<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/09/2019      IN070451		   B Haribabu   06/09/2019     Manickam                 ML-MMOH-CRF-1408
11/08/2020      IN072753           Prabha		11/08/2020     Manickam					NMC-JD-CRF-0046
--------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<!-- <%@include file="../../eCommon/jsp/Common.jsp" %> -->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<%	
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String params			= request.getQueryString() ;
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String patient_class	= request.getParameter("act_patient_class");
	String weight= request.getParameter("weight");//Added for IN:070451
	String bsa= request.getParameter("bsa");//Added for IN:070451
	String order_type_flag = request.getParameter("order_type_flag")==null?"":request.getParameter("order_type_flag");
	String prev_order = request.getParameter("prev_order")==null?"":request.getParameter("prev_order");
	String start_date_time = "";
	String iv_prep_yn			= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
	String location_type		= request.getParameter("location_type")==null?"":request.getParameter("location_type");
	String location_code		= request.getParameter("location_code")==null?"":request.getParameter("location_code");
	String take_home_medication = request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
	String priority				= request.getParameter("priority")==null?"":request.getParameter("priority");
	
	iv_prep_yn = iv_prep_yn.trim();
	
	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id,bean_name,request) ;
	bean.clear();	

	bean.setOrder_type_flag(order_type_flag);
	bean.setPatientClass(patient_class);
	//Added For NMC-JD-CRF-0046
  if(!order_type_flag.equals("Existing")){
 	ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id); // Added empty parameter for Bru-HIMS-CRF-347 [IN:037862] -- Begin ,added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]
	if(ord_disp_location != null & ord_disp_location.size()>0){ 
		bean.setDisplocn((String)ord_disp_location.get(0));  
		bean.setDisp_locn_code((String)ord_disp_location.get(0)); 
	} 
	} 
//Added For NMC-JD-CRF-0046
	if(prev_order.equals("previous"))
		bean.setIS_COPY_ORDER(true);
	else
		bean.setIS_COPY_ORDER(false);
	
	if(order_type_flag.equals("Existing")){
		String order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String answer = request.getParameter("answer")==null?"":request.getParameter("answer"); 
		ArrayList exstngIVorder = new ArrayList();
		HashMap record = null; 
		StringBuffer drugCodes = new StringBuffer();
		String act_pat_class = request.getParameter("act_pat_class")== null?"": request.getParameter("act_pat_class");  //RUT-CRF-0062 Added to get the Build MAR Rule
		exstngIVorder = (ArrayList)bean.getExistingIVRecords(order_id,answer,act_pat_class); //passed answer for IN24251 --16/12/2010-- priya  // RUT-CRF-0062
		for(int i=1;i<exstngIVorder.size();i++){
			record = new HashMap();
			record = (HashMap)exstngIVorder.get(i);
			drugCodes.append(record.get("ORDER_CATALOG_CODE"));
			drugCodes.append(",");
			start_date_time = (String)record.get("START_DATE_TIME");
		}

		bean.setPatId(patient_id);
		bean.setSTART_DATE_TIME(start_date_time);
		bean.setWeight(weight);//Added for IN:070451
		bean.setBSA(bsa);//Added for IN:070451
		bean.setDrugDetails(drugCodes.toString(),"","","","","","");  //CRF-0062 
		bean.setAllExistingIVOrders(exstngIVorder);
	}

	String search_bean_id		= "@DrugSearchBean"+patient_id+encounter_id;
	String search_bean_name		= "ePH.DrugSearchBean";
	DrugSearchBean searchbean	= (DrugSearchBean)getBeanObject(search_bean_id,search_bean_name,request);	
	searchbean.clear();	
	putObjectInBean(search_bean_id,searchbean,request);
%>
	<!-- <FRAMESET ROWS="50,23,27" FRAMESPACING="0"> -->		
<%		
		if(!order_type_flag.equals("Existing")){
%>
			<IFRAME name="f_iv_drug_details" id="f_iv_drug_details" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="IVPrescriptionDrugDetailFrames.jsp?<%= params %>" style='height:46vh;width:98vw'></IFRAME>
<%
		}
		else{
%>
			<IFRAME name="f_iv_drug_details" id="f_iv_drug_details" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style='height:46vh;width:98vw'></IFRAME>
<%
		}
%>
		<IFRAME name="f_iv_fluid" id="f_iv_fluid" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="IVPrescriptionFluidDetail.jsp?<%= params %>" style='height:17vh;width:99vw'></IFRAME>
		<IFRAME name="f_iv_admin" id="f_iv_admin" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="IVPrescriptionAdminDetail.jsp?<%= params %>" style='height:24vh;width:99vw'></IFRAME>
	<!-- </FRAMESET> -->
<% 
	putObjectInBean(bean_id,bean,request); 
%>
</HTML>

