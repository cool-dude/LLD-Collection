package com.joy.bowlingalley.factory;
import com.joy.bowlingalley.model.Bonus;
import com.joy.bowlingalley.strategy.DefaultStrategy;
import com.joy.bowlingalley.strategy.SparseStrategy;
import com.joy.bowlingalley.strategy.Strategy;
import com.joy.bowlingalley.strategy.StrikeStrategy;
public class BonusFactory {
    public static Strategy getStrategy(Bonus bonus){
        if(bonus.equals(Bonus.SPARE)){
            return new SparseStrategy();
        } else if(bonus.equals(Bonus.STRIKE)){
            return new StrikeStrategy();
        }else {
            return new DefaultStrategy();
        }
    }
}