<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html> 
<head><title><fmt:message key="Common.ModeOfTransport.label" bundle="${common_labels}"/></title>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle			= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	
%>


	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eFM/js/FMIssueFiles.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	//  below function added for 19706 date:Monday, March 01, 2010 and 19721 //0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* '

	function CheckForSpecChars_space(event)
	{
		
	 var strCheck ='`~!@#$%^&()="+[{]};:\|<,.>?/|\'-';
		 var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
if (strCheck.indexOf(key) == -1 && event.keyCode !=13 && (event.keyCode != 92)) return true;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return false ;
	}
	</script>
</head>
<%
	Connection con			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt	= null;
	ResultSet rs			= null ;

	try
	{
		String file_transport_mode = request.getParameter("file_transport_mode");
		String carried_by_name = request.getParameter("carried_by_name");

		if(file_transport_mode == null) file_transport_mode = "";
		if(carried_by_name == null) carried_by_name = "";
%>
<body style="overflow-y:hidden" onKeyDown = 'lockKey()' onLoad="showIdentity(); ablDisablOK();">
	<form name="FMIssueFileTransport" id="FMIssueFileTransport" METHOD="post" TARGET="messageFrame">
		<table WIDTH="100%" BORDER="0" CELLSPACING="0" CELLPADDING="3" ALIGN="center">
			<tr>
				<td class='label'  nowrap width='50%'><fmt:message key="Common.ModeOfTransport.label" bundle="${common_labels}"/></td>
				<td  class='fields' width='30%'><select name='file_transport_mode' id='file_transport_mode' onChange='enableDisable(this)'>
						<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
						<%
						stmt = con.createStatement();
						//rs = stmt.executeQuery("Select TRANSPORT_MODE,long_desc,by_person_yn from am_transport_mode where EFF_STATUS='E' AND FILE_RELATED_YN = 'Y' ");
						rs = stmt.executeQuery("SELECT TRANSPORT_MODE,        Long_desc, By_Person_yn FROM    am_transport_mode_lang_vw WHERE  EFF_STATUS = 'E' AND FILE_RELATED_YN = 'Y'  AND  LANGUAGE_ID='"+localeName+"'");
						
						while(rs != null && rs.next())
						{
						String ID	= rs.getString("TRANSPORT_MODE");
						String desc	= rs.getString("long_desc");
						String carried	= rs.getString("by_person_yn");

						if(desc == null || desc.equals("null")) desc = "";
						if(ID == null || ID.equals("null")) ID = "";
						if(carried == null || carried.equals("null")) carried = "";
						out.println("<script>by_person[incr]='"+carried+"';incr++;</script>");
						if(ID.equals(file_transport_mode))
							out.println("<option value='"+ID+"' selected>"+desc+"</option>");
						else
							out.println("<option value='"+ID+"'>"+desc+"</option>");
						}
						%>
					</select>
				</td>
				<td class='label' width='10%'></td>
			<td class='label' width='10%'></td>
		</tr> 
		<TR id="td1"><TD COLSPAN="4"></TD></TR>
		<TR> <TD CLASS="label" ><fmt:message key="eFM.CarriedBy.label" bundle="${fm_labels}"/></TD>
			<TD class='fields'><input type="text" maxlength="30" name="carried_by_name" id="carried_by_name"  onKeyPress='return CheckForSpecChars_space(event)' value="<%=carried_by_name%>"><img ID="td3" src='../../eCommon/images/mandatory.gif' align='center'></img></TD>
			
			<td class='label' ID="td2" style="display:none"></td>
			<td class='label' ></td>
		</TR>
		<TR>
			<TD CLASS="labelcenter" COLSPAN="4" ALIGN="center">
			<INPUT TYPE="button" CLASS="button" name="okbutton" id="okbutton" VALUE='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onClick="submitdetails()">
			<INPUT TYPE="button" CLASS="button" name="cancelbutton" id="cancelbutton" VALUE="Cancel" onClick="parent.document.getElementById('dialog_tag').close()">
			</TD>
		</TR>
	<%
	if(rs!=null ) rs.close();
	if(stmt != null) stmt.close();			
	}catch(Exception e){out.println("Exception e :"+e.toString());}
	finally 
	{		
		ConnectionManager.returnConnection(con,request);
	}
%>
</table>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

