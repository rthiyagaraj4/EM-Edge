package eMP.PACIReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import pacicardlibrary.PACICardAPI;
import pacicardlibrary.PaciException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Proxy;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;

import pacicardlibrary.PACICardProperties;
import pacicardlibrary.PaciException;

public class PACIReader 
{
	public static PACICardAPI api;
	 public static String input = "Hello";
	 public static String civil_ID = "";
	 public static String full_name = "";
	 public static String birth_date = "";
		public static String expiry_date = "";
		public static String nationality = "";
		public static String sex = "";
		public static String blood_group = "";
		public static String passport = "";
	public static void main(String[] args)
	{
		
		System.out.println("13 main==============");
		try
		{
			api=new PACICardAPI();
			System.err.println("17 api=============="+api);
			Events events= new Events();
			System.err.println("19 events=============="+events);
			api.AddEventListener(events);
			
		}
	catch(PaciException Ex)
		{
	//	System.err.println("17 Ex=============="+Ex);
		System.err.println("17 Ex1=============="+PACIReader.class.getName());
		//Logger.getLogger(PACIReader.class.getName()).log(Level.SEVERE,null, Ex);
		}
		
	}
	public static StringBuilder getCardReaderValues()
	{
		 StringBuilder str = new StringBuilder();
		try
		{
			api=new PACICardAPI();
			System.err.println("17 api=============="+api);
			Events events= new Events();
			System.err.println("19 events=============="+events);
			api.AddEventListener(events);
		//	String civil_ID = PACIReader.api.getCivil_ID(1, true);
			//System.err.println("17 11civil_ID=============="+civil_ID);
			System.err.println("19*************");
			//	String[] reader =PACIReader.api.GetReaders();
				System.err.println("19 222*************");
				Thread.sleep(8000);
				 civil_ID = PACIReader.api.getCivil_ID(0, true);	
					System.err.println("19 2221*************");
				full_name = PACIReader.api.getEnglish_Name(0, true);
				System.err.println("19 2222*************");
				birth_date = PACIReader.api.getBirth_Date(0, true);
				System.err.println("19 2223*************");
				expiry_date = PACIReader.api.getCard_Expiry_Date(0, true);
				System.err.println("19 2224*************");
				nationality = PACIReader.api.getNationalty_Latin_Text(0, true);
				System.err.println("19 2225*************");
				sex = PACIReader.api.getSex_Latin_Text(0, true);
				System.err.println("19 2226*************");
				blood_group = PACIReader.api.getBlood_Type(0, true);
				passport = PACIReader.api.getPassport(0, true);
				System.err.println("17 11civil_ID=============="+civil_ID);
				System.err.println("17 full_name=============="+full_name);
				System.err.println("17 birth_date=============="+birth_date);
				System.err.println("17 expiry_date=============="+expiry_date);
				System.err.println("17 nationality=============="+nationality);
				System.err.println("17 sex=============="+sex);
				System.err.println("17 blood_group=============="+blood_group);
				System.err.println("17 passport=============="+passport);
				//int nos=api.GetNumberOfReaders();
			
				 str.append(civil_ID +"$");
				 str.append(full_name+"$");
				 str.append(birth_date+"$");
				 str.append(expiry_date+"$");
				 str.append(nationality+"$");
				 str.append(sex+"$");
				 str.append(blood_group+"$");
				 str.append(passport);
				//System.err.println("19 nos=============="+nos);
		}
	catch(Exception Ex)
		{
		System.err.println("17 Ex1=222=jj============"+PACIReader.class.getName());
		System.err.println("17 Exj=============="+Ex);
		str.append("NullPointerException");
		
		//Logger.getLogger(PACIReader.class.getName()).log(Level.SEVERE,null, Ex);
		}
	return str;
	}
	public static int calculate()
	{
		System.err.println("17 calculate called==============");
	return 1;
	}
/*

@Override
public void ReaderChangeEvent() {
System.err.println ("Reader change");
}

@Override
public void CardConnectionEvent (int i) {
 System.err.println ("Card Connected");

 try {

//String civil_ID = PACIReader.api.getCivil_ID(i, true);
	// civil_ID="ddddddddddddddddddd";
//System.err.println("17 11civil_ID=============="+civil_ID);
String arabic_Name = PACIReader.api.getArabic_Name(i, true);
String english_Name = PACIReader.api.getEnglish_Name (i, true);
String card_Serial_No = PACIReader.api.getCard_Serial_No(i, true) ;
PACICardProperties cardProperties = PACIReader.api.GetCardProperties(i) ;
//System.err.println (civil_ID);

System.err.println (arabic_Name) ;

System.err.println (english_Name);

System.err.println (card_Serial_No) ;

System.err.println(cardProperties.toJSONString()) ;

 } catch (Exception ex) {
	 System.err.println ("Card Connected=====" +ex);
//Logger.getLogger(Events.class.getName()).1og(Level.SEVERE, null, ex);
 }
}

@Override
 public void CardDisconnectionEvent (int i) {
	System.out.println("Card Disconnected");

}
*/

}