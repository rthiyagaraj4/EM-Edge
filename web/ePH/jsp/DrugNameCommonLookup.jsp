<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

	    String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	  
		%>
<%-- Mandatory declarations end --%>

<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<title id="lookup_title"><fmt:message key="ePH.DrugSearch.label" bundle="${ph_labels}"/></title>

<%
String select			=	request.getParameter("select");
String dflt_txt			=	request.getParameter("default_text")==null?"":request.getParameter("default_text").trim();
String frm				=	request.getParameter("frm");
String identity			=   request.getParameter("identity");
String order_type_code	=	request.getParameter("order_type_code");
String modalYN			=	request.getParameter("modalYN");
String res_by_service	=	request.getParameter("res_by_service");
String service_code		=	request.getParameter("service_code");
String patient_class	=	request.getParameter("patient_class");
String drugorfluid		=	request.getParameter("drugorfluid");
String priority			=	request.getParameter("priority");
String discharge_yn		=	request.getParameter("discharge_yn");
String patient_id		=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id		=	request.getParameter("encounter_id");
String source_type		=	request.getParameter("source_type");
String source_code		=	request.getParameter("source_code");
String iv_prep_yn		=	request.getParameter("iv_prep_yn");
String calledfrom		=	request.getParameter("calledfrom");
String disp_locn_code   =   request.getParameter("disp_locn_code");
String date_of_birth	=   request.getParameter("date_of_birth")==null?"":request.getParameter("date_of_birth");
String gender			=   request.getParameter("gender")==null?"":request.getParameter("gender");
String normalRx_yn      =   request.getParameter("normalRx_yn")==null?"":request.getParameter("normalRx_yn"); // GHL-CRF-0549
String home_leave_yn_val			=   request.getParameter("home_leave_yn_val")==null?"":request.getParameter("home_leave_yn_val");//added home_leave_yn_val for Bru-HIMS-CRF-093[29960] 
String alternateOrder	=	request.getParameter("alternateOrder");//added for  JD-CRF-0198 [IN:058599]
String	bean_id  = "DrugSearchBean";
DrugSearchBean bean=null;
if(identity!=null){
	if(identity.equals("MedicationOrder")){
		bean_id		=	 request.getParameter("bean_id") ;
	}
}
String bean_name = "ePH.DrugSearchBean";
bean	 =	(DrugSearchBean)getBeanObject( bean_id, bean_name, request ) ;
 bean.setLanguageId(locale);

/*
bean.setDrugOrFluid(CommonBean.checkForNull(drugorfluid));
bean.setDischargeYN(discharge_yn);
bean.setPriority(priority);
*/
if (order_type_code != null){
	if (order_type_code.equals("NO")){
		order_type_code = "";
	}
}
String drug_codes = request.getParameter("drug_codes");
bean.initialize();

if(drug_codes != null){
   drug_codes = drug_codes.replace('[',' ');
   drug_codes = drug_codes.replace(']',' ');
   drug_codes = drug_codes.trim();
   bean.setDrugsAsDisabled(drug_codes.trim());
}

%>
<!-- added home_leave_yn_val for Bru-HIMS-CRF-093[29960] //added for  JD-CRF-0198 [IN:058599] and normalRx_yn added for GHL-CRF-0549 -->
<iframe name="lookup_header" id="lookup_header" src="../../ePH/jsp/DrugNameCommonLookupSearchCriteria.jsp?select=<%=select%>&default_text=<%=java.net.URLEncoder.encode(dflt_txt,"UTF-8")%>&frm=<%=frm%>&identity=<%=identity%>&order_type_code=<%=order_type_code%>&drug_codes=<%=drug_codes%>&bean_id=<%=bean_id%>&modalYN=<%=modalYN%>&res_by_service=<%=res_by_service%>&service_code=<%=service_code%>&patient_class=<%=patient_class%>&drugorfluid=<%=drugorfluid%>&priority=<%=priority%>&discharge_yn=<%=discharge_yn%>&patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&date_of_birth=<%=date_of_birth%>&gender=<%=gender%>&source_type=<%=source_type%>&source_code=<%=source_code%>&iv_prep_yn=<%=iv_prep_yn%>&calledfrom=<%=calledfrom%>&disp_locn_code=<%=disp_locn_code%>&home_leave_yn_val=<%=home_leave_yn_val%>&alternateOrder=<%=alternateOrder %>&normalRx_yn=<%=normalRx_yn%>" noresize  frameborder="no" marginheight="0" marginwidth="0" scrolling="no" style="height:30vh;width:96vw"></iframe>
<iframe name="lookup_footer" id="lookup_footer" src="../../eCommon/html/blank.html" noresize  frameborder="no" marginheight="0" marginwidth="0" style="height:70vh;width:96vw"></iframe>

</html>

<%

putObjectInBean(bean_id,bean,request);
%>

