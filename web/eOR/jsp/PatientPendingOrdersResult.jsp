<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- PatientPendingOrdersResult.jsp -->
<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head><title>Active Orders</title>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	


	<script language="JavaScript" src="../../eCommon/js/common.js"></script>


	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<!-- used for date validation-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

	<script language="JavaScript" src="../js/ExternalOrder.js"></script>

 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>


</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<%
	/* Mandatory checks start */
				String bean_id = "Or_PatOrderByPrivRelnBean" ;
				String bean_name = "eOR.PatOrderByPrivRelnBean";
				String practitioner_id = (String)session.getValue("ca_practitioner_id");
	/* Mandatory checks end */

	//PatOrderByPrivRelnBean bean = (PatOrderByPrivRelnBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	 PatOrderByPrivRelnBean bean = (PatOrderByPrivRelnBean)getBeanObject( bean_id, bean_name, request ) ;
		String mode	   = "1";//request.getParameter( "mode" ) ;
	
	bean.setLanguageId(localeName);	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		bean.clear() ;
		bean.setMode( mode ) ;
	//	String session_id= bean.getSessionId();
	//	String tmpstr =new String();
		String slClassValue = "";
	//	int count = 0;


	String Patient_id = request.getParameter("Patient_id") ;
	String encounter_id = bean.checkForNull(request.getParameter("encounter_id"),"");
	String patient_class = bean.checkForNull(request.getParameter("patient_class"),"");
	String discharge_indicator = bean.checkForNull(request.getParameter("discharge_indicator"),"");

	if( Patient_id==null || Patient_id.equals("")){
		Patient_id = "";
	}else {
		Patient_id = Patient_id.trim();
	}

	/*Patient_id = "RH00017171";
	encounter_id = "10";
	discharge_indicator = "Y";*/


	ArrayList searchData=new ArrayList();
	try{
        searchData=(ArrayList)bean.getModalResultDetails(Patient_id,practitioner_id,encounter_id,patient_class,discharge_indicator);
         if(searchData.size() == 0){%>
     <script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
	</script>

	<%}
    }catch(Exception e){
		e.printStackTrace();
	}



/* Initialize Function specific end */

%>
<form name='formPatientPendingOrders' id='formPatientPendingOrders'>
<table name='' id='' border='1' cellspacing='0' cellpadding = '0' width='100%' align='center' class="grid">


<%
try{
	String Pat_details = "";
	String Order_cat = "";
	//String Order_type = "";
	//String Loc_details = "";
	//String Date_details = "";
	String temp_grpby="";
	//String sex="";
	String Pat_Id="";
	String Order_Id="";
	String result_link="";
	//String Ord_status="";
	String cont_order_ind="";
	String Order_cat_code="";
	ArrayList GroupBy= null;

	for(int i=0;i<searchData.size();i++){
//	for(int i=0;i<10;i++){

	 GroupBy=(ArrayList)searchData.get(i);
	 Pat_details = (String)GroupBy.get(17);
	 Order_cat = (String)GroupBy.get(0);
	 Order_cat_code = (String)GroupBy.get(1);
	 //Order_type = (String)GroupBy.get(3);
	 //Loc_details = (String)GroupBy.get(10);
	// Date_details = (String)GroupBy.get(14);
	 //sex = (String)GroupBy.get(20);
	 Pat_Id = (String)GroupBy.get(11);
	 Order_Id = (String)GroupBy.get(13);
	 result_link=(String)GroupBy.get(22);
	// Ord_status = (String)GroupBy.get(16);
	 cont_order_ind=(String)GroupBy.get(23);

if(result_link == null || result_link.equals("null")) result_link =""; else result_link = result_link.trim();

if (!temp_grpby.equals(Pat_details)) {
			temp_grpby=Pat_details;
%>
	<tr>
		<td colspan='100%' align='left' class ='CAGROUPHEADING'><%=temp_grpby%></td>
	</tr>
<%}


		/*if(i % 2 == 0){
		slClassValue = "QRYEVEN";
		} else{ slClassValue = "QRYODD";*/
		slClassValue="gridData";
	
%>


<tr>


	<td  class='<%=slClassValue%>' width='16%' align=left><font size=1><%=(String)GroupBy.get(19)%></font></td>

	<td  class='<%=slClassValue%>' width='16%' align=left><font size=1><%=(String)GroupBy.get(20)%></font></td>

	<td  class='<%=slClassValue%>' width='10%' align=left><font size=1><%=(String)GroupBy.get(4)%></font></td>

	<td  class='<%=slClassValue%>' width='14%' align=left><font size=1><%=(String)GroupBy.get(3)%></font></td>

	<td  class='<%=slClassValue%>' width='16%' align=left><font size=1><%=(String)GroupBy.get(15)%></font></td>

	<td  class='<%=slClassValue%>' width='14%' align=left><font size=1><%=(String)GroupBy.get(7)%></font></td>

	<%//if (encounter_id.equals("")) {%>
	<%  if(result_link.equals("Y")) { %>
		<td  class='<%=slClassValue%>' width='14%' align=left><font size=1><a 	href="javascript:resultViewOrder('Result','<%=Order_cat%>','<%=Order_Id%>','','<%=cont_order_ind%>','<%=Pat_Id%>','<%=Order_cat_code%>')"><%=(String)GroupBy.get(16)%></a>	</font></td>
	<%} else {%>
		   <td  class='<%=slClassValue%>' width='14%' align=left><font size=1><%=(String)GroupBy.get(16)%>	</font></td>
	<% //}%>
</tr>
<%}}
		GroupBy.clear();searchData.clear();
%>

	<%
	}catch(Exception e)
	{
		e.printStackTrace();
	}%>
</table>
</form>

<%
		putObjectInBean(bean_id,bean,request);
%>

