package kr.ac.hallym.final_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kr.ac.hallym.final_project.databinding.ActivityPoemBinding
//뷰페이져2와 프래그먼트를 사용한 화면구성.
class Poem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding=ActivityPoemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabLayout=binding.tabs
        val viewPager=binding.viewpager
        //summary화면 구성시 사용했던 MyFragmentPagerAdapter에서 fragments 변수 수정 후 사용.
        var t1=MyFragmentPagerAdapter(this)
        t1.fragments= listOf(Poem1(),Poem2(),Poem3())
        viewPager.adapter=t1

        TabLayoutMediator(tabLayout,viewPager){ tab,position->
            tab.text="Poem${(position+1)}"
        }.attach()
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
