package jsp_servlet._ecommon._jsp;

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

public final class __modifylanguage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/ModifyLanguage.jsp", 1742195902540L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/ecommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n    <script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\n\n<script >\n\n\nfunction change(called_from)\n{\n\n\n\tvar switchlang = document.ModifyLang_form.switch_lang.value;\n\tvar cssName = document.ModifyLang_form.cssName.value;\n\t/* var xmlDoc= new ActiveXObject( \"Microsoft.XMLDom\" ) ;\n\tvar xmlHttp= new ActiveXObject( \"Microsoft.XMLHTTP\" ) ; */\n\tvar xmlDoc = \"\"; \n\tvar xmlHttp = new XMLHttpRequest();\n\t\n\txmlStr\t=\"<root></root>\" ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open( \"POST\", \"UpdateLang.jsp?language_id=\"+switchlang+\"&called_from=\"+called_from+\"&cssName=\"+cssName,false);\n\txmlHttp.send( xmlDoc ) ;\n\tresponseText=xmlHttp.responseText;\n\tresponseText = trimString(responseText)\n\t//alert(responseText);\n\n\t//if(document.forms[0].called_from.value=\'CA_PATIENT_CHART\'){\n\t\t//window.close();\n\t\t//retval=\'Success\';\n\t//}\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onKeyDown = \'lockKey()\' onload=\"disab()\" >\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<form name=\"ModifyLang_form\" id=\"ModifyLang_form\" >\n\n<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>\n<center>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"50%\" align=\'center\'>\n<tr><td class=\"NONE\" width=\"100%\">\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\n<tr>\n\t\t\t\t<td COLSPAN=2>&nbsp; </td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td align=\"right\" class=\"label\" nowrap>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" &nbsp;&nbsp;</td>\n\t\t\t <td align=\"left\"  id=\"curlang\" class=\"data\" nowrap>&nbsp;&nbsp; </td>\n\t\t\t</tr>\n\n\t\t\t<tr></tr>\n\n\t\t\t<tr>\n\t\t\t<!--td>&nbsp; </td-->\n\t\t\t\t<td class=\"label\" align=\"right\" nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" &nbsp;&nbsp;</td>\n\t\t\t\t<td  align=\"left\"  nowrap><select name=\'switch_lang\' id=\'switch_lang\'  >\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<OPTION VALUE=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</option>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t</select>\n\t\t\t\t\n\t\t\t<!--td>&nbsp; </td-->\n\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t   \n\t\t\t\t<td colspan=2>&nbsp;</td>\n\n\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t   \n\t\t\t\t<td colspan=2>&nbsp;</td>\n\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t   \n\t\t\t\t<td >&nbsp;</td><td align=left><input type=\"button\" value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' class=\'button\' onclick=\"sub_mit()\"><input type=\"button\" value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' class=\'button\' onclick=\"res_et()\"></td>\n\n\t\t\t</tr>\n\n\n</table>\n\n</td></tr>\n</table>\n<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<input type=\"hidden\" name=\"cssName\" id=\"cssName\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n</form>\n<script>\ndocument.getElementById(\"curlang\").innerText = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\n\n\nfunction disab(){\n\tif(parent.frames[0].document.forms[0]){\n\t\tparent.frames[0].document.forms[0].apply.style.visibility=\"hidden\";\n\t\tparent.frames[0].document.forms[0].reset.style.visibility=\"hidden\";\n\t}else{\n\t\tsetTimeout(\"disab()\",10);\n\t}\n}\n\nfunction sub_mit(){\n\tparent.apply();\n}\n\nfunction res_et(){\n\tparent.reset();\n}\n</script>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
 
	request.setCharacterEncoding("UTF-8");
	String sStyle = (String)session.getAttribute("PREFERRED_STYLE");
	sStyle= (sStyle==null?"IeStyle.css":sStyle); 
	String currlang = (String)session.getValue("LOCALE");

            _bw.write(_wl_block1Bytes, _wl_block1);


	Connection con =null;
	con = ConnectionManager.getConnection(request);

	String language_id="";
	String short_name="";
	String clang= "";
	String appl_user_id="";
	PreparedStatement pstmt=null ;
	PreparedStatement  pstmt2=null;
	PreparedStatement  pstmt3=null;
	ResultSet reset=null;
	ResultSet reset1=null;
	String called_from=request.getParameter("called_from");



	int count=0;
	

	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String cssName		= "";
	try{
		if(sStyle.contains("_bu")){
			String[] arrSplit = sStyle.split("\\.");
			cssName	= arrSplit[0];
		}else{
			cssName	= sStyle.replace(".css","");
		}

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

				try{
					//con = ConnectionManager.getConnection(request);
					//pstmt = con.prepareStatement("select language_id, short_name from sm_language where EFF_STATUS='E' and LANGUAGE_DIRECTION !='R' order by 2");
					pstmt = con.prepareStatement("select language_id, short_name from sm_language where EFF_STATUS='E'order by 2");
					
					
					reset=pstmt.executeQuery();

						if( reset != null )
						{
						   while( reset.next() )
							{
								 language_id = reset.getString( "language_id" ) ;
								 short_name=reset.getString("short_name");
								 if(language_id.equals(currlang)){

									 clang=short_name;

								 }else{
								
									
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( language_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( short_name));
            _bw.write(_wl_block13Bytes, _wl_block13);

								 }
							}
							
						}

						pstmt2 = con.prepareStatement("Update sm_appl_user set language_id=? where appl_user_id=?");
						if(reset.next()){
							pstmt2.setString(1,language_id);
							pstmt2.setString(2,appl_user_id);
							
							pstmt2.executeUpdate();
					}

					
					}catch(Exception e) {
						//out.println(e.toString());
						out.println("failed at ModifyLanguage.jsp ==>"+e.toString());
						e.printStackTrace();
					}
				/*	finally
					{
						if(con!=null) ConnectionManager.returnConnection(con,request);
					} */
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.apply.label","common_labels")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(cssName));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(clang));
            _bw.write(_wl_block19Bytes, _wl_block19);
 
if (reset != null) reset.close();
if (reset1 != null) reset1.close();
if (pstmt != null) pstmt.close();
if (pstmt2 != null) pstmt2.close();
if (pstmt3 != null) pstmt3.close();

}
catch(Exception e) { 
	out.println(e.toString());
	e.printStackTrace();
}
finally	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
		}

            _bw.write(_wl_block20Bytes, _wl_block20);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CurrentLanguage.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SelectLanguage.label", java.lang.String .class,"key"));
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
