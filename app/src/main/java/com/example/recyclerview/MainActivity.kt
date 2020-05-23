package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_character_data_cell.*

class MainActivity : AppCompatActivity() {

    val characterData: List<CharacterData> = listOf(
        CharacterData(R.drawable.korosensei, "殺せんせー","バカなるエロのチキンのタコ","月を破壊した超生物。その正体はかつて「死神」と呼ばれた暗殺者の実験後の姿…"),
        CharacterData(R.drawable.shiota, "潮田渚","性別","一見おとなしそうな見た目の男子だが、訓練を受けるにつれ暗殺の才能に目覚めてゆく…"),
        CharacterData(R.drawable.kayano, "茅野カエデ","永遠のゼロ","一見どこにでもいる女の子だが、その正体は触手をはやしながらもその苦痛に耐え抜く元天才子役…"),
        CharacterData(R.drawable.akabane, "赤羽業","中二半","自由奔放でプライドが高いが天才的な頭脳と戦闘の才能を併せ持つ…"),
        CharacterData(R.drawable.nakamura, "中村莉桜","英語ギャル","もともと優等生だったが、素行不良を繰り返してるうちに本当にE組へ。実は想い人があの人で…"),
        CharacterData(R.drawable.isogai, "磯貝悠馬","貧乏委員","実家が貧乏以外非の打ち所がない委員長。クラスメイトからの信頼も厚い"),
        CharacterData(R.drawable.kanzaki, "神崎有希子","神崎名人","優等生の自分に嫌気がさし、服装を変えて遊びに出かけたりするゲームの達人"),
        CharacterData(R.drawable.terasaka, "寺坂竜馬","鷹岡もどき","授業態度が悪く、悪の道に染まりがちだが根は仲間想いのいい奴"),
        CharacterData(R.drawable.horibe, "堀部糸成","コロコロ上がり","触手を植えられた転校生。電子工作が得意。"),
        CharacterData(R.drawable.karasuma, "烏間惟臣","性別","防衛省のエリート。椚が丘中学3-E組に超生物の暗殺を依頼に来る。"),
        CharacterData(R.drawable.bitch, "イリーナ・イェラビッチ","ビッチビチ","ハニートラップでは世界で右に出る者がいない暗殺者。3-Eの生徒や烏間との出会いで彼女に変化が…")
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = RecyclerViewAdapter(this)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=adapter
        adapter.addAll(characterData)

        val preview = Intent(this,PreviewActivity::class.java)

        //インターフェースの実装
        adapter.setOnItemClickListener(object:RecyclerViewAdapter.OnItemClickListener{
            override fun onItemClickListener(view: View,position:Int,characterImage:Int,characterName:String,codeName:String,description:String){
                //クリック時処理
                preview.putExtra("image",characterImage)
                preview.putExtra("name",characterName)
                preview.putExtra("code",codeName)
                preview.putExtra("description",description)
                startActivity(preview)
                //Toast.makeText(applicationContext, "${characterName}がタップされました。コードネームは${codeName}で、以下説明です。★${description}★", Toast.LENGTH_LONG).show()
            }
        })


    }
}
