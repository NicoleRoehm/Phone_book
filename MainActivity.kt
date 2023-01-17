package com.example.phone_book

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.phone_book.adapter.PhoneAdapter
import com.example.phone_book.data.Datasource
import com.example.phone_book.data.model.Contacts
import com.example.phone_book.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var phoneList: MutableList<Contacts>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val datasource = Datasource()
        val phoneList = datasource.getContactList()

        val phoneAdapter = PhoneAdapter(this, phoneList)

        binding.phoneRecycler.adapter = phoneAdapter

        binding.addButton.setOnClickListener {

            val name = binding.contactNametext.text.toString()
            val number = binding.phoneNumberTextedit.text.toString()

            if (!name.isNullOrEmpty()) {
                val newName = Contacts(name, number)
                phoneList.add(newName)
                phoneAdapter.notifyItemInserted(phoneList.lastIndex)


            }

        }

    }
}




