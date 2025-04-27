package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCommon.Common.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __gcpgenerateplantypebottom extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/GCPGeneratePlanTypeBottom.jsp", 1709116589746L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\t\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/common.js\'></Script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/ValidateControl.js\'></Script>\n\t<script language=\"JavaScript\" src=\"../../eCP/js/GCPGenerateCarePlan.js\"></script>\n<SCRIPT LANGUAGE=\"JavaScript\">\n<!--\n\n function scrollTitle()\n{\n\t   var scrollXY = document.body.scrollTop;\n\t  if(scrollXY == 0)\n\t  {\n\t\t\t\t\tdocument.getElementById(\"LibraryDetailTitle\").style.position = \'static\';\n\t\t\t\t\tdocument.getElementById(\"LibraryDetailTitle\").style.posTop  = 0;\n\t  }\n\t  else\n\t  {\n\t\t\t\tdocument.getElementById(\"LibraryDetailTitle\").style.position = \'relative\';\n\t\t\t\tdocument.getElementById(\"LibraryDetailTitle\").style.posTop  = scrollXY;\n\t }\n}\n//-->\n\n</SCRIPT>\t\n</head>\n\n<body OnMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\" Onload=\'\' onscroll=\'scrollTitle()\'>\n<script language=\'javascript\'>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<form name=\"generate_lib_details\" id=\"generate_lib_details\"  method =\'post\' target=\'messageFrame\' action=\'../../servlet/eCP.GCPGeneratePlanServlet\'>\n<div id=\'LibraryDetailTitle\' style=\'postion:relative\'>\t\n<table border=\'0\' cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' align=\'center\'>\n\t<tr>\n\t\t<th align=\'\'> ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" </th>\n\t</tr>\n</table>\n</div>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<table border=\'1\' cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' height=\'\' align=\'center\'>\n<tr>\t\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<td colspan=\'2\' height=\'1%\' align=\'left\' class=\'label\'><font size=\"1\"><b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b></font></td>\n\t\t\t</tr><tr><td colspan=\'2\' height=\'1%\' align=\'left\' class=\'label\'>&nbsp;&nbsp;<font size=\"1\"><b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</b></font></td>\n\t\n\t<input type =\'hidden\' name=\'termset_id";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' id=\'termset_id";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t<input type =\'hidden\' name=\'termset_id\' id=\'termset_id\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t<input type =\'hidden\' name=\'termset_desc";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' id=\'termset_desc";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t\t\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</tr><tr><td colspan=\'2\' height=\'.5%\' align=\'left\' class=\'label\'>&nbsp;&nbsp;<input type=\"checkbox\" name=\'chk_termcode";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'chk_termcode";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' checked onClick=\"chkValid(";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =",";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =")\" value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'><font size=\"1\"><b>&nbsp;&nbsp;";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</b></font></td>\n\t\t<input type =\'hidden\' name=\'termcode_id";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'termcode_id";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'> \t\t\n\t\t<input type =\'hidden\' name=\'termcode_desc";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'termcode_desc";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t<input type =\'hidden\' name=\'chk_libdetails";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'chk_libdetails";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</tr><tr><td colspan=\'2\' height=\'1%\' align=\'left\' class=\'CAGROUPHEADING\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><font size=\"1\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n&nbsp;(&nbsp;";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&nbsp;)</font></b></td>\n\t\t\t<input type =\'hidden\' name=\'outcomecode_id";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'outcomecode_id";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\t\n\t\t\t<input type =\'hidden\' name=\'care_plan_start_date\' id=\'care_plan_start_date\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t<input type =\'hidden\' name=\'care_plan_end_date\' id=\'care_plan_end_date\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\t<input type =\'hidden\' name=\'target_date\' id=\'target_date\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t<input type =\'hidden\' name=\'outcomecode_desc";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'outcomecode_desc";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t<tr>\n\t\t\n\t<td height=\'1%\' class=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' align=\'right\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"checkbox\" name=\'chk_libdetails";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' checked onClick=\'chkValidate(";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =")\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' ></td>\n\t<td height=\'1%\'  class=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'> &nbsp;<font size=\"1\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\t</font> \t\t\t\n\t</td>\n\t</tr>\n<input type =\'hidden\' name=\'intervention_code";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'intervention_code";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n<input type =\'hidden\' name=\'intervention_type";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' id=\'intervention_type";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n<input type =\'hidden\' name=\'freq_code";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'freq_code";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n<input type =\'hidden\' name=\'duration";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' id=\'duration";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n<input type =\'hidden\' name=\'durn_type";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' id=\'durn_type";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n<input type =\'hidden\' name=\'start_date";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' id=\'start_date";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n<input type =\'hidden\' name=\'end_date";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'end_date";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\t\t\t\n</table>\n<input type =\'hidden\' name=\'chk_libdetails";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n<input type =\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\t\n<input type =\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n<input type =\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n<input type =\'hidden\' name=\'casetype_code\' id=\'casetype_code\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n<input type =\'hidden\' name=\'lib_short_desc\' id=\'lib_short_desc\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n<input type =\'hidden\' name=\'library_code\' id=\'library_code\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n<input type =\'hidden\' name=\'version_no\' id=\'version_no\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n<input type =\'hidden\' name=\'query_str\' id=\'query_str\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n\n\n<input type =\'hidden\' name=\'libdetailvalue\' id=\'libdetailvalue\' value=\'\'>\n<input type =\'hidden\' name=\'intervention_code\' id=\'intervention_code\' value=\'\'>\n<input type =\'hidden\' name=\'sql\' id=\'sql\' value=\'\'>\t\n<input type =\'hidden\' name=\'x\' id=\'x\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\t\n<input type =\'hidden\' name=\'j\' id=\'j\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\t\n<input type =\'hidden\' name=\'i\' id=\'i\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\t\n</form>\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

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

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

  
Connection con = null;
PreparedStatement ps = null;
ResultSet rs = null;


String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");	
//out.println("<script>alert('patient_id:::"+patient_id+",encounter_id:::"+encounter_id+"')</script>");	
String casetype_code = request.getParameter("casetype_code") == null ? "" : request.getParameter("casetype_code");
//out.println("<script>alert('casetype_code:::"+casetype_code+"--')</script>");	
String lib_short_desc = request.getParameter("lib_short_desc") == null ? "" : request.getParameter("lib_short_desc");
String library_code = request.getParameter("library_code") == null ? "" : request.getParameter("library_code");
String version_no = request.getParameter("version_no") == null ? "" : request.getParameter("version_no");

//	out.println("<script>alert('library_code:::"+library_code+",version_no:::"+version_no+"')</script>");
String mode = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
mode = "insert";
//	out.println("<script>alert('mode:::"+mode+"--')</script>");
String sql = "";
String classValue="";
String termset="",termset1="";
String termcode="",termcode1="";
String outcomecode="",outcomecode1="";
int i=0,j=0,k=0,x=0;
try
{    
	
	con = ConnectionManager.getConnection(request);
	sql = "SELECT a.LIBRARY_ID,a.VERSION_NO ,a.TERM_SET_ID ,b.Term_Set_Desc Term_Set_Description ,a.TERM_CODE ,c.Short_desc Term_Code_Description ,c.Short_desc Term_Code_Description,a.OUTCOME_CODE ,F.Short_desc Outcome_Description,a.INTERVENTION_CODE ,a.INTERVENTION_TYPE ,a.SEQ_NO  ,a.REL_START_PERIOD,a.REL_START_PERIOD_UNIT,a.FREQ_CODE ,a.FREQ_DURN,a.FREQ_DURN_UNIT ,a.DEPENDENCY_LEVEL ,a.ALT_INTERVENTION_CODE ,a.STAGE_CODE ,a.ACCURACY_INDICATOR,Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),To_Char(SYSDATE,'DD/MM/YYYY HH24:MI'))  Start_Date_Time,to_char(to_date(Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),                               'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),			       'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),			       'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),        			       'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),			       To_Char(SYSDATE,'DD/MM/YYYY HH24:MI')),'DD/MM/YYYY hh24:mi')  + (Decode(a.FREQ_DURN_UNIT,'D',a.FREQ_DURN,'H',a.FREQ_DURN/24,'M',a.FREQ_DURN/1440,'W',a.FREQ_DURN*7,'L',a.FREQ_DURN *30)),'DD/MM/YYYY HH24:MI') End_Date_Time ,'<font color=black><b>' || D.Short_Desc ||'</b></font>' || '  Frequency : ' || E.Freq_Desc || ' For '  || a.Freq_Durn || ' ' || g.durn_desc || ' Start Date : ' || Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),                               'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),			       'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),			       'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),        			       'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),			       To_Char(SYSDATE,'DD/MM/YYYY HH24:MI'))   ||  ' End Date :' || to_char(to_date(Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),                               'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),			       'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),			       'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),        			       'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),			       To_Char(SYSDATE,'DD/MM/YYYY HH24:MI')),'DD/MM/YYYY hh24:mi')  + 			       (Decode(a.FREQ_DURN_UNIT,'D',a.FREQ_DURN,'H',a.FREQ_DURN/24,'M',a.FREQ_DURN/1440,'W',a.FREQ_DURN*7,'L',a.FREQ_DURN *30)),'DD/MM/YYYY HH24:MI')     Build_Diagonis_Intervention,to_char(decode(OUTCOME_TARGET_DURN_UNIT,'D',(select to_date(max(to_char(to_date(Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),                               'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),      			       'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),To_Char(SYSDATE,'DD/MM/YYYY HH24:MI')),'DD/MM/YYYY hh24:mi')  + (Decode(a.FREQ_DURN_UNIT,'D',a.FREQ_DURN,'H',a.FREQ_DURN/24,'M',a.FREQ_DURN/1440,'W',a.FREQ_DURN*7,'L',a.FREQ_DURN *30)),'DD/MM/YYYY HH24:MI') ),'DD/MM/YYYY HH24:MI')  Max_End_Date_Time from CP_INTERVENTION_FOR_OUTCOME A,CP_OUTCOME_FOR_TERM_CODE H where a.term_set_id = h.term_set_id and   a.term_code   = h.term_code and   a.outcome_code = H.outcome_code and   a.library_id = H.LIBRARY_ID and   a.version_no = h.VERSION_NO)+OUTCOME_TARGET_DURN,'H',(select to_date(max(to_char(to_date(Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'), 'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'), To_Char(SYSDATE,'DD/MM/YYYY HH24:MI')),'DD/MM/YYYY hh24:mi')  + (Decode(a.FREQ_DURN_UNIT,'D',a.FREQ_DURN,'H',a.FREQ_DURN/24,'M',a.FREQ_DURN/1440,'W',a.FREQ_DURN*7,'L',a.FREQ_DURN *30)),'DD/MM/YYYY HH24:MI') ),'DD/MM/YYYY HH24:MI')  Max_End_Date_Time from CP_INTERVENTION_FOR_OUTCOME A,CP_OUTCOME_FOR_TERM_CODE H where a.term_set_id = h.term_set_id and   a.term_code   = h.term_code and   a.outcome_code = H.outcome_code and   a.library_id = H.LIBRARY_ID and   a.version_no = h.VERSION_NO)+(OUTCOME_TARGET_DURN/24),'M',(select to_date(max(to_char(to_date(Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'), 'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),To_Char(SYSDATE,'DD/MM/YYYY HH24:MI')),'DD/MM/YYYY hh24:mi')  + (Decode(a.FREQ_DURN_UNIT,'D',a.FREQ_DURN,'H',a.FREQ_DURN/24,'M',a.FREQ_DURN/1440,'W',a.FREQ_DURN*7,'L',a.FREQ_DURN *30)),'DD/MM/YYYY HH24:MI') ),'DD/MM/YYYY HH24:MI')  Max_End_Date_Time from CP_INTERVENTION_FOR_OUTCOME A,CP_OUTCOME_FOR_TERM_CODE H  where a.term_set_id = h.term_set_id and   a.term_code   = h.term_code and   a.outcome_code = H.outcome_code and   a.library_id = H.LIBRARY_ID and   a.version_no = h.VERSION_NO)+(OUTCOME_TARGET_DURN/1440),'W',(select to_date(max(to_char(to_date(Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'), 'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'), 'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),To_Char(SYSDATE,'DD/MM/YYYY HH24:MI')),'DD/MM/YYYY hh24:mi')  + (Decode(a.FREQ_DURN_UNIT,'D',a.FREQ_DURN,'H',a.FREQ_DURN/24,'M',a.FREQ_DURN/1440,'W',a.FREQ_DURN*7,'L',a.FREQ_DURN *30)),'DD/MM/YYYY HH24:MI') ),'DD/MM/YYYY HH24:MI')  Max_End_Date_Time from CP_INTERVENTION_FOR_OUTCOME A,CP_OUTCOME_FOR_TERM_CODE H where a.term_set_id = h.term_set_id and   a.term_code   = h.term_code and   a.outcome_code = H.outcome_code and   a.library_id = H.LIBRARY_ID and   a.version_no = h.VERSION_NO)+(OUTCOME_TARGET_DURN*7), 'L', (select to_date(max(to_char(to_date(Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'), 'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'), 'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'), 'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),  'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'), To_Char(SYSDATE,'DD/MM/YYYY HH24:MI')),'DD/MM/YYYY hh24:mi')  +  (Decode(a.FREQ_DURN_UNIT,'D',a.FREQ_DURN,'H',a.FREQ_DURN/24,'M',a.FREQ_DURN/1440,'W',a.FREQ_DURN*7,'L',a.FREQ_DURN *30)),'DD/MM/YYYY HH24:MI') ),'DD/MM/YYYY HH24:MI')  Max_End_Date_Time from CP_INTERVENTION_FOR_OUTCOME A,CP_OUTCOME_FOR_TERM_CODE H  where a.term_set_id = h.term_set_id  and   a.term_code   = h.term_code  and   a.outcome_code = H.outcome_code and   a.library_id = H.LIBRARY_ID and   a.version_no = h.VERSION_NO)+(OUTCOME_TARGET_DURN*30)),'dd/mm/yyyy hh24:mi') OutCome_Target_Date,Decode(a.FREQ_DURN_UNIT,'D','Days','H','Hours','M','Minutes','L','Months','W','Weeks','') Freq_legend,D.Short_Desc Intervention_Desc FROM	CP_INTERVENTION_FOR_OUTCOME A,MR_TERM_SET B,MR_TERM_CODE C,	CA_INTERVENTION D,AM_FREQUENCY E,CP_OUTCOME F,AM_DURATION_TYPE G, CP_OUTCOME_FOR_TERM_CODE H WHERE a.LIBRARY_ID = ? AND a.VERSION_NO = ? and   a.term_set_id = b.term_Set_id and   a.term_set_id = c.term_set_id and   a.term_code   = c.term_code and   a.term_set_id = h.term_set_id and   a.term_code   = h.term_code and   a.library_id = H.LIBRARY_ID and   a.version_no = h.VERSION_NO and   a.outcome_code = H.outcome_code and   a.intervention_code = d.intervention_Code and   a.intervention_type = 'I' and   a.freq_code = e.freq_Code (+) and   a.freq_durn_Unit = g.durn_type (+) and   a.outcome_Code = f.outcome_code  Order by a.TERM_SET_ID,a.TERM_CODE,a.outcome_code,a.SEQ_NO  ";
	ps = con.prepareStatement(sql);
	ps.setString(1,library_code.trim());
	ps.setString(2,version_no.trim());
	rs = ps.executeQuery();

            _bw.write(_wl_block10Bytes, _wl_block10);

	while(rs.next())
	{
		termset =rs.getString(3);
		
		if(!termset.equals(termset1)){
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(lib_short_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
out.println(rs.getString(4));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(x));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(x));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(3)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rs.getString(3)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(x));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(x));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(4)));
            _bw.write(_wl_block19Bytes, _wl_block19);
		termset1=termset;			
		x++;	}	termcode =rs.getString(5);
		
			if(!termcode.equals(termcode1)){
				
				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString(5)));
            _bw.write(_wl_block25Bytes, _wl_block25);
out.println(rs.getString(6));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(j));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(5)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(j));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(6)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(j));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(k));
            _bw.write(_wl_block32Bytes, _wl_block32);
	termcode1=termcode;
			k=0;
			//out.println("<script>alert('chk_libdetails"+j+"----k=="+k+"')</script>");			
			}
			outcomecode =rs.getString(5);
			
			if(!outcomecode.equals(outcomecode1)){
			
					
            _bw.write(_wl_block33Bytes, _wl_block33);
out.println(rs.getString(9));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
out.println(rs.getString(25));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(j));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(8)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rs.getString(22)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rs.getString(23)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rs.getString(25)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(j));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(9)));
            _bw.write(_wl_block43Bytes, _wl_block43);
	outcomecode1=outcomecode;			
			j++;	}
		
		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;
	
	//out.println("<script>alert('chk_libdetails"+k+j+"')</script>");
	
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(k));
            out.print( String.valueOf(j));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(k));
            out.print( String.valueOf(j));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(k));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(rs.getString(10)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
out.println(rs.getString(24));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(k));
            out.print( String.valueOf(j));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(k));
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(10)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(k));
            out.print( String.valueOf(j));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(k));
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(11)));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(k));
            out.print( String.valueOf(j));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(k));
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(15)));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(k));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(k));
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(16)));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(k));
            out.print( String.valueOf(j));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(k));
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(17)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(k));
            out.print( String.valueOf(j));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(k));
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(22)));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(k));
            out.print( String.valueOf(j));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(k));
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(23)));
            _bw.write(_wl_block64Bytes, _wl_block64);

	i++;k++;	
}	//out.println("<script>alert('chk_libdetails"+j+"----k=="+k+"')</script>");k=0;

	if(rs != null) rs.close();
	if(ps != null) ps.close();

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(j));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(j));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(k));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(casetype_code));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(lib_short_desc));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(library_code));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(version_no));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(x));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(j));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);

}
catch(Exception ee)
{
	out.println("Exception in Library Details Module "+ee.toString());
}
finally
{
	try{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) ConnectionManager.returnConnection(con);
	}
	catch(Exception e){
		//out.println(e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
		}
}


            _bw.write(_wl_block78Bytes, _wl_block78);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.LibraryDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.OutcomeTargetDate.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
