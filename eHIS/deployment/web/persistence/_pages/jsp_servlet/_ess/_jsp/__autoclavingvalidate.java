package jsp_servlet._ess._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eSS.Common.*;
import eSS.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __autoclavingvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/AutoclavingValidate.jsp", 1732510516319L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
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
 
/*
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name			INC Number       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------

12/11/2014				AAKH_CRF_0057			Sakti Sankar		52312											Autoclaving function, option to select
																													Biological indicator , BMS Pass / Fail 
																													Both in Master as wel as Transaction function.
--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            eSS.AutoclavingBean bean= null;{
                bean=(eSS.AutoclavingBean)pageContext.getAttribute("bean");
                if(bean==null){
                    bean=new eSS.AutoclavingBean();
                    pageContext.setAttribute("bean",bean);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);


	String bean_id			=	request.getParameter("bean_id");
	String bean_name		=	request.getParameter("bean_name");
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	// AutoclavingBean bean	=	 (AutoclavingBean) getBeanObject(bean_id , bean_name, request);
	Hashtable hash			=	(Hashtable) XMLobj.parseXMLString(request);
    hash					=	(Hashtable) hash.get ("SEARCH");
	
	String autoclave_wash_unit_code = (String) hash.get("autoclave_wash_unit_code");
	
	if (autoclave_wash_unit_code.trim().equals("")) 
	{
		out.println("errorDisplay();");
		return;
	}

 try
   {
	HashMap hmRecord	= bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_AUTOCLAVE_UNIT_DETAILS"),autoclave_wash_unit_code);
	out.println("document.formAutoclavingHeader.temperature.value=\""+bean.checkForNull((String)hmRecord.get("TEMPERATURE"))+"\";");
	out.println("document.formAutoclavingHeader.sterile_type.value=\""+bean.checkForNull((String)hmRecord.get("STERILE_TYPE"))+"\";");
	 out.println("document.formAutoclavingHeader.service_location.value=\""+bean.checkForNull((String)hmRecord.get("SERVICE_LOC_DESC"))+"\";");
	 out.println("document.formAutoclavingHeader.sterilization_type.value=\""+bean.checkForNull((String)hmRecord.get("STERILE_TYPE_DESC"))+"\";");
	 
	 //Added by Sakti against  AAKH_CRF_0057  inc#52312
	 if(!bean.BiologicalIndicator_appl_yn(autoclave_wash_unit_code)) {
		 out.println("document.getElementById('id_b_indicator_label').style.visibility = 'hidden';");
		 out.println("document.getElementById('id_b_indicator').style.visibility = 'hidden';");
	 }else{
		 out.println("document.getElementById('id_b_indicator_label').style.visibility = 'visible';");
		 out.println("document.getElementById('id_b_indicator').style.visibility = 'visible';");
		 if(bean.getBIndicatorTestDone_yn().equals("Y")){
		 	out.println("document.getElementById('b_indicator_test_done_yn').selectedIndex = 0;");
		 }else{
			 out.println("document.getElementById('b_indicator_test_done_yn').selectedIndex = 1;");
		 }
	 }
	 if(!bean.Bms_appl_yn(autoclave_wash_unit_code)) {
		 out.println("document.getElementById('id_bms_pass_fail_label').style.visibility = 'hidden';");
		 out.println("document.getElementById('id_bms_pass_fail').style.visibility = 'hidden';");
	 }else{
		 out.println("document.getElementById('id_bms_pass_fail_label').style.visibility = 'visible';");
		 out.println("document.getElementById('id_bms_pass_fail').style.visibility = 'visible';");
		 if(bean.getBMSPassFail_yn().equals("P")){
		 	out.println("document.getElementById('bms_pass_fail').selectedIndex = 0;");
		 }else{
			 out.println("document.getElementById('bms_pass_fail').selectedIndex = 1;");
		 }
	 }
	 //Added ends


	hmRecord.get("SERVICE_LOC_CODE");
	out.println("refreshMessageFrame();");

   }catch(Exception e){

       out.println("checkRecord();");
       out.println("deletePreviousRecord();");
	   System.err.println(e);
	}
	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
