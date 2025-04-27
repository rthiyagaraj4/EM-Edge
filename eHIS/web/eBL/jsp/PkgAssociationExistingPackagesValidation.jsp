<%@page	import="java.sql.*,java.util.*,java.io.*,eBL.Common.*,webbeans.eCommon.*,eBL.PkgAssociationExistingPackagesBean"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<%


	String operation = request.getParameter("operation");
		
	if(operation.equals("encounterAssociationValidation")){
		
			Connection con = ConnectionManager.getConnection();	
			JSONObject obj=new JSONObject();
			String facilityId			= (String)session.getAttribute("facility_id");
			String patientId			= request.getParameter("patientId");
			String encounterId			= request.getParameter("encounterId");
			String episodeId			= request.getParameter("episodeId");
			String visitIdStr			= request.getParameter("visitId");
			if(visitIdStr==null || visitIdStr.equals("")){
				visitIdStr="0";
			}
			
			Integer visitId=Integer.parseInt(visitIdStr);
			int countInt=0;
	 		ArrayList<PkgAssociationExistingPackagesBean> pkgAssociationExistingPackagesBeanList= (session.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG"))==null ? new ArrayList<PkgAssociationExistingPackagesBean>(): (ArrayList<PkgAssociationExistingPackagesBean>)session.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG");
	 		
			/*  Checks whether Encounter is already associated to one or more Packages 	*/
			for(PkgAssociationExistingPackagesBean bean: pkgAssociationExistingPackagesBeanList){
				String ValidationQuery="select count(*) from bl_package_encounter_dtls where OPERATING_FACILITY_ID=? and PATIENT_ID=? and PACKAGE_CODE=? and PACKAGE_SEQ_NO=? and ENCOUNTER_ID=? AND nvl(visit_id,0) = nvl(to_number(?),0)"+"|"+facilityId+"|"+patientId+"|"+bean.getExistingPkgCode()+"|"+bean.getExistingPkgSeqNo()+"|"+episodeId+"|"+visitId.toString();
				System.out.println(ValidationQuery);
				String countStr=BLHelper.getDescriptionViaSQL(con,"select count(*) from bl_package_encounter_dtls where OPERATING_FACILITY_ID=? " +
																		"and PATIENT_ID=? and PACKAGE_CODE=? and PACKAGE_SEQ_NO=? and ENCOUNTER_ID=? AND nvl(visit_id,0) = nvl(to_number(?),0)",
																			facilityId,patientId,bean.getExistingPkgCode(),bean.getExistingPkgSeqNo(),episodeId,visitId.toString()); // Episode is passed as only episode is Stored in encounter_details table
				countInt=Integer.parseInt(countStr);	
				if(countInt>0) {
					obj.put("desc","ENC_ALREADY_ASSOCIATED");
					break;
				}
	
	
			}	
			
			//	Karthik added code for MMS-RY-SCF-0065  Checks whether Payer Details are present in Patient Financial Information 			
			for(PkgAssociationExistingPackagesBean bean: pkgAssociationExistingPackagesBeanList){
				String sql=" SELECT COUNT (*) "+
						  " FROM bl_package_sub_hdr a "+
						  " WHERE a.operating_facility_id = ? "+//1
						    " AND a.patient_id = ? "+//2
						    " AND a.package_seq_no = ? "+//3
						    " AND (   (    cust_group_code IS NOT NULL "+
						             " AND cust_group_code NOT IN ( "+
						                    " SELECT DISTINCT cust_group_code "+
						                               " FROM bl_encounter_payer_priority b "+
						                              " WHERE b.operating_facility_id = ? "+//4
						                                " AND b.episode_id = ? "+//5
						                                " AND NVL (b.visit_id, 0) = nvl(to_number(?),0) "+//6
						                                " AND acct_seq_no IN ( "+
						                                       " SELECT MAX (acct_seq_no) "+
						                                         " FROM bl_encounter_payer_priority "+
						                                        " WHERE operating_facility_id = ? "+//7
						                                          " AND episode_id = ? "+//8
						                                          " AND NVL (visit_id, 0) = nvl(to_number(?),0))) "+//9
						            " ) "+
						         " OR (    cust_code IS NOT NULL "+
						             " AND cust_code NOT IN ( "+
						                    " SELECT DISTINCT cust_code "+
						                               " FROM bl_encounter_payer_priority b "+
						                              " WHERE b.operating_facility_id = ? "+//10
						                                " AND b.episode_id = ? "+//11
						                                " AND NVL (b.visit_id, 0) = nvl(to_number(?),0) "+//12
						                                " AND acct_seq_no IN ( "+
						                                       " SELECT MAX (acct_seq_no) "+
						                                         " FROM bl_encounter_payer_priority "+
						                                        " WHERE operating_facility_id = ? "+//13
						                                          " AND episode_id = ? "+//14
						                                          " AND NVL (visit_id, 0) = nvl(to_number(?),0))) "+//15
						            " ) "+
						        " ) ";
				String countStr=BLHelper.getDescriptionViaSQL(con,sql,
						facilityId,patientId,bean.getExistingPkgSeqNo(),
						facilityId,episodeId,visitId.toString(),
						facilityId,episodeId,visitId.toString(),
						facilityId,episodeId,visitId.toString(),
						facilityId,episodeId,visitId.toString()); 
				countInt=Integer.parseInt(countStr);	
				if(countInt>0) {
					obj.put("desc","PAYER_NA_FIN_DTLS");
					break;
				}

			}
			

			if(countInt==0){
		    obj.put("flag","SUCCESS");
			}else{
			obj.put("flag","FAIL"); //one or more packages associated for this encouter
			}
		    out.print(obj);
		    out.flush();
	}else if(operation.equals("encounterChecked")){
		
		HashMap<String,ArrayList<String>>  packageSubscriptionAssociationEncounters= session.getAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS")==null ? null: (HashMap<String,ArrayList<String>>) session.getAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS") ;
		JSONObject obj=new JSONObject();
		if(packageSubscriptionAssociationEncounters==null){
			obj.put("flag","FAIL"); //No Encounters are selected to Associate
		}else{
			Map.Entry<String,ArrayList<String>> aObj=packageSubscriptionAssociationEncounters.entrySet().iterator().next();
			if(aObj.getValue().size()==0){
		    obj.put("flag","FAIL");
			}else{
			obj.put("flag","SUCCESS");	
			}
		}
	    out.print(obj);
	    out.flush();
		
	}
%>
