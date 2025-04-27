<!DOCTYPE html>
<%
/**
* @Module		: Medical Records..[MR]
* @Author		: SRIDHAR R 
* @Created on	: 23 MARCH 2005
**/
%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,java.text.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%
String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String call_function = request.getParameter("call_function")==null?"":request.getParameter("call_function");
String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");

%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eMR/js/MedBoardRequest.js' language='javascript'></script>	
		<script src='../../eMR/js/MedBoardReqTransaction.js' language='javascript'></script>	
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function tab_click(objName)
			{
				if(objName == 'request')
				{
					parent.frames[2].location.href = "../../eMR/jsp/MedBoardRequestDetail.jsp?call_function=<%=call_function%>";
					parent.frames[3].location.href = "../../eMR/jsp/MedBoardRequestDetailTabs.jsp?call_function=<%=call_function%>";
					parent.frames[0].document.forms[0].apply.disabled = false;

					document.getElementById("requestSpan").className="tabSpanclicked";
					document.getElementById("statusSpan").className="tabAspan";

					document.getElementById("requestTab").className="tabClicked";
					document.getElementById("statusTab").className="tabA";
				}
				else if(objName == 'status')
				{
					parent.frames[2].location.href = "../../eMR/jsp/ReportRequestQueryCriteria.jsp?request_type=MB&function_id=<%=function_id%>";
					parent.frames[3].location.href = "../../eCommon/html/blank.html";
					parent.frames[0].document.forms[0].apply.disabled = true;
					
					document.getElementById("requestSpan").className="tabAspan";
					document.getElementById("statusSpan").className="tabSpanclicked";
	
					document.getElementById("requestTab").className="tabA";
					document.getElementById("statusTab").className="tabClicked";
				}
			}
		</script>
	</head>
	<body   OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name="MedicalReportTabs_form" id="MedicalReportTabs_form" >
			<table border="0" width="100%" cellspacing='0' cellpadding='0'>
				<tr>
					<td width="100%" class="white">
						<ul id="tablist" class="tablist" style="padding-left:0px">
							<li class="tablistitem" title="Request">
								<a  onclick="tab_click('request')" class="tabClicked"  id='requestTab'>
									<span class="tabSpanclicked" id='requestSpan'><fmt:message key="Common.Request.label" bundle="${common_labels}"/></span>
								</a>
							</li>
							<li class="tablistitem" title="Status">
								<a onclick="tab_click('status')" class="tabA" id='statusTab'>
									<span class="tabAspan" id='statusSpan' ><fmt:message key="Common.status.label" bundle="${common_labels}"/></span>
								</a>
							</li>
						</ul>
					</td>
				</tr>
			</table> 
			<script>tab_click('request');</script>
		</form>
	</body>
</html>

