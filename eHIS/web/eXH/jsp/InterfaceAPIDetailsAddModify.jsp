<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% // String locale = ((String)session.getAttribute("LOCALE"));	%>

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
<script language="javascript" src="../../eXH/js/InterfaceAPI.js" ></script> 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

<%



String api_code="";
String srl_no="";
String arg_id=""; 
String arg_name=""; 

String stnd_code="";
String stnd_desc="";
String sub_api="";

String mode			=	request.getParameter("mode");
//	System.out.println("mode : "+mode);
if(mode.equals("U"))
{
	srl_no=request.getParameter("srl_no");
	api_code	=   request.getParameter("api_code");
	arg_name	=	request.getParameter("arg_name");

	stnd_code	=   request.getParameter("stnd_code");
	stnd_desc	=   request.getParameter("stnd_desc");
	sub_api		=	request.getParameter("sub_api");
}

	arg_id		=	request.getParameter("arg_id");

%>

<form name="InterfaceAPIdetails_setup_form" id="InterfaceAPIdetails_setup_form" target='messageFrame' method='post' >
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='20%'></td>
	<td width='50%'></td>
	<td width='20%'></td>
	<td width='30%'></td>
</tr>

<tr>
	<td class=label ><fmt:message key="eXH.ArgID.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=arg_id size=25 maxlength=50 value='<%=XHDBAdapter.checkNull(arg_id)%>'  <%=mode.equals("U")?"readonly":""%> > <img src='../../eCommon/images/mandatory.gif' align=middle>
	</td>
	<td colspan=2> </td>
</tr>

<tr>
	<td class=label ><fmt:message key="eXH.ArgName.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=arg_name size=25 maxlength=90 value='<%=arg_name%>' > <img src='../../eCommon/images/mandatory.gif' align=middle></td>
	<td colspan=2> </td>
</tr>

<tr>
<td class=label ><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></td>
<td align=left>
	<input type="text" name="stnd_code" id="stnd_code" size=10 onBlur='searchStandardCode()'  value="<%=XHDBAdapter.checkNull(stnd_code)%>">
	<input type=text id="stnd_desc"  name =standard_desc size=40 value='<%=XHDBAdapter.checkNull(stnd_desc)%>'  > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=standard_code_search value='?'    onClick="searchStandardCode()">
	<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td></td> <td></td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.SubAPI.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="sub_api"  name =sub_api size=25 value='<%=XHDBAdapter.checkNull(sub_api)%>' ></td>
<td> </td> <td> </td>
</tr>

<tr>
<tr>
	<td width='20%'></td>
	<td width='50%'></td>
	<td width='20%'></td>
	<td width='30%'></td>
</tr>
</tr>
</table>
	
<input type="hidden" name="act_mode" id="act_mode" value='<%=mode%>'>
<input type="hidden" name="api_code" id="api_code" value='<%=api_code%>'> 
<input type="hidden" name="srl_no" id="srl_no" value='<%=srl_no%>'>


</form>
</BODY>
</HTML> 

