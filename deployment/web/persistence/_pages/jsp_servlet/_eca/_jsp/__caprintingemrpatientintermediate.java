package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.*;
import eCA.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __caprintingemrpatientintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAPrintingEmrPatientIntermediate.jsp", 1732941616573L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
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
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
11/04/2019		ML-MMOH-CRF-1064	Kamalakannan G		11/04/2019		Ramesh Goli		IN066304
11/24/2023     32902        Twinkle Shah    	           Ramesh Goli             MMS-DM-CRF-0210			
--------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

//start 32902
Connection conn=null;
conn=ConnectionManager.getConnection(request);
PreparedStatement pstmt=null;
ResultSet rs=null;
// end 32902
	try {
		Hashtable hashObj = (Hashtable) XMLobj.parseXMLString(request);
		hashObj = (Hashtable) hashObj.get("SEARCH");
		String bean_id					= "CAClinicalHistoryBean" ;
		String bean_name				= "eCA.CAClinicalHistoryBean";
		String action = (String) hashObj.get("p_action") == null ? "": (String) hashObj.get("p_action");
	
		
		CAClinicalHistoryBean bean	= (CAClinicalHistoryBean)getBeanObject( bean_id, bean_name , request) ;
		//start 32902
		String ca_bean_id 						= "@CACommonGetPatientDtlBean";
		String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
		CACommonGetPatientDtlBean bean1			= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
		//end 32902
		if("PARENT_CHK".equals(action)){
			String hist_type = (String) hashObj.get("key") == null ? "": (String) hashObj.get("key");
			String histArr[] = hist_type.split("_");
			String event_class = "";
			hist_type = histArr[0];
			String flag = (String) hashObj.get("flag") == null ? "": (String) hashObj.get("flag");
			String eventList = (String) hashObj.get("eventList") == null ? "": (String) hashObj.get("eventList");
			LinkedHashMap<String,String> clntObj = bean.updateAllClinicalNotePrintingFlags(hist_type,flag,eventList);
			bean.parentAndChildChkFunc(hist_type,event_class,flag);
			out.println(clntObj);
		}else if("CLNT_CHILD_CHK".equals(action)){
			String hist_type = (String) hashObj.get("hist_type") == null ? "": (String) hashObj.get("hist_type");
			ArrayList list = bean.getClinicalNotePrintingEventClass(hist_type);
			out.println(list);
		}else if("CLNT_CHILD_INNER_CHK".equals(action)){
			String hist_type = (String) hashObj.get("hist_type") == null ? "": (String) hashObj.get("hist_type");
			String patient_id = (String) hashObj.get("patient_id") == null ? "": (String) hashObj.get("patient_id");
			String encounter_id = (String) hashObj.get("encounter_id") == null ? "": (String) hashObj.get("encounter_id");
			String date_from = (String) hashObj.get("date_from") == null ? "": (String) hashObj.get("date_from");
			String date_to = (String) hashObj.get("date_to") == null ? "": (String) hashObj.get("date_to");
			String arr[] = hist_type.split("_");
			String hist_rec = arr[0].trim();
			String event_class = arr[1];
			String flag		 = (String) hashObj.get("key") == null ? "": (String) hashObj.get("key");
			bean.updateValues(hist_type,flag);
			bean.parentAndChildChkFunc(hist_rec,event_class,flag);
			String checkFlag = bean.UIFunction(hist_rec);//testing
			bean.getDefaultClntMap(patient_id,encounter_id,date_from,date_to);
			String parentCheckflag = bean.getParentCheckFlag();
			out.println("changeCheckBox('"+checkFlag+"','"+hist_rec+"','"+parentCheckflag+"')");
		}else if("PRINTING_FINAL_LIST".equals(action)){
			System.out.println(bean.finalizePrintList());
		}else if("SELECT_ALL".equals(action)){
			String flag		 = (String) hashObj.get("flag") == null ? "": (String) hashObj.get("flag");
			String patient_id = (String) hashObj.get("patient_id") == null ? "": (String) hashObj.get("patient_id");
			String encounter_id = (String) hashObj.get("encounter_id") == null ? "": (String) hashObj.get("encounter_id");
			String date_from = (String) hashObj.get("date_from") == null ? "": (String) hashObj.get("date_from");
			String date_to = (String) hashObj.get("date_to") == null ? "": (String) hashObj.get("date_to");
			bean.getSelectAllListForPrint(flag);
			bean.selectAllCheckBox(flag, patient_id, encounter_id, date_from, date_to);
		}
		//start 32902
		else if("IS_PAT_RESTRICTED".equals(action)){
			int accessRightsViewPatient=0;
			String restPatientYN="";		
			String patient_id = (String) hashObj.get("patient_id") == null ? "": (String) hashObj.get("patient_id");
			String facility_id = (String) hashObj.get("facility_id") == null ? "": (String) hashObj.get("facility_id");
			String clinicianId = (String) hashObj.get("clinicianId") == null ? "": (String) hashObj.get("clinicianId");			
			accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902			
			if(!patient_id.equals("") || !patient_id.equals(null)){
			restPatientYN=bean1.getRestrictedPatientYN(patient_id);
			}            
            if(accessRightsViewPatient == 1 && restPatientYN.equals("Y")){
    			out.println("N");
    		}else if(accessRightsViewPatient == 1 && restPatientYN.equals("N")){
    			out.println("N");
    		}else if(accessRightsViewPatient == 0 && restPatientYN.equals("Y")){
    			out.println("Y");
    		}else{
    			out.println("N");
    		}
		}
		//end 32902
	} catch (Exception ex) {
		ex.printStackTrace();
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
