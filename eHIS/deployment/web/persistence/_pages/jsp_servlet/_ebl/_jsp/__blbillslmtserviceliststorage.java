package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.*;
import java.sql.*;
import java.text.*;
import oracle.sql.*;
import oracle.jdbc.*;
import java.math.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import com.ehis.util.*;
import java.util.*;
import org.json.simple.JSONObject;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blbillslmtserviceliststorage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillSlmtServiceListStorage.jsp", 1709114087959L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n  ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );
	
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


private String decodeParam(String input){
	String output = "";
	try{
		if(input!=null){
			input = input.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
			input = input.replaceAll("\\+", "%2B");
			output = URLDecoder.decode(input,"UTF-8");
		}
	}
	catch(Exception e){
		System.err.println("Exception while Decoding BillHdrAjax->"+e);
	}
	return output;
}



String toDateFormat(String date) throws ParseException{	
	
	if(date==null){
		return "";
	}
	
	String formattedDate;		
    String oldFormat = "dd/MM/yyyy HH:mm:ss";// 2013-10-08 17:15:33.0
    String newFormat = "yyyy-mm-dd hh:mm:ss";
    SimpleDateFormat sdfOld = new SimpleDateFormat(oldFormat);
    SimpleDateFormat sdfNew = new SimpleDateFormat(newFormat);    
	formattedDate=sdfNew.format(sdfOld.parse(date));		
	return formattedDate;	
} 


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);


try{
    Connection con	=	ConnectionManager.getConnection(request);
    
    String record_count= (request.getParameter("total_records")==null) ?"0":request.getParameter("total_records") ;
    int total_records=Integer.parseInt(record_count);
    TreeSet<BLBillSlmtServiceBean> slmt_by_svc_parameter_array =null;
    
    String operation=request.getParameter("operation")==null ? "":request.getParameter("operation") ;
    
    if(operation.equals("DELETE")){
    	slmt_by_svc_parameter_array = (TreeSet<BLBillSlmtServiceBean>) session.getAttribute("slmt_by_svc_parameter_array_session");
        BLBillSlmtServiceBean removeBeanObj = new BLBillSlmtServiceBean();
    	for(BLBillSlmtServiceBean beanObj:slmt_by_svc_parameter_array){
    		System.out.println(beanObj.getTrxDocRef());
    		System.out.println(request.getParameter("trans_doc_ref"));
    		if(beanObj.getTrxDocRef().equals(request.getParameter("trans_doc_ref"))){
    		removeBeanObj=beanObj;  		
    		}
    	}
    	slmt_by_svc_parameter_array.remove(removeBeanObj);
    	System.out.println(slmt_by_svc_parameter_array);
        session.setAttribute("slmt_by_svc_parameter_array_session",slmt_by_svc_parameter_array);
		
    	
    }else if(operation.equals("INCLUDE")){
	   
	    String billDocType=request.getParameter("billdoctypecode");
	    String billNumber=request.getParameter("billdocnum");
		String serviceDate=request.getParameter("service_date");
		String trxDocRef=request.getParameter("trx_doc_ref");
		String trxDocRefLineNum=request.getParameter("trx_doc_ref_line_num");	
		String trxDocRefSeqNum=request.getParameter("trx_doc_ref_seq_num");
		String billingService=request.getParameter("billing_service");
		String updNetChargeAmt=request.getParameter("upd_net_charge_amt");
		String chargeAmt=request.getParameter("charge_amt");
		String settledAmt=request.getParameter("settled_amt");	
		
		String all_service_criteria=(String) session.getAttribute("all_services_included_excluded_slmt");
		
		String inclusionExclusionCriteria="";
		if(all_service_criteria.equals("I")){
			inclusionExclusionCriteria="E";
		}else if(all_service_criteria.equals("E")){
			inclusionExclusionCriteria="I";	
		}
	
		
		BLBillSlmtServiceBean serviceBean=new BLBillSlmtServiceBean();
		serviceBean.setBillDocType(billDocType);
		serviceBean.setBillNumber(billNumber);
		serviceBean.setServiceDate(serviceDate);
		serviceBean.setTrxDocRef(trxDocRef);
		serviceBean.setTrxDocRefLineNum(trxDocRefLineNum);
		serviceBean.setTrxDocRefSeqNum(trxDocRefSeqNum);
		serviceBean.setBillingService(billingService);
		serviceBean.setUpdNetChargeAmt(updNetChargeAmt);
		serviceBean.setChargeAmt(chargeAmt);
		serviceBean.setSettledAmt(settledAmt);
		serviceBean.setInclusionExclusionCriteria(inclusionExclusionCriteria);
	    
	    System.out.println(session.getAttribute("slmt_by_svc_parameter_array_session"));
	    slmt_by_svc_parameter_array = session.getAttribute("slmt_by_svc_parameter_array_session")==null? new TreeSet<BLBillSlmtServiceBean>():(TreeSet<BLBillSlmtServiceBean>) session.getAttribute("slmt_by_svc_parameter_array_session");
	    if(slmt_by_svc_parameter_array==null){
	    	slmt_by_svc_parameter_array=new TreeSet();
	    }    
	    slmt_by_svc_parameter_array.add(serviceBean);
	    
	    System.out.println(slmt_by_svc_parameter_array);
	    session.setAttribute("slmt_by_svc_parameter_array_session",slmt_by_svc_parameter_array);
    }else if(operation.equals("UPDATE")){ 
    	
    	slmt_by_svc_parameter_array= (TreeSet<BLBillSlmtServiceBean>) session.getAttribute("slmt_by_svc_parameter_array_session");
    	Iterator<BLBillSlmtServiceBean> it=slmt_by_svc_parameter_array.iterator();
    	BLBillSlmtServiceBean deleteBean=new BLBillSlmtServiceBean();
    	BLBillSlmtServiceBean modifiedBean=new BLBillSlmtServiceBean();
    	String trans_doc_ref=request.getParameter("trans_doc_ref");
    	String settlement_amount=request.getParameter("settled_amt");
    	String all_service_criteria=request.getParameter("all_service_criteria");
    	while(it.hasNext()){
    		BLBillSlmtServiceBean serviceBean=it.next();
    		if(serviceBean.getTrxDocRef().toString().equals(trans_doc_ref)){
    			deleteBean=serviceBean;
    			modifiedBean.setBillDocType(serviceBean.getBillDocType());
    			modifiedBean.setBillingService(serviceBean.getBillingService());
    			modifiedBean.setBillNumber(serviceBean.getBillNumber());
    			modifiedBean.setChargeAmt(serviceBean.getChargeAmt());    			
    			modifiedBean.setServiceDate(serviceBean.getServiceDate());
    			modifiedBean.setTrxDocRef(serviceBean.getTrxDocRef());
    			modifiedBean.setTrxDocRefLineNum(serviceBean.getTrxDocRefLineNum());
    			modifiedBean.setTrxDocRefSeqNum(serviceBean.getTrxDocRefSeqNum());
    			modifiedBean.setUpdNetChargeAmt(serviceBean.getUpdNetChargeAmt());
    			modifiedBean.setInclusionExclusionCriteria(all_service_criteria);
    			modifiedBean.setSettledAmt(settlement_amount);
    		}
    	}
    	slmt_by_svc_parameter_array.remove(deleteBean);
    	slmt_by_svc_parameter_array.add(modifiedBean);
    	System.out.println(slmt_by_svc_parameter_array);
    	
    	
    }else if(operation.equals("ALL_INCLUDE_EXCLUDE")){   	
    	String all_service_criteria=request.getParameter("all_service_criteria");
    	session.setAttribute("all_services_included_excluded_slmt",all_service_criteria);
	    session.setAttribute("slmt_by_svc_parameter_array_session",null);
    }else if(operation.equals("CACHE_CLEAR")){
		session.removeAttribute("all_services_included_excluded_slmt");
		session.removeAttribute("slmt_by_svc_parameter_array_session");
		session.removeAttribute("deposit_parameter_array_session"); 
	    session.removeAttribute("deposit_adjusted_payable_amount");
	    
		String beanId = "BillDetailsBean" ;
		String beanName = "eBL.BLBillDetailsBean";		
		BLBillDetailsBean billDetailsBean = (BLBillDetailsBean) getBeanObject(beanId, beanName, request);
		billDetailsBean.clear();
		
    }
    else if("ASYNCPRINT".equals(operation)){
    	int totalRecords = 0;
    	totalRecords = Integer.parseInt(request.getParameter("totalReport"));
    	HashMap<String,String> asyncPrinterAttrib=new HashMap<String,String> ();
    	String printVal = "";
    	String reportId = "";
    	for(int i=1;i<=totalRecords;i++){
    		printVal = decodeParam(request.getParameter("billPrintVal"+i));
    		reportId = decodeParam(request.getParameter("report"+i));
    		asyncPrinterAttrib.put(printVal+"/"+i,reportId);
    	}
    	session.setAttribute("ASYNC_PRINTER_ATTRIB", asyncPrinterAttrib);
    	System.err.println("Session set");
    }
    
	JSONObject obj=new JSONObject();
    obj.put("flag","SUCCESS");    
    out.print(obj);
    out.flush();
     
} catch(Exception e) {
    System.out.println(e);
	JSONObject obj=new JSONObject();
    obj.put("flag","FAILED");    
    out.print(obj);
    out.flush();
     
}

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
