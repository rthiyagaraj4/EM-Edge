package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.CommonBean;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __instrumentcountlistframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/InstrumentCountListFrame.jsp", 1709120234000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n<!--\nDeveloped by    : Bhavani Shankar.\nModule/Function : Frame having Instrument Count List\nStart Date\t\t: 07/02/2006\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!-- CRF-268 Instrument Count - Rajesh V -->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eOT/js/InstrumentCount.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n</head>\n<title>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</title>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"InstrumentCountListForm\" id=\"InstrumentCountListForm\">\n<table cellpadding=3=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\">\n\t<tr id=\"instr_count_set_hdr_table\">\n\t<td class=\"columnHeader\" width=\"3%\"></td>\n\t<td class=\"columnHeader\" width=\"35%\" >\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t</td>\n\t<td class=\"columnHeader\"  width=\"35%\" >\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t</td>\n\t<!-- CRF-268 Instrument Count - Rajesh V -->\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<td class=\"columnHeader\" width=\"19%\"  >\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t</td>\n\t<td class=\"columnHeader\" width=\"19%\"  >\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t</td>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<!-- CRF-268 Instrument Count - Rajesh V -->\n\t</tr>\t\t\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<tr>\n\t<input type=\"hidden\" name=\"oper_code_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\"oper_code_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\"hidden\" name=\"set_code_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"set_code_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\"hidden\" name=\"tray_num_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"tray_num_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t<input type=\"hidden\" name=\"initial_count_cmpl_yn_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"initial_count_cmpl_yn_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"\tvalue=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=\"hidden\" name=\"final_count_cmpl_yn_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"final_count_cmpl_yn_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\n\t<td class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"ind_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" width=\"3%\" nowrap></td>\n\t<td class=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\"oper_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" style=\"font-size:7pt;font-weight:normal;\" width=\"60%\" nowrap> ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t</td>\n\t<td class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"set_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" style=\"font-size:7pt;font-weight:normal;\" wrap width=\"15%\" nowrap> ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t</td>\n\t<td style=\"font-size:7pt;font-weight:normal;color:blue\" class=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"tray_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"  width=\"20%\" onClick=\"populateDetails(\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\');\" nowrap>\n\t\t<font class=\'HYPERLINK\' style=\"font-size:7pt;color:blue;cursor:pointer;font-weight:normal\">\n\t\t<!-- CRF-268 Instrument Count - Rajesh V-->\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t</font>\n\t</td>\n\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t<td class=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"alloc_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t</td>\t\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t<!-- CRF-268 Instrument Count - Rajesh V-->\n\t</tr>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n</table>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="  <input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\"hidden\" name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\"hidden\" name=\"total_rows\" id=\"total_rows\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\t\n\t<input type=\"hidden\" name=\"oper_num\" id=\"oper_num\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\t\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\t\n\t<input type=\"hidden\" name=\"booking_num\" id=\"booking_num\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\t\n\t<input type=\"hidden\" name=\"oper_code\" id=\"oper_code\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\t\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
 String locale = (String)session.getAttribute("LOCALE"); 
	String otParam=""; 
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

	String params = request.getQueryString();
	String facility_id = (String)session.getValue("facility_id");
	String booking_num	= request.getParameter("booking_num");
	String oper_num		= request.getParameter("oper_num");
	String patient_id	= request.getParameter("patient_id");
	booking_num=booking_num==null?"":booking_num;
	booking_num=booking_num.equalsIgnoreCase("null")?"":booking_num;
	oper_num=oper_num==null?"":oper_num;
	oper_num=oper_num.equalsIgnoreCase("null")?"":oper_num;
	String tray_num  =  "",set_desc =  "",oper_code = "",oper_desc = "",set_code="",map_key = "",hdr_sql = "",item_sql = "",sql = "";
	String bean_id	 = "InstrumentCountBean";
	String bean_name = "eOT.InstrumentCountBean";
	InstrumentCountBean bean = (InstrumentCountBean)mh.getBeanObject( bean_id, request, bean_name );
	bean.clear();
	HashMap item_map = null;
	HashMap temp_map = null;
	Connection connection   = null ;
	PreparedStatement pstmt = null ;
	PreparedStatement item_pstmt = null ;
	PreparedStatement hdr_pstmt = null ;
	ResultSet rs = null ;
	ResultSet item_resultset = null ;
	ResultSet hdr_resultset = null ;
	int row_num = 0;
	//CRF-268 Instrument Count - Rajesh V
	int allocAty = 0;
	String itemType = "";
	//CRF-268 Instrument Count - Rajesh V
	
	try{
		connection	= ConnectionManager.getConnection(request);
		//CRF-268 Instrument Count - Rajesh V
		String sqlOtParam = "select NVL(cssd_interface_yn,'N') facility from ot_param_for_facility where operating_facility_id = ?";

		pstmt = connection.prepareStatement(sqlOtParam);
		pstmt.setString(1,facility_id);
		rs=pstmt.executeQuery();
		if(rs !=null && rs.next())
		{
			otParam=rs.getString("facility");		
		}
		pstmt = null;
		rs = null;
		
		if("Y".equalsIgnoreCase(otParam)){
			item_sql = "SELECT SURGERY_DATE, TEAM_DOCTOR_CODE, BOOKING_NUM, OPER_NUM, DOC_NUM, SET_CODE, TRAY_NUM, ITEM_TYPE, A.ITEM_CODE ITEM_CODE, ITEM_NAME, NVL(B.CONSUMABLE_YN,'N') CONSUMABLE_YN, STD_QTY, CSSD_QTY, OPEN_QTY, INITIAL_STATUS, INITIAL_STATUS_REMARKS, RETURN_QTY, FINAL_STATUS, FINAL_REMARKS, NVL(FINALIZED_YN,'N') FINALIZED_YN,GENERAL_REMARKS FROM OT_STORE_ISSUE_DTLS A, OT_SS_COMPONENTS B WHERE OPERATING_FACILITY_ID = ? AND nvl(BOOKING_NUM,'XX')=NVL( ?,nvl(BOOKING_NUM,'XX'))  AND OPER_NUM=? AND PATIENT_ID = ? AND OPER_CODE=? AND SET_CODE=? AND A.ITEM_CODE=B.ITEM_CODE";
			hdr_sql = "SELECT NVL(INITIAL_COUNT_CMPL_YN,'N') INITIAL_COUNT_CMPL_YN, NVL(FINAL_COUNT_CMPL_YN,'N') FINAL_COUNT_CMPL_YN FROM OT_STORE_ISSUE_HDR WHERE OPERATING_FACILITY_ID = ? AND nvl(BOOKING_NUM,'XX')=NVL( ?,nvl(BOOKING_NUM,'XX'))   AND OPER_NUM=? AND PATIENT_ID = ? AND SET_CODE=? ";
			sql =	"SELECT opl.oper_code,(select short_desc from ot_oper_mast where oper_code = opl.oper_code) oper_desc, "+
					" opl.item_type,opl.item_id,(select short_desc from ot_instrument where instr_code = opl.item_id) desce, no_of_units "+
					" FROM ot_pick_lists opl "+
					" WHERE opl.OPERATING_FACILITY_ID = ? "+
					" AND NVL(opl.BOOKING_NUM,'XX')   =NVL( ?,NVL(opl.BOOKING_NUM,'XX')) "+
					" AND opl.PATIENT_ID = ? and opl.item_type = 'I' and opl.CSSD_STATUS='F'";
		}
		else{
			item_sql = "SELECT SURGERY_DATE, TEAM_DOCTOR_CODE, BOOKING_NUM, OPER_NUM, DOC_NUM, SET_CODE, TRAY_NUM, ITEM_TYPE, A.ITEM_CODE ITEM_CODE, ITEM_NAME, NVL(B.CONSUMABLE_YN,'N') CONSUMABLE_YN, STD_QTY, CSSD_QTY, OPEN_QTY, INITIAL_STATUS, INITIAL_STATUS_REMARKS, RETURN_QTY, FINAL_STATUS, FINAL_REMARKS, NVL(FINALIZED_YN,'N') FINALIZED_YN,GENERAL_REMARKS FROM OT_STORE_ISSUE_DTLS A, OT_SS_COMPONENTS B WHERE OPERATING_FACILITY_ID = ? AND nvl(BOOKING_NUM,'XX')=NVL( ?,nvl(BOOKING_NUM,'XX'))  AND OPER_NUM=? AND PATIENT_ID = ? AND OPER_CODE=? AND SET_CODE=? AND TRAY_NUM=? AND A.ITEM_CODE=B.ITEM_CODE";
			hdr_sql = "SELECT NVL(INITIAL_COUNT_CMPL_YN,'N') INITIAL_COUNT_CMPL_YN, NVL(FINAL_COUNT_CMPL_YN,'N') FINAL_COUNT_CMPL_YN FROM OT_STORE_ISSUE_HDR WHERE OPERATING_FACILITY_ID = ? AND nvl(BOOKING_NUM,'XX')=NVL( ?,nvl(BOOKING_NUM,'XX'))   AND OPER_NUM=? AND PATIENT_ID = ? AND SET_CODE=? AND TRAY_NUM=?";
			sql = "SELECT OPER_CODE, OPER_DESC, SET_CODE, SET_DESC, TRAY_NUM FROM OT_SET_DETAILS_VW WHERE OPERATING_FACILITY_ID = ? AND nvl(BOOKING_NUM,'XX')=NVL( ?,nvl(BOOKING_NUM,'XX'))  AND OPER_NUM=? AND PATIENT_ID = ?";
		}
		//CRF-268 Instrument Count - Rajesh V
		item_pstmt		= connection.prepareStatement(item_sql) ;
		hdr_pstmt		= connection.prepareStatement(hdr_sql) ;

		pstmt	= connection.prepareStatement(sql) ;
		pstmt.setString(1,facility_id);
		pstmt.setString(2,booking_num);
		//CRF-268 Instrument Count - Rajesh V
		if("Y".equalsIgnoreCase(otParam)){
			pstmt.setString(3,patient_id);
		}
		else{
			pstmt.setString(3,oper_num);
			pstmt.setString(4,patient_id);
		}
		//CRF-268 Instrument Count - Rajesh V
		rs		= pstmt.executeQuery();

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
if("Y".equalsIgnoreCase(otParam)){ 
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{ 
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
} 
            _bw.write(_wl_block17Bytes, _wl_block17);

	int item_count=0;
	String classvalue = "";
	String initial_count_cmpl_yn = "";
	String final_count_cmpl_yn = "";
	while(rs!=null && rs.next()){
		row_num++;
		item_map=new HashMap();
		if ( row_num % 2 == 0 )
			classvalue = "gridData" ;
		else
			classvalue = "gridData" ;
		
		//CRF-268 Instrument Count - Rajesh V
		if("Y".equalsIgnoreCase(otParam)){
			oper_code	= rs.getString("OPER_CODE");
			oper_desc	= rs.getString("OPER_DESC");
			set_desc	= rs.getString("desce");
			set_code	= rs.getString("item_id");
			itemType	= rs.getString("item_type");
			allocAty    =  rs.getInt("no_of_units");
		}
		else{
			oper_code	= rs.getString("OPER_CODE");
			oper_desc	= rs.getString("OPER_DESC");
			set_desc	= rs.getString("SET_DESC");
			set_code	= rs.getString("SET_CODE");
			tray_num	= rs.getString("TRAY_NUM");
		}

		//CRF-268 Instrument Count - Rajesh V

		hdr_pstmt.setString(1,facility_id);
		hdr_pstmt.setString(2,booking_num);
		hdr_pstmt.setString(3,oper_num);
		hdr_pstmt.setString(4,patient_id);
		hdr_pstmt.setString(5,set_code);
		//CRF-268 Instrument Count - Rajesh V
		if(!("Y".equalsIgnoreCase(otParam))){
			hdr_pstmt.setString(6,tray_num);	
		}
		//CRF-268 Instrument Count - Rajesh V
		if(hdr_resultset!=null) hdr_resultset.close();
		hdr_resultset	= hdr_pstmt.executeQuery();
		while(hdr_resultset!=null && hdr_resultset.next()){
			initial_count_cmpl_yn	= hdr_resultset.getString("INITIAL_COUNT_CMPL_YN");
			final_count_cmpl_yn		= hdr_resultset.getString("FINAL_COUNT_CMPL_YN");
		}
		item_pstmt.setString(1,facility_id);
		item_pstmt.setString(2,booking_num);
		item_pstmt.setString(3,oper_num);
		item_pstmt.setString(4,patient_id);
		item_pstmt.setString(5,oper_code);
		item_pstmt.setString(6,set_code);
		//CRF-268 Instrument Count - Rajesh V
		if(!("Y".equalsIgnoreCase(otParam))){
			item_pstmt.setString(7,tray_num);	
		}
		//CRF-268 Instrument Count - Rajesh V
		if(item_resultset!=null) item_resultset.close();
		item_resultset	= item_pstmt.executeQuery();
		item_count=0;
		while(item_resultset!=null && item_resultset.next()){
			item_count++;
			temp_map=new HashMap();
			temp_map.put("SET_CODE",set_code);
			temp_map.put("TRAY_NUM",tray_num);
			temp_map.put("SURGERY_DATE",item_resultset.getString("SURGERY_DATE"));
			temp_map.put("ITEM_TYPE",item_resultset.getString("ITEM_TYPE"));
			temp_map.put("ITEM_CODE",item_resultset.getString("ITEM_CODE"));
			temp_map.put("CONSUMABLE_YN",item_resultset.getString("CONSUMABLE_YN"));			
			temp_map.put("ITEM_NAME",item_resultset.getString("ITEM_NAME"));
			temp_map.put("STD_QTY",item_resultset.getString("STD_QTY"));
			temp_map.put("CSSD_QTY",item_resultset.getString("CSSD_QTY"));
			temp_map.put("OPEN_QTY",item_resultset.getString("OPEN_QTY"));
			temp_map.put("INITIAL_STATUS",item_resultset.getString("INITIAL_STATUS"));
			temp_map.put("INITIAL_STATUS_REMARKS",item_resultset.getString("INITIAL_STATUS_REMARKS"));
			temp_map.put("RETURN_QTY",item_resultset.getString("RETURN_QTY"));
			temp_map.put("FINAL_STATUS",item_resultset.getString("FINAL_STATUS"));
			temp_map.put("FINALIZED_YN",item_resultset.getString("FINALIZED_YN"));
			temp_map.put("INITIAL_STATUS_REMARKS",item_resultset.getString("INITIAL_STATUS_REMARKS"));
			temp_map.put("FINAL_REMARKS",item_resultset.getString("FINAL_REMARKS"));
			temp_map.put("GENERAL_REMARKS",item_resultset.getString("GENERAL_REMARKS"));
			temp_map.put("INITIAL_COUNT_CMPL_YN",initial_count_cmpl_yn);
			temp_map.put("FINAL_COUNT_CMPL_YN",final_count_cmpl_yn);
			
			temp_map.put("UPDATE_FLAG","N");
			item_map.put(item_count+"",temp_map);
		}
		map_key=oper_code+set_code+tray_num;	
		bean.storeSetDetails(map_key,item_map); // store the Item Details in the bean
		bean.storeMapKeys(map_key); // store the Item Details in the bean

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(set_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tray_num));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(initial_count_cmpl_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(final_count_cmpl_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(oper_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(set_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block41Bytes, _wl_block41);
if("Y".equalsIgnoreCase(otParam)){
			out.println(itemType);
		}
		else{
			out.println(tray_num);
		}
		
            _bw.write(_wl_block42Bytes, _wl_block42);
if("Y".equalsIgnoreCase(otParam)){
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(allocAty));
            _bw.write(_wl_block45Bytes, _wl_block45);
} 
            _bw.write(_wl_block46Bytes, _wl_block46);

	}// end of while

            _bw.write(_wl_block47Bytes, _wl_block47);

if(item_resultset!=null) item_resultset.close();	
	}catch ( Exception e ) {
		System.err.println("Caught Exception error in InstrumentCountListFrame: "+e);
		e.printStackTrace() ;
	}finally {
		try{
			if(rs!=null) rs.close();
			if(hdr_pstmt!=null) hdr_pstmt.close();
			if(hdr_resultset!=null) hdr_resultset.close();
			if(item_resultset!=null) item_resultset.close();			
			if(pstmt!=null) pstmt.close();
			if(item_pstmt!=null) item_pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection,request);
		}catch(Exception es){es.printStackTrace();}
	}

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(params));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(row_num));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(booking_num));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(oper_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block57Bytes, _wl_block57);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.InstrumentCount.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Set.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AllocatedQuantity.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Tray.label", java.lang.String .class,"key"));
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
