<!DOCTYPE html>
<!DOCTYPE>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.io.*,java.sql.*,java.util.*,java.net.*,java.text.*,eMP.PatSearch.*,webbeans.eCommon.*, javax.naming.*,javax.ejb.*,java.rmi.*,javax.rmi.*" %>
<html>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8"); %>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<link type="text/css" rel="stylesheet" href="../../eIP/html/IPAdvBedMgmtStyle.css"/>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
			Connection con	= null;
			PreparedStatement	pstmt	= null;
			ResultSet rSet	= null;
			String bedWidth="";
			String bedHeight="";
			String vacantBed="";
			String occupiedBed="";
			String vacantPseudoBed="";
			String occupiedPseudoBed="";
			String blkdNonOverrideBed="";
			String blkdOverrideBed="";
			String reservedBed="";
			String occDepartedBed="";
			String bkdOverrideConfirmBed="";
			String bkdOverrideUnConfirmBed="";
			String bkdNonOverrideConfirmBed="";
			String bkdNonOverrideUnConfirmBed="";
			String room_clr="";
			try{
				con = ConnectionManager.getConnection(request);
				HashMap dataMap=eIP.IPAdvBedMgmtConfigBean.getBedConfSetupData(con);
				bedWidth=(String)dataMap.get("bed_img_width");
				bedHeight=(String)dataMap.get("bed_img_height");
				room_clr=(String)dataMap.get("room_clr");
				vacantBed=(String)dataMap.get("vacantBed_clr");
				occupiedBed=(String)dataMap.get("occupiedBed_clr");
				vacantPseudoBed=(String)dataMap.get("vacantPseudoBed_clr");
				occupiedPseudoBed=(String)dataMap.get("occupiedPseudoBed_clr");
				blkdNonOverrideBed=(String)dataMap.get("blkdNonOverrideBed_clr");
				blkdOverrideBed=(String)dataMap.get("blkdOverrideBed_clr");
				reservedBed=(String)dataMap.get("reservedBed_clr");
				occDepartedBed=(String)dataMap.get("occDepartedBed_clr");
				bkdOverrideConfirmBed=(String)dataMap.get("bkdOverrideConfirmBed_clr");
				bkdOverrideUnConfirmBed=(String)dataMap.get("bkdOverrideUnConfirmBed_clr");
				bkdNonOverrideConfirmBed=(String)dataMap.get("bkdNonOverrideConfirmBed_clr");
				bkdNonOverrideUnConfirmBed=(String)dataMap.get("bkdNonOverrideUnConfirmBed_clr");
				String vacantbed_text_clr=(String)dataMap.get("vacantbed_text_clr");
				String occupiedbed_text_clr=(String)dataMap.get("occupiedbed_text_clr");
				String vacantpseudobed_text_clr=(String)dataMap.get("vacantpseudobed_text_clr");
				String occupiedpseudobed_text_clr=(String)dataMap.get("occupiedpseudobed_text_clr");
				String blkdnonovrdbed_text_clr=(String)dataMap.get("blkdnonovrdbed_text_clr");
				String blkdovrdbed_text_clr=(String)dataMap.get("blkdovrdbed_text_clr");
				String reservedbed_text_clr=(String)dataMap.get("reservedbed_text_clr");
				String occdepartedbed_text_clr=(String)dataMap.get("occdepartedbed_text_clr");
				String bkdovrdconfirmbed_text_clr=(String)dataMap.get("bkdovrdconfirmbed_text_clr");
				String bkdovrdunconfirmbed_text_clr=(String)dataMap.get("bkdovrdunconfirmbed_text_clr");
				String bkdnonovrdconfirmbed_text_clr=(String)dataMap.get("bkdnonovrdconfirmbed_text_clr");
				String bkdnonovrduncnfrmbed_text_clr=(String)dataMap.get("bkdnonovrduncnfrmbed_text_clr");
		%>
		<table cellspacing=1 cellpadding=0 border='0' width='100%' height='100%' style='background:<%=room_clr%>'>			
		   <tr>
		   <td colspan='1' ><img src="../../eIP/images/BillPrepared.gif" align='left'></td>
		   <td class='label' colspan='11' align="left"><font size=1>&nbsp;<fmt:message key="eIP.DischargebillPrepared.label" bundle="${ip_labels}"/>
		   </td>
		   </tr>
			<tr>
				<td style="background:<%=vacantBed%>;color:<%=vacantbed_text_clr%>;width:2%;border:1px solid black;font-family:arial;font-size:10px;align:center;marginh:0px;padding:0px;"></td>
				<td class='label'><fmt:message key="Common.Vacant.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eIP.NormalBeds.label" bundle="${ip_labels}"/>&nbsp;</td>
				<td class='label' style="background:<%=occupiedBed%>;color:<%=occupiedbed_text_clr%>;width:2%;border:1px solid black;font-family:arial;font-size:10px;align:center;marginh:0px;padding:0px;"></td>
				<td class='label'><fmt:message key="Common.Occupied.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eIP.NormalBeds.label" bundle="${ip_labels}"/>&nbsp;</td>
				<td class='label' style="background:<%=vacantPseudoBed%>;color:<%=vacantpseudobed_text_clr%>;width:2%;border:1px solid black;font-family:arial;font-size:10px;align:center;marginh:0px;padding:0px;"></td><td class='label'><fmt:message key="Common.Vacant.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eIP.PseudoBabyBeds.label" bundle="${ip_labels}"/>&nbsp;</td>
				<td class='label' style="background:<%=occupiedPseudoBed%>;color:<%=occupiedpseudobed_text_clr%>;width:2%;border:1px solid black;font-family:arial;font-size:10px;align:center;marginh:0px;padding:0px;"></td><td class='label'><fmt:message key="Common.Occupied.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eIP.PseudoBabyBeds.label" bundle="${ip_labels}"/>&nbsp;</td>
				<td class='label' style="background:<%=blkdNonOverrideBed%>;color:<%=blkdnonovrdbed_text_clr%>;width:2%;border:1px solid black;font-family:arial;font-size:10px;align:center;marginh:0px;padding:0px;"></td><td class='label'><fmt:message key="Common.blocked.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eIP.Nonoverrideable.label" bundle="${ip_labels}"/>&nbsp;</td>
				<td class='label' style="background:<%=blkdOverrideBed%>;color:<%=blkdovrdbed_text_clr%>;width:2%;border:1px solid black;font-family:arial;font-size:10px;align:center;marginh:0px;padding:0px;"></td><td class='label'><fmt:message key="Common.blocked.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eIP.Overrideable.label" bundle="${ip_labels}"/>&nbsp;</td>
			</tr>
			<tr>					
				<td class='label' style="background:<%=reservedBed%>;color:<%=reservedbed_text_clr%>;width:2%;border:1px solid black;font-family:arial;font-size:10px;align:center;marginh:0px;padding:0px;"></td><td class='label'><fmt:message key="eIP.ReservedBeds.label" bundle="${ip_labels}"/></td>
				<td class='label' style="background:<%=occDepartedBed%>;color:<%=occdepartedbed_text_clr%>;width:2%;border:1px solid black;font-family:arial;font-size:10px;align:center;marginh:0px;padding:0px;"></td><td class='label'><fmt:message key="eIP.OcccupiedDeparted.label" bundle="${ip_labels}"/></td>
				<td class='label' style="background:<%=bkdOverrideConfirmBed%>;color:<%=bkdovrdconfirmbed_text_clr%>;width:2%;border:1px solid black;font-family:arial;font-size:10px;align:center;marginh:0px;padding:0px;"></td><td class='label'><fmt:message key="eIP.BookedOverrideableConfirmed.label" bundle="${ip_labels}"/></td>
				<td class='label' style="background:<%=bkdOverrideUnConfirmBed%>;color:<%=bkdovrdunconfirmbed_text_clr%>;width:2%;border:1px solid black;font-family:arial;font-size:10px;align:center;marginh:0px;padding:0px;"></td><td class='label'><fmt:message key="eIP.BookedOverrideableUnConfirmed.label" bundle="${ip_labels}"/></td>
				<td class='label' style="background:<%=bkdNonOverrideConfirmBed%>;color:<%=bkdnonovrdconfirmbed_text_clr%>;width:2%;border:1px solid black;font-family:arial;font-size:10px;align:center;marginh:0px;padding:0px;"></td><td class='label'><fmt:message key="eIP.BookedNonOverrideableConfirmed.label" bundle="${ip_labels}"/></td>
				<td class='label' style="background:<%=bkdNonOverrideUnConfirmBed%>;color:<%=bkdnonovrduncnfrmbed_text_clr%>;width:2%;border:1px solid black;font-family:arial;font-size:10px;align:center;marginh:0px;padding:0px;"></td><td class='label'><fmt:message key="eIP.BookedNonOverrideableUnConfirmed.label" bundle="${ip_labels}"/></td>
			</tr>
			<tr><td colspan='12'></td></tr>
		</table>
		<%
			if(rSet!=null)rSet.close();
			if(pstmt!=null)pstmt.close();
		}catch(Exception ex){
			ex.printStackTrace();
			try{
				con.rollback();
			}catch(Exception e){
				e.printStackTrace();
			}
		}finally{
			try{
				if(rSet!=null)rSet.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(con!=null)ConnectionManager.returnConnection(con,request); 
		}
		%>
	</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

