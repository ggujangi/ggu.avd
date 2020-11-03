package com.ggu.avd.ui.intro

import android.content.Intent
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.ggu.avd.MainActivity
import com.ggu.avd.R
import com.ggu.avd.databinding.ActivityIntroBinding
import com.ggu.avd.workers.DrawableDatabaseWorker
import java.util.concurrent.TimeUnit


class IntroActivity : AppCompatActivity() {

    override fun onResume() {
        super.onResume()
        val window: Window = window
        window.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) setDecorFitsSystemWindows(false)
            else {
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_IMMERSIVE or
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_FULLSCREEN
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityIntroBinding = DataBindingUtil.setContentView(this, R.layout.activity_intro)

        val avd: AnimatedVectorDrawable = binding.introIcon.drawable as AnimatedVectorDrawable

        val request = OneTimeWorkRequestBuilder<DrawableDatabaseWorker>().setInitialDelay(500, TimeUnit.MILLISECONDS).build()
        WorkManager.getInstance(this@IntroActivity).enqueue(request)

        WorkManager.getInstance(this@IntroActivity).getWorkInfoByIdLiveData(request.id)
                .observe(this, { info ->
                    if (info != null && info.state.isFinished) {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }
                })

        avd.start()
    }
}