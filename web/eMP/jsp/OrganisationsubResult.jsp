<!DOCTYPE html>
<!--
	Developed By       :	Shyam Prasad.P
	Created on   	   :	09/02/2006
	Function		   :	Oraganization
-->
<%@ page contentType="text/html; charset=UTF-8" import="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>


<script src='../../eMP/js/Organization.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function copyDetails(id)
{
	
	var org_id=document.forms[0].org_id.value;
	var org_name=document.forms[0].org_name.value;

	parent.frames[1].location.href="../../eMP/jsp/Organisationsub.jsp?org_sub_id="+id+"&mode=update"+"&org_id="+org_id+"&org_name="+org_name;
}
</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
<form>
 <table border="1" cellpadding="0" cellspacing="0" width="100%" align='center'>
 <td colspan=3 class='columnheader'><fmt:message key="eMP.SubUnitDetails.label" bundle="${mp_labels}"/></td>
 <tr><td colspan=1 width='25%'></td>
 <td colspan=1 width='45%'></td>
 <td colspan=1 width='35%'></td>
 </tr> 
 <td colspan=1 class='columnheader' nowrap><fmt:message key="eMP.SubUnitID.label" bundle="${mp_labels}"/></td>
 <td colspan=1 class='columnheader' ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
 <td colspan=1 class='columnheader' nowrap><fmt:message key="Common.ContactName.label" bundle="${common_labels}"/></td>
 <%
   ResultSet rs			= null;
   Statement stmt		= null;
   Connection con		= null;
   String family_org_id = "";
   String Orgdesc="";
   
   try
   {
     con			= ConnectionManager.getConnection(request);
	 family_org_id	= checkForNull(request.getParameter("org_id"));

     String sql="select eff_status,family_org_sub_id,(select FAMILY_ORG_NAME from MP_FAMILY_ORG where FAMILY_ORG_ID='"+family_org_id+"')  Orgdesc,family_org_sub_name,org_contact_name from MP_FAMILY_ORG_SUB where FAMILY_ORG_ID='"+family_org_id+"' order by family_org_sub_id ";
      stmt=con.createStatement();
      rs=stmt.executeQuery(sql);
	  int i=0;
	  String classValue="";
   while(rs.next())
   {
	   Orgdesc=checkForNull(rs.getString("Orgdesc"));
	   if ( i % 2 == 0 )
		  classValue = "QRYEVEN" ;
	   else
		  classValue = "QRYODD" ;
	   %><tr>

      <td class="<%=classValue%>">
	<%if(rs.getString("eff_status").equals("E")){%>
	 <a href='javascript:copyDetails("<%=checkForNull(rs.getString("family_org_sub_id"))%>")'><%=checkForNull(rs.getString("family_org_sub_id"))%>
	<%}else{%>
     <%=checkForNull(rs.getString("family_org_sub_id"))%>
	 <%}%></td>
      <td class="<%=classValue%>"><%=checkForNull(rs.getString("family_org_sub_name"))%></td>
      <td class="<%=classValue%>"><%=checkForNull(rs.getString("org_contact_name"),"&nbsp;")%></td>
     </tr>
   <% i++;}
 %>
 </table>
 <input type="hidden" name=org_id id=org_id value="<%=family_org_id%>">
 <input type="hidden" name=org_name id=org_name value="<%=Orgdesc%>">
 </form>
 </body>
	 <%}catch(Exception e)
	{
		   out.println("Exception in file AddOrganization.jsp"+e.toString());
    }
   finally 
   {
	   if(con!=null) ConnectionManager.returnConnection(con,request);
   }%>
</html>

  <%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

