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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import org.json.simple.JSONObject;

public final class __blbillslmtallservicessubmit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillSlmtAllServicesSubmit.jsp", 1709114086022L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\t\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );
	
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



String toDateFormat(String date,int type) throws ParseException{	
	if(date==null || date.equals("")){
		return null;
	}	
	String formattedDate;	
    String oldFormat = "dd/MM/yyyy HH:mm";// 2013-10-08 17:15:33.0
	if(type==1){
		oldFormat = "dd/MM/yyyy HH:mm";
	}else if(type==2){
		oldFormat = "dd/MM/yyyy";
	}

    String newFormat = "yyyy-MM-dd hh:mm:ss";
    SimpleDateFormat sdfOld = new SimpleDateFormat(oldFormat);
    SimpleDateFormat sdfNew = new SimpleDateFormat(newFormat);    
	formattedDate=sdfNew.format(sdfOld.parse(date));	
	return formattedDate;		
} 

Double toDoubleFormat(String number){	
	if(number==null){
		return 0.0;
	}	
	Double formattedNumber;		
	formattedNumber=Double.parseDouble(number);
	return formattedNumber;		
} 

Integer toIntegerFormat(String number){	
	if(number==null){
		return 0;
	}	
	Integer formattedNumber;		
	formattedNumber=Integer.parseInt(number);
	return formattedNumber;		
} 

String nullFormatter(String input){
	if(input==null){
		return "";
	}else{
		return input;
	}
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

Connection con = ConnectionManager.getConnection();
CallableStatement cst =null;
PreparedStatement pstmt = null;
ResultSet rs =null;

try{	
	
		
		System.out.println("getQueryString episode type: "+ request.getQueryString() );
	    String record_count=request.getParameter("total_records")==null ? "0": request.getParameter("total_records");
	    int total_records=Integer.parseInt(record_count);
	    
	    
		/* Parameters for Procedure Call */
		String facility_id = (String) session.getValue("facility_id");
		String language_id = (String)session.getAttribute("LOCALE");
		String cust_code = "";
		String episode_type = request.getParameter("episode_type"); //
		String slmt_amt =request.getParameter("slmt_amt");
		String user_id =(String) session.getValue("login_user");
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");	
		String ws_no = p.getProperty("client_ip_address");
		String slmt_doc_type_code = "";
		String slmt_doc_num = "";
		String cash_amt_given ="0";
		String cash_amt_returned = "0";
		String slmtModeWiseWcptYN="";
		/*Parameter for Procedure Call ends*/
	    
    
		/* Array of BILL_DOC_NUMBERS is Constructed here - Start  */	
		String beanId = "BillDetailsBean";
		String beanName = "eBL.BLBillDetailsBean";
		BLBillDetailsBean bean=(BLBillDetailsBean) getBeanObject(beanId, beanName, request);
		HashMap<String, ArrayList<BLBillDetailsBean>> billDtlMap=bean.getBillDtlMap();
		ArrayList<BLBillDetailsBean> billDetailList=billDtlMap.get("REPRINT");
		int bill_doc_rec_count=billDetailList.size(); // Total Records Placed in Array
		
	 	StructDescriptor bill_doc_record_descriptor =  StructDescriptor.createDescriptor("IBAEHIS.BILL_DOC_NUMBERS",con);
	    ArrayDescriptor bill_doc_array_descriptor = ArrayDescriptor.createDescriptor("IBAEHIS.BILL_DTLS", con);
	    
		Object[] bill_doc_numbers_record_array = new Object[bill_doc_rec_count];  // to store n number of object data
	    Object[] bill_doc_numbers_object   = new Object[13];  // to store object data
	    
	    for(int rec_count=0; rec_count<bill_doc_rec_count; rec_count++){

	    bill_doc_numbers_object[0]=billDetailList.get(rec_count).getPatientId();
	    bill_doc_numbers_object[1]=billDetailList.get(rec_count).getEpisodeType();
	    bill_doc_numbers_object[2]=toIntegerFormat(billDetailList.get(rec_count).getEpisodeId());
	    bill_doc_numbers_object[3]=toIntegerFormat(billDetailList.get(rec_count).getVisitId());
	    bill_doc_numbers_object[4]=billDetailList.get(rec_count).getDocTypeCode();
	    bill_doc_numbers_object[5]=toIntegerFormat(billDetailList.get(rec_count).getDocNum());
	    bill_doc_numbers_object[6]=toDoubleFormat(billDetailList.get(rec_count).getBillTotAmt());
	    bill_doc_numbers_object[7]=toDateFormat(billDetailList.get(rec_count).getDocDate(),1);
	    bill_doc_numbers_object[8]=toDoubleFormat(billDetailList.get(rec_count).getTotOutStdAmt());
	    bill_doc_numbers_object[9]=billDetailList.get(rec_count).getReceiptNature();
	    bill_doc_numbers_object[10]=billDetailList.get(rec_count).getReceiptTypeCode();
	    bill_doc_numbers_object[11]=billDetailList.get(rec_count).getExtAccCode();
	    bill_doc_numbers_object[12]=billDetailList.get(rec_count).getExtAccDept();
	    System.out.println(Arrays.asList(bill_doc_numbers_object));
	    
	    STRUCT bill_doc_numbers_record = new STRUCT(bill_doc_record_descriptor, con, bill_doc_numbers_object);     
		bill_doc_numbers_record_array[rec_count]=bill_doc_numbers_record;	
		
	    }    
	    ARRAY bill_doc_numbers_parameter_array = new ARRAY(bill_doc_array_descriptor,con,bill_doc_numbers_record_array);
		System.out.println("BILL_DOC_NUMBERS - BILL_DTLS"+ Arrays.asList(bill_doc_numbers_parameter_array)); 
		/* Array of BILL_DOC_NUMBERS is Constructed here - End  */
	
		
	    
		/* Array of SLMT_MODE is Constructed here - Data from BillSlmtTypeForm Starts */
		StructDescriptor slmt_mode_record_descriptor = StructDescriptor.createDescriptor("IBAEHIS.SLMT_MODE", con);
		ArrayDescriptor slmt_mode_array_descriptor = ArrayDescriptor.createDescriptor("IBAEHIS.SLMT_DTLS", con);
	    
		Object[] slmt_mode_record_array = new Object[total_records];  // to store n number of object data
	    Object[] slmt_mode_object   = new Object[12];  // to store object data

	    for(int rec_count=0; rec_count<total_records ;rec_count++){
	    String slmtType=request.getParameter("slmttype"+rec_count);
	    slmtType=slmtType.substring(0,2);
	    if(slmtType.equals("CA")){
	    	cash_amt_given=	request.getParameter("cash_given"+rec_count);
	    	cash_amt_returned=request.getParameter("cash_return"+rec_count);
	    }
	    slmt_mode_object[0]=slmtType;
	    slmt_mode_object[1]=Float.parseFloat(request.getParameter("billslmtamt"+rec_count));
	    slmt_mode_object[2]=0; //slmt_srno
		slmt_mode_object[3]=null; //slmt_doc_ref
	    slmt_mode_object[4]=toDateFormat(request.getParameter("instdate"+rec_count),2);//slmt_doc_ref_date
		slmt_mode_object[5]=nullFormatter(request.getParameter("instremarkcode"+rec_count));//bank_cc_code
	    slmt_mode_object[6]=0;//rcpt_rfnd_id_no
	    slmt_mode_object[7]=request.getParameter("payername"+rec_count);
	    slmt_mode_object[8]=request.getParameter("apprrefno"+rec_count);
	    String onlineApprovalCheckedYN= nullFormatter(request.getParameter("onlineapproval"+rec_count)).equalsIgnoreCase("checked") ? "Y" : "N";
	    slmt_mode_object[9]=onlineApprovalCheckedYN;
	    slmt_mode_object[10]=request.getParameter("batchno"+rec_count);
		slmt_mode_object[11]=request.getParameter("saledraftno"+rec_count); 
		
	    System.out.println(Arrays.asList(slmt_mode_object));
		
		STRUCT slmt_mode_record = new STRUCT(slmt_mode_record_descriptor,con, slmt_mode_object);
		slmt_mode_record_array[rec_count]=slmt_mode_record;
	    }
		  
	    ARRAY slmt_mode_parameter_array = new ARRAY(slmt_mode_array_descriptor,con,slmt_mode_record_array); 
		System.out.println("SLMT_MODE- SLMT_DTLS "+ Arrays.asList(slmt_mode_parameter_array)); 
		/* Array of SLMT_MODE is Constructed here - Data from BillSlmtTypeForm Ends */
		
	    
		/* Array of DEPOSIT_DTLS is Constructed Here   - Start */
	    ARRAY deposit_parameter_array = (ARRAY) session.getAttribute("deposit_parameter_array_session");
		if(deposit_parameter_array==null){
		    ArrayDescriptor deposit_array_descriptor = ArrayDescriptor.createDescriptor("IBAEHIS.DEP_DTLS", con);
			deposit_parameter_array = new ARRAY(deposit_array_descriptor,con,new Object[1]);    
		}
		System.out.println("DEPOSIT_DTLS"+ Arrays.asList(deposit_parameter_array));
		/* Array of DEPOSIT_DTLS is Constructed Here   - End */
	
	    
		
		/* Array of SETT_DTLS is Constructed Here - Starts */
			    
		TreeSet<BLBillSlmtServiceBean> slmt_by_svc_parameter_array_session = (TreeSet<BLBillSlmtServiceBean>) session.getAttribute("slmt_by_svc_parameter_array_session");
		Iterator<BLBillSlmtServiceBean> it=null;
	
		if(slmt_by_svc_parameter_array_session==null){
			total_records=1;
		}else{
			it=slmt_by_svc_parameter_array_session.iterator();
			total_records=slmt_by_svc_parameter_array_session.size();
		}
		
		StructDescriptor slmt_by_svc_record_descriptor = StructDescriptor.createDescriptor("IBAEHIS.SETT_BY_SERV", con);
		ArrayDescriptor slmt_by_svc_array_descriptor = ArrayDescriptor.createDescriptor("IBAEHIS.SETT_DTLS", con);
		
		Object[] slmt_by_svc_record_array = new Object[total_records]; // to store n number of object data
		Object[] slmt_by_svc_object = new Object[11]; // to store object data
		
		int servCount=0;
		
		if(it!=null){
		   	while(it.hasNext()){
			
		   	BLBillSlmtServiceBean serviceBean=it.next();	
			slmt_by_svc_object[0] = serviceBean.getBillDocType();
			slmt_by_svc_object[1] = Integer.parseInt(serviceBean.getBillNumber());
			slmt_by_svc_object[2] = toDateFormat(serviceBean.getServiceDate(),1);
			slmt_by_svc_object[3] = serviceBean.getTrxDocRef();
			slmt_by_svc_object[4] = Integer.parseInt(serviceBean.getTrxDocRefLineNum());
			slmt_by_svc_object[5] = Integer.parseInt(serviceBean.getTrxDocRefSeqNum());
			slmt_by_svc_object[6] = serviceBean.getBillingService();
			slmt_by_svc_object[7] = Double.parseDouble(serviceBean.getChargeAmt());
			slmt_by_svc_object[8] = Double.parseDouble(serviceBean.getSettledAmt());
			slmt_by_svc_object[9] = Double.parseDouble(serviceBean.getUpdNetChargeAmt());
			slmt_by_svc_object[10] = serviceBean.getInclusionExclusionCriteria();
		
			System.out.println(Arrays.asList(slmt_by_svc_object));
		
			STRUCT slmt_by_svc_record = new STRUCT(slmt_by_svc_record_descriptor, con, slmt_by_svc_object);
			slmt_by_svc_record_array[servCount] = slmt_by_svc_record;
			
			servCount++;
			}
		}	
		ARRAY slmt_by_svc_parameter_array = new ARRAY(slmt_by_svc_array_descriptor, con, slmt_by_svc_record_array);
		System.out.println("SETT_BY_SERV - SETT_DTLS"+ Arrays.asList(slmt_by_svc_parameter_array));
	   /* Array of SETT_DTLS is Constructed Here - Ends */
	   
			
			try{
				pstmt = con.prepareStatement("select slmt_mode_wise_rcpt_yn from bl_parameters where operating_facility_id=?");
				pstmt.setString(1,facility_id);
				rs = pstmt.executeQuery();					
				if(rs != null && rs.next()){
					slmtModeWiseWcptYN = rs.getString(1);
				}
			}catch(SQLException ex){
				ex.printStackTrace();
			}finally{
				rs.close();
				pstmt.close();
			}
			
			String error_level = "";
			String error_id = "";
			String error_text = "";

			con.setAutoCommit(false);

			cst = con.prepareCall("call bill_slmt_cons_rcpt_pat_cust.populate_slmt_cons_rcpt(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			cst.setString(1, facility_id); // facility_id
			cst.setString(2, language_id); // language_id
			cst.setString(3, cust_code); // cust_code
			cst.setString(4, episode_type); // episode_type
			cst.setDouble(5, Double.parseDouble(slmt_amt)); // slmt_amt
			cst.setArray(6, bill_doc_numbers_parameter_array); // b_cnt // bill_dtls
			cst.setArray(7, slmt_mode_parameter_array); // slmt_cnt slmt_dtls
			cst.setArray(8, slmt_by_svc_parameter_array); // sett_serv	// sett_dtls
			cst.setArray(9, deposit_parameter_array); // dedtl dep_dtls
			cst.setString(10, user_id); // user_id
			cst.setString(11, ws_no); // ws_no
			cst.setDouble(12, Double.parseDouble(cash_amt_given)); // cash_amt_given
			cst.setDouble(13, Double.parseDouble(cash_amt_returned)); // cash_amt_returned
			cst.registerOutParameter(14, Types.VARCHAR); // slmt_doc_type_code
			cst.registerOutParameter(15, Types.INTEGER); // slmt_doc_num
			cst.registerOutParameter(16, Types.VARCHAR); //multiple_slmt_doc_numbers
			cst.registerOutParameter(17, Types.INTEGER); // error_level
			cst.registerOutParameter(18, Types.VARCHAR); // error_id
			cst.registerOutParameter(19, Types.VARCHAR); // error_text
			cst.execute();

			 error_level = cst.getString(17);
			 error_id = cst.getString(18);
			 error_text = cst.getString(19);

			 String slmt_doc_type_code_op=cst.getString(14);
			 String slmt_doc_num_op=cst.getString(15);
			 String multiple_slmt_doc_numbers=cst.getString(16);
			 System.out.println("|error_level:" + error_level + "|error_id:" + error_id + "|error_text: "+error_text);
			

			if (error_level != null || error_id != null || error_text != null) {
				con.rollback();
				JSONObject obj=new JSONObject();
				obj.put("flag","F");  
				obj.put("info",nullFormatter(error_id)+":"+nullFormatter(error_text));    
				out.print(obj);
				out.flush();
			}else{	
				con.commit();
				
				String receiptGeneratedString;
				if(slmtModeWiseWcptYN.equals("Y")){
					receiptGeneratedString="Multiple Settlement Receipt Generated "+ multiple_slmt_doc_numbers ;
				}else{
					receiptGeneratedString="Receipt Generated "+ slmt_doc_type_code_op +"\\" + slmt_doc_num_op;
				}
				
				JSONObject obj=new JSONObject();
				obj.put("flag","S");  
				obj.put("info",receiptGeneratedString);    
				out.print(obj);
				out.flush();
   				 }


System.out.println("PROCEDURE bill_slmt_cons_rcpt_pat_cust.populate_slmt_cons_rcpt EXECUTED SUCCESSFULLY");
     
} catch(Exception e) {
	con.rollback();
    System.out.println(e);
	JSONObject obj=new JSONObject();
	obj.put("flag","F");  
	obj.put("info","Exception has Occured in Bill Settlement");    
	out.print(obj);
	out.flush();
}finally{
	if(cst!=null){
	cst.close();
	}
	if(con!=null){
	con.close();
	}
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
