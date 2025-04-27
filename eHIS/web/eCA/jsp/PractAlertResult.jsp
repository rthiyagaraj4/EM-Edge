<!DOCTYPE html>
<%--Author  Arvind Singh Pal Created on 4/1/2009 --%>

<%@page import="java.sql.*,webbeans.eCommon.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
	
%>	

	<link rel='stylesheet' type='text/css' href="../../eCommon/html/CommonCalendar.css"></link>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>	
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>	
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	
			<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
			<form name='PractAlert' id='PractAlert' >
			<%
			Connection con = null;		

		
			try
			{
				java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
				String locale = (String) p.getProperty("LOCALE");		
				
				String from 					= request.getParameter("from") ;
	
				String to 						= request.getParameter("to") ;
				
				String fromDate			=	request.getParameter("fromDate") == null ? "" : request.getParameter("fromDate");
				
				String toDate			=	request.getParameter("toDate") == null ? "" : request.getParameter("toDate"); 				
				
				 String group_By	=	request.getParameter("group_By") == null ? "" :		request.getParameter("group_By");
				 if(!localeName.equals("en"))
				{
                 fromDate		=	com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
			     toDate	=	com.ehis.util.DateUtils.convertDate(toDate,"DMY",locale,"en");
				}
				 
				String Patient_id="";
				String Patient_name="";
				String encounter_id="";
				String facility_id="";
				String Categ_desc="";
				String Event_desc="";
				String alert_remarks="";
				int maxRecord = 0;
				int start = 0 ;
				int end = 0 ;
				int i=1;

				if ( from == null )
					start = 1 ;
				else
					start = Integer.parseInt( from ) ;

				if ( to == null )
	  				end = 12 ;
				else
				end = Integer.parseInt( to ) ;

				con = ConnectionManager.getConnection(request);
				PreparedStatement pstmt= null;				
				ResultSet rset=null;				
				String sqlQuery="";
				
				try
			 {
			String sqlRecoed = " SELECT COUNT(*) total_records FROM  CA_ALERT_ACTION_LOG a,CA_ALERT_CATEG_LANG b WHERE  b.LANGUAGE_ID =? AND  a.ACTION_PEND_DATETIME BETWEEN TO_DATE(?,'dd/mm/yyyy hh24:mi')   AND TO_DATE(?,'dd/mm/yyyy hh24:mi')AND B.ALERT_CATEG_CODE=a.ALERT_CATEG_CODE  "; 
			
		
			pstmt = con.prepareStatement(sqlRecoed);
			pstmt.setString(1,locale);
			pstmt.setString(2,fromDate);
			pstmt.setString(3,toDate);
			
		    rset = pstmt.executeQuery();		
			if(rset.next())
			{
				maxRecord = rset.getInt("total_records");					
			}
			
			if (rset != null)
				rset.close();

			if (pstmt != null)
				pstmt.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		 if(maxRecord==0){	 %>
		 <script>alert('Query caused no records to be retrieved')</script>
		 <%	}		
	  if(maxRecord !=0) { %>
			<table cellpadding='3' align='center' width='100%'>
				<tr >
			<td width='100%' class='white' ></td>
				<td nowrap width='10%'>
			<%
				if ( !(start <= 1) )
				out.println("<A HREF='../../eCA/jsp/PractAlertResult.jsp?from="+(start-12)+"&to="+(end-12)+"&toDate="+toDate+"&fromDate="+fromDate+"&group_By="+group_By+"'"+" text-decoration='none'    class ='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");				

				  if ( !( (start+12) >= maxRecord ) )
					{
			out.println("<A HREF='../../eCA/jsp/PractAlertResult.jsp?from="+(start+12)+"&to="+(end+12)+"&toDate="+toDate+"&fromDate="+fromDate+"&group_By="+group_By+"'"+" text-decoration='none'                                 class ='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	}
	
%>

</td>
</tr>
</table>	
	<table id='PatCriteriaResultTbl'  class='grid' width='100%' border='0' cellpadding='3' cellspacing='0'>
	<%   sqlQuery="SELECT mp.PATIENT_ID,mp.PATIENT_NAME ,pr.ENCOUNTER_ID,pr.FACILITY_ID,b.ALERT_CATEG_DESC,c.ALERT_EVENT_DESC,a.ALERT_REMARKS  FROM mp_patient mp,pr_encounter pr,CA_ALERT_ACTION_LOG a,CA_ALERT_CATEG_LANG b,CA_ALERT_EVENT_LANG c WHERE mp.PATIENT_ID=A.PATIENT_ID AND b.LANGUAGE_ID = ? AND a.ACTION_PEND_DATETIME BETWEEN TO_DATE(?,'dd/mm/yyyy hh24:mi') AND TO_DATE(?,'dd/mm/yyyy hh24:mi')AND B.ALERT_CATEG_CODE=a.ALERT_CATEG_CODE AND  c.ALERT_CATEG_CODE=a.ALERT_CATEG_CODE  and A.facility_id=pr.facility_id and A.ENCOUNTER_ID=pr.encounter_id  ";		
				pstmt = con.prepareStatement(sqlQuery);
				pstmt.setString(1,locale);
				pstmt.setString(2,fromDate);
				pstmt.setString(3,toDate);				
				rset = pstmt.executeQuery();

				 if ( start != 1 )
				 for( int j=1; j<start; i++,j++ )
					 rset.next() ;

				 while(rset!=null && rset.next() && i<=end){
				
					 Patient_id=rset.getString("PATIENT_ID");
					 Patient_name=rset.getString("PATIENT_NAME");
					 encounter_id=rset.getString("ENCOUNTER_ID");
					 facility_id=rset.getString("FACILITY_ID");	
					 Categ_desc=rset.getString("ALERT_CATEG_DESC");
					 Event_desc=rset.getString("ALERT_EVENT_DESC");
					 alert_remarks=rset.getString("ALERT_REMARKS"); 		
		%>		
		<tr>		
		<% 
			if(group_By.equals("1")&&(!(Patient_id.equals("")))) {%>

			 <td width='50%'><b><%=Patient_id%>,<%=Patient_name%>,<%=encounter_id%>
			</td></tr>
			<tr><td class='gridData' ><%=Categ_desc%></td><td class='gridData'><%=Event_desc%></td><td class='gridData'><%=alert_remarks%></td></tr>
			<% } 
			else if(group_By.equals("2")&&(!(Patient_id.equals("")))) {%>
			<td ><b><%=Categ_desc%>
			</td></tr>
			</td><td class='gridData'><%=Event_desc%></td><td class='gridData'>
			<%=Patient_id%>,<%=Patient_name%>,<%=encounter_id%></td><td class='gridData'>
			<%=alert_remarks%></td></tr> 		
				<% } %>		
	

<% i++; } 
}
}
catch(Exception e)
{
	//out.println(e);//COMMON-ICN-0181
	e.printStackTrace();
}
finally 
{
	if (con!=null) ConnectionManager.returnConnection(con,request);
}
%> 
</body>
</html>

