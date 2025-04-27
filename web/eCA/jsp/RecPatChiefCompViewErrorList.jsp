<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<head>


<%
request.setCharacterEncoding("UTF-8");
String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
	Connection con	=null;
	PreparedStatement stmt = null;
	ResultSet  rs	= null;
	
	try
		{
			
			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			
			String classValue="";
			String FACILITY_ID  =  request.getParameter("facility_id");
			String ENCOUNTER_ID =  request.getParameter("encounter_id");
			String ERROR_DATE1 = "";


			String cc_query		= "SELECT COMPLAINT_DESC,ERROR_REMARKS ,ERROR_MARKED_BY_USER ,to_char(ERROR_DATE,'dd/mm/yyyy hh24:mi') ERROR_DATE1 FROM CA_ENCNTR_CC_ERRLOG A,CA_CHIEF_COMPLAINT_LANG_VW B WHERE A.COMPLAINT_ID =B.COMPLAINT_ID AND FACILITY_ID =? AND  ENCOUNTER_ID =? AND LANGUAGE_ID=? order by ERROR_DATE DESC " ;
			
			con		= ConnectionManager.getConnection(request);
			stmt	= con.prepareStatement(cc_query);					
			
			stmt.setString(1,FACILITY_ID);
			stmt.setString(2,ENCOUNTER_ID);
			stmt.setString(3,locale);
			rs		= stmt.executeQuery();
			int i	=	0;

%>
		<title><fmt:message key="eCA.MarkedasErrorList.label" bundle="${ca_labels}"/></title>
		</head>

		<body onKeyDown='lockKey()'>
			<!-- <center> -->
				<!-- <div id='divDataTitle' style='postion:relative'> -->
					<table width='100%' id='dataTitleTable' class='grid' >
						<tr>
							<td class='COLUMNHEADERCENTER' width='25%' nowrap><fmt:message key="Common.Complaint.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADERCENTER' width='25%' nowrap><fmt:message key="eCA.ErrorMarkedBy.label" bundle="${ca_labels}"/></td>
							<td class='COLUMNHEADERCENTER' width='25%'  nowrap><fmt:message key="Common.MarkedDate.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADERCENTER' width='25%' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
						
						</tr>
					<!-- </table>
				 </div>
					<table border='1' width='100%' id='dataTable' cellpadding='3' cellspacing='0' align='center' style="border-bottom:#ffffff"> -->
						<%
											
							while(rs.next())
								{
									if(i%2==0) 
										classValue = "QRYEVEN";
									else 
										classValue = "QRYODD";
									ERROR_DATE1 = rs.getString("ERROR_DATE1")==null?"":rs.getString("ERROR_DATE1");
									ERROR_DATE1 = com.ehis.util.DateUtils.convertDate(ERROR_DATE1,"DMYHM","en",locale);//Date Conversion is done by Archana Dhal on 10/7/2010 related to IN024213.
									
						%>
						<tr>
							<td class='gridData' width='25%' nowrap> <%=rs.getString("COMPLAINT_DESC")%></td>	
							<td class='gridData' width='25%' nowrap> <%=rs.getString("ERROR_MARKED_BY_USER")%></td>	
							<td class='gridData' width='25%' nowrap> <%=ERROR_DATE1%></td>
							<td class='gridData' width='25%' > <%=rs.getString("ERROR_REMARKS")%></td> 							
						</tr>		
						
	<%		
									i++;
								}   %>
					  </table>  
	<%			
					if(rs!=null)  rs.close();
					if(stmt!=null) stmt.close();

		 }
	catch(Exception e)
	{
	//	out.println("Exception "+e.toString());//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
			
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	%>
				    <!-- </table> -->
			<!-- </center> -->
		</body>
</html>


