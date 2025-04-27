package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __visitregistration extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/VisitRegistration.jsp", 1737541140336L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--    Function Name VisitRegistration\n    Created by M.Sathis Kumar on 13/12/2000 \n    resident_stay_yn\nfor that put oper_stn_yn in (\'O\', \'B\')\n    \n    -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script><!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 25th Nov 2013-->\n\n\t<!--Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1-->\n\t<script src=\'../../eXH/js/ExternalApplication.js\' language=\'Javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eOP/js/VisitRegistration.js\'></script>\n\t<script language=\'javascript\' src=\'../../eOP/js/VisitRegistrationQuery.js\'></script>\n\t<script language=\'javascript\' src=\'../../eOP/js/VisitRegistration1.js\'></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/DateUtils.js\" language=\"javascript\"></script>\n\t    <script language=\"javascript\" src=\"../../eOP/js/Checkblockscheduleforpract.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013-->\n\t\n\n\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n    </head>\n\n\t<form name=\'visit_form\' id=\'visit_form\'>\n\t\t<input type=\'hidden\' name=\'call_from\' id=\'call_from\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t</form>\n\n\n    <frameset rows=\'42,*,55\' >\n    <frame name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'  frameborder=0 scrolling=\'no\' noresize>\n    \n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="       \n           <frame name=\'f_query_add_mod\' id=\'f_query_add_mod\' id=\'visit1\' src=\'../../eOP/jsp/VisitRegistrationMain.jsp?function_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&func_source=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&query_string=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&patient=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&q_appt_ref_no=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&referral_id=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&q_clinic_code=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&q_locn_type=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&q_Appt_time=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&q_visit_adm_type=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&q_practitioner_id=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&contact_reason_code=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&reason=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&service_code=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&resource_class=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&call_from=CA\' frameborder=0 noresize scrolling=\'auto\'>\n\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\n\t\t <frame name=\'f_query_add_mod\' id=\'f_query_add_mod\' id=\'visit1\' src=\'../../eOP/jsp/VisitRegistrationMain.jsp?function_id=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' frameborder=0 noresize scrolling=\'no\'>\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\n    <frame name=\'messageFrame\' id=\'messageFrame\'  src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'no\'>\n   </frameset>\t\n   \t\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	
	String function_id=request.getParameter("function_id");
	String call_from     =(request.getParameter("call_from") == null)?"":request.getParameter("call_from");

    String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
    String params = request.getQueryString() ;
	int start_index = params.indexOf("&patient");
	if(start_index!=-1)
		params = params.substring(0,start_index);
	else
		params = params;	
		
    String source = url + params ; 
	
	//String queryStr	= params;	

	if(call_from.equals("CA"))
	{
		source = source+"&home_required_yn=N";
		//queryStr = queryStr+"&home_required_yn=N";		
	}	
	

	//session.putValue("queryString",queryStr);

	
	String patient     =(request.getParameter("patient") == null)?"":request.getParameter("patient");
	String q_appt_ref_no     =(request.getParameter("q_appt_ref_no") == null)?"":request.getParameter("q_appt_ref_no");
	String referral_id     =(request.getParameter("referral_id") == null)?"":request.getParameter("referral_id");
	String q_clinic_code     =(request.getParameter("q_clinic_code") == null)?"":request.getParameter("q_clinic_code");
	String q_visit_adm_type     =(request.getParameter("q_visit_adm_type") == null)?"":request.getParameter("q_visit_adm_type");
	String q_practitioner_id     =(request.getParameter("q_practitioner_id") == null)?"":request.getParameter("q_practitioner_id");
	String contact_reason_code =(request.getParameter("contact_reason_code") == null)?"":request.getParameter("contact_reason_code");
	String reason     =(request.getParameter("reason") == null)?"":request.getParameter("reason");	
	String service_code     =(request.getParameter("service_code") == null)?"":request.getParameter("service_code");	
	String q_locn_type     =(request.getParameter("q_locn_type") == null)?"":request.getParameter("q_locn_type");	
	String q_Appt_time     =(request.getParameter("q_Appt_time") == null)?"":request.getParameter("q_Appt_time");	
	String resource_class     =(request.getParameter("resource_class") == null)?"":request.getParameter("resource_class");


	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block11Bytes, _wl_block11);

		if(call_from.equals("CA"))
		{		 
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(params));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(params,"UTF-8")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(q_clinic_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(q_locn_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(q_Appt_time));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(q_visit_adm_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(q_practitioner_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(contact_reason_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(resource_class));
            _bw.write(_wl_block27Bytes, _wl_block27);

		}
		else
		{
	
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(params));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(params,"UTF-8")));
            _bw.write(_wl_block29Bytes, _wl_block29);

		}
	
            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RegisterVisit.label", java.lang.String .class,"key"));
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
