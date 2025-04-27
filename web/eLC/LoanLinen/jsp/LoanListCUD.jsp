<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADateTime,com.iba.framework.core.util.IBADateTime,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateValidation" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.ehis.lc.core.vo.SourceBean"%>
<%@ include file="/framework/html/Tag.text"%>

<ibaHTML:html locale="true">
<head>
	<%
		String facilityId=(String)session.getAttribute("facility_id");
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

		IBADateTime frmDate=LcDateFormat.getSevendaysBackDate(request);
		IBADateTime date = new IBADateTime(request.getSession().getId());
												
		IBADateValidation ibaDateValidation = new IBADateValidation();
		String cdate = ibaDateValidation.convertDateJS(date.toString(),"en",locale,pattern);
		String fdate = ibaDateValidation.convertDateJS(frmDate.toString(),"en",locale,pattern);

	
		SourceBean obj=new SourceBean();
		try
		{
			/* obj=(SourceBean)CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,				
					"sessid", "objKey"); */
									
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
		
	%>

<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LoanLinen.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/LoanLinen/js/loanedLinen.js'></script>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>

<script>

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

function convertDateToEn(){
  
  var tdate=document.getElementById("loanDateTo");

  IBADateValidator.convertDateJS(tdate.value,"<%=locale%>","en","<%=pattern%>",RDTocallbackMethod1);
  function  RDTocallbackMethod1(fdate){
	  document.getElementById("vo.criteriaItems[5].itemValue").value=fdate;
	
	} 

  var rdate=document.getElementById("loanDateFrom");
    IBADateValidator.convertDateJS(rdate.value,"<%=locale%>","en","<%=pattern%>",RDTocallbackMethod);
  function  RDTocallbackMethod(tdate){
			  document.getElementById("vo.criteriaItems[4].itemValue").value=tdate;
	} 


}

</script>
 <IBATagLibs:initCalendar />
</head>

<body onload="LoanLinen.getLoan('<%=locale%>',getLoanReason);getLoginUser();CurrDate2()" OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onmouseover="convertDateToEn()">
	<ibaHTML:form action="/QueryAction.do"	target="loanLinenResult">
<table border='0 ' cellpadding='2' cellspacing='0' width='100%' align='center'>
		
			<tr>
				<td align="right" class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.standardStock.sourceType" bundle="lcLabels" />
					
					</td>
						<td class="label" nowrap="nowrap">

												
							<input type=text name="sourceType" id="sourceType" maxlength="10" readonly="true" value="<%=srcType%>"/>
							<ibaHTML:hidden property="vo.criteriaItems[0].itemValue"/>
							<ibaHTML:hidden property="vo.criteriaItems[0].property" value="sourceType" />
							<img src="framework/images/mandatory.gif"></img>
						</td>
						<td class='label' align="right" nowrap="nowrap">
								<ibaBean:message key="com.iba.ehis.lc.standardStock.source" bundle="lcLabels" />
						 </td>
						 <td class='label'>
							<input type=text name="sourceCode" id="sourceCode" maxlength="30" readonly="true" value="<%=src%>" />
							<ibaHTML:hidden property="vo.criteriaItems[1].itemValue"/>
							<ibaHTML:hidden property="vo.criteriaItems[1].property" value="sourceCode" />
							<img src="framework/images/mandatory.gif"></img>
								
								
							
						</td>
				
				</tr>
			<tr>
				<td align="right" class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.loanLinen.loanTo" bundle="lcLabels" />
				</td>
				<td nowrap="nowrap" class='label' >
					<ibaHTML:select property="vo.criteriaItems[2].itemValue" onchange="setClearLoan();">
						<ibaHTML:option value="W"><ibaBean:message key="com.iba.ehis.lc.ward" bundle="lcLabels" />
						</ibaHTML:option>
						<ibaHTML:option value="P"><ibaBean:message key="com.iba.ehis.lc.patient" bundle="lcLabels" />
						</ibaHTML:option>
						<ibaHTML:option value="C"><ibaBean:message key="com.iba.ehis.lc.clinic" bundle="lcLabels" />
						</ibaHTML:option>
						<ibaHTML:option value="D"><ibaBean:message key="com.iba.ehis.lc.department" bundle="lcLabels" />
						</ibaHTML:option>
					</ibaHTML:select>
					<ibaHTML:hidden property="vo.criteriaItems[2].property" value="loanedToSourceType" />
					</td>
					<td class='label' align="right" nowrap="nowrap">
						<ibaBean:message key="com.iba.ehis.lc.standardStock.source" bundle="lcLabels" />
					</td>
					<td class='label'>
						<input type="text" name="loanedToSourceCode" id="loanedToSourceCode" maxlength="30" onblur="if(this.value!='')showLookupLoanList()"/>
							<ibaHTML:hidden property="vo.criteriaItems[3].itemValue" />
							<input type='button' class="BUTTON"  value='?' onclick='showLoanedLookup()' />
							<ibaHTML:hidden property="vo.criteriaItems[3].property" value="loanedToSourceCode" />
					</td>
				</tr>
				<tr>
					<td class='label' align="right" nowrap="nowrap">
						<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.loanDateFrom" bundle="lcLabels" />
					</td>
					<td class='label' >

					 <input type="text" readonly="true"  name="loanDateFrom" id="loanDateFrom" value="<%=fdate%>" onblur="isValidDate(this)" ><a onclick="return showCal('loanDateFrom', '%d/%m/%Y %H:%M', true, true,'itemValueid');" name='.itemValueid' id='itemValueid'>
					 <img src="<%=request.getContextPath()%>/framework/images/img.gif"></a>
					 <input type='hidden' name='vo.criteriaItems[4].itemValue.pattern' id='vo.criteriaItems[4].itemValue.pattern' value='%d/%m/%Y %H:%M'>
						<!-- <ibaHTML:IBACalendarInput property="vo.criteriaItems[4].itemValue" format="%d/%m/%Y %H:%M"></ibaHTML:IBACalendarInput>-->
						 <img src="framework/images/mandatory.gif"></img>
						  <ibaHTML:hidden property="vo.criteriaItems[4].itemValue" />
						 <ibaHTML:hidden property="vo.criteriaItems[4].property" value="loanDateFrom" />
					</td>
					
					<td class='label' align="right" nowrap="nowrap">
						<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.loanDateTo" bundle="lcLabels" />
					</td>
					<td class='label' nowrap="nowrap">
						 <input type="text" readonly="true"  name="loanDateTo" id="loanDateTo" value="<%=cdate%>" onblur="isValidDate(this)" ><a onclick="return showCal('loanDateTo', '%d/%m/%Y %H:%M', true, true,'itemValueid');" name='.itemValueid' id='itemValueid'>
						 <img src="<%=request.getContextPath()%>/framework/images/img.gif"></a>
						 <input type='hidden' name='vo.criteriaItems[5].itemValue.pattern' id='vo.criteriaItems[5].itemValue.pattern' value='%d/%m/%Y %H:%M'>
						 <ibaHTML:hidden property="vo.criteriaItems[5].itemValue"  />
						 <ibaHTML:hidden property="vo.criteriaItems[5].property" value="loanDateTo" />
					</td>
					
				</tr>
					
				<tr >
					<td class='label' align="right">
						<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.givenBy" bundle="lcLabels" />
					</td>
					<td class='label'>
					 <ibaHTML:text property="vo.criteriaItems[6].itemValue" value="<%=addedById%>" readonly="true" maxlength="30" />
						<ibaHTML:hidden property="vo.criteriaItems[6].property" value="givenBy" />
				</td>
				
				<td class='label' align="right">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.receivedBy" bundle="lcLabels" />
				</td>
				<td class='label' >
					<ibaHTML:text property="vo.criteriaItems[7].itemValue"  maxlength="30"  />
					<ibaHTML:hidden property="vo.criteriaItems[7].property" value="receivedBy" />
				</td>
				
				</tr>
				<tr>
				<td class='label' align="right" nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.reasonForLoan" bundle="lcLabels" />
				</td>
				<td class='label' >
					<ibaHTML:select property="vo.criteriaItems[8].itemValue" >

					</ibaHTML:select>
					<ibaHTML:hidden property="vo.criteriaItems[8].property" value="reasonForLoanCode" />
				</td>
				<td class='label' align="right" nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.requestStatus" bundle="lcLabels" />
				</td>
				<td class='label' >
				<ibaHTML:select property="vo.criteriaItems[9].itemValue" >
						<ibaHTML:option value="OS"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.outstanding" bundle="lcLabels" />
						</ibaHTML:option>
						<ibaHTML:option value=""><ibaBean:message key="com.iba.ehis.lc.requestForLinen.all" bundle="lcLabels" />
						</ibaHTML:option>
						<ibaHTML:option value="L"><ibaBean:message key="com.iba.ehis.lc.loaned" bundle="lcLabels" />
						</ibaHTML:option>
						<ibaHTML:option value="CN"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.cancelled" bundle="lcLabels" />
						</ibaHTML:option>
						<ibaHTML:option value="R"><ibaBean:message key="com.iba.ehis.lc.receivedBack" bundle="lcLabels" />
						</ibaHTML:option>
					</ibaHTML:select>
				
					<ibaHTML:hidden property="vo.criteriaItems[9].property" value="requestStatus" />
				</td>
					
				</tr>
				<tr>
				<td align="right" CLASS='label'>
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.linenItem" bundle="lcLabels" />
					</td>
					<td>
						<input type="text" name="linenItem" id="linenItem" maxlength="30" onblur="setClearLinenDesc();showLoanedDescLookup()"  />
						<ibaHTML:hidden property="vo.criteriaItems[10].itemValue" />
						<input type='button' class="BUTTON"  value='?' onclick='linenItemLookup()' />
						<ibaHTML:hidden property="vo.criteriaItems[10].property" value="linnenItem" />
					</td>
					<td>
				</td>
				<td></td>
					</tr>
				<tr>
						<td colspan='4'class='button' align='right'>
						<input type='button' class="BUTTON"  name="Search" id="Search" value="<ibaBean:message key='com.iba.ehis.lc.search' bundle='lcLabels' />" onclick="submitQuery()" />
						</td>
						</tr>
			
		</table>
		
		<input type="hidden" name="vo.operatingFacilityId" id="vo.operatingFacilityId" value="<%=facilityId%>" />
		<input type="hidden" name="vo.queryResultPage" id="vo.queryResultPage" value="LoanLinenQueryResultPage" />	
		<input type="hidden" name="languageId" id="languageId" value="<%=locale%>" />	
		<input type="hidden" name="loginUser" id="loginUser" value="<%=addedById%>" />	
	<!--	<input type="hidden" name="sourceCode" id="sourceCode" value="<%=srcCode%>" />	-->
		<ibaHTML:hidden property="vo.functionId"  />
		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
		<ibaHTML:hidden property="vo.mode" />
		<input type="hidden" name="vo.pageAction" id="vo.pageAction" value="LoanLinenPageAction" />
		<ibaHTML:hidden property="method" value="<%=new Integer(com.iba.ehis.core.util.AppConstants.QUERY).toString()%>" />
		<!--  Modify By DhanasekarV for weblogic server change -->
		<ibaHTML:hidden property="vo.viewCode" value="loanLinenListFrame"/>
	</ibaHTML:form>
</body>
<script>
	setSourceType();
</script>
</ibaHTML:html>

