package org.tonycox.garage.user.api.model

import java.math.BigDecimal

class Money(val amount: BigDecimal,
            val currency: String)