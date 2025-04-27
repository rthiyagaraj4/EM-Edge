<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page   import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*,java.util.*,java.util.GregorianCalendar,java.util.Date,java.util.Calendar" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script>
function checkDateTo(){		 
	 var bool =  checkDateBL(document.forms[0].to_receipt_date);		
		if(!bool){		
			 $('#to_receipt_date').val($('#todaysDate').val());
			return false;
		}
		if($("#to_receipt_date").val()!=''){			
			var fromLesserThanCurrentDt=isBeforeNow($("#to_receipt_date").val(), 'DMY',$("#locale").val());		
		 	 var  lesserThanCurrentDt=isBeforeNow($("#from_receipt_date").val(), 'DMY',$("#locale").val());			 
			 var  toGrtThanFromDt= isAfter( $("#to_receipt_date").val(), $("#from_receipt_date").val(), 'DMY',$("#locale").val());
			 if(fromLesserThanCurrentDt == false){
				 alert("To Date Cannot be greater than Current Date");
				  $("#to_receipt_date").val($('#todaysDate').val());
			 }
			 else if(lesserThanCurrentDt==false){
			  alert("From Date Cannot be greater than Current Date");
			  $("#from_receipt_date").val($('#todaysDate').val());
			  }
			  else if(toGrtThanFromDt==false){
				if($("#to_receipt_date").val()!='' ){					
			 	 alert("To Date Cannot be lesser than From Date");
			  	$("#to_receipt_date").val($('#from_receipt_date').val());
			  }
			 }			 
			 }
}

function checkDateFrom(){

	var bool =  checkDateBL(document.forms[0].from_receipt_date);
	if(!bool){
		 $('#from_receipt_date').val($('#todaysDate').val());
		return false;
	}
	
	if($("#from_receipt_date").val()!=''){
		var fromLesserThanCurrentDt=isBeforeNow($("#to_receipt_date").val(), 'DMY',$("#locale").val());	
		var  lesserThanCurrentDt=isBeforeNow($("#to_receipt_date").val(), 'DMY',$("#locale").val());
		var  toGrtThanFromDt= isAfter( $("#to_receipt_date").val(), $("#from_receipt_date").val(), 'DMY',$("#locale").val());
		
		if(fromLesserThanCurrentDt == false){			
			alert("From Date Cannot be greater than Current Date");
			$("#from_receipt_date").val($('#todaysDate').val());
		}
		else if(lesserThanCurrentDt==false){
		  alert("To Date Cannot be greater than Current Date");
		  $("#to_receipt_date").val($('#todaysDate').val());
		  }
		  else if(toGrtThanFromDt==false){
				if( $("#from_receipt_date").val()!=''){
		 		 alert("From Date Cannot be greater than To Date");
				 $("#from_receipt_date").val($("#to_receipt_date").val());
				 }
		 }
		 
		 }
}
</script>
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
	Connection con2 = null;
	ResultSet rs1=null; ResultSet rs=null;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt1 = null ;
	String locale="";
	String p_facility_id="";
	String receipt_number="";
	String payer_type=""; 
	String patient_id1="";
	String receipt_number_code="";
	String payer=""; 
	String strPatientId="";
	String nursing_unit_code=""; String payer_code="";
	String p_module_id		= "BL" ;
	String p_report_id		= "BLRBLPRT" ;
	String p_user_name		= (String) session.getValue( "login_user" );
	String PatIDLen = "";
	String todaysDate= "";
	String todaysDate30 ="";
	Calendar cal = Calendar.getInstance();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	String customer_id=(String)session.getValue("CUSTOMER_ID");
	String strCustomerId="";
	//String sqldeptype="";
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	boolean site3TierAlmoFeature = false;
	try {
		con1	=	ConnectionManager.getConnection(request);
		site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","3TIERALMOFEATURE");
	} catch(Exception ex) {
		System.err.println("Error in BLReprintReportReceiptHdr.jsp for getting site3TierAlmoFeature Connection: "+ex);
		ex.printStackTrace();
	}finally{				
		if(con1!=null)
		 {
			ConnectionManager.returnConnection(con1, request);
		 }
	}
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	try{	
		HttpSession httpSession = request.getSession(false);
		con	=	ConnectionManager.getConnection(request);	
		locale	= (String)session.getAttribute("LOCALE");
		p_facility_id = (String)httpSession.getValue("facility_id");
		payer=request.getParameter("payer");
		if(payer==null || payer.equals("")) payer="";
		receipt_number=request.getParameter("receipt_number");
		if(receipt_number==null || receipt_number.equals("")) receipt_number="";
		receipt_number_code=request.getParameter("receipt_number_code");
		if(receipt_number_code==null || receipt_number_code.equals("")) receipt_number_code="";
		
		todaysDate = dateFormat.format(cal.getTime());	
		todaysDate30 = subtractDays(cal.getTime(),29);
		
		
		
		
	  }catch(Exception eX){	
		out.println("Error= "+eX);}

	try{
		
		String sqlsiteParam = "Select CUSTOMER_ID from SM_SITE_PARAM ";
		pstmt = con.prepareStatement(sqlsiteParam);		
		rs = pstmt.executeQuery();
		
		if(rs != null){			
			while(rs.next()){
				strCustomerId = rs.getString("CUSTOMER_ID");
				strCustomerId=strCustomerId==null?"":strCustomerId;
		
			}
		System.out.println("strCustomerId:::"+strCustomerId);
		}
		pstmt = null;
		rs = null;			

	}
	catch(Exception e)
	{
		System.out.println("Exception in getting CUSTOMER_ID"+e);
		e.printStackTrace();
	}
	

%>
	<HTML>
		<HEAD>
			<TITLE>
			 Receipt Maintenance
			</TITLE>	
<%
			String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
			<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>			
			<script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></script>
			<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
			<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
			<script language='javascript' src='../../eBL/js/BLReprintReportReceipt.js'></script>
			<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>	
			<script language="javascript" src="../../eBL/js/AutoFillSearchCriteria.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	<script>

	 $(document).ready(function()
	 {
		 $('#reset').click(function(){
        	 resetValues();
         });
		
		 $('#print_option').click(function(){
				$("#print_option option[value*='A']").prop('disabled',true);
				$("#print_option option[value*='B']").prop('disabled',true); 
			 });
		 
		  $('#episode_type').click(function(){
			 if($('#episode_type').val()=='I' || $('#episode_type').val()=='R')  {				 
				 $('#episode_id').val(''); 
				 $('#visit_id').val('');
				 $('#from_receipt_doc_type_code').val('');
				 $('#to_receipt_doc_type_code').val('');
				 $('#from_receipt_number').val('');
				 $('#to_receipt_number').val('');
				// $('#episode_id').prop('disabled', true);
				 $('#episode_idbut').prop('disabled', true);			 
			 }else{
				 $('#from_receipt_doc_type_code').val('');
				 $('#from_receipt_number').val('');
				 $('#to_receipt_number').val('');
				 $('#to_receipt_doc_type_code').val('');
				 $('#visit_id').prop('disabled', false);
				// $('#episode_id').prop('disabled', false); 
				 $('#episode_idbut').prop('disabled', false);	
			}
        });
		
	 });
    	
     /*
 		 if($('#episode_type').val()=='**' || $('#episode_type').val()=='R'){				 
			 $('#episode_id').val(''); 
			 $('#episode_id').prop('disabled', true);
			 $('#episode_idbut').prop('disabled', true);			 
		 }else{
			 $('#episode_id').prop('disabled', false); 
			 $('#episode_idbut').prop('disabled', false);	
		 }   */     
         		
     
			
	
	</script>
	</HEAD> 		
	<BODY onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  onSelect="codeArrestThruSelect();">
	<FORM name='BLReceiptReprint' id='BLReceiptReprint' method='' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<TABLE border='0' cellpadding='2' cellspacing='0' align='center' width='100%'>
	<tr>
	<td width='20%' class='COLUMNHEADER' nowrap colspan="8"><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"></fmt:message> 
    </td>
    </tr>
	<TR>
	<td width='10px'  class='label'><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>	
	<td width='10px'>
	<Select id="episode_type" name="episode_type" >
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
			<%  }out.println("short desc >> patClassShortDesc :"+patClassShortDesc.substring(0, 2)); %>
			<%
			}
			}catch(Exception e) {
				System.out.println("currency="+e.toString());
				}
			finally{
			rs.close(); 
			pstmt1.close();
			if(con!=null)
			 {
				ConnectionManager.returnConnection(con, request);
			}
			}
			%>
					  		
				
				<td width="10px" class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td width="10px" class='fields'>
				<input type="text" name="patient_id" id="patient_id" maxlength="<%=PatIDLen%>" size="12" 	onKeyPress="return CheckForSpecChars(event);lockbackSpace();" onblur="if(this.value!=''){ChangeUpperCase( this ); callPatValidation(this);defaultEncounter('patId');} "><input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="PatientIdLookup();defaultEncounter();"  tabindex='2' /></td>				
				<td width="10px" class="label" ><fmt:message key="eBL.episodeid.label" bundle="${bl_labels}"/></td>
		<td width="10px" class='fields'>
		<input type="text" name='episode_id' id='episode_id'   maxlength="12"  size="8"     onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
		<input type='hidden' name='hdnEpisode_id' id='hdnEpisode_id' ><class="label" width="1%"><fmt:message key="eBL.Slash.label" bundle="${bl_labels}"/>
		<input type="text" name='visit_id' id='visit_id'   maxlength="2"  onBlur="" size="6"   onKeyPress="" ><input type='button' class='button' name='episode_idbut' id='episode_idbut' value='?' onClick="episodeLookup(episode_id,hdnEpisode_id)"  tabindex='2' /></td>
		</tr>
	
		<tr>
				<td class="label" width="10px"><fmt:message key="eBL.DEPOSIT_TYPE.label"	bundle="${bl_labels}"/></td>
		<td width='10px' class="fields"  name="depTypebut"  tabindex='2'>
		<select name='depositeType' id='depositeType' onChange="">
		 <option value='**'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<%
			try{
				con2 = ConnectionManager.getConnection(request);	
				System.out.println("in try");
				String sqldeptype ="SELECT LIST_ELMT_VALUE,LIST_ELMT_LABEL FROM SM_LIST_ITEM WHERE MODULE_ID = 'BL' AND FUNCTION_ID = 'BL_CASHIER_OP_RCPT_RFND' AND LIST_REF ='BLTRECR1_DEPOSIT'";
				 pstmt1=con2.prepareStatement(sqldeptype);
				 rs=pstmt1.executeQuery();			
				System.out.println("RESULT SET :"+rs);	
				while(rs.next())
				{System.out.println("ffdfgd="+rs.getString("LIST_ELMT_VALUE"));
				%>
				<option value="<%= rs.getString("LIST_ELMT_VALUE")%>"><%=rs.getString("LIST_ELMT_LABEL")%></option>
					<%
				}
			}catch(Exception e) {
					System.out.println("currency="+e.toString());
					}
			finally{
				rs.close(); 
				pstmt1.close();
				if(con2!=null)
				 {
					ConnectionManager.returnConnection(con2, request);
				}
			} 
			
		%>
	<!--  <option value='**'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<option value='A'><fmt:message key="eBL.ADM_DEP.label" bundle="${bl_labels}"/></option>
		<option value='T'><fmt:message key="eBL.TRN_DEP.label" bundle="${bl_labels}"/></option>
		<option value='O'><fmt:message key="eBL.OTH_DEP.label" bundle="${bl_labels}"/></option>
		<option value='P'><fmt:message key="eBL.PKG_DEP.label" bundle="${bl_labels}"/></option>
		<option value='N'><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
		<option value='D'><fmt:message key="eBL.PAT_DEP_PKG.label" bundle="${bl_labels}"/></option>
		<option value='S'><fmt:message key="eBL.DEP_SRGY.label" bundle="${bl_labels}"/></option> -->
		
		</td>	
		<td class="label" width="10px"><fmt:message key="eBL.REC_NATURE.label" bundle="${bl_labels}"/></td>
		<td width='10px' class="fields"><input type='hidden' name='receipt_nature_code' id='receipt_nature_code' value='' id='receipt_nature_code' onBlur="">
		<input type='text' name='receipt_nature' id='receipt_nature' size='23' maxlength='22'  value='' onBlur="" ><input type='button' class='button' name="rec_nat" id="rec_nat"   value='?'  tabindex='0' onClick='ReceiptNatureLookup(document.forms[0].receipt_nature,document.forms[0].receipt_nature_code);'></td>
		
		<td class="label" width="10px"><fmt:message key="eBL.RECEIPT_TYPE.label"	bundle="${bl_labels}"/></td>	
		<td width='10px' class="fields"><input type= 'hidden' name='recpt_type_code' id='recpt_type_code' value='' id='recpt_type_code' onblur="">
		<input type='text' name='recpt_type' id='recpt_type' size='12' maxlength='22'  value=''  onBlur="" ><input type='button' class='button' name="rec_type" id="rec_type"   value='?'  tabindex='0' onClick='ReceiptTypeLookup(document.forms[0].recpt_type,document.forms[0].recpt_type_code);'></td>	 
		
		</tr>
		<tr>	
		<td width='10px' class='label'><fmt:message key="eBL.FromreceiptDate.label" bundle="${bl_labels}"/></td>
		<td width='10px' class="fields"><input type='text' name='from_receipt_date' id='from_receipt_date'   onBlur="checkDateFrom();" SIZE='12' maxlength='50' VALUE='<%=todaysDate30 %>'><img name='from_receipt_date_cal' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('from_receipt_date');"><img src='../../eCommon/images/mandatory.gif'></td>
		<td width="10px"  class='label'><fmt:message key="eBL.ToreceiptDate.label" bundle="${bl_labels}"/> </td>
		<td width='10px' class="fields"><input type='text' name='to_receipt_date' id='to_receipt_date'  onBlur="checkDateTo();" SIZE='12' maxlength='50'  VALUE='<%=todaysDate %>' ><img name='to_receipt_date_cal' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('to_receipt_date');" ><img src='../../eCommon/images/mandatory.gif'></td>	
		<td  class="label" width="10px"><fmt:message key="eBL.BILL_DOC_NUMBER.label" bundle="${bl_labels}"/></td>
		<td width='10px' class='fields'>
		<input type='text'  name="bill_doc_no" id="bill_doc_no" SIZE='8'  MAXLENGTH='22'	VALUE= ''  onBlur="if(this.value != '' ){ billNoLkup(this,document.forms[0].bill_doc_type,'Y') } else{ clearCode(bill_doc_type);}"  >		
		<class="label" width="1%"><fmt:message key="eBL.Slash.label" bundle="${bl_labels}"/>
		<input width="8%" type='text' name="bill_doc_type" id="bill_doc_type" size='6' maxlength='22' value=''  onBlur=""><input type='button' class='button' name="bill_doc_no_but" id="bill_doc_no_but"   value='?'  tabindex='0' onClick='billNoLkup(document.forms[0].bill_doc_no,document.forms[0].bill_doc_type)'></td>
		<tr>
		<td width="10px" class="label"><fmt:message key="eBL.Fromreceiptnumber.label" bundle="${bl_labels}"/></td>		
		<td width="10px" class='fields'>	
		<input type='text'  name="from_receipt_number" id="from_receipt_number" SIZE='8'  MAXLENGTH='50' VALUE="<%=receipt_number%>"  onBlur="if(this.value != '' ){ receiptNoLkup(this,document.forms[0].from_receipt_doc_type_code,'Y',1) } else{ clearCode(from_receipt_doc_type_code);}">			
		<class="label" width="1%"><fmt:message key="eBL.Slash.label" bundle="${bl_labels}"/>			
		<input type= 'text' name="from_receipt_doc_type_code" id="from_receipt_doc_type_code"  size='8' MAXLENGTH ='50' id='from_receipt_doc_type_code' VALUE="<%=receipt_number_code%>"   onBlur=""><input type='button' class='button' name="fromreceiptbut" id="fromreceiptbut" value='?' onClick='receiptNoLkup(document.forms[0].from_receipt_number,document.forms[0].from_receipt_doc_type_code,"",1)' ></td>
		<td width="10px" class="label"><fmt:message key="eBL.ToreceiptNumber.label" bundle="${bl_labels}"/></td>			
		<td width="10px" class='fields' >
		<input type='text'  name="to_receipt_number" id="to_receipt_number" SIZE="8"  MAXLENGTH='50'	VALUE="<%=receipt_number%>"  onBlur="if(this.value != '' ){ receiptNoLkup(this,document.forms[0].to_receipt_doc_type_code,'Y',2) } else{ clearCode(to_receipt_doc_type_code);}">				
		<class="label" width="1%"><fmt:message key="eBL.Slash.label" bundle="${bl_labels}"/>			
		<input type= 'text' name="to_receipt_doc_type_code" id="to_receipt_doc_type_code"  size='6' MAXLENGTH ='50'  VALUE="<%=receipt_number_code%>"  onBlur=""><input type='button' class='button' name="toreceiptbut" id="toreceiptbut" value='?' onClick='receiptNoLkup(document.forms[0].to_receipt_number,document.forms[0].to_receipt_doc_type_code,"",2)' ></td>
		<td class="label" width="10px"><fmt:message key="eBL.downtimereceiptno.label"	bundle="${bl_labels}"/></td>
		<td width='10px' class='fields'>
		<input type='text' name='downtimereceipt_number' id='downtimereceipt_number' size='8' maxlength='22'  value='' onBlur="" >		
		<class="label" width="1%"><fmt:message key="eBL.Slash.label" bundle="${bl_labels}"/>		
		<input type='text' name='downtimereceipt_number_code' id='downtimereceipt_number_code'  size='6' maxlength='22'  value='' onBlur=""><input type='button' class='button' name='downtimerec_number' id='downtimerec_number' id='downtimerec_number'  value='?'  tabindex='0' onClick='downtimeReceiptnoLookup(document.forms[0].downtimereceipt_number_code,document.forms[0].downtimereceipt_number);'></td>	  
		</tr>
		<tr>
		
		<td class="label" width="10px"><fmt:message key="eBL.Options.label"	bundle="${bl_labels}"/></td>
		<td width='10px' class="fields">		
		<select name='print_option' id='print_option' id='print_option' onChange="">	 	
		<option value='R'><fmt:message key="eBL.RECEIPT.label" bundle="${bl_labels}"/></option>
		<option value='A' <% if( customer_id.equals("ALMO") || site3TierAlmoFeature == true) { %> disabled<%} %>><fmt:message key="eBL.ACKNOWLEDGEMENT.label" bundle="${bl_labels}"/></option>
		<option value='B' <% if( customer_id.equals("ALMO") || site3TierAlmoFeature == true) { %> disabled<%} %>><fmt:message key="eBL.BOTH.label" bundle="${bl_labels}"/></option>
		</select>
		</td>
				
		
		<td class='label'width="10px"><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels }"></fmt:message></td>
		<td width='10px' class="fields">
		<input type='text' name='custGrpCode' id='custGrpCode' id='custGrpCode' size="8" value='' onblur="if(this.value!=''){ callCommonLookupCode(custGrpDesc,custGrpCode,1,1); } else{ fnClearCode(custGrpDesc); }">
		<input type='text' name='custGrpDesc' id='custGrpDesc' id='custGrpDesc' size="8" value='' onblur="if(this.value!=''){ callCommonLookupCode(custGrpDesc,custGrpCode,1,2); } else{ fnClearCode(custGrpCode); }"><input type='button' class='button' name="custGrpBtn" id="custGrpBtn" id='custGrpBtn' value='?' onClick="callCommonLookupCode(custGrpDesc,custGrpCode,1,2);" tabindex='2'></td>
				
		<td class='label'width="10px"><fmt:message key="eBL.Customer.label" bundle="${bl_labels }"></fmt:message></td>
		<td width='10px' class="fields">
		<input type='text' name='custCode' id='custCode' id='custCode' size="8" value='' onblur="if(this.value!=''){ callCommonLookupCode(custDesc,custCode,2,1,custGrpCode); } else{ fnClearCode(custDesc); }">
		<input type='text' name='custDesc' id='custDesc' id='custDesc' size="8" value='' onblur="if(this.value!=''){ callCommonLookupCode(custDesc,custCode,2,2,custGrpCode); } else{ fnClearCode(custCode); }"><input type='button' class='button' name="custBtn" id="custBtn" id='custBtn' value='?' onClick="callCommonLookupCode(custDesc,custCode,2,2,custGrpCode)" tabindex='2'></td>
		</tr>
<td>
</td>	
<td>
</td>
<td>
</td>	
<td>
</td>
<td>
</td>	

		<td  class="label" width='10px' ><input type='button' class='button' onclick='search();' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>"  name='search_but' >	
		<input type='button' class='button' onclick='resetSrchCriteria()' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>"  name='reset_but' >
		</td>
				</tr>
			
		</TR>
		</TABLE>
		<input type= hidden name="locale" id="locale"   value="<%=locale%>">
		<input type= hidden name="facility_id" id="facility_id"  value="<%=p_facility_id %>">		
		<input type= hidden name="patient_id1" id="patient_id1"  value=''>		
		<input type='hidden' name='total_records' id='total_records' value="">
		<input type='hidden' name='log_rep_success_mes' id='log_rep_success_mes' value=''>
		<input type="hidden" name="p_report_id" id="p_report_id"    value="<%= p_report_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id"    value="<%= p_module_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"	   value="<%= p_user_name %>">
		<input type="hidden" name="L_EPISODE_TYPE" id="L_EPISODE_TYPE"	   value="">
		<input type="hidden" name="L_REPORT_TYPE" id="L_REPORT_TYPE"	   value="">		
		<input type="hidden" name="L_SERV_CLASS_YN" id="L_SERV_CLASS_YN"	   value="">
		<input type="hidden" name="p_session_id" id="p_session_id"	   value="">
		<input type="hidden" name="p_pgm_date" id="p_pgm_date"	   value="">
		<input type="hidden" name="p_pgm_id" id="p_pgm_id"	   value="">
		<input type='hidden' name='todaysDate' id='todaysDate' value='<%=todaysDate %>'>		
		</FORM>
		</BODY>
</HTML>		 

