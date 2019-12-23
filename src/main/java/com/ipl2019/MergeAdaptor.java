package com.ipl2019;

import java.util.Map;

public class MergeAdaptor extends IPLMatchAdaptor  {

    @Override
    public <E> Map<String, IPLDao> loadIplData(IPLMatch2019.Player player, String... iplCSVFilePath) throws IPLMatchException {
       Map<String,IPLDao>iplBatsManMap=super.loadIplData(IPLRunsCSV.class,iplCSVFilePath[0]);
       Map<String,IPLDao>iplBowlerMap=super.loadIplData(IPLWktsCSV.class,iplCSVFilePath[1]);
       iplBowlerMap.values().stream()
               .filter(iplRuns->iplBatsManMap.get(iplRuns.player)!=null)
       .forEach(iplRuns->iplBatsManMap.get(iplRuns.player).bowlingAverage=iplRuns.bowlingAverage);
        return iplBatsManMap;

        /*iplBowlerMap.values().stream()
                .filter(iplRuns->iplBatsManMap.get(iplRuns.player)!=null)
                .forEach(iplRuns->iplBatsManMap.get(iplRuns.player).battingAverage=iplRuns.bowlingAverage);
     */

    }
}
