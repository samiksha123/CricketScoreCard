package com.cricket.samiksha.cricketscorecard.model;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class OverTest {

  @Test
  public void shouldReturnRunPerOverWithoutWideAndNoBall(){
    Over over = new Over(Arrays.asList(1, 0, 0, 1, 1, 1), 0, 0);
    assertEquals(over.getTotalRuns(),4);
  }

  @Test
  public void shouldReturnRunPerOverWithWideAndNoBall(){
    Over over = new Over(Arrays.asList(1, 0, 0, 1, 1, 1), 2, 1);
    assertEquals(over.getTotalRuns(),7);
  }


}