package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCA.*;
import eCA.Common.*;
import eCommon.Common.*;
import java.text.DecimalFormat;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __clinicaleventhistoryintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ClinicalEventHistoryIntermediate.jsp", 1742381586360L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name				Rev.Date	Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
21/06/2020  	IN071596	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.7
21/07/2020  	IN072759	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.8
26/11/2020	6450		SIVABAGYAM M	26/11/2020		RAMESH G	MO-CRF-20101.10

------------------------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

request.setCharacterEncoding("UTF-8");
session = request.getSession(false);
String bean_id			= "@NewClinicalEventHistBean";
String bean_id_new		= "NewClinicalEventHistBean";
String bean_name		= "eCA.NewClinicalEventHistBean";
NewClinicalEventHistBean bean	= (NewClinicalEventHistBean)getBeanObject( bean_id_new, bean_name , request); 
Properties p = (Properties)session.getValue("jdbc");
String locale	= (String) p.getProperty("LOCALE");
String index 			= request.getParameter("index")==null ?"":request.getParameter("index");
String patient_id		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String login_user_id			=  request.getParameter("login_user_id")==null?"":request.getParameter("login_user_id");
String hist_data_type		= request.getParameter("hist_data_type")==null?"":request.getParameter("hist_data_type");
String clinician_id  	= request.getParameter("clinician_id")==null?"":request.getParameter("clinician_id");
String contr_sys_event_code		= request.getParameter("contr_sys_event_code")==null?"":request.getParameter("contr_sys_event_code");
String accessionNum		= request.getParameter("accessionNum")==null?"":request.getParameter("accessionNum");
String facility_id  	= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
String url		= request.getParameter("url")==null?"":request.getParameter("url");
String encounterId 		= request.getParameter("encounterId")==null?"":request.getParameter("encounterId");
String event_date_time 		= request.getParameter("event_date_time")==null?"":request.getParameter("event_date_time");
String strNormalcyInd 	= request.getParameter("strNormalcyInd")==null?"I":request.getParameter("strNormalcyInd");
String selHistType = request.getParameter("selHistType")==null	?"":request.getParameter("selHistType");
if(!selHistType.equals("MERP")){//6450 starts
		if(hist_data_type.equals("HTM"))//IN072759
			bean.getNoteContent(facility_id,event_date_time, contr_sys_event_code, accessionNum ,hist_data_type, locale, encounterId, patient_id, url, clinician_id, login_user_id,strNormalcyInd,selHistType);
		else
			bean.getRadiologyContent(facility_id,event_date_time, contr_sys_event_code, accessionNum ,hist_data_type, locale, encounterId, patient_id, url, clinician_id, login_user_id,strNormalcyInd);//IN072759
	}
	else{
		bean.getMedicalReportContent( facility_id, event_date_time, accessionNum, encounterId, patient_id, clinician_id);
	}//6450 ends
HashMap<String,String> searchData = bean.getRecords();
    out.print(((String)searchData.get(accessionNum)).replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", ""));//ML-MMOH-SCF-2966
	//out.print((String)searchData.get(accessionNum));	
putObjectInBean(bean_id,bean,session);


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
