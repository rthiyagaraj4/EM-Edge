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


<BR><BR>&nbsp;&nbsp;&nbsp;&nbsp;
<table border="0" align='center' width="95%" cellspacing='0' cellpadding='0'>
<tr><th  align=left  color=black colspan=2 nowrap ><B><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></B></th>

<tr>
<td  class=label  align =right width=10%>Disease:</td>
<td align=left  class=label>&nbsp;&nbsp;&nbsp;<B><fmt:message key="eMR.DengueFever.label" bundle="${mr_labels}"/></B></td>
</tr>
<tr>
<td  class=label  align =right width=10%>&nbsp;</td>
<td align=left >&nbsp;</td>
</tr>
<tr>
<td  class=label  align =right width=10%>Period:</td>
<td align=left  class=label>&nbsp;&nbsp;&nbsp;<B>Apr' 2004  - Dec' 2004 </B></td>
</tr>
<tr>
<td  class=label  align =right width=10%>&nbsp;</td>
<td align=left >&nbsp;</td>
</tr>
</tr>
</table>
<BR><BR><BR>
<table border="1" align='center' width="95%" cellspacing='0' cellpadding='0'>
<tr>
<th colspan> <fmt:message key="Common.Period.label" bundle="${common_labels}"/></th>
<th colspan>Hospital Kepala Batas</th>
<th colspan>Hospital Lahad Datu</th>
<tr >
<th colspan>&nbsp;</th>
<th ><fmt:message key="eMR.TotalNo.OfPatients.label" bundle="${mr_labels}"/></th>
<th><fmt:message key="eMR.TotalNo.OfPatients.label" bundle="${mr_labels}"/></th>
</tr>
<td class=QRYODD>Apr'04</td>
<td align=center class=QRYODD>2</td>
<td align=center class=QRYODD>0</td>
</tr>
</tr>
<td  class=QRYEVEN>May'04</td>
<td align=center class=QRYEVEN >0</td>
<td align=center class=QRYEVEN>1</td>
</tr>
</tr>
<td  class=QRYODD>Jun'04</td>
<td align=center class=QRYODD>1</td>
<td align=center class=QRYODD>0</td>
</tr>
</tr>
<td class=QRYEVEN >Jul'04</td>
<td align=center class=QRYEVEN >0</td>
<td align=center class=QRYEVEN>3</td>
</tr>
</tr>
<td class=QRYODD>Aug'04</td>
<td align=center class=QRYODD>3</td>
<td align=center class=QRYODD>5</td>
</tr>
<tr>
<td class=QRYEVEN >Sep'04</td>
<td align=center class=QRYEVEN>0</td>
<td align=center class=QRYEVEN>4</td>
</tr>
<tr>
<td class=QRYODD >Oct'04</td>
<td align=center class=QRYODD>0</td>
<td align=center class=QRYODD>5</td>
</tr>
<tr>
<td class=QRYEVEN>Nov'04</td>
<td align=center  class=QRYEVEN>3</td>
<td align=center  class=QRYEVEN>4</td>
</tr>
<tr>
<td class=QRYODD>Dec'04 </td>
<td align=center class=QRYODD>1</td>
<td align=center class=QRYODD>0</td>
</tr>
<tr>
<td class=QRYEVEN></td>
<td class=QRYEVEN></td>
<td class=QRYEVEN></td>
</tr>
<tr>
<td class=QRYODD><B>  &nbsp;&nbsp;<fmt:message key="Common.GrandTotal.label" bundle="${common_labels}"/></B></td>
<td align=center class=QRYODD><B>10</B></td>
<td align=center class=QRYODD><B>22</B></td>
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

