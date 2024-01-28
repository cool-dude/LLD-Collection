/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.cricscore.concrete;

import com.pc.cricscore.model.Balls;
import com.pc.cricscore.model.Innings;

/*Cricket Dashboard scorecard*/
public class CricketMatch {

    public enum State {
        NOT_STARTED, IN_PROGRESS, COMPLETED
    }

    private final State state;
    private final Innings currentInnings;
    private final Balls balls;
    private final MatchResult result;

}