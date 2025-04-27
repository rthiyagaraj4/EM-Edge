package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
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
import webbeans.eCommon.*;
import org.apache.commons.codec.binary.Base64;
import java.util.*;
import com.ehis.util.*;

public final class __bldischcleargenerateresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLDischClearGenerateResult.jsp", 1742750820083L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\"javascript\" src=\"../../eBL/js/BLDischClear.js\"></script>\n<HTML>\n<HEAD>\n</HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\"BLDischClearQueryResult\" id=\"BLDischClearQueryResult\">\n<P>\n<table align=\'right\'>\n<tr>\n<td>\t\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n</td>\n</tr>\n</table>\n<br>\n</p>\n<table class=\'grid\' border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' align=\'center\'>\n\t<td class=\'columnheadercenter\' nowrap></td>\n\t<td class=\'columnheadercenter\' nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td class=\'columnheadercenter\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t<td class=\'columnheadercenter\' nowrap colspan=\"2\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\t\t\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<tr>\n\t\t\t<td class=\"gridData\" nowrap><input type=\"radio\" id=\"bl_disc_clear_count_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" name=\"bl_disc_clear_count\" onclick=\"checkAuthorization(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\')\" value=\"\"></td>\n\t\t\t<td class=\"gridData\" nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t<td class=\"gridData\" nowrap>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t<td class=\"gridData\" nowrap colspan=\"2\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\n\t\t\t<input type=\"hidden\" name=\"patientId_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"patientId_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"episodeType_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"episodeType_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"episodeId_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"  id=\"episodeId_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"encounterId_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"encounterId_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"acctSeqNo_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"acctSeqNo_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"admissionDt_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"  id=\"admissionDt_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"curWardCode_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"curWardCode_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"curBedClassCode_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" id=\"curBedClassCode_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"curRoomNum_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"curRoomNum_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"curBedNum_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" id=\"curBedNum_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"curPhysicianId_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"curPhysicianId_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"docType_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" id=\"docType_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"docNumber_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\"docNumber_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"discAdviceAtTo_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"discAdviceAtTo_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"patOutsAmt_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" id=\"patOutsAmt_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"/>\n\t\n\t</tr>\t\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\t\n\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"/>\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"/>\n\t<input type=\"hidden\" name=\"login_user\" id=\"login_user\" id=\"login_user\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"/>\n\t<input type=\"hidden\" name=\"row_count\" id=\"row_count\" id=\"row_count\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"/>\n\t<input type=\"hidden\" name=\"reasonCode\" id=\"reasonCode\" id=\"reasonCode\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"/>\n\t<input type=\"hidden\" name=\"userId\" id=\"userId\" id=\"userId\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"/>\n\t<input type=\"hidden\" name=\"authRemarks\" id=\"authRemarks\" id=\"authRemarks\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"/>\n\t <input type=\'hidden\' name=\'valid_user_rec_found_YN\' id=\'valid_user_rec_found_YN\' id=\'valid_user_rec_found_YN\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"/>\n\t<input type=\"hidden\" name=\"is_record_selected\" id=\"is_record_selected\" id=\'is_record_selected\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"/>\n\t\n\t<input type=\"hidden\" name=\"patientId\" id=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"/>\n\t<input type=\"hidden\" name=\"nursingUnitCode\" id=\"nursingUnitCode\" id=\"nursingUnitCode\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"/>\n\t<input type=\"hidden\" name=\"episodeId\" id=\"episodeId\" id=\"episodeId\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"/>\n\t<input type=\"hidden\" name=\"discAdviceDtFrom\" id=\"discAdviceDtFrom\" id=\"discAdviceDtFrom\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"/>\n\t<input type=\"hidden\" name=\"discAdviceAtTo\" id=\"discAdviceAtTo\" id=\"discAdviceAtTo\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"/>\n\t<input type=\"hidden\" name=\"option_val\" id=\"option_val\" id=\"option_val\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"/>\n\t<input type=\"hidden\" name=\"from_next\" id=\"from_next\" id=\"from\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"/>  <!-- V230313 -->\n\t<input type=\"hidden\" name=\"to_next\" id=\"to_next\" id=\"to\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"/>  <!-- V230313 -->\n\t<input type=\"hidden\" name=\"from_prev\" id=\"from_prev\" id=\"from\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"/>  <!-- V230313 -->\n\t<input type=\"hidden\" name=\"to_prev\" id=\"to_prev\" id=\"to\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"/>  <!-- V230313 -->\n\t<input type=\"hidden\" name=\"total_rec\" id=\"total_rec\" id=\"total_rec\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"/>\n</table>\t\t\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );
	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
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

/*
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
----------------------------------------------------------------------------------------------
1	     V230313         42420    	 PMG2022-COMN-CRF-0009-US002	Namrata Charate
----------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
			
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		
		try
		{
			
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			
			java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_user = (String) p.getProperty("login_user");
			
			String facilityId = (String)session.getAttribute("facility_id");
			String locale = (String)session.getAttribute("LOCALE");
			String patient_Id = checkForNull(request.getParameter("patient_id"));
			String episode_Id = checkForNull(request.getParameter("episode_id"));
			String nursing_Unit_Code = checkForNull(request.getParameter("nursing_unit"));
			String disc_Advice_Dt_From =checkForNull(request.getParameter("disc_advice_dt_from"));
			String disc_Advice_Dt_To = checkForNull(request.getParameter("disc_advise_dt_to"));
			String option_val = checkForNull(request.getParameter("option_val"));
			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;
			String total_rec = request.getParameter( "total_rec" ) ;
			String sql = "";
			String patientName = "", patientId = "", episodeId= "", nursingUnitCode = "", discAdviceDtFrom="", discAdviceAtTo ="";
			String episodeType = "", admissionDt = "", docNumber = "", docType = "", patOutsAmt = "" , encounterId = "" , curAcctSeqNo = "", curWardCode="", curBedClassCode = "", curRoomNum = "", curBedNum = "", curPhysicianId = "", reasonCode = "", userId = "", 
			authRemarks = "", discClearanceDocTypeCode = "", docType_docNum = "";
			
			String row_count = "";
			String is_record_selected = "N";
			String valid_user_rec_found_YN = "N";
			
			int maxRecord = 0;
			int start = 0 ;
			int end = 0 ;
			int i = 1;
			int cnt = 0;
			
			if ( from == null )
				start = 1 ;
			else
				start = Integer.parseInt( from ) ;

			if ( to == null )
				end = 15 ;  //V230313
			else
				end = Integer.parseInt( to ) ;
			
			if ( total_rec == null )
				maxRecord = 0 ;
			else
				maxRecord = Integer.parseInt( total_rec ) ;
			
			con=ConnectionManager.getConnection(request);
			
			try
			{
				if(start == 1){
					sql = "Select count(*) as total from ip_episode a, bl_episode_fin_dtls b, "+
								" ip_discharge_advice c  "+
								" where a.facility_id= b.operating_facility_id "+
								" AND A.PATIENT_ID=B.PATIENT_ID "+
								" AND b.PATIENT_ID=c.PATIENT_ID "+
								" and b.operating_facility_id= c.facility_id "+
								" and a.episode_type = b.episode_type "+
								" and a.episode_id =b.episode_id "+
								" and b.episode_id =c.encounter_id "+
								" and c.DIS_ADV_STATUS='0' "+
								" and a.facility_id= ? "+
								" AND B.PATIENT_ID=NVL( ? ,B.PATIENT_ID) "+
								" AND B.EPISODE_ID=NVL( ? ,B.EPISODE_ID) "+
								" AND A.CUR_WARD_CODE=NVL( ? ,A.CUR_WARD_CODE) "+
								" and c.DIS_ADV_DATE_TIME is not null "+
								" and (( ? ='Y' and b.DISCH_BILL_DOC_NUMBER is not null) or ( ? ='N'   and b.DISCH_BILL_DOC_NUMBER is null) or ? ='B' )  "+
								" and not exists  "+
								" (select 'X' from BL_ENC_DISCHARGE_CLEARANCE e  "+
								" where e.episode_type = b.episode_type and e.patient_id = b.patient_id and e.episode_id = b.episode_id "+
								" and operating_facility_id= ? and nvl(cancelled_yn,'N')='N') "+
								" AND trunc(c.DIS_ADV_DATE_TIME) BETWEEN NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-JAN-1000 00:00:00' "+      
								" ,'DD-MON-YYYY HH24:MI:SS')) AND NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-DEC-4100 00:00:00' "+
								" ,'DD-MON-YYYY HH24:MI:SS'))  "+
								" order by a.ADMISSION_DATE_TIME desc ";
				
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1,facilityId);
					pstmt.setString(2,patient_Id);
					pstmt.setString(3,episode_Id);
					pstmt.setString(4,nursing_Unit_Code);
					pstmt.setString(5,option_val);
					pstmt.setString(6,option_val);
					pstmt.setString(7,option_val);
					pstmt.setString(8,facilityId);
					System.err.println("disc_Advice_Dt_From: "+disc_Advice_Dt_From);
					pstmt.setString(9,disc_Advice_Dt_From);
					System.err.println("disc_Advice_Dt_To: "+disc_Advice_Dt_To);
					pstmt.setString(10,disc_Advice_Dt_To);
					System.err.println("Here we are");
					System.err.println("Query is: "+sql);	
					rst = pstmt.executeQuery();
				
					rst.next();
					cnt = rst.getInt("total");
					
					if(cnt == 0){
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
					} 
					maxRecord = cnt;
					System.err.println("Total records count is: "+cnt);
				}	
		}catch(Exception e){
			System.err.println("Query Result Exception= "+e.toString());
		}
		
		System.err.println("maxRecord value is: "+maxRecord);
		
		try
		{
			sql = "Select b.episode_type EPISODE_TYPE,b.patient_id PATIENT_ID,b.episode_id EPISODE_ID, "+
					" to_char(a.ADMISSION_DATE_TIME,'dd-MM-yyyy HH24:mi:ss') Admission_dt_dec, "+ 
					" to_char(c.DIS_ADV_DATE_TIME,'dd-MM-yyyy HH24:mi:ss') Discharge_dt_dec, "+
							" b.DISCHARGE_BILL_GEN_IND, b.DISCH_BILL_DOC_TYPE_CODE Doc_Type, "+
							" b.DISCH_BILL_DOC_NUMBER Doc_Number ,A.CUR_WARD_CODE CUR_WARD_CODE, "+
							" A.CUR_ROOM_NUM CUR_ROOM_NUM, A.CUR_BED_NUM CUR_BED_NUM, A.CUR_PHYSICIAN_ID CUR_PHYSICIAN_ID, "+
							" A.CUR_BED_CLASS_CODE CUR_BED_CLASS_CODE, "+
							" B.CUR_ACCT_SEQ_NO CUR_ACCT_SEQ_NO, "+
							" A.ENCOUNTER_ID ENCOUNTER_ID,B.DISCHARGE_BILL_DATE_TIME, (select sum(nvl(BILL_TOT_OUTST_AMT,0)) "+
							" from bl_bill_hdr"+
							" where operating_facility_id= ? "+
							" and patient_id=NVL( ? ,B.PATIENT_ID) "+
							" and episode_id=NVL( ? ,B.EPISODE_ID) "+
							" and episode_type=b.episode_type "+
							" AND BILL_NATURE_CODE='C' AND nvl(BILL_STATUS,'!') "+
							" not in ('C','D')) PAT_OUTST_AMT, "+
							" ( "+
							" select decode( ? ,'en',short_name,SHORT_NAME_LOC_LANG) "+
							" FROM MP_PATIENT_MAST "+
							" WHERE PATIENT_ID=NVL( ? ,B.PATIENT_ID) "+
							" ) PATIENT_NAME "+
							" from ip_episode a, bl_episode_fin_dtls b,ip_discharge_advice c  "+
							" where a.facility_id= b.operating_facility_id "+
							" AND A.PATIENT_ID=B.PATIENT_ID "+
							" AND b.PATIENT_ID=c.PATIENT_ID "+
							" and b.operating_facility_id= c.facility_id "+
							" and a.episode_type = b.episode_type "+
							" and a.episode_id =b.episode_id "+
							" and b.episode_id =c.encounter_id "+
							" and c.DIS_ADV_STATUS='0' "+
							" and a.facility_id= ? "+
							" AND B.PATIENT_ID=NVL( ? ,B.PATIENT_ID) "+
							" AND B.EPISODE_ID=NVL( ? ,B.EPISODE_ID) "+
							" AND A.CUR_WARD_CODE=NVL( ? ,A.CUR_WARD_CODE) "+
							" and c.DIS_ADV_DATE_TIME is not null "+
							" and (( ? ='Y' and b.DISCH_BILL_DOC_NUMBER is not null) or ( ? ='N'   and b.DISCH_BILL_DOC_NUMBER is null) or ? ='B' )  "+
							" and not exists  "+
							" (select 'X' from BL_ENC_DISCHARGE_CLEARANCE e  "+
							" where e.episode_type = b.episode_type and e.patient_id = b.patient_id and e.episode_id = b.episode_id "+
							" and operating_facility_id= ? and nvl(cancelled_yn,'N')='N') "+
							" AND trunc(c.DIS_ADV_DATE_TIME) BETWEEN NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-JAN-1000 00:00:00' "+      
							" ,'DD-MON-YYYY HH24:MI:SS')) AND NVL((to_date( ? ,'DD/MM/YYYY')),TO_DATE('01-DEC-4100 00:00:00' "+
							" ,'DD-MON-YYYY HH24:MI:SS'))  "+
							" order by a.ADMISSION_DATE_TIME desc ";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,facilityId);
			pstmt.setString(2,patient_Id);
			pstmt.setString(3,episode_Id);
			pstmt.setString(4,locale);
			pstmt.setString(5,patient_Id);
			pstmt.setString(6,facilityId);
			pstmt.setString(7,patient_Id);
			pstmt.setString(8,episode_Id);
			pstmt.setString(9,nursing_Unit_Code);
			pstmt.setString(10,option_val);
			pstmt.setString(11,option_val);
			pstmt.setString(12,option_val);
			pstmt.setString(13,facilityId);
			pstmt.setString(14,disc_Advice_Dt_From);
			pstmt.setString(15,disc_Advice_Dt_To);

			rst = pstmt.executeQuery();
					
		}catch(Exception e){
			System.err.println("Query Result Exception= "+e.toString());
		}			

            _bw.write(_wl_block9Bytes, _wl_block9);


if ( !(start <= 1) ){  
	out.println("<a href='#' onclick='prevbtn();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a>");
	
}

if ( !( (start+15) > maxRecord ) )  //V230313
	out.println("<a href='#' onclick='nextbtn();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a>");
	
	
if(maxRecord > 0){

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

}	
		for( int j=1; j<start; i++,j++ )
			rst.next();
		
		while ( rst.next() && i<=end  )
		{	
			docType_docNum = "";  //V230313
			patientId = checkForNull(rst.getString("PATIENT_ID"));	
			patientName = checkForNull(rst.getString("PATIENT_NAME"));
			episodeId = checkForNull(rst.getString("EPISODE_ID"));
			episodeType = checkForNull(rst.getString("Episode_Type"));
			admissionDt = checkForNull(rst.getString("Admission_dt_dec"));
			discAdviceAtTo = checkForNull(rst.getString("Discharge_dt_dec"));
			docType = checkForNull(rst.getString("Doc_Type"));
			docNumber = checkForNull(rst.getString("Doc_Number"));
			patOutsAmt = checkForNull(rst.getString("PAT_OUTST_AMT"));
			encounterId = checkForNull(rst.getString("ENCOUNTER_ID"));
			curAcctSeqNo = checkForNull(rst.getString("CUR_ACCT_SEQ_NO"));
			curWardCode = checkForNull(rst.getString("CUR_WARD_CODE"));
			curBedClassCode = checkForNull(rst.getString("CUR_BED_CLASS_CODE"));
			curRoomNum = checkForNull(rst.getString("CUR_ROOM_NUM"));
			curBedNum = checkForNull(rst.getString("CUR_BED_NUM"));
			curPhysicianId = checkForNull(rst.getString("CUR_PHYSICIAN_ID"));  
			if(!docType.equals(""))
				docType_docNum = docType+"/"+docNumber;

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(docNumber));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patOutsAmt));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patientName));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(episodeId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(episodeType));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(admissionDt));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(discAdviceAtTo));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(docType_docNum));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patOutsAmt));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(episodeType));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(episodeId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(curAcctSeqNo));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(admissionDt));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(curWardCode));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(curBedClassCode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(curRoomNum));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(curBedNum));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(curPhysicianId));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(docType));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(docNumber));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(discAdviceAtTo));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patOutsAmt));
            _bw.write(_wl_block52Bytes, _wl_block52);
		
			i++;
		}

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(reasonCode));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(userId));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(authRemarks));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(valid_user_rec_found_YN));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(is_record_selected));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(patient_Id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(nursing_Unit_Code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(episode_Id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disc_Advice_Dt_From));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(disc_Advice_Dt_To));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(option_val));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(start+15));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(end+15));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(start-15));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(end-15));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block73Bytes, _wl_block73);

	}catch(Exception e){
		out.println("Exception in BLDischClearGenerateResult.jsp: "+e);
		System.err.println("Exception in BLDischClearGenerateResult.jsp: "+e);
	}finally{
		if(pstmt!=null)	pstmt.close();
		if(rst!=null)	rst.close();
		ConnectionManager.returnConnection(con,request);		
	}

            _bw.write(_wl_block74Bytes, _wl_block74);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.episodeid.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EpisodeType.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DISCR_ADV_DATE.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DischargeBillDocType.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Num.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAT_OS_AMT.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }
}
