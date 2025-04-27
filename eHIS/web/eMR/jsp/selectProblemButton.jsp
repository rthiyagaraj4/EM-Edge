<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8"  import ="webbeans.eCommon.*,java.sql.*,java.util.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
	<%  request.setCharacterEncoding("UTF-8"); %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eMR/js/RecDiagnosis.js' language='javascript'></script>
	<script src='../../eMR/js/RecDiagnosisMain.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>


<%
				
		Properties p			= (java.util.Properties) session.getValue( "jdbc" ) ;
		String userid			= p.getProperty("login_user") ;
		String locale			= (String) p.getProperty("LOCALE");
		String facilityId 		= (String) session.getValue( "facility_id" ) ;
		String encounter_id		= request.getParameter("encounter_id");
		String patient_id		= request.getParameter("patient_id");
		String callFunction     = request.getParameter("callFunction");
		Connection con 			= null;
		PreparedStatement stmt	= null;
		ResultSet rs			= null;
		String sql				= "";
	try
	{
		
		con = ConnectionManager.getConnection(request);

		sql=   "select a.complaint_id complaint_id, complaint_desc, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,?,'2') complaint_text,a.remarks, to_char(a.onset_datetime,'dd/mm/yyyy HH24:MI') onset_datetime_str from ca_encntr_chief_complaint a where a.facility_id=? and a.encounter_id=? order by a.onset_datetime desc ";
		
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,facilityId);
		stmt.setString(3,encounter_id);
		rs = stmt.executeQuery();

		%>
		<body onKeyDown='lockKey()'>
		<form name='selectProblemButton' id='selectProblemButton' >
		<table border=0 cellspacing=0 cellpadding=0 width="100%">
			<tr align="right">
		<%
		if(rs.next())
		{
			if(!callFunction.equals("showProblem"))
			{
		%>
		<td class='button'>
		<input type='button' class='button' name='ok' id='ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onclick='selectComplaint()'>
		<input type='button' class='button' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onclick='parent.parent.document.getElementById("dialog_tag").close();'></td>
		<%
			}else{
			%>
				
				<td class='button'><input type='button' class='button' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick='parent.parent.document.getElementById("dialog_tag").close();'></td>
		  <%}
		}
		%>	
			</tr>
		</table>	
	
		
		
	</form>
	</body>
	<%

	}catch(Exception e){
		//out.print("checking error"+e.toString());
		e.printStackTrace();
}finally{
	try{
		if (stmt != null) stmt.close();
		if (rs != null) rs.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}catch(Exception e){
	//out.print("checking error1"+e.toString());
	e.printStackTrace();
	}
 }
%>

</html>
		

