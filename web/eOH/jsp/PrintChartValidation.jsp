<!DOCTYPE html>
<%@ page  import="java.sql.*,java.util.*, eOH.*, eOH.Common.*, eCommon.Common.*, webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>



<%

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;

	String facility_id      = (String) session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("LOCALE");
	//locale = "en";
	String func_mode = request.getParameter( "func_mode" ) ;

	String oh_bean_id 		= "OHHistoryBean";
	String oh_bean_name 	= "eOH.OHHistoryBean";
	OHHistoryBean oh_bean	= (OHHistoryBean)getBeanObject( oh_bean_id, oh_bean_name, request );
	oh_bean.clear();
	try{
		con = ConnectionManager.getConnection();
		if(func_mode.equalsIgnoreCase("getAllImagesForHistoryForPrint")){
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_numbering_system = checkForNull(request.getParameter( "tooth_numbering_system" )) ;
			String baseline_chart_yn  = checkForNull(request.getParameter( "baseline_chart_yn" )) ;
			String asOnDatePrint  = checkForNull(request.getParameter( "asOnDatePrint" )) ;
			String oh_chart_level        = request.getParameter("oh_chart_level");
			String other_chart_facility_id        = request.getParameter("other_chart_facility_id");
			String as_on_date_chart_num        = request.getParameter("as_on_date_chart_num");// Added by Sridevi Joshi on 6/8/2010 for IN021890
			//String sql				= "";
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
			String image_id_new = "";
			//String[] arr = null;
			StringBuffer concatImage = new StringBuffer();
			StringBuffer sql_append = new StringBuffer();
			String cusp_tip_code = "";
			String treatments_outcome = "";
			String treatment_int_ext = "";
			if(oh_chart_level.equals("E")){
				if(baseline_chart_yn.equals("Y")){
					//sql_append.append("SELECT A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID, A.SURFACE_CODE,A.CUSP_TIP_CODE, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ?  AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
					//Commented by Sharon Crasta on 1/13/2010 for IN010894(SRR20056-CRF-0481) for new SUPRTH changes
					//sql_append.append("SELECT A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID, A.SURFACE_CODE,A.CUSP_TIP_CODE, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
					//commented by parul on 24/02/2010 for CRF-477
					//sql_append.append("SELECT A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID, A.SURFACE_CODE,A.CUSP_TIP_CODE,A.TREATMENTS_OUTCOME, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N' AND SUPER_TOOTH_NO IS NULL AND RETAINED_TOOTH_NO IS NULL");
					sql_append.append("SELECT A.TREATMENT_INT_EXT,A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID,(SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) IMAGE_ID_NEW, A.SURFACE_CODE,A.CUSP_TIP_CODE,A.TREATMENTS_OUTCOME, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE  PATIENT_ID = ? AND CHART_NUM = ? AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N' AND SUPER_TOOTH_NO IS NULL AND RETAINED_TOOTH_NO IS NULL");
				
					/*if(treatment_condition_tab_flag.equals("T")){ //When Clicked on Top Treatment Tab
						sql_append.append(" AND ((A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='I' AND (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) IS NOT NULL AND (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) NOT IN ('E')) OR A.TREATMENT_CONDITION = 'C')");
					}else{
						sql_append.append(" AND (A.TREATMENT_CONDITION = 'C' OR (A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='E')) ");
					}*/
					sql_append.append(" AND ((A.TREATMENT_CONDITION = 'C' OR (A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='E')) OR  (A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='I' AND A.STATUS IS NOT NULL))");

					sql_append.append(" ORDER BY A.ARCH_SNO DESC, A.QUADRANT_SNO DESC, A.TOOTH_NO , A.CHART_LINE_NUM DESC, TREATMENT_CONDITION DESC");
					pstmt = con.prepareStatement(sql_append.toString());
					pstmt.setString(1,tooth_numbering_system);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
								
				}
				else{
					//sql_append.append("SELECT A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID, A.SURFACE_CODE,A.CUSP_TIP_CODE, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ?  AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
					//sql_append.append("SELECT A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID, A.SURFACE_CODE,A.CUSP_TIP_CODE, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM = (SELECT MAX(CHART_NUM) FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND TO_DATE(?,'DD/MM/YYYY')  BETWEEN TRUNC(CHART_DATE) AND TRUNC(NVL(CHART_CLOSE_DATE,SYSDATE)))     AND TREATMENT_CONDITION_DATE <= TO_DATE (? || ' 23:59', 'DD/MM/YYYY HH24:MI')AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N'");

					//Commented by Sharon Crasta on 1/13/2010 for IN010894(SRR20056-CRF-0481) for new SUPRTH changes
					//sql_append.append("SELECT A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID, A.SURFACE_CODE,A.CUSP_TIP_CODE, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TREATMENT_CONDITION_DATE <= TO_DATE (? || ' 23:59', 'DD/MM/YYYY HH24:MI')AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
					//commented by parul on 24/02/2010 for CRF-477
					//sql_append.append("SELECT A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID, A.SURFACE_CODE,A.CUSP_TIP_CODE,A.TREATMENTS_OUTCOME, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TREATMENT_CONDITION_DATE <= TO_DATE (? || ' 23:59', 'DD/MM/YYYY HH24:MI')AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N' AND SUPER_TOOTH_NO IS NULL AND RETAINED_TOOTH_NO IS NULL");
					sql_append.append("SELECT A.TREATMENT_INT_EXT,A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID,(SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) IMAGE_ID_NEW,  A.SURFACE_CODE,A.CUSP_TIP_CODE,A.TREATMENTS_OUTCOME, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TREATMENT_CONDITION_DATE <= TO_DATE (? || ' 23:59', 'DD/MM/YYYY HH24:MI')AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N' AND SUPER_TOOTH_NO IS NULL AND RETAINED_TOOTH_NO IS NULL");

					sql_append.append(" AND ((A.TREATMENT_CONDITION = 'C' OR (A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='E')) OR  (A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='I' AND A.STATUS IS NOT NULL))");
					/*if(treatment_condition_tab_flag.equals("T")){ //When Clicked on Top Treatment Tab
						sql_append.append(" AND ((A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='I' AND (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) IS NOT NULL AND (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) NOT IN ('E')) OR A.TREATMENT_CONDITION = 'C')");
					}else{
						sql_append.append(" AND (A.TREATMENT_CONDITION = 'C' OR (A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='E')) ");
					}	*/

					sql_append.append(" ORDER BY A.ARCH_SNO DESC, A.QUADRANT_SNO DESC, A.TOOTH_NO , A.CHART_LINE_NUM DESC, TREATMENT_CONDITION DESC");

					pstmt = con.prepareStatement(sql_append.toString());
					pstmt.setString(1,tooth_numbering_system);
					pstmt.setString(2,patient_id);
					//pstmt.setString(3,chart_num);
					pstmt.setString(3,as_on_date_chart_num);
					pstmt.setString(4,asOnDatePrint);
					
				}
			}else{
				if(baseline_chart_yn.equals("Y")){
					//sql_append.append("SELECT A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID, A.SURFACE_CODE,A.CUSP_TIP_CODE, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ?  AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
					//Commented by Sharon Crasta on 1/13/2010 for IN010894(SRR20056-CRF-0481) for new SUPRTH changes
					//sql_append.append("SELECT A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID, A.SURFACE_CODE,A.CUSP_TIP_CODE, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
					//sql_append.append("SELECT A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID, A.SURFACE_CODE,A.CUSP_TIP_CODE,A.TREATMENTS_OUTCOME, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N' AND SUPER_TOOTH_NO IS NULL AND RETAINED_TOOTH_NO IS NULL");
					//commented by parul on 24/02/2010 for CRF-477
					sql_append.append("SELECT A.TREATMENT_INT_EXT,A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID,(SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) IMAGE_ID_NEW,  A.SURFACE_CODE,A.CUSP_TIP_CODE,A.TREATMENTS_OUTCOME, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N' AND SUPER_TOOTH_NO IS NULL AND RETAINED_TOOTH_NO IS NULL");
				
					/*if(treatment_condition_tab_flag.equals("T")){ //When Clicked on Top Treatment Tab
						sql_append.append(" AND ((A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='I' AND (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) IS NOT NULL AND (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) NOT IN ('E')) OR A.TREATMENT_CONDITION = 'C')");
					}else{
						sql_append.append(" AND (A.TREATMENT_CONDITION = 'C' OR (A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='E')) ");
					}*/
					sql_append.append(" AND ((A.TREATMENT_CONDITION = 'C' OR (A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='E')) OR  (A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='I' AND A.STATUS IS NOT NULL))");

					sql_append.append(" ORDER BY A.ARCH_SNO DESC, A.QUADRANT_SNO DESC, A.TOOTH_NO , A.CHART_LINE_NUM DESC, TREATMENT_CONDITION DESC");
					pstmt = con.prepareStatement(sql_append.toString());
					pstmt.setString(1,tooth_numbering_system);
					pstmt.setString(2,other_chart_facility_id);
					pstmt.setString(3,patient_id);
					pstmt.setString(4,chart_num);
								
				}
				else{
					//sql_append.append("SELECT A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID, A.SURFACE_CODE,A.CUSP_TIP_CODE, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ?  AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
					//Commented by Sharon Crasta on 1/13/2010 for IN010894(SRR20056-CRF-0481) for new SUPRTH changes
					//sql_append.append("SELECT A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID, A.SURFACE_CODE,A.CUSP_TIP_CODE, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TREATMENT_CONDITION_DATE <= TO_DATE (? || ' 23:59', 'DD/MM/YYYY HH24:MI')AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N'");
					//sql_append.append("SELECT A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID, A.SURFACE_CODE,A.CUSP_TIP_CODE,A.TREATMENTS_OUTCOME, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TREATMENT_CONDITION_DATE <= TO_DATE (? || ' 23:59', 'DD/MM/YYYY HH24:MI')AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N' AND SUPER_TOOTH_NO IS NULL AND RETAINED_TOOTH_NO IS NULL");
					sql_append.append("SELECT A.TREATMENT_INT_EXT,A.CHART_LINE_NUM,A.SITE_TYPE, A.TOOTH_NO, A.TOOTH_RANGE, A.ARCH_SNO, A.QUADRANT_SNO, A.HIDE_IMAGE_YN, A.MIXED_DENT_DECIDUOUS_YN, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS, A.STATUS STATUS_CODE ,DECODE(A.TRMT_CATEGORY_TYPE,NULL,(SELECT D.IMAGE_ID FROM OH_CONDITION_TYPE D WHERE A.CONDITION_TYPE=D.CONDITION_TYPE), (SELECT D.IMAGE_ID FROM OH_TREATMENT_CATEGORY_TYPE D WHERE D.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE)) IMAGE_ID,(SELECT DECODE(TREATMENT_INT_EXT,'E',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_E.gif',SUBSTR(E.IMAGE_ID,1,(INSTR(E.IMAGE_ID,'.gif')-1))||'_EF.gif'),'I',DECODE(NVL(TREATMENTS_OUTCOME,'S'),'S',E.IMAGE_ID,SUBSTR(E.IMAGE_ID,1,(INSTR (E.IMAGE_ID,'.gif')-1))||'_F.gif')) FROM OH_TREATMENT_CATEGORY_TYPE E WHERE E.TRMT_CATEGORY_TYPE = A.TRMT_CATEGORY_TYPE) IMAGE_ID_NEW, A.SURFACE_CODE,A.CUSP_TIP_CODE,A.TREATMENTS_OUTCOME, NVL(A.CONDITION_TYPE,A.TRMT_CATEGORY_TYPE) CONDITION_OR_TREATMENT_TYPE, (SELECT C.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE C.TOOTH_NO=A.TOOTH_NO AND NUMBERING_SYSTEM=?) NS_TOOTH_NO,TREATMENT_CONDITION FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TREATMENT_CONDITION_DATE <= TO_DATE (? || ' 23:59', 'DD/MM/YYYY HH24:MI')AND NVL(A.STATUS,'X')!='E' AND SITE_TYPE IS NOT NULL AND NVL(A.COND_CLOSED_YN,'N') = 'N' AND SUPER_TOOTH_NO IS NULL AND RETAINED_TOOTH_NO IS NULL");

					sql_append.append(" AND ((A.TREATMENT_CONDITION = 'C' OR (A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='E')) OR  (A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='I' AND A.STATUS IS NOT NULL))");
					/*if(treatment_condition_tab_flag.equals("T")){ //When Clicked on Top Treatment Tab
						sql_append.append(" AND ((A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='I' AND (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) IS NOT NULL AND (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) NOT IN ('E')) OR A.TREATMENT_CONDITION = 'C')");
					}else{
						sql_append.append(" AND (A.TREATMENT_CONDITION = 'C' OR (A.TREATMENT_CONDITION = 'T' AND A.TREATMENT_INT_EXT='E')) ");
					}	*/

					sql_append.append(" ORDER BY A.ARCH_SNO DESC, A.QUADRANT_SNO DESC, A.TOOTH_NO , A.CHART_LINE_NUM DESC, TREATMENT_CONDITION DESC");

					pstmt = con.prepareStatement(sql_append.toString());
					pstmt.setString(1,tooth_numbering_system);
					pstmt.setString(2,other_chart_facility_id);
					pstmt.setString(3,patient_id);
					//pstmt.setString(4,chart_num);
					pstmt.setString(4,as_on_date_chart_num);//Added by Sridevi Joshi on 6/8/2010 for IN021890
					pstmt.setString(5,asOnDatePrint);
					
				}
			}
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				chart_line_num = Integer.parseInt(checkForNull(rst.getString("CHART_LINE_NUM")));

				site_type = rst.getString("SITE_TYPE");
				image_id = rst.getString("IMAGE_ID");
				image_id_new = rst.getString("IMAGE_ID_NEW");
				status = rst.getString("STATUS"); //This is to get the status from OR table with respect to the status is stored in the chart_dtl table..
				status_code = rst.getString("STATUS_CODE"); // This is to get the status which is stored in the chart_dtl table..
				treatment_int_ext = rst.getString("TREATMENT_INT_EXT"); // This is to get the status which is stored in the chart_dtl table..
				surface_code = checkForNull(rst.getString("SURFACE_CODE"));

					if(site_type.equals("ARCH")){
						DB_tooth_no = rst.getString("ARCH_SNO");
						treatment_condition = rst.getString("TREATMENT_CONDITION"); // CONDITION OR TREATMENT TYPE	
						condition_type = rst.getString("CONDITION_OR_TREATMENT_TYPE"); // CONDITION OR TREATMENT TYPE
						treatments_outcome = rst.getString("TREATMENTS_OUTCOME"); 
						//concatImage.append(image_id+"##"+DB_tooth_no+"##"+site_type+"##"+display_tooth_no+"##"+condition_type+"##"+treatment_condition+"##"+status+"##"+status_code);
					}else if(site_type.equals("QUAD")){
						DB_tooth_no = rst.getString("QUADRANT_SNO");
						treatment_condition = rst.getString("TREATMENT_CONDITION"); // CONDITION OR TREATMENT TYPE	
						condition_type = rst.getString("CONDITION_OR_TREATMENT_TYPE"); // CONDITION OR TREATMENT TYPE
						treatments_outcome = rst.getString("TREATMENTS_OUTCOME"); 

						//commented by parul on 04/03/2010 for CRf-477 on 04/03/2010 
						//concatImage.append(image_id+"##"+DB_tooth_no+"##"+site_type+"##"+display_tooth_no+"##"+condition_type+"##"+treatment_condition+"##"+status+"##"+status_code);

					}else if(site_type.equals("TOOTH") || site_type.equals("THRNG")){
						DB_tooth_no = rst.getString("TOOTH_NO");
						display_tooth_no = rst.getString("NS_TOOTH_NO");
						condition_type = rst.getString("CONDITION_OR_TREATMENT_TYPE"); // CONDITION OR TREATMENT TYPE
						treatment_condition = rst.getString("TREATMENT_CONDITION"); // CONDITION OR TREATMENT TYPE	
						hide_image_yn = rst.getString("HIDE_IMAGE_YN"); // CONDITION OR TREATMENT TYPE	
						mixed_dent_deciduous_yn = rst.getString("MIXED_DENT_DECIDUOUS_YN"); // CONDITION OR TREATMENT TYPE	
                        treatments_outcome = rst.getString("TREATMENTS_OUTCOME"); 

						//concatImage.append(image_id+"##"+DB_tooth_no+"##"+site_type+"##"+display_tooth_no+"##"+condition_type+"##"+treatment_condition+"##"+status+"##"+hide_image_yn+"##"+mixed_dent_deciduous_yn);
					}else if(site_type.equals("CROWN")){
						//image_id = "";
						DB_tooth_no = rst.getString("TOOTH_NO");
						display_tooth_no = rst.getString("NS_TOOTH_NO");
						condition_type = rst.getString("CONDITION_OR_TREATMENT_TYPE"); // CONDITION OR TREATMENT TYPE	
						treatment_condition = rst.getString("TREATMENT_CONDITION"); // CONDITION OR TREATMENT TYPE	
						cusp_tip_code = rst.getString("CUSP_TIP_CODE"); 
						treatments_outcome = rst.getString("TREATMENTS_OUTCOME"); 

							if(!surface_code.equals("*A")){
								image_id = "";
							}
						//concatImage.append(DB_tooth_no+"##"+display_tooth_no+"##"+site_type+"##"+surface_code+"##"+condition_type+"##"+treatment_condition+"##"+status+"##"+cusp_tip_code);
					}else if(site_type.equals("ROOT")){
						//image_id = "";
						DB_tooth_no = rst.getString("TOOTH_NO");
						display_tooth_no = rst.getString("NS_TOOTH_NO");
						surface_code = rst.getString("SURFACE_CODE");
						condition_type = rst.getString("CONDITION_OR_TREATMENT_TYPE"); // CONDITION OR TREATMENT TYPE			
						treatment_condition = rst.getString("TREATMENT_CONDITION"); // CONDITION OR TREATMENT TYPE			
						treatments_outcome = rst.getString("TREATMENTS_OUTCOME"); 
					//concatImage.append(image_id+"##"+DB_tooth_no+"##"+site_type+"##"+display_tooth_no+"##"+condition_type+"##"+treatment_condition+"##"+status+"##"+status_code+"##"+hide_image_yn+"##"+surface_code+"##"+chart_line_num);
					} 
					
					concatImage.append(image_id+"##"+DB_tooth_no+"##"+site_type+"##"+display_tooth_no+"##"+condition_type+"##"+treatment_condition+"##"+status+"##"+status_code+"##"+hide_image_yn+"##"+mixed_dent_deciduous_yn+"##"+surface_code+"##"+cusp_tip_code+"##"+chart_line_num+"##"+treatments_outcome+"##"+image_id_new+"##"+treatment_int_ext);					
					concatImage.append("~");
			}
			out.println(concatImage);
			//oh_bean.setAllImagesForHistory_2(concatImage);
			//StringBuffer applyTrmts =oh_bean.getAllImagesForHistory_2();				
			//oh_bean.setAllImagesForHistory(concatImage);

			sql_append.setLength(0);
		}
		else if(func_mode.equalsIgnoreCase("updateDentistComments")){
			Hashtable htFormValues  = (Hashtable) XMLobj.parseXMLString(request);
			htFormValues = (Hashtable)htFormValues.get( "SEARCH" ) ;
			String patient_id = (String) htFormValues.get( "patient_id");
			String chart_num = (String) htFormValues.get( "chart_num");
			String dentist_comments = (String) htFormValues.get( "dentist_comments");

			dentist_comments = java.net.URLDecoder.decode(dentist_comments,"UTF-8");
			int update_dentist_comments = 0;

			pstmt = con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_HDR SET DENTIST_COMMENTS = ? WHERE PATIENT_ID = ? AND CHART_NUM = ?");
				
			pstmt.setString(1,dentist_comments);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			
			update_dentist_comments = pstmt.executeUpdate();
			if(update_dentist_comments != 0){
				con.commit();
			}
			else{
				con.rollback();
			}
			
			out.println(update_dentist_comments);
		}  else if(func_mode.equalsIgnoreCase("getConditions")){
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String condition_type = "";
			String site_type = "";
			String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
			String supernumerary_yn = "";
			String mixed_dent_deciduous_yn = "";
			String surface_code = "";
			String treatment_condition = "";
			String status = "";
			
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level")) ;
			String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id")) ;
			
			StringBuffer populateConditionsBuffer = new StringBuffer();

			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			if (oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM,SITE_TYPE,SUPERNUMERARY_YN,MIXED_DENT_DECIDUOUS_YN, SURFACE_CODE, TREATMENT_CONDITION, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS  FROM OH_RESTORATIVE_CHART_DTL A  WHERE PATIENT_ID = ?  AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND NVL (STATUS, 'X') != 'Z' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND CHART_LINE_NUM < ? ORDER BY CHART_NUM, CHART_LINE_NUM DESC");
				//pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
				pstmt.setString(4,chart_line_num);
			}else{
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM,SITE_TYPE,SUPERNUMERARY_YN,MIXED_DENT_DECIDUOUS_YN, SURFACE_CODE, TREATMENT_CONDITION, (SELECT E.ORDER_STATUS_TYPE FROM OR_ORDER_STATUS_CODE E WHERE E.ORDER_STATUS_CODE = A.STATUS) STATUS FROM OH_RESTORATIVE_CHART_DTL A  WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ?  AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND NVL (STATUS, 'X') != 'Z' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND CHART_LINE_NUM < ? ORDER BY CHART_NUM, CHART_LINE_NUM DESC");
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
				pstmt.setString(5,chart_line_num);
			}
			rst=pstmt.executeQuery();
			while(rst!=null && rst.next()){
				condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
				chart_line_num = checkForNull(rst.getString("CHART_LINE_NUM"));
				site_type = checkForNull(rst.getString("SITE_TYPE"));
				supernumerary_yn = checkForNull(rst.getString("SUPERNUMERARY_YN"));
				mixed_dent_deciduous_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));
				surface_code = checkForNull(rst.getString("SURFACE_CODE"));
				treatment_condition = checkForNull(rst.getString("TREATMENT_CONDITION"));
				status = checkForNull(rst.getString("STATUS"));
				populateConditionsBuffer.append(condition_type+"##"+chart_line_num+"##"+site_type+"##"+supernumerary_yn+"##"+mixed_dent_deciduous_yn+"##"+surface_code+"##"+treatment_condition+"##"+status);
				populateConditionsBuffer.append("~");
			}
			
			out.println(populateConditionsBuffer);
		 } else if(func_mode.equalsIgnoreCase("getExfoliationCase")){
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String condition_type = "";
			int chart_line_num = 0;
			String supernumerary_yn = "";
			
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level")) ;
			String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id")) ;
			
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			if (oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM, SUPERNUMERARY_YN FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ?  AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND NVL (STATUS, 'X') != 'Z' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND CONDITION_TYPE IN ('EXFOLTH') ORDER BY CHART_NUM, CHART_LINE_NUM DESC");
				//pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
			}else{
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM, SUPERNUMERARY_YN FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ?  AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL (STATUS, 'X') != 'E' AND NVL (STATUS, 'X') != 'Z' AND NVL (COND_CLOSED_YN, 'N') = 'N' AND CONDITION_TYPE IN ('EXFOLTH') ORDER BY CHART_NUM, CHART_LINE_NUM DESC");
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			}
			rst=pstmt.executeQuery();
			while(rst!=null && rst.next()){
				condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
				supernumerary_yn = checkForNull(rst.getString("SUPERNUMERARY_YN"));

				if(condition_type.equals("EXFOLTH") && supernumerary_yn.equals("Y")){
					chart_line_num = Integer.parseInt(checkForNull(rst.getString("CHART_LINE_NUM")));
				}
			}
			
			out.println(chart_line_num);
		 }else if(func_mode.equalsIgnoreCase("getAsOnChartStatus")){
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;

			String asOnDate = checkForNull(request.getParameter( "asOnDate" )) ;
	
			String asOnDate1 = checkForNull(com.ehis.util.DateUtils.convertDate(asOnDate, "DMY", locale, "en"));
			String chart_status = "";
			String chart_num = "";
			
			pstmt = con.prepareStatement("SELECT CHART_STATUS, CHART_NUM FROM  OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID=? AND CHART_NUM =  (SELECT MAX (CHART_NUM) FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ?  AND TO_DATE (?, 'DD/MM/YYYY') BETWEEN TRUNC (CHART_DATE) AND TRUNC(NVL (CHART_CLOSE_DATE,SYSDATE)))");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,asOnDate1);
					
			rst=pstmt.executeQuery();
			while(rst!=null && rst.next()){
				chart_status = checkForNull(rst.getString("CHART_STATUS"));
				chart_num = checkForNull(rst.getString("CHART_NUM"));
			}
			
			out.println(chart_status+"##"+chart_num);
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
%>
