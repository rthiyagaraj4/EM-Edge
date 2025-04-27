package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;

public final class __porteragedetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/PorterageDetails.jsp", 1709117839694L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n<head>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n</head>\n<script>\n\n// By Annadurai 3/5/2004 starts.,\nfunction assignValue()\n{\n\tif (document.forms[0].port_received_yn.checked == true)\n\t\tdocument.forms[0].port_received_yn.value\t= \"Y\";\n\telse document.forms[0].port_received_yn.value\t= \"N\";\n}\n// By Annadurai 3/5/2004 ends.,\nfunction selfClose()\n{\n\tself.close();\n\treturn 1;\n}\nfunction close_me()\n{\n\t\n\tvar port_vals = \"\";\n\tport_vals = \n\t\t\t\t\n\t(document.forms[0].Mode_of_Tran_desc.value.length == 0 ? \" \" : document.forms[0].Mode_of_Tran_desc.value) + \"^^\" + \n\t(document.forms[0].acc_per1_desc.value.length == 0? \" \" : document.forms[0].acc_per1_desc.value )+ \"^^\" +\n\t(document.forms[0].acc_per2_desc.value.length == 0? \" \" :\t\t\t\n\tdocument.forms[0].acc_per2_desc.value) + \"^^\" +\n\t(document.forms[0].acc_per3_desc.value.length == 0 ? \" \" :\n\tdocument.forms[0].acc_per3_desc.value) + \"^^\" +\n\t(document.forms[0].acc_per4_desc.value.length == 0 ? \" \" :\n\tdocument.forms[0].acc_per4_desc.value) + \"^^\" +\n\t(document.forms[0].acc_per5_desc.value.length == 0 ? \" \" :\n\tdocument.forms[0].acc_per5_desc.value) + \"^^\" +\n\t(document.forms[0].acc_per6_desc.value.length == 0 ? \" \" :\t\n\tdocument.forms[0].acc_per6_desc.value) + \"^^\" +\n\t(document.forms[0].acc_per7_desc.value.length == 0 ? \" \" :\t\t\t\n\tdocument.forms[0].acc_per7_desc.value) + \"^^\" +\n\n\t(document.forms[0].equip1_desc.value.length == 0 ? \" \" :\n\tdocument.forms[0].equip1_desc.value) + \"^^\" +\n\t(document.forms[0].equip2_desc.value.length == 0 ? \" \" :\t\t\t\n\tdocument.forms[0].equip2_desc.value) + \"^^\" +\n\t(document.forms[0].equip3_desc.value.length == 0 ? \" \" :\n\tdocument.forms[0].equip3_desc.value) + \"^^\" +\n\t(document.forms[0].equip4_desc.value.length == 0 ? \" \" :\n\tdocument.forms[0].equip4_desc.value) + \"^^\" +\n\t(document.forms[0].equip5_desc.value.length == 0 ? \" \" :\n\tdocument.forms[0].equip5_desc.value) + \"^^\" +\n\t(document.forms[0].equip6_desc.value.length == 0 ? \" \" :\t\t\t\n\tdocument.forms[0].equip6_desc.value) + \"^^\" +\n\t(document.forms[0].equip7_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[0].equip7_desc.value) + \"^^\" +\n\t\t\t\t\n\t(document.forms[0].bld_med1_desc.value.length == 0 ? \" \" : \n\tdocument.forms[0].bld_med1_desc.value) + \"^^\" +\n\t(document.forms[0].bld_med2_desc.value.length == 0 ? \" \" :  \t\t\t\n\tdocument.forms[0].bld_med2_desc.value) + \"^^\" +\n\t(document.forms[0].bld_med3_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[0].bld_med3_desc.value) + \"^^\" +\n\t(document.forms[0].bld_med4_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[0].bld_med4_desc.value) + \"^^\" +\n\t(document.forms[0].bld_med5_desc.value.length == 0 ? \" \" :  \t\t\t\n\tdocument.forms[0].bld_med5_desc.value) + \"^^\" +\n\t(document.forms[0].bld_med6_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[0].bld_med6_desc.value) + \"^^\" +\n\t(document.forms[0].bld_med7_desc.value.length == 0 ? \" \" :  \t\t\t\n\tdocument.forms[0].bld_med7_desc.value) + \"^^\" +\n\t(document.forms[0].bld_med8_desc.value.length == 0 ? \" \" :  \t\t\t\n\tdocument.forms[0].bld_med8_desc.value) + \"^^\" +\n\t(document.forms[0].bld_med9_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[0].bld_med9_desc.value) + \"^^\" +\n\t(document.forms[0].bld_med10_desc.value.length == 0 ? \" \" :  \t\t\t\n\tdocument.forms[0].bld_med10_desc.value) + \"^^\" +\n\t\t\t\t\n\t(document.forms[0].rec_doc1_desc.value.length == 0 ? \" \" :\n\tdocument.forms[0].rec_doc1_desc.value) + \"^^\" +\n\t(document.forms[0].rec_doc2_desc.value.length == 0 ? \" \" : \n\tdocument.forms[0].rec_doc2_desc.value) + \"^^\" +\n\t(document.forms[0].rec_doc3_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[0].rec_doc3_desc.value) + \"^^\" +\n\t(document.forms[0].rec_doc4_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[0].rec_doc4_desc.value) + \"^^\" +\n\t(document.forms[0].rec_doc5_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[0].rec_doc5_desc.value) + \"^^\" +\n\t\t\t\t\n\t(document.forms[0].pat_bel1_desc.value.length == 0 ? \" \" :\n\tdocument.forms[0].pat_bel1_desc.value) + \"^^\" +\n\t(document.forms[0].pat_bel2_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[0].pat_bel2_desc.value) + \"^^\" +\n\t(document.forms[0].pat_bel3_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[0].pat_bel3_desc.value) + \"^^\" +\n\t(document.forms[0].pat_bel4_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[0].pat_bel4_desc.value) + \"^^\" +\n\t(document.forms[0].pat_bel5_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[0].pat_bel5_desc.value) + \"^^\" +\n\t(document.forms[0].pat_bel6_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[0].pat_bel6_desc.value) + \"^^\" +\n\t(document.forms[0].pat_bel7_desc.value.length == 0 ? \" \" : \t\t\t\n\tdocument.forms[0].pat_bel7_desc.value) + \"^^\" +\n\t(document.forms[0].pat_bel8_desc.value.length == 0 ? \" \" :\n\tdocument.forms[0].pat_bel8_desc.value) + \"^^\" +\n\t(document.forms[0].pat_bel9_desc.value.length == 0 ? \" \" :\n\tdocument.forms[0].pat_bel9_desc.value) + \"^^\" +\n\t(document.forms[0].pat_bel10_desc.value.length == 0 ? \" \" :\n\tdocument.forms[0].pat_bel10_desc.value)+ \"^^\" ;\n\t// By Annadurai 3/5/2004 starts.,\n\tif (document.forms[0].jsp_name_val.value == \"PatientIn\")\n\t{\t\n\t\tport_vals = port_vals +\n\t\t(document.forms[0].port_received_yn.value.length == 0 ? \" \" :document.forms[0].port_received_yn.value)+ \"^^\" +\n\t\t(document.forms[0].received.value.length == 0 ? \" \" :\n\t\tdocument.forms[0].received.value)+ \"^^\" +\n\t\t(document.forms[0].port_remarks.value.length == 0 ? \" \" :\n\t\tdocument.forms[0].port_remarks.value);\n\t}\n\t// By Annadurai 3/5/2004 ends.,\n\n\twindow.close();\t\n\twindow.returnValue =port_vals;\n}\nfunction populateDetails()\n{\n\tvar port_vals=parent.window.dialogArguments;\n\tif(port_vals == null || port_vals ==\'null\')\n\t{\n\t\tport_vals=\'\';\n\t}\n\n\tvar arr_port_vals=port_vals.split(\"^^\");\n\tif(arr_port_vals[0])\n\t\tdocument.forms[0].Mode_of_Tran_desc.value\t\t= arr_port_vals[0];\n\t\n\tif(arr_port_vals[1])\n\t\tdocument.forms[0].acc_per1_desc.value\t\t= arr_port_vals[1];\n\tif(arr_port_vals[2])\n\t\tdocument.forms[0].acc_per2_desc.value\t\t= arr_port_vals[2];\n\tif(arr_port_vals[3])\n\t\tdocument.forms[0].acc_per3_desc.value\t\t= arr_port_vals[3];\n\tif(arr_port_vals[4])\n\t\tdocument.forms[0].acc_per4_desc.value\t\t= arr_port_vals[4];\n\tif(arr_port_vals[5])\n\t\tdocument.forms[0].acc_per5_desc.value\t\t= arr_port_vals[5];\n\tif(arr_port_vals[6])\n\t\tdocument.forms[0].acc_per6_desc.value\t\t= arr_port_vals[6];\n\tif(arr_port_vals[7])\n\t\tdocument.forms[0].acc_per7_desc.value\t\t= arr_port_vals[7];\n\t\n\tif(arr_port_vals[8])\n\t\tdocument.forms[0].equip1_desc.value\t\t= arr_port_vals[8];\n\tif(arr_port_vals[9])\n\t\tdocument.forms[0].equip2_desc.value\t\t= arr_port_vals[9];\n\tif(arr_port_vals[10])\n\t\tdocument.forms[0].equip3_desc.value\t\t= arr_port_vals[10];\n\tif(arr_port_vals[11])\n\t\tdocument.forms[0].equip4_desc.value\t\t= arr_port_vals[11];\n\tif(arr_port_vals[12])\n\t\tdocument.forms[0].equip5_desc.value\t\t= arr_port_vals[12];\n\tif(arr_port_vals[13])\n\t\tdocument.forms[0].equip6_desc.value\t\t= arr_port_vals[13];\n\tif(arr_port_vals[14])\n\t\tdocument.forms[0].equip7_desc.value\t\t= arr_port_vals[14];\n\n\tif(arr_port_vals[15])\n\t\tdocument.forms[0].bld_med1_desc.value\t\t= arr_port_vals[15];\n\tif(arr_port_vals[16])\n\t\tdocument.forms[0].bld_med2_desc.value\t\t= arr_port_vals[16];\n\tif(arr_port_vals[17])\n\t\tdocument.forms[0].bld_med3_desc.value\t\t= arr_port_vals[17];\n\tif(arr_port_vals[18])\n\t\tdocument.forms[0].bld_med4_desc.value\t\t= arr_port_vals[18];\n\tif(arr_port_vals[19])\n\t\tdocument.forms[0].bld_med5_desc.value\t\t= arr_port_vals[19];\n\tif(arr_port_vals[20])\n\t\tdocument.forms[0].bld_med6_desc.value\t\t= arr_port_vals[20];\n\tif(arr_port_vals[21])\n\t\tdocument.forms[0].bld_med7_desc.value\t\t= arr_port_vals[21];\n\tif(arr_port_vals[22])\n\t\tdocument.forms[0].bld_med8_desc.value\t\t= arr_port_vals[22];\n\tif(arr_port_vals[23])\n\t\tdocument.forms[0].bld_med9_desc.value\t\t= arr_port_vals[23];\n\tif(arr_port_vals[24])\n\t\tdocument.forms[0].bld_med10_desc.value\t\t= arr_port_vals[24];\n\n\n\tif(arr_port_vals[25])\n\t\tdocument.forms[0].rec_doc1_desc.value\t\t= arr_port_vals[25];\n\tif(arr_port_vals[26])\n\t\tdocument.forms[0].rec_doc2_desc.value\t\t= arr_port_vals[26];\n\tif(arr_port_vals[27])\n\t\tdocument.forms[0].rec_doc3_desc.value\t\t= arr_port_vals[27];\n\tif(arr_port_vals[28])\n\t\tdocument.forms[0].rec_doc4_desc.value\t\t= arr_port_vals[28];\n\tif(arr_port_vals[29])\n\t\tdocument.forms[0].rec_doc5_desc.value\t\t= arr_port_vals[29];\n\n\tif(arr_port_vals[30])\n\t\tdocument.forms[0].pat_bel1_desc.value\t\t= arr_port_vals[30];\n\tif(arr_port_vals[31])\n\t\tdocument.forms[0].pat_bel2_desc.value\t\t= arr_port_vals[31];\n\tif(arr_port_vals[32])\n\t\tdocument.forms[0].pat_bel3_desc.value\t\t= arr_port_vals[32];\n\tif(arr_port_vals[33])\n\t\tdocument.forms[0].pat_bel4_desc.value\t\t= arr_port_vals[33];\n\tif(arr_port_vals[34])\n\t\tdocument.forms[0].pat_bel5_desc.value\t\t= arr_port_vals[34];\n\tif(arr_port_vals[35])\n\t\tdocument.forms[0].pat_bel6_desc.value\t\t= arr_port_vals[35];\n\tif(arr_port_vals[36])\n\t\tdocument.forms[0].pat_bel7_desc.value\t\t= arr_port_vals[36];\n\tif(arr_port_vals[37])\n\t\tdocument.forms[0].pat_bel8_desc.value\t\t= arr_port_vals[37];\n\tif(arr_port_vals[38])\n\t\tdocument.forms[0].pat_bel9_desc.value\t\t= arr_port_vals[38];\n\tif(arr_port_vals[39])\n\t\tdocument.forms[0].pat_bel10_desc.value\t\t= arr_port_vals[39];\n\t// By Annadurai 3/5/2004 start.,\n\tif (document.forms[0].jsp_name_val.value == \"PatientIn\")\n\t{\n\t\tif(arr_port_vals[40]) \n\t\t{\n\t\t\tdocument.forms[0].port_received_yn.value\t= arr_port_vals[40];\n\t\t\tif (arr_port_vals[40] == \"Y\")\n\t\t\t\tdocument.forms[0].port_received_yn.checked = true;\n\t\t\telse\n\t\t\t\tdocument.forms[0].port_received_yn.checked = false;\n\t\t}\n\t\tif(arr_port_vals[41]) \n\t\t\tdocument.forms[0].received.value\t\t\t= arr_port_vals[41];\n\t\tif(arr_port_vals[42]) \n\t\t\tdocument.forms[0].port_remarks.value\t\t= arr_port_vals[42];\n\t}\n\t// By Annadurai 3/5/2004 end.,\n}\n</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body onLoad=\"populateDetails();\" onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n<form name=\"Porterage_form\" id=\"Porterage_form\"  method=\"post\"action=\'\' target=\'messageFrame\'> \n<table border=0 width=\"100%\" cellpadding=0 cellspacing=0>\n\t<tr>\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t<td colspan=3 align=left>&nbsp;<input type=text name=\'Mode_of_Tran_desc\' id=\'Mode_of_Tran_desc\'  maxlength=30 size=30  value=\"\"></td>\n\t\t</tr>\t\t\n\t\t<tr ><td colspan=\"4\" class=\"label\" >&nbsp;</td></tr>\n\t\t<tr>\t\t\t\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td colspan=3 >&nbsp;<input type=text name=\'acc_per1_desc\' id=\'acc_per1_desc\'  maxlength=30 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'acc_per2_desc\' id=\'acc_per2_desc\'  maxlength=30 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'acc_per3_desc\' id=\'acc_per3_desc\'  maxlength=30 size=30 width=\"15\" value=\"\"></td>\t\t\t\n\t\t</tr>\n\t\t<tr>\t\t\t\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >&nbsp;</td>\n\t\t\t<td colspan=3 >&nbsp;<input type=text name=\'acc_per4_desc\' id=\'acc_per4_desc\'  maxlength=30 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'acc_per5_desc\' id=\'acc_per5_desc\'  maxlength=30 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'acc_per6_desc\' id=\'acc_per6_desc\'  maxlength=30 size=30 width=\"15\" value=\"\"></td>\t\t\t\n\t\t</tr>\n\t\t<tr>\t\t\t\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >&nbsp;</td>\n\t\t\t<td colspan=3 >&nbsp;<input type=text name=\'acc_per7_desc\' id=\'acc_per7_desc\'  maxlength=30 size=30 width=\"15\" value=\"\"></td>\t\t\t\n\t\t</tr>\n\t\t<tr><td colspan=\"4\" class=\"label\">&nbsp;</td></tr>\n\t\t<tr>\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t<td colspan=3 >&nbsp;<input type=text name=\'equip1_desc\' id=\'equip1_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'equip2_desc\' id=\'equip2_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'equip3_desc\' id=\'equip3_desc\'  maxlength=40 size=30 width=\"15\" value=\"\"></td>\t\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >&nbsp;</td>\n\t\t\t<td colspan=3 >&nbsp;<input type=text name=\'equip4_desc\' id=\'equip4_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'equip5_desc\' id=\'equip5_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'equip6_desc\' id=\'equip6_desc\'  maxlength=40 size=30 width=\"15\" value=\"\"></td>\t\t\t\n\t\t</tr>\n\t\t<tr>\t\t\t\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >&nbsp;</td>\n\t\t\t<td colspan=3 >&nbsp;<input type=text name=\'equip7_desc\' id=\'equip7_desc\'  maxlength=40 size=30 width=\"15\" value=\"\"></td>\t\t\t\n\t\t</tr>\n\t\t<tr><td colspan=\"4\" class=\"label\" >&nbsp;</td></tr>\n\t\t<tr>\t\t\t\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t<td colspan=3 >&nbsp;<input type=text name=\'bld_med1_desc\' id=\'bld_med1_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'bld_med2_desc\' id=\'bld_med2_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'bld_med3_desc\' id=\'bld_med3_desc\'  maxlength=40 size=30 width=\"15\" value=\"\"></td>\n\t\t\t\n\t\t</tr>\n\t\t<tr>\t\t\t\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >&nbsp;</td>\n\t\t\t<td colspan=3 >&nbsp;<input type=text name=\'bld_med4_desc\' id=\'bld_med4_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'bld_med5_desc\' id=\'bld_med5_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'bld_med6_desc\' id=\'bld_med6_desc\'  maxlength=40 size=30 width=\"15\" value=\"\"></td>\t\t\t\n\t\t</tr>\n\t\t<tr>\t\t\t\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >&nbsp;</td>\n\t\t\t<td colspan=3 >&nbsp;<input type=text name=\'bld_med7_desc\' id=\'bld_med7_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'bld_med8_desc\' id=\'bld_med8_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'bld_med9_desc\' id=\'bld_med9_desc\'  maxlength=40 size=30 width=\"15\" value=\"\"></td>\t\t\t\n\t\t</tr>\n\t\t<tr>\t\t\t\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >&nbsp;</td>\n\t\t\t<td colspan=3 >&nbsp;<input type=text name=\'bld_med10_desc\' id=\'bld_med10_desc\'  maxlength=40 size=30 width=\"15\" value=\"\"></td>\t\t\t\n\t\t</tr>\n\t\t<tr><td colspan=\"4\" class=\"label\">&nbsp;</td></tr>\n\t\t<tr>\t\t\t\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t<td colspan=3 >&nbsp;<input type=text name=\'rec_doc1_desc\' id=\'rec_doc1_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'rec_doc2_desc\' id=\'rec_doc2_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'rec_doc3_desc\' id=\'rec_doc3_desc\'  maxlength=40 size=30 width=\"15\" value=\"\"></td>\n\t\t\t\n\t\t</tr>\n\t\t<tr>\t\t\t\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >&nbsp;</td>\n\t\t\t<td colspan=3 >&nbsp;<input type=text name=\'rec_doc4_desc\' id=\'rec_doc4_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'rec_doc5_desc\' id=\'rec_doc5_desc\'  maxlength=40 size=30 width=\"15\" value=\"\"></td>\t\t\t\n\t\t</tr>\n\t\t<tr><td colspan=\"4\" class=\"label\">&nbsp;</td></tr>\n\t\t<tr>\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t<td colspan=3 >&nbsp;<input type=text name=\'pat_bel1_desc\' id=\'pat_bel1_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'pat_bel2_desc\' id=\'pat_bel2_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'pat_bel3_desc\' id=\'pat_bel3_desc\'  maxlength=40 size=30 width=\"15\" value=\"\"></td>\t\t\t\n\t\t</tr>\n\t\t<tr>\t\t\t\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >&nbsp;</td>\n\t\t\t<td colspan=3 >&nbsp;<input type=text name=\'pat_bel4_desc\' id=\'pat_bel4_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'pat_bel5_desc\' id=\'pat_bel5_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'pat_bel6_desc\' id=\'pat_bel6_desc\'  maxlength=40 size=30 width=\"15\" value=\"\"></td>\t\t\t\n\t\t</tr>\n\t\t<tr>\t\t\t\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >&nbsp;</td>\n\t\t\t<td colspan=3 >&nbsp;<input type=text name=\'pat_bel7_desc\' id=\'pat_bel7_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'pat_bel8_desc\' id=\'pat_bel8_desc\'  maxlength=40 size=30 width=\"15\" value=\"\">&nbsp;<input type=text name=\'pat_bel9_desc\' id=\'pat_bel9_desc\'  maxlength=40 size=30 width=\"15\" value=\"\"></td>\t\t\t\n\t\t</tr>\n\t\t<tr>\t\t\t\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >&nbsp;</td>\n\t\t\t<td colspan=3 >&nbsp;<input type=text name=\'pat_bel10_desc\' id=\'pat_bel10_desc\'  maxlength=40 size=30 width=\"15\" value=\"\"></td>\t\t\t\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<tr><td colspan=\"4\" class=\"label\">&nbsp;</td></tr>\n\t\t<tr>\t\t\t\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&nbsp;</td>\n\t\t\t<td><input type=\"checkbox\" name=\'port_received_yn\' id=\'port_received_yn\' value=\"N\" onClick = \"assignValue();\"></td>\t<td  align=\"right\" nowrap class=\"label\" >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;</td>\n\t\t\t<td>\n\t\t\t\t<select name=\"received\" id=\"received\">\n\t\t\t\t\t<option value=\"\">&nbsp;&nbsp;--- ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="---&nbsp;&nbsp;</option>\n\t\t\t\t\t<option value=\"F\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</option>\n\t\t\t\t\t<option value=\"P\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</option>\n\t\t\t\t</select>\n\t\t\t</td>\t\t\t\n\t\t</tr>\t\t\n\t\t<tr><td colspan=\"4\" class=\"label\">&nbsp;</td></tr>\n\t\t<tr>\t\t\t\n\t\t\t<td  align=\"right\" nowrap class=\"label\" >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;</td>\n\t\t\t<td colspan=\"3\">&nbsp;<input type=\"text\" name=\'port_remarks\' id=\'port_remarks\' maxlength=\"200\" size=\"100\"></td>\t\t\t\n\t\t</tr>\t\t\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<tr>\n\t\t<td >&nbsp;</td>\n\t\t<td colspan=3 align=right><input type=\"button\" class=\"button\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" onclick=\"close_me();\">&nbsp;</td>\t\t\n\t\t</tr>\n</table>\n<input type=\"hidden\" name=\"jsp_name_val\" id=\"jsp_name_val\" value =\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n</form>\n</html>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

   //   By Annadurai 3/5/2004 starts
   String jsp_name =  request.getParameter("jsp_name");
   jsp_name = (jsp_name==null) ? "" : jsp_name;
   //   By Annadurai 3/5/2004 ends

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

			// By Annadurai starts.
			if (jsp_name.equals("PatientIn"))
			{
		
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

			}
			// By Annadurai End.
		
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block25Bytes, _wl_block25);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PorterageDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ModeOfTransport.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AccompanyingPerson.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.equipment.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BloodandMedication.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RecordsDocuments.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PatientBelongings.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PorterageReceived.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReceivedPartiallyFully.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReceivedinFull.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReceivedPartially.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PorterageRemarks.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
