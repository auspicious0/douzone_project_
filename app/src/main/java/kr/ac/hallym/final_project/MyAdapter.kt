package kr.ac.hallym.final_project

import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.utils.MiscUtils.contains
import kr.ac.hallym.final_project.databinding.ItemRecyclerviewBinding
//항목 뷰를 가지는 역할
class MyViewHolder(val binding: ItemRecyclerviewBinding):RecyclerView.ViewHolder(binding.root)

// 항목 구성자: 어뎁터
class MyAdapter(val contents:MutableList<String>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    //항목 뷰를 가지는 뷰 홀더를 준비하기 위해 자동 호출
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),
            parent,false))

    //각 항목을 구성하기 위해 호출
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding=(holder as MyViewHolder).binding
        binding.itemData.text=contents[position]
    }
    //항목 개수 판단하기 위해 자동 호출
    override fun getItemCount(): Int {
        return contents.size
    }
}

// 리사이클러 뷰 꾸미기
class MyDecoration(val context: Context):RecyclerView.ItemDecoration(){
    //각 항목을 꾸미기 위해 호출
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val index = parent.getChildAdapterPosition(view)+1
        if(index%3==0)
            outRect.set(10,10,10,60)
        else
            outRect.set(10,10,10,0)
        view.setBackgroundColor(Color.parseColor("#28a0ff"))
        ViewCompat.setElevation(view,20.0f)
    }
}
