package com.ipl2019;

import com.google.gson.Gson;
import java.util.*;
import static java.util.stream.Collectors.toCollection;

public class IPLMatch2019 {

    public enum Player{
        BOWLWER,BATSMAN;
    }

    Map<String, IPLDao> iplCSVMap;
    Map<IPLField, Comparator<IPLDao>> iplMapComparator;

    public IPLMatch2019() {
        this.iplCSVMap = new HashMap<>();
        this.iplMapComparator = new HashMap<>();
        this.iplMapComparator.put(IPLField.AVERAGE, Comparator.comparing(iplrun->iplrun.average));
        this.iplMapComparator.put(IPLField.STRIKING_RATE,Comparator.comparing(iplrun->iplrun.strikingRate));
        this.iplMapComparator.put(IPLField.MAX_SIX_AND_FOURS,new SortedOnMaxFoursAndSixes());
        this.iplMapComparator.put(IPLField.ECONOMY,Comparator.comparing(iplRun->iplRun.economy));
        Comparator<IPLDao>fourWkts=Comparator.comparing(iplRun->iplRun.fourWkts);
        Comparator<IPLDao>fiveWkts=Comparator.comparing(iplRuns->iplRuns.fiveWkts);
        Comparator<IPLDao>max4Wkts5Wkts=fourWkts.thenComparing(fiveWkts);
        Comparator<IPLDao> strikingRateComparator = Comparator.comparing(iplrun -> iplrun.strikingRate);
        Comparator<IPLDao>maxStrikingRateWith4Wkts5Wkts=strikingRateComparator.thenComparing(max4Wkts5Wkts);
        this.iplMapComparator.put(IPLField.STRIKING_RATE_FOURWKTS_FIVEWKTS,maxStrikingRateWith4Wkts5Wkts);
        Comparator<IPLDao> fourSixsComparator= new SortedOnMaxFoursAndSixes();
        Comparator<IPLDao> maxStrikingRateWithMaxSixesAndMaxFours= fourSixsComparator.thenComparing(strikingRateComparator);
        this.iplMapComparator.put(IPLField.STRIKINRATE_MAX_SIX_AND_FOURS, maxStrikingRateWithMaxSixesAndMaxFours);
        Comparator<IPLDao> maxAveargeComparator=Comparator.comparing(iplRuns->iplRuns.average);
        Comparator<IPLDao>maxStrikingRateWithMaxAverage=maxAveargeComparator.thenComparing(strikingRateComparator);
        this.iplMapComparator.put(IPLField.MAX_STRIKINRATE_MAX_AVERAGE, maxStrikingRateWithMaxAverage);
        Comparator<IPLDao>maxRunsComparator=Comparator.comparing(iplRuns->iplRuns.runs);
        Comparator<IPLDao>maxRunsWithBestAverage=maxRunsComparator.thenComparing(maxAveargeComparator);
        this.iplMapComparator.put(IPLField.MAX_RUNS_WITH_BEST_AVERAGE,maxRunsWithBestAverage);
    }

    public int loadiplData(String iplCsvFilePath, Player player) throws IPLMatchException {
        IPLMatchAdaptor censusAdaptor = IPLMatchAdaptorFactory.getCensusData(player);
        iplCSVMap = censusAdaptor.loadiplData(iplCsvFilePath);
        return iplCSVMap.size();
    }

    public String sortedByGivenField(IPLField fieldName) throws IPLMatchException {
        if (iplCSVMap == null || iplCSVMap.size() == 0) {
            throw new IPLMatchException("no ipl data", IPLMatchException.ExceptionType.NO_DATA_FOUND);
        }
        ArrayList iplList = iplCSVMap.values().stream()
                .sorted(this.iplMapComparator.get(fieldName))
                .collect(toCollection(ArrayList::new));
        String sortedIplRunsJson = new Gson().toJson(iplList);
        return sortedIplRunsJson;
    }

}

