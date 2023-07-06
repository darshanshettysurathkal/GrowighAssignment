package com.example.growigh

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

class AboutUsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_about_us, container, false)



        val nextarrow = view.findViewById<ImageView>(R.id.next_arrow_aboutUs)
        nextarrow.setOnClickListener {
            (activity as MainActivity).showVisionFragment()
        }

        return view
    }
}
