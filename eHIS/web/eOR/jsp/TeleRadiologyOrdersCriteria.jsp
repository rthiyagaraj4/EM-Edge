<!DOCTYPE html>
<%

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	
06/02/2018		IN065642		Prathyusha P				 		Ramesh G       GHL-CRF-0487 [IN:065642]
14/02/2018      IN066695        Prathyusha p     14/02/2018        Ramesh G        GHL-CRF-0487_US001 [IN:065642]
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,java.sql.*, eOR.* ,eOR.Common.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
	<%

	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	/** added by kishore kumar n on 27/11/2009  */
	Properties properties = (Properties)session.getValue("jdbc");
	String locale	= (String) properties.getProperty("LOCALE");

	 String bean_id					= "TeleRadiologyOrdersBean" ;
		String bean_name				= "eOR.TeleRadiologyOrdersBean";
		TeleRadiologyOrdersBean bean	= (TeleRadiologyOrdersBean)getBeanObject( bean_id, bean_name , request) ;
		//bean.setLanguageId(locale);
		ArrayList sysdate = (ArrayList)bean.getSysDateTime(properties);
		String curr_sys_date			= "";
		String last_month_date			= "";
		String sys_time_sec				= "";
		for(int i=0;i<sysdate.size();i++){
			curr_sys_date	= (String)sysdate.get(0);
			last_month_date = (String)sysdate.get(4);
			sys_time_sec	 = (String)sysdate.get(5);
			//curr_sys_date	= (String)sysdate.get(2);
			//last_month_date = (String)sysdate.get(3);

		}
	    if(curr_sys_date.equals("null") || curr_sys_date.equals(" ")) curr_sys_date="";
		if(last_month_date.equals("null") || last_month_date.equals(" ")) last_month_date="";

	    curr_sys_date = com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMY","en",localeName);
	    last_month_date = com.ehis.util.DateUtils.convertDate(last_month_date,"DMY","en",localeName);
	    String facilityId = (String)session.getValue("facility_id");
		
		String order_facility_id="";
		String order_facility_name="";
		ArrayList OrderingFacility=bean.getOrderingFacilityId(locale);
		
		 
		
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../js/TeleRadiologyOrders.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>

</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name ="teleRadilogyOrdersCriteriaForm"  >
<table border="0" cellspacing="0" id='tbId' width="100%" bordercolor=white>
<tr><td class=label  nowrap><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<select name="ordering_facility_name" id="ordering_facility_name" style="width:200;"  >
		<option value="">-----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------</option>
<%
					for (int i=0;i<OrderingFacility.size();i+=2){
						order_facility_id=(String)OrderingFacility.get(i);
						order_facility_name=(String)OrderingFacility.get(i+1);
						if(facilityId.equals(order_facility_id))	{
%>
							<option value='<%=order_facility_id%>'selected><%=order_facility_name%></option>
<%
						}
						else{
%>
		   					<option value='<%=order_facility_id%>'><%=order_facility_name%></option>
<%						
						}
					}
%>
             
					</SELECT>
					</td>
		 
	<td class=label  nowrap><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></td>
		<td class="fields">
			<input type='hidden' name='ordered_by_code' id='ordered_by_code' value=""/>
			<input type='text' size= 30 name="ordered_by" id="ordered_by" value="" onBlur="checkRec(this)" maxlength=''/>
			<input type='button' class='button' value='?'  name='search_ref' id='search_ref' onClick="getServiceCode(this)"/>
	    </td>	
		<td class=label  nowrap><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
		<td class="fields">
			<input type='text' size='30' maxlength='15' name='order_id' id='order_id' value="" onKeyPress='return CheckForSpecChars(event)' />
		</td> 
	</tr>

	<tr>
		<td class=label  nowrap><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/></td>
		<td class='fields'  >
			<input type='text'  name="ordering_pract_desc" id="ordering_pract_desc" value="" onBlur='getPractitioner1(this)' size= 30 />
			<input type='button' name='search' id='search' value='?'  class='button' onClick="getPractitioner()"/>
			<input type="hidden" name="ordering_pract_code" id="ordering_pract_code" value=''/>
		</td> 
		<td class=label  nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class="fields">
			<input type='hidden' name='order_type' id='order_type' value=""/>
			<input type='text' size= 30 name='order_type_desc' id='order_type_desc' value="" onBlur="callordertypeSearch1(this);"  maxlength='' />
			<input type="button" name="ordertypesearch" id="ordertypesearch" value='?'  class="button"  onClick="callordertypeSearch();"/>
		</td>	
		<td class=label nowrap><fmt:message key="Common.catalog.label" bundle="${common_labels}"/></td>
		<td class="fields"><input type=text name='catalog' id='catalog' value='' size="30" >
			<SELECT name="catalog_search_criteria" id="catalog_search_criteria" >
				<option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
				<option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
				<option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>
	</tr>
	<tr>
		<td class=label  nowrap><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<input type='text' name='performing_facility_id_name' id='performing_facility_id_name' value='' size=30   onblur='getPerformingFacility1(this)' />
			<input type='hidden' name='performing_facility_id' id='performing_facility_id' value='' />
			<input type='button' value='?' name='performing_facility_buttn' id='performing_facility_buttn' class='button' Onclick='getPerformingFacility();'  /></td> 
		<td class=label  nowrap><fmt:message key="Common.Performed.label" bundle="${common_labels}"/> <fmt:message key="Common.by.label" bundle="${common_labels}"/>
		<td class='fields' >
			<input type='hidden' name='performed_by_code' id='performed_by_code' value=""/>
			<input type='text' size=30 name="performed_by" id="performed_by" value="" onBlur="checkRec(this)" />
			<input type='button' class='button' value='?'  name='search_ref' id='search_ref' onClick="getServiceCode1(this)"/>
	    </td>
	    <td class=label ><fmt:message key="Common.Performed.label" bundle="${common_labels}"/> <fmt:message key="eOR.Date.label" bundle="${or_labels}"/> </td>
		<td class="fields" nowrap>
			<input type="text" name="date_from" id="date_from" value="<%=curr_sys_date%>" size="10" maxlength="10" onBlur="chkDateTime(this,'DMY','<%=locale%>');" />
			<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_from');" style='cursor:pointer'/><img align="center" src="../../eCommon/images/mandatory.gif"></img>&nbsp;&nbsp;&nbsp;
			<fmt:message key="Common.to.label" bundle="${common_labels}"/> &nbsp;&nbsp;&nbsp;
			<input type=text name='date_to' id='date_to' value="<%=curr_sys_date%>" size="10" maxlength="10" onBlur="chkDateTime(this,'DMY','<%=locale%>');" />
			<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to');" style='cursor:pointer'/><img align="center" src="../../eCommon/images/mandatory.gif"></img>
		</td>			
	</tr>
	<tr>
		<td class=label  nowrap><fmt:message key="Common.RepFacility.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<input type='text' name='reporting_facility_id_name' id='reporting_facility_id_name' value='' size= 30   onblur='getReportingFactility1(this)'  />
			<input type='hidden' name='reporting_facility_id' id='reporting_facility_id' value='' />
			<input type='button' value='?' name='reporting_facility_buttn' id='reporting_facility_buttn' class='button' Onclick=' getReportingFactility();' />
		</td> 
		<td class=label  nowrap><fmt:message key="Common.Assigned.label" bundle="${common_labels}"/> <fmt:message key="eOR.radiologist.label" bundle="${or_labels}"/></td>
		<td class='fields'  >
				<input type='text'  name="assigned_red_desc" id="assigned_red_desc" value="" onBlur="getRadiologist1(this)" size=30 />
				<input type='button' name='search' id='search' value='?'  class='button' onClick="getRadiologist()" />
				<input type="hidden" name="assigned_red_code" id="assigned_red_code" value=''/>
		</td> 	
		<td class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='fields' >
			<input type="text" name="Patient_Id" id="Patient_Id" size="20" maxlength="30" onKeyPress='return CheckForSpecChars(event)'/>
			<input type="button" name="Patient_Button" id="Patient_Button" value="?" class="button"  onClick="callPatientSearch(document.teleRadilogyOrdersCriteriaForm.Patient_Id)" />
			
		<fmt:message key="eOR.ExamStatus.label" bundle="${or_labels}"/> 
			
			<SELECT name="exam_search_criteria" id="exam_search_criteria" width="20">
				<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value='C'><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
				<option value='H'><fmt:message key="eOR.OnHold.label" bundle="${or_labels}"/> </option>
				<option value='P'><fmt:message key="eOR.Prelim.label" bundle="${or_labels}"/> </option>
				<option value='F'><fmt:message key="Common.Finalized.label" bundle="${common_labels}"/></option>
				<option value='M'><fmt:message key="Common.Modified.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>
	</tr>
	<tr>
		<td class='label' colspan="5"></td>
<td align="right" colspan='2'>
			<input type='button' name='Search' id='Search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class=button onclick="SearchChart('jsp')"/>
			<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class=button onclick="resetCriteria();"/>
		</td>
	</tr> 
</table>
<input type='hidden' name='locale' id='locale' value ='<%=locale%>'/>
<input type='hidden' name='facilityId' id='facilityId' value ='<%=facilityId%>'/>
<input type='hidden' name='current_date' id='current_date' value ='<%=curr_sys_date%>'/>
</form>
<script type="text/javascript">
	SearchChart('jsp');
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</body>
</html>

