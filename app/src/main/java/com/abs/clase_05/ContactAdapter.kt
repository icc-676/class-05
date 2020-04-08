package com.abs.clase_05

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_cell.view.*

class ContactAdapter(private val contacts: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_cell,
            parent, false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentItem = contacts[position]
        holder.bindUser(currentItem)
    }

    override fun getItemCount() = contacts.size

    class ContactViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        private var contact: Contact? = null

        init { }

        fun bindUser(contact: Contact) {
            this.contact = contact
            view.nameTextView.text = contact.name
            view.lastNameTextView.text = contact.lastName
            view.phoneTextView.text = contact.phone
            view.setOnClickListener {
                Toast.makeText(it.context, contact.name + "" + contact.lastName,10).show()
            }
        }

    }
}