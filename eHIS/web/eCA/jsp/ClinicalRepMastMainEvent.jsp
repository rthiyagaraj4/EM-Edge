<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");	
Connection con=null;
StringBuffer sql = new StringBuffer();
String hist_rec_type	=	"";
try
{
	PreparedStatement stmt=null;
	ResultSet rs=null;
	con=ConnectionManager.getConnection(request);
%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
 <script src='../../eCA/js/ClinicalRepMast.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<form name='ClinicalRepMastMainEvent_form' id='ClinicalRepMastMainEvent_form'  method='post' target='messageFrame'>
<body  class='CONTENT' OnMouseDown="CodeArrest()"  onKeyDown="lockKey()" >

<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>

<tr>
	<td class='label'>History Type </td>
	<td >	
	<select name='hist_rec_type' id='hist_rec_type' onchange='callLevelFour()' >
		<option value="">------------------Select------------------</option>	
	<%
	    sql = new StringBuffer();	
		sql.append("select HIST_REC_TYPE,LONG_DESC from  cr_hist_rec_type where hist_rec_type not in ('MHD') order by 1 ");//Added not in MHD for ML-MMOH-CRF-1759

		stmt = con.prepareStatement(sql.toString());
		rs = stmt.executeQuery();

		while(rs.next())
		{
			hist_rec_type = rs.getString("HIST_REC_TYPE");
			String long_desc = rs.getString("LONG_DESC");
		
			%>
			<option value='<%=hist_rec_type%>'><%=long_desc%></option>
		<%}
			
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();

	%>
	</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
<td class=label >Source</td> 
<td class='fields' >
<input type='radio' name='add_source' id='add_source' value='U' onClick=callLevelFour()>From Master
<input type='radio' name='add_source' id='add_source' value='A' onClick=callLevelFour()>New <img src='../../eCommon/images/mandatory.gif'> </td>

</tr>

</table>
<input type=hidden name=hist_rec_type1 id=hist_rec_type1 value="<%=hist_rec_type%>">
<input type=hidden name=add_source1 id=add_source1 value="">
<input type='hidden' name='mode' id='mode' value='insert'>
</form>

</body>
</html>
<%
	
}
catch(Exception e)
{
	//out.println("From ClinicalRepMastMainEvent.jsp" + e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

%>

