<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADateTime,com.iba.framework.core.util.IBADateValidation,com.iba.framework.core.util.IBADate" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.ehis.lc.core.vo.SourceBean"%>
<%@ page  import="com.iba.ehis.lc.core.util.LcDateFormat"%>
<%@ include file="/framework/html/Tag.text"%>

<ibaHTML:html locale="true">
<IBATagLibs:initCalendar />
<head>
	<%
		String facilityId=(String)session.getAttribute("facility_id");
		String functionId = (String) session.getAttribute("functionId");
		String moduleId = (String) session.getAttribute("moduleId");
		String loggedInUser = (String) session.getAttribute("login_user");
		String locale = (String) session.getAttribute("LOCALE");
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
		 userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */	//AMRI-SCF-0679
		
		String datepattrn=userPrefs.getDateFormat();
		String sb=userPrefs.getDateFormat();
		String tf=userPrefs.getTimeFormat();
		String pattern=sb+" "+tf;
						
		IBADateTime frmDate=LcDateFormat.getSevendaysBackDate(request);
		
		IBADateTime date = new IBADateTime(request.getSession().getId());
										
		IBADateValidation ibaDateValidation = new IBADateValidation();
		String cdate = ibaDateValidation.convertDateJS(date.toString(),"en",locale,"dd/MM/yyyy HH:mm");
		String fdate = ibaDateValidation.convertDateJS(frmDate.toString(),"en",locale,"dd/MM/yyyy HH:mm");

		SourceBean obj=new SourceBean();
		try
		{
			// obj=(SourceBean)CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,				
					//"sessid", "objKey");
									
		}catch(Exception e){} 
	
	//AMRI-SCF-0679
	String srcType = (String) session.getAttribute("sourceType");
	String srctype = (String) session.getAttribute("sourcetype");
	String src = (String) session.getAttribute("source");
	String srcCode = (String) session.getAttribute("sourceCode");
	//AMRI-SCF-0679
		/* String src=obj.getSource();
		String srcType=obj.getSourceType();
		String srctype=obj.getSourcetype();
		String srcCode=obj.getSourceCode(); */

		String sourceType = (String) request.getParameter("sourceType");
		String sourcetype = (String) request.getParameter("sourcetype");
		String source = (String) request.getParameter("source");	
		String sourceCode= (String) request.getParameter("sourceCode");
		
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
	<!--script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LcDateConverter.js'></script-->
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LcDateFormat.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/RequestForLinen/js/RequestForLinen.js'></script>

<script>

function getLoginUserRequestList(){
	var userId ='<%=session.getAttribute("login_user")%>';
	RequestForCleaning.getLoggedInUser("<%=locale%>", userId, callLoggedInUserRequestList);
	}

function callLoggedInUserRequestList(data){
	for(prop in data){
		document.QueryCriteriaForm["vo.criteriaItems[4].itemValue"].value = prop;
		}
	}
	
function setSourceType(){
var src= document.getElementById("sourceType").value;
if(src=="Nursing Unit" || src=="th Nursing Unit")
		document.getElementById("vo.criteriaItems[0].itemValue").value='W';
		document.getElementById("vo.criteriaItems[1].itemValue").value=document.getElementById("sourceCode").value;
	if(src=="Clinic" || src=="th Clinic")
		document.getElementById("vo.criteriaItems[0].itemValue").value='C';
		document.getElementById("vo.criteriaItems[1].itemValue").value=document.getElementById("sourceCode").value;
	if(src=="Department" || src=="th Department")
	    document.getElementById("vo.criteriaItems[0].itemValue").value='D';
		document.getElementById("vo.criteriaItems[1].itemValue").value=document.getElementById("sourceCode").value;
		//document.getElementById("vo.criteriaItems[1].itemValue").value='<%=srcCode%>';
}

function convertDateToEn(){
  
  var tdate=document.getElementById("toRequestDate");

  IBADateValidator.convertDateJS(tdate.value,"<%=locale%>","en","<%=pattern%>",RDTocallbackMethod);
  function  RDTocallbackMethod(tdate1){
	  document.getElementById("vo.criteriaItems[3].itemValue").value=tdate1;
	
	} 

  var rdate=document.getElementById("requestDate");
    IBADateValidator.convertDateJS(rdate.value,"<%=locale%>","en","<%=pattern%>",RDTocallbackMethod1);
  function  RDTocallbackMethod1(rdate1){
			  document.getElementById("vo.criteriaItems[2].itemValue").value=rdate1;
			 
	} 


}



</script>
</head>

<body onload="CurrDate('R');getLoginUserRequestList();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onmouseover="convertDateToEn()">
	<ibaHTML:form action="/QueryAction.do"	target="requestForLinenResult">
<br>
	<table border='0 ' cellpadding='2' cellspacing='0' width='80%' align='center' class='COMMON_TOOLBAR'>
		<tr>
			<td align="right" width="30%" CLASS='label' nowrap="nowrap">
				<ibaBean:message key="com.iba.ehis.lc.standardStock.sourceType" bundle="lcLabels" />
			</td>
			<td width="30%">
				<input type=text name="sourceType" id="sourceType" maxlength="10" readonly="true" value="<%=srcType%>"/>
				<ibaHTML:hidden property="vo.criteriaItems[0].itemValue" />
				<ibaHTML:hidden property="vo.criteriaItems[0].property" value="sourceType" />
			</td>
			<td align="right" width="20%" CLASS='label' nowrap="nowrap">
				<ibaBean:message key="com.iba.ehis.lc.standardStock.source" bundle="lcLabels" />
			</td>
			<td width="40%" nowrap="nowrap" >
				<input type=text name="srcCode" id="srcCode" maxlength="30"	readonly="true" value="<%=src%>" />
				<ibaHTML:hidden property="vo.criteriaItems[1].itemValue"/>
				<ibaHTML:hidden property="vo.criteriaItems[1].property" value="srcCode" />
			</td>
		</tr>
		<tr>
			<td class='label'  nowrap="nowrap" align="right">
				<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestDate"	bundle="lcLabels" />
			</td>
			
			<td class='label' nowrap="nowrap" >
			 <input type="text" readonly="true" name="requestDate" id="requestDate" value="<%=fdate%>" onblur="isValidDate(this)"><a onclick="return showCal('requestDate', '%d/%m/%Y %H:%M', true, true,'itemValueid');" name='.itemValueid' id='itemValueid'>
			 <img src="<%=request.getContextPath()%>/framework/images/img.gif"></a>
			 <input type='hidden' name='vo.criteriaItems[2].itemValue.pattern' id='vo.criteriaItems[2].itemValue.pattern' value='dd/MM/yyyy HH:mm'>
			 <img src="framework/images/mandatory.gif"></img>
			 <ibaHTML:hidden property="vo.criteriaItems[2].itemValue" />
			 <ibaHTML:hidden property="vo.criteriaItems[2].property" value="requestDate" />
			</td>
			<td class='label'  nowrap="nowrap" align="right">
					<ibaBean:message key="com.iba.ehis.lc.To" bundle="lcLabels" />
			</td>
			<td class='label' nowrap="nowrap" >
			 <input type="text" readonly="true" name="toRequestDate" id="toRequestDate" value="<%=cdate%>" onblur="isValidDate(this)"><a onclick="return showCal('toRequestDate', '%d/%m/%Y %H:%M', true, true,'itemValueid');" name='.itemValueid' id='itemValueid'>
			 <img src="<%=request.getContextPath()%>/framework/images/img.gif"></a>
			 <input type='hidden' name='vo.criteriaItems[3].itemValue.pattern' id='vo.criteriaItems[3].itemValue.pattern' value='dd/MM/yyyy HH:mm'>
			 <ibaHTML:hidden property="vo.criteriaItems[3].itemValue" />
			 <ibaHTML:hidden property="vo.criteriaItems[3].property" value="toRequestDate" />
			</td>

		</tr>
		<tr>
			<td class='label'  nowrap="nowrap" align="right">
				<ibaBean:message key="com.iba.ehis.lc.requestForLinen.raisedBy"	bundle="lcLabels" />
			</td>
			<td class='label'>
				 <ibaHTML:text property="vo.criteriaItems[4].itemValue" maxlength="30"/>
				 <ibaHTML:hidden property="vo.criteriaItems[4].property" value="raisedBy" />
			</td>
			<td class='label'  nowrap="nowrap" align="right">
				<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestStatus" bundle="lcLabels" />
			</td>
			<td class='label'>
				<select name="vo.criteriaItems[5].itemValue" id="vo.criteriaItems[5].itemValue" >
				<option value="ALL"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.all" bundle="lcLabels" />
				</option>
				<option value="OS+PI" selected><ibaBean:message key="com.iba.ehis.lc.requestForLinen.allPendingReq" bundle="lcLabels" />
				</option>
				<option value="OS"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.outstanding" bundle="lcLabels" />
				</option>
				<option value="PI"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.partiallyissued" bundle="lcLabels" />
				</option>
				<option value="IS"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.issued" bundle="lcLabels" />
				</option>
				<option value="CN"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.cancelled" bundle="lcLabels" />
				</option>
				</select>
				 <ibaHTML:hidden property="vo.criteriaItems[5].property" value="requestStatus" />
			</td>
		</tr>
		<!-- <tr>
			<td class='label'  nowrap="nowrap" align="right">
				<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
			</td>
			<td class='label' colspan='3'>
				<ibaHTML:hidden property="vo.criteriaItems[6].itemValue" />
				<input type='text' name='linenDesc' id='linenDesc' onblur="setClearLinenDesc();requestListLookup();" />
				<input type='button' class="BUTTON"  value='?' onclick='showLookupForList()' />
				<ibaHTML:hidden property="vo.criteriaItems[6].property" value="linnenItem" />
			</td>
		</tr> -->
		<tr>
			<td colspan='4'class='button' align='right'>
				<input type='button' class="BUTTON"  name="Search" id="Search" value="<ibaBean:message key='com.iba.ehis.lc.search' bundle='lcLabels' />"  onclick="submitQuery()" />
			</td>
		</tr>
	</table>
		
		<ibaHTML:hidden property="vo.operatingFacilityId" value="<%=facilityId%>" />
		<input type="hidden" name="vo.queryResultPage" id="vo.queryResultPage" value="RequestForLinenQueryResultPage" />					
		<ibaHTML:hidden property="vo.functionId" value=""/>

		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
		<ibaHTML:hidden property="vo.mode" />
		<input type="hidden" name="vo.pageAction" id="vo.pageAction" value="RequestForLinenPageAction" />
		<ibaHTML:hidden property="method" value="<%=com.iba.ehis.core.util.AppConstants.QUERY%>" />
		<ibaHTML:hidden property="vo.viewCode" value="requestsListFrame"/>
		<input type="hidden" name="languageId" id="languageId" value="<%=locale%>" />
		<input type="hidden" name="sourceCode" id="sourceCode" value="<%=srcCode%>" />
		<input type="hidden" name="sourceType" id="sourceType" value="<%=srcType%>" />
		<input type="hidden" name="sourceType1" id="sourceType1" value="<%=srctype%>" />

	</ibaHTML:form>
</body>
<script>
	setSourceType();
</script>
</ibaHTML:html>

