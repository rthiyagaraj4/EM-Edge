<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
<!-- CRF-268 Consumable pack - Rajesh V -->
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<!-- CRF-268 Consumable pack - Rajesh V -->
<script language='javascript' src='../../eOT/js/ConsumablePack.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onload="parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("update_mode_yn");
String chk_checked="checked";
String chk_value="E";
String package_code = request.getParameter("package_code")==null?"":request.getParameter( "package_code" );
if(package_code.equals("null") || package_code=="null"){
	package_code="";
}
String disable_flag="";
String package_code_disable="";
String long_description="";
String short_description="";
String sql="";
String status="";
//CRF-268 Consumable pack - Rajesh V
String facility_id = (String) session.getAttribute("facility_id");
String locale = (String) session.getAttribute("LOCALE");
String otParam = "";
String ss_group_desc = "";
//CRF-268 Consumable pack - Rajesh V
StringBuffer package_code_from_DB=new StringBuffer();
//CRF-268 Consumable pack - Rajesh V
try{
	con=ConnectionManager.getConnection(request);
	String sqlOtParam = "select NVL(cssd_interface_yn,'N') facility from ot_param_for_facility where operating_facility_id = ?";
	stmt=con.prepareStatement(sqlOtParam);
	stmt.setString(1,facility_id);
	rs=stmt.executeQuery();
	if(rs!=null && rs.next())
	{
		otParam = rs.getString("facility");
	}
	
	rs = null;
	stmt = null;
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
//CRF-268 Consumable pack - Rajesh V
if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);		
		//CRF-268 Consumable pack - Rajesh V
		//sql="SELECT PACKAGE_CODE, LONG_DESC,SHORT_DESC,NVL(STATUS,'E') STATUS FROM OT_PACKAGE_HDR WHERE PACKAGE_CODE=? ";
		sql = "SELECT PACKAGE_CODE, LONG_DESC,SHORT_DESC,NVL(STATUS,'E') STATUS, (select SHORT_DESC from SS_GROUP where group_code = OT_PACKAGE_HDR.ss_group_code) description FROM OT_PACKAGE_HDR WHERE PACKAGE_CODE= ?";
		//CRF-268 Consumable pack - Rajesh V
		stmt=con.prepareStatement(sql);
		stmt.setString(1,package_code);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			package_code=rs.getString(1);
			long_description=rs.getString(2);
			short_description=rs.getString(3);
			status=rs.getString(4);
			//CRF-268 Consumable pack - Rajesh V
			ss_group_desc = rs.getString("description");
			if(ss_group_desc == null){
				ss_group_desc = "";
			}
			//CRF-268 Consumable pack - Rajesh V
		}
		if(status.equals("E"))
		{
			chk_checked="checked";
			disable_flag="";
			
		}
		else
		{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}
		
	package_code_disable="disabled";	
		
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
}else if(mode.equals("insert")){
   
		try{
		con=ConnectionManager.getConnection(request);
		sql="SELECT PACKAGE_CODE FROM OT_PACKAGE_HDR";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
        		
		while(rs!=null && rs.next())
		{
			package_code_from_DB=package_code_from_DB.append(",").append(rs.getString(1));
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
<form name="ConsumablePacksHeader" id="ConsumablePacksHeader"  onload='FocusFirstElement()'  action="" method="" target="messageFrame"> 

<table border=0 cellspacing=0 cellpadding=0 width='70%'  align=center>
<tr>
	<td width='25%'>
	</td>
	<td width='25%'>
	</td>
</tr>

<tr>
	<td class=label><fmt:message key="Common.PackageCode.label" bundle="${common_labels}"/></td>
	<td clsas="fields">
	      <input type="text" name="package_code" id="package_code" value="<%=package_code%>" size=20  maxlength=20  <%=package_code_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
		  <img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td class="fields">
        <input type="text" name="long_description" id="long_description" value="<%=long_description%>"  size=40 maxlength=40 >
	    <img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label>
	       <fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
	</td>
	<td class="fileds">
	     <input type="text" name="short_description" id="short_description" value="<%=short_description%>"  size=15 maxlength=15 >
	     <img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<!-- CRF-268 Consumable pack - Rajesh V -->
<%if("Y".equalsIgnoreCase(otParam)){ %>
<tr>
<td class=label>
	<fmt:message key="eOT.CrossRefSSGroup.Label" bundle="${ot_labels}"/>
</td>
	<td class='fields'>
		<input type="text"  name="ss_group_desc" id="ss_group_desc" size='20' maxlength='20' value="<%=ss_group_desc%>" 
		onBlur="if(this.value!='')callSS_Group_Code();" >
		<input type="button" class="button" name="generic_search" id="generic_search" value="?" onClick="callSS_Group_Code();" >

	</td> 
</tr>
<%}%>
<!-- CRF-268 Consumable pack - Rajesh V -->
<tr>
	<td class=label>
	     <fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="checkbox" name="status" id="status" onClick='setStatusValue();' value='<%=chk_value%>' <%=chk_checked%> >
	</td>
</tr>


<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr>
</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name='package_code1' id='package_code1' value="<%=package_code%>">
<input type="hidden" name='long_description1' id='long_description1' value="<%=long_description%>">
<input type="hidden" name='short_description1' id='short_description1' value="<%=short_description%>">
<input type="hidden" name='package_code_from_DB' id='package_code_from_DB' value="<%=package_code_from_DB%>">
<!-- CRF-268 Consumable pack - Rajesh V -->
<input type="hidden" name="ss_group_code" id="ss_group_code" value="">
<input type=hidden name='locale' id='locale' value="<%=locale%>">
<!-- CRF-268 Consumable pack - Rajesh V -->
</form>
</body>
</html>


