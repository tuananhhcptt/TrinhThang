package clone.vtpay.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import clone.vtpay.R
import clone.vtpay.adapter.HistoryAdapter.ViewHolder
import clone.vtpay.repository.HistoryItem
import java.util.*
import kotlin.collections.ArrayList

class HistoryAdapter(val onItemClick: ((HistoryItem) -> (Unit))?) :
    RecyclerView.Adapter<ViewHolder>() {
    val TAG = "HistoryAdapter"
    private val dataSet = ArrayList<HistoryItem>()

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var mIcon: AppCompatImageView? = null
        var mTvHeaderTitle: TextView? = null
        var mTvHeaderValue: TextView? = null
        var mTvContent: TextView? = null
        var mTvDate: TextView? = null
        var mTvStatus: TextView? = null

        init {
            // Define click listener for the ViewHolder's View.
            mIcon = view.findViewById(R.id.icon)
            mTvHeaderTitle = view.findViewById(R.id.tv_header_title)
            mTvHeaderValue =
                view.findViewById(R.id.tv_header_value)
            mTvContent =
                view.findViewById(R.id.tv_content)
            mTvDate = view.findViewById(R.id.tv_date)
            mTvStatus = view.findViewById(R.id.tv_status)
            view.findViewById<LinearLayout>(R.id.root).setOnClickListener {
                onItemClick?.invoke(dataSet[adapterPosition])
            }

        }
    }

    fun setData(data: List<HistoryItem>) {
        this.dataSet.clear()
        this.dataSet.addAll(data)
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.history_item, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        var item = dataSet[position]
        var context = viewHolder.itemView.context
        Log.d(TAG, "onBindViewHolder: " + item.iconDrawable)
        viewHolder.apply {
            var drawable =
                context.resources.getIdentifier(
                    item.iconDrawable ?: "icon_34",
                    "drawable",
                    context.packageName
                )
            mIcon?.setImageDrawable(context.getDrawable(drawable))
            mTvHeaderValue?.text = item.money

            var nd = item.noidung

            mTvDate?.text = item.thoigian
            if ("03".equals(item.type)) {
                nd = item.noidung.substring(3)
            } else if (item.noidung.startsWith("01:") || item.noidung.startsWith("02:") ) {
                nd = item.noidung.substring(3)
            } else if (item.noidung.startsWith("01") || item.noidung.startsWith("02") ) {
                nd = item.noidung.substring(2)
            }

            if (item.isIsluong) {
                mTvHeaderTitle?.text = "Lương"
                item.randomPhoneNumber = "Lương"
            } else {
                val rd = randomPhoneNumber()
                mTvHeaderTitle?.text = rd
                item.randomPhoneNumber = rd
            }

            mTvContent?.text = item.noidung
        }
    }

    fun randomPhoneNumber() : String{
        val random = Random()
        val x: Int = random.nextInt(9000) + 1000
        val y: Int = random.nextInt(9000) + 1000

        var arr = arrayOf<String>("03", "09")
        val index = random.nextInt(2)

        return arr[index] + x + "" + y
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
