<!DOCTYPE html>
<%@ page import="java.sql.*,java.text.*, java.util.*,java.io.*, webbeans.eCommon.*,webbeans.op.CurrencyFormat,blopin.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String RemarksValue = request.getParameter("RemarksValue");
	if(RemarksValue == null || RemarksValue.equals("null"))
		RemarksValue = "";
		if(RemarksValue != null && RemarksValue.equals("")){
			RemarksValue=java.net.URLDecoder.decode(RemarksValue,"UTF-8");
		}

	String RemarksType	= request.getParameter("RemarksType");
	String  p_disb_col	=	"readonly";
	//Added by Ashwini on 26-Apr-2017 for ML-MMOH-CRF-0641
	String isDisplayAllRemarks = request.getParameter("isDisplayAllRemarks");
	String  encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	Connection con	= null;
	ResultSet rset  = null; 
	PreparedStatement pstmt	= null;
	ResultSet rset1  = null; 
	PreparedStatement pstmt1 = null;
	%>
<script>
function checkMaxLen(obj)
{
	 if (obj.value.length>200)
		{
			var error = getMessage("REMARKS_CANNOT_EXCEED");
			error = error.replace("$","Remarks");
			error = error.replace("#","200");
			alert(error)
			obj.focus();
		}
	
}
function doInit()
{
	var val 	= window.dialogArguments;
	val 		= ""+val+"";
	var index 	= -1;
	if ((val != '')||("undefined" != val))index = val.indexOf("^^^");
	if (index != -1)
	{
		document.getElementById("comments").value = val.substring(0,index);
		index += "^^^".length;
		var bool = val.substring(index,val.length);
		if (bool.toUpperCase() == 'TRUE')
		{
			document.getElementById("comments").readOnly = true;
		}
		document.getElementById("comments").focus();
	}else{
		if ("undefined" == val)document.getElementById("comments").value = '';
		else document.getElementById("comments").value = val;
		document.getElementById("comments").focus();
	}
	if(document.getElementById("comments").value == "")
		document.getElementById("comments").value = "<%=RemarksValue%>";
}



function doClose(RemarksType)
{
	if (RemarksType=='I')
	{
		if (document.getElementById("comments").value.length > 200) {
			alert("APP-SM0045 - Remarks cannot exceed 200 characters");
			document.getElementById("comments").focus();
		}
		else {
			window.returnValue = document.getElementById("comments").value;
			//window.close();
			parent.document.getElementById('dialog_tag').close();
		}
	}
	else
	{
		//window.close();
		parent.document.getElementById('dialog_tag').close();
	}
}
//Added by Ashwini on 26-Apr-2017 for ML-MMOH-CRF-0641
function closeRemarks()
{
		window.close();
}
function closeWin()
{
	if(document.getElementById("comments").value.length > 0)
		window.returnValue = document.getElementById("comments").value;
	else
		window.returnValue ='';
		window.close();
}


</script>
<title><fmt:message key="Common.ViewDetails.label" bundle="${common_labels}"/></title>
<!--Added by Ashwini on 26-Apr-2017 for ML-MMOH-CRF-0641-->
<style>
	.container {
		width:480px;
	}
	.inner_table_site { 
		width:100%; 
		height: 250px;
		overflow-y: auto;
	}
</style>
</head>
<!--Added by Ashwini on 26-Apr-2017 for ML-MMOH-CRF-0641-->
<%	try
	{
		con	= ConnectionManager.getConnection(request);
		String regn_date_time =  eAE.AECommonBean.getDisasterRegnDate(con,encounter_id);
if(isDisplayAllRemarks.equals("false"))
{%>
<body  onload='doInit()'  onUnload ='closeWin()'>

<table width='100%' border='0' cellspacing='0' cellpadding='0' align=center>
	<tr>
		<td>&nbsp;&nbsp;</td>
	</tr>
	      <tr>
		  
			<td class='label' align='center' width='10%' ><center><b><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </b></center></td>
			
			</tr>
			<tr>
			<td class='label'>&nbsp;<textarea name='comments' id='comments' style="resize:none;"
			rows=5 cols=50  onblur='makeValidString(this);checkMaxLen(this);' <%=p_disb_col%>><%=RemarksValue%></textarea> </td>
		</tr>

	</table>
	<br>
	<center><input type='Button'   class='Button' name='Ok' id='Ok' value='   Ok    ' onclick='doClose("<%=RemarksType%>")'></center>
<%} else {%>
<!--Added by Ashwini on 26-Apr-2017 for ML-MMOH-CRF-0641-->
<body>
<div class="container">
<table  border="1" width="100%" cellpadding='3'  style='border-spacing:0px;border-collapse: collapse;'>
	<tr>
		<th class='columnheader' align = center nowrap width="25%" colspan='2' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
	</tr>
	<tr></tr>
</table>
<div class="inner_table_site">
<table  border="1" width="100%" cellpadding='3'  style='border-spacing:0px;border-collapse: collapse;'>
	<tr>
		<th class='columnheader' align = left nowrap width="25%" colspan='2'><fmt:message key="eAE.SecondaryTriage.label" bundle="${ae_labels}"/>&nbsp<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
	</tr>
	<tr></tr>
	<tr>
		<th style="width:20%" class="columnheader"><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></th>
		<th style="width:30%" class="columnheader"><fmt:message key="Common.remarks.label" bundle="${ip_labels}"/></th>
	</tr>
	<tr></tr>
	<%
		JSONArray secTriageJsonArr	= new JSONArray();
		secTriageJsonArr  = eAE.AECommonBean.getSecTriageRemarks(con,encounter_id);	
		for(int i = 0 ; i < secTriageJsonArr.size() ; i++) 
		{
		JSONObject json	= (JSONObject)secTriageJsonArr.get(i);
		String recorded_date  = (String) json.get("recorded_date");
		String remarks		  = (String) json.get("remarks");
		%>
		<tr>
			<td nowrap class='fields' ><%=recorded_date%>&nbsp;</td>
			<td class='fields' style='word-wrap: break-word;width:300px;'><%=remarks%>&nbsp;</td>
		</tr>	
		<%}%>
	<tr>
		<td width='100%' colspan='2'>&nbsp;&nbsp;</td>
	</tr>
	<tr>
		<td class='columnheader' align = left nowrap width="10%" colspan='2'><fmt:message key="eAE.DisasterPatientRegistration.label" bundle="${ae_labels}"/> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	</tr>
	<tr></tr>
	<tr>
		<th style="width:20%" class="columnheader"><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></th>
		<th style="width:30%" class="columnheader"><fmt:message key="Common.remarks.label" bundle="${ip_labels}"/></th>
	</tr>
	<% if(!(RemarksValue.equals(""))) {%>
	<tr>
		<td nowrap class='fields'><%=regn_date_time%></td>
		<td class='fields' style='word-wrap: break-word;width:300px;'><%=RemarksValue%></td>
	</tr>
	<%}%>
	<tr>
		<td width='100%' colspan='2'>&nbsp;&nbsp;</td>
	</tr>
</table>
</div>
</div>
<br>
	<center><input type='Button'   class='Button' name='Ok' id='Ok' value='   Ok    ' onclick='closeRemarks()'></center>
<%}%>
<%}catch(Exception e) 
	{ 
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	%>
<!--End ML-MMOH-CRF-0641-->
</body>
</html>

