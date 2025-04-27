<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/framework/html/Tag.text"%>
<%@taglib uri="/WEB-INF/tld/IBACustom-html.tld"  prefix="ibaCustom" %>
<SCRIPT  LANGUAGE="JavaScript" SRC="<%=request.getContextPath()%>/framework/js/selectbox.js"></SCRIPT>
<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
<script type="text/javascript">

function selectOrder()
{
var order=document.getElementById('vo.orderBySelected.itemArr');
for (var i=0; i<order.options.length; i++) 
	{
	 order.options[i].selected="selected";
	}
}
</script>
<ibaHTML:html locale="true">
<head>
<%
			//String locale=session.getAttribute("LOCALE");
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
			:"IeStyle.css" ;
			if(sStyle==null)sStyle="IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
</head>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<ibaCustom:masterCriteria/>
	</body>
	
<script type="text/javascript">
	if(document.getElementById('vo.orderByOriginal.itemArr'))
	{
		if(document.getElementById('vo.orderByOriginal.itemArr').length > 0)
		{
			document.getElementById('vo.orderByOriginal.itemArr')[0].selected=true;
			moveSelectedOptions(document.getElementById('vo.orderByOriginal.itemArr'),document.getElementById('vo.orderBySelected.itemArr'));
		}
	}

</script>
</ibaHTML:html>


