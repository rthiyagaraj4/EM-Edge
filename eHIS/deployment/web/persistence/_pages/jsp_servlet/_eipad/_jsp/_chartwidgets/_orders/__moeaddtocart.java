package jsp_servlet._eipad._jsp._chartwidgets._orders;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eOR.Common.OrderEntryRecordBean;
import eOR.OrderEntryBean;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __moeaddtocart extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/orders/MoeAddToCart.jsp", 1709116945082L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
try{
	if(patientContext!=null){
		String patientId = patientContext.getPatientId();
		String encounterId = patientContext.getEncounterId();
		String locale = patientContext.getLocale();
		String or_bean_id = "@orderentrybeanm"+patientId+encounterId;
		String or_bean_name = "eOR.OrderEntryBean";
		String orderCatalogCode = request.getParameter("OrderCatalogCode") == null ? "":request.getParameter("OrderCatalogCode");
		String orderTypeCode = request.getParameter("OrderTypeCode") == null ? "":request.getParameter("OrderTypeCode");
		String orderCategoryCode = request.getParameter("OrderCatCode") == null ? "":request.getParameter("OrderCatCode");
		String orderCatalogCodeCSV = request.getParameter("OrderCatalogCodes") == null ? "":request.getParameter("OrderCatalogCodes"); //In case of ordersets, multiple values will be present in the csv
		String [] orderCatalogCodes = orderCatalogCodeCSV.split(",");
		String clinComments = request.getParameter("ClinComments") == null ? "":request.getParameter("ClinComments");
		String authorized = request.getParameter("authorized"+orderCategoryCode) == null ? "false":request.getParameter("authorized"+orderCategoryCode);
		String consented = request.getParameter("consented"+orderCategoryCode) == null ? "false":request.getParameter("consented"+orderCategoryCode);
		String cosigned = request.getParameter("cosigned"+orderCategoryCode) == null ? "false":request.getParameter("cosigned"+orderCategoryCode);
		String special_approved = request.getParameter("special_approved"+orderCategoryCode) == null ? "false":request.getParameter("special_approved"+orderCategoryCode);
		
		OrderEntryBean beanObj	= (OrderEntryBean)PersistenceHelper.getBeanObject(or_bean_id,or_bean_name,request);
		String check_box_value	= beanObj.checkForNull(request.getParameter( "check_box_value" ),"") ;
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) beanObj.getOrderEntryRecordBean();
		beanObj.setCatalogCodes(check_box_value);
		String key				= (beanObj.getPatientId()+beanObj.getEncounterId());
		HashMap previousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
		if(previousValues == null){
			previousValues = new HashMap();
		}
		previousValues.put("ck"+orderCatalogCode, "Y");
		previousValues.put("h1"+orderCatalogCode,orderCategoryCode);
		previousValues.put("h2"+orderCatalogCode,orderTypeCode);
		orderEntryRecordBean.setCheckedEntries(key, previousValues);
		orderEntryRecordBean.setOrderFormats(orderCategoryCode+"_CLINICALCOMMENTS", (orderCategoryCode+"_CLINICALCOMMENTS_0"),clinComments);
		beanObj.setTempValues("authorized"+orderCategoryCode,authorized);
		beanObj.setTempValues("consented"+orderCategoryCode,consented);
		beanObj.setTempValues("cosigned"+orderCategoryCode,cosigned);
		beanObj.setTempValues("special_approved"+orderCategoryCode,special_approved);
		
		for(int i=0;i<orderCatalogCodes.length;i++){
			beanObj.setTempValues("start_date_time"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("StartDate-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("end_date_time"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("EndDate-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("order_type_code"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("OrderType-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("priority"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("Priority-"+orderCatalogCodes[i]),""));
			String quantity = request.getParameter("Quantity-"+orderCatalogCodes[i]);
			if(quantity == null || quantity.trim().equals(""))
				quantity = "1";
			beanObj.setTempValues("quantity"+orderCatalogCodes[i],beanObj.checkForNull(quantity,"1"));
			beanObj.setTempValues("frequency_code"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("Frequency-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("duration_code"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("Duration-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("duration_value"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("DurationNum-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("performing_facility_id"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("PerformingLocation-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("performing_dept_loc_code"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("PerformingDept-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("performing_facility_desc"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("PerformingLocation-"+orderCatalogCodes[i]+"_input"),""));
			beanObj.setTempValues("performing_dept_loc_desc"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("PerformingDept-"+orderCatalogCodes[i]+"_input"),""));
		}
		if(orderCategoryCode.equals("CS")){
			beanObj.setTempValues("OrderSetChecked", "1");
		}
		
		
		//Setting all the values entered in the form
		//beanObj.setTempValues(key,value);
		putObjectInBean(or_bean_id,beanObj,request);
	}
}catch(Exception e){
	System.out.println(e.getMessage());
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
