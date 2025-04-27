<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.IBADate,com.iba.framework.core.util.IBADateTime,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateValidation"  contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.iba.framework.core.util.Constants" %>
<%@ page import="com.iba.ehis.core.vo.AppVO" %>
<%@ include file="/framework/html/Tag.text"%>
<ibaHTML:html locale="true">
<title><ibaBean:message
		key="com.iba.ehis.lc.requestForLinen.cancelDetail" bundle="lcLabels" />
</title>
<head>
	<%
			String facilityId = (String) session.getAttribute("facility_id");
			String functionId = (String) session.getAttribute("functionId");
			String moduleId = (String) session.getAttribute("moduleId");
			String addedById = (String) session.getAttribute("login_user");
			String locale = (String) session.getAttribute("LOCALE");
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";

			UserPreferences userPrefs =new UserPreferences();
			/* Cache cache = CacheManager.getCache();
			userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */
			
			String timepattrn=userPrefs.getTimeFormat();
			String sb=userPrefs.getDateFormat();
			String pattern=sb+" "+timepattrn;
	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
<script language="javascript" src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenRequest.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenIssue.js'></script>
	 <script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type="text/javascript"
		src='<%=request.getContextPath()%>/eLC/RequestForLinen/js/RequestForLinen.js'>
	</script>

	<script type="text/javascript">
	var pArgumentArray = new Array();
	pArgumentArray[0]= <%=request.getParameter("loanedToSourceType")%>
	pArgumentArray[1]= <%=request.getParameter("loanedToSourceCode")%>
	pArgumentArray[2]= <%=request.getParameter("sourceType")%>
	pArgumentArray[3]= <%=request.getParameter("sourceCode")%>
	pArgumentArray[4]= <%=request.getParameter("loanRefNum")%>
	
	var linkLoanDate = <%=request.getParameter("loanDate")%>
	IBADateValidator.convertDateJS(linkLoanDate,"en","<%=locale%>","dd/MM/yyyy HH:mm",callBackReqDate);
	function callBackReqDate(conDate){
	pArgumentArray[5]=conDate;
	}
	
	pArgumentArray[6]= <%=request.getParameter("givenBy")%>
	pArgumentArray[7]= <%=request.getParameter("receivedBy")%>
	pArgumentArray[8]=<%=request.getParameter("linenItem")%>     
	pArgumentArray[9]=<%=request.getParameter("reasonCode")%>
	pArgumentArray[10]=<%=request.getParameter("loanStatus")%>
	pArgumentArray[11]=<%=request.getParameter("remarks")%>"

	var sType=pArgumentArray[2];
		sType=trimString(sType);
		
	var scode=pArgumentArray[3];
		scode=trimString(scode);
		LinenIssue.getSourceDesc("<%=locale%>","<%=facilityId%>",sType,scode,callBackSourceDate);
	function callBackSourceDate(data){
	for(prop in data)
		pArgumentArray[12]=data[prop];
	}


	var loanType=pArgumentArray[0];
		loanType=trimString(loanType);
		
	var loanCode=pArgumentArray[1];
		loanCode=trimString(loanCode);
		
		LinenIssue.getSourceDesc("<%=locale%>","<%=facilityId%>",loanType,loanCode,callBackLoanDate);
	function callBackLoanDate(data){
	for(prop in data)
		pArgumentArray[13]=data[prop];}

	function callModalWindow(title)
	{
	
		var retVal = new String();
		var dialogHeight = "30";
		var dialogWidth = "45";
		var status = "no";
	
		var dialogUrl = contextPath + "/eLC/LoanLinen/jsp/ModalMessageFrames.jsp?title="+ title +"&vo.checkView=veiw&method=4&loanRefNum="+pArgumentArray[4]+"&givenBy="+pArgumentArray[6]+"&receivedBy="+pArgumentArray[7]+"&linenItem="+pArgumentArray[8]+"&reasonCode="+pArgumentArray[9]+"&requestStatus="+pArgumentArray[10]+"&loanedToSourceType="+pArgumentArray[0]+"&loanedToSourceCode="+pArgumentArray[1]+"&sourceType="+pArgumentArray[2]+"&sourceCode="+pArgumentArray[3]+"&remarks="+pArgumentArray[11]
		var dialogArguments = pArgumentArray;
		var dialogFeatures = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + " ; scroll=no; status:" + status;
			var val=window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
		if(val==true)
			parent.parent.window.frames[0].document.QueryCriteriaForm.submit();
		
	}
	
	
	</script>
</head>

<body>
	<table border='0' cellpadding='2' cellspacing='0' width='100%'
			align='center'>
			<%
				String stat = (String)request.getParameter("loanStatus");
				String CN_Value[] = stat.split(" ");
				String statusSplit = CN_Value[1];
				if(statusSplit.equals("CN")||statusSplit.equals("L")||statusSplit.equals("RE")){
			%>
		<tr>
				<td class="label">
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
				<td class='label'>
					<a href="#" onClick="return callModalWindow('<ibaBean:message	key="com.iba.ehis.lc.cancelDetail" bundle="lcLabels" />');">
					 <ibaBean:message	key="com.iba.ehis.lc.cancel" bundle="lcLabels" /> </a>
				</td>
			</tr>
			<tr>
				<td class="label">
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

