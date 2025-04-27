<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
29/04/2024     58928	     Krishna pranay	         30/04/204         Ramesh Goli       	ML-MMOH-CRF-1759.2
01/10/2024     68508     krishna pranay             13/10/2024  Ashwini Ragupathi  ML-MMOH-CRF-1759							

--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language='javascript' src='../../eCA/js/CAMenstrualHistDtlTrans.js'> </script>		

</head>
<form name='MenstrualHistDtlDetailsForm' id='MenstrualHistDtlDetailsForm'>
<%
		 
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String option_id = request.getParameter("option_id") == null ? "" : request.getParameter("option_id");
	String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
	String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	String episode_id = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");

	String firstFrameSrc  = "";
	String secondFrameSrc = "";
	String thirdFrameSrc="";
	
	firstFrameSrc  = "../../eCA/jsp/CAMenstrualHistDtlResult.jsp?";
	secondFrameSrc  = "../../eCA/jsp/CAMenstrualHistDtlTop.jsp?";
	thirdFrameSrc  = "../../eCA/jsp/CAMenstrualHistDtlBottom.jsp?";

	if("MENST_HIST_DTL".equals(option_id)  || "MENST_HIST_DTL1".equals(option_id))
	{
	%>
		<iframe name='plineFrame' id='plineFrame' src='../../eCommon/jsp/pline.jsp?Patient_ID=<%=patient_id%>' scrolling='no' frameborder="no" frameborder='0' style='height:10%;width:100vw'></iframe>
 	<iframe name="MenstrualHistDtlResultFrame" id="MenstrualHistDtlResultFrame" frameborder="no" scrolling="auto"  src="<%=firstFrameSrc%><%=request.getQueryString()%>" frameborder='0' style="height:30%;width:100vw"></iframe>
 	 <iframe name="MenstrualHistDtlTopFrame" id="MenstrualHistDtlTopFrame" frameborder="no" scrolling="auto"  src="<%=secondFrameSrc%><%=request.getQueryString()%>" frameborder='0' style="height:15%;width:100vw"></iframe>
 	 <iframe name="MenstrualHistDtlBottomFrame" id="MenstrualHistDtlBottomFrame" frameborder="no" scrolling="auto"  src="<%=thirdFrameSrc%><%=request.getQueryString()%>" frameborder='0' style="height:60%;width:100vw"></iframe> 	
	<%
	}
	%>

</form>
</html>

