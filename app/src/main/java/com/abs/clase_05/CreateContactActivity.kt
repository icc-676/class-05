package com.abs.clase_05

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_contact.*

class CreateContactActivity : AppCompatActivity() {

    companion object {
        const val  CONTACT = "CONTACT"
        fun newInstance(context: Context) = Intent(context, CreateContactActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_contact)
    }

    fun createContact(view: View) {
        val contact = Contact(nameText.text.toString(),lastNameText.text.toString(),phoneText.text.toString())
        val data = Intent().apply {
            putExtra(CONTACT,contact)
        }
        setResult(Activity.RESULT_OK,data)
        finish()
    }
}
