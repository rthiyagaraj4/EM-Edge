package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.placeorder.bc.PlaceOrderBC;
import eBL.placeorder.response.PlaceNewOrderResponse;
import eBL.placeorder.request.PlaceNewOrderRequest;
import eBL.placeorder.model.BLChargePatientNewOrderBean;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import com.iba.framework.core.util.UtilDateConverter;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.net.URLDecoder;
import java.sql.*;
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

public final class __blchargepatientneworderpersistence extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLChargePatientNewOrderPersistence.jsp", 1728457307202L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\n";
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


	private String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}

	private String decodeParam(String input){
	String output = "";
	if(input!=null){
		output = URLDecoder.decode(input);
	}
	return output;
		
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
// Page Added by Rajesh V. To Persist all the services in New Order 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

	String params = request.getQueryString();
	String sqlCoverage = "";
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String beanId = "BLChargePatientNewOrderBean" ;
	String beanName = "eBL.placeorder.model.BLChargePatientNewOrderBean";

	BLChargePatientNewOrderBean serviceBean = (BLChargePatientNewOrderBean) getObjectFromBean(beanId, beanName, session);
	String facility_id = (String)session.getAttribute("facility_id");
	ResourceBundle rb = null;
	Locale loc = null;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	PlaceOrderBC placeOrderBC = null;
	
	if(serviceBean.getServicesList() == null)
	{
		serviceBean.setServicesList(new ArrayList<BLChargePatientNewOrderBean>());
	}
	
	if(serviceBean.getRestrictionMap() == null){
		serviceBean.setRestrictionMap(new HashMap<String,String>());
	}
	
	ArrayList<BLChargePatientNewOrderBean> chargeList = serviceBean.getServicesList();
	HashMap<String,String> restrictionMap = serviceBean.getRestrictionMap();
	
	try 
	{
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
		
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;
		Calendar cal = Calendar.getInstance();
		java.util.Date dt = cal.getTime();
		
		String facilityId = (String)session.getValue( "facility_id" ) ;
		String loggedInUser = (String)session.getValue("login_user");	
		
		if(func_mode!= null && func_mode.equals("StoreServiceDetails"))
		{
			ArrayList<BLChargePatientNewOrderBean> serviceList = new ArrayList<BLChargePatientNewOrderBean>();
			BLChargePatientNewOrderBean bean = null;
			int count = Integer.parseInt((String)hash.get("rowCount"));
			for(int i=1; i<=count;i++){
				if(!"Y".equals((String)hash.get("deleteFlag_" + i))){
					bean = new BLChargePatientNewOrderBean();
					bean.setBlngServCode((String)hash.get("servCode_" + i));
					bean.setBlngServDesc((String)hash.get("servDesc_" + i));
					bean.setDateTime((String)hash.get("dateTime_" + i));
					bean.setServOrPanel((String)hash.get("servOrPanel_" + i));
					bean.setRateIndicator((String)hash.get("rateInd_" + i));
					bean.setRate((String)hash.get("rate_" + i));
					bean.setQuantity((String)hash.get("qty_" + i));
					bean.setBaseChargeAmt((String)hash.get("grossAmt_" + i));
					bean.setServDiscount((String)hash.get("servDisc_" + i));
					bean.setServDiscPerc((String)hash.get("servDiscPerc_" + i));
					bean.setAdhocRate((String)hash.get("adhocRate_" + i));
					
					bean.setAdhocPerc((String)hash.get("adhocDisc_" + i));
					if("".equals(bean.getAdhocRate())){
						bean.setDiscExists("N");
					}
					else{
						bean.setDiscExists("Y");
					}
					bean.setAdhocAmount((String)hash.get("adhocAmount_" + i));
					bean.setAdhocReason((String)hash.get("adhocReason_" + i));
					bean.setPolicyIncl((String)hash.get("policyIncl_" + i));
					bean.setUomCode((String)hash.get("uom_" + i));
					bean.setPractStaffInd((String)hash.get("practStaffInd_" + i));
					bean.setPractStaffType((String)hash.get("practStaffType" + i));
					bean.setAddlCharges((String)hash.get("addlCharges_" + i));
					bean.setNetChargeAmount((String)hash.get("total_" + i));
					bean.setPatNetChargeAmt((String)hash.get("patPayable_" + i));
					bean.setDrName((String)hash.get("drName_" + i));
					bean.setPhysicianName((String)hash.get("docNam" + i));
					bean.setRemarks((String)hash.get("remarksDtl_"+i));
					bean.setPreAppYn((String)hash.get("preAppReq_"+i));
					bean.setOverrideInd((String)hash.get("override_"+i));
					bean.setPanelString((String)hash.get("panelStr_"+i));
					bean.setEditPanel((String)hash.get("editPanel_"+i));
					bean.setOrgIncl((String)hash.get("originalIncl_"+i));
					serviceList.add(bean);
				}				
			}
			serviceBean.setServicesList(serviceList);
			serviceBean.setRemarks((String)hash.get("remarks"));
		}
		else if(func_mode!= null && func_mode.equals("removeRestriction"))
		{		
			String servPanelCode = (String) request.getParameter("servCode");
			String hh = (String) request.getParameter("hh");
			hh = hh.substring(11, 16);
			restrictionMap.remove(servPanelCode+":"+hh);
			
		}
		else if(func_mode!= null && func_mode.equals("assignPatInfo"))
		{			
			serviceBean.setPatientId((String)hash.get("patient_id"));
			serviceBean.setEpisodeId((String)hash.get("episode_id"));
			serviceBean.setVisitId((String)hash.get("visit_id"));
			serviceBean.setEncounterId((String)hash.get("encounter_id"));
			serviceBean.setEpisodeType((String)hash.get("episode_type"));
			serviceBean.setAcctSeqNo((String)hash.get("acctSeqNo"));
			serviceBean.setCustGroup((String)hash.get("payerGroup"));
			serviceBean.setCust((String)hash.get("payer"));
			serviceBean.setPolicyCode((String)hash.get("policy"));
			serviceBean.setPolicyNum((String)hash.get("policyNum"));
		}
		else if(func_mode!= null && func_mode.equals("updateServiceDetails")){
			String serviceQuery = "{call blplaceservice.populate_charge_bl_serv(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			String panelQuery = "{call blplaceservice.populate_charge_bl_panel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			String servOrPanel = (String) request.getParameter("servOrPanel");
			String episodeType = (String) request.getParameter("episodeType");
			String episodeId = (String) request.getParameter("episodeId");
			String visitId = (String) request.getParameter("visitId");
			String patientId = (String) request.getParameter("patientId");
			String encounterId = (String) request.getParameter("encounterId");
			String acctSeqNo = (String) request.getParameter("acctSeqNo");
			String dateTime = (String) request.getParameter("dateTime");
			String servPanelCode = (String) request.getParameter("servPanelCode");
			String servPanelDesc = decodeParam(request.getParameter("servPanelDesc"));
			String rateIndicator = (String) request.getParameter("rateIndicator");
			String quantity = (String) request.getParameter("quantity");
			String drName=(String) request.getParameter("drName");
			System.out.println("drName:::::"+drName);
			
			PlaceNewOrderRequest requestBean = new PlaceNewOrderRequest();
			requestBean.setServOrPanel(servOrPanel);
			requestBean.setEpisodeType(episodeType);
			requestBean.setEpisodeId(episodeId);
			requestBean.setVisitId(visitId);
			requestBean.setPatientId(patientId);
			requestBean.setEncounterId(encounterId);
			requestBean.setAcctSeqNo(acctSeqNo);
			requestBean.setServPanelCode(servPanelCode);
			requestBean.setServPanelDesc(servPanelDesc);
			requestBean.setRateIndicator(rateIndicator);
			requestBean.setFacilityId(facility_id);
			requestBean.setLocale(locale);
			requestBean.setQuantity(quantity);
			requestBean.setSplDepChkYn(drName);
			
			
			placeOrderBC  = new PlaceOrderBC(); 
			JsonObject jsonObj = placeOrderBC.updateServiceDetails(requestBean);
			out.println(jsonObj);
		}
		else if(func_mode!= null && func_mode.equals("getServiceDetails")){
			String serviceQuery = "{call blplaceservice.populate_charge_bl_serv(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			String panelQuery = "{call blplaceservice.populate_charge_bl_panel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			String servOrPanel = (String) request.getParameter("servOrPanel");
			String episodeType = (String) request.getParameter("episodeType");
			String episodeId = (String) request.getParameter("episodeId");
			String visitId = (String) request.getParameter("visitId");
			String patientId = (String) request.getParameter("patientId");
			String encounterId = (String) request.getParameter("encounterId");
			String acctSeqNo = (String) request.getParameter("acctSeqNo");
			String dateTime = (String) request.getParameter("dateTime");
			String servPanelCode = (String) request.getParameter("servPanelCode");
			String servPanelDesc = decodeParam(request.getParameter("servPanelDesc"));
			String rateIndicator = (String) request.getParameter("rateIndicator");
			
			PlaceNewOrderRequest requestBean = new PlaceNewOrderRequest();
			requestBean.setServOrPanel(servOrPanel);
			requestBean.setEpisodeType(episodeType);
			requestBean.setEpisodeId(episodeId);
			requestBean.setVisitId(visitId);
			requestBean.setPatientId(patientId);
			requestBean.setEncounterId(encounterId);
			requestBean.setAcctSeqNo(acctSeqNo);
			requestBean.setServPanelCode(servPanelCode);
			requestBean.setServPanelDesc(servPanelDesc);
			requestBean.setRateIndicator(rateIndicator);
			System.err.println(facility_id);
			requestBean.setFacilityId(facility_id);
			requestBean.setLocale(locale);
			requestBean.setQuantity("1");
			
			/*SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
			java.util.Date dt1 = new java.util.Date();
			String today = sdf1.format(dt1);*/
			

			
			placeOrderBC  = new PlaceOrderBC(); 
			PlaceNewOrderResponse responseBean = placeOrderBC.getServiceDetails(requestBean);
			List<String> errorList = responseBean.getErrorList();
			BLChargePatientNewOrderBean bean = responseBean.getNewOrderBean();
			String today = "";
			Connection con = null;
			try{
				con = ConnectionManager.getConnection();
				pstmt = con.prepareStatement("Select to_char(sysdate,'HH24:MI') today from dual");
				rst = pstmt.executeQuery();
				if(rst != null && rst.next()){
					today = rst.getString("today");
				}
			}
			catch(Exception e){
				System.err.println("Exception in getting Date BLChargePatientNewOrderDetails.jsp ->"+e);
			}
			finally{
				pstmt = null;
				rst = null;
				ConnectionManager.returnConnection(con);
			}
			
			StringBuffer consErrorText = new StringBuffer();
			String error = "";
			if(!errorList.isEmpty()){
				for (Iterator iterator = errorList.iterator(); iterator.hasNext();) {
					error = (String) iterator.next();
					consErrorText.append(error);
					consErrorText.append("\n");
				}
			}
			error = consErrorText.toString();

			if("".equals(error)){
				restrictionMap.put(servPanelCode+":"+today, "Y");
				chargeList.add(bean);
				out.println("Y");
			}
			else{
				out.println("N:::"+error);
			}
		}
		else if(func_mode!= null && func_mode.equals("checkDuplicate")){
			String servPanelCode = (String) request.getParameter("servPanelCode");
			SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
			java.util.Date dt1 = new java.util.Date();
			String today = sdf1.format(dt1);
			if(restrictionMap.containsKey(servPanelCode+":"+today)){
				out.println("Y");
			}
			else{
				out.println("N");
			}
		}
		else if(func_mode!= null && func_mode.equals("cancelExisting")){

			Gson gjon = new Gson();
			
			JsonParser jsonParser = new JsonParser();
			JsonObject cancelParam = (JsonObject)jsonParser.parse(request.getParameter("servForCancel"));
			System.err.println(cancelParam.get("episodeType").getAsString());
		}
		
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.err.println("Exception from BL Function Privilege :" + e);
	}	

	putObjectInBean(beanId,serviceBean,request);


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
