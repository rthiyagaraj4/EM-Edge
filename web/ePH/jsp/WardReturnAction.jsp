<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.* " %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../ePH/js/WardReturn.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form id="FormWardReturnAction" name="FormWardReturnAction" id="FormWardReturnAction">
<%
try{
			String mode	= CommonRepository.getCommonKeyValue("MODE_INSERT"); 
			java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
			String bean_id		= "WardReturnBean"+login_at_ws_no;
			String bean_name	= "ePH.WardReturnBean";
			String facility_id					= (String) session.getValue("facility_id");

			WardReturnBean bean = (WardReturnBean)getBeanObject( bean_id,bean_name,request) ;
			bean.clear() ;
			bean.setLanguageId(locale);
			bean.setMode( mode ) ;
			
			//Search Criteria's from Query Criteria page
			String patientid		= CommonBean.checkForNull(request.getParameter( "patientid" ));
			String drugcodes		= request.getParameter( "drugcodes" );
			String dispno     		= request.getParameter( "dispno" ) ;
			String cutoff     		= request.getParameter( "cutoff" ) ;
			String orderid     		= request.getParameter( "orderid" ) ;
			String displocn     	= request.getParameter( "dispLocn" ) ;
			String remarks     		= request.getParameter( "remarks" ) ;
			String ToStoreCode     	= request.getParameter( "ToStoreCode" ) ;
			String ToStore     	    = request.getParameter( "ToStore" ) ;
                        String drugcodes1       = request.getParameter( "checkstring1")==null?"":request.getParameter( "checkstring1"); // Added for GHL-CRF-0413.8 - Start
                        String barcode_id       = request.getParameter( "barcode_id" )==null?"":request.getParameter( "barcode_id" );
						barcode_id=barcode_id.trim();  // Added for GHL-CRF-0413.8 
                        String calledFrom       = request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");
                        if(!calledFrom.equals("ScannedBatch")){
							bean.getScannedBatchDetails().clear(); 
							bean.getscannedDetails().clear(); 
                        } // Added for GHL-CRF-0413.8  - End
			StringBuffer issue_qty_dtl   = new StringBuffer(); 
			HashMap IssueUOMAndBaseUOM	 = new HashMap();
			HashMap binLocationDetails	 = new HashMap();
			ArrayList binLocation=new ArrayList();

			String dflt_issue_uom		 = "";
			String base_uom			     = "";
			int base_to_disp_uom_equl    = 0;
			int base_to_def_uom_equl     = 0;
			int base_to_issue_uom_equl   = 0;
			int base_to_to_store_def_uom_equl = 0;
			int final_conv_factor        = 0;
			String to_store_def_issue_uom ="";
			String issue_uom_by			 = bean.getISSUE_UOM_BY ();

			String order_line_staus      = "";
			String dis_cont_reason       = "";
			String DISC_DATE_TIME		 = "";
			String pract_name			 = "";
			String nationalid			 = "" ;
			String healthcard     		 = "" ;
			String drug_code     		 = "" ;
			String status				 = "" ;
			int disabledCount			 = 0;
			boolean flag				 = false;

			String StoreCount			 = "" ;
			boolean site                 = bean.isSiteSpecific("PH", "WARD_ACK"); // Added for GHL-CRF-0413.8
			boolean barcode_2d_applicable = bean.isSiteSpecific("ST","2D_BARCODE_APPLICABLE");
			/* Initialize Function specific start */
			if(patientid.equals("")){
				patientid=(String)bean.getPatient_ID(dispno);
			}
			ArrayList checkedArray = new ArrayList();
			ArrayList batchDetails = bean.getScannedBatchDetails();
			
			HashMap scanned = bean.getscannedDetails();
		    batchDetails=bean.getBatchDetails(patientid,drugcodes,nationalid,healthcard,dispno,cutoff,orderid,displocn,ToStoreCode,barcode_id); // barcode_id Added for GHL-CRF-0413.8
			if ((batchDetails.size()==0 && !batchDetails.contains(barcode_id.trim())) && site && !barcode_id.equals("")){ // Added for GHL-CRF-0413.8 - Start
				%>
								<script>alert(getMessage("NOT_A_VALID_BARCODE","PH")); cancelAction();</script>
				<%
							}
			
			if(bean.getScannedBatchDetails().size()>0){ 
				batchDetails = bean.getScannedBatchDetails();
			} // Added for GHL-CRF-0413.8 - End
				
			int totalRows=batchDetails.size()/33; //changed 32 to 33 for BRU-SCF-1842
			int increment =33;//changed 32 to 33 for BRU-SCF-1842
		
			if(site || barcode_2d_applicable){ // if condition Added for GHL-CRF-0413.8 -Start
				
				totalRows=batchDetails.size()/35; //changed 34 to 35 for BRU-SCF-1842
				increment =35; //changed 34 to 35 for BRU-SCF-1842
			} // if condition Added for GHL-CRF-0413.8  - End
			int administred_count =0;
			if ((batchDetails.size()==0 && !batchDetails.contains(barcode_id.trim())) && site && !barcode_id.equals("")){ // else if Added for GHL-CRF-0413.8 - Start
				%>
				<script>alert(getMessage("NOT_A_VALID_BARCODE","PH")); cancelAction();</script>
<%
			} 
			else if (batchDetails.size()==0 && !site){
%>
				<script> alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));parent.parent.reset();</script>
<%
			}
			else{
				if((batchDetails.size()>0 && !batchDetails.contains(barcode_id.trim())) && site && !barcode_id.equals("")){
					%>
					<script>alert(getMessage("NOT_A_VALID_BARCODE","PH"));</script>
	<%
				}
				else if(site && !barcode_id.equals("") && batchDetails.size()>0){
%>
<script type="text/javascript">
var barcode='<%=barcode_id%>';
var barcodeDrug ='<%=batchDetails.get((batchDetails.indexOf(barcode_id))-17)%>';
var formObjdrug=parent.wardretmedicationdrugframe.FormWardReturnDrug;
var check=formObjdrug.DrugSelect;
var drugid=formObjdrug.drugid;
var drugselect = formObjdrug.DrugSelect;
for(i=0;i<check.length;i++){
  if(drugid[i].value==barcodeDrug){
	  drugselect[i].checked=true;
	  break;
  }
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%} 
	boolean Filled=false;
	if(!barcode_id.equals("") && site){
    	if(batchDetails.contains(barcode_id.trim())){
             for(int i=0;i<batchDetails.size();i+=35){ // 34 Changed to 35 for ML-BRU-SCF-1842 (PO Raised Issue)
            	 int incrmt = (Integer)batchDetails.get(i+33); 
            	 if(batchDetails.get(i+32).equals(barcode_id.trim())){
            		if(Integer.parseInt((String)batchDetails.get(i+21))>incrmt){
            			incrmt=incrmt+1;
            			batchDetails.set((i+33), incrmt);
            			scanned.put(batchDetails.get(i+3), "Y");
            			bean.setscannedDetails(scanned);
            			bean.setScannedBatchDetails(batchDetails);
            			Filled = true;
            			break;
            		}
            	 }
             }
          if(!Filled){
       %><script>
       alert(getMessage("PH_EXCEED_BALANCE_QTY","PH"));
       </script><% 
          }
          } 		
    } // Added for GHL-CRF-0431.8 - End
	%>
				<TABLE width="100%" align="left" cellspacing="0" cellpadding="0" border="1">
					<TR>
						<Th colspan=13 style="background-color:#FFD7D7;color:black;border-color:#FFD7D7" align="left"><fmt:message key="ePH.DispensedDrugDetails.label" bundle="${ph_labels}"/></Th>
					</TR>
					<TR>
					    <%if(site){ // Added for GHL-CRF-0413.8[IN063028] -Start %>
						 <td class='COLUMNHEADER' width=6%><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><input type="checkbox" name="Selcet_chk" id="Selcet_chk" value='' onClick="SelectAll_1(this,'<%=totalRows%>')"></td>
						    <%} // Added for GHL-CRF-0413.8[IN063028] -End %>
					    <td class='COLUMNHEADER'  width=26%><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' width=8%><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' width=10%><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></td>
						<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
						<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.DispensedDate.label" bundle="${ph_labels}"/></td> 
						<td class='COLUMNHEADER' width=6%><fmt:message key="Common.IssuedQuantity.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' width=6%><fmt:message key="ePH.QtyUOM.label" bundle="${ph_labels}"/></td>
						<td class='COLUMNHEADER' width=12%><fmt:message key="ePH.MaxReturnQty.label" bundle="${ph_labels}"/></td>
						<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.ReturnedQuantity.label" bundle="${ph_labels}"/></td>
					</tr>
<%
					int rowCount=0;
					String classvalue="";
					String batch_uom = "";//added for BRU-SCF-1842
					if(batchDetails!=null && batchDetails.size()>1){ // added for icn63722	
						for (int i=0,count=1;i<batchDetails.size();i+=increment){// Incremented 30 to 31  AMS-SCF-190 IN038440 // 31 changed to increment for GHL-CRF-0413.8
							if ( rowCount++ % 2 == 0 ){
								classvalue = "QRYEVEN" ;
							}
							else{
								classvalue = "QRYODD" ;
							}
							if(batchDetails.get(i+20).equals("Y")&& !batchDetails.get(i+21).equals("0")){
								flag   =	true;
								issue_qty_dtl			 =  new StringBuffer(); 
								IssueUOMAndBaseUOM		 =	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM((String)batchDetails.get(i+15),(String)batchDetails.get(i+14));			
								dflt_issue_uom			 =	(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
								base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM");
								to_store_def_issue_uom   = 	(String)batchDetails.get(i+19);
								StoreCount="0";
								if(!to_store_def_issue_uom.equals("")){	
								   StoreCount="1";
								}
								
								drug_code=(String)batchDetails.get(i+15);
								binLocation		 =	bean.getBinDetails(drug_code,displocn,locale);	
								
								base_to_disp_uom_equl    =	bean.getEqulValue ( (String)batchDetails.get(i+15), base_uom, (String)batchDetails.get(i+6));	
								base_to_def_uom_equl     =	bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom, dflt_issue_uom);			
								final_conv_factor        =	bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
								base_to_to_store_def_uom_equl =	bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom, to_store_def_issue_uom);

								if(site){ //if else added for BRU-SCF-1842
									batch_uom = (String)batchDetails.get(i+34);
								}else{
									batch_uom = (String)batchDetails.get(i+32);
								}
							 	//if(base_to_disp_uom_equl!=0 &&base_to_def_uom_equl!=0)COMMENTED FOR ML-BRU-SCF-1880
									if(base_to_disp_uom_equl != base_to_def_uom_equl){
									if(!((String)batchDetails.get(i+23)).equals("")){		
										if(issue_uom_by.equals("I")){
											base_to_issue_uom_equl   =  bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom,(String)batchDetails.get(i+23));
											if(!displocn.equals(ToStore)){
											   final_conv_factor        =	bean.lcm( final_conv_factor,base_to_to_store_def_uom_equl);
											} 
											else{
											   final_conv_factor        =	bean.lcm( final_conv_factor,base_to_issue_uom_equl);
											}
										}	
										issue_qty_dtl.append("( ").append((String)batchDetails.get(i+22)).append((String)batchDetails.get(i+24)).append(" )");
									}
									if(final_conv_factor>1)
									{final_conv_factor =final_conv_factor/base_to_disp_uom_equl;	//commented for ML-BRU-SCF-1880
									}
								}
%>
								<TR >
								    <% String checkYN ="";  // Added for GHL-CRF-0413.8[IN063028] - Start
								    if(site){  
								    	if(scanned.containsKey(batchDetails.get(i+3)) && scanned.get(batchDetails.get(i+3)).equals("Y"))
								            checkYN="checked";
								         else
								            checkYN ="";
								            	
								    %> 
							    <td class="<%=classvalue%>"><input type="checkbox" name="check_name<%=count%>" id="check_name<%=count%>" onClick="selectCheck(<%=count%>)" <%=checkYN%>></td>
							      <%} // Added for GHL-CRF-0413.8[IN063028] - End %>
									<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
										<%=batchDetails.get(i)%> - <%=batchDetails.get(i+29)%>
<%
										if(bean.getTradeName_Flag().equals("Y") && (batchDetails.get(i+30)!=null && !batchDetails.get(i+30).equals(""))){ // if block added for AMS-SCF-190 IN038440
%>
											<label class="label" style="font-size:xx-small;font-weight:normal" >(<%=batchDetails.get(i+30) %>)</label> 
<%
										}
%>
									</TD>
									<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
										<%=batchDetails.get(i+1)%>
									</TD>
									<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;">
										<%=com.ehis.util.DateUtils.convertDate((String)batchDetails.get(i+2),"DMY","en",locale)%>
									</TD>
									<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
										<%=batchDetails.get(i+3)%>
									</TD>
									<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
										<%=batchDetails.get(i+18)%> 
										<input type="hidden" name="dispno<%=count%>" id="dispno<%=count%>" id="dispno<%=count%>" value=<%=batchDetails.get(i+3)%>>
									</TD>
									<TD  class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
										<%=com.ehis.util.DateUtils.convertDate((String)batchDetails.get(i+4),"DMY","en",locale)%>
										<input type="hidden" name="disp_date_time<%=count%>" id="disp_date_time<%=count%>" id="disp_date_time<%=count%>" value=<%=(String)batchDetails.get(i+4)%>>
									</TD>
									<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;"  align="right" nowrap>
										<%=batchDetails.get(i+5)%><br>
<%
									if(issue_uom_by.equals("I")){
%>				
										<b><%=issue_qty_dtl.toString()%><b>
<%
									}
%>
									</TD>
									<TD class="<%=classvalue%>" nowrap>
									<%=bean.getUomDisplay(facility_id,batch_uom)%> <!-- changed (String)batchDetails.get(i+6) batch_uom for BRU-SCF-1842-->
									</TD>

									<TD align="right" class="<%=classvalue%>">
									
									<%=batchDetails.get(i+21)%></TD>
									<TD>
								<%if(site && (!barcode_id.equals("") || drugcodes1.length()>0) && scanned.containsKey(batchDetails.get(i+3)) && scanned.get(batchDetails.get(i+3)).equals("Y")){
									%>
									<input type='text'  maxlength=3 size=3 style="text-align:right" name="actualReturn<%=count%>" id="actualReturn<%=count%>" value=<%=batchDetails.get(i+33)%>  id="actualReturn<%=count%>"  onKeyPress=" if(event.keyCode!=13) {return allowValidNumber(this,event,3,0);}else{return false;}"onblur="CheckPositiveNumber(this);checkQty(this,<%=final_conv_factor%>,<%=base_to_disp_uom_equl%>,<%=base_to_def_uom_equl%>,'<%=(String)batchDetails.get(i+6)%>','<%=dflt_issue_uom%>');StoreCheck(<%=StoreCount%>);checkOnChange(<%=count%>);saveChangedQty(this,<%=count%>);">
									<%}else if(site){ %>
									<input type='text'  maxlength=3 size=3 style="text-align:right" name="actualReturn<%=count%>" id="actualReturn<%=count%>" id="actualReturn<%=count%>"  onKeyPress=" if(event.keyCode!=13) {return allowValidNumber(this,event,3,0);}else{return false;}"onblur="CheckPositiveNumber(this);checkQty(this,<%=final_conv_factor%>,<%=base_to_disp_uom_equl%>,<%=base_to_def_uom_equl%>,'<%=(String)batchDetails.get(i+6)%>','<%=dflt_issue_uom%>');StoreCheck(<%=StoreCount%>);checkOnChange(<%=count%>);saveChangedQty(this,<%=count%>);">
									<%} 
									 else{%>
									 <input type='text'  maxlength=3 size=3 style="text-align:right" name="actualReturn<%=count%>" id="actualReturn<%=count%>" id="actualReturn<%=count%>"  onKeyPress=" if(event.keyCode!=13) {return allowValidNumber(this,event,3,0);}else{return false;}"onblur="CheckPositiveNumber(this);checkQty(this,<%=final_conv_factor%>,<%=base_to_disp_uom_equl%>,<%=base_to_def_uom_equl%>,'<%=(String)batchDetails.get(i+6)%>','<%=dflt_issue_uom%>');StoreCheck(<%=StoreCount%>);">
									<%} %>
									<input type="hidden" name="returnable<%=count%>" id="returnable<%=count%>" id="returnable<%=count%>" value=<%=batchDetails.get(i+21)%>>		
									<input type="hidden" name="disp_locn_code<%=count%>" id="disp_locn_code<%=count%>" id="disp_locn_code<%=count%>" value=<%=batchDetails.get(i+14)%>>	
									<input type="hidden" name="patient_class<%=count%>" id="patient_class<%=count%>" id="patient_class<%=count%>" value=<%=batchDetails.get(i+25)%>>	
									<input type="hidden" name="order_id<%=count%>" id="order_id<%=count%>" id="order_id<%=count%>" value=<%=batchDetails.get(i+26)%>>	
									<input type="hidden" name="order_line_no<%=count%>" id="order_line_no<%=count%>" id="order_id<%=count%>" value=<%=batchDetails.get(i+27)%>>	
									<input type="hidden" name="srl_no<%=count%>" id="srl_no<%=count%>" id="srl_no<%=count%>" value=<%=batchDetails.get(i+9)%>>	
									<input type="hidden" name="srl_no_batch<%=count%>" id="srl_no_batch<%=count%>" id="srl_no_batch<%=count%>" value=<%=batchDetails.get(i+10)%>>	
									<input type="hidden" name="qty_uom<%=count%>" id="qty_uom<%=count%>" id="qty_uom<%=count%>" value=<%=batchDetails.get(i+6)%>>	
									<input type="hidden" name="drugcodes<%=count%>" id="drugcodes<%=count%>" id="drugcodes<%=count%>" value=<%=batchDetails.get(i+15)%>>	
									<input type="hidden" name="from_locn_code<%=count%>" id="from_locn_code<%=count%>" id="from_locn_code<%=count%>" value=<%=batchDetails.get(i+28)%>>	
									<input type="hidden" name="encounter_id<%=count%>" id="encounter_id<%=count%>" id="encounter_id<%=count%>" value=<%=batchDetails.get(i+29)%>>	
									<input type="hidden" name="tot_admin_qty<%=count%>" id="tot_admin_qty<%=count%>" id="tot_admin_qty<%=count%>" value=<%=batchDetails.get(i+31)%>>	
									<input type="hidden" name="StoreCount<%=count%>" id="StoreCount<%=count%>" id="StoreCount<%=count%>" value=<%=StoreCount%>>	<!-- GHL-SCF-1395-->
									
									</TD>
								</TR>
<%
								count++;
							}
							else{
							   administred_count++;
							}
						}
					}//end if
				
					if(!flag && batchDetails.size() != 1 ){ // modefied for icn63722
%>
						<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));parent.parent.reset();</script>
<%
					}
				}
%>
			<script>
   					 var rowCount = <%= totalRows - administred_count %>;  
    					parent.wardretmedicationbuttonframe.location.href = "../../ePH/jsp/WardReturnButton.jsp?countRows=" + rowCount;
			</script>
			<INPUT TYPE="hidden" name="remarks" id="remarks" VALUE="<%= remarks %>">
			<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
			<INPUT TYPE="hidden" name="patientid" id="patientid" VALUE="<%= patientid %>">

			<INPUT TYPE="hidden" name="disabledCoun" id="disabledCoun" VALUE="<%= disabledCount%>">
			<INPUT TYPE="hidden" name="totalrows" id="totalrows" VALUE="<%=totalRows-administred_count%>">
			<INPUT TYPE="hidden" name="ToStore" id="ToStore" VALUE="<%=ToStore%>">
			<INPUT TYPE="hidden" name="ToStoreCode" id="ToStoreCode" VALUE="<%=ToStoreCode%>">
			<INPUT TYPE="hidden" name="site" id="site" VALUE="<%=site%>"> <!--  Added for GHL-CRF-0413.8 -->
		</form>
<%
		putObjectInBean(bean_id,bean,request); 
	}catch(Exception e){
		e.printStackTrace();
	}
%>
	</body>
</html>

