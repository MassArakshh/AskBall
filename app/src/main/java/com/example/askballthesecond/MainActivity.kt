package com.example.askballthesecond

import android.content.Context
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView


class Fans {
    fun bip2 (context: Context, sours: Int) {
        var mediaPlayer = MediaPlayer.create(context,  sours)
        mediaPlayer.start()
    }
}

class Answers {

    val ansHello = arrayOf("друг!", "чел!", "бро!", "пипл...")
    val ansWisdom = arrayOf("Поспи.", "Поешь.", "Надо подумать!", "А надо ли?", "Тебе все по плечу!", "Это все не то...", "А как надо?",
        "Это тайна\nпокрытая макром!", "Танцуй\nпока молодой!", "Включи Мозг!", "У мамы спроси.", "Плохо", "Думай", "Ага", "А как ты думаешь?")

    fun choiseHelloAnswer (str: EditText): String {
        val answer: String
        val randomAnsHello = ansHello.random()

        if ( str.text.isEmpty()){
            if (randomAnsHello.equals("бро!") or randomAnsHello.equals("чел!") ) {
                answer = "Дарова, " + randomAnsHello
//                    SystemClock.sleep(2000)
            } else
                answer = "Привет, " + randomAnsHello
        } else if (str.text.contains("Алиса") or str.text.contains("Lis")) {
            answer = "Hello! " + str.text + ", доченька!"
        } else if (str.text.contains("Маша")){
            answer = "Ну привет, " + str.text +"."
        } else {
            answer = "Привет! " + str.text
        }
        return answer
    }

    fun choiseWisdomAnswer (): String {
        val answer: String
        val randomAnsWisdom = ansWisdom.random()
        answer = randomAnsWisdom
        return answer
    }

}

class MainActivity : AppCompatActivity() {

    private lateinit var mHelloTextView: TextView
    private lateinit var mAnswerView: TextView
    private lateinit var editText: EditText

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
            askButton.setText("Думаю")
            val myAnswers = Answers()
            mAnswerView.text = myAnswers.choiseWisdomAnswer()
        }

        imageButton.setOnClickListener {
            val myBip = Fans()
            val myAnswers = Answers()
            mHelloTextView.text = myAnswers.choiseHelloAnswer(editText)
            myBip.bip2(applicationContext, R.raw.meu2)
        }


    }
}

