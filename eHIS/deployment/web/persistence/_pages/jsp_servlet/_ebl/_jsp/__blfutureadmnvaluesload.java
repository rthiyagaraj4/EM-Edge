package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eBL.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blfutureadmnvaluesload extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLFutureAdmnValuesLoad.jsp", 1709114521260L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n\t\t\n <body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n  \n<input type=\'hidden\' name=\'billing_group\' id=\'billing_group\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></input>\n<input type=\'hidden\' name=\'billing_mode\' id=\'billing_mode\' value=\'Add\'></input>\n<input type=\'hidden\' name=\'bl_operation\' id=\'bl_operation\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></input>\n\n<!--\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'></input>\n\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'></input>\n<input type=\'hidden\' name=\'last_visit_dtls\' id=\'last_visit_dtls\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'></input>\n-->\n</body>\n\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" \n\n<script>\nwindow.close();\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con=null ;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1  = null;
	PreparedStatement pstmt2  = null;

	ResultSet rs1 = null;
	ResultSet rs2 = null;		

  	try
  	{	
//		System.out.println("Hidden Flds Loaded1");
		session.removeAttribute("financial_details");
		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);
//		Properties p = (Properties)httpSession.getValue("jdbc");

		String patient_id="";
		String episode_type="";
		String user_id = "";
		String facility_id = (String)httpSession.getValue("facility_id");	

		String last_visit_dtls="N";
		String sql="",episode="",record="";
		String strdfltbgyn="";

//		int future_adm_count=0;

		// Varibales for sql query
//Unused Var's
/*
		String slmt_type_code="",inst_ref="", inst_date="",inst_remarks="";
		String cust_code="",credit_doc_ref_desc="",credit_doc_ref_start_date="",credit_doc_ref_date="";
		String non_ins_blng_grp_id="",non_ins_cust_code="",non_ins_settlement_ind="";

		String remarks="";
*/		

		// return variables
		String rtn_blng_class_code="",rtn_employer_code="",rtn_slmt_ind="",rtn_blng_grp="";
		String rtn_annual_family_income="",rtn_family_assets_value="",rtn_num_of_dependents="";
		String rtn_resp_for_bill_payment="",rtn_pat_reln_with_resp_pers="",rtn_gl_holder_name="",rtn_pat_reln_with_gl_holder="";

		String rtn_slmt_type_code="",rtn_inst_ref="",rtn_inst_date="",rtn_inst_remarks="";
		String rtn_credit_doc_reqd_yn="",rtn_credit_cust_code="",rtn_credit_doc_ref="",rtn_credit_doc_start_date="",rtn_credit_doc_end_date="";
		String rtn_sponsor_cust_code="",rtn_sponsor_credit_doc_ref="",rtn_sponsor_credit_doc_start_date="",rtn_sponsor_credit_doc_end_date="";

		String rtn_ins_blng_grp="",rtn_ins_cust_code="",rtn_ins_cust_priority="",rtn_ins_policy_type_code="",rtn_ins_policy_no="";
		String rtn_ins_policy_start_date="",rtn_ins_policy_expiry_date="",rtn_ins_credit_auth_ref="",rtn_ins_credit_auth_date="";
		String rtn_ins_credit_approval_days="",rtn_ins_credit_approval_amount="",rtn_ins_policy_eff_from_date="",rtn_ins_policy_eff_to_date="";
		String rtn_ins_adj_rule_ind="",rtn_ins_adj_perc_amt_ind="",rtn_ins_adj_perc_amt_value="",rtn_ins_pmnt_diff_adj_int="",rtn_ins_drg_pmnt_diff_adj_int="",rtn_ins_spl_srv_pmnt_diff_adj_int="";
		String rtn_non_ins_blng_grp="",rtn_non_ins_cust_code="",rtn_non_ins_credit_doc_reqd_yn="",rtn_non_ins_slmt_type_code="";
		String rtn_non_ins_inst_ref="",rtn_non_ins_inst_date="",rtn_non_ins_inst_remarks="",rtn_non_ins_credit_doc_ref="",rtn_non_ins_credit_doc_start_date="",rtn_non_ins_credit_doc_end_date="";

		String rtn_remarks="";

		String temp_ins_blng_grp="",temp_ins_cust_code="",temp_ins_cust_priority="",temp_ins_policy_type_code="",temp_ins_policy_no="";
		String temp_ins_policy_start_date="",temp_ins_policy_expiry_date="",temp_ins_credit_auth_ref="",temp_ins_credit_auth_date="";
		String temp_ins_credit_approval_days="",temp_ins_credit_approval_amount="",temp_ins_policy_eff_from_date="",temp_ins_policy_eff_to_date="";
		String temp_ins_adj_rule_ind="",temp_ins_adj_perc_amt_ind="",temp_ins_adj_perc_amt_value="",temp_ins_pmnt_diff_adj_int="",temp_ins_drg_pmnt_diff_adj_int="",temp_ins_spl_srv_pmnt_diff_adj_int="";

		String billing_mode="",upd_fin_dtls="C", operation="Insert";


			patient_id=request.getParameter("patient_id");
			episode=request.getParameter("episode");
			record=request.getParameter("record");
			episode_type=request.getParameter("episode_type");
		
			if(episode==null)episode="";
			if(record==null)record="";
			if(episode_type==null)episode_type="";
		
			con = ConnectionManager.getConnection(request);

			if(episode.equals("N"))
			{
				String cond="Select last_episode_id, last_visit_id from op_last_visit where last_patient_id='"+patient_id+"'";

				pstmt2 = con.prepareStatement(cond);
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


		
			//sql="select blng_grp_id, blng_class_code, employer_code, settlement_ind, credit_doc_ref_desc,to_char(credit_doc_ref_date,'dd/mm/yyyy')credit_doc_ref_date, cust_code, slmt_type_code, slmt_doc_ref_desc, to_char(slmt_doc_ref_date,'dd/mm/yyyy')slmt_doc_ref_date, slmt_doc_remarks, remarks, policy_type_code, policy_number, to_char(policy_expiry_date,'dd/mm/yyyy')policy_expiry_date, non_ins_blng_grp_id, non_ins_cust_code, annual_family_income, family_assets_value, num_of_dependents,      resp_for_bill_payment,GL_HOLDER_NAME,PAT_RELN_WITH_GL_HOLDER,to_char(CREDIT_DOC_REF_START_DATE, 'dd/mm/yyyy') CREDIT_DOC_REF_START_DATE from bl_patient_fin_dtls where patient_id='"+patient_id+"'";

			try
			{
				String sql0 = "select nvl(dflt_pat_bg_for_encntr_regn_yn,'N') bg from bl_mp_param ";
				pstmt = con.prepareStatement(sql0);
				rs2 = pstmt.executeQuery() ;
				if( rs2 != null ) 
				{
					while( rs2.next() )
					{  
						strdfltbgyn = rs2.getString("bg");
					}
				}
				if (rs2 != null)   rs2.close();
				pstmt.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception in sql0:"+e);
			}
		
			sql="select blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc ,to_char(slmt_doc_ref_date,'dd/mm/yyyy') slmt_doc_ref_date,slmt_doc_remarks,cust_code,credit_doc_ref_desc,to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date,to_char(credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,gl_holder_name,pat_reln_with_gl_holder from bl_patient_fin_dtls where patient_id ='"+patient_id+"'";
		
			try
			{
					String sql_ins="SELECT a.cust_code cust_code,a.priority priority,a.policy_type_code policy_type_code,a.policy_number policy_number,to_char(a.policy_start_date,'dd/mm/yyyy') policy_start_date,to_char(a.policy_expiry_date,'dd/mm/yyyy') policy_expiry_date,a.credit_auth_ref credit_auth_ref,to_char(a.credit_auth_date,'dd/mm/yyyy') credit_auth_date,to_char(a.effective_date,'dd/mm/yyyy') effective_from,to_char(a.effective_to,'dd/mm/yyyy') effective_to,a.approved_amt approved_amt,a.approved_days approved_days,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int, a.blng_grp_id blng_grp_id FROM bl_ins_track_dtls a, bl_patient_fin_dtls b WHERE a.operating_facility_id ='"+facility_id+"' AND a.episode_type='"+episode_type+"' AND a.patient_id ='"+patient_id+"' AND a.patient_id = b.patient_id AND  a.priority is not NULL ORDER BY 2";

//							System.out.println("sql_ins:"+sql_ins);

							try
							{
								pstmt1 = con.prepareStatement(sql_ins);
								rs1 = pstmt1.executeQuery() ;
								if( rs1 != null ) 
								{
									while( rs1.next() )
									{  
//										System.out.println("Inside Ins Query");
										
										temp_ins_cust_code=rs1.getString("cust_code");
										if(temp_ins_cust_code==null || temp_ins_cust_code.equals("")) temp_ins_cust_code=" ";
										rtn_ins_cust_code=rtn_ins_cust_code+temp_ins_cust_code+"|";
										if(rtn_ins_cust_code==null) rtn_ins_cust_code="";
										
										temp_ins_cust_priority=rs1.getString("priority");
										if(temp_ins_cust_priority==null || temp_ins_cust_priority.equals("")) temp_ins_cust_priority=" ";
										rtn_ins_cust_priority=rtn_ins_cust_priority+temp_ins_cust_priority+"|";
										if(rtn_ins_cust_priority==null) rtn_ins_cust_priority="";
										
										temp_ins_policy_type_code=rs1.getString("policy_type_code");
										if(temp_ins_policy_type_code==null || temp_ins_policy_type_code.equals("")) temp_ins_policy_type_code=" ";
										rtn_ins_policy_type_code=rtn_ins_policy_type_code+temp_ins_policy_type_code+"|";
										if(rtn_ins_policy_type_code==null) rtn_ins_policy_type_code="";
										
										temp_ins_policy_no=rs1.getString("policy_number");
										if(temp_ins_policy_no==null || temp_ins_policy_no.equals("")) temp_ins_policy_no=" ";
										rtn_ins_policy_no=rtn_ins_policy_no+temp_ins_policy_no+"|";
										if(rtn_ins_policy_no==null) rtn_ins_policy_no="";
										
										temp_ins_policy_start_date=rs1.getString("policy_start_date");
										if(temp_ins_policy_start_date==null || temp_ins_policy_start_date.equals("")) temp_ins_policy_start_date=" ";
										rtn_ins_policy_start_date=rtn_ins_policy_start_date+temp_ins_policy_start_date+"|";
										if(rtn_ins_policy_start_date==null) rtn_ins_policy_start_date="";
										
										temp_ins_policy_expiry_date=rs1.getString("policy_expiry_date");
										if(temp_ins_policy_expiry_date==null || temp_ins_policy_expiry_date.equals("")) temp_ins_policy_expiry_date=" ";
										rtn_ins_policy_expiry_date=rtn_ins_policy_expiry_date+temp_ins_policy_expiry_date+"|";
										if(rtn_ins_policy_expiry_date==null) rtn_ins_policy_expiry_date="";
										
										temp_ins_credit_auth_ref=rs1.getString("credit_auth_ref");
										if(temp_ins_credit_auth_ref==null || temp_ins_credit_auth_ref.equals("")) temp_ins_credit_auth_ref=" ";
										rtn_ins_credit_auth_ref=rtn_ins_credit_auth_ref+temp_ins_credit_auth_ref+"|";
										if(rtn_ins_credit_auth_ref==null) rtn_ins_credit_auth_ref="";
										
										temp_ins_credit_auth_date=rs1.getString("credit_auth_date");
										if(temp_ins_credit_auth_date==null || temp_ins_credit_auth_date.equals("")) temp_ins_credit_auth_date=" ";
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
										if(temp_ins_policy_eff_from_date==null || temp_ins_policy_eff_from_date.equals("")) temp_ins_policy_eff_from_date=" ";
										rtn_ins_policy_eff_from_date=rtn_ins_policy_eff_from_date+temp_ins_policy_eff_from_date+"|";
										if(rtn_ins_policy_eff_from_date==null) rtn_ins_policy_eff_from_date="";
										
										temp_ins_policy_eff_to_date=rs1.getString("effective_to");
										if(temp_ins_policy_eff_to_date==null || temp_ins_policy_eff_to_date.equals("")) temp_ins_policy_eff_to_date=" ";
										rtn_ins_policy_eff_to_date=rtn_ins_policy_eff_to_date+temp_ins_policy_eff_to_date+"|";
										if(rtn_ins_policy_eff_to_date==null) rtn_ins_policy_eff_to_date="";
										
										temp_ins_adj_rule_ind=rs1.getString("adj_rule_ind");
										if(temp_ins_adj_rule_ind==null || temp_ins_adj_rule_ind.equals("")) temp_ins_adj_rule_ind=" ";
										rtn_ins_adj_rule_ind=rtn_ins_adj_rule_ind+temp_ins_adj_rule_ind+"|";
										if(rtn_ins_adj_rule_ind==null) rtn_ins_adj_rule_ind="";
										
										temp_ins_adj_perc_amt_ind=rs1.getString("adj_perc_amt_ind");
										if(temp_ins_adj_perc_amt_ind==null || temp_ins_adj_perc_amt_ind.equals("")) temp_ins_adj_perc_amt_ind=" ";
										rtn_ins_adj_perc_amt_ind=rtn_ins_adj_perc_amt_ind+temp_ins_adj_perc_amt_ind+"|";
										if(rtn_ins_adj_perc_amt_ind==null) rtn_ins_adj_perc_amt_ind="";
										
										temp_ins_adj_perc_amt_value=rs1.getString("adj_perc_amt_value");
										if(temp_ins_adj_perc_amt_value==null || temp_ins_adj_perc_amt_value.equals("")) temp_ins_adj_perc_amt_value=" ";
	//									System.out.println("temp_ins_adj_perc_amt_value:"+temp_ins_adj_perc_amt_value);
										rtn_ins_adj_perc_amt_value=rtn_ins_adj_perc_amt_value+temp_ins_adj_perc_amt_value+"|";
										if(rtn_ins_adj_perc_amt_value==null) rtn_ins_adj_perc_amt_value="";
										
										temp_ins_pmnt_diff_adj_int=rs1.getString("pmnt_diff_adj_int");
										if(temp_ins_pmnt_diff_adj_int==null || temp_ins_pmnt_diff_adj_int.equals("")) temp_ins_pmnt_diff_adj_int=" ";
										rtn_ins_pmnt_diff_adj_int=rtn_ins_pmnt_diff_adj_int+temp_ins_pmnt_diff_adj_int+"|";
										if(rtn_ins_pmnt_diff_adj_int==null) rtn_ins_pmnt_diff_adj_int="";
										
										temp_ins_drg_pmnt_diff_adj_int=rs1.getString("drg_pmnt_diff_adj_int");
										if(temp_ins_drg_pmnt_diff_adj_int==null || temp_ins_drg_pmnt_diff_adj_int.equals("")) temp_ins_drg_pmnt_diff_adj_int=" ";
										rtn_ins_drg_pmnt_diff_adj_int=rtn_ins_drg_pmnt_diff_adj_int+temp_ins_drg_pmnt_diff_adj_int+"|";
										if(rtn_ins_drg_pmnt_diff_adj_int==null) rtn_ins_drg_pmnt_diff_adj_int="";
										
										temp_ins_spl_srv_pmnt_diff_adj_int=rs1.getString("spl_srv_pmnt_diff_adj_int");
										if(temp_ins_spl_srv_pmnt_diff_adj_int==null || temp_ins_spl_srv_pmnt_diff_adj_int.equals("")) temp_ins_spl_srv_pmnt_diff_adj_int=" ";									rtn_ins_spl_srv_pmnt_diff_adj_int=rtn_ins_spl_srv_pmnt_diff_adj_int+temp_ins_spl_srv_pmnt_diff_adj_int+"|";
										if(rtn_ins_spl_srv_pmnt_diff_adj_int==null) rtn_ins_spl_srv_pmnt_diff_adj_int="";

										temp_ins_blng_grp=rs1.getString("blng_grp_id");
										if(temp_ins_blng_grp==null) temp_ins_blng_grp=" ";
										if(temp_ins_cust_priority.equals("1"))
										{
											rtn_blng_grp=temp_ins_blng_grp;
	//										System.out.println("rtn_blng_grp:"+rtn_blng_grp);
										}
										rtn_ins_blng_grp=rtn_ins_blng_grp+temp_ins_blng_grp+"|";
	//									System.out.println("rtn_ins_blng_grp:"+rtn_ins_blng_grp);

									}
								}
							
							}
							catch(Exception e)
							{
							}
							if (rs1 != null)   rs1.close();
							pstmt1.close();

			}
			catch(Exception e){}
			pstmt.close();
		
		
		billing_mode=billing_mode.trim();

		HashMap tabdata = new HashMap();
		tabdata.put("blng_grp",rtn_blng_grp);
		tabdata.put("slmt_ind",rtn_slmt_ind);
		tabdata.put("credit_doc_reqd_yn",rtn_credit_doc_reqd_yn);
		tabdata.put("blng_class",rtn_blng_class_code);
		tabdata.put("emp_code",rtn_employer_code);
		tabdata.put("slmt_type_code",rtn_slmt_type_code);
		tabdata.put("inst_ref",rtn_inst_ref);
		tabdata.put("inst_date",rtn_inst_date);
		tabdata.put("inst_remarks",rtn_inst_remarks);

		tabdata.put("credit_cust_code",rtn_credit_cust_code);
		tabdata.put("credit_doc_ref",rtn_credit_doc_ref);
		tabdata.put("credit_doc_start_date",rtn_credit_doc_start_date);
		tabdata.put("credit_doc_end_date",rtn_credit_doc_end_date);

		tabdata.put("sponsor_cust_code",rtn_sponsor_cust_code);
		tabdata.put("sponsor_credit_doc_ref",rtn_sponsor_credit_doc_ref);
		tabdata.put("sponsor_credit_doc_start_date",rtn_sponsor_credit_doc_start_date);
		tabdata.put("sponsor_credit_doc_end_date",rtn_sponsor_credit_doc_end_date);

		tabdata.put("ins_blng_grp",rtn_ins_blng_grp);
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
		tabdata.put("non_ins_cust_code",rtn_non_ins_cust_code);
		tabdata.put("non_ins_credit_doc_ref",rtn_non_ins_credit_doc_ref);
		tabdata.put("non_ins_credit_doc_start_date",rtn_non_ins_credit_doc_start_date);
		tabdata.put("non_ins_credit_doc_end_date",rtn_non_ins_credit_doc_end_date);

		tabdata.put("annual_income",rtn_annual_family_income);
		tabdata.put("family_asset",rtn_family_assets_value);
		tabdata.put("no_of_dependants",rtn_num_of_dependents);
		tabdata.put("resp_for_payment",rtn_resp_for_bill_payment);
		tabdata.put("pat_reln_with_resp_person",rtn_pat_reln_with_resp_pers);
		tabdata.put("fin_remarks",rtn_remarks);
		tabdata.put("gl_holder_name",rtn_gl_holder_name);
		tabdata.put("pat_reln_with_gl_holder",rtn_pat_reln_with_gl_holder);
		tabdata.put("upd_patient_fin_dtls_yn",upd_fin_dtls);
		tabdata.put("user_id",user_id);
//		System.out.println("tabdata values in change patient:"+tabdata);

		
		session.setAttribute("financial_details",tabdata);
//		System.out.println("financial_details in BLTest.jsp:"+session.getAttribute("financial_details"));


//		The following 2 lines are added for the OP & AE module purpose.To nullify the session everytime the patient_id is loaded
//		System.out.println("Session Values Reset in BLFinDetHiddenFlds.jsp");
		session.removeAttribute("hosp_panel_str");
		session.removeAttribute("prof_panel_str");
		session.removeAttribute("prof_panel_str_YN");
		session.removeAttribute("hosp_panel_str_YN");
		session.removeAttribute("upd_hosp_chrg_amt");
		session.removeAttribute("upd_hosp_chrg_pat_amt");
		session.removeAttribute("upd_med_chrg_amt");
		session.removeAttribute("upd_med_chrg_pat_amt");
		session.removeAttribute("hosp_dtls");
		session.removeAttribute("prof_dtls");
		session.removeAttribute("fin_dtls_to_chrg_dtls");
		session.removeAttribute("hosp_panel");
		session.removeAttribute("prof_panel");

            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(rtn_blng_grp));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(last_visit_dtls));
            _bw.write(_wl_block12Bytes, _wl_block12);
 
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

		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
