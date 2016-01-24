package com.cricket.samiksha.cricketscorecard.presenter;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GamePresenterTest {

  GamePresenter presenter = new GamePresenter();

  @Test
  public void getPossibleValuesForOver(){
    List<String> possibleValues = Arrays.asList("1", "2", "4", "6", "wide", "no ball", "wicket");
    assertEquals(possibleValues,presenter.getNumbers());
  }
}