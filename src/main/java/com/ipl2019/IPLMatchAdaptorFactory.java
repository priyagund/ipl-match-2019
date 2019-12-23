package com.ipl2019;

public class IPLMatchAdaptorFactory {
    public static IPLMatchAdaptor getIplData(IPLMatch2019Analyzer.Player player) throws IPLMatchException {
        if(player.equals(IPLMatch2019Analyzer.Player.BATSMAN))
            return new IPLBatsManAdaptor();
        if(player.equals(IPLMatch2019Analyzer.Player.BOWLWER))
            return new IPLBowlersAdaptor();
        if(player.equals(IPLMatch2019Analyzer.Player.MERGE_FILE))
            return new MergeAdaptor();
        throw new IPLMatchException("unknown Player",IPLMatchException.ExceptionType.INVALID_PLAYER);
    }
}
