package com.ipl2019;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AdaptorAnalyzerMockTest {

    private String IPL_RUNS_FILE_PATH="/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IPL2019FactsheetMostRuns.csv";
    @Mock
    IPLBatsManAdaptor iplBatsmanObject;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();


    @Test
    public void givenIplRunsFile_ifLoded_shouldReturnResult() throws IPLMatchException {

        IPLDao daoObjectOne = new IPLDao(new IPLRunsCSV("David Warner", "12", "692", "69.2", "481", "0", "3", "22", "23"));
        IPLDao daoObjectTwo = new IPLDao(new IPLRunsCSV(" MS Dhoni", "15", "309", "243", "134.62", "2", "3", "3", "8"));
        IPLDao daoObjectThree =new IPLDao(new IPLRunsCSV("Suresh Raina", "17", "314", "600", "121.97", "0", "3", "45", "9"));

        Map<String, IPLDao> sampleBatsmanMap = new HashMap<>();
        sampleBatsmanMap.put("David Warner", daoObjectOne);
        sampleBatsmanMap.put("MS Dhoni", daoObjectTwo);
        sampleBatsmanMap.put("Suresh Raina", daoObjectThree);
        iplBatsmanObject = mock(IPLBatsManAdaptor.class);
        when(iplBatsmanObject.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN,IPL_RUNS_FILE_PATH)).thenReturn(sampleBatsmanMap);
        IPLMatch2019Analyzer iplAnalyser = new IPLMatch2019Analyzer();
        iplAnalyser.setAdaptor( iplBatsmanObject);
        int countResult = iplAnalyser.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN, IPL_RUNS_FILE_PATH);
        Assert.assertEquals(3, countResult);
    }
}