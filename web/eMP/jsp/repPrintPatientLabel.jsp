<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	%>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>">
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<Script language='javascript' src='../../eCommon/js/common.js'></Script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<script>
		function query()
		{
			frames[1].location.href='../../eMP/jsp/blank.jsp?step_1=11&module_id=MP';
		}
		function reset()
		{			
			frames[1].location.href ="../../eCommon/html/blank.html" ;
		}
	</script>
</head>
<%
	if(request.getParameter("step").equals("1") )
	{	
		out.println("<html><head>");
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;		
		out.println("</head><iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe><iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMP/jsp/blank.jsp?step_1=11' frameborder=0 scrolling='auto' style='height:83vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe></html>");
	}
	else if(request.getParameter("step").equals("2"))
	{		
		String patient_id	=  request.getParameter("patient_ID");
		String module_id	= request.getParameter("module_id");
		String facility_id	= (String)session.getValue("facility_id");
		String pat_ser_grp_code		= "";		
		String sqlString			= "";		
		Connection con			= null;
		java.sql.Statement stmt	= null;
		ResultSet rset			= null;	
		try
		{
			con		= ConnectionManager.getConnection(request);
			stmt	= con.createStatement();
			rset	= stmt.executeQuery("SELECT pat_ser_grp_code FROM MP_PATIENT where patient_id = '"+patient_id+"'") ;			
			if (rset.next())
			{
				pat_ser_grp_code = rset.getString(1);				
			}
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();					
			
			sqlString ="SELECT DISTINCT a.report_id, b.report_desc, 1 no_of_copies, b.module_id FROM mp_online_reports a, sm_report_lang_vw b,sm_print_routing c WHERE a.pat_ser_grp_code = '"+pat_ser_grp_code+"' AND b.report_id = a.report_id AND a.report_id =c.report_id (+) AND c.facility_id(+) ='"+facility_id+"' AND a.report_id = 'MPBPTLBL'";			
		
			String reportParamNames		= "p_patient_id";
			String reportParamValues	= ""+patient_id+"";
			StringBuffer htmlFor = null;			
			htmlFor = new StringBuffer();
			htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
			htmlFor.append(" </head><body class='message' onKeyDown='lockKey()'>");
			htmlFor.append(" <script language = 'JavaScript'>");
			htmlFor.append("async function showInternalReports() { ");
			htmlFor.append(" var dialogHeight = '450px' ;");
			htmlFor.append(" var dialogWidth = '800px' ;");
			htmlFor.append(" var dialogTop = '65' ;");
			htmlFor.append(" var arguments = ''; ");
			// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
			htmlFor.append(" var getUrl =  '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=MPBPTLBL&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&Patient_ID="+patient_id+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
			htmlFor.append(" var features = 'dialogTop:'+ dialogTop +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
			htmlFor.append(" var retVal = await window.showModalDialog(getUrl,arguments,features); ");
			htmlFor.append(" window.location.href='../../eMP/jsp/blank.jsp?step_1=11&module_id="+module_id+"'; ");
			htmlFor.append(" } showInternalReports(); </script>");
			out.println(htmlFor.toString());
		
			if(htmlFor != null && htmlFor.length() > 0)
			{
				htmlFor.delete(0,htmlFor.length());
			}
			// commented by marwan and inserted in the showInternalReports function 
			// to allow the two pop-ups to open sequentially not at the same time
			//out.println("<script>window.location.href='../../eMP/jsp/blank.jsp?step_1=11&module_id="+module_id+"';</script></body></html>");	
		}
		catch(Exception e) 
		{
			out.println("Error here");
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	}
%>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

