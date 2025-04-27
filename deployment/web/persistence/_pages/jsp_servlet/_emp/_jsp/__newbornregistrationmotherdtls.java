package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import com.ehis.util.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;
import org.json.simple.*;

public final class __newbornregistrationmotherdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/NewbornRegistrationMotherDtls.jsp", 1742180743286L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="  \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<tr>\n<td class=\'label\' height=\"25\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" </td>\n<td class=\'QUERYDATA\' height=\"25\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&nbsp;</td>\n<td class=\'label\' height=\"25\"></td>\n<td class=\'label\' height=\"25\" nowrap><a name=\'ViewPatChartSummary\'   href=\"javascript:showPatChartSummary(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\',\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\');\"><B>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</B></a></td>\n</td>\n</tr>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<tr>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<td class=\'label\' height=\"25\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;</td>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<td class=\'label\' height=\"25\"></td>\n<td class=\'label\' height=\"25\"></td>\n<td class=\'label\' height=\"25\"></td>\n<td class=\'label\' height=\"25\" nowrap><a name=\'ViewPatChartSummary\'   href=\"javascript:showPatChartSummary(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<input type=\'hidden\' name=\'mother_pmi_no\' id=\'mother_pmi_no\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type=\'hidden\' name=\'invoked_from\' id=\'invoked_from\' value = \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n<input type=\'hidden\' name=\'race_required_yn\' id=\'race_required_yn\' value = \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n<input type = \'hidden\' name =\'alt_id_type_desc\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block0Bytes, _wl_block0);

request.setCharacterEncoding("UTF-8");
Properties p		= (java.util.Properties) session.getValue("jdbc");
String accept_national_id_no_yn			= checkForNull(request.getParameter("accept_national_id_no_yn"));
String mthr_nat_id_no			= checkForNull(request.getParameter("mthr_nat_id_no"));
String cd3			= checkForNull(request.getParameter("cd3"));
if(cd3.equals("")) cd3 = "National ID No";
String accept_oth_alt_id_yn			= checkForNull(request.getParameter("accept_oth_alt_id_yn"));
String mthr_oth_alt_id_No			= checkForNull(request.getParameter("mthr_oth_alt_id_No"));
String mthr_alt_id1_no			= checkForNull(request.getParameter("mthr_alt_id1_no"));
String alt_id1_type_desc			= checkForNull(request.getParameter("alt_id1_type_desc"));
String mthr_alt_id2_no			= checkForNull(request.getParameter("mthr_alt_id2_no"));
String alt_id2_type_desc			= checkForNull(request.getParameter("alt_id2_type_desc"));
String mthr_alt_id3_no			= checkForNull(request.getParameter("mthr_alt_id3_no"));
String alt_id3_type_desc			= checkForNull(request.getParameter("alt_id3_type_desc"));
String mthr_alt_id4_no			= checkForNull(request.getParameter("mthr_alt_id4_no"));
String alt_id4_type_desc			= checkForNull(request.getParameter("alt_id4_type_desc"));
String motherencounterid			= checkForNull(request.getParameter("motherencounterid"));
String mother_patient_id			= checkForNull(request.getParameter("mother_patient_id"));
String invoked_from			= checkForNull(request.getParameter("invoked_from"));
String race_required_yn			= checkForNull(request.getParameter("race_required_yn"));
String OtherAltNo			= checkForNull(request.getParameter("oth_alt_id_type"));
Map<String,String> hashMap					= new LinkedHashMap();
if(accept_national_id_no_yn.equals("Y") && !mthr_nat_id_no.equals("")){
hashMap.put(cd3,mthr_nat_id_no);
}
if(accept_oth_alt_id_yn.equals("Y") && !mthr_oth_alt_id_No.equals("")){
hashMap.put(OtherAltNo,mthr_oth_alt_id_No);
}
if(!mthr_alt_id1_no.equals("")){
hashMap.put(alt_id1_type_desc,mthr_alt_id1_no);
}
if(!mthr_alt_id2_no.equals("")){
hashMap.put(alt_id2_type_desc,mthr_alt_id2_no);
}
if(!mthr_alt_id3_no.equals("")){
hashMap.put(alt_id3_type_desc,mthr_alt_id3_no);
}
if(!mthr_alt_id4_no.equals("")){
hashMap.put(alt_id4_type_desc,mthr_alt_id4_no);
}
try{
int index=0;
for (Map.Entry<String,String> entry : hashMap.entrySet()) {
String key = entry.getKey();           
String value = entry.getValue();  
index++;
if(index == 1){

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(key));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(value));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(motherencounterid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

}
            _bw.write(_wl_block0Bytes, _wl_block0);
if(index == 2 || index == 4 || index == 6){
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block0Bytes, _wl_block0);
if(index!=1 && !value.equals("") ){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(key));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(value));
            _bw.write(_wl_block13Bytes, _wl_block13);
} if(index == 3 || index == 5 || index == 6){
            _bw.write(_wl_block14Bytes, _wl_block14);
}}
if(hashMap.isEmpty()){

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(motherencounterid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(mother_patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(mthr_alt_id1_no));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(invoked_from));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(race_required_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(alt_id1_type_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
}catch(Exception e){e.printStackTrace();
}finally{} 
            _bw.write(_wl_block0Bytes, _wl_block0);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ViewPatChartSummary.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ViewPatChartSummary.label", java.lang.String .class,"key"));
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
