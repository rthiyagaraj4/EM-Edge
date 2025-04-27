package jsp_servlet._eqa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import oracle.jdbc.driver.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __qadisciplinesearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QADisciplineSearch.jsp", 1742817543631L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n    <head>\n<title> Indicator List Entry </title>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script src=\"../../eQA/js/QAMessages.js\" language=\"JavaScript\"></Script>\n<script src=\"../../eCommon/js/Common.js\" language=\"javascript\"> </script>\n<Script src=\"../../eQA/js/QADirRecordOfClinIndicators.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n  <body class=\'content\'  topmargin=\'0\' onKeyDown = \'lockKey()\'>\n  <form name=\"Discipline_Frame\" id=\"Discipline_Frame\">\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<input type=\'hidden\' name=\'QIND_QUERY\' id=\'QIND_QUERY\' value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>\n\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n<tr>\n<td align=\"right\" width=\"30%\" class=\"label\">        \n  <b align=\"left\">\n\tDiscipline&nbsp;\n\t</b>\n\t</td>\n\t<td align=\"left\" width=\"40%\" class=\"label\">        \n\t\t<select name=\'QIND_DISCIPLINE_ID\' id=\'QIND_DISCIPLINE_ID\' onChange=\'funDisiplineList()\'>\n\t\t\t\t\t<option value=\'-1\'>&nbsp;&nbsp;-------- Select --------&nbsp;&nbsp;</option>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\tException occured ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n      ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n </td>\n <td align=\'right\'><input type=\'button\' class=\'button\' value=\'Record\' onClick=\'apply()\'></td>\n <td align=\'left\'><input type=\'button\' class=\'button\' value=\'Cancel\' onClick=\'cancel()\'></td>\n </tr>\n</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

 String queryString="";
 

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
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);


    session.removeAttribute("collectData");
	session.removeAttribute("arr");
 	queryString=request.getQueryString();	
 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

    StringBuffer sqlQindDispId= new StringBuffer();
	sqlQindDispId.append("SELECT  QIND_DISCIPLINE_ID QIND_ID,");
	sqlQindDispId.append(" QIND_DISCIPLINE_DESC QIND_DESC ");
	sqlQindDispId.append(" FROM QA_QIND_DISCIPLINE");

	try
	{
		conn = ConnectionManager.getConnection(request);
		pstmt=conn.prepareStatement(sqlQindDispId.toString());
		rs=pstmt.executeQuery();

		while(rs.next())
		{	 
		out.println("<option value='"+rs.getString("QIND_ID")+"'>");
		out.println(rs.getString("QIND_DESC")+"</option>");
		}	
		out.println("</select>");
        if (rs != null) rs.close();
        if (pstmt != null)  pstmt.close();
        if((sqlQindDispId != null) && (sqlQindDispId.length() > 0))
		{
			sqlQindDispId.delete(0,sqlQindDispId.length());
		}
	}catch(Exception ee)
	{
	  
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(ee));
            _bw.write(_wl_block8Bytes, _wl_block8);

	}
	finally
	{
		 ConnectionManager.returnConnection(conn, request);
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
