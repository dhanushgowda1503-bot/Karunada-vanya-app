package com.example.karunada_vanya.data

data class AlertData(

    val animal: String = "",

    val village: String = "",

    val location: String = "",

    val danger: String = "",

    val message: String = "",

    val timestamp: Long = System.currentTimeMillis()

)