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

public final class __recclinicalnotescheckcannedtext extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesCheckCannedText.jsp", 1709116116215L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n<html><head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\'javascript\'>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.enable_cannedtext.value = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\t\tvar url = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.location.href;\n//\t\talert(url);\n\t\tif(url.indexOf(\'/eCA/jsp/RTEditor.jsp\')!=-1 || url.indexOf(\'/eCA/jsp/RecClinicalNotesEditorsFrame.jsp\')!=-1)\n\t\t{\n\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.canned_text.disabled = ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =";\n\t\t}\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n</head><body class=\'message\' OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'></body></html>\n";
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

	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection			con		=	null;
	PreparedStatement	pstmt	=	null;
	ResultSet			rs		=	null;

	String	query_canned_text	=	"",		service_code	=	"";
	String	login_user_id		=	"",		note_type		=	"";
	String	sec_hdg_code		=	"";

	boolean	enable_cannedtext	=	false;

	try
	{
		con				=	ConnectionManager.getConnection(request);
		login_user_id	=	(String) session.getValue("login_user");
		service_code	=	(request.getParameter("service_code")==null) ?	""	:	request.getParameter("service_code");
		note_type		=	(request.getParameter("note_type")==null)	 ?	""	:	request.getParameter("note_type");
		sec_hdg_code	=	(request.getParameter("sec_hdg_code")==null) ?	""	:	request.getParameter("sec_hdg_code");

		//out.println("Query String : "+request.getQueryString());

		if(service_code==null)		service_code	= "";

		//query_canned_text = "Select text_blk_id, text_blk from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***') ) = nvl(?,'***') ";
		query_canned_text = "Select text_blk_id, CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk 	from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***') ) = nvl(?,'***')";
		/*
		out.println("<br>service_code	: "+service_code);
		out.println("<br>login_user_id	: "+login_user_id);
		out.println("<br>note_type		: "+note_type);
		out.println("<br>sec_hdg_code	: "+sec_hdg_code);
		out.println("<br>query_canned_text	: "+query_canned_text);
		*/
		
		pstmt		=	con.prepareStatement(query_canned_text);

		pstmt.setString(1,locale);
		pstmt.setString(2,service_code);
		pstmt.setString(3,service_code);
		pstmt.setString(4,login_user_id);
		pstmt.setString(5,login_user_id);
		pstmt.setString(6,note_type);
		pstmt.setString(7,note_type);
		pstmt.setString(8,sec_hdg_code);
		pstmt.setString(9,sec_hdg_code);
		
		rs			=	pstmt.executeQuery();

		if(rs.next())
		{
			enable_cannedtext = true;
		} // end of if(rs.next())
		else
		{
			enable_cannedtext = false;
		} // end of else if(rs.next())
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(enable_cannedtext));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((!(enable_cannedtext))));
            _bw.write(_wl_block10Bytes, _wl_block10);
	
	
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception@1:"+e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{

            _bw.write(_wl_block11Bytes, _wl_block11);

		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
