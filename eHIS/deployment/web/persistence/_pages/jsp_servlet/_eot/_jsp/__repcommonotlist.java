package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import eOT.*;
import eOT.Common.*;

public final class __repcommonotlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/repCommonOTList.jsp", 1709120332000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script language=\"javascript\">\n\tfunction assignLabel(){\n\t\tvar formObj = document.forms[0];\n\t\tvar x_table_id= formObj.p_table_id.value;\n\t\tvar x_rep_desc= formObj.p_rep_desc.value;\n        var locale = formObj.locale.value;\n\t\tvar code_title=getLabel(\"Common.code.label\",\"common\");\n\t\t if (x_rep_desc.length!=0 ) \n\t\t   t1.innerHTML= x_rep_desc + \" &nbsp;\";//x_rep_desc.toLowerCase() +\" &nbsp;\";\n\t\telse{\n\t\t   //t1.innerHTML= \"Code\" +\" &nbsp;\";  \n\t\t   t1.innerHTML= code_title +\" &nbsp;\";  \n\t\t}\n\n\t\tif (x_table_id==\"OT_OPER_TYPE\"){\n\t\t//\tformObj.qry_sql.value=\"SELECT OPER_TYPE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_TYPE WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_TYPE) LIKE UPPER(?) ORDER BY 2\";\n\t\n\t\tformObj.qry_sql.value=\"SELECT OPER_TYPE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_TYPE_LANG_VW WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_TYPE) LIKE UPPER(?) AND LANGUAGE_ID =\'\"+locale+\"\'  ORDER BY 2\";\n\t\tformObj.p_report_id.value=\"OTSOPTYP\";\n\n\t\t}\n\t\telse if (x_table_id==\"OT_EQUIPMENT_LANG_VW\"){\n\t\t\tformObj.qry_sql.value=\"SELECT EQUIPMENT_CODE CODE, LONG_DESC DESCRIPTION FROM OT_EQUIPMENT_LANG_VW WHERE LANGUAGE_ID =\'\"+locale+\"\' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(EQUIPMENT_CODE) LIKE UPPER(?) ORDER BY 2\";\n\t\t\tformObj.p_report_id.value=\"OTCEQUIP\";\n\t\t}\n\t\telse if (x_table_id==\"OT_OPER_ROOM\"){\n\t\t\tformObj.qry_sql.value=\"SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID = \'\"+p_facility_id+\"\' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2\";\n\t\t\tformObj.p_report_id.value=\"OTROTROM\";\n\t\t}\t\n\t}\n</script>\n<html>\n<HEAD>\n<TITLE></TITLE>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'></link>\n<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n <script src=\"../../eCommon/js/ValidateControl.js\"></script>\n <script src=\"../../eOT/js/OtReports.js\" ></script> \n <script language=\"javascript\" src=\"../../eCommon/html/blank.html\"> </script>\n <script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"> </script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<!-- <script src=\"../../eCommon/js/messages.js\" language=\"javascript\"></script>\n\t<script src=\"../../eOT/js/OTMessages.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n -->\n</HEAD>\n\n<BODY onMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey()\' onLoad=\"Focusing(\'p1\');\">\n<br>\n<br>\n<form name=\"OtReportOptionsForm\" id=\"OtReportOptionsForm\" action=\"../../eCommon/jsp/report_options.jsp\"  target=\"messageFrame\">\n\n<table width=\'80%\' align=\'center\' valign=\'top\' >\n\t<th align=\'left\'> <fmt:message key=\"Common.reportcritera.label\" bundle=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"/></th>\n\t<tr>\n\t\t<td width=\"100%\" class=\"Border\" align=\'center\'>\n\t\t\t<table width=\'100%\' cellpadding=3 cellSpacing=\"0\" align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"center\" width=\"35%\">&nbsp;</td>\n\t\t\t\t\t<td class=\"label\" width=\"20%\" ><fmt:message key=\"Common.from.label\" bundle=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/></td>\n\t\t\t\t\t<td class=\"label\" width=\"40%\"><fmt:message key=\"Common.to.label\" bundle=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/></td>\n\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=\'right\' width=\'30%\' class=\"label\" id=\"test\" > <fmt:message key=\"Common.code.label\" bundle=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/> &nbsp;</td>\n\t\t\t\t\t\t<td width=\'30%\'  >\n\t\t\t\t\t\t<input type=\'hidden\' name=\"p1\" id=\"p1\" value=\"\"> \n\t\t\t\t\t\t<input type=\"text\"  name=\'p1_desc\' id=\'p1_desc\' size=\"15\" maxlength=\"15\" align=\"center\" onFocus = \"assignLabel();\">\n\t\t\t\t\t  \t<input type=\'button\' class=\'button\' value=\'?\' name=\'but1\' id=\'but1\' onclick=\"searchCode(p1,p1_desc,document.forms[0].p_rep_desc.value,document.forms[0].qry_sql.value);\" >\n     \t\t\t\t    </td>\n\n\n\t\t\t\t\t\t<td width=\'40%\'> \n\t\t\t\t\t\t<input type=\'hidden\' name=\"p2\" id=\"p2\" value=\"\"> \n\t\t\t\t\t\t<input type=\"text\"  name=\'p2_desc\' id=\'p2_desc\' size=\"15\" maxlength=\"15\" align=\"center\" >\n\t\t\t\t\t\t<input type=\'button\' name=\'but2\' id=\'but2\' value=\'?\' class=\'button\' onclick=\"searchCode(p2,p2_desc,document.forms[0].p_rep_desc.value,document.forms[0].qry_sql.value);\" >\n\t\t\t\t\t\t</td>\t\t\t\t\n\n\t\t\t\t\t</tr>\n\n</table>\n</td>\n</tr>\n</table>\n\n<input type=\"hidden\" name=\"user_id\" id=\"user_id\"\tvalue=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\"  value=\"OT\">\n<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" value=\"OTSOPTYP\">\n<input type=\"hidden\" name=\"pgm_id\" id=\"pgm_id\" value=\"OTSOPTYP\">\n\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n<input type=\"hidden\" name=\"p_rep_desc\" id=\"p_rep_desc\" value = ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =">\n<input type=\"hidden\" name=\"p_table_id\" id=\"p_table_id\" value = ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">\n<input type=\"hidden\" name=\"qry_sql\" id=\"qry_sql\" value=\" \" >\n\n<input type=\"hidden\" name=\"no_of_mandatory_fields\" id=\"no_of_mandatory_fields\" value=\"0\" disabled>\n<input type=\"hidden\" name=\"no_of_compare_date_fields\" id=\"no_of_compare_date_fields\" value=\"0\" disabled>\n<input type=\"hidden\" name=\"no_of_comparison_fields\" id=\"no_of_comparison_fields\" value=\"0\" disabled>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n</form>\n</BODY>\n</HTML>\n\t\t\t\n\t\t\t\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	//String p_module_id		= "OT" ;
	//String p_report_id		= "" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	//String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_rep_desc		= request.getParameter("rep_desc"); 
	String p_table_id		= request.getParameter("t_id"); 
	String user_id			= (String)session.getValue("login_user");
	
	//String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String function_id = request.getParameter("function_id");
	//String source = url + params ;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
	}catch(Exception e){
		System.err.println("Err Msg repCommonOTList.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
  }


            _bw.write(_wl_block3Bytes, _wl_block3);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( p_rep_desc ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( p_table_id ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
