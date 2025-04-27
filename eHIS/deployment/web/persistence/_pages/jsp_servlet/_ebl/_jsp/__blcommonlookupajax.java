package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import eBL.Common.*;
import org.jaxen.util.FollowingAxisIterator;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;

public final class __blcommonlookupajax extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLCommonLookupAjax.jsp", 1719902910000L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\r\n\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
 
	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block1Bytes, _wl_block1);

	System.err.println("IN BLCommonLookupAjax.jsp");
	Connection con = null;
	PreparedStatement pstmt = null;
	CallableStatement csmt = null;
	ResultSet rs = null;
	String called_for = request.getParameter("called_for");
	String search_criteria = request.getParameter("search_criteria");
	String strWhereColumnType = request.getParameter("strWhereColumnType");
	String strWhereColumn = request.getParameter("strWhereColumn");
	String search_text = request.getParameter("search_text");
	String searchBy = request.getParameter("searchBy");
	String facility_id = request.getParameter("facility_id");
	String seqNoString = request.getParameter("seqNoString");
	String locale = request.getParameter("locale");
	System.err.println("QueryString : "+request.getQueryString());
	System.err.println("searchBy : "+searchBy);
	
	String sql = "";
	String procSql = "";
	String userWhereClause = "";
	List searchData = null;
	int column_count = 0;
	String pAge = "";
	String returnText = "";
	String err_out   = "";                  
	String err_code = "";                  
	String message_text  = "";
	String condVal="";
	//Calling blcore.bl_get_age function for getting patient Age
	if(called_for.equals("INS_BLNG_GRP_ID") || called_for.equals("NON_INS_BLNG_GRP_ID") || called_for.equals("PRI_BLNG_GRP_ID") ){ 
		String patient_id = request.getParameter("patient_id");
		String episode_type = request.getParameter("episode_type");
		String episodeId = request.getParameter("episodeId");
		String visitId = request.getParameter("visitId");
		sql = "select blcore.bl_get_age(?,?,?,?,?) xAge from dual";
		try{
			con = ConnectionManager.getConnection();
			
			System.err.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, facility_id);					
			pstmt.setString(2, patient_id);						
			pstmt.setString(3, episode_type);						
			pstmt.setString(4, episodeId);			
			pstmt.setString(5, visitId);				
			
			rs = pstmt.executeQuery();
			while(rs!= null && rs.next()){
		  		pAge = rs.getString("xAge") == null ? "" : rs.getString("xAge");
	        }
			System.err.println("Patient Age: "+pAge);
			
		}catch(Exception ex){
			if(pstmt != null)	pstmt.close();
			if(rs != null) rs.close();
			ConnectionManager.returnConnection(con,request);
		}
	}
	
	//Assigning the sql query for called Lookups
	if(called_for.equals("ENC_ID_LKUP")){
		String patient_id = request.getParameter("patient_id");
		String episode_type = request.getParameter("episode_type");
		
		if("I".equals(episode_type) || "D".equals(episode_type)){
		//	sql = "SELECT ENCOUNTER_ID code,PATIENT_ID description FROM bl_episode_fin_dtls WHERE OPERATING_FACILITY_ID = ?";
		sql="select episode_id code,PATIENT_ID description from ip_episode where facility_id = ? and nvl(episode_status,'X') != '9' ";
			condVal="upper(EPISODE_ID)";
		}
		else if("O".equals(episode_type) || "E".equals(episode_type)){
			sql="select (EPISODE_ID||lpad(LAST_VISIT_ID,4,'0')) code,PATIENT_ID description from op_episode where OPERATING_FACILITY_ID = ? ";
			condVal="upper((EPISODE_ID||lpad(LAST_VISIT_ID,4,'0')))";
		}
		//	sql = "SELECT ENCOUNTER_ID code,PATIENT_ID description FROM bl_visit_fin_dtls WHERE OPERATING_FACILITY_ID = ?";
		if(!"".equals(patient_id)){
			sql = sql + " AND PATIENT_ID = ?";
		}
		
		if(!"".equals(episode_type) && !"A".equals(episode_type)){
			sql = sql + " AND EPISODE_TYPE = ?";
		}	
		/* if("I".equals(episode_type) || "D".equals(episode_type)){
				sql=sql+" upper(EPISODE_ID) like upper(?)";
		}else if("O".equals(episode_type) || "E".equals(episode_type)){
			sql = sql + " AND upper((EPISODE_ID||lpad(LAST_VISIT_ID,4,'0'))) like upper(?)";
		}  */
		System.err.println("sql enclkup: "+sql);
	}else if(called_for.equals("NON_INS_BLNG_GRP_ID")){
		String cash_leg = "Cash";
		String credit_leg = "Credit";
		String sponsor_leg = "Sponsor";
		String ins_leg = "Insurance";
		
		sql = "SELECT code, description FROM (  select a.blng_grp_id code, a.short_desc||' ('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' description FROM bl_blng_grp_lang_vw a "
			   +"WHERE (   (NVL (a.settlement_ind, '1') = 'X' AND a.adm_rec_flag = '1') "
			          +"OR NVL (a.settlement_ind, '1') = 'C' "
			          +"OR NVL (a.settlement_ind, '1') = 'R' "
			          +") "
			    +"AND NVL (a.status, 'X') != 'S' "
			    		+"AND a.language_id = ? "
			    		+"AND (   (? = 'E' AND NVL (a.ae_yn, 'N') = 'Y' ) "
			    				+"OR ( ? = 'O' AND NVL (a.op_yn, 'N') = 'Y') "
			    				 +"    OR ( ? = 'R' AND NVL (a.ref_yn, 'N') = 'Y' ) "
			    			      +"    OR ( ? = 'I' AND NVL (a.ip_yn, 'N') = 'Y' ) "
			    			      +"    OR ( ? = 'D' AND NVL (a.dy_yn, 'N') = 'Y' )) "
			    		+"AND NVL (a.CATEGORY, 'UNRESTRICTED') IN "
			    		+"(NVL (blcommon.get_reln_code (?), 'UNRESTRICTED'), 'UNRESTRICTED' ) "
			    		+"AND NVL (a.package_yn, 'N') <> 'Y' "
			    		+"AND a.blng_grp_id <> '**' "
			    		+"AND ( (    a.blng_grp_id NOT IN ( "
				    		+"        	SELECT b.blng_grp_id FROM bl_blng_grp_res_by_user b "
					    		+"          WHERE UPPER (b.user_id) = UPPER (?) "
					    		+"           AND b.blng_grp_id = a.blng_grp_id "
					    		+"           AND TRUNC (SYSDATE) BETWEEN b.restrict_date_from AND NVL (b.restrict_date_to,TRUNC (SYSDATE))) "
			    				+"AND blcommon.is_function_applicable_yn('BL','BL_BLNG_GRP_RESTRICT_FOR_USER' ) = 'Y' ) "
			    			+"OR (blcommon.is_function_applicable_yn ('BL','BL_BLNG_GRP_RESTRICT_FOR_USER') = 'N' ) ) "
			    		+"AND (   (blcommon.is_function_applicable_yn ('BL', 'BL_BLNG_GRP_FACILITY') = 'N') "
			    			+"OR (    (blcommon.is_function_applicable_yn ('BL', 'BL_BLNG_GRP_FACILITY') = 'Y') "
			    				+"AND (blng_grp_id IN ( SELECT b.blng_grp_id FROM bl_blng_grp_facility b WHERE b.facility_id = ?)))) "
			      +"AND (( NVL (?, 0) BETWEEN NVL (a.age_from, 0) AND NVL (a.age_to, 999) AND NVL (a.age_req_yn, 'N') = 'Y' ) "
			      			+"OR (NVL (a.age_req_yn, 'N') = 'N') ) ) b WHERE 1=1  ";
			     // +"ORDER BY 2"
	}else if("BILLING_CATG_LOOKUP".equals(called_for) || called_for.equals("PRI_BILLING_CATG_LOOKUP")){
		if("PRI_BILLING_CATG_LOOKUP".equals(called_for)){
			sql = "select code, description from (select nvl (SHORT_DESC,' ') description, nvl (BLNG_GRP_CATG,' ') code from BL_BLNG_GRP_CATG_LANG_VW where language_id = ?) where 1=1 ";
		}
		
		if("BILLING_CATG_LOOKUP".equals(called_for)){
			sql = "select code, description from (select nvl (SHORT_DESC,' ') description, nvl (BLNG_GRP_CATG,' ') code from BL_BLNG_GRP_CATG_LANG_VW where language_id = ? and BLNG_GRP_CATG in (select distinct b.BLNG_GRP_CATG from bl_blng_grp_by_catg b, bl_blng_grp c where B.BLNG_GRP_ID = C.BLNG_GRP_ID and c.SETTLEMENT_IND = 'X' and c.adm_rec_flag = '2')) where 1=1 ";
		}
	}else if(called_for.equals("INS_BLNG_GRP_ID")){
		String cash_leg = "Cash";
		String credit_leg = "Credit";
		String sponsor_leg = "Sponsor";
		String ins_leg = "Insurance";
		
		sql = "SELECT code, description, capture_ref_source_dtl_yn, ref_source_main_mand_yn, ref_source_sub_mand_yn FROM (SELECT a.blng_grp_id code, a.short_desc||' ('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' description ,NVL (a.capture_ref_source_dtl_yn, 'N') capture_ref_source_dtl_yn,NVL (a.ref_source_main_mand_yn, 'N') ref_source_main_mand_yn,NVL (a.ref_source_sub_mand_yn, 'N') ref_source_sub_mand_yn "
			      +"FROM bl_blng_grp_lang_vw a, bl_blng_grp_by_catg d "
			 	  +"WHERE NVL (a.status, 'X') != 'S' "
			      +"AND a.language_id = ? "
				  +" AND a.settlement_ind = 'X'"
				  +" AND a.adm_rec_flag = '2'"
			      +"AND (  ( ? = 'E'  AND NVL (a.ae_yn, 'N') = 'Y' ) "
			      +"    OR ( ? = 'O' AND NVL (a.op_yn, 'N') = 'Y' ) "
			      +"    OR ( ? IS NULL AND NVL (a.ae_yn, 'N') = 'Y' ) "
			      +"    OR ( ? IS NULL AND NVL (a.op_yn, 'N') = 'Y' ) "
			    		  +"    OR ( ? = 'R' AND NVL (a.ref_yn, 'N') = 'Y' ) "
					      +"    OR ( ? = 'I' AND NVL (a.ip_yn, 'N') = 'Y' ) "
					      +"    OR ( ? = 'D' AND NVL (a.dy_yn, 'N') = 'Y' ) "
			       		+") "
			     +"AND NVL (a.CATEGORY, 'UNRESTRICTED') IN (NVL (blcommon.get_reln_code (?),'UNRESTRICTED' ), 'UNRESTRICTED') "
			     +"AND (   (    a.blng_grp_id NOT IN ( "
			                   +"SELECT b.blng_grp_id FROM bl_blng_grp_res_by_user b WHERE UPPER (b.user_id) = UPPER (?) AND b.blng_grp_id = a.blng_grp_id "
			                   +"AND TRUNC (SYSDATE) BETWEEN b.restrict_date_from AND NVL (b.restrict_date_to,TRUNC (SYSDATE)) )"
			              	   +"AND blcommon.is_function_applicable_yn ('BL', 'BL_BLNG_GRP_RESTRICT_FOR_USER' ) = 'Y') "
			          +"OR (blcommon.is_function_applicable_yn ('BL', 'BL_BLNG_GRP_RESTRICT_FOR_USER' ) = 'N' ) ) "
			    +"AND (   (blcommon.is_function_applicable_yn('BL','BL_BLNG_GRP_FACILITY') = 'N') OR ( (blcommon.is_function_applicable_yn('BL','BL_BLNG_GRP_FACILITY') = 'Y') AND (a.blng_grp_id IN ( SELECT b.blng_grp_id FROM bl_blng_grp_facility b WHERE b.facility_id =  ?) ) ) )"
			    +"AND a.blng_grp_id = d.blng_grp_id(+) "
			    +"AND(   (    blcommon.is_function_applicable_yn ('BL','BL_DISP_BG_CAT_AND_SLMT_TYPE' ) = 'Y' "
			             +" AND ( ( d.blng_grp_catg = ? "
				                 	 +"AND a.settlement_ind = ? "
				                 	 +"AND a.adm_rec_flag = ? "
				                     +"AND ? IS NOT NULL "
				                     +"AND ? IS NOT NULL ) "
			                 	 +"OR (a.settlement_ind = ? "
			                       	 +"AND ? IS NOT NULL "
			                         +"AND ? IS NULL ) "
			                   	+")"
			            +") "
			          	+"OR (blcommon.is_function_applicable_yn('BL','BL_DISP_BG_CAT_AND_SLMT_TYPE') = 'N' ) "
			         +")" 
			   +"AND (  ( NVL (?, 0) BETWEEN NVL(age_from, 0) AND NVL(age_to, 9999) AND NVL (age_req_yn, 'N') = 'Y') OR (NVL (age_req_yn, 'N') = 'N')) ) main WHERE 1=1  ";

	}else if(called_for.equals("PRI_BLNG_GRP_ID")){
		String cash_leg = "Cash";
		String credit_leg = "Credit";
		String sponsor_leg = "Sponsor";
		String ins_leg = "Insurance";
		sql = "SELECT code, description, capture_ref_source_dtl_yn, ref_source_main_mand_yn, ref_source_sub_mand_yn FROM (SELECT a.blng_grp_id code, (a.short_desc||' ('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')') description ,NVL (a.capture_ref_source_dtl_yn, 'N') capture_ref_source_dtl_yn,NVL (a.ref_source_main_mand_yn, 'N') ref_source_main_mand_yn,NVL (a.ref_source_sub_mand_yn, 'N') ref_source_sub_mand_yn "
		      +"FROM bl_blng_grp_lang_vw a, bl_blng_grp_by_catg d "
		 	  +"WHERE NVL (a.status, 'X') != 'S' "
		      +"AND a.language_id = ? "
		      +"AND (  ( ? = 'E'  AND NVL (a.ae_yn, 'N') = 'Y' ) "
		      +"    OR ( ? = 'O' AND NVL (a.op_yn, 'N') = 'Y' ) "
		      +"    OR ( ? IS NULL AND NVL (a.ae_yn, 'N') = 'Y' ) "
		      +"    OR ( ? IS NULL AND NVL (a.op_yn, 'N') = 'Y' ) "
		      +"    OR ( ? = 'R' AND NVL (a.ref_yn, 'N') = 'Y' ) "
		      +"    OR ( ? = 'I' AND NVL (a.ip_yn, 'N') = 'Y' ) "
		      +"    OR ( ? = 'D' AND NVL (a.dy_yn, 'N') = 'Y' ) "
		       		+") "
		     +"AND NVL (a.CATEGORY, 'UNRESTRICTED') IN (NVL (blcommon.get_reln_code (?),'UNRESTRICTED' ), 'UNRESTRICTED') "
		     +"AND (   (    a.blng_grp_id NOT IN ( "
		                   +"SELECT b.blng_grp_id FROM bl_blng_grp_res_by_user b WHERE UPPER (b.user_id) = UPPER (?) AND b.blng_grp_id = a.blng_grp_id "
		                   +"AND TRUNC (SYSDATE) BETWEEN b.restrict_date_from AND NVL (b.restrict_date_to,TRUNC (SYSDATE)) )"
		              	   +"AND blcommon.is_function_applicable_yn ('BL', 'BL_BLNG_GRP_RESTRICT_FOR_USER' ) = 'Y') "
		          +"OR (blcommon.is_function_applicable_yn ('BL', 'BL_BLNG_GRP_RESTRICT_FOR_USER' ) = 'N' ) ) "
		    +"AND (   (blcommon.is_function_applicable_yn('BL','BL_BLNG_GRP_FACILITY') = 'N') OR ( (blcommon.is_function_applicable_yn('BL','BL_BLNG_GRP_FACILITY') = 'Y') AND (a.blng_grp_id IN ( SELECT b.blng_grp_id FROM bl_blng_grp_facility b WHERE b.facility_id =  ?) ) ) )"
		    +"AND a.blng_grp_id = d.blng_grp_id(+) "
		    +"AND(   (    blcommon.is_function_applicable_yn ('BL','BL_DISP_BG_CAT_AND_SLMT_TYPE' ) = 'Y' "
		             +" AND ( ( d.blng_grp_catg = ? "
			                 	 +"AND a.settlement_ind = ? "
			                     +"AND ? IS NOT NULL "
			                     +"AND ? IS NOT NULL ) "
		                 	 +"OR (d.blng_grp_catg = ? "
	                       		 +"AND ? IS NULL "
	                       		 +"AND ? IS NOT NULL ) "
		                   	 +"OR (a.settlement_ind = ? "
		                       	 +"AND ? IS NOT NULL "
		                         +"AND ? IS NULL ) "
		                   	 +"OR (? IS NULL "
		                         +"AND ? IS NULL ) "
		                  +")"
		            +") "
		          	+"OR (blcommon.is_function_applicable_yn('BL','BL_DISP_BG_CAT_AND_SLMT_TYPE') = 'N' ) "
		         +")" 
		   +"AND (  ( NVL (?, 0) BETWEEN NVL(age_from, 0) AND NVL(age_to, 9999) AND NVL (age_req_yn, 'N') = 'Y') OR (NVL (age_req_yn, 'N') = 'N'))) b WHERE 1=1  ";
	}else if(called_for.equals("CUST_GRP_CODE")){
		sql = "select code, description from (SELECT cust_group_code code, short_desc description  FROM ar_cust_group_lang_vw WHERE language_id= ? AND status IS NULL) main where 1=1 ";
	}else if(called_for.equals("CUST_CODE")){
		String settlement_ind = request.getParameter("settlement_ind");
		String adm_rec_flag = request.getParameter("adm_rec_flag");
		String module_id = request.getParameter("module_id");
		String episode_type = request.getParameter("episode_type");
		
		if("X".equals(settlement_ind) && "2".equals(adm_rec_flag)){ // Insurance customers only
			String auto_fin_chk= "N";
			String valid_cust_check = "", valid_pol_check = "";
			HashMap values = new HashMap();
			values.put("episode_type",episode_type);
			values.put("auto_fin_chk","N");

			if(episode_type.equals("R"))
			{
				valid_cust_check = " and (?='MP' and a.ref_yn='Y') ";//Modified against MMS-DM-SCF-0729
				valid_pol_check=" and (?='MP' and nvl(c.external_covered,'N')='Y')";//Modified against MMS-DM-SCF-0729
			}
			else if(episode_type.equals("O"))
			{
				valid_cust_check = " and (?='OP' and a.op_yn='Y') ";//Modified against MMS-DM-SCF-0729
				valid_pol_check=" and (?='OP' and nvl(c.outpatient_cover,'N')='Y')";//Modified against MMS-DM-SCF-0729
			}
			else if(episode_type.equals("E"))
			{
				valid_cust_check = " and (?='AE' and a.op_yn='Y') ";//Modified against MMS-DM-SCF-0729
				valid_pol_check=" and (?='AE' and nvl(c.outpatient_cover,'N')='Y')";//Modified against MMS-DM-SCF-0729
			}
			else if(episode_type.equals("I"))
			{
				valid_cust_check = " and (?='IP' and a.ip_yn='Y') ";//Modified against MMS-DM-SCF-0729
				valid_pol_check=" and (?='IP' and nvl(c.inpatient_covered,'N')='Y')";//Modified against MMS-DM-SCF-0729
			}
			else if(episode_type.equals("D"))
			{
				valid_cust_check = " and (?='DC' and a.ip_yn='Y') ";//Modified against MMS-DM-SCF-0729
				valid_pol_check=" and (?='DC' and nvl(c.inpatient_covered,'N')='Y')";//Modified against MMS-DM-SCF-0729
			}
			
			if(auto_fin_chk.equals("Y"))
			{
				//to be implemented later
			}else{
				sql = "select code, description from (select distinct a.C_CDE code,a.SHORT_NAME description,C_GRP_CDE,C_GRP_NAM,CNY_NAM,RG_NAM,VAL_FRM,VAL_TO,CUR_COD,CUR_DSC from (select distinct d.cust_code C_CDE,a.short_name short_name,b.cust_group_code C_GRP_CDE,b.short_desc C_GRP_NAM,"
							+" blcommon.getcntry(a.country_code,?) cny_nam, blcommon.getregn(a.region_code,?) rg_nam,"
							+" a.VALID_FROM VAL_FRM,a.VALID_TO VAL_TO,a.CURRENCY_CODE CUR_COD,a.CURRENCY_DESC CUR_DSC"
							+" FROM AR_CUSTOMER_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group d,bl_ins_policy_type_hdr c "
							+" WHERE a.acc_entity_code= b.acc_entity_code"
							+" AND b.acc_entity_code= d.acc_entity_code"
							+" AND a.language_id = b.language_id"
							+" AND b.cust_group_code = d.cust_group_code"
							+" AND b.cust_group_code =  ? "
							+" AND operating_facility_id = ?"
							+" AND (c.cust_code = d.cust_code) "+valid_pol_check+" AND c.cust_group_code = d.cust_group_code "
							+" AND a.language_id=?"
							+" AND a.cust_code = d.cust_code"
							+" AND a.patient_flag = 'Y'"
							+" AND NVL(a.pat_com_flag,'N') = 'N'"
							+" AND NVL(a.insurance_yn,'Y') = 'Y'"
							+" AND a.status IS NULL"
							+valid_cust_check							
							+" AND decode(?,'CY',nvl(country_code,'XXXX'),'RN',nvl(region_code,'XXXX'))=nvl(?,decode(?,'CY',nvl(country_code,'XXXX'),'RN',nvl(region_code,'XXXX')))"
							+" UNION ALL "
							+"select distinct d.cust_code C_CDE,a.short_name short_name,b.cust_group_code C_GRP_CDE,b.short_desc C_GRP_NAM,"
							+" blcommon.getcntry(a.country_code,?) cny_nam, blcommon.getregn(a.region_code,?) rg_nam,"
							+" a.VALID_FROM VAL_FRM,a.VALID_TO VAL_TO,a.CURRENCY_CODE CUR_COD,a.CURRENCY_DESC CUR_DSC"
							+" FROM AR_CUSTOMER_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group d,bl_ins_policy_type_hdr c "
							+" WHERE a.acc_entity_code= b.acc_entity_code"
							+" AND b.acc_entity_code= d.acc_entity_code"
							+" AND a.language_id = b.language_id"
							+" AND b.cust_group_code = d.cust_group_code"
							//+" AND a.cust_group_code = ? "
							+" AND b.cust_group_code =  ? "
							+" AND operating_facility_id = ?"
							+" AND (c.cust_code = '**') "+valid_pol_check+" AND c.cust_group_code = d.cust_group_code "
							+" AND a.language_id=?"
							+" AND b.cust_group_code = ?"
							//+" AND a.cust_group_code = '"+cust_grp_code+"'"
							+" AND a.cust_code = d.cust_code"
							+" AND a.patient_flag = 'Y'"
							+" AND NVL(a.pat_com_flag,'N') = 'N'"
							+" AND NVL(a.insurance_yn,'Y') = 'Y'"
							+" AND a.status IS NULL"
							+valid_cust_check							
							+" AND decode(?,'CY',nvl(country_code,'XXXX'),'RN',nvl(region_code,'XXXX'))=nvl(?,decode(?,'CY',nvl(country_code,'XXXX'),'RN',nvl(region_code,'XXXX')))) a where 1=1) where 1=1 ";
			}
			
			//sql=BlRepository.getBlKeyValue("SQL_BL_INS_PAYER_LKUP",values,"INSPAYERLKUP");
			//sql = "select code, description from (SELECT c_cde code, short_name description FROM (" + sql + ") outer ) WHERE 1=1";
			System.err.println("Insurane sql:"+sql);
		} else if("X".equals(settlement_ind) && "1".equals(adm_rec_flag)){ // Sponsor customers only
			sql = "select code, description from (";
			sql = sql + "SELECT c.cust_code, a.short_name description, b.short_desc, a.country_name,c.cust_group_code, a.region_name, a.valid_from, a.valid_to "
		         +"FROM ar_customer_dtl_lang_vw a, ar_cust_group_lang_vw b, bl_cust_by_cust_group c "
		         +"WHERE NVL (patient_flag, 'N') = 'Y' "
		         +"AND NVL (pat_com_flag, 'N') = 'N' "
		         +"AND NVL (?, 'X') = 'X' "
		         +"AND ? = '1' "
		         +"AND NVL (a.insurance_yn, 'N') = 'N' "
		         +"AND a.language_id = b.language_id "
		         +"AND a.language_id = ? "
		         +"AND b.cust_group_code = c.cust_group_code "
		         +"AND a.cust_code = c.cust_code "
		         +"AND b.cust_group_code = NVL (?, b.cust_group_code) "
		         +"AND (   ? = 'N' "
		               +"OR ( ? = 'Y' "
		                   +"AND (c.cust_code, c.cust_group_code) IN ( "
		                         +" SELECT cust_code, cust_group_code FROM bl_patient_package_hdr WHERE operating_facility_id = ? "
		                            +"AND blng_grp_id = ? AND patient_id = ? "
		                        +")"
		                    +")" 
		               +") "
				+"AND a.status IS NULL "
				+" and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')"
							+" or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')"
							+" or (? = 'MP' and nvl(a.ref_yn,'N') = 'Y')) ";
			sql = sql + " ) outer where 1=1 ";
		} else if("R".equals(settlement_ind)){ // Credit customers only
			sql = "select code, description from (";
			sql = sql + "SELECT c.cust_code, a.short_name description, b.short_desc, a.country_name,c.cust_group_code, a.region_name, a.valid_from, a.valid_to "
		         +"FROM ar_customer_dtl_lang_vw a, ar_cust_group_lang_vw b, bl_cust_by_cust_group c "
		         +"WHERE NVL (patient_flag, 'N') = 'Y' "
		         +"AND NVL (pat_com_flag, 'N') = 'Y' "
		         +"AND NVL (?, 'X') = 'R' "
		         +"AND NVL (insurance_yn, 'N') = 'N' "
		         +"AND a.language_id = ? "
				 +"AND a.language_id = b.language_id "
		         +"AND b.cust_group_code = c.cust_group_code "
		         +"AND a.cust_code = c.cust_code "
		         +"AND b.cust_group_code = NVL (?, b.cust_group_code) "
		         +"AND ( ? = 'N' OR ( ? = 'Y' AND (c.cust_code, c.cust_group_code) IN ( "
		                          +"SELECT cust_code, cust_group_code FROM bl_patient_package_hdr WHERE operating_facility_id = ? "
		                            +" AND blng_grp_id = ? AND patient_id = ? "
		                      +")"
		                 +")" 
		             +") "		         
		         +"AND a.status IS NULL "
				 +" and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')"
							+" or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')"
							+" or (? = 'MP' and nvl(a.ref_yn,'N') = 'Y')) ";
			sql = sql + " ) outer where 1=1 ";
		}
	}else if(called_for.equals("POLICY_TYPE_CODE")){
		sql = "select code, description, policy_coverage_basis from (SELECT DISTINCT a.policy_type_code code, a.short_desc description , b.policy_coverage_basis policy_coverage_basis "
           		+"FROM bl_ins_policy_types_lang_vw a,bl_ins_policy_type_hdr b,bl_cust_by_cust_group c "
          		+"WHERE a.language_id = ? "
            	+" AND a.operating_facility_id = ? "
            	+" AND NVL (a.status, 'N') <> 'S' "
            	+" AND a.operating_facility_id = b.operating_facility_id "
            	+" AND a.policy_type_code = b.policy_type_code "
            	+" AND (c.cust_code = ?) "
            	+" AND c.cust_group_code = b.cust_group_code "
            	+" AND (b.cust_code = c.cust_code OR b.cust_code = '**') "
            	+" AND b.cust_group_code = ? "
            	+" AND ( (? IN ('O', 'E') AND NVL (b.outpatient_cover, 'N') = 'Y' )"
            	+" OR   (? IN ('I', 'D') AND NVL (b.inpatient_covered, 'N') = 'Y' )"
            	+" OR   (? IN ('R') AND NVL (b.external_covered, 'N') = 'Y' )"		
				+") ) main where 1=1 "; 
	}else if(called_for.equals("Primary_Ref_Source_LOV") || called_for.equals("PrimaryRefSRCLkup") || called_for.equals("NonInsPrimaryRefSRCLkup")){
		sql = "SELECT code, description from (SELECT referral_code code, long_desc description, short_desc,long_name, org_type org_type FROM am_referral_lang_vw "
			     +"WHERE (   (? = 'R' AND source_use_at_regn_yn = 'Y') "
			            +"OR (? IN ('O', 'E') AND source_use_at_visit_yn = 'Y') "
			            +"OR (? IN ('I', 'D') AND source_use_at_adm_yn = 'Y') )"
			      +"AND NVL (eff_status, 'E') = 'E' "
			      +"AND language_id = ? ) main where 1=1 ";
		
	}else if(called_for.equals("Sec_Ref_Source_LOV") || called_for.equals("SecRefSRCLkup") || called_for.equals("NonInsSecRefSRCLkup")){
		sql = "SELECT code, description from (SELECT referral_code code, long_desc description, short_desc,long_name, org_type org_type FROM am_referral_lang_vw "
			   +"WHERE (   (? = 'R' AND source_use_at_regn_yn = 'Y') "
			           +"OR (? IN ('O', 'E') AND source_use_at_visit_yn = 'Y') "
			           +"OR (? IN ('I', 'D') AND source_use_at_adm_yn = 'Y') ) "
			       +"AND NVL (eff_status, 'E') = 'E' "
			       +"AND language_id = ? ) main where 1=1 ";
	}else if(called_for.equals("PAT_ID_LKUP")){
		sql = "select a.patient_id code,DECODE (?, 'en', a.patient_name, "+
				"NVL (a.patient_name_loc_lang, a.patient_name) ) description from mp_patient a  "; //,a.patient_name
		}
	else if(called_for.equals("PKG_DTLS_LKUP")){
		/* String patient_id = request.getParameter("patient_id");
		String episode_type = request.getParameter("episode_type");
		String episodeId = request.getParameter("episodeId");
		String visitId = request.getParameter("visitId");
		String facility = request.getParameter("facility_id");
		 */sql="SELECT A.PACKAGE_SEQ_NO seqno,A.PACKAGE_CODE code,B.SHORT_DESC description FROM   BL_PACKAGE_SUB_HDR A,BL_PACKAGE_LANG_VW B"+
				" WHERE  A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND    A.PACKAGE_CODE    = B.PACKAGE_CODE "+
				" AND    B.LANGUAGE_ID = ? AND A.PATIENT_ID  = ? AND    NVL(A.STATUS,'O') ='O' "+
				" AND PACKAGE_SEQ_NO NOT IN (SELECT PACKAGE_SEQ_NO FROM BL_PACKAGE_ENCOUNTER_DTLs WHERE OPERATING_FACILITY_ID=?"+
				" AND PATIENT_ID = ? AND ENCOUNTER_ID =?  AND nvl(VISIT_ID,0) = nvl(?,0))";
		 if(!seqNoString.equals("")){
			 sql=sql+" AND PACKAGE_SEQ_NO NOT IN ("+seqNoString+") ";
		 }
	} //, A.MASTER_PKG_SEQ_NO 
	else if(called_for.equals("CustomerGroup")){
		sql="select code, description from (select cust_group_code code,short_desc description from ar_cust_group_lang_vw where language_id=? and status is null) main where 1=1 ";
	}
	else if(called_for.equals("Customer")){
		String settlement_ind = request.getParameter("settlement_ind");
		String adm_rec_flag = request.getParameter("adm_rec_flag");
		String module_id = request.getParameter("module_id");
		String episode_type = request.getParameter("episode_type");
		
		if("X".equals(settlement_ind) && "1".equals(adm_rec_flag)){ // Sponsor customers only
			sql = "select code, description from (";
			sql = sql + "SELECT c.cust_code code, a.short_name description, b.short_desc, a.country_name,c.cust_group_code, a.region_name, a.valid_from, a.valid_to "
		         +"FROM ar_customer_dtl_lang_vw a, ar_cust_group_lang_vw b, bl_cust_by_cust_group c "
		         +"WHERE NVL (patient_flag, 'N') = 'Y' "
		         +"AND NVL (pat_com_flag, 'N') = 'N' "
		         +"AND NVL (?, 'X') = 'X' "
		         +"AND ? = '1' "
		         +"AND NVL (a.insurance_yn, 'N') = 'N' "
		         +"AND a.language_id = b.language_id "
		         +"AND a.language_id = ? "
		         +"AND b.cust_group_code = c.cust_group_code "
		         +"AND a.cust_code = c.cust_code "
		         +"AND b.cust_group_code = NVL (?, b.cust_group_code) "
		         +"AND (   ? = 'N' "
		               +"OR ( ? = 'Y' "
		                   +"AND (c.cust_code, c.cust_group_code) IN ( "
		                         +" SELECT cust_code, cust_group_code FROM bl_patient_package_hdr WHERE operating_facility_id = ? "
		                            +"AND blng_grp_id = ? AND patient_id = ? "
		                        +")"
		                    +")" 
		               +") "
				+"AND a.status IS NULL "
				+" and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')"
							+" or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')"
							+" or (? = 'MP' and nvl(a.ref_yn,'N') = 'Y')) ";
			sql = sql + " ) outer where 1=1 ";
		} else if("R".equals(settlement_ind)){ // Credit customers only
			sql = "select code, description from (";
			sql = sql + "SELECT c.cust_code code, a.short_name description, b.short_desc, a.country_name,c.cust_group_code, a.region_name, a.valid_from, a.valid_to "
		         +"FROM ar_customer_dtl_lang_vw a, ar_cust_group_lang_vw b, bl_cust_by_cust_group c "
		         +"WHERE NVL (patient_flag, 'N') = 'Y' "
		         +"AND NVL (pat_com_flag, 'N') = 'Y' "
		         +"AND NVL (?, 'X') = 'R' "
		         +"AND NVL (insurance_yn, 'N') = 'N' "
		         +"AND a.language_id = ? "
				 +"AND a.language_id = b.language_id "
		         +"AND b.cust_group_code = c.cust_group_code "
		         +"AND a.cust_code = c.cust_code "
		         +"AND b.cust_group_code = NVL (?, b.cust_group_code) "
		         +"AND ( ? = 'N' OR ( ? = 'Y' AND (c.cust_code, c.cust_group_code) IN ( "
		                          +"SELECT cust_code, cust_group_code FROM bl_patient_package_hdr WHERE operating_facility_id = ? "
		                            +" AND blng_grp_id = ? AND patient_id = ? "
		                      +")"
		                 +")" 
		             +") "		         
		         +"AND a.status IS NULL "
				 +" and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')"
							+" or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')"
							+" or (? = 'MP' and nvl(a.ref_yn,'N') = 'Y')) ";
			sql = sql + " ) outer where 1=1 ";
		}
	}
		System.err.println("strWhereColumnType: "+strWhereColumnType+", search_criteria: "+search_criteria);
	System.err.println("sql: "+sql);
	
	if(search_text != null && !search_text.equals("")){
		
		if(search_criteria.equals("S"))
		{
			search_text = search_text + "%";
		}
		else if(search_criteria.equals("E"))
		{
			search_text = "%" + search_text;
		}
		else if(search_criteria.equals("C"))
		{
			search_text = "%" + search_text + "%";
		}
		
		if (strWhereColumnType.equalsIgnoreCase("VARCHAR2"))
		{
			userWhereClause = "( upper( "+strWhereColumn + ") like upper(?) OR upper( "+strWhereColumn + ") is NULL )";
		}
		else if (strWhereColumnType.equalsIgnoreCase("DATE"))
		{
			userWhereClause = "( to_char( "+strWhereColumn + ",'DD/MM/YYYY HH:MI:SS') like upper(?) OR upper( "+strWhereColumn + ") is NULL )";
		}
		else	// Search for Number Data Type
		{
			userWhereClause = "( upper( "+strWhereColumn+ ") like upper(?) OR "+strWhereColumn+ " is NULL )";
		}
		System.err.println("search_text:"+search_text);
		System.err.println("strWhereColumnType:"+strWhereColumnType);
		System.err.println("strWhereColumn:"+strWhereColumn);
		System.err.println("userWhereClause:"+userWhereClause);
		if(called_for.equals("PAT_ID_LKUP") ){  
			sql=sql+" where ";
			if(searchBy.equalsIgnoreCase("PI")){
				sql = sql +"upper(patient_id) LIKE upper(?)";
			}else if(searchBy.equalsIgnoreCase("PN")){
				sql = sql + "upper(FIRST_NAME) like upper(?) OR upper(SECOND_NAME) like upper(?) OR upper(THIRD_NAME) like upper(?) OR upper(FAMILY_NAME) like upper(?)";
			}
			System.err.println("Sql pat: "+sql);
		}else if(called_for.equals("ENC_ID_LKUP")){
			if(searchBy.equalsIgnoreCase("PI")){
				sql = sql +" and upper(patient_id) LIKE upper(?)";
			}else if(searchBy.equalsIgnoreCase("EI")){
				//sql = sql + " AND upper((EPISODE_ID||lpad(LAST_VISIT_ID,4,'0'))) like upper(?)";
				sql = sql + " AND "+condVal+" like upper(?)";
			} 
			System.err.println("Sql encID: "+sql);
		}else if(called_for.equals("PKG_DTLS_LKUP")){
			/* if(searchBy.equalsIgnoreCase("PC")){
				sql = sql +" and upper(A.PACKAGE_CODE) LIKE upper(?)";
			}else if(searchBy.equalsIgnoreCase("PD")){
				sql = sql + " AND upper(B.SHORT_DESC) like upper(?)";
			}else if(searchBy.equalsIgnoreCase("PS")){
				sql = sql + " AND upper(A.PACKAGE_SEQ_NO) like upper(?)";
			} */
			sql = sql +" and (upper(A.PACKAGE_CODE) LIKE upper(?) OR upper(B.SHORT_DESC) like upper(?) or upper(A.PACKAGE_SEQ_NO) like upper(?))";
			System.err.println("Sql PKG_DTLS_LKUP: "+sql);
		}else{
			sql = sql + " and " + userWhereClause;
		}	
		
		//sql = sql + " )";
	}
	System.err.println("SearchBy: "+searchBy);
	System.err.println("Sql Before Order By condition: "+sql);
	if(searchBy != null && (searchBy.equalsIgnoreCase("code") || searchBy.equalsIgnoreCase("PI") || searchBy.equalsIgnoreCase("EI"))){
		sql = sql + " ORDER BY 1 ";
	}else if(searchBy != null && (searchBy.equalsIgnoreCase("desc") || searchBy.equalsIgnoreCase("PN"))){
		sql = sql + " ORDER BY 2 ";
	}
	System.err.println("Final Sql in BLCommonLookupAjax: "+sql);
	try{
		if(sql != null && !sql.equals("")){

			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sql);
			searchData = new ArrayList();
			//set String according to the called Lookups
			if(called_for.equals("ENC_ID_LKUP")){
				String patient_id = request.getParameter("patient_id");
				String episode_type = request.getParameter("episode_type");

				System.err.println("facility_id"+facility_id+ "episode_type: "+episode_type+", patient_id: "+patient_id);
				System.err.println("column_count "+column_count);
				System.err.println("search_text "+search_text);
				pstmt.setString(++column_count, facility_id);	
				if(!"".equals(patient_id)){
					pstmt.setString(++column_count, patient_id);	
				}
				System.err.println("1 column_count "+column_count);
				if(!"".equals(episode_type) && !"A".equals(episode_type)){
					pstmt.setString(++column_count, episode_type);	
				}	
				System.err.println("2 column_count "+column_count);
				if((search_text != null && !search_text.equals("")) &&(searchBy.equalsIgnoreCase("PI") || searchBy.equalsIgnoreCase("EI"))){
					pstmt.setString(++column_count, search_text);
				}
			}else if(called_for.equals("NON_INS_BLNG_GRP_ID")){
				String patient_id = request.getParameter("patient_id");
				String episode_type = request.getParameter("episode_type");
				String authUser = request.getParameter("authUser");
				pstmt.setString(++column_count, locale);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, patient_id);
				pstmt.setString(++column_count, authUser);	
				pstmt.setString(++column_count, facility_id);	
				pstmt.setString(++column_count, pAge);		//:P_AGE */
			}else if(called_for.equals("BILLING_CATG_LOOKUP") || called_for.equals("PRI_BILLING_CATG_LOOKUP")){
				pstmt.setString(++column_count, locale);	
			}else if(called_for.equals("INS_BLNG_GRP_ID")){
				String patient_id = request.getParameter("patient_id");
				String episode_type = request.getParameter("episode_type");
				String blngGrpCatg = request.getParameter("blngGrpCatg");
				String authUser = request.getParameter("authUser");
				String settlement_ind = request.getParameter("settlement_ind");
				String adm_rec_flag = request.getParameter("adm_rec_flag");
				pstmt.setString(++column_count, locale);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, patient_id);
				pstmt.setString(++column_count, authUser);	
				pstmt.setString(++column_count, facility_id);	
				pstmt.setString(++column_count, blngGrpCatg);	
				pstmt.setString(++column_count, settlement_ind);		//:SETTLEMENT_IND
				pstmt.setString(++column_count, adm_rec_flag);			//:adm_rec_flag
				pstmt.setString(++column_count, settlement_ind);	
				pstmt.setString(++column_count, blngGrpCatg);
			/* 	
				pstmt.setString(++column_count, blngGrpCatg);	
				pstmt.setString(++column_count, settlement_ind);		//:SETTLEMENT_IND
				pstmt.setString(++column_count, blngGrpCatg);	 */
				
				pstmt.setString(++column_count, settlement_ind);		//:SETTLEMENT_IND
				pstmt.setString(++column_count, settlement_ind);		//:SETTLEMENT_IND
				pstmt.setString(++column_count, blngGrpCatg);
				/* 
				pstmt.setString(++column_count, blngGrpCatg);
				pstmt.setString(++column_count, settlement_ind);	 */	//:SETTLEMENT_IND
				pstmt.setString(++column_count, pAge);		//:P_AGE 
			}else if(called_for.equals("PRI_BLNG_GRP_ID")){
				String patient_id = request.getParameter("patient_id");
				String episode_type = request.getParameter("episode_type");
				String blngGrpCatg = request.getParameter("blngGrpCatg");
				String authUser = request.getParameter("authUser");
				String settlement_ind = request.getParameter("settlement_ind");
				pstmt.setString(++column_count, locale);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, episode_type);	
				pstmt.setString(++column_count, patient_id);
				pstmt.setString(++column_count, authUser);	
				pstmt.setString(++column_count, facility_id);	
				pstmt.setString(++column_count, blngGrpCatg);	
				pstmt.setString(++column_count, settlement_ind);		//:SETTLEMENT_IND
				pstmt.setString(++column_count, settlement_ind);		//:SETTLEMENT_IND
				pstmt.setString(++column_count, blngGrpCatg);	
				pstmt.setString(++column_count, blngGrpCatg);	
				pstmt.setString(++column_count, settlement_ind);		//:SETTLEMENT_IND
				pstmt.setString(++column_count, blngGrpCatg);	
				pstmt.setString(++column_count, settlement_ind);		//:SETTLEMENT_IND
				pstmt.setString(++column_count, settlement_ind);		//:SETTLEMENT_IND
				pstmt.setString(++column_count, blngGrpCatg);
				pstmt.setString(++column_count, blngGrpCatg);
				pstmt.setString(++column_count, settlement_ind);		//:SETTLEMENT_IND
				pstmt.setString(++column_count, pAge);		//:P_AGE 
			}else if(called_for.equals("CUST_GRP_CODE")){
				pstmt.setString(++column_count, locale);	
			}else if(called_for.equals("CUST_CODE")){
				String patient_id = request.getParameter("patient_id");
				String settlement_ind = request.getParameter("settlement_ind");
				String adm_rec_flag = request.getParameter("adm_rec_flag");
				String blngGrpId = request.getParameter("blngGrpId");
				String cust_grp_code = request.getParameter("cust_grp_code");
				String nd_package_yn = request.getParameter("nd_package_yn");
				String module_id = request.getParameter("module_id");

				System.err.println(settlement_ind+","+locale+","+cust_grp_code+","+nd_package_yn+","+facility_id+","+blngGrpId+","+patient_id+","+module_id+","+adm_rec_flag);
				if("X".equals(settlement_ind) && "2".equals(adm_rec_flag)){ // Insurance customers only
					pstmt.setString(++column_count,locale);
					pstmt.setString(++column_count,locale);
					pstmt.setString(++column_count,cust_grp_code);
					pstmt.setString(++column_count,facility_id);
					pstmt.setString(++column_count,module_id);
					pstmt.setString(++column_count,locale);
					pstmt.setString(++column_count,module_id);
					pstmt.setString(++column_count,"CY");
					pstmt.setString(++column_count,"");
					pstmt.setString(++column_count,"CY");
					pstmt.setString(++column_count,locale);
					pstmt.setString(++column_count,locale);
					pstmt.setString(++column_count,cust_grp_code);
					pstmt.setString(++column_count,facility_id);
					pstmt.setString(++column_count,module_id);
					pstmt.setString(++column_count,locale);
					pstmt.setString(++column_count,cust_grp_code);
					pstmt.setString(++column_count,module_id);
					pstmt.setString(++column_count,"CY");
					pstmt.setString(++column_count,"");
					pstmt.setString(++column_count,"CY");
				} else if("X".equals(settlement_ind) && "1".equals(adm_rec_flag)){ // Sponsor customers only
					pstmt.setString(++column_count, settlement_ind);
					pstmt.setString(++column_count, adm_rec_flag);	
					pstmt.setString(++column_count, locale);
					pstmt.setString(++column_count, cust_grp_code);	
					pstmt.setString(++column_count, nd_package_yn);	
					pstmt.setString(++column_count, nd_package_yn);	
					pstmt.setString(++column_count, facility_id);	
					pstmt.setString(++column_count, blngGrpId);
					pstmt.setString(++column_count, patient_id);
					pstmt.setString(++column_count, module_id);
					pstmt.setString(++column_count, module_id);
					pstmt.setString(++column_count, module_id);					
				} else if("R".equals(settlement_ind)){ // Credit customers only
					pstmt.setString(++column_count, settlement_ind);
					pstmt.setString(++column_count, locale);
					pstmt.setString(++column_count, cust_grp_code);	
					pstmt.setString(++column_count, nd_package_yn);	
					pstmt.setString(++column_count, nd_package_yn);	
					pstmt.setString(++column_count, facility_id);	
					pstmt.setString(++column_count, blngGrpId);
					pstmt.setString(++column_count, patient_id);
					pstmt.setString(++column_count, module_id);
					pstmt.setString(++column_count, module_id);
					pstmt.setString(++column_count, module_id);
				}			
			}else if(called_for.equals("POLICY_TYPE_CODE")){
				String episode_type = request.getParameter("episode_type");
				String cust_grp_code =  request.getParameter("cust_grp_code");
				String cust_code =  request.getParameter("cust_code");
				String module_id = request.getParameter("module_id");
				System.err.println("episode_type: "+episode_type+", cust_grp_code: "+cust_grp_code+", cust_code="+cust_code);
				pstmt.setString(++column_count, locale);		
				pstmt.setString(++column_count, facility_id);	
				pstmt.setString(++column_count, cust_code);	
				pstmt.setString(++column_count, cust_grp_code);
				pstmt.setString(++column_count, episode_type);
				pstmt.setString(++column_count, episode_type);
				pstmt.setString(++column_count, episode_type);
			}else if(called_for.equals("Primary_Ref_Source_LOV") || called_for.equals("PrimaryRefSRCLkup") || called_for.equals("NonInsPrimaryRefSRCLkup")){
				String episode_type = request.getParameter("episode_type");
				pstmt.setString(++column_count, episode_type);
				pstmt.setString(++column_count, episode_type);
				pstmt.setString(++column_count, episode_type);
				pstmt.setString(++column_count, locale);		
			}else if(called_for.equals("Sec_Ref_Source_LOV") ||  called_for.equals("SecRefSRCLkup") || called_for.equals("NonInsSecRefSRCLkup")){
				String episode_type = request.getParameter("episode_type");
				pstmt.setString(++column_count, episode_type);
				pstmt.setString(++column_count, episode_type);
				pstmt.setString(++column_count, episode_type);
				pstmt.setString(++column_count, locale);	
			}else if(called_for.equals("PAT_ID_LKUP")){
				pstmt.setString(++column_count, locale);
				if(search_text != null && !search_text.equals("")){
					if(searchBy.equalsIgnoreCase("PI")){
						pstmt.setString(++column_count, search_text);
					}else{
						pstmt.setString(++column_count, search_text);
						pstmt.setString(++column_count, search_text);
						pstmt.setString(++column_count, search_text);
						pstmt.setString(++column_count, search_text);
					}
				}
			}else if(called_for.equals("PKG_DTLS_LKUP")){
				String patient_id = request.getParameter("patientId");
				String episode_type = request.getParameter("episodeType");
				String episodeId = request.getParameter("episodeId");
				String visitId = request.getParameter("visitId");
				String facility = request.getParameter("facility_id");
				//String locale = request.getParameter("locale");
				pstmt.setString(++column_count, locale);
				pstmt.setString(++column_count, patient_id);
				pstmt.setString(++column_count, facility);
				pstmt.setString(++column_count, patient_id);
				pstmt.setString(++column_count, episodeId);
				pstmt.setString(++column_count, visitId);
				System.out.println("seqNoString "+seqNoString);
				/* if(!seqNoString.equals("")){
					pstmt.setString(++column_count, seqNoString);
				 } */
			}
			else if(called_for.equals("CustomerGroup")){
				//String locale = request.getParameter("locale");
				pstmt.setString(++column_count, locale);
			}	
			else if(called_for.equals("Customer")){
				String patient_id = request.getParameter("patient_id");
				String settlement_ind = request.getParameter("settlement_ind");
				String adm_rec_flag = request.getParameter("adm_rec_flag");
				String blngGrpId = request.getParameter("blngGrpId");
				String cust_grp_code = request.getParameter("cust_grp_code");
				String nd_package_yn = request.getParameter("nd_package_yn");
				String module_id = request.getParameter("module_id");
				
				 if("X".equals(settlement_ind) && "1".equals(adm_rec_flag)){ // Sponsor customers only
					pstmt.setString(++column_count, settlement_ind);
					pstmt.setString(++column_count, adm_rec_flag);	
					pstmt.setString(++column_count, locale);
					pstmt.setString(++column_count, cust_grp_code);	
					pstmt.setString(++column_count, nd_package_yn);	
					pstmt.setString(++column_count, nd_package_yn);	
					pstmt.setString(++column_count, facility_id);	
					pstmt.setString(++column_count, blngGrpId);
					pstmt.setString(++column_count, patient_id);
					pstmt.setString(++column_count, module_id);
					pstmt.setString(++column_count, module_id);
					pstmt.setString(++column_count, module_id);					
				} else if("R".equals(settlement_ind)){ // Credit customers only
					pstmt.setString(++column_count, settlement_ind);
					pstmt.setString(++column_count, locale);
					pstmt.setString(++column_count, cust_grp_code);	
					pstmt.setString(++column_count, nd_package_yn);	
					pstmt.setString(++column_count, nd_package_yn);	
					pstmt.setString(++column_count, facility_id);	
					pstmt.setString(++column_count, blngGrpId);
					pstmt.setString(++column_count, patient_id);
					pstmt.setString(++column_count, module_id);
					pstmt.setString(++column_count, module_id);
					pstmt.setString(++column_count, module_id);
				}
			}
			
			if(!called_for.equals("PAT_ID_LKUP") && !called_for.equals("ENC_ID_LKUP")){ //&& !called_for.equals("PKG_DTLS_LKUP")
				if(search_text != null && !search_text.equals("")){
					pstmt.setString(++column_count, search_text);	
					if(called_for.equals("PKG_DTLS_LKUP")){
						pstmt.setString(++column_count, search_text);	
						pstmt.setString(++column_count, search_text);	
					}
				}
			}
			System.err.println("Total paramter count: "+column_count);
			// Execute query
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				Map result1 = new HashMap();
				//getting the value from Resultset for called Lookups
				/* if(called_for.equals("ENC_ID_LKUP")){
					result1.put("code", rs.getString("EPISODE_ID"));
				}else{
					result1.put("code", rs.getString("code"));
					result1.put("description", rs.getString("description"));
				} */
				if(called_for.equals("PKG_DTLS_LKUP")){
					System.out.println("seqno "+rs.getString("seqno"));
					result1.put("seqno", rs.getString("seqno"));
				}
				result1.put("code", rs.getString("code"));
				result1.put("description", rs.getString("description"));
				searchData.add(result1);
			}			

		
		}
		
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		if(pstmt != null)	pstmt.close();
		if(rs != null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}
	
	// Convert the search results to JSON format
	if(searchData != null){
	    StringBuilder json = new StringBuilder("[");
	    for (Object result : searchData) {
	        Map resultMap = (Map) result;
	        json.append("{");
	        json.append("\"code\":\"").append(resultMap.get("code")).append("\",");
	        json.append("\"description\":\"").append(resultMap.get("description")).append("\"");
	        if(called_for.equals("PKG_DTLS_LKUP")){
	        	json.append(",");
				 json.append("\"seqno\":\"").append(resultMap.get("seqno")).append("\"");
			}
	        json.append("},");
	    }
	    if (!searchData.isEmpty()) {
	        json.deleteCharAt(json.length() - 1); // Remove trailing comma
	    }
	    json.append("]");
	    //System.err.println("Json object: "+json);
	    returnText = json.toString();
    }

  //while selecting the Billing Group Id validate its value
  	if(called_for.equals("validate_billing_grp_id")){
  		System.err.println("In validate_billing_grp_id");
  		String settlement_ind = "";
  		String adm_rec_flag = "";
  		String capture_ref_source_dtl_yn = "";
  		String ref_source_main_mand_yn = "";
  		String ref_source_sub_mand_yn = "";
  		String package_yn = "";
  		String visit_regn_date_time = "";
  		
  		String patient_id = request.getParameter("patient_id");
  		String episode_type = request.getParameter("episode_type");
  		String episodeId = request.getParameter("episodeId");
  		String visitId = request.getParameter("visitId");
  		String blngGrpId = request.getParameter("blngGrpId");
  		procSql = "{call bl_modify_fin_dtls_3t.blng_grp_id_chk(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
  		try{
  			con = ConnectionManager.getConnection();
  			
  			System.err.println(procSql);
  			csmt = con.prepareCall(procSql);
  			csmt.setString(1, facility_id);
  			csmt.setString(2, blngGrpId);
  			csmt.setString(3, patient_id);						
  			csmt.setString(4, episode_type);						
  			csmt.setString(5, episodeId);			
  			csmt.setString(6, visitId);	
  			csmt.setString(7, null);			//p_flag passing null
   			csmt.setString(8, locale);
  			System.err.println("All in param are set");
  			csmt.registerOutParameter(9, java.sql.Types.VARCHAR);
  			csmt.registerOutParameter(10, java.sql.Types.VARCHAR);
  			csmt.registerOutParameter(11, java.sql.Types.VARCHAR);
  			csmt.registerOutParameter(12, java.sql.Types.VARCHAR);
  			csmt.registerOutParameter(13, java.sql.Types.VARCHAR);
  			csmt.registerOutParameter(14, java.sql.Types.VARCHAR);
  			csmt.registerOutParameter(15, java.sql.Types.VARCHAR);
  			csmt.registerOutParameter(16, java.sql.Types.VARCHAR);
  			csmt.registerOutParameter(17, java.sql.Types.VARCHAR);
  			csmt.registerOutParameter(18, java.sql.Types.VARCHAR);
  			csmt.registerOutParameter(19, java.sql.Types.VARCHAR);
  			csmt.registerOutParameter(20, java.sql.Types.VARCHAR);
  			csmt.registerOutParameter(21, java.sql.Types.VARCHAR);
  			csmt.registerOutParameter(22, java.sql.Types.VARCHAR);
  			csmt.registerOutParameter(23, java.sql.Types.VARCHAR);
  			csmt.registerOutParameter(24, java.sql.Types.VARCHAR);
  			csmt.registerOutParameter(25, java.sql.Types.VARCHAR);
  			csmt.registerOutParameter(26, java.sql.Types.VARCHAR);
  			csmt.execute();
  			System.err.println("After execute the procedure");
  			settlement_ind = csmt.getString(12);
  			adm_rec_flag = csmt.getString(14);
  			capture_ref_source_dtl_yn = csmt.getString(18);
  			ref_source_main_mand_yn = csmt.getString(19);
  			ref_source_sub_mand_yn = csmt.getString(20);
  			package_yn = csmt.getString(22);
  			visit_regn_date_time = csmt.getString(23);
  			err_out = csmt.getString(24);
  			err_code = csmt.getString(25);
  			message_text = csmt.getString(26);
  			

			if(err_out == null) err_out="";
			if(err_code == null) err_code="";
			if(message_text == null) message_text="";
			
  			System.err.println(settlement_ind+"~"+adm_rec_flag+"~"+ref_source_main_mand_yn+"~"+ref_source_sub_mand_yn+"~"+package_yn+"~"+capture_ref_source_dtl_yn+"~"+visit_regn_date_time+"~"+err_out+"~"+err_code+"~"+message_text);
  			returnText = settlement_ind+"~"+adm_rec_flag+"~"+ref_source_main_mand_yn+"~"+ref_source_sub_mand_yn+"~"+package_yn+"~"+capture_ref_source_dtl_yn+"~"+visit_regn_date_time+"~"+err_out+"~"+err_code+"~"+message_text;
  		}catch(Exception ex){
  			ex.printStackTrace();
  		}finally{
  			if(csmt != null)	csmt.close();
  			ConnectionManager.returnConnection(con,request);
  		}
  	}
  if(called_for.equals("validate_PRI_BLNG_GRP_ID")){
		System.err.println("In validate_PRI_BLNG_GRP_ID");
		
		String p_alert = "";
		String patient_id = request.getParameter("patient_id");
		String episode_type = request.getParameter("episode_type");
		String episodeId = request.getParameter("episodeId");
		String visitId = request.getParameter("visitId");
		String blngGrpId = request.getParameter("blngGrpId");
		procSql = "{call bl_modify_fin_dtls_3t.validate_blng_grp_id(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		try{
			con = ConnectionManager.getConnection();
			
			System.err.println(procSql);
			csmt = con.prepareCall(procSql);
			csmt.setString(1, facility_id);
			csmt.setString(2, patient_id);						
			csmt.setString(3, episode_type);						
			csmt.setString(4, episodeId);			
			csmt.setString(5, visitId);	
			csmt.setString(6, blngGrpId);
			csmt.setString(7, null);			//p_prev_blng_grp passing null
 			csmt.setString(8, locale);
			csmt.setString(9, null);			//p_package_bill_doc_num passing null
			csmt.setString(10, "Y");					//p_blng_site_yn
			System.err.println("All in param are set");
			csmt.registerOutParameter(11, java.sql.Types.VARCHAR);
			csmt.registerOutParameter(12, java.sql.Types.VARCHAR);
			csmt.registerOutParameter(13, java.sql.Types.VARCHAR);
			csmt.registerOutParameter(14, java.sql.Types.VARCHAR);
			csmt.registerOutParameter(15, java.sql.Types.VARCHAR);
			csmt.registerOutParameter(16, java.sql.Types.VARCHAR);
			csmt.registerOutParameter(17, java.sql.Types.VARCHAR);
			csmt.registerOutParameter(18, java.sql.Types.VARCHAR);
			csmt.registerOutParameter(19, java.sql.Types.VARCHAR);
			csmt.registerOutParameter(20, java.sql.Types.VARCHAR);
		
			csmt.execute();
			System.err.println("After execute the procedure validate_blng_grp_id");
			
			err_out = csmt.getString(18);
			message_text = csmt.getString(19);
			p_alert = csmt.getString(20);
			
			

			if(err_out == null) err_out="";
			if(p_alert == null) p_alert="";
			if(message_text == null) message_text="";
			
			System.err.println("Output from validate_PRI_BLNG_GRP_ID:"+err_out+"~"+message_text+"~"+p_alert);
			returnText = err_out+"~"+message_text+"~"+p_alert;
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(csmt != null)	csmt.close();
			ConnectionManager.returnConnection(con,request);
		}
	
  }
    out.print(returnText);

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
