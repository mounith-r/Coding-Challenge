package com.zipcode.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zipcode.service.ZipCodeService;

@RestController
public class ZipCodeController {
	private static final Logger logger = LogManager.getLogger(ZipCodeController.class);
	
	@Autowired
	private ZipCodeService zipCoderService;
	
	/**
	 * 
	 * @param zipCodeRanges
	 * @return zipCode Range values
	 */
	@PostMapping("/getZipCodeRanges")
	public List<ArrayList<Integer>> getZipCodeRanges(@RequestBody int[][] zipCodeRanges) {
		try {
			return zipCoderService.getZipCodeRanges(zipCodeRanges);
		}catch(Exception e) {
			logger.error("Exception occured while generating the ZipCode ranges", e);
		}
		return null;
	}
	
}
