<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateTime,com.iba.framework.core.util.IBADateValidation" pageEncoding="ISO-8859-1"%>
<%@ include file="/framework/html/Tag.text"%>
<ibaHTML:html locale="true">

<head>
	<%
			String facilityId = (String) session.getAttribute("facility_id");
			String functionId = (String) request.getParameter("functionId");
			String moduleId = (String) request.getParameter("moduleId");
			String addedById = (String) session.getAttribute("login_user");
			session.setAttribute("requestStatus",request.getParameter("requestStatus"));
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
			
			UserPreferences userPrefs =new UserPreferences();
			//AMRI-SCF-0679
		userPrefs.setDateFormat("dd/MM/yyyy") ;
		userPrefs.setTimeFormat("HH:mm");
		userPrefs.setLocale("en");
		//AMRI-SCF-0679
			/* Cache cache = CacheManager.getCache();
			userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */ //AMRI-SCF-0679
			String datepattrn=userPrefs.getDateFormat();
			String sb=userPrefs.getDateFormat();
			String tf=userPrefs.getTimeFormat();
			String pattern=sb+" "+tf;
			String locale=userPrefs.getLocale();
	%>
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/IssueLinenAfterMending/js/IssueLinenAfterMending.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	</script>

	<script type="text/javascript">
	var pArgumentArray = new Array();
	var sourceDesc="";
	var conReqDate;
	var rno= <%=request.getParameter("requestNum")%>
	rno=trimString(rno);
	pArgumentArray[1]=rno;
	pArgumentArray[3]=<%=request.getParameter("sentBy")%>
	pArgumentArray[4]=<%=request.getParameter("requestStatus")%>
	pArgumentArray[6]=<%=request.getParameter("linenItem")%>
	pArgumentArray[7]=<%=request.getParameter("requestedQty")%>"
	pArgumentArray[9]=<%=request.getParameter("linenDesc")%>
	pArgumentArray[10]=<%=request.getParameter("agencyCode")%>
	pArgumentArray[11]=<%=request.getParameter("receivedBy")%>

	var requestDate = <%=request.getParameter("requestDate")%>
	IBADateValidator.convertDateJS(requestDate,"en",'<%=locale%>','<%=pattern%>',callBackDate);
	function callBackDate(reqDate){
	conReqDate=reqDate;
		pArgumentArray[2]=reqDate;
	}
	// pArgumentArray[2]=<%=request.getParameter("requestDate")%> 
		
	function callModalWindow(title)
		{
		var retVal = new String();
		var dialogHeight = "35";
		var dialogWidth = "55";
		var status = "no";
		var view="view";
		var dialogUrl = contextPath + "/IssueLinenAfterMendingViewAction.do?title="+ title +"&vo.checkView="+view+"&method=4&vo.issueOfLinenVO.requestNum="+pArgumentArray[1]+"&vo.issueOfLinenVO.raisedBy="+pArgumentArray[3]+"&requestDate="+pArgumentArray[2]+"&vo.issueOfLinenVO.requestStatus="+pArgumentArray[4]+"&vo.issueOfLinenVO.linenItem="+pArgumentArray[6]+"&vo.issueOfLinenVO.requestedQty="+pArgumentArray[7]+"&vo.issueOfLinenVO.addedFacilityId=<%=facilityId%>"
		var dialogArguments = pArgumentArray;
		var dialogFeatures = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + " ; scroll=auto; status:" + status;
		window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
		
	}
	function callModalWindow1(title)
	{
		var retVal = new String();
		var dialogHeight = "35";
		var dialogWidth = "55";
		var status = "no";
	
		var dialogUrl = contextPath + "/eLC/IssueLinenAfterMending/jsp/ModalMessageFrames.jsp?title="+ title+"&requestNum="+pArgumentArray[1]+"&requestDate="+conReqDate+"&raisedBy="+pArgumentArray[3]+"&requestStatus="+pArgumentArray[4]+"&linenItem="+pArgumentArray[6]+"&requestedQty="+pArgumentArray[7]+"&linenDesc="+pArgumentArray[9]
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
			//out.println(statusSplit);
			if(statusSplit.equals("CN")){
		%>
			<tr>
				<td class='label'>
					<a href="#"	onClick="return callModalWindow('<ibaBean:message	key='com.iba.ehis.lc.viewDetail' bundle='lcLabels' />');">
						<ibaBean:message key="com.iba.ehis.lc.view" bundle="lcLabels" />
					</a>
				</td>
			</tr>
			<tr>
				<td height="15">
					
				</td>
			</tr>
			<%
			} else if(statusSplit.equals("RE")){	
		%>
			<tr>
				<td class='label'>
					<a href="#"	onClick="return callModalWindow('<ibaBean:message	key='com.iba.ehis.lc.viewDetail' bundle='lcLabels' />');">
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
					<a href="#" onClick="return callModalWindow1('Receive');">
					 Receive </a>
				</td>
			</tr>
			<tr>
				<td class='label'>
					<a href="#"	onClick="return callModalWindow('<ibaBean:message	key='com.iba.ehis.lc.viewDetail' bundle='lcLabels' />');">
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

