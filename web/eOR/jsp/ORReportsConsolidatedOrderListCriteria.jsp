<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<HTML>
<HEAD>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/OrCommonFunction.js"></script>

	<script language="javascript" src="../js/ORReportsConsolidatedOrderList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<TR><TD colspan='4'>&nbsp;</TD></TR>
	<TR><TD>&nbsp;</TD><TD class='label' align='right'>Report</TD><TD align='left'>&nbsp;<SELECT name="report_type" id="report_type" onChange="repSelect(this)">
			<option value=''>&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;</Option>
			<Option value='O'>Outstanding Orders</Option>
			<Option value='N'>No. of Orders Placed for Department</Option>
			</Select>
			</TD><TD>&nbsp;</TD></TR>
	<TR><TD colspan='4'>&nbsp;</TD></TR>
</Table>
<%

%>
</BODY>
</HTML>

