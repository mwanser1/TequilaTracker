package android.mwanser.tequilatracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Wanser on 12/9/16.
 */

public class BarAdapter extends ArrayAdapter<Bar> {
    public BarAdapter(Context context, ArrayList<Bar> Bars) {
        super(context, 0, Bars);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Bar bar = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.bar_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.barName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.barType);
        TextView tvText = (TextView) convertView.findViewById(R.id.barStars);
        // Populate the data into the tem"plate view using the data object
        tvName.setText(bar.getName()+"  ");
        tvHome.setText(bar.getType()+"  ");
        tvText.setText(String.valueOf(bar.getStars()));
        // Return the completed view to render on screen
        return convertView;
    }
}