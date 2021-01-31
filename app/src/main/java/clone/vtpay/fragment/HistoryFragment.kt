package clone.vtpay.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import clone.vtpay.R
import clone.vtpay.adapter.ItemArrayAdapter
import clone.vtpay.repository.HistoryItem
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.Charset


class HistoryFragment : Fragment () {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_history, container, false)
        val listView: ListView = view.findViewById(R.id.listView)
        var itemArrayAdapter: ItemArrayAdapter
//
        val inputStream: InputStream = resources.openRawResource(R.raw.data)
        val bufferReader = BufferedReader(
            InputStreamReader(inputStream, Charset.forName("UTF-8"))
        )
        var items: MutableList<HistoryItem> = ArrayList()
        val list = java.util.ArrayList<HistoryItem>()
        var line: String?
        while (bufferReader.readLine().also { line = it } != null) {
            val token = line!!.split(",");
            val sample = HistoryItem(token[2], token[3], token[4], token[5], token[1])
            items.add(sample)
            list.add(sample)

            Log.i("thang.nt1", "create: $sample")
        }
        itemArrayAdapter = ItemArrayAdapter(context!!.applicationContext, R.layout.history_item, list)
        val state = listView.onSaveInstanceState()
        listView.adapter = itemArrayAdapter
        listView.onRestoreInstanceState(state)

        return view
    }
}