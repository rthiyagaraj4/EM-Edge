<%@ page  import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet rst = null;
	ResultSet rst1 = null;
	String locale = (String)session.getAttribute("LOCALE"); 
	String tooth_numering_system = request.getParameter( "tooth_numering_system" ) ;
	String chart_code = request.getParameter( "chart_code" ) ;
	String chart_num = request.getParameter( "chart_num" ) ;
	String chart_line_num = request.getParameter( "chart_line_num" ) ;
	String patient_id = request.getParameter( "patient_id" ) ;

	String tooth_num="";
	String disp_tooth_num="";
	String component_desc="";
	String component_code="";
	
	
	//String SQL="SELECT DECODE(A.TOOTH_NO,'*ALL','All',(SELECT NS_TOOTH_NO FROM OH_PERIODONTAL_CHART_DEF_DTL2 A,OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE NUMBERING_SYSTEM=? AND A.TOOTH_NO=C.TOOTH_NO ) ) DISPLAY_TOOTH_NO, A.TOOTH_NO, A.COMPONENT_CODE,  B.COMPONENT_SHORT_DESC_USER_DEF FROM OH_PERIODONTAL_CHART_DEF_DTL2 A ,  OH_PERDONTAL_CHRT_COMP_LANG_VW B WHERE  B.LANGUAGE_ID = ? AND A.CHART_CODE = ? AND NVL(A.REQUIRED_YN,'N') = 'Y' AND A.COMPONENT_CODE = B.COMPONENT_CODE";
	
	//String SQL="SELECT X.TOOTH_NO, X.COMPONENT_CODE, Y.NS_TOOTH_NO DISPLAY_TOOTH_NO, Z.COMPONENT_SHORT_DESC_USER_DEF FROM (SELECT A.TOOTH_NO, A.COMPONENT_CODE   FROM OH_PERIODONTAL_CHART_DEF_DTL2 A   WHERE CHART_CODE = ?    AND REQUIRED_YN = 'Y'    AND TOOTH_NO <> '*A'  UNION SELECT TO_CHAR(B.TOOTH_NO) TOOTH_NO, A.COMPONENT_CODE   FROM OH_PERIODONTAL_CHART_DEF_DTL2 A, OH_TOOTH B  WHERE A.CHART_CODE = ?    AND A.TOOTH_NO   = '*A'    AND A.REQUIRED_YN = 'Y'  AND B.PERMANENT_DECIDUOUS = 'P') X, OH_TOOTH_BY_NUMBERING_SYSTEM Y, OH_PERDONTAL_CHRT_COMP_LANG_VW Z  WHERE X.TOOTH_NO  = Y.TOOTH_NO    AND Y.NUMBERING_SYSTEM  = ?  AND X.COMPONENT_CODE	  	 = Z.COMPONENT_CODE   AND Z.LANGUAGE_ID  = ?";

	String SQL="SELECT X.TOOTH_NO, X.COMPONENT_CODE, Y.NS_TOOTH_NO DISPLAY_TOOTH_NO, Z.COMPONENT_SHORT_DESC_USER_DEF FROM (SELECT A.TOOTH_NO, A.COMPONENT_CODE   FROM OH_PERIODONTAL_CHART_DEF_DTL2 A   WHERE CHART_CODE = ?    AND REQUIRED_YN = 'Y'    AND TOOTH_NO <> '*A'  UNION SELECT TO_CHAR(B.TOOTH_NO) TOOTH_NO, A.COMPONENT_CODE   FROM OH_PERIODONTAL_CHART_DEF_DTL2 A, OH_TOOTH B  WHERE A.CHART_CODE = ?    AND A.TOOTH_NO   = '*A'    AND A.REQUIRED_YN = 'Y'  AND B.PERMANENT_DECIDUOUS = 'P') X, OH_TOOTH_BY_NUMBERING_SYSTEM Y, OH_PERDONTAL_CHRT_COMP_LANG_VW Z  WHERE X.TOOTH_NO  = Y.TOOTH_NO    AND Y.NUMBERING_SYSTEM  = ?  AND X.COMPONENT_CODE	  	 = Z.COMPONENT_CODE   AND Z.LANGUAGE_ID  = ? ORDER BY X.COMPONENT_CODE";

	//String SQL1="SELECT TOOTH_NO, COMPONENT_CODE FROM OH_PERIODONTAL_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_CODE=? AND CHART_LINE_NUM =? AND TOOTH_NO=? AND COMPONENT_CODE=?";
	String SQL1="SELECT TOOTH_NO, COMPONENT_CODE FROM OH_PERIODONTAL_CHART_DTL WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_CODE=? AND CHART_LINE_NUM =? AND TOOTH_NO=? AND COMPONENT_CODE=?";

	StringBuilder sbr = new StringBuilder();
	int row_count=0;
	try{
		con = ConnectionManager.getConnection();
		pstmt = con.prepareStatement(SQL);
		pstmt1 = con.prepareStatement(SQL1);
		pstmt.setString(1,chart_code);
		pstmt.setString(2,chart_code);
		pstmt.setString(3,tooth_numering_system);
		pstmt.setString(4,locale);
		rst = pstmt.executeQuery();
		while(rst!= null && rst.next()){
			tooth_num =rst.getString(1);//"TOOTH_NO"
			component_code=rst.getString(2);//COMPONENT_CODE
			disp_tooth_num =rst.getString(3);//"DISPLAY_TOOTH_NO 
			component_desc=rst.getString(4);//COMPONENT_SHORT_DESC_USER_DEF
		
			pstmt1.setString(1, patient_id);
			pstmt1.setString(2, chart_num);
			pstmt1.setString(3, chart_code);
			pstmt1.setString(4, chart_line_num);
			pstmt1.setString(5, tooth_num);
			pstmt1.setString(6, component_code);
			rst1 = pstmt1.executeQuery();
			int i=0;
			while(rst1!= null && rst1.next()){
				i++;
			}
			if(i==0){
				if(row_count==0){
					sbr.append(component_desc).append(" - #").append(disp_tooth_num);
				}else{
					sbr.append(",");
					sbr.append(component_desc).append(" - #").append(disp_tooth_num);
				}
				row_count++;
			}
		}
		out.println(sbr.toString());
	}catch(Exception e){
		con.rollback();
		out.println("Err Msg from PerioMandatoryValidation.jsp "+e.getMessage());
	}
	finally{
		sbr.setLength(0);
		if(rst!=null) rst.close();
		if(rst1!=null) rst1.close();
		if(pstmt!=null)pstmt.close();
		if(pstmt1!=null)pstmt1.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>
