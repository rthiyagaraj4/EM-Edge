<!DOCTYPE html>
<%
/**
* @Module		: Medical Records..[MR]
* @Author		: SRIDHAR R 
* @Created on	: 23 MARCH 2005
**/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,java.text.*,java.sql.*,webbeans.eCommon.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String call_function= checkForNull(request.getParameter("call_function"));

%>
<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function tab_click(objName)
			{
				if(objName == 'request')
				{
					parent.frames[2].location.href = "../../eMR/jsp/MedRecRequestCriteria.jsp?function_id=<%=call_function%>&call_function=<%=call_function%>";
					parent.frames[3].location.href = "../../eCommon/html/blank.html";
					document.getElementById("requestSpan").className="tabSpanclicked";
					document.getElementById("statusSpan").className="tabAspan";

					document.getElementById("requestTab").className="tabClicked";
					document.getElementById("statusTab").className="tabA";
					parent.document.getElementById("criteriaFrame").style.height = "35vh";
					parent.document.getElementById("resultFrame").style.height = "45vh";
				}
				else if(objName == 'status')
				{
					parent.frames[2].location.href = "../../eMR/jsp/ReportRequestQueryCriteria.jsp?request_type=MR&function_id=<%=call_function%>";	parent.frames[3].location.href = "../../eCommon/html/blank.html";
					document.getElementById("requestSpan").className="tabAspan";
					document.getElementById("statusSpan").className="tabSpanclicked";

					document.getElementById("requestTab").className="tabA";
					document.getElementById("statusTab").className="tabClicked";
					parent.document.getElementById("criteriaFrame").style.height = "51vh";
					parent.document.getElementById("resultFrame").style.height = "32vh";
				}
			}
		</script>
	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name="MedicalReportTabs_form" id="MedicalReportTabs_form" >
			<table border="0" width="100%" cellspacing='0' cellpadding='0'>
				<tr>
					<td width="100%" class="white" align="left">
						<ul id="tablist" class="tablist"  align="left" style="margin-left: -36px;" >
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



<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

