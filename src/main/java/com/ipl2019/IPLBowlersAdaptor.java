package com.ipl2019;

import java.util.Map;

public class IPLBowlersAdaptor extends IPLMatchAdaptor{


    @Override
    public <E> Map<String, IPLDao> loadIplData(IPLMatch2019.Player player, String... iplCSVFilePath) throws IPLMatchException {
        Map<String,IPLDao> iplRunsCSVMap=super.loadIplData(IPLWktsCSV.class,iplCSVFilePath[0]);
        return iplRunsCSVMap;
    }
}
