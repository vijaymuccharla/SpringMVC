package com.vj.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service("Wish Message Service")
public class WishMessageServiceImpl implements WishMessageService {

	@Override
	public String getWishMessage() {
		int hour=0;
		String result=null;
		//get current hour of the day
		hour=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		if(hour<12)
			result= "Good Morning";
		else if(hour<16)
			result="Good Afternoon";
		else if(hour<20)
			result="Good Evening";
		else
			result="Good Night, Sweet Dreams";
		
		//return string to Controller
		return result;
	}

}
