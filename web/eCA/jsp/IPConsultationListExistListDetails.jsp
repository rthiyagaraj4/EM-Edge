<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
18/11/2011    IN29413    Dinesh T     ARTEMIS - Added the new method
21/08/2011    IN034688	Dinesh T		Handling the billing related issue, while trying to charge consultation for more patients, charges were not posting to the billing tables
-----------------------------------------------------------------------------------------------
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
		<title></title>

	<%
		  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		  String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p1.getProperty("LOCALE");
		//String bill_facility_id		=	(String) session.getValue("facility_id");

		eCA.IPConsultationListBean ipConsultListBean = null;

		//eOR.OrderEntryBillingQueryBean billingbean = null;
		

		//String queryString = request.getQueryString();


	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script Language="JavaScript" src='../../eCA/js/IPConsultationList.js'></script>
			<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head> 
 <%
	
		Connection con = null;
		con =  ConnectionManager.getConnection(request);
		PreparedStatement stmt=null;
		PreparedStatement pstmt=null;
		//PreparedStatement stHist=null;
		ResultSet rs=null;
		ResultSet prs=null;
		int i=0;
		//int rowCnt = 0;
		String classValue ="";
		String pline ="";
		String rsAdmission_date_time ="";
		String cons_ref_id ="";
		String status ="";
		String catalog ="";
		String checked ="";
		String bean_key ="";
		String practitionerId ="";
		String cons_date ="";
		String cons_time ="";
		String create_type ="";


		String patient_id ="";
		String encounter_id ="";
		String rsSpecialty_code ="";
		String rsSpecialty_desc ="";
		String rsLocation_code ="";
		String arrVal ="";
		String cons_status ="";
		boolean flag = true;
		
		ArrayList BillChargeInfo = null;
		HashMap setBills_dtls			= null;
		HashMap bill_dtls				= null;
		String[] billing_details = null;
		double toatal_amt = 0.0;
		double toatal_pat_payable = 0.0;
		double toatal_pat_paid = 0.0;
		String aproval_reqd ="";
		String className1 ="";
	
		String quantity ="1";
		String orderId ="";
		String order_line_no ="";
		String patient_class ="IP";
		String p_patient_class ="";
		String chk_dis ="";
		String key_line_no ="";
		String  service_panel_code="";
		String  service_panel_ind="";
		String  episode_type="";
		String  visit_id="";
		String  episode_id="";
		String consult_date_time="";
		String consult_date="";
		String error_text="";
		String display="";
		String p_episode_id="";
		String source_type="";
		String source_code="";
		String episode_visit_num="";
		String display_admission_date="";
		String displaytooltip="";
		String order_id="";
		String order_line_num="";
		String billed_yn="";
		String cancelled_by="";
		String cancelled_date="";

		String	lower_limit				=	"";	
		String	upper_limit				=	"";
		String max_regular_cons ="";
		String max_referral_cons ="";
		String tool_tip ="";
		String consParamQuery ="";
		String control_value ="";
		String completed_date ="";

		StringBuffer query_string		=	new StringBuffer();
		ArrayList selectedList =new ArrayList();

		int		rowCnt					=	0,		maxRecordsDisp		=	7;
		int		startIndex				=	0,		endIndex			=	0;
		int		totalRecordCount		=	0;//,		colIndex			=	0;
		//int		sec_count				=	0;
		int totChecked=0;//IN29413
		int totDisabled=0;//IN29413

		//String display_admission_date = com.ehis.util.DateUtils.convertDate(rsAdmission_date_time,"DMYHM","en",locale);

		StringBuffer  existListQry = new StringBuffer();
		
		cons_ref_id			=	(request.getParameter("cons_ref_id")==null)	?	""	:	request.getParameter("cons_ref_id");
		status			=	(request.getParameter("status")==null)	?	""	:	request.getParameter("status");
		catalog			=	(request.getParameter("catalog")==null)	?	""	:	request.getParameter("catalog");
		practitionerId			=	(request.getParameter("practitionerId")==null)	?	""	:	request.getParameter("practitionerId");
		cons_date			=	(request.getParameter("cons_date")==null)	?	""	:	request.getParameter("cons_date");
		cons_time			=	(request.getParameter("cons_time")==null)	?	""	:	request.getParameter("cons_time");
		create_type			=	(request.getParameter("create_type")==null)	?	""	:	request.getParameter("create_type");
		consult_date_time=cons_date+" "+cons_time;

		lower_limit			=	(request.getParameter("lower_limit")==null)	?	"1"					:	request.getParameter("lower_limit");
		upper_limit			=	(request.getParameter("upper_limit")==null)	?	(""+maxRecordsDisp)	:	request.getParameter("upper_limit");
		//if(consult_date_time.length()!=16)
		//{
			try
			{
				consParamQuery = "select MAX_REGULAR_CONS MAX_REGULAR_CONS, MAX_REFERRAL_CONS MAX_REFERRAL_CONS,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date from ca_cons_param ";
				
				pstmt = con.prepareStatement(consParamQuery);
				prs = pstmt.executeQuery();
				while(prs.next())
				{
					consult_date=prs.getString("sys_date");
					max_regular_cons = prs.getString("MAX_REGULAR_CONS");
					max_referral_cons = prs.getString("MAX_REFERRAL_CONS");
				}
				if(prs!=null) prs.close();
				if(pstmt!=null)pstmt.close();
			}
			catch(Exception Se)
			{
				System.err.println(Se);
				Se.printStackTrace();
			}
		//}	
		if(!locale.equals("en"))
		{
			consult_date_time=com.ehis.util.DateUtils.convertDate(consult_date_time,"DMYHM",locale,"en");
			consult_date=com.ehis.util.DateUtils.convertDate(consult_date,"DMYHM","en",locale);
		}
		startIndex		=	Integer.parseInt(lower_limit);
		endIndex		=	Integer.parseInt(upper_limit);

		query_string.append("cons_ref_id=");		query_string.append(cons_ref_id);
		query_string.append("&status=");		query_string.append(status);
		query_string.append("&practitionerId=");		query_string.append(practitionerId);
		query_string.append("&cons_date=");		query_string.append(cons_date);
		query_string.append("&cons_time=");		query_string.append(cons_time);
		query_string.append("&create_type=");		query_string.append(create_type);
		query_string.append("&catalog=");		query_string.append(catalog);
		

		bean_key =practitionerId+cons_date+cons_time;

		ipConsultListBean = (eCA.IPConsultationListBean)getObjectFromBean("ipConsultListBeanUpd"+bean_key,"eCA.IPConsultationListBean",session);
		//ipConsultListBean.clearBean();

		selectedList =	ipConsultListBean.returnConsList();



		String bean_id = "Or_FutureOrder" ;
		String bean_name = "eOR.FutureOrder";
		
		eOR.FutureOrder bean = (eOR.FutureOrder)getBeanObject( bean_id, bean_name, request  ) ;
		/*
		eOR.OrderEntryBillingQueryBean billingbean				= (eOR.OrderEntryBillingQueryBean)getBeanObject( "Or_BillingQry", "eOR.OrderEntryBillingQueryBean", request ) ;

		bean.setOrderEntryBillBean(billingbean); */

		 eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) bean.getOrderEntryBillBean(); 
		 
				
%>

	<body onload="loadButtons()" onKeyDown="lockKey()">
		<form name='IPConsultationListExistListDetailsForm' id='IPConsultationListExistListDetailsForm' method='post' target='messageFrame' action='../../servlet/eCA.IPConsultationListServlet'>
		

<%

		//existListQry.append( "select e.PATIENT_ID,e.ENCOUNTER_ID, get_patient.get_line_detail(d.PATIENT_ID,?) Pline,to_char(e.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI') ADMISSION_DATE_TIME,e.SPECIALTY_CODE,am_get_desc.AM_SPECIALITY(e.SPECIALTY_CODE,'en',2) SPECIALTY_DESC,e.NURSING_UNIT_CODE,d.CONS_STATUS,a.patient_class p_patient_class,a.episode_id p_episode_id,a.PAT_CURR_LOCN_TYPE source_type,a.PAT_CURR_LOCN_CODE source_code,a.OP_EPISODE_VISIT_NUM episode_visit_num,d.order_id order_id,d.line_no order_line_num,cancelled_by_user_id  cancelled_by,cancelled_date cancelled_date,CA_GET_CONS_CHRG_CONTROL(?,e.FACILITY_ID,e.ENCOUNTER_ID,?,?) control_val,to_char(COMPLETED_DATE,'DD/MM/YYYY') COMPLETED_DATE   from  CA_CONS_LIST_DTL d,IP_OPEN_ENCOUNTER e,pr_encounter a  where d.CONS_REF_ID = ? and d.PATIENT_ID=e.PATIENT_ID and d.ENCOUNTER_ID =e.ENCOUNTER_ID and d.FACILITY_ID =e.FACILITY_ID and a.facility_id=d.facility_id and a.patient_id=d.patient_id and  a.encounter_id=d.encounter_id");//CHANGES INCLUDED FOR GET ACCESS RULE
		existListQry.append( "select e.PATIENT_ID,e.ENCOUNTER_ID, get_patient.get_line_detail(d.PATIENT_ID,?) Pline,to_char(e.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI') ADMISSION_DATE_TIME,e.SPECIALTY_CODE,am_get_desc.AM_SPECIALITY(e.SPECIALTY_CODE,'en',2) SPECIALTY_DESC,e.NURSING_UNIT_CODE,d.CONS_STATUS,a.patient_class p_patient_class,a.episode_id p_episode_id,a.PAT_CURR_LOCN_TYPE source_type,a.PAT_CURR_LOCN_CODE source_code,a.OP_EPISODE_VISIT_NUM episode_visit_num,d.order_id order_id,d.line_no order_line_num,cancelled_by_user_id  cancelled_by,cancelled_date cancelled_date,CA_GET_CONS_CHRG_CONTROL(?,e.FACILITY_ID,e.ENCOUNTER_ID,?,?) control_val,to_char(COMPLETED_DATE,'DD/MM/YYYY') COMPLETED_DATE   from  CA_CONS_LIST_DTL d,IP_OPEN_ENCOUNTER e,pr_encounter a  where d.CONS_REF_ID = ? and d.PATIENT_ID=e.PATIENT_ID and d.ENCOUNTER_ID =e.ENCOUNTER_ID and d.FACILITY_ID =e.FACILITY_ID and a.facility_id=d.facility_id and a.patient_id=d.patient_id and  a.encounter_id=d.encounter_id AND 'Y' = OR_GET_ACCESS_RULE(e.facility_id,E.encounter_id,'CN',E.patient_class,to_char(E.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI'),     (select to_char(DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI') from pr_encounter where facility_id = E.facility_id and encounter_id = E.encounter_id),(SELECT to_char(DIS_ADV_DATE_TIME,'DD/MM/YYYY HH24:MI') FROM IP_DISCHARGE_ADVICE WHERE FACILITY_ID=E.FACILITY_ID    and ENCOUNTER_ID=E.encounter_id AND DIS_ADV_STATUS in('0','1') and rownum <=1))");//CHANGES INCLUDED FOR GET ACCESS RULE
		if(!status.equals("A"))
		{
		existListQry.append( " and d.CONS_STATUS = ?");
		}
		try
		{
			stmt = con.prepareStatement(existListQry.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setString(1,locale);
			stmt.setString(2,practitionerId);
	                stmt.setString(3,max_regular_cons);
			stmt.setString(4,max_referral_cons);
			stmt.setString(5,cons_ref_id);			
                       if(!status.equals("A"))
			{
				stmt.setString(6,status);
			}

			rs = stmt.executeQuery();

			rs.last();
			totalRecordCount	=	rs.getRow();
			rs.beforeFirst();
	if( totalRecordCount>maxRecordsDisp)
		{
	%>
		<table  class='grid' WIDTH='100%'>
		<tr><td CLASS='BODYCOLORFILLED' >&nbsp;</td>	
	<%
		if(startIndex>maxRecordsDisp)
		{
	%>
			<td class='LABEL'  width='8%'><a href="../../eCA/jsp/IPConsultationListExistListDetails.jsp?lower_limit=<%=(startIndex-maxRecordsDisp)%>&upper_limit=<%=(endIndex-maxRecordsDisp)%>&<%=query_string.toString()%>" style="text-decoration:none;  font-weight:bold"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
	<%
		}
		if(totalRecordCount>endIndex)
		{
	%>
			<td class='LABEL' align='center' width='8%'><a href="../../eCA/jsp/IPConsultationListExistListDetails.jsp?lower_limit=<%=(startIndex+maxRecordsDisp)%>&upper_limit=<%=(endIndex+maxRecordsDisp)%>&<%=query_string.toString()%>" style="text-decoration:none; font-weight:bold"><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
	<%
		}
	%>
		</tr></table>
	<%
		}
	%>
	<table class='grid' width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
		<tr>
			<th class='columnheadercenter' align='left'><fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/><input type='checkbox' name='existSelAll' id='existSelAll' id='existSelAll' onclick='existSelectAll()'></th><!--IN29413-->
			<th class='columnheadercenter' align='left'><fmt:message key='Common.PatientDetails.label' bundle='${common_labels}'/></th>
			<th class='columnheadercenter' width='15%' align='left'><fmt:message key='Common.admissiondate.label' bundle='${common_labels}'/></th>
			<th class='columnheadercenter' colspan='5' align='left' ><fmt:message key='eCA.ChargeApplicable.label' bundle='${ca_labels}'/></th>
			<th class='columnheadercenter' align='left'>&nbsp;</th>
		</tr>
		
		<%
		if(startIndex>1)
			rs.absolute((startIndex-1));	
		classValue = "gridData";
		while(rs.next())
		{
			String displaytooltipi="";
			/*if(i % 2 == 0) classValue = "QRYEVEN";
			else classValue = "QRYODD";	*/

			rowCnt++;
			flag = false ;

						
			patient_id = rs.getString("PATIENT_ID")==null?"":rs.getString("PATIENT_ID");
			encounter_id = rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
			pline = rs.getString("Pline")==null?"":rs.getString("Pline");
			pline =pline.replaceAll("\\|",",");
			rsAdmission_date_time = rs.getString("ADMISSION_DATE_TIME")==null?"":rs.getString("ADMISSION_DATE_TIME");
			rsSpecialty_code = rs.getString("SPECIALTY_CODE")==null?"":rs.getString("SPECIALTY_CODE");
			rsSpecialty_desc = rs.getString("SPECIALTY_DESC")==null?"":rs.getString("SPECIALTY_DESC");
			rsLocation_code = rs.getString("NURSING_UNIT_CODE")==null?"":rs.getString("NURSING_UNIT_CODE");
			cons_status = rs.getString("CONS_STATUS")==null?"":rs.getString("CONS_STATUS");
			p_patient_class = rs.getString("p_patient_class")==null?"":rs.getString("p_patient_class");
			p_episode_id = rs.getString("p_episode_id")==null?"":rs.getString("p_episode_id");
			source_type = rs.getString("source_type")==null?"":rs.getString("source_type");
			source_code = rs.getString("source_code")==null?"":rs.getString("source_code");
			episode_visit_num = rs.getString("episode_visit_num")==null?"0":rs.getString("episode_visit_num");
			order_id = rs.getString("order_id")==null?"":rs.getString("order_id");
			order_line_num = rs.getString("order_line_num")==null?"":rs.getString("order_line_num");
			cancelled_by = rs.getString("cancelled_by")==null?"":rs.getString("cancelled_by");
			cancelled_date = rs.getString("cancelled_date")==null?"":rs.getString("cancelled_date");
			control_value = rs.getString("control_val")==null?"":rs.getString("control_val");
			completed_date = rs.getString("COMPLETED_DATE")==null?"":rs.getString("COMPLETED_DATE");
			if(!locale.equals("en"))
			{
				completed_date = com.ehis.util.DateUtils.convertDate(completed_date,"DMY","en",locale);
			}

			//arrVal = rsLocation_code+"~"+pline+"~"+rsAdmission_date_time+"~"+rsSpecialty_code+"~"+patient_id+"~"+encounter_id;

			arrVal = cons_ref_id+"~"+patient_id+"~"+encounter_id+"~"+consult_date_time+"~"+catalog+"~"+p_patient_class+"~"+p_episode_id+"~"+episode_visit_num+"~"+practitionerId+"~"+source_code+"~"+source_type;



			if(selectedList.contains(arrVal))
			{
				checked ="checked";
				totChecked++;//IN29413
			}
			else
			{
				checked ="";
			}


			/*if(cons_status.equals("P"))
			{
				if(!ipConsultListBean.returnConsList().contains(arrVal))
				{
					ipConsultListBean.addtoConsList(arrVal);
				}
			} */
			if(cons_status.equals("C"))
			{	
				className1="DISCHARGED";
				tool_tip="";
				
				if(status.equalsIgnoreCase("C"))
				{
					//billed_yn=ipConsultListBean.Bill_yn(bill_facility_id,order_id,order_line_num);
					billed_yn="N";
					if(billed_yn.equalsIgnoreCase("Y"))
					{
						chk_dis ="disabled";
						totDisabled++;//IN29413
					}
					else
					{
						if(!(cancelled_by.equals("")&&cancelled_date.equals("")))
						{
							chk_dis="disabled";
							totDisabled++;//IN29413
						}
						else
						{
							//if(cons_date.equals(consult_date.substring(0,10)))
							if(completed_date.equals(consult_date.substring(0,10)))
							{
								chk_dis="";
								
							}
							else
							{
								chk_dis="disabled";totDisabled++;//IN29413
							}
						}
					}
				}
				else
				{
					chk_dis="disabled";
					totDisabled++;//IN29413
				}

			}
			else
			{
				
				if(!control_value.equals(""))
				{
					chk_dis = "disabled";
					totDisabled++;//IN29413
					className1 = classValue;
					tool_tip="";

					if(control_value.equals("REGLR"))
					{
						tool_tip=bean.getMessage(localeName,"MAX_REG_CONS_EXCEED","CA");
						//tool_tip="Maximum No: of regular Consultation is over...";
					}
					if(control_value.equals("REFRL"))
					{
						tool_tip=bean.getMessage(localeName,"MAX_REF_CONS_EXCEED","CA");
						//tool_tip="Maximum No: of Referral Consultation is over...";
					}

				}
				else
				{
				totDisabled++;//IN29413
				className1 =classValue;
				chk_dis ="";
					tool_tip="";
				}
			}
	
	bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(patient_id+encounter_id+catalog);

	if(bill_dtls!=null)//Taken from the bean once the charging is done 
	{
				toatal_amt=Double.parseDouble(checkForNull((String)bill_dtls.get("total_payable"),"0.0"));
				toatal_pat_payable=Double.parseDouble(checkForNull((String)bill_dtls.get("patient_payable"),"0.0"));
				aproval_reqd=checkForNull((String)bill_dtls.get("preapp_yn"),"No");
				if(aproval_reqd.equals(""))
					aproval_reqd="No";
				if(aproval_reqd.equalsIgnoreCase("N"))
				{
					aproval_reqd="No";
				}
				else if(aproval_reqd.equalsIgnoreCase("Y"))
				{
					aproval_reqd="Yes";
				}

				service_panel_code  = checkForNull((String)bill_dtls.get("serv_panel_code"),"");
				service_panel_ind     = checkForNull((String)bill_dtls.get("serv_panel_ind"),"");
				episode_type             =checkForNull((String)bill_dtls.get("p_episode_type"),"");
				visit_id					  =checkForNull((String)bill_dtls.get("p_visit_id"),"");
				episode_id                =checkForNull((String)bill_dtls.get("p_episode_id"),"");
				error_text                  =(String)bill_dtls.get("error_text");
				
				if(!error_text.equals(""))
				{
				%>
					<script>
						//alert("<%=error_text%>");
					</script>
				<%
					display="disabled";
					displaytooltipi=error_text;
				}
				else if(service_panel_code.equals("")&&service_panel_ind.equals(""))
				{
					%>
					<script>
							var msg=getMessage("BILLING_SERVICE_NOT_DEFINED","OR");
							msg=msg.replace('{1}',"<%=catalog%>");
							alert(msg);
					</script>
					<%
					display="disabled";
					displaytooltipi=bean.getMessage(localeName,"BILLING_SERVICE_NOT_DEFINED","OR");
					displaytooltipi=displaytooltipi.replace("{1}",catalog);
				}
				else
				{
					display="";
				}
	
	}
	else//Value is from the Database
	 {
	BillChargeInfo = orderEntryBillBean.getBillChargeDetails(quantity,catalog,consult_date_time, locale, order_id, order_line_num,patient_id,encounter_id,patient_class,practitionerId) ;
		//BillChargeInfo = orderEntryBillBean.getBillChargeDetails(quantity,catalog,consult_date_time, locale, orderId, order_line_no,patient_id,encounter_id,patient_class,practitionerId) ; by rajan on 13/10/2008
		//getBillChargeDetails(String quantity,String catalog_code,String start_date_time,String language_id,String order_id,String order_line_no,String patient_id, String encounter_id,String patient_class,String practitioner_id)

		
		if(BillChargeInfo!=null)
		{


			for( int k=0 ; k< BillChargeInfo.size() ; k++ ) 
			{
				billing_details 	= (String[])BillChargeInfo.get(k);

					
				setBills_dtls		= new HashMap();

				setBills_dtls.put("charged_yn"       , billing_details[1]);
				setBills_dtls.put("total_payable"    , billing_details[2]);
				setBills_dtls.put("patient_payable"  , billing_details[3]);
				setBills_dtls.put("quantity"         , "1");
				setBills_dtls.put("incl_excl_action" , billing_details[4]);
				setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
				setBills_dtls.put("preapp_yn"        , billing_details[5]);
				setBills_dtls.put("patient_paid_amt" , billing_details[6]);
				setBills_dtls.put("bl_panel_str"     , billing_details[0]);
				setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
				setBills_dtls.put("serv_panel_code"  , billing_details[11]);
				setBills_dtls.put("p_episode_type"	 , billing_details[13]);
				setBills_dtls.put("p_episode_id"	 , billing_details[14]);
				setBills_dtls.put("p_visit_id"		 , billing_details[15]);
				setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
				setBills_dtls.put("error_text"		 , billing_details[9]);
			
				
				orderEntryBillBean.setOrderBillDtls(patient_id+encounter_id+catalog, setBills_dtls); 
				

				bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(patient_id+encounter_id+catalog);
				toatal_amt=Double.parseDouble(checkForNull((String)bill_dtls.get("total_payable"),"0.0"));
				toatal_pat_payable=Double.parseDouble(checkForNull((String)bill_dtls.get("patient_payable"),"0.0"));
				aproval_reqd=checkForNull((String)bill_dtls.get("preapp_yn"),"No");
				if(aproval_reqd.equals(""))
					aproval_reqd="No";
				if(aproval_reqd.equalsIgnoreCase("N"))
				{
					aproval_reqd="No";
				}
				else if(aproval_reqd.equalsIgnoreCase("Y"))
				{
					aproval_reqd="Yes";
				}

				service_panel_code  = checkForNull((String)bill_dtls.get("serv_panel_code"),"");
				service_panel_ind     = checkForNull((String)bill_dtls.get("serv_panel_ind"),"");
				episode_type             =checkForNull((String)bill_dtls.get("p_episode_type"),"");
				visit_id					  =checkForNull((String)bill_dtls.get("p_visit_id"),"");
				episode_id                =checkForNull((String)bill_dtls.get("p_episode_id"),"");
				error_text                  =(String)bill_dtls.get("error_text");
				
				if(!error_text.equals(""))
				{
				%>
					<script>
						//alert("<%=error_text%>");
					</script>
				<%
					display="disabled";
				
					displaytooltipi=error_text;
				}
				else if(service_panel_code.equals("")&&service_panel_ind.equals(""))
				{
					%>
					<script>
							var msg=getMessage("BILLING_SERVICE_NOT_DEFINED","OR");
							msg=msg.replace('{1}',"<%=catalog%>");
							alert(msg);
					</script>
					<%
					display="disabled";
					displaytooltipi=bean.getMessage(localeName,"BILLING_SERVICE_NOT_DEFINED","OR");
					displaytooltipi=displaytooltipi.replace("{1}",catalog);
				}
				else
				{
					display="";
				}
			/*


				toatal_amt =toatal_amt+ Double.parseDouble(checkForNull(billing_details[2],"0.0"));
				//toatal_amt += Double.parseDouble(bean.checkForNull(billing_details[2],"0.0"));
				toatal_pat_payable =toatal_pat_payable+ Double.parseDouble(checkForNull(billing_details[3],"0.0"));
				//toatal_pat_payable += Double.parseDouble(bean.checkForNull(billing_details[3],"0.0"));
				toatal_pat_paid =toatal_pat_paid+ Double.parseDouble(checkForNull(billing_details[6],"0.0"));
				//toatal_pat_paid += Double.parseDouble(bean.checkForNull(billing_details[6],"0.0"));

				aproval_reqd = (String)checkForNull(billing_details[5],"No");
				
				service_panel_code = (String)checkForNull(billing_details[11],"");
				service_panel_ind = (String)checkForNull(billing_details[10],"");
				episode_type = (String)checkForNull(billing_details[13],"");
				visit_id = (String)checkForNull(billing_details[15],"");
				episode_id = (String)checkForNull(billing_details[14],"");*/

			}
		}
	}
	





		display_admission_date = com.ehis.util.DateUtils.convertDate(rsAdmission_date_time,"DMYHM","en",locale);
		out.println("<tr id='rowid"+i+"'>");
		if(status.equalsIgnoreCase("C"))
		{
			out.println("<td class='"+classValue+"' rowspan='2' id='chk"+i+"'><input id='consultChk"+i+"' name='consultChk"+i+"' id='consultChk"+i+"' type='checkbox' onClick=\"addToCancelList(this,"+rowCnt+",'"+patient_id+"','"+encounter_id+"','"+consult_date_time+"','"+catalog+"','"+p_patient_class+"','"+p_episode_id+"','"+episode_visit_num+"','"+practitionerId+"','"+source_code+"','"+source_type+"','"+order_id+"','"+order_line_num+"');\""+checked+" "+chk_dis+" "+display+" ></td>");//IN29413
		}
		else
		{
			out.println("<td class='"+classValue+"' rowspan='2' id='chk"+i+"'><input name='consultChk"+i+"' id='consultChk"+i+"' id='consultChk"+i+"' type='checkbox' onClick=\"addToList1(this,"+rowCnt+",'"+patient_id+"','"+encounter_id+"','"+consult_date_time+"','"+catalog+"','"+p_patient_class+"','"+p_episode_id+"','"+episode_visit_num+"','"+practitionerId+"','"+source_code+"','"+source_type+"');\""+checked+" "+chk_dis+" "+display+" title='"+tool_tip+"'></td>");//IN29413
		}
		out.println("<td class='"+classValue+"' rowspan='2' id='pline"+i+"' title='"+displaytooltipi+"' wrap width='30%'>"+pline+"</td>");
		out.println("<td class='"+classValue+"' rowspan='2' id='admdate"+i+"' width='15%'>"+display_admission_date+"</td>");
		out.println("<td class='"+classValue+"' id='space"+i+"'>&nbsp;</td><td class='"+classValue+"' id='totalamt"+i+"' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.total.label","common_labels")+"</td><td class='"+classValue+"' id='patientamt"+i+"' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</td><td class='"+classValue+"' id='apprreqd"+i+"' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ApprovalReqd.label","or_labels")+"</td><td class='"+classValue+"' id='vespace"+i+"'>&nbsp;</td> ");
		out.println("<td class='"+classValue+"' ></td>");		
		out.println("</tr>");
		out.println("<tr><td class='"+classValue+"' id='charges"+i+"'> <b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Charges.label","ca_labels")+":</b></td><td class='"+classValue+"' id='total_amt_lab"+i+"'>"+toatal_amt+"</td><input type='hidden' name='total_amt_val"+i+"' id='total_amt_val"+i+"' id='total_amt_val"+i+"' value='"+toatal_amt+"'><td class='"+classValue+"' id='toatal_pat_payable_lab"+i+"'> "+toatal_pat_payable+"</td><input type='hidden' name='toatal_pat_payable_val"+i+"' id='toatal_pat_payable_val"+i+"' id='toatal_pat_payable_val"+i+"' value='"+toatal_pat_payable+"'><td class='"+classValue+"' id='aproval_reqd_lab"+i+"' > "+aproval_reqd+"</td><input type='hidden' name='aproval_reqd_val"+i+"' id='aproval_reqd_val"+i+"' id='aproval_reqd_val"+i+"'  value='"+aproval_reqd+"'>");
		if(error_text.equals("")&&(!(service_panel_code.equals("")))&&(!(service_panel_ind.equals("")))&&!(cons_status.equals("C"))&&(chk_dis.equals("")))
		{
			out.println("<td class='"+classValue+"'> <a class='gridLink' href=\"javascript:callReviseBilling('"+i+"','"+patient_id+"','"+encounter_id+"','"+catalog+"','"+service_panel_code+"','"+service_panel_ind+"','"+consult_date_time+"','"+episode_type+"','"+visit_id+"','"+episode_id+"','"+practitionerId+"','"+key_line_no+"','"+orderId+"','"+order_line_no+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.View/Edit.label","or_labels")+"</a> </td><td class='"+className1+"' width='6' align='center' ></td></tr>");
		}
		else
		{
			out.println("<td class='"+classValue+"' id='viewedit"+i+"'></td><td class='"+className1+"' width='6' align='center' ></td></tr>");
		}
		if(!error_text.equals("")||service_panel_code.equals("")||service_panel_ind.equals(""))
		{
		%>
		<script>
			displayrecord("<%=i%>");
		</script>
		<%
		}
		%>
		<input type="hidden" name="explanatory_text<%=i%>" id="explanatory_text<%=i%>" value="<%=displaytooltip%>">
		<%
		i++;

		 toatal_amt = 0.0;
		 toatal_pat_payable = 0.0;
		 toatal_pat_paid = 0.0;
		
			if(rowCnt>=maxRecordsDisp) break;
		
		}
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();	

		putObjectInBean("ipConsultListBeanUpd"+bean_key,ipConsultListBean,session);
		putObjectInBean(bean_id,bean,request);
				
		
		}

		catch(Exception e)
		{
			e.printStackTrace(System.err);
			
			//ConnectionManager.returnConnection(con,request);
		}
		finally 
		{
		
			ConnectionManager.returnConnection(con,request);
		}
		if(flag)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			out.println("<script> setTimeout('disButtons();','50');</script>");
			
		}



%>
		<input type='hidden' name='bean_key' id='bean_key' value="<%=bean_key%>">
		<input type='hidden' name='create_type' id='create_type' value="<%=create_type%>">
		<input type='hidden' name='cons_date' id='cons_date' value="<%=cons_date%>">
		<input type='hidden' name='cons_time' id='cons_time' value="<%=cons_time%>">
		<input type='hidden' name='practitionerId' id='practitionerId' value="<%=practitionerId%>">
		<input type='hidden' name='cons_ref_id' id='cons_ref_id' value="<%=cons_ref_id%>">
		<input type='hidden' name='consultCnt' id='consultCnt' value="<%=rowCnt%>"><!--IN29413-->
		<input type='hidden' name='status' id='status' value="<%=status%>">
		<%if(status.equalsIgnoreCase("C")){%>
		<input type='hidden' name='servMode' id='servMode' value="cancel">
		<%}else{%>
		<input type='hidden' name='servMode' id='servMode' value="update">
		<%}%>
		<input type='hidden' name='totChecked' id='totChecked' value='<%=totChecked%>'><!--IN29413-->
		<input type='hidden' name='totDisabled' id='totDisabled' value='<%=totDisabled%>'><!--IN29413-->
		</form>
		<script>
		//IN29413,starts
		var totDisabled=0;
		for(i=0;i<document.getElementById("consultCnt").value;i++)  
		{
			var clicker = document.getElementById('consultChk'+i);
			
			if(clicker.disabled == true)
			{
				totDisabled=totDisabled+1;
			}
		}
		document.getElementById("totDisabled").value=totDisabled;
		//alert(parseInt(document.getElementById("consultCnt").value)+" "+parseInt(document.getElementById("totChecked").value));
		if(parseInt(document.getElementById("totDisabled").value)==parseInt(document.getElementById("consultCnt").value))
		{
			document.getElementById("existSelAll").checked='';
			document.getElementById("existSelAll").value='N';
		}
		else
		{
			if(parseInt(document.getElementById("consultCnt").value)==parseInt(document.getElementById("totChecked").value)+parseInt(document.getElementById("totDisabled").value))
			{
				document.getElementById("existSelAll").checked='checked';
				document.getElementById("existSelAll").value='Y';
			}
		}

		if(parent.IPConsultationListToolbarFrame.document.getElementById("ChargeCons")!=null)//IN034688
			parent.IPConsultationListToolbarFrame.document.getElementById("ChargeCons").disabled=false;//IN034688
		//IN29413,ends
		</script>
  </body>
</html>

<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return ( inputString==null || inputString.equals("") )	?	defaultValue	:	inputString;
	}
%>

