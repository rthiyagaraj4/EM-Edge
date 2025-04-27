 <%-- saved on 03/11/2005 --%>
   <%@page contentType="text/html;charset=UTF-8" import="java.lang.*,java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.Common.*,eST.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.ConnectionManager "%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%	   
Connection conn = null;
try{
	conn = ConnectionManager.getConnection(request);	
	boolean ch=false;
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");				  
    String login_user       = (String)session.getValue("login_user");
	String facility    = (String)session.getValue("facility_id");
	/*Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String validate             = request.getParameter("validate") ; 	*/		 
	//	if(validate.equals("RECORDS_FOR_MEDICATIONLIST")){
    String strBeanName				=SRRMedicationListReportBean.strBeanName;
    
	 request.setAttribute("action_attr","R");
	SRRMedicationListReportBean	xhBean = SRRMedicationListReportBean.getBean(strBeanName,request,session);

	xhBean.action(request,conn);
	String strData[][] = xhBean.getDatabaseData();
	xhBean.action(request,conn);								  
	for(int i=0;i<strData.length;i++)						 						  
	{   

		if(strData[i][9].equals("Y")){
				 ch=true;
		ecis.utils.OnlineReports onlineReports 		= new ecis.utils.OnlineReports() ;
		ecis.utils.OnlineReport report1				= new ecis.utils.OnlineReport(facility,"ST","STMEDLIST_SRR") ;
		report1.addParameter("P_REPORT_ID","STMEDLIST_SRR") ;
		report1.addParameter("p_user_name",login_user) ;
		report1.addParameter("P_FACILITY_ID",facility) ;
		report1.addParameter("p_module_id","ST") ;
		report1.addParameter("P_LANGUAGE_ID",locale);
		report1.addParameter("P_DOC_NO",strData[i][2]) ;					 
		report1.addParameter("P_DOC_DATE",strData[i][3]) ;
		report1.addParameter("P_STORE_CODE",strData[i][4]) ;
		report1.addParameter("P_REPRINT","Y");					 
		onlineReports.add(report1) ;
		String ReportOutput = onlineReports.execute(request,response );
		}  																			  
	}

	if(ch==false)
	{
	   	out.println("<script>parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num=APP-000009 Atleast one record should be selected';</script>") ;
	}
	else		    
	{
	  out.println("<script>parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';</script>") ;
	}
        putObjectInBean(strBeanName,xhBean,request);
		//}														   
		}catch (Exception e) {
	out.println("alert(\"" + e + "\");") ;
	e.printStackTrace();								   
	} finally
	{																			  
		//arrRow.clear();											 
	//	arrCol.clear();
		ConnectionManager.returnConnection(conn);
		
	} 		     
	 request.setAttribute("action_attr","");
		
%>

	 											    
