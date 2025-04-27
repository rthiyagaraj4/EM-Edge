package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCA.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __camenstrualhistdtltop extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAMenstrualHistDtlTop.jsp", 1742180254550L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n    <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n    <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n    <script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script><script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n    <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n    <script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script>\n    <script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n    <script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n    <script language=\'javascript\' src=\'../../eCA/js/CAMenstrualHistDtlTrans.js\'></script>\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n    <form name=\'MenstrualHistDtlTopForm\' id=\'MenstrualHistDtlTopForm\'>\n        <table border=\'0\' cellspacing=\'0\' width=\'50%\'>\n            <td class=\"label\">\n                <input type=\"radio\" id=\"radio_event_L\" name=\"radio_event\" id=\"radio_event\" onclick=\"selectRadio(\'L\')\" \n                \t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" checked ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" disabled ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" >                ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n            </td>\n            <td class=\"label\">\n                <input type=\"radio\" id=\"radio_event_U\" name=\"radio_event\" id=\"radio_event\" onclick=\"selectRadio(\'U\')\" \n                \t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n            </td>\n            <input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n             <input type=\"hidden\" name=\"episode_id\" id=\"episode_id\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">    \n             <input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">    \n            <input type=\"hidden\" name=\"option_id\" id=\"option_id\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">    \n            <input type=\"hidden\" name=\"selectedValue\" id=\"selectedValue\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"> \n\t\t\t<input type=\"hidden\" id=\"called_form\" name=\"called_form\" id=\"called_form\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" />\n\t\t\t<input type=\"hidden\" id=\"function_id\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" />\n\t\t\t<input type=\"hidden\" id=\"finalize_yn\" name=\"finalize_yn\" id=\"finalize_yn\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" />\n\t\t\t<input type=\"hidden\" id=\"module_id\" name=\"module_id\" id=\"module_id\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" />\n\t\t\t\t\t<input type=\"hidden\" id=\"multibirthvalue\" name=\"multibirthvalue\" id=\"multibirthvalue\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" />\n\t\t\n            \n        </table>    \n    </form>    \n</body>\n</html>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );
	
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
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");

/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
29/04/2024     58928	     Krishna pranay	         30/04/204         Ramesh Goli       	ML-MMOH-CRF-1759.2
01/10/2024     68508     krishna pranay             13/10/2024  Ashwini Ragupathi  ML-MMOH-CRF-1759							
--------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);

    String locale = ((String)session.getAttribute("LOCALE"));
    String sStyle =
    (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? 
    (String)session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
    
    request.setCharacterEncoding("UTF-8");
    request = new XSSRequestWrapper(request); //MOHE-SCF-0153
    response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    
    String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
    String option_id = request.getParameter("option_id") == null ? "" : request.getParameter("option_id");
	String episode_id = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
	String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
    String facility_id=(String) session.getValue("facility_id");
	String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
	String module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
	String multibirthvalue = request.getParameter("multibirthvalue") == null ? "" : request.getParameter("multibirthvalue");


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

    String eventStatus = "";
    boolean shouldCheckLastMenstrualPeriod = false; // Flag for checking the radio button
    boolean shouldCheckUnsureOfDate = false; // New flag for UnsureOfDate radio button
    String ca_bean_id = "@CAMenstrualHistDtlTransBean";
    String ca_bean_name = "eCA.CAMenstrualHistDtlTransBean";
    CAMenstrualHistDtlTransBean bean = (CAMenstrualHistDtlTransBean)getBeanObject(ca_bean_id, ca_bean_name, request);
    ArrayList resArray = bean.getPatientMenstrualHistory(patient_id);
    boolean disableLastMenstrualPeriod = false;
    boolean disableUnsureOfDate = false;
    String mode1 = request.getParameter("mode1") == null ? "" : request.getParameter("mode1");
    String selectedValue = request.getParameter("selectedValue") == null ? "" : request.getParameter("selectedValue");
	String called_form = request.getParameter("called_form") == null ? "" : request.getParameter("called_form");
	String finalize_yn = request.getParameter("finalize_yn") == null ? "" : request.getParameter("finalize_yn");

	
	  boolean disableRadioButtons = false;
	
	if (mode1.equals("modify")) {
        // If mode is "modify", select the radio based on selectedValue
        if ("L".equals(selectedValue)) {
            shouldCheckLastMenstrualPeriod = true;
            disableUnsureOfDate = true;
        } else if ("U".equals(selectedValue)) {
            shouldCheckUnsureOfDate = true;
            disableLastMenstrualPeriod = true;
        }
    } else {
        // This code executes if mode is NOT "modify"
        if (resArray.size() > 0) {
            for (int i = 0; i < resArray.size(); i++) {
                String[] record = (String[]) resArray.get(i);
              
                eventStatus = CommonBean.checkForNull(record[14]);
              String  delivery_miscarrage_type = CommonBean.checkForNull(record[9]);
              String  delivery_miscarrage_date = CommonBean.checkForNull(record[10]);

              if ("C".equals(eventStatus) && (("Y".equals(multibirthvalue) && "N".equals(finalize_yn) && "MAINTAIN_BIRTH".equals(module_id)) || ("MAINTAIN_BIRTH".equals(module_id) && "Y".equals(finalize_yn)))) {

            	  disableRadioButtons = true;
       	        shouldCheckLastMenstrualPeriod = false;
       	        shouldCheckUnsureOfDate = false;
              
              }

                // If any event status is Active, do not check the radio button by default
                if ("A".equals(eventStatus) && delivery_miscarrage_type.equals("") && delivery_miscarrage_date.equals("")) {
                    shouldCheckLastMenstrualPeriod = false; // Don't check by default
                }
                else
                {
                	 shouldCheckLastMenstrualPeriod = true; // Don't check by default
                }
            }
        } else {
            // No records means the radio button should be checked by default
            shouldCheckLastMenstrualPeriod = true;
        }
    }

            _bw.write(_wl_block7Bytes, _wl_block7);
 if (shouldCheckLastMenstrualPeriod && !disableRadioButtons) { 
            _bw.write(_wl_block8Bytes, _wl_block8);
 } 
            _bw.write(_wl_block9Bytes, _wl_block9);
 if (disableLastMenstrualPeriod || disableRadioButtons) { 
            _bw.write(_wl_block10Bytes, _wl_block10);
 } 
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
 if (shouldCheckUnsureOfDate && !disableRadioButtons) { 
            _bw.write(_wl_block8Bytes, _wl_block8);
 } 
            _bw.write(_wl_block9Bytes, _wl_block9);
 if (disableUnsureOfDate || disableRadioButtons) { 
            _bw.write(_wl_block10Bytes, _wl_block10);
 } 
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( episode_id ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( encounter_id ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( option_id ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( selectedValue ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_form));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(finalize_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(multibirthvalue));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.LastMenstrualPeriod.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.UnsureOfDate.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
