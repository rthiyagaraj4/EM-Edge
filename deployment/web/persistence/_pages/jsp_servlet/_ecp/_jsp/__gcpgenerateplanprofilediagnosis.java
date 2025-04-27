package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;

public final class __gcpgenerateplanprofilediagnosis extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/GCPGeneratePlanProfileDiagnosis.jsp", 1742797882340L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\t\n\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language =\"JavaScript\" src =\'../../eCommon/js/common.js\'></Script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/ValidateControl.js\'></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCP/js/GCPGenerateCarePlan.js\"></script>\n\t\n<SCRIPT LANGUAGE=\"JavaScript\">\n<!--\n var tmp_count = new Array();\nvar xx=0;\nvar term_code_arr\t\t= new Array();\nvar termset_id_arr\t\t= new Array();\nvar tmp_termset_id\t\t= new Array();\nvar tmp_term_code\t\t= new Array();\nvar tmp_man_yn\t\t\t= new Array();\n\n function scrollTitle()\n{\n\tvar scrollXY = document.body.scrollTop;\n\tif(scrollXY == 0)\n\t{\n\t\tdocument.getElementById(\'DiagnosisTitle\').style.position = \'static\';\n\t\tdocument.getElementById(\'DiagnosisTitle\').style.posTop  = 0;\n\t}else{\n\t\tdocument.getElementById(\'DiagnosisTitle\').style.position = \'relative\';\n\t\tdocument.getElementById(\'DiagnosisTitle\').style.posTop  = scrollXY;\n\t}\n}\n\n//-->\n</SCRIPT>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\" Onload=\'\' onscroll=\'scrollTitle()\'>\n<script language=\'javascript\'>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<form name=\"generate_diagnosis\" id=\"generate_diagnosis\"  method =\'post\' target=\'\' action=\'\'>\n<div id=\'DiagnosisTitle\' style=\'postion:relative\'>\t\n<table border=\'1\' cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' align=\'center\'>\n\t<tr>\n\t\t<th colspan=\'7\' align=\'left\' class=\'PLANHEAD\'><font size=\"1.5\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</font></th>\n\t</tr>\n\t<tr>\n\t\t<th colspan=\'\' align=\'left\' class=\'PLANSUBHEAD\' width=\'52.9%\' height=\'1\'><font size=\"1\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</font></th>\n\t\t<th colspan=\'\' class=\'PLANSUBHEAD\' width=\'7.2%\' height=\'1\'><font size=\"1\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</font></th>\n\t\t<th colspan=\'\' class=\'PLANSUBHEAD\' width=\'8.2%\' height=\'1\'><font size=\"1\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</font></th>\n\t\t<th colspan=\'\' class=\'PLANSUBHEAD\' width=\'5%\' height=\'1\'><font size=\"1\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</font></th>\t\n\t\t<th colspan=\'\' class=\'PLANSUBHEAD\' width=\'9%\' height=\'1\'><font size=\"1\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</font></th>\n\t\t<th colspan=\'\' class=\'PLANSUBHEAD\' width=\'2%\' height=\'1\'><font size=\"1\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</font></th> \n\t</tr>\n</table>\n</div>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="<table border=\'0\' cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' align=\'center\' >\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\'\' class=\'CAGROUPHEADING\' height=\'1%\' width=\'2%\' onClick=\'showTermCode(";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =")\' id=\'trmCode_tree";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' align=\'center\'><font size=\"1\" color=\'#6633FF\'><B>--</B></font></td>\n\t\t\t\t\t<td colspan=\'7\' class=\'CAGROUPHEADING\' height=\'1%\' width=\'99%\'><font size=\"1\" >&nbsp;";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</font></td>\n\t\t\t\t</tr>\n\t\t\t</table> \n\t\t\t<table border=\'0\' cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' align=\'center\' id=\'term_cd";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' style=\'display:inline\' >\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\n\t\t<tr >\n\t\t\t<td height=\'1%\' width=\'2%\' class=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'  onClick=\'showFactor(";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =")\' id=\'factCode_tree";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' align=\'center\'><font size=\"1\" color=\'#6633FF\'><B>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</B></font></td>\n\t\t\t<td height=\'1\'  width=\'52.9%\'class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'><font size=\"1\" color=\"\" >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</font></td>\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<td height=\'1\'  width=\'7%\' class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' align=\'left\'><font size=\"1\" color=\"\" >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</font></td>\n\t\t\t<td height=\'1\'  width=\'8.2%\' class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</font></td>\n\t\t\t<td height=\'1\'  width=\'4%\' class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</font></td>\n\t\t\t<td height=\'1\'  width=\'9%\' class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' align=\'center\'><font size=\"1\" color=\"\" >";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</font></td>\n\t\t\t<td height=\'1\' width=\'3.8%\' class=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' align=\'center\'><input type=\"checkbox\" name=\'chk_diag";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'chk_diag";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' onClick=\'populateLibrary1(";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =")\' ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="></td>\n\t\t</tr>\n\t\t<input type =\'hidden\' name=\'termset_id";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'termset_id";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t<input type =\'hidden\' name=\'term_code";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'term_code";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t<input type =\'hidden\' name=\'term_code_desc";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'term_code_desc";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t<input type =\'hidden\' name=\'encounterId";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'encounterId";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\n\t\t<tr>\n\t\t\t<td colspan=\'7\' class=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' >\n\t\t\t\t<table border=\'0\' cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' align=\'center\'  id=\'factor";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' style=\'display:none\' >\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\'2\' class=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' width=\'3%\'>&nbsp;</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td colspan=\'5\' class=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' width=\'70%\'><font size=\"1\" ><B>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="<font size=\"1\" color=\'navy\'>&nbsp;";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</font></B></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\'4\' class=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' width=\'10%\'>&nbsp;</td>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' colspan=\'3\' width=\'70%\'><font size=\"1\"><B>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="&nbsp;<font size=\"1\" color=\'navy\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</font></B></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n</table>\n<input type =\'hidden\' name=\'i\' id=\'i\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n<input type =\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n<input type =\'hidden\' name=\'queryStr\' id=\'queryStr\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n<input type =\'checkbox\' name=\'chk_diag\' id=\'chk_diag\' style=\'display:none\'>\n</form>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

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
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
05/06/2024   60772      Twinkle Shah    05/06/2024	    Ramesh Goli      MMS-JU-SCF-0267
--------------------------------------------------------------------------------------------------------
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
            eCP.GCPGeneratePlanBean GCPGenerateBean= null;synchronized(session){
                GCPGenerateBean=(eCP.GCPGeneratePlanBean)pageContext.getAttribute("GCPGenerateBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(GCPGenerateBean==null){
                    GCPGenerateBean=new eCP.GCPGeneratePlanBean();
                    pageContext.setAttribute("GCPGenerateBean",GCPGenerateBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
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

//String p_called_from_ca		= (String)request.getParameter("p_called_from_ca ");
String patient_id			= (String)request.getParameter("patient_id");
String encounter_id			= (String)request.getParameter("episode_id");
String encounterId		= request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");
//String facility_id			= (String) session.getAttribute("facility_id") == null?"" :(String) session.getAttribute("facility_id");

String patient_class			= (String)request.getParameter("patient_class");
//String case_type_code			= (String)request.getParameter("casetype_code");
if(patient_id ==null)
	patient_id = "";
if(encounter_id ==null)
	encounter_id = "";

Connection con = null;
PreparedStatement pstmt = null,pstmt1 = null;
ResultSet rs = null,rs1 = null;

String  classValue = "",priorValue="";
//String readOnly = "readOnly";
//String mode = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
String sql = "",sql1 = "";
String term_set_id1="";String term_set_id ="";//String  term_code = "";
String checked="",disabled="";String Priority="",tmp_priority="";
String build_dc="",build_rs="";String factTree="";
int i=0;
try
{    
	//eCP.GCPGeneratePlanBean bean	= (eCP.GCPGeneratePlanBean)session.getAttribute("GCPGenerateBean");	
	
	con = ConnectionManager.getConnection(request);
//	sql = "SELECT A.OCCUR_SRL_NO, A.TERM_SET_ID, B.TERM_SET_DESC, A.TERM_CODE, C.SHORT_DESC TERM_SHORT_DESC, DECODE(A.CURR_NATURE,'A' ,'Actual','P','Potential','W','Wellness') NATURE, A.CURR_ACCURACY_CODE, D.SHORT_DESC ACCURACY_SHORT_DESC, A.CURR_PRIORITY,  TO_CHAR(A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE_STR FROM PR_DIAGNOSIS A, MR_TERM_SET B, MR_TERM_CODE C, MR_ACCURACY D WHERE A.PATIENT_ID = ? AND A.CURR_STATUS  ='A' AND EXISTS ( SELECT 1 FROM CP_PARAMETER WHERE ACCURACY_FOR_CARE_PLANS = A.CURR_ACCURACY_IND OR ACCURACY_FOR_CARE_PLANS ='B' ) AND B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE  =A.TERM_CODE AND D.ACCURACY_CODE=A.CURR_ACCURACY_CODE AND NOT EXISTS (SELECT 1 FROM PR_DIFFERENTIAL_DIAGNOSIS WHERE PATIENT_ID=A.PATIENT_ID AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE=A.TERM_CODE AND OCCUR_SRL_NO=A.OCCUR_SRL_NO AND FINALIZED_YN='N') AND NOT EXISTS (SELECT 1 FROM CP_PAT_CARE_PLAN_TERM_CODE IA, CP_PAT_CARE_PLAN IB WHERE IB.MD_CARE_PLAN_ID=IA.MD_CARE_PLAN_ID AND IB.CARE_PLAN_ID=IA.CARE_PLAN_ID AND IB.CURRENT_STATUS IN ('O','F') AND IA.PATIENT_ID=A.PATIENT_ID AND IA.TERM_SET_ID=A.TERM_SET_ID AND IA.TERM_CODE=A.TERM_CODE AND IA.STATUS='O' ) ORDER BY 2 ";
//	sql = "SELECT A.OCCUR_SRL_NO, A.TERM_SET_ID, B.TERM_SET_DESC, A.TERM_CODE, C.SHORT_DESC TERM_SHORT_DESC, DECODE(A.CURR_NATURE,'A' ,'Actual','P','Potential','W','Wellness') NATURE, A.CURR_ACCURACY_CODE, D.SHORT_DESC ACCURACY_SHORT_DESC, A.CURR_PRIORITY,  TO_CHAR(A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE_STR FROM PR_DIAGNOSIS A, MR_TERM_SET B, MR_TERM_CODE C, MR_ACCURACY D WHERE A.PATIENT_ID = ? AND A.CURR_STATUS  ='A' AND EXISTS ( SELECT 1 FROM CP_PARAMETER WHERE ACCURACY_FOR_CARE_PLANS = A.CURR_ACCURACY_IND OR ACCURACY_FOR_CARE_PLANS ='B' ) AND B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE  =A.TERM_CODE AND D.ACCURACY_CODE=A.CURR_ACCURACY_CODE AND NOT EXISTS (SELECT 1 FROM CP_PAT_CARE_PLAN_TERM_CODE IA, CP_PAT_CARE_PLAN IB WHERE IB.MD_CARE_PLAN_ID=IA.MD_CARE_PLAN_ID AND IB.CARE_PLAN_ID=IA.CARE_PLAN_ID AND IB.CURRENT_STATUS IN ('O','F') AND IA.PATIENT_ID=A.PATIENT_ID AND IA.TERM_SET_ID=A.TERM_SET_ID AND IA.TERM_CODE=A.TERM_CODE AND IA.STATUS='O' ) ORDER BY 2 ";
	//sql = "SELECT A.OCCUR_SRL_NO, A.TERM_SET_ID, B.TERM_SET_DESC, A.TERM_CODE, C.SHORT_DESC TERM_SHORT_DESC, A.CURR_NATURE NATURE, A.CURR_ACCURACY_CODE, D.SHORT_DESC ACCURACY_SHORT_DESC, A.CURR_PRIORITY,  TO_CHAR(A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE_STR FROM PR_DIAGNOSIS A, MR_TERM_SET B, MR_TERM_CODE C, MR_ACCURACY_LANG_VW D WHERE A.PATIENT_ID = ? AND A.CURR_STATUS  ='A' AND EXISTS ( SELECT 1 FROM CP_PARAMETER WHERE ACCURACY_FOR_CARE_PLANS = A.CURR_ACCURACY_IND OR ACCURACY_FOR_CARE_PLANS ='B' ) AND B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE  =A.TERM_CODE AND D.ACCURACY_CODE=A.CURR_ACCURACY_CODE AND NOT EXISTS (SELECT 1 FROM CP_PAT_CARE_PLAN_TERM_CODE IA, CP_PAT_CARE_PLAN IB WHERE IB.MD_CARE_PLAN_ID=IA.MD_CARE_PLAN_ID AND IB.CARE_PLAN_ID=IA.CARE_PLAN_ID AND IB.CURRENT_STATUS IN ('O','F') AND IA.PATIENT_ID=A.PATIENT_ID AND IA.TERM_SET_ID=A.TERM_SET_ID AND IA.TERM_CODE=A.TERM_CODE AND IA.STATUS='O' ) AND D.LANGUAGE_ID = ? ORDER BY 2 "; //60772
	sql = "SELECT A.OCCUR_SRL_NO, A.TERM_SET_ID, B.TERM_SET_DESC, A.TERM_CODE, C.SHORT_DESC TERM_SHORT_DESC, A.CURR_NATURE NATURE, A.CURR_ACCURACY_CODE, D.SHORT_DESC ACCURACY_SHORT_DESC, A.CURR_PRIORITY,  TO_CHAR(A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE_STR , a.onset_encounter_id FROM PR_DIAGNOSIS A, MR_TERM_SET B, MR_TERM_CODE C, MR_ACCURACY_LANG_VW D WHERE A.PATIENT_ID = ? AND A.CURR_STATUS  ='A' AND  A.OCCUR_SRL_NO=( Select Max(e.occur_srl_no)  from pr_diagnosis e where e.TERM_SET_ID=a.term_set_id AND e.TERM_CODE=a.term_code AND e.patient_id = a.patient_id AND e.curr_status = a.curr_status) AND EXISTS ( SELECT 1 FROM CP_PARAMETER WHERE ACCURACY_FOR_CARE_PLANS = A.CURR_ACCURACY_IND OR ACCURACY_FOR_CARE_PLANS ='B' ) AND B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE  =A.TERM_CODE AND D.ACCURACY_CODE=A.CURR_ACCURACY_CODE AND NOT EXISTS (SELECT 1 FROM CP_PAT_CARE_PLAN_TERM_CODE IA, CP_PAT_CARE_PLAN IB WHERE IB.MD_CARE_PLAN_ID=IA.MD_CARE_PLAN_ID AND IB.CARE_PLAN_ID=IA.CARE_PLAN_ID AND IB.CURRENT_STATUS IN ('O','F') AND IA.PATIENT_ID=A.PATIENT_ID AND IA.TERM_SET_ID=A.TERM_SET_ID AND IA.TERM_CODE=A.TERM_CODE AND IA.STATUS='O' ) AND D.LANGUAGE_ID = ? ORDER BY 2 ";  //60772

	sql1 = "SELECT A.FACTOR_CODE,  A.FACTOR_TYPE,  B.SHORT_DESC FACTOR_SHORT_DESC FROM PR_DIAGNOSIS_EVIDENCE A,MR_FACTOR B WHERE A.PATIENT_ID=? AND A.TERM_SET_ID=? AND A.TERM_CODE=? AND A.OCCUR_SRL_NO=? AND A.STATUS_SRL_NO=(SELECT MAX(STATUS_SRL_NO) FROM PR_DIAGNOSIS_EVIDENCE WHERE PATIENT_ID=A.PATIENT_ID AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE=A.TERM_CODE AND OCCUR_SRL_NO=A.OCCUR_SRL_NO ) AND B.FACTOR_CODE=A.FACTOR_CODE ORDER BY  A.FACTOR_TYPE , B.SHORT_DESC ";

	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, patient_id.trim());
	pstmt.setString(2, locale);

	rs = pstmt.executeQuery();

	pstmt1 = con.prepareStatement(sql1);
	

            _bw.write(_wl_block16Bytes, _wl_block16);

	while(rs.next())
	{	
		term_set_id =rs.getString(2);
		
		out.println("<script>termset_id_arr["+i+"]='"+rs.getString(2)+"';</script>");	
		out.println("<script>term_code_arr["+i+"]='"+rs.getString(4)+"';</script>");	
		if(!term_set_id.equals(term_set_id1)){

			
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
out.println(rs.getString(3));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);

			term_set_id1=term_set_id;	
		}

		if ( i % 2 == 0 )
			classValue = "GRPEVEN" ;
		else
			classValue = "GRPEVEN" ;

		tmp_priority = rs.getString(9)== null?"":rs.getString(9);
		if(tmp_priority.equals("C")){
			priorValue	= "PRIORCRIC";
			//fontClass	= "CRITICAL";//PRIORCRIC
			Priority	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels");
		}else if(tmp_priority.equals("H")){
			priorValue	= "PRIORHIGH";
			//fontClass	= "CRITICALHIGH";//PRIORHIGH
			Priority	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels");
		}else if(tmp_priority.equals("N")){
			priorValue	= "PRIORNORM";
			//fontClass	= "NORMAL";//PRIORNORM
			Priority	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels");
		}else if(tmp_priority == "" ){
			priorValue	= "GRPEVEN";
			//fontClass	= "";
			Priority	= "&nbsp;";
		}
		
		
		pstmt1.setString(1, patient_id.trim());
		pstmt1.setString(2, rs.getString(2).trim());
		pstmt1.setString(3, rs.getString(4).trim());
		pstmt1.setInt(4, rs.getInt(1));
		rs1 = pstmt1.executeQuery();
		build_dc = "";build_rs="";
		while(rs1.next()){
			if(rs1.getString(2).equals("DC")){
				build_dc =build_dc + rs1.getString(3)+",";
			}else if(rs1.getString(2).equals("RS")){
				build_rs = build_rs +rs1.getString(3)+",";
			}
		}

		if(rs1 != null) rs1.close();

		if(!build_dc.equals(""))
			build_dc=build_dc.substring(0,build_dc.length()-1);
		if(!build_rs.equals(""))
			build_rs=build_rs.substring(0,build_rs.length()-1);
		if(!build_dc.equals("") || !build_rs.equals(""))
			factTree="+";
		else
			factTree="";
	
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(factTree));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rs.getString(5)));
            _bw.write(_wl_block28Bytes, _wl_block28);

				String tempNature="";
				if(rs.getString(6)==null)
				{
					tempNature="&nbsp;";
				}
				else
				{
					tempNature=rs.getString(6);
				}
				if(tempNature.equals("W"))
					tempNature=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wellness.label","common_labels");
				if(tempNature.equals("P"))
					tempNature=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Potential.label","common_labels");
				if(tempNature.equals("A"))
					tempNature=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Actual.label","common_labels");
			
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
out.println(tempNature);
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
out.println(rs.getString(8)==null?"&nbsp;":rs.getString(8));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(priorValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
out.println(Priority);
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
out.println(rs.getString(10)==null?"&nbsp;":com.ehis.util.DateUtils.convertDate(rs.getString(10),"DMY","en",locale));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rs.getString(4)));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rs.getString(5)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rs.getString(11)));
            _bw.write(_wl_block50Bytes, _wl_block50);
	if(!build_dc.equals("") || !build_rs.equals("")){ 
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(build_dc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(build_rs));
            _bw.write(_wl_block61Bytes, _wl_block61);
	}
	i++;	}	

	if(pstmt1 != null) pstmt1.close();
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();


            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block65Bytes, _wl_block65);

}
catch(Exception ee)
{
	//out.println("Exception in Diagnosis Profile "+ee.toString());//COMMON-ICN-0181
          ee.printStackTrace();//COMMON-ICN-0181
}
finally
{
	try{
			if(rs1 != null) rs1.close();
			if(pstmt1 != null) pstmt1.close();
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) ConnectionManager.returnConnection(con);
	}
	catch(Exception e){
		//out.println(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
		}
}


            _bw.write(_wl_block66Bytes, _wl_block66);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.SelectDiagnosistoGenerateCareplan.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.EligibleDiagnosisforCarePlan.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Nature.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Accuracy.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.AsEvidencedByFactors.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.DefiningCharacteristics.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
