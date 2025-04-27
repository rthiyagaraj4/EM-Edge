<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8"); 
    Statement stmt=null;
    ResultSet rset=null ;
    Connection con = null;

    String p_module_id      = "OP" ;
    String p_report_id      = "OPBMTRFC" ;
    String p_facility_id        = (String) session.getValue( "facility_id" ) ;
    String p_user_name      = (String) session.getValue( "login_user" ) ;
    String ID="";
    String dat="";
    String en="";	
	String hcare_id="";
	String hcare_name="";
    try{
		con = ConnectionManager.getConnection(request);
%>
<html>
<HEAD>
<TITLE></TITLE>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<!-- <script src="../../eOP/js/repResetRunList_SRR.js"></script> -->
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<SCRIPT>
function chmonth(obj)
{
    if(obj.value != "")
	{
		if(validDate(obj.value,'MM',localeName)==false)
		{
			var msg=getMessage("INVALID_MONTH_FMT","SM");
			alert(msg);
			obj.select();
            obj.clear();
			return false;
		}	
		else 
			return true;			
	}
}

function validateYear(obj)
{
		if(obj.value!="")
		{
			if(validDate(obj.value,'YY',localeName)==false)
				{
				alert(getMessage("INVALID_YEAR_FMT", "SM"));
				obj.select();
                obj.clear();	
				return false;
			}
			else
				return true;
		}
}

function validateMthYr(obj)
{
		if(obj.value!="")
		{
			if(validDate(obj.value,'MY',localeName)==false)
				{
				alert(getMessage("MONTH_YEAR_INVALID", "SM"));
				obj.select();	
				return false;
			}
			else
				return true;
		}
}

function setDate(Object)
{ 

	var currentDate = new Date();
       if(Object.value!="")
	  {
		   if (isBeforeNow(Object.value,"MY",localeName))
		  {
			  return true;
		  }
		  else
		  {
			  alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
			  Object.value="";
			  Object.focus();            
		   }
       }
}
</SCRIPT>

</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<br>
<br>
<form name="repOPRefStatMonwiseform" id="repOPRefStatMonwiseform" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top' cellpadding='0' border='0' >
	<tr>
    <td class='columnheader'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
    </tr> 
</table>
	<table width='80%' align='center' cellpadding='2' cellspacing='0' border='0'>

               <tr>
				   <td class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
                    <td class='fields' colspan='2'><select name='p_for_facility_id' id='p_for_facility_id' >
                    <%
                    stmt=con.createStatement();
                    //rset=stmt.executeQuery("SELECT FACILITY_NAME,FACILITY_ID from sm_facility_for_user_vw WHERE APPL_USER_ID='"+p_user_name+"'  order by FACILITY_NAME ");
					 rset=stmt.executeQuery("SELECT facility_id,sm_get_desc.SM_FACILITY_PARAM(facility_id,'"+localeName+"',1) facility_name FROM SM_FACILITY_FOR_USER WHERE appl_user_id='"+p_user_name+"' ORDER BY facility_name");

                    if(rset!=null)
                    {
                    while(rset.next())
                    {
                    dat=rset.getString("FACILITY_NAME");
                    ID=rset.getString("FACILITY_ID");

                    out.println("<option value='"+ID+ "' "+en+">"+dat+"</option>");
                    }%>
                    </select>
                    <%  }
					if(stmt != null) stmt.close();
					if(rset != null) rset.close();
                    %>
                    </td>
                </tr>
				<tr>
					<td width='33%'>&nbsp;</td>
					<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td align="left" class="label"><fmt:message key="Common.HealthcareSettingType.label" bundle="${common_labels}"/></td>
					<td class='fields'>
						<select name='P_HCARE_FM' id='P_HCARE_FM'>
							<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
							<%	
								stmt=con.createStatement();
								rset = stmt.executeQuery("SELECT hcare_setting_type_code,short_desc FROM AM_HCARE_SETTING_TYPE_LANG_VW WHERE eff_status='E' and  language_id='"+localeName+"' ORDER BY 2");	
							
						 if(rset!=null)
						{
							while(rset.next())
							{
								hcare_id=rset.getString("hcare_setting_type_code");
  							    hcare_name=rset.getString("short_desc");
								out.println("<option value='"+hcare_id+"'>"+hcare_name+"</option>");
							}
						}						
					%>
					</select>
					<%
						if(stmt != null) stmt.close();
					    if(rset != null) rset.close();
					%>					
					</td>
					
					<td class='fields'>
						<select name='P_HCARE_TO' id='P_HCARE_TO'>
							<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
							<%	
								stmt=con.createStatement();
								rset = stmt.executeQuery("SELECT hcare_setting_type_code,short_desc FROM AM_HCARE_SETTING_TYPE_LANG_VW WHERE eff_status='E' and  language_id='"+localeName+"' ORDER BY 2");	
							
						 if(rset!=null)
						{
							while(rset.next())
							{
								hcare_id=rset.getString("hcare_setting_type_code");
								hcare_name=rset.getString("short_desc");
								out.println("<option value='"+hcare_id+"'>"+hcare_name+"</option>");
							}
						}

					%>
					</select></td>
					</tr>     
                <tr>
                    <td class="label">
                        <fmt:message key="Common.month.label" bundle="${common_labels}"/>/<fmt:message key="Common.year.label" bundle="${common_labels}"/>
                    </td>
                     <td class='fields'>
						 <!-- <input type="text" name="p_fm_mon" id="p_fm_mon" size="2" maxlength="2" onBlur="chmonth(this)" onKeyPress='return(ChkNumberInput(this,event,0))'>
							/ <input type="text" name="p_fm_year" id="p_fm_year" size="4" maxlength="4" onBlur="validateYear(this);" onKeyPress='return(ChkNumberInput(this,event,0))'><img src='../../eCommon/images/mandatory.gif'></img>
						</td>  -->       
						<input type="text" id='mdsfrom' name="p_fm_mon_yr" id="p_fm_mon_yr" size="7" maxlength="7" onBlur='if(validateMthYr(this)){setDate(this)}'><img  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsfrom','mm/y', null);" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img> 
					</td>


                    <td class='fields'>
						<!-- <input type="text" name="p_to_mon" id="p_to_mon" size="2" maxlength="2" onBlur="chmonth(this)" onKeyPress='return(ChkNumberInput(this,event,0))'>
                        / <input type="text" name="p_to_year" id="p_to_year" size="4" maxlength="4" onBlur="validateYear(this);" onKeyPress='return (ChkNumberInput(this,event,0))'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img> -->
						<input type="text" id='mdsto'  name="p_to_mon_yr" id="p_to_mon_yr" size="7" maxlength="7" onBlur='if(validateMthYr(this)){setDate(this)}'><img  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsto','mm/y', null);" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img>
                    </td>
                </tr>                
            </table>
<input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
<input type="hidden" name="p_fr_month" id="p_fr_month"          value="">
<input type="hidden" name="p_to_month" id="p_to_month"          value="">
<input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">

		<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

</form>
    <%}
catch(Exception e) {out.println(e.toString());}
finally{
if(stmt != null) stmt.close();
if(rset != null) rset.close();
if(con!=null)
    ConnectionManager.returnConnection(con,request);
}%>
</BODY>
</HTML>

