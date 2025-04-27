package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import eXH.*;
import java.util.*;
import eXH.XHDBAdapter;
import java.util.*;
import com.ehis.util.*;

public final class __adminoraclejobprocesslist_bfore_view extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/AdminOracleJobProcessList_bfore_view.jsp", 1709122298805L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/menu.css\' type=\'text/css\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eXH/html/style.css\" /> \n<SCRIPT Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></SCRIPT>\n<SCRIPT Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\" ></SCRIPT>\n<SCRIPT Language=\"JavaScript\" src=\"../../eXH/js/menu.js\" ></SCRIPT>\n<SCRIPT language=\"JavaScript\" src=\'../../eXH/js/AdministerReviewCommunicationProcess.js\'></SCRIPT>\n \n<SCRIPT>\nvar tooltip=function(){\n\tvar id = \'tt\';\n\tvar top = 3;\n\tvar left = 3;\n\tvar maxw = 500;\n\tvar speed = 10;\n\tvar timer = 20;\n\tvar endalpha = 200;\n\tvar alpha = 0;\t\t\t\t\t\t\t\t\t\t   \n\tvar tt,t,c,b,h;\n\tvar ie = document.all ? true : false;\n\treturn{\n\t\tshow:function(v,w){\n\t\tv=unescape(v);\n\t\t\t \tif(tt == null){\n\t\t\t\ttt = document.createElement(\'div\');\n\t\t\t\ttt.setAttribute(\'id\',id);\n\t\t\t\tt = document.createElement(\'div\');\t\t\t\t\t\t\t   \n\t\t\t\tt.setAttribute(\'id\',id + \'top\');\n\t\t\t\tc = document.createElement(\'div\');\n\t\t\t\tc.setAttribute(\'id\',id + \'cont\');\n\t\t\t\tb = document.createElement(\'div\');\n\t\t\t\tb.setAttribute(\'id\',id + \'bot\');\n\t\t\t\ttt.appendChild(t);\n\t\t\t\ttt.appendChild(c);\n\t\t\t\ttt.appendChild(b);\n\t\t\t\tdocument.body.appendChild(tt);\n\t\t\t\ttt.style.opacity = 0;\n\t\t\t\n\t\t\t\ttt.style.filter = \'alpha(opacity=0)\';\n\t\t\t\tdocument.onmousemove =this.pos;\n\t\t\t\t\n\t\t\t}\n\t\t\ttt.style.display = \'block\';\t\t\t  \n\t\t\tc.innerHTML = v;  \n\t\t\t  c.style.width=\"1010px\";\n\t\t\t\t  \tc.style.wordBreak=\'break-all\';\n\t\t\ttt.style.width = w ? w + \'px\' : \'50\';\n\t\t\tif(!w && ie){\n\t\t\t\tt.style.display = \'none\';\n\t\t\t\t\n\t\t\t\tb.style.display = \'none\';\n\t\t\t\ttt.style.width =tt.offsetWidth;\n\t\t\t\tt.style.display = \'block\';\n\t\t\t\tb.style.display = \'block\';\n\t\t\t}\n\t\t\tif(tt.offsetWidth > maxw){tt.style.width = maxw + \'px\'}\n\t\t\th = parseInt(tt.offsetHeight) + top;\n\t\t\tclearInterval(tt.timer);\n\t\t\ttt.timer = setInterval(function(){tooltip.fade(1)},timer);\n\t\t},\n\t\tpos:function(e){\n\t\t\tvar u =ie ? event.clientX + document.documentElement.scrollTop : e.pageX;\n\t\t\tvar l =\t100;\n\t\t\t\t//ie ? event.clientY + document.documentElement.scrollLeft : e.pageY;\n\t\t\ttt.style.top =(u - h) ;\n\t\t\ttt.style.left =0;\n\t\t},\n\t\tfade:function(d){\n\t\t\tvar a = alpha;\n\t\t\tif((a != endalpha && d == 1) || (a != 0 && d == -1)){\n\t\t\t\tvar i = speed;\n\t\t\t\tif(endalpha - a < speed && d == 1){\n\t\t\t\t\ti = endalpha - a;\n\t\t\t\t}else if(alpha < speed && d == -1){\n\t\t\t\t\ti = a;\n\t\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\talpha = a + (i * d);\n\t\t\t\ttt.style.opacity = alpha * .01;\n\t\t\t\ttt.style.filter = \'alpha(opacity=\' + alpha + \')\';\n\t\t\t}else{\n\t\t\t\tclearInterval(tt.timer);\t\t\t\t\t\t\t\t\t   \n\t\t\t\tif(d == -1){tt.style.display = \'none\'}\n\t\t\t}\n\t\t},\n\t\thide:function(){\n\t\t\tclearInterval(tt.timer);\n\t\t\ttt.timer = setInterval(function(){tooltip.fade(-1)},timer);\n\t\t}\n\t};\n}();\nfunction breakFun()\n{\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\tvar cou=parseInt(document.forms[0].count.value);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t   \n     for(var k=0;k<cou;k++)\n\t{\n       document.getElementById(\"check\"+k).style.wordBreak=\'break-all\';\n\t}\n\t\n}\n</SCRIPT>\n\n</HEAD>\t\t\t\t\t\t\t\t    \n \n<BODY  leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' onLoad=\"breakFun();\">\n\n<form name=\"AdminOracleJobProcessListForm\" id=\"AdminOracleJobProcessListForm\" method=\"post\">\n\n<table border=1 cellspacing=0 cellpadding=3 width=\'100%\' align=center> \n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<tr>\n\t\t<!--<td colspan=\"4\" class=\"CAGROUP\" > Job-Queue</td>--->\n\t  <td colspan=\"5\" align=\"right\" class=\"CAGROUP\"> \n\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\"><u>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</u></A>\n\t<A class=\'label\'  onClick=\"funAction(\'N\')\" style=\'cursor:pointer\'><u>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</u></A>\n\t</td>\n\t</tr>\n\t<tr>\t\t\t\t\t    \n\t<td class=\'COLUMNHEADER\' width=\'65%\'  nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<!---<td class=\'COLUMNHEADER\'  width=\'10%\' nowrap>Submitted By</td>--->\n\t<td class=\'COLUMNHEADER\'  width=\'15%\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t<td class=\'COLUMNHEADER\'  width=\'15%\' nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t<td class=\'COLUMNHEADER\'  width=\'5%\' nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t<tr>\n\t\t<td id=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' class=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\tjob=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" what=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" select_option=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" interval=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"\n\t\t\tlast_date=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" next_date=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" long_desc=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" err_msg=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"\n\t\tonClick=\'sendParam(this)\'  width=\'40%\' ><span class=\"hotspot\" onmouseover=\"tooltip.show(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\');\" onmouseout=\"tooltip.hide();\"><a href=\"#\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</a></span> </td>\t  \n\n\t    ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' width=\'15%\' >&nbsp;</td>\t\t\t\t\t\t\t  \n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' width=\'15%\' >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&nbsp;</td>\n         ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t<td class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' width=\'15%\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\n\n\t\t<td class=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' select_option=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" run_job=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"  proc_date=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" onMouseDown=\'showErrors(this)\' >\n\t\t<a href=\"#\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</a>\n\t\t</td>\t\t\t\t\t\t\t\t\t\t   \n\t\t\n<!--\t\t\terr_msg=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" -->\t\t \n\t</tr>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t  <tr>\n\t\t<td id=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' \n\t\t\tjob=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"\n\t\tonClick=\'sendParam(this)\'  width=\'40%\'  >\n\t\t<span class=\"hotspot\" onmouseover=\"tooltip.show(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</a></span>\n\t\t\t\t\t\t\t\t\t\t\t \n\n\t\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t</td>\n\t<!-- <td class=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td> -->\n\t\t<td class=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'  width=\'15%\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&nbsp;</td>\n\t\t<td class=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&nbsp;</td>\n\t\t\n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" onMouseDown=\'showErrors(this)\'>\n\t\t\t\t<a href=\"#\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</a>\n\t\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\t \t\t\t\t\t\t\t\t\t\t   \t\t\t\t\t\t \n\t\t\n\n\t\t\n\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n<!--\t\t\terr_msg=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" -->\t\t \n\t</tr>\n\t ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n</table>\n<INPUT TYPE=\"hidden\" name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n<INPUT TYPE=\"hidden\" name=\"mode\" id=\"mode\" value=\"U\">\n<INPUT TYPE=\"hidden\" name=\"job\" id=\"job\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"what\" id=\"what\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"interval\" id=\"interval\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"process_id\" id=\"process_id\" value=\"\">\n<!-- <INPUT TYPE=\"hidden\" name=\"process_val\" id=\"process_val\" value=\"\"> -->\n<INPUT TYPE=\"hidden\" name=\"process\" id=\"process\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"select_option\" id=\"select_option\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"last_date\" id=\"last_date\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"next_date\" id=\"next_date\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"long_desc\" id=\"long_desc\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"intervalss\" id=\"intervalss\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"err_msg\" id=\"err_msg\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"action_type\" id=\"action_type\" value=\"U\">\n<INPUT TYPE=\"hidden\" name=\"proc_date\" id=\"proc_date\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"actionduplicate\" id=\"actionduplicate\" value=\"\"> \n<INPUT TYPE=\"hidden\" name=\"functionID\" id=\"functionID\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"> \n\n\n<script>\n\nfunction funAction(typ)\n{\n\tdocument.forms[0].action_type.value = typ;\n\n\tfunSubmit();\n}\nfunction funSubmit()\n{\n\tvar act = \'../../eXH/jsp/AdminOracleJobProcessList.jsp?\';\t\t\t   \n\tthis.document.forms[0].action = act;\n\tthis.document.forms[0].target=\'\';\n\tthis.document.forms[0].submit();\t\n}\n</script>\n\n</form>\t\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

int count = 0;
	boolean boolToggle =  true;	
	String strTDClass = "";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	PreparedStatement pstmt1 = null;
	ResultSet rst1 = null;
	String process_name="";
	PreparedStatement pstmt2 = null;
	ResultSet rst2 = null;
	String job = "";
	String what = "";
	String log_user= "";
	String last_date = "";
	String next_date = "";
	String prev_status = "";
	String qryStr = "";
	String display_what="";
    String interval="";
	String functionID = request.getParameter("functionID") ;
	//String mainModule_id	= request.getParameter("module_id") ;
	 
	String intervalss="";	
	String long_desc="";
	String err_msg = "";
	String qry_id="ADMINORACLEJOBQUERY";
	String select_substr="";
	String this_date = "";

	String SQL1="select proc_id,LONG_DESC from xh_proc_id where proc_srt_cmd=?";

	//String SQL2="SELECT TO_CHAR(msg_date_time, 'DD/MM/YYYY HH:MI:SS AM')||' '||err_msg error FROM sy_proc_msg WHERE UPPER(PROC_ID)=? ";



try
{
	request.setAttribute(XHQueryRender.strQueryId,qry_id);
	request.setAttribute(XHQueryRender.col,"9");
	request.setAttribute(XHQueryRender.maxRec,"15");
	con = ConnectionManager.getConnection(request);
	HashMap resultsQry = XHQueryRender.getResults(request,session,con);
	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
	ArrayList arrCol = null;
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	
	if (boolPrevious == true)
	{
	  strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	  //strPrevious = "Previous";
	}
	else																		    
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
	 strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	 // strNext = "Next";
	}
	else
	{
	   strNext  = " ";
	}


        pstmt1 = con.prepareStatement(SQL1);
		/*con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(SQL);
		pstmt1 = con.prepareStatement(SQL1);
//		pstmt2 = con.prepareStatement(SQL2);
		rst = pstmt.executeQuery();
		
		int count = 0;
		int index = 0;
		String select_option="";
		
		
		while(rst.next()){
			job = rst.getString(1);
			what = rst.getString(2);
			log_user = rst.getString(3);  if(log_user==null) log_user="";
			last_date = rst.getString(4);  if(last_date==null) last_date="";
//			System.out.println("last_date : "+last_date);
			next_date = rst.getString(5);  if(next_date==null) next_date="";
			prev_status = CommonBean.checkForNull(rst.getString(7));
			interval=rst.getString(8);
			intervalss=	interval.substring(8,interval.length());
			intervalss=intervalss.substring(0,intervalss.length()-5);
			prev_status = ("".equals(prev_status))?"Idle":prev_status;
			qryStr = count%2==0?"QRYEVEN":"QRYODD";
			index=what.indexOf('(');
			display_what=what.substring(0,index==-1?what.indexOf(';'):index);
				System.out.println("display_what : "+display_what);						   
			pstmt1.setString(1,display_what);
			rst1 = pstmt1.executeQuery();	 
			if(rst1.next()) select_option=rst1.getString(1);
			if(select_option.equals("XIQTYUPD")){
				select_option = "XIPO";
			}
			if(rst1!=null)rst1.close();
				System.out.println("select_option : "+select_option);
	/*	    pstmt2.setString(1,select_option);
			rst2 = pstmt2.executeQuery();	 
			while(rst2.next())  {
				err_msg=err_msg+"\n"+(String)rst2.getString(1);
			}
//			System.out.println("err_msg : "+err_msg);
			err_msg = java.net.URLEncoder.encode(err_msg);
//			System.out.println("encoded err_msg : "+java.net.URLEncoder.encode(err_msg)); 
			if(rst2!=null)rst2.close();*/

			//interval1=interval.substring(8,10); 
			//long_desc=rst.getString(9);		 
		

		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strPrevious));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strNext));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

	try
	{
		int index = 0;
		String select_option = "";
		String moduleID = "";

for (int j=0; j<arrRow.size();j++)
{
arrCol = (ArrayList)arrRow.get(j);												   
if (boolToggle == true)
{
  strTDClass = "class='QRYEVEN'";
  boolToggle =  false;
}
else
{
  strTDClass = "class='QRYODD'";
 boolToggle =  true;
}

            job = XHDBAdapter.checkNull((String)arrCol.get(0));
			what = XHDBAdapter.checkNull((String)arrCol.get(1));


			

			log_user = XHDBAdapter.checkNull((String)arrCol.get(2));  if(log_user==null) log_user="";

			last_date = XHDBAdapter.checkNull((String)arrCol.get(3));  
			
			next_date = XHDBAdapter.checkNull((String)arrCol.get(4));  if(next_date==null) next_date="";
			
			this_date = XHDBAdapter.checkNull((String)arrCol.get(5));  if(this_date==null) this_date="";
			
			prev_status = CommonBean.checkForNull((String)arrCol.get(6));
		
			interval=XHDBAdapter.checkNull((String)arrCol.get(7));
			  


		 


		    	if(interval.equals("") || interval==null)
				{
				}
				else
				{		intervalss=	interval.substring(8,interval.length());
						intervalss=intervalss.substring(0,intervalss.length()-5);

				}
		

			prev_status = ("".equals(prev_status))?"Idle":prev_status;
			if(!this_date.equals("")) {
					prev_status	=	"Running";
			}
			else{
				if( last_date.equals("") ||  (last_date==null ) ) {
					prev_status	=	"Idle";
				}
			}

			qryStr = count%2==0?"QRYEVEN":"QRYODD";

			index=what.indexOf('(');
			display_what=what.substring(0,index==-1?what.indexOf(';'):index);


				
			pstmt1.setString(1,display_what);
			rst1 = pstmt1.executeQuery();	 									 
			if(rst1.next())
	{
				select_option = rst1.getString(1);	 
				process_name=rst1.getString(2);	
	}

			moduleID = select_option.substring(0,2);
		
																   
			if(select_option.equals("XIQTYUPD")){
				select_option = "XIPO";
			}
			if(rst1!=null)rst1.close();													 
				
	/*	    pstmt2.setString(1,select_option);
			rst2 = pstmt2.executeQuery();	 
			while(rst2.next())  {
				err_msg=err_msg+"\n"+(String)rst2.getString(1);
			}
//			System.out.println("err_msg : "+err_msg);
			err_msg = java.net.URLEncoder.encode(err_msg);
//			System.out.println("encoded err_msg : "+java.net.URLEncoder.encode(err_msg)); 
			if(rst2!=null)rst2.close();*/

			//interval1=interval.substring(8,10);
		    long_desc=XHDBAdapter.checkNull((String)arrCol.get(8));
				 select_substr=select_option.substring(0,2);								   


				 String orginalStr="";
				String orginalTitle=java.net.URLEncoder.encode((job+"-"+what));
					 if((job+"-"+what).length()>90)
					{
					 orginalStr=(job+"-"+what).substring(0,90);
					}
					else
					{
					 orginalStr=(job+"-"+what); 
					}

//System.out.println("interval1 : "+interval1);		
																		  			    
if(functionID.equals("XF_J_ADMNREV_SVR_PROCESS"))								 			    
{
	   if(select_substr.equals("XF")||select_substr.equals("DF")||select_substr.equals("BL"))
		{

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf("check"+count));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(job));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(what));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(select_option));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(intervalss));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(last_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(next_date));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(err_msg));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(process_name+" - "+(orginalTitle)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(orginalStr));
            _bw.write(_wl_block27Bytes, _wl_block27);
 if (last_date.equals("")) { 
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block29Bytes, _wl_block29);
 } else {  	
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(last_date));
            _bw.write(_wl_block31Bytes, _wl_block31);
 } 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(next_date));
            _bw.write(_wl_block34Bytes, _wl_block34);
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(select_option));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(job));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(what));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(intervalss));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(next_date));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(prev_status));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(err_msg));
            _bw.write(_wl_block41Bytes, _wl_block41);
count++;}	}										 
else
	{																 			 
	
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf("check"+count));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(job));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(what));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(select_option));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(intervalss));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(last_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(next_date));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(err_msg));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(process_name+" - "+(orginalTitle)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(orginalStr));
            _bw.write(_wl_block45Bytes, _wl_block45);
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(log_user));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(last_date));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(next_date));
            _bw.write(_wl_block50Bytes, _wl_block50);
 if("DF".equalsIgnoreCase(moduleID) || "XF".equalsIgnoreCase(moduleID) || "BL".equalsIgnoreCase(moduleID)){ 
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(select_option));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(job));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(what));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(intervalss));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(next_date));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(prev_status));
            _bw.write(_wl_block52Bytes, _wl_block52);
}else{
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(prev_status));
            _bw.write(_wl_block54Bytes, _wl_block54);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(err_msg));
            _bw.write(_wl_block56Bytes, _wl_block56);

	count++;													 
	}

		}							   
	}
	catch(Exception e){
			System.err.println("Err Msg From AdminOracleJobProcessList.jsp first: "+e);
		}
		
		}	catch(Exception e){
			System.err.println("Err Msg From AdminOracleJobProcessList.jsp : "+e);
	}finally{
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		if(pstmt1!=null)pstmt1.close();
		if(rst2!=null)rst2.close(); 
		if(pstmt2!=null)pstmt2.close();
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(count));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(functionID));
            _bw.write(_wl_block59Bytes, _wl_block59);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Process.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LastExecution.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NextExecution.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
}
