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
-------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
08/10/2013		IN041268 		Vijayakumar K	REGRESSION-Alpha-OR-System is displaying special character in the Order Preview Screen
24/3/2016		IN058811		Raja S			24/03/2016		Ramesh G		MO-CRF-20107 :National ID to be captured in any orderable (ALL 																				Order Categories) is a national requirement.
17/07/2018		IN064543		Kamalakannan	17/07/2018		Ramesh G		ML-MMOH-CRF-0776
22/07/2018		IN068445		Kamalakannan	22/07/2018		Ramesh G		ML-MMOH-CRF-0776				
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<!--
    New File Added to take care of the Line Level Order Format
-->

<%-- JSP Page specific attributes start --%>
<%-- IN041268 starts --%>
<%--<%@page import="eOR.*, java.util.*"  contentType="text/html; charset=UTF-8" %> --%>
<%@page import="eOR.*, java.util.*,java.net.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8" %>
<%-- IN041268 ends --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- Mandatory declarations end --%>
<%!

/*Added by Uma on 5/4/2010 for IN021062*/
private String decodeLocal(String field,String objVal,PageContext pageContext)
{
	String returntext="";
	if(objVal.trim().equalsIgnoreCase(""))
	{
		return	"";
	}
	if(field.equalsIgnoreCase("priority"))
	{
		if(objVal.equalsIgnoreCase("R"))
		{			
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");	
		}
		else if(objVal.equalsIgnoreCase("U"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
		}
		else if(objVal.equalsIgnoreCase("S"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
		}
	}
	else if(field.equalsIgnoreCase("sex"))
	{
		if(objVal.equalsIgnoreCase("M"))
		{			
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");	
		}
		else if(objVal.equalsIgnoreCase("F"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		}
		//IN039587 Starts
		else if(objVal.equalsIgnoreCase("U"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}
		//IN039587 Ends
	}
	else if(field.equalsIgnoreCase("duration"))
	{
		if(objVal.equalsIgnoreCase("M"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute(s).label","common_labels");
		}
		else if(objVal.equalsIgnoreCase("H"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
		}
		else if(objVal.equalsIgnoreCase("D"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Day(s).label","or_labels");
		}
		else if(objVal.equalsIgnoreCase("W"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Week(s).label","or_labels");
		}
		else if(objVal.equalsIgnoreCase("L"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Month(s).label","or_labels");
		}
		else 
		{
			returntext = "";
		}
	}
	else
	{
		return "";
	}
	if((returntext.length()>0)&&(returntext!=null))
		return returntext;
	else
		return "";
}
/*Ends Here by Uma on 5/4/2010 for IN021062*/
%>
<%

    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 		= request.getParameter("bean_id");
	String bean_name 	= request.getParameter("bean_name");
	/* Initialize Function specific start */
	//OrderEntryBean bean = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	beanQueryObj.setLanguageId(localeName);
	OrderEntryBean bean = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean 	= (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	// If it is a new patient set it, other wise get the patient id
	//orderEntryRecordBean.getPatient(bean.getPatientId());
	/* Initialize Function specific end */
%>
<html>
    <head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<!--IN064543--><script language="JavaScript" src="../../eOR/js/OrderEntryPreview.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 		<style></style>
	<script>
	// could not avoid to use the dialog Arguments...
	/*onLoad='doInit();'function doInit()
	{
		var txtArr 	= parent.parent.dialogArguments; 
		var str 	= '';
		for (y=0;y<txtArr.length;y++)
			str 	= str + txtArr[y]; 
		document.write(str);
	}	
	*/
	</script>
	</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to 	the bean to get the connection if using the query bean and not the functional bean 
	//IN041268 starts
	//String facility_name 			= bean.checkForNull(request.getParameter("facility_name"),"");
	String facility_name 			= URLDecoder.decode(bean.checkForNull(request.getParameter("facility_name"),""), "utf-8");
	//IN041268 ends
	String sys_date 				= bean.checkForNull(request.getParameter("sys_date"),"");

	//System.err.println("sys_date==========================="+sys_date);
	String patient_id 				= bean.checkForNull(request.getParameter("patient_id"),"");
	String encounter_id 			= bean.checkForNull(request.getParameter("encounter_id"),"");
	String physician_name 			= bean.checkForNull(request.getParameter("physician_name"),"");
	String order_date_time 			= bean.checkForNull(request.getParameter("order_date_time"),"");
	String sex 						= bean.checkForNull(request.getParameter("sex"),"");
	String age 						= bean.checkForNull(request.getParameter("age"),"");
	String dob 						= bean.checkForNull(request.getParameter("dob"),"");
	String order_id 				= bean.checkForNull(request.getParameter("order_id"),"");
	String ammend_called_from 				= bean.checkForNull(request.getParameter("ammend_called_from"),"");
	String nationality			 = "";
   	String patient_name			 = "";
	String national_id			 = "";  //IN058811
	int cnt=0;//IN068445
	ArrayList Nationality  = bean.getNationality(patient_id);// Get the Nationality Desc
   	if(Nationality!=null && Nationality.size() > 0)
   	{
   	    nationality = (String)Nationality.get(0);
   	    patient_name     = (String)Nationality.get(1); // Get the patient_name
		national_id	     = (String)Nationality.get(2); //IN058811
   	}
	String location_type			 = bean.checkForNull(bean.getLocationType(),"");
   	String location_code			 = bean.checkForNull(bean.getLocationCode(),"");
   	String location_name			 = "";
	ArrayList locn_dtls			 = new ArrayList();
	locn_dtls			 = bean.getLocationName(location_type,location_code);
	if(locn_dtls.size()>0)
	{
		for(int dtls=0;dtls<locn_dtls.size();dtls++)
		{
			String location=(String)locn_dtls.get(dtls);
			dtls++;
			String source_type       =(String)locn_dtls.get(dtls);
			if(source_type.equalsIgnoreCase("C"))
			{								
				source_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			}
			else if(source_type.equalsIgnoreCase("N"))
			{
				source_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
			}else if(source_type.equalsIgnoreCase("R"))
			{
				source_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
			}
			else if(source_type.equalsIgnoreCase("D"))
			{
				source_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
			}
			location_name = source_type+" / "+location;
		}

	}

	//System.err.println("dob"+dob);
	//String nationality 				= bean.checkForNull(request.getParameter("nationality"),"");
		
//	String location_type 			= bean.checkForNull(request.getParameter("location_type"),"");
//	String location_code 			= bean.checkForNull(request.getParameter("location_code"),"");
	//String location_name 			= bean.checkForNull(request.getParameter("location_name"),"");
	//String patient_name 			= bean.checkForNull(request.getParameter("patient_name"),"");
	String priority 				= bean.checkForNull(request.getParameter("priority"),"");	
	/*Added by Uma on 5/4/2010 for IN021062*/
	//String order_id 				= bean.checkForNull(request.getParameter("order_id"),"");
	if(priority.equalsIgnoreCase("R")||priority.equalsIgnoreCase("U")||priority.equalsIgnoreCase("S"))
	{			
		priority = (String)decodeLocal("priority",priority,pageContext);
	}
	/*Ends Here by Uma on 5/4/2010 for IN021062*/
	int total_rows 					= Integer.parseInt(bean.checkForNull(request.getParameter("total_rows"),"0"));
	String order_category			= bean.checkForNull(request.getParameter("order_category"),"");
	StringBuffer comments 			= new StringBuffer();
	// From the bean for header level clinical comments
	if(ammend_called_from.equalsIgnoreCase("existing_order"))
	{		
		if(bean.getAmendClinicalComments().length() > 0 )
		{
			comments = new StringBuffer();
			comments.append(bean.getAmendClinicalComments());		
		}
		else
		{
			comments = new StringBuffer();
			comments.append(bean.getAmendComments(order_id));
		}
	}
	else
	{		
		comments				= (StringBuffer)orderEntryRecordBean.getOrderFormats(order_category+"_CLINICALCOMMENTS",order_category+"_CLINICALCOMMENTS_0");
	}
	if(comments==null)
	{		
		comments 				= new StringBuffer();
	}
   //Header level ccomments
	// Till here	

	// Multi Patient Logic
	int count_patient				= 1;
	String record[]					= null;
	String record_patient[]			= null;
//	String pat_id					= null;
	ArrayList multi_patient			= bean.getMultiPatientDetails();  // Get the Multi Patient Orders Details
	if(multi_patient!=null && multi_patient.size() > 0)			  // Only If it is for Multi Patients
		count_patient				= multi_patient.size();			  // Else it will be 1 patient by default
	// Till here Multi Patient Logic	
	String performing_arr[] 		= new String [total_rows];
	String order_type_arr[] 		= new String [total_rows];
	String priority_arr[] 			= new String [total_rows];
	String instrn_content_type[]	= new String [total_rows];//IN064543
	String frequency_arr[]	 		= new String [total_rows];
	String frequency_desc_arr[]		= new String [total_rows];
	String duration_value_arr[]		= new String [total_rows];
	String ord_spl_appr_arr[] 		= new String [total_rows];
	String performing_dept_arr[]	= new String [total_rows];
	String catalog_code_arr[]		= new String [total_rows];
	String start_date_arr[] 		= new String [total_rows];
	String catalog_desc_arr[] 		= new String [total_rows];
	String priority_desc_arr[]		= new String [total_rows];
	String end_date_time_arr[]		= new String [total_rows];
	String duration_desc_arr[]		= new String [total_rows];
	String order_type_desc_arr[]	= new String [total_rows];
	String line_comment_arr[]		= new String [total_rows];
	String specimen_type_arr[]		= new String [total_rows];
	String nurse_collect_arr[]		= new String [total_rows];
	String appt_reqd_arr[]			= new String [total_rows];
	String chart_result_type[]		= new String [total_rows];
			
	String grouping					= "";
	String tree_grouping 			= "";
	String line_comment				= "";
	String nurse_collect			= "";
	String specimen_type			= "";
	TreeMap sorted_group	 		= new TreeMap();
	HashMap	hash_map				= new HashMap();	
	Set sorted_set 					= null;
	Iterator itr_map 				= null;
	ArrayList arrSeqNo				= null;
	Hashtable template    			= new Hashtable(); //new java.util.Hashtable(); 
	ArrayList PatientDtls			= null;
	int count						= 1;
	int seq_num     		  		= 0, grouping_seq_no = 0;
	String split_grouping			= "";
	String priority_desc			= "";
	String duration_desc			= "";
	for(int i=0;i<total_rows;i++)
	{	
		performing_arr[i]			= bean.checkForNull(request.getParameter("performing_facility_id"+i),"");	
		order_type_arr[i]			= bean.checkForNull(request.getParameter("order_type_code"+i),"");	
		priority_arr[i]				= bean.checkForNull(request.getParameter("priority"+i),"");	
		instrn_content_type[i]				= bean.checkForNull(request.getParameter("instrn_content_type"+i),"T");	//IN064543
		/*Added by Uma on 5/4/2010 for IN021062*/
		priority_desc				= bean.checkForNull(request.getParameter("priority_desc"+i),"");
		if(priority_desc.equalsIgnoreCase("R")||priority_desc.equalsIgnoreCase("U")||priority_desc.equalsIgnoreCase("S"))
		{			
			priority_desc = (String)decodeLocal("priority",priority_desc,pageContext);
		}
		//priority_desc_arr[i]		= bean.checkForNull(request.getParameter("priority_desc"+i),"");	
		/*Ends Here by Uma on 5/4/2010 for IN021062*/
		priority_desc_arr[i]		= priority_desc;	
		ord_spl_appr_arr[i]			= bean.checkForNull(request.getParameter("ord_spl_appr_reqd_yn"+i),"");
		catalog_code_arr[i]			= bean.checkForNull(request.getParameter("catalog_code"+i),""); 	
		frequency_arr[i]			= bean.checkForNull(request.getParameter("frequency"+i),"");
		frequency_desc_arr[i]		= bean.checkForNull(request.getParameter("frequency_code_arr"+i),"");
		start_date_arr[i]			= bean.checkForNull(request.getParameter("start_date_time"+i),"");	
		duration_value_arr[i]		= bean.checkForNull(request.getParameter("duration_value"+i),"");	
		performing_dept_arr[i]		= bean.checkForNull(request.getParameter("performing_dept_loc_code"+i),"");
		catalog_desc_arr[i]			= bean.checkForNull(request.getParameter("cat_desc"+i),"");
		end_date_time_arr[i]		= bean.checkForNull(request.getParameter("end_date_time"+i),"");
		//duration_desc_arr[i]		= bean.checkForNull(request.getParameter("duration_desc"+i),"");
		duration_desc				= bean.checkForNull(request.getParameter("duration_desc"+i),"");
		if(duration_desc.equalsIgnoreCase("M")||duration_desc.equalsIgnoreCase("H")||duration_desc.equalsIgnoreCase("D")||duration_desc.equalsIgnoreCase("W")||duration_desc.equalsIgnoreCase("L"))
		{			
			duration_desc = (String)decodeLocal("duration",duration_desc,pageContext);
		}
		duration_desc_arr[i]		= duration_desc;
		order_type_desc_arr[i]		= bean.checkForNull(request.getParameter("order_type_desc"+i),"");
		appt_reqd_arr[i]			= bean.checkForNull(request.getParameter("appt_reqd_yn"+i),"");
		chart_result_type[i]		= bean.checkForNull(request.getParameter("chart_result_type"+i),"");		
		arrSeqNo					= (ArrayList) orderEntryRecordBean.getOrderFormats("Comments"+catalog_code_arr[i], catalog_code_arr[i]);
		if(arrSeqNo!=null && arrSeqNo.size()>0)
		{
		  		line_comment 		=  bean.checkForNull((String) arrSeqNo.get(0),""); // comment
		}
		line_comment_arr[i]			= line_comment;
		
		nurse_collect				= "N"; specimen_type = "";
		arrSeqNo        			= (ArrayList) orderEntryRecordBean.getOrderFormats(catalog_code_arr[i], catalog_code_arr[i]+"_0");
		if(arrSeqNo!= null && arrSeqNo.size() >0)
		{
		   for(int k=0;k<arrSeqNo.size();k++)
		   {
		      seq_num   	 		= Integer.parseInt((String)arrSeqNo.get(k));//((Integer)arrSeqNo.get(k)).intValue(); // get the seq_num
		      template 				 = (Hashtable)  orderEntryRecordBean.getOrderFormats ( catalog_code_arr[i], (catalog_code_arr[i]+seq_num) );
		      if( template!=null && (((String) template.get("field_mnemonic")).equalsIgnoreCase("SPECIMEN_TYPE")) ) // System Defined cannot be changed
		      	specimen_type 		= bean.checkForNull((String) template.get("field_values"),"");
		      else if(template!=null && (((String) template.get("field_mnemonic")).equalsIgnoreCase("NURSE_COLLECT_YN")) ) // System Defined cannot be changed
		        nurse_collect 		= bean.checkForNull((String) template.get("field_values"),"N");
		  }  // End of for  
	  } // End of if called_from
 		if(appt_reqd_arr[i].equals("Y")) {
			grouping_seq_no++;
			split_grouping = bean.checkForNull(bean.splitGroupingOrders(grouping_seq_no),"000"); // call a method to get the split_grouping like "000" or "001" etc
		} else if(chart_result_type[i].equals("Y")) {
			grouping_seq_no++;
			split_grouping = bean.checkForNull(bean.splitGroupingOrders(grouping_seq_no),"000"); //call a method to get the split_grouping like "000" or "001" etc 
		} else split_grouping = "000";
 
	  specimen_type_arr[i]			= specimen_type;
	  nurse_collect_arr[i]			= nurse_collect;
 	 			grouping 			= performing_arr[i]+order_type_arr[i]+ priority_arr[i]+ord_spl_appr_arr[i]+specimen_type_arr[i]+nurse_collect_arr[i]+start_date_arr[i]+frequency_arr[i]+duration_value_arr[i]+performing_dept_arr[i]+split_grouping;
			    sorted_group.put(grouping,grouping);
 			    hash_map.put("ORDER_TYPE"+grouping,(String)order_type_desc_arr[i]);
			
	 } // End of total_rows
%>
<%
	for(int k=0;k<count_patient;k++)		// For the No of patients
	{ 
		if(multi_patient!=null && multi_patient.size() > 0)
		{
			record					= (String[]) multi_patient.get(k);
			patient_id				= bean.checkForNull(record[0],""); //patient_id
			encounter_id			= bean.checkForNull(record[1],""); //encounterid
			Nationality				= bean.getNationality(patient_id);
			if(Nationality!=null && Nationality.size() > 0)
		   	{
   				nationality			= (String)Nationality.get(0);
		   	    patient_name		= (String)Nationality.get(1); // Get the patient_name
				national_id			= (String)Nationality.get(2); //IN058811
   			}	
			PatientDtls				= beanQueryObj.getAgeSexDtls(properties, patient_id); // Get the sex,age and date_of_birth
			for(int i=0; i<PatientDtls.size(); i++)	// Only one record
			{	
				record_patient		= (String[])PatientDtls.get(i);
				sex	 				= record_patient[0];
				dob 	 			= record_patient[1];
				age 	 			= record_patient[2];
			}
		}  // End of multi_patient != null
	sex = (String)decodeLocal("sex",sex,pageContext);
	sorted_set 		= (Set)sorted_group.keySet();
	itr_map 		= (Iterator)sorted_set.iterator() ;
	while(itr_map.hasNext()){
		count		= 1;	
		tree_grouping = (String)itr_map.next();

%>
	<table width='100%' border='0' cellspacing='2' cellpadding='3' align=center height='auto'>
	<tr>
		<td class="BODYCOLORFILLED"   colspan=5 width="auto"><b><%=facility_name%></b></td>
		<td align="right" class='BODYCOLORFILLED'  width='auto'><b><%=sys_date%></b></td>
	</tr>
	<tr><td colspan=5 class='BODYCOLORFILLED'  width='auto'></td></tr>
	<tr><td colspan=5 class='BODYCOLORFILLED'  width='auto'></td></tr>
	
		<table CLASS="BOX" width='100%' border='0' cellspacing='2' cellpadding='3' align=center height='auto'>
			<tr><td colspan=4 class='PATQRED'   width='auto'><b><fmt:message key="eOR.OrderRequestfor.label" bundle="${or_labels}"/> <%=hash_map.get("ORDER_TYPE"+tree_grouping)%></b></td></tr>
			<tr><td colspan=4 class='BODYCOLORFILLED'><hr style='color=black' size='1'></td></tr>
			<tr>
				<td class='BODYCOLORFILLED'  width='auto' nowrap><b><fmt:message key="Common.OrderNo.label" bundle="${common_labels}"/></b>
				</td>
				<td class='BODYCOLORFILLED'  width='auto'><fmt:message key="eOR.Tobegenerated.label" bundle="${or_labels}"/>/<%=order_id%>
				</td>
				<td class='BODYCOLORFILLED'  width='auto' nowrap><b><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></b>
				</td>
				<td class='BODYCOLORFILLED'  width='auto'><%=order_date_time%>
				</td>
			</tr>
			<tr>
				<td class='BODYCOLORFILLED'  width='auto' nowrap><b><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></b>
				</td>
				<td class='BODYCOLORFILLED'  	width='auto'><%=physician_name%>
				</td>
				<td class='BODYCOLORFILLED'  width='auto' nowrap><b><fmt:message key="Common.priority.label" bundle="${common_labels}"/></b>
				</td>
				<td class='BODYCOLORFILLED'  width='auto'><%=priority%>
				</td>
			</tr>
			<tr>
				<td  class='BODYCOLORFILLED'  width='auto' nowrap><b><fmt:message key="Common.patient.label" bundle="${common_labels}"/></b>
				</td>
				<!--<td  colspan=3 class='BODYCOLORFILLED'  width='auto'><%=patient_name%>,<%=patient_id%>,<%=age%>,<%=sex%> 
				</td>
			</tr>
			<tr>	-->  <!--IN058811 removed colspan-->
				<td  class='BODYCOLORFILLED'  width='auto'><%=patient_name%>,<%=patient_id%>,<%=age%>,<%=sex%>
				</td>
				<td class='BODYCOLORFILLED'  width='auto' nowrap><b><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></b>
				</td>
				<td class='BODYCOLORFILLED'  width='auto'><%=com.ehis.util.DateUtils.convertDate(dob,"DMY","en",localeName)%>
				</td>
			</tr>
			<tr>
				<td class='BODYCOLORFILLED'  width='auto' nowrap><b><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></b>
				</td>
				<td class='BODYCOLORFILLED'  width='auto'><%=nationality%>
				</td>
				<!--IN058811 Starts -->
				<td class='BODYCOLORFILLED'  width='auto' nowrap><b><fmt:message key="eOR.NationalId.label" bundle="${or_labels}"/></td></b>
				</td>
				<td class='BODYCOLORFILLED'  width='auto'><%=national_id%>     
				</td> 
				<!--IN058811 End -->
			</tr>
			<tr>
				<td class='BODYCOLORFILLED'  width='auto' nowrap><b><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></b>
				</td>
				<td class='BODYCOLORFILLED'  width='auto'><%=encounter_id%>
				</td>
				<td class='BODYCOLORFILLED'  width='auto' nowrap><b><fmt:message key="Common.OrderLocation.label" bundle="${common_labels}"/></b>
				</td>
				<td class='BODYCOLORFILLED' width='auto'><%=location_name%>
				</td>
			</tr>
			<tr>
				<td  class='BODYCOLORFILLED'  width='auto' valign=top nowrap><b><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/></b>
				</td>
				<td  colspan=3 class='BODYCOLORFILLED'  width='auto'><%=comments%>
				</td>
			</tr>
			<tr>
				<td colspan=4 class='BODYCOLORFILLED'><hr style='color=black' size='1'>
				</td>
			</tr>
		</table>
		<table CLASS="BOX" width='100%' border='0' cellspacing='2' cellpadding='3' align=center height='auto'>
		<tr>
			<td class='BODYCOLORFILLED'  width='auto' nowrap><b><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></b></td>
			<td class='BODYCOLORFILLED'  width='auto' nowrap><b><fmt:message key="eOR.CatalogName.label" bundle="${or_labels}"/></b>
			</td>
			<td class='BODYCOLORFILLED'  width='auto' nowrap><b><fmt:message key="Common.priority.label" bundle="${common_labels}"/></b>
			</td>
			<td class='BODYCOLORFILLED'  width='auto' nowrap><b><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></b>
			</td>
			<td class='BODYCOLORFILLED'  width='auto' nowrap><b><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></b>
			</td>
		</tr>
		<tr>
			<td colspan=5 class='BODYCOLORFILLED'><hr style='color=black' size='1'>
			</td>
		</tr>	
<%		grouping_seq_no = 0;// reinitialize
		for(int i=0;i<total_rows;i++)
		{
			if(appt_reqd_arr[i].equals("Y")) {
				grouping_seq_no++;
				split_grouping = bean.checkForNull(bean.splitGroupingOrders(grouping_seq_no),"000"); // call a method to get the split_grouping like "000" or "001" etc
			} else if(chart_result_type[i].equals("Y")) {
				grouping_seq_no++;
				split_grouping = bean.checkForNull(bean.splitGroupingOrders(grouping_seq_no),"000"); // call a method to get the split_grouping like "000" or "001" etc
			} else split_grouping = "000";

			grouping 		= performing_arr[i]+order_type_arr[i]+ priority_arr[i]+ord_spl_appr_arr[i]+specimen_type_arr[i]+nurse_collect_arr[i]+start_date_arr[i]+frequency_arr[i]+duration_value_arr[i]+performing_dept_arr[i]+split_grouping;
 			if(grouping.equals(tree_grouping) )
			{
%>
			<tr>
					<td class='BODYCOLORFILLED'  width='auto' nowrap><%=count++%>
					</td>
					<td class='BODYCOLORFILLED'  width='auto' nowrap><%=catalog_desc_arr[i]%>
					</td>
					<td class='BODYCOLORFILLED'  width='auto' nowrap><%=priority_desc_arr[i]%>
					</td>
					<td class='BODYCOLORFILLED'  width='auto' nowrap><%=start_date_arr[i]%>
					</td>
					<td class='BODYCOLORFILLED'  width='auto' nowrap><%=end_date_time_arr[i]%></td>
				</tr>
<%				if(!frequency_arr[i].equals("")) { %>				
				<tr>
					<td class='BODYCOLORFILLED'  width='auto' nowrap><b><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/> </b></td>
						<td class='BODYCOLORFILLED'  width='auto' colspan=2><%=frequency_desc_arr[i]%>
						</td>
					<td class='BODYCOLORFILLED' colspan=2  width='auto'>
<%					if(!duration_value_arr[i].equals("")) { 
						out.println(duration_value_arr[i]);
					}	%>								
<%					if(!duration_desc_arr[i].equals("")) { 
						out.println(duration_desc_arr[i]);
					} %>					
					</td>
				</tr>		
<%				} %>						
<%				if(!line_comment_arr[i].equals("")) {  %>					
				<tr>
					<td class='BODYCOLORFILLED'  width='auto' nowrap><b><fmt:message key="eOR.CatalogComments.label" bundle="${or_labels}"/></b>
					</td>
						<!--IN064543 start-->
					<%if("T".equals(instrn_content_type[i])){ %>
						<td class='BODYCOLORFILLED' colspan=4 width='auto'><%=line_comment_arr[i]%></td>
					<%}else if("E".equals(instrn_content_type[i])){ %>
						<td name="cat_<%=cnt%>" class='BODYCOLORFILLED' colspan=4 width='auto'><a class="IMAGELINK" href="javascript:showPreviewEditorInstrn('<%=bean_id%>','<%=bean_name%>','<%=catalog_code_arr[i]%>','<%=catalog_desc_arr[i]%>')"><b>View</b></a></td><!--IN068445-->
					<%}
					} %>
						<!--IN064543 end-->					
				</tr>
				<tr><td colspan=5 class='BODYCOLORFILLED'></td></tr>
<%  
			cnt++;//IN068445
		} // End of if grouping	
	 }	%>
		</table>
		<tr><td colspan=5 class='BODYCOLORFILLED'><hr style='color=black' size='1'></td></tr>
		<br><br><br><br>
	</table>
	<!--IN068445 START-->
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<!--IN068445 END-->		
<%	} // End of while itr_map
} //  End of count_patient
	Nationality		= null;		// Nullifying the objects
	PatientDtls		= null;
	template		= null;
	hash_map		= null;
	sorted_set 		= null;
	itr_map 		= null;
	arrSeqNo 		= null;		// Nullifying the objects
	multi_patient	= null;
	sorted_group	= null;
	hash_map		= null;
	//comments.setLength(0);	

	// no need to set it back persistence
	//putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id,bean,request);	//IN068445
%>	
</body>
</html>

