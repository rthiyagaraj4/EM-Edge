<!DOCTYPE html>
<!-- 
Sr No              Version                Incident              SCF/CRF                        Developer Name
1                  V201218                IN73702            MMS-DM-CRF-0100.1         			Palani Narayanan
2                  V210228                 15239             MMS-DM-CRF-0100.1         			Ram kumar S
3				   V211020																		Mohanapriya K
-->

<%@ page import="java.sql.*,java.util.*,java.text.SimpleDateFormat,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*, eBL.RecordApprovalPatientDataBean "
	contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
					? (String) session.getAttribute("PREFERRED_STYLE")
					: "IeStyle.css";
%>

<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eBL/js/json2.js'></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/BillingInterimBillScript.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
var ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL	=	"<%=BlRepository.getBlKeyValue("ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL")%>";
var PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL	=	"<%=BlRepository.getBlKeyValue("PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL")%>";	
var PAYER_LOOKUP_RECORD_PREAPPROVAL			=	"<%=BlRepository.getBlKeyValue("PAYER_LOOKUP_RECORD_PREAPPROVAL")%>";	
var POLICY_LOOKUP_RECORD_PREAPPROVAL		=	"<%=BlRepository.getBlKeyValue("POLICY_LOOKUP_RECORD_PREAPPROVAL")%>";
	var headTop = -1;
	var FloatHead1;
	var arrPageURL;
	var myArray = new Array();
	function processScroll() {
		if (headTop < 0) {
			saveHeadPos();
		}
		if (headTop > 0) {
			if (document.documentElement && document.documentElement.scrollTop)
				theTop = document.documentElement.scrollTop;
			else if (document.body)
				theTop = document.body.scrollTop;

			if (theTop > headTop)
				FloatHead1.style.top = (theTop - headTop) + 'px';
			else
				FloatHead1.style.top = '0px';
		}
	}

	function saveHeadPos() {
		parTable = document.getElementById("divHeadSep");
		if (parTable != null) {
			headTop = parTable.offsetTop + 3;
			FloatHead1 = document.getElementById("heading");
			FloatHead1.style.position = "relative";
		}
	}

	function lockKey() {
		if (event.keyCode == 93)
			alert("Welcome to eHIS");
	}

	function lockbackSpace() {
		var mode = document.mode.value;
		if (mode == 'modify' && window.event.keyCode == 8) {

		}
	}

	var objFinal = {};
	var objunSelectFinal = [];

	function checkBoxValidate(index, start, end) {

		var table = document.getElementById("interim_Bill_Details_table");
		var rowCount = table.rows.length;
		var totalCount = document.getElementById("rowCount").value;
		var totalSize = document.getElementById("totalrowcount").value;
		start = start - 1;
		var count = 0;
		var i = 0;
		var checkObj = document.getElementById('select_all' + index);
		var selectArrFlag = parent.frames[1].document.getElementById("selectArrFlag").value;
		var selectArrUnSlectFlag = parent.frames[1].document.getElementById("selectArrUnSlectFlag").value;
		var selectJsonArrFlag = parent.frames[1].document.getElementById("selectJsonArrFlag").value;
		var selectAllFlag = parent.frames[1].document.getElementById("selectAllFlag").value;
		var selectAllPrevFlag=parent.frames[1].document.getElementById("selectAllPrevFlag").value;
		if (checkObj.checked) {
			if(selectAllPrevFlag!="Y"){
			document.getElementById('select_all' + index).value = 'Y';
			selectArrFlag = selectArrFlag + index + ",";
			parent.frames[1].document.getElementById("selectArrFlag").value = selectArrFlag;
			if (selectJsonArrFlag != null && selectJsonArrFlag != "")
				objFinal = JSON.parse(selectJsonArrFlag);
			var newNum = "";
			var newVal = "";
			newNum = index;
			var srl_no = document.getElementById("srl_no" + index).value;
			var patId = document.getElementById("patient_id" + index).value;
			var pName = document.getElementById("patient_name" + index).value;
			var epdId = document.getElementById("episode_id" + index).value;
			var admDate = document.getElementById("admissiondate" + index).value;
			admDate = admDate.split("/").reverse().join("-");
			var payerGroup = document.getElementById("payer_group" + index).value;
			var payer = document.getElementById("payer" + index).value;
			var policy = document.getElementById("policy" + index).value;
			var unbuiledAmount = document.getElementById("unbuiledamount"+ index).value;
			var billNumber = document.getElementById("billnumber" + index).value;
			var billDate = document.getElementById("billdate" + index).value;
			billDate = billDate.split("/").reverse().join("-");
			var selectall = document.getElementById("select_all" + index).value;
			newVal = srl_no + "~" + patId + "~" + pName + "~" + epdId + "~"
					+ admDate + "~" + payerGroup + "~" + payer + "~" + policy
					+ "~" + unbuiledAmount + "~" + billNumber + "~" + billDate
					+ "~" + selectall;
			objFinal[newNum] = newVal;
			parent.frames[1].document.getElementById("selectJsonArrFlag").value = JSON.stringify(objFinal);
			}else{
				if(selectArrUnSlectFlag.indexOf(index)!=-1){
					selectArrUnSlectFlag = selectArrUnSlectFlag.replace(index + ",", "");
					parent.frames[1].document.getElementById("selectArrUnSlectFlag").value = selectArrUnSlectFlag;
					document.getElementById("finalUnselectindex").value=selectArrUnSlectFlag;
				}
			}
		} else {
			if (selectAllFlag == "Y" || selectAllPrevFlag=="Y") {
				document.getElementById("Header_select_all").checked = false;
				document.getElementById("Header_select_all").value = "N";
				parent.frames[1].document.getElementById("selectAllFlag").value = "N";
				parent.frames[1].document.getElementById("selectAllPrevFlag").value = "Y";
				selectArrUnSlectFlag=selectArrUnSlectFlag + index + ",";
				parent.frames[1].document.getElementById("selectArrUnSlectFlag").value = selectArrUnSlectFlag;
				document.getElementById("finalUnselectindex").value=selectArrUnSlectFlag;
			} else {
				parent.frames[1].document.getElementById("selectAllPrevFlag").value = "N";
				selectArrFlag = selectArrFlag.replace(index + ",", "");
				delete objFinal[index];
				parent.frames[1].document.getElementById("selectJsonArrFlag").value = JSON.stringify(objFinal);
				parent.frames[1].document.getElementById("selectArrFlag").value = selectArrFlag;
			}
			
		}
	}

	function checkBoxValidate1(start, end) {
		var checkObj = document.getElementById("Header_select_all");
		var table = document.getElementById("interim_Bill_Details_table");
		parent.frames[1].document.getElementById("selectJsonArrFlag").value="";
		parent.frames[1].document.getElementById("selectArrFlag").value="";
		parent.frames[1].document.getElementById("selectArrUnSlectFlag").value ="";
		document.getElementById("finalUnselectindex").value="";
		document.getElementById("finalIndexArr").value="";
		var totalhashSize=document.getElementById("totalrowCount").value;//V210228
		objFinal = {};
		var rowCount = table.rows.length;
		//V210228 Starts
		if(totalhashSize<16){
			end=totalhashSize;
		}
		//V210228 Ends
		start = start - 1;
		var i = 0;
		if (checkObj.checked == true) {
			parent.frames[1].document.getElementById("selectAllFlag").value = "Y";
			parent.frames[1].document.getElementById("selectAllPrevFlag").value="";
			document.getElementById("Header_select_all").value = "Y";
			for (i = start; i < end; i++) {
				if(!document.getElementById("select_all" + i).disabled){
				document.getElementById("select_all" + i).checked = true;
				document.getElementById("select_all" + i).value = "Y";
				}

			}
		} else {
			parent.frames[1].document.getElementById("selectAllFlag").value = "N";
			parent.frames[1].document.getElementById("selectAllPrevFlag").value="";
			document.getElementById("Header_select_all").value = "N";
			for (i = start; i < end; i++) {
				if(!document.getElementById("select_all" + i).disabled){
				document.getElementById("select_all" + i).checked = false;
				document.getElementById("select_all" + i).value = "N";
				}
			}
		}
	}

	function validateDynamicChk() {
		var authorizedUserId = parent.frames[1].document.getElementById("authorizedUserId").value;
		var privilegeYN = parent.frames[1].document.getElementById("privilegeYN").value;
		var selectAllPrevFlag = parent.frames[1].document.getElementById("selectAllPrevFlag").value;
		var selectFlag = parent.frames[1].document.getElementById("selectAllFlag").value;
		var selectArrFlag = parent.frames[1].document.getElementById("selectArrFlag").value;
		var rowCount = document.getElementById("rowCount").value;
		var startVal = document.getElementById("start").value;
		document.getElementById("authorizedUserId").value=parent.frames[1].document.getElementById("authorizedUserName").value;
		document.getElementById("finalIndexArr").value=parent.frames[1].document.getElementById("selectArrFlag").value;
		document.getElementById("finalUnselectindex").value=parent.frames[1].document.getElementById("selectArrUnSlectFlag").value;
		startVal = startVal - 1;
		if (authorizedUserId == "Y" && privilegeYN=="YY") {
			if (selectFlag == "Y") {
				document.getElementById("Header_select_all").checked = true;
				document.getElementById("Header_select_all").disabled = false;
				document.getElementById("Header_select_all").value = "Y";
				for (var i = startVal; i < rowCount; i++) {
					if(!document.getElementById("select_all" + i).disabled){
					document.getElementById("select_all" + i).checked = true;
					document.getElementById("select_all" + i).value = "Y";
					}
				}
			} else if (selectFlag == "N") {
				document.getElementById("Header_select_all").checked = false;
				document.getElementById("Header_select_all").disabled = false;
				document.getElementById("Header_select_all").value = "N";
				for (var i = startVal; i < rowCount; i++) {
					if(!document.getElementById("select_all" + i).disabled){
					document.getElementById("select_all" + i).checked = false;
					document.getElementById("select_all" + i).value = "N";
					}
				}
				var res = selectArrFlag.split(",");
				for (var index = 0; index < res.length; index++) {
					var valueToCheck = trimString(res[index]);
					try {
						if (parseInt(valueToCheck) >= parseInt(startVal)
								&& parseInt(valueToCheck) < parseInt(rowCount) && valueToCheck!=null && valueToCheck!="") {
							document.getElementById("select_all" + valueToCheck).checked = true;
							document.getElementById('select_all' + valueToCheck).value = "Y";
						}
					} catch (e) {
						alert("Exception " + e);
					}
				}
				if (selectAllPrevFlag == "Y") {
					var selectArrUnSlectFlag = parent.frames[1].document.getElementById("selectArrUnSlectFlag").value;
					for (var i = startVal; i < rowCount; i++) {
						if(selectArrUnSlectFlag.indexOf(i)==-1 &&parseInt(i) >= parseInt(startVal)
								&& parseInt(i) < parseInt(rowCount)){
							document.getElementById("select_all" + i).checked = true;
							document.getElementById("select_all" + i).disabled = false;
							document.getElementById("select_all" + i).value = "Y";
						}
					}
				}

			}
		} else {
			document.getElementById("Header_select_all").checked = false;
			document.getElementById("Header_select_all").disabled = true;
			document.getElementById("Header_select_all").value = "N";
			for (var i = startVal; i < rowCount; i++) {
				document.getElementById("select_all" + i).checked = false;
				document.getElementById("select_all" + i).disabled = true;
				document.getElementById("select_all" + i).value = "N";
			}
		  }	
		//V210228 Starts
		//Disabling the header slect all
		var disFlag="N";
		for (i = startVal; i < rowCount; i++) {
				if(!document.getElementById("select_all" + i).disabled){
					disFlag="Y";
				}
			}
		if(disFlag=="N"){
			document.getElementById("Header_select_all").checked = false;
			document.getElementById("Header_select_all").disabled = true;
			document.getElementById("Header_select_all").value = "N";
		}
		//Ends
}
		  

</script>
</head>
<style>
div.tableContainer {
	width: 100%; /* table width will be 99% of this*/
	height: 160px; /* must be greater than tbody*/
	overflow: auto;
	margin: 0 auto;
}

table {
	width: 100%; /*100% of container produces horiz. scroll in Mozilla*/
	border: none;
	background-color: #f7f7f7;
}

table>tbody {
	/* child selector syntax which IE6 and older do not support*/
	overflow: auto;
	height: 120x;
	overflow-x: hidden;
}

thead tr {
	position: relative;
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
}

TD.YELLOW {
	BACKGROUND-COLOR: yellow;
	FONT-SIZE: 8pt;
	border-style: dashed;
	border-left-color: #D5E2E5;
	border-right-color: #D5E2E5;
	border-top-color: #D5E2E5;
	border-bottom-color: #D5E2E5;
}

TD.RED {
	background-color: #FFFFFF;
	COLOR: red;
	FONT-SIZE: 8pt;
	TEXT-ALIGN: LEFT
}
</style>

<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1   
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0   
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server 
	String locale = "";
	String facilityId = "";
	String mode = checkForNull(request.getParameter("mode"));
	String isUserCanAcess = "";
	String bean_id = "";
	String bean_name = "";
	String patientId = "";
	String episodeType = "";
	String patientName = "";
	String encounterId = "";
	String customerGroupCode = "";
	String encounterFromDate = "";
	String encounterToDate = "";
	String customerCode = "";
	String policyTypecode = "";
	String requestStatus = "";
	String speciality = "";
	String authorizedUserId = "";
	StringBuffer sql = null;
	LinkedHashMap recordPreApprovalDataMap = null;
	String disable = "DISABLED";
	String mainAuth=checkForNull(request.getParameter("mainAuth"));
	String privilegeYN=checkForNull(request.getParameter("privilegeYN"));
	String authorizedUserName=checkForNull(request.getParameter("authorizedUserName"));
	System.out.println("mainAuth  "+mainAuth);
	System.out.println("privilegeYN  "+privilegeYN);
	System.out.println("authorizedUserName  "+authorizedUserName);
	Boolean siteSpec = false;
	int rowcount = 0;
	int start = 0;
	int end = 0;
	int i = 1;
	String endOfRes = "1";
	int count = 0;
	boolean flage = true;
	int noofdecimal = 0;
	String from = request.getParameter("from");
	String to = request.getParameter("to");
	int index = 0;
	int lastIndex = 0;
	int totalrowcount = 0;

	if (from == null)
		start = 1;
	else
		start = Integer.parseInt(from);

	if (to == null)
		end = 16;
	else
		end = Integer.parseInt(to);

	try {
		//Connection con = ConnectionManager.getConnection(request); //V211020
		sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
				|| (session.getAttribute("PREFERRED_STYLE") != "")
						? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
		locale = (String) session.getAttribute("LOCALE");
		facilityId = (String) session.getValue("facility_id");
		patientId = checkForNull(request.getParameter("patinetId"));
		episodeType = checkForNull(request.getParameter("episodeType"));
		patientName = checkForNull(request.getParameter("patientName"));
		encounterId = checkForNull(request.getParameter("encounterId"));
		customerGroupCode = checkForNull(request.getParameter("customerGroupCode"));
		customerCode = checkForNull(request.getParameter("customerCode"));
		policyTypecode = checkForNull(request.getParameter("policyCode"));
		speciality = checkForNull(request.getParameter("speciality"));

		bean_id = "RecordApprovalPatientDataBean";
		bean_name = "eBL.RecordApprovalPatientDataBean";
		RecordApprovalPatientDataBean recordApprovalPatientDataBean = (RecordApprovalPatientDataBean) getBeanObject(
				bean_id, bean_name, request);
		isUserCanAcess = (String) (session.getValue("isUserCanAcess") == null ? "Y"
				: (session.getValue("isUserCanAcess")));
		if (request.getParameter("from") == null || mode.equals("search")) {
			recordApprovalPatientDataBean.clearBean();//V210228
			recordPreApprovalDataMap = recordApprovalPatientDataBean.getInterimBillApprovalData(facilityId,
					patientId, patientName, episodeType, encounterId, speciality, customerGroupCode,
					customerCode, policyTypecode);
			System.err.println("Firtst time  "+ recordPreApprovalDataMap.size());
		} else {
			recordPreApprovalDataMap = recordApprovalPatientDataBean.getrPatSearchValues();
			System.err.println("Second time  "+ recordPreApprovalDataMap.size());
		}
		rowcount = recordPreApprovalDataMap.size();
		System.err.println("Row Count "+rowcount);
		totalrowcount = rowcount;
		int cnt = 0;
		int previous = 0;
%>
<body onScroll="processScroll()" onKeyDown="lockKey();"
	onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();"
	onload='validateDynamicChk();'>
	<form id="recordApprovalPatientData" name="recordApprovalPatientData" id="recordApprovalPatientData">
		<div align="right">
			<td>
				<%
					if (cnt == 0) {

							if (!(start <= i)) {

								out.println("<A HREF='../../eBL/jsp/BLInterimBillDetals.jsp?from=" + (start - 16) + "&to="
										+ (end - 16) + "&patinetId=" + "&patinetId=" + patientId + "&episodeType=" + episodeType
										+ "&customerGroupCode=" + customerGroupCode + "&facility_id=" + facilityId
										+ "&patientName=" + patientName + "&encounterId=" + encounterId + "&speciality="
										+ speciality + "&customerGroupCode=" + customerGroupCode + "&customerCode="
										+ customerCode + "&customerGroupCode=" + customerGroupCode + "&policyCode="
										+ policyTypecode + "&mainAuth="+mainAuth+"&privilegeYN="+privilegeYN+"&authorizedUserName="+authorizedUserName+"' text-decoration='none'>" + com.ehis.util.BundleMessage
												.getBundleMessage(pageContext, "Common.previous.label", "common_labels")
										+ "</A>");

							}
							if (endOfRes.equals("1") && rowcount > end) {
								out.println(
										"<A id='nextval' HREF='../../eBL/jsp/BLInterimBillDetals.jsp?from=" + (start + 16)
												+ "&to=" + (end + 16) + "&patinetId=" + patientId + "&episodeType="
												+ episodeType + "&customerGroupCode=" + customerGroupCode + "&facility_id="
												+ facilityId + "&patientName=" + patientName + "&encounterId=" + encounterId
												+ "&speciality=" + speciality + "&customerGroupCode=" + customerGroupCode
												+ "&customerCode=" + customerCode + "&customerGroupCode=" + customerGroupCode
												+ "&policyCode="
												+ policyTypecode +"&mainAuth="+mainAuth+"&privilegeYN="+privilegeYN+"&authorizedUserName="+authorizedUserName+"' text-decoration='none'>" + com.ehis.util.BundleMessage
														.getBundleMessage(pageContext, "Common.next.label", "common_labels")
												+ "</A>");

							}
						}
				%>
			</td>
		</div>

		<table cellpadding=3 cellspacing=0 width="100%"
			id="interim_Bill_Details_table" name="interim_Bill_Details_table" id="interim_Bill_Details_table"
			border="1">
			<div id="tableContainer">
				<THEAD>
					<tr>
						<td colspan='16' class="columnheader" align="left">Patient
							Data</td>
					</tr>
					<TR>
						<td class='columnheader' nowrap width='5%' align="center" nowrap><fmt:message
								key="Common.SrlNo.label" bundle="${common_labels}" /></td>
						<td class='columnheader' width='6%' align="center" nowrap><fmt:message
								key="Common.patientId.label" bundle="${common_labels}" /></td>
						<td class='columnheader' width='8%' align="center" nowrap><fmt:message
								key="Common.PatientName.label" bundle="${common_labels}" /></td>
						<td class='columnheader' width='6%' align="center" nowrap><fmt:message
								key="Common.episodeid.label" bundle="${common_labels}" /></td>
						<td class='columnheader' width='8%' align="center" nowrap><fmt:message
								key="Common.admissiondate.label" bundle="${common_labels}" /></td>
						<td class='columnheader' width='5%' align="center" nowrap><fmt:message
								key="eBL.PayerGroup.label" bundle="${bl_labels}" /></td>
						<td class='columnheader' width='5%' align="center" nowrap><fmt:message
								key="Common.Payer.label" bundle="${common_labels}" /></td>
						<td class='columnheader' width='5%' align="center" nowrap><fmt:message
								key="eBL.POLICY.label" bundle="${bl_labels}" /></td>
						<td class='columnheader' width='6%' align="center" nowrap><fmt:message
								key="eBL.UnBilledAmount.Label" bundle="${bl_labels}" /></td>
						<td class='columnheader' width='6%' align="center" nowrap><fmt:message
								key="eBL.PreviousInterimBillDocNo.label" bundle="${bl_labels}" /></td>
						<td class='columnheader' width='6%' align="center" nowrap><fmt:message
								key="eBL.BilledDate.label" bundle="${bl_labels}" /></td>
						<td class='columnheader' width='6%' align="center" nowrap>
						<input 	type='Checkbox' <%=disable%> id="Header_select_all"	name="Header_select_all"
							onclick="checkBoxValidate1('<%=start%>','<%=end%>');"  value="N"/>&nbsp;
							<fmt:message key="eBL.SelectAll.Label" bundle="${bl_labels}" />
						</td>
					</TR>
				</THEAD>
				<TBODY style="height: 20px;">
					<%
						Iterator iterator = recordPreApprovalDataMap.keySet().iterator();
							String isDisabled = "disabled";
							String isReadOnly = "readonly onfocus='this.blur()'";
							if (recordPreApprovalDataMap.size() <= 0) {
								out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
							} else {	
								if (!(start == 1)) {
									for (int j = 1; j < start; i++, j++) {
										iterator.next();
									}

								}
								while (i <= end && iterator.hasNext()) {
									lastIndex = index;
									index = (Integer) iterator.next();
									int sNo = index + 1;
									rowcount = sNo;
									recordApprovalPatientDataBean = (RecordApprovalPatientDataBean) recordPreApprovalDataMap.get(index);

									String BilledDate = "";
									String AdmissionDate = "";

									BilledDate = recordApprovalPatientDataBean.getBillDate();
									System.err.println("Billed Date  "+BilledDate);
									if (BilledDate != null && !(BilledDate.equals(""))) {
										SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
										SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
										BilledDate = sdf2.format(sdf1.parse(BilledDate));
									}
									AdmissionDate = recordApprovalPatientDataBean.getAdmissionDate();
									System.err.println("AdmissionDate   "+AdmissionDate);
									if (AdmissionDate != null && !(AdmissionDate.equals(""))) {
										SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
										SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
										AdmissionDate = sdf2.format(sdf1.parse(AdmissionDate));
									}
					%>
					<%!public String UnbilledpriceFormat(String str) {
		if (str == null || str.equals("")) {
			str = "0.00";
		} else {
			str = String.format("%.2f", Float.parseFloat(str));
		}
		return str;
	}%>
					<tr>
						<td class="fields" style="text-align:center;" width='5%' nowrap id="srl_no<%=index%>" value="<%=sNo%>" name="srl_no<%=index%>"><%=sNo%></td>
						<td class="fields" style="text-align:center;" width='6%' nowrap id="patient_id<%=index%>"
							value="<%=recordApprovalPatientDataBean.getPatientId() != null
								? recordApprovalPatientDataBean.getPatientId() : ""%>"
							name="patient_id<%=index%>"><%=recordApprovalPatientDataBean.getPatientId() != null
								? recordApprovalPatientDataBean.getPatientId() : ""%>
						</td>
						<td class="fields" style="text-align:left;" width='15%' nowrap id="patient_name<%=index%>"
							value="<%=recordApprovalPatientDataBean.getPatientName() != null
								? recordApprovalPatientDataBean.getPatientName() : ""%>"
							name="patient_name<%=index%>"><%=recordApprovalPatientDataBean.getPatientName() != null
								? recordApprovalPatientDataBean.getPatientName() : ""%>
						</td>
						<td class="fields" style="text-align:center;" width='6%' nowrap id="episode_id<%=index%>"
							value="<%=recordApprovalPatientDataBean.getEpisodeId() != null
								? recordApprovalPatientDataBean.getEpisodeId() : ""%>"
							name="episode_id<%=index%>"><%=recordApprovalPatientDataBean.getEpisodeId() != null
								? recordApprovalPatientDataBean.getEpisodeId() : ""%>
						</td>
						<td class="fields" style="text-align:center;" width='8%' nowrap id="admissiondate<%=index%>"
							value="<%=AdmissionDate%>" name="admissiondate<%=index%>"><%=AdmissionDate%>
						</td>
						<td class="fields" style="text-align:center;" width='5%' nowrap id="payer_group<%=index%>"
							value="<%=recordApprovalPatientDataBean.getPayerGroup() != null
								? recordApprovalPatientDataBean.getPayerGroup() : ""%>"
							name="payer_group<%=index%>"><%=recordApprovalPatientDataBean.getPayerGroup() != null
								? recordApprovalPatientDataBean.getPayerGroup() : ""%>
						</td>
						<td class="fields" style="text-align:center;" width='6%' nowrap id="payer<%=index%>"
							value="<%=recordApprovalPatientDataBean.getPayer() != null
								? recordApprovalPatientDataBean.getPayer() : ""%>"
							name="payer<%=index%>"><%=recordApprovalPatientDataBean.getPayer() != null
								? recordApprovalPatientDataBean.getPayer() : ""%>
						</td>
						<td class="fields" style="text-align:center;" width='8%' nowrap id="policy<%=index%>"
							value="<%=recordApprovalPatientDataBean.getPolicy() != null
								? recordApprovalPatientDataBean.getPolicy() : ""%>"
							name="policy<%=index%>"><%=recordApprovalPatientDataBean.getPolicy() != null
								? recordApprovalPatientDataBean.getPolicy() : ""%>
						</td>
						<td class="fields" style="text-align:center;" width='8%' nowrap id="unbuiledamount<%=index%>"
							value="<%=UnbilledpriceFormat(recordApprovalPatientDataBean.getUnBuiledAmount())%>"
							name="unbuiledamount<%=index%>"><%=UnbilledpriceFormat(recordApprovalPatientDataBean.getUnBuiledAmount())%>
						</td>
						<td class="fields" style="text-align:center;" width='8%' nowrap id="billnumber<%=index%>"
							value="<%=recordApprovalPatientDataBean.getBillNumber() != null
								? recordApprovalPatientDataBean.getBillNumber() : ""%>"
							name="billnumber<%=index%>"><%=recordApprovalPatientDataBean.getBillNumber() != null
								? recordApprovalPatientDataBean.getBillNumber() : " "%>
						</td>
						<td class="fields" style="text-align:center;" width='8%' nowrap id="billdate<%=index%>"
							value="<%=BilledDate%>" name="billdate<%=index%>"><%=BilledDate%>
						</td>
							<%
							System.out.println("mainAuth check"+mainAuth+"::"+privilegeYN);
							if(mainAuth.equals("YY") && privilegeYN.equals("YY")){
								System.err.println("Inside Iff ");
							String  p_privilege_val="";
							String  p_allowed_yn="";
							CallableStatement cstmt=null;
							Connection	connection 	= ConnectionManager.getConnection();
							try{
							System.out.println("Inside Try");
							cstmt = connection.prepareCall("{ call blpolicyuseraccessdtls.get_bl_policy_privlege_yn(?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?)}");
							System.out.println("After Callable Try");
							cstmt.setString(1, facilityId);
							cstmt.setString(2, authorizedUserName);
							cstmt.setString(3, "");
							cstmt.setString(4, "INTERIM_BILL_AUTH");
							cstmt.setString(5, recordApprovalPatientDataBean.getPayerGroup());
							cstmt.setString(6, recordApprovalPatientDataBean.getPayer());
							cstmt.setString(7, recordApprovalPatientDataBean.getPolicy());
							cstmt.setString(8, "BILL_AUTHORIZATION");
							cstmt.setString(9, new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()));
							cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
							cstmt.execute();	
							p_privilege_val = cstmt.getString(10);
							p_allowed_yn = cstmt.getString(11);
							System.out.println("password check"+p_privilege_val+"::"+p_allowed_yn);
							if(p_privilege_val.equals("Y") && p_allowed_yn.equals("Y")){
								disable="";
								System.out.println("disable check   "+disable);
							}else{
								disable="disabled";
								System.out.println("disable check   "+disable);
							}
							}
							catch(Exception ee)
							{
								//cstmt.close(); //V211020
								//connection.close();//V211020
								ee.printStackTrace();
							}finally{
								cstmt.close();
								connection.close();
							}
							
							}	
							%>
							
							
						<td width="3%" align="center"  >
						<%if(!disable.equals("disabled")){
							%>
							<input type='Checkbox' id="select_all<%=index%>" name="select_all" value="select_all" align="center"
							onclick="checkBoxValidate('<%=index%>','<%=start%>','<%=end%>');"   >
					<% 	System.out.println("disable Applied   "+disable);}else{%>
						<input type='Checkbox' id="select_all<%=index%>" name="select_all" value="select_all" align="center"
							onclick="checkBoxValidate('<%=index%>','<%=start%>','<%=end%>');"  disabled  >
							<% System.out.println("disable Applied   "+disable);}%></td>
					</tr>

					<%	
					System.err.println(i);
						i++;
								}
					%>

				</TBODY>

			</div>
			<%
				cnt++;
					}
					if (!iterator.hasNext() && cnt != 0) {
						endOfRes = "0";
					}
				} catch (Exception e) {
					System.out.println("Exception in BillingRecordApprovalPatientDataDeatils.jsp::" + e);
					e.printStackTrace();

				}
			%>
		</table>
		<br> <br>
		<div id='comment'>
			<h5>
				<img src='../../eCommon/images/mandatory.gif'>
				<fmt:message key="eBL. AfterBillApproval.label"
					bundle="${bl_labels}" />
			</h5>
		</div>
		<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>">
		<input type='hidden' name='rowCount' id='rowCount' id='rowCount' value="<%=rowcount%>">
		<input type='hidden' name='lastIndex' id='lastIndex' value="<%=lastIndex%>"> 
		<input type='hidden' name='start' id='start' id='start' value="<%=start%>"> 
		<input type='hidden' name='finalIndexArr' id='finalIndexArr' id='finalIndexArr' value=""> 
		<input type='hidden' name='finalJSONArr' id='finalJSONArr' id='finalJSONArr' value="">
		<input type='hidden' name='finalUnselectindex' id='finalUnselectindex' id='finalUnselectindex' value="">
		<input type='hidden' name='totalrowCount' id='totalrowCount' id='totalrowCount' value="<%=totalrowcount%>"> 
		<input type='hidden' name='locale' id='locale' id='locale' value="<%=locale%>"> 
		<input type='hidden' name='facilityId' id='facilityId' id='facilityId' value="<%=facilityId%>"> 
		<input type='hidden' name='patientId' id='patientId' id='patientId' value="<%=patientId%>"> 
		<input type='hidden' name='episodeType' id='episodeType' id='episodeType' value="<%=episodeType%>">
		<input type='hidden' name='patientName' id='patientName' id='patientName' value="<%=patientName%>">
		<input type='hidden' name='encounterId' id='encounterId' id='encounterId' value="<%=encounterId%>"> 
		<input type='hidden' name='customerGroupCode' id='customerGroupCode' id='customerGroupCode' value="<%=customerGroupCode%>"> 
		<input type='hidden' name='customerCode' id='customerCode' id='customerCode' value="<%=rowcount%>">
		<input type='hidden' name='policyTypecode' id='policyTypecode' id='policyTypecode' value="<%=policyTypecode%>"> 
		<input type='hidden' name='speciality' id='speciality' id='speciality' value="<%=speciality%>">
		<input type='hidden' name='authorizedUserId' id='authorizedUserId' id="authorizedUserId" value="">
	</form>
	<div name='tooltiplayer' id='tooltiplayer'
		style='position: absolute; width: 30%; visibility: hidden;'
		bgcolor='blue'></div>
</body>
<%!private String checkForNull(String inputString) {
		return (inputString == null) ? "" : inputString;
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return (((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}%>
</html>

