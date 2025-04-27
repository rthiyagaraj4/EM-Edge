<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
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
<td  class=label  align =right width=10%>Speciality:</td>
<td align=left class=label>&nbsp;&nbsp;&nbsp;<B><fmt:message key="eMR.InternalMedicine.label" bundle="${mr_labels}"/></B></td>
</tr>
<tr>
<td  class=label  align =right width=10%>&nbsp;</td>
<td align=left >&nbsp;</td>
</tr>
<tr>
<td  class=label  align =right  width=10%>Period:</td>
<td align=left  class=label>&nbsp;&nbsp;&nbsp;<B>December  2004</B></td>
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
<th colspan=7>&nbsp;</th>
<th colspan=5>(Figures in MM:SS Format)</th>
<th colspan=1>&nbsp; </th>
<tr >
<tr>
<th colspan=7> <fmt:message key="Common.Period.label" bundle="${common_labels}"/></th>
<th colspan=3>Hospital Kepala Batas  </th>
<th colspan=3>Hospital Lahad Datu  </th>
<tr >
<th colspan=7>&nbsp;</th>
<th ><fmt:message key="eMR.RegnStartCons.label" bundle="${mr_labels}"/></th>
<th><fmt:message key="eMR.StartConsCheckout.label" bundle="${mr_labels}"/></th>
<th><fmt:message key="eMR.CheckoutEndVisit.label" bundle="${mr_labels}"/> </th>
<th ><fmt:message key="eMR.RegnStartCons.label" bundle="${mr_labels}"/></th>
<th><fmt:message key="eMR.StartConsCheckout.label" bundle="${mr_labels}"/></th>
<th><fmt:message key="eMR.CheckoutEndVisit.label" bundle="${mr_labels}"/> </th>
</tr>

<tr >
<td colspan=7 class=QRYODD>1st Week</td>
<td align=center  class=QRYODD>00:46</td>
<td align=center class=QRYODD>00:24</td>
<td align=center class=QRYODD>00:00</td>
<td align=center class=QRYODD>00:63</td>
<td align=center class=QRYODD>00:11</td>
<td align=center class=QRYODD>79:15 </td>
</tr>
<tr >
<td colspan=7 nowrap class=QRYEVEN >2nd Week</td>
<td align=center class=QRYEVEN>00:51</td>
<td align=center class=QRYEVEN>00:68</td>
<td align=center class=QRYEVEN>00:00</td>
<td align=center class=QRYEVEN>00:96</td>
<td align=center class=QRYEVEN>00:06</td>
<td align=center class=QRYEVEN>22:19 </td>
</tr>
<tr >
<td colspan=7 class=QRYODD>3rd Week</td>
<td align=center class=QRYODD>00:93</td>
<td align=center  class=QRYODD>01:03</td>
<td align=center class=QRYODD>00:00</td>
<td align=center class=QRYODD>03:15</td>
<td align=center class=QRYODD>00:09</td>
<td align=center class=QRYODD>00:95 </td>
</tr>
<tr >
<td colspan=7 class=QRYEVEN>4th Week</td>
<td align=center  class=QRYEVEN>00:66</td>
<td align=center class=QRYEVEN>00:36</td>
<td align=center class=QRYEVEN>00:00</td>
<td align=center class=QRYEVEN>00:40</td>
<td align=center class=QRYEVEN>00:03</td>
<td align=center class=QRYEVEN>15:97 </td>
</tr>
<tr >
<td colspan=7 class=QRYODD>5th Week</td>
<td align=center class=QRYODD >00:07</td>
<td align=center class=QRYODD>00:16</td>
<td align=center class=QRYODD>00:00</td>
<td align=center class=QRYODD>00:61</td>
<td align=center class=QRYODD>00:04</td>
<td align=center class=QRYODD>00:42 </td>
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

