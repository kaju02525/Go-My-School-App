package com.gomyschool.view.authentication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gomyschool.R
import com.gomyschool.view.home.DashboardActivity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btn_login.setOnClickListener {
            startActivity(Intent(this@LoginActivity,DashboardActivity::class.java))
        }
    }
}
