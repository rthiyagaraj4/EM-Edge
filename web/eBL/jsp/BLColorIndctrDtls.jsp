<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
20/07/2020 	  		       Ram kumar S											NMC-JD-CRF-0042
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
/*
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
------------------------------------------------------------------------------------------------------------------------------
1			 V210504			 17598			Common-ICN-0034				Mohana Priya K
2			 V230210							MMS-DM-CRF-0209.5			Namrata Charate
*/
%>
<%@ page contentType="text/html;charset=ISO-8859-1" import ="com.ehis.util.*,java.sql.*,java.util.*,java.net.*,java.text.*, eCommon.Common.*,org.json.simple.*, java.util.Map.Entry,java.util.Set,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,eBL.*,eBL.resources.*,webbeans.op.CurrencyFormat, java.io.*, java.text.SimpleDateFormat" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/> 
<html>
<head>
<%	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eBL/images/BLColorIndctr.css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eBL/js/BLColorIndctrDtls.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload="onLoadColorIndr();onPageLoad();" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%	
	Connection colCon = null;
	PreparedStatement colPstmt = null;
	ResultSet colRs = null;
	String modeType="insert";
	String facilityId  = (String) session.getValue("facility_id");
	String loginUser   = (String) session.getValue("login_user");
	HashMap colorTimeValues = new HashMap();
	java.util.Properties p=null;
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String WS_NO =p.getProperty("client_ip_address");
	boolean isMFDRApplicableForSite = false; 
	String mul_fact_ded_rule_YN = "N";
	String drug_cat_YN = "N";
	String diag_cat_YN = "N";
	String service_items_YN = "N"; //V230210
    
	try{		
			colCon=ConnectionManager.getConnection();
			
			try
			{
				isMFDRApplicableForSite = eCommon.Common.CommonBean.isSiteSpecific(colCon, "BL","DISP_MULTI_FACT_DED_RULE");	
			}catch(Exception e){
				e.printStackTrace();
			}
			System.err.println("isMFDRApplicableForSite "+isMFDRApplicableForSite);
			String mul_fact_ded_rule_YN_Qry = "SELECT NVL(MULTI_FACTOR_DED_RULE_APPL_YN,'N') MULTI_FACTOR_DED_RULE_APPL_YN, NVL(MFDR_DRUG_CAT_APPL_YN,'N') MFDR_DRUG_CAT_APPL_YN, NVL(MFDR_DIAG_CAT_APPL_YN,'N') MFDR_DIAG_CAT_APPL_YN, NVL(MFDR_SERV_ITEM_CAT_APPL_YN,'N') MFDR_SERV_ITEM_CAT_APPL_YN FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID = '"+facilityId+"'";   //V230210
			
			colPstmt=colCon.prepareStatement(mul_fact_ded_rule_YN_Qry);
			colRs= colPstmt.executeQuery();
			while(colRs.next()) { 
				mul_fact_ded_rule_YN = colRs.getString("MULTI_FACTOR_DED_RULE_APPL_YN");
				drug_cat_YN = colRs.getString("MFDR_DRUG_CAT_APPL_YN");
				diag_cat_YN = colRs.getString("MFDR_DIAG_CAT_APPL_YN");
				service_items_YN = colRs.getString("MFDR_SERV_ITEM_CAT_APPL_YN"); //V230210
			}
			
			colRs.close();
			colPstmt.close();			
		
			String colorPopulateQuery="SELECT REQUEST_STATUS,TIME_LIMIT,COLOR_CODE FROM BL_COLOR_INDICATOR_RULE_STATUS WHERE FACILITY_ID='"+facilityId+"'";

			colPstmt=colCon.prepareStatement(colorPopulateQuery);
			colRs= colPstmt.executeQuery();
			ResultSetMetaData colRsmd = colRs.getMetaData();
			int colColorNumber = colRsmd.getColumnCount();
			while(colRs.next()) { 
				colorTimeValues.put(colRs.getString("REQUEST_STATUS"),colRs.getString("TIME_LIMIT")+"~~"+colRs.getString("COLOR_CODE"));
				colorTimeValues.put(colRs.getString("REQUEST_STATUS"),colRs.getString("TIME_LIMIT")+"~~"+colRs.getString("COLOR_CODE"));
				colorTimeValues.put(colRs.getString("REQUEST_STATUS"),colRs.getString("TIME_LIMIT")+"~~"+colRs.getString("COLOR_CODE"));
				colorTimeValues.put(colRs.getString("REQUEST_STATUS"),colRs.getString("TIME_LIMIT")+"~~"+colRs.getString("COLOR_CODE"));
				colorTimeValues.put(colRs.getString("REQUEST_STATUS"),colRs.getString("TIME_LIMIT")+"~~"+colRs.getString("COLOR_CODE"));
				colorTimeValues.put(colRs.getString("REQUEST_STATUS"),colRs.getString("TIME_LIMIT")+"~~"+colRs.getString("COLOR_CODE"));
			}
			String penTimeLimit="",  penColorCode="";
			String insTimeLimit="",  insColorCode="";
			String holdTimeLimit="", holdColorCode="";
			String appTimeLimit="",  appColorCode="";
			String rejTimeLimit="",  rejColorCode="";
			String clarTimeLimit="", clarColorCode="";
			String []pensplit= new String[100];
			String []inssplit= new String[100];
			String []holdsplit= new String[100];
			String []appsplit= new String[100];
			String []rejsplit= new String[100];
			String []clarsplit= new String[100];
			if(colorTimeValues.size()!=0){
				modeType="update";
				//Getting Pending Status values
				String penValues=(String) colorTimeValues.get("P");
				pensplit=penValues.split("~~");
				penTimeLimit=pensplit[0];
				penColorCode=pensplit[1];
				//Getting Sent To Insurance Status values
				String insValues=(String) colorTimeValues.get("S");
				inssplit=insValues.split("~~");
				insTimeLimit=inssplit[0];
				insColorCode=inssplit[1];
				//Getting Hold Status values
				String holdValues=(String) colorTimeValues.get("H");
				holdsplit=holdValues.split("~~");
				holdTimeLimit=holdsplit[0];
				holdColorCode=holdsplit[1];
				//Getting Approved Status values
				String appValues=(String) colorTimeValues.get("A");
				appsplit=appValues.split("~~");
				appTimeLimit=appsplit[0];
				appColorCode=appsplit[1];
				//Getting Rejected Status values
				String rejValues=(String) colorTimeValues.get("R");
				rejsplit=rejValues.split("~~");
				rejTimeLimit=rejsplit[0];
				rejColorCode=rejsplit[1];
				//Getting Clarification Status values
				String clarValues=(String) colorTimeValues.get("C");
				clarsplit=clarValues.split("~~");
				clarTimeLimit=clarsplit[0];
				clarColorCode=clarsplit[1];
			}
			else{
				modeType="insert";
				penTimeLimit="00:00";  penColorCode="#FFFFFF";
				insTimeLimit="00:00";  insColorCode="#FFFFFF";
				holdTimeLimit="00:00"; holdColorCode="#FFFFFF";
				appTimeLimit="00:00";  appColorCode="#FFFFFF";
				rejTimeLimit="00:00";  rejColorCode="#FFFFFF";
				clarTimeLimit="00:00"; clarColorCode="#FFFFFF";
			}
%>
<form name='BLColorIndDtls' id='BLColorIndDtls' method='post' >
	<table cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<label><strong><fmt:message key="eBL.Record_Approval.label" bundle="${bl_labels}"/></strong></label>
		</td>
	</tr>
	<tr>
		<td>
			<table align="center" cellpadding="4" class='mainTable'>
				<tr>
				<td class='label' colspan="2" style="text-align=center;">
					<label><strong><fmt:message key="eBL.Request_Status.label" bundle="${bl_labels}"/></strong></label>
				</td>
				<td class='label' colspan="2" style="text-align=center;">
					<label><strong><fmt:message key="eBL.Time_Limit.label" bundle="${bl_labels}"/></strong></label>
				</td>
				<td class='label'  colspan="2" style="text-align=center;" cellpadding="1">
					<label style="text-align: end;"><strong><fmt:message key="eBL.Color_Indicaotr.label" bundle="${bl_labels}"/></strong></label>
				</td>
				</tr>
				<tr>
					<td class='fields' colspan="2" style="text-align=center;">
						<input type="text" name="reqStatus1" id="reqStatus1" style="width:130px;" value="Pending" readonly>
					</td>
					<td class='fields' width='100%' colspan="3" style="text-align=center;">
						<fmt:message key="eBL.HH_MM.label" bundle="${bl_labels}"/>
						<table>
							<tr>
								<td><input type="text" name="timeLimit1" id="timeLimit1"  value="<%=penTimeLimit%>" onchange="checkHHMM(this);" maxlength="5"></td>
								<td><img src='../../eCommon/images/mandatory.gif'></td>
							</tr>
						</table>	
					</td>
					<td class='fields' colspan="2" style="text-align=center;">
						<table>
							<tr>
								<td><input type="color" id="colInd1" name="colInd1"  value="<%=penColorCode.toUpperCase()%>" style="width:30px; padding-left: 28px;padding-right: 0px;padding-top: -1;padding-bottom: 0px;padding-top: 20px;" onfocus="this.blur()" readonly disabled ></td>
								<td><IMG id="colImg1" onclick='getColor("colInd1","colIndc1");' src="../../eBL/images/showColor.gif"></td>
								<input type="hidden" name="colIndc1" id="colIndc1" value="<%=penColorCode.toUpperCase()%>">
							</tr>	
						</table>
					</td>
				</tr>
				<tr>
					<td class='fields' colspan="2" style="text-align=center;">
						<input type="text" name="reqStatus2" id="reqStatus2" style="width:130px;" value="Sent To Insurance" readonly>
					</td>
					<td class='fields' colspan="3" style="text-align=center;">
						<fmt:message key="eBL.HH_MM.label" bundle="${bl_labels}"/>
						<table>
							<tr>
								<td><input type="text"  name="timeLimit2" id="timeLimit2" value="<%=insTimeLimit%>" onchange="checkHHMM(this);" maxlength="5"></td>
								<td><img src='../../eCommon/images/mandatory.gif'></td>
							</tr>
						</table>
					</td>
					<td class='fields' colspan="2" style="text-align=center;">
						<table>
							<tr>
								<td><input type="color" id="colInd2" name="colInd2" value="<%=insColorCode.toUpperCase()%>" style="width:30px; padding-left: 28px;padding-right: 0px;padding-top: -1;padding-bottom: 0px;padding-top: 20px;" onfocus="this.blur()" readonly disabled></td>
								<td><IMG id="colImg2" onclick='getColor("colInd2","colIndc2");' src="../../eBL/images/showColor.gif"></td>
								<input type="hidden" name="colIndc2" id="colIndc2" value="<%=insColorCode.toUpperCase()%>">
							</tr>	
						</table>
					</td>
				</tr>
				<tr>
					<td class='fields' colspan="2" style="text-align=center;">
						<input type="text" name="reqStatus3" id="reqStatus3" style="width:130px;" value="Hold" readonly>
					</td>
					<td class='fields' colspan="3" style="text-align=center;">
						<fmt:message key="eBL.HH_MM.label" bundle="${bl_labels}"/>
						<table>
							<tr>
								<td><input type="text" name="timeLimit3" id="timeLimit3"  value="<%=holdTimeLimit%>" onchange="checkHHMM(this);" maxlength="5"></td>
								<td><img src='../../eCommon/images/mandatory.gif'></td>
							</tr>
						</table>
					</td>
					<td class='fields' colspan="2" style="text-align=center;">
						<table>
							<tr>
								<td><input type="color"  name="colInd3" id="colInd3" value="<%=holdColorCode.toUpperCase()%>" style="width:30px; padding-left: 28px;padding-right: 0px;padding-top: -1;padding-bottom: 0px;padding-top: 20px;" onfocus="this.blur()" readonly disabled></td>
								<td><IMG id="colImg3" onclick='getColor("colInd3","colIndc3");' src="../../eBL/images/showColor.gif"></td>
							    <input type="hidden" name="colIndc3" id="colIndc3" value="<%=holdColorCode.toUpperCase()%>">
							</tr>	
						</table>
					</td>
				</tr>
				<tr>
					<td class='fields' colspan="2" style="text-align=center;">
						<input type="text" name="reqStatus4" id="reqStatus4" style="width:130px;" value="Approved" readonly>
					</td>
					<td class='fields' colspan="3" style="text-align=center;">
						<fmt:message key="eBL.HH_MM.label" bundle="${bl_labels}"/>
						<table>
							<tr>
								<td><input type="text" name="timeLimit4" id="timeLimit4" value="<%=appTimeLimit%>" onchange="checkHHMM(this);" maxlength="5"></td>
								<td><img src='../../eCommon/images/mandatory.gif'></td>
							</tr>
						</table>
					</td>
					<td class='fields' colspan="2" style="text-align=center;">
						<table>
							<tr>
								<td><input type="color" id="colInd4" name="colInd4" value="<%=appColorCode.toUpperCase()%>" style="width:30px; padding-left: 28px;padding-right: 0px;padding-top: -1;padding-bottom: 0px;padding-top: 20px;" onfocus="this.blur()" readonly disabled></td>
								<td><IMG id="colImg4" onclick='getColor("colInd4","colIndc4" );' src="../../eBL/images/showColor.gif"></td>
							    <input type="hidden" name="colIndc4" id="colIndc4" value="<%=appColorCode.toUpperCase()%>">
							</tr>	
						</table>
					</td>
				</tr>
				<tr>
					<td class='fields' colspan="2" style="text-align=center;">
						<input type="text" name="reqStatus5" id="reqStatus5" style="width:130px;" value="Rejected" readonly>
					</td>
					<td class='fields' colspan="3" style="text-align=center;">
						<fmt:message key="eBL.HH_MM.label" bundle="${bl_labels}"/>
						<table>
							<tr>
								<td><input type="text" name="timeLimit5"  id="timeLimit5" value="<%=rejTimeLimit%>" onchange="checkHHMM(this);" maxlength="5"></td>
								<td><img src='../../eCommon/images/mandatory.gif'></td>
							</tr>
						</table>
					</td>
					<td class='fields' colspan="2" style="text-align=center;">
						<table>
							<tr>
								<td><input type="color" id="colInd5" name="colInd5" value="<%=rejColorCode.toUpperCase()%>" style="width:30px; padding-left: 28px;padding-right: 0px;padding-top: -1;padding-bottom: 0px;padding-top: 20px;" onfocus="this.blur()" readonly disabled></td>
								<td><IMG id="colImg5" onclick='getColor("colInd5","colIndc5");' src="../../eBL/images/showColor.gif"></td>
							 <input type="hidden" name="colIndc5" id="colIndc5" value="<%=rejColorCode.toUpperCase()%>">
							</tr>	
						</table>
					</td>
				</tr>
				<tr>
					<td class='fields' colspan="2" style="text-align=center;">
						<input type="text" name="reqStatus6" id="reqStatus6"  style="width:130px;" value="Clarification" readonly>
					</td>
					<td class='fields' colspan="3" style="text-align=center;">
						<fmt:message key="eBL.HH_MM.label" bundle="${bl_labels}"/>
						<table>
							<tr>
								<td><input type="text" name="timeLimit6" id="timeLimit6" value="<%=clarTimeLimit%>" onchange="checkHHMM(this);" maxlength="5"></td>
								<td><img src='../../eCommon/images/mandatory.gif'></td>
							</tr>
						</table>	
					</td>
					<td class='fields'  colspan="2" style="text-align=center;">
						<table>
							<tr>
								<td><input type="color" id="colInd6" name="colInd6"  value="<%=clarColorCode.toUpperCase()%>" style="width:30px; padding-left: 28px;padding-right: 0px;padding-top: -1;padding-bottom: 0px;padding-top: 20px;" onfocus="this.blur()" readonly disabled></td>
								<td><IMG id="colImg6" onclick='getColor("colInd6","colIndc6");' src="../../eBL/images/showColor.gif"></td>
							    <input type="hidden" name="colIndc6" id="colIndc6" value="<%=clarColorCode.toUpperCase()%>">
							</tr>	
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
    </table>
	<%
	//V210504 Starts
		if(colPstmt != null) 	
			{
			colPstmt.close(); 	
			}
		if(colRs != null) 	
		{
			colRs.close(); 	
		}
		if(colCon!=null)
			{
				ConnectionManager.returnConnection(colCon, request);
			} //V210504 Ends
	}catch(Exception e){
		e.printStackTrace();
		System.err.println("Exception in BLColorIndctrDtls.jsp==>"+e);
	}
	%>
<input type="hidden" name="modeType" id="modeType" value="<%=modeType%>">
<input type="hidden" name="facilityId" id="facilityId" value="<%=facilityId%>">
<input type="hidden" name="loginUser" id="loginUser"  value="<%=loginUser%>">
<input type="hidden" name="WS_NO" id="WS_NO" value="<%=WS_NO%>">
<input type="hidden" name="finArrIds" id="finArrIds" value="">
<input type="hidden" name="mul_fact_ded_rule_YN" id="mul_fact_ded_rule_YN"  value="<%=mul_fact_ded_rule_YN%>">
<input type="hidden" name="is_mul_fact_ded_rule_mod" id="is_mul_fact_ded_rule_mod"  value="N">
<input type="hidden" name="isMFDRApplicableForSite" id="isMFDRApplicableForSite"  value='<%=isMFDRApplicableForSite?"Y":"N"%>'>
<input type="hidden" name="drug_cat_YN" id="drug_cat_YN"  value="<%=drug_cat_YN%>">
<input type="hidden" name="diag_cat_YN" id="diag_cat_YN"  value="<%=diag_cat_YN%>">
<input type="hidden" name="service_items_YN" id="service_items_YN"  value="<%=service_items_YN%>"> <!-- V230210 -->


</form>
</body>
</html>

