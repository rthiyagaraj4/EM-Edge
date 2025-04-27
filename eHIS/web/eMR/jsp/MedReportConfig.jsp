<!DOCTYPE html>
<!--Created by Ashwini on 12-Oct-2017 for ML-MMOH-CRF-0720-->
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>

<title><fmt:message key="eMR.MedicalReport.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.Configuration.label" bundle="${common_labels}"/></title>

		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eMR/js/MRParam.js' language='javascript'></script> 
</head>

<body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onKeyDown = 'lockKey()'>
<%
String mr_hdr_line1		= ""; 
String mr_hdr_line2		= ""; 
String mr_hdr_line3		= ""; 
String mr_hdr_line4		= ""; 
String mr_hdr_line5		= ""; 
String mr_hdr_line6		= "";
String mr_hdr_line7		= "";//Added By Dharma on 27/11/2019 against  ML-MMOH-CRF-1360
String mr_sign_line1	= ""; 
String mr_sign_line2	= ""; 
String mr_sign_line3	= ""; 
String mr_sign_line4	= ""; 
String mr_sign_line5	= ""; 
String mr_sign_line6	= ""; 
String mr_sign_line7	= ""; 
String mr_sign_line8	= ""; //Added by Ashwini on 16-Oct-2018 for ML-MMOH-CRF-1282
String mr_sign_line9 	= "";
Connection conn		= null;

try{
	mr_hdr_line1		= checkForNull(request.getParameter("mr_hdr_line1"));
	mr_hdr_line2		= checkForNull(request.getParameter("mr_hdr_line2"));
	mr_hdr_line3		= checkForNull(request.getParameter("mr_hdr_line3"));
	mr_hdr_line4		= checkForNull(request.getParameter("mr_hdr_line4"));
	mr_hdr_line5		= checkForNull(request.getParameter("mr_hdr_line5"));
	mr_hdr_line6		= checkForNull(request.getParameter("mr_hdr_line6"));
	mr_hdr_line7		= checkForNull(request.getParameter("mr_hdr_line7"));
	mr_sign_line1		= checkForNull(request.getParameter("mr_sign_line1"));
	mr_sign_line2		= checkForNull(request.getParameter("mr_sign_line2"));
	mr_sign_line3		= checkForNull(request.getParameter("mr_sign_line3"));
	mr_sign_line4		= checkForNull(request.getParameter("mr_sign_line4"));
	mr_sign_line5		= checkForNull(request.getParameter("mr_sign_line5"));
	mr_sign_line6		= checkForNull(request.getParameter("mr_sign_line6"));
	mr_sign_line7		= checkForNull(request.getParameter("mr_sign_line7"));
	mr_sign_line8		= checkForNull(request.getParameter("mr_sign_line8")); //Added by Ashwini on 16-Oct-2018 for ML-MMOH-CRF-1282
	mr_sign_line9		= checkForNull(request.getParameter("mr_sign_line9"));
%>

<form name='MedReportConfigForm' id='MedReportConfigForm' method='post' target='messageFrame'>

	<table  border='0' cellpadding='3' cellspacing='0' width='100%'> 
			<!-- Line 7 and field alignments Added/Modified By Dharma on 27/11/2019 against  ML-MMOH-CRF-1360-->
			<tr>
				<td colspan='4' class="COLUMNHEADER"><fmt:message key="eMR.HeaderForMedReport.label" bundle="${mr_labels}"/></td>
			</tr>
			<tr>
				<td class='label' width='20%' > <fmt:message key="Common.Line.label" bundle="${common_labels}"/> 1</td>
				<td class='fields' width='20%'> <input type='text' name="mr_hdr_line1" id="mr_hdr_line1" size="30" maxlength="40" onpaste="return false;" onkeypress="return MedRepConfigSpclCharChck(event);" value="<%=mr_hdr_line1%>"></td>
				<td class='label' width='20%' > <fmt:message key="Common.Line.label" bundle="${common_labels}"/> 5</td>
				<td class='fields' width='20%'> <input type='text' name="mr_hdr_line5" id="mr_hdr_line5" size="30" maxlength="40" onpaste="return false;" onkeypress="return MedRepConfigSpclCharChck(event);" value="<%=mr_hdr_line5%>"></td>
			</tr>
			<tr>
				<td class='label' width='20%' > <fmt:message key="Common.Line.label" bundle="${common_labels}"/> 2</td>
				<td class='fields' width='20%'><textarea name="mr_hdr_line2" rows='3' cols='25' maxlength="100" onpaste="return false;" onkeypress="return MedRepConfigSpclCharChck(event);" onkeyup='return imposeMaxLength(this);'><%=mr_hdr_line2%></textarea></td>
				<td class='label' width='20%' > <fmt:message key="Common.Line.label" bundle="${common_labels}"/> 6</td>
				<td class='fields' width='20%'> <input type='text' name="mr_hdr_line6" id="mr_hdr_line6" size="30" maxlength="40" onpaste="return false;" onkeypress="return MedRepConfigSpclCharChck(event);" value="<%=mr_hdr_line6%>"></td>
			</tr>
			<tr>
				<td class='label' width='20%' > <fmt:message key="Common.Line.label" bundle="${common_labels}"/> 3</td>
				<td class='fields' width='20%'> <input type='text' name="mr_hdr_line3" id="mr_hdr_line3" size="30" maxlength="40" onpaste="return false;" onkeypress="return MedRepConfigSpclCharChck(event);" value="<%=mr_hdr_line3%>"></td>
				<td class='label' width='20%' > <fmt:message key="Common.Line.label" bundle="${common_labels}"/> 7</td>
				<td class='fields' width='20%'> <input type='text' name="mr_hdr_line7" id="mr_hdr_line7" size="30" maxlength="20" onpaste="return false;" onkeypress="return MedRepConfigSpclCharChck(event);" value="<%=mr_hdr_line7%>"></td>
			</tr>
			<tr>
				<td class='label' width='20%' > <fmt:message key="Common.Line.label" bundle="${common_labels}"/> 4</td>
				<td class='fields' width='20%'> <input type='text' name="mr_hdr_line4" id="mr_hdr_line4" size="30" maxlength="40" onpaste="return false;" onkeypress="return MedRepConfigSpclCharChck(event);" value="<%=mr_hdr_line4%>"></td>
				<td colspan="2">&nbsp;</td>
			</tr>
			
			<tr>
				<td colspan='4' class="COLUMNHEADER"><fmt:message key="eMR.SignForMedReport.label" bundle="${mr_labels}"/></td>
			</tr>
			<tr>
				<td class='label' width='20%' > <fmt:message key="Common.Line.label" bundle="${common_labels}"/> 1</td>
				<td class='fields' width='20%'> <input type='text' name="mr_sign_line1" id="mr_sign_line1" size="30" maxlength="40" onpaste="return false;" onkeypress="return MedRepConfigSpclCharChck(event);" value="<%=mr_sign_line1%>"></td>
				<td class='label' width='20%' > <fmt:message key="Common.Line.label" bundle="${common_labels}"/> 5</td>
				<td class='fields' width='20%'> <input type='text' name="mr_sign_line5" id="mr_sign_line5" size="30" maxlength="40" onpaste="return false;" onkeypress="return MedRepConfigSpclCharChck(event);" value="<%=mr_sign_line5%>"></td>
			</tr>
			<tr>
				<td class='label' width='20%' > <fmt:message key="Common.Line.label" bundle="${common_labels}"/> 2</td>
				<td class='fields' width='20%'> <input type='text' name="mr_sign_line2" id="mr_sign_line2" size="30" maxlength="40" onpaste="return false;" onkeypress="return MedRepConfigSpclCharChck(event);" value="<%=mr_sign_line2%>"></td>
				<td class='label' width='20%' > <fmt:message key="Common.Line.label" bundle="${common_labels}"/> 6</td>
				<td class='fields' width='20%'> <input type='text' name="mr_sign_line6" id="mr_sign_line6" size="30" maxlength="40" onpaste="return false;" onkeypress="return MedRepConfigSpclCharChck(event);" value="<%=mr_sign_line6%>"></td>
			</tr>
			<tr>
				<td class='label' width='20%' > <fmt:message key="Common.Line.label" bundle="${common_labels}"/> 3</td>
				<td class='fields' width='20%'> <input type='text' name="mr_sign_line3" id="mr_sign_line3" size="30" maxlength="40" onpaste="return false;" onkeypress="return MedRepConfigSpclCharChck(event);" value="<%=mr_sign_line3%>"></td>
				<td class='label' width='20%' ><fmt:message key="Common.Line.label" bundle="${common_labels}"/> 7</td>
				<td class='fields' width='20%'> <input type='text' name="mr_sign_line7" id="mr_sign_line7" size="30" maxlength="100" onpaste="return false;" onkeypress="return MedRepConfigSpclCharChck(event);" value="<%=mr_sign_line7%>"></td> <!--maxlength increased by mujafar for ML-MMOH-CRF-1219 -->
			</tr>
			<tr>
				<td class='label' width='20%' > <fmt:message key="Common.Line.label" bundle="${common_labels}"/> 4</td>
				<td class='fields' width='20%'> <input type='text' name="mr_sign_line4" id="mr_sign_line4" size="30" maxlength="40" onpaste="return false;" onkeypress="return MedRepConfigSpclCharChck(event);" value="<%=mr_sign_line4%>"></td>
				<!--Added by Ashwini on 16-Oct-2018 for ML-MMOH-CRF-1282-->
				<td class='label' width='20%' > <fmt:message key="Common.Line.label" bundle="${common_labels}"/> 8</td>
				<td class='fields' width='20%'> <input type='text' name="mr_sign_line8" id="mr_sign_line8" size="30" maxlength="100" onpaste="return false;" onkeypress="return MedRepConfigSpclCharChck(event);" value="<%=mr_sign_line8%>"></td>
			</tr>
			<!-- Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365 Start -->
			<tr>
				<td class='label' width='20%' > <fmt:message key="Common.Line.label" bundle="${common_labels}"/> 9</td>
				<td class='fields' width='20%'><textarea name="mr_sign_line9" rows='3' cols='25' maxlength="70" onpaste="return false;" onkeypress="return MedRepConfigSpclCharChck(event);" onkeyup='return imposeMaxLength(this);'><%=mr_sign_line9%></textarea></td>
				<td class='label' width='20%' >&nbsp;</td>
				<td class='fields' width='20%'>&nbsp;</td> 
			</tr>
			<tr><td>&nbsp</td></tr>
			<!-- Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365 End -->
			<tr>
				<td colspan='2' class='button'><input type=button value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='BUTTON' onclick='closeMedRepConfig()'></td>
			</tr>
		</table>

		</form>
	</body>
</html>
<%
	}catch(Exception e){
		e.printStackTrace();
	}
	 finally{
			ConnectionManager.returnConnection(conn,request);
		}
%>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

