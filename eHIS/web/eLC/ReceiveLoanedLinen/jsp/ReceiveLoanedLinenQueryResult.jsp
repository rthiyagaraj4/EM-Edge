<!DOCTYPE html>
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADateTime,com.iba.framework.core.util.IBADateValidation,,com.iba.ehis.lc.core.util.LcDateFormat" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Page" %>
<%@ page  import="com.iba.ehis.core.vo.QueryResultVO" %>
<%@ page  import="java.util.List" %>
<%@ page  import="java.util.ArrayList" %>
<%@ page  import="com.iba.framework.core.pojo.web.BaseForm" %>
<%@ page  import="com.iba.ehis.dobj.LcRequestDtl"%>
<%@ page  import="com.iba.framework.core.util.Constants" %>
<%@ include file="/framework/html/Tag.text" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<ibaHtmlEl:html locale="true">

<head>
	<%
			String facilityId=(String)session.getAttribute("facility_id");
			String locale=(String)session.getAttribute("LOCALE");
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
			String qryEven = "QRYEVEN";
			String qryOdd = "QRYODD";

			UserPreferences userPrefs =new UserPreferences();
			/* Cache cache = CacheManager.getCache();
			userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */
		
							
			String timepattrn=userPrefs.getTimeFormat();
			String sb=userPrefs.getDateFormat();
			String pattern=sb+" "+timepattrn;
		
	%>
	
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<Script language="JavaScript" src='<%=request.getContextPath()%>/core/lookup/js/Lookup.js'></Script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/eLC/ReceiveLoanedLinen/js/tooltip.js"></script>
	<script type='text/javascript'															src='<%=request.getContextPath()%>/dwrlc/interface/ReceiveLoanedLinenList.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenIssue.js'></script>
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
<body>
	<ibaHTMLEl:form action="/ReceiveLoanedLinenPageAction.do">
	<br>
		<table>
		<tr>
			<ibaLogic:equal name="PageForm" property="vo.page.nextPage" value="true">
				<td>
				<a href="javascript:doNext()">
					<ibaBean:message key="com.iba.ehis.lc.next" bundle="lcLabels" />
					</a>
					</td>
			</ibaLogic:equal>
			<ibaLogic:equal name="PageForm" property="vo.page.previousPage" value="true">
				<td>
					<a href="javascript:doPrev()">
						<ibaBean:message key="com.iba.ehis.lc.previous" bundle="lcLabels" />
					</a>
				</td>
			</ibaLogic:equal>
			</tr></table>
			<ibaLogic:equal name="PageForm" value="0" property="vo.dataObjectsSize">
			<script> 
				alert("<ibaBean:message key='NO_RECORD_FOUND_FOR_CRITERIA' bundle='commonMesages' />");
			</script>
		</ibaLogic:equal>
		<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
			<ibaLogic:notEqual name="PageForm" value="0" property="vo.dataObjectsSize">
				<tr>
					<th>
						<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.loanedTo" bundle="lcLabels" />
					</th>
					<th>
						<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.ref.Num" bundle="lcLabels" />
					</th>
					<th>
						<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.loanDate" bundle="lcLabels" />
					</th>
					<th>
						<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.givenBy" bundle="lcLabels" />
					</th>
					<th>
						<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.receivedBy" bundle="lcLabels" />
					</th>
					<th>
						<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.linenItem" bundle="lcLabels" />
					</th>
					<th>
						<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.reson" bundle="lcLabels" />
					</th>
					<th>
						<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.status" bundle="lcLabels" />
					</th>
				</tr>
			</ibaLogic:notEqual>

			<ibaLogic:iterate id="result" name="PageForm" 	property="vo.dataObjects" indexId="rowId">
			<%
				  String style =(rowId.intValue()%2==0)?"QRYEVEN":"QRYODD";
			%>	

				<tr>
					<td class="<%=style%>" align='left'>
					<input type="hidden" name='sType_<%=rowId%>' id='sType_<%=rowId%>' value='<ibaBean:write name="result" property="loanedToSourceType" bundle="lcLabels"/>' />
					<input type="hidden" name='sCode_<%=rowId%>' id='sCode_<%=rowId%>' value='<ibaBean:write name="result" property="loanedToSourceCode" bundle="lcLabels" />' />
					<input type="text" name='sDesc_<%=rowId%>' id='sDesc_<%=rowId%>' value=" " style="background:transparent;border=0;" readonly="true" /> 
					<script>	
					var stype=document.getElementById("sType_<%=rowId%>").value;
					var scode=document.getElementById("sCode_<%=rowId%>").value;
					LinenIssue.getSourceDesc("<%=locale%>","<%=facilityId%>",stype,scode,callBackDate);
						function callBackDate(data){
							for(prop in data)
								document.getElementById("sDesc_<%=rowId%>").value=data[prop];
							}
					</script>		
					</td>
					<td class="<%=style%>" align='right'>
						<a href='<%=request.getContextPath()%>/eLC/ReceiveLoanedLinen/jsp/link.jsp?
						
							sourceCode="+<ibaBean:write name="result" property="sourceCode" />
							+"&sourceType="+<ibaBean:write name="result" property="sourceType" bundle="lcLabels" />
							+"&loanRefNum="+<ibaBean:write name="result" property="loanRefNum" />
							+"&loanDate="+<ibaBean:write name="result" property="loanDate" bundle="lcLabels" />
							+"&givenBy="+<ibaBean:write name="result" property="givenBy" />
							+"&receivedBy="+<ibaBean:write name="result" property="receivedBy" />
							+"&loanedToSourceType="+<ibaBean:write name="result" property="loanedToSourceType" />
							+"&loanedToSourceCode="+<ibaBean:write name="result" property="loanedToSourceCode" />
							+"&receivedBy="+<ibaBean:write name="result" property="receivedBy" />
							+"&reasonForLoan="+<ibaBean:write name="result" property="reasonforLoan" />
							+"&givenBackBy="+<ibaBean:write name="result" property="givenBackBy" />
							+"&receivedBackBy="+<ibaBean:write name="result" property="receivedBackBy" />
							+"&receivedWriteOff="+<ibaBean:write name="result" property="receivedWriteOff" />
							+"&remarks="+<ibaBean:write name="result" property="remarks" />
							+"&linenItem="+<ibaBean:write name="result" property="linenItem" />
							+"&linenDesc="+<ibaBean:write name="result" property="shortDesc" />
							+"&loanStatus="+<ibaBean:write name="result" property="loanStatus" />+"&loanQty="+<ibaBean:write name="result" property="loanQty" bundle="lcLabels" />+"&receivedQty="+<ibaBean:write name="result" property="receivedQty" bundle="lcLabels" />" '
								onclick="return show_hide_box(this,110,35,'2px dashed')" >
							<ibaBean:write name="result" property="loanRefNum" />
							
						</a>
					</td>				
					<td class="<%=style%>" align='left'>
						<input type="text" name="receiveLoanDate<%=rowId%>" id="receiveLoanDate<%=rowId%>" style="background:transparent;border=0;" readonly="true"/> 
						<script>
						IBADateValidator.convertDateJS('<ibaBean:write name="result" property="loanDate" bundle="lcLabels" />  ',"en","<%=locale%>","<%=pattern%>",RDFromcallbackMethod);
						function  RDFromcallbackMethod(fdate){
						document.getElementById("receiveLoanDate<%=rowId%>").value=fdate;
						// document.write(fdate);
						}
						</script>
						<!--<ibaBean:write name="result" property="loanDate" bundle="lcLabels" />-->
					</td>
					<td class="<%=style%>" align='left'>
						<ibaBean:write name="result" property="givenBy"/>
						
					</td>
					<td class="<%=style%>" align='left'>
						<ibaBean:write name="result" property="receivedBy" />
						
					</td>
					<td class="<%=style%>" align='left'>
						<input type="hidden" name='lCode_<%=rowId%>' id='lCode_<%=rowId%>' value='<ibaBean:write name="result" property="linenItem" bundle="lcLabels" />' />
						<input type="text" name='lDesc_<%=rowId%>' id='lDesc_<%=rowId%>' value=" " style="background:transparent;border=0;" readonly="true" /> 
						<script>
						var lcode=document.getElementById("lCode_<%=rowId%>").value;
						ReceiveLoanedLinenList.getLinenItem("<%=locale%>",lcode,callBackLinenDesc);
							function callBackLinenDesc(data){
								for(prop in data)
									document.getElementById("lDesc_<%=rowId%>").value=data[prop];
							}
						</script>	
					<!--	<ibaBean:write name="result" property="linenItem" />-->
						
					
					</td>
					<td class="<%=style%>" align='left'>
						<ibaBean:write name="result" property="reasonforLoan" />
	
					</td>
					<td class="<%=style%>" align='left'>
						<ibaLogic:equal value="OS" property="loanStatus" name="result">
							<ibaBean:message key="com.iba.ehis.lc.requestForLinen.outstanding" bundle="lcLabels" />
						</ibaLogic:equal>
						<ibaLogic:equal value="L" property="loanStatus" name="result">
							<ibaBean:message key="com.iba.ehis.lc.loaned" bundle="lcLabels" />
						</ibaLogic:equal>
						<ibaLogic:equal value="CN" property="loanStatus" name="result">
							<ibaBean:message key="com.iba.ehis.lc.requestForLinen.cancelled" bundle="lcLabels" />
						</ibaLogic:equal>
						<ibaLogic:equal value="RB" property="loanStatus" name="result">
							<ibaBean:message key="com.iba.ehis.lc.receivedBack" bundle="lcLabels" />
						</ibaLogic:equal>
						<ibaLogic:equal value="RE" property="loanStatus" name="result">
							<ibaBean:message key="com.iba.ehis.lc.received" bundle="lcLabels" />
						</ibaLogic:equal>
						<!--<ibaBean:write name="result" property="loanStatus" />-->
						
					</td>
				</tr>
			
			</ibaLogic:iterate>
		</table>
		<ibaHTML:hidden property="vo.page.pageNo" />
		<ibaHTML:hidden property="method" value="4" />

		<ibaLogicEl:iterate id="result" name="PageForm" property="vo.criteriaVo.criteriaItems" indexId="ind">
			<%
					String itemValProp = "vo.criteriaVo.criteriaItems[" + ind + "].itemValue";
					String prop = "vo.criteriaVo.criteriaItems[" + ind + "].property";
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

