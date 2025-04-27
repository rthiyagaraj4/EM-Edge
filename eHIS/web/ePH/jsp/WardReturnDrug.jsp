<!DOCTYPE html>
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    String locale			= (String)session.getAttribute("LOCALE");
	  
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
		<form id="FormWardReturnDrug" name="FormWardReturnDrug" id="FormWardReturnDrug">
<%
			//Search Criteria's from Query Criteria page
			String patientid			= request.getParameter( "patientid" );
			String drugcode				= request.getParameter( "drugcode" );
			String nationalid			= "" ;
			String healthcard			= "";
			String dispno     			= request.getParameter( "dispno" ) ;
			String cutoff     			= request.getParameter( "cutoff" ) ;
			String orderid     			= request.getParameter( "orderid" ) ;
			String displocn     		= request.getParameter( "dispLocn" ) ;
			String ordering_facility_id	= request.getParameter( "ordering_facility_id" ) ;

			java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
			String bean_id		= "WardReturnBean"+login_at_ws_no;
			String bean_name	= "ePH.WardReturnBean";

			/* Initialize Function specific start */
			WardReturnBean bean = (WardReturnBean)getBeanObject( bean_id,bean_name,request) ;
			boolean site = bean.isSiteSpecific("PH", "WARD_ACK"); // Added for GHL-CRF-0413.8
			bean.getScannedBatchDetails().clear(); // Added for GHL-CRF-0413.8
			bean.getscannedDetails().clear(); // Added for GHL-CRF-0413.8
			if(patientid.equals("")){
				patientid=(String)bean.getPatient_ID(dispno);
			}
			bean.setOrderingFacilityID(ordering_facility_id);  
			String episode_id = bean.getEpisodeId(patientid) ;//code added for FD-JD-CRF-0178[IN039208]			
			boolean bill_gen_yn			   = bean.getBillGenStatus(patientid,ordering_facility_id,episode_id);//code added for FD-JD-CRF-0178[IN039208]
			ArrayList drugDetails=bean.getDrugDetails(patientid,drugcode,nationalid,healthcard,dispno,cutoff,orderid,displocn,locale);
			if (drugDetails.size()==0){
%>
				<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script> <%--removed parent.parent.reset(); for KDAH-CRF-250--%>
<%
			}
			else{
				if (bill_gen_yn){
%>
					<script>//code added for FD-JD-CRF-0178[IN039208]--Start
						var proceed_yn =confirm(getMessage("PH_WARD_RETURN_BILL_GEN", "PH"));
						if(!proceed_yn){
							parent.parent.reset(); 
						}//code added for FD-JD-CRF-0178[IN039208]--End	
					</script> 
<%				
				}
				ArrayList patientDetails=new ArrayList();
				patientDetails=bean.getPatientDetails(patientid);
				String remarksUrl="../../ePH/jsp/WardReturnRemarks.jsp?"+request.getQueryString();
				String patientUrl="../../ePH/jsp/WardReturnPatientDetails.jsp?patient_id="+patientid+"&dispno="+dispno;
%>
				<script>parent.wardretmedicationremarksframe.location.href="<%=remarksUrl%>";
				parent.wardretmedicationplineframe.location.href="<%=patientUrl%>";</script>
				<table width="100%" align="right" cellspacing=0 cellpadding=0 border=1>
					<tr>
						<th width="15%" align="right"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
						<input type=checkbox name="SelectAll" id="SelectAll" id="SelectAll"  onClick="selectAll(this)"></th >
						<th ><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
					</tr>
<%
					int rowCount=0;
					//Added for for GHL-CRF-0412  start
 					int dispCount=0;
					int dispLocationCount=0;
					String dispLocationCode="";
					String dispCode="";
					//Added for for GHL-CRF-0412  end
					String classvalue="";
									
					for (int i=0;i<drugDetails.size();i+=5){ //	 incremented from 2 to 3  for AMS-SCF-0190 IN038440    incremented from 3 to 5 for GHL-CRF-0412
						
						//Added for for GHL-CRF-0412  Start
						if(((String)drugDetails.get(i+4)).equals(dispLocationCode)){
							
						}
						else{
							dispLocationCount++;
						}
						dispLocationCode=(String)drugDetails.get(4);
						dispCode=(String)drugDetails.get(3);
						
						//Added for for GHL-CRF-0412  End
						if ( rowCount++ % 2 == 0 ){
							classvalue = "QRYEVEN" ;
						}
						else{
							classvalue = "QRYODD" ;
						}
%>
						<tr>
							<td  class=<%=classvalue%> align="right">
							<input type="Checkbox"  name="DrugSelect" id="DrugSelect"  onClick="enableProceed(this)">
							<input type=hidden name="drugid" id="drugid" value="<%=drugDetails.get(i)%>">
							</td>
							<td class=<%=classvalue%>  style="font-family:verdana;font-size:8pt;" >
							<%=drugDetails.get(i+1)%>
<%
							if(bean.getTradeName_Flag().equals("Y") && (drugDetails.get(i+2)!=null && !drugDetails.get(i+2).equals(""))){ //Added for AMS-SCF-0190 IN038440
%>
								<label class="label" style="font-size:xx-small;font-weight:normal" >(<%=drugDetails.get(i+2) %>)</label>
<%
							}
%>
					<input type=hidden name="disp_code<%=dispCount %>" id="disp_code<%=dispCount %>" value="<%=drugDetails.get(i+3)%>">  <!-- Added  for GHL-CRF-0412  -->
					<input type=hidden name="disp_value<%=dispCount %>" id="disp_value<%=dispCount %>" value="<%=drugDetails.get(i+4)%>">  <!-- Added  for GHL-CRF-0412 --> 
						</td>
					</tr>
<%
            
				dispCount++;//Added for for GHL-CRF-0412  
				}  
%>
			</table>
			<input type=hidden name="dispLocationCount" id="dispLocationCount" value="<%=dispLocationCount%>"> <!-- Added  for GHL-CRF-0412  -->
<%
             //Added  for GHL-CRF-0412 start
        		if(dispLocationCount == 1){
            	 bean.setDisp_locn_value(dispLocationCode);
            	 bean.setDisp_locn(dispCode);
            	 %>  	 
            	 
        
            	 <%    }else{
            		 bean.setDisp_locn_value("");
            		 bean.setDisp_locn("");
            	 }  //Added  for GHL-CRF-0412 end
			}
%>
		</form>
<% 
		putObjectInBean(bean_id,bean,request); 
%>
	</body>
</html>

