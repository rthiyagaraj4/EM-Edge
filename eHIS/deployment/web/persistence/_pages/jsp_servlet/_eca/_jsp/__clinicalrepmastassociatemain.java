package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __clinicalrepmastassociatemain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ClinicalRepMastAssociateMain.jsp", 1709115753589L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCA/js/ClinicalRepMast.js\'></script>\n<script>\nfunction f1()\n{\n\t//var mode=document.forms[0].mode.value;\n\t//if(mode==\'update\')\n\teval(\"parent.frames[2].document.DiscrPanelQueryResult_form\"+";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =");\n\t\t\n}\n</script>\n</head>\n\n\n<body  OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' onLoad=\"contrsystempop()\" >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\n<form name=\'ClinicalRepMastAssociate_form\' id=\'ClinicalRepMastAssociate_form\'  method=\'post\' target=\'messageFrame\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\'  width=\'102%\' align=\'left\'>\n<tr>\n    \n\t\t<td class=label align=\'right\' width=\'25%\'>&nbsp;&nbsp;Contr System</td>\n\t\t\n\t\t<td align=left>&nbsp;&nbsp;<select name=\'contr_system\' id=\'contr_system\' onChange=\"displayContributingEvents();\">\n\t\t<option value=\"\">-----------Select------------</option>\n\t\t</select>\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n</tr>\n\n<tr>\n\t    <td  class=label align=right>Event Code</td>\n\t\t<td>&nbsp;\n\t\t<input type=\"text\" name=\"event_code\" id=\"event_code\" size=\"10\" maxlength=\"20\" value=\"\" onblur=\'\'><input type=\"button\" value=\"?\" class=\"button\" onClick=\"callEvent()\" name=\'search\' id=\'search\'  >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' name=\'mand2\'></img>\n\t\t</td>\n</tr>\n<tr><td  class=label align=right><b>Description</b></td>\n\t\t<td>&nbsp;</td>\n</tr>\n<tr>\n\t<td  align=\'right\' class=\'label\' >Long </td>\n\t<td  align=\'left\'>&nbsp;&nbsp;<input type=\'text\'  name=\'long_desc\' id=\'long_desc\' value=\"\"   size=\"60\" maxlength=\"60\" onBlur=\"makeValidString(this)\"\" >\n\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n</tr>\n\n<tr>\n\t<td  align=\'right\' class=\'label\'>Short</td>\n\t<td  align=\'left\'>&nbsp;&nbsp;<input type=\'text\'  name=\'short_desc\' id=\'short_desc\' value=\"\"  size=\"30\" maxlength=\"30\"  onBlur=\"makeValidString(this)\" >\n\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n</tr>\n\n</table>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\'  width=\'102%\' align=\'left\'>\n<tr>\n    \n\t\t<td class=label align=\'right\' width=\'25%\'>&nbsp;&nbsp;Contr System</td>\n\t\t\n\t\t<td align=left>&nbsp;&nbsp;<select name=\'contr_system\' id=\'contr_system\' onChange=\"displayContributingEvents();\">\n\t\t<option value=\"\">-----------Select------------</option>\n\t\t</select>\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n</tr>\n<tr>\n\t    <td  class=label align=right>Event Code</td>\n\t\t<td>&nbsp;\n\t\t<input type=\"text\" name=\"event\" id=\"event\" size=\"1\" maxlength=\"1\" value=\"$\" disabled><input type=\"text\" name=\"event_code\" id=\"event_code\" size=\"10\" maxlength=\"20\" value=\"\" >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' name=\'mand2\'></img>\n\t\t</td>\n</tr>\n</tr>\n<tr><td  class=label align=right><b>Description</b></td>\n\t\t<td>&nbsp;</td>\n</tr>\n<tr>\n\t<td  align=\'right\' class=\'label\' >Long </td>\n\t<td  align=\'left\'>&nbsp;&nbsp;<input type=\'text\'  name=\'long_desc\' id=\'long_desc\' value=\"\"   size=\"60\" maxlength=\"60\" onBlur=\"makeValidString(this)\"\" >\n\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n</tr>\n\n<tr>\n\t<td  align=\'right\' class=\'label\'>Short</td>\n\t<td  align=\'left\'>&nbsp;&nbsp;<input type=\'text\'  name=\'short_desc\' id=\'short_desc\' value=\"\"  size=\"30\" maxlength=\"30\"  onBlur=\"makeValidString(this)\" >\n\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n</tr>\n\n</table>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n     \n<input type=\'hidden\' name=\'contr_system1\' id=\'contr_system1\' value=\'\'>\n<input type=\'hidden\' name=\'event_code1\' id=\'event_code1\' value=\'\'>\n<input type=\'hidden\' name=\'long_desc1\' id=\'long_desc1\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=\'hidden\' name=\'short_desc1\' id=\'short_desc1\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n</form>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eCommon.RecordSet associateDiagBean= null;synchronized(session){
                associateDiagBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("associateDiagBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(associateDiagBean==null){
                    associateDiagBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("associateDiagBean",associateDiagBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(associateDiagBean.clearAll()));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con=null;
	//PreparedStatement pstmt=null;
		
	String long_desc="";
	String short_desc="";

	con =	ConnectionManager.getConnection(request);
	String source=request.getParameter("source");
	
	
            _bw.write(_wl_block9Bytes, _wl_block9);

	if (source.equals("U"))
	{

            _bw.write(_wl_block10Bytes, _wl_block10);
}
else
{
            _bw.write(_wl_block11Bytes, _wl_block11);
}
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
