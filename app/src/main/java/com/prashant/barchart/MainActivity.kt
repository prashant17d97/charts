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
            BarModel(barValue = 10, xAxisValue = "Mon"),
            BarModel(barValue = 20, xAxisValue = "Tue"),
            BarModel(barValue = 30, xAxisValue = "Wed"),
            BarModel(barValue = 40, xAxisValue = "Thu"),
            BarModel(barValue = 50, xAxisValue = "Fri"),
            BarModel(barValue = 60, xAxisValue = "Sat"),
            BarModel(barValue = 70, xAxisValue = "Sun"),
            //Months
            BarModel(barValue = 80, xAxisValue = "Jan"),
            BarModel(barValue = 90, xAxisValue = "Feb"),
            BarModel(barValue = 100, xAxisValue = "Mar"),
            BarModel(barValue = 90, xAxisValue = "Apr"),
            BarModel(barValue = 80, xAxisValue = "May"),
            BarModel(barValue = 70, xAxisValue = "Jun"),
            BarModel(barValue = 60, xAxisValue = "Jul"),
            BarModel(barValue = 50, xAxisValue = "Aug"),
            BarModel(barValue = 40, xAxisValue = "Sep"),
            BarModel(barValue = 30, xAxisValue = "Oct"),
            BarModel(barValue = 20, xAxisValue = "Nov"),
            BarModel(barValue = 10, xAxisValue = "Dec"),
        )

        binding?.rvBars?.apply {
            adapter = BarGraphAdapter(data, this@MainActivity)
        }
        binding?.rvHorizontalBars?.apply {
            adapter = BarGraphHorizontalAdapter(data, this@MainActivity)
        }
    }
}