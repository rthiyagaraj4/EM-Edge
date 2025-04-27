<!DOCTYPE html>
<HTML> 
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/RearrangementLayer.js"></Script>
<script language='javascript' src='../../eXH/js/ElementSegmentConfiguaration.js'></script>
<script language="javascript">

function chkSystStr(){
//    parent.parent.DataGroupIdframeset.rows="30,100,300,30";

//	alert("act_mode : "+document.forms[0].act_mode.value);
	var mode = document.forms[0].act_mode.value;
	if(mode!='U'){
		document.forms[0].config_id.readOnly = true;
		document.forms[0].config_name.readOnly = true;
		document.forms[0].profile_id.readOnly = true;
		document.forms[0].profile_desc.readOnly = true;
		document.forms[0].query_text.readOnly = true;
		document.forms[0].SysDefStr.readOnly = true;
		document.forms[0].datasrc_type.disabled = true;
	}

	if(document.forms[0].SysDefStr.value!=""){
		funcNavigator();
	}
}

function clrFields(obj){
	document.forms[0].config_id.value = "";
	document.forms[0].config_name.value = "";
	document.forms[0].stnd_code.value = "";
	document.forms[0].stnd_desc.value = "";

    if(obj!=""){
		document.forms[0].config_id.readOnly = false;
		document.forms[0].config_name.readOnly = false;
	}

}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<BODY  leftmargin=0 topmargin=0  bgcolor='' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad='chkSystStr();'>
<%
String mode=request.getParameter("mode");
String config_type="";
String config_id = "";
String config_name="";
String query_text="";
String field_seperator="|";
String sysdef_str="";

String qryText="";
String datasrc_type = "";
String stnd_code= "";
String stnd_desc = "";
String profile_id= "";
String profile_desc= "";

//String language_id="";

config_name		=	XHDBAdapter.checkNull(request.getParameter("config_name"));
qryText         =   XHDBAdapter.checkNull(request.getParameter("qryText"));

if(mode.equals("U"))
{
	config_type=XHDBAdapter.checkNull(request.getParameter("config_type"));
		//System.out.println("Modf Mode config_type : "+config_type);
	config_id=XHDBAdapter.checkNull(request.getParameter("config_id"));
		//System.out.println("Modf Mode config_id : "+config_id);
	config_name=XHDBAdapter.checkNull(request.getParameter("config_name"));
		//System.out.println("Modf Mode config_name : "+config_name);
	query_text=XHDBAdapter.checkNull(request.getParameter("query_text"));
		//System.out.println("Modf Mode query_text : "+query_text);
	field_seperator=request.getParameter("field_seperator");
		//System.out.println("Modf Mode field_seperator : "+field_seperator);
	sysdef_str=XHDBAdapter.checkNull(request.getParameter("sysdef_str"));
		//System.out.println("Modf Mode sysdef_str : "+sysdef_str);
	datasrc_type=XHDBAdapter.checkNull(request.getParameter("datasrc_type"));
		//System.out.println("Modf Mode datasrc_type : "+datasrc_type);		
	stnd_code=XHDBAdapter.checkNull(request.getParameter("stnd_code"));
	stnd_desc=XHDBAdapter.checkNull(request.getParameter("stnd_desc"));

	profile_id=XHDBAdapter.checkNull(request.getParameter("profile_id"));
	profile_desc=XHDBAdapter.checkNull(request.getParameter("profile_desc"));
	//language_id=request.getParameter("lang_id");
}

%>
<form name="Element_Segment_Configuaration" id="Element_Segment_Configuaration" target='messageFrame' method='post' 				action='../../servlet/eXH.XHElementSegmentConfiguarationServlet'>


<table cellspacing=0 cellpadding=3 width='100%' align=center >

<tr>
	<td width='20%'></td>
	<td width='50%'></td>
	<td width='20%'></td>
	<td width='30%'></td>
</tr>

<tr>
	<td class=label><fmt:message key="eXH.ConfigType.Label" bundle="${xh_labels}"/></td>
	<td class='fields'>
		<select class='select' name='config_type' id='config_type'  onchange='clrFields(this);'>
		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
		<option value='S' <%=config_type.equals("S")?"selected":""%> ><fmt:message key="eXH.Segment.Label" bundle="${xh_labels}"/></option>
		<option value='F' <%=config_type.equals("F")?"selected":""%> ><fmt:message key="Common.Field.label" bundle="${common_labels}"/></option>
	</select>	<img src='../../eCommon/images/mandatory.gif' align=middle>
	<td> </td> <td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.ConfigName.Label" bundle="${xh_labels}"/></td>
<td class='fields'>
<input type=text id="config_id"  name =config_id value='<%=XHDBAdapter.checkNull(config_id)%>' size=10 onBlur="searchSegmentField();">
<input type=text id="config_name"  name =config_name value='<%=config_name%>' size=40 > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=SgmntFldSearch value='?'    onClick="searchSegmentField();" > <img src='../../eCommon/images/mandatory.gif' align=middle>
</td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></td>
<td class='fields'>
<input type=text id="stnd_code"  name =stnd_code  readOnly value='<%=XHDBAdapter.checkNull(stnd_code)%>' size=10 >
<input type=text id="stnd_desc"  name =stnd_desc readOnly value='<%=XHDBAdapter.checkNull(stnd_desc)%>' size=40 >
</td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="Common.Profile.label" bundle="${common_labels}"/></td>
<td align=left>
<input type=text id="profile_id"  name =profile_id value='<%=XHDBAdapter.checkNull(profile_id)%>' size=10 onBlur="searchProfile();">
<input type=text id="profile_desc"  name =profile_desc value='<%=profile_desc%>' size=40 > <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ProfileSearch value='?'    onClick="searchProfile();" > <img src='../../eCommon/images/mandatory.gif' align=middle>
</td>
<td> </td><td> </td>
</tr>

<tr>
	<td class=label><fmt:message key="eXH.DataSourceType.Label" bundle="${xh_labels}"/></td>
	<td class='fields'>
		<select class='select' name=datasrc_type onChange='dsblQuery(this);' >
			<option value='Q' <%=datasrc_type.equals("Q")?"selected":""%> ><fmt:message key="Common.query.label" bundle="${common_labels}"/> </option> 
			<option value='P' <%=datasrc_type.equals("P")?"selected":""%> ><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/> </option> 
		</select> <img src='../../eCommon/images/mandatory.gif' align=middle>
	</td> 
	<td> </td> <td> </td>

</tr>

<tr>
	<td class=label><fmt:message key="eXH.QueryText.Label" bundle="${xh_labels}"/></td>
	<td colspan=1>
		<textarea name="query_text" rows=5 cols=60 onBlur='buildSystDefStr1();'><%=query_text%></textarea>
		<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button" name="query" id="query" value='?' 
		onClick="showQueryInfo();"> <img src='../../eCommon/images/mandatory.gif' align=middle>
	</td>
	
	<!--
	<td class='BUTTON'>
		<input class='button' type="button"  name='Validate' id='Validate' value='<fmt:message key="eXH.Validate.Label" bundle="${xh_labels}"/>' disabled onclick='validateQry();' >
	</td>
	-->
	<td> </td> 	<td> </td>
</tr>

<tr>
	<td class=label><fmt:message key="eXH.SysDefStr.Label" bundle="${xh_labels}"/></td>
	<td>
		<textarea name=SysDefStr rows=5 cols=60 onBlur='funcNavigator();'><%=sysdef_str%></textarea>	
	</td>
	<td> </td> <td> </td>
</tr>

<tr>
	<td width='20%'></td>
	<td width='50%'></td>
	<td width='20%'></td>
	<td width='30%'></td>
</tr>

</table>
<input type=hidden name=act_mode value='<%=mode%>'>
<input type=hidden name=qryText value='<%=qryText%>'>

</form>
</body>
</html>	



