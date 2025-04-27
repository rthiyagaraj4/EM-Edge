<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<%
	StringBuffer opt=new StringBuffer();
	Connection	con	=	null;
	PreparedStatement	stmt	=	null;
	ResultSet	rs		=	null;
	con	=	ConnectionManager.getConnection(request);
	HttpSession httpSession = request.getSession(false);
	String bed_no="";
	String bed_type="";
	String bed_type_desc ="";
	String billing_group="";
	String title="";
	String blg_grp_name="";
	String elig_level="";	
	String high_bedtype_on_hosp_req_yn="N";
	String level_of_serv_for_bed_type="";
	String reqtRmks = "";//AMRI-CRF-0362
	String locale	= (String)session.getAttribute("LOCALE");
	String facility_id = (String)httpSession.getValue("facility_id");

	//Added by Rajesh V for ML-MMOH-CRF-0865
	String reasonForTransfer = request.getParameter("reasonForTransfer");
	if(reasonForTransfer == null){
		reasonForTransfer = "";
	}
	boolean defaultRequestBySetup = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","REQUEST_DEFAULT_BY_SETUP");
	String defaultRequest = "";

	try
	{
		//The following changes are done for Internationalisation Process
		request.setCharacterEncoding("UTF-8");
		bed_type=request.getParameter("bed_type");
		bed_no = request.getParameter("bed_no");
		billing_group = request.getParameter("billing_group");
		title = request.getParameter("title");

		String sql2 = "select HIGHER_BEDTYPE_ON_HOSP_REQ_YN from bl_parameters where OPERATING_FACILITY_ID='"+facility_id+"'";
		stmt = con.prepareStatement(sql2);
		rs = stmt.executeQuery();
		while(rs.next())
		{
			high_bedtype_on_hosp_req_yn = rs.getString(1);
		}
		if(high_bedtype_on_hosp_req_yn == null) high_bedtype_on_hosp_req_yn="N";

		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();

		sql2 = "select short_desc,elig_level_of_service from bl_blng_grp_lang_vw where language_id='"+locale+"' and BLNG_GRP_ID = '"+billing_group+"'";
		stmt = con.prepareStatement(sql2);
		rs = stmt.executeQuery();
		while(rs.next())
		{
			blg_grp_name = rs.getString("short_desc");
			elig_level  = rs.getString("ELIG_LEVEL_OF_SERVICE");
		}

		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();

		sql2 = "select short_desc from ip_bed_type_lang_vw where language_id='"+locale+"' and bed_type_code = '"+bed_type+"'";
		stmt = con.prepareStatement(sql2);
	    rs = stmt.executeQuery();
		while(rs.next())
		{
			bed_type_desc = rs.getString("short_desc");
		}
		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();

		if(high_bedtype_on_hosp_req_yn.equals("Y"))
		{
			sql2 = "select b.LEVEL_OF_SERVICE LEVEL_OF_SERVICE from bl_ip_bed_type a, bl_blng_class b where a.blng_class_code = b.blng_class_code and a.bed_type_code ='"+bed_type+"'";
			stmt = con.prepareStatement(sql2);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				level_of_serv_for_bed_type = rs.getString("LEVEL_OF_SERVICE");
			}
			if(level_of_serv_for_bed_type == null ) level_of_serv_for_bed_type="";
			if (rs!=null) rs.close();
			if (stmt!=null) stmt.close();

			sql2 = "select a.bed_type_code, c.short_desc from bl_ip_bed_type a, bl_blng_class b, ip_bed_type_lang_vw c where c.language_id='"+locale+"' and a.blng_class_code = b.blng_class_code and a.bed_type_code = c.bed_type_code and b.level_of_service <= '"+elig_level+"' and b.level_of_service > '"+level_of_serv_for_bed_type+"'";
		}
		else
		{
			sql2 = "select a.bed_type_code, c.short_desc from bl_ip_bed_type a, bl_blng_class b, ip_bed_type_lang_vw c where c.language_id='"+locale+"' and a.blng_class_code = b.blng_class_code and a.bed_type_code = c.bed_type_code and b.level_of_service = '"+elig_level+"'";
		}

		stmt = con.prepareStatement(sql2);
	    rs = stmt.executeQuery();
		while(rs.next())
		{
			opt.append("<option value='"+rs.getString("bed_type_code")+"'>"+rs.getString("short_desc")+"</option>");			
		}
		
		if(defaultRequestBySetup && !"".equals(reasonForTransfer)){
			stmt = con.prepareStatement("Select blcommonproc.bl_transfer_type_default(?,?) from dual");
			stmt.setString(1, facility_id);
			stmt.setString(2, reasonForTransfer);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()){
				defaultRequest = rs.getString(1);
			}
		}		
		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
	}
	catch (Exception e)
	{ 
		e.printStackTrace();
		out.println ("Exception :"+e); 
	}
	finally
	{
		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
<title><%=title%></title>
	<script>
	var radioval = 'H';
	$(document).ready(function(){
	if($('#defaultRequest').val()=='H'){
	$('input:radio[name=bed_request]')[1].checked = true;
	radioval = 'H';
	dispReq();
	}
	});

	function storeVal(obj)
	{
		radioval = eval(obj).value;
	}
	function dispReq()
	{
	if(radioval == 'P')
	{
		document.getElementById('dispNameOnReq').innerText = "";
		document.getElementById('dispFieldOnReq').innerHTML = "<input type='hidden' name='BedTypeCode' id='BedTypeCode' value=''>";
	}
	else if(radioval == 'H')
	{
		//Added for authorization
		var retVal;
		var dialogHeight= "9" ;
		var dialogWidth	= "22" ;
		var dialogTop = "225" ;
		var center = "1" ;														   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;

		var arguments	= "" ;
		var tit	= getLabel("eBL.AUTH_SCREEN.label","BL");
		retVal=window.showModalDialog("../../eBL/jsp/BLBedTypeAuthMain.jsp?title="+tit,arguments,features);

		if(retVal=='1')
		{
			document.getElementById('dispNameOnReq').innerText = getLabel("eBL.BED_TYPE_FOR_CHARGING_BASIS.label","BL");
			document.getElementById('dispFieldOnReq').innerHTML = "<select name='BedTypeCode' id='BedTypeCode'><option value='--select--' selected>------"+getLabel('Common.defaultSelect.label','COMMON')+" ------</option><%=opt%></select>";
		}
		if(retVal=='0')
		{
			document.getElementById('dispNameOnReq').innerText = "";
			document.getElementById('dispFieldOnReq').innerHTML = "<input type='hidden' name='BedTypeCode' id='BedTypeCode' value=''>";
			document.getElementById("bed_request")[0].checked = true;
		}
		if(retVal!='0' && retVal!='1')
		{
			document.getElementById('dispNameOnReq').innerText = "";
			document.getElementById('dispFieldOnReq').innerHTML = "<input type='hidden' name='BedTypeCode' id='BedTypeCode' value=''>";
			document.getElementById("bed_request")[0].checked = true;
		}
		}
	}

	function validate(obj)
	{
		if(eval(obj).name == 'OK')
		{	
		if(document.forms[0].BedTypeCode.value != null || document.forms[0].BedTypeCode.value != '' )
		{	if(document.forms[0].BedTypeCode.value == '--select--')
		{	alert(getMessage("NO_SELECTION","IP"));
		return false;
		}
		else
		{	
			/*Modified by Rajesh V for ML-MMOH-CRF-0866 & AMRI-CRF-0362 for PAS Team*/
			var modified_bed_type = document.forms[0].BedTypeCode.value;
			var modified_reqt_Rmks = document.forms[0].reqt_Rmks.value;						
			var returnArray = new Array();
			returnArray[0] = modified_bed_type;
			returnArray[1] = $('input:radio[name=bed_request]:checked').val();
			returnArray[2] =modified_reqt_Rmks;
			parent.document.getElementById('dialog-body').contentWindow.returnValue =returnArray;
			parent.document.getElementById('dialog_tag').close();
		}
		}				
		}
		else if(eval(obj).name == 'CANCEL')
		{
			parent.document.getElementById('dialog-body').contentWindow.returnValue='close';
			parent.document.getElementById('dialog_tag').close();
		}
	}

	//AMRI-CRF-0362 Starts
	function textAreaLimit(field, maxlen) {
		if (field.value.length > maxlen + 1)
		alert('Should not be more than  '+maxlen+" characters");
		if (field.value.length > maxlen)
		field.value = field.value.substring(0, maxlen);
	}
	//AMRI-CRF-0362 Ends
	</script>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
<br>
<table width='100%' border='0' cellspacing='0' cellpadding='3' align='center'>
	<tr>
		<td class='label'  width='25%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
		<td class='fields'  width='25%'><%=blg_grp_name%></td>
		<td class='label' width='25%' ><fmt:message key="eBL.ELIG_LEVEL.label" bundle="${bl_labels}"/></td>
		<td class='fields' width='25%'><%=elig_level%></td>
	</tr>
	<tr>
		<td class='label' width="25%">
			<fmt:message key="Common.bedno.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' width="25%"><%=bed_no%></td>
		<td class='label' width="25%">
			<fmt:message key="Common.bedtype.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' width="25%"><%=bed_type_desc%></td>
	</tr>
	<tr>
		<td class='label' width="25%">
		<td class='label' width="25%">
		<td class='label' width="25%">
		<td class='label' width="25%">
	</tr>
</table>

<table width='100%' border='0' cellspacing='0' cellpadding='3' align='center'>
	<tr>
		<td  class='fields'><fmt:message key="eBL.HIGHER_CLASS_CHARGE_BASIS_TITLE.label" bundle="${bl_labels}"/></td>
	</tr>
</table>
<table width='100%' border='0' cellspacing='0' cellpadding='3' align='center'>
<tr>
	<td class='label' width="25%">
	<td class='label' width="25%">
	<td class='label' width="25%">
	<td class='label' width="25%">
</tr>
	<tr>
		<td  class='fields' width="25%"><input type='radio' name='bed_request' id='bed_request' value='P' onClick='storeVal(this);dispReq()'checked ><fmt:message key="eBL.PATIENT_REQUEST.label" bundle="${bl_labels}"/></td>
		<td  width="25%" class='label'><input type='radio' name='bed_request' id='bed_request' value='H' onClick='storeVal(this);dispReq()'><fmt:message key="eBL.HOSPITAL_REQUEST.label" bundle="${bl_labels}"/></td>
		<td  width="25%" class='label'></td>
		<td  width="25%" class='label'></td>
	</tr>
	<tr>		
		<td id = 'dispNameOnReq' class='label' width="40%"></td>
		<td id = 'dispFieldOnReq' class="fields" width="30%"><input type='hidden' name='BedTypeCode' id='BedTypeCode' value=''></td>
		<td  width="15%"></td>
		<td  width="15%"></td>
	</tr>
	<tr>
		<td  width="25%" class='label'></td>
		<td  width="25%" class='label'></td>
		<td  width="25%" class='label'></td>
		<td  width="25%" class='label'></td>
	</tr>

	<!-- AMRI-CRF-0362 Starts Here -->
	<tr>
		<td class='label' align="right">
		<fmt:message key="Common.Request.label" bundle="${common_labels}"/>
		<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
		</td>
		<td>
		<textarea name="reqt_Rmks" id="reqt_Rmks" value="<%=reqtRmks%>" rows="5" cols="60" onkeyup="textAreaLimit(this,250);"><%=reqtRmks%></textarea>
		</td>
	</tr>
	<!-- AMRI-CRF-0362 Ends Here -->

	<tr>
  	    <td  class='label' width="25%"></td>
		<td class='button'>
		<input type='button' name="OK" id="OK" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onClick='validate(this)' class='button'>
		<input type='button' name='CANCEL' id='CANCEL' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick='validate(this)' class='button'></td>		
		<td  class='label'></td>
		<td  class='label'></td>
	</tr>
</table>
</form>
	<input type= hidden name="locale" id="locale"  value='<%=locale%>'>
	<input type='hidden' name="defaultRequest" id="defaultRequest" id="defaultRequest" value="<%=defaultRequest%>">
</body>
</html>

