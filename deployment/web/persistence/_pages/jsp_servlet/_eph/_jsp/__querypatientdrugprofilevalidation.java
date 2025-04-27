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
import eST.*;
import eST.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __querypatientdrugprofilevalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/QueryPatientDrugProfileValidation.jsp", 1721020675001L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n ";
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
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
10/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
---------------------------------------------------------------------------------------------------------------
*/ 
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	try {		
		String func_mode			= request.getParameter("func_mode");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		if(func_mode!= null && func_mode.equals("DiscCancel")) {
			String reason			= (String) hash.get( "reason" );
			String remarks			= (String) hash.get( "remarks" );
			String status			= (String) hash.get( "status" );
			String order_line_no	= (String) hash.get( "order_line_no" );
			String order_id			= (String) hash.get( "order_id" );
			String called_frm		= (String) hash.get( "called_frm" );
			String	bean_id			= "QueryPatientDrugProfileBean" ;
			String	bean_name		= "ePH.QueryPatientDrugProfileBean";
			
			QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id, bean_name,request);
			bean.setLanguageId(locale);
			HashMap result = bean.discCancelDrug(order_id,order_line_no,remarks,reason,status);
			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				out.println("alertMessage('"+result.get( "message" )+"','"+called_frm+"')");
			}else{
				out.println(result);
			}
			putObjectInBean(bean_id,bean,request);
		}	
		else if(func_mode!= null && func_mode.equals("Duplicate")) { /* This block of code added for ML-BRU-SCF-0621[IN036565] -- Start */ 
			
			String bean_id		= (String) hash.get( "bean_id" );	
			String bean_name		= (String) hash.get( "bean_name" );			
			String patient_id		= (String) hash.get( "patientId" );		
			String chk_Patient	= (String) hash.get("chkPatientID");		
			String main_patientid   = "";		
			QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id, bean_name,request);
			bean.setLanguageId(locale);
			main_patientid  = bean.DuplicateCheck(patient_id);		
			if(main_patientid != null && main_patientid!="" ){
				out.println("mergedPatientAlert('"+main_patientid+"');");			
			 }			
			else if(chk_Patient!= null && chk_Patient.equals("true")){
			   out.println("chkPatientID('"+patient_id+"');");	
			}		
			putObjectInBean(bean_id,bean,request);
		} /* code added for ML-BRU-SCF-0621[IN036565] -- End */ 
        else if(func_mode!= null && func_mode.equals("update_accession_num")) { /* This block of code added for AAKH-CRF-0088.2 -- Start */ 
			String bean_id		= (String) hash.get( "bean_id" );	
			String bean_name		= (String) hash.get( "bean_name" );			
			String patient_id		= (String) hash.get( "patient_id" );		
			String drug_code	= (String) hash.get("drug_code");	
			String srl_no	= (String) hash.get("srl_no");
			String accession_no = (String) hash.get("retVal");
			String facility_id = (String) hash.get("facility_id");
			QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id, bean_name,request);
			
			bean.setLanguageId(locale);
			bean.UpdateAccessNo(accession_no, patient_id, drug_code, srl_no, facility_id);		
								
			putObjectInBean(bean_id,bean,request);
		} /* code added for AAKH-CRF-0088.2 -- End added for IN070786 start */ 
        else if(func_mode!= null && func_mode.equals("fetchDrugDetails")) {
			String bean_id		= (String) hash.get( "bean_id" );	
			String bean_name		= (String) hash.get( "bean_name" );			
			String drug_code	= (String) hash.get("drug_code");
			HashMap detailsMap			= new HashMap();
			String form_code="";
			String route_code="";
			//System.out.println("drug_code"+drug_code);
			QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id, bean_name,request);
			bean.setLanguageId(locale);
			detailsMap=bean.getDrugdetails(drug_code);
			ArrayList routes = (ArrayList)detailsMap.get("routes");
			ArrayList FreqList=(ArrayList)detailsMap.get("FreqList");
			route_code=(String)detailsMap.get("ROUTE_CODE");
			form_code=(String)detailsMap.get("FORM_CODE");
			String dosage_type=(String)detailsMap.get("DOSAGE_TYPE");
			String ori_dosage_type=(String)detailsMap.get("ORI_DOSAGE_TYPE");
			String strength_uom=(String)detailsMap.get("STRENGTH_UOM");
			String strength_uom_desc=(String)detailsMap.get("STRENGTH_UOM_DESC");
			ArrayList QtyDescDetails		= (ArrayList)bean.loadQtyDetails(form_code);
			out.println("clearData('document.PatientExternalDrug.route_code');") ;
			out.println("clearData('document.PatientExternalDrug.frequency');") ;
			out.println("clearData('document.PatientExternalDrug.dosage');") ;
			if(routes.size() <= 0){
				out.println("addDataDefault('',' ---Select---','document.PatientExternalDrug.route_code');");
			//	out.println("document.formClaimFormsCriteria.encounterIdCount.value=0"); 
			}
			else {	
				//out.println("document.formClaimFormsCriteria.encounterIdCount.value="+encounterDetails.size());
			//	out.println("alert(document.formClaimFormsCriteria.Patient_Id.value)");
				for(int i=0; i<routes.size(); i=i+3) {			
										
					if(route_code.equals(routes.get(i)))
						out.println("addDataDefault('"+ routes.get(i) + "', '" + routes.get(i+1) +"', 'document.PatientExternalDrug.route_code','selected');") ;
					else{
						out.println("addDataDefault('"+ routes.get(i) + "', '" + routes.get(i+1) +"', 'document.PatientExternalDrug.route_code');") ;
					}
				
				}
			}
			
			if(FreqList.size() <= 0){
				out.println("addDataDefault('',' ---Select---','document.PatientExternalDrug.frequency');");
			//	out.println("document.formClaimFormsCriteria.encounterIdCount.value=0"); 
			}
			else {	
				//out.println("document.formClaimFormsCriteria.encounterIdCount.value="+encounterDetails.size());
			//	out.println("alert(document.formClaimFormsCriteria.Patient_Id.value)");
				for(int i=0; i<FreqList.size(); i=i+3) {			
										
					if(form_code.equals(FreqList.get(i)))
						out.println("addDataDefault('"+ FreqList.get(i) + "', '" + FreqList.get(i+1) +"', 'document.PatientExternalDrug.frequency','selected');") ;
					else{
						out.println("addDataDefault('"+ FreqList.get(i) + "', '" + FreqList.get(i+1) +"', 'document.PatientExternalDrug.frequency');") ;
					}
				
				}
			}
			
			
			if(dosage_type.equals("A")){
				out.println("addDataDefault('A', 'Absolute', 'document.PatientExternalDrug.dosage','selected');") ;
				}
				else if(dosage_type.equals("S")){
					out.println("addDataDefault('S', 'Strength', 'document.PatientExternalDrug.dosage','selected');") ;
						out.println("addDataDefault('Q', 'Quantity', 'document.PatientExternalDrug.dosage','');") ;
				}
				else if(dosage_type.equals("Q")){
				if(ori_dosage_type.equals("S")){
				out.println("addDataDefault('S', 'Strength', 'document.PatientExternalDrug.dosage','');") ;
				out.println("addDataDefault('Q', 'Quantity', 'document.PatientExternalDrug.dosage','selected');") ;
				}
				else{
				out.println("addDataDefault('Q', 'Quantity', 'document.PatientExternalDrug.dosage','selected');") ;
				}
				}
			if(dosage_type.equals("S")){
				out.println("addDataDefault('"+ strength_uom + "', '" + strength_uom_desc +"', 'document.PatientExternalDrug.qty_desc','selected');") ;
			}
			
			else{
			if(QtyDescDetails.size() <= 0){
				out.println("addDataDefault('',' ---Select---','document.PatientExternalDrug.qty_desc');");
			//	out.println("document.formClaimFormsCriteria.encounterIdCount.value=0"); 
			}
			else {	
				//out.println("document.formClaimFormsCriteria.encounterIdCount.value="+encounterDetails.size());
			//	out.println("alert(document.formClaimFormsCriteria.Patient_Id.value)");
				for(int i=0; i<QtyDescDetails.size(); i=i+3) {			
										
					if(form_code.equals(QtyDescDetails.get(i)))
						out.println("addDataDefault('"+ QtyDescDetails.get(i) + "', '" + QtyDescDetails.get(i+1) +"', 'document.PatientExternalDrug.qty_desc','selected');") ;
					else{
						out.println("addDataDefault('"+ QtyDescDetails.get(i) + "', '" + QtyDescDetails.get(i+1) +"', 'document.PatientExternalDrug.qty_desc');") ;
					}
				
				}
			}
        }
			out.println("addDefaultValues('"+form_code+"');");
			putObjectInBean(bean_id,bean,request);
		}
        else if(func_mode!= null && func_mode.equals("changeuomDetails")) {
        	
        	String bean_id		= (String) hash.get( "bean_id" );	
			String bean_name    = (String) hash.get( "bean_name" );			
			String drug_code	= (String) hash.get("drug_code");
			String form_code	= (String) hash.get("form_code");
			String dosage_type =(String)hash.get("dosage_type");
			System.out.print("dosage_type"+dosage_type);
			System.out.println("drug_code"+drug_code);
			QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id, bean_name,request);
			bean.setLanguageId(locale);
			
			ArrayList QtyDescDetails		= (ArrayList)bean.loadQtyDetails(form_code);
			ArrayList strengthDetails		= (ArrayList)bean.strengthDetails(drug_code);
			out.println("clearData('document.PatientExternalDrug.qty_desc');") ;
			if(dosage_type.equals("S")){
				out.println("addDataDefault('"+ strengthDetails.get(0) + "', '" + strengthDetails.get(1) +"', 'document.PatientExternalDrug.qty_desc','selected');") ;
			}
			
			else{
			if(QtyDescDetails.size() <= 0){
				out.println("addDataDefault('',' ---Select---','document.PatientExternalDrug.qty_desc');");
			//	out.println("document.formClaimFormsCriteria.encounterIdCount.value=0"); 
			}
			else {	
				//out.println("document.formClaimFormsCriteria.encounterIdCount.value="+encounterDetails.size());
			//	out.println("alert(document.formClaimFormsCriteria.Patient_Id.value)");
				for(int i=0; i<QtyDescDetails.size(); i=i+3) {			
										
					if(form_code.equals(QtyDescDetails.get(i)))
						out.println("addDataDefault('"+ QtyDescDetails.get(i) + "', '" + QtyDescDetails.get(i+1) +"', 'document.PatientExternalDrug.qty_desc','selected');") ;
					else{
						out.println("addDataDefault('"+ QtyDescDetails.get(i) + "', '" + QtyDescDetails.get(i+1) +"', 'document.PatientExternalDrug.qty_desc');") ;
					}
				
				}
			}
        }
        }//added for IN070786 end
		
	}catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
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
