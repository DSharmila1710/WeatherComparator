package com.testvagrant.WeathreComparator.Compare;

import java.util.Comparator;

import com.testvagrant.Utils.Utils;
public class CompareWeatherLogic extends Utils implements Comparator<Float> {
	
	
	//Logic to compare
	public int compare(Float tempUsingAPI, Float tempUsingUI) {
		float difference;
		if(tempUsingAPI>=tempUsingUI) {
			difference = tempUsingAPI - tempUsingUI ;
		}else {
			difference = tempUsingUI - tempUsingAPI;
		}
		return Math.round(difference);
	}

	//logic for variance
	public float variance(Float tempUsingAPI, Float tempUsingUI) {
		Float[] arr = new Float[2];
		arr[0]=tempUsingAPI;
		arr[1]=tempUsingUI;
		
		Float mean = (tempUsingAPI+tempUsingUI)/2;
		float variance = 0 ;
		for(int i=0;i<arr.length;i++) {
			variance += (arr[i]-mean)*(arr[i]-mean);
		}
		variance /= arr.length;
		return variance;
	}

}
