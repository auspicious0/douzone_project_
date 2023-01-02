package kr.ac.hallym.final_project

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import kr.ac.hallym.final_project.databinding.ActivityAddBinding
import kr.ac.hallym.final_project.databinding.ActivityMusicBinding



class music : AppCompatActivity() {
    lateinit var binding: ActivityMusicBinding
    lateinit var adapter: ListViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val items = mutableListOf<ListViewItem>()

        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.shin)!!, "신해철", "필자와는 같은 본관을 가지고 있는 뮤지션으로 그가 생전에 열었던 공연에 한 번도 가지 못했던 것이 천추의 한이다." +
                " 그는 대학가요제 대상, '그대에게'로 대뷔해 일약 스타덤에 올랐고 '날아라 병아리', '민물장어의 꿈'등 수많은 히트곡을 만들었다." +
                "필자는 그의 곡 중 '그대에게'를 무대에서 선보인 적이 있으며 그의 노래 중 '내 마음 깊은 곳의 너'를 가장 좋아한다."))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.yb)!!, "yb", "나이가 들며 팽팽한 피부가 주름질 지 몰라도 윤도현의 목소리 만큼은 녹슬지 않는다." +
                "윤도현은 정톡파 락커로 당대 찾아 보기 힘든 보이스와 음악 실력을 선보였다." +
                "그의 음악프로 대뷔 무대에선 '타잔'이란 곡으로 기타를 튕기며 자유롭고 아름다운 락의 정수를 보여줬으며 긴 시간 수많은 히트곡과 함께 락의 대부로 자리매김 하고 있다." +
                "필자는 그의 곡중 '너를 보내고'를 무대에서 선보인 바 있다."))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.kim)!!, "김광석", "역사와 함께 젖어가는 시대의 시인인 김광석은 안타까운 사고로 사망하였지만 아직 수많은 이들의 가슴속에" +
                "살아 숨쉬고 있다. 그의 노래는 단 4장의 정규앨범이 전부지만 그의 시대를 관통하는 가사와 깊은 고독감을 노래하는 목소리에 남녀노소 막론하고" +
                "감동받곤 한다. 필자는 그의 노래중 '사랑했지만'을 무대에서 선보인 바 있다."))

        binding.listView.adapter=ListViewAdapter(items)

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

