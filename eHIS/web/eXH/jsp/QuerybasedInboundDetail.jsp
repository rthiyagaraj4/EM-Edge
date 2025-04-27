<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% // String locale = ((String)session.getAttribute("LOCALE"));%>
<% 

/*
String application_id = "";
String dg_desc = "";
String selected = "selected";
String defaultval = "";					    
String def_appl_id = ""; 
*/
/*

String strBeanName    = QueryBasedInboundBean.strBeanName;
///System.out.println("QuerybasedInboundDetail strBeanName : "+strBeanName);

ArrayList modulenames = null;
ArrayList tablenames  = null;
ArrayList colnames    = null;

QueryBasedInboundBean	xhBean = (QueryBasedInboundBean)QueryBasedInboundBean.getBean(strBeanName,request,session);
session.setAttribute("strBeanName",xhBean);

*/

String mode		 = request.getParameter("mode");
String inb_typ	 = request.getParameter("inb_typ");
	//System.out.println("inb_type : "+inb_typ);
// String detail_flag=request.getParameter("detail_flag");

if(mode.equals("U"))
{ 
//	application_id=request.getParameter("application_id");
//	def_appl_id=request.getParameter("application_id");
//	dg_desc=request.getParameter("dg_desc");
}
/*
Connection con =null;
Statement stmt = null;
ResultSet rs   = null;
*/
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
<script language="javascript" src="../../eXH/js/QueryBasedInbound.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">

function enblAddDetails(){
//	alert(document.forms[0].inbound_api.value);
	var app_name = document.forms[0].application_name.value;
	var fac_name = document.forms[0].facility_name.value;
	var evnt_typ = document.forms[0].event_type.value;
	var seg_typ  = document.forms[0].segment_type.value;
	var inb_api  = document.forms[0].inbound_api.value;
	 
	if(app_name!=""&&fac_name!=""&&evnt_typ!=""&&seg_typ!=""&&inb_api!=''){
		document.forms[0].add_butt.disabled = false;
		document.forms[0].new_butt.disabled = true;
	}
}
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onload='getHeaderValues();' >

<form name="QuerybasedInboundDetail" id="QuerybasedInboundDetail" target='messageFrame' method='post' action=''>

<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
	<td width='20%'></td>	
</tr>


<tr>

<td class=label ><fmt:message key="eXH.ApplicationID.Label" bundle="${xh_labels}"/></td> 

<td class='fields'>
<select class='select' name='application_name' id='application_name' <%=mode.equals("U")?"readonly":""%> onchange='enblAddDetails();' >
            <option value=''>-------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>-------</option>
			

</select>

<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td>  </tr>

<tr>

<td class=label ><fmt:message key="eXH.FacilityId.Label" bundle="${xh_labels}"/></td> 

<td class='fields'>
<select class='select' name='facility_name' id='facility_name' <%=mode.equals("U")?"readonly":""%> onchange='enblAddDetails();'>
            <option value=''>-------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>-------</option>

            

</select>

<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td> </tr>

<tr>

<td class=label ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td> 

<td class='fields'>
<select class='select' name='event_type' id='event_type' <%=mode.equals("U")?"readonly":""%> onchange='enblAddDetails();' >
            <option value=''>-------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>-------</option>


</select>

<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td>  </tr>

<tr>

<td class=label ><fmt:message key="eXH.ExecId.Label" bundle="${xh_labels}"/></td> 

<td class='fields'>
<select class='select' name='segment_type' id='segment_type' <%=mode.equals("U")?"readonly":""%> onchange='enblAddDetails();' >
            <option value=''>-------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>-------</option>

            

</select>

<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td> </tr>

<tr>

<td class=label ><fmt:message key="eXH.InboundAPI.Label" bundle="${xh_labels}"/></td> 

<td class='fields'>
<select class='select' name='inbound_api' id='inbound_api' <%=mode.equals("U")?"readonly":""%> onchange='enblAddDetails();'>
            <option value=''>-------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>-------</option>

</select>

<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td> </tr>


<tr><td colspan=3 class='BUTTON'>
<input class='button' type="button"  name='new_butt' id='new_butt' value='New Data Group'
onClick='funNew()'>
<input class='button' type="button"  name='add_butt' id='add_butt' value='<fmt:message key="eXH.AddDetails.Label" bundle="${xh_labels}"/>'  disabled onClick='funAdd()'>
<input class='button' type="button"  name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='funSearch()'>
</td>
</tr>

<tr>
	<td width='40%'></td>
	<td width='60%'></td>
	<td width='20%'></td>
	
</tr>
</table>


<input type=hidden name=act_mode value='<%=mode%>'>
<input type=hidden name=inb_type value='<%=inb_typ%>'>


</form>

</BODY>
</HTML> 

