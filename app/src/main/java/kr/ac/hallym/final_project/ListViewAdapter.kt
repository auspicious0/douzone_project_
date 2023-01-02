package kr.ac.hallym.final_project

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kr.ac.hallym.final_project.databinding.DecoMusicBinding

class ListViewAdapter(private val items: MutableList<ListViewItem>): BaseAdapter() {
    override fun getCount(): Int = items.size

    override fun getItem(position: Int): ListViewItem = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        var convertView = view
        if (convertView == null) convertView = LayoutInflater.from(parent?.context).inflate(R.layout.deco_music, parent, false)

        val item: ListViewItem = items[position]
        convertView!!.findViewById<ImageView>(R.id.image_title).setImageDrawable(item.icon)
        convertView.findViewById<TextView>(R.id.text_title).text = item.title
        convertView.findViewById<TextView>(R.id.text_sub_title).text = item.subTitle

        return convertView
    }
}