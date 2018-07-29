package org.tonycox.garage.user.api.model

data class StopLocation(val geoPoint: GeoPoint,
                        val localName: String)