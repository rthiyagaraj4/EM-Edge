package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __orderentryframeset extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryFrameSet.jsp", 1737634244000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n11/09/2013   IN043253\t Chowminya\tTicksheet has more than 5 sections in it, the 6th section onwards displays below and it is hidden\n30/07/2020\t IN073551\t Nijitha\t30/07/2020\tRamesh G \tMMS-KH-SCF-0092\n-----------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head><title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/></link>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryPreview.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n \t\t\t<!-- <frameset cols=\"50%,50%\" framespacing=0 name=\"OrderEntryFrameset\"> -->\n\t\t\t\t<iframe name=\"criteriaMainFrame\" id=\"criteriaMainFrame\" src= \"../../eOR/jsp/OrderEntryRecentlyFrameSet.jsp?search_by=practitioner&";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"no\" style=\'height:30vh;width:99vw\'></iframe>\n\t\t\t\t<iframe name=\"criteriaDetailFrame\" id=\"criteriaDetailFrame\" src= \"../../eOR/jsp/OrderEntryRecentlyFrameSet.jsp?search_by=patient&";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"no\" style=\'height:56vh;width:99vw\'></iframe>\n\t\t\t<!-- </frameset> -->\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<script>alert(getMessage(\"FREQUENT_NOT_SELECT\",\"COMMON\"));</script>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" \n \n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<!-- \t<frameset rows=\"30%,*,0\" framespacing=0 name=\"OrderEntryFrameset\"> -->\n\t\t\t<iframe name=\"criteriaMainFrame\" id=\"criteriaMainFrame\" src= \"../../eOR/jsp/OrderEntryAdditionalSearch.jsp?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"yes\" style=\'height:24vh;width:99vw\'></iframe>\n\t\t\t<iframe name=\"criteriaDetailFrame\" id=\"criteriaDetailFrame\" src= \"../../eCommon/html/blank.html\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"yes\" style=\'height:70vh;width:99vw\'></iframe>\n\t\t\t<iframe name=\"orderTypeLookUpFrame\"  id=\"orderTypeLookUpFrame\" \tsrc= \"../../eCommon/html/blank.html\" framespacing=\"0\"\t \tnoresize frameborder=\"0\"  scrolling=\"yes\" style=\'height:0vh;width:100vw\'></iframe>\n\t<!-- \t</frameset> -->\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<!-- \t<frameset rows=\"22%,6%,*\" framespacing=0 name=\"OrderEntryFrameset\"> -->\n\t\t\t<iframe name=\"criteriaMainFrame\" id=\"criteriaMainFrame\" src= \"../../eOR/jsp/OrderEntryTickSheets.jsp?";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"no\" style=\'height:30vh;width:99vw\'></iframe>\n\t\t\t<iframe name=\"criteriaDetailFrame\"  id=\"criteriaDetailFrame\" src= \"../../eCommon/html/blank.html\" framespacing=\"0\" noresize frameborder=\"0\" scrolling=\"auto\" style=\'height:56vh;width:99vw\'></iframe><!-- IN043253 -->\n\t\t\t<iframe name=\"criteriaTickSheetsFrame\" id=\"criteriaTickSheetsFrame\" src= \"../../eCommon/html/blank.html\" framespacing=\"0\" noresize frameborder=\"0\" style=\'height:72vh;width:100vw\'></iframe>\n\t\t<!-- </frameset> -->\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<!-- <frameset rows=\"35%,*,7%\" framespacing=0 name=\"OrderEntryFrameset\">-->\n\t\t\t<iframe name=\"criteriaMainFrame\" id=\"criteriaMainFrame\" src= \"../../eOR/jsp/OrderEntryCareSetSearch.jsp?";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"no\" style=\'height:30vh;width:99vw\'></iframe>\n\t\t\t<iframe name=\"criteriaDetailFrame\" id=\"criteriaDetailFrame\" src= \"../../eCommon/html/blank.html\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"auto\" style=\'height:56vh;width:99vw\'></iframe>\n\t\t\t<iframe name=\"criteriaButtonFrame\"   id=\"criteriaButtonFrame\" src= \"../../eCommon/html/blank.html\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"no\" style=\'height:53vh;width:99vw\'></iframe>\n\t<!--  \t</frameset>-->\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n\t\t<!-- <frameset rows=\"7%,*\" framespacing=0 name=\"OrderEntryFrameset\"> -->\n\t\t\t<iframe name=\"criteriaCategoryButtonFrame\" id=\"criteriaCategoryButtonFrame\" src= \"../../eOR/jsp/OrderEntryCategoryButtons.jsp?";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"no\" style=\'height:6vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\"criteriaPlaceOrderFrame\"  id=\"criteriaPlaceOrderFrame\" src= \"../../eCommon/html/blank.html\" framespacing=\"0\" noresize frameborder=\"0\"  scrolling=\"no\" style=\'height:92vh;width:100vw\'></iframe>\n\t\t<!-- </frameset>-->\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n</html>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
     
	//out.println("<script>alert('additional OrderEntryFrameSet"+request.getQueryString()+"');</script>");
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String  tab_name 			= request.getParameter("tab_name");
	if(tab_name == null || tab_name.equals("")) tab_name = "";
	String ammend_called_from	= request.getParameter("ammend_called_from");
	String function_from = request.getParameter("function_from");//IN073551
	if(ammend_called_from == null || ammend_called_from.equals("")) ammend_called_from = "";
	String called_from			= request.getParameter("called_from"); // Parameter is passed from OrderEntryCommonTabs.jsp
	String licence_key			= request.getParameter("licence_key"); // Parameter is passed from OrderEntryCommonTabs.jsp
	if(called_from == null || called_from.equals("")) called_from = "";
	if(licence_key == null || licence_key.equals("")) licence_key = "";
	if(ammend_called_from.equalsIgnoreCase("existing_order") && tab_name.equals(""))
		tab_name				 = "PlaceOrder";
	else if(licence_key.equals("ORPV") && called_from.equals("ON_LOAD") && tab_name.equals(""))
		tab_name				 = "PlaceOrder";	//If it Pharmacy Version for Alrabha
	else if("HIGH_RISK_ASSESS".equals(function_from))//IN073551
		tab_name				 = "PlaceOrder";//IN073551
		

	String frequent_orders_allowed_yn	= "N";  // Remove this variable and reference later, when frequent order is given


 	if(tab_name.equals("") || tab_name.equals("FrequentOrders") && frequent_orders_allowed_yn.equals("Y"))
	{
		if(!ammend_called_from.equalsIgnoreCase("existing_order"))
		{

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block12Bytes, _wl_block12);
		}  else { 
            _bw.write(_wl_block13Bytes, _wl_block13);
		} 
            _bw.write(_wl_block14Bytes, _wl_block14);
	} else if(tab_name.equals("") || tab_name.equals("AdditionalSearch"))
	{ //out.println("<script>alert('frameset"+request.getQueryString()+"');</script>");

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block16Bytes, _wl_block16);
	} else if(tab_name.equals("TickSheet")){ 
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block18Bytes, _wl_block18);
	} else if(tab_name.equals("CareSet")){ 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block20Bytes, _wl_block20);
	} else if(tab_name.equals("")  || tab_name.equals("PlaceOrder")){ 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block22Bytes, _wl_block22);
	} 
            _bw.write(_wl_block23Bytes, _wl_block23);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderEntryResultMain.label", java.lang.String .class,"key"));
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
