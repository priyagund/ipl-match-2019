package com.ipl2019;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AdaptorAnalyzerMockTest {

    private String IPL_RUNS_FILE_PATH="/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IPL2019FactsheetMostRuns.csv";
    private String IPL_WKTS_FILE_PATH="/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IPL2019FactsheetMostWkts.csv";
    IPLMatch2019Analyzer iplAnalyser = new IPLMatch2019Analyzer();
    IPLMatch2019Analyzer iplBowlingAnalyzer=new IPLMatch2019Analyzer();

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    private IPLBowlersAdaptor iplBowlerObject;
    private IPLBatsManAdaptor iplBatsmanObject;

    @Before
    public void givenRunsFileData() {
        try {
            IPLDao daoObjectOne = new IPLDao(new IPLRunsCSV("David Warner", "12", "692", "69.2", "481", "0", "3", "22", "23"));
            IPLDao daoObjectTwo = new IPLDao(new IPLRunsCSV(" MS Dhoni", "15", "309", "243", "134.62", "2", "3", "3", "8"));
            IPLDao daoObjectThree = new IPLDao(new IPLRunsCSV("Suresh Raina", "17", "314", "600", "121.97", "0", "3", "45", "9"));
            Map<String, IPLDao> sampleBatsmanMap = new HashMap<>();
            sampleBatsmanMap.put("David Warner", daoObjectOne);
            sampleBatsmanMap.put("MS Dhoni", daoObjectTwo);
            sampleBatsmanMap.put("Suresh Raina", daoObjectThree);
            this.iplBatsmanObject = mock(IPLBatsManAdaptor.class);
            when(this.iplBatsmanObject.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN, IPL_RUNS_FILE_PATH)).thenReturn(sampleBatsmanMap);
            iplAnalyser.setAdaptor(this.iplBatsmanObject);

            IPLDao daoBowlerObjectOne = new IPLDao(new IPLWktsCSV("Imran Tahir","17","64.2","431","16","26.0","6.69","14","2","0"));
            IPLDao daoBowlerObjectTwo = new IPLDao(new IPLWktsCSV("Kagiso Rabada","12","47","368","25","14.72","11.28","2","0","7.82"));
            IPLDao daoBowlerObjectThree = new IPLDao(new IPLWktsCSV("Deepak Chahar","17","64","482","0","7.47","17.59","0","0","7.47"));
            Map<String, IPLDao> sampleBowlerMap = new HashMap<>();
            sampleBowlerMap.put("Imran Tahir", daoBowlerObjectOne);
            sampleBowlerMap.put("Kagiso Rabada", daoBowlerObjectTwo);
            sampleBowlerMap.put("Deepak Chahar", daoBowlerObjectThree);
            this.iplBowlerObject = mock(IPLBowlersAdaptor.class);
            when(this.iplBowlerObject.loadIplData(IPLMatch2019Analyzer.Player.BOWLWER, IPL_WKTS_FILE_PATH)).thenReturn(sampleBowlerMap);
            iplBowlingAnalyzer.setAdaptor(this.iplBowlerObject);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }
        @Test
        public void givenIplRunsFile_ifLoded_shouldReturnResult() {
            try {
                int countResult = iplAnalyser.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN, IPL_RUNS_FILE_PATH);
                Assert.assertEquals(3, countResult);
            } catch (IPLMatchException e) {
                e.printStackTrace();
            }
        }

    @Test
    public void givenWicketFile_ifLoded_shouldReturnResult() {
        try {
            int countResult = iplBowlingAnalyzer.loadIplData(IPLMatch2019Analyzer.Player.BOWLWER, IPL_WKTS_FILE_PATH);
            Assert.assertEquals(3, countResult);
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLRunRecordsFile_sortedByLowestBatingAverage_shouldReturnPlayer() {
        try {
            iplAnalyser.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN,IPL_RUNS_FILE_PATH);
            String sortedCSVData = iplAnalyser.sortedByGivenField(IPLField.BATTING_AVERAGE);
            IPLRunsCSV[] iplRunsCSVS = new Gson().fromJson(sortedCSVData, IPLRunsCSV[].class);
            Assert.assertEquals("David Warner", iplRunsCSVS[0].player);
        } catch (IPLMatchException e) {

        }
    }

    @Test
    public void givenIPLWicketRecordsFile_sortedByLowestBatingAverage_shouldReturnPlayer() {
        try {
            iplBowlingAnalyzer.loadIplData(IPLMatch2019Analyzer.Player.BOWLWER,IPL_WKTS_FILE_PATH);
            String sortedCSVData = iplBowlingAnalyzer.sortedByGivenField(IPLField.BOWLING_AVERAGE);
            IPLWktsCSV[] iplWktsCSVS = new Gson().fromJson(sortedCSVData, IPLWktsCSV[].class);
            Assert.assertEquals("Deepak Chahar", iplWktsCSVS[0].player);
        } catch (IPLMatchException e) {

        }
    }
}

