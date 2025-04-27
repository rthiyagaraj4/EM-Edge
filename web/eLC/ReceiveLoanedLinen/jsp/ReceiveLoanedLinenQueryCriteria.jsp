<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADateTime,com.iba.framework.core.util.IBADateValidation,,com.iba.ehis.lc.core.util.LcDateFormat" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.ehis.lc.core.vo.SourceBean"%>
<%@ page  import="com.iba.framework.core.util.Constants"%>
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
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
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
		String PP=sb.substring(0,2);
				if(PP.compareToIgnoreCase("dd")==0)
				datepattrn="%d/%m/%y"+" "+tf;
				else if(PP.compareToIgnoreCase("MM")==0)
				datepattrn="%m/%d/%y"+" "+tf;
				else if(PP.compareToIgnoreCase("yy")==0)
				datepattrn="%y/%m/%d"+" "+tf;
//		String locale=userPrefs.getLocale();
			
		IBADateTime frmDate=LcDateFormat.getSevendaysBackDate(request);
		IBADateTime date = new IBADateTime(request.getSession().getId());
												
		IBADateValidation ibaDateValidation = new IBADateValidation();
		String cdate = ibaDateValidation.convertDateJS((date.getIBADate()).toString(),"en",locale,pattern);
		String fdate = ibaDateValidation.convertDateJS(frmDate.toString(),"en",locale,pattern);

		String currentDate = date.toString();

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
		String srcCode=obj.getSourceCode();
 */
		
	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>

	<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/ReceiveLoanedLinenList.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LcDateFormat.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/ReceiveLoanedLinen/js/ReceiveLoanedLinen.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
		<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
				
<IBATagLibs:initCalendar/>
<script>
// ****************** TO GET GIVEN BY AND RECEIVED BY THROW DWR REQUEST *******************************		
	
	function getLoginUser(){
		var userId ='<%=session.getAttribute("login_user")%>';
		RequestForCleaning.getLoggedInUser("<%=locale%>",userId,callLoggedInUser);
	}
	
	function callLoggedInUser(data){
	var code="";
	var desc="";
		for(prop in data){
			
			code=prop;
			desc=data[prop];
			//document.getElementById("receivedBy").value =desc ;
			//document.getElementById("givenBy").value =desc ;
		
		

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
function convertDateToEn(){
  
  var tdate=document.getElementById("vo.criteriaItems[12].itemValue");

  IBADateValidator.convertDateJS(tdate.value,"<%=locale%>","en","<%=pattern%>",RDTocallbackMethod);
  function  RDTocallbackMethod(tdate1){
	  document.getElementById("vo.criteriaItems[5].itemValue").value=tdate1;
	
	} 

  var rdate=document.getElementById("vo.criteriaItems[11].itemValue");
    IBADateValidator.convertDateJS(rdate.value,"<%=locale%>","en","<%=pattern%>",RDTocallbackMethod1);
  function  RDTocallbackMethod1(rdate1){
			  document.getElementById("vo.criteriaItems[4].itemValue").value=rdate1;
			 
	} 


}

</script>
</head>


<body onload="getLoanCode();getLoginUser();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onmouseover="convertDateToEn()">
	<ibaHTML:form action="/QueryAction.do" target="receiveLoanedLinenResult">
		<table border='0 ' cellpadding='2' cellspacing='0' width='100%' align='center'>
		<tr>
				<td class='label' colspan='2' align="right"  nowrap="nowrap">
					&nbsp
					</td> 
		</tr>
			<tr>
				<td class='label' align="right"  nowrap="nowrap">
					<ibaBean:message
									key="com.iba.ehis.lc.standardStock.sourceType"
									bundle="lcLabels" />
					</td>  
						<td class='label' nowrap="nowrap">
						  <input type=text name="sourceType" id="sourceType" maxlength="10" readonly="true" value="<%=srcType%>"/>
							<ibaHTML:hidden property="vo.criteriaItems[0].itemValue"/>
							<ibaHTML:hidden property="vo.criteriaItems[0].property" value="sourceType" />
							<img src="framework/images/mandatory.gif"></img>
						
					        <ibaBean:message key="com.iba.ehis.lc.standardStock.source" bundle="lcLabels" />
							<input type=text name="sourceCode" id="sourceCode" maxlength="30" readonly="true" value="<%=src%>" />
							<ibaHTML:hidden property="vo.criteriaItems[1].itemValue"/>
							<ibaHTML:hidden property="vo.criteriaItems[1].property" value="sourceCode" />
							<img src="framework/images/mandatory.gif"></img>
							</td>
						<td>
				</td>
				<td></td>
				</tr>
			<tr>
				<td  class='label' align="right"   nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.loanedTo" bundle="lcLabels" />
				</td>
				<td class='label' nowrap="nowrap">
					<ibaHTML:select property="vo.criteriaItems[2].itemValue" onchange="setClearLoan();">
						<!--<ibaHTML:option value="W"><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" />
						</ibaHTML:option>-->
						<ibaHTML:option value="W"><ibaBean:message key="com.iba.ehis.lc.ward" bundle="lcLabels" />
						</ibaHTML:option>
						<ibaHTML:option value="P"><ibaBean:message key="com.iba.ehis.lc.patient" bundle="lcLabels" />
						</ibaHTML:option>
						<ibaHTML:option value="C"><ibaBean:message key="com.iba.ehis.lc.clinic" bundle="lcLabels" />
						</ibaHTML:option>
						<ibaHTML:option value="D"><ibaBean:message key="com.iba.ehis.lc.department" bundle="lcLabels" />
						</ibaHTML:option>
					</ibaHTML:select>
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<ibaBean:message key="com.iba.ehis.lc.standardStock.source" bundle="lcLabels" />
					<ibaHTML:hidden property="vo.criteriaItems[2].property" value="loanedToSourceType" />
						<input type="text" name="loanedDesc" id="loanedDesc" maxlength="30" onblur="setClearSourceDesc();showLoanedDescLookup()"  />
							<ibaHTML:hidden property="vo.criteriaItems[3].itemValue" />
							<input type='button' class="BUTTON"  value='?' onclick='showLoanedLookup()' />
							<ibaHTML:hidden property="vo.criteriaItems[3].property" value="loanedToSourceCode" />
						</td>
				<td>
				</td>
				<td>
				</td>
				</tr>
				<tr>
					<td class='label' align="right"  nowrap="nowrap">
						<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.loanDateFrom" bundle="lcLabels" />
					</td>
					<td class='label' nowrap="nowrap" colspan="3">

					<input type="text" readonly="true" name="vo.criteriaItems[11].itemValue" id="vo.criteriaItems[11].itemValue" value="<%=fdate%>" onblur="isValidDate(this)"><a onclick="return showCal('vo.criteriaItems[11].itemValue', '%d/%m/%Y %H:%M', true, true,'itemValueid');" name='.itemValueid' id='itemValueid'><img src="<%=request.getContextPath()%>/framework/images/img.gif"></a><input type='hidden' name='vo.criteriaItems[4].itemValue.pattern' id='vo.criteriaItems[4].itemValue.pattern' value='%d/%m/%Y %H:%M'>
	       		    <ibaHTML:hidden property="vo.criteriaItems[4].itemValue" />
					<ibaHTML:hidden property="vo.criteriaItems[4].property" value="loanDateFrom"/>
  					<img src="framework/images/mandatory.gif"></img>
					&nbsp
					<ibaBean:message key="com.iba.ehis.lc.To" bundle="lcLabels" />
						
						<input type="text" readonly="true" name="vo.criteriaItems[12].itemValue" id="vo.criteriaItems[12].itemValue" value="<%=cdate%>" onblur="isValidDate(this)"><a onclick="return showCal('vo.criteriaItems[12].itemValue', '%d/%m/%Y %H:%M', true, true,'itemValueid');" name='.itemValueid' id='itemValueid'><img src="<%=request.getContextPath()%>/framework/images/img.gif"></a>
						 <ibaHTML:hidden property="vo.criteriaItems[5].itemValue"  />
						 <ibaHTML:hidden property="vo.criteriaItems[5].property" value="loanDateTo" />
					</td>
					
				</tr>
					
				<tr >
					<td class='label' align="right"  nowrap="nowrap">
						<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.givenBy" bundle="lcLabels" />
					</td>
					<td class='label'>
				
					 <ibaHTML:text property="vo.criteriaItems[6].itemValue" readonly="true" value="<%=addedById%>" />
						<ibaHTML:hidden property="vo.criteriaItems[6].property" value="givenBy" />
				</td>
				<td>
				</td>
				<td>
				</td>
			</tr>	
			<tr>
				<td class='label' align="right"  nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.receivedBy" bundle="lcLabels" />
				</td>
				<td class='label' >
			
					<ibaHTML:text property="vo.criteriaItems[7].itemValue" />
					<ibaHTML:hidden property="vo.criteriaItems[7].property" value="receivedBy" />
				</td>
					<td>
					</td><td>
				</tr>
				<tr>
				<td class='label' align="right"  nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.reasonForLoan" bundle="lcLabels" />
				</td>
				
				<td>
					<ibaHTML:select property="vo.criteriaItems[8].itemValue">
						<ibaHTML:option value=""><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" /></ibaHTML:option>
							<ibaHTML:optionsCollection property="vo.orderByOriginal.options" label="value" value="key" />
						</ibaHTML:select>
						<ibaHTML:hidden property="vo.criteriaItems[8].property" value="reasonForLoanCode" />	
					</td>
				<td>
				  		 
				</td>
				<td></td>
				</tr>
				<tr>
				<td class='label' align="right"  nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.requestStatus" bundle="lcLabels" />
					<td>
						<ibaHTML:select property="vo.criteriaItems[9].itemValue">
							<ibaHTML:option value="OS"><ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.outStanding" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="ALL"><ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.all" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="L"><ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.loaned" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="C"><ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.cancelled" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="R"><ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.receivedBack" bundle="lcLabels" />
							</ibaHTML:option>
						</ibaHTML:select>
					<ibaHTML:hidden property="vo.criteriaItems[9].property" value="requestStatus" />
				</td>
					<td></td>
				<td>
				</tr>
				<tr>
				<td class='label' align="right"  nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.linenItem" bundle="lcLabels" />
					</td>
					<td>
						<input type="text" name="linenItemDesc" id="linenItemDesc" size="30" maxlength="30" onblur="setClearLinenDesc();linenItemDescLookup()"  />
						<ibaHTML:hidden property="vo.criteriaItems[10].itemValue" />
						<input type='button' class="BUTTON"  value='?' onclick='linenItemLookup();' />
						<ibaHTML:hidden property="vo.criteriaItems[10].property" value="linnenItem" />
					</td>
					<td></td>
				<td></td>
			</tr>
			
				<tr>
					<td colspan='4'class='button' align='center'>
						<input type='button' class="BUTTON"  name="Search" id="Search" value="Search"  onclick="submitQuery()" />
					</td>
				</tr>
			
		</table>

		<input type="hidden" id="vo.operatingFacilityId" name="vo.operatingFacilityId" id="vo.operatingFacilityId" value="<%=facilityId%>" />
		<input type="hidden" name="vo.queryResultPage" id="vo.queryResultPage" value="ReceiveLoanedLinenQueryResultPage" />					
		<ibaHTML:hidden property="vo.functionId" />
		<ibaHTML:hidden property="vo.moduleId" value="LC" />
		<ibaHTML:hidden property="vo.mode" />
		<input type="hidden" name="vo.pageAction" id="vo.pageAction" value="ReceiveLoanedLinenPageAction" />
		<input type="hidden" name="languageId" id="languageId" value="<%=locale%>" />
		<ibaHTML:hidden property="method" value="<%=new Integer(com.iba.ehis.core.util.AppConstants.QUERY).toString()%>" />
		
				
	</ibaHTML:form>
</body>
<script>
	setSourceType();
</script>

</ibaHTML:html>

