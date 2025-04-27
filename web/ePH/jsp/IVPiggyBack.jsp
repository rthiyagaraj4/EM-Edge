<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
</head>
<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
	String params	= request.getQueryString() ;
	String patient_id	= request.getParameter("patient_id");
	String patient_class= request.getParameter("act_patient_class");
	String order_type_flag	= request.getParameter("order_type_flag");

     if(order_type_flag==null)order_type_flag="";
	String mode= request.getParameter("mode");
	 if(mode==null)mode="";
	String encounter_id = request.getParameter("encounter_id");
	String prev_order = request.getParameter("prev_order")==null?"":request.getParameter("prev_order");
	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name, request ) ;
	if(mode == null || mode.equals("") || mode.equals("blank") ){
		bean.clear();
	}
	bean.setPatientClass(patient_class);
	if(prev_order.equals("previous"))
		bean.setIS_COPY_ORDER(true);
	else
		bean.setIS_COPY_ORDER(false);
	if(mode.equals("amend")&& mode!=null)
      bean.setOrder_type_flag(mode);
	else if(order_type_flag.equals("Existing")){ 
		mode=order_type_flag;
		bean.setOrder_type_flag(mode);
	}
	bean.setIVType("IVPB");
%>
<iframe name="f_iv_pb_drug" id="f_iv_pb_drug" frameborder ="0" scrolling="no"  noresize src="IVPiggyBackDrugDetails.jsp?<%= params %>" style="height:47vh;width:100vw"></iframe><iframe name="f_iv_pb_approval" id="f_iv_pb_approval" frameborder ="0" scrolling="no"  noresize
	src="../../ePH/jsp/IVPiggyBackApproval.jsp?<%= params %>" style="height:6vh;width:100vw"></iframe><iframe name="f_iv_pb_drug_legend" id="f_iv_pb_drug_legend" frameborder ="0" scrolling="no"  noresize  src="IVPiggyBackLegends.jsp?<%= params %>" style="height:9vh;width:100vw"></iframe><iframe name="f_iv_pb" id="f_iv_pb"      frameborder ="0" scrolling="no"  noresize src="../../eCommon/html/blank.html" style="height:18%;width:100vw"></iframe><iframe name="f_iv_pb_admin_dtls" id="f_iv_pb_admin_dtls" frameborder="0" scrolling="no" noresize src="IVPiggyBackAdminDtls.jsp?<%= params %>" style="height:28vh;width:100vw"></iframe>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

