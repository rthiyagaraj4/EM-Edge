<!DOCTYPE html>
 
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head> 
<% 
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
		String facility_id=(String) session.getValue( "facility_id" );

		String bean_id = "BLGroupOrderRoutingBean" ;
		String bean_name = "ePH.BLGroupOrderRoutingBean";
		BLGroupOrderRoutingBean bean = (BLGroupOrderRoutingBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		bean.clear() ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

		ArrayList all = bean.getDataForList();
		ArrayList orderingFacility = (ArrayList)all.get(0);
		ArrayList billingGroup = bean.getBillingGroup();
        ArrayList customerGroup = bean.getCustomerGroup();
%>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='JavaScript' src='../../eCommon/js/CommonCalendar.js'></script>
		<Script language='JavaScript' src='../../eCommon/js/common.js'></Script>
		<script language="JavaScript" src="../../ePH/js/BLGroupOrderRouting.js"></script>
		<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

		<script>
			function focusObject(){
				document.forms[0].elements[0].focus();
			} 
			
			function addOrderByCol(){  
				var i=0;
				var from = document.getElementById('orderbycols'); 
				if ( from.options.length > 0 ) {
					var to = document.getElementById('orderbycolumns'); 
					var element = document.createElement('OPTION');
					var seltdIndex = from.selectedIndex;
					if(seltdIndex > -1){
						element.text = from.options[from.selectedIndex].text;
						element.value= from.options[from.selectedIndex].value; 
						to.add(element);      
						from.remove(from.selectedIndex);
						if(from.options[i])
							from.options[i].selected=true ;
						i++;
					}
				} 
			} 

			function removeOrderByCol(){
				var j=0;
				var from = document.getElementById('orderbycolumns');
				if ( from.options.length > 0 ){ 
					var to = document.getElementById('orderbycols');
					var element = document.createElement('OPTION');
					var seltdIndex = from.selectedIndex;
					if(seltdIndex > -1){
						element.text = from.options[from.selectedIndex].text;
						element.value = from.options[from.selectedIndex].value;
						to.add(element);    from.remove(from.selectedIndex);
						if(from.options[j]) 
							from.options[j].selected=true; 
						j++;
					}
				}
			}  

			function SelectAll(){
				var i = 0;
				document.getElementById("orderbycolumns").selectedIndex=0; 
				while ( i < document.getElementById("orderbycolumns").length) {
					document.getElementById("orderbycolumns").options[i].selected=true;
					i++; 
				}
			}  

			function execQuery(){
				if(document.getElementById("orderbycolumns").options.length >0 ){
					SelectAll(); 
					document.query_form.submit();
				}
				else{
					alert(getMessage('ORDERBY_NOT_BLANK','Common'))
				}
			}
		</script>
	</head>

	<body onMouseDown="" onKeyDown="lockKey()">
		<form name='query_form' id='query_form' method='post' action='BLGroupOrderRoutingQueryResult.jsp' onsubmit='SelectAll()'>
			<table cellpadding=0 cellspacing=3 width="98%" align="center" border="0" >
				<tr>
					<th colspan='6'><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>
				</tr>
				<tr>
					<td width='6'>&nbsp;</td>
					<td class="label"><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>
					<td  class='label' width='15%' >&nbsp;&nbsp;
						<select name="ordering_facility_id" id="ordering_facility_id" onChange="loadRoutineStatDischargeBasedOnFacility()" id="PerformingFacility">
<%
							String selectFacility="";
							for (int i=0;i<orderingFacility.size();i++){
								if (facility_id.equals(orderingFacility.get(i))){
									selectFacility="selected";
								}
								else{
									selectFacility="";
								}
%>
							<option value="<%=orderingFacility.get(i)%>" <%=selectFacility%> id="<%=orderingFacility.get(i)%>"><%=orderingFacility.get(++i)%></option>
<%
							}
%>
						</select>
					</td>
					<td class='label' width='20%' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>	
					</td>
					<td  class='label' width='25%' >&nbsp;&nbsp;
						<select name='ordering_source_type' id='ordering_source_type' onChange="ShowCombo(this)">
							<option value='*A' selected>All
							</option>
							<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
							</option>
							<option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
							</option>
							<option value='E'><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/>
							</option>
							<option value='D'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
							</option>
						</select>
					</td>
					<td width='6'>&nbsp;</td>
				</tr>

				<tr>
					<td width='6'>&nbsp;</td>
					<td class='label' width='27%' ><div id="div3" name="div3"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></div><div id="div4">Location</div>
					</td>
					<td  class='label' width='15%' >&nbsp;&nbsp;
						<input type='text' name='ordering_source_code' id='ordering_source_code' size='6' maxlength='6' onBlur='makeValidQueryCriteria(this);'>
						<select name="ordering_source_code_cmb" id="ordering_source_code_cmb"  onChange="setLocation()" >
					     <option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						</select></td>
					<td class='label' width='20%' ><div id="div1" name="div1"><fmt:message key="Common.LocationDesc.label" bundle="${common_labels}"/></div>
					</td>
					<td  class='label' width='25%' >&nbsp;&nbsp;
					<div id="div2" name="div2" >
						<input type='text' name='ordering_source_desc' id='ordering_source_desc' size='30' maxlength='30' onBlur='makeValidQueryCriteria(this);'>
					</div>
					</td>
					<td width='6'>&nbsp;</td>
				</tr>

				<tr>
					<td width='6'>&nbsp;</td>
					<td class='label' width='27%' ><fmt:message key="ePH.RoutingLevel.label" bundle="${ph_labels}"/>
					</td>
					<td  class='label' colspan=3>&nbsp;&nbsp;
						<select name='routing_level' id='routing_level' onChange="loadRoutingLevelRelatedElements(this,'QUERY'); loadRoutineStatDischargeBasedOnFacility();">
							<option value="">---<fmt:message key="Common.all.label" bundle="${common_labels}"/>---</option>
							<option value='S'><fmt:message key="Common.source.label" bundle="${common_labels}"/>
							</option>
							<option value='O'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/>
							</option>
							<option value='D' selected><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/>
							</option>
							<option value='G'><fmt:message key="Common.Drug.label" bundle="${common_labels}"/>
							</option>
							<option value="L"><fmt:message key="ePH.SpecialOrders.label" bundle="${ph_labels}"/></option>
							<OPTION value="M" ><fmt:message key="Common.MedicalItem.label" bundle="${common_labels}"/></OPTION>
							<OPTION value="H" ><fmt:message key="ePH.HomeLeave.label" bundle="${ph_labels}"/></OPTION><!-- added for Bru-HIMS-CRF-093[29960] -->
		
						</select>
						<select name="routing_code" id="routing_code" onChange="loadRoutineStatDischargeBasedOnRoutingLevel(routing_level,this)" id="RoutingCode" style="display:inline">
							<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
							<option value="G"><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
							<option value="N"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></option>
							<option value="C"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
						</select>
						<input type="text" name="drug_desc" id="drug_desc" style="display:none;" size="45" maxlength="30" onblur='searchForDrug(this);' value="" ><input type="button" value="?" name="btnDrug" id="btnDrug" style="display:none" class="button" onClick="searchForDrug(drug_desc);">
						<input type="hidden" name="drug_code" id="drug_code" value="">
					</td>
					<td width='6'>&nbsp;</td> 
				</tr>
				<tr>
					<td width='6'>&nbsp;</td>
					<td class='label' width='27%' > <fmt:message key="ePH.RoutineOrdersDispLocn.label" bundle="${ph_labels}"/>
					</td>
					<td  class='label' width='15%' >&nbsp;&nbsp;
						<select name="rtn_ord_disp_locn_code" id="rtn_ord_disp_locn_code" id="Routine">
							<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>					
						</select>
					</td>
					<td class='label' width='20%' > <fmt:message key="ePH.StatOrdersDispLocn.label" bundle="${ph_labels}"/>
					</td>
					<td  class='label' width='25%' >&nbsp;&nbsp;
						<select name="stat_ord_disp_locn_code" id="stat_ord_disp_locn_code" id="Stat">
							<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						</select>
					</td>
					<td width='6'>&nbsp;</td>
				</tr>
				<tr>
					<td width='6'>&nbsp;</td>
					<td class='label' width='27%' ><fmt:message key="ePH.DischargeMedicationDispLocn.label" bundle="${ph_labels}"/>
					</td>
					<td  class='label' width='15%' >&nbsp;&nbsp;
						<select name="disch_ord_disp_locn_code" id="disch_ord_disp_locn_code" id="Discharge/Take Home Medication">
							<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						</select>
					</td>
					<td width='6'>&nbsp;</td> 
					<tr>
					<td width='6'>&nbsp;</td> 
					<td class='label'  width='27%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
				<td class='label' width='15%'>&nbsp;&nbsp;
				<select name="billing_group"  id="Billing Group" >
				<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	
<%
					String selectGroup="";
					for (int i=0;i<billingGroup.size();i+=3){
%>
				<OPTION  VALUE="<%= billingGroup.get(i) %>" id="<%=billingGroup.get(i)%>"><%= billingGroup.get(i+1) %></OPTION>
<%               }
%>
				</select>
				</td>
				<td class='label'  width='27%'><fmt:message key="ePH.CustomerGroup.label" bundle="${ph_labels}"/></td>
				<td class='label' width='15%'>&nbsp;&nbsp;
				<select name="customer_group" id="customer_group" onChange="loadCustomer()" id="Customer Group">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	
<%
					for (int i=0;i<customerGroup.size();i+=2){
%>
				<OPTION  VALUE="<%= customerGroup.get(i) %>" id="<%=customerGroup.get(i)%>"><%= customerGroup.get(i+1) %></OPTION>
<%               }
%>
				</select>
				</td>
				<td width='6'>&nbsp;</td> 
				</tr>
				<tr>
				<td width='6'>&nbsp;</td> 
				<td class='label'  width='27%'><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
				<td class='label' width='15%' >&nbsp;&nbsp;
				<select name="customer_id" id="customer_id"  onChange="loadPolocyType()" id="Customer">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	
				</select>
				</td>
				<td class='label'  width='27%' ><fmt:message key="ePH.PolicyType.label" bundle="${ph_labels}"/></td>
				<td class='label'  width='15%' >&nbsp;&nbsp;
				<select name="polocy_type" id="Polocy Type">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	
				</select>
				</td>
        </tr>
					<td colspan='3'>&nbsp;</td>
				</tr>
			</table>
			<br>
			<table width='98%' align='center'><th width='20%' ><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/></td>
				<tr>
					<td width='60%' > 
					<p  title='Sort Order'>
					<table width='100%'><td align='center''><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
						<td>&nbsp;</td><td align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
						<tr>
							<td width='45%'  align='center'>
								<select name='orderbycols' id='orderbycols' size='5' >
									<option value='location_type'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></option>
									<option value='ordering_source_code'><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></option>
									<option value='ordering_source_desc'><fmt:message key="Common.LocationDesc.label" bundle="${common_labels}"/></option>
								</select>
							</td>
							<td  width='3%' >
								<input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> 
								<input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img>
							</td>
							<td width='45%'   align='center'>
								<select name='orderbycolumns' id='orderbycolumns' size='5' multiple='true'>
									<option value='ordering_facility_id'>
											<fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/>						
									</option>
								</select>
							</td>
						</tr>
					</table>
					</p>
					</td>
				</tr>
			</table>
			<br>
			<table border='0' width='100%' align='center'>
				<tr>
					<td width='100%' class='white' align='center'>
						<input type='button' name='ExecuteQuery' id='ExecuteQuery'  class='Button' onclick='execQuery()' Value='<fmt:message key="Common.Execute.label" bundle="${common_labels}"/>'
					</td>
				</tr>
			</table> 
			<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="facility_id" id="facility_id" value="<%= (String) session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
		</form>
		<script>
			loadRoutineStatDischargeBasedOnFacility();
		
		  function ShowCombo(obj){
				if(document.query_form.ordering_source_type.value=='*A'){
					document.query_form.ordering_source_code.style.visibility='visible';
					document.query_form.ordering_source_code.value="";
					document.query_form.ordering_source_code.style.display="inline";
					document.query_form.ordering_source_code_cmb.style.visibility='hidden';
					document.query_form.ordering_source_code_cmb.style.display="none";
					show(true,"div1");
					show(true,"div2");
					show(true,"div3");
					show(false,"div4");
					   
				}else{
				   document.query_form.ordering_source_code.style.visibility='hidden';
				   document.query_form.ordering_source_code.style.display="none";
				   document.query_form.ordering_source_code_cmb.style.visibility='visible';
				   document.query_form.ordering_source_code_cmb.style.display="inline";
				   document.query_form.ordering_source_desc.value="";
				   document.query_form.ordering_source_code.value="";
				   show(false,"div1");
				   show(false,"div2");
				   show(true,"div4");
				   show(false,"div3");
				   loadRelatedLocationQry(obj);
				}
		    }
			
			function setLocation(){			 
				document.query_form.ordering_source_code.value=document.query_form.ordering_source_code_cmb.value;
			}

            ShowCombo();

			function show(sw,obj) {
			 if (sw ) {
				 parent.blorderRoutingFrame.document.getElementById(obj).style.visibility = 'visible';
				 parent.blorderRoutingFrame.document.getElementById(obj).style.display = 'inline';
			 }
			 if (!sw ){ 
				 parent.blorderRoutingFrame.document.getElementById(obj).style.visibility = 'hidden';
				 parent.blorderRoutingFrame.document.getElementById(obj).style.display = 'none';
			 }
			}
          
		</script>
	</body>
</html>

