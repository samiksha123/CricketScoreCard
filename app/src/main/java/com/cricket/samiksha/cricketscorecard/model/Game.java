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
      Overs overs = new Overs(i,new Over());
      totalRuns += overs.getCurrentOver().getRunsPerOver();
    }
    return totalRuns;
}

}
