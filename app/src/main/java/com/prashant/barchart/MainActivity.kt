package com.prashant.barchart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.prashant.barchart.databinding.ActivityMainBinding
/**
 * The MainActivity class is the main activity of the application.
 * It extends the AppCompatActivity class and is responsible for displaying the main UI of the app.
 */
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private var binding = _binding

    /**
     * Called when the activity is being created.
     * This is where you should initialize the activity and setContentView to the appropriate layout.
     *
     * @param savedInstanceState The saved instance state bundle containing the activity's previous state, if any.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using the ActivityMainBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // Create a list of BarModel objects representing bar graph data
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
            BarModel(barValue = 10, xAxisValue = "Dec")
        )

        // Set up the RecyclerView and attach the BarGraphAdapter
        binding?.rvBars?.apply {
            adapter = BarGraphAdapter(data, this@MainActivity)
        }

        // Set up the RecyclerView for horizontal bars and attach the BarGraphHorizontalAdapter
        binding?.rvHorizontalBars?.apply {
            adapter = BarGraphHorizontalAdapter(data, this@MainActivity)
        }
    }
}
