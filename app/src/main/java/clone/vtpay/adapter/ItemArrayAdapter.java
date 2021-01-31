package clone.vtpay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import clone.vtpay.R;
import clone.vtpay.repository.HistoryItem;

public class ItemArrayAdapter extends ArrayAdapter<HistoryItem> {
    private ArrayList<HistoryItem> historyList = new ArrayList();

    static class ItemViewHolder {
        TextView tradecode;
        TextView phatsinhno;
        TextView phatsinhco;
        TextView noidung;
        TextView thoigian;
    }

    public ItemArrayAdapter(Context context, int textViewResourceId, ArrayList<HistoryItem> historyList) {
        super(context, textViewResourceId);
        this.historyList = historyList;
    }

    @Override
    public int getCount() {
        return this.historyList.size();
    }

    @Override
    public HistoryItem getItem(int index) {
        return (HistoryItem) this.historyList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ItemViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.history_item, parent, false);
            viewHolder = new ItemViewHolder();
            viewHolder.tradecode = (TextView) row.findViewById(R.id.trade_code);
            viewHolder.phatsinhno = (TextView) row.findViewById(R.id.phatsinhno);
            viewHolder.phatsinhco = (TextView) row.findViewById(R.id.phatsinhco);
            viewHolder.noidung = (TextView) row.findViewById(R.id.noidung);
            viewHolder.thoigian = (TextView) row.findViewById(R.id.thoigian);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ItemViewHolder)row.getTag();
        }
        HistoryItem stat = getItem(position);
        viewHolder.tradecode.setText(historyList.get(position).getTrade_code());
        viewHolder.phatsinhno.setText(historyList.get(position).getPhatsinhno());
        viewHolder.phatsinhco.setText(historyList.get(position).getPhatsinhco());
        viewHolder.noidung.setText(historyList.get(position).getNoidung());
        viewHolder.thoigian.setText(historyList.get(position).getThoigian());
        return row;
    }

}
