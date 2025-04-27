package eMP.PACIReader;
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

public class Events implements pacicardlibrary.PaciEventHandler {

	static String civil_ID="";

@Override
public void ReaderChangeEvent() {
System.err.println ("Reader change");
}

@Override
public void CardConnectionEvent (int i) {
 System.err.println ("Card Connected");

 try {
	 System.err.println("17 i=============="+i);
civil_ID = PACIReader.api.getCivil_ID(i, true);
System.err.println("17 11civil_ID=============="+civil_ID);
String arabic_Name = PACIReader.api.getArabic_Name(i, true);
String english_Name = PACIReader.api.getEnglish_Name (i, true);
String card_Serial_No = PACIReader.api.getCard_Serial_No(i, true) ;
PACICardProperties cardProperties = PACIReader.api.GetCardProperties(i) ;
System.err.println (civil_ID);

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

}
