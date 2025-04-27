<!DOCTYPE html>
<html>
<!--
												Developed by		   :		Kumar
												Developed on	 	   :	 	11/12/2001
												Modified by      		   :
												Modified Date	       :										-->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<!--<script language='javascript'src='../../eMR/js/vwActiveProblems.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
<script>
 function checkuser_event(e){	
			if(e.keyCode==13||e.keyCode==32)
				var key = new Array(13,32);
			if(key!=null){
				for(var i=0;i<key.length;i++){
					if(e.keyCode==key[i]){
						chkpasswd();
						break;
					}
				}
			}
		}

	function chkpasswd() {
	var p1 = document.Authorize_form.appl_user_passwd.value;
	var p2 = document.Authorize_form.screen_passwd.value;
	var ar = document.Authorize_form.access_rights.value;
	var nr = document.Authorize_form.no_records.value;
	var modal_yn = document.Authorize_form.modal_yn.value;

	
	
	p2 = p2.toUpperCase();	
	p1 = p1.toUpperCase();
	if(Authorize_form.screen_passwd.value==''){
				alert('APP-SM0007 Password Should be Entered');
				document.getElementById("screen_passwd").focus();
			}
	else{
	
 	if (nr==0 || ar == "N"){
		alert(getMessage("NO_AUTH_SENSITIVE_DIAGNOSIS","CA"));
		if(modal_yn == "Y"){
			// top.window.returnValue = "X" ;
			parent.parent.document.getElementById("dialog-body").contentWindow.returnValue = "X";
			parent.parent.document.getElementById("dialog_tag").close();
		}
	}else if (p1 != p2){
		alert(getMessage("PWD_MISMATCH","CA"));
		document.getElementById("screen_passwd").value="";
		document.getElementById("screen_passwd").focus();
		if(modal_yn == "Y"){
			// top.window.returnValue = "X" ;
			parent.parent.document.getElementById("dialog-body").contentWindow.returnValue = "X";
			parent.parent.document.getElementById("dialog_tag").close();
		}

	}else{
		// top.window.returnValue = "T" ;
		parent.parent.document.getElementById("dialog-body").contentWindow.returnValue = "T";
		parent.parent.document.getElementById("dialog_tag").close();
	}

	}


	/*var p1 = document.Authorize_form.appl_user_passwd.value;	
	var p2 = document.Authorize_form.screen_passwd.value;	
	var ar = document.Authorize_form.access_rights.value;
	var nr = document.Authorize_form.no_records.value;	
	if (nr==0 || ar == "N")
	{
		alert(getLabel("eMR.UnauthorisedUser.label","MR"));
	}
	else if (p1 != p2)
	{
		alert(getMessage("PWD_MISMATCH",'SM'));
	}
	else
	{
		parent.parent.window.returnValue = "T" ;
		parent.parent.window.close();
	}*/





}

function closeAuthorization(){

	top.window.returnValue = "F";
	top.window.close();
}
/*
Anjaneya Reddy added for ICN 6473.
*/
function focusObj(){
	document.getElementById("screen_passwd").focus();
}
</script>

<%
	Connection con=null;
//	PreparedStatement pstmt=null;
	//PreparedStatement stmt=null;
	Statement stmt=null;
	ResultSet rset=null ;

	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	String loginuser=p.getProperty( "login_user" ) ;
	String facilityId = (String)session.getValue("facility_id");//Maheshwaran K added for the ML-BRU-SCF-1008 [IN:043211]  as on 12/09/2013
	String P_access_type="";
	String P_access_data="" ;
	String P_patient_type="" ;
	
	String P_constr = checkForNull(request.getParameter("constr"));
	String modal_yn = request.getParameter("modal_yn");

	
	if(modal_yn == null) modal_yn="N";

	StringTokenizer st = new StringTokenizer(P_constr,"/");
	if(!(P_constr.equals("null"))){
	while(st.hasMoreTokens())
	{
			P_access_type=st.nextToken();
			P_access_data=st.nextToken();
			P_patient_type=st.nextToken();
	}
	}

	String accrights="";
	String pword="";
	int i=1;
	//StringBuffer L_access_detail = new StringBuffer("");
	StringBuffer L_rights_column = new StringBuffer("");
	String L_passwd_column="";

		if (P_access_type.equals("V")){
			//L_access_detail.append("View");
			L_rights_column.append("VW_");
		}
		else{
			//L_access_detail.append("Edit");
			L_rights_column.append("REC_");
		}

		if (P_access_data.equals("HR")){
			//L_access_detail.append(" High Risk ");
			L_rights_column.append("HIGH_RISK_");
			L_passwd_column = "HIGH_RISK_PASSWORD" ;
		}
		else{
			//L_access_detail.append(" Sensitive Diagnosis ") ;
			L_rights_column.append("SEN_DIAG_" );
			L_passwd_column = "SEN_DIAG_PASSWORD" ;
		}

		if (P_patient_type.equals("C")){
				//L_access_detail.append(" Consulting Patient" );
				L_rights_column.append("FOR_CONS_PAT_YN");
		}
		else {
			L_rights_column.append("FOR_OTH_PAT_YN") ;
		}
%>
	

</head>
<body onKeyDown="lockKey()" onLoad='focusObj()'>
		<form name='Authorize_form' id='Authorize_form' >
			<div align='center'><br>
<%
		try{
		con=ConnectionManager.getConnection(request);
		

		

		/*String sql  = " Select ? access_rights_yn , app_password.decrypt(?) password from mr_user_access_rights where appl_user_id =?";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,L_rights_column.toString());
		stmt.setString(2,L_passwd_column);
		stmt.setString(3,loginuser);*/
		//Maheshwaran K added facility id in the query for the ML-BRU-SCF-1008 [IN:043211]  as on 12/09/2013
		String sql  = " Select "+L_rights_column.toString()+" access_rights_yn , app_password.decrypt("+L_passwd_column+") password from mr_user_access_rights where appl_user_id ='"+loginuser+"' and FACILITY_ID= '"+facilityId+"'";
		
		stmt=con.createStatement();
		rset=stmt.executeQuery(sql);
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
			<table align="center" width="80%" border=0 cellspacing=0 cellpadding=0>
			
			<tr><td colspan=2 >&nbsp</tr>
			<tr>
					<td width="50%" align="center" class="label"><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
					 <td width="50%" align="left" colspan="2">&nbsp;&nbsp;
					<input type="password"  name="screen_passwd" id="screen_passwd" size="20" maxlength="20" onkeypress="checkuser_event(event)"></td>

			</tr>
				<tr><td colspan=2 >&nbsp</tr>
			<tr>
					 <td width="50%" class='button' >
					 <%-- <input type='button' name='ok' id='ok' onClick="chkpasswd();" value='   <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>   '  class='button'> --%>
					 <td width="50%" class='button' >&nbsp;&nbsp;
					 <input type='button' name='ok' id='ok' onClick="chkpasswd();" value='   <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>   '  class='button'>
					 <input type='button' name='cancel' id='cancel' onClick="closeWindow();" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>'  class='button'>
					 </td>
			</tr>
			</table>
			<!--Password &nbsp;
			<input type="password"  name="screen_passwd" id="screen_passwd" size="8" maxlength="8" ><br><br>

			 <input type='button' name='ok' id='ok' onClick="chkpasswd();" value='   OK   '  class='button'>
			 <input type='button' name='cancel' id='cancel' onClick="closeAuthorization();" value='Cancel'  class='button'>-->

<input type="hidden" name="appl_user_passwd" id="appl_user_passwd" value='<%=pword%>'>
<input type="hidden" name="access_rights" id="access_rights" value='<%=accrights%>'>
<input type="hidden" name="no_records" id="no_records" value='<%=i%>'>
<input type="hidden" name="modal_yn" id="modal_yn" value='<%=modal_yn%>'>
<%
		if(stmt!=null) stmt.close();
		if(rset!=null) rset.close();

}
	catch (Exception e){
		//out.println("Exception "+e.toString());
		e.printStackTrace();
	}
	finally {
		ConnectionManager.returnConnection(con,request);
	}

%>
</div>
</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
<script>
function closeWindow() {
	 const dialogTag = parent.parent.document.getElementById('dialog_tag');    
	    dialogTag.close();   
}</script>
