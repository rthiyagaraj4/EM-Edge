<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF           		Developer Name
-----------------------------------------------------------------------------------------------
1            V210129            11086          MOHE-CRF-0050                Mohana Priya K
-->

<%@ page language="java" contentType="text/html;charset=UTF-8" import="com.ehis.util.*, java.sql.*, java.util.*, java.net.*,java.text.*, eCommon.Common.*, org.json.simple.*, java.util.Map.Entry, java.util.Set,webbeans.eCommon.*, eBL.Common.*,eBL.*, eBL.resources.*, webbeans.op.CurrencyFormat, java.io.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser" />

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
					? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script type="text/javascript" src="../../eBL/js/json2.js"></script>
	<script type="text/javascript" src="../../eBL/js/json.min.js"></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eBL/js/dailycashTabFrame.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>

function resetTable()
{
	document.getElementById('servfrm').value='';
	document.getElementById('servto').value='';
	document.getElementById("shrtdesc").value='N';
	document.getElementById('shortdes').value='';
	
	var length=0;
	var len=document.getElementById('servcount').value;
	if(len<8){
		length=8;
	}else{
		length=len;
	}
	var table = document.getElementById('servItemRows');
	var rowCount = table.rows.length;
	if(length!=0){
		for(var m=length;m>=1;m--){
		table.deleteRow(m);
		}
	}
	
	for(var i=0;i<8;i++){
		var row = table.insertRow(1);
		var newcell	= row.insertCell(0);
		newcell.innerHTML ="<td align='center' ><input type='text' style='width:100%;' name='servCode"+i+"' id='servCode"+i+"'  id='servCode"+i+"' style='width='100%';' value=''></td>";
		newcell.style.textAlign = "center";
		var newcell1	= row.insertCell(1);
		newcell1.innerHTML ="<td align='center' ><input type='text' style='width:100%;' name='servDesc"+i+"' id='servDesc"+i+"'  id='servDesc"+i+"' style='width='100%';' value=''></td>";
		newcell1.style.textAlign = "center";
		var newcell2	= row.insertCell(2);
		newcell2.innerHTML ="<td align='center' ><input type='checkbox'  name='servCheck"+i+"' id='servCheck"+i+"'  id='servCheck"+i+"' style='width='100%';' value='' onclick='selectserv(this)'></td>";
		newcell2.style.textAlign = "center";
	}
	document.getElementById('servcount').value='8';
}
	
	
</script>
<style>
/*thead td, thead td.locked {
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
}*/
	
#table-wrapper {
  position:relative;
}
#table-scroll {
  height:250px;
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
	//String isUserCanAcess = "";

	try{
		sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
				|| (session.getAttribute("PREFERRED_STYLE") != "")
						? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
		locale = (String) session.getAttribute("LOCALE");
		facilityId = (String) session.getValue("facility_id");
		//isUserCanAcess = (String) (session.getValue("isUserCanAcess") == null ? "Y"
			//	: (session.getValue("isUserCanAcess")));
		HttpSession httpSession = request.getSession(false);

		Properties p = (Properties) httpSession.getValue("jdbc");
		String strLoggedUser = p.getProperty("login_user");
		if (strLoggedUser == null)
			strLoggedUser = "";
%>
<body onload="">
	<form name='createrportserv' id='createrportserv' method='post'>
	<center>
	<%
		String loginUser = (String) session.getValue("login_user");
			String localeLang = (String) session.getAttribute("LOCALE");
			int serSize = 0;
			int limit = 1;
			int extraID = 0;
			int extra = 0;
			int size = 0;
			if (serSize < 6) {
				extra = 6 - serSize;
				System.err.println("extra size  " + extra);
			}
	%>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
					<td><table width="100%" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td><table width='100%' align="center" cellpadding="2"
										cellspacing="0">
										<tr>
											<td class="label" width="10%"><fmt:message
													key="eBL.ServiceType.label" bundle="${bl_labels}" /></td>
											<td><select name="ServiceType" id="ServiceType" id="ServiceType" onChange="resetTable();"  
												style="width: 210px;">
													<option value="S" selected>Billing Service</option>
													<option value="I">Material Item</option>
											</select></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td><table width="100%" border="0" cellspacing="0"
										cellpadding="0">
										<tr>
											<td colspan='2'><b>Search Criteria for Service
													Selection </b></td>
										</tr>
											<br>
									</table>
									</td>
							</tr>
							<tr>
								<td><table width='100%' align="center" cellpadding="4"
										cellspacing="0" class='grid'>
										<tr>
											<td class="label" width="10%"><fmt:message
													key="eBL.Service.label" bundle="${bl_labels}" /> <fmt:message
													key="Common.from.label" bundle="${common_labels}" /></td>
											<td><input type="text" name='servfrm' id='servfrm' id='servfrm'
												size="30" onblur="serviceFromTo(servfrmdes,servfrm)">&nbsp;
												<input type="hidden" name='servfrmdes' id='servfrmdes' id='servfrmdes'
												size="30">&nbsp; <input type="button"
												class="button" value='?' name="servfrmBtn" id="servfrmBtn" id="servfrmBtn"
												onClick="serviceFromTo(servfrmdes,servfrm)"></td>
											<td class="label" width='3%' align='right'><fmt:message
													key="Common.to.label" bundle="${common_labels}" /></td>
											<td><input type="text" name='servto' id='servto' id='servto'
												size="30" onblur="serviceFromTo(servtodesc,servto)">&nbsp;
												<input type="hidden" name='servtodesc' id='servtodesc' id='servtodesc'
												size="30">&nbsp; <input type="button"
												class="button" value='?' name="servtoBtn" id="servtoBtn" id="servtoBtn"
												onClick="serviceFromTo(servtodesc,servto)"></td>
										</tr>
										<tr>
											<td class="label" width="10%"><fmt:message
													key="eBL.ShortDesc.label" bundle="${bl_labels}" /></td>
											<td><select name="shrtdesc" id="shrtdesc" id="shrtdesc"
												onchange="shortDescChange(this)" style="width: 120px;">
													<option value="N" selected></option>
													<option value="S">Start With</option>
													<option value="C">Contains</option>
													<option value="E">Ends With</option>
											</select> <input type="text" name='shortdes' id='shortdes' id='shortdes' size="30"
												disabled>&nbsp;</td>
												<td></td>
											<td align='right'><input type='button' class='BUTTON'
												value='Display Services' onclick='cleardata();displayServices();'>
											</td>
										</tr>
									</table>
									</td>
							</tr>
							<tr>
								<td>
								<div id="table-wrapper">
								<div id="table-scroll">
									<table width='100%' align="center" id="servItemRows" name="servItemRows" id="servItemRows" class='grid'>
										<thead>
										<tr>
											<td class='COLUMNHEADER' align='center' width='10%'>Service Item Code</td>
											<td class='COLUMNHEADER' align='center' width='20%'>Service Description</td>
											<td class='COLUMNHEADER' align='center' width='5%'>Select All<input type='checkbox' name="selectall" id="selectall" id="selectall" onclick="selectallserv()"></td>
										</tr>
										</thead>
										 <tbody>
										<%int i=8;
										for(int j=0;j<i;j++){
											%>
										<tr>
											<td align="center" >	
												<input type="text" name='servcode' id='servcode' id='servcode' size="30" style="width:100%;" readonly>
											</td>
											<td align="center" >
												<input type="text" name='description' id='description' id='description' size="30" style="width:100%;" readonly>
											</td>
											<td align="center" >
												<input type='checkbox' name="select" id="select" id="select" onclick="" style="width:100%;" readonly>
											</td>
										</tr>
										
										<%
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
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td align='right'><input type='button' class='BUTTON'
												value='Associate Services' onclick='associateServices()'></td>
										</tr>
									</table>
								</td>
							</tr>
						</table></td>
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
<input type="hidden" name="called" id="called" id="called" value="createserv">
<input type='hidden' name='servcount' id='servcount' value=''>
<input type='hidden' name='selectidx' id='selectidx' value='N'>
</form>
</body>
<%
	} catch (Exception e) {
		e.printStackTrace();
		System.err.println("Exception in generatedaycolReport.jsp::" + e);
	}
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
</html>

