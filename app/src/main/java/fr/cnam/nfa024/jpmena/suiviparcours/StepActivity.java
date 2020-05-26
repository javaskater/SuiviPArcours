package fr.cnam.nfa024.jpmena.suiviparcours;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.cnam.nfa024.jpmena.suiviparcours.bean.Step;

public class StepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);
        TextView tvFrom = (TextView)findViewById(R.id.tvFrom);
        TextView tvTo = (TextView)findViewById(R.id.tvTo);
        TextView tvBy = (TextView)findViewById(R.id.tvBy);
        Intent i = getIntent();
        final Step step = (Step) i.getSerializableExtra(MainActivity.STEP);
        tvFrom.setText(step.getmRoomFrom()+"");
        tvTo.setText(step.getmRoomTo()+"");
        tvBy.setText(step.getmDisplacment());
        Button ok = (Button)findViewById(R.id.confirmation);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.putExtra(MainActivity.STEP, step);
                StepActivity.this.setResult(MainActivity.REQUEST_CODE,i);
                StepActivity.this.finish();
            }
        });
    }
}
