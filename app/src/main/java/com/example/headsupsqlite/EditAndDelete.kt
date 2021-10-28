package com.example.headsupsqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class EditAndDelete : AppCompatActivity() {
    lateinit var dbhlr:DBHlr
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_and_delete)
        dbhlr = DBHlr(this)
        val name = findViewById<View>(R.id.edName1) as EditText
        val taboo1 = findViewById<View>(R.id.edTaboo11) as EditText
        val taboo2 = findViewById<View>(R.id.edTaboo21) as EditText
        val taboo3 = findViewById<View>(R.id.edTaboo31) as EditText

        val Nname = findViewById<View>(R.id.edNameNew) as EditText
        val Ntaboo1 = findViewById<View>(R.id.edTaboo1New) as EditText
        val Ntaboo2 = findViewById<View>(R.id.edTaboo2New) as EditText
        val Ntaboo3 = findViewById<View>(R.id.edTaboo3New) as EditText

        val btedit = findViewById<Button>(R.id.bteditCel)

        val Dname = findViewById<View>(R.id.edName2) as EditText
        val btdel = findViewById<Button>(R.id.btDel)
        val btBack = findViewById<Button>(R.id.btBack1)

        btedit.setOnClickListener {
            if(name.text.isEmpty()||taboo1.text.isEmpty()||taboo2.text.isEmpty()||taboo3.text.isEmpty()
                    || Nname.text.isEmpty()||Ntaboo1.text.isEmpty()||Ntaboo2.text.isEmpty()||Ntaboo3.text.isEmpty())
                Toast.makeText(this, "Fill all fields please", Toast.LENGTH_SHORT).show()
            else {
                dbhlr.update(name.text.toString(), taboo1.text.toString(), taboo2.text.toString(), taboo3.text.toString(), Nname.text.toString(), Ntaboo1.text.toString(), Ntaboo2.text.toString(), Ntaboo3.text.toString())
                name.setText("")
                taboo1.setText("")
                taboo2.setText("")
                taboo3.setText("")
                Nname.setText("")
                Ntaboo1.setText("")
                Ntaboo2.setText("")
                Ntaboo3.setText("")
                Toast.makeText(this, "update successfully", Toast.LENGTH_SHORT).show()
            }
        }
        btdel.setOnClickListener {
            if(Dname.text.isEmpty())
                Toast.makeText(this, "Fill the field please", Toast.LENGTH_SHORT).show()
            else {
                dbhlr.delete(Dname.text.toString())
                Dname.setText("")
                Toast.makeText(this, "deleted successfully", Toast.LENGTH_SHORT).show()
            }
        }
        btBack.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}