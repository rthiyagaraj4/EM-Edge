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
import eBL.BLReportIdMapper;
import webbeans.op.CurrencyFormat;
import webbeans.eCommon.*;
import org.apache.commons.codec.binary.Base64;
import java.util.*;
import com.ehis.util.*;

public final class __blfutordinsapprtrackresultframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLFutOrdInsApprTrackResultFrame.jsp", 1709114520557L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eBL/js/BLFutOrdInsApprTrackResult.js\' language=\'javascript\'></script>\n<script src=\'../../eBL/js/BLFutOrdInsApprTrack.js\' language=\'javascript\'></script>\n\n<HTML>\n<HEAD>\n\t<style>\n\t\tdiv.tableContainer {\n\t\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\t\theight: 160px; \t/* must be greater than tbody*/\n\t\t\toverflow: auto;\n\t\t\tmargin: 0 auto;\n\t\t}\n\t\t\n\t\ttable {\n\t\t\twidth: 100%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\n\t\t\tborder: none;\n\t\t\tbackground-color: #f7f7f7;\n\t\t\t}\n\t\t\t\n\t\ttable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\n\t\t\toverflow: auto; \n\t\t\theight: 120x;\n\t\t\toverflow-x: hidden;\n\t\t\t}\n\t\t\t\n\t\tthead tr\t{\n\t\t\tposition:relative; \n\t\t\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\n\t\t\t}\n\t\t\t\t\n\t\t\t\tdiv.tableContainer {\n\t\t\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\t\t\theight: 140px; \t/* must be greater than tbody*/\n\t\t\t\toverflow: scroll;\n\t\t\t\tmargin: 0 auto;\n\t\t\t}\t\n\t\t\t\tTD.YELLOW \n\t\t\t\t{\t\t\t\n\t\t\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\t\t\tFONT-SIZE: 8pt ;\n\t\t\t\t\tborder-style: dashed;\n\t\t\t\t\tborder-left-color: #D5E2E5;\n\t\t\t\t\tborder-right-color: #D5E2E5;\n\t\t\t\t\tborder-top-color: #D5E2E5;\n\t\t\t\t\tborder-bottom-color: #D5E2E5; \n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t.LocalYellow\n\t\t\t\t{\n\t\t\t\t\tCOLOR:#444444;\n\t\t\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\t\t\tFONT-SIZE: 8pt ;\n\t\t\t\t\tborder: 1x;\n\t\t\t\t\tborder-style: dashed;\n\t\t\t\t\tborder-left-color: #D5E2E5;\n\t\t\t\t\tborder-right-color: #D5E2E5;\n\t\t\t\t\tborder-top-color: #D5E2E5;\n\t\t\t\t\tborder-bottom-color: #D5E2E5; \n\t\t\t\t\tPADDING-LEFT:7px;\n\t\t  \t\t\tPADDING-RIGHT:7px\n\t\t\t\t}\n\t\tSPAN.LABEL\n\t\t{\n\t\t  COLOR:#444444;\n\t\t  /*background-color:#FFFFFF;*/\n\t\t  background-color:#FFFFFF;\n\t\t  FONT-SIZE: 8pt;\n\t\t  TEXT-ALIGN: LEFT;\n\t\t  /*TEXT-ALIGN: RIGHT;*/\n\t\t  PADDING-LEFT:7px;\n\t\t  PADDING-RIGHT:7px\n\t\t}\n\t\t\n\t\tSPAN.LABEL1\n\t\t{\n\t\t  COLOR:#444444;\n\t\t  /*background-color:#FFFFFF;*/\n\t\t  background-color:#FFFFFF;\n\t\t  FONT-SIZE: 8pt;\n\t\t  /*TEXT-ALIGN: LEFT;*/\n\t\t  TEXT-ALIGN: RIGHT;\n\t\t  PADDING-LEFT:7px;\n\t\t  PADDING-RIGHT:7px\n\t\t}\n\t\t\n\t\tSPAN.SpanYellow\n\t\t{\n\t\t\tCOLOR:#444444;\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tPADDING-LEFT:7px;\n\t\t\tPADDING-RIGHT:7px\n\t\t}\n\t</style>\n</HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n<form name=\"BLFutOrdInsApprTrackResultFrame\" id=\"BLFutOrdInsApprTrackResultFrame\">\n\n<table cellpadding=3 cellspacing=0  width=\"100%\" border=\"1\">\n<div id=\"tableContainer\">\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t\n<thead>\n\t<tr><td class=\"COLUMNHEADER\" align=\'left\' colspan=\"26\">Details</td></tr>\n\t<tr>\n\t\t<td class=\'COLUMNHEADER\' nowrap width = \"2%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t<td class=\'COLUMNHEADER\' nowrap width = \"5%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t<td class=\'COLUMNHEADER\' width = \"5%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\t\n\t\t<td class=\'COLUMNHEADER\' nowrap width = \"5%\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t<td class=\'COLUMNHEADER\'  width = \"5%\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\t\n\t\t<td class=\'COLUMNHEADER\' width = \"5%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\t\t\n\t\t<td class=\'COLUMNHEADER\' width = \"5%\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\t\t\t\n\t\t<td class=\'COLUMNHEADER\' width = \"5%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" - ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\t \n\t\t<td class=\'COLUMNHEADER\' nowrap width = \"5%\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" / ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td> \n\t</tr>\n</thead>\n<tbody>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\t\n\n\t<tr id=\'row";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' >\n\t\t<td class=\"fields\">\n\t\t\t&nbsp;<label>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</label>\n\t\t\t<input type=\"hidden\" name = \'OPERATING_FACILITY_ID_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id = \'OPERATING_FACILITY_ID_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' value =\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' />\n\t\t\t<input type=\"hidden\" name = \'PRIMARY_KEY_MODULE_ID_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id = \'PRIMARY_KEY_MODULE_ID_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' />\n\t\t\t<input type=\"hidden\" name = \'PRIMARY_KEY_MAIN_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id = \'PRIMARY_KEY_MAIN_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' />\n\t\t\t<input type=\"hidden\" name = \'PRIMARY_KEY_LINE_NO_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id = \'PRIMARY_KEY_LINE_NO_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' />\n\t\t\t<input type=\"hidden\" name = \'SERV_ITEM_CODE_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id = \'SERV_ITEM_CODE_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' />\n\t\t\t<input type=\"hidden\" name = \'BLNG_SERV_CODE_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id = \'BLNG_SERV_CODE_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' />\n\t\t</td>\n\t\t\n\t\t <td class=\"field\" nowrap>\n         \t&nbsp;<label name=\"encounter_id_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"encounter_id_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</label>\n         </td>\n\t\t\n\t\t<td class=\"field\" nowrap>\n        \t&nbsp;<label name=\"order_catalog_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\"order_catalog_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</label>\n        \t<input type=\"hidden\" id=\"order_catalog_code_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" name=\"order_catalog_code_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t</td>\n\t\t\n\t\t<td class=\"field\" nowrap>\n        \t&nbsp;<label name=\"order_date_time_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\"order_date_time_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</label>\n\t\t</td>\n\t\t\n\t\t<td class=\"field\" nowrap>\n\t\t     &nbsp;<label name=\"signed_date_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"signed_date_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</label>\n\t\t</td>\n\t\t\n\t\t<td class=\"field\" nowrap>\n        \t&nbsp;<label name=\"order_by_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" id=\"order_by_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</label>\n        \t<input type=\"hidden\" id=\"ordered_by_code_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" name=\"ordered_by_code_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t</td>\n\t\t\n\t\t<td class=\"field\" nowrap>\n\t\t    &nbsp;<label name=\"order_status_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" id =\"order_status_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</label>\n\t\t</td>\n\t\t\n\t\t<td class=\"field\" nowrap> \n       \t\t&nbsp;<label name=\"fut_ord_link_date_time_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" id=\"fut_ord_link_date_time_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</label>\n\t\t</td>\n\t\t\n\t\t<td class=\"field\" nowrap>\n\t\t\t&nbsp;<label name=\"coder_name_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" id=\"coder_name_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t</label><input type=\"hidden\" id=\"coder_id_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" name=\"coder_id_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t</td>\n\t\t\n\t\t<td class=\"field\" >\n\t\t\t&nbsp;<label name=\"remarks_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" id=\"remarks_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</label>\n\t\t</td>\n\t\t\n\t\t<td class=\"field\" nowrap>\n\t\t\t&nbsp;<label name=\"category_desc_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"category_desc_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</label>\n\t\t\t<input type=\"hidden\" id=\"category_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" name=\"category_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t</td>\n\t\t\n\t\t<td class=\"field\" nowrap>\n\t\t\t&nbsp;<label name=\"coding_status_desc_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" id=\"coding_status_desc_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</label>\n\t\t\t<input type=\"hidden\" id=\"coding_status_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" name=\"coding_status_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t</td>\n\t\t\n\t\t<td class=\"field\" nowrap>\n\t\t\t&nbsp;<label name=\"insurance_status_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" id=\"insurance_status_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</label>\n\t\t</td>\n\t\t\n\t\t<td class=\"field\" nowrap>\n\t\t\t&nbsp;<label name=\"ins_remarks_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" id=\"ins_remarks_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</label>\n\t\t</td>\n\t\t\n\t\t<td class=\"field\" nowrap>\n\t\t\t&nbsp;<label name=\"authorized_by_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" id=\"authorized_by_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</label>\n\t\t\t<input type=\"hidden\" id=\"ins_appr_auth_by_id_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" name=\"ins_appr_auth_by_id_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t</td>\n\t\t\n\t\t<td class=\"fields\" nowrap>&nbsp;\n\t\t              <Select name=\"APPR_INFO_TO_PAT_YN_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"APPR_INFO_TO_PAT_YN_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t                             <option value=\'\'>----";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="----</option>\n\t\t                             <option value=\"Y\" ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =">Yes</option>\n\t\t                             <option value=\"N\" ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =">No</option>\n\t\t              </Select>\n\t\t              \n\t\t</td>\n\t\t\n\t\t<td class=\"fields\" nowrap>\n\t\t              &nbsp;<input type=\"text\" name=\"APPR_INFO_BY_ID_";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"APPR_INFO_BY_ID_";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" maxlength = \'50\' value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" />\n\t\t\t\t\n\t\t</td>\n\t\t\n\t\t<td class=\"fields\" nowrap>\n\t\t              &nbsp;<input type=\"text\" name=\"APPR_INFO_DATE_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" id=\"APPR_INFO_DATE_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" size = \"12\" maxlength=\"10\" onblur=\'\' value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'APPR_INFO_DATE_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\');\"  onKeyPress=\"return lockbackSpace();\">\n\t\t</td>\n\t\t\n\t\t<td class=\"fields\" nowrap>\n\t\t              &nbsp;<input type=\"text\" name=\"APPR_START_DATE_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" id=\"APPR_START_DATE_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" readonly size = \"12\" maxlength=\"10\" onblur=\'\' value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t</td>\n\t\t\n\t\t<td class=\"fields\" nowrap>\n\t\t              &nbsp;<input type=\"text\" name=\"APPR_EXPIRE_DATE_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" id=\"APPR_EXPIRE_DATE_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t</td>\n\t\t\n\t\t<td class=\"fields\" nowrap>\n\t\t              &nbsp;<input type=\"text\" name=\"SERVICE_PERFORM_DATE_";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" id=\"SERVICE_PERFORM_DATE_";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'SERVICE_PERFORM_DATE_";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\');\"  onKeyPress=\"return lockbackSpace();\">\n\t\t</td>\n\t\t\n\t\t<td class=\"fields\" nowrap>\n        &nbsp;<select name=\"SERVICE_STATUS_";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" id=\"SERVICE_STATUS_";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t\t\t<option value=\'\'>----";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="----</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="  \n\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =">";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\t\t\t\t  \n        </select>\n\t\t</td>\n\t\t<td class=\"fields\" nowrap>\n\t\t              &nbsp;<input type=\"text\" name=\"SERVICE_REMARKS_";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" id=\"SERVICE_REMARKS_";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" maxlength = \'100\' value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" />\n\t\t</td>\n\t\t\n\t\t<td class=\"fields\" nowrap>\n\t\t              &nbsp;<Select name=\"FOLLOW_UP_VISIT_APPT_YN_";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" id=\"FOLLOW_UP_VISIT_APPT_YN_";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t\t                         <option value=\'\'>----";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="----</option>\n\t\t                         <option value=\"Y\" ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =">Yes</option>\n\t\t                     \t <option value=\"N\" ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =">No</option>\n\t\t              </Select>\n\t\t</td>\n\t\t\n\t\t<td class=\"fields\" nowrap>\n\t\t              &nbsp;<input type=\"text\" name=\"APPT_DATE_TIME_";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" id=\"APPT_DATE_TIME_";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'APPT_DATE_TIME_";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\');\"  onKeyPress=\"return lockbackSpace();\">\n\t\t</td>   \n\t\t\n\t\t<td class=\"fields\" nowrap>\n\t\t&nbsp;<Select name=\"FOLLOW_UP_VIST_ADM_";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" id=\"FOLLOW_UP_VIST_ADM_";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t\t\t<option value=\'\'>----";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="----</option>\n\t\t\t<option value=\"V\"  ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</option>\n\t\t\t<option value=\"A\"  ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</option>\n\t\t</Select>\n\t\t</td>\n\t\t \n\t\t\n\t</tr>\t\n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\t\t\n\n\t</tbody>\n\n";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\t\n<Script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));</script>\n";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\n\t</tbody>\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"/>\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\"/>\n\t<input type=\"hidden\" name=\"login_user\" id=\"login_user\" id=\"login_user\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\"/>\n\t<input type=\"hidden\" name=\"rowCount\" id=\"rowCount\" id=\"rowCount\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\"/> \n\t<input type=\"hidden\" id=\"p_action_id\" name=\"p_action_id\" id=\"p_action_id\"\tvalue=\"\">\t\n\t<input type=\"hidden\" id=\"prevActionID\" name=\"prevActionID\" id=\"prevActionID\"\tvalue=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\t\n\t\n\t\n\t<input type=\"hidden\" id=\"p_facility_id\" name=\"p_facility_id\" id=\"p_facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t<input type=\"hidden\" id=\"p_patient_id\" name=\"p_patient_id\" id=\"p_patient_id\"\tvalue=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t<input type=\"hidden\" id=\"p_episode_type\" name=\"p_episode_type\" id=\"p_episode_type\"\tvalue=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t<input type=\"hidden\" id=\"p_encounter_id\" name=\"p_encounter_id\" id=\"p_encounter_id\"\tvalue=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t<input type=\"hidden\" id=\"p_speciality_code\" name=\"p_speciality_code\" id=\"p_speciality_code\"\tvalue=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t<input type=\"hidden\" id=\"p_payer_grp_code\" name=\"p_payer_grp_code\" id=\"p_payer_grp_code\"\tvalue=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t<input type=\"hidden\" id=\"p_payer_code\" name=\"p_payer_code\" id=\"p_payer_code\"\tvalue=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t<input type=\"hidden\" id=\"p_policy_type_code\" name=\"p_policy_type_code\" id=\"p_policy_type_code\"\tvalue=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t<input type=\"hidden\" id=\"p_blng_grp_id\" name=\"p_blng_grp_id\" id=\"p_blng_grp_id\"\tvalue=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\t\n\t<input type=\"hidden\" id=\"p_serv_grp_code\" name=\"p_serv_grp_code\" id=\"p_serv_grp_code\"\tvalue=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n\t<input type=\"hidden\" id=\"p_serv_class_code\" name=\"p_serv_class_code\" id=\"p_serv_class_code\"\tvalue=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n\t<input type=\"hidden\" id=\"p_order_line_status\" name=\"p_order_line_status\" id=\"p_order_line_status\"\tvalue=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\t<input type=\"hidden\" id=\"p_coding_status\" name=\"p_coding_status\" id=\"p_coding_status\"\tvalue=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n\t<input type=\"hidden\" id=\"p_ins_status\" name=\"p_ins_status\" id=\"p_ins_status\"\tvalue=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t<input type=\"hidden\" id=\"p_enc_frm_date\" name=\"p_enc_frm_date\" id=\"p_enc_frm_date\"\tvalue=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n\t<input type=\"hidden\" id=\"p_enc_to_date\" name=\"p_enc_to_date\" id=\"p_enc_to_date\"\tvalue=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t\n";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\t\n<Script>\ndisplayQeuryButtons();\n</script>\n";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\n</table>\t\n</div>\t\n";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n</form>\n</BODY>\n<script>\nvar prevActionID = document.forms[0].prevActionID.value;\nprevActionCall(prevActionID);\n</script>\n</HTML>\n\n";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	System.err.println("In BLFutOrdInsApprTrackResultFrame.jsp");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con=null;
	PreparedStatement pstmt = null;
	BLHelper blHelper = null;
	CallableStatement callStmt=null;
	ResultSet rst=null;
	Map servStatusList = new HashMap();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	String facilityId = (String)session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("locale");
	if(locale == null) locale = "en";
	String qry_patient_id = checkForNull(request.getParameter("patient_id"));
	String qry_encounter_id = checkForNull(request.getParameter("encounter_id"));
	String qry_episode_type = checkForNull(request.getParameter("episode_type"));
	String qry_payer_grp_code = checkForNull(request.getParameter("payer_grp_code"));
	String qry_payer_code = checkForNull(request.getParameter("payer_code"));
	String qry_policy_type_code = checkForNull(request.getParameter("policy_type_code"));
	String qry_enc_frm_date = checkForNull(request.getParameter("enc_frm_date"));
	String qry_enc_to_date = checkForNull(request.getParameter("enc_to_date"));
	String qry_spec_nursing_unit_code = checkForNull(request.getParameter("spec_nursing_unit_code"));	
	String qry_insurance_Status = checkForNull(request.getParameter("insurance_Status"));	
	String qry_order_status = checkForNull(request.getParameter("order_status"));
	String qry_serviceGroupCode = checkForNull(request.getParameter("serviceGroupCode"));
	String qry_serviceClassificationCode = checkForNull(request.getParameter("serviceClassificationCode"));
	String qry_coding_status = checkForNull(request.getParameter("coding_status"));
	String qry_billingGrpCode = checkForNull(request.getParameter("billingGrpCode"));
	String qry_policy_no = checkForNull(request.getParameter("policy_no"));
	String prevActionID = checkForNull(request.getParameter("prevActionID"));
	
	System.err.println("URL Parameters :- Patient_id= "+qry_patient_id+", Episode_type="+qry_episode_type+" , Encounter_id="+qry_encounter_id+", Enc_frm_date="+qry_enc_frm_date+", Enc_to_date="+qry_enc_to_date+", Spec_nursing_unit_code="+qry_spec_nursing_unit_code+", Insurance_Status="+qry_insurance_Status+", Payer_grp_code="+qry_payer_grp_code+", Payer_code="+qry_payer_code+", Policy_type_code="+qry_policy_type_code+", Order_status="+qry_order_status+", ServiceGroupCode="+qry_serviceGroupCode+", ServiceClassificationCode="+qry_serviceClassificationCode+", Coding_status="+qry_coding_status+", BillingGrpCode="+qry_billingGrpCode);

            _bw.write(_wl_block8Bytes, _wl_block8);
	

	
	try
	{
		System.err.println("Query String in inerror.jsp:"+request.getQueryString());
		System.err.println("from date:"+new Date(sdf.parse(qry_enc_frm_date).getTime()));
		String params = request.getQueryString() ;
		if(params==null || params.equals("")) params="";
		String sql = "";
		int row_count = 0;
		int column_count = 1;
		java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_user = (String) p.getProperty("login_user");
		System.err.println("locale in BLFutOrdInsApprTrackResultFrame.jsp:"+locale);
		
		
		con=ConnectionManager.getConnection(request);
		
		servStatusList = (Map) BLHelper.getListOfItems(con, "BL", "L_SERVICE_STATUS", locale);

		sql = "{call BL_POPULATE_FUTURE_ORD(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		System.err.println(sql);
		callStmt = con.prepareCall(sql);
		callStmt.setString(1,facilityId);						//v_operating_facility_id
		callStmt.setString(2,qry_patient_id);						//v_patient_id
		callStmt.setString(3,"");						//v_patient_name
		callStmt.setString(4,qry_spec_nursing_unit_code);		//v_speciality_code	
		callStmt.setString(5, qry_episode_type);				//v_episode_type
		callStmt.setString(6, qry_encounter_id);				//v_encounter_id
		callStmt.setDate(7, new Date(sdf.parse(qry_enc_frm_date).getTime()));				//v_encounter_date_from
		callStmt.setDate(8, new Date(sdf.parse(qry_enc_to_date).getTime()));			//v_encounter_date_to
		callStmt.setString(9, qry_insurance_Status);				//v_ins_status
		callStmt.setString(10, qry_payer_grp_code);		//v_cust_group_code
		callStmt.setString(11, qry_payer_code);			//v_cust_code
		callStmt.setString(12, qry_policy_no);			//v_policy_number
		callStmt.setString(13, qry_order_status);				//v_order_line_status
		callStmt.setString(14, qry_serviceGroupCode);								//v_serv_grp_code
		callStmt.setString(15, qry_serviceClassificationCode);								//v_serv_classification_code
		callStmt.setString(16, qry_billingGrpCode);								//v_blng_grp_id
		callStmt.setString(17, qry_coding_status);								//v_coder_status

		callStmt.execute();
		
		sql = "select a.PATIENT_ID as PATIENT_ID , (select short_name from mp_patient_mast where patient_id =  a.PATIENT_ID) as patient_name , "+
 			"decode(a.episode_type,'O','OP','I','IP','E','EM','D','DC') patient_class , "+
			"a.ENCOUNTER_ID as ENCOUNTER_ID  , "+
 			"(select long_name from ar_customer_lang_vw where cust_code = a.CUST_CODE and language_id = '"+locale+"') payer_desc, "+
			"a.CUST_CODE as payer_code, "+
 			"a.POLICY_NUMBER as POLICY_NUMBER , "+
			"to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy HH24:MI:SS') as VISIT_ADM_DATE_TIME , "+
 			"a.PHYSICIAN_ID as PHYSICIAN_ID , "+
			"(select PRACTITIONER_NAME from am_practitioner_lang_vw where practitioner_id = a.PHYSICIAN_ID and language_id = '"+locale+"') PHYSICIAN_NAME , "+
			"a.SPECIALITY_CODE as SPECIALITY_CODE , "+
			"(case WHEN a.episode_type = 'I' OR a.episode_type ='D' THEN (SELECT LONG_DESC FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = 'SA' AND NVL(EFF_STATUS,'D') = 'E' and NURSING_UNIT_CODE = a.SPECIALITY_CODE) WHEN a.episode_type = 'O' OR a.episode_type ='E' THEN (select short_desc from am_speciality_lang_vw where language_id='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E' and speciality_code = a.SPECIALITY_CODE) end) as SPECIALTY_DESC, "+
 			"to_char(a.SIGNED_DATE,'dd/mm/yyyy') as SIGNED_DATE , "+
			"a.ORDER_CATALOG_CODE as ORDER_CATALOG_CODE , "+
 			"to_char(a.ORD_DATE_TIME,'dd/mm/yyyy HH24:MI:SS') as ORD_DATE_TIME , "+
 			"a.ORDER_BY_ID , "+
 			"a.ORDER_LINE_STATUS , "+
 			"(select short_desc from OR_ORDER_STATUS_CODE where order_status_code = a.ORDER_LINE_STATUS ) as order_status_desc, "+
 			"to_char(a.FUTURE_ORD_LINK_DATE,'dd/mm/yyyy HH24:MI:SS') as FUTURE_ORD_LINK_DATE , "+
 			"a.CODER_ID         , "   +
 			"a.CODER_REMARKS             , "+
 			"a.ORDER_CATEGORY            , "+
			"(SELECT SHORT_DESC FROM OR_ORDER_CATEGORY_lang_vw b WHERE a.ORDER_CATEGORY = b.ORDER_CATEGORY and LANGUAGE_ID = '"+locale+"') ORDER_CAT_DESC, "+
 			"a.CODER_STATUS              , "+
			"DECODE(a.CODER_STATUS,'*A','All','NW','New','DQ','Doctor Query','SQ','Supervisor Query','HD','Hold','PC','Partially Completed','CO','Completed','SC','Supervisor Clearance Completed') CODER_STATUS_DESC , "+
 			"NVL((select LIST_ELMT_LABEL from SM_LIST_ITEM WHERE LIST_ELMT_VALUE = a.ins_status and module_id = 'BL' AND LIST_REF = 'L_REC_APPROVAL_STATUS' ),'') INS_STATUS , "+
 			"a.INS_APPR_REMARKS          , "+
 			"a.INS_APPR_AUTH_BY_ID , "+
 			"to_char(a.APPR_START_DATE,'dd/mm/yyyy') as APPR_START_DATE , to_char(a.APPR_EXPIRE_DATE,'dd/mm/yyyy') as APPR_EXPIRE_DATE , "+
 			"a.OPERATING_FACILITY_ID, a.PRIMARY_KEY_MODULE_ID, a.PRIMARY_KEY_MAIN, a.PRIMARY_KEY_LINE_NO, a.SERV_ITEM_CODE, a.BLNG_SERV_CODE BLNG_SERV_CODE , "+
 			"a.APPR_INFO_TO_PAT_YN , a.APPR_INFO_BY_ID , to_char(a.APPR_INFO_DATE,'dd/mm/yyyy') as APPR_INFO_DATE , to_char(a.SERVICE_PERFORM_DATE,'dd/mm/yyyy') as SERVICE_PERFORM_DATE , a.SERVICE_STATUS  , a.SERVICE_REMARKS  , "+
 			"a.FOLLOW_UP_VISIT_APPT_YN , to_char(a.APPT_DATE_TIME,'dd/mm/yyyy') as APPT_DATE_TIME , a.FOLLOW_UP_VIST_ADM "+
 			"from BL_FUTURE_ORD_INS_APPR_TRK a "+
 			"where OPERATING_FACILITY_ID = '"+facilityId+"'  and "+
			"a.trx_status IS NULL and "+
			"a.patient_id = nvl(?,a.PATIENT_ID) and "+
 			"a.episode_type = nvl(?,a.episode_type) and  "+
	 		"a.ENCOUNTER_ID = nvl(?,a.ENCOUNTER_ID) and "+			
			"a.SPECIALITY_CODE = NVL(?,a.SPECIALITY_CODE) and "+
			"a.ORDER_LINE_STATUS = nvl(?,a.ORDER_LINE_STATUS) and "+
			"a.SERV_GRP_CODE = nvl(?,a.SERV_GRP_CODE) and "+
			"a.SERV_CLASSIFICATION_CODE = nvl(?,a.SERV_CLASSIFICATION_CODE) and "+
			"a.BLNG_GRP_ID = nvl(?,a.BLNG_GRP_ID) and "+
			"a.CUST_CODE IS NOT NULL AND "+
			"trunc(a.VISIT_ADM_DATE_TIME) between "+
			"to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy')";							 
			
		if(!"".equals(qry_payer_grp_code)){
			sql = sql + " and a.CUST_GROUP_CODE = nvl(?,a.CUST_GROUP_CODE) ";
		}
		
		if(!"".equals(qry_payer_code)){
			sql = sql + " and a.CUST_CODE = nvl(?,a.CUST_CODE) ";
		}
		
		if(!"".equals(qry_policy_type_code)){
			sql = sql + " and a.policy_type_code = nvl(?,a.policy_type_code) ";
		}
		
		if(!"".equals(qry_coding_status) && !"*A".equals(qry_coding_status))
			sql = sql + " and (a.CODER_STATUS = nvl(?,a.CODER_STATUS)) ";
		
		if(!"".equals(qry_insurance_Status))
			sql = sql + " and (a.INS_STATUS = nvl(?,a.INS_STATUS)) ";
		
		System.err.println("sql to load data :"+sql);
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(column_count,qry_patient_id);						
		pstmt.setString(++column_count,qry_episode_type);						
		pstmt.setString(++column_count,qry_encounter_id);						
		pstmt.setString(++column_count, qry_spec_nursing_unit_code);	
		pstmt.setString(++column_count, qry_order_status);
		pstmt.setString(++column_count, qry_serviceGroupCode);								
		pstmt.setString(++column_count, qry_serviceClassificationCode);	
		pstmt.setString(++column_count, qry_billingGrpCode);		
		pstmt.setString(++column_count, qry_enc_frm_date);				
		pstmt.setString(++column_count, qry_enc_to_date);			

		System.err.println("sql to load data column_count:"+column_count);
		if(!"".equals(qry_payer_grp_code))
			pstmt.setString(++column_count,qry_payer_grp_code);			
		
		if(!"".equals(qry_payer_code))
			pstmt.setString(++column_count, qry_payer_code);
		
		if(!"".equals(qry_policy_type_code))
			pstmt.setString(++column_count, qry_policy_type_code);
		
		if(!"".equals(qry_coding_status) && !"*A".equals(qry_coding_status))
			pstmt.setString(++column_count, qry_coding_status);
		
		if(!"".equals(qry_insurance_Status))
			pstmt.setString(++column_count, qry_insurance_Status);		

		System.err.println("sql to load data column_count:"+column_count);
		
		rst = pstmt.executeQuery();
		while ( rst.next() )
		{	
			System.err.println(rst.toString());
			String patient_id = checkForNull(rst.getString("PATIENT_ID"));
			String patient_name = checkForNull(rst.getString("patient_name"));
			String encounter_id = checkForNull(rst.getString("ENCOUNTER_ID"));
			String pat_class = checkForNull(rst.getString("patient_class"));
			String payer_code = checkForNull(rst.getString("payer_code"));
			String payer_grp_desc = checkForNull(rst.getString("payer_desc"));
			String policy_no = checkForNull(rst.getString("POLICY_NUMBER"));
			String visit_date = checkForNull(rst.getString("VISIT_ADM_DATE_TIME"));
			String physician_id = checkForNull(rst.getString("PHYSICIAN_ID"));
			String Physician_name = checkForNull(rst.getString("PHYSICIAN_NAME"));
			String Speciality_code = checkForNull(rst.getString("SPECIALITY_CODE"));
			String specialty_desc = checkForNull(rst.getString("SPECIALTY_DESC"));
			String signed_date = checkForNull(rst.getString("SIGNED_DATE"));
			String order_catalog_code = checkForNull(rst.getString("ORDER_CATALOG_CODE"));
			String ord_date_time = checkForNull(rst.getString("ORD_DATE_TIME"));
			String ordered_by = checkForNull(rst.getString("ORDER_BY_ID"));
			String order_status = checkForNull(rst.getString("ORDER_LINE_STATUS"));
			String order_status_desc = checkForNull(rst.getString("order_status_desc"));
			String future_ord_link_date = checkForNull(rst.getString("FUTURE_ORD_LINK_DATE"));
			String coder_id = checkForNull(rst.getString("CODER_ID"));
			String coder_remarks = checkForNull(rst.getString("CODER_REMARKS"));
			String order_category = checkForNull(rst.getString("ORDER_CATEGORY"));
			String order_cat_desc = checkForNull(rst.getString("ORDER_CAT_DESC"));			
			String coder_status = checkForNull(rst.getString("CODER_STATUS"));
			String coder_status_desc = checkForNull(rst.getString("CODER_STATUS_DESC"));			
			String insurance_status = checkForNull(rst.getString("INS_STATUS"));
			String ins_remarks = checkForNull(rst.getString("INS_APPR_REMARKS"));
			String ins_appr_auth_by_id = checkForNull(rst.getString("INS_APPR_AUTH_BY_ID"));
			String appr_start_date = checkForNull(rst.getString("APPR_START_DATE"));
			String appr_expire_date = checkForNull(rst.getString("APPR_EXPIRE_DATE"));
			String operating_facility_id = checkForNull(rst.getString("OPERATING_FACILITY_ID"));
			String primary_key_module_id = checkForNull(rst.getString("PRIMARY_KEY_MODULE_ID"));
			String primary_key_main =  checkForNull(rst.getString("PRIMARY_KEY_MAIN"));
			String primary_key_line_no = checkForNull(rst.getString("PRIMARY_KEY_LINE_NO"));
			String serv_item_code = checkForNull(rst.getString("SERV_ITEM_CODE"));
			String blng_serv_code = checkForNull(rst.getString("BLNG_SERV_CODE"));		
			String appr_info_to_pat_yn = checkForNull(rst.getString("APPR_INFO_TO_PAT_YN"));
			String appr_info_by_id = checkForNull(rst.getString("APPR_INFO_BY_ID"));
			String appr_info_date = checkForNull(rst.getString("APPR_INFO_DATE"));	
			String service_perform_date = checkForNull(rst.getString("SERVICE_PERFORM_DATE"));	
			String service_status = checkForNull(rst.getString("SERVICE_STATUS"));		
			String service_remarks = checkForNull(rst.getString("SERVICE_REMARKS"));
			String follow_up_visit_appt_yn = checkForNull(rst.getString("FOLLOW_UP_VISIT_APPT_YN"));		
			String appt_date_time =  checkForNull(rst.getString("APPT_DATE_TIME"));		
			String follow_up_vist_adm = checkForNull(rst.getString("FOLLOW_UP_VIST_ADM"));
			
 			row_count++;


            _bw.write(_wl_block9Bytes, _wl_block9);

		if(row_count == 1)
		{

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

		}

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(operating_facility_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(primary_key_module_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(primary_key_main));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(primary_key_line_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(serv_item_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(blng_serv_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ord_date_time));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(signed_date));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ordered_by));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ordered_by));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(order_status_desc));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(future_ord_link_date));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(coder_id));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(coder_id));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(coder_remarks));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(order_cat_desc));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(coder_status_desc));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(coder_status));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(insurance_status));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ins_remarks));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ins_appr_auth_by_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ins_appr_auth_by_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf( "Y".equals(appr_info_to_pat_yn)?"selected":""));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf( "N".equals(appr_info_to_pat_yn)?"selected":""));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(appr_info_by_id));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appr_info_date));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(appr_start_date));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(appr_expire_date));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(service_perform_date));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
 if(servStatusList != null){
						Iterator it = servStatusList.keySet().iterator();
            _bw.write(_wl_block104Bytes, _wl_block104);
 while(it.hasNext()){
							String key=(String)it.next(); 
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(key));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf( key.equals(service_status)?"selected":""));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(servStatusList.get(key) ));
            _bw.write(_wl_block108Bytes, _wl_block108);
 }} 
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(service_remarks));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf( "Y".equals(follow_up_visit_appt_yn)?"selected":""));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf( "N".equals(follow_up_visit_appt_yn)?"selected":""));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(appt_date_time));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf( "V".equals(follow_up_vist_adm)?"selected":""));
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf( "A".equals(follow_up_vist_adm)?"selected":""));
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);

		}

            _bw.write(_wl_block126Bytes, _wl_block126);
					
		
		if(row_count == 0){

            _bw.write(_wl_block127Bytes, _wl_block127);

		}

            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(prevActionID));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(qry_patient_id));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(qry_episode_type));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(qry_encounter_id));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(qry_spec_nursing_unit_code));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(qry_payer_grp_code));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(qry_payer_code));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(qry_policy_type_code));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(qry_billingGrpCode));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(qry_serviceGroupCode));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(qry_serviceClassificationCode));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(qry_order_status));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(qry_coding_status));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(qry_insurance_Status));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(qry_enc_frm_date));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(qry_enc_to_date));
            _bw.write(_wl_block149Bytes, _wl_block149);
					
		if(row_count > 0){

            _bw.write(_wl_block150Bytes, _wl_block150);

		}

            _bw.write(_wl_block151Bytes, _wl_block151);

	}catch(Exception e){
		out.println("Exception in BLFutOrdInsApprTrackResultFrame.jsp: "+e);
		System.err.println("Exception in BLFutOrdInsApprTrackResultFrame.jsp: "+e);
	}finally{
		if(callStmt!=null)	callStmt.close();
		if(rst!=null)	rst.close();
		ConnectionManager.returnConnection(con,request);		
	} 

            _bw.write(_wl_block152Bytes, _wl_block152);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDateTime.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Signed_Date.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderedBy.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderStatus.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Fut_Ord_Li_Da_Ti.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Coder_Name.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category1.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Coding_Status.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.INS_Status.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.authorizedby.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Approval_inf_to_Patient.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Approval_inf_By.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Approval.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.InformedDate/Time.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Approval.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Approval_EXPIRY_DATE.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Service_Performed_Date.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Service_Status.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.followup.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Visit.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bookappointment.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPT_DATE_TIME.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.followup.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Visit.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admission.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Visit.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admission.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }
}
