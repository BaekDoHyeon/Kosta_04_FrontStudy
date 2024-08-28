package com.edu.capsul;
//오늘 날짜정보를 저장하는 클래스
public class MyDate {
	
	private int month;
	private int day;
	
	/*
	 * 1~12 에 해당하는 월 값이 들어올때만 필드에 값을 할당
	 * 아니면 에러메시지 출력
	 */
	public void setMonth(int month) {
		if (month >= 1 && month <= 12) this.month = month;
		else errorMsg("Month Error...");
	}
	
	public int getMonth() {
		return month;
	}
	
	/*
	 * 월에 따라서 날짜가 달라진다.
	 * 1,3,5,7,8,10,12월 -> 1~31
	 * 2월 -> 1~28
	 * 4,6,9,11월 -> 1~30
	*/
	public void setDay(int day) {
		switch(month) {
		case 4:
		case 6:
		case 9:
		case 11: 
			if (day >= 1 && day <= 30) this.day = day;
			else errorMsg("Day Error...");
			break;
	
		case 2:
			if (day >= 1 && day <= 28) this.day = day;
			else errorMsg("Day Error...");
			break;
		
		default:
			if (day >= 1 && day <= 31) this.day = day;
			else errorMsg("Day Error...");
		}
	}
	
	//에러메시지를 출력하는 기능을 추가
	private void errorMsg(String msg) {
		System.out.printf("[에러] %s",msg);
		System.exit(0);
	}
	
	public int getDay() {
		return day;
	}

}
