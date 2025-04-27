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
import java.text.*;
import java.sql.Date;
import java.util.*;
import com.ehis.util.*;

public final class __queryfmfilemovementhistorysearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/QueryFMFileMovementHistorySearchResult.jsp", 1733218656388L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <!-- Developed By\t   :\tPrashant Bhalsingh\n\t Created on   \t   :\t21/06/2001\n\t Module Name \t   :\tFM\\File movement history\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n<HTML>\n<HEAD>\n\t<!-- <LINK rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></LINK> -->\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\'></SCRIPT>\n\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></SCRIPT>\n\t<script language=\'javascript\' src=\'../../eFM/js/QueryFMFileMovementHistroy.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<HEAD>\n<BODY onMouseDown=\"CodeArrest();\" onLoad=\'FocusFirstElement();\' onKeyDown = \'lockKey();\'>\n<FORM name=\"QueryFMSearchResult\" id=\"QueryFMSearchResult\" action=\"../../eFM/jsp/QueryFMFileMovementHIstorySearchResult.jsp\" method=\"post\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t  \t<SCRIPT>\n\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t\t\t    \t\n\t\t\t\t\tparent.frames[2]. location.href =\"../../eCommon/html/blank.html\";\n\t\t\t\t</SCRIPT>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<TABLE align=\'right\'>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t  <A href=\"javascript:getNext(\'previous\')\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="<A>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t  <A href=\"javascript:getNext(\'next\')\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n     \t\t\t\t<A href=\"javascript:getNext(\'previous\')\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t    \t\t\t<A href=\"javascript:getNext(\'next\')\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t</TD>\n\t\t</TR>\n\t</TABLE>\t\n\t<BR>\n\t<BR>\n\t<TABLE border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\"99%\">\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<tr>\n\t\t<td colspan=\'3\' class=\'PATIENTLINECOLOR\'>\n\t<font size=1 color=\'white\'><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;</b></font>\t\n\t\t</td>\n\t\n\t</tr>\t\t\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<TR>\n\t\t\t<TD colspan=\'3\'>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t</TD>\n\t\t</TR>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t<TR><TD  class=\'BODYCOLORFILLED\' colspan=\'3\'>&nbsp;</TD></TR>\n\t\t<TR>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t<TD  class=\'label\'><b>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" :</B>&nbsp;\n\t\t(";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =")&nbsp;";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp; - &nbsp;&nbsp;";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</TD>\n\t\t</TR>\n\t</TABLE>\n\t<TABLE border=\"1\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\"99%\">\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<TR><TD></TD><TR>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t<TR>\n\t\t\t<th rowspan=\"2\" height=\"15\" class=\'columnheader\' width=\'15%\' align=\"left\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</th>\n\t\t\t<th\tcolspan=\"2\"\theight=\"15\" width=\'34%\' class=\'columnheader\' align=\"left\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</th>\n\t\t\t<th rowspan=\"2\" height=\"15\" width=\'6%\' class=\'columnheader\' align=\"left\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</th>\n\t\t\t<th rowspan=\"2\" height=\"15\" width=\'15%\' class=\'columnheader\' align=\"left\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</th>\n\t\t\t<th rowspan=\"2\" height=\"15\" width=\'24%\' class=\'columnheader\' align=\"left\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</th>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<th height=\"15\" width=\'18%\' class=\'columnheader\' align=\"left\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</th>\n\t\t\t<th height=\"15\" width=\'18%\' class=\'columnheader\' align=\"left\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</th>\n\t\t</TR>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t<TR>\n\t\t\t<TD  height=\"20\"  class=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'><FONT size=1>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t</TD>\n\t\t\t<TD  height=\"20\" class=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' ><FONT size=1>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t</TD>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n                ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t<TD\theight=\"20\" class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"><FONT size=1>\n\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" / ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t</TD>\n\t\t\t\t<TD  height=\"20\" class=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"><FONT size=1>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t   <A href=\'javascript:GetShowRemarks(\"ReqComm";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\",\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\",\"R\")\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&nbsp; ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</A>\n\t\t\t   </FONT>\n\t\t\t\t\t<INPUT type=\'hidden\' name=\"ReqComm";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" id=\"ReqComm";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' >   \n\t\t\t\t   </TD>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t<TD  height=\"20\" class=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t   <A href=\'javascript:GetShowRemarks(\"txtComm";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\",\"IR\")\'> ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" </A>\n\t\t\t\t   </FONT>\n\t\t\t\t\t <INPUT type=\'hidden\' name=\"txtComm";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" id=\"txtComm";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' >     \n\t\t\t\t   </TD>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t<TD  height=\"20\" class=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"><FONT size=1>\n\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t</TD>\n\t\t\t<TD  height=\"20\" class=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t<A href=\'javascript:GetReturnRemarks(\"ReqComm";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\",\"RR\")\'>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" </a>\n\t\t\t     </FONT>\n\t\t<INPUT type=\'hidden\' name=\"ReqComm";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>    \n\t</TD> \n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\t\n\t\t\t</TD>\n\t\t\t<TD  height=\"20\" class=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</TD>\n\t\t\t</TR>\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t</TABLE>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" \n   <INPUT type=\'hidden\' name=\'previousRecord\' id=\'previousRecord\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' >\n\t<INPUT type=\'hidden\' name=\'nextRecord\' id=\'nextRecord\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' >\n\t<INPUT type=\'hidden\' name=\'flag\' id=\'flag\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' >\n\t<INPUT type=\'hidden\' name=\'volume_no\' id=\'volume_no\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' >\n\t<INPUT type=\'hidden\' name=\'noOfRecords\' id=\'noOfRecords\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' >\n\t<INPUT type=\'hidden\' name=\'facility\' id=\'facility\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' >\n\t<INPUT type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' >\n\t<INPUT type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' >\n\t<input type=\'hidden\' name=\'patientid\' id=\'patientid\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' >\n\t<INPUT type=\'hidden\' name=\'currStatDesc\' id=\'currStatDesc\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n\t<INPUT type=\'hidden\' name=\'currIdDesc\' id=\'currIdDesc\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n\t<INPUT type=\'hidden\' name=\'Curr_locn_desc\' id=\'Curr_locn_desc\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n\t<INPUT type=\'hidden\' name=\'curr_facility_name\' id=\'curr_facility_name\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n\t<INPUT type=\'hidden\' name=\'currentFileStatus\' id=\'currentFileStatus\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n\t<INPUT type=\'hidden\' name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n\t<INPUT type=\'hidden\' name=\'maintain_doc_or_file\' id=\'maintain_doc_or_file\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n\t<INPUT type=\'hidden\' name=\'doc_folder_id\' id=\'doc_folder_id\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n\t<INPUT type=\'hidden\' name=\'doc_type_code\' id=\'doc_type_code\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n\t <INPUT type=\'hidden\' name=\'criteria\' id=\'criteria\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' >\n\t ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t<INPUT type=\'hidden\' name=\'filetypeCriteria\' id=\'filetypeCriteria\' value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' >\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\n</FORM>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

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
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		Connection con  = ConnectionManager.getConnection(request);
		PreparedStatement pstmt_temp = null;
		ResultSet rs_temp = null;
		Statement stmt	= null;
		ResultSet rset	= null;
		Statement st	= null;
		ResultSet rs	= null;		
		
		String sql					= "";
		String mysql				= ""; 		
		String volumeCriteria		= "";
		String classValue			= "",p_req_remarks="",p_iss_remarks="";
		String current_locn_desc	= "";		
		String curr_file_status		= "";
		String IssueDate			= "";
		String recordedDateTime		= "";
		String curr_id_desc		    = "";
		String doc_folder_name = "";
		String doc_type = "";
		String intransit = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels");
		StringBuffer selectCriteria	= null;
      String mrd_receipt_remarks	= "";
//		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
		
		String queryCriteria = (request.getParameter("criteria")==null)?"":request.getParameter("criteria");
		String volume_no	 = ( (request.getParameter("volume_no")==null) || ((request.getParameter("volume_no").equals("null"))))?"":request.getParameter("volume_no");
		String queryfiletypeCriteria	= (request.getParameter("filetypeCriteria")==null)?"":request.getParameter("filetypeCriteria");
		String flag				=
		(request.getParameter("flag")==null)?"":request.getParameter("flag");
		String facility			= (request.getParameter("facility")==null)?"":request.getParameter("facility");
		String from				=
		(request.getParameter("from")==null)?"":request.getParameter("from");
		String to				=
		(request.getParameter("to")==null)?"":request.getParameter("to");
		String patientid		= (request.getParameter("patientid")==null)?"":request.getParameter("patientid");
		String currStatDesc		= (request.getParameter("currStatDesc")==null)?"":request.getParameter("currStatDesc");
		String currIdDesc		= (request.getParameter("currIdDesc")==null)?"":request.getParameter("currIdDesc");
		String Curr_locn_desc	= (request.getParameter("Curr_locn_desc")==null)?"":request.getParameter("Curr_locn_desc");
		String curr_facility_name	= (request.getParameter("curr_facility_name")==null)?"":request.getParameter("curr_facility_name");
		String currentFileStatus	= (request.getParameter("currentFileStatus")==null)?"":request.getParameter("currentFileStatus");
		String file_type_appl_yn	= (request.getParameter("file_type_appl_yn")==null)?"":request.getParameter("file_type_appl_yn");
		String doc_type_code		= (request.getParameter("doc_type_code")==null)?"":request.getParameter("doc_type_code");
		String doc_folder_id		= (request.getParameter("doc_folder_id")==null)?"":request.getParameter("doc_folder_id");
		String maintain_doc_or_file	= (request.getParameter("maintain_doc_or_file")==null)?"":request.getParameter("maintain_doc_or_file");
		
		int  nextRecord		= (request.getParameter("nextRecord")==null)? 									 0:Integer.parseInt(request.getParameter("nextRecord"));

		int	previousRecord	= (request.getParameter("previousRecord")==null)? 0 :                           Integer.parseInt(request.getParameter("previousRecord"));

		int counter					= 0;
		int fromRecordNumber		= 0;
		int toRecordNumber  		= 0;
		int noOfRecords				= 0;

		try
		{
			selectCriteria = new StringBuffer();
	 		if(from != null)
			{
				from = "'" + from + "'";
			}
			if(to != null)
			{
				to   = "'" + to + "'";
			}
			if(maintain_doc_or_file.equals("F"))
			{
				if(file_type_appl_yn.equals("N"))
				{
					selectCriteria.append("AND a.file_no= '"+queryCriteria+"' ");
				}
				else if(file_type_appl_yn.equals("Y"))
				{
					selectCriteria.append("AND a.file_no= '"+queryCriteria+"' ");
					selectCriteria.append(" AND a.file_type_code= '"+queryfiletypeCriteria+"' ");
				}
				if(!volume_no.equals(""))
				volumeCriteria = " AND a.volume_no = "+volume_no+" ";
			}
			else if(maintain_doc_or_file.equals("D"))
			{
				selectCriteria.append("AND a.file_no= '"+queryCriteria+"' ");
				selectCriteria.append("AND a.doc_folder_id= '"+doc_folder_id+"' ");
				selectCriteria.append("AND a.doc_type_code= '"+doc_type_code+"' ");
			}
			
			//sql	= "SELECT a.file_no, a.patient_id, a.file_type_code, a.volume_no,a.doc_folder_id,a.doc_type_code,to_char(a.sent_date_time,'DD/MM/YYYY HH24:MI')issuedate, a.src_locn_identity, a.src_fs_locn_desc, (CASE WHEN rec_date_time IS NOT NULL THEN TO_CHAR(a.rec_date_time,'DD/MM/YYYY HH24:MI')ELSE 'In Transit' END)recordeddatetime, a.dest_locn_identity, a.dest_fs_locn_desc, SUBSTR(c.appl_user_name,1,60)appl_user_name,(CASE WHEN a.facility_id<>a.dest_facility_id THEN b.facility_name ELSE '&nbsp;' END)facility_name, a.req_remarks, a.iss_remarks, a.mrd_receipt_remarks FROM fm_movement_log_vw a, sm_facility_param b, sm_appl_user c WHERE	TRUNC(a.SENT_DATE_TIME) BETWEEN " +			"NVL( TO_DATE("+from+ ", 'dd/MM/yyyy'),TO_DATE('01/01/1900','DD/MM/YYYy')) AND " + 			"NVL( TO_DATE("+to+ ", 'DD/MM/YYYY'),TO_DATE('31/12/5000','DD/MM/YYYY')) "+selectCriteria+" "+volumeCriteria+" AND a.patient_id = '"+patientid+"' AND a.dest_facility_id=b.facility_id and a.dest_user_id=c.appl_user_id(+) ORDER BY sent_date_time desc ";
			sql = " SELECT  a.file_no  , a.patient_id  , a.file_type_code  , a.volume_no  ,a.doc_folder_id  ,a.doc_type_code  ,TO_CHAR(a.sent_date_time,'DD/MM/YYYY HH24:MI')issuedate  , a.src_locn_identity  , FM_GET_DESC.FM_STORAGE_LOCN(A.SRC_FACILITY_ID, A.SRC_FS_LOCN_CODE,'"+localeName+"','2') src_fs_locn_desc  , (  CASE   WHEN rec_date_time IS  NOT NULL   THEN  TO_CHAR(a.rec_date_time,'DD/MM/YYYY HH24:MI')  ELSE '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels")+"'   END)recordeddatetime  , a.dest_locn_identity  , FM_GET_DESC.FM_STORAGE_LOCN(A.DEST_FACILITY_ID, A.DEST_FS_LOCN_CODE,'"+localeName+"','2') dest_fs_locn_desc  , SM_GET_DESC.SM_APPL_USER(a.dest_user_id,'"+localeName+"','1') appl_user_name  ,(  CASE   WHEN a.facility_id<>a.dest_facility_id   THEN  SM_GET_DESC.SM_FACILITY_PARAM(a.dest_facility_id,'"+localeName+"','1')   ELSE '&nbsp;'   END)facility_name  , a.req_remarks  , a.iss_remarks  , a.mrd_receipt_remarks  FROM  fm_movement_log a WHERE TRUNC(a.SENT_DATE_TIME) BETWEEN " + "NVL( TO_DATE("+from+ ", 'dd/MM/yyyy'),TO_DATE('01/01/1900','DD/MM/YYYy'))   AND " + "NVL( TO_DATE("+to+ ", 'DD/MM/YYYY'),TO_DATE('31/12/5000','DD/MM/YYYY')) "+selectCriteria+" "+volumeCriteria+"  AND a.patient_id = '"+patientid+"'  ORDER BY  sent_date_time desc ";
			
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rset = stmt.executeQuery(sql);
			while(rset.next())
			noOfRecords = noOfRecords + 1;
			
			rset.beforeFirst(); 
		    if (noOfRecords== 0)
			{

            _bw.write(_wl_block9Bytes, _wl_block9);

		  }
 		  else
		  {

            _bw.write(_wl_block10Bytes, _wl_block10);
						if("next".equals(flag.trim()))
						{
							fromRecordNumber= nextRecord	   + 1;
							toRecordNumber	= fromRecordNumber + 8;//put x-1 in place of 8 where x RecTODisplay
							 if(nextRecord-1> 0){
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
						}
						if(nextRecord + 9 < noOfRecords )
						{//put x in place of 9 where x is RecTODisplay
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
						}
			}
			if("previous".equals(flag.trim()))
			{
				fromRecordNumber	= previousRecord   - 9;//put x in place of 9 where x is RecTODisplay
				toRecordNumber	= fromRecordNumber + 8;//put x-1 place of 1 where x is RecTODisplay
				if( previousRecord - 9  > 1)
				{//put x in place of 9 where x is RecTODisplay
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
				}
				if (previousRecord <= noOfRecords )
				{

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
				}
			}

            _bw.write(_wl_block16Bytes, _wl_block16);
 
	if(maintain_doc_or_file.equals("D")){
		try{
	String sql_temp = " SELECT A.DOC_FOLDER_NAME, B.PATIENT_ID, B.FROM_PERIOD, B.TO_PERIOD, B.PATIENT_PERIOD_SPECIFIC,(CASE WHEN B.PATIENT_PERIOD_SPECIFIC='D'  THEN ', ' || TO_CHAR(B.FROM_PERIOD,'DD/MM/YYYY ') || ' - ' || TO_CHAR(B.TO_PERIOD,'DD/MM/YYYY ')ELSE ', ' || GET_PATIENT_LINE(B.PATIENT_ID,'"+localeName+"') END)DOC_TYPE FROM FM_CURR_LOCN_VW A, FM_DOC_FOLDER B WHERE A.FACILITY_ID = '"+facility+"'  AND A.DOC_FOLDER_ID = B.DOC_FOLDER_ID(+) AND A.FACILITY_ID = B.FACILITY_ID  "+selectCriteria+" AND A.PATIENT_ID = '"+patientid+"' ";
	pstmt_temp = con.prepareStatement(sql_temp);
	rs_temp = pstmt_temp.executeQuery();
	while(rs_temp.next())
		{
			doc_folder_name = rs_temp.getString("doc_folder_name")==null?"":rs_temp.getString("doc_folder_name");
			doc_type = rs_temp.getString("doc_type")==null?"":rs_temp.getString("doc_type");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(doc_folder_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(doc_type));
            _bw.write(_wl_block19Bytes, _wl_block19);
 } else { 
            _bw.write(_wl_block20Bytes, _wl_block20);
            {java.lang.String __page ="../../eCommon/jsp/pline.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("Patient_ID"), weblogic.utils.StringUtils.valueOf(patientid
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block23Bytes, _wl_block23);
 } 
            _bw.write(_wl_block24Bytes, _wl_block24);

	//mysql = "SELECT curr_fs_locn_desc, facility_name,decode (curr_fs_locn_identity,'D', 'Department', 'C', 'Clinic','N','Nursing Unit','T','Practitioner', 'E','Procedure Unit','Y','Daycare Unit') curr_fs_locn_identity, DECODE (curr_file_status, 'T', 'In Transit', 'I', 'Inside', 'L', 'Lost',    'A', 'Archived', 'O', 'Outside', 'R', 'Returned') curr_file_status FROM fm_curr_locn_vw a WHERE a.facility_id='"+facility+"' "+selectCriteria+" "+volumeCriteria+" ";
	mysql = "SELECT  b.long_desc curr_fs_locn_desc  , (CASE  WHEN a.facility_id IS NOT NULL  THEN (SELECT SM_GET_DESC.SM_FACILITY_PARAM(a.curr_facility_id,'"+localeName+"','1')  FROM sm_facility_param  WHERE facility_id = a.facility_id)  END ) facility_name  ,curr_fs_locn_identity curr_fs_locn_identity  ,curr_file_status curr_file_status  FROM  fm_curr_locn a   , fm_storage_locn_lang_vw b WHERE a.facility_id='"+facility+"' "+selectCriteria+" "+volumeCriteria+"   AND a.curr_facility_id = b.facility_id  AND a.curr_fs_locn_code =b.fs_locn_code  AND language_id='"+localeName+"'";
	
	st = con.createStatement();
	rs = st.executeQuery(mysql);
	if(rs.next())
    {
		current_locn_desc  = rs.getString("curr_fs_locn_desc");
		curr_facility_name = rs.getString("facility_name");
		curr_file_status   = rs.getString("curr_file_status");
		curr_id_desc       = rs.getString("curr_fs_locn_identity");
    }

	if(!curr_id_desc.equals(""))
		{
			switch(curr_id_desc.charAt(0))
			{
				case 'D' : curr_id_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : curr_id_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : curr_id_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : curr_id_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : curr_id_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : curr_id_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : curr_id_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}

            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(curr_id_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(current_locn_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(curr_facility_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
	
	if(rset.next())
	{

            _bw.write(_wl_block30Bytes, _wl_block30);

		rset.beforeFirst();
	}

            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

		int i = 1;
		while(rset.next()) 
		{
			p_req_remarks = rset.getString("req_remarks");
			p_iss_remarks = rset.getString("iss_remarks");

			counter++;
			if ( counter % 2 == 0 )
			  	classValue = "QRYODD";
			else
		  		classValue = "QRYEVEN";
			if(counter >=fromRecordNumber && counter <= toRecordNumber)
			{
				IssueDate=rset.getString("IssueDate");
				if(IssueDate != null)
				{
				IssueDate=DateUtils.convertDate(IssueDate,"DMYHM","en",localeName);
				}
				else
					IssueDate="";

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(IssueDate));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);

			String identity = "";
			String identityDescription =(rset.getString("SRC_LOCN_IDENTITY")==null)?"&nbsp;"
			:rset.getString("SRC_LOCN_IDENTITY");

			if("D".equals(identityDescription) || "d".equals(identityDescription))
				  identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels");
			if("T".equals(identityDescription) || "t".equals(identityDescription))
				  identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			if("C".equals(identityDescription) || "c".equals(identityDescription))
				  identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			if("N".equals(identityDescription) || "n".equals(identityDescription))
				  identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
			if("Y".equals(identityDescription) || "y".equals(identityDescription))
				  identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
			if("E".equals(identityDescription) || "e".equals(identityDescription))
				  identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((rset.getString("SRC_FS_LOCN_DESC")==null)?"&nbsp;":rset.getString("SRC_FS_LOCN_DESC")));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(" ("  +  identity +  ")"));
            _bw.write(_wl_block44Bytes, _wl_block44);

				String identityReceived = "";
				String identityDescriptionReceived =(rset.getString("DEST_LOCN_IDENTITY")==null)?"&nbsp;":rset.getString("DEST_LOCN_IDENTITY");
				if( "D".equals(identityDescriptionReceived) || "d".equals(identityDescriptionReceived))
				  identityReceived = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels");
				if( "T".equals(identityDescriptionReceived) || "t".equals(identityDescriptionReceived))
				  identityReceived = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
				if( "C".equals(identityDescriptionReceived) || "c".equals(identityDescriptionReceived))
					identityReceived = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
				if( "N".equals(identityDescriptionReceived) || "n".equals(identityDescriptionReceived))
				    identityReceived = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
				if( "Y".equals(identityDescriptionReceived) || "y".equals(identityDescriptionReceived))
				    identityReceived = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
				if( "E".equals(identityDescriptionReceived) || "e".equals(identityDescriptionReceived))
				    identityReceived = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");

            _bw.write(_wl_block45Bytes, _wl_block45);
 String fac_name=rset.getString("FACILITY_NAME");
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf((rset.getString("DEST_FS_LOCN_DESC")==null)?"&nbsp;":rset.getString("DEST_FS_LOCN_DESC")));
            _bw.write(_wl_block22Bytes, _wl_block22);
if(!fac_name.equals("&nbsp;")){
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf("("  +  identityReceived +  ")"));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(rset.getString("FACILITY_NAME")));
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf("("  +  identityReceived +  ")"));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);

				if(p_req_remarks==null)
				{
					out.println("&nbsp;</font></td>");
				}
				else
				{

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(p_req_remarks));
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(p_req_remarks));
            _bw.write(_wl_block58Bytes, _wl_block58);

				}

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);

				if(p_iss_remarks==null)
				{
					out.println("&nbsp;</font></td>");
				}
				else
				{

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(p_iss_remarks));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(p_iss_remarks));
            _bw.write(_wl_block64Bytes, _wl_block64);

			}
				   recordedDateTime=rset.getString("recordedDateTime");
				if(recordedDateTime != null)
				{
				
			if(!intransit.equals(recordedDateTime))
				{
				recordedDateTime=DateUtils.convertDate(recordedDateTime,"DMYHM","en",localeName);
				}
				}
				else
					recordedDateTime="";
if(curr_file_status.equals("R"))
				{
curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.returned.label","common_labels");
		recordedDateTime=curr_file_status;	}
		
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(recordedDateTime));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);

			mrd_receipt_remarks = rset.getString("MRD_RECEIPT_REMARKS");
			if(mrd_receipt_remarks==null) mrd_receipt_remarks="";
			if(mrd_receipt_remarks == null || mrd_receipt_remarks.equals("#")) mrd_receipt_remarks="";
			if(mrd_receipt_remarks==null || mrd_receipt_remarks.equals(""))
			{
				out.println("&nbsp;</font></td>");
			}
			else
			{

            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(mrd_receipt_remarks));
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(mrd_receipt_remarks));
            _bw.write(_wl_block71Bytes, _wl_block71);
			
			}

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf((rset.getString("appl_user_name")==null)?"&nbsp;":rset.getString("appl_user_name")));
            _bw.write(_wl_block73Bytes, _wl_block73);
			
			}
	  	i++;
		}
	  }

            _bw.write(_wl_block74Bytes, _wl_block74);

		if(rs_temp!=null)rs_temp.close();
		if(pstmt_temp!=null)pstmt_temp.close();
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
		if(rs!=null) rs.close();
		if(st!=null) st.close();


	}
	catch(Exception e)
	{
		  e.printStackTrace() ;
	}
	finally
	{
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(fromRecordNumber));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(toRecordNumber));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(noOfRecords));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(from));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(to));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(currStatDesc));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(currIdDesc));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(Curr_locn_desc));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(curr_facility_name));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(currentFileStatus));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(doc_folder_id));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(doc_type_code));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(queryCriteria));
            _bw.write(_wl_block94Bytes, _wl_block94);

	  if(file_type_appl_yn.equals("Y"))
	{

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(queryfiletypeCriteria));
            _bw.write(_wl_block96Bytes, _wl_block96);

	}

            _bw.write(_wl_block97Bytes, _wl_block97);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.CurrentFSLocation.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.Issuedon.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FSLocation.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.RequestRemarks.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IssueRemarks.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.Receivedon.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.ReturnRemarks.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReceivedBy.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Issued.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.received.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
}
