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

public final class __fmcancelrequestpopup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMCancelRequestPopup.jsp", 1726141378290L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<SCRIPT>\n\t\t\tparent.frames[1].document.getElementById(\"CancelFilesHeader_form\").querySelector(\'#fslocation\').length = 0 ;\n\t\t\t// var len = parent.frames[1].CancelFilesHeader_form.fslocation.length;\n\t\t\t//for(var i=0; i<=len; i++) \n\t\t\t//{\n\t\t\t//\tparent.frames[1].CancelFilesHeader_form.remove(\"fslocation\");\n\t\t\t//}\n\t\t\tvar opt\t  = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\topt.value =\t\"\";\n\t\t\topt.text  = \"-----\"+getLabel(\"Common.defaultSelect.label\",\"common\")+\"-----\";\n\t\t\tparent.frames[1].CancelFilesHeader_form.fslocation.add(opt);\n\t\t</SCRIPT>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<SCRIPT>\n\t\t\t var opt\t= parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t opt.value =\t\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="!";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t opt.text = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"; \n\t\t\t parent.frames[1].CancelFilesHeader_form.fslocation.add(opt);\n\t\t</SCRIPT>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<SCRIPT>\n\tparent.frames[4].document.location.href=\"../../eCommon/jsp/error.jsp\";\n</SCRIPT>\n\n";
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
	Connection con				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	

	String access_all	= "";
	String sql			= "";

	try 
	{
		con 	= ConnectionManager.getConnection(request);

		java.util.Properties p		= (java.util.Properties) session.getValue("jdbc");
		String facility_id			= (String) session.getValue("facility_id");
		String user_id				= p.getProperty("login_user");
		
		String locn_code			= request.getParameter("locn_code");
		String userSecurity			= request.getParameter("userSecurity");
		access_all					= request.getParameter("access_all");

		if(access_all == null || access_all.equals("null")) access_all = "";
		if(locn_code == null || locn_code.equals("null")) locn_code = "";
		if(userSecurity == null || userSecurity.equals("null")) userSecurity = "N";		
		if(userSecurity.equals("Y")) 
		{
			if(access_all.equals("*ALL")) //Modified by S.Sathish for IN021089 on Friday, April 30, 2010
			{
				//sql = "Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY from FM_STORAGE_LOCN where facility_id = ? and eff_status = 'E' and LOCN_IDENTITY = ? order by 2";
				sql = "SELECT"
					  +"  FS_LOCN_CODE"
					  +"  , SHORT_DESC"
					  +"  , LOCN_IDENTITY "
					  +"FROM"
					  +"  FM_STORAGE_LOCN_LANG_VW "
					  +"WHERE Facility_Id = ? "
					  +"  AND eff_Status = 'E' "
					  +"  AND LOCN_IDENTITY = ? "
					  +"  AND LANGUAGE_id=? "
					  +"ORDER BY"
					  +"  2";

				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,locn_code);
				pstmt.setString(3,localeName);
			}
			else
			{
				//sql = "Select FS_LOCN_CODE, FS_LOCN_SHORT_DESC, LOCN_IDENTITY from FM_USER_ACCESS_RIGHTS_VW where facility_id = ? and APPL_USER_ID = ? and CANCEL_REQUEST_YN = 'Y' and LOCN_IDENTITY = ? order by 2";
				sql = "SELECT"
								  +"  a.FS_LOCN_CODE"
								  +"  , ("
								  +"  CASE "
								  +"  WHEN A.FS_LOCN_CODE = '*ALL' "
								  +"  THEN"
								  +"    '*ALL' "
								  +"  ELSE B.SHORT_DESC "
								  +"  END)"
								  +"  , LOCN_IDENTITY "
								  +"FROM"
								  +"  FM_USER_ACCESS_RIGHTS A"
								  +"  , FM_STORAGE_LOCN_LANG_VW B "
								  +"WHERE A.FACILITY_ID = B.FACILITY_ID(+) "
								  +"  AND A.FS_LOCN_CODE = B.FS_LOCN_CODE(+) "
								  +"  AND A.Facility_Id = ? "
								  +"  AND A.APPL_USER_ID = ? "
								  +"  AND A.CANCEL_REQUEST_YN = 'Y' "
								  +"  AND LOCN_IDENTITY = ? "
								  +"  AND B.LANGUAGE_ID=? "
								  +"ORDER BY 2";
				
				if(pstmt != null) pstmt.close();				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,user_id);
				pstmt.setString(3,locn_code);
				pstmt.setString(4,localeName);
			}
		}
		else
		{
			//sql = "Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY from FM_STORAGE_LOCN where facility_id = ? and eff_status = 'E' and LOCN_IDENTITY = ? order by 2";
			sql = "SELECT"
					  +"  FS_LOCN_CODE"
					  +"  , SHORT_DESC"
					  +"  , LOCN_IDENTITY "
					  +"FROM"
					  +"  FM_STORAGE_LOCN_LANG_VW "
					  +"WHERE Facility_Id = ? "
					  +"  AND eff_Status = 'E' "
					  +"  AND LOCN_IDENTITY = ? "
					  +"  AND LANGUAGE_id=? "
					  +"ORDER BY 2";


			if(pstmt != null) pstmt.close();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,locn_code);
			pstmt.setString(3,localeName);
		}
		
            _bw.write(_wl_block6Bytes, _wl_block6);

		rs = pstmt.executeQuery();
		while(rs != null && rs.next()) 
		{
			String ID	= rs.getString(1);
			String desc	= rs.getString(2);
			String Iden = rs.getString(3);
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(ID));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Iden));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( desc ));
            _bw.write(_wl_block10Bytes, _wl_block10);

		}
	if(rs!=null)	rs.close();
	if(pstmt!=null) pstmt.close();
	}catch(Exception e){ out.println("Exception e :"+e); }
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
