package com.ipl;

import org.junit.Assert;
import org.junit.Test;

public class IPLMatch2019Test
{
  private String IPL_RUNS_RECORD_FILE="/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IPL2019FactsheetMostRuns.csv";

  @Test
    public void givenLoadmatchRunsRecord_ifLoded_shouldReturnResult()
    {
        try {
            IPLMatch2019 iplMatch2019=new IPLMatch2019();
            int noOfPlayers = iplMatch2019.loadIplPlayersRecord(IPL_RUNS_RECORD_FILE);
            Assert.assertEquals(101,noOfPlayers);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }

    }


}
