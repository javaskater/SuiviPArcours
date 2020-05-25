package fr.cnam.nfa024.jpmena.suiviparcours;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fr.cnam.nfa024.jpmena.suiviparcours.bean.Step;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Step> arrayOfSteps = Step.loadSteps();

        // Create the adapter to convert the array to views
        CustomStepAdapter adapter = new CustomStepAdapter(this, arrayOfSteps);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lvSteps);
        listView.setAdapter(adapter);
    }



}
