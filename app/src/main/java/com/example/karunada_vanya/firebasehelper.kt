

package com.example.karunada_vanya

import com.google.firebase.database.FirebaseDatabase
import com.example.karunada_vanya.data.AlertData

class FirebaseHelper {

    private val database =
        FirebaseDatabase.getInstance()

    private val alertsRef =
        database.getReference("alerts")

    fun sendAlert(alert: AlertData) {

        val id = alertsRef.push().key

        if (id != null) {

            alertsRef.child(id)
                .setValue(alert)
        }
    }
}