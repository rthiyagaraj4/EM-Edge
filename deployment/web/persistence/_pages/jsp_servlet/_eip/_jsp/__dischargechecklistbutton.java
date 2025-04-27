package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import com.ehis.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __dischargechecklistbutton extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/DischargeCheckListButton.jsp", 1720012442569L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<Script src=\"../../eCommon/js/dchk.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eIP/js/DischargeCheckList.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t<script>\n\n\tfunction callSubmit()\n\t{\n\t\t //Added by Mano on 19-Mar-2018 aganist ML-MMOH-CRF-1049 \n\t\tvar from =  parent.frames[1].document.forms[0].cert_from_date;\n\t\tvar to =  parent.frames[1].document.forms[0].cert_to_date;\n\t\t\n\t\t//Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218\n\t\tvar cert_num =  parent.frames[1].document.forms[0].cert_num;\n\t\tvar isautopopdurationapplyn = parent.frames[1].document.forms[0].isAutoPopDurationApplyn.value;\t\n\t\n\t\tparent.DischargeCheckList_frame1.setData_main();\n\t\tif(document.forms[0].infomPass.value == \"N\")\n\t\t{\n\t\t\tvar error = getMessage(\'CAN_NOT_BE_BLANK\',\'Common\'); \n\t\t\terror     = error.replace(\'$\',getLabel(\"Common.InformedDate/Time.label\",\"Common\"));\n\t\t\talert(error); \n\t\t}\n\t     else if ((from.value == \'\' || to.value == \'\') && isautopopdurationapplyn == \'true\')\n\t\t {\n\t\t\t //Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218\n\t\t\t if (!cert_num.value == \'\')\n\t\t\t {\n\t\t\t var error = getMessage(\'CAN_NOT_BE_BLANK\',\'Common\').replace(\'$\',getLabel(\"Common.fromdate.label\",\"Common\"));\n\t\t\t var error1 = getMessage(\'CAN_NOT_BE_BLANK\',\'Common\').replace(\'$\',getLabel(\"Common.todate.label\",\"Common\"));\n\t\t\t var finalError = \"\";\n\t\t\t \n\t\t\t if(from.value == \'\' && to.value == \'\')\n\t\t\t {\n\t\t\t\t finalError = error+\"\\n\"+error1;\n\t\t\t }\n\t\t\t else if(from.value == \'\')\n\t\t\t {\n\t\t\t\t finalError = error;\n\t\t\t }\n\t\t\t else\n\t\t\t {\n\t\t\t\t finalError = error1;\n\t\t\t }\n\t\t\t alert(finalError);\n\t\t\t }else\n\t\t\t {\n\t\t\t\t parent.DischargeCheckList_frame1.document.forms[0].submit();\n\t\t\t }\n\t\t }\n\t\telse\n\t\t{\n\t\t\tparent.DischargeCheckList_frame1.document.forms[0].submit();\n\t\t}\n\t}\n\nsetInterval(\"datefun()\",500);\n\tfunction datefun()\n\t{\n\t\tvar dttm = getCurrentDate(\'DMYHM\' ,\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\');\t\n\t\tdocument.forms[0].date_time_txt.value=dttm;\n\t\n\t}\n\tfunction close_window(){\n\t\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t\tdialogTag.close();\n\t}\n\n\n</script>\n</head>\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t<form name=\'DischargeCheckListButton\' id=\'DischargeCheckListButton\' method=\"post\" target=\"messageFrame\">\n\t\t\t<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' id=\'user_label\' width=\'25%\'>&nbsp;";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'>&nbsp;<input type=\'text\' name=\'user_txt\' id=\'user_txt\' size=\'15\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" disabled></td>\n\t\t\t\t<td class=\'label\' id=\'date_time_label\' width=\'25%\'>&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'date_time_txt\' id=\'date_time_txt\' id=\'datetimetxt\' size=\'16\' maxlength=\'16\' value=\"\" disabled></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' >&nbsp;</td>\n\t\t\t\t<td class=\'label\' >&nbsp;</td>\n\t\t\t\t<td class=\'label\' >&nbsp;</td>\n\t\t\t\t<td class=\'label\' >\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<input class=\'button\' type=\'button\' name=\'record\' id=\'record\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' onclick=\'callSubmit();\'>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<input class=\'button\' type=\'button\' name=\'print\' id=\'print\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' onclick=\'callPrint();\'>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<input class=\'button\' type=\'button\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' onclick=\'close_window();\'>&nbsp;&nbsp;</td>\n\t\t\t</tr>\n\t\t<input type=hidden name=\"infomPass\" id=\"infomPass\" value=\"Y\" >\n\t\t</table>\n\t</form>\n\t<script>\n\n\t\tif(document.forms[0].date_time_txt)\n\t\t{\n\t\t\tif(parent.DischargeCheckList_frame1.document.forms[0])\n\t\t\t{\n\t\t\t\tif(parent.DischargeCheckList_frame1.document.forms[0].h_date_time_txt)\n\t\t\t\t{\n\t\t\t\t\tif(parent.DischargeCheckList_frame1.document.forms[0].h_date_time_txt.value!=\'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].date_time_txt.value = parent.DischargeCheckList_frame1.document.forms[0].h_date_time_txt.value;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tif(document.forms[0].user_txt)\n\t\t{\n\t\t\tif(parent.DischargeCheckList_frame1.document.forms[0])\n\t\t\t{\n\t\t\t\tif(parent.DischargeCheckList_frame1.document.forms[0].h_user_txt)\n\t\t\t\t{\n\t\t\t\t\tif(parent.DischargeCheckList_frame1.document.forms[0].h_user_txt.value!=\'\')\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].user_txt.value = parent.DischargeCheckList_frame1.document.forms[0].h_user_txt.value;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t</script>\n</body>\n</html>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8");
String call_function= request.getParameter("call_function")==null?"":request.getParameter("call_function");
String disable_print= request.getParameter("disable_print")==null?"":request.getParameter("disable_print");
String locale			= (String)session.getAttribute("LOCALE");
String login_user = (String)session.getValue("login_user");


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

			if(!call_function.equals("VIEW_DISCHARGE_CHECKLIST"))
			{	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block13Bytes, _wl_block13);
	}
			else
			{	
				 if(!disable_print.equals("Disabled"))
				 {		
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")));
            _bw.write(_wl_block15Bytes, _wl_block15);
		}
				}
			
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RecordedBy.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.on.label", java.lang.String .class,"key"));
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
}
