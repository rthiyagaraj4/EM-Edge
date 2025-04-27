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
import eDR.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmpopulatefslocation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMPopulateFSLocation.jsp", 1709116866172L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMLostFound.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'message\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script>\n\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\tvar opt=parent.frames[3].document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\tparent.frames[3].document.forms[0].p_fs_location1.add(opt);\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' == \'L\' || \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' == \'A\' )\n\t\t\t\t{\n\t\t\t\t\tparent.frames[3].document.forms[0].p_fs_location1.options[1].selected = true;\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.frames[3].document.forms[0].p_fs_location1.disabled = false;\n\t\t\t\t}\n\t\t\t\tvar errors = \'\' ;\t\t\n\n\t\t</script>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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

			Connection con = ConnectionManager.getConnection(request);
			Statement stmt		=	null;
			ResultSet rs		=	null;
			stmt				=	con.createStatement();

			java.util.Properties p	= (java.util.Properties) session.getValue("jdbc" ) ;
			String addedById	= p.getProperty( "login_user" ) ;
			String facilityid 	= (String) session.getValue("facility_id");
			

			String p_new_status	= request.getParameter("p_new_status");		
			String sql			=	"";
			String p_code		=	"";
			String p_desc		=	"";
			String p_user_security_yn = "";
try
{

if (p_new_status.equals("O") || p_new_status.equals("I"))
{

	sql = "select user_security_yn from fm_parameter where facility_id='"+facilityid+"' ";

	rs  = stmt.executeQuery(sql);

	while (rs.next())
	{
		p_user_security_yn	= rs.getString("user_security_yn");
	}
	if (rs!=null) rs.close();
	
	if (p_user_security_yn.equals("Y"))
	{
		if (p_new_status.equals("I"))
		{
			//sql = "select a.fs_locn_code,a.short_desc long_desc from fm_storage_locn a , fm_user_access_rights b,fm_parameter c where a.eff_status='E' and a.facility_id=b.facility_id and a.fs_locn_code=b.fs_locn_code and b.appl_user_id='"+addedById+"' and b.facility_id='"+facilityid+"' and a.mr_locn_yn='Y' and a.facility_id=c.facility_id and a.fs_locn_code != c.dflt_lost_fs_locn_code and a.fs_locn_code != c.dflt_archive_fs_locn_code order by 2	";
			sql = "SELECT a.fs_Locn_Code,  a.Short_desc Long_desc FROM FM_STORAGE_LOCN_LANG_VW a,  fm_User_Access_Rights b,  fm_Parameter c WHERE  a.eff_Status = 'E'  AND A.LANGUAGE_ID='"+localeName+"'  AND a.Facility_Id = b.Facility_Id  AND a.fs_Locn_Code = b.fs_Locn_Code  AND b.apPl_User_Id = '"+addedById+"'  AND b.Facility_Id = '"+facilityid+"'  AND a.mr_Locn_yn = 'Y'  AND a.Facility_Id = c.Facility_Id  AND a.fs_Locn_Code != c.dflt_Lost_fs_Locn_Code  AND a.fs_Locn_Code != c.dflt_Archive_fs_Locn_Code ORDER BY 2	";
		}
		else
		{
			//sql = "select a.fs_locn_code,a.short_desc long_desc from fm_storage_locn a , fm_user_access_rights b ,fm_parameter c where a.eff_status='E' and a.facility_id=b.facility_id and a.fs_locn_code=b.fs_locn_code and b.appl_user_id='"+addedById+"' and b.facility_id='"+facilityid+"' and a.mr_locn_yn <> 'Y' and a.facility_id=c.facility_id and a.fs_locn_code != c.dflt_lost_fs_locn_code and a.fs_locn_code != c.DFLT_ARCHIVE_FS_LOCN_CODE  order by 2	";
			sql = "SELECT a.fs_Locn_Code,  a.Short_desc Long_desc FROM FM_STORAGE_LOCN_LANG_VW a,  fm_User_Access_Rights b,  fm_Parameter c WHERE a.eff_Status = 'E'  AND A.LANGUAGE_ID='"+localeName+"'  AND a.Facility_Id = b.Facility_Id  AND a.fs_Locn_Code = b.fs_Locn_Code  AND b.apPl_User_Id = '"+addedById+"'  AND b.Facility_Id = '"+facilityid+"'  AND a.mr_Locn_yn <> 'Y'  AND a.Facility_Id = c.Facility_Id  AND a.fs_Locn_Code != c.dflt_Lost_fs_Locn_Code  AND a.fs_Locn_Code != c.DFLT_ARCHIVE_FS_LOCN_CODE ORDER BY 2	";
		}
	}
	else
	{
		//sql = "select a.fs_locn_code,a.short_desc long_desc from fm_storage_locn a where a.eff_status='E' and a.facility_id='"+facilityid+"' order by 2";
		sql = "SELECT a.fs_Locn_Code,  a.Short_desc Long_desc FROM FM_STORAGE_LOCN_LANG_VW a WHERE a.eff_Status = 'E'  AND A.LANGUAGE_ID='"+localeName+"'  AND a.Facility_Id = '"+facilityid+"' ORDER BY 2";
	}
}
else if (p_new_status.equals("L"))
{
	//sql = " select a.dflt_lost_fs_locn_code fs_locn_code,b.short_desc long_desc  from fm_parameter a,fm_storage_locn b where a.facility_id='"+facilityid+"' and a.facility_id=b.facility_id and  a.dflt_lost_fs_locn_code=b.fs_locn_code ";	
	sql = "SELECT a.dflt_Lost_fs_Locn_Code fs_Locn_Code,  b.Short_desc Long_desc FROM fm_Parameter a,  FM_STORAGE_LOCN_LANG_VW b WHERE a.Facility_Id = '"+facilityid+"'  AND a.Facility_Id = b.Facility_Id  AND a.dflt_Lost_fs_Locn_Code = b.fs_Locn_Code  AND B.LANGUAGE_ID='"+localeName+"' ";	

}
else if (p_new_status.equals("A"))
{
	//sql = " select a.dflt_archive_fs_locn_code fs_locn_code ,b.short_desc long_desc  from fm_parameter a,fm_storage_locn b where a.facility_id='"+facilityid+"' and a.facility_id=b.facility_id and a.dflt_archive_fs_locn_code=b.fs_locn_code ";	
	sql = "SELECT a.dflt_Archive_fs_Locn_Code fs_Locn_Code,  b.Short_desc Long_desc FROM fm_Parameter a,  FM_STORAGE_LOCN_LANG_VW b WHERE a.Facility_Id = '"+facilityid+"'  AND a.Facility_Id = b.Facility_Id  AND a.dflt_Archive_fs_Locn_Code = b.fs_Locn_Code  AND B.LANGUAGE_ID='"+localeName+"'";	
}
else if ((p_new_status.equals("F")) || (p_new_status.equals("R")) )
{
	//sql = "select a.fs_locn_code fs_locn_code, a.short_desc long_desc from fm_storage_locn a, fm_parameter b where a.facility_id='"+facilityid+"' and a.facility_id=b.facility_id and a.eff_status='E' and a.fs_locn_code <> b.dflt_archive_fs_locn_code and a.fs_locn_code <> b.dflt_lost_fs_locn_code";	
	sql = "SELECT a.fs_Locn_Code fs_Locn_Code,  a.Short_desc Long_desc FROM FM_STORAGE_LOCN_LANG_VW a,  fm_Parameter b WHERE a.Facility_Id = '"+facilityid+"'  AND a.Facility_Id = b.Facility_Id  AND a.eff_Status = 'E'  AND A.LANGUAGE_ID='"+localeName+"'  AND a.fs_Locn_Code <> b.dflt_Archive_fs_Locn_Code  AND a.fs_Locn_Code <> b.dflt_Lost_fs_Locn_Code";	
}
	rs = stmt.executeQuery(sql);

	if(rs != null)
	{

	while (rs.next())
	{
		p_code	= rs.getString("fs_locn_code");
		p_desc	= rs.getString("long_desc");



            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_new_status));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_new_status));
            _bw.write(_wl_block12Bytes, _wl_block12);

	}
 }
if (rs!=null) rs.close();
if (stmt!=null) stmt.close();
}
catch (Exception e)
{}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
