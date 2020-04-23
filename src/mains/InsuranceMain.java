package mains;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import insuranceproject.account.Account;
import insuranceproject.account.AccountManager;
import insuranceproject.account.IndividualAccount;
import insuranceproject.exception.InvalidAuthenticationException;
import insuranceproject.insurancetype.HealthInsurance;
import insuranceproject.insurancetype.Insurance;
import insuranceproject.management.Managment;
import insuranceproject.user.User;

public class InsuranceMain {

	public static void main(String[] args) throws InvalidAuthenticationException {
		
		/*
		 * Projenin Class yapısını yaptım.
		 * Fakat projedeki iş mantığını anlayamadığım için hesaplama işlemlerini boş bıraktım.
		 */
		Managment.run();
	}
}
