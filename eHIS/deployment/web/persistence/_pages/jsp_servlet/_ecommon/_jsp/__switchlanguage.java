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

public final class __switchlanguage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/SwitchLanguage.jsp", 1742203221423L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n    <script src=\"../js/common.js\" language=\"javascript\"></script>\n\n<SCRIPT LANGUAGE=\"JavaScript\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\nfunction apply(){\n\n\tvar contin=true;\n\tvar called_from=frames[1].document.forms[0].called_from.value;\n\n\t//if(frames[1].document.forms[0].name==\'ModifyLang_form\'){\n\n\t\tif(frames[1].document.forms[0].called_from.value==\'CA_PATIENT_CHART\'){\n\t\t\tcontin=false;\n\t\t\t\n\t\t\tvar warn_msg=getMessage(\"LANG_SWITCH_REL_CHRT\",\"SM\");\n\n\t\t\tif(window.confirm(warn_msg)){\n\t\t\t\tcontin=true;\n\t\t\t}\n\t\t}\n\t//}\n\n\tif(contin){\n\t\tvar err_msg=getMessage(\"RECORD_MODIFIED\",\"SM\");\n\t\talert(err_msg);\n\t\tf_query_add_mod.change(called_from);\n\n\t\t//top.location.href=top.location.href;\n\t\tif( frames[1].document.forms[0].called_from.value!=\'CA_PATIENT_CHART\'){\n\n\t\t\tif(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'==\'HomeSummary\'){\n\t\t\t\ttop.frames[0].location.href=top.frames[0].location.href;\n\t\t\t\ttop.frames[2].frames[0].location.href=top.frames[2].frames[0].location.href;\n\t\t\t\ttop.frames[2].frames[1].location.href=top.frames[2].frames[1].location.href;\n\n\t\t\t}else{\n\t\t\t\ttop.location.href=top.location.href;\n\t\t\t}\n\t\t\t\n\t\t}else{\n\t\t\twindow.returnValue =\'Success\';\n\t\t\twindow.close();\n\t\t}\n\t}  \n}\nfunction reset(){\n\t\nf_query_add_mod.document.ModifyLang_form.reset();\n\n} \n</SCRIPT>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\n\t<script language=\'javascript\' src=\'../js/FreqAccessFunc.js\'></script>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<title>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</title>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</head>\n\t<meta HTTP-EQUIV=\"content-type\" CONTENT=\"text/html; charset=UTF-8\">\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<frameset rows=\'20,*,50\'>\n\t\t\t\t\t<frame id=\'commontoolbarFrame\'  name=\'commontoolbarFrame\'\tsrc=\"../../eCommon/html/blank.html\" frameborder=0 scrolling=\'no\' noresize>\t\t\t\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<frameset rows=\'42,*,50\'>\n\t\t\t\t\t<frame id=\'commontoolbarFrame\'  name=\'commontoolbarFrame\'\tsrc=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" frameborder=0 scrolling=\'no\' noresize>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\n\t\t\t\t\t<frame id=\'f_query_add_mod\'  name=\'f_query_add_mod\' \tsrc=\"../../eCommon/jsp/ModifyLanguage.jsp?called_from=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" frameborder=0>\n\t\t\t\t\t<frame id=\'messageFrame\'  name=\'messageFrame\'\t\tsrc=\'error.jsp\' frameborder=0 noresize scrolling=\'auto\'>\n\t\t\t\t</frameset>\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"SWITCH_LANG_NOT_APPL\",\"Common\"));\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\n\n\n</html>\n";
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

	String persFrom=request.getParameter("persFrom")==null?"":request.getParameter("persFrom");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(persFrom));
            _bw.write(_wl_block7Bytes, _wl_block7);

          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		 String called_from = request.getParameter("CALLED_FROM")==null?"":request.getParameter("CALLED_FROM");

		 
   
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
if(called_from!=null && called_from.equals("CA_PATIENT_CHART")){
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);

	request.setCharacterEncoding("UTF-8");	
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	//out.println(url);
	//out.println("--->"+params);
	Connection con =null;
	con = ConnectionManager.getConnection(request);
	int count=0;
	PreparedStatement pstmt=null ;
	ResultSet reset=null;
	
	//out.println("--->"+called_from);

	
	

	try{
		//pstmt = con.prepareStatement("select count(*) as total from sm_language where EFF_STATUS='E' and LANGUAGE_DIRECTION !='R'");
		pstmt = con.prepareStatement("select count(*) as total from sm_language where EFF_STATUS='E'");
		reset=pstmt.executeQuery();
		if (reset != null && reset.next()) {
			count = reset.getInt("total");
		}
		if(count != 1){
            _bw.write(_wl_block13Bytes, _wl_block13);
if(called_from!=null && called_from.equals("CA_PATIENT_CHART")){
            _bw.write(_wl_block14Bytes, _wl_block14);
}else{
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block18Bytes, _wl_block18);
}else{
            _bw.write(_wl_block19Bytes, _wl_block19);
}
		if(reset !=null)
			reset.close();
		if(pstmt!=null)
			pstmt.close();
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.switchlanguage.label", java.lang.String .class,"key"));
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
