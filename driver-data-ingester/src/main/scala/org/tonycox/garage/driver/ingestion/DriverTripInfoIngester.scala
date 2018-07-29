package org.tonycox.garage.driver.ingestion

import java.time.LocalTime
import java.util.Properties

import org.apache.flink.api.common.restartstrategy.RestartStrategies
import org.apache.flink.api.java.utils.ParameterTool
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.ObjectNode
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011
import org.apache.flink.streaming.util.serialization.JSONDeserializationSchema
import org.apache.kafka.clients.CommonClientConfigs

import scala.collection.JavaConverters._

/**
	* @author Anton Solovev
	* @since 17.03.2018
	*/
object DriverTripInfoIngester {
	def main(args: Array[String]): Unit = {
		val bootstrap = ParameterTool.fromArgs(args).get("bootstrap-server", "localhost:9092")
		val output = ParameterTool.fromArgs(args).get("", "")

		val inputTopic: String = try {
			ParameterTool.fromArgs(args).get("input-topic")
		} catch {
			case _: Exception =>
				System.err.println("No topic specified. Please run 'DriverTripInfoIngester --input-topic <topic>'")
				return
		}

		val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
		env.enableCheckpointing(500)
		env.setRestartStrategy(RestartStrategies.fixedDelayRestart(1, 0))
		env.getConfig.disableSysoutLogging

		val schema = new JSONDeserializationSchema()

		val consumerProps = new Properties()
		consumerProps.setProperty(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, bootstrap)
		val producerProps = new Properties()
		producerProps.setProperty(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, bootstrap)

		env
			.addSource[ObjectNode](new FlinkKafkaConsumer011(inputTopic, schema, consumerProps))
			.map(json => toTripInfo(json))
//			manipulation
//			.addSink(/* sink to redis storage */)

		env.execute()
	}

	def toTripInfo(json: ObjectNode): TripInfo = {
		val driverId = json.get("driverId").asLong()
		val departureTime = LocalTime.parse(json.get("departureTime").textValue())
		val arriveTime = LocalTime.parse(json.get("arriveTime").textValue())
		val path = json.get("path").elements().asScala
			.map(node => node.textValue()).toList
		new TripInfo(driverId, path, departureTime, arriveTime)
	}

}
