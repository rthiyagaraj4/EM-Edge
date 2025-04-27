<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210120             7339  	       	MOHE-CRF-0050		           Mohana Priya K
-->

<%@ page language="java" contentType="text/html;charset=UTF-8" 
	import="com.ehis.util.*, java.sql.*, java.util.*, java.net.*, java.text.*, eCommon.Common.*, org.json.simple.*, java.util.Map.Entry, java.util.Set, webbeans.eCommon.*, eBL.Common.*, eBL.*, eBL.resources.*, webbeans.op.CurrencyFormat, java.io.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser" />
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
					? (String) session.getAttribute("PREFERRED_STYLE")
					: "IeStyle.css";
%>
<%
	Connection con = null;
	CallableStatement cstmt = null;
	CallableStatement cstmt1 = null;
%>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link rel='stylesheet' type='text/css' href='../../eCommon/html/Tabs.css'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/CommonCalendar.js' language="javascript"></script>
<script language="javascript" src='../../eCommon/js/CommonLookup.js'></Script>
<script language="javascript" src='../js/dailycashTabFrame.js'></script>
<script type="text/javascript">	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String facilityId = (String) session.getValue("facility_id");
	String loginUser = (String) session.getValue("login_user");
	String localeLang = (String) session.getAttribute("LOCALE");
	String Called = request.getParameter("called") == null ? "" : request.getParameter("called");

	String servGpCode = request.getParameter("servGpCode") == null ? "" : request.getParameter("servGpCode");
	String servGpDesc = request.getParameter("servGpdesc") == null ? "" : request.getParameter("servGpdesc");

	if (!Called.equals("associate")) {
		Called = "createrptsergp";
	} else {
		Called = "Maintrptsergp";
	}
%>
<body onload="fnShowMainTabDetails('<%=Called%>')">
	<form name='Associate' id='Associate' method='post'>
		<center>
			<table cellpadding=2 cellspacing=0 border=0 width='100%' align="center">
				<tr width="10%">
					<td class='label' width="10%"><fmt:message key="eBL.SERVICE_GROUP.label"
							bundle="${bl_labels}" /></td>
					<td><input type="text" name='servGrpCode' id='servGrpCode' id='servGrpCode'
						value="<%=servGpCode%>" size="10" readonly='readonly'
						onfocus="this.blur()">&nbsp; <input type="text"
						name='servGrpDesc' id='servGrpDesc' id='servGrpDesc' value="<%=servGpDesc%>"
						size="50" readonly='readonly' onfocus="this.blur()">&nbsp;
					</td>
				</tr>
			</table>
			<br>
			<table cellpadding=2 cellspacing=0 border=0 width='100%'
				align="center">
				<tr width='100%'>
					<td width="100%" class="white">
						<ul id='tablist' class='tablist'>
							<li class="tablistitem"
								title='<fmt:message key="eBL.createReportingservgrp.label" bundle="${bl_labels}"/>'>
								<a onclick="fnShowMainTabDetails('createrptsergp')"
								class="tabClicked" id="createrptsergp"> <span
									class="tabSpanclicked" id="createrptsergpspan"> <fmt:message
											key="eBL.createReportingservgrp.label" bundle="${bl_labels}" />
								</span></a>
							</li>
							<li class="tablistitem"
								title='<fmt:message key="eBL.MaintReportingservgrp.label" bundle="${bl_labels}"/>'>
								<a onclick="fnShowMainTabDetails('Maintrptsergp')" class="tabA"
								id="Maintrptsergp"> <span class="tabAspan"
									id="Maintrptsergpspan"> <fmt:message
											key="eBL.MaintReportingservgrp.label" bundle="${bl_labels}" />
								</span></a>
							</li>
						</ul>
					</td>
				</tr>
			</table>
			<center>
<input type="hidden" name="locale" id="locale" id="locale" value="<%=localeLang%>"> 
<input type="hidden" name="FacilityId" id="FacilityId" id="FacilityId" value="<%=facilityId%>">
<input type="hidden" name="servGrpCode" id="servGrpCode" id="servGrpCode" value="<%=servGpCode%>">
<input type="hidden" name="servGrpDesc" id="servGrpDesc" id="servGrpDesc" value="<%=servGpDesc%>">
<input type="hidden" name="tempserviceVal" id="tempserviceVal" id="tempserviceVal" value="">
<input type="hidden" name="servcnt" id="servcnt" id="servcnt" value="">
<input type="hidden" name="rowval" id="rowval" id="rowval" value="">
</form>
</body>
</html>

