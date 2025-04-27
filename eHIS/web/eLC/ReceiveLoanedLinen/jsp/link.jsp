<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateTime" pageEncoding="ISO-8859-1"%>
<%@ page  import="com.iba.ehis.core.vo.AppVO" %>
<%@ include file="/framework/html/Tag.text" %>
<ibaHTML:html locale="true">

<head>
	<%
			String facilityId = (String) session.getAttribute("facility_id");
			String functionId = (String) session.getAttribute("functionId");
			String moduleId = (String) session.getAttribute("moduleId");
			String addedById = (String) session.getAttribute("login_user");
			String locale = (String) session.getAttribute("LOCALE");

			//String login_user = (String) session.getAttribute("login_user");
			session.setAttribute("loanStatus",request.getParameter("loanStatus"));
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
				UserPreferences userPrefs =new UserPreferences();
				/* Cache cache = CacheManager.getCache();
				userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */
				String datepattrn=userPrefs.getDateFormat();
				String sb=userPrefs.getDateFormat();
				String tf=userPrefs.getTimeFormat();
				String pattern=sb+" "+tf;
				

	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/eLC/ReceiveLoanedLinen/js/tooltip.js"></script> 
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/ReceiveLoanedLinen/js/ReceiveLoanedLinen.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenIssue.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenRequest.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type="text/javascript">
	
	
	var pArgumentArray = new Array();
	pArgumentArray[0]=<%=request.getParameter("reasonForLoan")%>
	pArgumentArray[1]= <%=request.getParameter("loanedToSourceType")%>
	pArgumentArray[2]= <%=request.getParameter("loanedToSourceCode")%>
	pArgumentArray[3]= <%=request.getParameter("sourceType")%>
	pArgumentArray[4]= <%=request.getParameter("sourceCode")%>
	pArgumentArray[5]= <%=request.getParameter("loanRefNum")%>
	pArgumentArray[6]= <%=request.getParameter("loanDate")%>
	pArgumentArray[7]= <%=request.getParameter("givenBy")%>
	pArgumentArray[8]= <%=request.getParameter("receivedBy")%>
	//		pArgumentArray[9]= <%=request.getParameter("linenDesc")%>
	pArgumentArray[9]=<%=request.getParameter("linenItem")%>     
	pArgumentArray[11]=<%=request.getParameter("loanStatus")%>
	pArgumentArray[12]=<%=request.getParameter("reasonForLoan")%>
	pArgumentArray[13]=<%=request.getParameter("receivedBackBy")%>
	pArgumentArray[14]=<%=request.getParameter("receivedWriteOff")%>
	pArgumentArray[15]=<%=request.getParameter("remarks")%>
	pArgumentArray[16]=<%=request.getParameter("loanQty")%>
	pArgumentArray[17]=<%=request.getParameter("receivedQty")%>
	pArgumentArray[21]= <%=request.getParameter("linenDesc")%>
		
	
	var sType=pArgumentArray[3];
		sType=trimString(sType);
		
	var scode=pArgumentArray[4];
		scode=trimString(scode);
	LinenIssue.getSourceDesc("<%=locale%>","<%=facilityId%>",sType,scode,callBackSourceDate);
	function callBackSourceDate(data){
	for(prop in data)
		pArgumentArray[18]=data[prop];
	}


	var loanType=pArgumentArray[1];
		loanType=trimString(loanType);
		
	var loanCode=pArgumentArray[2];
		loanCode=trimString(loanCode);
		
	LinenIssue.getSourceDesc("<%=locale%>","<%=facilityId%>",loanType,loanCode,callBackLoanDate);
	function callBackLoanDate(data){
	for(prop in data)
		pArgumentArray[19]=data[prop];
	}
	
	IBADateValidator.convertDateJS(pArgumentArray[6],"en","<%=locale%>","<%=pattern%>",RDFromcallbackMethod);
	function  RDFromcallbackMethod(fdate){
		pArgumentArray[20]=fdate;
	}


	function callModalWindowView(title){
			
		var retVal = new String();
		var dialogHeight = "30";
		var dialogWidth = "45";
		var status = "no";
		var view = "view";
		var dialogUrl = contextPath + "/ReceiveLoanedLinenViewAction.do?title="+ title+"&vo.checkView=view&method=4&vo.receiveLoanedLinenVO.reasonforLoan="+pArgumentArray[0]+"&vo.receiveLoanedLinenVO.loanedToSourceType="+pArgumentArray[1]+"&vo.receiveLoanedLinenVO.loanedToSourceCode="+pArgumentArray[2]+"&vo.receiveLoanedLinenVO.sourceType="+pArgumentArray[3]+"&vo.receiveLoanedLinenVO.sourceCode="+pArgumentArray[4]+"&vo.receiveLoanedLinenVO.loanRefNum="+pArgumentArray[5]+"&vo.receiveLoanedLinenVO.loanDate="+pArgumentArray[6]+"&vo.receiveLoanedLinenVO.loanDate.pattern=<%=pattern%>&vo.receiveLoanedLinenVO.givenBy="+pArgumentArray[7]+"&vo.receiveLoanedLinenVO.receivedBy="+pArgumentArray[8]+"&vo.receiveLoanedLinenVO.linenItem="+pArgumentArray[9]+"&vo.receiveLoanedLinenVO.loanStatus="+pArgumentArray[11]+"&vo.receiveLoanedLinenVO.reasonForLoan="+pArgumentArray[12]+"&vo.receiveLoanedLinenVO.receivedBackBy="+pArgumentArray[13]+"&vo.receiveLoanedLinenVO.receivedWriteOff="+pArgumentArray[14]+"&vo.receiveLoanedLinenVO.remarks="+pArgumentArray[15]+"&vo.addedFacilityId=<%=facilityId%>"
		var dialogArguments = pArgumentArray;
		var dialogFeatures = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + " ; scroll=no; status:" + status;
		window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
	}
	
	function callModalWindowReceive(title){
		var retVal = new String();
		var dialogHeight = "37";
		var dialogWidth = "50";
		var status = "no";
		var view = "receive";
		var dialogUrl = contextPath + "/eLC/ReceiveLoanedLinen/jsp/ModalMessageFrames.jsp?title="+ title+"&vo.checkView=receive&method=4&vo.receiveLoanedLinenVO.reasonforLoan="+pArgumentArray[0]+"&vo.receiveLoanedLinenVO.loanedToSourceType="+pArgumentArray[1]+"&vo.receiveLoanedLinenVO.loanedToSourceCode="+pArgumentArray[2]+"&vo.receiveLoanedLinenVO.sourceType="+pArgumentArray[3]+"&vo.receiveLoanedLinenVO.sourceCode="+pArgumentArray[4]+"&vo.receiveLoanedLinenVO.loanRefNum="+pArgumentArray[5]+"&vo.receiveLoanedLinenVO.loanDate="+pArgumentArray[6]+"&vo.receiveLoanedLinenVO.loanDate.pattern=<%=pattern%>&vo.receiveLoanedLinenVO.givenBy="+pArgumentArray[7]+"&vo.receiveLoanedLinenVO.receivedBy="+pArgumentArray[8]+"&vo.receiveLoanedLinenVO.linenItem="+pArgumentArray[9]+"&vo.receiveLoanedLinenVO.loanStatus="+pArgumentArray[11]+"&vo.receiveLoanedLinenVO.reasonForLoan="+pArgumentArray[12]+"&vo.receiveLoanedLinenVO.receivedBackBy="+pArgumentArray[13]+"&vo.receiveLoanedLinenVO.receivedWriteOff="+pArgumentArray[14]+"&vo.receiveLoanedLinenVO.remarks="+pArgumentArray[15]+"&vo.receiveLoanedLinenVO.loanQty="+pArgumentArray[16]+"&vo.receiveLoanedLinenVO.receivedQty="+pArgumentArray[17]+"&vo.addedFacilityId=<%=facilityId%>"
		var dialogArguments = pArgumentArray;
		var dialogFeatures = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + " ; scroll=no; status:" + status;
		var val=window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
		if(val==true)
			parent.parent.window.frames[0].document.QueryCriteriaForm.submit();
		
	}
		
	</script>
	
</head>

<body>
	<ibaBean:define id="status" scope="session" name="loanStatus" ></ibaBean:define>
	<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
		
		<%
			String stat = (String)session.getAttribute("loanStatus");
			String CN_Value[] = stat.split(" ");
			String statusSplit = CN_Value[1];
		//	out.println("status:"+statusSplit);
		//	String statusSplit = "OS";
			if(statusSplit.equals("OS")){
		%>
				
		<tr>
			<td class="label">
				<a href="#"	onClick="return callModalWindowView('<ibaBean:message	key="com.iba.ehis.lc.viewDetail" bundle="lcLabels" />');">
					<ibaBean:message key="com.iba.ehis.lc.view" bundle="lcLabels" />
				</a>
			</td>
		</tr>
		<tr>
			<td class='label'>
				<a href="#" onClick="return callModalWindowReceive('<ibaBean:message key="com.iba.ehis.lc.receive/writeOffDetail" bundle="lcLabels" />');">
				 <ibaBean:message	key="com.iba.ehis.lc.receive/writeOff" bundle="lcLabels" /> </a>
			</td>
		</tr>
		
		<%
			} 
		else{%>
			<tr>
			<td class="label">
				<a href="#"	onClick="return callModalWindowView('<ibaBean:message	key="com.iba.ehis.lc.viewDetail" bundle="lcLabels" />');">
					<ibaBean:message key="com.iba.ehis.lc.view" bundle="lcLabels" />
				</a>
			</td>
		</tr>
		<tr>
			<td height="15" >
				
			</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</ibaHTML:html>

