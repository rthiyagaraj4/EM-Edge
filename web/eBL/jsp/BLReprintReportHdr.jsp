<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page   import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*,java.util.*,java.util.GregorianCalendar,java.util.Date,java.util.Calendar,eBL.BLReportIdMapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!--
Sr No        Version           TFS/Incident        SCF/CRF    			Developer Name
----------------------------------------------------------------------------------------------
1            V210405             16612     	 	NMC-JD-SCF-0167-TF		Mohana Priya K
2            V210624             17147     		PMG2021-COMN-CRF-0077		MuthkumarN
-->

<%!
public String subtractDays(Date date, int days) {
    GregorianCalendar cal = new GregorianCalendar();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    cal.setTime(date);
    cal.add(Calendar.DATE, -days);             
    return dateFormat.format(cal.getTime());
}
%>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	Connection con1 = null;
	Connection con2 = null;//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	ResultSet rs1=null; ResultSet rs=null;
	ResultSet rs2=null;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt1 = null ;
	String locale="";
	String p_facility_id="";
	String bill_number="";
	String payer_type=""; 
	String patient_id1="";
	String bill_number_code="";
	String payer=""; 
	String strPatientId="";
	String nursing_unit_code=""; String payer_code="";
	String p_module_id		= "BL" ;
	String p_report_id		= "BLRBLPRT" ;
	String p_user_name		= (String) session.getValue( "login_user" );
	String PatIDLen = "";
	String todaysDate= "";
	String todaysDate30 ="";
	//String demo_version="";//Commented against V210624
	String site_id="";
	Calendar cal = Calendar.getInstance();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Boolean siteSpec=false;
	//Added V20180720-Subha/ML-MMOH-CRF-1173/Starts
	boolean siteSpecAuditReport = false; 
	String strLoggedUser = (String) session.getValue("login_user");	
	if (strLoggedUser==null) strLoggedUser = "";
	String siteSpecAuditReportYN = "";
	//Added V20180720-Subha/ML-MMOH-CRF-1173/Ends
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	boolean site3TierAlmoFeature = false;
	String site3TierAlmoFeatureYN = "";
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	try{			HttpSession httpSession = request.getSession(false);
		
		con	=	ConnectionManager.getConnection(request);	
		locale	= (String)session.getAttribute("LOCALE");
		p_facility_id = (String)httpSession.getValue("facility_id");
		payer=request.getParameter("payer");
		if(payer==null || payer.equals("")) payer="";
		bill_number=request.getParameter("bill_number");
		if(bill_number==null || bill_number.equals("")) bill_number="";
		bill_number_code=request.getParameter("bill_number_code");
		if(bill_number_code==null || bill_number_code.equals("")) bill_number_code="";
		
		todaysDate = dateFormat.format(cal.getTime());		
		todaysDate30 = subtractDays(cal.getTime(),29);
		
		
		try{
			
			siteSpec= eCommon.Common.CommonBean.isSiteSpecific(con,"BL", "ARABIC_REPORT_PRINT");
			
			if(siteSpec)
			{
				if(!("en".equalsIgnoreCase(locale)))
				{
				p_report_id="BLRBLPRT_ALMOAR";
				}
				else
				{
					p_report_id="BLRBLPRT";
				}
			}
			else
			{
				p_report_id="BLRBLPRT";
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Exception in site spec "+e);
		}
		
	  }catch(Exception eX){	
		out.println("Error= "+eX);}
	
	//Added V180201-Subha/KDAH-SCF-0472
	try {
		p_report_id = BLReportIdMapper.getBlReprintMethod(con, p_report_id, p_facility_id);
		System.out.println("Report ID " + p_report_id);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception in BLReprintReportHdr.jsp for reportID "+ e);
		}

	//Added V20180720-Subha/ML-MMOH-CRF-1173/Starts
	try{
		siteSpecAuditReport= eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "REPRINT_BILL_AUDIT_TRAIL_RPRT");
		System.out.println("siteSpecAuditReport: "+siteSpecAuditReport);
		if(siteSpecAuditReport) {
			siteSpecAuditReportYN = "Y";
		}else {
			siteSpecAuditReportYN = "N";
		}
	}catch(Exception exx) {
		exx.printStackTrace();
		System.err.println("Exception in site spec "+exx);
	}
	//Added V20180720-Subha/ML-MMOH-CRF-1173/Ends
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	try {
		con2	=	ConnectionManager.getConnection(request);
		site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con2, "BL","3TIERALMOFEATURE");
		if (site3TierAlmoFeature) {
			site3TierAlmoFeatureYN = "Y";
		}else {
			site3TierAlmoFeatureYN = "N";
		}
	} catch(Exception ex) {
		System.err.println("Error in AddModifyInsUpldImgHdr.jsp for getting site3TierAlmoFeature Connection: "+ex);
		ex.printStackTrace();
	}finally{
			if(con2!=null) {
				ConnectionManager.returnConnection(con2, request);
			}
		}
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
%>
	<HTML>
		<HEAD>
			<TITLE>
			Interim Bill Generation
			</TITLE>	
<%
			String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
			<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
			<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
			<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
			<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
			<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
			<script language='javascript' src='../js/BLReprintReport.js'></script>
			<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>	
			<script language="javascript" src="../../eBL/js/AutoFillSearchCriteria.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	<script>
	 $(document).ready(function(){
		 
		 
		 	var locale=$('#locale').val();
    		
		 	var siteSpec=$('#site_spec').val();
		 $('#reset').click(function(){
			 resetSrchCriteria();
         });
		 
		 $('#episode_type').click(function(){
			 if($('#episode_type').val()=='**' || $('#episode_type').val()=='R'){				 
				 $('#episode_id').val(''); 
				 $('#episode_id').prop('disabled', true);
				 $('#episode_idbut').prop('disabled', true);			 
			 }else{
				 $('#episode_id').prop('disabled', false); 
				 $('#episode_idbut').prop('disabled', false);	
			 }
         });
		 
		
		 $('#to_bill_date').blur(function(){
			
			 var bool =  checkDateBL(document.forms[0].to_bill_date);
				
				if(!bool){
					 $('#to_bill_date').val($('#todaysDate').val());
					return false;
				}
				if($("#to_bill_date").val()!=''){
					 
					var fromLesserThanCurrentDt=isBeforeNow($("#to_bill_date").val(), 'DMY',$("#locale").val());	
					
				 	 var  lesserThanCurrentDt=isBeforeNow($("#from_bill_date").val(), 'DMY',$("#locale").val());			 
					 var  toGrtThanFromDt= isAfter( $("#to_bill_date").val(), $("#from_bill_date").val(), 'DMY',$("#locale").val());
					  
					 if(fromLesserThanCurrentDt == false){
						 alert("To Date Cannot be greater than Current Date");
						
						  $("#to_bill_date").val($('#todaysDate').val());
					 }
					 else if(lesserThanCurrentDt==false){
					  alert("From Date Cannot be greater than Current Date");
					  $("#from_bill_date").val($('#todaysDate').val());
					  }
					  else if(toGrtThanFromDt==false){
						if($("#to_bill_date").val()!='' ){
							
					 	 alert("To Date Cannot be lesser than From Date");
					  	$("#to_bill_date").val($('#from_bill_date').val());
					  }
					 }
					 
					 }
				/*else{
					$("#to_bill_date").val($("#todaysDate").val());
				}*/
			});
				
		$('#from_bill_date').blur(function(){
		
			var bool =  checkDateBL(document.forms[0].from_bill_date);
		
			if(!bool){
				 $('#from_bill_date').val($('#todaysDate').val());
				return false;
			}
			
			if($("#from_bill_date").val()!='' ){
				var fromLesserThanCurrentDt=true;
				var  lesserThanCurrentDt=true;
				var  toGrtThanFromDt=true;
				
				
				
				fromLesserThanCurrentDt=isBeforeNow($("#from_bill_date").val(), 'DMY',$("#locale").val());
				if($("#to_bill_date").val()!=''){
				lesserThanCurrentDt=isBeforeNow($("#to_bill_date").val(), 'DMY',$("#locale").val());
				toGrtThanFromDt=isAfter( $("#to_bill_date").val(), $("#from_bill_date").val(), 'DMY',$("#locale").val());
				
				}
				if(fromLesserThanCurrentDt == false){
					alert("From Date Cannot be greater than Current Date");
					$("#from_bill_date").val($('#todaysDate').val());
				}
				else if(lesserThanCurrentDt==false){
				  alert("To Date Cannot be greater than Current Date");
				  $("#to_bill_date").val($('#todaysDate').val());
				  }
				  else if(toGrtThanFromDt==false){
						if( $("#from_bill_date").val()!=''){
				 		 alert("From Date Cannot be greater than To Date");
						 $("#from_bill_date").val($("#to_bill_date").val());
						 }
				 }
				 
				 }
			/*else{
				$("#from_bill_date").val($("#todaysDate30").val());
			}*/
		});
		 
        
         fnAutoFillLoadCriteria('EBL_REPRINT_REPORT');
         
		  //V210405 starts
         if (siteSpec == 'true') {
        	 if($('#language_option').val()=='E'){
 				$('#language_option').val('E');
 				}
 			else {
 				$('#language_option').val('A');
 				}
 			}
       //V210405 ends

         if($('#dtlPrint').val()=='Y'){
        	 $('#dtlPrint').prop('checked', true);
         }
         
         if($('#outStdOnly').val()=='Y'){
        	 $('#outStdOnly').prop('checked', true);
         }
         if($('#consolidatedBillSettlement').val()=='Y'){
        	 $('#consolidatedBillSettlement').prop('checked', true);
         }
 		 if($('#episode_type').val()=='**' || $('#episode_type').val()=='R'){				 
			 $('#episode_id').val(''); 
			 $('#episode_id').prop('disabled', true);
			 $('#episode_idbut').prop('disabled', true);			 
		 }else{
			 $('#episode_id').prop('disabled', false); 
			 $('#episode_idbut').prop('disabled', false);	
		 }        
        
 		/* if($('#from_bill_date').val() == ''){
 			$('#from_bill_date').val($('#todaysDate').val());
 		 }
 		 if($('#to_bill_date').val() == ''){
  			$('#to_bill_date').val($('#todaysDate').val());
  		 }*/
  		 
  		 
		/*if (siteSpec == 'true') {
								if (locale == 'en') {
									$('#language_option').val('E');
								}

								else {
									$('#language_option').val('A');
								}
							}  */ //Commented against V210405


						});   
	</script>
	
	</HEAD> 
			<BODY onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"onSelect="codeArrestThruSelect();">
			<FORM name='BLReprintReport' id='BLReprintReport' method='' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
			<TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
			<tr>
				<td width='20%' class='COLUMNHEADER' nowrap colspan="8">
      				<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"></fmt:message> 
      			</td>
      		</tr>
			 <TR>
				
			   <td width='17%'  class='label'><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>	
			   	<td width='17%'>
				<Select id="episode_type" name="episode_type" id="episode_type">
				<%
				try{
					con	=	ConnectionManager.getConnection(request);	
					String site_id_sql = "select customer_id from sm_site_param ";

					Statement stmt = con.createStatement();
					 rs2 = stmt.executeQuery(site_id_sql);	

						if(rs2.next())
						{
						   site_id  =  rs2.getString(1);	
						}

					if(rs!=null)   rs2.close();
					if(stmt!=null) stmt.close();
				
				}
				catch(Exception eX)
				{	
					//out.println("Error= "+eX);	
					eX.printStackTrace();		
				}

				/* Commented against V210624
					try{ 
						con1	=	ConnectionManager.getConnection(request);	
						String demo_identifier_sql = "select demo_version from bl_parameters where operating_facility_id = 'QF' ";
						
						Statement stmt2 = con1.createStatement();
						ResultSet rs3 = stmt2.executeQuery(demo_identifier_sql);	

						if(rs3.next())
						{
							demo_version  =  rs3.getString(1);	
							System.out.println("demo_identifier" +demo_version);
						}

						if(rs2!=null)   rs3.close();
						if(stmt2!=null) stmt2.close();
						con1.close();
					}
					catch(Exception eX)
					{	
						out.println("Error 1= "+eX);			
					}
				finally{
					if(con1!=null) {
						ConnectionManager.returnConnection(con1, request);
					}
				}*/

				//Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
				//if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN)) &&("N".equals(demo_version))){ 
				if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN))){ //removed demo_version against V210624
				%>
				<option value="**"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<%} %>
			<%	
			try{		
				 String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
				 pstmt1=con.prepareStatement(sqlLen);
				 rs=pstmt1.executeQuery();
				 while(rs.next() && rs!=null)
				{
			     PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
				}
				 pstmt1 = null;
				 rs = null;
				pstmt1 = con.prepareStatement( " SELECT  PATIENT_CLASS,SHORT_DESC  FROM AM_PATIENT_CLASS");
				rs = pstmt1.executeQuery();	
				System.out.println("RESULT SET :"+rs);			
				
				
			while(rs.next())
			{				
				String patientClass  =  rs.getString(1);
				String epi_type=!patientClass.substring(0, 1).equalsIgnoreCase("X")?patientClass.substring(0, 1):"R";
				String patClassShortDesc  =  rs.getString(2);						
				
				out.println("Inside while loop >> patClassShortDesc :"+patClassShortDesc);
				if(epi_type.equals("I"))
				{
				%>
				<option value="<%=epi_type%>" selected><%= patClassShortDesc %></option>
				<%
				}
				else{
			
				%>
				<option value="<%=epi_type%>"><%= patClassShortDesc %></option>
			<%} out.println("short desc >> patClassShortDesc :"+patClassShortDesc.substring(0, 2)); %>
			<%
			}
			}catch(Exception e) {
				System.out.println("currency="+e.toString());
				}
			finally{
			rs.close(); 
			pstmt1.close();
			if(con!=null ) {
				ConnectionManager.returnConnection(con, request);
			}
			}
			%>
					  		
				</select>
				</td>	
				<td width="17%" class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td width="17%" class='fields'>
					<input type="text" name="patient_id" id="patient_id" id="patient_id" maxlength="<%=PatIDLen%>" 
						onKeyPress="return CheckForSpecChars(event);lockbackSpace();" onblur="if(this.value!=''){ChangeUpperCase( this ); callPatValidation(this);defaultEncounter('patId');} ">
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="PatientIdLookup();defaultEncounter();"  tabindex='2' />					
				</td>
				<td width="16%" class="label" ><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></td>
				<td width="16%" class='fields'>
					<input type="text" name="episode_id" id="episode_id" id="episode_id"  maxlength="30"   size="12"  onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
					<input type='hidden' name='hdnEpisode_id' id='hdnEpisode_id' id='hdnEpisode_id'>
					<input type='button' class='button' id="episode_idbut" name="episode_idbut" id="episode_idbut" value='?' onClick="callEpisodeDialog()"  tabindex='2' /> 		 					
				</td>  								
			</tr>
			 <tr>
			 				
				 <td width="17%" class="label" width="25%">
				 	<fmt:message key="eBL.FromBillNumber.label" bundle="${bl_labels}"/>
				 </td>	
				<td width="17%" class="fields" width="25%">
					<INPUT TYPE="TEXT"  name="from_bill_number" id="from_bill_number" id='from_bill_number' SIZE="15"  MAXLENGTH='40' VALUE="<%=bill_number%>" onBlur="if(this.value != '' ){ billNoLkup(this,document.forms[0].from_bill_number_code,'Y');billNoFromToValidation('FROM'); } else{ clearCode(from_bill_number_code);}">&nbsp;<input type='button' class='button' name="frombillbut" id="frombillbut" value='?' onClick='billNoLkup(document.forms[0].from_bill_number,document.forms[0].from_bill_number_code);billNoFromToValidation("FROM");' >
					<input type= 'hidden' name="from_bill_number_code" id="from_bill_number_code"  id='from_bill_number_code' value="<%=bill_number_code%>">
				</td>		
				<td width="17%" class="label" width="25%">
					<fmt:message key="eBL.ToBillNumber.label" bundle="${bl_labels}"/>
				</td>	
				<td width="17%" class="fields" width="25%">
					<INPUT TYPE="TEXT"  name="to_bill_number" id="to_bill_number" id='to_bill_number' SIZE="15"  MAXLENGTH='40'	VALUE="<%=bill_number%>" onBlur="if(this.value != '' ){ billNoLkup(this,document.forms[0].to_bill_number_code,'Y');billNoFromToValidation('TO');} else{ clearCode(to_bill_number_code);}">&nbsp;<input type='button' class='button' name="tobillbut" id="tobillbut" value='?' onClick='billNoLkup(document.forms[0].to_bill_number,document.forms[0].to_bill_number_code);billNoFromToValidation("TO");' >
					<input type= 'hidden' name="to_bill_number_code" id="to_bill_number_code"  id="to_bill_number_code" value="<%=bill_number_code%>">	
				</td>	
				<td width="16%" class="label" >
					<fmt:message key="Common.VisitID.label" bundle="${common_labels}"/>
					<input type="text" name="visit_id" id="visit_id" id="visit_id"  maxlength="4"  onBlur="" size="4"  onKeyPress="return CheckForSpecChars(event);lockbackSpace();">&nbsp;&nbsp;
				  </td>
				  
				  <td width="16%" class="label" >
				  <fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/>
				
					<input type="text" name="payer_group" id="payer_group" id="payer_group" size='2' onKeyPress="" onblur="payergrouplookup(payer_group,'BLUR')" >
					<input type='button' class='button' name="payergroupbtn" id="payergroupbtn" value='?' onClick="payergrouplookup(payer_group,'BTN')" >					
			 
			<input type='hidden' name='payerdesc' id='payerdesc' id='payerdesc' value=''>
				
				</td>

				
			 </tr>
			
			<tr>
		<%	
			//Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
			//if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN))&&("Y".equals(demo_version))){ 
			if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN))){//removed demo_version against V210624
		%>
			<td width='17%' class='label'><fmt:message key="eBL.FromBillDate.label" bundle="${bl_labels}"/>    </td>
			<td width='17%' class="fields"><input type='text' name='from_bill_date' id='from_bill_date' id='from_bill_date'  SIZE='10' maxlength='30' VALUE='<%=todaysDate30 %>'  ><img name='from_bill_date_cal' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('from_bill_date');" onBlur='return checkDateBL(document.forms[0].from_bill_date)'><img src='../../eCommon/images/mandatory.gif'></td>
			<td width="17%"  class='label'><fmt:message key="eBL.ToBillDate.label" bundle="${bl_labels}"/> </td>
			<td width='17%' class="fields"><input type='text' name='to_bill_date' id='to_bill_date' id='to_bill_date' SIZE='10' maxlength='30'  VALUE='<%=todaysDate %>' ><img name='to_bill_date_cal' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('to_bill_date');" onBlur='return checkDateBL(document.forms[0].to_bill_date)'><img src='../../eCommon/images/mandatory.gif'></td>
				<%}
				else {%>
<td width='17%' class='label'><fmt:message key="eBL.FromBillDate.label" bundle="${bl_labels}"/>    </td>
				<td width='17%' class="fields"><input type='text' name='from_bill_date' id='from_bill_date' id='from_bill_date'  SIZE='10' maxlength='30' VALUE='<%=todaysDate30 %>'  ><img name='from_bill_date_cal' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('from_bill_date');" onBlur='return checkDateBL(document.forms[0].from_bill_date)'></td>
				<td width="17%"  class='label'><fmt:message key="eBL.ToBillDate.label" bundle="${bl_labels}"/> </td>
				<td width='17%' class="fields"><input type='text' name='to_bill_date' id='to_bill_date' id='to_bill_date' SIZE='10' maxlength='30'  VALUE='<%=todaysDate %>' ><img name='to_bill_date_cal' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('to_bill_date');" onBlur='return checkDateBL(document.forms[0].to_bill_date)'></td>
				<% } %>
				<td width='16%'  class='label'><fmt:message key="eBL.BillType.label" bundle="${bl_labels}"/></td>		
					<td width='16%'><select id="bill_type" name='bill_type' id='bill_type' >
						<option value="**"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value="T"><fmt:message key="eBL.InterimBill.label" bundle="${bl_labels}"/></option>
						<option value="D"><fmt:message key="eBL.DischargeBill.label" bundle="${bl_labels}"/></option>
						<option value="A"><fmt:message key="eBL.UnderchargeAdvice.label" bundle="${bl_labels}"/></option>
						<option value="O"><fmt:message key="eBL.VisitBill.label" bundle="${bl_labels}"/></option>
						<!-- Added by Karthik on 3/3/2015 This External Bill Code is only for Temporary Reference -->
						<option value="E"><fmt:message key="eBL.ExternalBill.label" bundle="${bl_labels}"/></option>											
				</select>
				</td>	
			</tr>
			<tr>
				<td width='16%'  class='label'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>	
			
			<td width='16%'><select name='payer_type' id='payer_type' id='payer_type' >
						
				<option value='B'><fmt:message key="eBL.BOTH.label" bundle="${bl_labels}"/></option> <!-- added against 0038.4-->				
					 <option value='C'><fmt:message key="eBL.CASH.label" bundle="${bl_labels}"/></option> <!-- added against 0038.4-->
						 <option value='R'><fmt:message key="eBL.CREDIT.label" bundle="${bl_labels}"/></option> <!-- added against 0038.4-->
						
						</option>
				
				</select>
			</td>
			
				
				<td width="16%" class="label" >
					<fmt:message key="eBL.PAYER_CODE.label" bundle="${bl_labels}"/></td>
				<td width='16%'><input type='text' name='cust_desc' id='cust_desc' value='' size='5' onblur="custLookUp(cust_desc,'BLUR')" >&nbsp;<input type='button' name='cust_button' id='cust_button' class='button' value='?' onclick="custLookUp(cust_desc,'BTN')">
					<input type='hidden' name='cust_code' id='cust_code' id='cust_code' value='' > 
				</td>
					
	<td class="label"  width='17%' >
			
				<input type="checkbox" name="zerobill" id="zerobill" id='zerobill' checked="checked"  /> 
				&nbsp; <fmt:message key="eBL.Include_Zero_Bill.label" bundle="${bl_labels}"/>  <!--added against MOHE-CRF-0039-->       				
			</td>
			
			
			</tr>
			</TR>
			<TR>		
				 
			<td class="label" width='17%' >
				<input type="checkbox" name="dtlPrint" id="dtlPrint" id='dtlPrint'   /> 
				&nbsp;<fmt:message key="eBL.DetailedBillPrint.label"  bundle="${bl_labels}"/>
			</td>
			
			
			<td class="label" width='17%' >
				<input type="checkbox" name="outStdOnly" id="outStdOnly" id='outStdOnly'  /> 
				&nbsp;<fmt:message key="eBL.OutstandingOnly.label"  bundle="${bl_labels}"/>
			</td>
			
			<td class="label"  width='17%' >
				<input type="checkbox" name="saveSearchCriteria" id="saveSearchCriteria" id='saveSearchCriteria' checked /> 
				&nbsp;<fmt:message key="eBL.SetDefaultValue.label"  bundle="${bl_labels}"/>				
			</td>
			<%
		
			if(siteSpec){%>
				
				<td class="label"  width='17%' ><fmt:message key="Common.Language.label"  bundle="${common_labels}"/>
				&nbsp;&nbsp;
				<select name='language_option' id='language_option' id='language_option' onChange='reportOption(this)' >
					<option value='A'>Arabic</option>
					<option value='E'>English</option>
				</select>
				
				</td>
			
			<%}
				//Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
				//if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN) ) &&("Y".equals(demo_version))){
				if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN))) {//removed demo_version against V210624				
			%>
			
			<td class="label"  width='17%' >
			
				<input type="checkbox" name="consolidatedBillSettlement" id="consolidatedBillSettlement"  style="visibility:visible;" /> 
				&nbsp;<fmt:message key="eBL.consolidatedBillSettlement.label"   bundle="${bl_labels}"   />				
			</td>
		<%} 
		else{
			%>
			<td class="label"  width='17%' >
			
				<input type="checkbox" name="consolidatedBillSettlement" id='consolidatedBillSettlement' style="visibility:hidden;"   /> 
							
			</td>
		<%} %>
			
			<td  class="label" width='16%' >
				<input type='button' class='button'  onclick='search()' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>"  name='search_but' id='search_but' >&nbsp;
				<input type='button' class='button' onclick='resetSrchCriteria()' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>"  name='reset_but'  id='reset_but' >
			</td>
			<td  class="label" width='16%' >
			</td>
			</TR>
			</tr>
			</TABLE>
			<table>
			<tr></tr>
		<%
			//Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
			//if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN))&&("Y".equals(demo_version))){
			if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN))){ 
			//removed demo_version against V210624
		%>
		
			<td class="label" width='40%'>	
			
		<fmt:message key="eBL.NOTE.label" bundle="${bl_labels}"/></td> <!--added against MOHE-CRF-0039--> 
			
	
			<%}%>
		</TR>
		</table>
		<input type= hidden name="locale" id="locale"  id='locale' value="<%=locale%>">
		<input type= hidden name="facility_id" id="facility_id"  id='facility_id' value="<%=p_facility_id %>">		
		<input type= hidden name="patient_id1" id="patient_id1"  value=''>		
		<!--<input type= hidden name="demo_version" id="demo_version" id='demo_version' value=''> //removed demo_version against V210624-->
		<input type= hidden name="site_id" id="site_id" id='site_id' value='<%=site_id%>'>		
		
		<input type='hidden' name='total_records' id='total_records' value="">
		<input type='hidden' name='log_rep_success_mes' id='log_rep_success_mes' value=''>
		
		<input type="hidden" name="p_report_id" id="p_report_id"   id="p_report_id" value="<%= p_report_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id"    value="<%= p_module_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"	   value="<%= p_user_name %>">
		<input type="hidden" name="L_EPISODE_TYPE" id="L_EPISODE_TYPE"	   value="">
		<input type="hidden" name="L_REPORT_TYPE" id="L_REPORT_TYPE"	   value="">		
		<input type="hidden" name="L_PAYER" id="L_PAYER"	   value="">
		<input type="hidden" name="L_FROM_BILL_NO" id="L_FROM_BILL_NO"	   value="">
		<input type="hidden" name="L_TO_BILL_NO" id="L_TO_BILL_NO"	   value="">
		<input type="hidden" name="L_FR0M_BILL_DATE" id="L_FR0M_BILL_DATE"	   value="">		
		<input type="hidden" name="L_TO_BILL_DATE" id="L_TO_BILL_DATE"	   value="">	
		<input type="hidden" name="P_FACILITY_ID" id="P_FACILITY_ID"	   value="<%=p_facility_id %>">
		<input type="hidden" name="L_SERV_CLASS_YN" id="L_SERV_CLASS_YN"	   value="">
		
		<input type="hidden" name="p_session_id" id="p_session_id"	   value="">
		<input type="hidden" name="p_pgm_date" id="p_pgm_date"	   value="">
		<input type="hidden" name="p_pgm_id" id="p_pgm_id"	   value="">
		<input type='hidden' name='todaysDate' id='todaysDate' id='todaysDate' value='<%=todaysDate %>'>
		<input type='hidden' name='todaysDate30' id='todaysDate30' id='todaysDate30' value='<%=todaysDate30 %>'>
		<input type='hidden' name='site_spec' id='site_spec' id='site_spec' value="<%=siteSpec %>">
		<!--<input type="hidden" name="P_LANG_ID_LOC" id="P_LANG_ID_LOC"	   value='<%=locale %>'>-->
		<input type='hidden' name='strLoggedUser' id='strLoggedUser' id='strLoggedUser' value="<%=strLoggedUser %>"> <!-- Added V20180720-Subha/ML-MMOH-CRF-1173 -->
		<input type='hidden' name='siteSpecAuditReportYN' id='siteSpecAuditReportYN' id='siteSpecAuditReportYN' value="<%=siteSpecAuditReportYN %>"> <!-- Added V20180727-Subha/ML-MMOH-CRF-1173 -->
		<input type='hidden' name='site3TierAlmoFeatureYN' id='site3TierAlmoFeatureYN' id='site3TierAlmoFeatureYN' value='<%=site3TierAlmoFeatureYN %>'>			
	</FORM>		
	</BODY>
</HTML>

