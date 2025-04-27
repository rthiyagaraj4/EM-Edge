package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __recordpatientadverseevent3 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecordPatientAdverseEvent3.jsp", 1740388196389L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head><title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n<script src=\"../../eCommon/js/messages.js\"></script>\n <script language=\'javascript\' src=\"../../eMR/js/RecordPatientAdverseEvent.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<iframe scrolling=\"no\" name=\'criteria_page\' id=\'criteria_page\' src=\'../../eMR/jsp/RecordPatientAdverseEvent12.jsp?allergen=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&react_val=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&mode=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&flag=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&search_text=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&patient_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&adv_event_ind=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&adv_event_type=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&event_done=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&checkedRec=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&reactcode=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&oldreactionvalue_count=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' noresize frameborder=0 style=\'height:10vh;width:100vw\'></iframe>\n\t\t<iframe name=\'detailpage\' id=\'detailpage\' src=\'../../eMR/jsp/RecordPatientAdverseEvent10.jsp?allergen=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&onblurRec=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' frameborder=\'0\' style=\"height:83vh; width:100vw; overflow-x:hidden;overflow-y: visible;\" noresize></iframe>\n\t\t<iframe scrolling=\"no\" name=\'viewdetailpage\' id=\'viewdetailpage\' src=\'../../eMR/jsp/RecordPatientAdverseEvent11.jsp?react_val=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&oth_reaction=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&reaction_date=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' noresize frameborder=0 style=\'height:8vh;width:100vw\'></iframe>\n</html>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String allergen=request.getParameter("allergen")==null?"":request.getParameter("allergen");
	String react_val=request.getParameter("react_val")==null?"":request.getParameter("react_val");
	String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	String flag=request.getParameter("flag")==null?"":request.getParameter("flag");
	String search_text=request.getParameter("search_text")==null?"":request.getParameter("search_text");
	String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String adv_event_ind=request.getParameter("adv_event_ind")==null?"":request.getParameter("adv_event_ind");
	String adv_event_type=request.getParameter("adv_event_type")==null?"":request.getParameter("adv_event_type");
	String oth_reaction=request.getParameter("oth_reaction")==null?"":request.getParameter("oth_reaction");
	String event_done=request.getParameter("event_done")==null?"":request.getParameter("event_done");
	String reaction_date=request.getParameter("reaction_date")==null?"":request.getParameter("reaction_date");
	String reactCodes3=request.getParameter("reactCodes3")==null?"":request.getParameter("reactCodes3");
	String onblurRec=request.getParameter("onblurRec")==null?"N":request.getParameter("onblurRec");
	 /*Avoid the Duplicate Reaction code added by Senthil on 12-08-2011*/
	String reactcode=request.getParameter("reactcode")==null?"":request.getParameter("reactcode");	
	String oldreactionvalue_count=request.getParameter("oldreactionvalue_count")==null?"":request.getParameter("oldreactionvalue_count");
	

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(allergen));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(react_val));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(search_text));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(adv_event_ind));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(adv_event_type));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(event_done));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(reactCodes3));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(reactcode));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oldreactionvalue_count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(allergen));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(react_val));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(search_text));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(adv_event_ind));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(adv_event_type));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(event_done));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(reactCodes3));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(onblurRec));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(react_val));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(oth_reaction));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(event_done));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(reaction_date));
            _bw.write(_wl_block26Bytes, _wl_block26);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ReactionSearch.label", java.lang.String .class,"key"));
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
