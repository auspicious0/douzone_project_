package kr.ac.hallym.final_project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kr.ac.hallym.final_project.databinding.ActivityCardViewBinding

class CardViewActivity : AppCompatActivity() {
    lateinit var binding:ActivityCardViewBinding
    lateinit var adapter:MyFragmentPagerAdapter
    var contents:MutableList<String>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding= ActivityCardViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ActionBarDrawerToggle 버튼 적용
        setSupportActionBar(binding.toolbar)
        //뒤로가기 버튼 추가
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val toogle = ActionBarDrawerToggle(this,binding.drawer,R.string.drawer_opened,R.string.drawer_closed)
        toogle.syncState()

        //drawer선택 리스터
        binding.mainDrawerView.setNavigationItemSelectedListener {
            Log.d("kkang","navigation item is clicked: ${it.title}")
            true
        }

        //뷰 페이저 어뎁터 적용
        adapter=MyFragmentPagerAdapter(this)
        binding.viewpager.adapter=adapter

        //아래와 같이 TabLayoutMediator를 만들어 TabLayout를 Viewpager2에 연결하고 첨부
        //각 텝의 이름 지정, 카드뷰 순서별로 설정
        TabLayoutMediator(binding.tabs,binding.viewpager){tab,position->
            if(position==0){
                tab.text="summary"
            }
            else if(position==1){
                tab.text="philosophy"
            }
            else if(position==2){
                tab.text="work_out"
            }
            else if(position==3){
                tab.text="music"
            }
            else if(position==4){
                tab.text="poem"
            }
            else if(position==5){
                tab.text="programming"
            }
        }.attach()
    }

    //메뉴 추가
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }
    //메뉴 선택시 기타 설정으로 이동
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_main_setting){
            val intent=Intent(this,SettingActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
    //초기화면으로 로그아웃
    override fun onSupportNavigateUp(): Boolean {
        Log.d("kkang","onSupportNavigateUp...")
        val intent= Intent(this,CardView::class.java)
        startActivity(intent)
        finish()
        onBackPressed()
        return super.onSupportNavigateUp()
    }


}
//프래그먼트 어뎁터
class MyFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity){
    var fragments:List<Fragment>
    init{
        fragments=listOf(OneFragment(),TwoFragment(),ThreeFragment(),FourFragment(),FiveFragment(),SixFragment())
    }


    override fun getItemCount(): Int =fragments.size
    override fun createFragment(position: Int): Fragment =fragments[position]
}
