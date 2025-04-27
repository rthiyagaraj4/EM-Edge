<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
 Connection con							= null;
 
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8");
try{
con = ConnectionManager.getConnection(request);

/* Below line added by mano against CRF-0737 */
		boolean mlcAndInfectiousDeceBodyApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con, "MO","CHANGE_MLC_AND_INFEC_DECS_BODY");
/* End of CRF-0737 */
String decesregn=request.getParameter("decesregn")==null?"":request.getParameter("decesregn");
%>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onKeyDown = 'lockKey()'>

<table border='1' width='99%'>

<%
if(decesregn.equals("burialpermit"))
{%>

<tr>
<td width="5%" align='left' style="background-color:BLACK;color:white">&nbsp;&nbsp;</td>
<td width="25%" align='left' class='oalabel' nowrap>
&nbsp;<fmt:message key="Common.broughtdead.label" bundle="${common_labels}"/></td>
<%if(mlcAndInfectiousDeceBodyApplicable){%>
<td width="5%" align='left' style="background-color:orange">&nbsp;</td>
<td width="25%" align='left' class='oalabel' nowrap>
&nbsp;<fmt:message key="Common.InfectiousDeceasedBody.label" bundle="${common_labels}"/> <!--this label change against ML-MMOH-CRF-0737 by Mano -->
<%}else{%>
<td width="5%" align='left' style="background-color:orange">&nbsp;</td>
<td width="25%" align='left' class='oalabel' nowrap>
&nbsp;<fmt:message key="Common.highriskbody.label" bundle="${common_labels}"/>
<%}%>
</tr>
<%}else 
if(decesregn.equals("decesregn"))
{%>

<tr>

<td width="5%" align='left' style="background-color:yellow;color:maroon">&nbsp;&nbsp;P</td>
<td width="25%" align='left' class='oalabel' nowrap>
&nbsp;<fmt:message key="eMO.ClinicalPostmortem.label" bundle="${mo_labels}"/>
</td>
<%if(mlcAndInfectiousDeceBodyApplicable){%>
<td width="5%" align='left' style="background-color:maroon;color:white">&nbsp;&nbsp;P</td>
<td width="25%" align='left' class='oalabel' nowrap>
&nbsp;<fmt:message key="Common.MedicoLegalCase.label" bundle="${common_labels}"/></td> <!--this label change against ML-MMOH-CRF-0737 by Mano -->
<%}else{%>
<td width="5%" align='left' style="background-color:maroon;color:white">&nbsp;&nbsp;P</td>
<td width="25%" align='left' class='oalabel' nowrap>
&nbsp;<fmt:message key="eMO.MedicoLegal.label" bundle="${mo_labels}"/></td><!--Bundle change for PAS-MO-PMG2020-TECH-CRF-0010/03-Label Name-->
<%}%>
<td width="5%" align='left' style="background-color:BLACK;color:white">&nbsp;&nbsp;</td>
<td width="25%" align='left' class='oalabel' nowrap>
&nbsp;<fmt:message key="Common.broughtdead.label" bundle="${common_labels}"/></td>
<%if(mlcAndInfectiousDeceBodyApplicable){%>
<td width="5%" align='left' style="background-color:orange">&nbsp;</td>
<td width="25%" align='left' class='oalabel' nowrap>
&nbsp;<fmt:message key="Common.InfectiousDeceasedBody.label" bundle="${common_labels}"/></td> <!--this label change against ML-MMOH-CRF-0737 by Mano -->
<%}else{%>
<td width="5%" align='left' style="background-color:orange">&nbsp;</td>
<td width="25%" align='left' class='oalabel' nowrap>
&nbsp;<fmt:message key="Common.highriskbody.label" bundle="${common_labels}"/></td>
<%}%>
</tr>

<%}else{%>

<tr>

<td width="5%" align='left' style="background-color:yellow;color:maroon">&nbsp;&nbsp;P</td>
<td width="25%" align='left' class='oalabel' nowrap>
&nbsp;<fmt:message key="eMO.ClinicalPostmortem.label" bundle="${mo_labels}"/>
</td>
<%if(mlcAndInfectiousDeceBodyApplicable){%>
<td width="5%" align='left' style="background-color:maroon;color:white">&nbsp;&nbsp;P</td>
<td width="25%" align='left' class='oalabel'nowrap>
&nbsp;<fmt:message key="Common.MedicoLegalCase.label" bundle="${common_labels}"/> <!--this label change against ML-MMOH-CRF-0737 by Mano -->
</td>
<%}else{%>
<td width="5%" align='left' style="background-color:maroon;color:white">&nbsp;&nbsp;P</td>
<td width="25%" align='left' class='oalabel'nowrap>
&nbsp;<fmt:message key="eMO.MedicoLegal.label" bundle="${mo_labels}"/><!--Bundle change for PAS-MO-PMG2020-TECH-CRF-0010/03-Label Name--> 
</td>
<%}%>

<td width="5%" align='left' style="background-color:BLACK;color:white">&nbsp;&nbsp;</td>
<td width="25%" align='left' class='oalabel' nowrap>
&nbsp;<fmt:message key="Common.broughtdead.label" bundle="${common_labels}"/></td>
<%if(mlcAndInfectiousDeceBodyApplicable){%>
<td width="5%" align='left' style="background-color:orange">&nbsp;</td>
<td width="25%" align='left' class='oalabel'nowrap>
&nbsp;<fmt:message key="Common.InfectiousDeceasedBody.label" bundle="${common_labels}"/> <!--this label change against ML-MMOH-CRF-0737 by Mano -->
</td>
<%}else{%>
<td width="5%" align='left' style="background-color:orange">&nbsp;</td>
<td width="25%" align='left' class='oalabel'nowrap>
&nbsp;<fmt:message key="Common.highriskbody.label" bundle="${common_labels}"/> 
</td>
<%}%>
</tr>
<%}%>

<%
}
catch(Exception e1)
{
	e1.printStackTrace();
}
finally
{
	if(con!=null)ConnectionManager.returnConnection(con);
}
%>

</table>
</body>

</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

