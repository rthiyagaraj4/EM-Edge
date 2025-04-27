<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	
	%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></script>
<script src="../../eCommon/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>

async function searchCustomerCode(obj,target) {	
			var retVal = 	new String();
			var locale= "<%=localeName%>"
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var argumentArray=new Array(8);
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;			
			if(target.value=="" && window.event.target == target)
				return;
			group_id = document.forms[0].P_CUSTOMER_GROUP_CODE.value;		
			tit=getLabel('Common.CustomerCode.label','common')	
			if(group_id!=""){
				argumentArray[0]="select code,description from (SELECT a.cust_code code, a.long_name description FROM ar_customer_lang_vw a,ar_cust_group_lang_vw b,bl_cust_by_cust_group d  WHERE a.acc_entity_code =  b.acc_entity_code AND b.acc_entity_code =d.acc_entity_code AND a.language_id = b.language_id AND b.cust_group_code = d.cust_group_code AND a.cust_group_code = b.cust_group_code AND a.cust_code = d.cust_code AND b.cust_group_code = '"+group_id+"' AND a.language_id = '"+locale+"' AND a.acc_entity_code IN (SELECT d.acc_entity_code FROM sy_acc_entity d  WHERE acc_entity_id = d.acc_entity_id) ) where 1 like ? and UPPER (code) LIKE UPPER (NVL (?, code)) AND UPPER (description) LIKE UPPER (NVL (?, description)) ORDER BY 2";    
			} else{
				argumentArray[0]="select cust_code code, long_name description from ar_customer_lang_vw where '1' like ? and language_id='"+locale+"' and upper(cust_code) like upper(nvl(?,cust_code)) and upper(long_name) like upper(nvl(?,long_name)) order by 2";
			}		
			argumentArray[1]=new Array("1");
			argumentArray[2]=new Array("1");
			argumentArray[3]=new Array(STRING);
			argumentArray[4]="2,3";
			argumentArray[5]=target.value;
			argumentArray[6]=CODE_DESC_LINK;
			argumentArray[7]=CODE_DESC;    
			var retVal= await CommonLookup(tit,argumentArray);		
			if(retVal==null || retVal=="")
				target.value="";
			else
				target.value=retVal[0];			  
	}

	async function searchgroupCode(obj,target){		
			var retVal = 	new String();
			var locale= "<%=localeName%>"
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var argumentArray=new Array(8);
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;		
			if(target.value=="" && window.event.target == target)
				return;
			tit=getLabel('Common.Customer.label','common'+''+'Common.GroupCode.label','common');
			argumentArray[0]="select cust_group_code code, long_desc description from ar_cust_group_lang_vw where '1' like ? and language_id='"+locale+"' and upper(cust_group_code) like upper(nvl(?,cust_group_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";        
			argumentArray[1]=new Array("'1'");
			argumentArray[2]=new Array("1");
			argumentArray[3]=new Array(STRING);
			argumentArray[4]="2,3";
			argumentArray[5]=target.value;
			argumentArray[6]=CODE_DESC_LINK;
			argumentArray[7]=CODE_DESC;    
			var retVal=await CommonLookup(tit,argumentArray);		
			if(retVal==null || retVal=="")
				target.value="";
			else
				target.value=retVal[0];		
	}
function mychangerepOPRefto()
 { 
	   if (document.getElementById("p_report_type").value=='Y')
	 {
		 document.forms[0].p_report_id.value="MPPALGRA";
		 document.getElementById("MY1").innerHTML=getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_year_date' id='p_year_date'  maxlength='4' size='4' onBlur=validateMonthYear(this); ><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_year_date.select();return showCalendar('p_year_date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if(document.getElementById("p_report_type").value=='M')
	 {
		 document.forms[0].p_report_id.value="MPPALGRA";
		 document.getElementById("MY1").innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_year_date' id='p_year_date' maxlength='7' size='7' onBlur=validateMonthYear(this);><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_year_date.select(); return showCalendar('p_year_date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 
 }
 function validateMonthYear(objDate){ 
	 //Added below date valdation for IN:47509
	if(objDate.value != ''){
		 var tmpDate =objDate.value;
		 var locale= "<%=localeName%>"
		 if(document.getElementById("p_report_type").value=="Y")
		 { 
			if(!validDate(tmpDate,"YY",locale)){
				alert(getMessage("INVALID_DATE_FMT", "SM"));
				objDate.value="";
				objDate.focus();
				return false;
			}
		 }
		 else if (document.getElementById("p_report_type").value=='M')
		 { 
			if(!validDate(tmpDate,"MY",locale)){
				alert(getMessage("INVALID_DATE_FMT", "SM"));
				objDate.value="";
				objDate.focus();
				return false;
			}
		 }
	}
 
 
 
 }

</script>
<%
String p_module_id	= "MP" ;
String p_report_id	= "MPPALGRA" ;
String p_facility_id = (String) session.getAttribute( "facility_id" ) ;
String p_user_name	= (String) session.getAttribute( "login_user" ) ;
String p_resp_id = (String)session.getAttribute("responsibility_id");
String fac_id    	= (String) session.getValue( "facility_id" ) ;
String locale = (String)session.getAttribute("LOCALE");
Connection con = null;
Statement stmt = null;
ResultSet rset = null;
PreparedStatement pstmt   = null;  
con = ConnectionManager.getConnection(request);
stmt=con.createStatement();
%>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey()'onLoad="mychangerepOPRefto();">
<center>
<form name="Patlistgroupbyage" id="Patlistgroupbyage" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR> 
<table border="0" width="80%" cellpadding='3' cellspacing='0'>
<tr>
	<td width='30%'>&nbsp;</td>
	<td width='30%'>&nbsp;</td>
	<td width='5%'>&nbsp;</td>
	<td width='35%'>&nbsp;</td>
</tr>
<tr>
<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class="fields"><select name='p_fac_id' id='p_fac_id'><!--  onChange='onChangeFacilityId()'> -->
<option value='' selected>--------------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------------- 
<%

pstmt = con.prepareStatement("select facility_id,facility_name from SM_FACILITY_PARAM_LANG_VW where language_id='"+locale+"' order by 2");
try

{
	  rset = pstmt.executeQuery();
	  if(rset!=null)
	  {
		  while(rset.next())
		  {
			String id=rset.getString(1);
			String name = rset.getString(2);
			if(id.equals(fac_id))
			  {
			%>
				<option value=<%=id%> selected><%=name%></option>
		  <%
			  }
			  else
			  {%>
				<option value=<%=id%>><%=name%> </option> 
			<%	}
				}
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
	  }
	  }catch(Exception e){out.println(e);}
	 finally
	 {
		if(con!=null) ConnectionManager.returnConnection(con,request); 
	 }
 
	  %></select></td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
				<tr>
					<td align='right' width='35%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%'>
						 <SELECT name="p_report_type" id="p_report_type" onchange='mychangerepOPRefto()'>
						 <option value="Y"><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option>
						 <option value="M"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
						 </SELECT>
						</td>
						<td align='right' id='MY1'class="label">&nbsp;</td>
						<td align='left' id='MY' > &nbsp; </td>
				
				</tr>
							

<tr>
	<td class="label"><fmt:message key="Common.Customer.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.GroupCode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type=text  name='P_CUSTOMER_GROUP_CODE' id='P_CUSTOMER_GROUP_CODE' size="4" maxlength="2" align="center" onBlur='searchgroupCode(P_CUSTOMER_GROUP_CODE, this)'><input type='button' name='company_group_id' id='company_group_id' value='?' class='button' onclick='searchgroupCode(this, P_CUSTOMER_GROUP_CODE)'>

	</td>
</tr>
		
<tr>
	<td class="label"><fmt:message key="Common.CustomerCode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type=text  name='P_CUSTOMER_CODE' id='P_CUSTOMER_CODE'  size="8" maxlength="8" align="center" onBlur='searchCustomerCode(P_CUSTOMER_CODE, this)'><input type='button' name='company_id' id='company_id' value='?' class='button' onclick='searchCustomerCode(this, P_CUSTOMER_CODE)'>
	</td>
</tr></table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=p_facility_id%>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%=p_module_id%>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%=p_report_id%>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=p_user_name%>">
<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%=p_resp_id %>">
<input type="hidden" name="p_language_id" id="p_language_id"			value="<%=locale%>">

</form>
</center>
</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

