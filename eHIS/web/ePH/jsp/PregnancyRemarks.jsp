<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	
</HEAD>
<title><fmt:message key="ePH.PregnancyRemarks.label" bundle="${ph_labels}"/></title>

<body>

<%
	String bean_id = "PregnancyCategory" ;
	String bean_name = "ePH.PregnancyCategoryBean";
	String LMPText = "";
	String gestationAgeText = "";
	String EDDText = "";
	String asOnDate = "";

	//PregnancyCategoryBean bean = (PregnancyCategoryBean)getBeanObject( bean_id, bean_name, request ) ;
    //bean.clear() ;
	//ArrayList pregnancyRemarksList = bean.getPregnancyRemarks();
	//if (pregnancyRemarksList.size() > 0)
	//{
	//LMPText = pregnancyRemarksList.get(0).toString();
	//gestationAgeText = pregnancyRemarksList.get(1).toString();
	//EDDText = pregnancyRemarksList.get(2).toString();
	//}
	LMPText = request.getParameter("lmp");
	gestationAgeText = request.getParameter("gestation");
	EDDText = request.getParameter("edd");
	asOnDate = request.getParameter("asOnDate");

%>
	<form name="PregnancyRemarksForm" id="PregnancyRemarksForm" id="Pregnancyremarks" >
		<table cellpadding="0" cellspacing="0"  border=0>
		
			 <tr ><td colspan="2" >&nbsp;</td></tr>
			<tr >
			<td colspan="2" class="data" >&nbsp;<fmt:message key="ePH.LastRecordedOn.label" bundle="${ph_labels}"/> <%=asOnDate%></td>
            </tr>
			 <tr ><td colspan="2" >&nbsp;</td></tr>
			<tr>
			<td  class="label"><fmt:message key="ePH.LMP.label" bundle="${ph_labels}"/></td>
			<td class="data" ><%=LMPText%></td>
            </tr>
			<tr ><td colspan="2" >&nbsp;</td></tr>
			<tr>
			<td  class="label"><fmt:message key="ePH.GestationAge.label" bundle="${ph_labels}"/></td>
			<td  class="data" >
			<%
			 
			if(!gestationAgeText.equals("")){%>
			<%=gestationAgeText%>&nbsp;
			<%
			  if (!gestationAgeText.contains("Days")){
			%>
				<fmt:message key="Common.days.label" bundle="${common_labels}"/>	
			<%}
			 }
			%>
			
			</td>
            </tr>
			<tr ><td colspan="2" >&nbsp;</td></tr>
			<tr>
			<td  class="label"><fmt:message key="Common.EDD.label" bundle="${common_labels}"/> </td>
			<td class="data" ><%=EDDText%>
				
			</td>
            </tr>

        </table>
	</form>
</body>
</html>

