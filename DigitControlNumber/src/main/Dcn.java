package main;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Dcn 
{
	String Gender;
	String DOB;
	int AreaCode;
	String FRecident;
	String NonRecident;
	
	public Dcn(String initGender,String initDOB,int initAreaCode,String initFRecident,String initNonRecident) {
		Gender=initGender;
		DOB= initDOB;
		AreaCode = initAreaCode;
		FRecident = initFRecident;
		NonRecident = initFRecident;
		
	}
	
	public void Display(String rnd, LocalDate localDate) {
		
		if(this.AreaCode < 01 || this.AreaCode > 53){
            System.out.print("Invalid input for Area Code.\nEnter the number Area Code (between 01-52):");
            }else {
		String gendervalue = null;
		LocalDate MyDate = localDate ;
		
		int year = MyDate.getYear();
		String s=Integer.toString(year);
		String substring = s.substring(s.length() - 2);
		//System.out.println("year:"+ substring);
		
		int monthvalue = localDate.getMonthValue();
		//System.out.println(monthvalue);
		String monthval = String.format("%02d", monthvalue);
		

		int dayOfMonth = localDate.getDayOfMonth();
		//System.out.println(dayOfMonth);
		//String D=Integer.toString(dayOfMonth);
		String  D = String.format("%02d", dayOfMonth);
		//System.out.println(D);
		
		String Area= Integer.toString(this.AreaCode);
		//System.out.println(Area);
		
		if(this.FRecident.equalsIgnoreCase("Y")&&this.Gender.equalsIgnoreCase("M")) {
			 gendervalue ="7";
		}else if(this.NonRecident.equalsIgnoreCase("Y")&& this.FRecident.equalsIgnoreCase("N")){
			 gendervalue ="9";
		}
		else if(this.FRecident.equalsIgnoreCase("Y")&&this.Gender.equalsIgnoreCase("F")) {
			 gendervalue ="8";
		}
		else if(this.Gender.equalsIgnoreCase("M") && MyDate.isAfter(LocalDate.parse("1900-01-01")) && MyDate.isBefore(LocalDate.parse("1999-12-31"))) {
			 gendervalue ="1";}
		else if (this.Gender.equalsIgnoreCase("F") && MyDate.isAfter(LocalDate.parse("1900-01-01")) && MyDate.isBefore(LocalDate.parse("1999-12-31"))) {
		     gendervalue ="2";
		}
		else if(this.Gender.equalsIgnoreCase("M") && MyDate.isAfter(LocalDate.parse("1800-01-01")) && MyDate.isBefore(LocalDate.parse("1899-12-31"))) {
			 gendervalue ="3";}
		else if (this.Gender.equalsIgnoreCase("F") && MyDate.isAfter(LocalDate.parse("1800-01-01")) && MyDate.isBefore(LocalDate.parse("1899-12-31"))) {
		     gendervalue ="4";
		}
		else if(this.Gender.equalsIgnoreCase("M") && MyDate.isAfter(LocalDate.parse("2000-01-01")) && MyDate.isBefore(LocalDate.parse("2099-12-31"))) {
			 gendervalue ="5";}
		else if (this.Gender.equalsIgnoreCase("F") && MyDate.isAfter(LocalDate.parse("2000-01-01")) && MyDate.isBefore(LocalDate.parse("2099-12-31"))) {
		     gendervalue ="6";
		}
		
		else {
			System.out.println("wrong Input Value for date enter again");
		}
		String cnp= gendervalue+substring+monthval+D+Area+rnd;
		System.out.println(cnp);
		
		util.Multiply(cnp);
        }
	}
	public Dcn() {
    	
    }
    
	public static void main(String[]args){
    	Scanner in = new Scanner(System.in);
		System.out.println("Input Toal Number of user Data :");
		int n = Integer.parseInt(in.nextLine().trim());
		Dcn user = new Dcn();
		for (int i = 1; i <= n; i ++) {
			System.out.println("Input user Details:"+ i);
			System.out.println("Your Gender M/F:");
			user.Gender = in.next();
			System.out.println("Your DOB dd.MM.yyyy:");
			String MYDate = user.DOB = in.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "dd.MM.yyyy" );
			LocalDate localDate = LocalDate.parse( MYDate , formatter );
			System.out.println(localDate);
			System.out.println("Your Area Code:Area Code (between 01-52)");
			user.AreaCode = in.nextInt();
	        System.out.println("Are you Foreign Recident in Romania Y/N:"); 
			user.FRecident = in.next();
			System.out.println("Are you Non-Recident in Romania Y/N:"); 
			user.NonRecident = in.next();
			String RandomNumber= (util.getRandomNumberString());
			//System.out.println(RandomNumber);
			user.Display(RandomNumber,localDate);
			
		}
	}

}
	