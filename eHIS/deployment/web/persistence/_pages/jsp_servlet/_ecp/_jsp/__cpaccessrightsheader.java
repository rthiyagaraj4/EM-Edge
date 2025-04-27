package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import eCP.*;
import eCommon.Common.*;
import com.ehis.eslp.*;

public final class __cpaccessrightsheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/CPAccessRightsHeader.jsp", 1709116575965L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n*\tCopyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teCP\n*\tPurpose \t\t:\t\n*\tCreated By\t\t:\tHema Malini B\n*\tCreated On\t\t:\t22 Jan 2005\n\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n  ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'></link>\n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/messages.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n  <script src=\"../js/CPAccessRights.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction clearval()\n{\n\tdocument.cp_access_right_header.practitioner_name.value=\"\";\n} \n</script>\n</head>\n<body onKeyDown = \'lockKey()\';  OnMouseDown=\"CodeArrest()\">\n ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<form name=\"cp_access_right_header\" id=\"cp_access_right_header\">\n\t <br>\n     <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' width=\"90%\">\n\t \t <tr><td colspan=\"4\">&nbsp;</td></tr>\n     <tr>\n\t\t<td align=\"right\" class=\"label\" >&nbsp;<fmt:message key=\"Common.practitionertype.label\" bundle=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"/>&nbsp;</td>\n\t\t<td align=\"left\" class=\"label\" >&nbsp;\n\t\t<select name=\"practitioner_type\" id=\"practitioner_type\" onchange=\'clearDetail();\'>\n\t\t<option value=\"\" selected> &nbsp&nbsp--------- <fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/> --------- </option>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t</select>\n\t\t</td> <td>&nbsp;</td><td>&nbsp;</td>\n\t\t</tr>\n\t\t<tr><td align=\"right\" class=\"label\">&nbsp;<fmt:message key=\"Common.practitionername.label\" bundle=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/>&nbsp;</td>\n\t\t<td align=\"left\" class=\"label\" >&nbsp;&nbsp;<input type=\"text\" name=\"practitioner_name\" id=\"practitioner_name\" maxlength=\"30\" size=\"30\" onchange=\'clearDetail();\'></td>\n\t\t<TD align=\'left\'>\n\t\t\t<SELECT name=\"search_text\" id=\"search_text\" onchange=\'clearDetail();\'><!-- onchange=\"clearval()\"-->\n\t\t\t<OPTION Value=\"C\"><fmt:message key=\"Common.contains.label\" bundle=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/></OPTION>\n\t\t\t<OPTION value=\"S\">Stats With</OPTION>\n\t\t\t<OPTION Value=\"E\"><fmt:message key=\"Common.endsWith.label\" bundle=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/></OPTION>\n\t\t\t</SELECT>\n\t\t</TD><td>&nbsp;</td>\n\t\t</tr>\n\t\t<tr><td align=\"right\" class=\"label\">&nbsp;<fmt:message key=\"Common.practitionerid.label\" bundle=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/>&nbsp;</td>\n\t\t<td align=\"left\" class=\"label\" >&nbsp;&nbsp;<input type=\"text\" name=\"practitioner_id\" id=\"practitioner_id\" maxlength=\"15\" size=\"15\" onchange=\'clearDetail();\'></td>\n\t\t<td>&nbsp;</td>\n\t\t<td  align=\"right\"><input type=button class=button value=\'<fmt:message key=\"Common.search.label\" bundle=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/>\' onclick=\'searchDetails()\'>&nbsp;&nbsp;</td>\n\t\t\n\t\t </tr>\n\t\t <tr><td colspan=\"4\">&nbsp;</td></tr>\n\t\t  </table>\t\n\t  </form>\n ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</body>\n</html>\n\n\n\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

  //This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
 
	  Connection con 	      = null;
	  PreparedStatement pstmt = null;
	  ResultSet rs		      = null;
try
   {
     con = ConnectionManager.getConnection(request);
	 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);

		String pract_type ="";
		pract_type = "Select pract_type, desc_userdef from am_pract_type where eff_status = 'E' order by desc_userdef";
		pstmt =con.prepareStatement(pract_type);
		rs = pstmt.executeQuery( );
		while(rs!=null  && rs.next())
		 {
			out.println("<option value='"+rs.getString("pract_type")+"'>"+rs.getString("desc_userdef")+""); 
		 }
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
}catch(Exception e)
	{
		//out.println("Error is ---"+e);//COMMON-ICN-0181
                e.printStackTrace();//COMMON-ICN-0181
	}
finally
  {
  			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			ConnectionManager.returnConnection(con,request);
  }

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
