package com.prashant.barchart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.prashant.barchart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private var binding = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val data = listOf(
            BarModel(value = 10, xAxisValue = "Mon"),
            BarModel(value = 20, xAxisValue = "Tue"),
            BarModel(value = 30, xAxisValue = "Wed"),
            BarModel(value = 40, xAxisValue = "Thu"),
            BarModel(value = 50, xAxisValue = "Fri"),
            BarModel(value = 60, xAxisValue = "Sat"),
            BarModel(value = 70, xAxisValue = "Sun"),
            //Months
            BarModel(value = 80, xAxisValue = "Jan"),
            BarModel(value = 90, xAxisValue = "Feb"),
            BarModel(value = 100, xAxisValue = "Mar"),
            BarModel(value = 90, xAxisValue = "Apr"),
            BarModel(value = 80, xAxisValue = "May"),
            BarModel(value = 70, xAxisValue = "Jun"),
            BarModel(value = 60, xAxisValue = "Jul"),
            BarModel(value = 50, xAxisValue = "Aug"),
            BarModel(value = 40, xAxisValue = "Sep"),
            BarModel(value = 30, xAxisValue = "Oct"),
            BarModel(value = 20, xAxisValue = "Nov"),
            BarModel(value = 10, xAxisValue = "Dec"),
        )

        binding?.rvBars?.apply {
            adapter = BarGraphAdapter(data, this@MainActivity)
        }
        binding?.rvHorizontalBars?.apply {
            adapter = BarGraphHorizontalAdapter(data, this@MainActivity)
        }
    }
}