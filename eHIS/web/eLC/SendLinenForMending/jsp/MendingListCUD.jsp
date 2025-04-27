<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@  page import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateTime,com.iba.framework.core.util.IBADateValidation" %>
<%@ include file="/framework/html/Tag.text"%>

<ibaHTML:html locale="true">
<IBATagLibs:initCalendar />
<head>
	<%
			String facilityId=(String)session.getAttribute("facility_id");
			String functionId = (String) session.getAttribute("functionId");
			String moduleId = (String) session.getAttribute("moduleId");
			String loggedInUser = (String) session.getAttribute("login_user");
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
				String locale=userPrefs.getLocale();
				String PP=sb.substring(0,2);
				if(PP.compareToIgnoreCase("dd")==0)
				datepattrn="%d/%m/%y"+" "+tf;
				else if(PP.compareToIgnoreCase("MM")==0)
				datepattrn="%m/%d/%y"+" "+tf;
				else if(PP.compareToIgnoreCase("yy")==0)
				datepattrn="%y/%m/%d"+" "+tf;
				IBADateTime frmDate=LcDateFormat.getSevendaysBackDate(request);
				
				IBADateTime date = new IBADateTime(request.getSession().getId());
												
				IBADateValidation ibaDateValidation = new IBADateValidation();
				String cdate = ibaDateValidation.convertDateJS(date.toString(),"en",locale,pattern);
				String fdate = ibaDateValidation.convertDateJS(frmDate.toString(),"en",locale,pattern);
	%>

<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>

	<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LcDateFormat.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/SendLinenForMending/js/SendLinenForMending.js'>
	</script>
	<script>

	
function reqListSourceDescLookup(){
	var sourceType=document.getElementById("vo.criteriaItems[0].itemValue").value;
	var sourceDesc = document.QueryCriteriaForm["reqListSourceDesc"].value;
	if(sourceType != '' && sourceDesc != '')
		showLookup();
}

function requestListLookup(){
	var linenDesc = document.getElementById("linenDesc").value;
	if(linenDesc != '')
		showLookup1();
}

function showLookup1() {
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array(document.QueryCriteriaForm["languageId"].value);
	var datatypesArray = new Array();
	namesArray[0]="languageId"
	
	argArray[0] = "ehis.lc.lodgeComplaint.getlaundryLinen"
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = DESC_CODE;
	argArray[4] = DESC_LINK;
	argArray[5] = document.QueryCriteriaForm["linenDesc"].value;
	retArr = Lookup("LinenItemCode", argArray);
	var linenCode = document.QueryCriteriaForm["vo.criteriaItems[4].itemValue"];
	var linenDesc = document.QueryCriteriaForm["linenDesc"];
	if(retArr!=null){
		//Set the data in to the fields
		linenCode.value = retArr[0];
		linenDesc.value = retArr[1];
		}
}

function submitQuery(){
	var request_status = document.getElementById("vo.criteriaItems[3].itemValue").value;
	var flag=checkNull1();
	if(flag==true){
		var fromDate = document.getElementById("vo.criteriaItems[0].itemValue").value;
		var toDate = document.getElementById("vo.criteriaItems[1].itemValue").value;
		if(toDate !=""){
			IBADateValidator.isDateGreaterThanJS(fromDate,toDate,'en',callBackFunction);
			function callBackFunction(data){
				var error ="";
				var msgArray=new Array();
				if(data ==true)	{				
					getServerMessage("APP-LC00013");
					var message = dwrMessage;
					msgArray=message.split("#");
					getServerMessage("com.iba.ehis.lc.requestForLinen.requestDate");
					error = error + msgArray[0] + "To Date" +  " " + msgArray[1] + " "+dwrMessage + "<br>";
					parent.parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
					document.getElementById("vo.criteriaItems[1].itemValue").value="";
					document.getElementById("vo.criteriaItems[1].itemValue").setFocus;
				}else	{
					if(request_status == 'OS+PR'){
						document.getElementById("vo.functionId").value = 'LC_SEND_REQ_FOR_MENDING';
						document.QueryCriteriaForm.submit();
					}else	 if(request_status == 'ALL'){
						document.getElementById("vo.functionId").value = 'ALL_LC_SEND_REQ_FOR_MENDING';
						document.QueryCriteriaForm.submit();
					}else {
						document.getElementById("vo.functionId").value = 'LC_SEND_REQ_FOR_MENDING1';
						document.QueryCriteriaForm.submit();
					}
				}
			}
		}
	}
}
function getLoginUserPlaceLinen(){
		var userId ='<%=session.getAttribute("login_user")%>';
		RequestForCleaning.getLoggedInUser("<%=locale%>",userId,callLoggedInUserPlaceLinen);
	}

function callLoggedInUserPlaceLinen(data){
		for(prop in data){
		document.getElementById("vo.criteriaItems[3].itemValue").value = prop;
		}
	}

function setDate(){
	var d1=document.QueryCriteriaForm["vo.criteriaItems[6].itemValue"].value;
	LcDateFormat.converteThaiToIBADateTime(d1,"<%=locale%>","<%=pattern%>",getDate);
	}

function getDate(data){
	document.QueryCriteriaForm["vo.criteriaItems[0].itemValue"].value=data;
	var d2=document.QueryCriteriaForm["vo.criteriaItems[7].itemValue"].value;
	LcDateFormat.converteThaiToIBADateTime(d2,"<%=locale%>","<%=pattern%>",getDate1);
	}

function getDate1(data){
	document.QueryCriteriaForm["vo.criteriaItems[1].itemValue"].value=data;
 	}

</script>
</head>

<body onload="CurrDate1('R');getLoginUserPlaceLinen()" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<ibaHTML:form action="/QueryAction.do"	target="requestForMendingResult">
<br>
	<table border='0 ' cellpadding='2' cellspacing='0' width='80%' align='center' class='COMMON_TOOLBAR'>
		<tr>
			<tr>
				<td class='label'  nowrap="nowrap" align="right">
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestDate"	bundle="lcLabels" />
				</td>
			<td class='label' nowrap="nowrap" >
				<!-- <ibaHTML:IBACalendarInput property="vo.criteriaItems[6].itemValue" value="<%=fdate%>" format="<%=datepattrn%>"/>
				<ibaHTML:hidden property="vo.criteriaItems[0].itemValue" />
				<img src="framework/images/mandatory.gif"></img>
				<ibaHTML:hidden property="vo.criteriaItems[0].property" value="requestDate" /> -->

				<ibaHTML:text readonly="true" property="vo.criteriaItems[6].itemValue" value="<%=fdate%>" size="18" onblur="isValidDate(this)" onkeydown="assignDate(this,false);" onkeypress="assignDate(this,false);" /><a onclick="return showCal('vo.criteriaItems[6].itemValue', '%d/%m/%Y %H:%M', true, true,'cutOffTimeForLinenRecptid');" name='.cutOffTimeForLinenRecptid' id='cutOffTimeForLinenRecptid'><img src="<%=request.getContextPath()%>/framework/images/img.gif"></a><input type='hidden' name='vo.criteriaItems[6].pattern' id='vo.criteriaItems[6].pattern' value='dd/MM/yyyy HH:mm'>
				<ibaHTML:hidden property="vo.criteriaItems[0].itemValue" />
				<ibaHTML:hidden property="vo.criteriaItems[0].property" value="requestDate"/>
				<img src='framework/images/mandatory.gif'></img>			
			</td>
			<td class='label'  nowrap="nowrap" align="right">
					<ibaBean:message key="com.iba.ehis.lc.To"	bundle="lcLabels" />
			</td>
			<td class='label' nowrap="nowrap" >
				 <!-- <ibaHTML:IBACalendarInput property="vo.criteriaItems[7].itemValue"  value="<%=cdate%>" format="<%=datepattrn%>"/>
				 <ibaHTML:hidden property="vo.criteriaItems[1].itemValue" />
				 <ibaHTML:hidden property="vo.criteriaItems[1].property" value="toRequestDate" /> -->

				<ibaHTML:text readonly="true" property="vo.criteriaItems[7].itemValue" value="<%=cdate%>" size="18" onblur="isValidDate(this)" onkeydown="assignDate(this,false);" onkeypress="assignDate(this,false);" /><a onclick="return showCal('vo.criteriaItems[7].itemValue', '%d/%m/%Y %H:%M', true, true,'cutOffTimeForLinenRecptid');" name='.cutOffTimeForLinenRecptid' id='cutOffTimeForLinenRecptid'><img src="<%=request.getContextPath()%>/framework/images/img.gif"></a><input type='hidden' name='vo.criteriaItems[7].pattern' id='vo.criteriaItems[7].pattern' value='dd/MM/yyyy HH:mm'>
				<ibaHTML:hidden property="vo.criteriaItems[1].itemValue" />
				<ibaHTML:hidden property="vo.criteriaItems[1].property" value="toRequestDate"/>
				<img src='framework/images/mandatory.gif'></img>			
			</td>
			</tr>
			<tr >
			<td class='label'  align="right">
					<ibaBean:message key="com.iba.ehis.lc.agencyCode.agencyCode" bundle="lcLabels" />
			</td>
			<td class='label'>
				<input type="text" name="agencyDesc" id="agencyDesc" onblur="showLookup3()"  />
				 <ibaHTML:hidden property="vo.criteriaItems[2].itemValue" />
				 <ibaHTML:hidden property="vo.criteriaItems[2].property" value="agencyCode" />
				<input type='button' class="BUTTON"  value='?' onclick='showAgencyLookup1()' />
			</td>
			
			<td class='label'  nowrap="nowrap" align="right">
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestStatus"	bundle="lcLabels" />
			</td>
			
			<td class='label' >
				 <select name="vo.criteriaItems[3].itemValue" id="vo.criteriaItems[3].itemValue" >
				<option value="ALL"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.all" bundle="lcLabels" />
				</option>
				<option value="OS+PR"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.allPendingReq" bundle="lcLabels" />
				</option>
				<option value="OS" selected><ibaBean:message key="com.iba.ehis.lc.requestForLinen.outstanding" bundle="lcLabels" />
				</option>
				<option value="PR"><ibaBean:message key="com.iba.ehis.lc.deliverCleanedLinen.partiallydelivered" bundle="lcLabels" />
				</option>
				<option value="RE"><ibaBean:message key="com.iba.ehis.lc.deliverCleanedLinen.delivered" bundle="lcLabels" />
				</option>
				<option value="CN"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.cancelled" bundle="lcLabels" />
				</option>
				</select>
				 <ibaHTML:hidden property="vo.criteriaItems[3].property" value="requestStatus" />
			</td>
		</tr>
		<tr >
			<!-- <td class='label'  nowrap="nowrap" align="right">
				<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
			</td>
			<td class='label' colspan='3'>
				 <ibaHTML:hidden property="vo.criteriaItems[4].itemValue" />
				  <input type='text' name='linenDesc' id='linenDesc' onblur='requestListLookup();' />
				  <input type='button' class="BUTTON"  value='?' onclick='showLookup1()' />
				  <ibaHTML:hidden property="vo.criteriaItems[4].property" value="linnenItem" />
			</td> -->
		</tr>
		<tr>
			<td colspan='4'class='button' align='right'>
				<input type='button' class="BUTTON"  name="Search" id="Search" value="<ibaBean:message key='com.iba.ehis.lc.search' bundle='lcLabels' />" onmouseover="setDate()" onclick="submitQuery()" />
			</td>
			</tr>
		</table>
		
	<input type="hidden" name="vo.operatingFacilityId" id="vo.operatingFacilityId" value="<%=facilityId%>" />		
	<input type="hidden" name="languageId" id="languageId" value="<%=locale%>" />	
		<input type="hidden" name="vo.queryResultPage" id="vo.queryResultPage" value="SendLinenForMendingQueryResultPage" />					
		<ibaHTML:hidden property="vo.functionId"/>

		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
		<ibaHTML:hidden property="vo.mode" />
		<input type="hidden" name="vo.pageAction" id="vo.pageAction" value="SendLinenForMendingPageAction" />
		<ibaHTML:hidden property="method" value="<%=com.iba.ehis.core.util.AppConstants.QUERY%>" />
		<ibaHTML:hidden property="vo.viewCode" value="requestsListFrame"/>
	</ibaHTML:form>
</body>
</ibaHTML:html>

