package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import org.json.simple.*;

public final class __mrintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/emr/jsp/MRIntermediate.jsp", 1730782879440L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="          \n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);


Connection conn=null;
	conn=ConnectionManager.getConnection(request);
	
try{
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String action			=	(String) hash.get("action")==null?"":(String) hash.get("action");
	String facilityID				= (String)session.getAttribute("facility_id");
	String locale           = (String) session.getAttribute("LOCALE");

		
		if(action.equals("Self_Prepare_Fwd_Practitioner")) 
		{ // added by mujafar for ML-MMOH-CRF-0718
			 
			
			String loginID = (String) hash.get("loginID");
			
			String resultValue = eMR.MRCommonBean.getSelfPractitioner(conn,loginID,facilityID,locale);
		
			out.println(resultValue);
		}
		else if(action.equals("getSysDateTime")) //  added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
		{
			String resultValue = eCommon.Common.CommonBean.getSystemDateTime(conn);
		
			out.println(resultValue);
			
		}
		else if(action.equals("Med_Rec_Req_Detail")) 
		{ // added by mujafar for ML-MMOH-CRF-0762 start
			 
			
			String requestor_type_code = (String) hash.get("requestor_type_code");
			
			String resultValue = eMR.MRCommonBean.getIndicator(conn,requestor_type_code);
		
			out.println(resultValue);
		}
		else if(action.equals("ChecklistCount"))
		{
			String request_type = (String) hash.get("request_type");
			String requestor_code = (String) hash.get("requestor_code");
			int count=0;
			JSONArray checkListJsonArr = new JSONArray();
			checkListJsonArr = eMR.MRCommonBean.getChecklistValues(conn,request_type,requestor_code);
			count = checkListJsonArr.size();
			out.println(count);
		}
		 // added by mujafar for ML-MMOH-CRF-0762 end
		
		//Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292
		else if (action.equals("previousMonthYear")){
		String req_type	= (String) hash.get("type");
		String date_my	= (String) hash.get("date_my");

		JSONObject dateJSONObj	= new JSONObject();
		dateJSONObj	= eMR.MRCommonBean.getPreviousMonthYear(conn,req_type,date_my);
		String previous_my	= (String)dateJSONObj.get("previous_my");
		
		out.println(previous_my);
		}
		
		//Added by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349
		else if(action.equals("getVisitType"))
		{
			String service_code = (String) hash.get("service_code");
			String clinic_code  = (String) hash.get("clinic_code");
			String facility_id  = (String) hash.get("facility_id");
			String language_id  = (String) hash.get("language_id");
			
			String VisitType = eMR.MRCommonBean.getVisitTypeForService(conn,language_id,facility_id,service_code,clinic_code);
			out.println(VisitType);
		}

		//Added by Ashwini on 24-Oct-2019 for MMS-DM-SCF-0645
		else if(action.equals("getTermCodeEffStatus"))
		{
			String term_code = (String) hash.get("term_code");
			String term_set_id = (String) hash.get("term_set_id");
			
			String eff_status = eMR.MRCommonBean.getTermCodeEffStatus(conn,term_code,term_set_id);
			out.println(eff_status);
		}
		//Added by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1
		else if (action.equals("getDrugCnt")){
			String facility_id = (String) hash.get("facility_id");
			int drug_cnt = eMR.MRCommonBean.getDrugCnt(conn,facility_id);	
			out.println(drug_cnt);
		}
/*Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 Start*/
		else if(action.equals("getMedicalTeam")){
			String Splcode = (String) hash.get("Splcode");
			String facility_id  = (String) hash.get("facility_id");
			JSONArray medicalrepteamJsonArr = new JSONArray();
			medicalrepteamJsonArr  = eMR.MRCommonBean.getMedicalTeamList(conn,facility_id,Splcode,"E",locale);
			String retVal	= "";
			for(int i = 0 ; i < medicalrepteamJsonArr.size() ; i++) 
			{
					JSONObject json	= (JSONObject)medicalrepteamJsonArr.get(i);
					String teamCode  = (String) json.get("team_id");
					String teamDesc  = (String) json.get("short_desc");
					String practList  = (String) json.get("pract_list");
					retVal = retVal+teamCode+"|~|"+teamDesc+"|~|"+practList+"@#";
			}
			out.println(retVal);
		}
		/*Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 End*/
		/*Added By Dharma on 13th Dec 2019 against ML-MMOH-CRF-1362 Start*/
		else if(action.equals("getRequestorAddress")){
			String requestorId		 = (String) hash.get("requestorId");
			String facilityId		 = (String) hash.get("facility_id");
			String returnValue		 = "";	
			JSONObject jsonObj 		 = eMR.MRCommonBean.getRequestorAddress(conn,requestorId,facilityId);
			String addressLine1		 = (String) jsonObj.get("addressLine1"); 
			String addressLine2 	 = (String) jsonObj.get("addressLine2");
			String addressLine3 	 = (String) jsonObj.get("addressLine3");
			String addressLine4		 = (String) jsonObj.get("addressLine4");
			String townCode			 = (String) jsonObj.get("townCode");
			String townDesc			 = (String) jsonObj.get("townDesc");
			String areaCode			 = (String) jsonObj.get("areaCode");
			String areaDesc			 = (String) jsonObj.get("areaDesc");
			String regionCode		 = (String) jsonObj.get("regionCode");
			String regionDesc		 = (String) jsonObj.get("regionDesc");
			String postalCode		 = (String) jsonObj.get("postalCode");
			String PostalDesc		 = (String) jsonObj.get("PostalDesc");
			String countryCode		 = (String) jsonObj.get("countryCode");
			String countryName		 = (String) jsonObj.get("countryName");
			String contactNo1		 = (String) jsonObj.get("contactNo1");
			String contactNo2		 = (String) jsonObj.get("contactNo2");
			String emailId			 = (String) jsonObj.get("emailId");
			
			returnValue = addressLine1+"$@^"+addressLine2+"$@^"+addressLine3+"$@^"+addressLine4+"$@^"+townCode+"$@^"+townDesc+"$@^"+areaCode+"$@^"+areaDesc+"$@^";
			returnValue = returnValue + regionCode+"$@^"+regionDesc+"$@^"+postalCode+"$@^"+PostalDesc+"$@^"+countryCode+"$@^"+countryName+"$@^"+contactNo1+"$@^"+contactNo2+"$@^"+emailId;
			out.println(returnValue);
		}
		/*Added By Dharma on 13t Dec 2019 against ML-MMOH-CRF-1362 End*/ 
		/*Added By Dharma on 4th Mar 2020 against ML-MMOH-CRF-1473 Start*/
		else if(action.equals("getMRReason")){
			String reason = (String) hash.get("reason");
			
			JSONArray reasonJsonArr = new JSONArray();
			reasonJsonArr  = eMR.MRCommonBean.getRejectReportReasonList(conn,reason);
			String retVal	= "";
			for(int i = 0 ; i < reasonJsonArr.size() ; i++) 
			{
					JSONObject json	= (JSONObject)reasonJsonArr.get(i);
					String code  = (String) json.get("reasonCode");
					String desc  = (String) json.get("reasonDesc");
					retVal = retVal+code+"~"+desc+"@#";
			}
			
			out.println(retVal);
		}
		/*Added By Dharma on 4th Mar 2020 against ML-MMOH-CRF-1473 End*/
		/*Added By Dharma on June 30th 2020 against AAKH-CRF-0122.2 Start*/
		else if(action.equals("getTermCodeDesc")) {
			System.err.println("Here");
			String termCode = (String) hash.get("termCode");
			String termSetId  = (String) hash.get("termSetId");
			System.err.println("termCode==>"+termCode);
			System.err.println("termSetId==>"+termSetId);
			String termCodeDesc = eMR.MRCoaderDiagBean.getTermCodeDesc(conn,termSetId,termCode,locale);
			System.err.println("termCodeDesc==>"+termCodeDesc); 
			out.println(termCodeDesc);
		}else if(action.equals("getDiagClassification")) {
			JSONArray diagClassicationArr = new JSONArray();

			String termSetId  = (String) hash.get("termSetId");
			diagClassicationArr = eMR.MRCoaderDiagBean.getDiagClassification(conn,termSetId,locale);
			out.println(diagClassicationArr.toString());
		}
		/*Added By Dharma on June 30th 2020 against AAKH-CRF-0122.2 End*/

		/*Added by Ashwini on 03-Sep-2020 for ML-MMOH-CRF-1351*/
		else if (action.equals("getEDOBClinicCnt")){
			String clinic_code = (String) hash.get("clinic_code");
			String facility_id = (String) hash.get("facility_id");
			String service_code = (String) hash.get("service_code");
			int clinic_cnt = eMR.MRCommonBean.getEDOBClinicCnt(conn,clinic_code,facility_id,service_code);
			out.println(clinic_cnt);
		}
		/*End ML-MMOH-CRF-1351*/

		/*Added by Arthi on 12-Oct-2022 for ML-MMOH-SCF-2123*/
		else if (action.equals("getFreeTextApplYN")){
			String termset_id = (String) hash.get("termset_id");
			String free_text_applicable_yn = eMR.MRCommonBean.getFreeTextApplYN(conn,termset_id);
			out.println(free_text_applicable_yn);
		}
		/*End ML-MMOH-SCF-2123*/

		/*Added by kamatchi S */
		else if (action.equals("getRestrictDrugYN")){
			String patient_id = (String) hash.get("patient_id");
			String Encounter_Id = (String) hash.get("Encounter_Id");
			String diagcode = (String) hash.get("diagcode");
			String diagset = (String) hash.get("diagset");
			String retVal	= "";
			String diagdesc	= "";
			PreparedStatement pstmt	= null;
			ResultSet rset 			= null;
			String sql = "select SHORT_DESC from mr_term_code where term_set_id = '"+diagset+"' and term_code ='"+diagcode+"' " ;
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset != null && rset.next()) 
			{  			
				diagdesc	= rset.getString("SHORT_DESC") == null ? "" : rset.getString("SHORT_DESC");
			}
			//String get_Restrict_Drug_YN = eMR.MRCommonBean.getRestrictYN(conn,patient_id,Encounter_Id,diagcode,locale,diagset);
			JSONObject get_Restrict_Drug_YN	= new JSONObject();
			get_Restrict_Drug_YN	= eMR.MRCommonBean.getRestrictYN(conn,patient_id,Encounter_Id,diagcode,locale,diagset);
			String restrictYN	= (String)get_Restrict_Drug_YN.get("restrictYN");
			Boolean checkDrug	= (Boolean)get_Restrict_Drug_YN.get("checkDrug");
			int cnt	= (Integer)get_Restrict_Drug_YN.get("cnt");
			retVal = restrictYN+"|~|"+checkDrug+"|~|"+cnt+"|~|"+diagdesc+"@#";
			out.println(retVal);
		}
		/*End*/

		

		
	}

	catch(Exception e) { 
	e.printStackTrace();

}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
}                           

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
