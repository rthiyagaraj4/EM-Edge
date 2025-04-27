<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.framework.core.util.IBADateTime,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateValidation" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ditchnet.org/jsp-tabs-taglib" prefix="ibaTabs" %>
<%@ page  import="com.iba.framework.core.util.Constants"%>
<%@ page  import="com.iba.framework.core.pojo.web.MessageReader"%>
<%@ page  import="com.iba.ehis.lc.core.vo.SourceBean"%>
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
		UserPreferences userPrefs =new UserPreferences();
		/* Cache cache = CacheManager.getCache();
		userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */ //AMRI-SCF-0679
		
		SourceBean obj=new SourceBean();
	try
		{
			/* obj=(SourceBean)CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,				
					"sessid", "objKey"); */ //AMRI-SCF-0679
									
		}catch(Exception e){} 
	
		String src=obj.getSource();
		String srcType=obj.getSourceType();
		String srctype=obj.getSourcetype();
		String srcCode=obj.getSourceCode();

	%>
	<script>
	
	function deleteRows() {
	var tableObj = document.getElementById("treeTable");
	var len = tableObj.rows.length;
	for (i = len - 1; i != -1; i--) {
		tableObj.deleteRow(i);
	}
	}
	
	function getstock()
	{
	var facilityId=document.getElementById("operatingFacilityId").value;
	var languageId=document.getElementById("languageId").value;
	var source=document.getElementById("sourceCode").value;
	var sourceType=document.getElementById("SouceDesc").value;
	//alert(facilityId+" "+languageId+" "+source+" "+sourceType);

	LinenIssue.getSourceStock(languageId,facilityId,sourceType,source,setStockData);
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
		head1.width="100%";
		head1.innerHTML ="<b><ibaBean:message key='com.iba.ehis.lc.receiveloanedlinen.linenItem' bundle='lcLabels' /></b>";

		var head2 = row.insertCell();
		head2.className = "COLUMNHEADER";
		head2.width="100%";
		head2.innerHTML ="<b><ibaBean:message key='com.iba.ehis.lc.requestForCleaningLinen.quantity' bundle='lcLabels' /></b>";
		var m=0;
		var qryEven = "QRYEVEN";
		var qryOdd = "QRYODD";

	for(prop in data)
	{
		var classVal = (m % 2 == 0) ? qryEven : qryOdd;
		var newRow = tableObj.insertRow(tableObj.rows.length);
		var col1 = newRow.insertCell();
		col1.className = 'label';
		col1.width="50%";
		col1.appendChild(document.createTextNode(prop));
		
		var col2 = newRow.insertCell();
		col2.className =  'label';
		col2.width="50%";
		col2.appendChild(document.createTextNode(data[prop]));
		row_ind++;
		m++;

	}
	callDWRLookUp();
	}
	
	
function callDWRLookUp(){
	
	var facilityId=document.getElementById("operatingFacilityId").value;
	var languageId=document.getElementById("languageId").value;
	var source=document.getElementById("sourceCode").value;
	var sourceType=document.getElementById("SouceDesc").value;
	//alert(facilityId+" "+languageId+" "+source+" "+sourceType);
	if(source!=""||source!=null)
		
	LinenIssue.getPendingCleaning(languageId,facilityId,sourceType,source,callPendingCleaning);
	}



function callPendingCleaning(rec){
	//deleteRows();
	var count=0;
	var row_ind=0;
	var ind=1;
	var tableObj = null;
	getServerMessage("com.iba.ehis.lc.pendingCleaning");
	var label1=dwrMessage;
	getServerMessage("com.iba.ehis.lc.requestForCleaningLinen.quantity");
	var Qtylabel=dwrMessage;
	tableObj = document.getElementById("StatusTable");
	var len = tableObj.rows.length;
	for (i = len - 1; i != -1; i--) {
		tableObj.deleteRow(i);
	}
	var row1 = tableObj.insertRow(tableObj.rows.length);
		var head = row1.insertCell();
		head.className = "PATIENTLINECOLOR";
		head.width="100%";
		head.colSpan='2';
		head.innerHTML ="<b>"+label1+"</b>";

	var row = tableObj.insertRow(tableObj.rows.length);
		var head1 = row.insertCell();
		head1.className = "COLUMNHEADER";
		head1.width="100%";
		head1.colspan="2";
		head1.innerHTML ="<b><ibaBean:message key='com.iba.ehis.lc.receiveloanedlinen.linenItem' bundle='lcLabels' /></b>";

		var head2 = row.insertCell();
		head2.className = "COLUMNHEADER";
		head2.width="100%";
		head2.innerHTML ="<b>"+Qtylabel+"</b>";
		var m=0;
		var qryEven = "QRYEVEN";
		var qryOdd = "QRYODD";
		for(prop in rec)
		{
		
		var  linenItem=prop	;
		var pendingQty=rec[prop];
		//alert(linenItem+"=="+pendingQty)
		
		var classVal = (m % 2 == 0) ? qryEven : qryOdd;
		var newRow = tableObj.insertRow(tableObj.rows.length);
		var col1 = newRow.insertCell();
		col1.className = 'label';
		col1.width="50%";
		col1.appendChild(document.createTextNode(linenItem));
		var col2 = newRow.insertCell();
		col2.className = 'label';
		col2.width="50%";
		col2.appendChild(document.createTextNode(pendingQty));
		row_ind++;
		m++;
	}
	var facilityId=document.getElementById("operatingFacilityId").value;
	var languageId=document.getElementById("languageId").value;
	var source=document.getElementById("sourceCode").value;
	var sourceType=document.getElementById("SouceDesc").value;
	//alert(facilityId+" "+languageId+" "+source+" "+sourceType);
	LinenIssue.getPendingIssue(languageId,facilityId,sourceType,source,callPendingIssue);
}
function callPendingIssue(data){
	deleteRows2();
	var count=0;
	var row_ind=0;
	var ind=1;
	var tableObj = null;
	getServerMessage("com.iba.ehis.lc.pendingIssue");
	var label1=dwrMessage;
	getServerMessage("com.iba.ehis.lc.requestForCleaningLinen.quantity");
	var Qtylabel=dwrMessage;
	tableObj = document.getElementById("StatusTable1");
	var row1 = tableObj.insertRow(tableObj.rows.length);
		var head = row1.insertCell();
		head.className = "PATIENTLINECOLOR";
		head.width="100%";
		head.colSpan='2';
		head.innerHTML ="<b>"+label1+"</b>";

	var row = tableObj.insertRow(tableObj.rows.length);
		var head1 = row.insertCell();
		head1.className = "COLUMNHEADER";
		head1.width="100%";
		head1.innerHTML ="<b><ibaBean:message key='com.iba.ehis.lc.receiveloanedlinen.linenItem' bundle='lcLabels' /></b>";

		var head2 = row.insertCell();
		head2.className = "COLUMNHEADER";
		head2.width="100%";
		head2.innerHTML ="<b>"+Qtylabel+"</b>";
		var m=0;
		var qryEven = "QRYEVEN";
		var qryOdd = "QRYODD";
	for(prop in data)
		{

			
					var  linenItem=prop;
					var pendingQty=data[prop];
					//alert(linenItem+"=="+requestedQty+"== "+deliveredQty)
		
		var classVal = (m % 2 == 0) ? qryEven : qryOdd;
		var newRow = tableObj.insertRow(tableObj.rows.length);
		var col1 = newRow.insertCell();
		col1.className ='label';
		col1.width="50%";
		col1.appendChild(document.createTextNode(linenItem));
		var col2 = newRow.insertCell();
		col2.className =  'label';
		col2.width="50%";
		col2.appendChild(document.createTextNode(pendingQty));
		row_ind++;
		m++;
	}
}
	</script>
	
	</head>
<body topmargin=0 OnMouseDown="CodeArrest()" onload="getstock();">
		

	
<!--  <div onclick="parent.slide() ; return false ;" bgcolor='blue'>...</div>
 -->
	 	<table width="100%">
			<tr>
			<td align="left" class="PATIENTLINECOLOR"><ibaBean:message key="com.iba.ehis.lc.stockStatus" bundle="lcLabels" />
			</td>
			<tr>		
			<td>
				<table id="treeTable" border='1' cellpadding='2' cellspacing='0' width='100%'>
				</table>
				</td>
			
			</tr>
		</table>
		<table width="100%" border="0" border='4' >
			<tr>
			<td class="PATIENTLINECOLOR"><ibaBean:message key="com.iba.ehis.lc.workStatus" bundle="lcLabels" />
			</td>
			</tr>
		</table>
			<table id="StatusTable" border='1' cellpadding='2' cellspacing='0' width='100%'>
			</table>
			<table id="StatusTable1" border='1' cellpadding='2' cellspacing='0' width='100%'>
			</table>
		</td>
		</tr>
	</table>	
			<input type="hidden" name="operatingFacilityId" id="operatingFacilityId" value="<%=facilityId%>" />	
			<input type="hidden" name="languageId" id="languageId" value="<%=locale%>" />	
			<input type="hidden" name="sourceType" id="sourceType" value="<%=srcType%>" />	
			<input type="hidden" name="Source" id="Source" value="<%=src%>" />	
			<input type="hidden" name="sourceCode" id="sourceCode" value="<%=srcCode%>" />	
			<input type="hidden" name="SouceDesc" id="SouceDesc" value="<%=srctype%>" />	
				
				
	</body>
</html>

