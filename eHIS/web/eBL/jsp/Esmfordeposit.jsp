<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.op.CurrencyFormat, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>   
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
						
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Billing Service Details</title>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%!private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
} 

private String qtydecimal(String input)
{
		CurrencyFormat cf1 = new CurrencyFormat();		
	input = cf1.formatCurrency(input,2);  
	return input;
}


%>
<%


HttpSession httpSession = request.getSession(false);

Properties p = (Properties)httpSession.getValue("jdbc");

String locale	= (String)session.getAttribute("LOCALE");	
if(locale==null || locale.equals("")) locale="en";	


String facilityid = (String) session.getValue("facility_id");
System.out.println("facilityid::::::"+facilityid);
if (facilityid==null) facilityid = "";

String	strloggeduser	=  (String) session.getValue("login_user");	
if (strloggeduser==null) strloggeduser = "";

String strclientip = p.getProperty("client_ip_address");
if (strclientip==null) strclientip = "";

String patient_id = request.getParameter("patient_id");	
if(patient_id==null) patient_id="";	
System.out.println("patient_id="+patient_id);


String episode_type = request.getParameter("episode_type");	
if(episode_type==null) episode_type="";	
System.out.println("episode_type ="+episode_type );



String strepisode_id = replaceNull(request.getParameter("episode_id"));	
int episode_id=0;
if("".equals(strepisode_id)){
	episode_id=0;
}		
else
{
	try
	{
		episode_id=Integer.parseInt(strepisode_id);	
	}catch(Exception e)
	{
		episode_id=0;
	}
}
//if(episode_id==null) episode_id="";	
System.out.println("Episode id ="+episode_id);

String strVisit_id = replaceNull(request.getParameter("visit_id"));	
int visit_id=0;
if("".equals(strVisit_id)){
	visit_id=0;
}		
else
{
	try
	{
		visit_id=Integer.parseInt(strVisit_id);	
	}catch(Exception e)
	{
		visit_id=0;
	}
}
System.out.println("visit_id="+visit_id);
String strencounter_id = replaceNull(request.getParameter("encounter_id"));	
int encounter_id=0;
if("".equals(strencounter_id)){
	encounter_id=0;
}		
else
{
	try
	{
		encounter_id=Integer.parseInt(strencounter_id);	
	}catch(Exception e)
	{
		encounter_id=0;
	}
} 
System.out.println("encounter_id="+encounter_id);
String beanId = "EstimateDepositBean";
String beanName = "eBL.BLEstimateDepositBean";
BLEstimateDepositBean depositbean = (BLEstimateDepositBean) getBeanObject(beanId, beanName, request); 
depositbean = (BLEstimateDepositBean) getBeanObject(beanId, beanName, request);
List<BLEstimateDepositBean> depositlist2 = depositbean.getDepositList();
int lastRow = 0;

//int size=depositlist1.size();

/*/* 
System.out.println("Bean Add");
for (Iterator iterator = depositlist2.iterator(); iterator.hasNext();)
{
depositbean = (BLEstimateDepositBean) iterator.next();
System.out.println("service code="+depositbean.getService_code());
System.out.println("charges="+depositbean.getCharges());
System.out.println("qty="+depositbean.getQty());
System.out.println("Rc="+depositbean.getRate_charge());
System.out.println("datetime="+depositbean.getDatetime());
System.out.println("line="+depositbean.getLine());
System.out.println("service_indicator="+depositbean.getService_indicator());
System.out.println("service_desc="+depositbean.getService_desc());
} */




%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/messages.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>			
		<script language='javascript' ></script>	
			
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<script language="javascript" src="../../eBL/js/BLDepositReceipt.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		
			
			<script>
			

			 $(document).ready(function(){    
				 Datetime(1);   
				 //$('#esttotal').val(0);
				 });

			 function putdeci(object)
				{
				 		if(object.value!='')
					{
				
					var decimal=2;
					putDecimal(object,17,decimal);
					}
				}
			 
			 function fnClearCode(obj) {
					obj.value = '';
				}
			 
			async function ServcodeLookup(service_desc1,service_code1,index)
			{
				
				if($('#service_code'+index).val()=='')
					{
						$('#qty'+index).val()=='';
					$('#charges_'+index).val()=='';
					}
				
				var formObj=document.Esmfordeposit;
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("eBL.SelectBillingService.label","BL");
				var locale=formObj.locale.value;
				var query='';
				var facility_id = formObj.facility_id.value; 
				query ="Select Code,Description from(SELECT ALL BL_BLNG_SERV_LANG_VW.BLNG_SERV_CODE Code, BL_BLNG_SERV_LANG_VW.SHORT_DESC Description FROM BL_BLNG_SERV_LANG_VW where LANGUAGE_ID = ('"+locale+"')) where upper(Code) like upper(?) and upper(Description) like upper(?) order by BL_BLNG_SERV_LANG_VW.SHORT_DESC "; 		
				argumentArray[0]	= query;
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = service_desc1.value;
				argumentArray[6]   = DESC_LINK ;
				argumentArray[7]   = CODE_DESC ;
				//alert('argumentArray=> '+argumentArray);
				retVal = await CommonLookup( title, argumentArray );
				var ret1=unescape(retVal);
			 	var arr=ret1.split(",");
			 	if(arr[1]==undefined) 
		 		{
			 		arr[0]="";	
			 		arr[1]="";	
		 		}
				//alert('serv code'+argumentArray[5]);
			if(retVal != null && retVal != "")
					{ 		
			   		document.getElementById('service_code'+index).value = arr[0];
			   		document.getElementById('service_desc'+index).value = arr[1];
			   		//document.getElementById('datetime'+index).value = today;
			   		document.getElementById('qty'+index).value = '1.00';
			   		
			   		estdeposit(index);
					}
			else
					{	
				document.getElementById('service_code'+index).value= "";
				document.getElementById('service_desc'+index).value="";
			
				document.getElementById('qty'+index).value=""; 
				document.getElementById('charges_'+index).value=""; 
					
					}
			} 
	 function addrow(index)
	 {
		 
		 
		 
			var index = $('#estimatedeposit tr:last').attr('data-id');
			//alert(index)
			if(isNaN(index)){
				index = 0;
			}
			var formObj=document.Esmfordeposit;
			index= parseInt(index)+parseInt(1);
			//alert(index);	
			document.getElementById("lastrow").value=index;
			//alert(index);
			//alert(document.getElementById('datetime'+index)=Datetime();
			var totalRows =  $('#estimatedeposit tr').length+parseInt(1);
			
				
			
			var tableRow = "<tr id='tr_"+index+"' data-id='"+index+"' indexval='"+index+"'> "+									
			"<td  width='2.5%' class='fields'>"+
			"<input type='text' id='line"+index+"' name='line"+index+"' id='line"+index+"' size='05' maxlength='30' value='"+totalRows+"'  readonly></td>"+
	 		"<td  width='2.5%' class='fields'>"+
			"<input type='text' id='service_indicator"+index+"' name='service_indicator"+index+"' id='service_indicator"+index+"' size='05' maxlength='30' value='S' onBlur='Datetime("+index+");' readonly></td>"+
			"<td width='3.5%' class='fields'>"+
			"<input type='text' id='datetime"+index+"' name='datetime"+index+"' id='datetime"+index+"' size='17' maxlength='30' value='' readonly>" +"</td>"+
			"<td width='3.5%' class='fields'>"+
			"<input type='text' id='service_code"+index+"' name='service_code"+index+"' id='service_code"+index+"' size='03' maxlength='30' value='' onBlur='ServcodeLookup(service_code"+index+",service_desc"+index+","+index+");'>"+"<input type='text' id='service_desc"+index+"' name='service_desc"+index+"' id='service_desc"+index+"' size='07' maxlength='30' value='' onBlur='ServcodeLookup(service_desc"+index+",service_code"+index+","+index+");' >"+"<input type='button' class='button' name='serv_code"+index+"' id='serv_code"+index+"' id='serv_code"+index+"' value='?' tabindex='0' onClick='ServcodeLookup(service_desc"+index+",service_code"+index+","+index+");'>"+"</td>"+
			"<td width='3.5%' class='fields'>"+
			"<input type='text' id='Rc"+index+"' name='Rc"+index+"' id='Rc"+index+"' size='07' maxlength='30' value='' readonly>"+"</td>"+
			"<td width='3.5%' class='fields'>"+
			"<input type='text' id='qty"+index+"' name='qty"+index+"' id='qty"+index+"' size='07' maxlength='30' value='1.00' onBlur='estdeposit("+index+");putdeci(this);' onKeyPress='return(ChkNumberInput(this,event,2))' "+"</td>"+
			"<td width='3.5%' class='fields'> "+
			"<input type='text' id='charges_"+index+"' name='charges_"+index+"' id='charges_"+index+"' size='07' maxlength='30' value='' onBlur='findTotal();' >"+"</td>"+
			"<td width='3.5%' class='fields'> "+
			"<input type='checkbox' name='selected_row"+index+"' id='selected_row"+index+"'  id='selected_row"+index+"' value='' onClick=''>"+"</td>"+
			"</tr>";
			//alert(tableRow);			

		 $('#estimatedeposit').append(tableRow);
		 Datetime(index);
		 
		 //if($('#esttotal').val())
		
	 
	 }
	 		
				function delrow()
	 			{
						
						
					var index = $('#estimatedeposit tr:last').attr('data-id');
					/*if ($('#selected_row1').prop("checked"))
					 {
						//alert('in first row');
						document.getElementById("charges_1").value="";
						document.getElementById("service_code1").value="";
						document.getElementById("service_desc1").value="";
						findTotal();
					 	
					 }
					 else
						 {*/
					for(i=0;i<=index;i++)
			 		{
			 			if ($('#selected_row'+i).prop("checked"))
			 			{ 	
			 			$('#tr_'+i).remove();
			 			findTotal();
			 			}
			 		       	
			 		}
					var i=1;
			 		$('input[id^=line]').each(function(){
	              	$(this).val(i);
	              	i++;
	          		});
						// }
	 			}
			
			function save()
			{
				var lrow = $('#estimatedeposit tr:last').attr('data-id');
				//var lastrow=document.getElementById("lastrow").value;
				
			var index = $('#estimatedeposit tr:last').attr('data-id');
		

			if($('#charges_'+index).val()=='')
				{
				alert('Charges Cannot be null');
				return;
				}
			
			
			if($('#qty'+index).val()=='')
				{
				alert(getMessage('BL00302','BL'));
				return;
				}
				
				if(lrow==undefined)
					{
					lrow=0;
					}
				
				var base_qty=document.getElementById("base_qty").value;
				//alert("base_qty"+base_qty);
				var base_rate=document.getElementById("base_rate").value;
				//alert("base_rate"+base_rate);
				var day_type_code=document.getElementById("day_type_code").value;
				//alert("day_type_code"+day_type_code);
				var time_type_code=document.getElementById("time_type_code").value;
				//alert("time_type_code"+time_type_code);				
				var esttotal=document.getElementById("esttotal").value;
				
				var dynamicParams= '';
				
				
				for(var i=1;i<=lrow;i++)
				{	 
				
					dynamicParams += 'qty'+i+'='+$('#qty'+i).val()+'&'+
                    'service_code'+i+'='+$('#service_code'+i).val()+'&'+
                    'service_desc'+i+'='+$('#service_desc'+i).val()+'&'+
                    'charges_'+i+'='+$('#charges_'+i).val()+'&'+
                    'datetime'+i+'='+$('#datetime'+i).val()+'&'+
					'service_indicator'+i+'='+$('#service_indicator'+i).val()+'&'+			
					'line'+i+'='+$('#line'+i).val()+'&'+								
					'Rc'+i+'='+$('#Rc'+i).val()+'&';
					//'esttotal'+i+'='+$('#esttotal'+i).val()+'&';
					//alert('esttotal'+'esttotal'+i+'='+$('#esttotal'+i).val()+'&');
					
				 } 
				
	 				$.ajax({	
					type : 'POST',
					url:"../jsp/Estimatdepositajaxcall.jsp?lrow="+lrow+"&base_qty="+base_qty+"&base_rate="+base_rate+"&day_type_code="+day_type_code+"&time_type_code="+time_type_code+"&esttotal="+esttotal,
					data:dynamicParams,
					async:false,
                    success:function(data){
                     //alert('success');
                    }
                    }); 
	 				//window.returnvalue();
				var stlmttotal=document.getElementById('esttotal').value;
				parent.window.returnValue=stlmttotal;
				parent.window.close();
				/*top.returnValue = stlmttotal
						top.close();*/
				}
				
	 	
	 			
			
				 function Datetime(index)
				 {						
							var today=getCurrentDate('DMYHMS' ,'"+locale+"');
							document.getElementById('datetime'+index).value = today;
				}
				 function roundToTwo(num) 
				 {    
					 		return +(Math.round(num + "e+2")  + "e-2");
				 }

					 

				 function findTotal()
				 {
					 //alert('calling findtotal')
				       	  var total_amount = 0; 
							 var rowAmount = 0;
				          $('input[id^=charges_]').each(function(){
				        	 if($(this).val() == ''){
				        		 rowAmount = 0;
				        	 }
				        	 else{
				        		 rowAmount = $(this).val();
				        	 }
				       	  total_amount = parseFloat(total_amount) + parseFloat(rowAmount);
					      total_amount = roundToTwo(total_amount);
				          });    
				        
				          
				          $('#esttotal').val(parseFloat(total_amount).toFixed(2)); 
				  }
				 
			 function estdeposit(index)
				 {	
				 	
				 	if($('#qty'+index).val()=='')
				 		{
				 		alert(getMessage('BL00302','BL'));
				 		return;
				 		}
				 	var formObj=document.Esmfordeposit;
				 	var facility_id=formObj.facility_id.value;
				 	var locale=formObj.locale.value;
				 	var patient_id=formObj.patient_id.value;
				 	var episode_id=formObj.episode_id.value;
				 	var episode_type=formObj.episode_type.value;
				 	var encounter_id=formObj.encounter_id.value;				 	
				 	var visit_id=formObj.visit_id.value;				 	
				 	var qty=document.getElementById('qty'+index).value;
				 	var service_code=document.getElementById('service_code'+index).value;
				 	var service_indicator=document.getElementById('service_indicator'+index).value;
				 	var datetime=document.getElementById('datetime'+index).value;
				 	$.ajax({	
						type : 'POST',
						url : "../jsp/BlDepositremarks.jsp?func_mode=estdep&facility_id="+facility_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&patient_id="+patient_id+"&visit_id="+visit_id+"&qty="+qty+"&service_code="+service_code+"&service_indicator="+service_indicator+"&datetime="+datetime,
					    async:false,
					    dataType:"text",
					    success: function(data){
					    	
					    	var dataArr = $.trim(data).split("::"); 	
				
					    	var error_id=dataArr[2];
				
				    								    	
					   		if((error_id=='' || error_id=='null'))
					    		{
									
					   			/*var charges=
					   			alert(charges);*/
					   			
					    		document.getElementById('Rc'+index).value=dataArr[0];
					   					if(document.getElementById('Rc'+index).value=='R')
					    		{
					    						    		document.getElementById('charges_'+index).readOnly=true;
					    						    							    		}
					   					else if(document.getElementById('Rc'+index).value=='C')
							    		{
							    						    		document.getElementById('qty'+index).readOnly=true;
							    		}
					   					
					   			var chrgs=dataArr[1];					   			
					   			chrgs=parseFloat(chrgs).toFixed(2)
					   			//alert(chrgs);					   			
					    		document.getElementById('charges_'+index).value=chrgs;                 
						    	document.getElementById('base_qty').value=dataArr[3];
						    	document.getElementById('base_rate').value=dataArr[5];
						    	document.getElementById('day_type_code').value=dataArr[4];
						    	document.getElementById('time_type_code').value=dataArr[6];	    		
					    		findTotal();
					    		}
					    	else
					    		{
					    		
					    		alert(getMessage(error_id,"BL"));
					    		
					    		}
					    
					    }
					
					});
					    
				 } 
				 
			 

	 
</script>

</head>
<body>

<form name='Esmfordeposit' id='Esmfordeposit' method='post' action='' onLoad='' scrolling=no >
<div>
	<table  border='1' cellpadding='3' cellspacing='0' align='center' width='100%'>	
	<tr><td class='COLUMNHEADER' colspan='16'><fmt:message key="eBL.EnterServiceItem.label" bundle="${bl_labels}"/></td></tr>
	</table></div>
	<br/><br/>
	<div overflow:scroll>  
	<!-- id="tblcontainer" STYLE="overflow: auto; width: 1020px; height: 195px;   padding:3px; margin: 0px">-->
	
	<table id='esmdeposit' border='1' cellpadding='3' cellspacing='0' align = 'center'  width='100%'>	
	
		<tr>
		<td class='COLUMNHEADER' width='10.5%'><fmt:message key="Common.Line.label" bundle="${common_labels}"/></td>	
	 	<td class='COLUMNHEADER' width='12.5%'><fmt:message key="eBL.ServiceIndicator.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='14.5%'><fmt:message key="eBL.ServiceDate/Time.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='12.5%'><fmt:message key="eBL.ServiceCode.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='12.5%'><fmt:message key="eBL.R_C.label"         bundle="${bl_labels}"/></td>	
		<td class='COLUMNHEADER' width='12.5%'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='12.5%'><fmt:message key="Common.Charges.label" bundle="${common_labels}"/></td>	
		<td class='COLUMNHEADER' width='12.5%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>		
		</tr>
 </table>
 
 	
  	<table id='estimatedeposit' border='1' cellpadding='3' cellspacing='0' align = 'center' id='' width='100%'>	
	
	<% 
	if(depositlist2!=null && !depositlist2.isEmpty())
	{
		//lastRow = depositlist2.size();
		int rowIndx = 1;
	for (Iterator iterator = depositlist2.iterator(); iterator.hasNext();)
	{	
	depositbean = (BLEstimateDepositBean) iterator.next();
	%>
	<tr data-id='<%=rowIndx %>' id='tr_<%=rowIndx%>'> 
 	<td  width='10.5%' class='FIELDS'><input type='text' id='line<%=rowIndx%>' name='line<%=rowIndx%>' size='05' maxlength='30' value='<%=depositbean.getLine()%>' readonly> </td> 
 	<td  width='12.5%' class='FIELDS'><input type='text' id='service_indicator<%=rowIndx%>' name='service_indicator<%=rowIndx%>' size='05' maxlength='30' value='<%= depositbean.getService_indicator()%>' onBlur='' readonly> </td> 
 	 <td  width='14.5%' class='FIELDS'><input type='text' id='datetime<%=rowIndx%>' name='datetime<%=rowIndx%>' size='17' maxlength='30' value='<%= depositbean.getDatetime()%>' readonly> </td> 
 	<td  width='12.5%' class='FIELDS'><input type='text' id='service_code<%=rowIndx%>' name='service_code<%=rowIndx%>' size='03' maxlength='30' value='<%=depositbean.getService_code()%>' > <input type='text' id='service_desc<%=rowIndx%>' name='service_desc<%=rowIndx%>' size='07' maxlength='22'  value='<%=depositbean.getService_desc() %>'  onBlur=""  ><input type='button' class='button' name="servcode" id="servcode" id="servcode" value='?' tabindex='0' onClick="ServcodeLookup(service_desc1,service_code1,1);"></td> 
 	<td  width='12.5%' class='FIELDS'><input type='text' id='Rc<%=rowIndx%>' name='Rc<%=rowIndx%>' size='07' maxlength='30' value='<%=depositbean.getRate_charge() %>' readonly > </td> 
 	 <td  width='12.5%' class='FIELDS'><input type='text' id='qty<%=rowIndx%>' name='qty<%=rowIndx%>' size='07' maxlength='30' value='<%=depositbean.getQty() %>' onBlur="estdeposit('<%=rowIndx%>'); putdeci(this);" onKeyPress='return(ChkNumberInput(this,event,2))' > </td> 
 	<td  width='12.5%' class='FIELDS'><input type='text' id='charges_<%=rowIndx%>' name='charges_<%=rowIndx%>'  size='07' maxlength='30' value='<%= qtydecimal(depositbean.getCharges())%>' readonly > </td> 
 	<td  width='12.5%'  class='FIELDS'><input type="checkbox" name='selected_row<%=rowIndx%>' id='selected_row<%=rowIndx%>' id='selected_row<%=rowIndx%>' value='' onClick=""></td>	
 	</tr>
	
	<%
	rowIndx++;
		
	}
	}
	else
	{
		//lastRow = 1;
	%>
	<tr data-id='1' id='tr_1'> 
 	<td  width='10.5%' class='FIELDS'><input type='text' id='line1' name='line1' id='line1' size='05' maxlength='30' value='1' readonly > </td> 
 	<td  width='12.5%' class='FIELDS'><input type='text' id='service_indicator1' name='service_indicator1' id='service_indicator1' size='05' maxlength='30' value='S' onBlur='' readonly> </td> 
 	 <td  width='14.5%' class='FIELDS'><input type='text' id='datetime1' name='datetime1' id='datetime1' size='17' maxlength='30' value=''  readonly > </td> 
 	<td  width='12.5%' class='FIELDS'><input type='text' id='service_code1' name='service_code1' id='service_code1' size='03' maxlength='30' value='' onBlur="if(this.value!=''){ ServcodeLookup(service_code1,service_desc1,1);}else{ fnClearCode(service_desc1); }" > <input type='text' id='service_desc1' name='service_desc1' id='service_desc1' size='07' maxlength='22'  value=''  onBlur="if(this.value!=''){ ServcodeLookup(service_desc1,service_code1,1);} else{ fnClearCode(service_desc1); }"  ><input type='button' class='button' name="servcode" id="servcode" id="servcode" value='?' tabindex='0' onClick="ServcodeLookup(service_desc1,service_code1,1);"></td> 
 	<td  width='12.5%' class='FIELDS'><input type='text' id='Rc1' name='Rc1' id='Rc1' size='07' maxlength='30' value='' readonly > </td> 
 	 <td  width='12.5%' class='FIELDS'><input type='text' id='qty1' name='qty1' id='qty1' size='07' maxlength='30' value='1.00' onBlur="estdeposit(1); putdeci(this);" onKeyPress='return(ChkNumberInput(this,event,2))'> </td> 
 	<td  width='12.5%' class='FIELDS'><input type='text' id='charges_1' name='charges_1' id='charges_1'  size='07' maxlength='30' value='' onBlur='findTotal();' > </td> 
 	<td  width='12.5%'  class='FIELDS'><input type="checkbox" name='selected_row1' id='selected_row1' id='selected_row1' value='' onClick=""></td>	  
	
	</tr> 
	<%
	}
	%>
	</table>	
	 </div> 
	
<div>
<table>
<tr>
<td width='25%'>
</td>
<td width='25%'>
</td>
<td width='25%'>
</td>

<td width='25%' >
		 <label><fmt:message key="eBL.TotalHeading.label" bundle="${bl_labels}"/></label>
		 <input type='text' id='esttotal' name='esttotal' id='esttotal' size='22' maxlength='22'  value='<%=depositbean.getEsttotal()%>'  onBlur="" readonly >		 	
		 </td>
</tr>
<tr>	<td width='26%'>
		<INPUT TYPE='button' name='add_button' id='add_button' id='add_button' class="BUTTON" VALUE="Add Row" size='5' onClick='addrow();'>
		<INPUT TYPE='button' name='del_button' id='del_button' id='del_button' class="BUTTON" VALUE="Delete Row" size='5' onClick='delrow();'>
		<INPUT TYPE='button' name='savebutton' id='savebutton' id='savebutton' class="BUTTON" VALUE="Save" size='5' onClick='save();'></td>
		<td>
		<td width='30%'></td>
		<td width='25%'></td>
</tr>
</table>
</div>

	 <input type= 'hidden' name="locale" id="locale"  value="<%=locale%>">
	<input type= 'hidden' name="facility_id" id="facility_id"  value="<%=facilityid %>">	
	<input type= 'hidden' name="patient_id" id="patient_id"  value="<%=patient_id%>">	
	<input type= 'hidden' name="episode_type" id="episode_type"  value="<%=episode_type%>">	
	<input type= 'hidden' name="episode_id" id="episode_id"  value="<%=episode_id%>">	
	<input type= 'hidden' name="visit_id" id="visit_id"  value="<%=visit_id%>">	
	<input type= 'hidden' name="encounter_id" id="encounter_id"  value="<%=encounter_id%>">	
	<input type= 'hidden' name="lastrow" id="lastrow"  id="lastrow"  value='<%=lastRow %>'> 
	<input type='hidden' name="base_qty" id="base_qty"  id="base_qty"  value=''> 
	<input type='hidden' name="base_rate" id="base_rate"  id="base_rate"  value=''>
	<input type='hidden' name="day_type_code" id="day_type_code"  id="day_type_code"  value=''>
	<input type='hidden' name="time_type_code" id="time_type_code"  id="time_type_code"  value=''> 
	
	
</body>
</html>

