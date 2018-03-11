package org.tonycox.garage.app.event

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Anton Solovev
 * @since 3/6/2018.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class SearchMessage(
        @JsonProperty("id") val id: String,
        @JsonProperty("definition") val definition: String)
