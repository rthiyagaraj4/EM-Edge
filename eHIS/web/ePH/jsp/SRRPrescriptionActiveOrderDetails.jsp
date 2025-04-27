<!DOCTYPE html>
 <!--saved on 15th Dec 2009 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>


<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8"); 
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
			request= new XSSRequestWrapper(request); 
			response.addHeader("X-XSS-Protection", "1; mode=block"); 
			response.addHeader("X-Content-Type-Options", "nosniff"); 
			//Added by Himanshu for MMS-ME-SCF-0097 endss
	String locale = (String) session.getAttribute("LOCALE");
	

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/PrescriptionTest.js"></script>
 	<script language="JavaScript" src="../js/SRRPhRepPrescription.js"></script>   
<!-- 	<script language="JavaScript" src="../js/SRRPhDispLabel.js"></script>   -->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<title><fmt:message key="ePH.CurrentMedication.label" bundle="${ph_labels}"/></title>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="PrescriptionActiveOrderDetailsForm" id="PrescriptionActiveOrderDetailsForm" >
<%

		String patient_id			=	CommonBean.checkForNull(request.getParameter("patient_id"));
		String orderid			    =	CommonBean.checkForNull(request.getParameter("orderid"));
		String encounter_id			    =	CommonBean.checkForNull(request.getParameter("encounter_id"));
		String order_type			    =	CommonBean.checkForNull(request.getParameter("order_type"));
	
	//out.println("patient_id--------->"+patient_id);
	//out.println("orderid------------>"+orderid);
		
		String	start_date			=	"";
		String	end_date			=	"";
		String	drug_desc			=	"";
		String	strength			=	"";
		String	strength_uom_desc	=	"";
		String	form_desc			=	"";
		String	practitioner_name	=	"";
		String	facility_name		=	"";
		String	location			=	"";
		String diag_text			=	"";
		String split_dose_prev		=	"";
		String order_id				=	"";
		String order_line_no		=	"";
		String freq_code			=	"";
		String freq_desc			=	"";
		String duplicate_reason		=	"";
		String allergy_reason		=	"";
		String dosage_reason		=	"";	
		String link					=	"";
		String discont_date_time	=	"";
		String perf_locn			=	"";
		String iv_prep_yn			=   "";
		String discharge_ind		=	"";
		String in_formulary_yn		=	"";
		String dosage				=	"";
		String dosage_uom			=	"";
		String per_facility_name	=	"";
		String key                  =   "";
		String drug_code            =   "";
		String trn_group_ref	    =	"";
		String disp_no	            =	"";
		String srl_no               =   "";
		String flag                 =   "";
		String prescribed_qty       =   "";
		String pres_practitioner_id =   "";
		String patient_class =   "";
		String drug_yn = "";
		
		String	bean_id				= "SRROnlineReportSet1Bean";
		String bean_name			= "ePH.SRROnlineReportSet1Bean";
		String facility_id					= (String) session.getValue("facility_id");
		String class_name			=	"";
		ArrayList active_orders		=	new ArrayList();		

		SRROnlineReportSet1Bean bean = (SRROnlineReportSet1Bean)getBeanObject(bean_id,bean_name,request) ;
		bean.setLanguageId(locale);
		bean.clear();



			active_orders	=	(ArrayList) bean.getDrugLabelActiveOrders(patient_id,orderid,facility_id,locale);


 //  out.println("active_orders-------->" +active_orders);
 // out.println("active_orders.size-------->" +active_orders.size());
    int maxcnt=active_orders.size();
//	out.println("orderid---->"+orderid);
//	out.println("patient_id---->"+patient_id);
	//out.println("p_disp_locn_code---->"+p_disp_locn_code);


	
%>
    <table cellpadding=0 cellspacing=0 width="150%" align="center" border="1">
	<tr>
			<th  class="small" width="13%"><fmt:message  key="Common.StartDate.label" bundle="${common_labels}"/></th>
			<th  class="small" width="13%"><fmt:message  key="Common.enddate.label" bundle="${common_labels}"/></th>
			<th  class="small" width="15%"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
			<th  class="small" width="8%"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/></th>
			<th  class="small" width="10%"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></th>
			<th  class="small" width="12%"><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></th>
			<th  class="small" width="10%"><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></th>
			<th  class="small" width="10%" nowrap><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></th>
			<th  class="small" width="15%" nowrap><fmt:message key="Common.facility.label" bundle="${common_labels}"/></th>
			<th  class="small" width="8%"><fmt:message  key="Common.diagnosis.label" bundle="${common_labels}"/></th>
			<th  class="small" width="8%"><fmt:message  key="Common.Select.label" bundle="${common_labels}"/><input type="checkbox" name="selectall_yn" id="selectall_yn" value="N"  onClick="return chkall(PrescriptionActiveOrderDetailsForm);"></th>
		
		
		<!-- 	<th  class="small" width="20%"><fmt:message  key="Common.PerformingFacility.label" bundle="${common_labels}"/></th>  -->
	</tr>
<%
		for (int i=0; i<active_orders.size(); i++) {

			if(i%2==0)
				class_name	=	"QRYEVENSMALL";
			else
				class_name	=	"QRYODDSMALL";

			HashMap record	=	(HashMap)	active_orders.get(i);
		
			start_date			=	CommonBean.checkForNull((String) record.get("start_date"));
			end_date			=	CommonBean.checkForNull((String) record.get("end_date"));
			drug_desc			=	CommonBean.checkForNull((String) record.get("drug_desc"));
			strength			=	CommonBean.checkForNull((String) record.get("strength"));
			split_dose_prev		=	CommonBean.checkForNull((String) record.get("split_dose_prev")); 
			strength_uom_desc	=	CommonBean.checkForNull((String) record.get("strength_uom_desc"));
			form_desc			=	CommonBean.checkForNull((String) record.get("form_desc"));
			practitioner_name	=	CommonBean.checkForNull((String) record.get("practitioner_name"));
			facility_name		=	CommonBean.checkForNull((String) record.get("facility_name"));
			diag_text			=	CommonBean.checkForNull((String) record.get("diag_text"));
			location			=	CommonBean.checkForNull((String) record.get("location"));
			order_id			=	CommonBean.checkForNull((String) record.get("order_id")); 
			order_line_no		=	CommonBean.checkForNull((String) record.get("order_line_no")); 
			freq_code			=	CommonBean.checkForNull((String) record.get("freq_code"));      
			freq_desc			=	CommonBean.checkForNull((String) record.get("freq_desc")); 
			allergy_reason		=	CommonBean.checkForNull((String) record.get("allergy_reason")); 
			dosage_reason		=	CommonBean.checkForNull((String) record.get("dosage_reason")); 
			duplicate_reason	=	CommonBean.checkForNull((String) record.get("duplicate_reason")); 
			pres_practitioner_id=	CommonBean.checkForNull((String) record.get("pres_practitioner_id")); 
			drug_code	        =	CommonBean.checkForNull((String) record.get("drug_code")); 
			patient_class	    =	CommonBean.checkForNull((String) record.get("patient_class")); 
			trn_group_ref	    =	CommonBean.checkForNull((String) record.get("trn_group_ref")); 
			disp_no	            =	CommonBean.checkForNull((String) record.get("disp_no")); 
			srl_no	            =	CommonBean.checkForNull((String) record.get("srl_no")); 
			prescribed_qty	    =	CommonBean.checkForNull((String) record.get("prescribed_qty")); 
			iv_prep_yn			=   CommonBean.checkForNull((String) record.get("iv_prep_yn")); 
			discharge_ind		=   CommonBean.checkForNull((String) record.get("discharge_ind")); 
			in_formulary_yn		=	CommonBean.checkForNull((String) record.get("in_formulary_yn")); 
			dosage				=	CommonBean.checkForNull((String) record.get("dosage")); 
			dosage_uom			=	CommonBean.checkForNull((String) record.get("dosage_uom_code")); 
			//p_langue			=	CommonBean.checkForNull((String) record.get("p_langue")); 
			perf_locn			=	CommonBean.checkForNull((String) record.get("pref_locn")); 
			drug_yn  =  CommonBean.checkForNull((String) record.get("drug_yn")); 
			flag	            =	(String) record.get("flag"); 
			patient_id	        =	(String) record.get("patient_id"); 
			discont_date_time	=	(String) record.get("discont_date_time"); 
			String discont_color="";
// Below code added for IN25904 --14-01-2011-- priya
			if(drug_yn.equals("N"))
			{
				freq_desc = "&nbsp;";
				freq_code = "";

			}
	
 // out.println("order_id-------->" +order_id);
//  out.println("trn_group_ref-------->" +trn_group_ref);
 // out.println("order_line_no-------->" +order_line_no);


			if(discont_date_time !=null &&  !discont_date_time.equals("")){
				discont_color = "red"; 
			}
						
			if(!allergy_reason.equals("") || !dosage_reason.equals("") || !duplicate_reason.equals("")) {
				link		=	"onClick=\"showReasons('"+allergy_reason+"','"+dosage_reason+"','"+duplicate_reason+"')\"  style='cursor:pointer;color:blue'";
			}
			else {
				link		=	"";
			}

			StringTokenizer st		=	new StringTokenizer(diag_text,"~");
			boolean diag_text_found	=	false;
				while(st.hasMoreTokens()) {
				String txt	= (String)st.nextToken();
				if(!txt.equals("")) {
					diag_text_found	=	true;
					break;
				}
			}

			if(iv_prep_yn.equals("1")||iv_prep_yn.equals("2")||iv_prep_yn.equals("3")||iv_prep_yn.equals("4")||iv_prep_yn.equals("5")){
				if(order_line_no.equals("1")){
					class_name = "IVFLUID";
				}else{
					class_name		  = "IVINGREDIENT";
					practitioner_name = "&nbsp;";
					facility_name	  = "&nbsp;";
					location    = "&nbsp;";
					perf_locn	= "&nbsp;";
					freq_code	= "&nbsp;";	
			//		start_date  = "&nbsp;";
			//		end_date    = "&nbsp;";
				}
			}
		
			//if(iv_prep_yn != null){
			//	order_line_no = "1";
			//}
			if(in_formulary_yn.equals("N"))
					class_name	=	"FORMULARY";

			if(discharge_ind.equals("D"))
					class_name	= "DISCHARGEMED";
	/*if(!locale.equals("en")){
		start_date = DateUtils.convertDate(start_date, "DMYHM","en",locale);
		end_date = DateUtils.convertDate(end_date, "DMYHM","en",locale);
	}*/



%>
	<tr >
			<td  class="<%=class_name%>"nowrap ><%=start_date%></td>
			<td  class="<%=class_name%>"nowrap ><%=end_date%></td>
			<td  class="<%=class_name%>"  width="15%" <%=link%> ><label style="color:<%=discont_color%>"><%=drug_desc%></label></td>
<%			
			if(split_dose_prev.equals("")) {		
%>
			<!-- <td  class="<%=class_name%>"><%=dosage%>&nbsp;<%=dosage_uom%></td> commented on 8/10/09-->
			<td  class="<%=class_name%>"nowrap><%=dosage%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,dosage_uom))%></td>
			<td  class="<%=class_name%>"  nowrap><%=freq_desc%></td>
<%			}	else	{	%>
			<!-- <td  class="<%=class_name%>"><%=dosage%>&nbsp;<%=dosage_uom%></td> commented on 8/10/09-->
			<td  class="<%=class_name%>"nowrap><%=dosage%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,dosage_uom))%></td>
			<td  class="<%=class_name%>" width="10%" ><label onClick="callFreqDet('<%=patient_id%>','<%=encounter_id%>','<%=order_id%>','<%=order_line_no%>','<%=java.net.URLEncoder.encode(freq_desc,"UTF-8")%>','<%=start_date%>')" style="cursor:pointer;color:blue" nowrap><%=freq_desc%></label></td>
<%			}	%>

			<td  class="<%=class_name%>" nowrap>&nbsp;<%=practitioner_name%></td>
			<td  class="<%=class_name%>" nowrap>&nbsp;<%=location%></td>
			<td  class="<%=class_name%>" nowrap><%=perf_locn%>&nbsp;</td>
			<td  class="<%=class_name%>"nowrap>&nbsp;<%=facility_name%></td>
			<!-- <td  class="<%=class_name%>">&nbsp;</td> -->
<%			
			if(diag_text_found) {
%>
			<td  class="<%=class_name%>" style="cursor:pointer;color:blue" nowrap><label onClick="callDiagText('<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(diag_text,"UTF-8")%>')">Details</label></td>

<%
			}
			else {
%>
			<td  class="<%=class_name%>" nowrap>&nbsp;</td>

<%
			}
%>
		<!-- 	<td  class="<%=class_name%>"nowrap>&nbsp;<%=per_facility_name%></td>   -->
                 <td  class="<%=class_name%>"nowrap> 
					 
	 <input type="checkbox" name="p_print_yn<%=i%>" id="p_print_yn<%=i%>" value="<%=flag%>"  onClick="assignValue(this);calvalidation(PrescriptionActiveOrderDetailsForm,this,'<%=facility_id%>','<%=i%>','<%=order_id%>~<%=order_line_no%>');" >
		</td>
		<input type="hidden" name="prescription_<%=i%>" id="prescription_<%=i%>" value="<%=order_id%>~<%=order_line_no%>">


					


		</tr>
<%
		}
%>
   <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="max_cnt" id="max_cnt" value="<%=maxcnt%>">
	<input type="hidden" name="orderid" id="orderid" value="<%=orderid%>">
	<input type="hidden" name="order_type" id="order_type" value="<%=order_type%>">
	</table>

</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>


