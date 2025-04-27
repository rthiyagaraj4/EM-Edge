<!DOCTYPE html>
 <%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	 <%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script> 
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script src="../../eCA/js/FlowSheetComponent.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>	
	</script>
	</head>
<%
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	String sql="";
	String dis="";
	String enabled_checked="";
	String menu_id="";
	String mode="";
	String s_desc="";
	String l_desc="";
	String eff_status="";
	String type="";
	String rncheck="";
	String rccheck="";
	
	mode=request.getParameter("mode")==null ? "" :request.getParameter("mode");
	type=request.getParameter("type")==null ? "" :request.getParameter("type");
	
	if(type.equalsIgnoreCase("C"))
	{
		rccheck="checked";
	}
	if(type.equalsIgnoreCase("N")){rncheck="checked";}


try
{
	if(mode.equals("insert"))
	{
		enabled_checked="checked";
	}
	else{
		con=ConnectionManager.getConnection(request);
		mode = "modify"; 	
		menu_id=(request.getParameter("menu_id")==null)?"":request.getParameter("menu_id");
		
		//sql = "select LONG_DESC,SHORT_DESC,EFF_STATUS from ca_flow_sheet where FLOW_SHEET_ID = ? ";
		sql = "select LONG_DESC,SHORT_DESC,EFF_STATUS from ca_flow_sheet_LANG_vW where FLOW_SHEET_ID = ? AND LANGUAGE_ID = ?";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,menu_id);
		stmt.setString(2,locale);
		rs=stmt.executeQuery();

		while(rs.next())
		{
			l_desc = rs.getString("LONG_DESC");
			s_desc = rs.getString("SHORT_DESC");
			eff_status = rs.getString("EFF_STATUS");
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(eff_status==null) eff_status="";

		if(s_desc==null) s_desc="";
		if(l_desc==null) l_desc="";

	}
		if(mode.equals("modify")){
		if(eff_status.equals("E")){
				enabled_checked="checked";
				dis="disabled";
			}
			else{
				enabled_checked="";
				dis="disabled";
			}
		}
			

%>
<body  class='CONTENT'  OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<BR>
   <form name="FlowSheetComp" id="FlowSheetComp" action="../../servlet/eCA.FlowSheetComponentServlet" method="post" target="messageFrame" >
   <br><br><br>

	   <%  if(mode.equals("modify")){%>

<table border=0 cellspacing=0 cellpadding=3 width='80%' align=center>
		   <tr>
		<td class='label' ><fmt:message key="eCA.FlowSheetID.label" bundle="${ca_labels}"/></td>
		<td class='fields'>
		<input type="text" name="id" id="id" size="10" value="<%=menu_id%>" maxlength="15"  <%=dis%> onkeypress="return CheckForSpecChars(event)"> <img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>
	
	<tr>
		<td class=label ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type="text" name="short_desc" id="short_desc" size="20" value="<%=s_desc%>" maxlength="20"
		<%=((enabled_checked.equals("checked"))?"":dis)%>
		onKeyPress='return CheckForSpeChar(event);'> &nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	
	<tr>
		<td class=label ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type="text" name="long_desc" id="long_desc" size="25" value="<%=l_desc%>" maxlength="30" 
		<%=((enabled_checked.equals("checked"))?"":dis)%>
		onKeyPress='return CheckForSpeChar(event);'> &nbsp;<img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>
	
	<tr>
		<td class=label ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="checkbox" name="eff_status" id="eff_status" value="E" <%=enabled_checked%> onBlur='func_assign()'>
		</td>
	</tr>
	
			</table>
			<%}else{%>
			
   <BR><BR><BR><BR><BR><BR><BR>
   <table border=0 cellspacing=0 cellpadding=3 width='75%' align=center>
  
	<tr>
		<td class=label ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type='radio' name='add_type' id='add_type' value='N' <%=rncheck%> onclick='Change_type(this)' ><fmt:message key="Common.New.label" bundle="${common_labels}"/>
		<input type='radio' name='add_type' id='add_type' value='C' <%=rccheck%>  onclick='Change_type(this)' ><fmt:message key="Common.CHARTING.label" bundle="${common_labels}"/></td></tr>
	
	   <%if(type.equalsIgnoreCase("N")){
		   %>
	<tr>
		<td class=label ><fmt:message key="eCA.FlowSheetID.label" bundle="${ca_labels}"/></td>
		<td class='fields'>
		<input type="text" name="id" id="id" size="10" value="<%=menu_id%>" maxlength="15"  <%=dis%> onkeypress="return CheckForSpecChars(event)"><img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>
	<tr>
		<td class=label ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type="text" name="short_desc" id="short_desc" size="20" value="<%=s_desc%>" maxlength="20"
		<%=((enabled_checked.equals("checked"))?"":dis)%>
		onKeyPress='return CheckForSpeChar(event);'> <img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	
	<tr>
		<td class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td align=left>
		<input type="text" name="long_desc" id="long_desc" size="25" value="<%=l_desc%>" maxlength="30" 
		<%=((enabled_checked.equals("checked"))?"":dis)%>
		onKeyPress='return CheckForSpeChar(event);'> <img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>
	
	<tr>
		<td class=label ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="checkbox" name="eff_status" id="eff_status" value="E" <%=enabled_checked%> onBlur='func_assign()'>
		</td>
	</tr>
	
			</table>
			<%}else{%>
			<tr>
			<td class='label' ><fmt:message key="eCA.FlowSheetID.label" bundle="${ca_labels}"/></td>
			<td class='fields'><input type ='text' name='id1' id='id1' size='1' maxlength='1'  value='$' readonly>
				<input type ='text' name='id' id='id' size='20' maxlength='20'  value='' onBlur ='getCharts(this)' ><input type ='Button' class='button' name='buttonChart' id='buttonChart' value='?' onClick ='getCharts(this)' >
				<img src='../../eCommon/images/mandatory.gif'></img>	
			</td>
		</tr>
				
	<tr>
		<td class=label ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type="text" name="short_desc" id="short_desc" size="20" value="" maxlength="20"
				onKeyPress='return CheckForSpeChar(event);'> &nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	
	<tr>
		<td class=label ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type="text" name="long_desc" id="long_desc" size="25" value="" maxlength="30" 
		onKeyPress='return CheckForSpeChar(event);'> &nbsp;<img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>
	<tr>
		<td class=label ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="checkbox" name="eff_status" id="eff_status" value="E" <%=enabled_checked%> onBlur='func_assign()'>
		</td>
	</tr>
	
			</table>
			<%}}%>
			

<input type=hidden name="flow_type" id="flow_type" value="<%=type%>">
<input type=hidden name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="short_desc1" id="short_desc1" value=""></input>
<input type="hidden" name="long_desc1" id="long_desc1" value=""></input>
<input type=hidden name="menu_id1" id="menu_id1" value="<%=menu_id%>"></input>
<input type=hidden name="status" id="status" value="<%=enabled_checked%>"></input>

</form>
<%
	} catch(Exception e){ 
			//out.println("Exception in FlowSheetComponent="+e.getMessage());//common-icn-0181
                           e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con);
	}
%>
</body>
</html>


