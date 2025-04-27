package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import oracle.jdbc.driver.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __repassessmentcategorylist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/repAssessmentCategoryList.jsp", 1709116611402L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block1 ="\n<HTML>\n<HEAD>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'></link>\t<SCRIPT src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></SCRIPT>\n\t<SCRIPT src=\"../../eCommon/js/common.js\" language=\"javascript\"></SCRIPT>\n\t<SCRIPT src=\"../../eCP/js/repCpMasterList.js\" language=\"javascript\"></SCRIPT>\n\t<script>\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\nfunction searchCode(obj,target)\n\t{\n\t\t\tvar retVal = \tnew String();\n\t\t\tvar dialogHeight= \"28\" ;\n\t\t\tvar dialogWidth\t= \"43\" ;\n\t\t\tvar status = \"no\";\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar sql=\"\";\n\t\t\tvar search_code=\"\";\n\t\t\tvar search_desc=\"\";\n\t\t\tvar tit=\"\";\n\t\t\t//var facility=obj1.value;\n\t\t\tif(obj.name==\"Assessmenttype\")\n\t\t\t{\n\t\t\t\ttit=\"Assessment \"\n\t\t\t\t//sql=\"select clinic_code, short_desc from op_clinic \";\n\t\t\t\tsql=\"select ASSESS_CATG_CODE,SHORT_DESC from cp_assess_catg\";\n\t\t\t\tsearch_code=\"assess_catg_code\";\n\t\t\t\tsearch_desc= \"SHORT_DESC\"\n\t\t\t}\n\t\t\t\n\t\t\tif(obj.name==\"Assessmenttype1\")\n\t\t\t{\n\t\t\t\ttit=\"Assessment\"\n\t\t\t\t//sql=\"select clinic_code, short_desc from op_clinic where FACILITY_ID=\"+facility;\n\t\t\t\tsql=\"select assess_catg_code,short_desc from cp_assess_catg\";\n\t\t\t\tsearch_code=\"assess_catg_code\";\n\t\t\t\tsearch_desc= \"SHORT_DESC\"\n\t\t\t}\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\t\tretVal = window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit,arguments,features);\n\n\t\t\tif (!(retVal == null))\n\t\t\t{\n\t\t\t\ttarget.value=retVal;\n\t\t\t}\n\t\t\telse\n\t\t\t\ttarget.focus();\n\t\t\t}\n</SCRIPT>\n</HEAD>\n<BODY  OnMouseDown=\"CodeArrest()\"  onKeyDown = \'lockKey()\'>\n\t<FORM name=\"repAssessmentForm\" id=\"repAssessmentForm\" action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n\t<BR>\n\t<TABLE width=\'80%\' align=\'center\' valign=\'top\'>\n\t\t<TH align=\'left\'> <fmt:message key=\"Common.reportcritera.label\" bundle=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"/></TH>\n\t\t<TR>\n\t\t\t<TD width=\"100%\" class=\"Border\" align=\'center\'>\n\t\t\t\t<TABLE width=\'80%\' cellPadding=\"0\" cellSpacing=\"0\"  align=\'center\' >\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD align=\"center\" width=\"25%\">&nbsp;</TD>\n\t\t\t\t\t\t<TD class=\"label\" width=\"20%\"><fmt:message key=\"Common.from.label\" bundle=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"/></TD>\n\t\t\t\t\t\t<TD class=\"label\" width=\"40%\"><fmt:message key=\"Common.to.label\" bundle=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/></TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD class=\"label\" align=\"right\">Assessment Catagory&nbsp;</TD>\n\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<input type=text  name=\'p_Assessment_code_from\' id=\'p_Assessment_code_from\' size=\"10\" maxlength=\"10\" align=\"center\">\n\t\t\t\t\t\t\t<input type=\'button\' name=\'Assessmenttype\' id=\'Assessmenttype\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_Assessment_code_from)\'>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<input type=text  name=\'p_Assessment_code_to\' id=\'p_Assessment_code_to\' size=\"10\" maxlength=\"10\" align=\"center\">\n\t\t\t\t\t\t\t<input type=\'button\' name=\'Assessmenttype1\' id=\'Assessmenttype1\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_Assessment_code_to)\'>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD colspan=\"3\">&nbsp;</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD align=\'right\' width=\'30%\' class=\"label\"><fmt:message key=\"Common.Nature.label\" bundle=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/> &nbsp;</TD>\n\t\t\t\t\t\t<TD  width=\'20%\' align=\"left\">\n\t\t\t\t\t\t\t<select name=\'p_nature\' id=\'p_nature\'>\n\t\t\t\t\t\t\t\t<option value=\"\"><fmt:message key=\"Common.Both.label\" bundle=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/>\n\t\t\t\t\t\t\t\t<option value=\"E\"><fmt:message key=\"Common.enabled.label\" bundle=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/>\n\t\t\t\t\t\t\t\t<option value=\"D\"><fmt:message key=\"Common.Disabled.label\" bundle=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD colspan=\"3\">&nbsp;</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD align=\'right\' width=\'30%\' class=\"label\"><fmt:message key=\"Common.orderBy.label\" bundle=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/> &nbsp;</TD>\n\t\t\t\t\t\t<TD  width=\'20%\' align=\"left\">\n\t\t\t\t\t\t\t<select name=\'p_order_by\' id=\'p_order_by\'>\n\t\t\t\t\t\t\t\t<option value=\"1\"><fmt:message key=\"Common.code.label\" bundle=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/>\n\t\t\t\t\t\t\t\t<option value=\"2\"><fmt:message key=\"Common.description.label\" bundle=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD colspan=\"3\">&nbsp;</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t</TABLE>\n\t\t\t</TD>\n\t\t</TR>\n\t</TABLE>\n\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n    <input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n    <input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n    <input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n    <input type=\"hidden\" name=\"p_resp_id\" id=\"p_resp_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t</FORM>\n<BODY>\n<HTML>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	//This file is saved on 18/10/2005.
	String p_module_id		= "CP";
	String p_report_id		= "CPBASCLT" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String p_resp_id			=	(String) session.getValue("responsibility_id");
    
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( p_facility_id ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( p_module_id ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( p_report_id ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( p_user_name ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( p_resp_id ));
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
