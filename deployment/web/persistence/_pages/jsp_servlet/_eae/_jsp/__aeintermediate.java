package jsp_servlet._eae._jsp;

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
import eAE.*;

public final class __aeintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEIntermediate.jsp", 1737437274699L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="          \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="              \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}


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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

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

            _bw.write(_wl_block2Bytes, _wl_block2);
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
