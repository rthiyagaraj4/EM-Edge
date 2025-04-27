<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	    ?				?			created
30/07/2018	IN061886		Ramesh G				    					To be able to plot Growth Charts for Pre Term babies and abnormal babies.
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title>SplChartKeyIntervalDtl</title>
		<script src='../../eCA/js/SplChartKey.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	</head>
</br><%
	String mode = "";
	mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	if(mode.equals("")){
		mode = "modify";
	}
	String xAxis_element= request.getParameter("xAxis_element")==null?"*K":request.getParameter("xAxis_element");
%>

<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name='SplChartKeyIntervalDtlForm' id='SplChartKeyIntervalDtlForm' method='post'>
<table width='98%' border='0' cellspacing=0 cellpadding=3 align=center>
		
		<tr>
				<td  class='label' ><fmt:message key="Common.Start.label" bundle="${common_labels}"/> <fmt:message key="Common.Value.label" bundle="${common_labels}"/></td><td><input type="text" name="start_value" id="start_value" size=10 maxlength=11 onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this);"  ><img src='../../eCommon/images/mandatory.gif'>
				</td>

				<td class='label' ><fmt:message key="Common.End.label" bundle="${common_labels}"/> <fmt:message key="Common.Value.label" bundle="${common_labels}"/></td><td><input type="text" name="end_value" id="end_value" size=10 maxlength=11 onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this);" ><img src='../../eCommon/images/mandatory.gif'>
				</td>
		</tr>
		<tr>
				<td  class='label' ><fmt:message key="eCA.Interval.label" bundle="${ca_labels}"/></td><td>
				<input type="text" name="interval" id="interval" size=10 maxlength=11 onkeypress="return allowPositiveNumber()" onBlur="checkPositiveNumber(this);" ><img src='../../eCommon/images/mandatory.gif'>
				</td>
				
				<td  class='label' ><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></td><td>
				<SELECT name="unit" id="unit">
					<%if("*K".equals(xAxis_element)){%>
					<option value = 'D' ><fmt:message key="Common.days.label" bundle="${common_labels}"/></option> 
					<option value = 'M' SELECTED ><fmt:message key="Common.months.label" bundle="${common_labels}"/></option> 
					<option value = 'Y' ><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option> 
					<option value = 'W' ><fmt:message key="Common.weeks.label" bundle="${common_labels}"/></option>   <!-- IN061886 -->
					<%}else if("WT".equals(xAxis_element)){%>
					<option value = 'KG' ><fmt:message key="Common.Kgs.label" bundle="${common_labels}"/></option>
					<%}else if("BM".equals(xAxis_element)){%>
					<option value = 'KM' ><fmt:message key="eCA.kgm2.label" bundle="${ca_labels}"/></option>
					<%}else if("LN".equals(xAxis_element)||"HC".equals(xAxis_element)||"CC".equals(xAxis_element)){%>
					<option value = 'CM' ><fmt:message key="eCA.centimeters.label" bundle="${ca_labels}"/></option>
					<%}%>
				</SELECT>
				</td>
			</tr>
			
			<tr>
				<td colspan = '3' class='label' ></td><td align='right' ><input type='button' class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Generate.label","common_labels")%>" onClick="processGenerate();"/><input type='button' class='button'	value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" 
				onClick="processClear();"/></td>
			</tr>
		</table>
		<input type='hidden' name='mode' id='mode' value='<%=mode%>'></input>
	</form>
</body>
</html>

