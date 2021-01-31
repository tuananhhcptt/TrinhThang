package clone.vtpay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import java.util.ArrayList;
import java.util.List;

import clone.vtpay.R;
import clone.vtpay.repository.HistoryItem;
@Deprecated
public class ItemArrayAdapter extends ArrayAdapter<HistoryItem> {
    private ArrayList<HistoryItem> historyList = new ArrayList();

    static class ItemViewHolder {
        AppCompatImageView mIcon;
        TextView mTvHeaderTitle;
        TextView mTvHeaderValue;
        TextView mTvContent;
        TextView mTvDate;
        TextView mTvStatus;
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
            viewHolder.mIcon=row.findViewById(R.id.icon);
            viewHolder.mTvHeaderTitle = (TextView) row.findViewById(R.id.tv_header_title);
            viewHolder.mTvHeaderValue = (TextView) row.findViewById(R.id.tv_header_value);
            viewHolder.mTvContent = (TextView) row.findViewById(R.id.tv_content);
            viewHolder.mTvDate = (TextView) row.findViewById(R.id.tv_date);
            viewHolder.mTvStatus = (TextView) row.findViewById(R.id.tv_status);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ItemViewHolder)row.getTag();
        }
        HistoryItem stat = getItem(position);
//        viewHolder.tradecode.setText(historyList.get(position).getTrade_code());
//        viewHolder.phatsinhno.setText(historyList.get(position).getPhatsinhno());
//        viewHolder.phatsinhco.setText(historyList.get(position).getPhatsinhco());
//        viewHolder.noidung.setText(historyList.get(position).getNoidung());
//        viewHolder.thoigian.setText(historyList.get(position).getThoigian());

        return row;
    }

}
