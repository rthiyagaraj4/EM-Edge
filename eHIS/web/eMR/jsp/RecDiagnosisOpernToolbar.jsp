<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8"  import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>

	<%
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
	<%  request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eMR/js/RecDiagnosis.js' language='javascript'></script>
	<script src='../../eMR/js/RecDiagnosisMain.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>



<%
		String authorizeButton="Y";		
		
		String auth_mode		= request.getParameter("authorize")==null?"":request.getParameter("authorize");
		
		String facilityId 		= (String) session.getValue( "facility_id" ) ;
		Properties p			= (java.util.Properties) session.getValue( "jdbc" ) ;
		String userid = p.getProperty("login_user") ;
		
		String patient_type			= request.getParameter("patient_type")==null?"C":request.getParameter("patient_type");
		String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":(String)request.getParameter("p_called_from_widget"); //CHL-CRF- 0008 - IN:001472
		
		
		String Patient_Id = request.getParameter("Patient_Id")==null?"":request.getParameter("Patient_Id");		
		String Encounter_Id=request.getParameter("Encounter_Id")==null?"":request.getParameter("Encounter_Id");
		String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id"); //Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
		//out.println("Patient_Id=>"+Patient_Id+"=Encounter_Id=>"+Encounter_Id);
		int priciplecount=0;
		String diag_class_yn="";
		
		
		Connection con 		= null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		String sql="";
	try
	{
		
		con = ConnectionManager.getConnection(request);

		//Added by Sangeetha for ML-MMOH-SCF-0714 on 15/may/17
		String renameAsteriskToDagger_yn = eMR.MRCommonBean.getRenameToDaggerYN(con);
		
		/*Below line Added for this CRF */
		//Maheshwaran k commented the below query and modified as on 17/09/2013
		//String priciplediag="select count(*) as principlediagcount from pr_diagnosis where curr_encounter_id=? and patient_id=? and curr_facility_id=? and CURR_STATUS='A' and DIAG_CLASS_CODE in ( select DIAG_CLASS_CODE from mr_diag_class where DIAG_CLASS_TYPE='PD'and EFF_STATUS='E')";
		String priciplediag="select count(*) as principlediagcount from pr_diagnosis_enc_dtl where encounter_id=? and patient_id=? and facility_id=? and STATUS='A' and DIAG_CLASS_CODE in ( select DIAG_CLASS_CODE from mr_diag_class where DIAG_CLASS_TYPE='PD'and EFF_STATUS='E')";
		
		
		
		stmt=con.prepareStatement(priciplediag);
		stmt.setString(1, Encounter_Id);
		stmt.setString(2, Patient_Id);
		stmt.setString(3, facilityId);
		rs=stmt.executeQuery();
		if(rs.next()){
		priciplecount=rs.getInt("principlediagcount");
		}
		if (stmt != null) stmt.close();
		if (rs != null) rs.close();
		
		
		stmt=con.prepareStatement("select DIAG_CLASS_MAND_YN from MR_PARAMETER");		
		rs=stmt.executeQuery();
		if(rs.next()){
		diag_class_yn=rs.getString("DIAG_CLASS_MAND_YN");
		if(diag_class_yn==null)diag_class_yn="N";
		}
		if (stmt != null) stmt.close();
		if (rs != null) rs.close();
		
		
		
		//End
		
		

		sql=   "select 'x' from mr_user_access_rights_vw where  FACILITY_ID = ?  and APPL_USER_ID = ? and ACCESS_TYPE    ='E'  and PATIENT_TYPE = ? and ACCESS_SCOPE='SD' ";
		
		stmt=con.prepareStatement(sql);
		stmt.setString(1, facilityId);
		stmt.setString(2, userid);
		stmt.setString(3, patient_type);
		rs=stmt.executeQuery();

		%>
		<body onKeyDown='lockKey()'>
		<form name='RecDiagAddModifyForm' id='RecDiagAddModifyForm' >
		<table border=0 cellspacing=0 cellpadding=0 width="100%">
			<tr>
		<%
		if(rs.next())
		{
			%>
			<td align='left' width='10%'><input style=" margin-left: 20px;" type="button" name="authorize" id="authorize" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")%>&nbsp;<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mode.label","common_labels")%>' class='button' onclick="parent.RecDiagnosisAddModify.chkAuthorize(document.forms[0].mode,parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_indicator.value)"><input type="hidden" name="mode" id="mode" value="Authorize Mode">
			</td>
			<%
				if(!auth_mode.equals(""))
			{
				%>
					<script>
						document.forms[0].authorize.value='<%=auth_mode%>'
						document.forms[0].mode.value='<%=auth_mode%>'
					</script>
				<%
			}
				
		}
		else
		{
			%>
			<td align='left' width='10%'><input style=" margin-left: 20px;" type="button" name="authorize" id="authorize" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")%>&nbsp;<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mode.label","common_labels")%>' class='button' onclick="parent.RecDiagnosisAddModify.chkAuthorize(document.forms[0].mode,parent.RecDiagnosisAddModify.document.RecDaignosis_form.code_indicator.value)" disabled><input type="hidden" name="mode" id="mode" value="Authorize Mode">
			</td>

			<%
				if(!auth_mode.equals(""))
			{
				%>
					<script>
						document.forms[0].authorize.value='<%=auth_mode%>'
						document.forms[0].mode.value='<%=auth_mode%>'
					</script>
				<%
			}

			authorizeButton="N";
		}
	%>
	
				
				<td align='left' >				
				<b><font align='left' size='1' color='blue'><a href="javascript:;" onclick="callNotifiableNotes()" id='notice_anchor'></a></font>&nbsp;</b></td> 
				<td align='right' style="padding-right: 40px;" class='button'><span name="principle_diag" id="principle_diag" style="background-color:red;visibility: hidden;font-size:12px"><font color='yellow' ><b><fmt:message key="eMR.PrincipleDiagnosisnotrecorded.label" bundle="${mr_labels}"/></b></font>&nbsp&nbsp;&nbsp&nbsp;</span>&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;<input type='button' class='button' name='record' id='record' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' onclick='Record()'><input type='Button' name='clear' id='clear' value=' <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%> ' class="button" onclick='clearform()'><input type='button' class='button' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onclick='cancel_a()' <%if(!"".equals(p_called_from_widget)){%>disabled<%}%>></td>  <!-- CHL-CRF- 0008 - IN:001472 -->
			</tr>
		</table>	
	
		<input type="hidden" name = "as_evidenced_by" value = "">
		<input type="hidden" name = "as_evidenced_by1" value = "">
		<input type="hidden" name = "patient_id" value = "">
		<input type="hidden" name="authorizeButton" id="authorizeButton" value="<%=authorizeButton%>">
		<!-- Added by Sangeetha for ML-MMOH-SCF-0714 on 15/may/17 -->
		<input type="hidden" name="renameAsteriskToDagger_yn" id="renameAsteriskToDagger_yn" value="<%=renameAsteriskToDagger_yn%>">
		<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
		
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
<script>

if('<%=priciplecount%>'==0 && '<%=diag_class_yn%>'=="Y")
{
document.getElementById('principle_diag').style.visibility = "visible";
}
</script>
</html>
		

