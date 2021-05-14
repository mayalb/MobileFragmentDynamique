package com.example.exo4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        doctorsList.apply{
            doctorsList.layoutManager= LinearLayoutManager(activity)
            doctorsList.adapter = Adapter(context,loadData())
        }
    }
    fun loadData():List<Doctor> {
        val data = mutableListOf<Doctor>()
        data.add(Doctor(R.drawable.doc1,"Maya","Larbi","083743829","cardiologue",7))
        data.add(Doctor(R.drawable.doc2,"Safi","Rihani","083743829","generaliste",10))
        data.add(Doctor(R.drawable.doc5,"fatima","bz","0886789","Dentiste",9))
        data.add(Doctor(R.drawable.doc4,"Rayane","Larbi","083743829","Dentiste",8))
        data.add(Doctor(R.drawable.doc3,"Massi","Larbi","92878","cardiologue",12))
        data.add(Doctor(R.drawable.doct6,"Rima","Amirat","083743829","pediatre",15))
        data.add(Doctor(R.drawable.doc7,"Youcef","larbi","083743829","pediatre",8))
        data.add(Doctor(R.drawable.doc8,"Ghada","flissi","0837989","ophtalmologue",1))
        data.add(Doctor(R.drawable.doct6,"Naima","larbi","083743829","pediatre",7))
        data.add(Doctor(R.drawable.doct6,"Said","larbi","083743829","dentiste",6))

        return data
    }

}