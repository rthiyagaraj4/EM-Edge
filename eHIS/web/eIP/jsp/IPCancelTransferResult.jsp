<!DOCTYPE html>
<!--Created by Thamizh selvi on 30th Mar 2017 against GDOH-CRF-0124-->
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eIP/js/IPCancelTransfer.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<%
		Connection con = null;
		try
		{
			con		= ConnectionManager.getConnection(request);	

			request.setCharacterEncoding("UTF-8");
			String locale					= (String)session.getAttribute("LOCALE");
			
			String class_val				= "QRYEVENSMALL";		
			String facility_id				= checkForNull((String)session.getValue("facility_id"));
			String patient_id				= checkForNull(request.getParameter("patient_id"));
			
			String pat_id="";
			String enc_id="";
			String srl_no="";
			String frm_serv_code="";
			String frm_bed_cls_code="";
			String frm_bed_cls_type="";
			String frm_pract_id="";
			String frm_spec_code="";
			String frm_sub_serv_code="";
			String trf_type="";

			String frm_nurs_unit_code="";
			String frm_nurs_unit_desc="";
			String frm_bed_class				= "";
			String frm_bed_type				= "";
			String frm_bed_no					= "";
			String frm_room_no					= "";
			
			String to_nurs_unit_code="";
			String to_nurs_unit="";
			String to_bed_class				= "";
			String to_bed_type				= "";
			String to_bed_no					= "";
			String to_room_no					= "";

			String modified_date				= "";
			String tfrReqRefNo					= "";

			JSONObject trfResultjsonObj = new JSONObject();

			trfResultjsonObj  = eIP.IPCancelTransferBean.getCancelTrfResult(con,patient_id,facility_id,locale);
			
			%>
			</head>
			<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
			<form name='CancelTransferResultForm' id='CancelTransferResultForm' method="post" action=""  target='messageFrame'>

			<%
			if(!trfResultjsonObj.isEmpty())
			{
				pat_id  = (String) trfResultjsonObj.get("patientId");
				enc_id  = (String) trfResultjsonObj.get("encounterId");
				
				srl_no  = (String) trfResultjsonObj.get("srlNum");
				frm_serv_code  = (String) trfResultjsonObj.get("frServCode");
				frm_bed_cls_code  = (String) trfResultjsonObj.get("frBedClsCode");
				frm_bed_cls_type  = (String) trfResultjsonObj.get("frBedTypeCode");
				frm_pract_id  = (String) trfResultjsonObj.get("frPractId");
				frm_spec_code  = (String) trfResultjsonObj.get("frSpecCode");
				frm_sub_serv_code  = (String) trfResultjsonObj.get("frSubServCode");
				trf_type  = (String) trfResultjsonObj.get("trfType");

				frm_nurs_unit_code  = (String) trfResultjsonObj.get("frmNursUtCode");
				frm_nurs_unit_desc  = (String) trfResultjsonObj.get("frmNursUtDesc");
				frm_bed_class  = (String) trfResultjsonObj.get("frmBedClsDesc");
				frm_bed_type  = (String) trfResultjsonObj.get("frmBedTypeDesc");
				frm_bed_no  = (String) trfResultjsonObj.get("frmBedNo");
				frm_room_no  = (String) trfResultjsonObj.get("frmRoomNo");

				to_nurs_unit_code  = (String) trfResultjsonObj.get("toNursUtCode");
				to_nurs_unit  = (String) trfResultjsonObj.get("toNursUt");
				to_bed_class  = (String) trfResultjsonObj.get("toBedClsDesc");
				to_bed_type  = (String) trfResultjsonObj.get("toBedTypeDesc");
				to_bed_no  = (String) trfResultjsonObj.get("toBedNo");
				to_room_no  = (String) trfResultjsonObj.get("toRoomNo");
				
				modified_date  = (String) trfResultjsonObj.get("modified_date");
				tfrReqRefNo  = (String) trfResultjsonObj.get("tfrReqRefNo");

				//String validate = "";
				//validate  = eIP.IPCancelTransferBean.validateForCancelTrf(con,enc_id,facility_id,frm_nurs_unit_code,frm_room_no,frm_bed_no);

			%>
			<table cellspacing='0' cellpadding='0' align='center' width='100%' border='1' >
				<tr>
					<td>
						<tr>
							<td width='2%' class="COLUMNHEADERCENTER" nowrap>&nbsp;</td>
							<td width='14%' class="COLUMNHEADERCENTER" align='center' nowrap>&nbsp;</td>
							<td width='14%' class="COLUMNHEADERCENTER" align='center' nowrap>&nbsp;</td>
							<td width='35%' class="COLUMNHEADERCENTER" colspan='5' align='center' nowrap><fmt:message key="eIP.FromDetails.label" bundle="${ip_labels}"/>&nbsp;</td>
							<td width='35%' class="COLUMNHEADERCENTER" colspan='5' align='center' nowrap><fmt:message key="eIP.ToDetails.label" bundle="${ip_labels}"/>&nbsp;</td>
						<tr>
						<tr>
							<td width='2%' class="COLUMNHEADERCENTER" nowrap>&nbsp;</td>
							<td width='14%' class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='14%' class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='7%' class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='7%' class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='7%' class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='7%' class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.roomno.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='7%' class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.bedno.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='7%' class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='7%' class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='7%' class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='7%' class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.roomno.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='7%' class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.bedno.label" bundle="${common_labels}"/>&nbsp;</td>
						</tr>		
							
				
						
				<%
					
						if(class_val.equals("QRYEVENSMALL"))
								class_val = "QRYODDSMALL";
						else
								class_val = "QRYEVENSMALL";
				%>
				<tr>
					<td class="<%=class_val%>" nowrap> <a href="javascript:showModalCurEnc('<%=enc_id%>','<%=patient_id%>','N')">+</a></td>
					<td width='14%' nowrap class='<%=class_val%>'><a href="javascript:showModalCancelTrf('<%=enc_id%>','<%=patient_id%>','<%=facility_id%>','<%=frm_nurs_unit_code%>','<%=frm_room_no%>','<%=frm_bed_no%>')"><%=enc_id%></td>
					<td width='14%' nowrap class='<%=class_val%>'><%=patient_id%></td>
					
					<td width='7%' nowrap class='<%=class_val%>'><%=frm_nurs_unit_desc%></td>
					<td width='7%' nowrap class='<%=class_val%>'><%=frm_bed_class%></td>
					<td width='7%' nowrap class='<%=class_val%>'><%=frm_bed_type%></td>
					<td width='7%' nowrap class='<%=class_val%>'><%=frm_room_no%></td>
					<td width='7%' nowrap class='<%=class_val%>'><%=frm_bed_no%></td>

					<td width='7%' nowrap class='<%=class_val%>'><%=to_nurs_unit%></td>
					<td width='7%' nowrap class='<%=class_val%>'><%=to_bed_class%></td>
					<td width='7%' nowrap class='<%=class_val%>'><%=to_bed_type%></td>
					<td width='7%' nowrap class='<%=class_val%>'><%=to_room_no%></td>
					<td width='7%' nowrap class='<%=class_val%>'><%=to_bed_no%></td>

				</tr>
				</td>
				</tr>
				</table>
			<%
			}
			else{%>
				<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
					parent.frames[3].location.href='../../eCommon/html/blank.html';
					parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
				</script>
			<%}
			%>
			
			<input type='hidden' name='srlNo' id='srlNo' value='<%=srl_no%>'>
			<input type='hidden' name='frmServCode' id='frmServCode' value='<%=frm_serv_code%>'>
			<input type='hidden' name='frmBedClsCode' id='frmBedClsCode' value='<%=frm_bed_cls_code%>'>
			<input type='hidden' name='frmBedClsType' id='frmBedClsType' value='<%=frm_bed_cls_type%>'>
			<input type='hidden' name='frmPractId' id='frmPractId' value='<%=frm_pract_id%>'>
			<input type='hidden' name='frmSpecCode' id='frmSpecCode' value='<%=frm_spec_code%>'>
			<input type='hidden' name='frmSubServCode' id='frmSubServCode' value='<%=frm_sub_serv_code%>'>
			<input type='hidden' name='trfType' id='trfType' value='<%=trf_type%>'>
	
			<input type='hidden' name='frmNursUtCode' id='frmNursUtCode' value='<%=frm_nurs_unit_code%>'>
			<input type='hidden' name='toNursUtCode' id='toNursUtCode' value='<%=to_nurs_unit_code%>'>
			<input type='hidden' name='frmRoomNo' id='frmRoomNo' value='<%=frm_room_no%>'>
			<input type='hidden' name='frmBedNo' id='frmBedNo' value='<%=frm_bed_no%>'>
			<input type='hidden' name='toRoomNo' id='toRoomNo' value='<%=to_room_no%>'>
			<input type='hidden' name='toBedNo' id='toBedNo' value='<%=to_bed_no%>'>
			
			<input type='hidden' name='modifiedDate' id='modifiedDate' value='<%=modified_date%>'>
			<input type='hidden' name='tfrReqRefNo' id='tfrReqRefNo' value='<%=tfrReqRefNo%>'>
			
			<input type='hidden' name='update' id='update' value=''>

			</form>
			</body>
		
			<%
		
				
		}catch(Exception e)
		{
			out.println(e);
			e.printStackTrace();
		}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}	
%>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString,String defaultValue)
	{
		return (inputString==null)	?	defaultValue :	inputString;
	}
%>

