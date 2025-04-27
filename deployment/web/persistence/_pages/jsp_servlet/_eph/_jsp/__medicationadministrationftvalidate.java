package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.Common.*;
import ePH.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __medicationadministrationftvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MedicationAdministrationFTValidate.jsp", 1721967571144L ,"10.3.6.0","Asia/Calcutta")) return true;
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

try{

	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends

	
	//    String locale         = (String)session.getAttribute("LOCALE");//Added for SKR-SCF-0913[Inc:46556]
	String facility_id = (String)session.getValue( "facility_id" );//GHL-CRF-0458
	String identity		  = request.getParameter( "identity" );
	String bean_id		  = request.getParameter( "bean_id" ) ;
	String bean_name	  = request.getParameter( "bean_name" ) ;
	Hashtable hash		  = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				  = (Hashtable)hash.get( "SEARCH" ) ;

	if(identity.equals("validateForMultiStrength")){
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,  bean_name, request ) ;	
		String drug_code = (String)hash.get("drug_code");
		String multi_strength= bean.validateForMultiStrength(drug_code);
		out.println(multi_strength);
		putObjectInBean(bean_id,bean,request);
	}
	else if(identity.equals("amendDrugDetails")){
		String admin_bean_id	=	"MedicationAdministrationBean";
		String admin_bean_name=	"ePH.MedicationAdministrationBean";		
		MedicationAdministrationBean admin_bean = (MedicationAdministrationBean)getBeanObject( admin_bean_id, admin_bean_name, request ) ;	
		
		String drug_code	=(String) hash.get("drug_code");
		String srl_no		=(String) hash.get("srl_no");
		String dose_qty		=(String) hash.get("dose_qty");
		String qty_uom		=(String) hash.get("qty_desc");
		String route_code	=(String) hash.get("route_code");
		String freq_code	=(String) hash.get("freq_code");
		String admin_date_time=(String) hash.get("admin_date_time");
		String route_desc	=(String) hash.get("route_desc");
		String freq_desc	=(String) hash.get("freq_desc");
		String batch_id		=(String) hash.get("batch_id");
		String expiry_date	=(String) hash.get("expiry_date");
		String trade_name	=(String) hash.get("trade_name");
			
		ArrayList newDrugDoseTimeDetails=new ArrayList();
		newDrugDoseTimeDetails= admin_bean.getnewDrugDetails();
		HashMap drugDetails   = new HashMap();
		String drugCode		  = "";
		String srlNo          = "";
		if(newDrugDoseTimeDetails.size()>0){
			for(int i=0;i<newDrugDoseTimeDetails.size();i++){
				drugDetails=new HashMap();
				drugDetails=(HashMap) newDrugDoseTimeDetails.get(i);
				drugCode   =(String) drugDetails.get("DRUG_CODE");
				srlNo      =(String) drugDetails.get("SRL_NO");
				if( drug_code.trim().equals(drugCode.trim()) && srl_no.trim().equals(srlNo.trim())){
					drugDetails.put("DOSE_QTY",dose_qty);
					drugDetails.put("QTY_UOM",qty_uom);
					drugDetails.put("ROUTE_CODE",route_code);
					drugDetails.put("FREQ_CODE",freq_code);
					drugDetails.put("ADMIN_DATE_TIME",admin_date_time);
					drugDetails.put("ROUTE_DESC",route_desc);
					drugDetails.put("FREQ_DESC",freq_desc);
					drugDetails.put("BATCH_ID",batch_id);
					drugDetails.put("EXPIRY_DATE",expiry_date);
					drugDetails.put("TRADE_NAME",trade_name);
				}
			}
		}
		putObjectInBean(admin_bean_id,admin_bean,request);
	}
	else if(identity.equals("storeAuthUserInBean")){ // Added for RUT-CRF-0035 [IN029926]  --begin
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,  bean_name, request ) ;	
		String auth_user_id = (String) hash.get( "auth_user_id" );
		bean.setAuthUserID(auth_user_id);
		out.println("1");
	} // Added for RUT-CRF-0035 [IN029926] end
	else if(identity.equals("taperCurrRow")){ // Added for RUT-CRF-0088 [IN:036978] 
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,  bean_name, request ) ;	
		int index = Integer.parseInt(hash.get( "index" ).toString());
		int inc = Integer.parseInt(hash.get( "inc" ).toString());
		HashMap drug_details=(HashMap) bean.getDrugDetails_Added();
		ArrayList non_iv_drug_dtls= (ArrayList) drug_details.get("NON_IV");
		List selectedDrugDtls= non_iv_drug_dtls.subList(index, index+inc);
		ArrayList newTaperRecord = new ArrayList(selectedDrugDtls);
		newTaperRecord.set(21,"N");//administered
		newTaperRecord.set(22,"N");//admin recordered
		newTaperRecord.set(23,"");//admin remarks
		newTaperRecord.set(24,"");//admindrugdetails
		newTaperRecord.set(25,"");
		newTaperRecord.set(26,"");
		if(newTaperRecord.size()==78){
			newTaperRecord.set(58,"Y");  // Brought by patient
			newTaperRecord.set(62,"Y");  // Brought by patient
		}
		else
			newTaperRecord.set(52,"Y");  // Brought by patient
	//	String facility_id = (String)session.getValue( "facility_id" );
		String encounter_id = (String)hash.get( "encounter_id" );
		String order_id = (String)newTaperRecord.get(13);
		String drug_code = (String)newTaperRecord.get(28);
		String sch_date_time = (String)newTaperRecord.get(16);
//		String dosage_seq_no = (String)newTaperRecord.get(17);//unused variable
		non_iv_drug_dtls.addAll(index+inc, newTaperRecord);
		bean.setDrugDetails(drug_details);
		bean.setTaperedRowNum(index);
		bean.addTaperSchedule(facility_id+"~"+encounter_id+"~"+order_id+"~"+drug_code+"~"+sch_date_time);
		out.println("reloadTaper('"+index+"')");
	}
	else if(identity.equals("deleteDrugDetails")){
		
		String admin_bean_id  =	"MedicationAdministrationBean";
		String admin_bean_name=	"ePH.MedicationAdministrationBean";		
		MedicationAdministrationBean admin_bean = (MedicationAdministrationBean)getBeanObject( admin_bean_id,admin_bean_name , request) ;	

		String drug_code	=(String) hash.get("drug_code");
		String srl_no		=(String) hash.get("srl_no");
		
		ArrayList newDrugDoseTimeDetails=new ArrayList();
		newDrugDoseTimeDetails=admin_bean.getnewDrugDetails();
		HashMap drugDetails=new HashMap();
		String drugCode    ="";
		String srlNo	   ="";
		if(newDrugDoseTimeDetails.size()>0){
			for(int i=0;i<newDrugDoseTimeDetails.size();i++){
				drugDetails= new HashMap();
				drugDetails= (HashMap) newDrugDoseTimeDetails.get(i);
				drugCode   = (String) drugDetails.get("DRUG_CODE");
				srlNo      = (String) drugDetails.get("SRL_NO");
				if( drug_code.trim().equals(drugCode.trim()) && srl_no.trim().equals(srlNo.trim())){
					drugDetails.put("DRUG_CODE","");
					drugDetails.put("SRL_NO","");
					drugDetails.put("DOSE_QTY","");
					drugDetails.put("QTY_UOM","");
					drugDetails.put("ROUTE_CODE","");
					drugDetails.put("FREQ_CODE","");
					drugDetails.put("ADMIN_DATE_TIME","");
					drugDetails.put("ROUTE_DESC","");
					drugDetails.put("FREQ_DESC","");
					drugDetails.put("BATCH_ID","");
					drugDetails.put("EXPIRY_DATE","");
					drugDetails.put("TRADE_NAME","");
				}
			}
		}
		putObjectInBean(admin_bean_id,admin_bean,request);
	}
	else if(identity.equals("storeDrugDetails")){
				
		String admin_bean_id	=	"MedicationAdministrationBean";
		String admin_bean_name=	"ePH.MedicationAdministrationBean";		
		MedicationAdministrationBean admin_bean = (MedicationAdministrationBean)getBeanObject( admin_bean_id,admin_bean_name, request ) ;	
		String drug_code	=(String) hash.get("drug_code");
		String drug_name	=(String) hash.get("drug_desc");
		String pract_name	=(String) hash.get("pract_name");
		String pract_id		=(String) hash.get("pract_id");
		String dose_qty		=(String) hash.get("dose_qty");
		String qty_uom		=(String) hash.get("qty_desc");
		String route_code	=(String) hash.get("route_code");
		String freq_code	=(String) hash.get("freq_code");
		String admin_date_time=(String) hash.get("admin_date_time");
		String route_desc	=(String) hash.get("route_desc");
		String freq_desc	=(String) hash.get("freq_desc");
		String batch_id		=(String) hash.get("batch_id");
		String expiry_date	=(String) hash.get("expiry_date");
		String trade_name	=(String) hash.get("trade_name");
		ArrayList DrugDoseTimeDetails=new ArrayList();
		DrugDoseTimeDetails=admin_bean.getnewDrugDetails();
		HashMap DoseDetails=new HashMap();
		int srl_no=DrugDoseTimeDetails.size();
		srl_no=srl_no+1;

		DoseDetails.put("PRACT_NAME",pract_name);
		DoseDetails.put("PRACT_ID",pract_id);
		DoseDetails.put("DRUG_CODE",drug_code);
		DoseDetails.put("SRL_NO",String.valueOf(srl_no));
		DoseDetails.put("DRUG_NAME",drug_name);
		DoseDetails.put("PRACT_ID",pract_id);
		DoseDetails.put("DOSE_QTY",dose_qty);
		DoseDetails.put("QTY_UOM",qty_uom);
		DoseDetails.put("ROUTE_CODE",route_code);
		DoseDetails.put("FREQ_CODE",freq_code);
		DoseDetails.put("ADMIN_DATE_TIME",admin_date_time);
		DoseDetails.put("ROUTE_DESC",route_desc);
		DoseDetails.put("FREQ_DESC",freq_desc);
		DoseDetails.put("BATCH_ID",batch_id);
		DoseDetails.put("EXPIRY_DATE",expiry_date);
		DoseDetails.put("TRADE_NAME",trade_name);
		admin_bean.setnewDrugDetails(DoseDetails);

		out.println(admin_bean.getnewDrugDetails());

		putObjectInBean(admin_bean_id,admin_bean,request);
	}
	else if(identity.equals("validateForBatchID")){
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,bean_name , request) ;	
		String item_code = (String)hash.get("item_code");
		String mode = (String)hash.get("mode");
		String batch_id	 = (String)hash.get("batch_id");
		String row_no	 = (String)hash.get("row_no");
		String drugtype  = (String)hash.get("drugtype");
		HashMap batch_details = bean.validateForBatchID(item_code,batch_id);
		if(batch_details.size()==0){
			out.println("alertForInvalidBatch('"+row_no+"','"+mode+"','"+drugtype+"')");
		}else{
			if(((String)batch_details.get("EXPIRED")).equals("Y")){
				out.println("alertForExpiredBatch('"+row_no+"','"+mode+"','"+drugtype+"')");
			}else{
				//String trade_id	   = (String)batch_details.get("TRADE_ID");
				String trade_name  = (String)batch_details.get("TRADE_NAME");
				String expiry_date = (String)batch_details.get("EXPIRY_DATE");
				if(trade_name==null) trade_name="";
				if(expiry_date==null) expiry_date="";
				out.println("assignTradeAndExpiryDate('"+trade_name+"','"+expiry_date+"','"+row_no+"','"+mode+"','"+drugtype+"')");
			}
		}
		putObjectInBean(bean_id,bean,request);
	}
	else if(identity.equals("validateNewEntryBatchID")){
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,bean_name, request ) ;	
		String drug_code = request.getParameter("drug_code");
		String batch_id = request.getParameter("batch_id");		
		HashMap batch_details = bean.validateNewEntryBatchID(drug_code,batch_id);
		if(batch_details.size()==0){
			out.println("alertForInvalidBatch('','')");
		}
		else{
			if(((String)batch_details.get("EXPIRED")).equals("Y")){
				out.println("alertForExpiredBatch('','')");
			}
			else{
				//String trade_id	   = (String)batch_details.get("TRADE_ID");
				String trade_name  = (String)batch_details.get("TRADE_NAME");
				String expiry_date = (String)batch_details.get("EXPIRY_DATE");
				if(trade_name==null) trade_name="";
				if(expiry_date==null) expiry_date="";
				out.println("assignTradeAndExpiryDate('"+trade_name+"','"+expiry_date+"','','')");
			}
		}
		putObjectInBean(bean_id,bean,request);
	}
	else if(identity.equals("saveRemarksForDrug")){
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,bean_name, request ) ;	

		String row_no			 = (String)hash.get("row_no");
		String drug_code		 = (String)hash.get("drug_code");
		String reason_code		 = (String)hash.get("reason_code");
		String remarks			 = (String)hash.get("remarks");
		String admn_dose_chng_reason_code	= (String) hash.get("admn_dose_chng_reason_code");
		String admn_dose_chng_reason	= (String) hash.get("admn_dose_chng_reason");
		String administered_by	 = hash.get("administered_by")==null?"":(String)hash.get("administered_by");	
		String order_id			 = hash.get("order_id")==null?"":(String)hash.get("order_id");	
		String order_line_num	 = hash.get("order_line_num")==null?"":(String)hash.get("order_line_num");	
		String encounter_id		 = hash.get("encounter_id")==null?"":(String)hash.get("encounter_id");	
		String authorized_by	 = hash.get("authorized_by")==null?"":(String)hash.get("authorized_by");
		String next_admin		 = hash.get("next_admin")==null?"":(String)hash.get("next_admin");
		String callFrom		 = hash.get("callFrom")==null?"":(String)hash.get("callFrom");
		String couldNotAdmin		 = hash.get("couldNotAdmin")==null?"":(String)hash.get("couldNotAdmin");

		remarks = java.net.URLDecoder.decode(remarks,"UTF-8");
		ArrayList arr_list_remarks		 = new ArrayList();
		arr_list_remarks.add(reason_code); //0
		arr_list_remarks.add(remarks);
		arr_list_remarks.add(administered_by);
		arr_list_remarks.add(authorized_by);
		arr_list_remarks.add(next_admin);
		arr_list_remarks.add(admn_dose_chng_reason_code); //5
		arr_list_remarks.add(admn_dose_chng_reason);
		if(couldNotAdmin.equals("Y") && callFrom.equals("SCH") ){
			String admin_bean_id	=	"MedicationAdministrationBean";
			String admin_bean_name=	"ePH.MedicationAdministrationBean";		
			MedicationAdministrationBean admin_bean = (MedicationAdministrationBean)getBeanObject( admin_bean_id,admin_bean_name, request ) ;	
			String dosage_seq		 = hash.get("dosage_seq")==null?"":(String)hash.get("dosage_seq");
			String sch_date_time		 = hash.get("sch_date_time")==null?"":(String)hash.get("sch_date_time");
//			String scheKey		 = hash.get("scheKey")==null?"":(String)hash.get("scheKey"); //unused variable
			String nursing_unit		 = hash.get("nursing_unit")==null?"":(String)hash.get("nursing_unit");
			String assign_bed_num		 = hash.get("assign_bed_num")==null?"":(String)hash.get("assign_bed_num");
			arr_list_remarks.add(assign_bed_num); //7
			arr_list_remarks.add(nursing_unit);
			arr_list_remarks.add(row_no);
			arr_list_remarks.add(drug_code); //10
			arr_list_remarks.add(order_id);
			arr_list_remarks.add(order_line_num); //12
			arr_list_remarks.add(encounter_id);
			arr_list_remarks.add(dosage_seq);
			arr_list_remarks.add(sch_date_time); //15
			HashMap resultMap = admin_bean.recordCouldNotAdmin(arr_list_remarks);
			if(resultMap!=null && resultMap.containsKey("result")){
				if((Boolean)resultMap.get("result")){
					out.println("window.returnValue = 'OK'");
				}
			}
		}
		else{
			bean.saveRemarksForDrug(row_no,drug_code,arr_list_remarks);
			if(!order_id.equals("") && !encounter_id.equals("")){
				arr_list_remarks.add(row_no); //0
				arr_list_remarks.add(drug_code);
				arr_list_remarks.add(order_id);
				arr_list_remarks.add(encounter_id);
				bean.setRemarks(arr_list_remarks);
			}
			out.println("assignAdminTime('"+next_admin+"','"+java.net.URLEncoder.encode(remarks,"UTF-8")+"','"+callFrom+"')");
			putObjectInBean(bean_id,bean,request);
		}
	}
	else if(identity.equals("validateRemarksForDrug")){
		bean_id	=	"MedicationAdministrationFTBean";
		bean_name=	"ePH.MedicationAdministrationFTBean";		
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,bean_name, request ) ;	
		String row_no = (String)hash.get("row_no");
		String drug_code = (String)hash.get("drug_code");
		out.println(bean.validateDrugRemarks(drug_code,row_no));		
		putObjectInBean(bean_id,bean,request);
	}
	else if(identity.equals("getBatchDetails")){
		bean_id	=	"MedicationAdministrationFTBean";
		bean_name=	"ePH.MedicationAdministrationFTBean";			
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,bean_name, request ) ;	
		String batch_id = request.getParameter("batch_id");
		out.println(bean.getBatchDetails(batch_id));

		putObjectInBean(bean_id,bean,request);
	}
	else if(identity.equals("showAdminToDate")){
		bean_id	=	"MedicationAdministrationFTBean";
		bean_name=	"ePH.MedicationAdministrationFTBean";			
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,  bean_name, request ) ;	
		String current_date_time = (String)hash.get("current_date_time");
		String date_time = bean.getToDateTime(current_date_time);
		out.println("assignAdminToDate('"+date_time+"')");

		putObjectInBean(bean_id,bean,request);
	}
	else if(identity.equals("showAdminFromDate")){
		bean_id	=	"MedicationAdministrationFTBean";
		bean_name=	"ePH.MedicationAdministrationFTBean";			
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,  bean_name, request ) ;	
		String current_date_time = (String)hash.get("current_date_time");
		String date_time = bean.getFromDateTime(current_date_time);
		out.println("assignAdminFromDate('"+date_time+"')");

		putObjectInBean(bean_id,bean,request);
	}
	else if(identity.equals("getPinNumberForRemarks")){		
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,  bean_name, request ) ;	
		String user_pin = bean.getPinNumber((String)hash.get("user_id"));		
		out.println(user_pin);
		putObjectInBean(bean_id,bean,request);
	}
	else if(identity.equals("deleteRemarksForDrug")){
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,bean_name, request ) ;	

		String row_no			 = (String)hash.get("row_no");
		String drug_code		 = (String)hash.get("drug_code");
		ArrayList arr_list_remarks1		=   new ArrayList();
		ArrayList arr_list_remarks2		=   new ArrayList();
		arr_list_remarks1 =bean.getRemarksForDrug(drug_code,row_no);
		for(int i=0; i<arr_list_remarks1.size();i++){
			if(i==7){
				bean.saveRemarksForDrug(row_no,drug_code,arr_list_remarks2);
			}
			if(i==5 || i==6)
				arr_list_remarks2.add("");
			else
				arr_list_remarks2.add(arr_list_remarks1.get(i));
		}
		bean.setRemarks(arr_list_remarks2);
	}
	else if(identity.equals("getAdminRouteDetails")){
		bean_id	=	"MedicationAdministrationFTBean";
		bean_name=	"ePH.MedicationAdministrationFTBean";			
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,bean_name, request ) ;	
		String route_categ_code = request.getParameter("route_categ_code");
		ArrayList rt_code=bean.getAdminRoute(route_categ_code);
		for(int ival=0;ival<rt_code.size();ival+=2)
			out.println("AddAdminRoutes('"+rt_code.get(ival)+"','"+rt_code.get(ival+1)+"')");
		putObjectInBean(bean_id,bean,request);
	}
	else if(identity.equals("updateMFR")){
		bean_id	=	"MedicationAdministrationFTBean";
		bean_name=	"ePH.MedicationAdministrationFTBean";			
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,bean_name, request ) ;	
		String order_id = request.getParameter("order_id");
		String srl_no = request.getParameter("srl_no");
		String actionTime = request.getParameter("actionTime");
		String actionBy = request.getParameter("actionBy");
		String actionRemarks = request.getParameter("actionRemarks");
		String iv_flow_rate = hash.get("iv_flow_rate")==null?"":(String)hash.get("iv_flow_rate");

		if(!actionRemarks.equals("")){
			actionRemarks=java.net.URLDecoder.decode(actionRemarks,"UTF-8");
		}
		String mfr_status = request.getParameter("mfr_status");
		HashMap mfrdtls=new HashMap();
		mfrdtls.put("order_id",order_id);
		mfrdtls.put("srl_no",srl_no);
		mfrdtls.put("actionTime",actionTime);
		mfrdtls.put("actionBy",actionBy);
		mfrdtls.put("actionRemarks",actionRemarks);
		mfrdtls.put("mfr_status",mfr_status);
		mfrdtls.put("iv_flow_rate",iv_flow_rate);
		bean.addMFRAudigLogList(mfrdtls);				
		putObjectInBean(bean_id,bean,request);
	}
	else if(identity.equals("updateMFRDetails")){
		bean_id	=	"MedicationAdministrationFTBean";
		bean_name=	"ePH.MedicationAdministrationFTBean";			
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,bean_name, request ) ;
		int sizeofdata = Integer.parseInt((String)hash.get("serialNum"));
		String order_id = (String)hash.get("order_id");
		String store_code = (String)hash.get("store_code");
		String drug_code = (String)hash.get("drug_code");
		String nxtScheduledDate = (String)hash.get("nxtScheduledDate");
		String sch_infusion_vol_str_unit = (String)hash.get("sch_infusion_vol_str_unit");
		String nursing_unit = (String)hash.get("nursing_unit");
		String callFrom = (String)hash.get("callFrom")==null?"":(String)hash.get("callFrom");
		HashMap mapMFRDetails;
		ArrayList listMFRDetails=new ArrayList();
		listMFRDetails.add(order_id);
		listMFRDetails.add(store_code);
		listMFRDetails.add(drug_code);
		listMFRDetails.add(nxtScheduledDate);
		listMFRDetails.add(sch_infusion_vol_str_unit);
		listMFRDetails.add(nursing_unit);
		for(int i=1;i<=sizeofdata;i++){
			mapMFRDetails   = new HashMap();
			mapMFRDetails.put("MARStatus",(String)hash.get("MARStatus"+i));
			mapMFRDetails.put("holdMinutes",(String)hash.get("holdMinutes"+i));
			mapMFRDetails.put("gaphours",(String)hash.get("gaphours"+i));
			mapMFRDetails.put("holdDateTime",(String)hash.get("holdDateTime"+i));
			mapMFRDetails.put("infusion_date_time",(String)hash.get("infusion_date_time"+i));
			mapMFRDetails.put("infusion_end_date",(String)hash.get("infusion_end_date"+i));
			mapMFRDetails.put("inf_prd",(String)hash.get("inf_prd"+i));
			mapMFRDetails.put("MFR_flow_rate",(String)hash.get("MFR_flow_rate"+i));
			mapMFRDetails.put("MFR_batch_id",(String)hash.get("MFR_batch_id_"+i));
			mapMFRDetails.put("MFR_exp_dt",(String)hash.get("MFR_exp_dt_"+i));
			mapMFRDetails.put("srl_no",(String)hash.get("srl_no"+i));
			mapMFRDetails.put("resumeDateTime",(String)hash.get("resumeDateTime"+i));
			mapMFRDetails.put("completedMinutes",(String)hash.get("completedMinutes"+i));
			mapMFRDetails.put("completedFlow",(String)hash.get("completedFlow"+i));
			mapMFRDetails.put("Newly_Admin",(String)hash.get("Newly_Admin_"+i));
			mapMFRDetails.put("iv_trade_id",(String)hash.get("iv_trade_id_"+i));
			mapMFRDetails.put("iv_bin_code",(String)hash.get("iv_bin_code_"+i));
			mapMFRDetails.put("inf_volume",(String)hash.get("inf_volume_"+i));
			mapMFRDetails.put("tot_strength_uom",(String)hash.get("tot_strength_uom"+i));
			mapMFRDetails.put("iv_flow_rate",(String)hash.get("iv_flow_rate"+i));
			listMFRDetails.add(mapMFRDetails);
			mapMFRDetails=null;
		}
		boolean inserted=bean.insertMFRAuditLog();
		boolean updated=bean.updateMFRDetails(listMFRDetails);
		ArrayList mfrdetails = new ArrayList();
		String statusStringNew="";
		String completedStatus="";
		if(updated)
			mfrdetails = bean.getStatusOfMAR(order_id,callFrom);
		if(mfrdetails.size()>0){
			statusStringNew =(String)mfrdetails.get(0);
			completedStatus =(String)mfrdetails.get(1);
		}
		out.println("assignMFRDetailsToParentWindow('"+statusStringNew+"','"+completedStatus+"')");
		putObjectInBean(bean_id,bean,request);
		bean.updateStockForMFR(listMFRDetails);
	}
	else if(identity.equals("clearMFRLog")){
		bean_id	=	"MedicationAdministrationFTBean";
		bean_name=	"ePH.MedicationAdministrationFTBean";			
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,bean_name, request ) ;
		bean.clearMFRAudigLogList();
		putObjectInBean(bean_id,bean,request);
	}
	else if(identity.equals("updateSFR")){
		bean_id	=	"MedicationAdministrationFTBean";
		bean_name=	"ePH.MedicationAdministrationFTBean";			
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,bean_name, request ) ;	
		String order_id = request.getParameter("order_id");
		String srl_no = request.getParameter("srl_no");
		String actionTime = request.getParameter("actionTime");
		String actionBy = request.getParameter("actionBy");
		String actionRemarks = request.getParameter("actionRemarks");
		String callFrom = request.getParameter("callFrom")==null?"":request.getParameter("callFrom");
		//if(!actionRemarks.equals(""))
		//{
		//	actionRemarks=java.net.URLDecoder.decode(actionRemarks,"UTF-8");
		//}
		String sfr_status = request.getParameter("sfr_status");
		String holdMinutes = (String)hash.get("holdMinutes");
		String holdDateTime = (String)hash.get("holdDateTime");
		String infusion_date_time = (String)hash.get("infusion_date_time");
		String infusion_end_date = (String)hash.get("infusion_end_date");
		String resumeDateTime = (String)hash.get("resumeDateTime");
		String completed_durn_in_mins = (String)hash.get("completed_durn_in_mins");
		String completed_volume = (String)hash.get("completed_volume");
		String iv_infusion_period = (String)hash.get("iv_infusion_period");
		String iv_flow_rate = (String)hash.get("iv_flow_rate");
		String iv_sch_admin_date_time = (String)hash.get("iv_sch_admin_date_time");
		/*if(!locale.equals("en")){//Added if condition for SKR-SCF-0913[Inc:46556]
		    	iv_sch_admin_date_time=com.ehis.util.DateUtils.convertDate(iv_sch_admin_date_time,"DMYHM",locale,"en");    
	     	}*/// commented for LEAP-INT-PH-SCF-14965 [IN057864]
		String iv_prep_yn = hash.get("iv_prep_yn")==null?"":(String)hash.get("iv_prep_yn");
		String encounter_id = hash.get("encounter_id")==null?"":(String)hash.get("encounter_id");
		String next_schd_date = hash.get("next_schd_date")==null?"":(String)hash.get("next_schd_date");
		String iv_drug_code = hash.get("iv_drug_code")==null?"":(String)hash.get("iv_drug_code");
//		String flow_rate_changed_YN = hash.get("flow_rate_changed_YN")==null?"":(String)hash.get("flow_rate_changed_YN"); //unused variable
		if(!(callFrom.equals("SCH") && sfr_status.equals("AD"))){ //commented & added below condition for AAKH-SCF-0140 [IN:050756] //uncommeted for AAKH-SCF-0152
		//if(!callFrom.equals("SCH") ){ //commneted for AAKH-SCF-0152
			HashMap sfrlogdtls=new HashMap();
			sfrlogdtls.put("order_id",order_id);
			sfrlogdtls.put("srl_no",srl_no);
			sfrlogdtls.put("actionTime",actionTime);
			sfrlogdtls.put("actionBy",actionBy);
			sfrlogdtls.put("actionRemarks",actionRemarks);
			sfrlogdtls.put("mfr_status",sfr_status);
			sfrlogdtls.put("iv_sch_admin_date_time",iv_sch_admin_date_time);
			sfrlogdtls.put("iv_flow_rate",iv_flow_rate);
			bean.addMFRAudigLogList(sfrlogdtls);				
			bean.insertMFRAuditLog();				
			bean.clearMFRAudigLogList();
		}
		HashMap sfrDtls=new HashMap();
		sfrDtls.put("order_id",order_id);
		sfrDtls.put("order_line_no","1");
		sfrDtls.put("SFR_Status",sfr_status);
		sfrDtls.put("holdMinutes",holdMinutes);
		sfrDtls.put("holdDateTime",holdDateTime);
		sfrDtls.put("infusion_date_time",infusion_date_time);
		sfrDtls.put("infusion_end_date",infusion_end_date);
		sfrDtls.put("resumeDateTime",resumeDateTime);
		sfrDtls.put("srl_no",srl_no);
		sfrDtls.put("completed_durn_in_mins",completed_durn_in_mins);
		sfrDtls.put("completed_volume",completed_volume);
		sfrDtls.put("iv_infusion_period",iv_infusion_period);
		sfrDtls.put("iv_flow_rate",iv_flow_rate);
		sfrDtls.put("iv_prep_yn",iv_prep_yn);
		sfrDtls.put("iv_sch_admin_date_time",iv_sch_admin_date_time);
		sfrDtls.put("encounter_id",encounter_id);
		sfrDtls.put("next_schd_date",next_schd_date);
		sfrDtls.put("iv_drug_code",iv_drug_code);
		boolean inserted = false;
		if(callFrom.equals("SCH") && (sfr_status.equals("ST") || sfr_status.equals("AD") || sfr_status.equals("CH"))){
			inserted=bean.insertSFRDetailsSCH(sfrDtls);
			if(inserted && sfr_status.equals("AD")){
				out.println("recInserted = '"+inserted+"';");
			}
			if(!inserted)
				out.println("alert(getMessage('EXCEPTION_OCCURED_WHILE_INSERTION','PH'));"); 
		}
		else
			inserted=bean.insertSFRDetails(sfrDtls);
		putObjectInBean(bean_id,bean,request);
	}
	else if(identity.equals("calcQtyInDispUOM")){
		bean_id	=	"MedicationAdministrationFTBean";
		bean_name=	"ePH.MedicationAdministrationFTBean";			
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,bean_name, request ) ;
		String drug_code = request.getParameter("drug_code");
		String qty = request.getParameter("qty");
		String qtyUom = request.getParameter("qtyUom");
		String prescribeMode = request.getParameter("prescribeMode");
		String order_id = request.getParameter("order_id");
		String order_line_no = request.getParameter("order_line_no");
		String iv = request.getParameter("iv");
		String row_no = request.getParameter("row_no");
		ArrayList returnlist=bean.getQtyUOM(drug_code,qty,qtyUom,prescribeMode,order_id,order_line_no);
		String quantityInDispenseUnit="";
		if(returnlist.size()>0)
			quantityInDispenseUnit =(String)returnlist.get(0);
		out.println("AssignQuantityInDispensingMode('"+quantityInDispenseUnit+"','"+iv+"','"+row_no+"');");

		putObjectInBean(bean_id,bean,request);
	}
	else if(identity.equals("getDateRangeDef")){
		String viewBy = hash.get("viewBy")==null?"W":(String)hash.get("viewBy");
		String admin_bean_id	=	"MedicationAdministrationBean";
		String admin_bean_name=	"ePH.MedicationAdministrationBean";
		String from_date="", to_date="";
		MedicationAdministrationBean admin_bean = (MedicationAdministrationBean)getBeanObject( admin_bean_id, admin_bean_name, request ) ;	
		HashMap hmSchMARDtl = admin_bean.getSchMARParams();
		if(hmSchMARDtl!=null & hmSchMARDtl.size()>0){
			if(viewBy.equals("M")){
				from_date = (String)hmSchMARDtl.get("MONTH_START");
				to_date =(String) hmSchMARDtl.get("MONTH_END");
			}
			else{
				from_date = (String)hmSchMARDtl.get("FROM_DATE");
				to_date =(String) hmSchMARDtl.get("TO_DATE");
			}
		}
		if(!from_date.equals("") && !to_date.equals("")){
			out.println("assignDateRange('"+from_date+"','"+to_date+"');");
		}
	}
	else if(identity.equals("getPrevNextDateRange")){
		String viewBy = hash.get("viewBy")==null?"W":(String)hash.get("viewBy");
		String fromDate = hash.get("fromDate")==null?"":(String)hash.get("fromDate");
		String toDate = hash.get("toDate")==null?"":(String)hash.get("toDate");
		String navigation = hash.get("navigation")==null?"":(String)hash.get("navigation");
		String admin_bean_id	=	"MedicationAdministrationBean";
		String admin_bean_name=	"ePH.MedicationAdministrationBean";
		MedicationAdministrationBean admin_bean = (MedicationAdministrationBean)getBeanObject( admin_bean_id, admin_bean_name, request ) ;	
		String[] navDateRange = admin_bean.getNavigateDateRange(fromDate, toDate,viewBy,navigation  );
		if(navDateRange!=null & navDateRange.length>1){
			fromDate = navDateRange[0];
			toDate =navDateRange[1];
		}
		if(!fromDate.equals("") && !toDate.equals("")){
			out.println("assignDateRange('"+fromDate+"','"+toDate+"');");
		}
	}
	else if(identity.equals("recordHoldDiscont")){
		String admin_bean_id	=	"MedicationAdministrationBean";
		String admin_bean_name=	"ePH.MedicationAdministrationBean";		
		MedicationAdministrationBean admin_bean = (MedicationAdministrationBean)getBeanObject( admin_bean_id,admin_bean_name, request ) ;	
		String reason_code		 = hash.get("reason_code")==null?"":(String)hash.get("reason_code");
		String remarks		 = hash.get("remarks")==null?"":(String)hash.get("remarks");
		String patient_id		 = hash.get("patient_id")==null?"":(String)hash.get("patient_id");
		String callFor		 = hash.get("callFor")==null?"":(String)hash.get("callFor");
		String order_id		 = hash.get("order_id")==null?"":(String)hash.get("order_id");
		String order_line_no		 = hash.get("order_line_no")==null?"":(String)hash.get("order_line_no");
		String sch_date_time		 = hash.get("sch_date_time")==null?"":(String)hash.get("sch_date_time");
		ArrayList alHoldDiscDetails = new ArrayList();
		alHoldDiscDetails.add(callFor);
		alHoldDiscDetails.add(reason_code);
		alHoldDiscDetails.add(java.net.URLDecoder.decode(remarks,"UTF-8"));
		alHoldDiscDetails.add(order_id);
		alHoldDiscDetails.add(order_line_no);
		alHoldDiscDetails.add(patient_id);
		alHoldDiscDetails.add(sch_date_time);
		HashMap resultMap = null;
		if(callFor.equals("HD"))
			resultMap = admin_bean.recordHold(alHoldDiscDetails);
		else if (callFor.equals("DC"))
			resultMap = admin_bean.recordDiscontinue(alHoldDiscDetails);
		if(resultMap!=null && resultMap.containsKey("result")){
			if((Boolean)resultMap.get("result"))
				out.println("window.returnValue = 'OK'");
		}
	}
	else if(identity.equals("ValidBatchId")){ // Added for AAKH-CRF-0084 [IN060429] - Start		
		String batch_id = hash.get("batch_id")==null?"":(String)hash.get("batch_id");
		String order_id = hash.get("order_id")==null?"":(String)hash.get("order_id");
		String item_code = hash.get("item_code")==null?"":(String)hash.get("item_code");//PMG2017-MMS-CRF-0002 
		String drug_code = hash.get("drug_code")==null?"":(String)hash.get("drug_code");//PMG2017-MMS-CRF-0002
		String order_line_no = hash.get("order_line_no")==null?"":(String)hash.get("order_line_no");
		String iv_prep_yn    = hash.get("iv_prep_yn")==null?"":(String)hash.get("iv_prep_yn");//MMS-KH-CRF-0017
		String patient_id    = hash.get("patient_id")==null?"":(String)hash.get("patient_id");//MMS-KH-CRF-0017
		boolean validBatchId = false;//PMG2017-MMS-CRF-0002
		bean_id	=	"MedicationAdministrationFTBean";
		bean_name=	"ePH.MedicationAdministrationFTBean";			
		MedicationAdministrationFTBean bean_1 = (MedicationAdministrationFTBean)getBeanObject( bean_id,bean_name, request ) ;
		//PMG2017-MMS-CRF-0002 - start
		boolean site_spec_yn	= bean_1.isSiteSpecific("PH", "VERIFY_ADM_DRUG");//3/22/2017


		if(site_spec_yn==true){
System.err.println("MedicationAdministrationFTValidate.jsp======item_code===654=>"+item_code+"==drug_code==>"+drug_code);			
			if(!item_code.equals("")){
				if(item_code.equals(drug_code)){
					validBatchId = bean_1.IsValidBatch(batch_id,order_id,order_line_no,true,item_code,iv_prep_yn,patient_id); //iv_prep_yn,patient_id added for MMS-KH-SCF-0017
			
				}else{
					//ArrayList multi_drugs = bean_1.getAlternateDrugMAR(order_id,order_line_no);
					if(iv_prep_yn.equals("2") || iv_prep_yn.equals("4") ||iv_prep_yn.equals("6") ||iv_prep_yn.equals("0") || iv_prep_yn.equals("8")){ //added for MMS-KH-CRF-0017 - start and modified for MMS-CRF-17.1
					validBatchId = bean_1.IsValidBatch(batch_id,order_id,order_line_no,true,item_code,iv_prep_yn,patient_id); 
					}else{ //added for MMS-KH-CRF-0017 - end
					ArrayList multi_drugs  = bean_1.getDB_MultiDrugDetail(order_id,order_line_no);//added for MMS-DM-SCF-0513
					String alt_drug_code = "";
					if(multi_drugs!=null && multi_drugs.size()>0){
					for(int n=0; n<multi_drugs.size(); n+=5){ 
							alt_drug_code			=	(String)multi_drugs.get(n);
							if(alt_drug_code.equals(item_code)){
								validBatchId = bean_1.IsValidBatch(batch_id,order_id,order_line_no,true,alt_drug_code,iv_prep_yn,patient_id); //iv_prep_yn,patient_id added for MMS-KH-SCF-0017
								break;				
							}
						}
					}
				  }
				}
			}else{
				if(item_code.equals("")){
					validBatchId = bean_1.IsValidBatch(batch_id,order_id,order_line_no,true,item_code,iv_prep_yn,patient_id); //iv_prep_yn,patient_id added for MMS-KH-SCF-0017
				}else{
					validBatchId = false;
				}
			}
		}else{		//PMG2017-MMS-CRF-0002 -end
		
			validBatchId = bean_1.IsValidBatch(batch_id,order_id,order_line_no,false,"",iv_prep_yn,patient_id);//iv_prep_yn,patient_id added for MMS-KH-SCF-0017
		}
		
		out.println("validBatchidYn('"+validBatchId+"');");
	} // Added for AAKH-CRF-0084 [IN060429] - End
	else if(identity.equals("validateQtyAck")){
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,  bean_name, request ) ;	
		String order_id = (String)hash.get("order_id");
		String order_line_no = (String)hash.get("order_line_no");
		String item_code = (String)hash.get("item_code");
		String batch_id = (String)hash.get("batch_id");
		String expiry_date = (String)hash.get("expiry_date");
		String trade_id = (String)hash.get("trade_id");
		String patient_id = (String)hash.get("patient_id");
		String recCount	  = (String)hash.get("recCount");
		String non_iv_admin_qty = (String)hash.get("non_iv_admin_qty");//GHL-CRF-0458.1
		String non_iv_checked   = (String)hash.get("non_iv_checked");//GHL-CRF-0458.1
		String placed_from_verbal_order=(String)hash.get("placed_from_verbal_order");// added for GHL-CRF-0509
		String encounter_id= (String)hash.get("encounter_id");//added for GHL-CRF-0482
		
		System.err.println("batch_id===701=sd=>"+batch_id);  
		if(non_iv_admin_qty==null || non_iv_admin_qty.equals(""))
			non_iv_admin_qty = "1";

		String allow_yn   = "N";//GHL-CRF-0458.1
		String disp_req_yn = "";//GHL-CRF-0458.1
		String tot_allow_qty = "";//GHL-CRF-0458.1
		String tot_non_iv_sel_qty = "";
		String allow_yn_val= bean.validateAckQty(order_id,order_line_no,item_code,batch_id,expiry_date,trade_id,patient_id,facility_id,encounter_id);
		tot_non_iv_sel_qty = non_iv_admin_qty;
System.err.println("allow_yn_val=====714=>"+allow_yn_val);
		if(allow_yn_val==null)//GHL-CRF-0458.1
			allow_yn_val = "~";
			
			allow_yn = allow_yn_val.split("~")[0];//GHL-CRF-0458.1
			disp_req_yn = allow_yn_val.split("~")[1];//GHL-CRF-0458.1
			tot_allow_qty = allow_yn_val.split("~")[2];//GHL-CRF-0458.1
			out.println("adminAllowYN('"+recCount+"','"+allow_yn+"');");
           //if condtion added for GHL-CRF-0509 START
			if(placed_from_verbal_order.equals("Y"))
				{
				disp_req_yn="N";
				allow_yn="Y";
				}
			//if condtion added for GHL-CRF-0509  END
			
		if(allow_yn.equals("N")){
			out.println("displayAlert('"+recCount+"','"+disp_req_yn+"');");//disp_req_yn added for GHL-CRF-0458.1
		}
		else{//GHL-CRF-0458.1 - start
			HashMap hm =(HashMap)bean.getAdminQty();
			if(hm!=null && hm.size()>0){
				if(non_iv_checked.equals("false")){
					tot_non_iv_sel_qty =(Float.parseFloat(tot_non_iv_sel_qty) - Float.parseFloat((String)hm.get(order_id+order_line_no+item_code)))+"";
				}else{
					tot_non_iv_sel_qty =(Float.parseFloat(tot_non_iv_sel_qty) + Float.parseFloat((String)hm.get(order_id+order_line_no+item_code)))+"";
				}

				if(Float.parseFloat(tot_allow_qty)<Float.parseFloat(tot_non_iv_sel_qty))
					out.println("displayAlert('"+recCount+"','Y');");
				else
					bean.setAdminQty(order_id,order_line_no,item_code,tot_non_iv_sel_qty);
			}else
				bean.setAdminQty(order_id,order_line_no,item_code,tot_non_iv_sel_qty);//GHL-CRF-0458.1 - end
		}
		
		

		
		putObjectInBean(bean_id,bean,request);
	}else if(identity.equals("getAltDoseDetails")){ //added for BRU-CRF-399.1
		bean_id	=	"MedicationAdministrationFTBean";
		bean_name=	"ePH.MedicationAdministrationFTBean";			
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,bean_name, request ) ;	

		String drug_code = request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
		String disp_drug_code = request.getParameter("disp_drug_code")==null?"":request.getParameter("disp_drug_code");
		String order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String order_line_num = request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
		String recCount =  request.getParameter("row_no");
		String freq_nature = request.getParameter("freq_nature");
		String old_MAR_yn  = request.getParameter("old_MAR_yn")==null?"N":request.getParameter("old_MAR_yn");
		String qty         = request.getParameter("qty")==null?"0":request.getParameter("qty");
					
		try{
			String dosage_dtl = bean.getAltDosageDetails(drug_code,disp_drug_code,order_id,order_line_num);
			String alt_qty = "";
			String strength_per_value_pres_uom = "";
			
			
			if(freq_nature.equals("P")){
				strength_per_value_pres_uom = dosage_dtl.split("~")[3];
				alt_qty = new Float(Float.parseFloat(qty)*Float.parseFloat(strength_per_value_pres_uom)*Float.parseFloat(dosage_dtl.split("~")[0])).intValue()+"";
			} 
		
				out.println("assignDosage('"+dosage_dtl.split("~")[0]+"','"+dosage_dtl.split("~")[1]+"','"+dosage_dtl.split("~")[2]+"','"+recCount+"','"+freq_nature+"','"+old_MAR_yn+"','"+alt_qty+"','"+dosage_dtl.split("~")[4]+"')");
		}catch(Exception e1){
			e1.printStackTrace();
		}
		putObjectInBean(bean_id,bean,request);
	}else if(identity.equals("barcode_validation")){//GHL-CRF-0509 - start
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,  bean_name, request ) ;
		String order_id = (String)hash.get("order_id")==null?"":(String)hash.get("order_id");
		String order_line_no = (String)hash.get("order_line_no")==null?"1":(String)hash.get("order_line_no");
		String store_code = (String)hash.get("store_code")==null?"":(String)hash.get("store_code");
		String item_code  = (String)hash.get("item_code")==null?"":(String)hash.get("item_code");
		String barcode_id = (String)hash.get("barcode_id")==null?"":(String)hash.get("barcode_id");
		HashMap barcode_map = bean.getBarcodeAvailableForItem();
		
		String barcode_avilable = "N";
		String batch_exp_date = "";
			System.err.println("MedicationAdministrationFTValidate.jsp===barcode_map===789=>"+barcode_map+"==order_id==>"+order_id+"==order_line_no==>"+order_line_no);
		if(barcode_map!=null && barcode_map.size()>0){
			if(barcode_map.containsKey(order_id+order_line_no)){
				barcode_avilable = (String)barcode_map.get(order_id+order_line_no);
				}
			else{
				barcode_avilable = bean.checkBarcodeValid(order_id,order_line_no,store_code,item_code,barcode_id);
			}
		}else{
			barcode_avilable = bean.checkBarcodeValid(order_id,order_line_no,store_code,item_code,barcode_id);
		}

		HashMap batchDetails = bean.getBatchDetailsForItem();
		if(barcode_avilable.equals("Y")){
			batch_exp_date = (String)batchDetails.get(order_id+order_line_no);
		}

		if(barcode_avilable.equals("Y"))
			out.println(batch_exp_date);
		else
			out.println("N");

	putObjectInBean(bean_id,bean,request);
	}else if(identity.equals("barcode_clear")){
		MedicationAdministrationFTBean bean = (MedicationAdministrationFTBean)getBeanObject( bean_id,  bean_name, request ) ;
		bean.clearBarcodeMap();
		
		
	putObjectInBean(bean_id,bean,request);
	}//GHL-CRF-0509 - end
}catch (Exception e) {
		e.printStackTrace();
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
