package com.kinan.pppb_tugas5_kinanthycahyaningrum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.kinan.pppb_tugas5_kinanthycahyaningrum.MainActivity.Companion.EXTRA_EMAIL
import com.kinan.pppb_tugas5_kinanthycahyaningrum.MainActivity.Companion.EXTRA_PHONE
import com.kinan.pppb_tugas5_kinanthycahyaningrum.MainActivity.Companion.EXTRA_USERNAME
import com.kinan.pppb_tugas5_kinanthycahyaningrum.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val username = intent.getStringExtra(EXTRA_USERNAME)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val phone = intent.getStringExtra(EXTRA_PHONE)


        with(binding){
            txtusername.text = username
            txtemail.text = email
            txtphone.text = phone

            btnLogout.setOnClickListener {
                setResult(RESULT_OK)
                finish()
            }
        }
    }



        }


