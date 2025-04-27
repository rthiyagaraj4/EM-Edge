<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<HTML>
<HEAD>
	<%
     Connection connection=null;
	 String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");


try
	{
		String code="";
        String desc="";
		connection= ConnectionManager.getConnection(request);
		String locale=(String)session.getAttribute("LOCALE"); 
			String	 facilityId 			= (String) session.getValue( "facility_id" ) ;
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
    <script src='../../eCommon/js/dchk.js' language='javascript'></script> 
	
	<script language='javascript' src='../../eMO/js/MOReleaseBedQueryCriteria.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  onKeyDown = 'lockKey()'> 
<form name="AreaAvailForm" id="AreaAvailForm" target="messageFrame">
	<table cellpadding='0' cellspacing='0' border='0' width='100%' >
				
   	<tr>
	<td class='LABEL' align='left'><fmt:message key="Common.area.label" bundle="${common_labels}"/>&nbsp;</td>
	<td ><select name='area_code' id='area_code' onChange="enableData();">
    <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </option>
<%	
    String sqlMOLoc=" select area_code,LONG_DESC from mo_area_lang_vw where LANGUAGE_ID='"+locale+"' and facility_id = '"+facilityId+"' AND eff_status='E' order by 2";
	PreparedStatement pStatement	= connection.prepareStatement(sqlMOLoc);
	ResultSet resultSet	= pStatement.executeQuery();
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
	if(resultSet!=null)resultSet.close();
	if(pStatement!=null)pStatement.close();
	%>
		</select></td>	
	<td class=label align=left><fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;</td>	
	<td>	<input type='text'  name='bed_no' id='bed_no' size='8' maxlength='8'  value='' onKeyPress='return CheckForSpecChars(event)' onblur='ChangeUpperCase(this);' disabled><input type='button'  name='search_bed' id='search_bed' value='?' disabled onclick='searchBed()' class='button' > </td>
	</tr>
	    <tr> <td colspan=4>&nbsp;</td></tr>
	<tr>
    <td class="LABEL" align="left"  ><fmt:message key="Common.blockeduntil.label" bundle="${common_labels}"/>&nbsp;</td>
    <td class="QUERYDATA" >
    <input type='text'  name='blocked_until' id='blocked_until' size='10' maxlength='10' value=''  onblur="CheckDate(this);" ><img src="../../eCommon/images/CommonCalendar.gif" id="resCaln" onClick="document.forms[0].blocked_until.select();return showCalendar('blocked_until', null, null );"  style="cursor='hand'">&nbsp;
   </td>
   <td colspan=2 align=right>
		<input type='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='submitPage();'>
		<input type='button' name='clear' id='clear'  value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'  class='button' onclick='clearAll()'>
		</td>
   </tr>
	 

	<%}catch(Exception e)
	{
	e.printStackTrace();
	} finally
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
</table>
</form>
</BODY>
</HTML>

