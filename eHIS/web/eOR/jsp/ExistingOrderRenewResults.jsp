<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head><title><fmt:message key="eOR.ActiveOrders.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<!-- used for date validation-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<% 


    	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
				String bean_id = "Or_PatOrderByPrivRelnBean" ;
				String bean_name = "eOR.PatOrderByPrivRelnBean";
//				String practitioner_id = (String)session.getValue("ca_practitioner_id");
	/* Mandatory checks end */

		//PatOrderByPrivRelnBean bean = (PatOrderByPrivRelnBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		PatOrderByPrivRelnBean	 bean = (PatOrderByPrivRelnBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(localeName);

		String mode	   = "1";//request.getParameter( "mode" ) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		bean.clear() ;
		bean.setMode( mode ) ;
		//String session_id= bean.getSessionId();
		//String tmpstr =new String();
		String slClassValue = "";
		//int count = 0;


//	String Patient_id = request.getParameter("Patient_id") ;
	String order_id    = request.getParameter("order_id");
	if (order_id == null) order_id = "";
	String order_line_num = request.getParameter("order_line_num");
	if (order_line_num == null) order_line_num = "";
	String Order_type_code = "";
	/*if( Patient_id==null || Patient_id.equals("")){
			out.println("<script>alert('Patient id is Null');</script>");
	}else {
		Patient_id = Patient_id.trim();
	}*/

	ArrayList searchData=new ArrayList();
	try{
	 //searchData=(ArrayList)bean.getModalRenewResultDetails(Patient_id,practitioner_id,order_id,order_line_num);
	 searchData=(ArrayList)bean.getModalRenewResultDetails(order_id);

	}catch(Exception e){
		out.println("Exception in search function::"+e);
	}
//  out.println(searchData.size());


/* Initialize Function specific end */

%>
<form name='formPatientPendingOrders' id='formPatientPendingOrders'>
<table name='' id='' border='1' cellspacing='0' cellpadding = '3' width='100%' align='center' class="grid">


<%
try{
	String Pat_details = "";
	
	//String Order_cat = "";
	//String Order_type = "";
	//String Loc_details = "";
	//String Date_details = "";
	String temp_grpby="";
	String priority="";
	//String sex="";
	//String Pat_Id="";
	//String Order_Id="";
	//String result_link="";
	//String Ord_status="";
	//String cont_order_ind="";
	//String Order_cat_code="";

	for(int i=0;i<searchData.size();i++){

	ArrayList GroupBy=(ArrayList)searchData.get(i);
	  Pat_details = (String)GroupBy.get(17);
	  Order_type_code = (String)GroupBy.get(2);
	 //Order_cat = (String)GroupBy.get(1);
	 //Order_cat_code = (String)GroupBy.get(0);
	 //Order_type = (String)GroupBy.get(3);
	 //Loc_details = (String)GroupBy.get(10);
	// Date_details = (String)GroupBy.get(14);
	// sex = (String)GroupBy.get(20);
	// Pat_Id = (String)GroupBy.get(11);
	 //Order_Id = (String)GroupBy.get(13);
	 //result_link=(String)GroupBy.get(21);
	// Ord_status = (String)GroupBy.get(16);
	// cont_order_ind=(String)GroupBy.get(22);
	 
				//	System.out.println("==="+register_details[11]);
if (Pat_details.indexOf(",")!=-1){

			StringTokenizer fieldTokenizer = new StringTokenizer(Pat_details,",");
			Pat_details="";
		
		while (fieldTokenizer.hasMoreTokens()) {
		  String tempToken = fieldTokenizer.nextToken();
		 
		   if ((tempToken.indexOf('/'))==1)
			{
			  String tempstr=tempToken.substring(1);
			  if (tempToken.charAt(0)=='M')
				  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")).concat(tempstr);
			  else if(tempToken.charAt(0)=='F')
				  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")).concat(tempstr);
			}
			Pat_details=Pat_details.concat(tempToken).concat(",");
			  
         

		}
					 }
		


	if(((String)GroupBy.get(4)).equals("R")){
					priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
										
				}
				else if(((String)GroupBy.get(4)).equals("U"))
				{
					
					priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
					
				}
					else if(((String)GroupBy.get(4)).equals("S"))
				{
					
					priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
					
				}

//if(result_link == null || result_link.equals("null")) result_link =""; else result_link = result_link.trim();

if (!temp_grpby.equals(Pat_details)) {
			temp_grpby=Pat_details;
%>
	<tr>
		<td colspan='100%' align='left' class ='CAGROUPHEADING'><%=temp_grpby%></td>
	</tr>
<%}


		/*if(i % 2 == 0){
		slClassValue = "QRYEVEN";
		} else{ slClassValue = "QRYODD";
	}*/
	slClassValue="gridData";	
%>


<tr>


	<td  class='<%=slClassValue%>' width='16%' ><font size=1><%=(String)GroupBy.get(18)%></font></td>

	<td  class='<%=slClassValue%>' width='16%' ><font size=1><%=(String)GroupBy.get(19)%></font></td>

	<td  class='<%=slClassValue%>' width='10%' ><font size=1><%=priority%></font></td>

	<td  class='<%=slClassValue%>' width='14%' ><font size=1><%=(String)GroupBy.get(3)%></font></td>

	<td  class='<%=slClassValue%>' width='16%' ><font size=1><%=(String)GroupBy.get(15)%></font></td>

	<td  class='<%=slClassValue%>' width='14%' ><font size=1><%=(String)GroupBy.get(7)%></font></td>

	<td  class='<%=slClassValue%>' width='14%' ><font
		size=1><%=(String)GroupBy.get(16)%>	</font></td>
</tr>
<%}%>

	<%}catch(Exception e){
		//out.println(e.getMessage());
		e.printStackTrace();//COMMON-ICN-0181
	}%>
</table>
<input type='hidden' name='order_id' id='order_id' value='<%=order_id%>'>
<input type='hidden' name='ord_typ_code' id='ord_typ_code' value='<%=Order_type_code%>'>
<input type='hidden' name='order_line_num' id='order_line_num' value='<%=order_line_num%>'>
<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>'>
</form>
</Body>
</Html>

<%
		putObjectInBean(bean_id,bean,request);

%>

