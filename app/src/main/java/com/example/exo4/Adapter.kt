package com.example.exo4

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import java.lang.NullPointerException

class Adapter(val context: Context, var data:List<Doctor>): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.doctor, parent, false))
    }

    override fun getItemCount()=data.size
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.img.setImageResource(data[position].img)
        holder.nom.text=data[position].name
        holder.prenom.text=data[position].prenom
        holder.num.text=data[position].phone
        holder.spec.text=data[position].specialite
        holder.imageView2.setOnClickListener { View->
            val longitude=-77.0364
            val latitude=38.89851
            val geolocation=Uri.parse("geo:$latitude,$longitude")
            val intent= Intent(Intent.ACTION_VIEW,geolocation)
            if(intent.resolveActivity(context.packageManager)!=null){
                context.startActivity(intent)
            }


        }
        holder.num.setOnClickListener {View->
            val numero= data[position].phone
            val uri = Uri.parse("tel:$numero")
            val intent = Intent(Intent.ACTION_DIAL, uri)
            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
        }}
        holder.itemView.setOnClickListener {  View->
            val prenom=data[position].prenom
            val nom=data[position].name
            val specialite =data[position].specialite
            val phone=data[position].phone
            val anneeExp=data[position].anneeExp
            val image =data[position].img
          //  val vm= ViewModelProvider(requireActivity()).get(Adapter::class.java)
            val bundle= bundleOf("img" to image,"nom" to nom, "prenom" to prenom , "specialite" to specialite , "phone" to phone ,"anneeExp" to anneeExp)
            View?.findNavController()?.navigate(R.id.action_mainFragment_to_detailFragment,bundle)
           // val intent= Intent(context,MainActivity2::class.java)
            //intent.putExtra("doctor",data[position])
           // context.startActivity(intent)




        }


    }

}
class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nom= view.findViewById<TextView>(R.id.textViewnom) as TextView
    val prenom= view.findViewById<TextView>(R.id.textViewprenom) as TextView
    val num= view.findViewById<TextView>(R.id.textViewphone) as TextView
    val spec= view.findViewById<TextView>(R.id.TextviewSpecialite) as TextView
    val img= view.findViewById<ImageView>(R.id.imageView) as ImageView
    val imageView2=view.findViewById<ImageView>(R.id.imageView2) as ImageView
   // val itemview=view.findViewById<MenuView.ItemView>(R.id.itemview) as MenuView.ItemView

}