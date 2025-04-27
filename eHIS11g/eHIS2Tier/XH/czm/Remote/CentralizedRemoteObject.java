//class 
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.io.*;
//class  CentralizedRemoteObject
public class CentralizedRemoteObject extends UnicastRemoteObject implements  CentralizedRemote
{
	String strLogInformation = "\t     IBAHEALTH CENTRALIZED INTERFACE REMOTE OBJECT LOG  \n";
	String line = "-------------------------------------------------------------------------------------------------------------";
	static String filename = "";
	String serviceName = "";
	String gatewayProcessLogFile = "";
	String serviceMonitor = "";
	int processID;

	CentralizedRemoteWriteLog write = null;   
	//constructor
	CentralizedRemoteObject(CentralizedRemoteWriteLog write) throws RemoteException
	{
		super();
		this.write = write;
		filename = write.filename;
		write.fileOutput(filename,"\n".getBytes(),"\n".getBytes().length); 
		write.fileOutput(filename,line.getBytes(),line.getBytes().length); 
		write.fileOutput(filename,"\n".getBytes(),"\n".getBytes().length);
		write.fileOutput(filename,"\n".getBytes(),"\n".getBytes().length); 
		write.fileOutput(filename,strLogInformation.getBytes(),strLogInformation.getBytes().length); 
		write.fileOutput(filename,"\n".getBytes(),"\n".getBytes().length); 
		write.fileOutput(filename,line.getBytes(),line.getBytes().length); 
		write.fileOutput(filename,"\n".getBytes(),"\n".getBytes().length); 
		write.fileOutput(filename," (CentralizedRemoteObject:constructor) Login to Centralized Remote Object\n");
	}

	// Method startHl7Gateway
	public String  startHl7Gateway(HashMap hashmap) throws RemoteException
	{
		String startstatus = "";
		Process gatewayprocess = null;
		try
		{
			String strcmd[] = null;

			boolean flag = false;
			write.fileOutput(filename," (CentralizedRemoteObject:startHl7Gateway) Inside Remote Object method startHl7Gateway\n");
			Process startprocess = null;
			Process statusprocess = null;

			CentralizedCheckService chkservice = new CentralizedCheckService(filename);
			Runtime runtime = Runtime.getRuntime();

			strcmd = getCommand(hashmap);		
			gatewayprocess = runtime.exec(strcmd[0]);

			String msg = chkservice.getConsoleErrMsg(gatewayprocess);
			write.fileOutput(filename," (CentralizedRemoteObject:startHl7Gateway)Start "+msg+"\n");

			write.fileOutput(filename," (CentralizedRemoteObject:startHl7Gateway)strcmd[1] command "+strcmd[1]+"\n");

			if(strcmd[1] != null) 
			{
				startprocess = runtime.exec(strcmd[1]);			
				Thread.sleep(1000);
				statusprocess = runtime.exec(strcmd[2]);	      
				String strmsg = chkservice.getConsoleMessage(statusprocess);
				write.fileOutput(filename," (CentralizedRemoteObject:startHl7Gateway)Status "+strmsg+"\n");
				flag = chkservice.isSubstringExists(strmsg,"RUNNING");
				if(flag) 
				{
					startstatus = "HL7Gateway Started Successfully......... ";
					startServiceListener(serviceName, gatewayProcessLogFile);
				}
				else startstatus = "HL7Gateway not Started ......... ";
			}
			else startstatus = "HL7Gateway Started Successfully......... ";

			write.fileOutput(filename,"(CentralizedRemoteObject:startHl7Gateway) "+startstatus+"\n");
		//	write.fileOutput(filename,"(CentralizedRemoteObject:startHl7Gateway)End of startHl7Gateway()\n");
		}
		catch(Exception ex) 
		{ 
			write.fileOutput(filename,"(CentralizedRemoteObject:startHl7Gateway)Exception "+ex.toString()+"\n");
			System.out.println("exception:"+ex.toString()); 
			ex.printStackTrace(System.out);
		}

		return startstatus;
	}

	public String  stopHl7Gateway(String applicationid,String facilityid,String processid) throws RemoteException
	{
		String statusflag = null;
		try
		{
			write.fileOutput(filename," (CentralizedRemoteObject:stopHl7Gateway) Inside Remote Object method stopHl7Gateway\n");

			CentralizedCheckService chkservice = new CentralizedCheckService(filename);

			write.fileOutput(filename," (CentralizedRemoteObject:stopHl7Gateway) ApplicationID :"+applicationid+"\n");
			write.fileOutput(filename," (CentralizedRemoteObject:stopHl7Gateway) FacilityID :"+facilityid+"\n");
			write.fileOutput(filename," (CentralizedRemoteObject:stopHl7Gateway) ProcessID :"+processid+"\n");

			statusflag = chkservice.stopJavaService(applicationid,facilityid,processid);

			write.fileOutput(filename," (CentralizedRemoteObject:stopHl7Gateway) "+statusflag+"\n");
			write.fileOutput(filename," (CentralizedRemoteObject:stopHl7Gateway) End of stopHl7Gateway()\n");
		}
		catch(Exception ex) 
		{ 
			write.fileOutput(filename," (CentralizedRemoteObject:stopHl7Gateway) Exception "+ex.toString()+"\n");
			System.out.println("exception:"+ex.toString()); ex.printStackTrace(System.out);
		}
		return statusflag;
	}//End of stopHl7Gateway


	//Method chkServiceStatus
	public HashMap chkServiceStatus(String applicationid,String facilityid,String processid) throws RemoteException
	{
		HashMap mapvar = null;
		try
		{
			write.fileOutput(filename," (CentralizedRemoteObject:chkServiceStatus)Inside Remote Object method chkServiceStatus\n");

			CentralizedCheckService chkservice=new CentralizedCheckService(filename);

			write.fileOutput(filename," (CentralizedRemoteObject:chkServiceStatus) ApplicationID :"+applicationid+"\n");
			write.fileOutput(filename," (CentralizedRemoteObject:chkServiceStatus) FacilityID :"+facilityid+"\n");
			write.fileOutput(filename," (CentralizedRemoteObject:chkServiceStatus) ProcessID :"+processid+"\n");

			mapvar=chkservice.chkJavaServiceStatus(applicationid,facilityid,processid);

			write.fileOutput(filename," (CentralizedRemoteObject:chkServiceStatus) End of chkServiceStatus()\n");
		}
		catch(Exception ex) 
		{
			write.fileOutput(filename," (CentralizedRemoteObject:chkServiceStatus) Exception "+ex.toString()+"\n");
			System.out.println("exception:"+ex.toString()); ex.printStackTrace(System.out);
		}
		return mapvar;
	}

	//Method  getCommand
	public String[] getCommand(HashMap hashmap)
	{
		String applicationid = "";
		String facilityid = "";
		String commtype = "";
		String databaseurl = "";
		String outputdirectory = "";
		String userid = "";
		String usrpassword = "";
		String commclient = "";
		String classpath = "";
		String strcmd = "";
		String jvmstring = "";
		String retryintervals = "";
		String servicemode = "";
		String protocalLinkId = "";  // Modified on 11/23/2007
		String strcmds[] = new String[3];

		int retryinterval = 0;
		int processid = 0;

		try
		{
			Properties props = System.getProperties();
			jvmstring = getJvmDll("jvm");
			classpath = props.getProperty("java.class.path");
			applicationid = (String)hashmap.get("applnId");  
			facilityid = (String)hashmap.get("facilityId");  
			commclient = (String)hashmap.get("client_id"); 
			commtype = (String)hashmap.get("commtype");  
			outputdirectory = (String)hashmap.get("out_dir");  
			processid = ((Integer)hashmap.get("procId")).intValue(); 
			databaseurl = (String)hashmap.get("db_string");  
			userid = (String)hashmap.get("user_id"); 
			usrpassword = (String)hashmap.get("pass_word"); 
			retryintervals = (String)hashmap.get("retryinterval");
			retryinterval = Integer.parseInt(retryintervals);
			servicemode = (String)hashmap.get("servicemode");
			protocalLinkId = (String)hashmap.get("protocolLinkID");  // Modified on 11/23/2007

			write.fileOutput(filename," (CentralizedRemoteObject:getCommand) jvmstring :"+jvmstring+"\n");
			write.fileOutput(filename," (CentralizedRemoteObject:getCommand) classpath :"+classpath+"\n");
			write.fileOutput(filename," (CentralizedRemoteObject:getCommand) applicationid :"+applicationid+"\n");
			write.fileOutput(filename," (CentralizedRemoteObject:getCommand) facilityid :"+facilityid+"\n");
			write.fileOutput(filename," (CentralizedRemoteObject:getCommand) commclient :"+commclient+"\n");
			write.fileOutput(filename," (CentralizedRemoteObject:getCommand) commtype :"+commtype+"\n");
			write.fileOutput(filename," (CentralizedRemoteObject:getCommand) outputdirectory :"+outputdirectory+"\n");
			write.fileOutput(filename," (CentralizedRemoteObject:getCommand) processid :"+processid+"\n");
			write.fileOutput(filename," (CentralizedRemoteObject:getCommand) databaseurl :"+databaseurl+"\n");
			write.fileOutput(filename," (CentralizedRemoteObject:getCommand) userid :"+userid+"\n");
			// write.fileOutput(filename," (CentralizedRemoteObject:getCommand) usrpassword :"+usrpassword+"\n");
			write.fileOutput(filename," (CentralizedRemoteObject:getCommand) retryintervals :"+retryintervals+"\n");
			write.fileOutput(filename," (CentralizedRemoteObject:getCommand) retryinterval :"+retryinterval+"\n");
			write.fileOutput(filename," (CentralizedRemoteObject:getCommand) servicemode :"+servicemode+"\n");
			write.fileOutput(filename," (CentralizedRemoteObject:getCommand) protocolLinkID :"+protocalLinkId+"\n");

			if(servicemode.equalsIgnoreCase("With Service"))
			{
				if(commtype.equalsIgnoreCase("O"))
				{
					strcmd = "JavaService -install Hl7_"+applicationid+"_"+facilityid+"_"+processid+" "+jvmstring+" -Djava.class.path="+classpath+" -start OutboundProcess -method main -params "+applicationid+" "+facilityid+" "+processid+" O "+retryinterval+" "+outputdirectory+" N "+databaseurl+" "+userid+" "+usrpassword+" "+protocalLinkId+" Y";
				}
				if(commtype.equalsIgnoreCase("I"))
				{
					strcmd = "JavaService -install Hl7_"+applicationid+"_"+facilityid+"_"+processid+" "+jvmstring+" -Djava.class.path="+classpath+" -start InboundProcess -method main -params "+commclient+" "+applicationid+" "+facilityid+" "+processid+" I "+retryinterval+" "+outputdirectory+" N "+databaseurl+" "+userid+" "+usrpassword+" "+protocalLinkId+" Y";
				}

				serviceName = "Hl7_"+applicationid+"_"+facilityid+"_"+processid;
				gatewayProcessLogFile = outputdirectory;
				serviceMonitor = "JavaService -install Hl7_"+applicationid+"_"+facilityid+"_"+processid+"_monitor "+jvmstring+" -Djava.class.path="+classpath+" -start ServiceRestart -method main -params ";
				processID = processid;

				strcmds[0] = strcmd;
				strcmds[1] = "sc start Hl7_"+applicationid+"_"+facilityid+"_"+processid+"";
				strcmds[2] = "sc query Hl7_"+applicationid+"_"+facilityid+"_"+processid+"";
				write.fileOutput(filename," (CentralizedRemoteObject:getCommand) commands(1) constructed for With Service :"+strcmds[0]+"\n");
				write.fileOutput(filename," (CentralizedRemoteObject:getCommand) commands(2) constructed for With Service :"+strcmds[1]+"\n");
				write.fileOutput(filename," (CentralizedRemoteObject:getCommand) commands(3) constructed for With Service :"+strcmds[2]+"\n");
			}

			if(servicemode.equalsIgnoreCase("Without Service"))
			{
				if(commtype.equalsIgnoreCase("O"))
				{
					strcmd = "java OutboundProcess "+applicationid+" "+facilityid+" "+processid+" O "+retryinterval+" "+outputdirectory+" y "+databaseurl+" "+userid+" "+usrpassword+" "+protocalLinkId+" N";
				}
				if(commtype.equalsIgnoreCase("I"))
				{
					strcmd = "java InboundProcess "+commclient+" "+applicationid+" "+facilityid+" "+processid+" I "+retryinterval+" "+outputdirectory+" Y "+databaseurl+" "+userid+" "+usrpassword+" "+protocalLinkId+" N";
				}
				strcmds[0]=strcmd;
				strcmds[1]=null;
				write.fileOutput(filename," (CentralizedRemoteObject:getCommand) commands(1) constructed for java :"+strcmds[0]+"\n");
				write.fileOutput(filename," (CentralizedRemoteObject:getCommand) commands(2) constructed for java :"+strcmds[1]+"\n");
			}
		}
		catch(Exception e)
		{
			write.fileOutput(filename," (CentralizedRemoteObject:getCommand) Excpetion occured :"+e.toString()+"\n");
		}

		return strcmds;

	}

	//Method getJvmDll
	public String getJvmDll(String jvmstr)
	{
		String propvalue=null;
		Properties properties = new Properties();
		try
		{
			properties.load(new FileInputStream("c:/ehis/config/properties.ini"));

			for(Enumeration props = properties.keys();props.hasMoreElements();)
			{
			String propkey;
			//String propvalue;
			propkey = (String)props.nextElement();
			propvalue = properties.getProperty(propkey);
			if(propkey.equalsIgnoreCase(jvmstr.trim()))
			{
			propvalue = properties.getProperty(propkey);
			break;
			}
			else  propvalue="";
			}
		}
		catch(IOException e)
		{	
			write.fileOutput(filename," (CentralizedRemoteObject:getJvmDll) Excpetion occured :"+e.toString()+"\n");
			System.out.println("Exception : "+e.toString()); 
		}
		write.fileOutput(filename," (CentralizedRemoteObject:getJvmDll) jvm reference path  :"+propvalue+"\n");

		return propvalue; 
	}

	/* public void stopProcess()
	{
	try
	{
	write.fileOutput(filename," (CentralizedRemoteObject:stopProcess) Stopping java process\n");
	gatewayprocess.destroy();
	}
	catch(Exception exception)
	{
	write.fileOutput(filename," (CentralizedRemoteObject:stopProcess) Exception :"+exception+"\n");			
	}
	}
	*/

	// method main()
	public static void main(String args[])
	{	
		CentralizedRemoteWriteLog write = new CentralizedRemoteWriteLog();
		try
		{	
			String rmiPort = getRMIPort();
			String bindStr = "//localhost:"+rmiPort+"/InterfaceEngineRemoteObj";

			LocateRegistry.createRegistry(Integer.parseInt(rmiPort));
			System.out.println("Port registered");

			CentralizedRemoteObject Server = new CentralizedRemoteObject(write);																		
			Naming.rebind(bindStr, Server);
			System.out.println("Server started @ "+rmiPort+"...");

			write.fileOutput(filename," (CentralizedRemoteObject:main) Remote Object running Sucessfully @ "+rmiPort+" port\n");
		}
		catch (java.net.MalformedURLException me)       
		{
			write.fileOutput(filename," (CentralizedRemoteObject:main) Remote Object MalformedURLException: "+me.toString()+"\n");
			System.out.println("Malformed URL: " + me.toString());   
		}
		catch (RemoteException re)  
		{
			write.fileOutput(filename," (CentralizedRemoteObject:main) Remote Object RemoteException: "+re.toString()+"\n");
			System.out.println("Remote exception: " + re.toString());
			re.printStackTrace(System.out);
		}
		catch(Exception exp)
		{
			write.fileOutput(filename," (CentralizedRemoteObject:main) RemoteException: "+exp.toString()+"\n");
			System.out.println("Remote exception: " + exp.toString());
			exp.printStackTrace(System.out);
		}
	}

	public void startServiceListener(String serviceName, String logFile)
	{
		Runtime runtime = Runtime.getRuntime();

		try
		{
			CentralizedCheckService chkservice = new CentralizedCheckService(filename);

			String processCmd = serviceMonitor + serviceName + " " + logFile+"\\"+processID+".log";
			String processStartCmd = "sc start " + serviceName + "_monitor";
			String processStatusCmd = "sc query " + serviceName + "_monitor";
			write.fileOutput(filename,"(OutboundClientApplication:startServiceListener)Process1 "+processCmd+"\n");

			Process p = runtime.exec(processCmd);
			String status = chkservice.getConsoleMessage(p);
			write.fileOutput(filename,"(CentralizedRemoteObject:startServiceListener)Install "+status+"\n");

			p = runtime.exec(processStartCmd);
			status = chkservice.getConsoleMessage(p);
			write.fileOutput(filename,"(CentralizedRemoteObject:startServiceListener)Start "+status+"\n");

			Thread.sleep(1000);

			p = runtime.exec(processStatusCmd);
			status = chkservice.getConsoleMessage(p);
			write.fileOutput(filename,"(CentralizedRemoteObject:startServiceListener)Status "+status+"\n");
		}
		catch(Exception exp)
		{
		}
	}

	/**
	 * Method retreives the rmi port from the properties config file.
	 * If the property "rmiport" is not found in the configuration file, by default it returns 1099.
	 */
	private static String getRMIPort()
	{
		CentralizedRemoteWriteLog write = new CentralizedRemoteWriteLog();
		String rmiPort = null;
		try
		{
			Properties properties = new Properties();
			File file = new File("C:/eHIS/config/properties.ini");

			if(!file.exists())
			{
				file = new File("C:/eHIS/reports/properties.ini");
			}
			
			properties.load(new FileInputStream(file));
			rmiPort = properties.getProperty("rmiport", "1099");
			
			if(rmiPort == null || rmiPort.trim().equals("")) rmiPort = "1099";
		}
		catch(Exception exp)
		{
			write.fileOutput(filename," (CentralizedRemoteObject:getRMIPort) RemoteException: "+exp.toString()+"\n");			
			exp.printStackTrace();
		}
		return rmiPort;
	}
}