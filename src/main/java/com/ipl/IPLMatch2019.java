package com.ipl;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class IPLMatch2019
{

    public int loadIplPlayersRecord(String ipl_runs_record_file) throws IPLMatchException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(ipl_runs_record_file)); CsvToBeanBuilder<IPLRunsCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IPLRunsCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IPLRunsCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IPLRunsCSV> censusCSVIterator = csvToBean.iterator();
            Iterable<IPLRunsCSV> csvIterable = () -> censusCSVIterator;
            int numOfPlayers = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
            return numOfPlayers;

        } catch (IOException e) {
            throw new IPLMatchException(e.getMessage(),IPLMatchException.ExceptionType.FILE_NOT_FOUND);
        }

    }
}
