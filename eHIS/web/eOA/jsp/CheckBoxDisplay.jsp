<!DOCTYPE html>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,java.util.*" %>

<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
  <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<table border='1' width='100%'>
<tr>
<!-- Modified against JD-CRF-0177 -->
<td width="2%"  class='OALIGHTGREEN'>&nbsp;</td>
<td width="8%"  class='oalabel' nowrap><fmt:message key="Common.OnlyFirstVisitAvailable.label" bundle="${common_labels}"/>
</td>

<td width="2%"  class='OADARKGREEN'>&nbsp;</td>
<td width="8%"  class='oalabel'nowrap><fmt:message key="Common.OnlyOtherVisitAvailable.label" bundle="${common_labels}"/>
</td>

<td width="2%"  class='OAGREEN'>&nbsp;</td>
<td width="8%"  class='oalabel'nowrap><fmt:message key="Common.FirstandOtherVisitAvailable.label" bundle="${common_labels}"/>
</td>

<td width="2%"  class='OAFULL'>&nbsp;</td>
<td width="8%"  class='oalabel'><fmt:message key="Common.FullyBooked.label" bundle="${common_labels}"/>
</td>

<td width="2%"  class='OARED'>&nbsp;</td>
<td width="8%"  class='oalabel'><fmt:message key="Common.blocked.label" bundle="${common_labels}"/>
</td>

<td width="2%"  class='OAYELLOW'>&nbsp;</td>
<td width="12%" class='oalabel' nowrap><fmt:message key="eOA.OverbookingsAvailable.label" bundle="${oa_labels}"/>
</td>

<td width="2%"  class='OAFORCED'>&nbsp;</td>
<td width="12%"  class='oalabel'><fmt:message key="eOA.ForcedbookingsAvailable.label" bundle="${oa_labels}"/>
</td> 

<td width="2%"  class='OAHOLIDAY'>&nbsp;</td>
<td width="8%"  class='oalabel'><fmt:message key="Common.Holiday.label" bundle="${common_labels}"/>
</td> 

<td width="2%" class='oalabel'>&nbsp;</td>
<td width="8%"  class='oalabel'><fmt:message key="eOA.NoSchedule.label" bundle="${oa_labels}"/>
</td>

</tr>
</table>
</body>

</html>

