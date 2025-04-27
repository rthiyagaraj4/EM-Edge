package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eRS.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __masterschedulecompleteview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/MasterScheduleCompleteView.jsp", 1709121641512L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eRS/html/RSStylesheet.css\'></link> -->\n<script language=\"JavaScript\" src=\"../../eRS/js/MasterSchedule.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../js/RSCommon.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../eRS/js/RSMessages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n -->\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body  onMouseDown=\"CodeArrest()\"   onKeyDown=\"lockKey()\" >\n\t\t<form name=formByWorkplaceCompleteView >\n\t\t<table border=\'1\' align=\'left\' width=\"100%\" bgcolor=\'white\'>\n\t\t\t<tr><!-- <td width=\'7%\'>&nbsp;</td> -->\n\t\t\t\t<td rowspan=\'2\' colspan=\'2\'class=\'master_label\' align=\'left\'>&nbsp;</td>\n\t\t\t\t<td rowspan=\'2\' class=\'master_label\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<td colspan=\'7\' class=\'master_label\' align=\'center\'><b><-------------Week ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" -------------></b></td>\t\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr>\t\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' align=\'center\' width=\'7%\'> <b>&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;&nbsp;&nbsp;&nbsp;</b></td>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t</tr>\t\t\n\t\t\t\t<!-- Requirement Data row -->\n \t\t\t\t<tr><!-- <td width=\'7%\' class=\'REQUIREMENT\'>&nbsp;</td> -->\n\t\t\t\t<td  colspan=\'2\' width=\'10%\' class=\'REQUIREMENT\'>&nbsp;</td>\n\t\t\t\t<td width=\'34%\' class=\'REQUIREMENT\' align=\'left\'>&nbsp;<b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</b></td>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<td width=\'8%\' class=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' align=\'center\' id=\'req_alloc_total";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="/";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t<input type=\'hidden\' name=\'req_total";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' id=\'req_total";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'alloc_total";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'alloc_total";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td  colspan=\'2\' width=\'10%\' class=\'REQUIREMENT\'>&nbsp;</td>\n\t\t\t\t\t<td width=\'34%\' class=\'REQUIREMENT\' align=\'left\'>&nbsp;<b>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' align=\'center\' id=\'oncall_total";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\t<input type=\'hidden\' name=\'oncall_req";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'oncall_req";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'oncall_alloc";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'oncall_alloc";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td  colspan=\'2\' width=\'10%\' class=\'REQUIREMENT\'>&nbsp;</td>\n\t\t\t\t\t<td width=\'30%\' class=\'REQUIREMENT\' align=\'left\'>&nbsp;<b>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t<td width=\'8%\' class=\'REQUIREMENT\' align=\'center\' id=\'unproductive_total";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t\t\t<input type=\'hidden\' name=\'unproductive_alloc";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'unproductive_alloc";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\t\t\n\t\t\t</tr>\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t<tr><td class=\'position\' colspan=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'><b> ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t \n\t\t\t<!-- Position Wise Data rows -->\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t<tr id=\'posit";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t\t\t\t\t\t<td  onclick=\'javascript:expanddetails(this,\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\")\' align=\"center\" width=\'2%\' class=\'position\'><a id=view";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="  href=\'\' ><b>+</b></a></td><td colspan=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' class=\'position\' ><b>&nbsp;";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</b></td>\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t\t\n\t\t\t\t\t\t<tr id=\'posit";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' style=\'display:none;\'>\n\t\t\t\t\t\t<td class=\'ALOCATED\' colspan=\'2\'>&nbsp;</td>\n\t\t\t\t\t\t<td class=\'ALOCATED\' width=\'34%\' align=\'left\'>&nbsp;";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&nbsp;-&nbsp;";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\n\t\t\t\t\t\t\t\t<td width=\'8%\' class=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' align=\'center\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" </td>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t</tr>\n<!-- StaffWise Allocation (Display)  -->\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t<tr id=\'posit";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' style=\'display:none;\'>\n\t\t\t\t\t\t\t\t\t\t\t<td colspan=\'3\' align=\'left\'  class=\'master_label\'><b>&nbsp;";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t\t\t<td width=\'8%\' class=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' align=\'center\' >";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\'8%\' class=\'master_label\' align=\'center\' >&nbsp;</td>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t\t\t\t<td width=\'8%\' class=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\'8%\' align=\'center\' class=\'master_label\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\n<!-- ****************************************** -->\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t\t<td width=\'8%\' align=\'center\' class=\'master_label\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n<!-- /******************************/ -->\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr id=\'posit";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' style=\'display:none;\'>\n\t\t\t\t\t\t\t\t<td colspan=\'3\' align=\'left\'  class=\'master_label\'><b>&nbsp;";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t<td width=\'8%\' class=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t\t<td width=\'8%\' align=\'center\' class=\'master_label\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t\t<td width=\'8%\' class=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t\t<td width=\'8%\' class=\'master_label\' align=\'center\' >&nbsp;</td>\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t<td width=\'8%\' class=\'master_label\' align=\'center\' >&nbsp;</td>\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\t\t\t\n\n<!-- /******************************/ -->\n\t\t\t\t<tr>\n\t\t\t\t<td  rowspan=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' colspan=\'2\' class=\'SHIFTTOTAL\'>&nbsp;";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="&nbsp;";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="&nbsp;</td>\n\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n<!-- Shift Requirement Rows -->\n\t\t\t\t\t<td class=\'SHIFTTOTAL\' width=\'34%\' align=\'left\'>&nbsp;";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" - ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\t\t\n\t\t\t\t\t</tr>\t\t\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\t\n<!-- /*********************/ -->\n\t\t\t</table>\n\t</form>\n\t</body>\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n</html>\n\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

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
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	MasterSheduleByWorkplaceResultWeekly.jsp
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	04-12-2004
*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

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

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String facility_id		= request.getParameter("facility_id")==null?"":request.getParameter("facility_id") ;
	String workplace_code= request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
	String requirement_id	= request.getParameter("requirement_id")==null?"":request.getParameter("requirement_id");
	String role_type		=request.getParameter("role_type")==null?"":request.getParameter("role_type") ;
	String staff_type	=request.getParameter("staff_type")==null?"":request.getParameter("staff_type");
	String position_code= request.getParameter("position_code")==null?"":request.getParameter("position_code");
	String staff_id			=request.getParameter("staff_id")==null?"":request.getParameter("staff_id") ;
	String view				=request.getParameter("view")==null?"":request.getParameter("view");
	int week_count =Integer.parseInt(request.getParameter("week_count")==null?"0":request.getParameter("week_count"));
	int total_days=(week_count*7);
	String classval="";

	Connection conn 		= null;
	PreparedStatement pstmt_WeekDays 			= null;
	PreparedStatement pstmt_Req_Total	= null;
	PreparedStatement pstmt_Alloc_Total	= null;
	PreparedStatement pstmt_Shiftwise_Req 		= null;
	PreparedStatement pstmt_Shiftwise_Alloc 		= null;
	PreparedStatement pstmt_Positionwise_Req 	= null;
	PreparedStatement pstmt_Positionwise_Alloc= null;
	PreparedStatement pstmt_Day_Indicator 		= null;
	PreparedStatement pstmt_Staff_List 		= null;
	PreparedStatement pstmt_Position_Desc 	= null;
	PreparedStatement pstmt_Oncall_Req	 =	 null;
	PreparedStatement pstmt_Unprod_Alloc	 =	 null;

	ResultSet rs_WeekDays 		    = null;
	ResultSet rs_Req_Total		 	= null;
	ResultSet rs_Alloc_Total	 	= null;
	ResultSet rs_Shiftwise_Req 		= null;
	ResultSet rs_Shiftwise_Alloc 	= null;
	ResultSet rs_Positionwise_Req	= null;
	ResultSet rs_Positionwise_Alloc	= null;
	ResultSet rs_Day_Indicator 		= null;
	ResultSet rs_Staff_List 		= null;
	ResultSet rs_Position_Desc		= null;
	ResultSet rs_Oncall_Req			= null;
	ResultSet rs_Unprod_Alloc		= null;

	ArrayList Week_Days		= new ArrayList() ;
	ArrayList Staff_Data		= new ArrayList() ;
	ArrayList Shift_Data		= new ArrayList() ;
	ArrayList req_Optimal_Values		= new ArrayList() ;
	ArrayList Day_Indicator		= new ArrayList() ;
	ArrayList Positionwise_Req		= new ArrayList() ;
	ArrayList Oncall_Req			= new ArrayList() ;

	HashMap Positionwise_Alloc		= new HashMap() ;
	HashMap Shiftwise_Req		= new HashMap() ;
	HashMap Shiftwise_Alloc		= new HashMap() ;
	HashMap Shift_Dtl					= new HashMap() ;

	int Allocated_Values[] = new int[total_days];
	int Shift_Allocated_Values[] = new int[total_days];
	int Posit_Allocated_Values[] = new int[total_days];
	int Oncall_Allocated[] = new int[total_days];
	//int Oncall_Required[] = new int[total_days];
	int Unprod_Allocated[] = new int[total_days];
	int totalShifts=0;
	int week_no=1;
	int day_no=0;
	int req_val=0;
	int alloc_val=0;
	int day=0;
	int day_count=0;
	int optimal=0;
	int alloc_total=0;

	String[] record				= null;
	String[] position_record= null;
	String[] shift_record		= null;
	String[] shift_req=null;
	//String[] shift_alloc=null;
	//String[] position_req=null;
	String[] staff_data=null;
	String[] Day_Indic=null;

	String posit_code="";
	String shift_code="";
	String prev_staff="";
	String staff_id1="";
	String sql_staff_list="";
	String shift_mnemonic="";
	String shift_indicator="";
	String prod_flag="";
	conn = ConnectionManager.getConnection(request);
	try {

		if(view.equals("aloc"))

			sql_staff_list="select a.role_type, a.staff_type, a.staff_id, b.shift_code, c.productive_flag, c.shift_indicator,b.shift_mnemonic, b.day_no, b.week_no from rs_staff_for_workplace a, rs_master_schedule b, am_shift c where a.facility_id=? and a.workplace_code=? and (? is null or a.role_type = ?) and (? is null or a.staff_type = ?) AND (? IS NULL OR a.staff_id = ?) and (a.role_type, a.staff_id) in ( select x.role_type, x.staff_id from am_staff_vw x where x.position_code in (select distinct position_code from rs_workplace_requirement_dtl where facility_id=? and workplace_code=? and requirement_id=? and position_code=?)) and b.facility_id = ? and b.workplace_code = ? and b.requirement_id = ? and b.position_code = ? and b.role_type = a.role_type and b.staff_id = a.staff_id and c.shift_code = b.shift_code order by b.staff_id, b.day_no";

		else 
			sql_staff_list="select a.role_type, a.staff_type, a.staff_id, b.shift_code,c.productive_flag, c.shift_indicator, b.shift_mnemonic, b.day_no, b.week_no from rs_staff_for_workplace a, rs_master_schedule b, am_shift c where a.facility_id=? and a.workplace_code=? and (? is null or a.role_type = ?) and (? is null or a.staff_type = ?) AND (? IS NULL OR a.staff_id = ?) and (a.role_type, a.staff_id) in ( select x.role_type, x.staff_id from am_staff_vw x where x.position_code in (select distinct position_code from rs_workplace_requirement_dtl where facility_id=? and workplace_code=? and requirement_id=? and position_code=?)) and b.facility_id(+) = ? and b.workplace_code(+) = ? and b.requirement_id(+) = ? and b.position_code(+) = ?  and b.role_type(+) = a.role_type and b.staff_id(+) = a.staff_id and c.shift_code(+) = b.shift_code order by b.staff_id, b.day_no";

		String sql_week_days="Select day_no, initcap (substr( day_of_week,1,1) ) day_of_week from sm_day_of_week order by day_no";

		//to get the week days legend
		pstmt_WeekDays = conn.prepareStatement( sql_week_days);
		rs_WeekDays = pstmt_WeekDays.executeQuery() ;
		while (rs_WeekDays != null && rs_WeekDays.next()) 
		{
			record = new String[2];				
			record[0] = rs_WeekDays.getString("day_no");
			record[1] = rs_WeekDays.getString("day_of_week");
			Week_Days.add(record);
		}
		if(pstmt_WeekDays !=null)
			pstmt_WeekDays.close();
		if(rs_WeekDays !=null)
			rs_WeekDays.close();

		//to get the Day Indicator
		for(week_no=1;week_no<=week_count;week_no++){
			String sql_day_indicator="select week_"+week_no+"_day_1 day1, week_"+week_no+"_day_2 day2, week_"+week_no+"_day_3 day3, week_"+week_no+"_day_4 day4, week_"+week_no+"_day_5 day5, week_"+week_no+"_day_6 day6,week_"+week_no+"_day_7 day7 from rs_workplace where facility_id=?and workplace_code=?";

			pstmt_Day_Indicator = conn.prepareStatement( sql_day_indicator);
			pstmt_Day_Indicator.setString(1,facility_id);
			pstmt_Day_Indicator.setString(2,workplace_code);
			rs_Day_Indicator = pstmt_Day_Indicator.executeQuery() ;

			while (rs_Day_Indicator != null && rs_Day_Indicator.next()) 
			{
				record = new String[7];				
				record[0] = rs_Day_Indicator.getString("day1");
				record[1] = rs_Day_Indicator.getString("day2");
				record[2] = rs_Day_Indicator.getString("day3");
				record[3] = rs_Day_Indicator.getString("day4");
				record[4] = rs_Day_Indicator.getString("day5");
				record[5] = rs_Day_Indicator.getString("day6");
				record[6] = rs_Day_Indicator.getString("day7");
				Day_Indicator.add(record) ;
			}
			if(pstmt_Day_Indicator !=null)
				pstmt_Day_Indicator.close();
			if(rs_Day_Indicator !=null)
				rs_Day_Indicator.close();
		}
		//to get the Day Totals Requirements
		String sql_req_total="select sum(a.fr_wday_opt) fr_wday_opt, sum(a.fr_nwday_opt) fr_nwday_opt, sum(a.fr_hday_opt)fr_hday_opt from rs_workplace_requirement_dtl a where a.facility_id =? and a.workplace_code = ? and a.requirement_id = ? ";
		pstmt_Req_Total = conn.prepareStatement( sql_req_total);
		pstmt_Req_Total.setString(1,facility_id);
		pstmt_Req_Total.setString(2,workplace_code);
		pstmt_Req_Total.setString(3,requirement_id);
		rs_Req_Total = pstmt_Req_Total.executeQuery() ;
		while (rs_Req_Total != null && rs_Req_Total.next())
		{
			req_Optimal_Values.add(rs_Req_Total.getString("fr_wday_opt")) ;
			req_Optimal_Values.add(rs_Req_Total.getString("fr_nwday_opt")) ;
			req_Optimal_Values.add(rs_Req_Total.getString("fr_hday_opt")) ;
		}
		if(pstmt_Req_Total !=null)
			pstmt_Req_Total.close();
		if(rs_Req_Total !=null)
			rs_Req_Total.close();

		String sql_oncall_req="select sum(a.fr_wday_opt) fr_wday_opt, sum(a.fr_nwday_opt) fr_nwday_opt, sum(a.fr_hday_opt)fr_hday_opt from rs_workplace_requirement_dtl a, am_shift b  where a.facility_id =? and a.workplace_code = ? and a.requirement_id = ? and b.shift_code = a.shift_code and b.productive_flag is not null and b.productive_flag ='O' ";
		pstmt_Oncall_Req = conn.prepareStatement( sql_oncall_req);
		pstmt_Oncall_Req.setString(1,facility_id);
		pstmt_Oncall_Req.setString(2,workplace_code);
		pstmt_Oncall_Req.setString(3,requirement_id);
		rs_Oncall_Req = pstmt_Oncall_Req.executeQuery() ;
		while (rs_Oncall_Req != null && rs_Oncall_Req.next()) {
			Oncall_Req.add(rs_Oncall_Req.getString("fr_wday_opt")) ;
			Oncall_Req.add(rs_Oncall_Req.getString("fr_nwday_opt")) ;
			Oncall_Req.add(rs_Oncall_Req.getString("fr_hday_opt")) ;
		}
		if(pstmt_Oncall_Req !=null)
			pstmt_Oncall_Req.close();
		if(rs_Oncall_Req !=null)
			rs_Oncall_Req.close();

		//to get the Day allocated total
		String sql_allocated_total="select week_no,day_no,nvl(count(staff_id),0) no_of_staff, b.productive_flag from rs_master_schedule a, am_shift b where facility_id = ? and workplace_code = ? and requirement_id = ? and week_no=?  and b.shift_code = a.shift_code and b.productive_flag is not null and b.productive_flag in ('W','O')  group by week_no,day_no, b.productive_flag order by week_no,day_no";
		pstmt_Alloc_Total = conn.prepareStatement( sql_allocated_total);
		pstmt_Alloc_Total.setString(1,facility_id);
		pstmt_Alloc_Total.setString(2,workplace_code);
		pstmt_Alloc_Total.setString(3,requirement_id);
		pstmt_Alloc_Total.setString(4,String.valueOf(week_no));
		rs_Alloc_Total = pstmt_Alloc_Total.executeQuery() ;

		while (rs_Alloc_Total != null && rs_Alloc_Total.next()) {
			String p_flag =rs_Alloc_Total.getString("productive_flag");
			week_no	=	Integer.parseInt(rs_Alloc_Total.getString("week_no")==null?"0":rs_Alloc_Total.getString("week_no"));
			day=Integer.parseInt(rs_Alloc_Total.getString("day_no")==null?"0":rs_Alloc_Total.getString("day_no"));
			day_no=((week_no-1)*7)+day;

			if(week_no <= week_count){
				if((p_flag!=null)&&(p_flag.equals("W"))){
					Allocated_Values[day_no-1]=Integer.parseInt(rs_Alloc_Total.getString("no_of_staff")==null?"0":rs_Alloc_Total.getString("no_of_staff"));
				}else{
					Oncall_Allocated[day_no-1]=Integer.parseInt(rs_Alloc_Total.getString("no_of_staff")==null?"0":rs_Alloc_Total.getString("no_of_staff"));
				}
			}
		}
		if(pstmt_Alloc_Total !=null)
			pstmt_Alloc_Total.close();
		if(rs_Alloc_Total !=null)
			rs_Alloc_Total.close();

		String sql_unproductive_allocated="SELECT   week_no, day_no, NVL (COUNT (staff_id), 0) no_of_staff    FROM rs_master_schedule a, am_shift b  WHERE facility_id = ?  AND workplace_code = ?  AND b.shift_code = a.shift_code AND b.shift_indicator = 'U' and a.requirement_id=? GROUP BY week_no, day_no, b.shift_indicator ORDER BY week_no, day_no";
		pstmt_Unprod_Alloc = conn.prepareStatement( sql_unproductive_allocated);
		pstmt_Unprod_Alloc.setString(1,facility_id);
		pstmt_Unprod_Alloc.setString(2,workplace_code);
		pstmt_Unprod_Alloc.setString(3,requirement_id);
		rs_Unprod_Alloc = pstmt_Unprod_Alloc.executeQuery() ;
		while (rs_Unprod_Alloc != null && rs_Unprod_Alloc.next()) {
			week_no	=	Integer.parseInt(rs_Unprod_Alloc.getString("week_no")==null?"0":rs_Unprod_Alloc.getString("week_no"));
			day=Integer.parseInt(rs_Unprod_Alloc.getString("day_no")==null?"0":rs_Unprod_Alloc.getString("day_no"));
			day_no=((week_no-1)*7)+day;
			Unprod_Allocated[day_no-1]=Integer.parseInt(rs_Unprod_Alloc.getString("no_of_staff")==null?"0":rs_Unprod_Alloc.getString("no_of_staff"));
		}
		if(pstmt_Unprod_Alloc !=null)
			pstmt_Unprod_Alloc.close();
		if(rs_Unprod_Alloc !=null)
			rs_Unprod_Alloc.close();

		//to get the Shiftwise Requirements Total
		//String sql_shiftwise_total="SELECT   a.shift_code, b.mnemonic_key shift_mnemonic, SUM (a.fr_wday_opt) fr_wday_opt, SUM (a.fr_nwday_opt) fr_nwday_opt, SUM (a.fr_hday_opt) fr_hday_opt, b.short_desc FROM rs_workplace_requirement_dtl a, am_shift b WHERE a.facility_id = ? AND a.workplace_code = ? AND a.requirement_id = ? and a.shift_code=b.SHIFT_CODE and b.productive_flag is not null and b.productive_flag ='W' GROUP BY a.shift_code, b.mnemonic_key, b.short_desc ORDER BY shift_code";
		String sql_shiftwise_total="SELECT   a.shift_code, b.mnemonic_key shift_mnemonic, SUM (a.fr_wday_opt) fr_wday_opt, SUM (a.fr_nwday_opt) fr_nwday_opt, SUM (a.fr_hday_opt) fr_hday_opt, b.short_desc FROM rs_workplace_requirement_dtl a, am_shift_lang_vw b WHERE a.facility_id = ? AND a.workplace_code = ? AND a.requirement_id = ? and a.shift_code=b.SHIFT_CODE and b.productive_flag is not null and b.productive_flag ='W' and b.language_id = ? GROUP BY a.shift_code, b.mnemonic_key, b.short_desc ORDER BY shift_code";
		pstmt_Shiftwise_Req = conn.prepareStatement( sql_shiftwise_total);
		pstmt_Shiftwise_Req.setString(1,facility_id);
		pstmt_Shiftwise_Req.setString(2,workplace_code);
		pstmt_Shiftwise_Req.setString(3,requirement_id);
		pstmt_Shiftwise_Req.setString(4,locale);
		rs_Shiftwise_Req = pstmt_Shiftwise_Req.executeQuery() ;
		while (rs_Shiftwise_Req != null && rs_Shiftwise_Req.next()) {
			record = new String[3];				
			record[0] = rs_Shiftwise_Req.getString("fr_wday_opt") ;
			record[1] = rs_Shiftwise_Req.getString("fr_nwday_opt");
			record[2] = rs_Shiftwise_Req.getString("fr_hday_opt");
			Shiftwise_Req.put(rs_Shiftwise_Req.getString("shift_code"),record);
			if(!Shift_Dtl.containsKey(rs_Shiftwise_Req.getString("shift_code"))){
				String shift[] = new String[3];				
				shift[0] = rs_Shiftwise_Req.getString("shift_code");
				shift[1] = rs_Shiftwise_Req.getString("shift_mnemonic");
				shift[2] = rs_Shiftwise_Req.getString("short_desc");
				Shift_Data.add(shift) ;
				Shift_Dtl.put(shift[0],shift[1]);
			}
		}
		if(pstmt_Shiftwise_Req !=null)
			pstmt_Shiftwise_Req.close();
		if(rs_Shiftwise_Req !=null)
			rs_Shiftwise_Req.close();

		//String sql_positionwise_total="select a.position_code, b.position_desc,a.shift_code, c.mnemonic_key, c.short_desc shift_desc, sum(a.fr_wday_opt) fr_wday_opt, sum(a.fr_nwday_opt) fr_nwday_opt, sum(a.fr_hday_opt) fr_hday_opt from rs_workplace_requirement_dtl a, am_position b, am_shift c where a.facility_id = ? and a.workplace_code = ? and a.requirement_id = ? and (? is null or a.position_code = ?) and  a.position_code=b.position_code and a.shift_code=c.shift_code and c.productive_flag is not null and c.productive_flag ='W' group by a.position_code,a.shift_code, b.position_desc, c.mnemonic_key, c.short_desc order by position_desc, shift_code";
		String sql_positionwise_total="select a.position_code, b.position_desc,a.shift_code, c.mnemonic_key, c.short_desc shift_desc, sum(a.fr_wday_opt) fr_wday_opt, sum(a.fr_nwday_opt) fr_nwday_opt, sum(a.fr_hday_opt) fr_hday_opt from rs_workplace_requirement_dtl a, am_position_lang_vw b, am_shift_lang_vw c where a.facility_id = ? and a.workplace_code = ? and a.requirement_id = ? and (? is null or a.position_code = ?) and  a.position_code=b.position_code and a.shift_code=c.shift_code and c.productive_flag is not null and c.productive_flag ='W' and b.language_id = ? and c.language_id = b.language_id group by a.position_code,a.shift_code, b.position_desc, c.mnemonic_key, c.short_desc order by position_desc, shift_code";

		//to get the Positionwise Shiftwise Day Totals Requirements
		pstmt_Positionwise_Req = conn.prepareStatement( sql_positionwise_total);
		pstmt_Positionwise_Req.setString(1,facility_id);
		pstmt_Positionwise_Req.setString(2,workplace_code);
		pstmt_Positionwise_Req.setString(3,requirement_id);
		pstmt_Positionwise_Req.setString(4,position_code);
		pstmt_Positionwise_Req.setString(5,position_code);
		pstmt_Positionwise_Req.setString(6,locale);
		rs_Positionwise_Req = pstmt_Positionwise_Req.executeQuery() ;
		while (rs_Positionwise_Req != null && rs_Positionwise_Req.next()) {
			record = new String[8];				
			record[0] = rs_Positionwise_Req.getString("position_code");
			record[1] = rs_Positionwise_Req.getString("position_desc");
			record[2] = rs_Positionwise_Req.getString("shift_code");
			record[3] = rs_Positionwise_Req.getString("mnemonic_key");
			record[4] = rs_Positionwise_Req.getString("shift_desc");
			record[5] = rs_Positionwise_Req.getString("fr_wday_opt");
			record[6] = rs_Positionwise_Req.getString("fr_nwday_opt");
			record[7] = rs_Positionwise_Req.getString("fr_hday_opt");
			Positionwise_Req.add(record) ;
		}
		if(pstmt_Positionwise_Req !=null)
			pstmt_Positionwise_Req.close();
		if(rs_Positionwise_Req !=null)
			rs_Positionwise_Req.close();
		totalShifts=Shift_Data.size();

            _bw.write(_wl_block8Bytes, _wl_block8);
 
				for(week_no=0; week_no<week_count; week_no++){

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(week_no+1));
            _bw.write(_wl_block10Bytes, _wl_block10);

				}

            _bw.write(_wl_block11Bytes, _wl_block11);

				for(week_no=0; week_no<week_count; week_no++){
					for(int i=0; i<Week_Days.size();i++){
						classval="";
						record=(String[])Week_Days.get(i);
						//if((record[1].equalsIgnoreCase("Sat"))||(record[1].equalsIgnoreCase("Sun")))
						//	classval="WEEKEND";
						//else 
							classval="WORKDAY";

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block14Bytes, _wl_block14);
				}

				}

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
	
				optimal=0;
				alloc_total=0;
				Day_Indic=(String[])Day_Indicator.get(0);
				//to display the total WORKING requirement & total allocated shifts for the given workplace and requirement
				for(day=0;day<Day_Indic.length;day++){
					if(Day_Indic[day].equalsIgnoreCase("W")&&(req_Optimal_Values.size()>0))
						optimal=Integer.parseInt((String)req_Optimal_Values.get(0)==null?"0":(String)req_Optimal_Values.get(0));
					if(Day_Indic[day].equalsIgnoreCase("N")&&(req_Optimal_Values.size()>1))
						optimal=Integer.parseInt((String)req_Optimal_Values.get(1)==null?"0":(String)req_Optimal_Values.get(1));
					if(Allocated_Values.length>0)
						alloc_total=Allocated_Values[day];
					if(alloc_total < optimal)
						classval="BELOWOPTIMAL";
					if(alloc_total > optimal)
						classval="ABOVEOPTIMAL";
					if(alloc_total == optimal)
						classval="OPTIMAL";
					if((optimal == 0)&&(alloc_total == 0))
						classval="REQUIREMENT";

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(alloc_total));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(optimal));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(day));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(day));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(optimal));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(day));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(day));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(alloc_total));
            _bw.write(_wl_block26Bytes, _wl_block26);

				}/*end of requirement display (for)..*/

            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
 
				optimal=0;
				alloc_total=0;
				Day_Indic=(String[])Day_Indicator.get(0);
				//to display the total ONCALL requirement & total allocated shifts for the given workplace and requirement
				for(day=0;day<Day_Indic.length;day++){

					if(Day_Indic[day].equalsIgnoreCase("W")&&(Oncall_Req.size()>0))
						optimal=Integer.parseInt((String)Oncall_Req.get(0)==null?"0":(String)Oncall_Req.get(0));
					if(Day_Indic[day].equalsIgnoreCase("N")&&(Oncall_Req.size()>1))
						optimal=Integer.parseInt((String)Oncall_Req.get(1)==null?"0":(String)Oncall_Req.get(1));
					if(Oncall_Allocated.length > 0)
						alloc_total=Oncall_Allocated[day];
					if(alloc_total < optimal)
						classval="BELOWOPTIMAL";
					if(alloc_total > optimal)
						classval="ABOVEOPTIMAL";
					if(alloc_total == optimal)
						classval="OPTIMAL";
					if((optimal == 0)&&(alloc_total == 0))
						classval="REQUIREMENT";

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(alloc_total));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(optimal));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(day));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(day));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(optimal));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(day));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(day));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(alloc_total));
            _bw.write(_wl_block26Bytes, _wl_block26);

				}/*end of requirement display (for)..*/

            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

				optimal=0;
				alloc_total=0;
				Day_Indic=(String[])Day_Indicator.get(0);
				//to display the total ONCALL requirement & total allocated shifts for the given workplace and requirement
				for(day=0;day<Day_Indic.length;day++){

					if(Unprod_Allocated.length > 0)
						alloc_total=Unprod_Allocated[day];

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(day));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(alloc_total));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(day));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(day));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(alloc_total));
            _bw.write(_wl_block26Bytes, _wl_block26);

			}/*end of requirement display (for)..*/

            _bw.write(_wl_block37Bytes, _wl_block37);
	
			if(Positionwise_Req.size()<=0){
				if(position_code !=null){
					String position_desc="";
					//String sql_possition_desc="select distinct position_desc from am_position  where position_code=? ";
					String sql_possition_desc="select position_desc from am_position_lang_vw where position_code=? and language_id = ? ";
					pstmt_Position_Desc 	= conn.prepareStatement( sql_possition_desc);
					pstmt_Position_Desc.setString(1,position_code);
					pstmt_Position_Desc.setString(2,locale);
					rs_Position_Desc		 					= pstmt_Position_Desc.executeQuery();
					while (rs_Position_Desc != null && rs_Position_Desc.next()){
						position_desc=rs_Position_Desc.getString("position_desc");
					}
					if(pstmt_Position_Desc != null) 
			pstmt_Position_Desc.close() ;

		if(rs_Position_Desc != null) 
			rs_Position_Desc.close() ;


            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(total_days+2));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(position_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);

				} //out.println("<script>alert('no shift found')</script>");
			}
			else{

            _bw.write(_wl_block40Bytes, _wl_block40);
	
				position_record=(String[])Positionwise_Req.get(0);

				for(int position=0;position<Positionwise_Req.size();position++){
					if(position_record != null){
						shift_code=position_record[2];
						if(!posit_code.equals(position_record[0])){

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(position_record[0]));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(position_record[0]));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(total_days+2));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(position_record[1]));
            _bw.write(_wl_block46Bytes, _wl_block46);

							posit_code=position_record[0];	
						}
						Posit_Allocated_Values=new int[total_days];
						Positionwise_Alloc.clear();
						String sql_positionwise_alloc="select a.shift_code,a.week_no,a.day_no, count(shift_mnemonic) allocated from rs_master_schedule a where a.facility_id = ? and a.workplace_code = ? and a.requirement_id = ? and a.position_code = ? and a.shift_code=? group by a.shift_code, a.week_no, a.day_no order by a.shift_code";

						//to get the Positionwise Shiftwise Day Totals Requirements 
						pstmt_Positionwise_Alloc = conn.prepareStatement( sql_positionwise_alloc);
						pstmt_Positionwise_Alloc.setString(1,facility_id);
						pstmt_Positionwise_Alloc.setString(2,workplace_code);
						pstmt_Positionwise_Alloc.setString(3,requirement_id);
						pstmt_Positionwise_Alloc.setString(4,posit_code);
						pstmt_Positionwise_Alloc.setString(5,shift_code);
						rs_Positionwise_Alloc = pstmt_Positionwise_Alloc.executeQuery() ;
						while (rs_Positionwise_Alloc != null && rs_Positionwise_Alloc.next()) {
							week_no	=	Integer.parseInt(rs_Positionwise_Alloc.getString("week_no")==null?"0":rs_Positionwise_Alloc.getString("week_no"));
							if(week_no <= week_count){
								day=Integer.parseInt(rs_Positionwise_Alloc.getString("day_no")==null?"0":rs_Positionwise_Alloc.getString("day_no"));
								day_no=((week_no-1)*7)+day;								Posit_Allocated_Values[day_no-1]=Integer.parseInt(rs_Positionwise_Alloc.getString("allocated")==null?"0":rs_Positionwise_Alloc.getString("allocated"));								Positionwise_Alloc.put(rs_Positionwise_Alloc.getString("shift_code"),Posit_Allocated_Values);
							}
						}
						if(pstmt_Positionwise_Alloc != null) 
			pstmt_Positionwise_Alloc.close() ;

		if(rs_Positionwise_Alloc != null) 
			rs_Positionwise_Alloc.close() ;


            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(position_record[4]));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(position_record[3]));
            _bw.write(_wl_block50Bytes, _wl_block50);
	
						Posit_Allocated_Values=(int[])Positionwise_Alloc.get(shift_code);
						for(week_no=0;week_no<week_count;week_no++){
							Day_Indic=(String[])Day_Indicator.get(week_no);
							for(day_count=0;day_count<Day_Indic.length;day_count++){
								classval="";
								day=(week_no)*7+day_count;
								if(Posit_Allocated_Values != null)
									alloc_val=Posit_Allocated_Values[day];
								else
									alloc_val=0;
								if(Day_Indic[day_count].equalsIgnoreCase("W"))
									req_val=Integer.parseInt(position_record[5]==null?"0":position_record[5]);
								if(Day_Indic[day_count].equalsIgnoreCase("N"))
									req_val=Integer.parseInt(position_record[6]==null?"0":position_record[6]);
								if(Day_Indic[day_count].equalsIgnoreCase("H"))
									req_val=Integer.parseInt(position_record[7]==null?"0":position_record[5]); 

								if(alloc_val < req_val)
									classval="BELOWOPTIMAL";
								if(alloc_val > req_val)
									classval="ABOVEOPTIMAL";
								if(alloc_val == req_val)
									classval="OPTIMAL";
								if((req_val==0)&&(alloc_val == 0))
									classval="ALOCATED";

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(alloc_val));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(req_val));
            _bw.write(_wl_block53Bytes, _wl_block53);

							}
						}

            _bw.write(_wl_block54Bytes, _wl_block54);

						//check for next position
						if((position+1)<Positionwise_Req.size())
							position_record=(String[])Positionwise_Req.get(position+1);
							//if next position found
						if(!posit_code.equals(position_record[0])){
			
							Staff_Data.clear();
							pstmt_Staff_List = conn.prepareStatement( sql_staff_list);
							pstmt_Staff_List.setString(1,facility_id);
							pstmt_Staff_List.setString(2,workplace_code);
							pstmt_Staff_List.setString(3,role_type);
							pstmt_Staff_List.setString(4,role_type);
							pstmt_Staff_List.setString(5,staff_type);
							pstmt_Staff_List.setString(6,staff_type);
							pstmt_Staff_List.setString(7,staff_id);
							pstmt_Staff_List.setString(8,staff_id);
							pstmt_Staff_List.setString(9,facility_id);
							pstmt_Staff_List.setString(10,workplace_code);
							pstmt_Staff_List.setString(11,requirement_id);
							pstmt_Staff_List.setString(12,posit_code);
							pstmt_Staff_List.setString(13,facility_id);
							pstmt_Staff_List.setString(14,workplace_code);
							pstmt_Staff_List.setString(15,requirement_id);
							pstmt_Staff_List.setString(16,posit_code);
							rs_Staff_List = pstmt_Staff_List.executeQuery() ;
							while (rs_Staff_List != null && rs_Staff_List.next()) {
								record = new String[9];		
								week_no=Integer.parseInt(rs_Staff_List.getString("week_no")==null?"0":rs_Staff_List.getString("week_no"));
								if(week_no <= week_count){
									record[0] = rs_Staff_List.getString("role_type") ;
									record[1] = rs_Staff_List.getString("staff_type") ;
									record[2] = rs_Staff_List.getString("staff_id") ;
									record[3] = rs_Staff_List.getString("shift_code") ;
									record[4] = rs_Staff_List.getString("productive_flag") ;
									record[5] = rs_Staff_List.getString("shift_indicator") ;
									record[6] = rs_Staff_List.getString("shift_mnemonic") ;
									record[7] = rs_Staff_List.getString("day_no") ;
									record[8] = rs_Staff_List.getString("week_no") ;
									Staff_Data.add(record);
								}
							}

							if(pstmt_Staff_List != null) 
			pstmt_Staff_List.close() ;

		if(rs_Staff_List != null) 
			rs_Staff_List.close() ;


							prev_staff="";
							if(Staff_Data.size()>0){
								staff_data=(String[])Staff_Data.get(0);
//								role_typ=staff_data[0];
//								staff_typ=staff_data[1];
								staff_id1=staff_data[2];
//								shift_cod=staff_data[3]==null?"":staff_data[3];
								prod_flag=staff_data[4]==null?"":staff_data[4];
								shift_indicator=staff_data[5]==null?"":staff_data[5];
								shift_mnemonic=staff_data[6]==null?"":staff_data[6];
								day_no=Integer.parseInt(staff_data[7]==null?"0":staff_data[7]);
								week_no=Integer.parseInt(staff_data[8]==null?"0":staff_data[8]);
								day_count=0;
								day=0;
								for(int staff=0;staff<Staff_Data.size();staff++){
									if(prod_flag.equals("O"))
										classval="Oncall";
									else
										if(shift_indicator.equals("U"))
										classval="Unproductive";
									else
										classval="master_label";
									if((week_no !=0)&&(day_no !=0))
										day_count=(week_no-1)*7+(day_no-1);
									else 
										day_count=0;
									if(!(prev_staff.equalsIgnoreCase(staff_id1))){
										prev_staff=staff_id1;
										day=0;

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block16Bytes, _wl_block16);

									}
									if((day_count==day)&&(!(shift_mnemonic.equals("")))){
										day++;

            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(shift_mnemonic));
            _bw.write(_wl_block50Bytes, _wl_block50);

									}
									else{
										if(day_count !=0){ 
											for(;day<day_count;day++){

            _bw.write(_wl_block59Bytes, _wl_block59);

											}				

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(shift_mnemonic));
            _bw.write(_wl_block61Bytes, _wl_block61);

											day++;
										}
									}
									if((staff+1 )<Staff_Data.size())
												staff_data=(String[])Staff_Data.get(staff+1);
									staff_id1=staff_data[2];
//									shift_cod=staff_data[3]==null?"":staff_data[3];
									shift_indicator	 =
									prod_flag=staff_data[4]==null?"":staff_data[4];
									shift_indicator=staff_data[5]==null?"":staff_data[5];
									shift_mnemonic=staff_data[6]==null?"":staff_data[6];
									day_no=Integer.parseInt(staff_data[7]==null?"0":staff_data[7]);
									week_no=Integer.parseInt(staff_data[8]==null?"0":staff_data[8]);
									if(!(prev_staff.equals(staff_data[2]))){
										if(day<total_days){
											for(;day<total_days;day++){

            _bw.write(_wl_block62Bytes, _wl_block62);

											}
											day=0;
										}
									}
								}

            _bw.write(_wl_block63Bytes, _wl_block63);
	
								if(day<total_days){
									for(;day<total_days;day++){

            _bw.write(_wl_block64Bytes, _wl_block64);

									}

            _bw.write(_wl_block65Bytes, _wl_block65);

								}
							}
						}
					}
				}

            _bw.write(_wl_block66Bytes, _wl_block66);

				//check for next position
				
				Staff_Data.clear();
				pstmt_Staff_List = conn.prepareStatement( sql_staff_list);
				pstmt_Staff_List.setString(1,facility_id);
				pstmt_Staff_List.setString(2,workplace_code);
				pstmt_Staff_List.setString(3,role_type);
				pstmt_Staff_List.setString(4,role_type);
				pstmt_Staff_List.setString(5,staff_type);
				pstmt_Staff_List.setString(6,staff_type);
				pstmt_Staff_List.setString(7,staff_id);
				pstmt_Staff_List.setString(8,staff_id);
				pstmt_Staff_List.setString(9,facility_id);
				pstmt_Staff_List.setString(10,workplace_code);
				pstmt_Staff_List.setString(11,requirement_id);
				pstmt_Staff_List.setString(12,posit_code);
				pstmt_Staff_List.setString(13,facility_id);
				pstmt_Staff_List.setString(14,workplace_code);
				pstmt_Staff_List.setString(15,requirement_id);
				pstmt_Staff_List.setString(16,posit_code);
				rs_Staff_List = pstmt_Staff_List.executeQuery() ;
				while (rs_Staff_List != null && rs_Staff_List.next()) {
					record = new String[9];		
					week_no=Integer.parseInt(rs_Staff_List.getString("week_no")==null?"0":rs_Staff_List.getString("week_no"));
					if(week_no <= week_count){
						record[0] = rs_Staff_List.getString("role_type") ;
						record[1] = rs_Staff_List.getString("staff_type") ;
						record[2] = rs_Staff_List.getString("staff_id") ;
						record[3] = rs_Staff_List.getString("shift_code") ;
						record[4] = rs_Staff_List.getString("productive_flag") ;
						record[5] = rs_Staff_List.getString("shift_indicator") ;
						record[6] = rs_Staff_List.getString("shift_mnemonic") ;
						record[7] = rs_Staff_List.getString("day_no") ;
						record[8] = rs_Staff_List.getString("week_no") ;

						Staff_Data.add(record);
					}
				}
				if(pstmt_Staff_List != null) 
			pstmt_Staff_List.close() ;

		if(rs_Staff_List != null) 
			rs_Staff_List.close() ;


				prev_staff="";
				if(Staff_Data.size()>0){
					staff_data=(String[])Staff_Data.get(0);
//					role_typ=staff_data[0];
//					staff_typ=staff_data[1];
					staff_id1=staff_data[2];
//					shift_cod=staff_data[3]==null?"":staff_data[3];
					prod_flag=staff_data[4]==null?"":staff_data[4];
					shift_indicator=staff_data[5]==null?"":staff_data[5];
					shift_mnemonic=staff_data[6]==null?"":staff_data[6];
					day_no=Integer.parseInt(staff_data[7]==null?"0":staff_data[7]);
					week_no=Integer.parseInt(staff_data[8]==null?"0":staff_data[8]);

					day_count=0;
					day=0;
					for(int staff=0;staff<Staff_Data.size();staff++){
						if(prod_flag.equals("O"))
							classval="Oncall";
						else
							if(shift_indicator.equals("U"))
							classval="Unproductive";
						else
							classval="master_label";
						if((week_no !=0)&&(day_no !=0))
							day_count=(week_no-1)*7+(day_no-1);
						else 
							day_count=0;
						if(!(prev_staff.equalsIgnoreCase(staff_id1))){
							prev_staff=staff_id1;
							day=0;

            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(posit_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(staff_id1));
            _bw.write(_wl_block16Bytes, _wl_block16);

						}
						if((day_count==day)&&(!(shift_mnemonic.equals("")))){
							day++;

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(shift_mnemonic));
            _bw.write(_wl_block50Bytes, _wl_block50);

						}
						else{ 
							if(day_count !=0){ 
								for(;day<day_count;day++){

            _bw.write(_wl_block70Bytes, _wl_block70);

								}				

            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(shift_mnemonic));
            _bw.write(_wl_block50Bytes, _wl_block50);

								day++;
							}
						}
						if((staff+1 )<Staff_Data.size()){
								staff_data=(String[])Staff_Data.get(staff+1);
						}
						staff_id1=staff_data[2];
//						shift_cod=staff_data[3]==null?"":staff_data[3];
						prod_flag=staff_data[4]==null?"":staff_data[4];
						shift_indicator=staff_data[5]==null?"":staff_data[5];
						shift_mnemonic=staff_data[6]==null?"":staff_data[6];
						day_no=Integer.parseInt(staff_data[7]==null?"0":staff_data[7]);
						week_no=Integer.parseInt(staff_data[8]==null?"0":staff_data[8]);

						if(!(prev_staff.equals(staff_data[2]))){
							if(day<total_days){
								for(;day<total_days;day++){

            _bw.write(_wl_block72Bytes, _wl_block72);

								}
								day=0;
							}
						}
					}

            _bw.write(_wl_block63Bytes, _wl_block63);
	
					if(day<total_days){
						for(;day<total_days;day++){

            _bw.write(_wl_block73Bytes, _wl_block73);

						}

            _bw.write(_wl_block74Bytes, _wl_block74);

					}
				}

            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(totalShifts));
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

				//to display Shift Total data
				for(int shift=0;shift<totalShifts;shift++){
					Shift_Allocated_Values=new int[total_days];
					shift_record=(String[])Shift_Data.get(shift);
					shift_code=shift_record[0];
					//to get the Shiftwise Allocated Total
					String sql_shiftwise_alloc="select a.shift_code,a.week_no,a.day_no, count(shift_mnemonic) allocated from rs_master_schedule a where a.facility_id = ? and a.workplace_code = ? and a.requirement_id = ? and shift_code=? group by a.shift_code,a.week_no,a.day_no order by a.shift_code";
					pstmt_Shiftwise_Alloc = conn.prepareStatement( sql_shiftwise_alloc);
					pstmt_Shiftwise_Alloc.setString(1,facility_id);
					pstmt_Shiftwise_Alloc.setString(2,workplace_code);
					pstmt_Shiftwise_Alloc.setString(3,requirement_id);
					pstmt_Shiftwise_Alloc.setString(4,shift_code);
					rs_Shiftwise_Alloc = pstmt_Shiftwise_Alloc.executeQuery() ;
					while (rs_Shiftwise_Alloc != null && rs_Shiftwise_Alloc.next()) {
						week_no	=	Integer.parseInt(rs_Shiftwise_Alloc.getString("week_no")==null?"0":rs_Shiftwise_Alloc.getString("week_no"));
						if(week_no<=week_count){
							day=Integer.parseInt(rs_Shiftwise_Alloc.getString("day_no")==null?"0":rs_Shiftwise_Alloc.getString("day_no"));
							day_no=((week_no-1)*7)+day;
							Shift_Allocated_Values[day_no-1]=Integer.parseInt(rs_Shiftwise_Alloc.getString("allocated")==null?"0":rs_Shiftwise_Alloc.getString("allocated"));
							Shiftwise_Alloc.put(rs_Shiftwise_Alloc.getString("shift_code"),Shift_Allocated_Values);
						}
					}

					  if(pstmt_Shiftwise_Alloc != null) 
			            pstmt_Shiftwise_Alloc.close() ;
		            	if(rs_Shiftwise_Alloc != null) 
            			rs_Shiftwise_Alloc.close() ;


					if(Shiftwise_Req.containsKey(shift_code))
						shift_req=(String[])Shiftwise_Req.get(shift_code);
					else
						shift_req=null;
					if(Shiftwise_Alloc.containsKey(shift_code))
						Shift_Allocated_Values=(int[])Shiftwise_Alloc.get(shift_code);
					else
						Shift_Allocated_Values=null;

            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(shift_record[2]));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(shift_record[1]));
            _bw.write(_wl_block50Bytes, _wl_block50);

					for(week_no=0;week_no<week_count;week_no++){
						Day_Indic=(String[])Day_Indicator.get(week_no);
						for(day_count=0;day_count<Day_Indic.length;day_count++){

							classval="";
							alloc_val=0;
							req_val=0;
							day=(week_no*7)+day_count;
							if(Shift_Allocated_Values != null)
								alloc_val=Shift_Allocated_Values[day];
							else
								alloc_val=0;
							if(Day_Indic[day_count].equalsIgnoreCase("W")){
								if(shift_req !=null)
									req_val=Integer.parseInt(shift_req[0]==null?"0":shift_req[0]);
								else
									req_val=0;
							} 
							else{
								if(Day_Indic[day_count].equalsIgnoreCase("N")){
									if(shift_req !=null)
										req_val=Integer.parseInt(shift_req[1]==null?"0":shift_req[1]);
									else
										req_val=0;
								}
							}
							if(alloc_val < req_val)
								classval="BELOWOPTIMAL";
							if(alloc_val >req_val)
								classval="ABOVEOPTIMAL";
							if(alloc_val == req_val)
								classval="OPTIMAL";
							if((req_val==0)&&(alloc_val == 0))
								classval="SHIFTTOTAL";

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(alloc_val));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(req_val));
            _bw.write(_wl_block53Bytes, _wl_block53);

						}
					}

            _bw.write(_wl_block81Bytes, _wl_block81);

				}
			}

            _bw.write(_wl_block82Bytes, _wl_block82);
	
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	}
	finally {
		if(pstmt_Req_Total != null) 
		pstmt_Req_Total.close() ;

		if(pstmt_Alloc_Total != null) 
			pstmt_Alloc_Total.close() ;

		if(pstmt_Shiftwise_Req != null) 
			pstmt_Shiftwise_Req.close() ;

		if(pstmt_Positionwise_Req != null) 
			pstmt_Positionwise_Req.close() ;

		if(pstmt_Shiftwise_Alloc != null) 
			pstmt_Shiftwise_Alloc.close() ;

		if(pstmt_Positionwise_Alloc != null) 
			pstmt_Positionwise_Alloc.close() ;

		if(pstmt_Day_Indicator != null) 
			pstmt_Day_Indicator.close() ;

		if(pstmt_Staff_List != null) 
			pstmt_Staff_List.close() ;

		if(pstmt_WeekDays != null) 
			pstmt_WeekDays.close() ;

		if(rs_WeekDays != null) 
			rs_WeekDays.close() ;

		if(rs_Req_Total != null) 
			rs_Req_Total.close() ;

		if(rs_Alloc_Total != null) 
			rs_Alloc_Total.close() ;

		if(rs_Shiftwise_Req != null) 
			rs_Shiftwise_Req.close() ;

		if(rs_Positionwise_Req != null) 
			rs_Positionwise_Req	.close() ;

		if(rs_Shiftwise_Alloc != null) 
			rs_Shiftwise_Alloc.close() ;

		if(rs_Positionwise_Alloc != null) 
			rs_Positionwise_Alloc	.close() ;

		if(rs_Day_Indicator != null) 
			rs_Day_Indicator.close() ;

		if(rs_Staff_List != null) 
			rs_Staff_List.close() ;

		ConnectionManager.returnConnection(conn,request);

	}

            _bw.write(_wl_block83Bytes, _wl_block83);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.WorkingShift.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.OncallShift.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.UnproductiveShift.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SHIFT.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
}
