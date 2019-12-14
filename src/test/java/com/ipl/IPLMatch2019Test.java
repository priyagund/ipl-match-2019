package com.ipl;

import org.junit.Assert;
import org.junit.Test;

public class IPLMatch2019Test
{
  private String IPL_RUNS_RECORD_FILE="/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IPL2019FactsheetMostRuns.csv";
  private String WRONG_FILE_PATH="/home/admin165/Downloads/CensusAnalyser(2)/CensusAnalyser/src/test/resources/USCensusData.csv";
  private String INCORRECT_HEADER="/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IncrrectHeader.csv";

  @Test
    public void givenLoadMatchRunsRecord_ifLoded_shouldReturnResult()
    {
        try {
            IPLMatch2019 iplMatch2019=new IPLMatch2019();
            int noOfPlayers = iplMatch2019.loadIplPlayersRecord(IPL_RUNS_RECORD_FILE);
            Assert.assertEquals(101,noOfPlayers);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenLoadMatchRunRecord_ifIncorrectFIle_shouldThrowException()
    {
        try {
            IPLMatch2019 iplMatch2019=new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord(WRONG_FILE_PATH);
        } catch (IPLMatchException e) {
            Assert.assertEquals(IPLMatchException.ExceptionType.SUME_ERROR_IN_FILE,e.type);
        }
    }

    @Test
    public void givenLoadMatchRunRecord_ifEmptyFile_shouldThrowException()
    {
        try {
            IPLMatch2019 iplMatch2019=new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord("");
        } catch (IPLMatchException e) {
            Assert.assertEquals(IPLMatchException.ExceptionType.SUME_ERROR_IN_FILE,e.type);
        }
    }

}
