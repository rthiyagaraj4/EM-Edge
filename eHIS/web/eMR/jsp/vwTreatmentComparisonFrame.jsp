<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>

<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown='lockKey()'>
<BR><BR><BR><BR>
<table border="0" align='center' width="95%" cellspacing='0' cellpadding='0'>
<tr><th  align=left  color=black colspan=2 nowrap ><B><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></B></th>

<tr>
<td  class=label  align =right width=10%>Diagnosis:</td>
<td align=left class=label>&nbsp;&nbsp;&nbsp;<B><fmt:message key="eMR.Asthma.label" bundle="${mr_labels}"/></B></td>
</tr>
<tr>
<td  class=label  align =right width=10%>&nbsp;</td>
<td align=left class=label>&nbsp;</td>
</tr>
<tr>
<td  class=label  align =right  width=10%>Period:</td>
<td align=left class=label>&nbsp;&nbsp;&nbsp;<B>December 2004</B></td>
</tr>
<tr>
<td  class=label  align =right width=10%>&nbsp;</td>
<td align=left class=label>&nbsp;</td>
</tr>
</tr>
</table>
<BR><BR><BR>

<table border="1" align='center' width="95%" cellspacing='0' cellpadding='0'>
<tr>
<th > <fmt:message key="Common.details.label" bundle="${common_labels}"/></th>
<th >Hospital Kepala Batas  </th>
<th >Hospital Lahad Datu</th>

</tr>
<tr>
<td  align class=QRYODD>Average length of  Stay(Days)</td>
<td align=center class=QRYODD>0.23</td>
<td align=center class=QRYODD>0.03</td>
</tr>
<tr>
<td class=QRYEVEN><fmt:message key="eMR.CostofStay.label" bundle="${mr_labels}"/></td>
<td align=center class=QRYEVEN>9.00</td>
<td align=center class=QRYEVEN	>23.00</td>
</tr>

<tr>
<td class=QRYODD><fmt:message key="eMR.CostofInvestigationsandTreatments.label" bundle="${mr_labels}"/></td>
<td align=center class=QRYODD>19.00</td>
<td align=center class=QRYODD>-</td>
</tr>
<tr>
<td class=QRYEVEN ><fmt:message key="eMR.AverageNumberofDrugs.label" bundle="${mr_labels}"/></td>
<td align=center class=QRYEVEN>4</td>
<td align=center class=QRYEVEN>4</td>
</tr>


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

