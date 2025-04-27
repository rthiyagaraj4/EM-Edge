<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateTime,com.iba.framework.core.util.IBADateValidation" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/framework/html/Tag.text"%>

<ibaHTML:html locale="true">
<head>
	<%
	String facilityId=(String)session.getAttribute("facility_id");
	String functionId = (String) session.getAttribute("functionId");
	String moduleId = (String) session.getAttribute("moduleId");
	String locale = (String) session.getAttribute("LOCALE");
	String loggedInUser = (String) session.getAttribute("login_user");
	String sourceDesc= (String) request.getParameter("sourceDesc");
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			
		
	if (sStyle == null)
		sStyle = "IeStyle.css";
		String qryEven = "QRYEVEN";
		String qryOdd = "QRYODD";
		UserPreferences userPrefs =new UserPreferences();
		//AMRI-SCF-0679
			userPrefs.setDateFormat("dd/MM/yyyy") ;
			userPrefs.setTimeFormat("HH:mm");
			userPrefs.setLocale("en");
			//AMRI-SCF-0679
		/*Cache cache = CacheManager.getCache(); 
		userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */ //Commented Against AMRI-SCF-0679
		String datepattrn=userPrefs.getDateFormat();
		String sb=userPrefs.getDateFormat();
		String tf=userPrefs.getTimeFormat();
		String pattern=sb+" "+tf;
		
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
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenRequest.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/eLC/DeliverCleanedLinen/js/DeliverCleanedLinen.js"></script>

<script>
	function showLookup() {
		var sourceType=document.QueryCriteriaForm["vo.criteriaItems[0].itemValue"].value;

		var facilityId=document.QueryCriteriaForm["vo.operatingFacilityId"];
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		
		namesArray[1]="languageId";
		valuesArray[1]="<%=locale%>";
		
		if(sourceType=="W"){
				argArray[0] = "ehis.lc.standardStock.nursingUnit"
				namesArray[0]="facilityId";
				valuesArray[0]=facilityId.value;
			}else if(sourceType=="C"){
				argArray[0] = "ehis.lc.standardStock.clinic"
				namesArray[0]="facilityId";
				valuesArray[0]=facilityId.value;
			}else if(sourceType=="D"){
				argArray[0] = "ehis.lc.standardStock.deptCode"
			}else {
				argArray[0] = "ehis.lc.standardStock.nursingUnit"
				namesArray[0]="facilityId";
				valuesArray[0]=facilityId.value;
			}
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
							
				//Display Order
		argArray[3] = DESC_CODE;

				// Link Description
		argArray[4] = DESC_LINK;
		argArray[5]=document.getElementById("source").value;
		if(sourceType=="W"){
		getServerMessage("com.iba.ehis.lc.ward");
		retArr = Lookup(dwrMessage, argArray);
		}else if(sourceType=="C"){
		getServerMessage("com.iba.ehis.lc.sourceCode");
		retArr = Lookup(dwrMessage, argArray);
		}else if(sourceType=="D"){
		getServerMessage("com.iba.ehis.lc.department");
		retArr = Lookup(dwrMessage, argArray);
		}else{
		getServerMessage("com.iba.ehis.lc.ward");
		retArr = Lookup(dwrMessage, argArray);
		}
		var txtUser = document.QueryCriteriaForm["vo.criteriaItems[1].itemValue"];
		var txtUser1 = document.getElementById("source");
		
		if(retArr!=null){
			//Set the data in to the fields
			txtUser.value = retArr[0];
			txtUser1.value = retArr[1];
		}
	}		
function showLookup1() {
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	namesArray[0]="languageId";
	valuesArray[0]="<%=locale%>";
	argArray[0] = "ehis.lc.standardStock.linenItem"
		

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	
	argArray[5] =document.getElementById("linenDesc").value;
	getServerMessage("com.iba.ehis.lc.linenitemcode");
	retArr = Lookup(dwrMessage, argArray);
	var txtUser = document.QueryCriteriaForm("vo.criteriaItems[6].itemValue");
		var txtUser1 = document.QueryCriteriaForm("linenDesc");
	
	if(retArr!=null){
		//Set the data in to the fields
		txtUser.value = retArr[0];
		txtUser1.value = retArr[1];
		}
	}
	
	function checkAlpha(){
		obj =  String.fromCharCode(window.event.keyCode);
		var alphaFilter =/^[a-z_A-Z]+$/;
		if (!(alphaFilter.test(obj))) { 
			getServerMessage("messages.Alphabet");
			parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
			window.event.keyCode = 27;
		}
   	} 
	
function submitQuery(){
	
	/*	var linenItemDesc = document.QueryCriteriaForm("linenDesc");
		if(linenItemDesc.value==""){
			document.QueryCriteriaForm("vo.criteriaItems[6].itemValue").value="";
		}*/
		var request_status = document.getElementById("vo.criteriaItems[5].itemValue").value;
		var flag=checkNull1();
		if(flag==true){
			var fromDate = document.getElementById("vo.criteriaItems[2].itemValue").value;
			var toDate = document.getElementById("vo.criteriaItems[3].itemValue").value;
			if(toDate !=""){
				var locale=document.getElementById("languageId").value;
				IBADateValidator.isDateGreaterThanJS(fromDate,toDate,locale,callBackFunction);
				function callBackFunction(data){
					var error ="";
					var msgArray=new Array();
					if(data ==true)	{				
						getServerMessage("APP-LC00013");
						var message = dwrMessage;
						msgArray=message.split("#");
						getServerMessage("com.iba.ehis.lc.requestForLinen.requestDate");
						error = error + msgArray[0] + "To Date" +  " " + msgArray[1] +" "+ dwrMessage + "<br>";
						parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
						document.getElementById("vo.criteriaItems[3].itemValue").value="";
						document.getElementById("vo.criteriaItems[3].itemValue").setFocus;
					} else	{
					if(request_status == 'OS+PI'){
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

function callLookup(arg){
		if(arg.value!="")
			showLookup1();
	}
function convertEng()
{

 var tDate=document.QueryCriteriaForm["requestDate"].value;
 IBADateValidator.convertDateJS(tDate,'<%=locale%>','en','dd/MM/yyyy HH:mm',callBackMethod);
  function callBackMethod(data)
	{
	  var newTDate=data;
		document.QueryCriteriaForm("vo.criteriaItems[2].itemValue").value=newTDate;
		 var fDate=document.QueryCriteriaForm["toDate"].value;
		IBADateValidator.convertDateJS(fDate,'<%=locale%>','en','dd/MM/yyyy HH:mm',callBackMethod1);
		  function callBackMethod1(data1)
			{
			 var newFDate=data1;
			 document.QueryCriteriaForm("vo.criteriaItems[3].itemValue").value=newFDate;
			}
	}

}

</script>
<IBATagLibs:initCalendar />
</head>
<body onload="getLoginUser();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onmouseover="convertEng()">
	<ibaHTML:form action="/QueryAction.do"	target="deliverCleanedLinenResult">
<br>
<table border='0 ' cellpadding='2' cellspacing='0' width='80%' align='center' class='COMMON_TOOLBAR'>
			<tr>
				<td align='right' width="30%" CLASS='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.standardStock.sourceType" bundle="lcLabels" />
				</td>
				<td width="30%">
					<ibaHTML:select property="vo.criteriaItems[0].itemValue" >
						<ibaHTML:option value=""><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" />
						</ibaHTML:option>
						<ibaHTML:option value="W"><ibaBean:message key="com.iba.ehis.lc.ward" bundle="lcLabels" />
						</ibaHTML:option>
						<ibaHTML:option value="C"><ibaBean:message key="com.iba.ehis.lc.clinic" bundle="lcLabels" />
						</ibaHTML:option>
						<ibaHTML:option value="D"><ibaBean:message key="com.iba.ehis.lc.department" bundle="lcLabels" />
						</ibaHTML:option>
					</ibaHTML:select>
					<ibaHTML:hidden property="vo.criteriaItems[0].property" value="sourceType" />
				</td>
				<td align='right' width="20%" CLASS='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.standardStock.source" bundle="lcLabels" />
				</td>
				<td width="40%" nowrap="nowrap" >
					<input type="text" name="source" id="source" onblur='showLookup()'/>
					<ibaHTML:hidden property="vo.criteriaItems[1].itemValue" />
					<input type='button' class="BUTTON"  value='?' onclick='showLookup()' />
					<ibaHTML:hidden property="vo.criteriaItems[1].property" value="sourceCode" />
				</td>
			</tr>
			<tr>
				<td class='label'  nowrap="nowrap" align='right'>
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestDate"	bundle="lcLabels" />
				</td>
			<td class='label' nowrap="nowrap">
				<ibaHTML:text property="requestDate" value="<%=fdate%>" size="18" readonly="true" onkeydown="assignDate(this,false);" onkeypress="assignDate(this,false);" /><a onclick="return showCal('requestDate', '%d/%m/%Y %H:%M', true, true,'cutOffTimeForLinenRecptid');" name='.cutOffTimeForLinenRecptid' id='cutOffTimeForLinenRecptid'><img src="<%=request.getContextPath()%>/framework/images/img.gif"></a>
				<!--  <ibaHTML:hidden property="vo.criteriaItems[2].property" value="requestDate"/> -->
				<img src='framework/images/mandatory.gif'></img>			

				 <ibaHTML:hidden property="vo.criteriaItems[2].itemValue"   />
				 <input type='hidden' name='vo.criteriaItems[2].pattern' id='vo.criteriaItems[2].pattern' value='dd/MM/yyyy HH:mm'>
				 <ibaHTML:hidden property="vo.criteriaItems[2].property" value="requestDate"/> 
			</td>
			<td class='label'  nowrap="nowrap" align='right'>
					<ibaBean:message key="com.iba.ehis.lc.To"	bundle="lcLabels" />
			</td>
			<td class='label' nowrap="nowrap" >
				<ibaHTML:text property="toDate" value="<%=cdate%>" size="18" readonly="true" onkeydown="assignDate(this,false);" onkeypress="assignDate(this,false);" /><a onclick="return showCal('toDate', '%d/%m/%Y %H:%M', true, true,'cutOffTimeForLinenRecptid');" name='.cutOffTimeForLinenRecptid' id='cutOffTimeForLinenRecptid'><img src="<%=request.getContextPath()%>/framework/images/img.gif"></a><input type='hidden' name='vo.criteriaItems[3].pattern' id='vo.criteriaItems[3].pattern' value='dd/MM/yyyy HH:mm'>
			<!-- 	<ibaHTML:hidden property="vo.criteriaItems[3].property" value="toRequestDate"/> -->
					<ibaHTML:hidden property="vo.criteriaItems[3].itemValue"  />
					<input type='hidden' name='vo.criteriaItems[3].pattern' id='vo.criteriaItems[3].pattern' value='dd/MM/yyyy HH:mm'>
					<ibaHTML:hidden property="vo.criteriaItems[3].property" value="toRequestDate"/>
			</td>
		</tr>
		<tr >
			<td class='label'  nowrap="nowrap" align='right'>
				<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.linenHandedOverBy"	bundle="lcLabels" />
			</td>
			<td class='label'>
				 <ibaHTML:text property="vo.criteriaItems[4].itemValue"/>
				 <ibaHTML:hidden property="vo.criteriaItems[4].property" value="linenHandedOverBy" />
			</td>
			<td class='label'  nowrap="nowrap" align='right'>
					<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.linenCollectedBy"	bundle="lcLabels" />
			</td>
			<td class='label'>
				 <ibaHTML:text property="vo.criteriaItems[4].itemValue" onkeypress="checkAlpha()" />
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
				<option value="OS+PI"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.allPendingReq" bundle="lcLabels" />
				</option>
				<option value="OS" selected><ibaBean:message key="com.iba.ehis.lc.requestForLinen.outstanding" bundle="lcLabels" />
				</option>
				<option value="PD"><ibaBean:message key="com.iba.ehis.lc.deliverCleanedLinen.partiallydelivered" bundle="lcLabels" />
				</option>
				<option value="DL"><ibaBean:message key="com.iba.ehis.lc.deliverCleanedLinen.delivered" bundle="lcLabels" />
				</option>
				<option value="CN"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.cancelled" bundle="lcLabels" />
				</option>
				</select>
				 <ibaHTML:hidden property="vo.criteriaItems[5].property" value="requestStatus" />
			</td>
			<!-- <td class='label'  nowrap="nowrap"  align='right'>
				<ibaBean:message key="com.iba.ehis.lc.Category" bundle="lcLabels" /> 
			</td>
			<td class='label' colspan='3'>
				 <select name="vo.criteriaItems[6].itemValue" id="vo.criteriaItems[6].itemValue" >
				<option value="C"><ibaBean:message key="com.iba.ehis.lc.cleaning" bundle="lcLabels" />
				</option>
				<option value="M" selected><ibaBean:message key="com.iba.ehis.lc.mending" bundle="lcLabels" />
				</option>
				</select>
				 
				  <ibaHTML:hidden property="vo.criteriaItems[6].property" value="category" /> 
			</td> -->
		</tr>
		<tr>
			<td colspan='4'class='button' align='right'>
				<input type='button' class="BUTTON"  name="Search" id="Search" value="<ibaBean:message key='com.iba.ehis.lc.search' bundle='lcLabels' />"  onclick="submitQuery()" />
			</td>
		</tr>
		</table>
		
		<input type="hidden" name="user" id="user" value="<%=loggedInUser%>" />
		<ibaHTML:hidden property="vo.operatingFacilityId" value="<%=facilityId%>" />
		<input type="hidden" name="vo.queryResultPage" id="vo.queryResultPage" value="DeliverCleanedLinenQueryResultPage" />					
		<ibaHTML:hidden property="vo.functionId" value="LC_REQ_FOR_CLEANING_LINEN" />
		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
		<ibaHTML:hidden property="vo.mode" />
		<input type="hidden" name="languageId" id="languageId" value="<%=locale%>"/>
		<input type="hidden" name="vo.locale" id="vo.locale" value="<%=locale%>"/>
		<input type="hidden" name="vo.pageAction" id="vo.pageAction" value="DeliverCleanedLinenPageAction" />
		<ibaHTML:hidden property="method" value="<%=new Integer(com.iba.ehis.core.util.AppConstants.QUERY).toString()%>" />
		<!--  Modify by DhanasekarV for weblogic -->
	</ibaHTML:form>
	
</body>
</ibaHTML:html>

