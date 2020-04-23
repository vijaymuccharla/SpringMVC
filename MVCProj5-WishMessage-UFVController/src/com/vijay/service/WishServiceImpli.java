package com.vijay.service;

import java.util.Calendar;

public class WishServiceImpli implements WishService {

	@Override
	public String generateWishMsg() {
		Calendar cal=null;
		int hour=0;
		String msg=null;
		//get System date
		cal=Calendar.getInstance();
		//get current hour of the day
		hour=cal.get(Calendar.HOUR_OF_DAY);
		if(hour<12)
			msg="Good Morning";
		else if(hour<16)
			msg="Good Afternoon";
		else if(hour<20)
			msg="Good Evening";
		else
			msg="Good Night";
		
		return msg;
	}

}
