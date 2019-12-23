package com.ipl2019;

import java.util.Comparator;

public class BatsManBowlerAverageComparator implements Comparator<IPLDao> {

    @Override
    public int compare(IPLDao iplDaoObject1, IPLDao iplDaoObject2) {
        return (int) ((iplDaoObject1.battingAverage + (1 / iplDaoObject1.bowlingAverage)) - (iplDaoObject2.battingAverage + (1 / iplDaoObject2.bowlingAverage)));
    }
}

