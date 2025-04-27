<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.* "  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
 
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	//String p_report_id		= "IPPDISLT" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	String isSpltyNurUnitToEnableYNAppl="";//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js" language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
<script src="../../eCommon/js/common.js" language='javascript'></script>
<script src="../../eCommon/js/DateUtils.js" language='javascript'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>


 function validate_date(obj) {
	
		if(obj.value!=''){

			if(isBeforeNow(obj.value,"DMY",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
			}
		}
  }
  
   function validate_date1(obj) {
	
		if(obj.value!=''){

			if(isBeforeNow(obj.value,"DMYHM",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
			}
		}
  }


async function searchCode(obj,target)
	{		
			var retVal = 	new String();
			var locale= "<%=locale%>"
			/* var dialogHeight= "28" ;
			var dialogWidth	= "43" ; */
			var dialogTop = "10px" ;
			var dialogHeight= "400px" ;
			var dialogWidth="900px";
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
	
			if(obj.name=="company_id")
			{
				tit=getLabel('eBL.CompanyName.label','bl')
				var group_id=document.getElementById("p_company_group").value;
				
				if(group_id==""){
					sql="SELECT cust_code,long_name FROM ar_customer_lang_vw  where language_id =`"+locale+"` ";
					search_code="cust_code";
				    search_desc= "long_name";
				}else{
				     sql="select a.cust_code ,a.long_name FROM AR_CUSTOMER_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group d where a.acc_entity_code= b.acc_entity_code AND b.acc_entity_code= d.acc_entity_code AND a.language_id = b.language_id AND b.cust_group_code = d.cust_group_code AND a.cust_group_code = b.cust_group_code AND a.cust_code = d.cust_code AND a.patient_flag = `Y` AND NVL(a.pat_com_flag,`N`) = `N` AND NVL(a.insurance_yn,`Y`) = `Y` AND a.language_id=`"+locale+"` AND b.cust_group_code =`"+group_id+"`";
					search_code="d.cust_code";
				    search_desc= "long_name";
				}				
				
			}
			if(obj.name=="company_group_id")
			{
				tit=getLabel('Common.CompanyGroup.label','common');
				sql="select cust_group_code,short_desc from ar_cust_group_lang_vw where language_id=`"+locale+"` ";
				search_code="cust_group_code";
				search_desc= "short_desc";
			}
			if(obj.name=="nursing_unit_code")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`<%= p_facility_id%>` and language_id=`"+locale+"` ";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}
			if(obj.name=="cash_group_id"){
			tit=getLabel('Common.CashGroup.label','common');
			sql="SELECT BLNG_GRP_ID,SHORT_DESC FROM bl_blng_grp_lang_vw where settlement_ind =`C` and language_id=`"+locale+"` ";
			    search_code="blng_grp_id";
				search_desc= "short_desc";
			}
			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

	
	 function showHide()
        {
		 document.getElementById('adm_id').checked=true;
		 document.getElementById('dis_id').checked=false;
		 
				if(document.getElementById('adm_id').checked)
				{   
					document.getElementById('adm_date_id').style.visibility = 'visible';
					document.getElementById('dis_date_id').style.visibility = 'hidden';
					document.getElementById('adm_order_id').style.visibility = 'visible';
					document.getElementById('adm_order_id1').style.visibility = 'hidden';
					document.getElementById('dis_group_id').style.visibility = 'visible';
					document.getElementById('dis_group_id1').style.visibility = 'hidden';
					
					document.getElementById('CashGroup_disp_yn').style.visibility = 'hidden';
			                document.getElementById('CashPatient_td1').style.display = 'none';
					document.getElementById('CashGroup_td1').style.display = 'none';
					 document.getElementById('CashPat_id').checked=false;
					
					if(document.getElementById('CashPat_id').checked==false){ 
					document.getElementById("CompanyGroup").style.display = "";
					document.getElementById("CompanyName").style.display = "";
					document.getElementById("CashGroup_disp_yn").style.visibility = 'hidden';
					document.getElementById("CashPatient_td1").style.display = "none";
					document.getElementById("CompanyGroup_id").style.display = "";
					 }
					 document.getElementById("current_IP").style.display ="";
				
				
					
					document.getElementById('dis_hid').style.display = "none";
					document.getElementById('adm_hid').style.display = "";
					document.getElementById('order_hide').style.display = "";
					document.getElementById('group_hide').style.display = "none";
					document.getElementById("dis_date_from").value="";
				    document.getElementById("dis_date_to").value="";
					document.getElementById("p_company_group").value="";
				    document.getElementById("p_company_name").value="";
					document.getElementById("p_to_nursing_unit").value="";
				    document.getElementById("p_fm_nursing_unit").value="";
					document.getElementById("currentIP_id").checked=false
					 document.getElementById('adm_mand_1').style.display="" 
		                         document.getElementById('adm_mand_2').style.display="" 
					
			
				
			fields = new Array(getLabel("eBL.CompanyName.label","bl"),getLabel("Common.admissiondate.label","Common"),getLabel("Common.nursingUnit.label","Common"),getLabel("Common.PatientName.label","Common"))
			var selected =document.forms[0].p_adm_order_by;                
		    var order_length=selected.length
			var order_lengths=1;
			for(i=0; i<order_length; i++)
			selected.remove(selected.options[i]);
		
			for(i=0; i<fields.length; i++){
			var x = document.getElementById("p_adm_order_by");
            var option = document.createElement("option");
		    option.value = "";
		    
			option.value=order_lengths++;
			option.text=fields[i]
			
			x.add(option);} 
			
			
			fields = new Array(getLabel("eBL.CompanyName.label","bl"),getLabel("Common.CompanyGroup.label","Common"),getLabel("Common.admissiondate.label","Common"),getLabel("Common.nursingUnit.label","Common"))
			var selected =document.forms[0].p_adm_group_by;                
		    var order_length=selected.length
			var order_lengths=1;
			for(i=0; i<order_length; i++)
			selected.remove(selected.options[i]);
		
			for(i=0; i<fields.length; i++){
			var x = document.getElementById("p_adm_group_by");
            var option = document.createElement("option");
		    option.value = "";
		  
			option.value=order_lengths++;
			option.text=fields[i]
		
			x.add(option);} 
				
			
				
				document.getElementById('p_cash_group').value="";
				
				
				}
			}
			function showHide1()
			{
			document.getElementById('dis_id').checked=true;
			document.getElementById('adm_id').checked=false;
			
			   if(document.getElementById('dis_id').checked)
				{
					document.getElementById('dis_date_id').style.visibility = 'visible';
					document.getElementById('adm_date_id').style.visibility = 'hidden';
					document.getElementById('adm_order_id').style.visibility = 'hidden';
					document.getElementById('adm_order_id1').style.visibility = 'visible';
					document.getElementById('dis_group_id').style.visibility = 'hidden';
					document.getElementById('dis_group_id1').style.visibility = 'visible';
					
					 document.getElementById('CashPat_id').checked=false;
					  if(document.getElementById('CashPat_id').checked==false){  
					document.getElementById("CompanyGroup").style.display = "";
					document.getElementById("CompanyName").style.display = "";
					document.getElementById("CashGroup_disp_yn").style.visibility = 'hidden';
					document.getElementById("CashPatient_td1").style.display = "none";
					document.getElementById("CompanyGroup_id").style.display = "";
					 }
					 
				
					
					
					document.getElementById('adm_hid').style.display = "none";
					document.getElementById('dis_hid').style.display = "";
					document.getElementById('order_hide').style.display = "none";
					document.getElementById('group_hide').style.display = "none";
					document.getElementById("adm_date_from").value="";
				    document.getElementById("adm_date_to").value="";
					document.getElementById("p_company_group").value="";
				    document.getElementById("p_company_name").value="";
					document.getElementById("p_to_nursing_unit").value="";
				    document.getElementById("p_fm_nursing_unit").value="";
                   				
					document.getElementById("current_IP").style.display ="none";
						document.getElementById("currentIP_id").checked=false
					
					
					
					
				fields = new Array(getLabel("Common.nursingUnit.label","Common"),getLabel("eBL.CompanyName.label","bl"),getLabel("Common.dischargedate.label","Common"),getLabel("Common.PatientName.label","Common"))
				var selected =document.forms[0].p_dis_order_by;                
				var order_length=selected.length
				var order_lengths=1;
				for(i=0; i<order_length; i++)
				selected.remove(selected.options[i]);
		
				for(i=0; i<fields.length; i++){
				var x = document.getElementById("p_dis_order_by");
				var option = document.createElement("option");
				option.value = "";
			
				option.value=order_lengths++;
				option.text=fields[i]
			
				x.add(option);} 
			
			
				fields = new Array(getLabel("Common.nursingUnit.label","Common"),getLabel("Common.dischargedate.label","Common"),getLabel("eBL.CompanyName.label","bl"),getLabel("Common.CompanyGroup.label","Common"))
				var selected =document.forms[0].p_dis_group_by;                
				var order_length=selected.length
				var order_lengths=1;
				for(i=0; i<order_length; i++)
				selected.remove(selected.options[i]);
			
				for(i=0; i<fields.length; i++){
				var x = document.getElementById("p_dis_group_by");
				var option = document.createElement("option");
				option.value = "";
			
				option.value=order_lengths++;
				option.text=fields[i]
			
				x.add(option);} 
	
				document.getElementById('p_cash_group').value="";
				}
           }
		   
function fields_disable(obj){
		   
			if(obj.checked==true){
		
			document.getElementById("CompanyGroup").style.display = "none";
			document.getElementById("CompanyName").style.display = "none";
			document.getElementById("CashGroup_disp_yn").style.visibility = 'visible';
			document.getElementById("CashPatient_td1").style.display = "";
			
			document.getElementById("CompanyGroup_id").style.display = "none";
			
			
			fields = new Array(getLabel("Common.CashGroup.label","Common"),getLabel("Common.admissiondate.label","Common"),getLabel("Common.nursingUnit.label","Common"),getLabel("Common.PatientName.label","Common"))
			var selected =document.forms[0].p_adm_order_by;                
		    var order_length=selected.length
			for(i=0; i<order_length; i++)
			selected.remove(selected.options[i]);
			order_length=order_length+1;
			for(i=0; i<fields.length; i++){
			var x = document.getElementById("p_adm_order_by");
            var option = document.createElement("option");
		    option.value = "";
		    order_lengths=order_length++;
			option.value=order_lengths;
			option.text=fields[i]
			x.add(option);} 
				 
				 
		   	fields1 = new Array(getLabel("Common.CashGroup.label","Common"),getLabel("Common.admissiondate.label","Common"),getLabel("Common.nursingUnit.label","Common"))
		   	var selected1 =document.forms[0].p_adm_group_by; 
		    var order_length1=selected1.length
		    for(i=0; i<order_length1; i++)
		    selected1.remove(selected1.options[i]);
		    order_length1=order_length1+1;     
		    for(i=0; i<fields1.length; i++){
			var x = document.getElementById("p_adm_group_by");
            var option = document.createElement("option");
			option.value = "";
			order_lengths=order_length1++;
			option.value=order_lengths;
		    option.text=fields1[i]
			x.add(option);} 
		  
		   
		    fields2 = new Array(getLabel("Common.nursingUnit.label","Common"),getLabel("Common.CashGroup.label","Common"),getLabel("Common.dischargedate.label","Common"),getLabel("Common.PatientName.label","Common"))
			var selected2 =document.forms[0].p_dis_order_by;                
		    var order_length2=selected2.length;
			for(i=0; i<order_length2; i++)
			selected2.remove(selected2.options[i]);
			//order_length2=order_length2+1;
			order_length2=order_length2+2;     //modified by Sangeetha on 4/8/2016
			for(i=0; i<fields2.length; i++){
			var x = document.getElementById("p_dis_order_by");
            var option = document.createElement("option");
		    option.value = "";
		    order_lengths=order_length2++;
			option.value=order_lengths;
			option.text=fields2[i]
		
			x.add(option);}  
			
			
			fields1 = new Array(getLabel("Common.nursingUnit.label","Common"),getLabel("Common.dischargedate.label","Common"),getLabel("Common.CashGroup.label","Common","Common"))
		   	var selected1 =document.forms[0].p_dis_group_by; 
		    var order_length1=selected1.length
		    for(i=0; i<order_length1; i++)
		    selected1.remove(selected1.options[i]);
		    //order_length1=order_length1+1;
			order_length1=order_length1+2;      // modified by Sangeetha on 4/8/2016
		    for(i=0; i<fields1.length; i++){
			var x = document.getElementById("p_dis_group_by");
            var option = document.createElement("option");
			option.value = "";
			order_lengths=order_length1++;
			option.value=order_lengths;
		    option.text=fields1[i]
			
			x.add(option);} 
			
		   
		  
			
			} else{
			
			document.getElementById("CompanyGroup").style.display = "";
			document.getElementById("CompanyName").style.display = "";
			document.getElementById("CashGroup_disp_yn").style.visibility = 'hidden';
			document.getElementById("CashPatient_td1").style.display = "none";
			
			document.getElementById("CompanyGroup_id").style.display = "";
			document.getElementById('p_cash_group').value="";
			 
			
			fields = new Array(getLabel("eBL.CompanyName.label","bl"),getLabel("Common.admissiondate.label","Common"),getLabel("Common.nursingUnit.label","Common"),getLabel("Common.PatientName.label","Common"))
			var selected =document.forms[0].p_adm_order_by;                
		    var order_length=selected.length
			
		    for(i=0; i<order_length; i++)
			selected.remove(selected.options[i]);
		    order_length=1;
			for(i=0; i<fields.length; i++){
		    var x = document.getElementById("p_adm_order_by");
            var option = document.createElement("option");
			option.value = "";
			order_lengths=order_length++;
			option.value=order_lengths;
			option.text=fields[i]
			x.add(option);} 
				 
				 
		    fields1 = new Array(getLabel("eBL.CompanyName.label","bl"),getLabel("Common.CompanyGroup.label","Common"),getLabel("Common.admissiondate.label","Common"),getLabel("Common.nursingUnit.label","Common"))
		   	var selected1 =document.forms[0].p_adm_group_by; 
		    var order_length1=selected1.length
		    for(i=0; i<order_length1; i++)
		    selected1.remove(selected1.options[i]);
		    order_length1=1;     
		    for(i=0; i<fields1.length; i++){
				 var x = document.getElementById("p_adm_group_by");
                   var option = document.createElement("option");
				   option.value = "";
				   order_lengths=order_length1++;
				    option.value=order_lengths;
				    option.text=fields1[i]
					x.add(option);
				 } 
		
			
			fields = new Array(getLabel("Common.nursingUnit.label","Common"),getLabel("eBL.CompanyName.label","bl"),getLabel("Common.dischargedate.label","Common"),getLabel("Common.PatientName.label","Common"))
			var selected =document.forms[0].p_dis_order_by;                
		    var order_length=selected.length
			
		    for(i=0; i<order_length; i++)
			selected.remove(selected.options[i]);
		    order_length=1;
			for(i=0; i<fields.length; i++){
		    var x = document.getElementById("p_dis_order_by");
            var option = document.createElement("option");
			option.value = "";
			order_lengths=order_length++;
			option.value=order_lengths;
			option.text=fields[i]
			
			x.add(option);} 
			
			
			 fields1 = new Array(getLabel("Common.nursingUnit.label","Common"),getLabel("Common.dischargedate.label","Common"),getLabel("eBL.CompanyName.label","bl"),getLabel("Common.CompanyGroup.label","Common"))
		   	var selected1 =document.forms[0].p_dis_group_by; 
		    var order_length1=selected1.length
		    for(i=0; i<order_length1; i++)
		    selected1.remove(selected1.options[i]);
		    order_length1=1;     
		    for(i=0; i<fields1.length; i++){
				 var x = document.getElementById("p_dis_group_by");
                   var option = document.createElement("option");
				   option.value = "";
				   order_lengths=order_length1++;
				    option.value=order_lengths;
				    option.text=fields1[i]
					x.add(option);
				 } 
			
		
			
			
			}
		   }
		   
		   function enable_disable(obj){
		   if(obj.checked==true){
		  
		   document.getElementById('adm_mand_1').style.display="none" 
		   document.getElementById('adm_mand_2').style.display="none" 
		   document.getElementById('adm_date_from').value=""
		   document.getElementById('adm_date_to').value=""
		 
		   }else{
		
		    document.getElementById('adm_mand_1').style.display="" 
		    document.getElementById('adm_mand_2').style.display="" 
			  document.getElementById('adm_date_from').value=""
			  document.getElementById('adm_date_to').value=""
			 
		   }
		    
		   }
		   
</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onload='showHide()'  onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2PatDischargeForm" id="Rep2PatDischargeForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
	Connection con  =  null;
	Statement stmt = null;
	StringBuffer sql1 = new StringBuffer();
	sql1.append("Select PRACT_TYPE, DESC_USERDEF,to_char(sysdate,'dd/mm/yyyy')CurrentDate From AM_PRACT_TYPE_lang_vw Where EFF_STATUS = 'E'  and language_id='"+locale+"' order by 2" );
	ResultSet rset = null;
	String CurrentDate = "";
	
	StringBuffer StrVal = new StringBuffer();

    try
    {
		con  =  ConnectionManager.getConnection(request);
		isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
		stmt = con.createStatement(); 
		rset = stmt.executeQuery(sql1.toString());


		if(rset != null)
		{
			while(rset.next())
			{
				StrVal.append(" <option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option> ");
				CurrentDate=rset.getString("CurrentDate");

				
			}
		}
	 }
	 catch(Exception e){/* out.println(e); */ e.printStackTrace();}
	 finally
	 {
		 try
		 {
			if(rset != null)    rset.close();
			if(stmt != null)    stmt.close();
		 }
		 catch(Exception e)
		 {
		 /* out.println("Exception in tryCatch : "+ e.toString()); */ e.printStackTrace();}
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }
%>
           <table width='30%' align='center' valign='top'>

				<tr>
				<td width='3%'><input type='radio' id='adm_id' checked onClick="showHide();"></td>
				<td align='right' width='30%' class="label">
				<fmt:message key="eIP.AdmissionReport.label" bundle="${ip_labels}"/></td>
						
			    <td width='3%'><input type='radio' id='dis_id'  onClick="showHide1();"></td>
				<td align="center" width='30%' class="label">
				<fmt:message key="eIP.DischargeReport.label" bundle="${ip_labels}"/></td>
						
				</tr>
				 <tr>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp;&nbsp;</td>
			    </tr>
		</table>
   <table width='80%' align='center' >

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>
	<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

				<tr>
					<td align="center" width="30%">&nbsp;</td>
					<td class="querydata" width="30%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
	
				</tr>	
				     <tr id='adm_hid'>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
			    	</tr>
                 <tr id='adm_date_id'>
 				<td align='left' width='30%' class="label"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='40%'  >
							<input type=text id="adm_date_from"  name='p_fm_admission_date' id='p_fm_admission_date' size="16" maxlength="16" align="center" onblur="if(validDateObj(this,'DMYHM',localeName))validate_date1(this)"><img src='../../eCommon/images/CommonCalendar.gif' onClick="Rep2PatDischargeForm.p_fm_admission_date.focus();return showCalendar('adm_date_from','dd/mm/yyyy' ,'hh:mm',null);"/>&nbsp;<img src='../../eCommon/images/mandatory.gif' id="adm_mand_1"></img>
						</td>
						<td width='30%'> 
							<input type=text id="adm_date_to"  name='p_to_admission_date' id='p_to_admission_date' size="16" maxlength="16" align="center" onblur="if(validDateObj(this,'DMYHM',localeName))validate_date1(this)"><img src='../../eCommon/images/CommonCalendar.gif' onClick="Rep2PatDischargeForm.p_to_admission_date.focus();return showCalendar('adm_date_to','dd/mm/yyyy' ,'hh:mm',null);"/>&nbsp;<img src='../../eCommon/images/mandatory.gif' id="adm_mand_2"></img>
						</td>
				</tr>
                 				

				<tr id='dis_date_id'>
						<td align='left' width='30%' class="label"><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='30%'  >
							<input type=text id="dis_date_from"  name='p_fm_discharge_date' id='p_fm_discharge_date' size="10" maxlength="10" align="center" onblur="if(validDateObj(this,'DMY',localeName))validate_date(this)"><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dis_date_from');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
						<td width='40%'> 
							<input type=text id="dis_date_to"  name='p_to_discharge_date' id='p_to_discharge_date' size="10" maxlength="10" align="center" onblur="if(validDateObj(this,'DMY',localeName))validate_date(this);"><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dis_date_to');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
				</tr>
                    <tr id='dis_hid'>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
			    	</tr>
				
				<tr><!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
				<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
				<tr>
				<jsp:include page="CommonNursingUnitLookup.jsp">
				<jsp:param name="nursing_unit_code_Appl" value="p_fm_nursing_unit"/>
				<jsp:param name="nursing_unit_to_code_Appl" value="p_to_nursing_unit"/>
				</jsp:include></tr>
				<%}else{%>
						<td align='left' width='30%' class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='30%'  >
							<input type=text  name='p_fm_nursing_unit' id='p_fm_nursing_unit' id='p_fm_nursing_unit' size="15" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_fm_nursing_unit)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_nursing_unit' id='p_to_nursing_unit' id='p_to_nursing_unit'size="14" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit)'>
						</td>
				<%}%>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
            	
				 <tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.CashPatient.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='30%'>
							<input type=checkbox  id='CashPat_id' name='CashPat' id='CashPat'	 onClick="fields_disable(this)" align="center">
						</td>
						<td id="current_IP" align='right'  class="label"><fmt:message key="eBL.CURR_IP.label" bundle="${bl_labels}"/><input type=checkbox  name='current_patient' id='current_patient' value="N" id='currentIP_id' onClick="enable_disable(this)" align="center"></td>
						
				  </tr>
				  	<tr id="CashPatient_td1">
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					</tr>
					 <tr id='CashGroup_disp_yn' >
						<td align='left' width='30%' class="label"><fmt:message key="Common.CashGroup.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='30%'  >
							<input type=text  name='p_cash_group' id='p_cash_group' id='p_cash_group' size="4" maxlength="2" align="center"><input type='button' name='cash_group_id' id='cash_group_id' value='?' class='button' onclick='searchCode(this, p_cash_group)'>
						</td>
				  </tr>
				<tr id='CashGroup_td1'>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					</tr>
				
				 <tr id="CompanyGroup">
						<td align='left' width='30%' class="label"><fmt:message key="Common.CompanyGroup.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='30%'  >
							<input type=text  name='p_company_group' id='p_company_group' id='p_company_group'size="4" maxlength="2" align="center"><input type='button' name='company_group_id' id='company_group_id' value='?' class='button' onclick='searchCode(this, p_company_group)'>
						</td>
				  </tr>
				<tr id="CompanyGroup_id">
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
			        <tr id="CompanyName">
						<td align='left' width='30%' class="label"><fmt:message key="eBL.CompanyName.label" bundle="${bl_labels}"/> &nbsp;</td>
						<td width='30%'  >
							<input type=text  name='p_company_name' id='p_company_name' id='p_company_name' size="8" maxlength="8" align="center"><input type='button' name='company_id' id='company_id' value='?' class='button' onclick='searchCode(this, p_company_name)'>
						</td>
				  </tr>
				<tr id='order_hide'>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr id='adm_order_id'>
					<td align='left' width='30%' class="label">
						<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  width='30%' align="left">
						<select id='p_adm_order_by' name='p_adm_order_by' id='p_adm_order_by'>
						
						<option value='1'><fmt:message key="eBL.CompanyName.label" bundle="${bl_labels}"/>
						<option value='2'><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/>
						<option value='3'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
						<option value='4'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
						
						</select>
					</td>
				</tr>
				
				<tr id='adm_order_id1'>
					<td align='left' width='30%' class="label">
						<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  width='30%' align="left">
						<select id='p_dis_order_by' name='p_dis_order_by' id='p_dis_order_by'>
						<option value='1'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
						<option selected value='2'><fmt:message key="eBL.CompanyName.label" bundle="${bl_labels}"/>
						<option value='3'><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/>
						<option value='4'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
						
						</select>
					</td>
				</tr>
				<tr id='group_hide'>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr id='dis_group_id'>
					<td align='left' width='30%' class="label">
						<fmt:message key="Common.groupby.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  width='30%' align="left">
						<select id='p_adm_group_by' name='p_adm_group_by' id='p_adm_group_by'>
						<option value='1'><fmt:message key="eBL.CompanyName.label" bundle="${bl_labels}"/>
						<option value='2'><fmt:message key="Common.CompanyGroup.label" bundle="${common_labels}"/>
						<option value='3'><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/>
						<option value='4'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				
				<tr  id='dis_group_id1'>
					<td align='left' width='30%' class="label">
						<fmt:message key="Common.groupby.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  width='30%' align="left">
						<select id='p_dis_group_by' name='p_dis_group_by' id='p_dis_group_by'>
						<option value='1'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
						<option value='2'><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/>
                        <option selected value='3'><fmt:message key="eBL.CompanyName.label" bundle="${bl_labels}"/>
						<option value='4'><fmt:message key="Common.CompanyGroup.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				</table>
	
	</td>
</tr>
</table>
	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
	
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
	<input type="hidden" name="p_current_patient" id="p_current_patient"		value="">

     <input type="hidden" name="p_cash" id="p_cash"		value=">
	<input type="hidden" name="CurrentDate" id="CurrentDate"		value="<%= CurrentDate %>">


</form>
</BODY>
</HTML>

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

