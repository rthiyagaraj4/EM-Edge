package jsp_servlet._efm._jsp;

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

public final class __fmconfirmreceiptfiles extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMConfirmReceiptFiles.jsp", 1725267114414L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMConfirmReceiptFiles.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' frameborder=\'0\' scrolling=no noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'receipt_header\' id=\'receipt_header\' src=\'../../eFM/jsp/FMConfirmReceiptFilesHeader.jsp?doc_or_file=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&accessAll=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&auto_rec_ward_yn=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&auto_rec_clinic_yn=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&auto_rec_procedure_yn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&auto_rec_daycare_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&auto_rec_pract_yn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&auto_rec_dept_yn=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&USER_SECURITY_YN=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&AUTO_REC_EXTERNAL_YN=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&DFLT_ARCHIVE_FS_LOCN_CODE=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&DFLT_LOST_FS_LOCN_CODE=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:20vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'receipt_criteria\' id=\'receipt_criteria\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize style=\'height:20vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'receipt_details\' id=\'receipt_details\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize style=\'height:40vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' scrolling=\'no\' frameborder=\'0\' noresize style=\'height:12vh;width:100vw\'></iframe>\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</html>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );


public static String checkForNull(String inputString)
{
	return ( ( (inputString == null) || (inputString.equals("null") ) ) ? "" : inputString );
}

public static String checkForNull(String inputString, String defaultValue)
{
	return ( ( (inputString == null) || (inputString.equals("null") ) ) ? defaultValue : inputString );
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
		ResultSet rs				= null;
		java.sql.Statement stmt		= null;
		PreparedStatement pstmt		= null;
		
		String maintain_doc_or_file = "";
		
		String facility_id	= (String) session.getValue("facility_id");
		String user_id		= (String) session.getValue("login_user");
	
		String sql							= "";
		String sql1							= "";
		String userSecurity					= "";
		String Auto_rec_ward				= "";
		String Auto_rec_clinic				= "";
		String Auto_rec_pract				= "";
		String Auto_rec_dept				= "";
		String Auto_rec_external			= "";
		String auto_rec_procedure_yn		= "";
		String auto_rec_daycare_yn			= "";
		String DFLT_ARCHIVE_FS_LOCN_CODE	= "";
		String DFLT_LOST_FS_LOCN_CODE		= "";

		int rec_cnt = 0;
		String userVal="";
		
		try
		{
			String url		= "../../eCommon/jsp/commonToolbar.jsp?";
			String params	= request.getQueryString() ;
			String source	= url + params;

			stmt = con.createStatement();

			rs = stmt.executeQuery("SELECT maintain_doc_or_file FROM mp_param");
			if(rs != null && rs.next())
			{
				maintain_doc_or_file = rs.getString("maintain_doc_or_file");
			} if(rs != null) rs.close();
		
			if(maintain_doc_or_file == null || maintain_doc_or_file.equals("null"))
				maintain_doc_or_file = "";

			sql = "Select AUTO_REC_WARD_YN, AUTO_REC_CLINIC_YN, AUTO_REC_PRACT_YN, AUTO_REC_DEPT_YN, AUTO_REC_EXTERNAL_YN,USER_SECURITY_YN,auto_rec_procedure_yn,auto_rec_daycare_yn,DFLT_ARCHIVE_FS_LOCN_CODE,DFLT_LOST_FS_LOCN_CODE from FM_PARAMETER where FACILITY_ID = ? ";
				   
			pstmt	= con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			rs		= pstmt.executeQuery();

			if(rs != null && rs.next())
			{
				 Auto_rec_ward				=  checkForNull(rs.getString(1));
				 Auto_rec_clinic			=  checkForNull(rs.getString(2));
				 Auto_rec_pract				=  checkForNull(rs.getString(3));
				 Auto_rec_dept				=  checkForNull(rs.getString(4));
				 Auto_rec_external			=  checkForNull(rs.getString(5));
				 userSecurity				=  checkForNull(rs.getString(6));
				 auto_rec_procedure_yn		=  checkForNull(rs.getString(7));
				 auto_rec_daycare_yn		=  checkForNull(rs.getString(8));
				 DFLT_ARCHIVE_FS_LOCN_CODE	=  checkForNull(rs.getString(9));
				 DFLT_LOST_FS_LOCN_CODE		=  checkForNull(rs.getString(10));
				 
			} if(rs != null) rs.close(); if(pstmt != null) pstmt.close();

			if(Auto_rec_ward.equals("Y") && Auto_rec_clinic.equals("Y") && Auto_rec_pract.equals("Y") && Auto_rec_dept.equals("Y") && Auto_rec_external.equals("Y"))
			{
				if(maintain_doc_or_file.equals("D"))
				{
					out.println("<script> alert(getMessage(\"NO_CONFIRM_RECEIPT_DOC\",\"FM\")); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
				}
				else if(maintain_doc_or_file.equals("F"))
				{
					out.println("<script> alert(getMessage(\"NO_CONFIRM_RECEIPT\",\"FM\")); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
				}
			}
			if(userSecurity.equals("Y"))
			{
				sql1 = "Select 1 rec_cnt , fs_locn_code from FM_USER_ACCESS_RIGHTS where FACILITY_ID = ?  and APPL_USER_ID = ? and CONFIRM_RECEIPT_FILE_YN = 'Y' ";
				
				pstmt = con.prepareStatement(sql1);

				pstmt.setString(1,facility_id);
				pstmt.setString(2,user_id);
								
				rs = pstmt.executeQuery();

				if(rs != null && rs.next())
				{
					 rec_cnt = rs.getInt(1); //Modified by S.Sathish for IN021089 on Friday, April 30, 2010
					 userVal =  rs.getString("fs_locn_code");
				} 
				if(rec_cnt != 1)
				{
					out.println("<script> alert(getMessage(\"FM_NO_USER_RIGHTS\",\"FM\")); parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; </script>");
				}
			}
			
			
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(source));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(userVal));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Auto_rec_ward));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Auto_rec_clinic));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(auto_rec_procedure_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(auto_rec_daycare_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Auto_rec_pract));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Auto_rec_dept));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(userSecurity));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Auto_rec_external));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(DFLT_ARCHIVE_FS_LOCN_CODE));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(DFLT_LOST_FS_LOCN_CODE));
            _bw.write(_wl_block21Bytes, _wl_block21);

		if(rs!=null)	rs.close();
		if(stmt!=null)  stmt.close();
		if(pstmt!=null) pstmt.close();
		}catch(Exception e){out.println(e);}
		finally
		{					
				ConnectionManager.returnConnection(con,request);			
		}
		
            _bw.write(_wl_block22Bytes, _wl_block22);


if(session.getAttribute("username")!=null)
session.removeAttribute("username");
if(session.getAttribute("objKey")!=null)
session.removeAttribute("objKey");

            _bw.write(_wl_block1Bytes, _wl_block1);
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
