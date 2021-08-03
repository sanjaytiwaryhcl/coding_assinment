package com.acme.mytrader.strategy;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import com.acme.mytrader.strategy.TradingStrategy;

public class TradingStrategyTest {
    
 private List<Double> priceList;
 private TradingStrategy tradingStrategy; 
 @Before
 public void init(){
 priceList=new ArrayList<>();
 tradingStrategy=new TradingStrategy(priceList); 
}

@Test
 public void getOrderedSellTest(){
 priceList.add(30.0);
 String sell=tradingStrategy.getOrderPlaced();
 Assert.assertEquals("Sell",sell);
}

@Test
 public void getOrderedBuyTest(){
 priceList.add(20.0);
 String buy=tradingStrategy.getOrderPlaced();
 Assert.assertEquals("Buy",buy);
}

@Test
 public void getOrderedNoUpdateTest(){
 
 tradingStrategy.getOrderPlaced();
 
}


@Test
    public void testNothing() {
    }
  
}
