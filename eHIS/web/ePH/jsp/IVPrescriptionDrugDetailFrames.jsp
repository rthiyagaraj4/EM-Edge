<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</HEAD>

<%
	//String url		= "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");

	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name , request) ;

	String or_mode = bean.getOrMode();	
%>

	 <div style="display:flex;">
	<%
		if(or_mode.equals("")){

	%>
	<iframe name="f_drug_list" id="f_drug_list" SCROLLING="auto" NORESIZE SRC="IVPrescriptionDrugList.jsp?<%= params %>" CLASS="IVWORKAREA" style="height:95vh;width:48vw"></iframe>
	<%
		}else{
	%>
	<iframe name="f_drug_list" id="f_drug_list" SCROLLING="auto" NORESIZE SRC="IVPrescriptionDrugListAmend.jsp?<%= params %>" CLASS="IVWORKAREA" style="height:95vh;width:48vw"></iframe>
	<%
		}
	%>
	 <div >
		<iframe name="f_sub_ivdrugs" id="f_sub_ivdrugs" FRAMEBORDER="0" SCROLLING="no"  NORESIZE SRC="IVPrescriptionDrugDetails.jsp?<%= params %>" style="height:76vh;width:50vw"></iframe>
		<iframe name="f_drug_button" id="f_drug_button" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="IVPrescriptionDrugDetailButtons.jsp?<%= params %>" style="height:16vh;width:45vw"></iframe>
</div>
	 </div> 

</HTML>
<%
putObjectInBean(bean_id,bean,request);
%>

