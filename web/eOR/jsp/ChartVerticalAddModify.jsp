<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8" %>
<%@ page import ="java.sql.*,webbeans.eCommon.*"   %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>

	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eOR/js/OrCommonFunction.js"></script>
	<script language="JavaScript" src="../../eOR/js/ChartVertical.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	

	String mode = (String )request.getParameter("mode");
	String facility_id = (String )session.getAttribute("facility_id");
	String bean_id = "Or_ChartVertical";
	String bean_name = "eOR.ChartVerticalBean";
	String wholeString = "";
	ChartVerticalBean bean = (ChartVerticalBean)getBeanObject( bean_id,  bean_name, request ) ;

	String sql_or_chart_result_type_discr_msr = OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_RESULT_TYPE_DISCR_MSR");
	//int		totalRecords	=	0;
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="FocusFirstElement()">
<form name="frmChartVertical" id="frmChartVertical">

		<%
			String classVal = "";
			int noOfRecords = 0;
			Vector objResultType = new Vector();
		if(mode.equalsIgnoreCase("1"))
		{
			noOfRecords = 10;
			objResultType = bean.getResultType();
			%>
		<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
		
		<tr>
			<td class="label" width='45%'><fmt:message key="eOR.resultmatrix.label" bundle="${or_labels}"/></td>
			<td class="fields">
				<select name="result_type" id="result_type" onchange="resetLower()">
					<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<%
					for(int i=0;i<objResultType.size();i+=2)
					{
					%>
				<option value="<%= objResultType.get(i) %>"> <%= objResultType.get(i+1) %></option>
						
					<%
					}
					%>

				</select><img src="../../eCommon/images/mandatory.gif" align=center>
			</td>
		</tr>
		
		</table>
		<table class='grid' width="100%">
			<tr>
				<th class='columnheader' ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th class='columnheader' ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
				<th class='columnheader' ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.DiscreteMeasure.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="eOR.CopyPrev.label" bundle="${or_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/> </th>
			</tr>
			<%
			for(int i=0;i<noOfRecords;i++)
			{
				if(i%2 == 0)
					classVal = "gridData";
				else
					classVal = "gridData";
				if(i ==0)
				{
		%>

			<tr>
				<td class='<%= classVal %>'><input type=text name="code<%= i %>" id="code<%= i %>" size=2 maxlength=4 onKeyPress="return CheckForSpecChars(event)" onBlur="CheckForSpecCharsWithoutSpaceBlur(this);resetColorCode(this);">
				<img src="../../eCommon/images/mandatory.gif" align=center>
				</td>
				<td class='<%= classVal %>'><input type=text name="long_desc<%= i %>" id="long_desc<%= i %>" size=12 maxlength=40 onBlur="makeValidString(this);resetColorCode(this);">
				<img src="../../eCommon/images/mandatory.gif" align=center>
				</td>
				<td class='<%= classVal %>'><input type=text name="short_desc<%= i %>" id="short_desc<%= i %>" size=7 maxlength=15 onBlur="makeValidString(this);resetColorCode(this);">
				<img src="../../eCommon/images/mandatory.gif" align=center>
				</td>
				<td class='<%= classVal %>'><input type=text name="seq_no<%= i %>" id="seq_no<%= i %>" size=4 maxlength=4 onblur="CheckForNumbers(this);resetColorCode(this);">
				<img src="../../eCommon/images/mandatory.gif" align=center>
				</td>
				<td class='<%= classVal %>'><input type=text name="discr_msr_desc<%= i %>" id="discr_msr_desc<%= i %>"
				size=10 maxlength=15 onblur="searchForDiscreteMeasure(this)"><input type=button class=button value="?" name="discr_msr_button<%= i %>" id="discr_msr_button<%= i %>" onclick="searchForDiscreteMeasure1(discr_msr_desc<%= i %>)">
				
				</td>
				<input type=hidden name="discr_msr_id<%= i %>" id="discr_msr_id<%= i %>" value="">
				<td class='<%= classVal %>'><input type=checkbox name="copy_prev<%= i %>" id="copy_prev<%= i %>" value="N" onclick="checkCopyPrev(this)"></td>
				<td class='<%= classVal %>'><input type=checkbox name="eff_status<%= i %>" id="eff_status<%= i %>" checked value="E" onclick="checkActive(this)"></td>
			</tr>
		<%
				}
				else
				{
			%>
			<tr>
				<td class='<%= classVal %>'><input type=text name="code<%= i %>" id="code<%= i %>" size=2 maxlength=4 onKeyPress="return CheckForSpecChars(event)" onBlur="resetColorCode(this);">
				</td>
				<td class='<%= classVal %>'><input type=text name="long_desc<%= i %>" id="long_desc<%= i %>" size=12 maxlength=40 onBlur="makeValidString(this);resetColorCode(this);">
				</td>
				<td class='<%= classVal %>'><input type=text name="short_desc<%= i %>" id="short_desc<%= i %>" size=7 maxlength=15 onBlur="makeValidString(this);resetColorCode(this);">
				</td>
				<td class='<%= classVal %>'><input type=text name="seq_no<%= i %>" id="seq_no<%= i %>" size=4 maxlength=4 onblur="CheckForNumbers(this);resetColorCode(this);">
				</td>
				<td class='<%= classVal %>'><input type=text name="discr_msr_desc<%= i %>" id="discr_msr_desc<%= i %>"
				size=10 maxlength=15 onblur="searchForDiscreteMeasure(this)"><input type=button class=button value="?" name="discr_msr_button<%= i %>" id="discr_msr_button<%= i %>" onclick="searchForDiscreteMeasure1(discr_msr_desc<%= i %>)">
				</td>
				<input type=hidden name="discr_msr_id<%= i %>" id="discr_msr_id<%= i %>" value="">
				<td class='<%= classVal %>'><input type=checkbox name="copy_prev<%= i %>" id="copy_prev<%= i %>" value="N" onclick="checkCopyPrev(this)"></td>
				<td class='<%= classVal %>'><input type=checkbox name="eff_status<%= i %>" id="eff_status<%= i %>" checked value="E" onclick="checkActive(this)"></td>
			</tr>
			<%
				}
			}
			%>

				</table>
			<%
		}
		else
		{
			//out.println("<script>alert('111111111');</script>");
			noOfRecords = 1;
			classVal = "gridData";
			String chkCP = "";
			String chart_res = "";
			String disableCP = "disabled";
			String discr_msr_id = ((request.getParameter("discr_msr_id")==null) ? "":request.getParameter("discr_msr_id").trim());
			
			String copy_prev = ((request.getParameter("prev")==null) ? "":request.getParameter("prev"));
			
			if(copy_prev.equalsIgnoreCase("Y"))
				chkCP = "checked";
			else
				chkCP = "";
			
			String temp = ((request.getParameter("temp")==null) ? "":request.getParameter("temp"));
			
			
			//String copy_prev_vert_yn = ((request.getParameter("copy_prev_vert_yn")==null) ? "":request.getParameter("copy_prev_vert_yn"));
			
			String chart_result_type = ((request.getParameter("chart_result_type")==null) ? "":request.getParameter("chart_result_type"));
			
			
			String chart_vertical_code = ((request.getParameter("chart_vertical_code")==null)? "":request.getParameter("chart_vertical_code").trim());
			
			mode = ((request.getParameter("mode")==null) ? "":request.getParameter("mode"));
			
			String long_desc = ((request.getParameter("long_description")==null)? "":request.getParameter("long_description"));
			
			String short_desc = ((request.getParameter("short_description")==null)? "":request.getParameter("short_description"));
		
			String seq_no =	((request.getParameter("seq_no")==null)? "":request.getParameter("seq_no"));
		
		
			String eff_statusVal[] = bean.getEffStatus(temp.trim(),chart_vertical_code.trim());

			//if (eff_statusVal != null)
			//	out.println("<script>alert('"+temp.trim()+","+chart_vertical_code+","+eff_statusVal[0]+"')</script>");
			if (eff_statusVal != null && eff_statusVal.length > 1)
				chart_res = eff_statusVal[1];
			String check = "";

			wholeString = mode.trim() + "$" + chart_result_type + "$" + chart_vertical_code + "$" + long_desc + "$" + short_desc + "$" + seq_no + "$" + discr_msr_id + "$" + copy_prev + "$" + temp.trim();
			
			
			if(eff_statusVal[0].trim().equalsIgnoreCase("E"))
			{
				check = "checked";
		%>
		<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
		<tr>
			<td  class="label"  width='40%'><fmt:message key="Common.ResultType.label" bundle="${common_labels}"/> </td>
			<td  class="fields" ><input type=text name="result_type" id="result_type" size=20 maxlength=20
				value="<%= chart_result_type %>" readonly>
				<img src="../../eCommon/images/mandatory.gif" align=center>
				</td>
		</tr>
		<tr>
			<td  class="label" width='40%'><fmt:message key="eOR.MatrixRowCode.label" bundle="${or_labels}"/> </td>
			<td  class="fields" ><input type=text name="code" id="code" size=4 maxlength=4
				value="<%= chart_vertical_code %>" readonly>
				<img src="../../eCommon/images/mandatory.gif" align=center>
				</td>
		</tr>
		<tr>
				<td class="label" width='40%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<td class="fields" ><input type=text name="long_desc" id="long_desc" size=35 maxlength=40 value="<%= long_desc %>" onBlur="makeValidString(this)">
				<img src="../../eCommon/images/mandatory.gif" align=center>
				</td>
		</tr>
		<tr>
				<td class="label"  width='40%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/> </td>
				<td class="fields"><input type=text name="short_desc" id="short_desc" size=15 maxlength=15 value="<%= short_desc %>" onBlur="makeValidString(this)">
				<img src="../../eCommon/images/mandatory.gif" align=center>
				</td>
		</tr>
		<tr>
				<td class="label"  width='40%'><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td>
				<td class="fields" ><input type=text name="seq_no" id="seq_no" size=4 maxlength=4 value="<%= seq_no %>" readonly>
				<img src="../../eCommon/images/mandatory.gif" align=center>
				</td>
		</tr>
		<tr>
				<td class="label" width='40%'><fmt:message key="Common.DiscreteMeasure.label" bundle="${common_labels}"/></td>
				<td class="fields" ><input type=text name="discr_msr_desc" id="discr_msr_desc" size=25 maxlength=25 value="<%= discr_msr_id %>" readonly>

				</td>
		</tr>
		<tr>
				<td class="label" width='40%'><fmt:message key="eOR.CopyPrevious.label" bundle="${or_labels}"/> </td>
				<td class="fields" ><input type=checkbox name="copy_prev" id="copy_prev"
				value="<%= copy_prev  %>" <%= chkCP %>  readonly <%= disableCP %>></td>
			</td>
		</tr>
		<tr>
				<td class="label" width='40%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td class="fields" ><input type=checkbox name="eff_status" id="eff_status" <%=check%> value="<%= eff_statusVal[0] %>" onclick="checkActive(this)"></td>
			</td>
		</tr>
			<input type=hidden name="chart_result_type" id="chart_result_type" value="<%= chart_res %>">

				</table>
		<%
			}
			else
			{
				check = "";
				mode = request.getParameter("mode");
				%>
			<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
			<tr>
			<td  class="label" width='40%'><fmt:message key="Common.ResultType.label" bundle="${common_labels}"/> </td>
			<td  class="fields" ><input type=text name="result_type" id="result_type" size=15 maxlength=15
				value="<%= chart_result_type %>" readonly>
				<img src="../../eCommon/images/mandatory.gif" align=center>
				</td>
			</tr>
			<tr>
			<td class="label" width='40%'><fmt:message key="eOR.MatrixRowCode.label" bundle="${or_labels}"/> </td>
			<td class="fields" ><input type=text name="code" id="code" size=4 maxlength=4
				value="<%= chart_vertical_code %>" readonly>
				<img src="../../eCommon/images/mandatory.gif" align=center>
			</td>
		</tr>
		<tr>
				<td class="label"  width='40%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/> </td>
				<td class="fields" ><input type=text name="long_desc" id="long_desc" size=35 maxlength=40 value="<%= long_desc %>" readonly>
				<img src="../../eCommon/images/mandatory.gif" align=center>
				</td>
		</tr>
		<tr>
				<td class="label" width='40%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/> </td>
				<td class="fields" ><input type=text name="short_desc" id="short_desc" size=15 maxlength=15 value="<%= short_desc %>" readonly>
				<img src="../../eCommon/images/mandatory.gif" align=center>
				</td>
		</tr>
		<tr>
				<td class="label"  width='40%'><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/> </td>
				<td class="fields" ><input type=text name="seq_no" id="seq_no" size=4 maxlength=4 value="<%= seq_no %>" readonly>
				<img src="../../eCommon/images/mandatory.gif" align=center>
				</td>
		</tr>
		<tr>
				<td class="label" width='40%'><fmt:message key="Common.DiscreteMeasure.label" bundle="${common_labels}"/></td>
				<td class="fields" ><input type=text name="discr_msr_desc" id="discr_msr_desc" size=25 maxlength=25 value="<%= discr_msr_id %>" readonly>
				
				</td>
		</tr>
		<tr>
				<td class="label"  width='40%'><fmt:message key="eOR.CopyPrevious.label" bundle="${or_labels}"/> </td>
				<td class="fields" ><input type=checkbox name="copy_prev" id="copy_prev"
				value="<%= copy_prev  %>" <%= chkCP %> readonly  <%= disableCP %> ></td>
			</td>
		</tr>
	<tr>
				<td class="label"  width='40%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td class="fields"  ><input type=checkbox name="eff_status" id="eff_status" <%=check%> value="<%= eff_statusVal[0] %>" onclick="checkActive(this)"></td>
			</td>
		</tr>
			<input type=hidden name="chart_result_type" id="chart_result_type" value="<%= chart_res %>">
				</table>
		<%
			}
		%>

		<%
		}
		%>

	<input type="hidden" name="SQL_OR_CHART_RESULT_TYPE_DISCR_MSR" id="SQL_OR_CHART_RESULT_TYPE_DISCR_MSR"
	value="<%=sql_or_chart_result_type_discr_msr%>" >
	<input type='hidden' name='noOfRecords' id='noOfRecords' value="<%= noOfRecords %>">
	<INPUT TYPE="hidden" name="totalRecords" id="totalRecords" value="<%=noOfRecords%>">
	<input type='hidden' name='facility_id' id='facility_id' value="<%= facility_id %>">
	<input type='hidden' name='mode' id='mode' value="<%= mode %>">
	<input type='hidden' name='bean_id' id='bean_id' value="<%= bean_id %>">
	<input type='hidden' name='bean_name' id='bean_name' value="<%= bean_name %>">
	<input type='hidden' name='wholeString' id='wholeString' value="<%= wholeString %>">
</form>

</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

