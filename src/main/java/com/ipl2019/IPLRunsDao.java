package com.ipl2019;

public class IPLRunsDao
{
    public String player;
    public int match;
    public int century;
    public int fifty;
    public double average;
    public int noOfFours;
    public int noOfSixs;
    public double strikingRate;
    public int runs;

    public IPLRunsDao(IPLRunsCSV iplRunsCsv) {
        if (iplRunsCsv.average.contains("-")) {
            this.average = 0;
        }
        if (!iplRunsCsv.average.contains("-")) {
            this.average = Double.parseDouble(iplRunsCsv.average);
        }
        this.player = iplRunsCsv.player;
        this.strikingRate =Double.parseDouble(iplRunsCsv.strikingRate);
        this.century = Integer.parseInt(iplRunsCsv.century);
        this.fifty = Integer.parseInt(iplRunsCsv.fifty);
        this.noOfSixs = Integer.parseInt(iplRunsCsv.noOfSixs);
        this.noOfFours = Integer.parseInt(iplRunsCsv.noOffours);
        this.runs=Integer.parseInt(iplRunsCsv.runs);
    }
   }

