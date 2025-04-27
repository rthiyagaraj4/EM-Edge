<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADateTime,com.iba.framework.core.util.IBADateValidation,,com.iba.ehis.lc.core.util.LcDateFormat" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.ehis.core.vo.QueryCriteriaVO"%>

<%@ page  import="com.iba.ehis.core.vo.QueryCriteriaItem"%>
<%@ page  import="com.iba.framework.core.util.Constants"%>
<%@ page  import="com.iba.ehis.lc.core.vo.SourceBean"%>
<%@ include file="/framework/html/Tag.text"%>

<ibaHTML:html locale="true">
<head>
	<% 	
		String title=(String)request.getParameter("title");
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
		
		SourceBean obj=new SourceBean();
		try
		{
			/* obj=(SourceBean)CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,				
					"sessid", "objKey"); */
									

		}catch(Exception e){} 
	
		String src=obj.getSource();
		String srcType=obj.getSourceType();
		String srctype=obj.getSourcetype();
		String srcCode=obj.getSourceCode();

		%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>

	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/ReceiveLoanedLinen/js/ReceiveLoanedLinenCUD.js'>
	</script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenIssue.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
					
<script>
function setStatus(){

var val=document.getElementById("vo.receiveLoanedLinenVO.receivedWriteOff").value;
if(val=="R")
	document.getElementById("vo.receiveLoanedLinenVO.loanStatus").value="RE";
else 
	document.getElementById("vo.receiveLoanedLinenVO.loanStatus").value="WO";
}
function checkQty(arg){
		obj =  String.fromCharCode(window.event.keyCode);
   		var alphaFilter =/^[0-9]+$/;
   		if (!(alphaFilter.test(obj))) { 
	   	getServerMessage("message.Numbers.Allowed");
		alert(dwrMessage);
	   	window.event.keyCode = 27;
		arg.value="";
	   }
	}

function convertDate(){
		var rdate= document.getElementById("vo.receiveLoanedLinenVO.loanDate");	IBADateValidator.convertDateJS(rdate.value,"en","<%=locale%>","<%=pattern%>",RDFromcallbackMethod);
					function  RDFromcallbackMethod(fdate){
						document.getElementById("loanDate").value=fdate;
					}
}

</script>
</head>
<title><%=title%></title>
<body onload="assignVal();convertDate()">
	<ibaHTML:form action="/ReceiveLoanedLinenAction.do" target="messageFrame">
		<table border='0 ' cellpadding='2' cellspacing='0' width='100%' align='center'>
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
				<td align="right" class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.ref.Num" bundle="lcLabels" />
				</td>
				<td align="left" class='label' nowrap="nowrap" colspan="3">
					<ibaHTML:text property="vo.receiveLoanedLinenVO.loanRefNum"
						maxlength="10" size="10" readonly="true" />
						&nbsp&nbsp
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.loanDate"
						bundle="lcLabels" />
					
					<input type="text" name="loanDate" id="loanDate" maxlength="16" size="16" readonly="true" />
					<ibaHTML:hidden property="vo.receiveLoanedLinenVO.loanDate"/>
					<ibaHTML:hidden property="vo.receiveLoanedLinenVO.loanDate.pattern" value="dd/MM/yyyy HH:mm" />
					
				</td>
				
			</tr>
		<tr>
			<td align="right" class='label'  nowrap="nowrap">
			<ibaBean:message key="com.iba.ehis.lc.standardStock.sourceType"
									bundle="lcLabels" />
				
					</td>
						<td align="left" class='label'  nowrap="nowrap">
						<input type=text name="sourceType" id="sourceType" maxlength="10" size="10" readonly="true"/>
						<ibaHTML:hidden property="vo.receiveLoanedLinenVO.sourceType" />
						&nbsp&nbsp&nbsp&nbsp&nbsp
						<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.source" bundle="lcLabels" />
					<!--	<ibaHTML:text property="vo.receiveLoanedLinenVO.sourceCode" maxlength="30" size="30" readonly="true" value="<%=src%>"/>-->
					<input type=text name="sourceCode" id="sourceCode" maxlength="30" size="30" readonly="true" value="<%=src%>"/>
					<ibaHTML:hidden property="vo.receiveLoanedLinenVO.sourceCode" />
						</td>
						<td>
					</td>
				<td></td>
				</tr>
			<tr>
				<td align="right" class='label'  nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.loanedTo" bundle="lcLabels" />
				</td>
				<td align="left" class='label'  nowrap="nowrap">
					
					<input type=text name="loanedToSourceType" id="loanedToSourceType" maxlength="10" size="10" readonly="true"/>
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.source" bundle="lcLabels" />
					<!--<ibaHTML:text property="vo.receiveLoanedLinenVO.loanedToSourceCode" maxlength="30" size="30" readonly="true"/>
					<ibaHTML:hidden property="vo.receiveLoanedLinenVO.loanedToSourceCode" />
					<input type=text name="loanSourceCode" id="loanSourceCode" maxlength="30" size="30" readonly="true"/> -->

					<ibaHTML:hidden property="vo.receiveLoanedLinenVO.loanedToSourceType" />
					<ibaHTML:hidden property="vo.receiveLoanedLinenVO.loanedToSourceCode" />

					<input type=text name="sourceDesc" id="sourceDesc" maxlength="30" size="30" readonly="true" value=" " />
					<script>	
					var stype=document.getElementById("vo.receiveLoanedLinenVO.loanedToSourceType").value;
					stype=trimString(stype);
					var scode=document.getElementById("vo.receiveLoanedLinenVO.loanedToSourceCode").value;
					scode=trimString(scode);
					
					LinenIssue.getSourceDesc("<%=locale%>","<%=facilityId%>",stype,scode,callBackSource1);
						function callBackSource1(data){
							for(prop in data){		   								
								document.getElementById("sourceDesc").value=data[prop];
										  }
							}
					</script>	
				</td>
				<td></td>
				<td></td>
				</tr>
				<tr >
					<td  align="right" class='label'  nowrap="nowrap">
						<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.givenBy" bundle="lcLabels" />
					</td>
					<td>
					 <ibaHTML:text property="vo.receiveLoanedLinenVO.givenBy"  maxlength="30" size="30" readonly="true"/>
				
						
				</td><td>
				</td><td>
				</td>
			</tr>	
			<tr>
				<td align="right" class='label'  nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.receivedBy" bundle="lcLabels" />
				</td>
				<td >
					<ibaHTML:text property="vo.receiveLoanedLinenVO.receivedBy" maxlength="30" size="30" readonly="true"/>
				</td>
					<td>
					</td><td>
				</tr>
				<tr>
				<td align="right" class='label'  nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.reasonForLoan" bundle="lcLabels" />
				</td>
				<td >
					<ibaHTML:text property="vo.receiveLoanedLinenVO.reasonforLoan" maxlength="100" size="30" readonly="true"/>
					
				
				</td>					
				<td>
				</td>
				<td></td>
				</tr>
				
				<tr>
				<td align="right" class='label'  nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" />
				</td>
					<td >
						<ibaHTML:text property="vo.receiveLoanedLinenVO.remarks" maxlength="100" size="30" readonly="true"/>
						<ibaHTML:hidden property="vo.receiveLoanedLinenVO.remarks"/>
					</td>
			<td></td>
			<td></td>
			</tr>
			</table>
			<table border='0 ' cellpadding='2' cellspacing='0' width='100%' align='center'>
			<tr>
				<th align="left" colspan='4' >
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.loanReceiptDetails" bundle="lcLabels" />
				</th>
				
			<tr>
				<td align="right" class='label'>
					<ibaBean:message key="com.iba.ehis.lc.receive/writeOff" bundle="lcLabels" />
					</td>
						<td>
							<ibaHTML:select property="vo.receiveLoanedLinenVO.receivedWriteOff" onchange="receivedQtyStatus();">
								<ibaHTML:option value="R"><ibaBean:message key="com.iba.ehis.lc.received" bundle="lcLabels" />
								</ibaHTML:option>
								<ibaHTML:option value="W"><ibaBean:message key="com.iba.ehis.lc.writeOff" bundle="lcLabels" />
								</ibaHTML:option>
							</ibaHTML:select>
							<img src="framework/images/mandatory.gif"></img>
						<td>
					</td>
				<td></td>
			</tr>	
			<tr>
				<td align="right" class='label'>
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.loanedQty" bundle="lcLabels" />
				</td>
				<td>
					<ibaHTML:text property="vo.receiveLoanedLinenVO.loanQty" maxlength="5" size="5" readonly='true' />
				</td>
					<td>
					</td><td>
				</tr>
				<tr>
			<tr>
				<td align="right" class='label'>
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.receivedQty" bundle="lcLabels" />
				</td>
				<td>
					<ibaHTML:text value="" property="vo.receiveLoanedLinenVO.receivedQty" maxlength="5" size="5" onkeypress="checkQty(this);" onblur="setStatus();checkReceivedQty();"/>
					<img src="framework/images/mandatory.gif" id="hide" ></img>
				</td>
					<td>
					</td><td>
				</tr>
				<tr>
				<td align="right" class='label'>
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.receivedBackBy" bundle="lcLabels" />
					</td><td>
					<ibaHTML:text property="vo.receiveLoanedLinenVO.receivedBackBy" maxlength="30" size="30" value="<%=addedById%>"/>
					<img src="framework/images/mandatory.gif"></img>
				</td>
				<td>
				</td><td>
			</tr>
			<tr>
				<td align="right" class='label'>
					<ibaBean:message key="com.iba.ehis.lc.receiveloanedlinen.givenBackBy" bundle="lcLabels" />
					</td><td>
					<ibaHTML:text property="vo.receiveLoanedLinenVO.givenBackBy" maxlength="30" size="30" />
					<ibaHTML:hidden property="vo.receiveLoanedLinenVO.loanQty" />
					<ibaHTML:hidden property="vo.receiveLoanedLinenVO.loanStatus" />
					<img src="framework/images/mandatory.gif"></img>
				</td>
				<td>
				</td><td>
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
				<tr>
					<td colspan="4" align='center'>
						<input class="BUTTON" type="button" name="Submit1" id="Submit1" value="Submit" onmouseover="setStatus()" onclick="submitFormNullCheck();"/>

					</td>
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

		<ibaHTML:hidden property="vo.operatingFacilityId" value="<%=facilityId%>" />
		<ibaHTML:hidden property="vo.functionId" value="LC_LOAN_LINEN" />
		<ibaHTML:hidden property="vo.moduleId" value="LC" />
		<ibaHTML:hidden property="vo.mode"/>
		<ibaHTML:hidden property="method" value='2'/>
		<input type="hidden" name="languageId" id="languageId" value="<%=locale%>"/>
								
	</ibaHTML:form>
</body>
<script>
document.getElementById("vo.receiveLoanedLinenVO.loanQty").value=dialogArguments[16];
var source=document.getElementById("vo.receiveLoanedLinenVO.sourceType").value;
source=trimString(source);
var obj=document.getElementById("sourceType");
if(source=="W")
{getServerMessage("com.iba.ehis.lc.ward");
var msg=dwrMessage;
obj.value=msg;}
else if(source=="D")
{getServerMessage("com.iba.ehis.lc.department");
var msg=dwrMessage;
obj.value=msg;}
else if(source=="C")
{getServerMessage("com.iba.ehis.lc.clinic");
var msg=dwrMessage;
obj.value=msg;}

var sourceTo=document.getElementById("vo.receiveLoanedLinenVO.loanedToSourceType").value;
sourceTo=trimString(sourceTo);
var obj1=document.getElementById("loanedToSourceType");
if(sourceTo=="W")
{getServerMessage("com.iba.ehis.lc.ward");
var msg=dwrMessage;
obj1.value=msg;}
else if(sourceTo=="D")
{getServerMessage("com.iba.ehis.lc.department");
var msg=dwrMessage;
obj1.value=msg;}
else if(sourceTo=="C")
{getServerMessage("com.iba.ehis.lc.clinic");
var msg=dwrMessage;
obj1.value=msg;}


</script>
</ibaHTML:html>

