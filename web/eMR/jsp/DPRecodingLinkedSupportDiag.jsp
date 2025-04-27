<!DOCTYPE html>
<!-- 
	1.Page was created for SRR-CRF-303.2
	2.For Recoding astriks for a Dagger.
	3.Created On 1/28/2010
-->  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap" %>
<%
	String sStyle					= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale					= checkForNull((String)session.getAttribute("LOCALE"));
	String FacilityId				= checkForNull((String) session.getValue( "facility_id" ));
	String associate_codes	= "";
	String calling_status		= "";
	String term_set				= "";
	String term_code			= "";
	String encounter_id		= "";
	String patient_id			= "";
	String occur_srl_no		= "";
	String stage_no_disp		= "";
	String support_seq_no	= "";
	String trx_no					= "";
	String Group_seq_no	= "";
	String group_YN			= "";
	String  addl_criteria		= "";

	String associate_code_lbl 			= "";
	String  SPPRT_DIAG_SQL		=	"";
	String  supp_term_code			="";
	String  supp_term_set_id			="";
	String  term_code_short_desc	="";
	String  supprt_diag_view			="";
	String  chk_disable					="";
	String long_desc						= "";// Added For Site Enhancement On 3/11/2010
	String long_desc_params			= "";// Added For Site Enhancement On 3/11/2010



	int i=0;


	Connection conn			= null;
	PreparedStatement pstmt		= null;
	ResultSet rs							= null;
%>
<html>
	<head>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eMR/js/DPRecoding.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	</head>
	<body>
		<%
				associate_codes	= checkForNull(request.getParameter("associate_codes"));
				calling_status		= checkForNull(request.getParameter("calling_status"));
				term_set				= checkForNull(request.getParameter("term_set"));
				term_code			= checkForNull(request.getParameter("term_code"));
				encounter_id			= checkForNull(request.getParameter("encounter_id"));
				patient_id				= checkForNull(request.getParameter("patient_id"));
				occur_srl_no			= checkForNull(request.getParameter("occur_srl_no"));
				stage_no_disp		= checkForNull(request.getParameter("stage_no_disp"));
				support_seq_no	= checkForNull(request.getParameter("support_seq_no"));
				trx_no					= checkForNull(request.getParameter("trx_no"));
				Group_seq_no		= checkForNull(request.getParameter("Group_seq_no"));
				group_YN				= checkForNull(request.getParameter("group_YN"));
				supprt_diag_view	 = checkForNull(request.getParameter("supprt_diag_view"));

				if(group_YN.equals("Y") && !Group_seq_no.equals("")){
					addl_criteria	="AND A.GROUP_SEQ_NO='"+Group_seq_no+"' ";
				}else{
					addl_criteria	="AND A.SUPPORT_SEQ_NO='"+support_seq_no+"' ";
				}




				
				if(calling_status.equals("ORIGINAL")){
					if (associate_codes.equals("A")){
						associate_code_lbl	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Asterisk.label","mr_labels");
						SPPRT_DIAG_SQL	= "SELECT A.SUPP_TERM_CODE,A.SUPP_TERM_SET_ID, B.SHORT_DESC,B.LONG_DESC FROM PR_SUPPORT_DIAGNOSIS A, MR_D_"+term_set+"_LANG_VW B WHERE B.TERM_CODE = A.SUPP_TERM_CODE AND A.PATIENT_ID = '"+patient_id+"'AND A.TERM_SET_ID = '"+term_set+"'AND B.TERM_SET_ID = '"+term_set+"' AND A.TERM_CODE = '"+term_code+"' AND A.OCCUR_SRL_NO = '"+occur_srl_no+"' AND B.LANGUAGE_ID='"+locale+"' ";
					}else if(associate_codes.equals("EC")){
						associate_code_lbl	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ExternalCause.label","mr_labels");
						SPPRT_DIAG_SQL	= "SELECT A.SUPP_TERM_CODE,A.SUPP_TERM_SET_ID, B.SHORT_DESC,B.LONG_DESC FROM PR_SUPPORT_DIAGNOSIS A, MR_D_"+term_set+"_LANG_VW B WHERE B.TERM_CODE = A.SUPP_TERM_CODE AND A.PATIENT_ID = '"+patient_id+"'AND A.TERM_SET_ID = '"+term_set+"'AND B.TERM_SET_ID = '"+term_set+"' AND A.TERM_CODE = '"+term_code+"' AND A.OCCUR_SRL_NO = '"+occur_srl_no+"' AND B.LANGUAGE_ID='"+locale+"' " ;
					}
				}else if(calling_status.equals("RECODE")){
					if (associate_codes.equals("A")){
						associate_code_lbl	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Asterisk.label","mr_labels");
						SPPRT_DIAG_SQL	= "SELECT A.SUPP_TERM_CODE,A.SUPP_TERM_SET_ID,B.SHORT_DESC,B.LONG_DESC FROM MR_RECODE_SUPPORT_DIAG A,MR_D_"+term_set+"_LANG_VW B WHERE A.PATIENT_ID = '"+patient_id+"' AND A.ENCOUNTER_ID='"+encounter_id+"' AND A.FACILITY_ID='"+FacilityId+"' AND A.TERM_SET_ID = '"+term_set+"' AND A.TERM_CODE = '"+term_code+"' AND A.OCCUR_SRL_NO = '"+occur_srl_no+"' AND A.STATUS='Y'  "+addl_criteria+" AND A.SUPP_TERM_CODE=B.TERM_CODE AND A.SUPP_TERM_SET_ID=B.TERM_SET_ID AND B.LANGUAGE_ID='"+locale+"'  ORDER BY SRL_NO ASC ";
					}else if(associate_codes.equals("EC")){
						associate_code_lbl	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ExternalCause.label","mr_labels");
						SPPRT_DIAG_SQL	= "SELECT A.SUPP_TERM_CODE,A.SUPP_TERM_SET_ID,B.SHORT_DESC,B.LONG_DESC FROM MR_RECODE_SUPPORT_DIAG A,MR_D_"+term_set+"_LANG_VW B WHERE A.PATIENT_ID = '"+patient_id+"' AND A.ENCOUNTER_ID='"+encounter_id+"' AND A.FACILITY_ID='"+FacilityId+"' AND A.TERM_SET_ID = '"+term_set+"'AND A.TERM_CODE = '"+term_code+"' AND A.OCCUR_SRL_NO = '"+occur_srl_no+"' AND A.STATUS='Y' "+addl_criteria+" AND A.SUPP_TERM_CODE=B.TERM_CODE AND A.SUPP_TERM_SET_ID=B.TERM_SET_ID AND B.LANGUAGE_ID='"+locale+"' ORDER BY SRL_NO ASC ";
					}				
				}
				if(supprt_diag_view.equals("E")){
					chk_disable	="";
				}else{
					chk_disable	="disabled";
				}
		%>
		<form name="linked_supprt_diag_form" id="linked_supprt_diag_form" action="../../servlet/eMR.DPRecodingSupprtDiagServlet" method="post" target="messageFrame">
			<table width='100%' cellpadding='1' cellspacing='0' border='0' >
				<tr>
					<td class='QUERYDATA' colspan='1' align='center'><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/>&nbsp;:&nbsp;<%=term_set%></td>
					<td class='QUERYDATA'><fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;:&nbsp;<%=term_code%></td>
				</tr>
			</table>
			<table width='100%' cellpadding='1' cellspacing='0' border='0' >
					<tr>
						<td colspan="4" class='PANELTOOLBAR'><%=associate_code_lbl%>&nbsp;<fmt:message key="eMR.linked.label" bundle="${mr_labels}"/></td>
					</tr>
					<tr></tr>
			</table>
			<div  style="position:relative;height:150px;overflow:auto">
				<table width='100%' cellpadding='1' cellspacing='0' border='0' >
					<thead id="TabHead">
						<tr style="position:relative;top:expression(this.offsetParent.scrollTop)" >
							<th align='left'><fmt:message key="eMR.Select.label" bundle="${mr_labels}"/></th>
							<th align='left' nowrap><fmt:message key="eMR.supporting.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.TermSet.label" bundle="${common_labels}"/>&nbsp;/&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
							<th align='left'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
							<th align='left' nowrap><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
						</tr>
						<tr></tr>
					</thead>
					<tbody>
						<%
							try{
								if(!SPPRT_DIAG_SQL.equals("")){
										conn							= ConnectionManager.getConnection(request);	
										pstmt=conn.prepareStatement(SPPRT_DIAG_SQL);
										rs	  = pstmt.executeQuery();
										while (rs.next()){
											String display_long_desc	 = "none";// Added For Site Enhancement On 3/11/2010
											supp_term_code			=	checkForNull(rs.getString("SUPP_TERM_CODE"));
											supp_term_set_id			=	checkForNull(rs.getString("SUPP_TERM_SET_ID"));
											term_code_short_desc	=	checkForNull(rs.getString("SHORT_DESC"));
											long_desc						=	checkForNull(rs.getString("LONG_DESC"));
											if(!(term_code_short_desc.equals(long_desc))){
												display_long_desc ="inline";
												long_desc_params = supp_term_code+","+supp_term_set_id;
											}
											%>
											<tr>
												<td class="gridData" width='10%'><input type="checkbox" name="chk_linked_diag_<%=i%>" id="chk_linked_diag_<%=i%>" value="Y" onclick="setValue('LINKED_DIAG',this)" checked <%=chk_disable%>><input type="hidden" name="hid_linked_diag_<%=i%>" id="hid_linked_diag_<%=i%>" value="Y$#<%=supp_term_code%>"></td>
												<td class="gridData" width='25%'><%=supp_term_set_id%>&nbsp;/&nbsp;<%=supp_term_code%></td>
												<td class="gridData" style='WORD-BREAK:BREAK-ALL;' width='40%'><%=term_code_short_desc%></td>
												<td class="gridData"width='25%'><span nowrap title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")%>" style="cursor:pointer;display:<%=display_long_desc%>"><a href="javascript:showLongDescription('<%=long_desc_params%>')"><b>!</b></a></span>&nbsp;</td>
											<tr>
									<%
												i++;
										}
										if(pstmt!=null)pstmt.close();
										if(rs!=null)rs.close();
									}
								}catch(Exception ex){
									ex.printStackTrace();
							}finally{
								ConnectionManager.returnConnection(conn,request);
								if(pstmt!=null)pstmt.close();
								if(rs!=null)rs.close();
							}
						%>
					</tbody>
				</table>
				<input type='hidden' name="total_records" id="total_records" value="<%=i%>">
			</div>
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

