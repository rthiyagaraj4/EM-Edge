<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="BatchBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
BatchBean.clearAll();	
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

<form name='EventBatchTabCriteriaForm' id='EventBatchTabCriteriaForm' action='../../servlet/eCA.ClinicalEventGroupServlet' method='post' target='messageFrame'>
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
<td align='left' class='label'>&nbsp;&nbsp;&nbsp;Data Set</td>
<td align='left' class='label' colspan=3>&nbsp;&nbsp;<input type="radio" name="dataset" id="dataset" value="A"  onClick="dispbatsearch()" checked>All
<input type="radio" name="dataset" id="dataset" value="S" onClick="dispbatsearch()" >Selected
</td>
</tr>
</table>
<input type='hidden' name='from' id='from' value='batch'>
<input type='hidden' name='datasetval' id='datasetval' value=''>
</form>
</body>
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
</html>

