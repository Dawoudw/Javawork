package dev.wsd.utils;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public final class PrintUtil {

	public PrintUtil() {

	}

	/**
	 * 
	 * @param text
	 */
	public static void printEmpty() {
		System.out.print("");
	}

	public static void printLnEmpty() {
		System.out.println("");

	}

	public static void drawEqual() {
		System.out.print("=========================================================================================");

	}

	public static void drawEqualLn() {
		System.out.println("=======================================================================================");

	}

	public static void drawHyphen() {
		System.out.print("---------------------------------------------------------");

	}

	public static void drawHyphenLn() {
		System.out.println("---------------------------------------------------------");

	}

	public static void drawUnderscore() {
		System.out.print("____________________________________________________________________________________________");

	}

	public static void drawUnderscoreLn() {
		System.out.println("____________________________________________________________________________________________");

	}
	public static void drawDotsLn() {
		System.out.println("...........................................................................");
		
	}

	/**
	 * 
	 * @param text
	 */

	public static void print(String text) {
		System.out.print(text);

	}

	public static void printLine(String text) {
		System.out.println(text);
	}

	/**
	 * 
	 * @param mesg
	 */
	public static void printMessage(String mesg) {
		System.out.print("System Message: " + mesg);
	}

	/**
	 * 
	 * @param mesg
	 */
	public static void printLineMessage(String mesg) {
		System.out.println("System Message: " + mesg);
	}

	/**
	 * 
	 * @param error
	 */
	public static void printError(String error) {
		System.err.print("Error Message: " + error);
	}

	/**
	 * 
	 * @param error
	 */
	public static void printErrorLine(String error) {
		System.err.println("Error Message: " + error);
		PrintUtil.drawHyphenLn();
	}

	/**
	 * 
	 * @param info
	 */
	public static void printInfo(String info) {
		System.out.print("Info: " + info);
	}

	/**
	 * 
	 * @param text
	 */
	public static void printWarning(String text) {
		System.err.print("Warning: " + text);
	}

	/**
	 * 
	 * @param info
	 */
	public static void printLineInfo(String info) {
		System.out.println("Info: " + info);
	}

	/**
	 * 
	 * @param text
	 */
	public static void printWarningLine(String text) {
		System.err.println("Warning: " + text);
	}

	
}