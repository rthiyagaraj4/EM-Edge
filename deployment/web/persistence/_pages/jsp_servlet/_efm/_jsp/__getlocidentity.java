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

public final class __getlocidentity extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/GetLocIdentity.jsp", 1709116878000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<script>\n\t\t\n\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<script>\t\t\t\t\t\t\n\n/* Added by Nanda on 06/07/2002 */\n\n\t\t\t\t\tvar p_mr_locn_yn = \'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';\n\t\t\t\t\tvar p_per_area_yn = \'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n\n\t\t\t\t\tif (p_mr_locn_yn==\'N\')\n\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].assign_fs_locn.checked=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].assign_fs_locn.disabled=true;\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].change_fs_locn.checked=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].change_fs_locn.disabled=true;\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].change_return_date_yn.checked=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].change_return_date_yn.disabled=true;\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].deficiency_check_yn.checked=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].deficiency_check_yn.disabled=true;\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].file_lost_found_yn.checked=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].file_lost_found_yn.disabled=true;\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].track_out_to_opd_yn.checked=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].track_out_to_opd_yn.disabled=true;\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].track_out_to_ipw_yn.checked=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].track_out_to_ipw_yn.disabled=true;\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].receive_file_yn.checked=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].receive_file_yn.disabled=true;\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].return_file_yn.checked=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].return_file_yn.disabled=false;\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].confirm_receipt_yn.checked=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].confirm_receipt_yn.disabled=false;\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].transfer_file_yn.checked=false;\n\t\t\t\t\t//\tparent.frames[1].document.forms[0].transfer_file_yn.disabled=true;\n                        parent.frames[1].document.forms[0].transfer_file_yn.disabled=false;\n\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].req_yn.checked=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].req_yn.disabled=false;\n\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].manual_request_yn.checked=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].manual_request_yn.disabled=false;\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].cancel_request_yn.checked=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].cancel_request_yn.disabled=false;\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].req_across_facilities_yn.checked=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].req_across_facilities_yn.disabled=true;\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].iss_yn.checked=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].iss_yn.disabled=true;\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].iss_across_facilities_yn.checked=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].iss_across_facilities_yn.disabled=true;\n\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].CREATE_FILE_VOLUME_YN.checked=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].CREATE_FILE_VOLUME_YN.disabled=true;\n\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tif(p_per_area_yn == \'Y\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].assign_fs_locn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].assign_fs_locn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].change_fs_locn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].change_fs_locn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].change_return_date_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].change_return_date_yn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].deficiency_check_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].deficiency_check_yn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].file_lost_found_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].file_lost_found_yn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].track_out_to_opd_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].track_out_to_opd_yn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].track_out_to_ipw_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].track_out_to_ipw_yn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].receive_file_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].receive_file_yn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].return_file_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].return_file_yn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].confirm_receipt_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].confirm_receipt_yn.disabled=false;\n\n\t\t\t\t\t\t//\tparent.frames[1].document.forms[0].transfer_file_yn.checked=false;\n\t\t\t\t\t\t\t//parent.frames[1].document.forms[0].transfer_file_yn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].req_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].req_yn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].manual_request_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].manual_request_yn.disabled=false;  \n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].cancel_request_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].cancel_request_yn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].req_across_facilities_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].req_across_facilities_yn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].iss_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].iss_yn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].iss_across_facilities_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].iss_across_facilities_yn.disabled=false;\n\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].CREATE_FILE_VOLUME_YN.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].CREATE_FILE_VOLUME_YN.disabled=false;\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(p_per_area_yn == \'N\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].assign_fs_locn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].assign_fs_locn.disabled=true;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].change_fs_locn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].change_fs_locn.disabled=true;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].change_return_date_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].change_return_date_yn.disabled=true;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].deficiency_check_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].deficiency_check_yn.disabled=true;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].file_lost_found_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].file_lost_found_yn.disabled=true;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].track_out_to_opd_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].track_out_to_opd_yn.disabled=true;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].track_out_to_ipw_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].track_out_to_ipw_yn.disabled=true;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].receive_file_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].receive_file_yn.disabled=true;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].return_file_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].return_file_yn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].confirm_receipt_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].confirm_receipt_yn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].transfer_file_yn.checked=false;\n\t\t\t\t\t\t  //parent.frames[1].document.forms[0].transfer_file_yn.disabled=true;\n                          parent.frames[1].document.forms[0].transfer_file_yn.disabled=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].req_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].req_yn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].manual_request_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].manual_request_yn.disabled=false; \n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].cancel_request_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].cancel_request_yn.disabled=false;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].req_across_facilities_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].req_across_facilities_yn.disabled=true;\n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].iss_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].iss_yn.disabled=true;  \n                         \n\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].iss_across_facilities_yn.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].iss_across_facilities_yn.disabled=true; \n\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].CREATE_FILE_VOLUME_YN.checked=false;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].CREATE_FILE_VOLUME_YN.disabled=true;\n\n\t\t\t\t\t\t}\n\t\t\t\t\t}\t\t\t\t\n\t\t            </script>\n\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tparent.frames[1].document.getElementById(\"storage_location\").value=\"\";\n\t\t\t\t\t\t\n\t\t            </script>\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n</form>\n</body>\n</html>\n\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
Connection con=null;
try
{
	con = ConnectionManager.getConnection(request);
	String fac_id  		= (String) session.getValue( "facility_id" ) ;
	String storage_location	= request.getParameter("storage_location");
	
	
	String sql="";
	String str1 = "";
	String str2 = "";
	String str3 = "";

	Statement stmt=null;
	ResultSet rs=null;
	
	stmt = con.createStatement() ;


	String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='testform' id='testform'>");
	
	if(!(storage_location.equals("")))
	{
	sql  = "SELECT LOCN_IDENTITY,MR_LOCN_YN, PERMANENT_FILE_AREA_YN FROM FM_STORAGE_LOCN WHERE  FACILITY_ID='"+fac_id +"' AND FS_LOCN_CODE='"+storage_location+"' AND EFF_STATUS='E' ";	
	rs  = stmt.executeQuery(sql) ;
	
			
	if( rs != null )
	{
		
            _bw.write(_wl_block5Bytes, _wl_block5);
			
				while( rs.next() )
				{
					str1 = rs.getString( "LOCN_IDENTITY" ) ;
					str2 = rs.getString("MR_LOCN_YN");
					str3 = rs.getString("PERMANENT_FILE_AREA_YN");
					
					if(str1.equals("A"))
						str1="All";
					if(str1.equals("D"))
						str1="Department";
					if(str1.equals("C"))
						str1="Clinic";
					if(str1.equals("N"))
						str1="Nursing Unit";
					if(str1.equals("T"))
						str1="Doctor";
					if(str1.equals("E"))
						str1="External";

		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(str2));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(str3));
            _bw.write(_wl_block8Bytes, _wl_block8);

				}
	 }
		
	}
	else
	{
	
            _bw.write(_wl_block9Bytes, _wl_block9);

	}
	
	rs.close() ;
	if(stmt != null)	stmt.close();
	}
	
catch( Exception e ){}
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
