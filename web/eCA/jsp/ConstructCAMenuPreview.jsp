<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>

<title><fmt:message key="Common.Preview.label" bundle="${common_labels}"/></title>
	<head>
<!-- 		<link rel="stylesheet" type="text/css" href="../../eCA/html/CAMainMenu.css">
 -->		
 	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

 
	
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCA/js/ConstructCAMenu.js" language="javascript"></script>
	</head>

 <%
	String menuid = request.getParameter("menuid");
	if(menuid == null || menuid == "")
	menuid="MENU";
%>
 	<div class='dtree'>
<body class='CA_COMMON'  OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()' >
	<form name="frmpreveiw" id="frmpreveiw">

	<TABLE width='100%' align='center' cellpadding=3 >
		<TR>
			<td class='fields'><input type='button' onclick="changeTree(this)" value='<fmt:message key="eCA.CollapseAll.label" bundle="${ca_labels}"/>' class='BUTTON' name='toggleTree'></input></td>
		</TR>
	</TABLE>
	<br>

	<script type='text/javascript'>
		var obj;	
		obj = new dTree('obj');
		obj.config.useStatusText=true;

		var menuid = "<%=menuid%>";
		obj.config.useStatusText=true;
		obj.add(0,-1,'<font size=2 style=font-weight:bold style=color:#333>'+menuid+'</font>');

		var arrValues	=	new Array();
		arrValues		=	parent.window.dialogArguments;

		for(i=0;i<arrValues.length;i++)
		{
			var splitValues = arrValues[i].split("#");
			obj.add(splitValues[1],splitValues[2],splitValues[0],'','','','','','');
			//obj.add(splitValues[1],splitValues[2],splitValues[0]);

		}
		document.write(obj);
		obj.openAll();
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
		<input type="hidden" name="menuid" id="menuid" value="<%=menuid%>"></input>
	</form>
</body>
</div>
</html>

