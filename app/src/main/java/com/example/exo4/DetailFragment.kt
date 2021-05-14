package com.example.exo4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

       val img = arguments?.getInt("img")

        if (img != null) {
            image2.setImageResource(img)
        }
        nom2.text= arguments?.get("nom").toString()
        prenom2.text= arguments?.get("prenom").toString()
        specialite2.text= arguments?.get("specialite").toString()
        val exp=arguments?.get("anneeExp").toString()
        anneeExp.text= "Expérience : $exp"

        this.num.text=arguments?.get("phone").toString()
        lienFb.setOnClickListener { View->
            val url ="https://www.facebook.com/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)


        }




    }


}