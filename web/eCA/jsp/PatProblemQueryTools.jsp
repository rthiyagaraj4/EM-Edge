<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,java.util.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	 Properties p = (Properties)session.getValue("jdbc");

	String errorModify=request.getParameter("errorModify")==null?"N":request.getParameter("errorModify");
	String Patient_Id=request.getParameter("Patient_Id")==null?"":request.getParameter("Patient_Id");

%>
<html>
<head>
<!-- 	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language='javascript' src='../../eCA/js/PatProblem.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language=javascript>

async function showErrorList(){
		var patient_id=document.forms[0].Patient_Id.value;
		var retVal;
		var dialogHeight=20;
		var dialogWidth=50;
		var features='dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
		retVal=await window.showModalDialog('../../eCA/jsp/PatProblemViewErrorList.jsp?patient_id='+patient_id,arguments,features);	
}

async function markError()
{
		var value=parent.addModifyPatProblem.document.PatProblem_form.errorRemarks.value;
		var comments;
		var retVal;
		var dialogHeight ='7' ;
		var dialogWidth = '30' ;
		var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		retVal 			=await  window.showModalDialog('../../eCA/jsp/RemarksDialog.jsp?allDia=Y&resultStr='+value,arguments,features);
		
		if(retVal==undefined){
					//checking undefined			
		}else  if(retVal!=null && retVal!=''){
			parent.addModifyPatProblem.document.PatProblem_form.errorRemarks.value=retVal;
			parent.addModifyPatProblem.document.getElementById("disMar").innerHTML="<font color=yellow  size=2><fmt:message key="eCA.MarkedforError.label" bundle="${ca_labels}"/> &nbsp;&nbsp;</font>";
		}else{
			parent.addModifyPatProblem.document.getElementById("disMar").innerText="";
			parent.addModifyPatProblem.document.PatProblem_form.errorRemarks.value="";
		}
}

</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%

String authorizeButton="Y";
	String QueryString1 = request.getQueryString();
	String resp_id = (String)session.getValue("responsibility_id");
	String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	
	String auth_mode=request.getParameter("authorize")==null?"":request.getParameter("authorize");
	String Encounter_Id 		= request.getParameter("Encounter_Id");
	String Practitioner_Id		= request.getParameter("Practitioner_Id");
	String Locn_Code			= request.getParameter("Locn_Code");
	String Locn_Type			= request.getParameter("Locn_Type");
	String f_authorize_yn		= request.getParameter("f_authorize_yn");
	String Sec_Hdg_Code			= request.getParameter("Sec_Hdg_Code");
	String patient_class		= request.getParameter("patient_class");
	String invoking_function	= request.getParameter("Function");
	String context				= request.getParameter("P_context");
	String modal_yn				= request.getParameter("modal_yn")==null?"":request.getParameter("modal_yn");
	String stage_code			= request.getParameter("stage_code")==null?"":request.getParameter("stage_code");
	String stage_desc = request.getParameter("stage_desc")==null?"":request.getParameter("stage_desc");
	String logicalseqno = request.getParameter("Logical_Seq")==null?"":request.getParameter("Logical_Seq");
	String called_from_ip = request.getParameter("called_from_ip")==null?"N":request.getParameter("called_from_ip");
	
	Connection con 		= null; //(Connection) session.getValue( "connection" );
	String facilityId 		= (String) session.getValue( "facility_id" ) ;
	//Properties p			= (java.util.Properties) session.getValue( "jdbc" ) ;
	String userid = p.getProperty("login_user") ;
	PreparedStatement stmt=null;
	ResultSet rs = null;
	String patient_type=request.getParameter("patient_type");
	String sql="";
	try
	{
		con = ConnectionManager.getConnection(request);

		if(patient_type.equals("null")) patient_type="C";

		sql=   "select 'x' from mr_user_access_rights_vw where  FACILITY_ID = ?  and APPL_USER_ID = ? and ACCESS_TYPE    ='E'  and PATIENT_TYPE = ? and ACCESS_SCOPE='SD' ";
		stmt=con.prepareStatement(sql);
		stmt.setString(1, facilityId);
		stmt.setString(2, userid);
		stmt.setString(3, patient_type);
		rs=stmt.executeQuery();

		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String rec_exist="";
		try{

				sql="SELECT GET_TASK_APPLICABILITY('MARK_DIAG_ERROR',NULL,?,?,?,?,?), nvl((SELECT 'Y' FROM pr_problem_vw WHERE PATIENT_ID=? AND ERROR_YN='Y' AND ROWNUM=1),'N') ERR_EXIST   FROM DUAL";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,resp_id);
				pstmt.setString(2,reln_id);
				pstmt.setString(3,facilityId);
				pstmt.setString(4,Encounter_Id);
				pstmt.setString(5,Patient_Id);
				pstmt.setString(6,Patient_Id);
				rset=pstmt.executeQuery();

		if (rset.next()){
				rec_exist=rset.getString(2);
		}
}catch(Exception e){
		//out.println("Exception @ try "+e.toString());//COMMON-ICN-0181
	    e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(pstmt!=null)
			pstmt.close();
	if(rset!=null)
			rset.close();
}
%>

<script>
	function cancel_close()
	{
		var called_from_ip =  document.query_button.called_from_ip.value;
		if(called_from_ip == 'Y'|| document.query_button.modal_yn.value=='Y')
			parent.window.close();
		else
			cancel_a();
	}
</script>
<form name="query_button" id="query_button">

<table border="0" cellpadding="3" cellspacing="0"   width='100%'>
<tr>
<td width='80%' class='white'>
	<%
		if(rs!=null)
		{
			if(rs.next())
			{

	%>
				<input type='button' name='authorize' id='authorize' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mode.label","common_labels")%>' class='button' onclick='parent.addModifyPatProblem.chkAuthorize(this,parent.addModifyPatProblem.document.PatProblem_form.code_indicator.value)'>
	<%
						if (!auth_mode.equals("")){    %>
									<script language=javascript> 
												document.forms[0].authorize.value='<%=auth_mode%>'; 
									</script>					
<%					}
			}else{
			authorizeButton="N";

			}
		}
		//else{
		//	out.println("<script language=javascript>alert(222);</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
		//	authorizeButton="N";
		//}
	%>
	<%	if (rec_exist.equals("Y")) 
		{
			%>
			<input type='button' name='btnView' id='btnView' onclick="showErrorList();" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ViewErrorList.label","ca_labels")%>" >&nbsp;
			<%}%>
<%	if(errorModify.equals("Y")) { %>
						<input type='button' align='left' name='error' id='error' onclick="markError()" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MarkError.label","common_labels")%>">&nbsp;					
			<%}%>
<td class='white' nowrap>
<input type='Button'  name='record' id='record' title='Record' class="Button" onclick="apply1()" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>">
<input type='Button' name='clear' id='clear' title='Clear' class="Button" onclick="clearform()" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>">
<input type='Button' name='cancel' id='cancel' title ='Cancel' class="Button" onclick="cancel_close()" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>'>
</td>
<td>
<input type='hidden' name='Patient_Id' id='Patient_Id' value="<%=Patient_Id%>">
<input type='hidden' name='Encounter_Id' id='Encounter_Id' value="<%=Encounter_Id%>">
<input type='hidden' name='Practitioner_Id' id='Practitioner_Id' value="<%=Practitioner_Id%>">
<input type='hidden' name='Locn_Code' id='Locn_Code' value="<%=Locn_Code%>">
<input type='hidden' name='Locn_Type' id='Locn_Type' value="<%=Locn_Type%>">
<input type='hidden' name='f_authorize_yn' id='f_authorize_yn' value="<%=f_authorize_yn%>">
<input type='hidden' name='Sec_Hdg_Code' id='Sec_Hdg_Code' value="<%=Sec_Hdg_Code%>">
<input type='hidden' name='Invoking_Function' id='Invoking_Function' value="<%=invoking_function%>">
<input type='hidden' name='Context' id='Context' value="<%=context%>">
<input type='hidden' name='stage_code' id='stage_code' value="<%=stage_code%>">
<input type='hidden' name='stage_desc' id='stage_desc' value="<%=stage_desc%>">
<input type='hidden' name='logical_seq_no' id='logical_seq_no' value="<%=logicalseqno%>">
<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>">
<input type='hidden' name='called_from_ip' id='called_from_ip'value="<%=called_from_ip%>">
<input type='hidden' name='modal_yn' id='modal_yn'value="<%=modal_yn%>">
<input type='hidden' name='help_function_id' id='help_function_id' value='RECORD_DIAGNOSIS'>
<input type='hidden' name='QueryString1' id='QueryString1' value="<%=QueryString1%>">

<input type=hidden name=authorizeButton value="<%=authorizeButton%>">
</td>
</tr>
</table>
</form>
</body>
<%
 }catch(Exception e){
	//	out.print("checking error"+e.toString());//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
}finally{
	try{
		if (stmt != null) stmt.close();
		if (rs != null) rs.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}catch(Exception e){
	//out.print("checking error1"+e.toString());//COMMON-ICN-0181
            e.printStackTrace();//COMMON-ICN-0181
	}
 }
%>
</html>

