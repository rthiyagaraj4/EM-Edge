<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page import="eBL.placeorder.bc.PlaceOrderBC"%>
<%@ page
	import="webbeans.eCommon.*,eBL.*,eBL.Common.*,com.ehis.util.*,java.util.*,java.sql.*,java.text.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<HTML>
<HEAD>
<link rel="stylesheet" type="text/css"
	href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script>
	$(document).ready(function(){
		var bannerSize = $(parent.BillingBanner.document).find('#bannerSize').val();
		var pDoc = parent.document;
		var frameAltered = $(pDoc).find('#framesAltered').val();
		if(frameAltered == 'no'){
			if(bannerSize<=2){
				$(pDoc).find('#allFramesExisting').val('5%,0%,0%,6%,26%,30%,30%,0%,4%');
				$(pDoc).find('#allFramesNew').val('5%,0%,0%,6%,21%,32%,32%,0%,4%');
				$(pDoc).find('#allFramesNewDtl').val('5%,0%,0%,6%,0%,51%,34%,0%,4%');
				$(pDoc).find('#allFramesNewRcrd').val('5%,0%,0%,6%,0%,34%,55%,0%,4%');
				$(pDoc).find('#allFramesMessage').val('5%,0%,0%,6%,25%,5%,30%,25%,4%');
				$(pDoc).find('#framesAltered').val('yes');
				$(pDoc).find('#BL_mainFrame').attr('rows','7%,0%,0%,5%,25%,29%,29%,0%,5%');
			}
		}
		
		$('#processed').change(function(){
			if($(this).val() == 'UP' || $(this).val() == 'UC'){
				$('#filterBy').val('D');
			}
		});
		
		$('#filterBy').change(function(){
			if($(this).val() != 'D'){
				if($('#processed').val() == 'UP' || $('#processed').val() == 'UC'){
					$('#filterBy').val('D');
				}
			}
		});
	});
</script>
<%-- JSP Page specific attributes end --%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	
			String reqParam = request.getQueryString();
			
			String locale="";
			String p_facility_id="";
			
			String servClass="";
			String servClassCode="";
			String billServ="";
			String billServCode="";
			String item="";
			String itemCode="";
			String entServGrp="";			
			String entServGrpCode="";
			String entGrpLine="";
			String entGrpLineCode="";		
			
			String serviceCode="";
			String user = "";
			
			
			boolean firstRec=true;
			String firstServiceCode=null;
			System.out.println("start>>>>>>>>>>>>>> BLChargePatientEncounterExistingOrder.jsp");
			
			
			 String encounter_date = request.getParameter("encounter_date");
			//String encounter_id = request.getParameter("encounter_id");
			// String patient_id = request.getParameter("patient_id");
			String patient_id	="";
			String encounter_id	="";

			if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
				patient_id	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
				encounter_id	= new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));
			}else{
				patient_id	= request.getParameter("patient_id");
				encounter_id	= request.getParameter("encounter_id");
			}//V230131

			System.out.println("patient_id BLChargePatientEncounterExistingOrder.jsp=> "+patient_id);
			System.out.println("encounter_id =>"+encounter_id);
			 String blng_grp_id = request.getParameter("blng_grp_id");
			 System.out.println("blng_grp_id =>"+blng_grp_id);
			 String episode_id = request.getParameter("episode_id");
			 System.out.println("episode_id =>"+episode_id);
			 String visit_id = request.getParameter("visit_id");
			String episode_type = request.getParameter("episode_type");
			String acctSeqNo = request.getParameter("acctSeqNum");
			String payerGroup = request.getParameter("payerGroup");
			String payer = request.getParameter("payer");
			String policy = request.getParameter("policy");
			String policyNum = request.getParameter("policyNum");
			String privilege[] = new String[2];
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rst = null;
			String chargeLogicYN = "";
			String underChargeYn = "";
			
			
			try{	
				HttpSession httpSession = request.getSession(false);				
				locale	= (String)session.getAttribute("LOCALE");	
				p_facility_id = (String)httpSession.getValue("facility_id");
				user = (String)session.getAttribute("login_user");	
				HashMap<String,String> blngServGroupUnSorted = new HashMap<String,String>();
				PlaceOrderBC placeOrderBC = new PlaceOrderBC();
				blngServGroupUnSorted = placeOrderBC.getBlngServGroup(locale);
				Map<String, String> blngServGroup = new TreeMap<String, String>(blngServGroupUnSorted);
				System.out.println("blngServGroup "+blngServGroup);
				request.setAttribute("blngServGroup", blngServGroup);
				
				privilege = placeOrderBC.getPrivilege(user, p_facility_id);
				System.out.println("privilege[0] =>"+privilege[0]);
				System.out.println("privilege[1] =>"+privilege[1]);
				
				
				con = ConnectionManager.getConnection();
				pstmt = con.prepareStatement("Select charge_logic_yn from bl_parameters where operating_facility_id = ?");
				pstmt.setString(1, p_facility_id);
				rst = pstmt.executeQuery();
				
				if(rst != null && rst.next()){
					chargeLogicYN = rst.getString("charge_logic_yn");
					System.out.println("chargeLogicYN,BLChargePatientEncounterExistingOrder.jsp =>"+chargeLogicYN);
				}
				
				pstmt = null;
				rst = null;
				if("I".equals(episode_type) || "D".equals(episode_type)){
					pstmt = con.prepareStatement("select DISCHARGED_YN,DISCHARGE_BILL_GEN_IND "+
							"from  bl_episode_fin_dtls "+
							"where operating_facility_id  = ? "+
							"and episode_type = ? "+
							"and episode_id = ? ");
					
					pstmt.setString(1, p_facility_id);
					pstmt.setString(2, episode_type);
					pstmt.setString(3, episode_id);
					rst = pstmt.executeQuery();
					if(rst != null && rst.next()){
						if("Y".equals(rst.getString("DISCHARGED_YN")) && "Y".equals(rst.getString("DISCHARGE_BILL_GEN_IND"))){
							underChargeYn = "Y";
						}
					}
					
				}
				
				
			  }catch(Exception eX){	
				out.println("Error= "+eX);
				System.err.println("Exception in getting Charge Logic YN ->"+eX);
				}
			finally{
				pstmt = null;
				rst = null;
				ConnectionManager.returnConnection(con);
			}
			
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
	<script language="javascript" src="../../eBL/js/BLChargePatient.js"></script> 
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eBL/js/BLChargePatientServiceLookup.js'></script>
<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>



	
	<script>
	function servCodeChange(){
		//alert("changed");
		//alert(document.forms[0].name);
		//alert(document.forms[0].serviceCode.value);
		var  loc=document.forms[0].locale.value;
		var sercod=document.forms[0].serviceCode.value;
		//var document.forms[0].serviceCode=document.forms[0].serviceCode.value;		
	}
	</script>
</HEAD>
<body>
			<FORM name='BLChargePatientEncounterExistingOrder' id='BLChargePatientEncounterExistingOrder' method='' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<table width="100%" CELLSPACING=0 cellpadding=3 align='center'>
      		<tr>
				<td width='20%' class='COLUMNHEADER' nowrap colspan="11">
      				<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"></fmt:message> 
      			</td>
      		</tr>
      		<tr>
      			<td width='5%'  nowrap class='label'>
      				<fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}"></fmt:message>
      			</td>
      			<td width='10%' nowrap class='fields'>
      				<Select style="width: 150px;" name='serviceCode' id='serviceCode'  onchange='servCodeChange()'>
      				<option value=''>-------<fmt:message key="Common.defaultSelect.label"bundle="${common_labels}" />
							-------	</option>
      					<c:forEach var="serv" items="${blngServGroup }">      						
      						<option value="${serv.key }">${serv.value }</option>
      					</c:forEach>
	      			</Select>
      			</td>
      			
      			
      			<td class="label" width="10%">
      				<fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/>
      			</td>	
				<td class="fields" width="20%">
					<INPUT TYPE="TEXT"  name="serv_class" id="serv_class" SIZE="15"  MAXLENGTH='40' VALUE="<%=servClass%>" onBlur="if(this.value != ''){ servClassLkup(this,document.forms[0].serv_class_code,'Y') } else{ clearCode(serv_class_code);}">
					<input type='button' class='button' name="servClass_but" id="servClass_but" value='?' onClick='servClassLkup(document.forms[0].serv_class,document.forms[0].serv_class_code)' >
					<input type= 'hidden' id='serv_class_code' name="serv_class_code" id="serv_class_code"  value="<%=servClassCode%>">
				</td>	
      			
      			<td class="label" width="5%">
      				<fmt:message key="Common.BillingService.label" bundle="${common_labels}"/>
      			</td>	
				<td class="fields" width="10%">
					<INPUT TYPE="TEXT"  name="bill_serv" id="bill_serv" SIZE="10"  MAXLENGTH='40' VALUE="<%=billServ%>" onBlur="if(this.value != ''){ billingServLkup(this,bill_serv_code,'Y') } else{ clearCode(bill_serv_code);}">
					<input type='button' class='button' name="frombillbut" id="frombillbut" value='?' onClick='billingServLkup(document.forms[0].bill_serv,bill_serv_code)' >
					<input type= 'hidden' id="bill_serv_code" name="bill_serv_code" id="bill_serv_code"  value="<%=billServCode%>">
				</td>	
				<td class="label" width="5%">
					<fmt:message key="Common.item.label" bundle="${common_labels}"/>
				</td>	
				<td class="fields" width="21%">
					<INPUT TYPE="TEXT"  name="item" id="item" SIZE="7"  MAXLENGTH='40' VALUE="<%=item%>" onBlur="if(this.value != ''){ itemLkup(this,document.forms[0].item_code,'Y') } else{ clearCode(item_code);}">
					<input type='button' class='button' name="item_but" id="item_but" value='?' onClick='itemLkup(document.forms[0].item,document.forms[0].item_code)' >
					<input type= 'hidden' name="item_code" id="item_code"   value="<%=itemCode%>">
				</td>	
					
				</tr>  
			 
				<tr>
				<td class="label" width="10%">
					<fmt:message key="eBL.EnterpriseServiceGroup.Label" bundle="${bl_labels}"/>
				</td>	
				<td class="fields" width="15%">
					<INPUT TYPE="TEXT"  name="ent_serv_grp" id="ent_serv_grp" SIZE="15"  MAXLENGTH='40' VALUE="<%=entServGrp%>" onBlur="if(this.value != ''){ entServGrpLkup(this,document.forms[0].entServ_Grp_code,'Y') } else{ clearCode(entServ_Grp_code);}">
					<input type='button' class='button' name="entServGrp_but" id="entServGrp_but" value='?' onClick='entServGrpLkup(document.forms[0].ent_serv_grp,document.forms[0].entServ_Grp_code)' >
					<input type= 'hidden' name="entServ_Grp_code" id="entServ_Grp_code"  value="<%=entServGrpCode%>">
				</td>	
				<td class="label" width="10%">
					<fmt:message key="eBL.EntGrpLine.label" bundle="${bl_labels}"/>
				</td>	
				<td class="fields" width="15%">
					<INPUT TYPE="TEXT"  name="ent_grp_line" id="ent_grp_line" SIZE="15"  MAXLENGTH='40' VALUE="<%=entGrpLine%>" onBlur="if(this.value != ''){ entGrpLineLkup(this,document.forms[0].entGrp_Line_code,'Y') } else{ clearCode(entGrp_Line_code);}">
					<input type='button' class='button' name="entGrpLine_but" id="entGrpLine_but" value='?' onClick='entGrpLineLkup(document.forms[0].ent_grp_line,document.forms[0].entGrp_Line_code)' >
					<input type= 'hidden' name="entGrp_Line_code" id="entGrp_Line_code"  value="<%=entGrpLineCode%>">
				</td>	
				<td class='label' width='10%'>
					<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>    
				</td>
				<td class="fields" width='15%'>
					<input type='text' name='from__date' id='from__date' SIZE='15' maxlength='30' VALUE='' onBlur='return checkValidDate(document.forms[0].from__date)' >
					<img name='from_bill_date_cal' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('from__date');" >
				</td>
				<td class='label' width="5%">
					<fmt:message key="Common.todate.label" bundle="${common_labels}"/> 
				</td>
				<td class="fields" width='20%'>
					<input type='text' name='to_date' id='to_date'  SIZE='7' maxlength='30'  VALUE='' onBlur='return checkValidDate(document.forms[0].to_date)'>
					<img name='to_bill_date_cal' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('to_date');" >
				</td>
				
				</tr>  
				<tr>
					<td class="label" width="10%">
						&nbsp;<fmt:message key="eBL.BilledUnBilled.label"  bundle="${bl_labels}"/>
					</td>	
					<td class="fields" width="15%">
						<select name='billedYN' id='billedYN'>
							<option value=''><fmt:message key="Common.Both.label"bundle="${common_labels}" /></option>
							<option value='Y'><fmt:message key="eBL.Billed.label"bundle="${bl_labels}" /></option>
							<option value='N'><fmt:message key="eBL.UnBilled.label"bundle="${bl_labels}" /></option>
						</select>
					</td>
					<td class="label" width="10%">
						<fmt:message key="eBL.Direct/Indirectchgs.label"  bundle="${bl_labels}"/>
					</td>	
					<td class="fields" width="15%">
						<select name='direct_indirectchgs' id='direct_indirectchgs'>
							<option value=''><fmt:message key="Common.Both.label"bundle="${common_labels}" /></option>
							<option value='D'><fmt:message key="eBL.Directchgs.label"bundle="${bl_labels}" /></option>
							<option value='I'><fmt:message key="eBL.Indirectchgs.label"bundle="${bl_labels}" /></option>
						</select>
					</td>
					<td nowrap class="label" width='10%'>
						<fmt:message key="eBL.FilterBy.label"bundle="${bl_labels}" />
					</td>

					<td nowrap width='15%'>
						<select name='filterBy' id='filterBy' >
							<option value="G"><fmt:message key="eBL.EnterpriseServiceGroup.Label" bundle="${bl_labels}"/></option>
							<option value="L"><fmt:message key="eBL.EntGrpLine.label" bundle="${bl_labels}"/> </option>
							<option value="D"><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/> </option>
							<!--<option value="EG"><fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}"></fmt:message> </option>
							<option value="EL"><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/></option>  -->
						</select>
						
					</td>
					<td nowrap class="label" width='10%'>
						<fmt:message key="eBL.Processed.label" bundle="${bl_labels}"/>
					</td>
					<td nowrap width='15%'>
						<select name='processed' id='processed' >
							<option value="P"><fmt:message key="eBL.Processed.label" bundle="${bl_labels}"/> </option>
							<option value="UP"><fmt:message key="eBL.UnProcessed.label" bundle="${bl_labels}"/> </option>
							<option value="UC"><fmt:message key="eBL.UnConfirmed.label" bundle="${bl_labels}"/></option>
							<!-- <option value="EG"><fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}"></fmt:message> </option>
							<option value="EL"><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/></option>  -->
						</select>
					</td>
				</tr>
				<tr>
					<td nowrap colspan='2' class='LABEL'>
						<%if("Y".equals(underChargeYn)){ %>
							<input type='checkbox' name='underCharge' id='underCharge'  disabled="disabled" checked="checked">
							&nbsp;<fmt:message key="eBL.UnderChargePatient.label" bundle="${bl_labels}"/>
						<%} else{ %>
							<input type='checkbox' name='underCharge' id='underCharge' disabled="disabled" >
							&nbsp;<fmt:message key="eBL.UnderChargePatient.label" bundle="${bl_labels}"/>
						<%} %>
					</td>
					<td nowrap colspan='3' class='LABEL'>
						<%if(("I".equals(episode_type) || "D".equals(episode_type)) && "Y".equals(underChargeYn)){ %>
							<input type='checkbox' name='underChrgOnly' id='underChrgOnly'>
							&nbsp;<fmt:message key="eBL.UnderChargeOnly.label" bundle="${bl_labels}"/>
						<%} else{ %>
							<input type='checkbox' disabled name='underChrgOnly' id='underChrgOnly'>
							&nbsp;<fmt:message key="eBL.UnderChargeOnly.label" bundle="${bl_labels}"/>
						<%} %>
					</td>
					
					<td colspan="4">
					</td>
					<td nowrap class="label" width='10%'>				
						<input type="button" class='button' name="add_mod" id="add_mod"  value="Search" onclick="showServiceDetails();"  />		
					</td>
					<td nowrap class="label" width='15%'>				
						<input type="button" class='button' name="reset" id="reset"   value="Reset" onclick="resetExistingOrder();"  />		
					</td>
				</tr> 						
      					 
      	</table>
      	
      	<input type= hidden name="locale" id="locale" id='locale' value="<%=locale%>">
      	<input type= hidden name="facility_id" id="facility_id"  value="<%=p_facility_id %>">
      	<input type= hidden name="patient_id" id="patient_id"  value="<%=patient_id %>">
      	<input type= hidden name="episode_id" id="episode_id"  value="<%=episode_id %>">
      	<input type= hidden name="visit_id" id="visit_id"  value="<%=visit_id %>">
      	<input type='hidden' name='encounter_date' id='encounter_date' value='<%=encounter_date %>'>
      	<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id %>'>
      	<input type='hidden' name='episode_type' id='episode_type' id='episode_type' value='<%=episode_type %>'>
      	<input type='hidden' name='acctSeqNo' id='acctSeqNo' id='acctSeqNo' value='<%=acctSeqNo %>'>
      	<input type='hidden' name='queryString' id='queryString' id='queryString' value='<%=reqParam%>'>
      	<input type='hidden' name='payerGroup' id='payerGroup' id='payerGroup' value='<%=payerGroup%>'>
      	<input type='hidden' name='payer' id='payer' id='payer' value='<%=payer%>'>
      	<input type='hidden' name='policy' id='policy' id='policy' value='<%=policy%>'>
      	<input type='hidden' name='policyNum' id='policyNum' id='policyNum' value='<%=policyNum%>'>
      	<input type='hidden' name='privForIndirect' id='privForIndirect' id='privForIndirect' value='<%=privilege[0] %>'>
      	<input type='hidden' name='chargeLogicYN' id='chargeLogicYN' id='chargeLogicYN' value='<%=chargeLogicYN %>'>
</FORM>
</body>

</HTML>

