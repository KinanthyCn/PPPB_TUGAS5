package com.kinan.pppb_tugas5_kinanthycahyaningrum

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.kinan.pppb_tugas5_kinanthycahyaningrum.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result -> if (result.resultCode == Activity.RESULT_OK){
            with(binding) {
                loginUsername.text.clear()
                loginEmail.text.clear()
                loginPhone.text.clear()
                loginPassword.text.clear()
                rectangle.isChecked = false


                }
            }
        }



    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
        const val EXTRA_PASSWORD = "extra_password"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            btnLogin.setOnClickListener {
                if (EXTRA_USERNAME.isEmpty() || EXTRA_EMAIL.isEmpty() || EXTRA_PHONE.isEmpty() || EXTRA_PASSWORD.isEmpty() || !rectangle.isChecked) {
                    Toast.makeText(
                        this@MainActivity,
                        "login failed, please fill in the form and agree to our ToC",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val intentToSecondActivity =
                        Intent(this@MainActivity, SecondActivity::class.java)
                    val username = loginUsername.text.toString()
                    intentToSecondActivity.putExtra(EXTRA_USERNAME, username)

                    val email = loginEmail.text.toString()
                    intentToSecondActivity.putExtra(EXTRA_EMAIL, email)

                    val phone = loginPhone.text.toString()
                    intentToSecondActivity.putExtra(EXTRA_PHONE, phone)

                    val password = loginPassword.text.toString()
                    intentToSecondActivity.putExtra(EXTRA_PASSWORD, password)

                    launcher.launch(intentToSecondActivity)
                }
            }
        }
    }

    fun login_() {
        val intentObj = Intent(Intent.ACTION_VIEW)
        intentObj.data = Uri.parse("https://youtu.be/dQw4w9WgXcQ?feature=shared")
        startActivity(intentObj)

    }


    fun terms_(view: View) {
        val intentObj = Intent(Intent.ACTION_VIEW)
        intentObj.data = Uri.parse("https://youtu.be/dQw4w9WgXcQ?feature=shared")
        startActivity(intentObj)
    }

    fun conditions_(view: View) {
        val intentObj = Intent(Intent.ACTION_VIEW)
        intentObj.data = Uri.parse("https://youtu.be/dQw4w9WgXcQ?feature=shared")
        startActivity(intentObj)
    }
}