package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __ohconddentalchartviewdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/OHCondDentalChartViewDetails.jsp", 1709119347239L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script language=\'javascript\' src=\'../../eOH/js/OHCondDentalChartViewDetails.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eOH/js/OHCommon.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t\n\t</head>\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n\t\t<form name=\"condViewDetailsForm\" id=\"condViewDetailsForm\">\n\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"1\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\" >\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<th align=\"left\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</th>\n\t\t\t\t\t\t\t\t<th align=\"right\" width=\"10%\"><img name=\"DC_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuDC\',this);\" /></th>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand1 style=\'visibility:hidden;display:none\'\">\n\t\t\t\t\t\t\t<td id=\"menuDC\" style=\'display:none\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\" >\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<th align=\"left\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th>\n\t\t\t\t\t\t\t\t\t<th align=\"right\" width=\"10%\"><img name=\"ET_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuET\',this);\" /></th>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand2 style=\'visibility:hidden;display:none\'\">\n\t\t\t\t\t\t\t<td id=\"menuET\" style=\'display:none\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\" >\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<th align=\"left\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t\t\t\t\t\t\t<th align=\"right\" width=\"10%\"><img name=\"GS_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuGS\',this);\" /></th>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand4 style=\'visibility:hidden;display:none\'\">\n\t\t\t\t\t\t\t<td id=\"menuGS\" style=\'display:none\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n\t\t\t\t \t  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" \n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\" >\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<th align=\"left\" >\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t\t\t\t\t\t<th align=\"right\" width=\"10%\"><img name=\"GS_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuSummary\',this);\" /></th>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" \n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand1 style=\'visibility:hidden;display:none\'\">\n\t\t\t\t\t\t\t<td id=\"menuSummary\" style=\'display:none\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\" >\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<th align=\"left\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t\t\t\t\t\t<th align=\"right\" width=\"10%\"><img name=\"BC_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuBC\',this);\" /></th>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand3 style=\'visibility:hidden;display:none\'\">\n\t\t\t\t\t\t\t<td id=\"menuBC\" style=\'display:none\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<!-- added by parul for Enterprise Specific Chart Applicable -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\" >\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<th align=\"left\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t\t\t\t\t\t\t\t\t\t<th align=\"right\" width=\"10%\"><img name=\"FC_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuFC\',this);\" /></th>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<div id=\"menuExpand3 style=\'visibility:hidden;display:none\'\">\n\t\t\t\t\t\t\t\t\t<td id=\"menuFC\" style=\'display:none\'>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<!-- <tr>\n\t\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\" >\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<th align=\"left\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="Marked Error Conditions</th>\n\t\t\t\t\t\t\t\t\t<th align=\"right\" width=\"10%\"><img name=\"ME_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuME\',this);\" /></th>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand5 style=\'visibility:hidden;display:none\'\">\n\t\t\t\t\t\t\t<td id=\"menuME\" style=\'display:none\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr> -->\n\t\t\t\t\t\t\n\t\t\t\t\t\t<!--\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\" >\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<th align=\"left\" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t\t\t\t\t\t\t\t\t<th align=\"right\" width=\"10%\"><img name=\"CN_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuCN\',this);\" /></th>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand4 style=\'visibility:hidden;display:none\'\">\n\t\t\t\t\t\t\t<td id=\"menuCN\" style=\'display:none\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t\t\t\t\t\t\t\t\t<th align=\"right\"  width=\"10%\"><img name=\"OL_arrow\" src=\"../../eOH/images/arrow-down.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuOL\',this);\" /></th>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand5 style=\'visibility:hidden;display:none\'\">\n\t\t\t\t\t\t\t<td id=\"menuOL\" style=\'display:none\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t</table></td>\n\t\t\t\t</tr>\n            </table>\n\n\t\t\t<input type = \"hidden\" name= \"params\" value = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t<input type = \"hidden\" name= \"locale\" value = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t<input type = \"hidden\" name= \"tooth_numbering_system\" value = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t<input type = \"hidden\" name= \"permanent_deciduous_flag\" value = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t\t<input type = \"hidden\" name= \"patient_id\" value = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t<input type = \"hidden\" name= \"encounter_id\" value = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t<input type = \"hidden\" name= \"episode_id\" value = \'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t<input type = \"hidden\" name= \"episode_type\" value = \'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t\t<input type = \"hidden\" name= \"patient_class\" value = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\n\t\t\t<input type = \"hidden\" name= \"visit_id\" value = \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t<input type = \"hidden\" name= \"source_code\" value = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t<input type = \"hidden\" name= \"source_type\" value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t\n\n\t\t\t<input type = \"hidden\" name= \"upper_arch_desc\" value = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t\t<input type = \"hidden\" name= \"lower_arch_desc\" value = \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t\t<input type = \"hidden\" name= \"Q1_id\" value = \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t\t<input type = \"hidden\" name= \"Q2_id\" value = \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t<input type = \"hidden\" name= \"Q3_id\" value = \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t<input type = \"hidden\" name= \"Q4_id\" value = \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t\t<input type = \"hidden\" name= \"Q1_desc\" value = \"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t<input type = \"hidden\" name= \"Q2_desc\" value = \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t\t<input type = \"hidden\" name= \"Q3_desc\" value = \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t<input type = \"hidden\" name= \"Q4_desc\" value = \"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t<input type = \"hidden\" name= \'mixed_dentition_YN\' value=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" >\n\t\t\t<input type = \"hidden\" name= \'chart_type\' value=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" >\n\t\t\t<input type = \"hidden\" name= \'header_tab\' value=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" >\n\t\t\t<input type = \"hidden\" name= \'facility_id\' value=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" >\n\t\t\t<input type = \"hidden\" name= \'baseline_chart_yn\' value=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" >\n\t\t\t<input type = \"hidden\" name= \'chart_num\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' >\n\t\t\t<input type = \"hidden\" name= \'ca_practitioner_id\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' >\n\t\t\t<input type = \"hidden\" name= \'option_id\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' >\n\t\t\t<input type = \"hidden\" name= \'called_from\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' >\n\t\t\t\n\t\t\t<input type = \"hidden\" name= \'chart_line_num\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' >\n\t\t\t<input type = \"hidden\" name= \'perio_chart\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' >\n\t\t\t<input type = \"hidden\" name= \'perio_arch\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' >\n\t\t\t<input type = \"hidden\" name= \"RD_Normal_yn\" value = \"\"> \n            <input type=\"hidden\" name=\"quadrant_sno\" id=\"quadrant_sno\" value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' >\n            <input type=\"hidden\" name=\"cur_chart_num\" id=\"cur_chart_num\" value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' >\n            <input type=\"hidden\" name=\"speciality_code\" id=\"speciality_code\" value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' >\n            <input type=\"hidden\" name=\"location_code\" id=\"location_code\" value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' >\n            <input type=\"hidden\" name=\"record_gingival_status_yn_param\" id=\"record_gingival_status_yn_param\" value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' >\n\t\t\t<!--  added by parul  for other facility chart CRF#0423 -->\n            <input type=\"hidden\" name=\"other_facilitychart_yn\" id=\"other_facilitychart_yn\" value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' >\n            <input type=\"hidden\" name=\"other_chart_facility_id\" id=\"other_chart_facility_id\" value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' >\n            <input type=\"hidden\" name=\"oh_chart_level\" id=\"oh_chart_level\" value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' >\n            <input type=\"hidden\" name=\"other_facility_yn\" id=\"other_facility_yn\" value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' >\n\t\t\t\n            <input type=\"hidden\" name=\"date_diff_flag\" id=\"date_diff_flag\" value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' >\n\n            <input type=\"hidden\" name=\"gingival_recording_by\" id=\"gingival_recording_by\" value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' >\n\t\t\t<input type=\"hidden\" name=\"gs_dflt_tooth_no_s1\" id=\"gs_dflt_tooth_no_s1\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t<input type=\"hidden\" name=\"gs_dflt_tooth_no_s2\" id=\"gs_dflt_tooth_no_s2\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t<input type=\"hidden\" name=\"gs_dflt_tooth_no_s3\" id=\"gs_dflt_tooth_no_s3\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t<input type=\"hidden\" name=\"gs_dflt_tooth_no_s4\" id=\"gs_dflt_tooth_no_s4\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t\t<input type=\"hidden\" name=\"gs_dflt_tooth_no_s5\" id=\"gs_dflt_tooth_no_s5\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t\t<input type=\"hidden\" name=\"gs_dflt_tooth_no_s6\" id=\"gs_dflt_tooth_no_s6\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\n\t\t\t<input type=\"hidden\" name=\"gs_dflt_tooth_no_q1\" id=\"gs_dflt_tooth_no_q1\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t<input type=\"hidden\" name=\"gs_dflt_tooth_no_q2\" id=\"gs_dflt_tooth_no_q2\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t\t<input type=\"hidden\" name=\"gs_dflt_tooth_no_q3\" id=\"gs_dflt_tooth_no_q3\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t<input type=\"hidden\" name=\"gs_dflt_tooth_no_q4\" id=\"gs_dflt_tooth_no_q4\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t<!--Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782-->\n\t\t\t<input type=\"hidden\" name=\"dflt_mixed_dentition_chart\" id=\"dflt_mixed_dentition_chart\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t<!-- Added by Sharon Crasta on 1/11/2010 for IN017822-->\n\t\t\t<input type=\"hidden\" name=\"chart_disable_from_main\" id=\"chart_disable_from_main\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\n\t\t\t<!-- Parameters for Diagnosis function -->\n\t\t\t<input type=\"hidden\" name=\"sex\" id=\"sex\" value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' >\n\t\t\t<input type=\"hidden\" name=\"dob\" id=\"dob\" value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' >\n\t\t\t<input type=\"hidden\" name=\"bed_num\" id=\"bed_num\" value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' >\n\t\t\t<input type=\"hidden\" name=\"room_num\" id=\"room_num\" value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' >\n\t\t\t<input type=\"hidden\" name=\"visit_adm_date\" id=\"visit_adm_date\" value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' >\n\t\t\t\n\t\t</form>\n\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\t\n\t</div>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	
	String disabled = "";
	String params					= request.getQueryString();
	String tooth_numbering_system	= checkForNull(request.getParameter("tooth_numbering_system"));
	String upper_arch_desc			= checkForNull(request.getParameter("upper_arch_desc"));
	String lower_arch_desc			= checkForNull(request.getParameter("lower_arch_desc"));
	String Q1_id					= checkForNull(request.getParameter("Q1_id"));
	String Q2_id					= checkForNull(request.getParameter("Q2_id"));
	String Q3_id					= checkForNull(request.getParameter("Q3_id"));
	String Q4_id					= checkForNull(request.getParameter("Q4_id"));
	String Q1_desc					= checkForNull(request.getParameter("Q1_desc"));
	String Q2_desc					= checkForNull(request.getParameter("Q2_desc"));
	String Q3_desc					= checkForNull(request.getParameter("Q3_desc"));
	String Q4_desc					= checkForNull(request.getParameter("Q4_desc"));
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
	String mixed_dentition_YN        = checkForNull(request.getParameter("mixed_dentition_YN"));
	String date_diff_flag        = checkForNull(request.getParameter("date_diff_flag"));
	String chart_num        = checkForNull(request.getParameter("chart_num"));
	String ca_practitioner_id = (String)session.getValue("ca_practitioner_id") ;
	String option_id = checkForNull(request.getParameter("option_id"));
	String sex = checkForNull(request.getParameter("Sex"));
	String dob = checkForNull(request.getParameter("Dob"));
	String bed_num = checkForNull(request.getParameter("bed_num"));
	String room_num = checkForNull(request.getParameter("room_num"));
	String visit_adm_date = checkForNull(request.getParameter("visit_adm_date"));
	String called_from = checkForNull(request.getParameter("called_from"));

	//String patient_id = "SD00000085";//request.getParameter( "patient_id" ) ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String encounter_id = checkForNull(request.getParameter( "encounter_id" )) ;
	String facility_id = (String)session.getValue("facility_id") ;
	String patient_class = checkForNull(request.getParameter("patient_class"));
	String speciality_code = checkForNull(request.getParameter("speciality_code"));
	String location_code = checkForNull(request.getParameter("location_code"));
	String chart_type = checkForNull(request.getParameter( "chart_type" )) ;
	String episode_type = checkForNull(request.getParameter( "episode_type" )) ;
	String header_tab = checkForNull(request.getParameter( "header_tab" )) ;
	String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" )) ;

String visit_id = checkForNull(request.getParameter( "visit_id" )) ; String source_code = checkForNull(request.getParameter( "location_code" )) ; String source_type = checkForNull(request.getParameter( "location_type" )) ; //String enterprise_specific_flag = checkForNull(request.getParameter( "enterprise_specific_flag" )) ;//added by parul for Enterprise Specific Chart Applicable

	//out.println("enterprise_specific_flag:"+enterprise_specific_flag);

	String record_gingival_status_yn_param = checkForNull(request.getParameter( "record_gingival_status_yn_param" )) ;
	// added by parul  for other facility chart CRF#0423
	String other_facilitychart_yn = checkForNull(request.getParameter( "other_facilitychart_yn" )) ;
	String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
	String other_facility_yn = checkForNull(request.getParameter( "other_facility_yn" )) ;
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	 }

	//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
	String dflt_mixed_dentition_chart = checkForNull(request.getParameter( "dflt_mixed_dentition_chart" )) ;
	
	if(date_diff_flag.equals("disable")){
		disabled = "disabled";
	}
	//Added by Sharon Crasta on 1/11/2010 for IN017822
	//Used to disable the chart once the APP-OH000153 message is displayed and on cancel.
	String chart_disable_from_main = checkForNull(request.getParameter( "chart_disable_from_main" )) ;
	//End
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	//String sql = "";
	//String trmt_cond_date = "";
	//String cond_trmt_type = "";
	String gingival_recording_by = "";

	String gs_dflt_tooth_no_s1 = "";
	String gs_dflt_tooth_no_s2 = "";
	String gs_dflt_tooth_no_s3 = "";
	String gs_dflt_tooth_no_s4 = "";
	String gs_dflt_tooth_no_s5 = "";
	String gs_dflt_tooth_no_s6 = "";

	String gs_dflt_tooth_no_q1 = "";
	String gs_dflt_tooth_no_q2 = "";
	String gs_dflt_tooth_no_q3 = "";
	String gs_dflt_tooth_no_q4 = "";

	
	//ArrayList arrList = new ArrayList();


try{
	con = ConnectionManager.getConnection(request);

	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
	if(oh_chart_level.equals("E")){
		pstmt = con.prepareStatement("SELECT GINGIVAL_RECORDING_BY,GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4,GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM");
	}else{//End
		pstmt = con.prepareStatement("SELECT GINGIVAL_RECORDING_BY,GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4,GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?");
		//pstmt.setString(1,facility_id);
		pstmt.setString(1,other_chart_facility_id);
	}
	rs = pstmt.executeQuery();
	while (rs != null && rs.next()){
		gingival_recording_by = checkForNull(rs.getString("GINGIVAL_RECORDING_BY"));
		gs_dflt_tooth_no_q1 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_Q1"));
		gs_dflt_tooth_no_q2 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_Q2"));
		gs_dflt_tooth_no_q3 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_Q3"));
		gs_dflt_tooth_no_q4 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_Q4"));

		gs_dflt_tooth_no_s1 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S1"));
		gs_dflt_tooth_no_s2 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S2"));
		gs_dflt_tooth_no_s3 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S3"));
		gs_dflt_tooth_no_s4 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S4"));
		gs_dflt_tooth_no_s5 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S5"));
		gs_dflt_tooth_no_s6 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S6"));
	}


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

						//	if(record_gingival_status_yn_param.equals("Y") && (permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N"))){
							if(record_gingival_status_yn_param.equals("Y")){
						
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

							}
						
            _bw.write(_wl_block11Bytes, _wl_block11);

						 //  if (permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N")){
					  
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

						//	}
						
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

                             if (oh_chart_level.equals("F")){							
						
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

							}
						
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
 if(!called_from.equals("OT")){
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
 } 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(params));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(permanent_deciduous_flag));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkForNull(request.getParameter("episode_id"))));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(upper_arch_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(lower_arch_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Q1_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(Q2_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(Q3_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(Q4_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(Q1_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(Q2_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(Q3_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(Q4_desc));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(mixed_dentition_YN));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(chart_type));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(header_tab));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(baseline_chart_yn));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(checkForNull(request.getParameter("new_chart_num"))));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(ca_practitioner_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(checkForNull(request.getParameter("chart_line_num"))));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(checkForNull(request.getParameter("perio_chart"))));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(checkForNull(request.getParameter("perio_arch"))));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(checkForNull(request.getParameter("quadrant_sno"))));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(record_gingival_status_yn_param));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(other_facilitychart_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(other_facility_yn));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(date_diff_flag));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(gingival_recording_by));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(gs_dflt_tooth_no_s1));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(gs_dflt_tooth_no_s2));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(gs_dflt_tooth_no_s3));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(gs_dflt_tooth_no_s4));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(gs_dflt_tooth_no_s5));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(gs_dflt_tooth_no_s6));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(gs_dflt_tooth_no_q1));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(gs_dflt_tooth_no_q2));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(gs_dflt_tooth_no_q3));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(gs_dflt_tooth_no_q4));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(dflt_mixed_dentition_chart));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(chart_disable_from_main));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(bed_num));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block84Bytes, _wl_block84);

}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Conditions.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ExtTreatments.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.GingivalStatus.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Summary.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.BaselineCharts.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.OtherFacilityCharts.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.GingivalStatus.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalNotes.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.OtherLinks.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
