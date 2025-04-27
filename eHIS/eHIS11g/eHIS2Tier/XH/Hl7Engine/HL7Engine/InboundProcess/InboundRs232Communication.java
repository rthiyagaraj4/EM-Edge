package HL7Engine.InboundProcess ;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;

import HL7Engine.Common.Common;
import HL7Engine.Common.MessageTokenizer;

public class InboundRs232Communication extends Thread
{
    Common common = null;

	String strMessage ;
	String strDirName;
		
	String strOutFileName ="";
	String strExtension=".hl7";

	boolean logToFile ;
	String strLogFile ;
	String strExceptionLogFile ;
		
	static Enumeration portList;
    static CommPortIdentifier portId;
    static SerialPort serialPort;
    
	InputStream inputStream;
	OutputStream outputStream;

	InboundServerDBInteraction serverDB;
	MessageTokenizer messageTokenizer;
	
	//constructor 
	public InboundRs232Communication(boolean logToFile, String strLogFile, String strExceptionLogFile,InboundServerDBInteraction serverDB)
	{
		common = Common.getInstance();
		this.logToFile = logToFile;
		this.strLogFile = strLogFile;
		this.strExceptionLogFile = strExceptionLogFile;
		this.serverDB = serverDB;
	}//

	public boolean checkRsCommunicationStatus()
	{
		try
		{	boolean foundport=false;
			portList = CommPortIdentifier.getPortIdentifiers();
            while (portList.hasMoreElements()) 
	        {
			   portId = (CommPortIdentifier) portList.nextElement();
			   System.out.println("RS232 "+portId.getName());
		       if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) 
		       {
			       if (portId.getName().equals("COM1")) 
		           { 
					   if( logToFile ) common.fileOutput( strLogFile, "(InboundRs232Communication:checkRsCommunicationStatus) COM1 Port Exists\n" );
					   serialPort = (SerialPort)portId.open("Rs232Communication", 2000);
					   foundport=true;
					   break;
				   }
				   else  foundport=false;
		       }
			}
		    return(foundport);		   
		}	
		catch(Exception exception)
		{
			
			common.fileOutput( strLogFile, "(InboundRs232Communication:checkRsCommunicationStatus)Exception:"+exception+"\n" );
			System.out.println( "(checkRsCommunicationStatus) Exception:"+exception );
			return(false);
		}	
	}

// 
     public void writeMessage(String msg)
     {
		 try {
			   
			   outputStream = serialPort.getOutputStream();
		       serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
			   outputStream.write(msg.getBytes());
			   outputStream.close();	
			
		    } catch (Exception exception) 
			{  
			 common.fileOutput( strLogFile, "(InboundRs232Communication:writeMessage)Exception:"+exception+"\n" );
			 System.out.println( "(writeMessage) Exception:"+exception );
			}
    }
    
/*	public InputStream readMesssge()
    {
   	   int numBytes=0;
	   String readValue="";
  	   try 
	   {
		  System.out.println("----- Waiting for messages -----");
	  	  serialPort.notifyOnDataAvailable(true);
		  System.out.println("----- MESSAGE RECEIVED -------");
		  inputStream = serialPort.getInputStream();
		  serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);

	    }
		catch (Exception e) 
	    {
			System.out.println("Exception in readData(1) method "+e.toString());
	    }
		return inputStream;
				
	/*  try 
	  {
		  byte[] readBuffer = null;	  
		 //*****************
		  int i=0;
		  while (true)
		  {	
			Thread.sleep(1000);	 
			//****************************
			 // if(i>15){ 
				            //System.out.println("failure");	
			   			  /*  readValue="ERROR";
			                break; 
					   }  
			   //else System.out.println("success");	
			//*********************************
			
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
	   System.out.println("readValue "+readValue); 	  */
		  // inputStream.close();
		  /* if(serialPort!=null)	{
			                      serialPort.close();
								  serialPort = null;
		                        }
 	        return readValue;	**/
		
	//		} 

	public void run()
	{
	   int numBytes=0;
	   String readValue="";
  	  
	   try 
	   {
	//	  Thread.sleep(1000);
		  serialPort.notifyOnDataAvailable(true);
		  inputStream = serialPort.getInputStream();
		  serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);

	   } catch (Exception e) {}
		
	   try 
	   {
	//	 Thread.sleep(1000);
		 byte[] readBuffer = null;		 		
		 readValue = "";
		 readBuffer = new byte[6291456];
		 //MessageTokenizer Object
		 messageTokenizer = new MessageTokenizer(serverDB.serverParameters.messageStart, serverDB.serverParameters.messageEnd);
		 if( logToFile ) common.fileOutput( strLogFile, "(InboundRs232Communication:run)Message Start Char:"+serverDB.serverParameters.messageStart+"\n" ) ;
		 if( logToFile ) common.fileOutput( strLogFile, "(InboundRs232Communication:run)Message End Char: "+serverDB.serverParameters.messageEnd+"\n" ) ;
		 while (true)
		 {				 
		    while (inputStream.available() > 0)
            {
                		//	System.out.println(" inputStream.available() :"+inputStream.available());								
				numBytes = inputStream.read(readBuffer);				
				readValue = readValue + new String(readBuffer,0,numBytes);					

		//		if(numBytes > 0)
		//		readValue = readValue + new String(readBuffer,0,numBytes);
            }			
			if(numBytes > 0)
			{
			//	String strMessage = new String(byteMsg,0,intTotBytes);
			//	readValue = new String(readBuffer,0,numBytes);

				if( logToFile ) common.fileOutput( strLogFile, "(InboundRs232Communication:run)Received Message:"+readValue+"\n" ) ;				
				
				String 	application= serverDB.strApplicationId;
				if(application.equals("EPABXI"))
				{
					messageTokenizer.getTokenized_Message(readValue);
				}
				else
				{
					System.out.println("tokenizing ... ... "+readValue);
					messageTokenizer.getTokenizedMessage(readValue);
				}
				
				//end 
				System.out.println("---- after tokenizing ---- "+messageTokenizer.intTotMessage);
				if( logToFile ) common.fileOutput( strLogFile, "(InboundRs232Communication:readMessage)Total Messages: "+messageTokenizer.intTotMessage +"\n" ) ;

				readValue = "";
				numBytes = 0;

				for (int i=0;i<messageTokenizer.intTotMessage;i++)
				{						
					serverDB.processQueryMessage(messageTokenizer.strMessageBox[i]);												
				}

				String solicited = serverDB.serverParameters.solicitedYN;

				if(solicited!=null && solicited.equalsIgnoreCase("Y"))
				{
					if( logToFile ) common.fileOutput( strLogFile, "(InboundRs232Communication:readMessage)Query Processing Completed\n" ) ;
					serverDB.serverParameters.ackSent = true; // indicates processing of query has completed.						
				}
		    }
		}
	   }
	   catch(Exception exception)
		{
		   exception.printStackTrace();
		}
	}

	public void startReadProcess()
	{
		this.start();
	}

}  //end of class 
   
 
 
 