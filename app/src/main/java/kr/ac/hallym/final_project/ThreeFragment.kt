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

class ThreeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        var myView=inflater.inflate(R.layout.activity_three_fragment,container,false)
        var myImage=myView.findViewById<ImageView>(R.id.workout)
        myImage.setOnClickListener{
            val intent= Intent(activity,workout::class.java)
            startActivity(intent)
        }
        return myView
        // Inflate the layout for this fragment
    }
}