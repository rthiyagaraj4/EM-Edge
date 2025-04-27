<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@page  import ="eCommon.Common.CommonBean,java.util.ArrayList,eOT.*,eOT.Common.*"%>

<%-- Mandatory declarations start --%>

<%@include file="../../eCommon/jsp/Common.jsp" %>

<%-- Mandatory declarations end --%>

<%
	String bean_id = "CheckInBean";
	String bean_name = "eOT.CheckInBean";
	CheckInBean chk_bean = (CheckInBean)mh.getBeanObject( bean_id, request, bean_name );
	String patient_id =CommonBean.checkForNull(request.getParameter("patient_id")); 
	String result_string = "";
	String encounterId = "";
	String wardCode =  "";
	String source_type = "";
	String source_code = "";
	//String surgeon_code = "";
	String admitting_speciality_code="";

	ArrayList pat_ward_list = chk_bean.getPatientWardDtls(patient_id);
	if(pat_ward_list.size()>0){
	   encounterId = CommonBean.checkForNull((String)pat_ward_list.get(0));
	   admitting_speciality_code = CommonBean.checkForNull(chk_bean.getSpecialtyCode(patient_id,encounterId));
	   wardCode =   CommonBean.checkForNull((String)pat_ward_list.get(1));
	   //surgeon_code =CommonBean.checkForNull((String)pat_ward_list.get(3));
	   source_type = "W";
	   //source_type = CommonBean.checkForNull((String)pat_ward_list.get(4));
	   source_code = wardCode;
	}

	String admitting_speciality_desc = CommonBean.checkForNull(chk_bean.getSpecialityDesc(admitting_speciality_code));
   //ward Desc
//   String surgery_date = chk_bean.getSysDate();
   String wardDesc = CommonBean.checkForNull(chk_bean.getWardDesc(wardCode));
  //Operation Status Code
   String operationStatus=chk_bean.getStatus();

   result_string = wardDesc+"::"+admitting_speciality_desc+"::"+source_type+"::"+source_code+"::"+operationStatus;
   out.println(result_string);
   

   %>
