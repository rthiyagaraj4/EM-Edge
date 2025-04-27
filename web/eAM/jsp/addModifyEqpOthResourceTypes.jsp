<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script src="../../eCommon/js/common.js" language='javascript'></script>

<script src="../../eAM/js/EquipmentOtherResourceTypes.js"  language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()' onLoad="FocusFirstElement();">
<%
	request.setCharacterEncoding("UTF-8");
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	Connection conn = ConnectionManager.getConnection(request);
	String mode = request.getParameter( "operation" );
	
	String rsrce_class = request.getParameter("resource_class");
	String rsrceType = request.getParameter("resource_type");
	
	Statement stmt=null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	String sql = "";

	String resource_class  = "";
	String resourceType = "";
	String longDesc	 = "";
	String shortDesc	 = "";
	String reactEffStatus = "E";
	String chkEffStatus  = "checked";
	String make_readonly = "";
	String rscrType_readonly="";
	//String checkenable ="enabled";

	try
	{
		if(!(rsrce_class==null && rsrceType==null))
		{
			sql = "Select * From am_resource_type where RESOURCE_TYPE=? ";
						
			pstmt   = conn.prepareStatement(sql);
			pstmt.setString	(	1,	rsrceType);
			rs		 = pstmt.executeQuery();

			if(rs.next()) {
				resource_class	= rs.getString("RESOURCE_CLASS");	
				resourceType	= rs.getString("RESOURCE_TYPE");
				longDesc	= rs.getString("LONG_DESC");
				shortDesc	= rs.getString("SHORT_DESC");
				reactEffStatus	= rs.getString("EFF_STATUS");
			
			}			
			if(resource_class == null || resource_class.equals("null"))
				resource_class = "";
			if(resource_class.equals("E")) resource_class="Equipment";
				else resource_class="Other";
			if(resourceType == null || resourceType.equals("null"))
				resourceType = "";
			if(longDesc == null || longDesc.equals("null"))
				longDesc = "";
			if(shortDesc == null || shortDesc.equals("null"))
				shortDesc = "";
			if(reactEffStatus == null || reactEffStatus.equals("null"))
				reactEffStatus = "";
			
			if (reactEffStatus.equals("E"))
				chkEffStatus = "checked";
			else if (reactEffStatus.equals("D"))
			{
				chkEffStatus = "unchecked";
				make_readonly = "readonly"; 
			}
			
			rscrType_readonly="readonly";
			mode = "modify";
			
		}else		
		{
			resource_class  = "";
			resourceType = "";
			longDesc	 = "";
			shortDesc	 = "";

			reactEffStatus = "E";
			chkEffStatus  = "checked";
			mode = "insert";
		}

%>


	<form name='EquipmentOtherResourceTypes_form' id='EquipmentOtherResourceTypes_form' action='../../servlet/eAM.EquipmentOtherResourceTypesServlet' method='post' target='messageFrame'>
		<div>
				<br><br><br><br>	<br><br><br><br>
				<table border='0' cellpadding='0' cellspacing='0' width='65%' align='center'>
					<tr><td colspan='2'>&nbsp;</td></tr>	
					<tr>
				
						<td class='label' width='30%'><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>		
						<td class='fields' width='70%'>&nbsp;
						<%
							if(mode.equals("modify")){  
						%>	

							<input type="text" name='resource_class' id='resource_class' size='10' maxlength='10' value='<%=resource_class%>' readonly>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
						<%
						}else{
						%>

				 		<select name='resource_class' id='resource_class' >  
							<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- <option value="E"><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
							<option value="O"><fmt:message key="Common.other.label" bundle="${common_labels}"/>
							</option>
						</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
						<%}%>
						
					   </td>
					</tr>
				  
					<tr><td colspan='2'>&nbsp;</td></tr>	
					<tr>
						<td  class='label' width='30%'><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
						<td class='fields' width='70%'>&nbsp;
						<input type='text' name='resource_type' id='resource_type' size='2' maxlength='2' value='<%=resourceType%>' <%=rscrType_readonly%> onBlur="ChangeUpperCase(this);" onKeyPress='return CheckForSpecChars(event);' >&nbsp;
						<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
					</tr>
					<tr><td colspan='2'>&nbsp;</td></tr>	
					<tr>
						<td  class='label' width='30%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
						<td class='fields' width='70%'>&nbsp;
						<input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur="makeValidString(this);" value="<%=longDesc%>" <%=make_readonly%>>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
					</tr>
					<tr><td colspan='2'>&nbsp;</td></tr>	
					<tr>
						<td  class='label' width='30%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
						<td class='fields' width='70%'>&nbsp;
						<input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortDesc%>" <%=make_readonly%> onBlur="makeValidString(this);" >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
					</tr>
					<tr><td colspan='2'>&nbsp;</td></tr>	
					<tr>
						<td  class='label' width='30%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
						<td class='fields' width='70%'>&nbsp;
						<input type='checkbox' name='eff_status' id='eff_status' value='<%=reactEffStatus%>' <%=chkEffStatus%> onClick="change()"></td>
					</tr>
					<tr><td colspan='2'>&nbsp;</td></tr>	
			</table>
		</div>

<%
		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		
		ConnectionManager.returnConnection(conn,request);
	}
%>
		<input type='hidden' name='function' id='function' value='<%=mode%>'>
	</form>
</body>
</html>

