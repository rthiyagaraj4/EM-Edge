<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");	
Connection con=null;
StringBuffer sql = new StringBuffer();
String hist_rec_type	=	"";
//String read_only = "";
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
<script language='javascript' src='../js/CAMessages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<form name='ClinicalRepMastRelink_form' id='ClinicalRepMastRelink_form'  method='post' target='messageFrame' >
<body  class='CONTENT' OnMouseDown="CodeArrest()"  onKeyDown="lockKey()"  >

<table border=0 cellspacing=0 cellpadding=0 width='100%' align=center>

<tr>
	<td class=label align=right>History Type </td>
	<td align=left>&nbsp;
	<select name='hist_rec_type' id='hist_rec_type' onChange='contrsystempop3()' >
		<option value="">---------------Select--------------</option>	
	<%
	    sql = new StringBuffer();	
		sql.append("select HIST_REC_TYPE,LONG_DESC from  cr_hist_rec_type order by 1 ");

		stmt = con.prepareStatement(sql.toString());
		rs = stmt.executeQuery();

		while(rs.next())
		{
			hist_rec_type = rs.getString("HIST_REC_TYPE");
			String long_desc = rs.getString("LONG_DESC");
		
			%>
			<option value='<%=hist_rec_type%>'><%=long_desc%></option>
		<%}
			
			//added new
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();

	%>
	</select>
	<img src='../../eCommon/images/mandatory.gif'>
	</td>

	<td class=label align='right' >Contr System</td>
		
	<td align=left>&nbsp;&nbsp;<select name='contr_system' id='contr_system' >
	<option value="">-------Select-----</option>
	</select>
	<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>

	<td  class=label align=right>Event Code</td>
	<td>&nbsp;
	<input type="text" name="event_code" id="event_code" size="10" maxlength="20" value="" onblur='callforPrompt(this)'><input type="button" value="?" class="button" onClick="callEvent1()" name='search' id='search'  >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center' name='mand2'></img>
	</td>

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
	out.println("From ClinicalRepMastMainEvent.jsp" + e.toString());
	e.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

%>

