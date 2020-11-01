package com.zipcode.service;

import java.util.ArrayList;
import java.util.List;

public interface ZipCodeService {

	List<ArrayList<Integer>> getZipCodeRanges(int[][] zipCodeRanges);
}
