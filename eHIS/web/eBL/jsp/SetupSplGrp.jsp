<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210118             7339  	       	MOHE-CRF-0050		           Mohana Priya K
2            V210216             14534 	       	MOHE-CRF-0050		           Mohana Priya K
-->
<%@ page language="java" contentType="text/html;charset=UTF-8" import ="com.ehis.util.*,java.sql.*,java.util.*,java.net.*,java.text.*, eCommon.Common.*,org.json.simple.*, java.util.Map.Entry,java.util.Set,webbeans.eCommon.*, eBL.Common.*,eBL.*,eBL.resources.*,webbeans.op.CurrencyFormat, java.io.*" %>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/> 

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
					? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/dailycashTabFrame.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<style>
/*
thead td, thead td.locked {
	background-color: navy;
	color: white;
	position: relative;
}

thead td {
	top: expression(document.getElementById ( "tbl-container") .scrollTop-4);
	z-index: 20;
}

thead td.locked {
	z-index: 30;
}

td.locked, th.locked {
	left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
	position: relative;
	z-index: 10;
}

td.locked, th.locked {
	left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
	position: relative;
	z-index: 10;
}   



thead td {
    display: block;
}

thead td {
  position: fixed;
  height: 10px;
}
	*/
#table-wrapper {
  position:relative;
}
#table-scroll {
  height:410px; 
  overflow:auto;  
  margin-top:20px;
}
#table-wrapper table {
  width:100%;
}
#table-wrapper table  {
  background:white;
  color:black;
}
#table-wrapper table thead tr {
  position:relative; 
  top: expression(offsetParent.scrollTop);
  z-index:2;
  height:20px;
  width:35%;
}	


</style>
<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1   
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0   
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server 
	String locale = "";
	String facilityId = "";
	String grpsave	=	"N";
	
	try {
		sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
				|| (session.getAttribute("PREFERRED_STYLE") != "")
						? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
		locale = (String) session.getAttribute("LOCALE");
		facilityId = (String) session.getValue("facility_id");
		//isUserCanAcess		= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));	
		HttpSession httpSession = request.getSession(false);

		Properties p = (Properties) httpSession.getValue("jdbc");
		String strLoggedUser = p.getProperty("login_user");
		if (strLoggedUser == null)
			strLoggedUser = "";
		System.err.println("user-->" + strLoggedUser);
%>
<body>
	<form name="BLrportserv" id="BLrportserv" id="BLrportserv"  action="../../servlet/eBL.BLDailyCashServlet" target="messageFrame" method='post'> 
		<center>
			<%
				String loginUser = (String) session.getValue("login_user");
				String localeLang = (String) session.getAttribute("LOCALE");
				int serSize = 0;
				String count = "";
				String exmcount = "";
				String disabled = "";
				String readonly = "";
				String onfocus = "";
				int totalrec=0;
			%>

			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="0"
							cellpadding="0" >
							<tr>
								<td>
									<div id="table-wrapper">
									<div id="table-scroll">
									  <table width='100%' align="center" cellpadding="4"
										cellspacing="0" class='grid' id="serviceTable1">
										<thead>
										<tr>
											<td class='COLUMNHEADER' align='center' width="5%">
												<fmt:message key="eBL.IRBSelect.label" bundle="${bl_labels}"/>
											</td>
											<td class='COLUMNHEADER' align='center' width="15%">
												<fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}"/>
											</td>
											<td class='COLUMNHEADER' align='center' >
												<fmt:message key="eBL.LongDesc.label" bundle="${bl_labels}"/>
											</td>
											<td class='COLUMNHEADER' align='center' >
												<fmt:message key="eBL.ShortDesc.label" bundle="${bl_labels}"/>
											</td>
											<td class='COLUMNHEADER'  align='center' width="15%">
												<fmt:message key="eBL.UsedForUndefItms.label" bundle="${bl_labels}"/>
											</td>
											<td class='COLUMNHEADER'  align='center' width="15%">
												<fmt:message key="eBL.UsedForExemptItms.label" bundle="${bl_labels}"/>
											</td>
										</tr>
										</thead>
										<tbody>
										<%
											String bean_id = "";
											String bean_name = "";
											String WS_NO = p.getProperty("client_ip_address");
											bean_id = "DailyCashDeliveryReport";
											bean_name = "eBL.DailyCashDeliveryReport";
											LinkedHashMap DailyCashReprt = null;
											DailyCashDeliveryReport DailyCashDeliveryReport = null;
											DailyCashReportBean DailyCashReportBean = new DailyCashReportBean();
											DailyCashReprt = new LinkedHashMap();
											DailyCashDeliveryReport = (DailyCashDeliveryReport) PersistenceHelper.getBeanObject(bean_id, bean_name,request);
											DailyCashDeliveryReport.clearBean();

											//To get USE_FOR_UNDEFINED_ITEM count
											Connection conn = null;
											PreparedStatement pstmt = null;
											ResultSet rs = null;

											try {
												String sql = "SELECT COUNT(*) FROM BL_REPORT_SERV_GROUP WHERE USE_FOR_UNDEFINED_ITEM='Y'";
												System.err.println("Query to Fetch  " + sql);
												conn = ConnectionManager.getConnection();
												pstmt = conn.prepareStatement(sql);
												rs = pstmt.executeQuery();
												System.err.println("After Execute Query count ");
												while (rs.next()) {
													count = checkForNull(rs.getString(1));
													System.err.println("countundef value obtained--" + checkForNull(rs.getString(1)));
													}
												} catch (Exception e) {
													System.err.println("Exception in getUndefCount=" + e);
													e.printStackTrace();
												} finally {
													System.err.println("Inside Finally");
													if (rs != null) {
														System.err.println("Result Set Not Empty-getUndefCount");
														rs.close();
													}
													if (pstmt != null)
														pstmt.close();
													ConnectionManager.returnConnection(conn);
												}
												//To get USE_FOR_UNDEFINED_ITEM count ends

												//To get Exempted_receipt_yn  count
												try {
													String sql = "SELECT COUNT(*) FROM BL_REPORT_SERV_GROUP WHERE EXEMPTED_RECEIPT_YN='Y'";
													System.err.println("Query to Fetch  " + sql);
													conn = ConnectionManager.getConnection();
													pstmt = conn.prepareStatement(sql);
													rs = pstmt.executeQuery();
													System.err.println("After Execute Query count ");
													while (rs.next()) {
														exmcount = checkForNull(rs.getString(1));
														System.err.println("exmcount value obtained--" + checkForNull(rs.getString(1)));
													}
												} catch (Exception e) {
													System.err.println("Exception in exmcount=" + e);
													e.printStackTrace();
												} finally {
													System.err.println("Inside Finally");
													if (rs != null) {
														System.err.println("Result Set Not Empty-exmcount");
														rs.close();
													}
													if (pstmt != null)
														pstmt.close();
													ConnectionManager.returnConnection(conn);
												}

												DailyCashDeliveryReport.getDBValues();//Loading DB Values from Temporary table to HasMap
												String KeyValue = "";
												int limit = 1;
												int extra = 0;
												int extraID = 0;
												DailyCashReprt = (LinkedHashMap) DailyCashDeliveryReport.getDailyCashSearchValues();

												serSize = DailyCashReprt.size();
												System.err.println("serSize From Bean  " + serSize);
												totalrec=serSize;
												if (serSize < 14) {
													extra = 14 - serSize;
													System.err.println("extra size  " + extra);
												}
												if (!DailyCashReprt.isEmpty()) {
													Iterator it = DailyCashReprt.entrySet().iterator();
													while (it.hasNext()) {
														Map.Entry obj = (Entry) it.next();
														DailyCashReportBean = (DailyCashReportBean) obj.getValue();
														KeyValue = (String) obj.getKey();
														if (DailyCashReportBean != null) {
															//Service Group Code
															String ServGroupCode = DailyCashReportBean.getServGroupCode();
															ServGroupCode = (ServGroupCode == null ? "" : ServGroupCode);
															ServGroupCode=ServGroupCode.toUpperCase(); //V210216
															System.err.println("ServGroupCode From Bean  " + ServGroupCode);

															//Long Desc
															String LongDesc = DailyCashReportBean.getLongDesc();
															LongDesc = (LongDesc == null ? "" : LongDesc);
															System.err.println("LongDesc From Bean  " + LongDesc);

															//Short Desc
															String ShortDesc = DailyCashReportBean.getShortDesc();
															ShortDesc = (ShortDesc == null ? "" : ShortDesc);
															System.err.println("ShortDesc From Bean  " + ShortDesc);

															//Used For Undefined Items
															String UsedForUndefinedItems = DailyCashReportBean.getUsedForUndefinedItems();
															UsedForUndefinedItems = (UsedForUndefinedItems == null ? "" : UsedForUndefinedItems);
															//UndefArr=UsedForUndefinedItems;
															
															if (UsedForUndefinedItems.equals("Y")) {
																UsedForUndefinedItems = "checked";
															} else {
																UsedForUndefinedItems = "unchecked";
															}
															System.err.println("UsedForUndefinedItems From Bean  " + UsedForUndefinedItems);

															//Used For Exempted Receipt
															String UsedForExemptedReceipt = DailyCashReportBean.getUsedForExemptedReceipt();
															UsedForExemptedReceipt = (UsedForExemptedReceipt == null ? "" : UsedForExemptedReceipt);
															System.err.println("UsedForExemptedReceipt From Bean  " + UsedForExemptedReceipt);
															
															if (UsedForExemptedReceipt.equals("Y")) {
																UsedForExemptedReceipt = "checked";
															} else {
																UsedForExemptedReceipt = "unchecked";
															}
															
										%>
											
											
										<tr id="serviceRow<%=limit%>">
											<td><input type="radio" name="select" id="select"
												onClick="selected_serv(this)" id="select<%=limit%>" value="" /></td>
											<td><input class="gridDataInputLess" type="text"
												maxlength="100" style="width:100%;" name="ServGroupCode<%=limit%>" id="ServGroupCode<%=limit%>"
												id="ServGroupCode<%=limit%>" value="<%=ServGroupCode%>" readonly></td>
											<td><input class="gridDataInputLess" type="text"
												maxlength="100" style="width:100%;" name="LongDesc<%=limit%>" id="LongDesc<%=limit%>"
												id="LongDesc<%=limit%>" value="<%=LongDesc%>" readonly></td>
											<td><input class="gridDataInputLess" type="text"
												maxlength="100" style="width:100%;" name="ShortDesc<%=limit%>" id="ShortDesc<%=limit%>"
												id="ShortDesc<%=limit%>" value="<%=ShortDesc%>" readonly></td>
											<td align='center'><input type="checkbox" align='center' onclick="return false;"
												name="checkboxundef<%=limit%>" id="checkboxundef<%=limit%>" <%=UsedForUndefinedItems%>
												id="checkboxundef<%=limit%>"
												value="<%=UsedForUndefinedItems%>" readonly onFocus="this.blur()"/>
											<td align='center'><input type="checkbox"  onclick="return false;"
												name="checkboxexempt<%=limit%>" id="checkboxexempt<%=limit%>" <%=UsedForExemptedReceipt%>
												id="checkboxexempt<%=limit%>"
												value="<%=UsedForExemptedReceipt%>" readonly/>
										</tr>
										<%
											}
														limit++;
													}
													if (extra > 0) {
														extraID = limit;
														for (int i = 0; i < extra; i++) {
															if (i == 0) {
																disabled = "";
																readonly = "";
																onfocus = "";
															} else {
																disabled = "disabled";
																readonly = "readonly";
																onfocus = "this.blur()";
															}
										%>
										<tr id="serviceRow<%=extraID%>" <%=disabled%>>
											<td id="selectbutton<%=extraID%>" <%=disabled%>>
											<input type="radio" name="select" id="select" onclick="selected_serv(this)" id="select<%=extraID%>" <%=readonly%> /></td>
											<td id="servgrpCodefld<%=extraID%>" <%=disabled%>>
											<input class="gridDataInputLess" type="text" maxlength="6" style="width:100%;"
												name="ServGroupCode<%=extraID%>" id="ServGroupCode<%=extraID%>" id="ServGroupCode<%=extraID%>" value="" onblur="ChangeUpperCase( this );enableNext(this);checkDuplicate(this);"  <%=onfocus%> <%=readonly%>></td><!--V210216-->
											<td id="longdescFld<%=extraID%>" <%=disabled%>>
												<input class="gridDataInputLess" type="text" maxlength="100" style="width:100%;" name="LongDesc<%=extraID%>" id="LongDesc<%=extraID%>" id="LongDesc<%=extraID%>"
												value="" onblur="shrtdesc(this);validdesc(this);enableNext(this)"
												<%=onfocus%> <%=readonly%>></td>
											<td id="shortDescfld<%=extraID%>" <%=disabled%>><input class="gridDataInputLess" type="text" maxlength="100" style="width:100%;"
												name="ShortDesc<%=extraID%>" id="ShortDesc<%=extraID%>" id="ShortDesc<%=extraID%>"
												value="" onblur="validdesc(this);enableNext(this);" <%=onfocus%>
												<%=readonly%>></td>
											<td id="checkboxundefFld<%=extraID%>" <%=disabled%>  align='center'><input type="checkbox" name="checkboxundef<%=extraID%>" id="checkboxundef<%=extraID%>" value="N"
												id="checkboxundef<%=extraID%>"
												onclick="checkUndefValid(this,'<%=count%>')" <%=onfocus%>
												<%=readonly%> /></td>
											<td id="checkboxexemptFld<%=extraID%>" <%=disabled%>  align='center'><input type="checkbox" name="checkboxexempt<%=extraID%>" id="checkboxexempt<%=extraID%>" value="N"
												id="checkboxexempt<%=extraID%>"
												onclick="checkExemValid(this,'<%=exmcount%>')" <%=onfocus%>
												<%=readonly%> /></td>
										</tr>
										<%
											extraID++;
														}
													}
												}
										%>
										 </tbody>
									</table>
									</div>
								</div>	
								</td>
							</tr>
							<tr>
								<td>
								<br>
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td align='RIGHT' width='10%'>
											<input type='button'
												class='BUTTON' value='Add'
												onclick="AddRow()">
											<input type='button' class='BUTTON' id="save"
												value='Save' onclick='saveGroupService()'>
											<input type='button'
												class='BUTTON' id='Associate' name='Associate' id='Associate' value='Associate Services/Items'
												onclick="AssocServ('associate')"></td>  
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</center>
		<input type="hidden" name="locale" id="locale" id="locale" value="<%=localeLang%>">
		<input type="hidden" name="FacilityId" id="FacilityId" id="FacilityId" value="<%=facilityId%>"> 
		<input type="hidden" name="servGrpCode" id="servGrpCode" id="servGrpCode" value=""> 
		<input type="hidden" name="servGrpDesc" id="servGrpDesc" id="servGrpDesc" value=""> 
		<input type="hidden" name="grpSize" id="grpSize" id="grpSize" value="<%=serSize%>">
		<input type="hidden" name="rowval" id="rowval" id="rowval" value=""> 
		<input type='hidden' name='user' id='user' id='user' value="<%=strLoggedUser%>">
		<input type="hidden" name="grpArrCode" id="grpArrCode" id="grpArrCode" value="">
		<input type="hidden" name="called" id="called" id="called" value="setupsplgrp">
		<input type="hidden" name="totrecords" id="totrecords" id="totrecords" value="<%=totalrec%>">  
		<input type="hidden" name="countval" id="countval" id="countval" value="">  
		<input type="hidden" name="exemcount" id="exemcount" id="exemcount" value="<%=exmcount%>">  
		<input type="hidden" name="undefcount" id="undefcount" id="undefcount" value="<%=count%>">  
		<input type="hidden" name="grpsave" id="grpsave" id="grpsave" value="<%=grpsave%>">
		<input type="hidden" name="modeType" id="modeType" id="modeType" value="setupSplGrp"> 
		<input type="hidden" name="WS_NO" id="WS_NO" id="WS_NO" value="<%=WS_NO%>">
		
	</form>
</body>
<%
	} catch (Exception e) {
		e.printStackTrace();
		System.err.println("Exception in Setup Spl Group JSP::" + e);
	}
%>
<%!private String checkForNull(String inputString) {
		return (inputString == null) ? "" : inputString;
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return (((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}%>
</html>

