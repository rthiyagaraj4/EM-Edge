<!DOCTYPE html>
<!--
File Name		: PlaceMealOrderEMResult.jsp
File Description: First frame of Result Page: This is to search all the A&E patients
CRF#			: Bru-HIMS-CRF-412
-->
<%@ page import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.sql.Timestamp,java.text.DateFormat,java.text.SimpleDateFormat,eCommon.Common.*"%><!--Modified Against ML-MMOH-CRF-0600 ToolTip-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<head>

<%
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ?
		(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
				if(sStyle==null)sStyle="IeStyle.css";
		//String facility_Id	= (String)session.getAttribute("facility_id");
		String language_Id  = (String)session.getAttribute("LOCALE");
 %>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eDS/js/json.js"></script>
	<script language="Javascript" src="../../eDS/js/DSCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script><!--Added Against ML-MMOH-CRF-0600 ToolTip-->
<form name='QueryResult' id='QueryResult'>
<input type="hidden" name="locationCode" id="locationCode" value="">
<input type="hidden" name="locationType" id="locationType" value="">
<input type="hidden" name="locale" id="locale" value="<%=language_Id %>"/>
<input type="hidden" name="hdnSpeciality" id="hdnSpeciality" value=""/>

<input type="hidden" name="from" id="from" value="<%=request.getParameter("from")%>">
<input type="hidden" name="to" id="to" value="<%=request.getParameter( "to" )%>">

<table align='right'>
<tr nowrap>
<%
String from = request.getParameter("from");
String to = request.getParameter( "to" );

int start = (from.equals(""))?0:Integer.parseInt(from);
int end = (to.equals(""))?13:Integer.parseInt(to);
if ( !(start <= 0) ) {%>
<td>

<A HREF="javascript:traversePage(<%=(start-13)%>,<%=(end-13)%>);" text-decoration='none'><fmt:message key="Common.previous.label" bundle='${common_labels}' /></A>
</td>
<%}%>
<td id="hrefNextMealOrder">
<A HREF="javascript:traversePage(<%=(start+13)%>,<%=(end+13)%>);" text-decoration='none'><fmt:message key="Common.next.label" bundle='${common_labels}' /></A>
</td>
</tr>
</table>
<br><br>
<table border="1" cellpadding="1" cellspacing="0" width="100%"  align="center" id="result" >
	<tr>
		<th>
			<fmt:message key="Common.patientId.label" bundle="${common_labels}" />
		</th>
		<th>
			<fmt:message key="Common.encounterid.label" bundle="${common_labels}" />
		</th>
		<th>
			<fmt:message key="Common.PatientName.label" bundle="${common_labels}" />
		</th>
		<th>
			<fmt:message key="eDS.VisitDateTime.label" bundle="${ds_labels}" />
		</th>
		<th>
			<fmt:message key="Common.status.label" bundle="${common_labels}" />
		</th> 
		<th>
			<input type="checkbox" name="chkAll" id="chkAll" onclick="checkAll(this)"/>
		</th>
	</tr>
	<tbody id="divOrderList_EM">
	</tbody>
	<input type=hidden name="hdnplaceorder" id="hdnplaceorder" value="">
	<input type=hidden name="totchkRowsInCurrPage" id="totchkRowsInCurrPage" value="">
</table>
	
<script language="Javascript" src="../../eDS/js/PlaceMealOrderEMResult.js"></script>
 </form>
</body>

