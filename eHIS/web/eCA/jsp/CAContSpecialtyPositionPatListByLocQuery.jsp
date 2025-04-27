<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
01/31/2024   49654      Twinkle Shah    Ramesh Goli      ML-MMOH-CRF-2109
--------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
Connection con=null;
request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0038
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
String dis="";
String pract_type="";
String desc_userdef="";
String  sql1 = "";

try
{
	PreparedStatement stmt1=null;
	ResultSet rs1=null;
	con=ConnectionManager.getConnection(request);
	String facility_id = (String)session.getValue("facility_id");
%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/CAContSpecialtyPositionPatListByLoc.js'></script>

</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement()' onKeyDown="lockKey()">

<form name="CAContSpecPositionPatListByLocForm" id="CAContSpecPositionPatListByLocForm">
<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>

<tr>
	<td class='label' ><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
	<td class='fields'><select name=practitioner_type id=practitioner_type onchange="callOnChange(this)">
	<option value=''>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------</option>	
	<%
			sql1="SELECT PRACT_TYPE,DESC_USERDEF FROM AM_PRACT_TYPE WHERE EFF_STATUS='E' ORDER BY DESC_USERDEF";
			stmt1=con.prepareStatement(sql1);
			rs1=stmt1.executeQuery();
			if(rs1!=null)
			{
				while(rs1.next())
				{
					pract_type=rs1.getString(1);
					desc_userdef=rs1.getString(2);
					out.println("<option value='"+pract_type+"'>"+desc_userdef+"</option>");
				}
			}

		if(rs1!=null)rs1.close();
		if(stmt1!=null)stmt1.close();


%>	</select><img src='../../eCommon/images/mandatory.gif'></img></td>	
<tr>
	<td  colspan='2'></td>
	<td colspan = '2' align=center ><input type=button class=button name=search id=search value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick='populateData();'></td>
</tr>


</table>
<input type="hidden" name="pract_type" id="pract_type" value="<%=pract_type%>">

<%
}
catch(Exception e){
	out.println("Exception in CAContSpecialtyPositionPatListByLoc.jsp"+e.toString());
	}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</form>
</body>
</html>

