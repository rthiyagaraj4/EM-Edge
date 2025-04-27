<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  contentType="text/html;charset=UTF-8" import="eOT.*, eOT.Common.*, eCommon.Common.*, webbeans.eCommon.*, java.sql.Connection, java.sql.ResultSet, java.sql.PreparedStatement" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>

<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eOT/js/SwabCount.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%  Connection connection  = null;
	PreparedStatement pstmt=null;
	ResultSet resultset =null;
	StringBuffer multiple_oper_desc = new StringBuffer();
	String facility_id	= (String) session.getValue("facility_id");
	String params		= request.getQueryString() ;
	String oper_num		= request.getParameter("oper_num");
	String patient_id	= request.getParameter("patient_id");
	String patient_name	= "",sql = "",sex = "",dob= "",ref_source_type	= "",ref_source_code	= "",ward_desc	= "",oper_date	= "",speciality_code = "",surg_start_time = "",surg_end_time = "",oper_name = "";
	String qry = "0";
	String qry_mode = request.getParameter("qry_mode");
	qry_mode=qry_mode==null?"":qry_mode;
	qry_mode=qry_mode.equals("null")?"":qry_mode;
	String hide_multi_swab = "button";
	if(qry_mode.equals("YES")) 
		hide_multi_swab = "hidden";
	else
		hide_multi_swab = "button";
	try{
		qry="1";
		sql = "SELECT PATIENT_NAME, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH,DECODE(SEX,'M','Male','F','Female','Unknown') SEX FROM MP_PATIENT where PATIENT_ID=?";

		connection = ConnectionManager.getConnection(request);
		pstmt=connection.prepareStatement(sql);
		pstmt.setString(1,patient_id);
		resultset=pstmt.executeQuery();
		while(resultset.next()){
			patient_name = resultset.getString("PATIENT_NAME");
			sex = resultset.getString("SEX");
			dob =com.ehis.util.DateUtils.convertDate(resultset.getString("DATE_OF_BIRTH"),"DMY","en",locale);
		}
        
		qry="2";
		sql = "SELECT DISTINCT TO_CHAR(OPER_DATE,'DD/MM/YYYY') OPER_DATE, WARD_CODE,PATIENT_CLASS,REF_SOURCE_TYPE, REF_SOURCE_CODE, SPECIALITY_CODE FROM OT_POST_OPER_HDR WHERE OPERATING_FACILITY_ID=? AND OPER_NUM = ?";
		if(pstmt!=null) pstmt.close();		
		if(resultset!=null) resultset.close();
		pstmt=connection.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		resultset=pstmt.executeQuery();
		while(resultset.next()){
			oper_date =com.ehis.util.DateUtils.convertDate(resultset.getString("OPER_DATE"),"DMY","en",locale);
			speciality_code = resultset.getString("SPECIALITY_CODE");
			ref_source_type = resultset.getString("REF_SOURCE_TYPE");
			ref_source_code = resultset.getString("REF_SOURCE_CODE");			
		}
		oper_date=oper_date==null?"":oper_date;
		oper_date=oper_date.equalsIgnoreCase("null")?"":oper_date;
		ref_source_type=ref_source_type==null?"":ref_source_type;
		ref_source_code=ref_source_code==null?"":ref_source_code;
		ref_source_code=ref_source_code.equalsIgnoreCase("null")?"":ref_source_code;

		qry="3";
		if(ref_source_type.equals("W"))
			sql="SELECT LONG_DESC WARD_DESC FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND FACILITY_ID = ? AND NVL(EFF_STATUS,'D') = 'E' AND NURSING_UNIT_CODE=?";
		else if(ref_source_type.equals("C"))
 			sql="SELECT LONG_DESC WARD_DESC FROM OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = ? AND NVL(EFF_STATUS,'D') = 'E' AND CLINIC_CODE=?";
		else if(ref_source_type.equals("R"))
			sql="SELECT LONG_DESC WARD_DESC FROM AM_REFERRAL_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E' AND REFERRAL_CODE=?";
		else{
			sql="";
			ward_desc="";
		}
		if(!sql.equals("")){		
			if(pstmt!=null) pstmt.close();		
			if(resultset!=null) resultset.close();
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,ref_source_code);
			resultset=pstmt.executeQuery();
			while(resultset.next()){
				ward_desc = resultset.getString("WARD_DESC");
			}
			ward_desc=ward_desc==null?"":ward_desc;
			ward_desc=ward_desc.equalsIgnoreCase("null")?"":ward_desc;
		}
		qry="4";	
		sql = "SELECT TO_CHAR(SURG_START_TIME,'DD/MM/YYYY HH24:MI') SURG_START_TIME, TO_CHAR(SURG_END_TIME,'DD/MM/YYYY HH24:MI') SURG_END_TIME FROM OT_POST_OPER_DTL2 WHERE OPERATING_FACILITY_ID=? AND OPER_NUM = ? AND rownum=1";

		if(pstmt!=null) pstmt.close();		
		if(resultset!=null) resultset.close();
		pstmt=connection.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		resultset=pstmt.executeQuery();
		while(resultset.next()){
			surg_start_time = resultset.getString("SURG_START_TIME");
			surg_end_time = resultset.getString("SURG_END_TIME");
		}
		surg_start_time=surg_start_time==null?"":surg_start_time;
		surg_start_time=surg_start_time.equalsIgnoreCase("null")?"":surg_start_time;
		surg_end_time=surg_end_time==null?"":surg_end_time;
		surg_end_time=surg_end_time.equalsIgnoreCase("null")?"":surg_end_time;
 
		qry="5";	
		sql = "SELECT LONG_DESC OPER_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE A.OPER_CODE = B.OPER_CODE AND A.OPERATING_FACILITY_ID = ? AND A.OPER_NUM = ?";//MMS-QH-CRF-0199
		if(pstmt!=null) pstmt.close();		
		if(resultset!=null) resultset.close();
		pstmt=connection.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		resultset=pstmt.executeQuery();
		int multi_oper_count = 0;
		while(resultset.next()){
			multi_oper_count++;
			if(multi_oper_count==1){
				oper_name = resultset.getString("OPER_DESC");//MMS-QH-CRF-0199
				multiple_oper_desc.append(oper_name);
			}else{
				multiple_oper_desc.append(",");
				multiple_oper_desc.append(resultset.getString("OPER_DESC"));//MMS-QH-CRF-0199
			}
		}
%>
<body  onKeyDown = 'lockKey()' >
<form name="SwabCountHeaderForm" id="SwabCountHeaderForm">
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="0">
		<input type="hidden"  name="patient_id" id="patient_id" size="10" value="<%=patient_id%>" disabled>
		<input type="hidden"  name="patient_name" id="patient_name" size="25"  value="<%=patient_name%>" disabled>
		<input type="hidden" class="fields" name="sex" id="sex" size="4" value="<%=sex%>" disabled>
		<input type="hidden" class="fields" name="age" id="age" size="9" value="<%=dob%>" disabled>

		<input type="hidden" class="fields" name="ward_code" id="ward_code" size="10" value="<%=ref_source_code%>" disabled>
		<input type="hidden" class="fields" name="ward_desc" id="ward_desc" size="20" value="<%=ward_desc%>" disabled>
		<input type="hidden" class="fields" name="sex" id="sex" size="9" value="<%=oper_date%>" disabled>
<tr>
<td width="25%" class="label" >
		<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></td>
	<td width="25%" class="fields" >
		<input type="text" class="fields" name="age" id="age" size="14" value="<%=surg_end_time%>" disabled>
	</td>
	
	<td width="25%" class="label"><fmt:message key="eOT.SurgeryStartTime.Label" bundle="${ot_labels}"/></td>
	<td width="25%" class="fields" >
		<input type="text" class="fields" name="age" id="age" size="14" value="<%=surg_start_time%>" disabled>
	</td>
</tr>
<tr>
<%
	if(multi_oper_count==1){
	%>
		<td width="25%" class="label" >
			<fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>
		<td width="25%" class="fields">
			<input type="text" class="fields" name="age" id="age" size="63" value="<%=oper_name%>" disabled> <!-- Size modified against MMS-QH-CRF-0199-->
		</td>

	<%
	}else{
	%>
			<td width="25%" class="label" style="font-size:7pt;font-weight:normal;color:blue"  onMouseOver="reasonToolTip('Operations(s),<%=multiple_oper_desc%>')"  onMouseOut='hideToolTip1();' ><fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>
			<td width="25%" class="fields">
				<input type="text" class="fields" name="age" id="age" size="63" value="<%=oper_name%>" disabled> <!-- Size modified against MMS-QH-CRF-0199-->
			</td>

	<%
	}
	%>
	<td width="25%" class="fields"></td>
    
	<td width="25%" class="fields">
		<input type="button" class="button" name="print_swab_count" id="print_swab_count"  value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>'  onClick="printSwabCount()">
		<input type="<%=hide_multi_swab%>" class="button" name="record" value='<fmt:message key="eOT.Addaswabcount.Label" bundle="${ot_labels}"/>' onClick="addNewSwabCount()">
	</td>
</tr>
</table>
	<input type='hidden' name='params' id='params' value='<%=params%>' >
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="OTRSWCNT">
	<input type="hidden" name="P_NO_OF_SWAB_COUNT" id="P_NO_OF_SWAB_COUNT" id="P_NO_OF_SWAB_COUNT" value="3">

</form>
 	<div name='tooltiplayer1' id='tooltiplayer1' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'>	
	</div>
</body>
</html>
<%
	}catch(Exception e){
		System.err.println("213 Caught error: SwabCountPatientHeader: "+e);
	}finally{
		if(pstmt!=null) pstmt.close();		
		if(resultset!=null) resultset.close();		
		ConnectionManager.returnConnection(connection,request);
	}
%>

