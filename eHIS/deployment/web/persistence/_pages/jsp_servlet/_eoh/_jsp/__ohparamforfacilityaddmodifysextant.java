package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __ohparamforfacilityaddmodifysextant extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/OHParamForFacilityAddModifySextant.jsp", 1709119351020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\n\t\t\n\t\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script language=\'javascript\' src=\'../../eOH/js/OHParameterForFacility.js\'></script>\t \n\t\t<script language=\'javascript\' src=\'../../eOH/js/OHParameters.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n\n\n\t</head>\n\t<!-- changed by parul on 211008 forSCR#6126 -->\n\t<!-- commented by parul on 10/08/2009 for crf 0456(IN009737) written in last AssignSextantValue() -->\n\t <!--   <body  onLoad= \"AssignSextantValue(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\',\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\');document.getElementById(\'ohsextant\').visibility = \'display\';document.getElementById(\'ohsextant\').style.display = \'\'\"; OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\"> -->\n\t    <body  onLoad= \"document.getElementById(\'ohsextant\').visibility = \'display\';document.getElementById(\'ohsextant\').style.display = \'\'\"; OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\"> \n\t\t<form name=\"OHParameterForFacilityFormForSextant\" id=\"OHParameterForFacilityFormForSextant\" >\n\t\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<div id=\'ohsextant\'>\n    \t\t  <table border=0 cellspacing=0 cellpadding=1 width=\'100%\' align=center >\n\t\t\t  <tr>\n               <td width=\"10%\">\n\t\t\t\t\t<table  border=0 cellspacing=0 cellpadding=8 width=\'100%\' align=\'center\' >\n\t\t\t\t\t\t<tr align=\'center\'><th ></th></tr>\n\t\t\t\t\t\t<tr align=\'center\'><th align=center >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th></tr>   \n\t\t\t\t\t\t<tr align=\'center\'><th  align=center></th></tr> \n                        <tr><td width=\"10%\" class=\"LABEL\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td></tr>\n\t\t\t\t\t\t<tr><td width=\"10%\" class=\"LABEL\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td></tr> \n\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t  <td width=\"25%\">\n\t\t\t\t\t<table  border=0 cellspacing=1 cellpadding=3 width=\'100%\' align=center >\n\t\t\t\t\t\t<tr align=center colspan=2>\n\t\t\t\t\t\t\t<th align=center colspan=3>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<th >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t\t\t\t<th colspan=2>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"25%\" align=\"center\" id=\"dec_gs_for_Q1\" ><input type=\"text\" name=\"dec_gs_no_of_tooth_for_S1\" id=\"dec_gs_no_of_tooth_for_S1\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" size=\"1\" maxlength=\"1\" onBlur=\"validateDecNumOfTooth(this)\" DB_VALUE=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td width=\"25%\" class=\"LABEL\" style=\"text-align:right\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t\t\t<td width=\"100%\" id=\"dec_gs_dflt_for_S1\">\n\t\t\t\t\t\t\t\t<select name=\"dec_gs_dflt_tooth_no_S1\" id=\"dec_gs_dflt_tooth_no_S1\" DB_VALUE=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =">\n\t\t\t\t\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</option>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t</select>\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n                         <tr>\n\t\t\t\t\t\t\t<td width=\"25%\" align=\"center\" id=\"dec_gs_for_Q2\"><input type=\"text\" name=\"dec_gs_no_of_tooth_for_S2\" id=\"dec_gs_no_of_tooth_for_S2\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\t\t\t<td width=\"100%\" id=\"dec_gs_dflt_for_S2\">\n\t\t\t\t\t\t\t\t<select name=\"dec_gs_dflt_tooth_no_S2\" id=\"dec_gs_dflt_tooth_no_S2\" DB_VALUE=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n                        <tr>\n\t\t\t\t\t\t\t<td width=\"25%\" align=\"center\" id=\"dec_gs_for_Q3\" ><input type=\"text\" name=\"dec_gs_no_of_tooth_for_S3\" id=\"dec_gs_no_of_tooth_for_S3\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t\t\t\t<td width=\"100%\" id=\"dec_gs_dflt_for_S3\">\n\t\t\t\t\t\t\t\t<select name=\"dec_gs_dflt_tooth_no_S3\" id=\"dec_gs_dflt_tooth_no_S3\" DB_VALUE=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"25%\" align=\"center\" id=\"dec_gs_for_Q4\"><input type=\"text\" name=\"dec_gs_no_of_tooth_for_S4\" id=\"dec_gs_no_of_tooth_for_S4\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t\t\t\t\t<td width=\"100%\" id=\"dec_gs_dflt_for_S4\">\n\t\t\t\t\t\t\t\t<select name=\"dec_gs_dflt_tooth_no_S4\" id=\"dec_gs_dflt_tooth_no_S4\" DB_VALUE=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"25%\" align=\"center\" id=\"dec_gs_for_Q5\" ><input type=\"text\" name=\"dec_gs_no_of_tooth_for_S5\" id=\"dec_gs_no_of_tooth_for_S5\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t\t\t\t\t<td width=\"100%\" id=\"dec_gs_dflt_for_S5\">\n\t\t\t\t\t\t\t\t<select name=\"dec_gs_dflt_tooth_no_S5\" id=\"dec_gs_dflt_tooth_no_S5\" DB_VALUE=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t    <td width=\"25%\" align=\"center\" id=\"dec_gs_for_Q6\" ><input type=\"text\" name=\"dec_gs_no_of_tooth_for_S6\" id=\"dec_gs_no_of_tooth_for_S6\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t\t\t\t\t<td width=\"100%\" id=\"dec_gs_dflt_for_S6\">\n\t\t\t\t\t\t\t\t<select name=\"dec_gs_dflt_tooth_no_S6\" id=\"dec_gs_dflt_tooth_no_S6\" DB_VALUE=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"25%\">\n\t\t\t\t\t\t<table  border=0 cellspacing=1 cellpadding=3 width=\'100%\' align=center >\n\t\t\t\t\t\t<tr align=center colspan=2>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t<th align=\"center\" colspan=3>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</th>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t<th align=\"center\" colspan=3 >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</th>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t   </tr>\n\t\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<th >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</th>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"25%\" align=\"center\" id=\"md_gs_for_Q1\" ><input type=\"text\" name=\"md_gs_no_of_tooth_for_S1\" id=\"md_gs_no_of_tooth_for_S1\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" size=\"1\" maxlength=\"1\" onBlur=\"validateMDNumOfTooth(this)\" DB_VALUE=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t\t\t\t\t<td width=\"100%\" id=\"md_gs_dflt_for_S1\">\n\t\t\t\t\t\t\t\t<select name=\"md_gs_dflt_tooth_no_S1\" id=\"md_gs_dflt_tooth_no_S1\" DB_VALUE=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t\t<!-- <img src=\'../../eCommon/images/mandatory.gif\'></img> -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n                         <tr>\n\t\t\t\t\t\t\t<td width=\"25%\" align=\"center\" id=\"md_gs_for_Q2\"><input type=\"text\" name=\"md_gs_no_of_tooth_for_S2\" id=\"md_gs_no_of_tooth_for_S2\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t\t\t\t\t<td width=\"100%\" id=\"md_gs_dflt_for_S2\">\n\t\t\t\t\t\t\t\t<select name=\"md_gs_dflt_tooth_no_S2\" id=\"md_gs_dflt_tooth_no_S2\" DB_VALUE=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n                        <tr>\n\t\t\t\t\t\t\t<td width=\"25%\" align=\"center\" id=\"md_gs_for_Q3\" ><input type=\"text\" name=\"md_gs_no_of_tooth_for_S3\" id=\"md_gs_no_of_tooth_for_S3\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t\t\t\t\t<td width=\"100%\" id=\"md_gs_dflt_for_S3\">\n\t\t\t\t\t\t\t\t<select name=\"md_gs_dflt_tooth_no_S3\" id=\"md_gs_dflt_tooth_no_S3\" DB_VALUE=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"25%\" align=\"center\" id=\"md_gs_for_Q4\"><input type=\"text\" name=\"md_gs_no_of_tooth_for_S4\" id=\"md_gs_no_of_tooth_for_S4\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t\t\t\t\t<td width=\"100%\" id=\"md_gs_dflt_for_S4\">\n\t\t\t\t\t\t\t\t<select name=\"md_gs_dflt_tooth_no_S4\" id=\"md_gs_dflt_tooth_no_S4\" DB_VALUE=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"25%\" align=\"center\" id=\"md_gs_for_Q5\" ><input type=\"text\" name=\"md_gs_no_of_tooth_for_S5\" id=\"md_gs_no_of_tooth_for_S5\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t\t\t\t<td width=\"100%\" id=\"md_gs_dflt_for_S5\">\n\t\t\t\t\t\t\t\t<select name=\"md_gs_dflt_tooth_no_S5\" id=\"md_gs_dflt_tooth_no_S5\" DB_VALUE=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"25%\" align=\"center\" id=\"md_gs_for_Q6\" ><input type=\"text\" name=\"md_gs_no_of_tooth_for_S6\" id=\"md_gs_no_of_tooth_for_S6\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t\t\t\t\t\t<td width=\"100%\" id=\"md_gs_dflt_for_S6\">\n\t\t\t\t\t\t\t\t<select name=\"md_gs_dflt_tooth_no_S6\" id=\"md_gs_dflt_tooth_no_S6\" DB_VALUE=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\n\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n    \t\t\t<td width=\"25%\">\n\t\t\t\t\t<table  border=0 cellspacing=1 cellpadding=3 width=\'100%\' align=center >\n\t\t\t\t\t\t<tr align=center colspan=2>\n\t\t\t\t\t\t\t<th align=center colspan=3>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</th>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<th>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</th>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"25%\" align=\"center\" id=\"gs_for_Q1\" ><input type=\"text\" name=\"gs_no_of_tooth_for_S1\" id=\"gs_no_of_tooth_for_S1\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" size=\"1\" maxlength=\"1\" onBlur=\"validateNumOfTooth(this)\" DB_VALUE=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t\t\t\t\t<td width=\"100%\" id=\"gs_dflt_for_S1\">\n\t\t\t\t\t\t\t\t<select name=\"gs_dflt_tooth_no_S1\" id=\"gs_dflt_tooth_no_S1\" DB_VALUE=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n                         <tr>\n\t\t\t\t\t\t\t<td width=\"25%\" align=\"center\" id=\"gs_for_Q2\"><input type=\"text\" name=\"gs_no_of_tooth_for_S2\" id=\"gs_no_of_tooth_for_S2\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\t\t\t\t\t\t\t<td width=\"100%\" id=\"gs_dflt_for_S2\">\n\t\t\t\t\t\t\t\t<select name=\"gs_dflt_tooth_no_S2\" id=\"gs_dflt_tooth_no_S2\" DB_VALUE=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n                        <tr>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td width=\"25%\" align=\"center\" id=\"gs_for_Q3\" ><input type=\"text\" name=\"gs_no_of_tooth_for_S3\" id=\"gs_no_of_tooth_for_S3\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\t\t\t\t\t\t\t<td width=\"100%\" id=\"gs_dflt_for_S3\">\n\t\t\t\t\t\t\t\t<select name=\"gs_dflt_tooth_no_S3\" id=\"gs_dflt_tooth_no_S3\" DB_VALUE=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"25%\" align=\"center\" id=\"gs_for_Q4\"><input type=\"text\" name=\"gs_no_of_tooth_for_S4\" id=\"gs_no_of_tooth_for_S4\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t\t\t\t\t\t<td width=\"100%\" id=\"gs_dflt_for_S4\">\n\t\t\t\t\t\t\t\t<select name=\"gs_dflt_tooth_no_S4\" id=\"gs_dflt_tooth_no_S4\" DB_VALUE=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"25%\" align=\"center\" id=\"gs_for_Q5\" ><input type=\"text\" name=\"gs_no_of_tooth_for_S5\" id=\"gs_no_of_tooth_for_S5\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t\t\t\t\t\t\t<td width=\"100%\" id=\"gs_dflt_for_S5\">\n\t\t\t\t\t\t\t\t<select name=\"gs_dflt_tooth_no_S5\" id=\"gs_dflt_tooth_no_S5\" DB_VALUE=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td width=\"25%\" align=\"center\" id=\"gs_for_Q6\" ><input type=\"text\" name=\"gs_no_of_tooth_for_S6\" id=\"gs_no_of_tooth_for_S6\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t\t\t\t\t<td width=\"100%\" id=\"gs_dflt_for_S6\">\n\t\t\t\t\t\t\t\t<select name=\"gs_dflt_tooth_no_S6\" id=\"gs_dflt_tooth_no_S6\" DB_VALUE=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\n\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\t\t\t\t\n\t\t\t</table>\n\t\t\t</div>\n         \n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =">\n\t\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =">\n\t\t\t<input type=\"hidden\" name=\"checked_yn\" id=\"checked_yn\" value=";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =">\n\t\t\t<input type=\"hidden\" name=\"chart_level\" id=\"chart_level\" value=";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =">\n\t\t   <input type=\"hidden\" name=\"tooth_numbering_system\" id=\"tooth_numbering_system\" value=";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =">\n\t\t   <input type=\"hidden\" name=\"record_gingival_status_yn\" id=\"record_gingival_status_yn\" value=";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =">\n\t\t   <input type=\"hidden\" name=\"dflt_mixed_dentition_chart\" id=\"dflt_mixed_dentition_chart\" value=";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="> \n\t\t   <input type=\"hidden\" name=\"from_mixed_dentition\" id=\"from_mixed_dentition\" value=";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="> \n\n\t\t  <input type=\"hidden\" name=\"gigival_recorded\" id=\"gigival_recorded\" value=\"S\"> \n\n\t\t  <input type=\"hidden\" name=\"gs_dflt_tooth_no_S1_hid\" id=\"gs_dflt_tooth_no_S1_hid\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"> \n\t\t  <input type=\"hidden\" name=\"gs_dflt_tooth_no_S2_hid\" id=\"gs_dflt_tooth_no_S2_hid\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\"> \n\t\t  <input type=\"hidden\" name=\"gs_dflt_tooth_no_S3_hid\" id=\"gs_dflt_tooth_no_S3_hid\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"> \n\t\t  <input type=\"hidden\" name=\"gs_dflt_tooth_no_S4_hid\" id=\"gs_dflt_tooth_no_S4_hid\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"> \n\t\t  <input type=\"hidden\" name=\"gs_dflt_tooth_no_S5_hid\" id=\"gs_dflt_tooth_no_S5_hid\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"> \n\t\t  <input type=\"hidden\" name=\"gs_dflt_tooth_no_S6_hid\" id=\"gs_dflt_tooth_no_S6_hid\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\"> \n\t\t  <input type=\"hidden\" name=\"gs_no_of_tooth_for_S1_hid\" id=\"gs_no_of_tooth_for_S1_hid\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"> \n\t\t  <input type=\"hidden\" name=\"gs_no_of_tooth_for_S2_hid\" id=\"gs_no_of_tooth_for_S2_hid\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\"> \n\t\t  <input type=\"hidden\" name=\"gs_no_of_tooth_for_S3_hid\" id=\"gs_no_of_tooth_for_S3_hid\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"> \n\t\t  <input type=\"hidden\" name=\"gs_no_of_tooth_for_S4_hid\" id=\"gs_no_of_tooth_for_S4_hid\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\"> \n\t\t  <input type=\"hidden\" name=\"gs_no_of_tooth_for_S5_hid\" id=\"gs_no_of_tooth_for_S5_hid\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"> \n\t\t  <input type=\"hidden\" name=\"gs_no_of_tooth_for_S6_hid\" id=\"gs_no_of_tooth_for_S6_hid\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\"> \n\t\t  <input type=\"hidden\" name=\"dec_gs_no_of_tooth_for_S1_hid\" id=\"dec_gs_no_of_tooth_for_S1_hid\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"> \n\t\t  <input type=\"hidden\" name=\"dec_gs_no_of_tooth_for_S2_hid\" id=\"dec_gs_no_of_tooth_for_S2_hid\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"> \n\t\t  <input type=\"hidden\" name=\"dec_gs_no_of_tooth_for_S3_hid\" id=\"dec_gs_no_of_tooth_for_S3_hid\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"> \n\t\t  <input type=\"hidden\" name=\"dec_gs_no_of_tooth_for_S4_hid\" id=\"dec_gs_no_of_tooth_for_S4_hid\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"> \n\t\t  <input type=\"hidden\" name=\"dec_gs_no_of_tooth_for_S5_hid\" id=\"dec_gs_no_of_tooth_for_S5_hid\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"> \n\t\t  <input type=\"hidden\" name=\"dec_gs_no_of_tooth_for_S6_hid\" id=\"dec_gs_no_of_tooth_for_S6_hid\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"> \n\t\t  <input type=\"hidden\" name=\"md_gs_no_of_tooth_for_S1_hid\" id=\"md_gs_no_of_tooth_for_S1_hid\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\"> \n\t\t  <input type=\"hidden\" name=\"md_gs_no_of_tooth_for_S2_hid\" id=\"md_gs_no_of_tooth_for_S2_hid\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"> \n\t\t  <input type=\"hidden\" name=\"md_gs_no_of_tooth_for_S3_hid\" id=\"md_gs_no_of_tooth_for_S3_hid\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\"> \n\t\t  <input type=\"hidden\" name=\"md_gs_no_of_tooth_for_S4_hid\" id=\"md_gs_no_of_tooth_for_S4_hid\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"> \n\t\t  <input type=\"hidden\" name=\"md_gs_no_of_tooth_for_S5_hid\" id=\"md_gs_no_of_tooth_for_S5_hid\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"> \n\t\t  <input type=\"hidden\" name=\"md_gs_no_of_tooth_for_S6_hid\" id=\"md_gs_no_of_tooth_for_S6_hid\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\"> \n\t\t<input type=\"hidden\" name=\"md_gs_dflt_tooth_no_S1_hid\" id=\"md_gs_dflt_tooth_no_S1_hid\" value=";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="> \n\t\t<input type=\"hidden\" name=\"md_gs_dflt_tooth_no_S2_hid\" id=\"md_gs_dflt_tooth_no_S2_hid\" value=";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="> \n\t\t<input type=\"hidden\" name=\"md_gs_dflt_tooth_no_S3_hid\" id=\"md_gs_dflt_tooth_no_S3_hid\" value=";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="> \n\t\t<input type=\"hidden\" name=\"md_gs_dflt_tooth_no_S4_hid\" id=\"md_gs_dflt_tooth_no_S4_hid\" value=";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="> \n\t\t<input type=\"hidden\" name=\"md_gs_dflt_tooth_no_S5_hid\" id=\"md_gs_dflt_tooth_no_S5_hid\" value=";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="> \n\t\t<input type=\"hidden\" name=\"md_gs_dflt_tooth_no_S6_hid\" id=\"md_gs_dflt_tooth_no_S6_hid\" value=";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="> \n\n\n\n\t\t<input type=\"hidden\" name=\"mixed_dentition_from_age_yrs_hid\" id=\"mixed_dentition_from_age_yrs_hid\" value=\"\">\n\t\t<input type=\"hidden\" name=\"mixed_dentition_to_age_yrs_hid\" id=\"mixed_dentition_to_age_yrs_hid\" value=\"\">\n\t\t<input type=\"hidden\" name=\"mixed_dentition_from_age_days_hid\" id=\"mixed_dentition_from_age_days_hid\" value=\"\">\n\t\t<input type=\"hidden\" name=\"mixed_dentition_to_age_days_hid\" id=\"mixed_dentition_to_age_days_hid\" value=\"\">\n\t\t<input type=\"hidden\" name=\"deciduous_grace_period_days_hid\" id=\"deciduous_grace_period_days_hid\" value=\"\">\n\t\t<input type=\"hidden\" name=\"dflt_mixed_dentition_chart_hid\" id=\"dflt_mixed_dentition_chart_hid\" value=\"\">\n\t\t<input type=\"hidden\" name=\"rest_chrt_validity_days_hid\" id=\"rest_chrt_validity_days_hid\" value=\"\">\n\t\t<input type=\"hidden\" name=\"peri_chrt_validity_days_hid\" id=\"peri_chrt_validity_days_hid\" value=\"\">\n\t\t<input type=\"hidden\" name=\"record_gingival_status_yn_hid\" id=\"record_gingival_status_yn_hid\" value=\"\">\n\t\t<input type=\"hidden\" name=\"bl_interface_flag_hid\" id=\"bl_interface_flag_hid\" value=\"\">\n\t\t<input type=\"hidden\" name=\"gingival_recording_by_hid\" id=\"gingival_recording_by_hid\" value=\"\">\n\t\t<input type=\"hidden\" name=\"tooth_numbering_system_hid\" id=\"tooth_numbering_system_hid\" value=\"\">\n\n\t\t</form>\n\t\t<script>\n\t\t\t     var chart_level=document.forms[0].chart_level.value;\n\t\t         if(chart_level==\"E\" || (chart_level==\"\" || chart_level==\"null\" || chart_level==null)){\n\t\t\t\t\tAssignParamSextantValue(\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\');\n\t\t\t\t }else if (chart_level==\"F\" ){\n\t\t\t\t    AssignSextantValue(\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\');\n\n\t\t\t\t}\t\t\t\n\t\t</script>\n\t  </body>\n   </html>\n\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );
 
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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
String mode=request.getParameter("mode");
    String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String record_gingival_status_yn = checkForNull(request.getParameter("record_gingival_status_yn")); 

            _bw.write(_wl_block5Bytes, _wl_block5);

			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(record_gingival_status_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);

			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String facility_id = (String)session.getValue("facility_id") ;
		  // String mode=request.getParameter("mode");
			//String tooth_numbering_system=""; //commented by parul on 211008 forSCR#6126
		//	String record_gingival_status_yn = ""; //commented by parul on 211008 forSCR#6126
			String record_gingival_status = checkForNull(request.getParameter("record_gingival_status_yn"));
			String from_mixed_dentition = checkForNull(request.getParameter("from_mixed_dentition"));
			String dflt_mixed_dentition_chart_hid = checkForNull(request.getParameter("dflt_mixed_dentition_chart"));
			
			String callFrom = checkForNull(request.getParameter("callFrom"));
			String chart_level = checkForNull(request.getParameter("chart_level"));
			String gs_dflt_tooth_no_S1_disabled = "";
			String gs_dflt_tooth_no_S2_disabled = "";
			String gs_dflt_tooth_no_S3_disabled = "";
			String gs_dflt_tooth_no_S4_disabled = "";
			String gs_dflt_tooth_no_S5_disabled = "";
			String gs_dflt_tooth_no_S6_disabled = "";

			String dec_gs_dflt_tooth_no_S1_disabled = "";
			String dec_gs_dflt_tooth_no_S2_disabled = "";
			String dec_gs_dflt_tooth_no_S3_disabled = "";
			String dec_gs_dflt_tooth_no_S4_disabled = "";
			String dec_gs_dflt_tooth_no_S5_disabled = "";
			String dec_gs_dflt_tooth_no_S6_disabled = "";

			String md_gs_dflt_tooth_no_S1_disabled = "";
			String md_gs_dflt_tooth_no_S2_disabled = "";
			String md_gs_dflt_tooth_no_S3_disabled = "";
			String md_gs_dflt_tooth_no_S4_disabled = "";
			String md_gs_dflt_tooth_no_S5_disabled = "";
			String md_gs_dflt_tooth_no_S6_disabled = "";

		   //paramters forPermanent sextant
			String gs_no_of_tooth_for_S1_hidden = checkForNull(request.getParameter("gs_no_of_tooth_for_S1_hidden"));
			String gs_no_of_tooth_for_S2_hidden  = checkForNull(request.getParameter("gs_no_of_tooth_for_S2_hidden"));
			String gs_no_of_tooth_for_S3_hidden = checkForNull(request.getParameter("gs_no_of_tooth_for_S3_hidden"));
			String gs_no_of_tooth_for_S4_hidden  = checkForNull(request.getParameter("gs_no_of_tooth_for_S4_hidden"));
			String gs_no_of_tooth_for_S5_hidden   = checkForNull(request.getParameter("gs_no_of_tooth_for_S5_hidden"));
			String gs_no_of_tooth_for_S6_hidden   = checkForNull(request.getParameter("gs_no_of_tooth_for_S6_hidden"));
			String gs_dflt_tooth_no_S1_hidden   = checkForNull(request.getParameter("gs_dflt_tooth_no_S1_hidden"));
			String gs_dflt_tooth_no_S2_hidden   = checkForNull(request.getParameter("gs_dflt_tooth_no_S2_hidden"));
			String gs_dflt_tooth_no_S3_hidden   = checkForNull(request.getParameter("gs_dflt_tooth_no_S3_hidden"));
			String gs_dflt_tooth_no_S4_hidden   = checkForNull(request.getParameter("gs_dflt_tooth_no_S4_hidden"));
			String gs_dflt_tooth_no_S5_hidden   = checkForNull(request.getParameter("gs_dflt_tooth_no_S5_hidden"));
			String gs_dflt_tooth_no_S6_hidden   = checkForNull(request.getParameter("gs_dflt_tooth_no_S6_hidden"));

		   //paramters for Deciduous sextant
			String dec_gs_no_of_tooth_for_S1_hidden = checkForNull(request.getParameter("dec_gs_no_of_tooth_for_S1_hidden"));
			String dec_gs_no_of_tooth_for_S2_hidden = checkForNull(request.getParameter("dec_gs_no_of_tooth_for_S2_hidden"));
			String dec_gs_no_of_tooth_for_S3_hidden = checkForNull(request.getParameter("dec_gs_no_of_tooth_for_S3_hidden"));
			String dec_gs_no_of_tooth_for_S4_hidden = checkForNull(request.getParameter("dec_gs_no_of_tooth_for_S4_hidden"));
			String dec_gs_no_of_tooth_for_S5_hidden = checkForNull(request.getParameter("dec_gs_no_of_tooth_for_S5_hidden"));
			String dec_gs_no_of_tooth_for_S6_hidden = checkForNull(request.getParameter("dec_gs_no_of_tooth_for_S6_hidden"));
			String dec_gs_dflt_tooth_no_S1_hidden   = checkForNull(request.getParameter("dec_gs_dflt_tooth_no_S1_hidden"));
			String dec_gs_dflt_tooth_no_S2_hidden   = checkForNull(request.getParameter("dec_gs_dflt_tooth_no_S2_hidden"));
			String dec_gs_dflt_tooth_no_S3_hidden   = checkForNull(request.getParameter("dec_gs_dflt_tooth_no_S3_hidden"));
			String dec_gs_dflt_tooth_no_S4_hidden   = checkForNull(request.getParameter("dec_gs_dflt_tooth_no_S4_hidden"));
			String dec_gs_dflt_tooth_no_S5_hidden   = checkForNull(request.getParameter("dec_gs_dflt_tooth_no_S5_hidden"));
			String dec_gs_dflt_tooth_no_S6_hidden   = checkForNull(request.getParameter("dec_gs_dflt_tooth_no_S6_hidden"));

		   //paramters for Mixed Dentition sextant
			String md_gs_no_of_tooth_for_S1_hidden = checkForNull(request.getParameter("md_gs_no_of_tooth_for_S1_hidden"));
			String md_gs_no_of_tooth_for_S2_hidden = checkForNull(request.getParameter("md_gs_no_of_tooth_for_S2_hidden"));
			String md_gs_no_of_tooth_for_S3_hidden = checkForNull(request.getParameter("md_gs_no_of_tooth_for_S3_hidden"));
			String md_gs_no_of_tooth_for_S4_hidden = checkForNull(request.getParameter("md_gs_no_of_tooth_for_S4_hidden"));
			String md_gs_no_of_tooth_for_S5_hidden = checkForNull(request.getParameter("md_gs_no_of_tooth_for_S5_hidden"));
			String md_gs_no_of_tooth_for_S6_hidden = checkForNull(request.getParameter("md_gs_no_of_tooth_for_S6_hidden"));
			String md_gs_dflt_tooth_no_S1_hidden   = checkForNull(request.getParameter("md_gs_dflt_tooth_no_S1_hidden"));
			String md_gs_dflt_tooth_no_S2_hidden   = checkForNull(request.getParameter("md_gs_dflt_tooth_no_S2_hidden"));
			String md_gs_dflt_tooth_no_S3_hidden   = checkForNull(request.getParameter("md_gs_dflt_tooth_no_S3_hidden"));
			String md_gs_dflt_tooth_no_S4_hidden   = checkForNull(request.getParameter("md_gs_dflt_tooth_no_S4_hidden"));
			String md_gs_dflt_tooth_no_S5_hidden   = checkForNull(request.getParameter("md_gs_dflt_tooth_no_S5_hidden"));
			String md_gs_dflt_tooth_no_S6_hidden   = checkForNull(request.getParameter("md_gs_dflt_tooth_no_S6_hidden"));

		   //paramters for Permanent sextant
			String gs_no_of_tooth_for_S1 = "";
			String gs_no_of_tooth_for_S2= "";
			String gs_no_of_tooth_for_S3 = "";
			String gs_no_of_tooth_for_S4  ="";
			String gs_no_of_tooth_for_S5 = "";
			String gs_no_of_tooth_for_S6 = "";
			String gs_dflt_tooth_no_S1 ="";
			String gs_dflt_tooth_no_S2 ="";
			String gs_dflt_tooth_no_S3 = "";
			String gs_dflt_tooth_no_S4 = "";
			String gs_dflt_tooth_no_S5 = "";
			String gs_dflt_tooth_no_S6 = "";

			 //paramters for Deciduous sextant
			String dec_gs_no_of_tooth_for_S1 = "";
			String dec_gs_no_of_tooth_for_S2 = "";
			String dec_gs_no_of_tooth_for_S3 = "";
			String dec_gs_no_of_tooth_for_S4 = "";
			String dec_gs_no_of_tooth_for_S5 = "";
			String dec_gs_no_of_tooth_for_S6 = "";
		    String dec_gs_dflt_tooth_no_S1 ="";
		    String dec_gs_dflt_tooth_no_S2 ="";
		    String dec_gs_dflt_tooth_no_S3 ="";
		    String dec_gs_dflt_tooth_no_S4 ="";
		    String dec_gs_dflt_tooth_no_S5 ="";
		    String dec_gs_dflt_tooth_no_S6 ="";

		   //paramters for Mixed Dentition sextant
		   String md_gs_no_of_tooth_for_S1 = "";
		   String md_gs_no_of_tooth_for_S2 = "";
		   String md_gs_no_of_tooth_for_S3 = "";
		   String md_gs_no_of_tooth_for_S4 = "";
		   String md_gs_no_of_tooth_for_S5 = "";
		   String md_gs_no_of_tooth_for_S6 = "";
		   String md_gs_dflt_tooth_no_S1 ="";
		   String md_gs_dflt_tooth_no_S2 ="";
		   String md_gs_dflt_tooth_no_S3 ="";
		   String md_gs_dflt_tooth_no_S4 ="";
		   String md_gs_dflt_tooth_no_S5 ="";
		   String md_gs_dflt_tooth_no_S6 ="";

			String dflt_mixed_dentition_chart = "";
		
		    String sql="";
			String checked_yn = "";
			String chk_value = "";
			String tooth_selected="";
			//String interface_flag_checked="";
			//String interface_flag_value="";
			int total_records=0;
			HashMap map = new HashMap();
			HashMap map_dec = new HashMap();
			HashMap map_md = new HashMap();
			String map_val = "";
		//	String map_md = "";
			String map_val_dec = "";
			String map_val_md = "";
			String j="";
			String n="";
			String q="";
			String sextant_sno="";
			String tooth_segment="";
			String map_value="";
			//String map_value_dec="";
			String[] map_value_arr=null;
		//	String[] map_value_arr_dec=null;
 			try{
				con=ConnectionManager.getConnection(request);
                if(chart_level.equals("F")){
					sql="SELECT COUNT(*) AS TOTAL_RECORDS_EXISTING FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?";
					pstmt=con.prepareStatement(sql);
				    pstmt.setString(1,facility_id);
					//rs=pstmt.executeQuery();
				
				}else if (chart_level.equals("E")|| chart_level.equals("") || chart_level.equals("null") || chart_level.equals(null)){
					sql="SELECT COUNT(*) AS TOTAL_RECORDS_EXISTING FROM OH_PARAM";
					pstmt=con.prepareStatement(sql);
				}
				rs=pstmt.executeQuery();
				rs.next();
				
				total_records=Integer.parseInt(checkForNull(rs.getString(1),"0"));
				//total_records=Integer.parseInt(checkForNull(rs.getString(1)));
						
			if(total_records==1){
				   mode="modify";
			}
			else{
				   mode="insert";
			}
			if(mode.equals("modify")){
                sql="SELECT chart_level FROM OH_PARAM";
				pstmt=con.prepareStatement(sql);
				//pstmt.setString(1,facility_id);
				rs=pstmt.executeQuery();

				while(rs!=null && rs.next()){
						chart_level=checkForNull(rs.getString("chart_level"));

				}
			    if(chart_level.equals("F")){
					sql="SELECT * FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,facility_id);
					rs=pstmt.executeQuery();

					while(rs!=null && rs.next()){
							tooth_numbering_system=checkForNull(rs.getString("tooth_numbering_system"));
							gs_no_of_tooth_for_S1=checkForNull(rs.getString("gs_no_of_tooth_for_S1"));
							gs_no_of_tooth_for_S2=checkForNull(rs.getString("gs_no_of_tooth_for_S2"));
							gs_no_of_tooth_for_S3=checkForNull(rs.getString("gs_no_of_tooth_for_S3"));
							gs_no_of_tooth_for_S4=checkForNull(rs.getString("gs_no_of_tooth_for_S4"));
							gs_no_of_tooth_for_S5=checkForNull(rs.getString("gs_no_of_tooth_for_S5"));
							gs_no_of_tooth_for_S6=checkForNull(rs.getString("gs_no_of_tooth_for_S6"));
							gs_dflt_tooth_no_S1=checkForNull(rs.getString("gs_dflt_tooth_no_S1"));
							gs_dflt_tooth_no_S2=checkForNull(rs.getString("gs_dflt_tooth_no_S2"));
							gs_dflt_tooth_no_S3=checkForNull(rs.getString("gs_dflt_tooth_no_S3"));
							gs_dflt_tooth_no_S4=checkForNull(rs.getString("gs_dflt_tooth_no_S4"));
							gs_dflt_tooth_no_S5=checkForNull(rs.getString("gs_dflt_tooth_no_S5"));
							gs_dflt_tooth_no_S6=checkForNull(rs.getString("gs_dflt_tooth_no_S6"));

							dec_gs_no_of_tooth_for_S1=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S1"));
							dec_gs_no_of_tooth_for_S2=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S2"));
							dec_gs_no_of_tooth_for_S3=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S3"));
							dec_gs_no_of_tooth_for_S4=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S4"));
							dec_gs_no_of_tooth_for_S5=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S5"));
							dec_gs_no_of_tooth_for_S6=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S6"));
							dec_gs_dflt_tooth_no_S1=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S1"));
							dec_gs_dflt_tooth_no_S2=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S2"));
							dec_gs_dflt_tooth_no_S3=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S3"));
							dec_gs_dflt_tooth_no_S4=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S4"));
							dec_gs_dflt_tooth_no_S5=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S5"));
							dec_gs_dflt_tooth_no_S6=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S6"));

							md_gs_no_of_tooth_for_S1=checkForNull(rs.getString("md_gs_no_of_tooth_for_S1"));
							md_gs_no_of_tooth_for_S2=checkForNull(rs.getString("md_gs_no_of_tooth_for_S2"));
							md_gs_no_of_tooth_for_S3=checkForNull(rs.getString("md_gs_no_of_tooth_for_S3"));
							md_gs_no_of_tooth_for_S4=checkForNull(rs.getString("md_gs_no_of_tooth_for_S4"));
							md_gs_no_of_tooth_for_S5=checkForNull(rs.getString("md_gs_no_of_tooth_for_S5"));
							md_gs_no_of_tooth_for_S6=checkForNull(rs.getString("md_gs_no_of_tooth_for_S6"));
							md_gs_dflt_tooth_no_S1=checkForNull(rs.getString("md_gs_dflt_tooth_no_S1"));
							md_gs_dflt_tooth_no_S2=checkForNull(rs.getString("md_gs_dflt_tooth_no_S2"));
							md_gs_dflt_tooth_no_S3=checkForNull(rs.getString("md_gs_dflt_tooth_no_S3"));
							md_gs_dflt_tooth_no_S4=checkForNull(rs.getString("md_gs_dflt_tooth_no_S4"));
							md_gs_dflt_tooth_no_S5=checkForNull(rs.getString("md_gs_dflt_tooth_no_S5"));
							md_gs_dflt_tooth_no_S6=checkForNull(rs.getString("md_gs_dflt_tooth_no_S6"));

							record_gingival_status_yn=checkForNull(rs.getString("record_gingival_status_yn"));
							dflt_mixed_dentition_chart=checkForNull(rs.getString("dflt_mixed_dentition_chart"));
					  }
							if (!gs_dflt_tooth_no_S1.equals("")){
							   gs_dflt_tooth_no_S1_disabled="disabled";
							
							}
							 if(!gs_dflt_tooth_no_S2.equals("")){
								gs_dflt_tooth_no_S2_disabled="disabled";
							}	
							 if(!gs_dflt_tooth_no_S3.equals("")){
								gs_dflt_tooth_no_S3_disabled="disabled";
							}
							 if(!gs_dflt_tooth_no_S4.equals("")){
								gs_dflt_tooth_no_S4_disabled="disabled";
							}
							 if(!gs_dflt_tooth_no_S5.equals("")){
								gs_dflt_tooth_no_S5_disabled="disabled";
							}
							 if(!gs_dflt_tooth_no_S6.equals("")){
								gs_dflt_tooth_no_S6_disabled="disabled";
							}

							 if (!dec_gs_dflt_tooth_no_S1.equals("")){
								dec_gs_dflt_tooth_no_S1_disabled="disabled";
								
							}
							 if (!dec_gs_dflt_tooth_no_S2.equals("")){
								dec_gs_dflt_tooth_no_S2_disabled="disabled";
								
							}
							 if (!dec_gs_dflt_tooth_no_S3.equals("")){
								dec_gs_dflt_tooth_no_S3_disabled="disabled";
								
							}
							 if (!dec_gs_dflt_tooth_no_S4.equals("")){
								dec_gs_dflt_tooth_no_S4_disabled="disabled";
								
							}
							 if (!dec_gs_dflt_tooth_no_S5.equals("")){
								dec_gs_dflt_tooth_no_S5_disabled="disabled";
								
							}
							 if (!dec_gs_dflt_tooth_no_S6.equals("")){
								dec_gs_dflt_tooth_no_S6_disabled="disabled";
								
							}

							 if (!md_gs_dflt_tooth_no_S1.equals("")){
								md_gs_dflt_tooth_no_S1_disabled="disabled";
								
							}
							
							 if (!md_gs_dflt_tooth_no_S2.equals("")){
								md_gs_dflt_tooth_no_S2_disabled="disabled";
								
							}
							
							 if (!md_gs_dflt_tooth_no_S3.equals("")){
								md_gs_dflt_tooth_no_S3_disabled="disabled";
								
							}
							
							 if (!md_gs_dflt_tooth_no_S4.equals("")){
								md_gs_dflt_tooth_no_S4_disabled="disabled";
								
							}
							
							 if (!md_gs_dflt_tooth_no_S5.equals("")){
								md_gs_dflt_tooth_no_S5_disabled="disabled";
								
							}
							
							 if (!md_gs_dflt_tooth_no_S6.equals("")){
								md_gs_dflt_tooth_no_S6_disabled="disabled";
								
							}
				}else if (chart_level.equals("E") || (chart_level.equals("") || chart_level.equals("null") || chart_level.equals(null))){
				        sql="SELECT * FROM OH_PARAM";
						pstmt=con.prepareStatement(sql);
						//pstmt.setString(1,facility_id);
						rs=pstmt.executeQuery();
						while(rs!=null && rs.next()){
							tooth_numbering_system=checkForNull(rs.getString("tooth_numbering_system"));
							gs_no_of_tooth_for_S1=checkForNull(rs.getString("gs_no_of_tooth_for_S1"));
							gs_no_of_tooth_for_S2=checkForNull(rs.getString("gs_no_of_tooth_for_S2"));
							gs_no_of_tooth_for_S3=checkForNull(rs.getString("gs_no_of_tooth_for_S3"));
							gs_no_of_tooth_for_S4=checkForNull(rs.getString("gs_no_of_tooth_for_S4"));
							gs_no_of_tooth_for_S5=checkForNull(rs.getString("gs_no_of_tooth_for_S5"));
							gs_no_of_tooth_for_S6=checkForNull(rs.getString("gs_no_of_tooth_for_S6"));
							gs_dflt_tooth_no_S1=checkForNull(rs.getString("gs_dflt_tooth_no_S1"));
							gs_dflt_tooth_no_S2=checkForNull(rs.getString("gs_dflt_tooth_no_S2"));
							gs_dflt_tooth_no_S3=checkForNull(rs.getString("gs_dflt_tooth_no_S3"));
							gs_dflt_tooth_no_S4=checkForNull(rs.getString("gs_dflt_tooth_no_S4"));
							gs_dflt_tooth_no_S5=checkForNull(rs.getString("gs_dflt_tooth_no_S5"));
							gs_dflt_tooth_no_S6=checkForNull(rs.getString("gs_dflt_tooth_no_S6"));

							dec_gs_no_of_tooth_for_S1=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S1"));
							dec_gs_no_of_tooth_for_S2=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S2"));
							dec_gs_no_of_tooth_for_S3=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S3"));
							dec_gs_no_of_tooth_for_S4=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S4"));
							dec_gs_no_of_tooth_for_S5=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S5"));
							dec_gs_no_of_tooth_for_S6=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S6"));
							dec_gs_dflt_tooth_no_S1=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S1"));
							dec_gs_dflt_tooth_no_S2=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S2"));
							dec_gs_dflt_tooth_no_S3=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S3"));
							dec_gs_dflt_tooth_no_S4=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S4"));
							dec_gs_dflt_tooth_no_S5=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S5"));
							dec_gs_dflt_tooth_no_S6=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S6"));

							md_gs_no_of_tooth_for_S1=checkForNull(rs.getString("md_gs_no_of_tooth_for_S1"));
							md_gs_no_of_tooth_for_S2=checkForNull(rs.getString("md_gs_no_of_tooth_for_S2"));
							md_gs_no_of_tooth_for_S3=checkForNull(rs.getString("md_gs_no_of_tooth_for_S3"));
							md_gs_no_of_tooth_for_S4=checkForNull(rs.getString("md_gs_no_of_tooth_for_S4"));
							md_gs_no_of_tooth_for_S5=checkForNull(rs.getString("md_gs_no_of_tooth_for_S5"));
							md_gs_no_of_tooth_for_S6=checkForNull(rs.getString("md_gs_no_of_tooth_for_S6"));
							md_gs_dflt_tooth_no_S1=checkForNull(rs.getString("md_gs_dflt_tooth_no_S1"));
							md_gs_dflt_tooth_no_S2=checkForNull(rs.getString("md_gs_dflt_tooth_no_S2"));
							md_gs_dflt_tooth_no_S3=checkForNull(rs.getString("md_gs_dflt_tooth_no_S3"));
							md_gs_dflt_tooth_no_S4=checkForNull(rs.getString("md_gs_dflt_tooth_no_S4"));
							md_gs_dflt_tooth_no_S5=checkForNull(rs.getString("md_gs_dflt_tooth_no_S5"));
							md_gs_dflt_tooth_no_S6=checkForNull(rs.getString("md_gs_dflt_tooth_no_S6"));

							record_gingival_status_yn=checkForNull(rs.getString("record_gingival_status_yn"));
							dflt_mixed_dentition_chart=checkForNull(rs.getString("dflt_mixed_dentition_chart"));
						}
						 if (!gs_dflt_tooth_no_S1.equals("")){
							gs_dflt_tooth_no_S1_disabled="disabled";
							
						}
						 if(!gs_dflt_tooth_no_S2.equals("")){
							gs_dflt_tooth_no_S2_disabled="disabled";
						}	
						 if(!gs_dflt_tooth_no_S3.equals("")){
							gs_dflt_tooth_no_S3_disabled="disabled";
						}
						 if(!gs_dflt_tooth_no_S4.equals("")){
							gs_dflt_tooth_no_S4_disabled="disabled";
						}
						 if(!gs_dflt_tooth_no_S5.equals("")){
							gs_dflt_tooth_no_S5_disabled="disabled";
						}
						 if(!gs_dflt_tooth_no_S6.equals("")){
							gs_dflt_tooth_no_S6_disabled="disabled";
						}

						 if (!dec_gs_dflt_tooth_no_S1.equals("")){
							dec_gs_dflt_tooth_no_S1_disabled="disabled";
							
						}
						 if (!dec_gs_dflt_tooth_no_S2.equals("")){
							dec_gs_dflt_tooth_no_S2_disabled="disabled";
							
						}
						 if (!dec_gs_dflt_tooth_no_S3.equals("")){
							dec_gs_dflt_tooth_no_S3_disabled="disabled";
							
						}
						 if (!dec_gs_dflt_tooth_no_S4.equals("")){
							dec_gs_dflt_tooth_no_S4_disabled="disabled";
							
						}
						 if (!dec_gs_dflt_tooth_no_S5.equals("")){
							dec_gs_dflt_tooth_no_S5_disabled="disabled";
							
						}
						 if (!dec_gs_dflt_tooth_no_S6.equals("")){
							dec_gs_dflt_tooth_no_S6_disabled="disabled";
							
						}

						 if (!md_gs_dflt_tooth_no_S1.equals("")){
							md_gs_dflt_tooth_no_S1_disabled="disabled";
							
						}
						
						 if (!md_gs_dflt_tooth_no_S2.equals("")){
							md_gs_dflt_tooth_no_S2_disabled="disabled";
							
						}
						
						 if (!md_gs_dflt_tooth_no_S3.equals("")){
							md_gs_dflt_tooth_no_S3_disabled="disabled";
							
						}
						
						 if (!md_gs_dflt_tooth_no_S4.equals("")){
							md_gs_dflt_tooth_no_S4_disabled="disabled";
							
						}
						
						 if (!md_gs_dflt_tooth_no_S5.equals("")){
							md_gs_dflt_tooth_no_S5_disabled="disabled";
							
						}
						
						 if (!md_gs_dflt_tooth_no_S6.equals("")){
							md_gs_dflt_tooth_no_S6_disabled="disabled";
							
						}
				}

				if(callFrom.equals("T")){
					gs_no_of_tooth_for_S1="";
					gs_no_of_tooth_for_S2="";
					gs_no_of_tooth_for_S3="";
					gs_no_of_tooth_for_S4="";
					gs_no_of_tooth_for_S5="";
					gs_no_of_tooth_for_S6="";
					gs_dflt_tooth_no_S1="";
					gs_dflt_tooth_no_S2="";
					gs_dflt_tooth_no_S3="";
					gs_dflt_tooth_no_S4="";
					gs_dflt_tooth_no_S5="";
					gs_dflt_tooth_no_S6="";

					dec_gs_no_of_tooth_for_S1="";
					dec_gs_no_of_tooth_for_S2="";
					dec_gs_no_of_tooth_for_S3="";
					dec_gs_no_of_tooth_for_S4="";
					dec_gs_no_of_tooth_for_S5="";
					dec_gs_no_of_tooth_for_S6="";
					dec_gs_dflt_tooth_no_S1="";
					dec_gs_dflt_tooth_no_S2="";
					dec_gs_dflt_tooth_no_S3="";
					dec_gs_dflt_tooth_no_S4="";
					dec_gs_dflt_tooth_no_S5="";
					dec_gs_dflt_tooth_no_S6="";

					md_gs_no_of_tooth_for_S1="";
					md_gs_no_of_tooth_for_S2="";
					md_gs_no_of_tooth_for_S3="";
					md_gs_no_of_tooth_for_S4="";
					md_gs_no_of_tooth_for_S5="";
					md_gs_no_of_tooth_for_S6="";
					md_gs_dflt_tooth_no_S1="";
					md_gs_dflt_tooth_no_S2="";
					md_gs_dflt_tooth_no_S3="";
					md_gs_dflt_tooth_no_S4="";
					md_gs_dflt_tooth_no_S5="";
					md_gs_dflt_tooth_no_S6="";				
				}
           
				if(record_gingival_status_yn.equals("Y")){
					checked_yn = "checked";
					chk_value = "Y";
				}
				else{
					checked_yn = "";
					chk_value = "N";
				}
              /*  if (!gs_dflt_tooth_no_S1.equals("")){
				    gs_dflt_tooth_no_S1_disabled="disabled";
					
				}
				 if(!gs_dflt_tooth_no_S2.equals("")){
					gs_dflt_tooth_no_S2_disabled="disabled";
				}	
				 if(!gs_dflt_tooth_no_S3.equals("")){
					gs_dflt_tooth_no_S3_disabled="disabled";
				}
				 if(!gs_dflt_tooth_no_S4.equals("")){
					gs_dflt_tooth_no_S4_disabled="disabled";
				}
				 if(!gs_dflt_tooth_no_S5.equals("")){
					gs_dflt_tooth_no_S5_disabled="disabled";
				}
				 if(!gs_dflt_tooth_no_S6.equals("")){
					gs_dflt_tooth_no_S6_disabled="disabled";
				}

				 if (!dec_gs_dflt_tooth_no_S1.equals("")){
				    dec_gs_dflt_tooth_no_S1_disabled="disabled";
					
				}
				 if (!dec_gs_dflt_tooth_no_S2.equals("")){
				    dec_gs_dflt_tooth_no_S2_disabled="disabled";
					
				}
				 if (!dec_gs_dflt_tooth_no_S3.equals("")){
				    dec_gs_dflt_tooth_no_S3_disabled="disabled";
					
				}
				 if (!dec_gs_dflt_tooth_no_S4.equals("")){
				    dec_gs_dflt_tooth_no_S4_disabled="disabled";
					
				}
				 if (!dec_gs_dflt_tooth_no_S5.equals("")){
				    dec_gs_dflt_tooth_no_S5_disabled="disabled";
					
				}
				 if (!dec_gs_dflt_tooth_no_S6.equals("")){
				    dec_gs_dflt_tooth_no_S6_disabled="disabled";
					
				}

				 if (!md_gs_dflt_tooth_no_S1.equals("")){
				    md_gs_dflt_tooth_no_S1_disabled="disabled";
					
				}
				
				 if (!md_gs_dflt_tooth_no_S2.equals("")){
				    md_gs_dflt_tooth_no_S2_disabled="disabled";
					
				}
				
				 if (!md_gs_dflt_tooth_no_S3.equals("")){
				    md_gs_dflt_tooth_no_S3_disabled="disabled";
					
				}
				
				 if (!md_gs_dflt_tooth_no_S4.equals("")){
				    md_gs_dflt_tooth_no_S4_disabled="disabled";
					
				}
				
				 if (!md_gs_dflt_tooth_no_S5.equals("")){
				    md_gs_dflt_tooth_no_S5_disabled="disabled";
					
				}
				
				 if (!md_gs_dflt_tooth_no_S6.equals("")){
				    md_gs_dflt_tooth_no_S6_disabled="disabled";
					
				}*/
            }
			if(callFrom.equals("S")){
					gs_no_of_tooth_for_S1=gs_no_of_tooth_for_S1_hidden;
					gs_no_of_tooth_for_S2=gs_no_of_tooth_for_S2_hidden;
					gs_no_of_tooth_for_S3=gs_no_of_tooth_for_S3_hidden;
					gs_no_of_tooth_for_S4=gs_no_of_tooth_for_S4_hidden;
					gs_no_of_tooth_for_S5=gs_no_of_tooth_for_S5_hidden;
					gs_no_of_tooth_for_S6=gs_no_of_tooth_for_S6_hidden;
					gs_dflt_tooth_no_S1=gs_dflt_tooth_no_S1_hidden;
					gs_dflt_tooth_no_S2=gs_dflt_tooth_no_S2_hidden;
					gs_dflt_tooth_no_S3=gs_dflt_tooth_no_S3_hidden;
					gs_dflt_tooth_no_S4=gs_dflt_tooth_no_S4_hidden;
					gs_dflt_tooth_no_S5=gs_dflt_tooth_no_S5_hidden;
					gs_dflt_tooth_no_S6=gs_dflt_tooth_no_S6_hidden;

					dec_gs_no_of_tooth_for_S1=dec_gs_no_of_tooth_for_S1_hidden;
					dec_gs_no_of_tooth_for_S2=dec_gs_no_of_tooth_for_S2_hidden;
					dec_gs_no_of_tooth_for_S3=dec_gs_no_of_tooth_for_S3_hidden;
					dec_gs_no_of_tooth_for_S4=dec_gs_no_of_tooth_for_S4_hidden;
					dec_gs_no_of_tooth_for_S5=dec_gs_no_of_tooth_for_S5_hidden;
					dec_gs_no_of_tooth_for_S6=dec_gs_no_of_tooth_for_S6_hidden;
					dec_gs_dflt_tooth_no_S1=dec_gs_dflt_tooth_no_S1_hidden;
					dec_gs_dflt_tooth_no_S2=dec_gs_dflt_tooth_no_S2_hidden;
					dec_gs_dflt_tooth_no_S3=dec_gs_dflt_tooth_no_S3_hidden;
					dec_gs_dflt_tooth_no_S4=dec_gs_dflt_tooth_no_S4_hidden;
					dec_gs_dflt_tooth_no_S5=dec_gs_dflt_tooth_no_S5_hidden;
					dec_gs_dflt_tooth_no_S6=dec_gs_dflt_tooth_no_S6_hidden;

					md_gs_no_of_tooth_for_S1=md_gs_no_of_tooth_for_S1_hidden;
					md_gs_no_of_tooth_for_S2=md_gs_no_of_tooth_for_S2_hidden;
					md_gs_no_of_tooth_for_S3=md_gs_no_of_tooth_for_S3_hidden;
					md_gs_no_of_tooth_for_S4=md_gs_no_of_tooth_for_S4_hidden;
					md_gs_no_of_tooth_for_S5=md_gs_no_of_tooth_for_S5_hidden;
					md_gs_no_of_tooth_for_S6=md_gs_no_of_tooth_for_S6_hidden;
					md_gs_dflt_tooth_no_S1=md_gs_dflt_tooth_no_S1_hidden;
					md_gs_dflt_tooth_no_S2=md_gs_dflt_tooth_no_S2_hidden;
					md_gs_dflt_tooth_no_S3=md_gs_dflt_tooth_no_S3_hidden;
					md_gs_dflt_tooth_no_S4=md_gs_dflt_tooth_no_S4_hidden;
					md_gs_dflt_tooth_no_S5=md_gs_dflt_tooth_no_S5_hidden;
					md_gs_dflt_tooth_no_S6=md_gs_dflt_tooth_no_S6_hidden;

				
				}

			String tooth_no = "";
			String tooth_num = "";
			
            //sql="SELECT TOOTH_NO, DECODE(?,'UNI', UNIVERSAL_TOOTH_NO,'FDI',FDI_TOOTH_NO,'') TOOTH_NUM FROM OH_TOOTH where PERMANENT_DECIDUOUS = 'P' ORDER BY TOOTH_NO ASC";
			//sql="SELECT A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
			sql="SELECT A.SEXTANT_SNO,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
				
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,tooth_numbering_system);
			
			rs=pstmt.executeQuery();
			
			while(rs!=null && rs.next()){
               sextant_sno=checkForNull(rs.getString("SEXTANT_SNO"));
				tooth_no=checkForNull(rs.getString("TOOTH_NO"));
				tooth_num=checkForNull(rs.getString("TOOTH_NUM"));
				if(tooth_num.equals("")){
					map = new HashMap();
				}
				else{
					tooth_segment=tooth_num+"#"+sextant_sno;
					map.put(tooth_no,tooth_segment);
				}
			}

			  //for deciduous tooth
			String sql_dec="SELECT A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'D' ORDER BY A.TOOTH_NO ASC";
				
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement(sql_dec);
			pstmt.setString(1,tooth_numbering_system);
			rs=pstmt.executeQuery();
			while(rs!=null && rs.next()){

				tooth_no=checkForNull(rs.getString("TOOTH_NO"));
				tooth_num=checkForNull(rs.getString("TOOTH_NUM"));
				if(tooth_num.equals("")){
					map_dec = new HashMap();
				}
				else{
					map_dec.put(tooth_no,tooth_num);
				}
			}

			//MD chart 

			String sql_1="SELECT A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM =? AND (A.PERMANENT_DECIDUOUS = 'D' OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY MIXED_DENT_TOOTH_ORDER ASC";
			
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement(sql_1);
			pstmt.setString(1,tooth_numbering_system);
			//pstmt.setString(2,dflt_mixed_dentition_chart);
			rs=pstmt.executeQuery();
			String tooth_no_md = "";
			String tooth_num_md = "";
			while(rs!=null && rs.next()){

				tooth_no_md=checkForNull(rs.getString("TOOTH_NO"));
				tooth_num_md=checkForNull(rs.getString("TOOTH_NUM"));
				if(tooth_num_md.equals("")){
					map_md = new HashMap();
				}
				else{
					map_md.put(tooth_no_md,tooth_num_md);
				}
			}
		
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

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
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dec_gs_no_of_tooth_for_S1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dec_gs_no_of_tooth_for_S1));
            _bw.write(_wl_block18Bytes, _wl_block18);

									if(record_gingival_status.equals("Y")){								
							
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
							
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dec_gs_dflt_tooth_no_S1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dec_gs_dflt_tooth_no_S1_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

										for(int m=33;m<=34;m++){
											n=""+m;
											if(map_dec.isEmpty() == false){
												map_val_dec = map_dec.get(n).toString();
												out.println("<option value='"+m+"' "+tooth_selected+">"+map_val_dec+"</option>");
												//out.println("<option value='"+m+"'>map_val_dec+"</option>");
											}
										}
									
            _bw.write(_wl_block25Bytes, _wl_block25);

									if(record_gingival_status.equals("Y")){								
								
            _bw.write(_wl_block26Bytes, _wl_block26);

									}
								
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(dec_gs_no_of_tooth_for_S2));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dec_gs_no_of_tooth_for_S2));
            _bw.write(_wl_block18Bytes, _wl_block18);

									if(record_gingival_status.equals("Y")){								
							
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
							
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dec_gs_dflt_tooth_no_S2));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dec_gs_dflt_tooth_no_S2_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

										for(int m=35;m<=40;m++){
											n=""+m;
											if(map_dec.isEmpty() == false){
												map_val_dec = map_dec.get(n).toString();
												out.println("<option value='"+m+"' "+tooth_selected+">"+map_val_dec+"</option>");
												//out.println("<option value='"+m+"'>map_val_dec+"</option>");
											}
										}
									
            _bw.write(_wl_block29Bytes, _wl_block29);

									if(record_gingival_status.equals("Y")){								
								
            _bw.write(_wl_block26Bytes, _wl_block26);

									}
								
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(dec_gs_no_of_tooth_for_S3));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dec_gs_no_of_tooth_for_S3));
            _bw.write(_wl_block18Bytes, _wl_block18);

								if(record_gingival_status.equals("Y")){								
							
            _bw.write(_wl_block19Bytes, _wl_block19);

							}
							
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(dec_gs_dflt_tooth_no_S3));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dec_gs_dflt_tooth_no_S3_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

										for(int m=41;m<=42;m++){
											n=""+m;
											if(map_dec.isEmpty() == false){
												map_val_dec = map_dec.get(n).toString();
												out.println("<option value='"+m+"' "+tooth_selected+">"+map_val_dec+"</option>");
												//out.println("<option value='"+m+"'>map_val_dec+"</option>");
											}
										}
									
            _bw.write(_wl_block29Bytes, _wl_block29);

									if(record_gingival_status.equals("Y")){								
								
            _bw.write(_wl_block26Bytes, _wl_block26);

									}
								
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dec_gs_no_of_tooth_for_S4));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dec_gs_no_of_tooth_for_S4));
            _bw.write(_wl_block18Bytes, _wl_block18);

								if(record_gingival_status.equals("Y")){								
							
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
							
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(dec_gs_dflt_tooth_no_S4));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dec_gs_dflt_tooth_no_S4_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

										for(int m=43;m<=44;m++){
											n=""+m;
											if(map_dec.isEmpty() == false){
												map_val_dec = map_dec.get(n).toString();
												out.println("<option value='"+m+"' "+tooth_selected+">"+map_val_dec+"</option>");
												//out.println("<option value='"+m+"'>map_val_dec+"</option>");
											}
										}
									
            _bw.write(_wl_block29Bytes, _wl_block29);

									if(record_gingival_status.equals("Y")){								
								
            _bw.write(_wl_block26Bytes, _wl_block26);

									}
								
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(dec_gs_no_of_tooth_for_S5));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dec_gs_no_of_tooth_for_S5));
            _bw.write(_wl_block18Bytes, _wl_block18);

								if(record_gingival_status.equals("Y")){								
							
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
							
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dec_gs_dflt_tooth_no_S5));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dec_gs_dflt_tooth_no_S5_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

										for(int m=45;m<=50;m++){
											n=""+m;
											if(map_dec.isEmpty() == false){
												map_val_dec = map_dec.get(n).toString();
												out.println("<option value='"+m+"' "+tooth_selected+">"+map_val_dec+"</option>");
												//out.println("<option value='"+m+"'>map_val_dec+"</option>");
											}
										}
									
            _bw.write(_wl_block29Bytes, _wl_block29);

									if(record_gingival_status.equals("Y")){								
								
            _bw.write(_wl_block26Bytes, _wl_block26);

									}
								
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dec_gs_no_of_tooth_for_S6));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dec_gs_no_of_tooth_for_S6));
            _bw.write(_wl_block18Bytes, _wl_block18);

								if(record_gingival_status.equals("Y")){								
							
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
							
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(dec_gs_dflt_tooth_no_S6));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dec_gs_dflt_tooth_no_S6_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

										for(int m=51;m<=52;m++){
											n=""+m;
											if(map_dec.isEmpty() == false){
												map_val_dec = map_dec.get(n).toString();
												out.println("<option value='"+m+"' "+tooth_selected+">"+map_val_dec+"</option>");
												//out.println("<option value='"+m+"'>map_val_dec+"</option>");
											}
										}
									
            _bw.write(_wl_block29Bytes, _wl_block29);

									if(record_gingival_status.equals("Y")){								
								
            _bw.write(_wl_block26Bytes, _wl_block26);

									}
								
            _bw.write(_wl_block38Bytes, _wl_block38);
 
								if(from_mixed_dentition.equals("D") || dflt_mixed_dentition_chart.equals("D") || dflt_mixed_dentition_chart_hid.equals("D")){
							
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

								
							}else if(from_mixed_dentition.equals("P") || dflt_mixed_dentition_chart.equals("P") || dflt_mixed_dentition_chart.equals("")){
							
							
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(md_gs_no_of_tooth_for_S1));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(md_gs_no_of_tooth_for_S1));
            _bw.write(_wl_block18Bytes, _wl_block18);

								if(record_gingival_status.equals("Y")){								
							
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
							
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(md_gs_dflt_tooth_no_S1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(md_gs_dflt_tooth_no_S1_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
								if(from_mixed_dentition.equals("P")){
										for(int i=2;i<=5;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("1")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
											}
										}
								}else if(from_mixed_dentition.equals("D")){
									for(int s=2;s<=3;s++){
											q=""+s;
											if(map_md.isEmpty() == false){
												map_val_md= map_md.get(q).toString();
												out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
											}							
									}
									for(int s=33;s<=34;s++){
											q=""+s;
											if(map_md.isEmpty() == false){
												map_val_md= map_md.get(q).toString();
												out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
										}							
									}			
								
								}
									
            _bw.write(_wl_block25Bytes, _wl_block25);

									if(record_gingival_status.equals("Y")){
								
            _bw.write(_wl_block47Bytes, _wl_block47);

									}
								
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(md_gs_no_of_tooth_for_S2));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(md_gs_no_of_tooth_for_S2));
            _bw.write(_wl_block18Bytes, _wl_block18);

								if(record_gingival_status.equals("Y")){								
							
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
							
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(md_gs_dflt_tooth_no_S2));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(md_gs_dflt_tooth_no_S2_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
									if(from_mixed_dentition.equals("P")){
											for(int i=6;i<=11;i++){
												j=""+i;
												if(map.isEmpty() == false){
													map_value = map.get(j).toString();
													map_value_arr=map_value.split("#");
													if(map_value_arr[1].equals("2")){
														map_val = map_value_arr[0];
														out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
													}
												}
											}
									}else if(from_mixed_dentition.equals("D")){
									for(int s=35;s<=40;s++){
											q=""+s;
											if(map_md.isEmpty() == false){
												map_val_md= map_md.get(q).toString();
												out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
											}							
									}
								
								}
									
            _bw.write(_wl_block29Bytes, _wl_block29);

									if(record_gingival_status.equals("Y")){
								
            _bw.write(_wl_block47Bytes, _wl_block47);

									}
								
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(md_gs_no_of_tooth_for_S3));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(md_gs_no_of_tooth_for_S3));
            _bw.write(_wl_block18Bytes, _wl_block18);

									if(record_gingival_status.equals("Y")){								
							
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
							
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(md_gs_dflt_tooth_no_S3));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(md_gs_dflt_tooth_no_S3_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
									if(from_mixed_dentition.equals("P")){
										for(int i=12;i<=15;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("3")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
											}
										}
									}else if(from_mixed_dentition.equals("D")){
									for(int s=41;s<=42;s++){
											q=""+s;
											if(map_md.isEmpty() == false){
												map_val_md= map_md.get(q).toString();
												out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
											}							
									}
									for(int s=14;s<=15;s++){
											q=""+s;
											if(map_md.isEmpty() == false){
												map_val_md= map_md.get(q).toString();
												out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
										}							
									}	
								
								}
									
            _bw.write(_wl_block29Bytes, _wl_block29);

									if(record_gingival_status.equals("Y")){
								
            _bw.write(_wl_block47Bytes, _wl_block47);

									}
								
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(md_gs_no_of_tooth_for_S4));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(md_gs_no_of_tooth_for_S4));
            _bw.write(_wl_block18Bytes, _wl_block18);

								if(record_gingival_status.equals("Y")){								
							
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
							
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(md_gs_dflt_tooth_no_S4));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(md_gs_dflt_tooth_no_S4_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
									if(from_mixed_dentition.equals("P")){
										for(int i=18;i<=21;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("4")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
											}
										}
									}
									else if(from_mixed_dentition.equals("D")){
										for(int s=18;s<=19;s++){
												q=""+s;
												if(map_md.isEmpty() == false){
													map_val_md= map_md.get(q).toString();
													out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
												}							
										}
										for(int s=43;s<=44;s++){
											q=""+s;
											if(map_md.isEmpty() == false){
												map_val_md= map_md.get(q).toString();
												out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
											}							
										}
									}

									
            _bw.write(_wl_block29Bytes, _wl_block29);

									if(record_gingival_status.equals("Y")){
								
            _bw.write(_wl_block47Bytes, _wl_block47);

									}
								
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(md_gs_no_of_tooth_for_S5));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(md_gs_no_of_tooth_for_S5));
            _bw.write(_wl_block18Bytes, _wl_block18);

								if(record_gingival_status.equals("Y")){								
							
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
							
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(md_gs_dflt_tooth_no_S5));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(md_gs_dflt_tooth_no_S5_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
									if(from_mixed_dentition.equals("P")){
										for(int i=22;i<=27;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("5")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
											}
										}
									}else if(from_mixed_dentition.equals("D")){
										for(int s=45;s<=50;s++){
												q=""+s;
												if(map_md.isEmpty() == false){
													map_val_md= map_md.get(q).toString();
													out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
												}							
										}
									}
									
            _bw.write(_wl_block29Bytes, _wl_block29);

									//if(record_gingival_status.equals("Y")){
								
            _bw.write(_wl_block47Bytes, _wl_block47);

								//	}
								
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(md_gs_no_of_tooth_for_S6));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(md_gs_no_of_tooth_for_S6));
            _bw.write(_wl_block18Bytes, _wl_block18);

								if(record_gingival_status.equals("Y")){								
							
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
							
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(md_gs_dflt_tooth_no_S6));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(md_gs_dflt_tooth_no_S6_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
										if(from_mixed_dentition.equals("P")){
											for(int i=28;i<=31;i++){
												j=""+i;
												if(map.isEmpty() == false){
													map_value = map.get(j).toString();
													map_value_arr=map_value.split("#");
													if(map_value_arr[1].equals("6")){
														map_val = map_value_arr[0];
														out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
													}
												}
											}
										}else if(from_mixed_dentition.equals("D")){
											for(int s=51;s<=52;s++){
													q=""+s;
													if(map_md.isEmpty() == false){
														map_val_md= map_md.get(q).toString();
														out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
													}							
											}
											for(int s=30;s<=31;s++){
												q=""+s;
												if(map_md.isEmpty() == false){
													map_val_md= map_md.get(q).toString();
													out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
												}							
											}
									    }
									
            _bw.write(_wl_block29Bytes, _wl_block29);

									if(record_gingival_status.equals("Y")){
								
            _bw.write(_wl_block47Bytes, _wl_block47);

									}
								
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(gs_no_of_tooth_for_S1));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(gs_no_of_tooth_for_S1));
            _bw.write(_wl_block18Bytes, _wl_block18);

								if(record_gingival_status.equals("Y")){								
							
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
							
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(gs_dflt_tooth_no_S1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(gs_dflt_tooth_no_S1_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
										for(int i=1;i<=32;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("1")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
											}
										}
									
            _bw.write(_wl_block25Bytes, _wl_block25);

									if(record_gingival_status.equals("Y")){								
								
            _bw.write(_wl_block26Bytes, _wl_block26);

									}
								
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(gs_no_of_tooth_for_S2));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(gs_no_of_tooth_for_S2));
            _bw.write(_wl_block18Bytes, _wl_block18);

								if(record_gingival_status.equals("Y")){								
							
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
							
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(gs_dflt_tooth_no_S2));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(gs_dflt_tooth_no_S2_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
										for(int i=1;i<=32;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("2")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
											}
										}
									
            _bw.write(_wl_block29Bytes, _wl_block29);

									if(record_gingival_status.equals("Y")){								
								
            _bw.write(_wl_block26Bytes, _wl_block26);

									}
								
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(gs_no_of_tooth_for_S3));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(gs_no_of_tooth_for_S3));
            _bw.write(_wl_block18Bytes, _wl_block18);

								if(record_gingival_status.equals("Y")){								
							
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
							
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(gs_dflt_tooth_no_S3));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(gs_dflt_tooth_no_S3_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
										for(int i=1;i<=32;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("3")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
											}
										}
									
            _bw.write(_wl_block29Bytes, _wl_block29);

									if(record_gingival_status.equals("Y")){								
								
            _bw.write(_wl_block26Bytes, _wl_block26);

									}
								
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(gs_no_of_tooth_for_S4));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(gs_no_of_tooth_for_S4));
            _bw.write(_wl_block18Bytes, _wl_block18);

									if(record_gingival_status.equals("Y")){								
							
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
							
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(gs_dflt_tooth_no_S4));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(gs_dflt_tooth_no_S4_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
										for(int i=1;i<=32;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("4")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
											}
										}
									
            _bw.write(_wl_block29Bytes, _wl_block29);

									if(record_gingival_status.equals("Y")){								
								
            _bw.write(_wl_block26Bytes, _wl_block26);

									}
								
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(gs_no_of_tooth_for_S5));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(gs_no_of_tooth_for_S5));
            _bw.write(_wl_block18Bytes, _wl_block18);

									if(record_gingival_status.equals("Y")){								
							
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
							
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(gs_dflt_tooth_no_S5));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(gs_dflt_tooth_no_S5_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
										for(int i=1;i<=32;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("5")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
											}
										}
									
            _bw.write(_wl_block29Bytes, _wl_block29);

									if(record_gingival_status.equals("Y")){								
								
            _bw.write(_wl_block26Bytes, _wl_block26);

									}
								
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(gs_no_of_tooth_for_S6));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(gs_no_of_tooth_for_S6));
            _bw.write(_wl_block18Bytes, _wl_block18);

									if(record_gingival_status.equals("Y")){								
							
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
							
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(gs_dflt_tooth_no_S6));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(gs_dflt_tooth_no_S6_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
										for(int i=1;i<=32;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("6")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
											}
										}
									
            _bw.write(_wl_block29Bytes, _wl_block29);

									if(record_gingival_status.equals("Y")){								
								
            _bw.write(_wl_block26Bytes, _wl_block26);

									}
								
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(checked_yn));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(chart_level));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(record_gingival_status_yn));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(dflt_mixed_dentition_chart));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(from_mixed_dentition));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(gs_dflt_tooth_no_S1));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(gs_dflt_tooth_no_S2));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(gs_dflt_tooth_no_S3));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(gs_dflt_tooth_no_S4));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(gs_dflt_tooth_no_S5));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(gs_dflt_tooth_no_S6));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(gs_no_of_tooth_for_S1));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(gs_no_of_tooth_for_S2));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(gs_no_of_tooth_for_S3));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(gs_no_of_tooth_for_S4));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(gs_no_of_tooth_for_S5));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(gs_no_of_tooth_for_S6));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(dec_gs_no_of_tooth_for_S1));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(dec_gs_no_of_tooth_for_S2));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(dec_gs_no_of_tooth_for_S3));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(dec_gs_no_of_tooth_for_S4));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(dec_gs_no_of_tooth_for_S5));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(dec_gs_no_of_tooth_for_S6));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(md_gs_no_of_tooth_for_S1));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(md_gs_no_of_tooth_for_S2));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(md_gs_no_of_tooth_for_S3));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(md_gs_no_of_tooth_for_S4));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(md_gs_no_of_tooth_for_S5));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(md_gs_no_of_tooth_for_S6));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(md_gs_dflt_tooth_no_S1));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(md_gs_dflt_tooth_no_S2));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(md_gs_dflt_tooth_no_S3));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(md_gs_dflt_tooth_no_S4));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(md_gs_dflt_tooth_no_S5));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(md_gs_dflt_tooth_no_S6));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(record_gingival_status_yn));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(record_gingival_status_yn));
            _bw.write(_wl_block113Bytes, _wl_block113);

	}
	catch(Exception e){
		e.printStackTrace() ;
	}
	finally{
		try{
			
			if(rs!=null)rs.close();
			if(pstmt!=null) pstmt.close();
			ConnectionManager.returnConnection(con);
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Sextant.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.UpperRight.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.UpperAnterior.Label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.UpperLeft.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.LowerLeft.Label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.LowerAnterior.Label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.LowerRight.Label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Decedious.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.MaxNumOfTooth.Label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultToothNo.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DeciduousMD.Label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.PermanentMD.Label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.MaxNumOfTooth.Label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultToothNo.Label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Permanent.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.MaxNumOfTooth.Label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultToothNo.Label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }
}
