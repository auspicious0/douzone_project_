package kr.ac.hallym.final_project

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.final_project.databinding.ActivityOneFragmentBinding
import kr.ac.hallym.final_project.databinding.ActivityWorkoutBinding

class workout : AppCompatActivity() {
    lateinit var adapter: MyAdapter
    var contents: MutableList<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contents = mutableListOf<String>()
        val db = DBHelper(this).readableDatabase
        val cursor = db.rawQuery("select*from TODO_TB", null)
        cursor.run {
            while (moveToNext()) {
                contents?.add(cursor.getString(1))
            }
        }
        db.close()
        binding.mainFab.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            requestLauncher.launch(intent)
        }
        //뒤로가기 버튼 추가
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//리사이클러 뷰에 LayoutManager, Adapter, ItemDecoration 적용
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerview.layoutManager = layoutManager
        adapter = MyAdapter(contents!!)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.addItemDecoration(MyDecoration(this))

    }

    private val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        it.data?.let { intent ->
            intent.getStringExtra("result")?.let {
                contents?.add(it)
                adapter?.notifyDataSetChanged()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
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

