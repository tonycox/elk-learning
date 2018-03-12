package org.tonycox.garage.flink

import java.util.Properties

import org.apache.flink.api.common.restartstrategy.RestartStrategies
import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.api.java.utils.ParameterTool
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.ObjectNode
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.connectors.kafka.{FlinkKafkaConsumer011, FlinkKafkaProducer011}
import org.apache.flink.streaming.util.serialization.JSONDeserializationSchema
import org.apache.kafka.clients.CommonClientConfigs

/**
	* @author Anton Solovev
	* @since 12.03.2018
	*/
object DriverSearcher {

	def main(args: Array[String]): Unit = {
		val bootstrap = ParameterTool.fromArgs(args).get("bootstrap-server", "localhost:9092")
		val outputTopic = ParameterTool.fromArgs(args).get("output-topic", "mirror")

		val topic: String = try {
			ParameterTool.fromArgs(args).get("input-topic")
		} catch {
			case _: Exception =>
				System.err.println("No topic specified. Please run 'DriverSearcher --input-topic <topic>'")
				return
		}

		val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
		env.enableCheckpointing(500)
		env.setRestartStrategy(RestartStrategies.fixedDelayRestart(1, 0))
		env.getConfig.disableSysoutLogging

		val schema = new JSONDeserializationSchema()

		val consProps = new Properties()
		consProps.setProperty(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, bootstrap)
		val prodProps = new Properties()
		prodProps.setProperty(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, bootstrap)

		env
			.addSource[ObjectNode](new FlinkKafkaConsumer011(topic, schema, consProps))
			.map(on => functi(on))
			.addSink(new FlinkKafkaProducer011(outputTopic, new SimpleStringSchema(), prodProps))

		env.execute()
	}

	def functi(on: ObjectNode): String = on.get("message").textValue()

}
