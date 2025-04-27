package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.lang.*;
import java.util.*;
import java.lang.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __medicationadministration extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MedicationAdministration.jsp", 1739192438778L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <!--\nDeveloped by    : P.Sudhakaran.\nModule/Function : MedicationAdministration\nstart date\t\t: 17/06/2003\n-->\n";
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../js/PhCommon.js\"></script>\n\t\t<script language=\"javascript\" src=\"../js/MedicationAdministration.js\"></script>\n\t\t<script language=\"javascript\" src=\"../js/MedicationAdministrationFixedTime.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>alert(getMessage(\"PH_MED_ADMIN_NOT_APPLICABLE\",\"PH\"));history.go(-1);</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<script>\n\t   toolBarString = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"\n\t</script>\n\t<!--<frameset rows=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" name=\'MARFrameset\'>-->\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\t\t\t<iframe name=\"f_search\" id=\"f_search\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../ePH/jsp/MARSchLevelCriteria.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" style=\"height:6vh;width:100vw\"></iframe>\n\t\t\t<iframe name=\"f_query_add_mod\" id=\"f_query_add_mod\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\" style=\"height:94vh;width:100vw\"> </iframe> \n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\n\t\t\t<iframe name=\"commontoolbarFrame\" id=\"commontoolbarFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" style=\"height:5vh;width:100vw\"></iframe>\n\t\t\t<iframe name=\"f_search\" id=\"f_search\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../ePH/jsp/MedicationAdministrationSearch.jsp?";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" style=\"height:20vh;width:100vw\"></iframe>\n\t\t\t<iframe name=\"f_query_add_mod\" id=\"f_query_add_mod\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\" style=\"height:67vh;width:100vw\"></iframe> \n\t\t\t<iframe name=\"messageFrame\" id=\"messageFrame\" src=\"../../eCommon/jsp/error.jsp\" frameborder=\"0\" noresize scrolling=\"auto\" style=\"height:7vh;width:100vw\"></iframe> \n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" \n\n\n<!--- \n\t<frameset rows=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" name=\'MARFrameset\'>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\n\t\t\t<frame name=\"f_search\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../ePH/jsp/MARSchLevelCriteria.jsp?";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t<frame name=\"f_query_add_mod\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\">  \n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\n\t\t\t<frame name=\"commontoolbarFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t<frame name=\"f_search\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../ePH/jsp/MedicationAdministrationSearch.jsp?";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t<frame name=\"f_query_add_mod\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\">  \n\t\t\t<frame name=\"messageFrame\" src=\"../../eCommon/jsp/error.jsp\" frameborder=\"0\" noresize scrolling=\"auto\"> \n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t</frameset>\n\t-->\n</html>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String facility_id		= (String) session.getValue("facility_id");
	//getting the reqd values from MedicationAdministrationBean 
	String bean_id					= "MedicationAdministrationBean";
	String bean_name				= "ePH.MedicationAdministrationBean";
	MedicationAdministrationBean bean			= (MedicationAdministrationBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);
	bean.fetchParamFacilityValues(facility_id); //modified to common method to fetch Parameter for Facility settings for [IN:043283]
	String medn_admin_reqd_yn=bean.getMednAdminReqdYN();

	if(medn_admin_reqd_yn.equals("N")){

            _bw.write(_wl_block9Bytes, _wl_block9);

	}
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String function_from=request.getParameter("function_from ");
	if(function_from != null){
		function_from=function_from.trim();
	}
	else{
		function_from="";
	}
	if(function_from!=null && function_from.equals("CA")) {
		url = "../../ePH/jsp/MARHeaderForCA.jsp?" ;
	}
	String source = url + params ;
	String called_form=request.getParameter("called_from");
	String option_id=request.getParameter("option_id")==null?"":request.getParameter("option_id");
	String MAR_sch_level_yn = "N";
	HashMap hmSchMARDtl = null;
	//source=url +"access=NYNNN&call_from_ca=Y&function_name=&option_id=PH_MAR_DESKTOP&locale=en&menu_id=PH&module_id=CA&function_id=CLINICIAN_ACCESS&function_name=Clinician%20Access&function_type=F&access=NYNNN&child_window=N&limit_function_id=&chartTitle=&reln_req_yn=N&fromNewFunction=Y&limit_function_id=";
	if(option_id.equals("PH_MAR_PAT_CHART")){
		bean.setSchMARParams();
		hmSchMARDtl =(HashMap) bean.getSchMARParams();
		if(hmSchMARDtl!=null && hmSchMARDtl.size()>0)
			MAR_sch_level_yn = hmSchMARDtl.get("MAR_SCH_LEVEL_YN")==null?"":(String)hmSchMARDtl.get("MAR_SCH_LEVEL_YN");	
	}

	if(function_from!=null && function_from.equals("CA")) { 
		 source =url +"module_id=CA&function_id=PH_MED_ADMIN&function_name=Medication%20Administration&function_type=F&menu_id=PH_TRANSACTIONS&access=NYNNN";  
	}

	if(called_form!=null && called_form.equals("CA")) { 
		source = url +"module_id=PH&function_id=PH_MED_ADMIN&function_name=Medication%20Administration&function_type=F&menu_id=PH_TRANSACTIONS&access=NYNNN"; 
	}

	String call_from_ca = (request.getParameter("call_from_ca")) == null ? "" : request.getParameter("call_from_ca");
	String rows ="37,130,*,9%";

	if (call_from_ca.equals("Y")) {
		//changing CA passed querystring argument "&access=NNYNN" as "&access=NYNNN", if not passed also pass it.
		if( source.indexOf("access",source.indexOf("access")+1) != -1 ) {
			String str1=source.substring(0,source.indexOf("access",source.indexOf("access")+1));
			String str2=source.substring(source.indexOf("access",source.indexOf("access")+1));
			String str3=str2.substring(str2.indexOf("&")+1);
			source=str1+"access=NYNNN&"+str3;
		} 
		else
			source += "&access=NYNNN";
		
		if(MAR_sch_level_yn.equals("Y"))
			rows ="30,*"; //rows ="105,*,25";
		else
			rows ="27,130,*,3%";

	}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(params));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rows));
            _bw.write(_wl_block12Bytes, _wl_block12);

		if(MAR_sch_level_yn.equals("Y")){

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(params));
            _bw.write(_wl_block14Bytes, _wl_block14);

		}
		else{

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(params));
            _bw.write(_wl_block17Bytes, _wl_block17);

		}

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rows));
            _bw.write(_wl_block19Bytes, _wl_block19);

		if(MAR_sch_level_yn.equals("Y")){

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(params));
            _bw.write(_wl_block21Bytes, _wl_block21);

		}
		else{

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(params));
            _bw.write(_wl_block24Bytes, _wl_block24);

		}

            _bw.write(_wl_block25Bytes, _wl_block25);

	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
