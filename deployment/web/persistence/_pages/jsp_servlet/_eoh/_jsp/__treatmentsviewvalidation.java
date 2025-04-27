package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eOH.*;
import webbeans.eCommon.ConnectionManager;
import eOR.OrderEntryBillingQueryBean;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __treatmentsviewvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/TreatmentsViewValidation.jsp", 1709117130332L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
	}

	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt = null;
	ResultSet rst2 = null;
	ResultSet rst1 = null;
	ResultSet rst = null;


	String oh_bean_id 		= "OHBillingBean";
	String oh_bean_name 	= "eOH.OHBillingBean";
	OHBillingBean oh_bean	= (OHBillingBean)getBeanObject( oh_bean_id, oh_bean_name, request );

	//String or_bean_id 		= "Or_billingQueryBean";
	//String or_bean_name 	= "eOR.OrderEntryBillingQueryBean";
	//OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request );

	String facility_id      = (String) session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("LOCALE"); 
	String func_mode = request.getParameter( "func_mode" ) ;
	//String called_from1 = checkForNull(request.getParameter("otFlag"));
	//String trmtYn = checkForNull(request.getParameter("trmtYn"));


	String trace_no = "0";
	try{
		con = ConnectionManager.getConnection();
		if(func_mode.equalsIgnoreCase("populateBaseLineChart")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String sql				= "";		
			String chart_date = "";
			String chart_num = "";
			String clinical_group_code = "";
			String chart_type = "";

			StringBuffer date_type = new StringBuffer();
			//StringBuffer chart_dtls = new StringBuffer();
			
				sql = "SELECT TO_CHAR(CHART_DATE,'DD/MM/YYYY') CHART_DATE, CHART_TYPE, CHART_NUM, CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID= ? AND PATIENT_ID = ? AND CHART_STATUS = 'C' ORDER BY CHART_NUM DESC";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					//chart_dtls.setLength(0);
					// The below order should not be changed, as it is being used in the js file.
					chart_date = rst.getString("CHART_DATE");		//  1
					chart_num = rst.getString("CHART_NUM");		//  2
					clinical_group_code = rst.getString("CLINICAL_GROUP_CODE");		//  3
					chart_type = rst.getString("CHART_TYPE");		//  3
					// The below order should not be changed, as it is being used in the js file.
					date_type.append(chart_date+"##"+chart_num+"##"+clinical_group_code+"##"+chart_type); 
					date_type.append("~");
				}
				out.println(date_type);
		}else if(func_mode.equalsIgnoreCase("populateTreatmentsToDo")){	
			
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String tooth_numbering_system = checkForNull(request.getParameter( "tooth_numbering_system" )) ;
			//String permanent_deciduous_flag = checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String episode_type = checkForNull(request.getParameter( "episode_type" )) ;
			String episode_id = checkForNull(request.getParameter( "episode_id" )) ;
			String visit_id = checkForNull(request.getParameter( "visit_id" )) ;
			String encounter_id = checkForNull(request.getParameter( "encounter_id" )) ;
			String pract_staff_id = checkForNull(request.getParameter( "practitioner_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String patient_class = checkForNull(request.getParameter( "patient_class" )) ;
			//Added by Sharon Crasta on 3/30/2010 for IN018302
			//commented and added by parul on 29/04/2010 for IN021055
			//String asOnDate = checkForNull(request.getParameter( "asOnDate" )) ;
			String asOnDate = com.ehis.util.DateUtils.convertDate(checkForNull(request.getParameter("asOnDate")),"DMY",locale,"en");  
			String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" )) ;
			//End
			String sql				= "";		
			String date = "";
			//String type = "";
			String type_desc = "";
			String arch_desc = "";
			String quad_desc = "";
			String arch_quad = "";
			String status = "";
			String trmt_code = "";
			String remarks = "";
			String site_type = "";
			String thrang_ref = "";
			String chart_line_num = "";
			String str_chart_line_num="";
			String order_id="";
			String order_line_num="";
			String deciduous_yn = "";
			String supernumerary_yn = "";
			String display_tooth_no = "";
			String intraoral_extraoral = "";

			//String dentist_comments = "";
			String sub_organ_code_1 = "";
			String bl_episode_type = "";

			String cusp_tip_code = "";//added by parul on 22/01/2010 for CRF-442
			String super_key_num = "";//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894

			//String patient_payable = "";
			//String patient_paid_amt = "";
			String total_payable = "";
			ArrayList bl_str_list = null;
			//HashMap bill_info = null;
			String max_str="";
			//int count_range = 1;
			StringBuffer date_type = new StringBuffer();
			StringBuffer chart_dtls = new StringBuffer();
			String[] tooth_range_arr = null;		
           //A.SUPER_TOOTH_NO added in query by parul on 11/12/2009 for super changes.
		   String super_tooth_no="";
		   String retained_tooth_no="";

			ArrayList episode_visit_list = oh_bean.getEpisodeAndVisitId(encounter_id);
			episode_id = (String) episode_visit_list.get(0);
			visit_id = (String) episode_visit_list.get(1);


			/* Commented by Sridevi Joshi on 28/11/2008 to remove PERMANENT_DECIDUOUS column reference from OH_QUADRANT_LANG_VW */
			//sql = "SELECT A.QUADRANT_SNO,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, REMARKS, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, NVL(A.TOOTH_NO,'') TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO AND G.PERMANENT_DECIDUOUS=?) QUADRANT_DESC, A.TRMT_CODE, A.SURFACE_CODE, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.TREATMENTS_OUTCOME, ORDER_ID, (SELECT K.ORDER_LINE_NUM FROM OR_ORDER_LINE K WHERE K.ORDER_ID = A.ORDER_ID) ORDER_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND  TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'I' AND A.CHART_NUM = ? AND (STATUS IS NULL OR STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE NOT IN ('60','E'))) AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC"; 

			//Commented by Sharon Crasta on  3/14/2009 to remove OPERATING_FACILITY_ID for Enterprise
			//sql = "SELECT A.QUADRANT_SNO,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, REMARKS, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, NVL(A.TOOTH_NO,'') TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.TRMT_CODE, A.SURFACE_CODE, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.TREATMENTS_OUTCOME, ORDER_ID, (SELECT K.ORDER_LINE_NUM FROM OR_ORDER_LINE K WHERE K.ORDER_ID = A.ORDER_ID) ORDER_LINE_NUM, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND  TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'I' AND A.CHART_NUM = ? AND (STATUS IS NULL OR STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE NOT IN ('60','E'))) AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC"; 
			//Commented on 6/18/2009 by Sharon Crasta for IN010066
			//sql = "SELECT A.QUADRANT_SNO,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, REMARKS, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, NVL(A.TOOTH_NO,'') TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.TRMT_CODE, A.SURFACE_CODE, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.TREATMENTS_OUTCOME, ORDER_ID, (SELECT K.ORDER_LINE_NUM FROM OR_ORDER_LINE K WHERE K.ORDER_ID = A.ORDER_ID) ORDER_LINE_NUM, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND  TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'I' AND A.CHART_NUM = ? AND (STATUS IS NULL OR STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE NOT IN ('60','E'))) AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC";

			//sql = "SELECT A.QUADRANT_SNO,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, REMARKS, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, NVL(A.TOOTH_NO,'') TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.TRMT_CODE, A.SURFACE_CODE, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.TREATMENTS_OUTCOME, A.ORDER_ID, (SELECT K.ORDER_LINE_NUM FROM OR_ORDER_LINE K WHERE K.ORDER_ID = A.ORDER_ID) ORDER_LINE_NUM, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND  TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'I' AND A.CHART_NUM = ? AND (STATUS IS NULL OR STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE NOT IN ('60','E'))) AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC"; 
			//String called_from = request.getParameter("otFlag");
			//Added by Sharon Crasta on 1/23/2010 for IN018302
			//Added to get the chart number according to the status of the chart.

			if(baseline_chart_yn.equals("Y")){
				sql = "SELECT A.CUSP_TIP_CODE,A.INTRAORAL_EXTRAORAL,A.ORGAN_CODE,A.SUB_ORGAN_CODE,A.QUADRANT_SNO,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, REMARKS, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, NVL(A.TOOTH_NO,'') TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.TRMT_CODE, A.SURFACE_CODE, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.TREATMENTS_OUTCOME, A.ORDER_ID, (SELECT K.ORDER_LINE_NUM FROM OR_ORDER_LINE K WHERE K.ORDER_ID = A.ORDER_ID) ORDER_LINE_NUM, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN ,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND  TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'I' AND A.CHART_NUM = ? AND (STATUS IS NULL OR STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE NOT IN ('60','E'))) AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC"; 
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale); // For OH_TRTMT_CATEGORY_TYPE_LANG_VW
				pstmt.setString(2,tooth_numbering_system); // For OH_TOOTH_BY_NUMBERING_SYSTEM
				pstmt.setString(3,locale); // For OH_ARCH_LANG_VW
				pstmt.setString(4,tooth_numbering_system); // For OH_ARCH_LANG_VW
				pstmt.setString(5,locale); // For OH_QUADRANT_LANG_VW
				pstmt.setString(6,tooth_numbering_system); // For OH_QUADRANT_LANG_VW
				//pstmt.setString(7,permanent_deciduous_flag); // For OH_QUADRANT_LANG_VW
				//pstmt.setString(7,facility_id);
				pstmt.setString(7,patient_id);
				pstmt.setString(8,chart_num);
			}
			else{
				sql = "SELECT A.CUSP_TIP_CODE,A.INTRAORAL_EXTRAORAL,A.ORGAN_CODE,A.SUB_ORGAN_CODE,A.QUADRANT_SNO,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, REMARKS, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, NVL(A.TOOTH_NO,'') TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.TRMT_CODE, A.SURFACE_CODE, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.TREATMENTS_OUTCOME, A.ORDER_ID, (SELECT K.ORDER_LINE_NUM FROM OR_ORDER_LINE K WHERE K.ORDER_ID = A.ORDER_ID) ORDER_LINE_NUM, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN ,A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND  TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'I' AND A.CHART_NUM = (SELECT MAX (CHART_NUM) FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND TO_DATE (?, 'DD/MM/YYYY') BETWEEN TRUNC (CHART_DATE) AND TRUNC (NVL (CHART_CLOSE_DATE, SYSDATE))) AND (STATUS IS NULL OR STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE NOT IN ('60','E'))) AND NVL(A.COND_CLOSED_YN,'N') = 'N' AND TRUNC (A.TREATMENT_CONDITION_DATE) <= TO_DATE (?, 'DD/MM/YYYY') ORDER BY CHART_LINE_NUM DESC"; 
					
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale); // For OH_TRTMT_CATEGORY_TYPE_LANG_VW
				pstmt.setString(2,tooth_numbering_system); // For OH_TOOTH_BY_NUMBERING_SYSTEM
				pstmt.setString(3,locale); // For OH_ARCH_LANG_VW
				pstmt.setString(4,tooth_numbering_system); // For OH_ARCH_LANG_VW
				pstmt.setString(5,locale); // For OH_QUADRANT_LANG_VW
				pstmt.setString(6,tooth_numbering_system); // For OH_QUADRANT_LANG_VW
				//pstmt.setString(7,permanent_deciduous_flag); // For OH_QUADRANT_LANG_VW
				//pstmt.setString(7,facility_id);
				pstmt.setString(7,patient_id);
				//Added by Sharon Crasta on 3/30/2010 for IN018302
				//pstmt.setString(8,chart_num);
				pstmt.setString(8,patient_id);
				pstmt.setString(9,asOnDate);
				pstmt.setString(10,asOnDate);
				//End
				
			}	
			rst = pstmt.executeQuery();
			
			while(rst!= null && rst.next()){
				chart_dtls.setLength(0);
				// The below order should not be changed, as it is being used in the js file.
				type_desc = rst.getString("TRMT_CATEGORY_TYPE_DESC");		//  1
				date = rst.getString("TREATMENT_CONDITION_DATE");		//  2
				arch_desc = rst.getString("ARCH_DESC");		//  3
				quad_desc = rst.getString("QUADRANT_DESC");		//  4
				
				status = rst.getString("STATUS");		//  4
				trmt_code = rst.getString("TRMT_CODE");		//  4
				remarks = rst.getString("REMARKS");		//  4
				site_type = checkForNull(rst.getString("SITE_TYPE"));		//  4
				chart_line_num = rst.getString("CHART_LINE_NUM");		//  4
				order_id = rst.getString("ORDER_ID");		//  4
				order_line_num = rst.getString("ORDER_LINE_NUM");
				//dentist_comments = rst.getString("DENTIST_COMMENTS");//  4
				supernumerary_yn = rst.getString("SUPERNUMERARY_YN");		//  4
				deciduous_yn = rst.getString("MIXED_DENT_DECIDUOUS_YN");		//  4
				//dentist_comments = rst.getString("DENTIST_COMMENTS");
				sub_organ_code_1 = rst.getString("SUB_ORGAN_CODE");
				super_tooth_no = rst.getString("SUPER_TOOTH_NO");
				retained_tooth_no = rst.getString("RETAINED_TOOTH_NO");
				cusp_tip_code = rst.getString("CUSP_TIP_CODE");
				super_key_num = checkForNull(rst.getString("SUPER_KEY_NUM"));
				
				if(site_type.equals("THRNG") || ((site_type.equals("MAXFS") && (sub_organ_code_1!=("") && sub_organ_code_1!=(null) && sub_organ_code_1!=("null"))) && (sub_organ_code_1.equals("TNGAB") || sub_organ_code_1.equals("TNGGM") || sub_organ_code_1.equals("TNGAG") || sub_organ_code_1.equals("TNGGAM") || sub_organ_code_1.equals("TNGMF")))){
					trace_no="2";
					chart_dtls.append(rst.getString("CHART_NUM")+":");		//  5
					chart_dtls.append(rst.getString("CHART_LINE_NUM")+":"); //  6
					chart_dtls.append(rst.getString("CHART_STATUS")+":");	//  7
					chart_dtls.append(rst.getString("CHART_DATE")+":");		//  8
					chart_dtls.append(rst.getString("SITE_TYPE")+":");		//  9
					chart_dtls.append(rst.getString("TOOTH_NO")+":");		//  10
					chart_dtls.append(rst.getString("NS_TOOTH_NO")+":");	//  11
					chart_dtls.append(rst.getString("ARCH_SNO")+":");		// 12
					chart_dtls.append(rst.getString("QUADRANT_SNO")+":");	// 13
					chart_dtls.append(rst.getString("SURFACE_CODE")+":");	// 14
					chart_dtls.append(rst.getString("TRMT_CATEGORY_TYPE")+":");	// 15
					chart_dtls.append(rst.getString("TRMT_CODE")+":");		// 16
					chart_dtls.append(rst.getString("TOOTH_RANGE")+":");		// 17 added by Sridevi Joshi

					
					String thrng_nos = checkForNull(rst.getString("TOOTH_RANGE"));

					if(!thrng_nos.equals(null) && !thrng_nos.equals("") && thrng_nos.indexOf(",") != -1){
						tooth_range_arr = thrng_nos.split(",");
						//String[] temp_arr = null;
						
						//2$$5,3$$6
						String str="";
						
						String str1="";
						String str2="";
						int ind = 0;
						int z=0;
						int m=0;

						ind = thrng_nos.indexOf("$$");
						str_chart_line_num = thrng_nos.substring(0,ind);
						
						for(int i=0;i<tooth_range_arr.length;i++){
							str = tooth_range_arr[i];
							ind = str.indexOf("$$");
						   
							str = str.substring(ind+2,str.length());
                   
							
							pstmt1 = con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM=? AND TOOTH_NO=?");
							pstmt1.setString(1,tooth_numbering_system);
							pstmt1.setString(2,str);
							rst1 = pstmt1.executeQuery();
							
							while(rst1!= null && rst1.next()){
								if(z==0){
									thrang_ref = rst1.getString("NS_TOOTH_NO");
									str1=str;

								}
								else{
									thrang_ref = thrang_ref+","+rst1.getString("NS_TOOTH_NO");
									str2=str;


								}
								z++;
							}
							max_str=str1+","+str2;
							pstmt2 = con.prepareStatement("SELECT A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?)");
							pstmt2.setString(1,tooth_numbering_system);
							pstmt2.setString(2,str);
							rst2 = pstmt2.executeQuery();
							while(rst2!= null && rst2.next()){
								if(m==0){
									display_tooth_no = rst2.getString("NS_TOOTH_NO");
								}
								else{
									display_tooth_no = display_tooth_no+","+rst2.getString("NS_TOOTH_NO");;
								}
								m++;
								
							}
							if(rst2!=null)rst2.close();
							if(pstmt2!=null)pstmt2.close();
							if(rst1!=null)rst1.close();
							if(pstmt1!=null)pstmt1.close();
						
						}
					}
					chart_dtls.append(thrang_ref+":"); // 18 added by Sridevi Joshi

					//chart_dtls.append(rst.getString("CLINICAL_GROUP_CODE")+":");		// 19 added by Sridevi Joshi
					//chart_dtls.append(rst.getString("SURFACE_CODE")+":");		// 20 added by Sridevi Joshi
					//chart_dtls.append(rst.getString("LOCATION")+":");		// 21 added by Sridevi Joshi
					chart_dtls.append(rst.getString("STATUS")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("TREATMENTS_OUTCOME")+":");		// 23 added by Sridevi Joshi
					chart_dtls.append(rst.getString("INTRAORAL_EXTRAORAL")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("ORGAN_CODE")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("SUB_ORGAN_CODE"));		// 23 added by Sridevi Joshi
					
					//String site_type_temp = rst.getString("SITE_TYPE");
					if(rst.getString("SITE_TYPE").equals("ARCH")){
						arch_quad = arch_desc;
					}
					else if(rst.getString("SITE_TYPE").equals("QUAD")){
						arch_quad = quad_desc;
					}
					else if(rst.getString("SITE_TYPE").equals("MAXFS")){
						arch_quad = intraoral_extraoral;
					}
					
					/* To get the latest chnaged charges for the tasks..
					String key1 = "OHOP00000012842_"+chart_num;
					//bill_info = or_bean.getOrderBillDtls(key1+order_line_num);
					
					bill_info = oh_bean.getBillDetails1(trmt_code,episode_type,"OH",key1,order_line_num,patient_id,episode_id,visit_id, encounter_id,"1",pract_staff_id,facility_id,locale,"TRMT");

					if(bill_info == null){
						bill_info = oh_bean.getBillDetails1(trmt_code,episode_type,"OR","","",patient_id,episode_id,visit_id, encounter_id,"1",pract_staff_id,facility_id,locale,"TRMT");
						or_bean.setOrderBillDtls(order_id+order_line_num,bill_info);
						putObjectInBean(or_bean_id,or_bean,request);
					}
					
					total_payable = (String)bill_info.get("total_payable");
					*/
					//Commented on 6/18/2009 by Sharon Crasta for IN010066
					//bl_str_list = oh_bean.getBillDetails(trmt_code,episode_type,"OR","","",patient_id,episode_id,visit_id, encounter_id,"1",pract_staff_id,facility_id,locale,"TRMT");
					//bl_str_list = oh_bean.getBillDetails(trmt_code,episode_type,"OR",order_id,order_line_num,patient_id,episode_id,visit_id, encounter_id,"1",pract_staff_id,facility_id,locale,"TRMT");

					if(pstmt2 != null) pstmt2.close();
					if(rst2 != null) rst2.close();
					pstmt2 = con.prepareStatement("SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = ? AND EPISODE_TYPE =?");
					pstmt2.setString(1,patient_class);
					pstmt2.setString(2,episode_type);
					rst2 = pstmt2.executeQuery();
					while(rst2!= null && rst2.next()){
						bl_episode_type = checkForNull(rst2.getString("BL_EPISODE_TYPE"));
					}

					bl_str_list = oh_bean.getBillDetails(trmt_code,bl_episode_type,"OR","","",patient_id,episode_id,visit_id, encounter_id,"1",pract_staff_id,facility_id,locale,"TRMT");

					//Added checkForNull() for IN014722 by Sridevi Joshi.
					total_payable = checkForNull((String)bl_str_list.get(2));	

					
					if(!str_chart_line_num.equals(chart_line_num)){
						//count_range++;
						continue;
					}
					else{														
						//date_type.append(date+"##"+type_desc+"##"+rst.getString("NS_TOOTH_NO")+"##"+chart_dtls+"##"+arch_quad+"##"+status+"##"+order_id+"##"+trmt_code+"##"+remarks+"##"+site_type+"##"+thrang_ref+"##"+total_payable);
						//date_type.append("~");
						date_type.append(date+"OH_SEP_1"+type_desc+"OH_SEP_1"+rst.getString("NS_TOOTH_NO")+"OH_SEP_1"+chart_dtls+"OH_SEP_1"+arch_quad+"OH_SEP_1"+status+"OH_SEP_1"+order_id+"OH_SEP_1"+trmt_code+"OH_SEP_1"+remarks+"OH_SEP_1"+site_type+"OH_SEP_1"+thrang_ref+"OH_SEP_1"+total_payable+"OH_SEP_1"+deciduous_yn+"OH_SEP_1"+supernumerary_yn+"OH_SEP_1"+display_tooth_no+"OH_SEP_1"+sub_organ_code_1+"OH_SEP_1"+max_str+"OH_SEP_1"+super_key_num);

						date_type.append("OH_SEP_2");
					}					
				}
				else if(!site_type.equals("THRNG")){
					display_tooth_no = "";
					trace_no="3";
					//Added by Sridevi Joshi when testing CRf-709(IN012626)...thrang_ref taking the values from the record if we have any record for THRNG after for TOOTH.
					thrang_ref = "";
					//type = rst.getString("CONDITION_TREATMENT_TYPE");
					// The below order should not be changed, as it is being used in the js file.

					chart_dtls.append(rst.getString("CHART_NUM")+":");		//  5
					chart_dtls.append(rst.getString("CHART_LINE_NUM")+":"); //  6
					chart_dtls.append(rst.getString("CHART_STATUS")+":");	//  7
					chart_dtls.append(rst.getString("CHART_DATE")+":");		//  8
					chart_dtls.append(rst.getString("SITE_TYPE")+":");		//  9
					chart_dtls.append(rst.getString("TOOTH_NO")+":");		//  10
					chart_dtls.append(rst.getString("NS_TOOTH_NO")+":");	//  11
					chart_dtls.append(rst.getString("ARCH_SNO")+":");		// 12
					chart_dtls.append(rst.getString("QUADRANT_SNO")+":");	// 13
					chart_dtls.append(rst.getString("SURFACE_CODE")+":");	// 14
					chart_dtls.append(rst.getString("TRMT_CATEGORY_TYPE")+":");	// 15
					chart_dtls.append(rst.getString("TRMT_CODE")+":");		// 16
					chart_dtls.append(rst.getString("TOOTH_RANGE")+":");		// 17 added by Sridevi Joshi



					//Commemted by Sridevi Joshi when testing CRf-709(IN012626)...thrang_ref taking the values from the record if we have any record for THRNG after for TOOTH.(This block is not required for TOOTH)
					/*
					String thrng_nos = checkForNull(rst.getString("TOOTH_RANGE"));
					if(!thrng_nos.equals(null) && !thrng_nos.equals("") && thrng_nos.indexOf(",") != -1){
						tooth_range_arr = thrng_nos.split(",");
						//String[] temp_arr = null;
						
						//2$$5,3$$6
						String str="";
						int ind = 0;
						int z=0;
						for(int i=0;i<tooth_range_arr.length;i++){
							str = tooth_range_arr[i];
							ind = str.indexOf("$$");
							str = str.substring(ind+2,str.length());
							pstmt1 = con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM=? AND TOOTH_NO=?");
							pstmt1.setString(1,tooth_numbering_system);
							pstmt1.setString(2,str);
							rst1 = pstmt1.executeQuery();
							
							while(rst1!= null && rst1.next()){
								if(z==0){
									thrang_ref = rst1.getString("NS_TOOTH_NO");
								}
								else{
									thrang_ref = thrang_ref+","+rst1.getString("NS_TOOTH_NO");
								}
								z++;
							}
						}
					}*/
					chart_dtls.append(thrang_ref+":"); // 18 added by Sridevi Joshi

					//chart_dtls.append(rst.getString("CLINICAL_GROUP_CODE")+":");		// 19 added by Sridevi Joshi
					//chart_dtls.append(rst.getString("SURFACE_CODE")+":");		// 20 added by Sridevi Joshi
					//chart_dtls.append(rst.getString("LOCATION")+":");		// 21 added by Sridevi Joshi

					chart_dtls.append(rst.getString("STATUS")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("TREATMENTS_OUTCOME")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("INTRAORAL_EXTRAORAL")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("ORGAN_CODE")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("SUB_ORGAN_CODE")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("SUPERNUMERARY_YN"));		// 23 added by Sridevi Joshi

					
					String site_type_temp = checkForNull(rst.getString("SITE_TYPE"));
					if(site_type_temp.equals("ARCH")){
						arch_quad = arch_desc;
					}
					else if(site_type_temp.equals("QUAD")){
						arch_quad = quad_desc;
					}
					else if(site_type_temp.equals("MAXFS")){
						arch_quad = intraoral_extraoral;
					}

					pstmt1 = con.prepareStatement("SELECT A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?)");
					pstmt1.setString(1,tooth_numbering_system);
					pstmt1.setString(2,rst.getString("TOOTH_NO"));
					//pstmt1.setString(3,PD_flag);
					rst1 = pstmt1.executeQuery();
					while(rst1!= null && rst1.next()){
						display_tooth_no = rst1.getString("NS_TOOTH_NO");
					}
					
					/*
					BEFORE INCLUDING THE ORDER_ID
					date_type.append(date+"##"+type_desc+"##"+rst.getString("NS_TOOTH_NO")+"##"+chart_dtls+"##"+arch_quad+"##"+status);
					*/
					
					//Commented on 6/18/2009 by Sharon Crasta for IN010066			   
			 		//bl_str_list = oh_bean.getBillDetails(trmt_code,episode_type,"OR","","",patient_id,episode_id,visit_id, encounter_id,"1",pract_staff_id,facility_id,locale,"TRMT");
					//bl_str_list = oh_bean.getBillDetails(trmt_code,episode_type,"OR",order_id,order_line_num,patient_id,episode_id,visit_id, encounter_id,"1",pract_staff_id,facility_id,locale,"TRMT");

					if(pstmt2 != null) pstmt2.close();
					if(rst2 != null) rst2.close();
					pstmt2 = con.prepareStatement("SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = ? AND EPISODE_TYPE =?");
					pstmt2.setString(1,patient_class);
					pstmt2.setString(2,episode_type);
					rst2 = pstmt2.executeQuery();
					while(rst2!= null && rst2.next()){
						bl_episode_type = checkForNull(rst2.getString("BL_EPISODE_TYPE"));
					}

					bl_str_list = oh_bean.getBillDetails(trmt_code,bl_episode_type,"OR","","",patient_id,episode_id,visit_id, encounter_id,"1",pract_staff_id,facility_id,locale,"TRMT");

					//Added checkForNull() for IN014722 by Sridevi Joshi.
					total_payable = checkForNull((String)bl_str_list.get(2));
					//date_type.append(date+"##"+type_desc+"##"+rst.getString("NS_TOOTH_NO")+"##"+chart_dtls+"##"+arch_quad+"##"+status+"##"+rst.getString("ORDER_ID")+"##"+trmt_code+"##"+remarks+"##"+site_type+"##"+thrang_ref+"##"+total_payable);
					//date_type.append("~");
					date_type.append(date+"OH_SEP_1"+type_desc+"OH_SEP_1"+rst.getString("NS_TOOTH_NO")+"OH_SEP_1"+chart_dtls+"OH_SEP_1"+arch_quad+"OH_SEP_1"+status+"OH_SEP_1"+rst.getString("ORDER_ID")+"OH_SEP_1"+trmt_code+"OH_SEP_1"+remarks+"OH_SEP_1"+site_type+"OH_SEP_1"+thrang_ref+"OH_SEP_1"+total_payable+"OH_SEP_1"+deciduous_yn+"OH_SEP_1"+supernumerary_yn+"OH_SEP_1"+display_tooth_no+"OH_SEP_1"+rst.getString("TOOTH_NO")+"OH_SEP_1"+super_tooth_no+"OH_SEP_1"+retained_tooth_no+"OH_SEP_1"+cusp_tip_code+"OH_SEP_1"+super_key_num);
					date_type.append("OH_SEP_2");
					
				}	
				if(rst1!=null)rst1.close();
				if(rst2!=null)rst2.close();
				if(pstmt1!=null)pstmt1.close();
				if(pstmt2!=null)pstmt2.close();
			}
			out.println(date_type);
		}
		else if(func_mode.equalsIgnoreCase("populateTreatmentsDone")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String tooth_numbering_system = checkForNull(request.getParameter( "tooth_numbering_system" )) ;
			//String permanent_deciduous_flag = checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String episode_type = checkForNull(request.getParameter( "episode_type" )) ;
			String episode_id = checkForNull(request.getParameter( "episode_id" )) ;
			String visit_id = checkForNull(request.getParameter( "visit_id" )) ;
			String encounter_id = checkForNull(request.getParameter( "encounter_id" )) ;
			String pract_staff_id = checkForNull(request.getParameter( "practitioner_id" )) ;
			String sql				= "";		
			String date = "";
			//String type = "";
			String type_desc = "";
			String arch_desc = "";
			String quad_desc = "";
			String arch_quad = "";
			String status = "";
			String trmt_code = "";
			String remarks = "";
			String site_type = "";
			String chart_line_num = "";
			String str_chart_line_num="";
			String complication_code="";
			String order_id="";
			String order_line_num="";
			String supernumerary_yn="";
			String deciduous_yn="";
			String display_tooth_no="";
			String intraoral_extraoral="";
			String sub_organ_code_1="";
			//String patient_payable = "";
			//String patient_paid_amt = "";
			String total_payable = "";
			String super_tooth_no = "";
			String retained_tooth_no = "";
			String cusp_tip_code = "";//added by parul on 22/01/2010 for CRF-442
			String super_key_num = "";//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
			String failure_remarks = "";//Added by parul on 1/24/2010 for (CRF-477 )
			ArrayList bl_str_list = null;

			//Added by Sharon Crasta on 3/14/2009 for Facility/Enterprise Charts
			String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id  = checkForNull(request.getParameter( "other_chart_facility_id" )) ;		
			
			//Added by Sharon Crasta on 1/23/2010 for IN018302
			//commented and added by parul on 29/04/2010 for IN021055
			//String asOnDate = checkForNull(request.getParameter( "asOnDate" )) ;
			String asOnDate = com.ehis.util.DateUtils.convertDate(checkForNull(request.getParameter("asOnDate")),"DMY",locale,"en");  
			String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" )) ;
			String str_chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			//End
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			//
			StringBuffer date_type = new StringBuffer();
			StringBuffer chart_dtls = new StringBuffer();
			String[] tooth_range_arr = null;
			//Added by Sharon Crasta on 3/30/2010 for IN018302 - made baseline as separate block so that the asondate logic could be taken care off.
			if(baseline_chart_yn.equals("Y")){
				if(oh_chart_level.equals("E")){
					/* Commented by Sridevi Joshi on 28/11/2008 to remove PERMANENT_DECIDUOUS column reference from OH_QUADRANT_LANG_VW */
					//sql = "SELECT A.QUADRANT_SNO,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, REMARKS, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO AND G.PERMANENT_DECIDUOUS=?) QUADRANT_DESC, A.TRMT_CODE, A.SURFACE_CODE, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.TREATMENTS_OUTCOME, A.COMPLICATION_CODE, ORDER_ID, (SELECT K.ORDER_LINE_NUM FROM OR_ORDER_LINE K WHERE K.ORDER_ID = A.ORDER_ID) ORDER_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND  TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'I' AND C.CHART_STATUS = 'A' AND NVL(STATUS,'X') = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60') AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC";
					
					//Commented by Sharon Crasta on  3/14/2009 to remove OPERATING_FACILITY_ID for Enterprise
					//sql = "SELECT A.QUADRANT_SNO,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, REMARKS, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.TRMT_CODE, A.SURFACE_CODE, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.TREATMENTS_OUTCOME, A.COMPLICATION_CODE, ORDER_ID, (SELECT K.ORDER_LINE_NUM FROM OR_ORDER_LINE K WHERE K.ORDER_ID = A.ORDER_ID) ORDER_LINE_NUM, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND  TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'I' AND C.CHART_STATUS = 'A' AND NVL(STATUS,'X') = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60') AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC";
					sql = "SELECT A.FAILURE_REMARKS,A.CUSP_TIP_CODE, A.INTRAORAL_EXTRAORAL, A.ORGAN_CODE,A.SUB_ORGAN_CODE,A.QUADRANT_SNO,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, REMARKS, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.TRMT_CODE, A.SURFACE_CODE, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.TREATMENTS_OUTCOME, A.COMPLICATION_CODE, ORDER_ID, (SELECT K.ORDER_LINE_NUM FROM OR_ORDER_LINE K WHERE K.ORDER_ID = A.ORDER_ID) ORDER_LINE_NUM, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN , A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'I' AND A.CHART_NUM = ? AND NVL(STATUS,'X') = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60') AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale); // For OH_TRTMT_CATEGORY_TYPE_LANG_VW
					pstmt.setString(2,tooth_numbering_system); // For OH_TOOTH_BY_NUMBERING_SYSTEM
					pstmt.setString(3,locale); // For OH_ARCH_LANG_VW
					pstmt.setString(4,tooth_numbering_system); // For OH_ARCH_LANG_VW
					pstmt.setString(5,locale); // For OH_QUADRANT_LANG_VW
					pstmt.setString(6,tooth_numbering_system); // For OH_QUADRANT_LANG_VW
					//pstmt.setString(7,permanent_deciduous_flag); // For OH_QUADRANT_LANG_VW
					//pstmt.setString(7,facility_id);
					pstmt.setString(7,patient_id);
					pstmt.setString(8,str_chart_num);
					rst = pstmt.executeQuery();
				}else{
				/* Commented by Sridevi Joshi on 28/11/2008 to remove PERMANENT_DECIDUOUS column reference from OH_QUADRANT_LANG_VW */
					//sql = "SELECT A.QUADRANT_SNO,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, REMARKS, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO AND G.PERMANENT_DECIDUOUS=?) QUADRANT_DESC, A.TRMT_CODE, A.SURFACE_CODE, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.TREATMENTS_OUTCOME, A.COMPLICATION_CODE, ORDER_ID, (SELECT K.ORDER_LINE_NUM FROM OR_ORDER_LINE K WHERE K.ORDER_ID = A.ORDER_ID) ORDER_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND  TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'I' AND C.CHART_STATUS = 'A' AND NVL(STATUS,'X') = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60') AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC";
					sql = "SELECT A.FAILURE_REMARKS,A.CUSP_TIP_CODE,A.INTRAORAL_EXTRAORAL, A.ORGAN_CODE,A.SUB_ORGAN_CODE,A.QUADRANT_SNO,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, REMARKS, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.TRMT_CODE, A.SURFACE_CODE, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.TREATMENTS_OUTCOME, A.COMPLICATION_CODE, ORDER_ID, (SELECT K.ORDER_LINE_NUM FROM OR_ORDER_LINE K WHERE K.ORDER_ID = A.ORDER_ID) ORDER_LINE_NUM, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN , A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND  TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'I' AND A.CHART_NUM = ? AND NVL(STATUS,'X') = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60') AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale); // For OH_TRTMT_CATEGORY_TYPE_LANG_VW
					pstmt.setString(2,tooth_numbering_system); // For OH_TOOTH_BY_NUMBERING_SYSTEM
					pstmt.setString(3,locale); // For OH_ARCH_LANG_VW
					pstmt.setString(4,tooth_numbering_system); // For OH_ARCH_LANG_VW
					pstmt.setString(5,locale); // For OH_QUADRANT_LANG_VW
					pstmt.setString(6,tooth_numbering_system); // For OH_QUADRANT_LANG_VW
					//pstmt.setString(7,permanent_deciduous_flag); // For OH_QUADRANT_LANG_VW
					//pstmt.setString(7,facility_id);
					pstmt.setString(7,other_chart_facility_id);
					pstmt.setString(8,patient_id);
					pstmt.setString(9,str_chart_num);
					rst = pstmt.executeQuery();

				}
			}else{ //End
				if(oh_chart_level.equals("E")){
					/* Commented by Sridevi Joshi on 28/11/2008 to remove PERMANENT_DECIDUOUS column reference from OH_QUADRANT_LANG_VW */
					//sql = "SELECT A.QUADRANT_SNO,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, REMARKS, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO AND G.PERMANENT_DECIDUOUS=?) QUADRANT_DESC, A.TRMT_CODE, A.SURFACE_CODE, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.TREATMENTS_OUTCOME, A.COMPLICATION_CODE, ORDER_ID, (SELECT K.ORDER_LINE_NUM FROM OR_ORDER_LINE K WHERE K.ORDER_ID = A.ORDER_ID) ORDER_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND  TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'I' AND C.CHART_STATUS = 'A' AND NVL(STATUS,'X') = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60') AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC";
					
					//Commented by Sharon Crasta on  3/14/2009 to remove OPERATING_FACILITY_ID for Enterprise
					//sql = "SELECT A.QUADRANT_SNO,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, REMARKS, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.TRMT_CODE, A.SURFACE_CODE, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.TREATMENTS_OUTCOME, A.COMPLICATION_CODE, ORDER_ID, (SELECT K.ORDER_LINE_NUM FROM OR_ORDER_LINE K WHERE K.ORDER_ID = A.ORDER_ID) ORDER_LINE_NUM, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND  TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'I' AND C.CHART_STATUS = 'A' AND NVL(STATUS,'X') = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60') AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC";
					sql = "SELECT A.FAILURE_REMARKS,A.CUSP_TIP_CODE, A.INTRAORAL_EXTRAORAL, A.ORGAN_CODE,A.SUB_ORGAN_CODE,A.QUADRANT_SNO,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, REMARKS, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.TRMT_CODE, A.SURFACE_CODE, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.TREATMENTS_OUTCOME, A.COMPLICATION_CODE, ORDER_ID, (SELECT K.ORDER_LINE_NUM FROM OR_ORDER_LINE K WHERE K.ORDER_ID = A.ORDER_ID) ORDER_LINE_NUM, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN , A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'I' AND A.CHART_NUM = (SELECT MAX (CHART_NUM)     FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND TO_DATE (?, 'DD/MM/YYYY')             BETWEEN TRUNC (CHART_DATE) AND TRUNC (NVL (CHART_CLOSE_DATE, SYSDATE))) AND NVL(STATUS,'X') = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60') AND NVL(A.COND_CLOSED_YN,'N') = 'N' AND TRUNC (A.TREATMENT_CONDITION_DATE) <= TO_DATE (?, 'DD/MM/YYYY') ORDER BY CHART_LINE_NUM DESC";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale); // For OH_TRTMT_CATEGORY_TYPE_LANG_VW
					pstmt.setString(2,tooth_numbering_system); // For OH_TOOTH_BY_NUMBERING_SYSTEM
					pstmt.setString(3,locale); // For OH_ARCH_LANG_VW
					pstmt.setString(4,tooth_numbering_system); // For OH_ARCH_LANG_VW
					pstmt.setString(5,locale); // For OH_QUADRANT_LANG_VW
					pstmt.setString(6,tooth_numbering_system); // For OH_QUADRANT_LANG_VW
					//pstmt.setString(7,permanent_deciduous_flag); // For OH_QUADRANT_LANG_VW
					//pstmt.setString(7,facility_id);
					pstmt.setString(7,patient_id);
					//Added by Sharon Crasta on 1/23/2010 for IN018302
					pstmt.setString(8,patient_id);
					pstmt.setString(9,asOnDate);
					pstmt.setString(10,asOnDate);
					//End
					rst = pstmt.executeQuery();
				}else{
				/* Commented by Sridevi Joshi on 28/11/2008 to remove PERMANENT_DECIDUOUS column reference from OH_QUADRANT_LANG_VW */
					//sql = "SELECT A.QUADRANT_SNO,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, REMARKS, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO AND G.PERMANENT_DECIDUOUS=?) QUADRANT_DESC, A.TRMT_CODE, A.SURFACE_CODE, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.TREATMENTS_OUTCOME, A.COMPLICATION_CODE, ORDER_ID, (SELECT K.ORDER_LINE_NUM FROM OR_ORDER_LINE K WHERE K.ORDER_ID = A.ORDER_ID) ORDER_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND  TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'I' AND C.CHART_STATUS = 'A' AND NVL(STATUS,'X') = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60') AND NVL(A.COND_CLOSED_YN,'N') = 'N' ORDER BY CHART_LINE_NUM DESC";
					sql = "SELECT A.FAILURE_REMARKS,A.CUSP_TIP_CODE,A.INTRAORAL_EXTRAORAL, A.ORGAN_CODE,A.SUB_ORGAN_CODE,A.QUADRANT_SNO,TO_CHAR(A.TREATMENT_CONDITION_DATE,'DD/MM/YYYY') TREATMENT_CONDITION_DATE, REMARKS, A.TRMT_CATEGORY_TYPE, (SELECT TRMT_CATEGORY_TYPE_DESC FROM OH_TRTMT_CATEGORY_TYPE_LANG_VW B WHERE LANGUAGE_ID=? AND B.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) TRMT_CATEGORY_TYPE_DESC, A.CHART_NUM, A.CHART_LINE_NUM, C.CHART_STATUS,TO_CHAR(C.CHART_DATE,'DD/MM/YYYY') CHART_DATE , C.CLINICAL_GROUP_CODE, A.SITE_TYPE, A.TOOTH_RANGE, A.TOOTH_NO, (SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM D WHERE D.NUMBERING_SYSTEM=? AND D.TOOTH_NO=A.TOOTH_NO) NS_TOOTH_NO,A.ARCH_SNO, (SELECT ARCH_DESC FROM OH_ARCH_LANG_VW F WHERE F.LANGUAGE_ID = ? AND F.NUMBERING_SYSTEM=? AND F.ARCH_ID=A.ARCH_SNO) ARCH_DESC, A.QUADRANT_SNO, (SELECT QUADRANT_DESC FROM OH_QUADRANT_LANG_VW G WHERE G.LANGUAGE_ID = ? AND G.NUMBERING_SYSTEM=? AND G.QUADRANT_SNO=A.QUADRANT_SNO) QUADRANT_DESC, A.TRMT_CODE, A.SURFACE_CODE, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS, A.TREATMENTS_OUTCOME, A.COMPLICATION_CODE, ORDER_ID, (SELECT K.ORDER_LINE_NUM FROM OR_ORDER_LINE K WHERE K.ORDER_ID = A.ORDER_ID) ORDER_LINE_NUM, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN , A.SUPER_TOOTH_NO,A.RETAINED_TOOTH_NO,A.SUPER_KEY_NUM FROM OH_RESTORATIVE_CHART_DTL A, OH_RESTORATIVE_CHART_HDR C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM=C.CHART_NUM AND A.PATIENT_ID=C.PATIENT_ID AND A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND  TREATMENT_CONDITION='T' AND TREATMENT_INT_EXT = 'I' AND A.CHART_NUM = (SELECT MAX (CHART_NUM)     FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND TO_DATE (?, 'DD/MM/YYYY')             BETWEEN TRUNC (CHART_DATE) AND TRUNC (NVL (CHART_CLOSE_DATE, SYSDATE))) AND NVL(STATUS,'X') = (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '60') AND NVL(A.COND_CLOSED_YN,'N') = 'N' AND TRUNC (A.TREATMENT_CONDITION_DATE) <= TO_DATE (?, 'DD/MM/YYYY') ORDER BY CHART_LINE_NUM DESC";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale); // For OH_TRTMT_CATEGORY_TYPE_LANG_VW
					pstmt.setString(2,tooth_numbering_system); // For OH_TOOTH_BY_NUMBERING_SYSTEM
					pstmt.setString(3,locale); // For OH_ARCH_LANG_VW
					pstmt.setString(4,tooth_numbering_system); // For OH_ARCH_LANG_VW
					pstmt.setString(5,locale); // For OH_QUADRANT_LANG_VW
					pstmt.setString(6,tooth_numbering_system); // For OH_QUADRANT_LANG_VW
					//pstmt.setString(7,permanent_deciduous_flag); // For OH_QUADRANT_LANG_VW
					//pstmt.setString(7,facility_id);
					pstmt.setString(7,other_chart_facility_id);
					pstmt.setString(8,patient_id);
					//Added by Sharon Crasta on 1/23/2010 for IN018302
					pstmt.setString(9,patient_id);
					pstmt.setString(10,asOnDate);
					pstmt.setString(11,asOnDate);
					//End
					rst = pstmt.executeQuery();

				}

			}
			while(rst!= null && rst.next()){
				chart_dtls.setLength(0);
				// The below order should not be changed, as it is being used in the js file.
				type_desc = rst.getString("TRMT_CATEGORY_TYPE_DESC");		//  1
				date = rst.getString("TREATMENT_CONDITION_DATE");		//  2
				arch_desc = rst.getString("ARCH_DESC");		//  3
				quad_desc = rst.getString("QUADRANT_DESC");		//  4
				status = rst.getString("STATUS");		//  4
				trmt_code = rst.getString("TRMT_CODE");		//  4
				remarks = rst.getString("REMARKS");		//  4
				site_type = checkForNull(rst.getString("SITE_TYPE"));		//  4
				chart_line_num = rst.getString("CHART_LINE_NUM");		//  4
				complication_code = checkForNull(rst.getString("COMPLICATION_CODE"));		//  4
				order_id = rst.getString("ORDER_ID");		//  4
				order_line_num = rst.getString("ORDER_LINE_NUM");		//  4
				String chart_num = rst.getString("CHART_NUM");
				String chart_line_num1 = rst.getString("CHART_LINE_NUM");
				//type = rst.getString("CONDITION_TREATMENT_TYPE");
				supernumerary_yn = rst.getString("SUPERNUMERARY_YN");		//  4
				deciduous_yn = rst.getString("MIXED_DENT_DECIDUOUS_YN");		//  4
				//String thrng_nos_1 = checkForNull(rst.getString("TOOTH_RANGE"));
				sub_organ_code_1 = rst.getString("SUB_ORGAN_CODE");
				super_tooth_no = rst.getString("SUPER_TOOTH_NO");
				retained_tooth_no = rst.getString("RETAINED_TOOTH_NO");
				cusp_tip_code = rst.getString("CUSP_TIP_CODE");
				super_key_num = checkForNull(rst.getString("SUPER_KEY_NUM"));
				failure_remarks = checkForNull(rst.getString("FAILURE_REMARKS"));

				//if(site_type.equals("THRNG")){
				if(site_type.equals("THRNG") || ((site_type.equals("MAXFS") && (sub_organ_code_1!=("") && sub_organ_code_1!=(null) && sub_organ_code_1!=("null"))) && (sub_organ_code_1.equals("TNGAB") || sub_organ_code_1.equals("TNGGM") || sub_organ_code_1.equals("TNGAG") || sub_organ_code_1.equals("TNGGAM") || sub_organ_code_1.equals("TNGMF")))){//TNGAB,TNGGM,TNGAG,TNGGAM,TNGMF
					// The below order should not be changed, as it is being used in the js file.
					chart_dtls.append(rst.getString("CHART_NUM")+":");		//  5
					chart_dtls.append(rst.getString("CHART_LINE_NUM")+":"); //  6
					chart_dtls.append(rst.getString("CHART_STATUS")+":");	//  7
					chart_dtls.append(rst.getString("CHART_DATE")+":");		//  8
					chart_dtls.append(rst.getString("SITE_TYPE")+":");		//  9
					chart_dtls.append(rst.getString("TOOTH_NO")+":");		//  10
					chart_dtls.append(rst.getString("NS_TOOTH_NO")+":");	//  11
					chart_dtls.append(rst.getString("ARCH_SNO")+":");		// 12
					chart_dtls.append(rst.getString("QUADRANT_SNO")+":");	// 13
					chart_dtls.append(rst.getString("SURFACE_CODE")+":");	// 14
					chart_dtls.append(rst.getString("TRMT_CATEGORY_TYPE")+":");	// 15
					chart_dtls.append(rst.getString("TRMT_CODE")+":");		// 16
					chart_dtls.append(rst.getString("TOOTH_RANGE")+":");		// 17 added by Sridevi Joshi

					String thrang_ref = "";
					String thrng_nos = checkForNull(rst.getString("TOOTH_RANGE"));
					if(!thrng_nos.equals(null) && !thrng_nos.equals("") && thrng_nos.indexOf(",") != -1){ // To get the Display tooth no in the form of t1,t2 in case of TOOTH RANGE
						tooth_range_arr = thrng_nos.split(",");
						//String[] temp_arr = null;
						
						//2$$5,3$$6
						String str="";
						int ind = 0;
						int z=0;
						int m=0;

						ind = thrng_nos.indexOf("$$");
						str_chart_line_num = thrng_nos.substring(0,ind);

						for(int i=0;i<tooth_range_arr.length;i++){
							str = tooth_range_arr[i];
							ind = str.indexOf("$$");
							str = str.substring(ind+2,str.length());
							pstmt1 = con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM=? AND TOOTH_NO=?");
							pstmt1.setString(1,tooth_numbering_system);
							pstmt1.setString(2,str);
							rst1 = pstmt1.executeQuery();
							
							while(rst1!= null && rst1.next()){
								if(z==0){
									thrang_ref = rst1.getString("NS_TOOTH_NO");
								}
								else{
									thrang_ref = thrang_ref+","+rst1.getString("NS_TOOTH_NO");
								}
								z++;
							}

							pstmt2 = con.prepareStatement("SELECT A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?)");
							pstmt2.setString(1,tooth_numbering_system);
							pstmt2.setString(2,str);
							rst2 = pstmt2.executeQuery();
							while(rst2!= null && rst2.next()){
								if(m==0){
									display_tooth_no = rst2.getString("NS_TOOTH_NO");
								}
								else{
									display_tooth_no = display_tooth_no+","+rst2.getString("NS_TOOTH_NO");;
								}
								m++;
								
							}
							if(rst2!=null)rst2.close();
							if(pstmt2!=null)pstmt2.close();
							if(rst1!=null)rst1.close();
							if(pstmt1!=null)pstmt1.close();
							
						}
					}
					chart_dtls.append(thrang_ref+":"); // 18 added by Sridevi Joshi

					//chart_dtls.append(rst.getString("CLINICAL_GROUP_CODE")+":");		// 19 added by Sridevi Joshi
					//chart_dtls.append(rst.getString("SURFACE_CODE")+":");		// 20 added by Sridevi Joshi
					//chart_dtls.append(rst.getString("LOCATION")+":");		// 21 added by Sridevi Joshi
					chart_dtls.append(rst.getString("STATUS")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("TREATMENTS_OUTCOME")+":");		// 22 added by Sridevi Joshi
					//chart_dtls.append(rst.getString("TREATMENTS_OUTCOME"));		// 23 added by Sridevi Joshi
					chart_dtls.append(rst.getString("INTRAORAL_EXTRAORAL")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("ORGAN_CODE")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("SUB_ORGAN_CODE"));		// 23 added by Sridevi Joshi
					

					if(site_type.equals("ARCH")){
						arch_quad = arch_desc;
					}
					else if(site_type.equals("QUAD")){
						arch_quad = quad_desc;
					}
					else if(site_type.equals("MAXFS")){
						//arch_quad = "NA";
						arch_quad = intraoral_extraoral;
					}

					/*
					BEFORE INCLUDING THE ORDER_ID
					date_type.append(date+"##"+type_desc+"##"+rst.getString("NS_TOOTH_NO")+"##"+chart_dtls+"##"+arch_quad); 
					*/

					bl_str_list = oh_bean.getBillDetails(trmt_code,episode_type,"OR","","",patient_id,episode_id,visit_id, encounter_id,"1",pract_staff_id,facility_id,locale,"TRMT");

					total_payable = (String)bl_str_list.get(2);

				
					if(!str_chart_line_num.equals(chart_line_num)){
						continue;
					}
					else{	
						/*date_type.append(date+"##"+type_desc+"##"+rst.getString("NS_TOOTH_NO")+"##"+chart_dtls+"##"+arch_quad+"##"+status+"##"+rst.getString("ORDER_ID")+"##"+trmt_code+"##"+remarks+"##"+site_type+"##"+thrang_ref+"##"+complication_code+"##"+total_payable); 
					date_type.append("~");
					*/

					 
					date_type.append(date+"OH_SEP_1"+type_desc+"OH_SEP_1"+rst.getString("NS_TOOTH_NO")+"OH_SEP_1"+chart_dtls+"OH_SEP_1"+arch_quad+"OH_SEP_1"+status+"OH_SEP_1"+rst.getString("ORDER_ID")+"OH_SEP_1"+trmt_code+"OH_SEP_1"+remarks+"OH_SEP_1"+site_type+"OH_SEP_1"+thrang_ref+"OH_SEP_1"+complication_code+"OH_SEP_1"+total_payable+"OH_SEP_1"+chart_num+"OH_SEP_1"+chart_line_num1+"OH_SEP_1"+deciduous_yn+"OH_SEP_1"+supernumerary_yn+"OH_SEP_1"+display_tooth_no+"OH_SEP_1"+sub_organ_code_1+"OH_SEP_1"+failure_remarks); 
					date_type.append("OH_SEP_2");
					}
				}
				else{
					// The below order should not be changed, as it is being used in the js file.
					chart_dtls.append(rst.getString("CHART_NUM")+":");		//  5
					chart_dtls.append(rst.getString("CHART_LINE_NUM")+":"); //  6
					chart_dtls.append(rst.getString("CHART_STATUS")+":");	//  7
					chart_dtls.append(rst.getString("CHART_DATE")+":");		//  8
					chart_dtls.append(rst.getString("SITE_TYPE")+":");		//  9
					chart_dtls.append(rst.getString("TOOTH_NO")+":");		//  10
					chart_dtls.append(rst.getString("NS_TOOTH_NO")+":");	//  11
					chart_dtls.append(rst.getString("ARCH_SNO")+":");		// 12
					chart_dtls.append(rst.getString("QUADRANT_SNO")+":");	// 13
					chart_dtls.append(rst.getString("SURFACE_CODE")+":");	// 14
					chart_dtls.append(rst.getString("TRMT_CATEGORY_TYPE")+":");	// 15
					chart_dtls.append(rst.getString("TRMT_CODE")+":");		// 16
					chart_dtls.append(rst.getString("TOOTH_RANGE")+":");		// 17 added by Sridevi Joshi

					String thrang_ref = "";
					String thrng_nos = checkForNull(rst.getString("TOOTH_RANGE"));
					if(!thrng_nos.equals(null) && !thrng_nos.equals("") && thrng_nos.indexOf(",") != -1){ // To get the Display tooth no in the form of t1,t2 in case of TOOTH RANGE
						tooth_range_arr = thrng_nos.split(",");
						//String[] temp_arr = null;
						
						//2$$5,3$$6
						String str="";
						int ind = 0;
						int z=0;
						for(int i=0;i<tooth_range_arr.length;i++){
							str = tooth_range_arr[i];
							ind = str.indexOf("$$");
							str = str.substring(ind+2,str.length());
							pstmt1 = con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM=? AND TOOTH_NO=?");
							pstmt1.setString(1,tooth_numbering_system);
							pstmt1.setString(2,str);
							rst1 = pstmt1.executeQuery();
							
							while(rst1!= null && rst1.next()){
								if(z==0){
									thrang_ref = rst1.getString("NS_TOOTH_NO");
								}
								else{
									thrang_ref = thrang_ref+","+rst1.getString("NS_TOOTH_NO");
								}
								z++;
							}
						}
					}
					chart_dtls.append(thrang_ref+":"); // 18 added by Sridevi Joshi

					//chart_dtls.append(rst.getString("CLINICAL_GROUP_CODE")+":");		// 19 added by Sridevi Joshi
					//chart_dtls.append(rst.getString("SURFACE_CODE")+":");		// 20 added by Sridevi Joshi
					//chart_dtls.append(rst.getString("LOCATION")+":");		// 21 added by Sridevi Joshi
					chart_dtls.append(rst.getString("STATUS")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("TREATMENTS_OUTCOME")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("INTRAORAL_EXTRAORAL")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("ORGAN_CODE")+":");		// 22 added by Sridevi Joshi
					chart_dtls.append(rst.getString("SUB_ORGAN_CODE"));		// 23 added by Sridevi Joshi
					
					if(site_type.equals("ARCH")){
						arch_quad = arch_desc;
					}
					else if(site_type.equals("QUAD")){
						arch_quad = quad_desc;
					}
					else if(site_type.equals("MAXFS")){
						arch_quad = intraoral_extraoral;
					}

					pstmt1 = con.prepareStatement("SELECT A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?)");
					pstmt1.setString(1,tooth_numbering_system);
					pstmt1.setString(2,rst.getString("TOOTH_NO"));
					//pstmt1.setString(3,PD_flag);
					rst1 = pstmt1.executeQuery();
					while(rst1!= null && rst1.next()){
						display_tooth_no = rst1.getString("NS_TOOTH_NO");
					}

					bl_str_list = oh_bean.getBillDetails(trmt_code,episode_type,"OR","","",patient_id,episode_id,visit_id, encounter_id,"1",pract_staff_id,facility_id,locale,"TRMT");

					total_payable = (String)bl_str_list.get(2);

				
					/*
					BEFORE INCLUDING THE ORDER_ID
					date_type.append(date+"##"+type_desc+"##"+rst.getString("NS_TOOTH_NO")+"##"+chart_dtls+"##"+arch_quad); 
					*/
					/*date_type.append(date+"##"+type_desc+"##"+rst.getString("NS_TOOTH_NO")+"##"+chart_dtls+"##"+arch_quad+"##"+status+"##"+rst.getString("ORDER_ID")+"##"+trmt_code+"##"+remarks+"##"+site_type+"##"+thrang_ref+"##"+complication_code+"##"+total_payable); 
					date_type.append("~");
					*/

					date_type.append(date+"OH_SEP_1"+type_desc+"OH_SEP_1"+rst.getString("NS_TOOTH_NO")+"OH_SEP_1"+chart_dtls+"OH_SEP_1"+arch_quad+"OH_SEP_1"+status+"OH_SEP_1"+rst.getString("ORDER_ID")+"OH_SEP_1"+trmt_code+"OH_SEP_1"+remarks+"OH_SEP_1"+site_type+"OH_SEP_1"+thrang_ref+"OH_SEP_1"+complication_code+"OH_SEP_1"+total_payable+"OH_SEP_1"+chart_num+"OH_SEP_1"+chart_line_num1+"OH_SEP_1"+deciduous_yn+"OH_SEP_1"+supernumerary_yn+"OH_SEP_1"+display_tooth_no+"OH_SEP_1"+sub_organ_code_1+"OH_SEP_1"+super_tooth_no+"OH_SEP_1"+retained_tooth_no+"OH_SEP_1"+cusp_tip_code+"OH_SEP_1"+super_key_num+"OH_SEP_1"+failure_remarks); 
					date_type.append("OH_SEP_2");

				}
				if(rst1!=null)rst1.close();
				if(rst2!=null)rst2.close();
				if(pstmt1!=null)pstmt1.close();
			}
			out.println(date_type);
		}
		else if(func_mode.equalsIgnoreCase("populateTreatmentTasks")){	
			
			String trmt_code	= checkForNull(request.getParameter( "trmt_code" )) ;
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num	= checkForNull(request.getParameter( "chart_line_num" )) ;
			//String episode_type	= checkForNull(request.getParameter( "episode_type" )) ;
			String episode_id	= checkForNull(request.getParameter( "episode_id" )) ;
			String visit_id	= checkForNull(request.getParameter( "visit_id" )) ;
			String encounter_id	= checkForNull(request.getParameter( "encounter_id" )) ;
			//String pract_staff_id	= checkForNull(request.getParameter( "practitioner_id" )) ;
			//String call_billing_yn	= checkForNull(request.getParameter( "call_billing_yn" )) ;
			//String serv_panel_ind = "";
			//String serv_panel_code = "";
			String bl_key = "";
			//String patient_payable = "";
			//String patient_paid_amt = "";
			//String total_payable = "";
			String bl_data_exists_yn = "N";

			//String sql				= "";		
			String treatment_tasks_code = "";
			String treatment_tasks_desc = "";
			String order_id = "";
			String order_line_num = "";
			String status = "";
			//String multiple_task_yn = "";
			String appt_ref_no = "";
			String appt_reqd_yn = "";
			String seq_no = "";
			String billed_yn = "";
			String start_date_time = "";
			String end_date_time = "";
			String cusp_tip_code = "";
			//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
			String task_seq_no = "";
			//
			//Added by Sharon Crasta on 9/11/2009 for IN011250
			String appt_date_time = "";
			String patient_class = "";

			//Added by Sharon Crasta on 12/22/2009 for SUPRTH and RTDESTH changes.
			String retained_tooth_no = "";
			String super_tooth_no = "";
			//End


			StringBuffer tasks_buff= new StringBuffer();
			//ArrayList bl_str_list = null;
			//HashMap bl_str_map = null;
			//HashMap bill_map = null;
			//Added by Sharon Crasta on 3/14/2009 for Facility/Enterprise Charts
			//String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			String other_chart_facility_id  = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			//
			ArrayList episode_visit_list = oh_bean.getEpisodeAndVisitId(encounter_id);
			episode_id = (String) episode_visit_list.get(0);
			visit_id = (String) episode_visit_list.get(1);

			//pstmt = con.prepareStatement("SELECT A.TASK_CODE, B.TASK_DESC, C.MULTIPLE_TASK_YN FROM OH_TREATMENT_TASKS A, OH_TASKS_LANG_VW B, OH_TREATMENT C WHERE A.TASK_CODE = B.TASK_CODE AND A.TRMT_CODE = C.TRMT_CODE AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID=? AND A.TRMT_CODE = ? ORDER BY 2");

			/* Commented to Add BL_TASK_CHARGE and BL_TOTAL_CHARGE in to the query*/
			//pstmt = con.prepareStatement("SELECT A.TASK_CODE, B.TASK_DESC, A.ORDER_ID, A.ORDER_LINE_NUM, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_TYPE, (SELECT APPT_REF_NO FROM OA_APPT WHERE FACILITY_ID =A.OPERATING_FACILITY_ID AND ORDER_ID = A.ORDER_ID AND ORDER_LINE_NUM = A.ORDER_LINE_NUM) APPT_REF_NO, NVL(A.APPT_REQD_YN,'N') APPT_REQD_YN FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG_VW B WHERE A.OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM =? AND A.TRMT_CODE = ? AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID=? AND NVL(A.STATUS,'X') != 'E' ORDER BY 2");
			//pstmt = con.prepareStatement("SELECT A.TASK_CODE, B.TASK_DESC, A.ORDER_ID, A.ORDER_LINE_NUM, A.BL_TASK_CHARGE, C.BL_TOTAL_CHARGE, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_TYPE, (SELECT APPT_REF_NO FROM OA_APPT WHERE FACILITY_ID =A.OPERATING_FACILITY_ID AND ORDER_ID = A.ORDER_ID AND ORDER_LINE_NUM = A.ORDER_LINE_NUM) APPT_REF_NO, NVL(A.APPT_REQD_YN,'N') APPT_REQD_YN FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG_VW B, OH_RESTORATIVE_CHART_DTL C WHERE A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND A.PATIENT_ID=C.PATIENT_ID AND A.CHART_NUM=C.CHART_NUM AND A.CHART_LINE_NUM =C.CHART_LINE_NUM AND A.TRMT_CODE = C.TRMT_CODE AND A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM =? AND A.TRMT_CODE = ? AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID=? AND NVL(A.STATUS,'X') != 'E' ORDER BY 2");

			/* Commenter to remove BL_TOTAL_CHARGE from the query*/
			//pstmt = con.prepareStatement("SELECT A.TASK_CODE, B.TASK_DESC, A.SEQ_NO, A.ORDER_ID, A.ORDER_LINE_NUM, A.BL_TASK_CHARGE, C.BL_TOTAL_CHARGE, (SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_TYPE, (SELECT APPT_REF_NO FROM OA_APPT WHERE FACILITY_ID =A.OPERATING_FACILITY_ID AND ORDER_ID = A.ORDER_ID AND ORDER_LINE_NUM = A.ORDER_LINE_NUM) APPT_REF_NO, NVL(A.APPT_REQD_YN,'N') APPT_REQD_YN FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG_VW B, OH_RESTORATIVE_CHART_DTL C WHERE A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND A.PATIENT_ID=C.PATIENT_ID AND A.CHART_NUM=C.CHART_NUM AND A.CHART_LINE_NUM =C.CHART_LINE_NUM AND A.TRMT_CODE = C.TRMT_CODE AND A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM =? AND A.TRMT_CODE = ? AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID=? AND NVL(A.STATUS,'X') != 'E' ORDER BY A.SEQ_NO");

			//pstmt = con.prepareStatement("SELECT A.BILL_SUB_REGN_NUM, A.TASK_CODE, B.TASK_DESC, A.SEQ_NO, A.BILLED_YN, A.ORDER_ID, A.ORDER_LINE_NUM,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_TYPE, (SELECT APPT_REF_NO FROM OA_APPT WHERE FACILITY_ID =A.OPERATING_FACILITY_ID AND ORDER_ID = A.ORDER_ID AND ORDER_LINE_NUM = A.ORDER_LINE_NUM) APPT_REF_NO, NVL(A.APPT_REQD_YN,'N') APPT_REQD_YN FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG_VW B, OH_RESTORATIVE_CHART_DTL C WHERE A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND A.PATIENT_ID=C.PATIENT_ID AND A.CHART_NUM=C.CHART_NUM AND A.CHART_LINE_NUM =C.CHART_LINE_NUM AND A.TRMT_CODE = C.TRMT_CODE AND A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM =? AND A.TRMT_CODE = ? AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID=? AND NVL(A.STATUS,'X') != 'E' AND NVL(C.COND_CLOSED_YN,'N') = 'N' ORDER BY A.SEQ_NO");

			//Adding start_date_time and end_date_time
			//pstmt = con.prepareStatement("SELECT TO_CHAR(A.START_DATE_TIME,'DD/MM/YYYY HH24:MI') START_DATE, TO_CHAR(A.END_DATE_TIME,'DD/MM/YYYY HH24:MI') END_DATE, A.BILL_SUB_REGN_NUM, A.TASK_CODE, B.TASK_DESC, A.SEQ_NO, A.BILLED_YN, A.ORDER_ID, A.ORDER_LINE_NUM,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_TYPE, (SELECT APPT_REF_NO FROM OA_APPT WHERE FACILITY_ID =A.OPERATING_FACILITY_ID AND ORDER_ID = A.ORDER_ID AND ORDER_LINE_NUM = A.ORDER_LINE_NUM) APPT_REF_NO, NVL(A.APPT_REQD_YN,'N') APPT_REQD_YN FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG_VW B, OH_RESTORATIVE_CHART_DTL C WHERE A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND A.PATIENT_ID=C.PATIENT_ID AND A.CHART_NUM=C.CHART_NUM AND A.CHART_LINE_NUM =C.CHART_LINE_NUM AND A.TRMT_CODE = C.TRMT_CODE AND A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM =? AND A.TRMT_CODE = ? AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID=? AND NVL(A.STATUS,'X') != 'E' AND NVL(C.COND_CLOSED_YN,'N') = 'N' ORDER BY A.SEQ_NO");
			
			
			//Appt_ref_no is taken from OH_RESTORATIVE_CHART_TASKS table( SCHEDULE_REF_NO) instead of OA_APPT
			//commented by Sharon Crasta on 3/14/2009 to remove OPERATING_FACILITY_ID for CRF #0423
			//pstmt = con.prepareStatement("SELECT TO_CHAR(A.START_DATE_TIME,'DD/MM/YYYY HH24:MI') START_DATE, A.SCHEDULE_REF_NO, TO_CHAR(A.END_DATE_TIME,'DD/MM/YYYY HH24:MI') END_DATE, A.BILL_SUB_REGN_NUM, A.TASK_CODE, B.TASK_DESC, A.SEQ_NO, A.BILLED_YN, A.ORDER_ID, A.ORDER_LINE_NUM,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_TYPE, NVL(A.APPT_REQD_YN,'N') APPT_REQD_YN FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG_VW B, OH_RESTORATIVE_CHART_DTL C WHERE A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND A.PATIENT_ID=C.PATIENT_ID AND A.CHART_NUM=C.CHART_NUM AND A.CHART_LINE_NUM =C.CHART_LINE_NUM AND A.TRMT_CODE = C.TRMT_CODE AND A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM =? AND A.TRMT_CODE = ? AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID=? AND NVL(A.STATUS,'X') != 'E' AND NVL(C.COND_CLOSED_YN,'N') = 'N' ORDER BY A.SEQ_NO");
			//pstmt = con.prepareStatement("SELECT TO_CHAR(A.START_DATE_TIME,'DD/MM/YYYY HH24:MI') START_DATE, A.SCHEDULE_REF_NO, TO_CHAR(A.END_DATE_TIME,'DD/MM/YYYY HH24:MI') END_DATE, A.BILL_SUB_REGN_NUM, A.TASK_CODE, B.TASK_DESC, A.SEQ_NO, A.BILLED_YN, A.ORDER_ID, A.ORDER_LINE_NUM,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_TYPE, NVL(A.APPT_REQD_YN,'N') APPT_REQD_YN FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG_VW B, OH_RESTORATIVE_CHART_DTL C WHERE A.PATIENT_ID=C.PATIENT_ID AND A.CHART_NUM=C.CHART_NUM AND A.CHART_LINE_NUM =C.CHART_LINE_NUM AND A.TRMT_CODE = C.TRMT_CODE AND A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM =? AND A.TRMT_CODE = ? AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID=? AND NVL(A.STATUS,'X') != 'E' AND NVL(C.COND_CLOSED_YN,'N') = 'N' ORDER BY A.SEQ_NO");
			//Commented by Sharon Crasta on 8/25/2009 for  IN010893(SRR20056-CRF-0480)
			//pstmt = con.prepareStatement("SELECT TO_CHAR(A.START_DATE_TIME,'DD/MM/YYYY HH24:MI') START_DATE,C.CUSP_TIP_CODE, A.SCHEDULE_REF_NO, TO_CHAR(A.END_DATE_TIME,'DD/MM/YYYY HH24:MI') END_DATE, A.BILL_SUB_REGN_NUM, A.TASK_CODE, B.TASK_DESC, A.SEQ_NO, A.BILLED_YN, A.ORDER_ID, A.ORDER_LINE_NUM,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_TYPE, NVL(A.APPT_REQD_YN,'N') APPT_REQD_YN FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG_VW B, OH_RESTORATIVE_CHART_DTL C WHERE A.PATIENT_ID=C.PATIENT_ID AND A.CHART_NUM=C.CHART_NUM AND A.CHART_LINE_NUM =C.CHART_LINE_NUM AND A.TRMT_CODE = C.TRMT_CODE AND A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM =? AND A.TRMT_CODE = ? AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID=? AND NVL(A.STATUS,'X') != 'E' AND NVL(C.COND_CLOSED_YN,'N') = 'N' ORDER BY A.SEQ_NO");
			//Commented and Added by Sharon Crasta on 9/11/2009 for IN011250
			//pstmt = con.prepareStatement("SELECT TO_CHAR(A.START_DATE_TIME,'DD/MM/YYYY HH24:MI') START_DATE,C.CUSP_TIP_CODE, A.SCHEDULE_REF_NO, TO_CHAR(A.END_DATE_TIME,'DD/MM/YYYY HH24:MI') END_DATE, A.BILL_SUB_REGN_NUM, A.TASK_CODE, B.TASK_DESC, A.SEQ_NO, A.TASK_SEQ, A.BILLED_YN, A.ORDER_ID, A.ORDER_LINE_NUM,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_TYPE, NVL(A.APPT_REQD_YN,'N') APPT_REQD_YN FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG_VW B, OH_RESTORATIVE_CHART_DTL C WHERE A.PATIENT_ID=C.PATIENT_ID AND A.CHART_NUM=C.CHART_NUM AND A.CHART_LINE_NUM =C.CHART_LINE_NUM AND A.TRMT_CODE = C.TRMT_CODE AND A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM =? AND A.TRMT_CODE = ? AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID=? AND NVL(A.STATUS,'X') != 'E' AND NVL(C.COND_CLOSED_YN,'N') = 'N' ORDER BY A.TASK_SEQ");
		
			/*if(called_from1.equals("OT")&& trmtYn.equals("menu1")){
			//	pstmt = con.prepareStatement("SELECT TO_CHAR(A.START_DATE_TIME,'DD/MM/YYYY HH24:MI') START_DATE,C.CUSP_TIP_CODE, A.SCHEDULE_REF_NO, TO_CHAR(A.SCHEDULE_DATE_TIME,'DD/MM/YYYY HH24:MI') SCHEDULE_DATE_TIME, TO_CHAR(A.END_DATE_TIME,'DD/MM/YYYY HH24:MI') END_DATE, A.BILL_SUB_REGN_NUM, A.TASK_CODE, B.TASK_DESC, A.SEQ_NO, A.TASK_SEQ, A.BILLED_YN, A.ORDER_ID, A.ORDER_LINE_NUM,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_TYPE, NVL(A.APPT_REQD_YN,'N') APPT_REQD_YN FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG_VW B, OH_RESTORATIVE_CHART_DTL C WHERE A.PATIENT_ID=C.PATIENT_ID AND A.CHART_NUM=C.CHART_NUM AND A.CHART_LINE_NUM =C.CHART_LINE_NUM AND A.TRMT_CODE = C.TRMT_CODE AND A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM =? AND A.TRMT_CODE = ? AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID=? AND  NVL(A.STATUS,'X') != 'E' AND A.STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE NOT IN ('10','15','60')) AND NVL(C.COND_CLOSED_YN,'N') = 'N' ORDER BY A.TASK_SEQ");
				pstmt = con.prepareStatement("SELECT TO_CHAR(A.START_DATE_TIME,'DD/MM/YYYY HH24:MI') START_DATE,C.CUSP_TIP_CODE, A.SCHEDULE_REF_NO, TO_CHAR(A.SCHEDULE_DATE_TIME,'DD/MM/YYYY HH24:MI') SCHEDULE_DATE_TIME, TO_CHAR(A.END_DATE_TIME,'DD/MM/YYYY HH24:MI') END_DATE, A.BILL_SUB_REGN_NUM, A.TASK_CODE, B.TASK_DESC, A.SEQ_NO, A.TASK_SEQ, A.BILLED_YN, A.ORDER_ID, A.ORDER_LINE_NUM,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_TYPE, NVL(A.APPT_REQD_YN,'N') APPT_REQD_YN FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG_VW B, OH_RESTORATIVE_CHART_DTL C WHERE A.PATIENT_ID=C.PATIENT_ID AND A.CHART_NUM=C.CHART_NUM AND A.CHART_LINE_NUM =C.CHART_LINE_NUM AND A.TRMT_CODE = C.TRMT_CODE AND A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM =? AND A.TRMT_CODE = ? AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID=? AND  NVL(A.STATUS,'X') != 'E' AND A.STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE NOT IN ('10','15')) AND NVL(C.COND_CLOSED_YN,'N') = 'N' ORDER BY A.TASK_SEQ");
			}else{*/
				pstmt = con.prepareStatement("SELECT A.PATIENT_CLASS, TO_CHAR(A.START_DATE_TIME,'DD/MM/YYYY HH24:MI') START_DATE,C.CUSP_TIP_CODE, A.SCHEDULE_REF_NO, TO_CHAR(A.SCHEDULE_DATE_TIME,'DD/MM/YYYY HH24:MI') SCHEDULE_DATE_TIME, TO_CHAR(A.END_DATE_TIME,'DD/MM/YYYY HH24:MI') END_DATE, A.BILL_SUB_REGN_NUM, A.TASK_CODE, B.TASK_DESC, A.SEQ_NO, A.TASK_SEQ, A.BILLED_YN, A.ORDER_ID, A.ORDER_LINE_NUM,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_TYPE, NVL(A.APPT_REQD_YN,'N') APPT_REQD_YN,C.SUPER_TOOTH_NO,C.RETAINED_TOOTH_NO FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG_VW B, OH_RESTORATIVE_CHART_DTL C WHERE A.PATIENT_ID=C.PATIENT_ID AND A.CHART_NUM=C.CHART_NUM AND A.CHART_LINE_NUM =C.CHART_LINE_NUM AND A.TRMT_CODE = C.TRMT_CODE AND A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM =? AND A.TRMT_CODE = ? AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID=? AND NVL(A.STATUS,'X') != 'E' AND NVL(C.COND_CLOSED_YN,'N') = 'N' ORDER BY A.TASK_SEQ"); //Added C.SUPER_TOOTH_NO,C.RETAINED_TOOTH_NO by Sharon Crasta on 12/22/2009 for SUPRTH and RTDESTH changes.
			//}
			//
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			pstmt.setString(4,trmt_code);
			pstmt.setString(5,locale);
			rst = pstmt.executeQuery();
		
			while(rst!= null && rst.next()){
				bl_key = checkForNull(rst.getString("BILL_SUB_REGN_NUM"));
				treatment_tasks_code = rst.getString("TASK_CODE");
				treatment_tasks_desc = rst.getString("TASK_DESC");
				seq_no = rst.getString("SEQ_NO");
				order_id = rst.getString("ORDER_ID");
				status = rst.getString("STATUS_TYPE");
				//appt_ref_no = rst.getString("APPT_REF_NO");
				appt_ref_no = rst.getString("SCHEDULE_REF_NO");
				appt_reqd_yn = rst.getString("APPT_REQD_YN");
				order_line_num = rst.getString("ORDER_LINE_NUM");
				billed_yn = rst.getString("BILLED_YN");
				start_date_time = checkForNull(rst.getString("START_DATE"));
				end_date_time = checkForNull(rst.getString("END_DATE"));
				cusp_tip_code = checkForNull(rst.getString("CUSP_TIP_CODE"));//Added by Parul on 28/08/2009 for IN010893(SRR20056-CRF-0483)
				//Added by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)
				task_seq_no = checkForNull(rst.getString("TASK_SEQ"));
				//
				//Commented and Added by Sharon Crasta on 9/11/2009 for IN011250
				appt_date_time = checkForNull(rst.getString("SCHEDULE_DATE_TIME"));
				patient_class = checkForNull(rst.getString("PATIENT_CLASS"));
				//
				//start_date_time = checkForNull(rst.getString("START_DATE_TIME"));

				//Added by Sharon Crasta on 12/22/2009 for SUPRTH and RTDESTH changes.
				super_tooth_no = checkForNull(rst.getString("SUPER_TOOTH_NO"));
				retained_tooth_no = checkForNull(rst.getString("RETAINED_TOOTH_NO"));
				//End

				if(bl_key.equals("")){
					bl_data_exists_yn = "N";
					//bl_key = order_id+"~"+chart_num;
				//	bl_key = order_id;
				}
				else{
					bl_data_exists_yn = "Y";
				}
				
				
				
				
				//commented by parul on 24/08/2009 for crf#0483
				//tasks_buff.append(treatment_tasks_code+"##"+treatment_tasks_desc+"##"+order_id+"##"+status+"##"+appt_ref_no+"##"+order_line_num+"##"+appt_reqd_yn+"##"+seq_no+"##"+bl_key+"##"+bl_data_exists_yn+"##"+billed_yn+"##"+start_date_time+"##"+end_date_time);
				
				//Commented by Sharon Crasta on 8/17/2009 for IN010893(SRR20056-CRF-0480)	//tasks_buff.append(treatment_tasks_code+"##"+treatment_tasks_desc+"##"+order_id+"##"+status+"##"+appt_ref_no+"##"+order_line_num+"##"+appt_reqd_yn+"##"+seq_no+"##"+bl_key+"##"+bl_data_exists_yn+"##"+billed_yn+"##"+start_date_time+"##"+end_date_time+"##"+cusp_tip_code);
			
				//Commented by Sharon Crasta on 9/11/2009 for IN011250
				//tasks_buff.append(treatment_tasks_code+"##"+treatment_tasks_desc+"##"+order_id+"##"+status+"##"+appt_ref_no+"##"+order_line_num+"##"+appt_reqd_yn+"##"+seq_no+"##"+bl_key+"##"+bl_data_exists_yn+"##"+billed_yn+"##"+start_date_time+"##"+end_date_time+"##"+cusp_tip_code+"##"+task_seq_no);  //14
				tasks_buff.append(treatment_tasks_code+"##"+treatment_tasks_desc+"##"+order_id+"##"+status+"##"+appt_ref_no+"##"+order_line_num+"##"+appt_reqd_yn+"##"+seq_no+"##"+bl_key+"##"+bl_data_exists_yn+"##"+billed_yn+"##"+start_date_time+"##"+end_date_time+"##"+cusp_tip_code+"##"+task_seq_no+"##"+appt_date_time+"##"+patient_class+"##"+super_tooth_no+"##"+retained_tooth_no);  //14
				tasks_buff.append("~");
				//
			}
			out.println(tasks_buff);
		}
		
		else if(func_mode.equalsIgnoreCase("getChargeDetails")){	
			
			String trmt_code	= checkForNull(request.getParameter( "trmt_code" )) ;
			String task_code	= checkForNull(request.getParameter( "task_code" )) ;
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num	= checkForNull(request.getParameter( "chart_line_num" )) ;
			String episode_type	= checkForNull(request.getParameter( "episode_type" )) ;
			String episode_id	= checkForNull(request.getParameter( "episode_id" )) ;
			String visit_id	= checkForNull(request.getParameter( "visit_id" )) ;
			String encounter_id	= checkForNull(request.getParameter( "encounter_id" )) ;
			String pract_staff_id	= checkForNull(request.getParameter( "practitioner_id" )) ;
			//Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
			String seq_no	= checkForNull(request.getParameter( "seq_no" )) ;
			String order_id	= checkForNull(request.getParameter( "order_id" )) ;
			//
			//String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
			//String call_billing_yn	= checkForNull(request.getParameter( "call_billing_yn" )) ;
			//String serv_panel_ind = "";
			//String serv_panel_code = "";
			String bl_key = "";
			String patient_payable = "";
			//String patient_paid_amt = "";
			String total_payable = "";
			String bl_data_exists_yn = "N";
			String incl_excl_ind = "N";
			String preapp_yn = "N";
			String serv_panel_ind = "";

			//String sql				= "";		
			String treatment_tasks_code = "";
			String treatment_tasks_desc = "";
			//String order_id = "";
			String order_line_num = "";
			String status = "";
			String visit_id_val = "";
			//String multiple_task_yn = "";
			String appt_ref_no = "";
			String appt_reqd_yn = "";
			//String seq_no = "";
			String module_id = "";
			StringBuffer tasks_buff= new StringBuffer();
			ArrayList bl_str_list = null;
			//HashMap bl_str_map = null;
			//HashMap bill_map = null;

			//Added by Sharon Crasta for CRF #0430 to display the patient paid as 0 when null.
			int patient_paid_amt_int = 0;
			
			//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
			//commented by parul on 02/07/2010 for 22318
			//pstmt = con.prepareStatement("SELECT ENCOUNTER_ID FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM =? AND TRMT_CODE = ? AND TASK_CODE = ? ");
			
			pstmt = con.prepareStatement("SELECT A.ENCOUNTER_ID,B.EPISODE_TYPE  FROM  OH_RESTORATIVE_CHART_TASKS A, OH_RESTORATIVE_CHART_DTL B WHERE A.PATIENT_ID =? AND A.CHART_NUM=? AND A.CHART_LINE_NUM=? AND A.TASK_CODE=? AND B.TRMT_CODE = ?  AND A.ORDER_ID=? AND A.CHART_LINE_NUM=B.CHART_LINE_NUM AND A.CHART_NUM=B.CHART_NUM AND A.PATIENT_ID =B.PATIENT_ID");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			pstmt.setString(4,task_code);
			pstmt.setString(5,trmt_code);
			pstmt.setString(6,order_id);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				encounter_id = checkForNull(rst.getString("ENCOUNTER_ID"));
				episode_type= checkForNull(rst.getString("EPISODE_TYPE"));
			}
			ArrayList episode_visit_list = oh_bean.getEpisodeAndVisitId(encounter_id);
			episode_id = (String) episode_visit_list.get(0);
			visit_id = (String) episode_visit_list.get(1);
			

			//Commented By Sharon Crasta on 3/18/2009 for CRF #0423
			//pstmt = con.prepareStatement("SELECT A.BILL_SUB_REGN_NUM, A.TASK_CODE, B.TASK_DESC, A.SEQ_NO, A.ORDER_ID, A.ORDER_LINE_NUM,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_TYPE, (SELECT APPT_REF_NO FROM OA_APPT WHERE FACILITY_ID =A.OPERATING_FACILITY_ID AND ORDER_ID = A.ORDER_ID AND ORDER_LINE_NUM = A.ORDER_LINE_NUM) APPT_REF_NO, NVL(A.APPT_REQD_YN,'N') APPT_REQD_YN FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG_VW B, OH_RESTORATIVE_CHART_DTL C WHERE A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID AND A.PATIENT_ID=C.PATIENT_ID AND A.CHART_NUM=C.CHART_NUM AND A.CHART_LINE_NUM =C.CHART_LINE_NUM AND A.TRMT_CODE = C.TRMT_CODE AND A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM =? AND A.TRMT_CODE = ? AND A.TASK_CODE = B.TASK_CODE AND A.TASK_CODE = ? AND B.LANGUAGE_ID=? AND NVL(A.STATUS,'X') != 'E' AND NVL(C.COND_CLOSED_YN,'N') = 'N' ORDER BY A.SEQ_NO");
			//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
			//pstmt = con.prepareStatement("SELECT A.OPERATING_FACILITY_ID,A.BILL_SUB_REGN_NUM, A.TASK_CODE, B.TASK_DESC, A.SEQ_NO, A.ORDER_ID, A.ORDER_LINE_NUM,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_TYPE, (SELECT APPT_REF_NO FROM OA_APPT WHERE ORDER_ID = A.ORDER_ID AND ORDER_LINE_NUM = A.ORDER_LINE_NUM) APPT_REF_NO, NVL(A.APPT_REQD_YN,'N') APPT_REQD_YN FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG_VW B, OH_RESTORATIVE_CHART_DTL C WHERE A.PATIENT_ID=C.PATIENT_ID AND A.CHART_NUM=C.CHART_NUM AND A.CHART_LINE_NUM =C.CHART_LINE_NUM AND A.TRMT_CODE = C.TRMT_CODE AND A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM =? AND A.TRMT_CODE = ? AND A.TASK_CODE = B.TASK_CODE AND A.TASK_CODE = ? AND B.LANGUAGE_ID=? AND NVL(A.STATUS,'X') != 'E' AND NVL(C.COND_CLOSED_YN,'N') = 'N' ORDER BY A.SEQ_NO");
			pstmt = con.prepareStatement("SELECT A.OPERATING_FACILITY_ID,A.BILL_SUB_REGN_NUM, A.TASK_CODE, B.TASK_DESC, A.SEQ_NO, A.ORDER_ID, A.ORDER_LINE_NUM,(SELECT ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_TYPE, (SELECT APPT_REF_NO FROM OA_APPT WHERE ORDER_ID = A.ORDER_ID AND ORDER_LINE_NUM = A.ORDER_LINE_NUM) APPT_REF_NO, NVL(A.APPT_REQD_YN,'N') APPT_REQD_YN FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG_VW B, OH_RESTORATIVE_CHART_DTL C WHERE A.PATIENT_ID=C.PATIENT_ID AND A.CHART_NUM=C.CHART_NUM AND A.CHART_LINE_NUM =C.CHART_LINE_NUM AND A.TRMT_CODE = C.TRMT_CODE AND A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM =? AND A.TRMT_CODE = ? AND A.TASK_CODE = B.TASK_CODE AND A.TASK_CODE = ? AND A.TASK_SEQ = ? AND B.LANGUAGE_ID=? AND NVL(A.STATUS,'X') != 'E' AND NVL(C.COND_CLOSED_YN,'N') = 'N' ORDER BY A.TASK_SEQ");
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,chart_line_num);
			pstmt.setString(4,trmt_code);
			pstmt.setString(5,task_code);
			pstmt.setString(6,seq_no);
			pstmt.setString(7,locale);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				facility_id = checkForNull(rst.getString("OPERATING_FACILITY_ID"));
				bl_key = checkForNull(rst.getString("BILL_SUB_REGN_NUM"));
				treatment_tasks_code = rst.getString("TASK_CODE");
				treatment_tasks_desc = rst.getString("TASK_DESC");
				seq_no = rst.getString("SEQ_NO");
				order_id = rst.getString("ORDER_ID");
				status = rst.getString("STATUS_TYPE");
				appt_ref_no = rst.getString("APPT_REF_NO");
				appt_reqd_yn = rst.getString("APPT_REQD_YN");
				order_line_num = rst.getString("ORDER_LINE_NUM");

				if(bl_key.equals("")){
					module_id="OR";
					bl_data_exists_yn = "N";
					//bl_key = order_id+"~"+chart_num;
					bl_key = order_id;
				}
				else{
					module_id="OH";
					bl_data_exists_yn = "Y";
				}
                
				bl_str_list = oh_bean.getBillDetails(treatment_tasks_code,episode_type,module_id,bl_key,order_line_num,patient_id,episode_id,visit_id, encounter_id,"1",pract_staff_id,facility_id,locale,"TASK");
				//bl_str_list = oh_bean.getBillDetails(treatment_tasks_code,episode_type,module_id,bl_key,order_line_num,patient_id,episode_id,visit_id, encounter_id,"1",pract_staff_id,other_chart_facility_id,locale,"TASK");
				//Added by Sharon Crasta for CRF #0430 to display the patient paid as 0 when null.
				if(bl_str_list.get(1) == "null" || bl_str_list.get(1) == null || bl_str_list.get(1) == ""){
					patient_paid_amt_int = 0;
				}else{
					patient_paid_amt_int = Integer.parseInt(bl_str_list.get(1).toString());
				}
				//
				patient_payable = (String)bl_str_list.get(0);
				//Commented by Sharon Crasta for CRF #0430 to display the patient paid as 0 when null.
				//patient_paid_amt = (String)bl_str_list.get(1);
				//
				total_payable = (String)bl_str_list.get(2);
				incl_excl_ind = (String)bl_str_list.get(3);
				preapp_yn = (String)bl_str_list.get(4);
				serv_panel_ind = (String)bl_str_list.get(5);
															
				//Commented and Added by Sharon Crasta for CRF #0430 to display the patient paid as 0 when null.	
				//tasks_buff.append(patient_payable+"##"+patient_paid_amt+"##"+total_payable);
				tasks_buff.append(patient_payable+"##"+patient_paid_amt_int+"##"+total_payable+"##"+incl_excl_ind+"##"+preapp_yn+"##"+serv_panel_ind);
				//
				tasks_buff.append("~");	
			}
			out.println(tasks_buff);
		}else if(func_mode.equalsIgnoreCase("TreatmentRHSTooltip")){ //Added By Yadav CRF-707 on 10/6/2009
				String encounter="";
				String patient_class=""; 									   
				String practitioner_id=""; 
				String performedInOt="";
				String otEncounter="";
				String encounter_id = checkForNull(request.getParameter( "encounter_id" ));
				String chart_num = checkForNull(request.getParameter( "chart_num" ));
				String chart_line_num = checkForNull(request.getParameter( "chart_line_num" ));
				String patient_id = checkForNull(request.getParameter( "patient_id" ));
				String trmt_code = checkForNull(request.getParameter( "trmt_code" ));
				String task_code = checkForNull(request.getParameter( "task_code" ));
				String task_seq_no = checkForNull(request.getParameter( "task_seq_no" ));
				String sql= "";		
				sql="SELECT ENCOUNTER_ID,PRACTITIONER_NAME FROM PR_ENCOUNTER ,AM_PRACTITIONER WHERE ENCOUNTER_ID =? AND FACILITY_ID=?  AND AM_PRACTITIONER.PRACTITIONER_ID=PR_ENCOUNTER.ATTEND_PRACTITIONER_ID";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,encounter_id);
				pstmt.setString(2,facility_id);
				rst = pstmt.executeQuery();
				
				while(rst.next()){
						
						encounter = checkForNull(rst.getString("ENCOUNTER_ID"));//
						practitioner_id = checkForNull(rst.getString("PRACTITIONER_NAME"));
					 }
					String sql1= "";
					sql1="SELECT ENCOUNTER_ID,PATIENT_CLASS,PERFORMED_IN_OT FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID=? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?";
					pstmt1=con.prepareStatement(sql1);
					pstmt1.setString(1,patient_id);
					pstmt1.setString(2,chart_num);
					pstmt1.setString(3,chart_line_num);
					pstmt1.setString(4,trmt_code);
					pstmt1.setString(5,task_code);
					pstmt1.setString(6,task_seq_no);
					rst1=pstmt1.executeQuery();
					while(rst1.next()){
						patient_class = checkForNull(rst1.getString("PATIENT_CLASS"));
						performedInOt= checkForNull(rst1.getString("PERFORMED_IN_OT"));
						otEncounter= checkForNull(rst1.getString("ENCOUNTER_ID"));

						}
			//	StringBuffer tasks_buff= new StringBuffer();
				//tasks_buff.append(encounter+":"+practitioner_id+":"+patient_class+":"+performedInOt);
			out.println(encounter+":"+practitioner_id+":"+patient_class+":"+performedInOt+":"+otEncounter+":"); 
			//out.println(tasks_buff); 
		} 
		
	}catch(Exception e){
		System.err.println("Err Msg from TreatmentsViewValidation.jsp "+e);
		System.err.println("TreatmentsViewValidation: func_mode== "+func_mode);
		System.err.println("TreatmentsViewValidation: trace_no== "+trace_no);
	}
	finally{
		if(rst!=null) rst.close();
		if(rst1!=null) rst1.close();
		if(rst2!=null) rst2.close();
		if(pstmt!=null)pstmt.close();
		if(pstmt1!=null)pstmt1.close();
		if(pstmt2!=null)pstmt2.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

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
