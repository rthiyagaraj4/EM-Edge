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
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper,webbeans.eCommon.*,eCA.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='javascript' src='../../eCA/js/CAMenstrualHistDtlTrans.js'> </script>	
      
</head>

<%

String facility_id="";
facility_id=(String) session.getValue("facility_id");
String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
String option_id = request.getParameter("option_id")==null?"":request.getParameter("option_id");
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String called_form = request.getParameter("called_form")==null?"":request.getParameter("called_form");

if("MENST_HIST_DTL".equals(option_id) || "MENST_HIST_DTL1".equals(option_id))
{  
%>
<frameset rows='5%,97%'>
<frame name='MenstrualHistDtlQueryFrame' id='MenstrualHistDtlQueryFrame' src='../../eCA/jsp/CAMenstrualHistDtlQuery.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize>
<frame name='MenstrualHistDtlResultFrame' id='MenstrualHistDtlResultFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no'>
<frame name='MenstrualHistDtlTopFrame' id='MenstrualHistDtlTopFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no'>
<frame name='MenstrualHistDtlBottomFrame' id='MenstrualHistDtlBottomFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no'>

</frameset>
<% 
}
else
{
%>
<frameset>
<frame name="MenstrualHistDtlPatient" id="MenstrualHistDtlPatient" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/CAMenstrualHistDtlPatient.jsp?<%=request.getQueryString()%>&called_form=<%=called_form%>"></frame>
</frameset>
<%
}

%>
<form>
<input type='hidden' name='option_id' id='option_id' value='<%=option_id%>'>

</form>
</html>

