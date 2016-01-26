package com.cricket.samiksha.cricketscorecard.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class OverTest {

  @Test
  public void shouldReturnRunPerOverWithoutWideAndNoBall(){
    Over over = new Over();
    over.addRuns(4);
    over.addRuns(3);
    assertEquals(over.getRunsPerOver(), 7);
  }

  @Test
  public void shouldReturnRunPerOverWithWideAndNoBall(){
    Over over = new Over();
    over.addRuns(4);
    over.addNoBall();
    over.addWideBall();
    assertEquals(over.getRunsPerOver(), 6);
  }

  @Test
  public void shouldTellOverIsComplete(){
    Over over = new Over();
    over.addRuns(4);
    over.addRuns(4);
    over.addRuns(4);
    over.addRuns(4);
    over.addRuns(4);
    over.addRuns(4);
    assertTrue(over.isComplete());
  }

  @Test
  public void shouldTellOverIsNotCompleteWhenFirstBallIsWide(){
    Over over = new Over();
    over.addWideBall();
    assertFalse(over.isComplete());
  }

  @Test
  public void shouldTellOverIsNotCompleteWhenSecondBallIsWide(){
    Over over = new Over();
    over.addRuns(2);
    over.addWideBall();
    assertFalse(over.isComplete());
  }


  @Test
  public void shouldIncreaseWicketIfBatsManIsOut(){
    Over over = new Over();
    over.addRuns(2);
    over.addWideBall();
    over.addWicket();
    over.addWicket();
    assertEquals(2, over.getWicketsCount());
  }

  @Test
  public void shouldUndoLastAction(){
    Over over = new Over();
    over.addRuns(2);
    over.addWideBall();
    over.addLastAction("wide");
    over.undoLastAction();
    assertEquals(2, over.getRunsPerOver());
  }

}