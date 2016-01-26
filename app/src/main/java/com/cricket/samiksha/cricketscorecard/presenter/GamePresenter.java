package com.cricket.samiksha.cricketscorecard.presenter;


import com.cricket.samiksha.cricketscorecard.model.Over;

import java.util.Arrays;
import java.util.List;

public class GamePresenter {
  private Over over = new Over();

  public List<String> getPossibleInputs() {
    return Arrays.asList("1","2","4","6","wide","no ball","wicket");
  }

  public List<String> getPossibleRuns(){
    return Arrays.asList("1","2","4","6");
  }

  public void setRunsPerOver(String runEnterByUser) {
    over.addLastAction(runEnterByUser);
    if(getPossibleRuns().contains(runEnterByUser)){
      over.addRuns(Integer.parseInt(runEnterByUser));
    }
    if(runEnterByUser.equals("wide"))
      over.addWideBall();
    if(runEnterByUser.equals("no ball"))
      over.addNoBall();
    if(runEnterByUser.equals("wicket"))
      over.addWicket();
  }

  public String getRuns(){
    return String.valueOf(over.getRunsPerOver());
  }

  public boolean isOverComplete() {
    return over.isComplete();
  }

  public String getWicket() {
    return String.valueOf(over.getWicketsCount());
  }


  public void undoLastAction() {
    over.undoLastAction();
  }

}
