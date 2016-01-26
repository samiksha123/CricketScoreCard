package com.cricket.samiksha.cricketscorecard.model;


import java.util.Stack;

public class Over {

  Stack<Integer> totalBalls = new Stack<>();
  int wideBall = 0;
  int noBall = 0;
  int wicketCount = 0;
  String lastAction;

  public void addRuns(int run) {
    totalBalls.push(run);
  }

  public void addWideBall() {
    this.wideBall++;
  }

  public void addNoBall() {
    this.noBall++;
  }

  public int getRunsPerOver() {
    int runs = 0;
    for (Integer ball : totalBalls) {
      runs += ball;
    }
    runs += wideBall + noBall;
    return runs;
  }

  public boolean isComplete() {
    return totalBalls.size() != 0 && totalBalls.size() % 6 == 0;
  }

  public void addWicket() {
    wicketCount++;
  }

  public int getWicketsCount(){
    return wicketCount;
  }

  public void addLastAction(String lastAction){
    this.lastAction = lastAction;
  }

  public void undoLastAction() {
    if (lastAction != null) {
      if (lastAction.equals("wide"))
        wideBall--;
      if (lastAction.equals("no ball"))
        noBall--;
      if (totalBalls.contains(Integer.parseInt(lastAction)) && totalBalls.size() != 0) {
        totalBalls.pop();
      }
    }
  }

}
