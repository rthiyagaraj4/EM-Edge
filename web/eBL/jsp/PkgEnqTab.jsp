<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>

<%
String packageCode		= request.getParameter("packageCode")== null ? "": request.getParameter("packageCode");	
String packageSeqNo		= request.getParameter("packageSeqNo")== null ? "": request.getParameter("packageSeqNo");	
String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src='../js/PkgEnq.js'></script> 

	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>	
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="frmPkgEnqTab" id="frmPkgEnqTab">

<table cellpadding=3 cellspacing=0 border=0 width='100%' align="center">
<tr width='100%'>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist' style="padding: 0px;">
			<li class="tablistitem" title='Package Services(Rate Based)'>
				<a onclick="showTabDetail('RATE_BASED','<%=packageCode%>','<%=packageSeqNo%>')" class="tabA" id="RATE_BASED">
					<span class="tabAspan" id="RATE_BASEDspan">
						<!-- <fmt:message key="eBL.PackageRateBaseHdr.Label" bundle="${bl_labels}"/> -->
						Package Services(Rate Based)
						</span></a>
			</li>

			<li class="tablistitem" title='Package Services(Charge Based)'>
				<a onclick="showTabDetail('CHARGE_BASED','<%=packageCode%>','<%=packageSeqNo%>')" class="tabA" id="CHARGE_BASED">
					<span class="tabAspan" id="CHARGE_BASEDspan">
						<!-- <fmt:message key="eBL.PackageChargeBaseHdr.Label" bundle="${bl_labels}"/> -->
						Package Services(Charge Based)
						</span></a>
			</li>
			
		</ul>
	</td>	
	</tr>
</table>
<input type='hidden' name='prevTabObj' id='prevTabObj' value="" />
<input type='hidden' name='fromDate' id='fromDate' value="" />
</form>
</body>
</html>

