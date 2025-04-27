<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateTime,com.iba.framework.core.util.IBADateValidation" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/framework/html/Tag.text"%>
<ibaHtml:html locale="true">
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
		IBADateTime frmDate=LcDateFormat.getSevendaysBackDate(request);
		System.err.println("32 getSevendaysBackDate:-"+frmDate);
		IBADateTime date = new IBADateTime(request.getSession().getId());
		System.err.println("32 current Date:-"+date);								
		IBADateValidation ibaDateValidation = new IBADateValidation();
		String cdate = ibaDateValidation.convertDateJS(date.toString(),"en",locale,"dd/MM/yyyy HH:mm");
		String fdate = ibaDateValidation.convertDateJS(frmDate.toString(),"en",locale,"dd/MM/yyyy HH:mm");
		System.err.println("32 from date and current Date:-"+fdate+" "+cdate);			
%>

<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
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
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/IssueOfLinen/js/IssueOfLinen.js'></script>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/framework/js/PopupWindow.js"></script>
	<IBATagLibs:initCalendar />
</head>
<script>
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
<body onload="CurrDate('T');getLoginUserPlaceLinen()" OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onmouseover="convertEng()" >
	<ibaHTML:form action="/QueryAction.do"	target="issueOfLinenResult">
<br>
<table border='0 ' cellpadding='2' cellspacing='0' width='80%' align='center' class='COMMON_TOOLBAR'>
	<tr>
		<td align="right" width="30%" CLASS='label' nowrap="nowrap">
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
		<td align="right" width="20%" CLASS='label' nowrap="nowrap">
			<ibaBean:message key="com.iba.ehis.lc.standardStock.source" bundle="lcLabels" />
		</td>
		<td width="40%" nowrap="nowrap" >
			<input type="text" name="source" id="source" onblur='showLookup()'/>
			<ibaHTML:hidden property="vo.criteriaItems[1].itemValue" />
			<input type='button' class="BUTTON"  value='?' onclick='showLookup()' />
			<ibaHTML:hidden property="vo.criteriaItems[1].property" value="srcCode" />
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
				<ibaHTML:text property="toDate" value="<%=cdate%>" size="18" readonly="true" onkeydown="assignDate(this,false);" onkeypress="assignDate(this,false);" /><a onclick="return showCal('toDate', '%d/%m/%Y %H:%M', true, true,'cutOffTimeForLinenRecptid');" name='.cutOffTimeForLinenRecptid' id='cutOffTimeForLinenRecptid'><img src="<%=request.getContextPath()%>/framework/images/img.gif"></a>
				<input type='hidden' name='vo.criteriaItems[3].pattern' id='vo.criteriaItems[3].pattern' value='dd/MM/yyyy HH:mm'>
			<!-- 	<ibaHTML:hidden property="vo.criteriaItems[3].property" value="toRequestDate"/> -->
					<ibaHTML:hidden property="vo.criteriaItems[3].itemValue"  />
					<input type='hidden' name='vo.criteriaItems[3].pattern' id='vo.criteriaItems[3].pattern' value='dd/MM/yyyy HH:mm'>
					<ibaHTML:hidden property="vo.criteriaItems[3].property" value="toRequestDate"/>
			</td>
		</tr>
	<tr>
		<td class='label'  nowrap="nowrap" align="right">
			<ibaBean:message key="com.iba.ehis.lc.requestForLinen.raisedBy"	bundle="lcLabels" />
		</td>
		<td class='label'>
			<input type="text" name="raisedBy" id="raisedBy" onblur="setloginUser()"/>
			 <ibaHTML:hidden property="vo.criteriaItems[4].itemValue" />
			 <ibaHTML:hidden property="vo.criteriaItems[4].property" value="raisedBy" />
		</td>
			<td class='label'  nowrap="nowrap" align="right">
			<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestStatus"	bundle="lcLabels" />
		</td>
		<td class='label'>
			<select name="vo.criteriaItems[5].itemValue" id="vo.criteriaItems[5].itemValue" >
					<option value="ALL"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.all" bundle="lcLabels" />
				</option>
					<option value="OS+PI"><ibaBean:message key="com.iba.ehis.lc.requestForLinen.allPendingReq" bundle="lcLabels" />
				</option>
					<option value="OS" selected><ibaBean:message key="com.iba.ehis.lc.requestForLinen.outstanding" bundle="lcLabels" />
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
			<input type='text' name='linenItemDesc' id='linenItemDesc' onblur='linenItemLookup();' />
			<input type='button' class="BUTTON"  value='?' onclick='showLookup1()' />
			<ibaHTML:hidden property="vo.criteriaItems[6].property" value="linnenItem" />
		</td>
	</tr> -->
	<tr>
		<td colspan='4'class='button' align='right'>
			<input type='button' class="BUTTON"  name="Search" id="Search" value="<ibaBean:message key='com.iba.ehis.lc.search' bundle='lcLabels' />" onclick="submitQuery()" />
		</td>
	</tr>
</table>
	<ibaHTML:hidden property="vo.operatingFacilityId" value="<%=facilityId%>" />
	<input type="hidden" name="vo.queryResultPage" id="vo.queryResultPage" value="IssueOfLinenQueryResultPage" />					
	<ibaHTML:hidden property="vo.functionId"/>
	<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
	<ibaHTML:hidden property="vo.locale" value="<%=locale%>" />
	<input type="hidden" name="loggedInUser" id="loggedInUser" value="<%=loggedInUser%>" />
	<ibaHTML:hidden property="vo.mode" />
	<input type="hidden" name="vo.pageAction" id="vo.pageAction" value="IssueOfLinenPageAction" />
	<input type="hidden" name="languageId" id="languageId" value="<%=locale%>" />
	<ibaHTML:hidden property="method" value="<%=new Integer(com.iba.ehis.core.util.AppConstants.QUERY).toString()%>" />
		<!--  Modify by DhanasekarV for weblogic -->
</ibaHTML:form>
</body>
</ibaHtml:html>

