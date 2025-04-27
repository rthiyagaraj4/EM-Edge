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
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __returnmedicationlogintemporary extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/ReturnMedicationLoginTemporary.jsp", 1722345476437L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
	
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
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
06/08/2020				IN073599				Haribabu														PH-MEDICITY-Return Medication
--------------------------------------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String bean_id    = request.getParameter( "bean_id" )==null?"": request.getParameter( "bean_id" );
	String bean_name  = request.getParameter( "bean_name" )==null?"": request.getParameter( "bean_name" );

	String identity   = request.getParameter( "identity" )==null?"": request.getParameter( "identity" );
	ReturnMedicationBean bean = (ReturnMedicationBean)getBeanObject(bean_id,bean_name,request) ;
	Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
    hash = ( Hashtable )hash.get( "SEARCH" ) ;
	
	if(identity.equals("DISPLOCN")){
		String patientcat = request.getParameter( "patientcat" ) ;
		ArrayList dispLocn =new ArrayList();
		dispLocn=bean.getDispLocn(patientcat,locale) ;
		if (dispLocn.size()==0){
			out.println("clearData('document.FormReturnMedicationLogin.disp_locn');") ;
		}
		out.println("addData('',' ---Select---','document.FormReturnMedicationLogin.disp_locn');");
		for (int i=0; i<dispLocn.size(); i+=2) {
			out.println("addData('"+ dispLocn.get(i) + "', '" + dispLocn.get(i+1) +"', 'document.FormReturnMedicationLogin.disp_locn');") ;
		}
	}
	else if(identity.equals("GETBLDETAILS")){
		// added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979  - start
		ArrayList blDetails = bean.getBLDetails();
		String bldtl ="";
		if(bean.getBillUserForCashCounter()){//if condition added for  KAUH-SCF-0276
		if(blDetails!=null && blDetails.size()>0){
			for(int blindx=0; blindx < blDetails.size(); blindx++){
				bldtl = (String)blDetails.get(blindx);
		// added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979 - End
				out.println("callbillingwindow('"+bldtl+"','"+request.getParameter("disp_locn_code")+"')");
			} 
		}
		// Added for In:073599 start
		else {
			out.println("clearframes()");
		}
		// Added for In:073599 end
	}
		else // else block added for KAUH-SCF-035[In:33236] 					
			out.println("clearframes()");
	}
	else if(identity.equals("SET_ORDERING_FACILITY")){
		String ordering_facility_id = request.getParameter( "ordering_facility_id" ) ;
		bean.setOrderingFacilityID(ordering_facility_id);
	} 
	else if (identity.equals("POPULATEENCOUNTER")){ //added for  AMS-CRF-0172
		String patient_id	= request.getParameter( "patient_id" ) ;
		String patientClass	= request.getParameter( "patientClass" ) ;
		String currentEncounter	= request.getParameter( "currentEncounter" ) ; //Added for IN032455
		ArrayList encounterDetails =new ArrayList();
		String default_encounter_id	= bean.getDefaultEncounterId(patient_id);
		encounterDetails =bean.getEncounterIdDetails(patient_id,patientClass) ;
		out.println("clearData('document.FormReturnMedicationQueryCriteria.encounterId');") ;
		if(currentEncounter==null || !currentEncounter.equals("Y")){
			out.println("addData('',' ---Select---','document.FormReturnMedicationQueryCriteria.encounterId');");
			out.println("document.FormReturnMedicationQueryCriteria.encounterIdCount.value=0");//added for MMS-DM-CRF-0039 [IN:055958]
		}
		else
			out.println("document.FormReturnMedicationQueryCriteria.encounterIdCount.value="+encounterDetails.size());//added for MMS-DM-CRF-0039 [IN:055958]
		for (int i=0; i<encounterDetails.size(); i++) {//i+=2
			if(default_encounter_id!=null && default_encounter_id.equals(encounterDetails.get(i)))
				out.println("addDataDefault('"+ encounterDetails.get(i) + "', '" + encounterDetails.get(i) +"', 'document.FormReturnMedicationQueryCriteria.encounterId','selected');") ;
			else{
				if(currentEncounter==null || !currentEncounter.equals("Y")) //Added for IN032455
					out.println("addDataDefault('"+ encounterDetails.get(i) + "', '" + encounterDetails.get(i) +"', 'document.FormReturnMedicationQueryCriteria.encounterId');") ;
			}
		}	
	} //till here  AMS-CRF-0172	  
	else if(identity.equals("POPULATEENCOUNTERFOROP")){ //code added for FD-JD-CRF-0178[IN039208]
		String patient_id	= request.getParameter( "patient_id" ) ;
		String patientClass	= request.getParameter( "patientClass" ) ;		
		ArrayList encounterDetails = bean.getEncounterIdDetails(patient_id,patientClass) ;		
		out.println("clearData('document.FormReturnMedicationQueryCriteria.encounterId');") ;
		if(encounterDetails.size() <= 0){
			out.println("addData('',' ---Select---','document.FormReturnMedicationQueryCriteria.encounterId');");
			out.println("document.FormReturnMedicationQueryCriteria.encounterIdCount.value=0"); //added for MMS-DM-CRF-0039 [IN:055958]
		}
		else {	
			out.println("document.FormReturnMedicationQueryCriteria.encounterIdCount.value="+encounterDetails.size());//added for MMS-DM-CRF-0039 [IN:055958]
			for(int i=0; i<encounterDetails.size(); i++) {			
				out.println("addDataDefault('"+ encounterDetails.get(i) + "', '" + encounterDetails.get(i) +"', 'document.FormReturnMedicationQueryCriteria.encounterId','');") ;			
			}
		}
	} 
	else if(identity.equals("CHECK_BILL")){
		String patient_id	= request.getParameter( "patientId" ) ;
		String ordering_facility_id	= request.getParameter( "ordering_facility_id" ) ;		
		String encounter_id	= request.getParameter( "encounter_id" ) ;		
		String dispLocn	= request.getParameter( "dispLocn" ) ;		
		boolean bill_gen_yn			   = bean.getBillGenStatus(patient_id,ordering_facility_id,encounter_id);		
		if(bill_gen_yn )	{			
			out.println("assignBillGenValue('Y');") ;			
		}
	}//code added for FD-JD-CRF-0178[IN039208] --End
	/* Added for GHL-CRF-0413.8 START */
	else if(identity.equals("INCREASEQTY")){
		String barcode	= request.getParameter( "barcode" ) ;
		String new_ret_qty	= request.getParameter( "new_ret_qty" ) ;	
		String returnable	= request.getParameter( "returnable" ) ;
		String count	= request.getParameter( "count" ) ;
		 int row_value =Integer.parseInt(count);
		 row_value=row_value*41; //changed 40 to 41 for ML-BRU-SCF-1842
		 String temp_ret_qty="";//Integer.parseInt(new_ret_qty);
		 int temp_returnable=Integer.parseInt(returnable);
		 
		ArrayList temp_barcode_details=bean.getNewBarcodeArry();
		if(temp_barcode_details.size()>0){
			
			for (int k=row_value;k<temp_barcode_details.size();k+=41) //changed 40 to 41 for ML-BRU-SCF-1842
			{
				if(!temp_barcode_details.get(k+19).equals("0") ){
					   
						 if(temp_barcode_details.get(k+39).equals(barcode)){
							 temp_ret_qty=(""+temp_barcode_details.get(k+38));
							 if(temp_ret_qty.equals(""))
								 temp_ret_qty="0";
							 int old_ret_qty=Integer.parseInt(temp_ret_qty);
							 if(old_ret_qty<temp_returnable){
							 temp_barcode_details.set(k+38, new_ret_qty);
							 bean.setNewBarcodeArry(temp_barcode_details);
							  break;
							 }else{
								 int temp_row_value =Integer.parseInt(count);
		                         row_value=temp_row_value*41+41; //changed 40 to 41 for ML-BRU-SCF-1842
							 }
						 }
						
						
				}else{
					row_value=row_value+41; //changed 40 to 41 for ML-BRU-SCF-1842
				}
			}
		}
	}
	else if(identity.equals("CANCELACTION")){
		bean.clearSavedList();
	}/*  Added for GHL-CRF-0413.8 end */
	else if(identity.equals("INCREMENTACTION")){
		String new_ret_qty	= request.getParameter( "new_ret_qty" ) ;	
		String count	= request.getParameter( "count" ) ;
		 int row_value =Integer.parseInt(count);
		 row_value=row_value*41;//changed 40 to 41 for ML-BRU-SCF-1842
		 int k=row_value;
		 String temp_ret_qty="";//Integer.parseInt(new_ret_qty);
		// int temp_returnable=Integer.parseInt(returnable);
		 
		ArrayList temp_barcode_details=bean.getNewBarcodeArry();
		if(temp_barcode_details.size()>0){
			
			 temp_ret_qty=""+(temp_barcode_details.get(k+38));
							 if(temp_ret_qty.equals(""))
								 temp_ret_qty="0";
							 int old_ret_qty=Integer.parseInt(temp_ret_qty);
							 
							 temp_barcode_details.set(k+38, new_ret_qty);
							 bean.setNewBarcodeArry(temp_barcode_details);
							  
							 
				
			
		}
	}

	putObjectInBean(bean_id,bean,request);

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
