<!DOCTYPE html>
<!--
	Developed By       :	Shyam Prasad.P
	Created on   	   :	09/02/2006
	Function		   :	Oraganization
-->
<%@ page contentType="text/html; charset=UTF-8" import="java.sql.*,java.util.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eMP/js/Organization.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function calldis()
{
	parent.parent.frames[0].document.getElementById('apply').disabled= true;
}
</script>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown='lockKey();' onload="calldis();FocusFirstElement()">
<form name="contact_form" id="contact_form" action="../../servlet/eMP.OrganizationServlet" method="post" target="messageFrame">
 <%
   ResultSet rs				= null;
   Statement stmt			= null;
   Connection con			= null;
   String organization_id	= "";
   String organization_name = "";
   String effective_status  = "";
   String mode1				= "";
   String disabled			= "";
   String checked			= "checked";
   String recdis			= "";
   String rec_disabled			= "";
   try{
		   organization_id=checkForNull(request.getParameter("org_id"));
		   recdis=checkForNull(request.getParameter("recdis"));
		   mode1=checkForNull(request.getParameter("mode"));
		   if(mode1.equals(""))
		   mode1="insert";
           if(recdis.equals("Y"))
		   rec_disabled="disabled";
		   else
            rec_disabled="";
		   
   if(!organization_id.equals(""))
   {
			con = ConnectionManager.getConnection(request);
		    String sql="select FAMILY_ORG_ID, FAMILY_ORG_NAME, EFF_STATUS from MP_FAMILY_ORG where FAMILY_ORG_ID='"+organization_id+"'";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
			   organization_id=rs.getString("FAMILY_ORG_ID");
			   organization_name=rs.getString("FAMILY_ORG_NAME");
			   effective_status=rs.getString("EFF_STATUS");
			}
	}
	
   if(effective_status.equals("E")){
     checked="checked";
	 disabled="";
   }
	else if(effective_status.equals("D")){
	 checked="";
	 disabled="disabled";
	}
    

 %>
  <table border="0" cellpadding="3" cellspacing="0" width="100%" align='center'>
  
  <td colspan=4  class='columnheader'><fmt:message key="Common.Organization.label" bundle="${common_labels}"/></td>
  <tr>
  <td colspan=1 width="20%"></td>
  <td colspan=1 width="20%"></td>
	  <td colspan=1 width="25%"></td>
	  <td colspan=1 width="35%"></td>
  </tr>

  <tr>
  <td colspan=1 class='label' ><fmt:message key="eMP.OrganizationID.label" bundle="${mp_labels}"/></td>
  <td colspan=1 class='fields'><input name="org_id" id="org_id" maxlength=10 size=10 value="<%=organization_id%>" onBlur="ChangeUpperCase(this);MPCheckNumber(this)" onKeyPress="return CheckForSpecChars(event);" <%if(!organization_id.equals("")){%> disabled <%}%>type=text><img src='../images/mandatory.gif'></img></td>
  <td colspan=1 class='label'><fmt:message key="Common.orgName.label" bundle="${common_labels}"/></td>
  <td colspan=1 class='fields'><input name="org_name" id="org_name" <%=disabled%> value="<%=organization_name%>" maxlength=30 size=30 type=text><img src='../images/mandatory.gif'></img></td>
  </tr>
   <tr>
  <td colspan=1 class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
  <td colspan=1 class='fields'><input name="eff_status" id="eff_status" <%=checked%> type=checkbox></td>
<td colspan=3 ><input type='button' name='record_org' id='record_org' <%=rec_disabled%> class='button' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="record1();"><input type='reset' class='button' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'>
	</td>
  </tr>
  
  </table>
  <input type="hidden" name="function" id="function" value='Organization_main'>
  <input type="hidden" name="mode" id="mode" value='<%=mode1%>'>
  </form>
  <%}//end of try block
	catch(Exception e)
	{
		   out.println("Exception in file AddOrganization.jsp"+e.toString());
    }
   finally 
   {
	   if(con!=null) ConnectionManager.returnConnection(con,request);
   }
 %>
  </body>
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

