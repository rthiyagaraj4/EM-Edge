<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Version     	Developer Name		Rev.Date		Rev.Name		SCF/CRF
-------------------------------------------------------------------------------------------------------------------------------------
09/06/2020 	  		         Ram kumar S									  AAKH-CRF-0122
15/10/2020 	 V201015	     Ram kumar S									  AAKH-SCF-0458
22/12/2020 	 V201222	     Ram kumar S									  AAKH-SCF-0479
29/09/2022                   Kamatchi S                                       TH-KW-CRF-0143
V230516						Mohanapriya										  AAKH-CRF-0153
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page contentType="text/html;charset=ISO-8859-1" import ="com.ehis.util.*,java.sql.*,java.util.*,java.net.*,java.text.*, eCommon.Common.*,org.json.simple.*, java.util.Map.Entry,java.util.Set,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,eBL.*,eBL.resources.*,webbeans.op.CurrencyFormat, java.io.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/> 
";
			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
			dummyDoc.dummy_frm.submit();
			},
			 error: function(data){
				 alert(data);
		  }
	});		
	}
}

function trim(str) {
	if(str != ""){
		return str.replace(/^\s+|\s+$/g,'');
	}
	return "";
} 

function onLoadServiceEdit() {
	var currentdate = new Date(); 
	var minutes=currentdate.getMinutes();
	if(minutes.length==1){
		minutes="0"+minutes;
	}
	var datetime = currentdate.getDate() + "/"
					+ (currentdate.getMonth()+1)  + "/" 
					+ currentdate.getFullYear() + " "  
					+ currentdate.getHours() + ":"  
					+ minutes;
	//Making Editable Functionlaity bas ed on billable check box
	try{
			var table = document.getElementById('serviceTable1');
			var rowCount = table.rows.length;
			if(rowCount>25){
				rowCount=25;
			}
        // var i=1 to start after header
			for(var j=1; j<rowCount; j++) {
			var colCount = table.rows[j].cells.length;
			//Disabling all service
				for(var k=0; k<colCount; k++){
						var str=table.rows[j].cells[k].innerHTML;
						var res;
						if(str.indexOf("<INPUT")==0){
							res = str.replace("<INPUT", "<INPUT disabled");
							if(res.indexOf("<IMG")==0){
							res = str.replace("<IMG", "<IMG disabled");
							}
						}
						else if(str.indexOf("<SELECT")==0 ){
							res = str.replace("<SELECT", "<SELECT disabled");
						}
						table.rows[j].cells[k].innerHTML=res;
				}
			}
	}catch(e){
			alert("Exception in Editable functionality against billable checkbox Row "+e);
		}
}

function GenerateBill(){
	//Calling gen Bill Function
	var facilityId =  $('#facilityId').val();
	var patientId = $('#PatientID').val();
	var encounter_id =  $('#encounter_id').val();
	var ServiceSessionId =  $('#ServiceSessionId').val();	
	var localeLang =  $('#localeLang').val();	
	var WS_NO =  $('#WS_NO').val();		
	var loginUser =  $('#loginUser').val();	
	var EpisodeType =  $('#EpisodeType').val();	
	var params="&facilityId="+facilityId+"&encounter_id="+encounter_id+"&ServiceSessionId="+ServiceSessionId+"&localeLang="+localeLang+"&WS_NO="+WS_NO+"&loginUser="+loginUser+"&EpisodeType="+EpisodeType+"&patientId="+patientId;
	var temp_jsp="../../eBL/jsp/BLCoderFunServiceValidations.jsp?CalledFor=GenBill"+params;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();		
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send("");
	var responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	var n1 = responseText.indexOf("~");
	var res1 = responseText.substr(n1+1);
	res1 = res1.split("~");
	if(res1[0]=="E"){
	var msgText=getMessage(res1[1],'BL');
		if(msgText=="" || msgText==null){
			var tempJsp="../../eBL/jsp/BLCoderFunServiceValidations.jsp?CalledFor=getMsgFromDB&msgId="+res1[1];
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();		
			xmlHttp.open("POST",tempJsp,false);
			xmlHttp.send("");
			var resText=xmlHttp.responseText;
			resText = trimString(resText);
			var nFin = resText.indexOf("~");
			var resFin = resText.substr(nFin+1);
			if(resFin=="" || resFin==null){
				alert("Error at server end..");
			}else{
				alert(resFin);
			}
		}else{
			alert(msgText);
		}
	}else if(res1[0]=="Err"){
		alert(res1[1]);
	}else if(res1[0]=="S"){
		if(res1.length==2){
			alert(res1[1]);
		}
		else if(res1.length==3){
			alert(res1[1]);
			alert(res1[2]);
		}
	}else{
		alert(res1[1]);
	}
	location.reload();
	parent.frames[3].location.reload();//V230222/AAKH-CRF-0172
}

function EditService(){
	var ServiceSessionId = $('#ServiceSessionId').val();
	var ServiceEncounterId = $('#encounter_id').val();
	//V201015 Starts
	var patientId = $('#PatientID').val();
	var EpisodeType = $('#EpisodeType').val();
	var EpisodeID = $('#EpisodeID').val();
	var visit_Id = $('#visit_Id').val();//Added by Kamatchi S for TH-KW-CRF-0143
	var siteSpecPatPayable = $('#siteSpecPatPayable').val();//V230222/AAKH-CRF-0172
	var siteSpecSearch = $('#siteSpecSearch').val();//V230529/AAKH-CRF-0153
	//V201015 Ends
	//document.forms[0].ServiceSessionId.value;
	var param="ServiceSessionId="+ServiceSessionId+"&ServiceEncounterId="+ServiceEncounterId+"&patientId="+patientId+"&episode_type="+EpisodeType+"&episode_id="+EpisodeID+"&visit_Id="+visit_Id+"&siteSpecPatPayable="+siteSpecPatPayable+"&siteSpecSearch="+siteSpecSearch; //V201015 Modified //Modified by Kamatchi S TH-KW-CRF-0143 //V230222
	var dialogUrl       = "../../eBL/jsp/BLCoderEditService.jsp?"+param;
	var dialogFeatures  = "dialogHeight:" + "100" + "; dialogWidth:" + "100" +" ; scroll=auto; ";
	/*var returnVal = window.showModalDialog(dialogUrl,null,dialogFeatures);
	if(returnVal=="Close"){
		location.reload();
	}*/
	//if(openFlag){
	//openFlag=false;
	document.getElementById("GenBill").disabled = true;
	document.getElementById("EditService").disabled = true;
	var retValue=window.open(dialogUrl, "", "directories=no,fullscreen=yes,titlebar=no,toolbar=no,menubar=no,resizable=yes, top=0, left=0,scrollbars=yes");
	//}
}

function setValue(val){
	//openFlag=val;
	document.getElementById("GenBill").disabled = false;
	document.getElementById("EditService").disabled = false;
	location.reload();
}

</script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con= null;
	Connection conSession = null;
	PreparedStatement pstmtSession = null ;
	ResultSet rsSession = null;
	String facilityId			= (String) session.getValue("facility_id");
	String encounter_id			= request.getParameter("encounter_id");
	String loginUser			= (String) session.getValue("login_user");
	String SessionId            = request.getParameter("session_id");
	String User					=	"";
	String bean_id				=	"";
	String bean_name			=	"";
	String KeyValue="";
	String EpisodeType=request.getParameter("episode_type");
	String EpisodeID=request.getParameter("episode_id");
	String PatientID= request.getParameter("patient_id");
	String VisitID="";
	String visit_Id = request.getParameter("visit_Id");//Added by Kamatchi S for TH-KW-CRF-0143
	java.util.Properties p=null;
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String WS_NO           =p.getProperty("client_ip_address");
	bean_id					= 	"BLCoderPatServiceBean" ;
	bean_name				= 	"eBL.BLCoderPatServiceBean"; 
	LinkedHashMap 	blCoderpatServices	=	null;
	BLCoderPatServiceBean blCoderPatServiceBean = 	null;
	BLCoderPatService	blCoderPatService = null;	
	Boolean siteSpecServiceCode = false;//Added by Kamatchi S for TH-KW-CRF-0143
	Boolean siteSpecPatPayable=false;//V230222
	Boolean siteSpecSearch=false;//V230529
	blCoderpatServices	=	new LinkedHashMap();
	blCoderPatServiceBean	= 	(BLCoderPatServiceBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request );
		
	//Getting Loaded Hashmap with Services
	String localeLang			= (String)session.getAttribute("LOCALE");
	String logInUserId="";
	String logInWSno="";
	blCoderPatServiceBean.clearBean();
	blCoderPatServiceBean.getDBValues(SessionId,facilityId,encounter_id);
	//SimpleDateFormat serviceIPSdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
	//SimpleDateFormat serviceOPSdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	int limit=0;
	int limitId=1;
	blCoderpatServices	= 	(LinkedHashMap)blCoderPatServiceBean.getBLCoderPatSearchValues(); 
	con = ConnectionManager.getConnection(request);//Modified by Kamatchi S for TH-KW-CRF-0143
	siteSpecServiceCode = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_SERVICE_CODE_REQD");//Added by Kamatchi S for TH-KW-CRF-0143
	siteSpecPatPayable =  eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ALLOW_CASH_PAT_IN_CODER_FN");//V230222
	siteSpecSearch =  eCommon.Common.CommonBean.isSiteSpecific(con, "BL","AAKH_BL_SCREEN_CHANGES");//V230529
	System.err.println("siteSpecSearch "+siteSpecSearch);

%>
<body onload="onLoadServiceEdit()" onKeyDown="lockKey();" onMouseDown="CodeArrest();">
<center>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
	      <tr >
	      	 <td class="BOLD">Services</td>
			 <td width="40%"></td>&nbsp;&nbsp;&nbsp;&nbsp;
			  <%if(siteSpecSearch){%>
	      	  <td style="align:center">
				<input type="text" name="searchCPT" id="searchCPT" id="searchCPT" placeholder="CPT Code Search" title="search CPT Code"> 
				<img alt="search" src="..\..\eBL\images\search.png" onclick="searchCptCode(searchCPT)">
			  </td> 
			 <% } %>
	      </tr>
      </table>
      <tr>
        <td><table width='100%' align="center" cellpadding="4" cellspacing="0" class='grid' id="serviceTable1" name='serviceTable1' id='serviceTable1'>
          <tr>
            <td class='COLUMNHEADER' >Date &amp; Time</td>
            <td class='COLUMNHEADER' >Drug/Non drug </td>
            <td class='COLUMNHEADER' >Service Type</td>
            <td class='COLUMNHEADER' >Service Code(CPT)</td>
            <td class='COLUMNHEADER' >Service Description</td>
			<!--Added by Kamatchi S for TH-KW-CRF-0143-->
			<% if(siteSpecServiceCode){%>
			<td class='COLUMNHEADER' >Billing Service Code</td>
			<%}%>
            <td class='COLUMNHEADER' >Ordering Clinician </td>
            <td class='COLUMNHEADER' >Performing Clinician</td>
            <td class='COLUMNHEADER' >Quantity</td>
            <td class='COLUMNHEADER' >Modifier/ Adjuster</td>
            <td class='COLUMNHEADER' >Zero Price</td>
            <td class='COLUMNHEADER' >Approval No.</td>
            <td class='COLUMNHEADER' >Approval Date </td>
            <td class='COLUMNHEADER' >Service Price</td>
			<!--Added by Kamatchi S for TH-KW-CRF-0143-->
			<% if(siteSpecServiceCode){%>
            <td class='COLUMNHEADER' >Ins/Cash Price</td>
			<%}else{%>
			<td class='COLUMNHEADER' >Ins.Price</td>	
			<%}%>
			<%if(siteSpecPatPayable){%>
				<td class='COLUMNHEADER' >Patient Payable</td>
			<%} //V230222/AAKH-CRF-0172
			%>
            <td class='COLUMNHEADER' >Billable</td>
            <td class='COLUMNHEADER' >Add Row</td>
            <td class='COLUMNHEADER' >Cancel Services</td>
            <td style="display:none;">BillDocTypeCode</td>
            <td style="display:none;">BillDocNo</td>
            <td style="display:none;">CustGrpCode</td>
            <td style="display:none;">CustCode</td>
            <td style="display:none;">TrxDocRef</td>
            <td style="display:none;">TrxDocRefLineNo</td>
            <td style="display:none;">TrxDocRefSeqNoNo</td>
            <td style="display:none;">TrxDate</td>
            <td style="display:none;">SettlementInd</td>
            <td style="display:none;">PatientAmt</td>
            <td style="display:none;">Key Value</td>
            </tr>
<%	
	
	if(blCoderpatServices.size()>25){
		limit=25;
	}else{
		limit=blCoderpatServices.size();
	}
	if(!blCoderpatServices.isEmpty()) {
         Iterator it = blCoderpatServices.entrySet().iterator();
		 int s=0;
			//for(int s=0;s<limit;s++){
         while(it.hasNext()&& s<limit) {
			 s++;
				Map.Entry obj = (Entry)it.next();
				blCoderPatService=(BLCoderPatService)obj.getValue();
				KeyValue=(String)obj.getKey();
		   if(blCoderPatService!=null){
			   //Login User ID
			   logInUserId= blCoderPatService.getlogInID();
				logInUserId=(logInUserId==null?"":logInUserId);
				//Login WS No ID
			   logInWSno= blCoderPatService.getlogInWSNo();
				logInWSno=(logInWSno==null?"":logInWSno);
			   //Bill Doc type code
			   String BillDocTypeCode= blCoderPatService.getBillDocTypeCode();
				BillDocTypeCode=(BillDocTypeCode==null?"":BillDocTypeCode);
			   //Bill Doc Number
			   String BillDocNo= blCoderPatService.getBillDocNum();
				BillDocNo=(BillDocNo==null?"":BillDocNo);
			   //Customer Group Code
			   String CustGrpCode= blCoderPatService.getCustGroupCode();
				CustGrpCode=(CustGrpCode==null?"":CustGrpCode);
			   //Customer Code
			   String CustCode= blCoderPatService.getCustCode();
				CustCode=(CustCode==null?"":CustCode);
			   //TRX Doc Ref
			   String TrxDocRef= blCoderPatService.getTrxDocRef();
				TrxDocRef=(TrxDocRef==null?"":TrxDocRef);
			   //TRX Doc Ref Line No
			   String TrxDocRefLineNo= blCoderPatService.getTrxDocRefLineNum();
				TrxDocRefLineNo=(TrxDocRefLineNo==null?"":TrxDocRefLineNo);
			   //TRX Doc Ref Seq No
			   String TrxDocRefSeqNo= blCoderPatService.getTrxDocRefSeqNum();
				TrxDocRefSeqNo=(TrxDocRefSeqNo==null?"":TrxDocRefSeqNo);
			   //TRX Date
			   String TrxDate= blCoderPatService.getTrxDate();
				TrxDate=(TrxDate==null?"":TrxDate);
				/*if(!TrxDate.equals("")){
					java.util.Date servdateTime3 = serviceIPSdf.parse(TrxDate);
					TrxDate = serviceOPSdf.format(servdateTime3);
				}*/
			   //Episode Type
			    EpisodeType= blCoderPatService.getEpisodeType();
				EpisodeType=(EpisodeType==null?"":EpisodeType);
			   //Episode Id
			    EpisodeID= blCoderPatService.getEpisodeId();
				EpisodeID=(EpisodeID==null?"":EpisodeID);
			   //Visit Id
			    VisitID= blCoderPatService.getVisitId();
				VisitID=(VisitID==null?"":VisitID);
			   //Settlement Ind
			   String SettlementInd= blCoderPatService.getSettlementInd();
				SettlementInd=(SettlementInd==null?"":SettlementInd);
			   //Patient Amount
			   String PatientAmt= blCoderPatService.getPatientAmount();
				PatientAmt=(PatientAmt==null?"":PatientAmt);
			   //Date and Time
				String Service_Date=  blCoderPatService.getServiceDate();
				Service_Date=(Service_Date==null?"":Service_Date);
				/*if(!Service_Date.equals("")){
					java.util.Date servdateTime2 = serviceIPSdf.parse(Service_Date);
					Service_Date = serviceOPSdf.format(servdateTime2);
				}*/
			   // Drug-NonDrug
				String Service_Type_Ind=  blCoderPatService.getServTypeInd();
				Service_Type_Ind=(Service_Type_Ind==null?"":Service_Type_Ind);
				String opt1="";
				String opt2="";
				String opt3="";
				if(Service_Type_Ind.equals("S") || Service_Type_Ind.equals("")){
					Service_Type_Ind="Service";
					opt1="";
					opt2="selected";
					opt3="";
				}else if(Service_Type_Ind.equals("I")){
					Service_Type_Ind="Drug";
					opt1="";
					opt2="";
					opt3="selected";
				}else{
					Service_Type_Ind="Drug";
					opt1="selected";
					opt2="";
					opt3="";
				}
			   // Service Type
				String Service_Type=  blCoderPatService.getServTypeDesc();
				Service_Type=(Service_Type==null?"":Service_Type);
				// CPT Code
				String CPT_Code=  blCoderPatService.getcptCode();
				CPT_Code=(CPT_Code==null?"":CPT_Code);
			   // Service Code
				String Service_Code=  blCoderPatService.getServItemCode();
				Service_Code=(Service_Code==null?"":Service_Code);
			   // Service Description
				String Service_Desc=  blCoderPatService.getServItemDesc();
				Service_Desc=(Service_Desc==null?"":Service_Desc);
			   // Ordering Clinician
				String Ordering_Clinician=  blCoderPatService.getOrderingPhysicianName();
				Ordering_Clinician=(Ordering_Clinician==null?"":Ordering_Clinician);
			   // Performing Clinician
				String Perform_Clinician=  blCoderPatService.getPerformPhysicianName();
				Perform_Clinician=(Perform_Clinician==null?"":Perform_Clinician);
			   // Quantity
				String Quantity=  blCoderPatService.getServQty();
			   // Modifier/Adjuster
				String Mod_Adjus=  blCoderPatService.getModifierAdjusterId();
				Mod_Adjus=(Mod_Adjus==null?"":Mod_Adjus);
			   // Zero Price
				String Zero_Price=  blCoderPatService.getZeroPriceYN();
				Zero_Price=(Zero_Price==null?"":Zero_Price);
				if(Zero_Price.equals("Y")){
					Zero_Price="checked";
				}else{
					Zero_Price="";
				}					
			   // Approval Number
				String Approval_No=  blCoderPatService.getCDRApprovalNo();
				Approval_No=(Approval_No==null?"":Approval_No);
			   // Approval Date
				String Approval_Date=  blCoderPatService.getCDRApprovalDate();
				Approval_Date=(Approval_Date==null?"":Approval_Date);
				/*if(!Approval_Date.equals("")){
				java.util.Date servdateTime4 = serviceIPSdf.parse(Approval_Date);
				Approval_Date = serviceOPSdf.format(servdateTime4);
			    System.err.println("Approval Date From Bean  "+Approval_Date);
				}*/
			   // Service Price
				String Service_Price=  blCoderPatService.getServiceAmount();
				Float servicePrice=Float.parseFloat(Service_Price);
				DecimalFormat df = new DecimalFormat("0.00");
				Service_Price = df.format(servicePrice);
			   // Insurance Amount
				String Ins_Amt=  blCoderPatService.getInsuranceAmount();
				Float insAmt=Float.parseFloat(Ins_Amt);
				Ins_Amt = df.format(insAmt);
				//V230222
				String pat_payable=  blCoderPatService.getPatientPayable();
				Float pat_pay=Float.parseFloat(pat_payable);
				pat_payable = df.format(pat_pay);
				//V230222
			   // Billable CheckBox
				String Billable_Check=  blCoderPatService.getBillableYN();
				Billable_Check=(Billable_Check==null?"":Billable_Check);
				if(Billable_Check.equals("Y")){
					Billable_Check="checked";
				}else{
					Billable_Check="unchecked";
				}
				//BillYN
				String  isbilled="";//V230516
				String boldYN="";//V230516
				String	Bill_YN=blCoderPatService.getBillYN();
				if(Bill_YN.equals("Y")){
					Bill_YN="checked";
					if(siteSpecSearch){
						isbilled="";
						boldYN="";
					}
				}else{
					Bill_YN="unchecked";
					if(siteSpecSearch){
						isbilled="unbilled";//V230516-AAKH-CRF-0153
						boldYN="bolder";
					}
				}			
			   // Add Row
				String AddRow=  blCoderPatService.getAddRowYN();
				AddRow=(AddRow==null?"":AddRow);
				if(AddRow.equals("Y")){
					AddRow="disabled";
				}else{
					AddRow="";
				}
			   // Cancel Services
				String Cancel_Services=  blCoderPatService.getCancelRowYN();
				Cancel_Services=(Cancel_Services==null?"":Cancel_Services);
				if(Cancel_Services.equals("Y")){
					Cancel_Services="checked";
				}else{
					Cancel_Services="unchecked";
				}
				%>
				<tr id='serviceRow<%=limitId%>' disabled>
            <td class="<%=isbilled%>"><input type="text" onblur="validateDateTime(this)" class="gridDataInputMore <%=boldYN%>" name="serviceDate<%=limitId%>" id="serviceDate<%=limitId%>" value="<%=Service_Date%>" size="18" maxlength="18"><img src="../../eCommon/images/CommonCalendar.gif"></td>
            <td class="<%=isbilled%>">
            	<select name="servicetype<%=limitId%>" id="servicetype<%=limitId%>" id="servicetype<%=limitId%>" onchange="DrugTypeChange(this)">       
					<option value="Select" <%=opt1%>>-Select-</option>
              		<option value="Service" <%=opt2%>>Service</option>
              		<option value="Drug" <%=opt3%>>Drug</option>
             	 </select>
            </td>
            <td class="<%=isbilled%>"><input class="gridDataInputLess <%=boldYN%>" maxlength="100" type="text" value="<%=Service_Type%>"></td>
            <td class="<%=isbilled%>"><input class="gridDataInput <%=boldYN%>" style="width: 100px;" type="text" name="cptCode<%=limit%>" onblur="validateCPTCode(this)" id="cptCode<%=limitId%>" value="<%=CPT_Code%>" ><input class="gridDataInput" type="hidden" name="serviceCode<%=limit%>" id="serviceCode<%=limit%>" id="serviceCode<%=limit%>" value="<%=Service_Code%>" ></td>
			<td class="<%=isbilled%>"><input class="gridDataInput <%=boldYN%>" type="text" name="serviceDesc<%=limitId%>" id="serviceDesc<%=limitId%>" value="<%=Service_Desc%>"  title="<%=Service_Desc%>"></td>
			<%if(siteSpecServiceCode){%><!--Added by Kamatchi S for TH-KW-CRF-0143-->
			<td class="<%=isbilled%>"><input class="gridDataInput <%=boldYN%>" type="text" name="serviceCode<%=limit%>" id="serviceCode<%=limit%>" value="<%=Service_Code%>"></td>
			<%}%>
            <td class="<%=isbilled%>"><input class="gridDataInput <%=boldYN%>" type="text" name="orderClinic<%=limitId%>" id="orderClinic<%=limitId%>" value="<%=Ordering_Clinician%>" ></td>
            <td class="<%=isbilled%>"><input class="gridDataInput <%=boldYN%>" type="text" name="performClinic<%=limitId%>" id="performClinic<%=limitId%>" value="<%=Perform_Clinician%>" ></td>
            <td class="<%=isbilled%>"><input class="gridDataInputLess <%=boldYN%>" type="text" name="serviceQty<%=limitId%>" id="serviceQty<%=limitId%>" onblur="validateServQty(this)" value="<%=Quantity%>"  ><input style="display:none;" type="text" id="serviceRateCharge<%=limitId%>" value="" ></td>
            <td class="<%=isbilled%>"><input class="gridDataInputLess <%=boldYN%>" type="text" maxlength="30" value="<%=Mod_Adjus%>" ></td>
            <td class="<%=isbilled%>"><input type="checkbox" name="checkbox<%=limitId%>" id="checkbox<%=limitId%>" value="<%=Zero_Price%>" id="checkbox<%=limitId%>" onclick="zeroPriceClick(this)"  <%=Zero_Price%>/></td>
            <td class="<%=isbilled%>"><input class="gridDataInput <%=boldYN%>" type="text" name="ApproveNum<%=limitId%>" id="ApproveNum<%=limitId%>" onchange="ModAppNo(this)" value="<%=Approval_No%>" ><input style="display:none;" type="text" id="serviceModAppNo<%=limitId%>" value="N" ></td>
            <td class="<%=isbilled%>"><input class="gridDataInputMore <%=boldYN%>" type="text" name="ApproveDate<%=limitId%>" id="ApproveDate<%=limitId%>" onchange="ModAppNo(this)"  value="<%=Approval_Date%>" ><img src="../../eCommon/images/CommonCalendar.gif"></td>
            <td class="<%=isbilled%>"><input class="gridDataInput <%=boldYN%>" type="text" name="ServPrice<%=limitId%>" id="ServPrice<%=limitId%>" value="<%=Service_Price%>" ></td>
            <td class="<%=isbilled%>"><input class="gridDataInput <%=boldYN%>" type="text" name="InsAmt<%=limitId%>" id="InsAmt<%=limitId%>" value="<%=Ins_Amt%>" ></td>
			<!--V230222-->
			<% if(siteSpecPatPayable){%> 
			 <td class="<%=isbilled%>">
			 	<input class="gridDataInput <%=boldYN%>" type="text" name="patPay<%=limitId%>" id="patPay<%=limitId%>" value="<%=pat_payable %>" >
			 </td>
			<%}%>
            <td class="<%=isbilled%>">
            	<input type="checkbox" name="checkboxBill<%=limitId%>" id="checkboxBill<%=limitId%>" value="<%=Billable_Check%>" id="checkboxBill<%=limitId%>"  onclick="billClick(this)" <%=Billable_Check%>/>
            	<input style="display:none;" type="text" id="serviceBillCheck<%=limitId%>" value="<%=Bill_YN%>" >
            </td>
            <td class="<%=isbilled%>"><input type="button" name="AddBTn<%=limitId%>" id="AddBTn<%=limitId%>"  value="+" onclick="addRow(this)" id="AddBTn<%=limitId%>">
            	<input style="display:none;" type="text" id="serviceAddRow<%=limitId%>" value="" >
            </td>
            <td class="<%=isbilled%>"><input type="checkbox" name="Cancelcheck<%=limitId%>" id="Cancelcheck<%=limitId%>" value="" id="Cancelcheck<%=limitId%>" onclick="CancelClick(this)" <%=Cancel_Services%> /><input style="display:none;" type="text" id="serviceCancelRow<%=limitId%>" value="" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=BillDocTypeCode%>" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=BillDocNo%>" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=CustGrpCode%>" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=CustCode%>" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=TrxDocRef%>"></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=TrxDocRefLineNo%>" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=TrxDocRefSeqNo%>" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=TrxDate%>"></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=SettlementInd%>" ></td>
            <td style="display:none;"><input type="text" style="display:none;"  value="<%=PatientAmt%>" ></td>
			<td style="display:none;"><input type="text" style="display:none;"  value="<%=KeyValue%>" ></td>
			<%if(siteSpecSearch || siteSpecPatPayable){%>
			<td style="display:none;"><input type="hidden" name="isbilled<%=limitId%>" id="isbilled<%=limitId%>" id="isbilled<%=limitId%>" value="<%=isbilled%>"></td>
			<td style="display:none;"><input type="hidden" name="boldYN<%=limitId%>" id="boldYN<%=limitId%>" id="boldYN<%=limitId%>" value="<%=boldYN%>"></td>
			<%}%>
			</tr>
				<%				
				} 
				limitId++;	   
         }
      }	
%>
	  </table></td>
	</tr>
  <tr>
  	<td>
  		<table width="100%" border="0" cellspacing="0" cellpadding="5">
  			<tr>
				<td style="text-align:left"><input type="submit" name="EditService" id="EditService" id="EditService" value="Details / Edit" onclick="EditService()"/></td>
				<%if(siteSpecServiceCode){%><!-- Modified by Kamatchi S for TH-KW-CRF-0143-->
				<td style="text-align:left"><input type="submit" name="Generate Bill" id="Generate Bill" id="GenBill" disabled value="Generate Bill" onclick="GenerateBill()"/></td>
				<%}else{%>
				<td style="text-align:left"><input type="submit" name="Generate Bill" id="Generate Bill" id="GenBill" value="Generate Bill" onclick="GenerateBill()"/></td>
				<%}%>
  			</tr>
  		</table>
  	</td> 
  </tr>
  </table></td>
  </tr>
  <tr>
    <td ><table width="100%" border="0" cellspacing="0" cellpadding="5">
	<%
		// Populating Financial Details 
		double patShareAmt=0.0d;
		double patPaidAmt=0.0d;
		double grossAmt=0.0d;
		double outStandAmt=0.0d;
		double depositAmt=0.0d;
		String pat_ShareAmt1="";
		String pat_PaidAmt1 ="";
		String gross_Amt1   ="";
		String outStandAmt1 ="";
		String netClaim_Amt1="";
		String depositAmt1="";
		String sessioStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		try	{
				//con = ConnectionManager.getConnection(request);//Commented for TH-KW-CRF-0143 by Kamatchi S
				String Query_Populate_Fin_Dtls = "{ call bl_coders.get_fin_dtls('"+facilityId+"','"+SessionId+"','"+encounter_id+"','"+localeLang+"','"+loginUser+"',?,?,?,?,?,?) }";
				CallableStatement call = con.prepareCall(Query_Populate_Fin_Dtls);		
					
				call.registerOutParameter(1,java.sql.Types.DOUBLE);
				call.registerOutParameter(2,java.sql.Types.DOUBLE);
				call.registerOutParameter(3,java.sql.Types.DOUBLE);
				call.registerOutParameter(4,java.sql.Types.DOUBLE);
				call.registerOutParameter(5,java.sql.Types.VARCHAR);// V201222 Modified 
				call.registerOutParameter(6,java.sql.Types.DOUBLE);
				call.execute();
				DecimalFormat df1 = new DecimalFormat("#.00");
				patShareAmt = call.getDouble(1);
				patPaidAmt = call.getDouble(2);
				grossAmt = call.getDouble(3);
				outStandAmt = call.getDouble(4);
				netClaim_Amt1 = call.getString(5); // V201222 Modified 
				depositAmt = call.getDouble(6);
				pat_ShareAmt1 =  String.format("%,.2f", patShareAmt);
				pat_PaidAmt1  =  String.format("%,.2f", patPaidAmt);
				gross_Amt1    =  String.format("%,.2f", grossAmt);
				outStandAmt1  =  String.format("%,.2f", outStandAmt);
				depositAmt1   =  String.format("%,.2f", depositAmt);
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception Occured in Procedure Call Coder Function Services  "+e);
		}
	%>
      <tr>
        <td colspan="5" class="BOLD">Financial Status</td>
      </tr>
      <tr>
        <td >Patient Share</td>
        <td><input type='text' class="gridDataInputMore" style="width: 200px;font-weight:bold;"  value="<%=pat_ShareAmt1%>" onfocus="this.blur()" readonly="readonly" ></td><!-- V201222 Modified --> 
        <td >&nbsp;</td>
        <td >Patient Paid</td>
        <td><input type='text' class="gridDataInputMore" style="width: 200px;font-weight:bold;"  value="<%=pat_PaidAmt1%>" onfocus="this.blur()" readonly="readonly"></td><!-- V201222 Modified --> 
        </tr>
      <tr>
        <td >Patient Outstanding</td> <!-- V201222 Modified --> 
        <td><input type='text' class="gridDataInputMore" style="width: 200px;font-weight:bold;"  value="<%=outStandAmt1%>" onfocus="this.blur()" readonly="readonly"></td><!-- V201222 Modified --> 
        <td >&nbsp;</td>
        <td >Gross Amount</td>
        <td><input type='text' class="gridDataInputMore" style="width: 200px;font-weight:bold;"  value="<%=gross_Amt1%>" onfocus="this.blur()" readonly="readonly"></td><!-- V201222 Modified --> 
        </tr>
        <tr>
        <td >Deposit Amount</td>
        <td><input type='text' class="gridDataInputMore" style="width: 200px;font-weight:bold;"  value="<%=depositAmt1%>" onfocus="this.blur()" readonly="readonly"></td><!-- V201222 Modified --> 
        <td >&nbsp;</td>
        <td class="BOLD" >Net Claim Amount</td>
        <td><input type='text' class="gridDataInputMore" id="netClaimAmt" style="width: 200px;color:red;font-weight:bold;" value="<%=netClaim_Amt1 %>" onfocus="this.blur()" readonly="readonly"></td><!-- V201222 Modified --> 
        </tr>
    </table></td>
  </tr>
  <tr>
	<td>
		<input type="button" name="visitGenBill" id="visitGenBill" id="visitGenBill" value="Encounter - Generated Bills" onclick="rePrintAllBill()"/></td>
	</td>
  </tr>
</table>
	</center>
	<input type="hidden" name="facilityId" id="facilityId" id="facilityId" value="<%=facilityId%>"> 
	<input type="hidden" name="encounter_id" id="encounter_id" id="encounter_id" value="<%=encounter_id%>"> 
	<input type="hidden" name="ServiceSessionId" id="ServiceSessionId" id="ServiceSessionId" value="<%=SessionId%>"> 
	<input type="hidden" name="localeLang" id="localeLang" id="localeLang" value="<%=localeLang%>"> 
	<input type="hidden" name="WS_NO" id="WS_NO" id="WS_NO" value="<%=WS_NO%>">  
	<input type="hidden" name="loginUser" id="loginUser" id="loginUser" value="<%=loginUser%>">
	<input type="hidden" name="EpisodeType" id="EpisodeType" id="EpisodeType" value="<%=EpisodeType%>" > 
	<input type="hidden" name="logInWSno" id="logInWSno" id="logInWSno" value="<%=logInWSno%>"> 
	<input type="hidden" name="logInUserId" id="logInUserId" id="logInUserId" value="<%=logInUserId%>"> 
	<input type="hidden" name="PatientID" id="PatientID" id="PatientID" value="<%=PatientID%>"> 	
	<input type="hidden" name="EpisodeID" id="EpisodeID" id="EpisodeID" value="<%=EpisodeID%>">			
	<input type="hidden" name="VisitID" id="VisitID" id="VisitID" value="<%=VisitID%>"> 
	<input type="hidden" name="siteSpecPatPayable" id="siteSpecPatPayable" id="siteSpecPatPayable" value="<%=siteSpecPatPayable%>"> <!--V230222-->
	<input type="hidden" name="siteSpecSearch" id="siteSpecSearch" id="siteSpecSearch" value="<%=siteSpecSearch%>"> <!--V230529-->
	<input type="hidden" name="visit_Id" id="visit_Id" id="visit_Id" value="<%=visit_Id%>"> <!-- Added by Kamatchi S for TH-KW-CRF-0143-->
	<input type="hidden" name="limit" id="limit" id="limit" value="<%=limitId%>"> 
	
</body>
</html>

