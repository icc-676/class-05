package com.abs.clase_05

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_RESULT = 1
    }


    var contactList = mutableListOf<Contact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contacts_recycler_view.adapter = ContactAdapter(contactList)
        contacts_recycler_view.layoutManager = LinearLayoutManager(this)

        createContactButton.setOnClickListener {
            startActivityForResult(CreateContactActivity.newInstance(this), REQUEST_RESULT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ( resultCode == Activity.RESULT_OK) {
            if (data != null) {
                data.apply {
                    val contact: Contact? = getParcelableExtra(CreateContactActivity.CONTACT)
                    contactList.add(contact!!)
                    contacts_recycler_view.adapter?.notifyDataSetChanged()
                }
            }
        }
    }
}

@Parcelize
data class Contact (val name:String, val lastName: String, val phone: String): Parcelable
