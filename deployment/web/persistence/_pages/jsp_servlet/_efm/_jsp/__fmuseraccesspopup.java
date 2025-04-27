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

public final class __fmuseraccesspopup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMUserAccessPopup.jsp", 1724410447138L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<SCRIPT>\n\t\t\tvar len = parent.f_query_add_mod.fm_user_access_form.storage_location.length;\n\t\t\tfor (var i=0; i<=len; i++) \n\t\t\t{\n\t\t\t\tparent.f_query_add_mod.fm_user_access_form.storage_location.remove(\"storage_location\");\n\t\t\t}\n\t\t\tvar opt\t= parent.frames[1].document.createElement(\'OPTION\');\n\t\t\topt.value =\t\"\";\n\t\t\topt.text = \"        --- \"+getLabel(\'Common.defaultSelect.label\',\'common\')+\" ---        \";\n\t\t\tparent.f_query_add_mod.fm_user_access_form.storage_location.add(opt);\n\t\t</SCRIPT>\n\t\t<SCRIPT>\n\t\t\tvar fs_locn_codes=\'\';\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\tvar opt\t= parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\t\topt.value =\t\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\t\topt.text = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t\tparent.f_query_add_mod.fm_user_access_form.storage_location.add(opt);\n\t\t\t\t\t\n\t\t\t\t\tfs_locn_codes = fs_locn_codes + \"|\" + opt.value;\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\tparent.f_query_add_mod.fm_user_access_form.all_fs_locn_codes.value = fs_locn_codes;\n\t</SCRIPT>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<SCRIPT>\n\tparent.frames[2].document.location.href=\"../../eCommon/jsp/error.jsp\";\n</SCRIPT>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	try 
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		String facilityid	= (String) session.getValue("facility_id");
		String locn_code	= request.getParameter("locn_code");

		String sql	= "SELECT A.FS_LOCN_CODE,A.SHORT_DESC,A.LOCN_IDENTITY FROM FM_STORAGE_LOCN A ,FM_PARAMETER B WHERE A.EFF_STATUS='E' AND A.FACILITY_ID='"+facilityid+"' AND A.FACILITY_ID=B.FACILITY_ID AND A.FS_LOCN_CODE NOT IN (B.DFLT_ARCHIVE_FS_LOCN_CODE,B.DFLT_LOST_FS_LOCN_CODE) AND A.LOCN_IDENTITY = DECODE('"+locn_code+"','P','D','"+locn_code+"') AND PERMANENT_FILE_AREA_YN = DECODE('"+locn_code+"','P','Y', 'D','N', A.PERMANENT_FILE_AREA_YN)  order by A.SHORT_DESC";
		rs  = stmt.executeQuery(sql) ;

		
            _bw.write(_wl_block6Bytes, _wl_block6);

			if(rs != null) 
			{
				while(rs.next())
				{
					
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( rs.getString("fs_locn_code") ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( rs.getString("short_desc")));
            _bw.write(_wl_block9Bytes, _wl_block9);

				}
			}
			
            _bw.write(_wl_block10Bytes, _wl_block10);

	if(rs!=null)	rs.close();
	if(stmt!=null) stmt.close();	
}
catch(Exception e)
{
	out.println("Exception e :"+e.toString());
}
finally 
{		
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
