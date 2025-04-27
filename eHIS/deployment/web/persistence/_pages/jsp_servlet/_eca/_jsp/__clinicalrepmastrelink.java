package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __clinicalrepmastrelink extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ClinicalRepMastRelink.jsp", 1742381712866L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\n <script src=\'../../eCA/js/ClinicalRepMast.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../js/CAMessages.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<form name=\'ClinicalRepMastRelink_form\' id=\'ClinicalRepMastRelink_form\'  method=\'post\' target=\'messageFrame\' >\n<body  class=\'CONTENT\' OnMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\"  >\n\n<table border=0 cellspacing=0 cellpadding=0 width=\'100%\' align=center>\n\n<tr>\n\t<td class=label align=right>History Type </td>\n\t<td align=left>&nbsp;\n\t<select name=\'hist_rec_type\' id=\'hist_rec_type\' onChange=\'contrsystempop3()\' >\n\t\t<option value=\"\">---------------Select--------------</option>\t\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<option value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</option>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</select>\n\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n\n\t<td class=label align=\'right\' >Contr System</td>\n\t\t\n\t<td align=left>&nbsp;&nbsp;<select name=\'contr_system\' id=\'contr_system\' >\n\t<option value=\"\">-------Select-----</option>\n\t</select>\n\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\n\t<td  class=label align=right>Event Code</td>\n\t<td>&nbsp;\n\t<input type=\"text\" name=\"event_code\" id=\"event_code\" size=\"10\" maxlength=\"20\" value=\"\" onblur=\'callforPrompt(this)\'><input type=\"button\" value=\"?\" class=\"button\" onClick=\"callEvent1()\" name=\'search\' id=\'search\'  >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' name=\'mand2\'></img>\n\t</td>\n\n</tr>\n\n</table>\n<input type=hidden name=hist_rec_type1 id=hist_rec_type1 value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n<input type=hidden name=add_source1 id=add_source1 value=\"\">\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'insert\'>\n</form>\n\n</body>\n</html>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);

request.setCharacterEncoding("UTF-8");	
Connection con=null;
StringBuffer sql = new StringBuffer();
String hist_rec_type	=	"";
//String read_only = "";
try
{
	PreparedStatement stmt=null;
	ResultSet rs=null;
	con=ConnectionManager.getConnection(request);

            _bw.write(_wl_block4Bytes, _wl_block4);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	    sql = new StringBuffer();	
		sql.append("select HIST_REC_TYPE,LONG_DESC from  cr_hist_rec_type order by 1 ");

		stmt = con.prepareStatement(sql.toString());
		rs = stmt.executeQuery();

		while(rs.next())
		{
			hist_rec_type = rs.getString("HIST_REC_TYPE");
			String long_desc = rs.getString("LONG_DESC");
		
			
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(hist_rec_type));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
}
			
			//added new
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();

	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(hist_rec_type));
            _bw.write(_wl_block11Bytes, _wl_block11);

	
}
catch(Exception e)
{
	out.println("From ClinicalRepMastMainEvent.jsp" + e.toString());
	e.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
