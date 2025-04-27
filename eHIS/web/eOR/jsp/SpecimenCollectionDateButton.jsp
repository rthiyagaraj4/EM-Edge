<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eOR/js/SpecimenOrder.js' ></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<!--<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
		 
	</head>
	<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<form name ='SpecimenCollectionBtn'>
		<table width='100%'cellpadding=3 cellspacing=0>
			<tr>
				<td class='button' align="right">
					<input type='button' class='button' id ='collectBtn' disabled value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onClick='closeDate();' name='ok' >
				</td>
			</tr>
		</table>
		<Script>
		/*Added by Uma on 1/5/2011 for IN025732*/
		if (parent.SpecimenCollectionDate.specimenDate)
		{
			parent.SpecimenCollectionDateButton.document.getElementById("collectBtn").disabled = false;
		}
		/*Ends Here*/
		</Script>
	</form>
	</body>
</html>

