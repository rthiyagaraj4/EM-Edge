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

public final class __fmdocmovementhistorysearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMDocMovementHistorySearch.jsp", 1709116836388L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/checkSystemDate.js\'></script>\n\t<script language=\'javascript\' src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\n</head>\n<script>\nfunction DateCompare(from,to,messageFrame,getVal) \n{\n\tvar getValue = getVal;\n\tvar fromarray; var toarray;\n\tvar fromdate = from.value ;\n\tvar todate = to.value ;\n\tif(fromdate.length > 0 && todate.length > 0 ) \n\t{\n\t\tfromarray = fromdate.split(\"/\");\n\t\ttoarray = todate.split(\"/\");\n\t\tvar fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);\n\t\tvar todt = new Date(toarray[2],toarray[1],toarray[0]);\n\t\tif(Date.parse(todt) < Date.parse(fromdt)) \n\t\t{\n\t\t\t//var\tmessag = \"APP-SM0005 To Date should be Greater than or equal to From Date\";\n\t\t\tvar\tmessag = getMessage(\"TO_DATE_LESSER_FROM_DATE\",\"FM\");\n\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+messag;\t\t\t\n\t\t\tto.select();\n\t\t\treturn false;\n\t\t}\n\t\telse if(Date.parse(todt) >= Date.parse(fromdt)) \n\t\t{\n\t\t\treturn true;\n\t\t}\n\t}\n\treturn true;\n}\n\n\tfunction CheckPatientExists(ObjVal)\n\t{\t\n\t\tif(ObjVal != \"\")\n\t\t{\n\t\t\tvar facility = ManualEntry_form.p_facility_id.value;\n\t\t\tvar HTMLVal = \"<html><body onKeyDown = \'lockKey()\' ><form name=\'Dummy\' id=\'Dummy\' method=\'post\' action=\\\"../../eFM/jsp/FMFileMovementCheckPatientExists.jsp?Patient=\"+ObjVal+\"&Facility=\"+facility+\" \\\"> </form></body></html>\";\n\t\t\tparent.frames[2].document.write(HTMLVal);\n\t\t\tparent.frames[2].document.forms[0].submit();\n\t\t}\t\n\t}\n\tfunction CheckFileExists(ObjVal)\n\t{\n\t\tif(ObjVal != \"\")\n\t\t{\n\t\t\tvar facility = ManualEntry_form.p_facility_id.value;\n\t\t\tvar HTMLVal = \"<html><body onKeyDown = \'lockKey()\'><form name=\'Dummy\' id=\'Dummy\' method=\'post\' action=\\\"../../eFM/jsp/FMFileMovementCheckFileExists.jsp?FileNo=\"+ObjVal+\"&Facility=\"+facility+\" \\\"> </form></body></html>\";\n\t\t\tparent.frames[2].document.write(HTMLVal);\n\t\t\tparent.frames[2].document.forms[0].submit();\n\t\t}\t\n\t}\n</script>\n<body OnMouseDown=\'CodeArrest();\' onload=\'FocusFirstElement();\' onKeyDown = \'lockKey();\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\'ManualEntry_form\' id=\'ManualEntry_form\' target=\'messageFrame\' action=\"../../eCommon/jsp/report_options.jsp\">\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'95%\' align=\'center\'>\n\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\t\n\t</tr><td colspan=\"6\" >\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t</td></tr>\n\t<tr>\n\t\t<td  class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;</td>\n\t\t<td >&nbsp;<input type=\'text\' id=\"date_from\" name=\'p_from_date\' id=\'p_from_date\' size=\'10\' maxlength=\'10\' tabIndex=\"3\" value=\'\' onBlur=\"validDateObj(this,\'DMY\',localeName);DateCompare(this, p_to_date, \'messageFrame\',\'Date\');\"><input type=\"image\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'date_from\');\">&nbsp;-&nbsp;<input type=\'text\' id=\"date_to\" name=\'p_to_date\' id=\'p_to_date\' size=\'10\' maxlength=\'10\' value=\'\' tabIndex=\"4\" onBlur=\"CheckDate(this);DateCompare(p_from_date, this, \'messageFrame\',\'Date\');\"><input type=\"image\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'date_to\');\"></td>\n\t</tr>\n\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\n</table>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<input type=\"hidden\" name=\"today\" id=\"today\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<input type=\'hidden\' name=\'f_curr_fs_locn\' id=\'f_curr_fs_locn\' value=\'\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String p_module_id		= "FM" ;
	String p_report_id		= "FMBFMVHS" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;

            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection conn		= ConnectionManager.getConnection(request);

	Statement stmt	= null;
	ResultSet rset	= null;	
	String sql = "";
	String today ="";
    
	try
	{
		sql = "select to_char(sysdate,'dd/mm/yyyy')today from dual";
		stmt = conn.createStatement();
		rset = stmt.executeQuery(sql);
		if (rset.next())
		{
			today = rset.getString("today");
		}

            _bw.write(_wl_block9Bytes, _wl_block9);
            {java.lang.String __page ="../../eFM/jsp/FMFileSearchComponentValues.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("frame_name"), weblogic.utils.StringUtils.valueOf("parent.searchResultFrame")},{ weblogic.utils.StringUtils.valueOf("form_name"), weblogic.utils.StringUtils.valueOf("ManualEntry_form")},{ weblogic.utils.StringUtils.valueOf("messageframe_name"), weblogic.utils.StringUtils.valueOf("parent.messageFrame")},{ weblogic.utils.StringUtils.valueOf("patientid_name"), weblogic.utils.StringUtils.valueOf("patientid")},{ weblogic.utils.StringUtils.valueOf("fileno_name"), weblogic.utils.StringUtils.valueOf("file_no")},{ weblogic.utils.StringUtils.valueOf("filetype_name"), weblogic.utils.StringUtils.valueOf("file_type_code")},{ weblogic.utils.StringUtils.valueOf("document_type_name"), weblogic.utils.StringUtils.valueOf("doc_type_code")},{ weblogic.utils.StringUtils.valueOf("document_folder_id_name"), weblogic.utils.StringUtils.valueOf("doc_folder_id")},{ weblogic.utils.StringUtils.valueOf("volumeno_name"), weblogic.utils.StringUtils.valueOf("volume_no")},{ weblogic.utils.StringUtils.valueOf("table_width"), weblogic.utils.StringUtils.valueOf("95")},{ weblogic.utils.StringUtils.valueOf("tablealign"), weblogic.utils.StringUtils.valueOf("center")},{ weblogic.utils.StringUtils.valueOf("volume_mandatory_yn"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("locn_code"), weblogic.utils.StringUtils.valueOf("f_curr_fs_locn")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();
}
catch(Exception e)
{
	out.println(e);
}
finally
{	
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( p_facility_id ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( p_module_id ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( p_report_id ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( p_user_name ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(today));
            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
