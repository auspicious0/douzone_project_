package kr.ac.hallym.final_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.hallym.final_project.databinding.ActivityCardView2Binding

class CardView : AppCompatActivity() {
    lateinit var binding:ActivityCardView2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCardView2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        //각 주제 선택시 화면 이동
        //신준철 선택시 화면 이동
        binding.sjc.setOnClickListener{
            val intent= Intent(this,CardViewActivity::class.java)
            startActivity(intent)
            finish()
        }
        //poem 선택시 화면이동.
        binding.poem.setOnClickListener{
            val intent= Intent(this,Poem::class.java)
            startActivity(intent)
            finish()
        }
        binding.phy.setOnClickListener{
            val intent= Intent(this,Phy::class.java)
            startActivity(intent)
            finish()
        }
        binding.workOut.setOnClickListener{
            val intent= Intent(this,workout::class.java)
            startActivity(intent)
            finish()
        }
        binding.music.setOnClickListener{
            val intent= Intent(this,music::class.java)
            startActivity(intent)
            finish()
        }
        binding.progremming.setOnClickListener{
            val intent= Intent(this,progremming::class.java)
            startActivity(intent)
            finish()
        }
        //뒤로 가기 버튼 추가
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    //초기화면으로 로그아웃
    override fun onSupportNavigateUp(): Boolean {
        Log.d("kkang","onSupportNavigateUp...")
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}