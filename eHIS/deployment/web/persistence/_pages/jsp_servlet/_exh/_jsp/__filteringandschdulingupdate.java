package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;

public final class __filteringandschdulingupdate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/FilteringAndSchdulingUpdate.jsp", 1709122336773L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'></link>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script src=\'../../eXH/js/FilterLayerReference.js\' language=\'javascript\'></script>\n\n<script Language=\"JavaScript\" >\nfunction CheckForSpecCharsforID(event) \n{\n    var strCheck = \'0123456789\';\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode);  // Get key value from key code\n    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\treturn (event.keyCode -= 32);\n\treturn true ;\n}\nfunction record(mode)\n{\nthis.document.forms[0].actualmode.value=mode;\nthis.document.forms[0].submit();\n\n}\nfunction cancel()\n{\n\tthis.document.forms[0].reset();\n}\nfunction hide()\n\t{\nvar k=1;\t\nvar count=0;\nfor(var i=1;i<document.DATAELEMENTCROSSREF.elements.length;i++)\n\t\t{\n\nif(document.DATAELEMENTCROSSREF.elements[i].value!=\"\" )\n{\n\ndocument.DATAELEMENTCROSSREF.elements[i].style.display=\"block\";\nif(document.DATAELEMENTCROSSREF.elements[i].type==\"text\")\n\t{\nk++;\n\t}\n}\nelse\n{\n\tdocument.DATAELEMENTCROSSREF.elements[i].style.display=\"none\";\n}\n}\n\n count =k/4;\nfor(var r=1;r<=count;r++)\n\t\t{\ndocument.getElementById(\"lablerow\"+r).style.display=\"block\"; \ndocument.getElementById(\"lablelevelt\"+r).style.display=\"block\";\ndocument.getElementById(\"lablelevels\"+r).style.display=\"block\";\ndocument.getElementById(\"lablelevelc\"+r).style.display=\"block\";\ndocument.getElementById(\"lablelevelv\"+r).style.display=\"block\";\n\t\t}\n\ndocument.forms[0].count.value=count;\n\t} \n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' onload=\"hide();\">\n<form name=\"DATAELEMENTCROSSREF\" id=\"DATAELEMENTCROSSREF\" target=\'messageFrame\' method=\"POST\" action=\'../../eXH/jsp/FilterAndSchedulingUpdateRecord.jsp\' > \n<table cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n<tr id=\"lablerow1\" style=\"display:none\">\n<td class=label id=\"lablelevelt1\" width=\'10%\' style=\"display:none\">Filter level1 type</td>\n<td align=left><input type=text name=Filter_level_type1 size=15 value=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' > </td>\n<td class=label id=\"lablelevels1\" width=\'10%\' style=\"display:none\">Filter level1 subtype</td>\n<td align=left><input type=text name=Filter_level_subtype1 size=15  value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'  style=\"display:none\"></td>\n<td class=\"label\" id=\"lablelevelc1\" style=\"display:none\">Filter level1 code</td>\n<td align=left>\n<input type=text id=\'Filter_level1_code\'  name =\'Filter_level_code1\' size=\'15\' value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'  style=\"display:none\"> \n</td>\n<td class=\"label\" id=\"lablelevelv1\" style=\"display:none\" >Filter level1 value</td>\n<td align=left><input type=text id=\"Filter_level_value1\"  name =\'Filter_level_value1\' size=\'15\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'  style=\"display:none\"> </td>\n</tr> \n\n \n<tr id=\"lablerow2\" style=\"display:none\">\n<td class=label width=\'10%\' id=\"lablelevelt2\" style=\"display:none\">Filter level2 type</td>\n\t<td align=left><input type=text name=Filter_level_type2 size=15 value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' style=\"display:none\" > </td>\n<td class=label width=\'10%\' id=\"lablelevels2\" style=\"display:none\">Filter level2 subtype</td>\n<td align=left><input type=text name=Filter_level_subtype2 size=15 value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'style=\"display:none\" ></td>\n<td class=\"label\" id=\"lablelevelc2\" style=\"display:none\">Filter level2 code</td>\n<td align=left>\n<input type=text id=\'Filter_level2_code\'  name =\'Filter_level_code2\' size=\'15\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'  style=\"display:none\"> \n</td>\n<td class=\"label\" id=\"lablelevelv2\" style=\"display:none\">Filter level2 value</td>\n<td align=left><input type=text id=\"Filter_level_value2\"  name =\'Filter_level_value2\' size=\'15\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'  style=\"display:none\"> </td>\n</tr>\n\n<tr id=\"lablerow3\" style=\"display:none\">\n<td class=label width=\'10%\' id=\"lablelevelt3\" style=\"display:none\">Filter level3 type</td>\n\t<td align=left><input type=text name=Filter_level_type3 size=15 value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' style=\"display:none\"> </td>\n<td class=label width=\'10%\' id=\"lablelevels3\" style=\"display:none\">Filter level3 subtype</td>\n<td align=left><input type=text name=Filter_level_subtype3 size=15 value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' style=\"display:none\"></td>\n<td class=\"label\" id=\"lablelevelc3\" style=\"display:none\">Filter level3 code</td>\n<td align=left>\n<input type=text id=\'Filter_level3_code\'  name =\'Filter_level_code3\' size=\'15\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' style=\"display:none\" > \n</td>\n<td class=\"label\" id=\"lablelevelv3\" style=\"display:none\">Filter level3 value</td>\n<td align=left><input type=text id=\"Filter_level_value3\"  name =\'Filter_level_value3\' size=\'15\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' style=\"display:none\" > </td>\n</tr>\n\n\n<tr id=\"lablerow4\" style=\"display:none\">\n<td class=label width=\'10%\' id=\"lablelevelt4\" style=\"display:none\">Filter level4 type</td>\n\t<td align=left><input type=text name=Filter_level_type4 size=15 value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' style=\"display:none\"> </td>\n<td class=label width=\'10%\' id=\"lablelevels4\" style=\"display:none\">Filter level4 subtype</td>\n<td align=left><input type=text name=Filter_level_subtype4 size=15 value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' style=\"display:none\"></td>\n<td class=\"label\" id=\"lablelevelc4\" style=\"display:none\">Filter level4 code</td>\n<td align=left>\n<input type=text id=\'Filter_level4_code\'  name =\'Filter_level_code4\' size=\'15\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'  style=\"display:none\"> \n</td>\n<td class=\"label\" id=\"lablelevelv4\" style=\"display:none\" >Filter level4 value</td>\n<td align=left><input type=text id=\"Filter_level4_value\"  name =\'Filter_level_value4\' size=\'15\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'  style=\"display:none\"> </td>\n</tr>\n\n<tr id=\"lablerow5\" style=\"display:none\">\n<td class=label width=\'10%\' id=\"lablelevelt5\"style=\"display:none\">Filter level5 type</td>\n\t<td align=left><input type=text name=Filter_level_type5 size=15 value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' style=\"display:none\"> </td>\n<td class=label id=\"lablelevels5\" width=\'10%\' style=\"display:none\">Filter level5 subtype</td>\n<td align=left><input type=text name=Filter_level_subtype5 size=15 value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' style=\"display:none\"></td>\n<td class=\"label\" id=\"lablelevelc5\" style=\"display:none\">Filter level5 code</td>\n<td align=left>\n<input type=text id=\'Filter_level5_code\'  name =\'Filter_level_code5\' size=\'15\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'  style=\"display:none\"> \n</td>\n<td class=\"label\" id=\"lablelevelv5\" style=\"display:none\">Filter level5 value</td>\n<td align=left><input type=text id=\"Filter_level_value5\"  name =\'Filter_level_value5\' size=\'15\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'  style=\"display:none\"> </td>\n</tr>\n\n<tr id=\"lablerow6\" style=\"display:none\">\n<td class=label width=\'10%\' id=\"lablelevelt6\" style=\"display:none\">Filter level6 type</td>\n<td align=left><input type=text name=Filter_level_type6 size=16 value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' style=\"display:none\"> </td>\n\n<td class=label width=\'10%\' id=\"lablelevels6\" style=\"display:none\">Filter level6 subtype</td>\n<td align=left><input type=text name=Filter_level_subtype6 size=16 value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' style=\"display:none\"></td>\n\n\n<td class=\"label\" id=\"lablelevelc6\" style=\"display:none\">Filter level6 code</td>\n<td align=left><input type=text id=\'Filter_level_code6\'  name =\'Filter_level_code6\' size=\'16\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'  style=\"display:none\"> \n</td>\n\n<td class=\"label\" id=\"lablelevelv6\" style=\"display:none\">Filter level6 value</td>\n<td align=left><input type=text id=\"Filter_level_value6\"  name =\'Filter_level_value6\' size=\'16\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'  style=\"display:none\"> </td>\n</tr>\n\n\n\n<tr id=\"lablerow7\" style=\"display:none\">\n<td class=label width=\'10%\' id=\"lablelevelt7\" style=\"display:none\">Filter level7 type</td>\n<td align=left><input type=text name=Filter_level_type7 size=15 value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' style=\"display:none\"> </td>\n\n<td class=label width=\'10%\' id=\"lablelevels7\" style=\"display:none\">Filter level7 subtype</td>\n<td align=left><input type=text name=Filter_level_subtype7 size=15 value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' style=\"display:none\"></td>\n\n<td class=\"label\" id=\"lablelevelc7\" style=\"display:none\">Filter level7 code</td>\n<td align=left><input type=text id=\'Filter_level_code7\'  name =\'Filter_level_code7\' size=\'15\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'  style=\"display:none\"> \n</td>\n\n<td class=\"label\" id=\"lablelevelv7\" style=\"display:none\">Filter level7 value</td>\n<td align=left><input type=text id=\"Filter_level_value7\"  name =\'Filter_level_value7\' size=\'15\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'  style=\"display:none\"> </td>\n</tr>\n\n<tr id=\"lablerow8\" style=\"display:none\">\n<td class=label width=\'10%\' id=\"lablelevet8\" style=\"display:none\">Filter level8 type</td>\n\t<td align=left id=\"\" ><input type=text name=Filter_level_type8 size=15 value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' style=\"display:none\"> </td>\n\n<td class=label width=\'10%\' id=\"lablelevels8\" style=\"display:none\">Filter level8 subtype</td>\n<td align=left><input type=text name=Filter_level_subtype8 size=15 value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' style=\"display:none\"></td>\n\n<td class=\"label\" id=\"lablelevelc8\" style=\"display:none\">Filter level8 code</td>\n<td align=left><input type=text id=\'Filter_level_code8\'  name =\'Filter_level_code8\' size=\'15\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'  style=\"display:none\"> \n</td>\n\n<td class=\"label\" id=\"lablelevelv8\" style=\"display:none\">Filter level8 value</td>\n<td align=left><input type=text id=\"Filter_level_value8\"  name =\'Filter_level_value8\' size=\'15\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'  style=\"display:none\"> </td>\n</tr>\n<tr id=\"lablerow9\" style=\"display:none\">\n<td class=label width=\'10%\' id=\"lablelevelt9\" style=\"display:none\">Filter level9 type</td>\n\t<td align=left><input type=text name=Filter_level_type9 size=15 value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' style=\"display:none\"> </td>\n\n<td class=label width=\'10%\' id=\"lablelevels9\" style=\"display:none\">Filter level9 subtype</td>\n<td align=left><input type=text name=Filter_level_subtype9 size=15 value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' style=\"display:none\"></td>\n\n<td class=\"label\" id=\"lablelevelc9\" style=\"display:none\">Filter level9 code</td>\n<td align=left><input type=text id=\'Filter_level_code9\'  name =\'Filter_level_code9\' size=\'15\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'  style=\"display:none\"> \n</td>\n\n<td class=\"label\" id=\"lablelevelv9\" style=\"display:none \">Filter level9 value</td>\n<td align=left><input type=text id=\"Filter_level_value9\"  name =\'Filter_level_value9\' size=\'15\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'  style=\"display:none\"> \n</tr>\n<tr>\n<td>\n</td>\n<td>\n</td>\n</tr>\n<tr>\n<td>\n</td>\n<td>\n</td>\n<td>\n</td>\n<td>\n</td>\n<td>\n</td>\n<td></td>\n<td class=\"BUTTON\"><input class=\'button\' type=\'button\'  name=\'Record\' id=\'Record\' value=\'<fmt:message key=\"eXH.Record.Label\" bundle=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"/>\' onClick=\"record(\'U\')\"></td>\n<td>\n<input class=\'button\' type=\'button\'  name=\'Cancel\' id=\'Cancel\' value=\'<fmt:message key=\"eXH.Cancel.Label\" bundle=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"/>\' onClick=\'cancel();\'></td>\n</tr>\n</table>\n<input type=\'hidden\' name=\'actualmode\' id=\'actualmode\' value=\'U\'>\t\n<input type=\'hidden\' name=\'Leval_number\' id=\'Leval_number\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<input type=hidden name=count >\n<input type=hidden name=Filter_group_desc_id value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'> \n<input type=hidden name=Tranaction_number value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'> \n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\n</form>\n</body>\n</html>\n\n \n\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

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
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
            _bw.write(_wl_block1Bytes, _wl_block1);

String exceptions="";
try
{

String Filterlevel1type=XHDBAdapter.checkNull(request.getParameter("Filter_level1_type"));
String Filterlevel1subtype=XHDBAdapter.checkNull(request.getParameter("Filter_level1_subtype"));
String Filterlevel1code=XHDBAdapter.checkNull(request.getParameter("Filter_level1_code"));
String Filterlevel1value=XHDBAdapter.checkNull(request.getParameter("Filter_level1_value"));

String Filterlevel2type=XHDBAdapter.checkNull(request.getParameter("Filter_level2_type"));
String Filterlevel2subtype=XHDBAdapter.checkNull(request.getParameter("Filter_level2_subtype"));
String Filterlevel2code=XHDBAdapter.checkNull(request.getParameter("Filter_level2_code"));
String Filterlevel2value=XHDBAdapter.checkNull(request.getParameter("Filter_level2_value"));

String Filterlevel3type=XHDBAdapter.checkNull(request.getParameter("Filter_level3_type"));
String Filterlevel3subtype=XHDBAdapter.checkNull(request.getParameter("Filter_level3_subtype"));
String Filterlevel3code=XHDBAdapter.checkNull(request.getParameter("Filter_level3_code"));
String Filterlevel3value=XHDBAdapter.checkNull(request.getParameter("Filter_level3_value"));

String Filterlevel4type=XHDBAdapter.checkNull(request.getParameter("Filter_level4_type"));
String Filterlevel4subtype=XHDBAdapter.checkNull(request.getParameter("Filter_level4_subtype"));
String Filterlevel4code=XHDBAdapter.checkNull(request.getParameter("Filter_level4_code"));
String Filterlevel4value=XHDBAdapter.checkNull(request.getParameter("Filter_level4_value"));

String Filterlevel5type=XHDBAdapter.checkNull(request.getParameter("Filter_level5_type"));
String Filterlevel5subtype=XHDBAdapter.checkNull(request.getParameter("Filter_level5_subtype"));
String Filterlevel5code=XHDBAdapter.checkNull(request.getParameter("Filter_level5_code"));
String Filterlevel5value=XHDBAdapter.checkNull(request.getParameter("Filter_level5_value"));

String Filterlevel6type=XHDBAdapter.checkNull(request.getParameter("Filter_level6_type"));
String Filterlevel6subtype=XHDBAdapter.checkNull(request.getParameter("Filter_level6_subtype"));
String Filterlevel6code=XHDBAdapter.checkNull(request.getParameter("Filter_level6_code"));
String Filterlevel6value=XHDBAdapter.checkNull(request.getParameter("Filter_level6_value"));

String Filterlevel7type=XHDBAdapter.checkNull(request.getParameter("Filter_level7_type"));
String Filterlevel7subtype=XHDBAdapter.checkNull(request.getParameter("Filter_level7_subtype"));
String Filterlevel7code=XHDBAdapter.checkNull(request.getParameter("Filter_level7_code"));
String Filterlevel7value=XHDBAdapter.checkNull(request.getParameter("Filter_level7_value"));

String Filterlevel8type=XHDBAdapter.checkNull(request.getParameter("Filter_level8_type"));
String Filterlevel8subtype=XHDBAdapter.checkNull(request.getParameter("Filter_level8_subtype"));
String Filterlevel8code=XHDBAdapter.checkNull(request.getParameter("Filter_level8_code"));
String Filterlevel8value=XHDBAdapter.checkNull(request.getParameter("Filter_level8_value"));

String Filterlevel9type=XHDBAdapter.checkNull(request.getParameter("Filter_level9_type"));
String Filterlevel9subtype=XHDBAdapter.checkNull(request.getParameter("Filter_level9_subtype"));
String Filterlevel9code=XHDBAdapter.checkNull(request.getParameter("Filter_level9_code"));
String Filterlevel9value=XHDBAdapter.checkNull(request.getParameter("Filter_level9_value"));

String leval_number=XHDBAdapter.checkNull(request.getParameter("Level_number"));
String Filter_group_desc_id=XHDBAdapter.checkNull(request.getParameter("Filter_group_code"));
String tranaction_number=XHDBAdapter.checkNull(request.getParameter("Transnumber"));

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(Filterlevel1type));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(Filterlevel1subtype));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(Filterlevel1code));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Filterlevel1value));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Filterlevel2type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Filterlevel2subtype));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Filterlevel2code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Filterlevel2value));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Filterlevel3type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Filterlevel3subtype));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Filterlevel3code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Filterlevel3value));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Filterlevel4type));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Filterlevel4subtype));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Filterlevel4code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Filterlevel4value));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Filterlevel5type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Filterlevel5subtype));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Filterlevel5code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Filterlevel5value));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Filterlevel6type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Filterlevel6subtype));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(Filterlevel6code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(Filterlevel6value));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(Filterlevel7type));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Filterlevel7subtype));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Filterlevel7code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(Filterlevel7value));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(Filterlevel8type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(Filterlevel8subtype));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(Filterlevel8code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(Filterlevel8value));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Filterlevel9type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(Filterlevel9subtype));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(Filterlevel9code));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(Filterlevel9value));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(leval_number));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(Filter_group_desc_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(tranaction_number));
            _bw.write(_wl_block45Bytes, _wl_block45);


}
catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of FilteringAndSchdulingUpdate.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	

            _bw.write(_wl_block46Bytes, _wl_block46);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
