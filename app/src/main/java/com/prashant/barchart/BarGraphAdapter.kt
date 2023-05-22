package com.prashant.barchart

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.prashant.barchart.databinding.BarViewHorizontalBinding
import com.prashant.barchart.databinding.BarViewVerticalBinding

/**
 * BarGraphAdapter is an adapter class used for populating a RecyclerView with bar graph items.
 * @param list The list of BarModel objects representing the data for the bar graph.
 * @param activity The activity associated with the adapter.
 */
class BarGraphAdapter(private val list: List<BarModel>, val activity: Activity) :
    RecyclerView.Adapter<BarGraphAdapter.BarView>() {

    /**
     * BarView is a ViewHolder class representing a single item view in the RecyclerView.
     * @param binding The view binding object for the item view.
     */
    inner class BarView(val binding: BarViewVerticalBinding) :RecyclerView.ViewHolder(binding.root)

    /**
     * Called when RecyclerView needs a new BarView to represent an item.
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new instance of BarView representing the item view.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarView {
        val binding =
            BarViewVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BarView(binding)
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     * @param holder The BarView to bind the data to.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: BarView, position: Int) {
        with(holder.binding) {
            tvXAxis.text = list[position].xAxisValue
            tvBarValue.text = list[position].barValue.toString()
            progressHorizontal.setOnClickListener {
                clBarValue.visibility = VISIBLE
                Handler(Looper.getMainLooper()).postDelayed({
                    clBarValue.visibility = INVISIBLE
                }, 2000)
            }
            progressHorizontal.progress = list[position].barValue
            progressHorizontal.max = 100
            verticalView.visibility = VISIBLE.takeIf { position == 0 } ?: GONE
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     * @return The total number of items in the adapter.
     */
    override fun getItemCount() = list.size
}

/**
 * BarGraphHorizontalAdapter is an adapter class used for populating a RecyclerView with horizontal bar graph items.
 * @param barModelList The list of BarModel objects representing the data for the horizontal bar graph.
 * @param activity The activity associated with the adapter.
 */
class BarGraphHorizontalAdapter(
    private val barModelList: List<BarModel>, private val activity: Activity
) :RecyclerView.Adapter<BarGraphHorizontalAdapter.BarView>() {
    private var progressDrawable = ContextCompat.getDrawable(activity, R.drawable.custom_progress)

    /**
     * BarView is a ViewHolder class representing a single item view in the RecyclerView.
     * @param binding The view binding object for the item view.
     */
    inner class BarView(val binding: BarViewHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root)

    /**
     * Called when RecyclerView needs a new BarView to represent an item.
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new instance of BarView representing the item view.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarView {
        val binding =
            BarViewHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BarView(binding)
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     * @param holder The BarView to bind the data to.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: BarView, position: Int) {
        with(holder.binding) {
            tvXAxis.text = barModelList[position].xAxisValue
            progressHorizontal.progress = barModelList[position].barValue
            Log.e("TAG", "onBindViewHolder: ${barModelList[position].barValue}")
            progressHorizontal.max = 100
//            progressHorizontal.progressDrawable = progressDrawable
            bottomView.visibility = VISIBLE.takeIf { position == barModelList.size - 1 } ?: GONE
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     * @return The total number of items in the adapter.
     */
    override fun getItemCount() = barModelList.size

    /**
     * Sets the progress drawable for the horizontal bar graph.
     * @param progressDrawable The drawable used for the progress indicator.
     */
    fun setAttribute(
        progressDrawable: Drawable? = ContextCompat.getDrawable(
            activity, R.drawable.custom_progress
        )
    ) {
        this.progressDrawable = progressDrawable
    }
}

/**
 * An enum representing the orientation of a bar graph.
 */
enum class Orientation {
    HORIZONTAL, VERTICAL
}