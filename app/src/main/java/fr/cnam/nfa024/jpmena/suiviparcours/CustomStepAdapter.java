package fr.cnam.nfa024.jpmena.suiviparcours;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
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

        final CheckBox cbDone = (CheckBox) convertView.findViewById(R.id.checkbox_done);
        cbDone.setChecked(step.getmDone());
        // Populate the data into the template view using the data object
        //Do note populate with an Integer setText takes String
        //see https://stackoverflow.com/questions/26001780/android-content-res-resourcesnotfoundexception-string-resource-id-0x1-error
        tvFrom.setText(step.getmRoomFrom().toString());
        tvTo.setText(step.getmRoomTo().toString());

        Button action = (Button) convertView.findViewById(R.id.tvAction);
        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "From:"+tvFrom.getText().toString()+ " to: " + tvTo.getText().toString() + "By:" + step.getmDisplacment(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getContext(), StepActivity.class);
                intent.putExtra(MainActivity.STEP, step); //step must be serializable
                ((Activity)getContext()).startActivityForResult(intent, MainActivity.REQUEST_CODE); //thanks to answer 62 of https://stackoverflow.com/questions/2848775/use-startactivityforresult-from-non-activity
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }
}
