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
//	String FacilityId				= checkForNull((String) session.getValue( "facility_id" ));
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
	String associate_code_lbl 		= "";
	String  SPPRT_DIAG_SQL	=	"";
	String  supp_term_code			="";
	String  supp_term_set_id			="";
	String  term_code_short_desc	="";
	String  diagprob_code_val		="";
	String record_assosicate_codes_0	= "";
	String record_assosicate_codes_1	= "";
	String record_assosicate_codes_2	= "";
	String long_desc								= "";// Added For Site Enhancement On 3/11/2010
	String long_desc_params					= "";// Added For Site Enhancement On 3/11/2010

	HashMap suppor_diag_map	= new HashMap();
//	HashMap term_code_map	= new HashMap();



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
				encounter_id			= checkForNull(request.getParameter("EncounterId"));
				patient_id				= checkForNull(request.getParameter("patient_id"));
				occur_srl_no			= checkForNull(request.getParameter("occur_srl_no"));
				stage_no_disp		= checkForNull(request.getParameter("stage_no_disp"));
				support_seq_no	= checkForNull(request.getParameter("support_seq_no"));
				trx_no					= checkForNull(request.getParameter("trx_no"));
				diagprob_code_val		= checkForNull(request.getParameter("diagprob_code_val"));
				record_assosicate_codes_0		= checkForNull(request.getParameter("record_assosicate_codes_0"));
				record_assosicate_codes_1		= checkForNull(request.getParameter("record_assosicate_codes_1"));
				record_assosicate_codes_2		= checkForNull(request.getParameter("record_assosicate_codes_2"));

					if (associate_codes.equals("A")){
						associate_code_lbl	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Asterisk.label","mr_labels");
					}else if(associate_codes.equals("EC")){
						associate_code_lbl	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ExternalCause.label","mr_labels");
					}
				if(diagprob_code_val.equals("0")){
					if(!record_assosicate_codes_0.equals("")){
						StringTokenizer  str_ary= new StringTokenizer(record_assosicate_codes_0,"|@");
						while(str_ary.hasMoreTokens()){
							String	code_buf =str_ary.nextToken();
							StringTokenizer  str_ary_code= new StringTokenizer(code_buf,"$*");
							while(str_ary_code.hasMoreTokens()){
								String code =str_ary_code.nextToken();
								str_ary_code.nextToken();
								str_ary_code.nextToken();
								suppor_diag_map.put(code,code);// Both Key and Value is Same;
								
							}
						}
					}
				}else if(diagprob_code_val.equals("1")){
					if(!record_assosicate_codes_1.equals("")){
						StringTokenizer  str_ary= new StringTokenizer(record_assosicate_codes_1,"|@");
						while(str_ary.hasMoreTokens()){
							String	code_buf =str_ary.nextToken();
							StringTokenizer  str_ary_code= new StringTokenizer(code_buf,"$*");
							while(str_ary_code.hasMoreTokens()){
								String code =str_ary_code.nextToken();
								str_ary_code.nextToken();
								str_ary_code.nextToken();
								suppor_diag_map.put(code,code);// Both Key and Value is Same;
							}
						}
					}
				}else if(diagprob_code_val.equals("2")){
					if(!record_assosicate_codes_2.equals("")){
						StringTokenizer  str_ary= new StringTokenizer(record_assosicate_codes_2,"|@");
						while(str_ary.hasMoreTokens()){
							String	code_buf =str_ary.nextToken();
							StringTokenizer  str_ary_code= new StringTokenizer(code_buf,"$*");
							while(str_ary_code.hasMoreTokens()){
								String code =str_ary_code.nextToken();
								str_ary_code.nextToken();
								str_ary_code.nextToken();
								suppor_diag_map.put(code,code);// Both Key and Value is Same;
								
							}
						}
					}
				}
//					term_code_map.put(term_code,suppor_diag_map);

		%>
		<form name="record_supprt_diag_form" id="record_supprt_diag_form"  method="post" target="targetFrame">
			<table width='100%' cellpadding='1' cellspacing='0' border='0' >
					<tr>
						<td colspan="4" class='PANELTOOLBAR'><%=associate_code_lbl%>&nbsp;<fmt:message key="eMR.unlinked.label" bundle="${mr_labels}"/></td>
					</tr>
					<tr></tr>
			</table>
			<div  style="position:relative;height:300px;overflow:auto">
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
									String code_val	 ="";
									String code_status	 ="";
									conn							= ConnectionManager.getConnection(request);
									SPPRT_DIAG_SQL	=	"SELECT B.EQUIVALENT_TERM_CODE SUPP_TERM_CODE,B.EQUIVALENT_TERM_SET_ID SUPP_TERM_SET_ID,A.SHORT_DESC,A.LONG_DESC FROM MR_EQUIVALENT_TERM_CODE B,MR_D_"+term_set+"_LANG_VW A  WHERE B.TERM_SET_ID = '"+term_set+"'AND B.TERM_CODE = '"+term_code+"'AND B.EQUIVALENT_TERM_SET_ID = '"+term_set+"' AND A.TERM_SET_ID=B.EQUIVALENT_TERM_SET_ID AND A.TERM_CODE=B.EQUIVALENT_TERM_CODE AND A.LANGUAGE_ID='"+locale+"'  ";
									
									pstmt=conn.prepareStatement(SPPRT_DIAG_SQL);
									rs	  = pstmt.executeQuery();
									while (rs.next()){
												String display_long_desc	 = "none";// Added For Site Enhancement On 3/11/2010
												supp_term_code			=	checkForNull(rs.getString("SUPP_TERM_CODE"));
												supp_term_set_id			=	checkForNull(rs.getString("SUPP_TERM_SET_ID"));
												term_code_short_desc	=	checkForNull(rs.getString("SHORT_DESC"));
												long_desc						=	checkForNull(rs.getString("LONG_DESC"));

												if(suppor_diag_map.containsKey(supp_term_code)){
													code_val	="Y";
													code_status ="checked";
												}else{
													code_val	="N";
													code_status ="";
												}
												if(!(term_code_short_desc.equals(long_desc))){
													display_long_desc ="inline";
													long_desc_params  = supp_term_code+","+supp_term_set_id;
												}
										%>
										<tr>
											<td class="gridData" width='10%'><input type="checkbox" name="chk_unlinked_diag_<%=j%>" id="chk_unlinked_diag_<%=j%>" value="<%=code_val%>" onclick="setValue('UNLINKED_DIAG',this)" <%=code_status%>><input type="hidden" name="hid_unlinked_diag_<%=j%>" id="hid_unlinked_diag_<%=j%>" value="N$#<%=supp_term_code%>$*<%=supp_term_set_id%>$*<%=term_code_short_desc%>"></td>
											<td class="gridData" width='25'><%=supp_term_set_id%>&nbsp;/&nbsp;<%=supp_term_code%></td>
											<td class="gridData" width='40%' style='WORD-BREAK:BREAK-ALL;'><%=term_code_short_desc%></td>
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
				<input type='hidden' name="diagprob_code_val" id="diagprob_code_val" value="<%=diagprob_code_val%>">
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

