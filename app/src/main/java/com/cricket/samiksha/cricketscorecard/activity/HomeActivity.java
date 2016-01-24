package com.cricket.samiksha.cricketscorecard.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cricket.samiksha.cricketscorecard.R;

public class HomeActivity extends Activity {

  private TextView teamName;
  private TextView numOfOvers;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.home_layout);

    teamName = (TextView) findViewById(R.id.team_name);
    numOfOvers = (TextView) findViewById(R.id.num_of_overs);

  }

  public void playGame(View view) {
    Intent intent = new Intent(this, GameActivity.class);
    intent.putExtra("team_name",teamName.getText().toString());
    intent.putExtra("num_of_overs",numOfOvers.getText().toString());
    startActivity(intent);
  }
}
