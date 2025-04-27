<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>

<html>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


   <%
try{
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
String i_clinic_code= checkForNull(request.getParameter("i_clinic_code"));
String i_clinic_name=checkForNull(request.getParameter("i_clinic_name"));
String i_practitioner_id=checkForNull(request.getParameter("i_practitioner_id"));
String i_practitioner_name=checkForNull(request.getParameter("i_practitioner_name"));
String i_appt_date=checkForNull(request.getParameter("i_appt_date"));
String i_from_time=checkForNull(request.getParameter("i_from_time"));
String i_to_time=checkForNull(request.getParameter("i_to_time"));
String i_time_table_type=checkForNull(request.getParameter("i_time_table_type"));
String i_patient_id=checkForNull(request.getParameter("i_patient_id"));
String clinic_type=checkForNull(request.getParameter("clinic_type"));
String res_type=checkForNull(request.getParameter("res_type"));
String or_catalogue_code=checkForNull(request.getParameter("or_catalogue_code"));
String order_id=checkForNull(request.getParameter("order_id"));
String order_line_num=checkForNull(request.getParameter("order_line_num"));
String order_catalog_code=checkForNull(request.getParameter("order_catalog_code"));
String create_wait_list_yn=checkForNull(request.getParameter("create_wait_list_yn"));
String entitlement_by_pat_cat_yn	= checkForNull(request.getParameter("entitlement_by_pat_cat_yn"));
String max_patients_per_slab	= checkForNull(request.getParameter("max_patients_per_slab"));
String calling_mode	= checkForNull(request.getParameter("calling_mode"));

System.out.println("i_clinic_code==>"+i_clinic_code);
System.out.println("i_clinic_name==>"+i_clinic_name);
System.out.println("i_practitioner_id==>"+i_practitioner_id);
System.out.println("i_practitioner_name==>"+i_practitioner_name);
System.out.println("i_appt_date==>"+i_appt_date);
System.out.println("i_from_time==>"+i_from_time);
System.out.println("i_to_time==>"+i_to_time);
System.out.println("i_time_table_type==>"+i_time_table_type);
System.out.println("i_patient_id==>"+i_patient_id);
System.out.println("clinic_type==>"+clinic_type);
System.out.println("res_type==>"+res_type);
System.out.println("entitlement_by_pat_cat_yn==>"+entitlement_by_pat_cat_yn);
   %>

	<head><title><fmt:message key="eOA.AppointmentGroups.label" bundle="${oa_labels}"/></title></head>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eOA/jsp/AppointmentGroupSelect.jsp?i_clinic_code=<%=i_clinic_code%>&i_clinic_name=<%=i_clinic_name%>&i_practitioner_id=<%=i_practitioner_id%>&i_practitioner_name=<%=i_practitioner_name%>&i_appt_date=<%=i_appt_date%>&i_from_time=<%=i_from_time%>&i_to_time=<%=i_to_time%>&i_time_table_type=<%=i_time_table_type%>&i_patient_id=<%=i_patient_id%>&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&or_catalogue_code=<%=or_catalogue_code%>&order_id=<%=order_id%>&order_line_num=<%=order_line_num%>&order_catalog_code=<%=order_catalog_code%>&create_wait_list_yn=<%=create_wait_list_yn%>&entitlement_by_pat_cat_yn=<%=entitlement_by_pat_cat_yn%>&max_patients_per_slab=<%=max_patients_per_slab%>"  scrolling='no' marginheight='0' marginwidth='0' style='height:86vh;width:100vw'></iframe>
	<iframe name='ButtonFrame' id='ButtonFrame'  src='../../eOA/jsp/BookApptButtons.jsp?fromPage=GroupAppoinment'  noresize scrolling='no' marginheight='0' marginwidth='0' style='height:5vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'  src='../../eCommon/jsp/error.jsp'  noresize scrolling='auto' marginheight='0' marginwidth='0' style='height:9vh;width:100vw'></iframe></html>
		<%
   }catch(Exception e){
		e.printStackTrace();
	}
		%>
		
<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

