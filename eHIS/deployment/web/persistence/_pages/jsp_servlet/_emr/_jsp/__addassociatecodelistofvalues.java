package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __addassociatecodelistofvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AddAssociateCodeListOfValues.jsp", 1709118859688L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n<SCRIPT LANGUAGE=\"JavaScript\">\n<!--\nfunction showDetails(currConVals)\n{\n\t\n\t//parent.AddAssociateCodeAddModifyFrame.location.href = \"../../eCA/jsp/AddAssociateCodeAddModify.jsp?code_indicator=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&diag_desc=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&title=\"+encodeURIComponent(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')+\"&p_diag_code=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&p_diag_scheme_desc=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&Encounter_Id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&p_auth_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&cause_indicator=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&Age=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&Sex=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&Dob=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&p_scheme=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&diag_code=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&currConVals=\" + currConVals + \"&convals=\" + document.form1.convals.value + \"&mode=modify\";\t\n\t\n\tparent.AddAssociateCodeAddModifyFrame.location.href = \"../../eMR/jsp/AddAssociateCodeAddModify.jsp?code_indicator=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&currConVals=\" + currConVals + \"&convals=\" + document.form1.convals.value + \"&mode=modify&term_set_id=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\t\n}\n//-->\n</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<BODY  class=\'CONTENT\' onKeyDown = \'lockKey()\'>\n<form name=\"form1\" id=\"form1\">\n\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<tr>\n\t\t\t<th>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t</th>\n\t\t\t<th>\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t</th>\n\t\t</tr>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t</table>\n\t<input type=\"hidden\" name=\"convals\" id=\"convals\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n</form>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);

	
	String code_indicator  = request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator");
	String diag_desc  = request.getParameter("diag_desc")==null?"":request.getParameter("diag_desc");
	String title  = request.getParameter("title")==null?"":request.getParameter("title");
	String p_diag_code  = request.getParameter("p_diag_code")==null?"":request.getParameter("p_diag_code");
	String p_diag_scheme_desc  = request.getParameter("p_diag_scheme_desc")==null?"":request.getParameter("p_diag_scheme_desc");
	String Encounter_Id  = request.getParameter("Encounter_Id")==null?"":request.getParameter("Encounter_Id");
	String p_auth_yn  = request.getParameter("p_auth_yn")==null?"":request.getParameter("p_auth_yn");
	String cause_indicator  = request.getParameter("cause_indicator")==null?"":request.getParameter("cause_indicator");
	String Age  = request.getParameter("Age")==null?"":request.getParameter("Age");
	String Sex  = request.getParameter("Sex")==null?"":request.getParameter("Sex");
	String Dob  = request.getParameter("Dob")==null?"":request.getParameter("Dob");
	String p_scheme  = request.getParameter("p_scheme")==null?"":request.getParameter("p_scheme");
	String diag_code  = request.getParameter("diag_code")==null?"":request.getParameter("diag_code");
	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	String convals  = request.getParameter("convals")==null?"":request.getParameter("convals");
	String associate_codes  = request.getParameter("associate_codes")==null?"":request.getParameter("associate_codes");
	
	if(!associate_codes.equals(""))
	convals = associate_codes;

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(title));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_diag_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_diag_scheme_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_auth_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(cause_indicator));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Age));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_scheme));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(code_indicator));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(title));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_diag_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_diag_scheme_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_auth_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(cause_indicator));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Age));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_scheme));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);


String code = "";
String desc ="";
String splitvals = "";
String classval ="";
int i= 0;
String longdesc="";	

StringTokenizer str1 = new StringTokenizer(convals, "|");
	{
		if(!convals.equals(""))
		{
			while(str1.hasMoreTokens())
			{
				splitvals = str1.nextToken();
				StringTokenizer str2 = new StringTokenizer(splitvals,"~");
				while(str2.hasMoreTokens())
				{
					code = java.net.URLDecoder.decode((String)str2.nextToken());
					desc = java.net.URLDecoder.decode((String)str2.nextToken());
					if(str2.hasMoreTokens())
						longdesc= java.net.URLDecoder.decode((String)str2.nextToken());
				}
				
				if(i%2 == 0)
					classval = "QRYODD";
				else
					classval = "QRYEVEN";
				out.println("<tr><td class='"+classval+"' > <a href=javascript:showDetails(\"" + java.net.URLEncoder.encode(code + "~" + desc) + "\")>" + code+ "</td>");
				out.println("<td class='"+classval+"' >" + desc+ "</td></tr>");
				i++;				
			}
		}
	}

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(convals));
            _bw.write(_wl_block27Bytes, _wl_block27);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DiagnosisCode.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DiagnosisDescription.label", java.lang.String .class,"key"));
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
