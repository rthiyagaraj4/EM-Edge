<!DOCTYPE html>
<!--Added by Metilda on 06/07/04  -->
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
     	request.setCharacterEncoding("UTF-8");

		String facility_id	= checkForNull((String)session.getValue("facility_id"));
		String loginUser	= checkForNull((String)session.getValue("login_user"));

		String locale=(String)session.getAttribute("LOCALE"); 
%>
<html>
<head>
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
    <script src='../../eCommon/js/dchk.js' language='javascript'></script> 
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	 <script src='../../eCommon/js/common.js' language='javascript'></script> 
	 <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	 <script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></Script>
	
	<script language='javascript' src='../../eMO/js/MOBlockBedDtl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
			<style>
textarea {
  resize: none;
}
</style>

</head>
<%
	Connection connection			= null;
	PreparedStatement pStatement	= null;
	ResultSet resultSet				= null;
	PreparedStatement   pstmt		= null;
	ResultSet aerset				= null;
	

	String clinic_code=checkForNull(request.getParameter("clinic_code"));
	String bedno=checkForNull(request.getParameter("bedno"));
	

	String readonly="";
	String asModal="";
	String sys_date_time="";

	if(! clinic_code.equals("")){
		readonly="disabled";
		asModal="Y";
	}else{
		asModal="N";
	}
	try
	{
		connection= ConnectionManager.getConnection(request);
    	
%>
</head>
<body OnMouseDown='CodeArrest()'   onKeyDown = 'lockKey()'>
<form name='rev_bed_form' id='rev_bed_form'  action='../../servlet/eMO.BlockBedServlet' method='post' target='messageFrame' >
<BR><BR><BR><BR><BR>
<table border='0' cellpadding='0' cellspacing='0' width='60%' align='center'>
<tr><td colspan="2">&nbsp;</td></tr>
<tr>

<td class="LABEL" align="LEFT" width="50%" ><fmt:message key="Common.area.label" bundle="${common_labels}"/>&nbsp;</td>
<td class="QUERYDATA" width="50%" >
<select name="area_code" id="area_code"  onChange="enableData();">
<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
<%
	String code = "";
	String desc = "";
	String oper_stn_id="";
	StringBuffer aeSql = new StringBuffer();
    aeSql.append("select oper_stn_id,to_char(SYSDATE,'dd/mm/yyyy hh24:mi') sys_date from am_user_for_oper_stn,DUAL ");
	aeSql.append(" where appl_user_id= ?  and facility_id= ? ");

	pstmt = connection.prepareStatement(aeSql.toString());
	pstmt.setString(1, loginUser);
	pstmt.setString(2, facility_id);
		
	aerset=pstmt.executeQuery();
	/*String aesql="select oper_stn_id from am_user_for_oper_stn where appl_user_id='"+loginUser+"' and facility_id='"+facility_id+"' ";
	aestmt=connection.createStatement();
	aerset=aestmt.executeQuery(aesql);*/
	if(aerset.next())
		{
		oper_stn_id=aerset.getString(1);
        sys_date_time=aerset.getString(2);             
		}
	if(aerset!=null)aerset.close();
	if(pstmt!=null)pstmt.close();
	if((aeSql != null) && (aeSql.length() > 0))
	  {
		aeSql.delete(0,aeSql.length());
	  } 
	
	out.println("locale :"+locale);
	String sqlMOLoc="select area_code,LONG_DESC from mo_area_lang_vw where LANGUAGE_ID='"+locale+"' AND facility_id = '"+facility_id+"' AND eff_status='E' order by 2";

	pStatement	= connection.prepareStatement(sqlMOLoc);
	resultSet	= pStatement.executeQuery();
	if (resultSet != null)
	{
		while(resultSet.next())
		{
			code	= checkForNull(resultSet.getString("area_code"));
			desc	= checkForNull(resultSet.getString("LONG_DESC"));
			%>
			<option value = "<%=code%>" > <%=desc%></option>
			<%
		}
	}
%>
<input type="Hidden" name="system_date" id="system_date" value = "<%=sys_date_time%>">	
</select>
	&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img></td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr>
<td class="LABEL" align="LEFT" width="50%" ><fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;</td>
<td class="QUERYDATA" width="50%" >
	<input type='text'  name='bed_no' id='bed_no' size='8' maxlength='8'  value='<%=bedno%>' onKeyPress='return CheckForSpecChars(event)' onblur='ChangeUpperCase(this);BedCheck();' disabled ><input type='button'  name='search_bed' id='search_bed' value='?' onclick='searchBed();BedCheck();' class='button' disabled>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>
</td>
</tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr>
<td class="LABEL" align="LEFT" width="50%" ><fmt:message key="Common.blockeduntil.label" bundle="${common_labels}"/>&nbsp;</td>
<td class="QUERYDATA" width="50%" >
<input type='text'  name='blocked_until' id='blocked_until' size='14' maxlength='16' value=''  onblur="validate1(this);" ><img src="../../eCommon/images/CommonCalendar.gif" id="resCaln" onClick="document.forms[0].blocked_until.select();return showCalendar('blocked_until',null,'hh:mm');"  style="cursor='hand'">&nbsp;<img align='center' id="resDate" src='../../eCommon/images/mandatory.gif'  " ></img>
</td>
</tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr>
<td class="LABEL" align="LEFT" width="50%" ><fmt:message key="Common.reason.label" bundle="${common_labels}"/>&nbsp;</td>
<td class="QUERYDATA" width="50%" >
<textarea  name='remarks' rows="2" cols="30" wrap onBlur="checkForMaxLimit(this);" ></textarea>&nbsp;<img align='center' id="reason" src='../../eCommon/images/mandatory.gif' style="visibility:'visible'" ></img>&nbsp;&nbsp;

</td>
</tr>

	<tr><td colspan="2">&nbsp;</td></tr>
</table>
<input type="Hidden" name="facility_id" id="facility_id" value = "<%=facility_id%>">
<input type="Hidden" name="asModal" id="asModal" value = "<%=asModal%>">
<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
		<input type='hidden' name='function' id='function' value='blockbed'>
		<input type='hidden' name='patient_id' id='patient_id' value=''>


</form>
</body>
</html>
<%		if (resultSet != null) resultSet.close();
		if (pStatement != null) pStatement.close();
	   
	}catch(Exception e) {out.println(e.toString());
	e.printStackTrace();}
	finally
	{
		ConnectionManager.returnConnection(connection,request);
	}			
%>		
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
%>

