package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.apache.derby.tools.sysinfo;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.sql.Date;
import eBL.*;
import eBL.Common.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.math.*;
import java.net.*;
import java.text.*;
import eBL.BLReportIdMapper;
import webbeans.op.CurrencyFormat;
import webbeans.eCommon.*;
import org.apache.commons.codec.binary.Base64;
import java.sql.*;
import webbeans.eCommon.*;
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import com.ehis.util.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __bleclaimsstatuswisedashboard extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLEClaimsStatusWiseDashboard.jsp", 1709114488492L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<link rel=\"stylesheet\" type=\"text/css\"\thref=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script>\n<script language=\'javascript\' src=\'../../eBL/js/BLEClaim.js\'></script>\n<script language=\'javascript\' src=\'../../eBL/js/RCMTransactions.js\'></script>\n\n<style type=\"text/css\">\nspan.a\n{\n\tbackground: #ffffff;\n\tborder: solid 1px #CCCCCC;\n\theight: 150px;\n\tdisplay:inline-block;\n    margin:10px 0;\n    border-radius:5px;\n\tcursor: pointer;\n}\n.box_title2\n{\n\twidth: 220px;\n\theight: 35px;\n    font-size: 12px;\n    font-weight: normal;\n    padding-left: 10px;\n    padding-top: 10px;\n    padding-bottom: 10px;\n    padding-right: 10px;\n    color: #ffffff;\n    ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n    background-color: #83AAB4;\n    ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n    background-color: #A3BF8A;\n    ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n    background-color: #DDC68E;\n    ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n    background-color: #B2B6D7;\n    ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n    background-color: #D696D0;\n    ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n    line-height: 10px;\n    font-family: verdana;\n\ttext-align: center;\n\twhite-space: nowrap;\n\t\n}\n.box_text\n{\n\tpadding-left: 10px;\n    padding-top: 10px;\n    padding-bottom: 10px;\n    padding-right: 10px;\n\tfont-family: verdana;\n\ttext-align: center;\n\tvertical-align: middle;\n\n}\n.txt\n{\n\tfont-family: verdana;\n\tfont-size: 30pt;\n\tfont-weight: bold;\n}\n.text\n{\n\tpadding-left: 10px;\n    padding-top: 10px;\n    padding-bottom: 10px;\n    padding-right: 10px;\n\tfont-family: verdana;\n\ttext-align: center;\n\tvertical-align: middle;\n\n}\t\n</style>\n</head>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n<BODY onKeyDown=\"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\" >\n<form id = \"statusWiseDashboard\" name = \"statusWiseDashboard\">\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\n\t\t\t<table width=\"100%\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"COLUMNHEADER\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>  \n\t\t\t<div>\n\t\t\t\t<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<span class=\"a\" id =\"payer\" onclick=\"onClickStatus(\'**\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');return false\">\n\t\t\t\t\t\t\t<div class=\"box_title2\" >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</div>\n\t\t\t\t\t\t\t<div class=\"box_text txt\" id=\"totalBillServices\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</div>\n\t\t\t\t\t\t\t<div class=\"text\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</div>\n\t\t\t\t\t\t</span>\n\t\t\t\t</label>      \n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\n\t\t\t<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<span class=\"a\" id =\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" onclick=\"onClickStatus(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\');return false\">\n\t\t\t\t\t<div class=\"box_title2\" >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</div>\n\t\t\t\t\t<div class=\"box_text txt\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</div>\n\t\t\t\t\t<div class=\"text\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</div>\n\t\t\t\t</span>\n\t\t\t</label>        \n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t</div>\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<script type=\"text/javascript\">\n\t\t\tdocument.getElementById(\"totalBillServices\").innerHTML = ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =";</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\t\n\t<Script>\n\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t</script>\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"/>\n\t<input type=\"hidden\" name=\"login_user\" id=\"login_user\" id=\"login_user\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"/>\n\t<input type=\'hidden\' name=\'click_count\' id=\'click_count\' id=\'click_count\' value=\'0\'>\n\t\n\t<input type=\"hidden\" id=\"p_facility_id\" name=\"p_facility_id\" id=\"p_facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t<input type=\"hidden\" id=\"p_patient_id\" name=\"p_patient_id\" id=\"p_patient_id\"\tvalue=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t<input type=\"hidden\" id=\"p_episode_type\" name=\"p_episode_type\" id=\"p_episode_type\"\tvalue=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t<input type=\"hidden\" id=\"p_encounter_id\" name=\"p_encounter_id\" id=\"p_encounter_id\"\tvalue=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<input type=\"hidden\" id=\"p_approval_doc_ref_no\" name=\"p_approval_doc_ref_no\" id=\"p_approval_doc_ref_no\"\tvalue=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t<input type=\"hidden\" id=\"p_claim_id\" name=\"p_claim_id\" id=\"p_claim_id\"\tvalue=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t<input type=\"hidden\" id=\"p_payer_grp_code\" name=\"p_payer_grp_code\" id=\"p_payer_grp_code\"\tvalue=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t<input type=\"hidden\" id=\"p_payer_code\" name=\"p_payer_code\" id=\"p_payer_code\"\tvalue=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t<input type=\"hidden\" id=\"p_policy_type_code\" name=\"p_policy_type_code\" id=\"p_policy_type_code\"\tvalue=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t<input type=\"hidden\" id=\"p_insurance_Status\" name=\"p_insurance_Status\" id=\"p_insurance_Status\"\tvalue=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\"hidden\" id=\"p_State_dur_from_date\" name=\"p_State_dur_from_date\" id=\"p_State_dur_from_date\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\"hidden\" id=\"p_State_dur_to_date\" name=\"p_State_dur_to_date\" id=\"p_State_dur_to_date\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\"hidden\" id=\"p_claims_services_level\" name=\"p_claims_services_level\" id=\"p_claims_services_level\"\tvalue=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\n</form>\n</BODY>\n</html>\n\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}

	
	private String checkForNull(String inputString, String dfltVal)
	{
		return (inputString == null) ? dfltVal : inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
if(sStyle.equals("IeStyle.css")){
            _bw.write(_wl_block8Bytes, _wl_block8);
}
    else if(sStyle.equals("IeStyleLime.css")){
            _bw.write(_wl_block9Bytes, _wl_block9);
}
    else if(sStyle.equals("IeStyleOrange.css")){
            _bw.write(_wl_block10Bytes, _wl_block10);
}
    else if(sStyle.equals("IeStyleBlue.css")){
            _bw.write(_wl_block11Bytes, _wl_block11);
}
    else if(sStyle.equals("IeStyleVoilet.css")){
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con=null;
	PreparedStatement pstmt = null;
	ResultSet rst=null;
	String sql = "";
	int row_count = 0;
	int column_count = 1;
	int totalBillServices = 0;
	
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_user = (String) p.getProperty("login_user");
	System.err.println("login_user in BLEClaimsStatusWiseDashboard.jsp:"+login_user);
	
	String facilityId = (String)session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("locale");
	if(locale == null) locale = "en";
	String qry_patient_id = checkForNull(request.getParameter("patient_id"));
	String qry_encounter_id = checkForNull(request.getParameter("encounter_id"));
	String qry_episode_type = checkForNull(request.getParameter("episode_type"));
	String qry_payer_grp_code = checkForNull(request.getParameter("payer_grp_code"));
	String qry_payer_code = checkForNull(request.getParameter("payer_code"));
	String qry_policy_type_code = checkForNull(request.getParameter("policy_type_code"));
	String qry_State_dur_from_date = checkForNull(request.getParameter("State_dur_from_date"));
	String qry_State_dur_to_date = checkForNull(request.getParameter("State_dur_to_date"));
	String qry_insurance_Status = checkForNull(request.getParameter("insurance_Status"));	
	String qry_approval_doc_ref_no = checkForNull(request.getParameter("approval_doc_ref_no"));
	String qry_claim_id = checkForNull(request.getParameter("claim_id"));
	String qry_cusName = checkForNull(request.getParameter("cusName"));
	String qry_claims_services_level = checkForNull(request.getParameter("claims_services_level"));
	//String prevActionID = checkForNull(request.getParameter("prevActionID"));
	
	System.err.println("URL Parameters :- Payer Name= "+qry_cusName+", Patient_id= "+qry_patient_id+", Episode_type="+qry_episode_type+" , Encounter_id="+qry_encounter_id+", Statement_duration_from_date="+qry_State_dur_from_date+", Statement_duration_to_date="+qry_State_dur_to_date+", Insurance_Status="+qry_insurance_Status+", Payer_grp_code="+qry_payer_grp_code+", Payer_code="+qry_payer_code+", Policy_type_code="+qry_policy_type_code+", Approval_doc_ref_no="+qry_approval_doc_ref_no+", Claim_id="+qry_claim_id+", facilityId = "+facilityId+", Claims_services_level = "+qry_claims_services_level);

            _bw.write(_wl_block14Bytes, _wl_block14);

	try{
		con	=	ConnectionManager.getConnection(request);
		sql = "SELECT b.claim_status,l.list_elmt_label claim_status_name, COUNT (1) cnt FROM BL_CLAIM_BILL_DTL b, SM_LIST_ITEM l WHERE b.operating_facility_id = ? ";
		if(!"".equals(qry_patient_id)){
			sql = sql + "AND b.patient_id = ? ";
		}	
		if(!"".equals(qry_episode_type)){
			sql = sql + "AND b.EPISODE_TYPE = ? ";
		}
		if(!"".equals(qry_encounter_id)){
			sql = sql + "AND b.encounter_id = ? ";
		}
		if(!"".equals(qry_payer_grp_code)){
			sql = sql + "AND b.cust_group_code = ? ";
		}
		if(!"".equals(qry_payer_code)){
			sql = sql + "AND b.cust_code = ? ";
		}
		if(!"".equals(qry_policy_type_code)){
			sql = sql + "AND b.policy_type_code = ? ";
		}
		if(!"".equals(qry_approval_doc_ref_no)){
			sql = sql + "AND b.appr_doc_ref_number = ? ";
		}
		if(!"".equals(qry_claim_id)){
			sql = sql + "AND b.claim_id = ? ";
		}
		if(!qry_insurance_Status.equals("**")){
	        sql = sql + "AND b.claim_status = ? ";
		}
		if(!"".equals(qry_State_dur_from_date) && !"".equals(qry_State_dur_to_date)){
			sql = sql +"AND (trunc(b.DOC_REF_DATE) between trunc((to_date(?,'dd/MM/YYYY'))) and trunc((to_date(?,'dd/MM/YYYY')))) ";
		}
        sql = sql + "AND ? = 'C' and b.claim_status = l.LIST_ELMT_VALUE and l.module_id = 'BL' and l.list_ref = 'L_INS_CLAIM_STATUS' GROUP BY b.claim_status,l.list_elmt_label ";
		sql = sql + "union ";
		sql = sql + "SELECT  a.claim_status,l.list_elmt_label claim_status_name, COUNT (1) FROM bl_claim_service_dtl a, SM_LIST_ITEM l,(select operating_facility_id,bill_doc_type_code,bill_doc_num,patient_id,encounter_id,cust_code from BL_CLAIM_BILL_DTL where operating_facility_id = ? ";
		if(!"".equals(qry_patient_id)){
			sql = sql + "AND patient_id = ? ";
		}	
		if(!"".equals(qry_episode_type)){
			sql = sql + "AND EPISODE_TYPE = ? ";
		}
		if(!"".equals(qry_encounter_id)){
			sql = sql + "AND encounter_id = ? ";
		}
		if(!"".equals(qry_payer_grp_code)){
			sql = sql + "AND cust_group_code = ? ";
		}
		if(!"".equals(qry_payer_code)){
			sql = sql + "AND cust_code = ? ";
		}
		if(!"".equals(qry_policy_type_code)){
			sql = sql + "AND policy_type_code = ? ";
		}
		if(!"".equals(qry_approval_doc_ref_no)){
			sql = sql + "AND appr_doc_ref_number = ? ";
		}
		if(!"".equals(qry_claim_id)){
			sql = sql + "AND claim_id = ? ";
		}
		if(!"".equals(qry_State_dur_from_date) && !"".equals(qry_State_dur_to_date)){
			sql = sql +"AND (trunc(DOC_REF_DATE) between trunc((to_date(?,'dd/MM/YYYY'))) and trunc((to_date(?,'dd/MM/YYYY')))) ";
		}
		sql = sql + ") b WHERE a.operating_facility_id = b.operating_facility_id AND a.bill_doc_type_code = b.bill_doc_type_code AND a.bill_doc_num = b.bill_doc_num ";
		if(!qry_insurance_Status.equals("**")){
			sql = sql + "AND a.claim_status = ? ";
		}
		sql = sql + "AND ? = 'S' AND a.claim_status = l.LIST_ELMT_VALUE AND l.module_id = 'BL' and l.list_ref = 'L_INS_CLAIM_STATUS' GROUP BY a.claim_status,l.list_elmt_label";
				
		System.err.println("sql to load data : "+sql);
	      	  
       	pstmt = con.prepareStatement(sql);
       	
		pstmt.setString(column_count,facilityId);
		if(!"".equals(qry_patient_id)){
			pstmt.setString(++column_count,qry_patient_id);	
		}
		if(!"".equals(qry_episode_type)){
			pstmt.setString(++column_count,qry_episode_type);
		}
		if(!"".equals(qry_encounter_id)){						
			pstmt.setString(++column_count,qry_encounter_id);
		}
		if(!"".equals(qry_payer_grp_code)){
			pstmt.setString(++column_count,qry_payer_grp_code);	
		}
		if(!"".equals(qry_payer_code)){	
			pstmt.setString(++column_count, qry_payer_code);
		}
		if(!"".equals(qry_policy_type_code)){			
			pstmt.setString(++column_count, qry_policy_type_code);
		}
		if(!"".equals(qry_approval_doc_ref_no)){
			pstmt.setString(++column_count, qry_approval_doc_ref_no);
		}
		if(!"".equals(qry_claim_id)){
			pstmt.setString(++column_count, qry_claim_id);
		}
		if(!"**".equals(qry_insurance_Status)){
			pstmt.setString(++column_count, qry_insurance_Status);	
		}
		if(!"".equals(qry_State_dur_from_date) && !"".equals(qry_State_dur_to_date)){
			pstmt.setString(++column_count,qry_State_dur_from_date);						
			pstmt.setString(++column_count, qry_State_dur_to_date);	  
		}
		pstmt.setString(++column_count, qry_claims_services_level);	  
		pstmt.setString(++column_count,facilityId);
		if(!"".equals(qry_patient_id)){
			pstmt.setString(++column_count,qry_patient_id);	
		}
		if(!"".equals(qry_episode_type)){
			pstmt.setString(++column_count,qry_episode_type);
		}
		if(!"".equals(qry_encounter_id)){						
			pstmt.setString(++column_count,qry_encounter_id);
		}
		if(!"".equals(qry_payer_grp_code)){
			pstmt.setString(++column_count,qry_payer_grp_code);	
		}
		if(!"".equals(qry_payer_code)){	
			pstmt.setString(++column_count, qry_payer_code);
		}
		if(!"".equals(qry_policy_type_code)){			
			pstmt.setString(++column_count, qry_policy_type_code);
		}
		if(!"".equals(qry_approval_doc_ref_no)){
			pstmt.setString(++column_count, qry_approval_doc_ref_no);
		}
		if(!"".equals(qry_claim_id)){
			pstmt.setString(++column_count, qry_claim_id);
		}
		if(!"".equals(qry_State_dur_from_date) && !"".equals(qry_State_dur_to_date)){
			pstmt.setString(++column_count,qry_State_dur_from_date);						
			pstmt.setString(++column_count, qry_State_dur_to_date);	  
		}
		if(!qry_insurance_Status.equals("**")){
			pstmt.setString(++column_count, qry_insurance_Status);	
		}
		pstmt.setString(++column_count, qry_claims_services_level);	  		
		
		System.err.println("sql to load data column_count: "+column_count);
		
		rst = pstmt.executeQuery();
		while ( rst.next() ){
			String insStatus = checkForNull(rst.getString("claim_status"));
			String insStatusName = checkForNull(rst.getString("claim_status_name"));
			int count = rst.getInt(3);
			totalBillServices = totalBillServices + count;
			row_count++;
			//System.out.println("Insurance Status : "+insStatusName+", Payer : "+qry_cusName+", Count : "+count); 
			if(row_count == 1)
			{
			
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( qry_cusName));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(qry_payer_code));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(totalBillServices));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
} 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(insStatus));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(insStatus));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(qry_payer_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(insStatusName));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(count));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
	
		System.err.println("Result count : "+row_count+", Total Bills/Services: "+totalBillServices); 
		if(row_count > 0 && totalBillServices > 0 ){ 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(totalBillServices));
            _bw.write(_wl_block31Bytes, _wl_block31);
  }
		if(row_count == 0){
	
            _bw.write(_wl_block32Bytes, _wl_block32);

		}
	
            _bw.write(_wl_block33Bytes, _wl_block33);

	}catch(Exception e){
		e.printStackTrace();
	}finally{
		pstmt.close();
		con.close();
	}

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(qry_patient_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(qry_episode_type));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(qry_encounter_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(qry_approval_doc_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(qry_claim_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(qry_payer_grp_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(qry_payer_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(qry_policy_type_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(qry_insurance_Status));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(qry_State_dur_from_date));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(qry_State_dur_to_date));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(qry_claims_services_level));
            _bw.write(_wl_block49Bytes, _wl_block49);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.INS_Status_By.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ALL.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ClickDetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ClickDetails.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
