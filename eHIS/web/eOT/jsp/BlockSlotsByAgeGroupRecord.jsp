<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eOT/js/BlockSlotsByAgeGroup.js'></script>
<script language='javascript' src='../../eOT/js/Hashtable.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript">
var RE_NUM = /^\-?\d+$/;
function check(obj){
	if(timeValidity(obj.value)==false)
		obj.focus();
	
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%

	//cannonicalization of empty string
	String empty = "".intern();
	
	//retreiving the locale from session
	String locale = (String)session.getAttribute("LOCALE");	

	//setting the character Encoding before retrieving any request 
	request.setCharacterEncoding("UTF-8");

	//getting request parameter
	String oper_room_code = checkForNull(request.getParameter("oper_room_code"));
//	String wd_start_time=checkForNull(request.getParameter("wd_start_time"));
//	String wd_end_time=checkForNull(request.getParameter("wd_end_time"));
//	String hd_start_time=checkForNull(request.getParameter("hd_start_time"));
//	String hd_end_time=checkForNull(request.getParameter("hd_end_time"));
	String facility_id=(String) session.getAttribute("facility_id");
//	String speciality_code=checkForNull(request.getParameter("speciality_code"));
	String mode=checkForNull(request.getParameter("update_mode_yn")).equals("modify")?"U":"I";
	String disable_flag=( mode.equals("U") )?"disabled":"";
	//Declaration of Variables
	String age_code=empty;
	String age_desc=empty;
	String start_time=empty;
	String end_time=empty;
	String sql=empty;
	String unit_ot_time=empty;
	String arguments = empty;
	String gender = empty;
	final  String SEPERATOR = "@@";
	int index=0;

	//Declaring SQL Strings
	String sqlForUnitTime="SELECT TO_CHAR(unit_ot_time, 'HH24:MI') FROM   ot_param_for_facility WHERE  operating_facility_id = ?"; 
	StringBuffer sbr = new StringBuffer();
	
	sql="SELECT A.AGE_GROUP_CODE,B.SHORT_DESC,TO_CHAR(A.FROM_TIME,'HH24:MI'), TO_CHAR(A.TO_TIME,'HH24:MI'), A.ALERT_TYPE ,NVL(B.GENDER,'N') GENDER FROM OT_OPER_ROOM_PREF A, AM_AGE_GROUP_LANG_VW B WHERE B.LANGUAGE_ID='"+locale+"' AND A.AGE_GROUP_CODE= B.AGE_GROUP_CODE  AND A.OPER_ROOM_CODE =? ORDER BY 2";

	//db releted declarations
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		con=ConnectionManager.getConnection(request);
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,oper_room_code);
		rs=pstmt.executeQuery();
		while(rs.next()){
			index++;
			arguments = sbr.append(rs.getString(1)).append(SEPERATOR).append(rs.getString(2)).append(SEPERATOR).append(rs.getString(3)).append(SEPERATOR).append(rs.getString(4)).append(SEPERATOR).append(rs.getString(5)).append(SEPERATOR).append(index).append(SEPERATOR).append("L").append(rs.getString(6)).toString(); 
			out.println("<script>loadDBRows('"+arguments+"');</script>");
		}
		out.println("<script>refresh()</script>");
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

		//getting unit time 	
		pstmt=con.prepareStatement(sqlForUnitTime);
		pstmt.setString(1,facility_id);
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next()){
			unit_ot_time=rs.getString(1);
		}
	}catch(Exception e){
		System.err.println("Err Msg in BlockSlotsBySpecialityRecord.jsp ::"+e.getMessage());
	}finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) 
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
%>

<form name="BlockSlotsBySpecialityRecordForm" id="BlockSlotsBySpecialityRecordForm"  onload='FocusFirstElement()'> 
<input type='hidden' name='params' id='params' value='<%=request.getQueryString()%>'>
<table border=0 cellspacing=0 cellpadding=3 width='100%'  >
<tr>
	<td class='label'>
		 <fmt:message key="Common.agegroup.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="agegrp_desc" id="agegrp_desc" value="" size=15 maxlength=15 ><input type="hidden" name="agegrp_code" id="agegrp_code" value=""><input type="button" class="button" name="srchagegroup" id="srchagegroup" value="?"  onclick='callAgeGroupcode();' <%=disable_flag%>>
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	
</tr>

<tr>
	<td class='label'>
		<fmt:message key="Common.gender.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
	<!--<input type="text" name="gender" id="gender" value="" size=10 maxlength=10>-->
	<select name="gender" id="gender">
	<option value='M' selected><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
	<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
	
	<!--
	<option value='M'><fmt:message key="eOT.Male.Label" bundle="${ot_labels}"/></option>
	<option value='F'><fmt:message key="eOT.Female.Label" bundle="${ot_labels}"/></option>
	-->
	</select>
	</td>
</tr>


<tr>
	<td class='label'>
		<fmt:message key="Common.StartTime.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="start_time" id="start_time" value=""  size='5' maxlength='5' onblur='check(this);'>
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
	<td class='label'>
		<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="end_time" id="end_time" value=""  size='5' maxlength='5' onblur='TimeCheck(document.forms[0].start_time,this);'>
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
	<td class='label'>
		<fmt:message key="Common.type.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<select name="alert_type" id="alert_type"  >
		<option value='A' selected><fmt:message key="Common.Alert.label" bundle="${common_labels}"/></option>
		<option value='S'><fmt:message key="Common.Stop.label" bundle="${common_labels}"/></option>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td></td>
	<td></td>
</tr>
<tr>

   <td></td>
   
    <td class='label' align='right' nowrap>
		
	<input type='button' class='button' value='Select' onClick='addRow();'   >
		<input type='button' class='button' value='Cancel' onClick='removeRow();'  ></td>

		
</tr>
</table>
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='oper_room_code' id='oper_room_code' value="<%=oper_room_code%>">
<input type='hidden' name='unit_ot_time' id='unit_ot_time' value="<%=unit_ot_time%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


