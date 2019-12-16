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

    Map<String, IPLRunsDao> iplRunsCSVMap = null;
    Map<IPLField, Comparator<IPLRunsDao>> iplRunsMapComparator = null;

    public IPLMatch2019() {
        this.iplRunsCSVMap = new HashMap<>();
        this.iplRunsMapComparator = new HashMap<>();
        this.iplRunsCSVMap = new HashMap<>();
        this.iplRunsCSVMap = new HashMap<>();
        iplRunsMapComparator.put(IPLField.AVERAGE, Comparator.comparing(iplrun->iplrun.average));

    }

    public int loadIplPlayersRecord(String ipl_runs_record_file) throws IPLMatchException {

            try (Reader reader = Files.newBufferedReader(Paths.get(ipl_runs_record_file));) {
                ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
                Iterator<IPLRunsCSV> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLRunsCSV.class);
                Iterable<IPLRunsCSV> csvIterable = () -> csvFileIterator;
                StreamSupport.stream(csvIterable.spliterator(), false)
                    .map(IPLRunsCSV.class::cast)
                    .forEach(iplRunsCSV -> iplRunsCSVMap.put(iplRunsCSV.player, new IPLRunsDao(iplRunsCSV)));
                return iplRunsCSVMap.size();
        } catch (IOException | CSVBuilderException e) {
                throw new IPLMatchException(e.getMessage(),
                        IPLMatchException.ExceptionType.FILE_NOT_FOUND);
            } catch (RuntimeException e) {
                throw new IPLMatchException(e.getMessage(),
                        IPLMatchException.ExceptionType.SUME_ERROR_IN_FILE);
            }
        }


    public String sortedByTopBattingRate(IPLField fieldName) throws IPLMatchException {
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

