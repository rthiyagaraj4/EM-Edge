package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __changepatientdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ChangePatientDetails.jsp", 1732272022128L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<html>\n\t\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration.js\'></Script>\n\t\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration1.js\'></Script>\n\t\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration2.js\'></Script>\n\t\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration3.js\'></Script>\n\t\t<Script language=\'javascript\' src=\'../../eMP/js/ChangePatientDetails.js\'></Script>\n\t\t<Script src=\"../../eCommon/js/DateUtils.js\" language=\"JavaScript\"></Script>\n\t\t<Script language=\"JavaScript\"src=\"../../eCommon/js/common.js\" ></Script>\n\n\n\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t</head>\n\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'    src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" frameborder=\'0\' scrolling=\'no\' noresize style=\'height:7vh;width:100vw\'></iframe>\n\t\t\t<!-- <iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" frameborder=\'0\'  scrolling=\'auto\' style=\'height:83vh;width:100vw\'></iframe> -->\n\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" frameborder=\'0\'  scrolling=\'no\' style=\'height: 85vh;width:99vw\'></iframe>\n\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=\'0\' noresize scrolling=\'auto\' style=\'height:8vh;width:100vw\'></iframe>\n\t\t</html>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	int step = Integer.parseInt( request.getParameter("step")==null?"1":request.getParameter("step") );
	
	String file_name	= "../../eMP/jsp/blank.jsp?step_1=5 ";

	String patient_id	= request.getParameter("Patient_ID");
	if(patient_id == null) patient_id = "" ;

	String function_id	= request.getParameter("function_id");
	if(function_id == null)function_id = "" ;
	String home_required_yn	= request.getParameter("home_required_yn" ) ;
	if (home_required_yn == null) home_required_yn ="";
	String parent_details	= request.getParameter("parent_details") ;
	if(parent_details == null) parent_details = "" ;

	String multi_birth					=  request.getParameter("multi_birth" )== null ? "" : request.getParameter("multi_birth");
	String nb_birth_place_code	= request.getParameter("nb_birth_place_code") == null ? "" : request.getParameter("nb_birth_place_code");
	String nb_birth_place_desc	= request.getParameter("nb_birth_place_desc") == null ? "" : request.getParameter("nb_birth_place_desc");

	String mother_patient_id	=  request.getParameter("mother_patient_id" ) ;
	if(mother_patient_id == null) mother_patient_id = "";
	
	//Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1
	String load_tab = request.getParameter("load_tab");
	if(load_tab == null) load_tab = "";

	String called_from_newborn = request.getParameter("called_from_newborn")==null?"N":request.getParameter("called_from_newborn");
	String noOfBirths = request.getParameter("noOfBirths");
	if(noOfBirths == null) noOfBirths = ""; 
	String numOfbaby = request.getParameter("numOfbaby");
	if(numOfbaby == null) numOfbaby = "";
	//addition ends here.
	
	if(!patient_id.equals("") && step == 1) 
	{ 
		file_name = "ChangePatientDetails.jsp?step=2&Patient_ID="+java.net.URLEncoder.encode(patient_id)+"&multi_birth="+multi_birth+"&mother_patient_id="+mother_patient_id+"&function_id="+function_id+"&parent_details="+java.net.URLEncoder.encode(parent_details)+"&numOfbaby="+numOfbaby+"&noOfBirths="+noOfBirths+"&load_tab="+load_tab+"&called_from_newborn="+called_from_newborn+"&nb_birth_place_code="+nb_birth_place_code+"&nb_birth_place_desc="+nb_birth_place_desc;
	}
	
	if(step == 1) 
	{  
		
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

			String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
			String params = request.getQueryString() ;
			String source = url + params ;
			
			if(!function_id.equals("CHG_PAT_DTLS")&&!function_id.equals(""))
				source = "../../eMP/jsp/ChangepatdocsToolBar.jsp";
			
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(source));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(file_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(file_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
 
	}
	else if(step == 2) 
	{ 		
		out.println("<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><iframe name='patient_main' id='patient_main'   src='../../eMP/jsp/ChangePatientHeader.jsp?patient_id="+java.net.URLEncoder.encode(patient_id)+"&function_id="+function_id+"' frameborder=0 scrolling='no' noresize style='height:12vh;width:100vw'></iframe><iframe name='patient_sub' id='patient_sub' src='../../eMP/jsp/ChangePatientSub.jsp?patient_id="+java.net.URLEncoder.encode(patient_id)+"&multi_birth="+multi_birth+"&mother_patient_id="+mother_patient_id+"&function_id="+function_id+"&parent_details="+java.net.URLEncoder.encode(parent_details)+"&numOfbaby="+numOfbaby+"&called_from_newborn="+called_from_newborn+"&noOfBirths="+noOfBirths+"&load_tab="+load_tab+"&nb_birth_place_code="+nb_birth_place_code+"&nb_birth_place_desc="+nb_birth_place_desc+"' frameborder=0 scrolling='auto' noresize style='height:87vh;width:100vw'></iframe>"); 
	}

            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ChgPatDtl.title.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
