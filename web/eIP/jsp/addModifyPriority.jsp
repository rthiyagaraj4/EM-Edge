<!DOCTYPE html>
<%
/// MODULE			:	InPatient Management..(IP)
/// Function Name	:	IPCodeSetUp -> Priority
/// Developer		:	SRIDHAR R
/// Funtion			:	This func is used to create a Priority Level with distinct colors.
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
   <head>
      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
      	
      	
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
		<script src='../js/Priority.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<%
// Added by SRIDHAR R on 27 APR 2004
// Initialization of variables
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String effStatus		= ""; 
	String checkBox1		= "";
	String checkBox4		= "";
	String priority_code	= "";
	String long_desc		= "";
	String short_desc		= "";
	String eff_status		= "";
	String exp_status		= "";
	String type_hours		= "";
	String type_days		= "";
	String exp_day			= "";
	String color_scheme		= "";
	String facilityID		= "";
	String disbld			= "";
	String rdonly			= "";
	String chk				= "";
	String mode				="insert";
	String expiry_period_unit	= "";

	Connection conn = null;
	Statement stmt	= null;
	ResultSet rs	= null;
	facilityID=(String)session.getValue("facility_id");

	mode = request.getParameter("mode");
	if (mode ==null) mode="insert";

	if(mode.equals("insert"))
		chk = "checked";

	if(mode.equals("update"))
	{
		rdonly = "readonly";
		priority_code = checkForNull(request.getParameter("priority_code"));

		eff_status	= checkForNull(request.getParameter("eff_status"));
		if(eff_status.equals("E"))
		{
			eff_status = "checked";
			disbld = "";
			rdonly = "";
		}
		else
		{
			eff_status = "";
			disbld = "disabled";
			rdonly = "readonly";
		}
	}

// Will Fetch the values in the update mode from IP_TRANSFER_PRIORITY table & display it in the form..
try
{  
	conn = ConnectionManager.getConnection(request);
	stmt = conn.createStatement();
  
  if(mode.equals("update"))
  {
	
	StringBuffer sql = new StringBuffer();
	sql.append("select * from IP_TRANSFER_PRIORITY where facility_id='"+facilityID+"' and priority_code='"+priority_code+"' ");

	rs = stmt.executeQuery(sql.toString());
	if(rs!=null )
	{
		while(rs.next())
		{
			priority_code	= checkForNull(rs.getString("priority_code"));
			long_desc  		= checkForNull(rs.getString("long_desc"));
			short_desc 		= checkForNull(rs.getString("short_desc"));
			color_scheme	= checkForNull(rs.getString("color_code_scheme"));
			exp_status		= checkForNull(rs.getString("expire_yn"));
			exp_day			= checkForNull(rs.getString("expiry_period"));
			expiry_period_unit = checkForNull(rs.getString("expiry_period_unit"));

			if(expiry_period_unit.equalsIgnoreCase("D"))
				type_days ="selected";
			else 
				type_hours="selected" ;

			effStatus = rs.getString("eff_status");
		
			if(effStatus.equals("E"))
			{
				checkBox4 = "checked";
				disbld = "";
				rdonly = "";
				
				if(exp_status.equals("Y"))
					checkBox1 = "checked";
				else
					checkBox1 = "";
			}
			else
			{
				if(exp_status.equals("Y"))
					checkBox1 = "checked";
				else
					checkBox1 = "";

				checkBox4 = "";
				disbld = "disabled";
				rdonly = "readonly";
			}
		 }
	  }
   }

if(rs!=null) 	    rs.close();
if(stmt!=null)	    stmt.close();
}
catch(Exception e)
{
// out.println(e.toString());
e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(conn,request);
}

%>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad='FocusFirstElement();change();setColor("<%=color_scheme%>","<%=mode%>");disableFields("<%=effStatus%>","<%=exp_status%>")'>
<form name='priority_form' id='priority_form'  method='post' action="../../servlet/eIP.TransferPriorityServlet" target='messageFrame'>
<div align='center'>
<br><br><br><br><br><br><br>
	<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
		<input type='hidden' name='mode' id='mode' value='<%=mode%>' >
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facilityID%>' >
		<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
		</tr>
   		<tr>
			<td class='label'>&nbsp;</td>

		<%
		String readonly_txt = "";
		  if(mode.equals("update"))
			  readonly_txt = "readonly"; 
		  else
			 readonly_txt = "";
		%>

			<td align='right' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td class='fields'>&nbsp;<input type='text' name='priority_code' id='priority_code' <%=readonly_txt%> <%=rdonly%> value="<%=priority_code%>"  onKeyPress="return CheckForSpecChars(event)" size=2 maxlength = 2><img src='../../eMP/images/mandatory.gif'align='center'></img>
			</td>
			<td class='label'>&nbsp;</td>
		</tr>
		<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
		</tr>
		<tr>
			<td class='label'>&nbsp;</td>
			<td   align='right' class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td class='fields'>&nbsp;<input type='text' name='long_desc' id='long_desc' <%=rdonly%> size='30' maxlength='30' value="<%=long_desc%>"  onBlur="makeValidString(this)"><img src='../../eMP/images/mandatory.gif'align='center'></img></td>
			<td class='label'>&nbsp;</td>
		</tr>
		<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
		</tr>

		<tr>
			<td class='label'>&nbsp;</td>
			<td align='right' class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		    <td class='fields'>&nbsp;<input type='text' name='short_desc' id='short_desc' <%=rdonly%> size='15' maxlength='15' value="<%=short_desc%>"  onBlur="makeValidString(this)"><img src='../../eMP/images/mandatory.gif'align='center'></img></td>
		    <td class='label'>&nbsp;</td>
   		</tr>
		<tr>
   			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
		</tr>
		<tr>
			<td class='label'>&nbsp;</td>
			<td align='right' class=label><fmt:message key="eIP.ColourCodeScheme.label" bundle="${ip_labels}"/></td>
			<td class='fields'>&nbsp;<input type="text" name="colorTxt" id="colorTxt" size="15" readonly align="right" ><img src='../../eIP/images/showColor.gif' alt='Get Color' onClick='showModal();' <%=disbld%> valign="CENTER" style="cursor:pointer" height="16">
			<input type="hidden" name="color_scheme" id="color_scheme" value="">
			<input type="hidden" name="update_color_val" id="update_color_val" value="<%=color_scheme%>">
			
			</td>
			<td class='label'>&nbsp;</td>
		</tr>
		<tr>
      		<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
		</tr>
		<tr>
			 <td class='label'>&nbsp;</td>
			 <td align='right' class='label'><fmt:message key="eIP.ExpiryRequired.label" bundle="${ip_labels}"/></td>
			 <td align='left' class='fields'><input type='checkbox' name='exp_status' id='exp_status'  <%=disbld%> value='Y' <%=checkBox1%> onClick="change()">&nbsp;&nbsp;<fmt:message key="Common.ExpiryPeriod.label" bundle="${common_labels}"/>&nbsp; <input type='text' name='exp_day' id='exp_day'  size='3' maxlength='3' value="<%=exp_day%>"  onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNum(this);CheckZeroVal(this)" <%=rdonly%> >
			 <input type="hidden" name="update_unit" id="update_unit" value="<%=expiry_period_unit%>">
			 <input type="hidden" name="hid_exp_day" id="hid_exp_day" value="<%=exp_day%>">
			<select <%=disbld%> name="days_hours" >
					<option value='H'  <%=type_hours%> ><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
					<option value='D'  <%=type_days%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
			</select><img id="star" src='../../eMP/images/mandatory.gif'align='center'></img></td>
			<td class='label'>&nbsp;</td>
		</tr>
		<tr>
			 <td class='label'>&nbsp;</td>
			 <td align='right' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			 <td align='left' class='fields'><input type='checkbox'  name='eff_status' id='eff_status' value='E' <%=chk%> <%=checkBox4%> onclick="chkStatus(this);" ></td>
			 <td class='label'>&nbsp;</td>
		</tr>
		<tr>
			<td class='label' width='10%'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label' width='10%'>&nbsp;</td>
		</tr>
	</table>
  </form>
 </body>
</html>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

