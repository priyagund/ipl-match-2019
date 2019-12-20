package com.ipl2019;

import java.util.Map;

public class IPLBowlerAdaptor extends IPLMatchAdaptor {

    @Override
    public <E> Map<String, IPLDao> loadiplData(String iplCSVFilePath) throws IPLMatchException {
        Map<String,IPLDao> iplRunsCSVMap=super.loadiplData(IPLRunsCSV.class,iplCSVFilePath);
        return iplRunsCSVMap;    }
}
