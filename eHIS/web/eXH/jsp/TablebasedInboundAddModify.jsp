<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript"  src="../../eXH/js/QueryBasedInbound.js" ></script>
<script language='javascript' src='../../eXH/js/APIBasedInbound.js'></script> 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>

<script Language="JavaScript" >
//function record
function record(val)
{
	this.document.forms[0].actualmode.value = val;
	this.document.forms[0].submit();
		
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<%

String strBeanName    = QueryBasedInboundBean.strBeanName;
	//System.out.println("QueryBasedInsertUpdateQueryInfo strBeanName : "+strBeanName);


ArrayList modulenames = null;

QueryBasedInboundBean	xhBean = (QueryBasedInboundBean)QueryBasedInboundBean.getBean(strBeanName,request,session);
session.setAttribute("strBeanName",xhBean);


String application_id=""; 
String facility_id=""; 
String event_type_id=""; 
String segment_type_id="";
String inboundapi_id=""; 

// String executionOrder=""; 
String srl_no="";

String optnVal="";
String tablename="";

String stnd_code="";
String stnd_desc="";
String sub_api="";

String mod_name = "";
String modl_name = "";
String selected = "";

String mode			=	request.getParameter("mode");

if(mode.equals("U"))
{
	srl_no=request.getParameter("srl_no");
		//System.out.println("TblBsdInbExec Ordr : "+srl_no);
	tablename=request.getParameter("table_name");
	stnd_code=request.getParameter("stnd_code");
	stnd_desc=request.getParameter("stnd_desc");
	sub_api=request.getParameter("sub_api");
	modl_name = request.getParameter("modl_name");
		//System.out.println("TblBsdInbExec modl_name : "+modl_name);
}

%>
<form name="TableBasedInbAddMod" id="TableBasedInbAddMod" target='messageFrame' method="POST" >

<%
	application_id = request.getParameter("application_id");
		//System.out.println("QrybsdAddmdfy application_id : "+application_id);
	facility_id = request.getParameter("facility_id");
	event_type_id = request.getParameter("event_type_id");
	segment_type_id = request.getParameter("segment_type_id");
	inboundapi_id = request.getParameter("inboundapi_id");
%>

<table cellspacing=0 cellpadding=3 width='101%' align=center>
<tr>
	<td width='20%'></td>
	<td width='50%'></td>
	<td width='20%'></td>
	<td width='40%'></td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.SubAPI.Label" bundle="${xh_labels}"/></td>
<td align=left>
	<input type=text id="sub_api"  name =sub_api value='<%=XHDBAdapter.checkNull(sub_api)%>' size=25 >
</td>
<td> </td><td> </td>
</tr>

	<tr>
		<td class=label><fmt:message key="eXH.Domain.Label" bundle="${xh_labels}"/></td>
		<td colspan=3 class='fields' >
			<SELECT name="module_name" id="module_name" onChange='setValues(this);'  >
			<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>

			<% 

			modulenames = (ArrayList)xhBean.getModules();
			for (int j=0; j<modulenames.size();j++){
				mod_name = (String)modulenames.get(j);
//					//System.out.println("115 modl_name "+modl_name);
				if(modl_name != null && modl_name.equalsIgnoreCase(mod_name))				
					selected = "selected";
				else
					selected = ""; 	
			%>

			<option value="<%=mod_name%>" <%= selected %> > <%=mod_name%> </option>
			<%}%>
			</SELECT>
			<img src='../../eCommon/images/mandatory.gif' align=middle>
		</td>
	</tr>

	<tr>
		<td class=label><fmt:message key="eXH.Entity.Label" bundle="${xh_labels}"/></td>
		<td colspan=3 class='fields' >
			<SELECT name="table_name" id="table_name" >
			<%

				if(tablename != ""){
			//		System.out.println("TblBsdAddMdfy tablename "+tablename);
					optnVal = tablename;
				}
				else{
					optnVal = 	"----------Select--------";
				}

			%>
				<option value='<%=optnVal%>'> <%=optnVal%>
			</option>
			</SELECT>
			<img src='../../eCommon/images/mandatory.gif' align=middle>
		</td>

<!--
<tr>
<td class=label ><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></td>
<td align=left>
<input type=text id="stnd_code"  name =stnd_code value='<%=XHDBAdapter.checkNull(stnd_code)%>' size=10 onBlur="searchStandard();">
<input type=text id="stnd_desc"  name =stnd_desc value='<%=stnd_desc%>' size=40 > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=StandardSearch value='?'    onClick="searchStandard();" >
<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td><td> </td>
</tr>
-->

</table>

<table cellspacing=0 cellpadding=3 width='101%' border=0 align=center id='insertoper' style='display:none'>
<tr>
<td class="BUTTON"><input class='button' type='button'  name='Record' id='Record' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="record('I')">
<input class='button' type='button'  name='Cancel' id='Cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="cancel()"></td>
</tr>
<tr>
<td >
</td>
</tr>
</table>
<table cellspacing=0 cellpadding=3 width='100%' align=center id='modifyoper' style='display:none'>
<tr>
<td colspan=8 align=right ><input class='button' type='button'  name='modify' id='modify' value='<fmt:message key="Common.Modify.label" bundle="${common_labels}"/>' onClick="record('U')"></td>
</tr>
<tr>
<td >
</td>
</tr>
</table>

<%
	if(modulenames!=null) modulenames.clear();
%>
<input type="hidden" name="act_mode" id="act_mode" value='<%=mode%>'>
<input type='hidden' name='actualmode' id='actualmode' value=''>	
<input type='hidden' name='rowid' id='rowid' value=''>
<input type='hidden' name='application_id' id='application_id' value='<%=application_id%>' >
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >
<input type='hidden' name='event_type_id' id='event_type_id' value='<%=event_type_id%>' >
<input type='hidden' name='segment_type_id' id='segment_type_id' value='<%=segment_type_id%>' >
<input type='hidden' name='inboundapi_id' id='inboundapi_id' value='<%=inboundapi_id%>' >

<input type="hidden" name="strBeanName" id="strBeanName" value='<%=strBeanName%>'>
<input type="hidden" name="srl_no" id="srl_no" value='<%=srl_no%>'>


</form>
</body>
</html>


