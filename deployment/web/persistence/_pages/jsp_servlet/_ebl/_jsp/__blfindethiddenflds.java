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
import eBL.BLReportIdMapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blfindethiddenflds extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLFinDetHiddenFlds.jsp", 1743571132188L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t\t\t<script>\n\t\t\t//parent.parent.document.getElementById(\'dialog-body\').contentWindow.returnValue = \'success\';\n\t\t    //parent.parent.document.getElementById(\'dialog_tag\').close();   \n\t\t\t\tparent.window.returnValue=\'success\';\n\t\t\t\twindow.close();\n\t\t\t</script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n  \n<input type=\'hidden\' name=\'billing_group\' id=\'billing_group\' value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></input>\n<input type=\'hidden\' name=\'billing_mode\' id=\'billing_mode\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></input>\n<input type=\'hidden\' name=\'bl_operation\' id=\'bl_operation\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></input>\n<input type=\'hidden\' name=\'bl_future_admn_YN\' id=\'bl_future_admn_YN\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'></input>\n<!--\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'></input>\n\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'></input>\n<input type=\'hidden\' name=\'last_visit_dtls\' id=\'last_visit_dtls\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'></input>\n-->\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<script>\n\t\t\t\tvar confirm_flag=confirm(getMessage(\"BL9797\",\"BL\"));\n\t\t\t\tif(confirm_flag)\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].bl_future_admn_YN.value=\"Y\";\n\t\t\t\t\tvar retVal;\n\t\t\t\t\tvar dialogHeight= \"0\" ;\n\t\t\t\t\tvar dialogWidth\t= \"0\" ;\n\t\t\t\t\tvar dialogTop = \"0\" ;\n\t\t\t\t\tvar center = \"0\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\tvar status=\"no\";\n\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\t\tvar url=\"../../eBL/jsp/BLFutureAdmnValuesLoad.jsp?patient_id=\"+\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"+\"&episode_type=\"+\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"+\"&record=\"+\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"+\"&episode=\"+\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t\t\tretVal = window.showModalDialog(url,arguments,features);\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].bl_future_admn_YN.value=\"N\";\n\t\t\t\t}\n\t\t\t\t\n\t\t\t</script>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" \n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );
	
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

/*Karthik added for encounter_specific_details starts*/
/*
Sr No        Version           Incident        SCF/CRF               Developer Name
-----------------------------------------------------------------------------------
1            V210629             19794        MMS-ME-SCF-0025-TF     Mohana priya K
2            V210806             21929        SKR-SCF-1625			 MuthukumarN
3 								 32970		  ML-MMOH-SCF-2047       Manivel N
4			 V220714			 33548		  MMS-ICN-00132	         Manivel N
5            V220719             34184        ML-MMOH-SCF-2047       Manivel N
6            V220824             35490        ML-MMOH-SCF-2113       Manivel N
*/

	Connection con				= null;
	Connection conn				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	ResultSet rsr				= null;
	int column_count = 1;
	con	=	ConnectionManager.getConnection(request);	

	String addedFacilityId =(String) session.getValue("facility_id");

	String moduleId_new =request.getParameter("module_id_new");
	if(moduleId_new==null) moduleId_new="";

	String custID= BLReportIdMapper.getCustomerId();

	String calling_module_id1=request.getParameter("calling_module");
	if(calling_module_id1==null) calling_module_id1="";

	String policyBLInclusionFlag=null;
	String dflt_policy_vst_reg=null;
	String policyValidQry="select NVL(charge_logic_yn,'N'),DFLT_POLICY_DEF_IN_VIS_REG_YN  from bl_parameters  where operating_facility_id = ?";

	Boolean siteSpec=false;
	Boolean siteBLQryChngBlngGrpINOP = false; //Shikha
	try
	{
		
		siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DONT_DFLT_POL_EXP_DAYS_CONFIG");
		System.err.println("SiteSpec"+siteSpec);
	}catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception in site specific "+e);
	}

	//shikha
	try {
		siteBLQryChngBlngGrpINOP = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_QRY_CHNG_BLNG_GRP_IN_OP");
		System.err.println("siteBLQryChngBlngGrpINOP" + siteBLQryChngBlngGrpINOP);
	} catch (Exception e) {
		e.printStackTrace();
		System.err.println("Exception in siteBLQryChngBlngGrpINOP site specific " + e);
	}
	//shikha
	try{
		pstmt = con.prepareStatement(policyValidQry);
		pstmt.setString(1, addedFacilityId);
		rsr=pstmt.executeQuery();
		if( rsr != null ) 
		{
			while(rsr.next())
			{
				policyBLInclusionFlag=rsr.getString(1);
				dflt_policy_vst_reg=rsr.getString(2);
				dflt_policy_vst_reg=dflt_policy_vst_reg==null?"N":dflt_policy_vst_reg;
			
			}
		}
		if(rsr != null) rsr.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e){
		policyBLInclusionFlag ="N";
		System.err.println("Error in BLFinDetHiddenFlds.jsp 77-"+e);
		e.printStackTrace();
	}
	String resetIPFinDtls="select NVL(IP_FIN_DTL_RESET,'N')  from bl_mp_param ";
	String resetIPFlag = "";
	String strSql="";
	String strSqlEnd ="";

	try{
		pstmt = con.prepareStatement(resetIPFinDtls);
		rsr=pstmt.executeQuery();
		if( rsr != null ) 
		{
			while(rsr.next())
			{			
				resetIPFlag=rsr.getString(1);						
			}
		}
		if(rsr != null) rsr.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e){
			e.printStackTrace();
			System.err.println("Error in BLFinDetHiddenFlds.jsp 100-"+e);
		resetIPFlag ="N";
	}
	// ConnectionManager.returnConnection(con, request);
	session.setAttribute("LINK_POLICY_IN_BILLING",policyBLInclusionFlag);	
	//karthik added code INCLUDE_POLICY_DETAILS_CRF ends


//String policyBLInclusionFlag= (session.getAttribute("LINK_POLICY_IN_BILLING")==null) ? "N": //(String)session.getAttribute("LINK_POLICY_IN_BILLING");
//policyBLInclusionFlag  = "Y";   //Modified By DhanasekarV
	String params = request.getQueryString();

            _bw.write(_wl_block1Bytes, _wl_block1);
            {java.lang.String __page ="../../eBL/jsp/BLClearBeanForInsurance.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block1Bytes, _wl_block1);

	if(policyBLInclusionFlag!=null && policyBLInclusionFlag.equals("Y")){
		String enc_patient_id= request.getParameter("patient_id");
		String enc_episode_type= request.getParameter("episode_type");
		String enc_episode_id= request.getParameter("episode_id");
		String enc_visit_id= request.getParameter("visit_id");
		String strEncPatRegDate= request.getParameter("encounter_date");
		String enc_locale= (String)session.getAttribute("LOCALE");
		String enc_facility_id= (String) session.getAttribute("facility_id");
		String policy_num=  request.getParameter("policy_num");
		String acct_seq=  request.getParameter("acct_seq");
		String oldFormat = "dd/MM/yyyy HH:mm:ss";
		String newFormat = "dd/MM/yyyy";
		SimpleDateFormat sdf1 = new SimpleDateFormat(oldFormat);
		SimpleDateFormat sdf2 = new SimpleDateFormat(newFormat);	    
	    try {
			if(strEncPatRegDate!=null)
	    	strEncPatRegDate=sdf2.format(sdf1.parse(strEncPatRegDate));
	    } catch (ParseException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        System.err.println("exception in BLFinDetHiddenFlds.jsp 135-"+e);
	    }
	
		// karthik added code on 5-25-2013 INCLUDE_POLICY_DETAILS_CRF
		
		if(enc_patient_id==null) enc_patient_id=""; 						
		if(enc_episode_type==null) enc_episode_type="";
		if(enc_episode_id==null) enc_episode_id="";
		if(enc_visit_id==null) enc_visit_id="";
		if(acct_seq==null) acct_seq="";
		if(policy_num==null) policy_num="";
		if(strEncPatRegDate==null) strEncPatRegDate="";
		
		HashMap encPlcyRecElementsMap=new HashMap();
		encPlcyRecElementsMap.put("enc_facility_id", enc_facility_id);
		encPlcyRecElementsMap.put("enc_patient_id", enc_patient_id);
		encPlcyRecElementsMap.put("enc_episode_type",enc_episode_type );
		encPlcyRecElementsMap.put("enc_episode_id",enc_episode_id );
		encPlcyRecElementsMap.put("enc_visit_id", enc_visit_id);
		encPlcyRecElementsMap.put("enc_locale", enc_locale);
		encPlcyRecElementsMap.put("policy_num", policy_num);
		encPlcyRecElementsMap.put("acct_seq", acct_seq);
		encPlcyRecElementsMap.put("encounter_date", strEncPatRegDate);
		encPlcyRecElementsMap.put("dflt_policy_vst_reg",dflt_policy_vst_reg);
		
		//if(session.getAttribute("ENCOUNTER_POLICY_RECORD_ELEMENTS")==null){
//		if((calling_module_id1.equals("MP")== true && enc_patient_id.length()>0) ||( calling_module_id1.equals("MP")== false || !"".equals(enc_patient_id)) &&((enc_episode_id!=null && !"".equals(enc_episode_id)) || enc_episode_type.equals("R")==true))
	
	if((calling_module_id1.equals("MP")== false || !"".equals(enc_patient_id)) &&((enc_episode_id!=null && !"".equals(enc_episode_id)) || enc_episode_type.equals("R")==true))
		session.setAttribute("ENCOUNTER_POLICY_RECORD_ELEMENTS",encPlcyRecElementsMap);
		//}
}

/*Karthik added for encounter_specific_details	ends*/	
	
	//Connection con=null ;
	CallableStatement call =null;
//	PreparedStatement pstmt = null;
	PreparedStatement pstmt1  = null;
	PreparedStatement pstmt2  = null;
	PreparedStatement pstmt3  = null;

	//ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;

  	try
  	{	

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		conn = ConnectionManager.getConnection(request);

		HashMap tabdata = new HashMap();

		String patient_id="";
		String user_id = "";
		String facility_id = (String)httpSession.getValue("facility_id");	
		String locale			= (String)session.getAttribute("LOCALE");
		String last_visit_dtls="N";
		String sql="",episode="",record="";
		String sql_ins="";
		String patient_class="";
		String episode_id="",visit_id="";
		String query_string="";
		String dflt_prv_fin_dtl_acrs_enc_yn="N";

		int future_adm_count=0;
		String bl_future_admn_YN="N";

		String mp_dflt_YN="";
		String enc_dflt_YN="";
		String mp_dflt_frst_enc_YN="N";
		String no_rec_found_in_enc_level_YN="N";
		String inside_loop_chk="N";
		String selected_from_prev_enc_YN="N";
		String called_for_reclass = "N", fin_class_flag_YN="N";
		int assessmentMonths = 0;

		String str_appt_bkng_epi_type="";
		String str_appt_book_ref_num="";

		// Varibales for sql query
		String slmt_type_code="",inst_ref="", inst_date="",inst_remarks="";
		String cust_group_code="", cust_code="",credit_doc_ref_desc="",credit_doc_ref_start_date="",credit_doc_ref_date="";
		String non_ins_blng_grp_id="",non_ins_cust_group_code="",non_ins_cust_code="",non_ins_settlement_ind="";

//		String rtn_no_of_enc_gl_valid="", rtn_no_of_op_enc_gl_valid="", rtn_no_of_ae_enc_gl_valid="", rtn_no_of_ip_enc_gl_valid ="", rtn_no_of_dc_enc_gl_valid="";
		
		String rtn_tot_valid_enc_with_gl="", rtn_tot_valid_op_enc_with_gl="", rtn_tot_valid_ae_enc_with_gl="", rtn_tot_valid_ip_enc_with_gl ="", rtn_tot_valid_dc_enc_with_gl="";
		
		String no_of_enc_gl_availed="0",no_of_op_enc_gl_availed="0",no_of_ae_enc_gl_availed="0",no_of_ip_enc_gl_availed="0",no_of_dc_enc_gl_availed="0";

		String gl_doc_ref_exist_YN="N";

		// return variables
		String rtn_blng_class_code="",rtn_employer_code="",rtn_slmt_ind="",rtn_blng_grp="";
		String rtn_annual_family_income="",rtn_family_assets_value="",rtn_num_of_dependents="";
		String rtn_resp_for_bill_payment="",rtn_pat_reln_with_resp_pers="",rtn_gl_holder_name="",rtn_pat_reln_with_gl_holder="";
		String rtn_ref_src_main_code="",rtn_ref_src_main_desc="",rtn_ref_src_sub_code="",rtn_ref_src_sub_desc="";

		String rtn_slmt_type_code="",rtn_inst_ref="",rtn_inst_date="",rtn_inst_remarks="";
		String rtn_credit_doc_reqd_yn="",rtn_credit_cust_group_code="",rtn_credit_cust_code="",rtn_credit_doc_ref="",rtn_credit_doc_start_date="",rtn_credit_doc_end_date="";
		String rtn_sponsor_cust_group_code ="",rtn_sponsor_cust_code="",rtn_sponsor_credit_doc_ref="",rtn_sponsor_credit_doc_start_date="",rtn_sponsor_credit_doc_end_date="";

		String rtn_ins_blng_grp="",rtn_ins_cust_group_code="",rtn_ins_cust_code="",rtn_ins_cust_priority="",rtn_ins_policy_type_code="",rtn_ins_policy_no="";
		String rtn_ins_restrict_check = "", rtn_ins_apprd_amt_restrict_check = "", rtn_ins_apprd_days_restrict_check= "";
		String rtn_ins_cred_auth_req_yn = "", rtn_ins_dflt_auth_ref_as_pol_no_yn = "", rtn_ins_cred_auth_mand_capt_yn="";

		String rtn_ins_policy_start_date="",rtn_ins_policy_expiry_date="",rtn_ins_credit_auth_ref="",rtn_ins_credit_auth_date="";
		String rtn_ins_credit_approval_days="",rtn_ins_credit_approval_amount="",rtn_ins_policy_eff_from_date="",rtn_ins_policy_eff_to_date="";
		String rtn_ins_adj_rule_ind="",rtn_ins_adj_perc_amt_ind="",rtn_ins_adj_perc_amt_value="",rtn_ins_pmnt_diff_adj_int="",rtn_ins_drg_pmnt_diff_adj_int="",rtn_ins_spl_srv_pmnt_diff_adj_int="";
		String rtn_non_ins_blng_grp="",rtn_non_ins_cust_group_code="",rtn_non_ins_cust_code="",rtn_non_ins_credit_doc_reqd_yn="",rtn_non_ins_slmt_type_code="";
		String rtn_non_ins_inst_ref="",rtn_non_ins_inst_date="",rtn_non_ins_inst_remarks="",rtn_non_ins_credit_doc_ref="",rtn_non_ins_credit_doc_start_date="",rtn_non_ins_credit_doc_end_date="";

		String rtn_ins_ref_src_main_code="", rtn_ins_ref_src_main_desc="", rtn_ins_ref_src_sub_code="", rtn_ins_ref_src_sub_desc="";
		String rtn_non_ins_ref_src_main_code="", rtn_non_ins_ref_src_main_desc="", rtn_non_ins_ref_src_sub_code="", rtn_non_ins_ref_src_sub_desc="";
		String rtn_remarks="", rtn_fin_remarks="";

		String rtn_inc_asset_ind="",rtn_ind_inc="",rtn_ind_inc_freq="",rtn_spouse_inc="",rtn_spouse_inc_freq="",rtn_dependent_inc="",rtn_dependent_inc_freq="",rtn_class_code="",rtn_class_type="",rtn_valid_from="",rtn_valid_to="",rtn_last_date="",rtn_social_pensioner_id="";

		String temp_ins_blng_grp="",temp_ins_cust_group_code="",temp_ins_cust_code="",temp_ins_cust_priority="",temp_ins_policy_type_code="",temp_ins_policy_no="";
		String temp_ins_policy_start_date="",temp_ins_policy_expiry_date="",temp_ins_credit_auth_ref="",temp_ins_credit_auth_date="";
		String temp_ins_credit_approval_days="",temp_ins_credit_approval_amount="",temp_ins_policy_eff_from_date="",temp_ins_policy_eff_to_date="";
		String temp_ins_adj_rule_ind="",temp_ins_adj_perc_amt_ind="",temp_ins_adj_perc_amt_value="",temp_ins_pmnt_diff_adj_int="",temp_ins_drg_pmnt_diff_adj_int="",temp_ins_spl_srv_pmnt_diff_adj_int="";

		String temp_ins_ref_src_main_code="", temp_ins_ref_src_main_desc="", temp_ins_ref_src_sub_code="", temp_ins_ref_src_sub_desc="";

		String restrict_check="", apprd_amt_restrict_check = "", apprd_days_restrict_check = "";
		String cred_auth_req_yn ="", dflt_auth_ref_as_pol_no_yn = "", cred_auth_mand_capt_yn="";

		String rtn_is_special_clinic_related = "N", fin_dtl_already_avail_YN="N", blng_grp_changed_YN="N";
		//String fin_class_dtls_updated_YN="N";

		String billing_mode="Add",upd_fin_dtls="C", operation="Insert";
		
		
		String  finDetClose="N";

		query_string=request.getParameter("query_string");
		if(query_string==null) query_string="";

		blng_grp_changed_YN =request.getParameter("blng_grp_changed_YN");
		if(blng_grp_changed_YN==null) blng_grp_changed_YN="N";
/*
		if(blng_grp_changed_YN.equals("Y"))
		{
			session.removeAttribute("financial_details");
		}
*/
		String calling_function_id=request.getParameter("calling_function_id");
		if(calling_function_id==null) calling_function_id="";

		String calling_module_id=request.getParameter("calling_module");
		if(calling_module_id==null) calling_module_id="";

		String disaster_regn_YN=request.getParameter("disaster_regn_YN");
		if(disaster_regn_YN==null) disaster_regn_YN="";

		String episode_type=request.getParameter("episode_type");
		if(episode_type==null) episode_type="";

		if(calling_module_id.equals("MP"))
		{
			episode_type="R";
		}

		String str_bkng_ref_no=request.getParameter("bookingrefno");
		if(str_bkng_ref_no == null) str_bkng_ref_no="";

		String str_appt_ref_no=request.getParameter("apptrefno");
		if(str_appt_ref_no == null) str_appt_ref_no="";

		
		String POLICY_EFF_T0_TMP="";  // Added By Vijay for MMS-QF-SCf-567
		String rtn_ins_pol_eff_to_tmp="";
		String rtnCreditAuthorisationBy="", rtnClaimCode="", rtnMembershipNumber="", tmpCreditAuthorisationBy="", tmpClaimCode="", tmpMembershipNumber="";//Added V190814-Aravindh/AMS-SCF-0808

/*
		if(!str_bkng_ref_no.equals("") || !str_appt_ref_no.equals(""))
		{
			if(episode_type.equals("I") || episode_type.equals("D"))
			{
				str_appt_bkng_epi_type="B";
				str_appt_book_ref_num=str_bkng_ref_no;
			}
			else if(episode_type.equals("O"))
			{
				str_appt_bkng_epi_type="A";
				str_appt_book_ref_num=str_appt_ref_no;
			}
			else if(episode_type.equals("R"))
			{

			}
		}
*/
		if(!str_bkng_ref_no.equals(""))
		{
			if(episode_type.equals("I") || episode_type.equals("D") || episode_type.equals("R"))
			{
				str_appt_bkng_epi_type="B";
				str_appt_book_ref_num=str_bkng_ref_no;
			}
		}

		if(!str_appt_ref_no.equals(""))
		{
			if(episode_type.equals("O")  || episode_type.equals("R"))
			{
				str_appt_bkng_epi_type="A";
				str_appt_book_ref_num=str_appt_ref_no;
			}
		}
System.err.println("episode_type in hiddenflds.jsp:"+episode_type);
		if(calling_module_id.equals("MP"))
			patient_class="XT";
		else if(calling_module_id.equals("AE"))
			patient_class="EM";
		else if(calling_module_id.equals("OP")) 
			patient_class="OP";
		else if(calling_module_id.equals("IP")) 
			patient_class="IP";
		else if(calling_module_id.equals("DC")) 
			patient_class="DC";

		selected_from_prev_enc_YN=request.getParameter("selected_from_prev_enc_YN");
		if(selected_from_prev_enc_YN==null) selected_from_prev_enc_YN="N";

		called_for_reclass = request.getParameter("called_for_reclass");
		if(called_for_reclass==null) called_for_reclass="N";

		patient_id=request.getParameter("patient_id");
		if(patient_id==null) patient_id="";
		episode=request.getParameter("episode");
		record=request.getParameter("record");
			
		if(episode==null)episode="";
		if(record==null)record="";

		
		try
		{
			String mp_dflt_YN_qry="select nvl(DFLT_PAT_BG_FOR_ENCNTR_REGN_YN,'N'),nvl(DFLT_LAST_ENCTR_FIN_DTLS_YN,'N'),nvl(DFLT_PAT_FIN_FOR_FST_ENC_YN,'N'),nvl(DFLT_PRV_FIN_DTL_ACROSS_ENC_YN,'N') from bl_mp_param";
			pstmt = con.prepareStatement(mp_dflt_YN_qry);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() )
				{  
					mp_dflt_YN = rs2.getString(1);			
					enc_dflt_YN = rs2.getString(2);
					mp_dflt_frst_enc_YN= rs2.getString(3);
					dflt_prv_fin_dtl_acrs_enc_yn = rs2.getString(4);		
				}
			}
			if (rs2 != null) rs2.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception in mp_dflt_YN_qry:"+e);
		}
		System.err.println("In Hidden Fields JSP mp_dflt_YN_qry:"+mp_dflt_YN+"|"+enc_dflt_YN+"|"+mp_dflt_frst_enc_YN+"|"+dflt_prv_fin_dtl_acrs_enc_yn);

		try
		{
			String sql_bl_class = "Select AUTO_FIN_CLASSFCTN_IN_USE_YN,ASSESSMENT_MONTHS from BL_PARAMETERS Where OPERATING_FACILITY_ID = ?";
			pstmt = con.prepareStatement(sql_bl_class);
			pstmt.setString(1, facility_id);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() )
				{  
					fin_class_flag_YN = rs2.getString("AUTO_FIN_CLASSFCTN_IN_USE_YN");
					assessmentMonths = rs2.getInt("ASSESSMENT_MONTHS");
				}
			}
			if (pstmt != null) pstmt.close();
			if (rs2 != null) rs2.close();

			if(fin_class_flag_YN == null) fin_class_flag_YN="N";
		}
		catch(Exception e)
		{ 	e.printStackTrace();
			System.err.println("Exception in mp_dflt_YN_qry 420-:"+e);
		}
		System.err.println("In Hidden Fields JSP sql_bl_class:"+fin_class_flag_YN+"|"+assessmentMonths);
		System.err.println("values:"+calling_module_id+"|"+disaster_regn_YN+"|"+calling_function_id+"|"+siteBLQryChngBlngGrpINOP);
		if(called_for_reclass.equals("N"))
		{
			System.err.println("Inside called_for_reclass = N Loop selected_from_prev_enc_YN->"+selected_from_prev_enc_YN);
			session.removeAttribute("financial_details");
			if(selected_from_prev_enc_YN.equals("N"))
			{
				System.err.println("Inside selected_from_prev_enc_YN = N");
				
				if(calling_module_id.equals("AE") && disaster_regn_YN.equals("Y") )
				{
					System.err.println("Inside Line 435");
					rtn_blng_grp=request.getParameter("dflt_disaster_blng_grp_id");
					rtn_slmt_type_code=request.getParameter("dflt_slmt_type_code");
					rtn_slmt_ind=request.getParameter("settlement_ind");
					rtn_blng_class_code=request.getParameter("emer_blng_class_code");

					if(rtn_blng_grp == null) rtn_blng_grp="";
					if(rtn_slmt_type_code == null) rtn_slmt_type_code="";
					if(rtn_slmt_ind == null) rtn_slmt_ind="";
					if(rtn_blng_class_code == null) rtn_blng_class_code="";

					operation="Update";
					billing_mode="Modify";
				}
				else 
				{
					System.err.println("Inside Line 451");
					if((calling_module_id.equals("IP") || calling_module_id.equals("DC")) && (calling_function_id.equals("ADMISSION")))
					{
						try
						{
							String future_adm_check_sql="select count(1) from bl_ins_track_dtls where OPERATING_FACILITY_ID= ? and PATIENT_ID= ? and adm_status='F' and trunc(EXPECTED_ADM_DATE)=trunc(sysdate) and ca_status='A' and active_yn='Y'";

							pstmt2 = con.prepareStatement(future_adm_check_sql);
							pstmt2.setString(1, facility_id);
							pstmt2.setString(2, patient_id);
							rs2 = pstmt2.executeQuery() ;
							if( rs2 != null ) 
							{
								while( rs2.next() )
								{
									future_adm_count=rs2.getInt(1);
								}
							}
							if (rs2 != null)   rs2.close();
							pstmt2.close();
						}
						catch(Exception e)
						{
							e.printStackTrace();
							System.err.println("Exception in future_adm_check_sql:"+e);
						}
					}
					System.err.println("Inside Line 477:"+episode);
					if(episode.equals("N"))
					{
						String cond="Select last_episode_id, last_visit_id from op_last_visit where last_patient_id=? ";
						pstmt2 = con.prepareStatement(cond);
						pstmt2.setString(1, patient_id);
						rs2 = pstmt2.executeQuery() ;
						if( rs2 != null ) 
						{
							while( rs2.next() )
							{
								last_visit_dtls="Y";
							}
						}
						if (rs2 != null)   rs2.close();
						pstmt2.close();
					}
					System.err.println("Inside Line 493:"+str_appt_book_ref_num);
					if(str_appt_book_ref_num.equals(""))
					{
						if(mp_dflt_YN.equals("Y") || calling_module_id.equals("MP"))
						{
							System.err.println("Inside Line 498");
							pstmt = con.prepareStatement("select blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc , slmt_doc_ref_date,slmt_doc_remarks,cust_group_code,cust_code,credit_doc_ref_desc,credit_doc_ref_start_date, credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,financial_remarks,gl_holder_name,pat_reln_with_gl_holder, REFERRAL_SOURCE_CODE_MAIN,REFERRAL_SOURCE_CODE_SUB,NON_INS_REF_SOURCE_CODE_MAIN,NON_INS_REF_SOURCE_CODE_SUB,episode_id,visit_id,IS_SPECIAL_CLINIC_RELATED,NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,CLASSIFICATION_START_DATE,CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID,LAST_DATE from (select b.blng_grp_id,b.settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc ,to_char(slmt_doc_ref_date,'dd/mm/yyyy') slmt_doc_ref_date,slmt_doc_remarks,b.cust_group_code,b.cust_code,credit_doc_ref_desc,to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date,to_char(credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,financial_remarks,gl_holder_name,pat_reln_with_gl_holder,blcommon.BL_VALID_REF_SOURCE_CODE(b.REFERRAL_SOURCE_CODE_MAIN,?) REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(b.REFERRAL_SOURCE_CODE_SUB,?) REFERRAL_SOURCE_CODE_SUB,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_MAIN,?) NON_INS_REF_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_SUB,?) NON_INS_REF_SOURCE_CODE_SUB,null episode_id,null visit_id,null IS_SPECIAL_CLINIC_RELATED,null NO_OF_ENC_GL_VALID,null NO_OF_OP_ENC_GL_VALID,null NO_OF_AE_ENC_GL_VALID,null NO_OF_IP_ENC_GL_VALID,null NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,to_char(CLASSIFICATION_START_DATE,'DD/MM/YYYY') CLASSIFICATION_START_DATE,to_char(CLASSIFICATION_END_DATE,'DD/MM/YYYY') CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID, to_char(add_months(CLASSIFICATION_START_DATE,?),'dd/mm/yyyy') LAST_DATE from bl_patient_fin_dtls a, BL_ENCOUNTER_PAYER_PRIORITY b where a.patient_id =? and a.patient_id = b.patient_id and b.episode_type='R' and  b.ACCT_SEQ_NO=a.CUR_ACCT_SEQ_NO and (a.non_ins_blng_grp_id is null or (a.non_ins_blng_grp_id is not null and b.PRIORITY is not null)) and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and b.blng_grp_id=c.blng_grp_id) /*order by B.PRIORITY*/) where rownum=1",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
							
							pstmt.setString(1,episode_type);
							pstmt.setString(2,episode_type);
							pstmt.setString(3,episode_type);
							pstmt.setString(4,episode_type);
							pstmt.setInt(5,assessmentMonths);
							pstmt.setString(6,patient_id);
							pstmt.setString(7,calling_module_id);
							pstmt.setString(8,calling_module_id);
							pstmt.setString(9,calling_module_id);
							pstmt.setString(10,calling_module_id);
							pstmt.setString(11,calling_module_id);
							rs = pstmt.executeQuery() ;
						}
						else if(enc_dflt_YN.equals("Y"))
						{
							System.err.println("Inside Line 516");
							// shikha internal server error
							if (siteBLQryChngBlngGrpINOP) {
								strSql = "select operating_facility_id,episode_type,patient_id,episode_id,visit_id,regn_date_time,blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc,slmt_doc_ref_date,slmt_doc_remarks,cust_group_code,cust_code,credit_doc_ref_desc,credit_doc_ref_start_date,credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,null financial_remarks,gl_holder_name,pat_reln_with_gl_holder,referral_source_code_main,referral_source_code_sub,non_ins_ref_source_code_main,non_ins_ref_source_code_sub,null IS_SPECIAL_CLINIC_RELATED,NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,CLASSIFICATION_START_DATE,CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID,LAST_DATE from (select  b.operating_facility_id,b.episode_type,b.patient_id,b.episode_id,b.visit_id,To_Char(regn_date_time,'yyyy/mm/dd hh24:mi:ss') regn_date_time,b.blng_grp_id,b.settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc,slmt_doc_ref_date,slmt_doc_remarks,b.cust_group_code,b.cust_code,credit_doc_ref_desc,credit_doc_ref_start_date,credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,null financial_remarks,gl_holder_name,pat_reln_with_gl_holder,b.referral_source_code_main,b.referral_source_code_sub,non_ins_ref_source_code_main,non_ins_ref_source_code_sub,null IS_SPECIAL_CLINIC_RELATED,NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,to_char(CLASSIFICATION_START_DATE,'DD/MM/YYYY') CLASSIFICATION_START_DATE,to_char(CLASSIFICATION_END_DATE,'DD/MM/YYYY') CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID, to_char(add_months(CLASSIFICATION_START_DATE,?),'dd/mm/yyyy') LAST_DATE from BL_PRV_ENC_SELECT_MAIN_BG_VW a,BL_ENCOUNTER_PAYER_PRIORITY B where a.operating_facility_id=? and a.operating_facility_id=b.operating_facility_id and a.patient_id=? and a.patient_id = b.patient_id and (a.episode_type ='R' or (a.episode_type <> 'R' and a.episode_id=b.episode_id)) and (a.episode_type in ('R','I','D') or (a.episode_type in ('O','E') and a.visit_id=b.visit_id)) AND a.episode_type=Decode(?,'Y',a.episode_type,?) and  b.ACCT_SEQ_NO=a.CUR_ACCT_SEQ_NO and (a.non_ins_blng_grp_id is null or (a.non_ins_blng_grp_id is not null and b.PRIORITY is not null))  ";
										System.err.println("if condition, 496==strSql==>>>"+strSql);
							}else {
										//Added against V210806
								strSql = "select operating_facility_id,episode_type,patient_id,episode_id,visit_id,regn_date_time,blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc,slmt_doc_ref_date,slmt_doc_remarks,cust_group_code,cust_code,credit_doc_ref_desc,credit_doc_ref_start_date,credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,null financial_remarks,gl_holder_name,pat_reln_with_gl_holder,referral_source_code_main,referral_source_code_sub,non_ins_ref_source_code_main,non_ins_ref_source_code_sub,null IS_SPECIAL_CLINIC_RELATED,NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,CLASSIFICATION_START_DATE,CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID,LAST_DATE from (select  b.operating_facility_id,b.episode_type,b.patient_id,b.episode_id,b.visit_id,To_Char(regn_date_time,'yyyy/mm/dd hh24:mi:ss') regn_date_time,b.blng_grp_id,b.settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc,slmt_doc_ref_date,slmt_doc_remarks,b.cust_group_code,b.cust_code,credit_doc_ref_desc,credit_doc_ref_start_date,credit_doc_ref_date,a.non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,null financial_remarks,gl_holder_name,pat_reln_with_gl_holder,b.referral_source_code_main,b.referral_source_code_sub,non_ins_ref_source_code_main,non_ins_ref_source_code_sub,null IS_SPECIAL_CLINIC_RELATED,NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,to_char(CLASSIFICATION_START_DATE,'DD/MM/YYYY') CLASSIFICATION_START_DATE,to_char(CLASSIFICATION_END_DATE,'DD/MM/YYYY') CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID, to_char(add_months(CLASSIFICATION_START_DATE,?),'dd/mm/yyyy') LAST_DATE from BL_PRV_ENC_SELECT_MAIN_BG_VW a,BL_ENCOUNTER_PAYER_PRIORITY B,bl_blng_grp c where a.operating_facility_id=? and a.operating_facility_id=b.operating_facility_id and a.patient_id=? and a.patient_id = b.patient_id and (a.episode_type ='R' or (a.episode_type <> 'R' and a.episode_id=b.episode_id)) and a.episode_type=Decode(?,'Y',a.episode_type,?) and ((a.episode_type in ('R','I','D') AND ((? = 'MP' AND ref_yn = 'Y') OR ( ? = 'IP' AND ip_yn = 'Y') OR (? = 'DC' AND dy_yn = 'Y'))) or (a.episode_type in ('O','E') and a.visit_id=b.visit_id AND ((? = 'OP' AND op_yn = 'Y') OR (? = 'AE' AND ae_yn = 'Y')))) AND b.ACCT_SEQ_NO=a.CUR_ACCT_SEQ_NO and (a.non_ins_blng_grp_id is null or (a.non_ins_blng_grp_id is not null and b.PRIORITY is not null)) AND b.blng_grp_id = c.blng_grp_id /*and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and b.blng_grp_id=c.blng_grp_id)*/ "; // moved module id specific conditions at last based on parameter setStrings. Correction done against ML-MMOH-SCF-2047
										System.err.println("else condition, 498==strSql==>>>"+strSql);
										//Added against V210806
							}
							// shikha internal server error
							strSqlEnd = "order by b.added_date  desc /*order by B.PRIORITY*/) WHERE rownum=1";
							System.err.println("Final, 531==strSqlEnd==>>>"+strSqlEnd);
							
							// V220719 no trace on why this condition is added. also HSA doesnt have credit auth as mandatory. hence commenting after discussion
							/* commented this condition for ML-MMOH-SCF-2047 by Manivel N on 19/07/2022
							if (custID.equals("SHALM") )
							{
								if((episode_type.equals("I")||episode_type.equals("D")) && resetIPFlag.equals("Y"))
								{
								 strSql = strSql  + "and 1 = 2";
								}
								 else if(episode_type.equals("O")||episode_type.equals("E"))
								{								
								 strSql = strSql  + " and CREDIT_DOC_REF_DATE is not null AND TRUNC(SYSDATE) BETWEEN  to_date(credit_doc_ref_start_date,'dd/mm/yyyy') AND to_date(credit_doc_ref_date,'dd/mm/yyyy') ";
								}
							}
							*/

							strSql = strSql + strSqlEnd;
							System.err.println("Params for Sql @ 546"+assessmentMonths+"|"+facility_id+"|"+patient_id+"|"+dflt_prv_fin_dtl_acrs_enc_yn+"|"+episode_type+"|"+siteBLQryChngBlngGrpINOP+"|"+calling_module_id);
							
							System.err.println("Final, 546==strSql==>>>"+strSql);

							pstmt = con.prepareStatement(strSql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
							pstmt.setInt(1,assessmentMonths);
							pstmt.setString(2,facility_id);
							pstmt.setString(3,patient_id);
							pstmt.setString(4,dflt_prv_fin_dtl_acrs_enc_yn);
							pstmt.setString(5,episode_type);
							if (!(siteBLQryChngBlngGrpINOP)) {								
								pstmt.setString(6,calling_module_id);
								pstmt.setString(7,calling_module_id);
								pstmt.setString(8,calling_module_id);
								pstmt.setString(9,calling_module_id);
								pstmt.setString(10,calling_module_id);
							}	
							rs = pstmt.executeQuery() ;
							System.err.println("BLFinDetHiddenFlds.jsp 562");
						}
					}
					else
					{  	
						System.err.println("In Else @ 567:"+episode_type);
						if(episode_type.equals("I") || episode_type.equals("D") || episode_type.equals("O"))
						{
							pstmt = con.prepareStatement("select blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc ,slmt_doc_ref_date,slmt_doc_remarks,cust_group_code,cust_code,credit_doc_ref_desc,credit_doc_ref_start_date,credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,financial_remarks,gl_holder_name,pat_reln_with_gl_holder,REFERRAL_SOURCE_CODE_MAIN,REFERRAL_SOURCE_CODE_SUB,NON_INS_REF_SOURCE_CODE_MAIN,NON_INS_REF_SOURCE_CODE_SUB,episode_id,visit_id,IS_SPECIAL_CLINIC_RELATED,NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,CLASSIFICATION_START_DATE,CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID,LAST_DATE from (select b.blng_grp_id,b.settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc ,to_char(slmt_doc_ref_date,'dd/mm/yyyy') slmt_doc_ref_date,slmt_doc_remarks,b.cust_group_code,b.cust_code,credit_doc_ref_desc,to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date,to_char(credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,financial_remarks,gl_holder_name,pat_reln_with_gl_holder,blcommon.BL_VALID_REF_SOURCE_CODE(b.REFERRAL_SOURCE_CODE_MAIN ,?) REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(b.REFERRAL_SOURCE_CODE_SUB,?) REFERRAL_SOURCE_CODE_SUB,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_MAIN,?) NON_INS_REF_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_SUB,?) NON_INS_REF_SOURCE_CODE_SUB,null episode_id,null visit_id,nvl(IS_SPECIAL_CLINIC_RELATED,'N') IS_SPECIAL_CLINIC_RELATED,null NO_OF_ENC_GL_VALID,null NO_OF_OP_ENC_GL_VALID,null NO_OF_AE_ENC_GL_VALID,null NO_OF_IP_ENC_GL_VALID,null NO_OF_DC_ENC_GL_VALID,null PATIENT_INC_ASSET_IND,null PATIENT_INC_ASSET_AMT,null PATIENT_INC_ASSET_FREQ,null SPOUSE_INC_ASSET_AMT,null SPOUSE_INC_ASSET_FREQ,null DEPENDENT_INC_ASSET_AMT,null DEPENDENT_INC_ASSET_FREQ,null CLASSIFICATION_CODE,null CLASSIFICATION_TYPE,null  CLASSIFICATION_START_DATE,null CLASSIFICATION_END_DATE,null SOCIAL_PENSIONER_ID,null LAST_DATE from bl_booking_fin_dtls a, BL_ENCOUNTER_PAYER_PRIORITY b where a.appt_book_ref_num=? and b.OPERATING_FACILITY_ID=? AND a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID and a.appt_book_ref_num = b.appt_book_ref_num and b.episode_type IN ('A','B') and  b.ACCT_SEQ_NO=a.CUR_ACCT_SEQ_NO and (a.non_ins_blng_grp_id is null or (a.non_ins_blng_grp_id is not null and b.PRIORITY is not null)) and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and b.blng_grp_id=c.blng_grp_id) order by b.added_date  desc /*order by B.PRIORITY*/) where rownum=1",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
							pstmt.setString(1,episode_type);
							pstmt.setString(2,episode_type);
							pstmt.setString(3,episode_type);
							pstmt.setString(4,episode_type);
							pstmt.setString(5,str_appt_book_ref_num);
							pstmt.setString(6,facility_id);
							pstmt.setString(7,calling_module_id);
							pstmt.setString(8,calling_module_id);
							pstmt.setString(9,calling_module_id);
							pstmt.setString(10,calling_module_id);
							pstmt.setString(11,calling_module_id);
							rs = pstmt.executeQuery() ;						
							System.err.println("BLFinDetHiddenFlds.jsp 574");
						}

						if(calling_module_id.equals("MP") && episode_type.equals("R"))
						{							
							pstmt = con.prepareStatement("select blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc , slmt_doc_ref_date,slmt_doc_remarks,cust_group_code,cust_code,credit_doc_ref_desc,credit_doc_ref_start_date, credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,financial_remarks,gl_holder_name,pat_reln_with_gl_holder,REFERRAL_SOURCE_CODE_MAIN,REFERRAL_SOURCE_CODE_SUB,NON_INS_REF_SOURCE_CODE_MAIN,NON_INS_REF_SOURCE_CODE_SUB,episode_id,visit_id,IS_SPECIAL_CLINIC_RELATED,NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,CLASSIFICATION_START_DATE,CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID,LAST_DATE from (select b.blng_grp_id,b.settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc ,to_char(slmt_doc_ref_date,'dd/mm/yyyy') slmt_doc_ref_date,slmt_doc_remarks,b.cust_group_code,b.cust_code,credit_doc_ref_desc,to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date,to_char(credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,financial_remarks,gl_holder_name,pat_reln_with_gl_holder,blcommon.BL_VALID_REF_SOURCE_CODE(b.REFERRAL_SOURCE_CODE_MAIN ,?) REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(b.REFERRAL_SOURCE_CODE_SUB,?) REFERRAL_SOURCE_CODE_SUB,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_MAIN,?) NON_INS_REF_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_SUB,?) NON_INS_REF_SOURCE_CODE_SUB,null episode_id,null visit_id,null IS_SPECIAL_CLINIC_RELATED,null NO_OF_ENC_GL_VALID,null NO_OF_OP_ENC_GL_VALID,null NO_OF_AE_ENC_GL_VALID,null NO_OF_IP_ENC_GL_VALID,null NO_OF_DC_ENC_GL_VALID,null PATIENT_INC_ASSET_IND,null PATIENT_INC_ASSET_AMT,null PATIENT_INC_ASSET_FREQ,null SPOUSE_INC_ASSET_AMT,null SPOUSE_INC_ASSET_FREQ,null DEPENDENT_INC_ASSET_AMT,null DEPENDENT_INC_ASSET_FREQ,null CLASSIFICATION_CODE,null CLASSIFICATION_TYPE,null  CLASSIFICATION_START_DATE,null CLASSIFICATION_END_DATE,null SOCIAL_PENSIONER_ID,null LAST_DATE from bl_booking_fin_dtls a,BL_ENCOUNTER_PAYER_PRIORITY b where a.appt_book_ref_num=? and a.appt_book_ref_num=b.appt_book_ref_num and b.OPERATING_FACILITY_ID=? AND a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID  and  b.ACCT_SEQ_NO=a.CUR_ACCT_SEQ_NO and (a.non_ins_blng_grp_id is null or (a.non_ins_blng_grp_id is not null and b.PRIORITY is not null)) and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and b.blng_grp_id=c.blng_grp_id) order by b.added_date  desc /*order by B.PRIORITY*/) where rownum=1",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
							pstmt.setString(1,episode_type);
							pstmt.setString(2,episode_type);
							pstmt.setString(3,episode_type);
							pstmt.setString(4,episode_type);
							pstmt.setString(5,str_appt_book_ref_num);
							pstmt.setString(6,facility_id);
							pstmt.setString(7,calling_module_id);
							pstmt.setString(8,calling_module_id);
							pstmt.setString(9,calling_module_id);
							pstmt.setString(10,calling_module_id);
							pstmt.setString(11,calling_module_id);
							rs = pstmt.executeQuery() ;		
							System.err.println("BLFinDetHiddenFlds.jsp 592");
						}

						if(rs!=null)
						{	
							if(!rs.next())
							{
								System.err.println("BLFinDetHiddenFlds.jsp 608 when rs has no data");	
								if(mp_dflt_YN.equals("Y"))
								{
									System.err.println("BLFinDetHiddenFlds.jsp 611");			
									pstmt = con.prepareStatement("select blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc , slmt_doc_ref_date,slmt_doc_remarks,cust_group_code,cust_code,credit_doc_ref_desc,credit_doc_ref_start_date, credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,financial_remarks,gl_holder_name,pat_reln_with_gl_holder, REFERRAL_SOURCE_CODE_MAIN,REFERRAL_SOURCE_CODE_SUB,NON_INS_REF_SOURCE_CODE_MAIN,NON_INS_REF_SOURCE_CODE_SUB,episode_id,visit_id,IS_SPECIAL_CLINIC_RELATED,NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,CLASSIFICATION_START_DATE,CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID,LAST_DATE from (select b.blng_grp_id,b.settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc ,to_char(slmt_doc_ref_date,'dd/mm/yyyy') slmt_doc_ref_date,slmt_doc_remarks,b.cust_group_code,b.cust_code,credit_doc_ref_desc,to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date,to_char(credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,financial_remarks,gl_holder_name,pat_reln_with_gl_holder,blcommon.BL_VALID_REF_SOURCE_CODE(b.REFERRAL_SOURCE_CODE_MAIN,?) REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(b.REFERRAL_SOURCE_CODE_SUB,?) REFERRAL_SOURCE_CODE_SUB,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_MAIN,?) NON_INS_REF_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_SUB,?) NON_INS_REF_SOURCE_CODE_SUB,null episode_id,null visit_id,null IS_SPECIAL_CLINIC_RELATED,null NO_OF_ENC_GL_VALID,null NO_OF_OP_ENC_GL_VALID,null NO_OF_AE_ENC_GL_VALID,null NO_OF_IP_ENC_GL_VALID,null NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,to_char(CLASSIFICATION_START_DATE,'DD/MM/YYYY') CLASSIFICATION_START_DATE,to_char(CLASSIFICATION_END_DATE,'DD/MM/YYYY') CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID, to_char(add_months(CLASSIFICATION_START_DATE,?),'dd/mm/yyyy') LAST_DATE from bl_patient_fin_dtls a, BL_ENCOUNTER_PAYER_PRIORITY b where a.patient_id =? and a.patient_id = b.patient_id and b.episode_type='R' and  b.ACCT_SEQ_NO=a.CUR_ACCT_SEQ_NO and (a.non_ins_blng_grp_id is null or (a.non_ins_blng_grp_id is not null and b.PRIORITY is not null)) and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and b.blng_grp_id=c.blng_grp_id) order by b.added_date  desc /*order by B.PRIORITY*/) where rownum=1",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
									pstmt.setString(1,episode_type);
									pstmt.setString(2,episode_type);
									pstmt.setString(3,episode_type);
									pstmt.setString(4,episode_type);
									pstmt.setInt(5,assessmentMonths);
									pstmt.setString(6,patient_id);
									pstmt.setString(7,calling_module_id);
									pstmt.setString(8,calling_module_id);
									pstmt.setString(9,calling_module_id);
									pstmt.setString(10,calling_module_id);
									pstmt.setString(11,calling_module_id);
									rs = pstmt.executeQuery() ;		
									System.err.println("BLFinDetHiddenFlds.jsp 625");
								}
								else if(enc_dflt_YN.equals("Y"))
								{
									System.err.println("BLFinDetHiddenFlds.jsp 629");

									System.err.println("Query, enc_dflt_YN==>>"+enc_dflt_YN);
									//pstmt = con.prepareStatement("select operating_facility_id,episode_type,patient_id,episode_id,visit_id,regn_date_time,blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc,slmt_doc_ref_date,slmt_doc_remarks,cust_group_code,cust_code,credit_doc_ref_desc,credit_doc_ref_start_date,credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,null financial_remarks,gl_holder_name,pat_reln_with_gl_holder,referral_source_code_main,referral_source_code_sub,non_ins_ref_source_code_main,non_ins_ref_source_code_sub,null IS_SPECIAL_CLINIC_RELATED,NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,CLASSIFICATION_START_DATE,CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID,LAST_DATE from (select  b.operating_facility_id,b.episode_type,b.patient_id,b.episode_id,b.visit_id,To_Char(regn_date_time,'yyyy/mm/dd hh24:mi:ss') regn_date_time,b.blng_grp_id,b.settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc,slmt_doc_ref_date,slmt_doc_remarks,b.cust_group_code,b.cust_code,credit_doc_ref_desc,credit_doc_ref_start_date,credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,null financial_remarks,gl_holder_name,pat_reln_with_gl_holder,b.referral_source_code_main,b.referral_source_code_sub,non_ins_ref_source_code_main,non_ins_ref_source_code_sub,null IS_SPECIAL_CLINIC_RELATED,NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,to_char(CLASSIFICATION_START_DATE,'DD/MM/YYYY') CLASSIFICATION_START_DATE,to_char(CLASSIFICATION_END_DATE,'DD/MM/YYYY') CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID, to_char(add_months(CLASSIFICATION_START_DATE,?),'dd/mm/yyyy') LAST_DATE from BL_PRV_ENC_SELECT_MAIN_BG_VW a,BL_ENCOUNTER_PAYER_PRIORITY B where a.operating_facility_id=? and a.operating_facility_id=b.operating_facility_id and a.patient_id=? and a.patient_id = b.patient_id and (a.episode_type ='R' or (a.episode_type <> 'R' and a.episode_id=b.episode_id)) and (a.episode_type in ('R','I','D') or (a.episode_type in ('O','E') and a.visit_id=b.visit_id)) AND a.episode_type=Decode(?,'Y',a.episode_type,?) and  b.ACCT_SEQ_NO=a.CUR_ACCT_SEQ_NO and (a.non_ins_blng_grp_id is null or (a.non_ins_blng_grp_id is not null and b.PRIORITY is not null)) and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and b.blng_grp_id=c.blng_grp_id) order by b.added_date  desc /*order by B.PRIORITY*/) WHERE rownum=1",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
									//Commented against V210806
			
									//Added against V210806
									pstmt = con.prepareStatement("select operating_facility_id,episode_type,patient_id,episode_id,visit_id,regn_date_time,blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc,slmt_doc_ref_date,slmt_doc_remarks,cust_group_code,cust_code,credit_doc_ref_desc,credit_doc_ref_start_date,credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,null financial_remarks,gl_holder_name,pat_reln_with_gl_holder,referral_source_code_main,referral_source_code_sub,non_ins_ref_source_code_main,non_ins_ref_source_code_sub,null IS_SPECIAL_CLINIC_RELATED,NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,CLASSIFICATION_START_DATE,CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID,LAST_DATE from (select  b.operating_facility_id,b.episode_type,b.patient_id,b.episode_id,b.visit_id,To_Char(regn_date_time,'yyyy/mm/dd hh24:mi:ss') regn_date_time,b.blng_grp_id,b.settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc,slmt_doc_ref_date,slmt_doc_remarks,b.cust_group_code,b.cust_code,credit_doc_ref_desc,credit_doc_ref_start_date,credit_doc_ref_date,a.non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,null financial_remarks,gl_holder_name,pat_reln_with_gl_holder,b.referral_source_code_main,b.referral_source_code_sub,non_ins_ref_source_code_main,non_ins_ref_source_code_sub,null IS_SPECIAL_CLINIC_RELATED,NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,to_char(CLASSIFICATION_START_DATE,'DD/MM/YYYY') CLASSIFICATION_START_DATE,to_char(CLASSIFICATION_END_DATE,'DD/MM/YYYY') CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID, to_char(add_months(CLASSIFICATION_START_DATE,?),'dd/mm/yyyy') LAST_DATE  from BL_PRV_ENC_SELECT_MAIN_BG_VW a,BL_ENCOUNTER_PAYER_PRIORITY B,bl_blng_grp c where a.operating_facility_id=? and a.operating_facility_id=b.operating_facility_id and a.patient_id=? and a.patient_id = b.patient_id and (a.episode_type ='R' or (a.episode_type <> 'R' and a.episode_id=b.episode_id)) and ((a.episode_type in ('R','I','D') AND ((? = 'MP' AND ref_yn = 'Y') OR ( ? = 'IP' AND ip_yn = 'Y') OR (? = 'DC' AND dy_yn = 'Y'))) or (a.episode_type in ('O','E') and a.visit_id=b.visit_id AND ((? = 'OP' AND op_yn = 'Y') OR (? = 'AE' AND ae_yn = 'Y')))) AND a.episode_type=Decode(?,'Y',a.episode_type,?) and  b.ACCT_SEQ_NO=a.CUR_ACCT_SEQ_NO and (a.non_ins_blng_grp_id is null or (a.non_ins_blng_grp_id is not null and b.PRIORITY is not null)) AND b.blng_grp_id = c.blng_grp_id /*and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and b.blng_grp_id=c.blng_grp_id)*/ order by b.added_date  desc /*order by B.PRIORITY*/) WHERE rownum=1",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
									//Added against V210806
									System.err.println("Checking details:" +assessmentMonths +"/"+facility_id+"/"+patient_id+"/"+dflt_prv_fin_dtl_acrs_enc_yn+"/"+episode_type+"/"+calling_module_id);
									// V220824 changed the order in which the parameters are passed based on ?
									pstmt.setInt(1,assessmentMonths);
									pstmt.setString(2,facility_id);
									pstmt.setString(3,patient_id);
									pstmt.setString(4,calling_module_id);
									pstmt.setString(5,calling_module_id);
									pstmt.setString(6,calling_module_id);
									pstmt.setString(7,calling_module_id);
									pstmt.setString(8,calling_module_id);
									
									pstmt.setString(9,dflt_prv_fin_dtl_acrs_enc_yn);
									pstmt.setString(10,episode_type);


									rs = pstmt.executeQuery() ;		
									System.err.println("BLFinDetHiddenFlds.jsp 650");
								}
							}
							else
							{
								System.err.println("BLFinDetHiddenFlds.jsp 655 when rs has data");	
								rs.beforeFirst();
							}
						}
					}
							
					try
					{
						if(rs!=null)
						{	
							if(!rs.next() && mp_dflt_frst_enc_YN.equals("Y"))
							{
								System.err.println("BLFinDetHiddenFlds.jsp 667");
								no_rec_found_in_enc_level_YN="Y";
								rs.close();
								pstmt.close();
																	
								pstmt = con.prepareStatement("select blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc , slmt_doc_ref_date,slmt_doc_remarks,cust_group_code,cust_code,credit_doc_ref_desc,credit_doc_ref_start_date, credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,financial_remarks,gl_holder_name,pat_reln_with_gl_holder, REFERRAL_SOURCE_CODE_MAIN,REFERRAL_SOURCE_CODE_SUB,NON_INS_REF_SOURCE_CODE_MAIN,NON_INS_REF_SOURCE_CODE_SUB,episode_id,visit_id,IS_SPECIAL_CLINIC_RELATED,NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,CLASSIFICATION_START_DATE,CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID,LAST_DATE from (select b.blng_grp_id,b.settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc ,to_char(slmt_doc_ref_date,'dd/mm/yyyy') slmt_doc_ref_date,slmt_doc_remarks,b.cust_group_code,b.cust_code,credit_doc_ref_desc,to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date,to_char(credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,financial_remarks,gl_holder_name,pat_reln_with_gl_holder,blcommon.BL_VALID_REF_SOURCE_CODE(b.REFERRAL_SOURCE_CODE_MAIN,?) REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(b.REFERRAL_SOURCE_CODE_SUB,?) REFERRAL_SOURCE_CODE_SUB,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_MAIN,?) NON_INS_REF_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_SUB,?) NON_INS_REF_SOURCE_CODE_SUB,null episode_id,null visit_id,null IS_SPECIAL_CLINIC_RELATED,null NO_OF_ENC_GL_VALID,null NO_OF_OP_ENC_GL_VALID,null NO_OF_AE_ENC_GL_VALID,null NO_OF_IP_ENC_GL_VALID,null NO_OF_DC_ENC_GL_VALID,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,CLASSIFICATION_CODE,CLASSIFICATION_TYPE,to_char(CLASSIFICATION_START_DATE,'DD/MM/YYYY') CLASSIFICATION_START_DATE,to_char(CLASSIFICATION_END_DATE,'DD/MM/YYYY') CLASSIFICATION_END_DATE,SOCIAL_PENSIONER_ID, to_char(add_months(CLASSIFICATION_START_DATE,?),'dd/mm/yyyy') LAST_DATE from bl_patient_fin_dtls a, BL_ENCOUNTER_PAYER_PRIORITY b where a.patient_id =? and a.patient_id = b.patient_id and b.episode_type='R' and  b.ACCT_SEQ_NO=a.CUR_ACCT_SEQ_NO and (a.non_ins_blng_grp_id is null or (a.non_ins_blng_grp_id is not null and b.PRIORITY is not null)) and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y')) and b.blng_grp_id=c.blng_grp_id) order by b.added_date  desc /*order by B.PRIORITY*/) where rownum=1",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

								pstmt.setString(1,episode_type);
								pstmt.setString(2,episode_type);
								pstmt.setString(3,episode_type);
								pstmt.setString(4,episode_type);
								pstmt.setInt(5,assessmentMonths);
								pstmt.setString(6,patient_id);
								pstmt.setString(7,calling_module_id);
								pstmt.setString(8,calling_module_id);
								pstmt.setString(9,calling_module_id);
								pstmt.setString(10,calling_module_id);

								rs = pstmt.executeQuery() ;
								System.err.println("BLFinDetHiddenFlds.jsp 685");
							}
							else
							{
								System.err.println("BLFinDetHiddenFlds.jsp 690");
								rs.beforeFirst();
							}
						}

						if( rs != null ) 
						{
							while( rs.next() )
							{  
								System.err.println("BLFinDetHiddenFlds.jsp 699");
								operation="Update";
								billing_mode="Modify";

								episode_id = rs.getString("episode_id");
								if(episode_id == null) episode_id="";

								visit_id = rs.getString("visit_id");
								if(visit_id == null) visit_id="";

								rtn_blng_grp= rs.getString("blng_grp_id");
								if(rtn_blng_grp==null) rtn_blng_grp="";
								System.err.println("BLFinDetHiddenFlds.jsp 711:"+rtn_blng_grp);

								rtn_slmt_ind= rs.getString("settlement_ind");
								if(rtn_slmt_ind==null) rtn_slmt_ind="";
								System.err.println("BLFinDetHiddenFlds.jsp 716 rtn_slmt_ind:"+rtn_slmt_ind);
								if(last_visit_dtls.equals("N"))
								{
									rtn_annual_family_income= rs.getString("annual_family_income");

									if(rtn_annual_family_income==null) rtn_annual_family_income="";
									rtn_family_assets_value = rs.getString("family_assets_value");

									if(rtn_family_assets_value==null) rtn_family_assets_value="";
								}

								rtn_num_of_dependents= rs.getString("num_of_dependents");
								if(rtn_num_of_dependents==null) rtn_num_of_dependents="";

								rtn_resp_for_bill_payment= rs.getString("resp_for_bill_payment");
								if(rtn_resp_for_bill_payment==null) rtn_resp_for_bill_payment="";

								rtn_pat_reln_with_resp_pers= rs.getString("pat_reln_with_resp_pers");
								if(rtn_pat_reln_with_resp_pers==null) rtn_pat_reln_with_resp_pers="";

								rtn_remarks= rs.getString("remarks");
								if(rtn_remarks==null) rtn_remarks="";

								rtn_fin_remarks= rs.getString("financial_remarks");
								if(rtn_fin_remarks==null) rtn_fin_remarks="";

								rtn_gl_holder_name= rs.getString("gl_holder_name");
								if(rtn_gl_holder_name==null) rtn_gl_holder_name="";
								System.err.println("rtn_gl_holder_name 1.0 "+rtn_gl_holder_name);
								
								/* rtn_gl_holder_name=rtn_gl_holder_name.replaceAll("''", "'");
								System.err.println("rtn_gl_holder_name 1"+rtn_gl_holder_name);
								 */
								
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
									System.err.println("BLFinDetHiddenFlds.jsp 763");
									rtn_ref_src_main_desc = call.getString(1);				
									call.close();
									if ( rtn_ref_src_main_desc == null ) rtn_ref_src_main_desc = "";

								}

								rtn_ref_src_sub_code=rs.getString("REFERRAL_SOURCE_CODE_SUB");
								if(rtn_ref_src_sub_code==null) rtn_ref_src_sub_code="";

								if(!rtn_ref_src_sub_code.equals(""))
								{
												System.err.println("########  BLFinDetHiddenFlds.jsp   13 "+con.isClosed());
									call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
									call.registerOutParameter(1,java.sql.Types.VARCHAR);

									call.setString(2,rtn_ref_src_sub_code);
									call.setString(3,locale);
									call.setString(4,"1");

									call.execute();				
									System.err.println("BLFinDetHiddenFlds.jsp 784");
									rtn_ref_src_sub_desc = call.getString(1);				
									call.close();
									if ( rtn_ref_src_sub_desc == null ) rtn_ref_src_sub_desc = "";
								}

								rtn_non_ins_ref_src_main_code=rs.getString("NON_INS_REF_SOURCE_CODE_MAIN");
								if(rtn_non_ins_ref_src_main_code==null) rtn_non_ins_ref_src_main_code="";

								if(!rtn_non_ins_ref_src_main_code.equals(""))
								{
												System.err.println("########  BLFinDetHiddenFlds.jsp   14 "+con.isClosed());
									call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
									call.registerOutParameter(1,java.sql.Types.VARCHAR);

									call.setString(2,rtn_non_ins_ref_src_main_code);
									call.setString(3,locale);
									call.setString(4,"1");

									call.execute();		
									System.err.println("BLFinDetHiddenFlds.jsp 804");
									rtn_non_ins_ref_src_main_desc = call.getString(1);				
									call.close();
									if ( rtn_non_ins_ref_src_main_desc == null ) rtn_non_ins_ref_src_main_desc = "";
								}

								rtn_non_ins_ref_src_sub_code=rs.getString("NON_INS_REF_SOURCE_CODE_SUB");
								if(rtn_non_ins_ref_src_sub_code==null) rtn_non_ins_ref_src_sub_code="";

								if(!rtn_non_ins_ref_src_sub_code.equals(""))
								{
												System.err.println("########  BLFinDetHiddenFlds.jsp   15 "+con.isClosed());
									call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
									call.registerOutParameter(1,java.sql.Types.VARCHAR);

									call.setString(2,rtn_non_ins_ref_src_sub_code);
									call.setString(3,locale);
									call.setString(4,"1");

									call.execute();		
									System.err.println("BLFinDetHiddenFlds.jsp 824");
									rtn_non_ins_ref_src_sub_desc = call.getString(1);				
									call.close();
									if ( rtn_non_ins_ref_src_sub_desc == null ) rtn_non_ins_ref_src_sub_desc = "";
								}

								rtn_is_special_clinic_related = rs.getString("IS_SPECIAL_CLINIC_RELATED");
								if(rtn_is_special_clinic_related==null) rtn_is_special_clinic_related="N";

								rtn_blng_class_code= rs.getString("blng_class_code");
								if(rtn_blng_class_code==null) rtn_blng_class_code="";

								rtn_employer_code= rs.getString("employer_code");
								if(rtn_employer_code==null) rtn_employer_code="";
								user_id = p.getProperty("login_user");

								if(user_id==null) user_id="";

								slmt_type_code=rs.getString("slmt_type_code");

								System.err.println("slmt_type_code:"+slmt_type_code);
								if(slmt_type_code==null) slmt_type_code="";
								inst_ref =  rs.getString("slmt_doc_ref_desc");

								if(inst_ref==null) inst_ref="";
								inst_date = rs.getString("slmt_doc_ref_date");

								if(inst_date==null) inst_date="";
								inst_remarks = rs.getString("slmt_doc_remarks");

								if(inst_remarks==null) inst_remarks="";

								cust_code=rs.getString("cust_code");
								if(cust_code==null) cust_code="";
										System.err.println("cust_code:"+cust_code);

								cust_group_code=rs.getString("cust_group_code");
								if(cust_group_code==null) cust_group_code="";
										System.err.println("cust_group_code:"+cust_group_code);

								credit_doc_ref_desc= rs.getString("credit_doc_ref_desc");

								if(credit_doc_ref_desc==null) credit_doc_ref_desc="";
								credit_doc_ref_start_date= rs.getString("credit_doc_ref_start_date");						

								if(credit_doc_ref_start_date==null) credit_doc_ref_start_date="";
								credit_doc_ref_date= rs.getString("credit_doc_ref_date");

								if(credit_doc_ref_date==null) credit_doc_ref_date="";

								non_ins_blng_grp_id= rs.getString("non_ins_blng_grp_id");
								if(non_ins_blng_grp_id==null) non_ins_blng_grp_id="";
								System.err.println("non_ins_blng_grp_id:"+non_ins_blng_grp_id);

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
								
								if(fin_class_flag_YN.equals("Y"))
								{
									System.err.println("Inside Class Values Fetching Loop");
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

									rtn_class_code=rs.getString("CLASSIFICATION_CODE");
									if(rtn_class_code==null) rtn_class_code="";

									rtn_class_type=rs.getString("CLASSIFICATION_TYPE");
									if(rtn_class_type==null) rtn_class_type="";

									rtn_valid_from=rs.getString("CLASSIFICATION_START_DATE");
									if(rtn_valid_from==null) rtn_valid_from="";

									rtn_valid_to=rs.getString("CLASSIFICATION_END_DATE");
									if(rtn_valid_to==null) rtn_valid_to="";

									rtn_social_pensioner_id=rs.getString("SOCIAL_PENSIONER_ID");
									if(rtn_social_pensioner_id==null) rtn_social_pensioner_id="";

									rtn_last_date=rs.getString("LAST_DATE");
									if(rtn_last_date==null) rtn_last_date="";

								}
							
								if (rtn_slmt_ind.equals("C"))
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
								else if (rtn_slmt_ind.equals("R"))
								{
									column_count = 1;
									System.err.println("Inside Credit");
									rtn_credit_doc_reqd_yn = "Y";
									rtn_credit_cust_group_code = cust_group_code;
									rtn_credit_cust_code = cust_code;
									if(rtn_credit_cust_code==null) rtn_credit_cust_code="";

									String qry_gl_chk = "SELECT CREDIT_DOC_REF_DESC,NO_OF_OP_ENC_GL_AVAILED,NO_OF_AE_ENC_GL_AVAILED,NO_OF_IP_ENC_GL_AVAILED,NO_OF_DC_ENC_GL_AVAILED FROM BL_GL_HOLDER_LOOKUP_VW WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CUST_GROUP_CODE=? AND CUST_CODE=? and LANGUAGE_ID=? ";

									if(!rtn_gl_holder_name.equals(""))
									{
										qry_gl_chk = qry_gl_chk + " AND GL_HOLDER_NAME=?";
									}
									//	System.err.println("qry_gl_chk:"+qry_gl_chk);
									System.err.println("########  BLFinDetHiddenFlds.jsp   16 "+con.isClosed());
									pstmt3 = con.prepareStatement(qry_gl_chk);
									pstmt3.setString(column_count, facility_id);
									pstmt3.setString(++column_count, patient_id);
									pstmt3.setString(++column_count, cust_group_code);
									pstmt3.setString(++column_count, cust_code);
									pstmt3.setString(++column_count, locale);
									if(!rtn_gl_holder_name.equals(""))
									{
										pstmt3.setString(++column_count, rtn_gl_holder_name);
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


								if( rtn_slmt_ind.equals("R") || (rtn_slmt_ind.equals("C") && !(credit_doc_ref_desc.equals(""))))
								{
									System.err.println("Inside Credit 1035");
									rtn_credit_doc_ref = credit_doc_ref_desc;
									if(rtn_credit_doc_ref==null) rtn_credit_doc_ref="";
									rtn_credit_doc_start_date = credit_doc_ref_start_date;
									if(rtn_credit_doc_start_date==null) rtn_credit_doc_start_date="";
									rtn_credit_doc_end_date = credit_doc_ref_date;
									if(rtn_credit_doc_end_date==null) rtn_credit_doc_end_date="";
								}
								else if(rtn_slmt_ind.equals("X") &&  non_ins_blng_grp_id.equals(""))
								{
									System.err.println("Inside Sponsor 1045");
									rtn_credit_doc_reqd_yn = "Y";
									rtn_sponsor_cust_group_code = cust_group_code;
									rtn_sponsor_cust_code = cust_code;
									if(rtn_sponsor_cust_code==null) rtn_sponsor_cust_code="";
									rtn_sponsor_credit_doc_ref = credit_doc_ref_desc;
									if(rtn_sponsor_credit_doc_ref==null) rtn_sponsor_credit_doc_ref="";
									rtn_sponsor_credit_doc_start_date = credit_doc_ref_start_date;
									if(rtn_sponsor_credit_doc_start_date==null) rtn_sponsor_credit_doc_start_date="";
									rtn_sponsor_credit_doc_end_date = credit_doc_ref_date;
									if(rtn_sponsor_credit_doc_end_date==null) rtn_sponsor_credit_doc_end_date="";
									column_count = 1;
									
									String qry_gl_chk = "SELECT CREDIT_DOC_REF_DESC,NO_OF_OP_ENC_GL_AVAILED,NO_OF_AE_ENC_GL_AVAILED,NO_OF_IP_ENC_GL_AVAILED,NO_OF_DC_ENC_GL_AVAILED FROM BL_GL_HOLDER_LOOKUP_VW WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CUST_GROUP_CODE=? AND CUST_CODE=? and LANGUAGE_ID=? ";

									if(!rtn_gl_holder_name.equals(""))
									{
										qry_gl_chk = qry_gl_chk + " AND GL_HOLDER_NAME=?";
									}
									System.err.println("qry_gl_chk:"+qry_gl_chk);
									System.err.println("########  BLFinDetHiddenFlds.jsp   17"+con.isClosed());
									pstmt3 = con.prepareStatement(qry_gl_chk);
									pstmt3.setString(column_count, facility_id);
									pstmt3.setString(++column_count, patient_id);
									pstmt3.setString(++column_count, cust_group_code);
									pstmt3.setString(++column_count, cust_code);
									pstmt3.setString(++column_count, locale);
									if(!rtn_gl_holder_name.equals(""))
									{
										pstmt3.setString(++column_count, rtn_gl_holder_name);
									}
									rs3 = pstmt3.executeQuery() ;
									System.err.println("BLFinDetHiddenFlds.jsp 1072");
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
								else if(rtn_slmt_ind.equals("X") && !(non_ins_blng_grp_id.equals("")))
								{
									System.err.println("Inside Insurance 1118");
									if(str_appt_book_ref_num.equals(""))
									{
										if(mp_dflt_YN.equals("Y") || calling_module_id.equals("MP") )
										{
											pstmt1 = con.prepareStatement("SELECT a.cust_group_code cust_group_code,a.cust_code cust_code,a.priority priority,a.policy_type_code policy_type_code,a.policy_number policy_number,to_char(a.policy_start_date,'dd/mm/yyyy') policy_start_date,to_char(a.policy_expiry_date,'dd/mm/yyyy') policy_expiry_date,a.credit_auth_ref credit_auth_ref,to_char(a.credit_auth_date,'dd/mm/yyyy') credit_auth_date,to_char(a.effective_from,'dd/mm/yyyy') effective_from,to_char(a.effective_to,'dd/mm/yyyy') effective_to,a.approved_amt approved_amt,a.approved_days approved_days,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int, a.blng_grp_id blng_grp_id,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_MAIN,?) ref_src_main_code,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_SUB,?) ref_src_sub_code,a.MEMBERSHIP_NO membership_no,a.credit_auth_by credit_auth_by,  a.claim_code claim_code FROM bl_encounter_payer_priority a, bl_patient_fin_dtls b WHERE a.episode_type = 'R' AND a.patient_id =? AND a.patient_id = b.patient_id AND a.acct_seq_no = b.cur_acct_seq_no AND a.priority is not NULL AND ( (? !='MP' AND ?='Y') OR (?='MP' ) ) and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and a.blng_grp_id=c.blng_grp_id) ORDER BY 3", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); // V220714 alias naming for credit_auth_by, claim_code, membership_no

											pstmt1.setString(1,episode_type);
											pstmt1.setString(2,episode_type);
											pstmt1.setString(3,patient_id);
											pstmt1.setString(4,calling_module_id);
											pstmt1.setString(5,mp_dflt_YN);
											pstmt1.setString(6,calling_module_id);
											pstmt1.setString(7,calling_module_id);
											pstmt1.setString(8,calling_module_id);
											pstmt1.setString(9,calling_module_id);
											pstmt1.setString(10,calling_module_id);
											pstmt1.setString(11,calling_module_id);
											rs1 = pstmt1.executeQuery() ;
											System.err.println("BLFinDetHiddenFlds.jsp 1139");
										}
										else if(enc_dflt_YN.equals("Y"))
										{
											if(mp_dflt_frst_enc_YN.equals("Y") && no_rec_found_in_enc_level_YN.equals("Y"))
											{
												System.err.println("########  BLFinDetHiddenFlds.jsp   19 "+con.isClosed());
												pstmt1 = con.prepareStatement("SELECT a.cust_group_code cust_group_code,a.cust_code cust_code,a.priority priority,a.policy_type_code policy_type_code,a.policy_number policy_number,to_char(a.policy_start_date,'dd/mm/yyyy') policy_start_date,to_char(a.policy_expiry_date,'dd/mm/yyyy') policy_expiry_date,a.credit_auth_ref credit_auth_ref,to_char(a.credit_auth_date,'dd/mm/yyyy') credit_auth_date,to_char(a.effective_from,'dd/mm/yyyy') effective_from,to_char(a.effective_to,'dd/mm/yyyy') effective_to,a.approved_amt approved_amt,a.approved_days approved_days,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int, a.blng_grp_id blng_grp_id,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_MAIN,?) ref_src_main_code,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_SUB,?) ref_src_sub_code,'' membership_no,'' credit_auth_by, '' claim_code FROM bl_encounter_payer_priority a, bl_patient_fin_dtls b WHERE a.episode_type = 'R' AND a.patient_id =? AND a.patient_id = b.patient_id AND a.acct_seq_no = b.cur_acct_seq_no AND a.priority is not NULL AND ( (? !='MP') OR (?='MP' ) ) and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and a.blng_grp_id=c.blng_grp_id) ORDER BY 3",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); // V220714 alias naming for credit_auth_by, claim_code, membership_no

												System.err.println("Inside Enc Level First Enc level check 1148");
												pstmt1.setString(1,episode_type);
												pstmt1.setString(2,episode_type);
												pstmt1.setString(3,patient_id);
												pstmt1.setString(4,calling_module_id);
												pstmt1.setString(5,calling_module_id);
												pstmt1.setString(6,calling_module_id);
												pstmt1.setString(7,calling_module_id);
												pstmt1.setString(8,calling_module_id);
												pstmt1.setString(9,calling_module_id);
												pstmt1.setString(10,calling_module_id);
												rs1 = pstmt1.executeQuery() ;
												System.err.println("BLFinDetHiddenFlds.jsp 1160");
											}
											else
											{
												System.err.println("########  BLFinDetHiddenFlds.jsp   20 "+con.isClosed());
												pstmt1 = con.prepareStatement("SELECT operating_facility_id,episode_type,patient_id,episode_id,visit_id,regn_date_time,acct_seq_no,cust_group_code,cust_code,priority,policy_type_code,policy_number,policy_start_date,policy_expiry_date,credit_auth_ref,credit_auth_date,effective_from effective_from,effective_to,approved_amt,approved_days,adj_rule_ind,adj_perc_amt_ind,adj_perc_amt_value,pmnt_diff_adj_int,drg_pmnt_diff_adj_int,spl_srv_pmnt_diff_adj_int,a.blng_grp_id,ref_src_main_code,ref_src_sub_code,'' membership_no,'' credit_auth_by, '' claim_code FROM BL_PRV_ENC_SELECT_INS_BG_VW a where operating_facility_id=? and patient_id=? AND episode_type=Decode(?,'Y',episode_type,?) AND nvl(episode_id,99999999) = decode(episode_type,'R',nvl(episode_id,99999999),?) AND nvl(visit_id,99999999) = decode(episode_type,'R',nvl(visit_id,99999999),'I',nvl(visit_id,99999999),'D',nvl(visit_id,99999999),?) and exists (Select 'X' from bl_blng_grp b where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and a.blng_grp_id=b.blng_grp_id) order by priority",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); // V220714 alias naming for credit_auth_by, claim_code, membership_no

												System.err.println("Inside Encounter Level Insurance check 1167");
												pstmt1.setString(1,facility_id);
												pstmt1.setString(2,patient_id);
												pstmt1.setString(3,dflt_prv_fin_dtl_acrs_enc_yn);
												pstmt1.setString(4,episode_type);
												pstmt1.setString(5,episode_id);
												pstmt1.setString(6,visit_id);
												pstmt1.setString(7,calling_module_id);
												pstmt1.setString(8,calling_module_id);
												pstmt1.setString(9,calling_module_id);
												pstmt1.setString(10,calling_module_id);
												pstmt1.setString(11,calling_module_id);
												rs1 = pstmt1.executeQuery() ;
												System.err.println("BLFinDetHiddenFlds.jsp 1180");
											}
										}
									}
									else
									{
										if(episode_type.equals("I") || episode_type.equals("D") || episode_type.equals("O"))
										{
											System.err.println("BLFinDetHiddenFlds.jsp 1188");
											System.err.println("########  BLFinDetHiddenFlds.jsp   21 "+con.isClosed());
											//Modified V190814-Aravindh/AMS-SCF-0808/'a.membership_no, a.credit_auth_by, a.claim_code' added
											pstmt1 = con.prepareStatement("SELECT a.cust_group_code cust_group_code,a.cust_code cust_code,a.priority priority,a.policy_type_code policy_type_code,a.policy_number policy_number,to_char(a.policy_start_date,'dd/mm/yyyy') policy_start_date,to_char(a.policy_expiry_date,'dd/mm/yyyy') policy_expiry_date,a.credit_auth_ref credit_auth_ref,to_char(a.credit_auth_date,'dd/mm/yyyy') credit_auth_date,to_char(a.effective_from,'dd/mm/yyyy') effective_from,to_char(a.effective_to,'dd/mm/yyyy') effective_to,a.approved_amt approved_amt,a.approved_days approved_days,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int, a.blng_grp_id blng_grp_id,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_MAIN,?) ref_src_main_code,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_SUB,?) ref_src_sub_code,a.membership_no membership_no, a.credit_auth_by credit_auth_by, a.claim_code claim_code FROM bl_encounter_payer_priority a, bl_booking_fin_dtls b WHERE a.operating_facility_id =? AND a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID AND a.appt_book_ref_num=? AND a.episode_type = ? AND a.appt_book_ref_num = b.appt_book_ref_num AND a.acct_seq_no = b.cur_acct_seq_no AND a.priority is not NULL and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and a.blng_grp_id=c.blng_grp_id) ORDER BY 3",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); // V220714 alias naming for credit_auth_by, claim_code, membership_no

											System.err.println("Inside Insurance of Booking/Appointment 1195:");
											pstmt1.setString(1,episode_type);
											pstmt1.setString(2,episode_type);
											pstmt1.setString(3,facility_id);
											pstmt1.setString(4,str_appt_book_ref_num);
											pstmt1.setString(5,str_appt_bkng_epi_type);
											pstmt1.setString(6,calling_module_id);
											pstmt1.setString(7,calling_module_id);
											pstmt1.setString(8,calling_module_id);
											pstmt1.setString(9,calling_module_id);
											pstmt1.setString(10,calling_module_id);
											rs1 = pstmt1.executeQuery() ;
											System.err.println("BLFinDetHiddenFlds.jsp 1245");
										}
							  
										if(calling_module_id.equals("MP") && episode_type.equals("R"))
										{
											System.err.println("########  BLFinDetHiddenFlds.jsp  22 "+con.isClosed());
											pstmt1 = con.prepareStatement("SELECT a.cust_group_code cust_group_code,a.cust_code cust_code,a.priority priority,a.policy_type_code policy_type_code,a.policy_number policy_number,to_char(a.policy_start_date,'dd/mm/yyyy') policy_start_date,to_char(a.policy_expiry_date,'dd/mm/yyyy') policy_expiry_date,a.credit_auth_ref credit_auth_ref,to_char(a.credit_auth_date,'dd/mm/yyyy') credit_auth_date,to_char(a.effective_from,'dd/mm/yyyy') effective_from,to_char(a.effective_to,'dd/mm/yyyy') effective_to,a.approved_amt approved_amt,a.approved_days approved_days,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int, a.blng_grp_id blng_grp_id,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_MAIN,?) ref_src_main_code,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_SUB,?) ref_src_sub_code,'' membership_no,'' credit_auth_by, '' claim_code FROM bl_encounter_payer_priority a, bl_booking_fin_dtls b WHERE a.operating_facility_id =? AND a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID AND a.episode_type = ? AND a.appt_book_ref_num =? AND a.appt_book_ref_num = b.appt_book_ref_num AND a.acct_seq_no = b.cur_acct_seq_no AND a.priority is not NULL and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and a.blng_grp_id=c.blng_grp_id) ORDER BY priority",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); // V220714 alias naming for credit_auth_by, claim_code, membership_no

											System.err.println("Inside Insurance of Booking/Appointment's MP Default:1212");
											pstmt1.setString(1,episode_type);
											pstmt1.setString(2,episode_type);
											pstmt1.setString(3,facility_id);
											pstmt1.setString(4,str_appt_bkng_epi_type);
											pstmt1.setString(5,str_appt_book_ref_num);
											pstmt1.setString(6,calling_module_id);
											pstmt1.setString(7,calling_module_id);
											pstmt1.setString(8,calling_module_id);
											pstmt1.setString(9,calling_module_id);
											pstmt1.setString(10,calling_module_id);
											rs1 = pstmt1.executeQuery() ;
											System.err.println("BLFinDetHiddenFlds.jsp 1224");
										}

										if(rs1!=null)
										{	
											if(!rs1.next())
											{
												if(mp_dflt_YN.equals("Y") || calling_module_id.equals("MP") )
												{
													System.err.println("BLFinDetHiddenFlds.jsp 1235");
													System.err.println("########  BLFinDetHiddenFlds.jsp   23 "+con.isClosed());
													pstmt1 = con.prepareStatement("SELECT a.cust_group_code cust_group_code,a.cust_code cust_code,a.priority priority,a.policy_type_code policy_type_code,a.policy_number policy_number,to_char(a.policy_start_date,'dd/mm/yyyy') policy_start_date,to_char(a.policy_expiry_date,'dd/mm/yyyy') policy_expiry_date,a.credit_auth_ref credit_auth_ref,to_char(a.credit_auth_date,'dd/mm/yyyy') credit_auth_date,to_char(a.effective_from,'dd/mm/yyyy') effective_from,to_char(a.effective_to,'dd/mm/yyyy') effective_to,a.approved_amt approved_amt,a.approved_days approved_days,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int, a.blng_grp_id blng_grp_id,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_MAIN,?) ref_src_main_code,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_SUB,?) ref_src_sub_code,'' membership_no,'' credit_auth_by, '' claim_code FROM bl_encounter_payer_priority a, bl_patient_fin_dtls b WHERE a.episode_type = 'R' AND a.patient_id =? AND a.patient_id = b.patient_id AND a.acct_seq_no = b.cur_acct_seq_no AND a.priority is not NULL AND ( (? !='MP' AND ?='Y') OR (?='MP')) and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and a.blng_grp_id=c.blng_grp_id) ORDER BY 3",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); // V220714 alias naming for credit_auth_by, claim_code, membership_no

													System.err.println("Inside MP level check of Booking:");
													pstmt1.setString(1,episode_type);
													pstmt1.setString(2,episode_type);
													pstmt1.setString(3,patient_id);
													pstmt1.setString(4,calling_module_id);
													pstmt1.setString(5,mp_dflt_YN);
													pstmt1.setString(6,calling_module_id);
													pstmt1.setString(7,calling_module_id);
													pstmt1.setString(8,calling_module_id);
													pstmt1.setString(9,calling_module_id);
													pstmt1.setString(10,calling_module_id);
													pstmt1.setString(11,calling_module_id);
													rs1 = pstmt1.executeQuery() ;
													System.err.println("BLFinDetHiddenFlds.jsp 1297");
												}
												else if(enc_dflt_YN.equals("Y"))
												{
													System.err.println("BLFinDetHiddenFlds.jsp 1256");
													if(mp_dflt_frst_enc_YN.equals("Y") && no_rec_found_in_enc_level_YN.equals("Y"))
													{
														System.err.println("BLFinDetHiddenFlds.jsp 1259");
														System.err.println("########  BLFinDetHiddenFlds.jsp   24 "+con.isClosed());
														pstmt1 = con.prepareStatement("SELECT a.cust_group_code cust_group_code,a.cust_code cust_code,a.priority priority,a.policy_type_code policy_type_code,a.policy_number policy_number,to_char(a.policy_start_date,'dd/mm/yyyy') policy_start_date,to_char(a.policy_expiry_date,'dd/mm/yyyy') policy_expiry_date,a.credit_auth_ref credit_auth_ref,to_char(a.credit_auth_date,'dd/mm/yyyy') credit_auth_date,to_char(a.effective_from,'dd/mm/yyyy') effective_from,to_char(a.effective_to,'dd/mm/yyyy') effective_to,a.approved_amt approved_amt,a.approved_days approved_days,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int, a.blng_grp_id blng_grp_id,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_MAIN,?) ref_src_main_code,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_SUB,?) ref_src_sub_code,'' membership_no,'' credit_auth_by, '' claim_code FROM bl_encounter_payer_priority a, bl_patient_fin_dtls b WHERE a.episode_type = 'R' AND a.patient_id =? AND a.patient_id = b.patient_id AND a.acct_seq_no = b.cur_acct_seq_no AND a.priority is not NULL AND ( (? !='MP' AND ?='Y') OR (?='MP')) and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and a.blng_grp_id=c.blng_grp_id) ORDER BY 3",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); // V220714 alias naming for credit_auth_by, claim_code, membership_no

														System.err.println("Inside Insurance of Booking/Appointment's MP Default1:1264");
														pstmt1.setString(1,episode_type);
														pstmt1.setString(2,episode_type);
														pstmt1.setString(3,patient_id);
														pstmt1.setString(4,calling_module_id);
														pstmt1.setString(5,mp_dflt_frst_enc_YN);
														pstmt1.setString(6,calling_module_id);
														pstmt1.setString(7,calling_module_id);
														pstmt1.setString(8,calling_module_id);
														pstmt1.setString(9,calling_module_id);
														pstmt1.setString(10,calling_module_id);
														pstmt1.setString(11,calling_module_id);
														rs1 = pstmt1.executeQuery() ;
														System.err.println("BLFinDetHiddenFlds.jsp 1321");
														System.err.println("Inside Enc Level First Enc level check of Booking:");
													}
													else
													{
														System.err.println("BLFinDetHiddenFlds.jsp 1281");
														System.err.println("########  BLFinDetHiddenFlds.jsp   25 "+con.isClosed());
														pstmt1 = con.prepareStatement("SELECT operating_facility_id,episode_type,patient_id,episode_id,visit_id,regn_date_time,acct_seq_no,cust_group_code,cust_code,priority,policy_type_code,policy_number,policy_start_date,policy_expiry_date,credit_auth_ref,credit_auth_date,effective_from effective_from,effective_to,approved_amt,approved_days,adj_rule_ind,adj_perc_amt_ind,adj_perc_amt_value,pmnt_diff_adj_int,drg_pmnt_diff_adj_int,spl_srv_pmnt_diff_adj_int,a.blng_grp_id,ref_src_main_code,ref_src_sub_code,'' membership_no,'' credit_auth_by, '' claim_code FROM BL_PRV_ENC_SELECT_INS_BG_VW a where operating_facility_id=? and patient_id=? AND episode_type=Decode(?,'Y',episode_type,?) AND nvl(episode_id,99999999) = decode(episode_type,'R',nvl(episode_id,99999999),?) AND nvl(visit_id,99999999) = decode(episode_type,'R',nvl(visit_id,99999999),'I',nvl(visit_id,99999999),'D',nvl(visit_id,99999999),?) and exists (Select 'X' from bl_blng_grp b where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and a.blng_grp_id=b.blng_grp_id) order by priority",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); // V220714 alias naming for credit_auth_by, claim_code, membership_no

														System.err.println("Inside Encounter level check of Booking:");
														pstmt1.setString(1,facility_id);
														pstmt1.setString(2,patient_id);
														pstmt1.setString(3,dflt_prv_fin_dtl_acrs_enc_yn);
														pstmt1.setString(4,episode_type);
														pstmt1.setString(5,episode_id);
														pstmt1.setString(6,visit_id);
														pstmt1.setString(7,calling_module_id);
														pstmt1.setString(8,calling_module_id);
														pstmt1.setString(9,calling_module_id);
														pstmt1.setString(10,calling_module_id);
														pstmt1.setString(11,calling_module_id);
														rs1 = pstmt1.executeQuery() ;
														System.err.println("BLFinDetHiddenFlds.jsp 1299");
													}
												}
											}
											else
											{
												System.err.println("BLFinDetHiddenFlds.jsp 1304");
												rs1.beforeFirst();
											}
										}
									}

									try
									{
										if( rs1 != null ) 
										{
											if(!rs1.next())
											{
												System.err.println("Inside Insurance Not Record Found");
												inside_loop_chk="Y";
												rs1.close();
												pstmt1.close();
										
												System.err.println("########  BLFinDetHiddenFlds.jsp   26 "+con.isClosed());
												pstmt1 = con.prepareStatement("SELECT Distinct Decode(a.cust_code,'**',NULL,a.cust_code) cust_code,a.policy_type_code policy_type_code,a.priority_no priority,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int,a.cust_group_code cust_group_code, a.blng_grp_id blng_grp_id,'' membership_no,'' credit_auth_by, '' claim_code FROM bl_payers_priority_by_bg a, bl_ins_policy_types_lang_vw b,ar_customer_lang_vw c,bl_ins_policy_type_hdr d,bl_cust_by_cust_group e WHERE a.operating_facility_id =? AND a.blng_grp_id =? AND a.patient_class =? AND b.language_id = ? AND c.ACC_ENTITY_CODE = e.ACC_ENTITY_CODE AND a.operating_facility_id = b.operating_facility_id AND a.operating_facility_id = d.operating_facility_id AND (a.cust_code = d.cust_code OR d.cust_code='**') AND (c.cust_code = a.cust_code OR a.cust_code='**') AND c.cust_code=e.cust_code AND a.cust_group_code=e.cust_group_code AND a.cust_group_code=d.cust_group_code AND a.policy_type_code = b.policy_type_code AND a.policy_type_code = d.policy_type_code AND c.language_id = b.language_id and exists (Select 'X' from bl_blng_grp f where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and a.blng_grp_id=f.blng_grp_id) ORDER BY a.priority_no",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); // V220714 alias naming for credit_auth_by, claim_code, membership_no

												System.err.println("No Valid Policy Found.Default qry:");
												pstmt1.setString(1,facility_id);
												pstmt1.setString(2,rtn_blng_grp);
												pstmt1.setString(3,patient_class);
												pstmt1.setString(4,locale);
												pstmt1.setString(5,calling_module_id);
												pstmt1.setString(6,calling_module_id);
												pstmt1.setString(7,calling_module_id);
												pstmt1.setString(8,calling_module_id);
												pstmt1.setString(9,calling_module_id);
												rs1 = pstmt1.executeQuery() ;				
												System.err.println("BLFinDetHiddenFlds.jsp 1385");
											}
											else
											{
												System.err.println("BLFinDetHiddenFlds.jsp 1339");
												rs1.beforeFirst();
											}
										}

										if(rs1!=null)
										{
											while( rs1.next() )
											{  
												System.err.println("Inside Ins Query 1348");
												temp_ins_cust_group_code=rs1.getString("cust_group_code");
												if(temp_ins_cust_group_code==null || temp_ins_cust_group_code.equals("")) temp_ins_cust_group_code=" ";
												rtn_ins_cust_group_code=rtn_ins_cust_group_code+temp_ins_cust_group_code+"|";
												if(rtn_ins_cust_group_code==null) rtn_ins_cust_group_code="";
												
												temp_ins_cust_code=rs1.getString("cust_code");
												if(temp_ins_cust_code==null || temp_ins_cust_code.equals("")) temp_ins_cust_code=" ";
												rtn_ins_cust_code=rtn_ins_cust_code+temp_ins_cust_code+"|";
												if(rtn_ins_cust_code==null) rtn_ins_cust_code="";

												temp_ins_cust_priority=rs1.getString("priority");
												rtn_ins_cust_priority=rtn_ins_cust_priority+temp_ins_cust_priority+"|";
												if(rtn_ins_cust_priority==null) rtn_ins_cust_priority="";
											
												temp_ins_policy_type_code=rs1.getString("policy_type_code");
												rtn_ins_policy_type_code=rtn_ins_policy_type_code+temp_ins_policy_type_code+"|";
												if(rtn_ins_policy_type_code==null) rtn_ins_policy_type_code="";
												System.err.println("temp_ins_policy_type_code:"+temp_ins_policy_type_code);
												
												/* Added V190814-Aravindh/AMS-SCF-0808/Starts */
												try {
													tmpCreditAuthorisationBy = rs1.getString("credit_auth_by");
												} catch(SQLException se) {
													tmpCreditAuthorisationBy = "";
													se.printStackTrace();
													System.err.println("BLFinDetHiddenFlds.jsp 1424");
												}
												if(tmpCreditAuthorisationBy == null) tmpCreditAuthorisationBy = "";
												rtnCreditAuthorisationBy += tmpCreditAuthorisationBy + "|";
												if(rtnCreditAuthorisationBy == null) rtnCreditAuthorisationBy = "";
												
												try {
													tmpClaimCode = rs1.getString("claim_code");
												} catch(SQLException se) {
													se.printStackTrace();
													tmpClaimCode = "";
													System.err.println("BLFinDetHiddenFlds.jsp 1436");
												}
												if(tmpClaimCode == null) tmpClaimCode = "";
												rtnClaimCode += tmpClaimCode + "|";
												if(rtnClaimCode == null) rtnClaimCode = "";
												
												try {
													tmpMembershipNumber = rs1.getString("membership_no");
												} catch(SQLException se) {
													se.printStackTrace();
													tmpMembershipNumber = "";
													System.err.println("BLFinDetHiddenFlds.jsp 1446");
												}
												if(tmpMembershipNumber == null) tmpMembershipNumber = "";
												rtnMembershipNumber += tmpMembershipNumber + "|";
												if(rtnMembershipNumber == null) rtnMembershipNumber = "";
												/* Added V190814-Aravindh/AMS-SCF-0808/Ends */
												
												/* Added By Vijay For MMS-QF-SCF-0567*/
												
												if(siteSpec)
												{
													try
													{
														//String polHdrEffToSql="select to_char(POLICY_EFF_TO,'dd/mm/yyyy') effective_to  from BL_INS_POLICY_TYPE_HDR where operating_facility_id = ? and cust_group_code = ? and cust_code = ? and policy_type_code = ? "; //Commented V210629 
														String polHdrEffToSql="select to_char(POLICY_EFF_TO,'dd/mm/yyyy') effective_to  from BL_INS_POLICY_TYPE_HDR where operating_facility_id = ? and cust_group_code = ? and (cust_code = ? or cust_code = '**') and policy_type_code = ?  and rownum=1 order by cust_code desc ";//V210629
												
														System.err.println("addedFacilityId / temp_ins_cust_group_code / temp_ins_cust_code "+addedFacilityId +"/ " +temp_ins_cust_group_code + "/ "+temp_ins_cust_code);
														pstmt2=con.prepareStatement(polHdrEffToSql);
														pstmt2.setString(1,addedFacilityId);
														pstmt2.setString(2,temp_ins_cust_group_code);
														pstmt2.setString(3,temp_ins_cust_code);
														pstmt2.setString(4,temp_ins_policy_type_code);
														rs2=pstmt2.executeQuery();
														if(rs2!=null)
														{
															while(rs2.next())
															{
																POLICY_EFF_T0_TMP=rs2.getString("effective_to");
																System.err.println("POLICY_EFF_TO_Tmp "+POLICY_EFF_T0_TMP);
																rtn_ins_pol_eff_to_tmp=rtn_ins_pol_eff_to_tmp+POLICY_EFF_T0_TMP+"|";	
															
															}
														}
															
														if(rs2 != null) rs2.close();
														pstmt2.close();

													}
													catch(Exception e)
													{
														
														System.err.println("Exception in 1485 "+e);
														e.printStackTrace();
													}
												}
												
												if(!temp_ins_cust_code.equals("") && !temp_ins_policy_type_code.equals(""))
												{
													try
													{
														String restrict_check_sql="SELECT DECODE(?,'O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U'), DECODE(?,'O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE(?,'O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,  'U'),'U'),decode(?,'O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode(?,'O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N'),decode(?,'O',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'I',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'R',NVL(a.EX_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = ? AND a.POLICY_TYPE_CODE = ? AND a.CUST_CODE = ? and b.cust_group_code = a.cust_group_code and a.cust_code = b.cust_code and a.cust_group_code=? ";
														String empty_sql_check="N";
														System.err.println(" BLFinDetHiddenFlds.jsp restrict_check_sql:"+restrict_check_sql);
														pstmt2 = con.prepareStatement(restrict_check_sql);
														pstmt2.setString(1, episode_type);
														pstmt2.setString(2, episode_type);
														pstmt2.setString(3, episode_type);
														pstmt2.setString(4, episode_type);
														pstmt2.setString(5, episode_type);
														pstmt2.setString(6, episode_type);
														pstmt2.setString(7, facility_id);
														pstmt2.setString(8, temp_ins_policy_type_code);
														pstmt2.setString(9, temp_ins_cust_code);
														pstmt2.setString(10, temp_ins_cust_group_code);
														rs2 = pstmt2.executeQuery() ;
														System.err.println("BLFinDetHiddenFlds.jsp 1500");
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
																cred_auth_mand_capt_yn = rs2.getString(6); 
																empty_sql_check="N";

															}
														}
														
														if(rs2 != null) rs2.close();
														pstmt2.close();

														if(empty_sql_check.equals("Y"))
														{
															restrict_check_sql="SELECT DECODE(?,'O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U'), DECODE(?,'O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE(?,'O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,  'U'),'U'),decode(?,'O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode(?,'O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N'),decode(?,'O',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'I',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'R',NVL(a.EX_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a WHERE a.OPERATING_FACILITY_ID = ? AND a.POLICY_TYPE_CODE = ? AND a.CUST_CODE = '**' and a.cust_group_code= ?";
														System.err.println("BLFinDetHiddenFlds.jsp no data found restrict_check_sql1:"+restrict_check_sql);
															pstmt2 = con.prepareStatement(restrict_check_sql);
															pstmt2.setString(1, episode_type);
															pstmt2.setString(2, episode_type);
															pstmt2.setString(3, episode_type);
															pstmt2.setString(4, episode_type);
															pstmt2.setString(5, episode_type);
															pstmt2.setString(6, episode_type);
															pstmt2.setString(7, facility_id);
															pstmt2.setString(8, temp_ins_policy_type_code);
															pstmt2.setString(9, temp_ins_cust_group_code);
															rs2 = pstmt2.executeQuery() ;
															System.err.println("BLFinDetHiddenFlds.jsp 1525");
															if( rs2 != null ) 
															{
																while( rs2.next() )
																{  
																	restrict_check=rs2.getString(1);
																	apprd_amt_restrict_check = rs2.getString(2); 
																	apprd_days_restrict_check = rs2.getString(3); 
																	cred_auth_req_yn = rs2.getString(4); 
																	dflt_auth_ref_as_pol_no_yn = rs2.getString(5); 
																	cred_auth_mand_capt_yn = rs2.getString(6); 
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
													System.err.println("restrict_check b4:"+restrict_check);
													if(restrict_check == null || restrict_check.equals("")) restrict_check="U";

													if(apprd_amt_restrict_check == null || apprd_amt_restrict_check.equals("")) apprd_amt_restrict_check="U";

													if(apprd_days_restrict_check == null || apprd_days_restrict_check.equals("")) apprd_days_restrict_check="U";

													if(cred_auth_req_yn == null || cred_auth_req_yn.equals("")) cred_auth_req_yn="N";

													if(cred_auth_mand_capt_yn == null || cred_auth_mand_capt_yn.equals("")) cred_auth_mand_capt_yn="N";

													if(dflt_auth_ref_as_pol_no_yn == null || dflt_auth_ref_as_pol_no_yn.equals("")) dflt_auth_ref_as_pol_no_yn="N";

													System.err.println("restrict_check aft:"+restrict_check);
													rtn_ins_restrict_check=rtn_ins_restrict_check+restrict_check+"|";
													rtn_ins_apprd_amt_restrict_check=rtn_ins_apprd_amt_restrict_check+apprd_amt_restrict_check+"|";
													rtn_ins_apprd_days_restrict_check=rtn_ins_apprd_days_restrict_check+apprd_days_restrict_check+"|";

													rtn_ins_cred_auth_req_yn = rtn_ins_cred_auth_req_yn+cred_auth_req_yn+"|";
													rtn_ins_cred_auth_mand_capt_yn = rtn_ins_cred_auth_mand_capt_yn+cred_auth_mand_capt_yn+"|";
													rtn_ins_dflt_auth_ref_as_pol_no_yn = rtn_ins_dflt_auth_ref_as_pol_no_yn+dflt_auth_ref_as_pol_no_yn+"|";
													System.err.println("in hidden flds:cred_auth_mand_capt_yn:"+rtn_ins_cred_auth_mand_capt_yn);
												}
												else
												{	
													rtn_ins_restrict_check=rtn_ins_restrict_check+"U"+"|";
													rtn_ins_apprd_amt_restrict_check=rtn_ins_apprd_amt_restrict_check+"U"+"|";
													rtn_ins_apprd_days_restrict_check=rtn_ins_apprd_days_restrict_check+"U"+"|";
													rtn_ins_cred_auth_req_yn = rtn_ins_cred_auth_req_yn+"N"+"|";
													rtn_ins_cred_auth_mand_capt_yn = rtn_ins_cred_auth_mand_capt_yn+"N"+"|";
													
													rtn_ins_dflt_auth_ref_as_pol_no_yn = rtn_ins_dflt_auth_ref_as_pol_no_yn+"N"+"|";
												}

												if(inside_loop_chk.equals("N"))
												{
													System.err.println("Inside IFFFFF 1584");
													temp_ins_policy_no=rs1.getString("policy_number");
													if(temp_ins_policy_no == null) temp_ins_policy_no = " ";
													rtn_ins_policy_no=rtn_ins_policy_no+temp_ins_policy_no+"|";
													if(rtn_ins_policy_no==null) rtn_ins_policy_no="";
											
													temp_ins_policy_start_date=rs1.getString("policy_start_date");
													if(temp_ins_policy_start_date == null) temp_ins_policy_start_date = " ";
													rtn_ins_policy_start_date=rtn_ins_policy_start_date+temp_ins_policy_start_date+"|";
													if(rtn_ins_policy_start_date==null) rtn_ins_policy_start_date="";
											
													temp_ins_policy_expiry_date=rs1.getString("policy_expiry_date");
													if(temp_ins_policy_expiry_date == null) temp_ins_policy_expiry_date = " ";		
													rtn_ins_policy_expiry_date=rtn_ins_policy_expiry_date+temp_ins_policy_expiry_date+"|";
													if(rtn_ins_policy_expiry_date==null) rtn_ins_policy_expiry_date="";
											
													temp_ins_credit_auth_ref=rs1.getString("credit_auth_ref");
													if(temp_ins_credit_auth_ref == null || temp_ins_credit_auth_ref.equals("")) temp_ins_credit_auth_ref=" ";
													rtn_ins_credit_auth_ref=rtn_ins_credit_auth_ref+temp_ins_credit_auth_ref+"|";
													if(rtn_ins_credit_auth_ref==null) rtn_ins_credit_auth_ref="";
											
													temp_ins_credit_auth_date=rs1.getString("credit_auth_date");
													if(temp_ins_credit_auth_date == null || temp_ins_credit_auth_date.equals("")) temp_ins_credit_auth_date= " ";
													rtn_ins_credit_auth_date=rtn_ins_credit_auth_date+temp_ins_credit_auth_date+"|";
													if(rtn_ins_credit_auth_date==null) rtn_ins_credit_auth_date="";
												
													temp_ins_credit_approval_days=rs1.getString("approved_days");
													if(temp_ins_credit_approval_days==null || temp_ins_credit_approval_days.equals("")) 	temp_ins_credit_approval_days=" ";

													System.err.println("restrict_check:"+restrict_check);
													
													if(restrict_check.equals("R"))
													{
														if(apprd_days_restrict_check.equals("U"))
														{
															rtn_ins_credit_approval_days=rtn_ins_credit_approval_days+" "+"|";
														}
														else
														{
															rtn_ins_credit_approval_days=rtn_ins_credit_approval_days+temp_ins_credit_approval_days+"|";
														}
													}
													else if(restrict_check.equals("U"))
													{
														rtn_ins_credit_approval_days=rtn_ins_credit_approval_days+" "+"|";
													}

													System.err.println("in hidden rtn_ins_credit_approval_days:"+rtn_ins_credit_approval_days);

													if(rtn_ins_credit_approval_days==null) rtn_ins_credit_approval_days="";
											
													temp_ins_credit_approval_amount=rs1.getString("approved_amt");
													if(temp_ins_credit_approval_amount==null || temp_ins_credit_approval_amount.equals("")) temp_ins_credit_approval_amount=" ";

													if(restrict_check.equals("R"))
													{
														if(apprd_amt_restrict_check.equals("U"))
														{
															rtn_ins_credit_approval_amount=rtn_ins_credit_approval_amount+" "+"|";
														}
														else
														{
															rtn_ins_credit_approval_amount=rtn_ins_credit_approval_amount+temp_ins_credit_approval_amount+"|";
														}
													}
													else if(restrict_check.equals("U"))
													{
														rtn_ins_credit_approval_amount=rtn_ins_credit_approval_amount+" "+"|";
													}
													System.err.println("in hidden rtn_ins_credit_approval_amount:"+rtn_ins_credit_approval_amount);
													
													if(rtn_ins_credit_approval_amount==null) rtn_ins_credit_approval_amount="";
											
													temp_ins_policy_eff_from_date=rs1.getString("effective_from");
													if(temp_ins_policy_eff_from_date == null) temp_ins_policy_eff_from_date = " ";			
													rtn_ins_policy_eff_from_date=rtn_ins_policy_eff_from_date+temp_ins_policy_eff_from_date+"|";
													if(rtn_ins_policy_eff_from_date==null) rtn_ins_policy_eff_from_date="";
											
													System.err.println("rtn_ins_policy_eff_from_date vijay 18 "+rtn_ins_policy_eff_from_date);
													
													temp_ins_policy_eff_to_date=rs1.getString("effective_to");
													if(temp_ins_policy_eff_to_date == null) temp_ins_policy_eff_to_date = " ";		
													if(temp_ins_policy_eff_to_date==null || temp_ins_policy_eff_to_date.equals("")) temp_ins_policy_eff_to_date=" ";
													rtn_ins_policy_eff_to_date=rtn_ins_policy_eff_to_date+temp_ins_policy_eff_to_date+"|";
													if(rtn_ins_policy_eff_to_date==null) rtn_ins_policy_eff_to_date="";

													temp_ins_ref_src_main_code = rs1.getString("ref_src_main_code");
													if(temp_ins_ref_src_main_code==null || temp_ins_ref_src_main_code.equals("")) temp_ins_ref_src_main_code="";
													System.err.println("temp_ins_ref_src_main_code  BLFinDetHiddenFlds:"+temp_ins_ref_src_main_code);

													if(!temp_ins_ref_src_main_code.equals(""))
													{
														call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
														call.registerOutParameter(1,java.sql.Types.VARCHAR);

														call.setString(2,temp_ins_ref_src_main_code);
														call.setString(3,locale);
														call.setString(4,"1");

														call.execute();		
														System.err.println("BLFinDetHiddenFlds.jsp 1681");
														temp_ins_ref_src_main_desc = call.getString(1);				
														call.close();
														if ( temp_ins_ref_src_main_desc == null || temp_ins_ref_src_main_desc.equals("")) temp_ins_ref_src_main_desc = " ";
													}
													else
													{
														temp_ins_ref_src_main_code=" ";
														temp_ins_ref_src_main_desc=" ";
													}

													rtn_ins_ref_src_main_code=rtn_ins_ref_src_main_code+temp_ins_ref_src_main_code+"|";
													if(rtn_ins_ref_src_main_code==null) rtn_ins_ref_src_main_code="";

													rtn_ins_ref_src_main_desc=rtn_ins_ref_src_main_desc+temp_ins_ref_src_main_desc+"|";
													if(rtn_ins_ref_src_main_desc==null) rtn_ins_ref_src_main_desc="";

													temp_ins_ref_src_sub_code = rs1.getString("ref_src_sub_code");
													if(temp_ins_ref_src_sub_code==null || temp_ins_ref_src_sub_code.equals("")) temp_ins_ref_src_sub_code="";

													if(!temp_ins_ref_src_sub_code.equals(""))
													{
															System.err.println("########  BLFinDetHiddenFlds.jsp   22 "+con.isClosed());
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
													if ( temp_ins_ref_src_sub_desc == null || temp_ins_ref_src_sub_desc.equals("")) temp_ins_ref_src_sub_desc = " ";

													rtn_ins_ref_src_sub_code=rtn_ins_ref_src_sub_code+temp_ins_ref_src_sub_code+"|";
													if(rtn_ins_ref_src_sub_code==null) rtn_ins_ref_src_sub_code="";

													rtn_ins_ref_src_sub_desc=rtn_ins_ref_src_sub_desc+temp_ins_ref_src_sub_desc+"|";
													if(rtn_ins_ref_src_sub_desc==null) rtn_ins_ref_src_sub_desc="";

													
												}
												else
												{
													System.err.println("Inside ELSEEEEE");
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
												}
												
												temp_ins_adj_rule_ind=rs1.getString("adj_rule_ind");
												if(temp_ins_adj_rule_ind==null) temp_ins_adj_rule_ind=" ";
												rtn_ins_adj_rule_ind=rtn_ins_adj_rule_ind+temp_ins_adj_rule_ind+"|";
												if(rtn_ins_adj_rule_ind==null) rtn_ins_adj_rule_ind="";
												
												temp_ins_adj_perc_amt_ind=rs1.getString("adj_perc_amt_ind");
												if(temp_ins_adj_perc_amt_ind==null) temp_ins_adj_perc_amt_ind=" ";
												rtn_ins_adj_perc_amt_ind=rtn_ins_adj_perc_amt_ind+temp_ins_adj_perc_amt_ind+"|";
												if(rtn_ins_adj_perc_amt_ind==null) rtn_ins_adj_perc_amt_ind="";
												
												temp_ins_adj_perc_amt_value=rs1.getString("adj_perc_amt_value");
												if(temp_ins_adj_perc_amt_value==null) temp_ins_adj_perc_amt_value=" ";

												rtn_ins_adj_perc_amt_value=rtn_ins_adj_perc_amt_value+temp_ins_adj_perc_amt_value+"|";
												if(rtn_ins_adj_perc_amt_value==null) rtn_ins_adj_perc_amt_value="";
												
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

												temp_ins_blng_grp=rs1.getString("blng_grp_id");
												if(temp_ins_blng_grp==null) temp_ins_blng_grp=" ";
												if(temp_ins_cust_priority.equals("1"))
												{
													rtn_blng_grp=temp_ins_blng_grp;
													System.err.println("rtn_blng_grp:"+rtn_blng_grp);
												}

												rtn_ins_blng_grp=rtn_ins_blng_grp+temp_ins_blng_grp+"|";
												System.err.println("rtn_ins_blng_grp:"+rtn_ins_blng_grp);
											}
										}
									}
									catch(Exception e)
									{
										System.err.println("Exception while fetching financial values:"+e);
									}
									if(rs1 != null) rs1.close();
									pstmt1.close();

									rtn_non_ins_blng_grp = non_ins_blng_grp_id;
									if(rtn_non_ins_blng_grp==null) rtn_non_ins_blng_grp="";

									rtn_non_ins_cust_group_code = non_ins_cust_group_code;
									if(rtn_non_ins_cust_group_code==null) rtn_non_ins_cust_group_code="";

									rtn_non_ins_cust_code = non_ins_cust_code;
									if(rtn_non_ins_cust_code==null) rtn_non_ins_cust_code="";

									String sql_non_ins="select settlement_ind from bl_blng_grp where blng_grp_id =?";
									try
									{
										System.err.println("########  BLFinDetHiddenFlds.jsp   23 "+con.isClosed());
										pstmt2 = con.prepareStatement(sql_non_ins);
										pstmt2.setString(1, non_ins_blng_grp_id);
										rs2 = pstmt2.executeQuery() ;
										System.err.println("BLFinDetHiddenFlds.jsp 1864");
										if( rs2 != null ) 
										{
											while( rs2.next() )
											{  
												System.err.println("Inside Non Ins Query");
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
										System.err.println("Inside Non Ins");
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
							}
						}
					}
					catch(Exception e)
					{
						System.err.println("Exception in Main Query Execution:"+e);
						out.println("Exception in Main Query Execution from BLFinDetHiddenFlds.jsp:"+e);
					}
					if(rs != null) rs.close();
					pstmt.close();
				}	
			}
			else if(selected_from_prev_enc_YN.equals("Y"))
			{
				System.err.println("BLFinDetHiddenFlds.jsp 1854");
				episode_id=request.getParameter("episode_id");
				if(episode_id==null) episode_id="";

				visit_id=request.getParameter("visit_id");
				if(visit_id==null) visit_id="";

				if(episode_type.equals("R"))
				{
					System.err.println("BLFinDetHiddenFlds.jsp 1863");
					System.err.println("########  BLFinDetHiddenFlds.jsp   24 "+con.isClosed());
					pstmt = con.prepareStatement("select blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc,slmt_doc_ref_date,slmt_doc_remarks,cust_group_code,cust_code,credit_doc_ref_desc,credit_doc_ref_start_date,credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,financial_remarks,gl_holder_name,pat_reln_with_gl_holder,REFERRAL_SOURCE_CODE_MAIN,REFERRAL_SOURCE_CODE_SUB,NON_INS_REF_SOURCE_CODE_MAIN,NON_INS_REF_SOURCE_CODE_SUB,null NO_OF_ENC_GL_VALID,null NO_OF_OP_ENC_GL_VALID,null NO_OF_AE_ENC_GL_VALID,null NO_OF_IP_ENC_GL_VALID,null NO_OF_DC_ENC_GL_VALID from(select b.blng_grp_id,b.settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc ,to_char(slmt_doc_ref_date,'dd/mm/yyyy') slmt_doc_ref_date,slmt_doc_remarks,b.cust_group_code,b.cust_code,credit_doc_ref_desc,to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date,to_char(credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,financial_remarks,gl_holder_name,pat_reln_with_gl_holder,blcommon.BL_VALID_REF_SOURCE_CODE(b.REFERRAL_SOURCE_CODE_MAIN,?) REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(b.REFERRAL_SOURCE_CODE_SUB,?) REFERRAL_SOURCE_CODE_SUB,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_MAIN,?) NON_INS_REF_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(NON_INS_REF_SOURCE_CODE_SUB,?) NON_INS_REF_SOURCE_CODE_SUB,null NO_OF_ENC_GL_VALID,null NO_OF_OP_ENC_GL_VALID,null NO_OF_AE_ENC_GL_VALID,null NO_OF_IP_ENC_GL_VALID,null NO_OF_DC_ENC_GL_VALID from bl_patient_fin_dtls a, BL_ENCOUNTER_PAYER_PRIORITY b where a.patient_id =? and a.patient_id = b.patient_id and b.episode_type='R' and  b.ACCT_SEQ_NO=a.CUR_ACCT_SEQ_NO and (a.non_ins_blng_grp_id is null or (a.non_ins_blng_grp_id is not null and b.PRIORITY is not null)) and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and b.blng_grp_id=c.blng_grp_id) order by B.PRIORITY) where rownum=1");
					pstmt.setString(1,episode_type);
					pstmt.setString(2,episode_type);
					pstmt.setString(3,episode_type);
					pstmt.setString(4,episode_type);
					pstmt.setString(5,patient_id);
					pstmt.setString(6,calling_module_id);
					pstmt.setString(7,calling_module_id);
					pstmt.setString(8,calling_module_id);
					pstmt.setString(9,calling_module_id);
					pstmt.setString(10,calling_module_id);
					rs = pstmt.executeQuery() ;
					System.err.println("BLFinDetHiddenFlds.jsp 1957");
				}
				else if(episode_type.equals("O") || episode_type.equals("E"))
				{
					System.err.println("BLFinDetHiddenFlds.jsp 1881");
					
					System.err.println("########  BLFinDetHiddenFlds.jsp   25 "+con.isClosed());
					pstmt = con.prepareStatement("select blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc,slmt_doc_ref_date,slmt_doc_remarks,cust_group_code,cust_code cust_code,credit_doc_ref_desc,credit_doc_ref_start_date,credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,gl_holder_name,pat_reln_with_gl_holder, REFERRAL_SOURCE_CODE_MAIN,REFERRAL_SOURCE_CODE_SUB,NON_INS_REF_SOURCE_CODE_MAIN,NON_INS_REF_SOURCE_CODE_SUB,NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID from(select c.blng_grp_id blng_grp_id,c.settlement_ind settlement_ind,b.blng_class_code blng_class_code,a.employer_code employer_code,b.slmt_type_code slmt_type_code,b.slmt_doc_ref_desc slmt_doc_ref_desc, to_char(b.slmt_doc_ref_date,'dd/mm/yyyy') slmt_doc_ref_date,b.slmt_doc_remarks slmt_doc_remarks,c.cust_group_code cust_group_code,c.cust_code cust_code,b.credit_doc_ref_desc credit_doc_ref_desc,to_char(b.credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date,to_char(b.credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date,b.non_ins_blng_grp_id non_ins_blng_grp_id,b.non_ins_cust_group_code non_ins_cust_group_code,b.non_ins_cust_code non_ins_cust_code,a.annual_family_income annual_family_income,a.family_assets_value family_assets_value,b.num_of_dependents num_of_dependents,b.resp_for_bill_payment resp_for_bill_payment,b.pat_reln_with_resp_pers pat_reln_with_resp_pers,b.remark remarks,b.gl_holder_name gl_holder_name,b.pat_reln_with_gl_holder pat_reln_with_gl_holder,blcommon.BL_VALID_REF_SOURCE_CODE(c.REFERRAL_SOURCE_CODE_MAIN ,?) REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(c.REFERRAL_SOURCE_CODE_SUB,?) REFERRAL_SOURCE_CODE_SUB,blcommon.BL_VALID_REF_SOURCE_CODE(b.NON_INS_REF_SOURCE_CODE_MAIN,?) NON_INS_REF_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(b.NON_INS_REF_SOURCE_CODE_SUB,?) NON_INS_REF_SOURCE_CODE_SUB,NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID from bl_patient_fin_dtls a, bl_visit_fin_dtls b,BL_ENCOUNTER_PAYER_PRIORITY c where a.patient_id = b.patient_id and b.patient_id = c.patient_id and b.operating_facility_id = ? and b.operating_facility_id=c.operating_facility_id and a.patient_id =? and b.episode_type=? and b.episode_type=c.episode_type AND b.episode_id=? AND b.episode_id=c.episode_id and b.visit_id=? and b.visit_id=c.visit_id and  b.CUR_ACCT_SEQ_NO=c.ACCT_SEQ_NO and (b.non_ins_blng_grp_id is null or (b.non_ins_blng_grp_id is not null and c.PRIORITY is not null)) and exists (Select 'X' from bl_blng_grp d where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and c.blng_grp_id=d.blng_grp_id) order by c.PRIORITY) WHERE rownum=1");
					pstmt.setString(1,episode_type);
					pstmt.setString(2,episode_type);
					pstmt.setString(3,episode_type);
					pstmt.setString(4,episode_type);
					pstmt.setString(5,facility_id);
					pstmt.setString(6,patient_id);
					pstmt.setString(7,episode_type);
					pstmt.setString(8,episode_id);
					pstmt.setString(9,visit_id);
					pstmt.setString(10,calling_module_id);
					pstmt.setString(11,calling_module_id);
					pstmt.setString(12,calling_module_id);
					pstmt.setString(13,calling_module_id);
					pstmt.setString(14,calling_module_id);
					rs = pstmt.executeQuery() ;
					System.err.println("BLFinDetHiddenFlds.jsp 1980");
				}
				else if(episode_type.equals("I") || episode_type.equals("D"))
				{
					System.err.println("BLFinDetHiddenFlds.jsp 1904");
					
					System.err.println("########  BLFinDetHiddenFlds.jsp   26 "+con.isClosed());
					pstmt = con.prepareStatement("select blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc,slmt_doc_ref_date,slmt_doc_remarks,cust_group_code,cust_code,credit_doc_ref_desc,credit_doc_ref_start_date,credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_group_code,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,gl_holder_name,pat_reln_with_gl_holder,REFERRAL_SOURCE_CODE_MAIN,REFERRAL_SOURCE_CODE_SUB,NON_INS_REF_SOURCE_CODE_MAIN,NON_INS_REF_SOURCE_CODE_SUB,NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID from(select c.blng_grp_id blng_grp_id,c.settlement_ind settlement_ind,null blng_class_code,a.employer_code employer_code,b.slmt_type_code slmt_type_code,b.slmt_doc_ref_desc slmt_doc_ref_desc, to_char(b.slmt_doc_ref_date,'dd/mm/yyyy')  slmt_doc_ref_date,b.slmt_doc_remarks slmt_doc_remarks,c.cust_group_code cust_group_code,c.cust_code cust_code,b.credit_doc_ref_desc credit_doc_ref_desc,to_char(b.credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date,to_char(b.credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date,b.non_ins_blng_grp_id non_ins_blng_grp_id,b.non_ins_cust_group_code non_ins_cust_group_code,b.non_ins_cust_code non_ins_cust_code,a.annual_family_income annual_family_income,a.family_assets_value family_assets_value,b.num_of_dependents num_of_dependents,b.resp_for_bill_payment resp_for_bill_payment,b.pat_reln_with_resp_pers pat_reln_with_resp_pers,b.remark remarks,b.gl_holder_name gl_holder_name,b.pat_reln_with_gl_holder pat_reln_with_gl_holder,blcommon.BL_VALID_REF_SOURCE_CODE(c.REFERRAL_SOURCE_CODE_MAIN ,?) REFERRAL_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(c.REFERRAL_SOURCE_CODE_SUB,?) REFERRAL_SOURCE_CODE_SUB,blcommon.BL_VALID_REF_SOURCE_CODE(b.NON_INS_REF_SOURCE_CODE_MAIN,?) NON_INS_REF_SOURCE_CODE_MAIN,blcommon.BL_VALID_REF_SOURCE_CODE(b.NON_INS_REF_SOURCE_CODE_SUB,?) NON_INS_REF_SOURCE_CODE_SUB,NO_OF_ENC_GL_VALID,NO_OF_OP_ENC_GL_VALID,NO_OF_AE_ENC_GL_VALID,NO_OF_IP_ENC_GL_VALID,NO_OF_DC_ENC_GL_VALID from bl_patient_fin_dtls a, bl_episode_fin_dtls b,BL_ENCOUNTER_PAYER_PRIORITY c where a.patient_id = b.patient_id and b.patient_id = c.patient_id and b.operating_facility_id = ? and b.operating_facility_id=c.operating_facility_id and a.patient_id =? and b.episode_type=? and b.episode_type=c.episode_type AND b.episode_id=? AND b.episode_id=c.episode_id and  b.CUR_ACCT_SEQ_NO=c.ACCT_SEQ_NO and (b.non_ins_blng_grp_id is null or (b.non_ins_blng_grp_id is not null and c.PRIORITY is not null)) and exists (Select 'X' from bl_blng_grp d where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and c.blng_grp_id=d.blng_grp_id) order by c.PRIORITY) WHERE rownum=1");
					pstmt.setString(1,episode_type);
					pstmt.setString(2,episode_type);
					pstmt.setString(3,episode_type);
					pstmt.setString(4,episode_type);
					pstmt.setString(5,facility_id);
					pstmt.setString(6,patient_id);
					pstmt.setString(7,episode_type);
					pstmt.setString(8,episode_id);
					pstmt.setString(9,calling_module_id);
					pstmt.setString(10,calling_module_id);
					pstmt.setString(11,calling_module_id);
					pstmt.setString(12,calling_module_id);
					pstmt.setString(13,calling_module_id);
					rs = pstmt.executeQuery() ;
					System.err.println("BLFinDetHiddenFlds.jsp 2003");
				}

				if(rs!=null)
				{
					while( rs.next() )
					{  
						System.err.println("BLFinDetHiddenFlds.jsp 1929");
						System.err.println("Inside the general query in selc from prev enc");
						operation="Update";
						billing_mode="Modify";
						rtn_blng_grp= rs.getString("blng_grp_id");
						if(rtn_blng_grp==null) rtn_blng_grp="";

						rtn_slmt_ind= rs.getString("settlement_ind");
						if(rtn_slmt_ind==null) rtn_slmt_ind="";
						if(last_visit_dtls.equals("N"))
						{
							rtn_annual_family_income= rs.getString("annual_family_income");

							if(rtn_annual_family_income==null) rtn_annual_family_income="";
							rtn_family_assets_value = rs.getString("family_assets_value");

							if(rtn_family_assets_value==null) rtn_family_assets_value="";
						}

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
						System.err.println("rtn_gl_holder_name 2.0  "+rtn_gl_holder_name);
						//rtn_gl_holder_name=rtn_gl_holder_name.replaceAll("'","''");	
						System.err.println("rtn_gl_holder_name 2.1 "+rtn_gl_holder_name);
									
						rtn_pat_reln_with_gl_holder= rs.getString("pat_reln_with_gl_holder");
						if(rtn_pat_reln_with_gl_holder==null) rtn_pat_reln_with_gl_holder="";

						rtn_ref_src_main_code=rs.getString("REFERRAL_SOURCE_CODE_MAIN");
						if(rtn_ref_src_main_code==null) rtn_ref_src_main_code="";

						if(!rtn_ref_src_main_code.equals(""))
						{
							System.err.println("########  BLFinDetHiddenFlds.jsp   27 "+con.isClosed());
							call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
							call.registerOutParameter(1,java.sql.Types.VARCHAR);

							call.setString(2,rtn_ref_src_main_code);
							call.setString(3,locale);
							call.setString(4,"1");

							call.execute();			
							System.err.println("BLFinDetHiddenFlds.jsp 2067");
							rtn_ref_src_main_desc = call.getString(1);				
							call.close();
							if ( rtn_ref_src_main_desc == null ) rtn_ref_src_main_desc = "";
						}

						rtn_ref_src_sub_code=rs.getString("REFERRAL_SOURCE_CODE_SUB");
						if(rtn_ref_src_sub_code==null) rtn_ref_src_sub_code="";

						if(!rtn_ref_src_sub_code.equals(""))
						{
							System.err.println("########  BLFinDetHiddenFlds.jsp   28 "+con.isClosed());
							call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
							call.registerOutParameter(1,java.sql.Types.VARCHAR);

							call.setString(2,rtn_ref_src_sub_code);
							call.setString(3,locale);
							call.setString(4,"1");

							call.execute();						
							System.err.println("BLFinDetHiddenFlds.jsp 2090");
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
							System.err.println("BLFinDetHiddenFlds.jsp 2112");
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
							System.err.println("BLFinDetHiddenFlds.jsp 2133");
							rtn_non_ins_ref_src_sub_desc = call.getString(1);				
							call.close();
							if ( rtn_non_ins_ref_src_sub_desc == null ) rtn_non_ins_ref_src_sub_desc = "";
						}

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

						cust_group_code=rs.getString("cust_group_code");
						if(cust_group_code==null) cust_group_code="";

						cust_code=rs.getString("cust_code");
						if(cust_code==null) cust_code="";

						credit_doc_ref_desc= rs.getString("credit_doc_ref_desc");
						if(credit_doc_ref_desc==null) credit_doc_ref_desc="";
		
						credit_doc_ref_start_date= rs.getString("credit_doc_ref_start_date");						
						if(credit_doc_ref_start_date==null) credit_doc_ref_start_date="";

						credit_doc_ref_date= rs.getString("credit_doc_ref_date");
						if(credit_doc_ref_date==null) credit_doc_ref_date="";

						non_ins_blng_grp_id= rs.getString("non_ins_blng_grp_id");
						if(non_ins_blng_grp_id==null) non_ins_blng_grp_id="";

						non_ins_cust_group_code= rs.getString("non_ins_cust_group_code");
						if(non_ins_cust_group_code==null) non_ins_cust_group_code="";

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
						
						if (rtn_slmt_ind.equals("C"))
						{
							System.err.println("Inside Cash 2109");
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
						else if (rtn_slmt_ind.equals("R"))
						{
							column_count = 1;
							System.err.println("Inside Credit 2130");
							rtn_credit_doc_reqd_yn = "Y";
							rtn_credit_cust_group_code = cust_group_code;
							rtn_credit_cust_code = cust_code;
							if(rtn_credit_cust_code==null) rtn_credit_cust_code="";
							
							String qry_gl_chk = "SELECT CREDIT_DOC_REF_DESC,NO_OF_OP_ENC_GL_AVAILED,NO_OF_AE_ENC_GL_AVAILED,NO_OF_IP_ENC_GL_AVAILED,NO_OF_DC_ENC_GL_AVAILED FROM BL_GL_HOLDER_LOOKUP_VW WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CUST_GROUP_CODE=? AND CUST_CODE=? and LANGUAGE_ID=?";

							if(!rtn_gl_holder_name.equals(""))
							{
								qry_gl_chk = qry_gl_chk + " AND GL_HOLDER_NAME=?";
							}

							System.err.println("########  BLFinDetHiddenFlds.jsp   29 "+con.isClosed());
							pstmt3 = con.prepareStatement(qry_gl_chk);
							pstmt3.setString(column_count, facility_id);
							pstmt3.setString(++column_count, patient_id);
							pstmt3.setString(++column_count, cust_group_code);
							pstmt3.setString(++column_count, cust_code);
							pstmt3.setString(++column_count, locale);
							if(!rtn_gl_holder_name.equals(""))
							{
								pstmt3.setString(++column_count, rtn_gl_holder_name);
							}
							rs3 = pstmt3.executeQuery() ;
							System.err.println("BLFinDetHiddenFlds.jsp 2151");
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
						System.err.println("rtn_slmt_ind:"+rtn_slmt_ind);
						System.err.println("non_ins_blng_grp_id:"+non_ins_blng_grp_id);

						if( rtn_slmt_ind.equals("R") || (rtn_slmt_ind.equals("C") && !(credit_doc_ref_desc.equals(""))))
						{
							System.err.println("Inside Credit 2201");
							rtn_credit_doc_ref = credit_doc_ref_desc;
							if(rtn_credit_doc_ref==null) rtn_credit_doc_ref="";
							rtn_credit_doc_start_date = credit_doc_ref_start_date;
							if(rtn_credit_doc_start_date==null) rtn_credit_doc_start_date="";
							rtn_credit_doc_end_date = credit_doc_ref_date;
							if(rtn_credit_doc_end_date==null) rtn_credit_doc_end_date="";
						}
						else if(rtn_slmt_ind.equals("X") &&  non_ins_blng_grp_id.equals(""))
						{
							column_count = 1;
							System.err.println("Inside Sponsor 2211");
							rtn_credit_doc_reqd_yn = "Y";
							rtn_sponsor_cust_group_code = cust_group_code;
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
							
							System.err.println("########  BLFinDetHiddenFlds.jsp   30 "+con.isClosed());
							pstmt3 = con.prepareStatement(qry_gl_chk);
							pstmt3.setString(column_count, facility_id);
							pstmt3.setString(++column_count, patient_id);
							pstmt3.setString(++column_count, cust_group_code);
							pstmt3.setString(++column_count, cust_code);
							pstmt3.setString(++column_count, locale);
							if(!rtn_gl_holder_name.equals(""))
							{
								pstmt3.setString(++column_count,rtn_gl_holder_name);
							}
							rs3 = pstmt3.executeQuery() ;
							System.err.println("BLFinDetHiddenFlds.jsp 2365");
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
						else if(rtn_slmt_ind.equals("X") && !(non_ins_blng_grp_id.equals("")))
						{
							System.err.println("Inside Insurance 2285");
							if(episode_type.equals("R"))
							{
								System.err.println("########  BLFinDetHiddenFlds.jsp   31 "+con.isClosed());
								pstmt1 = con.prepareStatement("SELECT a.cust_group_code cust_group_code,a.cust_code cust_code,a.priority priority,a.policy_type_code policy_type_code,a.policy_number policy_number,to_char(a.policy_start_date,'dd/mm/yyyy') policy_start_date,to_char(a.policy_expiry_date,'dd/mm/yyyy') policy_expiry_date,a.credit_auth_ref credit_auth_ref,to_char(a.credit_auth_date,'dd/mm/yyyy') credit_auth_date,to_char(a.effective_from,'dd/mm/yyyy') effective_from,to_char(a.effective_to,'dd/mm/yyyy') effective_to,a.approved_amt approved_amt,a.approved_days approved_days,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int, a.blng_grp_id blng_grp_id,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_MAIN,?) ref_src_main_code,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_SUB,?) ref_src_sub_code FROM bl_encounter_payer_priority a, bl_patient_fin_dtls b WHERE a.episode_type = 'R' AND a.patient_id =? AND a.patient_id = b.patient_id AND a.acct_seq_no = b.cur_acct_seq_no AND a.priority is not NULL and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and a.blng_grp_id=c.blng_grp_id) ORDER BY 3");
								pstmt1.setString(1,episode_type);
								pstmt1.setString(2,episode_type);
								pstmt1.setString(3,patient_id);
								pstmt1.setString(4,calling_module_id);
								pstmt1.setString(5,calling_module_id);
								pstmt1.setString(6,calling_module_id);
								pstmt1.setString(7,calling_module_id);
								pstmt1.setString(8,calling_module_id);
								rs1 = pstmt1.executeQuery() ;
								System.err.println("Inside MP level check 2435:");	
							}
							else if(episode_type.equals("O") || episode_type.equals("E"))
							{
								System.err.println("Inside OP level check:2303");

								System.err.println("########  BLFinDetHiddenFlds.jsp   32 "+con.isClosed());
								pstmt1 = con.prepareStatement("SELECT a.cust_group_code cust_group_code,a.cust_code cust_code,a.priority priority,a.policy_type_code policy_type_code,a.policy_number policy_number,to_char(a.policy_start_date,'dd/mm/yyyy') policy_start_date,to_char(a.policy_expiry_date,'dd/mm/yyyy') policy_expiry_date,a.credit_auth_ref credit_auth_ref,to_char(a.credit_auth_date,'dd/mm/yyyy') credit_auth_date,to_char(a.effective_from,'dd/mm/yyyy') effective_from,to_char(a.effective_to,'dd/mm/yyyy') effective_to,a.approved_amt approved_amt,a.approved_days approved_days,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int, a.blng_grp_id blng_grp_id,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_MAIN,?) ref_src_main_code,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_SUB,?) ref_src_sub_code FROM bl_encounter_payer_priority a, bl_visit_fin_dtls b WHERE a.operating_facility_id =? AND a.patient_id = ? AND a.episode_type = ? AND a.patient_id = b.patient_id AND a.episode_id = b.episode_id AND a.visit_id = b.visit_id AND a.acct_seq_no = b.cur_acct_seq_no AND a.operating_facility_id = b.operating_facility_id AND a.episode_type = b.episode_type AND b.episode_id=? AND b.visit_id=? AND a.priority is not NULL and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and a.blng_grp_id=c.blng_grp_id) ORDER BY 3");
								pstmt1.setString(1,episode_type);
								pstmt1.setString(2,episode_type);
								pstmt1.setString(3,facility_id);
								pstmt1.setString(4,patient_id);
								pstmt1.setString(5,episode_type);
								pstmt1.setString(6,episode_id);
								pstmt1.setString(7,visit_id);
								pstmt1.setString(8,calling_module_id);
								pstmt1.setString(9,calling_module_id);
								pstmt1.setString(10,calling_module_id);
								pstmt1.setString(11,calling_module_id);
								pstmt1.setString(12,calling_module_id);
								rs1 = pstmt1.executeQuery() ;
								System.err.println("BLFinDetHiddenFlds.jsp 2457");
							}
							else if(episode_type.equals("I") || episode_type.equals("D"))
							{
								System.err.println("Inside iP level check:2324");

								pstmt1 = con.prepareStatement("SELECT a.cust_group_code cust_group_code,a.cust_code cust_code,a.priority priority,a.policy_type_code policy_type_code,a.policy_number policy_number,to_char(a.policy_start_date,'dd/mm/yyyy') policy_start_date,to_char(a.policy_expiry_date,'dd/mm/yyyy') policy_expiry_date,a.credit_auth_ref credit_auth_ref,to_char(a.credit_auth_date,'dd/mm/yyyy') credit_auth_date,to_char(a.effective_from,'dd/mm/yyyy') effective_from,to_char(a.effective_to,'dd/mm/yyyy') effective_to,a.approved_amt approved_amt,a.approved_days approved_days,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int, a.blng_grp_id blng_grp_id,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_MAIN,?) ref_src_main_code,blcommon.BL_VALID_REF_SOURCE_CODE(a.REFERRAL_SOURCE_CODE_SUB,?) ref_src_sub_code FROM bl_encounter_payer_priority a, bl_episode_fin_dtls b WHERE a.operating_facility_id =? AND a.patient_id = ? AND a.episode_type = ? AND a.patient_id = b.patient_id AND a.episode_id = b.episode_id AND a.acct_seq_no = b.cur_acct_seq_no AND a.operating_facility_id = b.operating_facility_id AND a.episode_type = b.episode_type AND b.episode_id=? AND a.priority is not NULL and exists (Select 'X' from bl_blng_grp c where ((?='OP' AND OP_YN='Y') OR (?='AE' AND AE_YN='Y') OR (?='IP' AND IP_YN='Y') OR (?='DC' AND DY_YN='Y') OR (?='MP' AND REF_YN='Y')) and a.blng_grp_id=c.blng_grp_id) ORDER BY 3");

								pstmt1.setString(1,episode_type);
								pstmt1.setString(2,episode_type);
								pstmt1.setString(3,facility_id);
								pstmt1.setString(4,patient_id);
								pstmt1.setString(5,episode_type);
								pstmt1.setString(6,episode_id);
								pstmt1.setString(7,calling_module_id);
								pstmt1.setString(8,calling_module_id);
								pstmt1.setString(9,calling_module_id);
								pstmt1.setString(10,calling_module_id);
								pstmt1.setString(11,calling_module_id);

								rs1 = pstmt1.executeQuery() ;
								System.err.println("BLFinDetHiddenFlds.jsp 2341");
							}

							try
							{
								if( rs1 != null ) 
								{
									while( rs1.next() )
									{  
										System.err.println("Inside Ins Query");
										temp_ins_cust_group_code=rs1.getString("cust_group_code");
										rtn_ins_cust_group_code=rtn_ins_cust_group_code+temp_ins_cust_group_code+"|";
										if(rtn_ins_cust_group_code==null) rtn_ins_cust_group_code="";										

										temp_ins_cust_code=rs1.getString("cust_code");
										rtn_ins_cust_code=rtn_ins_cust_code+temp_ins_cust_code+"|";
										if(rtn_ins_cust_code==null) rtn_ins_cust_code="";
								
										temp_ins_cust_priority=rs1.getString("priority");
										rtn_ins_cust_priority=rtn_ins_cust_priority+temp_ins_cust_priority+"|";
										if(rtn_ins_cust_priority==null) rtn_ins_cust_priority="";
											
										temp_ins_policy_type_code=rs1.getString("policy_type_code");
										rtn_ins_policy_type_code=rtn_ins_policy_type_code+temp_ins_policy_type_code+"|";
										if(rtn_ins_policy_type_code==null) rtn_ins_policy_type_code="";

										if(!temp_ins_cust_code.equals("") && !temp_ins_policy_type_code.equals(""))
										{
											try
											{
												String restrict_check_sql="SELECT DECODE(?,'O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U'), DECODE(?,'O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE(?,'O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,  'U'),'U'),decode(?,'O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode(?,'O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N'),decode(?,'O',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'I',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'R',NVL(a.EX_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a, BL_CUST_BY_CUST_GROUP b WHERE a.OPERATING_FACILITY_ID = ? AND a.POLICY_TYPE_CODE = ? AND a.CUST_CODE = ? and b.cust_group_code = a.cust_group_code and a.cust_code = b.cust_code and a.cust_group_code=?";
												String empty_sql_check="N";
												System.err.println("########  BLFinDetHiddenFlds.jsp  33 "+con.isClosed());
												pstmt2 = con.prepareStatement(restrict_check_sql);
												pstmt2.setString(1, episode_type);
												pstmt2.setString(2, episode_type);
												pstmt2.setString(3, episode_type);
												pstmt2.setString(4, episode_type);
												pstmt2.setString(5, episode_type);
												pstmt2.setString(6, episode_type);
												pstmt2.setString(7, facility_id);
												pstmt2.setString(8, temp_ins_policy_type_code);
												pstmt2.setString(9, temp_ins_cust_code);
												pstmt2.setString(10, temp_ins_cust_group_code);
												rs2 = pstmt2.executeQuery() ;
												System.err.println("BLFinDetHiddenFlds.jsp 2376");
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
														cred_auth_mand_capt_yn = rs2.getString(6);
														empty_sql_check="N";
													}
												}
												
												if(rs2 != null) rs2.close();
												pstmt2.close();

												if(empty_sql_check.equals("Y"))
												{
													restrict_check_sql="SELECT DECODE(?,'O', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'E', NVL(a.OUTPATIENT_LIMIT_TYPE,'U'),'I', NVL(a.INPATIENT_LIMIT_TYPE,'U'),'D',NVL(a.INPATIENT_LIMIT_TYPE,'U'),'R',NVL(a.EXTERNAL_LIMIT_TYPE,'U'),'U'), DECODE(?,'O', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'E', NVL(a.OP_APPROVED_AMT_LIMIT_TYPE,'U'),'I', NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'D',NVL(a.IP_APPROVED_AMT_LIMIT_TYPE,'U'),'R',NVL(a.EX_APPROVED_AMT_LIMIT_TYPE, 'U'),'U'),DECODE(?,'O', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'E', NVL(a.OP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'I', NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'D',NVL(a.IP_APPROVED_DAYS_LIMIT_TYPE, 'U'),'R',NVL(a.EX_APPROVED_DAYS_LIMIT_TYPE,  'U'),'U'),decode(?,'O',NVL(a.OP_CRED_AUTH_REQ_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_REQ_YN,'N'),'I',NVL(a.IP_CRED_AUTH_REQ_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_REQ_YN,'N'),'R',NVL(a.EX_CRED_AUTH_REQ_YN,'N'),'N'),decode(?,'O',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'E',NVL(a.OP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'I',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN, 'N'),'D',NVL(a.IP_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'R',NVL(a.EX_DFLT_AUTH_REF_AS_POL_NO_YN,'N'),'N'),decode(?,'O',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'E',NVL(a.OP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'I',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN, 'N'),'D',NVL(a.IP_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'R',NVL(a.EX_CRED_AUTH_MAND_TO_CAPT_YN,'N'),'N') FROM BL_INS_POLICY_TYPE_HDR a WHERE a.OPERATING_FACILITY_ID = ? AND a.POLICY_TYPE_CODE = ? AND a.CUST_CODE = '**' and a.cust_group_code=?";

													System.err.println("########  BLFinDetHiddenFlds.jsp   34 "+con.isClosed());
													pstmt2 = con.prepareStatement(restrict_check_sql);
													pstmt2.setString(1, episode_type);
													pstmt2.setString(2, episode_type);
													pstmt2.setString(3, episode_type);
													pstmt2.setString(4, episode_type);
													pstmt2.setString(5, episode_type);
													pstmt2.setString(6, episode_type);
													pstmt2.setString(7, facility_id);
													pstmt2.setString(8, temp_ins_policy_type_code);
													pstmt2.setString(9, temp_ins_cust_group_code);
													rs2 = pstmt2.executeQuery() ;
													System.err.println("BLFinDetHiddenFlds.jsp 2402");
													if( rs2 != null ) 
													{
														while( rs2.next() )
														{  
															restrict_check=rs2.getString(1);
															apprd_amt_restrict_check = rs2.getString(2); 
															apprd_days_restrict_check = rs2.getString(3); 
															cred_auth_req_yn = rs2.getString(4); 
															dflt_auth_ref_as_pol_no_yn = rs2.getString(5); 
															cred_auth_mand_capt_yn = rs2.getString(6);
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
											
											if(restrict_check == null || restrict_check.equals("")) restrict_check="U";
											if(apprd_amt_restrict_check == null || apprd_amt_restrict_check.equals("")) apprd_amt_restrict_check="U";
											if(apprd_days_restrict_check == null || apprd_days_restrict_check.equals("")) apprd_days_restrict_check="U";
											if(cred_auth_req_yn == null || cred_auth_req_yn.equals("")) cred_auth_req_yn="N";
											if(cred_auth_mand_capt_yn == null || cred_auth_mand_capt_yn.equals("")) cred_auth_mand_capt_yn="N";
											if(dflt_auth_ref_as_pol_no_yn == null || dflt_auth_ref_as_pol_no_yn.equals("")) dflt_auth_ref_as_pol_no_yn="N";

											rtn_ins_restrict_check=rtn_ins_restrict_check+restrict_check+"|";

											rtn_ins_apprd_amt_restrict_check=rtn_ins_apprd_amt_restrict_check+apprd_amt_restrict_check+"|";
											rtn_ins_apprd_days_restrict_check=rtn_ins_apprd_days_restrict_check+apprd_days_restrict_check+"|";

											rtn_ins_cred_auth_req_yn = rtn_ins_cred_auth_req_yn+cred_auth_req_yn+"|";
											rtn_ins_cred_auth_mand_capt_yn = rtn_ins_cred_auth_mand_capt_yn+cred_auth_mand_capt_yn+"|";
											rtn_ins_dflt_auth_ref_as_pol_no_yn = rtn_ins_dflt_auth_ref_as_pol_no_yn+dflt_auth_ref_as_pol_no_yn+"|";
										}
										else
										{	
											rtn_ins_restrict_check=rtn_ins_restrict_check+"U"+"|";
											rtn_ins_apprd_amt_restrict_check=rtn_ins_apprd_amt_restrict_check+"U"+"|";
											rtn_ins_apprd_days_restrict_check=rtn_ins_apprd_days_restrict_check+"U"+"|";
											rtn_ins_cred_auth_req_yn = rtn_ins_cred_auth_req_yn+"N"+"|";
											rtn_ins_cred_auth_mand_capt_yn = rtn_ins_cred_auth_mand_capt_yn+"N"+"|";
											
											rtn_ins_dflt_auth_ref_as_pol_no_yn = rtn_ins_dflt_auth_ref_as_pol_no_yn+"N"+"|";
										}


										temp_ins_policy_no=rs1.getString("policy_number");
										if(temp_ins_policy_no == null) temp_ins_policy_no=" ";
										rtn_ins_policy_no=rtn_ins_policy_no+temp_ins_policy_no+"|";
										if(rtn_ins_policy_no==null) rtn_ins_policy_no="";
											
										temp_ins_policy_start_date=rs1.getString("policy_start_date");
										if(temp_ins_policy_start_date == null) temp_ins_policy_start_date=" ";
										rtn_ins_policy_start_date=rtn_ins_policy_start_date+temp_ins_policy_start_date+"|";
										if(rtn_ins_policy_start_date==null) rtn_ins_policy_start_date="";
											
										temp_ins_policy_expiry_date=rs1.getString("policy_expiry_date");
										if(temp_ins_policy_expiry_date == null) temp_ins_policy_expiry_date=" ";
										rtn_ins_policy_expiry_date=rtn_ins_policy_expiry_date+temp_ins_policy_expiry_date+"|";
										if(rtn_ins_policy_expiry_date==null) rtn_ins_policy_expiry_date="";
											
										temp_ins_credit_auth_ref=rs1.getString("credit_auth_ref");
										if(temp_ins_credit_auth_ref == null || temp_ins_credit_auth_ref.equals("")) temp_ins_credit_auth_ref=" ";
										rtn_ins_credit_auth_ref=rtn_ins_credit_auth_ref+temp_ins_credit_auth_ref+"|";
										if(rtn_ins_credit_auth_ref==null) rtn_ins_credit_auth_ref="";
											
										temp_ins_credit_auth_date=rs1.getString("credit_auth_date");
										if(temp_ins_credit_auth_date == null || temp_ins_credit_auth_date.equals("")) temp_ins_credit_auth_date=" ";
										rtn_ins_credit_auth_date=rtn_ins_credit_auth_date+temp_ins_credit_auth_date+"|";
										if(rtn_ins_credit_auth_date==null) rtn_ins_credit_auth_date="";
											
										temp_ins_credit_approval_days=rs1.getString("approved_days");
										if(temp_ins_credit_approval_days==null || temp_ins_credit_approval_days.equals("")) temp_ins_credit_approval_days=" ";
										rtn_ins_credit_approval_days=rtn_ins_credit_approval_days+temp_ins_credit_approval_days+"|";
										if(rtn_ins_credit_approval_days==null) rtn_ins_credit_approval_days="";
											
										temp_ins_credit_approval_amount=rs1.getString("approved_amt");
										if(temp_ins_credit_approval_amount==null || temp_ins_credit_approval_amount.equals("")) temp_ins_credit_approval_amount=" ";
										rtn_ins_credit_approval_amount=rtn_ins_credit_approval_amount+temp_ins_credit_approval_amount+"|";
										if(rtn_ins_credit_approval_amount==null) rtn_ins_credit_approval_amount="";
											
										temp_ins_policy_eff_from_date=rs1.getString("effective_from");
										if(temp_ins_policy_eff_from_date == null) temp_ins_policy_eff_from_date=" ";
										rtn_ins_policy_eff_from_date=rtn_ins_policy_eff_from_date+temp_ins_policy_eff_from_date+"|";
										if(rtn_ins_policy_eff_from_date==null) rtn_ins_policy_eff_from_date="";
											
										temp_ins_policy_eff_to_date=rs1.getString("effective_to");
										if(temp_ins_policy_eff_to_date==null || temp_ins_policy_eff_to_date.equals("")) temp_ins_policy_eff_to_date=" ";
										rtn_ins_policy_eff_to_date=rtn_ins_policy_eff_to_date+temp_ins_policy_eff_to_date+"|";
										if(rtn_ins_policy_eff_to_date==null) rtn_ins_policy_eff_to_date="";
										
										/* Added V180315-Aravindh/IN67010 start */
										if(siteSpec){
											try{
											String polHdrEffToSql="select to_char(POLICY_EFF_TO,'dd/mm/yyyy') effective_to  from BL_INS_POLICY_TYPE_HDR where operating_facility_id = ? and cust_group_code = ? and cust_code = ? and policy_type_code = ? ";
											
											System.err.println("addedFacilityId / temp_ins_cust_group_code / temp_ins_cust_code "+addedFacilityId +"/ " +temp_ins_cust_group_code + "/ "+temp_ins_cust_code);
											pstmt2=con.prepareStatement(polHdrEffToSql);
											pstmt2.setString(1,addedFacilityId);
											pstmt2.setString(2,temp_ins_cust_group_code);
											pstmt2.setString(3,temp_ins_cust_code);
											pstmt2.setString(4,temp_ins_policy_type_code);
											rs2=pstmt2.executeQuery();
											System.err.println("BLFinDetHiddenFlds.jsp 2510");
											if(rs2!=null)
											{
												while(rs2.next())
												{
													POLICY_EFF_T0_TMP=rs2.getString("effective_to");
													System.err.println("POLICY_EFF_TO_Tmp "+POLICY_EFF_T0_TMP);
													rtn_ins_pol_eff_to_tmp=rtn_ins_pol_eff_to_tmp+POLICY_EFF_T0_TMP+"|";	
												
												}
											}
												
											if(rs2 != null) rs2.close();
											pstmt2.close();
	
											}
											catch(Exception e)
											{												
												System.err.println("Exception in POLICY_EFF_TO_Tmp 2528: "+e);
												e.printStackTrace();
											}
										}
										/* Added V180315-Aravindh/IN67010 ends */
											
										temp_ins_adj_rule_ind=rs1.getString("adj_rule_ind");
										if(temp_ins_adj_rule_ind==null) temp_ins_adj_rule_ind=" ";
										rtn_ins_adj_rule_ind=rtn_ins_adj_rule_ind+temp_ins_adj_rule_ind+"|";
										if(rtn_ins_adj_rule_ind==null) rtn_ins_adj_rule_ind="";
											
										temp_ins_adj_perc_amt_ind=rs1.getString("adj_perc_amt_ind");
										if(temp_ins_adj_perc_amt_ind==null) temp_ins_adj_perc_amt_ind=" ";
										rtn_ins_adj_perc_amt_ind=rtn_ins_adj_perc_amt_ind+temp_ins_adj_perc_amt_ind+"|";
										if(rtn_ins_adj_perc_amt_ind==null) rtn_ins_adj_perc_amt_ind="";
											
										temp_ins_adj_perc_amt_value=rs1.getString("adj_perc_amt_value");
										if(temp_ins_adj_perc_amt_value==null) temp_ins_adj_perc_amt_value=" ";
										rtn_ins_adj_perc_amt_value=rtn_ins_adj_perc_amt_value+temp_ins_adj_perc_amt_value+"|";
										if(rtn_ins_adj_perc_amt_value==null) rtn_ins_adj_perc_amt_value="";
											
										temp_ins_pmnt_diff_adj_int=rs1.getString("pmnt_diff_adj_int");
										if(temp_ins_pmnt_diff_adj_int==null) temp_ins_pmnt_diff_adj_int=" ";
										rtn_ins_pmnt_diff_adj_int=rtn_ins_pmnt_diff_adj_int+temp_ins_pmnt_diff_adj_int+"|";
										if(rtn_ins_pmnt_diff_adj_int==null) rtn_ins_pmnt_diff_adj_int="";
											
										temp_ins_drg_pmnt_diff_adj_int=rs1.getString("drg_pmnt_diff_adj_int");
										if(temp_ins_drg_pmnt_diff_adj_int==null) temp_ins_drg_pmnt_diff_adj_int=" ";
										rtn_ins_drg_pmnt_diff_adj_int=rtn_ins_drg_pmnt_diff_adj_int+temp_ins_drg_pmnt_diff_adj_int+"|";
										if(rtn_ins_drg_pmnt_diff_adj_int==null) rtn_ins_drg_pmnt_diff_adj_int="";
											
										temp_ins_spl_srv_pmnt_diff_adj_int=rs1.getString("spl_srv_pmnt_diff_adj_int");
										if(temp_ins_spl_srv_pmnt_diff_adj_int==null) temp_ins_spl_srv_pmnt_diff_adj_int=" ";				
										rtn_ins_spl_srv_pmnt_diff_adj_int=rtn_ins_spl_srv_pmnt_diff_adj_int+temp_ins_spl_srv_pmnt_diff_adj_int+"|";
										if(rtn_ins_spl_srv_pmnt_diff_adj_int==null) rtn_ins_spl_srv_pmnt_diff_adj_int="";

										temp_ins_blng_grp=rs1.getString("blng_grp_id");
										if(temp_ins_blng_grp==null) temp_ins_blng_grp=" ";
										if(temp_ins_cust_priority.equals("1"))
										{
											rtn_blng_grp=temp_ins_blng_grp;
										}
										rtn_ins_blng_grp=rtn_ins_blng_grp+temp_ins_blng_grp+"|";

										temp_ins_ref_src_main_code = rs1.getString("ref_src_main_code");
										if(temp_ins_ref_src_main_code==null || temp_ins_ref_src_main_code.equals("")) 
										temp_ins_ref_src_main_code="";

										if(!temp_ins_ref_src_main_code.equals(""))
										{
														System.err.println("########  BLFinDetHiddenFlds.jsp   35 "+con.isClosed());
											call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
											call.registerOutParameter(1,java.sql.Types.VARCHAR);

											call.setString(2,temp_ins_ref_src_main_code);
											call.setString(3,locale);
											call.setString(4,"1");

											call.execute();						
											System.err.println("BLFinDetHiddenFlds.jsp 2752");
											temp_ins_ref_src_main_desc = call.getString(1);				
											call.close();
										}
										else
										{
											temp_ins_ref_src_main_code=" ";
											temp_ins_ref_src_main_desc=" ";
										}
										if ( temp_ins_ref_src_main_desc == null || temp_ins_ref_src_main_desc.equals("")) temp_ins_ref_src_main_desc = " ";									

										rtn_ins_ref_src_main_code=rtn_ins_ref_src_main_code+temp_ins_ref_src_main_code+"|";
										if(rtn_ins_policy_eff_to_date==null) rtn_ins_policy_eff_to_date="";

										rtn_ins_ref_src_main_desc=rtn_ins_ref_src_main_desc+temp_ins_ref_src_main_desc+"|";
										if(rtn_ins_ref_src_main_desc==null) rtn_ins_ref_src_main_desc="";

										temp_ins_ref_src_sub_code = rs1.getString("ref_src_sub_code");
										if(temp_ins_ref_src_sub_code==null || temp_ins_ref_src_sub_code.equals("")) temp_ins_ref_src_sub_code="";

										if(!temp_ins_ref_src_sub_code.equals(""))
										{
														System.err.println("########  BLFinDetHiddenFlds.jsp   36 "+con.isClosed());
											call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
											call.registerOutParameter(1,java.sql.Types.VARCHAR);

											call.setString(2,temp_ins_ref_src_sub_code);
											call.setString(3,locale);
											call.setString(4,"1");

											call.execute();					
											System.err.println("BLFinDetHiddenFlds.jsp 2783");
											temp_ins_ref_src_sub_desc = call.getString(1);				
											call.close();
										}
										else
										{
											temp_ins_ref_src_sub_code =" ";
											temp_ins_ref_src_sub_desc =" ";
										}
										if ( temp_ins_ref_src_sub_desc == null || temp_ins_ref_src_sub_desc.equals("")) temp_ins_ref_src_sub_desc = " ";
										
										rtn_ins_ref_src_sub_code=rtn_ins_ref_src_sub_code+temp_ins_ref_src_sub_code+"|";
										if(rtn_ins_ref_src_sub_code==null) rtn_ins_ref_src_sub_code="";

										rtn_ins_ref_src_sub_desc=rtn_ins_ref_src_sub_desc+temp_ins_ref_src_sub_desc+"|";
										if(rtn_ins_ref_src_sub_desc==null) rtn_ins_ref_src_sub_desc="";
									}
								}
							}
							catch(Exception e)
							{
								System.err.println("Exception while fetching financial values:"+e);
							}
							if(rs1 != null) rs1.close();
							pstmt1.close();

							rtn_non_ins_blng_grp = non_ins_blng_grp_id;
							if(rtn_non_ins_blng_grp==null) rtn_non_ins_blng_grp="";

							rtn_non_ins_cust_group_code = non_ins_cust_group_code;
							if(rtn_non_ins_cust_group_code==null) rtn_non_ins_cust_group_code="";

							rtn_non_ins_cust_code = non_ins_cust_code;
							if(rtn_non_ins_cust_code==null) rtn_non_ins_cust_code="";

							String sql_non_ins="select settlement_ind from bl_blng_grp where blng_grp_id =?";
							try
							{
								System.err.println("########  BLFinDetHiddenFlds.jsp   37 "+con.isClosed());
								pstmt2 = con.prepareStatement(sql_non_ins);
								pstmt2.setString(1, non_ins_blng_grp_id);
								rs2 = pstmt2.executeQuery() ;
								System.err.println("BLFinDetHiddenFlds.jsp 2659");
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
					}
				}
			}
						
			billing_mode=billing_mode.trim();
			System.err.println("BLFinDetHiddenFlds.jsp 2717:"+rtn_blng_grp);
			tabdata.put("blng_grp",rtn_blng_grp);
			tabdata.put("slmt_ind",rtn_slmt_ind);
			tabdata.put("annual_income",rtn_annual_family_income);
			tabdata.put("family_asset",rtn_family_assets_value);
			tabdata.put("no_of_dependants",rtn_num_of_dependents);
			tabdata.put("fin_remarks",rtn_remarks);

			/* Added for the enhancement of Patient Classification */
			if(fin_class_flag_YN.equals("Y"))
			{
				tabdata.put("inc_asset_ind",rtn_inc_asset_ind);	
				tabdata.put("ind_inc",rtn_ind_inc);	
				tabdata.put("ind_inc_freq",rtn_ind_inc_freq);	
				tabdata.put("spouse_inc",rtn_spouse_inc);	
				tabdata.put("spouse_inc_freq",rtn_spouse_inc_freq);	
				tabdata.put("dependent_inc",rtn_dependent_inc);	
				tabdata.put("dependent_inc_freq",rtn_dependent_inc_freq);	
				tabdata.put("class_code",rtn_class_code);	
				tabdata.put("class_type",rtn_class_type);	
				tabdata.put("valid_from",rtn_valid_from);	
				tabdata.put("valid_to",rtn_valid_to);	
				tabdata.put("last_date",rtn_last_date);	
				tabdata.put("remarks",rtn_fin_remarks);
				tabdata.put("social_pensioner_id",rtn_social_pensioner_id);	

				if(!rtn_class_code.equals(""))
					tabdata.put("fin_class_dtls_updated_YN","Y");
				else
					tabdata.put("fin_class_dtls_updated_YN","N");
			}
		}
		else
		{
			try
			{
				System.err.println("in hidden flds 2753 for class Query String:"+request.getQueryString());
				rtn_blng_grp = request.getParameter("blng_grp_id");
				if(rtn_blng_grp==null) rtn_blng_grp="";
		
				rtn_slmt_ind = request.getParameter("slmt_ind");
				if(rtn_slmt_ind==null) rtn_slmt_ind="";

				rtn_class_type = request.getParameter("class_type");
				if(rtn_class_type==null) rtn_class_type="";

				rtn_class_code = request.getParameter("class_code");
				if(rtn_class_code==null) rtn_class_code="";

				rtn_inc_asset_ind = request.getParameter("inc_asset_ind");
				if(rtn_inc_asset_ind==null) rtn_inc_asset_ind="";

				rtn_ind_inc = request.getParameter("ind_inc");
				if(rtn_ind_inc==null) rtn_ind_inc="";

				rtn_ind_inc_freq = request.getParameter("ind_inc_freq");
				if(rtn_ind_inc_freq==null) rtn_ind_inc_freq="";

				rtn_spouse_inc = request.getParameter("spouse_inc");
				if(rtn_spouse_inc==null) rtn_spouse_inc="";

				rtn_spouse_inc_freq = request.getParameter("spouse_inc_freq");
				if(rtn_spouse_inc_freq==null) rtn_spouse_inc_freq="";

				rtn_dependent_inc = request.getParameter("dependent_inc");
				if(rtn_dependent_inc==null) rtn_dependent_inc="";

				rtn_dependent_inc_freq = request.getParameter("dependent_inc_freq");
				if(rtn_dependent_inc_freq==null) rtn_dependent_inc_freq="";

				String tot_inc_asset = request.getParameter("tot_inc_asset");
				if(tot_inc_asset==null) tot_inc_asset="";

				rtn_valid_from = request.getParameter("valid_from");
				if(rtn_valid_from==null) rtn_valid_from="";

				rtn_valid_to = request.getParameter("valid_to");
				if(rtn_valid_to==null) rtn_valid_to="";

				rtn_last_date = request.getParameter("last_date");
				if(rtn_last_date==null) rtn_last_date="";

				rtn_fin_remarks = request.getParameter("remarks");
				if(rtn_remarks==null) rtn_remarks="";

				rtn_social_pensioner_id = request.getParameter("social_pensioner_id");
				if(rtn_social_pensioner_id==null) rtn_social_pensioner_id="";

				if(rtn_inc_asset_ind.equals("I"))
				{
					rtn_annual_family_income = tot_inc_asset;
				}
				else if(rtn_inc_asset_ind.equals("A"))
				{
					rtn_family_assets_value = tot_inc_asset;
				}

				rtn_num_of_dependents = request.getParameter("no_of_dependants");
				if(rtn_num_of_dependents==null) rtn_num_of_dependents="";

				tabdata=(HashMap)session.getAttribute("financial_details");
				if(!(tabdata==null || tabdata.isEmpty()))
				{
					System.err.println("When Session Value Exists");
					if(blng_grp_changed_YN.equals("Y"))
					{
						fin_dtl_already_avail_YN = "N";
						tabdata.put("fin_class_dtls_updated_YN","N");
					}
					else
					{
						fin_dtl_already_avail_YN = "Y";
						if(!rtn_class_code.equals(""))
							tabdata.put("fin_class_dtls_updated_YN","Y");
						else
							tabdata.put("fin_class_dtls_updated_YN","N");
					}
					tabdata.put("slmt_ind",rtn_slmt_ind);
					tabdata.put("annual_income",rtn_annual_family_income);
					tabdata.put("family_asset",rtn_family_assets_value);
					tabdata.put("no_of_dependants",rtn_num_of_dependents);
				}
				if(tabdata == null)
				{
					System.err.println("If tabdata is NULL");
					tabdata= new HashMap();
					tabdata.put("blng_grp",rtn_blng_grp);
					tabdata.put("slmt_ind",rtn_slmt_ind);
					tabdata.put("annual_income",rtn_annual_family_income);
					tabdata.put("family_asset",rtn_family_assets_value);
					tabdata.put("no_of_dependants",rtn_num_of_dependents);
					tabdata.put("fin_class_dtls_updated_YN","N");
				}
			}
			catch(Exception e)
			{
				System.err.println("Error in Class Logic Loop:"+e);
			}
		}
		System.err.println("@ 2856 fin_dtl_already_avail_YN:"+fin_dtl_already_avail_YN);
		if(fin_dtl_already_avail_YN.equals("N"))
		{
			session.setAttribute("blGetDfltEncBg", "Y");
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
			//Added By Vijay fro MMS-QF-SCF-0567
			if(siteSpec){
				tabdata.put("ins_policy_eff_to_date",rtn_ins_pol_eff_to_tmp);
				System.err.println("rtn_ins_pol_eff_to_tmp vijay after tabdata "+rtn_ins_pol_eff_to_tmp);
			}
			else{
				tabdata.put("ins_policy_eff_to_date",rtn_ins_policy_eff_to_date);	
				System.err.println("rtn_ins_pol_eff_to_tmp else tabdata "+rtn_ins_policy_eff_to_date);
			}
			
			//ends
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
			tabdata.put("ins_ref_src_main_code",rtn_ins_ref_src_main_code);
			tabdata.put("ins_ref_src_main_desc",rtn_ins_ref_src_main_desc);
			tabdata.put("ins_ref_src_sub_code",rtn_ins_ref_src_sub_code);
			tabdata.put("ins_ref_src_sub_desc",rtn_ins_ref_src_sub_desc);
			tabdata.put("ins_restrict_check",rtn_ins_restrict_check);
			tabdata.put("ins_apprd_amt_restrict_check",rtn_ins_apprd_amt_restrict_check);
			tabdata.put("ins_apprd_days_restrict_check",rtn_ins_apprd_days_restrict_check);
			tabdata.put("ins_cred_auth_req_yn",rtn_ins_cred_auth_req_yn);
			tabdata.put("ins_cred_auth_mand_capt_yn",rtn_ins_cred_auth_mand_capt_yn);
			tabdata.put("ins_dflt_auth_ref_as_pol_no_yn",rtn_ins_dflt_auth_ref_as_pol_no_yn);
			tabdata.put("resp_for_payment",rtn_resp_for_bill_payment);
			tabdata.put("pat_reln_with_resp_person",rtn_pat_reln_with_resp_pers);

			System.err.println("rtn_gl_holder_name final"+rtn_gl_holder_name);
			tabdata.put("gl_holder_name",rtn_gl_holder_name);
			tabdata.put("pat_reln_with_gl_holder",rtn_pat_reln_with_gl_holder);
			
			tabdata.put("ref_src_main_code",rtn_ref_src_main_code);
			tabdata.put("ref_src_main_desc",rtn_ref_src_main_desc);
			tabdata.put("ref_src_sub_code",rtn_ref_src_sub_code);
			tabdata.put("ref_src_sub_desc",rtn_ref_src_sub_desc);
			
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
			tabdata.put("cur_patient_id",patient_id);
			tabdata.put("fin_det_close",finDetClose); 
			tabdata.put("moduleId_new",moduleId_new); 
			tabdata.put("credit_authorisation_by",rtnCreditAuthorisationBy);//Added V190814-Aravindh/AMS-SCF-0808
			tabdata.put("claim_code",rtnClaimCode);//Added V190814-Aravindh/AMS-SCF-0808
			tabdata.put("membership_number",rtnMembershipNumber);//Added V190814-Aravindh/AMS-SCF-0808
		}

		session.setAttribute("financial_details",(HashMap)tabdata);
		System.err.println("Final Tabdata saved in session:"+(HashMap)tabdata);

/* ********************************************************* */

//		The following 2 lines are added for the OP & AE module purpose.To nullify the session everytime the patient_id is loaded
		session.removeAttribute("hosp_panel_str");
		session.removeAttribute("prof_panel_str");
		session.removeAttribute("addl_panel_str");
		session.removeAttribute("prof_panel_str_YN");
		session.removeAttribute("hosp_panel_str_YN");
		session.removeAttribute("addl_panel_str_YN");
		session.removeAttribute("upd_hosp_chrg_amt");
		session.removeAttribute("upd_hosp_chrg_pat_amt");
		session.removeAttribute("upd_med_chrg_amt");
		session.removeAttribute("upd_med_chrg_pat_amt");
		session.removeAttribute("upd_addl_chrg_amt");
		session.removeAttribute("upd_addl_chrg_pat_amt");
		session.removeAttribute("hosp_dtls");
		session.removeAttribute("prof_dtls");
		session.removeAttribute("addl_dtls");
		session.removeAttribute("fin_dtls_to_chrg_dtls");
		session.removeAttribute("hosp_panel");
		session.removeAttribute("prof_panel");
		session.removeAttribute("addl_panel");

		if(selected_from_prev_enc_YN.equals("Y"))
		{

            _bw.write(_wl_block5Bytes, _wl_block5);

		}

		if(called_for_reclass.equals("Y"))
		{
			out.println("Y");
		}

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rtn_blng_grp));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(billing_mode));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bl_future_admn_YN));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(last_visit_dtls));
            _bw.write(_wl_block13Bytes, _wl_block13);
 
		if((calling_module_id.equals("IP") || calling_module_id.equals("DC")) && (calling_function_id.equals("ADMISSION")))
		{
			if(future_adm_count>0)
			{

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(record));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(episode));
            _bw.write(_wl_block18Bytes, _wl_block18);

			}
		}
	}
	catch(Exception e)
	{ 
		out.println(e);
	} 
	finally
	{
		if(pstmt != null) pstmt.close();
		if(pstmt1 != null) pstmt1.close();
		if(pstmt2 != null) pstmt2.close();

		ConnectionManager.returnConnection(conn,request);
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
