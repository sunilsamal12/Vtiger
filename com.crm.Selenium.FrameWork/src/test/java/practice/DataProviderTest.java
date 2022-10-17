package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider="dataProvider_test")
	public void bookTicket(String src,String dst) {
		System.out.println("Book ticket from "+src+" to "+dst);
		
	}
	@DataProvider
	public Object[][] dataProvider_test(){
		Object[][] objarr=new Object[5][2];
		objarr[0][0]="Bangalore";
		objarr[0][1]="Goa";
		
		objarr[1][0]="Bangalore";
		objarr[1][1]="Mysore";
		
		objarr[2][0]="Bangalore";
		objarr[2][1]="Mangalore";
		
		objarr[3][0]="Bangalore";
		objarr[3][1]="Mumbai";
		
		objarr[4][0]="Bangalore";
		objarr[4][1]="Kerala";
		
		return objarr;
		
	}

}
