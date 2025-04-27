<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.Connection,java.sql.ResultSet,java.sql.Types,java.sql.CallableStatement,java.sql.PreparedStatement,java.sql.ResultSet,eOT.Common.*,eCommon.Common.CommonBean,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% String Link_Operation_And_Notes_in_Record_Surgeon_Notes = request.getParameter("Link_Operation_And_Notes_in_Record_Surgeon_Notes"); %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>

<%! 
	String encode(String data){	  
	byte byteData[] = data.getBytes();
	String outDat = "";
	for (int i=0; i<byteData.length; i++)
	{
		outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
	}
		return(outDat);
	}
%>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOT/js/RecordSurgeon.js"></script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script>
function Class_personnelrow()
{
	 this.speciality_code="";
	 this.speciality_desc="";
	 this.role_id ="";
	 this.role_desc ="";
	 this.role_type="";
	 this.practitioner_id="";
	 this.practitioner_name="";
	 this.position_desc="";
	 this.db_mode="";
	 this.recId ="";
}
	
function loadRoleDBRows(speciality_code,speciality_desc,role_id,role_desc,practitioner_id,practitioner_desc,recId,role_type,position_desc,mode){ 
	var objrow = newRow();
	var rows=parent.parent.parent.ObjectCollect.personnelrows;
	var rowLength=parent.parent.parent.ObjectCollect.personnelrowLength;
	if(rowLength==0){
	  objrow.speciality_code = speciality_code;
	  objrow.speciality_desc= speciality_desc;
	  objrow.role_id= role_id;
	  role_desc = role_desc;
	  objrow.role_desc= unescape(role_desc);
	  objrow.practitioner_id= practitioner_id;
	  objrow.practitioner_name=unescape(practitioner_desc);
	  objrow.role_type=role_type;
	  objrow.position_desc=unescape(position_desc);
	  objrow.db_mode=mode;
	  objrow.recId=recId;
	  rows.push(objrow);
	}
}

function newRow()
{
	var objrow = new Class_personnelrow();
	if(typeof(parent.parent.parent.ObjectCollect) != "undefined" && parent.parent.parent.ObjectCollect != '' && parent.parent.parent.ObjectCollect != null)
	{
		if(typeof(parent.parent.parent.ObjectCollect.personnelrows) != "undefined" && parent.parent.parent.ObjectCollect.personnelrows != '' && parent.parent.parent.ObjectCollect.personnelrows != null)
			objrow.recId = parent.parent.parent.ObjectCollect.personnelrows.length+1;
		else
			setTimeout('newRow()',500);
	}
	else
	{
		setTimeout('newRow()',500);
	}
	return(objrow);
}
</script>
<%
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String oper_num = checkForNull(request.getParameter("oper_num"));
	Connection con = null;
	CallableStatement cstmt= null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet rst = null;
	ResultSet rst1 = null;
	//Added for CHL-CRF-0020.1 [IN:043132]
	PreparedStatement pstmt_hosp = null;
	ResultSet rst_hosp = null;
	//Added for CHL-CRF-0020.1 [IN:043132]
	String err_msg = "",lang_err_txt = "";
	String tab_hide_yn = "Y";
	String disp_hosp ="";
	try{
			con = ConnectionManager.getConnection();
			//Added for CHL-CRF-0020.1 [IN:043132]
			String disp_hosp_sql = "select DISPLAY_HOSPITAL_YN from OT_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID =?";
			pstmt_hosp = con.prepareStatement(disp_hosp_sql);
			pstmt_hosp.setString(1, facility_id);
			rst_hosp = pstmt_hosp.executeQuery();
			while(rst_hosp.next()){
				disp_hosp=rst_hosp.getString(1);
			}
			if(rst_hosp!=null)rst_hosp.close();
			if(pstmt_hosp!=null)pstmt_hosp.close();				
			//	if( disp_hosp.equals("Y")){
			//Added for CHL-CRF-0020.1 [IN:043132]
			cstmt=con.prepareCall("{call OT_PROC_CODING_REQD(?,?,?,?,?)}");
			cstmt.setString(1,facility_id);
			cstmt.setString(2,oper_num);
			cstmt.registerOutParameter(3,Types.VARCHAR);
			cstmt.registerOutParameter(4,Types.VARCHAR);	
			cstmt.registerOutParameter(5,Types.VARCHAR);	
			cstmt.execute();
			err_msg = checkForNull(cstmt.getString(4));
			if("".equals(err_msg) ){
				tab_hide_yn = cstmt.getString(3);
				lang_err_txt=cstmt.getString(5);
			}
			pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PERSONNEL_SELECT2"));
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,facility_id);
			pstmt.setString(5,oper_num);
			rst = pstmt.executeQuery();
			int index = 0;
			while(rst.next())
			{
				index++;
				Thread.sleep(1000);	 //Added against SKR-SCF-1596
				out.println("<script>loadRoleDBRows('"+rst.getString("SPECIALITY_CODE")+"','"+rst.getString("SPECIALITY_DESC")+"','"+rst.getString("ROLE_ID") +"','"+(rst.getString("ROLE_DESC"))+"','"+rst.getString("PRACTITIONER_ID")+"','"+rst.getString("PRACTITIONER_NAME")+"','"+index+"','"+rst.getString("ROLE_TYPE")+"','"+encode(CommonBean.checkForNull(rst.getString("POS_DESC")))+"','L'); </script>");
			}
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(index == 0 && disp_hosp.equals("Y"))
			{
				String SQL2 = "SELECT SURGEON_CODE, GET_DESC(?,'AM_PRACTITIONER_LANG_VW','PRACTITIONER_NAME','PRACTITIONER_ID',SURGEON_CODE) " +  
						"PRACTITIONER_NAME, ANESTHETIST_CODE, GET_DESC(?,'AM_PRACTITIONER_LANG_VW','PRACTITIONER_NAME','PRACTITIONER_ID',ANESTHETIST_CODE) " + 
						"ANAESTHETIST_NAME, SPECIALITY_CODE, GET_DESC(?,'AM_SPECIALITY_LANG_VW','LONG_DESC','SPECIALITY_CODE',SPECIALITY_CODE) SPECIALITY_DESC, " + 
						"ASST_SURGEON_CODE,  GET_DESC(?,'AM_PRACTITIONER_LANG_VW','PRACTITIONER_NAME','PRACTITIONER_ID',ASST_SURGEON_CODE) " + 
						" ASST_SURGEON_NAME, ASST_SURGEON_CODE_2, GET_DESC(?,'AM_PRACTITIONER_LANG_VW','PRACTITIONER_NAME','PRACTITIONER_ID',ASST_SURGEON_CODE_2) " + 
						"ASST_SURGEON_NAME_2  FROM OT_POST_OPER_HDR HDR WHERE OPERATING_FACILITY_ID = ? AND OPER_NUM =  ?";

				String ROLE_SQL = "SELECT ROLE_DESC, ROLE_ID, ROLE_TYPE FROM OT_ROLES_LANG_VW WHERE LANGUAGE_ID= ? AND ROLE_TYPE IN ('OS', 'MA', 'AS')"
							+ "AND NVL(APPL_TO_OT_SLATE,'N') = 'N' AND NVL(STATUS,'E') = 'E'";
				pstmt1 = con.prepareStatement(ROLE_SQL);
				pstmt1.setString(1, locale);
				rst1 = pstmt1.executeQuery();
			if(pstmt!=null)
				pstmt.close();
				pstmt = con.prepareStatement(SQL2);
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,locale);
				pstmt.setString(5,locale);
				pstmt.setString(6,facility_id);
				pstmt.setString(7,oper_num);
				rst = pstmt.executeQuery();
				index = 0;
				//count of 
				int surgCount = 0;
				int anasCount = 0;
				int assSurgCount = 0;
				if(rst.next())
				{
					while(rst1.next() )
					{
						String roleId = rst1.getString("ROLE_TYPE");
						String specCode = rst.getString("SPECIALITY_CODE");
						String specDesc = rst.getString("SPECIALITY_DESC");
						String surgCode = rst.getString("SURGEON_CODE");							
				//if( disp_hosp.equals("Y")){//Added for CHL-CRF-0020.1 [IN:043132]
						if("OS".equals(roleId) && surgCode != null && (surgCount == 0))
						{
							index++;
							surgCount++;
							Thread.sleep(1000);	 //Added against SKR-SCF-1744
							out.println("<script>loadRoleDBRows('"+ specCode +"','"+ specDesc +"','"+rst1.getString("ROLE_ID") 
									+"','"+rst1.getString("ROLE_DESC")+"','" + surgCode +"','" 
									+rst.getString("PRACTITIONER_NAME")+"','"+index+"','"+rst1.getString("ROLE_TYPE")+"', '', 'I'"
									+ "); </script>");
						}									
						String asstSurgCode = rst.getString("ASST_SURGEON_CODE"); 
						if("AS".equals(roleId) && asstSurgCode != null && assSurgCount <= 1) // against IN:45275
						{
							index++;
							assSurgCount++;
							Thread.sleep(1000);	 //Added against SKR-SCF-1744
							out.println("<script>loadRoleDBRows('"+ specCode +"','"+ specDesc +"','"+rst1.getString("ROLE_ID") 
									+"','"+(rst1.getString("ROLE_DESC"))+"','"+ asstSurgCode +"','" 
									+encode(rst.getString("ASST_SURGEON_NAME"))+"','"+index+"','"+rst1.getString("ROLE_TYPE")+"', '', 'I'"
									+ "); </script>");
						}							
						asstSurgCode = rst.getString("ASST_SURGEON_CODE_2"); 
						if("AS".equals(roleId) && asstSurgCode != null && assSurgCount <= 1) // against IN:45275
						{
							index++;
							assSurgCount++;
							Thread.sleep(1000);	 //Added against SKR-SCF-1744
							out.println("<script>loadRoleDBRows('"+ specCode +"','"+ specDesc +"','"+rst1.getString("ROLE_ID") 
									+"','"+(rst1.getString("ROLE_DESC"))+"','"+ asstSurgCode +"','" 
									+ encode(rst.getString("ASST_SURGEON_NAME_2"))+"','"+index+"','"+rst1.getString("ROLE_TYPE")+"', '', 'I'"
									+ "); </script>");
						}
						String anansCode = rst.getString("ANESTHETIST_CODE");
						if("MA".equals(roleId) && anansCode != null && anasCount == 0)
						{
							index++;
							anasCount++;
							Thread.sleep(1000);	 //Added against SKR-SCF-1744
							out.println("<script>loadRoleDBRows('"+ specCode +"','"+ specDesc +"','"+rst1.getString("ROLE_ID") 
									+"','"+(rst1.getString("ROLE_DESC"))+"','"+ anansCode +"','" 
									+ encode(rst.getString("ANAESTHETIST_NAME"))+"','"+index+"','"+rst1.getString("ROLE_TYPE")+"','', 'I'"
									+ "); </script>");
						}
//									}//Added for CHL-CRF-0020.1 [IN:043132]
					}
				}
			}
			//	}
	}catch(Exception e){
		e.printStackTrace();
		System.err.println("Err Msg from RecordSurgeonTab.jsp "+e);
	}finally{
		if(cstmt!=null)cstmt.close();
		if(rst!=null)rst.close();
		if(rst1!=null)rst1.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)con.close();
	}
%>
<script language="javascript">
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload='loadOthrFrames();'>
<form name="RecordSurgeonTabForm" id="RecordSurgeonTabForm">
	<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
	<input type='hidden' name='tab_hide_yn' id='tab_hide_yn' value='<%=tab_hide_yn%>'>
	<table id="tab" cellspacing=0 cellpadding=3  border="0" width='100%' align="center" height="100%">
	<tr>
		<td width= "100%" class="white">
		<ul id="tablist" class="tablist">
			<li class="tablistitem" title='<fmt:message key="eOT.OperationDetails.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('OperationsProcedures')" class="tabclicked" id="OperationsProcedures">
					<span class="tabSpanclicked" id="OperationsProceduresspan">
					<fmt:message key="eOT.OperationDetails.Label" bundle="${ot_labels}"/></span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.PersonnelDetails.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('PersonnelDetails')" class="tabA" id="PersonnelDetails">
					<span class="tabAspan" id="PersonnelDetailsspan">
					<fmt:message key="eOT.PersonnelDetails.Label" bundle="${ot_labels}"/></span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.SurgeonNotes.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('SurgeonNotes')" class="tabA" id="SurgeonNotes">
					 <span class="tabAspan" id="SurgeonNotesspan">
					<fmt:message key="eOT.SurgeonNotes.Label" bundle="${ot_labels}"/></span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.TimeandDetails.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('TimeAndDetails')" class="tabA" id="TimeAndDetails">
					<span class="tabAspan" id="TimeAndDetailsspan">
					<fmt:message key="eOT.TimeandDetails.Label" bundle="${ot_labels}"/></span></a>
			</li>
      <% if( "N".equals(tab_hide_yn) ){ %>
      <li class="tablistitem" title='<fmt:message key="eOT.ProcedureCoding.Label" bundle="${ot_labels}"/>'>
			<a onclick="changeTab('ICDPCS')" class="tabA" id="ICDPCS" style='visible:hidden;display:Inline;'>
			<span class="tabAspan" id="ICDPCSspan" style='visible:hidden;display:Inline;'>
			<fmt:message key="eOT.ProcedureCoding.Label" bundle="${ot_labels}"/></span></a>
             </li>
      <%}else{%>

      <li class="tablistitem" title='<fmt:message key="eOT.ProcedureCoding.Label" bundle="${ot_labels}"/>'>
			<a onclick="changeTab('ICDPCS')" class="tabA" id="ICDPCS" style='visible:hidden;display:none;'>
			<span class="tabAspan" id="ICDPCSspan" style='visible:hidden;display:none;'>
			<fmt:message key="eOT.ProcedureCoding.Label" bundle="${ot_labels}"/></span></a>
        </li>
        <%}%>
	</ul>
	</td>
</tr>
</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='doc_oper_line_sent' id='doc_oper_line_sent' value=''>
<input type='hidden' name='oper_code_new' id='oper_code_new' value=''>
<input type='hidden' name='db_mode' id='db_mode' value=''>
<input type='hidden' name='oper_code_all' id='oper_code_all' value=''>
<input type='hidden' name='status_value' id='status_value' value=''>
<input type='hidden' name='Speciality_code_val' id='Speciality_code_val' value=''>
<input type='hidden' name='row_length' id='row_length' value=''>
<input type='hidden' name='spec_oper_comb' id='spec_oper_comb' value=''>
<input type='hidden' name='chk_val' id='chk_val' value=''>
<input type='hidden' name='spec_code_final' id='spec_code_final' value=''>
<input type='hidden' name='Link_Operation_And_Notes_in_Record_Surgeon_Notes' id='Link_Operation_And_Notes_in_Record_Surgeon_Notes' id='Link_Operation_And_Notes_in_Record_Surgeon_Notes' value='<%=Link_Operation_And_Notes_in_Record_Surgeon_Notes%>'>
<!-- Added for CHL-CRF-0020.1 [IN:043132] -->
<input type='hidden' name='disp_hosp' id='disp_hosp' value="<%=disp_hosp%>">
<script>prevTabObj='OperationsProcedures'</script>
<script>
function loadOthrFrames()//Chaitanya
{
	var params = document.forms[0].param.value;
	parent.RecordFrame.location.href="../../eOT/jsp/ProcedureFrames.jsp?"+params;
	parent.doc_status_frame.location.href="../../eOT/jsp/SurgeonDocStatus.jsp?"+params;
}
</script>
</form>
</body>
</html>

