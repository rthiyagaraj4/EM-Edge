package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;

public final class __addmodifygendergroup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/addModifyGenderGroup.jsp", 1740572400867L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eAM/js/GenderGroup.js\'  language =\'javascript\'></script></script>\n\n<SCRIPT LANGUAGE=\"JavaScript\">\n<!--\nfunction checkZero(obj)\n{\n\tif(parseInt(obj.value)==0){\n\t\talert(getMessage(\"INVALID_POSITIVE_NUMBER\",\"Common\"));\n\t\t//obj.select();\n\t\tobj.value=\"\";\n\t\tobj.focus();\n\t}\n}\n\nfunction changeCase(Obj)\n{\n\tObj.value=Obj.value.toUpperCase();\n\n}\nfunction allowNumerics(fld, e, maxInt, deci)\n{\n    var count=fld.value.length;//ok\n    var whichCode = (window.Event) ? e.which : e.keyCode;//ok\n\n\tvar minusOccurance = fld.value.indexOf(\'-\');\n\tif(minusOccurance != -1)\n\t{\n\t\tmaxInt++;\n\t}\n\tif(whichCode == 45 && count>0)\n\t{\n\t\treturn false\n\t}\n\n    if(count>=maxInt)\n    {\n        if(count==maxInt)\n        {\n            var dotOccurance = fld.value.indexOf(\'.\');\n\t\t\t//alert(\"dotOccurance : \"+dotOccurance);\n\n            if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt)&& deci>0)\n            {\n\t\t\t\tif(whichCode!=46)\n                {\n                    fld.value = fld.value+\".\";\n                    //alert(\"APP-0001 Reached Maximum Integer value\");\n                    //return false;\n                }\n            }\n        }\n        else if(count>maxInt)\n        {\n            var objectValue = fld.value;\n            var dotOccurance = objectValue.indexOf(\'.\');\n            //alert(objectValue.charAt(maxInt));\n            if((objectValue.charAt(maxInt))!=\'.\')\n            {\n                if(dotOccurance==-1 && parseInt(deci)>0 )\n                {\n                    fld.value = objectValue.substring(0,maxInt)+\".\";\n                    return false;\n                }\n            }\n        }\n    }\n\t//you donot require this just var strCheck = \'.0123456789\' for deci > 0\n\t//strCheck = \'0123456789\' for deci=0\n\t      var strCheck = \'.0123456789-\';\n\n//\talert(e.getKeyCode())\n    if (parseInt(deci)==0)//For Only Nos 0 - 9\n        strCheck = \'0123456789\';\n\n    var fldvalue=fld.value;\n    var whichCode = (window.Event) ? e.which : e.keyCode;\n    if (whichCode == 13) return true;  // Enter\n    var pointCount=0;\n\n    for(var i=0;i<fldvalue.length;i++)\n    {\n        if(fldvalue.charAt(i)==\'.\') pointCount++;\n    }\n\n    if (pointCount>0 && whichCode == 46) return false;\n\n    var fldValue    =   fld.value;\n    var dotIndex    =   fldValue.indexOf(\".\");\n    var fldLength   =   fldValue.length;\n    if(dotIndex!=-1)\n        if( fldLength > (dotIndex+deci) ) return false;\n\n\n\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n\n\tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\telse if(key == \"-\" && fldValue.indexOf(key) != -1  )\n\t{\n\t\tif(fldValue.indexOf(key) != 1 )\n\t\t\treturn false\n\t}\n    return true;\n}\n\n//-->\n</SCRIPT>\n<html>\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</head>\n\n\t<body OnMouseDown=\'CodeArrest()\' onLoad=\"FocusFirstElement()\"  onKeyDown = \'lockKey()\'>\n\t\t<form name=\'gender_form\' id=\'gender_form\' action=\'../../servlet/eAM.GenderGroupServlet\' method=\'post\' target=\'messageFrame\'>\n\t\t\t<div>\n\t\t\t<br><br><BR><br>\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'auto\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t        <td width=\'10%\'>&nbsp;</td>\n\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n\t\t\t\t <td>&nbsp;</td>\n\t\t\t</tr>\n    \t\t\t\t<tr>\n    \t\t\t\t     <td>&nbsp;</td>\n    \t\t\t\t     <td   class=\'label\'><!--width=\'40%\'-->";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n    \t\t\t\t     <td  class=\'fields\' ><!--width=\'60%\'colspan=\'2\'-->&nbsp;&nbsp;\n    \t\t\t\t   <input type=\'text\'  onBlur=\"makeValidString(this);changeCase(this)\" onKeyPress=\"return CheckForSpecChars(event)\"  name=\'gender_group_code\' id=\'gender_group_code\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" size=\'2\' maxlength=\'2\' ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img> </td>\n    \t\t\t\t   <td>&nbsp;</td>\n    \t\t\t\t   <td>&nbsp;</td>\n    \t\t\t\t</tr>\n    \t\t\t\t<tr>\n    \t\t\t\t\t<td>&nbsp;</td>\n    \t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t <td>&nbsp;</td>\n\t\t\t\t</tr>\n\n    \t\t\t\t<tr>\n    \t\t\t\t     <td>&nbsp;</td>\n    \t\t\t\t     <td   class=\'label\'><!--width=\'40%\'-->";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n      \t\t\t\t     <td  class=\'fields\'><!--colspan=\'2\'width=\'60%\'-->&nbsp;&nbsp;\n                                        <input type=\'text\' name=\'long_desc\' id=\'long_desc\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" onBlur=\"makeValidString(this)\"  size=\'30\' maxlength=\'30\' style=\'{ font-size: ;}\'  ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =">&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></td>\n                                     <td>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t  <td>&nbsp;</td>\n    \t\t\t        </tr>\n    \t\t\t        <tr>\n    \t\t\t        \t<td>&nbsp;</td>\n    \t\t\t        \t<td>&nbsp;</td>\n\t\t\t\t\t\t\t <td>&nbsp;</td>\n\t\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n\n    \t\t\t\t<tr>\n    \t\t\t\t     <td>&nbsp;</td>\n      \t\t\t\t     <td   class=\'label\'><!--width=\'40%\'-->";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t     <td  class=\'fields\'><!-- colspan=\"2\"width=\'60%\'-->&nbsp;&nbsp;\n      \t\t\t\t     <input type=\'text\' name=\'short_desc\' id=\'short_desc\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" onBlur=\"makeValidString(this)\"  size=\'15\' maxlength=\'15\' ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td>\n      \t\t\t\t     <td>&nbsp;</td>\n\t\t\t\t\t\t  <td>&nbsp;</td>\n    \t\t\t\t</tr>\n                                <tr>\n                                \t<td>&nbsp;</td>\n                                \t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t <td>&nbsp;</td>\n\t\t\t\t</tr>\n\n    \t\t\t\t<tr>\n    \t\t\t\t     <td>&nbsp;</td>\n    \t\t\t\t     <td  class=\'label\'><!--width=\'40%\'-->";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n    \t\t\t\t     <td  class=\'fields\'><!--colspan=\'2\'width=\'60%\'-->&nbsp;&nbsp;\n    \t\t\t\t      ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n    \t\t\t\t     \t<select name=\'gender\' id=\'gender\'>\n    \t\t\t\t     \t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n       \t\t\t\t     </select>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t<select name=\'gender\' id=\'gender\' value=\'\' disabled>\n\t\t\t\t\t\t\t\t\t<option";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="select-----</option>\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n       \t\t\t\t </td>\n       \t\t\t\t <td>&nbsp;</td>\n\t\t\t\t\t  <td>&nbsp;</td>\n    \t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t  <td>&nbsp;</td>\n    \t\t\t\t</tr>\n    \t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t     <td>&nbsp;</td>\n\t\t\t\t     <td   class=\'label\'><!--width=\'40%\'-->";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t     <td  class=\'fields\'><!--colspan=\'2\'width=\'60%\'-->&nbsp;&nbsp;\n\t\t\t\t     <!-- <input type=\"text\" name=\'min_age\' id=\'min_age\' size=\"3\"  maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' onBlur=\'CheckNum(this);checkZero(this);\' onKeyPress=\"return allowValidNumber(this, event, 3, 0);\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =">&nbsp<img src=\'../../eCommon/images/mandatory.gif\'> -->\n\t\t\t\t      <!--  Modified for ML-BRU-SCF-1101 [IN:044463]  -->\n\t\t\t\t       <input type=\"text\" name=\'min_age\' id=\'min_age\' size=\"6\"  maxlength=\'6\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' onBlur=\'CheckNum(this);checkZero(this);\' onKeyPress=\"return allowNumerics(this, event, 5, 0);\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =">&nbsp<img src=\'../../eCommon/images/mandatory.gif\'> \n\t\t\t\t       ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t<select name=\'age_unit\' id=\'age_unit\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t   </select>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td><td>&nbsp;</td><td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t <td>&nbsp;</td>\n\t\t\t\t</tr>\n\n    \t\t\t\t<tr>\n    \t\t\t\t      <td>&nbsp;</td>\n\t  \t\t         <td   class=\'label\'><!--width=\'40%\'-->";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t  \t\t\t     <td  class=\'fields\'><!-- colspan=\'2\'width=\'60%\'-->&nbsp;&nbsp;\n\t  \t\t\t      <!-- <input type=\"text\" name=\'max_age\' id=\'max_age\'  size=\"3\" maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" >&nbsp<img src=\'../../eCommon/images/mandatory.gif\' ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="> -->\n\t  \t\t\t       <!--  Modified for ML-BRU-SCF-1101 [IN:044463]  -->\n\t  \t\t\t       <input type=\"text\" name=\'max_age\' id=\'max_age\'  size=\"6\" maxlength=\'6\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =">\n\t  \t\t\t      \n\t  \t\t\t       ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t<select name=\'age_unit1\' id=\'age_unit1\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t  \t\t\t      <td>&nbsp;</td>\n\t\t\t\t\t   <td>&nbsp;</td>\n\t\t\t\t\t\n    \t\t\t\t</tr>\n    \t\t\t\t<tr>\n    \t\t\t\t\t<td>&nbsp;</td>\n    \t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t <td>&nbsp;</td>\n\t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t    <td>&nbsp;</td>\n\t\t\t\t    <td class=\'label\'><!-- width=\'40%\'-->";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t\t\t    ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t   \t\t\t <input type=\'hidden\' name=\'checked1\' id=\'checked1\'  value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t   \t\t\t  <td class=\'fields\'><!--colspan=\'2\' width=\'60%\'-->&nbsp;&nbsp;<input type=\'checkbox\' name=\'eff_status\' id=\'eff_status\' value=\'E\'  ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =">&nbsp;</td>\n\t   \t\t\t  <td>&nbsp;</td> <td>&nbsp;</td>\n\t   \t\t\t  ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n      \t\t\t\t  </tr>\n      \t\t\t\t  <tr>\n      \t\t\t\t  \t<td>&nbsp;</td>\n      \t\t\t\t  \t<td>&nbsp;</td>\n\t\t\t\t  \t<td>&nbsp;</td>\n\t\t\t\t  \t<td>&nbsp;</td>\n\t\t\t\t\t <td>&nbsp;</td>\n\t\t\t\t </tr>\n  \t\t\t</table>\n\t\t</div>\n\t\t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//String datefr="";
	//String dateto="";
	String code="";
	String longdesc="";
	String shortdesc="";
	String gender="";
	String max_age="";
	String min_age="";
	String age_unit="";
	String age_unit1="";
	String eff_status="";
	//SimpleDateFormat formatter;
	String s="";
	String vval="";
	
	String rdonly="";
	String fnval="insert";
	String def="checked";
	//String facilityId = (String) session.getValue( "facility_id" ) ;

	//String age_unitCols1[]={"---Select---","Day","Month","Year","Hours","Minutes","Seconds"};
	String age_unitCols1[]={"---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.hours.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.month.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.year.label","common_labels")};
	//String age_unitCols[]={"---Select---","Day","Month","Year","Hours","Minutes","Seconds"};
	String age_unitCols[]={"---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.hours.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.month.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.year.label","common_labels")};

	//String age_unitVals1[]={"","D","M","Y","H","N","S"};
	String age_unitVals1[]={"","D","H","N","M","Y"};
	//String age_unitVals[]={"","D","M","Y","H","N","S"};
	String age_unitVals[]={"","D","H","N","M","Y"};

	//String genderCols[]={"---Select---","Unknown","Male","Female"};
	String genderCols[]={"---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")};
	//String genderVals[]={"","U","M","F"};
	String genderVals[]={"","F","M","U"};
	Connection conn = ConnectionManager.getConnection(request);
	Statement stmt=null;
	PreparedStatement pstmt = null;
	ResultSet rset=null;

	try
	{
	    code=request.getParameter("age_grp_code");
	    if(code!=null)
	    {
	    	
	    	stmt = conn.createStatement();

	    //	rset=stmt.executeQuery("select * from am_age_group where Age_Group_Code='"+code+"' and facility_id='"+facilityId+"'");
	    	String sql1 = "select * from am_age_group where Age_Group_Code=?";
			
			pstmt   = conn.prepareStatement(sql1);
			pstmt.setString	(	1,	code		);
			rset		 = pstmt.executeQuery();
			if(rset != null)
	    	{
	    		   rdonly="readonly";
	    		   fnval="modify";
			   rset.next();
			   code = rset.getString("Age_Group_Code");
			   longdesc = rset.getString("long_desc");
			   shortdesc = rset.getString("short_desc");
			   gender =rset.getString("gender");
			   max_age=String.valueOf(rset.getInt("max_age"));
			   min_age=String.valueOf(rset.getInt("min_age"));
			   age_unit=rset.getString("age_unit");
			   age_unit1=rset.getString("AGE_UNIT_MAX");
			   eff_status=rset.getString("eff_status");
			   if(eff_status.equals("D"))
			   	s="readonly";

   			}
    		}
			if(rset!=null)	rset.close();
			if(stmt!=null) stmt.close();
			if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		
		ConnectionManager.returnConnection(conn,request);
	}
	if(code==null)	code="";


            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rdonly));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(longdesc));
            _bw.write(_wl_block14Bytes, _wl_block14);
out.print(s);
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(shortdesc));
            _bw.write(_wl_block17Bytes, _wl_block17);
out.print(s);
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if(!s.equalsIgnoreCase("readonly"))
	  			       {
            _bw.write(_wl_block20Bytes, _wl_block20);
vval="";
    				     	for(int kk=0;kk<4;kk++)
    				     	{
    				     		if(fnval.equals("modify"))
    				     	  	{
    				     	  		if(genderVals[kk].equals(gender))
    				     				vval="selected";
    				     	  		else
    				     				vval="";
    				     		}
    				          out.print("<option value=\""+genderVals[kk]+"\" " +vval+ ">"+genderCols[kk]+"</option>");
    				        }
    				     
            _bw.write(_wl_block21Bytes, _wl_block21);
}
       				     else
				    {   
				     	 for(int kk=0;kk<4;kk++)
				     	 {
				     	 	if(gender==null || gender.equals("")  )
				     	   	{
				     	   		vval="  ";
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

				     	   		//out.print("<input type='text'  value=\""+vval+"\" size='10' maxlength='10' " +s+">");
				     	      		out.print("<input type=hidden name='gender' id='gender' value='"+genderVals[kk]+"'>");
				     	      		break;
				     	      	}
				     	   	if(genderVals[kk].equals(gender))
				     	   	  {
				     	   	  	vval=genderCols[kk];
				     	   	     	out.print("<input type='text' value=\""+vval+"\" size='10' maxlength='10' " +s+">");
				     	      		out.print("<input type=hidden name='gender' id='gender' value='"+genderVals[kk]+"'>");
				     	      		break;
				     	      	}
	      				}
	      			   }
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(min_age));
            _bw.write(_wl_block26Bytes, _wl_block26);
out.print(s);
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(min_age));
            _bw.write(_wl_block28Bytes, _wl_block28);
out.print(s);
            _bw.write(_wl_block29Bytes, _wl_block29);
if(!s.equals("readonly") )
					 {
            _bw.write(_wl_block30Bytes, _wl_block30);
vval="";
						for(int kk=0;kk<6;kk++)
						{
							if(fnval.equals("modify"))
							{
								if(age_unitVals[kk].equals(age_unit))
									vval="selected";
								else
									vval="";
							}
						         out.print("<option value='"+age_unitVals[kk]+"' " +vval+ ">"+age_unitCols[kk]+"</option>");
						}
				    	   
            _bw.write(_wl_block31Bytes, _wl_block31);
}
					    else
					      {
					      	for(int kk=0;kk<6;kk++)
					      	{
					      		if(age_unitVals[kk].equals(age_unit))
							{
							     	vval=age_unitCols[kk];
							  	out.print("<input type='text' SIZE='10' value="+vval+" " +s+">");
					      			out.print("<input type='hidden' name='age_unit' id='age_unit' value='"+age_unitVals[kk]+"'>");
					      		  }
					      	 }
					      }
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(max_age));
            _bw.write(_wl_block26Bytes, _wl_block26);
out.print(s);
            _bw.write(_wl_block34Bytes, _wl_block34);
out.print(s);
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(max_age));
            _bw.write(_wl_block28Bytes, _wl_block28);
out.print(s);
            _bw.write(_wl_block34Bytes, _wl_block34);
out.print(s);
            _bw.write(_wl_block36Bytes, _wl_block36);
if(!s.equals("readonly") )
					     {
            _bw.write(_wl_block37Bytes, _wl_block37);
vval="";
						for(int gg=0;gg<6;gg++)
						{
							if(fnval.equals("modify"))
							{
								if(age_unitVals1[gg].equals(age_unit1))
									vval="selected";
								else
									vval="";
							}
						         out.print("<option value='"+age_unitVals1[gg]+"' " +vval+ ">"+age_unitCols1[gg]+"</option>");
						}
				    	   
            _bw.write(_wl_block31Bytes, _wl_block31);
}
					    else
					      {
					      	for(int gg=0;gg<6;gg++)
					      	{
					      		if(age_unitVals1[gg].equals(age_unit1))
							{
							     	vval=age_unitCols1[gg];
							  	out.print("<input type='text' SIZE='10' value="+vval+" " +s+">");
					      			out.print("<input type='hidden' name='age_unit1' id='age_unit1' value='"+age_unitVals1[gg]+"'>");
					      		  }
					      	 }
					      }
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

				    if(eff_status.equals("D"))
				    	def="";
				  
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(def));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(def));
            _bw.write(_wl_block42Bytes, _wl_block42);
   s="";
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block45Bytes, _wl_block45);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longdescription.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortdescription.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MinimumAge.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.MaximumAge.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
}
