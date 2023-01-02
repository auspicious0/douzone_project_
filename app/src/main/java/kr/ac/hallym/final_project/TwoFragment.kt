package kr.ac.hallym.final_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.motion.widget.MotionScene
import androidx.fragment.app.Fragment
import kr.ac.hallym.final_project.databinding.ActivityTwoFragmentBinding

class TwoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        var myView=inflater.inflate(R.layout.activity_two_fragment,container,false)
        var myImage=myView.findViewById<ImageView>(R.id.philosophy)
        myImage.setOnClickListener{
            val intent= Intent(activity,Phy::class.java)
            startActivity(intent)
        }
        return myView
        // Inflate the layout for this fragment
    }
}