package com.example.askballthesecond

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

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
        // альтернативный вариант
        // val imageButton = findViewById<ImageButton>(R.id.imageButton)
        // или val imageButton = findViewById(R.id.imageButton) as ImageButton


        imageButton.setOnClickListener {

            val answers = arrayOf("друг!", "чел!", "бро!", "пипл...")
            val randomAnswer = answers.random()

            val answers2 = arrayOf("оспи.", "поешь.", "надо подумать!", "а надо ли?", "тебе все по плечу!", "это все не то...", "а как надо?",
                "это тайна\nпокрытая макром!", "танцуй!", "включи Мозг!", "у мамы спроси.", "Плохо", "Думай", "Ага", "а как ты\nсама думаешь?")
            val randomAnswer2 = answers2.random()


            if (editText.text.isEmpty() or editText.text.endsWith("тут")){
                if (randomAnswer.equals("бро!") or randomAnswer.equals("чел!") ) {
                    mHelloTextView.text = "Дарова, " + randomAnswer
                    SystemClock.sleep(2000)
                   // mHelloTextView.text = "Включи мозг! "
                } else
                    mHelloTextView.text = "Привет! " + randomAnswer
            } else if (editText.text.equals("Алиса")) {
                mHelloTextView.text = "Hello! " + editText.text + ", доченька!"
            } else if (editText.text.equals("Маша")){
                mHelloTextView.text = "Ну привет, " + editText.text +"."
            } else {
                mHelloTextView.text = "Привет! " + editText.text
            }


            mAnswerView.text = randomAnswer2

            //SystemClock.sleep(5000)
//            return@setOnClickListener true
        }
    }
}

private fun ImageButton.setOnLongClickListener(function: (View) -> Unit) {

}
