package com.example.flatfind

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RoommateInput : AppCompatActivity() {

    private lateinit var roommateName: EditText
    private lateinit var roommateContact: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roommate_input)

        roommateName = findViewById(R.id.roommateName)
        roommateContact = findViewById(R.id.roommateContact)

        val addRoommateButton: Button = findViewById(R.id.addRoommateButton)
        addRoommateButton.setOnClickListener {
            addRoommate()
        }
    }

    private fun addRoommate() {
        val name = roommateName.text.toString()
        val contact = roommateContact.text.toString()

        // Logic to save roommate details, e.g., to a database or API
        // For example, you could add it to a list and notify the adapter

        Toast.makeText(this, "Roommate Added: $name, $contact", Toast.LENGTH_SHORT).show()
        finish() // Close the activity after adding
    }
}
