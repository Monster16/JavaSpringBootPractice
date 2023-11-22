package com.assignment.assignmentPractice.serviceImpl;

import org.springframework.stereotype.Service;

import com.assignment.assignmentPractice.handler.NotValidCreditCardHandler;
import com.assignment.assignmentPractice.service.Assignmnet_4_Service;


@Service
public class Assignment_4_ServiceImpl implements Assignmnet_4_Service{

	@Override
	public String validateCreditCard(String cardNumber) {
		// TODO Auto-generated method stub
		int len = cardNumber.length();
		for(char c : cardNumber.toCharArray()) {
			if(!(c >= '0' && c <= '0')) {
				throw new NotValidCreditCardHandler("Card Number should contain only numbers");
			}
		}
		if(len < 15) {
			throw new NotValidCreditCardHandler("Length of credit card is too less");
		}
		if(len > 19) {
			throw new NotValidCreditCardHandler("Length of credit card is too more");
		}
		if(len==15) {
			int x = (cardNumber.charAt(0)-'0')*1000 + (cardNumber.charAt(1)-'0')*100 + (cardNumber.charAt(2)-'0')*10 + (cardNumber.charAt(3)-'0');
			if(x==2014 || x== 2149) {
				return "enRoute";
			}
		}
		if(len>=16 && len <=19) {
			if(cardNumber.charAt(0)=='4') {
				return "visa";
			}
			int x = (cardNumber.charAt(0)-'0')*1000 + (cardNumber.charAt(1)-'0')*100 + (cardNumber.charAt(2)-'0')*10 + (cardNumber.charAt(3)-'0');
			if(x>=3528 && x<3589) {
				return "JCB";
			}
			System.out.println(x);
			x=(x*10) + (cardNumber.charAt(4)-'0');
			x=(x*10) + (cardNumber.charAt(5)-'0');
			System.out.println(x);
			if((x>=601100 && x<=601109)||(x>=601120 && x<=601149)||(x>=601177 && x<=601179)||(x>=601186 && x<=601199)||(x>=604000 && x<=659999) || x==601174) {
				return "Discover";
			}
			if((cardNumber.charAt(0)=='5' && (cardNumber.charAt(1)>='1' && cardNumber.charAt(1)<='5')) && (x>=510000 && x<559999)) {
				return "Mastercard";
			}
			if((cardNumber.charAt(0)=='2' && (cardNumber.charAt(1)>='2' && cardNumber.charAt(1)<='7')) && (x>=222100 && x<272099)) {
				return "Mastercard";
			}
		}
		
		throw new NotValidCreditCardHandler("Not a Valid Credit card");
		
		
	}

}
