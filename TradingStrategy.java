package com.acme.mytrader.strategy;

import java.util.List;
import com.acme.mytrader.price.PriceListener;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy {
//TODO:threasholdprice setting ,can be configured in property file
private double threasholdPrice=25.0;
//Specify buy or sell order
private String orderType="";
//updated price from upstream on the basis of regula polling
private List<Double> priceList=null;

//Initialise parameterised Constructor
public TradingStrategy(List<Double> priceList){
this.priceList=priceList;
}
/**
 * Notify price breach  and placed order on the basis of price
 *
 *@return  orderType
 */
public String getOrderPlaced(){
PriceListener priceUpdate=(security,updatedPrice) ->{
 try{
   if(getUpdatedPrice()){
   // TODO: sell Order  logic will be called here 
   //TODO:Replace S.O.P with Logger
   System.out.println(" Sell Order has been placed Successfully for : "+security);
orderType="Sell";
}else{
  // TODO: Buy Order  logic will be called here
 //TODO: Replace S.O.P with Logger
System.out.println(" Buy Order has been placed Successfully for : "+security);
orderType="Buy";
}
}catch(Exception e){
//Meaningfull message can be displayed using logger
}
};
//Initialise method argument, we can pass variable 
priceUpdate.priceUpdate("Reliance",5.0)
return orderType;
}
/**
 *
 * Get updated pricelist and check pricebreach
 * @ return boolean whether price list breach 
 */
private boolean getUpdatedPrice(){
if(priceList.size()!=0 && priceList!=null){
for(double price: getPriceList()){
 if(price>=threasholdPrice){
// assign updated price
 return true;
}
}
}else{
throw new RuntimeException("Pricelist is blank");
}
return false;
}

private List<Double> getPriceList(){
  // TODO: assign pricelist to another arraylist to make immutable
 return priceList;
}
}
