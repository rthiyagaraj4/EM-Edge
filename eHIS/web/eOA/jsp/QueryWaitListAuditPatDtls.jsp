<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%
request.setCharacterEncoding("UTF-8");
Connection conn=null;
ResultSet rs1=null;
Statement stmt=null;
String fac_id		= (String) session.getValue( "facility_id" ) ;
String patient_id=request.getParameter("patient_id");
String patientname=request.getParameter("patientname");
String waitlistnum=request.getParameter("waitlistnum");
if (!patientname.equals(""))
	{
		patientname		= 	patientname + "%" ;
	}
String gender="";
String date_of_birth="";
PreparedStatement pstmt=null;
try {
	conn = ConnectionManager.getConnection(request);
	stmt=conn.createStatement();
	%>
<HTML>

<head>
	<script src="../../eOP/js/menu.js" language="JavaScript1.2"></script>
	<script src="../../eOA/js/QueryWaitListAudit.js"></script>

	<%
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()' >

<form name='pat_details_form' id='pat_details_form'>
	<%
		//String sql="select PATIENT_ID,PATIENT_NAME ,GENDER,get_age(DATE_OF_BIRTH )DATE_OF_BIRTH from pr_wait_list where WAIT_LIST_NO='"+waitlistnum+"' and FACILITY_ID='"+fac_id+"'";
		String sql="select PATIENT_ID,PATIENT_NAME ,GENDER,get_age(DATE_OF_BIRTH )DATE_OF_BIRTH from pr_wait_list where WAIT_LIST_NO=? and FACILITY_ID=?";
	//	rs1=stmt.executeQuery(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,waitlistnum);
		pstmt.setString(2,fac_id);
		rs1 = pstmt.executeQuery();
		if(rs1 !=null && rs1.next())
		{
			patient_id=rs1.getString("PATIENT_ID");
			if(patient_id ==null) patient_id="";
			patientname=rs1.getString("PATIENT_NAME");
			if(patientname==null)patientname="";
			gender=rs1.getString("GENDER");
			String gender_desc="";	
			if(gender.equals("M"))
			{
			gender_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			}else if(gender.equals("F"))
			{
			gender_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			}else if(gender.equals("U"))
			{
			gender_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			}


			date_of_birth=rs1.getString("DATE_OF_BIRTH");
		
%>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>	
	<td width="5%" class='PATIENTLINECOLOR' style='position:relative;' nowrap><%=patient_id%> | <%=patientname%> | <%=gender_desc%>| <%=date_of_birth%></td>
	</tr>
<%
	}
	if(stmt !=null) stmt.close();
	if(rs1 !=null) rs1.close();

}catch ( Exception e ){
	//out.println("Exception " +e);
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally{
		ConnectionManager.returnConnection(conn,request);
}
%>
</table>
</form>
</body>
</html>

