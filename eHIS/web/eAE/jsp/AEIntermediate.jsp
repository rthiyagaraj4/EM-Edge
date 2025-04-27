<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eCommon.Common.*,org.json.simple.*,eAE.*" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj" scope="page" class="webbeans.eCommon.XMLStringParser"/> 
<%
	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	conn=ConnectionManager.getConnection(request);

try{
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String action			=	(String) hash.get("action")==null?"":(String) hash.get("action");
	String facilityId		=	(String)session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("LOCALE"); // added by mujafar for ML-MMOH-CRF-0632
	if (action.equals("validateFollowUp")){
		String pat_id			= (String) hash.get("pat_id");
		String FollowUpCnt_yn	= "N";
		int FollowUpCnt			= eAE.AECommonBean.getFollowUpCnt(conn,pat_id,facilityId);	

		if(FollowUpCnt > 0)
			FollowUpCnt_yn = "Y";
		else
			FollowUpCnt_yn	= "N";

		out.println(FollowUpCnt_yn);
	} 
// added by mujafar for ML-MMOH-CRF-0632	
	if(action.equals("PopulatePatientData"))
	{    
			String pat_id			= (String) hash.get("patientId");
			JSONObject getPatientDetails				= new JSONObject();
			getPatientDetails  = eAE.AECommonBean.getPatientData(conn,pat_id,facilityId,locale);
			
			
			String res_addr_line1     = (String)getPatientDetails.get("res_addr_line1");
			String res_addr_line2     = (String)getPatientDetails.get("res_addr_line2"); 
			String res_addr_line3     = (String)getPatientDetails.get("res_addr_line3"); 
			String res_addr_line4     = (String)getPatientDetails.get("res_addr_line4"); 
			String res_town_desc      = (String)getPatientDetails.get("res_town_desc"); 
			String res_area_desc      = (String)getPatientDetails.get("res_area_desc");  
			String res_region_desc    = (String)getPatientDetails.get("res_region_desc");
			String postal_desc        = (String)getPatientDetails.get("postal_desc"); 
			String res_country_desc   = (String)getPatientDetails.get("res_country_desc");
			String res_tel_no         = (String)getPatientDetails.get("res_tel_no");
			String res_mob_no         = (String)getPatientDetails.get("res_mob_no");
			String res_mail_id        = (String)getPatientDetails.get("res_mail_id");
			String date_of_birth      = (String)getPatientDetails.get("date_of_birth");
			String res_national_id_no = (String)getPatientDetails.get("res_national_id_no");
			String pat_name           = (String)getPatientDetails.get("pat_name");
			String res_town_code      =(String)getPatientDetails.get("res_town_code");
			String res_area_code      =(String)getPatientDetails.get("res_area_code");
			String res_region_code    =(String)getPatientDetails.get("res_region_code");
			String postal_code        =(String)getPatientDetails.get("postal_code");
			String res_country_code   =(String)getPatientDetails.get("res_country_code"); 
			String ocpn_desc          =(String)getPatientDetails.get("ocpn_desc"); // added by mujafar for ML-MMOH-CRF-0632
            //Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008
			String mail_addr_line1     = (String)getPatientDetails.get("mail_addr_line1");
			String mail_addr_line2     = (String)getPatientDetails.get("mail_addr_line2"); 
			String mail_addr_line3     = (String)getPatientDetails.get("mail_addr_line3"); 
			String mail_addr_line4     = (String)getPatientDetails.get("mail_addr_line4"); 
			String mail_town_desc      = (String)getPatientDetails.get("mail_town_desc"); 
			String mail_area_desc      = (String)getPatientDetails.get("mail_area_desc");  
			String mail_region_desc    = (String)getPatientDetails.get("mail_region_desc");
			String mail_postal_desc        = (String)getPatientDetails.get("mail_postal_desc"); 
			String mail_country_desc   = (String)getPatientDetails.get("mail_country_desc");
			String mail_town_code      =(String)getPatientDetails.get("mail_town_code");
			String mail_area_code      =(String)getPatientDetails.get("mail_area_code");
			String mail_region_code    =(String)getPatientDetails.get("mail_region_code");
			String mail_postal_code        =(String)getPatientDetails.get("mail_postal_code");
			String mail_country_code   =(String)getPatientDetails.get("mail_country_code"); 
			String res_contact_name         = (String)getPatientDetails.get("res_contact_name");
			String mail_contact_name         = (String)getPatientDetails.get("mail_contact_name");

			String contact3_mode         = (String)getPatientDetails.get("contact3_mode");
			String contact3_no           = (String)getPatientDetails.get("contact3_no");
			String contact4_mode         = (String)getPatientDetails.get("contact4_mode");
			String contact4_no           = (String)getPatientDetails.get("contact4_no");
			String contact5_mode         = (String)getPatientDetails.get("contact5_mode");
			String contact5_no           = (String)getPatientDetails.get("contact5_no");
			//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
			out.println("PopulatePatData(\"" + res_addr_line1 + "\",\"" + res_addr_line2 + "\",\"" + res_addr_line3 + "\",\"" + res_addr_line4 + "\",\"" + res_town_desc + "\",\"" + res_area_desc + "\",\"" + res_region_desc + "\",\"" + postal_desc + "\",\"" + res_country_desc + "\",\"" + res_tel_no + "\",\"" + res_mob_no + "\",\"" + res_mail_id + "\",\"" + date_of_birth + "\",\"" + res_national_id_no + "\",\"" + pat_name + "\",\"" + res_town_code + "\",\"" + res_area_code + "\",\"" + res_region_code + "\",\"" + postal_code + "\",\"" + res_country_code + "\",\"" + ocpn_desc + "\",\"" + mail_addr_line1 + "\",\"" + mail_addr_line2 + "\",\"" + mail_addr_line3 + "\",\"" + mail_addr_line4 + "\",\"" + mail_town_desc + "\",\"" + mail_area_desc + "\",\"" + mail_region_desc + "\",\"" + mail_postal_desc + "\",\"" + mail_country_desc + "\",\"" + res_contact_name + "\",\"" + mail_contact_name + "\",\"" + mail_town_code + "\",\"" + mail_area_code + "\",\"" + mail_region_code + "\",\"" + mail_postal_code + "\",\"" + mail_country_code + "\",\"" + contact3_mode + "\",\"" + contact3_no + "\",\"" + contact4_mode + "\",\"" + contact4_no + "\",\"" + contact5_mode + "\",\"" + contact5_no + "\");"); // MODIFIED by mujafar for ML-MMOH-CRF-0632
			//Modified by Suji Keerthi for ML-MMOH-CRF-1527 US008
			
		
	}
	if (action.equals("validateNOKNatId")){/*Added by Thamizh selvi on 6th Aug 2018 against ML-MMOH-CRF-1177 Start*/
		String nationalityId	= (String) hash.get("nationalityId");
		String retVal			= "";
		JSONObject dobJSONObj	= new JSONObject();

		dobJSONObj		= eMP.MPCommonBean.getDOBFrmNationalityId(conn, nationalityId);
		String dateOfBirthNOK	= (String)dobJSONObj.get("dateOfBirth");
		String resDOB			= (String)dobJSONObj.get("result");
		String errMesg			= (String)dobJSONObj.get("errorMsg");
		
		retVal = dateOfBirthNOK + "#" + resDOB + "#" + errMesg;
		out.println(retVal);
	}/*End*/

   /*Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022*/ 
	if(action.equals("getPriorityValue")){

		String priority_zone = (String) hash.get("priority_zone");

		JSONArray PriorityValueJsonArr = new JSONArray();
		PriorityValueJsonArr = eAE.AECommonBean.getPriorityValue(conn,locale,priority_zone);
		String PriorityCodeDesc = "";

		for(int i = 0 ; i < PriorityValueJsonArr.size() ; i++) 
		{
			JSONObject json	= (JSONObject)PriorityValueJsonArr.get(i);
			String priority_code = (String) json.get("priority_code");
			String short_desc = (String) json.get("short_desc");

			if(PriorityCodeDesc != ""){
				PriorityCodeDesc = PriorityCodeDesc+"##"+priority_code+"~~"+short_desc;
			}else{
				PriorityCodeDesc = priority_code+"~~"+short_desc;
			}
		}

		out.println(PriorityCodeDesc);
	}
	/*End ML-MMOH-CRF-1975*/
	//Kamatchi added for ML-MMOH-CRF-1972 as on 07-07-2023
	//Starts
	if(action.equals("IPEncPatChk"))
		{    
		String patient_id = (String) hash.get("patient_id");

		int IPEncPat = 0;
		String adtStatus = "";
		String retVal	= "";
		String assign_bed_num = "";
		//IPEncPatVal = eAE.AECommonBean.IPEncPatData(conn, patient_id);
		JSONObject IPEncPatVal				= new JSONObject();
			IPEncPatVal  = eAE.AECommonBean.IPEncPatData(conn, patient_id);
			adtStatus     = (String)IPEncPatVal.get("adtStatus");
			assign_bed_num     = (String)IPEncPatVal.get("assign_bed_num");
			IPEncPat     = (Integer)IPEncPatVal.get("cntYN");
			retVal = adtStatus+"|~|"+IPEncPat+"|~|"+assign_bed_num+"@#";
			out.println(retVal);
		
			}

	}
	catch(Exception e2) { 
		e2.printStackTrace();
	}finally{ 
		if(conn != null) {
			ConnectionManager.returnConnection(conn,request);
		}	
	}                           
%>          
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>              
