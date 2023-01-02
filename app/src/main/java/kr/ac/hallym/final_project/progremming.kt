package kr.ac.hallym.final_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class progremming : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progremming)
        //뒤로가기 버튼 추가
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    //선택 화면으로 로그아웃
    override fun onSupportNavigateUp(): Boolean {
        Log.d("kkang","onSupportNavigateUp...")
        val intent= Intent(this,CardView::class.java)
        startActivity(intent)
        finish()
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
