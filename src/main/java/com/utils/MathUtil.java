package com.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MathUtil {

	    public static int getRandom(int min,int max) {
	        Random random = new Random();
	        int s = random.nextInt(max)%(max-min+1) + min;
	       return s;
	    }
	    public static void main(String[] args){
	    	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	    	for(int i=1;i<=45000;i++){
	    		int price=getPrice();
	    		if(map.containsKey(price)){
	    			int value=map.get(price)+1;
	    			if(price==1)
	    				System.out.println("在第"+i+"次获得一等奖");
	    			map.put(price, value);
	    		}else{
	    			map.put(price, 1);
	    		}
	    	}
	    	
	    	for(Integer key:map.keySet()){
	    		System.out.println(key+"等奖：" + map.get(key));
	    		
	    	}
	    	
	    }
	    
	    public static int getPrice(){
	    	int random=getRandom(1,10000);
	    	int result=0;
	    	if(random==10000){
	    		result=1;
	    	}else if(random>9997 && random<10000){
	    		result=2;
	    	}else if(random>8537 && random<=9997){
	    		result=3;
	    	}else if(random>4420 && random<=8537){
	    		result=4;
	    	}else {
	    		result=5;
	    	}
	    	return result;
	    }
	
}
