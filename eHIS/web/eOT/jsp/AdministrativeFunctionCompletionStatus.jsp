<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

//String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8");

 String style = "";
				style = "color:blue;cursor:pointer";

%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
    String implant_entry_cmp_yn="";
	String consumable_entry_cmp_yn="";
	String equipment_entry_cmp_yn="";
	String instrument_entry_cmp_yn="";
	String finalize_implants_in="";
	String finalize_equp_in="";
	String finalize_instr_in="";
	String finalize_packs_in="";
	String rec_packs_in_admin_yn="";
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String facility_id=checkForNull(request.getParameter( "facility_id" )) ;
	String st_interface_flag="";
	String disable_impl_chk="";
	String disable_cons_chk="";
	String disable_eq_chk="";
	String disable_ic_chk="";
    Connection con=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	ResultSet rst1=null;
	ResultSet rst2=null;
	try{
	con = ConnectionManager.getConnection(request);
	//Modified by DhanasekarV on 29/03/2011

	String sql1="SELECT  NVL(IMPLANT_ENTRY_CMP_YN,'N'),NVL(CONSUMABLE_ENTRY_CMP_YN,'N'),NVL(EQUIPMENT_ENTRY_CMP_YN,'N'),NVL(INSTRUMENT_ENTRY_CMP_YN,'N')  FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID='"+facility_id+"'";
				pstmt1=con.prepareStatement(sql1);
				rst1=pstmt1.executeQuery();
				if(rst1 !=null && rst1.next())
				{
					
					implant_entry_cmp_yn=checkForNull(rst1.getString(1));
					consumable_entry_cmp_yn=checkForNull(rst1.getString(2));
					equipment_entry_cmp_yn=checkForNull(rst1.getString(3));
					instrument_entry_cmp_yn=checkForNull(rst1.getString(4));
				}
				String sql2="SELECT  FINALIZE_IMPLANTS_IN, FINALIZE_EQUP_IN, FINALIZE_INSTR_IN, FINALIZE_PACKS_IN,NVL(ST_INTERFACE_FLAG,'N'),NVL(REC_PACKS_IN_ADMIN_YN,'N')  FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID='"+facility_id+"'";
				pstmt2=con.prepareStatement(sql2);
				rst2=pstmt2.executeQuery();
				if(rst2 !=null && rst2.next())
				{
					finalize_implants_in=checkForNull(rst2.getString(1));
					finalize_equp_in=checkForNull(rst2.getString(2));
					finalize_instr_in=checkForNull(rst2.getString(3));
					finalize_packs_in=checkForNull(rst2.getString(4));
					st_interface_flag=checkForNull(rst2.getString(5));
					rec_packs_in_admin_yn=checkForNull(rst2.getString(6));
				}
				}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rst1!=null) rst1.close();
		if(rst2!=null) rst2.close();
		if(pstmt1!=null) pstmt1.close();
		if(pstmt2!=null) pstmt2.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
if(!("AF").equals(finalize_implants_in)) disable_impl_chk="disabled";
if(!("AF").equals(finalize_equp_in))     disable_eq_chk="disabled";
if(!("AF").equals(finalize_instr_in))    disable_ic_chk="disabled";
if(!("AF").equals(finalize_packs_in) || ("N").equals(rec_packs_in_admin_yn)) disable_cons_chk="disabled";
%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js" ></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
		<script Language="javascript" src="../../eOT/js/AdministrativeFunctionforAllCharges.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<form name="AdministrativeFunctionforAllChargesForm" id="AdministrativeFunctionforAllChargesForm">
					   <table width="100%" border="0" >
							<tr>
								<th align="left"><fmt:message key="eOT.CompletionStatus.Label" bundle="${ot_labels}"/> </th>
							</tr>
						</table>
						<table  width="100%" border="0" >
						<tr>
						<td class="label" width="25%"  nowrap >
						<fmt:message key="eOT.Prothesis/ImplantsCompleted.Label" bundle="${ot_labels}"/> 
						<%if(implant_entry_cmp_yn.equals("Y")){%>
							<input type='checkbox' name='pi_complete' id='pi_complete'  disabled checked>
						<%}else{%>
						<input type='checkbox' name='pi_complete' id='pi_complete'  onClick="setChkValue(this);" <%=disable_impl_chk%>>
						<%}%>
						</td>
						<td class="label" width="25%" nowrap >
						<fmt:message key="eOT.ConsumablesCompleted.Label" bundle="${ot_labels}"/> 
						<%if(consumable_entry_cmp_yn.equals("Y")){%>
						<input type='checkbox' name='cp_complete' id='cp_complete'  disabled checked>
						<%}else{%>
						<input type='checkbox' name='cp_complete' id='cp_complete'  onClick="setChkValue(this);" <%=disable_cons_chk%>>
						<%}%>
						</td>
						<td class="label" width="25%"  nowrap>
						<fmt:message key="eOT.EquipmentsCompleted.Label" bundle="${ot_labels}"/> 
						<%if(equipment_entry_cmp_yn.equals("Y")){%>
						<input type='checkbox' name='eq_complete' id='eq_complete'  disabled checked>
						<%}else{%>
						<input type='checkbox' name='eq_complete' id='eq_complete'  onClick="setChkValue(this);" <%=disable_eq_chk%>>
						<%}%>
						</td>
						<td class="label" width="25%" nowrap>
						<fmt:message key="eOT.Instruments/CSSDCompleted.Label" bundle="${ot_labels}"/> 
						<%if(instrument_entry_cmp_yn.equals("Y")){%>
						<input type='checkbox' name='ic_complete' id='ic_complete'  disabled checked>
						<%}else{%>
						<input type='checkbox' name='ic_complete' id='ic_complete'  onClick="setChkValue(this);" <%=disable_ic_chk%>>
						<%}%>
						</td>
                     
					    <td class="label" width="25%" nowrap>

						<input type="button" class="button" name="record" id="record"  align='left' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick="recordCharges();">
						
						</td>
						<tr>
						</table>
					    
						<input type='hidden' name='finalize_implants_in' id='finalize_implants_in' value="<%=finalize_implants_in%>">
						<input type='hidden' name='finalize_equp_in' id='finalize_equp_in' value="<%=finalize_equp_in%>">
						<input type='hidden' name='finalize_instr_in' id='finalize_instr_in' value="<%=finalize_instr_in%>">
						<input type='hidden' name='finalize_packs_in' id='finalize_packs_in' value="<%=finalize_packs_in%>">
						<input type='hidden' name='st_interface_flag' id='st_interface_flag' value="<%=st_interface_flag%>">
						</form>
	</body>
</html>

 

