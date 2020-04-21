package dev.wsd.utils;

import java.util.Scanner;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public final class ScannerUtil {

	public ScannerUtil(){

	}
 

	public static Scanner singleScan(){
		return  new Scanner(System.in);
	}

	public static Scanner continuesScan(){
		return null;
	}

	/**
	 * 
	 * @param inlineText
	 */
	public static Scanner continuesScan(String inlineText){
		return null;
	}

	/**
	 * 
	 * @param inlineText
	 */
	public static Scanner singleScan(String inlineText){
		return null;
	}

}