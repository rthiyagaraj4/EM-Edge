<!DOCTYPE html>
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Page" %>
<%@ page  import="com.iba.ehis.core.vo.QueryResultVO" %>
<%@ page  import="java.util.List" %>
<%@ page  import="java.util.ArrayList" %>
<%@ page  import="com.iba.framework.core.pojo.web.BaseForm" %>
<%@ page  import="com.iba.framework.core.util.Constants" %>
<%@ include file="/framework/html/Tag.text"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<ibaHtmlEl:html locale="true">
<head>
	<%
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
			String qryEven = "QRYEVEN";
			String qryOdd = "QRYODD";
			String facilityId=(String)session.getAttribute("facility_id");
			String locale = (String) session.getAttribute("LOCALE");

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
		<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/RequestForCleaningLinen/js/RequestForCleaningLinen.js'></script>
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
		<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>

	<Script language="JavaScript" src='<%=request.getContextPath()%>/core/lookup/js/Lookup.js'></Script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenIssue.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<Script language="JavaScript" src='<%=request.getContextPath()%>/framework/js/PopupWindow.js'></Script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/eLC/RequestForCleaningLinen/js/tooltip.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>


<script>

		function doNext() {
		var pageNum=document.getElementById("vo.page.pageNo")
			pageNum.value=parseInt(pageNum.value)+1
			document.PageForm.submit()
		}
		function doPrev() {
			var pageNum=document.getElementById("vo.page.pageNo")
			pageNum.value=parseInt(pageNum.value)-1
			document.PageForm.submit()
		}			
		
</script>

</head>

<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<ibaHTMLEl:form action="/RequestForCleaningLinenPageAction.do">
		<br>
		<div id="next" align="right" style="overflow: auto;">
			<table><tr><td>
						<ibaLogic:equal name="PageForm" property="vo.page.previousPage" value="true">		
						<a href="javascript:doPrev()">
						<ibaBean:message key="com.iba.ehis.lc.previous" bundle="lcLabels" />
						</a>
						</ibaLogic:equal>
						</td>
						<td>
						<ibaLogic:equal name="PageForm" property="vo.page.nextPage"	value="true">
						<a href="javascript:doNext()" >
						<ibaBean:message key="com.iba.ehis.lc.next" bundle="lcLabels" />
						</a></ibaLogic:equal>
						</td>

						</tr></table>
	</div>
	
			<ibaLogic:equal name="PageForm" value="0"
				property="vo.dataObjectsSize">
				<script> 
					alert("<ibaBean:message key='NO_RECORD_FOUND_FOR_CRITERIA' bundle='commonMesages' />");
				</script>
			</ibaLogic:equal>
<table border="1" width="100%" cellspacing='0' cellpadding='0'
			align='center'>
		
			<ibaLogic:notEqual name="PageForm" value="0"
				property="vo.dataObjectsSize">

				<tr >
					
					<th rowspan=2 align="center">
						<ibaBean:message key="com.iba.ehis.lc.standardStock.source"
							bundle="lcLabels" />
					</th>
					<th colspan=2 align="center">
						<ibaBean:message key="com.iba.ehis.lc.request"
							bundle="lcLabels" />

					</th>
					
					<th rowspan=2 align="center">
						<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.linenHandedOverBy"
							bundle="lcLabels" />
					</th>
					<th rowspan=2 align="center">
						<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.linenCollectedBy"
							bundle="lcLabels" />
					</th>
					<th rowspan=2 align="center">
						<ibaBean:message
							key="com.iba.ehis.lc.requestForLinen.requestStatus"
							bundle="lcLabels" />
					</th>

				</tr>
				<tr>
				<th><ibaBean:message key="com.iba.ehis.lc.num" bundle="lcLabels" /></th>
				<th><ibaBean:message key="com.iba.ehis.lc.date"	bundle="lcLabels" /></th>
				</tr>

			</ibaLogic:notEqual>

			<ibaLogic:iterate id="result" name="PageForm"
				property="vo.dataObjects" indexId="rowId">
				<%
				  String style =(rowId.intValue()%2==0)?"QRYEVEN":"QRYODD";
				  //out.println(style);
				%>

				<tr>
					<td class="<%=style%>" align="left">
						
					<input type="hidden" name='sType_<%=rowId%>' id='sType_<%=rowId%>' value='<ibaBean:write name="result" property="sourceType" bundle="lcLabels" />' />
					<input type="hidden" name='sCode_<%=rowId%>' id='sCode_<%=rowId%>' value='<ibaBean:write name="result" property="sourceCode" bundle="lcLabels" />' />
					<input type="text" name='sDesc_<%=rowId%>' id='sDesc_<%=rowId%>' value=" " style="background:transparent;border=0;" readonly="true"/> 
					<script>	
					var stype=document.getElementById("sType_<%=rowId%>").value;
					var scode=document.getElementById("sCode_<%=rowId%>").value;
					LinenIssue.getSourceDesc("<%=locale%>","<%=facilityId%>",stype,scode,callBackDate);
						function callBackDate(data){

							for(prop in data)
							{
								document.getElementById("sDesc_<%=rowId%>").value=data[prop];
							}
						}
					</script>		
					</td>
<%--					<td class="<%=style%>">--%>
<%--						<ibaBean:write name="result" property="sourceType" />--%>
<%--						<input type="hidden" value="<ibaBean:write name='result' id='result' property='sourceType' />" name="sourceType" />--%>
<%--					</td>--%>
					<td class="<%=style%>" align="right">
					<a href='<%=request.getContextPath()%>/eLC/RequestForCleaningLinen/jsp/link.jsp?sourceCode="+<ibaBean:write name="result" property="sourceCode" />+"&sourceType="+<ibaBean:write name="result" property="sourceType" />+"&requestNum="+<ibaBean:write name="result" property="requestNo" />+"&requestDate="+<ibaBean:write name="result" property="requestDate" bundle="lcLabels" />+"&linenCollectedBy="+<ibaBean:write name="result" property="linenCollectedBy" />+"&linenHandedOverBy="+<ibaBean:write name="result" property="linenHandedOverBy" />+"&requestStatus="+<ibaBean:write name="result" property="requestStatus" />+"&linenItem="+<ibaBean:write name="result" property="linenItem"
					/>+"&cancelledBy="+<ibaBean:write name="result" property="cancelledBy" />+"&cancelledDate="+<ibaBean:write name="result" property="cancelledDate" bundle="lcLabels" />+"&reasonCode="+<ibaBean:write name="result" property="reasonCode" />' onclick="return show_hide_box(this,100,35,'2px dashed')">
						<ibaBean:write name="result" property="requestNo" />
					</a>
					<input type="hidden" value="<ibaBean:write name='result' id='result' property='requestNo' />" name="requestNo" />
					</td>
					<td class="<%=style%>" align="left">
						<input type="text" name="requestDate<%=rowId%>" id="requestDate<%=rowId%>" style="background:transparent;border=0;" readonly="true"/> 
						<script>
						
						IBADateValidator.convertDateJS('<ibaBean:write name="result" property="requestDate" bundle="lcLabels" />  ',"en","<%=locale%>","<%=pattern%>",RDFromcallbackMethod);
						function  RDFromcallbackMethod(fdate){
							document.getElementById("requestDate<%=rowId%>").value=fdate;
						// document.write(fdate);
						}
						</script>
						<!--<ibaBean:write name="result" property="requestDate" bundle="lcLabels" />-->
							
					</td>
					<td class="<%=style%>" align="left">
						<ibaBean:write name="result" property="linenHandedOverBy" />
						
					</td>
					<td class="<%=style%>" align="left">
						<ibaBean:write name="result" property="linenCollectedBy" />
						
					</td>
					<td class="<%=style%>" align="left">
						<ibaLogic:equal value="OS" property="requestStatus" name="result">
							<ibaBean:message key="com.iba.ehis.lc.requestForLinen.outstanding" bundle="lcLabels" />
						</ibaLogic:equal>
						<ibaLogic:equal value="PD" property="requestStatus" name="result">
							<ibaBean:message key="com.iba.ehis.lc.requestForLinen.partiallyissued" bundle="lcLabels" />
						</ibaLogic:equal>
						<ibaLogic:equal value="DL" property="requestStatus" name="result">
							<ibaBean:message key="com.iba.ehis.lc.requestForLinen.issued" bundle="lcLabels" />
						</ibaLogic:equal>
						<ibaLogic:equal value="CN" property="requestStatus" name="result">
							<ibaBean:message key="com.iba.ehis.lc.requestForLinen.cancelled" bundle="lcLabels" />
						</ibaLogic:equal>
					</td>
				</tr>
			</ibaLogic:iterate>

		</table>
		<ibaHTML:hidden property="vo.page.pageNo" />
		<ibaHTML:hidden property="method" value="4" />

		<ibaLogicEl:iterate id="result" name="PageForm"
			property="vo.criteriaVo.criteriaItems" indexId="ind">
			<%
							String itemValProp = "vo.criteriaVo.criteriaItems["
							+ ind + "].itemValue";
							String prop = "vo.criteriaVo.criteriaItems[" + ind
							+ "].property";
			%>
			<ibaHTMLEl:hidden property="<%=itemValProp%>" />
			<ibaHTMLEl:hidden property="<%=prop%>" />

		</ibaLogicEl:iterate>
		<ibaHTML:hidden property="vo.criteriaVo.orderBySelected.itemValue" />
		<ibaHTML:hidden property="vo.criteriaVo.queryResultPage" />
		<ibaHTML:hidden property="vo.moduleId" />
		<ibaHTML:hidden property="vo.functionId" />
		<input type="hidden" name="languageId" id="languageId" value="<%=locale%>" />
	</ibaHTMLEl:form>
	
</body>
</ibaHtmlEl:html>

