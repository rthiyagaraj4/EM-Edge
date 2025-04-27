<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.IBADate,com.iba.framework.core.util.IBADateTime,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateValidation" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
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
		//AMRI-SCF-0679
		userPrefs.setDateFormat("dd/MM/yyyy") ;
		userPrefs.setTimeFormat("HH:mm");
		userPrefs.setLocale("en");
		//AMRI-SCF-0679
		String timepattrn=userPrefs.getTimeFormat();
		String sb=userPrefs.getDateFormat();
		String pattern=sb+" "+timepattrn;
	%>
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>

	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenRequest.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenIssue.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/eLC/RequestForLinen/js/tooltip.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>

	<script type="text/javascript"
		src='<%=request.getContextPath()%>/eLC/RequestForCleaningLinen/js/RequestForCleaningLinen.js'>
	</script>

	<script type="text/javascript">
	var pArgumentArray = new Array();
	pArgumentArray[0]=<%=request.getParameter("sourceCode")%>
	pArgumentArray[1]=<%=request.getParameter("requestNum")%>
	pArgumentArray[2]=<%=request.getParameter("requestDate")%>
	pArgumentArray[3]=<%=request.getParameter("linenHandedOverBy")%>
	pArgumentArray[4]=<%=request.getParameter("linenCollectedBy")%>
	pArgumentArray[5]=<%=request.getParameter("requestStatus")%>
	pArgumentArray[6]=<%=request.getParameter("sourceType")%>     
	pArgumentArray[7]=<%=request.getParameter("linenItem")%>
	pArgumentArray[8]=<%=request.getParameter("cancelledBy")%>
	pArgumentArray[9]=<%=request.getParameter("cancelledDate")%>
	pArgumentArray[10]=<%=request.getParameter("reasonCode")%>"
	
	var type1=pArgumentArray[6];
		type1=trimString(type1);
	var scode=pArgumentArray[0]
		scode=trimString(scode);
		//alert("<%=facilityId%>")
	LinenIssue.getSourceDesc("<%=locale%>","<%=facilityId%>",type1,scode,callBackDate);
	function callBackDate(data){
	for(prop in data)
		pArgumentArray[12]=data[prop];}

	IBADateValidator.convertDateJS(pArgumentArray[2],"en","<%=locale%>","<%=pattern%>",RDFromcallbackMethod);
	function  RDFromcallbackMethod(fdate){
						  pArgumentArray[13]=fdate;
		}


					

	function callModalWindow(title)
	{
		var retVal = new String();
		var dialogHeight = "30";
		var dialogWidth = "55";
		var status = "no";
	
		var dialogUrl = contextPath + "/RequestForCleaningLinenViewAction.do?title="+ title +"&vo.checkView=veiw&method=4&vo.placeCleaningLinenRequestVO.requestNum="+pArgumentArray[1]+"&vo.placeCleaningLinenRequestVO.sourceType="+pArgumentArray[6]+"&vo.placeCleaningLinenRequestVO.sourceCode="+pArgumentArray[0]+"&vo.placeCleaningLinenRequestVO.linenHandedOverBy="+pArgumentArray[3]+"&vo.placeCleaningLinenRequestVO.linenCollectedBy="+pArgumentArray[4]+"&vo.placeCleaningLinenRequestVO.requestStatus="+pArgumentArray[5]+"&vo.placeCleaningLinenRequestVO.linenItem="+pArgumentArray[7]+"&vo.placeCleaningLinenRequestVO.reasonCode="+pArgumentArray[10]
		var dialogArguments = pArgumentArray;
		var dialogFeatures = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + " ; scroll:yes; status:" + status;
		window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
		
	}
	
	
	</script>
</head>

<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
		<%
				String stat = (String)request.getParameter("requestStatus");
				String CN_Value[] = stat.split(" ");
				String statusSplit = CN_Value[1];
				if(statusSplit.equals("CN")||statusSplit.equals("DL")||statusSplit.equals("PD")){
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

