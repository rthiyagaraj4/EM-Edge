package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __organizationframe2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/OrganizationFrame2.jsp", 1709118666247L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped By       :\tShyam Prasad.P\n\tCreated on   \t   :\t09/02/2006\n\tFunction\t\t   :\tOraganization\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\n\n<script src=\'../../eMP/js/Organization.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<frameset rows=\'80,*\'>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<frame name=\'f_query_add_mod_main_criteria\' id=\'f_query_add_mod_main_criteria\' src=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" frameborder=0>\n    ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<frame name=\'f_query_add_mod_main_criteria\' id=\'f_query_add_mod_main_criteria\' src=\'../../eMP/jsp/AddOrganization.jsp\' frameborder=0>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<FRAMESET COLS=\"85%,75%\">\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<frame name=\'patient_sub\' id=\'patient_sub\'\t  src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" frameborder=0 noresize scrolling=\'no\'>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n              <frame name=\'patient_sub\' id=\'patient_sub\'\t  src=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" frameborder=0 noresize scrolling=\'no\'> \n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<frame name=\'patient_sub\' id=\'patient_sub\'\t  src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'no\'>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<frame name=\'f_query_add_mod_sub_result\' id=\'f_query_add_mod_sub_result\'\t   src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"  frameborder=0 noresize scrolling=\'auto\'>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n                <frame name=\'f_query_add_mod_sub_result\' id=\'f_query_add_mod_sub_result\'\t  src=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" frameborder=0 noresize scrolling=\'auto\'>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<frame name=\'f_query_add_mod_sub_result\' id=\'f_query_add_mod_sub_result\'\t  src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\'>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t</FRAMESET>\n</frameset>\n\t\t\t\t\t<input type=\"hidden\" name=\"fname\" id=\"fname\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, false , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block2Bytes, _wl_block2);

	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ;
	String function_name=request.getParameter("cfrom");
	String id=request.getParameter("org_id");
	String eff_status=request.getParameter("eff_status");
	String name=request.getParameter("org_name");
	if(function_name==null)function_name="";
	if(id==null)id="";
	if(name==null)name="";
	if(eff_status==null)eff_status="";
	String source1="../../eMP/jsp/AddOrganization.jsp?org_id="+id+"&mode=update";
	String src_sub="../../eMP/jsp/Organisationsub.jsp?org_id="+id+"&org_name="+name+"&eff_statusnew="+eff_status;
	String src_sub_res="../../eMP/jsp/OrganisationsubResult.jsp?org_id="+id;

            _bw.write(_wl_block3Bytes, _wl_block3);
if(function_name.equals("query")){
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(source1));
            _bw.write(_wl_block5Bytes, _wl_block5);
}else{
            _bw.write(_wl_block6Bytes, _wl_block6);
}
            _bw.write(_wl_block7Bytes, _wl_block7);
if(function_name.equals("query")){
		 if(eff_status.equals("E")){
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(src_sub));
            _bw.write(_wl_block9Bytes, _wl_block9);
}
		else
			{
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(src_sub));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
		}
		else{
            _bw.write(_wl_block12Bytes, _wl_block12);
}if(function_name.equals("query")){
		 if(eff_status.equals("E")){		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(src_sub_res));
            _bw.write(_wl_block14Bytes, _wl_block14);
}else{
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(src_sub_res));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
			}else{
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
