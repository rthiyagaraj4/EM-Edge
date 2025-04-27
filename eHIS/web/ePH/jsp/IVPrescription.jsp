<!DOCTYPE html>
 <%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
06/01/2021		 TFS-7345          Prabha      06/01/2020	  Manickavasagam J         MMS-DM-CRF-0177
--------------------------------------------------------------------------------------------------------------
*/
%> 

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>

<%
	String params			= request.getQueryString() ;

	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	//String clearOrNot		= request.getParameter("clearOrNot") == null ? "N":request.getParameter("clearOrNot");

	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name , request) ;
	//if (clearOrNot.equals("Y"))
	bean.clear();	

	String search_bean_id		= "@DrugSearchBean"+patient_id+encounter_id;
	String search_bean_name		= "ePH.DrugSearchBean";
	DrugSearchBean searchbean	= (DrugSearchBean)getBeanObject(search_bean_id, search_bean_name, request);

	String presBean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 presBean		= (PrescriptionBean_1)getBeanObject(presBean_id, presBean_name, request );
	bean.setPrintMarLabel(presBean.getPrintMarLabel());//Added for MMS-QH-CRF-0080 [IN:038064]
	bean.setPrintMarBarcode(presBean.getPrintMarBarcode()); //Added for MMS-QH-CRF-0080 [IN:038064]
	bean.setIVCalcInfuseBy(presBean.getIVCalcInfuseBy()); //Added for MMS-QH-CRF-0080 [IN:038064]
	bean.setParamVolumeCalc(presBean.getParamVolumeCalc()); //Added for AAKH-CRF-0094
	
	bean.setPreAllocAppl(); //Added for MMS-DM-CRF-0177
			
	searchbean.clear();
	String or_mode = request.getParameter("or_mode");
	if(or_mode==null)or_mode="";
	bean.setOrMode(or_mode);

	if(or_mode.equals("amend")){
%>
 <iframe name="f_ivselect" id="f_ivselect" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="IVAmendOptions.jsp?<%= params %>" style="height:5vh;width:100vw"></iframe>
 <iframe name="f_ivdetails" id="f_ivdetails" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="IVAmendDetailsFrame.jsp?<%= params %>" style="height:82vh;width:97vw"></iframe>
 <iframe name="f_ivbutton" id="f_ivbutton" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="IVAmendButtons.jsp?<%= params %>" style="height:9vh;width:97vw"></iframe>
<%
	}else{

%>
	 <iframe name="f_ivselect" id="f_ivselect" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="IVPrescriptionOptions.jsp?<%= params %>" style="height:5vh;width:100vw"></iframe>
	 <iframe name="f_ivdetails" id="f_ivdetails" FRAMEBORDER="0" SCROLLING="yes"  SRC="IVPrescriptionDetailsFrame.jsp?<%= params %>" style="height:82vh;width:97vw"></iframe>
	 <iframe name="f_ivbutton" id="f_ivbutton" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="IVPrescriptionButtons.jsp?<%= params %>&iv_prep_yn=1" style="height:9vh;width:97vw"></iframe>
<%
	}	
%>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
putObjectInBean(search_bean_id,searchbean,request);
%>

