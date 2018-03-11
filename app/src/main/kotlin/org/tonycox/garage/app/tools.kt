package org.tonycox.garage.app

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.slf4j.LoggerFactory

/**
 * @author Anton Solovev
 * @since 07.03.2018
 */
fun <T> loggerFor(clazz: Class<T>) = LoggerFactory.getLogger(clazz)

val mapper = ObjectMapper().registerModule(KotlinModule())