package com.cricket.samiksha.cricketscorecard.model;

import java.util.ArrayList;
import java.util.List;

public class Over {
  List<Integer> totalBalls = new ArrayList<>();
  int wideBall;
  int noBall;
  int runs;

  public Over(List<Integer> totalBalls, int wideBall, int noBall) {
    this.totalBalls = totalBalls;
    this.wideBall = wideBall;
    this.noBall = noBall;
  }

  public void setTotalBalls(List<Integer> totalBalls) {
    this.totalBalls = totalBalls;
  }

  public void setWideBall(int wideBall) {
    this.wideBall = wideBall;
  }

  public void setNoBall(int noBall) {
    this.noBall = noBall;
  }

  public void setRun(int runs) {
    this.runs = runs;
  }

  public int getTotalRuns() {
    for (Integer ball : totalBalls) {
      runs += ball;
    }
    runs += wideBall + noBall;
    return runs;
  }
}
