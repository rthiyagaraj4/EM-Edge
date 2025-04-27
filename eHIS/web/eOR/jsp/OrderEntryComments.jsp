<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
    request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<Style> </Style>
<script>
// On load it is called to put the default value .....Violated.
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
		if ("undefined" == val) document.getElementById("comments").value = '';
		else document.getElementById("comments").value = val;
		document.getElementById("comments").focus();
	}

}

function doClose()
{
	var comments_value = document.getElementById("comments").value
	if(comments_value.length > 499)
		comments_value = comments_value.substring(0,499);
	window.returnValue = comments_value;
	window.close();
}

function closeWin()
{
	if(document.getElementById("comments").value.length > 0)
	{
		var comments_value = document.getElementById("comments").value
		if(comments_value.length > 499)
			comments_value = comments_value.substring(0,499);
			window.returnValue = comments_value;
	}
	else	window.returnValue ='';
	window.close();
}

</script>
<%
	String hdg_name 	= request.getParameter("hdg_name");
	String read_only 	= "";
	if(hdg_name.equalsIgnoreCase("PATINSTRN") || hdg_name.equalsIgnoreCase("CONSENT"))
		read_only		= "READONLY";
	String slClassName = "";
	if (hdg_name.equals("")) {
		slClassName = "COMMENTS";
		read_only		= "READONLY";
	}
%>
<title>
<% 	if(hdg_name.equalsIgnoreCase("CLINICAL"))  { %>
		<fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/>
<%	} else if(hdg_name.equalsIgnoreCase("LINE"))  { %>
		<fmt:message key="eOR.CatalogComments.label" bundle="${or_labels}"/>
<%	} else if(hdg_name.equalsIgnoreCase("PREPS"))  { %>
		<fmt:message key="eOR.Preps.label" bundle="${or_labels}"/>
<%	} else if(hdg_name.equalsIgnoreCase("PATINSTRN"))  { %>
		<fmt:message key="Common.PatientInstruction.label" bundle="${common_labels}"/>
<%	} else if(hdg_name.equalsIgnoreCase("DEPTINSTRN"))  { %>
		<fmt:message key="eOR.DepartmentInstruction.label" bundle="${or_labels}"/>
<%	} else if(hdg_name.equalsIgnoreCase("CONSENT"))  { %>
		<fmt:message key="Common.Consent.label" bundle="${common_labels}"/>
<% 	} else { %>
		<fmt:message key="Common.Comments.label" bundle="${common_labels}"/>
<%	}        %>
</title>
</head>
<body onload="doInit()" onUnload ="closeWin()"  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()" style="background-color:#E2E3F0;">


<table width="100%" border="0" cellspacing="0" cellpadding="3" align=center>
	<tr>
		<td  class="label" width="10%"></td>
	</tr>
	<tr>
		<td width="90%" class="label"><textarea id="comments" name="comments" rows="5" class='<%=slClassName%>'cols="60" <%=read_only%> onBlur="makeValidString(this);" <% if(!hdg_name.equalsIgnoreCase("CLINICAL")) { %> onkeyPress='return checkMaxLimit(this,500)' <% } %>></textarea></td>
	</tr>

	<tr><td colspan="2" align=right><input type="Button" class="Button" name="Ok" id="Ok" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onclick="doClose()"></td></tr>
	</table>
</body>
</html>

