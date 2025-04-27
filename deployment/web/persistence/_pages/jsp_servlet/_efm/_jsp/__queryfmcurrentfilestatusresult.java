package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.text.*;
import java.sql.Date;
import eFM.*;
import java.util.*;
import com.ehis.util.*;

public final class __queryfmcurrentfilestatusresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/QueryFMCurrentFileStatusResult.jsp", 1734421610676L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n  <!-- Developed By\t   :-\tPrashant Bhalsingh\n\t Created on   \t   :\t21/06/2001\n\t Module Name \t   :\tFM\\File current storage location\n-->\n<!--modified for this CRF HSA-CRF-0306 -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eFM/js/QueryFMCurrentFileStatus.js\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/tableheaderscroll.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<!-- Supporting Js File For Fixed Header with scroll.... -->\n<script> \nwindow.onload=function(){ \n\t\t\tif(document.getElementById(\"dataTable\")!=null)\t{\t\t\n\t\t\t\tfxheaderInit(\'dataTable\',320);\n\t\t\t}\n}\n</script>\n<head>\n<BODY onMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey();\'>\n<form name=\"QueryFMSearchResult\" id=\"QueryFMSearchResult\" action=\"../../eFM/jsp/QueryFMCurrentFileStatusResult.jsp\" method=\"post\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\"98%\">\n\t<tr>\n\t\t<td colspan=\'4\'>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</td>\n\t</tr>\n</table>\n<br>\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\'center\' width=\"100%\" style=\"border:1x solid black\" id=\"dataTable\" >\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n\t\t<td class=\'columnheader\' width=\'30%\' style=\"background:#1E3F64\" >&nbsp;</td>\n\t\t<td class=\'columnheader\' width=\'35%\' style=\"background:#1E3F64\" >&nbsp;</td>\n\t\t<td class=\'columnheader\' width=\'35%\' style=\"background:#1E3F64\" > &nbsp;</td>\n\t\t<tr>\n\t\t<td class=\'columnheader\' width=\'30%\' style=\"background:#1E3F64\" >&nbsp;</td>\n\t\t<th class=\'columnheader\' width=\'35%\' style=\"background:#1E3F64\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t<th class=\'columnheader\' width=\'35%\' style=\"background:#1E3F64\" > ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t</tr>\n\t\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t   \t<td class=\'querydata\'><b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t   \t<td class=\'querydata\' ><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t</tr>\n\t\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t<td class=\'querydata\'><b>\n\t\t\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n           ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t   ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;/&nbsp;";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t</td>\n\t\t<td width=\"40%\" height=\"20\" class=\'label\'>&nbsp;</td>\n\t\t</tr>\n\t\t<!--Below line modified for this CRF HSA-CRF-0306 -->\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\n\t\t<!--Below line modified for this CRF HSA-CRF-0306 -->\n\t\t<tr>  \n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="<td >\n\t\t\t<TABLE border=\'0\' width=\'100%\'>\n\t\t\t      \n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</TD>\n\t\t\t\t\t\t<TD class=\'label\'  width=\'20%\' nowrap>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</TD>\n\t\t\t\t\t\t<TD class=\'label\'  width=\'35%\'>&nbsp;</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD   nowrap class=\'querydata\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</TD>\n\t\t\t\t\t\t<TD   nowrap class=\'querydata\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</TD>\n\t\t\t\t\t\t<TD  >&nbsp;</TD>\n\t\t\t\t\t</TR>\n\t\t\t</TABLE>\n\t\t\t </td>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t <td ><TABLE border=\'0\' width=\'100%\' >\t\t\t \n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</TD>\n\t\t\t\t\t\t<TD class=\'label\'  width=\'35%\'>&nbsp;</TD>\n\t\t\t\t\t</TR>\t\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD  nowrap class=\'querydata\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</TD>\n\t\t\t\t\t\t<TD  nowrap class=\'querydata\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</TD>\n\t\t\t\t\t\t<TD >&nbsp;</TD>\n\t\t\t\t\t</TR>\n\t\t\t</TABLE>\n\t\t\t </td>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t  <td ><TABLE border=\'0\' width=\'100%\'>\n\t\t\t         <TR>\t\t\t\t\t\t\n\t\t\t\t\t\t<TD width=\'25%\' class=\'label\' nowrap >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</TD>\n\t\t\t\t\t\t<TD width=\'20%\' class=\'label\' nowrap >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</TD>\n\t\t\t\t\t\t<TD width=\'20%\'>&nbsp;</TD>\n\t\t\t\t\t\t<TD width=\'35%\'>&nbsp;</TD>\n\t\t\t\t\t\t\n\t\t\t\t\t</TR>\t\n\t\t\t\t\t<TR>\t\t\t\t\t\t\n\t\t\t\t\t\t<TD nowrap class=\'querydata\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</TD>\n\t\t\t\t\t\t<TD nowrap class=\'querydata\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</TD>\n\t\t\t\t\t\t<TD nowrap>&nbsp;</TD>\n\t\t\t\t\t\t<TD nowrap>&nbsp;</TD>\n\t\t\t\t\t\t\n\t\t\t\t\t</TR></TABLE>\n\t\t\t </td>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t  <td ><TABLE border=\'0\' width=\'100%\'>\n\t\t\t         <TR>\t\t\t\t\t\t\n\t\t\t\t\t\t<TD  width=\'25%\' class=\'label\' nowrap>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</TD>\n\t\t\t\t\t\t<TD  width=\'20%\' class=\'label\' nowrap>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</TD>\n\t\t\t\t\t\t<TD width=\'35%\' class=\'label\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</TD>\n\t\t\t\t\t\t<TD width=\'20%\' class=\'label\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</TD>\n\t\t\t\t\t</TR>\t\n\t\t\t\t\t<TR>\t\t\t\t\t\t\n\t\t\t\t\t\t<TD nowrap class=\'querydata\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</TD>\n\t\t\t\t\t</TR></TABLE>\n\t\t\t </td>\t\t\t \n\t\t\t ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t \n\t\t\t <!--Added for this CRF HSA-CRF-0306 -->\n\t\t\t \n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\n\t\t\t\t<tr>\n\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\n\t\t<td class=\'querydata\'><B>\n\t\t\n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t    ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&nbsp;";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\n\t\t</td>\n\t\t<td class=\'label\'>&nbsp;</td>\n\t\t</tr>\n\t\t<!---Added for this CRF HSA-CRF-0306.1-->\n\t\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t<td class=\'querydata\'><b>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t</td>\t\t\n\t\t<td class=\'label\'></td>\n\t\t</tr>\n\t\n\t\t<tr><td class=\'columnheader\' width=\'100%\' style=\"background:#1E3F64\" colspan=3>&nbsp;</td></tr>\n\t\t\n\t  ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t<td  class=\'querydata\'><b>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\t\t\n\t\t<td  class=\'label\'></td>\n\t\t</tr>\n\t\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t<!--End for this CRF HSA-CRF-0306.1 -->\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="<!--Modified by Thamizh selvi on 22nd Aug 2017 against ML-MMOH-SCF-0716-->\n\t\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td><!--Modified issueddatetime to iss_date_time against ML-MMOH-SCF-0716-->\n\t\t<td class=\'label\'>&nbsp;</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" </td>\n\t\t<td  class=\'querydata\'><b>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t</td>\t\t\n\t\t<td  class=\'label\'></td>\n\t\t</tr>\t\t\n\t\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t</td>\t\t\n\t\t<td  class=\'label\'></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n\t\t<td class=\'querydata\'><B>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\t\t<td class=\'querydata\'><b>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\t\t\n\t\t<td  class=\'querydata\'><b>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t</tr>\t\n\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\t\t\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t      <a href=\'javascript:GetShowRemarks(\"ReqComm";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\",\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\",\"R\")\'>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</a>\n\t\t\t<input type=\'hidden\' name=\"ReqComm";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" id=\"ReqComm";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t</tr>\t\n\t\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t<!-- Below lines added by Venkatesh.s against ML-MMOH-CRF-0393 -->\n\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t <td class=\'querydata\'><a href=\'javascript:GetShowRemarks(\"ReqComm";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\",\"RQ\")\'> ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =" </a>\n          ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t<input type=\'hidden\' name=\'ReqComm";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' id=\'ReqComm";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t</td>\t \n           <!--end ML-MMOH-CRF-0393 -->\t\t\t\n\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" </a>\n\t\t   ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t </td>\n\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" </td>\t\n\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="<!--modified for HSA-CRF-0306.1 and HSA-SCF-0204 -->\t\n\t\t<td  class=\'label\'></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="<!--Added by Thamizh selvi on 22nd Aug 2017 against ML-MMOH-SCF-0716-->\n\t\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t<td  class=\'querydata\'><b>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\t\t\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t<td   class=\'querydata\'><b>";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t&nbsp-&nbsp";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t<td  class=\'label\'></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t<tr>\n\t\t   <td class=\'label\'>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\n\t\t   <td class=\'querydata\'><b><b>";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="&nbsp;<b>";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="&nbsp;&nbsp;&nbsp;</b></td>\t\t\n\t\t   <td class=\'label\'></td>\t\t\n\t\t</tr>\n\t\t\n\t\t<tr>\n\t\t<td class=\'label\'>&nbsp;</td>\n\t\t <td colspan=\"2\" class=\'fields\'>&nbsp;<input type=\'button\' class=\'button\' name=\'View\' id=\'View\' value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' onClick=\'ViewAppointment(\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" );\' style=\"border:1x solid black;\">\n\t\t\t<!--Added for this CRF HSA-CRF-0306-->\n\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t&nbsp;<input type=\'button\' class=\'button\' name=\'audit\' id=\'audit\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' onClick=\'ViewAuditTrail(\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\");\' style=\"border:1x solid black;\">\n\t\t\t&nbsp;<input type=\'button\' class=\'button\' name=\'filemovement\' id=\'filemovement\' value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' onClick=\'FileMovementHistory(\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\");\' style=\"border:1x solid black; width:150px;\" >\n\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t<tr><td  colspan=\"3\" height=\"5\" ></td></tr>\n\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\t\t\tparent.searchResultFrame.document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t</table>\n\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t<input type=\'hidden\' name=\'criteria\' id=\'criteria\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\n\t<input type=\'hidden\' name=\'facility\' id=\'facility\' value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\n\t<input type=\'hidden\' name=\'patientid\' id=\'patientid\' value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n\t<input type=\'hidden\' name=\'currStatDesc\' id=\'currStatDesc\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>\n\t<input type=\'hidden\' name=\'currIdDesc\' id=\'currIdDesc\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n\t<input type=\'hidden\' name=\'Curr_locn_desc\' id=\'Curr_locn_desc\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n\t<input type=\'hidden\' name=\'appointmentDays\' id=\'appointmentDays\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'>\n\t<input type=\'hidden\' name=\'bookingDays\' id=\'bookingDays\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	Properties p=(java.util.Properties) session.getValue("jdbc");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con				= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	ResultSet rset				= null;
	java.sql.Statement stmt1	= null;
	ResultSet rset1				= null;
	java.sql.Statement stmt2	= null;
	ResultSet rs				= null;
    java.sql.Statement stmt3	= null;
	ResultSet rs1				= null;
	
	String fcy_id = (String) session.getValue("facility_id");

	String iss_date_time = "";
	String return_date_time = "";
	String file_creation_date = "";
    String duration_type="";
	String return_criteria="";
	String no_of_dh_to_return_op="0";
	int parameter_hours=0;
	String curr_fs_locn_code="";
	String discharge_date_time="";
	String prev_facility_name="";
	String curr_filetrans="";
	String queryCriteria	= (request.getParameter("criteria")==null)?"":request.getParameter("criteria") ;
    String volume_no		= (request.getParameter("volume_no")==null)?"":request.getParameter("volume_no") ;
	String facility			= (request.getParameter("facility")==null)?"":request.getParameter("facility") ;
	String patientid		= (request.getParameter("patientid")==null)?"":request.getParameter("patientid") ;
	String currStatDesc		= (request.getParameter("currStatDesc")==null)?"":request.getParameter("currStatDesc") ;
	String currIdDesc		= (request.getParameter("currIdDesc")==null)?"":request.getParameter("currIdDesc") ;
	String Curr_locn_desc		= (request.getParameter("Curr_locn_desc")==null)?"":request.getParameter("Curr_locn_desc") ;
	String appointmentDays	=(request.getParameter("appointmentDays")==null)?"":request.getParameter("appointmentDays") ;
	String bookingDays		= (request.getParameter("bookingDays")==null)?"":request.getParameter("bookingDays") ;
	String sql	= "" ;
	
	StringBuffer SelectSqlBuffer	= null;
	SelectSqlBuffer					= new StringBuffer();
    String perm_fs_locn_code="";
	String file_status1="";
	//Below line added for this CRF HSA-CRF-0306
	String PatientClass="",NursingUnit="",Room="",Bed="",Specility="",Clinic="",Priorityzone="",Treatmentarea="",AssignCareType="",Assigncarecode="",returndate="",dischargedatetime="";
	String returndatetime="";//HSA-CRF-0306.1
	String fs_curr_locn_id=""; //HSA-CRF-0306.1
	int recorCount=0;
	boolean isCurrentFsLocation = false;//Added for this CRF HSA-CRF-0306
	String return_date_manual_yn="N"; //Added for this CRF HSA-CRF-0306.1
	
	String canceldischarge=""; //Added for this CRF HSA-CRF-0306.1
	String return_date=""; //Added for this CRF HSA-CRF-0306.1
	
	//Below line added for this CRF HSA-CRF-0306.1 and SCF HSA-SCF-0204
	String requestedby="",issuedby="",transferedby="",transfereddatetime="",movementtype="",narration="",transportdesc="",carriedby="",transfermode="",issueddatetime="",narration_desc="",reqname="",issued_by="", trfType="";//Modified by Thamizh selvi on 25th Aug 2017 for ML-MMOH-CRF-0716
	
	String curr_locn_dischage_datetime=""; //CRF HSA-CRF-0306.1
/* Below line(s) added by Venkatesh.s against ML-MMOH-CRF-0393 */
	String remarkforborrow="";
	String borrowing_reason="";
		
	try
	{
	   isCurrentFsLocation = CommonBean.isSiteSpecific(con,"FM","CURRENT_FS_LOCATION");//Added for this CRF HSA-CRF-0306
	
		String p_nursing_unit 	= "";
		String p_room_num		= "";
		String p_bed_num		= "";
        String pr_nursing_unit 	= "";
		String pr_room_num		= "";
		String pr_bed_num		= ""; 
		String curr_facility_id="";
		String dest_locn_identity="";
		int p_count		= 1;
		int count	    = 0;
		int appt_count  = 0;

		 stmt2 = con.createStatement();
	 
		 sql = "select count(1) from oa_appt where patient_id='"+patientid+"' and facility_id ='"+fcy_id+"' and trunc(appt_date)>=trunc(sysdate) and nvl(appt_status,1) != 'A'";
		 rs = stmt2.executeQuery(sql);
		 if(rs.next())
		 {
			 appt_count = rs.getInt(1);
		 }
		 if(rs != null)	rs.close();
	
		if(appt_count == 0)
		{
			sql="select count(1) from ip_booking_list where patient_id is not null and patient_id='"+patientid+"' and trunc(preferred_date)>=trunc(sysdate) and nvl(booking_status,1)=1";
			stmt2=con.createStatement();
			rs=stmt2.executeQuery(sql);
			 if (rs.next())
				 appt_count = rs.getInt(1);
		} if(rs!=null)	rs.close();	

		if(p_count == 1)
		{
			/*sql = "select c.long_desc NURSING_UNIT_SHORT_DESC,nvl(a.room_num,'&nbsp;')room_no,nvl(a.bed_num,'&nbsp;')bed_no from ip_open_encounter a, fm_curr_locn b, ip_nursing_unit c where a.facility_id=b.curr_facility_id and a.patient_id=b.patient_id and a.facility_id = c.facility_id and a.nursing_unit_code = c.nursing_unit_code and b.facility_id='"+facility+"' and b.file_no='"+queryCriteria+"' ";
			 
			rs = stmt2.executeQuery(sql);
			
			while(rs.next())
			{
				p_nursing_unit	=			(rs.getString("NURSING_UNIT_SHORT_DESC")==null)?"":rs.getString("NURSING_UNIT_SHORT_DESC");
				p_room_num	= (rs.getString("room_no")==null)?"":rs.getString("room_no");
				p_bed_num	= (rs.getString("bed_no")==null)?"":rs.getString("bed_no");

				++count ;
			} if(rs!=null)	rs.close();*/
			//if(stmt2!=null)	stmt2.close();
				
		/*String  sql1=" SELECT       ip_get_desc.Ip_nursing_unit(facility_id,fr_nursing_unit_code,'en','2')FR_NURSING_UNIT_desc,fr_room_no,fr_bed_no   FROM ip_adt_trn  WHERE srl_no = (SELECT MAX(srl_no)  FROM ip_adt_trn    WHERE patient_id    ='"+patientid+"')     AND patient_id = '"+patientid+"' " ;
             
	    rs = stmt2.executeQuery(sql1);
			
			while(rs.next())
			{
				pr_nursing_unit	=			(rs.getString("FR_NURSING_UNIT_desc")==null)?"":rs.getString("FR_NURSING_UNIT_desc");
				pr_room_num	= (rs.getString("fr_room_no")==null)?"":rs.getString("fr_room_no");
				pr_bed_num	= (rs.getString("fr_bed_no")==null)?"":rs.getString("fr_bed_no");

				//++count ;
			} if(rs!=null)	rs.close();*/
			//if(stmt2!=null)	stmt2.close();
			
			//Added for this CRF HSA-CRF-0306.1 SCF HSA-SCF-0204
			ArrayList currentfslocation=(ArrayList)FMCurrentEncounterDetails.getCurrentFsLocationDetails(con, patientid, queryCriteria, volume_no, p);
			for(int m=0; m<currentfslocation.size(); m++){
			FMCurrentEncounterDetailsBean currentfslocationDetails=(FMCurrentEncounterDetailsBean)currentfslocation.get(m); 			
				movementtype=currentfslocationDetails.getMovementtype();
				carriedby=currentfslocationDetails.getCarriedby();	
                transportdesc=currentfslocationDetails.getTransportdesc();	
				if(!movementtype.equals("")&&movementtype.equals("F")){
				transferedby=currentfslocationDetails.getTransferedby(); 
				transfereddatetime=currentfslocationDetails.getTransferdatetime();                				
				}
				/*Added by Thamizh selvi on 22nd Aug 2017 against ML-MMOH-SCF-0716 Start*/
				else{
					transferedby		= "";
					transfereddatetime	= "";
				}/*End*/
			    if(!transportdesc.equals("")&&!carriedby.equals("")){
				 transfermode=transportdesc+" - "+carriedby;				 
				}
				/*Added by Thamizh selvi on 22nd Aug 2017 against ML-MMOH-SCF-0752 Start*/
				else{
				 transfermode="";
				}/*End*/
			}
			
			
			ArrayList requestDetls=(ArrayList)FMCurrentEncounterDetails.getCurrentFsLocationRequestDetails(con, patientid, queryCriteria, volume_no, p);
			for(int n=0; n<requestDetls.size(); n++){
			FMCurrentEncounterDetailsBean requestedDetailsBean=(FMCurrentEncounterDetailsBean)requestDetls.get(n); 
				narration=requestedDetailsBean.getNarration();	
				/* Below line(s) added by Venkatesh.s against ML-MMOH-CRF-0393 */
               remarkforborrow=requestedDetailsBean.getRemarkforBorrow();	 
				requestedby=requestedDetailsBean.getRequestedby();
				issuedby=requestedDetailsBean.getIssuedby();
				issueddatetime=requestedDetailsBean.getIssuedDatetime();
				
			}
			
			//End HSA-CRF-0306.1 and SCF HSA-SCF-0204
			
			
			//Below line added for this CRF HSA-CRF-0306
			ArrayList nursingunitDetails=(ArrayList)FMCurrentEncounterDetails.getFromNursingunitDetails(con,patientid,facility,p);
			for(int j=0; j<nursingunitDetails.size(); j++){
			FMCurrentEncounterDetailsBean frmnursingunitDetails=(FMCurrentEncounterDetailsBean)nursingunitDetails.get(j); 
                pr_nursing_unit=frmnursingunitDetails.getFromnursingunit();
				pr_room_num	=frmnursingunitDetails.getFromroom(); 
				pr_bed_num=frmnursingunitDetails.getFrombed();				  
			}
			if(!isCurrentFsLocation){
			ArrayList List=(ArrayList)FMCurrentEncounterDetails.getCurrentEncounterDetails(con,queryCriteria,facility,p);
			recorCount=List.size(); 
			for(int i=0; i<List.size(); i++){
			   FMCurrentEncounterDetailsBean currencounterDetails=(FMCurrentEncounterDetailsBean)List.get(i);                
				PatientClass=currencounterDetails.getPatientClass();
				Assigncarecode=currencounterDetails.getAssigncarecode(); 
				AssignCareType=currencounterDetails.getAssignCareType();
				p_nursing_unit=currencounterDetails.getNursingUnit();
				p_room_num=currencounterDetails.getRoom();
				p_bed_num=currencounterDetails.getBed();
				Specility=currencounterDetails.getSpecility();
				Clinic=currencounterDetails.getClinic();
				Priorityzone=currencounterDetails.getPriorityzone();
				Treatmentarea=currencounterDetails.getTreatmentarea();		   
			    dischargedatetime=currencounterDetails.getDischargedatetime();
			}
						
			//End HSA-CRF-0306
			
		//Below line modified for this CRF HSA-CRF-0306 
			//if(count >= 1 ){
			if(recorCount >= 1 ){
				int add = 0;
				int len = p_nursing_unit.length();

				add = 18 -len ; 

				for(int i=0; i<add; i++)
				p_nursing_unit = p_nursing_unit + "&nbsp;";
                pr_nursing_unit = pr_nursing_unit + "&nbsp;";
				len = 0;
				add = 0;
				len = p_room_num.length();
				add = 8 -len ;

				for(int k=0; k<add; k++)
					p_room_num = p_room_num +  "&nbsp;"	;
			        pr_room_num = pr_room_num +  "&nbsp;"	;
					
			//Added clinic for HSA-CRF-0306
                len = 0;
				add = 0;	
                len = Clinic.length();
				add = 18 -len ; 
                for(int m=0; m<add; m++)
				Clinic = Clinic + "&nbsp;";  
				
             //Added speciality for HSA-CRF-0306
                len = 0;
				add = 0;	
                len = Specility.length();
				add = 18 -len ; 
                for(int n=0; n<add; n++)
				Specility = Specility + "&nbsp;"; 
             
             //Added Treatmentarea for HSA-CRF-0306
                len = 0;
				add = 0;	
                len = Treatmentarea.length();
				add = 18 -len ; 
                for(int k=0; k<add; k++)
				Treatmentarea = Treatmentarea + "&nbsp;"; 	
              
               //Added Priorityzone for HSA-CRF-0306
                len = 0;
				add = 0;	
                len = Priorityzone.length(); 
				add = 18 -len ;   
                for(int l=0; l<add; l++)
				Priorityzone = Priorityzone + "&nbsp;";    			  
			
			}
		  }//Added for this CRF HSA-CRF-0306.1
		}

		int record_count = 0;

	//SelectSqlBuffer.append("SELECT a.file_no, get_patient_line (a.patient_id,'"+localeName+"') patient_line, a.curr_fs_locn_code, d.short_desc curr_fs_locn_short_desc, a.prev_fs_locn_code, g.short_desc prev_fs_locn_desc, (CASE WHEN a.prev_fs_locn_code IS NOT NULL AND g.holder_name IS NOT NULL THEN (SELECT appl_user_name FROM sm_appl_user WHERE appl_user_id = g.holder_name) END ) prev_holder_name, g.holder_phone_no prev_phone_no, DECODE (a.curr_fs_locn_identity, 'D', 'Department', 'T', 'Practitioner', 'C', 'Clinic', 'N', 'Nursing Unit', 'X', 'External', 'E', 'Procedure Unit', 'Y', 'Daycare Unit' ) curr_fs_locn_identity, DECODE (g.locn_identity, 'D', 'Department', 'T', 'Practitioner', 'C', 'Clinic', 'N', 'Nursing Unit', 'X', 'External', 'E', 'Procedure Unit', 'Y', 'Daycare Unit' ) prev_fs_locn_identity, a.curr_file_status file_status, (CASE WHEN a.narration_code IS NOT NULL THEN (SELECT short_desc FROM fm_narration WHERE narration_code = a.narration_code) END ) narration_desc, TO_CHAR (a.added_date, 'dd/mm/rrrr hh24:mi') file_creation_date, DECODE (a.curr_file_status, 'I', 'Inside', 'O', 'Outside', 'L', 'Lost', 'T', 'InTransit', 'R', 'Returned', 'A', 'Archived', 'E', 'Other Facility' ) curr_file_status, (CASE WHEN a.curr_file_status = 'T' THEN    ' / ' || c.short_desc || ' (' || DECODE (c.locn_identity, 'D', 'Department', 'C', 'Clinic', 'N', 'Nursing Unit', 'T', 'Practitioner', 'E', 'Procedure Unit', 'Y', 'Daycare Unit' ) || ')' ELSE ' ' END ) dest_locn, TO_CHAR (a.iss_date_time, 'dd/mm/rrrr hh24:mi') iss_date_time, TO_CHAR (a.return_date_time, 'dd/mm/rrrr hh24:mi') return_date_time, (CASE WHEN a.facility_id <> a.curr_facility_id THEN ' / ' || (SELECT facility_name FROM sm_facility_param WHERE facility_id = a.curr_facility_id) ELSE ' ' END ) curr_facility_name, (CASE WHEN a.facility_id <> a.prev_facility_id THEN ' / ' || (SELECT facility_name FROM sm_facility_param WHERE facility_id = a.prev_facility_id) ELSE ' ' END ) prev_facility_name, (CASE WHEN a.curr_file_status = 'T' THEN (CASE WHEN c.holder_name IS NOT NULL THEN (SELECT appl_user_name FROM sm_appl_user WHERE appl_user_id = c.holder_name) END ) ELSE (CASE WHEN d.holder_name IS NOT NULL THEN (SELECT appl_user_name FROM sm_appl_user WHERE appl_user_id = d.holder_name) END ) END ) holder_name, (CASE WHEN a.curr_file_status = 'T' THEN c.holder_phone_no ELSE d.holder_phone_no END ) holder_phone_no, a.req_remarks, (CASE WHEN (    a.curr_facility_id = a.facility_id AND a.curr_fs_locn_code = a.perm_fs_locn_code AND a.curr_file_status = 'I' ) THEN 'Y' ELSE 'N' END ) owner_locn_yn, a.curr_locn_id, a.curr_fs_locn_identity locn_iden, c.locn_identity, i.src_user_id, (CASE WHEN i.src_user_id IS NOT NULL THEN (SELECT appl_user_name FROM sm_appl_user WHERE appl_user_id = i.src_user_id) END ) issued_by, i.transport_mode, i.carried_by_name, (CASE WHEN i.transport_mode IS NOT NULL THEN (SELECT long_desc FROM am_transport_mode WHERE transport_mode = i.transport_mode) END ) transport_desc, (CASE WHEN i.dest_user_id IS NOT NULL THEN (SELECT appl_user_name FROM sm_appl_user WHERE appl_user_id = i.dest_user_id) END ) reqname,j.carried_by_name carried_by_ret,(CASE WHEN j.transport_mode IS NOT NULL THEN (SELECT long_desc FROM am_transport_mode WHERE transport_mode = j.transport_mode) END ) transport_desc_ret FROM fm_curr_locn a, fm_transit_file b, fm_storage_locn c, fm_storage_locn d, fm_storage_locn g, fm_movement_log i, fm_movement_log j WHERE a.facility_id = '"+ facility + "' AND a.file_no = '" + queryCriteria + "' AND a.volume_no = "+volume_no+" AND a.facility_id = b.facility_id(+) AND a.file_no = b.file_no(+) AND b.facility_id = c.facility_id(+) AND b.dest_fs_locn_code = c.fs_locn_code(+) AND a.curr_facility_id = d.facility_id AND a.curr_fs_locn_code = d.fs_locn_code AND a.prev_facility_id = g.facility_id(+) AND a.prev_fs_locn_code = g.fs_locn_code(+) AND a.facility_id = i.facility_id(+) AND a.file_no = i.file_no(+) AND a.volume_no = i.volume_no(+) AND a.ISS_DATE_TIME = i.sent_date_time(+) AND a.facility_id = j.facility_id(+) AND a.file_no = j.file_no(+) AND a.volume_no = j.volume_no(+) AND a.last_movement_date_time = j.sent_date_time(+) ");
	SelectSqlBuffer.append("SELECT" );
	SelectSqlBuffer.append("  b.DEST_FS_LOCN_CODE,b.DEST_FACILITY_ID,a.file_no " );
	SelectSqlBuffer.append("  , get_patient_line (a.patient_id,'"+localeName+"') patient_line " );
	SelectSqlBuffer.append("  , a.curr_fs_locn_code " );
    SelectSqlBuffer.append("  , a.perm_fs_locn_code " );
	SelectSqlBuffer.append("  , a.deficiency_status " );
	SelectSqlBuffer.append("  , d.short_desc curr_fs_locn_short_desc " );
	SelectSqlBuffer.append("  , d.locn_identity other_locn_identity " );
	SelectSqlBuffer.append("  , a.prev_fs_locn_code " );
	SelectSqlBuffer.append("  , g.short_desc prev_fs_locn_desc " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN a.prev_fs_locn_code IS" );
	SelectSqlBuffer.append("    NOT NULL " );
	SelectSqlBuffer.append("    AND g.holder_name IS" );
	SelectSqlBuffer.append("    NOT NULL " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    (SM_GET_DESC.SM_APPL_USER(g.holder_name,'"+localeName+"','1')) " );
	SelectSqlBuffer.append("  END) prev_holder_name " );
	SelectSqlBuffer.append("  , g.holder_phone_no prev_phone_no " );
	SelectSqlBuffer.append("  , a.curr_fs_locn_identity curr_fs_locn_identity " );
	SelectSqlBuffer.append("  , g.locn_identity prev_fs_locn_identity " );
	SelectSqlBuffer.append("  , a.curr_file_status file_status " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN a.narration_code IS" );
	SelectSqlBuffer.append("    NOT NULL " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    (FM_GET_DESC.FM_NARRATION(A.NARRATION_CODE,'"+localeName+"','2')) " );
	SelectSqlBuffer.append("  END) narration_desc " );
	SelectSqlBuffer.append("  , TO_CHAR (a.added_date, 'dd/mm/rrrr hh24:mi') file_creation_date " );
	SelectSqlBuffer.append("  , a.curr_file_status curr_file_status " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN a.curr_file_status = 'T' " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    ' / ' || FM_GET_DESC.FM_STORAGE_LOCN(B.FACILITY_ID, b.dest_fs_locn_code,'"+localeName+"','2') || ' (' || c.locn_identity || ')' " );
	SelectSqlBuffer.append("  ELSE ' ' " );
	SelectSqlBuffer.append("  END ) dest_locn " );
	SelectSqlBuffer.append("  , TO_CHAR (a.iss_date_time, 'dd/mm/rrrr hh24:mi') iss_date_time " );
	SelectSqlBuffer.append("  , TO_CHAR (a.return_date_time, 'dd/mm/rrrr hh24:mi') return_date_time " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN a.facility_id <> a.curr_facility_id " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    ' / ' || (SM_GET_DESC.SM_FACILITY_PARAM(a.curr_facility_id,'"+localeName+"','1')) " );
	SelectSqlBuffer.append("  ELSE ' ' " );
	SelectSqlBuffer.append("  END) curr_facility_name " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN a.facility_id <> a.prev_facility_id " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    ' / ' || (SM_GET_DESC.SM_FACILITY_PARAM(a.prev_facility_id,'"+localeName+"','1')) " );
	SelectSqlBuffer.append("  ELSE ' ' " );
	SelectSqlBuffer.append("  END ) prev_facility_name " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN a.curr_file_status = 'T' " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    ( " );
	SelectSqlBuffer.append("    CASE " );
	SelectSqlBuffer.append("    WHEN c.holder_name IS" );
	SelectSqlBuffer.append("      NOT NULL " );
	SelectSqlBuffer.append("    THEN" );
	SelectSqlBuffer.append("      (SM_GET_DESC.SM_APPL_USER(c.holder_name,'"+localeName+"','1')) " );
	SelectSqlBuffer.append("    END) " );
	SelectSqlBuffer.append("  ELSE ( " );
	SelectSqlBuffer.append("    CASE " );
	SelectSqlBuffer.append("    WHEN d.holder_name IS" );
	SelectSqlBuffer.append("      NOT NULL " );
	SelectSqlBuffer.append("    THEN" );
	SelectSqlBuffer.append("      (SM_GET_DESC.SM_APPL_USER(d.holder_name,'"+localeName+"','1')) " );
	SelectSqlBuffer.append("    END) " );
	SelectSqlBuffer.append("  END) holder_name " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN a.curr_file_status = 'T' " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    c.holder_phone_no  " );
	SelectSqlBuffer.append("  ELSE d.holder_phone_no  " );
	SelectSqlBuffer.append("  END ) holder_phone_no  " );
 
   SelectSqlBuffer.append("  , ( " );
   SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN a.curr_file_status = 'T' " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    b.dest_locn_identity " );
	SelectSqlBuffer.append("  ELSE null " );
	SelectSqlBuffer.append("  END ) dest_locn_identity " );
  SelectSqlBuffer.append("  , a.req_remarks " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN ( a.curr_facility_id = a.facility_id " );
	SelectSqlBuffer.append("    AND a.curr_fs_locn_code = a.perm_fs_locn_code " );
	SelectSqlBuffer.append("    AND a.curr_file_status = 'I' ) " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    'Y' " );
	SelectSqlBuffer.append("  ELSE 'N' " );
	SelectSqlBuffer.append("  END) owner_locn_yn " );
	SelectSqlBuffer.append("  , a.curr_locn_id,a.curr_facility_id " );
	SelectSqlBuffer.append("  , a.curr_fs_locn_identity locn_iden " );
	SelectSqlBuffer.append("  , c.locn_identity " );
	SelectSqlBuffer.append("  , j.src_user_id, NVL(i.movement_type,j.movement_type) trfType" ); //Modified by Thamizh selvi on 25th Aug 2017 for ML-MMOH-CRF-0716
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN j.src_user_id IS" );
	SelectSqlBuffer.append("    NOT NULL " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    (SM_GET_DESC.SM_APPL_USER(j.src_user_id,'"+localeName+"','1')) " );
	SelectSqlBuffer.append("  END) issued_by " );
	SelectSqlBuffer.append("  , j.transport_mode " );
	SelectSqlBuffer.append("  , j.carried_by_name " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN j.transport_mode IS" );
	SelectSqlBuffer.append("    NOT NULL " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    ( am_get_desc.am_transport_mode(j.transport_mode,'"+localeName+"','1') ) " );
	SelectSqlBuffer.append("  END) transport_desc " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN i.dest_user_id IS" );
	SelectSqlBuffer.append("    NOT NULL " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    (SM_GET_DESC.SM_APPL_USER(i.dest_user_id,'"+localeName+"','1')) " );
	SelectSqlBuffer.append("  END) reqname " );
	SelectSqlBuffer.append("  , j.carried_by_name carried_by_ret " );
	SelectSqlBuffer.append("  , ( " );
	SelectSqlBuffer.append("  CASE " );
	SelectSqlBuffer.append("  WHEN j.transport_mode IS" );
	SelectSqlBuffer.append("    NOT NULL " );
	SelectSqlBuffer.append("  THEN" );
	SelectSqlBuffer.append("    ( am_get_desc.am_transport_mode(j.transport_mode,'"+localeName+"','1') ) " );
	SelectSqlBuffer.append("  END) transport_desc_ret " );	
	 /*Below line(s) borrowing_reason column added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
	SelectSqlBuffer.append(", TO_CHAR (a.discharge_date_time, 'dd/mm/rrrr hh24:mi') curr_locn_dis_date_time , return_date_manual_yn,a.borrowing_reason ");
	
	//Added for this CRF HSA-CRF-0306.1
   	SelectSqlBuffer.append("FROM" );
	SelectSqlBuffer.append("  fm_curr_locn a " );
	SelectSqlBuffer.append("  , fm_transit_file b " );
	SelectSqlBuffer.append("  , fm_storage_locn_lang_vw c " );
	SelectSqlBuffer.append("  , fm_storage_locn_lang_vw d " );
	SelectSqlBuffer.append("  , fm_storage_locn_lang_vw g " );
	SelectSqlBuffer.append("  , fm_movement_log i " );
	SelectSqlBuffer.append("  , fm_movement_log j " );
	//SelectSqlBuffer.append("WHERE a.facility_id = '"+ facility + "' " );
	SelectSqlBuffer.append("  WHERE a.file_no = '" + queryCriteria + "' " );
	SelectSqlBuffer.append("  AND a.patient_id ='"+patientid+"' " );
	SelectSqlBuffer.append("  AND a.volume_no = "+volume_no+" " );
	SelectSqlBuffer.append("  AND a.facility_id = b.facility_id(+) " );
	SelectSqlBuffer.append("  AND a.file_no = b.file_no(+) " );
	SelectSqlBuffer.append("  AND a.volume_no = b.volume_no (+) " );
	SelectSqlBuffer.append("  AND b.facility_id = c.facility_id(+) " );
	SelectSqlBuffer.append("  AND b.dest_fs_locn_code = c.fs_locn_code(+) " );
	SelectSqlBuffer.append("  AND c.language_id(+) = '"+localeName+"' " );
	SelectSqlBuffer.append("  AND a.curr_facility_id = d.facility_id " );
	SelectSqlBuffer.append("  AND a.curr_fs_locn_code = d.fs_locn_code " );
	SelectSqlBuffer.append("  AND d.language_id = '"+localeName+"' " );
	SelectSqlBuffer.append("  AND a.prev_facility_id = g.facility_id(+) " );
	SelectSqlBuffer.append("  AND a.prev_fs_locn_code = g.fs_locn_code(+) " );
	SelectSqlBuffer.append("  AND g.language_id(+) = '"+localeName+"' " );
	SelectSqlBuffer.append("  AND a.facility_id = i.facility_id(+) " );
	SelectSqlBuffer.append("  AND a.file_no = i.file_no(+) " );
	SelectSqlBuffer.append("  AND a.volume_no = i.volume_no(+) " );
	SelectSqlBuffer.append("  AND to_char(a.iss_date_time,'dd/mm/rrrr hh24:mi') = to_char(i.sent_date_time(+),'dd/mm/rrrr hh24:mi') " );////Modified by Thamizh selvi on 25th Aug 2017 for ML-MMOH-CRF-0716
	SelectSqlBuffer.append("  AND a.facility_id = j.facility_id(+) " );
	SelectSqlBuffer.append("  AND a.file_no = j.file_no(+) " );
	SelectSqlBuffer.append("  AND a.volume_no = j.volume_no(+) " );
	SelectSqlBuffer.append("  AND a.last_movement_date_time = j.sent_date_time(+) " );
	
  
	
	stmt	= con.createStatement();
    rset	= stmt.executeQuery(SelectSqlBuffer.toString());
	String location_identity = "";
	String current_locn		 = "";
	String sqlString		 = "";	
	String location_desc	 = "";	
    String other_locn_identity="";
	String desc_facility_id="";
	String desc_fs_locn_code="";
	String deficiency_status = "";

            _bw.write(_wl_block9Bytes, _wl_block9);
            {java.lang.String __page ="../../eCommon/jsp/pline.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("Patient_ID"), weblogic.utils.StringUtils.valueOf(patientid
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block11Bytes, _wl_block11);

	int i = 0;
	String p_req_remarks = "", p_owner_locn_yn="", p_owner_phone_yn="";
	String issue_trf_by = "";	
	if(rset.next())
	{ 
		issue_trf_by = rset.getString("iss_date_time");
		if((issue_trf_by==null) || (issue_trf_by.equals("null")))
		{
			//issue_trf_by="Transferred By";			
			issue_trf_by=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransferredBy.label","common_labels");			
		}
		else
		{
			//issue_trf_by="Issued By";			
			issue_trf_by=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.issuedby.label","common_labels");			
		}
		p_req_remarks = rset.getString("req_remarks");
		p_owner_locn_yn = rset.getString("owner_locn_yn");
		if (p_owner_locn_yn.trim().equals("Y"))
		{
			//p_owner_locn_yn="Holder Name";
			//p_owner_phone_yn="Holder Phone No.";
			p_owner_locn_yn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.HolderName.label","fm_labels");
			p_owner_phone_yn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.HolderPhoneNo..label","fm_labels");
		}
		else
		{
			p_owner_locn_yn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.HolderName.label","fm_labels");
			p_owner_phone_yn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.HolderPhoneNo..label","fm_labels");
		}
		
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

			String identity = 			(rset.getString("curr_fs_locn_identity")==null)?"&nbsp":rset.getString("curr_fs_locn_identity");
		        /*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
			borrowing_reason =(rset.getString("borrowing_reason")==null)?"":rset.getString("borrowing_reason");
				/* end ML-MMOH-CRF-0393-IN057159  */
			String prev_identity = 			(rset.getString("prev_fs_locn_identity")==null)?"&nbsp":rset.getString("prev_fs_locn_identity");
			desc_facility_id = 			(rset.getString("DEST_FACILITY_ID")==null)?"&nbsp":rset.getString("DEST_FACILITY_ID");
			desc_fs_locn_code = 			(rset.getString("DEST_FS_LOCN_CODE")==null)?"&nbsp":rset.getString("DEST_FS_LOCN_CODE");
			
			
			String locn_iden = 			(rset.getString("locn_iden")==null)?"&nbsp":rset.getString("locn_iden");
			location_identity	= rset.getString("locn_identity");
			
			
			current_locn		= rset.getString("curr_locn_id");
			/*Added for this CRF HSA-CRF-0306.1*/
			if(isCurrentFsLocation){
			if(current_locn==null || current_locn.equals("null")) current_locn="";
			ArrayList List=(ArrayList)FMCurrentEncounterDetails.getFileCurrentEncounterDetails(con,patientid,current_locn,locn_iden,facility,p);
			recorCount=List.size();  
			for(int k=0; k<List.size(); k++){
			   FMCurrentEncounterDetailsBean currencounterDetails=(FMCurrentEncounterDetailsBean)List.get(k);                
				PatientClass=currencounterDetails.getPatientClass();
				Assigncarecode=currencounterDetails.getAssigncarecode(); 
				AssignCareType=currencounterDetails.getAssignCareType();
				p_nursing_unit=currencounterDetails.getNursingUnit();
				p_room_num=currencounterDetails.getRoom();
				p_bed_num=currencounterDetails.getBed();
				Specility=currencounterDetails.getSpecility();
				Clinic=currencounterDetails.getClinic();
				Priorityzone=currencounterDetails.getPriorityzone();
				Treatmentarea=currencounterDetails.getTreatmentarea();		   
			    dischargedatetime=currencounterDetails.getDischargedatetime();
				canceldischarge=currencounterDetails.getCanceldischarge();				
				if((canceldischarge==null) || (canceldischarge.equals("null")))	canceldischarge = "";
				
				if((dischargedatetime==null) || (dischargedatetime.equals("null")))	dischargedatetime = "";
			}
			
			
						
			if(recorCount >= 1 ){
				int add = 0;
				int len = p_nursing_unit.length();

				add = 18 -len ; 

				for(int z=0; z<add; z++)
				p_nursing_unit = p_nursing_unit + "&nbsp;";
                pr_nursing_unit = pr_nursing_unit + "&nbsp;";
				len = 0;
				add = 0;
				len = p_room_num.length();
				add = 8 -len ;

				for(int q=0; q<add; q++)
					p_room_num = p_room_num +  "&nbsp;"	;
			        pr_room_num = pr_room_num +  "&nbsp;"	;
					
			//Added clinic for HSA-CRF-0306
                len = 0;
				add = 0;	
                len = Clinic.length();
				add = 18 -len ; 
                for(int r=0; r<add; r++)
				Clinic = Clinic + "&nbsp;";  
				
             //Added speciality for HSA-CRF-0306
                len = 0;
				add = 0;	
                len = Specility.length();
				add = 18 -len ; 
                for(int t=0; t<add; t++)
				Specility = Specility + "&nbsp;"; 
             
             //Added Treatmentarea for HSA-CRF-0306
                len = 0;
				add = 0;	
                len = Treatmentarea.length();
				add = 18 -len ; 
                for(int u=0; u<add; u++)
				Treatmentarea = Treatmentarea + "&nbsp;"; 	
              
               //Added Priorityzone for HSA-CRF-0306
                len = 0;
				add = 0;	
                len = Priorityzone.length(); 
				add = 18 -len ;   
                for(int b=0; b<add; b++)
				Priorityzone = Priorityzone + "&nbsp;";    			  
			
			}
		  }	
       		  
		/*End HSA-CRF-0306.1*/
			
            curr_facility_id     =  rset.getString("curr_facility_id");
			 other_locn_identity= rset.getString("other_locn_identity");
			String curr_file_status= rset.getString("curr_file_status")==null ? "&nbsp":rset.getString("curr_file_status");
			dest_locn_identity= rset.getString("dest_locn_identity")==null ? "":rset.getString("dest_locn_identity");	
			narration_desc= rset.getString("narration_desc")==null ? "":rset.getString("narration_desc");	
			reqname= rset.getString("reqname")==null ? "":rset.getString("reqname");	
			issued_by= rset.getString("issued_by")==null ? "":rset.getString("issued_by");	
			trfType		= rset.getString("trfType")==null ? "":rset.getString("trfType");//Modified by Thamizh selvi on 25th Aug 2017 for ML-MMOH-CRF-0716
			if(narration.equals("")) narration=narration_desc;
			if(issuedby.equals("")) issuedby=issued_by;
			 file_status1=curr_file_status;
			 stmt3 = con.createStatement();			 
			 		
			if((location_identity==null) || (location_identity.equals("null")))
				location_identity = locn_iden;
			
		if(curr_file_status.equals("T"))
		{
		 location_identity=dest_locn_identity;
		}
			if((current_locn==null) || (current_locn.equals("null")))
				current_locn = "";

					
		if( identity.equals(other_locn_identity))
		{
		  
		}
		else{
		identity=other_locn_identity;
		} 
			if(!identity.equals(""))
		{
			switch(identity.charAt(0))
			{
				case 'D' : identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}
       
		 		
		if(!prev_identity.equals(""))
		{
			switch(prev_identity.charAt(0))
			{
				case 'D' : prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : prev_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}
				if(location_identity.equals("N")) {
				sqlString	=	"SELECT long_desc short_desc FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code = '"+current_locn+"'  AND facility_id = '"+curr_facility_id+"' AND eff_status = 'E' and language_id='"+localeName+"'";
			} else if (location_identity.equals("C") || location_identity.equals("E")) {
				sqlString	=	"SELECT long_desc short_desc FROM op_clinic_lang_vw WHERE clinic_code = '"+current_locn+"' AND facility_id = '"+curr_facility_id+"' AND eff_status = 'E'  and language_id='"+localeName+"'";
			} else if (location_identity.equals("D")) {
				//sqlString	=	"SELECT long_desc short_desc FROM op_clinic_lang_vw WHERE clinic_code = '"+current_locn+"' AND facility_id = '"+curr_facility_id+"' AND eff_status = 'E'  and language_id='"+localeName+"'";
				sqlString	=	"SELECT short_desc from fm_storage_locn WHERE fs_locn_code  = '"+desc_fs_locn_code+"' AND facility_id = '"+desc_facility_id+"' AND eff_status = 'E'  ";
			} else if (location_identity.equals("T")) {
				sqlString	=	"SELECT practitioner_name short_desc FROM am_practitioner_lang_vw  WHERE practitioner_id = '"+current_locn+"' AND eff_status = 'E'  and language_id='"+localeName+"' ";
			}		// Condition Newly Added for FM Incident By Saanthaakumarg
			else if (location_identity.equals("Y")) {
				//sqlString	=	"SELECT short_desc from fm_storage_locn WHERE fs_locn_code  = '"+desc_fs_locn_code+"' AND facility_id = '"+desc_facility_id+"' AND eff_status = 'E'  ";
				sqlString	=	"SELECT long_desc short_desc FROM op_clinic_lang_vw WHERE clinic_code = '"+current_locn+"' AND facility_id = '"+curr_facility_id+"' AND eff_status = 'E'  and language_id='"+localeName+"'";
			}	
					
			if(!sqlString.equals(""))
			{				
				if(stmt2!=null)	stmt2.close();
				stmt2 = con.createStatement();
				rs = stmt2.executeQuery(sqlString);
				if ((rs!=null) && (rs.next()))
					location_desc = rs.getString("short_desc");
				// Line commented against IN018199 by Muthu on 18/01/2010 
				//if(curr_file_status.equals("I") || curr_file_status.equals("R"))
				if(curr_file_status.equals("I"))
					location_desc = "&nbsp;";
				else 
					location_desc = ((location_desc==null) || (location_desc.equals("null"))||(location_desc.equals(""))) ? "&nbsp;" : (" / ("+location_desc+") ");
			}

			if(!curr_file_status.equals(""))
			{
				switch(curr_file_status.charAt(0))
				{
					case 'T' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels"); break;

					case 'I' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisInside.label","fm_labels"); break;

					case 'L' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisLost.label","fm_labels"); break;

					case 'A' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisArchived.label","fm_labels"); break;

					case 'O' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisOutside.label","fm_labels"); break;

					case 'R' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.returned.label","common_labels"); break;

					case 'E' :
				curr_filetrans =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels");;	
			    curr_file_status =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherFacility.label","common_labels");
			 curr_file_status=curr_filetrans+"&nbsp;"+"/"+"&nbsp;" +curr_file_status;
			   break;
			
				
				
				}
			}
			
		 prev_facility_name = 			(rset.getString("prev_facility_name")==null)?"&nbsp":rset.getString("prev_facility_name");
				
		if(prev_identity.equals("") || prev_identity.equals("&nbsp") )
		  prev_facility_name="&nbsp";
		
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((rset.getString("CURR_FS_LOCN_SHORT_DESC")==null)?"&nbsp":rset.getString("CURR_FS_LOCN_SHORT_DESC") + "(" + identity + ")"));
            out.print( String.valueOf(rset.getString("curr_facility_name")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((rset.getString("prev_fs_locn_desc")==null)?"&nbsp":rset.getString("prev_fs_locn_desc") + "(" + prev_identity + ")"));
            out.print( String.valueOf(prev_facility_name));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

			deficiency_status = (rset.getString("deficiency_status")==null)?"":rset.getString("deficiency_status") ;
			if(deficiency_status.equals(""))
		   { 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(curr_file_status));
            out.print( String.valueOf(location_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
 }
			
			if(deficiency_status.equals("O"))
			{
            out.print( String.valueOf(curr_file_status));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(location_desc));
 } else if(deficiency_status.equals("C")){ 
            out.print( String.valueOf(curr_file_status));
            out.print( String.valueOf(location_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
 } else if(deficiency_status.equals("X")){ 
            out.print( String.valueOf(curr_file_status));
            out.print( String.valueOf(location_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
 } 
		
            _bw.write(_wl_block24Bytes, _wl_block24);
 //if(recorCount >= 1){ 
            _bw.write(_wl_block25Bytes, _wl_block25);
if(isCurrentFsLocation){

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block26Bytes, _wl_block26);
/*Added for this CRF HSA-CRF-0306*/
			    String tdclass="", fontsize="",nursingUnitDaycare=""; 
			    if(PatientClass.equals("IP"))tdclass="labelcenter";
				if(PatientClass.equals("IP"))
				nursingUnitDaycare=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
				if(PatientClass.equals("DC")&&isCurrentFsLocation)
				nursingUnitDaycare=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
				   
				   if(PatientClass.equals("IP")||(PatientClass.equals("DC")&&isCurrentFsLocation)){
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(nursingUnitDaycare));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_nursing_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(p_room_num));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(p_bed_num));
            _bw.write(_wl_block31Bytes, _wl_block31);
} /*Added for this CRF HSA-CRF-0306*/
            _bw.write(_wl_block32Bytes, _wl_block32);
/*Added for this CRF HSA-CRF-0306*/
			 if(PatientClass.equals("IP")||(PatientClass.equals("DC")&&isCurrentFsLocation)){			   
			 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(nursingUnitDaycare));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(pr_nursing_unit));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pr_room_num));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pr_bed_num));
            _bw.write(_wl_block36Bytes, _wl_block36);
}//Added for this CRF HSA-CRF-0306
			
			 if(PatientClass.equals("OP")&&isCurrentFsLocation){
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
if(AssignCareType.equals("C")){

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
}if(AssignCareType.equals("E")){

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(Specility));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(Clinic));
            _bw.write(_wl_block41Bytes, _wl_block41);
} if(PatientClass.equals("EM")&&isCurrentFsLocation){
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(Clinic));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(Priorityzone));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(Treatmentarea));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(p_bed_num));
            _bw.write(_wl_block47Bytes, _wl_block47);
}
            _bw.write(_wl_block48Bytes, _wl_block48);
 //}
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);


		return_date_time=rset.getString("return_date_time")==null?"":rset.getString("return_date_time");		
       String returnDateChkBlank	= return_date_time;
       //Added for this CRF HSA-CRF-0306.1
	      curr_locn_dischage_datetime=rset.getString("curr_locn_dis_date_time")==null?"":rset.getString("curr_locn_dis_date_time");
		   if(!curr_locn_dischage_datetime.equals(""))
			{
			   curr_locn_dischage_datetime=DateUtils.convertDate(curr_locn_dischage_datetime,"DMYHM","en",localeName);	
				
			}
	return_date_manual_yn=rset.getString("return_date_manual_yn")==null?"N":rset.getString("return_date_manual_yn"); //Added for this CRF HSA-CRF-0306.1	   
	   
			if(isCurrentFsLocation) {
				 returndate=return_date_time;
				 if(!returndate.equals(""))returndate=DateUtils.convertDate(returndate,"DMYHM","en",localeName);
			 } 
		//End HSA-CRF-0306.1
		
		if(!return_date_time.equals("") || return_date_time.equals("0"))
		{
			return_date_time=DateUtils.convertDate(return_date_time,"DMYHM","en",localeName);
			
			
		
		}
		else
			return_date_time = "&nbsp;";
	
		
            _bw.write(_wl_block10Bytes, _wl_block10);

	 
	 
	 
	 
	 if(rset1!=null)	rset1.close();
     if(stmt1!=null) stmt1.close();
		
		String sqlString1="select return_criteria  ,no_of_dh_to_return_op  , duration_type from  fm_storage_locn where fs_locn_code='"+curr_fs_locn_code+"' and facility_id='"+fcy_id+"'";
		
				
			  stmt1 = con.createStatement();
				rset1 = stmt1.executeQuery(sqlString1);
	while(rset1 != null && rset1.next()){
    return_criteria =rset1.getString("return_criteria");
    no_of_dh_to_return_op=rset1.getString("no_of_dh_to_return_op");
    duration_type=rset1.getString("duration_type");
    }
    	 
	 if(rset1!=null)	rset1.close();
     if(stmt1!=null) stmt1.close();
		
	       if(no_of_dh_to_return_op==null) no_of_dh_to_return_op="0";
	    	if(return_criteria==null) return_criteria="";
			if(duration_type==null) duration_type="";
		 		
			
			if(duration_type.equals("D"))
					{
					parameter_hours = Integer.parseInt(no_of_dh_to_return_op) * 24;
					}
					else
					{
				parameter_hours = Integer.parseInt(no_of_dh_to_return_op);	
					}	
		
	
		  
		 if(return_criteria.equals("D"))
			{
		  
		   String sqlString2="SELECT to_char(discharge_date_time+ "+(parameter_hours)+" / 24, 'dd/mm/yyyy hh24:mi') discharge_date_time  FROM pr_encounter WHERE discharge_date_time is not null AND facility_id ='"+fcy_id+"' AND assign_care_locn_code='"+current_locn+"' AND patient_id in (SELECT patient_id FROM fm_movement_log WHERE file_no ='"+queryCriteria+"' and patient_id='"+patientid+"'  AND facility_id ='"+fcy_id+"' AND sent_date_time IS NOT null)";
		      
			  stmt1 = con.createStatement();
				rset1 = stmt1.executeQuery(sqlString2);
    		 while(rset1 != null && (rset1.next())){
        discharge_date_time =rset1.getString("discharge_date_time");
          
		   }
       if(rset1!=null)	rset1.close();
       if(stmt1!=null) stmt1.close();
	       if(discharge_date_time==null) discharge_date_time="";
		  
		  if(!discharge_date_time.equals("") || discharge_date_time!=null)
				{
					discharge_date_time=DateUtils.convertDate(discharge_date_time,"DMYHM","en",localeName);
				}		
				 if(return_criteria.equals("D") && return_date_time!=null && !return_date_time.equals("&nbsp;") )
				{
                     
				}
		else	if(return_date_time.equals("&nbsp;") || return_date_time!=null)
				{
				 return_date_time=discharge_date_time;
							
				}
			
		/*	 if(parameter_hours<=0)
							{
        //     return_date_time="";
							} */
			if(return_date_time.equals(""))  return_date_time="&nbsp;";
			}
		
		//Added for this CRF HSA-CRF-0306.1 
		 String current_fs_locn_code="",number="",durations_type="",permenant_fs_locn_code="",duration_day_hours="",fslocn_return_criteria="",day_hour_return="",permanent_file_area_yn="",locn_identity="", current_file_status="";
		 int hours=0;		 
		 String currLocQuery="select curr_fs_locn_code, perm_fs_locn_code, curr_file_status from fm_curr_locn where facility_id='"+fcy_id+"' and file_no='"+queryCriteria+"' and volume_no='"+volume_no+"'";         		 
		 stmt1 = con.createStatement();
		 rset1 = stmt1.executeQuery(currLocQuery);
    	 if(rset1 != null && rset1.next()){
             current_fs_locn_code =rset1.getString("curr_fs_locn_code");
             permenant_fs_locn_code	=rset1.getString("perm_fs_locn_code");	
             current_file_status=rset1.getString("curr_file_status");				 
		 }		  
       if(rset1!=null)	rset1.close();
       if(stmt1!=null) stmt1.close();				
		 
		String durationsqlQuery="SELECT (CASE  WHEN locn_identity IN 'C' and exists (SELECT 1 FROM op_clinic             WHERE clinic_type = 'C' AND level_of_care_ind = 'E'   AND clinic_code = '"+current_locn+"' AND mr_location_code = '"+current_fs_locn_code+"' ) THEN  no_of_dh_to_return_em     ELSE (CASE                  WHEN locn_identity IN ('C', 'E') THEN no_of_dh_to_return_op   ELSE (CASE                            WHEN locn_identity = 'N' THEN no_of_dh_to_return_ip    ELSE (CASE                                      WHEN locn_identity = 'Y' THEN no_of_dh_to_return_dc   END)  END)                  END) END) no_of_dh_to_return, duration_type, return_criteria, permanent_file_area_yn, locn_identity FROM fm_storage_locn WHERE fs_locn_code = '"+current_fs_locn_code+"' AND facility_id='"+fcy_id+"'" ;
		
		
        		
		stmt1 = con.createStatement();
		rset1 = stmt1.executeQuery(durationsqlQuery);
    	if(rset1!= null&&rset1.next()){
            number= rset1.getString(1);
			durations_type= rset1.getString(2);
            fslocn_return_criteria= rset1.getString(3);	
            permanent_file_area_yn= rset1.getString(4);	
			locn_identity= rset1.getString(5);				
		 }         
       if(rset1!=null)	rset1.close();
       if(stmt1!=null) stmt1.close();
         if(number==null || number.equals("")) number = "0";
		 if(fslocn_return_criteria == null || fslocn_return_criteria.equals("null")) fslocn_return_criteria = "";
		 if(fslocn_return_criteria.equals("")) fslocn_return_criteria="I";
	     if(durations_type == null || durations_type.equals("null")) durations_type = "";
         if(durations_type.equals("D")){ 
			 hours = Integer.parseInt(number); 		 

			 if(isCurrentFsLocation&&recorCount >= 1 &&dischargedatetime.equals("")&&fslocn_return_criteria.equals("D")&&!current_file_status.equals("I")&&!current_file_status.equals("T")&& Integer.parseInt(number)!=0){
            
			 /*if(isCurrentFsLocation&&returndate.equals("")&&recorCount >= 1 &&dischargedatetime.equals("")&&fslocn_return_criteria.equals("D")&&!current_file_status.equals("I")&&!current_file_status.equals("T")&& Integer.parseInt(number)!=0){*/
			 	
			       
			  		 //returndate=number;					 
					 return_date=number; 
					 
					 if(Integer.parseInt(number)==1){ 
					       day_hour_return=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.Day.label","fm_labels");				
					 }else{
					       day_hour_return=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
					 } 				 
				
        duration_day_hours=day_hour_return+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.fromdischarge.label","fm_labels");				 
			  }
		}if(durations_type.equals("H")){   
		     //hours = Integer.parseInt(number); 
			      
             if(isCurrentFsLocation&&recorCount >= 1&&dischargedatetime.equals("")&&fslocn_return_criteria.equals("D")&&!current_file_status.equals("I")&&!current_file_status.equals("T")&&Integer.parseInt(number)!=0){
				  
            /*if(isCurrentFsLocation&&returndate.equals("")&&recorCount >= 1&&dischargedatetime.equals("")&&fslocn_return_criteria.equals("D")&&!current_file_status.equals("I")&&!current_file_status.equals("T")&&Integer.parseInt(number)!=0){*/
			               		 
               			  
				 //returndate=number;
				 return_date=number; 
				 
				 if(Integer.parseInt(number)==1){ 
				       day_hour_return=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.Hour.label","fm_labels");				
 				 }else{
				       day_hour_return=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.hours.label","common_labels");
				 }				 
				duration_day_hours=day_hour_return+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.fromdischarge.label","fm_labels") ;
			 }
		}	 
		
	   //End HSA-CRF-0306.1
	   
			
            _bw.write(_wl_block50Bytes, _wl_block50);

		if(isCurrentFsLocation && fslocn_return_criteria.equals("D") && recorCount >= 1 && !dischargedatetime.equals("") &&!current_file_status.equals("I")&&!current_file_status.equals("T")){
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(returndate));
            _bw.write(_wl_block51Bytes, _wl_block51);
}else if(isCurrentFsLocation && fslocn_return_criteria.equals("D") && recorCount >= 1 && dischargedatetime.equals("") && return_date_manual_yn.equals("Y") && !current_file_status.equals("I") && !current_file_status.equals("T")){
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(returndate));
            _bw.write(_wl_block10Bytes, _wl_block10);
}else if(isCurrentFsLocation && fslocn_return_criteria.equals("D") && recorCount >= 1 && dischargedatetime.equals("") && !current_file_status.equals("I") && !current_file_status.equals("T")){
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(return_date));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(duration_day_hours));
            _bw.write(_wl_block10Bytes, _wl_block10);
}else if(isCurrentFsLocation && fslocn_return_criteria.equals("D") && recorCount==0 && return_date_manual_yn.equals("Y") && !returndate.equals("") && !current_file_status.equals("I") && !current_file_status.equals("T")){
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(returndate));
            _bw.write(_wl_block10Bytes, _wl_block10);
}else if(isCurrentFsLocation && fslocn_return_criteria.equals("I") && !current_file_status.equals("I") && !current_file_status.equals("T")){
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(returndate));
            _bw.write(_wl_block10Bytes, _wl_block10);
}else if(!isCurrentFsLocation){
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(return_date_time));
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

			file_creation_date=rset.getString("FILE_CREATION_DATE");
			if(file_creation_date != null)
			{
				file_creation_date=DateUtils.convertDate(file_creation_date,"DMYHM","en",localeName);
			}
			else{
				file_creation_date = "&nbsp;";
		    }
     			

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(file_creation_date));
            _bw.write(_wl_block55Bytes, _wl_block55);

	  String file_status = rset.getString("file_status")==null?"":rset.getString("file_status");	
	   //if(file_status.equals("T") || file_status.equals("O")){
	  if((file_status.equals("T") || file_status.equals("O") || movementtype.equals("I") || movementtype.equals("F") || movementtype.equals("T"))&&!issuedby.equals("") && !file_status.equals("I"))//Modified by Thamizh selvi on 22nd Aug 2017 against ML-MMOH-SCF-0716
	{ 
	  
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(issuedby));
            _bw.write(_wl_block58Bytes, _wl_block58);
}
            _bw.write(_wl_block59Bytes, _wl_block59);
 if(!file_status.equals("I")){ 
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

		iss_date_time = rset.getString("iss_date_time");
		
	//Below code commented by Thamizh selvi on 23rd Aug 2017 against ML-MMOH-SCF-0716 since issueddatetime is obtained from fm_req_dtl table which is only applicable in the case of request and issue file and not during transfer file/change file storage location

	/*if(iss_date_time != null)
		{
			iss_date_time=DateUtils.convertDate(iss_date_time,"DMYHM","en",localeName);
		}
		else
			iss_date_time = "&nbsp;";*/
		/*Above line commented and below line added for HSA-SCF-0204 and HSA-CRF-0306.1*/
		
        /*if(issueddatetime != null)
		{
			issueddatetime=DateUtils.convertDate(issueddatetime,"DMYHM","en",localeName);
		}else{
			issueddatetime = "&nbsp;";
        }			
			
	
		curr_fs_locn_code=rset.getString("curr_fs_locn_code");
	if(curr_fs_locn_code==null) curr_fs_locn_code="";
			perm_fs_locn_code=rset.getString("perm_fs_locn_code");
	if(perm_fs_locn_code==null) perm_fs_locn_code="";

		/*if(perm_fs_locn_code.equals(curr_fs_locn_code) && file_status1.equals("I"))
		{
		iss_date_time = "&nbsp;";
		}*/
		/*Above line commented and below line added for HSA-SCF-0204 and HSA-CRF-0306.1
		if(perm_fs_locn_code.equals(curr_fs_locn_code) && file_status1.equals("I"))
		{
		issueddatetime = "&nbsp;";
		}*/
		
		if(iss_date_time==null || iss_date_time.equals("null")) iss_date_time="";  //This line for check the null value
		
		//if(issueddatetime.equals("")) issueddatetime=iss_date_time;//Commented by Thamizh selvi on 23rd Aug 2017 against ML-MMOH-SCF-0716
		
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(iss_date_time));
            _bw.write(_wl_block61Bytes, _wl_block61);
 } 
            _bw.write(_wl_block10Bytes, _wl_block10);
 
		 
		if((file_status.equals("T") || file_status.equals("O") ||  movementtype.equals("F") || movementtype.equals("T"))&&!transferedby.equals("") && !file_status.equals("I") && !trfType.equals("C"))//Modified by Thamizh selvi on 22nd Aug 2017 against ML-MMOH-SCF-0716
	       { 
	  
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(transferedby));
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(transfereddatetime));
            _bw.write(_wl_block64Bytes, _wl_block64);
}
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(p_owner_locn_yn));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf((rset.getString("HOLDER_NAME")==null)?"&nbsp":rset.getString("HOLDER_NAME")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf((rset.getString("prev_holder_name")==null)?"&nbsp":rset.getString("prev_holder_name")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_owner_phone_yn));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf((rset.getString("holder_phone_no")==null)?"&nbsp":rset.getString("holder_phone_no")));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf((rset.getString("prev_phone_no")==null)?"&nbsp":rset.getString("prev_phone_no")));
            _bw.write(_wl_block68Bytes, _wl_block68);

	//if(file_status.equals("T") || file_status.equals("O"){	
	if(requestedby.equals("")) requestedby=reqname;
	if(file_status.equals("T") || file_status.equals("O") || movementtype.equals("I") || movementtype.equals("F") )
	{ 
	//Above line commented and below line modified for HSA-CRF-0306.1 and HSA-SCF-0204
		
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(requestedby));
            _bw.write(_wl_block69Bytes, _wl_block69);
if(p_req_remarks != null){
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(p_req_remarks));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(p_req_remarks));
            _bw.write(_wl_block76Bytes, _wl_block76);
}
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
 if(narration.equalsIgnoreCase("others")){	
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(narration));
            _bw.write(_wl_block81Bytes, _wl_block81);
 if(!remarkforborrow.equals("")){
		  
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(remarkforborrow));
            _bw.write(_wl_block85Bytes, _wl_block85);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
if(!borrowing_reason.equals("")){ 
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(borrowing_reason));
            _bw.write(_wl_block85Bytes, _wl_block85);
}
            _bw.write(_wl_block86Bytes, _wl_block86);
}else if(narration_desc.equalsIgnoreCase("others")){ 
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(narration_desc));
            _bw.write(_wl_block87Bytes, _wl_block87);
 if(!remarkforborrow.equals("")){
		  
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(remarkforborrow));
            _bw.write(_wl_block85Bytes, _wl_block85);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
if(!borrowing_reason.equals("")){ 
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(borrowing_reason));
            _bw.write(_wl_block85Bytes, _wl_block85);
}
            _bw.write(_wl_block88Bytes, _wl_block88);
}else{
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(narration));
            _bw.write(_wl_block89Bytes, _wl_block89);
}
            _bw.write(_wl_block90Bytes, _wl_block90);
 } 
            _bw.write(_wl_block10Bytes, _wl_block10);
 if(!file_status.equals("I")){ 
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

		if(file_status.equals("T") || file_status.equals("O") || movementtype.equals("I") || movementtype.equals("F") || movementtype.equals("T"))
	   {
			if(trfType.equals("C") && file_status.equals("O")){transfermode = "";}//Modified by Thamizh selvi on 25th Aug 2017 for ML-MMOH-CRF-0716
		
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(transfermode));
            _bw.write(_wl_block93Bytes, _wl_block93);
 }else{ 
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf((rset.getString("transport_desc_ret")==null)?"&nbsp":rset.getString("transport_desc_ret")));
            _bw.write(_wl_block10Bytes, _wl_block10);
 if(!(rset.getString("carried_by_ret")==null)){	
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf((rset.getString("carried_by_ret")==null)?"&nbsp":rset.getString("carried_by_ret")));
            _bw.write(_wl_block10Bytes, _wl_block10);
 } 
            _bw.write(_wl_block96Bytes, _wl_block96);
 } 
            _bw.write(_wl_block97Bytes, _wl_block97);
 } 
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(appointmentDays));
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(bookingDays));
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.AppointmentDetail.label","fm_labels")));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(appointmentDays));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(bookingDays));
            _bw.write(_wl_block105Bytes, _wl_block105);
if(isCurrentFsLocation){
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AuditTrail.label","common_labels")));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(queryCriteria));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileMovement.label","fm_labels")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.History.label","common_labels")));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(queryCriteria));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block110Bytes, _wl_block110);
} //End HSA-CRF-0306
            _bw.write(_wl_block111Bytes, _wl_block111);
	if (appt_count==0) {
			// commented by Abdulhamid for EDGE Work - TFS BUG 77187.
			//out.println("<script>if(document.forms[0].View)document.forms[0].View.style.visibility='hidden';</script>");
		} 
            _bw.write(_wl_block112Bytes, _wl_block112);
		
		record_count++;
		}

		if(record_count == 0)
		{
			
            _bw.write(_wl_block113Bytes, _wl_block113);

		}
	
            _bw.write(_wl_block114Bytes, _wl_block114);

//	}


	if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
	{
		SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
	}
	if(rset!=null)	rset.close();
	if(rset1!=null)	rset1.close();
	if(rs!=null)	rs.close();
	if(rs1!=null)	rs1.close();
	if(stmt!=null)	stmt.close();
	if(stmt1!=null)	stmt1.close();
	if(stmt2!=null)	stmt2.close();
	if(stmt3!=null)	stmt3.close();
	}catch(Exception e){
	out.println("Exception  :" + e ) ;
	e.printStackTrace() ;
	}finally{
		if(stmt2!=null)	stmt2.close();
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(queryCriteria));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(currStatDesc));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(currIdDesc));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(Curr_locn_desc));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(appointmentDays));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(bookingDays));
            _bw.write(_wl_block123Bytes, _wl_block123);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CurrentFileStatus.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.PreviousFileStatus.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.CurrentFSLocation.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FileStatus.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.incomplete.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.closed.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancelled.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CurrentEncounterDetails.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.InpatientDetails.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.room.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Bed.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.room.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Bed.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clinic.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProcedureUnit.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clinic.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PriorityZone.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.treatmentarea.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Bed.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.ReturnDueDateTime.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FileCreatedDateTime.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.issuedby.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.issueddatetime.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransferredBy.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.TransferredDateTime.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestedBy.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.RequestRemarks.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.ReasonForBorrowing.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.TransportDetail.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.OPDAppointmentfor.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.inpatientbooking.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.for.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
}
