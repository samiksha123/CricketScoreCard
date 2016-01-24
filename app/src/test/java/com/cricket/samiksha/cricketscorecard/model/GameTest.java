package com.cricket.samiksha.cricketscorecard.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

  @Test
  public void shouldGiveRunsPerOver() {
    Game game = new Game(1);
    int runsPerOver = game.getRunsPerOver();
    assertEquals(5,runsPerOver);
  }

  @Test
  public void shouldGiveRunsPerInning() {
    Game game = new Game(20);
    int inningRuns = game.getInningRuns();
    assertEquals(100,inningRuns);
  }
}