package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __waitlistinvitationtabs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/WaitListInvitationTabs.jsp", 1709119287224L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n<html>\n\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n\t -->\n\t ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eOA/js/WaitListInvitation.js\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t\n</head>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\t\t<form name=\'waitlistinvitetabs\' id=\'waitlistinvitetabs\' action=\'../../servlet/eOA.AppointmentWtListServlet\' method=\'post\' target=\'messageFrame\'>\n\t<!-- \t<table name=\'waitlisttabs\' id=\'waitlisttabs\' width=\'100%\' align=\'center\' cellpadding=\'0\' cellspacing=\'0\' border=\'0\'> -->\n\t\t<!-- <tr>\n\t\t<td width=\'95%\' class=\'bodycolorfilled\'>&nbsp;</td> -->\n<!-- \t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<td align=\'right\' ><input type=\'Button\' class=\'button\' name=\'invite\' id=\'invite\' value=\'Invite\' onclick=\'invite_values()\'></td>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<td align=\'right\' ><input type=\'Button\' class=\'button\' disabled name=\'invite\' id=\'invite\' value=\'Invite\' onclick=\'invite_values()\'></td>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<!-- \t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<td >&nbsp;&nbsp;<input type=\'Button\' class=\'button\' name=\'reprint\' id=\'reprint\' value=\'Reprint\'></td>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<td >&nbsp;&nbsp;<input type=\'Button\' class=\'button\' disabled name=\'reprint\' id=\'reprint\' value=\'Reprint\'></td>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t -->\n\t\n\t<!-- <td align=\'right\' >&nbsp;&nbsp<input type=\'Button\' class=\'button\' name=\'clear\' id=\'clear\' value=\'Clear\' onclick=\'clear_val_tabs()\'>&nbsp;&nbsp;</td>  -->\n\n\t\t\n\t\t<!-- </tr> -->\n\t<!-- \t</table> -->\n\t\t\t<input type=\'hidden\' name=\'wait_list_value\' id=\'wait_list_value\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'record_status\' id=\'record_status\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'wait_date_value\' id=\'wait_date_value\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'final_vals\' id=\'final_vals\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'Operation\' id=\'Operation\' value=\'invitation\'>\n\t\t</body>\n\t</html>\n\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

request.setCharacterEncoding("UTF-8");
	Connection con = null;
	String wait_list_status=request.getParameter("wait_list_status");
	if(wait_list_status==null)wait_list_status="";
	
	try{
	
			con = ConnectionManager.getConnection(request);




            _bw.write(_wl_block4Bytes, _wl_block4);
if(!wait_list_status.equals("I")) {
            _bw.write(_wl_block5Bytes, _wl_block5);
}else{
            _bw.write(_wl_block6Bytes, _wl_block6);
}
            _bw.write(_wl_block7Bytes, _wl_block7);
if(wait_list_status.equals("I")) {
            _bw.write(_wl_block8Bytes, _wl_block8);
}else {
            _bw.write(_wl_block9Bytes, _wl_block9);
}
            _bw.write(_wl_block10Bytes, _wl_block10);

	
}
catch(Exception es){
out.println(es);
}
finally{
	ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
