<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<%
	String params	= request.getQueryString() ;
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name, request ) ;
	String or_mode = bean.getOrMode();	
%>
	
<%
		if(or_mode.equals("")){
%>
			<iframe name="f_drug_list" id="f_drug_list" SCROLLING="auto" NORESIZE SRC="IVAmendDrugList.jsp?<%= params %>" CLASS="IVWORKAREA" style="height:100vh;width:45vw"></iframe>
<%
		}
		else{
%>
			<iframe name="f_drug_list" id="f_drug_list" SCROLLING="auto" NORESIZE SRC="IVAmendDrugListAmend.jsp?<%= params %>" CLASS="IVWORKAREA" style="height:100vh;width:55vw"></iframe>
<%
		}
%>
		
			<iframe name="f_sub_ivdrugs" id="f_sub_ivdrugs" FRAMEBORDER="0" SCROLLING="no"  NORESIZE SRC="IVAmendDrugDetails.jsp?<%= params %>" style="height:96vh;width:100vw"></iframe>
			<iframe name="f_drug_button" id="f_drug_button" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="IVAmendDrugDetailButtons.jsp?<%= params %>" style="height:4vh;width:100vw"></iframe>
		</FRAMESET>
	</FRAMESET>
</HTML>

<%
putObjectInBean(bean_id,bean,request);
%>

