package com.ipl2019;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class IPLMatch2019Test {
    private String IPL_RUNS_RECORD_FILE = "/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IPL2019FactsheetMostRuns.csv";
    private String WRONG_FILE_PATH = "/home/admin165/Downloads/CensusAnalyser(2)/CensusAnalyser/src/test/resources/USCensusData.csv";
    private String INCORRECT_HEADER = "/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IncrrectHeader.csv";
    private String INCORRECT_DELIMETER = "/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IncorrectDelimiter.csv";
    private String FILE_FOR_STRIKING_RATE_AND_FOURS="/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IPL_2019_Check_StrikingRate_And_NoOfFours.csv";
    @Test
    public void givenLoadIPLRunsRecord_ifLoded_shouldReturnResult() {
        try {
            IPLMatch2019 iplMatch2019 = new IPLMatch2019();
            int noOfPlayers = iplMatch2019.loadIplPlayersRecord(IPL_RUNS_RECORD_FILE);
            Assert.assertEquals(100, noOfPlayers);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLRunRecordFile_ifIncorrectFIle_shouldThrowException() {
        try {
            IPLMatch2019 iplMatch2019 = new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord(WRONG_FILE_PATH);
        } catch (IPLMatchException e) {
            Assert.assertEquals(IPLMatchException.ExceptionType.SUME_ERROR_IN_FILE, e.type);
        }
    }

    @Test
    public void givenIPLRunRecordFile_ifEmptyFile_shouldThrowException() {
        try {
            IPLMatch2019 iplMatch2019 = new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord("");
        } catch (IPLMatchException e) {
            Assert.assertEquals(IPLMatchException.ExceptionType.SUME_ERROR_IN_FILE, e.type);
        }
    }

    @Test
    public void givenIPLRunRecordFile_ifIncorrctHeader_shouldThrowException() {
        try {
            IPLMatch2019 iplMatch2019 = new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord(INCORRECT_HEADER);
        } catch (IPLMatchException e) {
            Assert.assertEquals(IPLMatchException.ExceptionType.SUME_ERROR_IN_FILE, e.type);
        }
    }

    @Test
    public void givenIPLRunRecordFile_ifIncorrectDelimeter_shouThrownException() {
        try {
            IPLMatch2019 iplMatch2019 = new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord(INCORRECT_DELIMETER);
        } catch (IPLMatchException e) {
            Assert.assertEquals(IPLMatchException.ExceptionType.SUME_ERROR_IN_FILE, e.type);
        }

    }

    @Test
    public void givenIPLRunRecordsFile_sortedByLowestBatsMan_shouldReturnPlayer() {
        try {
            IPLMatch2019 iplMatch2019 = new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord(IPL_RUNS_RECORD_FILE);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.AVERAGE);
            IPLRunsCSV[] iplRunsCSVS = new Gson().fromJson(sortedCSVData, IPLRunsCSV[].class);
            Assert.assertEquals("Ishant Sharma", iplRunsCSVS[0].player);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLRunRecordFile_sortedTopBatsMan_shouldReturnPlayer() {
        try {
            IPLMatch2019 iplMatch2019 = new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord(IPL_RUNS_RECORD_FILE);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.AVERAGE);
            IPLRunsCSV[] iplRunsCSVS = new Gson().fromJson(sortedCSVData, IPLRunsCSV[].class);
            Assert.assertEquals("MS Dhoni", iplRunsCSVS[iplRunsCSVS.length - 1].player);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenIPLRunsRecordFile_sortedByLowestStrikingRate_shouldReturnPlayer() {
        try {
            IPLMatch2019 iplMatch2019 = new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord(IPL_RUNS_RECORD_FILE);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.STRIKING_RATE);
            IPLRunsCSV[] iplRunsCSVS = new Gson().fromJson(sortedCSVData, IPLRunsCSV[].class);
            Assert.assertEquals("Bhuvneshwar Kumar", iplRunsCSVS[0].player);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLRunsRecordFile_sortedByTopStrikingRate_shouldReturnPlayer() {
        try {
            IPLMatch2019 iplMatch2019 = new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord(IPL_RUNS_RECORD_FILE);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.STRIKING_RATE);
            IPLRunsCSV[] iplRunsCSVS = new Gson().fromJson(sortedCSVData, IPLRunsCSV[].class);
            Assert.assertEquals("Ishant Sharma", iplRunsCSVS[iplRunsCSVS.length - 1].player);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLRunsRecordFile_sortedByMaximumSixexAndFours_shouldReturnPlayer() {
        try {
            IPLMatch2019 iplMatch2019 = new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord(IPL_RUNS_RECORD_FILE);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.MAX_SIX_AND_FOURS);
            IPLRunsCSV[] iplRunsCSVS = new Gson().fromJson(sortedCSVData, IPLRunsCSV[].class);
            Assert.assertEquals("Andre Russell", iplRunsCSVS[iplRunsCSVS.length-1].player);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLRunsRecordFile_sortedByMinimumSixexAndFours_shouldReturnPlayer()
    {
        try{
        IPLMatch2019 iplMatch2019 = new IPLMatch2019();
        iplMatch2019.loadIplPlayersRecord(IPL_RUNS_RECORD_FILE);
        String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.MAX_SIX_AND_FOURS);
        IPLRunsCSV[] iplRunsCSVS = new Gson().fromJson(sortedCSVData, IPLRunsCSV[].class);
        Assert.assertEquals("Tim Southee", iplRunsCSVS[0].player);
    } catch (IPLMatchException e) {
        e.printStackTrace();
    }
    }

    @Test
    public void givenIPLRunsRecordFile_sortedByMinimumStrikingRAteWithMaxSixesAndMaxFours_shoulReturnPlayer()
    {
        try {
            IPLMatch2019 iplMatch2019=new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord(IPL_RUNS_RECORD_FILE);
            String sortedCSVData=iplMatch2019.sortedByGivenField(IPLField.STRIKINRATE_MAX_SIX_AND_FOURS);
            System.out.println(sortedCSVData);
            IPLRunsCSV[] iplRunsCSVS=new Gson().fromJson(sortedCSVData,IPLRunsCSV[].class);
            Assert.assertEquals("Shakib Al Hasan",iplRunsCSVS[0].player);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenIPLRunsRecordFile_sortedByMaximumStrikingRAteWithMaxSixesAndMaxFours_shoulReturnPlayer()
    {
        try {
            IPLMatch2019 iplMatch2019=new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord(IPL_RUNS_RECORD_FILE );
            String sortedCSVData=iplMatch2019.sortedByGivenField(IPLField.STRIKINRATE_MAX_SIX_AND_FOURS);
            System.out.println(sortedCSVData);
            IPLRunsCSV[] iplRunsCSVS=new Gson().fromJson(sortedCSVData,IPLRunsCSV[].class);
            Assert.assertEquals("Andre Russell",iplRunsCSVS[iplRunsCSVS.length-1].player);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLRunsRecordFile_sortedByMaximumStrikingWithGreatAverage_shouldReturnPlayer()
    {
        try {
            IPLMatch2019 iplMatch2019=new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord(IPL_RUNS_RECORD_FILE );
            String sortedCSVData=iplMatch2019.sortedByGivenField(IPLField.MAX_STRIKINRATE_MAX_AVERAGE);
            System.out.println(sortedCSVData);
            IPLRunsCSV[] iplRunsCSVS=new Gson().fromJson(sortedCSVData,IPLRunsCSV[].class);
            Assert.assertEquals("MS Dhoni",iplRunsCSVS[iplRunsCSVS.length-1].player);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLRunsRecordFile_sortedByMinimumStrikingWithGreatAverage_shouldReturnPlayer()
    {
        try {
            IPLMatch2019 iplMatch2019=new IPLMatch2019();
            iplMatch2019.loadIplPlayersRecord(IPL_RUNS_RECORD_FILE );
            String sortedCSVData=iplMatch2019.sortedByGivenField(IPLField.MAX_STRIKINRATE_MAX_AVERAGE);
            System.out.println(sortedCSVData);
            IPLRunsCSV[] iplRunsCSVS=new Gson().fromJson(sortedCSVData,IPLRunsCSV[].class);
            Assert.assertEquals("Tim Southee",iplRunsCSVS[0].player);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }



}