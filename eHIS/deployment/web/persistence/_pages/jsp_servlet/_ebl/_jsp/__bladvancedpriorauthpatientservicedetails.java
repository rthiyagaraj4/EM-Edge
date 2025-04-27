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
import java.io.*;
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
import java.util.*;
import com.ehis.util.*;

public final class __bladvancedpriorauthpatientservicedetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eBL/jsp/BLAdvancedPriorAuthPatientServiceDetails.jsp", 1717387890407L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\r\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\r\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\r\n<script language=\'javascript\' src=\'../../eBL/js/BLAdvancedPriorAuth.js\'></script>\r\n\r\n<html>\r\n<HEAD>\r\n\t<style>\r\n\t\tdiv.tableContainer {\r\n\t\t\twidth: 100%;\t\t/* table width will be 99% of this*/\r\n\t\t\theight: 160px; \t/* must be greater than tbody*/\r\n\t\t\toverflow: auto;\r\n\t\t\tmargin: 0 auto;\r\n\t\t}\r\n\t\t\r\n\t\ttable {\r\n\t\t\twidth: 100%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\r\n\t\t\tborder: none;\r\n\t\t\tbackground-color: #f7f7f7;\r\n\t\t\t}\r\n\t\t\t\r\n\t\ttable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\r\n\t\t\toverflow: auto; \r\n\t\t\theight: 120x;\r\n\t\t\toverflow-x: hidden;\r\n\t\t\t}\r\n\t\t\t\r\n\t\tthead tr\t{\r\n\t\t\tposition:relative; \r\n\t\t\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\r\n\t\t\t}\r\n\t\t\t\t\r\n\t\t\tdiv.tableContainer {\r\n\t\t\t\twidth: 100%;\t\t/* table width will be 99% of this*/\r\n\t\t\t\theight: 140px; \t/* must be greater than tbody*/\r\n\t\t\t\toverflow: scroll;\r\n\t\t\t\tmargin: 0 auto;\r\n\t\t\t}\t\r\n\t\t\t.LocalYellow\r\n\t\t\t{\r\n\t\t\t\tCOLOR:#444444;\r\n\t\t\t\tBACKGROUND-COLOR: yellow ;\r\n\t\t\t\tFONT-SIZE: 8pt ;\r\n\t\t\t\tborder: 1x;\r\n\t\t\t\tborder-style: dashed;\r\n\t\t\t\tborder-left-color: #D5E2E5;\r\n\t\t\t\tborder-right-color: #D5E2E5;\r\n\t\t\t\tborder-top-color: #D5E2E5;\r\n\t\t\t\tborder-bottom-color: #D5E2E5; \r\n\t\t\t\tPADDING-LEFT:7px;\r\n\t  \t\t\tPADDING-RIGHT:7px\r\n\t\t\t}\r\n\t\t\tSPAN.LABEL\r\n\t\t\t{\r\n\t\t\t  COLOR:#444444;\r\n\t\t\t  /*background-color:#FFFFFF;*/\r\n\t\t\t  background-color:#FFFFFF;\r\n\t\t\t  FONT-SIZE: 8pt;\r\n\t\t\t  TEXT-ALIGN: LEFT;\r\n\t\t\t  /*TEXT-ALIGN: RIGHT;*/\r\n\t\t\t  PADDING-LEFT:7px;\r\n\t\t\t  PADDING-RIGHT:7px\r\n\t\t\t}\r\n\t\t\t\r\n\t\t\tSPAN.LABEL1\r\n\t\t\t{\r\n\t\t\t  COLOR:#444444;\r\n\t\t\t  /*background-color:#FFFFFF;*/\r\n\t\t\t  background-color:#FFFFFF;\r\n\t\t\t  FONT-SIZE: 8pt;\r\n\t\t\t  /*TEXT-ALIGN: LEFT;*/\r\n\t\t\t  TEXT-ALIGN: RIGHT;\r\n\t\t\t  PADDING-LEFT:7px;\r\n\t\t\t  PADDING-RIGHT:7px\r\n\t\t\t}\r\n\t\t\t\r\n\t\t\tSPAN.SpanYellow\r\n\t\t\t{\r\n\t\t\t\tCOLOR:#444444;\r\n\t\t\t\tBACKGROUND-COLOR: yellow ;\r\n\t\t\t\tFONT-SIZE: 8pt ;\r\n\t\t\t\tPADDING-LEFT:7px;\r\n\t\t\t\tPADDING-RIGHT:7px\r\n\t\t\t}\r\n\t\t\ttbody tr.YELLOW{\r\n\t\t\t\tCOLOR:#444444;\r\n\t\t\t\tBACKGROUND-COLOR: yellow ;\r\n\t\t\t}\r\n\t\t\r\n\t</style>\r\n\t\r\n</HEAD>\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'/>\r\n\t\t\r\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n\r\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n<body class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\r\n\r\n<form name=\"BLAdvancedPriorAuthPatientServiceDetailForm\" enctype=\"multipart/form-data\" method=\"post\">\r\n<table cellpadding=3 cellspacing=0  width=\"100%\" border=\"1\">\r\n<div id=\"tableContainer\">\r\n\r\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\r\n\t\r\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\t\r\n<thead>\r\n\t<tr>\r\n\t\t<td class=\'COLUMNHEADER\' nowrap width = \"2%\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\r\n\t\t<td class=\'COLUMNHEADER\' nowrap width = \"5%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </td>\r\n\t\t<td class=\'COLUMNHEADER\' nowrap width = \"5%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\r\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\r\n\t\t<td class=\'COLUMNHEADER\' nowrap width = \"5%\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\r\n\t\t\t<input type=\"checkbox\" id=\"selectAllServices\" name=\"selectAllServices\" onclick=\"checkAllService(this)\" value=\"\" >\r\n\t\t</td>\r\n\t\t<td class=\'COLUMNHEADER\' nowrap width = \"5%\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\r\n\t</tr>\r\n</thead>\r\n<tbody id=\"BLAdvancedPriorAuthPatientServiceDetailTable\" name=\"BLAdvancedPriorAuthPatientServiceDetailTable\">\r\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\r\n\r\n\t<tr id=\'row_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' onclick=\"\">\r\n\t\t<td class=\"field\">\r\n\t\t\t&nbsp;<label name=\'srl_no_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' id=\'srl_no_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</label>\r\n\t\t\t<input type=\"hidden\" name=\"request_id_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"request_id_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" />\r\n\t\t\t<input type=\"hidden\" name=\"seq_no_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"seq_no_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" />\r\n\t\t\t<input type=\"hidden\" name=\"int_request_id_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"int_request_id_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" />\r\n\t\t\t<input type=\"hidden\" name=\"int_response_id_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"int_response_id_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" />\r\n\t\t\t<input type=\"hidden\" name=\"int_first_request_id_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id=\"int_first_request_id_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" />\r\n\t\t\t<input type=\"hidden\" name=\"commnuication_response_id_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"commnuication_response_id_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" />\r\n\t\t\t<input type=\"hidden\" name=\"cust_Code_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" id=\"cust_Code_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" />\r\n\t\t\t<input type=\"hidden\" name=\"cust_grp_code_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"cust_grp_code_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" />\r\n\t\t\t<input type=\"hidden\" name=\"policy_type_code_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" id=\"policy_type_code_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" />\r\n\t\t</td>\t\t\t\t\t\t\r\n\t\t <td class=\"field\" nowrap>\r\n             &nbsp;<label name=\"serv_grp_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" id=\"serv_grp_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</label>\r\n             <input type=\"hidden\" name=\"serv_grp_code_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"serv_grp_code_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\r\n         </td>\r\n\t\t<td class=\"field\" nowrap>\r\n\t\t\t&nbsp;<label  name=\"serv_classification_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" id=\"serv_classification_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</label>\r\n\t\t\t  <input type=\"hidden\" name=\"serv_classification_code_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" id=\"serv_classification_code_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" >\r\n        </td>\r\n\t\t \r\n\t\t <td class=\"field\" nowrap>\r\n         \t&nbsp;<label name=\"blng_serv_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"blng_serv_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</label>\r\n         \t  <input type=\"hidden\" name=\"blng_serv_code_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" id=\"blng_serv_code_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\r\n         </td>\r\n\t\t <td class=\"field\" nowrap>\r\n          \t&nbsp;<label name=\"serv_desc_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" id=\"serv_desc_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</label>\r\n         </td>\r\n\t\t<td class=\"field\" nowrap>\r\n         \t&nbsp;<label name=\"valid_from_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" id=\"valid_from_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</label>\r\n         </td>\r\n\t\t \r\n\t\t <td class=\"field\" nowrap>\r\n         \t&nbsp;<label name=\"valid_to_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" id=\"valid_to_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</label>\r\n         </td>\r\n         <td class=\"field\">\r\n\t\t\t&nbsp;<label name=\'int_response_id_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'int_response_id_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</label>\r\n\t\t</td>\r\n\t\t <td class=\"field\">\r\n\t\t\t&nbsp;<label name=\'APA_status_desc_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' id=\'APA_status_desc_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</label>\r\n\t\t\t<input type=\"hidden\" id=\"APA_status_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" name=\"APA_status_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" />\r\n\t\t</td>\r\n\t\t <td class=\"field\" nowrap>\r\n             &nbsp;<label name=\"approval_no_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" id=\"approval_no_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</label>\r\n         </td>\r\n         <td class=\"field\" nowrap>\r\n\t\t\t&nbsp;<label  name=\"pre_app_status_desc_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"pre_app_status_desc_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</label>\r\n\t\t\t<input type=\"hidden\" id=\"pre_app_status_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" name=\"pre_app_status_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" />\r\n        </td>\r\n\t\t<td class=\"field\" nowrap>\r\n\t\t\t&nbsp;<label  name=\"approved_qty_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"approved_qty_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</label>\r\n        </td>\r\n\t\t \r\n\t\t <td class=\"field\" nowrap>\r\n         \t&nbsp;<label  name=\"approved_amt_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" id=\"approved_amt_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</label>\r\n         </td>\r\n     \r\n\t\t <td class=\"field\" nowrap ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =">\r\n          \t&nbsp;<label name=\"availed_qty_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" id=\"availed_qty_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\"  >";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</label>\r\n         </td>\r\n\t\t<td class=\"field\" nowrap>\r\n         \t<a href=\"#\" name=\"remarks_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"remarks_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" onclick=\"callRemarkPopup(\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\',\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\');\">     ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</a> &nbsp;\r\n         </td>\r\n\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\r\n\t\t <td class=\"field\" nowrap>\r\n\t\t \t&nbsp;<input type=\"checkbox\" id=\"check_service_";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" name=\"check_service_";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" value=\"N\">\r\n         </td>\t\r\n\t\r\n          <td class=\"field\" nowrap>\r\n\t        <input type=\"hidden\" id=\"fileName_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" name=\"fileName_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" value=\"\" >\r\n         \t&nbsp;<input type=\"file\" name=\"patFile_";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" id=\"patFile_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" value=\"\"  size=10 maxlength=40 onchange=\"getFileType(\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\')\" onkeypress=\"return onkeyPressEvent(event);\" >\r\n         \t<input type=\"hidden\"   id=\"DocUplYN";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" name=\"DocUplYN";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" value=\"N\" />\r\n         </td>\t\r\n\t\t\t\t\t\t\r\n\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\t\t\t\t \t\r\n\t</tr> \r\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\t\t\r\n\r\n\t</tbody>\r\n\r\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\t\r\n<Script>\r\n\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\r\n\twindow.close();\r\n</script>\r\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\r\n\t\r\n\t</tbody>\r\n</table>\t\r\n</div>\t \r\n\t<input type=\'hidden\' name=\'called_from_dashboard_YN\' id=\'called_from_dashboard_YN\' value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\r\n\t<input type=\'hidden\' name=\'totalServices\' id=\'totalServices\' value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\r\n\t<input type=\'hidden\' name=\'filePath\' id=\'filePath\' value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'>\t\r\n\t<input type=\'hidden\' name=\'pathExist\' value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'>\t\r\n\t<input type=\'hidden\' name=\'writeAccess\' value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\t\r\n\t<input type=\"hidden\" name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' />\r\n\t<input type=\"hidden\" name=\'nationalId\' id=\'nationalId\' value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' />\r\n\t<input type=\"hidden\" name=\'iqamaId\' id=\'iqamaId\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' />\t\t\t\r\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\r\n</form>\r\n</body>\r\n</html>";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );
	
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

	System.err.println("In BLAdvancedPriorAuthPatientServiceDetails.jsp");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection con=null;
	PreparedStatement pstmt = null;
	ResultSet rst=null;
	String disabled = "";
	String listOfApprDocNum = "";
	String filePath="";
	String pathExist="";
	String writeAccess="";
	String bgcolor = "";
	String facilityId = (String)session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("LOCALE");
	String qry_patient_id = checkForNull(request.getParameter("patientId"));
	String qry_nationalId = checkForNull(request.getParameter("nationalId"));
	String qry_iqamaId = checkForNull(request.getParameter("iqamaId"));
	String called_from_dashboard_YN = request.getParameter("called_from_dashboard_YN");
	String qry_polled_from_date = checkForNull(request.getParameter("polled_from_date"));
	String qry_polled_to_date = checkForNull(request.getParameter("polled_to_date"));
	if(called_from_dashboard_YN == null || called_from_dashboard_YN.equals("")) called_from_dashboard_YN = "N";
	System.err.println(" called_from_dashboard_YN= "+called_from_dashboard_YN);
	System.err.println("URL Parameters :- Patient_id= "+qry_patient_id+",  nationalId="+qry_nationalId+", iqamaId="+qry_iqamaId+", facilityId: "+facilityId+", called_from_dashboard_YN: "+called_from_dashboard_YN+", qry_polled_from_date: "+qry_polled_from_date+", qry_polled_to_date: "+qry_polled_to_date);


            _bw.write(_wl_block7Bytes, _wl_block7);

	try{
		
		con=ConnectionManager.getConnection(request);
		// Query to get file path for copying uploaded doc STARTS here 
		String sqlFilePath = "select adv_pri_auth_doc_path from bl_parameters where OPERATING_FACILITY_ID = ? ";
		pstmt = con.prepareStatement(sqlFilePath);
		pstmt.setString(1,facilityId);
		
		rst = pstmt.executeQuery();
		while(rst.next())
		{
			filePath = rst.getString(1) == null ? "" : rst.getString(1);
		}
		System.out.println("filePath in jsp "+filePath);
	//	filePath = filePath.replace("\\", "/");
		System.err.println("filePath  1 "+filePath);
		String separator = System.getProperty( "file.separator" );
		File f = new File(filePath);
		if(f.exists())
		{
			pathExist="true";
			File file1 = new File(filePath+separator+System.currentTimeMillis()+".txt"); 
			try
			{
				if (file1.createNewFile())
				{
					writeAccess="true";
					file1.delete();
				}
				else
				{
					writeAccess="false";
				}
			}
			catch (IOException e)
	        {
				writeAccess="false";
	        }
		}
		else
		{
			pathExist="false";
		}
		System.out.println("filePath after:" + filePath);
		
		
	}
	catch(Exception e)
	{
		System.out.println("Exception while getting path in BLAdvancedPriorAuthPatientServiceDetails.jsp --"+e.toString());
		e.printStackTrace();
	}
	finally{
		if(rst != null) rst.close();
		if(pstmt != null) pstmt.close(); 
	}

            _bw.write(_wl_block0Bytes, _wl_block0);
	
	int noofdecimal = 2;
	try
	{		
		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2),to_char(sysdate,'dd/mm/yyyy HH24:MI'),to_char(sysdate,'dd/mm/yyyy') from  sm_acc_entity_param where acc_entity_id='ZZ'");
		ResultSet rscurr = pstmt.executeQuery();	
		while(rscurr.next())
		{
			noofdecimal  =  rscurr.getInt(1);
		}	
		if(rscurr!=null) rscurr.close();
		pstmt.close();
	}
	catch(Exception e)
	{
		System.out.println("Exception in No of Decimal Query="+e.toString());
	} 
	CurrencyFormat cf = new CurrencyFormat();


	
	try
	{
		String sql = "";
		int row_count = 0;
		int column_count = 0;
		String remarks = "";
		String bill_Number ="", apprDocRefNum ="", bill_Doc_Type_Code = "";
		java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_user = (String) p.getProperty("login_user");
		
		sql = "select a.BLNG_SERV_GROUP, b.long_desc serv_grp_desc,a.BLNG_SERV_CLASS,nvl(c.long_desc, g.long_desc) serv_class_desc,a.BLNG_SERV_CODE, nvl(d.long_desc, g.long_desc) serv_Desc,"
				+" to_char(a.EFFECTIVE_FROM,'dd/MM/yyyy') EFFECTIVE_FROM,"
				+" to_char(a.EFFECTIVE_TO,'dd/MM/yyyy') EFFECTIVE_TO, a.APA_STATUS, "
				+" e.list_elmt_label AS apa_status_desc,  a.PRE_APP_STATUS, f.list_elmt_label AS pre_app_status_desc, "
				+" a.PRE_APP_NUM , a.APPROVED_QTY, a.APPROVED_AMOUNT, a.UTILIZED_QTY, a.REMARKS ,"
				+" a.REQUEST_ID , a.SEQ_NO ,a.INT_REQUEST_ID , a.int_response_id , a.INT_FIRST_REQUEST_ID , a.COMMNUICATION_RESPONSE_ID, "
				+" a.CUST_CODE , a.CUST_GROUP_CODE ,  a.POLICY_TYPE_CODE ,a.BLNG_SERV_DESC BLNG_SERV_DESC"
			    +" from BL_INS_ADV_PRE_AUTH a, bl_blng_serv_grp b, bl_serv_classification c, bl_blng_serv d , sm_list_item e, sm_list_item f, mm_item g "
			    +" where a.BLNG_SERV_GROUP = b.serv_grp_code(+)"
			    +" and NVL(b.STATUS,'$')='$'"
			    +" and a.BLNG_SERV_CLASS = c.serv_classification_code(+)"
			    +" and NVL(c.STATUS,'$')='$'"
			    +" and a.BLNG_SERV_CODE = D.BLNG_SERV_CODE(+)"
			    +" AND a.blng_serv_code = g.item_code(+)"
			    +" and NVL(d.STATUS,'$')='$' "
				+" AND a.apa_status = e.list_elmt_value "
				+" AND e.module_id = 'BL' "
				+" AND e.list_ref = 'L_APA_STATUS' "
				+" AND a.pre_app_status = f.list_elmt_value "
				+" AND f.module_id = 'BL' "
				+" AND f.list_ref = 'L_INS_APA_STATUS' ";
	
		if(!"".equals(qry_polled_from_date) && !"".equals(qry_polled_to_date)){
			sql = sql + "and TRUNC(a.POLLED_DATE) BETWEEN to_date(?,'DD/MM/YYYY') AND to_date(?,'DD/MM/YYYY') ";
		}
		
		if(!"".equals(qry_patient_id)){
			sql = sql + " and a.PATIENT_ID = ? ";
		}
		
		if(!"".equals(qry_nationalId)){
			sql = sql + " and  a.NATIONAL_ID_NO = ? ";
		}
		
		if(!"".equals(qry_iqamaId)){
			sql = sql + " and a.IQAMA_ID = ? ";
		}
				
				
		System.err.println("sql to load data serv :"+sql);
		
		pstmt = con.prepareStatement(sql);		
		
		if(!"".equals(qry_polled_from_date) && !"".equals(qry_polled_to_date)){
			pstmt.setString(++column_count, qry_polled_from_date);	
			pstmt.setString(++column_count, qry_polled_to_date);
		}
		
		if(!"".equals(qry_patient_id))
			pstmt.setString(++column_count, qry_patient_id);			
		
		if(!"".equals(qry_nationalId))
			pstmt.setString(++column_count, qry_nationalId);
		
		if(!"".equals(qry_iqamaId))
			pstmt.setString(++column_count, qry_iqamaId);	

		System.err.println("sql to load data column_count:"+column_count);
				
		rst = pstmt.executeQuery();
		while ( rst.next() )
		{	
			System.err.println(rst.toString());
			disabled = "disabled";
			String blng_serv_group = checkForNull(rst.getString("BLNG_SERV_GROUP"));
			String serv_grp_desc = checkForNull(rst.getString("SERV_GRP_DESC"));
			String blng_serv_class = checkForNull(rst.getString("BLNG_SERV_CLASS"));
			String serv_class_desc = checkForNull(rst.getString("SERV_CLASS_DESC"));
			String blng_serv_code = checkForNull(rst.getString("BLNG_SERV_CODE"));
			String serv_desc = checkForNull(rst.getString("SERV_DESC"));
			String effective_from = checkForNull(rst.getString("EFFECTIVE_FROM"));
			String effective_to = checkForNull(rst.getString("EFFECTIVE_TO"));
			String apa_status = checkForNull(rst.getString("APA_STATUS"));
			String apa_status_desc = checkForNull(rst.getString("APA_STATUS_DESC"));
			String pre_app_num = checkForNull(rst.getString("PRE_APP_NUM"));
			String pre_app_status = checkForNull(rst.getString("PRE_APP_STATUS"));
			String pre_app_status_desc = checkForNull(rst.getString("PRE_APP_STATUS_DESC"));
			String approved_qty = checkForNull(rst.getString("APPROVED_QTY"));
			String approved_amount = checkForNull(rst.getString("APPROVED_AMOUNT"));
			String utilized_qty = checkForNull(rst.getString("UTILIZED_QTY"));
			remarks = checkForNull(rst.getString("REMARKS"));	
			String request_id = checkForNull(rst.getString("REQUEST_ID"));
			String seq_no = checkForNull(rst.getString("SEQ_NO"));
			String int_request_id = checkForNull(rst.getString("INT_REQUEST_ID"));
			String int_response_id = checkForNull(rst.getString("int_response_id"));
			String int_first_request_id = checkForNull(rst.getString("INT_FIRST_REQUEST_ID"));
			String commnuication_response_id = checkForNull(rst.getString("COMMNUICATION_RESPONSE_ID"));
			String cust_code = checkForNull(rst.getString("CUST_CODE"));
			String cust_group_code = checkForNull(rst.getString("CUST_GROUP_CODE"));
			String policy_type_code = checkForNull(rst.getString("POLICY_TYPE_CODE"));
			String blngServDesc = checkForNull(rst.getString("BLNG_SERV_DESC"));//Nphies
			
 			row_count++; 
 			System.err.println("pre_app_status is: "+pre_app_status);
 			if(pre_app_status.equals("C")){
				disabled = "";
				System.err.println("disabled is: "+disabled);
			}
			if(approved_amount != null && !approved_amount.equals("")){
				approved_amount = cf.formatCurrency(approved_amount, noofdecimal);
			} 
	        if(!utilized_qty.equals("") && approved_qty.equals(utilized_qty)){
	        	bgcolor = "style=background-color:green";	
	        }else{
	        	bgcolor = "";	
	        }
	      
 		if(serv_desc.equals("") || serv_desc.equals("null")){
 			serv_desc=blngServDesc;
 		}
 		System.err.println("serv_desc APA is: "+serv_desc);

            _bw.write(_wl_block8Bytes, _wl_block8);

		if(row_count == 1)
		{

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
if(called_from_dashboard_YN.equals("N")){ 
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
} 
            _bw.write(_wl_block15Bytes, _wl_block15);

		}

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(request_id ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(seq_no ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(int_request_id ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(int_response_id ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(int_first_request_id ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(commnuication_response_id ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(cust_code ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(cust_group_code ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(cust_group_code ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(serv_grp_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(blng_serv_group));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(serv_class_desc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(blng_serv_class));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(blng_serv_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(blng_serv_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(serv_desc));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(effective_from));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(effective_to));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(int_response_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(apa_status_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(apa_status ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(pre_app_num));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(pre_app_status_desc));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pre_app_status));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(approved_qty));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(approved_amount));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(bgcolor ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(utilized_qty));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(request_id ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(seq_no ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf((remarks!= null && !remarks.equals(""))?remarks:"..."));
            _bw.write(_wl_block84Bytes, _wl_block84);
if(called_from_dashboard_YN.equals("N")){ 
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block95Bytes, _wl_block95);
} 
            _bw.write(_wl_block96Bytes, _wl_block96);

		}

            _bw.write(_wl_block97Bytes, _wl_block97);
					
		
		if(row_count == 0){
			

            _bw.write(_wl_block98Bytes, _wl_block98);

		}

            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(called_from_dashboard_YN));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(filePath));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(pathExist));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(writeAccess));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(qry_patient_id ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(qry_nationalId ));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(qry_iqamaId ));
            _bw.write(_wl_block107Bytes, _wl_block107);

	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(pstmt!=null)	pstmt.close();
		if(rst!=null)	rst.close();
		ConnectionManager.returnConnection(con,request);		
	} 

            _bw.write(_wl_block108Bytes, _wl_block108);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SrlNo.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_GROUP.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SERVICE_CLASSIFICATION.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BLNG_SERV_CODE.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServiceDescription.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ValidFrom.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ValidTo.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PreauthRespId.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APA_Status.Label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ApprovalNumber.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Status.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_QTY.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AVAILD_QTY.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Remarks.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SelectAll.Label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UploadDocuments.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }
}
