package com.practice.exceptionhandlings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class InvalidDateException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidDateException(String message) {
		super(message);
	}
}

class Cheque {
	String bankName;
	String chequeNumber;
	Date chequeDate;

	public Cheque() {

	}

	public Cheque(String bankName, String chequeNumber, Date chequeDate) {
		this.bankName = bankName;
		this.chequeNumber = chequeNumber;
		this.chequeDate = chequeDate;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	public Date getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

}

class PaymentBO {
	public boolean processPayment(Cheque cheque) throws InvalidDateException {
		SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
		try {
			Date currentDate = formatter.parse("15/05/2017");
			if (cheque.getChequeDate().after(currentDate) || cheque.getChequeDate().compareTo(currentDate) == 0) {
				return true;
			} else if (cheque.getChequeDate().before(currentDate)) {
				throw new InvalidDateException("InvalidDateException: Cheque is valid only for three months");
			} 
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return false;
	}
}

public class InvalidDateExceptionPrgm {

	public static void main(String[] args) throws IOException, ParseException, InvalidDateException {
		try {
			PaymentBO paymentBO = new PaymentBO();
			SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
			formatter.setLenient(false);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the cheque details");
			System.out.println("Enter the bank name :");
			String bankName = br.readLine();
			System.out.println("Enter the cheque number :");
			String chequeNumber = br.readLine();
			System.out.println("Enter the cheque date :");
			Date chequeDate = formatter.parse(br.readLine());
			Cheque cheque = new Cheque(bankName, chequeNumber, chequeDate);
			boolean validate = paymentBO.processPayment(cheque);
			if (validate) {
				System.out.println("Cheque is sent to clearing house");
			} 
		} catch (InvalidDateException e) {
			System.out.println(e.getMessage());
		}

	}

}
