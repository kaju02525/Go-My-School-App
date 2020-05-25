package com.gomyschool.view.authentication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import com.gomyschool.R
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private val TAG = this::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

       // startActivity(Intent(this@SplashActivity, DashboardActivity::class.java))
        initAnimation()
        redirectView()
    }

    private fun initAnimation() {
        val topAnim=AnimationUtils.loadAnimation(this,R.anim.top_animation)
        val bottomAnim=AnimationUtils.loadAnimation(this,R.anim.bottom_animation)

        iv_logo.animation=topAnim
        tv_title.animation=bottomAnim
        tv_dec.animation=bottomAnim


    }

    private fun redirectView() {
      CoroutineScope(Dispatchers.Main).launch {
          delay(3500)
          val sharedIntent = Intent(this@SplashActivity, LoginActivity::class.java)
          val pair1 = Pair.create(iv_logo as View, "iv_logo")
       //   val pair2 = Pair.create(tv_title as View, "tv_title")
          val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@SplashActivity, pair1)
          startActivity(sharedIntent, options.toBundle())
          finish()
      }


    }


}
