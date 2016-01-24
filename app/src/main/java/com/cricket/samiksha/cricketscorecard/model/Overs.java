package com.cricket.samiksha.cricketscorecard.model;

import java.util.ArrayList;
import java.util.List;

public class Overs {

  int currentOver;
  List<Over> overs = new ArrayList<>();

  public Overs(int index,Over over) {
    overs.add(over);
    currentOver = index;
  }

  public Over getCurrentOver(){
    return overs.get(currentOver);
  }
}
