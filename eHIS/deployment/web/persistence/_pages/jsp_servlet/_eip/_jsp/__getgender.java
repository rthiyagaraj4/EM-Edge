package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;

public final class __getgender extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/GetGender.jsp", 1720445624748L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n            var gender = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n            if(gender == \'M\')\n            {\n                document.NursingUnitBkgLt_form.max_male_dly_booking.readOnly = false;\n                document.NursingUnitBkgLt_form.max_female_dly_booking.readOnly = true;\n                document.NursingUnitBkgLt_form.max_unknown_dly_booking.readOnly = true;\n                document.NursingUnitBkgLt_form.max_total_dly_booking.readOnly = true;\n                \n                //document.NursingUnitBkgLt_form.max_total_dly_booking.value = \'\';\n                document.NursingUnitBkgLt_form.max_female_dly_booking.value = \'\';\n                document.NursingUnitBkgLt_form.max_unknown_dly_booking.value = \'\';\n                \n            }\n            else if(gender == \'F\')\n            {\n                document.NursingUnitBkgLt_form.max_female_dly_booking.readOnly = false;\n                document.NursingUnitBkgLt_form.max_male_dly_booking.readOnly = true;\n                document.NursingUnitBkgLt_form.max_unknown_dly_booking.readOnly = true;\n                document.NursingUnitBkgLt_form.max_total_dly_booking.readOnly = true;\n\n                document.NursingUnitBkgLt_form.max_male_dly_booking.value = \'\';\n                document.NursingUnitBkgLt_form.max_unknown_dly_booking.value = \'\';\n                }\n            else if(gender == \'U\')\n            {\n                document.NursingUnitBkgLt_form.max_female_dly_booking.readOnly = true;\n                document.NursingUnitBkgLt_form.max_male_dly_booking.readOnly = true;\n                document.NursingUnitBkgLt_form.max_unknown_dly_booking.readOnly = false;\n                document.NursingUnitBkgLt_form.max_total_dly_booking.readOnly = true;\n\n                document.NursingUnitBkgLt_form.max_male_dly_booking.value = \'\';\n                //document.NursingUnitBkgLt_form.max_total_dly_booking.value = \'\';\n                document.NursingUnitBkgLt_form.max_unknown_dly_booking.value = \'\';\n                }\n                else \n                {\n                    document.NursingUnitBkgLt_form.max_male_dly_booking.readOnly = false;\n                    document.NursingUnitBkgLt_form.max_female_dly_booking.readOnly = false;\n                    document.NursingUnitBkgLt_form.max_unknown_dly_booking.readOnly = false;\n                    document.NursingUnitBkgLt_form.max_total_dly_booking.readOnly = true;\n\n                    //document.NursingUnitBkgLt_form.max_male_dly_booking.value = \'\';\n                    //document.NursingUnitBkgLt_form.max_female_dly_booking.value = \'\';\n                }\n\n                document.NursingUnitBkgLt_form.gender.value = gender;\n</script>\n            ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
    java.util.Hashtable hash = (java.util.Hashtable)obj.parseXMLString( request ) ;
    hash = (java.util.Hashtable)hash.get("SEARCH") ;
    String nursingunitcode      = (String)hash.get("nursing_unit_code");
	hash.clear();
    String facilityId           = (String) session.getValue("facility_id");
    Connection con              = null;
    PreparedStatement pstmt     = null;
    ResultSet rs                = null;
    String ID                   = "";

    try
    {
        con  =  ConnectionManager.getConnection(request);

        if (!(nursingunitcode == null || nursingunitcode.equals("")))
        { 
            pstmt=con.prepareStatement("select gender from am_age_group where age_group_code=(select age_group_code from ip_nursing_unit where facility_id = ? and nursing_unit_code=?)");
            pstmt.setString(1,facilityId);
            pstmt.setString(2,nursingunitcode);
            rs=pstmt.executeQuery();

            if(rs!=null)
            {   
                while(rs.next())
                {
                    ID  = rs.getString("gender");
                    if(ID == null) ID="";
                }
            }
            
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(ID));
            _bw.write(_wl_block3Bytes, _wl_block3);

        }

    }
    catch(Exception e)
    {
            out.print(e);
    }
    finally
    {
        if(pstmt != null)   pstmt.close();
        if(rs != null)  rs.close();
        ConnectionManager.returnConnection(con,request);

    }

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
