package com.zipcode.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zipcode.service.ZipCodeService;

@Service
public class ZipCodeServiceImpl implements ZipCodeService{

	/**
	 * @param zipCodeRanges
	 * return zipcode ranges
	 */
	@Override
	public List<ArrayList<Integer>> getZipCodeRanges(int[][] zipCodeRanges) {
		List<ArrayList<Integer> > ranges = new ArrayList<ArrayList<Integer> >(); 
		if(zipCodeRanges == null || zipCodeRanges.length<=0) {
			return ranges;
		}
		sortbyColumn(zipCodeRanges, 0);
		List<Integer> previousRanges = new ArrayList<Integer>();
		previousRanges.add(zipCodeRanges[0][0]);
		previousRanges.add(zipCodeRanges[0][1]);
		for(int i=1;i<zipCodeRanges.length;i++) {
			compareRanges(previousRanges,zipCodeRanges[i][0], zipCodeRanges[i][1], ranges);
		}
		ranges.add(new ArrayList<Integer>(Arrays.asList(previousRanges.get(0),previousRanges.get(1))));
		return ranges;
	}
	
	/**
	 * 
	 * @param previousRanges
	 * @param currentStartRange
	 * @param currentEndRange
	 * @param ranges
	 * 
	 * Compare ranges between previous and current one
	 */
	private void compareRanges(List<Integer> previousRanges,int currentStartRange, int currentEndRange, List<ArrayList<Integer>> ranges) {
		if(previousRanges.get(1) <= currentStartRange ) {
			ranges.add(new ArrayList<Integer>(Arrays.asList(previousRanges.get(0), previousRanges.get(1))));
			previousRanges.set(0, currentStartRange) ;
			previousRanges.set(1, currentEndRange)  ;
		}else if(currentEndRange > previousRanges.get(1)){
			previousRanges.set(1, currentEndRange) ;
		}
	}
	
	/**
	 * 
	 * @param zipCodeRanges
	 * @param column
	 * 
	 * sort based on specific column
	 */
	private static void sortbyColumn(int zipCodeRanges[][], int column) { 
        Arrays.sort(zipCodeRanges, new Comparator<int[]>() { 
            
       	// Compare values according to columns 
          @Override              
          public int compare(final int[] first, final int[] second) { 
  
            // To sort in descending order 
            if (first[column] > second[column]) 
                return 1; 
            else
                return -1; 
          } 
        });  
    } 
	
}
