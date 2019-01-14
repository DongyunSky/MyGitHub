package `fun`.chaoxi.wing.module.lab

import `fun`.chaoxi.wing.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab_kotlin.*
import org.jetbrains.anko.onClick

/**
 * @author Wing Gao
 * @date 2019/1/2 9:20
 * @description
 */
class FirstKotlin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab_kotlin)

        kotlin_text.onClick {
            when (kotlin_text.text.toString()) {
                "kotlin" -> kotlin_text.text = "java"
                "java" -> kotlin_text.text = "kotlin"
                else -> kotlin_text.text = "kotlin"
            }
        }

    }
}
