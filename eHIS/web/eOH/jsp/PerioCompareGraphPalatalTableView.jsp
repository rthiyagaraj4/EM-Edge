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
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eOH/js/OHCommon.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script>
function assignValueToCell(td_id,val){
	document.getElementById(td_id).innerHTML=val;
}
</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form name="PerioCompareChartDisplayForm" id="PerioCompareChartDisplayForm">
<table width="83%" cellpadding =0 cellspacing=2 border=1 id="myTable">
<%	
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String chart_num=checkForNull(request.getParameter("chart_num1"));
	String chart_num2=checkForNull(request.getParameter("chart_num2"));
	String chart_num3=checkForNull(request.getParameter("chart_num3"));
	String chart_line_num="";
	String chart_line_num2="";
	String chart_line_num3="";
	String chart_code=checkForNull(request.getParameter("chart_code"));
	String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag=checkForNull(request.getParameter("permanent_deciduous_flag"));
	String component_code=checkForNull(request.getParameter("components"));
	String surfface_appl_yn=checkForNull(request.getParameter("surfface_appl_yn"));
	StringBuilder  sbr= new StringBuilder();
	String perio_arch=checkForNull(request.getParameter("perio_arch"));
	String eval_type=checkForNull(request.getParameter("eval_type"));
	String eval_chart_date1=checkForNull(request.getParameter("eval_chart_date1"));
	String eval_chart_date2=checkForNull(request.getParameter("eval_chart_date2"));
	String no_of_charts=checkForNull(request.getParameter("no_of_charts"));
	if(eval_type.equals("BB")){
		chart_line_num="1";
		chart_line_num2="1";
		chart_line_num3="1";
	}else{
		chart_line_num=checkForNull(request.getParameter("chart_line_num1"));
		chart_line_num2=checkForNull(request.getParameter("chart_line_num2"));
		chart_line_num3=checkForNull(request.getParameter("chart_line_num3"));
	}
	
			String tooth_num			 =	 "";
			String S1					 =  "";
			String S2					 =  "";
			String S3					 =  "";
			String S4					 =  "";
			String S5					 =  "";
			String S6					 =  "";
			String comp_code		=  "";
			String component_desc		=  "";
			String chart_date			 =  "";
			String row_color			 =  "";
			String display_tooth_str	 =  "";
			String surfaces_appl_yn		=  "N";
					
			String tooth_str	 =  "";
			String[] tooth_str_arr	 = new String[8];
			String[] display_tooth_str_arr	 = new String[8];

			Connection con				= null;
			PreparedStatement pstmt  = null;
			PreparedStatement pstmt1  = null;
			ResultSet rs			        = null;
			ResultSet rs1			        = null;

			String next_row_flag		 =  "";
			String comp_str			 =  "";
			String td_id					 =	 "";
			String line_seq="";
			String cut_off="";

			String sql_tooth = "SELECT B.NS_TOOTH_NO DISPLAY_TOOTH_NO, A.TOOTH_NO FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO=B.TOOTH_NO AND B.NUMBERING_SYSTEM=? AND A.PERMANENT_DECIDUOUS = ? AND A.ARCH_SNO = ?";

			con=ConnectionManager.getConnection(request);
			
			int tooth_cnt=0;
			try{
			pstmt = con.prepareStatement(sql_tooth);
			pstmt.setString(1,tooth_numbering_system);
			pstmt.setString(2,permanent_deciduous_flag);
			pstmt.setString(3,perio_arch);
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
				System.err.println("Err Mesg From PerioCompareGraphPalatalTableVIew.jsp");
			}
	%>
	<tr>
<%
if(surfface_appl_yn.equals("Y")){
	%>
		<td class="COLUMNHEADERCENTER" width="5%"><fmt:message key='eOH.Lingual.Label' bundle='${oh_labels}'/></td>
<%	}%>

		<td class="COLUMNHEADERCENTER" width="6%"><fmt:message key="Common.Chart.label" bundle="${common_labels}"/></td>
		<%
				tooth_str_arr = tooth_str.split(",");
				display_tooth_str_arr = display_tooth_str.split(",");
				if(perio_arch.equals("L")){
				//for(int j=0;j<tooth_cnt;j++){
				for(int j=tooth_cnt-1;j>=0;j--){
				%>
				<td id="<%=tooth_str_arr[j]%>" class="COLUMNHEADERCENTER" width="3%"><%=display_tooth_str_arr[j]%></td>
				<%}
		}else{
				for(int j=0;j<tooth_cnt;j++){
				%>
				<td id="<%=tooth_str_arr[j]%>" class="COLUMNHEADERCENTER" width="3%"><%=display_tooth_str_arr[j]%></td>
				<%}
		}
		%>
	</tr>

	<%
		try{
			String sql="";
			 String sql1="select COMPONENT_SHORT_DESC_USER_DEF from OH_PERDONTAL_CHRT_COMP_LANG_VW where COMPONENT_CODE=?  and language_id=?";
			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1,component_code);
			pstmt.setString(2,locale);
			rs=pstmt.executeQuery();
			while(rs.next()){
					component_desc	 =  rs.getString(1);//component code
			}
	if(component_code.equals("N")){
	

	sql="SELECT COMPONENT_CODE,TOOTH_NO, VALUE ,SURFACES_APPL_YN, LINE_COLOR,LINE_SEQ FROM (SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.VALUE,D.SURFACES_APPL_YN,'QRYODD' LINE_COLOR,1 LINE_SEQ 		FROM OH_PERIODONTAL_CHART_DTL A,		(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 			 FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y			 WHERE Z.CHART_CODE = ? 			 AND X.LANGUAGE_ID = ? 			 AND Y.PERMANENT_DECIDUOUS = 'P'	  			 AND Y.ARCH_SNO = ? 			 AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  		WHERE  A.PATIENT_ID(+) =?	   	  		AND A.CHART_CODE(+) =?	 		AND A.CHART_NUM(+)  =?	 		AND A.CHART_LINE_NUM(+) =?	  		AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   	 		AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE	  		UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.VALUE,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,2 LINE_SEQ      		FROM OH_PERIODONTAL_CHART_DTL A,(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 		FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y    		WHERE Z.CHART_CODE = ?		  		AND X.LANGUAGE_ID =?		    		AND Y.PERMANENT_DECIDUOUS = 'P'		  		AND Y.ARCH_SNO =?		    		AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		  WHERE  A.PATIENT_ID(+) =?	   		  AND A.CHART_CODE(+) =?		  AND A.CHART_NUM(+)  =?		    AND A.CHART_LINE_NUM(+) =?		  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		    AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE )  		  WHERE COMPONENT_CODE =?		    ORDER BY LINE_SEQ,COMPONENT_CODE,TOOTH_NO";
				pstmt=con.prepareStatement(sql);
		pstmt.setString(1,chart_code);
		pstmt.setString(2,locale);
		pstmt.setString(3,perio_arch);
		pstmt.setString(4,patient_id);
		pstmt.setString(5,chart_code);
		pstmt.setString(6,chart_num);
		pstmt.setString(7,chart_line_num);
		pstmt.setString(8,chart_code);
		pstmt.setString(9,locale);
		pstmt.setString(10,perio_arch);
		pstmt.setString(11,patient_id);
		pstmt.setString(12,chart_code);
		pstmt.setString(13,chart_num2);
		pstmt.setString(14,chart_line_num2);
		pstmt.setString(15,component_code);
		rs=pstmt.executeQuery();

		int k=0;
		while(rs.next()){
						++k;
							next_row_flag = (comp_str.equals( rs.getString("COMPONENT_CODE")+"#"+rs.getString("LINE_SEQ")) )?"N":"Y";
							comp_code	 =  rs.getString("COMPONENT_CODE");//component code
							tooth_num			 =  rs.getString("TOOTH_NO");//tooth number
							S1				 =  checkForNull(rs.getString("VALUE"),"&nbsp;");//surface-1   
							//chart_line_num =  rs.getString(12);//val
							surfaces_appl_yn =  rs.getString("SURFACES_APPL_YN");//val
							row_color =  rs.getString("LINE_COLOR");//val 
							line_seq =  rs.getString("LINE_SEQ");//val
						if("BE".equals(eval_type)){
								chart_date			 = ("1".equals(line_seq))?eval_chart_date1+"(BL)":eval_chart_date1+"(EV)";//chart_date
							}else if("EE".equals(eval_type)){
								chart_date			 = ("1".equals(line_seq))?eval_chart_date1+"(EV1)":eval_chart_date2+"(EV2)";//chart_date
							}else if("BB".equals(eval_type)){
								chart_date			 = ("1".equals(line_seq))?eval_chart_date1+"(BL1)":eval_chart_date2+"(BL2)";//chart_date
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
							if("N".equals(surfaces_appl_yn)){
									sbr.append("<table width=100% cellpadding =0 cellspacing=1 border=1>");
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
									sbr.append("</tr>");
									sbr.append("</table>");
								
							}	
							comp_str = component_code+"#"+ rs.getString("LINE_SEQ");
							if("Y".equals(next_row_flag) ) {
								out.println("<tr>");
								if("1".equals(line_seq) ){
									//	out.println("<td  class='"+row_color+"' >"+component_code+"</td>");
										out.println("<td  class='"+row_color+"' >"+component_desc+"</td>");
								}else{
									out.println("<td  class='"+row_color+"' >&nbsp;</td>");
								}
									out.println("<td  class='"+row_color+"' nowrap>"+chart_date+"</td>");
									tooth_str_arr = tooth_str.split(",");
									for(int j=0;j<tooth_str_arr.length;j++){
										td_id =line_seq+component_code+tooth_str_arr[j] ;
										if(tooth_str_arr[j].equals(tooth_num) ){
											out.println("<td class='"+row_color+"' id="+td_id+" style=text-align:center >"+sbr.toString()+"</td>");
										}else{
											out.println("<td class='"+row_color+"' id="+td_id+" style=text-align:center>&nbsp;&nbsp;</td>");
										}
									}//for
								out.println("</tr>");
							}else{
							for(int j=0;j<tooth_str_arr.length;j++){
								td_id =line_seq+component_code+tooth_str_arr[j] ;
									if(tooth_str_arr[j].equals(tooth_num) )
									out.println("<SCRIPT>assignValueToCell('"+td_id+"','"+sbr.toString()+"','"+cut_off+"');</SCRIPT>");
								}
						}
						sbr.setLength(0);
				}//end of while
		}else{
	if(no_of_charts.equals("2")){	
		sql="SELECT COMPONENT_CODE,TOOTH_NO, S1, S2, S3, S4, S5, S6,SURFACES_APPL_YN, LINE_COLOR,LINE_SEQ FROM (SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6 ,D.SURFACES_APPL_YN,'QRYODD' LINE_COLOR,1 LINE_SEQ FROM OH_PERIODONTAL_CHART_DTL A, 	   	(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	  	FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	  WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	  AND Y.PERMANENT_DECIDUOUS = 'P'	 AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D	 WHERE A.PATIENT_ID(+) =?	   	 AND A.CHART_CODE(+) =?	AND A.CHART_NUM(+)  =?	AND A.CHART_LINE_NUM(+) =?	 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   	AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE	 UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,2 LINE_SEQ     FROM OH_PERIODONTAL_CHART_DTL A,		  (SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	   		   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y   WHERE Z.CHART_CODE = ?		 AND X.LANGUAGE_ID =?		   AND Y.PERMANENT_DECIDUOUS = 'P'		 AND Y.ARCH_SNO =?		   AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		 WHERE  A.PATIENT_ID(+) =?	   		 AND A.CHART_CODE(+) =?		 AND A.CHART_NUM(+)  =?		   AND A.CHART_LINE_NUM(+) =?		 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE )  		 WHERE COMPONENT_CODE =?		   ORDER BY LINE_SEQ,COMPONENT_CODE,TOOTH_NO";	
	}else if(no_of_charts.equals("3")){
		sql="SELECT COMPONENT_CODE,TOOTH_NO, S1, S2, S3, S4, S5, S6,SURFACES_APPL_YN, LINE_COLOR,LINE_SEQ FROM (SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6 ,D.SURFACES_APPL_YN,'QRYODD' LINE_COLOR,1 LINE_SEQ FROM OH_PERIODONTAL_CHART_DTL A, 	   	(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	  	FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	  WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	  AND Y.PERMANENT_DECIDUOUS = 'P'	 AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D	 WHERE A.PATIENT_ID(+) =?	   	 AND A.CHART_CODE(+) =?	AND A.CHART_NUM(+)  =?	AND A.CHART_LINE_NUM(+) =?	 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   	AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE	 UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,2 LINE_SEQ     FROM OH_PERIODONTAL_CHART_DTL A,		  (SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	   		   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y   WHERE Z.CHART_CODE = ?		 AND X.LANGUAGE_ID =?		   AND Y.PERMANENT_DECIDUOUS = 'P'		 AND Y.ARCH_SNO =?		   AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		 WHERE  A.PATIENT_ID(+) =?	   		 AND A.CHART_CODE(+) =?		 AND A.CHART_NUM(+)  =?		   AND A.CHART_LINE_NUM(+) =?		 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,3 LINE_SEQ     FROM OH_PERIODONTAL_CHART_DTL A,		  (SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	   		   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y   WHERE Z.CHART_CODE = ?		 AND X.LANGUAGE_ID =?		   AND Y.PERMANENT_DECIDUOUS = 'P'		 AND Y.ARCH_SNO =?		   AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		 WHERE  A.PATIENT_ID(+) =?	   		 AND A.CHART_CODE(+) =?		 AND A.CHART_NUM(+)  =?		   AND A.CHART_LINE_NUM(+) =?		 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE )  		 WHERE COMPONENT_CODE =?		   ORDER BY LINE_SEQ,COMPONENT_CODE,TOOTH_NO";		
	}
		if(no_of_charts.equals("2")){		
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,chart_code);
			pstmt.setString(2,locale);
			pstmt.setString(3,perio_arch);
			pstmt.setString(4,patient_id);
			pstmt.setString(5,chart_code);
			pstmt.setString(6,chart_num);
			pstmt.setString(7,chart_line_num);
			pstmt.setString(8,chart_code);
			pstmt.setString(9,locale);
			pstmt.setString(10,perio_arch);
			pstmt.setString(11,patient_id);
			pstmt.setString(12,chart_code);
			pstmt.setString(13,chart_num2);
			pstmt.setString(14,chart_line_num2);
			pstmt.setString(15,component_code);
		}else if(no_of_charts.equals("3")){		
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,chart_code);
			pstmt.setString(2,locale);
			pstmt.setString(3,perio_arch);
			pstmt.setString(4,patient_id);
			pstmt.setString(5,chart_code);
			pstmt.setString(6,chart_num);
			pstmt.setString(7,chart_line_num);
			pstmt.setString(8,chart_code);
			pstmt.setString(9,locale);
			pstmt.setString(10,perio_arch);
			pstmt.setString(11,patient_id);
			pstmt.setString(12,chart_code);
			pstmt.setString(13,chart_num2);
			pstmt.setString(14,chart_line_num2);
			pstmt.setString(15,chart_code);
			pstmt.setString(16,locale);
			pstmt.setString(17,perio_arch);
			pstmt.setString(18,patient_id);
			pstmt.setString(19,chart_code);
			pstmt.setString(20,chart_num3);
			pstmt.setString(21,chart_line_num3);
			pstmt.setString(22,component_code);
	} 
	
			rs=pstmt.executeQuery();
			int k=0;
				while(rs.next()){
							++k;
							next_row_flag = (comp_str.equals( rs.getString(1)+"#"+rs.getString(11)) )?"N":"Y";
							comp_code	 =  rs.getString(1);//component code
							tooth_num			 =  rs.getString(2);//tooth number
							S1				 =  checkForNull(rs.getString(3),"&nbsp;");//surface-1   
							S2				 =  checkForNull(rs.getString(4),"&nbsp;");//surface-2     
							S3				 =  checkForNull(rs.getString(5),"&nbsp;");//surface-3     
							S4				 =  checkForNull(rs.getString(6),"&nbsp;");//surface-4     
							S5				 =  checkForNull(rs.getString(7),"&nbsp;");//surface-5     
							S6				 =  checkForNull(rs.getString(8),"&nbsp;");//surface-6    
							//chart_line_num =  rs.getString(12);//val
							surfaces_appl_yn =  rs.getString(9);//val
							row_color =  rs.getString(10);//val 
							line_seq =  rs.getString(11);//val
							if(no_of_charts.equals("2")){
						if("BE".equals(eval_type)){
								chart_date			 = ("1".equals(line_seq))?"Baseline":"Evaluation";//chart_date
							}else if("EE".equals(eval_type)){
								chart_date			 = ("1".equals(line_seq))?"Evaluation1":"Evaluation2";//chart_date
							}else if("BB".equals(eval_type)){
								chart_date			 = ("1".equals(line_seq))?"Baseline1":"Baseline2";//chart_date
							}
				}else if(no_of_charts.equals("3")){
						if("BE".equals(eval_type)){
							if("1".equals(line_seq)){
								chart_date = "Baseline1";
							}else if("2".equals(line_seq)){
								chart_date = "Evaluation1";
							}else if("3".equals(line_seq)){
								chart_date = "Evaluation2";
							}
						}else if("EE".equals(eval_type)){
								if("1".equals(line_seq)){
									chart_date = "Evaluation1";
								}else if("2".equals(line_seq)){
									chart_date = "Evaluation2";
								}else if("3".equals(line_seq)){
									chart_date = "Evaluation3";
								}
							}else if("BB".equals(eval_type)){
								if("1".equals(line_seq)){
									chart_date = "Baseline1";
								}else if("2".equals(line_seq)){
									chart_date = "Baseline2";
								}else if("3".equals(line_seq)){
									chart_date = "Baseline3";
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
									sbr.append("<table width=100% cellpadding =0 cellspacing=1 border=1>");
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
												sbr.append("</tr>");
									sbr.append("</table>");
							}	
							comp_str = component_code+"#"+ rs.getString(11);
							if("Y".equals(next_row_flag) ) {
								out.println("<tr>");
								if("1".equals(line_seq) ){
									//	out.println("<td  class='"+row_color+"' >"+component_code+"</td>");
										out.println("<td  class='"+row_color+"' >"+component_desc+"</td>");
								}else{
									out.println("<td  class='"+row_color+"' >&nbsp;</td>");
								}
									out.println("<td  class='"+row_color+"' nowrap>"+chart_date+"</td>");
									tooth_str_arr = tooth_str.split(",");
									for(int j=0;j<tooth_str_arr.length;j++){
										td_id =line_seq+component_code+tooth_str_arr[j] ;
										if(tooth_str_arr[j].equals(tooth_num) ){
											out.println("<td class='"+row_color+"' id="+td_id+" style=text-align:center >"+sbr.toString()+"</td>");
										}else{
											out.println("<td class='"+row_color+"' id="+td_id+" style=text-align:center>&nbsp;&nbsp;</td>");
										}
									}//for
								out.println("</tr>");
							}else{
							for(int j=0;j<tooth_str_arr.length;j++){
								td_id =line_seq+component_code+tooth_str_arr[j] ;
									if(tooth_str_arr[j].equals(tooth_num) )
									out.println("<SCRIPT>assignValueToCell('"+td_id+"','"+sbr.toString()+"','"+cut_off+"');</SCRIPT>");
								}
						}
						sbr.setLength(0);
				}//end of while 
			}//end of surface_appl_yn 
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Err Mesg From PerioCompareGraphPalatalTableVIew.jsp"+e);
		}finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null)
				ConnectionManager.returnConnection(con,request); 
			}catch(Exception es){}
		}
		
%>

