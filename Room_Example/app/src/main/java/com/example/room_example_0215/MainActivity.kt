package com.example.room_example_0215

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initActivity()

        addBtn.setOnClickListener {
            add()
        }

        deleteBtn.setOnClickListener {
            delete()
        }
    }


    private fun initActivity() {
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "historyDB"
        ).build()
        getAll()
    }

    private fun add() {
        val nameText = et.text.toString()
        Thread(Runnable {
            db.historyDao().insertHistory(History(null, nameText))
            getAll()
        }).start()
    }

    private fun delete() {
        Thread(Runnable {
            db.historyDao().deleteAll()
            runOnUiThread {
                tv.text = ""
            }
        }).start()
    }

    private fun getAll() {
        Thread(Runnable {
            runOnUiThread {
                tv.text = ""
            }
            db.historyDao().getAll().forEach {
                runOnUiThread {
                    tv.text = tv.text.toString() + it.name.toString()
                }
            }
        }).start()
    }

}