package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmreceiveatmrd extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMReceiveAtMRD.jsp", 1726137016524L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tCreated On\t: 6/15/2002\n\tCreated By\t: Nanda Kumar R.\n\tModule\t\t: File Management (FM)\n\tFunction\t: Return File to MRD\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eFM/js/FMParam.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMReturnMRDFile.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\t\t\tvar errortext = getMessage(\'FM_NO_USER_RIGHTS\',\'FM\');\n\t\t\t\talert(errortext);\n\t\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' frameborder=\'0\' scrolling=no noresize style=\'height:8vh;width:100vw\'></iframe>\n<iframe name=\'default_val_frame\' id=\'default_val_frame\' src=\'../../eFM/jsp/FMReceiveFileMRDDefault.jsp?doc_or_file=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&user_security_yn=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&dflt_narr_code_for_note_rtn=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&accessAll=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&dflt_archive_fs_locn_code=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' frameborder=\"0\" scrolling=\'no\' noresize style=\'height:15vh;width:100vw\'></iframe>\n<iframe name=\'search_criteria_frame\' id=\'search_criteria_frame\' src=\'../../eFM/jsp/FMReceiveFileMRDSearch.jsp?doc_or_file=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&accept_out_intransit_yn=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'  frameborder=0 scrolling=\'no\' noresize style=\'height:33vh;width:100vw\'></iframe>\n<iframe name=\'select_files\' id=\'select_files\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize style=\'height:28vh;width:100vw\'></iframe>\n<iframe name=\'color_frame\' id=\'color_frame\' src=\'../../eFM/jsp/FMColorFile.jsp?&p_param=RECEIVE&doc_or_file=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:4vh;width:100vw\'></iframe>\n<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' scrolling=\'no\' frameborder=0 noresize style=\'height:12vh;width:100vw\'></iframe>\n\t \n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<form name=LoadReqFiles> </form>\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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

	Connection con				= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;

	Properties p		= (Properties) session.getValue("jdbc" ) ;
	String addedById	= p.getProperty( "login_user" ) ;
	String facilityid	= (String) session.getValue("facility_id");
	
try
{
	String url		= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source	= url + params ;

	String sql 							= "";
	String sql1 						= "";
	String p_user_security_yn			= "";
	String dflt_narr_code_for_note_rtn	= "";
	String dflt_archive_fs_locn_code	= "";
	String doc_or_file					= "";
	String accessAll					= "";
	String accept_out_intransit_yn      = "";
	
	stmt = con.createStatement();
	
	rs = stmt.executeQuery("Select MAINTAIN_DOC_OR_FILE from MP_PARAM ");
	if(rs != null && rs.next()) 
	{
		 doc_or_file = rs.getString("MAINTAIN_DOC_OR_FILE");			
	}
	if(rs != null) rs.close();
	
	sql = "select user_security_yn,dflt_narr_code_for_note_rtn,dflt_archive_fs_locn_code,accept_out_intransit_yn from fm_parameter where facility_id = '"+facilityid+"' ";
	rs  = stmt.executeQuery(sql);
	while(rs != null && rs.next())
	{
		p_user_security_yn			= rs.getString("user_security_yn");
		dflt_narr_code_for_note_rtn	= rs.getString("dflt_narr_code_for_note_rtn");
		dflt_archive_fs_locn_code	= rs.getString("dflt_archive_fs_locn_code");
		accept_out_intransit_yn 	= rs.getString("accept_out_intransit_yn");
	} if(rs != null) rs.close();

	if (p_user_security_yn.equals("Y"))
	{

		sql1 = "select 1 accessAll, fs_locn_code from fm_user_access_rights where facility_id = ? and appl_user_id = ?  and receive_file_yn = 'Y' ";
		
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,facilityid);
		pstmt.setString(2,addedById);
		
		rs = pstmt.executeQuery();
		
		if(rs.next())
		{
			accessAll = rs.getString("fs_locn_code");
		}
		else
		{
			
            _bw.write(_wl_block8Bytes, _wl_block8);

		}
	}


            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(source));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(doc_or_file));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_user_security_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(dflt_narr_code_for_note_rtn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(accessAll));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(dflt_archive_fs_locn_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(doc_or_file));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(accept_out_intransit_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(doc_or_file));
            _bw.write(_wl_block18Bytes, _wl_block18);

if(rs!=null)	rs.close();
if(stmt!=null) stmt.close();
if(pstmt!=null) pstmt.close();
}catch(Exception e){out.println(e);}
finally
{			
	ConnectionManager.returnConnection(con,request);	
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
