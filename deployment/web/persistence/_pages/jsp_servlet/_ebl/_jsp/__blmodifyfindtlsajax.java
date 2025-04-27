package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.jaxen.util.FollowingAxisIterator;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;
import eCommon.XSSRequestWrapper;
import eBL.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import com.ehis.util.*;
import eBL.Common.*;
import eBL.*;
import com.google.gson.JsonObject;

public final class __blmodifyfindtlsajax extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLModifyFinDtlsAjax.jsp", 1734595384000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
private String checkForNull(String inputString)
{
	
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}

public String formatDate(String inputDate){
	if(inputDate==null || inputDate.equals("")){
		return "";
	}
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    Timestamp inputTimeStamp = null;
    String outputDate=inputDate;
    long longTimeStamp = 0;
    inputTimeStamp = Timestamp.valueOf(inputDate);
    longTimeStamp = inputTimeStamp.getTime();
    outputDate=sdf.format(longTimeStamp);
    return outputDate;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
 
	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
String p_sys_message_id="",p_err_code="",p_error_text="",called_for="";
CallableStatement call =null;
PreparedStatement pstmt=null;
ResultSet rs=null;
Connection con =null;

try{
	con =ConnectionManager.getConnection();
	JsonObject obj = new JsonObject();
	String facility_id  =  (String) session.getValue("facility_id")==null?"GH":(String)session.getValue("facility_id") ;
	called_for = request.getParameter("called_for");
	System.out.println("called_for::"+called_for);
	//request.setCharacterEncoding("UTF-8");
	if(called_for.equals("validateUSer")){
		//String usr_id="",pass_wd="", remarks="";
		String usr_id	= 	request.getParameter("usr_id")==null?"":request.getParameter("usr_id");
		String pass_wd	= 	request.getParameter("pass_wd")==null?"":request.getParameter("pass_wd");
		String remarks	= 	request.getParameter("remarks")==null?"":request.getParameter("remarks");
		
		String episode_type	= 	request.getParameter("episodeType")==null?"":request.getParameter("episodeType");
		String patient	= 	request.getParameter("patientid")==null?"":request.getParameter("patientid");
		String episodeId	= 	request.getParameter("encounterId")==null?"":request.getParameter("encounterId");
//		 "&patientid="+patientid+"&episodeType="+episodeType+"&encounterId="+encounterId
		facility_id=request.getParameter("facility_id");
		usr_id=usr_id.trim();
		pass_wd=pass_wd.trim();
		remarks=remarks.trim();
		
		System.out.println("facility_id::"+facility_id);
		System.out.println("pass_wd::"+pass_wd);
		System.out.println("usr_id::"+usr_id);
		
		String valid_eligible_user = "";
		
		String query_elgb_user="select eff_status from sm_appl_user a where a.appl_user_id= UPPER(?)";
		
		System.err.println("	query_elgb_user:"+query_elgb_user);
		
		pstmt = con.prepareStatement(query_elgb_user);	
		pstmt.setString(1,usr_id);

		rs = pstmt.executeQuery();
		while(rs!=null && rs.next())
		{				
			valid_eligible_user = rs.getString(1);
		}
		
		System.err.println("	valid_eligible_user:"+valid_eligible_user);
		
		if("E".equals(valid_eligible_user)){
			
			query_elgb_user = "{call BLVALID.bl_authorize_user_pin(?,?,?,?,?,?)}";
		
			call = con.prepareCall(query_elgb_user);
			call.setString(1,facility_id);
			call.setString(2,usr_id);
			call.setString(3,pass_wd);
			call.registerOutParameter(4,java.sql.Types.VARCHAR);
			call.registerOutParameter(5,java.sql.Types.VARCHAR);
			call.registerOutParameter(6,java.sql.Types.VARCHAR);
		
			call.execute();	
			
			p_sys_message_id = call.getString(4);
			p_err_code = call.getString(5);
			p_error_text = call.getString(6);
			
			System.err.println("msg::p_err_code:::"+p_err_code);
			if(null != p_error_text && !"".equals(p_error_text)) {
				System.out.println("p_error_text :: "+p_error_text);
				obj.addProperty("p_error_text", p_error_text);
			} else if(null != p_sys_message_id && !"".equals(p_sys_message_id)) {
				System.out.println("p_sys_message_id :: "+p_sys_message_id);
				obj.addProperty("p_sys_message_id", p_sys_message_id);
			}  else{
				
			/* 	CHECK_UNBILLED (P_Facility_id varchar2
						p_episode_type VARCHAR2,
						p_PATIENT_ID varchar2,
						p_EPISODE_ID number,
						p_err_out varchar2) */
				System.out.println("after bl_authorize_user_pin success ");
			
				query_elgb_user = "{call bl_modify_fin_dtls_3t.CHECK_UNBILLED(?,?,?,?,?)}";
				
				call = con.prepareCall(query_elgb_user);
				call.setString(1,facility_id);
				call.setString(2,episode_type);
				call.setString(3,patient);
				call.setString(4,episodeId);
				call.registerOutParameter(5,java.sql.Types.VARCHAR);
				
				call.execute();	
				String message_id= call.getString(5);
				System.out.println("message_id in CHECK_UNBILLED:: "+message_id);
				
				if(null != message_id && !"".equals(message_id)) {
					obj.addProperty("p_sys_message_id",message_id );
				}else{
					obj.addProperty("Success", "Y");
				}
				
			}
		
		}
		else{
			System.out.println("p_sys_message_id :: BL2095 ");
			obj.addProperty("p_sys_message_id", "BL2095");
		}
		
		System.err.println("obj:::"+obj.toString());
	}else if(called_for.equals("pkgEnable")){
		String patientid=request.getParameter("patientid");
		String pkgEnableYN="{call bl_modify_fin_dtls_3t.proc_package_enable(?,?,?,?)}";
		call = con.prepareCall(pkgEnableYN);
		call.setString(1,facility_id);
		call.setString(2,patientid);
		call.registerOutParameter(3,java.sql.Types.VARCHAR);
		call.registerOutParameter(4,java.sql.Types.VARCHAR);
		call.execute();
		String enableYN = call.getString(3);
	//	enableYN="Y";
		p_error_text = call.getString(4);
		if(null != p_error_text && !"".equals(p_error_text)) {
			System.out.println("p_error_text :: "+p_error_text);
			obj.addProperty("p_error_text", p_error_text);
		}else if(null != enableYN && !"".equals(enableYN)){
			obj.addProperty("Value", enableYN);
		}
		System.err.println("obj:::"+obj.toString());
	}else if(called_for.equals("getBlngClsEligiblity")){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		facility_id =request.getParameter("facility_id"); 
		System.err.println("facility_id:::"+facility_id);
		String patientId = request.getParameter("patientId"); 
		String pkgCode= request.getParameter("pkgCode"); 
		String pkgSeqNo=request.getParameter("pkgSeqNo");
		String blngGrpId=request.getParameter("blngGrpId");
		String admDateTim=request.getParameter("admDateTime");
		String locale = request.getParameter("locale");
		String episode_id = request.getParameter("episodeId"); 
		String episodeType = request.getParameter("episodeType");
		//String p_associated_yn="Y"; //selPkg
		String p_associated_yn= request.getParameter("selPkg");
		String assoc_yn="",error_text	= "",error_message_id	= "";
		System.err.println("p_associated_yn:::"+p_associated_yn);
		System.err.println("episodeType:::"+episodeType);
		System.err.println("pkgSeqNo:::"+pkgSeqNo);
		System.err.println("blngGrpId:::"+blngGrpId);
		System.err.println("pkgCode:::"+pkgCode);
		System.err.println("admDateTime:::"+admDateTim);
		//Date fromDt = new Date(sdf.parse(admDateTime).getTime());
		//java.sql.Date admDateTime = new SimpleDateFormat("yyyy-MM-DD").parse(admDateTim);
		//java.sql.Date admDateTime = new java.sql.Date(sdf.parse(admDateTim).getTime());
		//cstmt.setDate(29, fromDt);
		String oldFormat = "yyyy-MM-dd";
		String newFormat = "dd/MM/yyyy";
		SimpleDateFormat sdf1 = new SimpleDateFormat(oldFormat);
		SimpleDateFormat sdf2 = new SimpleDateFormat(newFormat);	   
		try {
			if(admDateTim!=null && !"".equals(admDateTim))
				admDateTim=sdf2.format(sdf1.parse(admDateTim));
		 } catch (ParseException e) {
			        e.printStackTrace();
		}
		System.err.println("admDateTime:::"+admDateTim);
		CallableStatement cstmt = con.prepareCall( "{ call Bl_modify_fin_dtls_3t.val_pkg_asso_chk_box_change( ?, ?, ?, ?, ?, ?, ?, ?, ?,?, to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?) }" ) ;
		/* 
		TO_DATE('1989-12-09','YYYY-MM-DD')
	*/
		cstmt.setString( 1,	facility_id ) ;
		cstmt.setString( 2,	patientId ) ;
		cstmt.setString( 3,	episode_id) ;
		cstmt.setString( 4,	episodeType ) ; 
		
		cstmt.setString( 5,	blngGrpId ) ;
		cstmt.setString( 6,	"Y") ;
		cstmt.setString( 7,	pkgCode ) ;
		cstmt.setString( 8,	pkgSeqNo ) ;
		cstmt.setString( 9,	"Y" ) ;
		cstmt.setString( 10,	locale ) ;
		cstmt.setString( 11,admDateTim ) ;
		cstmt.setString( 12,	p_associated_yn ) ;
		
		cstmt.registerOutParameter( 12,  Types.VARCHAR ) ;
		cstmt.registerOutParameter( 13,  Types.VARCHAR ) ;
		cstmt.registerOutParameter( 14, Types.VARCHAR ) ;
		cstmt.registerOutParameter( 15, Types.VARCHAR ) ;
		cstmt.execute() ;
		assoc_yn	= cstmt.getString( 12 ) ;
		 System.err.println("assoc_yn:::"+assoc_yn);
		String showReqPage	= cstmt.getString( 13 ) ;
		 System.err.println("showReqPage:::"+showReqPage);
		error_message_id = cstmt.getString( 14 ) ;
		System.err.println("error_message_id:::"+error_message_id);
		error_text = cstmt.getString( 15) ;				
		 System.err.println("error_text:::"+error_text);
		 if(null != assoc_yn && !"".equals(assoc_yn)){
			 obj.addProperty("assoc_yn", assoc_yn);
		 }
		 if(null != showReqPage && !"".equals(showReqPage)){
			 obj.addProperty("showReqPage", showReqPage);
		 }
		 
		 if(null != error_message_id && !"".equals(error_message_id)) {
			 obj.addProperty("error_message_id", error_message_id);
		 }
		 if(null != error_text && !"".equals(error_text)) {
			 obj.addProperty("error_text", error_text);
		 }
		 if(cstmt!=null) cstmt.close();
	}else if(called_for.equals("ValidateRequest")){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		facility_id =request.getParameter("facility_id"); 
		System.err.println("facility_id:::"+facility_id);
		String patientId = request.getParameter("patientId"); 
		String pkgCode= request.getParameter("pkgCode"); 
		String pkgSeqNo=request.getParameter("pkgSeqNo");
		String storeVal=request.getParameter("storeVal");
		String locale = request.getParameter("locale");
		String episode_id = request.getParameter("episodeId"); 
		String episodeType = request.getParameter("episodeType");
		String hidePkg="",error="";
		String login_user = request.getParameter("login_user");
		System.err.println("episodeType:::"+episodeType);
		System.err.println("pkgSeqNo:::"+pkgSeqNo);
		System.err.println("storeVal:::"+storeVal);
		System.err.println("pkgCode:::"+pkgCode);
		call = con.prepareCall( "{ call bl_modify_fin_dtls_3t.val_req_radio_btn_change( ?, ?, ?, ?, ?, ?, ?, ?, ?) }" ) ;
		call.setString( 1,	facility_id ) ;
		call.setString( 2,	storeVal ) ;
		call.setString( 3,	patientId) ;
		call.setString( 4,	episode_id ) ; 
			
		call.setString( 5,	pkgCode ) ;
		call.setString( 6,	pkgSeqNo) ;
		call.setString( 7,	login_user ) ;
		
		call.registerOutParameter( 8,  Types.VARCHAR ) ;
		call.registerOutParameter( 9,  Types.VARCHAR ) ;
		
		call.execute() ;
		
		hidePkg = call.getString( 8 ) ;
		error = call.getString( 9) ;				
		 
		 if(null != hidePkg && !"".equals(hidePkg)){
			 obj.addProperty("hidePkg", hidePkg);
		 }
		 if(null != error && !"".equals(error)){
			 obj.addProperty("error", error);
		 }
		
	}else if(called_for.equals("getEpisodeIdVisitId")){
			facility_id =request.getParameter("facility_id");// (String)session.getAttribute("facility_id"); 
			System.err.println("facility_id:::"+facility_id);
			String patientId = request.getParameter("patientId"); 
			String episodeType = request.getParameter("episodeType");  
			String calledFrom=checkForNull(request.getParameter("calledFrom")); 
			String underchargeAllowedYN    = "N";
			String episode_id	= "",visit_id	= "",error_level	= "",error_text	= "",error_message_id	= "";
			String locale = request.getParameter("locale");
			String encID="";
			System.err.println("calledFrom:::"+calledFrom);
			System.err.println("episodeType:::"+episodeType);
			if("encTrfCharge".equals(calledFrom) && episodeType.equalsIgnoreCase("I")){//to retrive enc id for IP in transfer charges 
				String encountIdQry="Select episode_id from IP_EPISODE where  facility_id= ? and patient_id = ? and"+
						" ADMISSION_DATE_TIME = (SELECT MAX(ADMISSION_DATE_TIME) FROM IP_EPISODE WHERE facility_id= ?"+
						" and patient_id = ? and nvl(episode_type,'I') = ? and nvl(EPISODE_STATUS,'X')<>'9') ";
				System.err.println("	encountIdQry:"+encountIdQry);
				pstmt = con.prepareStatement(encountIdQry);	
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patientId ) ;
				pstmt.setString(3,facility_id);
				pstmt.setString(4,patientId ) ;
				pstmt.setString(5,episodeType) ;
				rs = pstmt.executeQuery();
				while(rs!=null && rs.next())
				{				
					encID = rs.getString(1);
				}
				obj.addProperty("encID", encID);
			}else{
			//CallableStatement cstmt = con.prepareCall( "{ call BLCOMMON.bl_proc_latest_episode ( ?, ?, ?, ?, ?, ?, ?, ?, ?) }" ) ;
			CallableStatement cstmt = con.prepareCall( "{ call Bl_modify_fin_dtls_3t.bl_proc_latest_episode ( ?, ?, ?, ?, ?, ?, ?, ?, ?) }" ) ;
			
			cstmt.setString( 1,	facility_id ) ;
			cstmt.setString( 2,	patientId ) ;
			cstmt.setString( 3,	episodeType) ;
			cstmt.setString( 4,	"N" ) ; // this to be discussed how to handle both IP & Post Discharge IP cases
			cstmt.registerOutParameter( 5,  Types.VARCHAR ) ;
			cstmt.registerOutParameter( 6,  Types.VARCHAR ) ;
			cstmt.registerOutParameter( 7, Types.VARCHAR ) ;
			cstmt.registerOutParameter( 8, Types.VARCHAR ) ;
			cstmt.registerOutParameter( 9, Types.VARCHAR ) ;
			cstmt.execute() ;
			episode_id	= cstmt.getString( 5 ) ;
			visit_id	= cstmt.getString( 6 ) ;
			error_level	= cstmt.getString( 7 ) ;
			error_message_id = cstmt.getString( 8 ) ;
			error_text = cstmt.getString( 9 ) ;				
			 System.err.println("episode_id:::"+episode_id);
			 System.err.println("visit_id:::"+visit_id);
			 System.err.println("error_message_id:::"+error_message_id);
				 if(null != episode_id){
					
				String sql="select decode(?,'O',?||lpad(?,4,'0'),'E',?||lpad(?,4,'0'),'I',?,'D',?) encounter_id from dual";
							//"select decode(?,'O',?||lpad(?,4,'0'),'I',?) encounter_id from dual";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, episodeType);
				pstmt.setString(2, episode_id);
				pstmt.setString(3, visit_id);	
				pstmt.setString(4, episode_id);
					
				pstmt.setString(5, visit_id);
				pstmt.setString(6, episode_id);
				pstmt.setString(7, episode_id);
				rs=pstmt.executeQuery();
				while(rs.next()){
					encID=rs.getString(1);
				}
				System.out.println("encID "+encID);
				//out.println(a.trim());MM00292003
				obj.addProperty("encID", encID);
				obj.addProperty("episode_id", episode_id); //Added for RBU-GHL-CRF-0033-US001 - siraj
				obj.addProperty("visit_id", visit_id); //Added for RBU-GHL-CRF-0033-US001 - siraj
			}else if(null != error_message_id) {
				/* Hashtable messageHashtable=new Hashtable();
				messageHashtable = MessageManager.getMessage(locale, error_message_id, "BL");
				String msg= (String)messageHashtable.get("message");
				 *///out.println(msg);p_sys_message_id
				 System.err.println("p_sys_message_id:::"+p_sys_message_id);
				obj.addProperty("p_sys_message_id", error_message_id);			
			}else if(null != error_text){
				//out.println(error_text);
				obj.addProperty("p_error_text", error_text);
			} else{
				obj.addProperty("encID", "");
				obj.addProperty("p_error_text", "");
				obj.addProperty("p_sys_message_id", "");
			}
			}
	}else if(called_for.equals("BlngGrpIdValidation")){
		
		String nonInsBlngId="";
		String NIBlngGrpdesc="";
		String blngGrpId=request.getParameter("blngGrpId");
		String locale = request.getParameter("locale");
		 System.err.println("blngGrpId:::"+blngGrpId);
		//String nonInsBlng="SELECT non_ins_blng_grp_id FROM bl_blng_grp WHERE blng_grp_id = ? ";
		String nonInsBlng="SELECT b.non_ins_blng_grp_id,a.short_desc FROM bl_blng_grp b,bl_blng_grp_lang_vw a WHERE b.blng_grp_id=? and B.NON_INS_BLNG_GRP_ID=a.blng_grp_id and a.language_id = ?";
		pstmt=con.prepareStatement(nonInsBlng);
		pstmt.setString(1, blngGrpId);
		pstmt.setString(2, locale);		
		rs=pstmt.executeQuery();
		while(rs.next()){
			nonInsBlngId=(rs.getString(1)== null) ? "" : rs.getString(1);
			NIBlngGrpdesc=(rs.getString(2)== null) ? "" : rs.getString(2);
		}
		 System.err.println("nonInsBlngId:::"+nonInsBlngId);
			
		String settlement_ind = "",adm_rec_flag = "",capture_ref_source_dtl_yn = "",credit_doc_ref_reqd_yn="";
  		String ref_source_main_mand_yn = "",ref_source_sub_mand_yn = ""; 
  		
		String sql="SELECT a.blng_grp_id, a.short_desc, credit_doc_ref_reqd_yn,CAPTURE_REF_SOURCE_DTL_YN, ref_source_main_mand_yn,"+
			"ref_source_sub_mand_yn,settlement_ind,adm_rec_flag FROM bl_blng_grp a WHERE blng_grp_id =?";
		
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, blngGrpId);
		
		rs=pstmt.executeQuery();
		while(rs.next()){
			capture_ref_source_dtl_yn=rs.getString("CAPTURE_REF_SOURCE_DTL_YN");
			settlement_ind=rs.getString("settlement_ind");
			adm_rec_flag=rs.getString("adm_rec_flag");
			ref_source_main_mand_yn=rs.getString("ref_source_main_mand_yn");
			ref_source_sub_mand_yn=rs.getString("ref_source_sub_mand_yn"); 
			credit_doc_ref_reqd_yn=rs.getString("credit_doc_ref_reqd_yn"); 
		}
		 System.err.println("capture_ref_source_dtl_yn:::"+capture_ref_source_dtl_yn);
		 System.err.println("settlement_ind:::"+settlement_ind);	
		obj.addProperty("capture_ref_source_dtl_yn", capture_ref_source_dtl_yn);
		obj.addProperty("settlement_ind", settlement_ind);
		obj.addProperty("adm_rec_flag", adm_rec_flag);
		obj.addProperty("ref_source_main_mand_yn", ref_source_main_mand_yn);
		obj.addProperty("ref_source_sub_mand_yn", ref_source_sub_mand_yn);
		obj.addProperty("nonInsBlngId", nonInsBlngId);
		obj.addProperty("NIBlngGrpdesc", NIBlngGrpdesc);
		obj.addProperty("credit_doc_ref_reqd_yn",credit_doc_ref_reqd_yn);
		 System.err.println(" settlement_ind:::"+settlement_ind);	
		if(!nonInsBlngId.equals("") && settlement_ind.equals("X")){
			
			 sql="SELECT a.blng_grp_id, a.short_desc, credit_doc_ref_reqd_yn,CAPTURE_REF_SOURCE_DTL_YN, ref_source_main_mand_yn,"+
					"ref_source_sub_mand_yn,settlement_ind,adm_rec_flag FROM bl_blng_grp a WHERE blng_grp_id =?";
				
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, nonInsBlngId);
				rs=pstmt.executeQuery();
				while(rs.next()){
					capture_ref_source_dtl_yn=rs.getString("CAPTURE_REF_SOURCE_DTL_YN");
					settlement_ind=rs.getString("settlement_ind");
					adm_rec_flag=rs.getString("adm_rec_flag");
					ref_source_main_mand_yn=rs.getString("ref_source_main_mand_yn");
					ref_source_sub_mand_yn=rs.getString("ref_source_sub_mand_yn"); 
					credit_doc_ref_reqd_yn=rs.getString("credit_doc_ref_reqd_yn"); 
				}
				 System.err.println("non ins capture_ref_source_dtl_yn:::"+capture_ref_source_dtl_yn);
				 System.err.println("non ins settlement_ind:::"+settlement_ind);	
				obj.addProperty("nicapture_ref_source_dtl_yn", capture_ref_source_dtl_yn);
				obj.addProperty("nisettlement_ind", settlement_ind);
				obj.addProperty("niadm_rec_flag", adm_rec_flag);
				obj.addProperty("niref_source_main_mand_yn", ref_source_main_mand_yn);
				obj.addProperty("niref_source_sub_mand_yn", ref_source_sub_mand_yn);
				obj.addProperty("nicredit_doc_ref_reqd_yn",credit_doc_ref_reqd_yn);			
		}
		 System.err.println("capture_ref_source_dtl_yn:::"+capture_ref_source_dtl_yn);
		 System.err.println("settlement_ind:::"+settlement_ind);	
		
	}
	else if(called_for.equals("NIBlngGrpIdValidation")){
		String nonInsBlngGrpId=request.getParameter("blngGrpId");
		String settlement_ind = "",adm_rec_flag = "",capture_ref_source_dtl_yn = "",credit_doc_ref_reqd_yn="";
  		String ref_source_main_mand_yn = "",ref_source_sub_mand_yn = ""; 
  		
		String sql="SELECT a.blng_grp_id, a.short_desc, credit_doc_ref_reqd_yn,CAPTURE_REF_SOURCE_DTL_YN, ref_source_main_mand_yn,"+
			"ref_source_sub_mand_yn,settlement_ind,adm_rec_flag FROM bl_blng_grp a WHERE blng_grp_id =?";
		
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, nonInsBlngGrpId);
		rs=pstmt.executeQuery();
		while(rs.next()){
			capture_ref_source_dtl_yn=rs.getString("CAPTURE_REF_SOURCE_DTL_YN");
			settlement_ind=rs.getString("settlement_ind");
			adm_rec_flag=rs.getString("adm_rec_flag");
			ref_source_main_mand_yn=rs.getString("ref_source_main_mand_yn");
			ref_source_sub_mand_yn=rs.getString("ref_source_sub_mand_yn"); 
			credit_doc_ref_reqd_yn=rs.getString("credit_doc_ref_reqd_yn"); 
		}
		 System.err.println("non ins capture_ref_source_dtl_yn:::"+capture_ref_source_dtl_yn);
		 System.err.println("non ins settlement_ind:::"+settlement_ind);	
		obj.addProperty("nicapture_ref_source_dtl_yn", capture_ref_source_dtl_yn);
		obj.addProperty("nisettlement_ind", settlement_ind);
		obj.addProperty("niadm_rec_flag", adm_rec_flag);
		obj.addProperty("niref_source_main_mand_yn", ref_source_main_mand_yn);
		obj.addProperty("niref_source_sub_mand_yn", ref_source_sub_mand_yn);
	//	obj.addProperty("ninonInsBlngId", nonInsBlngId);
		obj.addProperty("nicredit_doc_ref_reqd_yn",credit_doc_ref_reqd_yn);
	}
	else if(called_for.equals("getVisitAdmnRegDateTime")){
		String facilityId =request.getParameter("facility_id");
		String patientId = request.getParameter("patientId"); 
		String episodeType = request.getParameter("episodeType");  
		String encounterID = request.getParameter("encounterID");
		String encounterDateTime = "";
		String patientClass = "";
		String sql = "";
		String noOfDecimal="";
		if("O".equals(episodeType))
			patientClass = "OP";
		else if("E".equals(episodeType))
			patientClass = "EM";
		else if("I".equals(episodeType))
			patientClass = "IP";
		else if("D".equals(episodeType))
			patientClass = "DC";
		else if("R".equals(episodeType))
			patientClass = "EX";
  		
		if("R".equals(episodeType)){
			sql="SELECT to_char(REGN_DATE, 'YYYY-MM-DD') VISIT_ADM_DATE_TIME FROM mp_patient a WHERE PATIENT_ID = ?";
		} else {
			sql="SELECT to_char(VISIT_ADM_DATE_TIME, 'YYYY-MM-DD') VISIT_ADM_DATE_TIME FROM pr_encounter a WHERE FACILITY_ID = ? AND ENCOUNTER_ID = ? AND PATIENT_ID = ? AND PATIENT_CLASS = ?";
		}
		
		pstmt=con.prepareStatement(sql);
		if("R".equals(episodeType)){
			pstmt.setString(1, patientId);
		}else{
			pstmt.setString(1, facilityId);
			pstmt.setString(2, encounterID);
			pstmt.setString(3, patientId);
			pstmt.setString(4, patientClass);
		}
		rs=pstmt.executeQuery();
		
		while(rs.next()){
			encounterDateTime = rs.getString("VISIT_ADM_DATE_TIME");
		}
		//To get no of decimal point for amount fields
		sql="SELECT NO_OF_DECIMAL FROM SM_ACC_ENTITY_PARAM where rownum=1";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		while(rs.next()){
			noOfDecimal = rs.getString("NO_OF_DECIMAL");
		}
		if(null != noOfDecimal && !"".equals(noOfDecimal)) {
			obj.addProperty("noOfDecimal",noOfDecimal);
		}else{
			obj.addProperty("noOfDecimal","2");
		}
		System.err.println("encounterDateTime:::"+encounterDateTime);
		obj.addProperty("encounterDateTime",encounterDateTime);
	}
	else if(called_for.equals("procPackageCheck")){
		System.err.println("In procPackageCheck");
		String patientid = request.getParameter("patientId");
		String episode_id = request.getParameter("episode_id");
		facility_id = request.getParameter("facility_id");
		String visit_id = request.getParameter("visit_id");
		String episodeType = request.getParameter("episodeType");
		System.err.println("In procPackageCheck::: "+patientid+"::"+episode_id+"::"+facility_id+"::"+visit_id+"::"+episodeType);
		String sql = "{call bl_modify_fin_dtls_3t.proc_package_check (?,?,?,?,?,?,?)}";
		call = con.prepareCall(sql);
		call.setString(1,facility_id);
		call.setString(2,patientid);
		call.setString(3,episode_id);
		call.setString(4,visit_id);
		call.setString(5,episodeType);
		call.registerOutParameter(6,java.sql.Types.VARCHAR);
		call.registerOutParameter(7,java.sql.Types.VARCHAR);
		call.execute();
		String lv_package_chk  = call.getString(6);
		p_error_text = call.getString(7);
		if(null != p_error_text && !"".equals(p_error_text)) {
			System.out.println("p_error_text :: "+p_error_text);
			obj.addProperty("p_error_text", p_error_text);
		}else if(null != lv_package_chk && !"".equals(lv_package_chk)){
			obj.addProperty("Value", lv_package_chk);
		}
		System.err.println("obj:::"+obj.toString());
	
	}else if(called_for.equals("billExistCheck")){
		System.err.println("In billExistCheck");
		String patientid = request.getParameter("patientId");
		String episode_id = request.getParameter("episode_id");
		facility_id = request.getParameter("facility_id");
		String visit_id = request.getParameter("visit_id");
		String episodeType = request.getParameter("episodeType");
		String priBlngGrpId = request.getParameter("priBlngGrpId");
		String customerId = request.getParameter("customerId");
		String nonInsBlngGrp = request.getParameter("nonInsBlngGrp");
		String NonInsCustId = request.getParameter("NonInsCustId");
		String login_user = request.getParameter("login_user");
		session = request.getSession(false);
		Properties p = (Properties) session.getValue("jdbc");
		String client_ip_address = p.getProperty("client_ip_address");
		
		System.err.println("In billExistCheck::: "+patientid+"::"+episode_id+"::"+facility_id+"::"+visit_id+"::"+episodeType);
		String sql = "{call bl_modify_fin_dtls_3t.bill_exist_check(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		call = con.prepareCall(sql);
		call.setString(1,facility_id);
		call.setString(2,patientid);
		call.setString(3,episode_id);
		call.setString(4,episodeType);
		call.setString(5,visit_id);
		call.setString(6,priBlngGrpId);
		call.setString(7,customerId);
		call.setString(8, null);
		call.setString(9, nonInsBlngGrp);
		call.setString(10, null);
		call.setString(11, NonInsCustId);
		call.setString(12, login_user);
		call.setString(13, client_ip_address);
		call.registerOutParameter(14,java.sql.Types.VARCHAR);
		call.registerOutParameter(15,java.sql.Types.VARCHAR);
		call.registerOutParameter(16,java.sql.Types.VARCHAR);
		call.execute();
		String err_out  = call.getString(14);
		String cnfm_alert = call.getString(15);
		String message_text = call.getString(16);
		
		System.out.println("err_out :: "+err_out+", cnfm_alert :: "+cnfm_alert+", message_text :: "+message_text);
		if(err_out == null) err_out = "";
		if(cnfm_alert == null) cnfm_alert = "";
		if(message_text == null) message_text = "";
		
		obj.addProperty("err_out", err_out);
		obj.addProperty("cnfm_alert", cnfm_alert);
		obj.addProperty("message_text", message_text);
	
		System.err.println("obj:::"+obj.toString());
	
	}else if(called_for.equals("reloadWithSessionUpdate")){
		session.setAttribute("pageCalledYN","Y");
		obj.addProperty("Success", "Y");
		System.err.println("obj:::"+obj.toString());
	}else if(called_for.equals("dfltPolicyDateAndApprAmt")){
		String Str =	"!";
		String pateintId =	"";
		String moduleId =	"";
		String customerGroupcode =	"";
		String customerCode =	"";
		String policyTypeCode =	"";
		String locale =	"";
		String facilityId =	"";
		Connection connection =   null;
		PreparedStatement preparedStatement = 	null;
		ResultSet resultSet = 	null;
		String	mId =	"@moduleId";
		String	fId =	"@facilityId";
		String	cGId =	"@customerGroupcode";
		String	cId =	"@customerCode";
		String	pTCId =	"@policyTypeCode";
		StringBuffer sql = 	null;		
		try
		{			
			request.setCharacterEncoding("UTF-8");
			System.err.println("In LoadDefaultPolicyDateAndApprovedAmount.jsp.::: ");
			sql =	new StringBuffer();	
			connection =	ConnectionManager.getConnection(request);
			
			locale = 	checkForNull(request.getParameter("locale"));
			facilityId =  checkForNull(request.getParameter("facilityId"));
			moduleId =	checkForNull(request.getParameter("strModuleId")); 
			customerGroupcode =	checkForNull(request.getParameter("cust_group_code"));
			customerCode =	checkForNull(request.getParameter("cust_code"));
			policyTypeCode =	checkForNull(request.getParameter("policy_type_code"));
			
			System.err.println("facilityId in LoadDefaultPolicyDateAndApprovedAmount.jsp:::::::::: "+facilityId);
			System.err.println("moduleId in LoadDefaultPolicyDateAndApprovedAmount.jsp:::::::::::: "+moduleId);
			System.err.println("customerGroupcode in LoadDefaultPolicyDateAndApprovedAmount.jsp::: "+customerGroupcode);
			System.err.println("customerCode in LoadDefaultPolicyDateAndApprovedAmount.jsp:::::::: "+customerCode);
			System.err.println("policyTypeCode in LoadDefaultPolicyDateAndApprovedAmount.jsp:::::: "+policyTypeCode);
			
			if(moduleId.equalsIgnoreCase("MP"))
			{
				sql.append("SELECT POLICY_EFF_FROM, POLICY_EFF_TO,EX_APPROVED_NO_OF_DAYS,EX_APPROVED_AMT_LIMIT,ADDL_DAYS_POLICY_EXPDT FROM (SELECT to_char(POLICY_EFF_FROM,'yyyy-mm-dd') POLICY_EFF_FROM, to_char(POLICY_EFF_TO,'yyyy-mm-dd') POLICY_EFF_TO,EX_APPROVED_NO_OF_DAYS,EX_APPROVED_AMT_LIMIT,ADDL_DAYS_POLICY_EXPDT FROM  BL_INS_POLICY_TYPE_HDR WHERE POLICY_TYPE_CODE =  '@policyTypeCode' AND CUST_GROUP_CODE =  '@customerGroupcode' AND (CUST_CODE =  '@customerCode' OR CUST_CODE =  '**') and nvl(POLICY_EFF_TO,trunc(sysdate)) >= trunc(sysdate) order by decode(cust_code,'**',999,1)) where rownum = 1");
			}
			if(moduleId.equalsIgnoreCase("IP") || moduleId.equalsIgnoreCase("DC"))
			{
				sql.append("SELECT POLICY_EFF_FROM, POLICY_EFF_TO,IP_APPROVED_NO_OF_DAYS,IP_APPROVED_AMT_LIMIT,ADDL_DAYS_POLICY_EXPDT FROM (SELECT to_char(POLICY_EFF_FROM,'yyyy-mm-dd') POLICY_EFF_FROM, to_char(POLICY_EFF_TO,'yyyy-mm-dd') POLICY_EFF_TO,IP_APPROVED_NO_OF_DAYS,IP_APPROVED_AMT_LIMIT,ADDL_DAYS_POLICY_EXPDT FROM  BL_INS_POLICY_TYPE_HDR WHERE POLICY_TYPE_CODE =  '@policyTypeCode' AND CUST_GROUP_CODE =  '@customerGroupcode' AND (CUST_CODE =  '@customerCode' OR CUST_CODE =  '**') and nvl(POLICY_EFF_TO,trunc(sysdate)) >= trunc(sysdate) order by decode(cust_code,'**',999,1)) where rownum = 1");
			}
			if(moduleId.equalsIgnoreCase("OP") || moduleId.equalsIgnoreCase("AE"))
			{
				sql.append("SELECT POLICY_EFF_FROM,POLICY_EFF_TO,OP_APPROVED_NO_OF_DAYS,OP_APPROVED_AMT_LIMIT,ADDL_DAYS_POLICY_EXPDT from (SELECT to_char(POLICY_EFF_FROM,'yyyy-mm-dd') POLICY_EFF_FROM, to_char(POLICY_EFF_TO,'yyyy-mm-dd') POLICY_EFF_TO,OP_APPROVED_NO_OF_DAYS,OP_APPROVED_AMT_LIMIT,ADDL_DAYS_POLICY_EXPDT FROM BL_INS_POLICY_TYPE_HDR WHERE POLICY_TYPE_CODE = '@policyTypeCode' AND CUST_GROUP_CODE = '@customerGroupcode' AND (CUST_CODE = '@customerCode' OR CUST_CODE = '**') and nvl(POLICY_EFF_TO,trunc(sysdate)) >= trunc(sysdate) order by decode(cust_code,'**',999,1)) where rownum = 1 ");
			}
			System.err.println("sql in LoadDefaultPolicyDateAndApprovedAmount.jsp BEFORE:::::: "+sql);
			sql.replace(sql.indexOf(cGId),sql.indexOf(cGId)+cGId.length(),  customerGroupcode);
			sql.replace(sql.indexOf(cId),sql.indexOf(cId)+cId.length(),  customerCode);
			sql.replace(sql.indexOf(pTCId),sql.indexOf(pTCId)+pTCId.length(),  policyTypeCode);
			System.err.println("sql in LoadDefaultPolicyDateAndApprovedAmount.jsp AFTER:::::: "+sql);

			preparedStatement = connection.prepareStatement(sql.toString());
			resultSet=preparedStatement.executeQuery();
				
			if( resultSet != null ) 
			{
				while(resultSet.next())
				{
					
					Str=Str+checkForNull(resultSet.getString(1))+"~"+checkForNull(resultSet.getString(2))+"~"+checkForNull(resultSet.getString(3))+"~"+checkForNull(resultSet.getString(4))+"~"+checkForNull(resultSet.getString(5))+"~";
				}
			}
			System.err.println("Str in LoadDefaultPolicyDateAndApprovedAmount.jsp AFTER:::::: "+Str);
			obj.addProperty("Value", Str);
		}
		catch(Exception e)
		{
			System.err.println("EXCEPTION IN LoadDefaultPolicyDateAndApprovedAmount.jsp.::::: "+e); 
		}
		finally
		{
			if(resultSet!=null) resultSet.close();
			if(preparedStatement!=null) preparedStatement.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);			
		}
	}else if(called_for.equals("validateUserId")){
		System.err.println("In validateUserId");
		String usr_id	= 	request.getParameter("usr_id")==null?"":request.getParameter("usr_id");
		facility_id = request.getParameter("facility_id");
		
		System.err.println("In validate_user_id::: "+usr_id+"::"+facility_id);
		String sql = "{call bl_modify_fin_dtls_3t.validate_user_id(?,?,?)}";
		call = con.prepareCall(sql);
		call.setString(1,facility_id);
		call.setString(2,usr_id);
		call.registerOutParameter(3,java.sql.Types.VARCHAR);
		call.execute();
		String err_out  = call.getString(3);
		
		System.out.println("err_out :: "+err_out);
		if(err_out == null) err_out = "";
		
		obj.addProperty("err_out", err_out);
		System.err.println("obj:::"+obj.toString());
	
	}else if(called_for.equals("validateUserPassword")){
		System.err.println("In validateUserPassword");
		String usr_id	= 	request.getParameter("usr_id")==null?"":request.getParameter("usr_id");
		String pass_wd	= 	request.getParameter("pass_wd")==null?"":request.getParameter("pass_wd");
		facility_id = request.getParameter("facility_id");
		
		System.err.println("In validateUserPassword::: "+usr_id+"::"+pass_wd+"::"+facility_id);
		String sql = "{call bl_modify_fin_dtls_3t.validate_user_password(?,?,?,?,?)}";
		call = con.prepareCall(sql);
		call.setString(1,facility_id);
		call.setString(2,usr_id);
		call.setString(3,pass_wd);
		call.registerOutParameter(4,java.sql.Types.VARCHAR);
		call.registerOutParameter(5,java.sql.Types.VARCHAR);
		call.execute();
		String err_out  = call.getString(4);
		String message_text = call.getString(5);
		
		System.out.println("err_out :: "+err_out+", message_text :: "+message_text);
		if(err_out == null) err_out = "";
		if(message_text == null) message_text = "";
		
		obj.addProperty("err_out", err_out);
		obj.addProperty("message_text", message_text);
	
		System.err.println("obj:::"+obj.toString());
	
	}else if(called_for.equals("validate_cust_code")){
  		System.err.println("In validate_cust_code "+request.getQueryString() );
  		String settlement_ind = request.getParameter("settlement_ind");
  		String adm_rec_flag = request.getParameter("adm_rec_flag");
  		String patient_id = request.getParameter("patient_id");
  		String episode_type = request.getParameter("episode_type");
		String episode_id = request.getParameter("episode_id");
		String visit_id = request.getParameter("visit_id");
  		String blngGrpId = request.getParameter("blngGrpId");
  		String cust_grp_code = request.getParameter("cust_grp_code");
  		String cust_code =  request.getParameter("cust_code");
		String locale = request.getParameter("locale");
		String policy_type_code = "";
  		String priority = request.getParameter("priority");
		String visit_regn_date_time = request.getParameter("visit_regn_date_time");
		System.err.println("visit_regn_date_time:::"+visit_regn_date_time);
		System.err.println("cust_code:::"+cust_code);

		String oldFormat = "yyyy-MM-dd";
		String newFormat = "dd/MM/yyyy";
		SimpleDateFormat sdf1 = new SimpleDateFormat(oldFormat);
		SimpleDateFormat sdf2 = new SimpleDateFormat(newFormat);	   
		try {
			if(visit_regn_date_time!=null && !"".equals(visit_regn_date_time))
				visit_regn_date_time=sdf2.format(sdf1.parse(visit_regn_date_time));
		 } catch (ParseException e) {
			        e.printStackTrace();
		}
		System.err.println("visit_regn_date_time after conversion:::"+visit_regn_date_time);
  		
  		String procSql = "{call bl_modify_fin_dtls_3t.validate_cust_code(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
  		try{
  			con = ConnectionManager.getConnection();
  			
  			System.err.println(procSql);
  			call = con.prepareCall(procSql);
  			call.setString(1, facility_id);
			call.setString(2, patient_id);
			call.setString(3, episode_id);
			call.setString(4, visit_id);
  			call.setString(5, blngGrpId);
  			call.setString(6, cust_grp_code);
  			call.setString(7, cust_code);					
  			call.setString(8, episode_type);
  			call.setString(9, policy_type_code);							
  			call.setString(10, priority);			
  			call.setString(11, settlement_ind);	
  			call.setString(12, adm_rec_flag);		
  			call.setString(13, "");		//p_default_yn passing blank
   			call.setString(14, locale);
  			System.err.println("All in param are set");
  			//call.setString(15, visit_regn_date_time);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilDate = sdf.parse(visit_regn_date_time);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            System.err.println("sqlDate "+sqlDate);
            call.setDate(15, sqlDate); // Pass the date as java.sql.Date
			
  			call.registerOutParameter(16, java.sql.Types.DATE);
  			call.registerOutParameter(17, java.sql.Types.DATE);
  			call.registerOutParameter(18, java.sql.Types.VARCHAR);
  			call.registerOutParameter(19, java.sql.Types.VARCHAR);
  			call.registerOutParameter(20, java.sql.Types.VARCHAR);
  			call.registerOutParameter(21, java.sql.Types.VARCHAR);
  			call.registerOutParameter(22, java.sql.Types.VARCHAR);
  			call.registerOutParameter(23, java.sql.Types.VARCHAR);
  			call.registerOutParameter(24, java.sql.Types.VARCHAR);
  			call.registerOutParameter(25, java.sql.Types.VARCHAR);
  			call.registerOutParameter(26, java.sql.Types.VARCHAR);
  			call.registerOutParameter(27, java.sql.Types.VARCHAR);
  			call.execute();
  			System.err.println("After execute the procedure");
  			String err_out = call.getString(26);
			if(err_out == null) err_out = "";
  			String message_text = call.getString(27);
			if(message_text == null) message_text = "";
  			
  			System.err.println(err_out+"~"+message_text);
  			obj.addProperty("err_out", err_out);
			obj.addProperty("message_text", message_text);
  		}catch(Exception ex){
  			ex.printStackTrace();
  		}
  	}
	System.out.println(obj);
	out.println(obj.toString()); 
}catch(Exception e)
{
	e.printStackTrace();
	System.err.println("exception in BLModifyFinDtlsAjax::"+e);	
}finally{
	if(call!=null) call.close();
	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();
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
