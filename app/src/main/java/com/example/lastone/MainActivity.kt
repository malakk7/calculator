package com.example.lastone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val complaint : TextView = findViewById(R.id.TVcomplaint)
        complaint.setOnClickListener{
            var dialog_var = ComplaintFragment()
            dialog_var.show(supportFragmentManager, "Complaint Dialog")
        }

        val btn: Button = findViewById(R.id.compute)
        val resultTV: TextView = findViewById(R.id.result)
        val edtxt1: EditText = findViewById(R.id.num1)
        val edtxt2: EditText = findViewById(R.id.num2)
        val btn1: Button = findViewById(R.id.complaint)

        var flag: String = "Sum"
        val spinnerVal: Spinner = findViewById(R.id.sp1)
        var options = arrayOf("Sum", "Multiply", "Divide", "Subtract")
        spinnerVal.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        btn.setOnClickListener { view ->
            //code here
            var x: Int = edtxt1.text.toString().toInt();
            var y: Int = edtxt2.text.toString().toInt();
            if (flag == "Sum")
                resultTV.text = Sum(x, y).toString();
            else if (flag == "Multiply")
                resultTV.text = multiply(x, y).toString()
            else if (flag == "Subtract")
                resultTV.text = Subtract(x, y).toString();
            else
                resultTV.text = divide(x, y).toString();
        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.mymenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> Toast.makeText(this, "Standard selected", Toast.LENGTH_SHORT).show()
            R.id.item2 -> Toast.makeText(this, "Scientific selected", Toast.LENGTH_SHORT).show()
            R.id.item3 -> Toast.makeText(this, "Programmer selected", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }
}
public fun Sum(a: Int, b: Int): Int {
    return a+b
}
public fun multiply(a: Int, b: Int): Int {
    return a*b
}
public fun divide(a: Int, b: Int): Int {
    return b/a
}
public fun Subtract(a: Int, b: Int): Int {
    return b-a
}