package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.io.*;
import webbeans.op.CurrencyFormat;
import eOR.*;
import eOR.Common.*;
import eBL.BLReportIdMapper;

public final class __bladhocdiscvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLAdhocDiscValidation.jsp", 1731678093635L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

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
	
	request.setCharacterEncoding("UTF-8");	
	Connection con = null;
	PreparedStatement pstmt = null ;	
	ResultSet rs=null;

	String currdate="",discount_allowed_yn="",user_pasword="",blng_serv_code="",user_name="",p_user_pasword="",valid_user_YN="",valid_user_pass_YN="",serv_item_code="";
	String rec_found="";
	String str_disc_amt = "", str_act_gross_amt = "", str_serv_max_disc_per ="", str_serv_max_disc_amt = "", str_payer_max_disc_per = "", str_payer_max_disc_amt = "", str_max_allowed_limit="";

	String upd_gross_charge_amt = "", upd_disc_amt = "", upd_net_charge_amt = "";

	String strNull="";

	double disc_amt = 0, max_allowed_limit=0;

	int noofdecimal=2;
	
	String out_msg="";

	CurrencyFormat cf1 = null;
	
	String str_addl_chrg_amt = "";/* Added V180116-Aravindh/MMSVAT */

	boolean amtRoundOff = true;//Added V180123-Aravindh/MMS-JU-SCF-0102
	
	try
	{
		con	=	ConnectionManager.getConnection(request);	

		String locale = (String)session.getAttribute("LOCALE");			
		if(locale==null || locale.equals("")) locale="en";		
		
		String str_facility_id = (String) session.getValue("facility_id");
		if (str_facility_id==null) str_facility_id = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";

//		System.out.println("in validation:"+request.getQueryString());

		cf1 = new CurrencyFormat();

		String called_frm = request.getParameter("called_frm");	
		if(called_frm==null) called_frm="";		

		String module_id = request.getParameter("module_id");	
		if(module_id==null) module_id="";		

		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2),to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from  sm_acc_entity_param");
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				noofdecimal  =  rs.getInt(1);
				currdate	 =  rs.getString(2);
			}		
			rs.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("3="+e.toString());
		}
		
		//Added V180123-Aravindh/MMS-JU-SCF-0102 try
		try {
			pstmt = con.prepareStatement("select BILL_ROUNDING_IND  from bl_parameters");
			
			rs = pstmt.executeQuery();	
			if ( rs != null && rs.next())
			{
				if(rs.getString("BILL_ROUNDING_IND").trim().equalsIgnoreCase("0")) {
					amtRoundOff = false;
				}
			}
		} catch(Exception e) {   
			e.printStackTrace();
			System.out.println("4="+e.toString());
		} finally {
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();		 		
		}
		System.out.println("BLAdhocDiscValidation.jsp->amtRoundOff: "+amtRoundOff);
		
		if(called_frm.equals("user_pass"))
		{
//						System.out.println("Inside user_pass");
			blng_serv_code = request.getParameter("blng_serv_code");	
			if(blng_serv_code==null) blng_serv_code="";	

			serv_item_code = request.getParameter("serv_item_code");	
			if(serv_item_code==null || serv_item_code.equals("&nbsp;")) serv_item_code="";	

			user_name  = request.getParameter("user_name");	
			if(user_name==null) user_name="";	

			user_pasword  = request.getParameter("pass_wrd");	
			if(user_pasword==null) user_pasword="";	

//			System.out.println("in validation user_name" +user_name);
//			System.out.println("validation blng_serv_code" +blng_serv_code);
//			System.out.println("validation serv_item_code" +serv_item_code);
//			System.out.println("validation user_pasword" +user_pasword);
/* commented and moved above for PE Changes	
			try
			{		
				String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
				pstmt=con.prepareStatement(query_date);
				rs = pstmt.executeQuery();
				if (rs!=null)
				{
					if (rs.next())
					{
						currdate = rs.getString(1);
					}
				}
				if (rs != null)   rs.close();
				if (pstmt != null)   pstmt.close();
			}
			catch(Exception e)
			{
				System.out.println("error in date" +e);
			}
*/
			try
			{
				if(!user_name.equals(""))
				{
					String valid_user_qry="Select distinct 'Y' From BL_DISC_SERVICE_BY_USER Where User_Id=? And Facility_Id = ? ";

					pstmt=con.prepareStatement(valid_user_qry);
					pstmt.setString(1, user_name);
					pstmt.setString(2, str_facility_id);
					rs = pstmt.executeQuery();
					if (rs!=null)
					{
						rec_found = "N";
//						System.out.println("check");
						if (rs.next())
						{
							valid_user_YN = rs.getString(1);
							rec_found = "Y";
						}	
					}
					if(rec_found.equals("N")) valid_user_YN="N";

					if (rs != null)   rs.close();
					if (pstmt != null)   pstmt.close();
//					System.out.println("valid_user_YN:"+valid_user_YN);
				}
				
				if(valid_user_YN.equals("Y"))
				{
					if(!user_name.equals("") && !user_pasword.equals(""))
					{
						String query_pswd="select upper(app_password.decrypt(APPL_USER_PASSWORD)) as password from sm_appl_user where appl_user_id= ?";
						pstmt=con.prepareStatement(query_pswd);
						pstmt.setString(1, user_name);
						rs = pstmt.executeQuery();
						if (rs!=null)
						{
							rec_found = "N";
							if (rs.next())
							{
								p_user_pasword = rs.getString(1);
								rec_found = "Y";
							}
						}
						if(rec_found.equals("N")) p_user_pasword="N";
						if (rs != null)   rs.close();
						if (pstmt != null)   pstmt.close();

						if(!user_pasword.equalsIgnoreCase(p_user_pasword))
						{
							valid_user_pass_YN = "N";
						}
						else
						{
							valid_user_pass_YN = "Y";
						}
//					System.out.println("valid_user_pass_YN:"+valid_user_pass_YN);
					}
				}
				
				if(valid_user_YN.equals("Y") && valid_user_pass_YN.equals("Y"))
				{
					CallableStatement  call = 
					con.prepareCall("{ ? = call  blcore.Check_Service_discount(?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?,?)}");	
					call.registerOutParameter(1,java.sql.Types.VARCHAR);
					call.setString(2,str_facility_id);
					call.setString(3,blng_serv_code);
					call.setString(4,user_name);
					call.setString(5,currdate);
					if(module_id.equals("PH") || module_id.equals("ST") || module_id.equals("PS") || module_id.equals("MM"))
					{
						call.setString(6,serv_item_code);
					}
					else
					{
						call.setString(6,strNull);
					}
					call.registerOutParameter(7,java.sql.Types.VARCHAR);
					call.registerOutParameter(8,java.sql.Types.VARCHAR);
					call.registerOutParameter(9,java.sql.Types.VARCHAR);
					call.registerOutParameter(10,java.sql.Types.VARCHAR);
					call.execute();				
					
					discount_allowed_yn = call.getString(1);		
					if(discount_allowed_yn==null) discount_allowed_yn="N";

					str_serv_max_disc_per = call.getString(7);		
					if(str_serv_max_disc_per==null) str_serv_max_disc_per="";

					str_serv_max_disc_amt = call.getString(8);		
					if(str_serv_max_disc_amt==null) str_serv_max_disc_amt="";

					str_payer_max_disc_per = call.getString(9);		
					if(str_payer_max_disc_per==null) str_payer_max_disc_per="";

					str_payer_max_disc_amt = call.getString(10);		
					if(str_payer_max_disc_amt==null) str_payer_max_disc_amt="";

					call.close();	
//					System.out.println("in user_pass discount_allowed_yn from validation :"+discount_allowed_yn); 
//					System.out.println("in user_pass str_serv_max_disc_per:"+str_serv_max_disc_per);
//					System.out.println("in user_pass str_serv_max_disc_amt:"+str_serv_max_disc_amt);
//					System.out.println("in user_pass str_payer_max_disc_per:"+str_payer_max_disc_per);
//					System.out.println("in user_pass str_payer_max_disc_amt:"+str_payer_max_disc_amt);
				}
			}
			catch(Exception ul)
			{
				System.out.println("Exception in user validation : "+ul);
			}			
			
			if(valid_user_YN.equals("N"))
			{
				out_msg = "BL2095";
			}
			else
			{
				out_msg = " ";
			}

			if(valid_user_pass_YN.equals("N"))
			{
				out_msg = out_msg+"|"+"BL1232";
			}
			else
			{
				out_msg = out_msg+"|"+" ";
			}

			if(discount_allowed_yn.equals("N"))
			{
				out_msg = out_msg+"|"+"BL6275";
			}
			else
			{
				out_msg = out_msg+"|"+" ";
			}

			if(valid_user_YN.equals("Y") && valid_user_pass_YN.equals("Y"))
			{
				out_msg = out_msg+"|"+str_serv_max_disc_per+"|"+str_serv_max_disc_amt+"|"+str_payer_max_disc_per+"|"+str_payer_max_disc_amt+"|";
			}

//			System.out.println("out_msg:"+out_msg);

			out.println(out_msg);
		}
		else if(called_frm.equals("disc_amt"))
		{
			try
			{
//				System.out.println("Inside disc_amt");
				
				str_disc_amt = request.getParameter("disc_amt");	
				if(str_disc_amt==null) str_disc_amt="0";	
				disc_amt=Double.parseDouble(str_disc_amt);
//				System.out.println("str_disc_amt:"+str_disc_amt);

				str_act_gross_amt  = request.getParameter("act_gross_amt");	
				if(str_act_gross_amt==null) str_act_gross_amt="0";	
//				System.out.println("str_act_gross_amt:"+str_act_gross_amt);
				
				str_serv_max_disc_per  = request.getParameter("serv_max_disc_per");	
				if(str_serv_max_disc_per==null) str_serv_max_disc_per="";	
//				System.out.println("str_serv_max_disc_per:"+str_serv_max_disc_per);

				str_serv_max_disc_amt  = request.getParameter("serv_max_disc_amt");	
				if(str_serv_max_disc_amt==null) str_serv_max_disc_amt="";	
//				System.out.println("str_serv_max_disc_amt:"+str_serv_max_disc_amt);

				str_payer_max_disc_per  = request.getParameter("payer_max_disc_per");	
				if(str_payer_max_disc_per==null) str_payer_max_disc_per="";	
//				System.out.println("str_payer_max_disc_per:"+str_payer_max_disc_per);

				str_payer_max_disc_amt  = request.getParameter("payer_max_disc_amt");	
				if(str_payer_max_disc_amt==null) str_payer_max_disc_amt="";	
//				System.out.println("str_payer_max_disc_amt:"+str_payer_max_disc_amt);

				String str_called_frm_frame  = request.getParameter("called_frm_frame");	
				if(str_called_frm_frame==null) str_called_frm_frame="";	

//				System.out.println("str_called_frm_frame:"+str_called_frm_frame);

				CallableStatement  call = 
				con.prepareCall("{ ? = call  BLCORE.Get_Max_Disc_Allowed(?,?,?,?,?,?,?)}");	
				call.registerOutParameter(1,java.sql.Types.VARCHAR);
				call.setString(2,str_called_frm_frame);//(S)ervice or (P)ayer frame
				call.setString(3,str_act_gross_amt);
				call.setString(4,str_disc_amt);
				call.setString(5,str_serv_max_disc_per);
				call.setString(6,str_serv_max_disc_amt);
				call.setString(7,str_payer_max_disc_per);
				call.setString(8,str_payer_max_disc_amt);
				call.execute();				
				
				str_max_allowed_limit = call.getString(1);		

				System.out.println(" str_max_allowed_limit "+str_max_allowed_limit); 
				if(str_max_allowed_limit==null) 		str_max_allowed_limit="0";
				else
				{
					
					
//				System.out.println("max_allowed_limit from validation :"+max_allowed_limit); 

				if (!str_max_allowed_limit.equals("") )
				{
					max_allowed_limit = Double.parseDouble(str_max_allowed_limit);
					if( Math.abs(disc_amt) > Math.abs(max_allowed_limit))
					{
//						System.out.println("Error Messg");
						out_msg="BL6316";
					}
				}
				}
				
				call.close();	

			
				out.println(out_msg);
			}
			catch(Exception e)
			{
				System.out.println("Error in disc_amt loop:"+e);
			}
		}
		else if(called_frm.equals("refresh_payer_disc"))
		{
			String sel_rec= request.getParameter("sel_rec");	
			if(sel_rec==null) sel_rec="0";	

			String trx_doc_ref= request.getParameter("trx_doc_ref");	
			if(trx_doc_ref==null) trx_doc_ref="";	

			String trx_doc_ref_line_no= request.getParameter("trx_doc_ref_line_no");	
			if(trx_doc_ref_line_no==null) trx_doc_ref_line_no="";	

			String trx_doc_ref_seq_no= request.getParameter("trx_doc_ref_seq_no");	
			if(trx_doc_ref_seq_no==null) trx_doc_ref_seq_no="";	

			String str_patient_id= request.getParameter("patient_id");	
			if(str_patient_id==null) str_patient_id="";	

			String str_episode_type= request.getParameter("episode_type");	
			if(str_episode_type==null) str_episode_type="";	

			String str_episode_id= request.getParameter("episode_id");	
			if(str_episode_id==null) str_episode_id="";	

			String str_visit_id= request.getParameter("visit_id");	
			if(str_visit_id==null) str_visit_id="";	

//			System.out.println("sel_rec:"+sel_rec);
//			System.out.println("trx_doc_ref:"+trx_doc_ref);
//			System.out.println("trx_doc_ref_line_no:"+trx_doc_ref_line_no);

			String strsql = "select UPD_GROSS_CHARGE_AMT,NVL(UPD_DISC_AMT,0),UPD_NET_CHARGE_AMT,ACT_GROSS_AMT from bl_patient_charges_folio"
			+" where operating_facility_id = ?"
			+" and episode_type = ?"
			+" and patient_id   = ?" 
			//Commented V180313-Aravindh/BL-MMS-DM-CRF-0118.1/IN66901 start
			/* +" and episode_id = NVL('"+str_episode_id+"',EPISODE_ID)"
			+" and visit_id   = NVL('"+str_visit_id+"',VISIT_ID)" */
			//Commented V180313-Aravindh/BL-MMS-DM-CRF-0118.1/IN66901 end
			//Added V180313-Aravindh/BL-MMS-DM-CRF-0118.1/IN66901 start
			+" AND ((? IN ('O', 'E') AND episode_id = NVL (?, episode_id) AND visit_id = NVL (?, visit_id))"
			+" OR (? IN ('I', 'D') AND episode_id = NVL (?, episode_id)) OR ? = 'R')"
			//Added V180313-Aravindh/BL-MMS-DM-CRF-0118.1/IN66901 end
			+" and TRX_DOC_REF = ?"
			+" and TRX_DOC_REF_LINE_NUM = ?"
			+" and TRX_DOC_REF_SEQ_NUM = ?"
			+" and nvl(confirmed_yn,'N')='Y'"
			+" and nvl(billed_flag,'N') != 'Y'"
			+" and bill_doc_type_code is null"
			+" and ( nvl(package_ind,'X') = 'S' or (nvl(package_trx_ind,'X')='Y' and nvl(package_ind,'X') = 'P') )"
			+" and nvl(trx_finalize_ind,'N')= 'Y'" 
			+" and nvl(ins_pkg_pat_ind,'N') != 'K'"
			+" and bill_doc_type_code is null"
			+" and (nvl(trx_status,'N')<>'C'" 
			+" or ( nvl(trx_status,'N')='C' and ( ( REV_ADJ_TRX_IND in ('R', 'B','A') and (ORIG_DOC_REF, ORIG_DOC_REF_LINE_NUM,ORIG_DOC_REF_SEQ_NUM) in (select trx_doc_ref,trx_doc_ref_line_num,TRX_DOC_REF_SEQ_NUM from bl_patient_charges_folio where trx_status = 'C' and bill_doc_type_code is not null and operating_facility_id = ? and patient_id = ? AND ( (? IN('O','E') and episode_id = NVL(?,EPISODE_ID) and visit_id   = NVL(?,VISIT_ID)) OR ( ? IN('I','D') and episode_id = NVL(?,EPISODE_ID)) OR ? = 'R'))) or ( (trx_doc_ref,trx_doc_ref_line_num,TRX_DOC_REF_SEQ_NUM) in ( select ORIG_DOC_REF, ORIG_DOC_REF_LINE_NUM ,ORIG_DOC_REF_SEQ_NUM from bl_patient_charges_folio where trx_status = 'C' and operating_facility_id = ? and patient_id = ? and ( (? IN('O','E') and episode_id = NVL(?,EPISODE_ID) and visit_id   = NVL(?,VISIT_ID)) OR(? IN('I','D') and episode_id = NVL(?,EPISODE_ID)) or ? = 'R' ) and bill_doc_type_code is not null and ORIG_DOC_REF is not null )))))";

			System.out.println("strsql Payer:"+strsql);	

			/* Added V180116-Aravindh/MMSVAT Starts*/
			String sql_addl_charge_for_payer= " Select DECODE (RULE_COVERAGE, 'E', RULE_COVERAGE, 'Y'), Sum(Nvl(Addl_Charge_Amt,0)) From  BL_PAT_CHRG_FOLIO_ADDL_CHARGE"
					+" where TRX_DOC_REF = ? and TRX_DOC_REF_LINE_NUM = ? and Trx_Doc_Ref_Seq_Num = ?"
					+" and operating_facility_id= ? AND rule_code IS NOT NULL group by DECODE (RULE_COVERAGE, 'E', RULE_COVERAGE, 'Y')";
			
			/* Added V180116-Aravindh/MMSVAT Ends*/
			/* Fixed SQL Injection for Common-ICN-0222 */
			//stmt = con.createStatement();
		 	pstmt = con.prepareStatement(strsql);
		 	pstmt.setString(1, str_facility_id);
		 	pstmt.setString(2, str_episode_type);
		 	pstmt.setString(3, str_patient_id);
		 	pstmt.setString(4, str_episode_type);
		 	pstmt.setString(5, str_episode_id);
		 	pstmt.setString(6, str_visit_id);
		 	pstmt.setString(7, str_episode_type);
		 	pstmt.setString(8, str_episode_id);
		 	pstmt.setString(9, str_episode_type);
		 	pstmt.setString(10, trx_doc_ref);
		 	pstmt.setString(11, trx_doc_ref_line_no);
		 	pstmt.setString(12, trx_doc_ref_seq_no);
		 	pstmt.setString(13, str_facility_id);
		 	pstmt.setString(14, str_patient_id);
		 	pstmt.setString(15, str_episode_type);
		 	pstmt.setString(16, str_episode_id);
		 	pstmt.setString(17, str_visit_id);
		 	pstmt.setString(18, str_episode_type);
		 	pstmt.setString(19, str_episode_id);
		 	pstmt.setString(20, str_episode_type);
		 	pstmt.setString(21, str_facility_id);
		 	pstmt.setString(22, str_patient_id);
		 	pstmt.setString(23, str_episode_type);
		 	pstmt.setString(24, str_episode_id);
		 	pstmt.setString(25, str_visit_id);
		 	pstmt.setString(26, str_episode_type);
		 	pstmt.setString(27, str_episode_id);
		 	pstmt.setString(28, str_episode_type);
			rs = pstmt.executeQuery() ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					upd_gross_charge_amt = rs.getString(1);
					
					//Added V180301-Aravindh/MMS-JU-SCF-0102 if-else condition
					System.out.println("BLAdhocDiscValidation.jsp->before formatting->upd_gross_charge_amt: "+upd_gross_charge_amt);
					if(amtRoundOff) {
						upd_gross_charge_amt = cf1.formatCurrency(upd_gross_charge_amt, noofdecimal);
					} else {
						upd_gross_charge_amt = BLReportIdMapper.truncateUptoTwoDecimal(upd_gross_charge_amt,noofdecimal);
					}
					System.out.println("BLAdhocDiscValidation.jsp->after formatting->upd_gross_charge_amt: "+upd_gross_charge_amt);

					upd_disc_amt = rs.getString(2);
					
					//Added V180301-Aravindh/MMS-JU-SCF-0102 if-else condition
					System.out.println("BLAdhocDiscValidation.jsp->before formatting->upd_disc_amt: "+upd_disc_amt);
					if(amtRoundOff) {
						upd_disc_amt = cf1.formatCurrency(upd_disc_amt, noofdecimal);
					} else {
						upd_disc_amt = BLReportIdMapper.truncateUptoTwoDecimal(upd_disc_amt,noofdecimal);
					}
					System.out.println("BLAdhocDiscValidation.jsp->after formatting->upd_disc_amt: "+upd_disc_amt);

					upd_net_charge_amt = rs.getString(3);
					
					//Added V180301-Aravindh/MMS-JU-SCF-0102 if-else condition
					System.out.println("BLAdhocDiscValidation.jsp->before formatting->upd_net_charge_amt: "+upd_net_charge_amt);
					if(amtRoundOff) {
						upd_net_charge_amt = cf1.formatCurrency(upd_net_charge_amt, noofdecimal);
					} else {
						upd_net_charge_amt = BLReportIdMapper.truncateUptoTwoDecimal(upd_net_charge_amt,noofdecimal);
					}
					System.out.println("BLAdhocDiscValidation.jsp->after formatting->upd_net_charge_amt: "+upd_net_charge_amt);

					str_act_gross_amt = rs.getString(4);
					
					//Added V180301-Aravindh/MMS-JU-SCF-0102 if-else condition
					System.out.println("BLAdhocDiscValidation.jsp->before formatting->str_act_gross_amt: "+str_act_gross_amt);
					if(amtRoundOff) {
						str_act_gross_amt = cf1.formatCurrency(str_act_gross_amt, noofdecimal);
					} else {
						str_act_gross_amt = BLReportIdMapper.truncateUptoTwoDecimal(str_act_gross_amt,noofdecimal);
					}
					System.out.println("BLAdhocDiscValidation.jsp->after formatting->str_act_gross_amt: "+str_act_gross_amt);

//					System.out.println("Payer upd_gross_charge_amt:"+upd_gross_charge_amt);
//					System.out.println("Payer upd_disc_amt:"+upd_disc_amt);
//					System.out.println("Payer upd_net_charge_amt:"+upd_net_charge_amt);
//					System.out.println("Payer str_act_gross_amt:"+str_act_gross_amt);
				}
			}
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			/* Added V180116-Aravindh/MMSVAT Starts*/
			/* Fixed SQL Injection for Common-ICN-0222 */
			pstmt = con.prepareStatement(sql_addl_charge_for_payer);
			pstmt.setString(1, trx_doc_ref);
		 	pstmt.setString(2, trx_doc_ref_line_no);
		 	pstmt.setString(3, trx_doc_ref_seq_no);
		 	pstmt.setString(4, str_facility_id);
			rs = pstmt.executeQuery() ;
			if( rs != null ) 
			{
				while( rs.next() )
				{
					str_addl_chrg_amt = rs.getString(2);
				}
			}
			/* Added V180116-Aravindh/MMSVAT Ends*/
			
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
					
			//Added V180301-Aravindh/MMS-JU-SCF-0102 if-else condition
			System.out.println("BLAdhocDiscValidation.jsp->before formatting->str_addl_chrg_amt: "+str_addl_chrg_amt);
			if(amtRoundOff) {
				str_addl_chrg_amt = cf1.formatCurrency(str_addl_chrg_amt, noofdecimal);
			} else {
				str_addl_chrg_amt = BLReportIdMapper.truncateUptoTwoDecimal(str_addl_chrg_amt,noofdecimal);
			}
			System.out.println("BLAdhocDiscValidation.jsp->after formatting->str_addl_chrg_amt: "+str_addl_chrg_amt);
			
			/* Added V180116-Aravindh/MMSVAT 'str_addl_chrg_amt' variable */
			out_msg = upd_gross_charge_amt+"|"+upd_disc_amt+"|"+upd_net_charge_amt+"|"+str_act_gross_amt+"|"+str_addl_chrg_amt;
			out.println(out_msg);
		}
		else if(called_frm.equals("refresh_serv_disc"))
		{
			String sel_rec= request.getParameter("sel_rec");	
			if(sel_rec==null) sel_rec="0";	

			String trx_doc_ref= request.getParameter("trx_doc_ref");	
			if(trx_doc_ref==null) trx_doc_ref="";	

			String trx_doc_ref_line_no= request.getParameter("trx_doc_ref_line_no");	
			if(trx_doc_ref_line_no==null) trx_doc_ref_line_no="";	

			String str_patient_id= request.getParameter("patient_id");	
			if(str_patient_id==null) str_patient_id="";	

			String str_episode_type= request.getParameter("episode_type");	
			if(str_episode_type==null) str_episode_type="";	

			String str_episode_id= request.getParameter("episode_id");	
			if(str_episode_id==null) str_episode_id="";	

			String str_visit_id= request.getParameter("visit_id");	
			if(str_visit_id==null) str_visit_id="";	

//			System.out.println("sel_rec:"+sel_rec);
//			System.out.println("trx_doc_ref:"+trx_doc_ref);

			String strsql="Select SUM(UPD_GROSS_CHARGE_AMT),SUM(UPD_DISC_AMT),SUM(UPD_NET_CHARGE_AMT),SUM(ACT_GROSS_AMT) From Bl_Patient_Charges_Folio" 
			+" where operating_facility_id = ?" 
			+" and episode_type = ?" 
			+" and patient_id   = ?"
			//Commented V180313-Aravindh/BL-MMS-DM-CRF-0118.1/IN66901 start
			/* +" and episode_id = NVL('"+str_episode_id+"',EPISODE_ID)" 
			+" and visit_id   = NVL('"+str_visit_id+"',VISIT_ID)" */
			//Commented V180313-Aravindh/BL-MMS-DM-CRF-0118.1/IN66901 end
			//Added V180313-Aravindh/BL-MMS-DM-CRF-0118.1/IN66901 start
			+" AND ((? IN ('O', 'E') AND episode_id = NVL (?, episode_id) AND visit_id = NVL (?, visit_id))"
			+" OR (? IN ('I', 'D') AND episode_id = NVL (?, episode_id)) OR ? = 'R')"
			//Added V180313-Aravindh/BL-MMS-DM-CRF-0118.1/IN66901 end
			+" and TRX_DOC_REF = ?"
			+" and TRX_DOC_REF_LINE_NUM = ?"
			+" and nvl(confirmed_yn,'N')='Y'" 
			+" and nvl(billed_flag,'N') != 'Y'" 
			+" and bill_doc_type_code is null" 
			+" and (nvl(package_ind,'X') = 'S' or (nvl(package_trx_ind,'X')='Y' and nvl(package_ind,'X') = 'P') )" 
			+" and nvl(trx_finalize_ind,'N')= 'Y'"  
			+" and nvl(ins_pkg_pat_ind,'N') != 'K'" 
			+" and bill_doc_type_code is null" 
			+" and (nvl(trx_status,'N')<>'C'"  
			+" or ( nvl(trx_status,'N')='C'"  
			+" and ( ( REV_ADJ_TRX_IND in ('R', 'B','A')"  
		    +" and (ORIG_DOC_REF, ORIG_DOC_REF_LINE_NUM,ORIG_DOC_REF_SEQ_NUM) in" 
			+" (select trx_doc_ref,trx_doc_ref_line_num,TRX_DOC_REF_SEQ_NUM"  
            +" from bl_patient_charges_folio where trx_status = 'C'" 
            +" and bill_doc_type_code is not null" 
            +" and operating_facility_id = ?" 
            +" and patient_id = ?"  
            +" AND ( (? IN('O','E') and episode_id = NVL(?,EPISODE_ID) and visit_id   = NVL(?,VISIT_ID) )" 
            +" OR ( ? IN('I','D') and episode_id = NVL(?,EPISODE_ID))" 
			+" OR ? = 'R') ))" 
			+" OR ( (trx_doc_ref,trx_doc_ref_line_num,TRX_DOC_REF_SEQ_NUM) in" 
			+" ( select ORIG_DOC_REF, ORIG_DOC_REF_LINE_NUM ,ORIG_DOC_REF_SEQ_NUM" 
           	+" from bl_patient_charges_folio"  
            +" where trx_status = 'C' "           		
            +" and operating_facility_id = ? " 
           	+" and patient_id = ? " 
            +" and ( (? IN('O','E') and episode_id = NVL(?,EPISODE_ID) and visit_id   = NVL(?,VISIT_ID))" 
            +" OR(? IN('I','D') and episode_id = NVL(?,EPISODE_ID))" 
            +" OR ? = 'R' )" 
           	+" and bill_doc_type_code is not null" 
           	+" and ORIG_DOC_REF is not null"  
            +" )))))"  
			+" GROUP BY TRX_DOC_REF,TRX_DOC_REF_LINE_NUM,BLNG_SERV_CODE,to_char(SERVICE_DATE,'dd/mm/yyyy HH24:MI:SS')";

			System.out.println("strsql Service:"+strsql);	
			
			/* Fixed SQL Injection for Common-ICN-0222 */
			//stmt = con.createStatement();
			pstmt = con.prepareStatement(strsql);
		 	pstmt.setString(1, str_facility_id);
		 	pstmt.setString(2, str_episode_type);
		 	pstmt.setString(3, str_patient_id);
		 	pstmt.setString(4, str_episode_type);
		 	pstmt.setString(5, str_episode_id);
		 	pstmt.setString(6, str_visit_id);
		 	pstmt.setString(7, str_episode_type);
		 	pstmt.setString(8, str_episode_id);
		 	pstmt.setString(9, str_episode_type);
		 	pstmt.setString(10, trx_doc_ref);
		 	pstmt.setString(11, trx_doc_ref_line_no);
		 	pstmt.setString(12, str_facility_id);
		 	pstmt.setString(13, str_patient_id);
		 	pstmt.setString(14, str_episode_type);
		 	pstmt.setString(15, str_episode_id);
		 	pstmt.setString(16, str_visit_id);
		 	pstmt.setString(17, str_episode_type);
		 	pstmt.setString(18, str_episode_id);
		 	pstmt.setString(19, str_episode_type);
		 	pstmt.setString(20, str_facility_id);
		 	pstmt.setString(21, str_patient_id);
		 	pstmt.setString(22, str_episode_type);
		 	pstmt.setString(23, str_episode_id);
		 	pstmt.setString(24, str_visit_id);
		 	pstmt.setString(25, str_episode_type);
		 	pstmt.setString(26, str_episode_id);
		 	pstmt.setString(27, str_episode_type);
			rs = pstmt.executeQuery() ;
			//rs = stmt.executeQuery(strsql) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					upd_gross_charge_amt = rs.getString(1);
					//Added V180301-Aravindh/MMS-JU-SCF-0102 if-else condition
					System.out.println("BLAdhocDiscValidation.jsp->before formatting->upd_gross_charge_amt: "+upd_gross_charge_amt);
					if(amtRoundOff) {
						upd_gross_charge_amt = cf1.formatCurrency(upd_gross_charge_amt, noofdecimal);
					} else {
						upd_gross_charge_amt = BLReportIdMapper.truncateUptoTwoDecimal(upd_gross_charge_amt,noofdecimal);
					}
					System.out.println("BLAdhocDiscValidation.jsp->after formatting->upd_gross_charge_amt: "+upd_gross_charge_amt);

					upd_disc_amt = rs.getString(2);
					//Added V180301-Aravindh/MMS-JU-SCF-0102 if-else condition
					System.out.println("BLAdhocDiscValidation.jsp->before formatting->upd_disc_amt: "+upd_disc_amt);
					if(amtRoundOff) {
						upd_disc_amt = cf1.formatCurrency(upd_disc_amt, noofdecimal);
					} else {
						upd_disc_amt = BLReportIdMapper.truncateUptoTwoDecimal(upd_disc_amt,noofdecimal);
					}
					System.out.println("BLAdhocDiscValidation.jsp->after formatting->upd_disc_amt: "+upd_disc_amt);

					upd_net_charge_amt = rs.getString(3);
					//Added V180301-Aravindh/MMS-JU-SCF-0102 if-else condition
					System.out.println("BLAdhocDiscValidation.jsp->before formatting->upd_net_charge_amt: "+upd_net_charge_amt);
					if(amtRoundOff) {
						upd_net_charge_amt = cf1.formatCurrency(upd_net_charge_amt, noofdecimal);
					} else {
						upd_net_charge_amt = BLReportIdMapper.truncateUptoTwoDecimal(upd_net_charge_amt,noofdecimal);
					}
					System.out.println("BLAdhocDiscValidation.jsp->after formatting->upd_net_charge_amt: "+upd_net_charge_amt);

					str_act_gross_amt = rs.getString(4);
					//Added V180301-Aravindh/MMS-JU-SCF-0102 if-else condition
					System.out.println("BLAdhocDiscValidation.jsp->before formatting->str_act_gross_amt: "+str_act_gross_amt);
					if(amtRoundOff) {
						str_act_gross_amt = cf1.formatCurrency(str_act_gross_amt, noofdecimal);
					} else {
						str_act_gross_amt = BLReportIdMapper.truncateUptoTwoDecimal(str_act_gross_amt,noofdecimal);
					}
					System.out.println("BLAdhocDiscValidation.jsp->after formatting->str_act_gross_amt: "+str_act_gross_amt);

//					System.out.println("Serv upd_gross_charge_amt:"+upd_gross_charge_amt);
//					System.out.println("Serv upd_disc_amt:"+upd_disc_amt);
//					System.out.println("Serv upd_net_charge_amt:"+upd_net_charge_amt);
//					System.out.println("Serv str_act_gross_amt:"+str_act_gross_amt);
				}
			}
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

			out_msg = upd_gross_charge_amt+"|"+upd_disc_amt+"|"+upd_net_charge_amt+"|"+str_act_gross_amt;
			out.println(out_msg);
		}
	}
	catch(Exception ee)
	{
	  System.out.println("Error in edit Adhoc disc " +ee);
	}
	finally 
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
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
