<!DOCTYPE html>
<%
/*
Sr No           Version        Incident              SCF/CRF					Developer Name
1               V201125								MOHE-CRF-0050.3-US-004 		   Palani Narayanan
*/
%>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*, eBL.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <base target="_self">
<%
	HttpSession httpSession = request.getSession(false);
	String facility_id = "";	
	String locale			= (String)session.getAttribute("LOCALE");
	String login_user	= (String) session.getValue( "login_user" );
	String module_id=request.getParameter("module_id");
	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
	}
	catch(Exception eX)
	{
		out.println("Error= "+eX);
		eX.printStackTrace();
	}
	
Connection con = null;
PreparedStatement pstmt = null;
Statement stmt = null;
ResultSet rs = null;
con = ConnectionManager.getConnection(request); 
LinkedHashMap<String,String> itemPriceMap = new LinkedHashMap<String,String>();
LinkedHashMap<String,String> itemStatusMap = new LinkedHashMap<String,String>();
try{		
		String itmPrsLst  =  	BlRepository.getBlKeyValue("ITEAM_PRICE_LIST");
		pstmt = con.prepareStatement(itmPrsLst);
		pstmt.setString(1,login_user);
		rs = pstmt.executeQuery();
		
		if(rs!=null){
			while(rs.next()){
				itemPriceMap.put(rs.getString("id"),rs.getString("name"));				
			}	
		}
		
		pstmt = null;
		rs = null;
		String itemStatus  =  BlRepository.getBlKeyValue("ITEAM_PRICE_LIST_STATUS");
		pstmt = con.prepareStatement(itemStatus);
		pstmt.setString(1,module_id);
		pstmt.setString(2,locale);
		rs = pstmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				itemStatusMap.put(rs.getString("LIST_ELMT_VALUE"),rs.getString("List_Element"));
			}	
		}
		pstmt = null;
		rs = null;		
	}
	catch(Exception e)
	{
		out.println("Exception @ sys_date_wht_sec"+e);
		e.printStackTrace();
	}	
%>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='javascript' src='../js/BLAmount.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src='../js/PkgDef.js'></script> 
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/BLItemPriceList.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




<script>
var facility_id = '<%=facility_id%>';
function disable(bool,err_mess) {
	if(err_mess=="")
	{
		if (bool == true)
		{
			var process_label=getLabel("Common.processing.label","common");
			parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+process_label;
		}
	}
	else
	{
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+err_mess;
	}
}

function funFromItemCode() {	
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var title=getLabel("eBL.ItemCodeTitle.label","BL");
	title=encodeURIComponent(title);
	var column_sizes = escape("20%,80%");               
	var cashcntrcode=getLabel("eBL.ItemCode.label","BL");
	cashcntrcode=encodeURIComponent(cashcntrcode);
	var desc=getLabel("eBL.Description.label","BL");
	desc=encodeURIComponent(desc);
	var column_descriptions = cashcntrcode+","+desc;
	var locale=document.forms[0].locale.value;
	
	var sql = escape("select a.item_code ITM_CODE,short_desc ITM_DESC from bl_st_item a,mm_item_lang_vw b where nvl(status,'z')<>'c' and a.item_code=b.item_code and language_id='"+locale+"' and operating_facility_id='"+facility_id+"'");
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&target="+encodeURIComponent(document.forms[0].FromItemCode.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";
	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);
	var arr=new Array();
	if(retVal == null) retVal='';
	if (retVal != null || retVal!='')
	{
		var retVal=unescape(retVal);
		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");
			document.forms[0].FromItemCode.value = arr[0];
			document.getElementById('FromItem_desc').innerText= arr[1];
			}
		else
		{
			document.forms[0].FromItemCode.value = '';
			document.getElementById('FromItem_desc').innerText= '';
		}
	}
}

function funToItemCode() {	
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var title=getLabel("eBL.ItemCodeTitle.label","BL");
	title=encodeURIComponent(title);
	var column_sizes = escape("20%,80%");               
	var cashcntrcode=getLabel("eBL.ItemCode.label","BL");
	cashcntrcode=encodeURIComponent(cashcntrcode);
	var desc=getLabel("eBL.Description.label","BL");
	desc=encodeURIComponent(desc);
	var column_descriptions = cashcntrcode+","+desc;
	var locale=document.forms[0].locale.value;
	var sql = escape("select a.item_code ITM_CODE,short_desc ITM_DESC from bl_st_item a,mm_item_lang_vw b where nvl(status,'z')<>'c' and a.item_code=b.item_code and language_id='"+locale+"' and operating_facility_id='"+facility_id+"'");
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&target="+encodeURIComponent(document.forms[0].ToItemCode.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";
	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);
	var arr=new Array();
	if(retVal == null) retVal='';
	if (retVal != null || retVal!='')
	{
		var retVal=unescape(retVal);
		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");
			document.forms[0].ToItemCode.value = arr[0];
			document.getElementById('ToItem_desc').innerText= arr[1];
			}
		else
		{
			document.forms[0].ToIteamCode.value = '';
			document.getElementById('ToIteam_desc').innerText= '';
		}
	}
}

function funToItemCode() {	
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var title=getLabel("eBL.ItemCodeTitle.label","BL");
	title=encodeURIComponent(title);
	var column_sizes = escape("20%,80%");               
	var cashcntrcode=getLabel("eBL.ItemCode.label","BL");
	cashcntrcode=encodeURIComponent(cashcntrcode);
	var desc=getLabel("eBL.Description.label","BL");
	desc=encodeURIComponent(desc);
	var column_descriptions = cashcntrcode+","+desc;
	var locale=document.forms[0].locale.value;
	var sql = escape("select a.item_code ITM_CODE,short_desc ITM_DESC from bl_st_item a,mm_item_lang_vw b where nvl(status,'z')<>'c' and a.item_code=b.item_code and language_id='"+locale+"' and operating_facility_id='"+facility_id+"'");
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&target="+encodeURIComponent(document.forms[0].ToItemCode.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";
	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);
	var arr=new Array();
	if(retVal == null) retVal='';
	if (retVal != null || retVal!='')
	{
		var retVal=unescape(retVal);
		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");
			document.forms[0].ToItemCode.value = arr[0];
			document.getElementById('ToItem_desc').innerText= arr[1];
		}
		else
		{
			document.forms[0].ToIteamCode.value = '';
			document.getElementById('ToIteam_desc').innerText= '';
		}
	}
}

function funFromCreatAmendedBy() {	
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var title=getLabel("eBL.Users.label","BL");
	title=encodeURIComponent(title);
	var column_sizes = escape("20%,80%");               
	var column_descriptions = escape("Cash Counter Code,Description"); 
	var cashcntrcode=getLabel("eBL.CreatedAmendedCode.label","BL");
	cashcntrcode=encodeURIComponent(cashcntrcode);
	var desc=getLabel("eBL.CreatedAmendedName.label","BL");
	desc=encodeURIComponent(desc);
	var column_descriptions = cashcntrcode+","+desc;

	var locale=document.forms[0].locale.value;
	var sql = escape("select user_id CODE,username NAME from sy_user where facility_id='"+facility_id+"' and user_id in(select bl_user_id from bl_user where nvl(status,'N') != 'S' and operating_facility_id='"+facility_id+"') and nvl(status,'N') != 'S'");
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&target="+encodeURIComponent(document.forms[0].frmamendedBy_code.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";
	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);
	var arr=new Array();
	if(retVal == null) retVal='';
	if (retVal != null || retVal!='')
	{
		var retVal=unescape(retVal);
		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");
			document.forms[0].frmamendedBy_code.value = arr[0];
			document.getElementById('frmamendedBy_desc').innerText= arr[1];
		}
		else
		{
			document.forms[0].frmamendedBy_code.value = '';
			document.getElementById('frmamendedBy_desc').innerText= '';
		}
	}
}
	
function funToCreatAmendedBy() {	
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var title=getLabel("eBL.Users.label","BL");
	title=encodeURIComponent(title);
	var column_sizes = escape("20%,80%");               
	var cashcntrcode=getLabel("eBL.CreatedAmendedCode.label","BL");
	cashcntrcode=encodeURIComponent(cashcntrcode);
	var desc=getLabel("eBL.CreatedAmendedName.label","BL");
	desc=encodeURIComponent(desc);
	var column_descriptions = cashcntrcode+","+desc;
	var locale=document.forms[0].locale.value;
	var sql = escape("select user_id CODE,username NAME from sy_user where facility_id='"+facility_id+"' and user_id in(select bl_user_id from bl_user where nvl(status,'N') != 'S' and operating_facility_id='"+facility_id+"') and nvl(status,'N') != 'S'");
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&target="+encodeURIComponent(document.forms[0].toamendedBy_code.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";
	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);
	var arr=new Array();
	if(retVal == null) retVal='';
	if (retVal != null || retVal!='')
	{
		var retVal=unescape(retVal);
		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");
			document.forms[0].toamendedBy_code.value = arr[0];
			document.getElementById('toamendedBy_desc').innerText= arr[1];
	}
		else
		{
			document.forms[0].toamendedBy_code.value = '';
			document.getElementById('toamendedBy_desc').innerText= '';
		}
	}
}
	
function check_item() {
	if(document.forms[0].trdnamchk.checked) {
		document.forms[0].trdnamchk.value = 'Y';
	}
	else {
		document.forms[0].trdnamchk.value = 'N';
	}
}
function call_date_less_equal_chk(obj) {	
	if(!(obj.value==""))
	{
		var locale=document.forms[0].locale.value;
		var sysdate=getCurrentDate('DMY',locale);
		
		if(chkDtLessEqualThanSysDateNew(obj,sysdate))
		{	
			return true;
		}
		else
		{		
			return false;
		}
	}
	else
	{	
		return false;
	}
}

function call_date_less_equal_chk1(obj) {
	if(!(obj.value==""))
	{
		var locale=document.forms[0].locale.value;
		var sysdate=getCurrentDate('DMY',locale);
		
		if(chkDtLessEqualThanSysDateNew(obj,sysdate))
		{	
			//alert(getMessage("BL6015",'BL'));
			return true;
		}
		else
		{		
			return false;
		}
	}
	else
	{	
		return false;
	}
}

function chkDtLessEqualThanSysDateNew(entered_date,sys_date) {
	var locale=document.forms[0].locale.value;
	
	if(entered_date.value!="")
	{
		//CHANDED FROM DMY TO DMYHM 08/01/2021
		if((validDate(entered_date.value,'DMYHM',locale)))
		{
			var enteredDate = entered_date.value ;
			var sysDate = sys_date.value;
			//CHANDED FROM DMY TO DMYHM 08/01/2021
			if(isBeforeNow(enteredDate,'DMYHM',locale))
			{
				return true;
			}
			else
			{
				alert(getMessage("BL9114",'BL'));
				return false;
			}
		}
		else
		{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			entered_date.select();
			return false;
		}
	}
	else
	{
		return true;
	}
}

function toFromDateChk(obj) {
	if(!(obj.value==""))
	{	
		var sysdate=getCurrentDate('DMY',locale);
		var effFromDt = document.forms[0].FromdAmendedDate.value;
		var effToDt = document.forms[0].TodAmendedDate.value;
		if(checkDateBL(obj))
		{
			var locale=document.forms[0].locale.value;			
			if((!isBefore(effFromDt,effToDt,'DMY',locale)))
			{		
				alert(getMessage("BL1539",'BL'));
				obj.select();
			}
			else
			{	
				return false;
			}
		}
	}
	else
	{
		return false;
	}
}

function checkDateBL(entered_date) {
	var locale=document.forms[0].locale.value;
	if(entered_date.value!="")
	{
		if(validDate(entered_date.value,'DMY',locale))
		{
			return true;
		}
		else
		{	
			alert(getMessage("INVALID_DATE_FMT","SM"));
			entered_date.select();
			return false;
		}
	}
	else
	{
		return true;
	}
}
</script>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";		
		String facilityId		= (String) session.getValue( "facility_id" ) ;
 %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	onSelect="codeArrestThruSelect();">
	<form name='report_form' id='report_form' action='../../servlet/eBL.BLCashierReportServlet' method='post' target='dummyFrame'>
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>

	<tr>
			<td nowrap class='label'  ><fmt:message key="eBL.FacilityId.label" bundle="${bl_labels}"/></td>		
				<td nowrap class='fields'>
					<select name='itemprice' id='itemprice' style="width: 300px; ">	
				<%
				for (Iterator iterator = itemPriceMap.keySet().iterator(); iterator.hasNext();) {
					String type = (String) iterator.next();
						if(type.equals(facilityId)){
				%>	
					<option value='<%=type%>' selected><%=itemPriceMap.get(type) %></option>
						<%}
						else{%>
						<option value='<%=type%>'><%=itemPriceMap.get(type) %></option>
				<%}
					}
				%>
				</select>
	</td>
	</tr>
	<tr>
			<td nowrap class='label' ><fmt:message key="eBL.ItemType.label" bundle="${bl_labels}"/></td>
			<td   class='fields'>
				<select name='item_type' id='item_type' onchange=''>
					<option value='N'><fmt:message key="eBL.Drugs.label" bundle="${bl_labels}"/></option>
				   <option value='Y'><fmt:message key="eBL.Consumables.label" bundle="${bl_labels}"/></option>
				  </select>
			</td>
			<td nowrap class='label' ><fmt:message key="eBL.Status.label" bundle="${bl_labels}"/></td>
			<td nowrap class='fields'>
				<select name='itemstatus' id='itemstatus' style="width: 120px;">			
				<%
				for (Iterator iterator = itemStatusMap.keySet().iterator(); iterator.hasNext();) {
					String type = (String) iterator.next();
					if(type.equals("A")){
				%>	
					<option value='<%=type%>' selected><%=itemStatusMap.get(type) %></option>
					<%}
					else{%>
						<option value='<%=type%>'><%=itemStatusMap.get(type) %></option>
				<%}
				}
				%>
				</select>
			</td>			
	</tr>
	<tr>
			<td nowrap class='label' ><fmt:message key="eBL.TradeNameorBatch.label" bundle="${bl_labels}"/></td>
				<td nowrap><input type="checkbox"  id ="trdnamchk" name="trdnamchk" id="trdnamchk"  value="N"	onclick="check_item()" ></td>
		</tr>
		<tr>
				<td nowrap class='label' ><fmt:message key="eBL.FromItemCode.label" bundle="${bl_labels}"/></td>
			    <td nowrap class="fields"  >
				<input type='text' name='FromItemCode' id='FromItemCode' size='30' maxlength='40' value='' onBlur="funFromItemCode()">
					<input type='button' value='?' class='button' onClick="funFromItemCode()">
					
						</td>
					<td nowrap class='label' ><fmt:message key="eBL.ToItemCode.label" bundle="${bl_labels}"/></td>
			    <td  nowrap class="fields"  >
				<input type='text' name='ToItemCode' id='ToItemCode' size='30' maxlength='40' value='' onBlur="funToItemCode()">
					<input type='button' value='?' class='button' onClick="funToItemCode()">
				</td>
		</tr>
		<tr>
				<td nowrap class='label' ><fmt:message key="eBL.frmCreateAmendBy.label" bundle="${bl_labels}"/></td>
			    <td nowrap class="fields"  >
				<input type='text' name='frmamendedBy_code' id='frmamendedBy_code' size='30' maxlength='40' value='' onBlur="funFromCreatAmendedBy()">
				<input type='button' value='?' class='button' onClick="funFromCreatAmendedBy()">
					
				<td  class='label' ><fmt:message key="eBL.toCreateAmendBy.label" bundle="${bl_labels}"/></td>
			    <td nowrap class="fields"  >
				<input type='text' name='toamendedBy_code' id='toamendedBy_code' size='30' maxlength='40' value='' onBlur="funToCreatAmendedBy()">
					<input type='button' value='?' class='button' onClick="funToCreatAmendedBy()">
				</td>
		</tr>
		<tr>
				<td  nowrap class='label' ><fmt:message key="eBL.frmCreateAmendDate.label" bundle="${bl_labels}"/></td>
			    <td nowrap class="fields"  >
				<input type='text' name='FromdAmendedDate' id='FromdAmendedDate' size='30' maxlength='40' value='' onBlur='call_date_less_equal_chk(document.forms[0].FromdAmendedDate)'>
				<!--
				Below in show calendar hh:mm added for both From and To  AmendedDate
				-->
				<img onclick="return showCalendar('FromdAmendedDate','dd/mm/yyyy' ,'hh:mm');" src="../../eCommon/images/CommonCalendar.gif">
				</td>
				<td nowrap class='label' ><fmt:message key="eBL.toCreateAmendDate.label" bundle="${bl_labels}"/></td>
			    <td  class="fields"  >
				<input type='text' name='TodAmendedDate' id='TodAmendedDate' size='30' maxlength='40' value='' onBlur='call_date_less_equal_chk1(document.forms[0].TodAmendedDate)'>
				<img onclick="return showCalendar('TodAmendedDate','dd/mm/yyyy','hh:mm');" src="../../eCommon/images/CommonCalendar.gif">

		</tr>
		</tr>
	</table>
<input type= hidden name="locale" id="locale"  value='<%=locale%>'>
<input type= hidden name="facility_id" id="facility_id"  value='<%=facility_id%>'>
<input type= hidden name="log_rep_success_mes" id="log_rep_success_mes"  value=''>
<input type= hidden name="login_user" id="login_user"  value='<%=login_user%>'>
</form>
</body>
</html>

