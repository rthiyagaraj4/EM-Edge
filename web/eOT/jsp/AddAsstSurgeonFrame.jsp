<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<html>
<%@page  import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*" %>
<% 	
	String tab_name	= checkForNull(request.getParameter("tab_name"));// Added by Gaurav Against ML-MMOH-CRF-1791-US03...
	if(tab_name.equals("SLATE")){
%>
	<title>Assign Surgeon</title>	
<%
	}else{
%>
<title>
<fmt:message key="eOT.AsstSurgeon.Label" bundle="${ot_labels}"/>
</title>
<%
	}
%>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonLookup.js" language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script src='../../eOT/js/Booking.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="addAsstSurgForm" id="addAsstSurgForm">
<%	
	final String  empty = "".intern();
	String facility_id		= checkForNull(request.getParameter("facility_id"));
	String booking_no	= checkForNull(request.getParameter("booking_no"));	
	String splty_code	= checkForNull(request.getParameter("speciality_code"));
	String appt_ref_num	= checkForNull(request.getParameter("appt_ref_num"));// Added by Gaurav Against ML-MMOH-CRF-1791-US03...
	String oper_num	= checkForNull(request.getParameter("oper_num"));// Added by Gaurav Against ML-MMOH-CRF-1791-US03...
	String auto_schdl_yn	= checkForNull(request.getParameter("auto_schdl_yn"));// Added by Gaurav Against ML-MMOH-CRF-1791-US03...
	String surgeon_code2	= checkForNull(request.getParameter("surgeon_code2"));// Added by Gaurav Against ML-MMOH-CRF-1791-US03...
	String asstSurgCode1=empty;
	String asstSurgCode2=empty;
	String asstSurgDesc1=empty;
	String asstSurgDesc2=empty;
	String surgeon_code=empty;
	String surgeon_desc=empty;
	
	Connection connection  = null;
	PreparedStatement pstmt=null;
	ResultSet resultset =null;
	connection = ConnectionManager.getConnection(request);
	//Commented by Sharon Crasta on 6/1/2009 for IN010489(SRR20056-SCF-2987)
	//Changed SHORT_NAME to PRACTITIONER_NAME
	//String sql="SELECT ASST_SURGEON_CODE,ASST_SURGEON_CODE_2,GET_DESC(?,'AM_PRACTITIONER_LANG_VW','SHORT_NAME','PRACTITIONER_ID',ASST_SURGEON_CODE) ASST_SURGEON_DESC,GET_DESC(?,'AM_PRACTITIONER_LANG_VW','SHORT_NAME','PRACTITIONER_ID',ASST_SURGEON_CODE_2) ASST_SURGEON_DESC2,TEAM_DOCTOR_CODE SURGEON_CODE, GET_DESC(?,'AM_PRACTITIONER_LANG_VW','SHORT_NAME','PRACTITIONER_ID',TEAM_DOCTOR_CODE) SURGEON_DESC FROM OT_BOOKING_HDR WHERE OPERATING_FACILITY_ID=? AND BOOKING_NUM=?";
	String sql="SELECT ASST_SURGEON_CODE,ASST_SURGEON_CODE_2,GET_DESC(?,'AM_PRACTITIONER_LANG_VW','PRACTITIONER_NAME','PRACTITIONER_ID',ASST_SURGEON_CODE) ASST_SURGEON_DESC,GET_DESC(?,'AM_PRACTITIONER_LANG_VW','PRACTITIONER_NAME','PRACTITIONER_ID',ASST_SURGEON_CODE_2) ASST_SURGEON_DESC2,TEAM_DOCTOR_CODE SURGEON_CODE, GET_DESC(?,'AM_PRACTITIONER_LANG_VW','SHORT_NAME','PRACTITIONER_ID',TEAM_DOCTOR_CODE) SURGEON_DESC FROM OT_BOOKING_HDR WHERE OPERATING_FACILITY_ID=? AND BOOKING_NUM=?";
	//Changes End here
	try{
		pstmt=connection.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,facility_id);
		//pstmt.setString(3,"142");
		pstmt.setString(5,booking_no);
		resultset=pstmt.executeQuery();
		while(resultset.next()){
			asstSurgCode1 = checkForNull(resultset.getString(1));		
			asstSurgCode2= checkForNull(resultset.getString(2));		
			asstSurgDesc1 = checkForNull(resultset.getString(3));		
			asstSurgDesc2 = checkForNull(resultset.getString(4));		
			surgeon_code = checkForNull(resultset.getString(5));		
			surgeon_desc = checkForNull(resultset.getString(6));		
		}
	}catch(Exception e){
		System.err.println("62 :Exception in AddAsstSurgeonFrame.jsp"+e);
	}finally{
		if(resultset!=null) resultset.close();
		if(pstmt!=null) pstmt.close();		
		ConnectionManager.returnConnection(connection,request);
	}

	
//String disable1 = (asstSurgCode1.equals(""))?"":"readonly";
//String disable2 = (asstSurgCode2.equals(""))?"":"readonly";
	
%>
<table border='0' cellpadding=3  cellspacing='' align='center'  width='100%' >
	<tr>
		<td class='label' width='25%' >
				<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> &nbsp;
				</td>
				 <td class="fields" width="25%" colspan="3">
					<input type='hidden' name='surgeon_code' id='surgeon_code' value="<%=surgeon_code%>" > 
					<input type='text' name='surgeon_desc' id='surgeon_desc' size='20' value= "<%=surgeon_desc%>" onchange="if(this.value!='') searchSurgon(surgeon_desc,surgeon_code); else surgeon_code.value='' ">
					<input type='button' class='button' value='?' name='btnSurg' id='btnSurg' onClick="searchSurgon(surgeon_desc,surgeon_code);">
					<img src='../../eCommon/images/mandatory.gif'></img></td><!--Added by Gaurav Against ML-MMOH-CRF-1791-US03-->
				</td>
			</tr>
		<td class='label' width='25%' >
				<fmt:message key="eOT.AsstSurgeon.Label" bundle="${ot_labels}"/> &nbsp;1
				</td>
				 <td class="fields" width="25%" colspan="3">
					<input type='hidden' name='asst_surgeon_code1' id='asst_surgeon_code1' value="<%=asstSurgCode1%>" > 
					<input type='text' name='asst_surgeon_name1' id='asst_surgeon_name1' size='20' value= "<%=asstSurgDesc1%>" onchange="if(this.value!='') searchAsstSurgeon(asst_surgeon_name1,asst_surgeon_code1); else asst_surgeon_code1.value='' ">
					<input type='button' class='button' value='?' name='btnAsstSurg1' id='btnAsstSurg1' onClick="searchAsstSurgeon(asst_surgeon_name1,asst_surgeon_code1);">
				</td>
			</tr>
			<tr>
			<td class='label' width='25%' >
				<fmt:message key="eOT.AsstSurgeon.Label" bundle="${ot_labels}"/> &nbsp;2
				</td>
				 <td class="fields" width="25%" colspan="3">
					<input type='hidden' name='asst_surgeon_code2' id='asst_surgeon_code2' maxlength='15' size='15'  value= "<%=asstSurgCode2%>" >
					<input type='text' name='asst_surgeon_name2' id='asst_surgeon_name2' size='20' value= "<%=asstSurgDesc2%>" onchange="if(this.value!='') searchAsstSurgeon(asst_surgeon_name2,asst_surgeon_code2); else asst_surgeon_code2.value='' ">
					<input type='button' class='button' value='?' name='btnAsstSurg2' id='btnAsstSurg2' onClick="searchAsstSurgeon(asst_surgeon_name2,asst_surgeon_code2);">
				</td>
			</tr>
		<tr>
			<td class='label' width="25%"> </td>
			<td class="button" width="25%" colspan="3">
				<input type="button" class="button" name="OK" id="OK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="saveAsstSurgeons();">
				<input type="button" class="button" name="Cancel" id="Cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="parent.parent.document.getElementById('dialog_tag').close();">
			</td>
		</tr>

</table>



<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>" >	
<input type='hidden' name='booking_no' id='booking_no' value="<%=booking_no%>" >			
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='speciality_code' id='speciality_code' value="<%=splty_code%>">
<input type='hidden' name='asstSurgCode' id='asstSurgCode' value="<%=asstSurgCode1%>">
<!--Added by Gaurav against ML-MMOH-CRF-1791-US03...starts-->
<input type='hidden' name='tab_name' id='tab_name' value="<%=tab_name%>">
<input type='hidden' name='appt_ref_num' id='appt_ref_num' value="<%=appt_ref_num%>">
<input type='hidden' name='oper_num' id='oper_num' value="<%=oper_num%>">
<input type='hidden' name='auto_schdl_yn' id='auto_schdl_yn' value="<%=auto_schdl_yn%>">
<input type='hidden' name='surgeon_code2' id='surgeon_code2' value="<%=surgeon_code2%>">
<!--Added by Gaurav against ML-MMOH-CRF-1791-US03...ends-->
</form>
</body>
</html>

