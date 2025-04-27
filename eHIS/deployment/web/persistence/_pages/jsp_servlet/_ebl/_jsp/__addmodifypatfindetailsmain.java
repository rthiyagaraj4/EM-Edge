package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import java.text.*;
import eBL.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __addmodifypatfindetailsmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinDetailsMain.jsp", 1739161915646L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n<script>\n\twindow.name = \'Financial Details\';\n//\talert(\"window.name:\"+window.name);\n</script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eBL/js/AddModifyPatFinDetails.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<iframe name=\'tab_frames\' id=\'tab_frames\' SRC=\"AddModifyPatFinDetailsMainTabs.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"  frameborder=0 scrolling=\'no\' noresize style=\'height:3vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'MainFrame2\' id=\'MainFrame2\' SRC=\"../../eCommon/html/blank.html\" frameborder=0 \' scrolling=\'no\' noresize style=\'height:75vh;width:100vw\'></iframe>\n\t\t\t<!--\n\t\t\t<frame name=\'MainFrame2\'\t\tsrc=\'AddModifyPatFinClassDetailsMain.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' frameborder=0 noresize scrolling=\'no\' noresize>\n\t\t\t-->\n\t\t\t<iframe SRC=\"../../eCommon/html/blank.html\" frameborder=0 name=\'DummyFrame\' id=\'DummyFrame\' scrolling=\'no\' noresize style=\'height:0vh;width:100vw\'></iframe>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t <iframe SRC=\"AddModifyPatFinDetails.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" name=\'MainFrame1\' id=\'MainFrame1\' frameborder=0 scrolling=\'no\' noresize style=\'height:21vh;width:100vw\'></iframe>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<!--\n\t<iframe SRC=\"AddModifyPatFinDetails6.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" frameborder=0 name=\'MainFrame2\' scrolling=\'no\' noresize></iframe> \n-->\n\t\t\t<iframe SRC=\"../../eCommon/html/blank.html\" frameborder=0 name=\'MainFrame2\' id=\'MainFrame2\' scrolling=\'no\' noresize style=\'height:81vh;width:100vw\'></iframe>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<iframe SRC=\"../../eCommon/html/blank.html\" frameborder=0 name=\'MainFrame2\' id=\'MainFrame2\' scrolling=\'no\' noresize style=\'height:81vh;width:100vw\'></iframe>\n\t\t\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<iframe SRC=\"../../eCommon/html/blank.html\" frameborder=0 name=\'DummyFrame\' id=\'DummyFrame\' scrolling=\'no\' noresize style=\'height:0vh;width:100vw\'></iframe>\n\t\t\t<iframe SRC=\"BLValidation.jsp\" frameborder=0 name=\'ValidFrame\' id=\'ValidFrame\' scrolling=\'yes\' noresize style=\'height:0vh;width:100vw\'></iframe>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\n</html>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con = null;
	CallableStatement call =null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1  = null;
	PreparedStatement pstmt2  = null;
	PreparedStatement pstmt3  = null;

	Statement stmt1 = null;		
	ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	ResultSet rs4 = null;
	ResultSet rsm = null;
	
	try
	{
		request.setCharacterEncoding("UTF-8");
		con=ConnectionManager.getConnection(request);
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
//		String strclientip = p.getProperty("client_ip_address");
//		String sys_date_wht_sec="";
		String regn_date_time="";
		String patient_id ="";
		String user_id = "";
		String fin_class_flag_YN="", called_locn="", fin_dtls_updated_YN="N";
		String mp_dflt_YN="";
		String enc_dflt_YN="";
		String mp_dflt_frst_enc_YN="N";
		String provselfrmprevencyn="N", dflt_prv_fin_dtl_acrs_enc_yn="N";
		String no_rec_found_in_enc_level_YN="N";
		String package_enabled_yn = "N";
		String inside_loop_chk="N";
		int assessmentMonths = 0;

		String charge_for_pat_regn_yn="N";
		String fin_class_flag_setup_YN = "N"; // Added for PE Changes

		String third_party_gl_in_use_yn = "N";
		String third_party_gl_mandatory_yn = "N";
		String capture_employer_id_yn = "N";

		System.err.println("From Main Query String:"+request.getQueryString());		
		String locale	= (String)session.getAttribute("LOCALE");
		if(locale==null) locale="";

		String facility_id = (String)httpSession.getValue("facility_id");
		if(facility_id==null) facility_id="";

		String strModuleId = request.getParameter("calling_module_id");
		if (strModuleId==null)			strModuleId ="";

		String clinic_code = request.getParameter("clinic_code");
		if(clinic_code==null) clinic_code="";
		
		String pat_regn_date_time = request.getParameter("pat_regn_date_time");
		if(pat_regn_date_time == null) pat_regn_date_time="";

		String calling_function_id = request.getParameter("calling_function_id");
		if(calling_function_id == null) calling_function_id="";

		String disaster_regn_YN = request.getParameter("disaster_regn_YN");
		if(disaster_regn_YN == null) disaster_regn_YN="";
		
		String classTypChangeAuthYN = request.getParameter("isUserAuthorizedClass");
		if(classTypChangeAuthYN == null) classTypChangeAuthYN="";
		
		String episode_id="",visit_id="";
		String slmt_type_code="",inst_ref="", inst_date="",inst_remarks="";
		String class_type="" , class_code="", blng_grp_id="", cust_code="", cust_grp_code="";
		String credit_doc_ref_desc="",credit_doc_ref_start_date="",credit_doc_ref_date="";
		String class_defn_no="";
		String slmt_ind="", adm_rec_flag="";
		String non_ins_blng_grp_id="",non_ins_cust_group_code="",non_ins_cust_code="",non_ins_settlement_ind="";

		String rtn_slmt_type_code="",rtn_inst_ref="",rtn_inst_date="",rtn_inst_remarks="";
		String rtn_credit_cust_group_code="", rtn_credit_cust_code="", rtn_credit_doc_ref="", rtn_credit_doc_start_date=""; 
		String rtn_credit_doc_end_date="", rtn_sponsor_cust_group_code="", rtn_sponsor_cust_code="",rtn_sponsor_credit_doc_ref="";
		String rtn_sponsor_credit_doc_start_date="", rtn_sponsor_credit_doc_end_date="";
		String rtn_credit_doc_reqd_yn="N";
		
		String upd_fin_dtls="C";
		String rtn_ins_blng_grp="",rtn_ins_cust_group_code="",rtn_ins_cust_code="",rtn_ins_cust_priority="",rtn_ins_policy_type_code="",rtn_ins_policy_no="";
		String rtn_ins_restrict_check = "", rtn_ins_apprd_amt_restrict_check = "", rtn_ins_apprd_days_restrict_check= "";
		String rtn_ins_cred_auth_req_yn = "", rtn_ins_dflt_auth_ref_as_pol_no_yn = "";

		String rtn_ins_policy_start_date="",rtn_ins_policy_expiry_date="",rtn_ins_credit_auth_ref="",rtn_ins_credit_auth_date="";
		String rtn_ins_credit_approval_days="",rtn_ins_credit_approval_amount="",rtn_ins_policy_eff_from_date="",rtn_ins_policy_eff_to_date="";
		String rtn_ins_adj_rule_ind="",rtn_ins_adj_perc_amt_ind="",rtn_ins_adj_perc_amt_value="",rtn_ins_pmnt_diff_adj_int="",rtn_ins_drg_pmnt_diff_adj_int="",rtn_ins_spl_srv_pmnt_diff_adj_int="";

		String rtn_non_ins_blng_grp="",rtn_non_ins_cust_group_code="",rtn_non_ins_cust_code="",rtn_non_ins_credit_doc_reqd_yn="",rtn_non_ins_slmt_type_code="";
		String rtn_non_ins_inst_ref="",rtn_non_ins_inst_date="",rtn_non_ins_inst_remarks="",rtn_non_ins_credit_doc_ref="",rtn_non_ins_credit_doc_start_date="",rtn_non_ins_credit_doc_end_date="";

		String rtn_blng_class_code="",rtn_employer_code="";
//		String rtn_blng_grp="";
//		String rtn_slmt_ind="";
		String rtn_annual_family_income="",rtn_family_assets_value="",rtn_num_of_dependents="";
		String rtn_resp_for_bill_payment="",rtn_pat_reln_with_resp_pers="",rtn_gl_holder_name="",rtn_pat_reln_with_gl_holder="";
		String rtn_ref_src_main_code="",rtn_ref_src_main_desc="",rtn_ref_src_sub_code="",rtn_ref_src_sub_desc="";
		String rtn_ins_ref_src_main_code="", rtn_ins_ref_src_main_desc="", rtn_ins_ref_src_sub_code="", rtn_ins_ref_src_sub_desc="";
		String rtn_non_ins_ref_src_main_code="", rtn_non_ins_ref_src_main_desc="", rtn_non_ins_ref_src_sub_code="", rtn_non_ins_ref_src_sub_desc="";
		String rtn_remarks="";

		String rtn_inc_asset_ind="",rtn_ind_inc="",rtn_ind_inc_freq="",rtn_spouse_inc="",rtn_spouse_inc_freq="",rtn_dependent_inc="",rtn_dependent_inc_freq="",rtn_valid_from="",rtn_valid_to="",rtn_last_date="",rtn_social_pensioner_id="";
//		String rtn_class_code="", rtn_class_type="";

		String temp_ins_blng_grp="",temp_ins_cust_group_code="",temp_ins_cust_code="",temp_ins_cust_priority="",temp_ins_policy_type_code="",temp_ins_policy_no="";
		String temp_ins_policy_start_date="",temp_ins_policy_expiry_date="",temp_ins_credit_auth_ref="",temp_ins_credit_auth_date="";
		String temp_ins_credit_approval_days="",temp_ins_credit_approval_amount="",temp_ins_policy_eff_from_date="",temp_ins_policy_eff_to_date="";
		String temp_ins_adj_rule_ind="",temp_ins_adj_perc_amt_ind="",temp_ins_adj_perc_amt_value="",temp_ins_pmnt_diff_adj_int="",temp_ins_drg_pmnt_diff_adj_int="",temp_ins_spl_srv_pmnt_diff_adj_int="";

		String temp_ins_ref_src_main_code="", temp_ins_ref_src_main_desc="", temp_ins_ref_src_sub_code="", temp_ins_ref_src_sub_desc="";

		String restrict_check="", apprd_amt_restrict_check = "", apprd_days_restrict_check = "";
		String cred_auth_req_yn ="", dflt_auth_ref_as_pol_no_yn = "";

		String rtn_tot_valid_enc_with_gl="", rtn_tot_valid_op_enc_with_gl="", rtn_tot_valid_ae_enc_with_gl="", rtn_tot_valid_ip_enc_with_gl ="", rtn_tot_valid_dc_enc_with_gl="";
		
		String no_of_enc_gl_availed="0",no_of_op_enc_gl_availed="0",no_of_ae_enc_gl_availed="0",no_of_ip_enc_gl_availed="0",no_of_dc_enc_gl_availed="0";

		String gl_doc_ref_exist_YN="N";

		String rtn_is_special_clinic_related = "N";

		String strEpisodeType = "";
		HashMap tabdata=(HashMap)session.getAttribute("financial_details");
		String new_moduleId="";
		if(tabdata !=null){
			if((String)tabdata.get("moduleId_new") != null ){
		 new_moduleId=((String)tabdata.get("moduleId_new")).trim();
		 if(new_moduleId==null) new_moduleId="";
			}
		}		
		
		// karthik added code on 5-25-2013 INCLUDE_POLICY_DETAILS_CRF			
		String addedFacilityId =(String) session.getValue("facility_id");

		String policyBLInclusionFlag=null;
		String  dflt_policy_vst_reg = null;
		String policyValidQry="select charge_logic_yn,DFLT_POLICY_DEF_IN_VIS_REG_YN from bl_parameters  where operating_facility_id ='"+addedFacilityId+"'";

		try{
			pstmt = con.prepareStatement(policyValidQry);
			rs=pstmt.executeQuery();
			if( rs != null ) 
			{
				while(rs.next())
				{
					policyBLInclusionFlag=rs.getString(1);					
					dflt_policy_vst_reg=rs.getString(2);
					dflt_policy_vst_reg=dflt_policy_vst_reg==null?"N":dflt_policy_vst_reg;
				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		catch(Exception e){
		System.err.println("Error in AddModifyPatFinDetailsInsBody.jsp while getting charge_logic_yn");
		}
		if(policyBLInclusionFlag==null || policyBLInclusionFlag.equals("")){
			policyBLInclusionFlag="N";
		}
		session.setAttribute("LINK_POLICY_IN_BILLING",policyBLInclusionFlag);	
		System.err.println("LINK_POLICY_IN_BILLING"+(String)session.getAttribute("LINK_POLICY_IN_BILLING"));	

		//karthik added code INCLUDE_POLICY_DETAILS_CRF ends		

		if (strModuleId.equals("OP")) 
		{
			strEpisodeType = "O";
		}
		else if (strModuleId.equals("AE")) 
		{
			strEpisodeType = "E";
		}
		else if (strModuleId.equals("IP")) 
		{
			strEpisodeType = "I";
		}
		else if (strModuleId.equals("DC")) 
		{
			strEpisodeType = "D";
		}
		else if(strModuleId.equals("MP"))
		{
			strEpisodeType = "R";
		}

		called_locn = request.getParameter("called_locn");
		if (called_locn==null)			called_locn ="";

		patient_id = request.getParameter("patient_id");
		if(patient_id == null) patient_id="";

		fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="";

		//Rajesh V Added

		String vstDtTime = request.getParameter("vst_regn_date_time");
		if(vstDtTime == null){
			vstDtTime = "";
		}
	//	String vstDtTimeAtt[] = vstDtTime.split(" ");
		//session.setAttribute("clinic_code_bl_op",clinic_code+"::##"+patient_id+"::##"+strEpisodeType+"::##"+calling_function_id+"::##"+vstDtTimeAtt[0]);

		session.setAttribute("clinic_code_bl_op",clinic_code+"::##"+patient_id+"::##"+strEpisodeType+"::##"+calling_function_id+"::##"+vstDtTime);	
		
		// clear bean values   Insurance master bean....		
		
		/*Added by karthik to clear session Beans INCLUDE_POLICY_DETAILS_CRF - Starts*/

/*added beans commented by DhanasekarV  02/10/2013 */		
		String  prev_patient_id = "";
		String  prev_session_id = "";
		String  cur_session_id = "";

		String practo_appt_yn=request.getParameter("isPractoApptYn");
		if(practo_appt_yn == null) practo_appt_yn="N";		

		prev_patient_id = ""+session.getAttribute("PREV_PAT_ID_SESS_REF");		
		if( prev_patient_id .equals("null") )  prev_patient_id ="";
		
		if(patient_id .equals("null") )  patient_id ="";				
		
		if((prev_patient_id.length() > 0 && patient_id.length()==0) || (patient_id.length() > 0 && patient_id.equals(prev_patient_id)== false))
		{
			String pol_bean_id		= "PayerPolicyInsuranceMasterBean" ;
			String pol_bean_name	= "eBL.PolicyInsuranceMasterBean";
			PolicyInsuranceMasterBean pol_bean			= (PolicyInsuranceMasterBean)getBeanObject( pol_bean_id, pol_bean_name, request ) ;
			if(pol_bean!=null)
			pol_bean.clearAll();
			cleanBeanObject(pol_bean_id, pol_bean_name, request);

			String enc_pol_bean_id		= "EncPolicyInsuranceMasterBean" ;
			String enc_pol_bean_name	= "eBL.PolicyInsuranceMasterBean";							
			PolicyInsuranceMasterBean enc_pol_bean		= 	(PolicyInsuranceMasterBean)getBeanObject( enc_pol_bean_id, enc_pol_bean_name, request ) ;
			if(enc_pol_bean!=null)
			enc_pol_bean.clearAll();
			cleanBeanObject(enc_pol_bean_id, enc_pol_bean_name, request );
			/* 12/07/2013	Karthikeyan K	MMS-QH-CRF-0010	36789 starts*/
			session.setAttribute("VALID_ACROSS_ENCOUNTER_MAP",null);			
			session.setAttribute("ENCOUNTER_POLICY_RECORD_ELEMENTS",null);			
			session.setAttribute("CLAIM_CREDIT_MAP_SESSION",null); //Karthik added the code to add claim code starts  - IN50355
		}	
		session.setAttribute("PREV_PAT_ID_SESS_REF",patient_id);	

		/*end clear session   commented by DhanasekarV  02/10/2013 */	

	/*clear beans commented by DhanasekarV  02/10/2013
		if(patient_id!=null && !patient_id.equals("")){		

			if(session.getAttribute("PREV_PAT_ID_SESS_REF")==null){		
				session.setAttribute("PREV_PAT_ID_SESS_REF", patient_id);
			}
			else{
				
				String prevPatID=(String)session.getAttribute("PREV_PAT_ID_SESS_REF");

				if(!prevPatID.equals(patient_id)){
					
					System.err.println("KKKK Clearing Session");
					
					String pol_bean_id		= "PayerPolicyInsuranceMasterBean" ;
					String pol_bean_name	= "eBL.PolicyInsuranceMasterBean";
					PolicyInsuranceMasterBean pol_bean			= (PolicyInsuranceMasterBean)getBeanObject( pol_bean_id, pol_bean_name, request ) ;
					if(pol_bean!=null)
					pol_bean.clearAll();
					cleanBeanObject(pol_bean_id, pol_bean_name, request);
					
					String enc_pol_bean_id		= "EncPolicyInsuranceMasterBean" ;
					String enc_pol_bean_name	= "eBL.PolicyInsuranceMasterBean";							
					PolicyInsuranceMasterBean enc_pol_bean		= 	(PolicyInsuranceMasterBean)getBeanObject( enc_pol_bean_id, enc_pol_bean_name, request ) ;
					if(enc_pol_bean!=null)
					enc_pol_bean.clearAll();
					cleanBeanObject(enc_pol_bean_id, enc_pol_bean_name, request );

					session.setAttribute("VALID_ACROSS_ENCOUNTER_MAP",null);
					
				}

				session.setAttribute("PREV_PAT_ID_SESS_REF", patient_id);
			}
			
		}
		
	*/
		
		
		
		// end clear bean values insurance master bean
		
		
		
		
		
		
		
		//Rajesh V Added

		try
		{
			pstmt = con.prepareStatement("Select AUTO_FIN_CLASSFCTN_IN_USE_YN, CHARGE_FOR_PAT_REGN_YN,ASSESSMENT_MONTHS,nvl(third_party_gl_in_use_yn,'N') third_party_gl_in_use_yn, nvl(third_party_gl_mandatory_yn,'N') third_party_gl_mandatory_yn, NVL(capture_employer_id_yn,'N') capture_employer_id_yn,bl_package_enabled_yn(?) bl_package_enabled_yn from BL_PARAMETERS Where OPERATING_FACILITY_ID = ?");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,facility_id);
			rs = pstmt.executeQuery() ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					fin_class_flag_setup_YN = rs.getString("AUTO_FIN_CLASSFCTN_IN_USE_YN");
					charge_for_pat_regn_yn = rs.getString("CHARGE_FOR_PAT_REGN_YN");
					assessmentMonths = rs.getInt("ASSESSMENT_MONTHS");
					third_party_gl_in_use_yn = rs.getString("third_party_gl_in_use_yn");
					third_party_gl_mandatory_yn = rs.getString("third_party_gl_mandatory_yn");
					capture_employer_id_yn = rs.getString("capture_employer_id_yn");
					package_enabled_yn = rs.getString("bl_package_enabled_yn");
				}
			}
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();

			if(fin_class_flag_setup_YN == null) fin_class_flag_setup_YN="N";
			if(charge_for_pat_regn_yn == null) charge_for_pat_regn_yn="N";
			if (third_party_gl_in_use_yn == null ) third_party_gl_in_use_yn ="N";
			if (third_party_gl_mandatory_yn == null ) third_party_gl_mandatory_yn ="N";
			if (capture_employer_id_yn == null ) capture_employer_id_yn = "N";	

			System.err.println("From Query charge_for_pat_regn_yn:"+charge_for_pat_regn_yn);
		}
		catch(Exception e)
		{
			out.println("Exception in sql_charge_for_pat_regn_yn::"+e);
			System.err.println("Exception in sql_charge_for_pat_regn_yn::"+e);
		}
		if(charge_for_pat_regn_yn == null) charge_for_pat_regn_yn="N";

		if(fin_class_flag_YN.equals("") && !calling_function_id.equals("BOOKING"))
		{
			/*String sql_bl_class = "Select AUTO_FIN_CLASSFCTN_IN_USE_YN from BL_PARAMETERS Where OPERATING_FACILITY_ID = '"+facility_id+"'";
			try
			{
				pstmt = con.prepareStatement(sql_bl_class);
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{
					while( rs.next() )
					{  
						fin_class_flag_YN = rs.getString(1);
					}
				}
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
				System.err.println("From Query fin_class_flag_YN:"+fin_class_flag_YN);
			}
			catch(Exception e)
			{
				out.println("Exception in sql_bl_class::"+e);
				System.err.println("Exception in sql_bl_class::"+e);
			}
			if(fin_class_flag_YN == null) fin_class_flag_YN="N";		
			Commented for PE Changes */ 
			fin_class_flag_YN = fin_class_flag_setup_YN;
		}
/*	Commented for PE Changes	
		try
		{
			String sql_bl_class = "Select ASSESSMENT_MONTHS from BL_PARAMETERS Where OPERATING_FACILITY_ID = '"+facility_id+"'";

			pstmt = con.prepareStatement(sql_bl_class);
			rs = pstmt.executeQuery() ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					assessmentMonths = rs.getInt("ASSESSMENT_MONTHS");
				}
			}
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
			System.err.println("From Query assessmentMonths:"+assessmentMonths);

			if(fin_class_flag_YN == null) fin_class_flag_YN="N";
		}
		catch(Exception e)
		{
			System.err.println("Exception in mp_dflt_YN_qry:"+e);
		}
*/
		try
		{
			String mp_dflt_YN_qry="select nvl(DFLT_PAT_BG_FOR_ENCNTR_REGN_YN,'N'),nvl(DFLT_LAST_ENCTR_FIN_DTLS_YN,'N'),nvl(DFLT_PAT_FIN_FOR_FST_ENC_YN,'N'),nvl(PROV_TO_SEL_FROM_PRV_ENCTRS_YN,'N') prov_sel_frm_prev_enc,nvl(DFLT_PRV_FIN_DTL_ACROSS_ENC_YN,'N') from bl_mp_param";

			pstmt = con.prepareStatement(mp_dflt_YN_qry);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() )
				{  
					mp_dflt_YN = rs2.getString(1);			
					enc_dflt_YN = rs2.getString(2);
					mp_dflt_frst_enc_YN= rs2.getString(3);
					provselfrmprevencyn = rs2.getString(4);		
					dflt_prv_fin_dtl_acrs_enc_yn = rs2.getString(5);		
				}
			}
			if (rs2 != null) rs2.close();
			pstmt.close();

			if(mp_dflt_YN == null) mp_dflt_YN="N";
			if(enc_dflt_YN == null) enc_dflt_YN="N";
			if(mp_dflt_frst_enc_YN == null) mp_dflt_frst_enc_YN="N";
			if(provselfrmprevencyn == null) provselfrmprevencyn="N";
			if(dflt_prv_fin_dtl_acrs_enc_yn == null) dflt_prv_fin_dtl_acrs_enc_yn="N";
			System.err.println("From Query mp_dflt_YN_qry:"+mp_dflt_YN_qry);
		}
		catch(Exception e)
		{
			System.err.println("Exception in mp_dflt_YN_qry:"+e);
		}

		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);
		//String dflt_pat_bg_for_encntr_regn_yn = "";
//Commented for PE Changes-query moved above
	/*
		String sql_param = "select nvl(dflt_pat_bg_for_encntr_regn_yn,'N') bg from bl_mp_param ";
		try
		{
			pstmt = con.prepareStatement(sql_param);
			rset = pstmt.executeQuery() ;
			if( rset != null ) 
			{
				while( rset.next() )
				{  
					dflt_pat_bg_for_encntr_regn_yn = rset.getString("bg");
				}
			}
			if (pstmt != null) pstmt.close();
			if (rset != null) rset.close();
		}
		catch(Exception e)
		{
			out.println("Exception in Accessing BL_MP_PARAM::"+e);
		}
	*/
		if(strModuleId.equals("MP"))
		{
			if(patient_id.equals(""))
			{
				String regn_date_time_qry="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
				stmt1 = con.createStatement();
				rs4 = stmt1.executeQuery(regn_date_time_qry) ;
				if( rs4 != null ) 
				{
					while( rs4.next() )
					{  
						regn_date_time = rs4.getString(1);
					}
				}
			}
			else
			{
				String regn_date_time_qry="select to_char(REGN_DATE,'dd/mm/yyyy HH24:MI') from mp_patient where patient_id= ? ";
				//stmt1 = con.createStatement();
				pstmt = con.prepareStatement(regn_date_time_qry);
				pstmt.setString(1,patient_id);
				rs4 = pstmt.executeQuery() ;
				
				if( rs4 != null ) 
				{
					while( rs4.next() )
					{  
						regn_date_time = rs4.getString(1);
					}
				}
			}
			if(rs4 !=null) rs4.close();
			if(stmt1 !=null) stmt1.close();
			if(pstmt !=null) pstmt.close();
		}
		if( regn_date_time == null) regn_date_time="";
		
		
		
		if ("Y".equals(fin_class_flag_setup_YN) && "MP".equals(strModuleId))			
			
		 {
		try
			 {
			if(pat_regn_date_time.length() > 4)
		{
				String regn_date_time_qry="select to_char(to_date(?,'dd/mm/yyyy HH24:MI:SS'),'dd/mm/yyyy HH24:MI') from dual";
				//stmt1 = con.createStatement();
				pstmt = con.prepareStatement(regn_date_time_qry);
				pstmt.setString(1,pat_regn_date_time);
				rs4 = pstmt.executeQuery() ;
				
				if( rs4 != null ) 
				{
					while( rs4.next() )
					{  
						regn_date_time = rs4.getString(1);
					}
				}

		}
//			regn_date_time=pat_regn_date_time;

		if(rs4 !=null) rs4.close();
			if(pstmt != null) pstmt.close();

			 }catch(Exception ee ){}

		 }
	
		

		String frame_size="";
		

		String package_flag =request.getParameter("package_flag");		

		if((package_flag == null)||package_flag.equals("null"))package_flag="N";

//		if(fin_class_flag_YN.equals("Y") && (strModuleId.equals("MP") || strModuleId.equals("IP")))
		if(fin_class_flag_YN.equals("Y") && !calling_function_id.equals("BOOKING"))
		{
			frame_size="3%,97%";
		}
		else
		{
			if(package_flag.equals("Y"))
	//			frame_size="27%,73%,0%,0%";
				frame_size="15%,75%,0%,0%,0%,0%";
			else
	//			frame_size="35%,65%,0%,0%";	//frame_size="20%,80%,0%";
				frame_size="35%,65%,0%,0,0%,0%";	//frame_size="20%,80%,0%";
		}

		String title = (String) common_labels.getString("Common.financialdetails.label");
		String title_lbl = (String) common_labels.getString("Common.financialdetails.label");
		String date_time_label="";
		String encounter_label="";
		if(new_moduleId.equals("ST")){
			
			 date_time_label=(String) common_labels.getString("Common.datetime.label");
			
		}else{
			 encounter_label=(String) common_labels.getString("Common.encounterdatetime.label");
			
		}
		
		String encounter_date_time = request.getParameter("encounter_date_time");
		String encounter_date_time_loc = "", date_frm_calling_module_YN = "Y";
		if(encounter_date_time == null) encounter_date_time="";

		//Rajesh Test
		/*System.err.println("encounter_date_time.length"+encounter_date_time.length());
		if(encounter_date_time.length() == 19){
			encounter_date_time = encounter_date_time.substring(0,16);
		}
		System.err.println("encounter_date_time"+encounter_date_time);*/
		//Rajesh Test
		if(strModuleId.equals("MP"))
		{
			encounter_date_time = regn_date_time;
			date_frm_calling_module_YN = "N";
		}
		
		if(!encounter_date_time.equals(""))
		{
			if(!new_moduleId.equals("ST")){
			encounter_date_time_loc = com.ehis.util.DateUtils.convertDate(encounter_date_time,"DMYHM","en",locale);
			title=title+"--"+encounter_label+"-"+encounter_date_time_loc;
			}
			else{
				
				encounter_date_time_loc = com.ehis.util.DateUtils.convertDate(encounter_date_time,"DMYHM","en",locale);
				title=title+"--"+date_time_label+"-"+encounter_date_time_loc;
				
			}
		}

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(title));
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		String strRepositoryYN =	request.getParameter("bl_data_from_repos_yn");	
		String strDataSourceId =  request.getParameter("data_source_id");
		String strProcedureName = "{ call "+"BL_GET_MAPPING_ITEMS(?,?,?)"+"}";
		
		String strErrText = "";
		String strItemsDisabled = "";	

		if (strRepositoryYN == null ) 	strRepositoryYN = "";
		if (strDataSourceId == null )	strDataSourceId = "";
		

		if (strRepositoryYN.equals("Y") && strModuleId.equals("MP"))
		{	
			try
			{
				CallableStatement call1 = con.prepareCall(strProcedureName);
				call1.setString(1, strDataSourceId);
				call1.registerOutParameter(2,java.sql.Types.VARCHAR);
				call1.registerOutParameter(3,java.sql.Types.VARCHAR);
				call1.execute();
			
				strErrText = call1.getString(3);
			
				if (strErrText == null ) 
				{
					strItemsDisabled = call1.getString(2);
				}

				call1.close();
			}
			catch(Exception err)
			{
				System.err.println("Exception in call1:"+err);
			}
		}	

		String billing_mode = request.getParameter("billing_mode");
		if(billing_mode==null) billing_mode = "";

		String operation = request.getParameter("operation");
		if(operation==null) operation = "Insert";

		String strAllParam	="";

		strAllParam = (request.getQueryString()) + "&bl_data_from_repos_yn="+strRepositoryYN+
									"&items_disabled="+strItemsDisabled+"&charge_for_pat_regn_yn="+charge_for_pat_regn_yn;
		if(date_frm_calling_module_YN.equals("N"))
		{
			strAllParam = strAllParam +"&encounter_date_time="+encounter_date_time;
		}

		strAllParam = strAllParam + "&third_party_gl_in_use_yn="+third_party_gl_in_use_yn+"&third_party_gl_mandatory_yn="+third_party_gl_mandatory_yn+"&capture_employer_id_yn="+capture_employer_id_yn+"&dfltbgyn="+mp_dflt_YN+"&encdfltbgyn="+enc_dflt_YN+"&provselfrmprevencyn="+provselfrmprevencyn+"&package_enabled_yn="+package_enabled_yn+"&new_moduleId="+new_moduleId;

		
		if(!(tabdata==null || tabdata.isEmpty()))
		{
			fin_dtls_updated_YN=(String)tabdata.get("fin_dtls_updated_YN");
			if(fin_dtls_updated_YN==null) fin_dtls_updated_YN="N";
		}
		//System.out.println(" sql 451 FinDetailsMain.jsp ");
//		System.err.println("KKKK Y        	fin_class_flag_YN -> "+fin_class_flag_YN);
//		System.err.println("KKKK ''       	called_locn -> "+called_locn);
//		System.err.println("KKKK !MP     	strModuleId -> "+strModuleId);
//		System.err.println("KKKK N        	fin_dtls_updated_YN -> "+fin_dtls_updated_YN);
//		System.err.println("KKKK facility_id -> "+facility_id);
//		System.err.println("KKKK patient_id  -> "+patient_id);
//		System.err.println("KKKK strEpisodeType -> "+strEpisodeType);
//		System.err.println("KKKK encounter_date_time -> "+encounter_date_time);
//		System.err.println("KKKK dflt_prv_fin_dtl_acrs_enc_yn -> "+dflt_prv_fin_dtl_acrs_enc_yn);
		
			
		/*karthik added code here starts*/


		if(policyBLInclusionFlag.equals("Y") && (strModuleId.equals("MP")==false || !"".equals(patient_id))){
			
			
			
			
			
			
		if(patient_id!=null && strEpisodeType!=null && ( enc_dflt_YN.equals("Y") || "Y".equals(mp_dflt_YN) || "Y".equals(mp_dflt_frst_enc_YN))){
			
				String enc_patient_id=null;
				String enc_episode_type=null;
				String enc_episode_id=null;
				String enc_visit_id=null;
				String enc_regn_date_time=null;
				String enc_cust_code=null;
				String enc_policy_no=null;
				String enc_acc_seq=null;
				String  enc_date_time=null;
				String enc_sql = null;
				int no_rec_prev_enc = 0;
				String encplcy_sql = null;
				
				  enc_sql = " SELECT COUNT(*) FROM PR_ENCOUNTER  WHERE patient_id =? and  facility_id = ?  and encounter_id is not null and NVL(ADT_STATUS,'#') <> '09' ";
				  
				  pstmt = con.prepareStatement(enc_sql);
				  pstmt.setString(1,patient_id);
				  pstmt.setString(2,facility_id);
				  rsm = pstmt.executeQuery() ;
				  
				  if( rsm.next() )
					{
					  no_rec_prev_enc = Integer.parseInt(rsm.getString(1));
					}
				  rsm.close();
				  pstmt.close();
				  if("MP".equals(strModuleId)) no_rec_prev_enc =0; //Added for AAKH-SCF-172     17/04/2015
				if((mp_dflt_frst_enc_YN.equals("Y") && no_rec_prev_enc == 0)||"Y".equals(mp_dflt_YN))
	//		if((mp_dflt_frst_enc_YN.equals("Y")||"Y".equals(mp_dflt_YN)) && no_rec_prev_enc == 0)
				{
					
					if("MP".equals(strModuleId)){
						enc_sql="SELECT a.patient_id,a.episode_type,a.episode_id,a.visit_id,a.cust_code,a.ACCT_SEQ_NO,a.POLICY_NUMBER, to_char(a.enc_regn_date_time,'dd/mm/yyyy') enc_date  FROM bl_encounter_payer_priority a, bl_patient_fin_dtls b WHERE a.operating_facility_id =? AND a.episode_type = 'R' AND a.patient_id =? AND a.patient_id = b.patient_id AND a.acct_seq_no = b.cur_acct_seq_no AND a.priority is not NULL ";
					}
					else{
						enc_sql="SELECT a.patient_id,a.episode_type,a.episode_id,a.visit_id,a.cust_code,a.ACCT_SEQ_NO,a.POLICY_NUMBER, to_char(a.enc_regn_date_time,'dd/mm/yyyy') enc_date  FROM bl_encounter_payer_priority a, bl_patient_fin_dtls b WHERE a.operating_facility_id =? AND a.episode_type = 'R' AND a.patient_id = ? AND a.patient_id = b.patient_id AND a.acct_seq_no = b.cur_acct_seq_no AND a.priority is not NULL AND ? !='MP'  ";
					}
					
					System.err.println("  ##########   Inside Enc Level First Enc level Ins check:"+enc_sql);
					
					
					pstmt = con.prepareStatement(enc_sql);
					if("MP".equals(strModuleId)){
						pstmt.setString(1,facility_id);
						pstmt.setString(2,patient_id);
					}else{
						pstmt.setString(1,facility_id);
						pstmt.setString(2,patient_id);
						pstmt.setString(3,strModuleId);
					}
					
					rsm = pstmt.executeQuery() ;
					
					while( rsm.next() )
					{
						enc_patient_id = rsm.getString("patient_id");
						enc_episode_type = rsm.getString("episode_type");
						enc_episode_id = rsm.getString("episode_id");
						enc_visit_id = rsm.getString("visit_id");						
						enc_cust_code=rsm.getString("cust_code");	
						enc_acc_seq = rsm.getString("ACCT_SEQ_NO");
						enc_policy_no = rsm.getString("POLICY_NUMBER");
						enc_date_time = rsm.getString("enc_date");
					}
					
					rsm.close();
					pstmt.close();
					
				}
				
				else
				{
					
				enc_sql="select patient_id,episode_type,episode_id,visit_id,regn_date_time,cust_code  from BL_PRV_ENC_SELECT_MAIN_BG_VW where operating_facility_id=? and patient_id=? AND episode_type=Decode(?,'Y',episode_type,?) AND rownum=1";				
				System.err.println("  $$$$$$$$$$$  Inside Enc Level First Enc level Ins check:"+enc_sql);
				
				
				
				pstmt = con.prepareStatement(enc_sql);
				
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,dflt_prv_fin_dtl_acrs_enc_yn);
				pstmt.setString(4,strEpisodeType);
				
				rsm = pstmt.executeQuery() ;
				
				if( rsm.next() )
				{
					enc_patient_id = rsm.getString("patient_id");
					 
					enc_episode_type = rsm.getString("episode_type");
										
					enc_episode_id = rsm.getString("episode_id");
					
					enc_visit_id = rsm.getString("visit_id");
					
					enc_regn_date_time = rsm.getString("regn_date_time");
					
					enc_cust_code=rsm.getString("cust_code");	
					
				}
				
				rsm.close();
				pstmt.close();
				
				if(enc_cust_code!=null){
					
					if(enc_visit_id==null ||enc_visit_id.equals("null"))						
					 encplcy_sql ="select  ACCT_SEQ_NO,POLICY_NUMBER, to_char(enc_regn_date_time,'dd/mm/yyyy') enc_date from bl_encounter_payer_priority  where patient_id = '"+enc_patient_id+"'  and  episode_id = '"+enc_episode_id+"'   and  episode_type ='"+enc_episode_type+"'  and  cust_code = '"+enc_cust_code+"'  and  operating_facility_id =  '"+facility_id+"'  AND rownum=1";
					
					else
						encplcy_sql ="select  ACCT_SEQ_NO,POLICY_NUMBER, to_char(enc_regn_date_time,'dd/mm/yyyy') enc_date from bl_encounter_payer_priority  where patient_id = '"+enc_patient_id+"'  and  episode_id = '"+enc_episode_id+"'   and  episode_type ='"+enc_episode_type+"'  and  visit_id  =  NVL('"+enc_visit_id+"',visit_id)  and  cust_code = '"+enc_cust_code+"'  and  operating_facility_id =  '"+facility_id+"'  AND rownum=1";
					
					pstmt = con.prepareStatement(encplcy_sql);
					
					rsm = pstmt.executeQuery() ;
					if( rsm.next() )
					{
						enc_acc_seq = rsm.getString("ACCT_SEQ_NO");
						enc_policy_no = rsm.getString("POLICY_NUMBER");
						enc_date_time = rsm.getString("enc_date");
											
					}
					rsm.close();
					pstmt.close();
					
				}
			}
					
					if(enc_cust_code!=null){
						
						
						if(enc_patient_id==null) enc_patient_id=""; 						
						if(enc_episode_type==null) enc_episode_type="";
						if(enc_episode_id==null) enc_episode_id="";
						if(enc_visit_id==null) enc_visit_id="";
						if(enc_regn_date_time==null) enc_regn_date_time="";
						if(enc_cust_code==null) enc_cust_code="";
						if(enc_acc_seq==null) enc_acc_seq="";
						if(enc_policy_no==null) enc_policy_no="";
						if(enc_date_time==null) enc_date_time="";
						
					
					HashMap encPlcyRecElementsMap=new HashMap();
					encPlcyRecElementsMap.put("enc_facility_id", facility_id);
					encPlcyRecElementsMap.put("enc_patient_id", enc_patient_id);
					encPlcyRecElementsMap.put("enc_episode_type",enc_episode_type );
					encPlcyRecElementsMap.put("enc_episode_id",enc_episode_id );
					encPlcyRecElementsMap.put("enc_visit_id", enc_visit_id);
					encPlcyRecElementsMap.put("enc_locale", locale);
					encPlcyRecElementsMap.put("policy_num", enc_policy_no);
					encPlcyRecElementsMap.put("acct_seq", enc_acc_seq);
					encPlcyRecElementsMap.put("encounter_date", enc_date_time);
					encPlcyRecElementsMap.put("dflt_policy_vst_reg",dflt_policy_vst_reg);
					
					System.out.println("elements ######  "+session.getAttribute("ENCOUNTER_POLICY_RECORD_ELEMENTS"));
					
					if(session.getAttribute("ENCOUNTER_POLICY_RECORD_ELEMENTS")==null)
					session.setAttribute("ENCOUNTER_POLICY_RECORD_ELEMENTS",encPlcyRecElementsMap);
					
					System.out.println("elements ###### after "+session.getAttribute("ENCOUNTER_POLICY_RECORD_ELEMENTS"));
				
				String oldFormat = "yyyy-MM-dd HH:mm:ss";
				String newFormat = "dd/MM/yyyy";
				SimpleDateFormat sdf1 = new SimpleDateFormat(oldFormat);
				SimpleDateFormat sdf2 = new SimpleDateFormat(newFormat);	    

			    try {
					if(enc_regn_date_time!=null && !"".equals(enc_regn_date_time))
						enc_regn_date_time=sdf2.format(sdf1.parse(enc_regn_date_time));
			    } catch (ParseException e) {
			        // TODO Auto-generated catch block
			        e.printStackTrace();
			    }
				System.err.println("KKKK enc_pol_bean.getPreviousEncounterDetials("+facility_id+","+enc_patient_id+","+enc_episode_type+","+enc_episode_id+","+enc_visit_id+","+locale+","+enc_regn_date_time+")");

				PolicyInsuranceMasterBean encBeanInstance	=	null;
				HashMap<String, PolicyInsuranceMasterBean> encMasterMap = new HashMap<String, PolicyInsuranceMasterBean>();
				HashMap<String, PolicyInsuranceMasterBean> masterMap = new HashMap<String, PolicyInsuranceMasterBean>();
				
				String enc_pol_bean_id		= "EncounterPolicyInsuranceMasterBean" ;
				String enc_pol_bean_name	= "eBL.PolicyInsuranceMasterBean";
				PolicyInsuranceMasterBean enc_pol_bean		= 	(PolicyInsuranceMasterBean)getBeanObject( enc_pol_bean_id, enc_pol_bean_name, request ) ;
				
				String pol_bean_id		= "PayerPolicyInsuranceMasterBean" ;
				String pol_bean_name	= "eBL.PolicyInsuranceMasterBean";
				PolicyInsuranceMasterBean pol_bean			= (PolicyInsuranceMasterBean)getBeanObject( pol_bean_id, pol_bean_name, request ) ;

				
				if((!strModuleId.equalsIgnoreCase("MP")) || (strModuleId.equalsIgnoreCase("MP")&& enc_patient_id.length()>0) ){
					System.err.println("enc_pol_bean.getPreviousEncounterDetials("+facility_id+","+enc_patient_id+","+enc_episode_type+","+enc_episode_id+","+enc_visit_id+","+locale+","+enc_regn_date_time+")");
					encBeanInstance=enc_pol_bean.getPreviousEncounterDetials(facility_id, enc_patient_id, enc_episode_type, enc_episode_id, enc_visit_id, locale,enc_regn_date_time);
				}	
				else{
					encBeanInstance = new PolicyInsuranceMasterBean();
				}
				
				encMasterMap=encBeanInstance.getMasterMap();
				if( encMasterMap==null ){
				encMasterMap=new HashMap<String, PolicyInsuranceMasterBean>();
				}
				System.err.println("KKKK EncounterMap returned:"+encMasterMap);

				
				masterMap=pol_bean.getMasterMap();
				if( masterMap==null ){
					masterMap=new HashMap<String, PolicyInsuranceMasterBean>();
				}
				
				encMasterMap.putAll(masterMap);
				
				
				System.err.println("KKKK MasterMap returned:"+encMasterMap);
				
				
				//Appending Encounter Specific Bean Records along with the MasterMap which contains all Session Policy Records	
				//masterMap.putAll(encMasterMap);
				//pol_bean.setMasterMap(masterMap);
				// Commented by dhanasekar   1/10/2013 encMasterMap.putAll(masterMap);
				pol_bean.setMasterMap(encMasterMap);

				System.err.println("KKKK  New MasterMap -> (EncounterMap + MasterMap ):"+encMasterMap);	
			}
		}
		
		}
		 
		
		
		
		if(policyBLInclusionFlag.equals("Y"))
		{
		if(strModuleId.equalsIgnoreCase("MP") && (patient_id!=null || !patient_id.equals("")) ){
			 session.setAttribute("MP_CHANGE_PATIENT_VALID", "Y");
		 }
		 else{
			 session.setAttribute("MP_CHANGE_PATIENT_VALID", "N");
		 }
		}
		/*karthik added code here ends*/
		
		if(fin_class_flag_YN.equals("Y") && called_locn.equals("") && !strModuleId.equals("MP") && fin_dtls_updated_YN.equals("N") && !(calling_function_id.equals("BOOKING") && disaster_regn_YN.equals("Y")))
		{
			try
			{
				//System.out.println(" sql 455 FinDetailsMain.jsp");
				String sql= "";
				if(strEpisodeType.equals("I") || strEpisodeType.equals("D"))
				{
					sql="SELECT BLNG_GRP_ID,null episode_id,null visit_id,null blng_class_code,null employer_code,null slmt_type_code,null slmt_doc_ref_desc ,null  slmt_doc_ref_date,null slmt_doc_remarks,CUST_CODE,CUST_GROUP_CODE,CREDIT_DOC_REF_DESC,to_char(CREDIT_DOC_REF_START_DATE,'DD/MM/YYYY') CREDIT_DOC_REF_START_DATE,to_char(CREDIT_DOC_REF_DATE,'DD/MM/YYYY') CREDIT_DOC_REF_DATE,NON_INS_BLNG_GRP_ID, NON_INS_CUST_GROUP_CODE, NON_INS_CUST_CODE,null annual_family_income,null family_assets_value,null num_of_dependents,null resp_for_bill_payment,null pat_reln_with_resp_pers,null remarks,null gl_holder_name,null pat_reln_with_gl_holder,blcommon.BL_VALID_REF_SOURCE_CODE(REFERRAL_SOURCE_CODE_MAIN,?) REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(REFERRAL_SOURCE_CODE_SUB,?) REFERRAL_SOURCE_CODE_SUB,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_MAIN,?) NON_INS_REF_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_SUB,?) NON_INS_REF_SOURCE_CODE_SUB,null IS_SPECIAL_CLINIC_RELATED,null NO_OF_ENC_GL_VALID,null NO_OF_OP_ENC_GL_VALID,null NO_OF_AE_ENC_GL_VALID,null NO_OF_IP_ENC_GL_VALID,null NO_OF_DC_ENC_GL_VALID,null  PATIENT_INC_ASSET_IND,null PATIENT_INC_ASSET_AMT,null PATIENT_INC_ASSET_FREQ,null SPOUSE_INC_ASSET_AMT,null SPOUSE_INC_ASSET_FREQ,null DEPENDENT_INC_ASSET_AMT,null DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,to_char(START_DATE,'DD/MM/YYYY') VALID_FROM,to_char(END_DATE,'DD/MM/YYYY') VALID_TO,null LAST_DATE,null SOCIAL_PENSIONER_ID,CLASSFCTN_DEFN_NO FROM BL_ENC_CLASSFCTN_EXCL A WHERE OPERATING_FACILITY_ID = ? AND EPISODE_TYPE=? AND PATIENT_ID=? AND NVL(EPISODE_TYPE, 'X') in ('I','D') AND NVL(FINALIZE_YN,'N')='Y' AND ADMISSION='Y' AND VISIT_ADM_SPECIFIC='N' AND RECLASS_CORR_FLAG = 'R' AND TRUNC(to_date(to_char(to_date(?,'dd/mm/yyyy HH24:MI'),'dd/mm/yyyy'),'dd/mm/yyyy')) BETWEEN START_DATE AND END_DATE AND RECLASS_CORR_FLAG='R'";
				}
				else if(strEpisodeType.equals("O") || strEpisodeType.equals("E"))
				{
					sql="SELECT A.BLNG_GRP_ID,null episode_id,null visit_id,null blng_class_code,null employer_code,null slmt_type_code,null slmt_doc_ref_desc ,null  slmt_doc_ref_date,null slmt_doc_remarks,A.CUST_CODE,A.CUST_GROUP_CODE,A.CREDIT_DOC_REF_DESC,to_char(A.CREDIT_DOC_REF_START_DATE,'DD/MM/YYYY') CREDIT_DOC_REF_START_DATE,to_char(A.CREDIT_DOC_REF_DATE,'DD/MM/YYYY') CREDIT_DOC_REF_DATE,A.NON_INS_BLNG_GRP_ID, A.NON_INS_CUST_GROUP_CODE, A.NON_INS_CUST_CODE,null annual_family_income,null family_assets_value,null num_of_dependents,null resp_for_bill_payment,null pat_reln_with_resp_pers,null remarks,null gl_holder_name,null pat_reln_with_gl_holder,blcommon.BL_VALID_REF_SOURCE_CODE(A.REFERRAL_SOURCE_CODE_MAIN,?) REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(A.REFERRAL_SOURCE_CODE_SUB,?) REFERRAL_SOURCE_CODE_SUB,blcommon.BL_VALID_REF_SOURCE_CODE(A.NON_INS_REF_SOURCE_CODE_MAIN,?) NON_INS_REF_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(A.NON_INS_REF_SOURCE_CODE_SUB,?) NON_INS_REF_SOURCE_CODE_SUB,null IS_SPECIAL_CLINIC_RELATED,null NO_OF_ENC_GL_VALID,null NO_OF_OP_ENC_GL_VALID,null NO_OF_AE_ENC_GL_VALID,null NO_OF_IP_ENC_GL_VALID,null NO_OF_DC_ENC_GL_VALID,null PATIENT_INC_ASSET_IND,null PATIENT_INC_ASSET_AMT,null PATIENT_INC_ASSET_FREQ,null SPOUSE_INC_ASSET_AMT,null SPOUSE_INC_ASSET_FREQ,null DEPENDENT_INC_ASSET_AMT,null DEPENDENT_INC_ASSET_FREQ,A.CLASSIFICATION_CODE,A.CLASSIFICATION_TYPE,to_char(A.START_DATE,'DD/MM/YYYY') VALID_FROM,to_char(A.END_DATE,'DD/MM/YYYY') VALID_TO,null LAST_DATE,null SOCIAL_PENSIONER_ID,A.CLASSFCTN_DEFN_NO FROM  BL_ENC_CLASSFCTN_EXCL A WHERE OPERATING_FACILITY_ID = ? AND EPISODE_TYPE=? AND PATIENT_ID=? AND NVL(EPISODE_TYPE, 'X') in ('O','E') AND NVL(FINALIZE_YN,'N')='Y' AND ADMISSION='N' AND VISIT_ADM_SPECIFIC='N' AND CLINIC_SPECIFIC='Y' AND RECLASS_CORR_FLAG = 'R' AND TRUNC(to_date(to_char(to_date(?,'dd/mm/yyyy HH24:MI'),'dd/mm/yyyy'),'dd/mm/yyyy')) BETWEEN START_DATE AND END_DATE AND RECLASS_CORR_FLAG='R' AND (?) NOT IN (SELECT B.CLINIC_CODE FROM BL_ENC_CLASSFCTN_CLINIC_EXCL B WHERE B.CLASSFCTN_DEFN_NO = A.CLASSFCTN_DEFN_NO)";
				}
				System.err.println("sql for Future Admn/Visit:"+sql);

				pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				
				pstmt.setString(1,strEpisodeType);
				pstmt.setString(2,strEpisodeType);
				pstmt.setString(3,strEpisodeType);
				pstmt.setString(4,strEpisodeType);
				pstmt.setString(5,facility_id);
				pstmt.setString(6,strEpisodeType);
				pstmt.setString(7,patient_id);
				pstmt.setString(8,encounter_date_time);
				
				if(strEpisodeType.equals("O") || strEpisodeType.equals("E")){
					pstmt.setString(9,clinic_code);
				}				
				rs = pstmt.executeQuery() ;
				
				if(rs!=null)
				{
					if(!rs.next())
					{
						rs.close();
						pstmt.close();
					System.out.println("Future Admn/Visit Data for Class Not Found");
						if(mp_dflt_YN.equals("Y"))
						{
							sql="select blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc ,to_char(slmt_doc_ref_date,'dd/mm/yyyy') slmt_doc_ref_date,slmt_doc_remarks,cust_group_code,cust_code,credit_doc_ref_desc,to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date,to_char(credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,financial_remarks,gl_holder_name,pat_reln_with_gl_holder,blcommon.BL_VALID_REF_SOURCE_CODE(REFERRAL_SOURCE_CODE_MAIN,?) REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(REFERRAL_SOURCE_CODE_SUB,?) REFERRAL_SOURCE_CODE_SUB,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_MAIN,?) NON_INS_REF_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_SUB,?) NON_INS_REF_SOURCE_CODE_SUB,null episode_id,null visit_id,null IS_SPECIAL_CLINIC_RELATED,null NO_OF_ENC_GL_VALID,null NO_OF_OP_ENC_GL_VALID,null NO_OF_AE_ENC_GL_VALID,null NO_OF_IP_ENC_GL_VALID,null NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,to_char(CLASSIFICATION_START_DATE,'DD/MM/YYYY') VALID_FROM,to_char(CLASSIFICATION_END_DATE,'DD/MM/YYYY') VALID_TO,SOCIAL_PENSIONER_ID, to_char(add_months(CLASSIFICATION_START_DATE,?),'dd/mm/yyyy') LAST_DATE,null CLASSFCTN_DEFN_NO from bl_patient_fin_dtls where patient_id =? AND blng_grp_id IN (Select blng_grp_id from bl_blng_grp where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y') ) )";

//								System.err.println("sql in MP Level Selection:"+sql);
						}
						else if(enc_dflt_YN.equals("Y"))
						{
							//System.out.println("enc_dflt_YN &&&&&&&&&&&&&");
							sql="select blng_grp_id,episode_id,visit_id,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc,slmt_doc_ref_date,slmt_doc_remarks,cust_group_code,cust_code,credit_doc_ref_desc,credit_doc_ref_start_date,credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,null financial_remarks,gl_holder_name,pat_reln_with_gl_holder,blcommon.BL_VALID_REF_SOURCE_CODE(REFERRAL_SOURCE_CODE_MAIN,?) REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(REFERRAL_SOURCE_CODE_SUB,?) REFERRAL_SOURCE_CODE_SUB,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_MAIN,?) NON_INS_REF_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_SUB,?) NON_INS_REF_SOURCE_CODE_SUB,null IS_SPECIAL_CLINIC_RELATED,NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,to_char(CLASSIFICATION_START_DATE,'DD/MM/YYYY') VALID_FROM,to_char(CLASSIFICATION_END_DATE,'DD/MM/YYYY') VALID_TO,SOCIAL_PENSIONER_ID, to_char(add_months(CLASSIFICATION_START_DATE,?),'dd/mm/yyyy') LAST_DATE,null CLASSFCTN_DEFN_NO from BL_PRV_ENC_SELECT_MAIN_BG_VW where operating_facility_id=? and patient_id=? AND episode_type=Decode(?,'Y',episode_type,?) AND rownum=1";

							
								System.err.println("sql in Encounter Level Selection:"+sql);
						}
						pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
						
						pstmt.setString(1,strEpisodeType);
						pstmt.setString(2,strEpisodeType);
						pstmt.setString(3,strEpisodeType);
						pstmt.setString(4,strEpisodeType);
						pstmt.setInt(5,assessmentMonths);
						if(mp_dflt_YN.equals("Y")){
							pstmt.setString(6,patient_id);
							pstmt.setString(7,strModuleId);
							pstmt.setString(8,strModuleId);
							pstmt.setString(9,strModuleId);
							pstmt.setString(10,strModuleId);
							pstmt.setString(11,strModuleId);
						}else if(enc_dflt_YN.equals("Y")){
							pstmt.setString(6,facility_id);
							pstmt.setString(7,patient_id);
							pstmt.setString(8,dflt_prv_fin_dtl_acrs_enc_yn);
							pstmt.setString(9,strEpisodeType);
						}
						
						rs = pstmt.executeQuery() ;
					
						if(rs!=null)
						{	
							if(!rs.next() && mp_dflt_frst_enc_YN.equals("Y"))
							{
								rs.close();
								pstmt.close();
								no_rec_found_in_enc_level_YN="Y";
								sql="select blng_grp_id,null episode_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc ,to_char(slmt_doc_ref_date,'dd/mm/yyyy') slmt_doc_ref_date,slmt_doc_remarks,cust_group_code,cust_code,credit_doc_ref_desc,to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date,to_char(credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,financial_remarks,gl_holder_name,pat_reln_with_gl_holder,blcommon.BL_VALID_REF_SOURCE_CODE(REFERRAL_SOURCE_CODE_MAIN,?) REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(REFERRAL_SOURCE_CODE_SUB,?) REFERRAL_SOURCE_CODE_SUB,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_MAIN,?) NON_INS_REF_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_SUB,?) NON_INS_REF_SOURCE_CODE_SUB,null episode_id,null visit_id,null IS_SPECIAL_CLINIC_RELATED,null NO_OF_ENC_GL_VALID,null NO_OF_OP_ENC_GL_VALID,null NO_OF_AE_ENC_GL_VALID,null NO_OF_IP_ENC_GL_VALID,null NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,to_char(CLASSIFICATION_START_DATE,'DD/MM/YYYY') VALID_FROM,to_char(CLASSIFICATION_END_DATE,'DD/MM/YYYY') VALID_TO,SOCIAL_PENSIONER_ID, to_char(add_months(CLASSIFICATION_START_DATE,?),'dd/mm/yyyy') LAST_DATE,null CLASSFCTN_DEFN_NO from bl_patient_fin_dtls where patient_id =? AND blng_grp_id IN (Select blng_grp_id from bl_blng_grp where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') )) ";
//								System.err.println("sql in MP Level Selection as 1st enc:"+sql);
								pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
								
								pstmt.setString(1,strEpisodeType);
								pstmt.setString(2,strEpisodeType);
								pstmt.setString(3,strEpisodeType);
								pstmt.setString(4,strEpisodeType);
								pstmt.setInt(5,assessmentMonths);
								pstmt.setString(6,patient_id);
								pstmt.setString(7,strModuleId);
								pstmt.setString(8,strModuleId);
								pstmt.setString(9,strModuleId);
								pstmt.setString(10,strModuleId);
																
								rs = pstmt.executeQuery() ;
								
							}
							else
							{
								rs.beforeFirst();
							}
						}
					}
					else
					{
						rs.beforeFirst();
					}
				}
				
				if(!sql.equals(""))
				{
					while( rs.next() )
					{  
//						System.err.println("Rec Found");
						blng_grp_id = rs.getString("BLNG_GRP_ID");
						if(blng_grp_id == null) blng_grp_id="";

						episode_id = rs.getString("episode_id");
						if(episode_id == null) episode_id="";

						visit_id = rs.getString("visit_id");
						if(visit_id == null) visit_id="";

						rtn_blng_class_code= rs.getString("blng_class_code");
						if(rtn_blng_class_code==null) rtn_blng_class_code="";

						rtn_employer_code= rs.getString("employer_code");
						if(rtn_employer_code==null) rtn_employer_code="";

						user_id = p.getProperty("login_user");
						if(user_id==null) user_id="";

						slmt_type_code=rs.getString("slmt_type_code");
						if(slmt_type_code==null) slmt_type_code="";

						inst_ref =  rs.getString("slmt_doc_ref_desc");
						if(inst_ref==null) inst_ref="";

						inst_date = rs.getString("slmt_doc_ref_date");
						if(inst_date==null) inst_date="";

						inst_remarks = rs.getString("slmt_doc_remarks");
						if(inst_remarks==null) inst_remarks="";

						cust_code = rs.getString("CUST_CODE");
						if(cust_code == null) cust_code="";

						cust_grp_code = rs.getString("CUST_GROUP_CODE");
						if(cust_grp_code == null) cust_grp_code="";

						credit_doc_ref_desc = rs.getString("CREDIT_DOC_REF_DESC");
						if(credit_doc_ref_desc == null) credit_doc_ref_desc="";

						credit_doc_ref_start_date = rs.getString("CREDIT_DOC_REF_START_DATE");
						if(credit_doc_ref_start_date == null) credit_doc_ref_start_date="";

						credit_doc_ref_date = rs.getString("CREDIT_DOC_REF_DATE");
						if(credit_doc_ref_date == null) credit_doc_ref_date="";

						non_ins_blng_grp_id = rs.getString("NON_INS_BLNG_GRP_ID");
						if(non_ins_blng_grp_id == null) non_ins_blng_grp_id="";	

						non_ins_cust_group_code= rs.getString("non_ins_cust_group_code");
						if(non_ins_cust_code==null) non_ins_cust_code="";		

						non_ins_cust_code= rs.getString("non_ins_cust_code");
						if(non_ins_cust_code==null) non_ins_cust_code="";

						rtn_tot_valid_enc_with_gl= rs.getString("NO_OF_ENC_GL_VALID");
						if(rtn_tot_valid_enc_with_gl==null) rtn_tot_valid_enc_with_gl="";

						rtn_tot_valid_op_enc_with_gl= rs.getString("NO_OF_OP_ENC_GL_VALID");
						if(rtn_tot_valid_op_enc_with_gl==null) rtn_tot_valid_op_enc_with_gl="";

						rtn_tot_valid_ae_enc_with_gl= rs.getString("NO_OF_AE_ENC_GL_VALID");
						if(rtn_tot_valid_ae_enc_with_gl==null) rtn_tot_valid_ae_enc_with_gl="";

						rtn_tot_valid_ip_enc_with_gl= rs.getString("NO_OF_IP_ENC_GL_VALID");
						if(rtn_tot_valid_ip_enc_with_gl==null) rtn_tot_valid_ip_enc_with_gl="";

						rtn_tot_valid_dc_enc_with_gl= rs.getString("NO_OF_DC_ENC_GL_VALID");
						if(rtn_tot_valid_dc_enc_with_gl==null) rtn_tot_valid_dc_enc_with_gl="";

						class_defn_no = rs.getString("CLASSFCTN_DEFN_NO");
						if(class_defn_no == null) class_defn_no="";

						rtn_inc_asset_ind=rs.getString("PATIENT_INC_ASSET_IND");
						if(rtn_inc_asset_ind==null) rtn_inc_asset_ind="";

						rtn_ind_inc=rs.getString("PATIENT_INC_ASSET_AMT");
						if(rtn_ind_inc==null) rtn_ind_inc="";

						rtn_ind_inc_freq=rs.getString("PATIENT_INC_ASSET_FREQ");
						if(rtn_ind_inc_freq==null) rtn_ind_inc_freq="";

						rtn_spouse_inc=rs.getString("SPOUSE_INC_ASSET_AMT");
						if(rtn_spouse_inc==null) rtn_spouse_inc="";

						rtn_spouse_inc_freq=rs.getString("SPOUSE_INC_ASSET_FREQ");
						if(rtn_spouse_inc_freq==null) rtn_spouse_inc_freq="";

						rtn_dependent_inc=rs.getString("DEPENDENT_INC_ASSET_AMT");
						if(rtn_dependent_inc==null) rtn_dependent_inc="";

						rtn_dependent_inc_freq=rs.getString("DEPENDENT_INC_ASSET_FREQ");
						if(rtn_dependent_inc_freq==null) rtn_dependent_inc_freq="";

						class_code=rs.getString("CLASSIFICATION_CODE");
						if(class_code==null) class_code="";

						class_type=rs.getString("CLASSIFICATION_TYPE");
						if(class_type==null) class_type="";

						rtn_valid_from = rs.getString("VALID_FROM");
						if(rtn_valid_from == null) rtn_valid_from="";

						rtn_valid_to = rs.getString("VALID_TO");
						if(rtn_valid_to == null) rtn_valid_to="";

						rtn_social_pensioner_id=rs.getString("SOCIAL_PENSIONER_ID");
						if(rtn_social_pensioner_id==null) rtn_social_pensioner_id="";

						rtn_last_date=rs.getString("LAST_DATE");
						if(rtn_last_date==null) rtn_last_date="";

						rtn_annual_family_income= rs.getString("annual_family_income");
						if(rtn_annual_family_income==null) rtn_annual_family_income="";

						rtn_family_assets_value = rs.getString("family_assets_value");
						if(rtn_family_assets_value==null) rtn_family_assets_value="";

						rtn_num_of_dependents= rs.getString("num_of_dependents");
						if(rtn_num_of_dependents==null) rtn_num_of_dependents="";

						rtn_resp_for_bill_payment= rs.getString("resp_for_bill_payment");
						if(rtn_resp_for_bill_payment==null) rtn_resp_for_bill_payment="";

						rtn_pat_reln_with_resp_pers= rs.getString("pat_reln_with_resp_pers");
						if(rtn_pat_reln_with_resp_pers==null) rtn_pat_reln_with_resp_pers="";

						rtn_remarks= rs.getString("remarks");
						if(rtn_remarks==null) rtn_remarks="";

						rtn_gl_holder_name= rs.getString("gl_holder_name");
						if(rtn_gl_holder_name==null) rtn_gl_holder_name="";

						rtn_pat_reln_with_gl_holder= rs.getString("pat_reln_with_gl_holder");
						if(rtn_pat_reln_with_gl_holder==null) rtn_pat_reln_with_gl_holder="";

						rtn_ref_src_main_code=rs.getString("REFERRAL_SOURCE_CODE_MAIN");
						if(rtn_ref_src_main_code==null) rtn_ref_src_main_code="";

						if(!rtn_ref_src_main_code.equals(""))
						{
							call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
							call.registerOutParameter(1,java.sql.Types.VARCHAR);

							call.setString(2,rtn_ref_src_main_code);
							call.setString(3,locale);
							call.setString(4,"1");

							call.execute();							
							rtn_ref_src_main_desc = call.getString(1);				
							call.close();
							if ( rtn_ref_src_main_desc == null ) rtn_ref_src_main_desc = "";

						}

						rtn_ref_src_sub_code=rs.getString("REFERRAL_SOURCE_CODE_SUB");
						if(rtn_ref_src_sub_code==null) rtn_ref_src_sub_code="";

						if(!rtn_ref_src_sub_code.equals(""))
						{
							call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
							call.registerOutParameter(1,java.sql.Types.VARCHAR);

							call.setString(2,rtn_ref_src_sub_code);
							call.setString(3,locale);
							call.setString(4,"1");

							call.execute();							
							rtn_ref_src_sub_desc = call.getString(1);				
							call.close();
							if ( rtn_ref_src_sub_desc == null ) rtn_ref_src_sub_desc = "";
						}

						rtn_non_ins_ref_src_main_code=rs.getString("NON_INS_REF_SOURCE_CODE_MAIN");
						if(rtn_non_ins_ref_src_main_code==null) rtn_non_ins_ref_src_main_code="";

						if(!rtn_non_ins_ref_src_main_code.equals(""))
						{
							call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
							call.registerOutParameter(1,java.sql.Types.VARCHAR);

							call.setString(2,rtn_non_ins_ref_src_main_code);
							call.setString(3,locale);
							call.setString(4,"1");

							call.execute();							
							rtn_non_ins_ref_src_main_desc = call.getString(1);				
							call.close();
							if ( rtn_non_ins_ref_src_main_desc == null ) rtn_non_ins_ref_src_main_desc = "";
						}

						rtn_non_ins_ref_src_sub_code=rs.getString("NON_INS_REF_SOURCE_CODE_SUB");
						if(rtn_non_ins_ref_src_sub_code==null) rtn_non_ins_ref_src_sub_code="";

						if(!rtn_non_ins_ref_src_sub_code.equals(""))
						{
							call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
							call.registerOutParameter(1,java.sql.Types.VARCHAR);

							call.setString(2,rtn_non_ins_ref_src_sub_code);
							call.setString(3,locale);
							call.setString(4,"1");

							call.execute();							
							rtn_non_ins_ref_src_sub_desc = call.getString(1);				
							call.close();
							if ( rtn_non_ins_ref_src_sub_desc == null ) rtn_non_ins_ref_src_sub_desc = "";
						}

						rtn_is_special_clinic_related = rs.getString("IS_SPECIAL_CLINIC_RELATED");
						if(rtn_is_special_clinic_related==null) rtn_is_special_clinic_related="N";
			
						String sql_slmt_ind="select settlement_ind, adm_rec_flag from bl_blng_grp where blng_grp_id = '"+blng_grp_id+"'";
						pstmt2 = con.prepareStatement(sql_slmt_ind);
						rs2 = pstmt2.executeQuery() ;
				
						if(rs2!=null)
						{
							while( rs2.next() )
							{
								slmt_ind = rs2.getString("settlement_ind");
								adm_rec_flag = rs2.getString("adm_rec_flag");
							}
						}
						if(rs2 != null) rs2.close();
						pstmt2.close();
						if(slmt_ind == null) slmt_ind="";
						if(adm_rec_flag == null) adm_rec_flag="";

						if (slmt_ind.equals("C"))
						{
							rtn_slmt_type_code= slmt_type_code;
							if(rtn_slmt_type_code==null) rtn_slmt_type_code="";
							rtn_inst_ref =  inst_ref;
							if(rtn_inst_ref==null) rtn_inst_ref="";
							rtn_inst_date = inst_date;
							if(rtn_inst_date==null) rtn_inst_date="";
							rtn_inst_remarks = inst_remarks;
							if(rtn_inst_remarks==null) rtn_inst_remarks="";

							if (credit_doc_ref_desc !=null)
							{
								rtn_credit_doc_reqd_yn = "Y";
							}
							else
							{
								rtn_credit_doc_reqd_yn = "N";
							}
						}
						else if (slmt_ind.equals("R"))
						{
							rtn_credit_doc_reqd_yn = "Y";
							rtn_credit_cust_group_code = cust_grp_code;
							rtn_credit_cust_code = cust_code;
							if(rtn_credit_cust_code==null) rtn_credit_cust_code="";
							
							String qry_gl_chk = "SELECT CREDIT_DOC_REF_DESC,NO_OF_OP_ENC_GL_AVAILED,NO_OF_AE_ENC_GL_AVAILED,NO_OF_IP_ENC_GL_AVAILED,NO_OF_DC_ENC_GL_AVAILED FROM BL_GL_HOLDER_LOOKUP_VW WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CUST_GROUP_CODE=? AND CUST_CODE=? and LANGUAGE_ID=?";

							if(!rtn_gl_holder_name.equals(""))
							{
								qry_gl_chk = qry_gl_chk + " AND GL_HOLDER_NAME=?";
							}

							pstmt3 = con.prepareStatement(qry_gl_chk);
							pstmt3.setString(1,facility_id);
							pstmt3.setString(2,patient_id);
							pstmt3.setString(3,cust_grp_code);
							pstmt3.setString(4,cust_code);
							pstmt3.setString(5,locale);
							
							if(!rtn_gl_holder_name.equals(""))
							{
							pstmt3.setString(6,rtn_gl_holder_name);
							}
							rs3 = pstmt3.executeQuery() ;
							
							if( rs3 != null ) 
							{
								while( rs3.next() )
								{  
									String temp_credit_doc_ref_desc = rs3.getString(1);
									if(credit_doc_ref_desc == null) credit_doc_ref_desc="";

									if(credit_doc_ref_desc.equals(temp_credit_doc_ref_desc))
									{
										no_of_op_enc_gl_availed= rs3.getString(2);
										if(no_of_op_enc_gl_availed == null) no_of_op_enc_gl_availed="0";

										no_of_ae_enc_gl_availed= rs3.getString(3);
										if(no_of_ae_enc_gl_availed == null) no_of_ae_enc_gl_availed="0";

										no_of_ip_enc_gl_availed= rs3.getString(4);
										if(no_of_ip_enc_gl_availed == null) no_of_ip_enc_gl_availed="0";

										no_of_dc_enc_gl_availed= rs3.getString(5);
										if(no_of_dc_enc_gl_availed == null) no_of_dc_enc_gl_availed="0";

										int num_no_of_op_enc_gl_availed = Integer.parseInt(no_of_op_enc_gl_availed);
										int num_no_of_ae_enc_gl_availed = Integer.parseInt(no_of_ae_enc_gl_availed);
										int num_no_of_ip_enc_gl_availed = Integer.parseInt(no_of_ip_enc_gl_availed);
										int num_no_of_dc_enc_gl_availed = Integer.parseInt(no_of_dc_enc_gl_availed);

										int num_no_of_enc_gl_availed = num_no_of_op_enc_gl_availed+num_no_of_ae_enc_gl_availed+num_no_of_ip_enc_gl_availed+num_no_of_dc_enc_gl_availed;

										no_of_enc_gl_availed=Integer.toString(num_no_of_enc_gl_availed);

										gl_doc_ref_exist_YN = "Y";
									}
								}
							}
							else
							{
								no_of_enc_gl_availed="0";
								no_of_op_enc_gl_availed="0";
								no_of_ae_enc_gl_availed="0";
								no_of_ip_enc_gl_availed="0";
								no_of_dc_enc_gl_availed="0";
								gl_doc_ref_exist_YN = "N";
							}
							rs3.close();
							pstmt3.close();
						}

						if( slmt_ind.equals("R") || (slmt_ind.equals("C") && !(credit_doc_ref_desc.equals(""))))
						{
							rtn_credit_doc_ref = credit_doc_ref_desc;
							if(rtn_credit_doc_ref==null) rtn_credit_doc_ref="";
							rtn_credit_doc_start_date = credit_doc_ref_start_date;
							if(rtn_credit_doc_start_date==null) rtn_credit_doc_start_date="";
							rtn_credit_doc_end_date = credit_doc_ref_date;
							if(rtn_credit_doc_end_date==null) rtn_credit_doc_end_date="";
						}
						else if(slmt_ind.equals("X") &&  non_ins_blng_grp_id.equals(""))
						{
							rtn_credit_doc_reqd_yn = "Y";
							rtn_sponsor_cust_group_code = cust_grp_code;
							rtn_sponsor_cust_code = cust_code;
							if(rtn_sponsor_cust_code==null) rtn_sponsor_cust_code="";
							rtn_sponsor_credit_doc_ref = credit_doc_ref_desc;
							if(rtn_sponsor_credit_doc_ref==null) rtn_sponsor_credit_doc_ref="";
							rtn_sponsor_credit_doc_start_date = credit_doc_ref_start_date;
							if(rtn_sponsor_credit_doc_start_date==null) rtn_sponsor_credit_doc_start_date="";
							rtn_sponsor_credit_doc_end_date = credit_doc_ref_date;
							if(rtn_sponsor_credit_doc_end_date==null) rtn_sponsor_credit_doc_end_date="";
							
							String qry_gl_chk = "SELECT CREDIT_DOC_REF_DESC,NO_OF_OP_ENC_GL_AVAILED,NO_OF_AE_ENC_GL_AVAILED,NO_OF_IP_ENC_GL_AVAILED,NO_OF_DC_ENC_GL_AVAILED FROM BL_GL_HOLDER_LOOKUP_VW WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CUST_GROUP_CODE=? AND CUST_CODE=? and LANGUAGE_ID=?";

							if(!rtn_gl_holder_name.equals(""))
							{
								qry_gl_chk = qry_gl_chk + " AND GL_HOLDER_NAME=?";
							}

							pstmt3 = con.prepareStatement(qry_gl_chk);
							pstmt3.setString(1,facility_id);
							pstmt3.setString(2,patient_id);
							pstmt3.setString(3,cust_grp_code);
							pstmt3.setString(4,cust_code);
							pstmt3.setString(5,locale);
							
							if(!rtn_gl_holder_name.equals("")){
								pstmt3.setString(6,rtn_gl_holder_name);
							}
							rs3 = pstmt3.executeQuery() ;
							
							if( rs3 != null ) 
							{
								while( rs3.next() )
								{  
									String temp_credit_doc_ref_desc = rs3.getString(1);
									if(credit_doc_ref_desc == null) credit_doc_ref_desc="";

									if(credit_doc_ref_desc.equals(temp_credit_doc_ref_desc))
									{
										no_of_op_enc_gl_availed= rs3.getString(2);
										if(no_of_op_enc_gl_availed == null) no_of_op_enc_gl_availed="0";

										no_of_ae_enc_gl_availed= rs3.getString(3);
										if(no_of_ae_enc_gl_availed == null) no_of_ae_enc_gl_availed="0";

										no_of_ip_enc_gl_availed= rs3.getString(4);
										if(no_of_ip_enc_gl_availed == null) no_of_ip_enc_gl_availed="0";

										no_of_dc_enc_gl_availed= rs3.getString(5);
										if(no_of_dc_enc_gl_availed == null) no_of_dc_enc_gl_availed="0";

										int num_no_of_op_enc_gl_availed = Integer.parseInt(no_of_op_enc_gl_availed);
										int num_no_of_ae_enc_gl_availed = Integer.parseInt(no_of_ae_enc_gl_availed);
										int num_no_of_ip_enc_gl_availed = Integer.parseInt(no_of_ip_enc_gl_availed);
										int num_no_of_dc_enc_gl_availed = Integer.parseInt(no_of_dc_enc_gl_availed);

										int num_no_of_enc_gl_availed = num_no_of_op_enc_gl_availed+num_no_of_ae_enc_gl_availed+num_no_of_ip_enc_gl_availed+num_no_of_dc_enc_gl_availed;

										no_of_enc_gl_availed=Integer.toString(num_no_of_enc_gl_availed);
										gl_doc_ref_exist_YN = "Y";
									}
								}
							}
							else
							{
								no_of_enc_gl_availed="0";
								no_of_op_enc_gl_availed="0";
								no_of_ae_enc_gl_availed="0";
								no_of_ip_enc_gl_availed="0";
								no_of_dc_enc_gl_availed="0";
								gl_doc_ref_exist_YN = "N";
							}
						}
						else if(slmt_ind.equals("X") && !(non_ins_blng_grp_id.equals("")))
						{
							String sql_ins="SELECT CUST_GROUP_CODE,CUST_CODE,PRIORITY,POLICY_TYPE_CODE,POLICY_NUMBER,to_char(POLICY_START_DATE,'DD/MM/YYYY') POLICY_START_DATE,to_char(POLICY_EXPIRY_DATE,'DD/MM/YYYY') POLICY_EXPIRY_DATE,CREDIT_AUTH_REF,to_char(CREDIT_AUTH_DATE,'DD/MM/YYYY') CREDIT_AUTH_DATE,to_char(EFFECTIVE_FROM,'DD/MM/YYYY') EFFECTIVE_FROM,to_char(EFFECTIVE_TO,'DD/MM/YYYY') EFFECTIVE_TO,APPROVED_AMT,APPROVED_DAYS,ADJ_RULE_IND,ADJ_PERC_AMT_IND,ADJ_PERC_AMT_VALUE,PMNT_DIFF_ADJ_INT,DRG_PMNT_DIFF_ADJ_INT,SPL_SRV_PMNT_DIFF_ADJ_INT,BLNG_GRP_ID,blcommon.BL_VALID_REF_SOURCE_CODE(REFERRAL_SOURCE_CODE_MAIN,?) REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(REFERRAL_SOURCE_CODE_SUB,?) REFERRAL_SOURCE_CODE_SUB FROM BL_ENC_CLASSFCTN_PRTY_EXCL WHERE operating_facility_id=? AND episode_type=? AND priority is not null AND CLASSFCTN_DEFN_NO=? ORDER BY 3";

//							System.err.println("sql_ins for Future Admn/Visit:"+sql_ins);

							pstmt1 = con.prepareStatement(sql_ins,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
							
							pstmt1.setString(1,strEpisodeType);
							pstmt1.setString(2,strEpisodeType);
							pstmt1.setString(3,facility_id);
							pstmt1.setString(4,strEpisodeType);
							pstmt1.setString(5,class_defn_no);
							
							rs1 = pstmt1.executeQuery() ;
			
							if(rs1!=null)
							{
								if( !rs1.next() )
								{
									rs1.close();
									pstmt1.close();
//									System.err.println("Future Admn/Visit Ins Data for Class Not Found");

									if(mp_dflt_YN.equals("Y") || strModuleId.equals("MP") )
									{
										sql_ins="SELECT a.cust_group_code cust_group_code,a.cust_code cust_code,a.priority priority,a.policy_type_code policy_type_code,a.policy_number policy_number,to_char(a.policy_start_date,'dd/mm/yyyy') policy_start_date,to_char(a.policy_expiry_date,'dd/mm/yyyy') policy_expiry_date,a.credit_auth_ref credit_auth_ref,to_char(a.credit_auth_date,'dd/mm/yyyy') credit_auth_date,to_char(a.effective_from,'dd/mm/yyyy') effective_from,to_char(a.effective_to,'dd/mm/yyyy') effective_to,a.approved_amt approved_amt,a.approved_days approved_days,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int, a.blng_grp_id blng_grp_id,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_MAIN,'"+strEpisodeType+"') REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_SUB,'"+strEpisodeType+"') REFERRAL_SOURCE_CODE_SUB FROM bl_encounter_payer_priority a, bl_patient_fin_dtls b WHERE a.operating_facility_id ='"+facility_id+"' AND a.episode_type = 'R' AND a.patient_id ='"+patient_id+"' AND a.patient_id = b.patient_id AND a.acct_seq_no = b.cur_acct_seq_no AND a.priority is not NULL AND ( ('"+strModuleId+"' !='MP' AND '"+mp_dflt_YN+"'='Y' AND BLCOMMON.valid_ins_payer_yn('"+facility_id+"','"+strModuleId+"',a.cust_group_code,a.cust_code,a.policy_type_code)='Y') OR ('"+strModuleId+"'='MP' AND BLCOMMON.valid_ins_payer_yn('"+facility_id+"','"+strModuleId+"',a.cust_group_code,a.cust_code,a.policy_type_code)='Y') ) AND (BLCOMMON.Valid_Primary_BG_payers('"+facility_id+"','"+patient_id+"','"+strEpisodeType+"','"+blng_grp_id+"')='Y') ORDER BY 3";
//											System.err.println("Inside MP level Ins check:"+sql_ins);
									}
									else if(enc_dflt_YN.equals("Y"))
									{
										if(mp_dflt_frst_enc_YN.equals("Y") && no_rec_found_in_enc_level_YN.equals("Y"))
										{
											sql_ins="SELECT a.cust_group_code cust_group_code,a.cust_code cust_code,a.priority priority,a.policy_type_code policy_type_code,a.policy_number policy_number,to_char(a.policy_start_date,'dd/mm/yyyy') policy_start_date,to_char(a.policy_expiry_date,'dd/mm/yyyy') policy_expiry_date,a.credit_auth_ref credit_auth_ref,to_char(a.credit_auth_date,'dd/mm/yyyy') credit_auth_date,to_char(a.effective_from,'dd/mm/yyyy') effective_from,to_char(a.effective_to,'dd/mm/yyyy') effective_to,a.approved_amt approved_amt,a.approved_days approved_days,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int, a.blng_grp_id blng_grp_id,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_MAIN,'"+strEpisodeType+"') REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_SUB,'"+strEpisodeType+"') REFERRAL_SOURCE_CODE_SUB FROM bl_encounter_payer_priority a, bl_patient_fin_dtls b WHERE a.operating_facility_id ='"+facility_id+"' AND a.episode_type = 'R' AND a.patient_id ='"+patient_id+"' AND a.patient_id = b.patient_id AND a.acct_seq_no = b.cur_acct_seq_no AND a.priority is not NULL AND ( ('"+strModuleId+"' !='MP'  AND BLCOMMON.valid_ins_payer_yn('"+facility_id+"','"+strModuleId+"',a.cust_group_code,a.cust_code,a.policy_type_code)='Y') OR ('"+strModuleId+"'='MP') ) AND (BLCOMMON.Valid_Primary_BG_payers('"+facility_id+"','"+patient_id+"','"+strEpisodeType+"','"+blng_grp_id+"')='Y') ORDER BY 3";
//												System.err.println("Inside Enc Level First Enc level Ins check:"+sql_ins);
										}
										else
										{
											sql_ins="SELECT operating_facility_id,episode_type,patient_id,episode_id,visit_id,regn_date_time,acct_seq_no,cust_group_code,cust_code,priority,policy_type_code,policy_number,policy_start_date,policy_expiry_date,credit_auth_ref,credit_auth_date,effective_from effective_from,effective_to,approved_amt,approved_days,adj_rule_ind,adj_perc_amt_ind,adj_perc_amt_value,pmnt_diff_adj_int,drg_pmnt_diff_adj_int,spl_srv_pmnt_diff_adj_int,blng_grp_id,REF_SRC_MAIN_CODE  REFERRAL_SOURCE_CODE_MAIN,REF_SRC_SUB_CODE REFERRAL_SOURCE_CODE_SUB FROM BL_PRV_ENC_SELECT_INS_BG_VW where operating_facility_id='"+facility_id+"' and patient_id='"+patient_id+"' AND Blcommon.Valid_Ins_payer_yn(operating_facility_id,'"+strModuleId+"',cust_group_code,cust_code,policy_type_code) ='Y' AND episode_type=Decode('"+dflt_prv_fin_dtl_acrs_enc_yn+"','Y',episode_type,'"+strEpisodeType+"') AND nvl(episode_id,99999999) = decode(episode_type,'R',nvl(episode_id,99999999),'"+episode_id+"') AND nvl(visit_id,99999999) = decode(episode_type,'R',nvl(visit_id,99999999),'I',nvl(visit_id,99999999),'D',nvl(visit_id,99999999),'"+visit_id+"') order by priority";

//												System.err.println("Inside Encounter Level Insurance check:"+sql_ins);
										}
									}
									pstmt1 = con.prepareStatement(sql_ins,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
									
									
									rs1 = pstmt1.executeQuery() ;

									if( rs1 != null ) 
									{
										if(!rs1.next())
										{
//												System.err.println("Inside Insurance Not Record Found");
											inside_loop_chk="Y";
											rs1.close();
											pstmt1.close();
									
											sql_ins="SELECT DISTINCT a.cust_code cust_code,DECODE(a.cust_code,'**',NULL, c.short_name) cust_short_name,a.policy_type_code policy_type_code,b.short_desc policy_short_desc,a.priority_no priority,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int,blng_grp_id,a.cust_group_code cust_group_code,d.policy_coverage_basis,e.short_desc FROM bl_payers_priority_by_bg a, bl_ins_policy_types_lang_vw b,ar_customer_lang_vw c,bl_ins_policy_type_hdr d,ar_cust_group_lang_vw E,bl_cust_by_cust_group f,BL_APPL_BG_BY_CLASSFCTN g WHERE a.operating_facility_id ='"+facility_id+"' AND a.blng_grp_id ='"+blng_grp_id+"' AND a.BLNG_GRP_ID = g.APPL_BLNG_GRP_ID AND a.patient_class =DECODE('"+strEpisodeType+"','R','XT','O','OP','E','AE','I','IP','D','DC') AND b.language_id = '"+locale+"' and c.ACC_ENTITY_CODE = e.ACC_ENTITY_CODE and e.ACC_ENTITY_CODE = f.ACC_ENTITY_CODE AND g.CLASSIFICATION_CODE='"+class_code+"' AND a.operating_facility_id = b.operating_facility_id AND a.operating_facility_id = d.operating_facility_id AND a.operating_facility_id = g.operating_facility_id AND (a.cust_code = d.cust_code OR d.cust_code='**') AND (c.cust_code = a.cust_code OR a.cust_code='**') AND c.cust_code=f.cust_code AND f.cust_code=g.APPL_CUST_CODE AND a.cust_group_code=f.cust_group_code AND a.cust_group_code=d.cust_group_code AND d.cust_group_code=e.cust_group_code AND d.cust_group_code=g.APPL_CUST_GROUP_CODE AND a.policy_type_code = b.policy_type_code AND a.policy_type_code = d.policy_type_code AND c.language_id = b.language_id AND b.language_id = e.language_id ORDER BY a.priority_no";

//											System.err.println("No Valid Policy Found.Default qry:"+sql_ins);
	
											pstmt1 = con.prepareStatement(sql_ins);
											rs1 = pstmt1.executeQuery() ;
										}
										else
										{
											rs1.beforeFirst();
										}
									}
								}
								else
								{
									rs1.beforeFirst();
								}
							}

							if(rs1!=null)
							{
								while( rs1.next() )
								{
									temp_ins_cust_group_code=rs1.getString("CUST_GROUP_CODE");
									if(temp_ins_cust_group_code==null || temp_ins_cust_group_code.equals("")) temp_ins_cust_group_code=" ";
									rtn_ins_cust_group_code=rtn_ins_cust_group_code+temp_ins_cust_group_code+"|";
									if(rtn_ins_cust_group_code==null) rtn_ins_cust_group_code="";
									
									temp_ins_cust_code=rs1.getString("CUST_CODE");
									if(temp_ins_cust_code==null || temp_ins_cust_code.equals("")) temp_ins_cust_code=" ";
									rtn_ins_cust_code=rtn_ins_cust_code+temp_ins_cust_code+"|";
									if(rtn_ins_cust_code==null) rtn_ins_cust_code="";

									temp_ins_cust_priority=rs1.getString("PRIORITY");
									rtn_ins_cust_priority=rtn_ins_cust_priority+temp_ins_cust_priority+"|";
									if(rtn_ins_cust_priority==null) rtn_ins_cust_priority="";
								
									temp_ins_policy_type_code=rs1.getString("POLICY_TYPE_CODE");
									rtn_ins_policy_type_code=rtn_ins_policy_type_code+temp_ins_policy_type_code+"|";
									if(rtn_ins_policy_type_code==null) rtn_ins_policy_type_code="";

									if(!temp_ins_cust_code.equals("") && !temp_ins_policy_type_code.equals(""))
									{
										try
										{
											String restrict_check_sql="SELECT DECODE('"+strEpisodeType+"','O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U'), DECODE('"+strEpisodeType+"','O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE('"+strEpisodeType+"','O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,  'U'),'U'),decode('"+strEpisodeType+"','O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode('"+strEpisodeType+"','O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+temp_ins_policy_type_code+"' AND a.CUST_CODE = '"+temp_ins_cust_code+"' and b.cust_group_code = a.cust_group_code and a.cust_code = b.cust_code and a.cust_group_code='"+temp_ins_cust_group_code+"'";
											String empty_sql_check="N";
		//														System.err.println("restrict_check_sql:"+restrict_check_sql);
											pstmt2 = con.prepareStatement(restrict_check_sql);
											rs2 = pstmt2.executeQuery() ;
											if( rs2 != null ) 
											{
												empty_sql_check="Y";
												while( rs2.next() )
												{  
													restrict_check=rs2.getString(1);
													apprd_amt_restrict_check = rs2.getString(2); 
													apprd_days_restrict_check = rs2.getString(3); 
													cred_auth_req_yn = rs2.getString(4); 
													dflt_auth_ref_as_pol_no_yn = rs2.getString(5); 
													empty_sql_check="N";

												}
											}
																	
											if(rs2 != null) rs2.close();
											pstmt2.close();

											if(empty_sql_check.equals("Y"))
											{
												restrict_check_sql="SELECT DECODE('"+strEpisodeType+"','O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U'), DECODE('"+strEpisodeType+"','O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE('"+strEpisodeType+"','O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,  'U'),'U'),decode('"+strEpisodeType+"','O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode('"+strEpisodeType+"','O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a WHERE a.OPERATING_FACILITY_ID = '"+facility_id+"' AND a.POLICY_TYPE_CODE = '"+temp_ins_policy_type_code+"' AND a.CUST_CODE = '**' and a.cust_group_code='"+temp_ins_cust_group_code+"'";
		//															System.err.println("restrict_check_sql1:"+restrict_check_sql);
												pstmt2 = con.prepareStatement(restrict_check_sql);
												rs2 = pstmt2.executeQuery() ;
												if( rs2 != null ) 
												{
													while( rs2.next() )
													{  
														restrict_check=rs2.getString(1);
														apprd_amt_restrict_check = rs2.getString(2); 
														apprd_days_restrict_check = rs2.getString(3); 
														cred_auth_req_yn = rs2.getString(4); 
														dflt_auth_ref_as_pol_no_yn = rs2.getString(5); 
													}
												}

												if(rs2 != null) rs2.close();
												pstmt2.close();
											}
										}
										catch(Exception e)
										{
											System.err.println("Exception in restrict_check_sql query:"+e);
										}
										if(restrict_check == null) restrict_check="U";
										if(apprd_amt_restrict_check == null) apprd_amt_restrict_check="U";
										if(apprd_days_restrict_check == null) apprd_days_restrict_check="U";
										if(cred_auth_req_yn == null) cred_auth_req_yn="N";
										if(dflt_auth_ref_as_pol_no_yn == null) dflt_auth_ref_as_pol_no_yn="N";

										rtn_ins_restrict_check=rtn_ins_restrict_check+restrict_check+"|";
										rtn_ins_apprd_amt_restrict_check=rtn_ins_apprd_amt_restrict_check+apprd_amt_restrict_check+"|";
		//System.out.println("rtn_ins_apprd_amt_restrict_check *** "+rtn_ins_apprd_amt_restrict_check);
										rtn_ins_apprd_days_restrict_check=rtn_ins_apprd_days_restrict_check+apprd_days_restrict_check+"|";

										rtn_ins_cred_auth_req_yn = rtn_ins_cred_auth_req_yn+cred_auth_req_yn+"|";
										rtn_ins_dflt_auth_ref_as_pol_no_yn = rtn_ins_dflt_auth_ref_as_pol_no_yn+dflt_auth_ref_as_pol_no_yn+"|";
									}
									else
									{	
										rtn_ins_restrict_check=rtn_ins_restrict_check+"U"+"|";
										rtn_ins_apprd_amt_restrict_check=rtn_ins_apprd_amt_restrict_check+"U"+"|";
										rtn_ins_apprd_days_restrict_check=rtn_ins_apprd_days_restrict_check+"U"+"|";
										rtn_ins_cred_auth_req_yn = rtn_ins_cred_auth_req_yn+"N"+"|";
										rtn_ins_dflt_auth_ref_as_pol_no_yn = rtn_ins_dflt_auth_ref_as_pol_no_yn+"N"+"|";
									}

									if(inside_loop_chk.equals("N"))
									{
//													System.err.println("Inside IFFFFF");
										temp_ins_policy_no=rs1.getString("policy_number");
										if(temp_ins_policy_no == null) temp_ins_policy_no = " ";
										rtn_ins_policy_no=rtn_ins_policy_no+temp_ins_policy_no+"|";
										if(rtn_ins_policy_no==null) rtn_ins_policy_no="";
//System.err.println("Inside Level1");								
										temp_ins_policy_start_date=rs1.getString("policy_start_date");
										if(temp_ins_policy_start_date == null) temp_ins_policy_start_date = " ";
										rtn_ins_policy_start_date=rtn_ins_policy_start_date+temp_ins_policy_start_date+"|";
										if(rtn_ins_policy_start_date==null) rtn_ins_policy_start_date="";
								
										temp_ins_policy_expiry_date=rs1.getString("policy_expiry_date");
										if(temp_ins_policy_expiry_date == null) temp_ins_policy_expiry_date = " ";		rtn_ins_policy_expiry_date=rtn_ins_policy_expiry_date+temp_ins_policy_expiry_date+"|";
										if(rtn_ins_policy_expiry_date==null) rtn_ins_policy_expiry_date="";
								
										temp_ins_credit_auth_ref=rs1.getString("credit_auth_ref");
										if(temp_ins_credit_auth_ref == null || temp_ins_credit_auth_ref.equals("")) temp_ins_credit_auth_ref=" ";
										rtn_ins_credit_auth_ref=rtn_ins_credit_auth_ref+temp_ins_credit_auth_ref+"|";
										if(rtn_ins_credit_auth_ref==null) rtn_ins_credit_auth_ref="";
								
										temp_ins_credit_auth_date=rs1.getString("credit_auth_date");
										if(temp_ins_credit_auth_date == null || temp_ins_credit_auth_date.equals("")) temp_ins_credit_auth_date= " ";
										rtn_ins_credit_auth_date=rtn_ins_credit_auth_date+temp_ins_credit_auth_date+"|";
										if(rtn_ins_credit_auth_date==null) rtn_ins_credit_auth_date="";
//System.err.println("Inside Level2");																	
										temp_ins_credit_approval_days=rs1.getString("approved_days");
										if(temp_ins_credit_approval_days==null || temp_ins_credit_approval_days.equals("")) 	temp_ins_credit_approval_days=" ";
										rtn_ins_credit_approval_days=rtn_ins_credit_approval_days+temp_ins_credit_approval_days+"|";
										if(rtn_ins_credit_approval_days==null) rtn_ins_credit_approval_days="";
								
										temp_ins_credit_approval_amount=rs1.getString("approved_amt");
										if(temp_ins_credit_approval_amount==null || temp_ins_credit_approval_amount.equals("")) temp_ins_credit_approval_amount=" ";
										rtn_ins_credit_approval_amount=rtn_ins_credit_approval_amount+temp_ins_credit_approval_amount+"|";
										if(rtn_ins_credit_approval_amount==null) rtn_ins_credit_approval_amount="";
								
										temp_ins_policy_eff_from_date=rs1.getString("effective_from");
										if(temp_ins_policy_eff_from_date == null) temp_ins_policy_eff_from_date = " ";			rtn_ins_policy_eff_from_date=rtn_ins_policy_eff_from_date+temp_ins_policy_eff_from_date+"|";
										if(rtn_ins_policy_eff_from_date==null) rtn_ins_policy_eff_from_date="";
								
										temp_ins_policy_eff_to_date=rs1.getString("effective_to");
										if(temp_ins_policy_eff_to_date == null) temp_ins_policy_eff_to_date = " ";		
										if(temp_ins_policy_eff_to_date==null || temp_ins_policy_eff_to_date.equals("")) temp_ins_policy_eff_to_date=" ";
										rtn_ins_policy_eff_to_date=rtn_ins_policy_eff_to_date+temp_ins_policy_eff_to_date+"|";
										if(rtn_ins_policy_eff_to_date==null) rtn_ins_policy_eff_to_date="";

										temp_ins_ref_src_main_code = rs1.getString("REFERRAL_SOURCE_CODE_MAIN");
										if(temp_ins_ref_src_main_code==null || temp_ins_ref_src_main_code.equals("")) temp_ins_ref_src_main_code="";
//													System.err.println("temp_ins_ref_src_main_code:"+temp_ins_ref_src_main_code);
//System.err.println("Inside Level3");								
										if(!temp_ins_ref_src_main_code.equals(""))
										{
											call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
											call.registerOutParameter(1,java.sql.Types.VARCHAR);

											call.setString(2,temp_ins_ref_src_main_code);
											call.setString(3,locale);
											call.setString(4,"1");

											call.execute();							
											temp_ins_ref_src_main_desc = call.getString(1);				
											call.close();
											if ( temp_ins_ref_src_main_desc == null || temp_ins_ref_src_main_desc.equals("")) temp_ins_ref_src_main_desc = " ";
										}
										else
										{
											temp_ins_ref_src_main_code=" ";
											temp_ins_ref_src_main_desc=" ";
										}
//System.err.println("Inside Level4");								
										rtn_ins_ref_src_main_code=rtn_ins_ref_src_main_code+temp_ins_ref_src_main_code+"|";
										if(rtn_ins_ref_src_main_code==null) rtn_ins_ref_src_main_code="";

										rtn_ins_ref_src_main_desc=rtn_ins_ref_src_main_desc+temp_ins_ref_src_main_desc+"|";
										if(rtn_ins_ref_src_main_desc==null) rtn_ins_ref_src_main_desc="";

										temp_ins_ref_src_sub_code = rs1.getString("REFERRAL_SOURCE_CODE_SUB");
										if(temp_ins_ref_src_sub_code==null || temp_ins_ref_src_sub_code.equals("")) temp_ins_ref_src_sub_code="";

										if(!temp_ins_ref_src_sub_code.equals(""))
										{
											call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
											call.registerOutParameter(1,java.sql.Types.VARCHAR);

											call.setString(2,temp_ins_ref_src_sub_code);
											call.setString(3,locale);
											call.setString(4,"1");

											call.execute();							
											temp_ins_ref_src_sub_desc = call.getString(1);				
											call.close();
										}
										else
										{
											temp_ins_ref_src_sub_code = " ";
											temp_ins_ref_src_sub_desc = " ";
										}
//System.err.println("Inside Level5");								
										if ( temp_ins_ref_src_sub_desc == null || temp_ins_ref_src_sub_desc.equals("")) temp_ins_ref_src_sub_desc = " ";

										rtn_ins_ref_src_sub_code=rtn_ins_ref_src_sub_code+temp_ins_ref_src_sub_code+"|";
										if(rtn_ins_ref_src_sub_code==null) rtn_ins_ref_src_sub_code="";

										rtn_ins_ref_src_sub_desc=rtn_ins_ref_src_sub_desc+temp_ins_ref_src_sub_desc+"|";
										if(rtn_ins_ref_src_sub_desc==null) rtn_ins_ref_src_sub_desc="";
//System.err.println("Inside Level6");								
									}
									else
									{
//													System.err.println("Inside ELSEEEEE");
										temp_ins_policy_no=" ";
										rtn_ins_policy_no=rtn_ins_policy_no+temp_ins_policy_no+"|";

										temp_ins_policy_start_date=" ";
										rtn_ins_policy_start_date=rtn_ins_policy_start_date+temp_ins_policy_start_date+"|";

										temp_ins_policy_expiry_date=" ";
										rtn_ins_policy_expiry_date=rtn_ins_policy_expiry_date+temp_ins_policy_expiry_date+"|";

										temp_ins_credit_auth_ref=" ";
										rtn_ins_credit_auth_ref=rtn_ins_credit_auth_ref+temp_ins_credit_auth_ref+"|";

										temp_ins_credit_auth_date=" ";
										rtn_ins_credit_auth_date=rtn_ins_credit_auth_date+temp_ins_credit_auth_date+"|";

										temp_ins_credit_approval_days=" ";
										rtn_ins_credit_approval_days=rtn_ins_credit_approval_days+temp_ins_credit_approval_days+"|";

										temp_ins_credit_approval_amount=" ";
										rtn_ins_credit_approval_amount=rtn_ins_credit_approval_amount+temp_ins_credit_approval_amount+"|";

										temp_ins_policy_eff_from_date=" ";
										rtn_ins_policy_eff_from_date=rtn_ins_policy_eff_from_date+temp_ins_policy_eff_from_date+"|";

										temp_ins_policy_eff_to_date=" ";
										rtn_ins_policy_eff_to_date=rtn_ins_policy_eff_to_date+temp_ins_policy_eff_to_date+"|";

										temp_ins_ref_src_main_code=" ";
										rtn_ins_ref_src_main_code=rtn_ins_ref_src_main_code+temp_ins_ref_src_main_code+"|";

										temp_ins_ref_src_main_desc=" ";
										rtn_ins_ref_src_main_desc=rtn_ins_ref_src_main_desc+temp_ins_ref_src_main_desc+"|";

										temp_ins_ref_src_sub_code=" ";
										rtn_ins_ref_src_sub_code=rtn_ins_ref_src_sub_code+temp_ins_ref_src_sub_code+"|";

										temp_ins_ref_src_sub_desc=" ";
										rtn_ins_ref_src_sub_desc=rtn_ins_ref_src_sub_desc+temp_ins_ref_src_sub_desc+"|";
//										System.err.println("Inside Level6.1");								
									}
									temp_ins_adj_rule_ind=rs1.getString("adj_rule_ind");
									if(temp_ins_adj_rule_ind==null) temp_ins_adj_rule_ind=" ";
									rtn_ins_adj_rule_ind=rtn_ins_adj_rule_ind+temp_ins_adj_rule_ind+"|";
									if(rtn_ins_adj_rule_ind==null) rtn_ins_adj_rule_ind="";
//System.err.println("Inside Level7");																	
									temp_ins_adj_perc_amt_ind=rs1.getString("adj_perc_amt_ind");
									if(temp_ins_adj_perc_amt_ind==null) temp_ins_adj_perc_amt_ind=" ";
									rtn_ins_adj_perc_amt_ind=rtn_ins_adj_perc_amt_ind+temp_ins_adj_perc_amt_ind+"|";
									if(rtn_ins_adj_perc_amt_ind==null) rtn_ins_adj_perc_amt_ind="";
									
									temp_ins_adj_perc_amt_value=rs1.getString("adj_perc_amt_value");
									if(temp_ins_adj_perc_amt_value==null) temp_ins_adj_perc_amt_value=" ";

									rtn_ins_adj_perc_amt_value=rtn_ins_adj_perc_amt_value+temp_ins_adj_perc_amt_value+"|";
									if(rtn_ins_adj_perc_amt_value==null) rtn_ins_adj_perc_amt_value="";
//System.err.println("Inside Level8");																	
									temp_ins_pmnt_diff_adj_int=rs1.getString("pmnt_diff_adj_int");
									if(temp_ins_pmnt_diff_adj_int==null) temp_ins_pmnt_diff_adj_int=" ";
									rtn_ins_pmnt_diff_adj_int=rtn_ins_pmnt_diff_adj_int+temp_ins_pmnt_diff_adj_int+"|";
									if(rtn_ins_pmnt_diff_adj_int==null) rtn_ins_pmnt_diff_adj_int="";
									
									temp_ins_drg_pmnt_diff_adj_int=rs1.getString("drg_pmnt_diff_adj_int");
									if(temp_ins_drg_pmnt_diff_adj_int==null) temp_ins_drg_pmnt_diff_adj_int=" ";
									rtn_ins_drg_pmnt_diff_adj_int=rtn_ins_drg_pmnt_diff_adj_int+temp_ins_drg_pmnt_diff_adj_int+"|";
									if(rtn_ins_drg_pmnt_diff_adj_int==null) rtn_ins_drg_pmnt_diff_adj_int="";
									
									temp_ins_spl_srv_pmnt_diff_adj_int=rs1.getString("spl_srv_pmnt_diff_adj_int");
									if(temp_ins_spl_srv_pmnt_diff_adj_int==null) temp_ins_spl_srv_pmnt_diff_adj_int=" ";									rtn_ins_spl_srv_pmnt_diff_adj_int=rtn_ins_spl_srv_pmnt_diff_adj_int+temp_ins_spl_srv_pmnt_diff_adj_int+"|";
									if(rtn_ins_spl_srv_pmnt_diff_adj_int==null) rtn_ins_spl_srv_pmnt_diff_adj_int="";
//System.err.println("Inside Level9");								
									temp_ins_blng_grp=rs1.getString("blng_grp_id");
									if(temp_ins_blng_grp==null) temp_ins_blng_grp=" ";
									if(temp_ins_cust_priority.equals("1"))
									{
										blng_grp_id=temp_ins_blng_grp;
									}
									rtn_ins_blng_grp=rtn_ins_blng_grp+temp_ins_blng_grp+"|";
//System.err.println("Inside Level10");								
								}
							}
							if(rs1 != null) rs1.close();
							pstmt1.close();

							rtn_non_ins_blng_grp = non_ins_blng_grp_id;
							if(rtn_non_ins_blng_grp==null) rtn_non_ins_blng_grp="";
//System.err.println("Inside Level11");								
							rtn_non_ins_cust_group_code = non_ins_cust_group_code;
							if(rtn_non_ins_cust_group_code==null) rtn_non_ins_cust_group_code="";

							rtn_non_ins_cust_code = non_ins_cust_code;
							if(rtn_non_ins_cust_code==null) rtn_non_ins_cust_code="";
//System.err.println("Inside Level12");								
							String sql_non_ins="select settlement_ind from bl_blng_grp where blng_grp_id ='"+non_ins_blng_grp_id+"'";
							try
							{
								pstmt2 = con.prepareStatement(sql_non_ins);
								rs2 = pstmt2.executeQuery() ;
								if( rs2 != null ) 
								{
									while( rs2.next() )
									{  
										non_ins_settlement_ind=rs2.getString("settlement_ind");
										if(non_ins_settlement_ind==null) non_ins_settlement_ind="";
									}
								}
							}
							catch(Exception e)
							{
								System.err.println("Exception in sql_non_ins query:"+e);
							}
							if(rs2 != null) rs2.close();
							pstmt2.close();					

							if(non_ins_settlement_ind.equals("C"))
							{
								if(!(credit_doc_ref_desc.equals("")))
								{
									rtn_non_ins_credit_doc_reqd_yn = "Y";
								}
								else
								{
									rtn_non_ins_credit_doc_reqd_yn = "N";
								}
								rtn_non_ins_slmt_type_code = slmt_type_code;
								if(rtn_non_ins_slmt_type_code==null) rtn_non_ins_slmt_type_code="";

								rtn_non_ins_inst_ref = inst_ref;
								if(rtn_non_ins_inst_ref==null) rtn_non_ins_inst_ref="";
								
								rtn_non_ins_inst_date = inst_date;
								if(rtn_non_ins_inst_date==null) rtn_non_ins_inst_date="";
								
								rtn_non_ins_inst_remarks  = inst_remarks;
								if(rtn_non_ins_inst_remarks==null) rtn_non_ins_inst_remarks="";
							}
							else
							{
								rtn_non_ins_credit_doc_reqd_yn = "Y";
							}
							rtn_non_ins_credit_doc_ref = credit_doc_ref_desc;
							if(rtn_non_ins_credit_doc_ref==null) rtn_non_ins_credit_doc_ref="";
							rtn_non_ins_credit_doc_start_date = credit_doc_ref_start_date;
							if(rtn_non_ins_credit_doc_start_date==null) rtn_non_ins_credit_doc_start_date="";
							rtn_non_ins_credit_doc_end_date  = credit_doc_ref_date;
							if(rtn_non_ins_credit_doc_end_date==null) rtn_non_ins_credit_doc_end_date="";
						}
						if(!(tabdata==null || tabdata.isEmpty()))
						{
							tabdata.put("blng_grp",blng_grp_id);
							tabdata.put("slmt_ind",slmt_ind);
							tabdata.put("annual_income",rtn_annual_family_income);
							tabdata.put("family_asset",rtn_family_assets_value);
							tabdata.put("no_of_dependants",rtn_num_of_dependents);
							tabdata.put("fin_remarks",rtn_remarks);
							tabdata.put("credit_doc_reqd_yn",rtn_credit_doc_reqd_yn);
							tabdata.put("blng_class",rtn_blng_class_code);
							tabdata.put("emp_code",rtn_employer_code);
							tabdata.put("slmt_type_code",rtn_slmt_type_code);
							tabdata.put("inst_ref",rtn_inst_ref);
							tabdata.put("inst_date",rtn_inst_date);
							tabdata.put("inst_remarks",rtn_inst_remarks);

							tabdata.put("credit_cust_group_code",rtn_credit_cust_group_code);
							tabdata.put("credit_cust_code",rtn_credit_cust_code);
							tabdata.put("credit_doc_ref",rtn_credit_doc_ref);
							tabdata.put("credit_doc_start_date",rtn_credit_doc_start_date);
							tabdata.put("credit_doc_end_date",rtn_credit_doc_end_date);
							tabdata.put("sponsor_cust_group_code",rtn_sponsor_cust_group_code);
							tabdata.put("sponsor_cust_code",rtn_sponsor_cust_code);
							tabdata.put("sponsor_credit_doc_ref",rtn_sponsor_credit_doc_ref);
							tabdata.put("sponsor_credit_doc_start_date",rtn_sponsor_credit_doc_start_date);
							tabdata.put("sponsor_credit_doc_end_date",rtn_sponsor_credit_doc_end_date);
							tabdata.put("ins_blng_grp",rtn_ins_blng_grp);
							tabdata.put("ins_cust_group_code",rtn_ins_cust_group_code);
							tabdata.put("ins_cust_code",rtn_ins_cust_code);
							tabdata.put("ins_cust_priority",rtn_ins_cust_priority);
							tabdata.put("ins_policy_type_code",rtn_ins_policy_type_code);
							tabdata.put("ins_policy_no",rtn_ins_policy_no);
							tabdata.put("ins_policy_start_date",rtn_ins_policy_start_date);
							tabdata.put("ins_policy_expiry_date",rtn_ins_policy_expiry_date);
							tabdata.put("ins_credit_auth_ref",rtn_ins_credit_auth_ref);
							tabdata.put("ins_credit_auth_date",rtn_ins_credit_auth_date);
							tabdata.put("ins_credit_approval_days",rtn_ins_credit_approval_days);
							tabdata.put("ins_credit_approval_amount",rtn_ins_credit_approval_amount);
							tabdata.put("ins_policy_eff_from_date",rtn_ins_policy_eff_from_date);
							tabdata.put("ins_policy_eff_to_date",rtn_ins_policy_eff_to_date);
							tabdata.put("ins_adj_rule_ind",rtn_ins_adj_rule_ind);
							tabdata.put("ins_adj_perc_amt_ind",rtn_ins_adj_perc_amt_ind);
							tabdata.put("ins_adj_perc_amt_value",rtn_ins_adj_perc_amt_value);
							tabdata.put("ins_pmnt_diff_adj_int",rtn_ins_pmnt_diff_adj_int);
							tabdata.put("ins_drg_pmnt_diff_adj_int",rtn_ins_drg_pmnt_diff_adj_int);
							tabdata.put("ins_spl_srv_pmnt_diff_adj_int",rtn_ins_spl_srv_pmnt_diff_adj_int);
							tabdata.put("non_ins_blng_grp",rtn_non_ins_blng_grp);
							tabdata.put("non_ins_credit_doc_reqd_yn",rtn_non_ins_credit_doc_reqd_yn);
							tabdata.put("non_ins_slmt_type_code",rtn_non_ins_slmt_type_code); 
							tabdata.put("non_ins_inst_ref",rtn_non_ins_inst_ref);
							tabdata.put("non_ins_inst_date",rtn_non_ins_inst_date);
							tabdata.put("non_ins_inst_remarks",rtn_non_ins_inst_remarks);
							tabdata.put("non_ins_cust_group_code",rtn_non_ins_cust_group_code);
							tabdata.put("non_ins_cust_code",rtn_non_ins_cust_code);
							tabdata.put("non_ins_credit_doc_ref",rtn_non_ins_credit_doc_ref);
							tabdata.put("non_ins_credit_doc_start_date",rtn_non_ins_credit_doc_start_date);
							tabdata.put("non_ins_credit_doc_end_date",rtn_non_ins_credit_doc_end_date);
							tabdata.put("ins_restrict_check",rtn_ins_restrict_check);
							tabdata.put("ins_apprd_amt_restrict_check",rtn_ins_apprd_amt_restrict_check);

							tabdata.put("ins_apprd_days_restrict_check",rtn_ins_apprd_days_restrict_check);
							tabdata.put("ins_cred_auth_req_yn",rtn_ins_cred_auth_req_yn);
							tabdata.put("ins_dflt_auth_ref_as_pol_no_yn",rtn_ins_dflt_auth_ref_as_pol_no_yn);
							tabdata.put("resp_for_payment",rtn_resp_for_bill_payment);
							tabdata.put("pat_reln_with_resp_person",rtn_pat_reln_with_resp_pers);
							tabdata.put("gl_holder_name",rtn_gl_holder_name);
							tabdata.put("pat_reln_with_gl_holder",rtn_pat_reln_with_gl_holder);
							tabdata.put("ref_src_main_code",rtn_ref_src_main_code);
							tabdata.put("ref_src_main_desc",rtn_ref_src_main_desc);
							tabdata.put("ref_src_sub_code",rtn_ref_src_sub_code);
							tabdata.put("ref_src_sub_desc",rtn_ref_src_sub_desc);
							tabdata.put("ins_ref_src_main_code",rtn_ins_ref_src_main_code);
							tabdata.put("ins_ref_src_main_desc",rtn_ins_ref_src_main_desc);
							tabdata.put("ins_ref_src_sub_code",rtn_ins_ref_src_sub_code);
							tabdata.put("ins_ref_src_sub_desc",rtn_ins_ref_src_sub_desc);
							tabdata.put("non_ins_ref_src_main_code",rtn_non_ins_ref_src_main_code);
							tabdata.put("non_ins_ref_src_main_desc",rtn_non_ins_ref_src_main_desc);
							tabdata.put("non_ins_ref_src_sub_code",rtn_non_ins_ref_src_sub_code);
							tabdata.put("non_ins_ref_src_sub_desc",rtn_non_ins_ref_src_sub_desc);
							tabdata.put("tot_valid_enc_with_gl",rtn_tot_valid_enc_with_gl);
							tabdata.put("tot_valid_op_enc_with_gl",rtn_tot_valid_op_enc_with_gl);
							tabdata.put("tot_valid_ae_enc_with_gl",rtn_tot_valid_ae_enc_with_gl);
							tabdata.put("tot_valid_ip_enc_with_gl",rtn_tot_valid_ip_enc_with_gl);
							tabdata.put("tot_valid_dc_enc_with_gl",rtn_tot_valid_dc_enc_with_gl);
							tabdata.put("no_of_enc_gl_availed",no_of_enc_gl_availed);
							tabdata.put("no_of_op_enc_gl_availed",no_of_op_enc_gl_availed);
							tabdata.put("no_of_ae_enc_gl_availed",no_of_ae_enc_gl_availed);
							tabdata.put("no_of_ip_enc_gl_availed",no_of_ip_enc_gl_availed);
							tabdata.put("no_of_dc_enc_gl_availed",no_of_dc_enc_gl_availed);

							tabdata.put("gl_doc_ref_exist_YN",gl_doc_ref_exist_YN);		
							tabdata.put("upd_patient_fin_dtls_yn",upd_fin_dtls);
							tabdata.put("spl_clinic_rel_enc_YN",rtn_is_special_clinic_related);
							tabdata.put("user_id",user_id);
							tabdata.put("class_code",class_code);	
							tabdata.put("class_type",class_type);
							tabdata.put("inc_asset_ind",rtn_inc_asset_ind);	
							tabdata.put("ind_inc",rtn_ind_inc);	
							tabdata.put("ind_inc_freq",rtn_ind_inc_freq);	
							tabdata.put("spouse_inc",rtn_spouse_inc);	
							tabdata.put("spouse_inc_freq",rtn_spouse_inc_freq);	
							tabdata.put("dependent_inc",rtn_dependent_inc);	
							tabdata.put("dependent_inc_freq",rtn_dependent_inc_freq);	
							tabdata.put("valid_from",rtn_valid_from);	
							tabdata.put("valid_to",rtn_valid_to);	
							tabdata.put("last_date",rtn_last_date);	
							tabdata.put("social_pensioner_id",rtn_social_pensioner_id);
						}
					session.setAttribute("financial_details",tabdata);
					System.err.println("2001, AddModifyPatFinDetailsMain.jsp ===>"+tabdata);
					}
				}
				if(rs != null) rs.close();
				pstmt.close();
			}
			catch(Exception e)
			{
				System.err.println("Error while defaulting Future Clas Data:"+e);
				out.println("Error while defaulting Future Clas Data:"+e);
			}
		}
		//System.out.println("Class **** Frames");

            _bw.write(_wl_block2Bytes, _wl_block2);

//		if(fin_class_flag_YN.equals("Y") && (strModuleId.equals("MP") || strModuleId.equals("IP")))
		if(fin_class_flag_YN.equals("Y") && !calling_function_id.equals("BOOKING"))
		{

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strAllParam));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strAllParam));
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		else
		{   
			strAllParam = strAllParam +"&fin_class_flag_YN="+fin_class_flag_YN;
			strAllParam = strAllParam +"&practo_appt_yn="+practo_appt_yn;

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( strAllParam));
            _bw.write(_wl_block13Bytes, _wl_block13);

//	if(dflt_pat_bg_for_encntr_regn_yn.equals("Y"))
//	{
				if((billing_mode.equals("Modify")) || (operation.equals("Update")))
				{

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strAllParam));
            _bw.write(_wl_block15Bytes, _wl_block15);

				}	
				else
				{

            _bw.write(_wl_block16Bytes, _wl_block16);

				}
//	}

            _bw.write(_wl_block17Bytes, _wl_block17);

		} 

            _bw.write(_wl_block18Bytes, _wl_block18);

	
/*Added by karthik to clear session Beans INCLUDE_POLICY_DETAILS_CRF - Ends*/
	}
	catch(Exception e)
	{
		System.err.println("Main Exception:"+e);
	}
	finally
	{
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
