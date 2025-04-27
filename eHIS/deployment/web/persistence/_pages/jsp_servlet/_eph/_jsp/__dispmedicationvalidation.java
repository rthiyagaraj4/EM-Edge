package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.util.BundleMessage;
import org.jgroups.Message;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.text.DecimalFormat;
import eST.*;
import eST.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import eXH.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __dispmedicationvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationValidation.jsp", 1742368408479L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="  \n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
/* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100		 			?           created
09/08/2019      IN070605		 prathyusha  MMS-KH-CRF-0028
29/08/2020		IN073787		 shazana		ML-BRU-SCF-2047
09/11/2020		7405		 Manickavasagam			SKR-SCF-1459
29/11/2020  	IN:7977	        	Manickavasagam J                 SKR-SCF-1483
16/03/2021   IN15562         Manickavasagam J	 	   		 ML-MMOH-SCF-1741
26/04/2021   16820         Manickavasagam J	 	   		 MMS-KH-CRF-0038.1
06/01/2021	 TFS-25868		Prabha				GHL-CRF-0627
08/05/2023	 				Sushant T			GHL-SCF-1714
09/09/2023                  hariharan k         SKR-SCF-1734
---------------------------------------------------------------------------------------------------------------
*/ 
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE"); 
   Connection con			= null;  // Added for ML-MMOH-crf-0468 start
    String Sysdate 				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);// SKR-SCF-1734
    // Added for ML-MMOH-CRF-0468 - End
	
	boolean siteTpnStd =false;
	boolean siteTpn =false;
	boolean is_site_drug_label = false;
	boolean disp_sheet_check=false; //Added for GHL-CRF-0627
	boolean num_print_skr =false;//added for skr-scf-1721
	boolean isJobQueueReport = false; //Added for ML-MMOH-CRF-2155.1
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ; //added for IN070867
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );//added for IN070867
		String func_mode			= request.getParameter("func_mode");
	    System.out.println(" ML-MMOH-CRF-2042Validation-----Start4");	
	try {	
		con				= ConnectionManager.getConnection(request);
		siteTpn = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_MF_LABEL");// Added for ML-MMOH-CRF-0468 		
	    siteTpnStd = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_STD_REGIMEN_LABEL");// added for ML-MMOH-CRF-1089
		is_site_drug_label = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_LABEL_FORMAT");// added for ARYU-CRF-0014
		disp_sheet_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DISP_SHEET_CHECK");  //Added for GHL-CRF-0627
		num_print_skr=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PRINT_NUM_FOR_SKR"); //added for skr-scf-1721
		System.out.println(" ML-MMOH-CRF-2042Validation-----Start5");
	    isJobQueueReport		= eCommon.Common.CommonBean.isSiteSpecific(con,"PH","JOB_QUEUE_REPORT"); //Added for ML-MMOH-CRF-2155.1
	}
	catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}
	finally{ // Added for ML-MMOH-SCF-0468 start
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	} // Added for ML-MMOH-SCF-0468 end	
		
		
		if (func_mode==null) func_mode="";
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		String bean_id				=	"";
		String bean_name			=	"";
		if(hash.containsKey("SEARCH")) {
			hash				= (Hashtable)hash.get( "SEARCH" ) ;
			bean_id				= (String) hash.get( "bean_id" );
			if (bean_id==null) 	bean_id			= "";
			bean_name			= (String) hash.get( "bean_name" );
			if (bean_name==null) bean_name		= "";
		}

		if(bean_id.equals("")){
			bean_id = request.getParameter("bean_id") == null?"":request.getParameter("bean_id") ;
			bean_name = request.getParameter("bean_name")== null?"":request.getParameter("bean_name") ;
		}

		DispMedicationAllStages beanObj =null;
		if (!bean_name.equals("")){
			beanObj		= (DispMedicationAllStages)getBeanObject(bean_id,bean_name,request);
			beanObj.setLanguageId(locale);
		}
		if(func_mode!= null && func_mode.equals("reason")) {
			//Called for Releasing 
			String reason					= (String) hash.get( "reason" );
			String remarks					= java.net.URLDecoder.decode( (String) hash.get( "remarks" ),"UTF-8");
			String recno					= (String) hash.get( "recno" );
			String order_line_no			= (String) hash.get( "order_line_no" );
			String order_id					= (String) hash.get( "order_id" );
			beanObj.setRemarks(reason,remarks,recno);
			beanObj.setHold(order_id,order_line_no);
			out.println("callClose('OK')");
		}
		else if(func_mode!= null && func_mode.equals("get_pat_class")) {
			String disp_no		=	(String) hash.get( "disp_no" );
			String pat_class	=	beanObj.getPatientClass(disp_no);
			out.println("assignPatientClass('"+pat_class+"');");

		}
		else if(func_mode!= null && func_mode.equals("release")) {
			//Called for Releasing 
			String reason					= (String) hash.get( "reason" );
			String remarks					= java.net.URLDecoder.decode( (String) hash.get( "remarks" ),"UTF-8");
			String recno					= (String) hash.get( "recno" );
			String order_line_no			= (String) hash.get( "order_line_no" );
			String order_id					= (String) hash.get( "order_id" );
			beanObj.clearRemarks(recno);
			beanObj.clearHold(order_id,order_line_no);
			beanObj.setRemarks(reason,remarks,recno);
			out.println("callClose('RELEASE')");
		}
		else if(func_mode!= null && func_mode.equals("filling")) {  // added by senthilkumar on 17/4/2004
			String reason					= (String) hash.get( "reason" );
			String remarks					= (String) hash.get( "remarks" );
			String recno					= (String) hash.get( "recno" );
			String order_line_no			= (String) hash.get( "order_line_no" );
			String order_id					= (String) hash.get( "order_id" );
			//String drug_code				= (String) hash.get( "drug_code" );
			String chk						= ((String) hash.get( "chk" )).trim();
			if(remarks!=null && !remarks.equals("")){
				remarks = java.net.URLDecoder.decode(remarks,"UTF-8");
			}
			if(chk.equals("F")){
				beanObj.clearFillRemarks(order_id+"_"+order_line_no);
				beanObj.setFillingRemarks(reason,remarks,order_id+"_"+order_line_no);
			}
			if(chk.equals("D")){
				beanObj.clearDeliveryFillRemarks(order_id+"_"+order_line_no);
				beanObj.setDeliveryFillingRemarks(reason,remarks,order_id+"_"+order_line_no);
			}
			else if(chk.equals("A")){
				beanObj.clearAllocateFillRemarks(recno);
				beanObj.setAllocateFillingRemarks(reason,remarks,order_id+"_"+order_line_no);
			}
		}
		else if(func_mode!= null && func_mode.equals("cancelFilling")) {  
			
			String reason					= "";
			String remarks					= "";
			String recno					= (String) hash.get( "recno" );
			String order_line_no			= (String) hash.get( "order_line_no" );
			String order_id					= (String) hash.get( "order_id" );
			String chk						= ((String) hash.get( "chk" )).trim();

			if(chk.equals("F")){
				beanObj.clearFillRemarks(recno);
				beanObj.setFillingRemarks(reason,remarks,order_id+"_"+order_line_no);
			}
			else if(chk.equals("D")){
				beanObj.clearDeliveryFillRemarks(recno);
				beanObj.setDeliveryFillingRemarks(reason,remarks,order_id+"_"+order_line_no);
			}
			else if(chk.equals("A")){
				beanObj.clearAllocateFillRemarks(recno);
				beanObj.setAllocateFillingRemarks(reason,remarks,order_id+"_"+order_line_no);
			}
		}
		else if(func_mode!= null && func_mode.equals("userPINAuthValidation")) {   // RUT-CRF-0035 [IN029926] PIN Authentication --begin
			String call_from			= (String) hash.get( "call_from" );
			String user_name			= (String) hash.get( "user_name" );
			String user_id				= (String) hash.get( "user_id" );
			String PIN					= (String) hash.get( "PIN" );	
			String disp_locn_code		= (String) hash.get( "disp_locn_code" );	
			String disp_category		= (String) hash.get( "disp_category" );	
			String witness				= (String) hash.get( "witness" )==null?"":(String) hash.get( "witness" );// Added for AAKH-CRF-0023[IN:038259]//null handled for jd-crf-0200
			String patient_id			= (String) hash.get( "patient_id" );// Added for AAKH-CRF-0023[IN:038259]
			String encounter_id			= (String) hash.get( "encounter_id" );// Added for AAKH-CRF-0023[IN:038259]
			PIN  =java.net.URLDecoder.decode(PIN,"UTF-8");
			String result=beanObj.validateUserAuthPIN(user_id,PIN,call_from,disp_locn_code,disp_category);
			if("1".equals(result)){
				result=user_id;
				if(call_from.equals("MAR") && witness.equals("Y")){// Added for AAKH-CRF-0023[IN:038259] start
					String pres_bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
					String pres_bean_name			= "ePH.PrescriptionBean_1";
					PrescriptionBean_1 presbean		= (PrescriptionBean_1)getBeanObject( pres_bean_id, pres_bean_name, request );
					presbean.setWitnessByUser(user_id);
					putObjectInBean(pres_bean_id,presbean,request);
				}// Added for AAKH-CRF-0023[IN:038259] end
				if("A".equals(call_from) || "F".equals(call_from)|| "D".equals(call_from)|| "AS".equals(call_from)|| "IPF".equals(call_from)|| "IPFA".equals(call_from) || "V".equals(call_from)){
					beanObj.setAuthUserID(user_id);
				}
			}
			out.println(result);
		}
		else if(func_mode!= null && func_mode.equals("storeAuthUserInBean")){// Added for RUT-CRF-0035 [IN029926]  --begin
			beanObj.setAuthUserID((String) hash.get( "auth_user_id" ));
		} // Added for RUT-CRF-0035 [IN029926] --end
		else if (func_mode!= null && func_mode.equals("fill_person")){
			String fill_person_name		=(String) hash.get("fill_person_name");
			beanObj.setFillPersonName(fill_person_name);
		}
		else if (func_mode !=null && func_mode.equals("setAmendDetails")){
			DispMedicationAllStages beanObject =null;
			String code = ((String)hash.get("reason")).trim();
			String bean_id_remarks	 = (String)hash.get("bean_id");
			String bean_name_remarks = (String)hash.get("bean_name");
			String frmObj			 = (String)hash.get("frmObj");
			String appl_trn_type	 = ((String)hash.get("appl_trn_type")).trim();
			if (!bean_name.equals(""))
			 beanObject		= (DispMedicationAllStages)getBeanObject(bean_id_remarks, bean_name_remarks,request);	
			beanObject.setLanguageId(locale);
			String remarks = beanObject.checkForNull(beanObject.getRemarks(code,appl_trn_type));	
			remarks=remarks.replaceAll(" ","%20");//added for SKR-SCF-0208 -IN029298 -start
			remarks = java.net.URLEncoder.encode(remarks,"UTF-8" );
			remarks=remarks.replaceAll("%2520","%20"); //added for SKR-SCF-0208 -IN029298 -End
			out.println("document."+frmObj+".remarks.value=(decodeURIComponent('"+remarks+"'))");
			putObjectInBean(bean_id_remarks,beanObject,request);
		}
		else if(func_mode!= null && func_mode.equals("editlabel")){  //added for edit label 19/4/2004
			String sCalledFrom				= request.getParameter("calledFrom");
			int iTotalRecords				= Integer.parseInt(request.getParameter("totalRecordds"));
			String allow_edit_disp_label	= request.getParameter("allow_edit_disp_label")==null?"":request.getParameter("allow_edit_disp_label");
			String noOfPrints			    = "";// Code Added For RUT-CRF-0067
			String order_line_no			= "";
			String order_id					= "";
			String drug_code				= "";
			ArrayList editLabel				= new ArrayList();
			ArrayList printList             = new ArrayList();// Code Added For RUT-CRF-0067
			HashMap totalPrint              = new HashMap(); // Added for TTMWM-SCF-0184 - Start
			String disp_no                   ="";
			String disp_srl_no               =""; // Added for TTMWM-SCF-0184  - End
			String sDispStage  = request.getParameter("sDispStage")== null?"":request.getParameter("sDispStage");//Added for PH-HSA-CRF-0166 Linked Inc : 050750
			System.out.println(" ML-MMOH-CRF-2042Validation-----Start32");
					if(allow_edit_disp_label.equals("Y")){	System.out.println("220 allow_edit_disp_label"+allow_edit_disp_label);
				String labelLangId = beanObj.checkForNull(request.getParameter( "labelLangId"),"en");
				String	bean_id_1			=	"DispMedicationBean" ;
				String	bean_name_1			=	"ePH.DispMedicationBean";
				DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
				bean_1.SetEditableLabelLangId(labelLangId);
				for(int iCount= 0; iCount<iTotalRecords;iCount++){
					editLabel = new ArrayList();
					order_line_no	= beanObj.checkForNull(request.getParameter( "order_line_no_"+iCount ));
					order_id		= beanObj.checkForNull(request.getParameter( "order_id_"+iCount ));
					drug_code		= beanObj.checkForNull(request.getParameter( "drug_code_"+iCount ));
					noOfPrints		= beanObj.checkForNull(request.getParameter( "noOfPrints"+iCount ));
					System.out.println("noOfPrints"+noOfPrints);
					disp_no         = beanObj.checkForNull(request.getParameter( "disp_no_"+iCount )); // Added for TTMWM-SCF-0184  - Start
					disp_srl_no         = beanObj.checkForNull(request.getParameter( "disp_srl_no_"+iCount ));
					totalPrint.put(disp_no+"@"+disp_srl_no, noOfPrints); // Added for TTMWM-SCF-0184 -End
					if(!order_id.equals("") && !drug_code.equals("")){
						editLabel.add(beanObj.checkForNull(request.getParameter( "pres_drug_code_"+iCount ))) ;
						editLabel.add(drug_code) ;
						editLabel.add(beanObj.checkForNull(request.getParameter( "dispQty"+iCount ))) ;
						editLabel.add(beanObj.checkForNull(request.getParameter( "dispUOM"+iCount ))) ;
						editLabel.add(beanObj.checkForNull(request.getParameter( "dosageDtl_"+iCount ))) ;
						editLabel.add(noOfPrints) ;
						editLabel.add(beanObj.checkForNull(request.getParameter( "instruction_"+iCount ))) ;
						editLabel.add(beanObj.checkForNull(request.getParameter( "drug_yn"+iCount ))) ;//added for ML-BRU-SCF-1524 [IN:053164]
						beanObj.clearEditableLabel(order_id+"_"+drug_code+"_"+order_line_no+"_"+labelLangId);
						beanObj.setEditableLabel(editLabel,order_id+"_"+drug_code+"_"+order_line_no+"_"+labelLangId);
					}
					if(noOfPrints!=null && !noOfPrints.equals("")) //if condition added for EMR Spira# 1380
						{System.out.println("noOfPrints 245"+noOfPrints);
						printList.add(noOfPrints);
						System.out.println("261 noOfPrints"+noOfPrints);
						}
					System.out.println("266 sDispStage"+sDispStage);
					if(sDispStage.equals("F") || sDispStage.equals("A")){//added for skr-scf-1720
						beanObj.InsertPrintCountFill(disp_no,disp_srl_no,noOfPrints);
					}
					else{
						beanObj.InsertPrintCountDeliver(disp_no,disp_srl_no,noOfPrints);
					}
				}
				System.out.println(" ML-MMOH-CRF-2042Validation-----Start34");
				putObjectInBean(bean_id_1,bean_1,request);
			}
			else{
				System.out.println(" ML-MMOH-CRF-2042Validation-----Start35");
				String caution_1				= "";
				String caution_2				= "";
				String special_1				= "";
				String special_2				= "";
				String patient_int				= "";
				String pres_remarks				= "";
				String loc_caution_1			= "";
				String loc_caution_2			= "";
				String loc_special_1			= "";
				String loc_special_2			= "";
				String loc_patient_int			= "";
				String drug_indication          = "";
				String loc_drug_indication          = "";
				String line_bms_remarks_code="";//added for jd-crf-0221
				System.out.println("282 sDispStage"+sDispStage);
				System.out.println(" ML-MMOH-CRF-2042Validation-----Start36");
				for(int iCount= 0; iCount<iTotalRecords;iCount++){
					order_line_no			= request.getParameter( "order_line_no_"+iCount ) == null?"":request.getParameter( "order_line_no_"+iCount );
					order_id				= request.getParameter( "order_id_"+iCount )== null?"":request.getParameter( "order_id_"+iCount);
					drug_code				= request.getParameter( "drug_code_"+iCount )== null?"":request.getParameter( "drug_code_"+iCount );
					caution_1				= request.getParameter( "caution_1_"+iCount)== null?"":request.getParameter( "caution_1_"+iCount );
					caution_2				= request.getParameter( "caution_2_"+iCount )== null?"":request.getParameter( "caution_2_"+iCount );
					special_1				= request.getParameter( "special_1_"+iCount )== null?"":request.getParameter( "special_1_"+iCount );
					special_2				= request.getParameter( "special_2_"+iCount )== null?"":request.getParameter( "special_2_"+iCount );
					patient_int				= request.getParameter( "patient_int_"+iCount)== null?"":request.getParameter( "patient_int_"+iCount );
					pres_remarks			= request.getParameter( "pres_remarks_"+iCount )== null?"":request.getParameter( "pres_remarks_"+iCount );
					noOfPrints		= beanObj.checkForNull(request.getParameter( "noOfPrints"+iCount ));
					disp_no         = beanObj.checkForNull(request.getParameter( "disp_no_"+iCount )); // Added for TTMWM-SCF-0184  - Start
					disp_srl_no         = beanObj.checkForNull(request.getParameter( "disp_srl_no_"+iCount ));
					line_bms_remarks_code=	 request.getParameter( "line_bms_remarks_code_"+iCount)== null?"":request.getParameter( "line_bms_remarks_code_"+iCount );	
					System.out.println("310 line_bms_remarks_code"+line_bms_remarks_code);
					System.out.println("321 sDispStage"+sDispStage);
					if(sDispStage.equals("F") || sDispStage.equals("A")){//added for skr-scf-1720
						beanObj.InsertPrintCountFill(disp_no,disp_srl_no,noOfPrints);
					}
					else{
						beanObj.InsertPrintCountDeliver(disp_no,disp_srl_no,noOfPrints);
					}
					System.out.println(" ML-MMOH-CRF-2042Validation-----Start37");
					totalPrint.put(disp_no+"@"+disp_srl_no, noOfPrints); // Added for TTMWM-SCF-0184 -End
					editLabel				= new ArrayList();
					editLabel.add(caution_1);
					editLabel.add(caution_2);
					editLabel.add(special_1);
					editLabel.add(special_2);
					editLabel.add(patient_int);	
					//editLabel.add(line_bms_remarks_code);
					loc_caution_1			= request.getParameter( "loc_caution_1_"+iCount )== null?"":request.getParameter( "loc_caution_1_"+iCount );
					editLabel.add(loc_caution_1) ;
					loc_caution_2 = request.getParameter( "loc_caution_2_"+iCount )== null?"":request.getParameter( "loc_caution_2_"+iCount );
					editLabel.add(loc_caution_2) ;
					loc_special_1	= request.getParameter( "loc_special_1_"+iCount )== null?"":request.getParameter( "loc_special_1_"+iCount );
					editLabel.add(loc_special_1) ;
					loc_special_2	= request.getParameter( "loc_special_2_"+iCount )== null?"":request.getParameter( "loc_special_2_"+iCount );
					editLabel.add(loc_special_2) ;
					System.out.println(" ML-MMOH-CRF-2042Validation-----Start38");
					loc_patient_int	= request.getParameter( "loc_patient_int_"+iCount )== null?"":request.getParameter( "loc_patient_int_"+iCount );
					drug_indication = request.getParameter( "drug_ind_"+iCount )== null?"":request.getParameter( "drug_ind_"+iCount );//Added DRUG_INDICATION for  ML-BRU-CRF-72[Inc:29938]
					loc_drug_indication = request.getParameter( "loc_drug_ind_"+iCount )== null?"":request.getParameter( "loc_drug_ind_"+iCount );//Added DRUG_INDICATION for  ML-BRU-CRF-72[Inc:29938]
					//line_bms_remarks_code=	 request.getParameter( "line_bms_remarks_code_"+iCount)== null?"":request.getParameter( "line_bms_remarks_code_"+iCount );	
					System.out.println("301 line_bms_remarks_code"+line_bms_remarks_code);
					editLabel.add(loc_patient_int) ;
					editLabel.add(pres_remarks) ;
					System.out.println(" ML-MMOH-CRF-2042Validation-----Start39");
					editLabel.add(drug_indication) ;//Added DRUG_INDICATION for  ML-BRU-CRF-072[Inc:29938]
					editLabel.add(drug_code) ;
					editLabel.add(line_bms_remarks_code);
					System.out.println(" ML-MMOH-CRF-2042Validation-----Start40");
					beanObj.clearEditLabel((order_id+"_"+drug_code+"_"+order_line_no).trim());
					beanObj.setEditLabel(editLabel,(order_id+"_"+drug_code+"_"+order_line_no).trim());
					if(noOfPrints!=null && !noOfPrints.equals("")) //if condition added for EMR Spira# 1380
						printList.add(noOfPrints);
				}
			}
			beanObj.setNoOfPrints(printList);// Code Added For RUT-CRF-0067
			beanObj.setTotalPrint(totalPrint); // Added for TTMWM-SCF-0184
			out.println("<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
			out.println("<script>async function triggerPrintAndWait() {");
			if(sCalledFrom!=null && sCalledFrom.equals("PRINT_DIALOG")){

				String sComputeSetOrder	= request.getParameter("ComputeSetOrder");
				String sObjPrintSelectFrame = request.getParameter("PrintDialogFrame");

				if(beanObj.getAlEditLabelPairValues().size()>0  || (beanObj.getEditableLabel()!=null && beanObj.getEditableLabel().size()>0)){
					beanObj.updateDTLValues();
				}
				
				if(sComputeSetOrder.equals("true")){
					out.println(sObjPrintSelectFrame+".recordButton.onclick();");
				}
				//out.println("printOnlineDispense("+sObjPrintSelectFrame+",'OK');");
				//out.println("if("+sObjPrintSelectFrame+"!= undefined && "+sObjPrintSelectFrame+".printOK != null){");
				//out.println("await "+sObjPrintSelectFrame+".printOK.onclick();");
				//out.println("}");
				//oBean.clearAlOrderLineDataForEditLables();
				//out.println("</script>");
				
				out.println("    return new Promise((resolve, reject) => {");
				out.println("        try {");
				out.println("            if ("+sObjPrintSelectFrame+" != undefined && "+sObjPrintSelectFrame+".printOK != null) {");
				out.println("                const printOKButton = "+sObjPrintSelectFrame+".printOK;");
				out.println("				 const originalOnClick = printOKButton.onclick;");
				out.println("				printOKButton.onclick = function(event) {");
				out.println("                    if (originalOnClick) {");
				out.println("						originalOnClick.call(printOKButton, event); }");
				out.println("                    resolve('Print action completed.');");
				out.println("                };");
				out.println("				printOKButton.click();");
				out.println("            } else {");
				out.println("               reject('DispMedicationPrintDialog or printOK is undefined.'); }");
				out.println("        } catch (error) {");
				out.println("            reject(error); }");
				out.println("    });");
				//out.println("}");
			}
			
			out.println("window.returnValue='OK'; await window.close(); }  triggerPrintAndWait();</script>");
		}
		else if(func_mode!= null && func_mode.equals("editlabelcancel")) {
			//String drug_code					= (String) hash.get( "drug_code" );
			String order_id					= (String) hash.get( "order_id" );
			String order_line_no			= (String) hash.get( "order_line_no" );
			beanObj.clearEditLabel((order_id+"_"+order_line_no).trim());
		
		}//code ended.....
		else if(func_mode!= null && func_mode.equals("clearRemarks")) {
			String recno					= (String) hash.get( "recno" );
			String order_id					= (String) hash.get( "order_id" );
			String order_line_no			= (String) hash.get( "order_line_no" );
			beanObj.clearRemarks(recno);
			beanObj.clearHold(order_id,order_line_no);
		}
		else if(func_mode!= null && func_mode.equals("amendReason")) {  // added for Amend Prescription...on 5/2/2004
			String reason					= (String) hash.get( "reason" );
			String remarks					= (String) hash.get( "remarks" );
			String order_line_no			= (String) hash.get( "order_line_no" );
			String order_id					= (String) hash.get( "order_id" );
			//String drug_code				= (String) hash.get( "drug_code" );
			String patient_id				= (String) hash.get( "patient_id" );
			String encounter_id				= (String) hash.get( "encounter_id" );
			String chk						= ((String) hash.get( "chk" )).trim();

			String bean_id_2				= "@PrescriptionBean_1"+patient_id+encounter_id;
			String bean_name_2				= "ePH.PrescriptionBean_1";

			PrescriptionBean_1 bean_A		= (PrescriptionBean_1)getBeanObject( bean_id_2, bean_name_2, request );
			bean_A.setLanguageId(locale);
			
			ArrayList reason_val	= new ArrayList();
			reason_val.add(order_id);
			reason_val.add(reason);
			reason_val.add(remarks);
			
			if(chk.equals("O")){
				bean_A.clearAmendReason(order_id);
				bean_A.setAmendReason(order_id,reason_val);	
				bean_A.setAmendReasonTemp(order_id,reason_val);/* code Added for ML-BRU-SCF-0098 [IN031837] -- Start*/	
				String bean_id_1		= "@IVPrescriptionBean"+patient_id+encounter_id;
				String bean_name_1		= "ePH.IVPrescriptionBean";			
				IVPrescriptionBean bean_1	= (IVPrescriptionBean)getBeanObject(bean_id_1,bean_name_1,request);
				bean_1.setAmendReasonTemp(order_id,reason_val);//IN066779
				bean_1.setLanguageId(locale);
				bean_1.setObject(bean_A);
				putObjectInBean(bean_id_1,bean_1,request);	
					
				String bean_id_3			= "@OncologyRegimenBean"+patient_id+encounter_id;
				String bean_name_3		= "ePH.OncologyRegimenBean";
				OncologyRegimenBean bean_3= (OncologyRegimenBean)getBeanObject( bean_id_3, bean_name_3, request ) ;		
				bean_3.setLanguageId(locale);
				bean_3.setObject(bean_A);
				putObjectInBean(bean_id_3,bean_3,request);	/* code Added for ML-BRU-SCF-0098 [IN031837] -- End*/	
				String	bean_id_4					=	"DispMedicationBean" ;/* code Added for ML-BRU-SCF-0190[32621] -- Start*/	
				String	bean_name_4					=	"ePH.DispMedicationBean";
				DispMedicationBean bean_4		= (DispMedicationBean)getBeanObject( bean_id_4, bean_name_4, request);
				bean_4.setLanguageId(locale);
				String disp_locn_catg	=	bean_4.getDispLocnCatg();
				bean_A.setDispLocnCatg(disp_locn_catg);
				bean_A.setOrderLineNumber(order_line_no);/* code Added for ML-BRU-SCF-0190[32621] -- End*/
			}
			putObjectInBean(bean_id_2,bean_A,request);	
		}
		else if(func_mode!= null && func_mode.equals("cancelAmendReason")) {  
			//String reason					= (String) hash.get( "reason" );
			//String remarks					= (String) hash.get( "remarks" );
			String order_line_no			= (String) hash.get( "order_line_no" );
			String order_id					= (String) hash.get( "order_id" );
			//String drug_code				= (String) hash.get( "drug_code" );
			String patient_id				= (String) hash.get( "patient_id" );
			String encounter_id				= (String) hash.get( "encounter_id" );
			String chk						= ((String) hash.get( "chk" )).trim();
			String bean_id_2				= "@PrescriptionBean_1"+patient_id+encounter_id;
			String bean_name_2				= "ePH.PrescriptionBean_1";
			PrescriptionBean_1 bean_A		= (PrescriptionBean_1)getBeanObject( bean_id_2, bean_name_2,request );
			bean_A.setLanguageId(locale);
			ArrayList reason_val	= new ArrayList();
			reason_val.add("");
			reason_val.add("");
			reason_val.add("");
			if(chk.equals("O"))	{
				bean_A.clearAmendReason(order_id);
				bean_A.setAmendReason(order_id,reason_val);
			}
			putObjectInBean(bean_id_2,bean_A,request);
		}
		else if(func_mode!= null && func_mode.equals("clearBeanValues")){
			beanObj.clear();
			String	bean_id_3		=	"batchSearchBean" ;
			String	bean_name_3		=	"eST.BatchSearchBean";
			BatchSearchBean bean_3	= (BatchSearchBean)getBeanObject( bean_id_3, bean_name_3, request);
			bean_3.setLanguageId(locale);
			bean_3.clear();
			beanObj.clearHoldvaluesOnRefresh();
		}
		else if(func_mode!= null && func_mode.equals("clearPrescription")){	
			String patient_id		= (String) hash.get( "patient_id" );
			String order_id			= (String) hash.get( "order_id" );
			String	bean_id_1			=	"DispMedicationBean" ;
	        String	bean_name_1			=	"ePH.DispMedicationBean";
	        DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
			beanObj.clearPrescription(patient_id,bean_1.getOrderID());
			String	bean_id_3		=	"batchSearchBean" ;
			String	bean_name_3		=	"eST.BatchSearchBean";
			BatchSearchBean bean_3	= (BatchSearchBean)getBeanObject( bean_id_3, bean_name_3, request);
			bean_3.clear();
			beanObj.addPrescription(patient_id,order_id);
		}
		else if(func_mode!= null && func_mode.equals("clearOnRefresh")){
			String	bean_id_1			=	"DispMedicationBean" ;
	        String	bean_name_1			=	"ePH.DispMedicationBean";
	        DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
			bean_1.setLanguageId(locale);
			bean_1.setPatientID("");
			bean_1.clearonrefresh();
			bean_1.getStockDtl().clear();//Added for KDAH-CRF-0231 [IN-034551].
			bean_1.getTempStockDtls().clear();//Added for KDAH-CRF-0231 [IN-034551]
			beanObj.clearHoldvaluesOnRefresh();
			putObjectInBean(bean_id_1,bean_1,request);
		}
		else if(func_mode!= null && func_mode.equals("storeFill")) {
			String patient_id		= (String) hash.get( "patient_id" );
			String order_id			= (String) hash.get( "order_id" );
			//Added for KDAH-CRF-0231 [IN-034551] - Start
			String alloc_tot_qty	 = (String)hash.get("alloc_tot_qty");
			String bms_tot_qty	 = (String)hash.get("bms_tot_qty");
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject("DispMedicationBean", "ePH.DispMedicationBean", request);
			if((beanObj_1.getDispStage().equals("F")&&(beanObj_1.getDispLocnCatg().equals("O")))|| beanObj_1.getFillList().equals("AF")){ 
				beanObj_1.setValuesChanged(true);
			}
			beanObj.setFilling(patient_id,order_id);
			ArrayList temp_alloc_drug_detail=null;
			//Added for KDAH-CRF-0231 [IN-034551].
			ArrayList batch_list1=new ArrayList();
			String order_line_no="";
			double quantity=1.0;
			String batch_id="";
			String item_drug_code="";
			//Added for KDAH-CRF-0231 [IN-034551].
			if(!beanObj_1.getStockDtl().containsKey("autoalloc")){
			      Iterator batch_val=beanObj_1.getBatch_val().iterator();
			      while(batch_val.hasNext()){
				     ArrayList batch_list=(ArrayList)batch_val.next();
				     HashMap batch_map=(HashMap)batch_list.get(0);
				     String item_cost="";
				     String qty_uom="";
				     item_drug_code		=	(String)batch_map.get("ITEM_CODE");	
				     String expiry_date			=	(String)batch_map.get("EXPIRY_DATE");	
				     batch_id			=	(String)batch_map.get("BATCH_ID");	
				     String trade_id			=	(String)batch_map.get("TRADE_ID");	
				     String trade_name			=	(String)batch_map.get("TRADE_NAME");	
				     String bin_locn_code		=	(String)batch_map.get("BIN_LOCATION_CODE");
				     HashMap temp_batch_map=beanObj_1.getTempStockDtls();
				     if(temp_batch_map.containsKey(item_drug_code+"~"+batch_id)){
						//Added for KDAH-CRF-0231 [IN-034551].
						if(!beanObj_1.getStockDtl().containsKey("allocated"+item_drug_code+batch_id)){
							batch_list1.add(batch_list);
						}
						//Added for KDAH-CRF-0231 [IN-034551].
						beanObj_1.setStockDtlKey("barcode_applicable"+item_drug_code,"N");
						String temp_batch=temp_batch_map.get(item_drug_code+"~"+batch_id).toString();
						String[] batch_str=temp_batch.split("~");
						order_id=batch_str[0];
						order_line_no=batch_str[1];
						if(beanObj_1.getStockDtl().containsKey(item_drug_code+"qty")){
							quantity=Double.parseDouble(beanObj_1.getStockDtl().get(item_drug_code+"qty").toString());//Added for KDAH-CRF-0231 [IN-034551]
						}
						else{
							quantity=Double.parseDouble(batch_str[2].toString());
						}
						item_cost=batch_str[3];
						qty_uom=batch_str[4];
						temp_alloc_drug_detail=new ArrayList();
						temp_alloc_drug_detail.add(item_drug_code);
						temp_alloc_drug_detail.add(batch_id);
						temp_alloc_drug_detail.add(expiry_date);
						temp_alloc_drug_detail.add((int)(quantity)+"");
						temp_alloc_drug_detail.add(qty_uom);
						temp_alloc_drug_detail.add("");
						temp_alloc_drug_detail.add(trade_id);
						temp_alloc_drug_detail.add(bin_locn_code);
						temp_alloc_drug_detail.add(item_cost);
						temp_alloc_drug_detail.add(batch_str[5]);//qty_uom is changed as batch_str[5] for [IN:049778]
					}
				     beanObj_1.getStockDtl().remove("batchqty"+item_drug_code+batch_id);//Added for KDAH-CRF-0231 [IN-034551]
				}  //Added for KDAH-CRF-0231 [IN-034551].
				beanObj.setDrugDetail(patient_id,order_id,order_line_no,temp_alloc_drug_detail);
				beanObj.setDrugQuantity(patient_id,order_id,order_line_no,quantity);
					if(!(beanObj_1.getStockDtl().containsKey("allocated"+item_drug_code+batch_id) && beanObj_1.getStockDtl().get("allocated"+item_drug_code+batch_id).equals(item_drug_code))){
					Iterator batch_val1=batch_list1.iterator();
					while (batch_val1.hasNext()){
						ArrayList batch_temp=(ArrayList)batch_val1.next();							  
						if(beanObj_1.getBatch_val().contains(batch_temp)){
							beanObj_1.getBatch_val().remove(batch_temp);
						}
					}
				} //Added for KDAH-CRF-0231 [IN-034551].
				beanObj_1.getBatch_val().clear();//Added for KDAH-CRF-0231 [IN-034551]
			}
			else{
			    beanObj_1.getStockDtl().remove("autoalloc");
			}
			//Added for KDAH-CRF-0231 [IN-034551].
		}
		else if(func_mode!= null && func_mode.equals("clearDrugDet")) {
			String patient_id		= (String) hash.get( "patient_id" );
			String drug_code		= (String) hash.get( "drug_code" );
			String order_id			= (String) hash.get( "order_id" );
			String order_line_no	= (String) hash.get("order_line_no");
			beanObj.clearDrugDet(patient_id,order_id,order_line_no);
			out.println("refreshWindow('"+patient_id+"','"+order_id+"','"+drug_code+"','"+order_line_no+"')");
		}
		else if(func_mode!= null && func_mode.equals("storeMulti")){
			String tot_record	= (String) hash.get("tot_record");
			String order_line_no	= (String) hash.get("order_line_no");
			String patient_id	= (String) hash.get("patient_id");
			String order_id		= (String) hash.get("order_id");
			String drug_code		= (String) hash.get("drug_code");
			String alt_drug_remarks_ind		= (String) hash.get("alt_drug_remarks_ind");
			String source = CommonBean.checkForNull(request.getParameter("source"));//Added for Bru-HIMS-CRF-399 [IN:043767]
			StringBuilder sb = new StringBuilder();		//Added for Bru-HIMS-CRF-072.1[IN 049144]
			int recs		 =	Integer.parseInt(tot_record);
			ArrayList record_details	=	new ArrayList();
			String	tmp_alt_drug_code		=	null;
			String	alt_drug_code		=	null;
			String	alt_drug_desc		=	null;
			String	form_code			=	null;
			String	strength_value		=	null;
			String	strength_uom		=	null;			                             
			String	select				=	null;
			HashMap pack_dtls			=	null;
			int count					=	0;
			if(hash.containsKey("alt_drug_code0")){
				for(int i=0; i<=recs; i++)	{
					select				= (String) hash.get("select"+i)==null?"":(String) hash.get("select"+i);
					if(select.equals("Y")){
						alt_drug_code		= (String) hash.get("alt_drug_code"+i);
						alt_drug_desc		= (String) hash.get("alt_drug_desc"+i);
						form_code			= (String) hash.get("form_code"+i);
						strength_value		= (String) hash.get("strength_value"+i);
						strength_uom		= (String) hash.get("strength_uom"+i);
						pack_dtls			=	beanObj.getPackSize(alt_drug_code);

						if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
							form_code	=	(String)pack_dtls.get("STOCK_UOM");
						}

						tmp_alt_drug_code = alt_drug_code;
						record_details.add(alt_drug_code);
						record_details.add(java.net.URLDecoder.decode(alt_drug_desc,"UTF-8"));
						record_details.add(form_code);
						record_details.add(strength_value);
						record_details.add(strength_uom);
						count++;
						sb.append("'"+alt_drug_code+"',");	//Added for Bru-HIMS-CRF-072.1[IN 049144]
						/*if(count>3){
							out.println("CheckAltDrugCount('Y')");
							break;
						}*/
					}
				}
			}
			if(count==0){ //Added For Bru-HIMS-CRF-082 [IN:029948]
				beanObj.removeAltDrugRemarks(order_id+"~"+order_line_no);
			}
			if(drug_code.equals(tmp_alt_drug_code) && count==1){
				out.println("CheckAltDrugCount('SameDrug','"+count+"','"+order_id+"','"+order_line_no+"','"+alt_drug_remarks_ind+"','','','')");								
			}
			else if(source.equals("MAR") && record_details.size()>5){// else if Added for Bru-HIMS-CRF-399 [IN:043767]
				out.println("CheckAltDrugCount('Y','"+count+"','"+order_id+"','"+order_line_no+"','"+alt_drug_remarks_ind+"','"+source+"','','');");	
			}
			else if(record_details.size()>15){
				out.println("CheckAltDrugCount('Y','"+count+"','"+order_id+"','"+order_line_no+"','"+alt_drug_remarks_ind+"','','','');");								
			}
			else{
				if(source.equals("MAR") && record_details.size()>0){//if else Added for Bru-HIMS-CRF-399 [IN:043767]
					alt_drug_code = (String)record_details.get(0);
					alt_drug_desc = (String)record_details.get(1);
					//uncommented for regression issue on JUN MR18
					alt_drug_desc = alt_drug_desc.replaceAll(" ","%20"); //uncommented for regression issue on JUN MR18
					alt_drug_desc = java.net.URLEncoder.encode(alt_drug_desc,"UTF-8" );
					alt_drug_desc = alt_drug_desc.replaceAll("%2520","%20");
					out.println("CheckAltDrugCount('N','"+count+"','"+order_id+"','"+order_line_no+"','"+alt_drug_remarks_ind+"','"+source+"','"+alt_drug_code+"','"+alt_drug_desc+"');");
				}		
				else
					out.println("CheckAltDrugCount('N','"+count+"','"+order_id+"','"+order_line_no+"','"+alt_drug_remarks_ind+"','','','');");
				beanObj.setMultiDrugs(patient_id,order_id,order_line_no,record_details);
				beanObj.checkAlternateDetail(patient_id,order_id,order_line_no);
				if(!source.equals("MAR")){//if Added for Bru-HIMS-CRF-399 [IN:043767]
					MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request);
					if(medplan_bean.getStrCalledFrom().equals("Dispensing") && sb.length()>3){//Added for Bru-HIMS-CRF-072.1[IN 049144]
						medplan_bean.getPrescribeDrugDetails(sb);
					}
					HashMap hshmedplan = medplan_bean.getMedPlan_DrugDetails();
					HashMap hshTemp = new HashMap();
					List <String> arrTemp= new ArrayList<String>();
					Set <String> hshKeys = new HashSet<String>();
					hshKeys = hshmedplan.keySet();
					if(hshKeys!=null && hshKeys.size()>0){
						for(String key:hshKeys){
							hshTemp = (HashMap)hshmedplan.get(key);
							if(((String)hshTemp.get("order_id")).equals(order_id) && ((String)hshTemp.get("order_line_no")).equals(order_line_no))
								arrTemp.add(key);
						}
					}
					hshmedplan =  medplan_bean.getMedPlan_Local_DrugDetails();
					hshKeys = hshmedplan.keySet();
					if(hshKeys!=null && hshKeys.size()>0){
						for(String key:hshKeys){
							hshTemp = (HashMap)hshmedplan.get(key);
							if(((String)hshTemp.get("order_id")).equals(order_id) && ((String)hshTemp.get("order_line_no")).equals(order_line_no))
								arrTemp.add(key);
						}
					}
					for(String temp: arrTemp){
						medplan_bean.getMedPlan_DrugDetails().remove(temp);
						medplan_bean.getMedPlan_Local_DrugDetails().remove(temp);
					}
				}	
			}
			//objects nullified after usage
			record_details	=	null;
		}
		else if(func_mode!= null && func_mode.equals("storeBatch")){
			String patient_id		= (String) hash.get("patient_id");
			String order_id			= (String) hash.get("order_id");
			String order_line_no	= (String) hash.get("order_line_no");
			String drug_code		= (String) hash.get("drug_code");
			String alt_drug_code	= (String) hash.get("alt_drug_code");
			String totalRecords		= (String) hash.get("totalRecords");
			String source			= (String) hash.get("source");
			if(source==null)source	=	"";

			int tot_recs			= Integer.parseInt(totalRecords);
			String tmp_drug_code	= "";

			if(alt_drug_code.equals(""))
				tmp_drug_code		=	drug_code;	
			else
				tmp_drug_code		=	alt_drug_code;	

			ArrayList drug_detail	=	new ArrayList();
			int qty					=	0;
			String	item_drug_code		=	null;
			String	item_drug_color		=	null;
			String	batch_id			=	null;
			String	expiry_date			=	null;
			String	issue_qty			=	null;	
			String	qty_uom				=	null;

			for(int i=0; i<tot_recs; i++)	{
				item_drug_code		=	(String) hash.get("item_drug_code"+i);
				item_drug_color		=	(String) hash.get("item_drug_color"+i);
				batch_id			=	(String) hash.get("batch_id"+i);
				expiry_date			=	(String) hash.get("expiry_date"+i);
				issue_qty			=	(String) hash.get("issue_qty"+i);
				qty_uom				=	(String) hash.get("qty_uom"+i);
				if(tmp_drug_code.equals(item_drug_code))	{
					if(qty_uom==null)		
						qty_uom		=	"";
					if(!batch_id.equals("") && !issue_qty.equals(""))	{
						drug_detail.add(item_drug_code);
						drug_detail.add(batch_id);
						drug_detail.add(expiry_date);
						drug_detail.add(issue_qty);
						drug_detail.add(qty_uom);
						drug_detail.add(item_drug_color);
						drug_detail.add("");//trade_id
						drug_detail.add("");//bin_locn_code
						drug_detail.add("");//item_cost
						drug_detail.add(qty_uom);
						qty  +=	Integer.parseInt(issue_qty);
					}
				}
			}

			if(drug_detail.size() >= 1)	{
				if(alt_drug_code.equals("")) {
					beanObj.setDrugDetail(patient_id,order_id,order_line_no,drug_detail);
					beanObj.setDrugQuantity(patient_id,order_id,order_line_no,qty);
				}
				else	{
					beanObj.setAlternateDrugDetail(patient_id,order_id,order_line_no,drug_detail,alt_drug_code);
				}

				out.println("refreshWindow('"+patient_id+"','"+order_id+"','','"+order_line_no+"','"+source+"')");
			}

			// objects nullified after usage	
			drug_detail	=	null;
		}
		 
		else if(func_mode!= null && func_mode.equals("print_reqd")){			
			String	bean_id_1			=	(String) hash.get("bean_id_1");
			String	bean_name_1			=	(String) hash.get("bean_name_1");
			String	order_id			=	(String) hash.get("order_id");
			String	patient_id			=	(String) hash.get("patient_id");
			String	locn_code			=	(String) hash.get("source_code");
			String	disp_level			=	(String) hash.get("disp_level");
			String  tot_rec				=	(String) hash.get("tot_rec");
			String  complete_order_flag	=	(String) hash.get("complete_order_flag");		
			ArrayList	order_ids		=	null;
			HashMap	hmDispNos			=	null;
			HashMap	hmPrintLineStore	=	null;
			String disp_no				=	null;
			ArrayList disp_nos			=	null;
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1, request);
			beanObj_1.setLanguageId(locale);
			String disp_locn			=	beanObj_1.getDispLocnCode();
			String patient_class		=	beanObj_1.getDispLocnCatg();
			String curr_stage			=	beanObj_1.getDispStage();
			String iv_prep_yn			=	beanObj_1.getIvprepynFrManufacture(order_id)==null?"":beanObj_1.getIvprepynFrManufacture(order_id);
			//iv_prep_yn = beanObj_1.getIvprepynFrManufacture(order_id);
			//if(iv_prep_yn == null) iv_prep_yn="";

			if(disp_level.equals("P")) {
				order_ids		=	new ArrayList();
				for(int i=1; i<Integer.parseInt(tot_rec); i++) {
					//out.println("alert(\"" + (String)hash.get("del_detail"+i) + "\");") ;
					if(hash.containsKey("del_detail"+i) && ((String)hash.get("del_detail"+i)).equals("Y")) {
						order_ids.add((String) hash.get("order_id"+i));
					} 
					else if(curr_stage.equals("F") || curr_stage.equals("A")) {
						order_ids.add((String) hash.get("order_id"+i));
					}
				}
				hmDispNos		=	beanObj.getDispenseNumbers(beanObj_1.getPrintSeqNo(),disp_level);
			}
			else {
				order_ids		=	new ArrayList();
				order_ids.add(order_id);
				hmDispNos		=	beanObj.getDispenseNumbers(beanObj_1.getPrintSeqNo(),disp_level);
			}
			if(disp_level.equals("P")){
				disp_nos		=	(ArrayList)hmDispNos.get("disp_no");
				beanObj.setDispNos(disp_nos);
			} 
			else 
				disp_no			=	(String)hmDispNos.get("disp_no");
			if(disp_no==null)	
				disp_no	=	"";
			String login_user		=	(String)session.getValue("login_user");
			String facility_id		=	(String)session.getValue("facility_id");
			if( curr_stage.equals("D") || curr_stage.equals("AS")) 	{
			out.println("showPrintDialog('O','"+disp_no+"','"+login_user+"','"+facility_id+"','"+patient_id+"','"+locn_code+"','"+patient_class+"','"+curr_stage+"','"+complete_order_flag+"','"+beanObj_1.getBILLING_DET()+"','"+beanObj_1.getBLDocSrlNo()+"','"+disp_locn+"','"+beanObj_1.getOrderingFacility()+"')"); //beanObj_1.getBLDocSrlNo() Added for  [IN:043100] //disp_locn added for [IN:046496]-Billing beanObj_1.getOrderingFacility() added for MOHE-CRF-0060
			} 
			else if(curr_stage.equals("F") || curr_stage.equals("A")) {
				out.println("showPrintDialog('F','"+disp_no+"','"+login_user+"','"+facility_id+"','"+patient_id+"','"+locn_code+"','"+patient_class+"','"+curr_stage+"','"+complete_order_flag+"','"+disp_locn+"')"); // disp_locn added for [IN:046496]-Billing
			}
			// objects nullified after usage
			putObjectInBean(bean_id_1,beanObj_1,request);
			hmDispNos = null;
		} 
		else if(func_mode.equals("orOrder")){
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject("DispMedicationBean", "ePH.DispMedicationBean", request);
			beanObj_1.setLanguageId(locale);
			String	order_id				=	(String) hash.get("order_id");

			if(order_id==null || order_id.trim().equals("")){
				ArrayList alBMSOrderIds = beanObj_1.getAlBMSOrderIds();

				if(alBMSOrderIds.size()>0){
					beanObj.updateNextCollDateInFillAllocate(alBMSOrderIds,(String) hash.get("next_collection_date"), (String) hash.get("bmsReasonCode"));
				}
			}
			else{
				String	order_line_no			=	(String) hash.get("order_line_no");				
				String	disp_no					=	(String) hash.get("disp_no");
				String	srl_no					=	(String) hash.get("srl_no");
				String	next_collection_date	=	(String) hash.get("next_collection_date");
				String	bmsReasonCode	=	(String) hash.get("bmsReasonCode");
				String	referral_facility		="";
				String	referral_remarks		="";
				String	practioner_id			="";
				String	disp_location			="";

				String	flag					=	(String) hash.get("flag");
				String curr_stage				=	(String) hash.get("curr_stage");
				if(flag.equals("E")){	
					referral_facility	=	(String) hash.get("referral_facility");
					referral_remarks	=	(String) hash.get("referral_remarks");
					practioner_id		=	(String) hash.get("practioner_id");
				}
				else if(flag.equals("C")){				
					disp_location		=	(String) hash.get("disp_location");
				}

				HashMap values	= new HashMap();
				values.put("order_id" , order_id);
				values.put("order_line_no" , order_line_no);							
				values.put("disp_no" , disp_no);
				values.put("srl_no" , srl_no);
				values.put("next_collection_date" , next_collection_date);
				values.put("bmsReasonCode" , bmsReasonCode);
				values.put("flag" , flag);
				values.put("curr_stage",curr_stage);

				if(flag.equals("E")){
					values.put("referral_facility" , referral_facility);				
					values.put("referral_remarks" , referral_remarks);
					values.put("practioner_id" , practioner_id);		 
				}
				else if(flag.equals("C")){
					values.put("ReRtdDispLocnCode" , disp_location);
				}
				HashMap result = beanObj.callinsertNextCollDate(values);
				beanObj.setIR_FLAG_VALUE(new HashMap());
			}
		} 
		else if(func_mode.equals("print_dispense")){

			String sDispBeanId		=	(String) hash.get("bean_id_1");
			String sDispBeanName	=	(String) hash.get("bean_name_1");

			String order_type		=	"";
			String  curr_stage		=	"";
			String sDispLocnCode	=	"";
			DispMedicationBean dispBean = (DispMedicationBean)getBeanObject( sDispBeanId,  sDispBeanName, request ) ;
			 String print_seq_no			=	dispBean.getPrintSeqNo();
			if(dispBean!=null){
				order_type			=	dispBean.getOrderType();
				curr_stage			=	dispBean.getDispStage();
				sDispLocnCode		=	dispBean.getDispLocnCode();
			}
			else{
				order_type			=	(String) hash.get("order_type");
				curr_stage			=	(String) hash.get("curr_stage");
			}
			String	login_user		=	(String) hash.get("login_user");
			String	facility_id		=	(String) hash.get("facility_id");
			String	disp_no			=	(String) hash.get("disp_no");
			String	patient_id		=	(String) hash.get("patient_id");
			String	locn_code		=	(String) hash.get("locn_code");
			String	patient_class	=	(String) hash.get("patient_class");
			String	print_opt		=	(String) hash.get("print_opt");
			String	print_opt_MP		=	(String) hash.get("print_opt_MP")==null?"":(String) hash.get("print_opt_MP");
			String  printInclude	=	hash.get("printInclude")	==null?""	:	hash.get("printInclude").toString(); //added for RUT-CRF-0061 [IN:029599] - start
			String  printSeparate	=	hash.get("printSeparate")	==null?""	:	hash.get("printSeparate").toString(); 
			String 	printOnly		=	hash.get("printOnly")		==null?""	:	hash.get("printOnly").toString();
			String 	printTaper		=	hash.get("printTaper")		==null?""	:	hash.get("printTaper").toString();
			String 	print_Type		=	hash.get("print_Type")		==null?""	:	hash.get("print_Type").toString(); //Added for RUT-CRF-0061 [IN:029599] -end
			String 	printRefill		=	hash.get("printRefill")		==null?""	:	hash.get("printRefill").toString(); //Added for MOHE-CRF-0069
			String  dflt_lang_for_disp_label = (String) hash.get("select_loc_lang");
			String bms_sel_lang			= (String) hash.get("bms_sel_lang");  //newly added for CRF-074 by manickam
			String print_extr_pres	=	(String) hash.get("print_extr_pres");
			String language_id		=   (String)session.getAttribute("LOCALE");
			String	work_sheet_id		= "";//added for ML-MMOH-CRF-1089
			String bean_id_1		=	"";
			String bean_name_1	    =	"";
			String AdmixtureType    =	"";
			String sysdate			=   "";
			boolean medical_supp_label_printed = false;
		//added for ML-MMOH-CRF-1089 start
    	ArrayList duration_values   = new ArrayList();
			String duration_value		= "";
			String ord_type				= "";
      //added for ML-MMOH-CRF-1089 end
			String repeat_value_1			= "";
			String refill_orders ="";

			//String sm_local_language_id     = beanObj.getSMLOcalLanguageID(); // commented for MMS-QH-CRF-0069 [IN:037977]
			if(dflt_lang_for_disp_label==null || dflt_lang_for_disp_label.equals(""))//Added for MMS-QH-CRF-0069 [IN:037977]
				dflt_lang_for_disp_label = "en";
			String sm_local_language_id     = dflt_lang_for_disp_label; //Added for MMS-QH-CRF-0069 [IN:037977]
			
			/*if(!locale.equals("en") && dflt_lang_for_disp_label.equals("L")){// Code Override For FD-Bru-HIMS-CRF-074 & FD-Bru-HIMS-CRF-075
				sm_local_language_id = language_id;
			}*/

			//Added for AAKH-SCF-0007 [IN37357]
			if(sm_local_language_id == null || sm_local_language_id.equals("")){
			    sm_local_language_id= "en";
			}
			//Added for AAKH-SCF-0007 [IN37357]
			boolean bLabelAvailable	= false;

			if(print_opt != null && (print_opt.equals("A")||print_opt.contains("L")))
				bLabelAvailable		= true;

			locn_code = locn_code != null?locn_code.trim():"";
			DispMedicationBean beanObj_1	=	null;

			if( hash.get("bean_id_1")==null) {
				bean_id_1	=	"";
				bean_name_1	=	"";
			}
			else {
				bean_id_1	=	(String) hash.get("bean_id_1");
				bean_name_1	=	(String) hash.get("bean_name_1");
			}
			if(!bean_id_1.equals("")) {
				beanObj_1	=	(DispMedicationBean)getBeanObject(bean_id_1,bean_name_1,request);
				beanObj_1.setLanguageId(locale);
				AdmixtureType    =   beanObj_1. getAdmixtureType();	
				putObjectInBean(bean_id_1,beanObj_1,request);
			}
			sysdate			= beanObj_1.getTodaysDate();
			//ADDED FOR ML-MMOH-CRF-1089 STRART
			if(curr_stage.equals("D") && siteTpnStd && dispBean.getWsType().equals("7") ){
				work_sheet_id=beanObj_1.getwORKsHEETIdSTD(beanObj_1.getOrderID());
			}
			//ADDED FOR ML-MMOH-CRF-1089 END

			ArrayList print_reports	=	new ArrayList();
			String sPrintOthers[];
			ArrayList alPrintOthers = new ArrayList();
			boolean bMedicalSupplyAvail = false;
			if( hash.get("printOthers") != null && !hash.get("printOthers").toString().equals("")){
				sPrintOthers = hash.get("printOthers").toString().split("~");
				alPrintOthers = new ArrayList(Arrays.asList(sPrintOthers)); 
				if(alPrintOthers != null && alPrintOthers.size()>0){
					if(alPrintOthers.contains("CR"))
						print_reports.add("PHCERTREIM");
					if(alPrintOthers.contains("MSL")) // Medical Supply Label
						bMedicalSupplyAvail = true;
					if(alPrintOthers.contains("ML"))
						print_reports.add("PHMEDLIST");
					if(alPrintOthers.contains("HMS"))
						print_reports.add("PHHOMMED");
					if(alPrintOthers.contains("RFMS"))
						print_reports.add("PHPRRELMS");
					//added for ML-MMOH-CRF-1089 START
					if(curr_stage.equals("D") && siteTpnStd && dispBean.getWsType().equals("7") ){
					if(alPrintOthers.contains("MFGL"))
						print_reports.add("PHTPNDISPLBF");
					if(alPrintOthers.contains("WS"))
						print_reports.add("PHBRWRKTP");
					if(alPrintOthers.contains("COB"))
						print_reports.add("PHTPNSCOB");
					if(alPrintOthers.contains("LIP"))
						print_reports.add("PHTPNLIP");
					if(alPrintOthers.contains("TPNDS"))
						print_reports.add("PHRDISSHTPNSTD");  //ADDED for ML-ML-MMOH-CRF-2042 US002
					}
					//added for ML-MMOH-CRF-1089 END
				
									}
			}
						if(curr_stage==null)	
				curr_stage			=	"";
			ArrayList disp_nos		=	null;

			if(disp_no.equals(""))
				disp_nos	=	beanObj.getDispNos();
			System.out.println("1290disp_nos"+disp_nos);
			String ReportOutput		=	"";
			String	report_id		=	"";
			ArrayList disp_stage	= beanObj_1.getDispMedStages();//added for SKR-SCF-0611 [IN:034816] . Getting Disp Stages.
			String delivery_applicable = beanObj_1.getDeliveryApplicable();//added for SKR-SCF-0611 [IN:034816 
			if(patient_class.equals("I"))
				patient_class	=	"IP";
			else if(patient_class.equals("O"))
				patient_class	=	"OP";
			if (disp_stage.get(disp_stage.size()-1).equals(curr_stage) && !delivery_applicable.equals("Y"))	 //if block added for SKR-SCF-0611 [IN:034816 
				curr_stage = "D";
			//if(((curr_stage.equals("F") || curr_stage.equals("A") ) && (!disp_stage.get(disp_stage.size()-1).equals(curr_stage) && delivery_applicable.equals("Y"))) || alPrintOthers.contains("MSL")) {	 //&& (!disp_stage.get(disp_stage.size()-1).equals(curr_stage) && delivery_applicable.equals("Y")) added for SKR-SCF-0611 [IN:034816 
System.err.println("curr_stage======>"+curr_stage+"===alPrintOthers=====>"+alPrintOthers);
			if(curr_stage.equals("F") || curr_stage.equals("A") || alPrintOthers.contains("MSL")) {	
				if(order_type.equals("NOR")) {	
					if(print_opt.equals("DL")) {
						print_reports.add("PHPRDISSHFILL");
						print_reports.add("PHPRDISLBFILL");	
					}
					else if(print_opt.equals("D")) {
						print_reports.add("PHPRDISSHFILL");
					} 
					else if(print_opt.equals("L") || alPrintOthers.contains("MSL")) {
						print_reports.add("PHPRDISLBFILL");	
					}						
					else if (print_opt.equals("A")){
						print_reports.add("PHPRDISSHFILL");
						print_reports.add("PHPRDISLBFILL");	
						print_reports.add("PHPRBALMS");	
					//	print_reports.add("PHPRMEDPL");	//Added For ML-BRU-CRF-072[Inc:29938]
					}
					//Added Code for DispenseSheet,Balance Medicationsheet,Dispense label Reports on 16/Sept/2010
					else if (print_opt.equals("DB")){
						print_reports.add("PHPRDISSHFILL");
						print_reports.add("PHPRBALMS");	
					}
					else if (print_opt.equals("BL")){
						print_reports.add("PHPRDISLBFILL");
						print_reports.add("PHPRBALMS");	
					}
					else if (print_opt.equals("B"))	{
						print_reports.add("PHPRBALMS");	
					}  //Ends---16/sept/2010
					/*if (print_opt_MP.equals("M")){ // else if block Added For ML-BRU-CRF-072[Inc:29938]
						print_reports.add("PHPRMEDPL");
					} */ //commented for Bru-HIMS-CRF-072.1 [IN:049144]

					if(!print_reports.contains("PHPRDISLBFILL") && alPrintOthers.contains("MSL")){
						print_reports.add("PHPRDISLBFILL");	
					}
				}
				else if(order_type.equals("IVAD")||order_type.equals("IVAA")) {
					if(AdmixtureType.equals("I")||AdmixtureType.equals("C")){
						if(print_opt.equals("DL")) {
							print_reports.add("PHBRWRKSH");
							print_reports.add("PHBRMFGLB");
						}
						else if(print_opt.equals("D")) {
							print_reports.add("PHBRWRKSH");
						} 
						else if(print_opt.equals("L")) {
							print_reports.add("PHBRMFGLB");
						}
					}
					else{
						if(print_opt.equals("DL")) {
							print_reports.add("PHPRDISSHCONFILL");
							print_reports.add("PHRIVCONTFILL");
						}
						else if(print_opt.equals("D")) {
							print_reports.add("PHPRDISSHCONFILL");
						} 
						else if(print_opt.equals("L")) {
							print_reports.add("PHRIVCONTFILL");
						}
						/*if(print_opt_MP.equals("M")) {// if block Added For ML-BRU-CRF-072[Inc:29938]
							print_reports.add("PHPRMEDPL");
						}*/ //commented for Bru-HIMS-CRF-072.1 [IN:049144]
					}
				} 
				else if(order_type.equals("IVWA")) {
					if(print_opt.equals("DL")) {
						print_reports.add("PHPRDISSHCONFILL");
						if(is_site_drug_label) //added for ARYU-CRF-0014 and ARYU-SCF-0134
							print_reports.add("PHRFILLCONWOADD");
						else
							print_reports.add("PHRIVCONTFILL");
					}
					else if(print_opt.equals("D")) {
						print_reports.add("PHPRDISSHCONFILL");
					} else if(print_opt.equals("L")) {
						if(is_site_drug_label) //added for ARYU-CRF-0014 and ARYU-SCF-0134
							print_reports.add("PHRFILLCONWOADD");
						else
							print_reports.add("PHRIVCONTFILL");  // PHRIVCONTFILL   changed to  PHRFILLCONWOADD for SKR-SCF-1107 [IN:057251] [IN:003916] [IN:057781]
						//added PHRIVCONTFILL for ARYU-SCF-0056 
					}
					/*if(print_opt_MP.equals("M")) {// if block Added For ML-BRU-CRF-072[Inc:29938]
						print_reports.add("PHPRMEDPL");
					}*/ //commented for Bru-HIMS-CRF-072.1 [IN:049144]
				} 
				else if(order_type.equals("IVIA")||order_type.equals("IVID")) {
					if(AdmixtureType.equals("I")||AdmixtureType.equals("C")){
						if(print_opt.equals("DL")) {
							print_reports.add("PHBRWRKSH");
							print_reports.add("PHBRMFGLB");
						}
						else if(print_opt.equals("D")) {
							print_reports.add("PHBRWRKSH");
						}
						else if(print_opt.equals("L")) {
							print_reports.add("PHBRMFGLB");
						}	
					}
					else{
						if(print_opt.equals("DL")) {
							print_reports.add("PHPRDISSHINTFILL");
							print_reports.add("PHRIVINTTFILL");
						}
						else if(print_opt.equals("D")) {
							print_reports.add("PHPRDISSHINTFILL");
						} 
						else if(print_opt.equals("L")) {
							print_reports.add("PHRIVINTTFILL");
						}
						/*if(print_opt_MP.equals("M")) {//Added For ML-BRU-CRF-072[Inc:29938]
							print_reports.add("PHPRMEDPL");
						}*/ //commented for Bru-HIMS-CRF-072.1 [IN:049144]
					}
				}
				else if(order_type.equals("CD")||order_type.equals("CA")) {
					  if(AdmixtureType.equals("I")||AdmixtureType.equals("C")){
						  if(print_opt.equals("DL")) {
							print_reports.add("PHBRWRKSH");
							print_reports.add("PHBRMFGLB");
						  }
						  else if(print_opt.equals("D")) {
							print_reports.add("PHBRWRKSH");
						  } 
						  else if(print_opt.equals("L")) {
							print_reports.add("PHBRMFGLB");
						  }	
					  }
					  else{
						if(print_opt.equals("DL")) {
							print_reports.add("PHCYTODISSHFL");
							print_reports.add("PHRCYTOLBFILL");
						}
						else if(print_opt.equals("D")) {
							print_reports.add("PHCYTODISSHFL");
						} 
						else if(print_opt.equals("L")) {
							print_reports.add("PHRCYTOLBFILL");
						}
					}
				}
				else if(order_type.equals("TD")) {	
					if(print_opt.equals("DL")) {
						print_reports.add("PHRDISSHTPNFILL");
						print_reports.add("PHRTPNDISPLBFILL");
					}
					else if(print_opt.equals("D")) {
						print_reports.add("PHRDISSHTPNFILL");
					} 
					else if(print_opt.equals("L")) {
						print_reports.add("PHRTPNDISPLBFILL");
					}							
				}
			} 
			else {System.err.println(print_opt+"print_opt++++++++++++++++curr_stage======>"+curr_stage);
				/*if(print_opt_MP.equals("M")) {//Added For ML-BRU-CRF-072[Inc:29938]
					print_reports.add("PHPRMEDPL");
				}*/ //commented for Bru-HIMS-CRF-072.1 [IN:049144]
				if(print_opt.equals("A") ) {
					if(order_type.equals("NOR")  || alPrintOthers.contains("MSL") ) {
						print_reports.add("PHPRDISSH");
						print_reports.add("PHPRBALMS");	
						if(patient_class.equals("IP") )
							print_reports.add("PHPRDISLB_AL_IP");
						else if(patient_class.equals("OP") )
							print_reports.add("PHPRDISLB_AL_OP");
					}
					else if(order_type.equals("IVAA")||order_type.equals("IVAD")) {
						print_reports.add("PHPRDISSHIVCONT");
						print_reports.add("PHRIVCONT");		
						print_reports.add("PHPRBALMS");	//ADDED FOR ARYU-SCF-0118
						//print_reports.add("PHPRMEDPL"); //commented for Bru-HIMS-CRF-072.1 [IN:049144]
					} 
					else if(order_type.equals("IVWA")) {
						print_reports.add("PHPRDISSHIVCONT");
						print_reports.add("PHRIVCONTWOADD");		
						print_reports.add("PHPRBALMS");	//ADDED FOR ARYU-SCF-0118
						//print_reports.add("PHPRMEDPL"); //commented for Bru-HIMS-CRF-072.1 [IN:049144]
					}
					else if(order_type.equals("IVIA")||order_type.equals("IVID")) {
						print_reports.add("PHPRDISSHIVINTT");
						print_reports.add("PHRIVINTT");	
						print_reports.add("PHPRBALMS");	//ADDED FOR ARYU-SCF-0118
						//print_reports.add("PHPRMEDPL"); //commented for Bru-HIMS-CRF-072.1 [IN:049144]
					}
					else if(order_type.equals("CD")||order_type.equals("CA")) {
						print_reports.add("PHCYTODISSHDL");
						print_reports.add("PHRCYTOLBDEL");		
					}
					else if(order_type.equals("TD")) {
						print_reports.add("PHRTPNDISPLBDL");
						print_reports.add("PHRDISSHTPNDEL");				
					}
				}
				else if(print_opt.equals("DB")){
					if(order_type.equals("NOR")) {
						print_reports.add("PHPRDISSH");
						print_reports.add("PHPRBALMS");
					}
					else if(order_type.equals("IVAA")||order_type.equals("IVAD") || order_type.equals("IVWA")) {
						print_reports.add("PHPRDISSHIVCONT");							
					}
					else if(order_type.equals("IVIA")||order_type.equals("IVID")) {
						print_reports.add("PHPRDISSHIVINTT");
					}
					else if(order_type.equals("CD")||order_type.equals("CA")) {
						print_reports.add("PHCYTODISSHDL");
					}
					else if(order_type.equals("TD")) {
						print_reports.add("PHRTPNDISPLBDL");
					}
				}
				else if(print_opt.equals("DL")) {
					if(order_type.equals("NOR") || alPrintOthers.contains("MSL")) {
						print_reports.add("PHPRDISSH");
						if(patient_class.equals("IP") )
							print_reports.add("PHPRDISLB_AL_IP");
						else if(patient_class.equals("OP") )
							print_reports.add("PHPRDISLB_AL_OP");
						/*if(patient_class.equals("IP") && dflt_lang_for_disp_label.equals("E"))
							print_reports.add("PHPRDISLB_AL_IP");
						else if(patient_class.equals("OP") && dflt_lang_for_disp_label.equals("E"))
							print_reports.add("PHPRDISLB_AL_OP");
						else if(patient_class.equals("IP") && dflt_lang_for_disp_label.equals("L"))
							print_reports.add("PHPRDISLB_AL_IP_ARA");
						else if(patient_class.equals("OP") && dflt_lang_for_disp_label.equals("L"))
							print_reports.add("PHPRDISLB_AL_OP_ARA");
						else if(patient_class.equals("OP") && dflt_lang_for_disp_label.equals("B"))
							print_reports.add("PHPRDISLBOPEA");
						*/
					} 
					else if(order_type.equals("IVAA")||order_type.equals("IVAD")) {
						print_reports.add("PHPRDISSHIVCONT");
						print_reports.add("PHRIVCONT");		
					}
					else if(order_type.equals("IVWA")) {
						print_reports.add("PHPRDISSHIVCONT");
						print_reports.add("PHRIVCONTWOADD");		
					} 
					else if(order_type.equals("IVIA")||order_type.equals("IVID")) {
						print_reports.add("PHPRDISSHIVINTT");
						print_reports.add("PHRIVINTT");		
					}
					else if(order_type.equals("CD")||order_type.equals("CA")) {
						print_reports.add("PHCYTODISSHDL");
						print_reports.add("PHRCYTOLBDEL");		
					}
					else if(order_type.equals("TD")) {
						print_reports.add("PHRTPNDISPLBDL");
						print_reports.add("PHRDISSHTPNDEL");				
					}
				}
				else if(print_opt.equals("BL")) {
					if(order_type.equals("NOR") || alPrintOthers.contains("MSL")) {
						print_reports.add("PHPRBALMS");
						if(patient_class.equals("IP") )
							print_reports.add("PHPRDISLB_AL_IP");
						else if(patient_class.equals("OP") )
							print_reports.add("PHPRDISLB_AL_OP");
						
					/*	if(patient_class.equals("IP") && dflt_lang_for_disp_label.equals("E"))
							print_reports.add("PHPRDISLB_AL_IP");
						else if(patient_class.equals("OP") && dflt_lang_for_disp_label.equals("E"))
							print_reports.add("PHPRDISLB_AL_OP");
						else if(patient_class.equals("IP") && dflt_lang_for_disp_label.equals("L"))
							print_reports.add("PHPRDISLB_AL_IP_ARA");
						else if(patient_class.equals("OP") && dflt_lang_for_disp_label.equals("L"))
							print_reports.add("PHPRDISLB_AL_OP_ARA");
						else if(patient_class.equals("OP") && dflt_lang_for_disp_label.equals("B"))
							print_reports.add("PHPRDISLBOPEA");
						*/
					}
					else if(order_type.equals("IVAD")||order_type.equals("IVAA")) {
						print_reports.add("PHRIVCONT");		
					}
					else if(order_type.equals("IVWA")) {
						print_reports.add("PHRIVCONTWOADD");		
					}
					else if(order_type.equals("IVID")||order_type.equals("IVIA")) {
						print_reports.add("PHRIVINTT");		
					}
					else if(order_type.equals("CD")||order_type.equals("CA")) {
						print_reports.add("PHRCYTOLBDEL");		
					}
					else if(order_type.equals("TD")) {
						print_reports.add("PHRTPNDISPLBDL");
					}
				} 
				else if(print_opt.equals("D")) {
					if(order_type.equals("NOR")) {
						print_reports.add("PHPRDISSH");
						
					} 
					else if(order_type.equals("IVAD")||order_type.equals("IVAA") || order_type.equals("IVWA")) {
						print_reports.add("PHPRDISSHIVCONT");
					}
					else if(order_type.equals("IVIA")||order_type.equals("IVID")) {
						print_reports.add("PHPRDISSHIVINTT");
					}
					else if(order_type.equals("CD")||order_type.equals("CA")) {
						print_reports.add("PHCYTODISSHDL");
					}
					else if(order_type.equals("TD")) {							
						print_reports.add("PHRDISSHTPNDEL");							
					}
				} 
				else if(print_opt.equals("B")) {
					print_reports.add("PHPRBALMS");
				} 
				else if(print_opt.equals("L")) {
					if(order_type.equals("NOR") || alPrintOthers.contains("MSL")) {
						if(patient_class.equals("IP") )
							print_reports.add("PHPRDISLB_AL_IP");
						else if(patient_class.equals("OP") )
							print_reports.add("PHPRDISLB_AL_OP");
					/*	if(patient_class.equals("IP") && dflt_lang_for_disp_label.equals("E"))
							print_reports.add("PHPRDISLB_AL_IP");
						else if(patient_class.equals("OP") && dflt_lang_for_disp_label.equals("E"))
							print_reports.add("PHPRDISLB_AL_OP");
						else if(patient_class.equals("IP") && dflt_lang_for_disp_label.equals("L"))
							print_reports.add("PHPRDISLB_AL_IP_ARA");
						else if(patient_class.equals("OP") && dflt_lang_for_disp_label.equals("L"))
							print_reports.add("PHPRDISLB_AL_OP_ARA");
						else if(patient_class.equals("OP") && dflt_lang_for_disp_label.equals("B"))
							print_reports.add("PHPRDISLBOPEA");
						*/
					}
					else if(order_type.equals("IVAD")||order_type.equals("IVAA")) {
						print_reports.add("PHRIVCONT");		
					} 
					else if(order_type.equals("IVWA")) {
						print_reports.add("PHRIVCONTWOADD");		
					}
					else if(order_type.equals("IVID")||order_type.equals("IVIA")) {
						print_reports.add("PHRIVINTT");		
					}
					else if(order_type.equals("CD")||order_type.equals("CA")) {
						print_reports.add("PHRCYTOLBDEL");		
					}
					else if(order_type.equals("TD")) {
						print_reports.add("PHRTPNDISPLBDL");
					}
				}
			}
			if(print_extr_pres.equals("Y")){
				print_reports.add("PHREFLTR");  
			}
			
			if( printInclude.equals("I")){ //Added for RUT-CRF-0061 [IN:029599]- Start
				print_reports.add("PHHOMEDWITHEYE");
			}
			if( printSeparate.equals("S")){
				print_reports.add("PHHOMEDWOEYE");
			}
			if( printOnly.equals("O")){
				print_reports.add("PHHOMEDONLYEYE");
			}
			if( printTaper.equals("Y") ){
				print_reports.add("PHHOMEDTAPER");
			} //Added for RUT-CRF-0061 [IN:029599]-end
			if( printRefill.equals("Y") ){//Added If condition for MOHE-CRF-0069
				print_reports.add("PHPRREFLB");
			}
			
			ecis.utils.OnlineReports onlineReports		=	null;
			ecis.utils.OnlineReport report1				=	null;
			String stage = beanObj_1.getDispStage()==null?"":beanObj_1.getDispStage();
			if((stage.equals("A")||stage.equals("F")) && (!disp_stage.get(disp_stage.size()-1).equals(stage) && delivery_applicable.equals("Y"))) { // && (!disp_stage.get(disp_stage.size()-1).equals(stage) && delivery_applicable.equals("Y")) added for SKR-SCF-0611 [IN:034816]
				stage="A";
			}
			else{
				stage="D";
			}

			String   encounter_id  =  beanObj_1.getEncounterID();
			if(encounter_id==null || encounter_id.equals("null") || encounter_id.equals("11111")) {//encounter_id.equals("11111") Added for 52542 on 20/11/2023
				patient_class ="XT";
			}
			String customer_id = dispBean.getCustomerID();
			if(!disp_no.equals("")){
				ArrayList disp_srl_no				= new ArrayList();
				ArrayList order_line_field_values	= new ArrayList();
				int olfvSize						= 0;
				for(int i=0; i<print_reports.size(); i++) {
					report_id		=	(String)print_reports.get(i);
					if(report_id.equals("PHCERTREIM")){
						int count = beanObj.getCertificateReimburseCount ( disp_no,disp_no, stage);

						if(count>0){
							onlineReports 		= new ecis.utils.OnlineReports() ;
//							report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
							report1.addParameter("p_report_id",report_id) ;
							report1.addParameter("p_user_name",login_user) ;
							report1.addParameter("p_facility_id",facility_id) ;
							report1.addParameter("p_module_id", "PH") ;
							report1.addParameter("p_disp_no",disp_no);
							report1.addParameter("p_disp_locn_code",sDispLocnCode);
							report1.addParameter("p_patient_id",patient_id) ;	
							//if(!dflt_lang_for_disp_label.equals("E")){
							   report1.addParameter("p_language_id",sm_local_language_id) ;
							/*}
							else{
							   report1.addParameter("p_language_id","en") ;
							}*/ //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]

							onlineReports.add( report1) ;										
							ReportOutput = onlineReports.execute( request, response );
							report1 = null;
						}
					}
					else if(report_id.equals("PHMEDLIST")){
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id",report_id) ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_disp_date",sysdate) ;
						report1.addParameter("p_patient_id",patient_id) ;							
						report1.addParameter("p_frm_disp_no",disp_no);
						report1.addParameter("p_to_disp_no",disp_no);

						//if(!dflt_lang_for_disp_label.equals("E")){ //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
						   report1.addParameter("p_language_id",sm_local_language_id) ;
						/*}
						else{
						   report1.addParameter("p_language_id","en") ;
						}*/

						onlineReports.add( report1) ;										
						ReportOutput = onlineReports.execute( request, response );

						report1 = null;					
					}					
					else if(report_id.equals("PHHOMMED")){
						report_id			= "PHHOMMED";
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id",report_id) ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_disp_date",sysdate) ;
						report1.addParameter("p_patient_id",patient_id) ;							
						report1.addParameter("p_frm_disp_no",disp_no);
						report1.addParameter("p_to_disp_no",disp_no);
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						//if(!dflt_lang_for_disp_label.equals("E")){ //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
						   report1.addParameter("p_language_id",sm_local_language_id) ;
						/*}
						else{
						   report1.addParameter("p_language_id","en") ;
						}*/

						onlineReports.add( report1) ;										
						ReportOutput = onlineReports.execute( request, response );
						report1 = null;		
					}
					else if(report_id.equals("PHPRRELMS")){
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id",report_id) ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_disp_date",sysdate) ;
						report1.addParameter("p_patient_id",patient_id) ;							
						report1.addParameter("p_frm_disp_no",disp_no);
						report1.addParameter("p_to_disp_no",disp_no);
						//if(!dflt_lang_for_disp_label.equals("E")){ //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
						   report1.addParameter("p_language_id",sm_local_language_id) ;
						/*}
						else{
						   report1.addParameter("p_language_id","en") ;
						}*/
						onlineReports.add( report1) ;										
						ReportOutput = onlineReports.execute( request, response );
						//report1 = null;							
					}		
					else if(report_id.equals("PHPRDISLBFILL")||report_id.equals("PHPRDISLBFILL_ARA")||report_id.equals("PHPRDISLB_AL_IP")||report_id.equals("PHPRDISLB_AL_OP")||report_id.equals("PHPRDISLB_AL_IP_ARA")||report_id.equals("PHPRDISLB_AL_OP_ARA")){	//code for calling online labels for Noramal Rx
						if(!customer_id.equals("SRR")){System.out.println("report_id"+report_id);
							disp_srl_no			=	(ArrayList)beanObj.getDispSrlNO(disp_no,stage);
							if(disp_srl_no.size()>0){
								System.out.print("disp_srl_no 1621"+disp_srl_no);
								System.err.print("disp_srl_no 1621"+disp_srl_no);
								 onlineReports 		= new ecis.utils.OnlineReports() ;
//								 report1			= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
								for(int n=0;n<disp_srl_no.size();n++){
//									report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
									report1.addParameter("p_report_id",report_id) ;
									report1.addParameter("p_disp_no",disp_no);
									report1.addParameter("p_srl_no", (String)disp_srl_no.get(n)) ;
									report1.addParameter("p_user_name",login_user) ;
									report1.addParameter("p_facility_id",facility_id) ;
									report1.addParameter("p_locn_code",locn_code);
									report1.addParameter("p_patient_id",patient_id) ;							
									report1.addParameter("p_patient_class",patient_class);
									report1.addParameter("p_module_id", "PH") ;
									report1.addParameter("p_order_id", beanObj.getOrderId(disp_no,stage)) ;
									report1.addParameter("p_disp_date",sysdate) ; //added for SKR-SCF-1483
									/*if(bLabelAvailable && !bMedicalSupplyAvail)
										report1.addParameter("p_drug_yn", "Y") ;
									else*/ if(!bLabelAvailable && bMedicalSupplyAvail)
										report1.addParameter("p_drug_yn", "N");
									else
										report1.addParameter("p_drug_yn", "");

									//if(!dflt_lang_for_disp_label.equals("E")){ //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
									   report1.addParameter("p_language_id",sm_local_language_id) ;
									/*}
									else{
									   report1.addParameter("p_language_id","en") ;
									}*/
									onlineReports.add( report1) ;										
	System.err.println("DispMedicationValidation.jsp ==SKR-SCF-1278==MMS-KH-CRF-0017.1=labels for Noramal Rx  - p_report_id "+ report_id +" p_disp_no" + disp_no + " p_user_name" + login_user + "p_facility_id" + facility_id + "p_locn_code " + locn_code + " p_patient_id" + patient_id + "p_patient_class " + patient_class +" p_language_id="+sm_local_language_id+" ==stage===>"+stage+"disp_srl_no"+(String)disp_srl_no.get(n));
	System.err.println("DispMedicationValidation.jsp ==SKR-SCF-1610 1815labels for Noramal Rx  - p_report_id "+ report_id +" p_disp_no" + disp_no + " p_user_name" + login_user + "p_facility_id" + facility_id + "p_locn_code " + locn_code + " p_patient_id" + patient_id + "p_patient_class " + patient_class +" p_language_id="+sm_local_language_id+" ==stage===>"+stage+"disp_srl_no"+(String)disp_srl_no.get(n));
								}									
							}
							if(disp_srl_no.size()>0){
								ReportOutput = onlineReports.execute( request, response );
							}
						}
						else{
							onlineReports 		= new ecis.utils.OnlineReports() ;
//							report1			= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
							//for(int n=0;n<disp_srl_no.size();n++){
							//report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1.addParameter("p_report_id",report_id) ;
							report1.addParameter("p_disp_no",disp_no);
							//report1.addParameter("p_srl_no", (String)disp_srl_no.get(n)) ;
							report1.addParameter("p_user_name",login_user) ;
							report1.addParameter("p_facility_id",facility_id) ;
							report1.addParameter("p_locn_code",locn_code);
							report1.addParameter("p_patient_id",patient_id) ;							
							report1.addParameter("p_patient_class",patient_class);
							report1.addParameter("p_module_id", "PH") ;

							report1.addParameter("p_disp_to_no", disp_no) ;
							report1.addParameter("p_disp_fm_no", disp_no) ;
							//report1.addParameter("p_order_id", beanObj.getOrderId(disp_no,stage)) ;

							/*if(bLabelAvailable && !bMedicalSupplyAvail)
								report1.addParameter("p_drug_yn", "Y") ;
							else*/
							if(!bLabelAvailable && bMedicalSupplyAvail)
								report1.addParameter("p_drug_yn", "N");
							else
								report1.addParameter("p_drug_yn", "");

							//if(!dflt_lang_for_disp_label.equals("E")){ //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
							   report1.addParameter("p_language_id",sm_local_language_id) ;
							/*}
							else{
							   report1.addParameter("p_language_id","en") ;
							}*/
							onlineReports.add( report1) ;										
							//}						
						}
						report1 = null;
						if(bMedicalSupplyAvail && !medical_supp_label_printed){
							String disp_trn_seq_no =(String) beanObj.getDispTRNSeqNo(disp_no);
						   if(!disp_trn_seq_no.equals("")){
								onlineReports 		= new ecis.utils.OnlineReports() ;
//								report1				= new ecis.utils.OnlineReport( facility_id, "PH","PHPRDISLBMED") ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", "PHPRDISLBMED", "", "", "" , login_at_ws_no ); //added for IN070867
								report1.addParameter("p_report_id","PHPRDISLBMED") ;								
								report1.addParameter("p_user_name",login_user) ;
								report1.addParameter("p_facility_id",facility_id) ;								
								report1.addParameter("p_module_id", "PH") ;
								report1.addParameter("p_disp_trn_seq_no",disp_trn_seq_no) ;
								
								//if(!dflt_lang_for_disp_label.equals("E")){ //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
									report1.addParameter("p_language_id",sm_local_language_id) ;
								/*}
								else{
									report1.addParameter("p_language_id","en") ;
								}*/
								onlineReports.add( report1) ;
								ReportOutput = onlineReports.execute( request, response );
								report1 = null;
							}
							medical_supp_label_printed =true;
						}
					}
					else if(report_id.equals("PHRIVINTTFILL")||report_id.equals("PHRIVINTT")||report_id.equals("PHRCYTOLBFILL")||report_id.equals("PHRCYTOLBDEL")){
						//code for calling online labels for IV - Intermittent
						disp_srl_no				=	(ArrayList)beanObj.getDispSrlNO(disp_no,stage);
						String order_id			=	(String)beanObj.getOrderId(disp_no,stage);
						order_line_field_values	=	(ArrayList)beanObj.getOrderLineFieldValues(order_id);
						olfvSize					=	order_line_field_values.size();
						if(olfvSize == 0){
							olfvSize = 1;
						}
						 for(int n=0;n<disp_srl_no.size();n++){
							 onlineReports 		= new ecis.utils.OnlineReports() ;
							 for(int m=0;m<olfvSize;m++){
//								report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;	
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
								report1.addParameter("p_report_id",report_id) ;
								report1.addParameter("p_user_name",login_user) ;
								report1.addParameter("p_module_id", "PH") ;
								report1.addParameter("p_patient_id",patient_id) ;
								report1.addParameter("p_disp_no",disp_no);
								report1.addParameter("p_facility_id",facility_id) ;
								report1.addParameter("p_disp_date",sysdate);
								report1.addParameter("p_patient_class",patient_class);
								report1.addParameter("p_srl_no",(String)disp_srl_no.get(n));

								//if(!dflt_lang_for_disp_label.equals("E")){
								   report1.addParameter("p_language_id",sm_local_language_id) ;
									System.err.println("DispMedicationValidation.jsp ==SKR-SCF-1610 1921 Noramal Rx  - p_report_id "+ report_id +" p_disp_no" + disp_no + " p_user_name" + login_user + "p_facility_id" + facility_id + " p_patient_id" + patient_id + "p_patient_class " + patient_class +" p_language_id="+sm_local_language_id+" ==stage===>"+stage+"p_srl_no"+(String)disp_srl_no.get(n));
									
								/*}
								else{
								   report1.addParameter("p_language_id","en") ;
								}*/
								if(order_line_field_values.size() != 0){
									report1.addParameter("p_order_line_field_value",(String)order_line_field_values.get(m));
									System.err.println("DispMedicationValidation.jsp ==SKR-SCF-1610 1915for Noramal Rxp_order_line_field_value "+(String)order_line_field_values.get(m));
								}
								onlineReports.add( report1) ;
							 }
							 ReportOutput = onlineReports.execute( request, response );
						 }
						/* if(order_line_field_values.size()>0){
							ReportOutput = onlineReports.execute( request, response );
						 }*/          
						report1 = null;
					}
					else if(report_id.equals("PHRIVCONTFILL")||report_id.equals("PHRIVCONT") || report_id.equals("PHRFILLCONWOADD")){//report_id.equals("PHRFILLCONWOADD") added for ARYU-SCF-0014
						//code for calling online labels for IV - with additives
						 disp_srl_no				=	(ArrayList)beanObj.getDispSrlNO(disp_no,stage);
						 String order_id			=	(String)beanObj.getOrderId(disp_no,stage);
						 int repeat_value			=	beanObj.getRepeatValue(order_id);

						 for(int n=0;n<disp_srl_no.size();n++){
							 onlineReports 		= new ecis.utils.OnlineReports() ;
//							 report1			= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
							 for(int m=1;m<=repeat_value;m++){
//								report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;	
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
								report1.addParameter("p_report_id",report_id) ;
								report1.addParameter("p_user_name",login_user) ;
								report1.addParameter("p_module_id", "PH") ;
								report1.addParameter("p_patient_id",patient_id) ;
								report1.addParameter("p_disp_no",disp_no);
								report1.addParameter("p_facility_id",facility_id) ;
								report1.addParameter("p_disp_date",sysdate);
								report1.addParameter("p_patient_class",patient_class);
								report1.addParameter("p_srl_no",(String)disp_srl_no.get(n));				
								report1.addParameter("p_seq_no",m+"");	
								//if(!dflt_lang_for_disp_label.equals("E")){
								   report1.addParameter("p_language_id",sm_local_language_id) ;
								/*}
								else{
								   report1.addParameter("p_language_id","en") ;
								}*/
								onlineReports.add( report1) ;
							 }
							 System.err.println("SKR-SCF-1610 1958PHRIVCONTFILL===MMS-KH-CRF-0017.1==1818===>"+report_id+"==disp_srl_no.size()===>"+(String)disp_srl_no.get(n));
							 ReportOutput = onlineReports.execute( request, response );
						 }
						report1 = null;
					}
					//Added for ML-MMOH-CRF-2042 US002 start
					else if(report_id.equals("PHRDISSHTPNSTD")){
						
						
						onlineReports 		= new ecis.utils.OnlineReports() ;
				        report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); 
				        report1.addParameter("p_report_id",report_id) ;
				        report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_disp_date",sysdate) ;
						report1.addParameter("p_patient_id",patient_id) ;							
						report1.addParameter("p_module_id","PH");
						report1.addParameter("p_patient_class","IP");
						report1.addParameter("p_language_id",language_id) ;
						report1.addParameter("p_worksheet_id",work_sheet_id) ;
						onlineReports.add( report1) ;										
						ReportOutput = onlineReports.execute( request, response );
						report1 = null;	
				        }	
					//Added for ML-MMOH-CRF-2042 end									
					else{
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id",report_id) ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_locn_code",locn_code);
						report1.addParameter("p_patient_id",patient_id) ;
						report1.addParameter("p_disp_no",disp_no);
						report1.addParameter("p_patient_class",patient_class);
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						//if(!dflt_lang_for_disp_label.equals("E")){ //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
						   report1.addParameter("p_language_id",sm_local_language_id) ;
						/*}
						else{
						   report1.addParameter("p_language_id","en") ;
						}*/

						if(report_id.equals("PHREFLTR")) {			
							report1.addParameter("p_order_id", beanObj.getOrderId(disp_no,stage)) ;	
						}
System.err.println("DispMedicationValidation.jsp ==1835 ==SKR-SCF-1278=== p_report_id "+ report_id +" p_disp_no" + disp_no + " p_user_name" + login_user + "p_facility_id" + facility_id + "p_locn_code " + locn_code + " p_patient_id" + patient_id + "p_patient_class " + patient_class + " sDispLocnCode" + sDispLocnCode+" p_language_id="+sm_local_language_id+" ==stage===>"+stage+"==print_seq_no===>"+print_seq_no+"==sysdate===>"+sysdate);


						if(report_id.equals("PHPRDISSH") || report_id.equals("PHPRDISSHFILL") || report_id.equals("PHPRDISSHIVCONT") || report_id.equals("PHPRDISSHIVINTT") || report_id.equals("PHPRDISSHCONFILL") ||report_id.equals("PHCYTODISSHFL")|| report_id.equals("PHPRDISSHINTFILL")||report_id.equals("PHCYTODISSHDL")||report_id.equals("PHRDISSHTPNFILL")||report_id.equals("PHRDISSHTPNDEL")||report_id.equals("PHRTPNDISPLBDL")||report_id.equals("PHRTPNDISPLBFILL")) {
							report1.addParameter("p_disp_fm_no",disp_no);
							report1.addParameter("p_disp_to_no",disp_no);
							report1.addParameter("p_print_seq_no",print_seq_no) ;
						}
						if(report_id.equals("PHPRDISSHIVCONT")){ //added for SKR-SCF-1278
							String order_id			=	(String)beanObj.getOrderId(disp_no,stage);
							String iv_prep_yn = (String)beanObj.getIVFlag(order_id);
System.err.println("DispMedicationValidation.jsp==1864==order_id====>"+order_id+"==iv_prep_yn===>"+iv_prep_yn);
							report1.addParameter("P_IV_PREP_YN",iv_prep_yn);
							report1.addParameter("P_REPRINT","N");
						}
						if(report_id.equals("PHRIVCONT") || report_id.equals("PHRIVCONTWOADD") || report_id.equals("PHRIVINTT")|| report_id.equals("PHRCYTOLBDEL")||report_id.equals("PHRCYTOLBFILL")|| report_id.equals("PHRTPNDISPLBDL")||report_id.equals("PHRTPNDISPLBFILL")){
							report1.addParameter("p_disp_date",sysdate);
							report1.addParameter("p_pat_class",patient_class);

							if(bLabelAvailable && !bMedicalSupplyAvail)
								report1.addParameter("p_drug_yn", "Y") ;
							else if(!bLabelAvailable && bMedicalSupplyAvail)
								report1.addParameter("p_drug_yn", "N");
							else
								report1.addParameter("p_drug_yn", "");
						}
						System.err.println("skr-scf-1610 2012 p_disp_date"+sysdate+"p_pat_class"+patient_class+"bLabelAvailable"+bLabelAvailable+"bMedicalSupplyAvail"+bMedicalSupplyAvail);
						onlineReports.add( report1) ;
						ReportOutput = onlineReports.execute( request, response );
					}
				}					
			}
			else {
				ArrayList disp_trn_seq_nos =new ArrayList();
				if(print_reports.contains("PHPRDISSH") || print_reports.contains("PHPRDISSHFILL") || print_reports.contains("PHPRDISSHIVCONT") || print_reports.contains("PHPRDISSHIVINTT") || print_reports.contains("PHPRDISSHCONFILL") ||print_reports.contains("PHCYTODISSHFL")|| print_reports.contains("PHPRDISSHINTFILL")|| print_reports.contains("PHBRWRKSH")|| print_reports.contains("PHBRMFGLB")||print_reports.contains("PHCYTODISSHDL")||print_reports.contains("PHRDISSHTPNDEL")||print_reports.contains("PHRDISSHTPNFILL")){
						
					if(print_reports.contains("PHPRDISSH")) {
						report_id	=	"PHPRDISSH";
					}else if(print_reports.contains("PHPRDISSHFILL")) {
						report_id	=	"PHPRDISSHFILL";
					}else if(print_reports.contains("PHPRDISSHIVCONT")) {
						report_id	=	"PHPRDISSHIVCONT";
					}else if(print_reports.contains("PHPRDISSHIVINTT")) {
						report_id	=	"PHPRDISSHIVINTT";
					}else if(print_reports.contains("PHPRDISSHCONFILL")) {
						report_id	=	"PHPRDISSHCONFILL";
					}else if(print_reports.contains("PHPRDISSHINTFILL")) {
						report_id	=	"PHPRDISSHINTFILL";
					}else if(print_reports.contains("PHBRWRKSH")) {
						report_id	=	"PHBRWRKSH";
					}else if(print_reports.contains("PHBRMFGLB")) {
						report_id	=	"PHBRMFGLB";
					}else if(print_reports.contains("PHCYTODISSHFL")) {
						report_id	=	"PHCYTODISSHFL";
					}else if(print_reports.contains("PHCYTODISSHDL")) {
						report_id	=	"PHCYTODISSHDL";
					}else if(print_reports.contains("PHRDISSHTPNDEL")) {
						report_id	=	"PHRDISSHTPNDEL";
					}else if(print_reports.contains("PHRDISSHTPNFILL")) {
						report_id	=	"PHRDISSHTPNFILL";
					}
					
					String fm_disp_no	= (String)disp_nos.get(0);
					String to_disp_no	= (String)disp_nos.get( (disp_nos.size()-1) );
					StringBuffer dispNo = new StringBuffer();//SKR-SCF-1278
					onlineReports 		= new ecis.utils.OnlineReports() ;
//					report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;

				//Added for GHL-CRF-0627 - Start
				String pat_class="";
					if(disp_sheet_check){
						 pat_class=dispBean.getPatientClass(patient_id,encounter_id);
						 patient_class=pat_class;
					}
					System.err.println("pat_class===" + pat_class + "==patient_class===" + patient_class);	
					if(disp_sheet_check && (pat_class.equals("IP") || pat_class.equals("DC")) && report_id.equals("PHPRDISSHFILL"))
					{
						report_id="PHPRDISSHFILL_IP";
					}
					if(disp_sheet_check && (pat_class.equals("IP") || pat_class.equals("DC")) && report_id.equals("PHPRDISSH"))
					{
						report_id="PHPRDISSH_IP";
					}

					if(disp_sheet_check && pat_class.equals("EM") && report_id.equals("PHPRDISSHFILL"))
					{
						report_id="PHPRDISSHFILL_EM";
					}
					if(disp_sheet_check && pat_class.equals("EM") && report_id.equals("PHPRDISSH"))
					{
						report_id="PHPRDISSH_EM";
					} 
				//Added for GHL-CRF-0627 - End
					
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
              if(report_id.equals("PHPRDISSHIVCONT")){ //added for SKR-SCF-1278
							String order_id			=	(String)beanObj.getOrderId(fm_disp_no,stage);
							String iv_prep_yn = (String)beanObj.getIVFlag(order_id);
System.err.println("DispMedicationValidation.jsp==1864==order_id====>"+order_id+"==iv_prep_yn===>"+iv_prep_yn);
							report1.addParameter("P_IV_PREP_YN",iv_prep_yn);
							report1.addParameter("P_REPRINT","N");
						}
						//if(report_id.equals("PHPRDISSHFILL")){//added for SKR-SCF-1278 - start
						if(report_id.equals("PHPRDISSHFILL")||report_id.equals("PHPRDISSH")){//added for SKR-SCF-1278 - start//PHPRDISSH is added for SKR_SCF-1734	
							for(int i=0;i<disp_nos.size();i++){
								
								if(i==0){
									//dispNo.append("");
									dispNo.append((String)disp_nos.get(0));
									if(disp_nos.size()>1)
										dispNo.append(",");
								}else{
									if(i!=(disp_nos.size()-1)){
										dispNo.append((String)disp_nos.get(i));
										dispNo.append(",");
									}else{
										dispNo.append((String)disp_nos.get(i));
										//dispNo.append(")");
									}
								}
							}
							report1.addParameter("P2MULDISP",dispNo.toString());
						} //added for SKR-SCF-1278 - end
					report1.addParameter("p_report_id",report_id) ;
					report1.addParameter("p_user_name",login_user) ;
					report1.addParameter("p_facility_id",facility_id) ;
					report1.addParameter("p_locn_code",locn_code);
					report1.addParameter("p_patient_id",patient_id) ;
					report1.addParameter("p_disp_fm_no",fm_disp_no);
					report1.addParameter("p_disp_to_no",to_disp_no);
					report1.addParameter("p_patient_class",patient_class);
					report1.addParameter("p_disp_date",Sysdate);//SKR-SCF-1734
					report1.addParameter("p_module_id", "PH") ;
					//if(!dflt_lang_for_disp_label.equals("E")){ //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
					   report1.addParameter("p_language_id",sm_local_language_id) ;
					/*}
					else{
					   report1.addParameter("p_language_id","en") ;
					}*/
					report1.addParameter("p_print_seq_no",print_seq_no) ;
System.err.println("DispMedicationValidation.jsp==70867= SKR-SCF-1278==1910=MMS-KH-CRF-0017.1====report_id===>"+report_id+"==login_user=="+login_user+"==facility_id=="+facility_id+"==locn_code=="+locn_code+"==patient_id=="+patient_id+"==fm_disp_no=="+fm_disp_no+"==to_disp_no=="+to_disp_no+"==patient_class=="+patient_class+"==print_seq_no=="+print_seq_no+"sm_local_language_id"+sm_local_language_id);
					onlineReports.add( report1) ;
					ReportOutput = onlineReports.execute( request, response );

					if(print_reports.contains("PHPRDISSH")) {
						print_reports.remove("PHPRDISSH");
					}
					else if(print_reports.contains("PHPRDISSHFILL")) {
						print_reports.remove("PHPRDISSHFILL");
					}
					else if(print_reports.contains("PHPRDISSHIVCONT")) {
						print_reports.remove("PHPRDISSHIVCONT");
					}
					else if(print_reports.contains("PHPRDISSHIVINTT")) {
						print_reports.remove("PHPRDISSHIVINTT");
					}
					else if(print_reports.contains("PHPRDISSHCONFILL")) {
						print_reports.remove("PHPRDISSHCONFILL");
					}
					else if(print_reports.contains("PHPRDISSHINTFILL")) {
						print_reports.remove("PHPRDISSHINTFILL");
					}
					else if(print_reports.contains("PHBRWRKSH")) {
						print_reports.remove("PHBRWRKSH");
					}
					else if(print_reports.contains("PHBRMFGLB")) {
						print_reports.remove("PHBRMFGLB");
					}
					else if(print_reports.contains("PHCYTODISSHFL")) {
						print_reports.remove("PHCYTODISSHFL");
					}
					else if(print_reports.contains("PHCYTODISSHDL")) {
						print_reports.remove("PHCYTODISSHDL");
					}
					else if(print_reports.contains("PHRDISSHTPNDEL")) {
						print_reports.remove("PHRDISSHTPNDEL");
					}
					else if(print_reports.contains("PHRDISSHTPNFILL")) {
						print_reports.remove("PHRDISSHTPNFILL");
					} 
				}
				//Added for ML-MMOH-CRF-2042 US002 start
				if(print_reports.contains("PHRDISSHTPNSTD")){
					
					report_id	="PHRDISSHTPNSTD";
					onlineReports 		= new ecis.utils.OnlineReports() ;
			        report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); 
			        report1.addParameter("p_report_id",report_id) ;
			        report1.addParameter("p_user_name",login_user) ;
					report1.addParameter("p_facility_id",facility_id) ;
					report1.addParameter("p_disp_date",sysdate) ;
					report1.addParameter("p_patient_id",patient_id) ;							
					report1.addParameter("p_module_id","PH");
					report1.addParameter("p_patient_class","IP");
					report1.addParameter("p_language_id",language_id) ;
					report1.addParameter("p_worksheet_id",work_sheet_id) ;
					onlineReports.add( report1) ;										
					ReportOutput = onlineReports.execute( request, response );
					report1 = null;	
			        }	
				//Added for ML-MMOH-CRF-2042 end 							
				if( print_reports.contains("PHPRBALMS")){
					report_id	=	"PHPRBALMS";
					String dispNosForBMS = beanObj.getBalanceMedicationDispNos(disp_nos); //Added for Bru-HIMS-CRF-415 [IN:045556]
					/*for(int n=0;n<disp_nos.size(); n++){ 
						int count=beanObj.getBalanceMedicationcount((String)disp_nos.get(n));*///commented for Bru-HIMS-CRF-415 [IN:045556]
						if(!dispNosForBMS.equals("")){
							onlineReports 		= new ecis.utils.OnlineReports() ;
//							report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
							report1.addParameter("p_report_id",report_id) ;
							report1.addParameter("p_user_name",login_user) ;
							report1.addParameter("p_facility_id",facility_id) ;
							report1.addParameter("p_locn_code",locn_code);
							report1.addParameter("p_patient_id",patient_id) ;
							report1.addParameter("p_disp_no",dispNosForBMS); //Added for Bru-HIMS-CRF-415 [IN:045556]
							//report1.addParameter("p_disp_no",(String)disp_nos.get(n));//Commented for Bru-HIMS-CRF-415 [IN:045556]
							//report1.addParameter("p_disp_no",to_disp_no);
							report1.addParameter("p_patient_class",patient_class);
							report1.addParameter("p_module_id", "PH") ;
							report1.addParameter("curr_stage",curr_stage) ;
							report1.addParameter("p_disp_locn_code",sDispLocnCode);
							//report1.addParameter("p_language_id",language_id) ;
						//IF CONDTION COMMENTED FOR TBMC-SCF-0152
							//if(!bms_sel_lang.equals("E")){  //changed dflt_lang_for_disp_label to bms_sel_lang for CRF-074 by manickam
							   report1.addParameter("p_language_id",sm_local_language_id) ;
							/* }
							else{
							   report1.addParameter("p_language_id","en") ;
							} */
							onlineReports.add( report1) ;
							ReportOutput = onlineReports.execute( request, response );
						}
					//}                                
					//ReportOutput = onlineReports.execute( request, response );PHMEDLIST
					 if(print_reports.contains("PHPRBALMS")) {
						print_reports.remove("PHPRBALMS");
					}							
				}               
				if( print_reports.contains("PHMEDLIST")){
					report_id	=	"PHMEDLIST";	
					//for(int n=0;n<disp_nos.size(); n++){
					onlineReports 		= new ecis.utils.OnlineReports() ;
//					report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
					report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
					report1.addParameter("p_report_id",report_id) ;
					report1.addParameter("p_user_name",login_user) ;
					report1.addParameter("p_facility_id",facility_id) ;
					report1.addParameter("p_locn_code",locn_code);
					report1.addParameter("p_patient_id",patient_id) ;
					report1.addParameter("p_frm_disp_no",(String)disp_nos.get(0));
					report1.addParameter("p_to_disp_no",(String)disp_nos.get( (disp_nos.size()-1) ));
					//report1.addParameter("p_disp_no",to_disp_no);
					report1.addParameter("p_patient_class",patient_class);
					report1.addParameter("p_module_id", "PH") ;
					report1.addParameter("curr_stage",curr_stage) ;
					//report1.addParameter("p_language_id",language_id) ;
					//if(!dflt_lang_for_disp_label.equals("E")){ //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
					   report1.addParameter("p_language_id",sm_local_language_id) ;
					/*}
					else{
					   report1.addParameter("p_language_id","en") ;
					}*/
					//System.err.println("@@@@@@@@@@ Medication List  - p_report_id"+ report_id +" p_user_name" + login_user + "p_facility_id" +  facility_id +   " p_locn_code ="+ locn_code + " p_patient_id"+ patient_id +" p_frm_disp_no" + (String)disp_nos.get(0) + "p_to_disp_no" + (String)disp_nos.get( (disp_nos.size()-1) ) + " p_patient_class" + patient_class + " curr_stage"+ curr_stage+ " dflt_lang_for_disp_label"+ dflt_lang_for_disp_label +"sm_local_language_id"+ sm_local_language_id );
					onlineReports.add( report1) ;
					ReportOutput = onlineReports.execute( request, response );
					//}                                
								//ReportOutput = onlineReports.execute( request, response );PHMEDLIST
					 if(print_reports.contains("PHMEDLIST")) {
						print_reports.remove("PHMEDLIST");
					}							
				} 
				//Added for  ML-BRU-CRF-072[Inc:29938] start 
				//for(int k=0; k<disp_nos.size(); k++) {	
				/*if(disp_nos!=null && disp_nos.size()>0 && print_reports.contains("PHPRMEDPL")){//commented for Bru-HIMS-CRF-072.1 [IN:049144]
					report_id	=	"PHPRMEDPL";	
					//String order_id			=	(String)beanObj.getOrderId((String)disp_nos.get(k),stage);
					onlineReports 		= new ecis.utils.OnlineReports() ;
					report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
					report1.addParameter("p_report_id",report_id) ;
					report1.addParameter("p_user_name",login_user) ;
					report1.addParameter("p_facility_id",facility_id) ;
					report1.addParameter("p_locn_code",locn_code);
					report1.addParameter("p_patient_class",patient_class);
					report1.addParameter("p_module_id", "PH") ;
					//report1.addParameter("p_order_id",order_id) ;
					report1.addParameter("p_disp_fm_no",(String)disp_nos.get(0)) ;
					report1.addParameter("p_disp_to_no",(String)disp_nos.get(disp_nos.size()-1)) ;
					report1.addParameter("curr_stage",curr_stage) ;
					//if(!dflt_lang_for_disp_label.equals("E")){
					   report1.addParameter("p_language_id",sm_local_language_id) ;
					onlineReports.add( report1) ;
					ReportOutput = onlineReports.execute( request, response );
					//}
				}*/ //Added for  ML-BRU-CRF-072[Inc:29938] end 
				if(print_reports.contains("PHCERTREIM")){
					int count = beanObj.getCertificateReimburseCount ( (String)disp_nos.get(0), 
					(String)disp_nos.get( (disp_nos.size()-1) ) , stage);
					if(count>0){
						report_id	=	"PHCERTREIM";	
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
						report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id",report_id) ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						//report1.addParameter("p_disp_no",disp_no);
						report1.addParameter("p_frm_disp_no",(String)disp_nos.get(0));
						report1.addParameter("p_to_disp_no",(String)disp_nos.get( (disp_nos.size()-1) ));
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						report1.addParameter("p_patient_id",patient_id) ;							
						//if(!dflt_lang_for_disp_label.equals("E")){ //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
						   report1.addParameter("p_language_id",sm_local_language_id) ;
						/*}
						else{
						   report1.addParameter("p_language_id","en") ;
						}*/

						onlineReports.add( report1) ;										
						ReportOutput = onlineReports.execute( request, response );
						report1 = null;
					}
				}
				if(print_reports.contains("PHHOMMED")){
					report_id	=	"PHHOMMED";	
					onlineReports 		= new ecis.utils.OnlineReports() ;
					//report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
					report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
					report1.addParameter("p_report_id",report_id) ;
					report1.addParameter("p_user_name",login_user) ;
					report1.addParameter("p_facility_id",facility_id) ;
					report1.addParameter("p_module_id", "PH") ;
					report1.addParameter("p_disp_date",sysdate) ;
					report1.addParameter("p_patient_id",patient_id) ;							
					report1.addParameter("p_frm_disp_no",(String)disp_nos.get(0));
					report1.addParameter("p_to_disp_no",(String)disp_nos.get( (disp_nos.size()-1) ));
					//if(!dflt_lang_for_disp_label.equals("E")){
					   report1.addParameter("p_language_id",sm_local_language_id) ;
					/*}
					else{
					   report1.addParameter("p_language_id","en") ;
					}*/
					report1.addParameter("p_disp_locn_code",sDispLocnCode);

					onlineReports.add( report1) ;										
					ReportOutput = onlineReports.execute( request, response );
					report1 = null;		
				}
				if(print_reports.contains("PHPRRELMS"))	{
					report_id			= "PHPRRELMS_SRR";	
					onlineReports 		= new ecis.utils.OnlineReports() ;
//					report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
					report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
					report1.addParameter("p_report_id",report_id) ;
					report1.addParameter("p_user_name",login_user) ;
					report1.addParameter("p_facility_id",facility_id) ;
					report1.addParameter("p_module_id", "PH") ;
					report1.addParameter("p_disp_date",sysdate) ;
					report1.addParameter("p_patient_id",patient_id) ;							
					report1.addParameter("p_frm_disp_no",(String)disp_nos.get(0));
					report1.addParameter("p_to_disp_no",(String)disp_nos.get( (disp_nos.size()-1) ));
					
					//if(!dflt_lang_for_disp_label.equals("E")){ //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
					   report1.addParameter("p_language_id",sm_local_language_id) ;
					/*}
					else{
					   report1.addParameter("p_language_id","en") ;
					}*/
					onlineReports.add( report1) ;										
					ReportOutput = onlineReports.execute( request, response );
					report1 = null;		
				}
				//Added for RUT-CRF-0061 [IN:029599]- Start
				if( print_reports.contains("PHHOMEDWITHEYE")){
					if(!print_Type.equals("B")){
						if( print_Type.equals("L"))
							report_id	=	"PHHOMEDWITHEYE";
						else if(print_Type.equals("P"))
							report_id	=	"PHHOMEDWITHEYE_PO";
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
						report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id",report_id) ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_frm_disp_no",(String)disp_nos.get(0));
						report1.addParameter("p_to_disp_no",(String)disp_nos.get( (disp_nos.size()-1) ));
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						report1.addParameter("p_patient_id",patient_id) ;							
						report1.addParameter("p_language_id",sm_local_language_id) ;
			
						onlineReports.add( report1) ;										
						ReportOutput = onlineReports.execute( request, response );
						report1 = null;
					}
					else if(print_Type.equals("B")){
						onlineReports 		= new ecis.utils.OnlineReports() ;
//				report1				= new ecis.utils.OnlineReport( facility_id, "PH","PHHOMEDWITHEYE") ;//Changed for RUT-CRF-[IN46205]
						report1	= new ecis.utils.OnlineReport( facility_id, "PH", "PHHOMEDWITHEYE", "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id","PHHOMEDWITHEYE") ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_frm_disp_no",(String)disp_nos.get(0));
						report1.addParameter("p_to_disp_no",(String)disp_nos.get( (disp_nos.size()-1) ));
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						report1.addParameter("p_patient_id",patient_id) ;							
						report1.addParameter("p_language_id",sm_local_language_id) ;
		
						onlineReports.add( report1) ;										
						ReportOutput = onlineReports.execute( request, response );
						report1 = null;
					
						onlineReports 		= new ecis.utils.OnlineReports() ;
						//report1				= new ecis.utils.OnlineReport( facility_id, "PH","PHHOMEDWITHEYE_PO") ;//Changed for RUT-CRF-[IN46205]
						report1	= new ecis.utils.OnlineReport( facility_id, "PH", "PHHOMEDWITHEYE_PO", "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id","PHHOMEDWITHEYE_PO") ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_frm_disp_no",(String)disp_nos.get(0));
						report1.addParameter("p_to_disp_no",(String)disp_nos.get( (disp_nos.size()-1) ));
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						report1.addParameter("p_patient_id",patient_id) ;							
						report1.addParameter("p_language_id",sm_local_language_id) ;
		
						onlineReports.add( report1) ;										
						ReportOutput = onlineReports.execute( request, response );
						report1 = null;
					}
				}
				if( print_reports.contains("PHHOMEDWOEYE")){
					if(!print_Type.equals("B")){
						if( print_Type.equals("L"))
							report_id	=	"PHHOMEDWOEYE";
						else if(print_Type.equals("P"))
							report_id	=	"PHHOMEDWOEYE_PO";
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id",report_id) ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_frm_disp_no",(String)disp_nos.get(0));
						report1.addParameter("p_to_disp_no",(String)disp_nos.get( (disp_nos.size()-1) ));
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						report1.addParameter("p_patient_id",patient_id) ;							
						report1.addParameter("p_language_id",sm_local_language_id) ;
			
						onlineReports.add( report1) ;										
						ReportOutput = onlineReports.execute( request, response );
						report1 = null;
					}
					else if( print_Type.equals("B")){
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH","PHHOMEDWOEYE") ;//Changed for RUT-CRF-[IN46205]
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", "PHHOMEDWOEYE", "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id","PHHOMEDWOEYE") ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_frm_disp_no",(String)disp_nos.get(0));
						report1.addParameter("p_to_disp_no",(String)disp_nos.get( (disp_nos.size()-1) ));
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						report1.addParameter("p_patient_id",patient_id) ;							
						report1.addParameter("p_language_id",sm_local_language_id) ;
			
						onlineReports.add( report1) ;										
						ReportOutput = onlineReports.execute( request, response );
						report1 = null;
						
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH","PHHOMEDWOEYE_PO") ;//Changed for RUT-CRF-[IN46205]
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", "PHHOMEDWOEYE_PO", "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id","PHHOMEDWOEYE_PO") ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_frm_disp_no",(String)disp_nos.get(0));
						report1.addParameter("p_to_disp_no",(String)disp_nos.get( (disp_nos.size()-1) ));
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						report1.addParameter("p_patient_id",patient_id) ;							
						report1.addParameter("p_language_id",sm_local_language_id) ;
			
						onlineReports.add( report1) ;										
						ReportOutput = onlineReports.execute( request, response );
						report1 = null;
					}
				}
				if(print_reports.contains("PHHOMEDONLYEYE")){
					if(!print_Type.equals("B")){
						if( print_Type.equals("L"))
							report_id	=	"PHHOMEDONLYEYE";
						else if(print_Type.equals("P"))
							report_id	=	"PHHOMEDONLYEYE_PO";
						onlineReports 		= new ecis.utils.OnlineReports() ;
						//report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
						report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id",report_id) ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_frm_disp_no",(String)disp_nos.get(0));
						report1.addParameter("p_to_disp_no",(String)disp_nos.get( (disp_nos.size()-1) ));
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						report1.addParameter("p_patient_id",patient_id) ;							
						report1.addParameter("p_language_id",sm_local_language_id) ;
			
						onlineReports.add( report1) ;										
						ReportOutput = onlineReports.execute( request, response );
						report1 = null;
					}
					else if(print_Type.equals("B")){
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH","PHHOMEDONLYEYE") ;//Changed for RUT-CRF-[IN46205]
						report1	= new ecis.utils.OnlineReport( facility_id, "PH", "PHHOMEDONLYEYE", "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id","PHHOMEDONLYEYE") ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_frm_disp_no",(String)disp_nos.get(0));
						report1.addParameter("p_to_disp_no",(String)disp_nos.get( (disp_nos.size()-1) ));
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						report1.addParameter("p_patient_id",patient_id) ;							
						report1.addParameter("p_language_id",sm_local_language_id) ;
		
						onlineReports.add( report1) ;										
						ReportOutput = onlineReports.execute( request, response );
						report1 = null;
					
						onlineReports 		= new ecis.utils.OnlineReports() ;
						report1				= new ecis.utils.OnlineReport( facility_id, "PH","PHHOMEDONLYEYE_PO") ;//Changed for RUT-CRF-[IN46205]
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", "PHHOMEDONLYEYE_PO", "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id","PHHOMEDONLYEYE_PO") ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_frm_disp_no",(String)disp_nos.get(0));
						report1.addParameter("p_to_disp_no",(String)disp_nos.get( (disp_nos.size()-1) ));
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						report1.addParameter("p_patient_id",patient_id) ;							
						report1.addParameter("p_language_id",sm_local_language_id) ;
		
						onlineReports.add( report1) ;										
						ReportOutput = onlineReports.execute( request, response );
						report1 = null;
					}
				}
				if(print_reports.contains("PHHOMEDTAPER")){
					if(!print_Type.equals("B")){
						if(patient_class.equals("OP")){
							if( print_Type.equals("L"))
								report_id	=	"PHHOMEDOUTTAPER";
							else if(print_Type.equals("P"))
								report_id	=	"PHHOMEDOUTTAPER_PO";
						}
						else if(patient_class.equals("IP")){
							if( print_Type.equals("L"))
								report_id	=	"PHHOMEDTAPER";
							else if(print_Type.equals("P"))
								report_id	=	"PHHOMEDTAPER_PO";
						}
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id",report_id) ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_frm_disp_no",(String)disp_nos.get(0));
						report1.addParameter("p_to_disp_no",(String)disp_nos.get( (disp_nos.size()-1) ));
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						report1.addParameter("p_patient_id",patient_id) ;							
						report1.addParameter("p_language_id",sm_local_language_id) ;
			
						onlineReports.add( report1) ;										
						ReportOutput = onlineReports.execute( request, response );
						report1 = null;
					}
					else if( print_Type.equals("B")){
						if(patient_class.equals("OP"))
							report_id	=	"PHHOMEDOUTTAPER";
						else if(patient_class.equals("IP"))
							report_id	=	"PHHOMEDTAPER";
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id",report_id) ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_frm_disp_no",(String)disp_nos.get(0));
						report1.addParameter("p_to_disp_no",(String)disp_nos.get( (disp_nos.size()-1) ));
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						report1.addParameter("p_patient_id",patient_id) ;							
						report1.addParameter("p_language_id",sm_local_language_id) ;
		
						onlineReports.add( report1) ;										
						ReportOutput = onlineReports.execute( request, response );
						report1 = null;
						
						if(patient_class.equals("OP"))
							report_id	=	"PHHOMEDOUTTAPER_PO";
						else if(patient_class.equals("IP"))
							report_id	=	"PHHOMEDTAPER_PO";
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id","PHHOMEDTAPER_PO") ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_frm_disp_no",(String)disp_nos.get(0));
						report1.addParameter("p_to_disp_no",(String)disp_nos.get( (disp_nos.size()-1) ));
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						report1.addParameter("p_patient_id",patient_id) ;							
						report1.addParameter("p_language_id",sm_local_language_id) ;
		
						onlineReports.add( report1) ;										
						ReportOutput = onlineReports.execute( request, response );
						report1 = null;
					}
				}//Added for RUT-CRF-0061 [IN:029599] - End
				//added for ML-MMOH-CRF-1089 START
			if(curr_stage.equals("D") && siteTpnStd && dispBean.getWsType().equals("7") ){
				duration_values = (ArrayList)beanObj_1.getDurnValue(work_sheet_id,"TPN_WS_FINALIZE",sDispLocnCode);
				duration_value  = (String)duration_values.get(0);
				ord_type		= (String)duration_values.get(1);
				repeat_value_1	= (String)duration_values.get(2);
			
					System.out.println("print_reports"+print_reports);
					if(print_reports.contains("PHTPNDISPLBF")){
						report_id="PHTPNDISPLBF";
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_ord_type",ord_type);
						report1.addParameter("p_duration_value",duration_value);
						report1.addParameter("p_freq",repeat_value_1);
						report1.addParameter("p_worksheet_id",work_sheet_id) ;
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_user_name",login_user);
						report1.addParameter("p_report_id",report_id);					
						report1.addParameter("p_module_id","PH");
						report1.addParameter("p_report_exec_name",report_id);
						report1.addParameter("p_language_id",sm_local_language_id) ;
										onlineReports.add( report1) ;
					ReportOutput = onlineReports.execute( request, response );
					report1 = null;
					
					}
					if(print_reports.contains("PHBRWRKTP")){
						report_id="PHBRWRKTP";
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_worksheet_id",work_sheet_id) ;
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_user_name",login_user);
						report1.addParameter("p_report_id",report_id);					
						report1.addParameter("p_module_id","PH");
						report1.addParameter("p_report_exec_name",report_id);
						report1.addParameter("p_language_id",sm_local_language_id) ;
										onlineReports.add( report1) ;
					ReportOutput = onlineReports.execute( request, response );
					report1 = null;
					
					}
					if(print_reports.contains("PHTPNSCOB")){
						report_id="PHTPNSCOB";
						onlineReports 		= new ecis.utils.OnlineReports() ;
//					report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_worksheet_id",work_sheet_id) ;
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_user_name",login_user);
						report1.addParameter("p_report_id",report_id);					
						report1.addParameter("p_module_id","PH");
						report1.addParameter("p_report_exec_name",report_id);
						report1.addParameter("p_language_id",sm_local_language_id) ;
										onlineReports.add( report1) ;
					ReportOutput = onlineReports.execute( request, response );
					report1 = null;
					
					}
					
					if(print_reports.contains("PHTPNLIP")){
						report_id="PHTPNLIP";
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_worksheet_id",work_sheet_id) ;
						report1.addParameter("p_disp_locn_code",sDispLocnCode);
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_user_name",login_user);
						report1.addParameter("p_report_id",report_id);					
						report1.addParameter("p_module_id","PH");
						report1.addParameter("p_report_exec_name",report_id);
						report1.addParameter("p_language_id",sm_local_language_id) ;
				     onlineReports.add( report1) ;
					ReportOutput = onlineReports.execute( request, response );
					report1 = null;
					
					}
					
			}
			//added for ML-MMOH-CRF-1089 END
			//Adding start for MOHE-CRF-0069
			   if(print_reports.contains("PHPRREFLB")){
						report_id="PHPRREFLB";
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_patient_id",patient_id) ;
						report1.addParameter("p_refill_order",beanObj.getRefillOrderStr());
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_from_date","");
						report1.addParameter("p_to_date","");					
						report1.addParameter("p_module_id","PH");
			                        report1.addParameter("p_locn_code",locn_code);
						report1.addParameter("p_report_id",report_id);
						report1.addParameter("p_language_id",sm_local_language_id) ;
						onlineReports.add( report1) ;
						ReportOutput = onlineReports.execute( request, response );
						report1 = null;
					}
					//Adding end for MOHE-CRF-0069
				
				ArrayList disp_srl_no				=	new ArrayList() ;
				ArrayList order_line_field_values	=	new ArrayList();
				int olfvSize						=	0;
				
				ecis.utils.OnlineReports onlineReports1 		= new ecis.utils.OnlineReports() ;
				ArrayList noOfPrints = beanObj.getNoOfPrints();
				System.out.print("noOfPrints 2548"+noOfPrints);
				System.err.print("noOfPrints 2548"+noOfPrints);
				int printcountIndx=0;
				System.out.println("disp_nos"+disp_nos);
				for(int k=0; k<disp_nos.size(); k++) {	
					System.out.println("print_reports"+print_reports);
					for(int i=0; i<print_reports.size(); i++) {
						report_id		=	(String)print_reports.get(i);		
						//onlineReports 		= new ecis.utils.OnlineReports() ;
						if(order_type.equals("NOR")) {System.out.print("order_type 2555"+order_type);
						System.err.print("order_type 2555"+order_type);	
						if(report_id.equals("PHPRDISLBFILL")||report_id.equals("PHPRDISLBFILL_ARA")||report_id.equals("PHPRDISLB_AL_IP")||report_id.equals("PHPRDISLB_AL_OP")||report_id.equals("PHPRDISLB_AL_IP_ARA")||report_id.equals("PHPRDISLB_AL_OP_ARA")){
								if(!customer_id.equals("SRR")){
									disp_srl_no=null;
									disp_srl_no	=	(ArrayList)beanObj.getDispSrlNO((String)disp_nos.get(k),stage);
									System.err.println("disp_srl_no ---- 2521"+disp_srl_no);  //1,2
									System.out.println("patient_class---"+patient_class);
									int disp_srl_no_job_size = 0; //added for ML-MMOH-CRF-2155.1 - start 
									 if(isJobQueueReport && patient_class.equals("OP")){
										disp_srl_no_job_size = 1; 
									}else{
										disp_srl_no_job_size = disp_srl_no.size(); 
									} //added for ML-MMOH-CRF-2155.1 - end  
									if(disp_srl_no.size()>0){
										int noPrint=1;	
										//onlineReports1.wait(1000000000);
										System.out.println("2565"+disp_srl_no);
										//System.err.println("2565"+onlineReports1.getReports());
										onlineReports1 		= new ecis.utils.OnlineReports() ;
										report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
										//Collections.reverse(disp_srl_no);  // SKR-SCF-0716 [IN036163] - Reversed the order as the disp sl no is taken reverse from or_order_line
										for(int n=0;n<disp_srl_no.size();n++){
											System.out.print("disp_srl_no 2737"+disp_srl_no);
											System.err.println("disp_srl_no 2570"+disp_srl_no);
											if(printcountIndx<noOfPrints.size()){
												noPrint = Integer.parseInt((noOfPrints.get(printcountIndx)==null || noOfPrints.get(printcountIndx).equals(""))?"1":(String) noOfPrints.get(printcountIndx));
												System.out.print("noPrint 2740"+noPrint);
												System.err.println("noPrint 2570"+noPrint);
												printcountIndx++;
											}
											System.out.println("2527 num_print_skr"+num_print_skr);
											if(num_print_skr){//added for skr-scf-1721
												noPrint=Integer.parseInt((String)beanObj.getfillPrints((String)disp_nos.get(k),(String)disp_srl_no.get(n),facility_id));
												System.out.println("2517 noPrint"+noPrint);
											}
											System.out.println("getTotalPrint 2501"+beanObj.getTotalPrint());
										if(beanObj.getTotalPrint().containsKey((String)disp_nos.get(k)+"@"+(String)disp_srl_no.get(n))){ // Added for all Stages Dispense Label Issue.
											noPrint = Integer.parseInt((String)beanObj.getTotalPrint().get((String)disp_nos.get(k)+"@"+(String)disp_srl_no.get(n))); // Added for TTMWM-SCF-0184
											System.out.print("noPrint 2580"+noPrint);
											System.err.print("noPrint 2580"+noPrint);
													
										}
											//for(int indxNoP=0; indxNoP<noPrint; indxNoP++){ //commented for ML-MMOH-CRF-2155
//												report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							//report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
												report1.addParameter("p_report_id",report_id) ;
												report1.addParameter("p_disp_no",(String)disp_nos.get(k));
												 System.err.println("disp_srl_no inside report generate  "+(String)disp_srl_no.get(n));
												 if(!isJobQueueReport && !patient_class.equals("OP")){ //added for ML-MMOH-CRF-2155.1
													 report1.addParameter("p_srl_no", (String)disp_srl_no.get(n)) ;
												 } //added for ML-MMOH-CRF-2155.1 - modified 
												 
												//report1.addParameter("p_srl_no", (String)disp_srl_no.get(n)) ;
												report1.addParameter("p_user_name",login_user) ;
												report1.addParameter("p_facility_id",facility_id) ;
												report1.addParameter("p_locn_code",locn_code);
												report1.addParameter("p_patient_id",patient_id) ;					
												report1.addParameter("p_patient_class",patient_class);
												report1.addParameter("p_module_id", "PH") ;
												//if(!dflt_lang_for_disp_label.equals("E")){ //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
												   report1.addParameter("p_language_id",sm_local_language_id) ;
												/*}
												else{
												   report1.addParameter("p_language_id","en") ;
												}*/
												if(!bLabelAvailable && bMedicalSupplyAvail){
													report1.addParameter("p_drug_yn", "N");
												}
												else{
													report1.addParameter("p_drug_yn", "");
												}
												report1.addParameter("p_order_id", beanObj.getOrderId((String)disp_nos.get(k),stage)) ;
												 System.err.println("p_order_id inside report generate  "+beanObj.getOrderId((String)disp_nos.get(k),stage));
												if(noPrint>1){ //added for ML-MMOH-CRF-2155
														report1.addParameter("copies",noPrint+""); 
												}
												
												System.err.println("2768"+report1);
												if(noPrint>0){
												onlineReports1.add( report1) ;	
												}
												System.err.println("onlineReports1  "+onlineReports1);
		System.err.println("DispMedicationValidation.jsp==70867===2537=====report_id===>"+report_id+"==login_user=="+login_user+"==facility_id=="+facility_id+"==locn_code=="+locn_code+"==patient_id=="+patient_id+"==patient_class=="+patient_class+"==login_at_ws_no==");

		System.err.println("DispMedicationValidation.jsp ==SKR-SCF-1610 2754 for   - p_report_id "+ report_id +" p_disp_no" + (String)disp_nos.get(k) + " p_user_name" + login_user + "p_facility_id" + facility_id + "p_locn_code " + locn_code + " p_patient_id" + patient_id + "p_patient_class " + patient_class +" p_language_id="+sm_local_language_id+" ==stage===>"+stage+"disp_srl_no"+(String)disp_srl_no.get(n));
									//}//commented for ML-MMOH-CRF-2155
											
										}
										/* if( patient_class.equals("IP")){
										System.err.println("IP report "); */
										ReportOutput = onlineReports1.execute( request, response );
										//}
									}
									/* if(patient_class.equals("OP")){
										System.err.println("OP report ");
										ReportOutput = onlineReports1.execute( request, response );
									} */

								}// end if !customer_id.equals("SRR")
								else{	System.out.println("else 2620");
								System.err.println("else 2620");
									if(k==0){
										onlineReports1 		= new ecis.utils.OnlineReports() ;
//										report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
										report1.addParameter("p_report_id",report_id) ;
										report1.addParameter("p_disp_no",""); // for SRR20056-SCF-7184
										report1.addParameter("p_user_name",login_user) ;
										report1.addParameter("p_facility_id",facility_id) ;
										report1.addParameter("p_locn_code",locn_code);
										report1.addParameter("p_patient_id",patient_id) ;					
										report1.addParameter("p_patient_class",patient_class);
										report1.addParameter("p_module_id", "PH") ;

										report1.addParameter("p_disp_fm_no", (String)disp_nos.get(0)) ;
										report1.addParameter("p_disp_to_no",(String)disp_nos.get(disp_nos.size()-1)) ;
										//if(!dflt_lang_for_disp_label.equals("E")) //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
										   report1.addParameter("p_language_id",sm_local_language_id) ;
										/*
										else
										   report1.addParameter("p_language_id","en") ;*/
										
										if(!bLabelAvailable && bMedicalSupplyAvail){
											report1.addParameter("p_drug_yn", "N");
										}
										else{
											report1.addParameter("p_drug_yn", "");
										}
										   System.err.println("DispMedicationValidation.jsp ==SKR-SCF-1610 2788 for   - p_report_id "+ report_id +" p_disp_no='' p_user_name" + login_user + "p_facility_id" + facility_id + "p_locn_code " + locn_code + " p_patient_id" + patient_id + "p_patient_class " + patient_class +" p_language_id="+sm_local_language_id+" ==stage===>"+stage+"disp_nos"+disp_nos);
System.err.println("SKR-SCF-1610 p_disp_fm_no"+(String)disp_nos.get(0));
System.err.println(" SKR-SCF-1610p_disp_to_no"+(String)disp_nos.get(disp_nos.size()-1));
										onlineReports1.add( report1) ;	
										ReportOutput = onlineReports1.execute( request, response );
									}
								}// end else !customer_id.equals("SRR")
								report1 = null;
								if(bMedicalSupplyAvail && !medical_supp_label_printed){
							  		String disp_trn_seq_no = (String) beanObj.getDispTRNSeqNo((String)disp_nos.get(k));
								  	for(int m=0;m<disp_trn_seq_nos.size();m++){
									   if(((String)disp_trn_seq_nos.get(m)).equals(disp_trn_seq_no)){
										   medical_supp_label_printed =true;
										   break;
									   }
								   }
								   if(!medical_supp_label_printed){
									 disp_trn_seq_nos.add(disp_trn_seq_no);
								   }
								   if((!disp_trn_seq_no.equals(""))&&(!medical_supp_label_printed)){
									   onlineReports1 		= new ecis.utils.OnlineReports() ;
//										report1				= new ecis.utils.OnlineReport( facility_id, "PH","PHPRDISLBMED") ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", "PHPRDISLBMED", "", "", "" , login_at_ws_no ); //added for IN070867
										report1.addParameter("p_report_id","PHPRDISLBMED") ;								
										report1.addParameter("p_user_name",login_user) ;
										report1.addParameter("p_facility_id",facility_id) ;								
										report1.addParameter("p_module_id", "PH") ;
										report1.addParameter("p_disp_trn_seq_no",disp_trn_seq_no) ;
										//if(!dflt_lang_for_disp_label.equals("E")){ //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
											report1.addParameter("p_language_id",sm_local_language_id) ;
										/*}
										else{
											report1.addParameter("p_language_id","en") ;
										}*/
										onlineReports1.add( report1) ;	
										ReportOutput = onlineReports1.execute( request, response );
										report1 = null;
										medical_supp_label_printed =true;
								   }
								}
							}//end if report_id
						}// end if order_type.equals("NOR")
						else if(order_type.equals("IVIA")||order_type.equals("IVID")||order_type.equals("CA")||order_type.equals("CD")){
							if(report_id.equals("PHRIVINTTFILL")|| report_id.equals("PHRIVINTT")||report_id.equals("PHRCYTOLBFILL")||report_id.equals("PHRCYTOLBDEL")){
							//code for calling online labels for IV - Intermittent
							 disp_srl_no				=	(ArrayList)beanObj.getDispSrlNO((String)disp_nos.get(k),stage);
							 //if(order_type.equals("IVID")) //if block added for SKR-SCF-0651 [IN:035303] - commented for // SKR-SCF-0716 [IN036163]
								//Collections.reverse(disp_srl_no);
							 String order_id			=	(String)beanObj.getOrderId((String)disp_nos.get(k),stage);
							 order_line_field_values	=	(ArrayList)beanObj.getOrderLineFieldValues(order_id);
							 //ArrayList alDispQtyVal = (ArrayList)beanObj.getDispQty(order_id, (String)disp_nos.get(k),curr_stage);//Commented for SKR-SCF-0537 since it is no need //added for SKR-SCF-280 ICN 29433
							 int modulo=0, noPrint=1; //added for SKR-SCF-280 ICN 29433
							 olfvSize					=	order_line_field_values.size();
							 if(olfvSize == 0)
								 olfvSize = 1;
							 onlineReports1 		= new ecis.utils.OnlineReports() ;
							 int disp_srl_no_job_size = 0; //added for ML-MMOH-CRF-2155.1 - start 
								if(isJobQueueReport && patient_class.equals("OP")){
									disp_srl_no_job_size = 1; 
								}else{
									disp_srl_no_job_size = disp_srl_no.size();
								} //added for ML-MMOH-CRF-2155.1 - end 
							System.err.println("2684 ---------"+disp_srl_no_job_size);
							 for(int n=0;n<disp_srl_no.size();n++){
								 /*dispQtyVal = Integer.parseInt(alDispQtyVal.get(n)==null?"0":(String)alDispQtyVal.get(n)); //added for SKR-SCF-280 ICN 29433
								 //for(int m=0;m<olfvSize;m++) //commented for SKR-SCF-280 ICN 29433
								 if(alDispQtyVal.size()==noOfPrints.size()){
								   dispQtyVal=Integer.parseInt((String)noOfPrints.get(n));
								 }*/
						//		 for(int m=0;m<dispQtyVal;m++) //added for SKR-SCF-280 ICN 29433 // commented for SKR-SCF-0537
								 noPrint=1; 
							   	 if(printcountIndx<noOfPrints.size()){
									noPrint = Integer.parseInt(noOfPrints.get(printcountIndx)==null?"1":(String) noOfPrints.get(printcountIndx));
									printcountIndx++;
								 }
							   	System.out.println("2678 num_print_skr"+num_print_skr);
							   	if(num_print_skr){//added for skr-scf-1721
									noPrint=Integer.parseInt((String)beanObj.getfillPrints((String)disp_nos.get(k),(String)disp_srl_no.get(n),facility_id));//added for skr-scf-1721
									System.out.println("2679 noPrint"+noPrint);
								}
							   	 System.err.println("noPrint 2618"+noPrint);
								int indxNoP=0;
								 //for(int indxNoP=0; indxNoP<noPrint; indxNoP++){ commented for ML-MMOH-CRF-2155
//										report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;			
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
										report1.addParameter("p_report_id",report_id) ;
										System.err.println("p_report_id  "+report_id);
										report1.addParameter("p_user_name",login_user) ;
										report1.addParameter("p_module_id", "PH") ;
										report1.addParameter("p_patient_id",patient_id) ;
										report1.addParameter("p_disp_no",(String)disp_nos.get(k));
										report1.addParameter("p_facility_id",facility_id) ;
										report1.addParameter("p_disp_date",sysdate);
										report1.addParameter("p_patient_class",patient_class);
										//report1.addParameter("p_srl_no",(String)disp_srl_no.get(n));
										if(!isJobQueueReport && !patient_class.equals("OP")){ //added for ML-MMOH-CRF-2155.1
											report1.addParameter("p_srl_no",(String)disp_srl_no.get(n));
										 } //added for ML-MMOH-CRF-2155.1 - modified 
										//if(!dflt_lang_for_disp_label.equals("E")){ //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
										   report1.addParameter("p_language_id",sm_local_language_id) ;
										/*}
										else{
										   report1.addParameter("p_language_id","en") ;
										}*/
										if(order_line_field_values.size() != 0){
											modulo = indxNoP % order_line_field_values.size();
											report1.addParameter("p_order_line_field_value",(String)order_line_field_values.get(modulo)); //changed indxNoP to modulo for SKR-SCF-1046 //changed m to indxNoP for SKR-SCF-0537
										}
										if(noPrint>1) //added for ML-MMOH-CRF-2155
											report1.addParameter("copies",noPrint+"");
										System.err.println("DispMedicationValidation.jsp ==SKR-SCF-1610 2881 Noramal Rx  - p_report_id "+ report_id +" p_disp_no" + disp_no + " p_user_name" + login_user + "p_facility_id" + facility_id + "p_locn_code " + locn_code + " p_patient_id" + patient_id + "p_patient_class " + patient_class +" p_language_id="+sm_local_language_id+" ==stage===>"+stage+"disp_srl_no"+(String)disp_srl_no.get(n));
										onlineReports1.add( report1) ;
								//}
							 }
							 ReportOutput = onlineReports1.execute( request, response );
							 report1 = null;
							 if(bMedicalSupplyAvail && !medical_supp_label_printed ){
								String disp_trn_seq_no = (String) beanObj.getDispTRNSeqNo((String)disp_nos.get(k));
								for(int m=0;m<disp_trn_seq_nos.size();m++){
									if(((String)disp_trn_seq_nos.get(m)).equals(disp_trn_seq_no)){
									   medical_supp_label_printed =true;
									   break;
									}
								}
								if(!medical_supp_label_printed){
									disp_trn_seq_nos.add(disp_trn_seq_no);
								}
							 // disp_trn_seq_nos.add(disp_trn_seq_no);
							    if(!disp_trn_seq_no.equals("")&&!medical_supp_label_printed){
								   onlineReports1 		= new ecis.utils.OnlineReports() ;
//									report1				= new ecis.utils.OnlineReport( facility_id, "PH","PHPRDISLBMED") ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", "PHPRDISLBMED", "", "", "" , login_at_ws_no ); //added for IN070867
									report1.addParameter("p_report_id","PHPRDISLBMED") ;								
									report1.addParameter("p_user_name",login_user) ;
									report1.addParameter("p_facility_id",facility_id) ;								
									report1.addParameter("p_module_id", "PH") ;
									report1.addParameter("p_disp_trn_seq_no",disp_trn_seq_no) ;
									
									//if(!dflt_lang_for_disp_label.equals("E")){ //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
										report1.addParameter("p_language_id",sm_local_language_id) ;
									/*}
									else{
										report1.addParameter("p_language_id","en") ;
									}*/
									onlineReports1.add( report1) ;	
									ReportOutput = onlineReports1.execute( request, response );
									report1 = null;
									medical_supp_label_printed =true;
							   }
							}
						}// end if report_id	
					}// end if order_type.equals("IVIA")||order_type.equals("IVID")||order_type.equals("CA")||order_type.equals("CD")
					else if(order_type.equals("IVAD")||order_type.equals("IVAA")||order_type.equals("IVWA")){
						if(report_id.equals("PHRIVCONTFILL")|| report_id.equals("PHRIVCONT") || report_id.equals("PHRIVCONTWOADD") || report_id.equals("PHRFILLCONWOADD")){//report_id.equals("PHRFILLCONWOADD") added for ARYU-CRF-0014
							//code for calling online labels for IV - Additives, IV - Without Additives
							 disp_srl_no				=	(ArrayList)beanObj.getDispSrlNO((String)disp_nos.get(k),stage);
							 int disp_srl_no_job_size = 0; //added for ML-MMOH-CRF-2155.1 - start 
								if(isJobQueueReport && patient_class.equals("OP")){
									disp_srl_no_job_size = 1; 
								}else{
									disp_srl_no_job_size = disp_srl_no.size();
								} //added for ML-MMOH-CRF-2155.1 - end 
							//if(order_type.equals("IVAD")) //if block added for SKR-SCF-0651 [IN:035303] //Commented for SKR-SCF-0716 [IN036163]
								//Collections.reverse(disp_srl_no);
System.err.println("skr-scf-1610PHRIVCONTFILL======2707===MMS-KH-CRF-0017.1====>"+report_id+"==disp_srl_no===>"+disp_srl_no);
							 String order_id			=	(String)beanObj.getOrderId((String)disp_nos.get(k),stage);
							 //int repeat_value			=	beanObj.getRepeatValue(order_id);//commented for SKR-SCF-280 ICN 29433
							 //ArrayList alDispQtyVal = (ArrayList)beanObj.getDispQty(order_id, (String)disp_nos.get(k),curr_stage); //added for SKR-SCF-280 ICN 29433
							 int noPrint=1; //added for SKR-SCF-280 ICN 29433
							 onlineReports1 		= new ecis.utils.OnlineReports() ;
							 for(int n=0;n<disp_srl_no.size();n++){
								//dispQtyVal = Integer.parseInt(alDispQtyVal.get(n)==null?"0":(String)alDispQtyVal.get(n)); //added for SKR-SCF-280 ICN 29433
				//				for(int m=0;m<dispQtyVal;m++) //added for SKR-SCF-280 ICN 29433 commented for SKR-SCF-0537 
								noPrint=1;
								if(printcountIndx<noOfPrints.size()){
									noPrint = Integer.parseInt(noOfPrints.get(printcountIndx)==null?"1":(String) noOfPrints.get(printcountIndx));
									printcountIndx++;
								}
								System.out.println("2774 num_print_skr"+num_print_skr);
								if(num_print_skr){//added for skr-scf-1721
									noPrint=Integer.parseInt((String)beanObj.getfillPrints((String)disp_nos.get(k),(String)disp_srl_no.get(n),facility_id));//added for skr-scf-1721
									System.out.println("2771 noPrint"+noPrint);
								}
								System.out.println("2736 noPrint"+noPrint);
								int indxNoP=0; //added for ML-MMOH-CRF-2155
								//for(int indxNoP=0; indxNoP<noPrint; indxNoP++){ //commented for ML-MMOH-CRF-2155
									//for(int m=1;m<=repeat_value;m++) //commented for SKR-SCF-280 ICN 29433
//									report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
									report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867		
									report1.addParameter("p_report_id",report_id) ;
									report1.addParameter("p_user_name",login_user) ;
									report1.addParameter("p_module_id", "PH") ;
									report1.addParameter("p_patient_id",patient_id) ;
									report1.addParameter("p_disp_no",(String)disp_nos.get(k));
									report1.addParameter("p_facility_id",facility_id) ;
									report1.addParameter("p_disp_date",sysdate);
									report1.addParameter("p_patient_class",patient_class);
									//report1.addParameter("p_srl_no",(String)disp_srl_no.get(n));	
									if(!isJobQueueReport && !patient_class.equals("OP")){ //added for ML-MMOH-CRF-2155.1
										report1.addParameter("p_srl_no",(String)disp_srl_no.get(n));
									 } //added for ML-MMOH-CRF-2155.1 - modified 
									report1.addParameter("p_seq_no",indxNoP+"");	//changed m to indxNoP for SKR-SCF-0537
									//if(!dflt_lang_for_disp_label.equals("E")){ //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
									   report1.addParameter("p_language_id",sm_local_language_id) ;
									/*}
									else{
									   report1.addParameter("p_language_id","en") ;
									}*/
									if(noPrint>1) //added for ML-MMOH-CRF-2155
										report1.addParameter("copies",noPrint+"");
									System.err.println("DispMedicationValidation.jsp ==SKR-SCF-1610 2960 for Noramal Rx  - p_report_id "+ report_id +" p_disp_no" + (String)disp_nos.get(k) +" p_user_name" + login_user + "p_facility_id" + facility_id + "p_srl_no " + (String)disp_srl_no.get(n) + " p_patient_id" + patient_id + "p_patient_class " + patient_class +" p_language_id="+sm_local_language_id+" ==p_seq_no===>"+indxNoP);
									
									onlineReports1.add( report1) ;
								//} //commented for ML-MMOH-CRF-2155
							}
							ReportOutput = onlineReports1.execute( request, response );
							report1 = null;
						}// end if report_id.equals("PHRIVCONTFILL")|| report_id.equals("PHRIVCONT")
					}// end if order_type.equals("IVAD")||order_type.equals("IVAA")||order_type.equals("IVWA")
					onlineReports1 =null; 
					if(!report_id.equals("PHPRDISLBFILL")&& !report_id.equals("PHPRDISLBFILL_ARA")&& !report_id.equals("PHPRDISLB_AL_IP")&& !report_id.equals("PHPRDISLB_AL_OP")&& !report_id.equals("PHPRDISLB_AL_IP_ARA")&& !report_id.equals("PHPRDISLB_AL_OP_ARA")&& !report_id.equals("PHRIVINTTFILL")&& !report_id.equals("PHRIVINTT")&& !report_id.equals("PHRIVCONTFILL") && !report_id.equals("PHRFILLCONWOADD") && !report_id.equals("PHRIVCONT") && !report_id.equals("PHRCYTOLBFILL")&& !report_id.equals("PHRCYTOLBDEL")&& (report_id.equals("PHRTPNDISPLBFILL")|| report_id.equals("PHRTPNDISPLBDL")||report_id.equals("PHREFLTR"))){
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id",report_id) ;
						report1.addParameter("p_disp_no",(String)disp_nos.get(k));
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_locn_code",locn_code);
						report1.addParameter("p_patient_id",patient_id) ;							
						report1.addParameter("p_patient_class",patient_class);
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_order_id", beanObj.getOrderId((String)disp_nos.get(k),stage)) ;

						report1.addParameter("p_disp_date",sysdate);
						report1.addParameter("p_pat_class",patient_class);
						//if(!dflt_lang_for_disp_label.equals("E")){ //if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
						   report1.addParameter("p_language_id",sm_local_language_id) ;
						/*}
						else{
						   report1.addParameter("p_language_id","en") ;
						}*/
						
						onlineReports.add( report1) ;
						ReportOutput = onlineReports.execute( request, response );
						report1      = null;
										
						if(bMedicalSupplyAvail ){
							String disp_trn_seq_no = (String) beanObj.getDispTRNSeqNo((String)disp_nos.get(k));
							for(int m=0;m<disp_trn_seq_nos.size();m++){
								if(((String)disp_trn_seq_nos.get(m)).equals(disp_trn_seq_no)){
									medical_supp_label_printed =true;
									break;
								}
							}
							if(!medical_supp_label_printed){
								disp_trn_seq_nos.add(disp_trn_seq_no);
							}

							if(!disp_trn_seq_no.equals("") && !medical_supp_label_printed){
//								report1				= new ecis.utils.OnlineReport( facility_id, "PH","PHPRDISLBMED") ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", "PHPRDISLBMED", "", "", "" , login_at_ws_no ); //added for IN070867
								report1.addParameter("p_report_id","PHPRDISLBMED") ;								
								report1.addParameter("p_user_name",login_user) ;
								report1.addParameter("p_facility_id",facility_id) ;								
								report1.addParameter("p_module_id", "PH") ;
								report1.addParameter("p_disp_trn_seq_no",disp_trn_seq_no) ;
								
								//if(!dflt_lang_for_disp_label.equals("E")){//if condition & else part commented for  Added for MMS-QH-CRF-0069 [IN:037977]
									report1.addParameter("p_language_id",sm_local_language_id) ;
								/*}
								else{
									report1.addParameter("p_language_id","en") ;
								}*/
								onlineReports.add( report1) ;	
								ReportOutput = onlineReports.execute( request, response );
								report1 = null;
								medical_supp_label_printed =true;
							}
						}
						}// end if !report_id.equals("PHPRDISLBFILL")&& !report_id.equals("PHPRDISLBFILL_ARA")          
					}// end for print_reports
				}// end for disp_nos
			}
			// objects nullified after usage
			print_reports	=	null;
			dispBean.clearAlBMSOrderIds();
			dispBean.resetBConsuableItemAvailable();
			dispBean.setHmAllocBmsChk(new HashMap());
			//beanObj.clear();
		}
		else if(func_mode!= null && func_mode.equals("print_label")){
			System.out.println("In Disp Medication Validation");
			System.out.println("2905 print_label function");
			System.err.println("2905 print_label function");
			String bean_id_1			= "DispMedicationBean";
			String bean_name_1			= "ePH.DispMedicationBean";
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1, request);
			beanObj_1.setLanguageId(locale);
			bean_id						= (String) hash.get("bean_id");
			bean_name					= (String) hash.get("bean_name");
			String language_id		    = (String)session.getAttribute("LOCALE");
			String	work_sheet_id		= (String) hash.get("work_sheet_id");
			String	disp_locn_code		= (String) hash.get("disp_locn_code");
			String login_user			= (String)session.getValue("login_user");
			String facility_id			= (String)session.getValue("facility_id");
			String selected_ws_report_1 = (String) hash.get("selected_ws_report_1");
			String selected_ws_report_2 = (String) hash.get("selected_ws_report_2");
			String selected_ws_report_4 = (String) hash.get("selected_ws_report_4");//added for ml-mmoh-crf-0468
			String selected_ws_report_5 = (String) hash.get("selected_ws_report_5");//added for ml-mmoh-crf-0468
			String selected_ws_report_6 = (String) hash.get("selected_ws_report_6");//added for ml-mmoh-crf-2042																													  
			String ws_type				= (String) hash.get("ws_type");
			String curr_stage			= beanObj_1.getDispStage();
			String report_id			= "";
			String ReportOutput			= "";
			ArrayList duration_values   = new ArrayList();
			String duration_value		= "";
			String ord_type				= "";
			String repeat_value			= "";
			String type_of_wrksheet		= beanObj_1.getOrderType();
			ArrayList print_reports	=	new ArrayList();
			String disp_no				= "";
			String patient_id			= (String) hash.get("pid");
			String sDispNoPatId			= beanObj_1.getDispNoFromWorksheetId(work_sheet_id,disp_locn_code);
			if(sDispNoPatId!=null)	{
				disp_no = sDispNoPatId.split("~")[0];
				patient_id = sDispNoPatId.split("~")[1];
			}
			String sysdate			= beanObj_1.getTodaysDate();
			String sPrintOthers[];
			ArrayList alPrintOthers = null;
			if( hash.get("otherReports") != null && !hash.get("otherReports").toString().equals("")){
				sPrintOthers = hash.get("otherReports").toString().split("~");
				alPrintOthers = new ArrayList(Arrays.asList(sPrintOthers)); 
				if(alPrintOthers != null && alPrintOthers.size()>0){
					if(alPrintOthers.contains("CR"))
						print_reports.add("PHCERTREIM");
			
					if(alPrintOthers.contains("ML"))
						print_reports.add("PHMEDLIST");

					if(alPrintOthers.contains("HMS"))
						print_reports.add("PHHOMMED");

					if(alPrintOthers.contains("RFMS"))
						print_reports.add("PHPRRELMS");
				}
			}

			if(ws_type.equals("WS_FINALIZE") || ws_type.equals("CYTO_WS_FINALIZE") || ws_type.equals("TPN_WS_FINALIZE") ){//modified for MMS-KH-CRF-0017.1
				duration_values = (ArrayList)beanObj_1.getDurnValue(work_sheet_id,ws_type,disp_locn_code);
				duration_value  = (String)duration_values.get(0);
				ord_type		= (String)duration_values.get(1);
				repeat_value	= (String)duration_values.get(2);
			}
			String module_id = "PH" ;
			System.err.println("ws_type===2874=MMS-KH-CRF-0017.1=>"+ws_type);
			if(ws_type.equals("TPN_WS_FINALIZE") ){//modified for ml-mmoh-crf-0468
				if(selected_ws_report_1.equals("Y"))
					print_reports.add("PHBRWRKTP");
				if(selected_ws_report_2.equals("Y") && type_of_wrksheet.equals("TA"))
					{
					print_reports.add("PHBRMFGTP");
					
					}
				else{if(selected_ws_report_2.equals("Y") ){//added for ml-mmoh-crf-0469
					print_reports.add("PHTPNDISPLBF");
					}
				}
				if(selected_ws_report_4.equals("Y")   && type_of_wrksheet.equals("TA"))
					{
					print_reports.add("PHTPNCOB");
					}
				else{//ELSE ADDED FOR ML-MMOH-CRF-1089
					if(selected_ws_report_4.equals("Y")   && type_of_wrksheet.equals("TD"))
					{
					print_reports.add("PHTPNSCOB");
					}
				}
				if(selected_ws_report_5.equals("Y"))
					print_reports.add("PHTPNLIP");

				//Added for ML-MMOH-CRF-2042 starts
				if(selected_ws_report_6.equals("Y"))
				   print_reports.add("PHRDISSHTPNSTD");
				//Added for ML-MMOH-CRF-2042 ends		
				System.out.println("ML-MMOH-CRF-2042 Validation In Report if condition");		  
				int count = beanObj_1.CheckForLipid(facility_id,work_sheet_id,disp_locn_code);
				if(count>0){
					print_reports.add("PHTPNSYGLB");
				}
			}
			else if(ws_type.equals("TPN_WS_RECORD") ){
				print_reports.add("PHBRWRKTP");
			}
			else{
				if(selected_ws_report_1.equals("Y")){
					if(curr_stage.equals("F") || curr_stage.equals("A")){//filling,allocation
					   print_reports.add("PHBRWRKSH1");
					 }else{//delivery
					   print_reports.add("PHBRWRKSH");
					}
				}
				if(selected_ws_report_2.equals("Y")){
					if(type_of_wrksheet.equals("CO")){
						print_reports.add("PHCPMFGLB");
					}else{
						if(ord_type.equals("4")){
						   print_reports.add("PHCYTOMFGLB");
						}else{
						   print_reports.add("PHBRMFGLB");
						}
					}
				}
			}
			System.err.println("print_reports123====MMS-KH-CRF-0017.1=>"+print_reports+"==selected_ws_report_1===>"+selected_ws_report_1+"==selected_ws_report_2==>"+selected_ws_report_2);
			ecis.utils.OnlineReports onlineReports 	=	null;
			ecis.utils.OnlineReport report			=	null;
			ecis.utils.OnlineReport report1			=	null;
			for(int i=0; i<print_reports.size(); i++) {
				report_id		=	(String)print_reports.get(i);
				if(report_id.equals("PHCERTREIM")){
					int count = beanObj.getCertificateReimburseCount ( disp_no,disp_no, curr_stage);

					if(count>0){
						onlineReports 		= new ecis.utils.OnlineReports() ;
//						report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
							report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
						report1.addParameter("p_report_id",report_id) ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_disp_no",disp_no);
						report1.addParameter("p_locn_code",disp_locn_code);
						report1.addParameter("p_patient_id",patient_id) ;							
						report1.addParameter("p_language_id",language_id) ;
						onlineReports.add( report1) ;										
						ReportOutput = onlineReports.execute( request, response );
						report1 = null;
					}
				}

				if(report_id.equals("PHMEDLIST")){
//System.err.println("###### Medication List  - p_report_id "+ report_id +" p_user_name" + login_user + "p_facility_id" +  facility_id + "p_disp_date " + sysdate + " p_patient_id" + patient_id  + "p_disp_no " + disp_no + " p_language_id" + language_id);

					onlineReports 		= new ecis.utils.OnlineReports() ;
//					report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
					report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
					report1.addParameter("p_report_id",report_id) ;
					report1.addParameter("p_user_name",login_user) ;
					report1.addParameter("p_facility_id",facility_id) ;
					report1.addParameter("p_disp_date",sysdate) ;
					report1.addParameter("p_patient_id",patient_id) ;							
					report1.addParameter("p_frm_disp_no",disp_no);
					report1.addParameter("p_to_disp_no",disp_no);
					report1.addParameter("p_language_id",language_id) ;
					
					onlineReports.add( report1) ;										
					ReportOutput = onlineReports.execute( request, response );
					report1 = null;			
				}					
				if(report_id.equals("PHHOMMED")){
					onlineReports 		= new ecis.utils.OnlineReports() ;
//					report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
					report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
					report1.addParameter("p_report_id",report_id) ;
					report1.addParameter("p_user_name",login_user) ;
					report1.addParameter("p_facility_id",facility_id) ;
					report1.addParameter("p_disp_date",sysdate) ;
					report1.addParameter("p_patient_id",patient_id) ;							
					report1.addParameter("p_frm_disp_no",disp_no);
					report1.addParameter("p_to_disp_no",disp_no);
					report1.addParameter("p_language_id",language_id) ;
					report1.addParameter("p_disp_locn_code",disp_locn_code);
					onlineReports.add( report1) ;										
					ReportOutput = onlineReports.execute( request, response );
					report1 = null;		
				}
				
				//Added for ML-MMOH-CRF-2042 start		
				if(report_id.equals("PHRDISSHTPNSTD")){
					System.out.println("ML-MMOH-CRF-2042 Validation In Report");
					onlineReports 		= new ecis.utils.OnlineReports() ;
					report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); 
					report1.addParameter("p_report_id",report_id) ;
					report1.addParameter("p_user_name",login_user) ;
					report1.addParameter("p_facility_id",facility_id) ;
					report1.addParameter("p_disp_date",sysdate) ;
					report1.addParameter("p_patient_id",patient_id) ;							
					report1.addParameter("p_module_id","PH");
					report1.addParameter("p_patient_class","IP");
					report1.addParameter("p_language_id",language_id) ;
					report1.addParameter("p_worksheet_id",work_sheet_id) ;
					onlineReports.add( report1) ;										
					ReportOutput = onlineReports.execute( request, response );
					report1 = null;	
				}//Added for ML-MMOH-CRF-2042 ends										
				if(report_id.equals("PHPRRELMS")){
					onlineReports 		= new ecis.utils.OnlineReports() ;
//					report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
					report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867
					report1.addParameter("p_report_id",report_id) ;
					report1.addParameter("p_user_name",login_user) ;
					report1.addParameter("p_facility_id",facility_id) ;
					report1.addParameter("p_disp_date",sysdate) ;
					report1.addParameter("p_patient_id",patient_id) ;							
					report1.addParameter("p_frm_disp_no",disp_no);
					report1.addParameter("p_to_disp_no",disp_no);
					report1.addParameter("p_language_id",language_id) ;
					onlineReports.add( report1) ;										
					ReportOutput = onlineReports.execute( request, response );
					report1 = null;							
				}
				//Condition Modified for the incident num:25576 ==By Naveen on 21/DEC/2010                  
								   
				if(!report_id.equals("PHPRRELMS")&& !report_id.equals("PHCERTREIM")&& !report_id.equals("PHMEDLIST") && !report_id.equals("PHHOMMED") && !report_id.equals("PHRDISSHTPNSTD")){
					onlineReports 	= new ecis.utils.OnlineReports() ;
//					report			= new ecis.utils.OnlineReport( facility_id, module_id,report_id) ;
							report	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867 and changed report1 to report for MMS-KH-CRF-0017.1
					report.addParameter("p_worksheet_id",work_sheet_id) ;
					report.addParameter("p_disp_locn_code",disp_locn_code);
					report.addParameter("p_facility_id",facility_id) ;
					report.addParameter("p_user_name",login_user);
					report.addParameter("p_report_id",report_id);					
					report.addParameter("p_module_id",module_id);
					report.addParameter("p_report_exec_name",report_id);
					report.addParameter("p_language_id",language_id) ;
				
					if(report_id.equals("PHBRMFGLB") || report_id.equals("PHBRMFGTP") || report_id.equals("PHTPNDISPLBF")){
						report.addParameter("p_ord_type",ord_type);
						report.addParameter("p_duration_value",duration_value);
						report.addParameter("p_freq",repeat_value);
					}
					else if(report_id.equals("PHCYTOMFGLB")){
						report.addParameter("p_duration_value",duration_value);
						report.addParameter("p_freq",repeat_value);
					}
					else if(report_id.equals("PHTPNSYGLB")){
						report.addParameter("p_duration_value",duration_value);
					}

					onlineReports.add( report) ;
					ReportOutput = onlineReports.execute( request, response );
				}
			}
			// objects nullified after usage
			putObjectInBean(bean_id_1,beanObj_1,request);
			print_reports	=	null;
		}
		else if(func_mode!= null && func_mode.equals("getLocalLanguage")){
			System.out.println(" ML-MMOH-CRF-2042Validation-----Start67");
			
			/*String	patient_class	=	(String) hash.get("patient_class");
			String bean_id_1			= "DispMedicationBean";
			String bean_name_1			= "ePH.DispMedicationBean";

			DispMedicationBean beanObj_1		= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1, request);
			//	String language = beanObj_1.getDefaultLanguageForDispenseLabel(patient_class);
			putObjectInBean(bean_id_1,beanObj_1,request);	*/ 
		}
		else if(func_mode!= null && func_mode.equals("page_finder")){
			String	patient_id		=	(String) hash.get("patient_id");

			String bean_id_1		= "DispMedicationBean";
			String bean_name_1		= "ePH.DispMedicationBean";
			DispMedicationBean beanObj_1		= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1, request);
			beanObj_1.setLanguageId(locale);
			ArrayList patient_locator	= beanObj_1.getPatientLocator();
			int position				= patient_locator.indexOf(patient_id);
			++position;
			out.println("showPage('"+position+"')");
			putObjectInBean(bean_id_1,beanObj_1,request);
		}
		else if (func_mode !=null && func_mode.equals("GetRemarks")){
			DispMedicationAllStages beanObject =null;
			String code					 = ((String)hash.get("reason")).trim();
			String bean_id_getremarks	 = (String)hash.get("bean_id");
			String bean_name_getremarks  = (String)hash.get("bean_name");			
			String appl_trn_type	 = "H";
			if (!bean_name.equals(""))
			 beanObject		= (DispMedicationAllStages)getBeanObject(bean_id_getremarks, bean_name_getremarks, request);
			beanObject.setLanguageId(locale);

			String remarks = beanObject.checkForNull(beanObject.getRemarks(code,appl_trn_type));	
			remarks=remarks.replaceAll(" ","%20");//added for  SKR-SCF-0155 -IN029192 -start
			remarks = java.net.URLEncoder.encode(remarks,"UTF-8" );
			remarks=remarks.replaceAll("%2520","%20"); //added for  SKR-SCF-0155 -IN029192 -End
			out.println("PaintRemark('"+remarks+"')");
			//out.println("document."+frmObj+".remarks.value=('"+remarks+"')");
			putObjectInBean(bean_id_getremarks,beanObject,request);

		}
		else if(func_mode!= null && func_mode.equals("CHECKMESSAGE")){
			  
			String login_user			=(String) hash.get("LOGIN_USER");
			String patient_id			=(String) hash.get("PATIENT_ID");
			String disp_locn_code		=(String) hash.get("DISP_LOCN_CODE");
			String disp_stage			=(String) hash.get("DISP_STAGE");
			String user_id			    =(String) hash.get("USER_ID");
			String reccount			    =(String) hash.get("RECCOUNT");
			String tmp_reccount			=(String) hash.get("TMP_RECCOUNT");
			
			String row_no			    =(String) hash.get("ROW_NO");
			String sex			        =(String) hash.get("SEX");
			String age			        =(String) hash.get("AGE");

			String GetMessageStatus		="";			
			String bean_id_1		= "DispMedicationBean";
			String bean_name_1		= "ePH.DispMedicationBean";
			
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1, request);
			String allow_disp_record_lock_yn=beanObj_1.getAllow_disp_record_lock_yn();
			if(allow_disp_record_lock_yn.equals("Y")){
				GetMessageStatus		= beanObj_1.getLockStatus(patient_id,disp_locn_code,login_user,disp_stage);
				if(user_id.equals("")){
					ArrayList AccessRight=beanObj_1.getAccessRightStatus(login_user,patient_id,disp_locn_code,disp_stage);
					HashMap AccessRightMap = new HashMap();

					if(AccessRight.size()>0){
						for(int j=0; j<AccessRight.size(); j++){
							AccessRightMap = (HashMap)AccessRight.get(j);
							user_id = (String)AccessRightMap.get("user_id");
							//locked_date_time = (String)AccessRightMap.get("locked_date_time");
						}
					}
				}
			}	out.println("GetLockMessageStatus('"+GetMessageStatus+"','"+user_id+"','"+reccount+"','"+tmp_reccount+"','"+row_no+"','"+sex+"','"+age+"','"+login_user+"','"+patient_id+"','"+disp_locn_code+"','"+disp_stage+"')");
			putObjectInBean(bean_id_1,beanObj_1,request);
		}
		else if(func_mode!= null && func_mode.equals("CHECKUNLOCKRECORDS")){
			String login_user			=(String) hash.get("LOGIN_USER");
			String patient_id			=(String) hash.get("PATIENT_ID");
			String disp_locn_code		=(String) hash.get("DISP_LOCN_CODE");
			String disp_stage			=(String) hash.get("DISP_STAGE");
			String patient_id_status	=(String) hash.get("PATIENT_ID_STATUS");
			String Unlock_status_return ="";
						
			String bean_id_1		= "DispMedicationBean";
			String bean_name_1		= "ePH.DispMedicationBean";
			
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1, request);
			if(beanObj_1.getAllow_disp_record_lock_yn().equals("Y")){
				Unlock_status_return		= beanObj_1.getLockStatus1(login_user,patient_id,disp_locn_code,disp_stage,patient_id_status);
				out.println("Unlock_status_YN('"+Unlock_status_return+"')");
			}
			putObjectInBean(bean_id_1,beanObj_1,request);
		}
		else if(func_mode!= null && func_mode.equals("checklockDeliverystage")){
		
			String login_user			=(String) hash.get("LOGIN_USER");
			String patient_id			=(String) hash.get("FILL_PROC_ID");
			String disp_locn_code		=(String) hash.get("DISP_LOCN_CODE");
			String disp_stage			=(String) hash.get("DISP_STAGE");
			String patient_id_status	="";
			String Delivery_status_return ="";
			String p_delivery_fill_yn ="Y";
						
			String bean_id_1		= "DispMedicationBean";
			String bean_name_1		= "ePH.DispMedicationBean";
			
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1, request);
			if(beanObj_1.getAllow_disp_record_lock_yn().equals("Y")){
				Delivery_status_return		= beanObj_1.getUnlockRecordsDelivery(login_user,patient_id,disp_locn_code,disp_stage,patient_id_status,p_delivery_fill_yn);
				//out.println("Unlock_status_YN_Delivery('"+Unlock_status_return+"')");
			}
			putObjectInBean(bean_id_1,beanObj_1,request);
		}
		else if(func_mode!= null && func_mode.equals("CHECKLOCKREFRESH")){
			String lock_status			=(String) hash.get("LOCK_STATUS");
			String login_user			=(String) hash.get("LOGIN_USER");
			String patient_id			=(String) hash.get("PATIENT_ID");
			String disp_locn_code		=(String) hash.get("DISP_LOCN_CODE");
			String disp_stage			=(String) hash.get("DISP_STAGE");
			String patient_id_status	=(String) hash.get("PATIENT_ID_STATUS");
			String lock_status_return   ="";
			String bean_id_1		= "DispMedicationBean";
			String bean_name_1		= "ePH.DispMedicationBean";
			
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1, request);
			if(beanObj_1.getAllow_disp_record_lock_yn().equals("Y")){
			lock_status_return		= beanObj_1.getLockStatus1(login_user,patient_id,disp_locn_code,disp_stage,patient_id_status);
					//out.println("lockedNormally('"+lock_status_return+"')");
			}
			putObjectInBean(bean_id_1,beanObj_1,request);
		}
		else if(func_mode!= null && func_mode.equals("CHECKLOCK")){
			String lock_status			=(String) hash.get("LOCK_STATUS");
			String login_user			=(String) hash.get("LOGIN_USER");
			String patient_id			=(String) hash.get("PATIENT_ID");
			String disp_locn_code		=(String) hash.get("DISP_LOCN_CODE");
			String disp_stage			=(String) hash.get("DISP_STAGE");
			String patient_id_status	=(String) hash.get("PATIENT_ID_STATUS");
			String lock_status_return   ="";
			
			String bean_id_1		= "DispMedicationBean";
			String bean_name_1		= "ePH.DispMedicationBean";
			
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1, request);
			if(beanObj_1.getAllow_disp_record_lock_yn().equals("Y")){
				lock_status_return		= beanObj_1.getLockStatus1(login_user,patient_id,disp_locn_code,disp_stage,patient_id_status);
				out.println("lockedNormally('"+lock_status_return+"')");
			}
			putObjectInBean(bean_id_1,beanObj_1,request);
		}
		else if(func_mode!= null && func_mode.equals("PINautharizedYN")){
			String	pin						=(String) hash.get("PIN");
			String bean_id_1		= "DispMedicationBean";
			String bean_name_1		= "ePH.DispMedicationBean";
			String pin_autharized_YN		= "";
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1, request);
			beanObj_1.setLanguageId(locale);
			pin_autharized_YN		= beanObj_1.getautharizedyn(pin);
			out.println("PINauthartized_yn('"+pin_autharized_YN+"')");
			putObjectInBean(bean_id_1,beanObj_1,request);
		}
		else if(func_mode!= null && func_mode.equals("ITEMCHARGE_DTLS")){

			/*String	patient_id		= (String) hash.get("patient_id");
			String	encounter_id	= (String) hash.get("encounter_id");
			String	sal_trn_type	= (String) hash.get("sal_trn_type");
			String	item_code		= (String) hash.get("item_code");
			String	item_desc		= (String) hash.get("item_desc");
			String	item_qty		= (String) hash.get("qty"); 
            HashMap msg				= new HashMap();
			String  message			= null;
			msg		= beanObj.callItemChargeDtls(patient_id,encounter_id,sal_trn_type,item_code,item_qty);
			if((String)msg.get("error_msg") !=""){
					message = (String)msg.get("error_id") + "  " + (String)msg.get("error_msg");					
				    out.println("displayErrorMsg('"+message+"')");
			}
			else{
					message = (String)msg.get("insind")+","+(String)msg.get("baseqty")+","+(String)msg.get("baserate")+","+(String)msg.get("basechargeamt")+","+(String)msg.get("grosschargeamt")+","+(String)msg.get("discountper")+","+(String)msg.get("discountamt")+","+(String)msg.get("daytypecode")+","+(String)msg.get("daytypedesc")+","+(String)msg.get("timetypecode")+","+(String)msg.get("timetypedesc")+","+(String)msg.get("addlfactor")+","+item_code+","+item_desc+","+""+","+""+","+(String)msg.get("netchargeamt")+","+(String)msg.get("patgrosschargeamt")+","+(String)msg.get("patdiscamt")+","+(String)msg.get("patnetamt")+","+(String)msg.get("custgrosschargeamt")+","+(String)msg.get("custdiscamt")+","+(String)msg.get("custnewamt");	
					out.println("showchargedetails('"+message+"')");
		   }	*/
		}
		else if(func_mode!= null && func_mode.equals("STORE_BATCH_DET")){
          	String item_code				= (String) hash.get( "item_code" );
			String store_code				= (String) hash.get( "store_code" );
			double req_qty					= Double.parseDouble((String) hash.get( "req_qty" ));
			double act_req_qty				= Double.parseDouble((String) hash.get( "req_qty" ));
			String end_date				    = (String) hash.get( "end_date" );
			String trade_code				= (String) hash.get( "trade_code" );
            String patient_id				= (String) hash.get( "patient_id" );
			String order_id				    = (String) hash.get( "order_id" );
			String barcodeColorYn		    = (String) hash.get( "barcodeColorYn" ); // Added for MMS-DM-SCF-0488
            String order_line_no			= (String) hash.get( "order_line_no" );
            String qty_uom                  = (String) hash.get( "uom" );
			String billing_interface_yn		= (String) hash.get( "billing_interface_yn" );
			String drug_code				= (String) hash.get( "drug_code" );
			String recCount					= (String) hash.get( "recCount" );
			String iss_quantity_uom			= (String) hash.get( "iss_quantity_uom");// Added for for ML-BRU-SCF-1433 [IN:051291
			double act_bms_qty				= Double.parseDouble((String) hash.get( "act_bms_qty" )); //changed from String to Double for SKR-SCF-0377 [IN:030453]
			String base_uom				    = (String) hash.get( "base_uom" ); //added for SKR-SCF-0377 [IN:030453]
			double base_to_disp_uom_equl_val  =  Double.parseDouble((String) hash.get( "base_to_disp_uom_equl_val" )); //added for SKR-SCF-0377 [IN:030453]
            double base_to_def_uom_equl_val  =  Double.parseDouble((String) hash.get( "base_to_def_uom_equl_val" ));//Added for MMS-DM-SCF-0567
			double conv_factor				    = Double.parseDouble((String) hash.get( "conv_factor" )); //added for SKR-SCF-0377 [IN:030453]
			HashMap params					= new HashMap();
			String flag						= "N";
			String	bean_id_2		=	"StUtilities" ;
			String	bean_name_2		=	"eST.Common.StUtilities";
			StUtilities bean_2=null;
			try { 
				bean_2 = (StUtilities) getBeanObject( bean_id_2,  bean_name_2, request );
				bean_2.setLanguageId(locale);
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
			//ArrayList  drug_det =(ArrayList)beanObj.getDrugDetail( patient_id, order_id, order_line_no);
			String bean_id_1		        = "DispMedicationBean";
			String bean_name_1		        = "ePH.DispMedicationBean";
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1, request);
			String fill_list = beanObj_1.getFillList();
            ArrayList stock_det         = new ArrayList();
			ArrayList alloc_drug_detail	=	new ArrayList();
			StringBuffer batch_str      = new StringBuffer();
			double tot_issued_qty			=   0, tot_avail_qty=0; //SKR-SCF-1038 [IN:051884]
			String bar_code_scan_site_YN  = beanObj_1.getBarcodeSiteYN();//Added for MMS-DM-CRF-0157.1
			HashMap scaned_data = new HashMap();//Added for MMs-Dm-CRF-0157.1
			 String temp_batch_id="";//Added for MMs-Dm-CRF-0157.1
			 String entry_type= "";//Added for MMs-Dm-CRF-0157.1
			 String scan_key="";//Added for MMs-Dm-CRF-0157.1
			 HashMap stock = null;//Added for MMS-DM-CRF-0174.5
            String item_cost	     =	beanObj.getItemCost(item_code,store_code,req_qty+"",end_date);
			ArrayList stk_items      =  (ArrayList)beanObj.getStockItems(drug_code);
            HashMap drug_detail		=	beanObj.getDB_DrugDetail(order_id,order_line_no,end_date);
            ArrayList drug_det	    =	(ArrayList)drug_detail.get("main_detail");
            String alloc_fromBarCode = request.getParameter("alloc_fromBarCode")==null?"":request.getParameter("alloc_fromBarCode"); // Added for [IN:064158]
			String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="",act_patient_class="";//Added for MMS-DM-CRF-0170

			if((beanObj_1.getDispStage().equals("F")&&(beanObj_1.getDispLocnCatg().equals("O")))|| beanObj_1.getFillList().equals("AF")){ 
				beanObj_1.setValuesChanged(true);
			}
			if((stk_items.size()>0 && stk_items.get(0).equals("N"))&&(fill_list.equals("AF"))){ // stk_items.size()>0 Added for GHL-SCF-1295 
				for(int k=0;k<drug_det.size();k+=9){
					if(req_qty<=Double.parseDouble((String)drug_det.get(k+3))){
						alloc_drug_detail.add((String)drug_det.get(k));
						alloc_drug_detail.add((String)drug_det.get(k+1));
						alloc_drug_detail.add((String)drug_det.get(k+2));						
						alloc_drug_detail.add(req_qty+"");
						alloc_drug_detail.add(qty_uom);
						alloc_drug_detail.add("");

						alloc_drug_detail.add((String)drug_det.get(k+6));
						alloc_drug_detail.add((String)drug_det.get(k+7));
						alloc_drug_detail.add(item_cost);
						alloc_drug_detail.add(base_uom);//qty_uom is changed as base_uom for [IN:049778]
						batch_str.append((String)drug_det.get(k+6)).append(";").append((String)drug_det.get(k+1)).append(";").append((String)drug_det.get(k+2)).append(";").append((String)drug_det.get(k+7)).append(";").append(act_req_qty+"").append(";");
						tot_issued_qty =tot_issued_qty+req_qty;
					} 
					else{
						alloc_drug_detail.add((String)drug_det.get(k));
						alloc_drug_detail.add((String)drug_det.get(k+1));
						alloc_drug_detail.add((String)drug_det.get(k+2));						
						alloc_drug_detail.add((String)drug_det.get(k+3));
						alloc_drug_detail.add(qty_uom);
						alloc_drug_detail.add("");

						alloc_drug_detail.add((String)drug_det.get(k+6));
						alloc_drug_detail.add((String)drug_det.get(k+7));
						alloc_drug_detail.add(item_cost);
						alloc_drug_detail.add(base_uom);//qty_uom is changed as base_uom for [IN:049778]
						batch_str.append((String)drug_det.get(k+6)).append(";").append((String)drug_det.get(k+1)).append(";").append((String)drug_det.get(k+2)).append(";").append((String)drug_det.get(k+7)).append(";").append(act_req_qty+"").append(";");
						req_qty =req_qty-Double.parseDouble((String)drug_det.get(k+3)); 						    
						tot_issued_qty =tot_issued_qty+Double.parseDouble((String)drug_det.get(k+3));
				   }
				}   
			}
			else{
				if( !(trade_code.equals(""))){
					params.put("ITEM_CODE",item_code+"="+trade_code); 	
				}
				else{
					params.put("ITEM_CODE",item_code);
				}

				params.put("STORE_CODE",store_code);
				params.put("TRN_QTY",req_qty+"");
				params.put("INCLUDE_SUSPENDED","FALSE");
				params.put("INCLUDE_EXPIRED","FALSE");
				params.put("CUT_OFF_DATE",end_date);
				params.put("VERIFY_INSUFFICIENT_QTY","FALSE");
				params.put("ALREADY_USED_QTY","");
				params.put("MIN_EXP_DATE",end_date);
				if(beanObj_1.getBarcode_Scan_YN().equals("Y") && !beanObj_1.getScannedBarcode_id(order_id,order_line_no).equals("") && beanObj_1.getOrderType().equals("NOR")){ // Added for GHL-CRF-0463 - Start // order_id,order_line_no Added for MMS-DM-SCF-0488
					params.put("BARCODE_ID",beanObj_1.getScannedBarcode_id(order_id,order_line_no)); // Added for GHL-CRF-0463 - End // order_id,order_line_no Added for MMS-DM-SCF-0488
				  if(barcodeColorYn.equals("N")){ // Added for MMS-DM-SCF-0488 -Start
					  beanObj_1.setBarcodeColorYn(order_id,order_line_no,"N");
				  } // Added for MMS-DM-SCF-0488 -End
				}
				//System.out.println("Barcode id @@@3428===="+beanObj_1.getScannedBarcode_id(order_id,order_line_no));
				if(beanObj_1.get2DBarcodeApplicable().equals("Y") && !beanObj_1.getScannedBarcode_id(order_id,order_line_no).equals("")){//Added if condition for MMS-DM-CRF-0174.5
								stock = (HashMap)bean_2.get2DBarcodeDetails(params);
				}else{
				             stock	  = (HashMap)bean_2.getBatches(params);
				}
				stock_det         = (ArrayList)stock.get("BATCH_DATA");
				//code for setting batch details in bean
				double avail_qty				    =	0;
				//int already_disp_qty          =   0;
				if(!qty_uom.equals(base_uom) && req_qty>0){ //if block added for SKR-SCF-0377 [IN:030453]
					req_qty= new Double(Math.ceil(((Math.ceil(Double.parseDouble(req_qty+"")/conv_factor))*(conv_factor))/base_to_disp_uom_equl_val)).doubleValue();  
					act_bms_qty= new Double(Math.ceil(((Math.ceil(Double.parseDouble(act_bms_qty+"")/conv_factor))*(conv_factor))/base_to_disp_uom_equl_val)).doubleValue(); 
				}
				String issue_qty				=	"";
				HashMap batch_det			    =	null;
				double req_qty_tmp = 0.0; // Added for GHL-CRF-0463 - Start
				ArrayList alloc_drug_detail_tmp	=	new ArrayList(); 
				double req_qty_batch = 0.0; 
				req_qty_batch = req_qty; // Added for GHL-CRF-0463 -End
                if(beanObj_1.getBatchDetailsForBarcodeDrug().size() > 0 && beanObj_1.getBarcode_Scan_YN().equals("Y") && beanObj_1.getOrderType().equals("NOR") && !beanObj_1.getScannedBarcode_id(order_id,order_line_no).equals("") && req_qty>0){ // if condition Added for GHL-CRF-0463 - Start               	
                	
                	for (int j=0;j<stock_det.size();j++){
    					batch_det =(HashMap)stock_det.get(j);
    					 avail_qty			= Double.parseDouble((String)batch_det.get("AVAIL_QTY"));
    					if(!qty_uom.equals(base_uom)){ 
                         avail_qty  =  avail_qty/base_to_disp_uom_equl_val;
    					}
    				}
                	alloc_drug_detail = beanObj_1.getBatchDetailsForBarcodeDrug();		
                	
					if(req_qty > avail_qty){
						 issue_qty =avail_qty+"";
						 tot_issued_qty = tot_issued_qty+Double.parseDouble(issue_qty); 
					}
					else{
						 issue_qty =req_qty+"";    
						 tot_issued_qty = tot_issued_qty+Double.parseDouble(issue_qty);
						 if(!qty_uom.equals(base_uom)){
							 req_qty= new Double(Math.ceil(req_qty*base_to_disp_uom_equl_val)).doubleValue();
							 issue_qty =req_qty+"";
						 }
					}
					    tot_avail_qty = tot_avail_qty+avail_qty;
					    boolean last_scan_exist = false;
                		for (int j=0;j<alloc_drug_detail.size();j+=10){
                			if(((req_qty >= req_qty_tmp) && (j<(alloc_drug_detail.size()-10)))){
                				req_qty_tmp = req_qty_tmp+Double.parseDouble(alloc_drug_detail.get(j+3).toString());
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+0));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+1));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+2));
                				if(req_qty<=Double.parseDouble(alloc_drug_detail.get(j+3).toString()))
                					alloc_drug_detail_tmp.add(Double.toString(req_qty));
                				else
                				    alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+3));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+4));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+5));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+6));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+7));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+8));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+9));
                			}
                			else if(req_qty > req_qty_tmp && alloc_drug_detail.get(j+1).equals(batch_det.get("BATCH_ID")) && alloc_drug_detail.get(j+0).equals(batch_det.get("ITEM_CODE")) && alloc_drug_detail.get(j+2).equals(batch_det.get("EXPIRY_DATE")) ){
                				last_scan_exist = true;
                				alloc_drug_detail_tmp.add(alloc_drug_detail.get(j+0));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+1));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+2));
                				alloc_drug_detail_tmp.add(Double.toString(req_qty-req_qty_tmp));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+4));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+5));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+6));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+7));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+8));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+9));
                			}
                			else if(req_qty > req_qty_tmp){
                				alloc_drug_detail_tmp.add(alloc_drug_detail.get(j+0));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+1));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+2));  
               			
                				if((req_qty-req_qty_tmp)<=Double.parseDouble(alloc_drug_detail.get(j+3).toString()))
                					alloc_drug_detail_tmp.add(Double.toString(req_qty-req_qty_tmp));
                				else
                				    alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+3));
                				
                				req_qty = req_qty - Double.parseDouble(alloc_drug_detail.get(j+3).toString());
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+4));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+5));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+6));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+7));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+8));
                				alloc_drug_detail_tmp.add((String)alloc_drug_detail.get(j+9));
                			}			                 		
                 	}
                	          if(req_qty > req_qty_tmp && !last_scan_exist) {             			
            				alloc_drug_detail_tmp.add(batch_det.get("ITEM_CODE"));
          				    alloc_drug_detail_tmp.add(batch_det.get("BATCH_ID"));
          				    alloc_drug_detail_tmp.add(batch_det.get("EXPIRY_DATE"));
          				    alloc_drug_detail_tmp.add(Double.toString(req_qty-req_qty_tmp));
          				    if(!qty_uom.equals(base_uom)){
          					   alloc_drug_detail_tmp.add(qty_uom);
      					    }
      					    else{
      						  alloc_drug_detail_tmp.add(base_uom);
      					    }
          				    alloc_drug_detail_tmp.add("");
          				    alloc_drug_detail_tmp.add(batch_det.get("TRADE_ID"));
          				    alloc_drug_detail_tmp.add(batch_det.get("BIN_LOCATION_CODE"));
          				    alloc_drug_detail_tmp.add(item_cost);
          				    alloc_drug_detail_tmp.add(base_uom);	
            		}
                	req_qty_batch = req_qty_batch - req_qty_tmp;
                		
                	if(req_qty_batch > avail_qty){
                		alloc_drug_detail_tmp.clear();
                		alloc_drug_detail.clear();              			                 			
                		tot_issued_qty = 0.0;
                		beanObj_1.setScannedBarcode_id(order_id,order_line_no,""); // order_id and order_line_no changed Added for MMS-DM-SCF-0488
                		beanObj_1.setBarcode_id("");
                		out.println("clearlastScanned('"+recCount+"')"); // recCount Added for MMS-DM-SCF-0488
                		out.println("alert(getMessage('QUANTITY_NOT_AVAILABLE','PH'));");
                			
                		if(params.containsKey("BARCODE_ID")){
                			 params.remove("BARCODE_ID");
                		}
            			params.put("TRN_QTY","1");
            				
            			stock	  = (HashMap)bean_2.getBatches(params);
            			stock_det = (ArrayList)stock.get("BATCH_DATA");
                           
            			for (int j=0;j<stock_det.size();j++){
            				 batch_det =(HashMap)stock_det.get(j);
            				alloc_drug_detail.add(batch_det.get("ITEM_CODE"));
            				alloc_drug_detail.add(batch_det.get("BATCH_ID"));
            				alloc_drug_detail.add(batch_det.get("EXPIRY_DATE"));
            				alloc_drug_detail.add(Double.toString(tot_issued_qty));
            				if(!qty_uom.equals(base_uom)){
            						alloc_drug_detail.add(qty_uom);
            				}
            				else{
            						alloc_drug_detail.add(base_uom);
            				}
            				alloc_drug_detail.add("");
            				alloc_drug_detail.add(batch_det.get("TRADE_ID"));
            				alloc_drug_detail.add(batch_det.get("BIN_LOCATION_CODE"));
            				alloc_drug_detail.add(item_cost);
            				alloc_drug_detail.add(base_uom);
            			}
                	}
                	else{
                			tot_avail_qty  = req_qty_batch+req_qty_tmp;
                			if(req_qty > avail_qty)
                 			   tot_issued_qty =  tot_avail_qty;
                	}

                if(alloc_drug_detail_tmp.size()>0){
                			alloc_drug_detail = alloc_drug_detail_tmp;
                }
               } // if condition Added for GHL-CRF-0463 - End
			else{
				for (int j=0;j<stock_det.size();j++){
					batch_det =(HashMap)stock_det.get(j);
					alloc_drug_detail.add(batch_det.get("ITEM_CODE"));
					alloc_drug_detail.add(batch_det.get("BATCH_ID"));
					alloc_drug_detail.add(batch_det.get("EXPIRY_DATE"));

					/*for(int k=0;k<drug_det.size();k+=9){
						if(((String)batch_det.get("ITEM_CODE")).equals((String)drug_det.get(k))&& ((String)batch_det.get("BATCH_ID")).equals((String)drug_det.get(k+1)) && ((String)batch_det.get("EXPIRY_DATE")).equals((String)drug_det.get(k+2)) && ((String)batch_det.get("TRADE_ID")).equals((String)drug_det.get(k+6))&& ((String)batch_det.get("BIN_LOCATION_CODE")).equals((String)drug_det.get(k+7))){
							already_disp_qty = Integer.parseInt( (String)drug_det.get(k+3));
						}
					}*/
					// avail_qty			= Integer.parseInt((String)batch_det.get("AVAIL_QTY"))+already_disp_qty;
					avail_qty			= Double.parseDouble((String)batch_det.get("AVAIL_QTY"));
					if(!qty_uom.equals(base_uom)){ //if block added for SKR-SCF-0377 [IN:030453]
                    	avail_qty  =  Math.round(avail_qty/base_to_disp_uom_equl_val);
					}
					if(req_qty> avail_qty){
						 req_qty =req_qty - avail_qty;
						 if(!qty_uom.equals(base_uom)){//Addign start for MMS-DM-SCF-0570
						   avail_qty =new Double(Math.ceil(avail_qty*base_to_disp_uom_equl_val)).doubleValue();
						 }//Adding end for MMS-DM-SCF-0570
						 issue_qty =avail_qty+"";
						 tot_issued_qty = tot_issued_qty+Double.parseDouble(issue_qty); //added for SKR-SCF-0377 [IN:030453]
					}
					else{
						 issue_qty =req_qty+"";    
						 //tot_issued_qty = tot_issued_qty+Double.parseDouble(issue_qty);//added for SKR-SCF-0377 [IN:030453]//commented for ML-BRU-SCF-1798
						 if(!qty_uom.equals(base_uom)){//if added for [IN:049778]
							 req_qty= new Double(Math.ceil(req_qty*base_to_disp_uom_equl_val)).doubleValue();
							 issue_qty =req_qty+"";
							if(base_to_def_uom_equl_val != base_to_disp_uom_equl_val){//Added if condition for MMS-DM-SCF-0567
							 tot_issued_qty = tot_issued_qty+Double.parseDouble(issue_qty);//SCF-1798
							 }else{
								 tot_issued_qty = tot_issued_qty+Double.parseDouble(issue_qty);
							 }
						 }else{
							 tot_issued_qty = tot_issued_qty+Double.parseDouble(issue_qty);
						 }
					}
					// tot_issued_qty = tot_issued_qty+Double.parseDouble(issue_qty);//commented for  SKR-SCF-0377 [IN:030453]
					tot_avail_qty = tot_avail_qty+avail_qty; //added for SKR-SCF-1038 [IN:051884]
					if(!qty_uom.equals(base_uom)){//if condition and else block added for MMS-SCF-0040 [IN:041888], AAKH-SCF-0113 [IN:048937] - change Issue UOM
						alloc_drug_detail.add(issue_qty);
						alloc_drug_detail.add(qty_uom);
					}
					else{
						alloc_drug_detail.add((String)batch_det.get("QTY"));
						alloc_drug_detail.add(base_uom);
					}
					alloc_drug_detail.add("");
					alloc_drug_detail.add(batch_det.get("TRADE_ID"));
					alloc_drug_detail.add(batch_det.get("BIN_LOCATION_CODE"));
					alloc_drug_detail.add(item_cost);
					alloc_drug_detail.add(base_uom);//qty_uom is changed as base_uom for [IN:049778]
					//trade;batchid,exp_date,bin_loc,req_qty 
				  	batch_str.append((String)batch_det.get("TRADE_ID")).append(";").append((String)batch_det.get("BATCH_ID")).append(";").append((String)batch_det.get("EXPIRY_DATE")).append(";").append((String)batch_det.get("BIN_LOCATION_CODE")).append(";").append(issue_qty+"").append(";");
				}
			 }
			}
			if(tot_issued_qty<=act_req_qty){
				flag="N";
			}
			else{
				flag="Y";
			}    
			double tot_issue_qty_val = 0;//ML-BRU-SCF-1798 - start
			
			if(!base_uom.equals(qty_uom)){
				tot_issued_qty = Math.floor(tot_issued_qty/base_to_disp_uom_equl_val);//Changed tot_issued_qty_val to tot_issued_qty for MMS-DM-SCF-0564
			}else{
				tot_issued_qty = tot_issued_qty;//Changed tot_issued_qty_val to tot_issued_qty for MMS-DM-SCF-0564
			}//ML-BRU-SCF-1798 - end
			//beanObj.setIssueUomQty(order_id+order_line_no+drug_code+"_qty",tot_issued_qty+""); //Added for Issue UOM// Added for for ML-BRU-SCF-1433 [IN:051291
			//beanObj.setIssueUomQty(order_id+order_line_no+drug_code+"_equl",conv_factor+""); //Added for Issue UOM// Added for for ML-BRU-SCF-1433 [IN:051291
			if(alloc_fromBarCode.equals("N") && beanObj_1.getBarcode_Scan_YN().equals("Y")) // Added for [IN:064158]
            	beanObj_1.setBatchDetailsForBarcodeDrug(alloc_drug_detail); // Added for [IN:064158]
			beanObj.setDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail);//Added for ML-BRU-SCF-1433 [IN:051291
			beanObj.setDrugQuantity(patient_id,order_id,order_line_no,tot_issued_qty);//Added for ML-BRU-SCF-1433 [IN:051291 // tot_issued_qty changed to tot_issue_qty_val for ML-BRU-SCF-1851 
			if(qty_uom.equals(base_uom) &&  tot_avail_qty > act_req_qty){	//Added if blockcondition for KAIH-SCF-0094[Inc:35252]// &&  tot_avail_qty > act_req_qty added for SKR-SCF-1038 [IN:051884]
				tot_issued_qty=act_req_qty;
			}

		//	if( !qty_uom.equals(base_uom)){//else if block added MMS-SCF-0040 [IN:041888], AAKH-SCF-0113 [IN:048937] - change Issue UOM//Changed base_uom to iss_quantity_uom and removed else for ML-BRU-SCF-1433 [IN:051291] //qty_uom.equals(base_uom) &&Added for MMS-DM-SCF-0567
		 		//tot_issued_qty  =   Math.floor(tot_issued_qty/conv_factor); 
			//	act_bms_qty  =   Math.floor(act_bms_qty/conv_factor);//commented for  ML-BRU-SCF-1433 [IN:051291] (It is not direct scenario)
			//}
			//System.err.println("tot_issued_qty@@@==="+tot_issued_qty+"conv_factor==="+conv_factor);
		 /*	if( !qty_uom.equals(iss_quantity_uom)){//else if block added MMS-SCF-0040 [IN:041888], AAKH-SCF-0113 [IN:048937] - change Issue UOM//Changed base_uom to iss_quantity_uom and removed else for ML-BRU-SCF-1433 [IN:051291] //qty_uom.equals(base_uom) &&Added for MMS-DM-SCF-0567
		 		tot_issued_qty  =   Math.floor(tot_issued_qty/conv_factor); 
			//	act_bms_qty  =   Math.floor(act_bms_qty/conv_factor);//commented for  ML-BRU-SCF-1433 [IN:051291] (It is not direct scenario)
			}*/
			beanObj.setIssueUomQty(order_id+order_line_no+drug_code+"_qty",tot_issued_qty+""); //Added for Issue UOM
			beanObj.setIssueUomQty(order_id+order_line_no+drug_code+"_equl",conv_factor+""); //Added for Issue UOM  //commented  for ML-BRU-SCF-1433 [IN:051291] 

			/*beanObj.setDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail);
			beanObj.setDrugQuantity(patient_id,order_id,order_line_no,tot_issued_qty);*///commented  for ML-BRU-SCF-1433 [IN:051291] 
		//	if(!qty_uom.equals(base_uom)) //ML-BRU-SCF-1798//Commented for MS-DM-SCF-0567
			//tot_issued_qty  =   Math.floor(tot_issued_qty*conv_factor); //Commented for MS-DM-SCF-0567
			beanObj_1.setStockDtlKey(order_id+"~"+order_line_no+"~"+drug_code,tot_issued_qty+"");//Added for KDAH-CRF-0231 [IN-034551].
			beanObj_1.setOrderDrugdtl(order_id+"~"+order_line_no);//Added for KDAH-CRF-0231 [IN-034551].
			//if(!qty_uom.equals(base_uom))//ML-BRU-SCF-1798//Commented for MS-DM-SCF-0567
			//tot_issued_qty  =   Math.floor(tot_issued_qty/conv_factor);//Commented for MS-DM-SCF-0567
			
			out.println("SetBmsQuantity('"+tot_issued_qty+"','"+recCount+"','"+act_bms_qty+"')"); //moved from down for SKR-SCF-1038 [IN:051884]
			if(billing_interface_yn.equals("Y")){
				if(!qty_uom.equals(base_uom))// Added for SKR-SCF-1036 While changing qty, item cost is showing wrong
					tot_issued_qty= new Double(Math.ceil(tot_issued_qty*base_to_disp_uom_equl_val)).doubleValue();
				out.println("getBillingDetails('"+flag+"','"+order_id+"','"+order_line_no+"','"+drug_code+"','"+tot_issued_qty+"','"+batch_str.toString()+"','"+recCount+"','"+act_bms_qty+"')");
			}
			//Adding start for MMS-DM-CRF-0157.1
		//	System.err.println("batch_str.toString()@@@======"+batch_str.toString()+"bar_code_scan_site_YN==="+bar_code_scan_site_YN+"alloc_drug_detail@@@=="+alloc_drug_detail+"stock_det@@@@======="+stock_det+"beanObj_1.getBarCodeScanedData()=="+beanObj_1.getBarCodeScanedData());
			if(bar_code_scan_site_YN.equals("Y")){
//Adding start for MMS-DM-CRF-0170
				  act_patient_class     =  beanObj.getEncounterPatientClass(beanObj_1.getEncounterID(), patient_id);//Added for MMS-DM-CRF-0170
				  if(act_patient_class.equals("I"))
						act_patient_class  ="IP";
					else if(act_patient_class.equals("O"))
						act_patient_class  ="OP";
					else if(act_patient_class.equals("E"))
						act_patient_class  ="EM";
					else if(act_patient_class.equals("D"))
						act_patient_class  ="DC";
					else if(act_patient_class.equals("R"))
						act_patient_class  ="XT";

				ArrayList scanCountSetup    = beanObj_1.getScanCountReqForPatientClass(act_patient_class,"DISPENSE_MEDICATION");
				  if(scanCountSetup.size()>0){
					  scan_count_required_yn = (String)scanCountSetup.get(0);
					  alert_required_yn      = (String)scanCountSetup.get(1);
					  remarks_required_yn    = (String)scanCountSetup.get(2);
				}
			//	System.err.println("scan_count_required_yn@@==="+scan_count_required_yn+"alert_required_yn=="+alert_required_yn+"remarks_required_yn==="+remarks_required_yn);
				if( scan_count_required_yn.equals("Y")){//Adding end for MMS-DM-CRF-0170
				 String scan_count_inc ="";
				 HashMap temp_batch_data =new HashMap();
				 scaned_data = beanObj_1.getBarCodeScanedData();
				 for (int j=0;j<stock_det.size();j++){
    					temp_batch_data =(HashMap)stock_det.get(j);
				        temp_batch_id = (String)temp_batch_data.get("BATCH_ID");
					    scan_key=order_id+"~"+order_line_no+"~"+drug_code+"~"+temp_batch_id;
						if(!scaned_data.containsKey(scan_key)){
							beanObj_1.setBarCodeScanedData(scan_key, "M");
                               scan_count_inc="Y";
						}
				 }
				
				 
//				System.err.println("scan_key@@@==="+scan_key+"scan_count_inc==="+scan_count_inc);
				if(scan_count_inc.equals("Y")){//alert_required_yn added for MMS-DM-CRF-0170
				
				
				System.err.println("beanObj_1.getBarCodeScanedData()@@@@==="+beanObj_1.getBarCodeScanedData());
			  if (alert_required_yn.equals("Y")){ out.println("callManualScanRemarks('"+patient_id+"','"+beanObj_1.getEncounterID()+"','"+beanObj_1.getDispStage()+"','"+order_id+"','"+order_line_no+"','"+drug_code+"','"+temp_batch_id+"','"+act_patient_class+"','"+remarks_required_yn+"')");//act_patient_class,remarks_required_yn Added for MMS-DM-CRF-0170

              }else{
			   out.println("scanBarcodeCount('"+patient_id+"','"+beanObj_1.getEncounterID()+"','"+beanObj_1.getDispStage()+"','"+order_id+"','"+order_line_no+"','"+drug_code+"','"+temp_batch_id+"','M','"+act_patient_class+"')");//entry_type,act_patient_calss added for MMS-DM-CRF-0170 entity type repaced with M for testing issue raised by MMS
			  }
		   }
		  }
				//Ading end for MMS-DM-CRF-0157.1
						   


				//			}
			  //}
		}
			/*else{ //moved up for SKR-SCF-1038 [IN:051884]
				out.println("SetBmsQuantity('"+tot_issued_qty+"','"+recCount+"','"+act_bms_qty+"')");
			}*/
		}
		else if(func_mode!= null && func_mode.equals("GETBLDETAILS")){
			String bean_id_1		        = "DispMedicationBean";
			String bean_name_1		        = "ePH.DispMedicationBean";
			String disp_locn_code	        =  (String) hash.get("disp_locn_code");
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1, request);

			String disp_cash_coll_stage		= beanObj_1.getDispCashCollStage();
			if(disp_cash_coll_stage.equals("D")){
			    out.println("callbillingwindow('"+beanObj_1.getBILLING_DET()+"','"+disp_locn_code+"')");
			}
			else{
                out.println("clearframes()");
			}
			putObjectInBean(bean_id_1,beanObj_1,request);
		}
		else if(func_mode!= null && func_mode.equals("Setmodified_date")){
			String bean_id_1		        = "DispMedicationBean";
			String bean_name_1		        = "ePH.DispMedicationBean";
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1, request);
			String order_id	                =  (String) hash.get("order_id");
			beanObj_1.getModified_date(order_id);	

			HashMap Order_id_amend_yn =(HashMap)beanObj_1.getOrder_id_amend_yn();
			Order_id_amend_yn.put(order_id,"Y");
			putObjectInBean(bean_id_1,beanObj_1,request);
		}
		else if(func_mode!= null && func_mode.equals("ChangeDefaultUOM")){
			String strDefaultIssueUOM	= (String) hash.get("DefaultIssueUOM");
			String strKey				= (String) hash.get("Key");
			beanObj.setIssueUomQty(strKey,strDefaultIssueUOM);
		}	
		else if(func_mode!= null && func_mode.equals("setIssueUom")){//added for AAKH-SCF-0338
			String strDefaultIssueUOM	= (String) hash.get("DefaultIssueUOM");
			String strKey				= (String) hash.get("Key");
			beanObj.setIssueUomQty(strKey,strDefaultIssueUOM);
		}
		else if(func_mode!= null && func_mode.equals("clearAlBMSOrderIds")){
			String bean_id_1		        = "DispMedicationBean";
			String bean_name_1		        = "ePH.DispMedicationBean";
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1, request);
			beanObj_1.clearAlBMSOrderIds();
			beanObj_1.setHmAllocBmsChk(new HashMap());
			beanObj_1.resetBConsuableItemAvailable();
			putObjectInBean(bean_id_1,beanObj_1,request);
		}
		else if(func_mode!= null && func_mode.equals("changeLocalInstr")){
			beanObj	= (DispMedicationAllStages)getBeanObject(bean_id, bean_name, request);
			String iLabelPairs			= (String) hash.get("iLabelPairs");
			String lang_id				= (String) hash.get("locale");
			String formObj				= (String) hash.get("formObj");
			String instr				= (String) hash.get("instr");
			String instr_type			= (String) hash.get("instr_type");
			String loc_instr_txt = beanObj.getLocalInstr(instr,lang_id);
			loc_instr_txt=loc_instr_txt.replaceAll(" ","%20");
			loc_instr_txt = java.net.URLEncoder.encode(loc_instr_txt,"UTF-8");
			loc_instr_txt=loc_instr_txt.replaceAll("%2520","%20");
			/*if(instr_type.equals("C")){
				out.println("eval(document."+formObj+".loc_caution_1_"+iLabelPairs+").value=\""+loc_instr_txt+"\""); 
				//Added backslash "\" handling Spl character regarding incident number 20846
			}else{
				out.println("eval(document."+formObj+".loc_special_1_"+iLabelPairs+").value=\""+loc_instr_txt+"\"");
																													
			}*/
			out.println("assignLocaltxt('"+instr_type+"','"+iLabelPairs+"','"+loc_instr_txt+"');");
			putObjectInBean(bean_id,beanObj,request);
		}		
		else if (func_mode !=null && func_mode.equals("storage_locn")){	//added for Bru-HIMS-CRF-142 [IN:030195] - start
			DispMedicationAllStages beanObject =null;
			String disp_locn_code	= hash.get("disp_locn_code") == null?"":((String)hash.get("disp_locn_code")).trim();
			String str_locn			= hash.get("str_locn") == null?"":((String)hash.get("str_locn")).trim();
			String curr_stage		= hash.get("curr_stage") == null?"":((String)hash.get("curr_stage")).trim();
			String token_series		= hash.get("token_series") == null?"":((String)hash.get("token_series")).trim();  
			String patient_arvd		= hash.get("patient_arvd") == null?"":((String)hash.get("patient_arvd")).trim();  
			String patient_id		= hash.get("patient_id") == null?"":((String)hash.get("patient_id")).trim();
			String encounter_id		= hash.get("encounter_id") == null?"":((String)hash.get("encounter_id")).trim();//Added for TH-KW-CRF-0020.9
			String delivery_bin_yn		= hash.get("delivery_bin_yn") == null?"":((String)hash.get("delivery_bin_yn")).trim();//Added for TH-KW-CRF-0020.9
			if(str_locn == null) {str_locn = "";}

			bean_id	  = (String)hash.get("bean_id");
			bean_name  = (String)hash.get("bean_name");			

			if (!bean_name.equals(""))
				beanObject		= (DispMedicationAllStages)getBeanObject(bean_id, bean_name, request);
			beanObject.setStorageLocn(patient_id,disp_locn_code,str_locn,curr_stage,token_series,patient_arvd,delivery_bin_yn,encounter_id);	
			putObjectInBean(bean_id,beanObject,request);
		}
		else if (func_mode !=null && func_mode.equals("storage_locn1")){
			DispMedicationAllStages beanObject =null;
			String disp_locn_code			= hash.get("disp_locn_code") == null?"":((String)hash.get("disp_locn_code")).trim();
			String str_locn			= hash.get("str_locn") == null?"":((String)hash.get("str_locn")).trim();
			String curr_stage		= hash.get("curr_stage") == null?"":((String)hash.get("curr_stage")).trim();
			String token_series		= hash.get("token_series") == null?"":((String)hash.get("token_series")).trim();  
			String patient_arvd		= hash.get("patient_arvd") == null?"":((String)hash.get("patient_arvd")).trim();  
			String patient_id		= hash.get("patient_id") == null?"":((String)hash.get("patient_id")).trim();
            String Orderresult_id	= hash.get("Orderresult_id") == null?"":((String)hash.get("Orderresult_id")).trim();
			String token_no ="";
			String delivery_bin_yn		= hash.get("delivery_bin_yn") == null?"":((String)hash.get("delivery_bin_yn")).trim();//Added for TH-KW-CRF-0020.9
			String encounter_id		= hash.get("encounter_id") == null?"":((String)hash.get("encounter_id")).trim();//Added for TH-KW-CRF-0020.9
		
			ArrayList arrTokenList = new ArrayList();//Added for HSA-CRF-0136 [IN:048412]
			if(str_locn == null) 
				str_locn = "";

			bean_id	  = (String)hash.get("bean_id");
			bean_name  = (String)hash.get("bean_name");		
			String bean_id_1	  = (String)hash.get("bean_id_1");
			String bean_name_1  = (String)hash.get("bean_name_1");		
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1, request);
			token_no	= beanObj_1.getTokenNo();
			if(token_series.equals("*A"))//Added for HSA-SCF-0081 [IN:050227]
				token_series="";
			if((token_no!=null || !token_no.equals("")) && !token_series.equals("") )//Condition && !token_series.equals("") added for HSA-CRF-0136 [IN:048412]
				beanObject.setTokenVals(Orderresult_id,token_series+"_"+token_no);//Moved here for HSA-CRF-0136 [IN:048412]
			if(token_no==null || token_no.equals("") || token_series.equals("")){//Condition || token_series.equals("") added for HSA-CRF-0136 [IN:048412]
				arrTokenList	=	beanObj_1.getTokenDetails(disp_locn_code,patient_id,token_series,Orderresult_id);//Changed as ArrayList for HSA-CRF-0136 [IN:048412]
				if(arrTokenList!=null && arrTokenList.size()>0){//Added for HSA-CRF-0136 [IN:048412] start
					beanObject.setTokenVals(Orderresult_id, (String)arrTokenList.get(0)+"_"+(String)arrTokenList.get(1));
					token_series = (String)arrTokenList.get(0);
				}//Added for HSA-CRF-0136 [IN:048412] end
			}
			beanObject		= (DispMedicationAllStages)getBeanObject(bean_id, bean_name, request);	
			//beanObject.setTokenVals(Orderresult_id,token_no); //commented for for HSA-CRF-0136 [IN:048412] 
			beanObject.setStorageLocn(patient_id,disp_locn_code,str_locn,curr_stage,token_series,patient_arvd,delivery_bin_yn,encounter_id);//Added delivery_bin_yn,encounter_id for TH-KW-CRF-0020.9	
			putObjectInBean(bean_id,beanObject,request);
			putObjectInBean(bean_id_1,beanObj_1,request);
		}//added for Bru-HIMS-CRF-142 [IN:030195] - End
		else if(func_mode!= null && func_mode.equals("storeAlloc")) {//Added for KDAH-CRF-0231 [IN-034551] - Start
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject("DispMedicationBean", "ePH.DispMedicationBean", request);
			String patient_id	 = (String)hash.get("patient_id");
			String alloc_tot_qty	 = (String)hash.get("alloc_tot_qty");//Added for KDAH-CRF-0231 [IN-034551]
			String bms_tot_qty	 = (String)hash.get("bms_tot_qty");//Added for KDAH-CRF-0231 [IN-034551]
			ArrayList temp_alloc_drug_detail=null;
			ArrayList batch_list1=new ArrayList();
			String order_id="";
			String order_line_no="";
			double quantity=1.0;
			String batch_id="";
			String item_drug_code="", item_cost, qty_uom, expiry_date, trade_id, trade_name, bin_locn_code, temp_batch;
			ArrayList batch_list =null;
			HashMap batch_map = null;
			HashMap temp_batch_map = null;
			String[] batch_str = null;
			if(!beanObj_1.getStockDtl().containsKey("autoalloc")){
				Iterator batch_val=beanObj_1.getBatch_val().iterator();
				while(batch_val.hasNext()){
					batch_list=(ArrayList)batch_val.next();
					batch_map=(HashMap)batch_list.get(0);
					item_cost="";
					qty_uom="";
					item_drug_code		=	(String)batch_map.get("ITEM_CODE");	
					expiry_date			=	(String)batch_map.get("EXPIRY_DATE");	
					batch_id			=	(String)batch_map.get("BATCH_ID");	
					trade_id			=	(String)batch_map.get("TRADE_ID");	
					trade_name			=	(String)batch_map.get("TRADE_NAME");	
					bin_locn_code		=	(String)batch_map.get("BIN_LOCATION_CODE");
					 
					temp_batch_map=beanObj_1.getTempStockDtls();
					if(temp_batch_map.containsKey(item_drug_code+"~"+batch_id)){
						
						 if(!beanObj_1.getStockDtl().containsKey("allocated"+item_drug_code+batch_id)){//Added for KDAH-CRF-0231 [IN-034551]. -start
							batch_list1.add(batch_list);
						}
						beanObj_1.setStockDtlKey("barcode_applicable"+item_drug_code,"N");//Added for KDAH-CRF-0231 [IN-034551]. -end
						
						temp_batch=temp_batch_map.get(item_drug_code+"~"+batch_id).toString();
						batch_str=temp_batch.split("~");
						order_id=batch_str[0];
						order_line_no=batch_str[1];
						if(beanObj_1.getStockDtl().containsKey(item_drug_code+"qty")){
							quantity=Double.parseDouble(beanObj_1.getStockDtl().get(item_drug_code+"qty").toString());//Added for KDAH-CRF-0231 [IN-034551]
						}
						else{
							quantity=Double.parseDouble(batch_str[2].toString());
						}
						item_cost=batch_str[3];
						qty_uom=batch_str[4];
						temp_alloc_drug_detail=new ArrayList();
						temp_alloc_drug_detail.add(item_drug_code);
						temp_alloc_drug_detail.add(batch_id);
						temp_alloc_drug_detail.add(expiry_date);
						temp_alloc_drug_detail.add((int)(quantity)+"");
						temp_alloc_drug_detail.add(qty_uom);
						temp_alloc_drug_detail.add("");
						temp_alloc_drug_detail.add(trade_id);
						temp_alloc_drug_detail.add(bin_locn_code);
						temp_alloc_drug_detail.add(item_cost);
						temp_alloc_drug_detail.add(batch_str[5]);//qty_uom is changed as batch_str[5] for [IN:049778]
					 }
					 beanObj_1.getStockDtl().remove("batchqty"+item_drug_code+batch_id);//Added for KDAH-CRF-0231 [IN-034551]
				}//Added for KDAH-CRF-0231 [IN-034551].
				beanObj.setDrugDetail(patient_id,order_id,order_line_no,temp_alloc_drug_detail);
				beanObj.setDrugQuantity(patient_id,order_id,order_line_no,quantity);
				if(!(beanObj_1.getStockDtl().containsKey("allocated"+item_drug_code+batch_id) && beanObj_1.getStockDtl().get("allocated"+item_drug_code+batch_id).equals(item_drug_code))){
					Iterator batch_val1=batch_list1.iterator();
					while (batch_val1.hasNext()){
						ArrayList batch_temp=(ArrayList)batch_val1.next();							  
						if(beanObj_1.getBatch_val().contains(batch_temp)){
							beanObj_1.getBatch_val().remove(batch_temp);
						}
					}
				}  
				//Added for KDAH-CRF-0231 [IN-034551].
				beanObj_1.getBatch_val().clear();//Added for KDAH-CRF-0231 [IN-034551]
			}
			else{
				beanObj_1.getStockDtl().remove("autoalloc");
			}
		}
		else if(func_mode!= null && func_mode.equals("callAllocate")) {
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject("DispMedicationBean", "ePH.DispMedicationBean", request);
			if(!beanObj_1.getOrderType().equals("NOR")) // if condition added for GHL-CRF-0463
			beanObj_1.setBarcode_id("");
			beanObj_1.getBatch_val().clear();//Added for KDAH-CRF-0231 [IN-034551]
		}
		else if(func_mode!= null && func_mode.equals("clear_allocate")) {
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject("DispMedicationBean", "ePH.DispMedicationBean", request);
			 beanObj_1.getStockDtl().remove("autoalloc");
		}//Added for KDAH-CRF-0231 [IN-034551] - End
		else if(func_mode!= null && func_mode.equals("GET_VALID_BARCODE")){//Added for KDAH-CRF-0231 [IN-034551]. - Start
		    String bean_id_1		        = "DispMedicationBean";
			String bean_name_1		        = "ePH.DispMedicationBean";
			String disp_locn_code	        =  (String) hash.get("disp_locn_code");
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1, request);
			String bean_all_id	 = (String)hash.get("bean_all_id");
			String bean_all_name = (String)hash.get("bean_all_name");
			beanObj		= (DispMedicationAllStages)getBeanObject(bean_all_id,bean_all_name,request);
			String patient_id				= (String) hash.get( "patient_id" );
			String barcode_id				= (String) hash.get( "barcode_id" );
			ArrayList result		=	null;
			ArrayList orderLineDtls	=	new ArrayList();
			HashMap hmOrderLineDtls = new HashMap();
			ArrayList items=new ArrayList();
			String order_id=(String) hash.get( "order_id" )==null?"":(String) hash.get( "order_id" );
			String order_line_no=(String) hash.get( "order_line_num" )==null?"":(String) hash.get( "order_line_num" );
			String calledFrom=(String) hash.get( "calledFrom" )==null?"":(String) hash.get( "calledFrom" );
			String alt_drug_code=(String) hash.get( "alt_drug_code" )==null?"":(String) hash.get( "alt_drug_code" );
			String allowMoreQtyConfirmed=(String) hash.get( "allowMoreQtyConfirmed" )==null?"":(String) hash.get( "allowMoreQtyConfirmed" );
			String scanMoreQty=(String) hash.get( "scanMoreQty" )==null?"N":(String) hash.get( "scanMoreQty" ); // Added for GHL-SCF-1293
			String disp_stage=(String) hash.get( "disp_stage" )==null?"N":(String) hash.get( "disp_stage" ); // Added for GHL-SCF-1293
			String entry_type=(String) hash.get( "entry_type" )==null?"":(String) hash.get( "entry_type" );//Added for MMS-DM-CRF-157.1
			//Adding start for MMS-DM-CRF-0170
			String act_patient_episode_type=(String) hash.get( "act_patient_episode_type" )==null?"":(String) hash.get( "act_patient_episode_type" );
			String barcode_scan_count_yn=(String) hash.get( "barcode_scan_count_yn" )==null?"":(String) hash.get( "barcode_scan_count_yn" );
			String act_patient_class ="";
			String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="";
      		    if(act_patient_episode_type.equals(""))
			act_patient_episode_type     =  beanObj.getEncounterPatientClass(beanObj_1.getEncounterID(), patient_id);//Added for MMS-DM-CRF-0170
			//System.err.println("act_patient_episode_type@@@==="+act_patient_episode_type);
			if(act_patient_episode_type.equals("I"))
                act_patient_class  ="IP";
			else if(act_patient_episode_type.equals("O"))
                act_patient_class  ="OP";
			else if(act_patient_episode_type.equals("E"))
                act_patient_class  ="EM";
			else if(act_patient_episode_type.equals("D"))
                act_patient_class  ="DC";
			else if(act_patient_episode_type.equals("R"))
                act_patient_class  ="XT";
         if(beanObj_1.getBarcodeSiteYN().equals("Y")){
                ArrayList scanCountSetup    = beanObj_1.getScanCountReqForPatientClass(act_patient_class,"DISPENSE_MEDICATION");
				  if(scanCountSetup.size()>0){
					  scan_count_required_yn = (String)scanCountSetup.get(0);
					  alert_required_yn      = (String)scanCountSetup.get(1);
					  remarks_required_yn    = (String)scanCountSetup.get(2);
				}
		}

			//ADDING END FOR MMS-DM-CRF-0170
			String scan_key  ="";//Added for MMS-DM-CRF-0157.1
			HashMap scaned_data = new HashMap();//Added for MMS-DM-CRF-0157.1
			String tem_batch_id ="";//Added for MMS-DM-CRF-0157.1
			String bar_code_scan_site_YN= beanObj_1.getBarcodeSiteYN();//Added for MMS-DM-CRF-0157.1
			String scan_count_inc="";//Added for MMS-DM-CRF-0157.1
			String drug_code="";
			String item_code="";
			String store_code="";
			String trade_code="";
			String end_date="";
			String base_uom="";
			String qty_uom="";
			String act_bms_qty="";
			/*String taper_order_yn="";
			String taper_order_id="";
			String taper_order_line_num="";
			String taper_disable="";*/
			double req_qty			 = 1.0;
			double req_qty_batch	=	0.0;//added for GHL-CRF-0413.1 [IN:061794]
			double base_to_disp_uom_equl     = 0;
			double tmp_unit_qty     = 0;
			String disp_level	= beanObj_1.getDispLevelValue();
			String disp_catg	= beanObj_1.getDispLocnCatg();
			HashMap params					= new HashMap();
			ArrayList alOrderIds = new ArrayList();
			ArrayList tmpResult = new ArrayList();
			ArrayList stock_det         = new ArrayList();
			HashMap IssueUOMAndBaseUOM       = new HashMap();
			boolean success = false, batchFound=false;
			int dup_count=1;
			HashMap stock = null;
			String	bean_id_2		=	"StUtilities" ;
			String	bean_name_2		=	"eST.Common.StUtilities";
			StUtilities bean_2=null;
			HashMap hmBatchDtl = null;
			ArrayList barCodesForDrug = null;
			ArrayList alloc_drug_detail = null;
			ArrayList altDrugDtl = null;
			ArrayList multi_drugs = null;
			String firstOccKey = "", item_cost="", tmpItemCode, tmpBatchID, qty="", allowMoreQty="", strReq_qty="";
			String req_drug_qty			=	"";//Added for [IN45912]
			double scanned_qty  = 0.0; // Added for [IN:064158]
			double presc_qty    = 0.0; // Added for [IN:064158]
			double batch_scan   = 0.0;// Added for [IN:064158]
			double batch_scan1  = 0.0; // Added for [IN:064158]
			boolean notBarCodeAlloc = false, batchExist=false, altBatchFound=false, allowMoreQty_yn = true;
			HashMap drugCount =new HashMap();
			//beanObj.clearDrugCount();
			int drug_count =1;
			int temp_drug_count =1;
			HashMap hmAllowMoreQty = beanObj_1.getHmAllowMoreQty();
			try { 
				bean_2 = (StUtilities) getBeanObject( bean_id_2,  bean_name_2, request );
				bean_2.setLanguageId(locale);
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
			
			if(beanObj_1.getAlTrxOrderIds()!=null){
				alOrderIds = new ArrayList(beanObj_1.getAlTrxOrderIds());
			}
			if(disp_level.equals("P") && order_id.equals("") && order_line_no.equals("")) {
				result			= beanObj_1.getOrders(patient_id.trim());
				if(beanObj_1.getOrderType()!=null && beanObj_1.getCriteriaOrderType().equals("ALL")){
					if(alOrderIds.size()>0){
						for(int i=0;i<result.size();i=i+11) {	//Modified for RUT-CRF-0088 [IN036978]  13 ->11	// IN 44141
							if(alOrderIds.contains(result.get(i+1))){
								for(int j=i;j< i+11;j++)//Modified for RUT-CRF-0088 [IN036978]  13 ->11	// IN 44141	
									tmpResult.add(result.get(j));
							}
						}
					}
					result = tmpResult;
				}

				ArrayList tmp	=	new ArrayList();
				String tmp_order_id	=	"";//Added for [IN:45546]
				for(int i=0;i<result.size();i=i+11) {		
					tmp_order_id=result.get(i+1)==null?"":result.get(i+1).toString();//Added for [IN:45546]
					tmp = (ArrayList)beanObj_1.getOrderLineDetails(patient_id,tmp_order_id);//Changed for [IN:45546]
					if(tmp!=null && tmp.size()!=0) {
						for(int j=0; j<tmp.size(); j+=65){ //56-->57 for JD-CRF-0179 [IN:041211] //56 --> 58 for HSA-CRF-0138 [IN:048414] & Bru-HIMS-CRF-080//Changed to 61 while testing MMS-ICN-0128 given exception //Changed 61 to 63 for TH-KW-CRF-0008 //Changed 63 to 65 for mms-dm-crf-0209.1
							hmOrderLineDtls.put((String)result.get(i+1), tmp);
						}
					}
				}
			}
			else {
				alOrderIds.clear();
				hmOrderLineDtls.clear();
				alOrderIds.add(order_id);
				tmpResult = (ArrayList)beanObj_1.getOrderLineDetails(patient_id,order_id);
				if(tmpResult!=null && tmpResult.size()!=0) {
					for(int j=0; j<tmpResult.size(); j+=65){ // 54 to 56 //56-->57 for JD-CRF-0179 [IN:041211]//57-->56 for [IN:045546]//56-->54 for [IN:45912] --> 56 -->58 for  HSA-CRF-0138 [IN:048414] & Bru-HIMS-CRF-080//Changed to 61 while testing MMS-ICN-0128 given exception//Changed 61 to 63 for TH-KW-CRF-0008//Changed 63 to 65 for mms-dm-crf-0209.1
						if(order_line_no.equals((String)tmpResult.get(j+11))){//11-->10 for [IN:045546
							for(int k=j; k<(j+65); k++)//54 to 56//56-->57 for JD-CRF-0179 [IN:041211]//57-->56 for [IN:045546]//56-->54 for [IN:45912]//Changed to 61 while testing MMS-ICN-0128 given exception//Changed 61 to 63 for TH-KW-CRF-0008//Changed 63 to 65 for mms-dm-crf-0209.1
								orderLineDtls.add( tmpResult.get(k));
						}
					}
				}

				hmOrderLineDtls.put(order_id, orderLineDtls );
			}
			if(beanObj_1.get2DBarcodeApplicable().equals("Y")){
			   for(int z =0;z<alOrderIds.size(); z++){

				order_id	=	alOrderIds.get(z).toString();
				orderLineDtls = (ArrayList)hmOrderLineDtls.get(order_id);
				for(int i=0;i<orderLineDtls.size(); i+=65){
				    drug_code=orderLineDtls.get(i+3).toString();
					beanObj.setDrugCount(drug_code);
				}
				//System.err.println("drug_code@@@setdrugcount==="+drug_code);
					
			  }
			}
			for(int j=0;j<alOrderIds.size(); j++){
				order_id	=	alOrderIds.get(j).toString();
				orderLineDtls = (ArrayList)hmOrderLineDtls.get(order_id);
				if(orderLineDtls != null){
					for(int i=0;i<orderLineDtls.size(); i+=65){//57-->54 for [IN:45912]54-->58 for GHL-SCF-1041 [IN:060412]//Changed to 61 while testing MMS-ICN-0128 given exception//Changed 61 to 63 for TH-KW-CRF-0008//Changed 63 to 65 for mms-dm-crf-0209.1
						/*taper_order_yn=orderLineDtls.get(i+53).toString();
						taper_order_id=orderLineDtls.get(i+54).toString();
						taper_order_line_num=orderLineDtls.get(i+55).toString();
						if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){
							taper_disable = "disabled";
						}
						if(!taper_disable.equals("disabled") ){*/
							params.clear();
							order_line_no=orderLineDtls.get(i+11).toString();//12-->11 for [IN:45912]
							drug_code=orderLineDtls.get(i+3).toString();
							beanObj.setDrugCount(drug_code); //added by Himanshu Against GHL-SCF-1787
							multi_drugs	=	beanObj.getMultiDrugs(patient_id,order_id,order_line_no);
							if(multi_drugs!=null  && multi_drugs.size()>0 && !calledFrom.equals("REALLOCATE")){
								continue;
							}
							end_date=orderLineDtls.get(i+7).toString();//8-->7 for [IN:45912]
							if(end_date.length()>10){
								end_date= end_date.substring(0,10);
							}
							qty_uom=orderLineDtls.get(i+9).toString();//10-->9 for [IN:45912]
							if(!alt_drug_code.equals("") && calledFrom.equals("REALLOCATE")){
								drug_code=alt_drug_code;
							}
							
							trade_code				= beanObj_1.gettrade_codes(order_id,order_line_no,drug_code).toString();
							items			=  (ArrayList)beanObj.loadItems(drug_code);
							if(items.size()>0){
								item_code     =   (String)items.get(0);
							}
							store_code	=	beanObj_1.getStoreCode();
							if( !(trade_code.equals(""))){
								params.put("ITEM_CODE",item_code+"="+trade_code); 	
							}
							else{
								params.put("ITEM_CODE",item_code);
							}
							
							String curr_qty = beanObj.getDrugQuantity(patient_id,order_id,order_line_no);//Adding start for MMS-DM-CRF-0174.5
							 //drug_count = Integer.parseInt((String)beanObj.getDrugCount(drug_code));
									
							String stDrug_count = (String)beanObj.getDrugCount(drug_code);// added for MMS-QF-SCF-0723 start
							  if(stDrug_count.equals(""))
									 drug_count =1;
							  else
								  drug_count =Integer.parseInt(stDrug_count);// added for MMS-QF-SCF-0723 end
							  
							 act_bms_qty=orderLineDtls.get(i+15).toString();
							if(curr_qty == null || curr_qty.equals(""))//Added for [IN45912]
								 curr_qty = "1";
							if(act_bms_qty == null || act_bms_qty.equals(""))//Added for [IN45912]		
								act_bms_qty="0";
							 //drug_count = Integer.parseInt((String)beanObj.getDrugCount(drug_code));
							 System.err.println("get2DBarcodeApplicable=="+beanObj_1.get2DBarcodeApplicable()+"drug_count=="+drug_count+"calledFrom=="+calledFrom+"temp_drug_count=="+temp_drug_count);
							if(beanObj_1.get2DBarcodeApplicable().equals("Y") && drug_count>1 && !calledFrom.equals("REALLOCATE") && temp_drug_count < drug_count){
							    if(Double.parseDouble(curr_qty)>=Double.parseDouble(act_bms_qty)){
								    temp_drug_count++;
									break;
								}
							}//Adding end for MMS-DM-CRF-0174.5

							params.put("STORE_CODE",store_code);
							params.put("TRN_QTY","1");
							params.put("INCLUDE_SUSPENDED","FALSE");
							params.put("INCLUDE_EXPIRED","FALSE");
							params.put("CUT_OFF_DATE",end_date);
							params.put("VERIFY_INSUFFICIENT_QTY","FALSE");
							params.put("ALREADY_USED_QTY","");
							params.put("MIN_EXP_DATE",end_date);
							params.put("BARCODE_ID",barcode_id);
							//System.err.println("params@@@ get valid barcode==="+params+"beanObj_1.get2DBarcodeApplicable()=="+beanObj_1.get2DBarcodeApplicable()+"barcode_id=="+barcode_id);
							if(beanObj_1.get2DBarcodeApplicable().equals("Y") && !barcode_id.equals("")){//Added if condition for MMS-DM-CRF-0174.5
								stock = (HashMap)bean_2.get2DBarcodeDetails(params);
							}else{
							    stock	  = (HashMap)bean_2.getBatches(params);
							}
							//System.err.println("stock@@=="+stock);
							stock_det         = (ArrayList)stock.get("BATCH_DATA");
							if(stock_det.size() > 0 && !stock.containsKey("EXCEPTION")){
								hmBatchDtl = (HashMap)stock_det.get(0);//Added for MMS-DM-CRF-0174.5
							  //Adding start for MMS-DM-CRF-0157.1
								if(bar_code_scan_site_YN.equals("Y")){
									scaned_data = beanObj_1.getBarCodeScanedData();
							       // hmBatchDtl = (HashMap)stock_det.get(0);Moved up for MMS-DM-CRF-0174.5
								    tem_batch_id=(String)hmBatchDtl.get("BATCH_ID");
									 scan_key=order_id+"~"+order_line_no+"~"+drug_code+"~"+tem_batch_id;
										if(!scaned_data.containsKey(scan_key)){
										   beanObj_1.setBarCodeScanedData(scan_key, entry_type);
										   scan_count_inc ="Y";
										}
								}//Adding end for MMS-DM-CRF-0157.1

								System.err.println("beanObj_1.setBarCodeScanedData@@==="+beanObj_1.getBarCodeScanedData());
								beanObj_1.setBarCodesForDrug(order_id+"~"+order_line_no+"~"+drug_code, barcode_id);//Added for KDAH-CRF-0231 [IN-034551]
							    beanObj_1.getTempStockDtls().put(item_code,item_code);
							  //Added for KDAH-CRF-0231 [IN-034551]
                                beanObj_1.set2DBarCodeForDrug(drug_code+"~"+(String)hmBatchDtl.get("BATCH_ID"), barcode_id);//Added for MMS-MD-CRF-0174.5
								batchFound = true;
								break;
							}
						//}
					}
					if(batchFound)
						break;
				}
			}
			temp_drug_count =1;//Added for MMS-DM-CRF-0174.5
			for(int j=0;j<alOrderIds.size(); j++){
				order_id	=	alOrderIds.get(j).toString();
				orderLineDtls = (ArrayList)hmOrderLineDtls.get(order_id);
				if(orderLineDtls != null){
					//success=false;
					for(int i=0;i<orderLineDtls.size(); i+=65){//57  --> 58 for GHL-SCF-1041 [IN:060412]//Changed to 61 while testing MMS-ICN-0128 given exception//Changed 61 to 63 for TH-KW-CRF-0008//Changed 63 to 65 for mms-dm-crf-0209.1
						/*taper_order_yn=orderLineDtls.get(i+53).toString();
						taper_order_id=orderLineDtls.get(i+54).toString();
						taper_order_line_num=orderLineDtls.get(i+55).toString();
						if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){
							taper_disable = "disabled";
						}
						if(!taper_disable.equals("disabled") ){*/
							order_line_no=orderLineDtls.get(i+11).toString();//Changed 12 to 11 forGHL-SCF-1041 [IN:060412]
							drug_code=orderLineDtls.get(i+3).toString();//changed from 4 to 3 for GHL-CRF-0413.1 [IN:061794]
							beanObj.setDrugCount(drug_code); //added by Himanshu Against GHL-SCF-1787
							if(!alt_drug_code.equals("") && calledFrom.equals("REALLOCATE")){
								drug_code=alt_drug_code;
							}
							String curr_qty = beanObj.getDrugQuantity(patient_id,order_id,order_line_no);//Adding start for MMS-DM-CRF-0174.5
							 act_bms_qty=orderLineDtls.get(i+15).toString();
							if(curr_qty == null || curr_qty.equals(""))//Added for [IN45912]
								 curr_qty = "1";
							if(act_bms_qty == null || act_bms_qty.equals(""))//Added for [IN45912]		
								act_bms_qty="0";
							 //drug_count = Integer.parseInt((String)beanObj.getDrugCount(drug_code));
							String stDrug_count = (String)beanObj.getDrugCount(drug_code); // added for MMS-QF-SCF-0723 start
							  if(stDrug_count.equals(""))
									 drug_count =1;
							  else
								  drug_count =Integer.parseInt(stDrug_count);// added for MMS-QF-SCF-0723 end
							  
							if(beanObj_1.get2DBarcodeApplicable().equals("Y") && drug_count>1 && !calledFrom.equals("REALLOCATE") && temp_drug_count < drug_count){
							    if(Double.parseDouble(curr_qty)>=Double.parseDouble(act_bms_qty)){
								    temp_drug_count++;
									break;
								}
							}//Adding end for MMS-DM-CRF-0174.5

							items			=  (ArrayList)beanObj.loadItems(drug_code);
							if(items.size()>0){
								item_code     =   (String)items.get(0);
							}
							if(stock_det.size() > 0 && !stock.containsKey("EXCEPTION")){
								hmBatchDtl = (HashMap)stock_det.get(0);
									System.err.println("item_code===="+item_code+": hmBatchDtl-ITEM_CODE :"+hmBatchDtl.get("ITEM_CODE"));
								if(item_code.equals((String)hmBatchDtl.get("ITEM_CODE"))){
									allowMoreQty = (String)hmAllowMoreQty.get(drug_code);
									if(firstOccKey.equals(""))
										firstOccKey = order_id+"~"+order_line_no+"~"+drug_code;
									barCodesForDrug=beanObj_1.getBarCodesForDrug(order_id+"~"+order_line_no+"~"+drug_code);
									//success = true;//commented for GHL-CRF-0413.1 [IN:061794]

									if(barCodesForDrug==null || barCodesForDrug.size()==0){
										notBarCodeAlloc = false;
										break;
									}else{//else condition added for GHL-CRF-0413.1 [IN:061794]
										notBarCodeAlloc = true;
										success = true;
										break;
									}
								}
								//notBarCodeAlloc = false;
							}
						//}
					}
					if(notBarCodeAlloc)
						break;
				}
			}
			if(!alt_drug_code.equals("") && calledFrom.equals("REALLOCATE") && success){
				String prescribed_strength	=  	(String) hash.get("prescribed_strength")==null?"0.0":(String) hash.get("prescribed_strength");
				String alt_drug_strength	=CommonBean.checkForNull((String) hash.get("alt_drug_strength"));
				String bms_strength			=	CommonBean.checkForNull((String) hash.get("bms_strength"));
				String fractroundupyn      =   beanObj.getFractRoundupYN(alt_drug_code);
				multi_drugs	    = beanObj.getMultiDrugs(patient_id,order_id,order_line_no);
				Float fTotalDuration = Float.parseFloat(beanObj_1.getDurationValue(order_id+order_line_no));
				String sRepeatFreqCode		= "";
				String sFreqCode			= "";
				// For Multi Frequency 
				String disp_auth_yn				=   CommonBean.checkForNull((String)beanObj_1.getDispAutharizationYN(drug_code));	
				String strResetQty				=	beanObj_1.getStrResetQty()==null?"":beanObj_1.getStrResetQty();
				boolean bPRNOrAbsOrder			=	beanObj.getBPRNOrAbsOrder();
				if( strResetQty.equals("null"))
					strResetQty="";
			   
				int opdispperiod			   = Integer.parseInt(beanObj_1.getFillPeriod());

				if(bPRNOrAbsOrder)
					opdispperiod = 999;
				sRepeatFreqCode			=	beanObj_1.getFreqRepeatCode(order_id, order_line_no).split("~")[0];
				sFreqCode				=	beanObj_1.getFreqRepeatCode(order_id, order_line_no).split("~")[1];

				String sOrigDispUnit	= beanObj_1.getStrChangedDispenseUnit() != null?beanObj_1.getStrChangedDispenseUnit():"D";
				String sOrigDispPeriod	= beanObj_1.getStrChangedDispensePeriod() != null?beanObj_1.getStrChangedDispensePeriod():"1";

				if(sRepeatFreqCode.equals("W")){
					if(sOrigDispUnit.equals("H"))
						opdispperiod = (int) Math.ceil((Float.parseFloat(opdispperiod+"")/(24*7)))*7; // divide by 24 to make day and divide by 7 to convert to week and ceil it.
					else if(sOrigDispUnit.equals("D"))
						opdispperiod = (int) Math.ceil((Float.parseFloat(opdispperiod+"")/7))*7;
					else if(sOrigDispUnit.equals("M"))
						opdispperiod = (int) Integer.parseInt(sOrigDispPeriod)*4*7;
				}
				else if(sRepeatFreqCode.equals("M")){
					if(sOrigDispUnit.equals("H"))
						opdispperiod = (int) Math.ceil((Float.parseFloat(opdispperiod+"")/(24*30)))*30; 
					else if(sOrigDispUnit.equals("D"))
						opdispperiod = (int) Math.ceil((Float.parseFloat(opdispperiod+"")/30))*30;
					else if(sOrigDispUnit.equals("W"))
						opdispperiod = (int)Math.ceil((Float.parseFloat(opdispperiod+"")/4))*30 ;
				}

				if(sFreqCode.equals("H"))
					fTotalDuration = fTotalDuration/24;
				else if(sFreqCode.equals("W"))
					fTotalDuration = fTotalDuration*7;
				else if(sFreqCode.equals("L"))
					fTotalDuration = fTotalDuration*30;
				else if(sFreqCode.equals("Y"))
					fTotalDuration = fTotalDuration*365;
				String allow_short_expiry_drugs_yn =beanObj_1.getAllow_short_expiry_drugs_yn();

				String alt_qty1        	= "";
				String alt_strength_value1 = "";
				String alt_drug_code1		="",  bms_qty="", strength_value="", main_strength_per_value_pres_uom = "", Order_qty="", repeat_value="", qty_value="",   strength_per_value_pres_uom="" , split_yn="",   drug_pack_size="";
				ArrayList alt_qty			= new ArrayList();
				HashMap pack_dtls1			= new HashMap();
				float tmp_alloc			= 0;
				float pack_size1              = 0; 
				float strength_per_value1  =0;
				int duration				=   0;	
				int duration1				=   0;
				int tot_alt_drug_qty        = 0;
				for(int n=0; n<multi_drugs.size(); n+=5){ 
					alt_qty1		          =	 beanObj.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 
					alt_strength_value1     =	(String)multi_drugs.get(n+3);
					alt_drug_code1		  =	(String)multi_drugs.get(n);
					pack_dtls1              =	 beanObj.getPackSize(alt_drug_code1);
					if(pack_dtls1.containsKey("PACK_SIZE")) {
						if(!((String)pack_dtls1.get("PACK_SIZE")).equals("")) {
							pack_size1	        =	Float.parseFloat(((String)pack_dtls1.get("PACK_SIZE"))); // Integer.parseInt changed to Float.parseFloat for [IN:036634]
							strength_per_value1	=	Float.parseFloat(((String)pack_dtls1.get("STRENGTH_PER_VALUE_PRES_UOM")));
						}		
					}
					if(!alt_qty1.equals("") && !alt_qty1.equals("0")) {
						if(!alt_drug_code1.equals(alt_drug_code))
							tmp_alloc	+=	 ((Float.parseFloat(alt_strength_value1)) * Integer.parseInt(alt_qty1)*pack_size1)/strength_per_value1 ;
					}
				}
				if(Float.parseFloat(prescribed_strength)>0)
					bms_strength = (Float.parseFloat(prescribed_strength) - tmp_alloc)+"";
				if(fractroundupyn.equals("N")){
					HashMap qty_dtls	        = beanObj.getqtyvalue(alt_drug_code,order_id,order_line_no);		
					strength_per_value_pres_uom =(String)qty_dtls.get("STRENGTH_PER_VALUE_PRES_UOM");
					tot_alt_drug_qty	=	new Float(Math.ceil((Float.parseFloat(bms_strength)*(Float.parseFloat(strength_per_value_pres_uom))/Float.parseFloat(alt_drug_strength)))).intValue();

					HashMap pack_dtls	    = beanObj.getPackSize(alt_drug_code);

					if(pack_dtls.containsKey("PACK_SIZE")) {
						if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
							drug_pack_size	=	(String)pack_dtls.get("PACK_SIZE");			
							tot_alt_drug_qty = (int)Math.ceil(tot_alt_drug_qty/Float.parseFloat(drug_pack_size));
						}		
					}
					if(!bms_strength.equals("") && !alt_drug_strength.equals("")) { 
						bms_qty	=	new Float(Math.ceil((Float.parseFloat(bms_strength)*(Float.parseFloat(strength_per_value_pres_uom))/Float.parseFloat(alt_drug_strength)))).intValue()+"";
						qty		=	bms_qty = tot_alt_drug_qty+"";
					} 
					strength_value			= (String)qty_dtls.get("STRENGTH_VALUE");
				}
				else{
					duration					=  0;
					duration					=  new Float(Math.ceil(fTotalDuration)).intValue();
					HashMap qty_dtls			= beanObj.getqtyvalue(alt_drug_code,order_id,order_line_no);
					repeat_value				= (String)qty_dtls.get("repeat_value");
					strength_value				= (String)qty_dtls.get("STRENGTH_VALUE");
					strength_per_value_pres_uom= (String)qty_dtls.get("STRENGTH_PER_VALUE_PRES_UOM");
					qty_value					= (String)qty_dtls.get("QTY_VALUE");
					split_yn					= (String)qty_dtls.get("SPLIT_DOSE_YN");

					if(strength_per_value_pres_uom.equals(""))
						strength_per_value_pres_uom = "0";

					if(alt_drug_strength.equals(""))
					alt_drug_strength = "0";

					tot_alt_drug_qty	=	new Float(Math.ceil((Float.parseFloat(bms_strength)/Float.parseFloat(alt_drug_strength))/(Float.parseFloat(strength_per_value_pres_uom)))).intValue();

					duration1              = duration;
					if(repeat_value.equals("")||repeat_value==null){
						repeat_value = "1";
					}

					Order_qty	=(String)beanObj.getOrderqty(order_id,order_line_no);
					if(split_yn.equals("Y")){
						qty_value = (new Float(Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(repeat_value))).intValue())+"";
					}
					if(!qty.equals("") && !Order_qty.equals(qty)){   //Modified for AAKH-SCF-0299
						
					duration			=	duration-opdispperiod;
					float per_day_qty	=	Float.parseFloat(Order_qty)/duration1 ;
						duration			= ( new Float((Math.ceil(Float.parseFloat(qty)/per_day_qty ))).intValue()) ;
					}
					if(duration!=duration1){
						bms_qty				=	((int) (((Math.ceil((Float.parseFloat(bms_strength)/((Float.parseFloat(strength_value)))))*(duration))/duration1))*(Float.parseFloat(main_strength_per_value_pres_uom)))+"";
					}
					else{
						bms_qty				=	((int) ((Math.ceil((Float.parseFloat(bms_strength)/((Float.parseFloat(strength_value)))))*(duration))/duration1))+"";
					}
					qty		=	bms_qty;
				}
			}

			if(notBarCodeAlloc && success && (!beanObj_1.getOrderType().equals("TA"))){  // Added for [IN:064158] - Start and removed NOR to TA for MMS-KH-CRF-0038.1
				beanObj_1.setScannedBarcode_id(order_id,order_line_no,barcode_id); // Added for GHL-CRF-0463
			    beanObj_1.setStockDtlKey("barcode_applicable"+drug_code,"N"); 
				orderLineDtls = (ArrayList)hmOrderLineDtls.get(order_id);
				item_code = "";
				if(orderLineDtls != null){
					for(int i=0;i<orderLineDtls.size(); i+=65){//Changed to 61 while testing MMS-ICN-0128 given exception //Changed 61 to 63 for TH-KW-CRF-0008//Changed 63 to 65 for mms-dm-crf-0209.1
						if(order_line_no.equals((String)orderLineDtls.get(i+11))){
							if(!alt_drug_code.equals("") && calledFrom.equals("REALLOCATE")){
								drug_code=alt_drug_code;
							}
							drug_code=orderLineDtls.get(i+3).toString();
							presc_qty = Double.parseDouble(orderLineDtls.get(i+8).toString()); 
							act_bms_qty = orderLineDtls.get(i+15).toString(); //Adding for GHL-SCF-1714
							items			=  (ArrayList)beanObj.loadItems(drug_code);
							if(items.size()>0){
								item_code     =   (String)items.get(0);
							}
							break;
						}
					}
				}
				
				/*-------------- Added for MMS-DM-SCF-0488 -Start------*/
				if(!barcode_id.equals(""))
					beanObj_1.setBarcodeColorYn(order_id,order_line_no,"Y");
				base_to_disp_uom_equl     = 0;  
				double base_to_def_uom_equl      = 1;
				double issue_qty_val			 = 0;
				double conv_factor				 = 1;
				//added for MMS-KH-CRF-0038.1 -start
				String equl_qty_val = (String)(((HashMap)beanObj.getIssueUomQty()).get(order_id+order_line_no+item_code+"_equl"));
				if(equl_qty_val==null || equl_qty_val.equals(""))
					equl_qty_val="1";
				//added for MMS-KH-CRF-0038.1 -end
				double iss_qty_eq_val            = Double.valueOf(equl_qty_val); // Added for MMS-DM-SCF-0488 - Reopen Issue //  1.0 changed to "1.0" for MMS-DM-SCF-0083
				IssueUOMAndBaseUOM		=	(HashMap)beanObj.getStoreDfltIssueUOMAndBaseUOM(beanObj_1.getStoreCode(),drug_code);
				String orig_dflt_issue_uom		= (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
				base_to_disp_uom_equl    =	beanObj.getEqulValue ( item_code, (String)IssueUOMAndBaseUOM.get("BASE_UOM"), qty_uom);
				base_to_def_uom_equl	 =  beanObj.getEqulValue ( item_code, (String)IssueUOMAndBaseUOM.get("BASE_UOM"), orig_dflt_issue_uom);
				base_uom = (String)IssueUOMAndBaseUOM.get("BASE_UOM");
				if(base_to_disp_uom_equl!=base_to_def_uom_equl || qty_uom!=base_uom){
					conv_factor    = beanObj.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
				 if(base_to_def_uom_equl!=iss_qty_eq_val){ // Added for MMS-DM-SCF-0488 - Reopen Issue - Start
					conv_factor = beanObj.lcm(base_to_def_uom_equl, iss_qty_eq_val);
					conv_factor = beanObj.lcm(conv_factor, base_to_disp_uom_equl);
				 } // Added for MMS-DM-SCF-0488 - Reopen Issue - End
				}
				/*-------------- Added for MMS-DM-SCF-0488 -End------*/
				strReq_qty = (String)((HashMap)beanObj.getIssueUomQty()).get(order_id+order_line_no+item_code+"_qty")==null?"1.0":(String)((HashMap)beanObj.getIssueUomQty()).get(order_id+order_line_no+item_code+"_qty"); // ==null?"1.0":(String)((HashMap)beanObj.getIssueUomQty()).get(order_id+order_line_no+item_code+"_qty")  Added for MMS-DM-SCF-0083
				strReq_qty = String.valueOf(Double.valueOf(strReq_qty)*conv_factor); /*-------------- Added for MMS-DM-SCF-0488 ------*/
				
				if( !qty_uom.equals(base_uom) ){//added for MMS-KH-CRF-0038.1
				conv_factor    = beanObj.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
				strReq_qty  =  Math.ceil(((Math.ceil(Double.parseDouble(strReq_qty)/conv_factor))*(conv_factor))/base_to_disp_uom_equl)+""; 

 				}

				if(presc_qty!=0.0) 
						req_qty = presc_qty; 
				if(!alt_drug_code.equals("") && calledFrom.equals("REALLOCATE")){
					req_qty = Double.parseDouble(qty==null?"1.0":qty);
				}
			
				if(Double.parseDouble(act_bms_qty) <= Double.parseDouble(beanObj.getDrugQuantity(patient_id, order_id, order_line_no))){ // Added for GHL-SCF-1293 - Start // act_bms_qty Condition Added for GHL-SCF-1714   && req_qty <= Double.parseDouble(beanObj.getDrugQuantity(patient_id, order_id, order_line_no))
					if(allowMoreQty!=null){				
					if(allowMoreQty.equals("Y")){
					  if(!scanMoreQty.equals("Y") && !calledFrom.equals("REALLOCATE")){ // !calledFrom.equals("REALLOCATE") Added for GHL-SCF-1293 -- When barcode is scanned from Allocation/fill Window
						 out.println("scanMoreThanPresc('"+patient_id+"','"+order_id+"','"+disp_stage+"','"+alt_drug_code+"','"+barcode_id+"');");
						 return;
					  }
					}
					else{
						scanMoreQty ="N";
						out.println("alert(getMessage('PH_ALLOC_QTY_LESS_BMS_QTY','PH'));");
					}
					}else{
						scanMoreQty = "N";
					}
				} // Added for GHL-SCF-1293 - End	
			
				 if(req_qty > Double.parseDouble((String)hmBatchDtl.get("AVAIL_QTY")) && (req_qty > Double.parseDouble(beanObj.getDrugQuantity(patient_id, order_id, order_line_no)) || (Double.parseDouble(beanObj.getDrugQuantity(patient_id, order_id, order_line_no)) <= Double.parseDouble((String)hmBatchDtl.get("AVAIL_QTY")) && req_qty <= Double.parseDouble(beanObj.getDrugQuantity(patient_id, order_id, order_line_no)) && (scanMoreQty.equals("Y") || calledFrom.equals("REALLOCATE"))))){ // modified for IN-64492 // && (scanMoreQty.equals("Y") || calledFrom.equals("REALLOCATE")) Added for GHL-SCF-1293
					req_qty = Double.parseDouble( (String)hmBatchDtl.get("AVAIL_QTY") );
					beanObj_1.setBarCodesForDrug(order_id+"~"+order_line_no+"~"+drug_code, barcode_id);  
					beanObj_1.setStockDtlKey("valid_barcode",barcode_id);
					beanObj_1.setStockDtlKey("valid_drug_code",order_id+"~"+order_line_no+"~"+drug_code);
				     //Adding start for MMS-DM-CRF-0157.1
					if(bar_code_scan_site_YN.equals("Y")){
						  scaned_data = beanObj_1.getBarCodeScanedData();
						  hmBatchDtl = (HashMap)stock_det.get(0);
						  tem_batch_id=(String)hmBatchDtl.get("BATCH_ID");
						  scan_key=order_id+"~"+order_line_no+"~"+drug_code+"~"+tem_batch_id;
							if(!scaned_data.containsKey(scan_key)){
							   beanObj_1.setBarCodeScanedData(scan_key, entry_type);
							   scan_count_inc ="Y";
							}
					}//Adding end for MMS-DM-CRF-0157.1  

					double req_qty_actual	=	0.0;
					item_cost	=	beanObj.getItemCost(item_code,store_code,req_qty+"",end_date);
					alloc_drug_detail = new ArrayList();
					ArrayList all_drug_detail = new ArrayList();
					if(beanObj_1.getDispStage().equals("F") && beanObj_1.getDispLocnCatg().equals("O") && (beanObj_1.getFillingStatus().equals("A") || beanObj_1.getFillingStatus().equals("B"))){ // if else condtions are Added for IN-64492 - Start
						all_drug_detail = beanObj.getDrugDetail(patient_id, order_id, order_line_no); 
						beanObj_1.setValuesChanged(true);
					} 
					else
					{	all_drug_detail = beanObj_1.getBatchDetailsForBarcodeDrug();} // Added for IN-64492 - End
					
					for(int m=0;m<all_drug_detail.size();m+=10){ // Added for GHL-CRF-0463 - Start
					if(all_drug_detail.size()> 0 && (all_drug_detail.get(m+3).equals("0.0") || all_drug_detail.get(m+3).equals("0"))) // all_drug_detail.get(m+3).equals("0") Added for AAKH-SCF-0386  
						all_drug_detail.subList(m, m+10).clear();
						break;
					}	// Added for GHL-CRF-0463 - End
					if(all_drug_detail.size()!=0 ) {
						batch_scan = batch_scan+conv_factor;// Chaned 1 to conv_factor for MMS-ICN-0128 point-3
						//System.err.println("batch_scan@@==="+batch_scan+"conv_factor==="+conv_factor);
						for(int k=0; k<all_drug_detail.size(); k+=10) {
							if(!((String)all_drug_detail.get(k+1)).equals(hmBatchDtl.get("BATCH_ID")) ){
								alloc_drug_detail.add((String)all_drug_detail.get(k));
								alloc_drug_detail.add((String)all_drug_detail.get(k+1));
								alloc_drug_detail.add((String)all_drug_detail.get(k+2));
								alloc_drug_detail.add((String)all_drug_detail.get(k+3));
								alloc_drug_detail.add((String)all_drug_detail.get(k+4));
								alloc_drug_detail.add((String)all_drug_detail.get(k+5));
								alloc_drug_detail.add((String)all_drug_detail.get(k+6));
								alloc_drug_detail.add((String)all_drug_detail.get(k+7));
								alloc_drug_detail.add((String)all_drug_detail.get(k+8));
								alloc_drug_detail.add((String)all_drug_detail.get(k+9));
								req_qty_actual 	= req_qty_actual+Double.parseDouble((String)all_drug_detail.get(k+3));
							}
							else { 
								batch_scan1 = Double.parseDouble(all_drug_detail.get(k+3).toString());
								scanned_qty = Double.parseDouble(beanObj.getDrugQuantity(patient_id, order_id, order_line_no));
								//if(req_qty > batch_scan1){  // commented for GHL-SCF-1293
								   batch_scan1 = Double.parseDouble(all_drug_detail.get(k+3).toString())+1;	 
								   scanned_qty = Double.parseDouble(beanObj.getDrugQuantity(patient_id, order_id, order_line_no))+1; 
							   // }  // commented for GLH-SCF-1293
							} 
						}	
					}
				
					if(req_qty_actual!=0.0)
						req_qty_actual = req_qty_actual+req_qty;
					else
						req_qty_actual = req_qty;
					alloc_drug_detail.add(hmBatchDtl.get("ITEM_CODE"));
					alloc_drug_detail.add(hmBatchDtl.get("BATCH_ID"));
					alloc_drug_detail.add(hmBatchDtl.get("EXPIRY_DATE"));
					
					if(batch_scan1!=0.0) 
						alloc_drug_detail.add(((int)(batch_scan1))+"");
					else if(batch_scan!=0.0) 
						alloc_drug_detail.add(((int)(batch_scan))+"");
					else{
						if(scanned_qty<1) 
							scanned_qty = Double.parseDouble(strReq_qty)+1; 
						alloc_drug_detail.add(((int)(scanned_qty))+""); 
					} 
					alloc_drug_detail.add(qty_uom);
					alloc_drug_detail.add("");
					alloc_drug_detail.add(hmBatchDtl.get("TRADE_ID"));
					alloc_drug_detail.add(hmBatchDtl.get("BIN_LOCATION_CODE"));
					alloc_drug_detail.add(item_cost);
					alloc_drug_detail.add(qty_uom);
					if(req_qty >= batch_scan1) 
					   beanObj_1.setBatchDetailsForBarcodeDrug(alloc_drug_detail); 
					if(!alt_drug_code.equals("") && calledFrom.equals("REALLOCATE")){
						beanObj.setAlternateDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail,alt_drug_code);
					}
					else{
					    ArrayList alloc_drug_detail_1 = new ArrayList();
					if(alloc_drug_detail.size()>0){
						scanned_qty =0.0; // added for IN064492  AND KDAH-SCF-0434
						for(int k=0; k<alloc_drug_detail.size(); k+=10) {
							if(((String)alloc_drug_detail.get(k)).equals(hmBatchDtl.get("ITEM_CODE")) ){
								alloc_drug_detail_1.add((String)alloc_drug_detail.get(k));
								alloc_drug_detail_1.add((String)alloc_drug_detail.get(k+1));
								alloc_drug_detail_1.add((String)alloc_drug_detail.get(k+2));
							    alloc_drug_detail_1.add((String)alloc_drug_detail.get(k+3));
							    scanned_qty =scanned_qty+Double.parseDouble((String)alloc_drug_detail.get(k+3)); // Added for [IN064492] AND KDAH-SCF-0434
								alloc_drug_detail_1.add((String)alloc_drug_detail.get(k+4));
								alloc_drug_detail_1.add((String)alloc_drug_detail.get(k+5));
								alloc_drug_detail_1.add((String)alloc_drug_detail.get(k+6));
								alloc_drug_detail_1.add((String)alloc_drug_detail.get(k+7));
								alloc_drug_detail_1.add((String)alloc_drug_detail.get(k+8));
								alloc_drug_detail_1.add((String)alloc_drug_detail.get(k+9));
							 
							}
						}
						beanObj.setDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail_1);
						beanObj.setDrugQuantity(patient_id,order_id,order_line_no, scanned_qty);
					   }
					}
					
					out.println("validbarcode('true','"+dup_count+"','"+calledFrom+"','"+scan_key+"','"+entry_type+"','"+bar_code_scan_site_YN+"','"+scan_count_inc+"','"+act_patient_class+"','"+scan_count_required_yn+"','"+alert_required_yn+"','"+remarks_required_yn+"','"+patient_id+"','"+beanObj_1.getEncounterID()+"','"+disp_stage+"')"); // calledFrom Added for MMS-DM-SCF-0083 scan_key,entry_type,bar_code_scan_site_YN,scan_count_inc added for MMS-DM-CRF-157.1 act_patient_class,scan_count_required_yn,alert_required_yn,remarks_required_yn added for MMS-DM-CRF-0170
				}
				
				else{
					beanObj_1.setBarCodesForDrug(order_id+"~"+order_line_no+"~"+drug_code, barcode_id);  
					beanObj_1.setStockDtlKey("valid_barcode",barcode_id);
					beanObj_1.setStockDtlKey("valid_drug_code",order_id+"~"+order_line_no+"~"+drug_code);
				     //Adding start for MMS-DM-CRF-0157.1
					if(bar_code_scan_site_YN.equals("Y")){
						 scaned_data = beanObj_1.getBarCodeScanedData();
						 hmBatchDtl = (HashMap)stock_det.get(0);
						 tem_batch_id=(String)hmBatchDtl.get("BATCH_ID");
						 scan_key=order_id+"~"+order_line_no+"~"+drug_code+"~"+tem_batch_id;
							if(!scaned_data.containsKey(scan_key)){
							   beanObj_1.setBarCodeScanedData(scan_key, entry_type);
							   scan_count_inc ="Y";
							}
					}//Adding end for MMS-DM-CRF-0157.1
					item_cost	=	beanObj.getItemCost(item_code,store_code,req_qty+"",end_date);
					alloc_drug_detail = new ArrayList();
					ArrayList all_drug_detail = new ArrayList();
					
					if(beanObj_1.getDispStage().equals("F") && beanObj_1.getDispLocnCatg().equals("O") && (beanObj_1.getFillingStatus().equals("A") || beanObj_1.getFillingStatus().equals("B"))){ // IF condtion is Added for IN-64492 - Start	
						all_drug_detail = beanObj.getDrugDetail(patient_id, order_id, order_line_no); 
						beanObj_1.setValuesChanged(true);
					} 
					else{
						all_drug_detail = beanObj.getDrugDetail(patient_id, order_id, order_line_no);//beanObj_1.getBatchDetailsForBarcodeDrug(); // Added for IN-64492 - End // getDrugDetail(patient_id, order_id, order_line_no); Added for AAKH-SCF-0377
					    
						if(!alt_drug_code.equals("") && calledFrom.equals("REALLOCATE") && req_qty >= scanned_qty){ // req_qty >= scanned_qty Added MMS-DM-SCF-0083
							all_drug_detail = beanObj.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);
						}
					}
					
						/*if(all_drug_detail.size()> 0 && all_drug_detail.get(3).equals("0"))
							all_drug_detail.clear(); */ // Commented for AAKH-SCF-0377
							
					   for(int m=0;m<all_drug_detail.size();m+=10){ // Added for AAKH-SCF-0377 - Start
						  if(all_drug_detail.size()> 0 && (all_drug_detail.get(m+3).equals("0.0") || all_drug_detail.get(m+3).equals("0")))  // all_drug_detail.get(m+3).equals("0") Added for AAKH-SCF-0386
							  all_drug_detail.subList(m, m+10).clear();
							  break;
						  } // Added for AAKH-SCF-0377 - End
						
					if(all_drug_detail.size()!=0 && (req_qty > Double.parseDouble(beanObj.getDrugQuantity(patient_id, order_id, order_line_no)) || (req_qty<=Double.parseDouble(beanObj.getDrugQuantity(patient_id, order_id, order_line_no))  && (scanMoreQty.equals("Y") || calledFrom.equals("REALLOCATE"))))) { // || (req_qty<=Double.parseDouble(beanObj.getDrugQuantity(patient_id, order_id, order_line_no)) && (scanMoreQty.equals("Y") || calledFrom.equals("REALLOCATE")))  Added for GHL-SCF-1293 // && req_qty > Double.parseDouble((String)hmBatchDtl.get("AVAIL_QTY")) Added for AAKH-SCF-0386 
					    batch_scan = batch_scan+conv_factor; // 1 changed to conv_factor for MMS-DM-SCF-0488
						for(int k=0; k<all_drug_detail.size(); k+=10) {
							if(!((String)all_drug_detail.get(k+1)).equals(hmBatchDtl.get("BATCH_ID")) || !((String)all_drug_detail.get(k+0)).equals(hmBatchDtl.get("ITEM_CODE"))){ // ((String)all_drug_detail.get(k+0)).equals(hmBatchDtl.get("ITEM_CODE")) Added for AAKH-SCF-0377
								alloc_drug_detail.add((String)all_drug_detail.get(k));
								alloc_drug_detail.add((String)all_drug_detail.get(k+1));
								alloc_drug_detail.add((String)all_drug_detail.get(k+2));
							    alloc_drug_detail.add((String)all_drug_detail.get(k+3));
								alloc_drug_detail.add((String)all_drug_detail.get(k+4));
								alloc_drug_detail.add((String)all_drug_detail.get(k+5));
								alloc_drug_detail.add((String)all_drug_detail.get(k+6));
								alloc_drug_detail.add((String)all_drug_detail.get(k+7));
								alloc_drug_detail.add((String)all_drug_detail.get(k+8));
								alloc_drug_detail.add((String)all_drug_detail.get(k+9));
								
								
								if(req_qty > Double.parseDouble((String)all_drug_detail.get(k+3))){
									if((int)req_qty_batch==0)
										req_qty_batch = req_qty-Double.parseDouble((String)all_drug_detail.get(k+3));
									else
										req_qty_batch = req_qty_batch-Double.parseDouble((String)all_drug_detail.get(k+3));
									}
								//else
								//alloc_drug_detail.clear();// commented for AAKH-SCF-0377
																
							 
							}
							else { 
								// if(req_qty > scanned_qty) // Commented for GHL-SCF-01293
							if(((String)all_drug_detail.get(k+0)).equals(hmBatchDtl.get("ITEM_CODE"))) {  
							if( !qty_uom.equals(base_uom))  //added for MMS-KH-CRF-0038.1
								batch_scan1 = (Double.parseDouble(all_drug_detail.get(k+3).toString())*conv_factor)+conv_factor;
							else	
							    batch_scan1 = Double.parseDouble(all_drug_detail.get(k+3).toString())+conv_factor; // 1 changed to conv_factor for MMS-DM-SCF-0488	 
							}
						  }  
						}
						scanned_qty = Double.parseDouble(beanObj.getDrugQuantity(patient_id, order_id, order_line_no)); 
						// if(req_qty > scanned_qty) // Commented for GHL-SCF-01293
						    scanned_qty = Double.parseDouble(beanObj.getDrugQuantity(patient_id, order_id, order_line_no))+conv_factor; // 1 changed to conv_factor for MMS-DM-SCF-0488  and changed conv_factore to 1 for MMS-KH-CRF-0028.1 Changed back to convertion factor for MMS-ICN-0128 point-3
					}						
				  if((batch_scan1<=Double.parseDouble((String)hmBatchDtl.get("AVAIL_QTY")) && batch_scan<=Double.parseDouble((String)hmBatchDtl.get("AVAIL_QTY")))&& ((Double.parseDouble(act_bms_qty) > Double.parseDouble(beanObj.getDrugQuantity(patient_id, order_id, order_line_no))) || (Double.parseDouble(act_bms_qty) <= Double.parseDouble(beanObj.getDrugQuantity(patient_id, order_id, order_line_no)) && (scanMoreQty.equals("Y") || calledFrom.equals("REALLOCATE"))))) {  // || (req_qty <= Double.parseDouble(beanObj.getDrugQuantity(patient_id, order_id, order_line_no)) && scanMoreQty.equals("Y") || calledFrom.equals("REALLOCATE")) Added for GHL-SCF-1293 // batch_scan1<=Double.parseDouble((String)hmBatchDtl.get("AVAIL_QTY")) && batch_scan<=Double.parseDouble((String)hmBatchDtl.get("AVAIL_QTY")) Added for AAKH-SCF-0386 //((Double.parseDouble(act_bms_qty) > Double.parseDouble(beanObj.getDrugQuantity(patient_id, order_id, order_line_no))) || (Double.parseDouble(act_bms_qty) <= Double.parseDouble(beanObj.getDrugQuantity(patient_id, order_id, order_line_no)) Updated for GHL-SCF-1714
					alloc_drug_detail.add(hmBatchDtl.get("ITEM_CODE"));
					alloc_drug_detail.add(hmBatchDtl.get("BATCH_ID"));
					alloc_drug_detail.add(hmBatchDtl.get("EXPIRY_DATE"));
					if(batch_scan1!=0.0) 
						alloc_drug_detail.add(((int)(batch_scan1))+"");
					else if(batch_scan!=0.0) 
						alloc_drug_detail.add(((int)(batch_scan))+"");
					else{
						if(scanned_qty<1){ 
						 if(!alt_drug_code.equals("")){ // if else Added for MMS-DM-SCF-0083
							 scanned_qty = conv_factor;
						 }else{
							scanned_qty = Double.parseDouble(strReq_qty);//+conv_factor; // 1 changed to conv_factor for MMS-DM-SCF-0488 and remved 1 for MMS-KH-CRF-0038.1 as first time scanning it is showing as 2
							  if(scanned_qty<1)//Added for MMS-ICN-0128
							    scanned_qty = conv_factor;
						    }
						}
							
						alloc_drug_detail.add(((int)(scanned_qty))+""); 
					}			
					alloc_drug_detail.add(qty_uom);
					alloc_drug_detail.add("");
					alloc_drug_detail.add(hmBatchDtl.get("TRADE_ID"));
					alloc_drug_detail.add(hmBatchDtl.get("BIN_LOCATION_CODE"));
					alloc_drug_detail.add(item_cost);
					alloc_drug_detail.add(base_uom);//changed qty_uom to base_uom for MMS-KH-CRF-0038.1

					//if(req_qty > scanned_qty)  // Commented for GHL-SCF-01293
						beanObj_1.setBatchDetailsForBarcodeDrug(alloc_drug_detail); 
					
					if(!alt_drug_code.equals("") && calledFrom.equals("REALLOCATE") && req_qty >= scanned_qty){ // req_qty >= scanned_qty Added MMS-DM-SCF-0083
						beanObj.setAlternateDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail,alt_drug_code);
					}
					else{
					    ArrayList alloc_drug_detail_1 = new ArrayList();
					if(alloc_drug_detail.size()>0){
						for(int k=0; k<alloc_drug_detail.size(); k+=10) {
							if(((String)alloc_drug_detail.get(k)).equals(hmBatchDtl.get("ITEM_CODE")) ){
								alloc_drug_detail_1.add((String)alloc_drug_detail.get(k));
								alloc_drug_detail_1.add((String)alloc_drug_detail.get(k+1));
								alloc_drug_detail_1.add((String)alloc_drug_detail.get(k+2));
							        alloc_drug_detail_1.add((String)alloc_drug_detail.get(k+3));
								alloc_drug_detail_1.add((String)alloc_drug_detail.get(k+4));
								alloc_drug_detail_1.add((String)alloc_drug_detail.get(k+5));
								alloc_drug_detail_1.add((String)alloc_drug_detail.get(k+6));
								alloc_drug_detail_1.add((String)alloc_drug_detail.get(k+7));
								alloc_drug_detail_1.add((String)alloc_drug_detail.get(k+8));
								alloc_drug_detail_1.add((String)alloc_drug_detail.get(k+9));
							 
							}
						}
						beanObj.setDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail_1);
						if(!alt_drug_code.equals("") && calledFrom.equals("REALLOCATE")){ // req_qty >= scanned_qty Added MMS-DM-SCF-0083
							beanObj.setAlternateDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail_1,alt_drug_code);
						}
						beanObj.setDrugQuantity(patient_id,order_id,order_line_no, scanned_qty);
					   }
					}
				}
					out.println("validbarcode('true','"+dup_count+"','"+calledFrom+"','"+scan_key+"','"+entry_type+"','"+bar_code_scan_site_YN+"','"+scan_count_inc+"','"+act_patient_class+"','"+scan_count_required_yn+"','"+alert_required_yn+"','"+remarks_required_yn+"','"+patient_id+"','"+beanObj_1.getEncounterID()+"','"+disp_stage+"')"); // calledFrom Added for MMS-DM-SCF-0083)");scan_key,entry_type ,bar_code_scan_site_YN,scan_count_inc added for MMS-DM-CRF-157.1 scan_count_required_yn,alert_required_yn,remarks_required_yn,act_patient_class added for MMS-DM-CRF-0170
				}
			}  // Added for [IN:064158] - End
			else if(notBarCodeAlloc && success) {
			    beanObj_1.setStockDtlKey("barcode_applicable"+drug_code,"N");//Added for KDAH-CRF-0231 [IN-034551] 
				orderLineDtls = (ArrayList)hmOrderLineDtls.get(order_id);
				item_code = "";
				if(orderLineDtls != null){
					for(int i=0;i<orderLineDtls.size(); i+=65){// 57 -- > 58 for GHL-SCF-1041 [IN:060412]//Changed to 61 while testing MMS-ICN-0128 given exception//Changed 61 to 63 for TH-KW-CRF-0008//Changed 63 to 65 for mms-dm-crf-0209.1
						if(order_line_no.equals((String)orderLineDtls.get(i+11))){
							if(!alt_drug_code.equals("") && calledFrom.equals("REALLOCATE")){
								drug_code=alt_drug_code;
							}
							drug_code=orderLineDtls.get(i+3).toString();
							items			=  (ArrayList)beanObj.loadItems(drug_code);
							if(items.size()>0){
								item_code     =   (String)items.get(0);
							}
							break;
						}
					}
				}
				
				strReq_qty = (String)((HashMap)beanObj.getIssueUomQty()).get(order_id+order_line_no+item_code+"_qty");
				req_qty = Double.parseDouble(strReq_qty==null?"1.0":strReq_qty);
				if(!alt_drug_code.equals("") && calledFrom.equals("REALLOCATE")){
					req_qty = Double.parseDouble(qty==null?"1.0":qty);
				}
				if(req_qty > Double.parseDouble( (String)hmBatchDtl.get("AVAIL_QTY") )){//changed QTY_ON_HAND to avail_qty for GHL-CRF-0413.1 [IN:061794]
					//success = false;//commented for GHL-CRF-0413.1 [IN:061794]
					//out.println("validbarcode('false', 'INSUFFICIENTBATCH')");//commented for GHL-CRF-0413.1 [IN:061794]
					//added for GHL-CRF-0413.1 [IN:061794] start
					req_qty = Double.parseDouble( (String)hmBatchDtl.get("AVAIL_QTY") );
					beanObj_1.setBarCodesForDrug(order_id+"~"+order_line_no+"~"+drug_code, barcode_id);  
					beanObj_1.setStockDtlKey("valid_barcode",barcode_id);
					beanObj_1.setStockDtlKey("valid_drug_code",order_id+"~"+order_line_no+"~"+drug_code);
				     //Adding start for MMS-DM-CRF-0157.1
					if(bar_code_scan_site_YN.equals("Y")){
						scaned_data = beanObj_1.getBarCodeScanedData();
						hmBatchDtl = (HashMap)stock_det.get(0);
						tem_batch_id=(String)hmBatchDtl.get("BATCH_ID");
						 scan_key=order_id+"~"+order_line_no+"~"+drug_code+"~"+tem_batch_id;
							if(!scaned_data.containsKey(scan_key)){
							   beanObj_1.setBarCodeScanedData(scan_key, entry_type);
							   scan_count_inc ="Y";
							}
					}//Adding end for MMS-DM-CRF-0157.1
					double req_qty_actual	=	0.0;
					item_cost	=	beanObj.getItemCost(item_code,store_code,req_qty+"",end_date);
					alloc_drug_detail = new ArrayList();
					ArrayList all_drug_detail = new ArrayList();
					all_drug_detail = beanObj_1.getBatchDetailsForBarcodeDrug();
					
					if(all_drug_detail.size()!=0) {
						for(int k=0; k<all_drug_detail.size(); k+=10) {
							if(!((String)all_drug_detail.get(k+1)).equals(hmBatchDtl.get("BATCH_ID")) ){
								alloc_drug_detail.add((String)all_drug_detail.get(k));
								alloc_drug_detail.add((String)all_drug_detail.get(k+1));
								alloc_drug_detail.add((String)all_drug_detail.get(k+2));
								alloc_drug_detail.add((String)all_drug_detail.get(k+3));
								alloc_drug_detail.add((String)all_drug_detail.get(k+4));
								alloc_drug_detail.add((String)all_drug_detail.get(k+5));
								alloc_drug_detail.add((String)all_drug_detail.get(k+6));
								alloc_drug_detail.add((String)all_drug_detail.get(k+7));
								alloc_drug_detail.add((String)all_drug_detail.get(k+8));
								alloc_drug_detail.add((String)all_drug_detail.get(k+9));
								req_qty_actual 	= req_qty_actual+Double.parseDouble((String)all_drug_detail.get(k+3));
							}
						}
					}
				
					if(req_qty_actual!=0.0)
						req_qty_actual = req_qty_actual+req_qty;
					else
						req_qty_actual = req_qty;
					alloc_drug_detail.add(hmBatchDtl.get("ITEM_CODE"));
					alloc_drug_detail.add(hmBatchDtl.get("BATCH_ID"));
					alloc_drug_detail.add(hmBatchDtl.get("EXPIRY_DATE"));
					alloc_drug_detail.add(((int)(req_qty))+"");
					alloc_drug_detail.add(qty_uom);
					alloc_drug_detail.add("");
					alloc_drug_detail.add(hmBatchDtl.get("TRADE_ID"));
					alloc_drug_detail.add(hmBatchDtl.get("BIN_LOCATION_CODE"));
					alloc_drug_detail.add(item_cost);
					alloc_drug_detail.add(qty_uom);
					beanObj_1.setBatchDetailsForBarcodeDrug(alloc_drug_detail);
					if(!alt_drug_code.equals("") && calledFrom.equals("REALLOCATE")){
						beanObj.setAlternateDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail,alt_drug_code);
					}
					else{
						beanObj.setDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail);
						beanObj.setDrugQuantity(patient_id,order_id,order_line_no, req_qty_actual);
					}
					
					out.println("validbarcode('true','"+dup_count+"','"+calledFrom+"','"+scan_key+"','"+entry_type+"','"+bar_code_scan_site_YN+"','"+scan_count_inc+"','"+act_patient_class+"','"+scan_count_required_yn+"','"+alert_required_yn+"','"+remarks_required_yn+"','"+patient_id+"','"+beanObj_1.getEncounterID()+"','"+disp_stage+"')"); // calledFrom Added for MMS-DM-SCF-0083)");//added for GHL-CRF-0413.1 [IN:061794] endscan_key,entry_type ,bar_code_scan_site_YN,scan_count_inc added for MMS-DM-CRF-157.1 scan_count_required_yn,alert_required_yn,remarks_required_yn,act_patient_class added for MMS-DM-CRF-0170
				}
				
				else{
					beanObj_1.setBarCodesForDrug(order_id+"~"+order_line_no+"~"+drug_code, barcode_id);  
					beanObj_1.setStockDtlKey("valid_barcode",barcode_id);
					beanObj_1.setStockDtlKey("valid_drug_code",order_id+"~"+order_line_no+"~"+drug_code);
				     //Adding start for MMS-DM-CRF-0157.1
					if(bar_code_scan_site_YN.equals("Y")){
						 scaned_data = beanObj_1.getBarCodeScanedData();
						 hmBatchDtl = (HashMap)stock_det.get(0);
						 tem_batch_id=(String)hmBatchDtl.get("BATCH_ID");
						 scan_key=order_id+"~"+order_line_no+"~"+drug_code+"~"+tem_batch_id;
							if(!scaned_data.containsKey(scan_key)){
							   beanObj_1.setBarCodeScanedData(scan_key, entry_type);
							   scan_count_inc ="Y";
							}
					}//Adding end for MMS-DM-CRF-0157.1

					item_cost	=	beanObj.getItemCost(item_code,store_code,req_qty+"",end_date);
					alloc_drug_detail = new ArrayList();
					ArrayList all_drug_detail = new ArrayList();
					
						all_drug_detail = beanObj_1.getBatchDetailsForBarcodeDrug();
				
					
					if(all_drug_detail.size()!=0) {
						for(int k=0; k<all_drug_detail.size(); k+=10) {
							if(!((String)all_drug_detail.get(k+1)).equals(hmBatchDtl.get("BATCH_ID")) ){
								alloc_drug_detail.add((String)all_drug_detail.get(k));
								alloc_drug_detail.add((String)all_drug_detail.get(k+1));
								alloc_drug_detail.add((String)all_drug_detail.get(k+2));
								alloc_drug_detail.add((String)all_drug_detail.get(k+3));
								alloc_drug_detail.add((String)all_drug_detail.get(k+4));
								alloc_drug_detail.add((String)all_drug_detail.get(k+5));
								alloc_drug_detail.add((String)all_drug_detail.get(k+6));
								alloc_drug_detail.add((String)all_drug_detail.get(k+7));
								alloc_drug_detail.add((String)all_drug_detail.get(k+8));
								alloc_drug_detail.add((String)all_drug_detail.get(k+9));
								if(req_qty > Double.parseDouble((String)all_drug_detail.get(k+3))){
									if((int)req_qty_batch==0)
										req_qty_batch = req_qty-Double.parseDouble((String)all_drug_detail.get(k+3));
									else
										req_qty_batch = req_qty_batch-Double.parseDouble((String)all_drug_detail.get(k+3));
									}
								else
								alloc_drug_detail.clear();
							}
							
						}
					}
					
					alloc_drug_detail.add(hmBatchDtl.get("ITEM_CODE"));
					alloc_drug_detail.add(hmBatchDtl.get("BATCH_ID"));
					alloc_drug_detail.add(hmBatchDtl.get("EXPIRY_DATE"));
					if(req_qty_batch!=0.0)
						alloc_drug_detail.add(((int)(req_qty_batch))+"");
					else
						alloc_drug_detail.add(((int)(req_qty))+"");
					alloc_drug_detail.add(qty_uom);
					alloc_drug_detail.add("");
					alloc_drug_detail.add(hmBatchDtl.get("TRADE_ID"));
					alloc_drug_detail.add(hmBatchDtl.get("BIN_LOCATION_CODE"));
					alloc_drug_detail.add(item_cost);
					alloc_drug_detail.add(qty_uom);
					
					if(!alt_drug_code.equals("") && calledFrom.equals("REALLOCATE")){
						beanObj.setAlternateDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail,alt_drug_code);
					}
					else{
						beanObj.setDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail);
						beanObj.setDrugQuantity(patient_id,order_id,order_line_no, req_qty);
					}
					out.println("validbarcode('true','"+dup_count+"','"+calledFrom+"','"+scan_key+"','"+entry_type+"','"+bar_code_scan_site_YN+"','"+scan_count_inc+"','"+act_patient_class+"','"+scan_count_required_yn+"','"+alert_required_yn+"','"+remarks_required_yn+"','"+patient_id+"','"+beanObj_1.getEncounterID()+"','"+disp_stage+"')"); // calledFrom Added for MMS-DM-SCF-0083scan_key,entry_type ,bar_code_scan_site_YN,scan_count_inc added for MMS-DM-CRF-157.1 scan_count_required_yn,alert_required_yn,remarks_required_yn,act_patient_class added for MMS-DM-CRF-0170
				}
			}
			else if (success){
			    beanObj_1.setStockDtlKey("barcode_applicable"+drug_code,"Y");//Added for KDAH-CRF-0231 [IN-034551]
				barCodesForDrug=beanObj_1.getBarCodesForDrug(firstOccKey);
				String[] tmpOrdid = firstOccKey.split("~");
				order_id = tmpOrdid[0];
				order_line_no = tmpOrdid[1];
				orderLineDtls = (ArrayList)hmOrderLineDtls.get(order_id);
				item_code = "";
				for(int i=0;i<orderLineDtls.size(); i+=65){ // 56 --> 58 for GHL-SCF-1041 [IN:060412]//Changed to 61 while testing MMS-ICN-0128 given exception//Changed 61 to 63 for TH-KW-CRF-0008//Changed 63 to 65 for mms-dm-crf-0209.1
					if(order_line_no.equals((String)orderLineDtls.get(i+11))){
						drug_code=orderLineDtls.get(i+3).toString();
						act_bms_qty=orderLineDtls.get(i+15).toString();
						items			=  (ArrayList)beanObj.loadItems(drug_code);
						if(items.size()>0){
							item_code     =   (String)items.get(0);
						}
						break;
					}
				}
				if(barCodesForDrug!=null && barCodesForDrug.size()>0){
					dup_count++;
				}
				beanObj_1.setBarCodesForDrug(firstOccKey, barcode_id);  
				beanObj_1.setStockDtlKey("valid_barcode",barcode_id);
				beanObj_1.setStockDtlKey("valid_drug_code",firstOccKey);
				     //Adding start for MMS-DM-CRF-0157.1
				if(bar_code_scan_site_YN.equals("Y")){
					 scaned_data = beanObj_1.getBarCodeScanedData();
					 hmBatchDtl = (HashMap)stock_det.get(0);
					 tem_batch_id=(String)hmBatchDtl.get("BATCH_ID");
					 scan_key=order_id+"~"+order_line_no+"~"+drug_code+"~"+tem_batch_id;
						if(!scaned_data.containsKey(scan_key)){
						   beanObj_1.setBarCodeScanedData(scan_key, entry_type);
						   scan_count_inc ="Y";
						}
				}//Adding end for MMS-DM-CRF-0157.1
				if(!alt_drug_code.equals("") && calledFrom.equals("REALLOCATE"))
					alloc_drug_detail = beanObj.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);
				else
					alloc_drug_detail = beanObj.getDrugDetail(patient_id,order_id,order_line_no);
				//if((alt_drug_code.equals("") || !calledFrom.equals("REALLOCATE")) && allowMoreQtyConfirmed.equals("") ){
				if(alt_drug_code.equals("")  && allowMoreQtyConfirmed.equals("") ){
					strReq_qty = beanObj.getDrugQuantity(patient_id,order_id,order_line_no);
					if(strReq_qty == null || strReq_qty.equals(""))//Added for [IN45912]
						strReq_qty = "1";
					if(act_bms_qty == null || act_bms_qty.equals(""))//Added for [IN45912]		
						act_bms_qty="0";
					if(Double.parseDouble(strReq_qty)>=Double.parseDouble(act_bms_qty) ){
						if(allowMoreQty!=null){		//Added for [IN45912]				
						if(allowMoreQty.equals("Y")){
							allowMoreQty_yn = true;
							out.println("confirm(getMessage('ALLOC_QTY_GRT_PRES_QTY','PH'))");
							return;
						}
						else{
							allowMoreQty_yn = false;
						}
						}else{//Added for [IN45912]
							allowMoreQty_yn = false;
						}
					}
				}
				if(allowMoreQty_yn){
					if(alloc_drug_detail.size()!=0) {
						for(int k=0; k<alloc_drug_detail.size(); k+=10) { //9->10 for MMS-SCF-0040 [IN:041888]
							tmpItemCode = (String)alloc_drug_detail.get(k);
							tmpBatchID = (String)alloc_drug_detail.get(k+1);
							if(tmpItemCode.equals((String)hmBatchDtl.get("ITEM_CODE")) && tmpBatchID.equals((String)hmBatchDtl.get("BATCH_ID"))){
								req_qty = Double.parseDouble((String)alloc_drug_detail.get(k+3));
								if(alt_drug_code.equals("") && calledFrom.equals("REALLOCATE")){//Added for KDAH-CRF-0231 [IN-034551] - Start
								    if(req_qty>=Double.parseDouble(act_bms_qty) ){
										if(allowMoreQty.equals("Y")){
											out.println("getMessage('PH_ALLOC_QTY_LESS_BMS_QTY','PH')");
										    alloc_drug_detail.set(k+3,((int)(req_qty))+"");
											batchExist = true;
											break;
										}
										else{
											req_qty++;
											alloc_drug_detail.set(k+3,((int)(req_qty))+"");
											batchExist = true;
											break;
										}
									}
								}
								else{
									req_qty++;
									alloc_drug_detail.set(k+3,((int)(req_qty))+"");
									batchExist = true;
									break;
								}//Added for KDAH-CRF-0231 [IN-034551] - End
							}
						}
					}
					if(!batchExist){
						if(alloc_drug_detail==null || alloc_drug_detail.size()==0)
							alloc_drug_detail = new ArrayList();
						alloc_drug_detail.add(hmBatchDtl.get("ITEM_CODE"));
						alloc_drug_detail.add(hmBatchDtl.get("BATCH_ID"));
						alloc_drug_detail.add(hmBatchDtl.get("EXPIRY_DATE"));
						alloc_drug_detail.add(((int)(req_qty))+"");
						alloc_drug_detail.add(qty_uom);
						alloc_drug_detail.add("");
						alloc_drug_detail.add(hmBatchDtl.get("TRADE_ID"));
						alloc_drug_detail.add(hmBatchDtl.get("BIN_LOCATION_CODE"));
						item_cost	=	beanObj.getItemCost(item_code,store_code,req_qty+"",end_date);
						alloc_drug_detail.add(item_cost);
						alloc_drug_detail.add(qty_uom);//Added for MMS-SCF-0040 [IN:041888]
					}
					
					if(!calledFrom.equals("REALLOCATE") || beanObj_1.getStockDtl().containsKey("autoalloc") && beanObj_1.getStockDtl().get("autoalloc").equals("Y")){//Added for KDAH-CRF-0231 [IN-034551] -Start
						req_qty= Double.parseDouble(beanObj.getDrugQuantity(patient_id,order_id,order_line_no))+1;
					}
					else{
						req_drug_qty=beanObj.getDrugQuantity(patient_id,order_id,order_line_no);//Added for [IN:45912] - Start
						if(req_drug_qty.equals(""))
							req_drug_qty="0";
					    req_qty= Double.parseDouble(req_drug_qty);//Added for [IN:45912] - End
					}//Added for KDAH-CRF-0231 [IN-034551] -End
					if(!alt_drug_code.equals("") && calledFrom.equals("REALLOCATE")){
						beanObj.setAlternateDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail,alt_drug_code);
					}
					else{
						beanObj.setDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail);
						beanObj.setDrugQuantity(patient_id,order_id,order_line_no,req_qty);
					}
					out.println("validbarcode('true','"+dup_count+"','"+calledFrom+"','"+scan_key+"','"+entry_type+"','"+bar_code_scan_site_YN+"','"+scan_count_inc+"','"+act_patient_class+"','"+scan_count_required_yn+"','"+alert_required_yn+"','"+remarks_required_yn+"','"+patient_id+"','"+beanObj_1.getEncounterID()+"','"+disp_stage+"')"); // calledFrom Added for MMS-DM-SCF-0083scan_key,entry_type ,bar_code_scan_site_YN,scan_count_inc added for MMS-DM-CRF-157.1 scan_count_required_yn,alert_required_yn,remarks_required_yn,act_patient_class added for MMS-DM-CRF-0170
				}
				else{
					out.println("validbarcode('false','"+allowMoreQty_yn+"','"+calledFrom+"','"+scan_key+"','"+entry_type+"','"+bar_code_scan_site_YN+"','"+scan_count_inc+"','"+act_patient_class+"','"+scan_count_required_yn+"','"+alert_required_yn+"','"+remarks_required_yn+"','"+patient_id+"','"+beanObj_1.getEncounterID()+"','"+disp_stage+"')"); // calledFrom Added for MMS-DM-SCF-0083)");scan_key,entry_type ,bar_code_scan_site_YN,scan_count_inc added for MMS-DM-CRF-157.1 scan_count_required_yn,alert_required_yn,remarks_required_yn,act_patient_class added for MMS-DM-CRF-0170
				}
			}
			else{
				if(stock!=null && stock.containsKey("EXCEPTION"))
					out.println("validbarcode('false','"+stock.get("EXCEPTION").toString()+"','"+calledFrom+"','"+scan_key+"','"+entry_type+"','"+bar_code_scan_site_YN+"','"+scan_count_inc+"','"+act_patient_class+"','"+scan_count_required_yn+"','"+alert_required_yn+"','"+remarks_required_yn+"','"+patient_id+"','"+beanObj_1.getEncounterID()+"','"+disp_stage+"')"); // calledFrom Added for MMS-DM-SCF-0083 scan_key,entry_type added for MMS-DM-CRF-157.1 scan_count_required_yn,alert_required_yn,remarks_required_yn,act_patient_class added for MMS-DM-CRF-0170
				else
					out.println("validbarcode('false','INVALID','"+calledFrom+"','"+scan_key+"','"+entry_type+"','"+bar_code_scan_site_YN+"','"+scan_count_inc+"','"+act_patient_class+"','"+scan_count_required_yn+"','"+alert_required_yn+"','"+remarks_required_yn+"','"+patient_id+"','"+beanObj_1.getEncounterID()+"','"+disp_stage+"')"); // calledFrom Added for MMS-DM-SCF-0083 scan_key,entry_type ,bar_code_scan_site_YN,scan_count_inc added for MMS-DM-CRF-157.1 scan_count_required_yn,alert_required_yn,remarks_required_yn,act_patient_class added for MMS-DM-CRF-0170
			}
			putObjectInBean(bean_id_1,beanObj_1,request);
		}//Added for KDAH-CRF-0231 [IN-034551]. - End 
		else if(func_mode!= null && func_mode.equals("storeAltDrugRemarks")){// Added for Bru-HIMS-CRF-082 [IN:029948]-start
			String order_id=(String)hash.get("order_id");
			String order_line_num=(String)hash.get("order_line_num");
			String alt_drug_remarks = hash.get("alt_drug_remarks")==null?"":(String)hash.get("alt_drug_remarks");
			beanObj.setAltDrugRemarks(order_id+"~"+order_line_num, java.net.URLDecoder.decode(alt_drug_remarks,"UTF-8"));
				
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject("DispMedicationBean", "ePH.DispMedicationBean", request);
			if((beanObj_1.getDispStage().equals("F")&&(beanObj_1.getDispLocnCatg().equals("O")))|| beanObj_1.getFillList().equals("AF")){ 
				beanObj_1.setValuesChanged(true);
			}
		} // Added For Bru-HIMS-CRF-082 [IN:029948] --end
		else if(func_mode.equals("addActiveDrug") || func_mode.equals("recordDrug")){// Added for Bru-HIMS-CRF-072.1[IN 049144] start
			MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request); 
			String drug_code=CommonBean.checkForNull((String)hash.get("drug_code"));
			String order_id=CommonBean.checkForNull((String)hash.get("order_id"));
			String order_line_no=CommonBean.checkForNull((String)hash.get("order_line_no"));
			String drug_name = java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("drug_name")),"UTF-8");
			String loc_lang_id = medplan_bean.getStrLocalLangID();
			String primary_lang_id = medplan_bean.getStrPrimaryLangID();
			LinkedHashMap hshmap = new LinkedHashMap();
			hshmap.put("drug_name",drug_name);
			hshmap.put("drug_code",drug_code);
			hshmap.put("qty_issue",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("qty_issue")),"UTF-8"));
			hshmap.put("qty_issuelocal",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("qty_issuelocal")),"UTF-8"));
			hshmap.put("curr_disp_yn",CommonBean.checkForNull((String)hash.get("curr_disp_yn")));
			hshmap.put("merge_yn",CommonBean.checkForNull((String)hash.get("merge_yn")));
			hshmap.put("merged_med_plan_id",CommonBean.checkForNull((String)hash.get("merged_med_plan_id")));
			hshmap.put("pres_drug_code",CommonBean.checkForNull((String)hash.get("pres_drug_code")));
			hshmap.put("disp_drug_code",CommonBean.checkForNull((String)hash.get("disp_drug_code")));
			hshmap.put("plan_recorded",CommonBean.checkForNull((String)hash.get("recorded")));
			hshmap.put("impnote",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("impnote")),"UTF-8"));
			hshmap.put("howtotakelocal",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("howtotakelocal")),"UTF-8"));
			hshmap.put("impnotelocal",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("impnotelocal")),"UTF-8"));
			hshmap.put("howtotake",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("howtotake")),"UTF-8"));
			hshmap.put("drug_name_local",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("drug_name_local")),"UTF-8"));
			hshmap.put("order_id",order_id);
			hshmap.put("order_line_no",order_line_no);
			hshmap.put("chkdrug",CommonBean.checkForNull((String)hash.get("chkdrug")));
			if(((String)hshmap.get("chkdrug")).equals("D"))
				hshmap.put("checked","");
			else if (((String)hshmap.get("chkdrug")).equals("E"))
				hshmap.put("checked","checked");
			if(func_mode.equals("recordDrug")){
				String lang_id = CommonBean.checkForNull((String)hash.get("lang_id"));
				String link = CommonBean.checkForNull((String)hash.get("link"));
				hshmap.put("lang_id",lang_id);
				hshmap.put("encounter_id",CommonBean.checkForNull((String)hash.get("encounter_id")));
				hshmap.put("patient_id",CommonBean.checkForNull((String)hash.get("patient_id")));
				hshmap.put("morning",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("morning")),"UTF-8"));
				hshmap.put("afternoon",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("afternoon")),"UTF-8"));
				hshmap.put("evening",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("evening")),"UTF-8"));
				hshmap.put("night",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("night")),"UTF-8"));
				hshmap.put("morninglocal",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("morninglocal")),"UTF-8"));
				hshmap.put("afternoonlocal",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("afternoonlocal")),"UTF-8"));
				hshmap.put("eveninglocal",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("eveninglocal")),"UTF-8"));
				hshmap.put("nightlocal",java.net.URLDecoder.decode(CommonBean.checkForNull((String)hash.get("nightlocal")),"UTF-8"));
				hshmap.put("disp_no",CommonBean.checkForNull((String)hash.get("disp_no")));
				hshmap.put("disp_srl_no",CommonBean.checkForNull((String)hash.get("disp_srl_no")));
				hshmap.put("medicationplanner_flag","true");//added for ML-BRU-SCF-1521.1 [IN:055331](medication planner point alone)
				
				if(lang_id.equals(primary_lang_id)){
					medplan_bean.setMedPlan_DrugDetails(order_id+"_"+order_line_no+"_"+drug_code+"_"+lang_id, hshmap);
					if(((String)hshmap.get("curr_disp_yn")).equals("N") && ((String)hshmap.get("plan_recorded")).equals("N") && link.equals(lang_id))
						medplan_bean.getMedPlan_DrugDetails().remove(order_id+"_"+order_line_no+"_"+drug_code+"_"+lang_id);
				}
				if(lang_id.equals(loc_lang_id)){
					medplan_bean.setMedPlan_Local_DrugDetails(order_id+"_"+order_line_no+"_"+drug_code+"_"+loc_lang_id, hshmap);
					if(((String)hshmap.get("curr_disp_yn")).equals("N") && ((String)hshmap.get("plan_recorded")).equals("N") && link.equals(lang_id))
						medplan_bean.getMedPlan_Local_DrugDetails().remove(order_id+"_"+order_line_no+"_"+drug_code+"_"+lang_id);
				}
				medplan_bean.setMedValuesChanged(true);
			}
			else{
				String dose[] = new String[4],doselocal[] = new String[4];
				dose = medplan_bean.getDoseDetails(order_id, order_line_no,primary_lang_id,drug_code,drug_code);
				doselocal = medplan_bean.getDoseDetails(order_id, order_line_no,loc_lang_id,drug_code,drug_code);
				hshmap.put("morning",dose[0]);
				hshmap.put("afternoon",dose[1]);
				hshmap.put("evening",dose[2]);
				hshmap.put("night",dose[3]);
				hshmap.put("morninglocal",doselocal[0]);
				hshmap.put("afternoonlocal",doselocal[1]);
				hshmap.put("eveninglocal",doselocal[2]);
				hshmap.put("nightlocal",doselocal[3]);
				medplan_bean.setMedPlan_DrugDetails(order_id+"_"+order_line_no+"_"+drug_code+"_"+primary_lang_id, hshmap);
				medplan_bean.setMedPlan_Local_DrugDetails(order_id+"_"+order_line_no+"_"+drug_code+"_"+loc_lang_id, hshmap);
			}
		}
		else if(func_mode.equals("updateMedPlan")){
			MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request);
			String patient_id=CommonBean.checkForNull((String)hash.get("patient_id"));
			String mediplan_seq_no=CommonBean.checkForNull((String)hash.get("mediplan_seq_no"));
			String encounter_id=CommonBean.checkForNull((String)hash.get("encounter_id"));
			boolean isMedValuesChanged=medplan_bean.isMedValuesChanged();
			if(isMedValuesChanged){
				if(!mediplan_seq_no.equals(""))
					medplan_bean.updateMediPlan(patient_id,mediplan_seq_no);
				else 
					medplan_bean.insertMediPlan(patient_id);
			}
		}
		else if(func_mode.equals("getDetailsBasedonMedPlanid")){
			MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request);
			DispMedicationBean dispBean = (DispMedicationBean)getBeanObject( "DispMedicationBean", "ePH.DispMedicationBean",request);
			DispMedicationAllStages all_bean = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages",request);
			String patient_id=CommonBean.checkForNull((String)hash.get("patient_id"));
			String mediplan_seq_no=CommonBean.checkForNull((String)hash.get("medplanid"));
			String encounter_id=CommonBean.checkForNull((String)hash.get("encounter_id"));
			String order_date_from=CommonBean.checkForNull((String)hash.get("order_date_from"));
			String order_date_to=CommonBean.checkForNull((String)hash.get("order_date_to"));
			String disp_locn_code=CommonBean.checkForNull((String)hash.get("disp_locn_code"));
			String disp_locn_desc=CommonBean.checkForNull((String)hash.get("disp_locn_desc"));
			String disp_stage=CommonBean.checkForNull((String)hash.get("disp_stage"));
			String loc_lang_id = all_bean.getSMLOcalLanguageID();
			if(!mediplan_seq_no.equals("")){
				StringBuilder sb = new StringBuilder("'"+mediplan_seq_no+"',");
				ArrayList<String> mediplan_report_query  =new ArrayList<String>();
				mediplan_report_query.add(patient_id);//0
				mediplan_report_query.add(mediplan_seq_no);//1
				mediplan_report_query.add(order_date_from);//2
				mediplan_report_query.add(order_date_to);//3
				mediplan_report_query.add(disp_locn_code);//4
				mediplan_report_query.add(encounter_id);//5
				mediplan_report_query.add(disp_stage);//6
				
				dispBean.setDispLocnName(disp_locn_desc);
				dispBean.setDispLocnCode(disp_locn_code);//Added for [IN:051273]
				dispBean.setEncounterID(encounter_id);//Added for [IN:051273]
				dispBean.setPatientclass("OP");
				medplan_bean.setMediplan_report_query(mediplan_report_query);
				medplan_bean.setStrCalledFrom("Report");
				medplan_bean.setStrTotal_gross_charge_amount("");
				medplan_bean.setStrPrimaryLangID("en");
				medplan_bean.setStrLocalLangID(loc_lang_id);
				medplan_bean.clearMediPlanSeqNo();
				medplan_bean.setMedValuesChanged(false);
				medplan_bean.setMediPlanSeqNo(mediplan_seq_no);
				medplan_bean.clearMedPlan_DrugDetails();
				medplan_bean.clearMedPlan_Local_DrugDetails();
				medplan_bean.getDetailsBasedonMedPlanid(patient_id, sb);
			}
		}
		else if(func_mode.equals("cancelDrug")){
			MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request);
			HashMap hshmedplan = medplan_bean.getMedPlan_DrugDetails();
			HashMap hshTemp = new HashMap();
			List <String> arrTemp= new ArrayList<String>();
			Set <String> hshKeys = new HashSet<String>();
			hshKeys = hshmedplan.keySet();
			if(hshKeys!=null && hshKeys.size()>0){
				for(String key:hshKeys){
					hshTemp = (HashMap)hshmedplan.get(key);
					if(((String)hshTemp.get("curr_disp_yn")).equals("N") && !((String)hshTemp.get("plan_recorded")).equals("Y"))
						arrTemp.add(key);
				}
			}
			hshmedplan =  medplan_bean.getMedPlan_Local_DrugDetails();
			hshKeys = hshmedplan.keySet();
			if(hshKeys!=null && hshKeys.size()>0){
				for(String key:hshKeys){
					hshTemp = (HashMap)hshmedplan.get(key);
					if(((String)hshTemp.get("curr_disp_yn")).equals("N") && !((String)hshTemp.get("plan_recorded")).equals("Y"))
						arrTemp.add(key);
				}
			}
			for(String temp: arrTemp){
				medplan_bean.getMedPlan_DrugDetails().remove(temp);
				medplan_bean.getMedPlan_Local_DrugDetails().remove(temp);
			}
		}// Added for Bru-HIMS-CRF-072.1[IN 049144] end
		else if(func_mode!= null && func_mode.equals("setlabelLangId")){ //added for Bru-HIMS-CRF-414 [IN:045554]
			String labelLangId = beanObj.checkForNull((String)hash.get( "labelLangId"),"en");
			String	bean_id_1			=	"DispMedicationBean" ;
			String	bean_name_1			=	"ePH.DispMedicationBean";
			DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
			bean_1.SetEditableLabelLangId(labelLangId);
			putObjectInBean(bean_id_1,bean_1,request);
		}else if(func_mode!= null && func_mode.equals("updateReviewDetails")){
			DispMedicationAllStages beanObject =null;
			String login_user				= (String) hash.get("reviewed_by");
			String calling_func			= (String) hash.get("calling_func");
			String order_id			= (String) hash.get("order_id");
			String order_line_no			= (String) hash.get("order_line_no");
			String allergy_cnt			= (String) hash.get("allergy_cnt");
			String alergy_details			= (String) hash.get("alergy_details");
			String duplicate_details			= (String) hash.get("duplicate_details");
			String dosage_details			= (String) hash.get("dosage_details");
			String intaraction_details      =(String) hash.get("intaraction_details");
			String bean_id_remarks	 = (String)hash.get("bean_id");
			String bean_name_remarks = (String)hash.get("bean_name");
			beanObject		= (DispMedicationAllStages)getBeanObject(bean_id_remarks, bean_name_remarks,request);	
			beanObject.setLanguageId(locale);
			beanObject.updateReviewDetails(login_user,calling_func,order_id,order_line_no,allergy_cnt,alergy_details,dosage_details,duplicate_details,intaraction_details);
			
		
		}else if(func_mode!= null && func_mode.equals("ApprovalNo")){ //added for AAKH-CRF-0117 - start
			
			String	bean_id_1			=	"DispMedicationBean" ;
			String	bean_name_1			=	"ePH.DispMedicationBean";
			DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
			
			
			String tot_rec				= (String) hash.get("tot_rec");
			String approval_no = (String)hash.get("approval_no");
			String order_id = "";
			String order_line_no = "";
			String drug_code="";
			for (int i=1;i<Integer.parseInt(tot_rec);i++ ){
				order_id = (String)hash.get("order_id_"+i);
				order_line_no = (String)hash.get("order_line_num_"+i);
				//drug_code = (String)hash.get("drug_code_"+i);
				bean_1.setApprovalNo(order_id,order_line_no,approval_no);//modified for AAKH-CRF-0117
			}
		 
		putObjectInBean(bean_id_1,bean_1,request);
 		}else if(func_mode!= null && func_mode.equals("ApprovalNoForDrug")){ //added for AAKH-CRF-0117 - start
			
			String	bean_id_1			=	"DispMedicationBean" ;
			String	bean_name_1			=	"ePH.DispMedicationBean";
			DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
			
			
			 
			String approval_no = (String)hash.get("approval_no");
			String order_id = "";
			String order_line_no = "";
			String drug_code="";
 
			order_id = (String)hash.get("order_id");
			order_line_no = (String)hash.get("order_line_num");
			//drug_code = (String)hash.get("drug_code");
			bean_1.setApprovalNo(order_id,order_line_no,approval_no);
  		putObjectInBean(bean_id_1,bean_1,request);
 		}//added for IN070605 end
 		 		
 		
		putObjectInBean(bean_id,beanObj,request);
	
	

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
