package org.tonycox.garage.driver.api.model

class Route(val points: List<GeoPoint>,
            val stops: List<StopLocation>)