<%@page import="java.sql.Types"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="ecis.utils.OnlineReports"%>
<%@page import="ecis.utils.OnlineReport"%>
<%@ page   import="java.util.*" contentType="text/html;charset=UTF-8" %> 
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%


try{

String calledForReceipt = request.getParameter("calledForReceipt");
if(calledForReceipt == null){
	calledForReceipt = "";
}

HashMap<String,String> asyncPrinterAttrib = null;

if("Y".equals(calledForReceipt)){
	System.err.println("Called For Receipt");
	asyncPrinterAttrib = (HashMap<String,String>)session.getAttribute("ASYNC_PRINTER_ATTRIB_RECEIPT");
}
else{
	System.err.println("Called For Original");
	asyncPrinterAttrib = (HashMap<String,String>)session.getAttribute("ASYNC_PRINTER_ATTRIB");
}

System.err.println("asyncPrinterAttrib->"+asyncPrinterAttrib);
Set<String> kSet=asyncPrinterAttrib.keySet();
Iterator<String> it=kSet.iterator();

while(it.hasNext()){
	String str_bill_prt_format_vals=it.next();
	String strBlrblprt=asyncPrinterAttrib.get(str_bill_prt_format_vals);
	String locale = (String)session.getAttribute("LOCALE"); 
	String str_facility_id = (String)session.getAttribute("facility_id"); 
	String pgm_id=null;
	String session_id=null;
	String pgm_date=null;
	String mpi_id_rep=null;						
		
	StringTokenizer st1 = new StringTokenizer(str_bill_prt_format_vals,"/");

		while(st1.hasMoreTokens())
		{
			pgm_id = st1.nextToken();
			System.err.println("pgm_id in Disc:"+pgm_id);
			session_id = st1.nextToken();
			System.err.println("session_id in Disc:"+session_id);
			pgm_date = st1.nextToken();
			System.err.println("pgm_date in Disc:"+pgm_date);
			mpi_id_rep = st1.nextToken();
			System.err.println("mpi_id_rep in Disc:"+mpi_id_rep);
			st1.nextToken();
		}

		//Modified by muthukumar against Arabic Language change on 31-5-2012
		OnlineReport onlinereportParam = null;
	boolean printRcptSiteSpec=false;
	
		if(locale.equals("ar"))
			{
			Connection conn=null;
				try{
					
					conn=ConnectionManager.getConnection();
					
					printRcptSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(conn,
						"BL", "ARABIC_REPORT_PRINT");
					System.err.println("ss "+printRcptSiteSpec);
				}catch(Exception e)
				{
					e.printStackTrace();
					System.err.println("Exception in getting Report Id " + e);
					
				}
				finally{
					if(conn!=null)
					{
						try{
							conn.close();
						}
						catch(Exception e)
						{
							e.printStackTrace();
							System.err.println("Exception in returning connection "+e);
						}
					}
				}
			
				if(printRcptSiteSpec)
				{
					 onlinereportParam = new OnlineReport(str_facility_id, "BL", strBlrblprt);
				}
			
				else
				{
				 onlinereportParam = new OnlineReport(str_facility_id, "BL", "BLRBLPRTAKAR");	
				}
			}
			else
			{
				//Modified by DhanasekarV against PH ST specific report
			 onlinereportParam = new OnlineReport(str_facility_id, "BL", strBlrblprt);
			}
		
		System.err.println("session_id in strBlrblprt:"+strBlrblprt);
		//Modified by muthukumar against Arabic Language change on 31-5-2012

		onlinereportParam.addParameter("p_facility_id",str_facility_id);
		onlinereportParam.addParameter("p_pgm_date",pgm_date);
		onlinereportParam.addParameter("p_pgm_id",pgm_id);
		onlinereportParam.addParameter("p_Session_id",session_id);
	//	System.err.println("Online Report onlinereportParam in Disc:"+onlinereportParam);
		OnlineReports onlinereports = new OnlineReports();
		onlinereports.add(onlinereportParam);
		//System.err.println("Online Report Added in Disc:"+onlinereports);
		String strResults =  onlinereports.execute(request,response);
	//	System.err.println("Online Report Executed in Disc");
		System.err.println("ASYNC_PRINTER_ATTRIB"+strResults);
		
		//session.setAttribute("ASYNC_PRINTER_ATTRIB",null);

		onlinereportParam = null;
		onlinereports = null;		

	}

if("Y".equals(calledForReceipt)){
	session.removeAttribute("ASYNC_PRINTER_ATTRIB_RECEIPT");
}
else{
	session.removeAttribute("ASYNC_PRINTER_ATTRIB");
}
}catch(Exception e){
	e.printStackTrace();
	System.err.println("Err Msg from BLAdhocDiscOnlineReport.jsp "+e);
} 

%>


	
