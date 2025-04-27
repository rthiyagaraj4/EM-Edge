<!DOCTYPE html>
<!-- 
Sr No        Version           Incident        SCF/CRF             		Developer Name
---------------------------------------------------------------------------------------
1            V201109            	       MOHE-CRF-0050.3-US003          Ram kumar S
2            V201222            11806	   	MOHE-CRF-0050.3-US003          Ram kumar S
 -->

<%@ page
	import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*,  "
	contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="xmlObj" scope="page"
	class="webbeans.eCommon.XMLStringParser" />
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = 	(String)session.getAttribute("LOCALE");
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css' />
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/PriceListServicesReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
	String facilityId =	"";
	Connection con = ConnectionManager.getConnection();	
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try  
	{		 
		sStyle 	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		System.out.println("Locale  "+locale);
		facilityId =   (String) session.getValue( "facility_id" ) ;
		if(facilityId == null) facilityId="";
		String loginUser	= (String) session.getValue("login_user");
		if(loginUser == null) loginUser="";
		
		String str_module_id     =  request.getParameter("module_id");	
		if(str_module_id == null) str_module_id="";
		
		String facilitySql="SELECT a.acc_entity_name name, a.acc_entity_id   id "+
				"FROM   sy_acc_entity a,  sm_facility_for_user b "+
				"WHERE  b.facility_id = a.acc_entity_id  "+
				"AND b.appl_user_id = '"+loginUser+"' "+
				"ORDER BY 1";
		String priceIndSql="SELECT  NVL(B.LIST_ELMT_LABEL,A.LIST_ELMT_LABEL), A.LIST_ELMT_VALUE FROM  "+
				"SM_LIST_ITEM A, SM_LIST_ITEM_DESC B  "+
				"WHERE A.MODULE_ID = '"+str_module_id+"' "+
				" AND A.MODULE_ID = B.MODULE_ID (+) "+
				" AND A.LIST_REF = B.LIST_REF (+) "+
				" AND A.LIST_SRL_NO = B.LIST_SRL_NO (+) "+
				"AND A.LIST_REF = 'PRICE_IND' "+
				"AND UPPER(B.LANGUAGE_ID (+))  = upper('"+locale+"') "+
				"ORDER BY A.LIST_SRL_NO";
		String statusSql="SELECT  NVL(B.LIST_ELMT_LABEL,A.LIST_ELMT_LABEL) , A.LIST_ELMT_VALUE  "+
				"FROM SM_LIST_ITEM A, SM_LIST_ITEM_DESC B WHERE A.MODULE_ID = '"+str_module_id+"' "+
				"AND A.MODULE_ID = B.MODULE_ID AND A.LIST_REF = B.LIST_REF  "+
				"AND A.LIST_SRL_NO = B.LIST_SRL_NO  "+
				"AND A.LIST_REF ='STATUS_IND'  "+
				"AND B.LANGUAGE_ID   = '"+locale+"'  "+
				"ORDER BY A.LIST_SRL_NO";
		
		String groupBySql="SELECT  NVL(B.LIST_ELMT_LABEL,A.LIST_ELMT_LABEL), A.LIST_ELMT_VALUE FROM  "+
				 "SM_LIST_ITEM A, SM_LIST_ITEM_DESC B "+
				 "WHERE A.MODULE_ID = '"+str_module_id+"' "+
				 "AND A.MODULE_ID = B.MODULE_ID (+) "+
				 "AND A.LIST_REF = B.LIST_REF (+) "+
				 "AND A.LIST_SRL_NO = B.LIST_SRL_NO (+) "+
				 "AND A.LIST_REF ='GROUP_BY' "+
				 "AND UPPER(B.LANGUAGE_ID (+))  = upper('"+locale+"') "+
				 "ORDER BY A.LIST_SRL_NO";
%>

<body onKeyDown="lockKey();" onMouseDown="CodeArrest();"
	style="padding-left: 10px; padding-right: 10px; padding-top: 5px;">
	<form name="BillsPeriodSummaryForm" id="BillsPeriodSummaryForm" id="BillsPeriodSummaryForm"
		action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

		<table width="100%" CELLSPACING='0' cellpadding='3' align='center'>
			<tr>
				<td class="columnheader">Report Criteria</td>
			</tr>
		</table>
		<br>
		<table cellpadding='5' cellspacing='0' width="100%" align="center"
			border='0'>
			<tr>
				<td class="label" width="15%"><fmt:message
						key="Common.FacilityID.label" bundle="${bl_labels}" /></td><!-- V201222 Modifed -->
				<td colspan="3" class='fields'><select name="facility_ID" id="facility_ID"
					id="facility_ID" style="width: 370px;"><!-- V201222 Modifed -->
						<%
						pstmt = con.prepareStatement(facilitySql);
						rs = pstmt.executeQuery() ;
		while(rs.next())
		{
		%>
						<option value=<%=rs.getString("id")%>><%=rs.getString("name") %></option>
						<%
		}
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		%>
				</select></td>
			</tr>
			<tr>
				<td class="label" width="10%"><fmt:message
						key="eBL.PriceInd.label" bundle="${bl_labels}" /></td>
				<td class='fields'><select name="PriceInd" id="PriceInd" id="PriceInd"
					style="width: 100px;"><!-- V201222 Modifed -->
						<%
						pstmt = con.prepareStatement(priceIndSql);
						rs = pstmt.executeQuery() ;
						while(rs.next())
						{
						%>
						<option value=<%=rs.getString(2)%>><%=rs.getString(1) %></option>
						<%
						}
						if(pstmt!=null) pstmt.close();
						if(rs!=null) rs.close();
						%>
				</select></td>

				<td class="label" width="15%"><!-- V201222 Modifed -->
				<fmt:message
						key="Common.status.label" bundle="${bl_labels}" /></td>
				<td class='fields'><select name="status" id="status" id="status"
					style="width: 120px;">
						<%
						pstmt = con.prepareStatement(statusSql);
						rs = pstmt.executeQuery() ;
						while(rs.next())
						{
						%>
						<option value=<%=rs.getString(2)%>><%=rs.getString(1) %></option>
						<%
						}
						if(pstmt!=null) pstmt.close();
						if(rs!=null) rs.close();
						%>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"></td>
				<td class="label"><fmt:message key="eBL.StandardPrice.label"
						bundle="${bl_labels}" /></td>
				<td class='fields'><input type="checkbox" name="standardPrice" id="standardPrice"
					id="standardPrice" /></td>
			</tr>
			<tr>
				<td class="label" width="10%"><fmt:message
						key="eBL.FrmCustCode.label" bundle="${bl_labels}" /></td>
				<td class='fields'><input type="text" name="FrmCustCode" id="FrmCustCode"
					id="FrmCustCode" maxlength="50"
					onBlur="ChangeUpperCase( this );if(this.value!='') priceListCommonLookup(1,FrmCustCode,FrmCustCodeHid,'custCode');   else { FrmCustCodeHid.value =''; onBlurEvent('1'); }"
					onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
					<input type='button' class='button' name="FrmCustCodelookUp" id="FrmCustCodelookUp"
					id="FrmCustCodelookUp" value='?'
					onClick="priceListCommonLookup(1,FrmCustCode,FrmCustCodeHid,'custCode');toFromCheck(1)"
					tabindex='2' /> <input type="hidden" name="FrmCustCodeHid" id="FrmCustCodeHid"
					id="FrmCustCodeHid" value=""></td> <!-- V201222 Modifed -->
				<td class="label" width="10%"><fmt:message
						key="eBL.ToCustCode.label" bundle="${bl_labels}" /></td>
				<td class='fields'><input type="text" name="ToCustCode" id="ToCustCode"
					id="ToCustCode" maxlength="50"
					onBlur="ChangeUpperCase( this );if(this.value!='') priceListCommonLookup(2,ToCustCode,ToCustCodeHid,'custCode'); else  { ToCustCodeHid.value =''; onBlurEvent('1');}"
					onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
					<input type='button' class='button' name="ToCustCodelookUp" id="ToCustCodelookUp"
					id="ToCustCodelookUp" value='?'
					onClick="priceListCommonLookup(2,ToCustCode,ToCustCodeHid,'custCode');toFromCheck(1);"
					tabindex='2' /> <input type="hidden" name="ToCustCodeHid" id="ToCustCodeHid"
					id="ToCustCodeHid" value=""></td><!-- V201222 Modifed -->
			</tr>
			<tr>
				<td class="label" width="10%"><fmt:message
						key="eBL.FrmBillingGrp.label" bundle="${bl_labels}" /></td>
				<td class='fields'><input type="text" name="FrmBillingGrp" id="FrmBillingGrp"
					id="FrmBillingGrp" maxlength="50"
					onBlur="ChangeUpperCase( this );if(this.value!='') priceListCommonLookup(1,FrmBillingGrp,FrmBillingGrpHid,'billingGrp'); else  {FrmBillingGrpHid.value =''; onBlurEvent('2');}"
					onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
					<input type='button' class='button' name="FrmBillingGrplookUp" id="FrmBillingGrplookUp"
					id="FrmBillingGrplookUp" value='?'
					onClick="priceListCommonLookup(1,FrmBillingGrp,FrmBillingGrpHid,'billingGrp');toFromCheck(2);"
					tabindex='2' /> <input type="hidden" name="FrmBillingGrpHid" id="FrmBillingGrpHid"
					id="FrmBillingGrpHid" value=""></td><!-- V201222 Modifed -->
				<td class="label" width="10%"><fmt:message
						key="eBL.ToBillingGrp.label" bundle="${bl_labels}" /></td>
				<td class='fields'><input type="text" name="ToBillingGrp" id="ToBillingGrp"
					id="ToBillingGrp" maxlength="50"
					onBlur="ChangeUpperCase( this );if(this.value!='') priceListCommonLookup(2,ToBillingGrp,ToBillingGrpHid,'billingGrp'); else { ToBillingGrpHid.value =''; onBlurEvent('2');}" 
					onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
					<input type='button' class='button' name="ToBillingGrplookUp" id="ToBillingGrplookUp"
					id="ToBillingGrplookUp" value='?'
					onClick="priceListCommonLookup(2,ToBillingGrp,ToBillingGrpHid,'billingGrp');toFromCheck(2);"
					tabindex='2' /> <input type="hidden" name="ToBillingGrpHid" id="ToBillingGrpHid"
					id="ToBillingGrpHid" value=""></td><!-- V201222 Modifed -->
			</tr>
			<tr>
				<td class="label" width="10%"><fmt:message
						key="eBL.frmBillingClass.label" bundle="${bl_labels}" /></td>
				<td class='fields'><input type="text" name="frmBillingClass" id="frmBillingClass"
					id="frmBillingClass" maxlength="50"
					onBlur="ChangeUpperCase( this );if(this.value!='') priceListCommonLookup(1,frmBillingClass,FrmBillingClsHid,'billingCls');else  FrmBillingClsHid.value ='';"
					onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
					<input type='button' class='button' name="frmBillingClasslookUp" id="frmBillingClasslookUp"
					value='?'
					onClick="priceListCommonLookup(1,frmBillingClass,FrmBillingClsHid,'billingCls');toFromCheck(3);"
					tabindex='2' /> <input type="hidden" name="FrmBillingClsHid" id="FrmBillingClsHid"
					id="FrmBillingClsHid" value=""></td>
				<td class="label" width="10%"><fmt:message
						key="eBL.toBillingClass.label" bundle="${bl_labels}" /></td>
				<td class='fields'><input type="text" name="toBillingClass" id="toBillingClass"
					id="toBillingClass" maxlength="50"
					onBlur="ChangeUpperCase( this );if(this.value!='') priceListCommonLookup(2,toBillingClass,ToBillingClsHid,'billingCls');else  ToBillingClsHid.value ='';"
					onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
					<input type='button' class='button' name="toBillingClasslookUp" id="toBillingClasslookUp"
					value='?'
					onClick="priceListCommonLookup(2,toBillingClass,ToBillingClsHid,'billingCls');toFromCheck(3);"
					tabindex='2' /> <input type="hidden" name="ToBillingClsHid" id="ToBillingClsHid"
					id="ToBillingClsHid" value=""></td>
			</tr>
			<tr>
				<td class="label" width="10%"><fmt:message
						key="eBL.frmBillingServ.label" bundle="${bl_labels}" /></td>
				<td class='fields'><input type="text" name="frmBillingServ" id="frmBillingServ"
					id="frmBillingServ" maxlength="50"
					onBlur="ChangeUpperCase( this );if(this.value!='') priceListCommonLookup(1,frmBillingServ,frmBillingServHid,'billingServ');else  frmBillingServHid.value ='';"
					onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
					<input type='button' class='button' name="frmBillingServlookUp" id="frmBillingServlookUp"
					value='?'
					onClick="priceListCommonLookup(1,frmBillingServ,frmBillingServHid,'billingServ');toFromCheck(4);"
					tabindex='2' /> <input type="hidden" name="frmBillingServHid" id="frmBillingServHid"
					id="frmBillingServHid" value=""></td>
				<td class="label" width="10%"><fmt:message
						key="eBL.toBillingServ.label" bundle="${bl_labels}" /></td>
				<td class='fields'><input type="text" name="toBillingServ" id="toBillingServ"
					id="toBillingServ" maxlength="50"
					onBlur="ChangeUpperCase( this );if(this.value!='') priceListCommonLookup(2,toBillingServ,toBillingServHid,'billingServ');else  toBillingServHid.value ='';"
					onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
					<input type='button' class='button' name="toBillingServlookUp" id="toBillingServlookUp"
					value='?'
					onClick="priceListCommonLookup(2,toBillingServ,toBillingServHid,'billingServ');toFromCheck(4);"
					tabindex='2' /> <input type="hidden" name="toBillingServHid" id="toBillingServHid"
					id="toBillingServHid" value=""></td>
			</tr>
			<tr>
				<td class="label" width="10%"><fmt:message
						key="eBL.frmEffDate.label" bundle="${bl_labels}" /></td>
				<td class='fields'><input type="text" name="frmEffDate" id="frmEffDate"
					id="frmEffDate"  size="15" maxlength='10'  value=''
					onBlur='return dateRegEx(this);'><img
					src="../../eCommon/images/CommonCalendar.gif"
					onClick="return showCalendar('frmEffDate');"></td><!-- V201222 Modifed -->
				<td class="label" width="10%"><fmt:message
						key="eBL.toEffDate.label" bundle="${bl_labels}" />
				<td class='fields'><input type="text" name="toEffDate" id="toEffDate"
					id="toEffDate" size="15" maxlength='10' value=""
					onBlur="if(this.value!='') { dateRegEx(this); dateValidation(1);}"><img
					src="../../eCommon/images/CommonCalendar.gif"
					onClick="return showCalendar('toEffDate');"></td><!-- V201222 Modifed -->
				</td>
			</tr>
			<tr>
				<td class="label" width="10%"><fmt:message
						key="eBL.frmCreateAmendBy.label" bundle="${bl_labels}" /></td>
				<td class='fields'><input type="text" name="frmCreateAmendBy" id="frmCreateAmendBy"
					id="frmCreateAmendBy" maxlength="50"
					onBlur="ChangeUpperCase( this );if(this.value!='') priceListCommonLookup(1,frmCreateAmendBy,frmCreateAmendByHid,'CreateAmendBy');else  frmCreateAmendByHid.value ='';"
					onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
					<input type='button' class='button' name="frmCreateAmendBylookUp" id="frmCreateAmendBylookUp"
					value='?'
					onClick="priceListCommonLookup(1,frmCreateAmendBy,frmCreateAmendByHid,'CreateAmendBy');toFromCheck(5);"
					tabindex='2' /> <input type="hidden" name="frmCreateAmendByHid" id="frmCreateAmendByHid"
					id="frmCreateAmendByHid" value=""></td>
				<td class="label" width="10%"><fmt:message
						key="eBL.toCreateAmendBy.label" bundle="${bl_labels}" /></td>
				<td class='fields'><input type="text" name="toCreateAmendBy" id="toCreateAmendBy"
					id="toCreateAmendBy" maxlength="50"
					onBlur="ChangeUpperCase( this );if(this.value!='') priceListCommonLookup(2,toCreateAmendBy,toCreateAmendByHid,'CreateAmendBy');else  toCreateAmendByHid.value ='';"
					onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
					<input type='button' class='button' name="toCreateAmendBylookUp" id="toCreateAmendBylookUp"
					value='?'
					onClick="priceListCommonLookup(2,toCreateAmendBy,toCreateAmendByHid,'CreateAmendBy');toFromCheck(5);"
					tabindex='2' /> <input type="hidden" name="toCreateAmendByHid" id="toCreateAmendByHid"
					id="toCreateAmendByHid" value=""></td>
			</tr>
			<tr>
				<td class="label" width="10%"><fmt:message
						key="eBL.frmCreateAmendDate.label" bundle="${bl_labels}" /></td>
				<td class='fields'><input type="text" name="frmCreateAmendDate" id="frmCreateAmendDate"
					id="frmCreateAmendDate" size="15" maxlength='10'  value=''
					onBlur="if(this.value!='') { dateRegEx(this); dateValidation(2);}"><img
					src="../../eCommon/images/CommonCalendar.gif"
					onClick="return showCalendar('frmCreateAmendDate');"></td><!-- V201222 Modifed -->
				<td class="label" width="10%"><fmt:message
						key="eBL.toCreateAmendDate.label" bundle="${bl_labels}" />
				<td><input type="text" name="toCreateAmendDate" id="toCreateAmendDate"
					id="toCreateAmendDate"  size="15" maxlength='10'  value=''
					onBlur="if(this.value!='') { dateRegEx(this); dateValidation(3);}"><img
					src="../../eCommon/images/CommonCalendar.gif"
					onClick="return showCalendar('toCreateAmendDate');"></td><!-- V201222 Modifed -->
				</td>
			</tr>
			<tr>
				<td class="label"><fmt:message key="Common.groupby.label"
						bundle="${bl_labels}" /></td>
				<td class='fields'><select name="groupby" id="groupby" id="groupby"
					onchange="groupby(this)" style="width: 120px;">
						<option value="Select">-Select-</option>
						<%
						pstmt = con.prepareStatement(groupBySql);
						rs = pstmt.executeQuery() ;
						while(rs.next())
						{
						%>
						<option value=<%=rs.getString(2)%>><%=rs.getString(1) %></option>
						<%
						}
						if(pstmt!=null) pstmt.close();
						if(rs!=null) rs.close();
						%>
				</select></td>
			</tr>
		</table>
		<input type='hidden' name='locale' id='locale' id='locale' value="<%=locale%>">
		<input type='hidden' name='facilityId' id='facilityId' id='facilityId'
			value="<%=facilityId%>"> <input type="hidden"
			name="p_module_id" id="p_module_id" id="p_module_id" value="<%=str_module_id%>">
		<input type="hidden" name="p_report_id" id="p_report_id" id="p_report_id" value="">
		<input type="hidden" name="p_user_id" id="p_user_id" id="p_user_id"
			value="<%=loginUser%>"> <input type="hidden" name="pgm_id" id="pgm_id"
			id="pgm_id" value="">
	</form>
</body>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception in BLCollectSumryReport.jsp::"+e);
	}
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
</HTML>

