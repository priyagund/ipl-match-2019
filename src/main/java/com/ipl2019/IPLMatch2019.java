package com.ipl2019;

import com.google.gson.Gson;
import csvbuilder.CSVBuilderException;
import csvbuilder.CSVBuilderFactory;
import csvbuilder.ICSVBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toCollection;

public class IPLMatch2019 {

    Map<String, IPLDao> iplRunsCSVMap;

    Map<IPLField,Comparator<IPLDao>>iplWktsMapComparator;
    Map<IPLField, Comparator<IPLDao>> iplRunsMapComparator;
    Map<String, IPLDao>iplWktsCSVMap ;

    public IPLMatch2019() {
        this.iplRunsCSVMap = new HashMap<>();
        this.iplRunsMapComparator = new HashMap<>();
        this.iplWktsCSVMap= new HashMap<>();
        this.iplRunsMapComparator.put(IPLField.AVERAGE, Comparator.comparing(iplrun->iplrun.average));
        this.iplRunsMapComparator.put(IPLField.STRIKING_RATE,Comparator.comparing(iplrun->iplrun.strikingRate));
        this.iplRunsMapComparator.put(IPLField.MAX_SIX_AND_FOURS,new SortedOnMaxFoursAndSixes());
        Comparator<IPLDao> strikingRateComparator = Comparator.comparing(iplrun -> iplrun.strikingRate);
        Comparator<IPLDao> fourSixsComparator= new SortedOnMaxFoursAndSixes();
        Comparator<IPLDao> maxStrikingRateWithMaxSixesAndMaxFours= fourSixsComparator.thenComparing(strikingRateComparator);
        this.iplRunsMapComparator.put(IPLField.STRIKINRATE_MAX_SIX_AND_FOURS, maxStrikingRateWithMaxSixesAndMaxFours);
        Comparator<IPLDao> maxAveargeComparator=Comparator.comparing(iplRuns->iplRuns.average);
        Comparator<IPLDao>maxStrikingRateWithMaxAverage=maxAveargeComparator.thenComparing(strikingRateComparator);
        this.iplRunsMapComparator.put(IPLField.MAX_STRIKINRATE_MAX_AVERAGE, maxStrikingRateWithMaxAverage);
        Comparator<IPLDao>maxRunsComparator=Comparator.comparing(iplRuns->iplRuns.runs);
        Comparator<IPLDao>maxRunsWithBestAverage=maxRunsComparator.thenComparing(maxAveargeComparator);
        this.iplRunsMapComparator.put(IPLField.MAX_RUNS_WITH_BEST_AVERAGE,maxRunsWithBestAverage);

    }

    public int loadIplPlayersRunsRecord(String ipl_runs_record_file) throws IPLMatchException {

            try (Reader reader = Files.newBufferedReader(Paths.get(ipl_runs_record_file));) {
                ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
                Iterator<IPLRunsCSV> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLRunsCSV.class);
                Iterable<IPLRunsCSV> csvIterable = () -> csvFileIterator;
                StreamSupport.stream(csvIterable.spliterator(), false)
                    .map(IPLRunsCSV.class::cast)
                    .forEach(iplRunsCSV -> iplRunsCSVMap.put(iplRunsCSV.player, new IPLDao(iplRunsCSV)));
                return iplRunsCSVMap.size();
        } catch (IOException | CSVBuilderException e) {
                throw new IPLMatchException(e.getMessage(),
                        IPLMatchException.ExceptionType.FILE_NOT_FOUND);
            } catch (RuntimeException e) {
                throw new IPLMatchException(e.getMessage(),
                        IPLMatchException.ExceptionType.SUME_ERROR_IN_FILE);
            }
        }

    public int loadIplPlayersWktsRecord(String ipl_Wkts_record_file) throws IPLMatchException {

        try (Reader reader = Files.newBufferedReader(Paths.get(ipl_Wkts_record_file))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IPLWktsCSV> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLWktsCSV.class);
            Iterable<IPLWktsCSV> csvIterable = () -> csvFileIterator;
            StreamSupport.stream(csvIterable.spliterator(), false)
                    .map(IPLWktsCSV.class::cast)
                    .forEach(iplWktsCSV  -> iplWktsCSVMap.put(iplWktsCSV.player, new IPLDao(iplWktsCSV)));
            return iplWktsCSVMap.size();
        } catch (IOException | CSVBuilderException e) {
            throw new IPLMatchException(e.getMessage(),
                    IPLMatchException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new IPLMatchException(e.getMessage(),
                    IPLMatchException.ExceptionType.SUME_ERROR_IN_FILE);
        }
    }

    public String sortedByGivenField(IPLField fieldName) throws IPLMatchException {
        if (iplRunsCSVMap == null || iplRunsCSVMap.size() == 0) {
            throw new IPLMatchException("no ipl data", IPLMatchException.ExceptionType.NO_DATA_FOUND);
        }
        ArrayList iplList = iplRunsCSVMap.values().stream()
                .sorted(this.iplRunsMapComparator.get(fieldName))
                .collect(toCollection(ArrayList::new));
        String sortedIplRunsJson = new Gson().toJson(iplList);
        return sortedIplRunsJson;
    }

}

