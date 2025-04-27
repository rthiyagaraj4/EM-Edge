package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __deliveryinstructionsquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/DeliveryInstructionsQueryCriteria.jsp", 1728905382000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n<head>\n<title>Instruments</title>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<link rel=\'stylesheet\' type=\'text/css\'\n\thref=\'../../eCommon/html/CommonCalendar.css\'></link>\n<script src=\'../../eCommon/js/CommonCalendar.js\' language=\'JavaScript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'JavaScript\'></script>\n<Script src=\'../../eCommon/js/common.js\' language=\'JavaScript\'></Script>\n<script language=\'javascript\'>\n\tfunction focusObject() {\n\t\tdocument.forms[0].elements[0].focus();\n\t}\n\tfunction addOrderByCol() {\n\t\tvar i = 0;\n\t\tvar from = document.getElementById(\'orderbycols\');\n\t\tif (from.options.length > 0) {\n\t\t\tvar to = document.getElementById(\'orderbycolumns\');\n\t\t\tvar element = document.createElement(\'OPTION\');\n\t\t\telement.text = from.options[from.selectedIndex].text;\n\t\t\telement.value = from.options[from.selectedIndex].value;\n\t\t\tto.add(element);\n\t\t\tfrom.remove(from.selectedIndex);\n\t\t\tif (from.options[i])\n\t\t\t\tfrom.options[i].selected = true;\n\t\t\ti++;\n\t\t}\n\t}\n\tfunction removeOrderByCol() {\n\t\tvar j = 0;\n\t\tvar from = document.getElementById(\'orderbycolumns\');\n\t\tif (from.options.length > 0) {\n\t\t\tvar to = document.getElementById(\'orderbycols\');\n\t\t\tvar element = document.createElement(\'OPTION\');\n\t\t\telement.text = from.options[from.selectedIndex].text;\n\t\t\telement.value = from.options[from.selectedIndex].value;\n\t\t\tto.add(element);\n\t\t\tfrom.remove(from.selectedIndex);\n\t\t\tif (from.options[j])\n\t\t\t\tfrom.options[j].selected = true;\n\t\t\tj++;\n\t\t}\n\t}\n\tfunction SelectAll() {\n\t\tvar i = 0;\n\t\tdocument.getElementById(\"orderbycolumns\").selectedIndex = 0;\n\t\twhile (i < document.getElementById(\"orderbycolumns\").length) {\n\t\t\tdocument.getElementById(\"orderbycolumns\").options[i].selected = true;\n\t\t\ti++;\n\t\t}\n\t}\n\tfunction execQuery() {\n\t\tif (document.getElementById(\"orderbycolumns\").options.length > 0) {\n\t\t\tSelectAll();\n\t\t\tdocument.query_form.submit();\n\t\t} else {\n\t\t\talert(getMessage(\'ORDERBY_NOT_BLANK\', \'Common\'))\n\t\t}\n\t}\n\tfunction textAreaLimit(field, maxlen) {\n\t\tif (field.value.length > maxlen + 1)\n\t\talert(\'Should not be more than  \'+maxlen+\" characters\");\n\t\tif (field.value.length > maxlen)\n\t\tfield.value = field.value.substring(0, maxlen);\n\t}\n\n</script>\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'\n\tonLoad=\'focusObject()\'>\n\t<form name=\'query_form\' id=\'query_form\' method=\'post\'\n\t\taction=\'../../eDS/jsp/DeliveryInstructionsQueryResult.jsp?ph_module_yn=null\'\n\t\tonsubmit=\'SelectAll()\'>\n\t\t<Script src=\'../../eCommon/js/common.js\' language=\'JavaScript\'></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<table width=\'100%\' align=\'center\' cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t<tr>\n\t\t\t\t<th align=\'left\' width=\'20%\'>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</th>\n\t\t\t<tr>\n\t\t\t\t<td width=\'60%\'><p title=\'Query Criteria\'>\n\t\t\t\t\t<table width=\'100%\'>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\'40%\' class=\'label\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t\t\t\t\t<td class=\'fields\' width=\'60%\'><input type=text\n\t\t\t\t\t\t\t\tname=\'del_Instr\' id=\'del_Instr\' size=\'4\' maxlength=\'4\'\n\t\t\t\t\t\t\t\tonBlur=\'makeValidQueryCriteria(this);\'></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\'40%\' class=\'label\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<textarea name=\"long_Desc\" style=\"resize: none;\"  rows=\"5\" cols=\"60\" onkeyup=\"textAreaLimit(this,100);\"></textarea>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\'40%\' class=\'label\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t\t\t<td width=\'60%\' class=\'fields\'><select name=\'enabled_Yn\' id=\'enabled_Yn\'><option\n\t\t\t\t\t\t\t\t\t\tvalue=\'B\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</option>\n\t\t\t\t\t\t\t\t\t<option value=\'E\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</option>\n\t\t\t\t\t\t\t\t\t<option value=\'D\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</option></select>&nbsp;</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table></td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</p>\n\t\t<table width=\'100%\' align=\'center\'>\n\t\t\t<th width=\'20%\' align=\'left\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t</td>\n\t\t\t<tr>\n\t\t\t\t<td width=\'60%\'>\n\t\t\t\t\t<p title=\'Sort Order\'>\n\t\t\t\t\t<table width=\'100%\'>\n\t\t\t\t\t\t<td align=\'center\'><b>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td align=\'center\'><b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\'45%\' align=\'center\'><select name=\'orderbycols\' id=\'orderbycols\'\n\t\t\t\t\t\t\t\tsize=\'5\'><option value=\'long_desc\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n\t\t\t\t\t\t\t\t\t<option value=\'eff_status\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</option></select></td>\n\t\t\t\t\t\t\t<td align=\'center\' width=\'3%\'><input type=\'button\'\n\t\t\t\t\t\t\t\tname=\'add\' id=\'add\' class=\'button\' onclick=\'addOrderByCol()\'\n\t\t\t\t\t\t\t\tvalue=\'---->\'> <input type=\'button\' name=\'add\' id=\'add\'\n\t\t\t\t\t\t\t\tclass=\'button\' value=\'<----\' onclick=\'removeOrderByCol()\'></img></td>\n\t\t\t\t\t\t\t<td width=\'45%\' align=\'center\'><select name=\'orderbycolumns\' id=\'orderbycolumns\'\n\t\t\t\t\t\t\t\tsize=\'5\' multiple=\'true\'><option value=\'instr_code\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</option></select></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t</p>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<br>\n\t\t<table border=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td width=\'100%\' align=\'center\' class=\'white\'><input type=\'button\' name=\'ExecuteQuery\' id=\'ExecuteQuery\' class=\'Button\'\n\t\t\t\t\tonclick=\'execQuery()\'></td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<script>var exe=getLabel(\'Common.Execute.label\',\'common\'); document.forms[0].ExecuteQuery.value=exe;</script>\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
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
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String delInstr =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.InstructionCode.Label","ot_labels") ;
String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String longDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Description.Label","ot_labels") ;
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(queryCriteria ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(delInstr ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(longDesc ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(nature ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(both ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(enabled ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sortorder ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(comSelect ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(orderby ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(longDesc ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(nature ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(delInstr ));
            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
