<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<html>
<head>
	
<%
        request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  topmargin="0">
<%
	String bean_id			= "DispMedicationBean" ;
	String bean_name		= "ePH.DispMedicationBean";
	DispMedicationBean bean = (DispMedicationBean)getBeanObject(bean_id,bean_name,request) ;


	String patient_id = request.getParameter("patient_id");
	String disp_no = request.getParameter("dispno");

	//String patient_name = request.getParameter("patient_name");
	//String sex	= request.getParameter("sex");
	//String age	= request.getParameter("age");

	java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
	String bean_id1		= "WardReturnBean"+login_at_ws_no;
    String bean_name1 = "ePH.WardReturnBean";
    WardReturnBean ret_bean = (WardReturnBean)getBeanObject( bean_id1,bean_name1,request) ;	 
	
	ArrayList patientDetails=new ArrayList();
	patientDetails=ret_bean.getPatientDetails(patient_id);
	String patient_name = (String)patientDetails.get(0);
	String sex	= (String)patientDetails.get(1);
	String age	= (String)patientDetails.get(2);
	
	String disp_locn_code   = bean.getDispLocnCode();
	boolean displayFacility = false;


	if(sex.equalsIgnoreCase("female"))
		sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
	else if(sex.equalsIgnoreCase("male"))
		sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
	else if(sex.equalsIgnoreCase("unknown"))
		sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

%>
<form name="frmPatientDetails" id="frmPatientDetails" >
<table cellpadding="0" cellspacing="0" width="100%" align="left" border="0" id="patient_details" > 
	<tr>
		<th class="commontoolbarfunction" align="left" >&nbsp;<%=patient_name%>&nbsp;,&nbsp;<%=sex%>&nbsp;,&nbsp;<%=age%>,&nbsp;<%=patient_id%></th>	
	</tr>

	<tr><td>
	<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="showDrugProfile('<%=patient_id%>','<%=disp_locn_code%>','')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/></td></font>
	</tr>

</table>
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

