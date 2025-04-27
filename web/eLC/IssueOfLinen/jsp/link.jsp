<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.iba.ehis.core.vo.AppVO" %>
<%@ include file="/framework/html/Tag.text"%>
<ibaHTML:html locale="true">

<head>
	<%
			String facilityId = (String) session.getAttribute("facility_id");
			String functionId = (String) request.getParameter("functionId");
			String moduleId = (String) request.getParameter("moduleId");
			String addedById = (String) session.getAttribute("login_user");
			String locale = (String) session.getAttribute("LOCALE");
			session.setAttribute("requestStatus",request.getParameter("requestStatus"));
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
		String pattern="dd/MM/yyyy hh:mm";
	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />	
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenIssue.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
</script>

	<script type="text/javascript">
	var pArgumentArray = new Array();
	var sourceDesc="";
	pArgumentArray[0]= <%=request.getParameter("sourceCode")%>
	var reqNum = trimString(<%=request.getParameter("requestNum")%>);
	pArgumentArray[1] = reqNum;
	var reqDate = <%=request.getParameter("requestDate")%>
	IBADateValidator.convertDateJS(reqDate,"en","<%=locale%>","dd/MM/yyyy HH:mm",callBackDate);
	function callBackDate(conDate){
		pArgumentArray[2]=conDate;
	}

	pArgumentArray[3] = <%=request.getParameter("raisedBy")%>
	pArgumentArray[4] = <%=request.getParameter("requestStatus")%>
	pArgumentArray[5] = <%=request.getParameter("sourceType")%>   
			var ss=pArgumentArray[5];   
			pArgumentArray[5]=trimString(ss);
			if(pArgumentArray[5]=='W'){
			getServerMessage("com.iba.ehis.lc.ward");
			sourceDesc=dwrMessage;}
			else if(pArgumentArray[5]=='C'){
			getServerMessage("com.iba.ehis.lc.clinic");
			sourceDesc=dwrMessage;}
			else if(pArgumentArray[5]=='D'){
			getServerMessage("com.iba.ehis.lc.department");
			sourceDesc=dwrMessage;}
			
	pArgumentArray[6]=<%=request.getParameter("linenItem")%>
	pArgumentArray[7]=<%=request.getParameter("requestedQty")%>"
	pArgumentArray[8]=sourceDesc;
	pArgumentArray[9]=<%=request.getParameter("linenDesc")%>
	
	var type1=pArgumentArray[5];
	type1=trimString(type1);
		
	var scode=pArgumentArray[0]
		scode=trimString(scode);
		LinenIssue.getSourceDesc("<%=locale%>","<%=facilityId%>",type1,scode,callBackSourceDesc);
	function callBackSourceDesc(data){
	for(prop in data)
		pArgumentArray[10]=data[prop];
	}

	function callModalWindow(title){
		
		var retVal = new String();
		var dialogHeight = "35";
		var dialogWidth = "55";
		var status = "no";
		var view="view";
		
		var dialogUrl = contextPath + "/IssueOfLinenViewAction.do?title="+ title +"&vo.checkView="+view+"&method=4&vo.issueOfLinenVO.requestNum="+pArgumentArray[1]+"&vo.issueOfLinenVO.requestDate="+pArgumentArray[2]+"&vo.issueOfLinenVO.requestDate.pattern=<%=pattern%>&vo.issueOfLinenVO.sourceType="+pArgumentArray[5]+"&vo.issueOfLinenVO.sourceCode="+pArgumentArray[0]+"&vo.issueOfLinenVO.raisedBy="+pArgumentArray[3]+"&vo.issueOfLinenVO.requestStatus="+pArgumentArray[4]+"&vo.issueOfLinenVO.linenItem="+pArgumentArray[6]+"&vo.issueOfLinenVO.requestedQty="+pArgumentArray[7]+"&vo.issueOfLinenVO.addedFacilityId=<%=facilityId%>"
		var dialogArguments = pArgumentArray;
		var dialogFeatures = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + " ; scroll=auto; status:" + status;
		window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
		
	}
	function callModalWindow1(title){
		var retVal = new String();
		var dialogHeight = "35";
		var dialogWidth = "55";
		var status = "no";
		var dialogUrl = contextPath + "/eLC/IssueOfLinen/jsp/ModalMessageFrames.jsp?title="+ title+"&requestNum="+pArgumentArray[1]+"&requestDate="+pArgumentArray[2]+"&sourceType="+pArgumentArray[5]+"&sourceCode="+pArgumentArray[0]+"&raisedBy="+pArgumentArray[3]+"&requestStatus="+pArgumentArray[4]+"&linenItem="+pArgumentArray[6]+"&requestedQty="+pArgumentArray[7]+"&sourceDesc="+pArgumentArray[8]+"&linenDesc="+pArgumentArray[9]
		var dialogArguments = pArgumentArray;
		var dialogFeatures = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + " ; scroll=auto; status:" + status;
		var val=window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
		if(val==true)
			parent.parent.window.frames[0].document.QueryCriteriaForm.submit();
		
	}
	
	</script>
</head>

<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
	
		<%
			String stat = (String)request.getParameter("requestStatus");
			String CN_Value[] = stat.split(" ");
			String statusSplit = CN_Value[1];
			if(statusSplit.equals("CN")){
		%>
			<tr>
				<td class='label'>
					<a href="#"	onClick="return callModalWindow('<ibaBean:message	key="com.iba.ehis.lc.viewDetail" bundle="lcLabels" />');">
						<ibaBean:message key="com.iba.ehis.lc.view" bundle="lcLabels" />
					</a>
				</td>
			</tr>
			<tr>
				<td height="15">
					
				</td>
			</tr>
			<%
			} else if(statusSplit.equals("IS")){	
		%>
			<tr>
				<td class='label'>
					<a href="#"	onClick="return callModalWindow('<ibaBean:message	key="com.iba.ehis.lc.viewDetail" bundle="lcLabels" />');">
						<ibaBean:message key="com.iba.ehis.lc.view" bundle="lcLabels" />
					</a>
				</td>
			</tr>
			<tr>
				<td height="15">
					
				</td>
			</tr>
		<%
			} else {
		%>
		<tr>
				<td class='label' >
					<a href="#" onClick="return callModalWindow1('<ibaBean:message	key="com.iba.ehis.lc.issue" bundle="lcLabels" />');">
					 <ibaBean:message	key="com.iba.ehis.lc.issue" bundle="lcLabels" /> </a>
				</td>
			</tr>
			<tr>
				<td class='label'>
					<a href="#"	onClick="return callModalWindow('<ibaBean:message	key="com.iba.ehis.lc.viewDetail" bundle="lcLabels" />');">
						<ibaBean:message key="com.iba.ehis.lc.view" bundle="lcLabels" />
					</a>
				</td>
			</tr>
		<%
			}
		%>
		</table>
</body>
</ibaHTML:html>

