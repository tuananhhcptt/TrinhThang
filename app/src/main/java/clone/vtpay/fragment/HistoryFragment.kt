package clone.vtpay.fragment

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import clone.vtpay.R
import clone.vtpay.adapter.HistoryAdapter
import clone.vtpay.adapter.ItemArrayAdapter
import clone.vtpay.repository.HistoryItem
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.Charset


class HistoryFragment : Fragment() {
    val TAG="HistoryFragment"
    lateinit var itemArrayAdapter: HistoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_history, container, false)
        val listView: RecyclerView = view.findViewById(R.id.rv_history)

//
        itemArrayAdapter = HistoryAdapter()
        listView.layoutManager = LinearLayoutManager(context)
        listView.adapter = itemArrayAdapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LoadTextAsync().execute()
    }

    inner class LoadTextAsync : AsyncTask<Void, Void, List<HistoryItem>>() {
        override fun doInBackground(vararg params: Void?): List<HistoryItem> {

            val inputStream: InputStream = resources.openRawResource(R.raw.data)
            val bufferReader = BufferedReader(
                InputStreamReader(inputStream, Charset.forName("UTF-8"))
            )
            val list = ArrayList<HistoryItem>()
            var line: String?
            while (bufferReader.readLine().also { line = it } != null) {
                Log.d(TAG, "doInBackground: "+line)
                val token = line!!.split(",");
                val sample = HistoryItem(token[1]?:"", token[2]?:"", token[3]?:"", token[4]?:"", token[5]?:"")
                list.add(sample)

                Log.i("thang.nt1", "create: $sample")
            }
            return list
        }

        override fun onPostExecute(result: List<HistoryItem>) {
            super.onPostExecute(result)
            itemArrayAdapter.setData(result)
        }

    }
}