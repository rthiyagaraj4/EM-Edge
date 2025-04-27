<%@page import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=ISO-8859-1"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
10/01/2019	  	IN068344	     	Manickavasagam 		  								GHL-CRF-0549 [IN068344] 
30/06/2020		IN072347			Shazana												GHL-CRF-0619 
21/01/2021	    TFS-12204            Prabha      21/01/2021	  Manickavasagam J          MMS-DM-CRF-0177
03/02/2021		TFS-15266          Haribabu   03/02/2021     Manickavasagam J           NMC-JD-SCF-0159
03/01/2022		TFS-26862			Prabha												GHL-ICN-0090
--------------------------------------------------------------------------------------------------------------
*/ 

request.setCharacterEncoding("UTF-8");
//Added for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String bean_id	= request.getParameter( "bean_id" ) ;
	String bean_name= request.getParameter( "bean_name" ) ;
	String criteria	= request.getParameter( "criteria" );
	String normalRx_yn = request.getParameter("normalRx_yn")==null?"":request.getParameter("normalRx_yn");//GHL-CRF-0549

	Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	DrugSearchBean bean = (DrugSearchBean)getBeanObject( bean_id,bean_name, request ) ;
	//added for GHL-CRF-0619 
	boolean	result					=	false;
	String message			=	"";
	String flag				=	"";
	//added try catch block for GHL-CRF-0619 
	try{
		
		
		if (criteria.equals("Other")){
			bean.resetSelectedDrugsList();
			bean.setOtherCriteriaData(hash);
			out.println("showSearchResults('"+normalRx_yn+"')"); //GHL-CRF-0549
		}
		else if (criteria.equals("Main")){
			bean.resetSelectedDrugsList();
			hash.put("name",java.net.URLDecoder.decode((String)hash.get("name"),"UTF-8"));  
			/* code added for Bru-HIMS-CRF-070 [IN029935] --Start --*/
			String npb_drug	= hash.get( "npb_drug" ) ==null?"":(String)hash.get( "npb_drug" );		
			bean.setNPBDrug(npb_drug);
			/* code added for Bru-HIMS-CRF-070 [IN029935] --End --*/
			bean.setMainCriteriaData(hash);
			out.println("showSearchResults('"+normalRx_yn+"')");//GHL-CRF-0549
		}
		else if(criteria.equals("StoreDrugs")){
				
			bean.storeSelectedDrugs(hash);
			Hashtable ht=bean.getSelectedDrugs();
		
			if (ht.size()>0){
				out.println("enableDisableSelectButton('false')");
			}
			else{
				out.println("enableDisableSelectButton('true')");
			}
		}
		else if(criteria.equals("getSelectedDrugs")){
			Hashtable ht=bean.getSelectedDrugs();
			out.println("returnDrugs('"+ht.values()+"')");
			bean.resetSelectedDrugsList();
		} 
		else if(criteria.equals("checkforpromptalertmsg")){
			String drug_code	= request.getParameter( "drug_code" ) ;
			String  promptalertmsg=bean.getAlert_YN(drug_code);
			promptalertmsg=promptalertmsg.replaceAll(" ","%20");
			promptalertmsg = java.net.URLEncoder.encode(promptalertmsg,"UTF-8");
			promptalertmsg=promptalertmsg.replaceAll("%2520","%20");
			if(! promptalertmsg.equals("") && !( promptalertmsg==null )){
			  out.println("returncheckforpromptalertmsg('"+promptalertmsg+"')");
			}
		}  //added for GHL-CRF-0619 
		else if(criteria.equals("checkforBrand")){
			HashMap orderDetails= new HashMap();
			ArrayList drugDetails = new ArrayList();
			HashMap record	=	null;
		
			String drug_code	= request.getParameter( "drug_code" ) ;
			String encounter_id	= request.getParameter( "encounter_id" ) ;
			String patient_id	= request.getParameter( "patient_id" ) ;
			String drug_desc	= request.getParameter( "drug_desc" ) ; //added for GHL-ICN-0090
			String remarks      	= "";
			//select generic id of the item selected
			String genericId = bean.getGenericId(drug_code);
		
			drugDetails = bean.getDrugProfileDtls(patient_id,genericId,encounter_id); 
		
			if(drugDetails!=null && drugDetails.size()>0){
				record=	(HashMap)drugDetails.get(0); 
				message = (String)record.get("DRUG_DESC");
				remarks = (String)record.get("REMARKS");
				
				if(remarks==null)
					remarks = "";


					if(!drug_code.equalsIgnoreCase((String)record.get("DRUG_CODE"))){
						//System.out.println("different item - display alert"); 
						result=true;
					}
					else{
						//System.out.println("same item - no alert"); 
						result=false;
					}		
				
				
			}else{
				result=false;
			}
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\",'', \"" + remarks + "\",\"" + drug_desc + "\" ) ; ") ;	//drug_desc added for GHL-ICN-0090	
		}
	 else if(criteria.equals("drugSearch")) //Added for MMS-DM-CRF-0177
		{
			String code	= request.getParameter( "code" ) ;
			String generic_trade	= request.getParameter( "generic_trade" ) ;
			if(!code.equals("")){  // Added for NMC-JD-SCF-0159
				bean.setGenericOrTradeCode(code);
				bean.setSearchByGenericOrTrade(generic_trade);
			} // Added for NMC-JD-SCF-0159
			HashMap record = new HashMap(); 
			ArrayList form_code = bean.getListValuesForForm(code, generic_trade);
			out.println("clearListItems('frmDrugNameCommonLookupSearchCriteria.form_desc'); ");
			for(int i=0; i< form_code.size(); i++) {
						record = (HashMap)form_code.get(i);
						out.println("addListItem(\"frmDrugNameCommonLookupSearchCriteria.form_desc\", \"" + record.get("CODE") + "\",\"" + record.get("DESCRIPTION") + "\");");
						
					}
			 record = new HashMap(); 
			 ArrayList strength_code = bean.getListValuesForStrength(code, generic_trade);
			 out.println("clearListItems('frmDrugNameCommonLookupSearchCriteria.strength_uom'); ");
			 for(int i=0; i< strength_code.size(); i++) {
					record = (HashMap)strength_code.get(i);
					out.println("addListItem(\"frmDrugNameCommonLookupSearchCriteria.strength_uom\", \"" + record.get("CODE") + "\",\"" + record.get("DESCRIPTION") + "\");");
					
				}
		}  //Added for MMS-DM-CRF-0177
	
	 else if(criteria.equals("cleargenericcode")) // Added for NMC-JD-SCF-0159 - Start
		{
			
				bean.setGenericOrTradeCode("");
				bean.setSearchByGenericOrTrade("");
			
			HashMap record = new HashMap(); 
			ArrayList form_code = bean.getListValuesForForm("%", "");
			out.println("clearListItems('frmDrugNameCommonLookupSearchCriteria.form_desc'); ");
			for(int i=0; i< form_code.size(); i++) {
						record = (HashMap)form_code.get(i);
						out.println("addListItem(\"frmDrugNameCommonLookupSearchCriteria.form_desc\", \"" + record.get("CODE") + "\",\"" + record.get("DESCRIPTION") + "\");");
						
					}
			 record = new HashMap(); 
			 ArrayList strength_code = bean.getListValuesForStrength("%", "");
			 out.println("clearListItems('frmDrugNameCommonLookupSearchCriteria.strength_uom'); ");
			 for(int i=0; i< strength_code.size(); i++) {
					record = (HashMap)strength_code.get(i);
					out.println("addListItem(\"frmDrugNameCommonLookupSearchCriteria.strength_uom\", \"" + record.get("CODE") + "\",\"" + record.get("DESCRIPTION") + "\");");
					
				}
		}  // Added for NMC-JD-SCF-0159 - End
		//Added for TFS id:-16341
		 else if(criteria.equals("setDispLocnCode")) 
			{
				String disp_locn_code	= request.getParameter( "disp_locn_code" ) ;
				bean.setDispLocnCode(disp_locn_code) ;
			}
		//Added for TFS id:-16341
	}
	catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
		exception.printStackTrace();
		System.out.println(exception.toString());
	}
	
	putObjectInBean(bean_id,bean,request);
%>
