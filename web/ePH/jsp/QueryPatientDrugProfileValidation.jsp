<% /* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
10/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
---------------------------------------------------------------------------------------------------------------
*/ %>

 <%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*,eST.*,eST.Common.*" contentType="text/html;charset=UTF-8" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	try {		
		String func_mode			= request.getParameter("func_mode");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		if(func_mode!= null && func_mode.equals("DiscCancel")) {
			String reason			= (String) hash.get( "reason" );
			String remarks			= (String) hash.get( "remarks" );
			String status			= (String) hash.get( "status" );
			String order_line_no	= (String) hash.get( "order_line_no" );
			String order_id			= (String) hash.get( "order_id" );
			String called_frm		= (String) hash.get( "called_frm" );
			String	bean_id			= "QueryPatientDrugProfileBean" ;
			String	bean_name		= "ePH.QueryPatientDrugProfileBean";
			
			QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id, bean_name,request);
			bean.setLanguageId(locale);
			HashMap result = bean.discCancelDrug(order_id,order_line_no,remarks,reason,status);
			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				out.println("alertMessage('"+result.get( "message" )+"','"+called_frm+"')");
			}else{
				out.println(result);
			}
			putObjectInBean(bean_id,bean,request);
		}	
		else if(func_mode!= null && func_mode.equals("Duplicate")) { /* This block of code added for ML-BRU-SCF-0621[IN036565] -- Start */ 
			
			String bean_id		= (String) hash.get( "bean_id" );	
			String bean_name		= (String) hash.get( "bean_name" );			
			String patient_id		= (String) hash.get( "patientId" );		
			String chk_Patient	= (String) hash.get("chkPatientID");		
			String main_patientid   = "";		
			QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id, bean_name,request);
			bean.setLanguageId(locale);
			main_patientid  = bean.DuplicateCheck(patient_id);		
			if(main_patientid != null && main_patientid!="" ){
				out.println("mergedPatientAlert('"+main_patientid+"');");			
			 }			
			else if(chk_Patient!= null && chk_Patient.equals("true")){
			   out.println("chkPatientID('"+patient_id+"');");	
			}		
			putObjectInBean(bean_id,bean,request);
		} /* code added for ML-BRU-SCF-0621[IN036565] -- End */ 
        else if(func_mode!= null && func_mode.equals("update_accession_num")) { /* This block of code added for AAKH-CRF-0088.2 -- Start */ 
			String bean_id		= (String) hash.get( "bean_id" );	
			String bean_name		= (String) hash.get( "bean_name" );			
			String patient_id		= (String) hash.get( "patient_id" );		
			String drug_code	= (String) hash.get("drug_code");	
			String srl_no	= (String) hash.get("srl_no");
			String accession_no = (String) hash.get("retVal");
			String facility_id = (String) hash.get("facility_id");
			QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id, bean_name,request);
			
			bean.setLanguageId(locale);
			bean.UpdateAccessNo(accession_no, patient_id, drug_code, srl_no, facility_id);		
								
			putObjectInBean(bean_id,bean,request);
		} /* code added for AAKH-CRF-0088.2 -- End added for IN070786 start */ 
        else if(func_mode!= null && func_mode.equals("fetchDrugDetails")) {
			String bean_id		= (String) hash.get( "bean_id" );	
			String bean_name		= (String) hash.get( "bean_name" );			
			String drug_code	= (String) hash.get("drug_code");
			HashMap detailsMap			= new HashMap();
			String form_code="";
			String route_code="";
			//System.out.println("drug_code"+drug_code);
			QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id, bean_name,request);
			bean.setLanguageId(locale);
			detailsMap=bean.getDrugdetails(drug_code);
			ArrayList routes = (ArrayList)detailsMap.get("routes");
			ArrayList FreqList=(ArrayList)detailsMap.get("FreqList");
			route_code=(String)detailsMap.get("ROUTE_CODE");
			form_code=(String)detailsMap.get("FORM_CODE");
			String dosage_type=(String)detailsMap.get("DOSAGE_TYPE");
			String ori_dosage_type=(String)detailsMap.get("ORI_DOSAGE_TYPE");
			String strength_uom=(String)detailsMap.get("STRENGTH_UOM");
			String strength_uom_desc=(String)detailsMap.get("STRENGTH_UOM_DESC");
			ArrayList QtyDescDetails		= (ArrayList)bean.loadQtyDetails(form_code);
			out.println("clearData('document.PatientExternalDrug.route_code');") ;
			out.println("clearData('document.PatientExternalDrug.frequency');") ;
			out.println("clearData('document.PatientExternalDrug.dosage');") ;
			if(routes.size() <= 0){
				out.println("addDataDefault('',' ---Select---','document.PatientExternalDrug.route_code');");
			//	out.println("document.formClaimFormsCriteria.encounterIdCount.value=0"); 
			}
			else {	
				//out.println("document.formClaimFormsCriteria.encounterIdCount.value="+encounterDetails.size());
			//	out.println("alert(document.formClaimFormsCriteria.Patient_Id.value)");
				for(int i=0; i<routes.size(); i=i+3) {			
										
					if(route_code.equals(routes.get(i)))
						out.println("addDataDefault('"+ routes.get(i) + "', '" + routes.get(i+1) +"', 'document.PatientExternalDrug.route_code','selected');") ;
					else{
						out.println("addDataDefault('"+ routes.get(i) + "', '" + routes.get(i+1) +"', 'document.PatientExternalDrug.route_code');") ;
					}
				
				}
			}
			
			if(FreqList.size() <= 0){
				out.println("addDataDefault('',' ---Select---','document.PatientExternalDrug.frequency');");
			//	out.println("document.formClaimFormsCriteria.encounterIdCount.value=0"); 
			}
			else {	
				//out.println("document.formClaimFormsCriteria.encounterIdCount.value="+encounterDetails.size());
			//	out.println("alert(document.formClaimFormsCriteria.Patient_Id.value)");
				for(int i=0; i<FreqList.size(); i=i+3) {			
										
					if(form_code.equals(FreqList.get(i)))
						out.println("addDataDefault('"+ FreqList.get(i) + "', '" + FreqList.get(i+1) +"', 'document.PatientExternalDrug.frequency','selected');") ;
					else{
						out.println("addDataDefault('"+ FreqList.get(i) + "', '" + FreqList.get(i+1) +"', 'document.PatientExternalDrug.frequency');") ;
					}
				
				}
			}
			
			
			if(dosage_type.equals("A")){
				out.println("addDataDefault('A', 'Absolute', 'document.PatientExternalDrug.dosage','selected');") ;
				}
				else if(dosage_type.equals("S")){
					out.println("addDataDefault('S', 'Strength', 'document.PatientExternalDrug.dosage','selected');") ;
						out.println("addDataDefault('Q', 'Quantity', 'document.PatientExternalDrug.dosage','');") ;
				}
				else if(dosage_type.equals("Q")){
				if(ori_dosage_type.equals("S")){
				out.println("addDataDefault('S', 'Strength', 'document.PatientExternalDrug.dosage','');") ;
				out.println("addDataDefault('Q', 'Quantity', 'document.PatientExternalDrug.dosage','selected');") ;
				}
				else{
				out.println("addDataDefault('Q', 'Quantity', 'document.PatientExternalDrug.dosage','selected');") ;
				}
				}
			if(dosage_type.equals("S")){
				out.println("addDataDefault('"+ strength_uom + "', '" + strength_uom_desc +"', 'document.PatientExternalDrug.qty_desc','selected');") ;
			}
			
			else{
			if(QtyDescDetails.size() <= 0){
				out.println("addDataDefault('',' ---Select---','document.PatientExternalDrug.qty_desc');");
			//	out.println("document.formClaimFormsCriteria.encounterIdCount.value=0"); 
			}
			else {	
				//out.println("document.formClaimFormsCriteria.encounterIdCount.value="+encounterDetails.size());
			//	out.println("alert(document.formClaimFormsCriteria.Patient_Id.value)");
				for(int i=0; i<QtyDescDetails.size(); i=i+3) {			
										
					if(form_code.equals(QtyDescDetails.get(i)))
						out.println("addDataDefault('"+ QtyDescDetails.get(i) + "', '" + QtyDescDetails.get(i+1) +"', 'document.PatientExternalDrug.qty_desc','selected');") ;
					else{
						out.println("addDataDefault('"+ QtyDescDetails.get(i) + "', '" + QtyDescDetails.get(i+1) +"', 'document.PatientExternalDrug.qty_desc');") ;
					}
				
				}
			}
        }
			out.println("addDefaultValues('"+form_code+"');");
			putObjectInBean(bean_id,bean,request);
		}
        else if(func_mode!= null && func_mode.equals("changeuomDetails")) {
        	
        	String bean_id		= (String) hash.get( "bean_id" );	
			String bean_name    = (String) hash.get( "bean_name" );			
			String drug_code	= (String) hash.get("drug_code");
			String form_code	= (String) hash.get("form_code");
			String dosage_type =(String)hash.get("dosage_type");
			System.out.print("dosage_type"+dosage_type);
			System.out.println("drug_code"+drug_code);
			QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id, bean_name,request);
			bean.setLanguageId(locale);
			
			ArrayList QtyDescDetails		= (ArrayList)bean.loadQtyDetails(form_code);
			ArrayList strengthDetails		= (ArrayList)bean.strengthDetails(drug_code);
			out.println("clearData('document.PatientExternalDrug.qty_desc');") ;
			if(dosage_type.equals("S")){
				out.println("addDataDefault('"+ strengthDetails.get(0) + "', '" + strengthDetails.get(1) +"', 'document.PatientExternalDrug.qty_desc','selected');") ;
			}
			
			else{
			if(QtyDescDetails.size() <= 0){
				out.println("addDataDefault('',' ---Select---','document.PatientExternalDrug.qty_desc');");
			//	out.println("document.formClaimFormsCriteria.encounterIdCount.value=0"); 
			}
			else {	
				//out.println("document.formClaimFormsCriteria.encounterIdCount.value="+encounterDetails.size());
			//	out.println("alert(document.formClaimFormsCriteria.Patient_Id.value)");
				for(int i=0; i<QtyDescDetails.size(); i=i+3) {			
										
					if(form_code.equals(QtyDescDetails.get(i)))
						out.println("addDataDefault('"+ QtyDescDetails.get(i) + "', '" + QtyDescDetails.get(i+1) +"', 'document.PatientExternalDrug.qty_desc','selected');") ;
					else{
						out.println("addDataDefault('"+ QtyDescDetails.get(i) + "', '" + QtyDescDetails.get(i+1) +"', 'document.PatientExternalDrug.qty_desc');") ;
					}
				
				}
			}
        }
        }//added for IN070786 end
		
	}catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}
%>
