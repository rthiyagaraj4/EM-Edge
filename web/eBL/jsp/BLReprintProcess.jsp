<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
---------------------------------------------------------------------------------------------
1            V210104             11948          NMC-JD-SCF-0127-TF          Mohana Priya K
2            V210129             13523          MOHE-CRF-0060       		Shikha Seth
3            V210624             17147     		PMG2021-COMN-CRF-0077		MuthkumarN
4	         V221107								TH-KW-CRF-0174  		Mohana Priya K
-->
<%@ page  import="eBL.*,eBL.Common.*,java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*,java.text.*,eBL.BLReportIdMapper" 			contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 

<%!
private String checkForNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}

public String billingFormatConverter(Connection con, String amount) {
	//Karthik added here
	PreparedStatement pstmt_dec = null;
	ResultSet rs_dec = null;
	int noofdecimal = 2;

	try {
		
		pstmt_dec = con.prepareStatement(" select nvl(no_of_decimal,2) from  sm_acc_entity_param where acc_entity_id='ZZ'");
		rs_dec = pstmt_dec.executeQuery();
		if (rs_dec.next() && rs_dec != null)
			noofdecimal = rs_dec.getInt(1);

		if (rs_dec != null)
			rs_dec.close();
		if (pstmt_dec != null)
			pstmt_dec.close();			

		if (amount == null || "".equals(amount)) {
			amount = "0.00";
		} else {
			CurrencyFormat cf = new CurrencyFormat();
			amount = cf.formatCurrency(amount, noofdecimal);
		}

	} catch (Exception e) {
		System.out.println("Exception Getting Number of Decimals. " + e.toString());
	}
	return amount;
} 

%>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	Connection con1 = null;
	PreparedStatement pstmt = null ;
	Statement stmt1				= null;
	ResultSet rs1 = null;
	Statement stmt2				= null;
	ResultSet rs2 = null;
	
	ResultSet rscurr=null;
	String locale="";	

	String classval="";
	int total_records=0;
	
	String p_facility_id="";
	String p_from_bill_number_code="";
	String p_to_bill_number_code="";
	String p_from_bill_number="";	
	String p_to_bill_number=""; 
	String p_from_bill_date="";
	String p_to_bill_date="";
	String p_payer_code="";	
	String p_episode_type="";	
	String p_bill_type="";
	String p_outstd_only = "";
	String p_cust_code = "";
	
	String strRowId="";
	String strDocTypCode="";
	String strDocNum="";	
	String strDocDate="";
	String strBillTotAmt="";
	String strPatientId="";
	String strBillNatCode="";
	String strBillingGroupId="";
	String strCustCode="";
	String strepisodeTyp="";
	String strepisodeId="";
	String strVisitId="";
	String strBillPrintFlag="";
	String patientId="";
	String episodeId = "";
	String visitId = "";
	String billPaidAmt = "";
	String totOutAmt = "";
	String site_id="";
	String excemptedAmt="";
	String drugPenalty="";
	int noofdecimal=2;
	int doc_amt=0;
	//For Traversal
	int constCount = 50;
	String nextYn = "N";
	String prevYn = "N";
	String traversal = "N";
	String fromRcrd = "";
	String toRcrd = "";
	int startIndex = 0;
	int startRcrd = 0;
	int endRcrd = 0;
	int totalRecord=0;
	String amt="";
	String amt1="";

	String mpi_id="";//V221107
	String setlmt_ind = "";//V221107
	String insBillAmt=""; //V221107
	String eSignYN ="";
	String payer_group="";
	String payer_type="";
	//String demo_version="";//Commented against V210622
	String zerobill="";
	String strOperatingFacilityId=""; //V210129
	fromRcrd = checkForNull(request.getParameter("fromRcrd"));
	toRcrd = checkForNull(request.getParameter("toRcrd"));
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	Connection con2 = null;		
	boolean site3TierAlmoFeature = false;
	String site3TierAlmoFeatureYN = "";
	try {
		con2	=	ConnectionManager.getConnection(request);
		site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con2, "BL","3TIERALMOFEATURE");
		if (site3TierAlmoFeature) {
			site3TierAlmoFeatureYN = "Y";
		}else {
			site3TierAlmoFeatureYN = "N";
		}
	} catch(Exception ex) {
		System.err.println("Error in BLReprintProcess.jsp for getting site3TierAlmoFeature Connection: "+ex);
		ex.printStackTrace();
	}finally{
			if(con2!=null) {
				ConnectionManager.returnConnection(con2, request);
			}
		}
		
	
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	if(fromRcrd == null || "".equals(fromRcrd)){
		startRcrd = 1;
	}
	else{
		startRcrd = Integer.parseInt(fromRcrd);
	}
		
	if(toRcrd == null || "".equals(toRcrd)){
		endRcrd = constCount;
	}
	else{
		endRcrd = Integer.parseInt(toRcrd);
	}
	startIndex = startRcrd;

	//For Traversal
	
	boolean searched = (request.getParameter("searched") == null) ?false:true;	
	
	try
	{	
		HttpSession httpSession = request.getSession(false);		
		
		con	=	ConnectionManager.getConnection(request);
			
		locale	= (String)session.getAttribute("LOCALE");
		p_facility_id = (String)httpSession.getValue("facility_id");
		eSignYN = BLReportIdMapper.eSignatureFlag(p_facility_id); //V221107
		if(eSignYN == null) eSignYN = "N";
		System.err.println("eSignYN "+eSignYN);
		
		p_from_bill_number_code=request.getParameter("from_bill_number_code");
		if(p_from_bill_number_code==null || p_from_bill_number_code.equals("")) p_from_bill_number_code="";		
		p_to_bill_number_code=request.getParameter("to_bill_number_code");
		if(p_to_bill_number_code==null || p_to_bill_number_code.equals("")) p_to_bill_number_code="";
		p_from_bill_number=request.getParameter("from_bill_number");
		if(p_from_bill_number==null || p_from_bill_number.equals("")) p_from_bill_number="";
		p_to_bill_number=request.getParameter("to_bill_number");
		if(p_to_bill_number==null || p_to_bill_number.equals("")) p_to_bill_number="";
		p_from_bill_date=request.getParameter("from_bill_date");
		if(p_from_bill_date==null || p_from_bill_date.equals("")) p_from_bill_date="";
		p_to_bill_date=request.getParameter("to_bill_date");
		if(p_to_bill_date==null || p_to_bill_date.equals("")) p_to_bill_date="";
		p_payer_code=request.getParameter("payer_code");
		if(p_payer_code==null || p_payer_code.equals("")) p_payer_code="";		
		p_episode_type=request.getParameter("episode_type");
		if(p_episode_type==null) p_episode_type="";
		p_bill_type=request.getParameter("bill_type");
		if(p_bill_type==null) p_bill_type="";
		payer_group=request.getParameter("payer_group");
		if(payer_group==null) payer_group="";
		
		payer_type=request.getParameter("payer_type");
		if(payer_type==null) payer_type="";
		
		zerobill=request.getParameter("zerobill");
		if(zerobill==null) zerobill="";
		
		
		p_cust_code=request.getParameter("cust_code");
		if(p_cust_code==null) p_cust_code="";


		patientId = checkForNull(request.getParameter("patientId"));
		episodeId = checkForNull(request.getParameter("episodeId"));
		visitId = checkForNull(request.getParameter("visitId"));
		p_outstd_only = checkForNull(request.getParameter("outStdOnly"));

		
		System.out.println("p_payer_code/p_episode_type/p_bill_type>>>>>>>>>>>" +p_payer_code+"/"+p_episode_type+"/"+p_bill_type);
		
		String site_id_sql = "select customer_id from sm_site_param ";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(site_id_sql);	

			if(rs.next())
			{
			   site_id  =  rs.getString(1);	
			}

		if(rs!=null)   rs.close();
		if(stmt!=null) stmt.close();		
	}
	catch(Exception eX)
	{	
		//out.println("Error= "+eX);
		eX.printStackTrace();			
	}

	/* Commented against V210622
	try{ 
		con1	=	ConnectionManager.getConnection(request);	
		//String demo_identifier_sql = "select demo_version from bl_parameters where operating_facility_id = 'QF' ";

		String demo_identifier_sql = "select demo_version from bl_parameters where operating_facility_id = '"+p_facility_id+"' ";//MOHE-SCF-0016

		Statement stmt2 = con1.createStatement();
		ResultSet rs2 = stmt2.executeQuery(demo_identifier_sql);	

		if(rs2.next())
		{
			demo_version  =  rs2.getString(1);	
			System.err.println("BLReprint Process demo_identifier" +demo_version);
		}

			if(rs2!=null)   rs2.close();
			if(stmt2!=null) stmt2.close();	
		}
		catch(Exception eX)
		{	
			out.println("Error 1= "+eX);			
		}
		finally
		{
			if(con1!=null) 
			{
			ConnectionManager.returnConnection(con1, request);
			}
		}*/
	
	try
	{		
		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
		rscurr = pstmt.executeQuery();	
		while(rscurr.next())
		{
			noofdecimal  =  rscurr.getInt(1);		
		}		
		}
		catch(Exception e)
		{    e.printStackTrace();
			System.out.println("3="+e.toString());
		}
	finally
	{
		if (rscurr != null)   rscurr.close();
		if (pstmt != null) pstmt.close();		
	}

%>
<HTML>
	<HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
		<script language='javascript' src='../../eBL/js/BLReprintReport.js'></script>
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<script language='javascript' src='../../eBL/js/json2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		<script>
		$(document).ready(function(event){
			$("input[type='text']").keydown(function(e){
				if (e.which === 8 && !$(e.target).is("input[type='text']:not([readonly])")) {
					e.preventDefault();
			    }
			});
			
			if($('#traverse').val() == 'Y'){
				$('#trProgress').show();
			}else{
				$('#trProgress').hide();
			}
			
			if($('#hdnNextSpan').val() == 'Y'){
				$('#nextSpan').show();
			}else{
				$('#nextSpan').hide();
			}
				
			if($('#prevSpan').val() == 'Y'){
				$('#previousSpan').show();
			}else{
				$('#previousSpan').hide();
			}
				
				
				
			$('#nextSpan').click(function(){
				var startFrom = parseInt($('#fromRcrd').val())+parseInt($('#constCount').val());
				var endWith = parseInt($('#toRcrd').val())+parseInt($('#constCount').val());
				document.location.href = "BLReprintProcess.jsp?from_bill_number_code="+$('#hdnBillDocFrom').val()+
										"&to_bill_number_code="+$('#hdnBillDocTo').val()+
										"&from_bill_number="+$('#hdnBillNoFrom').val()+
										"&to_bill_number="+$('#hdnBillNoTo').val()+
										"&from_bill_date="+$('#hdnBillDateFrom').val()+
										"&to_bill_date="+$('#hdnBillDateTo').val()+
										"&episode_type="+$('#hdnEpisodeType').val()+
										"&bill_type="+$('#hdnBillType').val()+
										"&patientId="+$('#hdnPatientId').val()+
										"&episodeId="+$('#hdnEpisodeId').val()+
										"&visitId="+$('#hdnVisitId').val()+
										"&outStdOnly="+$('#hdnOutStd').val()+
										"&cust_code="+$('#hdncustCode').val()+ 	
										"&fromRcrd="+startFrom+
										"&toRcrd="+endWith+
										"&payer_group="+$('#payer_group').val()+
										"&payer_type="+$('#payer_type').val()+
										"&zerobill="+$('#zerobill').val();
			});
			$('#previousSpan').click(function(){
				var startFrom = parseInt($('#fromRcrd').val())-parseInt($('#constCount').val());
				var endWith = parseInt($('#toRcrd').val())-parseInt($('#constCount').val());
				document.location.href = "BLReprintProcess.jsp?from_bill_number_code="+$('#hdnBillDocFrom').val()+
										"&to_bill_number_code="+$('#hdnBillDocTo').val()+
										"&from_bill_number="+$('#hdnBillNoFrom').val()+
										"&to_bill_number="+$('#hdnBillNoTo').val()+
										"&from_bill_date="+$('#hdnBillDateFrom').val()+
										"&to_bill_date="+$('#hdnBillDateTo').val()+
										"&episode_type="+$('#hdnEpisodeType').val()+
										"&bill_type="+$('#hdnBillType').val()+
										"&patientId="+$('#hdnPatientId').val()+
										"&episodeId="+$('#hdnEpisodeId').val()+
										"&visitId="+$('#hdnVisitId').val()+
										"&outStdOnly="+$('#hdnOutStd').val()+
										"&cust_code="+$('#hdncustCode').val()+ 	
										"&fromRcrd="+startFrom+
										"&toRcrd="+endWith+
										"&payer_group="+$('#payer_group').val()+
										"&payer_type="+$('#payer_type').val()+
										"&zerobill="+$('#zerobill').val();

			});
			//ENM-2558 - MMS-QH-CRF-0163 Karthik added for Select All Case
	
			$('#selectAll').click(function(){
				
			var patId=$('#hdnPatientId').val();
			var site_id = $('#site_id').val();
			//var demo_version =  $('#demo_version').val();//Commented against V210622
			var index = $('#tbl tr').length;
			
			var selectedFrameDoc = parent.selectedFrame.document;
			var index2 = $(selectedFrameDoc).find('#indexTrack').val();
			var trlast = $(parent.selectedFrame.document).find('#tblSelectedReport tr:last');
			var lastIndex =  $(selectedFrameDoc).find('#indexTrack').val(); 
			var index1= $('#tblSelectedReport tr').length;
			var site3TierAlmoFeatureYN=$('#site3TierAlmoFeatureYN').val();//V210104

			if (lastIndex == 'undefined' || lastIndex == undefined) {lastIndex= 0;}
			var limitexc = (parseInt(index2)+(parseInt(index)-2));
			var chkBill='';
			chkBill=parent.search_hdr.document.BLReprintReport.consolidatedBillSettlement.checked;
			
			if(chkBill == true){
				
				$(parent.buttonFrame.document).find("#btnSettlement").show();
				$(parent.buttonFrame.document).find("#btnCancel").hide();
				$(parent.buttonFrame.document).find("#btnReprint").hide();
				$(parent.buttonFrame.document).find("#report_type").hide();
				$(parent.buttonFrame.document).find("#payer_type").hide();
				
			}
			else{
				
				$(parent.buttonFrame.document).find("#btnSettlement").hide();
				$(parent.buttonFrame.document).find("#btnCancel").show();
				$(parent.buttonFrame.document).find("#btnReprint").show();
				$(parent.buttonFrame.document).find("#report_type").show();
				$(parent.buttonFrame.document).find("#payer_type").show();
			}
				
					
			//if((site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y')&& demo_version == 'Y'){ //Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
			if((site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y')){//removed demo_version against V210603
			if(parent.search_hdr.document.BLReprintReport.consolidatedBillSettlement.checked==true)
			{
				
			if(patId == ""){ return;}
			}
			if(lastIndex>=50) 
			{
				alert("Already 50 rows got selected Can't proceed");
				//if((site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y') && demo_version == 'Y') //Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
				if((site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y'))
				{//removed demo_version against V210603					
					if(chkBill == true)
					{						
						$(selectedFrameDoc).find('[id^=rem_slmt_amt]').each(function(){
							$(this).prop('disabled',false);
						});
						
						$(selectedFrameDoc).find('[id^=bill_print_yn]').each(function(){
							$(this).prop('disabled',false);
						});
						
						$(parent.buttonFrame.document).find("#btnSettlement").show();
						$(parent.buttonFrame.document).find("#btnCancel").hide();
						$(parent.buttonFrame.document).find("#btnReprint").hide();
						$(parent.buttonFrame.document).find("#report_type").hide();
						$(parent.buttonFrame.document).find("#payer_type").hide();
						
					}
					else{
						
						$(selectedFrameDoc).find('[id^=rem_slmt_amt]').each(function(){
							$(this).prop('disabled',true);
						});
						
						$(selectedFrameDoc).find('[id^=bill_print_yn]').each(function(){
							$(this).prop('disabled',true);
						});
						
						$(parent.buttonFrame.document).find("#btnSettlement").hide();
						$(parent.buttonFrame.document).find("#btnCancel").show();
						$(parent.buttonFrame.document).find("#btnReprint").show();
						$(parent.buttonFrame.document).find("#report_type").show();
						$(parent.buttonFrame.document).find("#payer_type").show();
					}
				}
				resetFlag();
				return false;			
			} 			 
			}				 
			for (all = 1; all < (index-1); all++) {							
					moveData(all,true,false,1);			
			}
									
			//if((site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y') && demo_version == 'Y'){ //Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
			if((site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y')){ //removed demo_version against V210603
				if(chkBill == true){
					$(selectedFrameDoc).find('[id^=rem_slmt_amt]').each(function(){
						$(this).prop('disabled',false);
					});
					
					$(selectedFrameDoc).find('[id^=bill_print_yn]').each(function(){
						$(this).prop('disabled',false);
					});
					
					$(parent.buttonFrame.document).find("#btnSettlement").show();
					$(parent.buttonFrame.document).find("#btnCancel").hide();
					$(parent.buttonFrame.document).find("#btnReprint").hide();
					
				}
				else{
					$(selectedFrameDoc).find('[id^=rem_slmt_amt]').each(function(){
						$(this).prop('disabled',true);
					});
					
					$(selectedFrameDoc).find('[id^=bill_print_yn]').each(function(){
						$(this).prop('disabled',true);
					});
					
					$(parent.buttonFrame.document).find("#btnSettlement").hide();
					$(parent.buttonFrame.document).find("#btnCancel").show();
					$(parent.buttonFrame.document).find("#btnReprint").show();
				}
			}
			resetFlag();		
	});
});
</script>
<style>
div.tableContainer {
	width: 100%;		/* table width will be 99% of this*/
	height: 160px; 	/* must be greater than tbody*/
	overflow: auto;
	margin: 0 auto;
}

table {
	width: 100%;		/*100% of container produces horiz. scroll in Mozilla*/
	border: none;
	background-color: #f7f7f7;
	}
	
table>tbody	{  /* child selector syntax which IE6 and older do not support*/
	overflow: auto; 
	height: 120x;
	overflow-x: hidden;
	}
	
thead tr	{
	position:relative; 
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
	}
		
		div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 140px; 	/* must be greater than tbody*/
		overflow: scroll;
		margin: 0 auto;
	}	
		TD.YELLOW 
		{			
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
		}
		
		.LocalYellow
		{
			COLOR:#444444;
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border: 1x;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
			/* PADDING-LEFT:7px;
  			PADDING-RIGHT:7px */
		}
SPAN.LABEL
{
  COLOR:#444444;
  /*background-color:#FFFFFF;*/
  background-color:#FFFFFF;
  FONT-SIZE: 8pt;
  TEXT-ALIGN: LEFT;
  /*TEXT-ALIGN: RIGHT;*/
  /* PADDING-LEFT:7px;
  PADDING-RIGHT:7px */
}
SPAN.SpanYellow
		{
			COLOR:#444444;
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			/* PADDING-LEFT:7px;
  			PADDING-RIGHT:7px */
		}
	

		</style>
	</HEAD> 

	<script>
		function selected(i)
		{				
			var selected_row=eval(document.forms[0].selected_row+i);		
			if(selected_row.checked==false)
			{	
			selected_row.checked=false;
			document.resultForm.checked_row.value="";				
			}
			else
			{					
				var total_records=document.forms[0].total_records.value;					
				for(var j=0;j<total_records;j++)
				{ 
					var temp=eval(document.resultForm.selected_row+j);					
					temp.checked=false;
		        }
			selected_row.checked=true;				
			document.forms[0].checked_row.value=i;
			}
			if(selected_row.checked)
			{
			  selected_row.value="1";	
			}
			else
			{
				selected_row.value="1";	
			}
		}	
		
		function no_record_check()
		{			
			//alert("no records check");
			//parent.dummy_frame.location.href='../../eCommon/html/blank.html';
 			var total_records=document.forms[0].total_records.value;
			if(total_records==0)
			{
				setTimeout(function(){ alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common")); }, 100);
				$("#tableContainer").html("");
				//parent.frames[1].document.forms[0].submit_but.disabled=true;
				parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=&err_value=";

			}
			parent.search_hdr.document.forms[0].total_records.value=total_records;
			
		}

		function assign_value()
		{
			parent.search_hdr.document.forms[0].group_by.value = document.forms[0].group_by.value;
		}

	</script>
	<body onLoad="no_record_check();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	onSelect="codeArrestThruSelect();">
	<form name='resultForm' id='resultForm'> 
	
<%
		try
		{		
			/*String query_refresh=
					"SELECT rownum rnum,doc_type_code, doc_num, to_char(doc_date,'dd/mm/yyyy hh24:mi') doc_date, bill_tot_amt, patient_id,bill_nature_code,"+
					 " blng_grp_id, cust_code, episode_type, episode_id,visit_id, bill_print_flag,bill_paid_amt,bill_tot_outst_amt,operating_facility_id "+ //V210129 
					 " FROM bl_bill_hdr "+
					 " WHERE "+
					 " doc_type_code BETWEEN NVL ('"+p_from_bill_number_code+"', '!!!!!!' ) AND NVL ('"+p_to_bill_number_code+"', '~~~~~~') "+
					 " AND 	doc_num BETWEEN NVL ('"+p_from_bill_number+"', 0) AND NVL ('"+p_to_bill_number+"', 99999999) "+					  
					 " AND TRUNC (doc_date) BETWEEN NVL ( TO_DATE ('"+p_from_bill_date+"', 'dd/mm/yyyy'), TO_DATE ('01/01/1900', 'dd/mm/yyyy')) "+					 
					 " AND NVL ( TO_DATE ('"+p_to_bill_date+"', 'dd/mm/yyyy'), TO_DATE ('31/12/4000', 'dd/mm/yyyy')) "+					
					 " AND NVL (bill_status, '$') <> 'C' "+
					 " and (('"+payer_group+"' is not null and cust_group_code = '"+payer_group+"') or '"+payer_group+"' is null) "+  					      
  					" and (('"+payer_type+"' ='C'  "+
  					" and cust_code is null)  "+
 					" or ('"+payer_type+"' ='R'  "+
 				  " and cust_code is not null) "+
 				  "  or ('"+payer_type+"' ='B' )) "+
 				 " and (('"+zerobill+"' = 'I') "+
 				 " or ('"+zerobill+"' = 'E' and bill_tot_amt <> 0)) "; */ //Commented V221107

			String query_refresh=
					"SELECT rownum rnum,doc_type_code, doc_num, to_char(doc_date,'dd/mm/yyyy hh24:mi') doc_date, bill_tot_amt, patient_id,bill_nature_code,"+
					 "a.blng_grp_id blng_grp_id, a.cust_code, episode_type, episode_id,visit_id, bill_print_flag,bill_paid_amt,bill_tot_outst_amt,operating_facility_id,MPI_ID,bill_amt,b.settlement_ind setlmt_ind"+ //V210129 
					 " FROM bl_bill_hdr a,bl_blng_grp b"+
					 " WHERE "+
					 " doc_type_code BETWEEN NVL ('"+p_from_bill_number_code+"', '!!!!!!' ) AND NVL ('"+p_to_bill_number_code+"', '~~~~~~') "+
					 " AND 	doc_num BETWEEN NVL ('"+p_from_bill_number+"', 0) AND NVL ('"+p_to_bill_number+"', 99999999) "+					  
					 " AND TRUNC (doc_date) BETWEEN NVL ( TO_DATE ('"+p_from_bill_date+"', 'dd/mm/yyyy'), TO_DATE ('01/01/1900', 'dd/mm/yyyy')) "+					 
					 " AND NVL ( TO_DATE ('"+p_to_bill_date+"', 'dd/mm/yyyy'), TO_DATE ('31/12/4000', 'dd/mm/yyyy')) "+					
					 " AND NVL (bill_status, '$') <> 'C' "+
					 " and (('"+payer_group+"' is not null and cust_group_code = '"+payer_group+"') or '"+payer_group+"' is null) "+  					      
  					" and (('"+payer_type+"' ='C'  "+
  					" and a.cust_code is null)  "+
 					" or ('"+payer_type+"' ='R'  "+
 				  " and a.cust_code is not null) "+
 				  "  or ('"+payer_type+"' ='B' )) "+
 				 " and (('"+zerobill+"' = 'I') "+
 				 " or ('"+zerobill+"' = 'E' and bill_tot_amt <> 0)) and a.blng_grp_id =b.blng_grp_id  "; //V221107 174 changes

			
					 String queryCount = 
					"SELECT count(*) total "+
							 " FROM bl_bill_hdr "+
							 " WHERE "+
							 " doc_type_code BETWEEN NVL ('"+p_from_bill_number_code+"', '!!!!!!' ) AND NVL ('"+p_to_bill_number_code+"', '~~~~~~') "+
							 " AND 	doc_num BETWEEN NVL ('"+p_from_bill_number+"', 0) AND NVL ('"+p_to_bill_number+"', 99999999) "+					  
							 " AND TRUNC (doc_date) BETWEEN NVL ( TO_DATE ('"+p_from_bill_date+"', 'dd/mm/yyyy'), TO_DATE ('01/01/1900', 'dd/mm/yyyy')) "+					 
							 " AND NVL ( TO_DATE ('"+p_to_bill_date+"', 'dd/mm/yyyy'), TO_DATE ('31/12/4000', 'dd/mm/yyyy')) "+					
							 " AND NVL (bill_status, '$') <> 'C' "+
							 " and (('"+payer_group+"' is not null and cust_group_code = '"+payer_group+"') or '"+payer_group+"' is null) "+  					      
			  					" and (('"+payer_type+"' ='C'  "+
			  					" and cust_code is null)  "+
			 					" or ('"+payer_type+"' ='R'  "+
			 				  " and cust_code is not null) "+
			 				  "  or ('"+payer_type+"' ='B' )) "+
			 				 " and (('"+zerobill+"' = 'I') "+
			 				 " or ('"+zerobill+"' = 'E' and bill_tot_amt <> 0)) ";
		
							 
							 String whereClause = "";
					if(!"".equals(patientId)){
						whereClause = whereClause + " AND PATIENT_ID = '"+patientId+"' ";
					}
					
					if(!"".equals(episodeId)){
						whereClause = whereClause + " AND EPISODE_ID = '"+episodeId+"' ";
					}
					
					if(!"".equals(visitId)){
						whereClause = whereClause + " AND VISIT_ID = '"+visitId+"' ";
					}
					
					if(!"**".equals(p_episode_type)){
						whereClause = whereClause + " AND episode_type = '"+p_episode_type+"' ";
					}
					
					if(! ("**".equals(p_bill_type) || "E".equals(p_bill_type) )){
						whereClause = whereClause +  " AND bill_trx_type_code = '"+p_bill_type+"' ";
						whereClause = whereClause +  " AND episode_id is not null ";
					}
					
					if("E".equals(p_bill_type)){
						whereClause = whereClause + 	" AND episode_type ='R' ";
					} 
					
						
				if(! ("".equals(p_cust_code)) ){
						//whereClause = whereClause +  " AND CUST_CODE = '"+p_cust_code+"' ";
						whereClause = whereClause +  " AND CUST_CODE = (DECODE('"+p_cust_code+"','**',cust_code,'"+p_cust_code+"')) ";
					}

					if("Y".equals(p_outstd_only)){
						whereClause = whereClause +  " AND bill_tot_outst_amt <> 0 ";
					}		 
				/*	 " AND bill_trx_type_code = 'D' "+
					 " AND "+
					 " ((cust_code = '"+p_payer_code+"' OR (cust_code IS NULL AND rev_cust_code = '"+p_payer_code+"'))) ";*/			
			
			String orderBy=" order by doc_type_code,doc_num ";
			query_refresh  = "Select * from ("+query_refresh + whereClause +") where rnum between "+startRcrd +" and "+endRcrd + orderBy ;
					 
			queryCount  = queryCount + whereClause;
			pstmt = con.prepareStatement(queryCount);
			rs1 = pstmt.executeQuery();
			if(rs1 != null && rs1.next()){
				totalRecord = rs1.getInt("total");
			}
			if(startRcrd>1){
				prevYn = "Y";
				traversal = "Y";
			}
			
			if((startRcrd+constCount) <= totalRecord){
				nextYn = "Y";
				traversal = "Y";
			}	

			/*HashMap sqlMap = new HashMap();

			sqlMap.put("sqlData",query_refresh);
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			
		//	displayFields.add("ROW_ID");	
			displayFields.add("DOC_TYPE_CODE");	
			displayFields.add("DOC_NUM");	
			displayFields.add("DOC_DATE");	
			displayFields.add("BILL_TOT_AMT");	
			displayFields.add("PATIENT_ID");	
			displayFields.add("BILL_NATURE_CODE");	
			displayFields.add("BLNG_GRP_ID");	
			displayFields.add("CUST_CODE");	
			displayFields.add("EPISODE_TYPE");	
			displayFields.add("EPISODE_ID");
			displayFields.add("VISIT_ID");	
			displayFields.add("BILL_PRINT_FLAG");					
			displayFields.add("BILL_PAID_AMT");	
			displayFields.add("BILL_TOT_OUTST_AMT");	
			// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			System.out.println("result==>"+result);*/
		
			pstmt = null;
			rs1 = null;
			
			pstmt = con.prepareStatement(query_refresh);
			rs1= pstmt.executeQuery();
%>

		<div id="tableContainer">
			<table border='' cellpadding='3' cellspacing='0'  id='tbl' >	
			<thead>
			<tr style="background-color: white; border: none;" id='trProgress'>
			<% //Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
			//if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN)) && ("Y".equals(demo_version))){
			if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN))) { //removed demo_version against V210603
		%>
			<td colspan='13' nowrap="nowrap">
			<%}
			else{%>
			<td colspan='11' nowrap="nowrap">
			<%} %>
				&nbsp;
			</td>
					<td colspan='1' nowrap="nowrap">
						<span class="LABEL" style="font-weight: normal; color: blue; cursor: pointer;cursor:pointer ">
							<span id='previousSpan'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></span>
						</span>
					</td>
					<td colspan='1' nowrap="nowrap">
						<span class="LABEL" style="font-weight: normal; color: blue; cursor: pointer;cursor:pointer ">
							<span id='nextSpan'><fmt:message key="Common.next.label" bundle="${common_labels}"/></span>
						</span>
					</td>
				</tr>
			<tr style="position: sticky;z-index: 1;top: 0;">
<!-- 					ENM-2558 - MMS-QH-CRF-0163 Karthik Added isForALL attribute to skip alert in Select All Case 	-->
				<td class='COLUMNHEADER' width='5%'><div id='selectAll'><span style="color: blue; font-size: 12px;cursor:pointer ">(+)</span><fmt:message key="Common.selectall.label" bundle="${common_labels}"/></div></td>
				<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='11%'><fmt:message key="Common.DocumentNumber.label" bundle="${common_labels}"/></td>					
				<td class='COLUMNHEADER' width='12%' style="white-space: nowrap"><fmt:message key="Common.DocumentDate.label" bundle="${common_labels}" /></td>	
				<td class='COLUMNHEADER' width='11%' style="white-space: nowrap"><fmt:message key="eBL.BILLED_AMT.label" bundle="${bl_labels}"/></td>		
				
				<td class='COLUMNHEADER' width='11%'style="white-space: nowrap"><fmt:message key="eBL.BillPaidAmt.label" bundle="${bl_labels}"/></td>	
				<td class='COLUMNHEADER' width='11%'style="white-space: nowrap"><fmt:message key="eBL.BillOutStdAmt.label" bundle="${bl_labels}"/></td>			
				
				
				<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>	
<!-- 				Karthik Commented to Remove Billing class code -->
<%-- 				<td class='COLUMNHEADER' width='6%'><fmt:message key="eBL.Bill_CLASS_CODE.label" bundle="${common_labels}"/> </td>			 --%>
				<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='8%' style="white-space: nowrap"><fmt:message key="eBL.PAYER_CODE.label" bundle="${bl_labels}"/> </td>	
				<td class='COLUMNHEADER' width='6%'><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='6%'><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='6%'><fmt:message key="Common.VisitID.label" bundle="${common_labels}"/></td>
		<% 
			//Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
			//if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN)) && ("Y".equals(demo_version))){
			if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN))) { //removed demo_version against V210603
		%>
			<td class='COLUMNHEADER' width='8%'><fmt:message key="eBL.Exempted_Amount.label" bundle="${bl_labels}"/></td>
				<!--added against MOHE-CRF-0039--> 			
				<td class='COLUMNHEADER' width='8%'><fmt:message key="eBL.DrugPenalty.label" bundle="${bl_labels}"/></td> <!--added against MOHE-CRF-0039-->	
				<%} %>	
		
			</tr>
			</thead>
			<tbody>
<%				int i=1;	
	if(rs1 != null){
		while(rs1.next()){
			classval = "label";
			DecimalFormat df = new DecimalFormat("0.00");
			strDocTypCode=  checkForNull(rs1.getString("doc_type_code"));
			strDocNum=checkForNull(rs1.getString("doc_num"));
			strDocDate=checkForNull(rs1.getString("doc_date"));
			
			strBillTotAmt=billingFormatConverter(con,checkForNull(rs1.getString("bill_tot_amt")));
			
			
			strPatientId=checkForNull(rs1.getString("patient_id"));
			System.err.println("strPatientId:"+strPatientId);
			strBillNatCode=checkForNull(rs1.getString("bill_nature_code"));
			System.err.println("strBillNatCode:"+strBillNatCode);
			strBillingGroupId=checkForNull(rs1.getString("blng_grp_id"));
			strCustCode=checkForNull(rs1.getString("cust_code"));
			strepisodeTyp=checkForNull(rs1.getString("episode_type"));
			strepisodeId=checkForNull(rs1.getString("episode_id"));
			strVisitId=checkForNull(rs1.getString("visit_id"));
			strBillPrintFlag=checkForNull(rs1.getString("bill_print_flag"));
			billPaidAmt=billingFormatConverter(con,checkForNull(rs1.getString("bill_paid_amt")));
			totOutAmt=billingFormatConverter(con,checkForNull(rs1.getString("bill_tot_outst_amt")));
			strOperatingFacilityId=checkForNull(rs1.getString("operating_facility_id")); //V210129
			System.err.println("strOperatingFacilityId:"+strOperatingFacilityId);
			mpi_id=checkForNull(rs1.getString("MPI_ID")); //V221107 
			System.err.println("mpi_id BLreprintprocess:"+mpi_id);
			setlmt_ind=checkForNull(rs1.getString("setlmt_ind"));//V221107
			System.err.println("setlmt_ind:"+setlmt_ind);
			insBillAmt=checkForNull(rs1.getString("bill_amt"));//V221107
			System.err.println("insBillAmt:"+insBillAmt);
			
			if(strBillTotAmt.equals(totOutAmt)) billPaidAmt=billingFormatConverter(con,"0");
			
			
				
			String getExcemptedAmountQry="select doc_amt from bl_bill_adj_dtl   where ADJ_DOC_TYPE_CODE =? and ADJ_DOC_NUM =?  and ADJUST_EXEMPT_IND = 'E'   AND (DOC_TYPE_CODE,DOC_NUM) in (select DOC_TYPE_CODE,DOC_NUM from bl_bill_adj_hdr where nvl(finalized_yn,'N') = 'N' AND nvl(STATUS,'N') <> 'C' and nvl(cancelled_yn,'N')='N' )"; 	
			
			excemptedAmt= BLHelper.getDescriptionViaSQL(con,getExcemptedAmountQry,strDocTypCode,strDocNum);
			excemptedAmt=billingFormatConverter(con,excemptedAmt);
			
			if(Double.parseDouble(excemptedAmt)>0){
			Double finalOutStandingAmt= Double.parseDouble(totOutAmt) - Double.parseDouble(excemptedAmt);
			totOutAmt=billingFormatConverter(con,finalOutStandingAmt.toString());
			
			}
			
			String multiSlmtBeanId = "BLMultiBillSettlementBean";
			String multiSlmtBeanName = "eBL.BLMultiBillSettlementBean";
			BLMultiBillSettlementBean multiSlmtBean=(BLMultiBillSettlementBean) getBeanObject(multiSlmtBeanId, multiSlmtBeanName, request);
			Double penaltyCharge=multiSlmtBean.getDrugPenaltyChargesSingleBill(con, p_facility_id, strDocTypCode, strDocNum);
			drugPenalty=billingFormatConverter(con,penaltyCharge.toString());
		
%>			
				<tr id=row<%=i%> onclick='highlightRow(<%=i%>,"<%=classval%>")'>
					<td id='row<%=i %>_col0' class=<%=classval%> width="5%" style='cursor:pointer; white-space: nowrap' >
				<!-- ENM-2558 - MMS-QH-CRF-0163 Karthik changed Selection option from 'checkbox' to 'Button' and added isForALL attribute to skip alert in Select All Case -->
						<div  id='doc_typ_chk<%=i%>' name='doc_typ_chk<%=i%>' index='<%=i%>' onclick="moveData(<%=i%>,false,true,0)"> <div style="color: blue; font-size: 12px;">+</div> </div>
					</td>
					
					<td id='row<%=i %>_col1' class=<%=classval%> width="7%" style="white-space: nowrap">
						<span class="LABEL" id='doc_typ_code<%=i%>' name='doc_typ_code<%=i%>'><%=strDocTypCode%></span>
					</td>

					<td id='row<%=i %>_col2' class=<%=classval%> width="11%" class="fields" style='cursor:pointer; white-space: nowrap' onclick="tooltip(this,<%=i %>);"	onmouseover="hideToolTip();">
						<span class="LABEL" name='doc_num<%=i%>' id='doc_num<%=i%>'><%=strDocNum%></span>&nbsp;
						<img align='right' src='../../eCommon/images/inactiveArrow.gif' id='imgArrow<%=i%>'>
					</td>

					<td id='row<%=i %>_col3' class=<%=classval%> width="12%" class="fields" style="white-space: nowrap">
						<span class="LABEL" name='doc_date<%=i%>' id='doc_date<%=i%>'><%=strDocDate%></span> 
					</td>

					<td id='row<%=i %>_col4' class=<%=classval%> width="11%" class="fields"style="white-space: nowrap">
						<span class="LABEL" name='bill_tot_amt<%=i%>' id='bill_tot_amt<%=i%>'><%=strBillTotAmt%></span> 
					</td>
		
					<td id='row<%=i %>_col13' class=<%=classval%> width="11%" class="fields"style="white-space: nowrap">
						<span class="LABEL" name='bill_paid_amt<%=i%>' id='bill_paid_amt<%=i%>'><%=billPaidAmt%></span> 
					</td>

					<td id='row<%=i %>_col14' class=<%=classval%> width="11%" class="fields"style="white-space: nowrap">
						<span class='LABEL' name='bill_outstd_amt<%=i%>' id='bill_outstd_amt<%=i%>'><%=totOutAmt%></span> 
					</td>
					
					<td id='row<%=i %>_col5' width="7%" class=<%=classval%> style="white-space: nowrap">
						<span class="LABEL" name='patient_id<%=i%>' id='patient_id<%=i%>'><%=strPatientId%></span>
					</td>			
		<!-- Karthik Commented to Remove Billing class code and make it hidden -->
		<%-- 					<td id='row<%=i %>_col6' class=<%=classval%> width="5%" > --%>
		<%-- 						<span class="LABEL" name='bill_nat_code<%=i%>' id='bill_nat_code<%=i%>'><%=strBillNatCode%></span> --%>
		<!-- 					</td> -->
					<input type='hidden' name='bill_nat_code<%=i%>'  id='bill_nat_code<%=i%>' value='<%=strBillNatCode%>'>
					<input type='hidden' name='strOperatingFacilityId<%=i%>'  id='strOperatingFacilityId<%=i%>' value='<%=strOperatingFacilityId%>'>
					<input type='hidden' name='mpi_id<%=i%>'  id='mpi_id<%=i%>' value='<%=mpi_id%>'><!--V221107-->
					<input type="hidden"	name="setlmt_ind<%=i%>"  id='setlmt_ind<%=i%>'	value="<%=setlmt_ind%>"><!-- V221117 -->
					<input type="hidden"	name="insBillAmt<%=i%>"  id='insBillAmt<%=i%>'	value="<%=insBillAmt%>"><!-- V221117 --><%
					System.err.println("setlmt_ind :"+setlmt_ind);
					%>
					<td id='row<%=i %>_col7' class=<%=classval%> width="7%" style="white-space: nowrap">
						<span class='LABEL' id='bill_grp_id<%=i%>' name='bill_grp_id<%=i%>'><%=strBillingGroupId%></span> 
					</td>

					<td id='row<%=i %>_col8' class=<%=classval%> width="8%" class="fields" style="white-space: nowrap">
						<span class='LABEL' name='payer_code<%=i%>' id='payer_code<%=i%>'><%=strCustCode%></span>
					</td>
		
					<td id='row<%=i %>_col9' width="6%" class=<%=classval%> style="white-space: nowrap">
						<span class='LABEL' readonly name='episode_type<%=i%>' id='episode_type<%=i%>' ><%=strepisodeTyp%></span> 
					</td>
		
					<td id='row<%=i %>_col10' width="6%" class=<%=classval%> style="white-space: nowrap">
						<span class='LABEL' name='episode_id<%=i%>' id='episode_id<%=i%>'><%=strepisodeId%></span>
					</td>		
		
					<td id='row<%=i %>_col11' class=<%=classval%> width="6%" style="white-space: nowrap">
						<span class='LABEL' readonly name='visit_id<%=i%>' id='visit_id<%=i%>'><%=strVisitId%></span> 
					</td>  
		<% //Added V200228 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
		//if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN)) && ("Y".equals(demo_version))){ 
		if(("ALMO".equals(site_id) || "Y".equals(site3TierAlmoFeatureYN))){//removed demo_version against V210603
			
		%>
					<td id='row<%=i %>_col12' class=<%=classval%> width="8%" style="white-space: nowrap">
						<span class='LABEL' readonly name='excempted_amt<%=i%>' id='excempted_amt<%=i%>'><%=excemptedAmt%></span>
					</td>

					<td id='row<%=i %>_col13' class=<%=classval%> width="8%" style="white-space: nowrap">
						<span class='LABEL' readonly name='drug_penalty<%=i%>' id='drug_penalty<%=i%>'><%=drugPenalty%></span>
					</td>
					<%} %>
				</tr> 
 <%
					i++;
					total_records++; 
					
 				}//while
			}//If
%>
			</tbody>
			</table>
		</div>
<%				
		}
		catch(Exception eX)
		{		
			//out.println("Error= "+eX);
			eX.printStackTrace();			
		}
		finally
		{
			if (rs1 != null)   rs1.close();
			if (pstmt != null) pstmt.close();
			if(con!=null) 
			{
				ConnectionManager.returnConnection(con, request);
			}
		}
%>

		<input type='hidden' name='total_records' id='total_records' value='<%=total_records%>'>	
		<input type='hidden' name='checked_row' id='checked_row' value='' >		
		<input type='hidden' name='rowClicked' id='rowClicked' id='rowClicked' value = ''>		
		<input type='hidden' name='docType' id='docType' value = ''>
		<input type='hidden' name='documentNumber' id='documentNumber' value = ''>
		<input type='hidden' name='documentDate' id='documentDate' value = ''>
		<input type='hidden' name='billedAmount' id='billedAmount' value = ''>
		<input type='hidden' name='patientId' id='patientId' value = ''>
		<input type='hidden' name='billingClassCode' id='billingClassCode' value = ''>
		<input type='hidden' name='billingGroup' id='billingGroup' value = ''>
		<input type='hidden' name='payerCode' id='payerCode' value = ''>
		<input type='hidden' name='episodeType' id='episodeType' value = ''>
		<input type='hidden' name='episodeId' id='episodeId' value = ''>
		<input type='hidden' name='visitId' id='visitId' value = ''>
		<input type='hidden' name='excempted_amt' id='excempted_amt' value = ''>	
	
<%			
	if(total_records>0){
		System.out.println("total_records/classval"+total_records+"/"+classval);
		out.println("<script>");
		out.println("highlightRow(1,'"+classval+"')");
		out.println("</script>");
	}			
 %>
<!-- 		<script>parent.dummy_frame.location.href='../../eCommon/html/blank.html';</script>	 -->
	<input type='hidden' name='fromRcrd' id='fromRcrd'  value='<%=startRcrd %>'>
	<input type='hidden' name='toRcrd' id='toRcrd'  value='<%=endRcrd %>'>
	<input type='hidden' name='constCount'  id='constCount' value='<%=constCount %>'>
	<input type='hidden' name='prevClicked'  id='prevClicked' value=''>
	<input type='hidden' name='hdnNextSpan'  id='hdnNextSpan' value='<%=nextYn %>'>
	<input type='hidden' name='prevSpan'  id='prevSpan' value='<%=prevYn %>'>
	<input type='hidden' name='traverse'  id='traverse' value='<%=traversal%>'>
	
	<!-- Hidden Vars for Next / Prev Refresh -->
	<input type='hidden' name='hdnEpisodeType'  id='hdnEpisodeType' value='<%=p_episode_type %>'>
	<input type='hidden' name='hdnPatientId'  id='hdnPatientId' value='<%=patientId %>'>
	<input type='hidden' name='hdnEpisodeId'  id='hdnEpisodeId' value='<%=episodeId %>'>
	<input type='hidden' name='hdnBillNoFrom'  id='hdnBillNoFrom' value='<%=p_from_bill_number%>'>
	<input type='hidden' name='hdnBillDateFrom'  id='hdnBillDateFrom' value='<%=p_from_bill_date %>'>
	<input type='hidden' name='hdnBillDocFrom'  id='hdnBillDocFrom' value='<%=p_from_bill_number_code %>'>
	<input type='hidden' name='hdnBillNoTo'  id='hdnBillNoTo' value='<%=p_to_bill_number %>'>
	<input type='hidden' name='hdnBillDateTo'  id='hdnBillDateTo' value='<%=p_to_bill_date%>'>
	<input type='hidden' name='hdnBillDocTo'  id='hdnBillDocTo' value='<%=p_to_bill_number_code %>'>
	
	<input type='hidden' name='hdnVisitId'  id='hdnVisitId' value='<%=visitId %>'>
	<input type='hidden' name='hdnBillType'  id='hdnBillType' value='<%=p_bill_type %>'>
	<input type='hidden' name='hdnDtlBillPrint'  id='hdnDtlBillPrint' value=''>
	<input type='hidden' name='hdnOutStd'  id='hdnOutStd' value='<%=p_outstd_only %>'>
	<input type='hidden' name='hdncustCode'  id='hdncustCode' value='<%=p_cust_code%>'>
	<input type='hidden' name='site_id'  id='site_id' value='<%=site_id%>'>
	<!-- <input type='hidden' name='demo_version' id='demo_version' id='demo_version' value=''> //removed demo_version against V210603-->
	<input type='hidden' name='excempted_amt'  id='excempted_amt' value='<%=excemptedAmt%>'>
	<input type='hidden' name='payer_group'  id='payer_group' value='<%=payer_group%>'>
	<input type='hidden' name='payer_type'  id='payer_type' value='<%=payer_type%>'>
	<input type='hidden' name='zerobill'  id='zerobill' value='<%=zerobill%>'>
	<input type='hidden' name='noofdecimal'   value='<%=noofdecimal%>'>
	<input type='hidden' name='site3TierAlmoFeatureYN'  id='site3TierAlmoFeatureYN' value='<%=site3TierAlmoFeatureYN %>'>
	<input type='hidden' name='eSignYN' id='eSignYN'  value='<%=eSignYN %>'><!--V221107-->
	
	
<!-- 	Added by Karthik to include login user in Param 17  -->
	<input type='hidden' name='login_user' id='login_user'  value='<%=(String)session.getAttribute("login_user")%>'>
	
	<!-- Hidden Vars for Next / Prev Refresh -->
	<input type="hidden" name="locale" id="locale"  value="<%=locale%>">
	</form >
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>
	<div name='tooltiplayer1' id='tooltiplayer1' style="position: absolute; width: 12%; visibility: visible; left: 451px; top: 40px; background-color: #808080 !important; z-index: 1000;">
		<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
			<tr>
				<td width='100%' id='t'></td>
				<!-- </td> -->
			</tr>
		</table>
	</div>
	<%System.out.println("************************************set form is about to be called **********************************"+searched);%>
	<%out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLReprintProcess.jsp",searched));%>
	<%System.out.println("************************************set form is about to be called **********************************"+searched);%>
	</body>
	</TBODY>	
	</div>
</HTML>

