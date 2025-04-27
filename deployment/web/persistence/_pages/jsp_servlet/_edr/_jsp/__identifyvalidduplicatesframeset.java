package jsp_servlet._edr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __identifyvalidduplicatesframeset extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/IdentifyValidDuplicatesFrameset.jsp", 1734170402462L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Developed By       :  P.Sudhakaran -->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eDR/js/IdentifyValidDuplicates.js\'></script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\" ></Script>\n<!-- \t<script language=\"javascript\" src=\"../../eDR/js/DRrowcolor.js\" ></script> -->\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/rowcolor.js\"></Script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<FRAMESET COLS=\"28,72\">\n\t\t\t<FRAMESET ROWS=\'80,*\'>\n\t\t\t\t<FRAME NAME=\'GROUP_TITLE\' id=\'GROUP_TITLE\' FRAMEBORDER=\'0\' SRC=\"../../eDR/jsp/IdentifyValidDuplicateHeaderTitle.jsp?modal=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&grp_no=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" scrolling=\'no\' noresize>\n\t\t\t\t<FRAMESET COLS=\'92%,*\'>\n\t\t\t\t\t<FRAME NAME=\'GROUP_HDR\' id=\'GROUP_HDR\' FRAMEBORDER=\'0\'  SRC=\"../../eDR/jsp/IdentifyValidDuplicateHeader.jsp?modal=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" scrolling=\'no\' noresize>\n\t\t\t\t\t<FRAME NAME=\'GROUP_RECORD_IMAGE\' id=\'GROUP_RECORD_IMAGE\' FRAMEBORDER=\'0\'  \tSRC=\"../../eDR/jsp/IdentifyValidDuplicateArrow.jsp?grp_no=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" scrolling=\'no\' noresize>\n\t\t\t\t</FRAMESET>\n\t\t\t</FRAMESET>\n\t\t\t<FRAMESET ROWS=\"14%,14%,*\">\n\t\t\t\t<FRAME NAME=\'SEARCH_SCREEN\'  id=\'SEARCH_SCREEN\' FRAMEBORDER=\'0\' SRC=\'../../eDR/jsp/IdentifyValidDuplicateSearch.jsp?modal=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t\t\t<FRAME NAME=\'GROUP_DTLS_TITLE\' id=\'GROUP_DTLS_TITLE\' FRAMEBORDER=\'0\'  SRC=\'../../eDR/jsp/IdentifyValidDuplicateDetailsTitle.jsp\'>\n\t\t\t    <FRAME NAME=\'GROUP_DTLS\' id=\'GROUP_DTLS\' FRAMEBORDER=0  SRC=\"\">\n\t\t\t</FRAMESET>\n\t\t</FRAMESET>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<FRAMESET COLS=\"28,72\">\n\t\t\t<FRAMESET ROWS=\'60,*\'>\n\t\t\t\t<FRAME NAME=\'GROUP_TITLE\' id=\'GROUP_TITLE\' FRAMEBORDER=0 SRC=\"../../eDR/jsp/IdentifyValidDuplicateHeaderTitle.jsp?modal=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" scrolling=no noresize>\n\t\t\t\t<FRAMESET COLS=\'92%,*\'>\n\t\t\t\t\t<FRAME NAME=\'GROUP_HDR\' id=\'GROUP_TITLE\' FRAMEBORDER=0  SRC=\"../../eDR/jsp/IdentifyValidDuplicateHeader.jsp?modal=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" scrolling=\'no\' noresize>\n\t\t\t\t\t<FRAME NAME=\'GROUP_RECORD_IMAGE\' id=\'GROUP_RECORD_IMAGE\' FRAMEBORDER=0  SRC=\"../../eDR/jsp/IdentifyValidDuplicateArrow.jsp?grp_no=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" scrolling=\'no\' noresize>\n\t\t\t\t</FRAMESET>\n\t\t\t</FRAMESET>\n\t\t\t<FRAMESET ROWS=\"14%,14%,*\">\n\t\t\t\t<FRAME NAME=\'SEARCH_SCREEN\' id=\'SEARCH_SCREEN\' FRAMEBORDER=\'0\' SRC=\'../../eDR/jsp/IdentifyValidDuplicateSearch.jsp?modal=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' noresize>\n\t\t\t\t<FRAME NAME=\'GROUP_DTLS_TITLE\' id=\'GROUP_DTLS_TITLE\' FRAMEBORDER=\'0\'  SRC=\'../../eDR/jsp/IdentifyValidDuplicateDetailsTitle.jsp\' noresize>\n\t\t\t\t<FRAME NAME=\'GROUP_DTLS\' id=\'GROUP_DTLS\' FRAMEBORDER=\'0\'  SRC=\"\" noresize>\n\t\t\t</FRAMESET>\n\t\t</FRAMESET>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</html>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
	
	Connection con			= null;
	PreparedStatement pstmt = null;	
	ResultSet rs  			= null;	

	String grp_no	= "";

	try
	{	
		con		= ConnectionManager.getConnection(request);
		//pstmt	= con.createStatement(); 
		
		String sql1		= ""; 		
		
		sql1  = "SELECT count(1) grp_no FROM DR_DUP_GROUP_HDR A,DR_DUP_GROUP_DTLS B WHERE A.DUP_GROUP_ID = B.DUP_GROUP_ID AND system_gen_yn='Y' AND marked_for_merge_yn='N' AND group_status = 'U' AND sug_valid_pat_flag='Y'";
		
		pstmt = con.prepareStatement(sql1);	
		rs    = pstmt.executeQuery();
		if(rs != null)
		{
			if(rs.next())
			{
				grp_no = rs.getString("grp_no");		
			}
		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	
	String modal = request.getParameter("modal");	
	
	if(modal == null || modal.equals("null")) modal = "";

	if(modal.equals("Y"))
	{
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(grp_no));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(grp_no));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(grp_no));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block13Bytes, _wl_block13);

	}
	else
	{
		
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(grp_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(grp_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(grp_no));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block18Bytes, _wl_block18);

	}

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
