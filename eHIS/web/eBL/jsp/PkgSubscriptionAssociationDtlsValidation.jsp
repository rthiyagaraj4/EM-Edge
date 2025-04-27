<%-- JSP Page specific attributes start --%>
<%@ page import="com.itextpdf.text.log.SysoLogger"%>
<%@ page
	import="webbeans.eCommon.*,eBL.*,eBL.Common.*,com.ehis.util.*,java.util.*,java.sql.*,java.text.*"%>
<%-- Mandatory declarations start --%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page"
	class="webbeans.eCommon.XMLStringParser" />

<%
	try {
		System.err.println("Inside PkgSubscriptionAssociationDtlsValidation.jsp");
		Connection con = ConnectionManager.getConnection();	
		request.setCharacterEncoding("UTF-8");	
		String action=request.getParameter("action");
		String pkgCode="";
		System.err.println("Inside PkgSubscriptionAssociationDtlsValidation.jsp action:"+action);
		if(action.equals("across_encounter_check")){
			
			String packageCodeList=request.getParameter("packageCodeList");
			boolean isAcrossEncounter=false;
			StringTokenizer stPackageDetails=new StringTokenizer(packageCodeList,"|"); 
			while(stPackageDetails.hasMoreTokens()){
				
				String acrossEncounterLogic="N";
				PreparedStatement pstmtChrg = con.prepareStatement("select ACROSS_ENCOUNTER_YN from bl_package where PACKAGE_CODE=?");
				pkgCode=stPackageDetails.nextToken();
				pstmtChrg.setString(1,pkgCode);
				ResultSet	rsChrg = pstmtChrg.executeQuery() ;
				if(rsChrg.next())	{ 
					
						acrossEncounterLogic = rsChrg.getString(1);
						if(acrossEncounterLogic==null){
							acrossEncounterLogic="N";
						}	
						
						if(acrossEncounterLogic.equals("N")){
							isAcrossEncounter=false;
							break;
						}						
						isAcrossEncounter=true;						
				}
				if (rsChrg != null) rsChrg.close();
				if (pstmtChrg != null) pstmtChrg.close();					
			}
			if(isAcrossEncounter==true){
			System.out.println("SUCCESS_ACROSS_ENCOUNTER PKG_CODE:"+pkgCode);
			out.println("SUCCESS_ACROSS_ENCOUNTER");
			}else{
			System.out.println("FAILURE_ACROSS_ENCOUNTER PKG_CODE:"+pkgCode);
			out.println("FAILURE_ACROSS_ENCOUNTER");
			}
		}
		if(action.equals("submit")){
				Hashtable hash = (Hashtable) xmlObj.parseXMLString(request);
				hash = (Hashtable) hash.get("SEARCH");
				int totalRecords=Integer.parseInt((String)hash.get("totalRecords"));
				String patientId=(String)hash.get("patientId");
				//Added by palaniNarayanan  FOR PMG-COMMON-CFR-00076 on V210622 Starts
				String package_seq_no=(String)hash.get("package_seq_no");
				if(package_seq_no==null) package_seq_no="";
				String packageCodeList=(String)hash.get("packageCodeList");
				if(packageCodeList==null) packageCodeList="";
				String eff_from_date=(String)hash.get("eff_from_date");
				if(packageCodeList==null) packageCodeList="";
				String function_id=(String)hash.get("function_id");
				if(function_id==null) function_id="";
				//Added by palaniNarayanan  FOR PMG-COMMON-CFR-00076 on V210622  Ends
				ArrayList<String> encounterCombinationArray=new ArrayList<String>();
				HashMap<String,ArrayList<String>>  packageSubscriptionAssociationEncounters=new HashMap<String,ArrayList<String>>();
		
				String encounterCombinationString="";
				for(int i=0;i<totalRecords;i++){
				boolean boolEncounterSelected=Boolean.parseBoolean((String)hash.get("selectEncounter"+i));
				if(boolEncounterSelected==true){
				String patientClass=(String)hash.get("alPatientClass"+i);
				if(patientClass.equals("OP")){
					patientClass = "O";		
				}else if(patientClass.equals("IP")){
					patientClass = "I";		
				}else if(patientClass.equals("DC")){
					patientClass = "D";		
				}else{
					patientClass = "E";
				}
				encounterCombinationString=patientClass+"|"+(String)hash.get("alEncounterId"+i)+"|"+(String)hash.get("alEpisodeId"+i)+"|"+(String)hash.get("alVisitId"+i);
				/* Below code added by palaniNarayanan  FOR PMG-COMMON-CFR-00076 on V210622  STRATS */
				if(!function_id.equals("EBL_TRAN_PACKAGE_MAINTAIN") || function_id.equals("") )
				{
					encounterCombinationArray.add(encounterCombinationString);
					
				}
				else
				{
					encounterCombinationString=encounterCombinationString+"|"+package_seq_no+"|"+packageCodeList+"|"+eff_from_date;
					encounterCombinationArray.add(encounterCombinationString);
							
				}
						
				}	
			packageSubscriptionAssociationEncounters.put(patientId, encounterCombinationArray);
		}
				/*  PMG-COMMON-CFR-00076 on V210622  Ends */
	
		session.setAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS", packageSubscriptionAssociationEncounters);
		encounterCombinationString = encounterCombinationString.replace("|","~~");
		out.println(encounterCombinationString);
		}
		if(action.equals("count")){	
			
			
			
			String patientId=request.getParameter("patId");
			ArrayList<String> encounterListArray=new ArrayList<String>();
						
		 	if(session.getAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS")!=null){
				HashMap<String,ArrayList<String>>  packageSubscriptionAssociationEncounters=new HashMap<String,ArrayList<String>>();
				ArrayList<String> encounterCombinationArray=new ArrayList<String>();
				packageSubscriptionAssociationEncounters=(HashMap<String,ArrayList<String>>)session.getAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS");
				encounterCombinationArray=packageSubscriptionAssociationEncounters.get(patientId);	
			//	System.out.println("encounterCombinationArray/patientId"+encounterCombinationArray+"/"+patientId);
				if(encounterCombinationArray==null){
					encounterCombinationArray=new ArrayList<String>();
				}		
				for(int encCount=0;encCount<encounterCombinationArray.size();encCount++){
				StringTokenizer stEncList=new StringTokenizer(encounterCombinationArray.get(encCount),"|");					
				String headerEpisodeType=stEncList.nextToken();
				String encounterId=stEncList.nextToken();
				encounterListArray.add(encounterId);
				}
				
			 //	System.out.println("encounterCombinationArray.size()"+encounterCombinationArray.size());

			} 
		 	
		 	
		 //	System.out.println("encounterListArray-size"+encounterListArray.size());
		 	if(encounterListArray.size() > 1){
		 		out.println("MULTIPLE_ENCOUNTER_SUCCESS");
		 		
		 	}
		 	else{
		 		out.println("MULTIPLE_ENCOUNTER_FAILURE");
		 	}

		}
		
		if(action.equals("clearSession")){
			System.err.println("Inside clear session");
			session.removeAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS");
			out.println("SUCCESS");
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Exception from PkgSubscriptionAssociationDtlsValidation.jsp :"+ e);
	}
%>
