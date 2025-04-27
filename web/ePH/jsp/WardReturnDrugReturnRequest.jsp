<!DOCTYPE html>
 <%-- In Jsp Page included for KDAH-CRF-250-U001 --%>
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		
<%
        request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		 request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		 response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		 response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		 //ends

	    String locale			= (String)session.getAttribute("LOCALE");
	    String mode	= CommonRepository.getCommonKeyValue("MODE_MODIFY"); 
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../ePH/js/WardReturn.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form id="FormWardReturnDrug1" name="FormWardReturnDrug1" id="FormWardReturnDrug1">
<%
			//Search Criteria's from Query Criteria page
			String patientid			= request.getParameter( "patientid" );
			String drugcode				= request.getParameter( "drugcode" );
			String nationalid			= "" ;
			String healthcard			= "";
			String dispno     			= request.getParameter( "dispno" ) ;
			System.err.println("dispno+++++++36"+dispno);
			String cutoff     			= request.getParameter( "cutoff" ) ;
			String orderid     			= request.getParameter( "orderid" ) ;
			String displocn     		= request.getParameter( "dispLocn" ) ;
			System.err.println("displocn+++++++in jsp 39"+displocn);
			String ordering_facility_id	= request.getParameter( "ordering_facility_id" ) ;

			java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
			String bean_id		= "WardReturnBean"+login_at_ws_no;
			String bean_name	= "ePH.WardReturnBean";
            int countReturn=0;
            int count1=1;
        //    String DISC_DATE_TIME="";
			/* Initialize Function specific start */
			WardReturnBean bean = (WardReturnBean)getBeanObject( bean_id,bean_name,request) ;
			String Ward_Date_From   = CommonBean.checkForNull(request.getParameter( "Ward_Date_From" ) );
			String ward_Date_To     = CommonBean.checkForNull(request.getParameter( "ward_Date_To" )) ;
		//	ReturnMedicationBean bean_return = (ReturnMedicationBean)getBeanObject( bean_id,bean_name,request) ;
			bean.setMode(mode);
			if(patientid.equals("")){
				patientid=(String)bean.getPatient_ID(dispno);
			}
			bean.setOrderingFacilityID(ordering_facility_id);  
						
			
			System.out.println("wardReturn_YN"+request.getParameter( "wardReturnYN" ) );
					String wardReturnYN =request.getParameter( "wardReturnYN" );
					
			ArrayList drugDetails=bean.getDrugDetails(patientid,drugcode,nationalid,healthcard,dispno,cutoff,orderid,displocn,locale,wardReturnYN,Ward_Date_From,ward_Date_To);
			if (drugDetails.size()==0){
%>
				<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script> <%--removed parent.parent.reset(); for KDAH-CRF-250--%>
<%
countReturn =0;
			}
			else{
				countReturn =1;
			
					ArrayList patientDetails=new ArrayList();
					patientDetails=bean.getPatientDetails(patientid);
					String patientUrl="../../ePH/jsp/WardReturnPatientDetails.jsp?patient_id="+patientid+"&dispno="+dispno;
	%>
					<script>parent.wardretmedicationplineframe.location.href="<%=patientUrl%>";</script>
				
				<%	String classvalue="";
					
					String DISC_DATE_TIME		 = " ";
					
					//String nationalid			 = "" ;
					//String healthcard     		 = "" ;
					
					%>
					   
					<TABLE   cellspacing="0" cellpadding="0" border="1" width = "100%">     
						<tr>
							
							<td   class='COLUMNHEADER' width="5%" align="right">
							<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
							<input type=checkbox name="SelectAll" id="SelectAll" id="SelectAll"  onClick="selectAllDrugs(this)"></td >
							<td class='COLUMNHEADER'  width=20%><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADER'  width=5%><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADER' width=10%><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td >
							<td class='COLUMNHEADER' width=5%><fmt:message key="ePH.Dispenseno.label" bundle="${ph_labels}"/></td>
							<td class='COLUMNHEADER' width=5%><fmt:message key="ePH.ReturningLocation.label" bundle="${ph_labels}"/></td >
							<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.ReturnRequestDate.label" bundle="${ph_labels}"/></td >
							<td class='COLUMNHEADER' width=5%><fmt:message key="ePH.IssuedQty.label" bundle="${ph_labels}"/></td >
							<td class='COLUMNHEADER' width=5%><fmt:message key="ePH.ReturnRequestQty.label" bundle="${ph_labels}"/></td >
							<td class='COLUMNHEADER' width=5%><fmt:message key="ePH.QtyUOM.label" bundle="${ph_labels}"/></td >
							<td class='COLUMNHEADER' width=15%><fmt:message key="ePH.ReasonforReturn.label" bundle="${ph_labels}"/></td> 
							 
										  
						</tr>
<%
						int rowCount=0;
						
						for (int i=0;i<drugDetails.size();i+=18){ 
							if ( rowCount++ % 2 == 0 ){
								classvalue = "QRYEVEN" ;
							}
							else{
								classvalue = "QRYODD" ;
							}
%>
							<TR > 
							
							<td  class=<%=classvalue%> align="right">
							<input type="checkbox" id="check_id<%=count1%>" name="chk_<%=count1%>"   onclick="AssignValue(this,'<%=count1%>')" value="" />
							</td>
							   <TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" >
									<%=drugDetails.get(i)%>
<%									
									if( drugDetails.get(i+1)!=null && !drugDetails.get(i+1).equals("")){ 
%>
										<label class="label" style="font-size:xx-small;font-weight:normal" >-&nbsp;<%=drugDetails.get(i+1) %></label>
<%
									}
%>
									</TD>
									
									<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" >
								<%=drugDetails.get(i+2)%>
								</TD>
								
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" >
								<%=com.ehis.util.DateUtils.convertDate((String)drugDetails.get(i+3),"DMY","en",locale)%>
								</TD>
									
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" >
								  <%=CommonBean.checkForNull((String)drugDetails.get(i+4))%>
								</TD>
								 
								 <TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" >
								  <%=CommonBean.checkForNull((String)drugDetails.get(i+5))%>
								</TD>
								
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" >
								<% DISC_DATE_TIME=(String)drugDetails.get(i+6);
								DISC_DATE_TIME=com.ehis.util.DateUtils.convertDate(DISC_DATE_TIME,"DMYHM","en",locale);
								if(DISC_DATE_TIME.equals("")){%>
								&nbsp;&nbsp;
								<%}else{
									%>
								<%=DISC_DATE_TIME%>
								<%} %>
								</TD>
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" >
								 <%=CommonBean.checkForNull((String)drugDetails.get(i+7))%>
								</TD>
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" >
								 <%=CommonBean.checkForNull((String)drugDetails.get(i+8))%>
								</td>
								
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" >
								 &nbsp;<%=bean.getUomDisplay(ordering_facility_id,drugDetails.get(i+9).toString())%>
								</TD>
								
									<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" >
								 <%=CommonBean.checkForNull((String)drugDetails.get(i+10))%>
								</TD>
								
							<input type="hidden" name="dispno<%=count1%>" id="dispno<%=count1%>"value="<%=drugDetails.get(i+4)%>">
							<input type="hidden" name="srlno<%=count1%>" id="srlno<%=count1%>"value="<%=drugDetails.get(i+12)%>">
							<input type="hidden" name="srlnobatch<%=count1%>" id="srlnobatch<%=count1%>"value="<%=drugDetails.get(i+13)%>">
							<input type="hidden" name="orderLineNo<%=count1%>" id="orderLineNo<%=count1%>"value="<%=drugDetails.get(i+15)%>">
							<input type="hidden" name="orderId<%=count1%>" id="orderId<%=count1%>"value="<%=drugDetails.get(i+14)%>">
							<input type="hidden" name="retdocno<%=count1%>" id="retdocno<%=count1%>"value="<%=drugDetails.get(i+16)%>">
							<input type="hidden" name="retdoclineno<%=count1%>" id="retdoclineno<%=count1%>"value="<%=drugDetails.get(i+17)%>">
							
							</TR>
							
<%
							count1++;
						}
%>
						
					</table>
<%
				
				
			}
			
%>
<input type="hidden" name="total_count" id="total_count"value="<%=count1-1%>">
<script>
				parent.wardretmedicationbuttonframe.location.href="../../ePH/jsp/WardReturnButton.jsp?countReturn="+<%=countReturn%>;

			</script>
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
		</form>
		
<% 
		putObjectInBean(bean_id,bean,request); 
%>
	</body>
</html>

