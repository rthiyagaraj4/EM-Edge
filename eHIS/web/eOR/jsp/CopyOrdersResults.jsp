<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
24/11/2011    IN029659       Chowminya G    Incident No: IN029659 - < System allows to place the new orders using Copy Previous Order function- CRF Linked Issue> 
13/08/2013	  IN042045		 Chowminya G	System should not allow to copy for the drugs for which Verbal Order Applicable is not selected																														
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------
19/03/2015  IN052649		Ramesh G										Previous orders - Default filter to be filtered by All or by specialty	 
27/07/2022	26826			Ramesh G										MMS-DM-CRF-0197 
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" %>

<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<HTML>
<HEAD>
    <TITLE></TITLE>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript"	src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>


	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ExistingOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<BODY onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	/* Mandatory checks start */
	//String mode	   = "1";//request.getParameter( "mode" ) ;

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id		= request.getParameter("bean_id");
	String bean_name	= request.getParameter("bean_name");

	bean_id				= (bean_id == null) ? "":bean_id.trim();
	bean_name			= (bean_name == null) ? "":bean_name.trim();

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id"); //--[IN029659]
	String resp_id = (String)session.getValue("responsibility_id");
	String cur_encounter_id	= request.getParameter("cur_encounter_id");//--[IN029659]
	String cur_patient_class	= request.getParameter("cur_patient_class");//--[IN029659]
	String practitioner_type	= request.getParameter("practitioner_type");//IN042045
	
	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";

	ArrayList allValues = new ArrayList();
	String finalString  = "";
	String patient_id	= "";
	String encounter_id = "";
	String date_from	= "";
	String date_to		= "";
	String order_category	= "";
	String order_type_code	= "";
	String ord_pract_id		= "";
	//String function_id		= "";
	String view_by			= "";
	String patient_class	= "";
	String catalog			= "";
	String search_criteria  = "";
	String activity_type	= "";
	String location_type	= "";
	String locn	= "";
	String speciality_code	= "";	//IN052649
	String OrderingSpecialityCopyPreviousOrder	= "";	//IN052649
	String function_from = request.getParameter("function_from");
	function_from = (function_from == null) ? "" : function_from.trim();
 	if (function_from.equals("")) {
		//function_id = request.getParameter( "function_id" ) ;

		patient_id		= request.getParameter("patientId");
		encounter_id	= request.getParameter("encntr_id");
		patient_class	= request.getParameter("patient_class");
		date_from		= request.getParameter("date_from");
		date_to			= request.getParameter("date_to");
		order_category	= request.getParameter("order_category");
		order_type_code	= request.getParameter("order_type");
		ord_pract_id 	= request.getParameter("ord_pract_id");
		catalog			= request.getParameter("catalog");
		view_by			= request.getParameter("view_by");
		search_criteria = request.getParameter("search_criteria");
		activity_type	= request.getParameter("activity_type")==null?"":request.getParameter("activity_type");
		location_type	= request.getParameter("location_type")==null?"":request.getParameter("location_type");
		locn	= request.getParameter("locn")==null?"":request.getParameter("locn");
		speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code"); //IN052649
		OrderingSpecialityCopyPreviousOrder = request.getParameter("OrderingSpecialityCopyPreviousOrder")==null?"N":request.getParameter("OrderingSpecialityCopyPreviousOrder"); //IN052649

		patient_id 		= (patient_id == null) ? "" : patient_id.trim();
		encounter_id 	= (encounter_id == null) ? "" : encounter_id.trim();
		patient_class	= (patient_class == null) ? "" : patient_class.trim();
		date_from	 	= (date_from == null) ? "" : date_from.trim();
		date_to		 	= (date_to == null) ? "" : date_to.trim();
		order_category 	= (order_category == null) ? "" : order_category.trim();
		order_type_code = (order_type_code == null)? "" : order_type_code.trim();
		ord_pract_id 	= (ord_pract_id == null) ? "" :ord_pract_id.trim();
		catalog			= (catalog == null) ? "" : catalog.trim();
		view_by			= (view_by == null) ? "L" : view_by.trim();
		search_criteria	= (search_criteria == null) ? "S" : search_criteria.trim();
	} else {
		finalString = request.getParameter("finalString");
		finalString	= (finalString == null) ? "" : finalString.trim();
	}
	/* Mandatory checks end */

	/* Initialize Function specific start */
	//ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);

	//bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	//bean.clear() ;
	//bean.setMode( mode ) ;

// THESE ARE THE PARAMS FOR AMMEND FUNCTION

	/*String location_type			= bean.checkForNull(request.getParameter("location_type"),"");
	String location_code			= bean.checkForNull(request.getParameter("location_code"),"");
	String patient_class			= bean.checkForNull(request.getParameter("patient_class"),"");
	String p_called_from_ca			= bean.checkForNull(request.getParameter("p_called_from_ca"),"");
	String sex						= bean.checkForNull(request.getParameter("sex"),"");
	String age						= bean.checkForNull(request.getParameter("age"),"");
	String dob						= bean.checkForNull(request.getParameter("dob"),"");
	String visit_adm_date			= bean.checkForNull(request.getParameter("visit_adm_date"),"");*/

// THESE ARE THE PARAMS FOR AMMEND FUNCTION - END
	//--[IN029659]--Start
	String discharge_adv_date_time = "";
	String[] record = new String[2] ;
	
	HashMap  copyPrevAccess= (HashMap)bean.getCopyPreviousOrderAccess(facility_id,practitioner_type);  //19314
	discharge_adv_date_time = bean.getDischargeAdvDateTime(patient_id,cur_encounter_id); 
	record = bean.getDischargeDateTime(patient_id,cur_encounter_id); 
	//--[IN029659]--End
	if (function_from.equals("")) 
	{
		//allValues		= bean.viewCopyOrderDetails(patient_id,encounter_id,patient_class,date_from,date_to,order_category,order_type_code,facility_id,cur_encounter_id,cur_patient_class,record[0],record[1],discharge_adv_date_time,ord_pract_id,catalog,view_by,search_criteria,activity_type,location_type,locn); //Modified --[IN029659]//IN042045
		// IN052649 Start
		//allValues		= bean.viewCopyOrderDetails(patient_id,encounter_id,patient_class,date_from,date_to,order_category,order_type_code,facility_id,cur_encounter_id,cur_patient_class,record[0],record[1],discharge_adv_date_time,ord_pract_id,catalog,view_by,search_criteria,activity_type,location_type,locn,practitioner_type); //IN042045
		allValues		= bean.viewCopyOrderDetails(patient_id,encounter_id,patient_class,date_from,date_to,order_category,order_type_code,facility_id,cur_encounter_id,cur_patient_class,record[0],record[1],discharge_adv_date_time,ord_pract_id,catalog,view_by,search_criteria,activity_type,location_type,locn,practitioner_type,speciality_code,OrderingSpecialityCopyPreviousOrder); //IN052649
		//IN052649 End.
	} else 
	{
		allValues		= bean.getBeanValues();
	}

	if(allValues.size() == 0){
%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
			parent.CopyOrdersHdr.location.href = "../../eCommon/html/blank.html";
			parent.CopyOrdersResults.location.href = "../../eCommon/html/blank.html";
			parent.CopyOrdersResultsBottom.location.href = "../../eCommon/html/blank.html";
			parent.CopyOrdersBtn.location.href = "../../eCommon/html/blank.html";
		</script>
<%	}
%>
<form name="copy_orders_results" id="copy_orders_results" target="messageFrame" >
<Table cellpadding="3" cellspacing="0" border="1" width="100%" class="grid">
<%
	String[] copy_details = null;
	String slClassValue = "";
	int j = 0;

	for(int i=0; i<allValues.size(); i++){
		if (finalString.indexOf("~"+i+"~") == -1) {
			copy_details = (String[])allValues.get(i);

	       /* if(j % 2 == 0){
				slClassValue = "QRYEVEN";
			}else{
				slClassValue = "QRYODD";
			}*/
			slClassValue="gridData";

			if(copy_details[0] == null) copy_details[0] = "";
	        if(copy_details[1] == null) copy_details[1] = "";
	        if(copy_details[2] == null) copy_details[2] = "";
	        if(copy_details[3] == null) copy_details[3] = "";
	        if(copy_details[4] == null) copy_details[4] = "";
	        if(copy_details[5] == null) copy_details[5] = "";
	        if(copy_details[6] == null) copy_details[6] = "";
	        if(copy_details[7] == null) copy_details[7] = "";
			if(copy_details[8] == null) copy_details[8] = "";
			if(copy_details[9] == null) copy_details[9] = "";
			if(copy_details[10] == null) copy_details[10] = "";
			if(copy_details[11] == null) copy_details[11] = "";
	        if(copy_details[12] == null) copy_details[12] = "";
	        if(copy_details[13] == null) copy_details[13] = "";
	        if(copy_details[14] == null) copy_details[14] = "";
			if(copy_details[15] == null) copy_details[15] = "";
	        if(copy_details[16] == null) copy_details[16] = "";
	        if(copy_details[17] == null) copy_details[17] = "";
	        if(copy_details[18] == null) copy_details[18] = "";
			if(copy_details[19] == null) copy_details[19] = "";
	        if(copy_details[20] == null) copy_details[20] = "";
	        if(copy_details[21] == null) copy_details[21] = "";
	        if(copy_details[22] == null) copy_details[22] = "";
			if(copy_details[23] == null) copy_details[23] = "";
	        if(copy_details[24] == null) copy_details[24] = "";
	        if(copy_details[25] == null) copy_details[25] = "";
	        if(copy_details[26] == null) copy_details[26] = "";
	        if(copy_details[27] == null) copy_details[27] = "";
	        if(copy_details[28] == null) copy_details[28] = "";
			if(copy_details[29] == null) copy_details[29] = "";
	        if(view_by.equals("L")) {		        
		        if(copy_details[30] == null) copy_details[30] = "";
		        if(copy_details[31] == null) copy_details[31] = "";
				if(copy_details[32] == null) copy_details[32] = "";
	        }
			if(copy_details[10].indexOf("$$RD##")!=-1)
			{
					String[] str = (String[])copy_details[10].split("!~!");
					String order_detail ="";
					String[] strtitle = null;
					for(int s=0;s<str.length;s++)
					{
						if(str[s].indexOf("$$RD##")!=-1)
						{
							String line_order = (String)str[s];
							strtitle  =line_order.split("::");
							String titleText = "";
							if(strtitle[1].length()>0)
							{
								titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels")+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Reason.label","or_labels")+":"+ strtitle[1];
							}
							else
							{
								titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels");
							}
							strtitle[0] = "<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";
							order_detail = order_detail+strtitle[0]+strtitle[2]+", ";
						}
						else
						{
							order_detail = order_detail+str[s]+", ";
						}
					}
					copy_details[10] = order_detail;
					if(copy_details[10].lastIndexOf(",") ==((copy_details[10].length())-2))
					{
						copy_details[10] = copy_details[10] .substring(0,((copy_details[10].length())-2));
					}
				}
				if(copy_details[10].indexOf("!~!")!=-1)
				{
					copy_details[10] = copy_details[10].replace("!~!",",");
				}
				String deptOnlyYN="N";
				if("L".equals(view_by)){
					deptOnlyYN=copy_details[32];
				}else if("H".equals(view_by)){
					deptOnlyYN=copy_details[29];
				}
	        %>

	        <tr>
		<td width='5%' class='<%=slClassValue%>' ><input type=checkbox name='chk<%=i%>' id='chk<%=i%>'  value="N" onClick='clickSelect1()'  <%if("N".equals(copyPrevAccess.get(copy_details[0])) && "Y".equals(deptOnlyYN)){%> disabled title="Restricted Departmental Order from Copy Previous Orders"<%}%> ></td>
	        	<td width='8%' class='<%=slClassValue%>' ><font size=1><%=copy_details[1]%></font></td>
	        	<td width='8%' class='<%=slClassValue%>' ><font size=1><%=copy_details[2]%></font></td>
	        	<%if (view_by.equals("L")) {%>
	        		<td width='10%' class='<%=slClassValue%>' ><font size=1><a class="gridLink" href="javascript:callCopyMenuFunctions1('View','escape(<%=copy_details[1]%>)','<%=copy_details[0]%>','<%=copy_details[6]%>','','<%=copy_details[29]%>','<%=copy_details[30]%>','','<%=copy_details[7]%>','<%=copy_details[20]%>','<%=copy_details[18]%>','<%=copy_details[21]%>')"><%=copy_details[10]%></a></font></td>
	        	<%} else if (view_by.equals("H")) {%>
	        		<td width='10%' class='<%=slClassValue%>' ><font size=1><a class="gridLink" href="javascript:callMenuFunctions('View','<%=copy_details[7]%>','<%=copy_details[0]%>','<%=copy_details[1]%>','<%=copy_details[6]%>','<%=copy_details[20]%>','<%=copy_details[18]%>','<%=copy_details[21]%>','<%=copy_details[14]%>','','<%=copy_details[8]%>','<%=copy_details[5]%>')"><%=copy_details[10]%></a></font></td>
	        	<%}%>
	        	<td width='12%' class='<%=slClassValue%>' ><font size=1><%=com.ehis.util.DateUtils.convertDate(copy_details[27],"DMYHM","en",localeName)%></font></td>
	        	<td width='12%' class='<%=slClassValue%>' ><font size=1><%=com.ehis.util.DateUtils.convertDate(copy_details[28],"DMYHM","en",localeName)%></font></td>
	        	<td width='6%' class='<%=slClassValue%>' ><font size=1><%=copy_details[3]%></font></td>
	        	<td width='10%' class='<%=slClassValue%>' ><font size=1><%=copy_details[17]%></font></td>

	        	<td width='10%' class='<%=slClassValue%>' ><font size=1><%=copy_details[19]%></font></td>
				<input type='hidden' name='order_category<%=i%>' id='order_category<%=i%>' value='<%=copy_details[0]%>'>  <!-- 26826-->
				<%-- <input type='hidden' name='order_id<%=i%>' id='order_id<%=i%>' value='<%=copy_details[6]%>'>
	        	<input type='hidden' name='sex<%=i%>' id='sex<%=i%>' value='<%=copy_details[21]%>'>
	        	<input type='hidden' name='dob<%=i%>' id='dob<%=i%>' value='<%=copy_details[22]%>'>
	        	<input type='hidden' name='order_type_code<%=i%>' id='order_type_code<%=i%>' value='<%=copy_details[14]%>'>
	        	<input type='hidden' name='order_category<%=i%>' id='order_category<%=i%>' value='<%=copy_details[0]%>'>
	        	<input type='hidden' name='patient_id<%=i%>' id='patient_id<%=i%>' value='<%=copy_details[7]%>'>
	        	<input type='hidden' name='encounter_id<%=i%>' id='encounter_id<%=i%>' value='<%=copy_details[8]%>'>
	        	<input type='hidden' name='ord_pract_id<%=i%>' id='ord_pract_id<%=i%>' value='<%=copy_details[16]%>'>
	        	<input type='hidden' name='priority<%=i%>' id='priority<%=i%>' value='<%=copy_details[13]%>'>
	        	<input type='hidden' name='order_status<%=i%>' id='order_status<%=i%>' value='<%=copy_details[18]%>'>
	        	<input type='hidden' name='cont_order_ind<%=i%>' id='cont_order_ind<%=i%>' value='<%=copy_details[20]%>'>
	        	<input type='hidden' name='ordering_facility_id<%=i%>' id='ordering_facility_id<%=i%>' value='<%=copy_details[23]%>'>
	        	<input type='hidden' name='source_code<%=i%>' id='source_code<%=i%>' value='<%=copy_details[12]%>'>
	        	<input type='hidden' name='iv_prep_yn<%=i%>' id='iv_prep_yn<%=i%>' value='<%=copy_details[25]%>'>
	        	<input type='hidden' name='age<%=i%>' id='age<%=i%>' value='<%=copy_details[26]%>'>
	        	<input type='hidden' name='source_type<%=i%>' id='source_type<%=i%>' value='<%=copy_details[11]%>'>
	        	<input type='hidden' name='patient_class<%=i%>' id='patient_class<%=i%>' value='<%=copy_details[5]%>'> --%>
	        </tr>
	<%		j++;
		}
	}
%>
</Table>
<input type='hidden' name='finalString' id='finalString' value='<%=finalString%>'>
<input type='hidden' name='allValues' id='allValues' value='<%=allValues.size()%>'>
<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>'>
<input type='hidden' name='localeName' id='localeName' value='<%=localeName%>'>
</form>
<%

%>
</BODY>
</HTML>

<%
	//putObjectInBean(bean_id,bean,request);
%>

