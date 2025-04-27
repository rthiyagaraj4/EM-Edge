<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ditchnet.org/jsp-tabs-taglib" prefix="ibaTabs" %>
<%@ page  import="com.iba.framework.core.util.Constants"%>
<%@ page  import="com.iba.framework.core.pojo.web.MessageReader"%>
<%@ include file="/framework/html/Tag.text"%>
<%@taglib uri="/WEB-INF/tld/ditchnet-tabs-taglib.tld" prefix="tab"%>

<html>
	<head>
	<%
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
		.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css" ;
	%>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>	
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenRequest.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenIssue.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script  type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/eLC/core/js/LcExpand.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
	<ibaTabs:tabConfig />
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
		
			
	<%
		String locale = (String)session.getValue("LOCALE");
		String facilityId=(String)session.getAttribute("facility_id");	
		//pageContext.setAttribute("values", request.getQueryString());
		Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().indexOf("org.ditchnet.jsp.tabs") != -1) {
						cookies[i].setValue("");
					}
				}
			}
			MessageReader mr=new MessageReader();

			pageContext.setAttribute("withLaundry",mr.getMessage(request,"com.iba.ehis.lc.withLaundry"));
			pageContext.setAttribute("inCleaning",mr.getMessage(request,"com.iba.ehis.lc.inCleaning"));
			pageContext.setAttribute("rootDir",request.getContextPath(),PageContext.PAGE_SCOPE);

	%>
	<script>
	function tabClicked(evt) {
	var selectedTabPane = evt.getTabPane();
	viewId = selectedTabPane.id;
	//alert(viewId)
	if(viewId!='withLaundryTab')
		{
			getCleaningstock();
		}
		else
		{
			getstock();
		}
	}
	function deleteRows() {
	var tableObj = document.getElementById("treeTable");
	var len = tableObj.rows.length;
	for (i = len - 1; i != -1; i--) {
		tableObj.deleteRow(i);
	}
	}
	function deleteRows1() {
	var tableObj = document.getElementById("treeTable1");
	var len = tableObj.rows.length;
	for (i = len - 1; i != -1; i--) {
		tableObj.deleteRow(i);
	}
	}
	function getstock()
	{
	var facilityId='<%=facilityId%>';
	var locale = document.getElementById("languageId").value;
	LinenIssue.getStockDetail(locale,facilityId,setStockData);
	}
	
	function getCleaningstock()
	{
	var facilityId='<%=facilityId%>';
	var locale = document.getElementById("languageId").value;
	LinenIssue.getInCleaningDetail(locale,facilityId,setCleaningData);
	}
	function setStockData(data)
	{
	deleteRows();
	var count=0;
	var row_ind=0;
	var ind=1;
	var tableObj = null;
	tableObj = document.getElementById("treeTable");
	var row = tableObj.insertRow(tableObj.rows.length);
		var head1 = row.insertCell();
		head1.className = "COLUMNHEADER";
		head1.width="50%";
		head1.innerHTML ="<b><ibaBean:message key='com.iba.ehis.lc.receiveloanedlinen.linenItem' bundle='lcLabels' /></b>";

		var head2 = row.insertCell();
		head2.className = "COLUMNHEADER";
		head2.width="50%";
		head2.innerHTML ="<b><ibaBean:message key='com.iba.ehis.lc.withLaundry' bundle='lcLabels' /></b>";
		var m=0;
		var qryEven = "QRYEVEN";
		var qryOdd = "QRYODD";

	for(prop in data)
	{
		var classVal = (m % 2 == 0) ? qryEven : qryOdd;
		var newRow = tableObj.insertRow(tableObj.rows.length);
		var col1 = newRow.insertCell();
		col1.className = classVal;
		col1.width="50%";
		col1.appendChild(document.createTextNode(prop));
		
		var col2 = newRow.insertCell();
		col2.className = classVal;
		col2.width="50%";
		col2.appendChild(document.createTextNode(data[prop]));
		row_ind++;
		m++;

	}
	}
	
	function setCleaningData(data)
	{
	deleteRows1();
	var count=0;
	var row_ind=0;
	var ind=1;
	var tableObj = null;
	tableObj = document.getElementById("treeTable1");
	var row = tableObj.insertRow(tableObj.rows.length);
		var head1 = row.insertCell();
	head1.className = "COLUMNHEADER";
		head1.width="50%";
		head1.innerHTML ="<b><ibaBean:message key='com.iba.ehis.lc.receiveloanedlinen.linenItem' bundle='lcLabels' /></b>";
		
		var head2 = row.insertCell();
		head2.className = "COLUMNHEADER";
		head2.width="50%";
		head2.innerHTML ="<b><ibaBean:message key='com.iba.ehis.lc.inCleaning' bundle='lcLabels' /></b>";
		var m=0;
		var qryEven = "QRYEVEN";
		var qryOdd = "QRYODD";
	for(prop in data)
	{
		var classVal = (m % 2 == 0) ? qryEven : qryOdd;
		var newRow = tableObj.insertRow(tableObj.rows.length);
		var col1 = newRow.insertCell();
		col1.className = classVal;
		col1.width="50%";
		col1.appendChild(document.createTextNode(prop));
		
		var col2 = newRow.insertCell();
		col2.className = classVal;
		col2.width="50%";
		col2.appendChild(document.createTextNode(data[prop]));
		row_ind++;
		m++;
	}
}

	</script>
	
	</head>
<body OnMouseDown="CodeArrest()" onload="getstock();getCleaningstock();">
		

	
<!--  <div onclick="parent.slide() ; return false ;" bgcolor='blue'>...</div>
 -->
	 	<table width="100%">
				
			<tr>
			
			<td align="left" class="PATIENTLINECOLOR"><ibaBean:message key="com.iba.ehis.lc.stockStatus" bundle="lcLabels" />
			</td>
			<tr>		
			<td>
			<tab:tabContainer id="treeTabs"	selectedTabPaneId="requestForLinenTreeTab"
			jsTabListener="tabClicked">
			<tab:tabPane id="withLaundryTab" tabTitle="${withLaundry}">
				<table id="treeTable" border='1' cellpadding='2' cellspacing='0' width='100%'>
				</table>
			</tab:tabPane>

			<tab:tabPane id="inCleaningTab"	tabTitle="${inCleaning}">
				<table id="treeTable1" border='1' cellpadding='2' cellspacing='0' width='100%'>
				</table>
			</tab:tabPane>
			</tab:tabContainer>
			</td>
			
			</tr>
		</table>
		<br>
		<table width="100%" border="0" border='4'>
			<tr><td>
				<table width="100%" border="0" border='4'>
					<tr>
					<td colspan='2'class="PATIENTLINECOLOR">
					<ibaBean:message key="com.iba.ehis.lc.workStatus" bundle="lcLabels" />
					</td>
					</tr>
					<tr>
					<td class="LABEL" nowrap="nowrap"><ibaBean:message key="com.iba.ehis.lc.standardStock.sourceType" bundle="lcLabels" /> </td>
					<td>
					<select name="sourceType" id="sourceType">
							<option value=""><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" />
							</option>
							<option value="W"><ibaBean:message key="com.iba.ehis.lc.ward" bundle="lcLabels" />
							</option>
							<option value="C"><ibaBean:message key="com.iba.ehis.lc.clinic" bundle="lcLabels" />
							</option>
							<option value="D"><ibaBean:message key="com.iba.ehis.lc.department" bundle="lcLabels" />
							</option>
					</select>
					</td>
					</tr>
					<tr>
					<td class="LABEL" nowrap="nowrap"><ibaBean:message key="com.iba.ehis.lc.source" bundle="lcLabels" /> </td>
					<td nowrap="nowrap"><input type="text" maxlength=30 name="wardsDesc" id="wardsDesc" onblur="showLookup1()" />
					<input type="hidden" name="wardsCode" id="wardsCode" />
					<input type="button" class="BUTTON"  value="?" onclick="showLookup1()" />
				<input type="button" class="BUTTON"  value="Go" onclick="callDWRLookUp()"/>
				<img src="<%=request.getContextPath()%>/framework/images/mandatory.gif"></img>
					</td>
					</tr> 
					<tr><td class="LABEL"><ibaBean:message key="com.iba.ehis.lc.onDate" bundle="lcLabels" /></td>
					  <td class="LABEL"><Div id="dt"></div>
					  <script>
						var currDate = new Date();
						var date = currDate.getDate();
						var mon = currDate.getMonth();
						var hrNow = currDate.getHours();
						var mnNow = currDate.getMinutes();
						scNow = currDate.getSeconds();
						mon = mon+1;
						var year = currDate.getYear();
						if(date <10)
							date = "0"+date;
						if(mon <10)
							mon = "0"+mon;
						var convert1= date + "/" + mon + "/" + year;
						IBADateValidator.convertDateJS(convert1,'en','<%=locale%>','dd/MM/yyyy',callBackMethod);
						 function callBackMethod(data)
						{ convert1=data;
						document.getElementById("dt").innerText=convert1;
						}
						
					  </script>
					  </td>
					</tr>
					</table>
			</td>
			</tr>
			</table>
			<br>
			<table id="StatusTable" border='1' cellpadding='2' cellspacing='0' width='100%'>
			</table>
			<br>
			<table id="StatusTable1" border='1' cellpadding='2' cellspacing='0' width='100%'>
			</table>
		</td>
		</tr>
	</table>	
			<input type="hidden" name="operatingFacilityId" id="operatingFacilityId" value="<%=facilityId%>" />	
			<input type="hidden" name="languageId" id="languageId" value="<%=locale%>" />	
				
	</body>
</html>

