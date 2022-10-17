package com.crm.Generic_Utilities;

import java.util.Random;
/**
 * its used for dulpicate value
 * @author sunil
 *
 */
public class Java_Utility {
	public int getRandomNum() {
		Random ran=new Random();
		int RanNum=ran.nextInt(1000);
		return RanNum;
	}

}
