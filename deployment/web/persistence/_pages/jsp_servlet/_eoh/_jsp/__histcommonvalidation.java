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
import eOH.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __histcommonvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/HistCommonValidation.jsp", 1709117115825L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
  request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;

	String facility_id      = (String) session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("LOCALE");
	locale = "en";
	String func_mode = request.getParameter( "func_mode" ) ;

	String oh_bean_id 		= "OHHistoryBean";
	String oh_bean_name 	= "eOH.OHHistoryBean";
	OHHistoryBean oh_bean	= (OHHistoryBean)getBeanObject( oh_bean_id, oh_bean_name, request );
	oh_bean.clear();
	try{
		con = ConnectionManager.getConnection();
		if(func_mode.equalsIgnoreCase("getAllImagesForHistory")){
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_numbering_system = checkForNull(request.getParameter( "tooth_numbering_system" )) ;
			String baseline_chart_yn  = checkForNull(request.getParameter( "baseline_chart_yn" )) ;
			String site_type = "";
			String image_id = "";
			String  DB_tooth_no = "";
			String display_tooth_no = "";
			String condition_type = "";
			String surface_code = "";
			String treatment_condition = "";
			String status = "";
			String status_code = "";
			String hide_image_yn = "";
			int chart_line_num = 0;
			String mixed_dent_deciduous_yn = "";
			//String[] arr = null;
			StringBuffer concatImage = new StringBuffer();
			StringBuffer sql_append = new StringBuffer();
			String cusp_tip_code = "";
			String treatments_outcome = "";//added by parul on 11/02/2010 for CRF-477 & 496
			String treatment_int_ext = "";//added by parul on 11/02/2010 for CRF-477 & 496
			String image_id_new = "";//added by parul on 11/02/2010 for CRF-477 & 496

			if(baseline_chart_yn.equals("Y")){
				sql_append.append("SELECT A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID,(SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) IMAGE_ID_NEW,  A.SURFACE_CODE,A.CUSP_TIP_CODE,A.TREATMENTS_OUTCOME,A.TREATMENT_INT_EXT, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ?  AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N' AND SUPER_TOOTH_NO IS NULL AND RETAINED_TOOTH_NO IS NULL");
			
				sql_append.append(" AND ((A.TREATMENT_CONDITION = 'C' OR (A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='E')) OR  (A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='I' AND A.STATUS IS NOT NULL))");

				sql_append.append(" ORDER BY A.ARCH_SNO DESC, A.QUADRANT_SNO DESC, A.TOOTH_NO , A.CHART_LINE_NUM DESC, TREATMENT_CONDITION DESC");

				pstmt = con.prepareStatement(sql_append.toString());
				pstmt.setString(1,tooth_numbering_system);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,chart_num);
				
			}
			else{
				sql_append.append("SELECT A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID,(SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) IMAGE_ID_NEW,  A.SURFACE_CODE,A.CUSP_TIP_CODE,A.TREATMENTS_OUTCOME,A.TREATMENT_INT_EXT, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ?  AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N' AND SUPER_TOOTH_NO IS NULL AND RETAINED_TOOTH_NO IS NULL");

				sql_append.append(" AND ((A.TREATMENT_CONDITION = 'C' OR (A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='E')) OR  (A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='I' AND A.STATUS IS NOT NULL))");

				sql_append.append(" ORDER BY A.ARCH_SNO DESC, A.QUADRANT_SNO DESC, A.TOOTH_NO , A.CHART_LINE_NUM DESC, TREATMENT_CONDITION DESC");

				pstmt = con.prepareStatement(sql_append.toString());

				pstmt.setString(1,tooth_numbering_system);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,chart_num);
				
			}

			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				chart_line_num = Integer.parseInt(checkForNull(rst.getString("CHART_LINE_NUM")));

				site_type = rst.getString("SITE_TYPE");
				image_id = rst.getString("IMAGE_ID");
				status = rst.getString("STATUS"); //This is to get the status from OR table with respect to the status is stored in the chart_dtl table..
				status_code = rst.getString("STATUS_CODE"); // This is to get the status which is stored in the chart_dtl table..
				image_id_new = rst.getString("IMAGE_ID_NEW");
				treatment_int_ext = rst.getString("TREATMENT_INT_EXT");

					if(site_type.equals("ARCH")){
						DB_tooth_no = rst.getString("ARCH_SNO");
						treatment_condition = rst.getString("TREATMENT_CONDITION"); // CONDITION OR TREATMENT TYPE	
						condition_type = rst.getString("CONDITION_OR_TREATMENT_TYPE"); // CONDITION OR TREATMENT TYPE
						treatments_outcome = rst.getString("TREATMENTS_OUTCOME");
						
						concatImage.append(image_id+"##"+DB_tooth_no+"##"+site_type+"##"+display_tooth_no+"##"+condition_type+"##"+treatment_condition+"##"+status+"##"+status_code+"##"+treatments_outcome+"##"+image_id_new+"##"+treatment_int_ext);
					}else if(site_type.equals("QUAD")){
						DB_tooth_no = rst.getString("QUADRANT_SNO");
						treatment_condition = rst.getString("TREATMENT_CONDITION"); // CONDITION OR TREATMENT TYPE	
						condition_type = rst.getString("CONDITION_OR_TREATMENT_TYPE"); // CONDITION OR TREATMENT TYPE
						treatments_outcome = rst.getString("TREATMENTS_OUTCOME");

						concatImage.append(image_id+"##"+DB_tooth_no+"##"+site_type+"##"+display_tooth_no+"##"+condition_type+"##"+treatment_condition+"##"+status+"##"+status_code+"##"+treatments_outcome+"##"+image_id_new+"##"+treatment_int_ext);
					}else if(site_type.equals("TOOTH") || site_type.equals("THRNG")){
						DB_tooth_no = rst.getString("TOOTH_NO");
						display_tooth_no = rst.getString("NS_TOOTH_NO");
						condition_type = rst.getString("CONDITION_OR_TREATMENT_TYPE"); // CONDITION OR TREATMENT TYPE
						treatment_condition = rst.getString("TREATMENT_CONDITION"); // CONDITION OR TREATMENT TYPE	
						hide_image_yn = rst.getString("HIDE_IMAGE_YN"); // CONDITION OR TREATMENT TYPE	
						mixed_dent_deciduous_yn = rst.getString("MIXED_DENT_DECIDUOUS_YN"); // CONDITION OR TREATMENT TYPE
						treatments_outcome = rst.getString("TREATMENTS_OUTCOME");
						concatImage.append(image_id+"##"+DB_tooth_no+"##"+site_type+"##"+display_tooth_no+"##"+condition_type+"##"+treatment_condition+"##"+status+"##"+hide_image_yn+"##"+mixed_dent_deciduous_yn+"##"+treatments_outcome+"##"+image_id_new+"##"+treatment_int_ext);
					}else if(site_type.equals("CROWN")){
						image_id = "";
						DB_tooth_no = rst.getString("TOOTH_NO");
						display_tooth_no = rst.getString("NS_TOOTH_NO");
						surface_code = checkForNull(rst.getString("SURFACE_CODE"));
						condition_type = rst.getString("CONDITION_OR_TREATMENT_TYPE"); // CONDITION OR TREATMENT TYPE	
						treatment_condition = rst.getString("TREATMENT_CONDITION"); // CONDITION OR TREATMENT TYPE	
						cusp_tip_code = rst.getString("CUSP_TIP_CODE"); 
						treatments_outcome = rst.getString("TREATMENTS_OUTCOME");

						if(!surface_code.equals("*A")){//added by parul for CRF-442
							image_id = "";
						}	concatImage.append(image_id+"##"+DB_tooth_no+"##"+display_tooth_no+"##"+site_type+"##"+condition_type+"##"+surface_code+"##"+treatment_condition+"##"+status+"##"+cusp_tip_code+"##"+treatments_outcome+"##"+image_id_new+"##"+treatment_int_ext);

					}else if(site_type.equals("ROOT")){
						DB_tooth_no = rst.getString("TOOTH_NO");
						display_tooth_no = rst.getString("NS_TOOTH_NO");
						surface_code = rst.getString("SURFACE_CODE");
						condition_type = rst.getString("CONDITION_OR_TREATMENT_TYPE"); // CONDITION OR TREATMENT TYPE			
						treatment_condition = rst.getString("TREATMENT_CONDITION"); // CONDITION OR TREATMENT TYPE	
						treatments_outcome = rst.getString("TREATMENTS_OUTCOME");
						concatImage.append(image_id+"##"+DB_tooth_no+"##"+site_type+"##"+display_tooth_no+"##"+condition_type+"##"+treatment_condition+"##"+status+"##"+status_code+"##"+hide_image_yn+"##"+mixed_dent_deciduous_yn+"##"+surface_code+"##"+cusp_tip_code+"##"+chart_line_num+"##"+treatments_outcome+"##"+image_id_new+"##"+treatment_int_ext);

					}

					concatImage.append("~");
			}
			out.println(concatImage);
			oh_bean.setAllImagesForHistory_2(concatImage);
			oh_bean.setAllImagesForHistory(concatImage);

			sql_append.setLength(0);
		}
		else if(func_mode.equalsIgnoreCase("populateDisplayToothNoAndName")){	
			String numbering_system = checkForNull(request.getParameter( "numbering_system" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String permanent_deciduous_flag = checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String mixed_dentition_YN = checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			String sql				= "";	
			String display_tooth_no = "";
			String tooth_name = "";
			String mapped_tooth_no = "";
			String mixed_dent_tooth_no = "";
			if(tooth_no.indexOf(",") == -1){ //If tooth no is in the form of (12,14) system will throw an exception saying that "Invalid Number".Changed ON 05MAR2008
				if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
					sql = "SELECT B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.MIXED_DENT_TOOTH_NO FROM OH_TOOTH_LANG_VW  B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) AND TOOTH_NO = ?";
				}else{
					sql = "SELECT B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.MIXED_DENT_TOOTH_NO FROM OH_TOOTH_LANG_VW B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND B.PERMANENT_DECIDUOUS = ? AND TOOTH_NO = ?";
				}
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,numbering_system);
				pstmt.setString(3,permanent_deciduous_flag);
				pstmt.setString(4,tooth_no);
				rst=pstmt.executeQuery();
				while(rst.next()){
					display_tooth_no = checkForNull(rst.getString("TOOTH_NUM"));
					tooth_name = checkForNull(rst.getString("TOOTH_NAME"));
					mapped_tooth_no = checkForNull(rst.getString("MAPPED_TOOTH_NO"));
					mixed_dent_tooth_no = checkForNull(rst.getString("MIXED_DENT_TOOTH_NO"));
				}
			}
		    out.println(display_tooth_no+"##"+tooth_name+"##"+mapped_tooth_no+"##"+mixed_dent_tooth_no);
		}
		else if(func_mode.equalsIgnoreCase("SuperRDyn")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no	= checkForNull(request.getParameter( "tooth_no" )) ;
			String SuperRDyn = "N";
			String mixed_dent_deciduous_yn = "";
			
			pstmt = con.prepareStatement(" SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE IN ('RTDESTH','SUPRTH') AND NVL(COND_CLOSED_YN,'N') = 'N'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				mixed_dent_deciduous_yn = checkForNull(rst.getString("CONDITION_TYPE"));
				SuperRDyn = "Y";
			}
			out.println(SuperRDyn+"##"+mixed_dent_deciduous_yn);
		}
		else if(func_mode.equalsIgnoreCase("populateSuperYN")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String super_yn = "";
			String RD_yn = "";
			pstmt = con.prepareStatement("SELECT CONDITION_TYPE, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			pstmt.setString(4,tooth_no);
			rst=pstmt.executeQuery();
			while(rst.next()){
				if(checkForNull(rst.getString("CONDITION_TYPE")).equals("EXFOLTH")){
					super_yn = checkForNull(rst.getString("SUPERNUMERARY_YN"));
					RD_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));
				}
			}
		    out.println(super_yn+"##"+RD_yn);
		}
		else if(func_mode.equalsIgnoreCase("populateNSToothNoForJS")){	
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String numbering_system = checkForNull(request.getParameter( "numbering_system" )) ;
			String sql				= "";	
			String dec_ns_tooth_no = "";
			//String int_tooth_no = "";
			sql = "SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,numbering_system);
			pstmt.setString(2,tooth_no);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				dec_ns_tooth_no = checkForNull(rst.getString("NS_TOOTH_NO"));
				
			}
			out.println(dec_ns_tooth_no);
		}
		else if(func_mode.equalsIgnoreCase("populateNSToothNo")){	
			String PD_flag = "";
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String numbering_system = checkForNull(request.getParameter( "numbering_system" )) ;
			String permanent_deciduous_flag = checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String mixed_dentition_YN = checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
			if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D")){
				PD_flag = "P";
			}
			else{
				PD_flag = "D";
			}
			String sql				= "";	
			String dec_ns_tooth_no = "";
			String int_tooth_no = "";
			//Commented by Sharon Crasta on 1/18/2010 for IN010894(SRR20056-CRF-0481) for new SUPRTH and RTDESTH changes
			//sql = "SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?) AND B.PERMANENT_DECIDUOUS = ?";
			sql = "SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,numbering_system);
			pstmt.setString(2,tooth_no);
			//pstmt.setString(3,PD_flag);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				dec_ns_tooth_no = checkForNull(rst.getString("NS_TOOTH_NO"));
				int_tooth_no = checkForNull(rst.getString("TOOTH_NO"));
			}
			out.println(dec_ns_tooth_no+"##"+int_tooth_no);
		}
		//Perio Functions

		else if(func_mode.equalsIgnoreCase("getChartComponents")){	
			String chart_code = checkForNull(request.getParameter("perio_chart"));
			String comp_code = "";

			StringBuffer comp_code_buff = new StringBuffer();

			pstmt = con.prepareStatement("SELECT COMPONENT_CODE FROM OH_PERIODONTAL_CHART_DEF_DTL WHERE CHART_CODE = ?");
			pstmt.setString(1,chart_code);
			
			rst=pstmt.executeQuery();
			while(rst.next()){
				comp_code = checkForNull(rst.getString("COMPONENT_CODE"));
				comp_code_buff.append(comp_code);
				comp_code_buff.append("~");
			}
			out.println(comp_code_buff);
		}
		else if(func_mode.equalsIgnoreCase("getAllDetailRecords")){	
			String patient_id = checkForNull(request.getParameter("patient_id"));
			String chart_num = checkForNull(request.getParameter("chart_num"));
			String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
			String chart_code = checkForNull(request.getParameter("perio_chart"));
			String baseline_closed_yn = checkForNull(request.getParameter("baseline_closed_yn"));
			String eval_active_yn = checkForNull(request.getParameter("eval_active_yn"));
			String tab_code = checkForNull(request.getParameter("tab_code"));
			
			String component_code = "";
			String tooth_no = "";
			String s1 = "";
			String s2 = "";
			String s3 = "";
			String s4 = "";
			String s5 = "";
			String s6 = "";
			String value = "";
			String surface_B_val = "";
			String surface_L_val = "";
			StringBuffer surface_code_name = new StringBuffer();
			if(tab_code.equals("BC")){ // For Baseline Charts
				if(baseline_closed_yn.equals("Y")){ // Called from Baseline Chart Active menu
					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS = 'CD'");
				}
				else{ 
					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS NOT IN ('CD','ME')");
				}

				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,"1");
				pstmt.setString(5,chart_code);
				pstmt.setString(6,tab_code);
			}
			else if(tab_code.equals("EC")){ //For Evaluation Charts
				if(eval_active_yn.equals("N")){ // Called from Baseline/Evaluation Chart menu (for completed Evaluation Charts)
					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND C.CHART_LINE_STATUS = 'CM'");
				}
				else{ 
					//pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS NOT IN ('CD','ME') AND C.CHART_LINE_STATUS NOT IN ('CD','ME','CM')");
					pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE,A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM = C.CHART_NUM AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE = ? AND C.CHART_TYPE = ? AND B.CHART_STATUS NOT IN ('CD','ME') AND C.CHART_LINE_STATUS NOT IN ('CD','ME')");
				}
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,chart_code);
				pstmt.setString(6,tab_code);
			}
			
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				component_code = checkForNull(rst.getString("COMPONENT_CODE"));
				tooth_no = checkForNull(rst.getString("TOOTH_NO"));
				s1 = checkForNull(rst.getString("s1"));
				s2 = checkForNull(rst.getString("s2"));
				s3 = checkForNull(rst.getString("s3"));
				s4 = checkForNull(rst.getString("s4"));
				s5 = checkForNull(rst.getString("s5"));
				s6 = checkForNull(rst.getString("s6"));
				value = checkForNull(rst.getString("VALUE"));
				surface_B_val = s1+s2+s3;
				surface_L_val = s4+s5+s6;
				//surface_code_name.append(component_code+"##"+tooth_no+"##"+surface_B_val+"##"+surface_L_val+"##"+value);
				surface_code_name.append(component_code+"##"+tooth_no+"##"+s1+"##"+s2+"##"+s3+"##"+s4+"##"+s5+"##"+s6+"##"+value);
				surface_code_name.append("~");
			}
			out.println(surface_code_name);
		}else if(func_mode.equalsIgnoreCase("getCutOffValues")){	
			String component_code = checkForNull(request.getParameter("component_code"));
			String chart_code = checkForNull(request.getParameter("chart_code"));
			//String min_val = "";
			//String max_val = "";
			String cut_off = "";
			//String surfaces_appl_yn = "";
			//StringBuffer surface_code_name = new StringBuffer();
			pstmt = con.prepareStatement("SELECT B.CUT_OFF FROM OH_PERIODONTAL_CHART_COMP A,OH_PERIODONTAL_CHART_DEF_DTL B WHERE  A.COMPONENT_CODE=B.COMPONENT_CODE AND  B.CHART_CODE = ? and B.COMPONENT_CODE=?");
			pstmt.setString(1,chart_code);
			pstmt.setString(2,component_code);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				cut_off = checkForNull(rst.getString("CUT_OFF"));
			}
			out.println(cut_off);
		}else if(func_mode.equalsIgnoreCase("checkForERUPTH")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String called_from = checkForNull(request.getParameter( "called_from" )) ;
			String condition_type = "";
			int chart_line_num = 0;

			if(called_from.equals("populateArea")){
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Z' AND NVL(COND_CLOSED_YN,'N') = 'N' AND (SUPERNUMERARY_YN = 'N' OR SUPERNUMERARY_YN IS NULL) AND CONDITION_TYPE IN ('ERUPTH','EXFOLTH') ORDER BY CHART_NUM, CHART_LINE_NUM");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				rst=pstmt.executeQuery();

				while(rst.next()){
					chart_line_num = Integer.parseInt(checkForNull(rst.getString("CHART_LINE_NUM")));
				}
			}else{
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Z' AND NVL(COND_CLOSED_YN,'N') = 'N' AND CONDITION_TYPE = 'ERUPTH' ORDER BY CHART_NUM, CHART_LINE_NUM");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				rst=pstmt.executeQuery();

				while(rst.next()){
					condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
					
					if(condition_type.equals("ERUPTH")){
						chart_line_num = Integer.parseInt(checkForNull(rst.getString("CHART_LINE_NUM")));
					}
				}
			}
		    out.println(chart_line_num);
		}

	}catch(Exception e){
		e.printStackTrace() ;
		System.err.println("HistCommonValidation, Exception at 349 qrystring=: "+request.getQueryString());
		System.err.println("HistCommonValidation, Exception at 349, func_mode== "+func_mode);
	}
	finally{
		if(rst!=null) rst.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
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
