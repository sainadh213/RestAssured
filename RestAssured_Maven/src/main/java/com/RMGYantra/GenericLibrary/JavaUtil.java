package com.RMGYantra.GenericLibrary;

import java.util.Random;

public class JavaUtil {
	public int getRandomNumber()
	{
		Random rn=new Random();
		int randomNumber = rn.nextInt(2000);
		return randomNumber;
	}

}
