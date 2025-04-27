package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BLReportIdMapper;
import java.sql.Date;
import eBL.*;
import eBL.Common.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.io.*;
import java.math.*;
import java.net.*;
import java.util.*;
import java.text.*;
import com.ehis.util.*;
import webbeans.op.CurrencyFormat;
import webbeans.eCommon.*;
import org.apache.commons.codec.binary.Base64;
import java.util.*;
import com.ehis.util.*;

public final class __blinsackpymtsearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eBL/jsp/BLInsAckPymtSearchResult.jsp", 1713248478515L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1669269240778L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\r\n<script>\r\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\";\r\n</script>\r\n\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\r\n<script language=\"javascript\" src=\"../../eBL/js/BLInsAckPymt.js\"></script>\r\n\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n<HTML>\r\n<HEAD>\r\n\r\n</HEAD>\r\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\r\n\t\t\r\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\t\t\r\n<script>\r\n\r\nfunction loadBtnFrame(){\r\n\tparent.frames[0].document.getElementById(\'search_button\').disabled=false; \r\n\tvar totalRecords = document.getElementById(\"totalRecords\").value;\r\n\tvar recAvailForSel = document.getElementById(\"recAvailForSel\").value;\r\n\t\r\n\tif(recAvailForSel == 0)\r\n\t\tdocument.getElementById(\"checkheader\").disabled = true;\r\n\t\r\n\tif(totalRecords > 0)\r\n\t\tparent.frames(2).document.location.href = \"../../eBL/jsp/BLInsAckPymtBtn.jsp\";\r\n}\r\n\r\n</script>\r\n    \r\n<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onLoad=\"loadBtnFrame();\" >\r\n<form name=\"BLInsAckPymtSearchResultForm\" enctype=\"multipart/form-data\">\r\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\r\n\r\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\t<div class=\"table-container\">\r\n\t\t\t<TABLE class=\'grid\' border=1 width=\"100%\" cellspacing=0 cellpadding=3 align=\'center\'>\r\n\t\t\t<thead>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<th class=\'columnheadercenter\' width=\"2%\"><input type=\"checkbox\" id=\"checkheader\" name=\"checkheader\" onclick=\"selectAll(this)\" value=\"\"/></th>\r\n\t\t\t\t\t<th class=\'columnheadercenter\' width=\"10%\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\r\n\t\t\t\t\t<th class=\'columnheadercenter\' width=\"8%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\r\n\t\t\t\t\t<th class=\'columnheadercenter\' width=\"20%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\r\n\t\t\t\t\t<th class=\'columnheadercenter\' width=\"10%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\r\n\t\t\t\t</tr>\r\n\t\t\t</thead>\r\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\r\n\t\t<tbody>\r\n\t\t<tr>\r\n\t\t\t<td><input type=\"checkbox\" id=\"select_record_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" name=\"select_record_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" onclick=\"selectRecord(this)\" value=\"\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" /></td>\r\n\t\t\t<td>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\r\n\t\t\t<td>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\r\n\t\t\t<input type=\'hidden\' name=\'payerGrpCode_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'payerGrpCode_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'payerCode_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'payerCode_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'pymtRefID_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'pymtRefID_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'pymtAmount_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'pymtAmount_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'pymtRecdDate_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'pymtRecdDate_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\t\t\t\r\n\t\t\t<input type=\'hidden\' name=\'pymtRefStatus_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'pymtRefStatus_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\r\n\t\t\t<input type=\"hidden\" id=\"checkedStatus_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" name=\"checkedStatus_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" value=\"N\" >\r\n\t\t\t<input type=\"hidden\" id=\"patientID_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" name=\"patientID_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\r\n\t\t\t<input type=\"hidden\" id=\"encounterID_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" name=\"encounterID_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\r\n\t\t\t<input type=\"hidden\" id=\"pymtCurrType_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" name=\"pymtCurrType_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\r\n\t\t</tr>\r\n\t\t\t\t\t\r\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\r\n<Script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\r\nparent.frames(3).document.location.href = \'../../eCommon/html/blank.html\';\t\r\n</script>\r\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\r\n\t\t\t<input type=\'hidden\' name = \"facility_id\" id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\r\n\t\t\t<input type=\'hidden\' name = \"locale\" id=\'locale\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\r\n\t\t\t<input type=\'hidden\' name = \"totalRecords\" id=\'totalRecords\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\t\r\n\t\t\t<input type=\'hidden\' name = \"recAvailForSel\" id=\'recAvailForSel\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\t\r\n\t\t\t<input type=\'hidden\' name = \"qryPayerGrpCode\" id=\'qryPayerGrpCode\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\t\r\n\t\t\t<input type=\'hidden\' name = \"qryPayerGrpDesc\" id=\'qryPayerGrpDesc\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\t\t\r\n\t\t\t<input type=\'hidden\' name = \"qryPayerCode\" id=\'qryPayerCode\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\t\r\n\t\t\t<input type=\'hidden\' name = \"qryPayerDesc\" id=\'qryPayerDesc\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\t\t\r\n\t\t\t<input type=\'hidden\' name = \"qryPymtRefID\" id=\'qryPymtRefID\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\t\r\n\t\t\t<input type=\'hidden\' name = \"qryPymtRefFromDate\" id=\'qryPymtRefFromDate\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\t\r\n\t\t\t<input type=\'hidden\' name = \"qryPymtRefToDate\" id=\'qryPymtRefToDate\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\t\r\n\t\t\t<input type=\'hidden\' name = \"qryPymtRefStatus\" id=\'qryPymtRefStatus\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\t\t\r\n\t</tbody>\r\n</table>\r\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\r\n</form>\r\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\r\n</body>\t\r\n\t\r\n</HTML>\r\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		ResultSet rst1=null;
		BLHelper blHelper = null;

		try
		{
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			System.err.println("params IN BLInsAckPymtSearchResult.jsp is: "+params);
			
			con=ConnectionManager.getConnection(request);
			String sql = "";
			StringBuilder sqlBuilder = new StringBuilder();
			
			String facilityId = (String)session.getAttribute("facility_id");
			String locale = (String)session.getAttribute("LOCALE");
			String pymtCurrType = "";
			
			String qryPayerGrpCode = checkForNull(request.getParameter("payerGroupCode"));
			String qryPayerGrpDesc = checkForNull(request.getParameter("payerGroupDesc"));
			String qryPayerCode = checkForNull(request.getParameter("payerCode"));
			String qryPayerDesc = checkForNull(request.getParameter("payerDesc"));
			String qryPymtRefID = checkForNull(request.getParameter("pymtRefID"));
			String qryPymtRefFromDate = checkForNull(request.getParameter("pymtRefFromDate"));
			String qryPymtRefToDate =checkForNull(request.getParameter("pymtRefToDate"));
			String qryPymtRefStatus = checkForNull(request.getParameter("pymtRefStatus"));

			int column_count = 1, totalRecords = 0, recAvailForSel = 0;
			String payer_Group = "", payer = "", policy_type = "", visit_Dt_Admit_Dt = "";
			String checkout_Dis_Dt = "";

			CurrencyFormat cf1 = new CurrencyFormat();	
			boolean amountRoundOff = true;
			int noofdecimal=2;
			String disabled = "";
			
			CurrencyFormat cf = new CurrencyFormat();
			
			String dispCurr = blHelper.getCurrencyDetails(con, facilityId);

            _bw.write(_wl_block4Bytes, _wl_block4);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

		try{
			pstmt = con.prepareStatement("select BILL_ROUNDING_IND  from bl_parameters");
			rst = pstmt.executeQuery();	
			if ( rst != null && rst.next()) {
				if(rst.getString("BILL_ROUNDING_IND").trim().equalsIgnoreCase("0")) {
					amountRoundOff = false;
				}
			}

			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rst = pstmt.executeQuery();	
			while(rst.next())
			{
				noofdecimal  =  rst.getInt(1);		
			}			
		}
		catch(Exception e)
		{
			System.out.println("Exception in try of BLRCMTransGenerateBillResult.jsp for currency setup --"+e.toString());
			e.printStackTrace();
		}	
	
		try
		{
			sqlBuilder.append("SELECT RECEIPT_REF_NUM as RECEIPT_REF_NUM, RECEIPT_AMT RECEIPT_AMT, a.cust_group_code as  CUST_GRP_CODE, DECODE (a.cust_group_code,'**', 'All Payer Group',(SELECT grp.long_desc FROM ar_cust_group grp WHERE grp.cust_group_code =  a.cust_group_code)) CUST_GRP_DESC, a.cust_code as CUST_CODE, DECODE (a.cust_code,'**', 'All Payer',(SELECT cust.long_name FROM ar_customer cust WHERE cust.cust_code = a.cust_code)) CUST_DESC, to_char(a.REC_REF_DATE,'dd/MM/yyyy') REC_REF_DATE, to_char(a.ACK_DATE,'dd/MM/yyyy') ACK_DATE, a.STATUS STATUS, a.REMARKS REMARKS, b.LIST_ELMT_LABEL as CLAIM_STATUS_DESC, ENCOUNTER_ID as ENCOUNTER_ID, PATIENT_ID as PATIENT_ID FROM BL_CLAIM_BILL_ACK_DTLS a, sm_list_item b WHERE a.OPERATING_FACILITY_ID = ? AND a.status = b.LIST_ELMT_VALUE AND b.MODULE_ID = 'BL' AND b.LIST_REF = 'L_INS_PYMT_STATUS'");
					
			if(!"".equals(qryPayerGrpCode))
				sqlBuilder.append(" and (a.CUST_GROUP_CODE = nvl(?,a.CUST_GROUP_CODE))");
			
			if(!"".equals(qryPayerCode))
				sqlBuilder.append(" and (a.CUST_CODE = nvl(?,a.CUST_CODE))");
			
			if(!"".equals(qryPymtRefID))
				sqlBuilder.append(" and (a.RECEIPT_REF_NUM = nvl(?,a.RECEIPT_REF_NUM))");
			
			if(!"".equals(qryPymtRefFromDate) && !"".equals(qryPymtRefToDate))
				sqlBuilder.append(" and trunc(a.REC_REF_DATE) between to_date( ? ,'DD/MM/YYYY') AND to_date( ? ,'DD/MM/YYYY')");					
					
			if(!"".equals(qryPymtRefStatus))
				sqlBuilder.append(" and a.STATUS = ?  ");
			
			sqlBuilder.append("ORDER BY RECEIPT_REF_NUM DESC");
			
			pstmt = con.prepareStatement(sqlBuilder.toString());
			
			pstmt.setString(column_count,facilityId);
			
			if(!"".equals(qryPayerGrpCode))
				pstmt.setString(++column_count,qryPayerGrpCode);
			if(!"".equals(qryPayerCode))
				pstmt.setString(++column_count,qryPayerCode);
			if(!"".equals(qryPymtRefID))
				pstmt.setString(++column_count,qryPymtRefID);
			if(!"".equals(qryPymtRefFromDate) && !"".equals(qryPymtRefToDate)){
				pstmt.setString(++column_count,qryPymtRefFromDate);
				pstmt.setString(++column_count,qryPymtRefToDate);
			}
			if(!"".equals(qryPymtRefStatus))
					pstmt.setString(++column_count,qryPymtRefStatus);

			System.err.println("Sql is: "+sql);
			
			rst = pstmt.executeQuery();		

			while (rst.next())
			{				
				if(!"P".equals(checkForNull(rst.getString("STATUS"))))
					disabled = "disabled";
				else
					disabled = "";
				
				if("P".equals(rst.getString("STATUS")))
					recAvailForSel = recAvailForSel + 1;
				

            _bw.write(_wl_block8Bytes, _wl_block8);

				if(totalRecords == 0)
				{

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

		}

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(checkForNull(rst.getString("RECEIPT_REF_NUM"))));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( ("".equals(checkForNull(rst.getString("RECEIPT_AMT")))) ? "" : cf.formatCurrency(checkForNull(rst.getString("RECEIPT_AMT")), noofdecimal) ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(rst.getString("CUST_GRP_DESC"))));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(rst.getString("CUST_DESC"))));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(rst.getString("REC_REF_DATE"))));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(rst.getString("ACK_DATE"))));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(rst.getString("CLAIM_STATUS_DESC"))));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(rst.getString("REMARKS"))));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rst.getString("CUST_GRP_CODE")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rst.getString("CUST_CODE")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rst.getString("RECEIPT_REF_NUM")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rst.getString("RECEIPT_AMT")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rst.getString("REC_REF_DATE")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rst.getString("STATUS")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rst.getString("PATIENT_ID")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rst.getString("ENCOUNTER_ID")));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dispCurr));
            _bw.write(_wl_block41Bytes, _wl_block41);

				totalRecords = totalRecords + 1;
			}
		}catch(Exception e){
			System.err.println("Query Result Exception= "+e.toString());
			out.println("Error in BLInsAckPymtSearchResult.jsp -> "+e.toString());
		}
		
		if(totalRecords == 0){

            _bw.write(_wl_block42Bytes, _wl_block42);

		}
		else{

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(recAvailForSel));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(qryPayerGrpCode));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(qryPayerGrpDesc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(qryPayerCode));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(qryPayerDesc));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(qryPymtRefID));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(qryPymtRefFromDate));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(qryPymtRefToDate));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(qryPymtRefStatus));
            _bw.write(_wl_block55Bytes, _wl_block55);
			
		}

            _bw.write(_wl_block56Bytes, _wl_block56);
	
		}catch(Exception e){
			System.err.println("Exception in BLInsAckPymtSearchResult.jsp: "+e);
		}finally{
			if(pstmt!=null)	pstmt.close();
			if(rst!=null)	rst.close();
			ConnectionManager.returnConnection(con,request);		
		}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PYMT_REF_ID.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.amount.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReceivedDate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AcknowledgementDate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
}
