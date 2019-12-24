package com.ipl2019;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class IPLBowlerAdaptorTest {

    private String IPL_WKTS_FILE_PATH="/home/admin142/Desktop/priya/ipl-match-2019/src/test/resources/IPL2019FactsheetMostWkts.csv";
    private String WRONG_FILE_PATH="/home/admin142/Desktop/priya/ipl-match-2019/src/test/resources/IPL_Wkts_Sample_file_path.json";
    private String INCORRECT_HEADER="/home/admin142/Desktop/priya/ipl-match-2019/src/test/resources/IncrrectHeader.csv";
    private String INCORRECT_DELIMETER="/home/admin142/Desktop/priya/ipl-match-2019/src/test/resources/IncorrectDelimiter.csv";

    @Test
    public void givenLoadIPLWktsRecord_ifLoded_shouldReturnResult() {
        try {
            IPLBowlersAdaptor iplBowlersAdaptor = new IPLBowlersAdaptor();
            Map<String, IPLDao> noOfPlayers = iplBowlersAdaptor.loadIplData(IPLMatch2019Analyzer.Player.BOWLWER,IPL_WKTS_FILE_PATH);
            Assert.assertEquals(99, noOfPlayers.size());
        } catch (IPLMatchException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLRunRecordFile_ifIncorrectFIle_shouldThrowException() {
        try {
            IPLBatsManAdaptor iplBatsManAdaptor = new IPLBatsManAdaptor();
            iplBatsManAdaptor.loadIplData(IPLMatch2019Analyzer.Player.BOWLWER,WRONG_FILE_PATH);
        } catch (IPLMatchException e) {
            Assert.assertEquals(IPLMatchException.ExceptionType.FILE_NOT_FOUND, e.type);
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
