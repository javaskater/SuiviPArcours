package fr.cnam.nfa024.jpmena.suiviparcours;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fr.cnam.nfa024.jpmena.suiviparcours.bean.Step;

public class MainActivity extends AppCompatActivity {

    public final static String STEP = "Step";

    public  final static int REQUEST_CODE = 1;

    private ArrayList<Step> mArrayOfSteps;

    private CustomStepAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mArrayOfSteps = Step.loadSteps();

        // Create the adapter to convert the array to views
        mAdapter = new CustomStepAdapter(this, mArrayOfSteps);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lvSteps);
        listView.setAdapter(mAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == REQUEST_CODE ) {
                 Step returnedStep = (Step)data.getSerializableExtra(STEP);
                 Toast.makeText(this, "Step from" +returnedStep.getmRoomFrom()+ " to " +returnedStep.getmRoomTo()+ " successfully done", Toast.LENGTH_LONG).show();
                 for (Step oneStep:mArrayOfSteps){
                     if (oneStep.equals(returnedStep)){
                         oneStep.setmDone(new Boolean(true));
                         mAdapter.notifyDataSetChanged();
                         break;
                     }
                 }
            }
        } catch (Exception ex) {
            Toast.makeText(this, ex.toString(),
                    Toast.LENGTH_SHORT).show();
        }

    }

}
