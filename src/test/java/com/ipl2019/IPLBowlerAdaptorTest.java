package com.ipl2019;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class IPLBowlerAdaptorTest {

    private String IPL_WKTS_FILE_PATH="/home/admin165/Desktop/Priya/NewIPL2019/src/test/resources/IPL2019FactsheetMostWkts.csv";

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
}
