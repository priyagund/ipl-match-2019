package com.ipl2019;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class IPLMatch2019AnalyzerTest {

    private String IPL_RUNS_RECORD_FILE = "/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IPL2019FactsheetMostRuns.csv";
    private String FILE_FOR_STRIKING_RATE_AND_FOURS="/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IPL_2019_Check_StrikingRate_And_NoOfFours.csv";
    private String IPL_WKTS_FILE_PATH="/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IPL2019FactsheetMostWkts.csv";
    private String IPL_WKTS_SAMPLE_FILE="/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IPL_Wkts_Sample_file_path.csv";

    @Test
    public void givenLoadIPLRunsRecord_ifLoded_shouldReturnResult() {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            int noOfPlayers = iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN,IPL_RUNS_RECORD_FILE);
            Assert.assertEquals(100, noOfPlayers);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLRunRecordsFile_sortedByLowestBatsMan_shouldReturnPlayer() {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBatsManAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN,IPL_RUNS_RECORD_FILE);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.BATTINGAVERAGE);
            IPLRunsCSV[] iplRunsCSVS = new Gson().fromJson(sortedCSVData, IPLRunsCSV[].class);
            Assert.assertEquals("Ishant Sharma", iplRunsCSVS[0].player);
        } catch (IPLMatchException e) {

        }
    }

    @Test
    public void givenIPLRunRecordFile_sortedTopBatsMan_shouldReturnPlayer() {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBatsManAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN,IPL_RUNS_RECORD_FILE);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.BATTINGAVERAGE);
            IPLRunsCSV[] iplRunsCSVS = new Gson().fromJson(sortedCSVData, IPLRunsCSV[].class);
            Assert.assertEquals("MS Dhoni", iplRunsCSVS[iplRunsCSVS.length - 1].player);
        } catch (IPLMatchException e) {

        }

    }

    @Test
    public void givenIPLRunsRecordFile_sortedByLowestStrikingRate_shouldReturnPlayer() {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBatsManAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN,IPL_RUNS_RECORD_FILE);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.STRIKING_RATE);
            IPLRunsCSV[] iplRunsCSVS = new Gson().fromJson(sortedCSVData, IPLRunsCSV[].class);
            Assert.assertEquals("Bhuvneshwar Kumar", iplRunsCSVS[0].player);
        } catch (IPLMatchException e) {

        }
    }

    @Test
    public void givenIPLRunsRecordFile_sortedByTopStrikingRate_shouldReturnPlayer() {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBatsManAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN,IPL_RUNS_RECORD_FILE);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.STRIKING_RATE);
            IPLRunsCSV[] iplRunsCSVS = new Gson().fromJson(sortedCSVData, IPLRunsCSV[].class);
            Assert.assertEquals("Ishant Sharma", iplRunsCSVS[iplRunsCSVS.length - 1].player);
        } catch (IPLMatchException e) {

        }
    }

    @Test
    public void givenIPLRunsRecordFile_sortedByMaximumSixexAndFours_shouldReturnPlayer() {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBatsManAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN,IPL_RUNS_RECORD_FILE);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.MAX_SIX_AND_FOURS);
            IPLRunsCSV[] iplRunsCSVS = new Gson().fromJson(sortedCSVData, IPLRunsCSV[].class);
            Assert.assertEquals("Andre Russell", iplRunsCSVS[iplRunsCSVS.length-1].player);
        } catch (IPLMatchException e) {

        }
    }

    @Test
    public void givenIPLRunsRecordFile_sortedByMinimumSixexAndFours_shouldReturnPlayer()
    {
        try{
        IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
        iplMatch2019.setAdaptor(new IPLBatsManAdaptor());
        iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN,IPL_RUNS_RECORD_FILE);
        String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.MAX_SIX_AND_FOURS);
        IPLRunsCSV[] iplRunsCSVS = new Gson().fromJson(sortedCSVData, IPLRunsCSV[].class);
        Assert.assertEquals("Tim Southee", iplRunsCSVS[0].player);
    } catch (IPLMatchException e) {

    }
    }

    @Test
    public void givenIPLRunsRecordFile_sortedByMinimumStrikingRAteWithMaxSixesAndMaxFours_shoulReturnPlayer()
    {
        try {
            IPLMatch2019Analyzer iplMatch2019=new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBatsManAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN,IPL_RUNS_RECORD_FILE);
            String sortedCSVData=iplMatch2019.sortedByGivenField(IPLField.STRIKINRATE_MAX_SIX_AND_FOURS);
            IPLRunsCSV[] iplRunsCSVS=new Gson().fromJson(sortedCSVData,IPLRunsCSV[].class);
            Assert.assertEquals("Shakib Al Hasan",iplRunsCSVS[0].player);
        } catch (IPLMatchException e) {

        }
    }

    @Test
    public void givenIPLRunsRecordFile_sortedByMaximumStrikingRateWithMaxSixesAndMaxFours_shoulReturnPlayer()
    {
        try {
            IPLMatch2019Analyzer iplMatch2019=new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBatsManAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN,IPL_RUNS_RECORD_FILE);
            String sortedCSVData=iplMatch2019.sortedByGivenField(IPLField.STRIKINRATE_MAX_SIX_AND_FOURS);
            IPLRunsCSV[] iplRunsCSVS=new Gson().fromJson(sortedCSVData,IPLRunsCSV[].class);
            Assert.assertEquals("Andre Russell",iplRunsCSVS[iplRunsCSVS.length-1].player);
        } catch (IPLMatchException e) {

        }
    }

    @Test
    public void givenIPLRunsRecordFile_sortedByMaximumStrikingWithGreatBattingAverage_shouldReturnPlayer()
    {
        try {
            IPLMatch2019Analyzer iplMatch2019=new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBatsManAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN ,IPL_RUNS_RECORD_FILE);
            String sortedCSVData=iplMatch2019.sortedByGivenField(IPLField.MAX_STRIKINRATE_MAX_AVERAGE);
            IPLRunsCSV[] iplRunsCSVS=new Gson().fromJson(sortedCSVData,IPLRunsCSV[].class);
            Assert.assertEquals("Ishant Sharma",iplRunsCSVS[iplRunsCSVS.length-1].player);
        } catch (IPLMatchException e) {

        }
    }

    @Test
    public void givenIPLRunsRecordFile_sortedByMinimumStrikingWithGreatBattingAverage_shouldReturnPlayer()
    {
        try {
            IPLMatch2019Analyzer iplMatch2019=new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBatsManAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN,IPL_RUNS_RECORD_FILE);
            String sortedCSVData=iplMatch2019.sortedByGivenField(IPLField.MAX_STRIKINRATE_MAX_AVERAGE);
            IPLRunsCSV[] iplRunsCSVS=new Gson().fromJson(sortedCSVData,IPLRunsCSV[].class);
            Assert.assertEquals("Bhuvneshwar Kumar",iplRunsCSVS[0].player);
        } catch (IPLMatchException e) {

        }
    }

    @Test
    public void givenIPLRunsRecordFile_sortedWithMaximumRunsWithBestBattingAverage_shouldReturnPlayer()
    {
        try {
            IPLMatch2019Analyzer iplMatch2019=new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBatsManAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN,IPL_RUNS_RECORD_FILE);
            String sortedCSVData=iplMatch2019.sortedByGivenField(IPLField.MAX_RUNS_WITH_BEST_AVERAGE);
            IPLRunsCSV[] iplRunsCSVS=new Gson().fromJson(sortedCSVData,IPLRunsCSV[].class);
            Assert.assertEquals("David Warner",iplRunsCSVS[iplRunsCSVS.length-1].player);
        } catch (IPLMatchException e) {

        }
    }

    @Test
    public void givenIPLRunsRecordFile_sortedWithMinimumRunsWithWorstAverage_shouldReturnPlayer() {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBatsManAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN,IPL_RUNS_RECORD_FILE);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.MAX_RUNS_WITH_BEST_AVERAGE);
            IPLRunsCSV[] iplRunsCSVS = new Gson().fromJson(sortedCSVData, IPLRunsCSV[].class);
            Assert.assertEquals("Tim Southee", iplRunsCSVS[0].player);
        } catch (IPLMatchException e) {

        }
    }

        @Test
        public void givenLoadIPLWktsRecord_ifLoded_shouldReturnResult() {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBowlersAdaptor());
            int noOfPlayers = iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BOWLWER,IPL_WKTS_FILE_PATH);
            Assert.assertEquals(99, noOfPlayers);
        } catch (IPLMatchException e) {
           e.printStackTrace();
        }
    }

    @Test
    public void givenIPLWktsRecordFile_sortedWithTopBowlingAvearge_shouldReturnPlayer()
    {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBowlersAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BOWLWER,IPL_WKTS_FILE_PATH);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.BOWLINGAVERAGE);
            IPLWktsCSV[] iplWktsCSVS = new Gson().fromJson(sortedCSVData, IPLWktsCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", iplWktsCSVS[iplWktsCSVS.length - 1].player);
        } catch (IPLMatchException e) {
          e.printStackTrace();
        }
    }

    @Test
    public void givenIPLWktsRecordFile_sortedWithWorthBowlingAverage_shouldreturnPlayer()
    {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBowlersAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BOWLWER,IPL_WKTS_FILE_PATH);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.BOWLINGAVERAGE);
            IPLWktsCSV[] iplWktsCSVS = new Gson().fromJson(sortedCSVData, IPLWktsCSV[].class);
            Assert.assertEquals("Suresh Raina", iplWktsCSVS[0].player);
        } catch (IPLMatchException e) {
          e.printStackTrace();
        }
    }

    @Test
    public void givenIPLWktsRecordFile_sortedWithTopStrikingRateOfBowler_shouldReturnPlayer()
    {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBowlersAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BOWLWER,IPL_WKTS_FILE_PATH);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.STRIKING_RATE);
            IPLWktsCSV[] iplWktsCSVS = new Gson().fromJson(sortedCSVData, IPLWktsCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", iplWktsCSVS[iplWktsCSVS.length-1].player);
        } catch (IPLMatchException e) {
          e.printStackTrace();
        }
    }

    @Test
    public void givenIPLWktsRecordFile_sortedWithWorthStrikingRateOfBowler_shouldReturnPlayer()
    {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBowlersAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BOWLWER,IPL_WKTS_FILE_PATH);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.STRIKING_RATE);
            IPLWktsCSV[] iplWktsCSVS = new Gson().fromJson(sortedCSVData, IPLWktsCSV[].class);
            Assert.assertEquals("Suresh Raina", iplWktsCSVS[0].player);
        } catch (IPLMatchException e) {
           e.printStackTrace();
        }
    }

    @Test
    public void givenIPLWktsRecordFile_sortedWithTopEconomy_shouldreturnPlayer()
    {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBowlersAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BOWLWER,IPL_WKTS_FILE_PATH);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.ECONOMY);
            IPLWktsCSV[] iplWktsCSVS = new Gson().fromJson(sortedCSVData, IPLWktsCSV[].class);
            Assert.assertEquals("Ben Cutting", iplWktsCSVS[iplWktsCSVS.length-1].player);
        } catch (IPLMatchException e) {
          e.printStackTrace();
        }
    }

    @Test
    public void givenIPLWktsRecordFile_sortedWithWorstEconomy_shouldreturnPlayer()
    {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBowlersAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BOWLWER,IPL_WKTS_FILE_PATH);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.ECONOMY);
            IPLWktsCSV[] iplWktsCSVS = new Gson().fromJson(sortedCSVData, IPLWktsCSV[].class);
            Assert.assertEquals("Shivam Dube", iplWktsCSVS[0].player);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLWktsRecordFile_sortedWithMaxStrikingRateWith4WktsAnd5Wkts_shouldreturnPlayer() {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBowlersAdaptor());
            iplMatch2019.loadIplData( IPLMatch2019Analyzer.Player.BOWLWER,IPL_WKTS_FILE_PATH);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.STRIKING_RATE_FOURWKTS_FIVEWKTS);
            IPLWktsCSV[] iplWktsCSVS = new Gson().fromJson(sortedCSVData, IPLWktsCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", iplWktsCSVS[iplWktsCSVS.length-1].player);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }

    }
    
    @Test
    public void givenIPLWktsRecordFile_sortedWithMinimumStrikingRateWith4WktsAnd5Wkts_shouldreturnPlayer()
    {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBowlersAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BOWLWER,IPL_WKTS_FILE_PATH);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.STRIKING_RATE_FOURWKTS_FIVEWKTS);
            IPLWktsCSV[] iplWktsCSVS = new Gson().fromJson(sortedCSVData, IPLWktsCSV[].class);
            Assert.assertEquals("Suresh Raina", iplWktsCSVS[0].player);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLWktsRecordFile_sortedWithMaximumBowlingAverageWithBestStrikingRate()
    {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBowlersAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BOWLWER,IPL_WKTS_FILE_PATH);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.GREAT_BOWLING_AVERAGE_BEST_STRIKING_RATE);
            IPLWktsCSV[] iplWktsCSVS = new Gson().fromJson(sortedCSVData, IPLWktsCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", iplWktsCSVS[iplWktsCSVS.length-1].player);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }
    
    
    @Test
    public void givenIPLWktsRecordFile_sortedWithMinimumBowlingAverageWithBestStrikingRate_shouldReturnPlayer()
    {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBowlersAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BOWLWER,IPL_WKTS_FILE_PATH);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.GREAT_BOWLING_AVERAGE_BEST_STRIKING_RATE);
            IPLWktsCSV[] iplWktsCSVS = new Gson().fromJson(sortedCSVData, IPLWktsCSV[].class);
            Assert.assertEquals("Suresh Raina", iplWktsCSVS[0].player);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLWktsRecordFile_sortedWithMaximumWicketsWithBestBowlingAverage_shouldReturnPlay() {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBowlersAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BOWLWER,IPL_WKTS_FILE_PATH);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.MAXIMUM_WICKET_WITH_BEST_BOWLING);
            IPLWktsCSV[] iplWktsCSVS = new Gson().fromJson(sortedCSVData, IPLWktsCSV[].class);
            Assert.assertEquals("Imran Tahir", iplWktsCSVS[iplWktsCSVS.length-1].player);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLWktsRecordFile_sortedWithMinimumWicketsWithWorstBowlingAverage_shouldReturnPlay() {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new IPLBowlersAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.BOWLWER,IPL_WKTS_FILE_PATH);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.MAXIMUM_WICKET_WITH_BEST_BOWLING);
            IPLWktsCSV[] iplWktsCSVS = new Gson().fromJson(sortedCSVData, IPLWktsCSV[].class);
            Assert.assertEquals("Suresh Raina", iplWktsCSVS[0].player);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLRecordFile_sortedWithHighBattingAndBowllingAverage_shouldReturnPlayer()
    {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new MergeAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.MERGE_FILE,IPL_RUNS_RECORD_FILE,IPL_WKTS_FILE_PATH);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.MAXIMUM_BATTING_AVERAGE_MAXIMUM_BALLING_AVERAGE);
            IPLDao[] iplWktsCSVS = new Gson().fromJson(sortedCSVData, IPLDao[].class);
            Assert.assertEquals("Shreyas Iyer", iplWktsCSVS[iplWktsCSVS.length-1].player);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLRecordFile_sortedWithMostRunsAndHighWkts_shouldReturnPlayer()
    {
        try {
            IPLMatch2019Analyzer iplMatch2019 = new IPLMatch2019Analyzer();
            iplMatch2019.setAdaptor(new MergeAdaptor());
            iplMatch2019.loadIplData(IPLMatch2019Analyzer.Player.MERGE_FILE,IPL_RUNS_RECORD_FILE,IPL_WKTS_FILE_PATH);
            String sortedCSVData = iplMatch2019.sortedByGivenField(IPLField.MOST_RUNS_AND_HIGH_WICKETS);
            IPLDao[] iplWktsCSVS = new Gson().fromJson(sortedCSVData, IPLDao[].class);
            Assert.assertEquals("Hardik Pandya", iplWktsCSVS[iplWktsCSVS.length-1].player);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }
}


