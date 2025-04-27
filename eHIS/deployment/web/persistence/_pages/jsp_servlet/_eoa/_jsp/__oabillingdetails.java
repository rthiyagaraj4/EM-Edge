package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import java.net.URLEncoder.*;

public final class __oabillingdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/OAbillingdetails.jsp", 1709119245272L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\t\n\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n<script src=\'../../eOA/js/BookAppointment.js\' language=\'javascript\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<body CLASS=\"MESSAGE\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"oabill\" id=\"oabill\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<script>\n\t\t\tparent.frames[0].document.Bkappt_form.billing_group.value=document.forms[0].billing_group.value;\n\t\t\tparent.frames[0].document.Bkappt_form.bl_future_admn_YN.value=document.forms[0].bl_future_admn_YN.value;\n\t\t\tparent.frames[0].document.Bkappt_form.bl_operation.value=document.forms[0].bl_operation.value;\n\t\t\t\n\t</script>\t\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script>\n\t\t\tparent.frames[0].document.Bkappt_form.billing_group.value=document.forms[0].billing_group.value;\n\t\t\tparent.frames[0].document.Bkappt_form.bl_future_admn_YN.value=document.forms[0].bl_future_admn_YN.value;\n\t\t\tparent.frames[0].document.Bkappt_form.bl_operation.value=document.forms[0].bl_operation.value;\n\t\t\t\n\t</script>\t\t\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\n</body>\n</form>\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);
 
Connection con = null;

java.util.Properties p;

try{
	request.setCharacterEncoding("UTF-8");	
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String client_ip_address ;
	client_ip_address = p.getProperty("client_ip_address");
    String fromPage=(String) request.getParameter("from")==null?"":request.getParameter("from");
	String pat_id1				=	request.getParameter("patient_id");
	if(pat_id1 ==null) pat_id1="";
	String module_id = request.getParameter("calling_module_id");
	String calling_function_id = "BOOKING";
	String episode_type = request.getParameter("episode_type");
	String blng_grp				=	request.getParameter("blng_grp");
	if(blng_grp ==null) blng_grp="";
	String apptrefno=request.getParameter("apptrefno");
	if(apptrefno ==null) apptrefno="";
	String from_page=request.getParameter("from_page");
	if(from_page ==null) from_page="";
	String bl_operational			= (String)session.getValue("bl_operational"); 
	if(fromPage.equals("finacial_dtl")){
	//String bl_operational=(String)hash.get("bl_operational");
	//String module_id="IP";
	//String calling_function_id="BOOKING";
	//String episode_type=(String)hash.get("episode_type");
	//String blng_grp=(String)hash.get("blng_grp");
	if(from_page.equals("")){
		if(bl_operational.equals("Y") && !pat_id1.equals("")){
				if((blng_grp == null || blng_grp.equals(""))){
	
            {java.lang.String __page ="../../eBL/jsp/BLFinDetHiddenFlds.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(pat_id1
                        )},{ weblogic.utils.StringUtils.valueOf("calling_module"), weblogic.utils.StringUtils.valueOf(module_id
                        )},{ weblogic.utils.StringUtils.valueOf("calling_function_id"), weblogic.utils.StringUtils.valueOf(calling_function_id
                        )},{ weblogic.utils.StringUtils.valueOf("episode_type"), weblogic.utils.StringUtils.valueOf(episode_type
                        )},{ weblogic.utils.StringUtils.valueOf("apptrefno"), weblogic.utils.StringUtils.valueOf(apptrefno
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block8Bytes, _wl_block8);
}
		}
	}else{
	if(bl_operational.equals("Y")){
				if((blng_grp == null || blng_grp.equals(""))){
	
            {java.lang.String __page ="../../eBL/jsp/BLFinDetHiddenFlds.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(pat_id1
                        )},{ weblogic.utils.StringUtils.valueOf("calling_module"), weblogic.utils.StringUtils.valueOf(module_id
                        )},{ weblogic.utils.StringUtils.valueOf("calling_function_id"), weblogic.utils.StringUtils.valueOf(calling_function_id
                        )},{ weblogic.utils.StringUtils.valueOf("episode_type"), weblogic.utils.StringUtils.valueOf(episode_type
                        )},{ weblogic.utils.StringUtils.valueOf("apptrefno"), weblogic.utils.StringUtils.valueOf(apptrefno
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block9Bytes, _wl_block9);
 }
	}
		}
out.println("<script>grabFinancialDetails();</script>");
}// end if conditions for calling page 	
}catch( Exception e ){
	//out.println(e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{

	if (con!=null) ConnectionManager.returnConnection(con,request);
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
