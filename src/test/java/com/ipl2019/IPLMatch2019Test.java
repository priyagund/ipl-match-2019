package com.ipl2019;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class IPLMatch2019Test
{
  private String IPL_RUNS_RECORD_FILE="/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IPL2019FactsheetMostRuns.csv";
  private String WRONG_FILE_PATH="/home/admin165/Downloads/CensusAnalyser(2)/CensusAnalyser/src/test/resources/USCensusData.csv";
  private String INCORRECT_HEADER="/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IncrrectHeader.csv";
  private String INCORRECT_DELIMETER="/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IncorrectDelimiter.csv";

  @Test
    public void givenLoadIPLRunsRecord_ifLoded_shouldReturnResult()
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
    public void givenIPLRunRecordFile_ifIncorrectFIle_shouldThrowException()
    {
        try {
            IPLMatch2019 iplMatch2019=new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord(WRONG_FILE_PATH);
        } catch (IPLMatchException e) {
            Assert.assertEquals(IPLMatchException.ExceptionType.SUME_ERROR_IN_FILE,e.type);
        }
    }

    @Test
    public void givenIPLRunRecordFile_ifEmptyFile_shouldThrowException()
    {
        try {
            IPLMatch2019 iplMatch2019=new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord("");
        } catch (IPLMatchException e) {
            Assert.assertEquals(IPLMatchException.ExceptionType.SUME_ERROR_IN_FILE,e.type);
        }
    }

    @Test
    public void givenIPLRunRecordFile_ifIncorrctHeader_shouldThrowException()
    {
        try {
            IPLMatch2019 iplMatch2019=new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord(INCORRECT_HEADER);
        } catch (IPLMatchException e) {
            Assert.assertEquals(IPLMatchException.ExceptionType.SUME_ERROR_IN_FILE,e.type);
        }
    }

    @Test
    public void givenIPLRunRecordFile_ifIncorrectDelimeter_shouThrownException()
    {
        try {
        IPLMatch2019 iplMatch2019=new IPLMatch2019();
        iplMatch2019.loadIplPlayersRecord(INCORRECT_DELIMETER);
    } catch (IPLMatchException e) {
        Assert.assertEquals(IPLMatchException.ExceptionType.SUME_ERROR_IN_FILE,e.type);
    }

    }

   @Test
    public void givenIPLRunRecordsFile_sortedByGoodbatsMan_shouldReturnResult()
    {
        try {
            IPLMatch2019 iplMatch2019=new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord(IPL_RUNS_RECORD_FILE);
            String sortedCensusData = iplMatch2019.sortedByTopBattingRate(IPLField.AVERAGE);
            IPLRunsCSV[] iplRunsCSVS = new Gson().fromJson(sortedCensusData,IPLRunsCSV[].class);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }

}
