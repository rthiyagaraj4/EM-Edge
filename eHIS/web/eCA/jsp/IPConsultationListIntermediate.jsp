
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%

String operation_mode = request.getParameter("operation_mode")==null?"":request.getParameter("operation_mode");


String bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");



if(operation_mode.equals("create"))
{

	eCA.IPConsultationListBean ipConsultListBean = null;

		ipConsultListBean = (eCA.IPConsultationListBean)getObjectFromBean("ipConsultListBean"+bean_key,"eCA.IPConsultationListBean",session);
	
	String pline = request.getParameter("pline")==null?"":request.getParameter("pline");
	String Admission_date_time = request.getParameter("Admission_date_time")==null?"":request.getParameter("Admission_date_time");
	String Specialty_code = request.getParameter("Specialty_code")==null?"":request.getParameter("Specialty_code");
	String Location_code = request.getParameter("Location_code")==null?"":request.getParameter("Location_code");
	
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String attend_practitioner_id = request.getParameter("attend_practitioner_id")==null?"":request.getParameter("attend_practitioner_id");
	String create_type = request.getParameter("create_type")==null?"":request.getParameter("create_type");

	String arrVal ="";

	




	if(create_type.equals("S"))
	{
		arrVal = attend_practitioner_id+"~"+Location_code+"~"+pline+"~"+Admission_date_time+"~"+Specialty_code+"~"+patient_id+"~"+encounter_id;
	}
	else
	{
		arrVal = Location_code+"~"+Location_code+"~"+pline+"~"+Admission_date_time+"~"+Specialty_code+"~"+patient_id+"~"+encounter_id;
	}

	if(mode.equals("Add"))

	{
		//if(!ipConsultListBean.returnConsList().contains(arrVal))
		//{
			ipConsultListBean.addtoConsList(arrVal);
		//}


	}
	else if (mode.equals("Rem"))
	{
		if(ipConsultListBean.returnConsList().contains(arrVal))
		{
			ipConsultListBean.remFromConsList(arrVal);
		}

	}
	
	putObjectInBean("ipConsultListBean"+bean_key,ipConsultListBean,session);
}
else if(operation_mode.equals("update"))
{


		eCA.IPConsultationListBean ipConsultListBean = null;

		ipConsultListBean = (eCA.IPConsultationListBean)getObjectFromBean("ipConsultListBeanUpd"+bean_key,"eCA.IPConsultationListBean",session);

	//String bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String cons_ref_id = request.getParameter("cons_ref_id")==null?"":request.getParameter("cons_ref_id");
	String consult_date_time = request.getParameter("consult_date_time")==null?"":request.getParameter("consult_date_time");
	String order_catalog = request.getParameter("order_catalog")==null?"":request.getParameter("order_catalog");
	String p_patient_class = request.getParameter("p_patient_class")==null?"":request.getParameter("p_patient_class");
	String p_episode_id = request.getParameter("p_episode_id")==null?"":request.getParameter("p_episode_id");
	String episode_visit_num = request.getParameter("episode_visit_num")==null?"":request.getParameter("episode_visit_num");
	String practitioner_id = request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
	String source_code = request.getParameter("source_code")==null?"":request.getParameter("source_code");
	String source_type = request.getParameter("source_type")==null?"":request.getParameter("source_type");



	String arrVal ="";

		
	arrVal = cons_ref_id+"~"+patient_id+"~"+encounter_id+"~"+consult_date_time+"~"+order_catalog+"~"+p_patient_class+"~"+p_episode_id+"~"+episode_visit_num+"~"+practitioner_id+"~"+source_code+"~"+source_type;

	if(mode.equals("Add"))
	{
		//if(!ipConsultListBean.returnConsList().contains(arrVal))
		//{
			ipConsultListBean.addtoConsList(arrVal);
		//}


	}
	else if (mode.equals("Rem"))
	{
		if(ipConsultListBean.returnConsList().contains(arrVal))
		{
			ipConsultListBean.remFromConsList(arrVal);
		}

	}
	
	putObjectInBean("ipConsultListBeanUpd"+bean_key,ipConsultListBean,session);

}
	
	
	
	
	


%>
