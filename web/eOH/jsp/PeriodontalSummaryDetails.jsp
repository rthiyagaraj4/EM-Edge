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
	//PreparedStatement pstmt3=null;
	ResultSet rs1=null;
	//ResultSet rs3=null;
	
	//boolean isExfoliated = false;
	//int count_GS = 0;
	//

	String facility_id = (String)session.getValue("facility_id") ;
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String chart_num = checkForNull(request.getParameter("chart_num"));
	String quadrant_sno = checkForNull(request.getParameter("quadrant_sno"));
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
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
	

	String code_desc="";
	
	String gs_count = checkForNull(request.getParameter("gs_count"));
	if(gs_count.equals("")) gs_count = "0.0"; 

	String th_count = checkForNull(request.getParameter("th_count"));
	if(th_count.equals("")) th_count = "0"; 


	Double gs_count_int = Double.valueOf(gs_count).doubleValue();
	int th_count_int = Integer.parseInt(th_count);
	
	String ns_tooth_no = "";
	String gingival_status_desc = "";
	String gingival_status_value = "";
	//String GS_desc = "";
	//String GS_desc1 = "";

	//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
	String tooth_no = "";
	String mapped_tooth_no = "";
	//String super_yn = "";
	//String MD_yn = "";
	//String exfolth_yn = "N";
	//String deciduous_tooth_yn = "N";
	//String condition_type = "";
	String status = "";
	//

	//String Of_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Of.Label","oh_labels");
	String For_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.For.Label","oh_labels");

	try{
			con=ConnectionManager.getConnection(request);

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			
			if(gingival_recording_by.equals("Q")){
				
				/* Commented by Sharon Crasta on 28/11/2008 to remove PERMANENT_DECIDUOUS column reference from OH_QUADRANT */
				//pstmt=con.prepareStatement("SELECT QUADRANT_DESC CODE_DESC FROM OH_QUADRANT WHERE NUMBERING_SYSTEM=? AND QUADRANT_SNO = ? AND PERMANENT_DECIDUOUS = ?");

				pstmt=con.prepareStatement("SELECT QUADRANT_DESC CODE_DESC FROM OH_QUADRANT WHERE NUMBERING_SYSTEM=? AND QUADRANT_SNO = ? ");

				pstmt.setString(1,tooth_numbering_system);
				pstmt.setString(2,quadrant_sno);
				//pstmt.setString(3,permanent_deciduous_flag);
			}
			else{
				pstmt=con.prepareStatement("SELECT SEXTANT_DESC CODE_DESC FROM OH_SEXTANT WHERE NUMBERING_SYSTEM=? AND SEXTANT_SNO = ?");
				pstmt.setString(1,tooth_numbering_system);
				pstmt.setString(2,quadrant_sno);
				
			}
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				code_desc = checkForNull(rs.getString("CODE_DESC"));
				code_desc = For_label+" "+code_desc;
				//GS_desc = Of_label+" "+code_desc;
				//GS_desc1 = For_label+" "+code_desc;
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

		
		
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			
			//pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT C.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW C WHERE C.CONDITION_TYPE = A.CONDITION_TYPE AND LANGUAGE_ID = ?) CONDITION_TYPE_DESC, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.QUADRANT_SNO = ? AND NVL(STATUS,'X') != 'E' ORDER BY NS_TOOTH_NO ASC");
			
			//pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT C.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW C WHERE C.CONDITION_TYPE = A.CONDITION_TYPE AND LANGUAGE_ID = ?) CONDITION_TYPE_DESC, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.QUADRANT_SNO = ? AND NVL(STATUS,'X') != 'E' ORDER BY NS_TOOTH_NO ASC");

			//pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.QUADRANT_SNO = ? AND NVL(STATUS,'X') != 'E' ORDER BY NS_TOOTH_NO ASC");
			if(oh_chart_level.equals("E")){
				if(gingival_recording_by.equals("Q")){
					//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.QUADRANT_SNO = ? AND NVL(STATUS,'X') != 'E' ORDER BY NS_TOOTH_NO ASC");
					pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT C.MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = A.TOOTH_NO) MAPPED_TOOTH_NO, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE , A.STATUS FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.QUADRANT_SNO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Y'  AND NVL(STATUS,'X') != 'N' ORDER BY NS_TOOTH_NO ASC");
				}
				else{
					//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.SEXTENT_SNO = ? AND NVL(STATUS,'X') != 'E' ORDER BY NS_TOOTH_NO ASC");
					pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT C.MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = A.TOOTH_NO) MAPPED_TOOTH_NO, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE , A.STATUS FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.SEXTENT_SNO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Y'  AND NVL(STATUS,'X') != 'N' ORDER BY NS_TOOTH_NO ASC");
				}
			
				pstmt.setString(1,tooth_numbering_system);
				pstmt.setString(2,locale);
				//pstmt.setString(3,locale);
				//pstmt.setString(3,facility_id);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,chart_num);
				pstmt.setString(5,quadrant_sno);
				rs = pstmt.executeQuery();
			}else{
				if(gingival_recording_by.equals("Q")){
					//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.QUADRANT_SNO = ? AND NVL(STATUS,'X') != 'E' ORDER BY NS_TOOTH_NO ASC");
					pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT C.MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = A.TOOTH_NO) MAPPED_TOOTH_NO, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE , A.STATUS FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.QUADRANT_SNO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Y'  AND NVL(STATUS,'X') != 'N' ORDER BY NS_TOOTH_NO ASC");
				}
				else{
					//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE  FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.SEXTENT_SNO = ? AND NVL(STATUS,'X') != 'E' ORDER BY NS_TOOTH_NO ASC");
					pstmt=con.prepareStatement("SELECT A.TOOTH_NO, (SELECT B.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE B.NUMBERING_SYSTEM = ? AND B.TOOTH_NO = A.TOOTH_NO) NS_TOOTH_NO, (SELECT C.MAPPED_TOOTH_NO FROM OH_TOOTH C WHERE C.TOOTH_NO = A.TOOTH_NO) MAPPED_TOOTH_NO, (SELECT D.GINGIVAL_STATUS_DESC FROM OH_GINGIVAL_STATUS_LANG_VW D WHERE D.GINGIVAL_STATUS_CODE = A.GINGIVAL_STATUS_CODE AND LANGUAGE_ID = ?) GINGIVAL_STATUS_DESC, A.VALUE , A.STATUS FROM  OH_RESTORATIVE_CHART_GING_STS A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID=? AND A.CHART_NUM = ? AND A.SEXTENT_SNO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Y' AND NVL(STATUS,'X') != 'N' ORDER BY NS_TOOTH_NO ASC");
				}
			
				pstmt.setString(1,tooth_numbering_system);
				pstmt.setString(2,locale);
				//pstmt.setString(3,locale);
				//pstmt.setString(3,facility_id);
				pstmt.setString(3,other_chart_facility_id);
				pstmt.setString(4,patient_id);
				pstmt.setString(5,chart_num);
				pstmt.setString(6,quadrant_sno);
				rs = pstmt.executeQuery();	
					
			}
	%>
		
			<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
				<form name="PeridontalSummary" id="PeridontalSummary" method="post" target="messageFrame">
				
					<table width="96%" cellpadding =4 cellspacing='1' border='0' align='center' valign='center'>
						
						<%
							while(rs!= null && rs.next()){
								ns_tooth_no = checkForNull(rs.getString("NS_TOOTH_NO"));
								gingival_status_desc = checkForNull(rs.getString("GINGIVAL_STATUS_DESC"));
								gingival_status_value = checkForNull(rs.getString("VALUE"));
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
						//	}
								//
						%>
								<tr>
									<td width="25%" class='LABEL'><%=ns_tooth_no%></td>
									<td width="25%" class='LABEL'><%=gingival_status_desc%></td>
									<td width="25%" class='LABEL'><%=gingival_status_value%></td>
								</tr>
						<%
							}
						%>
						
					</table>
					
					<br>
					<table align="center" width="96%">
						<tr>
							<!-- <td width="35%" class='LABEL'><fmt:message key="eOH.NoOfConditionsRecorded.Label" bundle="${oh_labels}"/></td> -->
							<td width="35%" class='LABEL'><fmt:message key="eOH.NoOfToothsRecordedFor.Label" bundle="${oh_labels}"/> <%=code_desc%></td>
							<td width="15%" class='LABEL'><%=th_count%></td>
						</tr>
						<tr>
							<td width="35%" class='LABEL'><fmt:message key="eOH.SumOfGingivalStatus.Label" bundle="${oh_labels}"/> <%=code_desc%></td>
							<td width="15%" class='LABEL'><%=gs_count%></td>
						</tr>
						<tr>
							<td width="35%" class='LABEL'><fmt:message key="eOH.AvgOfGingivalStatus.Label" bundle="${oh_labels}"/> <%=code_desc%></td>
							<td width="15%" class='LABEL'>
							<%
								if(th_count_int > 0){
									out.println(format_decimal((gs_count_int/th_count_int),2));
								}
								else{
									out.println(th_count_int);
								}
							%>
							
							</td>
						</tr>
					</table>
					<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
					<input type="hidden" name="chart_num" id="chart_num" value="<%=chart_num%>">
					<input type="hidden" name="tooth_numbering_system" id="tooth_numbering_system" value="<%=tooth_numbering_system%>">
					<input type="hidden" name="called_from_viewchart_yn" id="called_from_viewchart_yn" value="Y">
					<input type="hidden" name="called_from_viewchart_gingival" id="called_from_viewchart_gingival" value="N">
					<input type="hidden" name="oh_chart_level" id="oh_chart_level" value="<%=oh_chart_level%>">
					<input type="hidden" name="other_chart_facility_id" id="other_chart_facility_id" value="<%=other_chart_facility_id%>">

					
					
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



