package com.cricket.samiksha.cricketscorecard.presenter;


import com.cricket.samiksha.cricketscorecard.model.Over;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamePresenter {
  private List<Integer> totalBalls = new ArrayList<>();
  private int wideBalls = 0;
  private int wicket = 0;

  private int noball = 0;


  public List<String> getNumbers() {
    return Arrays.asList("1","2","4","6","wide","no ball","wicket");
  }

  public List<String> getPossibleRuns(){
    return Arrays.asList("1","2","4","6");
  }

  public void setRunsPerOver(String runEnterByUser) {
    if(getPossibleRuns().contains(runEnterByUser))
      totalBalls.add(Integer.parseInt(runEnterByUser));
    if(runEnterByUser.equals("wide"))
      setWidesPerOver();
    if(runEnterByUser.equals("no ball"))
      setNoBallsPerOver();
    if(runEnterByUser.equals("wicket"))
      setWicket();
  }

  public String getRuns(){
    Over over = new Over(totalBalls, wideBalls, noball);
    return String.valueOf(over.getTotalRuns());
  }

  public boolean isOverComplete() {
    return totalBalls.size() % 6 == 0;
  }

  public void setWidesPerOver(){
    wideBalls += 1;
  }

  public void setNoBallsPerOver(){
    noball += 1;
  }

  private void setWicket() {
    wicket += 1;
  }



}
