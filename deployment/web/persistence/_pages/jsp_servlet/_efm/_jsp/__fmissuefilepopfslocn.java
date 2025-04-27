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

public final class __fmissuefilepopfslocn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMIssueFilePopFSLocn.jsp", 1709116859781L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tCreated On\t: 1/20/2003\n\tCreated By\t: Marayan Kumar K.R.\n\tModule\t\t: File Management (FM)\n\tFunction\t: Issue File Search\n-->\n";
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

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t<SCRIPT>\n\t\t\t\t\tvar len = parent.issue_tab.document.FileIsuueTab.fs_locn_name.length;\n\t\t\t\t\tfor(var i=0; i<=len; i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.issue_tab.document.FileIsuueTab.fs_locn_name.remove(\"fs_locn_name\");\n\t\t\t\t\t}\n\t\t\t\t\tvar opt\t= parent.issue_header.document.createElement(\'OPTION\');\n\t\t\t\t\topt.value =\t\"\";\n\t\t\t\t\topt.text = \"----------\"+getLabel(\"Common.defaultSelect.label\",\"common\")+\"----------\";\n\t\t\t\t\tparent.issue_tab.document.FileIsuueTab.fs_locn_name.add(opt);\n\t\t\t\t</SCRIPT>\n\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t<SCRIPT>\n\t\t\t\t\t\tvar opt\t= parent.issue_tab.document.createElement(\'OPTION\');\n\t\t\t\t\t\topt.value =\t\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\t\t\topt.text = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t\t\tparent.issue_tab.document.FileIsuueTab.fs_locn_name.add(opt);\n\t\t\t\t\t</SCRIPT>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<SCRIPT>\n\t\t\t\t\tparent.issue_tab.document.FileIsuueTab.fs_narration.value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t</SCRIPT>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<SCRIPT>\n\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n</SCRIPT>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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
	try 
	{
		con	= ConnectionManager.getConnection(request);

		String fac_id	= (String) session.getValue("facility_id");
		Properties p	= (Properties) session.getValue("jdbc");

		String addedById	= p.getProperty("login_user");
		String popmode		= request.getParameter("popmode");

		String sql	= "";
		
		if(popmode.equals("1"))
		{
			String locn_code			= request.getParameter("locn_code");
			String p_user_security_yn	= request.getParameter("userSecurity")==null?"":request.getParameter("userSecurity");
			String p_access_all			= request.getParameter("access_all")==null?"":request.getParameter("access_all");

			if(p_user_security_yn.equals("Y"))
			{
				if(p_access_all.equals("*ALL"))
				{
					//sql = "select a.fs_locn_code, a.short_desc from fm_storage_locn a  where a.eff_status='E' and a.facility_id = ? and LOCN_IDENTITY = ? order by 2";
				//	sql = "SELECT   a.fs_Locn_Code, a.Short_desc FROM FM_STORAGE_LOCN_LANG_VW a WHERE    a.eff_Status = 'E' AND a.Facility_Id =? AND LOCN_IDENTITY = ? AND LANGUAGE_ID=? ORDER BY 2  ";
			sql = "SELECT   fs_Locn_Code,fm_get_desc.fm_storage_locn (facility_id, fs_locn_code, '"+localeName+"',2 ) Short_desc FROM FM_STORAGE_LOCN a WHERE    a.eff_Status = 'E' AND a.Facility_Id =? AND LOCN_IDENTITY = ?  ORDER BY 2  ";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,fac_id);
					pstmt.setString(2,locn_code);
					//pstmt.setString(3,localeName);
				}
				else
				{
					//sql = "select a.fs_locn_code, a.short_desc from fm_storage_locn a , fm_user_access_rights b where a.eff_status='E' and a.facility_id=b.facility_id and a.fs_locn_code=b.fs_locn_code and b.appl_user_id = ? and b.facility_id = ? and (b.req_yn='Y' or b.req_across_facilities_yn='Y' ) and LOCN_IDENTITY = ? order by 2";
					sql = "SELECT a.fs_Locn_Code,fm_get_desc.fm_storage_locn (a.facility_id, a.fs_locn_code, '"+localeName+"',2 ) Short_desc FROM FM_STORAGE_LOCN  a, fm_User_Access_Rights b WHERE a.eff_Status = 'E' AND a.Facility_Id = b.Facility_Id AND a.fs_Locn_Code = b.fs_Locn_Code AND b.apPl_User_Id = ? AND b.Facility_Id = ? AND (b.req_yn = 'Y' OR b.req_Across_faciLities_yn = 'Y') AND LOCN_IDENTITY = ?   ORDER BY 2";
					if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,addedById);
					pstmt.setString(2,fac_id);
					pstmt.setString(3,locn_code);
					//pstmt.setString(4,localeName);
				}
			}
			else
			{
				//sql = "select a.fs_locn_code, a.short_desc from fm_storage_locn a,fm_parameter b where a.eff_status='E' and a.facility_id = ? and a.facility_id=b.facility_id and a.fs_locn_code not in (b.dflt_archive_fs_locn_code,b.dflt_lost_fs_locn_code) and LOCN_IDENTITY = ? order by 2";
				sql = "SELECT a.fs_Locn_Code,fm_get_desc.fm_storage_locn (a.facility_id, a.fs_locn_code, '"+localeName+"',2 ) Short_desc FROM FM_STORAGE_LOCN a, fm_Parameter b WHERE a.eff_Status = 'E' AND a.Facility_Id = ? AND a.Facility_Id = b.Facility_Id AND a.fs_Locn_Code NOT IN (b.dflt_Archive_fs_Locn_Code, b.dflt_Lost_fs_Locn_Code) AND LOCN_IDENTITY = ? ORDER BY 2";
				if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,fac_id);
				pstmt.setString(2,locn_code);
			//	pstmt.setString(3,localeName);
			}
		
			rs  = pstmt.executeQuery();
			if(rs != null) 
			{
				
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
		}
		if(popmode.equals("2"))
		{
			String storage_location	= request.getParameter("storage_location");
			sql = "";
			sql  = "SELECT a.NARRATION_CODE FROM FM_STORAGE_LOCN a , FM_NARRATION b WHERE  a.FS_LOCN_CODE = ? and a.facility_id = ? and a.narration_code=b.narration_code and b.eff_status = 'E' ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,storage_location);
			pstmt.setString(2,fac_id);

			while(rs != null && rs.next()) 
			{
				
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( rs.getString( "NARRATION_CODE" ) ));
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
		}

		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e);
	}
	finally 
	{		
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
