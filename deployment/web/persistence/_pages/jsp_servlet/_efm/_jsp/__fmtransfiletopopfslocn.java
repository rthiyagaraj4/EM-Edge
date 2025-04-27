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

public final class __fmtransfiletopopfslocn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMTransFileToPopFSLocn.jsp", 1726141411000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tCreated On\t: 1/20/2003\n\tCreated By\t: Marayan Kumar K.R.\n\tModule\t\t: File Management (FM)\n\tFunction\t: Request File\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t<SCRIPT>\n\t\t\t\tvar len = parent.frames[2].document.forms[0].tofslocn.length;\n\t\t\t\tfor(var i=0; i<=len; i++) \n\t\t\t\t{\n\t\t\t\t\tparent.frames[2].document.forms[0].tofslocn.remove(\"tofslocn\");\n\t\t\t\t}\n\t\t\t\tvar opt\t\t= parent.frames[2].document.createElement(\'OPTION\');\n\t\t\t\topt.value\t= \"\";\n\t\t\t\topt.text\t= \"      ----- \"+getLabel(\'Common.defaultSelect.label\',\'common\')+\" -----      \";\n\t\t\t\tparent.frames[2].document.forms[0].tofslocn.add(opt);\n\t\t\t</SCRIPT>\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<SCRIPT>\n\t\t\t\t\tvar opt\t= parent.frames[2].document.createElement(\'OPTION\');\n\t\t\t\t\topt.value =\t\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\t\topt.text = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t\tparent.frames[2].document.forms[0].tofslocn.add(opt);\n\t\t\t\t</SCRIPT>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<SCRIPT>\n\tparent.frames[5].document.location.href=\"../../eCommon/jsp/error.jsp\";\n</SCRIPT>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
	Connection con			= ConnectionManager.getConnection(request);
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;
	String facility_id	= (String) session.getValue("facility_id");
	
	String sql			= "";

	String Dflt_Archive_Locn	= request.getParameter("Dflt_Archive_Locn");
	String Dflt_Lost_Locn		= request.getParameter("Dflt_Lost_Locn");
	String from_locn_code		= request.getParameter("From_locn_code");
	String returning_desc		= request.getParameter("returning_desc");
	String from_fs_locn_id  = request.getParameter("from_fs_locn_id");
	String locn_code 			= request.getParameter("locn_code");
 	if(from_locn_code == null || from_locn_code.equals("null")) from_locn_code = "NOTDEFINED";
	if(returning_desc == null || returning_desc.equals("null")) returning_desc = "";
	if(Dflt_Archive_Locn == null || Dflt_Archive_Locn.equals("null")) Dflt_Archive_Locn = "";
	if(Dflt_Lost_Locn == null || Dflt_Lost_Locn.equals("null")) Dflt_Lost_Locn = "";
	if(locn_code == null || locn_code.equals("null")) locn_code = "";
	if(from_fs_locn_id == null || from_fs_locn_id.equals("null")) from_fs_locn_id = "";
	try 
	{
		if(!(from_locn_code.equals("NOTDEFINED")) && (!(returning_desc.equals("")) || from_fs_locn_id.equals("D") ))
		{
			sql = "SELECT FS_LOCN_CODE ,fm_get_desc.fm_storage_locn (facility_id,fs_locn_code,'"+localeName+"',2 ) SHORT_DESC FROM FM_STORAGE_LOCN   WHERE Facility_Id = ?  AND LOCN_IDENTITY = ?   AND EFF_STATUS = 'E' and LOCN_IDENTITY in ('C','N','T','E','Y','D') AND (FS_LOCN_CODE != ?  AND FS_LOCN_CODE != ?  AND FS_LOCN_CODE != ?)   ORDER BY   2 ";
	
			
			
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,locn_code);
			pstmt.setString(3,from_locn_code);
			pstmt.setString(4,Dflt_Archive_Locn);
			pstmt.setString(5,Dflt_Lost_Locn);
			rs	= pstmt.executeQuery();

			
            _bw.write(_wl_block6Bytes, _wl_block6);

			while(rs != null && rs.next()) 
			{
				
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( rs.getString("fs_locn_code") ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( rs.getString("short_desc")));
            _bw.write(_wl_block9Bytes, _wl_block9);

			}
		}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	}catch(Exception e){out.println("Exception e:"+e);}
	finally
	{			
			ConnectionManager.returnConnection(con,request);		
	}

            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
