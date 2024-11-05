package com.example.listview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lvMain)
        val names = arrayOf("Valera", "Masha", "Stas", "Vanya", "Sergey", "Nazar")

        val arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, names)

        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectItem = names[position]
            Toast.makeText(this, "Это: $selectItem", Toast.LENGTH_SHORT).show()
        }

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}