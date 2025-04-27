package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __ipconsultationlistintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/IPConsultationListIntermediate.jsp", 1731066436583L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);


String operation_mode = request.getParameter("operation_mode")==null?"":request.getParameter("operation_mode");


String bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");



if(operation_mode.equals("create"))
{

	eCA.IPConsultationListBean ipConsultListBean = null;

		ipConsultListBean = (eCA.IPConsultationListBean)getObjectFromBean("ipConsultListBean"+bean_key,"eCA.IPConsultationListBean",session);
	
	String pline = request.getParameter("pline")==null?"":request.getParameter("pline");
	String Admission_date_time = request.getParameter("Admission_date_time")==null?"":request.getParameter("Admission_date_time");
	String Specialty_code = request.getParameter("Specialty_code")==null?"":request.getParameter("Specialty_code");
	String Location_code = request.getParameter("Location_code")==null?"":request.getParameter("Location_code");
	
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String attend_practitioner_id = request.getParameter("attend_practitioner_id")==null?"":request.getParameter("attend_practitioner_id");
	String create_type = request.getParameter("create_type")==null?"":request.getParameter("create_type");

	String arrVal ="";

	




	if(create_type.equals("S"))
	{
		arrVal = attend_practitioner_id+"~"+Location_code+"~"+pline+"~"+Admission_date_time+"~"+Specialty_code+"~"+patient_id+"~"+encounter_id;
	}
	else
	{
		arrVal = Location_code+"~"+Location_code+"~"+pline+"~"+Admission_date_time+"~"+Specialty_code+"~"+patient_id+"~"+encounter_id;
	}

	if(mode.equals("Add"))

	{
		//if(!ipConsultListBean.returnConsList().contains(arrVal))
		//{
			ipConsultListBean.addtoConsList(arrVal);
		//}


	}
	else if (mode.equals("Rem"))
	{
		if(ipConsultListBean.returnConsList().contains(arrVal))
		{
			ipConsultListBean.remFromConsList(arrVal);
		}

	}
	
	putObjectInBean("ipConsultListBean"+bean_key,ipConsultListBean,session);
}
else if(operation_mode.equals("update"))
{


		eCA.IPConsultationListBean ipConsultListBean = null;

		ipConsultListBean = (eCA.IPConsultationListBean)getObjectFromBean("ipConsultListBeanUpd"+bean_key,"eCA.IPConsultationListBean",session);

	//String bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String cons_ref_id = request.getParameter("cons_ref_id")==null?"":request.getParameter("cons_ref_id");
	String consult_date_time = request.getParameter("consult_date_time")==null?"":request.getParameter("consult_date_time");
	String order_catalog = request.getParameter("order_catalog")==null?"":request.getParameter("order_catalog");
	String p_patient_class = request.getParameter("p_patient_class")==null?"":request.getParameter("p_patient_class");
	String p_episode_id = request.getParameter("p_episode_id")==null?"":request.getParameter("p_episode_id");
	String episode_visit_num = request.getParameter("episode_visit_num")==null?"":request.getParameter("episode_visit_num");
	String practitioner_id = request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
	String source_code = request.getParameter("source_code")==null?"":request.getParameter("source_code");
	String source_type = request.getParameter("source_type")==null?"":request.getParameter("source_type");



	String arrVal ="";

		
	arrVal = cons_ref_id+"~"+patient_id+"~"+encounter_id+"~"+consult_date_time+"~"+order_catalog+"~"+p_patient_class+"~"+p_episode_id+"~"+episode_visit_num+"~"+practitioner_id+"~"+source_code+"~"+source_type;

	if(mode.equals("Add"))
	{
		//if(!ipConsultListBean.returnConsList().contains(arrVal))
		//{
			ipConsultListBean.addtoConsList(arrVal);
		//}


	}
	else if (mode.equals("Rem"))
	{
		if(ipConsultListBean.returnConsList().contains(arrVal))
		{
			ipConsultListBean.remFromConsList(arrVal);
		}

	}
	
	putObjectInBean("ipConsultListBeanUpd"+bean_key,ipConsultListBean,session);

}
	
	
	
	
	



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
