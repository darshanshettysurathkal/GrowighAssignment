package com.example.growigh
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

class MissionFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_mission, container, false)

        val nextArrow = view.findViewById<ImageView>(R.id.next_arrow_mission)
        nextArrow.setOnClickListener {
            (activity as MainActivity).openHomeActivity()
        }

        return view
    }
}
