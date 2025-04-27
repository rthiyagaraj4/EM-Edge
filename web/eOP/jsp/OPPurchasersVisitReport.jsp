<!DOCTYPE html>

<%--
Filename		: OPPurchasersVisitReport.jsp
Modified On		: 1-3-2005
Version			: 3
--%>

<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8"); 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String p_facility_id		= (String) session.getValue( "facility_id" );
String p_user_name		= (String) session.getValue( "login_user" );
String locale=(String)session.getAttribute("LOCALE");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>



<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>

<script>



async function searchClinicCode(obj,target){  
	var facilityid = "<%=p_facility_id%>";
	var tit="";
	var locale = "<%=localeName%>"; 		
	target.value=trimString(target.value);
	if(target.value=="" && window.event.target == target)
		return;	
	var argumentArray=new Array(8);
	if(obj.name=="tolocn" || obj.name=="fromlocn"){
        tit=getLabel("Common.locationcode.label","Common");
		argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' and facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) and clinic_type IN ('C','E') and LEVEL_OF_CARE_IND = 'A' order by 2";                
		argumentArray[1]=new Array("facility_id");
		argumentArray[2]=new Array(facilityid);
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;                
    }else{		
		return;            
	}
	
	var retVal=await CommonLookup(tit,argumentArray);

	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retVal==null || retVal=="")
				target.value="";
			else
				target.value=arr[0];
		            
}

async function searchCustomerCode(obj,target) {	
			var retVal = 	new String();
			var locale= "<%=localeName%>"
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
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
			group_id = document.forms[0].P_CUSTOMER_GROUP.value;		
			tit=getLabel('Common.CustomerCode.label','common')	
			if(group_id!=""){
				argumentArray[0]="select code,description from (SELECT a.cust_code code, a.long_name description FROM ar_customer_lang_vw a,ar_cust_group_lang_vw b,         bl_cust_by_cust_group d  WHERE a.acc_entity_code =  b.acc_entity_code AND b.acc_entity_code =d.acc_entity_code AND a.language_id = b.language_id AND b.cust_group_code = d.cust_group_code AND a.cust_group_code = b.cust_group_code AND a.cust_code = d.cust_code AND b.cust_group_code = '"+group_id+"' AND a.language_id = '"+locale+"' AND a.acc_entity_code IN (SELECT d.acc_entity_code FROM sy_acc_entity d  WHERE acc_entity_id = d.acc_entity_id) ) where 1 like ? and UPPER (code) LIKE UPPER (NVL (?, code)) AND UPPER (description) LIKE UPPER (NVL (?, description)) ORDER BY 2";    
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
			var retVal=await CommonLookup(tit,argumentArray);		
			var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retVal==null || retVal=="")
				target.value="";
			else
				target.value=arr[0];			  
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
			var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retVal==null || retVal=="")
				target.value="";
			else
				target.value=arr[0];		
	}


function ComparePeriodFromToTime(from,to)
{
	
	var frdt = document.getElementById("mdsfrom").value; 
	var tdt = document.getElementById("mdsto").value;
	var greg_tdt = "";
	var greg_frdt = "";

	if(frdt !="" && validDate(frdt,"DMY","en"))
	{
		greg_frdt = convertDate(frdt,"DMY",localeName,"en");
	}

	if(to !="" && validDate(tdt,"DMY","en"))
	{
		greg_tdt = convertDate(tdt,"DMY",localeName,"en");
	}
	
	if(greg_frdt != "" && greg_tdt !="")
	{
		if(!isBefore(greg_frdt,greg_tdt,"DMY","en"))
		{
			alert( getMessage("TO_DT_GR_EQ_FM_DT",'SM') );
			//document.forms[0].TO_VIST_DATE.value="";
			document.forms[0].TO_VIST_DATE.focus();
			document.forms[0].TO_VIST_DATE.select();
		}
	}
}
function setDate(Object){ 
//var currentDate = new Date();
       if(Object.value!="")
	{
	   if (isBeforeNow(Object.value,"DMY",localeName))
        {
          return true;
        }
        else
        {
			alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
			Object.value="";
            Object.focus();            
        }
    }
	}
</script>

<%
    String p_module_id      = "OP" ;
    String p_report_id      = "OPDOPVIR" ;
     Statement stmt=null;
    ResultSet rset=null ;

    Connection con = null;
try{
	con = ConnectionManager.getConnection(request);
%>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<center>
    <form name="opPurchaseVisit" id="opPurchaseVisit" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
    <BR><!--BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR-->

<table width='80%' align='center' valign='top'>
<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>

</table>
<table width='80%' cellPadding="2" cellSpacing="0" align='center' border='0'>

<tr>
	<td width='33%'>&nbsp;</td>
	<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
	<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</tr>

<tr>
    <td  class="label"><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></td>
	<td class='fields'>
                <input type=text id='mdsfrom' name='FM_VIST_DATE' id='FM_VIST_DATE' size="10" maxlength="10" onblur='if(validDateObj(this,"DMY",localeName)){setDate(this)};ComparePeriodFromToTime(FM_VIST_DATE,this);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsfrom');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img> 
    </td>     
    <td class='fields'>
              <input type=text id='mdsto' name='TO_VIST_DATE' id='TO_VIST_DATE' size="10" maxlength="10" onblur='if(validDateObj(this,"DMY",localeName)){setDate(this)};ComparePeriodFromToTime(TO_VIST_DATE,this);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsto');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img>
      </td>
</tr>
<tr>
<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
 <td class='fields'><input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="4" maxlength="4" onBlur='searchClinicCode(fromlocn, this)'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchClinicCode(this, p_fm_locn_code)'>
	</td>	
	<td class='fields'>
	    <input type="text" name="p_to_locn_code" id="p_to_locn_code" size="4" maxlength="4" onBlur='searchClinicCode(tolocn, this)'><input type='button' name='tolocn' id='tolocn' value='?' class='button' onclick='searchClinicCode(this, p_to_locn_code)'>
	</td>
 
	
</tr>
<tr>
	<td class="label"><fmt:message key="Common.Customer.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.GroupCode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type=text  name='P_CUSTOMER_GROUP' id='P_CUSTOMER_GROUP' size="4" maxlength="2" align="center" onBlur='searchgroupCode(P_CUSTOMER_GROUP, this)'><input type='button' name='company_group_id' id='company_group_id' value='?' class='button' onclick='searchgroupCode(this, P_CUSTOMER_GROUP)'>

	</td>
	<td class='label' colspan="2"></td>
</tr>
		
<tr>
	<td class="label"><fmt:message key="Common.CustomerCode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type=text  name='P_CUSTOMER_NAME' id='P_CUSTOMER_NAME'  size="8" maxlength="8" align="center" onBlur='searchCustomerCode(P_CUSTOMER_NAME, this)'><input type='button' name='company_id' id='company_id' value='?' class='button' onclick='searchCustomerCode(this, P_CUSTOMER_NAME)'>
	</td>
	<td class='label' colspan="2"></td>
</tr>			   
</table>
        <br>
			<%if(locale.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(locale.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
        <input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
        <input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
        <input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
        <input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
        <input type="hidden" name="p_fr_month" id="p_fr_month"          value="">
        <input type="hidden" name="p_to_month" id="p_to_month"          value="">
        <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
		<input type="hidden" name="P_FM_VIST_DATE" id="P_FM_VIST_DATE"       value="">
        <input type="hidden" name="P_TO_VIST_DATE" id="P_TO_VIST_DATE"         value="">
       

	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>


<%}catch(Exception e) { out.println(e.toString());}
finally
{
	try{
		if(stmt != null) stmt.close();
		if(rset != null) rset.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
if( con !=null ) ConnectionManager.returnConnection(con,request);
}
%>
    </form>
</center>
</body>
</html>

