package com.ipl2019;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class IPLBatsManAdaptorTest {

    private String IPL_RUNS_RECORD_FILE = "/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IPL2019FactsheetMostWkts.csv";
    private String WRONG_FILE_PATH = "/home/admin165/Downloads/CensusAnalyser(2)/CensusAnalyser/src/test/resources/USCensusData.csv";
    private String INCORRECT_HEADER = "/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IncrrectHeader.csv";
    private String INCORRECT_DELIMETER = "/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IncorrectDelimiter.csv";

    @Test
    public void givenLoadIPLRunsRecord_ifLoded_shouldReturnResult() {
        try {
            IPLBatsManAdaptor iplBatsManAdaptor = new IPLBatsManAdaptor();
            Map<String, IPLDao> noOfPlayers = iplBatsManAdaptor.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN, IPL_RUNS_RECORD_FILE);
            Assert.assertEquals(100, noOfPlayers.size());
        } catch (IPLMatchException e) {

        }
    }

    @Test
    public void givenIPLRunRecordFile_ifIncorrectFIle_shouldThrowException() {
        try {
            IPLBatsManAdaptor iplBatsManAdaptor = new IPLBatsManAdaptor();
            iplBatsManAdaptor.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN,WRONG_FILE_PATH);
        } catch (IPLMatchException e) {
            Assert.assertEquals(IPLMatchException.ExceptionType.SUME_ERROR_IN_FILE, e.type);
        }
    }

    @Test
    public void givenIPLRunRecordFile_ifEmptyFile_shouldThrowException() {
        try {
            IPLBatsManAdaptor iplBatsManAdaptor = new IPLBatsManAdaptor();
            iplBatsManAdaptor.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN,"");
        } catch (IPLMatchException e) {
            Assert.assertEquals(IPLMatchException.ExceptionType.SUME_ERROR_IN_FILE, e.type);
        }
    }

    @Test
    public void givenIPLRunRecordFile_ifIncorrctHeader_shouldThrowException() {
        try {
            IPLBatsManAdaptor iplBatsManAdaptor = new IPLBatsManAdaptor();
            iplBatsManAdaptor.loadIplData(IPLMatch2019Analyzer.Player.BATSMAN,INCORRECT_HEADER);
        } catch (IPLMatchException e) {
            Assert.assertEquals(IPLMatchException.ExceptionType.SUME_ERROR_IN_FILE, e.type);
        }
    }

    @Test
    public void givenIPLRunRecordFile_ifIncorrectDelimeter_shouThrownException() {
        try {
            IPLBatsManAdaptor iplBatsManAdaptor = new IPLBatsManAdaptor();
            iplBatsManAdaptor
                    .loadIplData(IPLMatch2019Analyzer.Player.BATSMAN,INCORRECT_DELIMETER);
        } catch (IPLMatchException e) {
            Assert.assertEquals(IPLMatchException.ExceptionType.SUME_ERROR_IN_FILE, e.type);
        }

    }
}