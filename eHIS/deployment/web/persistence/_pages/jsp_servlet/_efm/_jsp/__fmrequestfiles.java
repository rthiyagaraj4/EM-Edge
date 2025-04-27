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

public final class __fmrequestfiles extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMRequestFiles.jsp", 1725364738655L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tCreated On\t: 6/11/2002\n\tCreated By\t: Nanda Kumar R.\n\tModule\t\t: File Management (FM)\n\tFunction\t: FM Request for Files\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eFM/js/FMParam.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMRequestFile.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<script>\n\t\tvar errortext = getMessage(\'FM_NO_USER_RIGHTS\',\'FM\');\n\t\talert(errortext);\n\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t</script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' frameborder=\'0\' scrolling=no noresize style=\'height:6vh;width:100vw\'></iframe>\n\t\t<iframe name=\'requester_details\' id=\'requester_details\' src=\'../../eFM/jsp/FMRequestFileDetails.jsp?doc_or_file=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&p_user_security_yn=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&p_access_all=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:20vh;width:100vw\'></iframe>\n\t\t<iframe name=\'requestee_details\' id=\'requestee_details\' src=\'../../eFM/jsp/FMRequesteeFileDetails.jsp?doc_or_file=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:6vh;width:100vw\'></iframe>\n\t\t<iframe name=\'search_criteria\' id=\'search_criteria\' src=\'../../eFM/jsp/FMRequestFileSearch.jsp?doc_or_file=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&auto_check_patient_file_request=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' frameborder=0 scrolling=\'auto\' noresize style=\'height:25vh;width:100vw\'></iframe>\n\t\t<iframe name=\'select_files\' id=\'select_files\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize style=\'height:28vh;width:100vw\'></iframe>\n\t\t<iframe name=\'color_frame\' id=\'color_frame\' src=\'../../eFM/jsp/FMColorFile.jsp?p_param=REQ&doc_or_file=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:3vh;width:100vw\'></iframe>\n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' scrolling=\'auto\' frameborder=\'0\' noresize style=\'height:12vh;width:100vw\'></iframe>\n\t\t\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<form name=LoadReqFiles> </form>\n</html>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}


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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null;
	Properties p	= (Properties) session.getValue("jdbc" ) ;
	String addedById	= p.getProperty( "login_user" ) ;
	String facilityid 	= (String) session.getValue("facility_id");

	java.sql.Statement stmt		= null;
	PreparedStatement pstmt = null;
	ResultSet rs		= null;

try
{
	String doc_or_file = "";
	con = ConnectionManager.getConnection(request);	
	
	stmt = con.createStatement();
	if(rs!=null)rs.close();
	rs = stmt.executeQuery("Select MAINTAIN_DOC_OR_FILE from MP_PARAM where module_id='MP' ");
	if(rs.next()) {
		doc_or_file = rs.getString("MAINTAIN_DOC_OR_FILE");			
	}
	if(rs!=null)rs.close();			
	if(stmt!=null)stmt.close();
	
	stmt = con.createStatement();
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String sql 		= "";
	String sql1 		= "";
	String p_user_security_yn	= "";
	String p_access_all = "";
    String auto_check_patient_file_request="";
	/*Below Query Modified for this CRF[SKR-CRF-0012]*/
	sql = "select user_security_yn,auto_check_pat_file_request from fm_parameter where facility_id='"+facilityid+"' ";
	rs  = stmt.executeQuery(sql);

	while (rs.next())
	{
		p_user_security_yn	= rs.getString("user_security_yn");
		auto_check_patient_file_request=rs.getString("auto_check_pat_file_request");
	}
	if(rs!=null)	rs.close();

	if (p_user_security_yn.equals("Y"))
	{
	sql1 = "select 1 rec_cnt , fs_locn_code from fm_user_access_rights where facility_id= ? and  appl_user_id= ?  and (req_yn='Y' or req_across_facilities_yn='Y') ";

		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,facilityid);
		pstmt.setString(2,addedById);		
		rs   = pstmt.executeQuery();

	if (!rs.next())
	{

            _bw.write(_wl_block8Bytes, _wl_block8);
	}else
	{
		p_access_all = rs.getString("fs_locn_code");
	}
if(rs!=null)	rs.close();
if(pstmt!=null) pstmt.close();
}else{
	p_access_all ="*ALL" ;
}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(source));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(doc_or_file));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_user_security_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_access_all));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(doc_or_file));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(doc_or_file));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(auto_check_patient_file_request));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(doc_or_file));
            _bw.write(_wl_block17Bytes, _wl_block17);

if(stmt!=null) stmt.close();				
}
catch(Exception e)
{
	out.println(e);
}
finally
{		
	ConnectionManager.returnConnection(con,request);
}
if(session.getAttribute("p_appl_user_name")!=null)
session.removeAttribute("p_appl_user_name");


            _bw.write(_wl_block18Bytes, _wl_block18);
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
