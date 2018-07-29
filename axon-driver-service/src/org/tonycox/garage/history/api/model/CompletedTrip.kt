package org.tonycox.garage.history.api.model

class CompletedTrip(val fullReport: Report,
                    val commentsOnTrip: List<CommentOnTrip>,
                    val commentOnPassenger: List<CommentOnPassenger>)