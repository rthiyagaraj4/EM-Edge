<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
Connection con=null;
request.setCharacterEncoding("UTF-8"); 
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
String dis="";
String idd="";
String datt="";
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

// added by Arvind @  06-12-08 

	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 //end

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<script language='javascript' src='../js/NoteTypeByService.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement()' onKeyDown="lockKey()">

<form name="NoteTypeByService_form" id="NoteTypeByService_form">
<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>

<tr>
	<td class='label' ><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
	<td class='fields'><select name=note_type <%=dis%> onchange="callOnChange(this)">
	<option value=''>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------</option>	
	<%
			sql1=" Select note_type_desc, note_type from ca_note_type where SERV_FACL_SPEC_YN = 'Y' and eff_status='E' order by note_type_desc ";
			stmt1=con.prepareStatement(sql1);
			rs1=stmt1.executeQuery();
			if(rs1!=null)
			{
				while(rs1.next())
				{
					datt=rs1.getString(1);
					idd=rs1.getString(2);
					out.println("<option value='"+idd+"'>"+datt+"</option>");
				}
			}

		if(rs1!=null)rs1.close();
		if(stmt1!=null)stmt1.close();


%>	</select><img src='../../eCommon/images/mandatory.gif'></img></td>
	<td class='label' ><fmt:message key="Common.department.label" bundle="${common_labels}"/></td>
	<td class='fields'><select name=department onchange="callOnChange(this)">
	<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
<%
			sql1=" select DEPT_SHORT_DESC, DEPT_CODE from am_facility_dept_vw where operating_facility_id= ? and eff_status = 'E' order by DEPT_SHORT_DESC		";
			stmt1=con.prepareStatement(sql1);
			stmt1.setString(1,facility_id);
			rs1=stmt1.executeQuery();
			String service_desc="";
			String service_code="";
			if(rs1!=null)
			{
				while(rs1.next())
				{
					service_desc=rs1.getString(1);
					service_code=rs1.getString(2);
					out.println("<option value='"+service_code+"'>"+service_desc+"</option>");
				}
			
			if(rs1!=null) rs1.close();
			if(stmt1!=null) stmt1.close();
			}
%>
	</select></td>
</tr>
	
<tr>
	<td  colspan='2'></td>
	<td colspan = '2' align=right ><input type=button class=button name=search value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick='submitPage();'></td>
</tr>


</table>

<!-- added by arvind @ 06-12-08 -->

				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>

				<!-- end -->
<%
	
}
catch(Exception e){
	//out.println("Exception in AddModifyNoteTypeByService.jsp"+e.toString());//COMMON-ICN-0181
          e.printStackTrace();//COMMON-ICN-0181
	}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</form>
</body>
</html>

