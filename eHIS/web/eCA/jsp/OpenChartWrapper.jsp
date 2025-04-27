<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             	100            		?           created
01/11/2011    	IN29355        		Menaka      Manage Specimen>New List
												System not allow to record new list if orders were placed from Place Order function
25/01/2012	  	IN030563 & 			Ramesh G	When we place another Order of the same category the Pin No. is prompted again even if the
				IN030566						Patient chart is not closed.												
14/06/2012	  	IN033233			Menaka V	Patient chart does not open when selecting unassigned consultation patient from By location
												function.	
13/06/2013		IN038776			Ramesh G	This is a child cr for  MMS-QH-CRF- 0042 to cover the Billing related changes		
29/08/2013		IN042884			Ramesh G    A Validations on Doctor Consultation should not start if there are Unbilled and unsettled for the current encounter.
06/11/2013		IN042989			Chowminya   MMS-QH-CRF-0126.3 AE Parameter to check unbilled/unsettled amounts when opening up patient chart in CA
25/11/2013		IN045186			Chowminya   MMS-QH-CRF-0126.3 - linked_AE/CA pages reload issue 
27/11/2013		IN045246			Chowminya   MMS-QH-CRF-0126.3 - linked_Patient List By Bed/Bay Chart>System throws the warning message twice		
03/12/2013		IN045375			Chowminya   MMS-QH-CRF-0126.3 - linked_System overlaps OP Parameter settings and reflects AE Parameter settings	
16/12/2013      IN034536		Nijitha S		Bru-HIMS-CRF-133	
06/04/2015		IN048704		Nijitha S 		HSA-CRF-0175	
13/04/2015		IN054965			Nijitha						HSA-CRF-0175
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
26/10/2017		IN065070	Raja S		27/10/2017		Ramesh G			ML-MMOH-CRF-0623.1
05/03/2018		IN066859	Raja S		05/03/2018		Ramesh G			ML-MMOH-SCF-0948
25/06/2018		IN068016	Thamizh		26/06/2018							ML-MMOH-SCF-1028
18/10/2023     32902             Krishna Pranay    	     19/10/2023      Ramesh G      MMS-DM-CRF-0210	

---------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*, java.util.*,webbeans.eCommon.*,eCommon.Common.*,eCA.CAOpenChartServlet,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//Connection  con = null;//IN034536
	Connection  con = ConnectionManager.getConnection(request);//IN034536
	ResultSet rs = null;
	PreparedStatement stmt = null;

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;

	String locale = (String) p.getProperty("LOCALE");
	String practitioner_id		= checkForNull((String)session.getValue("ca_practitioner_id"));
	String from_service_yn		= checkForNull(request.getParameter("from_service_yn"));
	String from_module			= checkForNull(request.getParameter("from_module"));
	String patient_id			= checkForNull(request.getParameter("patient_id"));
	String accession_number		= checkForNull(request.getParameter("accession_number"));
	String accession_type		= checkForNull(request.getParameter("accession_type"));
	String called_function_id	= checkForNull(request.getParameter("called_function_id"));
	String strRelnReqYn			= checkForNull(request.getParameter("reln_ReqYn"));
	String strRelnYn			= checkForNull(request.getParameter("reln_Yn"));
	String patChartCalledFrm	= checkForNull(request.getParameter("patChartCalledFrm"));
	//IN034536 Starts
	String p_queue_date	= checkForNull(request.getParameter("p_queue_date"));
	String isPatientEncMovement	= checkForNull(request.getParameter("isPatientEncMovement"));
	
	boolean isPatMovement = false;
	if("".equals(isPatientEncMovement))
	{
		
		isPatMovement=eOP.QMSInterface.isSiteSpecific(con,"OP","PATENC_MOVEMENT");	
		
		isPatientEncMovement=Boolean.toString(isPatMovement);
	}
	String Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
	if("".equals(Sydate))
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		Sydate = dateFormat.format(cal.getTime());
		
	}
	//IN034536 Ends
	String patient_class		= "";
	String actionOnPendingBill	= ""; //[IN042884]
	//[IN030566] Starts

	//Added by Rameswar on 08-Feb-16 for GDOH-CRF-081
	Boolean isPracApplicable	= eOP.QMSInterface.isSiteSpecific(con, "AE","PRACT_MANDATORY_AE"); 
	//Added by Rameswar on 08-Feb-16 for GDOH-CRF-081
	try{			
		if((session.getAttribute("TEMP_PASS")!=null) && (session.getAttribute("TEMP_PASS")!="")){
			HashMap mHash = new HashMap();
			mHash = (HashMap) session.getAttribute("TEMP_PASS");
			if(mHash.containsKey(patient_id)){
				mHash.remove(patient_id);
			}
			session.setAttribute("TEMP_PASS",mHash);
		}
	}catch(Exception ee)
	{	
		out.println("Exception in OpenChartWrapper.jsp for TEMP_PASS Session-- "+ee.toString()+"--");
		ee.printStackTrace();
	}
	//[IN030566] Ends
	String loginUser			= checkForNull((String)session.getValue("login_user"));	
	String episode_id			= checkForNull(request.getParameter("encounter_id"));
		
	if(episode_id.equals("") )
		episode_id				=	checkForNull(request.getParameter("episode_id"));

	if(episode_id==null||episode_id.equals("null"))
	episode_id="";
	patient_class				= (from_module.equals("AE")?"EM":checkForNull(request.getParameter("patient_class")));
	
	String unAssigned_yn = request.getParameter("unAssigned_yn") == null ? "Y" : request.getParameter("unAssigned_yn");
	String fromNewFunction = request.getParameter("fromNewFunction") == null ? "N" : request.getParameter("fromNewFunction");
	String referral_id = request.getParameter("referral_id") == null ? "" : request.getParameter("referral_id");
	String ConsOrdChartYn = request.getParameter("ConsOrdChartYn") == null ? "N" : request.getParameter("ConsOrdChartYn");
	String practId_yn = "";
	//IN065070 Starts
	boolean isAEStartConsulation = false;
	isAEStartConsulation=CommonBean.isSiteSpecific(con,"AE","AE_START_CONSULTATION");	
	//IN065070 Ends

	HashMap sessionMainMap = new HashMap();
	ArrayList sessList = new ArrayList();
	
	try
	{	
		if(strRelnReqYn.equals("Y") )
		{
			if(strRelnYn.equals("Y"))
			{
				sessionMainMap = (HashMap) session.getAttribute("sessionMainMap"+session.getId()) == null ? new HashMap() : (HashMap) session.getAttribute("sessionMainMap"+session.getId());
					
				if(sessionMainMap == null || sessionMainMap.size() == 0)
					session.setAttribute("sessionMainMap"+session.getId(),new HashMap());

				sessList = (ArrayList) session.getAttribute("sessionList"+session.getId()) == null ? new ArrayList() : (ArrayList) session.getAttribute("sessionList"+session.getId());

				if(sessList == null || sessList.size() == 0)
					session.setAttribute("sessionList"+session.getId(),new ArrayList());
			}
		}
		else
		{
				sessionMainMap = (HashMap) session.getAttribute("sessionMainMap"+session.getId()) == null ? new HashMap() : (HashMap) session.getAttribute("sessionMainMap"+session.getId());
					
				if(sessionMainMap == null || sessionMainMap.size() == 0)
					session.setAttribute("sessionMainMap"+session.getId(),new HashMap());

				sessList = (ArrayList) session.getAttribute("sessionList"+session.getId()) == null ? new ArrayList() : (ArrayList) session.getAttribute("sessionList"+session.getId());

				if(sessList == null || sessList.size() == 0)
					session.setAttribute("sessionList"+session.getId(),new ArrayList());
		}
	
	}
	
	catch(Exception ee)
	{
		
		out.println("Exception 1 in OpenChartWrapper.jsp -- "+ee.toString()+"--");
		ee.printStackTrace();
	}
	%>	
	  
      <input type="hidden" id="practitioner_id"  name="practitioner_id" id="practitioner_id" value='<%=practitioner_id%>'><!-- 32902  --> 
     
      
<html>
<HEAD>
<%
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language=javascript src='../../eCommon/js/ValidateControl.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language=javascript src='../../eCA/js/CAMenu.js'></script>
<SCRIPT LANGUAGE="JavaScript">
async function patClick()
{
	var patient_id = document.WrapperPatCriteriaFrm.patient_id.value;
	var episode_id = document.WrapperPatCriteriaFrm.episode_id.value;
	var episode_visit_id = document.WrapperPatCriteriaFrm.episode_visit_id.value;
	var wname = patient_id + episode_id + episode_visit_id;
	var AEStartConsult_flag =<%=isAEStartConsulation%>;//Added for IN065070
	var obj = "";
	var tempVar = "";
	if(top.content!=null)
		obj = top.content.CommonToolbar;
	
	var winNameStr = "";
	var i = 0;
	
	var result = "T";
	if(top.content!=null && top.content.CommonToolbar != null )
	{		
		if(obj.pat_info != null)
		{
			var pat_info_temp = [];
			var j = 0;
			var tempStr = "";
			
			for(i=0;i<obj.pat_info.length;i++)
			{
				if(obj.pat_info[i].window_obj &&!obj.pat_info[i].window_obj.closed)
				{	
					pat_info_temp[j++] = obj.pat_info[i];
				}
			}
			obj.pat_info = pat_info_temp;	
			i = 0;
			
			<%
			for(int i=0; i< sessList.size();i++){%>
				tempStr = '<%=sessList.get(i)%>';
				if(wname == tempStr)
				{
					var element =  obj.pat_info[<%=i%>];
					if (typeof(element) != 'undefined' && element != null)
					{
						if(!obj.pat_info[<%=i%>].window_obj.closed)
						{	
							obj.pat_info[<%=i%>].window_obj.focus();
							result = "F";
						}
					}
				}
			<%}%>
		}
	}

	if(result == "T")
	{
		var episode_type = document.WrapperPatCriteriaFrm.episode_type.value;
		var location_type = document.WrapperPatCriteriaFrm.location_type.value;
		var location_code = document.WrapperPatCriteriaFrm.location_code.value;
		var age = document.WrapperPatCriteriaFrm.age.value;
		var sex = document.WrapperPatCriteriaFrm.sex.value;
		var dob = document.WrapperPatCriteriaFrm.dob.value;
		var room_num = document.WrapperPatCriteriaFrm.room_num.value;
		var bed_num = document.WrapperPatCriteriaFrm.bed_num.value;
		var patient_class = document.WrapperPatCriteriaFrm.patient_class.value;
		var physician_id = document.WrapperPatCriteriaFrm.physician_id.value;
		var discharge_date = document.WrapperPatCriteriaFrm.discharge_date.value;
		var episode_Status = document.WrapperPatCriteriaFrm.episode_Status.value;
		var visit_adm_date = document.WrapperPatCriteriaFrm.visit_adm_date.value;
		var queue_status = document.WrapperPatCriteriaFrm.queue_status.value;
		var consultDateTime = document.WrapperPatCriteriaFrm.consultDateTime.value;
		var cons_srvc_start_date_time = document.WrapperPatCriteriaFrm.cons_srvc_start_date_time.value;//IN066859
		//IN034536 Start
		var p_queue_date = document.WrapperPatCriteriaFrm.p_queue_date.value;
		var isPatientEncMovement = document.WrapperPatCriteriaFrm.isPatientEncMovement.value;
		var Sydate = document.WrapperPatCriteriaFrm.Sydate.value;	
		var curr_queue_status = document.WrapperPatCriteriaFrm.curr_queue_status.value; 
		//IN034536 Ends
		//Added by Rameswar on 08-Feb-16 for GDOH-CRF-081
		var isPracApplicable = document.WrapperPatCriteriaFrm.isPracApplicable.value;
		//patient_class condition added by Dharma against GDOH-SCF-0250 [IN:063706] on 13th Mar 2017
		if(isPracApplicable=="true" && curr_queue_status < 04 && physician_id !="" && patient_class=="EM"){
		physician_id="";
		}//Added by Rameswar on 08-Feb-16 for GDOH-CRF-081
		if(episode_visit_id == null || episode_visit_id =='null')
			episode_visit_id = '';
	
		if((physician_id==null || physician_id=='null' || physician_id  == "") && episode_type == "O")
		{ 
			if(self.document.WrapperPatCriteriaFrm.patient_class.value == 'EM')
			{	
				//IN042989 - Start
				var actionOnPendingBill = document.WrapperPatCriteriaFrm.actionOnPendingBill.value;
				var visit_status = document.WrapperPatCriteriaFrm.visit_status.value;
				var patient_class = document.WrapperPatCriteriaFrm.patient_class.value;
				var actionOnPendingBillfalg = false;

				if(actionOnPendingBill=="N")
				{
					actionOnPendingBillfalg = true;
				}else
				{
						actionOnPendingBillfalg = OPQBlValidation();	
				}

				if(actionOnPendingBillfalg)
				{	
					//old code - Start
					var features   = 'dialogHeight:700px; dialogWidth:1000px; dialogTop:150; status=no';
					var arguments  = '';					
					var queryString = "option_id=AEMODAL&patient_id="+patient_id + "&visit_id=" + episode_visit_id + "&episode_id=" + episode_id + "&encounter_id=" + episode_id + "&location_code=" + location_code + "&location_type=" + location_type + "&bed_no=" + bed_num + "&room_num=" + room_num + "&episode_type=" + episode_type + "&discharge_date=" + discharge_date + "&visit_adm_date=" + visit_adm_date + "&episode_Status=" + episode_Status + "&sex=" + sex + "&Age=" + age + "&Dob=" + dob + "&security_level=&protection_ind=&reln_req_yn=" + self.document.WrapperPatCriteriaFrm.reln_req_yn.value + "&patient_class=EM&PQ=Y&CA=Y&child_window=Y&practitioner_id=<%=practitioner_id%>&detail_fn=Y&fn=lower";		
					
					var retValAE = await top.window.showModalDialog('../../eAE/jsp/AEMPAllowedOperationMain.jsp?selection_mode=AssignTreatmentArea&' + queryString ,arguments,features);

				
					if(retValAE == '*ALL')
					{
						alert(getMessage("ATTEND_PRACT_NOT_ASSIGNED","CA"));
						return false;
					}
					if(retValAE != null && retValAE != '')
					{ 
						//IN065070 starts
						   //32902 start
	         	           var practitioner_id=document.getElementById("practitioner_id").value;
	         		     	var facility_id 	= document.WrapperPatCriteriaFrm.facility_id.value;
	         	        	var patientid = document.WrapperPatCriteriaFrm.patient_id.value;
	         	         var xmlStr ="<root><SEARCH ";
						 xmlStr += " p_action=\"IS_PAT_RESTRICTED\"";
						 xmlStr += " facility_id=\""+ facility_id + "\" ";
						 xmlStr += " patientid=\""+ patientid + "\" ";
						 xmlStr += " practitioner_id=\""+ practitioner_id + "\" ";
						 xmlStr +=" /></root>";
						 var temp_jsp="../../eCA/jsp/CAGetAcccessRightPatientDtl.jsp";
						 var xmlDoc = "";
						 var xmlHttp =new XMLHttpRequest();;
						 //xmlDoc.loadXML(xmlStr);
				
						 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						 xmlHttp.open("POST",temp_jsp,false);
						 xmlHttp.send(xmlDoc);
						 var responseText = xmlHttp.responseText;
						 var response = trimString(xmlHttp.responseText);
				         if(response == "Y"){
						 alert(getMessage("AC_RSTR_PAT_LMT_AUT","CA")); 
						 return;
						 } 
				         //32902  end
						if(AEStartConsult_flag)
						{
							var retVal;
							var dialogTop	= "150";
							var dialogHeight ="400px" ;
							var dialogWidth = "700px" ;
							var features	= "Width:" + dialogWidth +"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:"+dialogTop +"; scroll=no; status=no";
							var arguments	= "patChartCalledFrm=<%=patChartCalledFrm%>";
							//var returnVal = window.showModalDialog('../jsp/StartConsultationDialog.jsp?patChartCalledFrm=<%=from_module%>&p_queue_date="+p_queue_date+"&isPatientEncMovement=<%=isPatientEncMovement%>&Sydate=<%=Sydate%>',arguments,features); //Commented for IN065070
							var returnVal = await window.showModalDialog('../../eCA/jsp/StartConsultationDialog.jsp?pat_class=AE&patChartCalledFrm=<%=from_module%>&p_queue_date="+p_queue_date+"&isPatientEncMovement=<%=isPatientEncMovement%>&Sydate=<%=Sydate%>',arguments,features); //Modified for IN065070
							var patChartType = document.getElementById("CA_PATLIST_BY_LOCN_CHART_TYPE").value;
							if(returnVal!= undefined)
							{
								returnArray = returnVal.split("#");
								if(returnArray[1] == 'Yes')
								{
									var retVal		= new String();
									var dialogTop	= "";
									var dialogHeight= "15";                     
									var dialogWidth = "70";
									var status		= "no";
									var scroll		= "no";
									var features    = "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
									var arguments   = "";
		      						var parameters	= "p3="+episode_id+"&module_id=AE&p2="+patient_id;
									var action_url	="../../eOP/jsp/CallConsStart.jsp?"+parameters;  
									retVal = await window.showModalDialog(action_url,arguments,features);
									if(retVal == "Y")
									{
										window.location.href = window.location.href;
										document.getElementById('startConsYN').value='N';
									}else if(retVal == undefined || retVal == null || retVal=="N")
									{
										return;
									}
								}
								else if(returnArray[1] == 'No')
									document.getElementById('startConsYN').value='N';

								if(returnArray[0] == 'PCWOE')
									document.getElementById('episode_id').value='';
							}
							else if(returnVal == undefined || returnVal == null)
							{
								return;
							}
						}
						//IN065070 Ends
						document.WrapperPatCriteriaFrm.physician_id.value = retValAE;
						document.WrapperPatCriteriaFrm.Opphysician_id.value = '' ;
						self.document.WrapperPatCriteriaFrm.insert_op.value = 'N';
						self.document.WrapperPatCriteriaFrm.submit();
					//IN045186 - to reload the result page to refresh the status change from AE and CA - Start
						if(top.content.workAreaFrame != null && top.content.workAreaFrame != undefined)
						{	
							if(top.content.frames[3].frames[1].frames[0].name == "AEMPSearchCriteriaFrame")//IN045246
								top.content.frames[3].frames[1].frames[2].location.reload();//IN045246
							else	
								top.content.workAreaFrame.PatResultFr.location.reload();
						}
						else if(top.content.frames[1].name == "f_query_add_mod")//IN045246
							top.content.frames[1].frames[2].location.reload();	//IN045246	
					}else{						
						if(top.content.frames[1].name == "f_query_add_mod")
							top.content.frames[1].frames[2].location.reload();
						else if(top.content.frames[3].frames[1].frames[0].name == "AEMPSearchCriteriaFrame")//IN045246
							top.content.frames[3].frames[1].frames[2].location.reload();//IN045246
						else	
							top.content.workAreaFrame.PatResultFr.location.reload();	
					}
					//IN045186 - end
					//old code - End
				}else{
					return;
				}
				//IN042989 - End
			}
			else if(self.document.WrapperPatCriteriaFrm.patient_class.value == 'OP')
			{	
				var features   = 'dialogHeight:25; dialogWidth:45; dialogTop:180; status=no';
				var arguments  = '';
				//var queryString = "practitioner_id=<%=practitioner_id%>&p3=" + episode_id + "&patient_id=" + patient_id + "&locn_type=" + location_type + "&locn_code=" + location_code + "&p16="+visit_adm_date+"&module_id=CA&p10=A&visit_adm_date="+visit_adm_date + "&p15=" + escape(queue_status);//IN034536
				var queryString = "practitioner_id=<%=practitioner_id%>&p3=" + episode_id + "&patient_id=" + patient_id + "&locn_type=" + location_type + "&locn_code=" + location_code + "&p16="+visit_adm_date+"&module_id=CA&p10=A&visit_adm_date="+visit_adm_date + "&p15=" + escape(queue_status)+"&p1="+curr_queue_status+"&isPatientEncMovement="+isPatientEncMovement+"&Sydate="+Sydate;//IN034536
				var a = confirm(getMessage("PAT_UNASSIGN","CA"));
				if (a)
				{
					var retValOP = await window.showModalDialog("../../eOP/jsp/CallAssign.jsp?" + queryString, arguments, features);
					
					if(retValOP != null && retValOP != '' && retValOP !='ok')
					{					
						document.WrapperPatCriteriaFrm.physician_id.value = retValOP;
						document.WrapperPatCriteriaFrm.Opphysician_id.value =retValOP ;					
						self.document.WrapperPatCriteriaFrm.insert_op.value = 'N';

						if((document.WrapperPatCriteriaFrm.mngPatQueueYN.value == 'Y' && '<%=patChartCalledFrm%>' == 'OP') ||(document.WrapperPatCriteriaFrm.CAPatListLocn.value == 'Y' && '<%=patChartCalledFrm%>' == ''))
						{	
							var retVal;
							var dialogTop	= "150";
							var dialogHeight ="400px" ;
							var dialogWidth = "700px" ;
							var features	= "Width:" + dialogWidth +"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:"+dialogTop +"; scroll=no; status=no";
							var arguments	= "patChartCalledFrm=<%=patChartCalledFrm%>";
							//var returnVal = window.showModalDialog('../jsp/StartConsultationDialog.jsp?patChartCalledFrm=<%=patChartCalledFrm%>',arguments,features);//IN034536
							//var returnVal =  window.showModalDialog('../jsp/StartConsultationDialog.jsp?patChartCalledFrm=<%=patChartCalledFrm%>&p_queue_date="+p_queue_date+"&isPatientEncMovement=<%=isPatientEncMovement%>&Sydate=<%=Sydate%>',arguments,features);//IN034536//Commented for IN065070
							var returnVal = await window.showModalDialog('../../eCA/jsp/StartConsultationDialog.jsp?pat_class=OP&patChartCalledFrm=<%=patChartCalledFrm%>&p_queue_date="+p_queue_date+"&isPatientEncMovement=<%=isPatientEncMovement%>&Sydate=<%=Sydate%>',arguments,features);//Modified for IN065070
							var patChartType = document.getElementById("CA_PATLIST_BY_LOCN_CHART_TYPE").value;
							
							if(returnVal!= undefined)
							{
								returnArray = returnVal.split("#");
								if(returnArray[1] == 'Yes')
									document.getElementById('startConsYN').value='Y';
								else if(returnArray[1] == 'No')
									document.getElementById('startConsYN').value='N';
								if(returnArray[0] == 'PCWOE')
									document.getElementById('episode_id').value='';
								
								self.document.WrapperPatCriteriaFrm.submit();
							}
							else if(returnVal == undefined || returnVal == null)
							{
								return;
							}
						}//IN033233 Starts
						else
						{
							self.document.WrapperPatCriteriaFrm.submit();
						}//IN033233 Ends
					}
				}
			}
			else
			{	
				alert(getMessage("TRD_PTN_NO_PRACT",'CA'));			
				var queryString = "option_id=AE_ASSIGN_DA1&patient_id="+patient_id + "&visit_id=" + episode_visit_id + "&episode_id=" + episode_id + "&encounter_id=" + episode_id + "&location_code=" + location_code + "&location_type=" + location_type + "&bed_no=" + bed_num + "&room_num=" + room_num + "&episode_type=" + episode_type + "&discharge_date=" + discharge_date + "&visit_adm_date=" + visit_adm_date + "&episode_Status=" + episode_Status + "&sex=" + sex + "&Age=" + age + "&Dob=" + dob + "&security_level=&protection_ind=&reln_req_yn=" + self.document.WrapperPatCriteriaFrm.reln_req_yn.value + "&patient_class=EM&PQ=Y&CA=Y&child_window=Y&practitioner_id=<%=practitioner_id%>&detail_fn=Y&fn=lower&<%=request.getQueryString()%>";

				
				var action_url = '../../eCA/jsp/OpenChartWrapperPatListGetValues.jsp?' + queryString;					
				var htmlVal = "<html><head><link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link></head>"+
				"<body  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'><form name='form1' method='post' action='"+action_url+"' OnMouseDown='CodeArrest()' OnKeyDown='disableKeys()'>"+			
				 "</form></body></html>";
				top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',htmlVal);				
				top.content.messageFrame.document.form1.submit();
			}
		}
		else if('<%=unAssigned_yn%>' == "N")
		{
			var practId = self.document.WrapperPatCriteriaFrm.practId_yn.value;
			//IN048704 Starts
			var assign_confirm_referral_yn  = self.document.WrapperPatCriteriaFrm.assign_confirm_referral_yn.value;
			if(practId == 'Y')
			{
				if(assign_confirm_referral_yn == "Y")
				{	
					var dialogTop	= "150";
					var dialogHeight ="7" ;
					var dialogWidth = "20" ;
					var features	= "Width:" + dialogWidth +"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:"+dialogTop +"; scroll=no; status=no";
					
					var returnVal = await window.showModalDialog('../../eCA/jsp/AssignAndConfirmDialog.jsp',arguments,features);
					var arguments  = '';
					if(returnVal=='A')
					{
						self.document.WrapperPatCriteriaFrm.submit();
						//top.content.workAreaFrame.PatResultFr.location.reload();
					}
					else if(returnVal == 'AC')
					{
						self.document.WrapperPatCriteriaFrm.assignorConfirmKey.value = returnVal;
						self.document.WrapperPatCriteriaFrm.submit();
						//top.content.workAreaFrame.PatResultFr.location.reload();
					}
				}	
				else 
				{
					var a = confirm(getMessage("PAT_UNASSIGN","CA"));
					if(a)
					{
						self.document.WrapperPatCriteriaFrm.submit();
					}
				}
				//IN048704 Ends
			}
			else
				self.document.WrapperPatCriteriaFrm.submit();
		}
		else
		{	
			self.document.WrapperPatCriteriaFrm.insert_op.value = 'N';
			//[IN042884] Start.
			var actionOnPendingBill = document.WrapperPatCriteriaFrm.actionOnPendingBill.value;
			var visit_status = document.WrapperPatCriteriaFrm.visit_status.value;
			var patient_class = document.WrapperPatCriteriaFrm.patient_class.value;
			var actionOnPendingBillfalg = false;
			if(actionOnPendingBill=="N" || parseInt(visit_status) >=4 || patient_class!="OP"){
				actionOnPendingBillfalg = true;
			}else{				
				actionOnPendingBillfalg = OPQBlValidation();					
			}
			
			if(actionOnPendingBillfalg){	
			//[IN042884] End.
				if((document.WrapperPatCriteriaFrm.mngPatQueueYN.value == 'Y' && '<%=patChartCalledFrm%>' == 'OP') ||(document.WrapperPatCriteriaFrm.CAPatListLocn.value == 'Y' && '<%=patChartCalledFrm%>' == ''))
				{									
						if(patient_class == 'OP' && consultDateTime == "")
						{
								var retVal;
								var dialogTop	= "150";
								var dialogHeight ="5" ;
								var dialogWidth = "23" ;
								var features	= "Width:" + dialogWidth +"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:"+dialogTop +"; scroll=no; status=no";
								var arguments	= "patChartCalledFrm=<%=patChartCalledFrm%>";
								//var returnVal = window.showModalDialog('../jsp/StartConsultationDialog.jsp?patChartCalledFrm=<%=patChartCalledFrm%>',arguments,features);//IN034536
								//var returnVal = window.showModalDialog('../jsp/StartConsultationDialog.jsp?patChartCalledFrm=<%=patChartCalledFrm%>&p_queue_date="+p_queue_date+"&isPatientEncMovement=<%=isPatientEncMovement%>&Sydate=<%=Sydate%>',arguments,features);//IN034536   //Commented for IN065070
								var returnVal = await window.showModalDialog('../../eCA/jsp/StartConsultationDialog.jsp?pat_class=OP&patChartCalledFrm=<%=patChartCalledFrm%>&p_queue_date="+p_queue_date+"&isPatientEncMovement=<%=isPatientEncMovement%>&Sydate=<%=Sydate%>',arguments,features);//IN034536   //Modified for IN065070
								var patChartType = document.getElementById("CA_PATLIST_BY_LOCN_CHART_TYPE").value;

								if(returnVal!= undefined)
								{
									returnArray = returnVal.split("#");
									if(returnArray[1] == 'Yes')
										document.getElementById('startConsYN').value='Y';
									else if(returnArray[1] == 'No')
										document.getElementById('startConsYN').value='N';
									if(returnArray[0] == 'PCWOE')
										document.getElementById('episode_id').value='';
										
									
								}
								else if(returnVal == undefined || returnVal == null)
								{
									return;
								}
						}
					
				}
				//IN065070 starts
				//if(AEStartConsult_flag && patient_class == 'EM' &&  curr_queue_status != "04")//Commented for IN066859
				if(AEStartConsult_flag && patient_class == 'EM' &&  curr_queue_status < 04 && cons_srvc_start_date_time =="")//Modified for IN066859
				{
					if((document.WrapperPatCriteriaFrm.AE_CURR_EMR_PATIENT.value == 'Y' && '<%=from_module%>' == 'AE') ||(document.WrapperPatCriteriaFrm.AE_CA_PATLIST_BY_LOCN.value == 'Y' && '<%=from_module%>' == ''))
					{
							var retVal;
							var dialogTop	= "150";
							var dialogHeight ="5" ;
							var dialogWidth = "23" ;
							var features	= "Width:" + dialogWidth +"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:"+dialogTop +"; scroll=no; status=no";
							var arguments	= "patChartCalledFrm=<%=patChartCalledFrm%>";
							var returnVal = await window.showModalDialog('../../eCA/jsp/StartConsultationDialog.jsp?pat_class=AE&patChartCalledFrm=<%=from_module%>&p_queue_date="+p_queue_date+"&isPatientEncMovement=<%=isPatientEncMovement%>&Sydate=<%=Sydate%>',arguments,features);
							var patChartType = document.getElementById("CA_PATLIST_BY_LOCN_CHART_TYPE").value;
							if(returnVal!= undefined)
							{
								returnArray = returnVal.split("#");
								if(returnArray[1] == 'Yes')
								{
									var retVal		= new String();
									var dialogTop	= "";
									var dialogHeight= "15";                     
									var dialogWidth = "70";
									var status		= "no";
									var scroll		= "no";
									var features    = "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
									var arguments   = "";
		      						var parameters	= "p3="+episode_id+"&module_id=AE&p2="+patient_id;
	
									var action_url	="../../eOP/jsp/CallConsStart.jsp?"+parameters;  

									retVal = await window.showModalDialog(action_url,arguments,features);
	
									if(retVal == "Y")
									{
										window.location.href = window.location.href;
										document.getElementById('startConsYN').value='N';
									}else if(retVal == undefined || retVal == null || retVal=="N")
									{
										return;
									}
								}
								else if(returnArray[1] == 'No')
									document.getElementById('startConsYN').value='N';
								
								if(returnArray[0] == 'PCWOE')
									document.getElementById('episode_id').value='';
										
							}
							else if(returnVal == undefined || returnVal == null)
							{
								return;
							}


					}else if((document.WrapperPatCriteriaFrm.AE_CURR_EMR_PATIENT.value == 'N' || document.WrapperPatCriteriaFrm.AE_CURR_EMR_PATIENT.value == ''  && '<%=from_module%>' == 'AE') ||(document.WrapperPatCriteriaFrm.AE_CA_PATLIST_BY_LOCN.value == 'N' || document.WrapperPatCriteriaFrm.AE_CA_PATLIST_BY_LOCN.value == '' && '<%=from_module%>' == ''))
					{
							var retVal		= new String();
							var dialogTop	= "";
							var dialogHeight= "15";                     
							var dialogWidth = "70";
							var status		= "no";
							var scroll		= "no";
							var features    = "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
							var arguments   = "";
		      				var parameters	= "p3="+episode_id+"&module_id=AE&p2="+patient_id;
	
							var action_url	="../../eOP/jsp/CallConsStart.jsp?"+parameters;  

							retVal = await window.showModalDialog(action_url,arguments,features);
							if(retVal == "Y")
							{
								window.location.href = window.location.href;
								document.getElementById('startConsYN').value='N';
							}else if(retVal == undefined || retVal == null || retVal=="N")
							{
								return;
							}
					}


				}
				//IN065070 Ends
			//[IN042884] Start.	
			}else{
				return;
			}
			//[IN042884] End.
			self.document.WrapperPatCriteriaFrm.submit();
			
			//IN065070
		
				if('<%=from_module%>' == 'AE')
				{
					if(top.content.frames[1].frames[0] != null && top.content.frames[1].frames[0] != undefined)
					{	
						if(top.content.frames[1].frames[0].name == "AEMPSearchCriteriaFrame"){
							//top.content.frames[1].frames[1].location.reload();//Commented for IN068016
							top.content.frames[1].frames[1].location.href = top.content.frames[1].frames[1].location.href;//Modified for IN068016
						}
					}
				}
			//IN065070
		}
	}
}
//[IN042884] Start.
function OPQBlValidation(){

	
		var facility_id 	= document.WrapperPatCriteriaFrm.facility_id.value;
		var patient_id = document.WrapperPatCriteriaFrm.patient_id.value;
		var visit_id		= document.WrapperPatCriteriaFrm.visit_id.value;
		var episode_id_new	= document.WrapperPatCriteriaFrm.episode_id_new.value;
		var actionOnPendingBill = document.WrapperPatCriteriaFrm.actionOnPendingBill.value;	
		//IN042989 - Start
		var patient_class = document.WrapperPatCriteriaFrm.patient_class.value;
		var episode_type = "O";
		
		if(patient_class == "EM")
			episode_type = "E";
		//IN042989 - End
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr+=" facility_id=\""+facility_id+"\" ";
		xmlStr+=" p_patient_id=\""+patient_id+"\"";
		xmlStr+=" p_episode_type=\""+episode_type+"\" ";
		xmlStr+=" p_episode_id=\""+episode_id_new+"\"";
		xmlStr+=" p_visit_id=\""+visit_id+"\" ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		var url = "../../eCA/jsp/CABLValidation.jsp";
		xmlHttp.open("POST", url, false);
		xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
		xmlHttp.send(xmlDoc);	
		
		var unbilledArr = trim(xmlHttp.responseText).split("|");
		var p_unbilled_amt	= parseInt(unbilledArr[0]);
		var p_unsettled_amt	= parseInt(unbilledArr[1]);	
		if(p_unbilled_amt==0 && p_unsettled_amt==0){
			actionOnPendingBillfalg = true;
		}else{
			if(actionOnPendingBill=='W'){
				if(confirm(getMessage("UNSETTLED_UNBILLED_AMT_WARNING","OP"))){
					actionOnPendingBillfalg = true;
				}else
					actionOnPendingBillfalg = false;//IN045246
			}else{
				alert(getMessage("UNSETTLED_UNBILLED_AMT_STOP","OP"));
				actionOnPendingBillfalg = false;
			}
		}
	
	return actionOnPendingBillfalg;
}

function trim(str) {
        return str.replace(/^\s+|\s+$/g,"");
}
//[IN042884] End.
</SCRIPT>
<BODY CLASS="MESSAGE"  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='WrapperPatCriteriaFrm' id='WrapperPatCriteriaFrm' action='../../servlet/eCA.CAOpenChartServlet' method = 'post'  >
	<input type="hidden" name="visit_adm_date" id="visit_adm_date" value="">
	<input type="hidden" name="age" id="age" value="">
	<input type="hidden" name="dob" id="dob" value="">
	<input type="hidden" name="sex" id="sex" value="">		
	<input type="hidden" name="episode_type" id="episode_type" value="">
	<input type="hidden" name="visit_id" id="visit_id" value="">
	<input type="hidden" name="episode_id" id="episode_id" value="">
	<input type="hidden" name="patient_id" id="patient_id" value="">
	<input type="hidden" name="patient_class" id="patient_class" value="">
	<input type="hidden" name="location_type" id="location_type" value="">
	<input type="hidden" name="location_code" id="location_code" value="">
	<input type="hidden" name="room_num" id="room_num" value="">
	<input type="hidden" name="bed_num" id="bed_num" value="">
	<input type="hidden" name="physician_id" id="physician_id" value="">
	<input type="hidden" name="episode_Status" id="episode_Status" value="">
	<input type="hidden" name="discharge_date" id="discharge_date" value="">
	<input type="hidden" name="episode_visit_id" id="episode_visit_id" value="">      
	<input type="hidden" name="pline" id="pline" value="">
	<input type="hidden" name="security_level" id="security_level" value="">
	<input type="hidden" name="protection_ind" id="protection_ind" value="">        
	<input type="hidden" name="Opphysician_id" id="Opphysician_id" value="">
	<input type="hidden" name="reln_req_yn" id="reln_req_yn" value="">
	<input type="hidden" name="attending_doc" id="attending_doc" value="">
	<input type="hidden" name="insert_op" id="insert_op" value="N">        
	<input type="hidden" name="medical_team" id="medical_team" value="">
	<input type="hidden" name="queue_status" id="queue_status" value="">
	<input type="hidden" name="specialty_code" id="specialty_code" value="">
	<input type="hidden" name="reln_reqYn" id="reln_reqYn" value="<%=strRelnReqYn%>">
	<input type="hidden" name="reln_Yn" id="reln_Yn" value="<%=strRelnYn%>">
	<input type="hidden" name="from_service_yn" id="from_service_yn"		value="<%=from_service_yn%>">
	<input type="hidden" name="called_function_id" id="called_function_id"	value="<%=called_function_id%>">
	<input type="hidden" name="accession_number" id="accession_number"	value="<%=accession_number%>">
	<input type="hidden" name="accession_type" id="accession_type"		value="<%=accession_type%>">
	<input type="hidden" name="function_id" id="function_id"		value="<%=request.getParameter("function_id")%>">
	<input type="hidden" name="unAssigned_yn" id="unAssigned_yn"		value="<%=unAssigned_yn%>">
	<input type="hidden" name="referral_id" id="referral_id"		value="<%=referral_id%>">
	<input type="hidden" name="fromNewFunction" id="fromNewFunction"		value="<%=fromNewFunction%>">
	<input type="hidden" name="practId_yn" id="practId_yn"	value="">
	<input type="hidden" name="ConsOrdChartYn" id="ConsOrdChartYn"	value="<%=ConsOrdChartYn%>">
	<input type="hidden" name="startConsYN" id="startConsYN"	value="">
	<input type="hidden" name="consultDateTime" id="consultDateTime"	value="">
	<input type="hidden" name="mngPatQueueYN" id="mngPatQueueYN"	value="">
	<input type="hidden" name="CAPatListLocn" id="CAPatListLocn"	value="">
	<input type="hidden" name="CA_PATLIST_BY_LOCN_CHART_TYPE" id="CA_PATLIST_BY_LOCN_CHART_TYPE"	value="">
	<input type="hidden" name="MNG_PAT_QUEUE_CHART_TYPE" id="MNG_PAT_QUEUE_CHART_TYPE"	value="">
	<!--IN065070-->
	<input name='AE_CURR_EMR_PATIENT' id='AE_CURR_EMR_PATIENT' type='hidden' value=''/>
	<input name='AE_CURR_EMR_PATIENT_CHART_TYPE' id='AE_CURR_EMR_PATIENT_CHART_TYPE' type='hidden' value=''/>
	<input name='AE_CA_PATLIST_BY_LOCN' id='AE_CA_PATLIST_BY_LOCN' type='hidden' value=''/>
	<input name='AE_PATLIST_BY_LOCN_CHART_TYPE' id='AE_PATLIST_BY_LOCN_CHART_TYPE' type='hidden' value=''/>
	<!--IN065070-->
	<input type="hidden" name="patChartCalledFrm" id="patChartCalledFrm" value="<%=patChartCalledFrm%>">  <!-- IN038776-->
	<!--  [IN042884] Start.-->
	<input type="hidden" name="actionOnPendingBill" id="actionOnPendingBill"	value="">	
	<input type="hidden" name="facility_id" id="facility_id"	value=""> 
	<input type="hidden" name="episode_id_new" id="episode_id_new"	value="">
	<input type="hidden" name="visit_status" id="visit_status"	value="">
	<!--  [IN042884] End.-->
	<!--IN034536 Starts-->
	<input type="hidden" name="isPatientEncMovement" id="isPatientEncMovement" value='<%=isPatientEncMovement%>' >
	<input type="hidden" name="p_queue_date" id="p_queue_date" value="<%=p_queue_date%>" >
	<input type="hidden" name="cons_srvc_start_date_time" id="cons_srvc_start_date_time" value="" ><!--IN066859-->
	<input type="hidden" name="Sydate" id="Sydate" value="<%=Sydate%>" >
	<input type="hidden" name="curr_queue_status" id="curr_queue_status" value="">
	<!--IN034536 Ends -->
	<input type="hidden" name="assign_confirm_referral_yn" id="assign_confirm_referral_yn" value=""><!-- //IN048704-->
	<input type="hidden" name="assignorConfirmKey" id="assignorConfirmKey" value=""><!-- //IN048704-->

	<input type="hidden" name="isPracApplicable" id="isPracApplicable" value="<%=isPracApplicable%>"><!--Added by Rameswar on 08-Feb-16 for GDOH-CRF-081-->
</form>
</BODY>
<%
try
{	

	String facility_id			= checkForNull((String)session.getValue("facility_id"));

	String queue_status = "";
	String establish_reln_req_yn="";
	String ses_pract_id="";
	String ses_pract_name="";
	String ses_pract_type="";

	//con = ConnectionManager.getConnection(request);//IN034536
	out.println("<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script><script language='JavaScript'>");
	
	session.putValue("ca_patient_class",patient_class);  //[IN038776]
	if((patient_class.equals("OP") || patient_class.equals("EM")) && !episode_id.equals("") )
	{
		//String query = " select to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') ADM_VISIT_DATE, get_age(b.DATE_OF_BIRTH) AGE, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DOB, b.SEX, 'O' EPISODE_TYPE, a.ENCOUNTER_ID EPISODE_ID, A.PATIENT_ID, A.PATIENT_CLASS, 'C' LOCN_TYPE, A.ASSIGN_CARE_LOCN_CODE LOCN_CODE,A.ASSIGN_ROOM_NUM ROOM_NUM, A.ASSIGN_BED_NUM BED_NUM, A.ATTEND_PRACTITIONER_ID PHYSICIAN_ID, NVL2(A.ATTEND_PRACTITIONER_ID,'N','Y') UNASSIGN_PATIENT_YN, A.ATTEND_PRACTITIONER_ID ACTUAL_PHYSICIAN_ID, A.VISIT_STATUS VISIT_EPISODE_STATUS, to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, A.OP_EPISODE_VISIT_NUM VISIT_ID,  (SELECT QUEUE_STATUS FROM OP_PATIENT_QUEUE WHERE FACILITY_ID=A.FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID)  queue_status, A.SPECIALTY_CODE ,(select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) ESTABLISH_RELN_REQ_YN  from pr_encounter a, mp_patient b where A.facility_id=? AND A.ENCOUNTER_ID=? AND B.PATIENT_ID=A.PATIENT_ID ";
		//[IN042884] String query = " select to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') ADM_VISIT_DATE, get_age(b.DATE_OF_BIRTH) AGE, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DOB, b.SEX, 'O' EPISODE_TYPE, a.ENCOUNTER_ID EPISODE_ID, A.PATIENT_ID, A.PATIENT_CLASS, a.assign_care_locn_type LOCN_TYPE, A.ASSIGN_CARE_LOCN_CODE LOCN_CODE,A.ASSIGN_ROOM_NUM ROOM_NUM, A.ASSIGN_BED_NUM BED_NUM, A.ATTEND_PRACTITIONER_ID PHYSICIAN_ID, NVL2(A.ATTEND_PRACTITIONER_ID,'N','Y') UNASSIGN_PATIENT_YN, A.ATTEND_PRACTITIONER_ID ACTUAL_PHYSICIAN_ID, A.VISIT_STATUS VISIT_EPISODE_STATUS, to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, A.OP_EPISODE_VISIT_NUM VISIT_ID,  (SELECT QUEUE_STATUS FROM OP_PATIENT_QUEUE WHERE FACILITY_ID=A.FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID)  queue_status, A.SPECIALTY_CODE ,(select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) ESTABLISH_RELN_REQ_YN,visit_status_set_on_date from pr_encounter a, mp_patient b where A.facility_id=? AND A.ENCOUNTER_ID=? AND B.PATIENT_ID=A.PATIENT_ID ";//Modified by Menaka for issue IN29355
		//String query = " select to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') ADM_VISIT_DATE, get_age(b.DATE_OF_BIRTH) AGE, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DOB, b.SEX, 'O' EPISODE_TYPE, a.ENCOUNTER_ID EPISODE_ID, a.EPISODE_ID EPISODE_ID_NEW,a.VISIT_STATUS, A.PATIENT_ID, A.PATIENT_CLASS, a.assign_care_locn_type LOCN_TYPE, A.ASSIGN_CARE_LOCN_CODE LOCN_CODE,A.ASSIGN_ROOM_NUM ROOM_NUM, A.ASSIGN_BED_NUM BED_NUM, A.ATTEND_PRACTITIONER_ID PHYSICIAN_ID, NVL2(A.ATTEND_PRACTITIONER_ID,'N','Y') UNASSIGN_PATIENT_YN, A.ATTEND_PRACTITIONER_ID ACTUAL_PHYSICIAN_ID, A.VISIT_STATUS VISIT_EPISODE_STATUS, to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, A.OP_EPISODE_VISIT_NUM VISIT_ID,  (SELECT QUEUE_STATUS FROM OP_PATIENT_QUEUE WHERE FACILITY_ID=A.FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID)  queue_status, A.SPECIALTY_CODE ,(select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) ESTABLISH_RELN_REQ_YN,visit_status_set_on_date from pr_encounter a, mp_patient b where A.facility_id=? AND A.ENCOUNTER_ID=? AND B.PATIENT_ID=A.PATIENT_ID ";//[IN042884]//IN034536
		//String query = " select to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') ADM_VISIT_DATE, get_age(b.DATE_OF_BIRTH) AGE, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DOB, b.SEX, 'O' EPISODE_TYPE, a.ENCOUNTER_ID EPISODE_ID, a.EPISODE_ID EPISODE_ID_NEW,a.VISIT_STATUS, A.PATIENT_ID, A.PATIENT_CLASS, a.assign_care_locn_type LOCN_TYPE, A.ASSIGN_CARE_LOCN_CODE LOCN_CODE,A.ASSIGN_ROOM_NUM ROOM_NUM, A.ASSIGN_BED_NUM BED_NUM, A.ATTEND_PRACTITIONER_ID PHYSICIAN_ID, NVL2(A.ATTEND_PRACTITIONER_ID,'N','Y') UNASSIGN_PATIENT_YN, A.ATTEND_PRACTITIONER_ID ACTUAL_PHYSICIAN_ID, A.VISIT_STATUS VISIT_EPISODE_STATUS, to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, A.OP_EPISODE_VISIT_NUM VISIT_ID,  (SELECT QUEUE_STATUS FROM OP_PATIENT_QUEUE WHERE FACILITY_ID=A.FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID)  queue_status, A.SPECIALTY_CODE ,(select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) ESTABLISH_RELN_REQ_YN,visit_status_set_on_date,(SELECT TO_CHAR(QUEUE_DATE, 'dd/mm/yyyy') QUEUE_DATE FROM OP_PATIENT_QUEUE WHERE FACILITY_ID=A.FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID)  queue_date from pr_encounter a, mp_patient b where A.facility_id=? AND A.ENCOUNTER_ID=? AND B.PATIENT_ID=A.PATIENT_ID ";//[IN042884]//IN034536//Commented for IN066859
		String query = " select to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') ADM_VISIT_DATE, get_age(b.DATE_OF_BIRTH) AGE, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DOB, b.SEX, 'O' EPISODE_TYPE, a.ENCOUNTER_ID EPISODE_ID, a.EPISODE_ID EPISODE_ID_NEW,a.VISIT_STATUS, A.PATIENT_ID, A.PATIENT_CLASS, a.assign_care_locn_type LOCN_TYPE, A.ASSIGN_CARE_LOCN_CODE LOCN_CODE,A.ASSIGN_ROOM_NUM ROOM_NUM, A.ASSIGN_BED_NUM BED_NUM, A.ATTEND_PRACTITIONER_ID PHYSICIAN_ID, NVL2(A.ATTEND_PRACTITIONER_ID,'N','Y') UNASSIGN_PATIENT_YN, A.ATTEND_PRACTITIONER_ID ACTUAL_PHYSICIAN_ID, A.VISIT_STATUS VISIT_EPISODE_STATUS, to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, A.OP_EPISODE_VISIT_NUM VISIT_ID,  (SELECT QUEUE_STATUS FROM OP_PATIENT_QUEUE WHERE FACILITY_ID=A.FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID)  queue_status, A.SPECIALTY_CODE ,(select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) ESTABLISH_RELN_REQ_YN,visit_status_set_on_date,(SELECT TO_CHAR(QUEUE_DATE, 'dd/mm/yyyy') QUEUE_DATE FROM OP_PATIENT_QUEUE WHERE FACILITY_ID=A.FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID)  queue_date,(SELECT TO_CHAR(CONS_SRVC_START_DATE_TIME, 'dd/mm/yyyy') CONS_SRVC_START_DATE_TIME FROM OP_PATIENT_QUEUE WHERE FACILITY_ID=A.FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID) cons_srvc_start_date_time from pr_encounter a, mp_patient b where A.facility_id=? AND A.ENCOUNTER_ID=? AND B.PATIENT_ID=A.PATIENT_ID ";//Modified for IN066859
		stmt = con.prepareStatement(query);
		stmt.setString(1, facility_id);
		stmt.setString(2, episode_id);
		rs = stmt.executeQuery();

		if (rs.next())
		{	
				if(queue_status.equals ("01"))
				{				
					queue_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedIn.label","common_labels");
				}	

				else if(queue_status.equals("02"))
				{
				queue_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ArrivedatNS.label","ca_labels");
				}	

				else if(queue_status.equals("03"))
				{
					queue_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.InitChkUpORVtlSgnRec.label","op_labels");
				
				}
				else if(queue_status.equals("04"))
				{
				
				queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");
				}	

				else if(queue_status.equals("05"))
				{
				queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.UndergoingTrtORInvst.label","op_labels");
				}
				else if(queue_status.equals("06"))
				{
				queue_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.RetFrmInvest.label","op_labels");
				}	
			out.println("document.WrapperPatCriteriaFrm.visit_adm_date.value='" + checkForNull(rs.getString("ADM_VISIT_DATE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.age.value='" + checkForNull(rs.getString("AGE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.sex.value='" + checkForNull(rs.getString("SEX")) + "';");
			out.println("document.WrapperPatCriteriaFrm.episode_type.value='" + checkForNull(rs.getString("EPISODE_TYPE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.episode_id.value='" + checkForNull(rs.getString("EPISODE_ID")) + "';");
			out.println("document.WrapperPatCriteriaFrm.patient_id.value='" + checkForNull(rs.getString("PATIENT_ID")) + "';");
			out.println("document.WrapperPatCriteriaFrm.patient_class.value='" + checkForNull(rs.getString("PATIENT_CLASS")) + "';");
			out.println("document.WrapperPatCriteriaFrm.location_type.value='" + checkForNull(rs.getString("LOCN_TYPE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.location_code.value='" + checkForNull(rs.getString("LOCN_CODE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.room_num.value='" + checkForNull(rs.getString("ROOM_NUM")) + "';");
			out.println("document.WrapperPatCriteriaFrm.bed_num.value='" + checkForNull(rs.getString("BED_NUM")) + "';");
			out.println("document.WrapperPatCriteriaFrm.physician_id.value='" + checkForNull(rs.getString("PHYSICIAN_ID")) + "';");		
			out.println("document.WrapperPatCriteriaFrm.Opphysician_id.value='" + checkForNull(rs.getString("ACTUAL_PHYSICIAN_ID")) + "';");		
			out.println("document.WrapperPatCriteriaFrm.discharge_date.value='" + checkForNull(rs.getString("DISCHARGE_DATE_TIME")) + "';");		
			out.println("document.WrapperPatCriteriaFrm.episode_Status.value='" + checkForNull(rs.getString("VISIT_EPISODE_STATUS")) + "';");
			out.println("document.WrapperPatCriteriaFrm.dob.value='" + checkForNull(rs.getString("DOB")) + "';");
			out.println("document.WrapperPatCriteriaFrm.visit_id.value='" + checkForNull(rs.getString("VISIT_ID")) + "';");
			out.println("document.WrapperPatCriteriaFrm.insert_op.value='" + checkForNull(rs.getString("UNASSIGN_PATIENT_YN")) + "';");
			out.println("document.WrapperPatCriteriaFrm.queue_status.value='" + checkForNull(queue_status) + "';");
			out.println("document.WrapperPatCriteriaFrm.specialty_code.value='" + checkForNull(rs.getString("SPECIALTY_CODE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.consultDateTime.value='" + checkForNull(rs.getString("visit_status_set_on_date")) + "';");
			out.println("document.WrapperPatCriteriaFrm.episode_id_new.value='" + checkForNull(rs.getString("EPISODE_ID_NEW")) + "';"); //[IN042884]
			out.println("document.WrapperPatCriteriaFrm.visit_status.value='" + checkForNull(rs.getString("VISIT_STATUS")) + "';"); //[IN042884]
			out.println("document.WrapperPatCriteriaFrm.p_queue_date.value='" + checkForNull(rs.getString("queue_date")) + "';"); //IN034536
			out.println("document.WrapperPatCriteriaFrm.curr_queue_status.value='" + checkForNull(rs.getString("QUEUE_STATUS")) + "';"); //IN034536
			out.println("document.WrapperPatCriteriaFrm.cons_srvc_start_date_time.value='" + checkForNull(rs.getString("cons_srvc_start_date_time")) + "';"); //IN066859
			establish_reln_req_yn = (rs.getString("establish_reln_req_yn")==null?"":rs.getString("establish_reln_req_yn"));
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		
		//starts,DineshT,32881 
		//query = "select ca_patlist_by_locn,mng_pat_queue,CA_PATLIST_BY_LOCN_CHART_TYPE,MNG_PAT_QUEUE_CHART_TYPE from ca_cons_param";//commented for IN065070
		query = "select ca_patlist_by_locn,mng_pat_queue,CA_PATLIST_BY_LOCN_CHART_TYPE,MNG_PAT_QUEUE_CHART_TYPE,AE_CURR_EMR_PATIENT,AE_CURR_EMR_PATIENT_CHART_TYPE,AE_CA_PATLIST_BY_LOCN,AE_PATLIST_BY_LOCN_CHART_TYPE from ca_cons_param";//Modified for IN065070
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();

		if(rs.next())
		{
			out.println("document.WrapperPatCriteriaFrm.mngPatQueueYN.value='" + checkForNull(rs.getString("mng_pat_queue")) + "';");
			out.println("document.WrapperPatCriteriaFrm.CAPatListLocn.value='" + checkForNull(rs.getString("ca_patlist_by_locn")) + "';");
			out.println("document.WrapperPatCriteriaFrm.CA_PATLIST_BY_LOCN_CHART_TYPE.value='" + checkForNull(rs.getString("CA_PATLIST_BY_LOCN_CHART_TYPE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.MNG_PAT_QUEUE_CHART_TYPE.value='" + checkForNull(rs.getString("MNG_PAT_QUEUE_CHART_TYPE")) + "';");
			//IN065070 changes starts
			out.println("document.WrapperPatCriteriaFrm.AE_CURR_EMR_PATIENT.value='" + checkForNull(rs.getString("AE_CURR_EMR_PATIENT")) + "';");
			out.println("document.WrapperPatCriteriaFrm.AE_CURR_EMR_PATIENT_CHART_TYPE.value='" + checkForNull(rs.getString("AE_CURR_EMR_PATIENT_CHART_TYPE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.AE_CA_PATLIST_BY_LOCN.value='" + checkForNull(rs.getString("AE_CA_PATLIST_BY_LOCN")) + "';");
			out.println("document.WrapperPatCriteriaFrm.AE_PATLIST_BY_LOCN_CHART_TYPE.value='" + checkForNull(rs.getString("AE_PATLIST_BY_LOCN_CHART_TYPE")) + "';");
			//IN065070 changes ends
		}

		if(rs != null) 
			rs.close();
		if(stmt != null) 
			stmt.close();
		//ends,DineshT,32881 	
	}
	else if((patient_class.equals("IP") || patient_class.equals("DC")) && !episode_id.equals(""))
	{
		//String query =  " select to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') ADMISSION_DATE_TIME, get_age(b.DATE_OF_BIRTH) AGE, to_char(b.DATE_OF_BIRTH,'dd/mm/yyyy') DOB, B.SEX, 'I' EPISODE_TYPE, A.EPISODE_ID, A.PATIENT_ID, A.PATIENT_CLASS, 'W'  LOCN_TYPE, A.ASSIGN_CARE_LOCN_CODE  CUR_WARD_CODE, A.ASSIGN_ROOM_NUM CUR_ROOM_NUM, A.ASSIGN_BED_NUM CUR_BED_NUM, A.ATTEND_PRACTITIONER_ID CUR_PHYSICIAN_ID, A.ADT_STATUS, to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, A.SPECIALTY_CODE,(select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) ESTABLISH_RELN_REQ_YN  from pr_encounter a, mp_patient b where A.facility_id=? AND A.ENCOUNTER_ID=? AND B.PATIENT_ID=A.PATIENT_ID   ";
		String query =  " select to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') ADMISSION_DATE_TIME, get_age(b.DATE_OF_BIRTH) AGE, to_char(b.DATE_OF_BIRTH,'dd/mm/yyyy') DOB, B.SEX, 'I' EPISODE_TYPE, A.EPISODE_ID, A.PATIENT_ID, A.PATIENT_CLASS, 'W'  LOCN_TYPE, A.ASSIGN_CARE_LOCN_CODE  CUR_WARD_CODE, A.ASSIGN_ROOM_NUM CUR_ROOM_NUM, A.ASSIGN_BED_NUM CUR_BED_NUM, A.ATTEND_PRACTITIONER_ID CUR_PHYSICIAN_ID, A.ADT_STATUS, to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, A.SPECIALTY_CODE,(select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) ESTABLISH_RELN_REQ_YN,(select c.ASSGN_CONF_REF_YN from ca_encntr_param c ) ASSIGN_CONFIRM_REFERRAL_YN  from pr_encounter a, mp_patient b where A.facility_id=? AND A.ENCOUNTER_ID=? AND B.PATIENT_ID=A.PATIENT_ID   "; //IN048704
		stmt = con.prepareStatement(query);
		stmt.setString(1, facility_id);
		stmt.setString(2, episode_id);
		rs = stmt.executeQuery();
		if (rs.next())
		{	
			out.println("document.WrapperPatCriteriaFrm.visit_adm_date.value='" + checkForNull(rs.getString("ADMISSION_DATE_TIME")) + "';");
			out.println("document.WrapperPatCriteriaFrm.age.value='" + checkForNull(rs.getString("AGE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.sex.value='" + checkForNull(rs.getString("SEX")) + "';");
			out.println("document.WrapperPatCriteriaFrm.episode_type.value='" + checkForNull(rs.getString("EPISODE_TYPE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.episode_id.value='" + checkForNull(rs.getString("EPISODE_ID")) + "';");
			out.println("document.WrapperPatCriteriaFrm.patient_id.value='" + checkForNull(rs.getString("PATIENT_ID")) + "';");
			out.println("document.WrapperPatCriteriaFrm.patient_class.value='" + checkForNull(rs.getString("PATIENT_CLASS")) + "';");
			out.println("document.WrapperPatCriteriaFrm.location_type.value='" + checkForNull(rs.getString("LOCN_TYPE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.location_code.value='" + checkForNull(rs.getString("CUR_WARD_CODE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.room_num.value='" + checkForNull(rs.getString("CUR_ROOM_NUM")) + "';");
			out.println("document.WrapperPatCriteriaFrm.bed_num.value='" + checkForNull(rs.getString("CUR_BED_NUM")) + "';");
			out.println("document.WrapperPatCriteriaFrm.physician_id.value='" + checkForNull(rs.getString("CUR_PHYSICIAN_ID")) + "';");		
			out.println("document.WrapperPatCriteriaFrm.Opphysician_id.value='';");		
			out.println("document.WrapperPatCriteriaFrm.discharge_date.value='" + checkForNull(rs.getString("DISCHARGE_DATE_TIME")) + "';");		
			out.println("document.WrapperPatCriteriaFrm.episode_Status.value='" + checkForNull(rs.getString("ADT_STATUS")) + "';");
			out.println("document.WrapperPatCriteriaFrm.dob.value='" + checkForNull(rs.getString("DOB")) + "';");
			out.println("document.WrapperPatCriteriaFrm.visit_id.value='';");
			out.println("document.WrapperPatCriteriaFrm.insert_op.value='';");
			out.println("document.WrapperPatCriteriaFrm.specialty_code.value='" + checkForNull(rs.getString("SPECIALTY_CODE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.assign_confirm_referral_yn.value='" + checkForNull(rs.getString("ASSIGN_CONFIRM_REFERRAL_YN")) + "';");//IN048704

			establish_reln_req_yn = (rs.getString("establish_reln_req_yn")==null?"":rs.getString("establish_reln_req_yn"));
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();	
	}
	else if(!patient_id.equals("") && episode_id.equals(""))
	{
		String query =  " select sex, get_age(date_of_birth) age, TO_CHAR(date_of_birth,'DD/MM/YYYY') date_of_birth,(select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) ESTABLISH_RELN_REQ_YN  from mp_patient where patient_id=? ";
		stmt = con.prepareStatement(query);
		stmt.setString(1, patient_id);
		rs = stmt.executeQuery();
		//out.println("alert('####');");
		if (rs.next())
		{
			
			out.println("document.WrapperPatCriteriaFrm.patient_id.value='" + patient_id + "';");
			out.println("document.WrapperPatCriteriaFrm.age.value='" + checkForNull(rs.getString("AGE")) + "';");
			out.println("document.WrapperPatCriteriaFrm.sex.value='" + checkForNull(rs.getString("SEX")) + "';");
			out.println("document.WrapperPatCriteriaFrm.dob.value='" + checkForNull(rs.getString("date_of_birth")) + "';");
			out.println("document.WrapperPatCriteriaFrm.patient_class.value='XT';");
			out.println("document.WrapperPatCriteriaFrm.episode_Status.value='0';");
			out.println("document.WrapperPatCriteriaFrm.insert_op.value='N';");
			establish_reln_req_yn = (rs.getString("establish_reln_req_yn")==null?"":rs.getString("establish_reln_req_yn"));
		}
	
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	else
	{
		//out.println("alert('APP-002416 Parameters passed to the wrapper are not enough...');");
	}
	out.println("</script>");
    out.println("<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>");
		
	
	//stmt = con.prepareStatement("select func_role_id, practitioner_name, pract_type, c.ESTABLISH_RELN_REQ_YN from sm_appl_user a, am_practitioner_lang_vw b  ,ca_encntr_param c where b.practitioner_id=a.func_role_id and a.appl_user_id = ? and a.func_role ='P' and a.language_id = ?");	
	
	 ses_pract_id = (String)(session.getValue("ca_practitioner_id")==null?"":session.getValue("ca_practitioner_id"));
	 ses_pract_name=(String)(session.getValue("practitioner_name")==null?"":session.getValue("practitioner_name"));
	 ses_pract_type=(String)(session.getValue("practitioner_type")==null?"":session.getValue("practitioner_type"));
	if((ses_pract_id.equals(""))||(ses_pract_name.equals(""))||(ses_pract_type.equals("")))
	{
		stmt = con.prepareStatement("select func_role_id, AM_GET_DESC.AM_PRACTITIONER(a.func_role_id,?,'1') practitioner_name, pract_type,'N' TAB_MENU_YN , (select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) ESTABLISH_RELN_REQ_YN  from sm_appl_user a, am_practitioner b where b.practitioner_id=a.func_role_id and appl_user_id = ? and func_role ='P'");
	
	stmt.setString(1, locale);
	stmt.setString(2, loginUser);
	
	rs = stmt.executeQuery();
	if(rs.next())
	{
		String ca_practitioner_id = (rs.getString("func_role_id")==null?"":rs.getString("func_role_id"));
		String pract_type = (rs.getString("pract_type")==null?"":rs.getString("pract_type"));
		if(pract_type == null)	
			pract_type="";
		String practitioner_name = (rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name"));
		establish_reln_req_yn = (rs.getString("establish_reln_req_yn")==null?"":rs.getString("establish_reln_req_yn"));
		if(practitioner_name == null) 
			practitioner_name="";		
		if(ca_practitioner_id.equals(""))
		{
			out.println("<script>alert(getMessage('NO_USER_FOUND','CA'));</script>");
				if(from_service_yn.equals("Y")){
					out.println("<script>parent.window.close();</script>");	
				}else{
					out.println("<script>location.href='../../eCommon/jsp/dmenu.jsp'</script>");
				}
		}
		

		session.putValue("ca_practitioner_id",ca_practitioner_id);
	    session.putValue("practitioner_name",practitioner_name);
	    session.putValue("practitioner_type",pract_type);
		out.println("<script>");
		out.println("self.document.WrapperPatCriteriaFrm.reln_req_yn.value ='" + establish_reln_req_yn + "'");
		out.println("</script>");
	}
	} // end if
	else
	{

		out.println("<script>");
		out.println("self.document.WrapperPatCriteriaFrm.reln_req_yn.value ='" + establish_reln_req_yn + "'");
		out.println("</script>");
	
	}
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();

	String sqlCheck = "select 'Y' from PR_REFERRAL_REGISTER where REFERRAL_ID = ? and TO_PRACT_ID is null";
	stmt = con.prepareStatement(sqlCheck.toString());
	stmt.setString(1, referral_id);
					
	rs = stmt.executeQuery();
	if(rs.next())
	{
		practId_yn = rs.getString(1);
	}
%>
	<script>
		document.WrapperPatCriteriaFrm.practId_yn.value = '<%=practId_yn%>';
	</script>
<%
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	//[IN042884] Start...
	stmt = con.prepareStatement("SELECT ACTION_ON_PENDING_BILL FROM OP_PARAM WHERE OPERATING_FACILITY_ID=?");
	stmt.setString(1, facility_id);					
	rs = stmt.executeQuery();
	if(rs.next())	
		actionOnPendingBill = rs.getString(1);
	%>
	<script>
		document.WrapperPatCriteriaFrm.actionOnPendingBill.value = '<%=actionOnPendingBill%>';
		document.WrapperPatCriteriaFrm.facility_id.value = '<%=facility_id%>';
	</script>
	<%
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();	
	
	//[IN042884] End...
	
	//IN042989 - Start
	//IN045375 - Added if condition
	if("EM".equals(patient_class))
	{
		stmt = con.prepareStatement("SELECT ACTION_ON_PENDING_BILL FROM AE_PARAM WHERE OPERATING_FACILITY_ID=?");
		stmt.setString(1, facility_id);					
		rs = stmt.executeQuery();
		if(rs.next())	
			actionOnPendingBill = rs.getString(1);
		%>
		<script>
			document.WrapperPatCriteriaFrm.actionOnPendingBill.value = '<%=actionOnPendingBill%>';
			document.WrapperPatCriteriaFrm.facility_id.value = '<%=facility_id%>';
		</script>
		<%
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	//IN042989 - End
}
catch(Exception e)
{
	//out.println("Exception @ OpenChartWrapper->"+e.toString());//COMMON-ICN-0181
	out.println("Open the Error log for the StackTrace....");
	e.printStackTrace();
}
finally
{
	
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
%>
</HEAD>
</HTML>
<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
%>
<SCRIPT LANGUAGE="JavaScript">patClick();</SCRIPT>

