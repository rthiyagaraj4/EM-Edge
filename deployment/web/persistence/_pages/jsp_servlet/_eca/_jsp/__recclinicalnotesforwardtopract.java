package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;

public final class __recclinicalnotesforwardtopract extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesForwardToPract.jsp", 1709115227635L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\tpractArry[";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="] = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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

/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
26/12/2013	IN027097		Vijayakumar K	System is displaying script error window while forwarding clinical notes
-----------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
 
	Connection con = null;
	PreparedStatement pstmt	= null;
	ResultSet rs = null;

	try
	{
		con = ConnectionManager.getConnection(request);

		Map hash = (Map)obj.parseXMLString( request ) ;
		hash = (Map)hash.get("SEARCH") ;
		String facilityId =(String) session.getValue("facility_id");
		String locale = (String)session.getAttribute("LOCALE");
		//String clinician_id	= (String) session.getValue("ca_practitioner_id");

		String speciality_id = (String) hash.get("speciality_id");
		if(speciality_id == null) speciality_id = "";

		String note_type = (String) hash.get("note_type");
		if(note_type == null) note_type = "";

		String clinician_id = (String) hash.get("clinician_id");
		if(clinician_id == null) clinician_id = "";
		
		String sql = "";
		String clinician_name = "";
		String clinician_dtls = "";
		int i = 0;

		if(speciality_id.equals(""))
		{
			sql = "SELECT a.practitioner_id clinician_id, b.practitioner_name clinician_name FROM am_pract_for_facility a, am_practitioner_lang_vw b WHERE b.language_id = ? AND a.facility_id = ? and b.practitioner_id = a.practitioner_id AND a.practitioner_id != ? AND a.practitioner_id IN (SELECT ia.func_role_id FROM ca_note_type_for_resp ib,sm_appl_user ia, sm_resp_for_user ic WHERE ib.note_type = ? AND ib.privilege_type IN ('3', '4') AND ia.appl_user_id = ic.appl_user_id AND ic.resp_id = ib.resp_id)  order by 2"; 
			pstmt =	con.prepareStatement(sql);
			pstmt.setString( 1,	locale);
			pstmt.setString( 2,	facilityId);
			pstmt.setString( 3,	clinician_id);
			pstmt.setString( 4, note_type);
			rs = pstmt.executeQuery() ;
		}
		else
		{
			sql = "SELECT a.practitioner_id clinician_id, b.practitioner_name clinician_name FROM am_pract_for_facility a, am_practitioner_lang_vw b WHERE b.language_id = ? AND a.facility_id = ? and b.practitioner_id = a.practitioner_id AND a.practitioner_id != ? AND a.practitioner_id IN (SELECT ia.func_role_id FROM ca_note_type_for_resp ib,sm_appl_user ia, sm_resp_for_user ic WHERE ib.note_type = ? AND ib.privilege_type IN ('3', '4') AND ia.appl_user_id = ic.appl_user_id AND ic.resp_id = ib.resp_id) AND (b.primary_speciality_code = ? OR EXISTS (SELECT 1 FROM am_pract_specialities WHERE facility_id = a.facility_id AND practitioner_id = a.practitioner_id AND speciality_code = ?) ) order by 2 ";
		
			pstmt =	con.prepareStatement(sql);
			pstmt.setString( 1,	locale);
			pstmt.setString( 2,	facilityId);
			pstmt.setString( 3,	clinician_id);
			pstmt.setString( 4, note_type);
			pstmt.setString( 5,	speciality_id);
			pstmt.setString( 6,	speciality_id);
			rs = pstmt.executeQuery() ;
		}

		if (rs != null)
		{
			while(rs.next())
			{
				clinician_id = rs.getString("clinician_id") == null ? "" : rs.getString("clinician_id");
				clinician_name = rs.getString("clinician_name") == null ? "" : rs.getString("clinician_name");
				clinician_dtls = clinician_id + "~" + clinician_name;
				clinician_dtls = java.net.URLEncoder.encode(clinician_dtls,"UTF-8");//IN027097

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(i));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(clinician_dtls));
            _bw.write(_wl_block5Bytes, _wl_block5);

				i++;
			}
		}
		if (pstmt !=null) pstmt.close();
		if (rs !=null) rs.close();
		if (hash !=null) hash.clear();
	}
	catch( Exception e )
	{
		
		e.printStackTrace();
	}
	finally
	{
		if(con !=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
