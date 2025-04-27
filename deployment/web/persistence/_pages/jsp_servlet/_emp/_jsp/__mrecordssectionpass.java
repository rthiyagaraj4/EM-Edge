package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __mrecordssectionpass extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/MRecordsSectionPass.jsp", 1709628643559L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t<html>\n\t\t\t\t<head>\n\t\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t\t<Script language=\'javascript\' src=\'../js/MRecordsSection.js\'></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t\t\t</head>\n\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'../../eCommon/html/blank.html\' frameborder=0 style=\'height:83vh;width:100vw\'></iframe>\n\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/MstCodeError.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:9vh;width:100vw\'></iframe>\n\t\t\t</html>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<html> \t\t\t\t\n\t\t\t\t\n\t\t\t\t<Script language=\"JavaScript\">\n\t\t\t\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\talert(getMessage(\"MR_SECTION_NOT_ALL_FAC\",\'MP\'));\n\t\t\t\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t</Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t</html>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<html> \t\n\t\t\t\t<Script language=\"JavaScript\">\n\t\t\t\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\talert(getMessage(\"MP_PARAM_NOT_FOUND\",\'MP\'));\n\t\t\t\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t</Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t</html>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block5Bytes, _wl_block5);

	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
	Connection con = null;
	PreparedStatement pstmt =null;
	ResultSet rs=null;
	ResultSet rs1=null;
	String facilityid = (String) session.getValue("facility_id");
	String separate_file_no_yn="N";
	String single_or_multi_files_ind="";
	boolean proceed = false;

try {
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("Select single_or_multi_files_ind,separate_file_no_yn from mp_param_for_facility where facility_id='" + facilityid + "' ");
	rs = pstmt.executeQuery();
	if(rs != null) {
		if(rs.next()) {
			separate_file_no_yn=rs.getString("separate_file_no_yn")==null ? "N" : rs.getString("separate_file_no_yn");
			single_or_multi_files_ind=rs.getString("single_or_multi_files_ind")==null ? "S" : rs.getString("single_or_multi_files_ind");
			proceed = true;
		}
		else {
			try{
				pstmt=con.prepareStatement("Select single_or_multi_files_ind,separate_file_no_yn from mp_param");
				rs1 = pstmt.executeQuery();
				if(rs1 != null) {
					if(rs1.next()) {
						separate_file_no_yn=rs1.getString("separate_file_no_yn")==null ? "N" : 	rs1.getString("separate_file_no_yn");
						single_or_multi_files_ind=rs1.getString("single_or_multi_files_ind")==null ? "S" : rs1.getString("single_or_multi_files_ind");
						proceed = true;
					}
				}
			}catch(Exception e) { 
				e.printStackTrace();
				// out.println("Exception :"+e.toString());
				}
			finally
			{
				if (pstmt != null) pstmt.close();
				if (rs1 != null) rs1.close();
			}
		}
	}
	else {
		try{
			pstmt=con.prepareStatement("Select single_or_multi_files_ind,separate_file_no_yn from mp_param");
			rs1 = pstmt.executeQuery();
			if(rs1 != null) {
				if(rs1.next()) {
					separate_file_no_yn=rs1.getString("separate_file_no_yn")==null ? "N" : 	rs1.getString("separate_file_no_yn");
					single_or_multi_files_ind=rs1.getString("single_or_multi_files_ind")==null ? "S" : rs1.getString("single_or_multi_files_ind");
					proceed = true;
				}
			}
		}catch(Exception e) { 
			e.printStackTrace();
			//out.println("Exception :"+e.toString());
			}
		finally
		{
			if (pstmt != null) pstmt.close();
			if (rs1 != null) rs1.close();
		}
	}
}catch(Exception e) { 
	e.printStackTrace();
	//out.println("Exceptiom :"+e.toString());
	}
finally {
	if(pstmt !=null) pstmt.close();
	if(rs!=null) rs.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

	if(proceed && ((single_or_multi_files_ind.equals("M") && separate_file_no_yn.equals("N")) || (single_or_multi_files_ind.equals("M") && separate_file_no_yn.equals("Y")) || (single_or_multi_files_ind.equals("S") && separate_file_no_yn.equals("Y")))) {
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(source));
            _bw.write(_wl_block7Bytes, _wl_block7);

	}
	else if( proceed && (single_or_multi_files_ind.equals("S") && separate_file_no_yn.equals("N"))) {
		
            _bw.write(_wl_block8Bytes, _wl_block8);

	}
	else {
		
            _bw.write(_wl_block9Bytes, _wl_block9);

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
