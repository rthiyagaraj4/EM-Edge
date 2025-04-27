package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __iplistofavailablebedsbyspecialty extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPListofAvailableBedsbySpecialty.jsp", 1710353608397L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\t\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\tfunction reset()\n\t{\n\t\tf_query_add_mod.document.forms[0].reset();\n\t}\n\tfunction run()\n\t{\n\t\tvar fields = new Array(f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_sex_spec_ind);\n\t\tvar names = new Array(getLabel(\'Common.gender.label\',\'Common\'));\n\t\tif(f_query_add_mod.checkFields( fields, names, messageFrame))\n\t\t{\n\t\t\tif( !doDateCheckAlert(f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_fr_dt,f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_to_dt )  )\n\t\t\t{\t\t\t\t\n\t\t\t\t\tvar error=getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\");\t\t\t\t\t\n\t\t\t\t\tmessageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+error;\t\t\t\t\t\n\t\t\t\t\treturn false;\n\t\t\t}\n\t\t\tif( f_query_add_mod.CheckString(getLabel(\'Common.NursingUnitCode.label\',\'Common\'), f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_fm_nursing_unit_code,f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_to_nursing_unit_code, messageFrame )  )\n\t\t\t\tif( f_query_add_mod.CheckString(getLabel(\'Common.speciality.label\',\'Common\')+\" \"+getLabel(\'Common.code.label\',\'Common\'), f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_fr_spl,f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_to_spl, messageFrame )  )\n\t\t\t\t\tif( f_query_add_mod.CheckString(getLabel(\'Common.bedtype.label\',\'Common\')+\" \"+getLabel(\'Common.code.label\',\'Common\'), f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_fr_bed_type,f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_to_bed_type, messageFrame )  )\n\t\t\t\t\t\tif( f_query_add_mod.CheckString(getLabel(\'eIP.BedClassCode.label\',\'IP\'), f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_fr_bed_class,f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_to_bed_class, messageFrame )  )\n\t\t\t\t\t\t\tif( f_query_add_mod.CheckString(getLabel(\'Common.roomno.label\',\'Common\'), f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_fm_room_no,f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_to_room_no, messageFrame )  )\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tf_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.submit() ;\n\t\t\t\t\t\t\n\t\t\t }\n    }\t\n\tfunction doDateCheckAlert(from,to)\n\t\t{\n\t\t\tvar fromdate = from.value ;\n\t\t\tvar todate = to.value ;\n\t\t\tvar localeName=f_query_add_mod.document.forms[0].p_language_id.value;\n\t\t\tif(fromdate!=\'\' && todate!=\'\')\n\t\t\t{\n\t\t\t\t\tvar greg_fromDate = convertDate(fromdate,\"DMYHM\",localeName,\"en\");\n\t\t\t\t\tvar greg_toDate = convertDate(todate,\"DMYHM\",localeName,\"en\");\n\t\t\t\t\tif(isBefore(greg_fromDate,greg_toDate,\"DMYHM\",\"en\"))\n\t\t\t\t\t{\t\t\t\t\t\t\n\t\t\t\t\t\treturn true;\n\t\t\t\t\t}\n\t\t\t\t\telse \n\t\t\t\t\t{\n\t\t\t\t\t\treturn false;\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t\treturn true;\n\n\t\t}\n</script>\n\t\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" frameborder=\'0\' scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t<iframe scrolling=\"no\" name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'../jsp/IPListofAvailableBedsbySpecialty_form.jsp\'  frameborder=0 style=\'height:80vh;width:100vw\'></iframe><iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:40%;width:100vw\'></iframe>\n</html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block5Bytes, _wl_block5);
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
