<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%

%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>


	<script language="JavaScript" src="../js/OrCommon.js"></script>

	<script language="JavaScript" src="../js/Template.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<form name="templateDiscreteMeasureForm" id="templateDiscreteMeasureForm">
		<table cellpadding="0" cellspacing="0" width="100%" align="center">
			<tr>
				<td align="right" width="39%" class="label">Discrete Measure &nbsp</td>
				<td align="left" width="61%">
				<input type=text name="templateDiscreteMeasure" id="templateDiscreteMeasure" value="" size=20 maxlength=20><input type=button class="button" name="templateDiscreteMeasureLookup" id="templateDiscreteMeasureLookup" value="?" onclick="">
				</td>
			</tr>
			<tr>
				<td>
					<br>
				</td>
				<td> </td>
			</tr>
		</table>
	</form>
</body>
</html>

