package com.cricket.samiksha.cricketscorecard.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.cricket.samiksha.cricketscorecard.R;
import com.cricket.samiksha.cricketscorecard.presenter.GamePresenter;

public class GameActivity extends Activity {

  GamePresenter presenter = new GamePresenter();
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

    final TextView overs = (TextView) findViewById(R.id.overs);
    overs.setText(currentOverCounter + "/" + numOfOvers);

    GridView gridView = createInputTemplate();
    gridView.setOnItemClickListener(onInputClickListener(numOfOvers, overs));
  }

  @NonNull
  private AdapterView.OnItemClickListener onInputClickListener(final String numOfOvers, final TextView overs) {
    return new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String runEnterByUser = ((TextView) view).getText().toString();
        presenter.setRunsPerOver(runEnterByUser);

        TextView runs = (TextView) findViewById(R.id.total_runs);
        runs.setText(presenter.getRuns());

        if (presenter.isOverComplete()) {
          currentOverCounter += 1;
          showDialog();
        }
        overs.setText(currentOverCounter + "/" + numOfOvers);

      }
    };
  }

  @NonNull
  private GridView createInputTemplate() {
    GridView gridView = (GridView) findViewById(R.id.gridview1);
    ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
        android.R.layout.simple_list_item_1, presenter.getNumbers());
    gridView.setAdapter(adapter);
    return gridView;
  }

  private void showDialog() {
    new AlertDialog.Builder(GameActivity.this)
        .setTitle("Over complete")
        .setMessage("Over : " + currentOverCounter + "\n" + "Runs : " + presenter.getRuns())
        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
          }
        }).show();
  }

}
