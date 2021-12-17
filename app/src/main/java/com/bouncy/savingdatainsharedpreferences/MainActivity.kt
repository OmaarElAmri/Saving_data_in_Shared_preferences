package com.bouncy.savingdatainsharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bouncy.savingdatainsharedpreferences.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        binding.btnSave.setOnClickListener(){
            val name = binding.txtName.text.toString()
            val age = binding.txtAge.text.toString()
            val isAdult = binding.checkBox.isChecked

            editor.apply(){
                putString("name", name)
                putString("age", age)
                putBoolean("isAdult", isAdult)
                apply()
            }
        }

        binding.btnLoad.setOnClickListener(){
            val name = sharedPref.getString("name",null)
            val age = sharedPref.getString("age", null)
            val isAdult = sharedPref.getBoolean("isAdult", false)

            binding.txtName.setText(name)
            binding.txtAge.setText(age.toString())
            binding.checkBox.isChecked = isAdult
        }
    }
}
