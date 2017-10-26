package com.practice.iosw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class InvoiceBO {
	public void findAllRejectedPayments(String inputfile, String outputfile) {
		String sCurrentLine, splitStr[];
		int lineNo = 1;
		List<String> sList = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(inputfile))) {
			while ((sCurrentLine = br.readLine()) != null) {
				splitStr = sCurrentLine.split(",");
				if (splitStr[6].equalsIgnoreCase("Rejected")) {
					sList.add(splitStr[0] + "," + splitStr[2] + "," + splitStr[1] + "," + splitStr[5] + ","
							+ splitStr[6]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputfile))) {
			for (String str : sList) {
				bw.write(str);
				if (lineNo != sList.size())
					bw.newLine();
				lineNo++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class DisplayRejectedPayments {

	private static final String INPUTFILE = "src/test/java/com/practice/iosw/rejectin.txt";
	private static final String OUTPUTFILE = "src/test/java/com/practice/iosw/rejectout.txt";

	public static void main(String[] args) throws IOException {
		InvoiceBO invoiceBO = new InvoiceBO();
		invoiceBO.findAllRejectedPayments(INPUTFILE, OUTPUTFILE);
		System.out.println("Output file created");
	}

}
