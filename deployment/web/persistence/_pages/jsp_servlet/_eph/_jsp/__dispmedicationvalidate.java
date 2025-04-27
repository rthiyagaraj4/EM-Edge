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
import eST.*;
import eST.Common.*;
import java.text.DecimalFormat;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __dispmedicationvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationValidate.jsp", 1742367781876L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" ";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");

try {
	String identity		  = request.getParameter( "identity" );
	String bean_id		  = request.getParameter( "bean_id" ) ;
	String bean_name	  = request.getParameter( "bean_name" ) ; 
	String patient_id	  = request.getParameter( "patient_id" );
	String disp_stage 	  ="";
	Hashtable hash		  = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				  = (Hashtable)hash.get( "SEARCH" ) ;
	String disp_locn_code = (String) hash.get("disp_locn_code");
	String disp_locn_catg = (String) hash.get("disp_locn_catg");
	String disp_stage_global= (String) hash.get("disp_stage");
	String disp_locn_name = (String) hash.get("disp_locn_name");
	String LoginUserId       =(String)session.getValue("login_user");
	DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setLanguageId(locale);
	if(identity.equals("populateToken")){
		String token_series	= (String) hash.get("token_series");
		String tok_no		= (String) hash.get("token_no");
		String queue_date	= (String) hash.get("queue_date");
		bean.setQueueDate(queue_date);
		bean.updateTokenStatus(token_series);
		if(token_series.equals("*A"))
			token_series = "";
		HashMap  token_dtls		=	(HashMap)bean.displayTokenNumber(token_series,tok_no,"Y");
		String token_no				= (String)token_dtls.get("TOKEN_NO"); 
		String token_status			= (String)token_dtls.get("TOKEN_STATUS"); 
		String added_facility_id    = (String)token_dtls.get("ADDED_FACILITY_ID"); 
		if(!token_no.equals("")&& token_status.equals("XX")){
		   out.println("DiplayPendingTokenDtls('"+token_series+"','"+token_no+"')");  
		}
		else{ 
		   out.println("assignToken('"+token_no+"','"+added_facility_id+"')");
		}
	}
	else if(identity.equals("callAuthorizationCheck")){ //0026.1 
		ArrayList respList = new ArrayList();  
		String paramValue = ""; 
		String paramValue_old =""; 
		String patientId = (String)hash.get("patient_id");
		String encounter_id = (String)hash.get("encounter_id");
		String order_id = (String)hash.get("orderId"); 
		String dispTmpNo = (String)hash.get("dispTmpNo"); 
		String order_line_num = (String)hash.get("order_line_num"); 
		String drug_code = (String)hash.get("drug_code"); 
		String status = "N";  
		String dispQty =  (String)hash.get("alloc_qty");
		String uom =  (String)hash.get("uom"); 
		String unit_price =(String)hash.get("unitPrice");//MOHE-CRF-0026.1 

		if(paramValue.equals("") && ( bean.getIqviaDispData()==null || bean.getIqviaDispData().equals("")) ){ 
			paramValue  = patientId+"~"+encounter_id+"~"+order_id+"~"+dispTmpNo+"~"+order_line_num+"~"+drug_code+"~"+status+"~"+dispQty+"~"+uom+"~"+unit_price;  
		}else if (bean.getIqviaDispData()!=null && !bean.getIqviaDispData().equals("")){
			paramValue_old  = bean.getIqviaDispData(); 
			paramValue  = patientId+"~"+encounter_id+"~"+order_id+"~"+dispTmpNo+"~"+order_line_num+"~"+drug_code+"~"+status+"~"+dispQty+"~"+uom+"~"+unit_price;
			paramValue = paramValue_old+"#"+paramValue;  
		}
		bean.setIqviaDispData(paramValue);   
	}
	else if(identity.equals("callAuthorizationStatus")){ //0026.1 
		ArrayList respList = new ArrayList();   
		ArrayList statusList = new ArrayList();
		String patientId = (String)hash.get("patient_id");
		String encounter_id = (String)hash.get("encounter_id");
		String order_id = (String)hash.get("orderId"); 
		String drug_code = (String)hash.get("drug_code"); 
		String order_line_num = (String)hash.get("order_line_num"); 
		String dispTmpNo = (String)hash.get("dispTmpNo");  
		String dispQty = (String)hash.get("alloc_qty");  
		String uom =  (String)hash.get("uom"); 
		String resp_status =(String)hash.get("response_code");  
		String claim_id =(String)hash.get("claimId");  
		String responseStatus = (String)hash.get("responseStatus"); 
		String unit_price = (String)hash.get("unitPrice"); //MOHE-CRF-0026.1 

		String status = "N";
		String paramValue = "";  
		String paramValue_old = "";  
		if(paramValue.equals("") && ( bean.getIqviaAuthStatusDispData()==null || bean.getIqviaAuthStatusDispData().equals("")) ){  
			paramValue  = patientId+"~"+encounter_id+"~"+order_id+"~"+dispTmpNo+"~"+order_line_num+"~"+drug_code+"~"+status+"~"+dispQty+"~"+uom+"~"+unit_price+"~"+resp_status+"~"+claim_id;  
		}else if (bean.getIqviaAuthStatusDispData()!=null && !bean.getIqviaAuthStatusDispData().equals("")){ 
			paramValue_old  = bean.getIqviaAuthStatusDispData(); 
			if(responseStatus.equals("S")){
				paramValue = paramValue_old+"#"+paramValue;  
			}else{
				paramValue  = patientId+"~"+encounter_id+"~"+order_id+"~"+dispTmpNo+"~"+order_line_num+"~"+drug_code+"~"+status+"~"+dispQty+"~"+uom+"~"+unit_price+"~"+resp_status+"~"+claim_id;  
				paramValue = paramValue_old+"#"+paramValue;  
			}
		}
		bean.setIqviaAuthStatusDispData(paramValue);  
	}
	
	else if(identity.equals("setDispData")){ 
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ; //added for IN070867
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );//added for IN070867
		/*String	bean_id_1			=	"DispMedicationBean" ;
		String	bean_name_1			=	"ePH.DispMedicationBean";
		DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);*/
		String request_type =(String)hash.get("request_type");
		String dispense_stage = (String)hash.get("disp_stage");  
		String facility_id = (String) session.getValue("facility_id");  
		String added_by_id			= prop.getProperty("login_user");//login_by_id	
		String disp_data = bean.getIqviaDispData();  
		String authStatus_disp_data ="";
		authStatus_disp_data = bean.getIqviaAuthStatusDispData(); 
		if(request_type.equals("PHPREAUTH")){
				out.println("assignDispData('"+disp_data+"','"+dispense_stage+"')");    
			}else if (request_type.equals("PHSTATUS")){
				out.println("assignAuthStatusDispData('"+authStatus_disp_data+"','"+dispense_stage+"')");    
			}   	
	}
	else if(identity.equals("callDispense")){ //MOHE-CRF-0026.1 
		ArrayList respList = new ArrayList();  
		String paramValue = ""; 
		String paramValue_old =""; 
		String patientId = (String)hash.get("patient_id");
		String encounter_id = (String)hash.get("encounter_id");
		String order_id = (String)hash.get("orderId"); 
		String dispTmpNo = (String)hash.get("dispTmpNo"); 
		String order_line_num = (String)hash.get("order_line_num"); 
		String drug_code = (String)hash.get("drug_code"); 
		String status = "N";  
		String dispQty =  (String)hash.get("alloc_qty");
		String uom =  (String)hash.get("uom"); 
		String unit_price = "1";//check
		String dosage_freq_code = (String)hash.get("frequencyCode"); 
		String dosage_freq= (String)hash.get("repeatValue"); 
		String dosage_period= (String)hash.get("durnValue"); 
		String dosage_period_unit= (String)hash.get("durationType"); 
		String route_code= (String)hash.get("routeCode"); 
		String dose_qty_value= (String)hash.get("qtyValue"); 
		String dose_qty_unit= (String)hash.get("qtyUnit"); 
		if(paramValue.equals("") && ( bean.getIqviaAfterDispenseData()==null || bean.getIqviaAfterDispenseData().equals("")) ){ 
			paramValue  = patientId+"~"+encounter_id+"~"+order_id+"~"+dispTmpNo+"~"+order_line_num+"~"+drug_code+"~"+status+"~"+dispQty+"~"+uom+"~"+unit_price+"~"+dosage_freq_code+"~"+dosage_freq+"~"+dosage_period+"~"+dosage_period_unit+"~"+route_code+"~"+dose_qty_value+"~"+dose_qty_unit;  
		}else if (bean.getIqviaAfterDispenseData()!=null && !bean.getIqviaAfterDispenseData().equals("")){
			paramValue_old  = bean.getIqviaAfterDispenseData(); 
			paramValue  = patientId+"~"+encounter_id+"~"+order_id+"~"+dispTmpNo+"~"+order_line_num+"~"+drug_code+"~"+status+"~"+dispQty+"~"+uom+"~"+unit_price+"~"+dosage_freq_code+"~"+dosage_freq+"~"+dosage_period+"~"+dosage_period_unit+"~"+route_code+"~"+dose_qty_value+"~"+dose_qty_unit;
			paramValue = paramValue_old+"#"+paramValue;  
		}
		System.out.println("paramValue: "+paramValue); 
		bean.setIqviaAfterDispenseData(paramValue);    
	}
	else if(identity.equals("setPostDispData")){ 
		System.out.println("DispMedValidate.jsp - setPostDispData");  
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ; //added for IN070867
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );//added for IN070867
		String request_type =(String)hash.get("request_type");
		String dispense_stage = (String)hash.get("disp_stage");  
		String facility_id = (String) session.getValue("facility_id");  
		String added_by_id			= prop.getProperty("login_user");//login_by_id	
		String disp_data = bean.getIqviaAfterDispenseData();  
		String postDisp_disp_data ="";
		postDisp_disp_data = bean.getIqviaAfterDispenseData(); 
		if(request_type.equals("PHDISP")){
				out.println("assignPostDispData('"+disp_data+"','"+dispense_stage+"')");    
			}  
		
	}
	else if (identity.equals("setOrderIdClaimDet")){
		String orderIdNo =(String)hash.get("orderIdNo");
		String claimId = (String)hash.get("claimId");  
		String respStatus = (String)hash.get("respStatus");  
		System.out.println("orderIdNo: "+orderIdNo);
		System.out.println("claimId: "+claimId);
		System.out.println("respStatus: "+respStatus); 
		ArrayList arrList = new ArrayList();
		String claimDet = ""; 
		String claimDetails_old = ""; 
		/*if(bean.getOrderClaimIdDet()==null || bean.getOrderClaimIdDet().equals("")){
			 claimDet = orderIdNo+"~"+claimId+"~"+respStatus;
			arrList.add(claimDet); 
			System.out.println("arrList: "+arrList); 
		}
		else if (!bean.getOrderClaimIdDet().equals("") || bean.getOrderClaimIdDet()!=null){
			claimDetails_old = bean.getOrderClaimIdDet();
			claimDet =  orderIdNo+"~"+claimId+"~"+respStatus;
			arrList.add(claimDet); 
			System.out.println("arrList: "+arrList);
		}
		bean.setOrderClaimIdDet(arrList); 
		System.out.println("bean.getOrderClaimIdDet(): "+bean.getOrderClaimIdDet()); */
		
	}//MOHE-CRF-0026.1 END 
	else if(identity.equals("validateToken")){
		String token_series	= (String) hash.get("token_series");
		String token_no		= (String) hash.get("token_no");
		String queue_date	= (String) hash.get("queue_date");
		if(token_series==null || token_series.equals("*A"))//Added for HSA-SCF-0081 [IN:050227]
			token_series = "";
		bean.setQueueDate(queue_date);  
		bean.updateTokenStatus(token_series);
		String result		=	bean.validateTokenNumber(token_series,token_no);
		if(result.equals("Y")){
			String token_status =   bean.GetTokenStatus(token_series,token_no);
			if(token_status.equals("XX")){
			   out.println("DiplayPendingTokenDtls('"+token_series+"','"+token_no+"')");
			}
			else{
			   out.println("validateResult('"+result+"')");	
			}
		}
		else{
		  out.println("validateResult('"+result+"')");	
		}
	}
	else if(identity.equals("getDispCatg")){
		bean.setDispLocnCode(disp_locn_code);
		String disp_catg = bean.getDispCatg(disp_locn_code);
		//Below condition is added by sureshkumar T for the Inc : SRR20056-SCF-7894 [ 29225 ] up to 74
		String prev_disp_catg		= (String)hash.get("prev_disp_catg");
		if(prev_disp_catg == null )
			prev_disp_catg="";
		out.println("assignDispCatg('"+disp_catg+"','"+prev_disp_catg+"')");	
	}
	else if (identity.equals("getDispStage")){
	//	String disp_stage = bean.getDispStage();
		bean.clearDispMedStageDetails(); // added for SKR-SCF-0611 [IN:034816]
		StringBuffer stageDisplaySequence = new StringBuffer();
		String applicableStages = bean.getDispStagesApplicable(disp_locn_code.trim(),disp_locn_catg.trim());
		String verf_combined_with_alloc = bean.getVerfCombinedWithAlloc();
		Hashtable param_legends = bean.getLegendsFromParam();
		String homepage= hash.get("homepage")==null?"":(String) hash.get("homepage"); //added for Bru-HIMS-CRF-073.1 [IN:047222]
		StringTokenizer stApplicableStages = new StringTokenizer(applicableStages,":");
		int countTokens = stApplicableStages.countTokens();
		String stage	=	null;
		if(!homepage.equals("Y")){ //if condition and else blcok added for Bru-HIMS-CRF-073.1 [IN:047222]
			while(stApplicableStages.hasMoreTokens()){
				stage = stApplicableStages.nextToken();
				if(!stage.equals("AS")) // if block added for SKR-SCF-0611 [IN:034816]
					bean.setDispMedStages(stage);
				if(disp_locn_catg.equals("O")){
					if(verf_combined_with_alloc.equals("C")&&( stage.equals("V") )){
						stageDisplaySequence=stageDisplaySequence.append("A:");
						out.println("assignApplicableDispStage('A','"+(String)param_legends.get("A")+"')");
					}
					else if(stage.equals("V") && !verf_combined_with_alloc.equals("C")){
						out.println("assignApplicableDispStage('V','"+(String)param_legends.get("V")+"')");
						stageDisplaySequence=stageDisplaySequence.append("V:");
					}
					else if(stage.equals("A") && !verf_combined_with_alloc.equals("C")){
						out.println("assignApplicableDispStage('A','"+(String)param_legends.get("A")+"')");
						stageDisplaySequence=stageDisplaySequence.append("A:");
					}
					else if(stage.equals("F")){
						out.println("assignApplicableDispStage('F','"+(String)param_legends.get("F")+"')");
						stageDisplaySequence=stageDisplaySequence.append("F:");
					}
					else if(stage.equals("B")){
						out.println("assignApplicableDispStage('B','"+(String)param_legends.get("B")+"')");
						stageDisplaySequence=stageDisplaySequence.append("B:");
					}
					else if(stage.equals("D")){
						out.println("assignApplicableDispStage('D','"+(String)param_legends.get("D")+"')");
						stageDisplaySequence=stageDisplaySequence.append("D:");
					}
					else if(stage.equals("AS") && countTokens > 1){
						out.println("assignApplicableDispStage('AS')");
						stageDisplaySequence=stageDisplaySequence.append("AS:");
					}
					else if(verf_combined_with_alloc.equals("C")){
						stageDisplaySequence=stageDisplaySequence.append("A:");	out.println("assignApplicableDispStage('A','"+(String)param_legends.get("A")+"')");
					}
				}//below condition added by Himanshu IAE for all Dispense location
				else if(disp_locn_catg.equals("IAE"))
				{
					if(stage.equals("V")  ){
						out.println("assignApplicableDispStage('V','"+(String)param_legends.get("V")+"')");
						stageDisplaySequence=stageDisplaySequence.append("V:");
					}
				}
				else{
					if(stage.equals("V")  ){
						out.println("assignApplicableDispStage('V','"+(String)param_legends.get("V")+"')");
						stageDisplaySequence=stageDisplaySequence.append("V:");
					}
					else if(stage.equals("F")){
						out.println("assignApplicableDispStage('F','"+(String)param_legends.get("F")+"')");
						stageDisplaySequence=stageDisplaySequence.append("F:");
					}
					else if(stage.equals("D")){
						out.println("assignApplicableDispStage('D','"+(String)param_legends.get("D")+"')");
						stageDisplaySequence=stageDisplaySequence.append("D:");
					}
				}
				bean.setStageDisplaySequence(stageDisplaySequence.toString());
			}
			param_legends		=	null;
			stApplicableStages	=	null;
		} //added for Bru-HIMS-CRF-073.1 [IN:047222] -start
		else if(homepage.equals("Y")){
			disp_stage= hash.get("disp_stage")==null?"":(String) hash.get("disp_stage");
			String disp_locn = "", fill_list="";
			String facility_id=(String) session.getValue( "facility_id" );
			boolean stageFound= false;
			if(disp_locn_catg.equals("I")){
				if(disp_stage.equals("F")){
					disp_stage="F";
					fill_list="WF";
				}
				else if(disp_stage.equals("FL")){
					disp_stage="F";
					fill_list="AF";
				}
				else if(disp_stage.equals("DF")){
					disp_stage="D";
					fill_list="DWF";
				}
				else if(disp_stage.equals("D")){
					disp_stage="D";
					fill_list="DF";
				}
			}
			while(stApplicableStages.hasMoreTokens()){
				stage = stApplicableStages.nextToken();
				if(!stage.equals("AS")) // if block added for [IN:051932]
					bean.setDispMedStages(stage);
				if( stage.equals(disp_stage) ){
					stageFound = true;
					//break;//commented for [IN:051932]
				}
			}
			if(stageFound){
				stageFound = false;
				ArrayList result = bean.checkToProceed(facility_id.trim(),"DispMedication");
				String disp_locn_details=(String)result.get(0);
				bean.setDispLocnDetails(disp_locn_details);
				StringTokenizer stdisp_locn_details = new StringTokenizer(disp_locn_details,"|");
				StringTokenizer st_disp_locn = null;
				String strdisp_locn_code = "";
				String curr_enc_financial_dtl_yn="", issue_token_on_regn_YN="";
				while (stdisp_locn_details.hasMoreTokens()){
					disp_locn = stdisp_locn_details.nextToken();
					st_disp_locn = new StringTokenizer(disp_locn,",");
					strdisp_locn_code = st_disp_locn.nextToken();
					if((strdisp_locn_code).equals(disp_locn_code)){
						disp_locn_name = st_disp_locn.nextToken();
						issue_token_on_regn_YN = st_disp_locn.nextToken();
						curr_enc_financial_dtl_yn = st_disp_locn.nextToken();
						stageFound = true;
						break;
					}
				}
				bean.getDispCatg(disp_locn_code);
				bean.setCurrEncFinancialDtl(curr_enc_financial_dtl_yn);
				bean.setDispLocnCode(disp_locn_code.trim());
				bean.setDispLocnCatg(disp_locn_catg.trim());
				bean.setIssueTokenOnRegnYN(issue_token_on_regn_YN);
				bean.setDispStage(disp_stage);
				bean.setFillList(fill_list);
				bean.setDispLocnName(java.net.URLEncoder.encode(disp_locn_name.trim(),"UTF-8"));
				DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages", request);
				bean_all_stages.getUserAuthPINYN(session.getAttribute("facility_id").toString(),disp_locn_code.trim()); 
				if(stageFound){
					if(issue_token_on_regn_YN.equals("Y")&&disp_locn_catg.equals("O")){
						String resulttk = bean.validateWSForTokenSeries();
						if(resulttk.equals("N"))
							out.println("retVal ='PH_INVALID_TOKEN_SERIES_FOR_WORK_STATION'");			
						else
							out.println("retVal='GOQUERYCRITERIA'");
					}
					else{
						out.println("retVal ='GOQUERYCRITERIA'");
					}
				}
				else
					out.println("retVal ='ACCESS_DENIED'");			
			}
			else
				out.println("retVal ='ACCESS_DENIED'");			
		} //added for Bru-HIMS-CRF-073.1 [IN:047222] -end
	}
	else if(identity.equals("validateTokenNo")){
		/*String next_token_no	= request.getParameter("next_token_no");
		String token_series		= (String)hash.get("token_series");
		String result = bean.validateTokenNo(next_token_no,token_series);
		out.println("showAnAlertForTokenNumber('"+result+"','"+next_token_no+"')");*/
	}
	else if (identity.equals("validateWSForTokenSeries")){
		if(bean.getFunctionIdentity().equals("VerifyPrescriptions") && !bean.checkValidFlow(disp_locn_catg.trim(), disp_locn_code.trim())){
			out.println("alert(getMessage('PH_VERIFICATION_NOT_APPLI','PH'))");
			out.println("focusOnPasswordField('Y')");
		}
		else {
			bean.setPassword((String) hash.get("password"));
			if(!bean.validateThePassword()){
				out.println("alert(getMessage('PH_INVALID_PASSWORD','PH'))");
				out.println("focusOnPasswordField('Y')");			
			}
			else{
				out.println("focusOnPasswordField('N')");	
				String fill_list= (String) hash.get("fill_list");
				if(fill_list==null){
					fill_list = "WF";	// WF - Without Fill list
				}
				String curr_enc_financial_dtl_yn = hash.get("curr_enc_financial_dtl_yn")==null?"":(String) hash.get("curr_enc_financial_dtl_yn");//Added for JD-CRF-0156 [IN:41737] 
				bean.setCurrEncFinancialDtl(curr_enc_financial_dtl_yn); //Added for JD-CRF-0156 [IN:41737] 
				bean.setFillList(fill_list);
				String issue_token_on_regn_YN = bean.getIssueTokenOnRegnYN();
				bean.setDispLocnCode(disp_locn_code.trim());
				bean.setDispLocnCatg(disp_locn_catg.trim());
				bean.setDispDrugRights(disp_locn_code);//Added for Performance Issue by chandra 17072022
				if(disp_stage_global != null){
					bean.setDispStage(disp_stage_global.trim());
				}
				else{
					bean.setDispStage("V");
				}
				bean.setDispLocnName(disp_locn_name.trim());
				DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages", request);  // Added for RUT-CRF-0035 IN029926
				bean_all_stages.getUserAuthPINYN(session.getAttribute("facility_id").toString(),disp_locn_code.trim()); // Added for RUT-CRF-0035 IN029926
				if(issue_token_on_regn_YN.equals("Y")&&disp_locn_catg.equals("O")){
					String result = bean.validateWSForTokenSeries();
					out.println("validateWSForTokenSeries('"+result+"')");			
				}
				else{
					out.println("WSForTokenSeriesNotApplicable()");
				}
			}
		}
	}
	else if(identity.equals("storeCriteriaValues")){
		String token_no			= (String) hash.get("token_no");         
		String order_date_from	= (String) hash.get("order_date_from");  
		String order_date_to	= (String) hash.get("order_date_to");    
		String scope			= (String) hash.get("scope");            
		String priority			= (String) hash.get("priority");         
			   patient_id		= (String) hash.get("patient_id");       
		String order_id			= (String) hash.get("order_id");   
		String token_series		= (String) hash.get("token_series");   
		String chk_group_by_patient = (String)hash.get("chk_group_by_patient");
		String admixture_type		= (String)hash.get("admixture_type");
		String disp_level		= (String)hash.get("disp_level");
		String ord_locn_code	= (String)hash.get("ord_locn_code");
		String order_type		= (String)hash.get("order_type");
		String order_locn_type	= (String)hash.get("ord_locn_type");	
		String pat_mobile_no    = (String)hash.get("pat_mobile_no");//Added for TH-KW-CRF-0014	
		String national_id      = (String)hash.get("national_id");//Added for TH-KW-CRF-0014	
		String include_orders_by_freq_durn	= hash.get("include_orders_by_freq_durn")==null?"": ((String)hash.get("include_orders_by_freq_durn"));	// Added for SRR20056-CRF-0663
		String include_absolute_orders = hash.get("include_absolute_orders")==null?"":((String)hash.get("include_absolute_orders"));		// Added for SRR20056-CRF-0663    
		String sort_token_series_ind = hash.get("sort_token_series_ind")==null?"":((String)hash.get("sort_token_series_ind")); //Added for HSA-CRF-0136 [IN:048412]
		String opCustomSortOrder = (String)hash.get("customSortOrder"); //added for ML-MMOH-CRF-1666
		String opCustomSortBy   = (String)hash.get("customSortBy"); //added for ML-MMOH-CRF-1666
		String disp_locn_iae=(String)hash.get("disp_locn")==null?"": (String)hash.get("disp_locn"); //Added by Himanshu for MMS-DM-CRF-0232
		String prescription_num=(String)hash.get("prescription_num")==null?"": (String)hash.get("prescription_num"); //Added by Himanshu for GHL-CRF-0672
		bean.setPrescription_number(prescription_num); //Added by Himanshu for GHL-CRF-0672
		String queue_date	= (String)hash.get("queue_date");//ML-MMOH-SCF-2977
		
		//Added by Himanshu for MMS-DM-CRF-0232
        if(disp_locn_iae.equals("all"))
        {
        	String strdisp_locn_code	=	"";
        	String disp_locn_details	=  "";
        	String disp_locn	=  "";
        	StringTokenizer st_disp_locn =	null;
        	ArrayList result = bean.checkToProceed(session.getAttribute("facility_id").toString(),"DispMedication");
        	if(result.size()>0) {
        		disp_locn_details =(String)result.get(0);
        	}
        	StringTokenizer stdisp_locn_details = new StringTokenizer(disp_locn_details,"|");
        	while (stdisp_locn_details.hasMoreTokens())
        	{
        		disp_locn			= stdisp_locn_details.nextToken();
        		st_disp_locn		= new StringTokenizer(disp_locn,",");
        		strdisp_locn_code	= strdisp_locn_code+"@@@"+st_disp_locn.nextToken();
        		//System.out.println("inside loop "+strdisp_locn_code);
        	}

        	bean.setDisp_locn_iae(strdisp_locn_code);
        }else{
        bean.setDisp_locn_iae(disp_locn_iae); 
        }
         //Added by Himanshu for MMS-DM-CRF-0232 Ends
		
         String order_by         = "";
		disp_stage = bean.getDispStage();
		
		SalesBean stSaleBean				=	(SalesBean)getBeanObject( "salesBean", "eST.SalesBean", request );//Added AMS-CRF-0068.1 [IN:050333] start
		boolean Min_Rol_yn                  =stSaleBean.getMin_Rol_yn(LoginUserId,bean.getDispLocnCode());
		boolean getReq_allowed_yn		    =stSaleBean.getReq_allowed_yn(LoginUserId,bean.getDispLocnCode());
		bean.setMin_Rol_yn(Min_Rol_yn);
		bean.setReq_allowed_yn(getReq_allowed_yn); //Added AMS-CRF-0068.1 [IN:050333] end
		String orderingfacility =(String)hash.get("OrderingFacility");
		bean.setOrderingFacility(orderingfacility);
		bean.getBarCodeScanedData().clear();//Added for MMS-DM-CRF-0170

		if(disp_stage.equals("AS"))
			order_by  =  (String)hash.get("order_by");
		
		if(admixture_type==null){
			admixture_type="";
		}
		bean.getBarCodesForDrug().clear();//Added for KDAH-CRF-0231 [IN-034551].
		bean.getStockDtl().clear();//Added for KDAH-CRF-0231 [IN-034551].
		bean.getBatch_val().clear();//Added for KDAH-CRF-0231 [IN-034551].
		bean.getOrderDrugdtl().clear();//Added for KDAH-CRF-0231 [IN-034551].
		bean.getDrugQty().clear();//Added for KDAH-CRF-0231 [IN-034551].
		bean.setDispLevelValue(disp_level);
		bean.setAdmixtureType(admixture_type);
		bean.setTokenNo(token_no);
		bean.setTokenSeriesCode(token_series);
		bean.setQMSDtl(bean.getDispLocnCode(), token_series); // Added for Bru-HIMS-CRF-076 [IN:029942]
		bean.setOrderDateFrom(order_date_from);
		bean.setOrderDateTo(order_date_to);
		bean.setScope(scope);
		bean.setPriority(priority);
		bean.setPatientID(patient_id);
		bean.setOrderID(order_id);
		bean.setChkGroupByPatient(chk_group_by_patient);
		bean.setAddCriteriaLocnCode(ord_locn_code);
		bean.setOrderType(order_type);
		bean.setOrdLocnType(order_locn_type);
		bean.setOrderBy(order_by);
		bean.setCriteriaOrderType(order_type);
		bean.setBillingParams( bean.getDispLocnCode(), "OP"); //added for SRR20056-SCF-7639 ICN027720
		bean.checkForStockInstallation(); //added for SKR PerformanceIssue

        bean.setGroupByOrdLocn((String)hash.get("group_by_ord_locn"));
	    bean.setIncludeDrugsByFreqDurn(include_orders_by_freq_durn);	// Method name setExcludeDrugsByFreqDurn changed to setIncludeDrugsByFreqDurn for SRR20056-CRF-0663
	    bean.setIncludeAbsoluteOrders(include_absolute_orders);	// Added for SRR20056-CRF-0663
	    bean.setExcludePRNOrders((String)hash.get("exclude_PRN_orders"));
        bean.setDrugMedical((String)hash.get("drug_medical"));
		
		bean.setCustomGroupBy("");//added for CRF# PMG25006-CRF-0867 -start
		bean.setCustomGroupOrder("");
		bean.setCustomSortBy("");
		bean.setCustomSortOrder("");
		bean.setCustomTabBased(""); 
		bean.setCustomTabBasedHrs("");
		bean.setCustomTabBasedOption("");	//added for CRF# PMG25006-CRF-0867 -End
		bean.setFacilityParamValues(); //added for Bru-HIMS-CRF-082 [IN:029948]
		bean.getDispMednDefltValues();	//added for JD-CRF-0170.1 [IN:040204]
		bean.setDispDrugRights(bean.getDispLocnCode());
		bean.setPatMobileNo(pat_mobile_no);//Added for TH-KW-CRF-0014
		bean.setPatNationalID(national_id);//Added for TH-KW-CRF-0014
		bean.setOpCustomSortBy(opCustomSortBy);//added for ML-MMOH-CRF-1666
		bean.setOpCustomSortOrder(opCustomSortOrder);//added for ML-MMOH-CRF-1666
		bean.setDispBeyondBeforeValues();//Added for COMMON-ICN-0116 [39681]
		bean.setExclOrdLocnDispenseYN();//Added for ML-MMOH-CRF-2085
		bean.setQueueDate(queue_date);//ML-MMOH-SCF-2977		
				
	//	System.err.println("Pateint Mobile NO after setting@@==="+bean.getPatMobileNo());
		DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages", request);  // added for AAKH-SCF-0113 [IN:048937]
		bean_all_stages.setSTEntityData();	//added for AAKH-SCF-0113 [IN:048937]

		String display_dms_link_yn	   = bean.getDispDMSLink();	//added for RUT-CRF-0083.5 [IN:041511] -Start
		bean.setSortTokenSeriesInd(sort_token_series_ind); //Added for HSA-CRF-0136 [IN:048412]
		if(display_dms_link_yn.equals("Y"))
			out.println("displayDMSLink('"+display_dms_link_yn+"');");//added for RUT-CRF-0083.5 [IN:041511] -End
	}
	else if(identity.equals("storeIPCriteriaValues")){
		disp_stage = bean.getDispStage();
		String fill_list  = bean.getFillList();	
		bean.setOrderBy("");
		String orderingfacility =(String)hash.get("OrderingFacility");
		String include_absolute_orders		= (String)hash.get("include_absolute_orders")==null?"Y": (String)hash.get("include_absolute_orders");	// Added for SRR20056-CRF-0663
		String include_orders_by_freq_durn		= (String)hash.get("include_orders_by_freq_durn")==null?"Y": (String)hash.get("include_orders_by_freq_durn");	// Added for SRR20056-CRF-0663
		String tab_based_group_sort_disp	= hash.get("tab_based_group_sort_disp")==null?"":((String)hash.get("tab_based_group_sort_disp"));// Added for PMG20056-CRF-0867
		//com.ehis.util.DateUtils.convertDate((String)fill_dates.get(i),"DMYHM","en",locale);
		bean.setOrderingFacility(orderingfacility);
		bean.setBillingParams( bean.getDispLocnCode(), "IP"); //added for SRR20056-SCF-7639 ICN027720
		bean.checkForStockInstallation(); //added for SKR PerformanceIssue
		String order_id			= (String)hash.get("order_id");//Added for JD-CRF-0181 [IN:40699]
		String pat_mobile_no    = (String)hash.get("pat_mobile_no");//Added for TH-KW-CRF-0014	
		String national_id      = (String)hash.get("national_id");//Added for TH-KW-CRF-0014	
		bean.setOrderID(order_id);//Added for JD-CRF-0181 [IN:40699]
		bean.setCustomGroupBy("");//added for CRF# PMG25006-CRF-0867 -start
		bean.setCustomGroupOrder("");
		bean.setCustomSortBy("");
		bean.setCustomSortOrder("");
		bean.setCustomTabBased(""); 
		bean.setCustomTabBasedHrs("");
		bean.setCustomTabBasedOption("");
		bean.setScope("");	//added for CRF# PMG25006-CRF-0867 -End
		bean.getBarCodeScanedData().clear();//Added for MMS-DM-CRF-0170

		DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages", request);  // added for AAKH-SCF-0113 [IN:048937]
		bean_all_stages.setSTEntityData();	//added for AAKH-SCF-0113 [IN:048937]
		SalesBean stSaleBean				=	(SalesBean)getBeanObject( "salesBean", "eST.SalesBean", request );
		boolean Min_Rol_yn                  =stSaleBean.getMin_Rol_yn(LoginUserId,bean.getDispLocnCode());
		boolean getReq_allowed_yn		    =stSaleBean.getReq_allowed_yn(LoginUserId,bean.getDispLocnCode());
		bean.setMin_Rol_yn(Min_Rol_yn);
		bean.setReq_allowed_yn(getReq_allowed_yn);//Added AMS-CRF-0068.1 [IN:050333] end
		bean.setDispDrugRights(bean.getDispLocnCode());
		bean.setPatMobileNo(pat_mobile_no);//Added for TH-KW-CRF-0014
		bean.setPatNationalID(national_id);//Added for TH-KW-CRF-0014
		bean.setDispBeyondBeforeValues();//Added for COMMON-ICN-0116 [39681]
		bean.setExclOrdLocnDispenseYN();//Added for ML-MMOH-CRF-2085
		//System.err.println("Pateint Mobile NO after setting@@==="+bean.getPatMobileNo());

		if(disp_stage.equals("F") && fill_list.equals("AF")){	// F - Filling , AF - Against Fill list
			String nursing_unit		= (String)hash.get("nursing_unit");
			String fill_process_date= (String)hash.get("fill_process_date");
			String fill_type		= (String)hash.get("fill_type");
			String fill_process_id	= (String)hash.get("fill_process_id");
			String batches			= (String)hash.get("batches");
			String order_status		= (String)hash.get("order_status");
			String disp_level		= (String)hash.get("disp_level");
			String national_id_no	= (String)hash.get("national_id_no");
			String order_type		= (String)hash.get("order_type");
			patient_id		= (String)hash.get("patient_id");//added for [IN:055192]
			//String fill_date_time	= (String)hash.get("fill_date_time"); Commented By Sandhya for incident num:25101
			//Date conversion done by sandhya===25101 on 25/Nov/2010
			String prescription_num=(String)hash.get("prescription_num")==null?"": (String)hash.get("prescription_num"); //Added by Himanshu for GHL-CRF-0672
			String fill_date_time	= com.ehis.util.DateUtils.convertDate((String)hash.get("fill_date_time"),"DMYHM",locale,"en"); 
			bean.setNursingUnit(nursing_unit);
			bean.setFillProcessDate(fill_process_date);
			bean.setFillType(fill_type);
			bean.setFillProcessID(fill_process_id);
			bean.setBatches(batches);
			bean.setPatientID(patient_id);//added for [IN:055192]
			bean.setOrderStatus(order_status);				
			bean.setDispLevelValue(disp_level);
			bean.setNationalIDNo(national_id_no);
			bean.setOrderType(order_type);
			bean.setFillDateTime(fill_date_time);
			bean.setCriteriaOrderType(order_type);

			bean.setIPScope(order_status);

			bean.setGroupByOrdLocn((String)hash.get("group_by_ord_locn"));
	        	bean.setIncludeDrugsByFreqDurn(include_orders_by_freq_durn);	// Method name setExcludeDrugsByFreqDurn changed to setIncludeDrugsByFreqDurn for SRR20056-CRF-0663
	        	bean.setIncludeAbsoluteOrders(include_absolute_orders);	// Added for SRR20056-CRF-0663
	        	bean.setExcludePRNOrders((String)hash.get("exclude_PRN_orders"));
            		bean.setDrugMedical((String)hash.get("drug_medical"));
		}
		else if(disp_stage.equals("D") && fill_list.equals("DWF")){

			String fill_proc_date	= (String)hash.get("fill_proc_date");
			String fill_proc_type	= (String)hash.get("fill_proc_type");
			String fill_proc_id		= (String)hash.get("fill_proc_id");
			String nursing_unit		= (String)hash.get("nursing_unit");
			
			bean.setFillProcessDate(fill_proc_date);
			bean.setFillType(fill_proc_type);
			bean.setFillProcessID(fill_proc_id);
			bean.setNursingUnit(nursing_unit);
	        bean.setIncludeDrugsByFreqDurn(include_orders_by_freq_durn);	// Added for SRR20056-CRF-0663
	        bean.setIncludeAbsoluteOrders(include_absolute_orders);	// Added for SRR20056-CRF-0663
		}
		else if(disp_stage.equals("D")){
			String nursing_unit		= (String)hash.get("nursing_unit");
			String priority			= (String)hash.get("priority");
			patient_id		= (String)hash.get("patient_id");
			String disp_level		= (String)hash.get("disp_level");
			String ip_scope			= (String)hash.get("ip_scope");
			String national_id_no	= (String)hash.get("national_id_no");
			String order_type		= (String)hash.get("order_type");
			String order_date_from  = (String)hash.get("order_date_from");
			String order_date_to	= (String)hash.get("order_date_to");
			String fill_doc_num=(String)hash.get("fill_doc_num")==null?"": (String)hash.get("fill_doc_num"); //Added by Himanshu for GHL-CRF-0672
			bean.setOrderDateFrom(order_date_from);
			bean.setOrderDateTo(order_date_to);	
			bean.setNursingUnit(nursing_unit);
			bean.setPriority(priority);
			bean.setPatientID(patient_id);
			bean.setDispLevelValue(disp_level);
			bean.setIPScope(ip_scope);
			bean.setNationalIDNo(national_id_no);
			bean.setOrderType(order_type);
			bean.setCriteriaOrderType(order_type);

			bean.setGroupByOrdLocn((String)hash.get("group_by_ord_locn"));
			bean.setIncludeDrugsByFreqDurn(include_orders_by_freq_durn);	// Method name setExcludeDrugsByFreqDurn changed to setIncludeDrugsByFreqDurn for SRR20056-CRF-0663
			bean.setIncludeAbsoluteOrders(include_absolute_orders);	// Added for SRR20056-CRF-0663
			bean.setExcludePRNOrders((String)hash.get("exclude_PRN_orders"));
			bean.setDrugMedical((String)hash.get("drug_medical"));
			bean.setBedNo((String)hash.get("bed_no")); // Added for KDAH-CRF-0338
			bean.setFill_doc_num(fill_doc_num);     //Added by Himanshu for GHL-CRF-0672
			
			if(tab_based_group_sort_disp.equals("Y")){//added for CRF# PMG25006-CRF-0867 -start
				bean.setCustomGroupBy((String)hash.get("customGroupBy"));
				bean.setCustomGroupOrder((String)hash.get("customGroupOrder"));
				bean.setCustomSortBy((String)hash.get("customSortBy"));
				bean.setCustomSortOrder((String)hash.get("customSortOrder"));
				bean.setCustomTabBased((String)hash.get("customTabBased")); 
				bean.setCustomTabBasedHrs((String)hash.get("customTabBasedHrs"));
				String customTabBasedOption = (String)hash.get("customTabBasedOption");
				if(customTabBasedOption!=null && customTabBasedOption.equals("1"))
					customTabBasedOption = "PAST";
				else if(customTabBasedOption!=null && customTabBasedOption.equals("2"))
					customTabBasedOption = "CURRENT";
				else
					customTabBasedOption="";
				bean.setCustomTabBasedOption(customTabBasedOption);
			}//added for CRF# PMG25006-CRF-0867 -End
		}
		else{
			String nursing_unit		= (String)hash.get("nursing_unit");
			String priority			= (String)hash.get("priority");
			//String order_id			= (String)hash.get("order_id");//Commented for FD-JD-CRF-0181
			       patient_id		= (String)hash.get("patient_id");
			String admixture_type	= (String)hash.get("admixture_type");
			String disp_level		= (String)hash.get("disp_level");
			String ip_scope			= (String)hash.get("ip_scope");
			String national_id_no	= (String)hash.get("national_id_no");
			String order_type		= (String)hash.get("order_type");
			String order_date_from  = (String)hash.get("order_date_from");
			String order_date_to	= (String)hash.get("order_date_to");
			String disp_locn_iae=(String)hash.get("disp_locn")==null?"": (String)hash.get("disp_locn"); //Added by Himanshu for MMS-DM-CRF-0232
			String prescription_num=(String)hash.get("prescription_num")==null?"": (String)hash.get("prescription_num"); //Added by Himanshu for GHL-CRF-0672
			
			System.out.println("prescription_numprescription_numprescription_num "+prescription_num);
			bean.setPrescription_number(prescription_num);

			bean.setOrderDateFrom(order_date_from);
		    bean.setOrderDateTo(order_date_to);		

			if(admixture_type==null){
				admixture_type="";
			}
			bean.setAdmixtureType(admixture_type);
			bean.setNursingUnit(nursing_unit);
			bean.setPriority(priority);
			bean.setPatientID(patient_id);
			//bean.setOrderID(order_id);//Commented for JD-CRF-0181 [IN:40699]
			bean.setDispLevelValue(disp_level);
			bean.setIPScope(ip_scope);
			bean.setNationalIDNo(national_id_no);
			bean.setOrderType(order_type);
			bean.setCriteriaOrderType(order_type);

			bean.setGroupByOrdLocn((String)hash.get("group_by_ord_locn"));
	        bean.setIncludeDrugsByFreqDurn(include_orders_by_freq_durn);	// Method name setExcludeDrugsByFreqDurn changed to setIncludeDrugsByFreqDurn for SRR20056-CRF-0663
	        bean.setIncludeAbsoluteOrders(include_absolute_orders);	// Added for SRR20056-CRF-0663
			bean.setExcludePRNOrders((String)hash.get("exclude_PRN_orders"));
            bean.setDrugMedical((String)hash.get("drug_medical"));
	        bean.setBedNo((String)hash.get("bed_no")); // Added for KDAH-CRF-0338
	      
	        //Added by Himanshu for MMS-DM-CRF-0232
	        if(disp_locn_iae.equals("all"))
	        {
	        	String strdisp_locn_code	=	"";
	        	String disp_locn_details	=  "";
	        	String disp_locn	=  "";
	        	StringTokenizer st_disp_locn =	null;
	        	ArrayList result = bean.checkToProceed(session.getAttribute("facility_id").toString(),"DispMedication");
	        	if(result.size()>0) {
	        		disp_locn_details =(String)result.get(0);
	        	}
	        	StringTokenizer stdisp_locn_details = new StringTokenizer(disp_locn_details,"|");
	        	while (stdisp_locn_details.hasMoreTokens())
	        	{
	        		disp_locn			= stdisp_locn_details.nextToken();
	        		st_disp_locn		= new StringTokenizer(disp_locn,",");
	        		strdisp_locn_code	= strdisp_locn_code+"@@@"+st_disp_locn.nextToken();
	        		//System.out.println("inside loop "+strdisp_locn_code);
	        	}

	        	bean.setDisp_locn_iae(strdisp_locn_code);
	        }else{
	        bean.setDisp_locn_iae(disp_locn_iae); 
	        }
	        
	      //Added by Himanshu for MMS-DM-CRF-0232 Ends
	        		
	        		
//System.err.println("=======**************========tab_based_group_sort_disp="+tab_based_group_sort_disp+" customGroupBy="+hash.get("customGroupBy")+" customSortBy="+hash.get("customSortBy")+" customGroupOrder="+hash.get("customGroupOrder")+" customSortOrder="+hash.get("customSortOrder")+" customTabBased="+hash.get("customTabBased")+" =customTabBasedHrs="+hash.get("customTabBasedHrs")+" customTabBasedOption="+hash.get("customTabBasedOption"));
			if(tab_based_group_sort_disp.equals("Y")){
				bean.setCustomGroupBy((String)hash.get("customGroupBy"));
				bean.setCustomGroupOrder((String)hash.get("customGroupOrder"));
				bean.setCustomSortBy((String)hash.get("customSortBy"));
				bean.setCustomSortOrder((String)hash.get("customSortOrder"));
				bean.setCustomTabBased((String)hash.get("customTabBased")); 
				bean.setCustomTabBasedHrs((String)hash.get("customTabBasedHrs"));
				String customTabBasedOption = (String)hash.get("customTabBasedOption");
				if(customTabBasedOption!=null && customTabBasedOption.equals("1"))
					customTabBasedOption = "PAST";
				else if(customTabBasedOption!=null && customTabBasedOption.equals("2"))
					customTabBasedOption = "CURRENT";
				else
					customTabBasedOption="";
				bean.setCustomTabBasedOption(customTabBasedOption);
			}
		}
		bean.setFacilityParamValues(); //added for Bru-HIMS-CRF-082 [IN:029948]
		bean.getDispMednDefltValues();	//added for JD-CRF-0170.1 [IN:040204]
		String display_dms_link_yn	   = bean.getDispDMSLink();	//added for RUT-CRF-0083.5 [IN:041511]
		if(display_dms_link_yn.equals("Y"))
			out.println("displayDMSLink('"+display_dms_link_yn+"');");//added for RUT-CRF-0083.5 [IN:041511] -End
	}
	else if(identity.equals("storeDeliveryDetails")){
		String collected_by		= (String)hash.get("collected_by");
		String gender			= (String)hash.get("gender");
		String nationality		= (String)hash.get("nationality");
		String dispensed_by		= (String)hash.get("dispensed_by");
		String date_time		= (String)hash.get("date_time");
		String Received_at		= (String)hash.get("Received_at");
		String practioner_id    = (String)hash.get("practioner_id");
		String practioner_name   = (String)hash.get("practioner_name");
         
		if(practioner_id==null)
           practioner_id="";
		if(Received_at==null)
           Received_at="";
		if(practioner_name==null)
           practioner_name="";
		bean.setCollectorDtlsFlag("Y");
		String issue_token_on_regn_yn = request.getParameter("issue_token_on_regn_yn");
		if(issue_token_on_regn_yn.equals("N")){
			bean.setDeliveryDetails(collected_by,gender,nationality,dispensed_by,date_time,Received_at,practioner_id,practioner_name);
		}
		else{
			String token_series_code = (String)hash.get("token_series_code");
			bean.setDeliveryDetails(collected_by,gender,nationality,dispensed_by,date_time,token_series_code,Received_at,practioner_id,practioner_name);
		}
	}
	else if(identity.equals("storeAdditionalCriteriaValues")){
		//bean.setAddCriteriaLocnCode((String)hash.get("disp_locn_code"));
		//bean.setAddCriteriaLocnDesc((String)hash.get("disp_locn_desc"));
		//bean.setAddCriteriaPractitionerName((String)hash.get("practitioner_name"));
		bean.setAddCriteriaPractitionerName(java.net.URLDecoder.decode((String)hash.get("practitioner_name"),"UTF-8"));//Decoded for ARYU-SCF-0073 
		bean.setAddCriteriaPractitionerID((String)hash.get("practitioner_id"));
		//bean.setAddCriteriaEncounterID((String)hash.get("encounter_id"));
		bean.setGender((String)hash.get("gender"));
		bean.setAddCriteriaNatCode((String)hash.get("nationality"));
		//bean.setAddCriteriaNatDesc((String)hash.get("nationality_desc"));
		bean.setAddCriteriaNatDesc(java.net.URLDecoder.decode((String)hash.get("nationality_desc"),"UTF-8"));//Decoded for ARYU-SCF-0073
	}
	else if(identity.equals("clearAdditionalCriteriaValues")){
		bean.clearAdditionalCriteriaValues();
	}
	else if(identity.equals("getSourceValue")){
		String function_identity = bean.getFunctionIdentity();
		out.println("showCriteriaAfterSwitch('"+bean.getSource()+"','"+function_identity+"')");
	}
	else if(identity.equals("getStoreCodeDesc")){
		String store_code = bean.getStoreCode();
		String store_desc = bean.getStoreDesc(store_code);
		String store_code_desc = store_code + "::" + store_desc;
		out.println("sendStoreCodeDesc('"+store_code_desc+"')");
	}
	else if(identity.equals("getItemCount")){
		String drug_code	= request.getParameter("drug_code");
		bean.setItemDetails(drug_code);
		int tot_count = bean.getItemCount();
		String drug_form	= request.getParameter("drug_form");
		if(drug_form != null && drug_form.equals("P")){
			String rf_id = request.getParameter("rf_id");
			bean.setRFItemDetails(rf_id);
			tot_count = bean.getItemCount()+bean.getRFItemCount();
		}
		out.println("assignItemCount('"+tot_count+"')");
	}
	else if(identity.equals("getItemCodeForDrug")){
		String drug_code	= request.getParameter("drug_code");
		out.println("assignItemCode('"+bean.getItemCodeForDrug(drug_code)+"')");
	}
	else if(identity.equals("getTotalAvailableQty")){		
		String st_bean_id		  = "batchSearchBean";
		String st_bean_name	      = "eST.BatchSearchBean" ;
		BatchSearchBean st_bean = (BatchSearchBean)getBeanObject( st_bean_id, st_bean_name,request ) ;
		st_bean.setLanguageId(locale);
		out.println("assignTotalAvailableQty('"+st_bean.getTotalAvailableQty()+"')");
		putObjectInBean(st_bean_id,st_bean,request);
	}
	else if(identity.equals("getItemCode")){
		ArrayList item_details = bean.getItemDetails();
		out.println("assignItemCode('"+item_details.get(0)+"')");
	}
	else if(identity.equals("getDrugForm")){
		String drug_code = (String)hash.get("drug_code");
		String drug_form = bean.getDrugForm(drug_code);
		out.println("assignDrugForm('"+drug_form+"')");
	}
	else if(identity.equals("getRfQty")){
		String facility_id        = (String) session.getValue("facility_id") ;
		String drug_code = (String)hash.get("drug_code");
		String rf_id = (String)hash.get("rf_id");
		String rf_qty = (bean.getRfQty())+"";			
		String rf_qty_uom = bean.getRfQtyUOM();	
		String rf_qty_uom1 =bean.getUomDisplay(facility_id,rf_qty_uom);	////Added code for the incident 21215 to  converting UOM value to descriptin &code on 7/May/2010
		out.println("assignStabilityInfoAndRfQty('"+rf_qty+"',\""+rf_qty_uom1+"\")");
	}
	else if(identity.equals("getStockQtyUOM")){
		String rf_id	     = (String)hash.get("rf_id");
		String rf_qty        = (String)hash.get("rf_qty");
		String facility_id        = (String) session.getValue("facility_id") ;
		bean.setStockQtyUOM(rf_qty,rf_id);
		String stock_qty     = bean.getStockQty();
		String stock_qty_uom = bean.getStockQtyUOM();
		String stock_qty_uom1 = bean.getUomDisplay(facility_id,stock_qty_uom);  //Added code for the incident 21215 to  converting UOM value to descriptin &code on 7/May/2010
       //stock_qty_uom =bean.getUomDisplay(session.getValue( "facility_id" ),stock_qty_uom);
		out.println("assignStockQtyUOM('"+stock_qty+"',\""+stock_qty_uom1+"\")");
	}
	else if(identity.equals("alloc_batches")){
		String drug_item_count = (String)hash.get("drug_item_count");
		String order_line_no = (String)hash.get("order_line_no");
		String flag = request.getParameter("flag");
		if(flag==null)flag="";
		if(!flag.equals("RF")){		// Drug
			String drug_code		= null;
			String item_code		= null;
			//String alloc_qty_count	= null;
			String row_count		= null;
			String alloc_qty		=	null;
			Hashtable ht_ws_allocated_qty = bean.getHTWSAllocatedQty();
			Hashtable ws_allocated_qty = (Hashtable)ht_ws_allocated_qty.get(order_line_no);
			ArrayList show_qty				=	null;

			for (int i=1;i<=Integer.parseInt(drug_item_count);i++){
				 show_qty = new ArrayList();
				 drug_code = (String)hash.get("drug_code"+i);
				 item_code = (String)hash.get("item_code"+i);
				 //alloc_qty_count = (String)hash.get("alloc_qty_count");
				 row_count = 	(String)hash.get("row_count"+i);
				if(row_count==null)row_count = "0";

				for (int k=1;k<Integer.parseInt(row_count);k++){
					ws_allocated_qty = (Hashtable)ht_ws_allocated_qty.get(order_line_no);
					if (hash.get("alloc_qty"+i+k)!= null){
						alloc_qty = (String)hash.get("alloc_qty"+i+k);						
						//bean.wsAllocateQty(item_code,drug_code,alloc_qty,order_line_no);					
						show_qty.add((String)hash.get("alloc_qty"+i+k));
						if(ws_allocated_qty==null){
							bean.wsAllocateQty(item_code,drug_code,(String)hash.get("alloc_qty"+i+k),order_line_no);
					    }
						else{
							ws_allocated_qty.put(item_code+drug_code,show_qty);
					    }
					}
				}			
			}		
		}
		else if(flag.equals("RF")){	// RF - Reconst Fluid
			Hashtable ht_allocate_batches = bean.getHTWSFluidAllocateBatches();
			ArrayList ws_show_batches_records_fluid = (ArrayList)ht_allocate_batches.get(order_line_no);
			for (int i=1;i<=(ws_show_batches_records_fluid.size())/16;i++){
				String alloc_qty = (String)hash.get("alloc_qty"+i);
				ws_show_batches_records_fluid.set((16*i)-1,alloc_qty);	
			}
			// objects nullified after usage
			ht_allocate_batches	=	null;
		}
		bean.setAllocatedStatus("AB"); //Allocate batches
	}
	else if (identity.equals("show_batches")){
		int outer_count = Integer.parseInt((String)hash.get("selected_outer_count"));
		int inner_count = Integer.parseInt((String)hash.get("selected_inner_count"));
		String flag			 = (String)hash.get("flag");
		String order_line_no = (String)hash.get("order_line_no"); 
		String drug_code	 = (String)hash.get("drug_code"); 
		String drug_name	 =   java.net.URLDecoder.decode((String)hash.get("drug_name"),"UTF-8"); //decode Added for [IN:041227]
		 disp_locn_code= (String)hash.get("disp_locn_code"); 
		//String store_code	 = (String)hash.get("store_code"); 
		if(flag.equals("D")){	// D - Drug
			HashMap ws_first_time_yn =(HashMap)bean.getWSFirstYN(); /*code for checking whether quantiry is allocated first time or not*/
			ws_first_time_yn.put(order_line_no+drug_code,"N"); /*ends here */ 
			Hashtable ht_ws_allocated_qty = bean.getHTWSAllocatedQty();
			ArrayList ws_show_batches_records = new ArrayList();
			String item_code				=	null;
			ArrayList show_qty				=	null;	
			for (int i=0;i<outer_count;i++){
				show_qty = new ArrayList();
				for (int j=0;j<inner_count;j++){
					String batch_id  = (String)hash.get("batch_id"+i+j);
					Hashtable ws_allocated_qty = (Hashtable)ht_ws_allocated_qty.get(order_line_no);
					if(batch_id != null){
						item_code = (String)hash.get("item_code"+i+j);
						ws_show_batches_records.add(item_code);
						ws_show_batches_records.add((String)hash.get("batch_id"+i+j));
						ws_show_batches_records.add((String)hash.get("drug_code"));
						ws_show_batches_records.add(drug_name);
						ws_show_batches_records.add(java.net.URLDecoder.decode((String)hash.get("item_desc"+i+j),"UTF-8")); //decode Added for [IN:041227]
						ws_show_batches_records.add((String)hash.get("disp_locn_code"));
						ws_show_batches_records.add((String)hash.get("store_code"));
						ws_show_batches_records.add((String)hash.get("expiry_date"+i+j));
						ws_show_batches_records.add((String)hash.get("bin_locn_code"+i+j));
						ws_show_batches_records.add((String)hash.get("bin_locn_desc"+i+j));
						ws_show_batches_records.add((String)hash.get("trade_id"+i+j));
						ws_show_batches_records.add(java.net.URLDecoder.decode((String)hash.get("trade_name"+i+j),"UTF-8")); // decode added for [IN:041227]
						ws_show_batches_records.add((String)hash.get("manufacturer_id"+i+j));
						ws_show_batches_records.add((String)hash.get("manufacturer_name"+i+j));
						ws_show_batches_records.add((String)hash.get("available_qty"+i+j));
						show_qty.add((String)hash.get("alloc_qty"+i+j));				
						if(ws_allocated_qty==null){
							bean.wsAllocateQty(item_code,drug_code,(String)hash.get("alloc_qty"+i+j),order_line_no);
						}else{
							ws_allocated_qty.put(item_code+drug_code,show_qty);
						}
					}
				}
			}
			Hashtable ht_allocate_batches = bean.getHTWSAllocateBatches();
			ht_allocate_batches.put(order_line_no,ws_show_batches_records);
			// objects nullified after usage
			ht_ws_allocated_qty			=	null;
			//ws_allocated_qty			=	null;
			ws_show_batches_records		=	null;
			show_qty					=	null;
		}
		else if(flag.equals("F")){	// F - Reconst Fluid
			ArrayList ws_show_batches_records_fluid = new ArrayList();
			//ArrayList show_qty			=	null;
			String item_code			=	null;
			for (int i=0;i<outer_count;i++){
			//	show_qty = new ArrayList();
				for (int j=0;j<inner_count;j++){
					item_code = (String)hash.get("item_code"+i+j);
					if(item_code!=null){
						ws_show_batches_records_fluid.add(item_code);
						ws_show_batches_records_fluid.add((String)hash.get("batch_id"+i+j));
						ws_show_batches_records_fluid.add((String)hash.get("drug_code"));
						ws_show_batches_records_fluid.add(drug_name);
					    ws_show_batches_records_fluid.add(java.net.URLDecoder.decode((String)hash.get("item_desc"+i+j),"UTF-8")); //decode Added for [IN:041227]
						ws_show_batches_records_fluid.add((String)hash.get("disp_locn_code"));
						ws_show_batches_records_fluid.add((String)hash.get("store_code"));
						ws_show_batches_records_fluid.add((String)hash.get("expiry_date"+i+j));
						ws_show_batches_records_fluid.add((String)hash.get("bin_locn_code"+i+j));
						ws_show_batches_records_fluid.add((String)hash.get("bin_locn_desc"+i+j));
						ws_show_batches_records_fluid.add((String)hash.get("trade_id"+i+j));
						ws_show_batches_records_fluid.add(java.net.URLDecoder.decode((String)hash.get("trade_name"+i+j),"UTF-8")); // decode added for [IN:041227]
						ws_show_batches_records_fluid.add((String)hash.get("manufacturer_id"+i+j));
						ws_show_batches_records_fluid.add((String)hash.get("manufacturer_name"+i+j));
						ws_show_batches_records_fluid.add((String)hash.get("available_qty"+i+j));
						ws_show_batches_records_fluid.add((String)hash.get("alloc_qty"+i+j));
				   }
				}
			}
			Hashtable ht_allocate_batches = bean.getHTWSFluidAllocateBatches();
			ht_allocate_batches.put(order_line_no,ws_show_batches_records_fluid);
			bean.setAllocatedStatus("SB"); 
			// objects nullified after usage
			ws_show_batches_records_fluid		=	null;
		}
	}
	else if(identity.equals("ws_add_drug_details")){
		String physical_form = (String)hash.get("physical_form");
		String order_line_no = (String)hash.get("order_line_no");
		String rf_id		 = (String)hash.get("rf_id");
		String drug_code     = (String)hash.get("drug_code");
		String fluid_qty_as_per_order = (String)hash.get("fluid_qty_as_per_order");
		String drug_qty_as_per_order  = (String)hash.get("drug_qty_as_per_order");
		String fluid_qty_preparation  = (String)hash.get("fluid_qty_preparation");
		String drug_qty_preparation   = (String)hash.get("drug_qty_preparation");
		String fluid_qty_spillage	  = (String)hash.get("fluid_qty_spillage");
		String drug_qty_spillage	  = (String)hash.get("drug_qty_spillage");
		String fluid_qty_drawn		  = (String)hash.get("fluid_qty_drawn");
		String drug_qty_drawn		  = (String)hash.get("drug_qty_drawn");
		ArrayList arrList = new ArrayList();
		arrList.add(drug_code);
		arrList.add(drug_qty_as_per_order);
		arrList.add(drug_qty_preparation);
		arrList.add(drug_qty_spillage);
		arrList.add(drug_qty_drawn);
		if(physical_form.equals("P")){	// P - Powder form
			arrList.add(rf_id);
			arrList.add(fluid_qty_as_per_order);
			arrList.add(fluid_qty_preparation);
			arrList.add(fluid_qty_spillage);
			arrList.add(fluid_qty_drawn);
		}
		bean.addDrugDetails(order_line_no,arrList);
		bean.addAllocatedDrugs(drug_code,order_line_no);
		// objects nullified after usage
		arrList		=	null;
	}
	else if(identity.equals("save_mfg_label_details")){
		String mfg_unit		 = java.net.URLDecoder.decode((String)hash.get("mfg_unit"),"UTF-8");
		String batch_id		 = (String)hash.get("batch_id");
		String expiry_date	 = (String)hash.get("expiry_date");
		String qty_volume    = (String)hash.get("qty_volume");
		String qty_uom		 = (String)hash.get("qty_uom");
		String Admin_Inst	 = (String)hash.get("Admin_Inst")==null?"":(String)hash.get("Admin_Inst");
		String infusion_line = (String)hash.get("infusion_line");
		String finalise_yn  = (String)hash.get("finalise_yn");			 
		ArrayList arr_list  = new ArrayList();
		arr_list.add(mfg_unit);
		arr_list.add(batch_id);
		arr_list.add(expiry_date);
		arr_list.add(qty_volume);
		arr_list.add(qty_uom);
		arr_list.add(Admin_Inst);
		arr_list.add(finalise_yn);
		arr_list.add(infusion_line);
		bean.setMfgUnitDetails(arr_list);
		// objects nullified after usage
		arr_list		=	null;
	}
	else if(identity.equals("drawn_from_stock")){
		String ordered_qty = (String)hash.get("ordered_qty");
		String order_line_no = (String)hash.get("order_line_no");
		bean.setOrderedQty(order_line_no,ordered_qty);
	}
	else if(identity.equals("populateFillDate")){
		String fill_type      =  (String)hash.get("fill_type");
		disp_locn_code		  =  bean.getDispLocnCode();
		ArrayList fill_dates  =  new ArrayList();
		if(fill_type!=null && fill_type.equals("I")){
			fill_dates = bean.getIncrementalFillDateTime(disp_locn_code);
		}
		else{
			fill_dates = bean.getRoutineFillDateTime(disp_locn_code);
		}
		String fillbean_date="";
		for (int i=0;i<fill_dates.size();i++){
			//Added IF-Else Condition For converting IncrementingFillDates to Thai for the incident num:25101 on 25/Nov/2010== By Sandhya
			if(!locale.equals("en")){
				fillbean_date=com.ehis.util.DateUtils.convertDate((String)fill_dates.get(i),"DMYHM","en",locale);
			}
			else{		
				fillbean_date=(String)fill_dates.get(i);
			}
			out.println("assignFillDate('"+fillbean_date+"')");
		}
	}
	else if(identity.equals("getFillProc")){
		out.println("clearData('document.frmDispMedicationQueryCriteriaIP.fill_proc_id');") ;
		out.println("clearData('document.frmDispMedicationQueryCriteriaIP.nursing_unit');") ;
		String added_date		  = (String) hash.get("added_date");
		String proc_type		  = (String) hash.get("proc_type");
		String OrderingFacility	  = (String) hash.get("OrderingFacility");
		ArrayList fillProcId	  = new ArrayList();
		
		fillProcId	= bean.getFillProcId(added_date,proc_type,OrderingFacility);

		for (int i=0;i<fillProcId.size();i++){
			out.println("addOption('"+fillProcId.get(i)+"','"+fillProcId.get(i)+"',document.frmDispMedicationQueryCriteriaIP.fill_proc_id);");
		}
	}
	else if(identity.equals("getNursingUnit")){
		out.println("clearData('document.frmDispMedicationQueryCriteriaIP.nursing_unit');") ;
		String added_date		  = request.getParameter( "added_date" );
		String fill_proc_id		  = request.getParameter( "fill_proc_id" );
		String facility_id		  = request.getParameter( "facility_id" );
		String p_user_name        = request.getParameter( "p_user_name" );
		disp_stage         = "DF";
		disp_locn_code     = request.getParameter( "disp_locn_code" );
		ArrayList nursingUnits	  = bean.getNursingUnit(added_date,fill_proc_id,facility_id);
		if(nursingUnits==null || nursingUnits.size()== 0 ){
			out.println("getFillProc()");
		}
		String lock_status		  ="";
		String user_id		      ="";
		String locked_date_time	  ="";
		String Unlock_all_records_yn ="";
		HashMap AccessRightMap = new HashMap();
		for (int i=0;i<nursingUnits.size();i+=2){
			out.println("addOption(\""+((String)nursingUnits.get(i))+"\",\""+((String)nursingUnits.get(i+1))+"\",document.frmDispMedicationQueryCriteriaIP.nursing_unit);");
		}
//changed during PE By naveen
		//String allow_disp_record_lock_yn=bean.getAllowdisprecordlock(facility_id);
		String allow_disp_record_lock_yn=bean.getAllow_disp_record_lock_yn();
		//out.println("allow_disp_record_lock_yn--->"+allow_disp_record_lock_yn);
		if(allow_disp_record_lock_yn.equals("Y")){
		    lock_status=bean.getLockStatus_Delivery_stage(fill_proc_id,disp_locn_code,p_user_name,disp_stage);
			ArrayList AccessRight=bean.getAccessRightStatus(p_user_name,fill_proc_id,disp_locn_code,disp_stage);
	//commented during PE By Naveen
			//Unlock_all_records_yn=bean.getUnLockRecordsYN(p_user_name,disp_locn_code);
			Unlock_all_records_yn=bean.geuUnlockAllRecordsYN();

			if(AccessRight.size()>0){
			  for(int j=0; j<AccessRight.size(); j++){
					AccessRightMap = (HashMap)AccessRight.get(j);
					user_id = (String)AccessRightMap.get("user_id");
					locked_date_time = (String)AccessRightMap.get("locked_date_time");
				}
			}
		}
		else if(allow_disp_record_lock_yn.equals("N")){
			lock_status="0";
		}
		out.println("Unlock_Delivery_Status_yn('"+lock_status+"','"+user_id+"','"+locked_date_time+"')");
	}
	else if(identity.equals("unlockrecorddelivery_yn")){
		
		String login_user	= request.getParameter("p_user_name");
		String fill_proc_id	= request.getParameter("fill_proc_id");
		disp_locn_code		= request.getParameter("disp_locn_code");
		disp_stage		    = request.getParameter("disp_stage");
		String patient_id_status	= request.getParameter("patient_id_status");
		String p_delivery_fill_yn	= request.getParameter("p_delivery_fill_yn"); 
		String Icon_unlock_status	= request.getParameter("Icon_unlock_status"); 
		String Icon_unlock="";
		if(bean.getAllow_disp_record_lock_yn().equals("Y")){
			Icon_unlock = bean.geticonUnlock(login_user,fill_proc_id,disp_locn_code,disp_stage,patient_id_status,p_delivery_fill_yn);
			if(Icon_unlock_status.equals("Y")){
				out.println("Icon_unlock_status_return('"+Icon_unlock+"','"+Icon_unlock_status+"')");
			}
		}
	}
	else if(identity.equals("refynstatus")){
		String order_id      =  (String)request.getParameter("order_id");
		String order_line_num =  (String)request.getParameter("order_line_num");
		bean.setReferral(order_id,order_line_num);
	}
	else if (identity.equals("nationalityHealthCardNo")){
		ArrayList result =	bean.getNationalityHealthCardNo(patient_id);
		if (result.size()>0){
			out.println("assignNationalityHealthCardNo('"+result.get(0)+"','"+result.get(1)+"')");
		}
	}
	else if(identity.equals("refcancel")){
			bean.unsetReferral();
	}
	else if(identity.equals("VERIFY_REMARKS")){
		String verify_remark	= (String)hash.get("verify_remarks");
		verify_remark	=  java.net.URLDecoder.decode(verify_remark,"UTF-8"); //uncommented for ML-MMOH-SCF-0327 [IN:058772] //Commented on 20/Oct/2010 for the incident num:24587===By Sandhya
		String order_id			= (String)hash.get("order_id");
		String order_line_no	= (String)hash.get("order_line_no");
		HashMap verifyremarks   = (HashMap)bean.getverifyremarks();
		verifyremarks.put((order_id+order_line_no),verify_remark);
	}
	else if(identity.equals("modify_mfg_label_details")){
		String facility_id	= (String)hash.get("facility_id");
		String disp_locn	= (String)hash.get("disp_locn");
		String worksheet_id = (String)hash.get("worksheet_id");
		String mfg_unit		= java.net.URLDecoder.decode((String)hash.get("mfg_unit"),"UTF-8");
		String batch_id		= (String)hash.get("batch_id");
		String expiry_date	= (String)hash.get("expiry_date");
		String qty_volume   = (String)hash.get("qty_volume");
		String qty_uom		= (String)hash.get("qty_uom");
		String Admin_Inst	= (String)hash.get("Admin_Inst");

		   if(Admin_Inst==null)Admin_Inst="";
		String ord_type		= request.getParameter("ord_type");
		   if(ord_type==null)ord_type="";
		String infusion_line = (String)hash.get("infusion_line");
		String finalise_yn  = (String)hash.get("finalise_yn");
		//out.println("<script>alert('"+ord_type+"'   )</script>");
		ArrayList arr_list = new ArrayList();
		arr_list.add(facility_id);
		arr_list.add(disp_locn);
		arr_list.add(worksheet_id);
		arr_list.add(mfg_unit);
		arr_list.add(batch_id);
		arr_list.add(expiry_date);
		arr_list.add(qty_volume);
		arr_list.add(qty_uom);
		arr_list.add(ord_type);
		arr_list.add(Admin_Inst);
		arr_list.add(finalise_yn);
		arr_list.add(infusion_line);		
		bean.modifyMfctDetails(arr_list);	
	
		// objects nullified after usage
		arr_list		=	null;
	}
	else if(identity.equals("StoreBillingDetails")){

		String called_from						 =  (String)hash.get("called_from");
		String all_stages_bean_id				 =  (String)hash.get("all_stages_bean_id");
		String all_stages_bean_name				 =  (String)hash.get("all_stages_bean_name");
		String drug_code						 =	(String)hash.get("drug_code");				
		String srl_no							 =	(String)hash.get("Srl_no");				
		String excl_incl_ind					 =	(String)hash.get("excl_incl_ind");				
		String bl_incl_excl_override_reason_code =	(String)hash.get("bl_incl_excl_override_reason_code");		
		//String bl_incl_excl_override_reason_desc =	java.net.URLDecoder.decode(((String) hash.get( "bl_incl_excl_override_reason_desc" )),"UTF-8");
				patient_id						 =	(String)hash.get("patient_id");				
		String encounter_id					     =	(String)hash.get("encounter_id");				
		String sal_trn_type						 =	(String)hash.get("sal_trn_type");				
		String sysdate							 =	(String)hash.get("sysdate");	
		String store_code						 =	(String)hash.get("store_code");	
		String tot_alloc_qty					 =  (String)hash.get("tot_alloc_qty");
		String batch_str						 =  (String)hash.get("batch_str");
		String order_id							 =  (String)hash.get("order_id");
		String order_line_no					 =  (String)hash.get("order_line_no");
		float tot_gross_charge_amount			 =  Float.parseFloat((String)hash.get("tot_gross_charge_amount"));
		float tot_groos_pat_payable				 =  Float.parseFloat((String)hash.get("tot_groos_pat_payable"));
	        
		float tot_gross_amount				     = 0;//added for ML-BRU-CRF-0469 start
	    
	    if(!(bean.checkForNull((String)hash.get("tot_gross_amount")).toString()).equals("")){ // !((String)hash.get("tot_gross_amount")).equals("") Changed to  !(bean.checkForNull((String)hash.get("tot_gross_amount")).toString()).equals("") for ML-BRU-SCF-1851
	    	 tot_gross_amount				 = Float.parseFloat((String)hash.get("tot_gross_amount"));
	    }
	  //added for ML-BRU-CRF-0469 end
		float old_gross_charge_amount			 =  Float.parseFloat((String)hash.get("old_gross_charge_amount"));
		float old_groos_pat_payable			     =  Float.parseFloat((String)hash.get("old_groos_pat_payable"));
		//added for ML-BRU-CRF-0469 -start
		float   old_gross_amount			         =  0;
		  if(!(bean.checkForNull((String)hash.get("old_gross_amount")).toString()).equals("")){ // !((String)hash.get("old_gross_amount")).equals("") Changed to !(bean.checkForNull((String)hash.get("old_gross_amount")).toString()).equals("") for ML-BRU-SCF-1851
			  old_gross_amount= Float.parseFloat((String)hash.get("old_gross_amount"));
		  }
		  //added for ML-BRU-CRF-0469 - end
		String gross_charge_amount				 =  "";
		String groos_pat_payable				 =  "";	
		String gross_amount                      = "";//added for ML-BRU-CRF-0469
		String tot_gross_charge_amount_str		 =  "";
		String tot_groos_pat_payable_str		 =  "";
		String tot_gross_amount_str               = "";//added for ML-BRU-CRF-0469
		
		String dischargeIND		                 =  (String)hash.get("dischargeIND");
		//boolean calculate_total					 =  false;
		String decimalFormatString				 =  "";

		DispMedicationAllStages all_stages_bean = (DispMedicationAllStages)getBeanObject( all_stages_bean_id, all_stages_bean_name, request);
		HashMap chareg_det                      = (HashMap)all_stages_bean.callItemChargeDtls(patient_id,encounter_id,sal_trn_type,drug_code,Double.parseDouble(tot_alloc_qty), batch_str,sysdate,store_code,excl_incl_ind,bl_incl_excl_override_reason_code,order_id,order_line_no,called_from,dischargeIND);
		MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request); // Added for ML-BRU-CRF-0469 [IN:065426]
		if(chareg_det.get("error_msg").equals("")){
			HashMap det =new HashMap();
			det.put("BL_EXCL_INCL_IND",excl_incl_ind);
			det.put("BL_INCL_EXCL_OVERRIDE_REASON_CODE",bl_incl_excl_override_reason_code);   
		  
			if(called_from.equals("V")){
				all_stages_bean.setBiilingReasonDetails(patient_id+order_id+order_line_no,det) ;
			}
			else{
				all_stages_bean.setBiilingReasonDetails(patient_id+order_id+order_line_no+drug_code,det) ;
			}

			decimalFormatString=(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
			/*if(!chareg_det.get("grosschargeamt").equals("null")){
				gross_charge_amount= (String)chareg_det.get("grosschargeamt");
			}*/ //Commented for ML-BRU-SCF-0368 [IN:034748]
			if(!chareg_det.get("patnetamt").equals("null")){
				groos_pat_payable  = (String)chareg_det.get("patnetamt");
			}
			if(!chareg_det.get("netchargeamt").equals("null")){
				//groos_pat_payable  = (String)chareg_det.get("netchargeamt");
				gross_charge_amount  = (String)chareg_det.get("netchargeamt"); //added ML-BRU-SCF-0368 [IN:034748]
			}
			//added for ML-BRU-CRF-0469 start 
			if(!chareg_det.get("grosschargeamt").equals("null")){
				gross_amount  = (String)chareg_det.get("grosschargeamt"); 
			}
			//added for ML-BRU-CRF-0469 end
			tot_gross_charge_amount = tot_gross_charge_amount-old_gross_charge_amount;
			tot_groos_pat_payable = tot_groos_pat_payable-old_groos_pat_payable;
			tot_gross_amount      =	tot_gross_amount-old_gross_amount;//added for ML-BRU-CRF-0469
			
			tot_gross_charge_amount = tot_gross_charge_amount+Float.parseFloat(gross_charge_amount);
			tot_groos_pat_payable   = tot_groos_pat_payable+Float.parseFloat(groos_pat_payable);
			DecimalFormat dfTest    = new DecimalFormat(decimalFormatString);
			tot_gross_amount        = tot_gross_amount+Float.parseFloat(gross_amount);//added for ML-BRU-CRF-0469
			
			tot_gross_charge_amount_str = dfTest.format(tot_gross_charge_amount);
			tot_groos_pat_payable_str   = dfTest.format(tot_groos_pat_payable);
		
			tot_gross_amount_str   = dfTest.format(tot_gross_amount);//added for ML-BRU-CRF-0469 
		 if(!bean.getPatientclass().equalsIgnoreCase("IP")){ //added for ML-BRU-CRF-0469 - Start 
			medplan_bean.setStrTotal_gross_charge_amount(tot_gross_charge_amount_str);
			medplan_bean.setStrTotal_gross_amount(tot_gross_amount_str);
			medplan_bean.setstrTotal_charge_amount(tot_groos_pat_payable_str);//added for ML-BRU-CRF-0469 - End
		 }
			out.println("setBillingAmounts('"+srl_no+"','"+gross_charge_amount+"','"+groos_pat_payable+"','"+tot_gross_charge_amount_str+"','"+tot_groos_pat_payable_str+"','"+gross_amount+"','"+tot_gross_amount_str+"')");// ,'"+gross_amount+"','"+tot_gross_amount_str+"' added for ML-BRU-CRF-0469
		}
		chareg_det =null;
	}
	else if(identity.equals("getCalculatedamounts")) {
		String	mark_up_down							=	(String) hash.get("mark_up_down");
		String	gross_admx_prep_charge					=	(String) hash.get("gross_admx_prep_charge");				
		String	groos_pat_payable_admx_prep_charge		=	(String) hash.get("groos_pat_payable_admx_prep_charge");
		String	bl_decimal_format_Str					=	(String) hash.get("bl_decimal_format_Str");
		
		DecimalFormat dfTest							=   new DecimalFormat(bl_decimal_format_Str);
		gross_admx_prep_charge				= dfTest.format(Float.parseFloat(mark_up_down)*Float.parseFloat(gross_admx_prep_charge));
		groos_pat_payable_admx_prep_charge  = dfTest.format(Float.parseFloat(mark_up_down)*Float.parseFloat(groos_pat_payable_admx_prep_charge));
		out.println("DisplayAmounts('"+gross_admx_prep_charge+"','"+groos_pat_payable_admx_prep_charge+"')");
	}
	else if(identity.equals("GETTOTALAMOUNTS")) {
		String	tot_gross_charge_amount					=	(String) hash.get("tot_gross_charge_amount");
		String	tot_groos_pat_payable					=	(String) hash.get("tot_groos_pat_payable");				
		String	calc_markup_gross_admx_prep_charge		=	(String) hash.get("calc_markup_gross_admx_prep_charge");
		String	calc_markup_groos_pat_payable_admx_prep_charge	=	(String) hash.get("calc_markup_groos_pat_payable_admx_prep_charge");

		String	bl_decimal_format_Str					=	java.net.URLDecoder.decode((String) hash.get("bl_decimal_format_str"));
		DecimalFormat dfTest							=   new DecimalFormat(bl_decimal_format_Str);

		tot_gross_charge_amount	= dfTest.format(Float.parseFloat(tot_gross_charge_amount)+Float.parseFloat(calc_markup_gross_admx_prep_charge));
		tot_groos_pat_payable   = dfTest.format(Float.parseFloat(tot_groos_pat_payable)+Float.parseFloat(calc_markup_groos_pat_payable_admx_prep_charge));

		out.println("displaytotalamounts('"+tot_gross_charge_amount+"','"+tot_groos_pat_payable+"')");
			
	}
	else if(identity.equals("SetItemDetails")){

		String all_stages_bean_id				 =  (String)hash.get("all_stages_bean_id");
		String all_stages_bean_name				 =  (String)hash.get("all_stages_bean_name");
		String itemCodes	= (String) hash.get( "itemCodes" )==null?"":(String) hash.get( "itemCodes" );
		String tradeCodes	= (String) hash.get( "tradeCodes" )==null?"":(String) hash.get( "tradeCodes" );
		String tradeNames	= (String) hash.get( "tradeNames" )==null?"":(String) hash.get( "tradeNames" );
		String bl_install_yn		= (String) hash.get( "bl_install_yn" )==null?"":(String) hash.get( "bl_install_yn" );
		String take_home_medication	= (String) hash.get( "take_home_medication" )==null?"":(String) hash.get( "take_home_medication" );
		String priority	= (String) hash.get( "priority" )==null?"":(String) hash.get( "priority" );
		String count	= (String) hash.get( "count" )==null?"0":(String) hash.get( "count" );
		String tradeCodesArr[] = tradeCodes.split(",");
		String tradeNamesArr[] = tradeNames.split(",");
		String item_code="";
		String item_desc="";
		String trade_code="";
		String trade_name="";
		int trade_count=0;

		itemCodes = itemCodes.replace('[',' ');
		itemCodes = itemCodes.replace(']',' ');

		StringTokenizer stTtemCodes = new StringTokenizer(itemCodes.trim(),",");

		DispMedicationAllStages all_stages_bean = (DispMedicationAllStages)getBeanObject( all_stages_bean_id, all_stages_bean_name, request);
		
		while(stTtemCodes.hasMoreTokens()){
			item_code	=stTtemCodes.nextToken();
			if(trade_count < tradeCodesArr.length){
				trade_code=tradeCodesArr[trade_count];
				trade_name = tradeNamesArr[trade_count++];
			}
			else{
				trade_code = "";
				trade_name = "";
			}
			all_stages_bean.loadItemDetail(item_code, trade_code, trade_name, bl_install_yn );
		}
        ArrayList tot_cons_item_dtl  = (ArrayList)all_stages_bean.getConsumableDetails();
		HashMap cons_item_dtls       =  new HashMap();
		int rec_no =Integer.parseInt(count);
		if(tot_cons_item_dtl.size()>0){
           cons_item_dtls       = (HashMap)tot_cons_item_dtl.get(rec_no);
		}

       putObjectInBean(all_stages_bean_id,all_stages_bean,request);
       out.println("setItemValues('"+(String)cons_item_dtls.get("LONG_DESC")+"')");

	}
	else if(identity.equals("SetBatchDetails")){	
		String rec_no  =(String)hash.get("rec_no");
		//Date Conversion done for expiry_date regarding incident num:24587 on 21/Oct/2010===By Sandhya
		String expiry_date  = (String)hash.get("expiry_date");
		//Added if condition on 12/Nov/2010 regarding incident num:24843
		if(locale.equals("en")){
		 expiry_date  =com.ehis.util.DateUtils.convertDate(expiry_date,"DMY",locale,"en");
		}
		//String expiry_date  =(String)hash.get("expiry_date");
		HashMap  batch_det = new HashMap();
		batch_det.put("BATCH_ID",(String)hash.get("batch_id"));
		batch_det.put("ITEM_CODE",(String)hash.get("item_code"));
		batch_det.put("ITEM_NAME",(String)hash.get("item_name"));
		batch_det.put("STORE_CODE",(String)hash.get("store_code"));
		batch_det.put("STORE_DESC",(String)hash.get("store_desc"));
		batch_det.put("EXPIRY_DATE",expiry_date);
		batch_det.put("BIN_LOCN_CODE",(String)hash.get("bin_locn_code"));
		batch_det.put("BIN_LOCN_DESC",(String)hash.get("bin_locn_desc"));
		batch_det.put("TRADE_ID",(String)hash.get("trade_id"));
		batch_det.put("TRADE_DESC",(String)hash.get("trade_desc"));
		batch_det.put("MANUFACTURER_CODE",(String)hash.get("manufacturer_code"));
		batch_det.put("MANUFACTURER_DESC",(String)hash.get("manufacturer_desc"));
		batch_det.put("AVAIL_QTY",(String)hash.get("avail_qty"));

		String sysdate =(String)hash.get("sysdate");

		String all_stages_bean_id				 =  (String)hash.get("all_stages_bean_id");
		String all_stages_bean_name				 =  (String)hash.get("all_stages_bean_name");
		
		DispMedicationAllStages all_stages_bean = (DispMedicationAllStages)getBeanObject( all_stages_bean_id, all_stages_bean_name, request);

		ArrayList tot_cons_item_dtl  = (ArrayList)all_stages_bean.getConsumableDetails();
		HashMap cons_item_dtls       =  new HashMap();
		int srl_no                   =  Integer.parseInt(rec_no);
		cons_item_dtls               = (HashMap)tot_cons_item_dtl.get(srl_no);
		if(cons_item_dtls.size()>0){
			 cons_item_dtls.put("BATCH_DET",batch_det) ;
		}
	}
	else if(identity.equals("SetSelectedRecord")){
		String srl_no                     =  (String) hash.get("rec_no");
		String selected_yn				  =  (String)hash.get("selected_yn");
		String all_stages_bean_id		  =  (String)hash.get("all_stages_bean_id");
		String all_stages_bean_name		  =  (String)hash.get("all_stages_bean_name");
		DispMedicationAllStages all_stages_bean = (DispMedicationAllStages)getBeanObject( all_stages_bean_id, all_stages_bean_name, request);

		ArrayList tot_cons_item_dtl  = (ArrayList)all_stages_bean.getConsumableDetails();
		HashMap cons_item_dtls       =  new HashMap();
		int rec_no                   =  Integer.parseInt(srl_no);
		cons_item_dtls               = (HashMap)tot_cons_item_dtl.get(rec_no);

		if(cons_item_dtls.size()>0){
			cons_item_dtls.put("SELECTED_YN",selected_yn);                   
		}  
	}
	else if(identity.equals("StoreConcumableBillingDetails")){
		String bl_install_yn                     =  (String) hash.get("bl_install_yn");
		String all_stages_bean_id				 =  (String)hash.get("all_stages_bean_id");
		String all_stages_bean_name				 =  (String)hash.get("all_stages_bean_name");
		String drug_code						 =	(String)hash.get("drug_code");				
		String srl_no							 =	(String)hash.get("Srl_no");				
				patient_id						 =	(String)hash.get("patient_id");				
		String encounter_id					     =	(String)hash.get("encounter_id");				
		String sal_trn_type						 =	(String)hash.get("sal_trn_type");				
		String sysdate							 =	(String)hash.get("sysdate");	
		String store_code						 =	(String)hash.get("store_code");	
		String tot_alloc_qty					 =  (String)hash.get("tot_alloc_qty");
		String batch_str						 =  (String)hash.get("batch_str");
		String order_id							 =  (String)hash.get("order_id");
		String order_line_no					 =  (String)hash.get("order_line_no");
		String old_tot_gross_charge_amount_str	 =  (String)hash.get("tot_gross_charge_amount");
		String old_tot_groos_pat_payable_str	 =  (String)hash.get("tot_groos_pat_payable");
		String old_gross_charge_amount_str		 =  (String)hash.get("old_gross_charge_amount");
		String old_groos_pat_payable_str		 =  (String)hash.get("old_groos_pat_payable");	   
		double tot_gross_charge_amount			 = 0;
		double tot_groos_pat_payable				 = 0;
		double old_gross_charge_amount			 = 0;
		double old_groos_pat_payable			     = 0;
		HashMap  billing_det                     = new HashMap();
		String gross_charge_amount				 =  "";
		String groos_pat_payable				 =  "";			
		String tot_gross_charge_amount_str		 =  "";
		String tot_groos_pat_payable_str		 =  "";
		String decimalFormatString				 =  "";
		String err_msg							 =  "";
			String dischargeIND		                 =  (String)hash.get("dischargeIND");
		DispMedicationAllStages all_stages_bean = (DispMedicationAllStages)getBeanObject( all_stages_bean_id, all_stages_bean_name, request);

		if(bl_install_yn.equals("Y")){
			if(!old_tot_gross_charge_amount_str.equals("") && !old_tot_groos_pat_payable_str.equals("")){
				tot_gross_charge_amount			 =  Double.parseDouble((String)hash.get("tot_gross_charge_amount"));
				tot_groos_pat_payable			 =  Double.parseDouble((String)hash.get("tot_groos_pat_payable"));  
			}

			if(!old_gross_charge_amount_str.equals("") && !old_groos_pat_payable_str.equals("")){						  
				old_gross_charge_amount			 =  Double.parseDouble((String)hash.get("old_gross_charge_amount")); 
				old_groos_pat_payable			 =  Double.parseDouble((String)hash.get("old_groos_pat_payable"));
			}

			HashMap chareg_det                      = (HashMap)all_stages_bean.callItemChargeDtls(patient_id,encounter_id,sal_trn_type,drug_code,Double.parseDouble(tot_alloc_qty), batch_str,sysdate,store_code,"","","","","",dischargeIND);
			err_msg =(String)chareg_det.get("error_msg");
			if(err_msg.equals("")){
				HashMap det =new HashMap();
				decimalFormatString=(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
				 /*if(!chareg_det.get("grosschargeamt").equals("null")){
					 gross_charge_amount= (String)chareg_det.get("grosschargeamt");
				 }*/ //Commented for ML-BRU-SCF-0368 [IN:034748]
				 if(!chareg_det.get("netchargeamt").equals("null")){//added ML-BRU-SCF-0368 [IN:034748]
					gross_charge_amount  = (String)chareg_det.get("netchargeamt"); 
				 }
				 if(!chareg_det.get("patnetamt").equals("null")){
					 groos_pat_payable  = (String)chareg_det.get("patnetamt");
				 }
				 
				tot_gross_charge_amount = tot_gross_charge_amount-old_gross_charge_amount;
				tot_groos_pat_payable = tot_groos_pat_payable-old_groos_pat_payable;
				tot_gross_charge_amount = tot_gross_charge_amount+Double.parseDouble(gross_charge_amount);
				tot_groos_pat_payable   = tot_groos_pat_payable+Double.parseDouble(groos_pat_payable);

				DecimalFormat dfTest    = new DecimalFormat(decimalFormatString);
				tot_gross_charge_amount_str = dfTest.format(tot_gross_charge_amount);
				tot_groos_pat_payable_str   = dfTest.format(tot_groos_pat_payable);

				billing_det.put("GROSS_CHARGE_AMOUNT",gross_charge_amount);
				billing_det.put("GROSS_CHARGE_AMOUNT",gross_charge_amount);
				out.println("setConsumableBillingAmounts('"+err_msg+"','"+srl_no+"','"+gross_charge_amount+"','"+groos_pat_payable+"','"+tot_gross_charge_amount_str+"','"+tot_groos_pat_payable_str+"')");
		  }
		  else{
				out.println("setConsumableBillingAmounts('"+err_msg+"','"+srl_no+"','"+gross_charge_amount+"','"+groos_pat_payable+"','"+tot_gross_charge_amount_str+"','"+tot_groos_pat_payable_str+"')");
			}
			chareg_det =null;
		}
            
		ArrayList tot_cons_item_dtl  = (ArrayList)all_stages_bean.getConsumableDetails();
		HashMap cons_item_dtls       =  new HashMap();
		int rec_no                   =  Integer.parseInt(srl_no);
		cons_item_dtls               = (HashMap)tot_cons_item_dtl.get(rec_no);
		HashMap  batch_det           = new HashMap();
		if(cons_item_dtls.size()>0){
			cons_item_dtls.put("ALLOC_QTY",tot_alloc_qty);

			batch_det =(HashMap)cons_item_dtls.get("BATCH_DET");
			String item_cost	=	all_stages_bean.getItemCost((String)hash.get("item_code"),(String)hash.get("store_code"),tot_alloc_qty,sysdate);

			batch_det.put("ITEM_COST",item_cost);


			billing_det.put("GROSS_CHARGE_AMOUNT",gross_charge_amount);
			billing_det.put("GROOS_PAT_PAYABLE",groos_pat_payable);
			billing_det.put("ERROR_MSG",err_msg);

			cons_item_dtls.put("BILLING_DET",billing_det) ; 
			if(!err_msg.equals("")){
				cons_item_dtls.put("SELECTED_YN","N");   
			}
		}  
	}
	else if(identity.equals("clearBatchDetails")){	
			
			String rec_no                            =  (String)hash.get("rec_no");
			String all_stages_bean_id				 =  (String)hash.get("all_stages_bean_id");
			String all_stages_bean_name				 =  (String)hash.get("all_stages_bean_name");
			
            DispMedicationAllStages all_stages_bean = (DispMedicationAllStages)getBeanObject( all_stages_bean_id, all_stages_bean_name, request);

			ArrayList tot_cons_item_dtl  = (ArrayList)all_stages_bean.getConsumableDetails();
		    HashMap cons_item_dtls       =  new HashMap();
		    int srl_no                   =  Integer.parseInt(rec_no);
			cons_item_dtls               = (HashMap)tot_cons_item_dtl.get(srl_no);
            if(cons_item_dtls.size()>0){
				 if(cons_item_dtls.containsKey("BATCH_DET"))
                     cons_item_dtls.remove("BATCH_DET"); 
                 if(cons_item_dtls.containsKey("ALLOC_QTY"))
				     cons_item_dtls.put("ALLOC_QTY",""); 
                 if(cons_item_dtls.containsKey("BILLING_DET"))
				     cons_item_dtls.remove("BILLING_DET");
			}
		}
		else if(identity.equals("chngDurnValue")){

			String durnPrdVal		= (String)hash.get("durnPrdVal");
			String durnPrdType		= (String)hash.get("durnPrdType");
			String calledFrom		= (String)hash.get("calledFrom");

			bean.setStrChangedDispensePeriod(request.getParameter("orgDurnPrdVal"));
			bean.setStrChangedDispenseUnit(durnPrdType);	
			String strDurationType = bean.getStrIPFillPeriodUnit()==null?"":bean.getStrIPFillPeriodUnit();
//			if(!durnPrdType.equals("H")) 
				durnPrdType = "D";
			bean.setFillPeriod(durnPrdVal);
			bean.setFillUnit(durnPrdType);
			if(calledFrom.equals("REALLOCATE")){
				bean.getBarCodesForDrug().clear();//Added for KDAH-CRF-0231 [IN-034551].
				bean.getStockDtl().clear();//Added for KDAH-CRF-0231 [IN-034551].
				bean.getBatch_val().clear();//Added for KDAH-CRF-0231 [IN-034551].
				bean.getOrderDrugdtl().clear();//Added for KDAH-CRF-0231 [IN-034551].
				bean.getDrugQty().clear();//Added for KDAH-CRF-0231 [IN-034551].
			}
			if(bean.getDispLocnCatg().equals("I")){
				bean.setStrIPFillPeriodAhead(durnPrdVal);
                if(!strDurationType.equals("P")){
				     bean.setStrIPFillPeriodUnit(durnPrdType);
				}
			}
		}
		else if (identity.equals("checkOrderChanges"))		{
			String sPatientId			= (String)hash.get("patientId");
			String sEncounterId			= (String)hash.get("encounterId");
			String sDispStage			= (String)hash.get("dispStage");
			String sFillingStatus		= (String)hash.get("fillingStatus");
			String sDispLocnCatg		= (String)hash.get("dispLocnCatg");
			String sGroupByPatient		= (String)hash.get("groupByPatient");
			String sDispLevel			= (String)hash.get("dispLevel");
			String sOrderIds			= (String)hash.get("URL");
			String sIVPrepYN			= (String)hash.get("iv_prep_yn");
			String sIVOrderId			= (String)hash.get("iv_order_id");
			String sSelectedOrderType   = (String)hash.get("selectedOrderType");

			bean.setWsType(sIVPrepYN);
			bean.setEncounterID(sEncounterId);
			out.println("checkOrderChanges('','"+sIVOrderId+"','"+sPatientId+"','"+sDispStage+"','','','"+sFillingStatus+"','"+sDispLocnCatg+"','"+sGroupByPatient+"','"+sIVPrepYN+"','"+sDispLevel+"','"+java.net.URLEncoder.encode(sOrderIds)+"','"+sSelectedOrderType+"','Y')");
		}
		else if(identity.equals("setTrxOrderIds")){
			String sOrderIds			= java.net.URLDecoder.decode((String)hash.get("orderIds"));
			String sUpdate				= (String)hash.get("bUpdate");
			boolean bUpdate				= false;

			if(bean.getAlTrxOrderIds() == null || bean.getAlTrxOrderIds().size() == 0)
				bUpdate = true;
			else if (sUpdate != null && sUpdate.equals("false"))
				bUpdate = false;
			else if (sUpdate != null && sUpdate.equals("true"))
				bUpdate	 = true;

			ArrayList alOrderIds = new ArrayList();

			if(sOrderIds!=null)	{
				StringTokenizer oStringTokenizer = new StringTokenizer(sOrderIds,"::");
				while (oStringTokenizer.hasMoreElements())
					alOrderIds.add(oStringTokenizer.nextElement());        
			}
			bean.clearAlTrxOrderIds();
			bean.setAlTrxOrderIds(alOrderIds);			
			bean.setDispencePeriod(bean.getDispLocnCode());

		}
		else if(identity.equals("getOrders")){
			String sPatientId = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			String issue_token_on_regn_YN = bean.getIssueTokenOnRegnYN();
			if(issue_token_on_regn_YN.equals("Y")){
				//System.err.println("sPatientId==="+sPatientId);
            		  // bean.getOrderlingFacilityID(sPatientId); //commented for SKr-SCF-1512
			} 
			ArrayList alOrders = (ArrayList)bean.getOrders(patient_id.trim());
			if(alOrders !=null && alOrders.size()>0&& !(bean.getFillList().equals("AF"))){
				out.println("completeOtherOrders()");
			}
		}
		else if(identity.equals("clearPatientId")){
			bean.setPatientID("");
		}
		else if(identity.equals("setSelectedOrderType")){
			String sSelectedOrderType	= (String)hash.get("selectedOrderType");
			bean.setOrderType(sSelectedOrderType);
		}
		else if(identity.equals("clearTrxOrderIds")){
			String Ordering_Facility_id	= (String)hash.get("Ordering_Facility_id");
			String row_no	= (String)hash.get("row_no");//Added for Bru-HIMS-CRF-416[IN045566]
			String patient_class	= (String)hash.get("patient_class");//Added for Bru-HIMS-CRF-416[IN045566]
			bean.setOrderingFacility(Ordering_Facility_id);
			bean.clearAlTrxOrderIds();
			bean.setOrderType(bean.getCriteriaOrderType());
			bean.setRecCount(row_no);//Added for Bru-HIMS-CRF-416[IN045566]
			bean.setPatientclass(patient_class);//Added for Bru-HIMS-CRF-416[IN045566]
			bean.setRelPatientID("");//Added for Bru-HIMS-CRF-416[IN045566]
			bean.setreleaseFlag("");//Added for Bru-HIMS-CRF-416[IN045566]
			bean.SetEditableLabelLangId("");//Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1454 [IN:052271]
			bean.clearBatchDetailsForBarcodeDrug();//added for GHL-CRF-0413.1 [IN:061794]
		}
		else if(identity.equals("clearPatientValues")){
			String all_stages_bean_id				 =  (String)hash.get("all_stages_bean_id");
			String all_stages_bean_name				 =  (String)hash.get("all_stages_bean_name");
			String sPatientId	= (String)hash.get("PatientId");
            DispMedicationAllStages all_stages_bean = (DispMedicationAllStages)getBeanObject( all_stages_bean_id, all_stages_bean_name, request);
			all_stages_bean.clearPatient(sPatientId);
			putObjectInBean(all_stages_bean_id,all_stages_bean,request);
		}
		else if(identity.equals("AddPPNValues")){
			String all_stages_bean_id				 =  (String)hash.get("all_stages_bean_id");
			String all_stages_bean_name				 =  (String)hash.get("all_stages_bean_name");

			DispMedicationAllStages all_stages_bean = (DispMedicationAllStages)getBeanObject( all_stages_bean_id, all_stages_bean_name, request);

			String sEncounterId						= bean.getEncounterID();
			String sItemCode						= (String)hash.get("itemCode");
			String sTradeId							= (String)hash.get("tradeId");
			String sBatchId							= (String)hash.get("batchId");
			String sExpDate							= (String)hash.get("expiryDate");
			String sBinLocn							= (String)hash.get("binLocation");
			String sSelQty							= (String)hash.get("selectedQty");
			String sPatientID						= (String)hash.get("patientId");
			String dischargeIND		                 =  (String)hash.get("dischargeIND");

			HashMap hmPPNValues						= new HashMap();
			StringBuffer sbBatchString				= new StringBuffer();

			sbBatchString.append(sTradeId).append(";").append(sBatchId).append(";").append(sExpDate).append(";").append(sBinLocn).append(";").append(sSelQty).append(";");

			hmPPNValues.put("itemCode",sItemCode);
			hmPPNValues.put("itemDesc",(String)hash.get("itemDesc"));
			hmPPNValues.put("batchId",sBatchId);
			hmPPNValues.put("batchQty",(String)hash.get("batchQty"));
			hmPPNValues.put("tradeId",sTradeId);
			hmPPNValues.put("mfgId",(String)hash.get("mfgId"));
			hmPPNValues.put("UOMCode",(String)hash.get("UOMCode"));
			hmPPNValues.put("orderId",(String)hash.get("orderId"));
			hmPPNValues.put("patientId",sPatientID);
			hmPPNValues.put("selectedQty",sSelQty);
			hmPPNValues.put("expiryDate",sExpDate);
			hmPPNValues.put("binLocation",sBinLocn);

			HashMap hmItemCost	= new HashMap();
			float fGrossPatPayable	= 0;
			float fItemCost			= 0;
			
			if(all_stages_bean.getBLInterfaceYN().equals("Y")){ //checkforbillinginterface
				hmItemCost	= all_stages_bean.callItemChargeDtls(sPatientID,sEncounterId,all_stages_bean.getEncounterPatientClass(sEncounterId, patient_id),sItemCode,Double.parseDouble(sSelQty),sbBatchString.toString(),bean.getTodaysDate(),bean.getDispLocnCode().trim(),"","",(String)hash.get("orderId"),"1",bean.getDispStage(),dischargeIND);  // patient_id for getEncounterPatientClass added for [IN:035667] 

				if(hmItemCost!=null && hmItemCost.get("error_msg").equals("")){

					String sFormatString	= (String)hmItemCost.get("BL_DECIMAL_FORMAT_STRING");
					DecimalFormat dfTest    = new DecimalFormat(sFormatString);

					if(!hmItemCost.get("patnetamt").equals("null")){
						fGrossPatPayable  = Float.parseFloat(((String)hmItemCost.get("patnetamt")).trim());
						if(fGrossPatPayable >0){
							fItemCost		= fGrossPatPayable/ Float.parseFloat(sSelQty);
						}
					}
				}
			}
			hmPPNValues.put("itemCost",fItemCost+"");
			hmPPNValues.put("grossCost",fGrossPatPayable+"");
			hmPPNValues.put("billingError",hmItemCost.get("error_msg"));

			bean.setHmPPNValues(hmPPNValues);
		}
		else if(identity.equals("RemovePPNValues")){
			bean.setHmPPNValues(null);
		}
		else if(identity.equals("checkDispAuthYN")){
            String sDrugCodes                 =  (String) hash.get("drugCodes");
			String all_stages_bean_id		  =  (String) hash.get("bean_id");
			String all_stages_bean_name		  =  (String) hash.get("bean_name");
			String sDispDrugAuthYN			  = "N";
			DispMedicationAllStages all_stages_bean = (DispMedicationAllStages)getBeanObject( all_stages_bean_id, all_stages_bean_name, request);

			List lstDrugCodes = Arrays.asList(sDrugCodes.split("~"));
			Set stDrugCodes = new HashSet();

			for (int x=0; x< lstDrugCodes.size(); x++)  
				stDrugCodes.add(lstDrugCodes.get(x));  
			stDrugCodes.remove("");

			if(stDrugCodes.size()>0){
				sDispDrugAuthYN = all_stages_bean.getDispDrugAuthYN(stDrugCodes);
			}
			out.println("dispDrugAuthCheck('"+sDispDrugAuthYN+"');");
		}
		else if(identity.equals("checkMedicalStock")){
			String all_stages_bean_id		  =  (String) hash.get("bean_id");
			String all_stages_bean_name		  =  (String) hash.get("bean_name");
			DispMedicationAllStages all_stages_bean = (DispMedicationAllStages)getBeanObject( all_stages_bean_id, all_stages_bean_name, request);
			boolean bAvailable = all_stages_bean.checkMedicalItemStock();
			out.println("setStockAvailable('"+bAvailable+"')");
		}
		else if(identity.equals("ClearWSAllocateBatches")){
			String all_stages_bean_id		  =  (String) hash.get("bean_id");
			String all_stages_bean_name		  =  (String) hash.get("bean_name");
			bean.clearHTWSAllocateBatches();
			bean.setHTWSFluidAllocateBatches(new Hashtable());
		}
		else if(identity.equals("ClearDispBeanvalues")){
			bean.setFillProcessID("");
            bean.setNursingUnit	("");				
		}
		else if(identity.equals("getDefault")){	   // Added for ICN-30405
			String disp_locn		=  (String) hash.get("disp_locn");
			ArrayList defaultValues = bean.getDefaultValues(disp_locn);
			if(defaultValues!=null){
				out.println("setDefaultList('"+defaultValues.get(0)+"','"+defaultValues.get(1)+"')");
			}
		}
		else if(identity.equals("getDispStageverify")){	 // add this condition ML-BRU-SCF-0097[31836]
			bean.getDispStagesApplicable(disp_locn_code.trim(),disp_locn_catg.trim());			
			String homepage= hash.get("homepage")==null?"":(String) hash.get("homepage"); //added for Bru-HIMS-CRF-073.1 [IN:047222] -start
			String facility_id=(String) session.getValue( "facility_id" );
			if(homepage.equals("Y")){
				if(!bean.checkValidFlow(disp_locn_catg.trim(), disp_locn_code.trim())){
					out.println("retVal = 'PH_VERIFICATION_NOT_APPLI'");
				}
				else {
					ArrayList result = bean.checkToProceed(facility_id.trim(),"VerifyPrescriptions");
					String disp_locn_details=(String)result.get(0);
					bean.setDispLocnDetails(disp_locn_details);
					StringTokenizer stdisp_locn_details = new StringTokenizer(disp_locn_details,"|");
					String disp_locn = "";
					StringTokenizer st_disp_locn = null;
					String strdisp_locn_code = "";
					String curr_enc_financial_dtl_yn="", issue_token_on_regn_YN="";
					while (stdisp_locn_details.hasMoreTokens()){
						disp_locn = stdisp_locn_details.nextToken();
						st_disp_locn = new StringTokenizer(disp_locn,",");
						strdisp_locn_code = st_disp_locn.nextToken();
						if((strdisp_locn_code).equals(disp_locn_code)){
							disp_locn_name = st_disp_locn.nextToken();
							issue_token_on_regn_YN = st_disp_locn.nextToken();
							curr_enc_financial_dtl_yn = st_disp_locn.nextToken();
							break;
						}
					}
					bean.getDispCatg(disp_locn_code);
					bean.setCurrEncFinancialDtl(curr_enc_financial_dtl_yn);
					bean.setDispLocnCode(disp_locn_code.trim());
					bean.setDispLocnCatg(disp_locn_catg.trim());
					bean.setIssueTokenOnRegnYN(issue_token_on_regn_YN);
					bean.setDispStage("V");
					bean.setDispLocnName(java.net.URLEncoder.encode(disp_locn_name.trim(),"UTF-8"));
					DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages", request);
					bean_all_stages.getUserAuthPINYN(session.getAttribute("facility_id").toString(),disp_locn_code.trim()); 
					if(issue_token_on_regn_YN.equals("Y")&&disp_locn_catg.equals("O")){
						String resulttk = bean.validateWSForTokenSeries();
						if(resulttk.equals("N"))
							out.println("retVal ='PH_INVALID_TOKEN_SERIES_FOR_WORK_STATION'");			
						else
							out.println("retVal='GOQUERYCRITERIA'");
					}
					else{
						out.println("retVal ='GOQUERYCRITERIA'");
					}
				}
			} //added for Bru-HIMS-CRF-073.1 [IN:047222] -else
		}
		else if(identity.equals("CheckForAppointments")){
			String next_appt_days =bean.CheckForAppointments(patient_id);
			String recIndex		  =  (String) hash.get("recIndex");
			if(!next_appt_days.equals("")){
				out.println("dispAppointmentDtl('"+recIndex+"','"+next_appt_days+"')");
			}
		} /* code added for ML-BRU-SCF-0340[IN:034556] -- Start */ 		
		else if(identity.equals("tokenToGetFacility")){
		String token_series	= (String) hash.get("token_series");
		String token_no		= (String) hash.get("token_no");
		String queue_date	= (String) hash.get("queue_date");
		String facility_name	= "";
	
		facility_name = bean.getOrderingFacilityForToken(queue_date,token_series,token_no);
		
		out.println("setorderingfacilitytotoken('"+facility_name+"')");	
	}  /* code added for ML-BRU-SCF-0340[IN:034556] -- End */ 
	else if(identity.equals("CALLQMSTOEKN")){ // added for Bru-HIMS-CRF-076 [IN029942] -start
		String token_no	= (String)hash.get("token_no");
		String recIndex	= (String)hash.get("recIndex");
		String queue_date	= (String)hash.get("queue_date");
		String session_id = session.getId();
		String[] QMSResult =	bean.callQMSToken(   session_id,  token_no, queue_date);
		if(QMSResult!=null ){
			out.println("assignQMSResult('"+QMSResult[0]+"','"+QMSResult[1]+"','"+QMSResult[2]+"','"+recIndex+"');");
		}

	} // added for Bru-HIMS-CRF-076 [IN029942] -end
	else if(identity.equals("clearOrders")){//Added for Bru-HIMS-CRF-416[IN045566]--start
		bean.setRelPatientID("");
		bean.setreleaseFlag("");
	}// Added for Bru-HIMS-CRF-416[IN045566]--end
	else if(identity.equals("showhidealert")){//Added for INC#47651--START
		String relflag= bean.getreleaseFlag();
		bean.SetEditableLabelLangId("");//Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1454 [IN:052271]
		boolean rflag=false;
		if(relflag.equalsIgnoreCase("releasebatch")){
			rflag = true;}
		out.println(rflag);
	}// Added for Bru-HIMS-CRF-416[IN045566]--end
	else if(identity.equals("getDefaultDispStage")){ // else if Added for [IN:047788]
		String defStage = "";
		if(disp_locn_catg.equals("I"))
			defStage = bean.getStrIPDefStage();
		else if(disp_locn_catg.equals("O"))
			defStage = bean.getStrOPDefStage();
		if(!defStage.equals(""))
			out.println("assignDefaultDispStage('"+defStage+"');");
	}
	else if(identity.equals("toolBar"))  { //Added AMS-CRF-0068.1 [IN:050333] start 
		String toolBarString = request.getParameter( "toolBarString" ); 
		toolBarString= "menu_id=PH_MENU&module_id=PH&function_id=PH_DISP_MEDICATION&function_name=Dispense Medication&function_type=F&access=NNNNN";
		session.removeValue("queryString") ;
		session.putValue( "queryString", toolBarString ) ;
	}//Added AMS-CRF-0068.1 [IN:050333] end
	else if(identity.equals("setStockItem")){// Added for Bru-HIMS-CRF-080[IN:029946]
		String drug_code = bean.checkForNull(request.getParameter("drug_code"));
		ArrayList stock_items = new ArrayList();
		stock_items.add("Y");
		stock_items.add(drug_code);
		DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages", request);
		bean_all_stages.setStockItems(drug_code, stock_items);
	}
	else if(identity.equals("getRightsForReturnMed")){//added for MMS-QH-CRF-0201 [IN:052255] [IN:052255]
		disp_locn_code = bean.checkForNull(request.getParameter("disp_locn_code"));
		DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages", request);
		String result = bean_all_stages.getMednReturn(disp_locn_code);
		if(result.equals("Y"))
			out.println("retVal ='Y'");
		else
			out.println("retVal ='N'");
	}else if(identity.equals("getAlternateDrug")){ //added for MMS-CRF-0030 - start

			DispMedicationAllStages beanObj = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages", request);
			String qty_reqd = (String)hash.get("qty_reqd");
			String store_code = (String)hash.get("store_code");
			String eff_expiry = (String)hash.get("eff_expiry");
			String drug_code = (String)hash.get("drug_code");
			String generic_id = (String)hash.get("generic_id");
			String strength_value = (String)hash.get("strength_value");
			String order_id = (String)hash.get("order_id");
			String order_line_no = (String)hash.get("order_line_no");
			//String patient_id    = (String)hash.get("patient_id");
			String rec_no		 = (String)hash.get("rec_no");
			String disp_stage1    = (String)hash.get("disp_stage");
			String classvalue	 = (String)hash.get("classvalue");
			String prescribed_strength =(String)hash.get("prescribed_strength");
			String barcode_flg  = (String)hash.get("barcode_flg");

			LinkedHashMap	stock_alternate_drugs =	beanObj.getStockAlternateDrugs(store_code,qty_reqd,eff_expiry,generic_id,drug_code,strength_value,"Y");
	//System.err.println("DispMedicationValidation.jsp=====stock_alternate_drugs=====5314===>"+stock_alternate_drugs);
			Set	alternate_set	=	null;
			Iterator	iter	=	null;
			String	sEqulStrengthUOM	= "";
			String	sEnableDisableCheck	= "";
			alternate_set	=	stock_alternate_drugs.keySet();
			iter	=	alternate_set.iterator();
			java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
			String fmtQty = "";	
			String select_status	=	"";
			String key = "";
			String alt_drug_code = "";
			String drug_name = "";
			String strength_uom = "";
			String form_code = "";
			String form_desc = "";
			String stock_uom = "";
			String select_box = "";
			String alloc_qty = "";
			ArrayList item_detail = null;
			ArrayList avail_qty  = null;
			HashMap record  = new HashMap();
			ArrayList addAltItems = new ArrayList();
			int cunt = 0;
			double tot_qty					=	0;
			HashMap pack_dtls = null;
			String drug_pack_size = "";
			String allow_more_qty = "";
			int tot_alt_drug_qty = 0;
			String strength_per_value_pres_uom = "";
			if(stock_alternate_drugs!=null && stock_alternate_drugs.size()>0){
				out.println("displayAlternateHeader('"+rec_no+"')");
				out.println("displayAlternateHeaderBarcode('"+rec_no+"','"+classvalue+"','"+barcode_flg+"','"+drug_code+"','"+order_id+"','"+order_line_no+"')");
			}else{
				out.println("displayAlertForNoRecords()");
			}
	
			while(iter.hasNext())	{ 
				tot_qty			=	0;			
				key	=	(String)iter.next();				
				record				=	(HashMap) stock_alternate_drugs.get(key);
				alt_drug_code		=	(String)record.get("DRUG_CODE");
				drug_name			=	(String)record.get("DRUG_DESC");
				strength_value		=	(String)record.get("STRENGTH_VALUE");
				strength_uom		=	(String)record.get("STRENGTH_UOM");
				form_code			=	(String)record.get("FORM_CODE");
				form_desc			=	(String)record.get("FORM_DESC");
				item_detail			=	(ArrayList)record.get("ITEM");
				avail_qty			=	(ArrayList)record.get("AVAIL_QTY"); 

				stock_uom			= (String)record.get("STOCK_UOM");					
			
				for(int q=0; q<avail_qty.size(); q++) {
					if(avail_qty.size() >=1 && !((String)avail_qty.get(q)).equals(""))
						tot_qty	+=	Double.parseDouble((String)avail_qty.get(q));
				}
				fmtQty = df.format(tot_qty);
				if(fmtQty.equals("0")) 
					sEnableDisableCheck = "disabled"; 						
					
				drug_name = drug_name.replaceAll(" ","%20"); 
				drug_name = java.net.URLEncoder.encode(drug_name,"UTF-8" );
				drug_name = drug_name.replaceAll("%2520","%20");
				
				if(!fmtQty.equals("") && !fmtQty.equals("0")){
					addAltItems.add(alt_drug_code);
				}
			
			pack_dtls	    = beanObj.getPackSize(alt_drug_code);

			if(pack_dtls.containsKey("PACK_SIZE")) {
				if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
					drug_pack_size	=	(String)pack_dtls.get("PACK_SIZE");			
					strength_per_value_pres_uom = (String)pack_dtls.get("STRENGTH_PER_VALUE_PRES_UOM");
					tot_alt_drug_qty	=	new 	Float(Math.ceil((Float.parseFloat(prescribed_strength)*(Float.parseFloat(strength_per_value_pres_uom))/Float.parseFloat(strength_value)))).intValue();
					tot_alt_drug_qty = (int)Math.ceil(tot_alt_drug_qty/Float.parseFloat(drug_pack_size));
					}

			 }		
		    allow_more_qty= bean.getAlternateHmAllowMoreQty(alt_drug_code,locale);
	//System.err.println("prescribed_strength===>"+prescribed_strength+"==tot_alt_drug_qty===>"+tot_alt_drug_qty);
			
			out.println("displayAlternateDrugDtls('"+drug_name+"','"+alt_drug_code+"','"+fmtQty+"','"+order_id+"','"+order_line_no+"','"+cunt+"','"+rec_no+"','"+strength_value+"','"+beanObj.getUomDisplay((String) session.getValue("facility_id"),strength_uom)+"','"+tot_alt_drug_qty+"','"+form_code+"','"+strength_uom+"','"+classvalue+"','"+allow_more_qty+"','"+drug_code+"');");
			cunt++;
			}
			if(stock_alternate_drugs!=null && stock_alternate_drugs.size()>0)
				out.println("displayAlternateFooter('"+order_id+"','"+order_line_no+"','"+cunt+"','"+patient_id+"','"+rec_no+"','"+disp_stage1+"','"+store_code+"','"+eff_expiry+"','"+barcode_flg+"','"+drug_code+"')");
		
			if(addAltItems!=null && addAltItems.size()>0)
				beanObj.setAltItems(order_id+order_line_no+drug_code,addAltItems);
			else
				beanObj.setAltItems(order_id+order_line_no+drug_code,new ArrayList());
		

  		//putObjectInBean(bean_id_1,bean,request);
 		}//MMS-KH-CRF-0030 - end
		else if(identity.equals("setAltDrugDtl")){ //added for MMS-CRF-0030 - start
			String	bean_id_1			=	"DispMedicationBean" ;
			String	bean_name_1			=	"ePH.DispMedicationBean";
			DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);

			DispMedicationAllStages beanObj = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages", request);

			String alt_drug_code = (String)hash.get("alt_drug_code");
			//String patient_id = (String)hash.get("patient_id");
			String store_code = (String)hash.get("store_code");
			String end_date = (String)hash.get("end_date");
			String form_code = (String)hash.get("form_code");
			double req_qty	 = Double.parseDouble((String) hash.get( "alloc_qty" ));
			String strength_value = (String)hash.get("strength_value");
			String strength_uom = (String)hash.get("strength_uom");
			String order_id = (String)hash.get("order_id");
			String order_line_no = (String)hash.get("order_line_no");
			String alt_drug_desc = (String)hash.get("alt_drug_desc");
			String drug_code = (String)hash.get("drug_code");
			HashMap params			=	new HashMap();
			ArrayList record_details= new ArrayList();
			record_details.add(alt_drug_code);
			record_details.add(java.net.URLDecoder.decode(alt_drug_desc,"UTF-8"));
			record_details.add(form_code);
			record_details.add(strength_value);
			record_details.add(strength_uom);
			beanObj.setMultiDrugs(patient_id,order_id,order_line_no,record_details);
			beanObj.checkAlternateDetail(patient_id,order_id,order_line_no);
			String trade_code   =  (String)bean_1.gettrade_codes(order_id,order_line_no,alt_drug_code);
			HashMap IssueUOMAndBaseUOM		=(HashMap)beanObj.getStoreDfltIssueUOMAndBaseUOM(store_code,alt_drug_code);
			String base_uom			 = (String)IssueUOMAndBaseUOM.get("BASE_UOM");

			if( !(trade_code.equals(""))){
					params.put("ITEM_CODE",alt_drug_code+"="+trade_code); 	
			}
			else{
					params.put("ITEM_CODE",alt_drug_code);
			}

			params.put("STORE_CODE",store_code);
			params.put("TRN_QTY",req_qty+"");
			params.put("INCLUDE_SUSPENDED","FALSE");
			params.put("INCLUDE_EXPIRED","FALSE");
			params.put("CUT_OFF_DATE",end_date);
			params.put("VERIFY_INSUFFICIENT_QTY","FALSE");
			params.put("ALREADY_USED_QTY","");
			params.put("MIN_EXP_DATE",end_date);
			
			String	bean_id_2		=	"StUtilities" ;
			String	bean_name_2		=	"eST.Common.StUtilities";
			StUtilities bean_2=null;
			String barcode_2d_yn    =  bean.get2DBarcodeApplicable();//Added for MMS-DM-CRF-0174.5
			ArrayList batches2DBarocde = new ArrayList();//Added for MMS-DM-CRF-0174.5
			ArrayList altBatchDetails = new ArrayList();
			String	bean_id_st		=	"StTransaction" ;//Added for MMS-DM-CRF-0174.5
			String	bean_name_st		=	"eST.Common.StTransaction";//Added for MMS-DM-CRF-0174.5
			StTransaction bean_st=null;//Added for MMS-DM-CRF-0174.5
			try { 
				bean_2 = (StUtilities) getBeanObject( bean_id_2,  bean_name_2, request );
				bean_2.setLanguageId(locale);
				bean_st = (StTransaction) getBeanObject( bean_id_st,  bean_name_st, request );//Added for MMS-DM-CRF-0174.5
				bean_st.setLanguageId(locale);//Added for MMS-DM-CRF-0174.5
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}

			HashMap stock	  = (HashMap)bean_2.getBatches(params);

			ArrayList stock_detail		=	(ArrayList)stock.get("BATCH_DATA");
			HashMap batch_det = null;
			ArrayList alloc_drug_detail = new ArrayList();
			boolean barcode_flag = false;
				ArrayList assigned_barcode_id   = null;
				HashMap allBarcodeId = beanObj.getAltBarcode();
				if(allBarcodeId!=null && allBarcodeId.size()>0)
					  assigned_barcode_id = (ArrayList)allBarcodeId.get(order_id+order_line_no+drug_code);
				
				if(assigned_barcode_id==null)
					assigned_barcode_id = new ArrayList();
				if(assigned_barcode_id!=null && assigned_barcode_id.size()>0){
					barcode_flag = true;
				}
				if(!barcode_flag){
					for (int j=0;j<stock_detail.size();j++){
						batch_det =(HashMap)stock_detail.get(j);
						alloc_drug_detail.add(batch_det.get("ITEM_CODE"));
						alloc_drug_detail.add(batch_det.get("BATCH_ID"));
						alloc_drug_detail.add(batch_det.get("EXPIRY_DATE"));

					double avail_qty			= Double.parseDouble((String)batch_det.get("AVAIL_QTY"));
					
					if(req_qty>avail_qty)
						req_qty = avail_qty;

						String item_cost	     =	beanObj.getItemCost(alt_drug_code,store_code,req_qty+"",end_date);		
						alloc_drug_detail.add(((int)(req_qty))+"");
						alloc_drug_detail.add(base_uom);
						alloc_drug_detail.add("");
						alloc_drug_detail.add(batch_det.get("TRADE_ID"));
						alloc_drug_detail.add(batch_det.get("BIN_LOCATION_CODE"));
						alloc_drug_detail.add(item_cost);
						alloc_drug_detail.add(base_uom);
						
					} 	
				}else{
				  if(assigned_barcode_id!=null && assigned_barcode_id.size()>0){
					String barcode_id = "";
					String barcode_scan_qty = "";
					HashMap barcodeScanQty = beanObj.getBarcodeQty();
					
					for(int i=0;i<assigned_barcode_id.size();i++){
						barcode_id = (String)assigned_barcode_id.get(i);
						System.err.println("barcode_id===1908===>"+barcode_id);
						if(barcodeScanQty!=null && barcodeScanQty.size()>0){
						 barcode_scan_qty = (String)barcodeScanQty.get(order_id+order_line_no+barcode_id);
						if(barcode_scan_qty==null)
							barcode_scan_qty = "0";
						}
						if(barcode_2d_yn.equals("Y")){//Adding start for MMS-DM-CRF-0174.5
                                batches2DBarocde = bean_st.get2DBarcodeBacthes(store_code,barcode_id);
								if(batches2DBarocde.size()>0){
									HashMap batches2D =(HashMap)batches2DBarocde.get(0);
								     altBatchDetails.add((String)batches2D.get("ITEM_CODE"));
									 altBatchDetails.add((String)batches2D.get("BATCH_ID"));
									 altBatchDetails.add((String)batches2D.get("EXPIRY_DATE"));
									 altBatchDetails.add((String)batches2D.get("TRADE_ID"));
									 altBatchDetails.add((String)batches2D.get("BIN_LOCATION_CODE"));
									 altBatchDetails.add((String)batches2D.get("AVAIL_QTY"));
								}
						}else{//Adding end for MMS-DM-CRF-0174.5
						        altBatchDetails = beanObj.getBatchDetailsForBarcode(barcode_id);
						}
						System.err.println("altBatchDetails=====>"+altBatchDetails+"==barcode_id===>"+barcode_id);
						if(altBatchDetails!=null && altBatchDetails.size()>0){
							alloc_drug_detail.add((String)altBatchDetails.get(0));
							alloc_drug_detail.add((String)altBatchDetails.get(1));
							alloc_drug_detail.add((String)altBatchDetails.get(2));
							alloc_drug_detail.add(barcode_scan_qty);
							String item_cost	     =	beanObj.getItemCost(alt_drug_code,store_code,barcode_scan_qty,end_date);		

							alloc_drug_detail.add(base_uom);
							alloc_drug_detail.add("");
							alloc_drug_detail.add((String)altBatchDetails.get(3));
							alloc_drug_detail.add((String)altBatchDetails.get(4));
							alloc_drug_detail.add(item_cost);
							alloc_drug_detail.add(base_uom);
						}

					}
				  }
				}
			//	System.err.println("alloc_drug_detail==1933=>"+alloc_drug_detail);
				beanObj.setAlternateDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail,alt_drug_code);

			//putObjectInBean(bean_id_1,bean_1,request);
			//putObjectInBean(bean_id_2,bean_2,request);
		}else if(identity.equals("nonPreferenceRemarks")){ //GHL-CRF-00618
		
		DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages", request);
			String drug_code		= (String) hash.get("drug_code");
			String remarks_code		= (String) hash.get("remarks_code");

			String order_id		= (String) hash.get("order_id");
			String order_line_no		= (String) hash.get("order_line_no");
		//	System.err.println("remarks_code===435==>"+remarks_code+"==drug_code====>"+drug_code+"==order_id===>"+order_id+"==order_line_no===>"+order_line_no);
			bean_all_stages.setNonPrefernceRemarks(drug_code,remarks_code,order_id,order_line_no);
			out.println("closeRemarksWindowForDrug()");
	} else if(identity.equals("validateBarcode")){ //MMS-KH-CRF-0030
		
		DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages", request);
			String drug_code        = (String) hash.get("drug_code");
			String order_id        = (String) hash.get("order_id");
			String order_line_no    = (String) hash.get("order_line_no");
			String barcode_id		= (String) hash.get("barcode_id");
			String rec_no			=(String) hash.get("rec_no");
			String store_code        =(String)hash.get("store_code");//Adding start for MMS-DM-CRF-0174.5
			String barcode_2d_yn    =  bean.get2DBarcodeApplicable();
			ArrayList batches2DBarocde = new ArrayList();
			String barcode_2d_item ="";
			String barcode_2d_avl_qty ="";
			String	bean_id_2		=	"StTransaction" ;
			String	bean_name_2		=	"eST.Common.StTransaction";
			StTransaction bean_2=null;
			try { 
				bean_2 = (StTransaction) getBeanObject( bean_id_2,  bean_name_2, request );
				bean_2.setLanguageId(locale);
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
			String alt_item_dtl		=  "";
			if(barcode_2d_yn.equals("Y")){
                  batches2DBarocde = bean_2.get2DBarcodeBacthes(store_code,barcode_id);
				  if(batches2DBarocde.size()>0){
					  HashMap batches2D = (HashMap)batches2DBarocde.get(0);
				       barcode_2d_item =(String)batches2D.get("ITEM_CODE");
                       barcode_2d_avl_qty = (String)batches2D.get("AVAIL_QTY");
					   alt_item_dtl =  barcode_2d_item+"~"+barcode_2d_avl_qty;
				  }
                  
			}else{//Adding end for MMS-DM-CRF-0174.5
			       alt_item_dtl = bean_all_stages.getItemForBarcode(barcode_id);
			}
			System.err.println("alt_item_dtl==="+alt_item_dtl);
			String item_code = "";
			double avail_qty = 0;
			String item_result[] = alt_item_dtl.split("~");
//										
			if(item_result.length>1){
				item_code = item_result[0];
				avail_qty = Double.parseDouble(item_result[1]);
			}
			String alloc_drug = "";

			if(item_code!=null && !item_code.equals("")){
				HashMap altItem	        = bean_all_stages.getAltItems();
				ArrayList arr  = (ArrayList)altItem.get(order_id+order_line_no+drug_code);
				HashMap altQty = bean_all_stages.getAltDrugScanQty();
				HashMap allocAltDrug = bean_all_stages.getSelectedAltDrug();
				String alt_drug_qty = (String)altQty.get(order_id+order_line_no+drug_code);
				HashMap allBarcodeId = bean_all_stages.getAltBarcode();
				HashMap barcodeScanQty = bean_all_stages.getBarcodeQty();

				String barcode_scan_qty = "0";
				if(barcodeScanQty!=null && barcodeScanQty.size()>0){
				  barcode_scan_qty = (String)barcodeScanQty.get(order_id+order_line_no+barcode_id);
				if(barcode_scan_qty==null)
					barcode_scan_qty = "0";
				}
				

				if(allocAltDrug!=null && allocAltDrug.size()>0)
					 alloc_drug = (String)allocAltDrug.get(order_id+order_line_no+drug_code);

				if(alloc_drug==null)
					alloc_drug = "";
				
				if(alloc_drug.equals("") || alloc_drug.equals(item_code)){
				
				ArrayList assigned_barcode_id   = null;

				if(allBarcodeId!=null && allBarcodeId.size()>0)
					  assigned_barcode_id = (ArrayList)allBarcodeId.get(order_id+order_line_no+drug_code);
				
				if(assigned_barcode_id==null)
					assigned_barcode_id = new ArrayList();
			
				
				
				if(alt_drug_qty==null || alt_drug_qty.equals(""))
					alt_drug_qty = "0";

				if(arr!=null && arr.size()>0){
					if(arr.contains(item_code)){
						if(Double.parseDouble(barcode_scan_qty)<avail_qty){
						if(assigned_barcode_id.contains(barcode_id)){
							if(Integer.parseInt(barcode_scan_qty)>0)
								barcode_scan_qty = (Integer.parseInt(barcode_scan_qty) + 1) +"";
								bean_all_stages.setBarcodeQty(order_id+order_line_no+barcode_id,barcode_scan_qty);
						}else{
							barcode_scan_qty = "1";
							bean_all_stages.setBarcodeQty(order_id+order_line_no+barcode_id,"1");
							if(!assigned_barcode_id.contains(barcode_id)){
								assigned_barcode_id.add(barcode_id);
								bean_all_stages.addAltBarcode(order_id+order_line_no+drug_code,assigned_barcode_id);
							}
						}
						
					alt_drug_qty= (Integer.parseInt(alt_drug_qty) + 1)+"" ; 

						
						
						
						bean_all_stages.setAltDrugScanQty(order_id+order_line_no+drug_code,alt_drug_qty);
						bean_all_stages.setSelectedAltDrug(order_id+order_line_no+drug_code,item_code);
						out.println("assignAltDrugQty('"+order_id+"','"+order_line_no+"','"+item_code+"','"+alt_drug_qty+"')");
						}else{
						out.println("insufficientBatchQty()");
						}
					}
						
						
					}
				}else{
					out.println("displayAlertForMoreRecords()");
				}
				}else{
						out.println("alertForInvalidBarcode('"+rec_no+"')");	
				}
				
				out.println("clearBarcodeScreen('"+rec_no+"')");
			
			}else if(identity.equals("clearBarcodeQty")){ //GHL-CRF-00618
		
		DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages", request);
			String drug_code	 = (String) hash.get("drug_code");
			String order_id		 = (String) hash.get("order_id");
			String order_line_no = (String) hash.get("order_line_no");
			String barcode_id	 = "";
			ArrayList assigned_barcode_id = null;
			HashMap allBarcodeId = bean_all_stages.getAltBarcode();
			HashMap allocAltDrug = bean_all_stages.getSelectedAltDrug();
			HashMap altQty = bean_all_stages.getAltDrugScanQty();

			if(allBarcodeId!=null && allBarcodeId.size()>0){
				assigned_barcode_id = (ArrayList)allBarcodeId.get(order_id+order_line_no+drug_code);
				if(assigned_barcode_id==null)
					assigned_barcode_id = new ArrayList();
		
				if(assigned_barcode_id!=null && assigned_barcode_id.size()>0){
					HashMap barcodeScanQty = bean_all_stages.getBarcodeQty();

					for(int i=0;i<assigned_barcode_id.size();i++){
						barcode_id = (String)assigned_barcode_id.get(i); 
						if(barcodeScanQty!=null && barcodeScanQty.containsKey(order_id+order_line_no+barcode_id)){
							barcodeScanQty.remove(order_id+order_line_no+barcode_id);

						}

					}
					
					allBarcodeId.remove(order_id+order_line_no+drug_code);

				}
				if(allocAltDrug!=null && allocAltDrug.size()>0){
					if(allocAltDrug.containsKey(order_id+order_line_no+drug_code))
						allocAltDrug.remove(order_id+order_line_no+drug_code);
				}
				
				if(altQty!=null && altQty.size()>0){
					if(altQty.containsKey(order_id+order_line_no+drug_code))
						altQty.remove(order_id+order_line_no+drug_code);
				}
				

			} 
	}
	
	putObjectInBean(bean_id,bean,request);

}catch(Exception e) {
	e.printStackTrace();
}

            _bw.write(_wl_block1Bytes, _wl_block1);

//putObjectInBean(bean_id,bean,request);
//putObjectInBean(bean_id,st_bean,request);

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
