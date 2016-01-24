package com.cricket.samiksha.cricketscorecard.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.cricket.samiksha.cricketscorecard.R;
import com.cricket.samiksha.cricketscorecard.model.Over;
import com.cricket.samiksha.cricketscorecard.presenter.HomePresenter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends Activity {

  HomePresenter presenter = new HomePresenter();
  private List<Integer> totalBalls = new ArrayList<Integer>();
  private int currentOverCounter = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.game_layout);

    Intent intent = getIntent();
    final String teamName = intent.getStringExtra("team_name");
    final String numOfOvers = intent.getStringExtra("num_of_overs");

    TextView team = (TextView) findViewById(R.id.team_name);
    team.setText(teamName);


    GridView gridView = (GridView) findViewById(R.id.gridview1);
    ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
        android.R.layout.simple_list_item_1, presenter.getNumbers());
    gridView.setAdapter(adapter);

    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view,
                              int position, long id) {
        String runEnterByUser = ((TextView) view).getText().toString();
        int wideBalls = 0;
        int noball = 0;
        if(runEnterByUser.equals("1"))
          totalBalls.add(1);
        if(runEnterByUser.equals("2"))
          totalBalls.add(2);
        if(runEnterByUser.equals("4"))
          totalBalls.add(4);
        if(runEnterByUser.equals("6"))
          totalBalls.add(6);
        if(runEnterByUser.equals("wide"))
          wideBalls += 1;
        if(runEnterByUser.equals("no ball"))
          noball += 1;
        Over over = new Over(totalBalls, wideBalls, noball);
        TextView runs = (TextView) findViewById(R.id.total_runs);
        String totalruns = String.valueOf(over.getTotalRuns());
        runs.setText(totalruns);

        if(totalBalls.size() % 6 == 0 && wideBalls == 0 && noball == 0){
          currentOverCounter += 1;
          new AlertDialog.Builder(GameActivity.this)
              .setTitle("Over complete")
              .setMessage("Over : "+ currentOverCounter + "\n" + "Runs : " + totalruns)
              .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
              }).show();
        }

        TextView overs = (TextView) findViewById(R.id.overs);
        overs.setText(currentOverCounter+"/"+numOfOvers);

      }
    });
  }
}
