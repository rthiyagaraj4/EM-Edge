<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../js/PatHighRisk.js" language="javascript"></SCRIPT>
<%
	Connection con =null;

	

	String loginuser=(String) session.getValue( "login_user" ) ;
	String P_access_type="";
	String P_access_data="" ;
	String P_patient_type="" ;
	
	String P_constr = request.getParameter("constr");

	String modal_yn = request.getParameter("modal_yn");
	if(modal_yn == null) modal_yn="N";

	String facilityId = (String)session.getValue("facility_id");
	if(P_constr==null) P_constr="";
	StringTokenizer st = new StringTokenizer(P_constr,"/");
	while(st.hasMoreTokens())
	{
			
			  P_access_type=st.nextToken();
				P_access_data=st.nextToken();
				P_patient_type=st.nextToken();
			
	}

	String accrights="";
	String pword="";
	int i=1;
	StringBuffer L_access_detail = new StringBuffer();
	StringBuffer L_rights_column =  new StringBuffer();
	String L_passwd_column="";
		L_access_detail.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels"));
		L_access_detail.append(" - ");

		if (P_access_type.equals("V"))
		{			
			L_rights_column =  new StringBuffer();
			L_access_detail.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels"));
			L_rights_column.append("VW_");
		}
		else
		{
			L_access_detail =  new StringBuffer();
			L_rights_column =  new StringBuffer();
			L_access_detail.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels"));
			L_rights_column.append("REC_");
		}

		if (P_access_data.equals("HR")){
			L_access_detail.append(" ");
			L_access_detail.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HighRisk.label","common_labels"));
			L_rights_column.append("HIGH_RISK_" );
			L_passwd_column = "HIGH_RISK_PASSWORD" ;
		}
		else{
			L_access_detail.append(" ");
			L_access_detail.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SensitiveDiagnosis.label","common_labels"));
			L_rights_column.append("SEN_DIAG_" );
			L_passwd_column = "SEN_DIAG_PASSWORD" ;
		}

		if (P_patient_type.equals("C")){
				L_access_detail.append(" ");
				L_access_detail.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ConsultingPatient.label","common_labels") );
				L_rights_column.append("FOR_CONS_PAT_YN" );
		}
		else {
			L_access_detail.append(" ");
			L_rights_column.append("FOR_OTH_PAT_YN" );
		}
		
%>
<head>
	<title><%=L_access_detail.toString() %></title>

</head>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onload='document.getElementById("screen_passwd").focus()'>
		<form name='Authorize_form' id='Authorize_form' >
			<div align='center'><br>
<%
		try
		{
		con=ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rset=null ;	
		String sql  = " Select "+L_rights_column.toString()+" access_rights_yn , upper(app_password.decrypt("+L_passwd_column+")) password from mr_user_access_rights where appl_user_id =? and facility_id=?";
	
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,loginuser);
		pstmt.setString(2,facilityId);
		rset=pstmt.executeQuery();

		if(!(rset.next()))
		{
			i = 0;
		}
		else
		{
			do
			{
			accrights = rset.getString("access_rights_yn");
			pword = rset.getString("password");
			}while(rset.next());

		}

%>
			<table align="center" width="90%" border=0 cellspacing=0 cellpadding=3>
			<tr>
					<td align="center"><fmt:message key="Common.password.label" bundle="${common_labels}"/><!-- </td> -->
					<!--  <td width="50%" align="left" colspan="2"> -->
					<input type="password"  name="screen_passwd" id="screen_passwd" size="18" maxlength="18" onkeypress = 'return disallowEnterKey()'></td>

			</tr>
				<tr><td colspan=3 >&nbsp&nbsp&nbsp</td></tr> 
			<tr>
					 <td align='center'>&nbsp&nbsp&nbsp&nbsp
					 <input type='button' name='ok' id='ok' onClick="chkpasswd();" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' class='button'><input type='button' name='cancel' id='cancel' onClick="closeAuthorization();" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button'>
					 </td>
			</tr>
			</table>

			<input type="hidden" name="appl_user_passwd" id="appl_user_passwd" value='<%=pword%>'>
			<input type="hidden" name="access_rights" id="access_rights" value='<%=accrights%>'>
			<input type="hidden" name="no_records" id="no_records" value='<%=i%>'>
			<input type="hidden" name="modal_yn" id="modal_yn" value='<%=modal_yn%>'>
<%
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
}
catch (Exception e)
{
	//out.println("Exception in  AuthorizeMRAccess.jsp:"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if (con != null) ConnectionManager.returnConnection(con,request);
}

%>
</div>
</form>
</body>
</html>

