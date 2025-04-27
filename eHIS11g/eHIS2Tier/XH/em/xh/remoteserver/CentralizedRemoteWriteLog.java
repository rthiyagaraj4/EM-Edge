package em.xh.remoteserver;
import java.io.* ;
import java.net.*;
import java.util.*;
import HL7Engine.Common.InterfaceUtil;

//class Common 
public class CentralizedRemoteWriteLog
{
  String filename = InterfaceUtil.getDefaultLogLoc("CentralizedRemoteObject");

	public CentralizedRemoteWriteLog()
	{
		try
		{
			File f = new File(InterfaceUtil.getIntSetupDir() + "/logs/");
			if(!f.exists()) f.mkdir();
		}
		catch (Exception exp)
		{
			System.out.println(exp);
		}
	}

  private  String trimMilli(int j)
  {
    if(j<10)
    {
      return("00"+j);
    }
    else if (j<100)
    {
      return("0"+j);
    }
    else
    {
      return(""+j);
    }
  }

  private  String trim(int j)
  {
    if(j<10)
    {
      return("0"+j);
    }
    else
    {
      return(j+"");
    }
  }

	public void fileOutput(String strOutFileName, String strMessage ) 
	{
		GregorianCalendar gc = new GregorianCalendar();
		String strTimeStamp = "";
		try
		{
			strTimeStamp = trim(gc.get(gc.DAY_OF_MONTH))+"/"+
			 trim((gc.get(gc.MONTH)+1))+"/"+
			 trim(gc.get(gc.YEAR))+" "+
			 trim(gc.get(gc.HOUR_OF_DAY))+
			 ":"+
			 trim(gc.get(gc.MINUTE))+":"+
			 trim(gc.get(gc.SECOND))+":"+
			trimMilli(gc.get(gc.MILLISECOND));
		}
		catch (Exception exp)
		{
		}
		
		fileOutput( strOutFileName, (strTimeStamp+strMessage).getBytes(), (strTimeStamp+strMessage).getBytes().length );
	}

	public void fileOutput(String strFileName, byte[] byteMsg,int intTotBytes)  
	{
		try
		{
			FileOutputStream fileOutputStream = new FileOutputStream(strFileName,true);
			fileOutputStream.write(byteMsg,0,intTotBytes);
			fileOutputStream.close();	
		} 
		catch(FileNotFoundException exceptionFileNotFound)
		{
			System.out.println(" (fileOutput) FileNotFound Exception "+exceptionFileNotFound);
		}
		catch(IOException exceptionFile)
		{
			System.out.println(" (fileOutput) IOException  "+exceptionFile);
		}
		catch(Exception exception)
		{
			System.out.println(" (fileOutput) General Exception "+exception);
		}
	}
}