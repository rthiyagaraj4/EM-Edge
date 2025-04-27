package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import eOR.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __ivprescriptionbuttons extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/IVPrescriptionButtons.jsp", 1709120894899L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<HTML>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<HEAD>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/IVPiggyBack.js\"></SCRIPT>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/IVPrescriptionWithAdditives.js\"></SCRIPT>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/IVPrescription.js\"></SCRIPT>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\t</HEAD>\n\t<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" > \n\t<FORM name=\"formIVPrescriptionButtons\" id=\"formIVPrescriptionButtons\">\n\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n\t\t\t<TR>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<TD align=\"left\" class=\"label\" >&nbsp;&nbsp;";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<b><label class=\"label\" id=\"dflt_disp_locn_lbl\" name=\"dflt_disp_locn_lbl\" >&nbsp;";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" <label></b>\n\t\t\t\t</TD>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<TD align=\"right\" > \n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t<!--\t<IMG SRC=\"../images/DrugInteractions.gif\" onMouseOver=\"changeCursor(this)\" onClick=\"viewInteraction(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\', \'\', \'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');\" HEIGHT=\"20\"> -->\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t<INPUT TYPE=\"button\" CLASS=\"button\" name=\"ChargeDetails\" id=\"ChargeDetails\" VALUE=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' onClick=\"displayChargeDetails(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\')\"> <!-- default_comp_fluid_falg added for ML-MMOH-CRF-1223 -->\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" \n\t\t\t\t\t\t<INPUT TYPE=\"button\" CLASS=\"button\" name=\"ChargeDetails\" id=\"ChargeDetails\" VALUE=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\')\">\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" \n\t\t\t\t<INPUT TYPE=\"button\" CLASS=\"button\" name=\"PREVIEW\" id=\"PREVIEW\" VALUE=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' onClick=\"previewRX(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\" style=\'display:";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'><!--style //added for ML-MMOH-CRF-0341 [IN:057179] default_comp_fluid_falg added for ML-MMOH-CRF-1223 -->\n\t\t\t\t<INPUT TYPE=\"button\" CLASS=\"button\" name=\"RELEASE\" id=\"RELEASE\" VALUE=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' onClick=\"releaseRX(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'><!--style //added for ML-MMOH-CRF-0341 [IN:057179]  default_comp_fluid_falg added for ML-MMOH-CRF-1223-->\n\t\t\t\t<INPUT TYPE=\"button\" CLASS=\"button\" name=\"PREVIEW\" id=\"PREVIEW\" VALUE=\'Preview & Release RX\' onClick=\"previewRX(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'><!--button //added for ML-MMOH-CRF-0341 [IN:057179]  default_comp_fluid_falg added for ML-MMOH-CRF-1223-->\n\t\t\t\t<INPUT TYPE=\"button\" CLASS=\"button\" name=\"CLEAR\" id=\"CLEAR\" VALUE=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' onClick=\"callClearAll(1)\" ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =">\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t</TABLE>\n\t\t<input type=\'hidden\' name=\'iv_prep_yn\' id=\'iv_prep_yn\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t    <input type=\'hidden\' name=\'time_flag\' id=\'time_flag\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t<input type=\'hidden\' name=\'time_flag\' id=\'time_flag\' value=\'\'>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t</FORM>\n\t</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );
	
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
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
04/06/2020      IN072753           Prabha											   NMC-JD-CRF-0046
2/12/2020			6041			Shazana       					NMC-JD-CRF-0063
--------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

    Connection con			= null;//added for ml-mmoh-crf-1223
	PreparedStatement pstmt = null; // NMC-JD-CRF-0197
	ResultSet resultSet     = null; // NMC-JD-CRF-0197
	try{
	String patient_id			= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id			= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String iv_prep_yn			= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
	String location_type		= request.getParameter("location_type")==null?"":request.getParameter("location_type");
	String location_code		= request.getParameter("location_code")==null?"":request.getParameter("location_code");
	String take_home_medication = request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
	String priority				= request.getParameter("priority")==null?"":request.getParameter("priority");
	String	bl_install_yn		= request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
	String	order_id		= request.getParameter("order_id")==null?"":request.getParameter("order_id");//NMC-JD-CRF-0063 
	String act_pat_class = request.getParameter("act_pat_class")==null?"":request.getParameter("act_pat_class");//NMC-JD-CRF-0063 
	String  disp_locn_code=request.getParameter("disp_locn_code")==null?"":request.getParameter("disp_locn_code");
	String	bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
	iv_prep_yn = iv_prep_yn.trim();

	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";

	String or_mode			= request.getParameter("or_mode")==null?"":request.getParameter("or_mode");
	String mode				= request.getParameter("mode")==null?"":request.getParameter("mode");
	String time_flag		= "";
	String iv_with_additives		= "";
	String iv_without_additives		= "";
	String iv_intermittent		= "";
	String preview_rx_yn=request.getParameter("preview_rx_yn")==null?"":request.getParameter("preview_rx_yn"); //added for ML-MMOH-CRF-0341 [IN:057179]
	PrescriptionBean_1 beanPres = (PrescriptionBean_1)getBeanObject( "@PrescriptionBean_1"+patient_id+encounter_id,"ePH.PrescriptionBean_1",request) ;//Added NMC-JD-CRF-0063 start
		
	if(preview_rx_yn.equals("")){
		//PrescriptionBean_1 beanPres = (PrescriptionBean_1)getBeanObject( "@PrescriptionBean_1"+patient_id+encounter_id,"ePH.PrescriptionBean_1",request) ;
		preview_rx_yn=beanPres.getPreviewRxYN();
	}

	String previewManDisp = "none", previewReleaseDisp="inline";
	if(preview_rx_yn.equals("Y")){
		previewManDisp = "inline"; 
		previewReleaseDisp = "none";
	}
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id,bean_name, request);
	con				= ConnectionManager.getConnection(request);//added for ml-mmoh-crf-1223
	boolean default_comp_fluid_falg = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DEFAULT_COMP_FLUID_INF_OVER");// Added for ML-MMOH-CRF-1223
	boolean op_take_home_med_flag = eCommon.Common.CommonBean.isSiteSpecific(con,"PH", "OP_TAKE_HOME_MEDICATION");//added for NMC-JD-CRF-0063
	boolean  site_alw_disp_loc_drug_search_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_DISP_LOC_DRUG_SEARCH");//added for NMC-JD-CRF-0197
	String patient_class = bean.getPatientClass();
	String locale = bean.getLanguageId();
		System.out.println("patient_class: "+patient_class);  //added for NMC-JD-CRF-0063
	if(patient_class!=null){
		if(patient_class.equals("EM")|| patient_class.equals("OP")){
			if(op_take_home_med_flag){
				bean.setTakeHomeMedicationOp("Y");
			}else{
				bean.setTakeHomeMedicationOp("N");
			}
		}
	}//END
			if(beanPres.getOpDischMedInd()==null){
				bean.setOpDischMedInd("N");
			}
			else if(beanPres.getOpDischMedInd()!=null){
				bean.setOpDischMedInd(beanPres.getOpDischMedInd());
			}
			//END
			if(op_take_home_med_flag){//ADDED FOR NMC-JD-CRF-0063 [TFS:12491]
				if(beanPres.getPatient_class_tkHome()!=null && beanPres.getPatient_class_tkHome().equals("IP")){
					bean.setTakeHomeMedicationOp("N");  
				}
			}
	
	
	ArrayList ivLegends = bean.getIvLegends();
	if(ivLegends != null && ivLegends.size()>1){
		iv_with_additives		= (String)ivLegends.get(0);
		iv_without_additives	= (String)ivLegends.get(1);
		iv_intermittent			= (String)ivLegends.get(2);
	}

	String title_display = "";

	if(iv_prep_yn.equals("3") || iv_prep_yn.equals("4") ){
	    bean.setIVType("IVPB");
		title_display = iv_intermittent;
	}
	else if(iv_prep_yn.equals("1") || iv_prep_yn.equals("2") ){
	    bean.setIVType("IVD");
		title_display = iv_with_additives;
	}
    else if( iv_prep_yn.equals("5")  ){
	    bean.setIVType("IVWA");
		title_display = iv_without_additives;
	}
	System.out.println("getOrderDispenseLocation - IVPrescriptionButtons.jsp"); //ADDED FOR NMC-JD-CRF-0063 START
	System.out.println("getTakeHomeMedicationOp:  "+bean.getTakeHomeMedicationOp());
	System.out.println("getOpDischMedInd:  "+bean.getOpDischMedInd());//END
	if(op_take_home_med_flag && act_pat_class.equals("OP")){//added for NMC-JD-CRF-0063  
		if(order_id!=null && !order_id.equals("") && beanPres.getCalledFrom().equals("AMEND_ORDER")){    
			ArrayList amendDetails = (ArrayList) bean.getAmendDetails(order_id);   
			if(amendDetails.size()>0){
				bean.setOpDischMedInd((String)amendDetails.get(0));   
					bean.setTakeHomeMedicationOp("Y"); 
		} 
	}
}
	
	ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id); // Added empty parameter for Bru-HIMS-CRF-347 [IN:037862] -- Begin ,added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]
	String dflt_disp_locn	= "";
	if(ord_disp_location != null & ord_disp_location.size()>0){ 
		dflt_disp_locn		=	(String)ord_disp_location.get(2) ==null?"":(String)ord_disp_location.get(2);	
		if(!site_alw_disp_loc_drug_search_appl){
		bean.setDisp_locn_code((String)ord_disp_location.get(0)); //Added For NMC-JD-CRF-0046
		bean.setDisplocn((String)ord_disp_location.get(0));  //Added For NMC-JD-CRF-0046
		}
		time_flag			=	bean.ChkWorkingHours((String)ord_disp_location.get(0));
	} 
	String order_type_flag  =	bean.getOrder_type_flag();
	/*Added for NMC-JD-CRF-0197 start*/
			String drug_search_bean_id	="@DrugSearchBean"+patient_id+encounter_id; //Modified for TFS-16341
			String drug_search_bean_name			= "ePH.DrugSearchBean";
			DrugSearchBean drug_bean				= (DrugSearchBean)getBeanObject( drug_search_bean_id, drug_search_bean_name , request);
			drug_bean.setLanguageId(locale);
			if(site_alw_disp_loc_drug_search_appl) //added for NMC-JD-CRF-0197 
					{
						if(!disp_locn_code.equals("")){
							bean.setDisp_locn_code(disp_locn_code);
							bean.setDisplocn(disp_locn_code);
						} 
					
		                pstmt = con.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT27") );
						pstmt.setString(1,bean.getDisp_locn_code());
						pstmt.setString(2,bean.getLoginFacilityId());
						pstmt.setString(3,bean.getLanguageId());			
						resultSet = pstmt.executeQuery() ;											
						if(resultSet!=null && resultSet.next()){					
							dflt_disp_locn = resultSet.getString("SHORT_DESC");				
						}

						bean.closeStatement(pstmt);
						bean.closeResultSet(resultSet);						
					}
			
	/*Added for NMC-JD-CRF-0197 end*/
	

            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
			
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

		if(bean.getIVType().equals("IVPB")){

            _bw.write(_wl_block10Bytes, _wl_block10);

		}
		else if(bean.getIVType().equals("IVD")) { 

            _bw.write(_wl_block11Bytes, _wl_block11);

		} 
		else {	

            _bw.write(_wl_block12Bytes, _wl_block12);
	
		}	

            _bw.write(_wl_block13Bytes, _wl_block13);
   //  For IV-Fluids - Dispense Location value will be hidden here and moved - for Bru-HIMS-CRF-347 [IN:037862]
			if(!bean.getIVType().equals("IVWA")) {
			
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(dflt_disp_locn));
            _bw.write(_wl_block16Bytes, _wl_block16);

			}
			
            _bw.write(_wl_block17Bytes, _wl_block17);
	
				if(or_mode==null){	
					or_mode="";
				}
	
				or_mode					= bean.getOrMode();
				HashMap MFRRecs			= new HashMap();
				MFRRecs					= bean.getMFRRecs();
				String reset_disabled	= "";

				if(mode.equals("amend") && MFRRecs!=null && MFRRecs.size()>0){
					reset_disabled		= "disabled";
				}

				ArrayList drugList		= bean.getDrugDetails();
/* //Commented for FDB Tuning - start - can be removed the code if not required
				ArrayList exProd		= new ArrayList();
				ArrayList drugDesc		= new ArrayList();
				for(int i=0;i<drugList.size();i++) {
					HashMap drugDetails = (HashMap)drugList.get(i);
					if (drugDetails.size() != 0) {
						String extprod	= (String)drugDetails.get("EXTERNAL_PRODUCT_ID");

						if (!extprod.equals("")) {
							drugDesc.add((String)drugDetails.get("SHORT_DESC"));
							exProd.add(extprod);
						}
					}
				}
				if (drugDesc.size()>=2) {
					String beanid1		= "@ExternalProductLinkBean"+patient_id+encounter_id ;
					String beanname1	= "ePH.ExternalProductLinkBean";
					ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject( beanid1, beanname1 , request) ;

					//Store Drug ids
					if(exProd.size() > 0){
						beanex.storeDrugIds(patient_id, "", exProd, drugDesc);
					}
					//Store interactions
					HashMap drug_Details =	new HashMap();
					if (!drug_Details.isEmpty()) { */

            _bw.write(_wl_block18Bytes, _wl_block18);
/*= patient_id */
            _bw.write(_wl_block19Bytes, _wl_block19);
/*= encounter_id*/ 
            _bw.write(_wl_block20Bytes, _wl_block20);

			/*		}
					putObjectInBean(beanid1,beanex,request);
				}*/ //Commented for FDB Tuning - end
 
				if(bean.getIVType().equals("IVD")){
					if(!mode.equals("amend")){
						if(drugList.size()>0 && bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){

            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(default_comp_fluid_falg));
            _bw.write(_wl_block24Bytes, _wl_block24);

						}
					}
					else{
						if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){

            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(default_comp_fluid_falg));
            _bw.write(_wl_block24Bytes, _wl_block24);

						}
					}
				}
				else{
						
					if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
		

            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);

					}
				}	

            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(title_display));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(default_comp_fluid_falg));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(previewReleaseDisp));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(default_comp_fluid_falg));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(previewReleaseDisp));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(title_display));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(default_comp_fluid_falg));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(previewManDisp));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(reset_disabled));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);

		if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(time_flag));
            _bw.write(_wl_block36Bytes, _wl_block36);

		}
		else{

            _bw.write(_wl_block38Bytes, _wl_block38);

		}

            _bw.write(_wl_block39Bytes, _wl_block39);

putObjectInBean(bean_id,bean,request);
}catch(Exception e){
		e.printStackTrace();
}
finally{ // Added for ML-MMOH-SCF-1223 - start
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
} // Added for ML-MMOH-crf-1223 end

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseLocation.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeDetails.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeDetails.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChargeDetails.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PreviewRx.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReleaseRx.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reset.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }
}
