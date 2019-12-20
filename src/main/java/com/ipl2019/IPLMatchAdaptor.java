package com.ipl2019;

import csvbuilder.CSVBuilderException;
import csvbuilder.CSVBuilderFactory;
import csvbuilder.ICSVBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public abstract class IPLMatchAdaptor {

    public abstract  <E> Map<String, IPLDao> loadiplData(String csvFilePath) throws IPLMatchException;

    protected  <E> Map<String, IPLDao> loadiplData(Class<E> censusCSVClass, String csvFilePath) throws IPLMatchException {
        Map<String, IPLDao> iplCSVMap = new HashMap<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> csvFileIterator = icsvBuilder.getCSVFileIterator(reader, censusCSVClass);
            Iterable<E> csvIterable = () -> csvFileIterator;
            if (censusCSVClass.getName().equals("com.ipl2019.IPLRunsCSV")) {
                StreamSupport.stream(csvIterable.spliterator(), false).
                        map(IPLRunsCSV.class::cast).
                        forEach(iplCSV -> iplCSVMap.put(iplCSV.player, new IPLDao(iplCSV)));
            } else if (censusCSVClass.getName().equals("com.ipl2019.IPLWktsCSV")) {
                StreamSupport.stream(csvIterable.spliterator(), false).
                        map(IPLWktsCSV.class::cast).
                        forEach(iplCSV -> iplCSVMap.put(iplCSV.player, new IPLDao(iplCSV)));
            }
            return iplCSVMap;

        } catch (IOException | CSVBuilderException e) {
            throw new IPLMatchException(e.getMessage(),
                    IPLMatchException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new IPLMatchException(e.getMessage(),
                    IPLMatchException.ExceptionType.SUME_ERROR_IN_FILE);
        }
    }
}
