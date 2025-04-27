package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import ePH.Common.*;
import ePH.*;
import java.text.DecimalFormat;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __regprescriptionsvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/RegPrescriptionsValidate.jsp", 1723002668601L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="  ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
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
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
16/10/2019  71423                Manickavasagam j                       SKR-SCF-1273
23/07/2020  IN073195                Manickavasagam j                       SKR-SCF-1273.1
---------------------------------------------------------------------------------------------------------------
*/ 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

try{
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097 
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	
	String bean_id						= request.getParameter( "bean_id" ) ;
	String bean_name					= request.getParameter( "bean_name" ) ;
	String identity						= request.getParameter("identity");
	String patient_id					= request.getParameter("patient_id");
	String order_id						= request.getParameter("order_id");
	String priority						= request.getParameter("priority");
	String order_status					= request.getParameter("order_status");
	String order_date_from				= request.getParameter("order_date_from");
	String order_date_to				= request.getParameter("order_date_to");
	String disp_locn_code				= request.getParameter("disp_locn_code");
	String gender						= request.getParameter("gender");
	String nationality					= request.getParameter("nationality");
	String ord_loc_type					= request.getParameter("ord_loc_type");
	String ord_locn_code				= request.getParameter("ord_locn_code");
	String row_no						= request.getParameter("row_no");
	String name				="";
	String age				="";
	String facility_id		=(String) session.getValue( "facility_id" );
	String login_user	    ="";
	String lock_status_return ="";
	String user_id            ="";
	String locked_date_time   ="";
	String lock_status_value  ="";
	String patient_id_status  ="";
	String Unlock_all_records_yn =""; 
	String Unlock_status_return  =""; 
	String allow_disp_record_lock_yn  =""; 
	login_user       =(String)session.getValue("login_user");
	allow_disp_record_lock_yn	= request.getParameter("allow_disp_record_lock_yn");
	String disp_stage ="R";
	
	int no_of_patients		= 0;
	Hashtable hash			= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash					= (Hashtable)hash.get( "SEARCH" ) ;
	RegPrescriptionsBean bean = (RegPrescriptionsBean)getBeanObject( bean_id,bean_name,request);
	bean.clear();
	bean.setDispBeyondBeforeValues();//Added for COMMON-ICN-0120 [40745]
	if(disp_locn_code!=null && !disp_locn_code.equals("null")){
		bean.setDispLocnCode(disp_locn_code);
	}

	if (identity.equals("patientDetails")){
		bean.clearPrescriptionDetails();
		String order_ids ="";
		String patient_lock_id ="";
		String pat_name="", gender_tmp="", nationality_tmp="", genderCode="",nationalityCode="",patient_class="",encounter_id="" ;//code 'patient_class="",encounter_id="" ' added for JD-CRF-0156[IN041737]
		HashMap hmPrescriptionDetails = new HashMap(); //added for Bru-HIMS-CRF-094 [IN:029959]
		ArrayList alOrderLineDtl=null; //added for Bru-HIMS-CRF-094 [IN:029959]

		allow_disp_record_lock_yn=bean.getAllowdisprecordlock(facility_id);
		Unlock_all_records_yn=bean.getUnLockRecordsYN(login_user,disp_locn_code);
				System.err.println("order_id==67====>"+order_id);
		ArrayList result = bean.getDataForThePatientFrame(patient_id,order_id,priority,order_status,order_date_from,order_date_to,disp_locn_code,ord_loc_type,ord_locn_code);
		if (result.size()>0){
			String enc_id = ""; //SKR-SCF-1273.1
			for (int i=0;i<result.size();){
				no_of_patients ++;
				patient_id =(String) result.get(0);
				name=(String)result.get(1)==null?"":(String)result.get(1);

				age=(String)result.get(2);
				gender=(String)result.get(3);
				nationality=(String)result.get(4);
				nationalityCode =(String) result.get(7);
				genderCode =(String) result.get(8);
				patient_class =(String) result.get(9);//code added for JD-CRF-0156[IN041737]
				encounter_id =(String) result.get(i+10);//code added for JD-CRF-0156[IN041737]  and modified for //SKR-SCF-1273.1
				if(i==0) //SKR-SCF-1273.1
				enc_id = encounter_id;

				patient_lock_id =(String) result.get(i);

				patient_id_status ="N";
				lock_status_value= bean.getLockStatus1(login_user,patient_id,disp_locn_code,disp_stage,patient_id_status);
				lock_status_return = bean.getLockStatusOnLoad(patient_lock_id,disp_locn_code,disp_stage,login_user);
				ArrayList AccessRight=bean.getAccessRightStatus(patient_lock_id,disp_locn_code,disp_stage);
				HashMap lock_statusMap = new HashMap();
				if(AccessRight.size()>0){
					for(int k=0; k<AccessRight.size(); k++)	{
						lock_statusMap = (HashMap)AccessRight.get(k);
						user_id = (String)lock_statusMap.get("user_id");
						locked_date_time = (String)lock_statusMap.get("locked_date_time");
					}
				}		
				pat_name = result.get(i+1)==null?"":(String)result.get(i+1);
				gender_tmp = result.get(i+3)==null?"":(String)result.get(i+3);
				nationality_tmp = result.get(i+4)==null?"":(String)result.get(i+4);
				out.println("assignDataToPatientFrame('"+result.get(i)+"','"+java.net.URLEncoder.encode(pat_name,"UTF-8")+"','"+result.get(i+2)+"','"+gender_tmp+"','"+nationality_tmp+"','"+(String)result.get(i+5)+"','"+result.get(i+6)+"','"+(String)result.get(i+7)+"','"+result.get(i+8)+"','"+lock_status_return+"','"+disp_locn_code+"','"+user_id+"','"+locked_date_time+"','"+Unlock_all_records_yn+"','"+allow_disp_record_lock_yn+"','"+encounter_id+"')");	//encounter_id added for SKR-SCF-1273.1
				i=i+11;//code i=i+9 is replaced by i=i+11 added for JD-CRF-0156[IN041737]
			}
			lock_status_return = bean.getLockStatusOnLoad(patient_id,disp_locn_code,disp_stage,login_user);
			if(lock_status_return.equals("0")){
				out.println("assignToPatientLine('"+patient_id+"','"+java.net.URLEncoder.encode(name,"UTF-8")+"','"+age+"','"+gender+"','"+nationality+"','"+genderCode+"','"+nationalityCode+"','"+patient_class+"','"+encounter_id+"')");//code '"+patient_class+"','"+encounter_id+"''added for JD-CRF-0156[IN041737]
				out.println("assignToNumberOfPatients('"+no_of_patients+"')");
			}
			result  = bean.getDataForTheFooter(patient_id,order_id,priority,order_status,order_date_from,order_date_to,disp_locn_code,enc_id); //enc_id added for SKR-SCF-1273.1
			if (result.size()>0){
				order_id = (String)result.get(3);
			}

			ArrayList printResult =	bean.getPrintRelatedInfo(disp_locn_code,facility_id);
			bean.setPrintResultDetails(printResult);//Added for ML-BRU-SCF-1199 [IN:045703]
			order_ids ="";
			for(int i=0;i<result.size();){
				String 	pract_name=(String)result.get(i+7);
				String 	loc_desc=result.get(i+5)==null?"":(String)result.get(i+5);
				loc_desc=loc_desc.replaceAll(" ","%20");
				loc_desc = java.net.URLEncoder.encode(loc_desc,"UTF-8");
				loc_desc=loc_desc.replaceAll("%2520"," ");
				loc_desc=loc_desc.replaceAll("%20"," ");

				pract_name=pract_name.replaceAll(" ","%20");
				pract_name = java.net.URLEncoder.encode(pract_name,"UTF-8");
				pract_name=pract_name.replaceAll("%2520"," ");
				pract_name=pract_name.replaceAll("%20"," ");
				String 	order_type=(String)result.get(i+2);
				if(lock_status_return.equals("0")){	 
					out.println("assignDataToPresDetailsFrame('"+result.get(i)+"','"+java.net.URLEncoder.encode((String)result.get(i+1),"UTF-8")+"','"+order_type+"','"+result.get(i+3)+"','"+result.get(i+4)+"','"+loc_desc+"','"+result.get(i+6)+"','"+pract_name+"','"+result.get(i+8)+"','"+result.get(i+9)+"','"+result.get(i+10)+"','"+result.get(i+11)+"','"+printResult.get(0)+"')");
				}
				order_ids =order_ids + (String)result.get(i+3)+":Y,";
				alOrderLineDtl = bean.getDrugDosageDetails((String)result.get(i+3),disp_locn_code); //added for Bru-HIMS-CRF-094 [IN:029959]
				//added for SKR-SCF-1273[71423] - start
				String order_line_no = "";
				String order_id_val      = (String)result.get(i+3)+",";
				if(alOrderLineDtl!=null && alOrderLineDtl.size()>0){
					for(int k=0;k<alOrderLineDtl.size();k=k+19){
						if(k==0)
							order_line_no = order_line_no+alOrderLineDtl.get(k+8)+":Y";
						else
							order_line_no = order_line_no+":"+alOrderLineDtl.get(k+8)+":Y";
					}
				
					if(!order_line_no.equals("")){
						bean.storePrescriptionDetails(order_id_val+order_line_no);
					}
				}
				//added for SKR-SCF-1273[71423] - end
				alOrderLineDtl.add((String)result.get(i+10));
				hmPrescriptionDetails.put((String)result.get(i+3), alOrderLineDtl); //added for Bru-HIMS-CRF-094 [IN:029959]
				i=i+12;				
			}
			if(result.size()>0){
				bean.clear();
				bean.storeOrderDetails(order_ids);
			}
			out.println("assignPrintRelatedInfo('"+printResult.get(0)+"','"+printResult.get(1)+"')");
			bean.setPatPrescriptionDetails(hmPrescriptionDetails);  //added for Bru-HIMS-CRF-094 [IN:029959]
			bean.clearPatientPayable();  //added for Bru-HIMS-CRF-094 [IN:029959]
			result = (ArrayList)hmPrescriptionDetails.get(order_id);//bean.getDrugDosageDetails(order_id,disp_locn_code); 
			bean.setRegisteredOrders(result);//Added for ML-BRU-SCF-1199 [IN:045703]
			//result =bean.getDrugDosageDetails(order_id,disp_locn_code);
			String dischargeIND="", drug_desc="";
			//for(int i=0;i<(result.size()-1);i+= 19){ //Commented for stop loading RegPrescriptionsDetailFooter.jsp in loop
				//drug_desc =(String)result.get(i+1);
				if(lock_status_return.equals("0")){	   		
					ArrayList result1  = bean.getDataForTheFooter(patient_id,order_id,priority,order_status,order_date_from,order_date_to,disp_locn_code,encounter_id);//encounter_id added for SKR-SCF-1273.1
					if(result1.size()>0){
						order_id = (String)result1.get(3);
						dischargeIND=(String)result1.get(10);
					}
					if( dischargeIND!=null && dischargeIND.equals("D")){
						dischargeIND="Y";
					}		
					else{
						dischargeIND="N";
					}
					//drug_desc =java.net.URLEncoder.encode((String)result.get(i+1),"UTF-8");
					//out.println("assignPrescriptionDetailsForTheFirstOrder('"+result.get(i)+"','"+drug_desc+"','"+result.get(i+2)+"','"+result.get(i+3)+"','"+java.net.URLEncoder.encode((String)result.get(i+4),"UTF-8")+"','"+java.net.URLEncoder.encode((String)result.get(i+5),"UTF-8")+"','"+result.get(i+6)+"','"+java.net.URLEncoder.encode((String)result.get(i+7),"UTF-8")+"','"+result.get(i+8)+"','"+order_id+"','"+result.get(i+10)+"','"+result.get(i+11) +"','"+result.get(i+12) +"','"+result.get(i+13) +"','"+result.get(i+14) +"','"+dischargeIND+"','"+result.get(i+15) +"','"+result.get(i+16)+ "','"+result.get(i+17)+"','"+result.get(i+18)+"')"); //15->tapered_yn 16->taper_order_id 	// added result.get(i+17),result.get(i+18) for CRF RUT-CRF-0034.1[IN:037389] //Commented for stop loading RegPrescriptionsDetailFooter.jsp in loop
					out.println("assignPrescriptionDetailsForTheFirstOrder('"+lock_status_return+"','"+dischargeIND+"');"); //Added outside the loop.
				}
				//i = i+ 19;//changed 17 to 19 for CRF RUT-CRF-0034.1[IN:037389]
			//}
		}
		else{
			String pndng_ord_count  = bean.getPendngOrderCnt(patient_id);
			//out.println("reset('No records','"+pndng_ord_count+"')"); //Commented for Bru-HIMS-CRF-142 [IN:030195]
			//Added for Bru-HIMS-CRF-142 [IN:030195] - Start
			if(!patient_id.equals("")){
				ArrayList patmode = new ArrayList();
				String pat_arr_checked_yn = (String)(bean.getPatientArrivalDet(facility_id, disp_locn_code)).get(0); // Added for TTM-SCF-169
				patmode = 	(ArrayList)bean.getPatientMode(patient_id,order_date_from,order_date_to);
				if(patmode.size()==0)
					out.println("reset('No records','"+pndng_ord_count+"')");
				if(patmode.size()==1) 
					out.println("reset('No records','"+pndng_ord_count+"','" +disp_locn_code  + "','"+ pat_arr_checked_yn + "','"+ patmode + "');");  // pat_arr_checked_yn Added for TTM-SCF-169
				if(patmode.size()==2) 
					out.println("reset('No records','"+pndng_ord_count+"','" +  disp_locn_code + "','" + pat_arr_checked_yn + "');"); // pat_arr_checked_yn Added for TTM-SCF-169
			}
			else
				out.println("reset('No records','"+pndng_ord_count+"')");
			//Added for Bru-HIMS-CRF-142 [IN:030195] - End
		}
	}
	else if(identity.equals("DrugDosageDetails")){
		String dischargeIND_yn = request.getParameter("dischargeIND_yn")==null?"":request.getParameter("dischargeIND_yn");
		ArrayList printResult =	bean.getPrintRelatedInfo(disp_locn_code,facility_id);
		out.print(printResult.get(0)+"~"+printResult.get(1)+"~");
		ArrayList result = null;
		HashMap  hmPrescriptionDetails = bean.getPatPrescriptionDetails(); //added for Bru-HIMS-CRF-094 [IN:029959]
		if(hmPrescriptionDetails!=null && hmPrescriptionDetails.containsKey(order_id)) // if block & else condition added for Bru-HIMS-CRF-094 [IN:029959]
			result= (ArrayList)hmPrescriptionDetails.get(order_id); 
		else{
			result = bean.getDrugDosageDetails(order_id,disp_locn_code);
			result.add("");
		}
		for(int i=0;i<(result.size()-1);){	
			out.print(result.get(i)+"~"+java.net.URLEncoder.encode((String)result.get(i+1),"UTF-8")+"~"+result.get(i+2)+"~"+result.get(i+3)+"~"+java.net.URLEncoder.encode((String)result.get(i+4),"UTF-8")+"~"+java.net.URLEncoder.encode((String)result.get(i+5),"UTF-8")+"~"+result.get(i+6)+"~"+java.net.URLEncoder.encode((String)result.get(i+7),"UTF-8")+"~"+result.get(i+8)+"~"+order_id+"~"+result.get(i+10)+"~"+result.get(i+11)+"~"+result.get(i+12)+"~"+result.get(i+13)+"~"+"~"+result.get(i+14)+"~"+result.get(i+15)+"~"+result.get(i+16)+"~"+result.get(i+17)+"~"+result.get(i+18)+"~"); //15->tapered_yn 16->taper_order_id// added result.get(i+17),result.get(i+18) for CRF RUT-CRF-0034.1[IN:037389]
			i = i+ 19;
		}
		bean.setRegisteredOrders(result);//Added for ML-BRU-SCF-1199 [IN:045703]
		bean.setPrintResultDetails(printResult);//Added for ML-BRU-SCF-1199 [IN:045703]
	}
	else if (identity.equals("CHECKLOCK")){
		HashMap lock_statusMap = new HashMap();
		String enc_id  = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id"); //enc_id added for SKR-SCF-1273.1
		user_id             ="";
		String count_patient    ="";
		if(allow_disp_record_lock_yn.equals("Y")){
			ArrayList lock_status=bean.getLockResult(patient_id,disp_locn_code,disp_stage,login_user);
			if(lock_status.size()>0){
				for(int j=0; j<lock_status.size(); j++){
					lock_statusMap = (HashMap)lock_status.get(j);
					count_patient = (String)lock_statusMap.get("count_patient");
					user_id = (String)lock_statusMap.get("user_id");
				}
			}
			if(lock_status.size()==0){
				count_patient="0";
				user_id="";
			} 
		}
		else{
			count_patient="0";
			user_id="";
			allow_disp_record_lock_yn="N";
		}
		out.println("checklockresult('"+count_patient+"','"+user_id+"','"+patient_id+"','"+allow_disp_record_lock_yn+"',"+row_no+",'"+enc_id+"')"); //encounter_id added for SKR-SCF-1273.1
	}
	else if (identity.equals("TokenSeries")){
		ArrayList result = bean.getTokenDetails(disp_locn_code,gender,nationality);
		if (result.size()>0){		
			for (int i=0;i<result.size();i=i+3){			
				out.println("assignTokenSeriesDetails('"+result.get(i)+"','"+result.get(i+1)+"','"+result.get(i+2)+"')");
			}
		}
		else{
			out.println("assignTokenSeriesDetails('','','')");
		}
	}
	else if (identity.equals("OrdersForSelectedPatient")){
		String order_ids ="", genderCode="",nationalityCode="", patient_class ="",encounter_id ="";//code 'patient_class="",encounter_id="" ' added for JD-CRF-0156[IN041737]		
		String enc_id = request.getParameter("enc_id")==null?"":request.getParameter("enc_id");//added for SKR-SCF-1273.1
		bean.clearPrescriptionDetails();
		out.println("deleteFlag=false");
		HashMap hmPrescriptionDetails = new HashMap(); //added for Bru-HIMS-CRF-094 [IN:029959]
		ArrayList alOrderLineDtl=null; //added for Bru-HIMS-CRF-094 [IN:029959]
		System.err.println("order_id==265====>"+order_id);
		ArrayList result = bean.getDataForThePatientFrame(patient_id,order_id,priority,order_status,order_date_from,order_date_to,disp_locn_code,ord_loc_type,ord_locn_code);
		patient_id =(String) result.get(0);
		name=(String)result.get(1);
		age=(String)result.get(2);
		gender=(String)result.get(3);
		nationality=(String)result.get(4);
		nationalityCode =(String) result.get(7);
		genderCode =(String) result.get(8);
		patient_class =(String) result.get(9);//code added for JD-CRF-0156[IN041737]
		encounter_id =(String) result.get(10);//code added for JD-CRF-0156[IN041737]  
		allow_disp_record_lock_yn=bean.getAllowdisprecordlock(facility_id);
		if(allow_disp_record_lock_yn.equals("Y")){
			lock_status_return = bean.getLockStatus(patient_id,disp_locn_code,disp_stage);
			if(lock_status_return.equals("0")){
				patient_id_status ="N";
				lock_status_value= bean.getLockStatus1(login_user,patient_id,disp_locn_code,disp_stage,patient_id_status);
			}
		} 
		out.println("assignToPatientLine('"+patient_id+"','"+java.net.URLEncoder.encode(name,"UTF-8")+"','"+age+"','"+gender+"','"+nationality+"','"+genderCode+"','"+nationalityCode+"','"+patient_class+"','"+encounter_id+"')");//code ''"+patient_class+"','"+encounter_id+"''added for JD-CRF-0156[IN041737]
		result  = bean.getDataForTheFooter(patient_id,order_id,priority,order_status,order_date_from,order_date_to,disp_locn_code,enc_id); //encounter_id added for SKR-SCF-1273.1
		String dischargeIND="";
		if(result.size()>0){
			order_id = (String)result.get(3);
			dischargeIND=(String)result.get(10);
		}
		if( dischargeIND!=null && dischargeIND.equals("D")){
			dischargeIND="Y";
		}		
		else{
			dischargeIND="N";
		}
		out.println("assigndischargeIND('"+dischargeIND+"')");
		ArrayList printResult =	bean.getPrintRelatedInfo(disp_locn_code,facility_id);
		bean.setPrintResultDetails(printResult);//Added for ML-BRU-SCF-1199 [IN:045703]
		String 	pract_name, loc_desc, order_type;
		order_ids =""; // Added for Inc # 8740
		for(int i=0;i<result.size();){
			//order_ids =""; // commented for Inc # 8740
			pract_name=(String)result.get(i+7)==null?"":(String)result.get(i+7);
			loc_desc=(String)result.get(i+5)==null?"":(String)result.get(i+5);
			order_type=(String)result.get(i+2)==null?"":(String)result.get(i+2);
			loc_desc=loc_desc.replaceAll(" ","%20");
			loc_desc = java.net.URLEncoder.encode(loc_desc,"UTF-8");
			loc_desc=loc_desc.replaceAll("%2520"," ");
			loc_desc=loc_desc.replaceAll("%20"," ");

			pract_name=pract_name.replaceAll(" ","%20");
			pract_name = java.net.URLEncoder.encode(pract_name,"UTF-8");
			pract_name=pract_name.replaceAll("%2520"," ");
			pract_name=pract_name.replaceAll("%20"," ");
			out.println("assignDataToPresDetailsFrame('"+result.get(i)+"','"+java.net.URLEncoder.encode((String)result.get(i+1),"UTF-8")+"','"+order_type+"','"+result.get(i+3)+"','"+result.get(i+4)+"','"+loc_desc+"','"+result.get(i+6)+"','"+pract_name+"','"+result.get(i+8)+"','"+result.get(i+9)+"','"+result.get(i+10)+"','"+result.get(i+11)+"','"+printResult.get(0)+"','"+dischargeIND+"')");
			order_ids =order_ids + (String)result.get(i+3)+":Y,";
			alOrderLineDtl = bean.getDrugDosageDetails((String)result.get(i+3),disp_locn_code); //added for Bru-HIMS-CRF-094 [IN:029959]
			alOrderLineDtl.add((String)result.get(i+10));
			hmPrescriptionDetails.put((String)result.get(i+3), alOrderLineDtl); //added for Bru-HIMS-CRF-094 [IN:029959]
			i=i+12;
		}
		if(result.size()>0){
			bean.clear();
			bean.storeOrderDetails(order_ids);
		}
		out.println("assignPrintRelatedInfo('"+printResult.get(0)+"','"+printResult.get(1)+"')");
		bean.setPatPrescriptionDetails(hmPrescriptionDetails);  //added for Bru-HIMS-CRF-094 [IN:029959]
		bean.clearPatientPayable();  //added for Bru-HIMS-CRF-094 [IN:029959]
		result = (ArrayList)hmPrescriptionDetails.get(order_id);//bean.getDrugDosageDetails(order_id,disp_locn_code); 
		bean.setRegisteredOrders(result);//Added for ML-BRU-SCF-1199 [IN:045703]
		//result = bean.getDrugDosageDetails(order_id,disp_locn_code);
		/*String drug_desc ="";
		for(int i=0;i<(result.size()-1);i+= 19){
			drug_desc =java.net.URLEncoder.encode((String)result.get(i+1),"UTF-8");
			out.println("assignPrescriptionDetailsForTheFirstOrder('"+result.get(i)+"','"+drug_desc+"','"+result.get(i+2)+"','"+result.get(i+3)+"','"+java.net.URLEncoder.encode((String)result.get(i+4),"UTF-8")+"','"+java.net.URLEncoder.encode((String)result.get(i+5),"UTF-8")+"','"+result.get(i+6)+"','"+java.net.URLEncoder.encode((String)result.get(i+7),"UTF-8")+"','"+result.get(i+8)+"','"+order_id+"','"+result.get(i+10)+"','"+result.get(i+11)+"','"+result.get(i+12)+"','"+result.get(i+13)+"','"+result.get(i+14)+"','"+dischargeIND+"','"+result.get(i+15)+"','"+result.get(i+16)+"','"+result.get(i+17)+"','"+result.get(i+18)+"')"); //15->tapered_yn 16->taper_order_id	// added result.get(i+17),result.get(i+18) for CRF RUT-CRF-0034.1[IN:037389]
			//i = i+ 19;
		}*/ //Commented for stop loading RegPrescriptionsDetailFooter.jsp in loop
		out.println("assignPrescriptionDetailsForTheFirstOrder('"+lock_status_return+"','"+dischargeIND+"');"); //Added outside teh loop
		bean.storeOrderDetails(order_id+":Y,");
	}
	else if (identity.equals("nationalityHealthCardNo")){
		ArrayList result =	bean.getNationalityHealthCardNo(patient_id);
		if (result.size()>0){
			out.println("assignNationalityHealthCardNo('"+result.get(0)+"','"+result.get(1)+"')");
			out.println("searchTheDataForHeaderAndFooter()"); //Added for 
		}
	}
	else if (identity.equals("storeOrderDetails")){
		bean.clear();
		out.println(bean.storeOrderDetails(request.getParameter("order_ids")));
	}
	else if (identity.equals("storePrescriptionDetails")){
		bean.clear();
		out.println(request.getParameter("prescriptions"));
		out.println(bean.storePrescriptionDetails(request.getParameter("prescriptions")));
		//		out.println(bean.getDebug());
	}
	else if(identity.equals("print_register")){
		String module_id	= "PH" ;
		String report_id	= "PHBREGPR" ;
		login_user	= (String) session.getValue( "login_user" );
		patient_id			= (String)hash.get("patient_id");
		String token_series_code	= (String)hash.get("token_series_code");
		disp_locn_code				= (String)hash.get("disp_locn_code");
		String reg_orders			= (String)hash.get("order_id");	
		String print_pres			= (String)hash.get("print_pres");	
		String print_token			= (String)hash.get("print_token");
		String language_id		    = (String)session.getAttribute("LOCALE");
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		String ReportOutput			=	"";	
		if(print_token!=null && print_token.equals("Y")) {
			ecis.utils.OnlineReport report	= new ecis.utils.OnlineReport( facility_id, module_id,report_id) ;
			report.addParameter("p_patient_id",patient_id) ;
			report.addParameter("p_token_series_code",token_series_code);
			report.addParameter("p_disp_locn_code",disp_locn_code);
			report.addParameter("p_facility_id",facility_id) ;
			report.addParameter("p_language_id",language_id) ;
			String token_serial_no=bean.getmaxSerialnum( patient_id,token_series_code, disp_locn_code, facility_id);
			report.addParameter("p_serial_no",token_serial_no) ;
			onlineReports.add( report) ;		
			ReportOutput = onlineReports.execute( request, response );
		}
		if(print_pres!=null && print_pres.equals("Y")) {
			StringTokenizer st	 =	new StringTokenizer(reg_orders,",");
			String curr_order_id =   "";
			String pat_class     =   "";
			String pres_report_id	 =   "";
			while(st.hasMoreTokens()) {
				onlineReports	= new ecis.utils.OnlineReports() ;
				curr_order_id	= st.nextToken();
				pat_class		= curr_order_id.substring(2,4);
				if(pat_class.equals("XT")){
					pres_report_id="PHBOPPEX";
				}else{
					pres_report_id="PHBOPPRS";
				}
				ecis.utils.OnlineReport report2= new ecis.utils.OnlineReport( facility_id, "PH", pres_report_id) ;

				report2.addParameter("p_facility_id", facility_id) ;
				report2.addParameter("p_module_id", "PH") ;
				report2.addParameter("p_report_id", pres_report_id) ;                   
				report2.addParameter("p_order_id", curr_order_id) ;
				report2.addParameter("p_language_id",language_id) ;
				//report2.addParameter("p_order_id", st.nextToken()) ;
				//report2.addParameter("p_locncode", locn_code) ;
				//report2.addParameter("p_patclass", patient_class) ;
				report2.addParameter("p_user_name", login_user) ;
				onlineReports.add( report2) ;
				ReportOutput = onlineReports.execute( request, response );
			}
		}
	}
	else if (identity.equals("checkunlockrecord")){
		patient_id_status			="Y";
		Unlock_status_return		= bean.getLockStatus1(login_user,patient_id,disp_locn_code,disp_stage,patient_id_status);
		out.println("Unlock_status_YN('"+Unlock_status_return+"')");
	}
	else if (identity.equals("GenTokenYN")){
		String token_series_code	= (String)hash.get("token_series_code");
		disp_locn_code				= (String)hash.get("disp_locn_code");
		
		ArrayList genTokenDtls =	bean.getGenerateTokenYN(disp_locn_code,token_series_code);	 // added for Bru-HIMS-CRF-076 [IN029942] -start
		if(genTokenDtls != null && genTokenDtls.size()>0){
			out.println("DisplayTokenNO('"+(String)genTokenDtls.get(0)+"','"+(String)genTokenDtls.get(1)+"','"+(String)genTokenDtls.get(2)+"');");
		}		//String gen_token_yn - end
		/*String gen_token_yn =	bean.getGenerateTokenYN(disp_locn_code,token_series_code);	
		out.println("DisplayTokenNO('"+gen_token_yn+"')"); */ //Commented for Bru-HIMS-CRF-076 [IN029942]
	}
	else if(identity.equals("StoreBillingDetails")){

		String drug_code						 =	(String)hash.get("drug_code");				
		String srl_no							 =	(String)hash.get("Srl_no");				
		String excl_incl_ind					 =	(String)hash.get("excl_incl_ind");				
		String bl_incl_excl_override_reason_code =	(String)hash.get("bl_incl_excl_override_reason_code");		
		patient_id						 =	(String)hash.get("patient_id");				
		String encounter_id					     =	(String)hash.get("encounter_id");				
		String sal_trn_type						 =	(String)hash.get("sal_trn_type");				
		String sysdate							 =	(String)hash.get("sysdate");	
		String store_code						 =	(String)hash.get("store_code");	
		String tot_alloc_qty					 =  (String)hash.get("tot_alloc_qty");
		String batch_str						 =  (String)hash.get("batch_str");
		order_id							 =  (String)hash.get("order_id");
		float tot_gross_charge_amount			 =  Float.parseFloat((String)hash.get("tot_gross_charge_amount"));
		float tot_groos_pat_payable				 =  Float.parseFloat((String)hash.get("tot_groos_pat_payable"));
		float old_gross_charge_amount			 =  Float.parseFloat((String)hash.get("old_gross_charge_amount"));
		float old_groos_pat_payable			     =  Float.parseFloat((String)hash.get("old_groos_pat_payable"));	
		String gross_charge_amount				 =  "";
		String groos_pat_payable				 =  "";			
		String tot_gross_charge_amount_str		 =  "";
		String tot_groos_pat_payable_str		 =  "";
		String decimalFormatString				 =  "";
		String dischargeIND				 =  (String)hash.get("dischargeIND");
		String	disp_bean_id				=	"DispMedicationAllStages" ;
		String	disp_bean_name			    =	"ePH.DispMedicationAllStages";	
		DispMedicationAllStages disp_bean   = (DispMedicationAllStages)getBeanObject( disp_bean_id, disp_bean_name,request);

		HashMap chareg_det                  = (HashMap)disp_bean.callItemChargeDtls(patient_id,encounter_id,sal_trn_type,drug_code,Integer.parseInt(tot_alloc_qty), batch_str,sysdate,store_code,excl_incl_ind,bl_incl_excl_override_reason_code,"","","R",dischargeIND);

		if(chareg_det.get("error_msg").equals("")){
			HashMap det =new HashMap();
			det.put("BL_EXCL_INCL_IND",excl_incl_ind);
			det.put("BL_INCL_EXCL_OVERRIDE_REASON_CODE",bl_incl_excl_override_reason_code);   
		  
			decimalFormatString=(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
			 if(!chareg_det.get("grosschargeamt").equals("null")){
				 gross_charge_amount= (String)chareg_det.get("grosschargeamt");
			 }
			 if(!chareg_det.get("patnetamt").equals("null")){
				 groos_pat_payable  = (String)chareg_det.get("patnetamt");
			 }
			tot_gross_charge_amount = tot_gross_charge_amount-old_gross_charge_amount;
			tot_groos_pat_payable = tot_groos_pat_payable-old_groos_pat_payable;
			tot_gross_charge_amount = tot_gross_charge_amount+Float.parseFloat(gross_charge_amount);
			tot_groos_pat_payable   = tot_groos_pat_payable+Float.parseFloat(groos_pat_payable);
			DecimalFormat dfTest    = new DecimalFormat(decimalFormatString);
			tot_gross_charge_amount_str = dfTest.format(tot_gross_charge_amount);
			tot_groos_pat_payable_str   = dfTest.format(tot_groos_pat_payable);
			out.println("setBillingAmounts('"+srl_no+"','"+gross_charge_amount+"','"+groos_pat_payable+"','"+tot_gross_charge_amount_str+"','"+tot_groos_pat_payable_str+"')");
		}
		chareg_det =null;
	}
	else if(identity.equals("GENQMSTOEKN")){ // added for Bru-HIMS-CRF-076 [IN029942] -start
		patient_id						 =	(String)hash.get("patient_id");				
		String encounter_id					     =	(String)hash.get("encounter_id");				
		String token_series_code	= (String)hash.get("token_series_code");
		disp_locn_code				= (String)hash.get("disp_locn_code");
		String session_id = session.getId();
		String[] QMSResult =	bean.genQMSToken(disp_locn_code,token_series_code,encounter_id, session_id);
		if(QMSResult!=null ){
			out.println("assignQMSResult('"+QMSResult[0]+"','"+QMSResult[1]+"','"+"','"+QMSResult+"');");
		}
	} // added for Bru-HIMS-CRF-076 [IN029942] -end
	else if(identity.equals("getDummyTokenNo")){
		String disp_locn_code1=request.getParameter("disp_locn_code");
		String token_series_code1=request.getParameter("token_series_code");
		String dummy_token_no=bean.getTempTokenSeriesNo(facility_id,disp_locn_code1,token_series_code1);
		out.println("dummytoken('"+dummy_token_no+"')");
	}
	else if(identity.equals("storevalues")){ // methods added for Bru_HIMS-CRF-142(30195)
			ArrayList arral1 = new ArrayList();
			HashMap result= new HashMap();
			String check = "";
			int len = Integer.parseInt(request.getParameter("len"));
			for(int i=0;i<len;i++){
				check=(String)hash.get("check_"+i);
				if(check!=null && check.equals("Y")){
					arral1.add((String)hash.get("drug_name_"+i));
					arral1.add((String)hash.get("disp_locn_"+i));
					arral1.add((String)hash.get("storage_locn_"+i));
					arral1.add((String)hash.get("order_status_"+i));
					arral1.add((String)hash.get("token_status_"+i));
					arral1.add((String)hash.get("token_series_code_"+i));
					arral1.add((String)hash.get("token_serial_no_"+i));
					arral1.add((String)hash.get("queue_date_"+i));
					arral1.add((String)hash.get("order_id_"+i));
					arral1.add((String)hash.get("order_line_num_"+i));
					arral1.add((String)hash.get("order_catalog_code_"+i));
					arral1.add((String)hash.get("pat_mode_"+i));
					arral1.add((String)hash.get("disp_locn_code_"+i));
				}
			}
			result=bean.updateOrdDispQ(arral1);
			String msgid=(String)result.get("msgid");
			out.println("onPatArrived(\""+msgid+"\")"); 
	}
	else if(identity.equals("GenTokenonPatArrv")){
		String pat_id=(String)hash.get("patient_id");
		String disp_locn=(String)hash.get("disp_locn_code");
		String token_series=(String)hash.get("token_series");
		String token_no=(String)hash.get("token_serial_no");
		ArrayList gentoken = new ArrayList();
		gentoken	=	bean.getTokenNo(disp_locn,pat_id,token_series,token_no);
		if(gentoken.size()==1){
			out.println("alert(\"" + gentoken.get(0) + "\");") ;
		}
		else{
			out.println("displaygeneratedtoken(\""+ gentoken.get(1) +"\",\""+ gentoken.get(0) +"\")");
		}
	}//addeding end for Bru_HIMS-CRF-142(30195)
	else if(identity.equals("checkChargeDetailsForOtherOrders")){
		patient_id=hash.get("patient_id")==null?"":(String)hash.get("patient_id");
		String encounter_id=hash.get("encounter_id")==null?"":(String)hash.get("encounter_id");
		String patientPayable = bean.getPatientPayable(patient_id);
		String	disp_bean_id				=	"DispMedicationAllStages" ;
		String	disp_bean_name			    =	"ePH.DispMedicationAllStages";	
		DispMedicationAllStages disp_bean   = (DispMedicationAllStages)getBeanObject( disp_bean_id, disp_bean_name,request);
		if(patientPayable==null || patientPayable.equals("")){
			patientPayable = "N";
			disp_locn_code               =   bean.getDispLocnCode();    
			String sys_date						=	bean.getTodaysDate();
			HashMap  hmPrescriptionDetails = bean.getPatPrescriptionDetails();
			ArrayList odrKeyList = new ArrayList(hmPrescriptionDetails.keySet());
			ArrayList alOrderDtl = null;
			HashMap chareg_det = null;
			HashMap bl_override_det = null;
			String ord_id,in_formulary_yn,drugid, order_line_num , patient_class , bms_qty, dischargeIND_yn;
			float groos_pat_payable   =  0;
			for(int indx=0; indx<odrKeyList.size(); indx++){
				ord_id = (String)odrKeyList.get(indx);
				alOrderDtl = (ArrayList)hmPrescriptionDetails.get(ord_id);
				dischargeIND_yn = (String)alOrderDtl.get(alOrderDtl.size()-1);
				for(int i=0; i<(alOrderDtl.size()-1); i+=19){
					drugid = (String)alOrderDtl.get(i);
					order_line_num = (String)alOrderDtl.get(i+8);
					bms_qty = (String)alOrderDtl.get(i+12);
					in_formulary_yn = (String)alOrderDtl.get(i+13);
					if(in_formulary_yn.equals("Y") && disp_bean.getBillableItemYN (drugid).equals("Y") ){ 
						bl_override_det = (HashMap)bean.getbl_override_det(ord_id,order_line_num,drugid);
						if(!encounter_id.equals("")){
							patient_class  =  bean.getEncounterPatientClass(encounter_id,(String)bl_override_det.get("ORDERING_FACILITY_ID"), patient_id);
						}
						else{
							patient_class                  =  "R";
						}

						chareg_det = bean.callItemChargeDtls(patient_id ,encounter_id,patient_class,drugid,Integer.parseInt(bms_qty),";",sys_date,disp_locn_code,(String)bl_override_det.get("BL_INCL_EXCL_OVERRIDE_VALUE"),(String)bl_override_det.get("BL_INCL_EXCL_OVERRIDE_REASON"),ord_id,order_line_num,"R",(String)bl_override_det.get("ORDERING_FACILITY_ID"),dischargeIND_yn);//order_id and order_line_no added for MMS-DM-CRF-0126

						if(chareg_det.get("error_msg").equals("")){
							if(!chareg_det.get("patnetamt").equals("null")){
								 groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
							}
							if(groos_pat_payable>0){
								patientPayable="Y";
								break;
							}
						}
					}
				}
				if(patientPayable.equals("Y")){
					break;
				}
			}
		}
		bean.setPatientPayable(patient_id, patientPayable);
		out.println("displayPayeeIndicator('"+patientPayable+"');");
	}//addeding end for Bru_HIMS-CRF-142(30195)
	putObjectInBean(bean_id,bean,request);
}
catch(Exception e){
	e.printStackTrace();
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
