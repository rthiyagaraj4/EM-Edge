package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __reprsmasterlistform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/repRSMasterListForm.jsp", 1709121646465L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'></link><script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\"../../eRS/js/repRSMasterList.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body  OnMouseDown=\"CodeArrest()\" onLoad=\"codeCheck(\'code\')\" >\n<form name=\"menu_form\" id=\"menu_form\" >\n\n\n<BR>\n<div align=\"left\">\n\n  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"50%\" align=\'center\'>\n\n     <tr >\n      <td width=\"20%\" align=\"right\" class=\"label\"> </td>\n      <td width=\"20%\"></td>\n\n    <td width=\"50%\" align=\"left\" class=\"label\">\n    ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n    </td>\n\n     </tr>\n     <tr>\n      <td width=\"30%\" align=\"right\" class=\"label\">Code &nbsp;</td>\n\t        <td width=\"20%\" align=\"left\" colspan=\"2\">\n\t\t\t<select name=\"code\" id=\"code\"  onChange=\"codeCheck(this.value)\" >\n\t<option value=\' \' selected>&nbsp;------- Select -------&nbsp;\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t<option value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n    </select></td>\n    </tr>\n    <tr>\n\t\t<td>&nbsp;</td>\n\t\t<td>&nbsp;</td>\n\t\t<td>&nbsp;</td>\n\t</tr>\n   </table>\n</form>\n<script>document.forms[0].code.focus();</script>\n</div>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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


	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs=null ;
	String strd="";

            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(strd));
            _bw.write(_wl_block5Bytes, _wl_block5);

try {
		con = ConnectionManager.getConnection(request);
	      if(con==null)out.println("one");
	      
	      String sql = "Select  table_id,master_code_desc from sm_master_code where module_id='RS' order by master_code_desc";
		  pstmt = con.prepareStatement(sql);
	      rs    = pstmt.executeQuery();
	      if( rs != null )
	      {
	          while( rs.next())
	          {
	        	String classname  = rs.getString("table_id") ;
	        	String classname1 = rs.getString("master_code_desc");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( classname ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( classname1 ));
            _bw.write(_wl_block1Bytes, _wl_block1);

	          }
	      }

} catch(Exception e) {  out.println("in else "+e);}
finally {
  if (rs    != null)    rs.close();
  if (pstmt != null) pstmt.close();
  ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
