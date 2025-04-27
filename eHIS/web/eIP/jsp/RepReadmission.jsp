<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8"  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPREADIS" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");

%>
<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

 function validate_date(obj) {
	
		if(obj.value!=''){

			if(isBeforeNow(obj.value,"DMY",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
			}
		}
  }

 function allowNumeric(event){
	var strCheck = '0123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;
}

</script>
</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown ="lockKey();">
<br>
<br>
<form name="RepReadmissionForm" id="RepReadmissionForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
    Connection con  =  null;
    Statement stmt = null;
    ResultSet rset = null;
	PreparedStatement pstmt = null;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
	java.sql.Timestamp dt	= new Timestamp(System.currentTimeMillis()) ;
	String Sdate = dateFormat.format(dt) ;
  
%>

<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
               
			  <tr> <br>
			   <td  class="label" width="25%"> <fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			   <td  class="label" width="5%"></td>
			   <td width="25%"> 
							<select name='p_fac_id' id='p_fac_id' >	
                        <option value="">----------------&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---------------							
					<%
	   				try
					{
					String fid;
					String fname;
					con = ConnectionManager.getConnection(request);
					String sql1="select facility_id,facility_name from SM_FACILITY_PARAM_LANG_VW where language_id='"+locale+"' and  STATUS ='E' order by 2";
					pstmt=con.prepareStatement(sql1);
					rset=pstmt.executeQuery();
					if(rset!=null)
					{
					   while(rset.next())
					   {
						fid=rset.getString("facility_id");
						fname=rset.getString("facility_name");
						if(fid.equals(p_facility_id))
						out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
						else
                        out.println("<option value='"+fid+ "' >"+fname+"</option>");
					   }
					}

					}catch(Exception e)
					{
						e.printStackTrace();
					}
				 if (rset != null) rset.close();
	 			 if (pstmt != null) pstmt.close();
				 if( con != null) ConnectionManager.returnConnection(con,request);
	%>
						</select>
						</td>
			   </tr>
		
                    <tr>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
				</tr> 		
                     
			     
				
				<tr>
 				<td align='right' width='25%' class="label"><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/> </td>
				<td class="label" width="5%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				
						<td width='25%'  >
							<input type=text id="dis_date_from"  name='p_fm_discharge_date_disp' id='p_fm_discharge_date_disp' size="10" maxlength="10" align="center" onblur="if(validDateObj(this,'DMY',localeName))validate_date(this)"><img align="center"  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dis_date_from');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
						
						<td class="label" width="5%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
						<td width='25%'> 
							<input type=text id="dis_date_to"  name='p_to_discharge_date_disp' id='p_to_discharge_date_disp' size="10" maxlength="10" onblur="if(validDateObj(this,'DMY',localeName))validate_date(this)"><img align="center"  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dis_date_to');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
				<td class="label" width="25%"><fmt:message key="eIP.Readmissionwithin.label" bundle="${ip_labels}"/></td>
				<td  class="label" width="5%"></td>
				<td  width='25%'> <input type=text name='p_daysofdischarge' id='p_daysofdischarge' size="5" maxlength="2" onkeypress ='return allowNumeric(event)' onpaste="return false" />
				<font style="COLOR:#444444;background-color:#FFFFFF;FONT-SIZE: 8pt;TEXT-ALIGN: LEFT;PADDING-LEFT:7px;PADDING-RIGHT:7px;"><fmt:message key="eIP.Daysofdischarge.label" bundle="${ip_labels}"/></font><img src='../../eCommon/images/mandatory.gif'></img></td>


	</td>
</tr>
</table>
	<%if(localeName.equals("en"))
	{%>
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
	
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%=p_module_id%>">
	<input type="hidden" name="p_fm_discharge_date" id="p_fm_discharge_date" 		value="">
	<input type="hidden" name="p_to_discharge_date" id="p_to_discharge_date" 		value="">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%=p_report_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=p_user_name%>">
	<input type='hidden' name ='currdate' value="<%=Sdate%>">
	<input type='hidden' name ='p_language_id' value="<%=locale%>">
</form>
</BODY>
</HTML>


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

