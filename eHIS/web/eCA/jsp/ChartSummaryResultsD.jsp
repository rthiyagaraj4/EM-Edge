<!--
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name       Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?          created
23/08/2011    IN:028353      Menaka     Incident No: 028353 - <System adds '0' before result of Auto
                                         report orders in Clinical Event History ( Flow sheet view ).> 
27/01/2012	  INO30714		Menaka V	THAI screen>View Clinical Event History>View>In the Recorded Clinical
										Note the name is not displayed in THAI 
20/06/2012	  IN033489		Menaka V	Report header blank in clinical event history.
21/11/2012	  IN035950		Nijitha		CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
										more appealing. Keeping the display of information more clear and visible.		
21/02/2013	  IN035924	  	Karthi L	 	CA View chart summary "RESULT WIDGET" should come blank if patient visit hospital after 6 month or 										time interval defined by customer(CHL-CRF-018)
08/03/2013	  IN038454		Karthi L	fix to avoid Null pointer exception
16/03/2013	  IN038508		Karthi L 	Data displayed is not as per setup in chart summary content.
14/05/2013	  IN037793		Karthi L	To be able to view the Specimen image attachment in 'Existing Orders' function and 'Clinical Event 									 History' function in OR and CA.
30/05/2013	  IN040237		Karthi L	Clicking on the icon, system is displaying error message.
17/06/2013	  IN040866		Karthi L	System is not displaying the Image in CA 
22/06/2013    IN040416		Nijitha S   CRF-OR-Bru-HIMS-CRF-052.1/02-System is not displaying 'View' hyperlink for the Laboratory Panel 								  Order 
24/06/2013	  IN041014		Karthi L	Resulted value is not displaying in Clinical event History 
21/11/2013    IN45102		Nijitha S   RL/OR-View Chart Summary 
18/12/2013	  IN042552		Ramesh G	Bru-HIMS-CRF-391 --- Notes Confidentiality
06/03/2014	 IN047501    Ramesh G	In Chartsummry Result widget: Wrong result numeric values are diaplyed foe some test which 		
											resulted for another different test.
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
06/03/2014	IN047204		Karthi L		07/03/2014		Ramesh 			Order result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to. 											
12/03/2014	IN047566		Akbar											Linked issue of Bru-HIMS-CRF-195.2-47204/01
19/03/2014	IN47847			Nijitha S										Order result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to
28/03/2014	BRUNEI LIVE ISSUE Karthi										Display hist_data_type result string in single line without using hyperlink
01/04/2014	IN048253			Karthi L		01/04/2014		Akbar			Getting Script error when click on External Application link icon.
15/05/2014	IN047205		Karthi L		16/05/2014		Ramesh			Changes to clinical event history and chart summary view - to provide link to the scanned document in clinical views
02/06/2014	IN037701		Nijitha												SKR-CRF-0036
09/06/2014	IN049533		Karthi L										DMS Document Uploaded is not displayed in chart summary
11/06/2014	IN049589[IN047205]		Karthi L								Document Uploaded cannot be viewed in another facility	
04/09/2014  PER0409			Akbar	     									Performance changes suggested by sunil
08/09/2014  IN050936		Chowminya										None of the order retrieving any image from RIS/PACS but already having order image in PACS
17/10/2014	IN050649		Karthi L										Record chart same time, system separate data of chart in view chart summary.
30/01/2015  IN053093		Nijitha S										ML-BRU-SCF-1515
19/03/2015	IN052800		Karthi L										If link image for Histology orderable, from CA, user not able to view the image. No link appear under View.
09/10/2015	IN055910		Karthi L										From Clinician Access, modified result shall be identified by include "!" in Blue color
25/01/2016	IN058139		Ramesh G										INT-CRF-BRU-CIS-005-US001
07/07/2017	IN064688		Raja S			08/07/2017		RameshG			ML-MMOH-SCF-0753
07/11/2017	IN064132		Raja S			07/11/2017		Ramesh G		ML-MMOH-CRF-0831
07/02/2018	IN065970		Vijayakumar K	07/02/2018		RameshGo		ML-BRU-SCF-1611.1 [IN:065970]
07/03/2018	IN065970		Vijayakumar K	07/03/2018		RameshGo		ML-BRU-SCF-1611.1 [IN:065970] reopen
19/03/2018	IN067037		Raja S			19/03/2018		Ramesh G		ML-BRU-SCF-1787
28/06/2018	IN065341		Prakash C		29/06/2018		Ramesh G 		MMS-DM-CRF-0115
12/11/2018	IN068797		Prakash C 		15/12/2018		Ramesh G		MMS-DM-SCF-0568
03/04/2019	IN069978        	Prakash C		03/04/2019	Ramesh G	MMS-ICN-00116
30/07/2019	IN070610		Dinesh T		30/07/2019		Ramesh G		TBMC-CRF-0011.1
03/02/2020	IN071561		SIVABAGYAM M	03/02/2020		RAMESH G		GHL-CRF-0558.1
15/12/2020	7902			Sivabagyam M	15/12/2020		Ramesh G		MMS-DM-CRF-0180.1
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
02/09/2021	14801			Ramesh 											SKR-SCF-1578
07/03/2022	27788			Ramesh Goli		07/03/2022		RAMESH G    	MMS-ME-SCF-0067	
23/06/2022	31688			Ramesh Goli		07/03/2022		RAMESH G    	NMC-JD-SCF-0288
16/08/2022	29803			Ramesh G 										ML-BRU-CRF-0635
08/08/2023  48184           Krishna Pranay   11/08/2023    RAMESH G       RL-COMMON-View Chart Summary(View Image)
------------------------------------------------------------------------------------------------------------------------------------------------------------
-->
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCA.*,java.math.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> <!--added eCA.* for IN035924 --> <!--IN064688 added math.* -->
<%@page import="java.util.*, eCA.*,eOR.*,eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCA.Common.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> <!--  IN052800 -->
<html>
<head> 

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//[IN035950] Starts
String p_called_from = (request.getParameter("p_called_from") == null) ? "" : request.getParameter("p_called_from");//IN037701
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!--IN037701-->
<%if(!"CA_SPC".equals(p_called_from)){%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%}%>
<%
String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
String content_ID = request.getParameter("content_ID");

//String facility_id= (String) session.getValue("facility_id");//IN035924 commented for IN065341
	
String sessionStyle = "";
if(!"".equals(prefStyleSheet)){
 sessionStyle=prefStyleSheet;
}

//[IN035950] Ends
	String title= request.getParameter("title")==null?"":request.getParameter("title");
%>
<title><%=title%></title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sessionStyle%>' type='text/css' />

<style>
A 
{ 
	text-decoration : none ;
}
.gridData1
{
	background-color: #FFFFFF;
	height:18px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 8pt;
	color: #000000;
	font-weight:normal;
	text-align:left;
	padding-left:10px;
	padding-right:10px;
	vertical-align:middle;
	border-bottom:0px;
	border-top:0px;
	border-left:0px;
	border-right:0px;
	border-style:solid;
}
.innerGrid
{
	background-color: #FFFFFF;
	height:18px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 8pt;
	color: #000000;
	font-weight:normal;
	text-align:left;
	vertical-align:middle;
	border-bottom:1px;
	border-top:0px;
	border-left:0px;
	border-right:0px;
	border-style:solid;
	border-color:#EEEEEE;
}
</style>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src="../../eCA/js/ResearchPatient.js" language="javascript"></script>
<script src="../../eCA/js/CAOpenExternalApplication.js" language="javascript"></script>
<script src='../../eXH/js/ExternalApplication.js' language='javascript'></script> <!-- added for IN047024 -->
<script src="../../eCommon/js/jquery-3.6.3.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- added for IN048253 -->
<script>

//function callResults(patient_id,title,reln_id)//INO30714 commented for IN038454
//function callResults(patient_id,title,reln_id,enc_id, facility_id, content_ID,p_called_from)//INO30714//Parameters facility and content_ID addd for IN038454//added p_called_from for IN037701
//function callResults(patient_id,title,reln_id,enc_id, facility_id, content_ID,p_called_from,RepDb,clob_data)//IN071561
async function callResults(patient_id,title,reln_id,enc_id, facility_id, content_ID,p_called_from,RepDb,clob_data,p_review_rad_yn)//IN071561
{
	var dialogHeight	= "60vh" ;
	var dialogWidth		= "60vw" ;
	var status			= "no";
	var scroll			= "yes";
	var dialogTop		= "140";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
	
	//retVal 			= window.showModalDialog('../../eCA/jsp/ChartSummaryResultsMain.jsp?patient_id='+patient_id+'&modal_yn=Y'+'&title='+encodeURIComponent(title,"UTF-8")+'&relationship_id='+reln_id,arguments,features);//INO30714
	
	//retVal 			= window.showModalDialog('../../eCA/jsp/ChartSummaryResultsMainD.jsp?patient_id='+patient_id+'&modal_yn=Y'+'&title='+encodeURIComponent(title,"UTF-8")+'&relationship_id='+reln_id+'&encounter_id='+enc_id,arguments,features);//INO30714// commented for IN038454
	//retVal 			= window.showModalDialog('../../eCA/jsp/ChartSummaryResultsMainD.jsp?patient_id='+patient_id+'&facility_id='+facility_id+'&content_id='+content_ID+'&modal_yn=Y'+'&title='+encodeURIComponent(title,"UTF-8")+'&relationship_id='+reln_id+'&encounter_id='+enc_id+'&p_called_from='+p_called_from,arguments,features);//IN038454//added p_called_from for IN037701
	//retVal 			= window.showModalDialog('../../eCA/jsp/ChartSummaryResultsMainD.jsp?patient_id='+patient_id+'&facility_id='+facility_id+'&content_id='+content_ID+'&modal_yn=Y'+'&title='+encodeURIComponent(title,"UTF-8")+'&relationship_id='+reln_id+'&encounter_id='+enc_id+'&p_called_from='+p_called_from+'&RepDb='+RepDb+'&clob_data='+clob_data,arguments,features);//IN065341//IN071561
	retVal 			= await top.window.showModalDialog('../../eCA/jsp/ChartSummaryResultsMainD.jsp?patient_id='+patient_id+'&facility_id='+facility_id+'&content_id='+content_ID+'&modal_yn=Y'+'&title='+encodeURIComponent(title,"UTF-8")+'&relationship_id='+reln_id+'&encounter_id='+enc_id+'&p_called_from='+p_called_from+'&RepDb='+RepDb+'&clob_data='+clob_data+'&p_review_rad_yn='+p_review_rad_yn,arguments,features);//IN065341//IN071561
	
}
function changeColor(obj)
{
	obj.cells[0].style.backgroundColor="#FFFFC0";
	obj.cells[1].style.backgroundColor="#FFFFC0";
	obj.cells[2].style.backgroundColor="#FFFFC0";
}
function changeColor1(obj,index)
{
	if(eval(document.getElementById("tab"+index).rows[1].style.display == 'none'))
	{
		obj.cells[0].style.backgroundColor="#FFFFFF";
		obj.cells[1].style.backgroundColor="#FFFFFF";
		obj.cells[2].style.backgroundColor="#FFFFFF";
	}
}
//function showDetails(index)//IN037701
function showDetailResult(index)//method name changed for IN037701
{
	if(eval(document.getElementById("tab"+index).rows[1].style.display == 'none'))
	{
		if(eval(document.getElementById("tab"+index).rows[1].cells[0].innerHTML != ''))
		{
			eval(document.getElementById("tab"+index).rows[1].style.display = 'inline');
			eval(document.getElementById("tab"+index).rows[1].cells[0].style.backgroundColor='#FFFFC0');
		}
	}
	else
		eval(document.getElementById("tab"+index).rows[1].style.display = 'none');
}
//IN058139 Stat.
//function openGrpah(index,patient_id,event_code,event_group,histRecType)
//function openGrpah(index,patient_id,event_code,event_group,histRecType,event_dateTime)commented for IN065341
//IN058139 End.
async function openGrpah(index,patient_id,event_code,event_group,histRecType,event_dateTime,RepDb,clob_data)//IN065341
{
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "90vw" ;
	var status			= "no";
	var dialogTop		= "";
	var arguments		= "" ;
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	//IN058139 Stat.
	//var action_url		=	'../../eCA/jsp/ChartSummaryResultsGraphMain.jsp?patient_id='+patient_id+'&event_code='+event_code+'&event_group='+event_group+'&histRecType='+histRecType;
	//var action_url		=	'../../eCA/jsp/ChartSummaryResultsGraphMain.jsp?patient_id='+patient_id+'&event_code='+event_code+'&event_group='+event_group+'&histRecType='+histRecType+'&event_dateTime='+event_dateTime;
	//IN058139 End.
	var action_url		=	'../../eCA/jsp/ChartSummaryResultsGraphMain.jsp?patient_id='+patient_id+'&event_code='+event_code+'&event_group='+event_group+'&histRecType='+histRecType+'&event_dateTime='+event_dateTime+'&RepDb='+RepDb+'&clob_data='+clob_data;
	var retVal=await top.window.showModalDialog(action_url,arguments,features);
}

function submitPrevNext(from, to)
{
	document.ChartSummResult_Form.from.value = from;
	document.ChartSummResult_Form.to.value = to; 
	document.ChartSummResult_Form.submit();
}

</script>
</head>
<%
	Properties p			= (Properties)session.getValue("jdbc");
	String locale			= (String) p.getProperty("LOCALE");
	Connection con			= null;
	PreparedStatement stmt	= null;
	ResultSet rs			= null;
	String viewconf_appl	= "X";
	StringBuffer sql		= new StringBuffer() ;	
	PreparedStatement pstmtImgView = null; // added for Bru-HIMS-CRF-052.1 [IN037793]
	ResultSet resImgView = null; // added for Bru-HIMS-CRF-052.1 [IN037793]
	int recCount = 0; // added for Bru-HIMS-CRF-052.1 [IN037793]
	PreparedStatement pstmtImgCount = null; // [IN037793]
	PreparedStatement pstmtPerFacId = null; // IN040866
	ResultSet rsetPerFacId = null;  // IN040866
	ResultSet rsetImgCount = null; // added for Bru-HIMS-CRF-052.1 [IN037793]
	String login_at_ws_no		= p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address");	// IN047204
	String login_user = (String)session.getValue("login_user"); // added for Bru-HIMS-CRF-052.1 [IN037793]
	PreparedStatement pstmtOrderId = null; // IN047204
	ResultSet rsetOrderId = null;  // IN047204
	
	String accessionNum	= "", histRecType = "", contrSysEventCode = "", contrSysId = "", eventTime = "";
	String histRecTypeDesc = "", eventClassDesc = "", eventGroupDesc = "", eventDesc = "";
	String textExist = "", histDataType = "", resultStr = "";
	//String resultNum = "", resultNumUom = "", normalLow = "",	normalHigh = "";	commented for IN047501
	String resultNumUom = "", normalLow = "",	normalHigh = "";			//included for IN047501	
	String histRecTypeDescPrev = "", eventGroupDescPrev = "", eventDatePrev = "", tempStrValue = "";
	String normalcyInd = "";
	String ext_image_appl_id = "", ext_image_obj_id = "";
	String color_cell_indicator = "";
	String descCellInd = "";
	String event_date = "";
	String eventTimePrev = "";
	String legend_type = "";
	String patient_class = "";
	String reported_by = "";
	String details1 = "";
	String event_code = "", event_group = "";
	String pend_review_yn = "";
	String result_num_prefix = "";
	String result_status = "";
	String resultStatus ="";//29803
	String normalcy_str = "";
	StringBuffer details = new StringBuffer();
	String resp_id		= (String)session.getValue("responsibility_id");
	String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String patient_id	= request.getParameter("patient_id");
//IN065341 starts
	String bean_id1 = "ca_CentralizedBean" ;
	String bean_name1 = "eCA.CentralizedBean";
	CentralizedBean bean1 = (CentralizedBean)getBeanObject( bean_id1, bean_name1, request ) ;
	bean1.setLanguageId(localeName);
	bean1.clear() ;
	bean1.setFunctionId(bean1.checkForNull(request.getParameter("function_id")));
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
	String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
	PreparedStatement pstmtImgView1 = null; //7902
	ResultSet resImgView1 = null;//7902
	String study_id="",ext_img_disable="",param_def_str="",ext_img_display="";//7902
	String enc_id="";
	 String facility_id="";
	 String scope_disp="D";
	 int no_of_days=3;
	if(called_from.equals("CDR")){
		 enc_id = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
		 facility_id=request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
	}else{
//IN065341 ends
		 enc_id = request.getParameter("encounter_id");
		 facility_id= (String) session.getValue("facility_id");
	}//IN065341
	//String enc_id = request.getParameter("encounter_id");//INO30714 commented for IN065341
	String ext_image_upld_id = ""; //Bru-HIMS-CRF-052.1  [IN037793]
	String ext_img_file_locn = ""; //Bru-HIMS-CRF-052.1  [IN037793]
	//IN064132 changes starts
	String resulted_practitioner = "";
	boolean isPracSiteSpecific = false;
	//IN064132 changes ends				
	//IN047204  - Start
	String dmsExternalLinkYN = ""; 
	String event_code_type = "";
	String order_typ_code = ""; 
	String access_no_rd 	= "";
	String order_id 	= ""; 
	String locn_code	= "";		
	String locn_type	= "";
	String loc_desc		= "";
	String visit_id		= "";
	String physician_id	= "";
	String admit_date	= "";
	String encntr_type	= "";
	HashMap extLinkHashMap = null;
	String event_dateTime = ""; //IN058139
	//IN047204 - End
	//Bru-HIMS-CRF-195.3 - IN047205 - Start
	eCA.CAExternalLinkDataDTO externalDataDTO = null;
	String ext_image_appli_id = "";
	String ext_image_obj_id_dms = "";
	String ext_image_source = "";
	String ext_srce_doc_ref_no = "";
	String ext_srce_doc_ref_line_no = "";
	ArrayList externalList = null;
	//Bru-HIMS-CRF-195.3 - IN047205 - End
	/*if(facility_id == null) { // added for IN038454 - START
		facility_id =  request.getParameter("facility_id") == null? "":request.getParameter("facility_id") ;
	}commented for IN064531*/
	if(content_ID == null){
		content_ID = request.getParameter("content_id") == null? "":request.getParameter("content_id");
	} // added for IN038454 - END
	eCA.PatientBannerGroupLine manageEmailBean = null; //IN052800
	
	String option_id= request.getParameter("option_id") == null? "":(String)request.getParameter("option_id") ; //27788
	String limit_function_id = request.getParameter("limit_function_id") == null? "":(String)request.getParameter("limit_function_id") ;  //27788
		
	//IN066119 starts
	String bean_id = "Or_ViewOrder" ;
	String bean_name = "eOR.ViewOrder";
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name,request ) ;
	String hideSpecimenType = "N";
	HashMap orParamFac = new HashMap();
	//IN066119 ends
	String enctr_id = "";//IN031989
	String fac_id="";//IN033489
	String modal_yn		= request.getParameter("modal_yn");
	if (modal_yn == null) modal_yn = "N";
	//IN037701 Starts
	if("CA_SPC".equals(p_called_from))
		modal_yn = "Y";
	//IN037701 Ends
	int i = 0, j = 0;
	if(resp_id == null)resp_id = "";

	int maxCount = 0;
	int start = 0 ;
    int end = 0 ;

	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 10 ;
    else
        end = Integer.parseInt( to ) ;
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<!-- 27788 Start. -->
<!-- <form name="ChartSummResult_Form" id="ChartSummResult_Form" action="ChartSummaryResultsD.jsp?<//%=request.getQueryString()%>" method="post"> -->
<form name="ChartSummResult_Form" id="ChartSummResult_Form" action="ChartSummaryResultsD.jsp" method="post">

<!-- 27788 End. -->

<%
	try
	{
		manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+enc_id,"eCA.PatientBannerGroupLine",session); //IN052800
		//IN070610, starts 
		ArrayList<String> funcIds = new ArrayList<String>();
		funcIds.add("UPLOAD_TR_CATEGORY_ORDERS");
		manageEmailBean.adapter.setSiteSpecific(funcIds,"OR");
		Boolean uploadFuncTrOrders = manageEmailBean.adapter.isSiteSpecific("UPLOAD_TR_CATEGORY_ORDERS");
		//IN070610, ends
		boolean restrict_rd	=false;	//IN071561
		
		// added below line for BRU-CRF-018 - IN035924 START
		StringBuffer encListBuf = new StringBuffer();
		ArrayList encounterList = null;
		CAEncounterList oEncounterList = new CAEncounterList();
		if(!called_from.equals("CDR")){//IN065341
			HashMap encounterMap = oEncounterList.getPatEncounterList(patient_id, facility_id, content_ID);
			 scope_disp = (String)encounterMap.get("SCOPE_DISP");
			Integer no_of_days_before = (Integer)encounterMap.get("NO_OF_DAYS");
			 no_of_days = no_of_days_before.intValue();
			encounterList = (ArrayList)encounterMap.get("ENC_LIST");
			dmsExternalLinkYN = oEncounterList.getExternalDmsLinkYN(facility_id); //IN047204 	
				
			if( no_of_days >= 1  &&  !"null".equals(scope_disp) &&  scope_disp.equalsIgnoreCase("P"))
			{
				Iterator iterator = encounterList.iterator();
				int index = 0;
				
				while(iterator.hasNext())
				{	
					index++;
					encListBuf.append("'");
					encListBuf.append(iterator.next());
					if(encounterList.size() >= index )
					{
						encListBuf.append("'");
					}
					
					if(encounterList.size() != index )
					{
						encListBuf.append(",");
					}
				}
			}
			else if(scope_disp.equalsIgnoreCase("P"))
			{
				encListBuf.append("'");
				encListBuf.append(enc_id);
				encListBuf.append("'");
			}
			
			// END - IN035924
			
			if(scope_disp.equalsIgnoreCase("D")) { //IN038508 - START
				no_of_days = 3;
			}
			else if(scope_disp.equalsIgnoreCase("P")) {
				no_of_days =no_of_days + 2;
			}  //IN038508 - END
		}//IN065341
		con	 = ConnectionManager.getConnection(request);
		//IN066119 STARTS
		orParamFac=bean.orParamFacility(con, facility_id);
		hideSpecimenType = (String)orParamFac.get("HIDE_SPECIMENTYPE");
		//IN066119 ENDS
		isPracSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","RESULTED_PRACTITIONER"); //Added for IN064132
		restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");//IN071561
		//IN065341 starts
			if(called_from.equals("CDR")){
				bean1.executeCDR(con,patient_id,enc_id,RepDb,"CR_ENCOUNTER_DETAIL_TXT");
			}
			//stmt = con.prepareStatement(" select GET_TASK_APPLICABILITY(?,NULL,?,?) from dual ");
			String  sql1="select GET_TASK_APPLICABILITY ##REPDB##(?,NULL,?,?) from dual ##REPDB##";
			sql1=sql1.replaceAll("##REPDB##",RepDb);
			stmt = con.prepareStatement(sql1);
		//IN065341 ends
		stmt.setString(1,"VIEW_CONF_RESULT");
		stmt.setString(2,resp_id);
		stmt.setString(3,reln_id);
		rs = stmt.executeQuery();
		if (rs.next())
			viewconf_appl = rs.getString(1);
		if (viewconf_appl == null) viewconf_appl = "X";
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		
	//IN065341 starts	
		//stmt = con.prepareStatement("select LEGEND_TYPE from CR_CLIN_EVENT_PARAM ");
		String  sql2="select LEGEND_TYPE from CR_CLIN_EVENT_PARAM##REPDB##";
		sql2=sql2.replaceAll("##REPDB##",RepDb);
		stmt = con.prepareStatement(sql2);
	//IN065341 ends
		rs = stmt.executeQuery();
		if (rs.next())
		{
			legend_type = rs.getString(1) == null ? "S" : rs.getString(1);
		}
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();

		//sql.append("SELECT event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time,B.short_desc hist_rec_type_desc, C.short_desc event_class_desc, DECODE(A.event_code,A.event_group,NULL,E.short_desc)  event_group_desc, d.short_desc event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX, A.result_num, A.result_num_uom, A.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,'"+locale+"','1') reported_by, d.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR  FROM CR_ENCOUNTER_DETAIL A ,CR_HIS_RECTYP_LNG_VW B,  CR_EVENT_CLASS_LANG_VW C,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e WHERE B.LANGUAGE_ID = ? AND B.hist_rec_type=A.hist_rec_type AND c.hist_rec_type=A.hist_rec_type AND C.event_class= A.event_class AND  C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = ?  AND d.hist_rec_type=A.hist_rec_type AND  d.event_code=A.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  E.LANGUAGE_ID(+)= ?  AND e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  and patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') from  or_order_category where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) where RANK_NO < 3	) AND a.event_class NOT IN ('CNS$' ,'RFS$', 'RFR$' )" );//IN033489
		//sql.append("SELECT event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time,B.short_desc hist_rec_type_desc, C.short_desc event_class_desc, DECODE(A.event_code,A.event_group,NULL,E.short_desc)  event_group_desc, d.short_desc event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX, A.result_num, A.result_num_uom, A.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,'"+locale+"','1') reported_by, d.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID  FROM CR_ENCOUNTER_DETAIL A ,CR_HIS_RECTYP_LNG_VW B,  CR_EVENT_CLASS_LANG_VW C,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e WHERE B.LANGUAGE_ID = ? AND B.hist_rec_type=A.hist_rec_type AND c.hist_rec_type=A.hist_rec_type AND C.event_class= A.event_class AND  C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = ?  AND d.hist_rec_type=A.hist_rec_type AND  d.event_code=A.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  E.LANGUAGE_ID(+)= ?  AND e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  and patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') from  or_order_category where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) where RANK_NO < "+no_of_days+"	) AND a.event_class NOT IN ('CNS$' ,'RFS$', 'RFR$' )" );//IN033489 //IN038508
		
		//sql.append("SELECT event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time,B.short_desc hist_rec_type_desc, C.short_desc event_class_desc, DECODE(A.event_code,A.event_group,NULL,E.short_desc)  event_group_desc, d.short_desc event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX, A.result_num, A.result_num_uom, A.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,'"+locale+"','1') reported_by, d.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID  FROM CR_ENCOUNTER_DETAIL A ,CR_HIS_RECTYP_LNG_VW B,  CR_EVENT_CLASS_LANG_VW C,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e WHERE B.LANGUAGE_ID = ? AND B.hist_rec_type=A.hist_rec_type AND c.hist_rec_type=A.hist_rec_type AND C.event_class= A.event_class AND  C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = ?  AND d.hist_rec_type=A.hist_rec_type AND  d.event_code=A.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  E.LANGUAGE_ID(+)= ?  AND e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  and patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') from  or_order_category where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) " );//IN033489 //IN038508 //Bru-HIMS-CRF-052.1 [IN037793]
		//PER0409 - removed locale from below query and included desc as sub query
		//sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, A.result_num, A.result_num_uom, A.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') reported_by, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type  FROM CR_ENCOUNTER_DETAIL A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') from  or_order_category where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) " );  //Bru-HIMS-CRF-052.1 [IN037793] - a.EVENT_CODE_TYPE added for IN047204//Commented for IN064132
		//sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, A.result_num, A.result_num_uom, A.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type  FROM CR_ENCOUNTER_DETAIL A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') from  or_order_category where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) " );  //Modified for IN064132 //commented for IN067037
		//sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type  FROM CR_ENCOUNTER_DETAIL A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') from  or_order_category where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) " );  //modified for IN067037
	//IN069978 starts	
		if(!called_from.equals("CDR")){	
			//IN070610, starts
//			sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER##REPDB## where patient_id= ? ) " );  //modified for IN065341
			if(uploadFuncTrOrders){
				//6484 Start.
				//sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER##REPDB## where patient_id= ? ) " );  //modified for IN065341
				sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0  or nvl(dbms_lob.getlength(compress_hist_data),0)>0)) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,a.result_status resultStatus  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER##REPDB## where patient_id= ? ) " );  //modified for IN065341
				//6484 End.
			}else{
				//6484 Start.
				//sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER##REPDB## where patient_id= ? ) " );  //modified for IN065341
				sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0  or nvl(dbms_lob.getlength(compress_hist_data),0)>0)) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type,a.result_status resultStatus  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER##REPDB## where patient_id= ? ) " );  //modified for IN065341
				//6484 End.
			}//IN070610, ends			
		}else{
			//IN070610, starts
//			sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID  from  PR_ENCOUNTER##REPDB## where patient_id= ? and encounter_id = ? " );  //modified for IN065341
			if(uploadFuncTrOrders){
				//6484 Start.
				//sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID  from  PR_ENCOUNTER##REPDB## where patient_id= ? and encounter_id = ? " );  //modified for IN065341
				sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and ( dbms_lob.getlength(hist_data)>0  or nvl(dbms_lob.getlength(compress_hist_data),0)>0)) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,a.result_status resultStatus  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID  from  PR_ENCOUNTER##REPDB## where patient_id= ? and encounter_id = ? " );  //modified for IN065341
				//6484 End.
			}else{
				//6484 Start.
				//sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID  from  PR_ENCOUNTER##REPDB## where patient_id= ? and encounter_id = ? " );  //modified for IN065341
				sql.append("SELECT TO_CHAR(event_date,'dd/mm/yyyy hh24:mi:ss')event_date ,a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time, TO_CHAR(event_date,'hh24:mi') event_time, (select short_desc from CR_HIS_RECTYP_LNG_VW ##REPDB## where LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (select short_desc from CR_EVENT_CLASS_LANG_VW ##REPDB## where language_id=? and event_class = a.event_class and hist_rec_type = a.hist_rec_type) event_class_desc, (select short_desc from CR_CLN_EVT_GRP_LANG_VW ##REPDB## where language_id=? and hist_rec_type = a.hist_rec_type and event_group = a.event_group and event_group_type=a.event_group_type)  event_group_desc, (select short_desc from CR_CLN_EVT_MST_LANG_VW ##REPDB## where language_id= ? and hist_rec_type = a.hist_rec_type and event_code=a.event_code and event_code_type=a.event_code_type) event_desc, a.hist_data_type, a.RESULT_NUM_PREFIX, DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(A.RESULT_NUM),TO_CHAR(A.RESULT_NUM,DECODE(A.RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW,DECODE(nvl(A.RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code and ( dbms_lob.getlength(hist_data)>0  or nvl(dbms_lob.getlength(compress_hist_data),0)>0)) ,'N') text_exisits   ,A.hist_rec_type   ,A.contr_sys_event_code   ,A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.performed_by_id,?,'1') reported_by,AM_GET_DESC.AM_PRACTITIONER##REPDB##(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner, a.event_code, A.event_group, nvl((select 'Y' from CA_RESULT_REVIEW_PEND_LOG##REPDB## where PRACT_ID = ? and  HIST_REC_TYPE=a.HIST_REC_TYPE and  CONTR_SYS_ID = a.CONTR_SYS_ID and ACCESSION_NUM = a.ACCESSION_NUM and EVENT_CODE = a.EVENT_CODE and rownum=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID, a.event_code_type,a.result_status resultStatus  FROM CR_ENCOUNTER_DETAIL##REPDB## A WHERE a.patient_id=? and a.hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE from  or_order_category##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' ) and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID  from  PR_ENCOUNTER##REPDB## where patient_id= ? and encounter_id = ? " );  //modified for IN065341
				//6484 End.
			}
			//IN070610, ends
		}	
	//IN069978 ends	
	//IN065341 starts	
		if(called_from.equals("CDR")){
			sql.append("	) AND a.event_class NOT IN ('CNS$' ,'RFS$', 'RFR$' )");
		}else{//IN065341 ends
			if(scope_disp.equalsIgnoreCase("C")){
				sql.append(" )AND a.event_class NOT IN ('CNS$' ,'RFS$', 'RFR$' )");
			}
			else {
				sql.append("where RANK_NO < "+no_of_days+"	) AND a.event_class NOT IN ('CNS$' ,'RFS$', 'RFR$' )");
			}
		}//IN065341
	//IN069978 starts
	//31688 Starts.
	/* 
		if (modal_yn.equals("N")){
			//sql.append(" and a.event_date in (select event_date from (select event_date, dense_rank() over (order by event_date desc) drank,rank() over (order by event_date desc) rank from cr_encounter_detail where patient_id=? and hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') from  or_order_category where PREFERRED_VIEW_RESULT_YN='Y' )) where rank<=10 OR drank<2) ");
			if(!called_from.equals("CDR")){	
				sql.append(" and a.event_date in (select event_date from (select event_date, dense_rank() over (order by event_date desc) drank,rank() over (order by event_date desc) rank from cr_encounter_detail##REPDB## where patient_id=? and hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE  from  or_order_category ##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' )) where rank<=10 OR drank<2) ");//IN065341
			}else{
				sql.append(" and a.event_date in (select event_date from (select event_date, dense_rank() over (order by event_date desc) drank,rank() over (order by event_date desc) rank from cr_encounter_detail##REPDB## where patient_id=? and encounter_id = ? and hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE  from  or_order_category ##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' )) where rank<=10 OR drank<2) ");//IN065341
			}
		}else{
	*/ //31688 End.
			if(called_from.equals("CDR")){
				sql.append(" and a.event_date in (select event_date from (select event_date, dense_rank() over (order by event_date desc) drank,rank() over (order by event_date desc) rank from cr_encounter_detail##REPDB## where patient_id=? and encounter_id = ? and hist_rec_type in  (select  nvl(HIST_REC_TYPE,'*') HIST_REC_TYPE  from  or_order_category ##REPDB## where PREFERRED_VIEW_RESULT_YN='Y' )) where rank<=10000 OR drank<10000) ");//IN065341
			}
	//	} //31688 
	//IN069978 ends	
		if (viewconf_appl.equals("X"))
			sql.append(" and (nvl(A.PROTECTION_IND,'N')!='Z' )  ");
	
		//sql.append(" and nvl(a.STATUS,'`') not in('S','E')  order by a.event_date desc,hist_rec_type,request_num_seq, event_group_desc,a.event_group,event_desc,a.event_code ");//CHL_CRF_EMR_0018
	
	/*	if(scope_disp.equalsIgnoreCase("D")){ // condition added for CHL-CRF-018 IN035924
			sql.append(" and nvl(a.STATUS,'`') not in('S','E') and encounter_id=? order by a.event_date desc,hist_rec_type,request_num_seq, event_group_desc,a.event_group,event_desc,a.event_code ");//CHL_CRF_EMR_0018
		}	*/ // commented for IN038508
		
		//IN042552 Start.
		String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");//IN042552
		//sql.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,a.event_group),'N')='Y' "); //IN042552    //PER0409
		//sql.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,?,?,a.performed_by_id,a.AUTHORIZED_BY_ID,a.event_group),'N')='Y' "); //IN042552    //PER0409
		//sql.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,?,?,a.performed_by_id,a.AUTHORIZED_BY_ID,a.event_group),'N')!='N' "); //Performance Issue in GHL [Ramesh]
		sql.append(" and nvl(ca_view_confidnt_event##REPDB## (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,?,?,a.performed_by_id,a.AUTHORIZED_BY_ID,a.event_group),'N')!='N' "); 
		//IN042552 End.
		//IN071561 STARTS
		 if(restrict_rd)
			   sql.append( " AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,'"+login_user+"')='N' ");
		//IN071561 ENDS
		if(scope_disp.equalsIgnoreCase("P") || scope_disp.equalsIgnoreCase("D"))  // condition added for CHL-CRF-018 IN035924
		{	
			//sql.append(" and nvl(a.STATUS,'`') not in('S','E') and encounter_id in("+encListBuf+") order by a.event_date desc,hist_rec_type,request_num_seq, event_group_desc,a.event_group,event_desc,a.event_code ");
			//sql.append(" and nvl(a.STATUS,'`') not in('S','E') order by a.event_date desc,hist_rec_type,request_num_seq, event_group_desc,a.event_group,event_desc,a.event_code ");//IN038508 - Commented for IN050649
			sql.append(" and nvl(a.STATUS,'`') not in('S','E') order by a.event_date desc,hist_rec_type, event_group_desc, a.event_group, request_num_seq, event_desc,a.event_code ");// modified for IN050649
		}	
		else if(scope_disp.equalsIgnoreCase("C")) // condition added for CHL-CRF-018 IN035924
		{
			//sql.append(" and nvl(a.STATUS,'`') not in('S','E') and encounter_id=?  and EVENT_DATE between (sysdate - ?) and sysdate order by a.event_date desc,hist_rec_type,request_num_seq, event_group_desc,a.event_group,event_desc,a.event_code "); - Commented for IN050649
			sql.append(" and nvl(a.STATUS,'`') not in('S','E') and encounter_id=?  and EVENT_DATE between (sysdate - ?) and sysdate order by a.event_date desc,hist_rec_type, event_group_desc, a.event_group, request_num_seq	,event_desc,a.event_code "); // modified for IN050649			
		}	
		
		//CHL_CRF_EMR_0018 Starts
		int indx=1;
		/*stmt=con.prepareStatement(sql.toString());
		stmt.setString(1,practitioner_id);
		stmt.setString(2,locale);
		stmt.setString(3,locale);
		stmt.setString(4,locale);
		stmt.setString(5,locale);
		stmt.setString(6,patient_id);
		stmt.setString(7,patient_id);
		if (modal_yn.equals("N"))
			stmt.setString(8,patient_id);*/
		// modified for CHL-CRF-018 IN035924	
	//IN065341 starts
		//stmt=con.prepareStatement(sql.toString());
		String result=sql.toString();
		result=result.replaceAll("##REPDB##",RepDb);
		result=result.replaceAll("##CLOB##",clob_data);
		stmt=con.prepareStatement(result);
	//IN065341 ends
		//PER0409 - start
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);//added for IN064132
		//PER0409 - end
		stmt.setString(indx++,practitioner_id);
		//PER0409 - start
		//stmt.setString(indx++,locale);
		//stmt.setString(indx++,locale);
		//stmt.setString(indx++,locale);
		//stmt.setString(indx++,locale);
		//PER0409 - end
		stmt.setString(indx++,patient_id);
		stmt.setString(indx++,patient_id);
		if(called_from.equals("CDR")){//IN069978 starts
			stmt.setString(indx++,enc_id);
		}//IN069978 ends
		//31688 Starts.
		/*
		if (modal_yn.equals("N"))
			stmt.setString(indx++,patient_id);
		if (modal_yn.equals("Y") && called_from.equals("CDR"))//IN069978 starts
			stmt.setString(indx++,patient_id);
		*/	
		//31688 End.
		if(called_from.equals("CDR")){
			stmt.setString(indx++,patient_id); //31688
			stmt.setString(indx++,enc_id);
		}//IN069978 ends
		//PER0409 - start
		stmt.setString(indx++,clinician_id);			
		stmt.setString(indx++,resp_id);			
		//PER0409 - end
		//if(scope_disp.equalsIgnoreCase("D") || scope_disp.equalsIgnoreCase("C")){ //condition added for CHL-CRF-018 IN035924
		if( scope_disp.equalsIgnoreCase("C")){
			stmt.setString(indx++,enc_id);			
		}
		if(scope_disp.equalsIgnoreCase("C")){ // added for CHL-CRF-018 IN035924
			stmt.setInt(indx++,no_of_days);			
		}		
		//CHL_CRF_EMR_0018 Ends
		rs = stmt.executeQuery();

		while(rs.next())
		{
			maxCount = maxCount+1;
		}
		if(rs!=null) rs.close();

		if(maxCount > 0)
		{
%>
			<table cellpadding='3' cellspacing='0' border='0' width='90%' align='center'>
			<tr>
			<td class='white' width='75%'></td> 
			<td  align='right' width='25%'>
<%
			//IN037701 Starts
			if(!"CA_SPC".equals(p_called_from))
			{//IN037701 Ends
			if ( !(start <= 1) )
			{
%>
				<A class="gridLink" HREF='javascript:submitPrevNext(<%=(start-10)%>,<%=(end-10)%>)'  text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
<%
			}
			if ( !( (start+10) > maxCount ) )
			{
%>
				<A class="gridLink" HREF='javascript:submitPrevNext(<%=(start+10)%>,<%=(end+10)%>)'  text-decoration='none'>&nbsp;<fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
<%
			
			}
			}//IN037701
%>
			</td>
			</tr>
			</table>
			<center>
			<table class='grid' width='100%' id='tb1' cellspacing='0' cellpadding='0'><tr>
<%
		rs = stmt.executeQuery();
		
		if(start > 0)
			for(int k=0;(k<start-1 && rs.next());k++);
		//IN037701 Starts	
		if("CA_SPC".equals(p_called_from))
		{
			start = 0;
			end = 0;
		}
		//IN037701 Ends
		while(rs.next() && (start <= end))
		{
			String resultNum = "";		//added for IN047501
			accessionNum = rs.getString("accession_num") == null ? "" : rs.getString("accession_num");
			histRecType = rs.getString("hist_rec_type") == null ? "" : rs.getString("hist_rec_type");
			contrSysEventCode = rs.getString("contr_sys_event_code") == null ? "" : rs.getString("contr_sys_event_code");
			contrSysId = rs.getString("contr_sys_id") == null ? "" : rs.getString("contr_sys_id");
			event_date = rs.getString("event_date_time") == null ? "" : rs.getString("event_date_time");
			event_dateTime =  rs.getString("event_date") == null ? "" : rs.getString("event_date"); //IN058139
			eventTime = rs.getString("event_time") == null ? "" : rs.getString("event_time");
			histRecTypeDesc = rs.getString("hist_rec_type_desc") == null ? "" : rs.getString("hist_rec_type_desc");
			eventClassDesc = rs.getString("event_class_desc") == null ? "" : rs.getString("event_class_desc");
			eventGroupDesc = rs.getString("event_group_desc") == null ? "" : rs.getString("event_group_desc");
			eventDesc = rs.getString("event_desc") == null ? "" : rs.getString("event_desc");
			textExist = rs.getString("text_exisits") == null ? "" : rs.getString("text_exisits");	
			histDataType = rs.getString("hist_data_type") == null ? "" : rs.getString("hist_data_type");	
			ext_image_appl_id = rs.getString("ext_image_appl_id") == null ? "" : rs.getString("ext_image_appl_id");	
			ext_image_obj_id	= rs.getString("ext_image_obj_id") == null ? "" : rs.getString("ext_image_obj_id");
			if(legend_type.equals("C"))
				color_cell_indicator = rs.getString("COLOR_CELL_IND") == null ? "" : rs.getString("COLOR_CELL_IND");
			else if(legend_type.equals("S"))
				color_cell_indicator = rs.getString("normal_range_symbol") == null ? "" : rs.getString("normal_range_symbol");
			descCellInd = rs.getString("DESC_CELL_IND") == null ? "" : rs.getString("DESC_CELL_IND");
			resultStr = rs.getString("result_str") == null ? "" : rs.getString("result_str");
			patient_class = rs.getString("PATIENT_CLASS") == null ? "" : rs.getString("PATIENT_CLASS");
			reported_by = rs.getString("reported_by") == null ? "" : rs.getString("reported_by");
			resulted_practitioner = rs.getString("resulted_practitioner") == null ? "" : rs.getString("resulted_practitioner"); //Added for IN064132
			event_code = rs.getString("event_code") == null ? "" : rs.getString("event_code");
			event_group = rs.getString("event_group") == null ? "" : rs.getString("event_group");
			pend_review_yn = rs.getString("pend_review_yn") == null ? "" : rs.getString("pend_review_yn");
			normalcyInd = rs.getString("normalcy_ind") == null ? "" : rs.getString("normalcy_ind");
			result_status = rs.getString("STATUS") == null ? "" : rs.getString("STATUS");
			resultStatus = rs.getString("resultStatus") == null ? "" : rs.getString("resultStatus"); //29803
			normalcy_str = rs.getString("NORMALCY_STR") == null ? "" : rs.getString("NORMALCY_STR");
			enctr_id = rs.getString("encounter_ID") == null ? "" : rs.getString("encounter_ID");//IN033489
			fac_id = rs.getString("FACILITY_ID") == null ? "" : rs.getString("FACILITY_ID");//IN033489
			event_code_type  = rs.getString("EVENT_CODE_TYPE")==null?"":rs.getString("EVENT_CODE_TYPE"); // IN047204
			// added for Bru-HIMS-CRF-052.1 [IN037793] - Start
			
			ext_image_upld_id = rs.getString("EXT_IMAGE_UPLD_ID") == null ? "" : rs.getString("EXT_IMAGE_UPLD_ID");
			//IN066119 starts
			if("Y".equals(hideSpecimenType) && "LBIN".equals(histRecType))
				resultStr ="";
			//IN066119 ends
				//7902 STARTS
				if(!ext_image_appl_id.equals("") && ext_image_appl_id.equals("CPACS"))
				{
				
					ext_img_disable="disabled";
					
					String paramQuery = "SELECT PARAM_DEF_STR  FROM CA_EXT_IMAGE_APPL_LANG_VW##REPDB## WHERE  EXT_IMAGE_APPL_ID=?";
					paramQuery = paramQuery.replaceAll("##REPDB##",RepDb);
					pstmtImgView1 = con.prepareStatement(paramQuery); 
					pstmtImgView1.setString(1,ext_image_appl_id);
					resImgView1 = pstmtImgView1.executeQuery();
					
					while(resImgView1.next())
					{
						param_def_str = resImgView1.getString("PARAM_DEF_STR") == null ? "" : resImgView1.getString("PARAM_DEF_STR");
					}
					if(pstmtImgView1!=null) pstmtImgView1.close();
					if(resImgView1!=null) resImgView1.close();
					
					if(!param_def_str.equals("") && param_def_str.contains("~STUDY_ID`")){	
						String studayQuery ="SELECT A.study_id  FROM or_order_line##REPDB## a, cr_encounter_detail##REPDB## b WHERE B.EXT_IMAGE_APPL_ID =? AND to_char(a.ext_appl_accession_num) = b.ext_image_obj_id AND b.ext_image_obj_id=?";
						studayQuery = studayQuery.replaceAll("##REPDB##",RepDb);
						pstmtImgView = con.prepareStatement(studayQuery); 
						pstmtImgView.setString(1,ext_image_appl_id);
						pstmtImgView.setString(2,ext_image_obj_id);
						resImgView = pstmtImgView.executeQuery();
						
						while(resImgView.next())
						{
							study_id = resImgView.getString("STUDY_ID") == null ? "" : resImgView.getString("STUDY_ID");
						}
						
						if(pstmtImgView!=null) pstmtImgView.close();
						if(resImgView!=null) resImgView.close();
					}
					
				}
				if(study_id.equals("null"))
					study_id="";
				if(!study_id.equals("") && param_def_str.contains("~STUDY_ID`"))
				{
					ext_img_disable="";
					ext_img_display="";
				} 
				else if(!study_id.equals("") && !param_def_str.contains("~STUDY_ID`"))
				{
					ext_img_disable="";
					ext_img_display="";
				} 
				else if(study_id.equals("") && param_def_str.contains("~STUDY_ID`")&& ext_image_appl_id.equals("CPACS"))
				{
					ext_img_disable="disabled";
					ext_img_display="Study ID not available, we cannot Proceed";
				}
				else if(study_id.equals("") && !param_def_str.contains("~STUDY_ID`"))
				{
					ext_img_disable="";
					ext_img_display="";
				}	//7902 ENDS
			if(!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) {
			//IN065341 starts	
				//pstmtImgView = con.prepareStatement("select EXT_IMAGE_FILE_LOCN_PARAM from CR_EXT_IMAGE_UPLD where EXT_IMAGE_UPLD_ID = ?"); 
				String sql3="select EXT_IMAGE_FILE_LOCN_PARAM from CR_EXT_IMAGE_UPLD ##REPDB## where EXT_IMAGE_UPLD_ID = ?";
				sql3=sql3.replaceAll("##REPDB##",RepDb);
				pstmtImgView = con.prepareStatement(sql3);
			//IN065341 ends
				pstmtImgView.setString(1,ext_image_upld_id);
				resImgView = pstmtImgView.executeQuery();
				//contrSysEventCode = event_group;//IN040416
				String recCountInt = "";
				String perfFacilityId = ""; //IN040866 
				while(resImgView.next())
				{
					ext_img_file_locn = resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM") == null ? "" : resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM");
				}
				//IN040866 - Start
			//IN065341 starts	
				//pstmtPerFacId = con.prepareStatement("select  distinct b.performing_facility_id from or_order_line a,or_order b where a.order_id = b.order_id and a.accession_num = ?"); 
				String sql4="select  distinct b.performing_facility_id from or_order_line ##REPDB## a,or_order ##REPDB## b where a.order_id = b.order_id and a.accession_num = ?";
				sql4=sql4.replaceAll("##REPDB##",RepDb);
				pstmtPerFacId = con.prepareStatement(sql4);
			//IN065341 ends			
				pstmtPerFacId.setString(1,ext_image_obj_id);
				rsetPerFacId = pstmtPerFacId.executeQuery();
				if(rsetPerFacId.next()){
					perfFacilityId = rsetPerFacId.getString("PERFORMING_FACILITY_ID") == null ? "":  rsetPerFacId.getString("PERFORMING_FACILITY_ID");
				}
				
				//IN040866 - End
				// IN052800 - Start
				if(perfFacilityId.equals("") || perfFacilityId == null){
					perfFacilityId = manageEmailBean.getOrderIdFromSpecimen(ext_image_obj_id);
				}
				//IN052800 - End
				//IN065970 starts
				//pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ?"); 
			//IN065341 starts	
				//pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where SPECIMEN_NO = ? and TEST_CODE = ?");
				String sql5="select count(*) from rl_specimen_image_dtls ##REPDB## where SPECIMEN_NO = ? and TEST_CODE = ?";
				sql5=sql5.replaceAll("##REPDB##",RepDb);
				pstmtImgCount = con.prepareStatement(sql5);
			//IN065341 ends
				//pstmtImgCount.setString(1,fac_id); commented for IN040866
				//pstmtImgCount.setString(1,perfFacilityId);// modified for IN040866
				//pstmtImgCount.setString(2,ext_image_obj_id);
				pstmtImgCount.setString(1,ext_image_obj_id);
				//pstmtImgCount.setString(3,contrSysEventCode); //IN040416
				//pstmtImgCount.setString(3,event_group);//IN040416
				//pstmtImgCount.setString(2,event_group);
				  pstmtImgCount.setString(2,event_code);//48184 As per discuss with lab.I have done changes

				//IN065970 ends
				rsetImgCount = pstmtImgCount.executeQuery();
				if(rsetImgCount.next()) 
				{
					recCount = rsetImgCount.getInt(1);
				}
				recCountInt = String.valueOf(recCount);
				//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",contrSysEventCode).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user).replace("~language_id#",locale);  //commented for IN040866
				//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",contrSysEventCode).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",login_user).replace("~language_id#",locale); // modified for IN040866 //IN040416
				//IN065970 reopen starts
				//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",login_user).replace("~language_id#",locale); //IN040416	
				//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user).replace("~language_id#",locale);
				  ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user).replace("~language_id#",locale);//48184 As per discuss with lab.I have done changes
                 //IN065970 reopen ends
				
				if(resImgView  != null) resImgView.close();
				if(pstmtImgView != null) pstmtImgView.close();

				if(rsetImgCount  != null)  rsetImgCount.close();
				if(pstmtImgCount  != null) pstmtImgCount.close();

				if(rsetPerFacId  != null) rsetPerFacId.close();
				if(pstmtPerFacId  != null) pstmtPerFacId.close();
			}	
			// End	
			if(patient_class.equals("OP"))
				patient_class =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
			else if(patient_class.equals("IP"))
				patient_class =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
			else if(patient_class.equals("EM"))
				patient_class =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
			else if(patient_class.equals("DC"))
				patient_class = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

			details.setLength(0);
			details1 = "";
			//IN064132 changes starts
			/*
			if(!reported_by.equals(""))
				details.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportedBy.label","common_labels") + " : " + reported_by);
			*/
			if(isPracSiteSpecific && "LBIN".equals(histRecType))
			{
				if(!resulted_practitioner.equals(""))
					details.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportedBy.label","common_labels") + " : " + resulted_practitioner);
			}
			else{
				if(!reported_by.equals(""))
					details.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportedBy.label","common_labels") + " : " + reported_by);
			}
			//IN064132 changes ends
			if(!patient_class.equals(""))
			{
				if(!(details.toString()).equals(""))
					details.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels") + " : " + patient_class);
				else
					details.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels") + " : " + patient_class);
			}

			if(pend_review_yn.equals("Y"))
			{
				eventDesc = "<b>" + eventDesc + "</b>";
				eventTime = "<b>" + eventTime + "</b>";
			}
			
			if(!event_date.equals("") && !locale.equals("en"))
				event_date = com.ehis.util.DateUtils.convertDate(event_date,"DMY","en",locale);
			
			if(!histRecTypeDesc.equals(histRecTypeDescPrev))
			{
				i++;
				if(sStyle.equals(prefStyleSheet) )
				{
				out.println("<tr><td VALIGN=top  class='gridData' style='background-color:#C0C0C0' colspan=3 nowrap><b>"+histRecTypeDesc+"</b>&nbsp&nbsp&nbsp&nbsp"+event_date+"</td></tr>");
				}else
				{
				out.println("<tr><td VALIGN=top  class='gridData' colspan=3 nowrap><b>"+histRecTypeDesc+"</b>&nbsp&nbsp&nbsp&nbsp"+event_date+"</td></tr>");
				}
			//	out.println("<td VALIGN=top class='gridData' colspan=3>"+event_date+"</td></tr>");
				if (!eventGroupDesc.equals(""))
				{
					out.println("<tr><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='50%'>"+eventGroupDesc+"</td>");
					out.println("<td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='15%'>"+eventTime+"</td><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='35%'>&nbsp;</td></tr>");
					out.println("<tr>");
					out.println("<td colspan='3'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");
					out.println("<td VALIGN=top  class='gridData1' width='50%'><img src='../../eCA/images/Arrow.gif' name='sub' alt='Sub' />&nbsp;&nbsp;&nbsp;"+eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>&nbsp;</td><td class='gridData1' width='35%'>");
				}
				else
				{
					out.println("<tr>");
					out.println("<td colspan='3'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");//IN037701
					out.println("<td VALIGN=top  class='gridData1' width='50%'>");
					out.println(eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>"+eventTime+"</td><td class='gridData1' width='35%'>");
				}
				j++;
				histRecTypeDescPrev = histRecTypeDesc;
				eventDatePrev = event_date;
				eventGroupDescPrev = eventGroupDesc;
				eventTimePrev = eventTime;
			}
			else if(!event_date.equals(eventDatePrev))
			{
				if(sStyle.equals(prefStyleSheet))
				{
				out.println("<tr><td VALIGN=top  class='gridData' style='background-color:#C0C0C0' colspan=3 nowrap><b>"+histRecTypeDesc+"</b>&nbsp&nbsp&nbsp&nbsp"+event_date+"</td></tr>");
				}else
				{
				out.println("<tr><td VALIGN=top  class='gridData' colspan=3 nowrap><b>"+histRecTypeDesc+"</b>&nbsp&nbsp&nbsp&nbsp"+event_date+"</td></tr>");
				}
				//out.println("<tr><td VALIGN=top class='gridData' colspan=3>"+event_date+"</td></tr>");
				if (!eventGroupDesc.equals(""))
				{
					out.println("<tr><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='50%'>"+eventGroupDesc+"</td>");
					out.println("<td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='15%'>"+eventTime+"</td><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='35%'>&nbsp;</td></tr>");
					out.println("<tr>");
					out.println("<td colspan='3'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");//IN037701
					out.println("<td VALIGN=top  class='gridData1' width='50%'><img src='../../eCA/images/Arrow.gif' name='sub' alt='Sub' />&nbsp;&nbsp;&nbsp;"+eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>&nbsp;</td><td class='gridData1' width='35%'>");
				}
				else
				{
					out.println("<tr>");
					out.println("<td colspan='3'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");//IN037701
					out.println("<td VALIGN=top  class='gridData1' width='50%'>");
					out.println(eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>"+eventTime+"</td><td class='gridData1' width='35%'>");
				}
				j++;
				eventDatePrev = event_date;
				eventGroupDescPrev = eventGroupDesc;
				eventTimePrev = eventTime;
			}
			else if(!eventGroupDesc.equals(eventGroupDescPrev) || !eventTime.equals(eventTimePrev))
			{
				if (!eventGroupDesc.equals(""))
				{
					out.println("<tr><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='50%'>"+eventGroupDesc+"</td>");
					out.println("<td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='15%'>"+eventTime+"</td><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='35%'>&nbsp;</td></tr>");
					out.println("<tr>");
					out.println("<td colspan='3'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");//IN037701
					out.println("<td VALIGN=top  class='gridData1' width='50%'><img src='../../eCA/images/Arrow.gif' name='sub' alt='Sub' />&nbsp;&nbsp;&nbsp;"+eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>&nbsp;</td><td class='gridData1' width='35%'>");
				}
				else
				{
					out.println("<tr>");
					out.println("<td colspan='3'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");//IN037701
					out.println("<td VALIGN=top  class='gridData1' width='50%'>");
					out.println(eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>"+eventTime+"</td><td class='gridData1' width='35%'>");
				}
				j++;
				eventGroupDescPrev = eventGroupDesc;
				eventTimePrev = eventTime;
			}
			else if(eventGroupDesc.equals(eventGroupDescPrev) && eventTime.equals(eventTimePrev))
			{
				if(!eventGroupDesc.equals(""))
				{	
					out.println("<tr>");
					out.println("<td colspan='3'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");//IN037701
					out.println("<td VALIGN=top  class='gridData1' width='50%'><img src='../../eCA/images/Arrow.gif' name='sub' alt='Sub' />&nbsp;&nbsp;&nbsp;"+eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>&nbsp;</td><td class='gridData1' width='35%'>");
				}
				else
				{
					out.println("<tr>");
					out.println("<td colspan='3'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");//IN037701
					out.println("<td VALIGN=top  class='gridData1' width='50%'>");
					out.println(eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>"+eventTime+"</td><td class='gridData1' width='35%'>");
				}
				j++;
			}
			else
			{
				out.println("<tr>");
				out.println("<td colspan='3'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");//IN037701
				out.println("<td VALIGN=top  class='gridData1' width='50%'>"+eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>"+eventTime+"</td><td class='gridData1' width='35%'>");
				j++;
			}
			//HSA-CRF-0257.1 - IN055910- Start
			if("LBIN".equalsIgnoreCase(histRecType) && "C".equalsIgnoreCase(result_status)) {
				out.println("<img src='../../eCA/images/modifiedresult.png' name='mod_result' alt='Result Modified'/>&nbsp;");
			}
			//HSA-CRF-0257.1 - IN055910- End
			if(histDataType.equals("NUM"))
			{
				result_num_prefix = rs.getString("result_num_prefix")==null?"":rs.getString("result_num_prefix");
				//IN064688 Changes Starts
				//resultNum = rs.getString("result_num")==null?"":rs.getString("result_num");//Menaka for IN:028353
				BigDecimal rm =rs.getBigDecimal("result_num");
				if(rm!=null)
				resultNum=rm.toString();
				else
				resultNum="";
				//IN064688 Changes Ends
				resultNumUom = rs.getString("result_num_uom")==null?"":rs.getString("result_num_uom");
				//IN064688 Changes starts
				//normalLow = rs.getString("NORMAL_LOW")==null?"":rs.getString("NORMAL_LOW");
				BigDecimal nl =rs.getBigDecimal("NORMAL_LOW");
				if(nl!=null)
				normalLow=nl.toString();
				else
				normalLow="";
				//normalHigh = rs.getString("NORMAL_HIGH")==null?"":rs.getString("NORMAL_HIGH");
				BigDecimal nh=rs.getBigDecimal("NORMAL_HIGH");
				if(nh!=null)
				normalHigh=nh.toString();
				else
				normalHigh="";
				//IN064688 Changes Ends
				//Added by Jyothi.G on 09/12/2010 to fix IN025310
				if(!normalLow.equals("") && !normalHigh.equals(""))
					details1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels") + " : " + normalLow + " " + resultNumUom +" to "+ normalHigh + " " + resultNumUom ;
				else if(!normalLow.equals(""))
					details1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels") + " : (>=" + normalLow + " " + resultNumUom + ")" ;
				else if(!normalHigh.equals(""))
					details1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels") + " : (<=" + normalHigh + " " + resultNumUom + ")" ;
				else
					details1 = "";

				if(!details1.equals(""))
					details1 = details1 + "<br>" + details.toString();
				else
					details1 = details.toString(); //END

				if(!color_cell_indicator.equals(""))
				{
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
					else
						out.println("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
				}
				else
				{
					if(normalcyInd.equals("."))
					{
						if(legend_type.equals("S"))
							out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
						else
							out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
					}
					else if(!normalLow.equals("") && !normalHigh.equals("") && !resultNum.equals(""))
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if((Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) && (Float.parseFloat(resultNum) <= 	Float.parseFloat(normalHigh)))
							{
								if(legend_type.equals("S"))
									out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
								else
									out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
							}
						}
					}
					else if(!normalLow.equals("") && normalHigh.equals("") && !resultNum.equals(""))//Added by Jyothi.G on 09/12/2010 to fix IN025310
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if(Float.parseFloat(resultNum) >= Float.parseFloat(normalLow))
							{
								if(legend_type.equals("S"))
									out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
								else
									out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
							}
						}
					}
					else if(normalLow.equals("") && !normalHigh.equals("") && !resultNum.equals(""))
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if(Float.parseFloat(resultNum) <= 	Float.parseFloat(normalHigh))
							{
								if(legend_type.equals("S"))
									out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
								else
									out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
							}
						}
					}//END
				}
				//IN067037 start 
				/*
				//IN053093 Starts	
				//CHANGED FOR NUMBERFORMATE EXCEPTION START
				if(!resultNum.equals(""))
				{
				if(Float.parseFloat(resultNum) < 1)
				{
					out.println("<b>"+result_num_prefix+Double.parseDouble(resultNum)+"</b>&nbsp;"+resultNumUom);
				}
				else
				{
					out.println("<b>"+result_num_prefix+resultNum+"</b>&nbsp;"+resultNumUom);
				}
				}
				//CHANGED FOR NUMBERFORMATE EXCEPTION end
				//IN053093 Ends
				*/
				if(!resultNum.equals(""))
					out.println("<b>"+result_num_prefix+resultNum+"</b>&nbsp;"+resultNumUom);

				//IN067037 ends
				if(!resultStr.equals(""))
				{
					if(resultStr.length() > 25){
						tempStrValue = resultStr.substring(0,24);
						resultStr = replaceSpecialChar(resultStr);
						out.println("<a class='' href=\"javaScript:ShowComments('"+resultStr+"')\" title='"+resultStr+"'>"+tempStrValue+"...</a>"); //14801  Added ShowComments 
					}else{
						out.println(resultStr);
					}
				}
				if(textExist.equals("Y"))
				{
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"')\" />");	//IN033489
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"')\" />");	//IN033489
					out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"','"+RepDb+"','"+clob_data+"')\" />");	//IN065341
				}
				//IN058139 Stat.
				//out.println("<img src='../../eCA/images/chart.gif' alt='Graph' onclick=\"openGrpah('"+j+"','"+patient_id+"','"+event_code+"','"+event_group+"','"+histRecType+"')\" />");
				//out.println("<img src='../../eCA/images/chart.gif' alt='Graph' onclick=\"openGrpah('"+j+"','"+patient_id+"','"+event_code+"','"+event_group+"','"+histRecType+"','"+event_dateTime+"')\" />");//IN058139
				out.println("<img src='../../eCA/images/chart.gif' alt='Graph' onclick=\"openGrpah('"+j+"','"+patient_id+"','"+event_code+"','"+event_group+"','"+histRecType+"','"+event_dateTime+"','"+RepDb+"','"+clob_data+"')\" />");//IN065341
			}
			else if(histDataType.equals("STR"))
			{	details1 = details.toString();
				if(!color_cell_indicator.equals(""))
				{	
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' ></font>&nbsp;");
					else
						out.println("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px'></font>&nbsp;");
				}
				else if(normalcyInd.equals("."))
				{
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
					else
						out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
				}
				if(resultStr.length() > 25)
				{
					tempStrValue = resultStr.substring(0,24);
					resultStr = replaceSpecialChar(resultStr);
					out.println("<a class='' href=\"javaScript:ShowComments('"+resultStr+"')\" title='"+resultStr+"'>"+tempStrValue+"...</a>"); //14801  Added ShowComments 
				}
				else
					out.println(resultStr);

				if(!normalcy_str.equals(""))
				{
					out.println(" <font color=blue>( Normal Value : "+normalcy_str+" )</font>");
				}
				
				if(textExist.equals("Y"))
				{
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"')\" />");//IN033489
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"')\" />");//IN033489					
					out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"','"+RepDb+"','"+clob_data+"')\" />");//IN065341
					
				}
			}
			else if(histDataType.equals("TXT")||histDataType.equals("HTM"))
			{
				if(!color_cell_indicator.equals(""))
				{
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' ></font>&nbsp;");
					else
						out.println("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px'></font>&nbsp;");
				}
				else if(normalcyInd.equals("."))
				{
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
					else
						out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
				}
				details1 = details.toString();
				if(!histRecType.equals("CLNT")&& histDataType.equals("TXT"))
				{
					//out.println("Result Text:");
				}
				//added for IN041014 - Start

				out.println("<b>"+resultNum+"</b>&nbsp;");//Commented for IN45102   // uncommented for IN047501
				
				if(!resultStr.equals(""))
				{
					//out.println("<b>"+resultNum+"</b>&nbsp;");//Added for IN45102    // commented for IN047501
					/*if(resultStr.length() > 25){
						tempStrValue = resultStr.substring(0,24);
						resultStr = replaceSpecialChar(resultStr);
						out.println("<a class='' href=\"javaScript:ShowComments('"+resultStr+"')\" title='"+resultStr+"'>"+tempStrValue+"...</a>"); //14801  Added ShowComments 
					}else{ 
						out.println(resultStr);
					}  
					*///commentd for BRUNEI LIVE ISSUE
				}
				
				//IN041014 - End
				if(textExist.equals("Y"))
				{
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"')\" />");//IN033489
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"')\" />");//IN033489					
					out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"','"+RepDb+"','"+clob_data+"')\" />");//IN065341
				}
			}

			/*if(!ext_image_appl_id.equals(""))
			{
				out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+ext_image_appl_id+"')\">");	
			}*/
			//Added condition for EMG
			if ( (ext_image_appl_id != null && (!ext_image_appl_id.equals(""))))  
			{
				if(!("DMS").equals(ext_image_appl_id)) { // IN049533
					if(!("DOCUL").equals(ext_image_appl_id) && (ext_image_upld_id.equals(null) || ext_image_upld_id.equals("")))  // modified for IN040237 - START
				//	if(!("DOCUL").equals(ext_image_appl_id)) // modified for IN040237
					{	
					//IN068797 starts	
						//IN050936 included patient_id
						//out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+ext_image_obj_id+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"')\">");
						//out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+ext_image_obj_id+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"','','','','"+RepDb+"','"+clob_data+"','"+facility_id+"')\">");//7902
						out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' "+ext_img_disable+" onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+ext_image_obj_id+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"','','','','"+RepDb+"','"+clob_data+"','"+facility_id+"')\"  alt='"+ext_img_display+"' >");//7902
					//IN068797 ends	
						//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+ext_image_obj_id+"','"+contrSysEventCode+"','"+ext_image_appl_id+"')\">");	

						//out.println("<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_image_obj_id+"','"+contrSysEventCode+"','','','"+recCount+"','"+facility_id+"')\"> View Image </a>");
					}
					else if (ext_image_upld_id.equals(null) || ext_image_upld_id.equals(""))
					{ 	
						//IN050936 included patient_id
					//IN068797 starts	
						//out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"')\">");
						//out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+ext_image_obj_id+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"','','','','"+RepDb+"','"+clob_data+"','"+facility_id+"')\">");//7902
						out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' "+ext_img_disable+" onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"','','','','"+RepDb+"','"+clob_data+"','"+facility_id+"')\"  alt='"+ext_img_display+"' >");//7902
					//IN068797 ends
					}
					else if((!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) && recCount > 0) {
					//out.println("<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_image_obj_id+"','"+contrSysEventCode+"','','','"+recCount+"','"+facility_id+"')\"> View Image </a>");
					out.println("<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_img_file_locn+"')\"><br></br> View Image </a>");
					}
				}	// IN049533
			} //END
			/* commented for IN040237
			// added for Bru-HIMS-CRF-052.1 [IN037793]
			if((!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) && recCount > 0) {
				//out.println("<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_image_obj_id+"','"+contrSysEventCode+"','','','"+recCount+"','"+facility_id+"')\"> View Image </a>");
				out.println("<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_img_file_locn+"')\"> View Image </a>");
			}
			*/
			// added for IN047204 - Start
			if("Y".equals(dmsExternalLinkYN)) {// && "RD".equals(event_code_type)) { // commented for  Bru-HIMS-CRF-195.3 - IN047205 
				extLinkHashMap = oEncounterList.getExternalLinkParameters(facility_id, patient_id, enctr_id, locale); 
				admit_date	= (String) extLinkHashMap.get("P_ENCNTR_DATE");
				locn_code	= (String) extLinkHashMap.get("P_LOCN_CODE");
				locn_type	= (String) extLinkHashMap.get("P_LOCN_TYPE");
				visit_id	= (String) extLinkHashMap.get("P_VISIT_ID");
				loc_desc	= (String) extLinkHashMap.get("P_LOC_DESC");
				physician_id	= (String) extLinkHashMap.get("P_PHYSICIAN_ID");
				encntr_type	= (String) extLinkHashMap.get("P_EPISODE_TYPE");
				externalList = oEncounterList.getExternalLinkdata(histRecType, contrSysId, accessionNum, contrSysEventCode); //Bru-HIMS-CRF-195.3 - IN047205 - Start
				Iterator iter = externalList.iterator(); 
				while(iter.hasNext()){
					externalDataDTO = (eCA.CAExternalLinkDataDTO)iter.next();
					ext_image_appli_id = externalDataDTO.getExt_image_appl_id();
					ext_image_obj_id_dms = externalDataDTO.getExt_image_obj_id();
					ext_image_source = externalDataDTO.getExt_image_source();
					ext_srce_doc_ref_no = externalDataDTO.getSrce_doc_ref_no();
					ext_srce_doc_ref_line_no = externalDataDTO.getSrce_doc_ref_line_no();	
				
					if("RD".equals(event_code_type)) { 		//Bru-HIMS-CRF-195.3 - IN047205 - End
						//Fix for IN047566/Start
						//access_no_rd 	= accessionNum.substring(accessionNum.indexOf("#")+1, accessionNum.indexOf("$"));
						if ((ext_image_obj_id.equals(null) || ext_image_obj_id.equals(""))) 
							access_no_rd 	= accessionNum.substring(accessionNum.indexOf("#")+1, accessionNum.indexOf("$"));
						else
							access_no_rd 	= ext_image_obj_id;
						//Fix for IN047566/End
					//IN065341 starts	
						//pstmtOrderId = con.prepareStatement("select  order_id, order_type_code from or_order_line where accession_num = ?"); 
						String sql6 = "select  order_id, order_type_code from or_order_line ##REPDB## where accession_num = ?"; 
						sql6=sql6.replaceAll("##REPDB##",RepDb);
						pstmtOrderId = con.prepareStatement(sql6);
					//IN065341 ends					
					pstmtOrderId.setString(1,access_no_rd);
						rsetOrderId = pstmtOrderId.executeQuery();
						if(rsetOrderId.next()){
							order_id = rsetOrderId.getString("order_id") == null ? "":  rsetOrderId.getString("order_id");
							order_typ_code	= rsetOrderId.getString("order_type_code") == null ? "":  rsetOrderId.getString("order_type_code");	
						}
						
						if(rsetOrderId  != null) rsetOrderId.close();
						if(pstmtOrderId  != null) pstmtOrderId.close();
						
							//out.println("<img src='../../eCommon/images/ExternalDocument.PNG' title='External Link' onClick=\"return getExtLink('"+patient_id+"','"+enctr_id+"','"+accessionNum+"','"+order_id+"','"+facility_id+"','"+locale+"','"+login_user+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+encntr_type+"','"+loc_desc+"')\">");//IN47847 added title
						out.println("<img src='../../eCommon/images/ExternalDocument.PNG' title='External Link' onClick=\"return getExtLink('"+patient_id+"','"+enctr_id+"','"+accessionNum+"','"+order_id+"','"+fac_id+"','"+locale+"','"+login_user+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+encntr_type+"','"+loc_desc+"','"+ext_image_appli_id+"','"+ext_image_obj_id_dms+"','"+ext_image_source+"','"+ext_srce_doc_ref_no+"','"+ext_srce_doc_ref_line_no+"')\">"); // IN049589 Passing peforming facility_id[fac_id] instead of login facility_id[facility_id]
					}	//Bru-HIMS-CRF-195.3 - IN047205 - Start
					else {
						out.println("<img src='../../eCommon/images/ExternalDocument.PNG' title='External Link' onClick=\"return getExtLink('"+patient_id+"','"+enctr_id+"','"+accessionNum+"','"+order_id+"','"+fac_id+"','"+locale+"','"+login_user+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+encntr_type+"','"+loc_desc+"','"+ext_image_appli_id+"','"+ext_image_obj_id_dms+"','"+ext_image_source+"','"+ext_srce_doc_ref_no+"','"+ext_srce_doc_ref_line_no+"')\">"); // IN049589 Passing peforming facility_id[fac_id] instead of login facility_id[facility_id]
					}	//Bru-HIMS-CRF-195.3 - IN047205 - End
				}	
			}
			// added for IN047204 - End
			
			//IN070610, starts
			String l_upload_view = "N";
			Integer l_rec_cnt = 0;
			
			if(uploadFuncTrOrders)
				l_rec_cnt = Integer.parseInt(rs.getString("uploaded_doc_cnt"));
			
			if(l_rec_cnt > 0 && "TRET".equals(histRecType) && uploadFuncTrOrders)
			{
				l_upload_view = "Y";
			}							
			
			if("Y".equals(l_upload_view))								
				out.println("<a style='cursor:pointer;color:blue' onClick=\"uploadedDocuments('"+accessionNum+"','"+contrSysEventCode+"')\"><img src='../../eOR/images/DOCUL.gif' width='16' height='16' border=0 alt='Uploaded Documents'/></a>");					
			//IN070610, ends
			
			if(result_status.equals("P")||resultStatus.equals("4"))
				out.println("<font color='red'>(Preliminary)</font>");

			out.println("</td></tr>");
			out.println("<tr style='display:none'><td class='gridData1' colspan='3'>"+details1+"</td></tr>");
			out.println("</table></td></tr>");
			if(!"CA_SPC".equals(p_called_from))//IN037701
				start++;
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		}
		 
		if (i==0)
		{
			out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NoResultdata.label","ca_labels")+"</td></tr>");		
		}
		else if (modal_yn.equals("N"))
		{
%>
		<!--	 <tr><td colspan='3' class='gridData'><a class='gridLink' href="javascript:callResults('<%=patient_id%>','<%=title%>','<%=reln_id%>','<%=enc_id%>')"><fmt:message key="eCA.MoreDtlRef.label" bundle="${ca_labels}"/></a></td></tr>INO30714 ,commented for IN038454 -->
		<!--IN065341 starts-->
		 <!--<tr><td colspan='3' class='gridData'><a class='gridLink' href="javascript:callResults('<%=patient_id%>','<%=title%>','<%=reln_id%>','<%=enc_id%>','<%=facility_id%>','<%=content_ID%>','<%=p_called_from%>')"><fmt:message key="eCA.MoreDtlRef.label" bundle="${ca_labels}"/></a></td></tr> <!--added arguments facility_id and content_ID for IN038454, added p_called_from for IN037701 --> 
		 <tr><td colspan='3' class='gridData'><a class='gridLink' href="javascript:callResults('<%=patient_id%>','<%=title%>','<%=reln_id%>','<%=enc_id%>','<%=facility_id%>','<%=content_ID%>','<%=p_called_from%>','<%=RepDb%>','<%=clob_data%>','<%=p_review_rad_yn%>')"><fmt:message key="eCA.MoreDtlRef.label" bundle="${ca_labels}"/></a></td></tr><!-- IN071561-->
		 <!--IN065341 ends-->
<%
		}
	}	
	catch(Exception e)
	{
		//out.println(e);//COMMON-ICN-0181
			e.printStackTrace();
	}
	finally
	{	
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>
</table>
</center>
		<input type=hidden name='from' id='from' value='<%=start%>'>
		<input type=hidden name='to' id='to' value='<%=end%>'>
		<input type=hidden name='start' id='start' value='<%=start%>'>
		<input type=hidden name='end' id='end' value='<%=end%>'>
		<!-- 27788 Start. -->
		<input type='hidden' name='option_id' id='option_id' value='<%=option_id%>' />
		<input type='hidden' name='locale' id='locale' value='<%=locale%>' />
		<input type='hidden' name='limit_function_id' id='limit_function_id' value='<%=limit_function_id%>' />
		<input type='hidden' name='relationship_id' id='relationship_id' value='<%=reln_id%>' />
		<input type='hidden' name='title' id='title' value='<%=title%>' />
		<input type='hidden' name='prefStyle' id='prefStyle' value='<%=prefStyleSheet%>' />
		<input type='hidden' name='content_ID' id='content_ID' value='<%=content_ID%>' />
		<input type='hidden' name='called_from' id='called_from' value='<%=called_from%>' />
		<input type='hidden' name='encounter_id' id='encounter_id' value='<%=enc_id%>' /> <!-- //31688-->
		<input type='hidden' name='facility_id1' id='facility_id1' value='<%=facility_id%>' />
		<input type='hidden' name='enc_id1' id='enc_id1' value='<%=enc_id%>' />
		<input type='hidden' name='RepDb' id='RepDb' value='<%=RepDb%>' />
		<input type='hidden' name='clob_data' id='clob_data' value='<%=clob_data%>' />
		<!-- 27788 End. -->
		<!--INO30714 Starts -->
		<input type="hidden" name="patient_id" id="patient_id" value='<%=patient_id%>'> 
		<input type="hidden" name="enc_id" id="enc_id" value='<%=enc_id%>'> 
		<!-- INO30714 Ends-->
</form>
</body>
</html>
<%!
	String replaceSpecialChar(String resultStr)
	{		
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~");			
		if(resultStr.indexOf("\r")!=-1)
			resultStr = resultStr.replaceAll("\r","");
		if(resultStr.indexOf("'")!=-1)
			resultStr = resultStr.replaceAll("'","`");
		if(resultStr.indexOf("\"")!=-1)
			resultStr = resultStr.replaceAll("\"","|");
		return resultStr;
	}
%>

