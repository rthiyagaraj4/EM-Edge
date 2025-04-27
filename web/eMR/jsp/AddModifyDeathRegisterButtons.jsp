<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap" %>
<% 
	request.setCharacterEncoding("UTF-8"); 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String single_stage_death_reg_appl_yn="";// Getting from MR_Parameter Table.
	String visble_save_btn="";// To make visible or Hide of Save button,Based upon the value of  SINGLE_STAGE_DEATH_REG_APPL_YN.

%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script> 
		<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
		<script language='javascript' src="../../eMR/js/DeathRegister.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<script>
		async function callAuditTrail(){
			var dialogHeight= "1000px";
			var dialogWidth = "1000px";
			var dialogTop	= "100";
			var status = "no";
			var arguments	= "" ;			
			var patient = parent.frames[1].document.forms[0].patient_id.value;
			var encounter_id = parent.frames[1].document.forms[0].encounter_id.value;
			var facilityId = parent.frames[1].document.forms[0].facilityId.value;
			var features	= "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			var jsp_name;
			jsp_name = "../../eMR/jsp/ViewDeathRegisterAuditTrial.jsp?patient_id=" + patient+"&encounter_id="+encounter_id+"&facilityId="+facilityId;			
			retVal = await window.showModalDialog(jsp_name,arguments,features);

		}

		</script>
	</head>
	<%
		try{
			String finalize_yn				=	checkForNull(request.getParameter("finalize_yn"),"N");
			String call_from					=	checkForNull(request.getParameter("call_from"));
			String disable_btns="";
			String display_audit_btn="";
			String display_print_btn="";
			String mrdthcercount	= "";
			String MR_PARAM_SQL="SELECT SINGLE_STAGE_DEATH_REG_APPL_YN,(SELECT 1 FROM sm_report  WHERE report_id = 'MRDTHCER' and Module_id = 'MR') mrdthcercount FROM MR_PARAMETER";
			conn = ConnectionManager.getConnection(request);
			pstmt=conn.prepareStatement(MR_PARAM_SQL);
			rs=pstmt.executeQuery();
			while(rs.next()){
				single_stage_death_reg_appl_yn=checkForNull(rs.getString("SINGLE_STAGE_DEATH_REG_APPL_YN"));
				mrdthcercount=checkForNull(rs.getString("mrdthcercount"));
			}

			if(mrdthcercount.equals("")){
				display_print_btn	= "none;";
			}

			/*FYI:
			1.Based upon the parameter set up value wheather the MDR is to perfom single stage or multiple stage
			the below logic is used.
			2. if the parameter set to  'Y 'only finalize button will visible. if 'N' Both save and finalize buttons are visible.
			*/
			if(single_stage_death_reg_appl_yn.equals("Y")){
				visble_save_btn="hidden";
			}else{
				visble_save_btn="visible";
			}
			/*
				FYI:Once the MDR is finalized all the buttons are not visible.like wise the below logic works.	
			*/
			if(finalize_yn.equals("Y")){
				disable_btns="none";
			}else{
				disable_btns="";
			}
			/*
			FYI:If MDR is calling from IP Discharge Advice the audit trail button wouldnt visible.
			*/
			if(call_from.equals("IP_Discharge_Advice")){
				display_audit_btn="none";
			}else{
				display_audit_btn="";
			}
	%>
			<body>
				<form name="DR_Buttons_Form" id="DR_Buttons_Form">
					<table width='100%' cellpadding='1' cellspacing='0' border='0' >
							<tr>
								<td width='10%' class='fields' align='right'><input type="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AuditTrail.label","common_labels")%>' onclick="callAuditTrail();" style="display:<%=display_audit_btn%>"/></td>
								<td  width='90%' colspan="3" class='fields'></td>
								<td  class='fields' style="visibility:<%=visble_save_btn%>;display:<%=disable_btns%>"><input type="button"  name="save_btn" id="save_btn" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Save.label","common_labels")%>' onclick="Save('N')" /></td>
								<td  class='fields' style="display:<%=disable_btns%>"><input type="button" name="finalize_btn" id="finalize_btn" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Finalize.label","common_labels")%>' onclick="Save('Y')" / ></td>
								<td  class='fields' style="display:<%=display_print_btn%>"><input type="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' onclick="printMDRCertificate1()"/></td>
								<td  class='fields' style="display:<%=disable_btns%>"><input type="button" name="clear_btn" id="clear_btn" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onclick="resetValues();"/></td>
								<td  class='fields'><input type="button" name="close_btn" id="close_btn" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick="closeWindow();"/></td>

							</tr>
					</table>
					 <input type='hidden' id='deathCerApplYn' value='<%=mrdthcercount%>'></input><!--Added by Rameswar  Against  HSA-SCF-0143.1 [IN:055069]-->
				</form>
			</body>
	<%}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		ConnectionManager.returnConnection(conn,request);
	}%>
</html>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

