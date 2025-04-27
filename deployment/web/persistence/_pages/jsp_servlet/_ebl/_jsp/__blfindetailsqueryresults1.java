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

public final class __blfindetailsqueryresults1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLFinDetailsQueryResults1.jsp", 1709114506383L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\t\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\n\n<script language=\'javascript\'>\n\t\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n<form name=\'PatFinQryForm\' id=\'PatFinQryForm\' method=\'post\' action=\'\'  scrolling=no>\n<table width=\'100%\' cellpadding=\'3\' cellspacing=\'0\' border=\'0\' align=\"center\">\n<td class=\"COLUMNHEADER\" >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\n<tr>\n\t<td class=\'label\' width=\"25%\" >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t<td class=\'data\'  width=\"25%\" ><b>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</b></td>\n\t<td class=\'label\' width=\"25%\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b></td>\n</tr>\n<tr>\n\t<td class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b></td>\n\t<td width=\"25%\" ></td>\n\t<td width=\"25%\" ></td>\n</tr>\n<tr>\n\t<td class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t<td class=\'data\' width=\"25%\" ><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></td>\n\t<td width=\"25%\" ></td>\n\t<td width=\"25%\" ></td>\n</tr>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<tr>\n\t<td class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</b></td>\n\t<td width=\"25%\" ></td>\n\t<td width=\"25%\" ></td>\n</tr>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n\n</table>\n \n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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

	Connection con = null;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt1 = null ;
	PreparedStatement pstmt2 = null ;
	ResultSet rs = null ;
	ResultSet rs1 = null, rs2 = null;
	
	try
	{
		request.setCharacterEncoding("UTF-8");
		con	=	ConnectionManager.getConnection(request);

		HttpSession httpSession = request.getSession(false);
//		Properties p = (Properties)httpSession.getValue("jdbc");

//		String user_id = "";
		String facility_id = (String)httpSession.getValue("facility_id");	
		String last_visit_dtls="N";
		String sql="";		

		String rtn_blng_class_code="",rtn_employer_code="",rtn_slmt_ind="",rtn_blng_grp="";
//		String rtn_bing_class_desc="",rtn_blng_grp_desc="";
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

//		String rtn_non_ins_blng_grp_desc="";	
		String rtn_remarks="";

		String slmt_type_code="",inst_ref="", inst_date="",inst_remarks="";
		String cust_code="",credit_doc_ref_desc="",credit_doc_ref_start_date="",credit_doc_ref_date="";
		String non_ins_blng_grp_id="",non_ins_cust_code="",non_ins_settlement_ind="";

		String temp_ins_blng_grp="",temp_ins_cust_code="",temp_ins_cust_priority="",temp_ins_policy_type_code="",temp_ins_policy_no="";
		String temp_ins_policy_start_date="",temp_ins_policy_expiry_date="",temp_ins_credit_auth_ref="",temp_ins_credit_auth_date="";
		String temp_ins_credit_approval_days="",temp_ins_credit_approval_amount="",temp_ins_policy_eff_from_date="",temp_ins_policy_eff_to_date="";
		String temp_ins_adj_rule_ind="",temp_ins_adj_perc_amt_ind="",temp_ins_adj_perc_amt_value="",temp_ins_pmnt_diff_adj_int="",temp_ins_drg_pmnt_diff_adj_int="",temp_ins_spl_srv_pmnt_diff_adj_int="";
		
//		String remarks="";

		String patient_id=request.getParameter("patient_id");

		sql="select blng_grp_id,settlement_ind,blng_class_code,employer_code,slmt_type_code,slmt_doc_ref_desc ,to_char(slmt_doc_ref_date,'dd/mm/yyyy') slmt_doc_ref_date,slmt_doc_remarks,cust_code,credit_doc_ref_desc,to_char(credit_doc_ref_start_date,'dd/mm/yyyy') credit_doc_ref_start_date,to_char(credit_doc_ref_date,'dd/mm/yyyy') credit_doc_ref_date,non_ins_blng_grp_id,non_ins_cust_code,annual_family_income,family_assets_value,num_of_dependents,resp_for_bill_payment,pat_reln_with_resp_pers,remarks,gl_holder_name,pat_reln_with_gl_holder from bl_patient_fin_dtls where patient_id ='"+patient_id+"'";

		try
		{
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery() ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
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
					rtn_pat_reln_with_gl_holder= rs.getString("pat_reln_with_gl_holder");
					if(rtn_pat_reln_with_gl_holder==null) rtn_pat_reln_with_gl_holder="";
					rtn_blng_class_code= rs.getString("blng_class_code");
					if(rtn_blng_class_code==null) rtn_blng_class_code="";
					rtn_employer_code= rs.getString("employer_code");
					if(rtn_employer_code==null) rtn_employer_code="";
//					user_id = p.getProperty("login_user");
//					if(user_id==null) user_id="";

					slmt_type_code=rs.getString("slmt_type_code");
//					System.out.println("slmt_type_code:"+slmt_type_code);
					if(slmt_type_code==null) slmt_type_code="";
					inst_ref =  rs.getString("slmt_doc_ref_desc");
					if(inst_ref==null) inst_ref="";
					inst_date = rs.getString("slmt_doc_ref_date");
					if(inst_date==null) inst_date="";
					inst_remarks = rs.getString("slmt_doc_remarks");
					if(inst_remarks==null) inst_remarks="";

					cust_code=rs.getString("cust_code");
					if(cust_code==null) cust_code="";
					credit_doc_ref_desc= rs.getString("credit_doc_ref_desc");
					if(credit_doc_ref_desc==null) credit_doc_ref_desc="";
					credit_doc_ref_start_date= rs.getString("credit_doc_ref_start_date");
					if(credit_doc_ref_start_date==null) credit_doc_ref_start_date="";
					credit_doc_ref_date= rs.getString("credit_doc_ref_date");
					if(credit_doc_ref_date==null) credit_doc_ref_date="";

					non_ins_blng_grp_id= rs.getString("non_ins_blng_grp_id");
//					System.out.println("non_ins_blng_grp_id:"+non_ins_blng_grp_id);
					if(non_ins_blng_grp_id==null) non_ins_blng_grp_id="";
					non_ins_cust_code= rs.getString("non_ins_cust_code");
					if(non_ins_cust_code==null) non_ins_cust_code="";

					if (rtn_slmt_ind.equals("C"))
					{
//						System.out.println("Inside Cash");
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
//						System.out.println("Inside Credit");
						rtn_credit_doc_reqd_yn = "Y";
						rtn_credit_cust_code = cust_code;
						if(rtn_credit_cust_code==null) rtn_credit_cust_code="";
					}

					if( rtn_slmt_ind.equals("R") || (rtn_slmt_ind.equals("C") && !(credit_doc_ref_desc.equals(""))))
					{
//						System.out.println("Inside Credit");
 						rtn_credit_doc_ref = credit_doc_ref_desc;
						if(rtn_credit_doc_ref==null) rtn_credit_doc_ref="";
						rtn_credit_doc_start_date = credit_doc_ref_start_date;
						if(rtn_credit_doc_start_date==null) rtn_credit_doc_start_date="";
						rtn_credit_doc_end_date = credit_doc_ref_date;
						if(rtn_credit_doc_end_date==null) rtn_credit_doc_end_date="";
					}
					else if(rtn_slmt_ind.equals("X") &&  non_ins_blng_grp_id.equals(""))
					{
//						System.out.println("Inside Sponsor");
						rtn_credit_doc_reqd_yn = "Y";
						rtn_sponsor_cust_code = cust_code;
						if(rtn_sponsor_cust_code==null) rtn_sponsor_cust_code="";
						rtn_sponsor_credit_doc_ref = credit_doc_ref_desc;
						if(rtn_sponsor_credit_doc_ref==null) rtn_sponsor_credit_doc_ref="";
						rtn_sponsor_credit_doc_start_date = credit_doc_ref_start_date;
						if(rtn_sponsor_credit_doc_start_date==null) rtn_sponsor_credit_doc_start_date="";
						rtn_sponsor_credit_doc_end_date = credit_doc_ref_date;
						if(rtn_sponsor_credit_doc_end_date==null) rtn_sponsor_credit_doc_end_date="";

					}
					else if(rtn_slmt_ind.equals("X") && !(non_ins_blng_grp_id.equals("")))
					{
//						System.out.println("Inside Insurance");
						String sql_ins="SELECT a.cust_code cust_code,a.priority priority,a.policy_type_code policy_type_code,a.policy_number policy_number,to_char(a.policy_start_date,'dd/mm/yyyy') policy_start_date,to_char(a.policy_expiry_date,'dd/mm/yyyy') policy_expiry_date,a.credit_auth_ref credit_auth_ref,to_char(a.credit_auth_date,'dd/mm/yyyy') credit_auth_date,to_char(a.effective_from,'dd/mm/yyyy') effective_from,to_char(a.effective_to,'dd/mm/yyyy') effective_to,a.approved_amt approved_amt,a.approved_days approved_days,a.adj_rule_ind adj_rule_ind,a.adj_perc_amt_ind adj_perc_amt_ind,a.adj_perc_amt_value adj_perc_amt_value,a.pmnt_diff_adj_int pmnt_diff_adj_int,a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int, a.blng_grp_id blng_grp_id FROM bl_encounter_payer_priority a, bl_patient_fin_dtls b WHERE a.operating_facility_id ='"+facility_id+"' AND a.episode_type = 'R' AND a.patient_id ='"+patient_id+"' AND a.patient_id = b.patient_id AND a.acct_seq_no = b.cur_acct_seq_no AND a.priority is not NULL ORDER BY 2";

						try
						{
							pstmt1 = con.prepareStatement(sql_ins);
							rs1 = pstmt1.executeQuery() ;
							if( rs1 != null ) 
							{
								while( rs1.next() )
								{  
									temp_ins_cust_code=rs1.getString("cust_code");
									rtn_ins_cust_code=rtn_ins_cust_code+temp_ins_cust_code+"|";
									if(rtn_ins_cust_code==null) rtn_ins_cust_code="";
									
									temp_ins_cust_priority=rs1.getString("priority");
									rtn_ins_cust_priority=rtn_ins_cust_priority+temp_ins_cust_priority+"|";
									if(rtn_ins_cust_priority==null) rtn_ins_cust_priority="";
									
									temp_ins_policy_type_code=rs1.getString("policy_type_code");
									rtn_ins_policy_type_code=rtn_ins_policy_type_code+temp_ins_policy_type_code+"|";
									if(rtn_ins_policy_type_code==null) rtn_ins_policy_type_code="";
									
									temp_ins_policy_no=rs1.getString("policy_number");
									rtn_ins_policy_no=rtn_ins_policy_no+temp_ins_policy_no+"|";
									if(rtn_ins_policy_no==null) rtn_ins_policy_no="";
									
									temp_ins_policy_start_date=rs1.getString("policy_start_date");
									rtn_ins_policy_start_date=rtn_ins_policy_start_date+temp_ins_policy_start_date+"|";
									if(rtn_ins_policy_start_date==null) rtn_ins_policy_start_date="";
									
									temp_ins_policy_expiry_date=rs1.getString("policy_expiry_date");
									rtn_ins_policy_expiry_date=rtn_ins_policy_expiry_date+temp_ins_policy_expiry_date+"|";
									if(rtn_ins_policy_expiry_date==null) rtn_ins_policy_expiry_date="";
									
									temp_ins_credit_auth_ref=rs1.getString("credit_auth_ref");
									rtn_ins_credit_auth_ref=rtn_ins_credit_auth_ref+temp_ins_credit_auth_ref+"|";
									if(rtn_ins_credit_auth_ref==null) rtn_ins_credit_auth_ref="";
									
									temp_ins_credit_auth_date=rs1.getString("credit_auth_date");
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
									rtn_ins_policy_eff_from_date=rtn_ins_policy_eff_from_date+temp_ins_policy_eff_from_date+"|";
									if(rtn_ins_policy_eff_from_date==null) rtn_ins_policy_eff_from_date="";
									
									temp_ins_policy_eff_to_date=rs1.getString("effective_to");
									if(temp_ins_policy_eff_to_date==null || temp_ins_policy_eff_to_date.equals("")) temp_ins_policy_eff_to_date=" ";
									rtn_ins_policy_eff_to_date=rtn_ins_policy_eff_to_date+temp_ins_policy_eff_to_date+"|";
									if(rtn_ins_policy_eff_to_date==null) rtn_ins_policy_eff_to_date="";
									
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
//									System.out.println("temp_ins_adj_perc_amt_value:"+temp_ins_adj_perc_amt_value);
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
									}
									rtn_ins_blng_grp=rtn_ins_blng_grp+temp_ins_blng_grp+"|";
								}
							}
						
						}
						catch(Exception e)
						{
						}
						rs1.close();
						pstmt1.close();

						rtn_non_ins_blng_grp = non_ins_blng_grp_id;
						if(rtn_non_ins_blng_grp==null) rtn_non_ins_blng_grp="";
						rtn_non_ins_cust_code = non_ins_cust_code;

						if(rtn_non_ins_cust_code==null) rtn_non_ins_cust_code="";

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
						}
						rs2.close();
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
	rs.close();
	pstmt.close();
	}
	catch(Exception e)
	{
	}


            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rtn_blng_grp));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rtn_non_ins_blng_grp));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rtn_blng_class_code));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rtn_employer_code));
            _bw.write(_wl_block14Bytes, _wl_block14);

	if (rtn_slmt_ind.equals("C"))
	{

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rtn_slmt_type_code));
            _bw.write(_wl_block16Bytes, _wl_block16);

	}
	}
	
	catch(Exception ee)
	{
		out.println("Exception in main try"+ee);
	}
	finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.financialdetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NON_INS_BILLING_GROUP.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingClass.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EMPLOYER_NAME.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SettlementType.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
