package fr.cnam.nfa024.jpmena.suiviparcours;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import fr.cnam.nfa024.jpmena.suiviparcours.bean.Step;

public class CustomStepAdapter extends ArrayAdapter<Step> {
    public CustomStepAdapter(Context context, ArrayList<Step> steps) {
        super(context, 0, steps);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_step, parent, false);
        }

        // Get the data item for this position
        final Step step = getItem(position);

        // Lookup view for data population
        final TextView tvFrom = (TextView) convertView.findViewById(R.id.tvFrom);
        final TextView tvTo = (TextView) convertView.findViewById(R.id.tvTo);
        // Populate the data into the template view using the data object
        //Do note populate with an Integer setText takes String
        //see https://stackoverflow.com/questions/26001780/android-content-res-resourcesnotfoundexception-string-resource-id-0x1-error
        tvFrom.setText(step.getRoomFrom().toString());
        tvTo.setText(step.getRoomTo().toString());

        Button action = (Button) convertView.findViewById(R.id.tvAction);
        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "From:"+tvFrom.getText().toString()+ " to: " + tvTo.getText().toString() + "By:" + step.getDisplacment(), Toast.LENGTH_LONG).show();
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }
}
