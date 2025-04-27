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

	String associate_code_lbl 			="";
	String  SPPRT_DIAG_SQL		="";
	String  supp_term_code			="";
	String  supp_term_set_id			="";
	String  term_code_short_desc	="";
	String  diagprob_code_val		="";
	String  supprt_diag_view			="";
	String  chk_disable					="";
	String long_desc						= "";// Added For Site Enhancement On 3/11/2010
	String long_desc_params			= "";// Added For Site Enhancement On 3/11/2010


	int j=0;

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
				diagprob_code_val	= checkForNull(request.getParameter("diagprob_code_val"));
				supprt_diag_view	 = checkForNull(request.getParameter("supprt_diag_view"));


				if(group_YN.equals("Y") && !Group_seq_no.equals("")){
					addl_criteria	="AND GROUP_SEQ_NO='"+Group_seq_no+"' ";
				}else{
					addl_criteria	="AND SUPPORT_SEQ_NO='"+support_seq_no+"' ";
				}

				if (associate_codes.equals("A")){
					associate_code_lbl	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Asterisk.label","mr_labels");
				}else if(associate_codes.equals("EC")){
					associate_code_lbl	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ExternalCause.label","mr_labels");
				}
				if(supprt_diag_view.equals("E")){
					chk_disable	="";
				}else{
					chk_disable	="disabled";
				}

		%>
		<form name="unlinked_supprt_diag_form" id="unlinked_supprt_diag_form" action="../../servlet/eMR.DPRecodingSupprtDiagServlet" method="post" target="targetFrame">
			<table width='100%' cellpadding='1' cellspacing='0' border='0' >
					<tr>
						<td colspan="4" class='PANELTOOLBAR'><%=associate_code_lbl%>&nbsp;<fmt:message key="eMR.unlinked.label" bundle="${mr_labels}"/></td>
					</tr>
					<tr></tr>
			</table>
			<div  style="position:relative;height:180px;overflow:auto">
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
									conn							= ConnectionManager.getConnection(request);
									SPPRT_DIAG_SQL	=	"SELECT B.EQUIVALENT_TERM_CODE SUPP_TERM_CODE,B.EQUIVALENT_TERM_SET_ID SUPP_TERM_SET_ID,A.SHORT_DESC,A.LONG_DESC FROM MR_EQUIVALENT_TERM_CODE B,MR_D_"+term_set+"_LANG_VW  A WHERE B.TERM_SET_ID = '"+term_set+"'AND B.TERM_CODE = '"+term_code+"'AND B.EQUIVALENT_TERM_SET_ID = '"+term_set+"' AND A.TERM_SET_ID=B.EQUIVALENT_TERM_SET_ID AND A.TERM_CODE=B.EQUIVALENT_TERM_CODE AND EQUIVALENT_TERM_CODE NOT IN (SELECT SUPP_TERM_CODE EQUIVALENT_TERM_CODE FROM MR_RECODE_SUPPORT_DIAG WHERE PATIENT_ID = '"+patient_id+"' AND ENCOUNTER_ID ='"+encounter_id+"' AND FACILITY_ID = '"+FacilityId+"'  AND STATUS='Y' "+addl_criteria+") AND A.LANGUAGE_ID='"+locale+"' ";
									pstmt=conn.prepareStatement(SPPRT_DIAG_SQL);
									rs	  = pstmt.executeQuery();
									while (rs.next()){
												String display_long_desc	 = "none";// Added For Site Enhancement On 3/11/2010
												supp_term_code	=	checkForNull(rs.getString("SUPP_TERM_CODE"));
												supp_term_set_id	=	checkForNull(rs.getString("SUPP_TERM_SET_ID"));
												term_code_short_desc	=	checkForNull(rs.getString("SHORT_DESC"));
												long_desc						=	checkForNull(rs.getString("LONG_DESC"));
												if(!(term_code_short_desc.equals(long_desc))){
													display_long_desc ="inline";
													long_desc_params  = supp_term_code+","+supp_term_set_id;
												}
										%>
										<tr>
											<td class="gridData" width='10%'><input type="checkbox" name="chk_unlinked_diag_<%=j%>" id="chk_unlinked_diag_<%=j%>" value="N" onclick="setValue('UNLINKED_DIAG',this)" <%=chk_disable%>><input type="hidden" name="hid_unlinked_diag_<%=j%>" id="hid_unlinked_diag_<%=j%>" value="N$#<%=supp_term_code%>$*<%=supp_term_set_id%>$*<%=term_code_short_desc%>"></td>
											<td class="gridData" width='25%'><%=supp_term_set_id%>&nbsp;/&nbsp;<%=supp_term_code%></td>
											<td class="gridData" style='WORD-BREAK:BREAK-ALL;' width='40%'><%=term_code_short_desc%></td>
											<td class="gridData" width='25%'><span nowrap title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")%>" style="cursor:pointer;display:<%=display_long_desc%>"><a href="javascript:showLongDescription('<%=long_desc_params%>')"><b>!</b></a></span>&nbsp;</td>
										<tr>
								<%
											j++;
										}
									if(pstmt!=null)pstmt.close();
									if(rs!=null)rs.close();
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
				<input type='hidden' name="total_records" id="total_records" value="<%=j%>">
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

