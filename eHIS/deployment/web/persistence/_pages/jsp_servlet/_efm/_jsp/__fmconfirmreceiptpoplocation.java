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

public final class __fmconfirmreceiptpoplocation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMConfirmReceiptPopLocation.jsp", 1737693946313L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tCreated On\t: 1/20/2003\n\tCreated By\t: Marayan Kumar K.R.\n\tModule\t\t: File Management (FM)\n\tFunction\t: Request File\n-->\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<SCRIPT>\n\t\t    //console.log(parent.receipt_header.document.getElementById(\"fslocation\"));\n\t\t   // var len = parent.frames[1].ConfirmReceiptHeader_form.document.forms[0].fslocation.length;\n\t\t    var len = parent.receipt_header.document.getElementById(\"fslocation\").length;\n\t\t\tfor(var i=0; i<=len; i++) \n\t\t\t{\n\t\t\t\t//parent.frames[1].ConfirmReceiptHeader_form.document.forms[0].fslocation.remove(\"fslocation\");\n\t\t\t\tparent.receipt_header.document.getElementById(\"fslocation\").remove(\"fslocation\");\n\t\t\t}\n\t\t\t//var opt\t= parent.frames[1].ConfirmReceiptHeader_form.document.createElement(\'OPTION\');\n\t\t\t   var opt\t= parent.receipt_header.document.createElement(\'OPTION\');\n\t\t\topt.value =\t\"\";\n\t\t\topt.text = \"----- \"+getLabel(\"Common.defaultSelect.label\",\"common\")+\" -----\";\n\t\t\t//parent.frames[1].ConfirmReceiptHeader_form.document.forms[0].fslocation.add(opt);\n\t\t\tparent.receipt_header.document.getElementById(\"fslocation\").add(opt);\n\t\t</SCRIPT>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<SCRIPT>\n\t\t\t\t//var opt\t= parent.frames[1].ConfirmReceiptHeader_form.document.createElement(\'OPTION\');\n\t\t\t\tvar opt\t= parent.receipt_header.document.createElement(\'OPTION\');\n\t\t\t\topt.value =\t\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="!";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\topt.text = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t//parent.frames[1].ConfirmReceiptHeader_form.document.forms[0].fslocation.add(opt);\n\t\t\t    parent.receipt_header.document.getElementById(\"fslocation\").add(opt);\n\t\t\t</SCRIPT>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<SCRIPT>\n\t\tparent.frames[4].document.location.href=\"../../eCommon/jsp/error.jsp\";\n\t</SCRIPT>\n\n";
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
	String facility_id	= (String) session.getValue( "facility_id" ) ;
	Properties p		= (Properties) session.getValue("jdbc" ) ;
	

	String locn_code	= request.getParameter("locn_code");
	String user_id		= p.getProperty( "login_user" ) ;

	Connection con				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	
	try 
	{
		con 	= ConnectionManager.getConnection(request);
				
		String access_all					= "";
		String userSecurity					= "";
		String auto_rec_ward				= "";
		String auto_rec_clinic				= "";
		String auto_rec_pract				= "";
		String auto_rec_dept				= "";
		//String Auto_rec_external			= "";
		String Dflt_archive_fs_locn_code	= "";
		String Dflt_lost_fs_locn_code		= "";
		String moreCriteria					= "";
		String SelectSql					= "";
		String auto_rec_procedure_yn		= "", auto_rec_daycare_yn = "";
		
		access_all					= request.getParameter("accessAll");
		userSecurity				= request.getParameter("userSecurity");
		auto_rec_ward				= request.getParameter("auto_rec_ward");
		auto_rec_clinic				= request.getParameter("auto_rec_clinic");
		auto_rec_procedure_yn		= request.getParameter("auto_rec_daycare_yn");
		auto_rec_daycare_yn			= request.getParameter("auto_rec_daycare_yn");
		auto_rec_pract				= request.getParameter("auto_rec_pract");
		auto_rec_dept				= request.getParameter("auto_rec_dept");
		//Auto_rec_external			= request.getParameter("Auto_rec_external");
		Dflt_archive_fs_locn_code	= request.getParameter("Dflt_archive_fs_locn_code");
		Dflt_lost_fs_locn_code		= request.getParameter("Dflt_lost_fs_locn_code");
		
		if(userSecurity == null || userSecurity.equals("null")) userSecurity = "N";
		
		if(locn_code.equals("N")) 
		{
			if(auto_rec_ward.equals("N")) moreCriteria = "'N'";
		}

		if(locn_code.equals("C")) 
		{
			if(auto_rec_clinic.equals("N")) moreCriteria = "'C'";
		}

		if(locn_code.equals("E")) 
		{
			if(auto_rec_procedure_yn.equals("N")) 	moreCriteria = "'E'";
		}

		if(locn_code.equals("Y")) 
		{
			if(auto_rec_daycare_yn.equals("N")) moreCriteria = "'Y'";
		}

		if(locn_code.equals("T")) 
		{
			if(auto_rec_pract.equals("N")) moreCriteria = "'T'";
		}
		
		if(locn_code.equals("D")) 
		{
			if(auto_rec_dept.equals("N")) moreCriteria = "'D'";
		}

		

		if(userSecurity.equals("Y")) 
		{
			if(access_all.equals("*ALL"))  //Modified by S.Sathish for IN021089 on Friday, April 30, 2010
			{
				//SelectSql = "Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY from FM_STORAGE_LOCN where facility_id = '"+facility_id+"' and eff_status = 'E' and LOCN_IDENTITY IN ("+moreCriteria+") and (FS_LOCN_CODE != '"+Dflt_archive_fs_locn_code+"' and FS_LOCN_CODE != '"+Dflt_lost_fs_locn_code+"') order by 2";
				 SelectSql = "SELECT"
						  +"  FS_LOCN_CODE"
						  +"  ,fm_get_desc.fm_storage_locn (facility_id, FS_LOCN_CODE,'"+localeName+"',2 ) SHORT_DESC"
						  +"  , LOCN_IDENTITY "
						  +"FROM"
						  +"  FM_STORAGE_LOCN_LANG_VW "
						  +"WHERE Facility_Id = '"+facility_id+"' "
						  +"  AND LANGUAGE_ID='"+localeName+"' "
						  +"  AND eff_Status = 'E' "
						  +"  AND LOCN_IDENTITY IN ("+moreCriteria+") "
						  +"  AND "
						  +"  ("
						  +"    FS_LOCN_CODE != '"+Dflt_archive_fs_locn_code+"' "
						  +"    AND FS_LOCN_CODE != '"+Dflt_lost_fs_locn_code+"'"
						  +"  ) "
						  +"ORDER BY"
						  +"  2";

				
			}
			else
			{
				//SelectSql = "Select FS_LOCN_CODE, FS_LOCN_SHORT_DESC, LOCN_IDENTITY from FM_USER_ACCESS_RIGHTS_VW where facility_id = '"+facility_id+"' and APPL_USER_ID = '"+user_id+"' and CONFIRM_RECEIPT_FILE_YN = 'Y' and LOCN_IDENTITY IN ("+moreCriteria+") and (FS_LOCN_CODE != '"+Dflt_archive_fs_locn_code+"' and FS_LOCN_CODE != '"+Dflt_lost_fs_locn_code+"') order by 2";
				 SelectSql = "SELECT"
							  +"  a.FS_LOCN_CODE"
							  +"  , ("
							  +"  CASE "
							  +"  WHEN A.FS_LOCN_CODE = '*ALL' "
							  +"  THEN"
							  +"    '*ALL' "
							  +"  ELSE B.SHORT_DESC "
							  +"  END)"
							  +"  , b.LOCN_IDENTITY "
							  +"FROM"
							  +"  FM_USER_ACCESS_RIGHTS A"
							  +"  , FM_STORAGE_LOCN_LANG_VW B "
							  +"WHERE A.FACILITY_ID = B.FACILITY_ID(+) "
							  +"  AND A.FS_LOCN_CODE = B.FS_LOCN_CODE(+) "
							  +"  AND a.Facility_Id = '"+facility_id+"' "
							  +"  AND a.APPL_USER_ID = '"+user_id+"' "
							  +"  AND a.CONFIRM_RECEIPT_FILE_YN = 'Y' "
							  +"  AND b.LOCN_IDENTITY IN ("+moreCriteria+") "
							  +"  AND "
							  +"  ("
							  +"    a.FS_LOCN_CODE != '"+Dflt_archive_fs_locn_code+"' "
							  +"    AND a.FS_LOCN_CODE != '"+Dflt_lost_fs_locn_code+"'"
							  +"  ) "
							  +"  AND B.LANGUAGE_ID='"+localeName+"' "
							  +"ORDER BY"
							  +"  2";

			}
		}
		else
		{
			//SelectSql = "Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY from FM_STORAGE_LOCN where facility_id = '"+facility_id+"' and eff_status = 'E' and LOCN_IDENTITY IN ("+moreCriteria+") and (FS_LOCN_CODE != '"+Dflt_archive_fs_locn_code+"' and FS_LOCN_CODE != '"+Dflt_lost_fs_locn_code+"') order by 2";
			 SelectSql = "SELECT"
						  +"  FS_LOCN_CODE"
						  +"  ,fm_get_desc.fm_storage_locn (facility_id, FS_LOCN_CODE,'"+localeName+"',2 ) SHORT_DESC"
						  +"  , LOCN_IDENTITY "
						  +"FROM"
						  +"  FM_STORAGE_LOCN_LANG_VW "
						  +"WHERE Facility_Id = '"+facility_id+"' "
						  +"  AND LANGUAGE_ID='"+localeName+"' "
						  +"  AND eff_Status = 'E' "
						  +"  AND LOCN_IDENTITY IN ("+moreCriteria+") "
						  +"  AND "
						  +"  ("
						  +"    FS_LOCN_CODE != '"+Dflt_archive_fs_locn_code+"' "
						  +"    AND FS_LOCN_CODE != '"+Dflt_lost_fs_locn_code+"'"
						  +"  ) "
						  +"ORDER BY"
						  +"  2";

		}

		
		
            _bw.write(_wl_block6Bytes, _wl_block6);

		
		pstmt = con.prepareStatement(SelectSql);
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
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e);
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
