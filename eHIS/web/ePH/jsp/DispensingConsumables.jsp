<!DOCTYPE html>
  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<title><fmt:message key="ePH.MedicalItems.label" bundle="${ph_labels}"/></title>
	</head>
<%
	String params			        = request.getQueryString() ;
	String disp_stage		        = request.getParameter("disp_stage");
	String disp_locn_code           = request.getParameter("disp_locn_code");
	String bl_patient_class         = request.getParameter("bl_patient_class");
	String locale                   = (String) session.getAttribute("LOCALE");
	String bean_id					= "@ConsumableOrderBean";
	String bean_name				= "ePH.ConsumableOrderBean";
	ConsumableOrderBean bean		= (ConsumableOrderBean)getBeanObject( bean_id, bean_name, request );
   
    bean.setLanguageId(locale);
	params = params +"&bean_id="+bean_id+"&bean_name="+bean_name;
	String orderIDS_trxRefIDS= request.getParameter("orderIDS_trxRefIDS");
	StringBuffer trx_ref_ids = new StringBuffer();
	StringBuffer order_ids   = new StringBuffer();

	StringTokenizer data        = new StringTokenizer(orderIDS_trxRefIDS,"::");
	while(data.hasMoreTokens()){
	   if(data.hasMoreTokens()){
			order_ids.append("'").append(data.nextToken()).append("'");		
		}
		if(data.hasMoreTokens()){
			trx_ref_ids.append("'").append(data.nextToken()).append("'");
		}
		if(data.hasMoreTokens()){
			trx_ref_ids.append(",");
			order_ids.append(",");
		}
	}

    String	disp_bean_id			   =	"DispMedicationAllStages" ;
	String	disp_bean_name			   =	"ePH.DispMedicationAllStages";
	DispMedicationAllStages disp_bean  = (DispMedicationAllStages)getBeanObject( disp_bean_id, disp_bean_name, request);
    ArrayList  tot_cons_item_dtl  = (ArrayList)disp_bean.getConsumableDetails();
    String bean_id1 = "DispMedicationBean" ;
	String bean_name1 = "ePH.DispMedicationBean";
	DispMedicationBean bean_1 = (DispMedicationBean)getBeanObject( bean_id1, bean_name1, request ) ;

    if(!bl_patient_class.equals("I")&&!bl_patient_class.equals("D")){
		if((bean_1.getDispStage().equals("F") && (bean_1.getFillingStatus().equals("A")  ))|| (bean_1.getDispStage().equals("A") && (bean_1.getFillingStatus().equals("B")  )) || disp_stage.equals("D")){
			if(tot_cons_item_dtl.size()==0){
				disp_bean.getDispensedConsumableOrderDetails( order_ids.toString(),disp_locn_code);//this method is used set dispensing det for dispensed consumables
			}
		}
		/*else{
			if(tot_cons_item_dtl.size()==0){
				// disp_bean.getConsumableOrderDetails( trx_ref_ids.toString(),disp_stage);//this method is used set dispensing det for ordered consumables
			}
		}*/
	}
	else{
		if(bean_1.getDispStage().equals("F")){
			if(tot_cons_item_dtl.size()==0){
				disp_bean.getDispensedConsumableOrderDetails( order_ids.toString(),disp_locn_code);
				// disp_bean.getConsumableOrderDetails( trx_ref_ids.toString(),disp_stage);//this method is used set dispensing det for ordered consumables
			}
		}
		else{
			if(tot_cons_item_dtl.size()==0){
				disp_bean.getDispensedConsumableOrderDetails( order_ids.toString(),disp_locn_code);//this method is used set dispensing det for dispensed consumables
			}
		}
	}
	tot_cons_item_dtl  = (ArrayList)disp_bean.getConsumableDetails();
 %>
	<iframe name="Disp_cons_items_criteria" id="Disp_cons_items_criteria" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/DispensingConsumablesItemsCriteria.jsp?<%= params %>" style="height:10vh;width:100vw"></iframe>
	<iframe name="Disp_cons_item_result" id="Disp_cons_item_result" FRAMEBORDER="0" SCROLLING="yes" NORESIZE SRC="../../ePH/jsp/DispensingConsumablesItemsDetails.jsp?<%= params %>" style="height:80vh;width:100vw"></iframe>
	<iframe name="Disp_cons_item_buttons" id="Disp_cons_item_buttons" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/DispensingConsumablesButtons.jsp?<%= params %>" style="height:5vh;width:100vw"></iframe>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(disp_bean_id,disp_bean,request);
%>
</HTML>

