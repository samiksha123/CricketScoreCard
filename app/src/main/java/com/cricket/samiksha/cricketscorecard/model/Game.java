package com.cricket.samiksha.cricketscorecard.model;

import java.util.Arrays;

public class Game {

  int numberOfOvers;
  int totalRuns;

  public Game(int numberOfOvers) {
    this.numberOfOvers = numberOfOvers;
  }

  public int getInningRuns(){
    for (int i = 0; i < numberOfOvers; i++) {
      Overs overs = new Overs(i,new Over(Arrays.asList(1,2,0,0,2,0),0,0));
      totalRuns += overs.getCurrentOver().getTotalRuns();
    }
    return totalRuns;
}

}
