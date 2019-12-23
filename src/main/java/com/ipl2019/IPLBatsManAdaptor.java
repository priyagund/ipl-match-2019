package com.ipl2019;

import java.util.Map;

public class IPLBatsManAdaptor extends IPLMatchAdaptor {

    @Override
    public <E> Map<String, IPLDao> loadIplData(IPLMatch2019Analyzer.Player player, String... iplCSVFilePath) throws IPLMatchException {
        Map<String,IPLDao> iplRunsCSVMap=super.loadIplData(IPLRunsCSV.class,iplCSVFilePath[0]);
        return iplRunsCSVMap;    }

}
