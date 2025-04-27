<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.util.*, eSS.Common.*, eSS.* " contentType="text/html;charset=UTF-8"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id				=		request.getParameter("bean_id");
	String bean_name			=		request.getParameter("bean_name");
	int functionType			=		Integer.parseInt(request.getParameter("function_type"));
	String user_name = (String) session.getValue("login_user");
	//System.err.println("user_name"+user_name);

	if ((bean_id == null) || (bean_id.equals("")))
		return;
	ReturnGroupBean bean		= (ReturnGroupBean) getBeanObject(bean_id, bean_name , request);
	Hashtable hash				= (Hashtable) XMLobj.parseXMLString(request);
    hash						= (Hashtable) hash.get ("SEARCH");
	
	switch (functionType) {
		case 1: 
			{
					if (hash.size() > 0) {
						bean.updateSelectedTrays(hash);
					}
			}
			break;
		case 2: 
			{	
					String group_code		=	(String) hash.get("group_code");
					String tray_no			=	(String) hash.get("tray_no");
					String selected_index	=	(String) hash.get("selected_index");
					if ((group_code.trim().equals("")) || (tray_no.trim().equals(""))) {
						out.println("errorDisplay();");
						return;
					}
					bean.setGroup_code(group_code);
					bean.setTray_no(tray_no);
					out.println("clearListItems('parent.frameReturnGroupDetail.document.formReturnGroupDetail.bin_location_code'); ");
					ArrayList binLocation = bean.getBinLocations();
					for(int i=0; i< binLocation.size(); i++) {
						String[] record = (String[])binLocation.get(i);
						out.println("addListItem(\"parent.frameReturnGroupDetail.document.formReturnGroupDetail.bin_location_code\", \"" + record[0] + "\",\"" + record[1] + "\");");
					}
					binLocation = null;

					int index = Integer.parseInt(selected_index);
					String[] trayDetails = bean.getTrayDetail(index);
					out.println("setBinlocation('"+trayDetails[3]+"');");
					out.println("setExpired('"+trayDetails[7].equals("Y")+"');");
					out.println("setUsed('"+((String)trayDetails[8]).equals("Y")+"');");
					if (trayDetails[6] == null)
						out.println("setPatientID('');");
					else 
						out.println("setPatientID('"+trayDetails[6]+"');");
					String pname="";
					if (trayDetails[16] != null) {
						pname = trayDetails[16];
						//Added by Rabbani #Inc no:42059 (ML-BRU-SCF-0960) on 07-AUG-2013
						pname = pname.replaceAll(" ","%20");
					    pname = java.net.URLEncoder.encode(pname,"UTF-8");
					    pname = pname.replaceAll("%2520","%20");
						
					}
					out.println("setPatientName('"+pname+"');"); 
					if (trayDetails[9] != null) {
						HashMap hmTemp=bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_GROUP_SELECT_SINGLE"), group_code);	
						String sterilize_reqd_yn	=	(String)hmTemp.get("STERILIZE_REQD_YN");
						if (sterilize_reqd_yn.equals("Y")){
							out.println("setSterilization(true);");
						}
						else
							out.println("setSterilization(false);");
					}
					else 
						out.println("setSterilization('false');");
					if (trayDetails[10] != null) {
						out.println("setWashing("+((String)trayDetails[10]).equals("Y")+");");
					}
					else 
						out.println("setWashing('false');");
					if (trayDetails[11] != null)
						out.println("setPacking("+((String)trayDetails[11]).equals("Y")+");");
					else 
						out.println("setPacking('false');");
					if (trayDetails[12] != null)
						out.println("setContaminated("+((String)trayDetails[12]).equals("Y")+");");
					else
						out.println("setContaminated('false');");
					if (trayDetails[13] != null)
						out.println("setChargeConsumable("+((String)trayDetails[13]).equals("Y")+");");

					//Bru-HIMS-CRF-360
					String remarks  = trayDetails[22];
					
					if (remarks == null || remarks.equals("")) {
						out.println("setRemarks('');");
					}else{ 
							String remarks_desc = bean.checkForNull(trayDetails[23]);
							remarks_desc = remarks_desc.replaceAll(" ","%20");
							remarks_desc = java.net.URLEncoder.encode(remarks_desc,"UTF-8");
							remarks_desc = remarks_desc.replaceAll("%2520","%20");
							out.println("setRemarks('"+remarks_desc+"','"+remarks+"');");
						}
					
						
						if (trayDetails[6] == null || trayDetails[6].equals("")) {
						out.println("parent.frameReturnGroupDetail.document.formReturnGroupDetail.img_remarks.style.visibility = 'visible';");
						}else{
						out.println("parent.frameReturnGroupDetail.document.formReturnGroupDetail.img_remarks.style.visibility = 'hidden';");
						}
				//ENDS	

			}
			break;
		case 3: // To enable or disable document no
			{
					String doc_type_code = (String) hash.get("doc_type_code");
					if (doc_type_code.trim().equals("")) {
						out.println("errorDisplay();");
						return;
					}
					if (!bean.isDocNoAutoGenYN(doc_type_code)) 
						out.println("enableDocNo();");
					else 
						out.println("disableDocNo();");
			}
			break;
		case 4: 
			{
					String from_store_code =  (String) hash.get("return_from");
					String to_store_code =  (String) hash.get("return_to");
					bean.setFr_store_code(from_store_code);
					bean.setTo_store_code(to_store_code);
					bean.clearSelectedTrays();
					out.println("clearListItems('parent.frameReturnGroupDetail.document.formReturnGroupDetail.bin_location_code'); ");
					ArrayList binLocation = bean.getBinLocations();
					for(int i=0; i< binLocation.size(); i++) {
						String[] record = (String[])binLocation.get(i);
						out.println("addListItem(\"parent.frameReturnGroupDetail.document.formReturnGroupDetail.bin_location_code\", \"" + record[0] + "\",\"" + record[1] + "\");");
					}
					binLocation = null;
			}
			break;
		case 5: 
			{
					String patient_id =  (String) hash.get("patient_id");
					bean.setPatient_id(patient_id);
					//Added by Rabbani #Inc no:42059 (ML-BRU-SCF-0960) on 07-AUG-2013
					 String patient_name  =  bean.checkForNull(bean.getPatientName());
							 if(!patient_name.equals("")){
					           patient_name = patient_name.replaceAll(" ","%20");
					           patient_name = java.net.URLEncoder.encode(patient_name,"UTF-8");
					           patient_name = patient_name.replaceAll("%2520","%20");
				               }
					out.println("setPatientName('"+patient_name+"');");
					patient_id = null;
			}
			break;
		case 6: 
			{
					String bin_desc=request.getParameter("bin_desc");
					if (hash.size() > 0) {
						bean.updateSelectedTraysValues(hash,bin_desc);
						
					}
			}
			break;
		case 7:
			{
				int isValidDocDate = -1;
				String doc_date = (String) hash.get("doc_date");
				if (doc_date.trim().equals("")) {
					out.println("errorDisplay();"); // To be replaced with proper message
					return;
				}
				isValidDocDate = bean.isValidDocDate(doc_date);
				String errorCode = null;
				if (isValidDocDate > 0) {
					if (isValidDocDate== 1) {
						errorCode = "DOC_DT_NOT_LT_PROC_MTH";
					}
					else if (isValidDocDate== 2) {
						errorCode = "DOC_DT_NOT_GR_SYSDATE";
					}
					out.println("requestDocDateFocus();");
					out.println("assignResult(false,getMessage(\""+errorCode+"\",'SS'), \"0\")");
				} 
				else {
					out.println("assignResult(true,\"\", \"0\");");
					return;
				}
			}
			break;
		case 8:
			{
				boolean vaildEncounter = false;
				String encounter_id = (String) hash.get("encounter_id");
				String patient_id = (String) hash.get("patient_id");
				vaildEncounter = bean.validateEncounter(encounter_id,patient_id);
				if (!vaildEncounter) {
					out.println("requestEncounterIDFocus();");
					return;
				}
			}
			break;
		case 9:
			{
					java.util.HashMap hmResult = null;

					ArrayList alParameters	=	new ArrayList();
					alParameters.add(hash.get("group_code"));
					alParameters.add(new Long((String)hash.get("tray_no")));
					alParameters.add(hash.get("item_code"));
					alParameters.add("N");
					alParameters.add(new Long((String)hash.get("discrepancy_qty")));
					boolean canProceed = ((HashMap)bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_VALIDATE_DISCREPANCY_QTY_SELECT"),alParameters)).get("MESSAGE").toString().equals("NO_ERROR");
					if (!canProceed) {
						out.println("assignResult(false, \"INVALID_DISCREPANCY_QTY_MSG\", \"0\" ) ; ") ;
						return;
					}

					if (hash.size() > 0) {
						hmResult = bean.updateDiscrepancyDetail(hash);
					}
					boolean result = ((Boolean)hmResult.get("result")).booleanValue();
					String message = (String)hmResult.get("msgid");
					String flag = (String)hmResult.get("flag");
					out.println("assignResult(" + result + ", \"" + message + "\", \""+flag+"\" ) ; ") ;
			}
			break;
		case 10:
			{
					/*
						Update for the discrepancy records to be processed !
					*/

					if (hash.size() > 0) {
						bean.setDescrepancy();
						bean.updateSelectedDiscrepancyDetail(hash);
					}
			}
			break;
		case 11:
			{
					String discrepancy_key = (String) hash.get("selected_discrepancy");
					
					String[] discrepancy_details = bean.getSelectedDiscrepancyDetail(discrepancy_key);
				
					out.println("var arrayObject = new Array();");
					out.println("arrayObject[0] = '"+bean.checkForNull(discrepancy_details[2])+"';");
					out.println("arrayObject[1] = '"+bean.checkForNull(discrepancy_details[4])+"';");
					out.println("arrayObject[2] = '"+bean.checkForNull(discrepancy_details[5])+"';");
					out.println("arrayObject[3] = '"+bean.checkForNull(discrepancy_details[6])+"';");
					out.println("arrayObject[4] = '"+bean.checkForNull(discrepancy_details[7])+"';");
					out.println("arrayObject[5] = '"+bean.checkForNull(discrepancy_details[8])+"';");
					out.println("arrayObject[6] = '"+bean.checkForNull(discrepancy_details[14])+"';");
					out.println("arrayObject[7] = '"+bean.checkForNull(discrepancy_details[11])+"';");
					out.println("arrayObject[8] = '"+bean.checkForNull(discrepancy_details[10])+"';");
					out.println("arrayObject[9] = '"+bean.checkForNull(discrepancy_details[17])+"';");
					out.println("editDiscrepancyDetail(arrayObject);");
					bean.setItem_code(bean.checkForNull(discrepancy_details[2]));
					bean.setCurrentEditingDiscrepancy(discrepancy_key);
			}
			break;
		case 12 :
			{
				bean.setCurrentEditingDiscrepancy(null);
			}
			break;
		case 13 :
			{
				bean.resetDetails();
			}
			break;
		case 14 :
			{
				String itemCode = (String) hash.get("item_code");
				int itemQty = Integer.parseInt((String) hash.get("discrepancy_qty"));
				double unitCost = bean.getItemUnitCost(itemCode);
				out.println ("document.formReturnGroupDiscrepancyDetail.charge_amt.value = \'"+(unitCost * itemQty)+"\'");
			}
			break;
		case 15 :
			{
				String patient_id= request.getParameter("patient_id");
				bean.setPatient_id(patient_id);
				if (bean.getPatientName()==null) {
					out.println("assignResult(false, \"INVALID_PATIENT_ID\", \"0\" ) ; ") ;
					return;
				}
				try { 
					out.println("setEncounterID(\""+bean.getEncounterID(patient_id)+"\");");
				}
				catch (Exception exception) {
					exception.printStackTrace();
					out.println("assignResult(false, \"INVALID_ENCOUNTER_ID\", \"0\" ) ; ") ;
					return;
				}
			}
			break;
		case 16:{
			if((bean.getDescrepancy())==0){
				String group_code = (String) hash.get("group_code");
				String tray_no = (String) hash.get("tray_no");
				
				bean.loadDiscrepancyDetails(group_code,tray_no);
				String discrepancyMainKey = group_code + "-"+tray_no;
				out.println("discrepancyMainKey"+discrepancyMainKey);
			}
		}
		break;
		case 17:
			{
				String group_code	= request.getParameter("group_code");
				String tray_no		= request.getParameter("tray_no");
				
				ArrayList alparams	= new ArrayList();
				alparams.add(group_code);
				alparams.add(tray_no);
				
				
				ArrayList alRecords	=	bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_RETURN_DISCREPANCY_SELECT"),alparams);
				if(alRecords.size()>0){
				HashMap hmRecord	=	(HashMap)alRecords.get(0);
								
				out.println("document.formReturnGroupDiscrepancyDetail.item_code.value=\""+bean.checkForNull((String)hmRecord.get("ITEM_CODE"))+"\"");
				out.println("document.formReturnGroupDiscrepancyDetail.write_off_reason_code.value=\""+bean.checkForNull((String)hmRecord.get("WRITE_OFF_REASON_CODE"))+"\"");
				out.println("document.formReturnGroupDiscrepancyDetail.remarks.value=\""+bean.checkForNull((String)hmRecord.get("REMARKS"))+"\"");
				out.println("document.formReturnGroupDiscrepancyDetail.discrepancy_qty.value=\""+bean.checkForNull((String)hmRecord.get("DISCREPANCY_QTY"))+"\"");
				out.println("document.formReturnGroupDiscrepancyDetail.patient_id.value=\""+bean.checkForNull((String)hmRecord.get("PATIENT_ID"))+"\"");
				out.println("document.formReturnGroupDiscrepancyDetail.item_returnable_yn.value=\""+bean.checkForNull((String)hmRecord.get("ITEM_RETURNABLE_YN"))+"\"");
				out.println("document.formReturnGroupDiscrepancyDetail.encounter_id.value=\""+bean.checkForNull((String)hmRecord.get("ENCOUNTER_ID"))+"\"");
				out.println("document.formReturnGroupDiscrepancyDetail.charge_option.value=\""+bean.checkForNull((String)hmRecord.get("CHARGE_OPTION"))+"\"");
				out.println("document.formReturnGroupDiscrepancyDetail.charge_amt.value=\""+bean.checkForNull((String)hmRecord.get("CHARGE_AMT"))+"\"");
				out.println("document.formReturnGroupDiscrepancyDetail.rec_reference.value=\""+bean.checkForNull((String)hmRecord.get("REC_REFERENCE"))+"\"");
				}
			}
			
			break;
		case 18:
			{
				String group_code		=	(String) hash.get("group_code");
				String tray_no			=	(String) hash.get("tray_no");
				ArrayList alparams	= new ArrayList();
				alparams.add(group_code);
				alparams.add(tray_no);
				
				HashMap alRecords	=	bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_RETURN_DISCREPANCY_COUNT"),alparams);
				String stCountRecord = (String)alRecords.get("COUNT");
				if(stCountRecord.equals("0"))
				{
				
					out.println("parent.frameReturnGroupDetail.document.formReturnGroupDetail.discrepancy.disabled=true");
				}
			}
			break;
						
		case 19: // This case will be executed on click of OK or next_previous added against inc#43893
		{
				ArrayList checkedrecord =  bean.getAlSelectedTrayDetails();
				ArrayList selectedrecord = bean.getSelectedTraysList();
				checkedrecord.clear();
				selectedrecord.clear();
				
						
		}
		break;
		case 20: // This case will be executed on click of group search button added against Inc#43893 to hold already added groupcode-trayno
		{

			ArrayList	alRecords	=	new ArrayList();
			HashMap	hmDtlRecord	=	new HashMap();
			int total_rec	=	Integer.parseInt((String)hash.get("total_checkboxes"));
	       	for(int i=0;i<total_rec;i++){
				String groupCode_trayNo = (String)hash.get("group_code_"+i)+"-"+(String)hash.get("tray_no_"+i);
				bean.setalGroupRecords(groupCode_trayNo);
				
			}//Added ends

			
				
		}
		break;
		case 21: //Added for AAKH-CRF-0057
		{
                bean_id				=		request.getParameter("bean_id");
	            bean_name			=		request.getParameter("bean_name");
			    String language_id = bean.getLanguageId();
				String facility_id = bean.getLoginFacilityId();
				String report_id="SSRTNGRPFRM";
				String doc_no=request.getParameter("doc_no");
				String doc_type_code=request.getParameter("doc_type_code");
				 //System.err.println("report_id@@@==="+report_id+"doc_no==="+doc_no+"doc_type_code===="+doc_type_code+"language_id==="+language_id+"facility_id==="+facility_id);
                 ecis.utils.OnlineReports onlineReports		=	new ecis.utils.OnlineReports() ;
			     ecis.utils.OnlineReport report1				=	new ecis.utils.OnlineReport( facility_id, "SS",report_id) ;
				
				report1.addParameter("p_report_id",report_id.trim()) ;
				report1.addParameter("p_doc_no",doc_no.trim());
				report1.addParameter("p_doc_type_code", doc_type_code.trim()) ;
				report1.addParameter("p_language_id",language_id.trim()) ;
				report1.addParameter("p_facility_id",facility_id.trim()) ;
				report1.addParameter("p_user_name",user_name.trim()) ;
				onlineReports.add( report1) ;
				String ReportOutput = onlineReports.execute( request, response );
				report1 = null;

			
				
		}
		break;
		default :
			//To be replaced with proper message
			out.println("alert(\'Invalid Function : "+functionType+"\');");
			return;
	}
putObjectInBean(bean_id,bean,request); 
%>
