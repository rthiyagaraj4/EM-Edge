<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
      	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' /> 

        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
   	
<%
	//Connection conn= (Connection) session.getValue("connection");
	Connection conn=null;
	PreparedStatement stmt=null;
	ResultSet rs	 =null;
 
	String patientid=request.getParameter("patientid");
	//String context=request.getParameter("context");
    String context = (String)request.getParameter("PQ");
	if (context==null) context="Y";

	String P_access_type="V";
	String P_access_data="HR";
	String facilityId 		= (String) session.getValue( "facility_id" ) ;
	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	String login_user=p.getProperty( "login_user" ) ; 
	StringBuffer sql = new StringBuffer();


	sql.append("select '1' from mr_user_access_rights_vw where ");
	sql.append(" facility_id=? and appl_user_id=? and access_type='V' ");

	if (context.equals("Y"))
		sql.append(" and patient_type='C' ");
	else
		sql.append( " and patient_type='O' ");

	sql.append(" and  access_scope='HR'");
	sql.append(" and exists(select 'x' from pr_high_risk_condition where patient_id=? ");
	sql.append(" and close_date is null and rownum<2)");


	try
	{
  	    conn = ConnectionManager.getConnection(request);
		stmt = conn.prepareStatement(sql.toString());
		stmt.setString(1,facilityId);
		stmt.setString(2,login_user);
		stmt.setString(3,patientid);
		rs=	stmt.executeQuery();
	%>
      	
      	<script>
			var Highrisk_Status="N";
				      	function HighRisk()
				      	{		
				      	var P_access_type=document.forms[0].P_access_type.value;
								var P_access_data=document.forms[0].P_access_data.value;
								var Context=document.forms[0].Context.value;
									
									if (Highrisk_Status=="N")
									{
											
											
											parent.ChartSummaryMedicalAlertsFrame.location.href='../../eCA/jsp/AuthorizeHRC.jsp?patientid=<%=patientid%>&Context=<%=context%>&jsp_name=QryPatSumHRC.jsp&B_jsp_name=QryPatSHRCblank.jsp&context=<%=context%>'
																					
											
											//document.location.href=call		 
											
									}

									/*if(document.forms[0].highrisk.checked==false)
									{
											

									}*/
								}			
			     	</script>
      	
      	
  
</head>     	
<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<form name="HRCblank" id="HRCblank">




<table border align=center cellpadding='0' cellspacing='0' width='100%'>
<!--<th align=center>High Risk&nbsp;<input type=checkbox 
  name="highrisk" id="highrisk" onclick=HighRisk()>
</th>-->
<td align=center>
	<%
		String enable="disabled";
		if(rs!=null)
			if(rs.next())
				enable="";

			out.print("<input type='button' name='highrisk' id='highrisk' value='&nbsp;&nbsp;&nbsp;High Risk&nbsp;&nbsp;&nbsp;&nbsp;' "+enable+" class='button' onclick=HighRisk()>");
	%>
</td>
</table>

<input type="hidden" name="P_access_type" id="P_access_type" value=<%=P_access_type %>>
<input type="hidden" name="P_access_data" id="P_access_data" value=<%=P_access_data %>>

<input type="hidden" name="Context" id="Context" value=<%=context %>>


</form>
</body>
</html>

<%

	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}

catch(Exception e){
	//out.print(e);//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally{	
	
	if (conn != null) ConnectionManager.returnConnection(conn,request);
}

	%>


