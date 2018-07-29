package org.tonycox.garage.driver.api.model

data class StopLocation(val geoPoint: GeoPoint,
                        val localName: String)