<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADateTime" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.ehis.lc.core.vo.SourceBean"%>
<%@ include file="/framework/html/Tag.text"%>

<ibaHTML:html locale="true">
<head>
	<%
			String facilityId=(String)session.getAttribute("facility_id");
			String loggedInUser = (String) session.getAttribute("login_user");
			String functionId = (String) session.getAttribute("functionId");
			String moduleId = (String) session.getAttribute("moduleId");
			String locale = (String) session.getAttribute("LOCALE");
			String userFlag=(String)request.getParameter("userFlag");

			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";

		UserPreferences userPrefs =new UserPreferences();
/* 		Cache cache = CacheManager.getCache();
		userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */
		//AMRI-SCF-0679
		userPrefs.setDateFormat("dd/MM/yyyy") ;
		userPrefs.setTimeFormat("HH:mm");
		userPrefs.setLocale("en");
		//AMRI-SCF-0679
		String timepattrn=userPrefs.getTimeFormat();
		String sb=userPrefs.getDateFormat();
		String pattern=sb+" "+timepattrn;

		IBADateTime date = new IBADateTime(request.getSession().getId());

		String currentDate=date.toString();
		
		  SourceBean obj=new SourceBean();
		try
		{
			obj=(SourceBean)CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,"sessid", "objKey");
									
		}catch(Exception e){} 

		String src=obj.getSource();
		String srcType=obj.getSourceType();
		String srctype=obj.getSourcetype();
		String srcCode=obj.getSourceCode();
											
	
	%>

<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
		<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/eLC/RequestForCleaningLinen/js/RequestForCleaningLinen.js"></script>

<script>

function getLoginUserPlaceLinen(){
		var userId ='<%=session.getAttribute("login_user")%>';
		RequestForCleaning.getLoggedInUser("<%=locale%>",userId,callLoggedInUserPlaceLinen);
	}
	function callLoggedInUserPlaceLinen(data){
		for(prop in data){
			document.getElementById("vo.criteriaItems[4].itemValue").value = prop;
		}
}

function showLookup() {
	var sourceType=document.QueryCriteriaForm["vo.criteriaItems[0].itemValue"].value;
	document.QueryCriteriaForm["vo.criteriaItems[1].itemValue"].value="";
	var facilityId=document.QueryCriteriaForm["vo.operatingFacilityId"];
	var languageId=document.getElementById("languageId").value;
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array(facilityId,languageId);
	var datatypesArray = new Array();
	if(sourceType=="W")
		{	argArray[0] = "ehis.lc.standardStock.nursingUnit"
		   // namesArray[0]=facilityId.value;
		}
		else if(sourceType=="C")
		{
			argArray[0] = "ehis.lc.standardStock.clinic"
		}
		else if(sourceType=="D")
		{	argArray[0] = "ehis.lc.standardStock.deptCode"
		}
		else 	argArray[0] = "ehis.lc.standardStock.nursingUnit"

	  namesArray[0]=facilityId.value;
	  namesArray[1]="languageId";
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] =document.QueryCriteriaForm["sourceDesc"].value;
	retArr = Lookup("SourceCode", argArray);
	var txtUser = document.QueryCriteriaForm["vo.criteriaItems[1].itemValue"];
	var txtUser1 = document.QueryCriteriaForm["sourceDesc"];
	if(retArr!=null)
			{
			//Set the data in to the fields
			txtUser.value = retArr[0];
			txtUser1.value = retArr[1];
			}
	
}


function showLookup1() {

	var sourceType=document.getElementById("vo.criteriaItems[0].itemValue").value;
	var sourceCode=document.getElementById("vo.criteriaItems[1].itemValue").value;
	var languageId=document.getElementById("languageId").value;

	document.QueryCriteriaForm("vo.criteriaItems[6].itemValue").value="";

	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	
	argArray[0] = "ehis.lc.standardStock.linenItem"
	

	namesArray[0]="languageId";


	valuesArray[0]=languageId;

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] =document.QueryCriteriaForm("linenDesc").value
	retArr = Lookup("LinenItemCode", argArray);
	var txtUser = document.QueryCriteriaForm("vo.criteriaItems[6].itemValue");
	var txtUser1 = document.QueryCriteriaForm("linenDesc");
	if(retArr!=null)
			{
			//Set the data in to the fields
			txtUser.value = retArr[0];	
			txtUser1.value = retArr[1];
			}
	
}

function submitQuery()
{
	/*	var linenDesc = document.QueryCriteriaForm("linenDesc");
		if(linenDesc.value==""){
			document.QueryCriteriaForm("vo.criteriaItems[6].itemValue").value="";
		} */
		var request_status = document.getElementById("vo.criteriaItems[5].itemValue").value;
		if(checkNull1()){
			var fromDate = document.getElementById("vo.criteriaItems[2].itemValue").value;
			var toDate = document.getElementById("vo.criteriaItems[3].itemValue").value;
	
			if(toDate !=""){
				var locale=document.getElementById("languageId").value;
				IBADateValidator.isDateGreaterThanJS(fromDate,toDate,locale,callBackFunction);
				function callBackFunction(data){
					var error ="";
					var msgArray=new Array();
					if(data ==true)	{				
						getServerMessage("APP-LC00012");
						var message = dwrMessage;
						msgArray=message.split("#");
						getServerMessage("com.iba.ehis.lc.todate");
						var toDAte=dwrMessage;
						getServerMessage("com.iba.ehis.lc.requestForLinen.requestDate");
						error = error + msgArray[0] + dwrMessage +  " " + msgArray[1] + ""+toDAte+ "<br>";
						
						parent.parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
						document.getElementById("vo.criteriaItems[3].itemValue").value="";
						document.getElementById("vo.criteriaItems[3].itemValue").setFocus;
					} else	{
					if(request_status == 'OS+PD'){
						document.getElementById("vo.functionId").value = 'REQ_FOR_CLEANING';
						document.QueryCriteriaForm.submit();
					}else{
						document.getElementById("vo.functionId").value = 'LC_REQ_FOR_CLEANING_LINEN';
						document.QueryCriteriaForm.submit();
						}
					}
				}
			}
		}
}


function CurrDate(arg){	
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
		if(hrNow<10)
				hrNow="0"+hrNow;
		if(mnNow<10)
				mnNow="0"+mnNow;
		var convert1= date + "/" + mon + "/" + year;
			convert1=convert1+" "+hrNow+ ":" +mnNow;
		
		var seven = 1000 * 60 * 60 * 24 * 7;
		var reqFromCurrDate = new Date(currDate - seven);
		var fromDate = reqFromCurrDate.getDate();
		var fromMonth = reqFromCurrDate.getMonth();
		fromMonth = fromMonth+1;
		var fromYear = reqFromCurrDate.getYear();
		if(fromDate <10)
			fromDate = "0"+fromDate;
		if(fromMonth <10)
			fromMonth = "0"+fromMonth;
		var reqFromDate= fromDate + "/" + fromMonth + "/" + fromYear;
			reqFromDate=reqFromDate+" "+hrNow+ ":" +mnNow;
	
		if(arg=='Y')
		{
			document.getElementById("vo.criteriaItems[2].itemValue").value=reqFromDate;
			IBADateValidator.convertDateJS(reqFromDate,"en","<%=locale%>","<%=pattern%>",RDFromcallbackMethod);
					function  RDFromcallbackMethod(fdate){
						document.getElementById("requestDate").value=fdate;
			}

			var rdate=document.getElementById("vo.criteriaItems[3].itemValue");
			rdate.value=convert1;
			IBADateValidator.convertDateJS(convert1,"en","<%=locale%>","<%=pattern%>",RDTocallbackMethod);
			function  RDTocallbackMethod(tdate){
				document.getElementById("toRequestDate").value=tdate;
			
			}
		}
}


function setSourceType(){
	var src= document.getElementById("sourceType").value;
	if(src=="Nursing Unit" || src=="th Nursing Unit")
		document.getElementById("vo.criteriaItems[0].itemValue").value='W';
		document.getElementById("vo.criteriaItems[1].itemValue").value='<%=srcCode%>';
	if(src=="Clinic" || src=="th Clinic")
		document.getElementById("vo.criteriaItems[0].itemValue").value='C';
		document.getElementById("vo.criteriaItems[1].itemValue").value='<%=srcCode%>';
	if(src=="Department" || src=="th Department")
		document.getElementById("vo.criteriaItems[0].itemValue").value='D';
		document.getElementById("vo.criteriaItems[1].itemValue").value='<%=srcCode%>';
}


</script>
<IBATagLibs:initCalendar />
</head>

<body onload="CurrDate('Y');getLoginUserPlaceLinen();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<ibaHTML:form action="/QueryAction.do"	target="pendingCountResult">
<br>
<table border='0 ' cellpadding='2' cellspacing='0' width='80%'
			align='center' class='COMMON_TOOLBAR'>
			<tr>
							<td align='right' width="30%" CLASS='label' nowrap="nowrap">
								<ibaBean:message
									key="com.iba.ehis.lc.standardStock.sourceType"
									bundle="lcLabels" />
							</td>
							<td width="30%">
							<ibaLogic:equal value="Y" scope="request" parameter="userFlag"> 
							<select name="vo.criteriaItems[0].itemValue" id="vo.criteriaItems[0].itemValue">
								<option value="W"><ibaBean:message key="com.iba.ehis.lc.ward" bundle="lcLabels" />
								</option>
								<option value="C"><ibaBean:message key="com.iba.ehis.lc.clinic" bundle="lcLabels" />
								</option>
								<option value="D"><ibaBean:message key="com.iba.ehis.lc.department" bundle="lcLabels" />
								</option>
							</select>
						</ibaLogic:equal>   
						<ibaLogic:equal value="N" scope="request" parameter="userFlag"> 
							 <input type=text name="sourceType" id="sourceType" maxlength="10" readonly="true" value="<%=srcType%>"/> 
							 <ibaHTML:hidden property="vo.criteriaItems[0].itemValue" value="<%=srctype%>"/>
						</ibaLogic:equal> 	
							<ibaHTML:hidden property="vo.criteriaItems[0].property" value="sourceType" />

							</td>
						
							<td align='right' width="20%" CLASS='label' nowrap="nowrap">
								<ibaBean:message
									key="com.iba.ehis.lc.standardStock.source"
									bundle="lcLabels" />
							</td>
							<td width="40%" nowrap="nowrap" >

							<ibaLogic:equal value="N" scope="request" parameter="userFlag"> 
								<input type=text name="sourceCode" id="sourceCode" maxlength="10" readonly="true" value="<%=src%>"/>
								<ibaHTML:hidden property="vo.criteriaItems[1].itemValue" value="<%=srcCode%>"/>
							</ibaLogic:equal>
							<ibaLogic:equal value="Y" scope="request" parameter="userFlag"> 
								<input type="text" name="sourceDesc" id="sourceDesc" maxlength="30" />
								<input type='button' class="BUTTON"  value='?' onclick='showLookup()' />
								<ibaHTML:hidden property="vo.criteriaItems[1].itemValue"/>
							 </ibaLogic:equal>
							<ibaHTML:hidden property="vo.criteriaItems[1].property" value="sourceCode" />
							</td>
						</tr>
						<tr>
						<td class='label'  nowrap="nowrap" align='right'>
								<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestDate"	bundle="lcLabels" />
						</td>
						<td class='label' nowrap="nowrap">
							<input type="text" readonly onblur="isValidDate(this)" name="requestDate" id="requestDate" value=""><a onclick="return showCal('requestDate', '%d/%m/%Y %H:%M', false, true,'itemValueid');" name='.itemValueid' id='itemValueid'><img src="<%=request.getContextPath()%>/framework/images/img.gif"></a><input type='hidden' name='vo.criteriaItems[2].itemValue.pattern' id='vo.criteriaItems[2].itemValue.pattern' value='%d/%m/%Y %H:%M'>
							  <ibaHTML:hidden property="vo.criteriaItems[2].itemValue" />
							  <ibaHTML:hidden property="vo.criteriaItems[2].property" value="requestDate"/>
							 <img src="framework/images/mandatory.gif"></img>


						</td>
						<td class='label'  nowrap="nowrap" align='right'>
								<ibaBean:message key="com.iba.ehis.lc.To"	bundle="lcLabels" />
						</td>
						<td class='label' >
							<input type="text" readonly name="toRequestDate" id="toRequestDate" value="" onblur="isValidDate(this)"><a onclick="return showCal('toRequestDate', '%d/%m/%Y %H:%M', false, true,'itemValueid');" name='.itemValueid' id='itemValueid'><img src="<%=request.getContextPath()%>/framework/images/img.gif"></a><input type='hidden' name='vo.criteriaItems[3].itemValue.pattern' id='vo.criteriaItems[3].itemValue.pattern' value='%d/%m/%Y %H:%M'>
							<!-- <ibaHTML:IBACalendarInput property="vo.criteriaItems[3].itemValue" format="%d/%m/%Y %H:%M" />-->
							 <ibaHTML:hidden property="vo.criteriaItems[3].itemValue" />
							 <ibaHTML:hidden property="vo.criteriaItems[3].property" value="toRequestDate"/>
						</td>
						</tr>
						<tr >
						<td class='label'  nowrap="nowrap" align='right'>
								<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.linenHandedOverBy"	bundle="lcLabels" />
						</td>
						<td class='label'>
							 <ibaHTML:text property="vo.criteriaItems[4].itemValue" maxlength="30" />
							 <ibaHTML:hidden property="vo.criteriaItems[4].property" value="linenHandedOverBy"  />
						</td>
						<td class='label'  nowrap="nowrap" align='right'>
								<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.linenCollectedBy"	bundle="lcLabels" />
						</td>
						<td class='label'>
							 <ibaHTML:text property="vo.criteriaItems[4].itemValue" onkeypress="checkAlpha()" maxlength="30" />
							 <ibaHTML:hidden property="vo.criteriaItems[4].property" value="linenCollectedBy" />
						</td>
						
						</tr>
						<tr >
						<td class='label'  nowrap="nowrap" align='right'>
								<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestStatus"	bundle="lcLabels" />
						</td>
						<td class='label'>
							 <select name="vo.criteriaItems[5].itemValue" id="vo.criteriaItems[5].itemValue" >
							<option value=""><ibaBean:message key="com.iba.ehis.lc.requestForLinen.all" bundle="lcLabels" />
							</option>
							<option value="OS+PD" selected><ibaBean:message key="com.iba.ehis.lc.requestForLinen.allPendingReq" bundle="lcLabels" />
							</option>
							<option value="OS"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.outstanding" bundle="lcLabels" />
							</option>
							<option value="PD"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.partiallyissued" bundle="lcLabels" />
							</option>
							<option value="DL"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.issued" bundle="lcLabels" />
							</option>
							<option value="CN"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.cancelled" bundle="lcLabels" />
							</option>
							</select>
							 <ibaHTML:hidden property="vo.criteriaItems[5].property" value="requestStatus" />
						</td>
						<td class='label'  nowrap="nowrap"  align='right'>
								<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
						</td>
						<td class='label' nowrap="nowrap">
							<input type="text" name="linenDesc" id="linenDesc" maxlength="30" onblur="setClearLinenDesc();"/>
							 <ibaHTML:hidden property="vo.criteriaItems[6].itemValue" onkeyup="setFieldsToUpperCase(this)" onkeypress="return checkAlphaNum()" /><input type='button' class="BUTTON"  value='?' onclick='showLookup1()' />
							  <ibaHTML:hidden property="vo.criteriaItems[6].property" value="linenItem" />

							  <ibaHTML:hidden property="vo.criteriaItems[9].property" value="category" />
							  <ibaHTML:hidden property="vo.criteriaItems[9].itemValue" value="D"/>
							  <ibaHTML:hidden property="vo.criteriaItems[10].property" value="countConfirmedYn" /> 
							  <ibaHTML:hidden property="vo.criteriaItems[10].itemValue" value="N"/>
							  
						</td>
						</tr>
						<tr>
						<td colspan='4'class='button' align='right'>
						<input type='button' class="BUTTON"  name="Search" id="Search" value="<ibaBean:message key="com.iba.ehis.lc.search" bundle="lcLabels" />" onmouseover="convertDateToEn()" onclick="submitQuery()" />
						</td>
						</tr>
		</table>
		
		<ibaHTML:hidden property="vo.operatingFacilityId" value="<%=facilityId%>" />
		<input type="hidden" name="vo.queryResultPage" id="vo.queryResultPage" value="PendingCountQueryResultPage" />					
			<ibaHTML:hidden property="vo.functionId"  />
		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
		<input type="hidden" name="languageId" id="languageId" value="<%=locale%>" />
		<input type="hidden" name="logInUser" id="logInUser" value="<%=loggedInUser%>" />
		<input type="hidden" name="sourceCode" id="sourceCode" value="<%=srcCode%>" />
		<ibaHTML:hidden property="vo.mode" />
		<input type="hidden" name="vo.pageAction" id="vo.pageAction" value="PendingCountPageAction" />
		<ibaHTML:hidden property="method" value="<%=new Integer(com.iba.ehis.core.util.AppConstants.QUERY).toString()%>" />
			<!--  Modify by DhanasekarV for weblogic -->
		<ibaHTML:hidden property="vo.viewCode" value="pendingCount"/>
	</ibaHTML:form>
</body>
</ibaHTML:html>

