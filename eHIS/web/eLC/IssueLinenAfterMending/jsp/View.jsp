<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateTime" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Page" %>
<%@ page  import="java.util.List" %>
<%@ page  import="java.util.ArrayList" %>
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
					String qryEven = "QRYEVEN";
			String qryOdd = "QRYODD";
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
			//	String locale=userPrefs.getLocale();
	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type="text/javascript"	src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	
	<script type="text/javascript">
	var contentList =new Hashtable();
 
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
<title><%=request.getParameter("title") %></title>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<ibaHTML:form action="/IssueLinenAfterMendingViewAction.do" target="messageFrame">
<br><br>
<table border='0 ' cellpadding='2' cellspacing='0' width='100%'	align='center'>
			<tr>
				<td class='label' nowrap="nowrap" >
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestNum"
						bundle="lcLabels" />
				</td>
				<td nowrap="nowrap" class='label' align="left">
				<script>
					document.write(dialogArguments[1])
				</script>
				<input type="hidden" name="vo.issueOfLinenVO.requestNum" id="vo.issueOfLinenVO.requestNum" />
				</td>
				<td class='label' nowrap="nowrap" >
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestDate" bundle="lcLabels" />
				</td>
				<td nowrap="nowrap" class='label' align='left'>
					<script>
						document.write(dialogArguments[2])
					</script>
					<input type="hidden" name="vo.issueOfLinenVO.requestDate" id="vo.issueOfLinenVO.requestDate" />
					<input type="hidden" name="vo.issueOfLinenVO.requestDate.pattern" id="vo.issueOfLinenVO.requestDate.pattern" value="<%=pattern%>" />
				</td>
			</tr>
			
			<tr>
				<td class='label' nowrap="nowrap" >
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.raisedBy"	bundle="lcLabels" />
				</td>
				<td class='label' align="left">
					<script>
						document.write(dialogArguments[3])
					</script>
					<input type="hidden" name="vo.issueOfLinenVO.raisedBy" id="vo.issueOfLinenVO.raisedBy" />
				</td>
				<td class='label' nowrap="nowrap" align="left">
					<ibaBean:message
						key="com.iba.ehis.lc.requestForLinen.requestStatus"	bundle="lcLabels" />
				</td>
				<td class='label'>
					<script>
								
						dialogArguments[4]=trimString(dialogArguments[4]);
						var sType1="";
						if(dialogArguments[4]=='OS'){
						getServerMessage("com.iba.ehis.lc.requestForLinen.outstanding");
						sType1=dwrMessage;
						document.write(sType1)
						}
						else if(dialogArguments[4]=='RE'){
						getServerMessage("com.iba.ehis.lc.requestForLinen.issued");
						sType1=dwrMessage;
						document.write(sType1)
						}
						else if(dialogArguments[4]=='PR'){
						getServerMessage("com.iba.ehis.lc.requestForLinen.partiallyissued");
						sType1=dwrMessage;
						document.write(sType1)
						}
						else if(dialogArguments[4]=='CN'){
						getServerMessage("com.iba.ehis.lc.requestForLinen.cancelled");
						sType1=dwrMessage;
						document.write(sType1)
						}
						
					</script>
				
					<input type=hidden name="vo.issueOfLinenVO.requestStatus" id="vo.issueOfLinenVO.requestStatus" readonly="true" class='label' style="background:transparent;border=0"/>
				</td>
			</tr>
			<input type="hidden" name="vo.issueOfLinenVO.locale" id="vo.issueOfLinenVO.locale" value="<%=locale%>">
		</table>
			
		
		
</ibaHTML:form>

<ibaHTML:form action="/RequestForLinenViewPageAction.do" target="messageFrame">
		
				<ibaLogic:equal name="PageForm" property="vo.page.nextPage"
					value="true">
					
						<a href="javascript:doNext()">
						<ibaBean:message key="com.iba.ehis.lc.next" bundle="lcLabels" />
						</a>
					
				</ibaLogic:equal>
				
				<ibaLogic:equal name="PageForm" property="vo.page.previousPage"
					value="true">
			
						<a href="javascript:doPrev()">
						<ibaBean:message key="com.iba.ehis.lc.previous" bundle="lcLabels" />
						</a>
				</ibaLogic:equal>
	
			
<table border='1' cellpadding='2' cellspacing='0' width='100%'
			id="tableid" align='center' >
			<tr>
				<th align="left" colspan=5>
					<ibaBean:message key="com.iba.ehis.lc.linenItemDetail" bundle="lcLabels" />
				</th>
			</tr>
			<tr>

				<th align="center">
					<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
				</th>
				<th align="center">
					<ibaBean:message
						key="com.iba.ehis.lc.sentQty"
						bundle="lcLabels" />
				</th>
				<th align="center">
					<ibaBean:message
						key="com.iba.ehis.lc.loanLinen.receivedQty"
						bundle="lcLabels" />
				</th>
				<th align="center">
					<ibaBean:message
						key="com.iba.ehis.lc.requestForLinen.pendingQuantity"
						bundle="lcLabels" />
				</th>
				<th align="center">
					<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" />
				</th>

			</tr>
		
			<ibaLogic:iterate id="result" name="IssueLinenAfterMendingForm"
				property="vo.requestsListVO.linenRequest" indexId="rowId">
				<%
				  String style =(rowId.intValue()%2==0)?"QRYEVEN":"QRYODD";
				  //out.println(style);
				%>
				<tr>
						<td class="<%=style %>">
						<ibaBean:write name="result" property="linenItem" />
					</td>

						<td class="<%=style %>" align="right">
						
						<ibaBean:write name="result" property="issuedQty" bundle='lcLabels' />
						<input type="hidden" value="<ibaBean:write name='result' id='result' property='issuedQty' bundle='lcLabels' />" name="requestedQty<%=rowId %>" />
					</td>
						<td class="<%=style %>" align="right">
						<ibaBean:write name="result" property="requestedQty" bundle="lcLabels" />			
						<input type="hidden" value="<ibaBean:write name='result' id='result' property='requestedQty' bundle='lcLabels' />" name="issueQty<%=rowId %>" />
					</td>
					<td class="<%=style %>" align="right">
					<input type="hidden" name="pendingQty<%=rowId%>" id="pendingQty<%=rowId%>" />
					<script>
						var val<%=rowId%>=parseInt(document.getElementById("requestedQty<%=rowId%>").value-document.getElementById("issueQty<%=rowId%>").value);
										document.getElementById("pendingQty<%=rowId%>").value=val<%=rowId%>;
					var temp=<%=rowId%>;
					if(parseInt(temp)>=1)
					{	temp=parseInt(temp)-1;
					var pQty<%=rowId%>=parseInt(document.getElementById("pendingQty"+temp).value)-parseInt(document.getElementById("issueQty"+<%=rowId%>).value);
					document.getElementById("pendingQty<%=rowId%>").value=pQty<%=rowId%>;
					document.write(pQty<%=rowId%>);
					}
					else
					{
					document.write(val<%=rowId%>);
					}
					</script>
					</td>
					<td class="<%=style %>">
						<ibaBean:write name="result" property="remark" bundle="lcLabels"/>
					</td>
				
				</tr>
								
			</ibaLogic:iterate>
			
		</table>
		
	<input type="hidden" name="vo.issueOfLinenVO.locale" id="vo.issueOfLinenVO.locale" value="<%=locale%>">
</ibaHTML:form>
	<script type="text/javascript">
			document.getElementById("vo.issueOfLinenVO.requestNum").value= dialogArguments[1];
			document.getElementById("vo.issueOfLinenVO.requestDate").value= dialogArguments[2];
		
			document.getElementById("vo.issueOfLinenVO.raisedBy").value= dialogArguments[3];
			//document.getElementById("vo.issueOfLinenVO.requestStatus").value= dialogArguments[4];

			document.getElementById("vo.issueOfLinenVO.requestStatus").value=dialogArguments[4];
		
	</script>
</body>
</ibaHTML:html>

