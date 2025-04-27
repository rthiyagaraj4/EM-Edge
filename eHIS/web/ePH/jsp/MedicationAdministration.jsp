<!DOCTYPE html>
 <!--
Developed by    : P.Sudhakaran.
Module/Function : MedicationAdministration
start date		: 17/06/2003
-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../js/MedicationAdministration.js"></script>
		<script language="javascript" src="../js/MedicationAdministrationFixedTime.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	</head>
<%
	String facility_id		= (String) session.getValue("facility_id");
	//getting the reqd values from MedicationAdministrationBean 
	String bean_id					= "MedicationAdministrationBean";
	String bean_name				= "ePH.MedicationAdministrationBean";
	MedicationAdministrationBean bean			= (MedicationAdministrationBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);
	bean.fetchParamFacilityValues(facility_id); //modified to common method to fetch Parameter for Facility settings for [IN:043283]
	String medn_admin_reqd_yn=bean.getMednAdminReqdYN();

	if(medn_admin_reqd_yn.equals("N")){
%>
		<script>alert(getMessage("PH_MED_ADMIN_NOT_APPLICABLE","PH"));history.go(-1);</script>
<%
	}
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String function_from=request.getParameter("function_from ");
	if(function_from != null){
		function_from=function_from.trim();
	}
	else{
		function_from="";
	}
	if(function_from!=null && function_from.equals("CA")) {
		url = "../../ePH/jsp/MARHeaderForCA.jsp?" ;
	}
	String source = url + params ;
	String called_form=request.getParameter("called_from");
	String option_id=request.getParameter("option_id")==null?"":request.getParameter("option_id");
	String MAR_sch_level_yn = "N";
	HashMap hmSchMARDtl = null;
	//source=url +"access=NYNNN&call_from_ca=Y&function_name=&option_id=PH_MAR_DESKTOP&locale=en&menu_id=PH&module_id=CA&function_id=CLINICIAN_ACCESS&function_name=Clinician%20Access&function_type=F&access=NYNNN&child_window=N&limit_function_id=&chartTitle=&reln_req_yn=N&fromNewFunction=Y&limit_function_id=";
	if(option_id.equals("PH_MAR_PAT_CHART")){
		bean.setSchMARParams();
		hmSchMARDtl =(HashMap) bean.getSchMARParams();
		if(hmSchMARDtl!=null && hmSchMARDtl.size()>0)
			MAR_sch_level_yn = hmSchMARDtl.get("MAR_SCH_LEVEL_YN")==null?"":(String)hmSchMARDtl.get("MAR_SCH_LEVEL_YN");	
	}

	if(function_from!=null && function_from.equals("CA")) { 
		 source =url +"module_id=CA&function_id=PH_MED_ADMIN&function_name=Medication%20Administration&function_type=F&menu_id=PH_TRANSACTIONS&access=NYNNN";  
	}

	if(called_form!=null && called_form.equals("CA")) { 
		source = url +"module_id=PH&function_id=PH_MED_ADMIN&function_name=Medication%20Administration&function_type=F&menu_id=PH_TRANSACTIONS&access=NYNNN"; 
	}

	String call_from_ca = (request.getParameter("call_from_ca")) == null ? "" : request.getParameter("call_from_ca");
	String rows ="37,130,*,9%";

	if (call_from_ca.equals("Y")) {
		//changing CA passed querystring argument "&access=NNYNN" as "&access=NYNNN", if not passed also pass it.
		if( source.indexOf("access",source.indexOf("access")+1) != -1 ) {
			String str1=source.substring(0,source.indexOf("access",source.indexOf("access")+1));
			String str2=source.substring(source.indexOf("access",source.indexOf("access")+1));
			String str3=str2.substring(str2.indexOf("&")+1);
			source=str1+"access=NYNNN&"+str3;
		} 
		else
			source += "&access=NYNNN";
		
		if(MAR_sch_level_yn.equals("Y"))
			rows ="30,*"; //rows ="105,*,25";
		else
			rows ="27,130,*,3%";

	}
%>
	<script>
	   toolBarString = "<%=params%>"
	</script>
	<!--<frameset rows="<%=rows%>" name='MARFrameset'>-->
<%
		if(MAR_sch_level_yn.equals("Y")){
%>	
			<iframe name="f_search" id="f_search" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/MARSchLevelCriteria.jsp?<%=params%>" style="height:6vh;width:100vw"></iframe>
			<iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:94vh;width:100vw"> </iframe> 
<%
		}
		else{
%>	
			<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:5vh;width:100vw"></iframe>
			<iframe name="f_search" id="f_search" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/MedicationAdministrationSearch.jsp?<%=params%>" style="height:20vh;width:100vw"></iframe>
			<iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:67vh;width:100vw"></iframe> 
			<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:7vh;width:100vw"></iframe> 
<%
		}
%> 


<!--- 
	<frameset rows="<%=rows%>" name='MARFrameset'>
<%
		if(MAR_sch_level_yn.equals("Y")){
%>	
			<frame name="f_search" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/MARSchLevelCriteria.jsp?<%=params%>">
			<frame name="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html">  
<%
		}
		else{
%>	
			<frame name="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>">
			<frame name="f_search" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/MedicationAdministrationSearch.jsp?<%=params%>">
			<frame name="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html">  
			<frame name="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto"> 
<%
		}
%>
	</frameset>
	-->
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

