<!DOCTYPE html>
<!--Created by P.Anuradha on Dec-27-2004-->
<%-- JSP Page specific attributes start --%>

<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, com.ehis.eslp.* ,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- jsp:useBean id="mh" scope="session" class="CommonMultipleHandler" --%>
<%-- To call the Common MultipleHandler where the id will be as mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
  <head>
	<%
	//This file is saved on 18/10/2005.
	String locale=(String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/Dependency.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  </head>
<%
Connection conn=null;

PreparedStatement reassessment_pstmt=null;
ResultSet reassessmentrset=null;

PreparedStatement dependency_pstmt=null;
ResultSet dependency_rset=null;

try
{
String mode=request.getParameter("mode") ;
String function_id = request.getParameter("function_id" ) ;


String reassessmentintervalunit_sql="";
String reassessmentintervalunit_type="";
String reassessmentintervalunit_desc="";

String checkstatus="";
String fieldstatus="";
String editstatus="";


conn=ConnectionManager.getConnection(request);	

reassessmentintervalunit_sql="select durn_type, durn_desc from am_duration_type_lang_vw where language_id='"+locale+"' order by durn_desc";

reassessment_pstmt=conn.prepareStatement(reassessmentintervalunit_sql);
reassessmentrset=reassessment_pstmt.executeQuery();
%>
<body onMouseDown="CodeArrest()" onload='FocusFirstElement()' onKeyDown="lockKey()">
<form name="DependencyAddModify_Form" id="DependencyAddModify_Form" method="post" action='../../servlet/eCP.DependencyServlet' target="messageFrame">
<br><br><br><br>
<%if(mode.equals("1"))
{
%>
<table cellpadding=0 cellspacing=0 width="75%" align="center">
<tr>
<td colspan="5">&nbsp;</td>
</tr>
<tr>
<td >&nbsp;</td>
<td align="right" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td align="left" >&nbsp;
<input type="text" name="Dependency_code" id="Dependency_code" value="" size="4" maxlength="4" onBlur="ChangeUpperCase( this );" onKeyPress="return CheckForSpecChars(event);" >&nbsp;
<img src="../../eCommon/images/mandatory.gif"></img>
</td>
<td class="label" colspan='2'>&nbsp;</td>
</tr>
<tr>
<td colspan="6">&nbsp;</td>
</tr>
<tr>
<td >&nbsp;</td>
<td align="right" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
<td align="left" >&nbsp;
<input type="text" name="Dependency_Longdesc" id="Dependency_Longdesc" value=""  size="30" maxLength="30" onBlur="makeValidString( this );">
<img src="../../eCommon/images/mandatory.gif"></img>
</td>
<td class="label" colspan='2'>&nbsp;</td>
</tr>
<tr>
<td colspan="6">&nbsp;</td>
</tr>
<tr>
<td class="label" >&nbsp;</td>
<td align="right" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
<td align="left" >&nbsp;
<input type="text" name="Dependency_Shortdesc" id="Dependency_Shortdesc" value=""  size="15" maxLength="15" onBlur="makeValidString( this );">&nbsp;
<img src="../../eCommon/images/mandatory.gif"></img>
</td>
<td class="label" colspan='2'>&nbsp;</td>
</tr>
<tr>
<td colspan="6">&nbsp;</td>
</tr>
<tr>
<td class="label" >&nbsp;</td>
<td class="label" align="right"><fmt:message key="Common.Level.label" bundle="${common_labels}"/></td>
<td align="left" class="label" colspan="3">&nbsp;
<select name="Dependency_Level" id="Dependency_Level">
<option value="">-<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-</option>
<%
for(int k=1;k<=9;k++)
{
%>
<option value="<%=k%>"><%=k%></option>
<%
}
%>
</select>&nbsp;
<img src="../../eCommon/images/mandatory.gif"></img>
</td>
</tr>
<tr>
<td colspan="6">&nbsp;</td>
</tr>
<tr>
<td class="label">&nbsp;</td>
<td class="label" align="right"><fmt:message key="eCP.ReassessmentInterval.label" bundle="${cp_labels}"/></td>
<td align="left" class="label" colspan="3">&nbsp;
<input type="text" name="Reassessment_Interval" id="Reassessment_Interval" value="" size="3" maxlength="3" onBlur="CheckNum(this);" onKeyPress="return allowValidNumber(this,event,3,0);">
<select name="Reassessment_Unit" id="Reassessment_Unit">
<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
try
{
if(reassessmentrset!=null)
	{
	while(reassessmentrset.next())
	{
	  reassessmentintervalunit_type=reassessmentrset.getString("durn_type");
	  reassessmentintervalunit_desc=reassessmentrset.getString("durn_desc");
%>
<option value="<%=reassessmentintervalunit_type%>"><%=reassessmentintervalunit_desc%></option>
<%}}}catch(Exception exp){exp.toString();}%>
</select>&nbsp;
<img src="../../eCommon/images/mandatory.gif"></img>
</td>
</tr>
<tr>
<td colspan="6">&nbsp;</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td class="label"  align='right'><fmt:message key="eCP.Guideline.label" bundle="${cp_labels}"/></td>
	<td align='left'>&nbsp;&nbsp;<textarea name="guideline" cols=40 rows=5 onKeyPress="checkMaxLimit(this,4000);" onblur="checkForMax(this);"></textarea></td>
	<td colspan='2'>&nbsp;</td>
</tr>
<tr>
<td colspan="6">&nbsp;</td>
</tr>
<tr>
<td class="label" >&nbsp;</td>
<td class="label"  align='right'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
<td align='left'>&nbsp;<input type='checkbox' name='eff_status_yn' id='eff_status_yn' checked>
</td>
<td class="label" colspan='2'>&nbsp;</td>
</tr>
</table>
<%
}
else if(mode.equals("2"))
{

	String dependency_code="";
	String short_desc  = "";
	String long_desc = "";
	String dependency_level="";
    String reassessment="";
    String reassessment_unit="";
    String dep_level_display="";
    String display="";
	String eff_status = "";
	String dependency_sql = "";
	String guideline="";

dependency_code=request.getParameter("dependency_code")==null?"":request.getParameter("dependency_code");

dependency_sql="select * from cp_dependency where dependency_code=?";
dependency_pstmt=conn.prepareStatement(dependency_sql);
dependency_pstmt.setString(1,dependency_code);

dependency_rset=dependency_pstmt.executeQuery();

if(dependency_rset!=null)
	{
	while(dependency_rset.next())
		{
		   long_desc = dependency_rset.getString("long_desc")==null ? "":dependency_rset.getString("long_desc");
	       short_desc  = dependency_rset.getString("short_desc")==null ? "":dependency_rset.getString("short_desc");
	       dependency_level = dependency_rset.getString("dependency_level")==null? "":dependency_rset.getString("dependency_level");
	       reassessment = dependency_rset.getString("reassessment_interval")==null? "":dependency_rset.getString("reassessment_interval");
	       reassessment_unit = dependency_rset.getString("reassessment_interval_unit")==null? "":dependency_rset.getString("reassessment_interval_unit");
		   guideline = dependency_rset.getString("guideline")==null ? "D":dependency_rset.getString("guideline");
	       eff_status = dependency_rset.getString("eff_status")==null ? "D":dependency_rset.getString("eff_status");
		}
	}
if(eff_status.equals("E"))
{
	checkstatus="checked";
	fieldstatus="";
	editstatus="";
}
else
{
	checkstatus="";
	fieldstatus="disabled";
	editstatus="readonly";
}
%>
<table cellpadding=0 cellspacing=0 width="75%" align="center">
<tr>
<td colspan="5">&nbsp;</td>
</tr>
<tr>
<td class="label" >&nbsp;</td>
<td align="right" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td align="left" >&nbsp;
<input type="text" name="Dependency_code" id="Dependency_code" value="<%=dependency_code%>" size="4" maxlength="4" onBlur="ChangeUpperCase( this );" onKeyPress="return CheckForSpecChars(event);" readonly>&nbsp;
<img src="../../eCommon/images/mandatory.gif"></img>
</td>
<td class="label" colspan='2'>&nbsp;</td>
</tr>
<tr>
<td colspan="6">&nbsp;</td>
</tr>
<tr>
<td class="label" >&nbsp;</td>
<td align="right" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
<td align="left" >&nbsp;
<input type="text" name="Dependency_Longdesc" id="Dependency_Longdesc" value="<%=long_desc%>"  size="30" maxLength="30" onBlur="makeValidString( this );" <%=editstatus%>>
<img src="../../eCommon/images/mandatory.gif"></img>
</td>
<td class="label" colspan='2'>&nbsp;</td>
</tr>
<tr>
<td colspan="6">&nbsp;</td>
</tr>
<tr>
<td class="label" >&nbsp;</td>
<td align="right" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
<td align="left" >&nbsp;
<input type="text" name="Dependency_Shortdesc" id="Dependency_Shortdesc" value="<%=short_desc%>"  size="15" maxLength="15" onBlur="makeValidString( this );" <%=editstatus%>>&nbsp;
<img src="../../eCommon/images/mandatory.gif"></img>
</td>
<td class="label" colspan='2'>&nbsp;</td>
</tr>
<tr>
<td colspan="6">&nbsp;</td>
</tr>
<tr>
<td class="label" >&nbsp;</td>
<td class="label" align="right"><fmt:message key="Common.Level.label" bundle="${common_labels}"/></td>
<td align="left" class="label" colspan="3">&nbsp;
<select name="Dependency_Level" id="Dependency_Level" onChange="DependencyLevel(this);" <%=fieldstatus%>>
<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<%
int k=0;
for(k=1;k<=9;k++)
{
	int dep_level=Integer.parseInt(dependency_level);
	
	if(dep_level==k)
         dep_level_display="selected";
	else
		  dep_level_display="";
%>
<option value="<%=k%>" <%=dep_level_display%>><%=k%></option>
<%
}
%>
</select>
<img src="../../eCommon/images/mandatory.gif"></img>
</td>
</tr>
<tr>
<td colspan="6">&nbsp;</td>
</tr>
<tr>
<td class="label">&nbsp;</td>
<td class="label" align="right"><fmt:message key="eCP.ReassessmentInterval.label" bundle="${cp_labels}"/></td>
<td align="left" class="label" colspan="3">&nbsp;
<input type="text" name="Reassessment_Interval" id="Reassessment_Interval" value="<%=reassessment%>" size="3" maxlength="3" onBlur="CheckNum(this);" onKeyPress="return allowValidNumber(this,event,3,0);" <%=editstatus%>>
<select name="Reassessment_Unit" id="Reassessment_Unit" <%=fieldstatus%> onChange="ReassessmentUnit();">
<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
try
{
if(reassessmentrset!=null)
	{
	while(reassessmentrset.next())
	{
	  reassessmentintervalunit_type=reassessmentrset.getString("durn_type");
	  reassessmentintervalunit_desc=reassessmentrset.getString("durn_desc");

      
	  if(reassessment_unit.equals(reassessmentintervalunit_type))
      	  display="selected";
	  else
		  display="";

%>
<option value="<%=reassessmentintervalunit_type%>" <%=display%>><%=reassessmentintervalunit_desc%></option>
<%}}}catch(Exception exp){exp.toString();}%>
</select>&nbsp;
<img src="../../eCommon/images/mandatory.gif"></img>
</td>
</tr>
<tr>
<td colspan="6">&nbsp;</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td class="label"  align='right'><fmt:message key="eCP.Guideline.label" bundle="${cp_labels}"/></td>
	<td align='left'>&nbsp;&nbsp;<textarea name="guideline" cols=40 rows=5 onKeyPress="checkMaxLimit(this,4000);" onblur="checkForMax(this);" <%=editstatus%>><%=guideline%></textarea></td>
	<td colspan='2'>&nbsp;</td>
</tr>
<tr>
<td colspan="6">&nbsp;</td>
</tr>
<tr>
<td class="label" >&nbsp;</td>
<td class="label"  align='right'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
<td align='left'>&nbsp;<input type='checkbox' name='eff_status_yn' id='eff_status_yn' value="<%=eff_status%>" <%=checkstatus%>>
</td>
<td class="label" colspan='2'>&nbsp;</td>
</tr>
</table>
<input type="hidden" name="Dependency_Level1" id="Dependency_Level1" value="<%=dependency_level%>">
<input type="hidden" name="Reassessment_Unit1" id="Reassessment_Unit1" value="<%=reassessment_unit%>">
<%}%>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
</form>
</body>
<%
}
catch(Exception exp)
{
	out.println(exp.toString());
}
finally
{
	  if (dependency_rset != null) dependency_rset.close();
	   if (reassessmentrset != null) reassessmentrset.close();
      if (reassessment_pstmt != null) reassessment_pstmt.close();
	  if (dependency_pstmt != null) dependency_pstmt.close();
	  
	  if(conn != null)
		ConnectionManager.returnConnection(conn,request);
}
%>
</html>

