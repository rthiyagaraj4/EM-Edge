package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recdiagnosistabs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecDiagnosisTabs.jsp", 1729661121771L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart2.js\'></script>\n\t<script>\n\tvar currentTab = new String();\n\tcurrentTab = \"Diagnosis\";\n\n\tfunction tab_change(tab_name)\n\t{\n\t\tif(currentTab == \"Diagnosis\")\n\t\t\tdocument.getElementById(\"curr_id\").src=\"../../eMR/images/current diagnosis_light.gif\";\n\t\telse if(currentTab ==\"Episode\")\n\t\t\tdocument.getElementById(\"EOC_id\").src=\"../../eMR/images/Episodeofcare_light.gif\";\n\n\t\tif(tab_name == \"Diagnosis\")\n\t\t\t\tdocument.getElementById(\"curr_id\").src=\"../../eMR/images/current diagnosis_dark.gif\";\t\t\n\t\telse if(tab_name ==\"Episode\")\n\t\t\tdocument.getElementById(\"EOC_id\").src=\"../../eMR/images/Episodeofcare_dark.gif\";\n\n\t\tcurrentTab = tab_name;\n\t}\n\n\tfunction Call_click(tab_name)\n\t{\n\t\tif(tab_name == \"Diagnosis\"){\n\t\t\t\t\tvar qery_str1=document.forms[0].query_string.value;\n\t\tparent.RecDiagnosisMain.location.href=\'../../eMR/jsp/RecDiagnosisMain.jsp?\'+qery_str1;\n\n\t\t}\t\n\t\telse if(tab_name ==\"Episode\"){\n\t\t\tvar qery_str=document.forms[0].query_string.value;\n\t\t\tparent.RecDiagnosisMain.location.href=\'../../eMR/jsp/RecDiagnosisEOCMain.jsp?\'+qery_str;\n\t\t}\n\t}\n\t</script>\n</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<!-- <body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  onload=\"tab_change(\'Diagnosis\');Call_click(\'Diagnosis\');\">\n on load scipt call removed as part of PE\n -->\n <body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  >\n\n\t<center>\n\t<form name=\'RecClinicalNotesTabForm\' id=\'RecClinicalNotesTabForm\'>\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t<tr>\n\t\t\t<td align=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t\t\t<!-- <a align=\'left\' href=\"javascript:tab_change(\'Diagnosis\')\" ><img src=\"../../eMR/images/current diagnosis_light.gif\" border=0 id=\'curr_id\' onClick=\"Call_click(\'Diagnosis\')\"></a>\n\t\t\t\t<a align=\'left\' href=\"javascript:tab_change(\'Episode\')\" ><img src=\"../../eMR/images/Episodeofcare_light.gif\" border=0 id=\'EOC_id\' onClick=\"Call_click(\'Episode\')\"></a>\n -->\n\t\t\t\t<!-- <a <style_visibility%> href=\'javascript:callRecDiagnosis()\'>\n\t\t\t\t\t<input type=\'Button\' name=\'Diagnosis\' id=\'Diagnosis\' value=\' Current Problems/Diagnosis \' class=\"button\" onClick=\'callRecDiagnosis();\'>\n\t\t\t\t</a> -->\n\t\t\t\t<!-- <a <style_visibility%> href=\'javascript:callEpisodeofCare()\'>\n\t\t\t\t\t<input type=\'Button\' name=\'Episode\' id=\'Episode\' value=\' Episode of Care \' class=\"button\" onClick=\'callEpisodeofCare();\'>\n\t\t\t\t</a> -->\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" <input type=\"BUTTON\" class=\"BUTTON\" name=\"view_error\" id=\"view_error\" value=\"View Error Docs\" onClick=\"showErrorDocuments()\">\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t</td> </tr>\n\t</table>\n\t<input type=\'hidden\' name=\'query_string\' id=\'query_string\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t<input type=\'hidden\' name=\'editor_reqd_yn\' id=\'editor_reqd_yn\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t<input type=\'hidden\' name=\'operation_mode\' id=\'operation_mode\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t<input type=\'hidden\' name=\'curr_click\' id=\'curr_click\' value=\'Y\'>\n\t<input type=\'hidden\' name=\'EOC_click\' id=\'EOC_click\' value=\'Y\'>\n   \n\n\n\n\t</form>\n\t</center>\n\t<script language=\'javascript\'>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t//callRecClinicalNotesSearch(); // commented as part of PE\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t//callRecClinicalNotesMain(); // commented as part of PE\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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
 request.setCharacterEncoding("UTF-8"); 
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	String	editor_reqd_yn		=	"",		function_id			=	"";
	String	style_visibility	=	"",		error_docs_exists	=	"";
	String	operation_mode		=	"",		align_property		=	"LEFT";
	String	query_string		=	"";

	editor_reqd_yn			=	(request.getParameter("editor_reqd_yn")==null)	?	"Y"	:	request.getParameter("editor_reqd_yn");
	function_id				=	(request.getParameter("function_id")==null)	?	""	:	request.getParameter("function_id");
	error_docs_exists		=	(request.getParameter("error_docs_exists")==null)	?	""	:	request.getParameter("error_docs_exists");
	operation_mode			=	(request.getParameter("operation_mode")==null)	?	""	:	request.getParameter("operation_mode");

	query_string			=	(request.getQueryString()==null)	?	""	:	request.getQueryString();
	if( function_id.equals("DISCHARGE_SUMMARY") || function_id.equals("NOTIFIABLE_FORM")|| function_id.equals("SPCL_NOTE") )//commented for relaxing the user to record any number of referral letters
	{
		style_visibility = " style='visibility:hidden' ";
		if(error_docs_exists.equalsIgnoreCase("true")) align_property = "RIGHT";
	}
	if( function_id.equals("SIGN_NOTES") || function_id.equals("REVIEW_NOTES") )
	{
		style_visibility = " style=visibility:hidden ";
	}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(align_property));
            _bw.write(_wl_block11Bytes, _wl_block11);

			if(error_docs_exists.equalsIgnoreCase("true"))
			{
		
            _bw.write(_wl_block12Bytes, _wl_block12);

			}
			
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(editor_reqd_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getParameter("patient_id")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block18Bytes, _wl_block18);

		String callback_mode = "";
		callback_mode	=	(request.getParameter("callback_mode")==null)? "" : request.getParameter("callback_mode");
		if(callback_mode.equals("Search"))
		{
	
            _bw.write(_wl_block19Bytes, _wl_block19);

		}
		else if(callback_mode.equals("Add"))
		{
	
            _bw.write(_wl_block20Bytes, _wl_block20);

		}
	
            _bw.write(_wl_block21Bytes, _wl_block21);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisTabs.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
