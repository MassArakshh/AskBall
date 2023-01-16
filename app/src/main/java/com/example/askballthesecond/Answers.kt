package com.example.askballthesecond

import android.widget.EditText

class Answers {

    private val ansHello = arrayOf("друг!", "чел!", "бро!", "пипл...")
    private val ansWisdom = arrayOf(
        "Поспи.",
        "Поешь.",
        "Надо подумать!",
        "А надо ли?",
        "Тебе все по плечу!",
        "Это все не то...",
        "А как надо?",
        "Это тайна\nпокрытая макром!",
        "Танцуй\nпока молодой!",
        "Включи Мозг!",
        "У мамы спроси.",
        "Плохо",
        "Думай",
        "Ага",
        "А как ты думаешь?"
    )

    fun choiseHelloAnswer(str: EditText): String {
        val answer: String
        val randomAnsHello = ansHello.random()

        if (str.text.isEmpty()) {
            if (randomAnsHello.equals("бро!") or (randomAnsHello == "чел!")) {
                answer = "Дарова, " + randomAnsHello
//                    SystemClock.sleep(2000)
            } else
                answer = "Привет, " + randomAnsHello
        } else if (str.text.contains("Алиса") or str.text.contains("Lis")) {
            answer = "Hello! " + str.text + ", доченька!"
        } else if (str.text.contains("Маша")) {
            answer = "Ну привет, " + str.text + "."
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