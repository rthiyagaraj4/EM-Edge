/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
*/
package HL7Simulator.Common ;

public class MessageTokenizer
{
//MSH|^~\&|MEDICOM|GET-WELL HOSPITAL|TEST APPLICATION||20030315101732||ADT^A04|1736|P|2.3.1|||NEEVN|A04|20020828120605||||20030315101732
//PID|||TN06501283||JOSE^^^||200103150000|M||||||||||TN06501283||||||||0027^SOUTH AFRICA (N.P)||||PV1||O||IV|||^||||||||||||50104099V1|CP||||||||||||||||||||||||200303151017||

	public String strMessageBox[] ;
	String strPartialMessage="";
	
	String strEndMessage=""+((char)13)+((char)28)+((char)13);
	String strHeader = "MSH";
	String strStartBlock = ""+((char)11);
	String strStartMessage = "";

	public int intTotMessage;
	String strMessageControlId = "";
	String strApplicationId = "";		
	
	public MessageTokenizer()
	{
		strStartMessage=strStartBlock+strHeader;
	}
	public void getTokenizedMessage(String msg)
	{
		intTotMessage = 0;
		int intStart = 0;
		int intEnd =0;

		String strTotalMessage="";		
			
		strTotalMessage = strPartialMessage+msg;
		strMessageBox = new String[30];
					
		System.out.println( "msg:"+msg );
		System.out.println( "strTotalMessage:"+strTotalMessage );
		while(true)
		{
			try
			{	
				intStart = strTotalMessage.indexOf(strStartMessage,intStart);
				intEnd  = strTotalMessage.indexOf(strEndMessage,intEnd);
				System.out.println( "intStart:"+intStart );
				System.out.println( "intEnd:"+intEnd );
			}
			catch(Exception exceptionGeneral)
			{
				System.out.println(" Error Exception "+exceptionGeneral);
			}
			if ((intStart>=0) && (intEnd>0))	
			{
				strPartialMessage = "";
				strMessageBox[intTotMessage] = strTotalMessage.substring(intStart,intEnd+3);
				++intTotMessage;
			}
			else if ((intStart>0)&&(intEnd<0))
			{
				// Initial Partial Message;
				strPartialMessage = strTotalMessage.substring(intStart);
				break;
			}
			else if ((intStart<0)&&(intEnd>0))
			{
				// Final Partial Message
				System.out.println(" Serious Condition ");
				break;
			}
			else if ((intStart<0)&&(intEnd<0))
			{
				// Middle Segment
				if (intTotMessage==0)
				{
					strPartialMessage = strTotalMessage;
				}
				break;
			}
			++intStart;
			++intEnd ;			
		}		// End of While True Loop
	}
}												