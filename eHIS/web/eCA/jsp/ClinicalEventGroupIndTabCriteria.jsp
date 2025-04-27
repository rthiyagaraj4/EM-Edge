<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<%
request.setCharacterEncoding("UTF-8");	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/ClinicalEventGroup.js'></script>

</head>
<body onLoad='' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String rectype="";
	String longdesc="";
	String sql="select HIST_REC_TYPE,LONG_DESC from  cr_hist_rec_type where HIST_REC_TYPE in ('CLNT','PTCR','TRET','LBIN','RDIN','SUNT') order by 1";	
	try
	{
			con =	ConnectionManager.getConnection(request);
			
%>

<form name='EventIndTabCriteriaForm' id='EventIndTabCriteriaForm' action='../../servlet/eCA.ClinicalEventGroupServlet' method='post' target='messageFrame'>
<table border='0' cellpadding='3' cellspacing='0'  width='100%' align='left'>
<tr>
   
		<td class=label align='right' width='25%'>&nbsp;&nbsp;History Type</td>
		<td align=left>&nbsp;&nbsp;<select name='histype' id='histype'  onchange='populateCntrSys(this)'>
		<option value="">------------Select-------------</option>
		<%
    
	
	pstmt= con.prepareStatement(sql);
	rs = pstmt.executeQuery();
	while(rs!=null && rs.next())
	{
		rectype=rs.getString("HIST_REC_TYPE");
		longdesc=rs.getString("LONG_DESC");
				
		out.println("<option value='"+rectype+"'>"+longdesc+"</option>");
	}
	
	if(rs!=null)   rs.close(); 
	if(pstmt!=null) pstmt.close();
%>	

</select>
<img src='../../eCommon/images/mandatory.gif' align='center'></img>
</td>
</tr>

<tr>
<td align='right' class='label'>Source</td>
<td>&nbsp;&nbsp;<input type="radio" name="source" id="source" value="M" checked onClick="display()">From Master
<input type="radio" name="source" id="source" value="N" onClick="display()">New
</td>
</tr>

<tr>
   
		<td class=label align='right' width='25%'>&nbsp;&nbsp;Contr System</td>
		<td align=left>&nbsp;&nbsp;<select name='contr' id='contr'  onchange='callAddElement(this)'>
		<option value="">------------Select-------------</option>
        </select>
        <img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
</tr>

<tr id='grp' style='display:block'>
<td align='right' class='label'>Event Group Code</td>
	<td>&nbsp;&nbsp;<input type='text' name="groupcode" id="groupcode" value="" size='20' maxlength='40' onKeyPress="return CheckForSpecChars(event)" onBlur=""><input type="button" value="?" class="button" onClick="callGroupCode()" name='search' id='search'  >
<img src='../../eCommon/images/mandatory.gif' align='center'></img>

</td>
</tr>

<tr id='grp2' style='display:none'>
<td align='right' class='label'>Event Group Code</td>
<td>&nbsp;
<input type='text' name="dollar" id="dollar" value="$" size='1' maxlength='1' readonly><input type='text' name="groupcode2" id="groupcode2" value="" size='20' maxlength='40' onKeyPress="return CheckForSpecChars(event)" onBlur="">
<img src='../../eCommon/images/mandatory.gif' align='center'></img>
</td> 
</tr>

<tr>
	<td  align='right' class='label' >Long Description</td>
	<td  align='left'>&nbsp;&nbsp;<input type='text'  name='long_desc' id='long_desc' value=""   size="40" maxlength="60" onBlur="makeValidString(this)"" ><img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</td>
</tr>

<tr >
	<td  align='right' class='label'>Short Description</td>
	<td  align='left'>&nbsp;&nbsp;<input type='text'  name='short_desc' id='short_desc' value=""   size="20" maxlength="40"  onBlur="makeValidString(this)">
    <img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</td>
</tr>

<% 

}
catch(Exception eg)
{
  // out.println("Exception="+eg.toString());//COMMON-ICN-0181
  eg.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
} 

%>	
</select>
</td>
</tr>
<tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	
</tr>
</table>
<input type='hidden' name='groupcodeval' id='groupcodeval' value=''>
<input type='hidden' name='from' id='from' value='ind'>
</form>
</body>
</html>

