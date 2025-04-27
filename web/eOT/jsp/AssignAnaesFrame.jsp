<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*" %>
<% 	
	Connection connection  = null;
	PreparedStatement pstmt=null;
	ResultSet resultset =null;
	String facility_id	=null;
	String anaesthetist1_code="";
	String short_name="";
	//String facility_id		= CommonBean.checkForNull(request.getParameter("facility_id"));
	facility_id		= CommonBean.checkForNull(request.getParameter("facility_id"));
	String patient_id	= CommonBean.checkForNull(request.getParameter("patient_id"));
	String booking_no	= CommonBean.checkForNull(request.getParameter("booking_no"));	
try{
%>
<title>
<fmt:message key="eOT.AssignAnaesthetist.Label" bundle="${ot_labels}"/>
</title>

<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonLookup.js" language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script src='../../eOT/js/AssignAnaesthetist.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="assignAnaesForm" id="assignAnaesForm">
<%	
	connection = ConnectionManager.getConnection(request);			
	//String sql="SELECT ANAESTHETIST1_CODE FROM OT_BOOKING_HDR WHERE OPERATING_FACILITY_ID= ? AND BOOKING_NUM = ? ";			
	//Modified by Rajesh on 01/12
	//String sql="SELECT ANAESTHETIST1_CODE, SHORT_NAME FROM OT_BOOKING_HDR A, AM_PRACTITIONER_LANG_VW B WHERE A.OPERATING_FACILITY_ID= ? AND B.LANGUAGE_ID=? AND A.BOOKING_NUM =? AND B.PRACTITIONER_ID=A.ANAESTHETIST1_CODE ";
	String sql="SELECT ANAESTHETIST1_CODE, SHORT_NAME FROM OT_BOOKING_HDR A, AM_PRACTITIONER_LANG_VW B WHERE A.OPERATING_FACILITY_ID= ? AND B.LANGUAGE_ID=? AND A.BOOKING_NUM =? AND B.PRACTITIONER_ID=A.ANAESTHETIST1_CODE ";
	pstmt=connection.prepareStatement(sql);
	pstmt.setString(1,facility_id);
	pstmt.setString(2,locale);
	pstmt.setString(3,booking_no);
	resultset=pstmt.executeQuery();
	while(resultset.next()){
		short_name = CommonBean.checkForNull(resultset.getString("SHORT_NAME"));		
	}
	/*if(!anaesthetist1_code.equals("")){
		String sql1="SELECT SHORT_NAME FROM SY_PHYSICIAN_MAST WHERE PHYSICIAN_ID = ? ";
		pstmt=connection.prepareStatement(sql1);
		pstmt.setString(1,anaesthetist1_code);
		resultset=pstmt.executeQuery();
		while(resultset.next()){
			short_name = CommonBean.checkForNull(resultset.getString("SHORT_NAME"));			
		}
	}*/ 	

%>
<table border='0' cellpadding=3  cellspacing='' align='center'  width='100%' >
<tr>
	<td class='label' width="25%">
		<fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/> 
	</td>
    <td class="fields" width="25%" colspan="3">
		<input type='hidden' name='Anaesthetiest1_code' id='Anaesthetiest1_code' value="<%=anaesthetist1_code%>"> 
		<input name='Anaesthetiest2_code' id='Anaesthetiest2_code' size='15' value="<%=short_name%>" onchange="if(this.value!='')searchAssignAnaesthetist(Anaesthetiest2_code); else Anaesthetiest1_code.value='' "> 
		<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="searchAssignAnaesthetist(Anaesthetiest2_code);" >
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	</tr>
<tr>
	<td class='label' width="25%"> </td>
	<td class="button" width="25%" colspan="3">
		<input type="button" class="button" name="OK" id="OK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="saveAnaesthetist();">
		<input type="button" class="button" name="Cancel" id="Cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="parent.parent.document.getElementById('dialog_tag').close();">
	</td>
</tr>
</table>
<%	
}catch(Exception e){
	System.err.println("208: Exception in Assi"+e);
}finally{
	if(resultset!=null) resultset.close();
	if(pstmt!=null) pstmt.close();		
	ConnectionManager.returnConnection(connection,request);
}
%>
	<input type='hidden' name='facility_id_1' id='facility_id_1' value="<%=facility_id%>" >	
	<input type='hidden' name='patient_id_1' id='patient_id_1' value="<%=patient_id%>" >
	<input type='hidden' name='booking_no_1' id='booking_no_1' value="<%=booking_no%>" >			
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

