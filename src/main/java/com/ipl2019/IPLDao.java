package com.ipl2019;

public class IPLDao
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
    public int wkts;
    public int fourWkts;
    public int fiveWkts;
    public double overs;
    public double economy;

    public IPLDao(IPLRunsCSV iplRunsCsv) {
        this.average=Double.parseDouble(iplRunsCsv.average);
        this.player = iplRunsCsv.player;
        this.strikingRate =Double.parseDouble(iplRunsCsv.strikingRate);
        this.century = Integer.parseInt(iplRunsCsv.century);
        this.fifty = Integer.parseInt(iplRunsCsv.fifty);
        this.noOfSixs = Integer.parseInt(iplRunsCsv.noOfSixs);
        this.noOfFours = Integer.parseInt(iplRunsCsv.noOffours);
        this.runs=Integer.parseInt(iplRunsCsv.runs);
        this.match=Integer.parseInt(iplRunsCsv.match);
    }

    public IPLDao(IPLWktsCSV iplWktsCSV) {
        this.average=Double.parseDouble(iplWktsCSV.average);
        this.player = iplWktsCSV.player;
        this.wkts=Integer.parseInt(iplWktsCSV.wkts);
        this.fourWkts=Integer.parseInt(iplWktsCSV.fourWkts);
        this.fiveWkts=Integer.parseInt(iplWktsCSV.fiveWkts);
        this.strikingRate =Double.parseDouble(iplWktsCSV.strikingRate);
        this.runs=Integer.parseInt(iplWktsCSV.runs);
        this.wkts=Integer.parseInt(iplWktsCSV.wkts);
        this.match=Integer.parseInt(iplWktsCSV.match);
        this.overs=Double.parseDouble(iplWktsCSV.overs);
        this.economy=Double.parseDouble(iplWktsCSV.economy);
    }

}

