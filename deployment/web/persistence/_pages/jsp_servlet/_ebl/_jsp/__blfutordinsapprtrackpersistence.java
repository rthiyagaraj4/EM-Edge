package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public final class __blfutordinsapprtrackpersistence extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLFutOrdInsApprTrackPersistence.jsp", 1709114102678L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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
Sr No        Version           Incident        SCF/CRF                     		Developer Name
-----------------------------------------------------------------------------------------------
 1											AAKH-CRF-0152.3				Monika Gupta
*/ 
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
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	System.err.println("Persitence file called.deff. for future order");
	
	String params = request.getQueryString();
	String beanId = "bl_BLFutOrdInsApprTrackBean";
	String beanName = "eBL.BLFutOrdInsApprTrackBean";
	System.err.println("Future Order and Insurance Approval Tracking Persitence file called..");
		
	BLFutOrdInsApprTrackBean policyBean = (BLFutOrdInsApprTrackBean) getBeanObject(beanId, beanName, request);
	
	 if(policyBean.getPolicyMap() == null){
		policyBean.setPolicyMap(new HashMap<String, List<BLFutOrdInsApprTrackBean>>());
	} 
	System.err.println("Persitence file called..123");
	HashMap<String, List<BLFutOrdInsApprTrackBean> > policyMap = policyBean.getPolicyMap();
	
	String called_frm = request.getParameter("called_frm");
	
	if("onApply".equals(called_frm))
	{
		try 
		{
		
			request.setCharacterEncoding("UTF-8");
			
			String locale = (String)session.getAttribute("LOCALE");
		//	String func_mode = request.getParameter("func_mode");
			String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
		
			Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
				hash = (Hashtable)hash.get( "SEARCH" ) ;

			String facilityId = (String)session.getValue( "facility_id" ) ;
			String loggedInUser = (String)session.getValue("login_user");	
			List<BLFutOrdInsApprTrackBean> covList = new ArrayList<BLFutOrdInsApprTrackBean>();
			BLFutOrdInsApprTrackBean covBean = null;
			int rowCount = Integer.parseInt((String)hash.get("rowCount"));	
			
			for(int i=1; i<=rowCount; i++){	
				covBean = new BLFutOrdInsApprTrackBean();	
				System.err.println("covList is:");		
				covBean.setOperating_facility_id((String)hash.get("OPERATING_FACILITY_ID_" + i));
				covBean.setPrimary_key_module_id((String)hash.get("PRIMARY_KEY_MODULE_ID_" + i));
				covBean.setPrimary_key_main((String)hash.get("PRIMARY_KEY_MAIN_" + i));
				covBean.setPrimary_key_line_no((String)hash.get("PRIMARY_KEY_LINE_NO_"+i));
				covBean.setServ_item_code((String)hash.get("SERV_ITEM_CODE_"+i));
				covBean.setBlng_serv_code((String)hash.get("BLNG_SERV_CODE_"+i));
					
				covBean.setAppr_info_to_pat_yn((String)hash.get("APPR_INFO_TO_PAT_YN_" + i));	
				covBean.setAppr_info_by_id((String)hash.get("APPR_INFO_BY_ID_"+i));
				covBean.setAppr_info_date((String)hash.get("APPR_INFO_DATE_"+i));
				covBean.setAppr_start_date((String)hash.get("APPR_START_DATE_"+i));
				covBean.setAppr_expire_date((String)hash.get("APPR_EXPIRE_DATE_"+i));
				covBean.setService_perform_date((String)hash.get("SERVICE_PERFORM_DATE_" + i));
				covBean.setService_status((String)hash.get("SERVICE_STATUS_" + i));
				covBean.setService_remarks((String)hash.get("SERVICE_REMARKS_" + i));
				covBean.setFollow_up_visit_appt_yn((String)hash.get("FOLLOW_UP_VISIT_APPT_YN_" + i));
				covBean.setAppt_date_time((String)hash.get("APPT_DATE_TIME_" + i));
				covBean.setFollow_up_vist_adm((String)hash.get("FOLLOW_UP_VIST_ADM_" + i));

					
				if(!("".equals(covBean.getOperating_facility_id()) && "".equals(covBean.getPrimary_key_module_id()) && "".equals(covBean.getPrimary_key_main()) 
					&& "".equals(covBean.getPrimary_key_line_no()) && "".equals(covBean.getServ_item_code()) && "".equals(covBean.getBlng_serv_code()))){
						
						if(!"".equals(covBean.getAppr_info_to_pat_yn()) || !"".equals(covBean.getAppr_info_by_id()) || !"".equals(covBean.getAppr_info_date()) || !"".equals(covBean.getAppr_start_date()) || !"".equals(covBean.getAppr_expire_date()) || !"".equals(covBean.getService_perform_date()) || !"".equals(covBean.getService_status()) || !"".equals(covBean.getService_remarks()) || !"".equals(covBean.getFollow_up_visit_appt_yn()) || !"".equals(covBean.getAppt_date_time()) || !"".equals(covBean.getFollow_up_vist_adm())){
							covList.add(covBean); 
						}
				}  
			}  
			if(!(covList.isEmpty())){
				policyMap.put("BLFutOrdInsApprTrackInfo", covList); 
				System.err.println("Data is in CovList.."+covList.size());
			}
		}catch (Exception e) {	
			e.printStackTrace();
			System.err.println("Exception from BLFutOrdInsApprTrackPersistence :" + e);
		} 
		putObjectInBean("bl_BLFutOrdInsApprTrackBean",policyBean,request);	
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
