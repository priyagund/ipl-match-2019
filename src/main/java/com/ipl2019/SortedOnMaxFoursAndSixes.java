package com.ipl2019;

import java.util.Comparator;

public class SortedOnMaxFoursAndSixes implements Comparator<IPLRunsDao>
{
    @Override
    public int compare(IPLRunsDao iplRunsDaoOne, IPLRunsDao iplRunsDaoTwo)
    {
        return ((iplRunsDaoOne.noOfSixs*6)+(iplRunsDaoOne.noOfFours*4)) - ((iplRunsDaoTwo.noOfSixs*6)+(iplRunsDaoTwo.noOfFours*4));
    }
}
