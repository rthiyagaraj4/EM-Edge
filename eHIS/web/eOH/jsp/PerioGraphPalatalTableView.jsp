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
		//alert(td_id);alert(val);
}
</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form name="PerioCompareChartDisplayForm" id="PerioCompareChartDisplayForm">
<table width="83%" cellpadding =0 cellspacing=2 border=1 id="myTable">
<%	
			String patient_id=checkForNull(request.getParameter("patient_id"));
			String chart_code=checkForNull(request.getParameter("chart_code"));
			String chart_num=checkForNull(request.getParameter("chart_num"));
			String eval_chart_line_num=checkForNull(request.getParameter("chart_line_num"));
			String perio_arch_val=checkForNull(request.getParameter("perio_arch"));
			String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
			String permanent_deciduous_flag=checkForNull(request.getParameter("permanent_deciduous_flag"));
			String components=checkForNull(request.getParameter("components"));
			String load_flag=checkForNull(request.getParameter("load_flag"));
			String qry_str =("2".equals(load_flag))?"WHERE COMPONENT_CODE IN ("+components+")":"WHERE COMPONENT_CODE IN ('PD')";
			StringBuilder  sbr= new StringBuilder();
				
			String tooth_num			 =	 "";
			String S1					 =  "";
			String S2					 =  "";
			String S3					 =  "";
			String S4					 =  "";
			String S5					 =  "";
			String S6					 =  "";
			String component_code		=  "";
			String component_desc		 =  "";
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

			/* Removed X.FORMULA_YN = 'N' from Where Clause for CAL
			String SQL=" SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ FROM( SELECT D.COMPONENT_CODE, D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,D.SURFACES_APPL_YN, 'QRYODD' LINE_COLOR, 1 LINE_SEQ FROM OH_PERIODONTAL_CHART_DTL A, 	  (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO FROM OH_PERDONTAL_CHRT_COMP_LANG_VW X,OH_TOOTH Y WHERE X.FORMULA_YN = 'N' 	   AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P'AND Y.ARCH_SNO = ?	 ) D  	   WHERE A.OPERATING_FACILITY_ID(+)= ? AND A.PATIENT_ID(+) = ?    AND A.CHART_CODE(+) = ?   AND A.CHART_NUM(+)	= ?   AND A.CHART_LINE_NUM(+) = ?   AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE) "+qry_str+" ";

			*/
//			String SQL=" SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ FROM( SELECT D.COMPONENT_CODE, D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,D.SURFACES_APPL_YN, 'QRYODD' LINE_COLOR, 1 LINE_SEQ FROM OH_PERIODONTAL_CHART_DTL A, 	  (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO FROM OH_PERDONTAL_CHRT_COMP_LANG_VW X,OH_TOOTH Y WHERE X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P'AND Y.ARCH_SNO = ?	 ) D  	   WHERE A.OPERATING_FACILITY_ID(+)= ? AND A.PATIENT_ID(+) = ?    AND A.CHART_CODE(+) = ?   AND A.CHART_NUM(+)	= ?   AND A.CHART_LINE_NUM(+) = ?   AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE) "+qry_str+" ORDER BY COMPONENT_CODE";
			String SQL=" SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ FROM( SELECT D.COMPONENT_CODE, D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,D.SURFACES_APPL_YN, 'QRYODD' LINE_COLOR, 1 LINE_SEQ FROM OH_PERIODONTAL_CHART_DTL A, 	  (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO FROM OH_PERDONTAL_CHRT_COMP_LANG_VW X,OH_TOOTH Y WHERE X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P'AND Y.ARCH_SNO = ?	 ) D  	   WHERE A.PATIENT_ID(+) = ?    AND A.CHART_CODE(+) = ?   AND A.CHART_NUM(+)	= ?   AND A.CHART_LINE_NUM(+) = ?   AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE) "+qry_str+" ORDER BY COMPONENT_CODE";
			con=ConnectionManager.getConnection(request);
			
			int tooth_cnt=0;
			try{
			pstmt = con.prepareStatement(sql_tooth);
			pstmt.setString(1,tooth_numbering_system);
			pstmt.setString(2,permanent_deciduous_flag);
			pstmt.setString(3,perio_arch_val);
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
				System.err.println("Err Mesg From PerioGraphBuccalTableView.jsp");
			}
	%>
	<tr>
		<td class="columnHeader" width="5%"><fmt:message key="eOH.Lingual.Label" bundle="${oh_labels}"/></td>
		<%
				tooth_str_arr = tooth_str.split(",");
				display_tooth_str_arr = display_tooth_str.split(",");
				if(perio_arch_val.equals("L")){
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


				
					pstmt=con.prepareStatement(SQL);
					pstmt.setString(1,locale);
					pstmt.setString(2,perio_arch_val );
					pstmt.setString(3,patient_id);
					pstmt.setString(4,chart_code);
					pstmt.setString(5,chart_num);
					pstmt.setString(6,eval_chart_line_num);
					rs=pstmt.executeQuery();
					int k=0;
					while(rs.next()){
							++k;
							next_row_flag = (comp_str.equals( rs.getString(1)+"#"+rs.getString(12)) )?"N":"Y";
							component_code	 =  rs.getString(1);//component code
							component_desc	 =  rs.getString(2);//component desc
							tooth_num			 =  rs.getString(3);//tooth number
							S1				 =  checkForNull(rs.getString(4),"&nbsp;");//surface-1   
							S2				 =  checkForNull(rs.getString(5),"&nbsp;");//surface-2     
							S3				 =  checkForNull(rs.getString(6),"&nbsp;");//surface-3     
							S4				 =  checkForNull(rs.getString(7),"&nbsp;");//surface-4     
							S5				 =  checkForNull(rs.getString(8),"&nbsp;");//surface-5     
							S6				 =  checkForNull(rs.getString(9),"&nbsp;");//surface-6     
							surfaces_appl_yn =  rs.getString(10);//val
							row_color =  rs.getString(11);//val
							line_seq =  rs.getString(12);//val
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
									sbr.append("<table width=100% cellpadding =0 cellspacing=0 border=1>");
									sbr.append("<tr>");
								/*	sbr.append("<td class="+row_color+" nowrap>").append(S4).append("</td>");
									sbr.append("<td class="+row_color+" nowrap>").append(S5).append("</td>");
									sbr.append("<td class="+row_color+" nowrap>").append(S6).append("</td>");*/
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
							comp_str = component_code+"#"+ rs.getString(12);
							component_code=component_desc;

							if("Y".equals(next_row_flag) ) {
								out.println("<tr>");
								if("1".equals(line_seq) )
										out.println("<td  class='"+row_color+"' >"+component_code+"</td>");
								else
									tooth_str_arr = tooth_str.split(",");
									if(perio_arch_val.equals("U")){
										for(int j=0;j<tooth_str_arr.length;j++){
											td_id =line_seq+component_code+tooth_str_arr[j] ;
											if(tooth_str_arr[j].equals(tooth_num) )
												out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center >"+sbr.toString()+"</td>");
											else
												out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center>&nbsp;&nbsp;</td>");
										}
									}else if(perio_arch_val.equals("L")){
										for(int j=tooth_str_arr.length-1;j>=0;--j){
											td_id =line_seq+component_code+tooth_str_arr[j] ;
											if(tooth_str_arr[j].equals(tooth_num) )
												out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center >"+sbr.toString()+"</td>");
											else
												out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center>&nbsp;&nbsp;</td>");
										}			
									}
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
			
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Err Mesg From PerioGraphPalatalTableView.jsp"+e);
		}finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(Exception es){}
		}
		
%>

