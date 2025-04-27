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
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>
	TD.OABRUHEALTH{
		BACKGROUND-COLOR:Bisque;  
		FONT-SIZE: 8pt ;
		border-style: SOLID;
		border-left-color: #B2B6D7;
		border-right-color: #B2B6D7;
		border-top-color: #E2E3F0;
		border-bottom-color: #E2E3F0;
	}
</style>

</head>

<%
request.setCharacterEncoding("UTF-8");	

	Connection con = null;

	//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
	 Boolean isSlotStartMidEndAppl = false;

try
{
	con = ConnectionManager.getConnection(request);

	isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
%>

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

<!-- <td width="10%" class='oalabel' nowrap><fmt:message key="Common.available.label" bundle="${common_labels}"/></td>-->

<td width="3%"  class='OAFULL'>&nbsp;</td>
<td width="14%" class='oalabel' nowrap><fmt:message key="Common.FullyBooked.label" bundle="${common_labels}"/></td>

<td width="3%"  class='OARED'>&nbsp;</td>
<td width="10%"  class='oalabel' nowrap><fmt:message key="Common.blocked.label" bundle="${common_labels}"/></td>

<td width="3%"  class='OAYELLOW'>&nbsp;</td>
<td width="" class='oalabel' nowrap><fmt:message key="eOA.OverbookingsAvailable.label" bundle="${oa_labels}"/></td>
<td width="3%"  class='OAHOLIDAY'>&nbsp;</td>
<td width="10%" class='oalabel' nowrap><fmt:message key="Common.Holiday.label" bundle="${common_labels}"/></td>

<td width="3%" class='OABLOCK'>&nbsp;</td>
<td width="10%" class='oalabel' nowrap><fmt:message key="eOA.Break.label" bundle="${oa_labels}"/></td>

<td width="3%" class='OAFORCED'>&nbsp;</td>
<td width="10%" class='oalabel' nowrap><fmt:message key="eOA.ForcedBooking.label" bundle="${oa_labels}"/></td>

<td width="3%" class='oalabel'>&nbsp;</td>
<td width=""  class='oalabel' nowrap><fmt:message key="eOA.NoSchedule.label" bundle="${oa_labels}"/></td>

<%if(isSlotStartMidEndAppl){%>
	<td width="3%"  class='OABRUHEALTH'>&nbsp;</td>
	<td width="10%" class='oalabel' nowrap><fmt:message key="eOA.BruHealthSlot.label" bundle="${oa_labels}"/></td>
<%}%>

<td class='button' ><input type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='parent.window.close()'></td> 
</td>

</tr>
</table>
</body>

<%
}catch(Exception e){
	e.printStackTrace();
}finally{
	ConnectionManager.returnConnection(con,request);
}
%>

</html>

