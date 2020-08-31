package net.inherency.example.core

import java.time.LocalTime

data class AddressDTO (
        var name: String = "",
        var description: String = "",
        var line1: String = "",
        var line2: String? = null,
        var basicZipCode: Int = 0
)

fun maybeMakeAddressDTO(inputTime: LocalTime): AddressDTO? {
    return if (inputTime.isBefore(LocalTime.NOON)) { //Yes, this should be injected!
        null
    } else {
        AddressDTO().apply {
            name = "name"
            description = "desc"
            line1 = "123 Ave. A"
            basicZipCode = 78717
        }
    }
}

fun demoScopeFunctions(): String? {
    return maybeMakeAddressDTO(LocalTime.now())?.let {
        "${it.name}::${it.description}"
    }.also {
        it?.run { println("Processed successfully") }
    }
}
