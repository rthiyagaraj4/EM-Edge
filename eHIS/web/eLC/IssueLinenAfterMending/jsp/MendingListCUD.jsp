<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateTime,com.iba.framework.core.util.IBADateValidation" pageEncoding="UTF-8"%>
<%@ include file="/framework/html/Tag.text"%>

<ibaHTML:html locale="true">
<head>
	<%
			String facilityId=(String)session.getAttribute("facility_id");
			String functionId = (String) session.getAttribute("functionId");
			String moduleId = (String)session.getAttribute("moduleId");
			String loggedInUser = (String) session.getAttribute("login_user");
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
				String cdate = ibaDateValidation.convertDateJS((date.getIBADate()).toString(),"en",locale,pattern);
				String fdate = ibaDateValidation.convertDateJS(frmDate.toString(),"en",locale,pattern);
	%>

	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LcDateFormat.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/IssueLinenAfterMending/js/IssueLinenAfterMending.js'></script>


		<script>



function showLookup() {
	var sourceType=document.QueryCriteriaForm["vo.criteriaItems[0].itemValue"].value;
	if(sourceType != ""){
		var facilityId=document.QueryCriteriaForm["vo.operatingFacilityId"].value;
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array(facilityId,document.getElementById("languageId").value);
		var datatypesArray = new Array();
		namesArray[0]="facilityId";
		namesArray[1]="languageId";
		if(sourceType=="W")
			argArray[0] = "ehis.lc.standardStock.nursingUnit"
		else if(sourceType=="C")
			argArray[0] = "ehis.lc.standardStock.clinic"
		else if(sourceType=="D")
			argArray[0] = "ehis.lc.standardStock.deptCode"
		
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
							
				//Display Order
		argArray[3] = DESC_CODE;

				// Link Description
		argArray[4] = DESC_LINK;
		argArray[5] = document.QueryCriteriaForm["sourceCodeDesc"].value;
		retArr = Lookup("SourceCode", argArray);
		var sourceCode = document.QueryCriteriaForm["vo.criteriaItems[1].itemValue"];
		var sourceCodeDesc = document.QueryCriteriaForm["sourceCodeDesc"];
		if(retArr!=null){
			//Set the data in to the fields
			sourceCode.value = retArr[0];
			sourceCodeDesc.value = retArr[1];
		}
	}
}		
function linenItemLookup(){
	var linenItemDesc = document.QueryCriteriaForm("linenItemDesc").value;
	if(linenItemDesc != "")
	showLookup1()
}
function showLookup1(){

	var argArray = new Array();
	var namesArray = new Array("languageId");
	var valuesArray = new Array(document.getElementById("languageId").value);
	var datatypesArray = new Array();
	
	argArray[0] = "ehis.lc.lodgeComplaint.getlaundryLinen"
		

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] =document.QueryCriteriaForm("linenItemDesc").value;
	retArr = Lookup("LinenItemCode", argArray);
	var linenItemObj = document.QueryCriteriaForm("vo.criteriaItems[5].itemValue");
	var linenItemDesc = document.QueryCriteriaForm("linenItemDesc");
	if(retArr!=null)
			{
			//Set the data in to the fields
			linenItemObj.value = retArr[0];
			linenItemDesc.value = retArr[1];
			}
	
}
function checkAlphaNum(){
		obj =  String.fromCharCode(window.event.keyCode);
	   	var alphaFilter =/^[a-z_A-Z_0-9]+$/;
	   	if (!(alphaFilter.test(obj))) { 
	   		getServerMessage("messages.AlphaNumeric");
	   		parent.window.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
	   		window.event.keyCode = 27;
   		}
   	   }  	
function checkNumber(){
	  	 	obj =  String.fromCharCode(window.event.keyCode);
	   		var alphaFilter =/^[0-9]+$/;
	   		if (!(alphaFilter.test(obj))) { 
		   	getServerMessage("message.Numbers.Allowed");
			parent.window.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
		   	window.event.keyCode = 27;
   		}
   	}
function submitQuery(){
	/*	var linenItemDesc = document.QueryCriteriaForm("linenItemDesc");
		if(linenItemDesc.value==""){
			document.QueryCriteriaForm("vo.criteriaItems[5].itemValue").value="";
		}*/
		var request_status = document.getElementById("vo.criteriaItems[4].itemValue").value;
		var flag=checkNull1();
		if(flag==true){
			var fromDate = document.getElementById("vo.criteriaItems[1].itemValue").value;
			var toDate = document.getElementById("vo.criteriaItems[2].itemValue").value;
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
						error = error + msgArray[0] + "To Date" +  " " + msgArray[1] + dwrMessage + "<br>";
						parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
						document.getElementById("vo.criteriaItems[2].itemValue").value="";
						document.getElementById("vo.criteriaItems[2].itemValue").setFocus;
					} else {
						if(request_status == 'OS+PR'){
							document.getElementById("vo.functionId").value = 'LC_SEND_REQ_FOR_MENDING';
							document.QueryCriteriaForm.submit();
						} else if(request_status == '') {
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
function convertEng()
{
 var tDate=document.QueryCriteriaForm["requestDate"].value;
 IBADateValidator.convertDateJS(tDate,'<%=locale%>','en','dd/MM/yyyy HH:mm',callBackMethod);
  function callBackMethod(data)
	{
	  var newTDate=data;
		document.QueryCriteriaForm("vo.criteriaItems[1].itemValue").value=newTDate;
		 var fDate=document.QueryCriteriaForm["toDate"].value;
		IBADateValidator.convertDateJS(fDate,'<%=locale%>','en','dd/MM/yyyy HH:mm',callBackMethod1);
		  function callBackMethod1(data1)
			{
			 var newFDate=data1;
			 document.QueryCriteriaForm("vo.criteriaItems[2].itemValue").value=newFDate;
			}
	}


}

</script>
<IBATagLibs:initCalendar />
</head>

<body onload="CurrDate('T');getLoginUserPlaceLinen()" OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onmouseover="convertEng()" >
	<ibaHTML:form action="/QueryAction.do"	target="issueOfMendingResult">
<br>
<table border='0 ' cellpadding='2' cellspacing='0' width='80%'
			align='center' >
						
			<tr>
				<td class='label'  nowrap="nowrap" align='right'>
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestDate"	bundle="lcLabels" />
				</td>
			<td class='label' nowrap="nowrap">
				<ibaHTML:text property="requestDate" value="<%=fdate%>" size="18" readonly="true" onkeydown="assignDate(this,false);" onkeypress="assignDate(this,false);" /><a onclick="return showCal('requestDate', '%d/%m/%Y %H:%M', true, true,'cutOffTimeForLinenRecptid');" name='.cutOffTimeForLinenRecptid' id='cutOffTimeForLinenRecptid'><img src="<%=request.getContextPath()%>/framework/images/img.gif"></a>
				<img src='framework/images/mandatory.gif'></img>			

				 <ibaHTML:hidden property="vo.criteriaItems[1].itemValue"   />
				 <input type='hidden' name='vo.criteriaItems[1].pattern' id='vo.criteriaItems[1].pattern' value='dd/MM/yyyy HH:mm'>
				 <ibaHTML:hidden property="vo.criteriaItems[1].property" value="requestDate"/> 
			</td>
			<td class='label'  nowrap="nowrap" align='right'>
					<ibaBean:message key="com.iba.ehis.lc.To"	bundle="lcLabels" />
			</td>
			<td class='label' nowrap="nowrap" >
				<ibaHTML:text property="toDate" value="<%=cdate%>" size="18" readonly="true" onkeydown="assignDate(this,false);" onkeypress="assignDate(this,false);" /><a onclick="return showCal('toDate', '%d/%m/%Y %H:%M', true, true,'cutOffTimeForLinenRecptid');" name='.cutOffTimeForLinenRecptid' id='cutOffTimeForLinenRecptid'><img src="<%=request.getContextPath()%>/framework/images/img.gif"></a>
					<ibaHTML:hidden property="vo.criteriaItems[2].itemValue"  />
					<input type='hidden' name='vo.criteriaItems[2].pattern' id='vo.criteriaItems[2].pattern' value='dd/MM/yyyy HH:mm'>
					<ibaHTML:hidden property="vo.criteriaItems[2].property" value="toRequestDate"/>
			</td>
		</tr>
					<tr>
						<td class='label'  nowrap="nowrap" align='right'>
							<ibaBean:message key="com.iba.ehis.lc.requestForLinen.raisedBy"	bundle="lcLabels" />
						</td>
						<td class='label'>
							 <ibaHTML:text property="vo.criteriaItems[3].itemValue"  />
							 <ibaHTML:hidden property="vo.criteriaItems[3].property" value="raisedBy" />
						</td>
						<td class='label'  nowrap="nowrap" align='right'>
								<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestStatus"	bundle="lcLabels" />
						</td>
						<td class='label'>
							 <select name="vo.criteriaItems[4].itemValue" id="vo.criteriaItems[4].itemValue" >
							<option value=""><ibaBean:message key="com.iba.ehis.lc.requestForLinen.all" bundle="lcLabels" />
							</option>
							<option value="OS+PR"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.allPendingReq" bundle="lcLabels" />
							</option>
							<option value="OS"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.outstanding" bundle="lcLabels" />
							</option>
							<option value="PR"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.partiallyissued" bundle="lcLabels" />
							</option>
							<option value="RE"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.issued" bundle="lcLabels" />
							</option>
							<option value="CN"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.cancelled" bundle="lcLabels" />
							</option>
							</select>
							 <ibaHTML:hidden property="vo.criteriaItems[4].property" value="requestStatus" />
						</td>
					</tr>
					<!-- <tr>
						<td class='label'  nowrap="nowrap" align='right'>
							<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
						</td>
						<td class='label' colspan='3'>
							<ibaHTML:hidden property="vo.criteriaItems[5].itemValue" onkeyup="setFieldsToUpperCase(this)" onkeypress="return checkAlphaNum()" />
							<input type=text name="linenItemDesc" id="linenItemDesc" onblur="linenItemLookup();"/>
							<input type='button' class="BUTTON"  value='?' onclick='showLookup1()' />
							<ibaHTML:hidden property="vo.criteriaItems[5].property" value="linnenItem" />
						</td>
					</tr> -->
					<tr>
						<td colspan='4'class='button' align='right'>
							<input type='button' class="BUTTON"  name="Search" id="Search" value="<ibaBean:message key='com.iba.ehis.lc.search' bundle='lcLabels' />" onclick="submitQuery()" />
						</td>
					</tr>
			</table>
		
		<input type="hidden" name="vo.operatingFacilityId" id="vo.operatingFacilityId" value="<%=facilityId%>" />		
		<input type="hidden" name="languageId" id="languageId" value="<%=locale%>" />
		<input type="hidden" name="vo.queryResultPage" id="vo.queryResultPage" value="IssueOfLinenAfterMendingQueryResultPage" />					
		<ibaHTML:hidden property="vo.functionId"/>
		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
		<ibaHTML:hidden property="vo.mode" />
		<input type="hidden" name="vo.pageAction" id="vo.pageAction" value="IssueOfLinenAfterMendingPageAction" />
		<ibaHTML:hidden property="method" value="<%=new Integer(com.iba.ehis.core.util.AppConstants.QUERY).toString()%>" />
		<!--  modified By DhanasekarV for weblogic server -->

	</ibaHTML:form>
</body>
</ibaHTML:html>

