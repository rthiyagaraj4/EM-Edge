package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __repss203form extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/repSS203Form.jsp", 1722345660775L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\n<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\"../../eCommon/js/common.js\"></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCommon/js/common.js\"></script>\n\t<script src=\"../../eMR/js/MRReports.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\n\t\tfunction ChkDateFormat(Object2) {\n\t\t\tvar datefield = Object2;\n\t\t\tif (ChkDate1(Object2) == false) {\n\t\t\t\talert(parent.parent.parent.frames[0].getMessage(\'INVALID_DATE_FMT\',\'SM\'));\n\t\t\t\tdatefield.select();\n\t\t\t\tdatefield.focus();\t\t\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse {\n\t\t\t\treturn true;\n\t\t\t}\n\t\t}\n function ValidString(event)\n{\n\tif((((event.keyCode>=48) && (event.keyCode<=57))\n\t\t||((event.keyCode>=65) && (event.keyCode<=90))\n\t\t||((event.keyCode>=97) && (event.keyCode<=122))\n\t\t||(event.keyCode==42)||(event.keyCode==95)))\n\t{\n\t\treturn true\n\t}\n\telse\n\t{\t\n\t\treturn false\n\t}\n}\nfunction allowPositiveNumberm() \n{\n\tvar key = window.event.keyCode;\n\t\n\t// allows only numbers to be entered\n\t\n\tif((key >=47 )&&(key <58)) \n\t\t{\n\t\t\treturn true;\n\t\t}\n\t\telse \n\t\t\treturn false\n}\nfunction allowPositiveNumbermy() \n{\n\tvar key = window.event.keyCode;\n\t\n\t// allows only numbers to be entered\n\tif((key >47 )&&(key<58)) \n\t\t{\n\t\t\treturn true;\n\t\t}\n\t\telse \n\t\t\treturn false\n}\n\n\t\n\n\nfunction clearList(objSelect)\n{\n\tvar length = objSelect.options.length;\n\tfor(var index = 1 ;index < length ;index++)\n\t{\n\t\tobjSelect.remove(1)\n\t}\n}\n\n//function name changed and validateDT added for ML-MMOH-SCF-2021 by Kamatchi S\nfunction mychangeRep()\n {\n\t //document.getElementById(\"report_type\").value=\"D\";\n\t if (document.getElementById(\"report_type\").value==\'M\')\n\t {\n\t\t \n\t\t document.getElementById(\"MY1\").innerHTML=getLabel(\"Common.month.label\",\"Common\")+\"&nbsp;\"\n\t\t document.getElementById(\"MY\").innerHTML = \"<input type=\'text\' name=\'p_fm_Date\' id=\'p_fm_Date\'  maxlength=\'7\' size=\'7\' onblur=\'ChkDateFormat(this);ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\\\"report_type\\\").value);\' onKeypress=\'return allowPositiveNumberm();\'><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_fm_Date.select();return showCalendar(\'p_fm_Date\',\'mm/y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t\t \n\t }\n\t else  if (document.getElementById(\"report_type\").value==\'Y\')\n\t {\n\t   \n\t\t document.getElementById(\"MY1\").innerHTML=getLabel(\"Common.year.label\",\"Common\")+\"&nbsp;\"\n\t\t document.getElementById(\"MY\").innerHTML = \"<input type=\'text\' name=\'p_fm_Date\' id=\'p_fm_Date\'  maxlength=\'4\' size=\'4\' onkeypress=\'return allowPositiveNumbermy()\' onblur=\'ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\\\"report_type\\\").value);\' ><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_fm_Date.select();return showCalendar(\'p_fm_Date\',\'y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t }\n\t  else  if (document.getElementById(\"report_type\").value==\'D\')\n\t {\n\t    \n\t\t document.getElementById(\"MY1\").innerHTML=getLabel(\"Common.date.label\",\"Common\")+\"&nbsp;\"\n\t\t document.getElementById(\"MY\").innerHTML = \"<input type=\'text\' name=\'p_fm_Date\' id=\'p_fm_Date\'  maxlength=\'10\' size=\'10\'onBlur=\'CheckDate(this);ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\\\"report_type\\\").value);\'><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_fm_Date.select();return showCalendar(\'p_fm_Date\',\'dd/mm/y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t }\n\n\t  if (document.getElementById(\"report_type\").value==\'M\')\n\t {\n\t\t  \n\t\t  document.getElementById(\"MY3\").innerHTML = \"<input type=\'text\' name=\'p_to_Date\' id=\'p_to_Date\'  maxlength=\'7\' size=\'7\' onblur=\'ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\\\"report_type\\\").value);ChkDateFormat(this);\' onKeypress=\'return allowPositiveNumberm();\'><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_to_Date.select();return showCalendar(\'p_to_Date\',\'mm/y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t\t  \n\t }\n\t else  if (document.getElementById(\"report_type\").value==\'Y\')\n\t {\n\t\t\n\t\t \n\t\t document.getElementById(\"MY3\").innerHTML = \"<input type=\'text\' name=\'p_to_Date\' id=\'p_to_Date\'  maxlength=\'4\' size=\'4\' onkeypress=\'return allowPositiveNumbermy()\' onblur=\'ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\\\"report_type\\\").value);\' ><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_to_Date.select();return showCalendar(\'p_to_Date\',\'y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t }\n\t  else  if (document.getElementById(\"report_type\").value==\'D\')\n\t {\n\t\t  \n\t\t document.getElementById(\"MY3\").innerHTML = \"<input type=\'text\' name=\'p_to_Date\' id=\'p_to_Date\'  maxlength=\'10\' size=\'10\' onBlur=\'ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\\\"report_type\\\").value);CheckDate(this);\'><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_to_Date.select();return showCalendar(\'p_to_Date\',\'dd/mm/y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t }\n }\t\n \n</script>\n</head>\n<!--function name changed for ML-MMOH-SCF-2021 by Kamatchi S-->\n<body  OnMouseDown=\"CodeArrest();\" onLoad=\"FocusFirstElement();mychangeRep();\"  onKeyDown = \'lockKey()\'>\n<form name=\"MRBSS203\" id=\"MRBSS203\" action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n<BR><BR><BR><BR>\n<table border=\"0\" width=\'80%\' cellpadding=\"0\" cellspacing=\"0\"  align=\'center\'>\n<th align=\'left\' colspan=\'4\'> ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</th>\n<tr>\n\t<td colspan=4>&nbsp;</td>\n</tr>\n<tr>\n\t<td colspan=1 width=\'10%\'>&nbsp;</td>\n\t<td align=\'right\' width=\'15%\' class=\"label\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&nbsp;</td>\n\t<td width=\'25%\'  >\n\t\t <SELECT name=\"report_type\" id=\"report_type\" onchange=\'mychangeRep()\'><!--function name changed for ML-MMOH-SCF-2021 by Kamatchi S-->\n\t\t <option value=\"D\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</option>\n\t\t <option value=\"M\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</option>\n\t\t <option value=\"Y\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</option>\n\t\t </SELECT>\n\t</td>\n\t<td width=\'30%\'>&nbsp;</td>\n</tr>\n\t<tr>\n\t<td colspan=4>&nbsp;</td>\n</tr>\n<tr>\n<td colspan=1 >&nbsp;</td>\t\t\n<td align=\'right\' id=\'MY1\'class=\"label\"> &nbsp; </td>\n\t\t<td align=\'left\' id=\'MY\' > &nbsp; </td>\n\t\t<td align=\'left\' id=\'MY3\' > &nbsp; </td>\n</tr>\n<tr>\n\t<td colspan=4>&nbsp;</td>\n</tr>\n\t\n</table>\n<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" \tvalue=\"MRBSS203\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \t\tvalue=\"MR\">\n<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n<input type=\"hidden\" name=\"P_RESP_ID\" id=\"P_RESP_ID\"\t\tvalue=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n \n \n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block0Bytes, _wl_block0);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block4Bytes, _wl_block4);

	request.setCharacterEncoding("UTF-8");
    Connection con =null;
	ResultSet rset = null;
	java.sql.Statement stmt1 = null;

	String facility_id = (String) session.getValue("facility_id");
    String resp_id=(String) session.getValue("responsibility_id");
	String user_id = (String) session.getValue("login_user");
	String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");

try {

    con=ConnectionManager.getConnection(request);

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block15Bytes, _wl_block15);

} catch(Exception e) {  /* out.println("in else "+e); */ e.printStackTrace();}
finally
{
	if(con != null)ConnectionManager.returnConnection(con,request);
	 if(rset!= null) rset.close();
	 if(stmt1!=null) stmt1.close();
}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reportcritera.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reporttype.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.daily.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.monthly.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Yearly.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }
}
