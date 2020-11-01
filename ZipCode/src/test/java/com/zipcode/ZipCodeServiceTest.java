package com.zipcode;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zipcode.service.ZipCodeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZipCodeServiceTest {

	@Autowired
	private ZipCodeService zipCodeService;
	
	
	@Test
	public void getZipCodesForNull() {
		int[][] empty =null;
		List<ArrayList<Integer>> zipCodeRanges =  zipCodeService.getZipCodeRanges(empty);
		assertTrue(zipCodeRanges.size()==0);
	}
	
	@Test
	public void getZipCodesForEmpty() {
		int[][] empty = {};
		List<ArrayList<Integer>> zipCodeRanges =  zipCodeService.getZipCodeRanges(empty);
		assertTrue(zipCodeRanges.size()==0);
	}
	
	@Test
	public void getZipCodesForInput1() {
		int[][] empty = {{94133,94133},{94200,94299},{94600,94699}};
		List<ArrayList<Integer>> zipCodeRanges =  zipCodeService.getZipCodeRanges(empty);
		assertTrue(zipCodeRanges.size()==3);
		assertTrue(zipCodeRanges.get(0).get(0) == 94133);
		assertTrue(zipCodeRanges.get(2).get(0) == 94600);
		assertTrue(zipCodeRanges.get(2).get(1) == 94699);
	}
	
	@Test
	public void getZipCodesForInput2() {
		int[][] empty = {{94133,94133},{94200,94299},{94226,94399}};
		List<ArrayList<Integer>> zipCodeRanges =  zipCodeService.getZipCodeRanges(empty);
		assertTrue(zipCodeRanges.size()==2);
		assertTrue(zipCodeRanges.get(0).get(0) == 94133);
		assertTrue(zipCodeRanges.get(1).get(0) == 94200);
		assertTrue(zipCodeRanges.get(1).get(1) == 94399);
	}


	@Test
	public void getZipCodesForInput3() {
		int[][] empty = {{94133,94133},{94226,94399},{94200,94299},{94226,94499}};
		List<ArrayList<Integer>> zipCodeRanges =  zipCodeService.getZipCodeRanges(empty);
		assertTrue(zipCodeRanges.size()==2);
		assertTrue(zipCodeRanges.get(0).get(0) == 94133);
		assertTrue(zipCodeRanges.get(1).get(0) == 94200);
		assertTrue(zipCodeRanges.get(1).get(1) == 94499);
	}

}
