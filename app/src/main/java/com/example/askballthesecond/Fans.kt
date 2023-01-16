package com.example.askballthesecond

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.net.Uri
import android.widget.Toast

class Fans {
    fun bip2 (context: Context, sours: Int) {
        val mediaPlayer = MediaPlayer.create(context,  sours)
        mediaPlayer.start()
    }

    fun sendToPhoneMassageWhatsApp (message: String, context: Context, phone: Number) {
        try {
            val uri: Uri =
                Uri.parse("https://api.whatsapp.com/send?phone=" + phone.toString() + "&text=" + "gh")
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW // ACTION_SEND - не работает
            intent.data = uri
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            //intent.type = "text/plain"
            //intent.setPackage("com.whatsapp") // с ним не работает
            context.startActivity(intent)

        } catch (e: PackageManager.NameNotFoundException) {
            Toast.makeText(context, "Please install whatsapp first.", Toast.LENGTH_SHORT).show()
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context,"Error 1", Toast.LENGTH_SHORT).show()

        }

    }

    fun sendToEnyoneMessageAnyApp (message: String, context: Context){
        /* реализация по-проще
        try {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message);
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.type = "text/plain"
            context.startActivity(Intent.createChooser(intent, null)) // выбор App
            //intent.setPackage("com.whatsapp") // сразу в whatsapp
            //context.startActivity(intent)

        } catch (e: PackageManager.NameNotFoundException) {
            Toast.makeText(context, "Please install App first.", Toast.LENGTH_SHORT).show()
        }
        */
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, message)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            type = "text/plain"
        }
        context.startActivity(Intent.createChooser(sendIntent, null))
    }
}