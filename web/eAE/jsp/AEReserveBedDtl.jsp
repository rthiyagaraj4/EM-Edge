<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
		String facility_id	= checkForNull((String)session.getValue("facility_id"));
		String loginUser	= checkForNull((String)session.getValue("login_user"));
%>
<html>
<head>
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
    <script src='../../eCommon/js/dchk.js' language='javascript'></script> 
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eAE/js/AEReserveBed.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
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
	//PreparedStatement   pstmt		= null;
	//ResultSet aerset				= null;

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String locale			= (String)session.getAttribute("LOCALE");
	String clinic_code=checkForNull(request.getParameter("clinic_code"));
	String treatment_area_code=checkForNull(request.getParameter("treatment_area_code"));
	String bedno=checkForNull(request.getParameter("bedno"));
	 String treatment_area_desc=checkForNull(request.getParameter("treatment_area_desc"));
	String oper_stn_id=checkForNull(request.getParameter("OsVal"));
	String sys_date_time=checkForNull(request.getParameter("sys_date"));
	/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	String sql              ="";
	/* CRF  SKR-CRF-0021 [IN028173] end  */
	String  five_level_triage_appl_yn	= (request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
  
	String readonly="";
	String asModal="";
	//String sys_date_time="";

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
<body OnMouseDown='CodeArrest()'  onload='FocusFirstElement()' onKeyDown = 'lockKey()'>
<form name='reserve_bed_form' id='reserve_bed_form'  action='../../servlet/eAE.
ReserveBedServlet' method='post' target='messageFrame' >
<BR><BR>
<table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'>
<tr>
<td class="LABEL"  width="50%" ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
<td class="QUERYDATA" width="50%" >
<select name="clinic" id="clinic"  <%=readonly%> onChange="clearval();">
<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
<%
	
	String code = "";
	String desc = "";

	/* Thursday, May 27, 2010 PE_EXE
	String oper_stn_id="";
	StringBuffer aeSql = new StringBuffer();
    aeSql.append("select oper_stn_id,to_char(SYSDATE,'dd/mm/yyyy hh24:mi') sys_date from am_user_for_oper_stn,DUAL ");
	aeSql.append(" where appl_user_id= ?  and facility_id= ? ");

	pstmt = connection.prepareStatement(aeSql.toString());
	pstmt.setString(1, loginUser);
	pstmt.setString(2, facility_id);
	aerset=pstmt.executeQuery();
	//String aesql="select oper_stn_id from am_user_for_oper_stn where appl_user_id='"+loginUser+"' and facility_id='"+facility_id+"' ";
	aestmt=connection.createStatement();
	aerset=aestmt.executeQuery(aesql);
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
	*/
	
	String sqlAELoc="select clinic_code, long_desc clinic_desc from OP_CLINIC_LANG_VW where language_id='"+locale+"' and eff_status = 'E' AND LEVEL_OF_CARE_IND = 'E' and (facility_id,clinic_code,CLINIC_TYPE) in (select facility_id,locn_code,locn_type from AM_OS_USER_LOCN_ACCESS_VW where facility_id =? and oper_stn_id =? and appl_user_id = ? and RESERVE_BED_BAY_YN='Y') order by 2";

	pStatement	= connection.prepareStatement(sqlAELoc);

	pStatement.setString(1, facility_id);
	pStatement.setString(2, oper_stn_id);
    pStatement.setString(3, loginUser);

	resultSet	= pStatement.executeQuery();
	if (resultSet != null)
	{
		while(resultSet.next())
		{
			code	= checkForNull(resultSet.getString("clinic_code"));
			desc	= checkForNull(resultSet.getString("clinic_desc"));
			if(clinic_code.equals(code)){%>
				<option value = "<%=code%>" selected> <%=desc%></option>
			<%}else{%>
				<option value = "<%=code%>" > <%=desc%></option>
			<%}
		}
	}
%> 
<select><img align='center' id="clinicid" src='../../eCommon/images/mandatory.gif' ></img>
</td>
</tr>
<input type="Hidden" name="sys_date_time" id="sys_date_time" value = "<%=sys_date_time%>">

<tr>
	<td class='LABEL' ><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	
	        <select name='priority_value' id='priority_value'onChange="callTreatment();" >
			<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option> 
			<!-- below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] -->
			<%
			
			
	        	sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E' ";
				if(!five_level_triage_appl_yn.equals("Y")){
	 				sql	= sql + "  and priority_zone not in ('B','W') ";
				}
	 			sql= sql + " order by PRIORITY_ZONE_ORDER asc"; 
			    pStatement   = connection.prepareStatement(sql.toString());
				pStatement.setString(1,locale) ;
			    resultSet    = pStatement.executeQuery();
				while(resultSet!=null && resultSet.next())
				{
			     
			   out.println("<option value='"+resultSet.getString(1)+"'>");	     
			   out.println(resultSet.getString(2));
			   out.println("</option>"); 
				}
			
			%>
			
			<!--CRF  SKR-CRF-0021 [IN028173] end-->
		   </select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
		
	</td>
</tr>

<tr>
<td class="LABEL"  width="50%" ><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
<td class="QUERYDATA" width="50%" >
<select name="treatment_area" id="treatment_area"  <%=readonly%> onchange='clearBed(this);'>
<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>	
<%if(! treatment_area_code.equals("")){%>
	<option value="<%=treatment_area_code%>" selected><%=treatment_area_desc%></option>
<%}%>
</select><img align='center' id="treatment" src='../../eCommon/images/mandatory.gif' ></img>
</td>
</tr>

<tr>
<td class="LABEL"  width="50%" ><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/></td>
<td class="QUERYDATA" width="50%" >
<% 
	if(bedno.equals("")){%>
	<input type='text'  name='bed_no' id='bed_no' size='8' maxlength='8'  readonly onKeyPress='return CheckForSpecChars(event)' onblur='ChangeUpperCase(this);checkForValidBed(this.value);'><input type='button'  name='search_bed' id='search_bed' value='?' onclick='searchBed()' class='button'><img align='center' src='../../eCommon/images/mandatory.gif'></img>
<%}else{%>
	<input type='text'  name='bed_no' id='bed_no' size='8' maxlength='8'  value='<%=bedno%>' onKeyPress='return CheckForSpecChars(event)' onblur='ChangeUpperCase(this);checkForValidBed(this.value);' disabled ><input type='button'  name='search_bed' id='search_bed' value='?' onclick='searchBed()' class='button' disabled><img align='center' src='../../eCommon/images/mandatory.gif'></img>
<%}%>
</td>
</tr>
<tr>
<td class="LABEL"  width="50%" ><fmt:message key="eAE.ReserveUntil.label" bundle="${ae_labels}"/></td>
<td class="QUERYDATA" width="50%" >
<%if(clinic_code.equals("")){%>
	<input type='text' id='reserveUntil' name='reserve_until' id='reserve_until' size='14' maxlength='16' value='' onKeyPress='return(CheckNumberInput(this,event,2));' onblur="dateVal(sys_date_time,this);" ><img src="../../eCommon/images/CommonCalendar.gif" id="resCaln" onClick="document.forms[0].reserve_until.select();return showCalendar('reserveUntil', null, 'hh:mm' );"  style='cursor:pointer'></img>&nbsp;<img align='center' id="resDate" src='../../eCommon/images/mandatory.gif'  " ></img>
<%}else{%>
	<input type='text' id='reserveUntil' name='reserve_until' id='reserve_until' size='14' maxlength='16' value='' onKeyPress='return(CheckNumberInput(this,event,2));' onblur="dateVal(sys_date_time,this);" ><img src="../../eCommon/images/CommonCalendar.gif" id="resCaln" onClick="document.forms[0].reserve_until.select();return showCalendar('reserveUntil', null, 'hh:mm' );" style='cursor:pointer'></img>&nbsp;<img align='center' id="resDate" src='../../eCommon/images/mandatory.gif'  ></img>
<%}%>
</td>
</tr>

<tr><td colspan="2">&nbsp;</td></tr>
<tr>
<td class="LABEL"  width="50%" ><fmt:message key="eAE.Reasons.label" bundle="${ae_labels}"/></td>
<td class="QUERYDATA" width="50%" >
<%if(clinic_code.equals("")){%>

	<textarea  name='reasons' rows="2" cols="30" wrap onKeyPress="checkMaxLimit(this,30);" onBlur="checkForMaxLimit(this,30);" ></textarea><img align='center' id="reason" src='../../eCommon/images/mandatory.gif' style="visibility:'visible'" ></img>
<%}else{%>
	<textarea  name='reasons' rows="2" cols="30" wrap onKeyPress="checkMaxLimit(this,30);" onBlur="checkForMaxLimit(this,30);" ></textarea><img align='center' id="reason" src='../../eCommon/images/mandatory.gif' ></img>
<%}%>
</td>
</tr>
</table>
<input type="Hidden" name="facility_id" id="facility_id" value = "<%=facility_id%>">
<input type="Hidden" name="asModal" id="asModal" value = "<%=asModal%>">
<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
</form>
</body>
</html>
<%		if (resultSet != null) resultSet.close();
		if (pStatement != null) pStatement.close();
	   
	}catch(Exception e) {e.printStackTrace();}
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

