package com.ipl2019;

import java.util.Map;

public class IPLBowlersAdaptor extends IPLMatchAdaptor {

    @Override
    public <E> Map<String, IPLDao> loadiplData(String iplcsvFilePath) throws IPLMatchException {
        Map<String,IPLDao> iplWktsCSVMap=super.loadiplData(IPLWktsCSV.class, iplcsvFilePath);
        return iplWktsCSVMap;
    }
}
