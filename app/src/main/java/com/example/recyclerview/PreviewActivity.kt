package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        val imageId = intent.getIntExtra("image",0)
        val charaName=intent.getStringExtra("name")
        val codeName=intent.getStringExtra("code")
        val description=intent.getStringExtra("description")

        previewImage.setImageResource(imageId)
        previewCharaNameText.text = charaName
        previewCodenameText.text = codeName
        previewDescriptionText.text = description

        backButton.setOnClickListener{
            finish()
        }
    }
}
