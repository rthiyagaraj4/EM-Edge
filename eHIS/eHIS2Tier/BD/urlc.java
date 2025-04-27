import java.net.*;
import java.io.*;


public class urlc implements Runnable
{

Thread thr;
String url ="";

public void run()
	{
	try
	{		  
	loadURL();		
	}
	catch(Exception ee)		{	}
	}

public void setURL(String arg)
	{
	url = arg;
	}

public void exploreURL()
	{
	thr=new Thread(this);
	thr.start();
	}


private void loadURL()
	{
	try
		{
String result="";
URL reportUrl = new URL( url ) ;
URLConnection urlConnection = reportUrl.openConnection(); 
BufferedReader br = new BufferedReader(
					new InputStreamReader(
					urlConnection.getInputStream()
										) ) ;
						String line = "" ;
						String output = "" ;

						while( (line = br.readLine() ) != null ) {
							output = output + line ;
						}

						int start = output.indexOf( "<PRE>" ) ;
						int end   = output.lastIndexOf( "</PRE>" ) ;

						if ( start != -1 ) {
							String error = output.substring( start+5, end ) ;
							result += error ;
						}					

					br.close();	
		}
		catch(Exception ee)
		{
		}
	}


/*public static void main(String arg[])
 {
//	System.out.println("enter here");
try
 {
urlc xx=new urlc();
xx.setURL("http://130.78.242.80:7778/reports/rwservlet?report=BDRLBPRN+userid=APPLUSER/appluser@SRDV+server=rep_indbgl-10grep_10gRep_Rel2+destype=cache+desformat=pdf+recursive_load=no+P_FACILITY_ID=HS+P_PGM_ID=BDRSCRLB+P_FM_UNIT_NO=CSIR080000408+P_FM_PRODUCT_CODE=01+P_LANGUAGE_ID=en");
xx.exploreURL();
xx.setURL("http://130.78.242.80:7778/reports/rwservlet?report=BDRLBPRN+userid=APPLUSER/appluser@SRDV+server=rep_indbgl-10grep_10gRep_Rel2+destype=cache+desformat=pdf+recursive_load=no+P_FACILITY_ID=HS+P_PGM_ID=BDRSCRLB+P_FM_UNIT_NO=CSIR080000408+P_FM_PRODUCT_CODE=01+P_LANGUAGE_ID=en");
xx.exploreURL();
xx.setURL("http://130.78.242.80:7778/reports/rwservlet?report=BDRLBPRN+userid=APPLUSER/appluser@SRDV+server=rep_indbgl-10grep_10gRep_Rel2+destype=cache+desformat=pdf+recursive_load=no+P_FACILITY_ID=HS+P_PGM_ID=BDRSCRLB+P_FM_UNIT_NO=CSIR080000408+P_FM_PRODUCT_CODE=01+P_LANGUAGE_ID=en");
xx.exploreURL();
xx.setURL("http://130.78.242.80:7778/reports/rwservlet?report=BDRLBPRN+userid=APPLUSER/appluser@SRDV+server=rep_indbgl-10grep_10gRep_Rel2+destype=cache+desformat=pdf+recursive_load=no+P_FACILITY_ID=HS+P_PGM_ID=BDRSCRLB+P_FM_UNIT_NO=CSIR080000408+P_FM_PRODUCT_CODE=01+P_LANGUAGE_ID=en");
xx.exploreURL();
System.out.println("completed");

}
catch(Exception ee)
 {
	System.out.println("Exception ee "+ee);
}
}*/

}

