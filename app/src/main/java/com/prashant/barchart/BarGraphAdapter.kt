package com.prashant.barchart

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View.*
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.prashant.barchart.databinding.BarViewHorizontalBinding
import com.prashant.barchart.databinding.BarViewVerticalBinding

class BarGraphAdapter(private val list: List<BarModel>, val activity: Activity) :
    RecyclerView.Adapter<BarGraphAdapter.BarView>() {

    inner class BarView(val binding: BarViewVerticalBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarView {
        val binding =
            BarViewVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BarView(binding)
    }

    override fun onBindViewHolder(holder: BarView, position: Int) {
        with(holder.binding) {
            tvXAxis.text = list[position].xAxisValue
            tvBarValue.text = list[position].value.toString()
            progressHorizontal.setOnClickListener {
                clBarValue.visibility = VISIBLE
                Handler(Looper.getMainLooper()).postDelayed({
                    clBarValue.visibility = INVISIBLE
                }, 2000)
            }
            progressHorizontal.progress = list[position].value
            progressHorizontal.max = 100
            verticalView.visibility = if (position == 0) {
                VISIBLE
            } else {
                GONE
            }

        }
    }

    override fun getItemCount() = list.size
}

class BarGraphHorizontalAdapter(
    private val barModelList: List<BarModel>, private val activity: Activity
) : RecyclerView.Adapter<BarGraphHorizontalAdapter.BarView>() {
    private var progressDrawable = ContextCompat.getDrawable(activity, R.drawable.custom_progress)

    inner class BarView(val binding: BarViewHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarView {
        val binding =
            BarViewHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BarView(binding)
    }

    override fun onBindViewHolder(holder: BarView, position: Int) {
        with(holder.binding) {
            tvXAxis.text = barModelList[position].xAxisValue
            progressHorizontal.progress = barModelList[position].value
            Log.e("TAG", "onBindViewHolder: ${barModelList[position].value}")
            progressHorizontal.max = 100
//            progressHorizontal.progressDrawable = progressDrawable
            bottomView.visibility = if (position == barModelList.size - 1) {
                VISIBLE
            } else {
                GONE
            }

        }
    }

    override fun getItemCount() = barModelList.size

    fun setAttribute(
        progressDrawable: Drawable? = ContextCompat.getDrawable(
            activity, R.drawable.custom_progress
        )
    ) {
        this.progressDrawable = progressDrawable
    }
}

enum class Orientation {
    HORIZONTAL, VERTICAL
}