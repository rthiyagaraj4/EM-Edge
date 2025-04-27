<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<HTML> 
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*,eXB.*,eXB.XBDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% //String locale = ((String)session.getAttribute("LOCALE"));%>
<% 

String payer_group_code = "";
String payer_group_desc = "";
String payer_code  = "";
String payer_desc   = "";
String policy_code  = "";
String policy_desc  = "";
String episode_type = "";
String enableYN  = "";
String facility_Id	= "";
String facility_Name = "";

String mode=XBDBAdapter.checkNull(request.getParameter("mode"));				
	System.out.println("XBMasterSetUpSelect.jsp mode :"+mode);
String fun_id=XBDBAdapter.checkNull((String)session.getAttribute("fun_id"));  

String module_Id = "";
String module_Name = "";

if(mode.equals("U"))
{
	module_Id=XBDBAdapter.checkNull(request.getParameter("module_Id"));
	module_Name=XBDBAdapter.checkNull(request.getParameter("module_Name"));
	payer_group_code=XBDBAdapter.checkNull(request.getParameter("payer_group_code"));
	payer_group_desc=XBDBAdapter.checkNull(request.getParameter("payer_group_desc"));
	payer_code=XBDBAdapter.checkNull(request.getParameter("payer_code"));
	payer_desc=XBDBAdapter.checkNull(request.getParameter("payer_desc"));
	policy_code=XBDBAdapter.checkNull(request.getParameter("policy_code"));
	policy_desc=XBDBAdapter.checkNull(request.getParameter("policy_desc"));
	episode_type=XBDBAdapter.checkNull(request.getParameter("episode_type"));
//	System.out.println("episode_type : "+episode_type);
	enableYN=XBDBAdapter.checkNull(request.getParameter("enabled_yn"));
	if(enableYN.equalsIgnoreCase("Y")){
		enableYN = "checked";
	}
	else{ 
		enableYN = "";
	}
	facility_Id=XBDBAdapter.checkNull(request.getParameter("facility_Id"));
		System.out.println("facility_Id : "+facility_Id);
	facility_Name=XBDBAdapter.checkNull(request.getParameter("facility_Name"));
		System.out.println("facility_Name : "+facility_Name);
}
if(mode.equals("I"))
{
	enableYN = "checked";
}

Connection con=null;
Statement stmt = null;
ResultSet rs  = null;

%>
<HEAD>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eXB/js/XBMasterSetUp.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


 			  
  
<script>
/*	function chkVal(obj){
		if(obj.checked==true){
//			alert("checked");
			this.document.forms[0].enabled_yn.value = 'Y';
		}else{
//			alert("Unchecked");
			this.document.forms[0].enabled_yn.value = 'N';
		}
	}		*/						   
</script>
</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'  >
<!-- onLoad='formLoad()' -->
<form name="Mastersetup_form" id="Mastersetup_form" target='messageFrame' method='post' action='../../servlet/eXB.MasterSetUpAddModifyServlet'>

<table cellspacing=0 cellpadding=3 width='100%' align=center>
<input type="hidden" name="fun_id" id="fun_id" id="fun_id" value="<%=fun_id%>">
<tr>																		   
	<td width='20%'></td>
	<td width='45%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr> 												 

<tr>
	<td class=label >Facility</td>
	<td align=left>
		<input type="hidden" name="facility_Id" id="facility_Id"  value="<%=XBDBAdapter.checkNull(facility_Id)%>">
		<input type=text id="facility_Name"  name =facility_Name size=35 maxlength=30 value='<%=XBDBAdapter.checkNull(facility_Name)%>' onBlur='searchFacility();' title='Facility Type' <%=mode.equals("U")?"disabled":""%>> <input  type="button"  name=faclityNameSearch value='?'    onClick='searchFacility();'>
		<img src='../../eCommon/images/mandatory.gif' align=middle>
	</td>
	<td> </td> <td> </td>
</tr>

<tr>
	<td class=label >Module Type</td>
	<td align=left>
		<input type="hidden" name="module_Id" id="module_Id"  value="<%=XBDBAdapter.checkNull(module_Id)%>">
		<input type=text id="module_Name"  name =module_Name size=35 maxlength=30 value='<%=XBDBAdapter.checkNull(module_Name)%>' onBlur='searchModuleType();' title='Module Type'> <input  type="button"  name=moduleNameSearch value='?'    onClick='searchModuleType();'>
		<img src='../../eCommon/images/mandatory.gif' align=middle>
	</td>
	<td> </td> <td> </td>
</tr>

<tr>
<td class=label >Payer Group</td>
<td align=left>
	<input type="hidden" name="payer_group_code" id="payer_group_code"  value="<%=XBDBAdapter.checkNull(payer_group_code)%>">
	<input type=text id="payer_group_desc"  name =payer_group_desc size=35  value='<%=XBDBAdapter.checkNull(payer_group_desc)%>' onBlur='searchPayerGroup();' title='Payer Group' <%=mode.equals("U")?"disabled":""%> > <input  type="button"  name=payerGroupSearch value='?'    onClick='searchPayerGroup();' <%=mode.equals("U")?"disabled":""%> >
	<img src='../../eCommon/images/mandatory.gif' align=middle>
</td>
	<td> </td> <td> </td>
</tr>

<tr>
<td class='label' >Payer</td>
<td align=left>
	<input type="hidden" name="payer_code" id="payer_code"  value="<%=XBDBAdapter.checkNull(payer_code)%>">
	<input type=text id="payer_desc"  name =payer_desc size=35  value='<%=XBDBAdapter.checkNull(payer_desc)%>' onBlur='searchPayer();' title='Payer' <%=mode.equals("U")?"disabled":""%> > <input  type="button"  name=payerSearch value='?'    onClick='searchPayer();' <%=mode.equals("U")?"disabled":""%> >
	<img src='../../eCommon/images/mandatory.gif' align=middle>
</td>
  	<td></td> <td></td> 
</tr> 		

<tr>
<td class=label >Policy</td>
<td align=left>
	<input type="hidden" name="policy_code" id="policy_code"  value="<%=XBDBAdapter.checkNull(policy_code)%>">
	<input type=text id="policy_desc"  name =policy_desc size=35  value='<%=XBDBAdapter.checkNull(policy_desc)%>' onBlur='searchPolicy();' title='Policy Type' <%=mode.equals("U")?"disabled":""%> > <input  type="button"  name=policySearch value='?'    onClick='searchPolicy();' <%=mode.equals("U")?"disabled":""%> >
	<img src='../../eCommon/images/mandatory.gif' align=middle>
</td>
<td></td> <td></td>
</tr> 

<tr>
<td class=label >Episode Type</td>
 <td align=left>
	<select name="episode_type" id="episode_type"  style="width:100"  title='Episode Type' <%=mode.equals("U")?"disabled":""%> >
	  <option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
      <option value='I' <%=episode_type.equals("I")?"selected":""%>><fmt:message key="Common.inpatient.label"  bundle="${common_labels}"/></option>
      <option value='O' <%=episode_type.equals("O")?"selected":""%>><fmt:message key="Common.Outpatient.label"  bundle="${common_labels}"/></option>
	</select> <img src='../../eCommon/images/mandatory.gif' align=middle>
  </td>  
<td> </td><td> </td>
</tr>								

<tr>
	<td class=label>Enabled</td>
	<td align=left><INPUT TYPE="checkbox" name="enabled_yn" id="enabled_yn" <%=enableYN%> > </td> <!-- onClick='chkVal(this);'  -->
	<td></td> <td></td> 
</tr>

<tr>
	<td width='20%'></td>
	<td width='45%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>
</table> 
<%
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
%>

<input type=hidden name=act_mode value='<%=mode%>'>

</form>									  
<script>

</script>
</BODY> 
</HTML> 						  

