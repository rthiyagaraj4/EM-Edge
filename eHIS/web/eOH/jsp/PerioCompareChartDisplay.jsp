<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<HTML>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp" %>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eOH/js/PerioCompareChart.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eOH/js/OHCommon.js"></script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form name="PerioCompareChartDisplayForm" id="PerioCompareChartDisplayForm">
<table width="100%" cellpadding =0 cellspacing=1 border=1 id="myTable">
<%	
			String patient_id=checkForNull(request.getParameter("patient_id"));
			String chart_code=checkForNull(request.getParameter("chart_code"));
			String quadrant=checkForNull(request.getParameter("quadrant"));
			String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
			String permanent_deciduous_flag=checkForNull(request.getParameter("permanent_deciduous_flag"));
			String components=checkForNull(request.getParameter("components"));
			String eval_type=checkForNull(request.getParameter("eval_type"));
			String chart_compare=checkForNull(request.getParameter("chart_compare"));
			String qry_str = (components.length()>0)?"WHERE COMPONENT_CODE IN ("+components+")":"";
			String eval_chart_num1=checkForNull(request.getParameter("eval_chart_num1"));
			String eval_chart_num2=checkForNull(request.getParameter("eval_chart_num2"));
			String eval_chart_num3=checkForNull(request.getParameter("eval_chart_num3"));
			String selected_val1=checkForNull(request.getParameter("selected_val1"));
			String selected_val2=checkForNull(request.getParameter("selected_val2"));
			String selected_val3=checkForNull(request.getParameter("selected_val3"));
			String eval_chart_line_num1="";
			String eval_chart_line_num2="";
			String eval_chart_line_num3="";
			if(eval_type.equals("BB")){
					eval_chart_line_num1="1";
					eval_chart_line_num2="1";
					eval_chart_line_num3="1";
			}else{
				eval_chart_line_num1=checkForNull(request.getParameter("eval_chart_line_num1"));
				eval_chart_line_num2=checkForNull(request.getParameter("eval_chart_line_num2"));
				eval_chart_line_num3=checkForNull(request.getParameter("eval_chart_line_num3"));
			}
			//String qry_str1 = (components.length()>0)?"AND X.COMPONENT_CODE IN ("+components+")":"";
			StringBuilder  sbr= new StringBuilder();
			//sbr.append("'").append(eval_chart_line_num1).append("'").append(",");
			//sbr.append("'").append(eval_chart_line_num2).append("'");
			String cond="";
			String eval_chart_type1="";
			String eval_chart_type2="";
			String eval_chart_type3="";
			switch(quadrant.charAt(0)){
				case '1':
				case '2': cond = "U"; break;
				case '3':
				case '4':cond = "L"; break;
			}
			if(chart_compare.equals(2)){
				if("BE".equals(eval_type)){
					eval_chart_type1="BL";
					eval_chart_type2="EV";
				}else if("EE".equals(eval_type)){
					eval_chart_type1="EV1";
					eval_chart_type2="EV2";
				}else if("BB".equals(eval_type)){
					eval_chart_type1="BL1";
					eval_chart_type2="BL2";
				}
			}else if(chart_compare.equals(3)){
				if("BE".equals(eval_type)){
					eval_chart_type1="BL";
					eval_chart_type2="EV1";
					eval_chart_type3="EV2";
				}else if("EE".equals(eval_type)){
					eval_chart_type1="EV1";
					eval_chart_type2="EV2";
					eval_chart_type3="EV3";
				}else if("BB".equals(eval_type)){
					eval_chart_type1="BL1";
					eval_chart_type2="BL2";
					eval_chart_type3="BL3";
				}
			}
					
			String tooth_num			 =	 "";
			String S1					 =  "";
			String S2					 =  "";
			String S3					 =  "";
			String S4					 =  "";
			String S5					 =  "";
			String S6					 =  "";
			String val					 =  "";
			String component_code	 =  "";
			String component_desc	 =  "";
			String chart_date			 =  "";
			String row_color			 =  "";
			String display_tooth_str	 =  "";
			String surfaces_appl_yn	 =  "N";
			
			
			String tooth_str	 =  "";
			String[] tooth_str_arr	 = new String[8];
			String[] display_tooth_str_arr	 = new String[8];

			Connection con				= null;
			PreparedStatement pstmt  = null;
			PreparedStatement pstmt1  = null;
			ResultSet rs			        = null;
			ResultSet rs1		        = null;
			String next_row_flag		 =  "";
			String chart_line_num	 =  "";
			String comp_str			 =  "";
			String td_id					 =	 "";
			String line_seq="";
			String cut_off="";
			String SQL="";
			String sql_tooth = "SELECT B.NS_TOOTH_NO DISPLAY_TOOTH_NO, A.TOOTH_NO FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO=B.TOOTH_NO AND B.NUMBERING_SYSTEM=? AND A.PERMANENT_DECIDUOUS = ? AND A.ARCH_SNO = ?";


			/*String SQL="SELECT A.COMPONENT_CODE,D.COMPONENT_SHORT_DESC_USER_DEF,TO_CHAR(C.CHART_COMPLETED_DATE,'DD/MM')||DECODE(C.CHART_LINE_NUM,'"+eval_chart_line_num1+"','("+eval_chart_type1+")','"+eval_chart_line_num2+"','("+eval_chart_type2+")'),A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,C.CHART_LINE_NUM, D.SURFACES_APPL_YN,DECODE(C.CHART_LINE_NUM,'"+eval_chart_line_num1+"','CAGREENSMALL','"+eval_chart_line_num2+"','QRYEVENSMALL')   FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C, OH_PERDONTAL_CHRT_COMP_LANG_VW D, OH_TOOTH_BY_NUMBERING_SYSTEM E WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM =  C.CHART_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_CODE = ?  AND A.CHART_NUM = ? AND C.CHART_LINE_NUM IN("+sbr.toString()+") AND D.LANGUAGE_ID=? AND  E.QUADRANT_SNO IN ("+cond+") AND E.NUMBERING_SYSTEM = ? AND E.TOOTH_NO = A.TOOTH_NO AND D.COMPONENT_CODE=A.COMPONENT_CODE AND D.FORMULA_YN='N' AND B.CHART_STATUS NOT IN ('ME') "+qry_str+" ORDER BY NVL(D.SURFACES_APPL_YN,'N') ASC, D.COMPONENT_SHORT_DESC_USER_DEF,C.CHART_LINE_NUM";*/
			
			//SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, VALUE, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ FROM

			//String SQL="SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, VALUE, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ FROM ( SELECT D.COMPONENT_CODE, D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'CAGREENSMALL' LINE_COLOR, 1 LINE_SEQ FROM OH_PERIODONTAL_CHART_DTL A, (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO FROM OH_PERDONTAL_CHRT_COMP_LANG_VW X,OH_TOOTH Y WHERE X.FORMULA_YN = 'N' AND X.LANGUAGE_ID	 =? AND Y.PERMANENT_DECIDUOUS = ? AND Y.ARCH_SNO = ? "+qry_str1+") D  WHERE A.OPERATING_FACILITY_ID(+)=?  AND A.PATIENT_ID(+) =?  AND A.CHART_CODE(+) =?  AND A.CHART_NUM(+)	=? AND A.CHART_LINE_NUM(+) =? 	AND A.TOOTH_NO (+)  = D.TOOTH_NO AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE  UNION  SELECT D.COMPONENT_CODE,D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'QRYEVENSMALL' LINE_COLOR, 2 LINE_SEQ FROM OH_PERIODONTAL_CHART_DTL A, (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO FROM OH_PERDONTAL_CHRT_COMP_LANG_VW X,OH_TOOTH Y WHERE X.FORMULA_YN = 'N' AND X.LANGUAGE_ID	 = ? AND Y.PERMANENT_DECIDUOUS = ? AND Y.ARCH_SNO = ? "+qry_str1+") D  WHERE A.OPERATING_FACILITY_ID(+)=?  AND A.PATIENT_ID(+) =?  AND A.CHART_CODE(+) =?  AND A.CHART_NUM(+)=? AND A.CHART_LINE_NUM(+) =? 	AND A.TOOTH_NO (+)  = D.TOOTH_NO AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE ) ORDER BY SURFACES_APPL_YN ASC, COMPONENT_SHORT_DESC_USER_DEF, LINE_SEQ";

			//String SQL="SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, VALUE, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ FROM ( 	   SELECT D.COMPONENT_CODE, D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'CAGREENSMALL' LINE_COLOR, 1 LINE_SEQ FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO 	   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.OPERATING_FACILITY_ID(+)=?  AND A.PATIENT_ID(+) =? 	   AND A.CHART_CODE(+) =?   AND A.CHART_NUM(+)	=?  AND A.CHART_LINE_NUM(+) =?  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE  UNION SELECT D.COMPONENT_CODE,D.COMPONENT_SHORT_DESC_USER_DEF,	   D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'DISPDATE' LINE_COLOR, 2 LINE_SEQ 	   FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO 	   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.OPERATING_FACILITY_ID(+)=? AND A.PATIENT_ID(+) =? AND A.CHART_CODE(+) =? AND A.CHART_NUM(+)=? AND A.CHART_LINE_NUM(+) =? 	   AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE ) 	   "+qry_str+" ORDER BY SURFACES_APPL_YN ASC, COMPONENT_SHORT_DESC_USER_DEF, LINE_SEQ";
			
			//Commented by Parul for CRf #0423
			//String SQL="SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, VALUE, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ, EVAL_CHART_LINE_NUM FROM ( 	   SELECT D.COMPONENT_CODE, D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'CAGREENSMALL' LINE_COLOR, 1 LINE_SEQ, ? EVAL_CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.OPERATING_FACILITY_ID(+)=?  AND A.PATIENT_ID(+) =? 	   AND A.CHART_CODE(+) =?   AND A.CHART_NUM(+)	=?  AND A.CHART_LINE_NUM(+) =?  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE  UNION SELECT D.COMPONENT_CODE,D.COMPONENT_SHORT_DESC_USER_DEF,	   D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'DISPDATE' LINE_COLOR, 2 LINE_SEQ, ? EVAL_CHART_LINE_NUM  FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO 	   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.OPERATING_FACILITY_ID(+)=? AND A.PATIENT_ID(+) =? AND A.CHART_CODE(+) =? AND A.CHART_NUM(+)=? AND A.CHART_LINE_NUM(+) =? 	   AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE ) 	   "+qry_str+" ORDER BY SURFACES_APPL_YN ASC, COMPONENT_SHORT_DESC_USER_DEF, LINE_SEQ DESC";
			//String SQL="SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, VALUE, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ, EVAL_CHART_LINE_NUM FROM ( 	   SELECT D.COMPONENT_CODE, D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'CAGREENSMALL' LINE_COLOR, 1 LINE_SEQ, ? EVAL_CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.OPERATING_FACILITY_ID(+)=?  AND A.PATIENT_ID(+) =? 	   AND A.CHART_CODE(+) =?   AND A.CHART_NUM(+)	=?  AND A.CHART_LINE_NUM(+) =?  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE  UNION SELECT D.COMPONENT_CODE,D.COMPONENT_SHORT_DESC_USER_DEF,	   D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'DISPDATE' LINE_COLOR, 2 LINE_SEQ, ? EVAL_CHART_LINE_NUM  FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO 	   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.PATIENT_ID(+) =? AND A.CHART_CODE(+) =? AND A.CHART_NUM(+)=? AND A.CHART_LINE_NUM(+) =? 	   AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE ) 	   "+qry_str+" ORDER BY SURFACES_APPL_YN ASC, COMPONENT_SHORT_DESC_USER_DEF, LINE_SEQ DESC";
			//String SQL="SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, VALUE, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ, EVAL_CHART_LINE_NUM FROM ( 	   SELECT D.COMPONENT_CODE, D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'CAGREENSMALL' LINE_COLOR, 1 LINE_SEQ, ? EVAL_CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.PATIENT_ID(+) =? 	   AND A.CHART_CODE(+) =?   AND A.CHART_NUM(+)	=?  AND A.CHART_LINE_NUM(+) =?  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE  UNION SELECT D.COMPONENT_CODE,D.COMPONENT_SHORT_DESC_USER_DEF,	   D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'DISPDATE' LINE_COLOR, 2 LINE_SEQ, ? EVAL_CHART_LINE_NUM  FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO 	   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.PATIENT_ID(+) =? AND A.CHART_CODE(+) =? AND A.CHART_NUM(+)=? AND A.CHART_LINE_NUM(+) =? 	   AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE ) 	   "+qry_str+" ORDER BY SURFACES_APPL_YN ASC, COMPONENT_SHORT_DESC_USER_DEF, LINE_SEQ DESC";
			if(chart_compare.equals("2")){
				SQL="SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, VALUE, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ, EVAL_CHART_LINE_NUM FROM ( 	   SELECT D.COMPONENT_CODE, D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'OHCOMPAREBASE' LINE_COLOR, 1 LINE_SEQ, ? EVAL_CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.PATIENT_ID(+) =? 	   AND A.CHART_CODE(+) =?   AND A.CHART_NUM(+)	=?  AND A.CHART_LINE_NUM(+) =?  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE  UNION SELECT D.COMPONENT_CODE,D.COMPONENT_SHORT_DESC_USER_DEF,	   D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'OHCOMPAREEVAL1' LINE_COLOR, 2 LINE_SEQ, ? EVAL_CHART_LINE_NUM  FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO 	   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.PATIENT_ID(+) =? AND A.CHART_CODE(+) =? AND A.CHART_NUM(+)=? AND A.CHART_LINE_NUM(+) =? 	   AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE ) 	   "+qry_str+" ORDER BY SURFACES_APPL_YN ASC, COMPONENT_SHORT_DESC_USER_DEF, LINE_SEQ DESC";
			}else if(chart_compare.equals("3")){
				SQL="SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, VALUE, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ, EVAL_CHART_LINE_NUM FROM ( 	   SELECT D.COMPONENT_CODE, D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'OHCOMPAREBASE' LINE_COLOR, 1 LINE_SEQ, ? EVAL_CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.PATIENT_ID(+) =? 	   AND A.CHART_CODE(+) =?   AND A.CHART_NUM(+)	=?  AND A.CHART_LINE_NUM(+) =?  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE  UNION SELECT D.COMPONENT_CODE,D.COMPONENT_SHORT_DESC_USER_DEF,	   D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'OHCOMPAREEVAL1' LINE_COLOR, 2 LINE_SEQ, ? EVAL_CHART_LINE_NUM  FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO 	   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.PATIENT_ID(+) =? AND A.CHART_CODE(+) =? AND A.CHART_NUM(+)=? AND A.CHART_LINE_NUM(+) =? 	   AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE UNION SELECT D.COMPONENT_CODE,D.COMPONENT_SHORT_DESC_USER_DEF,	   D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'OHCOMPAREEVAL2' LINE_COLOR, 3 LINE_SEQ, ? EVAL_CHART_LINE_NUM  FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO 	   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.PATIENT_ID(+) =? AND A.CHART_CODE(+) =? AND A.CHART_NUM(+)=? AND A.CHART_LINE_NUM(+) =? 	   AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE) 	   "+qry_str+" ORDER BY SURFACES_APPL_YN ASC, COMPONENT_SHORT_DESC_USER_DEF, LINE_SEQ ";
			}
			
			con=ConnectionManager.getConnection(request);
			int tooth_cnt=0;
			try{
			pstmt = con.prepareStatement(sql_tooth);
			pstmt.setString(1,tooth_numbering_system);
			pstmt.setString(2,permanent_deciduous_flag);
			pstmt.setString(3,cond);
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(tooth_cnt == 0){
					tooth_str = rs.getString("TOOTH_NO");
					display_tooth_str = rs.getString("DISPLAY_TOOTH_NO");
				}else{
					tooth_str = tooth_str + "," +rs.getString("TOOTH_NO");
					display_tooth_str = display_tooth_str + "," +rs.getString("DISPLAY_TOOTH_NO");
				}
			tooth_cnt++;
			}

			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			}catch(Exception e){
				System.err.println("Err Mesg From perioCompareChartDisplay"+e.getMessage());
			}
	%>
	<tr>
		<td class="COLUMNHEADERCENTER" width="15%"><fmt:message key="Common.Component.label" bundle="${common_labels}"/></td>
		<td class="COLUMNHEADERCENTER" width="12%"><fmt:message key="Common.Chart.label" bundle="${common_labels}"/></td>
		<%
				tooth_str_arr = tooth_str.split(",");
				display_tooth_str_arr = display_tooth_str.split(",");
		
			if(cond.equals("U")){
				for(int j=0;j<tooth_cnt;j++){
		%>
				<td id="<%=tooth_str_arr[j]%>" class="COLUMNHEADERCENTER" width="3%"><%=display_tooth_str_arr[j]%></td>
		<%}
		}else
		{
		for(int j=tooth_cnt-1;j>=0;j--){
		%>
				<td id="<%=tooth_str_arr[j]%>" class="COLUMNHEADERCENTER" width="3%"><%=display_tooth_str_arr[j]%></td>
		<%}
		}
		%>
	</tr>

	<%
		try{

					pstmt=con.prepareStatement(SQL);
					if(chart_compare.equals("2")){
						pstmt.setString(1,eval_chart_line_num1);
						pstmt.setString(2,chart_code);
						pstmt.setString(3,locale);
						pstmt.setString(4,cond );
						pstmt.setString(5,patient_id);
						pstmt.setString(6,chart_code);
						pstmt.setString(7,eval_chart_num1);
						pstmt.setString(8,eval_chart_line_num1);
						pstmt.setString(9,eval_chart_line_num2);
						pstmt.setString(10,chart_code);
						pstmt.setString(11,locale);
						pstmt.setString(12,cond );
						pstmt.setString(13,patient_id);
						pstmt.setString(14,chart_code);
						pstmt.setString(15,eval_chart_num2);
						pstmt.setString(16,eval_chart_line_num2);
					}else if(chart_compare.equals("3")){
						pstmt.setString(1,eval_chart_line_num1);
						pstmt.setString(2,chart_code);
						pstmt.setString(3,locale);
						pstmt.setString(4,cond );
						pstmt.setString(5,patient_id);
						pstmt.setString(6,chart_code);
						pstmt.setString(7,eval_chart_num1);
						pstmt.setString(8,eval_chart_line_num1);
						pstmt.setString(9,eval_chart_line_num2);
						pstmt.setString(10,chart_code);
						pstmt.setString(11,locale);
						pstmt.setString(12,cond );
						pstmt.setString(13,patient_id);
						pstmt.setString(14,chart_code);
						pstmt.setString(15,eval_chart_num2);
						pstmt.setString(16,eval_chart_line_num2);
						pstmt.setString(17,eval_chart_line_num3);
						pstmt.setString(18,chart_code);
						pstmt.setString(19,locale);
						pstmt.setString(20,cond );
						pstmt.setString(21,patient_id);
						pstmt.setString(22,chart_code);
						pstmt.setString(23,eval_chart_num3);
						pstmt.setString(24,eval_chart_line_num3);
					}
					rs=pstmt.executeQuery();
					int k=0;
					while(rs.next()){
							++k;
							next_row_flag = (comp_str.equals( rs.getString(1)+"#"+rs.getString(13)) )?"N":"Y";
							component_code	 =  rs.getString(1);//component code
							component_desc	 =  rs.getString(2);//component desc
							tooth_num			 =  rs.getString(3);//tooth number
							S1				 =  checkForNull(rs.getString(4),"&nbsp;");//surface-1     
							S2				 =  checkForNull(rs.getString(5),"&nbsp;");//surface-2     
							S3				 =  checkForNull(rs.getString(6),"&nbsp;");//surface-3     
							S4				 =  checkForNull(rs.getString(7),"&nbsp;");//surface-4     
							S5				 =  checkForNull(rs.getString(8),"&nbsp;");//surface-5     
							S6				 =  checkForNull(rs.getString(9),"&nbsp;");//surface-6     
							val				 =  checkForNull(rs.getString(10));//val
							surfaces_appl_yn =  rs.getString(11);//val
							row_color =  rs.getString(12);//val
							line_seq =  rs.getString(13);//val
							chart_line_num =  rs.getString(14);//chart_line_num
							if(chart_compare.equals("2")){
								if("BE".equals(eval_type)){
									chart_date	= ("1".equals(line_seq))?selected_val1:selected_val2;//chart_date
								}else if("EE".equals(eval_type)){
									chart_date	= ("1".equals(line_seq))?selected_val1:selected_val2;//chart_date
								}else if("BB".equals(eval_type)){
									chart_date	= ("1".equals(line_seq))?selected_val1:selected_val2;//chart_date
								}
							}else if(chart_compare.equals("3")){
								if("BE".equals(eval_type)){
									//chart_date= ("1".equals(line_seq))?eval_chart_date1+"(BL)":eval_chart_date2+"(EV)";//chart_date
									if("1".equals(line_seq)){
										chart_date = selected_val1;
									}else if("2".equals(line_seq)){
										chart_date = selected_val2;
									}else if("3".equals(line_seq)){
										chart_date = selected_val3;
									}
								}else if("EE".equals(eval_type)){
									//chart_date= ("1".equals(line_seq))?eval_chart_date1+"(EV1)":eval_chart_date2+"(EV2)";//chart_date
									if("1".equals(line_seq)){
										chart_date = selected_val1;
									}else if("2".equals(line_seq)){
										chart_date = selected_val2;
									}else if("3".equals(line_seq)){
										chart_date = selected_val3;
									}
								}else if("BB".equals(eval_type)){
									//chart_date = ("1".equals(line_seq))?eval_chart_date1+"(BL1)":eval_chart_date2+"(BL2)";//chart_date
									if("1".equals(line_seq)){
										chart_date = selected_val1;
									}else if("2".equals(line_seq)){
										chart_date = selected_val2;
									}else if("3".equals(line_seq)){
										chart_date = selected_val3;
									}
								}
							}
							sbr.setLength(0);

							String SQL1="SELECT B.CUT_OFF FROM OH_PERIODONTAL_CHART_COMP A,OH_PERIODONTAL_CHART_DEF_DTL B WHERE  A.COMPONENT_CODE=B.COMPONENT_CODE AND  B.CHART_CODE = ? and B.COMPONENT_CODE=? ";
							pstmt1=con.prepareStatement(SQL1);
							pstmt1.setString(1,chart_code);
							pstmt1.setString(2,component_code);
							rs1 = pstmt1.executeQuery();
							while(rs1.next()){
							cut_off = checkForNull(rs1.getString("CUT_OFF"));
							}
						if("Y".equals(surfaces_appl_yn)){
							if("1".equals(quadrant) || "4".equals(quadrant)){
									sbr.append("<table width=100% cellpadding =1 cellspacing=1 border=0>");
											sbr.append("<tr>");
									if(S1.equals("&nbsp;")){
										if(S1.compareTo(cut_off) >= 0){
												sbr.append("<td class="+row_color+" nowrap>").append(S1).append("</td>");
											}
										}else{
											if(Integer.parseInt(S1) >= Integer.parseInt(cut_off)) {										
												sbr.append("<td class="+row_color+" nowrap>").append("<font color=red>"+S1+"</font>").append("</td>");
											}else{
												sbr.append("<td class="+row_color+" nowrap>").append(S1).append("</td>");
											}								
										}

									if(S2.equals("&nbsp;")){
										if(S2.compareTo(cut_off) >= 0){
												sbr.append("<td class="+row_color+" nowrap>").append(S2).append("</td>");
											}
										}else{
											if(Integer.parseInt(S2) >= Integer.parseInt(cut_off)) {										
												sbr.append("<td class="+row_color+" nowrap>").append("<font color=red>"+S2+"</font>").append("</td>");
											}else{
												sbr.append("<td class="+row_color+" nowrap>").append(S2).append("</td>");
											}								
										}
								  if(S3.equals("&nbsp;")){
										if(S3.compareTo(cut_off) >= 0){
											sbr.append("<td class="+row_color+" nowrap>").append(S3).append("</td>");
											}
										}else{
											if(Integer.parseInt(S3) >= Integer.parseInt(cut_off)) {										
												sbr.append("<td class="+row_color+" nowrap>").append("<font color=red>"+S3+"</font>").append("</td>");
											}else{
												sbr.append("<td class="+row_color+" nowrap>").append(S3).append("</td>");
											}								
										}
								sbr.append("</tr>");
								sbr.append("</table>");
						}else{
							sbr.append("<table width=100% cellpadding =1 cellspacing=1 border=0>");
							sbr.append("<tr>");
							 if(S4.equals("&nbsp;")){
								if(S4.compareTo(cut_off) >= 0){
									sbr.append("<td class="+row_color+" nowrap>").append(S4).append("</td>");
									}
								}else{
									if(Integer.parseInt(S4) >= Integer.parseInt(cut_off)) {										
										sbr.append("<td class="+row_color+" nowrap>").append("<font color=red>"+S4+"</font>").append("</td>");
									}else{
										sbr.append("<td class="+row_color+" nowrap>").append(S4).append("</td>");
									}								
								}
							if(S5.equals("&nbsp;")){
								if(S5.compareTo(cut_off) >= 0){
									sbr.append("<td class="+row_color+" nowrap>").append(S5).append("</td>");
									}
								}else{
									if(Integer.parseInt(S5) >= Integer.parseInt(cut_off)) {										
										sbr.append("<td class="+row_color+" nowrap>").append("<font color=red>"+S5+"</font>").append("</td>");
									}else{
										sbr.append("<td class="+row_color+" nowrap>").append(S5).append("</td>");
									}								
								}
							if(S6.equals("&nbsp;")){
								if(S6.compareTo(cut_off) >= 0){
									sbr.append("<td class="+row_color+" nowrap>").append(S6).append("</td>");
									}
								}else{
									if(Integer.parseInt(S6) >= Integer.parseInt(cut_off)) {										
										sbr.append("<td class="+row_color+" nowrap>").append("<font color=red>"+S6+"</font>").append("</td>");
									}else{
										sbr.append("<td class="+row_color+" nowrap>").append(S6).append("</td>");
									}								
								}

									/*sbr.append("<td class="+row_color+" nowrap color>").append(S4).append("</td>");
									sbr.append("<td class="+row_color+" nowrap>").append(S5).append("</td>");
									sbr.append("<td class="+row_color+" nowrap>").append(S6).append("</td>");*/
						
									sbr.append("</tr>");
									sbr.append("</table>");
								}

							}	

							sbr.append(val);
							comp_str = component_code+"#"+ rs.getString(13);
							if("Y".equals(next_row_flag) ) {
								out.println("<tr>");
								//if("1".equals(line_seq) )
								if(chart_compare.equals("3")){
								if(chart_line_num.equals(eval_chart_line_num1) ){
									out.println("<td  class='"+row_color+"' >"+component_desc+"</td>");
								}else{
									out.println("<td  class='"+row_color+"' >&nbsp;</td>");
								}
									out.println("<td  class='"+row_color+"' nowrap>"+chart_date+"</td>");
									tooth_str_arr = tooth_str.split(",");
								}else  if(chart_compare.equals("2")){
								if(chart_line_num.equals(eval_chart_line_num2) ){
									out.println("<td  class='"+row_color+"' >"+component_desc+"</td>");
								}else{
									out.println("<td  class='"+row_color+"' >&nbsp;</td>");
								}
									out.println("<td  class='"+row_color+"' nowrap>"+chart_date+"</td>");
									tooth_str_arr = tooth_str.split(",");
								}
							
								if(cond.equals("U")){
								for(int j=0;j<tooth_str_arr.length;j++){
										td_id =line_seq+component_code+tooth_str_arr[j] ;
									if(tooth_str_arr[j].equals(tooth_num) ){
										//out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center >"+sbr.toString()+"</td>");
										if(surfaces_appl_yn.equals("N")){
											if(val.compareTo(cut_off)>=0){
												out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center ><font color=red>"+val+"</font></td>");
											}else{
												out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center >"+val+"</td>");
											}
										}else{
											out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center >"+sbr.toString()+"</td>");
										}
									}else{
										out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center>&nbsp;</td>");
									}
							}
							}else if(cond.equals("L"))
								{
					
								for(int j=tooth_str_arr.length-1;j>=0;j--){
								
										td_id =line_seq+component_code+tooth_str_arr[j] ;
									if(tooth_str_arr[j].equals(tooth_num) ){
										//out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center >"+sbr.toString()+"</td>");
										if(surfaces_appl_yn.equals("N")){
											if(val.compareTo(cut_off)>=0){
												out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center ><font color=red>"+val+"</font></td>");
											}else{
												out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center >"+val+"</td>");
											}
										}else{
											out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center >"+sbr.toString()+"</td>");
										}
									}else{
										out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center>&nbsp;</td>");
									}
							}
							}
								out.println("</tr>");
								if(line_seq.equals("3")){
									out.println("<tr></tr><tr></tr>");
								}

						}else{
								
								if(cond.equals("U")){
								for(int j=0;j<tooth_str_arr.length;j++){
									td_id =line_seq+component_code+tooth_str_arr[j] ;
									if(tooth_str_arr[j].equals(tooth_num) )
										out.println("<SCRIPT>assignValueToCell('"+td_id+"','"+sbr.toString()+"','"+cut_off+"');</SCRIPT>");
								}
								}
								else if(cond.equals("L"))
								{
									for(int j=tooth_str_arr.length-1;j>=0;j--){
									td_id =line_seq+component_code+tooth_str_arr[j] ;
									if(tooth_str_arr[j].equals(tooth_num) )
										out.println("<SCRIPT>assignValueToCell('"+td_id+"','"+sbr.toString()+"','"+cut_off+"');</SCRIPT>");
								}
								}
								
					}
						sbr.setLength(0);
				}//end of while 
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Err Mesg From PerioCompareChartDisplay.jsp"+e);
		}finally{
			try{
				if(rs!=null) rs.close();
				if(rs1!=null) rs1.close();
				if(pstmt!=null) pstmt.close();
				if(pstmt1!=null) pstmt1.close();
				if(con!=null) con.close();
			}catch(Exception es){}
		}
		
%>

