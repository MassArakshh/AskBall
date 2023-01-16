package com.example.askballthesecond

import android.annotation.SuppressLint
import android.content.Intent.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity : AppCompatActivity() {

    private lateinit var mHelloTextView: TextView
    private lateinit var mAnswerView: TextView
    private lateinit var editText: EditText

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editPersonName)
        mHelloTextView = findViewById(R.id.textView)
        mAnswerView = findViewById(R.id.textView3)



        var imageButton: ImageButton = findViewById(R.id.imageButton)
        var askButton: Button = findViewById(R.id.button)

        // альтернативный вариант
        // val imageButton = findViewById<ImageButton>(R.id.imageButton)
        // или val imageButton = findViewById(R.id.imageButton) as ImageButton

        askButton.setOnClickListener {
            askButton.text = "Думаю"
            val myAnswers = Answers()
            mAnswerView.text = myAnswers.choiseWisdomAnswer()
        }

        imageButton.setOnClickListener {
            val myClick = Fans()
            val myAnswers = Answers()
            mHelloTextView.text = myAnswers.choiseHelloAnswer(editText)
            myClick.bip2(applicationContext, R.raw.meu2)
            val message = "Привет! от " + mHelloTextView.text

            //myClick.sendToPhoneMassageWhatsApp(message, applicationContext, 79064295697)
            myClick.sendToEnyoneMessageAnyApp(message, applicationContext)
        }
    }
}

