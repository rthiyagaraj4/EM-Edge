<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap" %>
<%
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	 String locale = (String)session.getAttribute("LOCALE"); 

	

	String term_set		=	"";
	String term_code	=	"";
	String term_set_lbl	=	"";
	String term_code_lbl	 =	"";

	String cal_from		=	"";
//	String eql_term_set		=	"";
//	String eql_term_code	=	"";
	String EncounterId		=	"";
	String facility_id			=	"";
	String stg_srl_no			=	"";
	String procedureYN		=	"";
	String accession_num		=	"";
	String contr_mod_id		=	"";
	String proc_type_lbl		=	"";
	String acces_num_facility	=	"";
	String acces_num				=	"";
	String acces_line_num		=	"";
	String mod_id_lbl				=	"";//Added On 2/8/2010 For a SCF
	cal_from		=	checkForNull(request.getParameter("cal_from"));   
	Connection con	 = null;
	PreparedStatement pstmt	= null;
	ResultSet rs	= null;
%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<body>
		<form name ='DiagEqualantCodeDesc' method='post'>
			<%
				try{
					con					=	ConnectionManager.getConnection(request);
					term_set			=	checkForNull(request.getParameter("term_set"));   
					term_code		=	checkForNull(request.getParameter("term_code"));
					EncounterId		=	checkForNull(request.getParameter("EncounterId"));
					stg_srl_no			=	checkForNull(request.getParameter("stg_srl_no"));
					procedureYN	=	checkForNull(request.getParameter("procedureYN"));
					accession_num	=	checkForNull(request.getParameter("accession_num"));
					contr_mod_id	=	checkForNull(request.getParameter("contr_mod_id"));
					term_set_lbl		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TerminologySet.label","common_labels");           
					term_code_lbl	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TerminologyCode.label","common_labels");
					proc_type_lbl	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels");
					facility_id			=	(String) session.getValue( "facility_id" ) ;
					if(contr_mod_id.equals("OT")){
						mod_id_lbl	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.OT.label","mr_labels");
					}else{
						mod_id_lbl	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NonOT.label","mr_labels");
					}
			%>
					<table width='100%' cellspacing='0' cellpadding='0' scrolling="no">
						<tr>
							<td class="label"><b><%=term_set_lbl%></b>:<b><%=term_set%></b></td> 
							<td class="label"><b><%=term_code_lbl%></b>:<b><%=term_code%></b></td> 
							<%if(!contr_mod_id.equals("")){%>
								<td class="label"><b><%=proc_type_lbl%></b>:<b><%=mod_id_lbl%></b></td> 
							<%}%>
						</tr>
						<tr><td class="label"></td> <td class="label"></td></tr>
						<tr><td class="label"></td> <td class="label"></td></tr>
					</table>
						<%if(cal_from.equals("Eq_Term_cd")){%>
						<table width='100%' cellspacing='0' cellpadding='0' scrolling="no">
							<th align='LEFT' ><fmt:message key="eMR.EquivalentTermSet.label" bundle="${mr_labels}"/></th>
							<th align='LEFT' ><fmt:message key="eMR.EquivalentCode.label" bundle="${mr_labels}"/></th>
							<th align='LEFTJa' ><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
						<%
								String eql_code_sql ="SELECT A.EQUIVALENT_TERM_SET_ID,A.EQUIVALENT_TERM_CODE,B.SHORT_DESC FROM MR_EQUIVALENT_TERM_CODE A,MR_TERM_CODE B WHERE A.TERM_SET_ID = '"+term_set+"' AND A.TERM_CODE = '"+term_code+"' AND A.CROSS_REF_TYPE = 'EQ' AND A.EQUIVALENT_TERM_SET_ID=B.TERM_SET_ID AND A.EQUIVALENT_TERM_CODE=B.TERM_CODE ";
								
								pstmt	= con.prepareStatement(eql_code_sql);
								rs			= pstmt.executeQuery();

								while(rs.next()){
									%>
										<tr>
											<td class="label" align="center"><%=checkForNull(rs.getString("EQUIVALENT_TERM_SET_ID"))%></td>
											<td class="label" align="center"><%=checkForNull(rs.getString("EQUIVALENT_TERM_CODE"))%></td>
											<td class="label" align="center"><%=checkForNull(rs.getString("SHORT_DESC"))%></td>
										</tr>
								<%	
								}//End Of While%>
								</table>
								<%
										if(pstmt!=null) pstmt.close();
										if(rs!=null) rs.close();
										
						}else if(cal_from.equals("Sprt_Diag")){%>
						<table width='100%' cellspacing='0' cellpadding='0' scrolling="no">
							<th align='LEFT' ><fmt:message key="eMR.supporting.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.TermSet.label" bundle="${common_labels}"/> </th>
							<th align='LEFT' ><fmt:message key="eMR.supporting.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></th>
							<th align='LEFT' ><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
					
						<%
								String spprt_code_sql ="SELECT SUPP_TERM_SET_ID, SUPP_TERM_CODE,C.SHORT_DESC FROM PR_DIAGNOSIS_ENC_DTL A,PR_DIAGNOSIS_DETAIL B,MR_TERM_CODE C WHERE A.TERM_SET_ID = B.TERM_SET_ID AND A.TERM_CODE = B.TERM_CODE AND A.PATIENT_ID = B.PATIENT_ID AND A.OCCUR_SRL_NO = B.OCCUR_SRL_NO AND A.FACILITY_ID = '"+facility_id+"' AND A.ENCOUNTER_ID ='"+EncounterId+"' AND  B.TERM_SET_ID = '"+term_set+"' AND B.TERM_CODE ='"+term_code+"' AND B.SUPP_TERM_SET_ID=C.TERM_SET_ID AND B.SUPP_TERM_CODE=C.TERM_CODE ";
						
								
								pstmt	= con.prepareStatement(spprt_code_sql);
//								pstmt.setString(1,facility_id);
//								pstmt.setString(2,EncounterId);
//								pstmt.setString(3,term_set);
//								pstmt.setString(4,term_code);
								rs			= pstmt.executeQuery();

								while(rs.next()){
									%>
										<tr>
											<td class="label" align="center"><%=checkForNull(rs.getString("SUPP_TERM_SET_ID"))%></td>
											<td class="label" align="center"><%=checkForNull(rs.getString("SUPP_TERM_CODE"))%></td>
											<td class="label" align="center"><%=checkForNull(rs.getString("SHORT_DESC"))%></td>
										</tr>
								<%	
								}//End Of While
									%>
								</table>
								<%
										if(pstmt!=null) pstmt.close();
										if(rs!=null) rs.close();

						}else if(cal_from.equals("Remarks")){
								String	rmrks_code_sql="";%>
								<table width='100%' cellspacing='0' cellpadding='0' scrolling="no">
							<%if(procedureYN.equals("Y")){
								 rmrks_code_sql ="SELECT REMARKS FROM MR_PROCEDURE_RECODING_DTL WHERE PROC_CODE_SCHEME = '"+term_set+"' AND PROC_CODE = '"+term_code+"' AND ENCOUNTER_ID='"+EncounterId+"' AND STAGE_SRL_NO ='"+stg_srl_no+"' AND FACILITY_ID='"+facility_id+"' ";%>
								<th align='LEFT'><fmt:message key="eMR.DiagnosisRemarks.label" bundle="${mr_labels}"/></th> <!--modified by mujafar for ML-MMOH-CRF-1270 -->
						<%}else{
								 rmrks_code_sql ="SELECT REMARKS FROM MR_DIAGNOSIS_RECODING_DTL WHERE TERM_SET_ID = '"+term_set+"' AND TERM_CODE = '"+term_code+"'  AND ENCOUNTER_ID='"+EncounterId+"'  AND STAGE_SRL_NO ='"+stg_srl_no+"'  AND FACILITY_ID='"+facility_id+"'";
						%>
								<th align='LEFT' ><fmt:message key="eMR.DiagnosisRemarks.label" bundle="${mr_labels}"/></th> <!--modified by mujafar for ML-MMOH-CRF-1270 -->
						<%}%>
						<%
								pstmt	= con.prepareStatement(rmrks_code_sql);
//								pstmt.setString(1,term_set);
//								pstmt.setString(2,term_code);
//								pstmt.setString(3,EncounterId);
//								pstmt.setString(4,stg_srl_no);
//								pstmt.setString(5,facility_id);

								rs			= pstmt.executeQuery();
								while(rs.next()){%>
										<tr>
											<td class="label" align="left"><%=checkForNull(rs.getString("REMARKS"))%></td>
										</tr>
								<%	
									}//End Of While%>
								</table>
								<%
										if(pstmt!=null) pstmt.close();
										if(rs!=null) rs.close();
						}else if(cal_from.equals("AcessionNum")){
							String sql_order_cat			=	"";
								%>
								<table width='100%' cellspacing='0' cellpadding='0' scrolling="no">
								<th align='LEFT'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th>
								<th align='LEFT' ><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
								<%
								if(contr_mod_id.equals("OT")){
										StringTokenizer tkn_accion_num	= new StringTokenizer(accession_num,"$");
										acces_num_facility	=	tkn_accion_num.nextToken();
										acces_num				=	tkn_accion_num.nextToken();
										acces_line_num			=	tkn_accion_num.nextToken();
									sql_order_cat="SELECT A.OPER_CODE,B.ORDER_CATALOG_CODE,C.SHORT_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B, OR_ORDER_CATALOG C WHERE A.OPER_CODE = B.OPER_CODE AND   B.ORDER_CATALOG_CODE = C.ORDER_CATALOG_CODE AND A.OPERATING_FACILITY_ID = '"+acces_num_facility+"' AND   A.OPER_NUM ='"+acces_num+"' AND OPER_LINE_NUM ="+acces_line_num+" ";
								}else if(contr_mod_id.equals("RD")){
										StringTokenizer tkn_accion_num	= new StringTokenizer(accession_num,"$");
										acces_num_facility	=	tkn_accion_num.nextToken();
										acces_num				=	tkn_accion_num.nextToken();
										acces_line_num			=	tkn_accion_num.nextToken();
									sql_order_cat="SELECT A.EXAM_CODE,B.ORDER_CATALOG_CODE,C.SHORT_DESC FROM RD_EXAM_VIEW_REQUESTED A, RD_EXAMS B, OR_ORDER_CATALOG C  WHERE A.EXAM_CODE = B.EXAM_CODE  AND   B.ORDER_CATALOG_CODE = C.ORDER_CATALOG_CODE AND A.OPERATING_FACILITY_ID = '"+acces_num_facility+"'   AND   A.REQUEST_NUM ='"+acces_num+"'  AND REQUEST_LINE_NUM ="+acces_line_num+" ";
								}else if(contr_mod_id.equals("OR")){
										StringTokenizer tkn_accion_num	= new StringTokenizer(accession_num,"$");
//										acces_num_facility	=	tkn_accion_num.nextToken();
										acces_line_num			=	tkn_accion_num.nextToken();
										acces_num				=	tkn_accion_num.nextToken();
//									sql_order_cat="SELECT  A.ORDER_CATALOG_CODE, A.CATALOG_DESC SHORT_DESC FROM OR_ORDER_LINE A,OR_ORDER B  WHERE A.ACCESSION_NUM='"+acces_num+"' AND A.ACCESSION_LINE_NUM='"+acces_line_num+"' AND B.ORDERING_FACILITY_ID='"+acces_num_facility+"' AND A.ORDER_ID=B.ORDER_ID ";   
									sql_order_cat="SELECT ORDER_CATALOG_CODE, OR_GET_DESC.OR_ORDER_CATALOG(A.ORDER_CATALOG_CODE,'"+locale+"',1) SHORT_DESC  from or_order_line A where ORDER_ID='"+acces_num+"' and ORDER_LINE_NUM='"+acces_line_num+"'";   
								}
									pstmt	= con.prepareStatement(sql_order_cat);
									rs			= pstmt.executeQuery();
									while(rs.next()){%>
											<tr>
												<td class="label" align="left"><%=checkForNull(rs.getString("ORDER_CATALOG_CODE"))%></td>
												<td class="label" align="left"><%=checkForNull(rs.getString("SHORT_DESC"))%></td>
											</tr>
								<%	
									}//End Of While%>
								</table>
								<%
										if(pstmt!=null) pstmt.close();
										if(rs!=null) rs.close();

						}%>
			<%}catch(Exception ex){
						ex.printStackTrace();
				}finally{
					if(pstmt!=null) pstmt.close();
					if(rs!=null) rs.close();
					ConnectionManager.returnConnection(con,request);
				}%>
		</form>
	</body>
</html>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

