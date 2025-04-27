<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="RelinkBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
RelinkBean.clearAll();	
%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
		<script src='../../eCommon/js/messages.js' language='javascript'></script>
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

<form name='EventRelinkTabCriteriaForm' id='EventRelinkTabCriteriaForm' action='../../servlet/eCA.ClinicalEventGroupServlet' method='post' target='messageFrame'>
<table border='0' cellpadding='0' cellspacing='0'  width='100%' align='left'>

<tr>
   
		<td class=label align='left' width='15%' >&nbsp;&nbsp;History Type</td>
		<td align=left>&nbsp;&nbsp;<select name='histype' id='histype'  onchange='populateBatCntrSys(this)'>
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
<td class=label align='left' width='15%'>&nbsp;&nbsp;Contr System</td>
<td align=left>&nbsp;&nbsp;<select name='contr' id='contr'  onchange=''>
<option value="">------------Select-------------</option>
</select>
<img src='../../eCommon/images/mandatory.gif' align='center'></img>
</td>
</tr>
<tr>
<td align='left' class='label' nowrap>Event Group Code</td>
<td align='left' class='label' colspan=2>&nbsp;&nbsp;<input type='text' name="groupcoder" id="groupcoder" value="" size='20' maxlength='40' onKeyPress="return CheckForSpecChars(event)" onBlur=""><input type="button" value="?" class="button" onClick="callrelinkGroup()" name='search' id='search'  >
<img src='../../eCommon/images/mandatory.gif' align='center'></img>
<input type='hidden' name='groupcode' id='groupcode' value=''>
</td>

<td align="right"><input type="button" align="left" name="Search" id="Search" value="Search" onClick="searchrelinkEventGroup();" class="button" >
<input type="button" align="left" name="clear" id="clear" value="Clear" onClick="clearRelink();" class="button" >
</td>
</tr>
</table>
<input type='hidden' name='from' id='from' value='relink'>

</form>
</body>
<% 

}
catch(Exception eg)
{
   //out.println("Exception="+eg.toString());//COMMON-ICN-0181
   eg.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
} 

%>	
</html>

