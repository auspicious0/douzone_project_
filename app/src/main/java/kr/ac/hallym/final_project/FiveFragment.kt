package kr.ac.hallym.final_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.w
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class FiveFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        var myView=inflater.inflate(R.layout.fragment_five,container,false)
        var myImage=myView.findViewById<ImageView>(R.id.poems)
        myImage.setOnClickListener{
            val intent= Intent(activity,Poem::class.java)
            startActivity(intent)
        }
        return myView
        // Inflate the layout for this fragment
    }
}