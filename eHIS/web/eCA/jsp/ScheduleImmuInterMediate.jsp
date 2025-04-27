

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCA.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	try 
	{
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
//		String locale = (String) p.getProperty("LOCALE"); 	
		String client_ip_address=	p.getProperty("client_ip_address")==null?"":(String)p.getProperty("client_ip_address");
		String login_user_id =  p.getProperty("login_user")==null?"":(String)p.getProperty("login_user")  ;
		String facility_id = session.getAttribute("facility_id")==null?"":(String) session.getAttribute("facility_id"); 	
		String scheduled_user_id = session.getAttribute("ca_practitioner_id")==null?"":(String)session.getAttribute("ca_practitioner_id");

		hash = (Hashtable)hash.get( "SEARCH" ) ;			
		String callFrom =(String) hash.get("CallFrom");
		ScheduleForVaccination schBean = new ScheduleForVaccination();

		if(callFrom.equals("CREATE_ADHOC_SCH"))
		{							
			hash.remove("CallFrom");
			hash.put("FACILITY_ID",facility_id);
			hash.put("SCHEDULED_USER_ID",scheduled_user_id);
			hash.put("LOGIN_USER_ID",login_user_id);
			hash.put("CLIENT_IP_ADDRESS",client_ip_address);
			hash.put("SCHEDULED_USER_ID",scheduled_user_id);
			String retVal = schBean.createAdhocSchedule(hash);	
			
			
			//out.println( "alert('retVal : "+retVal+"') ; " ) ;
			out.println("parent.ExistScheduleTreeFrame.location.href = '../../eCA/jsp/ScheduleExistingVaccinations.jsp?"+request.getQueryString()+"'");			
			
			if(retVal.equals("TRANS_FAILED"))
			{
				out.println("var msg = getMessage('FAILED_TRANSACTION','CA')");
				out.println("parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg");
			}
				
		}else if(callFrom.equals("LINK_VACCINE_SCH"))
		{							
			hash.remove("CallFrom");			

			String result = schBean.setLinkForRXVaccine(hash);		
			out.println("parent.parent.parent.ExistScheduleTreeFrame.location.href = '../../eCA/jsp/ScheduleExistingVaccinations.jsp?"+request.getQueryString()+"'");
		}
		
	}catch(Exception e){
		e.printStackTrace();	
	}
%>	 
	 
