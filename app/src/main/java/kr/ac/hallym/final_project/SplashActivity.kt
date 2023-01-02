package kr.ac.hallym.final_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.airbnb.lottie.LottieAnimationView
import kr.ac.hallym.final_project.databinding.ActivitySplashBinding
import kotlin.random.Random

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        //lottie 추가
        val splashImage=binding.splashImage as LottieAnimationView
        splashImage.playAnimation()
        
        //1~3초 사이 로티 재생
        Handler(Looper.getMainLooper()).postDelayed({
            val intent= Intent(this,CardView::class.java)
            startActivity(intent)
            finish()
        },1000L+ Random.nextLong(2000))
    }
}