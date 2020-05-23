package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import java.nio.file.Files.find

class RecyclerViewAdapter(private val context: Context):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    val items: MutableList<CharacterData> =mutableListOf()

    //リスナー格納変数
    lateinit var  listener: OnItemClickListener

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        //item_character_data_cell.xmlのidからcomponentの取得
        val charaImage: ImageView=view.findViewById(R.id.characterImageView)
        val charaNameTextView: TextView =view.findViewById(R.id.characterNameTextView)
        val codenameTextView: TextView=view.findViewById(R.id.codenameTextView)
        val charaDetailTextView:TextView=view.findViewById(R.id.descriptionTextView)

        //Layoutのholder
        //val container : ConstraintLayout = view.findViewById(R.id.itemLayoutLayor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_character_data_cell,parent, false)
        return ViewHolder(view)
    }

    //空のitems(mutableList)にデータ(chracterData)を全部追加
    fun addAll(items: List<CharacterData>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        //componentに、item(chracterData)の各メンバを格納
        holder.charaImage.setImageResource(item.characterImageResource)
        holder.charaNameTextView.text = item.characterName
        holder.codenameTextView.text = item.codeName
        holder.charaDetailTextView.text = item.description

        //
        holder.charaImage.setOnClickListener{
            listener.onItemClickListener(it,position,item.characterImageResource,item.characterName,item.codeName,item.description)
        }
    }

    //インターフェイスの作成
    interface OnItemClickListener{
        fun onItemClickListener(view:View,position: Int,characterImage:Int,characterName:String,codeName:String,description:String)
    }

    //リスナー
    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener=listener
    }

}




