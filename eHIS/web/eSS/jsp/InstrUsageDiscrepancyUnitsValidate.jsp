<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="alTrayDiscrepancyList" scope="session" class="java.util.ArrayList"/>
<%
	
	
		String bean_id						= request.getParameter("bean_id");
		String bean_name					= request.getParameter("bean_name");
		String validate						= request.getParameter("validate");

		String group_code				    =	request.getParameter("group_code");
		String group_desc				    =	request.getParameter("group_desc");
		String store_code				    =	request.getParameter("store_code");
		String tray_no					    =	request.getParameter("tray_no");
		String patient_id				    =	request.getParameter("patient_id");
		String patient_name				    =	request.getParameter("patient_name");
		String encounter_id				    =	request.getParameter("encounter_id");
		String item_code				    =	request.getParameter("item_code");
		String item_desc					=	request.getParameter("item_desc");
		String remarks						=	request.getParameter("remarks");
		String discrepancy_qty				=	request.getParameter("discrepancy_qty");
		String discrepancy_type				=	request.getParameter("discrepancy_type");
		String write_off_reason_desc		=	request.getParameter("write_off_reason_desc");
		String write_off_reason_code		=	request.getParameter("write_off_reason_code");
		String index						=	request.getParameter("index");
		String message						=	"";
		String flag							=	"";
		boolean	result						=	false;

		
	
		if ((bean_id == null) || (bean_id.equals("")))
		return;
		InstrUsageDiscrepancyUnitsDetailBean bean = (InstrUsageDiscrepancyUnitsDetailBean) getBeanObject(bean_id, bean_name,request);
		Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
		try
		{
		  if (validate.equals("STORE_CODE"))
					{
					
							bean.setStore_code(store_code);
					
					}
		  else	
				if (validate.equals("GROUP_DESC"))
					{
						bean.setStore_code(request.getParameter("store_code"));
						bean.setGroup_code(group_code);
						bean.setGroup_desc(group_desc);
					
					}
		else 
				if (validate.equals("POPULATE_DISCREPANCY")){
			
						ArrayList alParameters=new ArrayList(3);
						alParameters.add( bean.getOwnerStoreCode(store_code,tray_no,group_code));
						alParameters.add(group_code);
						alParameters.add(tray_no);
				
				if(bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_TRAY_DTLS_COUNT_VALID_FOR_TRD"),alParameters).get("TOTAL").toString().equals("0")){
						throw new Exception("INVALID_TRAY_NO");
								}

						ArrayList alParameters1=new ArrayList(3);
						alParameters1.add(group_code);
						alParameters1.add(bean.getLanguageId());

						ArrayList alRecords	=	bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_ITEM_FOR_GROUP_SELECT_LIST_FOR_TRD"),alParameters1);
						for (int i=0; i<alRecords.size(); i++){
					HashMap hmRecord	=	(HashMap)alRecords.get(i);
					
					out.println(  "addListItem(\"parent.frameInstrUsageDiscrepancyUnitsDetail.document.forms[0].item_code\",\""+hmRecord.get("ITEM_CODE")+"\",\""+hmRecord.get("SHORT_DESC")+"\");"  );
					}
				
					

				alParameters=new ArrayList(3);
				alParameters.add(group_code);
				alParameters.add(tray_no);

				alRecords	=	bean.fetchRecords("SELECT dtl.STORE_CODE,dtl.group_code,dtl.tray_no,dtl.PATIENT_ID,dtl.ENCOUNTER_ID,dtl.item_code,  dtl.write_off_reason_code, wr.short_desc write_off_reason_desc, mm.short_desc item_desc, dtl.remarks, dtl.discrepancy_qty, discrepancy_type, dtl.charge_amt, dtl.usage_ind, dtl.finalized_yn FROM ss_discrepancy_dtl dtl, ss_write_off_reason wr, mm_item mm WHERE dtl.group_code=? AND dtl.tray_no=? AND dtl.item_code=mm.item_code AND dtl.write_off_reason_code=wr.write_off_reason_code",alParameters);

					for (int i=0; i<alRecords.size(); i++){

					HashMap hmRecord	=	(HashMap)alRecords.get(i);
					hmRecord.put("item_code",			hmRecord.get("ITEM_CODE")				);
					hmRecord.put("discrepancy_qty",	hmRecord.get("DISCREPANCY_QTY")		);
					hmRecord.put("discrepancy_type",	hmRecord.get("DISCREPANCY_TYPE")		);
					hmRecord.remove("ITEM_CODE"				);
					hmRecord.remove("DISCREPANCY_TYPE"				);
					hmRecord.remove("DISCREPANCY_QTY");
					alTrayDiscrepancyList.add(hmRecord);
			}
			
				out.println("disableHeader();");//added for KDAH-SCF-0329
				result	=	true; 
				if(result)
				out.println("refreshList('"+result+"'); ");	
				message	=	"Done"+validate;
			}
		else	
			if (validate.equals("SEARCH_PATIENT")){
			
					 patient_name =  bean.getPatientName(patient_id);
				
			
				if ((patient_name == null) || (patient_name.trim().length() <=0)) {
					out.println("invalidPatientName();");
					return;
				}
				
		}
	else	
			if (validate.equals("PATIENT_NAME")){
			
					
				out.println("setPatientName(\""+bean.getPatientName(patient_id)+"\");");
		
				try{
				String encounterId = "";
				ArrayList alEncounterList = bean.getEncounterArrayList(patient_id);
				for(int i=0; i< alEncounterList.size(); i++) {
					HashMap record	=	(HashMap)alEncounterList.get(i);
					String listRecord	=	(String)record.get("ENCOUNTER_ID");
					
					out.println(  "addListItem(\"document.forms[0].encounter_id\",\""+listRecord+"\",\""+listRecord+"\");"  );
					}
					
				
				encounterId = null;
				result			=	true;
			}
			catch(Exception exception){
				flag			=	"INVALID_PATIENT";
				result			=	false;
			}
			
									
	}
				
	
		else	if (validate.equals("ADD_TO_LIST")){
			
					HashMap hmListItems	=	new HashMap();
				if(bean.isItemAndDiscrepancyInArrayList(alTrayDiscrepancyList,group_code,tray_no,item_code,write_off_reason_code,Integer.parseInt(index))){
						throw new Exception("RECORD_ALREADY_EXISTS");
									
				}
				
				if(remarks.length()>200)
						throw new Exception("REMARKS_EXCEEDS_MAX_LIMIT");
				if(index.equals("-1")){
				hmListItems.put("item_code",			item_code				);
				hmListItems.put("item_desc",			item_desc				);
				hmListItems.put("write_off_reason_code",write_off_reason_code	);
				hmListItems.put("write_off_reason_desc",write_off_reason_desc	);
				hmListItems.put("remarks",				remarks					);
				hmListItems.put("discrepancy_qty",		discrepancy_qty			);
				hmListItems.put("discrepancy_type",		discrepancy_type		);
				hmListItems.put("patient_id",			patient_id				);
				hmListItems.put("patient_name",			patient_name			);
				hmListItems.put("encounter_id",			encounter_id			);
				hmListItems.put("group_desc",			group_desc				);
				hmListItems.put("group_code",			group_code				);
				hmListItems.put("tray_no",				tray_no					);
				hmListItems.put("store_code",			store_code				);
				hmListItems.put("usage_ind","O");
				hmListItems.put("mode",bean.getCommonRepositoryValue("MODE_INSERT"));
				alTrayDiscrepancyList.add(hmListItems);
				result	=	true;
				bean.setEncounter_id(encounter_id);
				
		
				out.println("document.formInstrUsageDiscrepancyUnitsDetail.encounter_id.value=\""+""+"\"");
				out.println("document.formInstrUsageDiscrepancyUnitsDetail.encounter_id.disabled=\""+"true"+"\"");
		
				if(result)	{	
					    out.println("refreshList('"+result+"'); ");	
						}
			}
			else{
			hmListItems.put("mode",((HashMap)alTrayDiscrepancyList.get(Integer.parseInt(index))).get("mode"));
			hmListItems.put("usage_ind",((HashMap)alTrayDiscrepancyList.get(Integer.parseInt(index))).get("usage_ind"));
			hmListItems.put("finalized_yn",((HashMap)alTrayDiscrepancyList.get(Integer.parseInt(index))).get("finalized_yn"));
			hmListItems.put("item_code",			item_code				);
			hmListItems.put("item_desc",			item_desc				);
			hmListItems.put("write_off_reason_code",write_off_reason_code	);
			hmListItems.put("write_off_reason_desc",write_off_reason_desc	);
			hmListItems.put("remarks",				remarks					);
			hmListItems.put("discrepancy_qty",		discrepancy_qty			);
			hmListItems.put("discrepancy_type",		discrepancy_type		);
			hmListItems.put("patient_id",			patient_id				);
			hmListItems.put("patient_name",			patient_name			);
			hmListItems.put("encounter_id",			encounter_id			);
			hmListItems.put("group_code",			group_code				);
			hmListItems.put("group_desc",			group_desc				);
			hmListItems.put("tray_no",				tray_no					);
			hmListItems.put("store_code",			store_code				);
			alTrayDiscrepancyList.set(Integer.parseInt(index),hmListItems);
			result	=	true;
			bean.setEncounter_id(encounter_id);
			
			out.println("document.formInstrUsageDiscrepancyUnitsDetail.encounter_id.disabled=\""+"true"+"\"");
			if(result)	{	
							out.println("refreshList('"+result+"'); ");
				
			}
				message	=	"Done";
			
			}
		}
			
	else if (validate.equals("EDIT_DETAIL")){
		
		String key = (String) hash.get("selected_key");
		
			if (key == null || (key.trim().equals(""))) {
				return;
			}
			String[] detail = bean.getDetail(key);
			out.println("var arrayObject = new Array();");
			out.println("arrayObject[0] = '"+bean.checkForNull(detail[0])+"';");
			out.println("arrayObject[1] = '"+bean.checkForNull(detail[2])+"';");
			out.println("arrayObject[2] = '"+bean.checkForNull(detail[4])+"';");
			out.println("arrayObject[3] = '"+bean.checkForNull(detail[5])+"';");
			out.println("arrayObject[4] = '"+bean.checkForNull(detail[7])+"';");
			out.println("arrayObject[5] = '"+bean.checkForNull(detail[8])+"';");
			out.println("arrayObject[6] = '"+bean.checkForNull(detail[9])+"';");
			out.println("editDetail(arrayObject);");
		}
		
	
	
	}
	catch(Exception e)
	{
		
		result	=	false;
		message	=	e.getMessage();
		System.out.println("======message=========>"+message);
		
	}
	finally{
	
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
	
	putObjectInBean( bean_id,bean,request);
%>
