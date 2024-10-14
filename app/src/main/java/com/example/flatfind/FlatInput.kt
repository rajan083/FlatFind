package com.example.flatfind

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FlatInput : AppCompatActivity() {

    private lateinit var flatName: EditText
    private lateinit var flatLocation: EditText
    private lateinit var flatPrice: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flat_input)

        flatName = findViewById(R.id.flatName)
        flatLocation = findViewById(R.id.flatLocation)
        flatPrice = findViewById(R.id.flatPrice)

        val addFlatButton: Button = findViewById(R.id.addFlatButton)
        addFlatButton.setOnClickListener {
            addFlat()
        }
    }

    private fun addFlat() {
        val name = flatName.text.toString()
        val location = flatLocation.text.toString()
        val price = flatPrice.text.toString().toIntOrNull()

        // Logic to save flat details, e.g., to a database or API
        // For example, you could add it to a list and notify the adapter

        Toast.makeText(this, "Flat Added: $name, $location, $price", Toast.LENGTH_SHORT).show()
        finish() // Close the activity after adding
    }
}
