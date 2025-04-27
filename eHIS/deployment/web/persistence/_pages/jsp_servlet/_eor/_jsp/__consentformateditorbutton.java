package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __consentformateditorbutton extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ConsentFormatEditorButton.jsp", 1722340730000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n\t\t<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/>\n\t\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t<script language=\"Javascript\" src=\"../../eOR/js/ConsentFormat.js\"></script>\n\n\t\t\t<script language=\"javascript\" src=\"../../eOR/js/OrCommonFunction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n <!-- for Number validations -->\n \t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\t <form name =\"editorButtonForm\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\n\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" id=\'test\'>\n\t\t\t<tr>\n\t\t\t\t<td>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td colspan=\"3\" class=\'fields\'>\n\t\t\t\t\t<textarea rows=\"0\" cols=\"25\" name=\"RTEText\" id=\"RTEText\" style=\"visibility:hidden\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</textarea>\n\t\t\t\t</td>\n\t\t\t</tr>\n \t\t\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n  \t\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t<input type=\"hidden\" name=\"consent_type\" id=\"consent_type\"\n\t\t\tvalue=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n  \t\t\t<input type=\"hidden\" name=\"consent_form_id\" id=\"consent_form_id\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t<input type=\"hidden\" name=\"consent_form_label\" id=\"consent_form_label\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t<input type=\"hidden\" name=\"consent_format\" id=\"consent_format\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t<input type=\"hidden\" name=\"effective_status\" id=\"effective_status\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t<input type=\"hidden\" name=\"indexed\" id=\"indexed\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t<!--<input type=\"hidden\" name=\"table_count\" id=\"table_count\" value=\"\">--><!--will be set dynamically when table has been created-->\n\t\t<!--\t<Script>setTimeout(\"setEditorTemplate()\",200);</script> --> <!-- commented for ML-MMOH-SCF-0371 [IN059763] -->\n\t\t\t<Script>setTimeout(\"setEditorTemplate()\",";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =");</script> <!-- ML-MMOH-SCF-0371 [IN059763] -->\n \t\t</table>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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

/*
---------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------
23/03/2016	IN059763		Karthi L										Unable to view the Consent details after configured it.[ML-MMOH-SCF-0371]
---------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	 
	 String bean_id = request.getParameter( "bean_id" ) ;
	 String bean_name = request.getParameter( "bean_name" ) ;
 	 ConsentFormat bean  = (ConsentFormat)getBeanObject( bean_id, bean_name ,request) ;
	 bean.setLanguageId(localeName);
	 int time_interval = 0;
	 time_interval = bean.getTimeInterval();

            _bw.write(_wl_block11Bytes, _wl_block11);
            {java.lang.String __page ="EditorButton.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean.getConsentValues()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(request.getParameter("mode")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(request.getParameter("function_id")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(request.getParameter("consent_type")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(request.getParameter("consent_form_id")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(request.getParameter("consent_form_label")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(request.getParameter("consent_format")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(request.getParameter("effective_status")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(request.getParameter("indexed")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(time_interval));
            _bw.write(_wl_block25Bytes, _wl_block25);

		// NO NEED FOR setting it for persistence
		//putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block26Bytes, _wl_block26);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Editor.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
