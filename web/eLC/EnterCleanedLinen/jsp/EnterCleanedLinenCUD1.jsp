<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADateValidation,com.iba.framework.core.util.IBADate,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateTime" pageEncoding="ISO-8859-1"%>
<%@ include file="/framework/html/Tag.text"%>

<ibaHTML:html locale="true">
<head>
	<%
			String facilityId=(String)session.getAttribute("facility_id");
			String functionId = (String) request.getParameter("functionId");
			String moduleId = (String) request.getParameter("moduleId");
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
				String locale=userPrefs.getLocale();
				String tf=userPrefs.getTimeFormat();
				String pattern=sb+" "+tf;
				String PP=sb.substring(0,2);
				if(PP.compareToIgnoreCase("dd")==0)
				datepattrn="%d/%m/%y"+" "+tf;
				else if(PP.compareToIgnoreCase("MM")==0)
				datepattrn="%m/%d/%y"+" "+tf;
				else if(PP.compareToIgnoreCase("yy")==0)
				datepattrn="%y/%m/%d"+" "+tf;
				IBADateTime todate=LcDateFormat.convertDateFormat(null,request);
				IBADateValidation ibaVlaid = new IBADateValidation();
				String conDate = (String)ibaVlaid.convertDateJS(todate.toString() ,"en", locale, "dd/MM/yyyy HH:mm");
				
	%>

	<link rel='stylesheet' type='text/css' href="<%=request.getContextPath()%>/core/css/<%=sStyle%>" />
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/framework/js/PopupWindow.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/CleanLinen.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/eLC/EnterCleanedLinen/js/EnterCleanedLinen.js"></script>
	<script>
		var contentList =new Hashtable();
		var  testpopup5="";
		var val="";

		function setval(){
			val=document.getElementById("remarkArea").value;
			document.getElementById("vo.remark").value=val;
		}

		function test5popupactivate(anchor) {
			if(testpopup5==""){
			 testpopup5 = new PopupWindow();
			}
			val=document.getElementById("vo.remark").value;
			document.getElementById("remarkArea").value=val;
			getServerMessage("com.iba.ehis.lc.ok");
			var buttonLabel = dwrMessage;
			testpopup5.height=200;
			testpopup5.width=300;
			testpopup5.offsetX=-10;
			testpopup5.offsetY=10;
			testpopup5.autoHide();
			testpopup5.populate('<title>Remark..</title><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/core/css/<%=sStyle%>"></link><FORM><CENTER><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="center"> Remark: </td></tr><tr><td  align="center"><textarea rows=5 cols=40 maxlength=2000 name="remarkArea" onkeyup="window.opener.document.getElementById("remarkArea").value=this.value;window.opener.setval()">'+val+'</textarea></td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();window.opener.setval()" value="'+buttonLabel+'"/></td></tr></table> </FORM></CENTER>');
			testpopup5.showPopup(anchor);
			setval();
		}

function reset()
{
content.location.href=contextPath+"/EnterCleanedLinenAction.do?method="+loadMethod
}

</script>
<IBATagLibs:initCalendar />
</head>
<body onload="CleanLinen.getReqNo(getRequestNumber);getLoginUser();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<ibaHTML:form action="/EnterCleanedLinenAction.do" target="messageFrame">
<br>
<table border='0 ' cellpadding='2' cellspacing='0' width='100%' align='center' class='COMMON_TOOLBAR'>
		<tr>
			<tr>
			<td class='label'  nowrap="nowrap"  align='right'>
					<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
			</td>
			<td class='label'>
				 <ibaHTML:hidden property="vo.linenItem"/>
				 <input type="text" name="linenItemDesc" id="linenItemDesc" onblur="linenItemShowLookup();"/>
				 <input type='button' class="BUTTON"  value='?' onclick='showLookup()' />
				 
			</td>
			<td class='button' align='right'>
			<input type='button' class="BUTTON"  name="Search" id="Search" value="<ibaBean:message key="com.iba.ehis.lc.search" bundle="lcLabels" />" onclick="getStock()" />
			</td>
			</tr>
	</table>					
	<br>
	<table border='0 ' cellpadding='2' cellspacing='0' width='100%' align='center' class='COMMON_TOOLBAR'	>
		<tr>
			<td class='label'  nowrap="nowrap"  align='right'>
				<ibaBean:message key="com.iba.ehis.lc.enterCleanedLinen.cleaningDate" bundle="lcLabels" />
			</td>

			<td class='label' nowrap="nowrap">
				<ibaHTML:text property="vo.cleaningDate" value="<%=conDate%>" size="18" readonly="true"  onkeydown="assignDate(this,false);" onkeypress="assignDate(this,false);" /><a onclick="return showCal('vo.cleaningDate', '%d/%m/%Y %H:%M', true, true,'cutOffTimeForLinenRecptid');" name='.cutOffTimeForLinenRecptid' id='cutOffTimeForLinenRecptid'><img src="<%=request.getContextPath()%>/framework/images/img.gif"></a><input type='hidden' name='vo.cleaningDate.pattern' id='vo.cleaningDate.pattern' value='dd/MM/yyyy HH:mm'>
				<img src='framework/images/mandatory.gif'></img>			
			</td>
		</tr>
		<tr>
			<td class='label'  nowrap="nowrap"  align='right'>
				<ibaBean:message key="com.iba.ehis.lc.enterCleanedLinen.cleaningDoneBy" bundle="lcLabels" />
			</td>
			<td class='label'>
				 <ibaHTML:text property="vo.cleaningDoneBy" onkeypress="return checkAlphaNum()" />
				 <img src="framework/images/mandatory.gif"></img>
				 <ibaHTML:hidden property="vo.cleaningRefNo"  />
				<a href="javascript:#" onclick="test5popupactivate(this.id);return false;" name="prepAnchor" id="prepAnchor">
				<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" /></a>
				<input type="hidden" name="remarkArea" id="remarkArea" value="" maxlength="2000"/>
				<input type="hidden" name="vo.remark" id="vo.remark" value="" maxlength="2000"/>
			</td>
		</tr>
	</table>
	<br>
		<table border='1' cellpadding='2' cellspacing='0' width='100%' id="tableid" align='center' >
			<tr>
				<td  colspan=6 >
					<b><ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" /></b>
				</td>
			</tr>
			<tr>
				<th align="center" width="20%">
					<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
				</th>
				<th  align='right' width="10%" nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.enterCleanedLinen.pendgingQty" bundle="lcLabels" />
				</th>
				<th align="center" width="10%" nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.enterCleanedLinen.cleanedQty" bundle="lcLabels" />
				</th>
				<th  nowrap="nowrap" align='right' width="10%">
					<ibaBean:message key="com.iba.ehis.lc.enterCleanedLinen.qualityPassed"	bundle="lcLabels" />
				</th>
				<th align="center" width="25%">
					<ibaBean:message key="com.iba.ehis.lc.enterCleanedLinen.natureOfDefect" bundle="lcLabels" />
				</th>
				<th align="center" width="25%">
					<ibaBean:message key="com.iba.ehis.lc.enterCleanedLinen.reasonforDefect" bundle="lcLabels" />
				</th>
			</tr>
			<tr>
				<td  colspan=6 >
					<table border='1' cellpadding='2' cellspacing='0' width='100%' id="contentTable" >
				</td>
			</tr>
		</table>
		
		
		<ibaHTML:hidden property="vo.operatingFacilityId" value="<%=facilityId%>" />
		<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>" />
		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
		<ibaHTML:hidden property="vo.mode" />
		
		<input type=hidden name="userId" id="userId" value="<%=loggedInUser%>" />
		<input type=hidden name="languageId" id="languageId" value="<%=locale%>" />
		<input type=hidden name="vo.locale" id="vo.locale" value="<%=locale%>" />
		<table align="center"><tr><td><input type="button" value="Submit" name="submit" id="submit" class="BUTTON" onclick="apply()" /></td></tr></table>
		</ibaHTML:form>
</body>
</ibaHTML:html>

