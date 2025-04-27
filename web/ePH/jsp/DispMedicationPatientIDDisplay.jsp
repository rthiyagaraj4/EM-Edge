<!DOCTYPE html>
<!--
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
04/17/2017      KDAH-CRF-0338     Devindra/Mukesh    Inclusion of Bed No in the Fill and Deliver screen in Dispense Medication.
09/01/2017		IN:065140			Mukesh M		 Internal issue related to GHL-CRF-0453	
01/10/2021		TFS-23793         Prabha 			 ML-MMOH-SCF-1904
11/10/2023		40147			  Sushant Tambe		 MMS-DM-CRF-0228
---------------------------------------------------------------------------------------------------------------
*/ -->
<%-- JSP Page specific attributes start --%>
<!-- Modified for ML-MMOH-CRF-0532 [IN061327] -->
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<head>
		<SCRIPT LANGUAGE="JavaScript">
			/*function blinkImage(){ //Commented for ML-BRU-SCF-1144[IN045159] - start
				var e;
				var count=0;
				try{
					count = document.frmDispMedicationPatientIDDisplay.tot_rec.value;
				}
				catch(e){}

				for(var i=0;i<count;i++){
					try{
						e = document.getElementById("appt_list_"+i);//eval("document.getElementById("appt_list_")"+i);//
						if(e.style.display=='inline'){
							e.style.visibility = ( e.style.visibility == 'visible' )? 'hidden' : 'visible';
						}
					}
					catch(e){}
				}
			}
			window.onload = function(){
				window.setInterval("blinkImage()",500);
			}*/ //Commented for ML-BRU-SCF-1144[IN045159] - End
		</SCRIPT>
<% Connection con				= null;
	try{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String login_user	=	(String)session.getValue("login_user");
		//String facility_id		=	(String)session.getValue("facility_id");//Commented for Checkstyle
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePH/js/DispMedication.js"></script>
		<script language="javascript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>	
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	</head>
	<body onMouseDown="" onKeyDown="lockKey()" onLoad="clickPatient()"><!--added onload for Bru-HIMS-CRF-416[IN045566] -->
		<form name="frmDispMedicationPatientIDDisplay" id="frmDispMedicationPatientIDDisplay">
<%
			
			String sUrgentTitle = SpringCacheBean.getLabel(pageContext,"ePH.UrgentOrderExists.label","ph_labels.resources.Labels");
			sUrgentTitle		= sUrgentTitle ==null?"":sUrgentTitle;
			int ptindex = 0;//added for Bru-HIMS-CRF-416[IN045566]
			String bean_id			= "DispMedicationBean" ;
			String bean_name		= "ePH.DispMedicationBean";	
			DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
			bean.setLanguageId(locale);
			String	bean_id_2		=	"DispMedicationAllStages" ;
			String	bean_name_2		=	"ePH.DispMedicationAllStages";
			DispMedicationAllStages bean_2	= (DispMedicationAllStages)getBeanObject( bean_id_2, bean_name_2, request);
			String sort_token_series_ind     =   bean.getSortTokenSeriesInd(); //Added for HSA-CRF-0136 [IN:048412]
			String gender			=	null;
			String sOrderType		= bean.getCriteriaOrderType()==null?"":bean.getCriteriaOrderType();
			String from				= CommonBean.checkForNull(request.getParameter("from"));
			String to				= CommonBean.checkForNull(request.getParameter("to"));
			String sPriorityImg		= "&nbsp;";
			String dispname="";
			String desp_name_code_loc="";
			String desp_name_code="";
			boolean newaeheader=false;
		//if(!from.equals("") && !to.equals(""))
			//bean.setPatientID("");
			String tab_based_group_sort_disp	 = bean.getTabBasegGroupSortDisp();
			String customGroupBy	 = bean.getCustomGroupBy();
			String customGroupByHeader = "";
			String prevCustomGroupByHeader = "";
			ArrayList result		 = bean.getAllThePatientsBasedOnCriteria(from,to);

			if(result == null)
				result = new ArrayList();
			String relflag= "false";// Added for Bru-HIMS-CRF-416[IN045566]--start
			relflag = bean.getreleaseFlag();
			ArrayList patientsList		 = bean.getallPatients();
			String selptid = bean.getRelPatientID();
			if(patientsList.contains(selptid)){
				ptindex = patientsList.indexOf(selptid);
			}
			else{
				relflag = "disp";
%>
				<script>
					clickPatient();
				</script>
<%				
			}//Added for Bru-HIMS-CRF-416[IN045566] --end
			String disp_locn_catg	   = bean.getDispLocnCatg();	
			String sysdate             = bean.getTodaysDate();
			String getDate_plus_365	   = bean.getDate_plus_365();	

			if(!(locale.equals("en"))){//added for IN25886 --26/04/2011-- priya
				 sysdate = com.ehis.util.DateUtils.convertDate(sysdate, "DMY","en", locale);
				 getDate_plus_365 =  com.ehis.util.DateUtils.convertDate(getDate_plus_365, "DMY","en", locale);
			} 

			String scope               = bean.getScope();
			String disp_stage		   = bean.getDispStage();
			String disp_locn_code	   = bean.getDispLocnCode();
			String patient_id		   = "";
			String lock_status		   = "";
			//String patient_id_status   = "";	//Commented for Checkstyle
			String user_id             = "";
			String locked_date_time    = "";
			String Unlock_all_records_yn      = "";
			String allow_disp_record_lock_yn  = "";
			HashMap AccessRightMap            = new HashMap();
			int resultSize			= 19; //changed from 15 to 18 for RUT-CRF-0083.5 [IN:041511] // 18 Changed to 19 for BSP-SCF-0060
			if((disp_locn_catg.equals("IAE") || disp_locn_catg.equals("I")) && !((String) bean.getFillList()).equals("AF")){ // Added for KDAH-CRF-0338 - Start
				resultSize			= 20; // 19 Changed to 20 for BSP-SCF-0060
			} // Added for KDAH-CRF-0338 - End
			
			if((disp_locn_catg.equals("IAE") || (disp_locn_catg.equals("I") && !((String) bean.getFillList()).equals("AF"))) && bean.getDisp_locn_iae().contains("@@@")) //modified  by Himanshu For MMS-DM-CRF-0232 starts
			{
				resultSize			= 21;
			}
			//Added  by Himanshu For MMS-DM-CRF-0232 starts
			if(disp_locn_catg.equals("O") && bean.getDisp_locn_iae().contains("@@@"))
			{
				resultSize			= 20;
			}
			
			int recCount			= 0;
			int tmp_recCount		= 0;
			String ord_loc			= "";
			String classvalue		= "";
			String flag				="N";
			
			String flag1				="N";
			String patient_class="";
			String patient_class_temp="";
			
			String sTokenNumbers	= "";
			String clinic_or_nursing_unit ="";
			String criteria_patient_id = request.getParameter("patient_id");
			boolean record_found=true;
			String QMS_required_yn = "Y"; // Added for Bru-HIMS-CRF-076 [IN:029942]
			if(bean.getIssueTokenOnRegnYN().equals("Y"))// Added for Bru-HIMS-CRF-076 [IN:029942]
				QMS_required_yn = bean.getQMSRequiredYN();
			if(!bean.getIssueTokenOnRegnYN().equals("Y") || disp_locn_catg.equals("I"))
				sort_token_series_ind="O";
			//String patinet_tokens	= ""; //Added for Bru-HIMS-CRF-142 [IN:030195] - start//Commented for Checkstyle
			String storage_locn_appl_yn = bean.getStorageLocnApplYN(disp_locn_code);
			String storage_locn_text = "Patient Called";
			String patient_arvd		= "";	//Added for Bru-HIMS-CRF-142 [IN:030195] - End
			String ordering_facility_id="";// added for ML-BRU-SCF-0792 [IN:039236]
			String sTokenNos="";// added for ML-BRU-SCF-0786 [IN:039204]
			//String patient_class="", encounter_id, episode_id;// added for RUT-CRF-0083.5 [IN:041511] Commented for Checkstyle
			String order_id		=	request.getParameter("order_id")==null?"":request.getParameter("order_id");//Added for JD-CRF-0181[IN045511]		
			String bed_no = ""; // Added for KDAH-CRF-0338
			String refresh_pat_details ="YES";//Added for TH-KW-CRF-0011
			String disp_auto_refresh =bean.getDispAutoRefresh();//Added for TH-KW-CRF-0011
			int refresh_time = Integer.parseInt(disp_auto_refresh)*60000;//Added for TH-KW-CRF-0011
			/* Added for ML-MMOH-CRF-0532 [IN061327]  start*/
			
			 con						= ConnectionManager.getConnection(request);
			 boolean siteOrder = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","ORDER_LOCATION");
			 boolean site  = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PATIENT_LOCATION"); //Added for ML-MMOH-SCF-1904
			 boolean auto_refresh  = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DISP_MEDICATION_AUTO_REFRESH"); //Added for TH-KW-CRF-0011
			 boolean display_delivery_bin = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DISPLAY_DELIVERY_BIN");//Adding start for TH-KW-CRF-0020.9
			 boolean ph_print_prescription  = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_PRINT_PRESCRIPTION"); //Added for MMS-DM-CRF-0228	 		 
			boolean isSite_integration_em_bd_pyxis =  eCommon.Common.CommonBean.isSiteSpecific(con,"PH","PH_INTEGRATION_EM_BD_PYXIS"); //  Added  by Himanshu For MMS-DM-CRF-0232
			 String delivery_bin_yn ="";
					 
			//MMS-DM-CRF-0228 start
			String maxRecord1 = "";
			double maxRecord = 0;
			
			if(ph_print_prescription){
				maxRecord1 = (String)result.get(0);
			}
			
			if(maxRecord1 == null) maxRecord1="";
			if (!maxRecord1.equals(""))
			maxRecord = Double.parseDouble((String)maxRecord1);
	
			int start			= 0;
			int end				= 0;
			int searchThreshold	= 12;
			double maxDisplay	= 0;
			double maxDisplay1	= 0;
			int TotalNoRecords = 0;
			String mode = "";
			
			if(ph_print_prescription){
			from = request.getParameter( "from" );
			to = request.getParameter( "to" );

			if ( from == null || from.equals(""))
			    start = 1 ;
			else
			    start = Integer.parseInt( from ) ;
			if ( to == null || to.equals(""))
			    end = searchThreshold ;
			else
			    end = Integer.parseInt( to ) ;
			}

			double Hit=0;
			double Hit_for_buttons=0;
			String maxDisp = eCommon.Common.CommonBean.checkForNull(request.getParameter("maxdisplay"),"0");
			String maxDisp1 = eCommon.Common.CommonBean.checkForNull(request.getParameter("maxdisplay1"),"0");
	
			if (maxDisp==null ||maxDisp.equals("0.0")) maxDisp = "0";
			if (maxDisp1==null ||maxDisp1.equals("0.0")) maxDisp1 = "0";
			maxDisplay = Double.parseDouble(maxDisp);
			maxDisplay1 = Double.parseDouble(maxDisp1);					 	 
			//MMS-DM-CRF-0228 end	 
			
			 if(display_delivery_bin)
                   delivery_bin_yn ="Y";
			 else
				   delivery_bin_yn = "N";//Adding end for TH-KW-CRF-0020.9
			 /* Added for ML-MMOH-CRF-0532 [IN061327] end */
			
			
				
					//if(scope.equals("EX"))
				//resultSize = 17; //Commented for IN 32923 //14->17 RUT-CRF-0083.5 [IN:041511]
%>
<!-- Display the Previous Next link -->
			 <table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="customGroupTable">
<% 
			if(tab_based_group_sort_disp.equals("Y") && bean.getCustomTabBased().equals("Y")){
				String customTabBasedHrs = bean.getCustomTabBasedHrs();
				String customTabBasedOption = bean.getCustomTabBasedOption();
				String pastTabClass="CAFIRSTSELECTHORZ", currentTabClass="CASECONDSELECTHORZ";
				if(customTabBasedOption.equals("PAST")){
					pastTabClass="CASECONDSELECTHORZ";
					currentTabClass="CAFIRSTSELECTHORZ";
				}
%>
				<tr >
					<td id="pastOrders"  width="15%"class="<%=currentTabClass%>" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_CUSTOM_GROUP');javascript:showPatientsBasedOnTheCriteria('I','<%=bean.getIssueTokenOnRegnYN()%>','<%=disp_stage%>','<%=bean.getFillList()%>','1');" nowrap>
						<a class="MENUHIGHERLEVELLINK" style="color:white" name="print_report" ><fmt:message key="Common.Orders.label" bundle="${common_labels}"/>&nbsp; < &nbsp; <%=customTabBasedHrs%> &nbsp;<fmt:message key="Common.Hrs.label" bundle="${common_labels}"/></a>
					</td>

					<td id="currentOrders" width="15%" class="<%=pastTabClass%>" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_CUSTOM_GROUP');javascript:showPatientsBasedOnTheCriteria('I','<%=bean.getIssueTokenOnRegnYN()%>','<%=disp_stage%>','<%=bean.getFillList()%>','2')" nowrap>
						<a class="MENUHIGHERLEVELLINK" style="color:white" name="bal_med_dtl" ><fmt:message key="Common.Orders.label" bundle="${common_labels}"/>&nbsp; > &nbsp;<%=customTabBasedHrs%> &nbsp;<fmt:message key="Common.Hrs.label" bundle="${common_labels}"/></a>
					</td>
					<td id='dummy' align="left"  width="*" />
				</tr> 

<%
			}
%>
			</table>
<%
			if((result.size()<resultSize && disp_locn_catg.equals("O"))||(result.size()<15 && disp_locn_catg.equals("I"))||(result.size()<15 && disp_locn_catg.equals("IAE"))){
				record_found = false;
%>
				<script language="javascript">
					//alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common")); //commented [IN:037465]
					parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"); //added for [IN:037465]
					//parent.parent.parent.document.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.disabled=false;
					const button = document.getElementById("btnSearch");
					if (button) {
						button.disabled = false;
						}
					enableCriteria();
					</script>
<%            if(auto_refresh && refresh_pat_details.equals("YES")){//Added if condition for TH-KW-CRF-0011
%>
					<script> setTimeout("setAutoRefresh()",'<%=refresh_time%>');</script>
<%}%>

				
<%
				if(!tab_based_group_sort_disp.equals("Y") && !bean.getCustomTabBased().equals("Y")){
					return;
				}
			}
			if(record_found){
				if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) ) && ( !( ((String) result.get(0)).equals("")) )){
%>
					<script language="javascript">
						parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
					</script>
<%                  if(auto_refresh && refresh_pat_details.equals("YES")){ //Added if condition for TH-KW-CRF-0011
%>
					<script> setTimeout("setAutoRefresh()",'<%=refresh_time%>');</script>
<%}%>

					<table cellpadding=0 cellspacing=0 align="center" id="nav_table">
					<tr>
					<td width="80%" class="white">&nbsp;</td>
					<td width="20%" class="white">&nbsp;
<%
	// For display the previous/next link
			if(!ph_print_prescription){ //Added for MMS-DM-CRF-0228 start
				out.println(result.get(0));
			}
			else{
				if ( !(start <= 1) ) 
		    	{
%>
				        <Script language="JavaScript">
							parent.parent.patient_id_pagination.document.getElementById("disprec").style.visibility='visible' ; 
							var maxrec = '';
							var str = '';
							if("<%=Hit%>")
							maxrec = "<%=Hit%>";
							if(parent.parent.patient_id_pagination.document.getElementById("to"))
							str=parent.parent.patient_id_pagination.document.getElementById("to").value;
							if (eval(maxrec) > 50)
							{
								parent.parent.patient_id_pagination.document.forms[0].prev.style.visibility = 'visible';
						        parent.parent.patient_id_pagination.document.forms[0].next.style.visibility = 'visible';
							}
						</Script>
<%
					}
				    else 
				    {
%>
				        <Script language="JavaScript">
				        var defaultwindow= parent.patient_id_pagination.document.forms[0].defaultwindow.value;
<%
				            String display_anchors = "";  
				            if(mode.equals(""))
				            {                                               
								maxDisplay = maxRecord/searchThreshold;                             
				                if (maxRecord > 10)
								{
									maxDisplay = Math.ceil(maxDisplay); 
								}else
								{
									maxDisplay = Math.floor(maxDisplay);
								}
				                if (maxDisplay>5) maxDisplay1=5; else maxDisplay1 = maxDisplay;
				                int noofRec = 1;
				                int number=0;
				                display_anchors = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";             
				                for (int i=1;i<=maxDisplay1;i++) 
								{
				                	noofRec=(i-1)*12+1;
				                	number=number+12;
				                    display_anchors = display_anchors +"<b><a name='str"+noofRec+"' href='javascript:SubmitLinkForPagination("+noofRec+","+(number)+","+noofRec+")'>"+(i)+"</a></b>";
				                    display_anchors = display_anchors +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				                   // noofRec =noofRec +searchThreshold;
				                }											
							}
				            				            
%>                  
				            var md = "<%=mode%>";
				            if (md=="")
				            {
								var td = "<%=display_anchors%>";            
				                var scroll_view = "<%=maxDisplay%>";   
								if (scroll_view>0)
				                {
									if(defaultwindow!=""){
										parent.patient_id_pagination.document.getElementById('disprec').innerHTML= defaultwindow;
									}else{
										parent.patient_id_pagination.document.getElementById('disprec').innerHTML = td;
										parent.patient_id_pagination.document.getElementById('defaultwindow').value= td;
									}
				                    parent.patient_id_pagination.document.getElementById("disprec").style.visibility='visible' ; 
								}
				                if (scroll_view>5) 
				                {
				                	parent.patient_id_pagination.document.getElementById('next').style.visibility = 'visible';            
				                	parent.patient_id_pagination.document.getElementById('prev').style.visibility = 'visible';
				                	parent.patient_id_pagination.document.getElementById('prev').disabled = true;
				                	parent.patient_id_pagination.document.getElementById('next').disabled = false;	
				                	
				                	parent.patient_id_pagination.document.getElementById('first').style.visibility='visible' ;
				                    parent.patient_id_pagination.document.getElementById('last').style.visibility='visible' ;
				                    parent.patient_id_pagination.document.getElementById('first').disabled = false;
				                	parent.patient_id_pagination.document.getElementById('last').disabled = false;	
								}           
				                mode = "Y";
				            if('<%=maxRecord%>'<=12)parent.patient_id_pagination.defaultSetting(); 
							}
						</Script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



						<%
					}
				}//Added for MMS-DM-CRF-0228 end
			
				//result.remove(0);
%>
					</td></tr>
					</table>
<% 
				}
%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="patientiddisplaytable">
				<tr id="header">
					<td class="COLUMNHEADER" width="2%">&nbsp;</td>
					<%if(disp_locn_catg.equals("I") && !((String) bean.getFillList()).equals("AF")){ //&& !((String) bean.getFillList()).equals("AF") added for ip with fill list// Added for KDAH-CRF-0338 - Start %>
					<td class="COLUMNHEADER" width="15%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class="COLUMNHEADER" width="3%" nowrap ><img src='../../ePH/images/Locked.gif'></td>
					<td class="COLUMNHEADER" width="30%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
					<td class="COLUMNHEADER" width="10%">
					<%} else{ %>
					<td class="COLUMNHEADER" width="20%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<!-- <td class="COLUMNHEADER" width="10%" nowrap ><fmt:message key="ePH.UserLocked.label" bundle="${ph_labels}"/></td> -->
					<td class="COLUMNHEADER" width="3%" nowrap ><img src='../../ePH/images/Locked.gif'></td>
					<td class="COLUMNHEADER" width="35%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
					<td class="COLUMNHEADER" width="10%">
					<%} // Added for KDAH-CRF-0338 - End %>
<%
					if(sort_token_series_ind.equals("R")){
%>
						<fmt:message key="ePH.RegisterDateTime.label" bundle="${ph_labels}"/>
<%
					}
					else if(sort_token_series_ind.equals("P")){
%>
						<fmt:message key="ePH.PatientArrived.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.time.label" bundle="${common_labels}"/>
<%
					}
					else {
%>
						<fmt:message key="ePH.ReleaseDateTime.label" bundle="${ph_labels}"/>
<%
					}
%>
					<td class="COLUMNHEADER" width="3%"><fmt:message key="ePH.No.OfOrders.label" bundle="${ph_labels}"/></td>
					<td class="COLUMNHEADER" width="6%"><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
					<td class="COLUMNHEADER" width="6%"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
					<td class="COLUMNHEADER" width="10%"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>	
<%
					if((bean.getGroupByOrdLocn()).equals("N")&&!scope.equals("EX")){
						/* Added for ML-MMOH-CRF-0532 [IN061327] start */
						if(siteOrder && disp_locn_catg.equalsIgnoreCase("I")){
						%>					
						<td class="COLUMNHEADER" width="10%"><fmt:message key="Common.patient.label" bundle="${common_labels}"/> <fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<%			}
						else if(disp_locn_catg.equalsIgnoreCase("I") && !((String) bean.getFillList()).equals("AF")){ // else if condition Added for KAUH-CRF-0338 - Start
				%>			<td class="COLUMNHEADER" width="10%"><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></td>
					<%	} // else if condition Added for KAUH-CRF-0338 - End
						else{%>
						<td class="COLUMNHEADER" width="25%"><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></td>
					<%-- 	<td class="COLUMNHEADER" width="25%"><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></td> --%>
<%
		                          }/* Added for ML-MMOH-CRF-0532 [IN061327] end */	
                                        }
					if((disp_locn_catg.equalsIgnoreCase("I") || disp_locn_catg.equalsIgnoreCase("IAE")) && !((String) bean.getFillList()).equals("AF")){
						//condition Added for KAUH-CRF-0338 -Start %>			
					<td class="COLUMNHEADER" width="15%"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
							<% 	} 

//Added  by Himanshu For MMS-DM-CRF-0232 starts
if(isSite_integration_em_bd_pyxis && bean.getDisp_locn_iae().contains("@@@"))
{
	%>		
	<td class="COLUMNHEADER" width="25%"><fmt:message key="ePH.DispenseLocation.label" bundle="${common_labels}"/></td>
<%
	}
//Added  by Himanshu For MMS-DM-CRF-0232 ends

// condition Added for KDAH-CRF-0338 - End
%>
				</tr>
<%				//added for GHL-CRF-0453 - start
				String print_value = "";
				String min_value   = "0";//GHL-CRF-0453
				String max_value   = "0";//GHL-CRF-0453
				String print_msg   = "";
				String print_spilt = "";//GHL-CRF-0453
				String bin_location ="";
				HashMap printValueForOrders = bean.getPrintValueForOrders(); //CRF-453
				//added for GHL-CRF-0453 - end
				if( disp_locn_catg.equals("O")&&!scope.equals("EX")){
					for(int i=0;i<result.size();i=i+resultSize){

						if(recCount%2==0){
							classvalue = "QRYODD";
						}
						else{
							classvalue = "QRYEVEN";
						}
						if(i==0)
							++i;	
						
						////Added  by Himanshu For MMS-DM-CRF-0232 starts
						if(isSite_integration_em_bd_pyxis)
						{
						if(bean.getDisp_locn_iae().contains("@@@")){
						desp_name_code_loc=(String) result.get(i+18);
						String desp_code_loc[]=	desp_name_code_loc.split(" &&& ");
						//bean.setDisp_locn_codeall(desp_code_loc[0]); // this is created for getOrders(patient id) for all dispnce location scenario
						desp_name_code=desp_code_loc[0];
						dispname=desp_code_loc[1];
						 }else
						 {
							// bean.setDisp_locn_codeall(bean.getDisp_locn_iae());
							 desp_name_code=bean.getDisp_locn_iae();
						 }
						}//Added  by Himanshu For MMS-DM-CRF-0232 ends
						
						
						//Added for Bru-HIMS-CRF-142 [IN:030195] - start
						sTokenNos="";
						if(bean.getIssueTokenOnRegnYN().equals("Y")){
							sTokenNumbers = result.get(i+10)!=null?result.get(i+10).toString():"";
							if(sTokenNumbers != null && !sTokenNumbers.equals("") && sTokenNumbers.length() >1){
								if(sTokenNumbers.indexOf("~")!=-1){ //if condition and else block added for RUT-SCF-0264 [IN:039436]
									if(sTokenNumbers.indexOf("/")!=-1) //if and else block added for RUT-SCF-0264 [IN:039436]
										sTokenNos = sTokenNumbers.substring(sTokenNumbers.indexOf("(")+1, sTokenNumbers.indexOf("/"));	// added for ML-BRU-SCF-0786 [IN:039204]
									sTokenNumbers = sTokenNumbers.replaceAll("~",",").substring(0,sTokenNumbers.length());
								}
							 }
							if(sTokenNos.equals("")){
								if(sTokenNumbers.indexOf("/")!=-1) //if and else block added for RUT-SCF-0264 [IN:039436]
									sTokenNos = sTokenNumbers.substring(sTokenNumbers.indexOf("(")+1, sTokenNumbers.indexOf("/"));	// added for ML-BRU-SCF-0786 [IN:039204]
								else
									sTokenNos = sTokenNumbers.substring(sTokenNumbers.indexOf("(")+1,sTokenNumbers.length());	// added for ML-BRU-SCF-0786 [IN:039204]
							}
						}
						if(sTokenNumbers.indexOf("><")>1){
							 patient_arvd   = sTokenNumbers.substring(sTokenNumbers.indexOf("=")+1,sTokenNumbers.indexOf("><"));
						}
						if(storage_locn_appl_yn.equals("Y")){
							storage_locn_text = "Keep in Delivery Bin";
						}
						//Added for Bru-HIMS-CRF-142 [IN:030195] - End
						sPriorityImg =  result.get(i+11).toString().equals("U")?"<img src='../../ePH/images/Urgent.gif' style='width:14;height:10' title='"+sUrgentTitle+"' >":"&nbsp;";
						if(disp_stage.equals("AS")||disp_stage.equals("A")||disp_stage.equals("F")||disp_stage.equals("D")||disp_stage.equals("V")){
%>
							<tr colspan="8"></tr>
<%
							if(clinic_or_nursing_unit.equals("")|| !(clinic_or_nursing_unit.equals(((String)result.get(i+9))))){
								clinic_or_nursing_unit =result.get(i+9)==null?"":(String)result.get(i+9);
								flag="Y";
							}
							if(flag.equals("Y")){
								if(clinic_or_nursing_unit.equals("N")){
%>
									<td class="COLUMNHEADER" align="center" id="th1" colspan="11"><b><fmt:message key="ePH.DischargeMedications.label" bundle="${ph_labels}"/></b></td>
<%
								}
								else{
%>
									<td class="COLUMNHEADER" align="center" id="th2" colspan="11"><b><fmt:message key="Common.Outpatients.label" bundle="${common_labels}"/></b></td>
<%	
								}
								flag="N";
							}
						}
						if(!ord_loc.equals((String)result.get(i))&&((bean.getGroupByOrdLocn()).equals("Y"))) {
							ord_loc	=	result.get(i)==null?"":(String)result.get(i);		
%>
							<tr colspan="8"></tr><tr colspan="8"></tr><tr colspan="8"></tr>
								<td class="COLUMNHEADER" align="left" id="th_<%=recCount%>" colspan="9"><%=ord_loc%></td>
<%	
								tmp_recCount	=	recCount;
						}
						else {
%>
							<label id="th_<%=recCount%>" style="display:none"></label> 
<%	
						}	
						patient_id					=	(String)result.get(i+1);
					    ordering_facility_id =    (String)result.get(i+14);// added for ML-BRU-SCF-0792 [IN:039236]
			//changed during PE BY Naveen
					   // allow_disp_record_lock_yn	=	bean.getAllowdisprecordlock(facility_id);
						allow_disp_record_lock_yn	=	bean.getAllow_disp_record_lock_yn();
						if(allow_disp_record_lock_yn.equals("Y")){
							 lock_status   =  bean.getLockStatus(patient_id,disp_locn_code,login_user,disp_stage);
						
							ArrayList AccessRight	=	bean.getAccessRightStatus(login_user,patient_id,disp_locn_code,disp_stage);
				//commented during PE By Naveen
						   // Unlock_all_records_yn	=	bean.getUnLockRecordsYN(login_user,disp_locn_code);
							Unlock_all_records_yn   =   bean.geuUnlockAllRecordsYN();
							if(AccessRight.size()>0){
							  for(int j=0; j<AccessRight.size(); j++){
									AccessRightMap		= (HashMap)AccessRight.get(j);
									user_id				= (String)AccessRightMap.get("user_id");
									locked_date_time	= (String)AccessRightMap.get("locked_date_time");
								}
							}
						}
						else if(allow_disp_record_lock_yn.equals("N")){
							 lock_status   = "0";
						}			
%>
						<tr id="tr_<%=recCount%>" style="display:">
							<td class="<%=classvalue%>"><%=sPriorityImg%></td> 
							<td class="<%=classvalue%>" style="font-size:9px">
<%
								if(!patient_arvd.equals("red")||!(disp_stage.equals("D")||disp_stage.equals("AS"))){ //if condition Added for Bru-HIMS-CRF-142 [IN:030195] - start
%>
									<label style='cursor:pointer;color:blue;font-size:9px;font-weight:bold'  onMouseOver='showToolTip(this,"<%=result.get(i+7)%>","<%=result.get(i+6)%>","<%=result.get(i+5)%>","<%=result.get(i+8)%>")' onClick='if(CheckAccessRights("<%=login_user%>","<%=patient_id%>","<%=disp_locn_code%>","<%=disp_stage%>","<%=user_id%>","<%=recCount%>","<%=tmp_recCount%>","<%=recCount%>","<%=java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")%>","<%=result.get(i+7)%>","<%=result.get(i+6)%>","<%=java.net.URLEncoder.encode(ord_loc)%>","<%=allow_disp_record_lock_yn%>","<%=(String)result.get(i+14)%>")){collapse("<%=recCount%>","<%=tmp_recCount%>","<%=(String)result.get(i+1)%>");LockStatus("<%=user_id%>","<%=lock_status%>","<%=login_user%>","<%=patient_id%>","<%=disp_locn_code%>","<%=disp_stage%>","<%=allow_disp_record_lock_yn%>");displayOrdersForPatient("<%=recCount%>","<%=result.get(i+1)%>","<%=java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")%>","<%=result.get(i+7)%>","<%=result.get(i+6)%>","","<%=(String)result.get(i+14)%>");}'	id="patient_id_label<%=recCount%>"><%=result.get(i+1)%>	</label>
									<label  onClick='collapse("<%=recCount%>","<%=tmp_recCount%>","<%=(String)result.get(i+1)%>");displayOrdersForPatient("<%=recCount%>","<%=result.get(i+1)%>","<%=java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")%>","<%=result.get(i+7)%>","<%=result.get(i+6)%>","","<%=result.get(i+14)%>")'  id="<%="S"+result.get(i+1)%>">&nbsp;</label>
<%
                                  if(delivery_bin_yn.equals("Y") && storage_locn_appl_yn.equals("Y")){//Adding start for TH-KW-CRF-0020.9
										String en_id = (String)result.get(i+15);

										bin_location =bean_2.getBinLocation(patient_id,en_id,disp_locn_code);
%>
                                    <label  style='color:red;font-size:9px;font-weight:bold' id="BinLocation<%=recCount%>">&nbsp;<%=bin_location%> </label>
<%
                                 }//Adding end for TH-KW-CRF-0020.9
								}
								else{ //else block Added for Bru-HIMS-CRF-142 [IN:030195] - start
%>
									<label style='cursor:pointer;color:blue;font-size:9px;font-weight:bold' onMouseOver='showToolTip(this,"<%=result.get(i+7)%>","<%=result.get(i+6)%>","<%=result.get(i+5)%>","<%=result.get(i+8)%>")' id="patient_id_label<%=recCount%>"><%=result.get(i+1)%>
<%
								}
								if(bean.getIssueTokenOnRegnYN().equals("Y")){
									/*sTokenNumbers = result.get(i+(resultSize-4))!=null?result.get(i+(resultSize-4)).toString():"";
									if(sTokenNumbers != null && !sTokenNumbers.equals("") && sTokenNumbers.length() >1){
										sTokenNumbers = sTokenNumbers.replaceAll("~",",").substring(0,sTokenNumbers.length()-1);*/ //Commented for  Bru-HIMS-CRF-142 [IN:030195]
%>
										<label style='cursor:pointer;color:blue;font-size:9px' id="tokenNumbers<%=recCount%>" onclick="viewTokenDetails('<%=result.get(i+1)%>')">&nbsp;<%=sTokenNumbers%></label>
<%
										if(QMS_required_yn.equals("Y") && disp_stage.equals("D")){
%>
											<img src="../../ePH/images/CallToken.png" align="center" title='<fmt:message key="ePH.callQmsToken.label" bundle="${ph_labels}"/>' id='QMS_call_token' onclick='callQMSToken("<%=recCount%>","<%=sTokenNos%>");'></img>
<%
										}
									 //} //commented for  Bru-HIMS-CRF-142 [IN:030195]
								 }
								 //added for GHL-CRF-0453 - start							
								if(printValueForOrders!=null && printValueForOrders.size()>0)
									{
										print_value = "";
											print_spilt = (String)printValueForOrders.get(patient_id);//8/2/2017 GHL-CRF-0453
											if(print_spilt!=null){ //GHL-CRF-0453
												min_value = ((String)printValueForOrders.get(patient_id)).split("~")[0];
												max_value = ((String)printValueForOrders.get(patient_id)).split("~")[1];
											}
											if(Integer.parseInt(max_value)==1)
												print_value = "1";
											
										//	System.err.println("min_value=339=>"+min_value+"==max_value==>"+max_value);
											if(Integer.parseInt(min_value)!=Integer.parseInt(max_value))
												print_msg = "P";

											if(Integer.parseInt(min_value)!=0 && Integer.parseInt(min_value)==Integer.parseInt(max_value))
												print_msg = "F";

									//	System.err.println("DispMedicationPatientIDDisplay.jsp===print_msg=====346====>"+print_msg);
									}
								
								if(disp_stage.equals("F") || disp_stage.equals("A")){	//Added for IN:065140
									if(print_value.equals("1")){
										if(print_msg.equals("F")){
%>
											<img  src="../../ePH/images/printed_fully.gif" height='20'  width='20' onmouseover = "showToolTipPrint(this,'Fully Printed')"></img>

						
<%											}else{ %>
											<img  src="../../ePH/images/printed_partial.gif" height='20'  width='20' onmouseover = "showToolTipPrint(this,'Partially Printed')"></img>


<%											}
										} 
									} //added for GHL-CRF-0453 - end
									
								if(ph_print_prescription && (disp_stage.equals("A") || disp_stage.equals("AS") || disp_stage.equals("D"))){ //Added for MMS-DM-CRF-0228 start	
								%> 
 								<img src='../../ePH/images/print.gif' align="center"
									title='<fmt:message key="ePH.PrintPrescription.label" bundle="${ph_labels}"/>' style="cursor:pointer;width:20;height:20" id="printPres_<%=recCount%>" onClick="showPrintPrescription('<%=result.get(i+1)%>','<%=sOrderType%>')"> 
 								<%}//Added for MMS-DM-CRF-0228 end %>
								</td>
<%
								if(lock_status.equals("1")){
									if(Unlock_all_records_yn.equals("Y")){
%>
										<td class="<%=classvalue%>" style="font-size:9px"><label id="Logout_gif" style='cursor:pointer;color:blue;font-size:9px;font-weight:bold'  onMouseOver="showToolTipLockStatus(this,'<%=user_id%>','<%=locked_date_time%>')"onClick='UnLockRecord("<%=login_user%>","<%=patient_id%>","<%=disp_locn_code%>","<%=disp_stage%>","<%=Unlock_all_records_yn%>")'><b><img src='../../eCommon/images/enabled.gif'></B></td> 
<%
									}
									else if(Unlock_all_records_yn.equals("N")){
%>
										<td class="<%=classvalue%>" style="font-size:9px"><label id="Logout_gif" style='cursor:pointer;color:blue;font-size:9px;font-weight:bold'  onMouseOver="showToolTipLockStatus(this,'<%=user_id%>','<%=locked_date_time%>')"><b><img src='../../eCommon/images/enabled.gif'></B></td>
<%
									}
							   }
							   else if(lock_status.equals("0")||lock_status.equals("")){
%>
									<td class="<%=classvalue%>" style="font-size:9px"><b>&nbsp;</B></td>
<%
								}
%>
								<input type="hidden" name="lock_status<%=recCount%>" id="lock_status<%=recCount%>" value="<%=lock_status%>">
								<td class="<%=classvalue%>" style="font-size:9px"><b><%=result.get(i+2)%></b>&nbsp;
             					<!--  Added for Bru-HIMS-CRF-142 [IN:030195] - start-->	
<%
								if((disp_stage.equals("D") || disp_stage.equals("AS"))  && storage_locn_appl_yn.equals("Y") && (patient_arvd.equals("red") || patient_arvd.equals("green")) || ((disp_stage.equals("D") || disp_stage.equals("AS")) && delivery_bin_yn.equals("Y") && storage_locn_appl_yn.equals("Y"))){//|| ((disp_stage.equals("D") || disp_stage.equals("AS")) && delivery_bin_yn.equals("Y")) added for TH-KW-CRF-0020.9 and storage_locn_appl_yn.equals("Y") added for ICN-40445
%>
									&nbsp;&nbsp;&nbsp;&nbsp;<font color="black" size=1><b><%=storage_locn_text%></b></font> <input type="checkbox" name="str_lcn_chk" id="str_lcn_chk" onclick="storageLocation(this,'<%=disp_stage%>','<%=result.get(i+1)%>','<%=patient_arvd%>','1','<%=storage_locn_appl_yn%>','<%=ordering_facility_id%>','<%=delivery_bin_yn%>','<%=result.get(i+15)%>');"><!--  added for ML-BRU-SCF-0792 [IN:039236] delivery_bin_yn,15 added for TH-KW-CRF-0020.9-->
<%
								}
								else if(disp_stage.equals("D") && storage_locn_appl_yn.equals("N") && patient_arvd.equals("green")){
%>
									&nbsp;&nbsp;&nbsp;&nbsp;<font color="black" size=1><%=storage_locn_text%></font> <input type="checkbox" name="str_lcn_chk" id="str_lcn_chk" onclick="storageLocation(this,'<%=disp_stage%>','<%=result.get(i+1)%>','<%=patient_arvd%>','2','<%=storage_locn_appl_yn%>','<%=ordering_facility_id%>');"><!--  added for ML-BRU-SCF-0792 [IN:039236]-->
<%
								}
%>
								</td>	<!-- Added for Bru-HIMS-CRF-142 [IN:030195] - End -->	
								<td class="<%=classvalue%>" style="font-size:9px"><b><%=com.ehis.util.DateUtils.convertDate((String)result.get(i+12),"DMYHM","en",locale)%>&nbsp;</b></td>
								<td class="<%=classvalue%>" style="font-size:9px" ><labels id="number_of_orders<%=recCount%>">&nbsp;<%=result.get(i+3)%></label></td>
								<td class="<%=classvalue%>" style="font-size:9px">&nbsp;<%=result.get(i+6)%></td>
<% 
								if( ((String)result.get(i+7)).equals("M"))
									gender	=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
								else if( ((String)result.get(i+7)).equals("F")) 
									gender	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
								if( ((String)result.get(i+7)).equals("U")) 
									gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
%>
								<td class="<%=classvalue%>" style="font-size:9px">&nbsp;<%=gender%></td>
								<td class="<%=classvalue%>" style="font-size:9px">&nbsp;<%=result.get(i+5)%></td>
<%
								if((bean.getGroupByOrdLocn()).equals("N")&&!scope.equals("EX")){
%>
									<td class="<%=classvalue%>" style="font-size:9px"><%=result.get(i)==null?"":result.get(i)%>&nbsp;</td>
<%
								}
						//Added  by Himanshu For MMS-DM-CRF-0232 starts
						if(isSite_integration_em_bd_pyxis && bean.getDisp_locn_iae().contains("@@@"))
						{
%>				<td class="<%=classvalue%>" style="font-size:9px">&nbsp;<%=dispname%></td>
								<%
								}
						%>
								<input type="hidden" name="patient_id<%=recCount%>" id="patient_id<%=recCount%>" value="<%=result.get(i+1)%>">
							</tr>
							<tr>
								<td class="COLUMNHEADER" colspan='2' align="left" id="all_det_th_<%=recCount%>" style="font-size:9px;display:none"><%=ord_loc%></td>
							</tr>
							<tr id="all_det_<%=recCount%>" style="font-size:9px;display:none">
<%
								//String next_appt_days =bean.CheckForAppointments((String)result.get(i+1));
%>
								<td  class="<%=classvalue%>" style="font-size:9px;" width='70%'>

									<label id= "patient_bt<%=recCount%>" style='cursor:pointer;color:blue;font-size:9px;font-weight:bold'  onMouseOver='showToolTip(this,"<%=result.get(i+7)%>","<%=result.get(i+6)%>","<%=result.get(i+5)%>","<%=result.get(i+8)%>")' onClick='collapse("<%=recCount%>","<%=tmp_recCount%>","<%=(String)result.get(i+1)%>");displayOrdersForPatient("<%=recCount%>","<%=result.get(i+1)%>","<%=java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")%>","<%=result.get(i+7)%>","<%=result.get(i+6)%>","","<%=result.get(i+14)%>")'><%=result.get(i+1)%></label><!--id added for Bru-HIMS-CRF-416[IN045566] -->
									<label id="number_of_orders<%=recCount%>">&nbsp;(<%=result.get(i+3)%>)</label>
 									<br><B><%=result.get(i+2)%>&nbsp;</B>
								</td>
								<td  class="<%=classvalue%>" style="font-size:9px;" width='30%'>
									<img src='../../ePH/images/print.gif' align="center"
									title='<fmt:message key="ePH.PrintPrescription.label" bundle="${ph_labels}"/>' style="display:none;cursor:pointer;width:20;height:20" id="print_pres_<%=recCount%>" onClick="showPrintPrescription('<%=result.get(i+1)%>','<%=sOrderType%>')"> 

<%
								//	if(!next_appt_days.equals("")){
%>
										<img src='../../ePH/images/MI_View-ScheduleAppionment.gif' title='<fmt:message key="ePH.APPOINTMENTLIST.label" bundle="${ph_labels}"/>' style="display:none;cursor:pointer;width:20;height:20" id="appt_list_<%=recCount%>" onClick="DiplayAppointmentDtls('<%=result.get(i+1)%>','<%=sysdate%>','<%=getDate_plus_365%>')" ><label id="next_appt_days<%=recCount%>"></label>
<%
								//	} <!--&nbsp;<b>(<%/*=next_appt_days%*/>)</b> -->
									if(bean.getIssueTokenOnRegnYN().equals("Y") && QMS_required_yn.equals("Y") && disp_stage.equals("D")){	// added for ML-BRU-SCF-0786 [IN:039204]
%>
										<img src="../../ePH/images/CallToken.png" align="center" title='<fmt:message key="ePH.callQmsToken.label" bundle="${ph_labels}"/>'  id='QMS_call_token' onclick='callQMSToken("<%=recCount%>","<%=sTokenNos%>");'></img>
<%
									}			
%> 
									</td>
								</tr>
								<input type='hidden' name='Ordering_Facility_id_<%=recCount%>' id='Ordering_Facility_id_<%=recCount%>' value ='<%=result.get(i+14)%>'>
								<input type='hidden' name='encounter_id<%=recCount%>' id='encounter_id<%=recCount%>' value ='<%=result.get(i+15)%>'><!-- added for RUT-CRF-0083.5 [IN:041511] Start -->
								<input type='hidden' name='episode_id<%=recCount%>' id='episode_id<%=recCount%>' value ='<%=result.get(i+16)%>'>
								<input type='hidden' name='patient_class<%=recCount%>' id='patient_class<%=recCount%>' value ='<%=result.get(i+17)%>'> <!-- added for RUT-CRF-0083.5 [IN:041511] -End -->	
								<input type='hidden' name='desp_name_code<%=recCount%>' id='desp_name_code<%=recCount%>' value ='<%=desp_name_code%>'>		
								<%if(bean.getDisp_locn_iae().contains("@@@")){ //modified  by Himanshu For MMS-DM-CRF-0232 starts%>							
								<input type='hidden' name='locn_code<%=recCount%>' id='locn_code<%=recCount%>' value ='<%=result.get(i+19)%>'> <!-- added for BSP-SCF-0060 -->
								<% }else{%>
								<input type='hidden' name='locn_code<%=recCount%>' id='locn_code<%=recCount%>' value ='<%=result.get(i+18)%>'> <!-- added for BSP-SCF-0060 -->
						      <% } 
								if(  !((String) bean.getFillList()).equals("AF")){//if  condtion is add for Ip with fill  %>
								<input type='hidden' name='bed_num<%=recCount%>' id='bed_num<%=recCount%>' value =""><%  } %><!-- added for KDAH-CRF-0338 -->
<%     
								recCount++;
							}
						}
						else if ( disp_locn_catg.equals("O")&&scope.equals("EX")){	
							for(int i=0;i<result.size();i=i+resultSize){
								if(recCount%2==0){
									classvalue = "QRYODD";
								}
								else{
									classvalue = "QRYEVEN";
								}
							
								if(i==0)
									i++;
								
								//Added  by Himanshu For MMS-DM-CRF-0232 starts
								if(isSite_integration_em_bd_pyxis)
								{
								if(bean.getDisp_locn_iae().contains("@@@")){
								desp_name_code_loc=(String) result.get(i+18);
								String desp_code_loc[]=	desp_name_code_loc.split(" &&& ");
								//bean.setDisp_locn_codeall(desp_code_loc[0]); // this is created for getOrders(patient id) for all dispnce location scenario
								desp_name_code=desp_code_loc[0];
								dispname=desp_code_loc[1];
								 }else
								 {
									// bean.setDisp_locn_codeall(bean.getDisp_locn_iae());
									 desp_name_code=bean.getDisp_locn_iae();
								 }
								}
								//Added  by Himanshu For MMS-DM-CRF-0232 ends
								
								//Added for Bru-HIMS-CRF-142 [IN:030195] - start
								sTokenNos="";
								if(bean.getIssueTokenOnRegnYN().equals("Y")){
									sTokenNumbers = result.get(i+10)!=null?result.get(i+10).toString():"";
									if(sTokenNumbers != null && !sTokenNumbers.equals("") && sTokenNumbers.length() >1){
										if(sTokenNumbers.indexOf("~")!=-1){ //if condition and else block added for RUT-SCF-0264 [IN:039436]
											if(sTokenNumbers.indexOf("/")!=-1) //if and else block added for RUT-SCF-0264 [IN:039436]
												sTokenNos = sTokenNumbers.substring(sTokenNumbers.indexOf("(")+1, sTokenNumbers.indexOf("/"));	// added for ML-BRU-SCF-0786 [IN:039204]
											sTokenNumbers = sTokenNumbers.replaceAll("~",",").substring(0,sTokenNumbers.length());
										}
									 }
									if(sTokenNos.equals("")){
										if(sTokenNumbers.indexOf("/")!=-1) //if and else block added for RUT-SCF-0264 [IN:039436]
											sTokenNos = sTokenNumbers.substring(sTokenNumbers.indexOf("(")+1, sTokenNumbers.indexOf("/"));	// added for ML-BRU-SCF-0786 [IN:039204]
										else
											sTokenNos = sTokenNumbers.substring(sTokenNumbers.indexOf("(")+1,sTokenNumbers.length());	// added for ML-BRU-SCF-0786 [IN:039204]
									}
								}
								if(sTokenNumbers.indexOf("><")>1){
									 patient_arvd   = sTokenNumbers.substring(sTokenNumbers.indexOf("=")+1,sTokenNumbers.indexOf("><"));
								}
								if(storage_locn_appl_yn.equals("Y")){
									storage_locn_text = "Keep in Delivery Bin";
								}
								//Added for Bru-HIMS-CRF-142 [IN:030195] - End
								sPriorityImg = result.get(i+12).toString().equals("U")?"<img src='../../ePH/images/Urgent.gif' style='width:14;height:10' title='"+sUrgentTitle+"' />":"&nbsp;";
								patient_id=(String)result.get(i+1);
								String patient_name=(String)result.get(i+2);
								 ordering_facility_id =    (String)result.get(i+14);// added for ML-BRU-SCF-0792 [IN:039236]
								//changed during PE By Naveen
								//  allow_disp_record_lock_yn=bean.getAllowdisprecordlock(facility_id);
								allow_disp_record_lock_yn=bean.getAllow_disp_record_lock_yn();
								if(allow_disp_record_lock_yn.equals("Y")){
									lock_status=bean.getLockStatus(patient_id,disp_locn_code,login_user,disp_stage);
									ArrayList AccessRight=bean.getAccessRightStatus(login_user,patient_id,disp_locn_code,disp_stage);
									//commented during PE By Naveen
									// Unlock_all_records_yn=bean.getUnLockRecordsYN(login_user,disp_locn_code);
									Unlock_all_records_yn=bean.geuUnlockAllRecordsYN();
									if(AccessRight.size()>0){
									  for(int j=0; j<AccessRight.size(); j++){
											AccessRightMap = (HashMap)AccessRight.get(j);
											user_id = (String)AccessRightMap.get("user_id");
											locked_date_time = (String)AccessRightMap.get("locked_date_time");
										}
									}
								}
								else if(allow_disp_record_lock_yn.equals("N")){
									lock_status="0";
								}
%>
								<input type="hidden" name="patient_name_<%=recCount%>" id="patient_name_<%=recCount%>" value="<%=java.net.URLEncoder.encode(patient_name,"UTF-8")%>">
							<tr id="tr_<%=recCount%>" style="display:">
								<td class="<%=classvalue%>"><%=sPriorityImg%></td>
								<td class="<%=classvalue%>" style="font-size:9px">
<%
								if(!patient_arvd.equals("red")||!(disp_stage.equals("D")||disp_stage.equals("AS"))){ //if condition Added for Bru-HIMS-CRF-142 [IN:030195] - start
%>
								<label style='cursor:pointer;color:blue;font-size:9px;font-weight:bold'  onMouseOver='showToolTip(this,"<%=result.get(i+6)%>","<%=result.get(i+5)%>","<%=result.get(i+4)%>","<%=result.get(i+7)%>")' onClick='if(CheckAccessRights("<%=login_user%>","<%=patient_id%>","<%=disp_locn_code%>","<%=disp_stage%>","<%=user_id%>","<%=recCount%>","<%=tmp_recCount%>","<%=recCount%>","<%=java.net.URLEncoder.encode(patient_name,"UTF-8")%>","<%=result.get(i+7)%>","<%=result.get(i+6)%>","<%=java.net.URLEncoder.encode(ord_loc)%>","<%=allow_disp_record_lock_yn%>","<%=(String)result.get(i+14)%>")){collapse("<%=recCount%>","<%=tmp_recCount%>","<%=(String)result.get(i)%>");displayOrdersForPatient("<%=recCount%>","<%=result.get(i+1)%>","<%=java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")%>","<%=result.get(i+6)%>","<%=result.get(i+5)%>","","<%=result.get(i+14)%>")}'  id="patient_id_label<%=recCount%>"><%=result.get(i+1)%></label>
								<label  onClick='collapse("<%=recCount%>","<%=tmp_recCount%>","<%=(String)result.get(i)%>");displayOrdersForPatient("<%=recCount%>","<%=result.get(i+1)%>","<%=java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")%>","<%=result.get(i+7)%>","<%=result.get(i+6)%>","","<%=result.get(i+14)%>")'  id="<%="S"+result.get(i+1)%>">&nbsp;</label>
<%
								}
								else{ //else block Added for Bru-HIMS-CRF-142 [IN:030195] - start
%>
									<label style='cursor:pointer;color:blue;font-size:9px;font-weight:bold' onMouseOver='showToolTip(this,"<%=result.get(i+8)%>","<%=result.get(i+7)%>","<%=result.get(i+6)%>","<%=result.get(i+9)%>")' id="patient_id_label<%=recCount%>"><%=patient_id%>
<%
								}

								if(bean.getIssueTokenOnRegnYN().equals("Y")){
									/*sTokenNumbers = result.get(i+(resultSize-4))!=null?result.get(i+(resultSize-4)).toString():"";
									if(sTokenNumbers != null && !sTokenNumbers.equals("")  && sTokenNumbers.length() >1){
										sTokenNumbers = sTokenNumbers.replaceAll("~",",").substring(0,sTokenNumbers.length()-1);*/
%>
										<label style='cursor:pointer;color:blue;font-size:9px' id="tokenNumbers<%=recCount%>" onclick="viewTokenDetails('<%=result.get(i+1)%>')">&nbsp;<%=sTokenNumbers%></label>
<%
									//}
									if( QMS_required_yn.equals("Y") && disp_stage.equals("D")){	// added for ML-BRU-SCF-0786 [IN:039204]
%>
										<img src="../../ePH/images/CallToken.png" align="center" title='<fmt:message key="ePH.callQmsToken.label" bundle="${ph_labels}"/>'  id='QMS_call_token' onclick='callQMSToken("<%=recCount%>","<%=sTokenNos%>");'></img>
<%
									}			
								}
%>
								</label>
								<% //added for GHL-CRF-0453 - start								
								if(printValueForOrders!=null && printValueForOrders.size()>0)
									{
										print_value = "";
											print_spilt = (String)printValueForOrders.get(patient_id);//8/2/2017 GHL-CRF-0453
											if(print_spilt!=null){ //GHL-CRF-0453
												min_value = ((String)printValueForOrders.get(patient_id)).split("~")[0];
												max_value = ((String)printValueForOrders.get(patient_id)).split("~")[1];
											}
											if(Integer.parseInt(max_value)==1)
												print_value = "1";
											
										//	System.err.println("min_value=339=>"+min_value+"==max_value==>"+max_value);
											if(Integer.parseInt(min_value)!=Integer.parseInt(max_value))
												print_msg = "P";

											if(Integer.parseInt(min_value)!=0 && Integer.parseInt(min_value)==Integer.parseInt(max_value))
												print_msg = "F";

									//	System.err.println("DispMedicationPatientIDDisplay.jsp===print_msg=====346====>"+print_msg);
									}
								
								if(disp_stage.equals("F") || disp_stage.equals("A")){	//Added for IN:065140	
									if(print_value.equals("1")){
										if(print_msg.equals("F")){
%>
											<img  src="../../ePH/images/printed_fully.gif" height='20'  width='20' onmouseover = "showToolTipPrint(this,'Fully Printed')"></img>

						
<%											}else{ %>
											<img  src="../../ePH/images/printed_partial.gif" height='20'  width='20' onmouseover = "showToolTipPrint(this,'Partially Printed')"></img>


<%											}
									}
									} //added for GHL-CRF-0453 - end %>
									
<%								if(ph_print_prescription && (disp_stage.equals("A") || disp_stage.equals("AS") || disp_stage.equals("D"))){ //Added for MMS-DM-CRF-0228 start	
%> 
 								<img src='../../ePH/images/print.gif' align="center"
									title='<fmt:message key="ePH.PrintPrescription.label" bundle="${ph_labels}"/>' style="cursor:pointer;width:20;height:20" id="printPres_<%=recCount%>" onClick="showPrintPrescription('<%=patient_id%>','<%=sOrderType%>')"> <%-- showPrintPrescription('<%=patient_id%> Added for 52625--%>
<%								}//Added for MMS-DM-CRF-0228 end %>

								</td> 
<%								
								if(lock_status.equals("1")){
									if(Unlock_all_records_yn.equals("Y")){
%>
										<td class="<%=classvalue%>" style="font-size:9px"><label id="Logout_gif" style='cursor:pointer;color:blue;font-size:9px;font-weight:bold'  onMouseOver="showToolTipLockStatus(this,'<%=user_id%>','<%=locked_date_time%>')"onClick='UnLockRecord("<%=login_user%>","<%=patient_id%>","<%=disp_locn_code%>","<%=disp_stage%>","<%=Unlock_all_records_yn%>")'><b><img src='../../eCommon/images/enabled.gif'></B></td> 
<%
									}
									else if(Unlock_all_records_yn.equals("N")){
%>
										<td class="<%=classvalue%>" style="font-size:9px"><label id="Logout_gif" style='cursor:pointer;color:blue;font-size:9px;font-weight:bold'  onMouseOver="showToolTipLockStatus(this,'<%=user_id%>','<%=locked_date_time%>')"><b><img src='../../eCommon/images/enabled.gif'></B></td>
<%
									}
								}
								else if(lock_status.equals("0")||lock_status.equals("")){
%>
									<td class="<%=classvalue%>" style="font-size:9px"><b>&nbsp;</B></td>
<%
								}
%>
								<input type="hidden" name="lock_status<%=recCount%>" id="lock_status<%=recCount%>" value="<%=lock_status%>">
							<td class="<%=classvalue%>" style="font-size:9px"><b><%=result.get(i+2)%></b>&nbsp; 
				             	<!--  Added for Bru-HIMS-CRF-142 [IN:030195] - start-->	
<%
								if((disp_stage.equals("D") || disp_stage.equals("AS"))  && storage_locn_appl_yn.equals("Y") && (patient_arvd.equals("red") || patient_arvd.equals("green"))){
%>
									&nbsp;&nbsp;&nbsp;&nbsp;<font color="black" size=1><b><%=storage_locn_text%></b></font> <input type="checkbox" name="str_lcn_chk" id="str_lcn_chk" onclick="storageLocation(this,'<%=disp_stage%>','<%=patient_id%>','<%=patient_arvd%>','1','<%=storage_locn_appl_yn%>','<%=ordering_facility_id%>');">
<%
								}
								else if(disp_stage.equals("D") && storage_locn_appl_yn.equals("N") && patient_arvd.equals("green")){
%>
									&nbsp;&nbsp;&nbsp;&nbsp;<font color="black" size=1><%=storage_locn_text%></font> <input type="checkbox" name="str_lcn_chk" id="str_lcn_chk" onclick="storageLocation(this,'<%=disp_stage%>','<%=patient_id%>','<%=patient_arvd%>','2','<%=storage_locn_appl_yn%>','<%=ordering_facility_id%>');">
<%
								}
%>
                               </td>
								<!-- Added for Bru-HIMS-CRF-142 [IN:030195] - End -->	

							<td class="<%=classvalue%>" style="font-size:9px"><b><%=com.ehis.util.DateUtils.convertDate((String)result.get(i+12),"DMYHM","en",locale)%>&nbsp;</b></td>
							<td class="<%=classvalue%>" style="font-size:9px" ><label id="number_of_orders<%=recCount%>">&nbsp;<B><%=result.get(i+3)%></B></label></td>
							<td class="<%=classvalue%>" style="font-size:9px">&nbsp;<%=result.get(i+6)%></td>
<%	
							if( ((String)result.get(i+7)).equals("M"))
								gender	=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
							else if( ((String)result.get(i+7)).equals("F"))
								gender	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
							if( ((String)result.get(i+7)).equals("U")) 
								gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
%>
							<td class="<%=classvalue%>" style="font-size:9px">&nbsp;<%=gender%></td>
							<td class="<%=classvalue%>" style="font-size:9px">&nbsp;<%=result.get(i+5)%></td>
							
					<%		//Added  by Himanshu For MMS-DM-CRF-0232 starts
						if(isSite_integration_em_bd_pyxis && bean.getDisp_locn_iae().contains("@@@"))
						{
%>				<td class="<%=classvalue%>" style="font-size:9px">&nbsp;<%=dispname%></td>
								<%
								}
						%>
							<input type="hidden" name="patient_id<%=recCount%>" id="patient_id<%=recCount%>" value="<%=result.get(i)%>">
						</tr>
						<tr id="all_det_<%=recCount%>" style="font-size:9px;display:none">
<%
							//String next_appt_days =bean.CheckForAppointments((String)result.get(i));
%>
							<td  class="<%=classvalue%>" style="font-size:9px;" width='70%'>
								<label id="patient_bt<%=recCount%>" style='cursor:pointer;color:blue;font-size:9px'  onMouseOver='showToolTip(this,"<%=result.get(i+7)%>","<%=result.get(i+6)%>","<%=result.get(i+5)%>","<%=result.get(i+8)%>")' onClick='collapse("<%=recCount%>","<%=tmp_recCount%>","<%=(String)result.get(i+1)%>");displayOrdersForPatient("<%=recCount%>","<%=result.get(i+1)%>","<%=java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")%>","<%=result.get(i+7)%>","<%=result.get(i+6)%>","","<%=result.get(i+14)%>")'> <%=result.get(i+1)%></label><!-id added for Bru-HIMS-CRF-416[IN045566]-->
								<label id="number_of_orders<%=recCount%>" style='font-weight:bold'>&nbsp;(<%=result.get(i+3)%>)</label>
								<br><%=result.get(i+2)%>
							</td>
							<td  class="<%=classvalue%>" style="font-size:9px;" width='30%'>

								<img src='../../ePH/images/print.gif' align="center"
								title='<fmt:message key="ePH.PrintPrescription.label" bundle="${ph_labels}"/>' style="display:none;cursor:pointer;width:20;height:20" id="print_pres_<%=recCount%>" onClick="showPrintPrescription('<%=patient_id%>','<%=sOrderType%>')"> <%-- showPrintPrescription('<%=patient_id%> Added for 52625--%>
<%
								//if(!next_appt_days.equals("")){
%>
									<img src='../../ePH/images/MI_View-ScheduleAppionment.gif' title='<fmt:message key="ePH.APPOINTMENTLIST.label" bundle="${ph_labels}"/>' style="display:none;cursor:pointer;width:20;height:20" id="appt_list_<%=recCount%>" onClick="DiplayAppointmentDtls('<%=result.get(i)%>','<%=sysdate%>','<%=getDate_plus_365%>')" ><label id="next_appt_days<%=recCount%>"></label>
<%
								//} &nbsp;(<%*/=next_appt_days%*/>)
								if(bean.getIssueTokenOnRegnYN().equals("Y") && QMS_required_yn.equals("Y") && disp_stage.equals("D")){	// added for ML-BRU-SCF-0786 [IN:039204]
%>
									<img src="../../ePH/images/CallToken.png" align="center" title='<fmt:message key="ePH.callQmsToken.label" bundle="${ph_labels}"/>'  id='QMS_call_token' onclick='callQMSToken("<%=recCount%>","<%=sTokenNos%>");'></img>
<%
								}
%> 
							</td>
						</tr>
						<input type='hidden' name='Ordering_Facility_id_<%=recCount%>' id='Ordering_Facility_id_<%=recCount%>' value = '<%=result.get(i+14)%>'>
						<input type='hidden' name='encounter_id<%=recCount%>' id='encounter_id<%=recCount%>' value ='<%=result.get(i+15)%>'><!-- added for RUT-CRF-0083.5 [IN:041511] Start -->
						<input type='hidden' name='episode_id<%=recCount%>' id='episode_id<%=recCount%>' value ='<%=result.get(i+16)%>'>
						<input type='hidden' name='patient_class<%=recCount%>' id='patient_class<%=recCount%>' value ='<%=result.get(i+17)%>'> <!-- added for RUT-CRF-0083.5 [IN:041511] -End -->
						<input type='hidden' name='desp_name_code<%=recCount%>' id='desp_name_code<%=recCount%>' value ='<%=desp_name_code%>'>	
						<%if(bean.getDisp_locn_iae().contains("@@@")){ //modfied  by Himanshu For MMS-DM-CRF-0232 starts %>							
								<input type='hidden' name='locn_code<%=recCount%>' id='locn_code<%=recCount%>' value ='<%=result.get(i+19)%>'> <!-- added for BSP-SCF-0060 -->
								<% }else{%>
								<input type='hidden' name='locn_code<%=recCount%>' id='locn_code<%=recCount%>' value ='<%=result.get(i+18)%>'> <!-- added for BSP-SCF-0060 -->
						      <% } 
						 if(  !((String) bean.getFillList()).equals("AF")){ //if  condtion is add for Ip with fill %>
						<input type='hidden' name='bed_num<%=recCount%>' id='bed_num<%=recCount%>' value =""> <!-- added for KDAH-CRF-0338 -->
						<%} %>
<%     
						recCount++;
					}
				}
				else if(disp_locn_catg.equals("I")){
					classvalue	= "";
					//String ord_loc		= "";
					for(int i=0;i<result.size();i=i+resultSize){
						if(recCount%2==0){
							classvalue = "QRYODD";
						}
						else{
							classvalue = "QRYEVEN";
						}
						if(i==0){
							++i;
						}

						//Added  by Himanshu For MMS-DM-CRF-0232 starts
						if(isSite_integration_em_bd_pyxis){
							if(bean.getDisp_locn_iae().contains("@@@")){
								desp_name_code_loc=(String) result.get(i+19);
							String desp_code_loc[]=	desp_name_code_loc.split(" &&& ");
							//bean.setDisp_locn_codeall(desp_code_loc[0]); // this is created for getOrders(patient id) for all dispnce location scenario
							desp_name_code=desp_code_loc[0];
							dispname=desp_code_loc[1];
							 }else
							 {
								// bean.setDisp_locn_codeall(bean.getDisp_locn_iae());
								 desp_name_code=bean.getDisp_locn_iae();
							 }
						}
						//Added  by Himanshu For MMS-DM-CRF-0232 ends
						
						sPriorityImg = result.get(i+11).toString().equals("U")?"<img src='../../ePH/images/Urgent.gif' style='width:14;height:10' title='"+sUrgentTitle+"' />":"&nbsp;";
						if(tab_based_group_sort_disp.equals("Y") && !customGroupBy.equals("NONE")  ){
							if(customGroupBy.equals("NURSING_UNIT"))
								customGroupByHeader = (String)result.get(i);
							if(customGroupBy.equals("RELEASE_DATE_TIME")){
								customGroupByHeader = com.ehis.util.DateUtils.convertDate((String)result.get(i+12),"DMYHM","en",locale);
								customGroupByHeader = customGroupByHeader.substring(0,10);
							}
							if(customGroupBy.equals("ORD_DATE_TIME")){
								customGroupByHeader = com.ehis.util.DateUtils.convertDate((String)result.get(i+13),"DMY","en",locale);
								customGroupByHeader = customGroupByHeader.substring(0,10);
							}
							if(customGroupBy.equals("PRIORITY"))
								customGroupByHeader = (String)result.get(i+11);
							if(customGroupBy.equals("PERFORMING_DEPTLOC_CODE") && bean.getDisp_locn_iae().contains("@@@"))
								customGroupByHeader = dispname;
							if(!prevCustomGroupByHeader.equals(customGroupByHeader)){
								prevCustomGroupByHeader = customGroupByHeader ;
%>
								<tr colspan="8"></tr>
									<td class="COLUMNHEADER" align="left" id="th_<%=recCount%>" colspan="12"><b><%=customGroupByHeader%></b></td> <!-- colspan="10" Changed to colspan="11" for KDAH-CRF-0338 -->
								</tr>
<%
							}
							else{
%>
								<label id="th_<%=recCount%>" style="display:none"></label> 
<%
							}
						}
						else if(!ord_loc.equals((String)result.get(i))&&((bean.getGroupByOrdLocn()).equals("Y"))) {
							ord_loc	=	result.get(i)==null?"":(String)result.get(i);		
%>
							<tr colspan="8"></tr><tr colspan="8"></tr><tr colspan="9"></tr>
								<td class="COLUMNHEADER" align="left" id="th_<%=recCount%>" colspan="10"><%=ord_loc%></td <!-- colspan changed from 9 to 10 for KDAH-CRF-0338 -->
<%	
								tmp_recCount	=	recCount;
						}
						else{
%>
							<label id="th_<%=recCount%>" style="display:none"></label> 
<%
						}
						patient_id=(String)result.get(i+1);
						//changed during PE BY Naveen	   		
						//allow_disp_record_lock_yn=bean.getAllowdisprecordlock(facility_id);
						allow_disp_record_lock_yn=bean.getAllow_disp_record_lock_yn();

						if(allow_disp_record_lock_yn.equals("Y")){
							lock_status=bean.getLockStatus(patient_id,disp_locn_code,login_user,disp_stage);
							ArrayList AccessRight=bean.getAccessRightStatus(login_user,patient_id,disp_locn_code,disp_stage);
				//commented during PE By Naveen
						   // Unlock_all_records_yn=bean.getUnLockRecordsYN(login_user,disp_locn_code);
							Unlock_all_records_yn=bean.geuUnlockAllRecordsYN();

							if(AccessRight.size()>0){
								for(int j=0; j<AccessRight.size(); j++){
									AccessRightMap = (HashMap)AccessRight.get(j);
									user_id = (String)AccessRightMap.get("user_id");
									locked_date_time = (String)AccessRightMap.get("locked_date_time");
								}
							}	 		    
						}
						else if(allow_disp_record_lock_yn.equals("N")){
							lock_status="0";
						}
%> 
						<tr id="tr_<%=recCount%>" style="display:">
							<td class="<%=classvalue%>"><%=sPriorityImg%></td>
							<td class="<%=classvalue%>" style="font-size:9px">
								<label style='cursor:pointer;color:blue;font-size:9px;font-weight:bold'  onMouseOver="showToolTip(this,'<%=result.get(i+7)%>','<%=result.get(i+6)%>','<%=result.get(i+5)%>','<%=result.get(i+8)%>')" onClick='if(CheckAccessRights("<%=login_user%>","<%=patient_id%>","<%=disp_locn_code%>","<%=disp_stage%>","<%=user_id%>","<%=recCount%>","<%=tmp_recCount%>","<%=recCount%>","<%=java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")%>","<%=result.get(i+7)%>","<%=result.get(i+6)%>","<%=java.net.URLEncoder.encode(ord_loc)%>","<%=allow_disp_record_lock_yn%>","<%=(String)result.get(i+14)%>")){collapse("<%=recCount%>","<%=tmp_recCount%>","<%=(String)result.get(i+1)%>");LockStatus("<%=user_id%>","<%=lock_status%>","<%=login_user%>","<%=patient_id%>","<%=disp_locn_code%>","<%=disp_stage%>","<%=allow_disp_record_lock_yn%>");displayOrdersForPatient("<%=recCount%>","<%=(String)result.get(i+1)%>","<%=java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")%>","<%=result.get(i+7)%>","<%=result.get(i+6)%>","<%=java.net.URLEncoder.encode(ord_loc)%>","<%=result.get(i+14)%>")}'  id="patient_id_label<%=recCount%>"><%=result.get(i+1)%>
								</label>
								<label  onClick='collapse("<%=recCount%>","<%=tmp_recCount%>","<%=(String)result.get(i+1)%>");displayOrdersForPatient("<%=recCount%>","<%=result.get(i+1)%>","<%=java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")%>","<%=result.get(i+7)%>","<%=result.get(i+6)%>","","<%=result.get(i+14)%>")'  id="<%="S"+result.get(i+1)%>">&nbsp;</label>  

<%								//added for GHL-CRF-0453 - start
								if(printValueForOrders!=null && printValueForOrders.size()>0)
									{
										print_value = "";
											print_spilt = (String)printValueForOrders.get(patient_id);//8/2/2017 GHL-CRF-0453
											if(print_spilt!=null){//GHL-CRF-0453
												min_value = ((String)printValueForOrders.get(patient_id)).split("~")[0];
												max_value = ((String)printValueForOrders.get(patient_id)).split("~")[1];
											}
						//System.err.println("DispMedicationPatientIDDisplay.jsp===print_msg=====877====>"+print_msg);
											if(Integer.parseInt(max_value)==1)
												print_value = "1";
											
										//	System.err.println("min_value=339=>"+min_value+"==max_value==>"+max_value);
											if(Integer.parseInt(min_value)!=Integer.parseInt(max_value))
												print_msg = "P";

											if(Integer.parseInt(min_value)!=0 && Integer.parseInt(min_value)==Integer.parseInt(max_value))
												print_msg = "F";

									//	System.err.println("DispMedicationPatientIDDisplay.jsp===print_msg=====346====>"+print_msg);
									}
%>								
									
<%								if(disp_stage.equals("F") || disp_stage.equals("A")){	//Added for IN:065140	
									if(print_value.equals("1")){
										if(print_msg.equals("F")){
%>
											<img  src="../../ePH/images/printed_fully.gif" height='20'  width='20' onmouseover = "showToolTipPrint(this,'Fully Printed')"></img>

						
<%											}else{ %>
											<img  src="../../ePH/images/printed_partial.gif" height='20'  width='20' onmouseover = "showToolTipPrint(this,'Partially Printed')"></img>


<%											}
									}
									}//added for GHL-CRF-0453 - end
%>								</td>

<%
								if(lock_status.equals("1")){
									if(Unlock_all_records_yn.equals("Y")){
%>
										<td class="<%=classvalue%>" style="font-size:9px"><label id="Logout_gif" style='cursor:pointer;color:blue;font-size:9px;font-weight:bold'  onMouseOver="showToolTipLockStatus(this,'<%=user_id%>','<%=locked_date_time%>')"onClick='UnLockRecord("<%=login_user%>","<%=patient_id%>","<%=disp_locn_code%>","<%=disp_stage%>","<%=Unlock_all_records_yn%>")'><b><img src='../../eCommon/images/enabled.gif'></B></td> 
<%
									}
									else if(Unlock_all_records_yn.equals("N")){
%>
										<td class="<%=classvalue%>" style="font-size:9px"><label id="Logout_gif" style='cursor:pointer;color:blue;font-size:9px;font-weight:bold'  onMouseOver="showToolTipLockStatus(this,'<%=user_id%>','<%=locked_date_time%>')"><b><img src='../../eCommon/images/enabled.gif'></B></td><%}
								   }
								   else if(lock_status.equals("0")||lock_status.equals("")){
%>
										<td class="<%=classvalue%>" style="font-size:9px"><b>&nbsp;</B></td>
<%
								   }
%>
									<input type="hidden" name="lock_status<%=recCount%>" id="lock_status<%=recCount%>" value="<%=lock_status%>">
								<td class="<%=classvalue%>" style="font-size:9px"><b><%=result.get(i+2)%></B>&nbsp;</td>
								<td class="<%=classvalue%>" style="font-size:9px"><b><%=com.ehis.util.DateUtils.convertDate((String)result.get(i+12),"DMYHM","en",locale)%></b>&nbsp;</td>
								<td class="<%=classvalue%>" style="font-size:9px"><label id="number_of_orders<%=recCount%>">&nbsp;<%=result.get(i+3)%></label></td>
								<td class="<%=classvalue%>" style="font-size:9px"><%=result.get(i+6)%></td>
<% 
							   if( ((String)result.get(i+7)).equals("M"))
									gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
								else if( ((String)result.get(i+7)).equals("F"))
									gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
								if( ((String)result.get(i+7)).equals("U"))
									gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
%>
								<td class="<%=classvalue%>" style="font-size:9px"><%=gender%></td>
								<td class="<%=classvalue%>" style="font-size:9px"><%=result.get(i+5)%></td>
<%  
 							//Added for ML-MMOH-SCF-1904
 							
								String pat_id=result.get(i+1)==null?"":(String)result.get(i+1);
								String enc_id=result.get(i+16)==null?"":(String)result.get(i+16);
								
								String locn_desc = bean.getPatientLocation(pat_id, enc_id);
								
							
								if(site){
									if((bean.getGroupByOrdLocn()).equals("N")&&!scope.equals("EX")){
%>
									<td class="<%=classvalue%>" style="font-size:9px"><%=locn_desc%></td>	
<%
									}
								}
								else{
									if((bean.getGroupByOrdLocn()).equals("N")&&!scope.equals("EX")){
%>
									<td class="<%=classvalue%>" style="font-size:9px"><%=result.get(i)%></td>					
<%
									}
								} //Modified for ML-MMOH-SCF-1904 -END
%>
                             <% if(  !((String) bean.getFillList()).equals("AF")){ //if  condtion is add for Ip with fill%>
                                <td class="<%=classvalue%>" style="font-size:9px"><%=result.get(i+18)%></td>  <!-- Added for KAUH-CRF-0338  -->
								 <%}
                             
								    if(bean.getDisp_locn_iae().contains("@@@")){ //Added  by Himanshu For MMS-DM-CRF-0232 starts
									 %>
									 <td class="<%=classvalue%>" style="font-size:9px"><%=dispname%></td>	
									 <%} %>	
								<input type="hidden" name="patient_id<%=recCount%>" id="patient_id<%=recCount%>" value="<%=result.get(i+1)%>">
							</tr>
							<tr>
								<td colspan='2' class="COLUMNHEADER" align="left" id="all_det_th_<%=recCount%>" style="font-size:9px;display:none"><%=ord_loc%></td>
							</tr>
							<tr id="all_det_<%=recCount%>" style="font-size:9px;display:none" width='70%'>
<%
								//String next_appt_days =bean.CheckForAppointments((String)result.get(i+1));
%>
								<td  class="<%=classvalue%>" style="font-size:9px;">
									<label id= "patient_bt<%=recCount%>" style='cursor:pointer;color:blue;font-size:9px;font-weight:bold'  onMouseOver="showToolTip(this,'<%=result.get(i+7)%>','<%=result.get(i+6)%>','<%=result.get(i+5)%>','<%=result.get(i+8)%>')" onClick='collapse("<%=recCount%>","<%=tmp_recCount%>","<%=(String)result.get(i+1)%>");displayOrdersForPatient("<%=recCount%>","<%=(String)result.get(i+1)%>","<%=java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")%>","<%=result.get(i+7)%>","<%=result.get(i+6)%>","<%=java.net.URLEncoder.encode(ord_loc)%>","<%=result.get(i+14)%>")' ><!--id added for Bru-HIMS-CRF-416[IN045566] -->
									<%=result.get(i+1)%></label>

									<label id="number_of_orders<%=recCount%>">&nbsp;(<%=result.get(i+3)%>)</label>
									<br><b><%=result.get(i+2)%></b>
								</td>
								<td  class="<%=classvalue%>" style="font-size:9px;" width='30%'>
<%
									//if(!next_appt_days.equals("")){
%>
										<img src='../../ePH/images/MI_View-ScheduleAppionment.gif' title='<fmt:message key="ePH.APPOINTMENTLIST.label" bundle="${ph_labels}"/>' style="display:none;cursor:pointer;width:20;height:20" id="appt_list_<%=recCount%>" onClick="DiplayAppointmentDtls('<%=result.get(i+1)%>','<%=sysdate%>','<%=getDate_plus_365%>')" >
										<label id="next_appt_days<%=recCount%>"></label>
<%
									//} &nbsp;(<%/*=next_appt_days%*/>)
									if(  !((String) bean.getFillList()).equals("AF")){//if  condtion is add for Ip with fill
									bed_no = (String)result.get(i+18)==null?"":(String)result.get(i+18); }// Added for KDAH-CRF-0338 
%>
								</td>
							</tr>
							<input type='hidden' name='Ordering_Facility_id_<%=recCount%>' id='Ordering_Facility_id_<%=recCount%>' value = '<%=result.get(i+14)%>'>
							<input type='hidden' name='encounter_id<%=recCount%>' id='encounter_id<%=recCount%>' value ='<%=result.get(i+15)%>'><!-- added for RUT-CRF-0083.5 [IN:041511] Start -->
							<input type='hidden' name='episode_id<%=recCount%>' id='episode_id<%=recCount%>' value ='<%=result.get(i+16)%>'>
							<input type='hidden' name='patient_class<%=recCount%>' id='patient_class<%=recCount%>' value ='<%=result.get(i+17)%>'> <!-- added for RUT-CRF-0083.5 [IN:041511] -End -->							
							<input type='hidden' name='desp_name_code<%=recCount%>' id='desp_name_code<%=recCount%>' value ='<%=desp_name_code%>'>							
							
							<% if(  !((String) bean.getFillList()).equals("AF")){ 
									//if  condtion is add for Ip with fill %>
								<input type='hidden' name='bed_num<%=recCount%>' id='bed_num<%=recCount%>' value ='<%=bed_no%>'> <!-- added for KDAH-CRF-0338 -->
								<% if(bean.getDisp_locn_iae().contains("@@@")){ //modified  by Himanshu For MMS-DM-CRF-0232 %>
								<input type='hidden' name='locn_code<%=recCount%>' id='locn_code<%=recCount%>' value ='<%=result.get(i+20)%>'> <!-- index Will be 20 for location code if All option is selected in Dispence loc -->
								<% }else{ %>
								<input type='hidden' name='locn_code<%=recCount%>' id='locn_code<%=recCount%>' value ='<%=result.get(i+19)%>'> <!-- added for BSP-SCF-0060 -->
	<%                     }
								}else{%>
								<input type='hidden' name='locn_code<%=recCount%>' id='locn_code<%=recCount%>' value ='<%=result.get(i+18)%>'> <!-- added for MMS-ME-SCF-0001 -->
	<%                          }
							recCount++;
						}
					}else if(disp_locn_catg.equals("IAE") && isSite_integration_em_bd_pyxis)
					{

						classvalue	= "";
						for(int i=0;i<result.size();i=i+resultSize){
							if(recCount%2==0){
								classvalue = "QRYODD";
							}
							else{
								classvalue = "QRYEVEN";
							}
							if(i==0){
								++i;
							}
							
							//Added  by Himanshu For MMS-DM-CRF-0232 starts
							if(isSite_integration_em_bd_pyxis){
									if(bean.getDisp_locn_iae().contains("@@@"))
									{
									desp_name_code_loc=(String) result.get(i+19);
									String desp_code_loc[]=	desp_name_code_loc.split(" &&& ");
									//bean.setDisp_locn_codeall(desp_code_loc[0]); // this is created for getOrders(patient id) for all dispnce location scenario
									desp_name_code=desp_code_loc[0];
									dispname=desp_code_loc[1];
									 }else
									 {
										// bean.setDisp_locn_codeall(bean.getDisp_locn_iae());
										desp_name_code=bean.getDisp_locn_iae();
									 }
							}
							//Added  by Himanshu For MMS-DM-CRF-0232 ends
							
							
							sPriorityImg = result.get(i+11).toString().equals("U")?"<img src='../../ePH/images/Urgent.gif' style='width:14;height:10' title='"+sUrgentTitle+"' />":"&nbsp;";
							if(tab_based_group_sort_disp.equals("Y") && !customGroupBy.equals("NONE")  ){
							
								if(customGroupBy.equals("NURSING_UNIT"))
									customGroupByHeader = (String)result.get(i);
								if(customGroupBy.equals("RELEASE_DATE_TIME")){
									customGroupByHeader = com.ehis.util.DateUtils.convertDate((String)result.get(i+12),"DMYHM","en",locale);
									customGroupByHeader = customGroupByHeader.substring(0,10);
								}
								if(customGroupBy.equals("ORD_DATE_TIME")){
									customGroupByHeader = com.ehis.util.DateUtils.convertDate((String)result.get(i+13),"DMY","en",locale);
									customGroupByHeader = customGroupByHeader.substring(0,10);
								}
								if(customGroupBy.equals("PRIORITY"))
									customGroupByHeader = (String)result.get(i+11);
								if(customGroupBy.equals("PERFORMING_DEPTLOC_CODE") && bean.getDisp_locn_iae().contains("@@@"))
									customGroupByHeader = dispname;
								if(!prevCustomGroupByHeader.equals(customGroupByHeader)){
									prevCustomGroupByHeader = customGroupByHeader ;
									newaeheader=true;
	%>
									<tr colspan="8"></tr>
										<td class="COLUMNHEADER" align="left" id="th_<%=recCount%>" colspan="12"><b><%=customGroupByHeader%></b></td> <!-- colspan="10" Changed to colspan="11" for KDAH-CRF-0338 -->
									
									
	<%
								}
								else{
	%>
									<label id="th_<%=recCount%>" style="display:none"></label> 
	<%
								}
							}
							else if(!ord_loc.equals((String)result.get(i))&&((bean.getGroupByOrdLocn()).equals("Y"))) {
								ord_loc	=	result.get(i)==null?"":(String)result.get(i);		
	%>
								<tr colspan="8"></tr><tr colspan="8"></tr><tr colspan="9"></tr>
									<td class="COLUMNHEADER" align="left" id="th_<%=recCount%>" colspan="10"><%=ord_loc%></td <!-- colspan changed from 9 to 10 for KDAH-CRF-0338 -->
	<%	
									tmp_recCount	=	recCount;
							}
							else{
	%>
								<label id="th_<%=recCount%>" style="display:none"></label> 
	<%
							}
							///////////////////////////////////////////////////////////////////////////////////////
							if(customGroupBy.equals("NONE")){
							if(patient_class.equals("")|| !(patient_class.equals(((String)result.get(i+17))))){
								patient_class =result.get(i+17)==null?"":(String)result.get(i+17);
								
								if(patient_class.equals("IP"))
							{
								patient_class_temp="Inpatients";
							}else if(patient_class.equals("EM"))
							{
								patient_class_temp="AE patients";
							}else
							{
								patient_class_temp="";
							}
							
								flag1="Y";
							}
							if(flag1.equals("Y")){
								if(patient_class.equals("N")){
%>
									<tr colspan="8"></tr>
										<td class="COLUMNHEADER" align="left" id="th1" colspan="12"><center><b><%=patient_class_temp%></b></center></td>
									</tr>
<%
								}
								else{
%>
									<tr colspan="8"></tr>
										<td class="COLUMNHEADER" align="left" id="th1" colspan="12"><center><b><%=patient_class_temp%></b></center></td>
									</tr>
<%	
								}
								flag1="N";
							}
							}
							
							
							if(patient_class.equals("")|| !(patient_class.equals(((String)result.get(i+17)))))
							{
								newaeheader=true;
									patient_class =result.get(i+17)==null?"":(String)result.get(i+17);
												
												if(patient_class.equals("IP"))
											{
												patient_class_temp="Inpatients";
											}else if(patient_class.equals("EM"))
											{
												patient_class_temp="AE patients";
											}else
											{
												patient_class_temp="";
											}
							}
							if(newaeheader){
								%>
								<tr colspan="8"></tr>
									<td class="COLUMNHEADER" align="left" id="th1" colspan="12"><center><b><%=patient_class_temp%></b></center></td>
								</tr><%
								newaeheader=false;
							}
							
							patient_id=(String)result.get(i+1);
							//changed during PE BY Naveen	   		
							//allow_disp_record_lock_yn=bean.getAllowdisprecordlock(facility_id);
							allow_disp_record_lock_yn=bean.getAllow_disp_record_lock_yn();

							if(allow_disp_record_lock_yn.equals("Y")){
								lock_status=bean.getLockStatus(patient_id,disp_locn_code,login_user,disp_stage);
								ArrayList AccessRight=bean.getAccessRightStatus(login_user,patient_id,disp_locn_code,disp_stage);
					//commented during PE By Naveen
							   // Unlock_all_records_yn=bean.getUnLockRecordsYN(login_user,disp_locn_code);
								Unlock_all_records_yn=bean.geuUnlockAllRecordsYN();

								if(AccessRight.size()>0){
									for(int j=0; j<AccessRight.size(); j++){
										AccessRightMap = (HashMap)AccessRight.get(j);
										user_id = (String)AccessRightMap.get("user_id");
										locked_date_time = (String)AccessRightMap.get("locked_date_time");
									}
								}	 		    
							}
							else if(allow_disp_record_lock_yn.equals("N")){
								lock_status="0";
							}
	%> 
							<tr id="tr_<%=recCount%>" style="display:">
								<td class="<%=classvalue%>"><%=sPriorityImg%></td>
								<td class="<%=classvalue%>" style="font-size:9px">
									<label style='cursor:pointer;color:blue;font-size:9px;font-weight:bold'  onMouseOver="showToolTip(this,'<%=result.get(i+7)%>','<%=result.get(i+6)%>','<%=result.get(i+5)%>','<%=result.get(i+8)%>')" onClick='if(CheckAccessRights("<%=login_user%>","<%=patient_id%>","<%=disp_locn_code%>","<%=disp_stage%>","<%=user_id%>","<%=recCount%>","<%=tmp_recCount%>","<%=recCount%>","<%=java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")%>","<%=result.get(i+7)%>","<%=result.get(i+6)%>","<%=java.net.URLEncoder.encode(ord_loc)%>","<%=allow_disp_record_lock_yn%>","<%=(String)result.get(i+14)%>")){collapse("<%=recCount%>","<%=tmp_recCount%>","<%=(String)result.get(i+1)%>");LockStatus("<%=user_id%>","<%=lock_status%>","<%=login_user%>","<%=patient_id%>","<%=disp_locn_code%>","<%=disp_stage%>","<%=allow_disp_record_lock_yn%>");displayOrdersForPatient("<%=recCount%>","<%=(String)result.get(i+1)%>","<%=java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")%>","<%=result.get(i+7)%>","<%=result.get(i+6)%>","<%=java.net.URLEncoder.encode(ord_loc)%>","<%=result.get(i+14)%>")}'  id="patient_id_label<%=recCount%>"><%=result.get(i+1)%>
									</label>
									<label  onClick='collapse("<%=recCount%>","<%=tmp_recCount%>","<%=(String)result.get(i+1)%>");displayOrdersForPatient("<%=recCount%>","<%=result.get(i+1)%>","<%=java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")%>","<%=result.get(i+7)%>","<%=result.get(i+6)%>","","<%=result.get(i+14)%>")'  id="<%="S"+result.get(i+1)%>">&nbsp;</label>  

	<%								//added for GHL-CRF-0453 - start
									if(printValueForOrders!=null && printValueForOrders.size()>0)
										{
											print_value = "";
												print_spilt = (String)printValueForOrders.get(patient_id);//8/2/2017 GHL-CRF-0453
												if(print_spilt!=null){//GHL-CRF-0453
													min_value = ((String)printValueForOrders.get(patient_id)).split("~")[0];
													max_value = ((String)printValueForOrders.get(patient_id)).split("~")[1];
												}
												if(Integer.parseInt(max_value)==1)
													print_value = "1";
												
											//	System.err.println("min_value=339=>"+min_value+"==max_value==>"+max_value);
												if(Integer.parseInt(min_value)!=Integer.parseInt(max_value))
													print_msg = "P";

												if(Integer.parseInt(min_value)!=0 && Integer.parseInt(min_value)==Integer.parseInt(max_value))
													print_msg = "F";

										//	System.err.println("DispMedicationPatientIDDisplay.jsp===print_msg=====346====>"+print_msg);
										}
	%>								
										
	<%								if(disp_stage.equals("F") || disp_stage.equals("A")){	//Added for IN:065140	
										if(print_value.equals("1")){
											if(print_msg.equals("F")){
	%>
												<img  src="../../ePH/images/printed_fully.gif" height='20'  width='20' onmouseover = "showToolTipPrint(this,'Fully Printed')"></img>

							
	<%											}else{ %>
												<img  src="../../ePH/images/printed_partial.gif" height='20'  width='20' onmouseover = "showToolTipPrint(this,'Partially Printed')"></img>


	<%											}
										}
										}//added for GHL-CRF-0453 - end
	%>								</td>

	<%
									if(lock_status.equals("1")){
										if(Unlock_all_records_yn.equals("Y")){
	%>
											<td class="<%=classvalue%>" style="font-size:9px"><label id="Logout_gif" style='cursor:pointer;color:blue;font-size:9px;font-weight:bold'  onMouseOver="showToolTipLockStatus(this,'<%=user_id%>','<%=locked_date_time%>')"onClick='UnLockRecord("<%=login_user%>","<%=patient_id%>","<%=disp_locn_code%>","<%=disp_stage%>","<%=Unlock_all_records_yn%>")'><b><img src='../../eCommon/images/enabled.gif'></B></td> 
	<%
										}
										else if(Unlock_all_records_yn.equals("N")){
	%>
											<td class="<%=classvalue%>" style="font-size:9px"><label id="Logout_gif" style='cursor:pointer;color:blue;font-size:9px;font-weight:bold'  onMouseOver="showToolTipLockStatus(this,'<%=user_id%>','<%=locked_date_time%>')"><b><img src='../../eCommon/images/enabled.gif'></B></td><%}
									   }
									   else if(lock_status.equals("0")||lock_status.equals("")){
	%>
											<td class="<%=classvalue%>" style="font-size:9px"><b>&nbsp;</B></td>
	<%
									   }
	%>
										<input type="hidden" name="lock_status<%=recCount%>" id="lock_status<%=recCount%>" value="<%=lock_status%>">
									<td class="<%=classvalue%>" style="font-size:9px"><b><%=result.get(i+2)%></B>&nbsp;</td>
									<td class="<%=classvalue%>" style="font-size:9px"><b><%=com.ehis.util.DateUtils.convertDate((String)result.get(i+12),"DMYHM","en",locale)%></b>&nbsp;</td>
									<td class="<%=classvalue%>" style="font-size:9px"><label id="number_of_orders<%=recCount%>">&nbsp;<%=result.get(i+3)%></label></td>
									<td class="<%=classvalue%>" style="font-size:9px"><%=result.get(i+6)%></td>
	<% 
								   if( ((String)result.get(i+7)).equals("M"))
										gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
									else if( ((String)result.get(i+7)).equals("F"))
										gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
									if( ((String)result.get(i+7)).equals("U"))
										gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
	%>
									<td class="<%=classvalue%>" style="font-size:9px"><%=gender%></td>
									<td class="<%=classvalue%>" style="font-size:9px"><%=result.get(i+5)%></td>
	<%  
	 							//Added for ML-MMOH-SCF-1904
	 							
									String pat_id=result.get(i+1)==null?"":(String)result.get(i+1);
									String enc_id=result.get(i+16)==null?"":(String)result.get(i+16);
									
									String locn_desc = bean.getPatientLocation(pat_id, enc_id);
									
								
									if(site){
										if((bean.getGroupByOrdLocn()).equals("N")&&!scope.equals("EX")){
	%>
										<td class="<%=classvalue%>" style="font-size:9px"><%=locn_desc%></td>	
	<%
										}
									}
									else{
										if((bean.getGroupByOrdLocn()).equals("N")&&!scope.equals("EX")){
	%>
										<td class="<%=classvalue%>" style="font-size:9px"><%=result.get(i)%></td>					
	<%
										}
									} //Modified for ML-MMOH-SCF-1904 -END
	%>
	                             <% if(  !((String) bean.getFillList()).equals("AF")){ //if  condtion is add for Ip with fill%>
	                                <td class="<%=classvalue%>" style="font-size:9px"><%=result.get(i+18)%></td>  <!-- Added for KAUH-CRF-0338  -->
									 <%}
	                             if(bean.getDisp_locn_iae().contains("@@@")){ //Added  by Himanshu For MMS-DM-CRF-0232 
									 %>
									 <td class="<%=classvalue%>" style="font-size:9px"><%=dispname%></td>	
									 <%} %>	
									<input type="hidden" name="patient_id<%=recCount%>" id="patient_id<%=recCount%>" value="<%=result.get(i+1)%>">
								</tr>
								<tr>
									<td colspan='2' class="COLUMNHEADER" align="left" id="all_det_th_<%=recCount%>" style="font-size:9px;display:none"><%=ord_loc%></td>
								</tr>
								<tr id="all_det_<%=recCount%>" style="font-size:9px;display:none" width='70%'>
	<%
									//String next_appt_days =bean.CheckForAppointments((String)result.get(i+1));
	%>
									<td  class="<%=classvalue%>" style="font-size:9px;">
										<label id= "patient_bt<%=recCount%>" style='cursor:pointer;color:blue;font-size:9px;font-weight:bold'  onMouseOver="showToolTip(this,'<%=result.get(i+7)%>','<%=result.get(i+6)%>','<%=result.get(i+5)%>','<%=result.get(i+8)%>')" onClick='collapse("<%=recCount%>","<%=tmp_recCount%>","<%=(String)result.get(i+1)%>");displayOrdersForPatient("<%=recCount%>","<%=(String)result.get(i+1)%>","<%=java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")%>","<%=result.get(i+7)%>","<%=result.get(i+6)%>","<%=java.net.URLEncoder.encode(ord_loc)%>","<%=result.get(i+14)%>")' ><!--id added for Bru-HIMS-CRF-416[IN045566] -->
										<%=result.get(i+1)%></label>

										<label id="number_of_orders<%=recCount%>">&nbsp;(<%=result.get(i+3)%>)</label>
										<br><b><%=result.get(i+2)%></b>
									</td>
									<td  class="<%=classvalue%>" style="font-size:9px;" width='30%'>
	<%
										//if(!next_appt_days.equals("")){
	%>
											<img src='../../ePH/images/MI_View-ScheduleAppionment.gif' title='<fmt:message key="ePH.APPOINTMENTLIST.label" bundle="${ph_labels}"/>' style="display:none;cursor:pointer;width:20;height:20" id="appt_list_<%=recCount%>" onClick="DiplayAppointmentDtls('<%=result.get(i+1)%>','<%=sysdate%>','<%=getDate_plus_365%>')" >
											<label id="next_appt_days<%=recCount%>"></label>
	<%
										//} &nbsp;(<%/*=next_appt_days%*/>)
										if(  !((String) bean.getFillList()).equals("AF")){//if  condtion is add for Ip with fill
										bed_no = (String)result.get(i+18)==null?"":(String)result.get(i+18); }// Added for KDAH-CRF-0338 
	%>
									</td>
								</tr>
								<input type='hidden' name='Ordering_Facility_id_<%=recCount%>' id='Ordering_Facility_id_<%=recCount%>' value = '<%=result.get(i+14)%>'>
								<input type='hidden' name='encounter_id<%=recCount%>' id='encounter_id<%=recCount%>' value ='<%=result.get(i+15)%>'><!-- added for RUT-CRF-0083.5 [IN:041511] Start -->
								<input type='hidden' name='episode_id<%=recCount%>' id='episode_id<%=recCount%>' value ='<%=result.get(i+16)%>'>
								<input type='hidden' name='patient_class<%=recCount%>' id='patient_class<%=recCount%>' value ='<%=result.get(i+17)%>'> <!-- added for RUT-CRF-0083.5 [IN:041511] -End -->							
								<input type='hidden' name='desp_name_code<%=recCount%>' id='desp_name_code<%=recCount%>' value ='<%=desp_name_code%>'>					
								
								<% if(  !((String) bean.getFillList()).equals("AF")){ 
									
									
									//if  condtion is add for Ip with fill %>
								<input type='hidden' name='bed_num<%=recCount%>' id='bed_num<%=recCount%>' value ='<%=bed_no%>'> <!-- added for KDAH-CRF-0338 -->
								<% if(bean.getDisp_locn_iae().contains("@@@")){ //modified  by Himanshu For MMS-DM-CRF-0232 starts%>
								<input type='hidden' name='locn_code<%=recCount%>' id='locn_code<%=recCount%>' value ='<%=result.get(i+20)%>'> <!-- index Will be 20 for location code if All option is selected in Dispense loc -->
								<% }else{ %>
								<input type='hidden' name='locn_code<%=recCount%>' id='locn_code<%=recCount%>' value ='<%=result.get(i+19)%>'> <!-- added for BSP-SCF-0060 -->
	<%                     }
								}else{
		//else added for MMS-ME-SCF-001
		%>
								<input type='hidden' name='locn_code<%=recCount%>' id='locn_code<%=recCount%>' value ='<%=result.get(i+18)%>'> <!-- added for MMS-ME-SCF-0001 -->
	<%                          }
								recCount++;
							}
						
					}
%>
			</table>
			<input type="hidden" name="tot_rec" id="tot_rec" value="<%=recCount%>">
			<input type="hidden" name="sel_rec" id="sel_rec" value="">
			<input type="hidden" name="disp_locn_catg" id="disp_locn_catg" value="<%=disp_locn_catg%>">
			<input type="hidden" name="print_yn" id="print_yn" value="<%=bean.getUserPrintYN()%>">
			<input type="hidden" name="from" id="from" id="from" value="">
			<input type="hidden" name="to" id="to" id="to" value="">
			<input type="hidden" name="orderType" id="orderType" value="<%=bean.getOrderType()%>"/>
			<input type="hidden" name="function_id" id="function_id" value="<%=bean.getSFunctionId()%>">
			<input type="hidden" name="criteria_patient_id" id="criteria_patient_id" value="<%=criteria_patient_id%>">
			<input type="hidden" name="headerCount" id="headerCount" value="<%=tmp_recCount%>">
			<input type="hidden" name="tab_based_group_sort_disp" id="tab_based_group_sort_disp" value="<%=tab_based_group_sort_disp%>">
			<input type="hidden" name="login_user" id="login_user" value="<%=login_user%>">
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="ptindex" id="ptindex" value="<%=ptindex%>"><!-- added for Bru-HIMS-CRF-416[IN045566] -->
			<input type="hidden" name="relflag" id="relflag" value="<%=relflag%>"><!-- added for Bru-HIMS-CRF-416[IN045566] -->
			<input type="hidden" name="refresh_pat_details" id="refresh_pat_details" value="<%=refresh_pat_details%>"><!-- Added for TH-KW-CRF-0011 -->
			
			<!-- Added for MMS-DM-CRF-0228 start --> 
			<input type="hidden" name="ph_print_prescription" id="ph_print_prescription" id="ph_print_prescription" value="<%=ph_print_prescription%>">
			<input type="hidden" name="mode" id="mode" id="mode" value="">
			<input type="hidden" name="maxdisplay" id="maxdisplay" id="maxdisplay" value="<%=maxDisplay%>">
			<input type="hidden" name="maxdisplay1" id="maxdisplay1" id="maxdisplay1" value="<%=maxDisplay1%>">
			<input type="hidden" name="searchthreshold" id="searchthreshold" id="searchthreshold" value="<%=searchThreshold%>">
			<input type="hidden" name="Hit_Limit" id="Hit_Limit" value="<%=Hit%>">
			<input type="hidden" name="searchBasedOn" id="searchBasedOn" id="searchBasedOn" value="">
			<!-- Added for MMS-DM-CRF-0228 end --> 
			
		</form>
	</body>
</html>
<script language="javascript">
<%
	if((result.size()==9 && disp_locn_catg.equals("O"))){
%>
		document.getElementById("patient_id_label0").click();
		document.getElementById("patientiddisplaytable").rows(1).cells(0).style.backgroundColor	= "#fde6d0";
<%
	}
	else if((result.size()==9 && disp_locn_catg.equals("I"))){
%>
		//document.getElementById("patient_id_label0").click();
		//document.getElementById("patientiddisplaytable").rows(1).cells(0).style.backgroundColor	= "#fde6d0";
<%
	}

	if(criteria_patient_id!=null && !criteria_patient_id.equals("") && recCount>0 ){
%>
		loadPatientDRugDtl('<%=criteria_patient_id%>');
<%
	}
%>
	function showToolTip(obj,sex,age,nationality,national_id_no){
		if(sex=="M")
			sex= "         "+getLabel("Common.Sex.label","Common") +" : " + getLabel("Common.male.label","Common");
		else if(sex=="F")
			sex="         "+getLabel("Common.Sex.label","Common") +" : " + getLabel("Common.female.label","Common");
		else 
			sex="         "+ getLabel("Common.Sex.label","Common") +" : " + getLabel("Common.Both.label","Common");
		//age ="           Age : "+age;
		age ="         "+getLabel("Common.age.label","Common")+" : "+age;
		if(nationality!="null")
			nationality = "\n "+getLabel("Common.nationality.label","Common")+" : "+nationality;
		else
			nationality = "";
		
		obj.title=sex+"\n"+age+nationality;
		if(national_id_no!="null")
			national_id_no = "\nNational ID No : "+national_id_no;
		else
			national_id_no = "";
	}
	tryLocatingPatient();
	//parent.parent.parent.document.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.disabled=false;
	const button = document.getElementById("btnSearch");
	if (button) {
		button.disabled = false;
		}
<%
		if(!order_id.equals("")){ //Added for JD-CRF-0181[IN045511]
%>
			document.getElementById("patient_id_label0").click();
<%
		}
%>	
	</script>
<%
		}
		putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}finally{ //CRF-413.8
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
	}
%>

