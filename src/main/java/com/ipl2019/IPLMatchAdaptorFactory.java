package com.ipl2019;

public class IPLMatchAdaptorFactory {
    public static IPLMatchAdaptor getIplData(IPLMatch2019.Player player) throws IPLMatchException {
        if(player.equals(IPLMatch2019.Player.BATSMAN))
            return new IPLBatsManAdaptor();
        if(player.equals(IPLMatch2019.Player.BOWLWER))
            return new IPLBowlersAdaptor();
        if(player.equals(IPLMatch2019.Player.MERGE_FILE))
            return new MergeAdaptor();
        throw new IPLMatchException("unknown Player",IPLMatchException.ExceptionType.INVALID_PLAYER);
    }
}
