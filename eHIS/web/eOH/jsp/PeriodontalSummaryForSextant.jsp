<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>


<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
	PreparedStatement pstmt1=null;
	//PreparedStatement pstmt2=null;
	
	ResultSet rs1=null;
//	ResultSet rs2=null;
//	boolean isExfoliated = false;
//	int count_GS = 0;
	//


	String facility_id = (String)session.getValue("facility_id") ;
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String chart_num = checkForNull(request.getParameter("chart_num"));
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String called_from_tab=checkForNull(request.getParameter("called_from_tab"));
	String gingival_recording_by=checkForNull(request.getParameter("gingival_recording_by"));
	String permanent_deciduous_flag=checkForNull(request.getParameter("permanent_deciduous_flag"));
	//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
	String mixed_dentition_YN=checkForNull(request.getParameter("mixed_dentition_YN"));
	//
	//Added by Sharon Crasta for CRF #0423 on 3/30/2009
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
	String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
	}

	String tooth_no = "";
	String q1_tooth = "";
	String q2_tooth = "";
	String q3_tooth = "";
	String q4_tooth = "";
	String q5_tooth = "";
	String q6_tooth = "";
	

	int count = 0;
	int gingival_status_sum =0;
	int tooth_count = 0;
	int q1_count = 0;
	int q2_count = 0;
	int q3_count = 0;
	int q4_count = 0;
	int q5_count = 0;
	int q6_count = 0;

	double gs_q1_count = 0.0;
	double gs_q2_count = 0.0;
	double gs_q3_count = 0.0;
	double gs_q4_count = 0.0;
	double gs_q5_count = 0.0;
	double gs_q6_count = 0.0;

	int th_q1_count = 0;
	int th_q2_count = 0;
	int th_q3_count = 0;
	int th_q4_count = 0;
	int th_q5_count = 0;
	int th_q6_count = 0;

	//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
	String ns_tooth_no = "";
	String mapped_tooth_no = "";
	//String super_yn = "";
	//String MD_yn = "";
	//String exfolth_yn = "N";
	//String deciduous_tooth_yn = "N";
	//String condition_type = "";
	String status = "";
	//

	//String msg = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"APP-OH00088","OH"); 
	//String msg = "";

	StringBuffer str = new StringBuffer();
	
	if(gingival_recording_by.equals("Q")){
		str.append("<script>");
		str.append("var msg=getMessage('APP-OH00088','OH');");
	
		str.append("document.write(msg);");
		str.append("</script>");
	}
	else{
		str.append("<script>");
		str.append("var msg=getMessage('APP-OH00089','OH');");

		str.append("document.write(msg);");
		str.append("</script>");
	}
	

	
	
%>
	<html>
		<head>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="javascript" src="../../eCommon/js/common.js"></script> 
			<script language="javascript" src="../../eOH/js/PeriodontalSummary.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
		</head>
	<%
	
		try{
			con=ConnectionManager.getConnection(request);
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();

				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				//pstmt=con.prepareStatement("SELECT DISTINCT (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) TOOTH_NO, A.GINGIVAL_STATUS_CODE FROM OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND QUADRANT_SNO = ?");
				if(oh_chart_level.equals("E")){
					//pstmt=con.prepareStatement("SELECT A.SEXTENT_SNO, A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, COUNT(A.TOOTH_NO) TOOTH_COUNT, SUM(A.VALUE) GINGIVAL_STATUS_SUM  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND NVL(STATUS,'X') != 'E' AND A.SEXTENT_SNO IS NOT NULL GROUP BY A.SEXTENT_SNO, A.TOOTH_NO");
					//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt=con.prepareStatement("SELECT A.SEXTENT_SNO, A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, COUNT(A.TOOTH_NO) TOOTH_COUNT, SUM(A.VALUE) GINGIVAL_STATUS_SUM  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.PATIENT_ID=? AND A.CHART_NUM = ? AND NVL(STATUS,'X') != 'E' AND A.SEXTENT_SNO IS NOT NULL GROUP BY A.SEXTENT_SNO, A.TOOTH_NO");
					pstmt=con.prepareStatement("SELECT A.SEXTENT_SNO, A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT C.MAPPED_TOOTH_NO	FROM OH_TOOTH C WHERE C.TOOTH_NO = A.TOOTH_NO) MAPPED_TOOTH_NO, COUNT(A.TOOTH_NO) TOOTH_COUNT, SUM(A.VALUE) GINGIVAL_STATUS_SUM, A.STATUS  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.PATIENT_ID=? AND A.CHART_NUM = ? AND NVL(STATUS,'X') != 'E'  AND NVL(STATUS,'X') != 'Y' AND A.SEXTENT_SNO IS NOT NULL GROUP BY A.SEXTENT_SNO, A.TOOTH_NO, A.STATUS ORDER BY NS_TOOTH_NO ASC");
				
					pstmt.setString(1,tooth_numbering_system);
					//pstmt.setString(2,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					rs=pstmt.executeQuery();
				}else{
					//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt=con.prepareStatement("SELECT A.SEXTENT_SNO, A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, COUNT(A.TOOTH_NO) TOOTH_COUNT, SUM(A.VALUE) GINGIVAL_STATUS_SUM  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND NVL(STATUS,'X') != 'E' AND A.SEXTENT_SNO IS NOT NULL GROUP BY A.SEXTENT_SNO, A.TOOTH_NO");
					pstmt=con.prepareStatement("SELECT A.SEXTENT_SNO, A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT C.MAPPED_TOOTH_NO	FROM OH_TOOTH C WHERE C.TOOTH_NO = A.TOOTH_NO) MAPPED_TOOTH_NO, COUNT(A.TOOTH_NO) TOOTH_COUNT, SUM(A.VALUE) GINGIVAL_STATUS_SUM, A.STATUS  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND NVL(STATUS,'X') != 'E'  AND NVL(STATUS,'X') != 'Y' AND A.SEXTENT_SNO IS NOT NULL GROUP BY A.SEXTENT_SNO, A.TOOTH_NO, A.STATUS ORDER BY NS_TOOTH_NO ASC");
					
					pstmt.setString(1,tooth_numbering_system);
					//pstmt.setString(2,facility_id);
					pstmt.setString(2,other_chart_facility_id);
					pstmt.setString(3,patient_id);
					pstmt.setString(4,chart_num);
					rs=pstmt.executeQuery();
				}
			
				while(rs.next()){
					ns_tooth_no = checkForNull(rs.getString("NS_TOOTH_NO"));
					gingival_status_sum = rs.getInt("GINGIVAL_STATUS_SUM");
					tooth_count = rs.getInt("TOOTH_COUNT");
					//Added by Sharon Crasta on 8/7/2009 for IN009739(SRR20056-CRF-0457)
					tooth_no = rs.getString("TOOTH_NO");
					mapped_tooth_no = rs.getString("MAPPED_TOOTH_NO");
					status = rs.getString("STATUS");
					
					
					 
					 if(rs1 != null) rs1.close();
					 if(pstmt1 != null) pstmt1.close();
					 if (mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D")){
							
							if(status.equals("A")){
								
								pstmt1 = con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO = ? ");
								pstmt1.setString(1,tooth_numbering_system);
								pstmt1.setString(2,mapped_tooth_no);
								
								rs1=pstmt1.executeQuery();
								while(rs1!=null && rs1.next()){
									   ns_tooth_no = checkForNull(rs1.getString("NS_TOOTH_NO"));
								}
							}

							if(status.equals("S")){
							   ns_tooth_no = ns_tooth_no + "s";					
							}

							if(status.equals("R")){
								 pstmt1 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?)");
								 pstmt1.setString(1,tooth_numbering_system);
								 pstmt1.setString(2,tooth_no);
								
								 rs1=pstmt1.executeQuery();
								 while(rs1!=null && rs1.next()){
									   ns_tooth_no = checkForNull(rs1.getString("NS_TOOTH_NO"));
								}
							}
						}
						else if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("P")){
						
						if(status.equals("D")){
							pstmt1 = con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO = ?");
							//pstmt.setString(1,other_chart_facility_id);
							pstmt1.setString(1,tooth_numbering_system);
							pstmt1.setString(2,mapped_tooth_no);
							
							rs1=pstmt1.executeQuery();
							while(rs1!=null && rs1.next()){
								   ns_tooth_no = checkForNull(rs1.getString("NS_TOOTH_NO"));
							}
							//ns_tooth_no =  disply_tooth_no_deciduous;
						}
					}
					else{
						if(status.equals("S")) {
							ns_tooth_no =  ns_tooth_no + "s";
						}
						if(status.equals("R")){
							 pstmt1 = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND A.TOOTH_NO = B.TOOTH_NO AND A.TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = ?)");
							 pstmt1.setString(1,tooth_numbering_system);
							 pstmt1.setString(2,tooth_no);
							
							 rs1=pstmt1.executeQuery();
							 while(rs1!=null && rs1.next()){
								   ns_tooth_no = checkForNull(rs1.getString("NS_TOOTH_NO"));
							}
						}
					}
					 //
					if(rs.getString("SEXTENT_SNO").equals("1")){
						if(q1_count == 0){
							//q1_tooth = tooth_no;
							q1_tooth = ns_tooth_no;
							gs_q1_count = gingival_status_sum;
							//th_q1_count = Integer.parseInt(tooth_count);
							th_q1_count = tooth_count;
						}
							
						else{
							//q1_tooth = q1_tooth+"/"+tooth_no;
							q1_tooth = q1_tooth+"/"+ns_tooth_no;
							gs_q1_count = gs_q1_count+gingival_status_sum;
							//th_q1_count = th_q1_count+Integer.parseInt(tooth_count);
							th_q1_count = th_q1_count+tooth_count;
						}
						q1_count++;
					}
					else if(rs.getString("SEXTENT_SNO").equals("2")){
						if(q2_count == 0){
							//q2_tooth = tooth_no;
							q2_tooth = ns_tooth_no;
							gs_q2_count = gingival_status_sum;
							//th_q1_count = Integer.parseInt(tooth_count);
							th_q2_count = tooth_count;
							
							
						}
						else{
							//q2_tooth = q2_tooth+"/"+tooth_no;
							q2_tooth = q2_tooth+"/"+ns_tooth_no;
							gs_q2_count = gs_q2_count+gingival_status_sum;
							//th_q1_count = th_q1_count+Integer.parseInt(tooth_count);
							th_q2_count = th_q2_count+tooth_count;
						}
						q2_count++;
					}
					else if(rs.getString("SEXTENT_SNO").equals("3")){
						if(q3_count == 0){
							//q3_tooth = tooth_no;
							q3_tooth = ns_tooth_no;
							gs_q3_count = gingival_status_sum;
							//th_q1_count = Integer.parseInt(tooth_count);
							th_q3_count = tooth_count;
						}
						else{
							//q3_tooth = q3_tooth+"/"+tooth_no;
							q3_tooth = q3_tooth+"/"+ns_tooth_no;
							gs_q3_count = gs_q3_count+gingival_status_sum;
							//th_q1_count = th_q1_count+Integer.parseInt(tooth_count);
							th_q3_count = th_q3_count+tooth_count;
						}
						q3_count++;
					}
					else if(rs.getString("SEXTENT_SNO").equals("4")){
						if(q4_count == 0){
							//q4_tooth =tooth_no;
							q4_tooth =ns_tooth_no;
							gs_q4_count = gingival_status_sum;
							//th_q1_count = Integer.parseInt(tooth_count);
							th_q4_count = tooth_count;
						}
						else{
							//q4_tooth = q4_tooth+"/"+tooth_no;
							q4_tooth = q4_tooth+"/"+ns_tooth_no;
							gs_q4_count = gs_q4_count+gingival_status_sum;
							//th_q1_count = th_q1_count+Integer.parseInt(tooth_count);
							th_q4_count = th_q4_count+tooth_count;
						}
						q4_count++;
					}
					else if(rs.getString("SEXTENT_SNO").equals("5")){
						if(q5_count == 0){
							//q5_tooth =tooth_no;
							q5_tooth =ns_tooth_no;
							gs_q5_count = gingival_status_sum;
							//th_q1_count = Integer.parseInt(tooth_count);
							th_q5_count = tooth_count;
						}
						else{
							//q5_tooth = q5_tooth+"/"+tooth_no;
							q5_tooth = q5_tooth+"/"+ns_tooth_no;
							gs_q5_count = gs_q5_count+gingival_status_sum;
							//th_q1_count = th_q1_count+Integer.parseInt(tooth_count);
							th_q5_count = th_q5_count+tooth_count;
						}
						q5_count++;
					}
					else if(rs.getString("SEXTENT_SNO").equals("6")){
						if(q6_count == 0){
							//q6_tooth =tooth_no;
							q6_tooth =ns_tooth_no;
							gs_q6_count = gingival_status_sum;
							//th_q1_count = Integer.parseInt(tooth_count);
							th_q6_count = tooth_count;
						}
						else{
							//q6_tooth = q6_tooth+"/"+tooth_no;
							q6_tooth = q6_tooth+"/"+ns_tooth_no;
							gs_q6_count = gs_q6_count+gingival_status_sum;
							//th_q1_count = th_q1_count+Integer.parseInt(tooth_count);
							th_q6_count = th_q6_count+tooth_count;
						}
						q6_count++;
					}
				
				}

%>
		
			<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
				<form name="PeridontalSummary" id="PeridontalSummary" method="post" target="messageFrame">
				   <!-- <table width="80%" cellpadding =0 cellspacing='1' border='0' align='center' valign='center' style="background-color:white">
						<tr>
							<td class='label' width="20%" style="background-color:white"><%=q1_tooth%></td>
							
							<td class='LABEL' width="20%" style="background-color:white"><%=q2_tooth%></td>
						</tr>
					</table> -->
					
			<table width="80%" cellpadding =4 cellspacing='1' border='1' align='center' valign='center'>
			
				  <%
                      if(called_from_tab.equals("Y")){
				   %>  
					 <tr>
							<td width="20%" class='LABEL' nowrap >
							 	<%
									if(th_q1_count > 0){
										out.println(gs_q1_count);
									}
									else{
										out.println(th_q1_count);
									}
								%>  
                         
					</td>
				
							<td width="20%" class='LABEL' nowrap>
								<%
									if(th_q2_count > 0){
										out.println(gs_q2_count);
									}
									else{
										out.println(th_q2_count);
									}
								%>
							</td>
						</tr>
						<tr>
							<td width="20%" class='LABEL' nowrap>
								<%
									if(th_q4_count > 0){
										out.println(gs_q4_count);
									}
									else{
										out.println(th_q4_count);
									}
								%>
							</td>
							<td width="20%" class='LABEL' nowrap>
								<%
									if(th_q3_count > 0){
										out.println(gs_q3_count);
									}
									else{
										out.println(th_q3_count);
									}
								%>
							</td>	
						</tr>
						<tr>
							<td width="20%" class='LABEL' nowrap>
								<%
									if(th_q5_count > 0){
										out.println(gs_q5_count);
									}
									else{
										out.println(th_q5_count);
									}
								%>
							</td>
							<td width="20%" class='LABEL' nowrap>
								<%
									if(th_q6_count > 0){
										out.println(gs_q6_count);
									}
									else{
										out.println(th_q6_count);
									}
								%>
							</td>	
						</tr>
				
				<%	
				     }else{
					 %>
						
						<tr>
						
							<td width="20%" class='LABEL' nowrap>
								<%
									if(th_q1_count > 0){
										out.println("<a href=\"javascript:showGSDetails('1','"+gs_q1_count+"','"+th_q1_count+"','"+gingival_recording_by+"')\">"+format_decimal((gs_q1_count/th_q1_count),2)+"</a>("+q1_tooth+")");
									}
									else{
										out.println("<a href=\"javascript:showGSDetails('1','','"+th_q1_count+"','"+gingival_recording_by+"')\">"+th_q1_count+"</a>");
									}
								%> 
                         
										
							</td>
							<td width="20%" class='LABEL' nowrap>
								<%
									if(th_q2_count > 0){
										out.println("<a href=\"javascript:showGSDetails('2','"+gs_q2_count+"','"+th_q2_count+"','"+gingival_recording_by+"')\">"+format_decimal((gs_q2_count/th_q2_count),2)+"</a>("+q2_tooth+")");
									}
									else{
										out.println("<a href=\"javascript:showGSDetails('2','','"+th_q2_count+"','"+gingival_recording_by+"')\">"+th_q2_count+"</a>");
									}
								%>
							</td>
							<td width="20%" class='LABEL' nowrap>
								<%
									if(th_q3_count > 0){
										out.println("<a href=\"javascript:showGSDetails('3','"+gs_q3_count+"','"+th_q3_count+"','"+gingival_recording_by+"')\">"+format_decimal((gs_q3_count/th_q3_count),2)+"</a>("+q3_tooth+")");
									}
									else{
										out.println("<a href=\"javascript:showGSDetails('3','','"+th_q3_count+"','"+gingival_recording_by+"')\">"+th_q3_count+"</a>");
									}
								%>
							</td>
						</tr>
						<tr>
							<td width="20%" class='LABEL' nowrap>
								<%
									if(th_q6_count > 0){
										out.println("<a href=\"javascript:showGSDetails('6','"+gs_q6_count+"','"+th_q6_count+"','"+gingival_recording_by+"')\">"+format_decimal((gs_q6_count/th_q6_count),2)+"</a>("+q6_tooth+")");
									}
									else{
										out.println("<a href=\"javascript:showGSDetails('6','','"+th_q6_count+"','"+gingival_recording_by+"')\">"+th_q6_count+"</a>");
									}
								%>
							</td>
							<td width="20%" class='LABEL' nowrap>
								<%
									if(th_q5_count > 0){
										out.println("<a href=\"javascript:showGSDetails('5','"+gs_q5_count+"','"+th_q5_count+"','"+gingival_recording_by+"')\">"+format_decimal((gs_q5_count/th_q5_count),2)+"</a>("+q5_tooth+")");
									}
									else{
										out.println("<a href=\"javascript:showGSDetails('5','','"+th_q5_count+"','"+gingival_recording_by+"')\">"+th_q5_count+"</a>");
									}
								%>
							</td>
							<td width="20%" class='LABEL' nowrap>
								<%
									if(th_q4_count > 0){
										out.println("<a href=\"javascript:showGSDetails('4','"+gs_q4_count+"','"+th_q4_count+"','"+gingival_recording_by+"')\">"+format_decimal((gs_q4_count/th_q4_count),2)+"</a>("+q4_tooth+")");
									}
									else{
										out.println("<a href=\"javascript:showGSDetails('4','','"+th_q4_count+"','"+gingival_recording_by+"')\">"+th_q4_count+"</a>");
									}
								%>
							</td>
						</tr>
					<%
						}
					%> 
				
					</table>
					<!-- <table width="80%" cellpadding =4 cellspacing='1' border='0' align='center' valign='center'>
						<tr>
							<td class='LABEL' width="10%" style="background-color:white"><%=q4_tooth%></td>
							<td class='LABEL' width="10%" style="background-color:white"><%=q3_tooth%></td>
						</tr>
					</table> -->
					<table align="center" width="80%">
						<tr>
							<%
								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
								pstmt=con.prepareStatement("SELECT VALUE,GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW WHERE LANGUAGE_ID=?");
								pstmt.setString(1,locale);
								rs=pstmt.executeQuery();

								while(rs.next()){
							%>
										<td width="30%" class='LABEL' nowrap><%=rs.getString("VALUE")%>:<%=rs.getString("GINGIVAL_STATUS_DESC")%></td>
							<%
									if(count==2){
							%>
										</tr><tr>
							<%
									}
									count++;
								}
							%>
						</tr>
						<tr>
							<td width="20%" class='LABEL' colspan=3 style="background-color:'white'">&nbsp;</td>
						</tr>
						<tr>
							<td width="20%" class='LABEL' colspan=3><b><fmt:message key="Common.note.label" bundle="${common_labels}"/>:</b><%=str.toString()%></td>
						</tr>
					</table>

					<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
					<input type="hidden" name="chart_num" id="chart_num" value="<%=chart_num%>">
					<input type="hidden" name="tooth_numbering_system" id="tooth_numbering_system" value="<%=tooth_numbering_system%>">
					<input type="hidden" name="called_from_tab" id="called_from_tab" value="<%=called_from_tab%>">
                    <input type="hidden" name="called_from_ging_summary" id="called_from_ging_summary" value="Y">
                    <input type="hidden" name="called_from_viewchart_yn" id="called_from_viewchart_yn" value="Y">
                    <input type="hidden" name="called_from_viewchart_gingival" id="called_from_viewchart_gingival" value="N">
                    <input type="hidden" name="gingival_recording_by" id="gingival_recording_by" value="<%=gingival_recording_by%>">
					<input type="hidden" name="permanent_deciduous_flag" id="permanent_deciduous_flag" value="<%=permanent_deciduous_flag%>">
					<input type="hidden" name="oh_chart_level" id="oh_chart_level" value="<%=oh_chart_level%>">
					<input type="hidden" name="other_chart_facility_id" id="other_chart_facility_id" value="<%=other_chart_facility_id%>">
					<!--Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)-->
					<input type="hidden" name="mixed_dentition_YN" id="mixed_dentition_YN" value="<%=mixed_dentition_YN%>">
					
					
					
					
				</form>
			</body>
		</html>
		
<%
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(rs1!=null) rs1.close();
		if(pstmt1!=null) pstmt1.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>

