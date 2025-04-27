<!DOCTYPE html>
<!-- 
Sr No        Version           TFS/Incident        SCF/CRF   			Developer Name
------------------------------------------------------------------------------------------------
1          V201118/V201214     8071/74237        MOHE-CRF-0050.4      	Mohana Priya K
2            V210106            12438          BL-MOHE-CRF-0050.4-US001 and US002/02-Invoice Reports     Mohana Priya K
3			V211020											            Mohanapriya K
 -->

<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*,  "  
contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>	
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/BLInvoiceReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    
<script>

async function callCommonLookupCode(obj,code,sqlSelect){
		var locale  	 = document.getElementById('locale').value;
		var facilityId   = document.getElementById('facility_id').value;
		var episode_type = document.getElementById('EpisodeType').value;
		var from_mon	 = document.getElementById('from_mon').value;
		var from_yr		 = document.getElementById('from_yr').value;
		var to_mon		 = document.getElementById('to_mon').value;
		var to_yr		 = document.getElementById("to_yr").value;
		var fm_date		 = document.getElementById('fm_date').value;
		var to_date		 = document.getElementById('to_date').value;
		
		var argumentArray  = new Array();
		var dataNameArray  = new Array();
		var dataValueArray = new Array();
		var dataTypeArray  = new Array();
		var sql 	= '';
		var title 	= '';
		
		
		switch(sqlSelect){
			case 1:
			{    sql="SELECT   long_Desc description, cust_group_code code from(( select  long_desc,CUST_GROUP_CODE from ar_cust_group AR where  status is null "+
						 "and  EXISTS (SELECT  A.CUST_GROUP_CODE FROM  BL_INS_PAYER_APPR_DTL A "+
						 "WHERE A.OPERATING_FACILITY_ID ='"+facilityId+"' AND A.CUST_GROUP_CODE = AR.CUST_GROUP_CODE "+       
					   	 "AND TRUNC(DOC_REF_DATE) BETWEEN  to_DATE('"+fm_date+"','DD/MM/YYYY')  AND  to_DATE('"+to_date+"','DD/MM/YYYY')  "+
						 "AND (('"+episode_type+"'= '1' and episode_type in ('O','E','R')) or ('"+episode_type+"' = '2' and episode_type in ('I','D')) "+
						 "or ('"+episode_type+"' = 'A' and episode_type in ('I','D','O','E','R'))) "+
						 "AND NVL('"+from_yr+"',0) =0 AND NVL('"+from_mon+"',0) =0 AND NVL('"+to_yr+"',0) =0 "+
						 " AND NVL('"+to_mon+"',0) =0 ) )"+"  UNION SELECT   long_Desc, cust_group_code from "+
						 "( select  long_desc,CUST_GROUP_CODE from ar_cust_group AR where  status is null "+
						 "and  EXISTS(SELECT  'Y' FROM bl_bill_hdr b WHERE b.OPERATING_FACILITY_ID ='"+facilityId+"' "+
						 "AND b.CUST_GROUP_CODE = AR.CUST_GROUP_CODE  AND LPAD (NVL (TO_CHAR (posted_year), '0'), 4, '0') "+
						 " || LPAD (NVL (TO_CHAR (posted_month), '0'), 2, '0') "+
						 " BETWEEN LPAD (NVL (TO_CHAR ('"+from_yr+"'), '0'), 4, '0') "+
						 " || LPAD (NVL (TO_CHAR ('"+from_mon+"'), '0'), 2, '0') "+
						 " AND LPAD (NVL (TO_CHAR ('"+to_yr+"'), '0'), 4, '0') "+
						 "|| LPAD (NVL (TO_CHAR ('"+to_mon+"'), '0'), 2, '0') "
						 +"  AND NVL('"+from_yr+"',0) !=0 "+
						 " AND NVL('"+from_mon+"',0) !=0 "+
					     "AND NVL('"+to_yr+"',0) !=0 "+
					     " AND NVL('"+to_mon+"',0) !=0  )) UNION ALL "+
						 "SELECT 'All Groups','**' from dual ) where upper(long_Desc) like upper(?) and upper(cust_group_code) like upper(?) order by 1";    //V201231
				
				title = getLabel("eBL.CUSTOMER_GROUP.label","BL");
				break;	
			}
			case 2:
			{
				var cust_code=document.getElementById('custGrpCode').value;
				sql="SELECT   CUST_CODE code, long_name description from("+
					"( select  AR.CUST_CODE CUST_CODE, AR.long_name LONG_NAME from ar_customer AR "+
					"where  status is null "+
					"and  EXISTS (SELECT   DISTINCT A.CUST_CODE "+
					"FROM  BL_INS_PAYER_APPR_DTL A WHERE A.OPERATING_FACILITY_ID ='"+facilityId+"' AND A.CUST_GROUP_CODE=AR.CUST_GROUP_CODE "+
					"AND A.CUST_GROUP_CODE = '"+cust_code+"' AND TRUNC(DOC_REF_DATE) BETWEEN to_DATE('"+fm_date+"','DD/MM/YYYY')  AND  to_DATE('"+to_date+"','DD/MM/YYYY')"+
					"AND (('"+episode_type+"'= '1' and episode_type in ('O','E','R')) or "+
					"('"+episode_type+"' = '2' and episode_type in ('I','D')) or "+
					"('"+episode_type+"' = 'A' and episode_type in ('I','D','O','E','R'))) "+
					"AND NVL('"+from_yr+"',0) =0 AND NVL('"+from_mon+"',0) =0 "+
					"AND NVL('"+to_yr+"',0) =0 AND NVL('"+to_mon+"',0) =0 ) ) "+
					"UNION SELECT   CUST_CODE, long_name from "+
					"( select  AR.CUST_CODE CUST_CODE, AR.long_name LONG_NAME from ar_customer AR where  status is null "+
					"and  EXISTS (SELECT       DISTINCT A.CUST_CODE FROM  BL_BILL_HDR A "+
					"WHERE A.OPERATING_FACILITY_ID ='"+facilityId+"' AND A.CUST_GROUP_CODE=AR.CUST_GROUP_CODE "+
					"AND A.CUST_GROUP_CODE = '"+cust_code+"' AND LPAD (NVL (TO_CHAR (posted_year), '0'), 4, '0') "+
					" || LPAD (NVL (TO_CHAR (posted_month), '0'), 2, '0') "+
					" BETWEEN LPAD (NVL (TO_CHAR ('"+from_yr+"'), '0'), 4, '0') "+
					" || LPAD (NVL (TO_CHAR ('"+from_mon+"'), '0'), 2, '0') "+
					"AND LPAD (NVL (TO_CHAR ('"+to_yr+"'), '0'), 4, '0') "+
					" || LPAD (NVL (TO_CHAR ('"+to_mon+"'), '0'), 2, '0') "+
					" AND NVL('"+from_yr+"',0) !=0 AND NVL('"+from_mon+"',0) !=0 "+
					"AND NVL('"+to_yr+"',0) !=0  AND NVL('"+to_mon+"',0) !=0) ) "+
					")where upper(long_name) like upper(?) and upper(CUST_CODE) like upper(?) order by 1";  //V201231
				
				title = getLabel("eBL.PAYER.label","bl");
				break;
			}
		}
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;				
			
		returnedValues = await CommonLookup(title, argumentArray );
		var ret1=unescape(returnedValues);
			 	var arr=ret1.split(",");
			 	if(arr[1]==undefined) 
		 		{
			 		arr[0]="";	
			 		arr[1]="";	
		 		}
		if((returnedValues != null) && (returnedValues != "") )  {
		
			obj.value = arr[1];
			code.value = arr[0];
		}
		else
		{
		
		obj.value = '';
		code.value = '';		
		}
}

function valid_Range(callfrom){
	var from_mon=document.getElementById('from_mon').value;
	var from_yr=document.getElementById('from_yr').value;
	var to_mon=document.getElementById('to_mon').value;
	var to_yr=document.getElementById("to_yr").value;
	//V210106 Starts
	var date = new Date();
	var year=date.getFullYear()
	var mon=date.getMonth()+1;
	//V210106 ends
	if(callfrom==2){ 
		//V210106 starts
		if(from_mon>mon && from_yr==year){
			alert(getMessage('BL0733', 'BLEXT'));
			document.getElementById('from_mon').value='0';
			document.getElementById('from_yr').value='0';
			document.getElementById('fm_date').disabled=false;
			document.getElementById('fmdate').disabled=false;
			document.getElementById('to_date').disabled=false;
			document.getElementById('todate').disabled=false;
			return false;
		}else if(to_yr==year && to_mon>mon){
			 alert(getMessage('BL0733', 'BLEXT'));
			 document.getElementById('to_mon').value='0';
			 document.getElementById("to_yr").value='0';
			 document.getElementById('fm_date').disabled=false;
			 document.getElementById('fmdate').disabled=false;
			 document.getElementById('to_date').disabled=false;
	   		 document.getElementById('todate').disabled=false;
	   		 return false;
		}
		//V210106 ends
		
		if(from_mon=='0' || from_yr=='0'){
			 alert(getMessage('BL0734', 'BLEXT')); //V201214
			 document.getElementById('to_mon').value='0';
			 document.getElementById("to_yr").value='0';
             return false;
		}else if(from_yr!='0' && from_mon!='0'){
			if(to_yr!='0' && to_mon!='0'){
			  if(from_yr==to_yr){
				if(from_mon>to_mon){
					alert(getMessage('BL0735', 'BLEXT')); //V201214
					 document.getElementById('to_mon').value='0';
					 document.getElementById("to_yr").value='0';
	    	         return false;
				}else{
					return true;
				}
			}else if(from_yr>to_yr){
				alert(getMessage('BL0735', 'BLEXT')); //V201214
			 	document.getElementById('to_mon').value='0';
				 document.getElementById("to_yr").value='0';
            	return false;
				}
			}
		}
	}
	if(callfrom==1){ //V210106 starts
		if(from_mon>mon && from_yr==year){
			alert(getMessage('BL0733', 'BLEXT'));
			document.getElementById('from_mon').value='0';
			document.getElementById('from_yr').value='0';
			document.getElementById('fm_date').disabled=false;
			document.getElementById('fmdate').disabled=false;
			document.getElementById('to_date').disabled=false;
			document.getElementById('todate').disabled=false;
			return false;
		}else if(to_yr==year && to_mon>mon){
			alert(getMessage('BL0733', 'BLEXT'));
			document.getElementById('to_mon').value='0';
			document.getElementById("to_yr").value='0';
			document.getElementById('fm_date').disabled=false;
			document.getElementById('fmdate').disabled=false;
			document.getElementById('to_date').disabled=false;
			document.getElementById('todate').disabled=false;	
			return false;
		}//V210106 ends
		
		if(from_yr!='0' || from_mon!='0'){
			document.getElementById('fm_date').value='';
			document.getElementById('fm_date').disabled=true;
			document.getElementById('fmdate').disabled=true;
			document.getElementById('to_date').value='';
			document.getElementById('to_date').disabled=true;
			document.getElementById('todate').disabled=true;
		}
	else{
		document.getElementById('fm_date').disabled=false;
		document.getElementById('fmdate').disabled=false;
		document.getElementById('to_date').disabled=false;
		document.getElementById('todate').disabled=false;
	}
	}
}

function checkVal(obj){ 
	if(obj==1){
		if(document.getElementById('unposted').checked==true){
			document.getElementById('unposted').checked=false;	
		}
		document.getElementById('from_mon').value="0";	
		document.getElementById('from_mon').disabled=false;	
		document.getElementById('from_yr').value="0";	
		document.getElementById('from_yr').disabled=false;
		document.getElementById('to_mon').value="0";	
		document.getElementById('to_mon').disabled=false;
		document.getElementById("to_yr").value="0";	
		document.getElementById("to_yr").disabled=false;
	}
	if(obj==2){ 
		if(document.getElementById('posted').checked==true){
			document.getElementById('posted').checked=false;	
		}
		document.getElementById('from_mon').value="0";	
		document.getElementById('from_mon').disabled=true;	
		document.getElementById('from_yr').value="0";	
		document.getElementById('from_yr').disabled=true;
		document.getElementById('to_mon').value="0";	
		document.getElementById('to_mon').disabled=true;
		document.getElementById("to_yr").value="0";	
		document.getElementById("to_yr").disabled=true;
		document.getElementById('fm_date').disabled=false; //V201209
		document.getElementById('fmdate').disabled=false; //V201209
		document.getElementById('To_date').disabled=false; //V201209
		document.getElementById('todate').disabled=false; //V201209
	}
} 

</script>
</head>
<style>
		thead td, thead td.locked	{ 
		background-color: navy;
		color: white;
		position:relative;}	
		thead td {
		top: expression(document.getElementById("tbl-container").scrollTop-4); 
		z-index: 20;}
		thead td.locked {z-index: 30;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative; 
		z-index: 10;}
		</style>
<%
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
	String locale			=	"";
	String from_yr			=	"";
	String isUserCanAcess	=	"";
	String disabled="";
	String p_user_name		= (String) session.getValue( "login_user" );
	Connection con	= null;
	PreparedStatement pstmt = null;
	ResultSet rs		= null;
	String session_id="";
	String p_pgm_date="";
	String value1="N";
	String value2="N";
	try  
	{		 
		locale  = 	(String)session.getAttribute("LOCALE");
		String facilityId =   (String) session.getValue( "facility_id" ) ;
		con=ConnectionManager.getConnection(request);
		isUserCanAcess = (String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));	
%>

<BODY onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" onload="ReportListchange(document.forms[0].Report_list)" style="padding-left:10px;padding-right:10px;padding-top:5px;">
 <form name="BLUnbilledForm" id="BLUnbilledForm" id="BLUnbilledForm"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame" > 

<TABLE width="100%" CELLSPACING='0' cellpadding='3' align='center'>
<tr>
	<th  class="columnheader" style="text-align:left;"><fmt:message key="eBL.ReportCriteria.label" bundle="${bl_labels}"/> </th>
</tr>	
</TABLE> 
<br>
<table cellpadding='10' cellspacing='0' width="100%" align="center" border='0'>	
	<tr>
		<td  class="label">
			<fmt:message key="eBL.report_list.label" bundle="${bl_labels}"/>
		</td>
		<td colspan='2'>
			<select name="Report_list" id="Report_list" id="Report_list" onchange="ReportListchange(this)" style="width: 230px;">       
				<option value="INRSUMINV" >Summary Of Invoice</option>
				<option value="INRSTDFT" >Consolidated Summary of Invoice</option>
			</select>		
		</td>
	</tr>
	<tr>
	    <td  class="label" width="10%">
			<fmt:message key="eBL.EpisodeType.label" bundle="${bl_labels}"/>
		</td>
		<td>
			<select name="EpisodeType" id="EpisodeType" id="EpisodeType" style="width: 210px;">       
				<option value="A" selected>All</option>
				<option value="1" >Outpatient/Emergency/Referral</option>
				<option value="2" >Inpatient/Daycare</option>
			</select>		
		</td><td></td>
		<td class="label" colspan='2'>
			<input type="radio" name="posted" id="posted" id="posted" onclick="checkVal(1);ReportListchange(document.getElementById('Report_list'));" checked><fmt:message key="eBL.posted.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name="unposted" id="unposted" id="unposted" onclick="checkVal(2);ReportListchange(document.getElementById('Report_list'));" ><fmt:message key="eBL.unposted.label" bundle="${bl_labels}"/>   	
		</td>
	</tr>
	<tr>
		 <td  class="label" width="15%">
			<fmt:message key="eBL.posted_mth/Yr_frm.label" bundle="${bl_labels}"/>
		</td>
		<td width="10%" class='fields' colspan='1'>
			<select name="from_mon" id="from_mon" id="from_mon" onchange="valid_Range(1);" style="width: 80px;">       
				<option value="0" selected>sel</option>
				<option value="1" >JAN</option>
				<option value="2" >FEB</option>
				<option value="3" >MAR</option>
				<option value="4" >APR</option>
				<option value="5" >MAY</option>
				<option value="6" >JUN</option>
				<option value="7" >JUL</option>
				<option value="8" >AUG</option>
				<option value="9" >SEP</option>
				<option value="10">OCT</option>
				<option value="11">NOV</option>
				<option value="12">DEC</option>
				
		    </select>	
			<select name="from_yr" id="from_yr" id="from_yr" onchange="valid_Range(1);" style="width: 80px;">   
				<option value="0" selected>sel</option>
				
				<%try{
					// con=ConnectionManager.getConnection(request); //V211020
					from_yr = "select extract (year from sysdate) -2012 ,extract (year from sysdate) from dual";
					pstmt = con.prepareStatement(from_yr);
					rs = pstmt.executeQuery();	
					if(rs != null){
						while(rs.next()){
						String tot = rs.getString(1);
						String strYr = rs.getString(2);
						if(strYr!=null){
							int year=Integer.parseInt(strYr);
							int total=Integer.parseInt(tot);
							int[] yr=new int[total+1];
							for(int t=0;t<=total;t++){
								yr[t]=year--;
								String yrv=Integer.toString(yr[t]);
								
							%>
							<option value="<%=yrv%>"><%=yr[t] %></option>
							<%
							}
					}                  	
				}//while 
			}//Result Set IF Condition 
			}catch(Exception e)
			{
				e.printStackTrace();
				out.println("Exception is "+e);
			}
			finally{
				try{
					if(pstmt!=null) pstmt.close();
					if(rs!=null)rs.close();
					// ConnectionManager.returnConnection(con); //V211020
				}catch(Exception e)
				{
					e.printStackTrace();
					out.println("Exception is "+e);
				}				
			}	 %>    
		    </select>	
		</td>&nbsp;&nbsp;&nbsp;&nbsp;
		<td></td>
	    <td  class="label" width='15%' colspan='1' align='left'>
			<fmt:message key="eBL.posted_mth/Yr_To.label" bundle="${bl_labels}"/>
		</td>
		<td colspan='2'>
			<select name="to_mon" id="to_mon" id="to_mon" onchange="valid_Range(2);" style="width: 80px;">       
				<option value="0" selected>sel</option>
				<option value="1" >JAN</option>
				<option value="2" >FEB</option>
				<option value="3" >MAR</option>
				<option value="4" >APR</option>
				<option value="5" >MAY</option>
				<option value="6" >JUN</option>
				<option value="7" >JUL</option>
				<option value="8" >AUG</option>
				<option value="9" >SEP</option>
				<option value="10">OCT</option>
				<option value="11">NOV</option>
				<option value="12">DEC</option>
		    </select>	
			<select name="to_yr" id="to_yr" id="to_yr" onchange="valid_Range(2);" style="width: 80px;">       
				<option value="0" selected>sel</option>
					<%try{
					//con=ConnectionManager.getConnection(request); //V211020
					from_yr = "select extract (year from sysdate) -2012 ,extract (year from sysdate) from dual";
					pstmt = con.prepareStatement(from_yr);
					rs = pstmt.executeQuery();	
					if(rs != null){
						while(rs.next()){
						String tot = rs.getString(1);
						String strYr = rs.getString(2);
						if(strYr!=null){
							int year=Integer.parseInt(strYr);
							int total=Integer.parseInt(tot);
							int[] yr=new int[total+1];
							for(int t=0;t<total+1;t++){
								yr[t]=year--;
								String yrv=Integer.toString(yr[t]);
								%>
							<option value="<%=yrv%>"><%=yr[t] %></option>
							<%
						}
					}                  	
				}//while 
			}//Result Set IF Condition 
			}catch(Exception e)
			{
				e.printStackTrace();
				out.println("Exception is "+e);
			}
			finally{
				try{
					if(pstmt!=null) pstmt.close();
					if(rs!=null)rs.close();
					//ConnectionManager.returnConnection(con); //V211020
				}catch(Exception e)
				{
					e.printStackTrace();
					out.println("Exception is "+e);
				}				
			}	 %>    
		    
		    </select>	
		</td><td></td>
	</tr>
	<tr>
		<td  class="label" width="10%">
			<fmt:message key="eBL.stat_date_frm.label" bundle="${bl_labels}"/>
		</td>
		<td width="10%" class='fields' colspan='2'>
			<input type="text" name="fm_date" id="fm_date" id="fm_date" size="10" maxlength='10' value='' <%=disabled %> onBlur='return checkDateBL(document.forms[0].fm_date,fm_date,to_date);return dateRegEx(this)' >
				&nbsp; <input type="image" max-width='5%' max-height='5%' src="../../eCommon/images/CommonCalendar.gif" id=fmdate onClick="return showCalendar('fm_date');"><img src='../../eCommon/images/mandatory.gif'>
		</td>
        <td  class="label" width="15%">
		 	<fmt:message key="eBL.stat_date_To.label" bundle="${bl_labels}"/>
		</td>
		<td>
			<input type="text"  name="to_date" id="to_date"  id="to_date"   size="10" maxlength='10' value='' onBlur='return toFromDateChk(document.forms[0].to_date,fm_date,to_date);return dateRegEx(this)' >
				&nbsp; <input type="image" src="../../eCommon/images/CommonCalendar.gif" id=todate onClick="return showCalendar('to_date');" border="0"><img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>
	<tr>
		<td  class="label" width="10%">
			<fmt:message key="eBL.Visit_period_frm.label" bundle="${bl_labels}"/>
		</td>
		<td width="10%" class='fields' colspan='2'>
			<input type="text" name="vst_fm_date" id="vst_fm_date" id="vst_fm_date" size="10" maxlength='10' value='' onBlur='return checkDateBL(document.forms[0].vst_fm_date,vst_fm_date,vst_to_date);return dateRegEx(this)' >
				&nbsp; <input type="image"  src="../../eCommon/images/CommonCalendar.gif" id="vstfm" onClick="return showCalendar('vst_fm_date');">
		</td>
        <td  class="label" width="10%">
		 	<fmt:message key="eBL.Visit_period_To.label" bundle="${bl_labels}"/>
		</td>
		<td>
			<input type="text"  name="vst_to_date" id="vst_to_date"  id="vst_to_date"   size="10" maxlength='10' value='' onBlur='return toFromDateChk(document.forms[0].vst_to_date,vst_fm_date,vst_to_date);return dateRegEx(this)' >
				&nbsp; <input type="image"  src="../../eCommon/images/CommonCalendar.gif" id="vstto" onClick="return showCalendar('vst_to_date');">
		</td>
	</tr>
	<tr>
		<td  class="label" width="15%">
			<fmt:message key="eBL.disc_period_frm.label" bundle="${bl_labels}"/>
		</td>
		<td width="10%" class='fields' colspan='2'>
			<input type="text" name="disc_fm_date" id="disc_fm_date" id="disc_fm_date" size="10" maxlength='10' value='' onBlur='return checkDateBL(document.forms[0].disc_fm_date,disc_fm_date,disc_to_date);return dateRegEx(this)' >
				&nbsp; <input type="image"  src="../../eCommon/images/CommonCalendar.gif" id="disfm" onClick="return showCalendar('disc_fm_date');">
		</td>
        <td  class="label" width="10%">
		 	<fmt:message key="eBL.disc_period_To.label" bundle="${bl_labels}"/>
		</td>
		<td>
			<input type="text"  name="disc_to_date" id="disc_to_date"  id="disc_to_date"   size="10" maxlength='10' value='' onBlur='return toFromDateChk(document.forms[0].disc_to_date,disc_fm_date,disc_to_date);return dateRegEx(this)' >
				&nbsp; <input type="image"  src="../../eCommon/images/CommonCalendar.gif" id="disto" onClick="return showCalendar('disc_to_date');">
		</td>
	</tr>
	<tr>
	   <td width="10%" nowrap class='label'  style="text-align: left;" > 
		   <fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/>
		</td>
		<td width="20%" nowrap class='fields' style="text-align: left;">
			<input type="text" name='custGrpCode' id='custGrpCode' id='custGrpCode' size="10" onblur="if(this.value!=''){ callCommonLookupCode(custGrpDesc,custGrpCode,1); } else{ fnClearCode(custGrpDesc);  }">&nbsp;
			<input type="text" name='custGrpDesc' id='custGrpDesc' id='custGrpDesc' size="30" onblur="if(this.value!=''){ callCommonLookupCode(custGrpDesc,custGrpCode,1); } else{ fnClearCode(custGrpCode);  }">&nbsp;
			<input type="button" class="button" value='?' name="custGrpBtn" id="custGrpBtn" id="custGrpBtn" onClick="callCommonLookupCode(custGrpDesc,custGrpCode,1);" ><img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>
	<tr>
	   <td width="10%" nowrap class='label'  style="text-align: left;" > 
		   <fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/>
		</td>
		<td width="20%" nowrap class='fields' style="text-align: left;">
			<input type="text" name='payercode' id='payercode' id='payerCode' size="10" onblur="if(this.value!=''){ callCommonLookupCode(payerDesc,payercode,2); } else{ fnClearCode(payerDesc);  }">&nbsp;
			<input type="text" name='payerDesc' id='payerDesc' id='payerDesc' size="30" onblur="if(this.value!=''){ callCommonLookupCode(payerDesc,payercode,2); } else{ fnClearCode(payercode);  }">&nbsp;
			<input type="button" class="button" value='?' name="payerBtn" id="payerBtn" id="payerBtn" onClick="callCommonLookupCode(payerDesc,payercode,2);" >
		</td>
	</tr>
</table>		
		
	<input type='hidden' name='locale' id='locale' 		id='locale'			value="<%=locale%>" 	>
	<input type='hidden' name='facilityId' id='facilityId'	id='facilityId' 	value="<%=facilityId%>" >
	<input type="hidden" name="p_module_id" id="p_module_id" id="p_module_id" 	value="IN"	>
	<input type="hidden" name="p_report_id" id="p_report_id" id="p_report_id"	value="" >
	<input type="hidden" name="pgm_id" id="pgm_id" 		id="pgm_id"			value=""	> 		
	<input type="hidden" name="facility_id" id="facility_id" 	id="facility_id" value="<%=facilityId%>"	>
	<input type="hidden" name="p_session_id" id="p_session_id" 	value="<%=session_id%>">	
	<input type="hidden" name="p_user_name" id="p_user_name" 	value="<%=p_user_name%>">
	<input type="hidden" name="p_pgm_date" id="p_pgm_date"	   value="">
</form>
</BODY>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception in BLUnbilledReport.jsp::"+e);
	}finally{
		try{
			ConnectionManager.returnConnection(con); //V211020
		}catch(Exception e)
			{
				e.printStackTrace();
				out.println("Exception is "+e);
			}				
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

