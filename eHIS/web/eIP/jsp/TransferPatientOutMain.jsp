<!DOCTYPE html>
<html>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*,com.ehis.util.*" %>

<%
request.setCharacterEncoding("UTF-8");
String locale				= (String)session.getAttribute("LOCALE");

Connection con				= null;
Statement stmt				= null;
PreparedStatement pstmt		= null;
ResultSet rset				= null;
try
{
	con						=	ConnectionManager.getConnection(request);
	String facilityId		=	checkForNull((String)session.getValue("facility_id"));
	String eid				=	checkForNull(request.getParameter("encounter_id"));
	String sdate			=   checkForNull(request.getParameter("sdate"));
	String admissiondate	=	checkForNull(request.getParameter("admissiondate"));
	String admissiontype	=	checkForNull(request.getParameter("admissiontype"));
	String status_value		=	checkForNull(request.getParameter("status_value"));
	String MAX_TRN_DATE_TIME=   checkForNull(request.getParameter("max_trn_date_time"));
	
	long    encounterid		=	Long.parseLong(eid);
	String call_function	=	request.getParameter("call_function");
	StringBuffer strBuffer	=	new StringBuffer();
	String admissiondate_converted = "";
	String sdate_converted	= "";
	String d_converted		= "";
	String trans_Type		= "";
	if(!(admissiondate.equals("") || admissiondate == null))
			admissiondate_converted = DateUtils.convertDate(admissiondate,"DMYHM","en",locale); 
	
	if(!(sdate.equals("") || sdate == null))
			sdate_converted = DateUtils.convertDate(sdate,"DMYHM","en",locale); 
	if(!(MAX_TRN_DATE_TIME.equals("") || MAX_TRN_DATE_TIME == null))
	MAX_TRN_DATE_TIME		= DateUtils.convertDate(MAX_TRN_DATE_TIME,"DMYHM","en",locale);

	boolean isCnrmReqPatOutChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","AUTO_CNRM_TFR_REQ_PAT_OUT_CHNG");//Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617
	
	boolean isArrivalDateAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","AR_DATE_IN_TR_PAT_IN_APPL_YN"); //Added by Mujafar for ML-MMOH-CRF-1136
%>

<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../js/TransferPatient.js" language="javascript"></script> 
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/DateUtils.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<script>
	
	//Added by Mujafar for ML-MMOH-CRF-1136 start
		function compareDates(obj,prefer_date)
		{
			if(obj.value!='' && prefer_date.value!='')
			{
				var arr_date = convertDate(obj.value,"DMYHM",localeName,"en");
				var prf_date = convertDate(prefer_date.value,"DMYHM",localeName,"en");
				
				
				if(!isAfter(arr_date,prf_date,'DMYHM','en'))
			  {
				 
				 var error = getMessage("DATE1_LT_DATE2","IP");
				 error = error.replace("$",getLabel("Common.ArrivalDateTime.label",'Common'));
				 error = error.replace("#",getLabel('eIP.PreferredDateTime.label','IP'));
				 alert(error);
				 obj.select();
				 obj.focus();
				 return false;
			  }
				
				
				
			}
			
		}
	
		 function validate_date(obj) 
		 {
				if(obj.value!=''){

					if(isBeforeNow(obj.value,"DMYHM",localeName))
						return true;
					else {
						
						var error = getMessage("DATE1_GT_DATE2","IP");
						error =  error.replace("$",getLabel("Common.ArrivalDateTime.label",'Common'));
						error =  error.replace("#", getLabel("Common.SystemDateTime.label",'Common'));
						alert(error);
						
						
						
						obj.select();
						obj.focus();
						return false ;
					}
				}
		}
		//Added by Mujafar for ML-MMOH-CRF-1136 end
		
	
		function validateBackDate(prefDate)
		{
			var max_trn_date_time = document.forms[0].max_trn_date_time.value;
			if (prefDate.value != ""  || prefDate.value != '')
			{
		 		if(!validDateObj(prefDate,"DMYHM",localeName))
				{
				 return ;
				}

				var greg_prefDateTime = convertDate(prefDate.value,'DMYHM',localeName,'en');
				var greg_maxtfrDateTime = convertDate(max_trn_date_time,'DMYHM',localeName,'en');
				var admission_date_time = convertDate("<%=admissiondate_converted%>",'DMYHM',localeName,'en');
				if(isBefore(greg_prefDateTime,admission_date_time,'DMYHM','en'))
				{
					var error = getMessage('DATE1_SHD_GT_DATE2','IP');
					/* 17956 Thursday, January 07, 2010*/
					error = error.replace('$',getLabel("eIP.PreferredDateTime.label",'IP'));
					error = error.replace('#',getLabel("Common.AdmissionDateTime.label",'Common'));
					alert(error);
					prefDate.select();
				}////modified for 12/15/2008 6021  MF-SCF-0051
				else if(!isBefore(greg_maxtfrDateTime,greg_prefDateTime,'DMYHM','en')){
			
					var error = getMessage('DATE1_LT_DATE2','IP');
					var last_encounter = getLabel("eIP.LastTransactionDateTime.label","IP");
					error = error.replace('$',getLabel("eIP.PreferredDateTime.label",'IP'));
					error = error.replace('#',last_encounter);
					alert(error);
					prefDate.select();
					}

			}
		}
		var isShift = false;
		function setShift(){
		var keyCode=window.event.keyCode;
		if(keyCode == 16) isShift=true;
	}

		function shift_tab(){
			var keyCode=window.event.keyCode;
			if(keyCode == 9 && isShift == true){
			parent.frames[5].button_s.focus();
		}
		}

		function shift_tab1(){
		var keyCode=window.event.keyCode;
		if(keyCode == 9 && isShift == true){
		document.forms[0].transfer_type1.focus();
		}
		
	}
	function shift_tab11(){
		
		var keyCode = window.event.keyCode;
		
		if(keyCode == 9){
		
			parent.frames[1].document.forms[0].pref_date.focus();
			
		}
		
	}
function setTab()
	{
		var keyCode = window.event.keyCode;
		if(keyCode == 9)
		parent.frames[5].button_c.focus();
	}
	function changefocus()
	{
		document.forms[0].pref_date.focus();
	}
	</script>

</head>
<%
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
	java.util.Date dt=new java.util.Date();
	String d = dateFormat.format( dt ) ;
	String min = String.valueOf(dt.getMinutes()) ;
	if(min.length() == 1)   min = "0"+min ;
	d=d + " "+String.valueOf(dt.getHours())+":"+min;

	if(!(d.equals("") || d == null))
			d_converted = DateUtils.convertDate(d,"DMYHM","en",locale); 	

	//String admissiondate		= "";
	//String admissiontype		= "";
	String prefered_date		="";
	String tfr_type_code		="";
	String priority				= "";
	String TRANSFER_TY_SHORT_DESC ="";
	String prefered_date_converted ="";
	

	
		strBuffer.delete(0, strBuffer.length());
		if(call_function.equals("TransferPatientIn"))
		{
			strBuffer.append("select PRIORITY_CODE,ip_get_desc.IP_TRANSFER_PRIORITY(facility_id,PRIORITY_CODE,'"+locale+"',2) PRIORITY_SHORT_DESC, TFR_REQ_TYPE,to_char(PREF_DATE_TIME,'dd/mm/rrrr hh24:mi') PREF_DATE_TIME,TFR_REQ_REASON,ip_get_desc.IP_TRANSFER_TYPE(TFR_REQ_REASON,'"+locale+"',2) TRANSFER_TYPE_SHORT_DESC ");
			strBuffer.append("from ip_transfer_request where tfr_req_status = '3' and encounter_id =");
			strBuffer.append(encounterid);
            strBuffer.append("  and facility_id = '");
            strBuffer.append(facilityId);
            strBuffer.append("' ");
			
			
		}
		else
		{
			strBuffer.append("SELECT" );
			strBuffer.append("  PRIORITY_CODE" );
			strBuffer.append("  , ip_get_desc.IP_TRANSFER_PRIORITY(facility_id, PRIORITY_CODE,'"+locale+"',2) PRIORITY_SHORT_DESC" );
			strBuffer.append("  , TFR_REQ_REASON" );
			strBuffer.append("  , ip_get_desc.IP_TRANSFER_TYPE(TFR_REQ_REASON,'"+locale+"',2) TRANSFER_TYPE_SHORT_DESC" );
			strBuffer.append("  , TFR_REQ_TYPE" );
			strBuffer.append("  , TO_CHAR(PREF_DATE_TIME,'dd/mm/rrrr hh24:mi') PREF_DATE_TIME" );
			strBuffer.append("  , DECODE (TFR_REQ_TYPE, 'RT','Request for Transfer', 'TO', 'Transfer Out') tfr_req_type_desc " );
			strBuffer.append("FROM" );
			strBuffer.append("  ip_transfer_request " );
			strBuffer.append("WHERE " );
			strBuffer.append("  facility_id = '"+facilityId+"' " );
			strBuffer.append("  AND encounter_id ="+encounterid+" " );
			strBuffer.append("  AND tfr_req_status = '1' " );
		}
		stmt  = con.createStatement();
		rset  = stmt.executeQuery(strBuffer.toString());
		if(rset.next())
		{
			tfr_type_code			= checkForNull(rset.getString("TFR_REQ_REASON"));
			TRANSFER_TY_SHORT_DESC	= checkForNull(rset.getString("TRANSFER_TYPE_SHORT_DESC"));
			prefered_date			= checkForNull(rset.getString("PREF_DATE_TIME"));
			priority				= checkForNull(rset.getString("PRIORITY_SHORT_DESC"));
			if(rset	!= null)   rset.close();
			if(stmt  != null)   stmt.close();		
		}

	//}
	/*Monday, May 03, 2010 , commented for PE
	String trn_date_time = "";
	String Sql_trnTime = " Select to_char(trn_date_time,'dd/mm/rrrr hh24:mi') trn_date_time from IP_ADT_TRN where encounter_id = '"+encounterid+"' and facility_id  = '"+facilityId+"' ";    
	stmt  = con.createStatement();
	rset    = stmt.executeQuery(Sql_trnTime);
	if(rset != null)
	{
		if(rset.next())
		{
			trn_date_time = checkForNull(rset.getString("trn_date_time"));
		}    
		if(rset	!= null)   rset.close();
		if(stmt  != null)   stmt.close();		
	}
	
//modified for 12/15/2008 6021  MF-SCF-0051
	String trn_date = "SELECT to_char(MAX(TRN_DATE_TIME),'dd/mm/rrrr hh24:mi')  FROM IP_ADT_TRN WHERE FACILITY_ID = '"+facilityId+"' AND ENCOUNTER_ID = '"+encounterid+"'";
		stmt  = con.createStatement();
		rset	=stmt.executeQuery(trn_date.toString());
			if(rset != null){
				if(rset.next()){
					MAX_TRN_DATE_TIME = rset.getString(1);
				}
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();
MAX_TRN_DATE_TIME = DateUtils.convertDate(MAX_TRN_DATE_TIME,"DMYHM","en",locale);

	/**/
	if(prefered_date.equals(""))
	prefered_date=sdate;

	if(!( prefered_date==null || prefered_date.equals("")))
			prefered_date_converted=DateUtils.convertDate(prefered_date,"DMYHM","en",locale);
			
%>
<script>

</script>
	
	<body <%if(call_function.equals("TransferPatientOut")){%>onload='getTfrType();'<%}%> onMouseDown='CodeArrest()' onKeyDown='lockKey();setShift();' > 
	<form name="trf_form" id="trf_form"   method="" action="" target="parent.frames[1]">
		
	<table border="0" width="100%" cellpadding="3" cellspacing="0">
		 <tr>
				<th colspan='4' align="left" style=" color: white;" class='columnheader' width="100%" ><fmt:message key="Common.AdmissionDetails.label" bundle="${common_labels}"/></th>
		</tr>
		<tr><!-- 17956 Thursday, January 07, 2010 -->
			<td class="label" width='25%'><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></td>
			 <td  class='querydata' WIDTH='25%'><input type="hidden" name="admission_date" id="admission_date" value="<%=admissiondate%>" ><%=admissiondate_converted%></td>
			<td class="label" WIDTH='20%'  ><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
			<td  class='querydata' WIDTH='30%'><input type="hidden" name="admission_type" id="admission_type" value="<%=admissiontype%>" ><%=admissiontype%></td> 
		</tr>
		<tr>
			<%--<td class="label" ><fmt:message key="Common.transferdate.label" bundle="${common_labels}"/></td>
			<td class='querydata' ><input type="hidden" name="transfer_date" id="transfer_date"  value="<%=d%>"> <%=d_converted%> </td>--%>

			<%	
		
		if(!priority.equals("") || call_function.equals("TransferPatientIn") || !tfr_type_code.equals(""))
			{
						
						String disable_yn="";  // added by mujafar for ML-MMOH-CRF-1136
						if(isArrivalDateAppl)disable_yn="disabled";
		%>
				<td class="label" ><fmt:message key="eIP.PreferredDateTime.label" bundle="${ip_labels}"/></td><td  class='querydata'><INPUT TYPE="text" name="pref_date" id="pref_date" readOnly id="prefDate"  <%=disable_yn%>  size="16" maxlength="16" value="<%=prefered_date_converted%>" onblur=""  onKeyPress='' onkeyDown='shift_tab();'>
				<%
				if(!isArrivalDateAppl) // added by mujafar for ML-MMOH-CRF-1136
				{
				%>
				<img src='../../eCommon/images/mandatory.gif' align='center'>
				<%
				}
				%>
				</td> 
		<%	}
			else
			{	%>
				<td class="label" ><fmt:message key="eIP.PreferredDateTime.label" bundle="${ip_labels}"/></td><td  class='querydata'><INPUT TYPE="text" name="pref_date" id="pref_date" size="16" maxlength="16" value="<%=sdate_converted%>" onblur="validateBackDate(this);//compareSystemDate(this);"  onKeyPress='' <%if(status_value.equals("Confirmed")){%> Readonly <%}%> onkeyDown='shift_tab1();' tabindex = '1'><img name='beddt' src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].pref_date.focus();return showCalendar('pref_date',null,'hh:mm');" tabindex = '2'/><img src='../../eCommon/images/mandatory.gif' align='center' > </img></td> 
		<%	}	%>

		<%	if(call_function.equals("TransferPatientIn"))
			{	%>
				<td class="label" WIDTH='20%' ><fmt:message key="eIP.ReasonforTransfer.label" bundle="${ip_labels}"/></td>
				<td  class="querydata"  WIDTH='30%'><%=TRANSFER_TY_SHORT_DESC%><input type=hidden name='transfer_type_code' id='transfer_type_code'  value="<%=tfr_type_code%>" ></td>
		<%	}
			else
			{	
				%>
				<td class="label" WIDTH='20%'><fmt:message key="eIP.ReasonforTransfer.label" bundle="${ip_labels}"/></td><td class='querydata' WIDTH='30%'><select name="transfer_type1" id="transfer_type1" onChange="getBlockingDetails();<% if(isCnrmReqPatOutChngAppl){%>chkInformedDtlsMand();<%}%>" <% if(status_value.equals("Confirmed")){%>disabled<%}%> onkeyDown='shift_tab1();setTab();' tabindex = '3' onblur="changefocus()">
				<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
				<%
					
						if(!status_value.equals("Confirmed"))
						{
							//rset = stmt.executeQuery("select ip_get_desc.IP_TRANSFER_TYPE(transfer_type_code,'"+locale+"',1)short_desc, transfer_type_code||'='|| blocking_type_code || '=' ||blokcing_type_short_desc ||'='|| decode(block_units, 'H', block_period, 'D', block_period*24)   ||'='|| to_char(sysdate+(decode(block_units, 'H', block_period, 'D', block_period*24)/24), 'dd/mm/rrrr hh24:mi') || '='||block_units||'='|| override_yn ||'='||(select bed_block_period_normal from ip_param where facility_id ='"+facilityId+"') transfer_type_code from IP_TRANSFER_TYPE_VW where EFF_STATUS = 'E' order by 1");
							trans_Type = "select ip_get_desc.IP_TRANSFER_TYPE(transfer_type_code,?,2)short_desc, transfer_type_code||'='|| blocking_type_code || '=' ||blokcing_type_short_desc ||'='|| decode(block_units, 'H', block_period, 'D', block_period*24)   ||'='|| to_char(sysdate+(decode(block_units, 'H', block_period, 'D', block_period*24)/24), 'dd/mm/rrrr hh24:mi') || '='||block_units||'='|| override_yn ||'='||(select bed_block_period_normal from ip_param where facility_id =?) ||'='|| informed_dtls_mand_yn transfer_type_code  from IP_TRANSFER_TYPE_VW where EFF_STATUS = 'E' order by 1"; //Modified by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617
						}
						else
						{
							// 17956 
							//rset = stmt.executeQuery("select ip_get_desc.IP_TRANSFER_TYPE(transfer_type_code,'"+locale+"',1) short_desc, transfer_type_code from IP_TRANSFER_TYPE_VW where EFF_STATUS = 'E' order by 1");
							trans_Type = "select ip_get_desc.IP_TRANSFER_TYPE(transfer_type_code,?,2) short_desc, transfer_type_code from IP_TRANSFER_TYPE where EFF_STATUS = 'E' order by 1";
						}
					
					pstmt = con.prepareStatement(trans_Type);
					pstmt.setString(1,locale);
					if(!status_value.equals("Confirmed"))
						pstmt.setString(2,facilityId);
					rset  = pstmt.executeQuery();
					while(rset.next())
					{
						String desc = rset.getString("short_desc");
						String code = rset.getString("transfer_type_code");
						String sel = "";
						if (code.equals(tfr_type_code))
							sel = "selected";
						else
							sel = "";
						out.print("<option value=\""+code+"\""+sel+">"+desc );
					}
					if(rset	!= null)   rset.close();
					if(pstmt  != null)   pstmt.close();		
				%>
				</select>
				<img align="center" src="../../eCommon/images/mandatory.gif">
				<input type="hidden" name="transfer_type_code" id="transfer_type_code"  value="">
				</td>
		<%	}	%>
		</tr>

	<%	if(call_function.equals("TransferPatientIn"))
		{	%>
			<tr>
				<td class="label"  ><fmt:message key="eIP.TransferInStatus.label" bundle="${ip_labels}"/></td>
				<td class='querydata'    >
					<select name = "transfer_in_status" onChange="enableAllFields()" OnkeyDown='shift_tab11()'>
						<option value = "">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value = "01"><fmt:message key="Common.Accepted.label" bundle="${common_labels}"/></option>
						<option value = "02"><fmt:message key="Common.Rejected.label" bundle="${common_labels}"/></option>
					</select>
				<img align="center" id="img_trans_in" src="../../eCommon/images/mandatory.gif">
						
				</td>
				
			<%
			
			if(isArrivalDateAppl) // added by mujafar for ML-MMOH-CRF-1136
			{
				%>	
			
			<td class="label"  id="arr_date_disp" name="arr_date_disp" style="display:none" ><fmt:message key="Common.ArrivalDateTime.label" bundle="${common_labels}"/></td>
			<td  class='querydata'  id="arr_date_disp1" name="arr_date_disp1" style="display:none" >
			<INPUT TYPE="text" name="arrival_date"  id="arrival_date" size="16" maxlength="16" value="" onblur="if(validDateObj(this,'DMYHM',localeName)){validate_date(this);compareDates(this,document.forms[0].pref_date);}"  onKeyPress='' onkeyDown='shift_tab();'><input type="image" id="arr_img" src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].arrival_date.focus();return showCalendar('arrival_date',null,'hh:mm');" ><img src='../../eCommon/images/mandatory.gif' align='center'>
			</td> 
				
			<%}%>	
			</tr>
	<%	}
		else
		{	%>
		<tr><td class='DEFAULTBLANKROW2PT' colspan=4>&nbsp;</td></tr>
		<%}%>
	</table>
	<input type="hidden" name="sysdate" id="sysdate" value="<%=sdate%>">
	<input type="hidden" name="priority_chk" id="priority_chk" value="<%=priority%>">
	<input type="hidden" name="max_trn_date_time" id="max_trn_date_time" value="<%=MAX_TRN_DATE_TIME%>">
	<input type="hidden" name="call_function" id="call_function" value="<%=call_function%>"><!--Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617-->
	
	<input type="hidden" name="isArrivalDateAppl" id="isArrivalDateAppl" value="<%=isArrivalDateAppl%>"><!--Added by mujafar  for ML-MMOH-CRF-1136-->
	<%if(call_function.equals("TransferPatientIn") ||!priority.equals(""))
	{%>
		<%--<input type="hidden" name="transfer_type1" id="transfer_type1" value="<%=TRANSFER_TY_SHORT_DESC%>">--%>
	<%}%>
	<br>

	</form>
<%		
		if(rset	  != null)			rset.close();
		if(stmt   != null)			stmt.close();
	}catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally 
	{
		ConnectionManager.returnConnection(con,request);
	}
	 %>
<script>
	if(document.forms[0].transfer_type1 != null)
	{
		if(document.forms[0].transfer_type1.value != "")
		{   
			document.forms[0].transfer_type1.disabled = true;
		}
	}
</script>
	 
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>

