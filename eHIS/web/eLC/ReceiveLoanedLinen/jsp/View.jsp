<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.IBADate,com.iba.framework.core.util.IBADateTime,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateValidation" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.iba.framework.core.util.Constants"%>
<%@ page  import="com.iba.ehis.lc.core.vo.SourceBean"%>
<%@ include file="/framework/html/Tag.text"%>
<ibaHTML:html locale="true">
<head>
	<%	
	String facilityId=(String)request.getAttribute("facility_Id");
	String functionId = (String) session.getAttribute("functionId");
	String moduleId = (String) session.getAttribute("moduleId");
	String addedById = (String) session.getAttribute("login_user");
	String locale = (String) session.getAttribute("LOCALE");
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"): "IeStyle.css";
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

	SourceBean obj=new SourceBean();
		try
	{
		obj=(SourceBean)CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,"sessid", "objKey");
									
	}catch(Exception e){} 
		
	String src=obj.getSource();
	String srcType=obj.getSourceType();
	String srctype=obj.getSourcetype();
	String srcCode=obj.getSourceCode();
	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script type="text/javascript"	src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/ReceiveLoanedLinen/js/ReceiveLoanedLinen.js'></script>
	<script type='text/javascript'															src='<%=request.getContextPath()%>/dwrlc/interface/ReceiveLoanedLinenList.js'></script>


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

	function assignVal(){
			
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.loanRefNum"].value = dialogArguments[5];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.loanDate"].value = dialogArguments[6];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.sourceType"].value = dialogArguments[3];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.sourceCode"].value = dialogArguments[4];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.loanedToSourceType"].value = dialogArguments[1];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.loanedToSourceCode"].value = dialogArguments[2];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.givenBy"].value = dialogArguments[7];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.receivedBy"].value = dialogArguments[8];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.reasonforLoan"].value = dialogArguments[12];
		//document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.linenItem"].value = dialogArguments[9];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.reasonforLoan"].value = dialogArguments[0];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.loanStatus"].value = dialogArguments[11];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.remarks"].value = dialogArguments[15];
	} 
	
</script>
</head>
<title><%=request.getParameter("title") %></title>
<body onload="assignVal();">
<ibaHTML:form action="/ReceiveLoanedLinenViewAction.do" target="messageFrame">

<table border='0 ' cellpadding='2' cellspacing='0' width='100%'	align='center'>
		<br>	
			<tr>
				<td>
					&nbsp;
				</td><td>
					&nbsp;
				</td><td>
					&nbsp;
				</td><td>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.loanref.Num" bundle="lcLabels" />
				</td>
				<td nowrap="nowrap" class='label'>
					<script>
						document.write(dialogArguments[5]);
					</script>
					<input type="hidden" name="vo.receiveLoanedLinenVO.loanRefNum" id="vo.receiveLoanedLinenVO.loanRefNum" />
				</td>
				<td class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.loanDate" bundle="lcLabels" />
				</td>
				<td nowrap="nowrap" class='label'>
					<script>
						document.write(dialogArguments[20]);
					</script>
					<input type="hidden" name="vo.receiveLoanedLinenVO.loanDate" id="vo.receiveLoanedLinenVO.loanDate" />
					<input type="hidden" name="vo.receiveLoanedLinenVO.loanDate.pattern" id="vo.receiveLoanedLinenVO.loanDate.pattern" value="dd/MM/yyyy HH:mm" />
				</td>

			</tr>
			<tr>
				<td align="left" width="30%" class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.standardStock.sourceType"	bundle="lcLabels" />
				</td>
				<td width="30%" class='label'>
				
				<script>
						document.write('<%=srcType%>');
		//				document.write(dialogArguments[3]);
					</script>
				<input type="hidden" name="vo.receiveLoanedLinenVO.sourceType" id="vo.receiveLoanedLinenVO.sourceType" />
				</td>
				<td align="left" width="20%" class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.source" bundle="lcLabels" />
				</td>
				<td width="40%" nowrap="nowrap" class='label'>
				
					<script>
//						document.write(dialogArguments[4]);
						document.write(dialogArguments[18]);
					</script>
					<input type="hidden" name="vo.receiveLoanedLinenVO.sourceCode" id="vo.receiveLoanedLinenVO.sourceCode" />
				</td>
			</tr>
			<tr>
				<td align="left" width="30%" class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.loanedTo"	bundle="lcLabels" />
				</td>
				<td width="30%" class='label'>
				
				 <script>
					var ss=dialogArguments[1];   
					dialogArguments[1]=trimString(ss);
					var sType="";
					if(dialogArguments[1]=='W'){
					getServerMessage("com.iba.ehis.lc.ward");
					sType=dwrMessage;}
					else if(dialogArguments[1]=='C'){
					getServerMessage("com.iba.ehis.lc.clinic");
					sType=dwrMessage;}
					else if(dialogArguments[1]=='D'){
					getServerMessage("com.iba.ehis.lc.department");
					sType=dwrMessage;}
					else if(dialogArguments[1]=='P'){
					getServerMessage("com.iba.ehis.lc.patient");
					sType=dwrMessage;}
					document.write(sType);
					</script>
					   <!--<script>
						document.write(dialogArguments[18]);
//						document.write(dialogArguments[1]);
					</script>-->
				<input type="hidden" name="vo.receiveLoanedLinenVO.loanedToSourceType" id="vo.receiveLoanedLinenVO.loanedToSourceType" />
				</td>
				<td align="left" width="20%" class='label' nowrap="nowrap">
					
					<ibaBean:message key="com.iba.ehis.lc.standardStock.source"	bundle="lcLabels" />
				</td>
				<td width="40%" nowrap="nowrap" class='label'>
				  <script>
//						document.write(dialogArguments[2]);
						document.write(dialogArguments[19]);
					</script>
					<input type="hidden" name="vo.receiveLoanedLinenVO.loanedToSourceCode" id="vo.receiveLoanedLinenVO.loanedToSourceCode" />
				</td>
			</tr>
			<tr>
				<td class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.givenBy" bundle="lcLabels" />
				</td>
				<td class='label'>
					<script>
						document.write(dialogArguments[7]);
					</script>
				<input type="hidden" name="vo.receiveLoanedLinenVO.givenBy" id="vo.receiveLoanedLinenVO.givenBy" />

				</td>
				<td class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.receivedBy" bundle="lcLabels" />
				</td>
				<td class='label'>
					<script>
						document.write(dialogArguments[8]);
					</script>
				<input type="hidden" name="vo.receiveLoanedLinenVO.receivedBy" id="vo.receiveLoanedLinenVO.receivedBy" />

				</td>
				</tr>
				<tr>
				<td class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.reasonForLoan"	bundle="lcLabels" />
				</td>
				<td class='label'>
					<script>
						if(dialogArguments[0]!=null)
						document.write(dialogArguments[0]);
						else
						document.write(dialogArguments[12]);
					</script>
				<input type="hidden" name="vo.receiveLoanedLinenVO.reasonforLoan" id="vo.receiveLoanedLinenVO.reasonforLoan" />

				</td>
				<td class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.remark"	bundle="lcLabels" />
				</td>
				<td class='label'>
					<script>
						document.write(dialogArguments[15]);
					</script>
				<input type="hidden" name="vo.receiveLoanedLinenVO.remarks" id="vo.receiveLoanedLinenVO.remarks" />

				</td>
				</tr>
				<tr>
				<!--<td class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
				</td>
				<td class='label'>
					<script>
						document.write(dialogArguments[9]);
					</script>
				<input type="hidden" name="vo.receiveLoanedLinenVO.linenItem" id="vo.receiveLoanedLinenVO.linenItem" />

				</td>  -->
				<td class='label' nowrap="nowrap">
					<ibaBean:message
						key="com.iba.ehis.lc.receiveloanedlinen.status"	bundle="lcLabels" />
				</td>
				<td class='label'>
				<script>
						var ss1=dialogArguments[11];   
						dialogArguments[11]=trimString(ss1);
						var sType1="";
						if(dialogArguments[11]=='OS'){
						getServerMessage("com.iba.ehis.lc.requestForLinen.outstanding");
						sType1=dwrMessage;
						document.write(sType1);
						}
						else if(dialogArguments[11]=='L'){
						getServerMessage("com.iba.ehis.lc.receiveloanedlinen.loaned");
						sType1=dwrMessage;
						document.write(sType1);
						}
						else if(dialogArguments[11]=='RB'){
						getServerMessage("com.iba.ehis.lc.receivedBack");
						sType1=dwrMessage;
						document.write(sType1);
						}
						else if(dialogArguments[11]=='CN'){
						getServerMessage("com.iba.ehis.lc.requestForLinen.cancelled");
						sType1=dwrMessage;
						document.write(sType1);
						}
						else if(dialogArguments[11]=='RE'){
						getServerMessage("com.iba.ehis.lc.received");
						sType1=dwrMessage;
						document.write(sType1);
						}
					</script>
					<input type="hidden" name="vo.receiveLoanedLinenVO.loanStatus" id="vo.receiveLoanedLinenVO.loanStatus" />
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td><td>
					&nbsp;
				</td><td>
					&nbsp;
				</td><td>
					&nbsp;
				</td>
		</tr>
		</table>
			<input type="hidden" name="vo.operatingFacilityId" id="vo.operatingFacilityId" value="<%=facilityId%>" />
			<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>" />
			<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
			<ibaHTML:hidden property="method" value="2" />		
			<ibaHTML:hidden property="vo.mode" />
			<input type="hidden" name="languageId" id="languageId" value="<%=locale%>"/>
		
</ibaHTML:form>

<ibaHTML:form action="/ReceiveLoanedLinenViewPageAction.do" target="messageFrame">
		
	<ibaLogic:equal name="PageForm" property="vo.page.nextPage" value="true">
		<a href="javascript:doNext()">
			<ibaBean:message key="com.iba.ehis.lc.next" bundle="lcLabels" />
		</a>
	</ibaLogic:equal>
	
	<ibaLogic:equal name="PageForm" property="vo.page.previousPage" value="true">
		<a href="javascript:doPrev()">
			<ibaBean:message key="com.iba.ehis.lc.previous" bundle="lcLabels" />
		</a>
	</ibaLogic:equal>
	
	<ibaLogic:equal name="ReceiveLoanedLinenForm" value="0" property="vo.receiveLoanedLinenVO.receiveLoanedLinenList">
		<script>
			 var error=getServerMessage("com.iba.ehis.lc.noRecord");
			 parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		</script>
	</ibaLogic:equal>
		<table border='1' cellpadding='2' cellspacing='0' width='100%' id="tableid" align='center'>
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
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.loanedQty" bundle="lcLabels" />
				</th>
				<th align="center">
					<ibaBean:message
						key="com.iba.ehis.lc.receiveloanedlinen.receivedQty" bundle="lcLabels" />
				</th>
			</tr>

		<ibaLogic:iterate id="result" name="ReceiveLoanedLinenForm" property="vo.receiveLoanedLinenVO.receiveLoanedLinenList" indexId="rowId">
			<!--<script>
				ReceiveLoanedLinenList.getLinenItem("<%=locale%>",'<ibaBean:write name="result" property="linenItem" bundle="lcLabels" />',callBackLinenDesc);
				function callBackLinenDesc(data){
						for(prop in data)
				document.getElementById("lDesc_<%=rowId%>").value=data[prop];
				}
			</script>-->
			<%	
			  	String style =(rowId.intValue()%2==0)?"QRYEVEN":"QRYODD";
				  //out.println(style);
			%>
			<tr class="label" >
				<td class="<%=style %>" align='left'>
					<!--	<input type="hidden" name='lDesc_<%=rowId%>' id='lDesc_<%=rowId%>'/> 
						<script>
						  // alert(document.getElementById('lDesc_<%=rowId%>').value)
						document.write(document.getElementById('lDesc_<%=rowId%>').value);
						</script>-->
						
					<ibaBean:write name="result" property="linenItem"  />
				</td>
				<td class="<%=style %>" align='right'>
					<ibaBean:write name="result" property="loanedQty" bundle="lcLabels" />
				</td>
				<td class="<%=style %>" align='right'>
					<ibaBean:write name="result" property="receivedQty" bundle="lcLabels"  />
				</td>
			</tr>
			
			</ibaLogic:iterate>
						
		</table>
</ibaHTML:form>
</body>


</ibaHTML:html>
	

