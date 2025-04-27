package HL7Engine.OutboundProcess ;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;

import HL7Engine.Common.Common;
import HL7Engine.Common.MessageTokenizer;

public class OutboundRs232Communication extends Thread
{
	Common common = Common.getInstance();
	OutboundClientDBInteraction clientDB;
	MessageTokenizer messageTokenizer = null;

	String strMessage ;
	String strDirName;

	String strOutFileName ="";
	String strExtension=".hl7";

	boolean logToFile ;
	String strLogFile ;
	String strExceptionLogFile ;
	int intStart = 0;

	static Enumeration portList;
	static CommPortIdentifier portId;
	static SerialPort serialPort;

	InputStream inputStream;
	OutputStream outputStream;

	public OutboundRs232Communication()
	{
	}

	//constructor 
	public OutboundRs232Communication(boolean logToFile, String strLogFile, String strExceptionLogFile, OutboundClientDBInteraction clientDB)
	{
		this.logToFile = logToFile;
		this.strLogFile = strLogFile;
		this.strExceptionLogFile = strExceptionLogFile;
		this.clientDB = clientDB;
	}//

	public boolean checkRsCommunicationStatus()
	{
		try
		{	
			boolean foundport=false;
			portList = CommPortIdentifier.getPortIdentifiers();
			System.out.println("RS232 PORT");
			while (portList.hasMoreElements()) 
			{
				portId = (CommPortIdentifier) portList.nextElement();
				System.out.println("RS232 "+portId.getName());
				if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) 
				{
					if (portId.getName().equals("COM1")) 
					{ 
						serialPort = (SerialPort)portId.open("Rs232Communication", 2000);
						foundport=true;
					}
					else  foundport=false;
				}
			}
			return(foundport);		   
		}	
		catch(Exception exception)
		{
			common.fileOutput( strLogFile, "(OutboundRs232Communication:checkRsCommunicationStatus)Exception:"+exception+"\n" );
			System.out.println( "(checkRsCommunicationStatus) Exception:"+exception );
			return(false);
		}	
	}

	public void run()
	{
		readMesssge();
	}

	public void writeMessage(String msg)
	{
		try 
		{
			if(intStart == 0)
			{
				intStart = 1;
				this.start();
			}

			outputStream = serialPort.getOutputStream();
			serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);			
			if(logToFile) common.fileOutput( strLogFile, "(OutboundRs232Communication:writeMessage) Sending Message \n======\n "+msg+"\n======\n\n" );
			outputStream.write(msg.getBytes());
			outputStream.close();	

		} 
		catch (Exception exception) 
		{  
			common.fileOutput( strLogFile, "(OutboundRs232Communication:writeMessage)Exception:"+exception+"\n" );
			System.out.println( "(writeMessage) Exception:"+exception );
		}
	}
/*
	public String  readMesssge()
	{
		int numBytes=0;
		String readValue="";
		try 
		{
			serialPort.notifyOnDataAvailable(true);
			inputStream = serialPort.getInputStream();
			serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);

		} 
		catch (Exception e) 
		{
			System.out.println("Exception in readData(1) method "+e.toString());
		}

		try 
		{
			byte[] readBuffer = null;	 
			//*****************
			int i=0;
			while (true)
			{	
				Thread.sleep(1000);	 				
				if(i>15)
				{ 
					//System.out.println("failure");	
					readValue="ERROR";
					break; 
				}  
				else System.out.println("success");					

				while (inputStream.available() > 0)
				{
					readBuffer = new byte[inputStream.available()];
					numBytes = inputStream.read(readBuffer);
				}
				if(numBytes >0)
				{
					readValue =new String(readBuffer);
					break;
				}
				i++;
			}                         

		} 
		catch (Exception e) 
		{
			System.out.println("Exception in readData(2) method "+e.toString());
			readValue="ERROR";
		}
		System.out.println("readValue "+readValue); 
		// inputStream.close();
		 
		if(serialPort!=null)
		{
		serialPort.close();
		serialPort = null;
		}
		return readValue;	

	}   

*/

	public void readMesssge()
	{
		int numBytes=0;
		String readValue="";
		try 
		{
			messageTokenizer = new MessageTokenizer(clientDB.clientParameters.messageStart, clientDB.clientParameters.messageEnd);
			if(logToFile) common.fileOutput( strLogFile, "(OutboundRs232Communication:readMesssge) \n" );
			serialPort.notifyOnDataAvailable(true);
			inputStream = serialPort.getInputStream();
			serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);

		} 
		catch (Exception e) 
		{
			System.out.println("Exception in readData(1) method "+e.toString());
		}

		try 
		{
			byte[] readBuffer = null;
			readValue = "";
			readBuffer = new byte[6291456];
			//*****************
		//	int i=0;
			while (true)
			{	
			/*	Thread.sleep(1000);	 				
				if(i>15)
				{ 
					//System.out.println("failure");	
					readValue="ERROR";
					break; 
				}  
				else System.out.println("success");					
			*/
				while (inputStream.available() > 0)
				{
					numBytes = inputStream.read(readBuffer);				
					readValue = readValue + new String(readBuffer,0,numBytes);
				}
				if(numBytes >0)
				{
				//	readValue =new String(readBuffer);
					if( logToFile ) common.fileOutput( strLogFile, "(OutboundRs232Communication:readMesssge)Receiving Message/Acknowledgement :\n======\n"+readValue+"\n=======\n" );

					messageTokenizer.getTokenizedMessage(readValue);	
				//	System.out.println( messageTokenizer.intTotMessage ) ;
					
					for (int i=0;i<messageTokenizer.intTotMessage;i++)
					{
						/***** Store the Message in the Database***********/
					//	System.out.println( "here to call processAcknowledgement) ") ;
						clientDB.processAcknowledgement(messageTokenizer.strMessageBox[i]); 
					}
					readValue = "";
					numBytes = 0;
				}
			//	i++;
			}                         

		} 
		catch (Exception e) 
		{
			System.out.println("Exception in readData(2) method "+e.toString());
			readValue="ERROR";
		}		
		// inputStream.close();
		/* 
		if(serialPort!=null)
		{
		serialPort.close();
		serialPort = null;
		}
		return readValue;	*/

	}  //end of method 

}  //end of class 



