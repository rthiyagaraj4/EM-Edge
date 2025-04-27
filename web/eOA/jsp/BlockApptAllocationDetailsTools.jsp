<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,java.util.*" %>

<html>  
<head>  
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		   	<script src='../../eCommon/js/common.js' language='javascript'></script>
		 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 
	<script language="JavaScript">
			/*function returnSlotValues(from)
			{ 
				var ret = '';
				if(from == 'O')
				{
					var n = parent.BlockApptAllocationDetailsFrame.document.forms[0].total_count.value;
					var slot_appt_ctrl = parent.BlockApptAllocationDetailsFrame.document.forms[0].slot_appt_ctrl.value;
					var sumtext = 0;
					var finalvals = '';
					for(var i=0;i<n;i++)
					{
						var a = eval("parent.BlockApptAllocationDetailsFrame.document.getElementById('block_slot_text')"+i+".value");
						sumtext+=eval(a);
						if( eval(a) != 0)
						{
							var b = eval("parent.BlockApptAllocationDetailsFrame.document.getElementById('block_slot')"+i+".value");
							b = b.replace('$',a);
							finalvals+=b+"#";
						}
					}					
					var totalslots = parent.BlockApptAllocationDetailsFrame.document.forms[0].slots_blocked.value;
					
					if (!(parent.BlockApptAllocationDetailsFrame.document.getElementById("block_slot_text1")))
						sumtext = totalslots;
					if(totalslots != sumtext){
						if (slot_appt_ctrl=="S"){
							var error = getOMessage('TOTAL_BLOCK_SLOTS_MISMATCH','OA');
							alert(error)
							ret = 'F';
						}
						if (ret != 'F' && totalslots < sumtext){
							
							var error = getMessage('BLOCK_SLOTS_GR_TOTAL_SLOTS','OA');
							alert(error)
							ret = 'F';
						}
						
						if (ret != 'F' && sumtext==0){
							
							var error = getMessage('TOTAL_BLOCK_GREAT_ZERO','OA');
							alert(error)
							ret = 'F';
						}

					}
					if (ret != 'F')
					{					
					if (parent.BlockApptAllocationDetailsFrame.document.forms[0].first_visit_text||parent.BlockApptAllocationDetailsFrame.document.forms[0].other_visit_text)
						{
						   var first_visit_value = "0";
						   if(parent.BlockApptAllocationDetailsFrame.document.forms[0].first_visit_text)
						   first_visit_value =parent.BlockApptAllocationDetailsFrame.document.forms[0].first_visit_text.value;
                           var other_visit_value ="0"; 
						   if(parent.BlockApptAllocationDetailsFrame.document.forms[0].other_visit_text)
								other_visit_value =parent.BlockApptAllocationDetailsFrame.document.forms[0].other_visit_text.value;
						   var criteria_flag = "Y";
						   if (finalvals=="")
							   criteria_flag="N"
						   if (first_visit_value=="") first_visit_value="0";
						   if (other_visit_value=="") other_visit_value="0";
						   finalvals = finalvals +"$"+first_visit_value+"#"+other_visit_value;
						   var sumvalue = parseInt(first_visit_value)+parseInt(other_visit_value);

						   if(totalslots != sumvalue){
									if (slot_appt_ctrl=="S"){
										var error = getMessage('TOTAL_BLOCK_SLOTS_MISMATCH','OA');
										alert(error);
										ret = 'F';
									}
							}
							if (parseInt(totalslots) < parseInt(sumvalue)){
								
									if (slot_appt_ctrl=="P"){
										
										var error = getMessage('BLOCK_SLOTS_GR_TOTAL_SLOTS','OA');
										alert(error);
										ret = 'F';
									}
							}
							
							if (parseInt(sumvalue) < parseInt(totalslots)){
								
									if (slot_appt_ctrl=="P"){
										
										
										var error = getMessage('BLOCK_SLOTS_LS_TOTAL_SLOTS','OA');			
										alert(error);
										ret = 'F';
									}
							}


							if (ret != 'F' && sumvalue==0){
								
								var error = getMessage('TOTAL_BLOCK_GREAT_ZERO','OA');
								alert(error)
								ret = 'F';
							}
							if ( ret != 'F' && criteria_flag=="Y" && sumtext != sumvalue){
									if (slot_appt_ctrl=="P"){
										var error = getMessage('ALLC_NOT_EQUAL_VTYPE','OA');
										alert(error);
										ret = 'F';
									}
								}
						if (ret != 'F')
							ret = finalvals;
					}
					}
				}
				else
					ret = '';				
				parent.window.returnValue = ret ;
				if(ret != 'F')
					parent.window.close();
			}*/
			function returnSlotValues(from){				
				var ret = '';
				if(from == 'O'){
						var n = parent.BlockApptAllocationDetailsFrame.document.forms[0].total_count.value;
						//alert("n"+n);
						var slot_appt_ctrl = parent.BlockApptAllocationDetailsFrame.document.forms[0].slot_appt_ctrl.value;
												//alert("slot_appt_ctrl"+slot_appt_ctrl);

						var sumtext = 0;
						var finalvals = '';
						var firstval=parent.BlockApptAllocationDetailsFrame.document.forms[0].first_visit_text.value;
												//alert("firstval"+firstval);

						var otherval=parent.BlockApptAllocationDetailsFrame.document.forms[0].other_visit_text.value;
												//alert("otherval"+otherval);

						var total_slots_booked= parent.BlockApptAllocationDetailsFrame.document.forms[0].total_slots_booked.value;
												//alert("total_slots_booked"+total_slots_booked);

						var sum = parseInt(firstval)+parseInt(otherval)+parseInt(total_slots_booked) ;
												//alert("sum"+sum);

						var max_patients_per_day= parent.BlockApptAllocationDetailsFrame.document.forms[0].max_patients_per_day.value;
												//alert("max_patients_per_day"+max_patients_per_day);

						var max_first_visits_all= parent.BlockApptAllocationDetailsFrame.document.forms[0].max_first_visits.value;
												//alert("max_first_visits_all"+max_first_visits_all);

							var max_oth_visits_all = parent.BlockApptAllocationDetailsFrame.document.forms[0].max_other_visits.value;
													//alert("max_oth_visits_all"+max_oth_visits_all);

						var max_first_visits_blocked =parent.BlockApptAllocationDetailsFrame.document.forms[0].total_first_visits_blocked.value;
												//alert("max_first_visits_blocked"+max_first_visits_blocked);

						var max_other_visits_blocked =parent.BlockApptAllocationDetailsFrame.document.forms[0].total_other_visits_blocked.value;
												//alert("max_other_visits_blocked"+max_other_visits_blocked);

						var allow_first = max_first_visits_all-max_first_visits_blocked;
												//alert("allow_first"+allow_first);

						var allow_other = max_oth_visits_all-max_other_visits_blocked;
												//alert("allow_other"+allow_other);


								if(firstval>allow_first)
								{
									//alert("@180");
									//var error = getMessage('BLOCK_LESS_FIRST_BOOKED');
										var error = "APP-OA01860 First visit block slots cannot be greater than the difference between  maximum first visit and booked first visits";

									alert(error);
									ret = 'F';
								}else
								{
																		//alert("@186");

								}
								if(otherval>allow_other)
								{
																		//alert("@191");

									//var error = getMessage('BLOCK_LESS_OTHER_BOOKED');
									var error = "APP-OA01861 Other visit block slots cannot be greater than the difference between  maximum other visit and booked other visits";
									alert(error);
									ret = 'F';
								}else
								{
																		//alert("@192");

								}
								if(sum>max_patients_per_day)
								{
																		//alert("@203");

									//var error = getMessage('SUM_OTHER_FIRST_BLOCKED_ZERO');
									var error = "APP-OA01859 Sum of  first visit , other visit and total slots blocked should not be greater than maximum patients per day";

									alert(error);
										ret = 'F';
								}else
								{
																	//alert("@204");
}
								for(var i=0;i<n;i++)
								{
									
									var a = eval("parent.BlockApptAllocationDetailsFrame.document.getElementById('block_slot_text')"+i+".value");
									sumtext+=eval(a);
									if( eval(a) != 0)
									{
										var b = eval("parent.BlockApptAllocationDetailsFrame.document.getElementById('block_slot')"+i+".value");
										b = b.replace('$',a);
										finalvals+=b+"#";
									}
								}					
								var totalslots = parent.BlockApptAllocationDetailsFrame.document.forms[0].slots_blocked.value;
								if (!(parent.BlockApptAllocationDetailsFrame.document.getElementById("block_slot_text1")))
									sumtext = totalslots;
								if(totalslots != sumtext){
									if (slot_appt_ctrl=="S"){
										//var error = getMessage('TOTAL_BLOCK_SLOTS_MISMATCH');
										var error = "APP-OA0093 Total number of Block Slots must match Slots to be Blocked";

										alert(error)
										ret = 'F';
									}
									if (ret != 'F' && totalslots < sumtext){
										//var error = getMessage('BLOCK_SLOTS_GR_TOTAL_SLOTS');
										var error =  "APP-OA0159 Sum of Block Slots should not be greater than Selected Blocks";
										alert(error)
										ret = 'F';
									}
									if (ret != 'F' && sumtext==0){
										//var error = getMessage('TOTAL_BLOCK_GREAT_ZERO');
										var error =  "APP-OA0163 Total number of Block Slots Should be Greater than Zero";
										alert(error)
										ret = 'F';
									}

								}
								if (ret != 'F')
								{					
								if (parent.BlockApptAllocationDetailsFrame.document.forms[0].first_visit_text||parent.BlockApptAllocationDetailsFrame.document.forms[0].other_visit_text)
									{
									   var first_visit_value = "0";
									   if(parent.BlockApptAllocationDetailsFrame.document.forms[0].first_visit_text)
									   first_visit_value =parent.BlockApptAllocationDetailsFrame.document.forms[0].first_visit_text.value;
									   var other_visit_value ="0"; 
									   if(parent.BlockApptAllocationDetailsFrame.document.forms[0].other_visit_text)
											other_visit_value =parent.BlockApptAllocationDetailsFrame.document.forms[0].other_visit_text.value;
									   var criteria_flag = "Y";
									   if (finalvals=="")
										   criteria_flag="N"
									   if (first_visit_value=="") first_visit_value="0";
									   if (other_visit_value=="") other_visit_value="0";
									   finalvals = finalvals +"$"+first_visit_value+"#"+other_visit_value;
									   var sumvalue = parseInt(first_visit_value)+parseInt(other_visit_value);

									   if(totalslots != sumvalue){
												if (slot_appt_ctrl=="S"){
													//var error = getMessage('TOTAL_BLOCK_SLOTS_MISMATCH');
													var error =  "APP-OA0093 Total number of Block Slots must match Slots to be Blocked";
													alert(error);
													ret = 'F';
												}
										}
										if (parseInt(totalslots) < parseInt(sumvalue)){
												if (slot_appt_ctrl=="P"){
													//var error = getMessage('BLOCK_SLOTS_GR_TOTAL_SLOTS');
													var error =   "APP-OA0159 Sum of Block Slots should not be greater than Selected Blocks";

													alert(error);
													ret = 'F';
												}
											}
										if (ret != 'F' && sumvalue==0){
											//var error = getMessage('TOTAL_BLOCK_GREAT_ZERO');
											var error =   "APP-OA0163 Total number of Block Slots Should be Greater than Zero";

											alert(error)
											ret = 'F';
										}
										if ( ret != 'F' && criteria_flag=="Y" && sumtext != sumvalue){
												if (slot_appt_ctrl=="P"){
													//var error = getMessage('ALLC_NOT_EQUAL_VTYPE');
													var error =   "APP-OA0160 Sum of Allocations should be equals to Sum of Visit types";

													alert(error);
													ret = 'F';
												}
											}
									if (ret != 'F')
										ret = finalvals;
								}
								}
							}
							else
								ret = '';		
							let dialogBody = parent.parent.document.getElementById('dialog-body');
							dialogBody.contentWindow.returnValue = ret;
							//parent.window.returnValue = ret ;
							if(ret != 'F') {
								//parent.window.close();
							    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
								dialogTag.close();  } 
			}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%request.setCharacterEncoding("UTF-8");	
%>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<form onload = 'display_warning()' >
	<hr>
	<table cellpadding=0 cellspacing=0 width="100%" border=0>
		<tr>
			<td align=center class=BODYCOLORFILLED id = 'display_warn'>
				<%
				String slot_appt_ctrl = request.getParameter("slot_appt_ctrl")==null?"":request.getParameter("slot_appt_ctrl");
				if (slot_appt_ctrl.equals("S")){
				%>
				<b><font size=2><fmt:message key="eOA.blocksums.label" bundle="${oa_labels}"/></font>
				<%}%>
</td>
		</tr>
		<tr>
			<td align=right class=BODYCOLORFILLED>
				<input type="button" class=BUTTON value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="returnSlotValues('O')">
				<input type="button" class=BUTTON value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="returnSlotValues('C')">
			</td>
		</tr>
	</table>
</form>
</body>
</html>

