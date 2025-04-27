<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eOT/js/AnaesthSetUpParamFlty.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form name="AnaesthSetUpParamFltyForm" id="AnaesthSetUpParamFltyForm"  onload='FocusFirstElement()'  action="../../servlet/eOT.AneasthSetUpParamFltyServlet" method="post" target="messageFrame"> 
<%

Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
String facility_id =(String) session.getAttribute("facility_id"); 

String disable_flag="";
String next_anaesthesia_serial_num		="";
String next_preop_asses_num				="";

String sql="";
int total_records=0;
	con=ConnectionManager.getConnection(request);	//Added Against Common-ICN-0031
	try{
		//con=ConnectionManager.getConnection(request);	//Commented Against Common-ICN-0031
		sql=" Select count(*) as total_records_existing from AT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID = ? ";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,facility_id);
		rs=stmt.executeQuery();
	    rs.next();
		
		total_records=rs.getInt(1);
		
}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			//ConnectionManager.returnConnection(con);	//Commented Against Common-ICN-0031
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		}

		if(total_records==1)
		{
		   mode="modify";
		   disable_flag="disabled";
		}
		else
		{
		   mode="insert";
		   disable_flag="";
		}

		if(mode.equals("modify"))
{

	try{
		//con=ConnectionManager.getConnection(request);		//Commented Against Common-ICN-0031
		sql="Select NEXT_ANAESTHESIA_SERIAL_NUM, NEXT_PREOP_ASSES_NUM FROM AT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID = ?";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,facility_id);
		rs=stmt.executeQuery();

		if(rs!=null && rs.next())
		{
			next_anaesthesia_serial_num		=(rs.getString("NEXT_ANAESTHESIA_SERIAL_NUM")==null?"":rs.getString("NEXT_ANAESTHESIA_SERIAL_NUM"));
			next_preop_asses_num			=(rs.getString("NEXT_PREOP_ASSES_NUM")==null?"":rs.getString("NEXT_PREOP_ASSES_NUM"));
		}

}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		}
}

%>
<br><br>
<table border=0 cellspacing=0 cellpadding=3  width='60%'  align=center>
<!-- <tr>
	<td width='35%'>&nbsp;</td>
	<td width='35%'>&nbsp;</td>
</tr>  -->

<th class="columnheadercenter" colspan='2'><fmt:message key="eOT.AnaesthesiaNumbering.Label" bundle="${ot_labels}"/></th>
<!-- <td width='70%'></td>
<td width='70%'></td> -->
 
<tr> 
	<td class=label align=left nowrap>
		<fmt:message key="eOT.NextNo.Label" bundle="${ot_labels}"/> 
	</td><td>
		<input type='text' name='next_anaesthesia_serial_num' id='next_anaesthesia_serial_num' size='10' value="<%=next_anaesthesia_serial_num%>" > 
		<img src='../../eCommon/images/mandatory.gif'> 
	</td>
	<!-- <td></td>	 -->
</tr> 

<!-- <tr>
	<td width='35%'>&nbsp;</td>
	<td width='35%'>&nbsp;</td>
</tr> --> 

<th class="columnheadercenter" colspan='2'>
	<fmt:message key="eOT.PreOperativeAssessmentNum.Label" bundle="${ot_labels}"/>
</th>
<!-- <th width='100%'></th>
<th width='100%'></th> -->  

<tr> 
	<td class='label' nowrap>
		<fmt:message key="eOT.NextNo.Label" bundle="${ot_labels}"/> 
		</td><td>
		<input type='text' name='next_preop_asses_num' id='next_preop_asses_num' size='10' value="<%=next_preop_asses_num%>" > 
		<img src='../../eCommon/images/mandatory.gif'> 
	</td><!-- 	<td></td>	 -->			 
</tr> 

<!-- 
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr> -->
</table>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name="tot_records" id="tot_records" value="<%=total_records %>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


