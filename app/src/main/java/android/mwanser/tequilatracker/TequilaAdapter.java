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

public class TequilaAdapter extends ArrayAdapter<Tequila> {
    public TequilaAdapter(Context context, ArrayList<Tequila> tequilas) {
        super(context, 0, tequilas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Tequila tequila = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tequila_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tequilaName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tequilaType);
        TextView tvText = (TextView) convertView.findViewById(R.id.tequilaStars);
        // Populate the data into the tem"plate view using the data object
        tvName.setText(tequila.getName()+"  ");
        tvHome.setText(tequila.getType()+"  ");
        tvText.setText(String.valueOf(tequila.getStars()));
        // Return the completed view to render on screen
        return convertView;
    }
}