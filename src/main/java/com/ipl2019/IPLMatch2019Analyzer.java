package com.ipl2019;

import com.google.gson.Gson;
import java.util.*;
import static java.util.stream.Collectors.toCollection;

public class IPLMatch2019Analyzer {

    private IPLMatchAdaptor iplMatchAdaptor;

    public enum Player{
        BOWLWER,BATSMAN,MERGE_FILE;
    }

    Map<String, IPLDao> iplCSVMap;
    Map<IPLField, Comparator<IPLDao>> iplMapComparator;


    public IPLMatch2019Analyzer() {
        this.iplCSVMap = new HashMap<>();
        this.iplMapComparator = new HashMap<>();
        this.iplMapComparator.put(IPLField.BATTINGAVERAGE, Comparator.comparing(iplrun->iplrun.battingAverage));
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
        this.iplMapComparator.put(IPLField.BOWLINGAVERAGE, Comparator.comparing(iplrun->iplrun.bowlingAverage));
        Comparator<IPLDao> maxAveargeComparator=Comparator.comparing(iplRuns->iplRuns.bowlingAverage);
        Comparator<IPLDao>maxStrikingRateWithMaxAverage=maxAveargeComparator.thenComparing(strikingRateComparator);
        this.iplMapComparator.put(IPLField.MAX_STRIKINRATE_MAX_AVERAGE, maxStrikingRateWithMaxAverage);
        Comparator<IPLDao>maxRunsComparator=Comparator.comparing(iplRuns->iplRuns.runs);
        Comparator<IPLDao>maxRunsWithBestAverage=maxRunsComparator.thenComparing(maxAveargeComparator);
        this.iplMapComparator.put(IPLField.MAX_RUNS_WITH_BEST_AVERAGE,maxRunsWithBestAverage);
        Comparator<IPLDao>maxBowlingAverageWithBestStrikingRate=strikingRateComparator.thenComparing(maxAveargeComparator);
        this.iplMapComparator.put(IPLField.GREAT_BOWLING_AVERAGE_BEST_STRIKING_RATE,maxBowlingAverageWithBestStrikingRate);
        Comparator<IPLDao>maxWicktes=Comparator.comparing(iplRuns->iplRuns.wickets);
        Comparator<IPLDao>maxBowlingAverageMaxWkts=maxWicktes.thenComparing(maxAveargeComparator);
        this.iplMapComparator.put(IPLField.MAXIMUM_WICKET_WITH_BEST_BOWLING,maxBowlingAverageMaxWkts);
        Comparator<IPLDao>bowlingAverage=Comparator.comparing(iplRuns->iplRuns.bowlingAverage);
        Comparator<IPLDao>battingAverage=Comparator.comparing(iplRuns->iplRuns.battingAverage);
        Comparator<IPLDao>maximumBowlingAverageAndBattingAverage=bowlingAverage.thenComparing(battingAverage);
        this.iplMapComparator.put(IPLField.MAXIMUM_BATTING_AVERAGE_MAXIMUM_BALLING_AVERAGE,maximumBowlingAverageAndBattingAverage);
        this.iplMapComparator.put(IPLField.MAXIMUM_BATTING_AVERAGE_MAXIMUM_BALLING_AVERAGE,new BatsManBowlerAverageComparator());
        Comparator<IPLDao>maxRuns=Comparator.comparing(iplRuns->iplRuns.runs);
        Comparator<IPLDao>maxWkts=Comparator.comparing(iplRuns->iplRuns.wickets);
        Comparator<IPLDao>maxRunsAndmaxWkts=maxRuns.thenComparing(maxWkts);
        this.iplMapComparator.put(IPLField.MOST_RUNS_AND_HIGH_WICKETS,maxRunsAndmaxWkts);
    }

    public int loadIplData(Player player,String... iplCsvFilePath) throws IPLMatchException {
        iplCSVMap = this.iplMatchAdaptor.loadIplData(player, iplCsvFilePath);
        return iplCSVMap.size();
    }

    public void setAdaptor(IPLMatchAdaptor iplMatchAdaptor){
        this.iplMatchAdaptor=iplMatchAdaptor;
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

