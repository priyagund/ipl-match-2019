package com.ipl2019;

import java.util.Comparator;

public class SortedOnMaxFoursAndSixes implements Comparator<IPLDao>
{
    @Override
    public int compare(IPLDao iplRunsDaoOne, IPLDao iplRunsDaoTwo)
    {
        return ((iplRunsDaoOne.noOfSixs*6)+(iplRunsDaoOne.noOfFours*4)) - ((iplRunsDaoTwo.noOfSixs*6)+(iplRunsDaoTwo.noOfFours*4));
    }
}
