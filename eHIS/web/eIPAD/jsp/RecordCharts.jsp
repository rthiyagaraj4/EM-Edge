<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*, eCA.ChartRecording.*,javax.rmi.*,webbeans.eCommon.MessageManager,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<% 
request.setCharacterEncoding("UTF-8");

String locale = "en";
String facility_id= ""; //(String)session.getValue("facility_id");
String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
String strPracType = "";
String strPostBack = "";
String strInterval = "";
String strPatientId = "";
String strEncounterId = "";
String strChartType = "";
PatientContext oPatientContext = new PatientContext();
oPatientContext.request = request;
String strRowCount = "";
String strCurrentDate = "";
String strCurrentDatetime = "";
String strRecord = "";
int nListSize1 = 0;
String normalInd = "";
String strPatientClass = "";
//boolean recInsert = false;
String recInsert = "false";

if(session.getValue("facility_id") != null )
{
	oPatientContext.sFacilityId = (String)session.getValue("facility_id");
}
if(session.getValue("ca_practitioner_id") != null)
{
	oPatientContext.sClinicianId  = (String)session.getValue("ca_practitioner_id");
}
if(session.getValue("practitioner_type") != null )
{
	oPatientContext.sPracType = (String)session.getValue("practitioner_type");
}
if(session.getValue("PatientID") != null)
{
	oPatientContext.sPatientId = (String)session.getValue("PatientID");
}
if(session.getValue("EpisodeId") != null )
{
	oPatientContext.sEncounterId = (String)session.getValue("EpisodeId");
}
if(session.getValue("Gender") != null )
{
	oPatientContext.sGender = (String)session.getValue("Gender");
}
if(session.getValue("DOB") != null )
{
	oPatientContext.sDob = (String)session.getValue("DOB");
}
if(request.getParameter("cmbChartType") != null )
{
	strChartType = request.getParameter("cmbChartType");
}
if(request.getParameter("patclass") != null )
{
	strPatientClass = request.getParameter("patclass");
}

ChartDetails oChartDetails = new ChartDetails();
List<ChartType> oChartList = new ArrayList<ChartType>(); 
int nListSize = 0;
int nLoopCount = 0;

strPostBack = request.getParameter("hdnPostBack");
strCurrentDate = DateUtils.getCurrentDate("DMY", locale);
strCurrentDatetime = DateUtils.getCurrentDate("DMYHM", locale);
strRecord = request.getParameter("hdnRecord");
if(strPostBack != null && strPostBack.equals("true"))
{
	if(request.getParameter("hdnPatientClass") != null )
	{
		strPatientClass = request.getParameter("hdnPatientClass");
	}
	if(strRecord != null && strRecord.equals("Record") )
	{
		PrintWriter out1;
		java.util.Properties p1 = null;
		//out1 = response.getWriter();
		if(session.getValue("jdbc") != null)
		{
		   p1 = (java.util.Properties) session.getValue("jdbc") ;
		}
		if(p1 != null)
		{
		 //recInsert = insertRecord(request,out1,p1,session);
			recInsert = insertRecord(request,p1,session);
		}
	}
}
%>
<%!
private String insertRecord(HttpServletRequest request,java.util.Properties p, HttpSession session)
{
	//PrintWriter out;
	//java.util.Properties p;
	
	String sStyle = "";

	
	//if(session.getValue("jdbc") != null)
	//{
	//   p = (java.util.Properties) session.getValue("jdbc") ;
	//}
	
	StringBuffer replaceString = null;
	Connection con = null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmtSelect=null;
	CallableStatement cs = null;
	String sysdate = "";
	ResultSet rs=null;
	//List<String> oTransResultList = new ArrayList<String>();
	//p = (java.util.Properties) session.getValue("jdbc") ;
	String locale		= "en";//(String) p.getProperty("LOCALE");
	HashMap hashRecord = new HashMap();
	boolean bool = false;
	String disMsrId = "", disMsrResultType = "",  uom = "", normalLow = "",normalHigh = "",criticalLow = "",criticalHigh = "",normalAbnormalInd ="",chartGrpId = "",resultNum="",resultStr="",result_prefix="", remarks="";
	boolean flag=true;
	String taskSrlNo = request.getParameter("taskSrlNo") == null ? "" : request.getParameter("taskSrlNo");
	if(taskSrlNo.equals("null"))
	taskSrlNo = "";
	hashRecord.put("taskSrlNo",taskSrlNo);
	String taskCode = request.getParameter("taskCode") == null ? "" : request.getParameter("taskCode");
	if(taskCode.equals("null"))
	taskCode = "";
	hashRecord.put("taskCode",taskCode);
	String facilityId = (String)	session.getValue("facility_id")==null ? "" :(String)	session.getValue("facility_id") ;
	hashRecord.put("facilityId",facilityId);
	String practitionerId = (String)	session.getValue("ca_practitioner_id")==null ? "" :(String)	session.getValue("ca_practitioner_id");
	hashRecord.put("practitionerId",practitionerId);
	String function_from = request.getParameter("function_from")==null ? "" : request.getParameter("function_from");
	hashRecord.put("function_from",function_from);
	String addedById   = p.getProperty( "login_user" )==null ? "" :p.getProperty( "login_user" ) ;
	hashRecord.put("addedById",addedById);
	String addedAtWSNo = "IPAD";//p.getProperty("client_ip_address") ==null ? "" : p.getProperty("client_ip_address");
	hashRecord.put("addedAtWSNo",addedAtWSNo);
	//String encounterId = request.getParameter("episode_id")==null ? "0" :request.getParameter("episode_id");
	String encounterId = (String)session.getValue("EpisodeId") == null ? "" : (String)session.getValue("EpisodeId");
	if(encounterId.equals("")) encounterId = "0";
	hashRecord.put("encounterId",encounterId);
	String patientId = request.getParameter("hdnPatientId")==null ? "" :request.getParameter("hdnPatientId");
	hashRecord.put("patientId",patientId);

	String contr_mod_accession_num = request.getParameter("contr_mod_accession_num")==null ? "" :request.getParameter("contr_mod_accession_num");
	hashRecord.put("contr_mod_accession_num",contr_mod_accession_num);
	String module_id = request.getParameter("module_id")==null ? "" :request.getParameter("module_id");
	hashRecord.put("module_id",module_id);

	//String patientClass = "IP"; //request.getParameter("patient_class")==null ? "" : request.getParameter("patient_class");
	String patientClass =  request.getParameter("hdnPatientClass")==null ? "" : request.getParameter("hdnPatientClass");
	hashRecord.put("patientClass",patientClass);
	String chartId = request.getParameter("cmbChartType")==null ? "" :request.getParameter("cmbChartType");
	hashRecord.put("chartId",chartId);
	String recTime = com.ehis.util.DateUtils.getCurrentDate("DMYHM", locale);//request.getParameter("rec_time")==null ? "" : request.getParameter("rec_time");
	
	recTime		= com.ehis.util.DateUtils.convertDate(recTime,"DMYHM",locale,"en");
	hashRecord.put("recTime",recTime);

	String errorMsg = "";
	String count = request.getParameter("count") == null ? "0" : request.getParameter("count") ;
	int counter = Integer.parseInt(count);
	hashRecord.put("count",count);
	//boolean bTranResult = false;
	String bTranResult = "false";
	try
	{
		con  = ConnectionManager.getConnection(request);
		con.setAutoCommit(false);
		String query = "";
		
		/*******ADDED BY Deepa on 11/16/2009 at 3:00 PM for IN016097**************************/
		String chartType = "";
		
		query = "SELECT SPL_CHART_TYPE FROM CA_CHART WHERE CHART_ID = ?";
		pstmtSelect = con.prepareStatement(query);
		pstmtSelect.setString(1,chartId);
		rs = pstmtSelect.executeQuery();
		while(rs.next())
		{
			chartType = rs.getString("SPL_CHART_TYPE") == null ? "" : rs.getString("SPL_CHART_TYPE");
		}

		if(rs != null) rs.close();
		if(pstmtSelect != null) pstmtSelect.close();
		query = "";

		/*******ADDED BY Deepa on 11/16/2009 at 3:00 PM for IN016097**************************/
	
		if(!function_from.equals("CP"))
		{
		query = "select 1  from CA_ENCNTR_DISCR_MSR a where  ENCOUNTER_ID=? and FACILITY_ID=? and CHART_ID =? and  TEST_OBSERV_DT_TM  >= to_date(?,'dd/mm/yyyy hh24:mi') and rownum=1 AND DISCR_MSR_RESULT_TYPE!='S' ";
//		union  select 1 from dual where to_date(?,'dd/mm/yyyy hh24:mi') > SYSDATE ) ";
		}
		else
		{
			query = " select 1  from CA_ENCNTR_DISCR_MSR a where  ENCOUNTER_ID=? and FACILITY_ID=? and CHART_ID =? and  TEST_OBSERV_DT_TM  = to_date(?,'dd/mm/yyyy hh24:mi') AND DISCR_MSR_RESULT_TYPE!='S' ";
		}
		
		
		pstmtSelect = con.prepareStatement(query);
		pstmtSelect.setString(1,encounterId);
		pstmtSelect.setString(2,facilityId);
		pstmtSelect.setString(3,chartId);
		pstmtSelect.setString(4,recTime);

		rs= pstmtSelect.executeQuery();
		while(rs.next())
		{
			flag=false;
			break;
		}
		if(pstmtSelect !=null) pstmtSelect.close();
		if(rs != null)rs.close();

			sysdate = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			if(flag==true)
			{
				for(int i=0;i<counter;i++)
				{
					resultStr="";
					resultNum="";
					disMsrResultType = request.getParameter("dis_msr_type_"+i)==null ? "":request.getParameter("dis_msr_type_"+i);

					hashRecord.put("dis_msr_type_"+i,disMsrResultType);
					 if(disMsrResultType.equals("N")||disMsrResultType.equals("A")||disMsrResultType.equals("S")||disMsrResultType.equals("I"))	 
					{
						resultNum = request.getParameter("comp_"+i)==null ? "":request.getParameter("comp_"+i);
						hashRecord.put("comp_"+i,resultNum);
						result_prefix = request.getParameter("result_prefix"+i)==null ? "":request.getParameter("result_prefix"+i);
						hashRecord.put("result_prefix"+i,result_prefix);
					}
				else	if(disMsrResultType.equals("L"))	 
					{

							resultStr = request.getParameter("listItemValue"+i)==null ? "":request.getParameter("listItemValue"+i);
							if(resultStr.equals("------Select------")) resultStr = "";
							resultNum = request.getParameter("comp_"+i)==null ? "": request.getParameter("comp_"+i);
							hashRecord.put("comp_"+i,resultNum);	
							hashRecord.put("listItemValue"+i,resultStr);
					}
					 else
					{
						resultStr = request.getParameter("comp_"+i)==null ? "": request.getParameter("comp_"+i);

						if(disMsrResultType.equals("D") )	 
							resultStr = com.ehis.util.DateUtils.convertDate(resultStr,"DMY",locale,"en");
						else if(disMsrResultType.equals("E") )	 
							resultStr = com.ehis.util.DateUtils.convertDate(resultStr,"DMYHM",locale,"en");

						hashRecord.put("comp_"+i,resultStr);	
					}
					disMsrId = request.getParameter("dis_msr_id_"+i)==null ? "":request.getParameter("dis_msr_id_"+i) ;
					hashRecord.put("dis_msr_id_"+i,disMsrId);	
					uom = request.getParameter("uom_"+i)==null ? "":request.getParameter("uom_"+i);
					hashRecord.put("uom_"+i,uom);	
					normalLow = request.getParameter("normal_low_"+i)==null ? "": request.getParameter("normal_low_"+i);
					hashRecord.put("normal_low_"+i,normalLow);	
					normalHigh = request.getParameter("normal_high_"+i)==null ? "":request.getParameter("normal_high_"+i);
					hashRecord.put("normal_high_"+i,normalHigh);	
					criticalLow = request.getParameter("critical_low_"+i)==null ? "":request.getParameter("critical_low_"+i);
					hashRecord.put("critical_low_"+i,criticalLow);	
					criticalHigh = request.getParameter("critical_high_"+i)==null ? "":request.getParameter("critical_high_"+i);
					hashRecord.put("critical_high_"+i,criticalHigh);	
					normalAbnormalInd = request.getParameter("normal_abnormal_ind_"+i)==null ? "":request.getParameter("normal_abnormal_ind_"+i);
					hashRecord.put("normal_abnormal_ind_"+i,normalAbnormalInd);	
					chartGrpId = request.getParameter("chat_grp_id_"+i)==null ? "":request.getParameter("chat_grp_id_"+i);
					hashRecord.put("chat_grp_id_"+i,chartGrpId);
					remarks = request.getParameter("remarksField"+i)==null ? "":request.getParameter("remarksField"+i);
					hashRecord.put("remarksField"+i,remarks);
//					hashRecord.put("locale_"+i,locale);
					
				}//for
				boolean local_ejbs = false;
				
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ChartRecording",ChartRecordingManager.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
				Object argArray[] = new Object[3];

				argArray[0] = p;
				argArray[1] = hashRecord;
				argArray[2] = locale;

				Class paramArray[] = new Class[3];

				paramArray[0] = p.getClass();
				paramArray[1] = hashRecord.getClass();;
				paramArray[2] = locale.getClass();
					
				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertChartRecords",
				paramArray)).invoke(busObj,argArray);


				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				bool = ((Boolean)results.get("results")).booleanValue();
				//bTranResult = bool;
				
				if(!bool)
				{
					bTranResult = "false";
				}
				else
				{
					bTranResult = "true";
				}
				
				//if(bTranResult == false)
				//int chk = 0 ;
				//int pi = 5/chk ;
				if(bool == false)	
				{
					try
					{
						if(chartType.equals("GR"))
						{
							cs = con.prepareCall("{call CABUILDSPLCHART.GR(?,?)}");
							cs.setString(1,patientId);
							cs.setString(2,chartId);
							cs.execute();

							con.commit();
						}					
					}
					catch (Exception proc)
					{
						//proc.printStackTrace(System.err);
						bTranResult = proc.toString();
					}
				}
			}
			//con.commit();
	}
	catch(Exception e)
	{
		try{
		con.rollback();
		}catch(Exception ee)
		{}
		//e.printStackTrace(System.err);
		//out.println("Exception in try2 of RecordCharts.jsp" +e.toString());
		bTranResult = "Exception in try2 of RecordCharts.jsp" +e.toString();
	}
	finally
	{
		try{
			if(rs!=null)rs.close();
			if(cs!=null)cs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
				ConnectionManager.returnConnection(con,p);
		}
		catch(Exception e)
		{
			bTranResult = "Exception in try3 of RecordCharts.jsp" +e.toString();
		}
	}
	
	hashRecord.clear();
	return bTranResult;
}
%>
<!DOCTYPE html> 
<html>
<head>
<meta name="apple-mobile-web-app-capable" content="yes" />   
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  
<link rel="stylesheet" href="../css/iPadRecordCharts.css" />
<script src="../jquery-1.5.2.min.js"></script>  
<script src="../jquery.mobile-1.0a4.1.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 
<title></title>

</head>
<script>
var tempField;
  function submitForm()
  {
	  document.getElementById("hdnPostBack").value = "true";
	  document.getElementById("frmRecordChart").submit();
  }
  function cancelRecord(objBtn)
  {
	  //document.getElementById("frmRecordChart").submit(); 
	   objBtn.style.border = "3px solid #48d1d8";
	  window.parent.showRecordChart();
  }
  function changeOrientation(orient)
  {
  		//alert(orient);
  	if(orient == "landscape")
  	   {
  	//	document.getElementById("dvNotesMenu").style.min-height = "492px";
  	    $("#dvmain").css('min-height','512px');
  	    


  	    
  	   }
       else
  	   {
      	 //alert(document.getElementById("dvNotesMenu").style.min-height);
      	// document.getElementById("dvNotesMenu").style.min-height = "748px";
      	$("#dvmain").css('min-height','768px');
  
  	   }
   
  }
  function loadValues()
  {
	  document.getElementById("cmbChartType").value = document.getElementById("hdnChartTypeCombo").value;
	 
	  var tranState = document.getElementById("hdnTranState").value;
	  var record = document.getElementById("hdnRecord").value;
	  if(record == "Record")
	  {
		  document.getElementById("cmbChartType").value = "select";
			  if(tranState == "false")
			  {
				 alert("Operation Completed Successfully") ;
			  }
			  else if(tranState == "true")
			  {
				    alert("Operation failed") ;
			  }
			  else
				  {
				     alert(tranState);
				  }
		}
	  document.getElementById("hdnTranState").value = "";
	  document.getElementById("hdnRecord").value = "";
	  
  }
  function loadWidgets()
  {
  	window.parent.showLoadingMsg();
  }
  function allowValidNumberLocal3(fld,e){
		var count=fld.value.length;//ok
	    var whichCode = (window.Event) ? e.which : e.keyCode;//ok
		//var whichCode = (window.Event) ? e.which : e.keyCode;
		if (whichCode == 13) return false; 
		 else return true;
	}
  function allowValidNumberLocal2(fld, e, maxInt, deci)
  {

      var count=fld.value.length;//ok
      var whichCode = (window.Event) ? e.which : e.keyCode;//ok
     // alert(whichCode);
    if(whichCode == 8)  
    {
    	  return true;
    }
  	var minusOccurance = fld.value.indexOf('-');
  	var plusOccurance = fld.value.indexOf('+');
  	if(minusOccurance != -1 || plusOccurance != -1)
  	{
  		maxInt++;
  		fld.setAttribute("maxLength",maxInt);
  	}
  	else
  	{
  		fld.setAttribute("maxLength",maxInt);
  	}
  	if((whichCode == 45 && count>0) || (whichCode == 43 && count>0))
  	{
  		return false
  	}

      if(count >= maxInt)
      {
          
  		return false;
      }
  	
  	//you donot require this just var strCheck = '.0123456789' for deci > 0
  	//strCheck = '0123456789' for deci=0
  	      var strCheck = '.0123456789-+';

//  	alert(e.getKeyCode())
      if (parseInt(deci)==0)//For Only Nos 0 - 9
          strCheck = '0123456789-+';

      var fldvalue=fld.value;
    //g  var whichCode = (window.Event) ? e.which : e.keyCode;
    // if (whichCode == 13) return true;  // Enter     commented by Channaveer B
      var pointCount=0;

      for(var i=0;i<fldvalue.length;i++)
      {
          if(fldvalue.charAt(i)=='.') pointCount++;
      }

      if (pointCount>0 && whichCode == 46) return false;

      var fldValue    =   fld.value;
      var dotIndex    =   fldValue.indexOf(".");
      var fldLength   =   fldValue.length;
  	var count = 0;
      if(dotIndex!=-1){
         /* if( fldLength > (parseInt(dotIndex)+parseInt(deci)) )
  			return false;*/
  	}


  	key = String.fromCharCode(whichCode);  // Get key value from key code
    
  	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
  	else if((key == "-" && fldValue.indexOf(key) != -1) || (key == "+" && fldValue.indexOf(key) != -1) )
  	{
  		if(fldValue.indexOf(key) != 1 )
  			return false
  	}
      return true;
  }
  function validateNumber(obj,numdigitsdec,mindigits,minValue,maxValue,lowlevel,highlevel,rownumber,critlow,crithigh,cricLowStr,cricHighStr,lowStr,highStr)
  {
	  tempField = obj;
	  var val = obj.value;
	  var msrId = $(obj).attr('data-discMsrId');
	  //alert(msrId);
		if(isNaN(val))
		{
			obj.value = "";
			return;
		}
		if(val.indexOf(".") != -1)
		{
			var str = val.substring(val.indexOf(".")+1, val.length);
			
			if (parseInt(numdigitsdec) != 0 && (str.length) > parseInt(numdigitsdec) )
			{	
				var msg = "Only " + numdigitsdec + " decimal digit(s) allowed";//getMessage('VARIABLE_DEC_DIGIT','CA');
				//msg = msg.replace('@',numdigitsdec);
				alert(msg);
				obj.value = '';
				//obj.focus(); // this will work only in IE
				//setTimeout("tempField.focus();",10);
				//setTimeout(function(){obj.focus();},2);
				return;
			}
		}
		if(val != null && val != '' && minValue != '' && maxValue != '')
		{
			if(parseFloat(minValue) > val || parseFloat(maxValue) < val)
			{
				var msg = "The value of " +msrId + " should be between " +minValue + " and " + maxValue;//getMessage("MIN_MAX_VALUE_RANGE","CA");
				//msg =msg.replace('(1)',minValue);
				//msg =msg.replace('(2)',maxValue);
				alert(msg);
				obj.value='';
				//obj.select();
				//obj.focus();
				//setTimeout(function(){obj.focus();},2);

				return false;
			}

		}
		//--------
	    if(val != null && val != '')
		{
	    	var colorIndicator = ""
			if((lowlevel != '' && parseFloat(lowlevel) != 0) && (highlevel != '' &&  parseFloat(highlevel) != 0)   && (critlow != '' && parseFloat(critlow) != 0) &&  (crithigh != 0 && parseFloat(crithigh) != ''))
			{
				if(parseFloat(val) >= parseFloat(critlow) && parseFloat(val) < parseFloat(lowlevel))
					colorIndicator = lowStr;
				else if(parseFloat(val) > parseFloat(crithigh))
					colorIndicator = cricHighStr;
				else if(parseFloat(val) < parseFloat(critlow))
					colorIndicator = cricLowStr;
				else if(parseFloat(val) > parseFloat(highlevel) && parseFloat(val) <= parseFloat(crithigh))
					colorIndicator = highStr;
			}// end of if
			else
			{
				if((lowlevel != '' && parseFloat(lowlevel) != 0))
				{
					if((critlow != '' && parseFloat(critlow) != 0))
					{
						if(parseFloat(val) < parseFloat(critlow)) 
							colorIndicator = cricLowStr;
						else if((parseFloat(val) >= parseFloat(critlow)) && (parseFloat(val) < parseFloat(lowlevel))) 
							colorIndicator = lowStr;
					}
					else if(parseFloat(val) < parseFloat(lowlevel)) 
						colorIndicator = lowStr;
				}
	
				if((highlevel != '' &&  parseFloat(highlevel) != 0))
				{
					if((crithigh != '' && parseFloat(crithigh) != 0))
					{
						if(parseFloat(val) > parseFloat(crithigh)) 
							colorIndicator = cricHighStr;
						else if((parseFloat(val) <= parseFloat(crithigh)) && (parseFloat(val) > parseFloat(highlevel))) 
							colorIndicator = highStr;
					}
					else if(parseFloat(val) > parseFloat(highlevel)) 
						colorIndicator = highStr;
				}
			}// end of else
	        /*
			if(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm != null)
			{
				var normal_abnormal_ind = eval("document.ChartLayoutDetailForm.normal_abnormal_ind_"+rownumber);
				normal_abnormal_ind.value=colorIndicator;
			}
			else
			{
				var normal_abnormal_ind = eval("document.chartRecordingAmendErrorForm.normal_abnormal_ind_"+rownumber);
				normal_abnormal_ind.value=colorIndicator ;
			}
	    	*/
	    	var normal_abnormal_ind = "normal_abnormal_ind_" +rownumber;
	    	//alert(normal_abnormal_ind);
	    	//alert(document.getElementById(normal_abnormal_ind));
	    	document.getElementById(normal_abnormal_ind).value = colorIndicator;
		}
		//--------
		if ( val != null && val != '')
		{
			var val1=val;
			if(eval(mindigits) != 0) {
				
				if(val1.indexOf("-")>=0)
				{
					val1 = val1.substr(val1.indexOf("-")+1,val1.length);
				}
				
				if(val1.indexOf(".")>=0)
				{
					val1 = val1.substr(0, val1.indexOf("."));
				}
				if(val1.length < eval(mindigits))  {
					var short_desc_alert;

				

					//var message_alert="Please enter minimum" + mindigits + " digits";//getMessage("MINIMUM_DIGITS","CA");
					var message_alert="Minimum number of digits for " + msrId + " must be " + mindigits;
					//message_alert=message_alert.replace('$',short_desc_alert.value);
					//alert(message_alert+' '+mindigits);	
					alert(message_alert);
					obj.value='';
					//obj.focus();
					//setTimeout(function(){obj.focus();},2);
					//obj.select();
				}
			}
			if(!CheckForNumber1(val)) 
			{
				//obj.focus();
			}
			else
			{
			    var n = obj.value;
				if((n.indexOf(".")) >= 0)
				{
					if(numdigitsdec !=0 )  {
						var arr =  new Array();
						arr = n.split(".");
						var num = arr[0].length;
						var frac = arr[1].length;

		                if (frac > numdigitsdec )
						{
							var msg = "Decimal digits greate";//getMessage("VARIABLE_DEC_DIGIT","CA");
							//msg = msg.replace("@",numdigitsdec);
							//alert(msg);
							obj.value='';
							//obj.focus();
							//setTimeout(function(){obj.focus();},2);
						}
					}else {
						//alert("No decimal");
						obj.value='';
						//obj.focus();
						//setTimeout(function(){obj.focus();},2);
					}
				}

			}
		}
  }
  function CheckForNumber1(val) {
	  
			return true;
	}
  function displayDate(txtObj,rownumber)
  {
	  //alert("hi");
	 // alert(txtObj);
	  var sHidden = "comp_" + rownumber;
	  document.getElementById(txtObj).value = document.getElementById("hdnCurrentDate").value;
	 // txtObj.value = document.getElementById("hdnCurrentDate").value;
	  document.getElementById(sHidden).value = document.getElementById("hdnCurrentDate").value;
	  
  }
  function displayDateTime(txtObj,rownumber)
  {
	  //alert("hi");
	 // alert(txtObj);
	 var sHidden = "comp_" + rownumber;
	  document.getElementById(txtObj).value = document.getElementById("hdnCurrentDateTime").value;
	 // txtObj.value = document.getElementById("hdnCurrentDate").value;
	  document.getElementById(sHidden).value = document.getElementById("hdnCurrentDateTime").value;
	  
  }
  function chkValidityOfTime(strfromTime)
  {
  	if(strfromTime.value != '')
  	{
  		strfromTimeVal = strfromTime.value;
  		strTemp = strfromTimeVal.indexOf(":");
  		if(strTemp == -1 || strTemp != 2){
  			alert("Invalid Time Format");
  			//strfromTime.select();
  			strfromTime.value = "";
  			return false;
  		}
  		else
  		{
  			checkTimeForDetail(strfromTime);
  		}
  	}
  }
  function checkTimeForDetail(strfromTime)
  {
  	strfromTimeVal = strfromTime.value;
  	strSplitTime = strfromTimeVal.split(":");
  	hr = strSplitTime[0];
  	min = strSplitTime[1];

  	if(strfromTime.value.length !=5)
  	{
  		alert("Invalid Time Format");
  				//strfromTime.select();
  				strfromTime.value = "";
  		return false;
  	}
  	
  	if(!(hr.charCodeAt(0) >= 48 && hr.charCodeAt(0) <=57 &&
  		hr.charCodeAt(1) >= 48 && hr.charCodeAt(1) <=57 &&
  		min.charCodeAt(0) >= 48 && min.charCodeAt(0) <=57 &&
  		min.charCodeAt(1) >= 48 && min.charCodeAt(1) <=57  ))
  		{
  		    alert("Invalid Time Format");
  			//strfromTime.select();
  			strfromTime.value = "";
  			return false;
  		}



  	if(hr>23){
  		  alert("Invalid Hour");
  		//strfromTime.select();
  		strfromTime.value = "";
  		return false;
  	}
  	if(min>59){
  		  alert("Invalid minute");
  		//strfromTime.select();
  		strfromTime.value = "";
  		return false;
  	}
  	return true;
  }
  function displayFormula()
  {
	  $("[data-summation = 'Y']").each(function(index, value) {      
			 // console.log('div' + index + ':' + $(this).attr('id')); 
			 //alert(index);data-discMsrId
			// alert($(this).val());
			//alert("hi");
			   var rownumber = $(this).attr('data-rownumber');
			   //alert(rownumber);
			   var SF = "hdnSF" + rownumber;
			   var formula =  document.getElementById(SF).value;
			  // alert(formula);
			   var sCompValue = "comp_" + rownumber;
			   var objHidden =  document.getElementById(sCompValue);
			   var objText = $(this);
			  // alert(objText);
			  // alert(index);
			  // alert(value);
			   var flag
				var objTextValue  = "";
				if(formula != 'X')	
				{
					var number = parseFloat(eval(formula))
					//alert(number);
					flag = 	isFinite(number)
					var index = 0;
					if(flag == true)
					{
						number = number * 1000
						number = Math.round(number);
						number = number /1000;
						//objText.value = number
						//alert(objText.value);
						objHidden.value = number;
						$(this).attr('value', number);
					}
					else
					{
						//objText.value = ""
						//objHidden.value = ""
					}
				}
			 
			 
	  }); 
  }
  function recordCharts(objBtn)
  {
	  var brec = true;
	  objBtn.style.border = "3px solid #48d1d8";
	  $("[data-mandatory = 'Y']").each(function(index, value) {      
		 // console.log('div' + index + ':' + $(this).attr('id')); 
		 //alert(index);data-discMsrId
		// alert($(this).val());
		
		 var msrId = $(this).attr('data-discMsrId');
		 var dataValue =  $(this).val();
		 if(dataValue == null || dataValue == "")
			 {
			   var msg = "" + msrId + " Should Not Be Blank";
			   if(brec)
				   {
				   alert(msg);
				   }
			   
			   brec = false;
			   return false;
			 }
		 
		  }
	  ); 
	  
	  if(brec)
		  {
		     
		      
	           var count = document.getElementById("count").value;
	           count =  parseInt(count);
	          // alert("count " + count);
	           var index =0;
	           var bValuePresent = false;
	           for(index=0;index<count;index++)
	           {
	        	   var msrtype = "dis_msr_type_" + index;
	        	   var type = document.getElementById(msrtype).value;
	        	  //alert("type " + type);
	        	   var cntrl = "comp_" + index
	        	   var cntrlValue = document.getElementById(cntrl).value;
	        	  //alert("cntrlvalue " + cntrlValue);
	        	   var lCntrl = "listItemValue" + index;
	        	   var lCntrlValue = document.getElementById(lCntrl).value;
	        	 //alert("lcntrlvalue " + lCntrlValue);
	        	   if(type == "N" || type == "A" || type == "I" ||type == "D" || type == "E" || type == "T" || type == "C")
	        		{
	        		    if(cntrlValue != null && cntrlValue != "")
	        		    	{
	        		    	  bValuePresent = true;
	        		    	  break;
	        		    	}
	        		}
	        	   else if(type == "L")
	        		{
	        		   if(lCntrlValue != null && lCntrlValue != "------Select------" && lCntrlValue != "Select")
	       		    	{
	       		    	  bValuePresent = true;
	       		    	  break;
	       		    	}
	        		}
	        	   else
	        		{
	        		   if(cntrlValue != null && cntrlValue != "")
	       		    	{
	       		    	  bValuePresent = true;
	       		    	  break;
	       		    	}
	        		}   
	        		   
	           }
	           if(bValuePresent)
	        	   {
					  document.getElementById("hdnPostBack").value = "true";
					  document.getElementById("hdnRecord").value = "Record";
					  document.getElementById("frmRecordChart").submit();
	        	   }
	           else
	        	   {
	        	     alert("Atleast one value should be entered");
	        	   }
		  }
	  objBtn.style.border = "1px solid #48d1d8";
  }
  function valueChange(obj,index)
  {
	  var sHidden = "comp_" + index;
	  document.getElementById(sHidden).value = obj.value;
	 // alert( document.getElementById(sHidden).value);
	  
	  
  }
  function evalCheckBox(objCheck,index)
  {
	  var sHidden = "comp_" + index;
  	if(objCheck.checked==true)
  		document.getElementById(sHidden).value = 'Y';
  	   	else
  	   	document.getElementById(sHidden).value ='';
  }	
  function setComboValue(objcombo,rownumber)
  {
	  var sHidden = "listItemValue" + rownumber;
	  var sCompValue = "comp_" + rownumber;
	  document.getElementById(sHidden).value = objcombo.options[objcombo.selectedIndex].text
	  document.getElementById(sCompValue).value = objcombo.value;
	  //alert(objcombo.value);
	 // alert(document.getElementById(sHidden).value);
	 // alert(document.getElementById(sCompValue).value);
  }
  function checkForNaN(obj,TextId,rownumber)
  {
	  var formula = "";
	  // alert(formula);
	  // alert($(this));
	   
	  // alert($(this).attr("data-formula"));
	  // formula = $(this).attr('data-formula');
	  
	   var objText = document.getElementById(TextId);
	   var sCompValue = "comp_" + rownumber;
	   var SF = "hdnSF" + rownumber;
	   var objHidden =  document.getElementById(sCompValue);
	   var SFId = document.getElementById(SF).value;
	   //formula = SFId;
	   formula = $(obj).attr('data-formula');
	  // alert(formula);
	    var flag
		var objTextValue  = "";
		if(formula != 'X')	
		{
			var number = parseFloat(eval(formula))
			//alert(number);
			flag = 	isFinite(number)
			var index = 0;
			if(flag == true)
			{
				number = number * 1000
				number = Math.round(number);
				number = number /1000;
				objText.value = number
				objHidden.value = number
			}
			else
			{
				objText.value = ""
				objHidden.value = ""
			}
		}
  }
</script>
<body onload = "loadValues()">
<section data-role = "page" style = "padding:0px;background:#ffffff">
 <form name = "frmRecordChart" id = "frmRecordChart" method = "post">
    <div data-role = "none" class ='divmain' id = 'dvmain'  style="padding:0px" >
	     <div data-role = "none" class = "dvRecordChart">
		     <table style="width:100%;height:100%" border = "0" cellpadding = "0" cellspacing = "0">
		       <tr style="width:100%;height:100%">
		         <td style = "width : 95%" align = "left"  valign = "center">
		            <span class = "spanRecordChart">Record Charts</span>
		            
		         </td> 
		         <td style="width:5%" align = "center" valign = "middle"  onclick = "loadWidgets()" >
		         <img src = "../images/Close.png"></img>
		         </td>
		       </tr>
		     </table>
	    </div>
	    <div id = "dvCriteria" class = "dvCriteria" data-role = "none">
	      <table style="height:68px;width:100%" border = "0" cellpadding = "0" cellspacing = "0">
				     <tr style="height:30px;width:100%">
					      <td align = "left" style="width:34%"><span class = "spanFilterBy">Select Chart</span></td>
					      <td align = "left" style="width:33%">             
					      </td>
					      <td align = "left" style="width:33%">
					      </td>  
				     </tr>
				     <tr style="height:35px;width:100%">
					      <td align = "left" style="width:34%">
					        <select  class="cmbFilterBy" data-role="none" id="cmbChartType" name = "cmbChartType" onchange = "submitForm()"> 
		           
		                                           <option value="select">Select</option>
													<%
													ChartType oChartType = null;
													try {
														oChartList = oChartDetails.getChartForCombo(oPatientContext);
														 if(oChartList != null)
											        	      nListSize =  oChartList.size();
														if(nListSize > 0)
											            {
															 for(nLoopCount = 0 ; nLoopCount < nListSize; nLoopCount ++)
															 {
																 oChartType = oChartList.get(nLoopCount);	
																 if(oChartType != null)
																 {
																	 %>
																	    <option value="<%=oChartType.getChartId()%>"><%=oChartType.getChartDesc() %></option>
																	 <% 
																 }
															 }
											            }
														
													}
													catch ( Exception e ){
														out.println("Exception " + e);
														//out.println(sqlStr.toString());
														e.printStackTrace();
													}
													%>
				            </select> 
					      </td>
					     <td align = "left" style="width:33%" valign = "middle"></td>
					     <td align = "center" style="width:33%"> </td>
				     </tr>
				     
				     
				     <tr style="height:3px;width:100%">
				        <td>&nbsp;</td>
				     </tr>
			   </table>
	   </div>
	    <div data-role = "none" id = "dvChartFields" class = "dvChartFields" >
	    
	     <table style = "width:100%;height:44px" border = "0" cellspacing = "0" cellpadding = "0">
	    	 <tr class = "dvRecordChart">
	    	    <td  class = "CFirstCol" valign = "center" align = "left"> 
	    	      <span class = "spChartHeader" >Event</span>
	    	    </td>
	    	     <td class = "CSecCol" valign = "center" align = "left"> 
	    	       <span class = "spChartHeader">Value</span>
	    	     </td>
	    	     <td class = "CThirdCol" valign = "center" align = "left">
	    	     <span class = "spChartHeader">Unit</span>
	    	     </td>
	     	 </tr>
	     </table>
	     <%
	       
			if(strPostBack != null && strPostBack.equals("true") && strRecord != null && !strRecord.equals("Record"))	
			{
				oPatientContext.sChartId = strChartType;
				List<ChartConfig> oChartConfigList = new ArrayList<ChartConfig>(); 
				String strSectionId = "";
				int nCssCount = 1;  // To display alternate Row Color.
				int nLoopCount1 = 0;
				
				//int nListSize1 = 0;
				  
				
				
				try {
						
						oChartConfigList = oChartDetails.getChartConfig(oPatientContext) ; 
						if(oChartConfigList != null)
						{
							nListSize1 = oChartConfigList.size();
							
						}
						if(nListSize1 > 0)
						{
							ChartConfig oChartConfig = null;
							for(nLoopCount1 = 0 ; nLoopCount1 < nListSize1;nLoopCount1 ++)
							{
								oChartConfig = oChartConfigList.get(nLoopCount1);
								if(oChartConfig != null)
								{
									if(!strSectionId.equals(oChartConfig.getSectionId()))
									{
										%>
										<table style = "width:100%;height:20px" border = "0" cellspacing = "0" cellpadding = "0">
									    	 <tr class = "trChartGroup">
									    	    <td  style = "width:100%" valign = "center" align = "left"> 
									    	      <span class = "spChartRow" ><%=oChartConfig.getSectionDesc() %></span>
									    	    </td>
									    	   
									     	 </tr>
									     </table>
										
										<% 
									}//sectionid
									
									
									
									%>
									 
									  <table style = "width:100%;height:40px" border = "0" cellspacing = "0" cellpadding = "0">
								    	 <tr class = "trChartRows<%=nCssCount%>">
								    	    <td  class = "CFirstCol" valign = "center" align = "left"> 
								    	      <span class = "spChartRow" ><%=oChartConfig.getDiscMsrDesc()%></span>
								    	    </td>
								    	     <td class = "CSecCol" valign = "center" align = "left"> 
								    	       <%
								    	       String maxSize = oChartConfig.getNumDigitsMax();
								    	       String minSize = oChartConfig.getNumDigitsMin();
								    	       String decSize =  oChartConfig.getNumDigitsDecimal();
								    	       String defaultValue = oChartConfig.getDefaultValue();
								    	       String minValue = oChartConfig.getMinValue();
								    	       String maxValue = oChartConfig.getMaxValue();
								    	       String num_dflt_result = oChartConfig.getNumDfltResult();
								    	       String defaultText = "";
								    	       
								    	       if (maxSize.equals(""))
								   			   {
								   				 maxSize = "20";
								   			   }
								              // if(Integer.parseInt(maxSize)==0)
									   		   if(Float.parseFloat(maxSize)==0)
									            {
									                   maxSize = "20";
									             }
								   			    String type = oChartConfig.getResultType();
								    	       
								    	       if(type != null && !type.equals("L") && !type.equals("C")) //to display textbox control
								    	       {
								    	    	  if(type.equals("N")||type.equals("I"))
								    	    	  {
								    	    		  normalInd = "";
								    	    		  if(defaultValue != null && defaultValue.length() > Integer.parseInt(maxSize))
								    	    			  defaultValue = "";
								    	    		  normalInd = oChartConfig.getNormalIndicator();
									    	    	   if(type.equals("I") )
									    	    	   {
									    	    		   decSize = "0"; 
									    	    	   } 
								    	    	   %>
								    	    	    <input type = "textbox"   data-role = "none" onchange = "valueChange(this,'<%=nLoopCount1 %>')" data-discMsrId = "<%=oChartConfig.getDiscMsrDesc()%>" name = "custom_<%=oChartConfig.getSectionId() %>_<%=oChartConfig.getDiscMsrId() %>" id = "custom_<%=oChartConfig.getSectionId() %>_<%=oChartConfig.getDiscMsrId() %>"  data-mandatory = "<%=oChartConfig.getMandatoryYN() %>" class = "txtChart" value = "<%=defaultValue %>" maxLength= "<%=maxSize%>" onkeypress="return allowValidNumberLocal2(this, event, '<%=maxSize%>','<%=decSize%>')" onblur = "validateNumber(this,'<%=decSize%>','<%=minSize %>','<%=minValue %>','<%= maxValue%>','<%=oChartConfig.getNormalLow() %>','<%=oChartConfig.getNormalHigh() %>','<%=nLoopCount1 %>','<%=oChartConfig.getCriticalLow() %>','<%=oChartConfig.getCriticalHigh() %>','<%=oChartConfig.getCriticalLowStr() %>','<%=oChartConfig.getCriticalHighStr() %>','<%=oChartConfig.getLowStr() %>','<%=oChartConfig.getHighStr() %>');displayFormula()" />
								    	    	    
								    	    	   <%
								    	    	   if(oChartConfig.getMandatoryYN().equals("Y"))
								    	    	    {
								    	    	    %>
								    	    	   <img  src='../images/mandatory.gif'></img>
								    	    	    <% 
								    	    	    }
								    	    	   
								    	    	  }
								    	    	  else if(type.equals("D"))
								    	    	  {
								    	    		  normalInd = "";
								    	    		  %>
								    	    		     <input type = "textbox"  data-discMsrId = "<%=oChartConfig.getDiscMsrDesc()%>" data-role = "none" readonly class = "txtChartD" name = "custom_<%=oChartConfig.getSectionId() %>_<%=oChartConfig.getDiscMsrId() %>" id = "custom_<%=oChartConfig.getSectionId() %>_<%=oChartConfig.getDiscMsrId() %>"  data-mandatory = "<%=oChartConfig.getMandatoryYN() %>" /><input type ="button"  value='Now' class="btnTypeD"  data-role = "none" onclick = "displayDate('custom_<%=oChartConfig.getSectionId() %>_<%=oChartConfig.getDiscMsrId() %>','<%=nLoopCount1 %>')"/>
								    	    		     
								    	    		  <% 
								    	    		  if(oChartConfig.getMandatoryYN().equals("Y"))
									    	    	    {
									    	    	    %>
									    	    	   <img  src='../images/mandatory.gif'></img>
									    	    	    <% 
									    	    	    }
								    	    		  
								    	    		  
								    	    	  }
								    	    	  else if(type.equals("T"))
								    	    	  {
								    	    		  normalInd = "";
								    	    		  %>
								    	    		    <input type = "textbox"   onchange = "valueChange(this,'<%=nLoopCount1 %>')" data-discMsrId = "<%=oChartConfig.getDiscMsrDesc()%>" data-role = "none" maxLength= "5" class = "txtChartD" name = "custom_<%=oChartConfig.getSectionId() %>_<%=oChartConfig.getDiscMsrId() %>" id = "custom_<%=oChartConfig.getSectionId() %>_<%=oChartConfig.getDiscMsrId() %>"  data-mandatory = "<%=oChartConfig.getMandatoryYN() %>" onblur = "chkValidityOfTime(this)" />
								    	    		  <%
								    	    		  
								    	    		  if(oChartConfig.getMandatoryYN().equals("Y"))
									    	    	    {
									    	    	    %>
									    	    	   <img  src='../images/mandatory.gif'></img>
									    	    	    <% 
									    	    	    }
								    	    	  }
								    	    	  else if(type.equals("E"))
								    	    	  {
								    	    		 
								    	    		  %>
								    	    		     <input type = "textbox"    data-discMsrId = "<%=oChartConfig.getDiscMsrDesc()%>" data-role = "none" readonly class = "txtChartD" name = "custom_<%=oChartConfig.getSectionId() %>_<%=oChartConfig.getDiscMsrId() %>" id = "custom_<%=oChartConfig.getSectionId() %>_<%=oChartConfig.getDiscMsrId() %>"  data-mandatory = "<%=oChartConfig.getMandatoryYN() %>" /><input type ="button"  value='Now' class="btnTypeD"  data-role = "none" onclick = "displayDateTime('custom_<%=oChartConfig.getSectionId() %>_<%=oChartConfig.getDiscMsrId() %>','<%=nLoopCount1 %>')"/>
								    	    		  <%
								    	    		  if(oChartConfig.getMandatoryYN().equals("Y"))
									    	    	    {
									    	    	    %>
									    	    	   <img  src='../images/mandatory.gif'></img>
									    	    	    <% 
									    	    	    }
								    	    	  }
								    	    	  else if(type.equals("A"))
								    	    	  {
								    	    		
								    	    		  %>
								    	    		  <input type = "textbox"   onchange = "valueChange(this,'<%=nLoopCount1 %>')" data-summation = "Y" data-rownumber = "<%=nLoopCount1 %>" data-discMsrId = "<%=oChartConfig.getDiscMsrDesc()%>" data-role = "none"  class = "txtChartD" name = "custom_<%=oChartConfig.getSectionId() %>_<%=oChartConfig.getDiscMsrId() %>" id = "custom_<%=oChartConfig.getSectionId() %>_<%=oChartConfig.getDiscMsrId() %>"  data-mandatory = "<%=oChartConfig.getMandatoryYN() %>" />
								    	    		  <input type ="button"  value='+' class="btnTypeA"   data-formula = "<%=oChartConfig.getSummationFormula()%>" data-role = "none" onclick = "checkForNaN(this,'custom_<%=oChartConfig.getSectionId() %>_<%=oChartConfig.getDiscMsrId() %>','<%=nLoopCount1 %>')" />
								    	    		  <% 
								    	    	  }
								    	    	  else
								    	    	  {
								    	    		  normalInd = "";
								    	    		  %>
								    	    		 <input type = "textbox"   onchange = "valueChange(this,'<%=nLoopCount1 %>')" data-role = "none" data-discMsrId = "<%=oChartConfig.getDiscMsrDesc()%>" name = "custom_<%=oChartConfig.getSectionId() %>_<%=oChartConfig.getDiscMsrId() %>" id = "custom_<%=oChartConfig.getSectionId() %>_<%=oChartConfig.getDiscMsrId() %>"  data-mandatory = "<%=oChartConfig.getMandatoryYN() %>" class = "txtChart" maxLength= "20" onkeypress="return allowValidNumberLocal3(this, event)"  />   
								    	    		  <% 
								    	    	  }
								    	    	  
								    	       }
								    	       if(type != null &&  type.equals("C")) // to display checkbox control
								    	       {
								    	    	   
								    	    	  %>
								    	    	   <input type = "checkbox" data-role = "none"  class = "chkChart"  onclick = "evalCheckBox(this,'<%=nLoopCount1 %>')"/>  
								    	    	  
								    	    	 <%   
								    	       }
								    	       if(type != null &&  type.equals("L")) // to display list box control
								    	       {
								    	    	   normalInd = "";
								    	    	   defaultText = "------Select------";
								    	    	   %>
								    	    	      <select  class="cmbChart" data-role="none" onchange = "setComboValue(this,'<%=nLoopCount1 %>')" data-combo = "yes"> 
								    	    	      <option value=''>Select</option>
								    	    	   <% 
								    	    	   int nCount = 0;
								    	    	   int nsize = 0;
								    	    	   List<ChartCombo> oChartComboList = null;
								    	    	   oChartComboList = oChartConfig.getChartComboList();
								    	    	   String selected = "";
								    	    	   String dfSelected = "";
								    	    	   if(oChartComboList != null)
								    	    	   {
								    	    		   nsize = oChartComboList.size();
								    	    		   if(nsize > 0)
								    	    		   {
								    	    			   ChartCombo oChartCombo = null;
								    	    			   for(nCount = 0 ;nCount < nsize;nCount++)
								    	    			   {
								    	    				   oChartCombo = oChartComboList.get(nCount);
								    	    				   
								    	    				   if(oChartCombo != null)
								    	    				   {
								    	    					   normalInd = oChartCombo.getNormAbnormIndicator();
								    	    					   dfSelected = oChartCombo.getDfltYN();
								    	    					   if( dfSelected != null &&  dfSelected.equals("Y"))
								    	    					   {
								    	    						   selected = "selected";
								    	    						   defaultValue = oChartCombo.getRefRangeSeq();
								    	    						   defaultText = oChartCombo.getRefRangeDesc();
								    	    						   
								    	    					   }
								    	    					   else
								    	    					   {
								    	    						   selected = "";
								    	    					   }
								    	    					   %>
								    	    					    <option value = "<%=oChartCombo.getRefRangeSeq()%>" <%=selected %>><%= oChartCombo.getRefRangeDesc()%></option> 
								    	    					   <% 
								    	    				   }
								    	    				   
								    	    			   }
								    	    			   
								    	    		   }
								    	    	   }
								    	    	   %>
								    	    	   </select>
								    	    	   <% 
								    	    	   
								    	       }
								    	       
								    	       %>
								    	      
								    	       
								    	     </td>
								    	     <td class = "CThirdCol" valign = "center" align = "left">
								    	        <span class = "spChartRow"><%= oChartConfig.getUnits()%></span>
								    	     </td>
								     	 </tr>
								     </table>
									 <input type="hidden" name="discr_msr_id_grp_id<%=nLoopCount1 %>" id="discr_msr_id_grp_id<%=nLoopCount1 %>" id="discr_msr_id_grp_id<%=nLoopCount1 %>" value= "custom_<%=oChartConfig.getSectionId() %>_<%=oChartConfig.getDiscMsrId() %>" />
									 <input type="hidden" name="dis_msr_type_<%=nLoopCount1 %>" id="dis_msr_type_<%=nLoopCount1 %>" id="dis_msr_type_<%=nLoopCount1 %>" value="<%=type %>"/>
									 <input type="hidden" name="dis_msr_id_<%=nLoopCount1 %>" id="dis_msr_id_<%=nLoopCount1 %>" id ="dis_msr_id_<%=nLoopCount1 %>" value="<%=oChartConfig.getDiscMsrId() %>" />
									 <input type= "hidden" name="chat_grp_id_<%=nLoopCount1 %>" id="chat_grp_id_<%=nLoopCount1 %>" id ="chat_grp_id_<%=nLoopCount1 %>" value="<%=oChartConfig.getSectionId() %>"/>
									 <input type="hidden" name="comp_<%=nLoopCount1 %>" id="comp_<%=nLoopCount1 %>" id = "comp_<%=nLoopCount1 %>"  value="<%=defaultValue%>"/>
									 <input type="hidden" name="normal_low_<%=nLoopCount1 %>" id="normal_low_<%=nLoopCount1 %>" id ="normal_low_<%=nLoopCount1 %>" value= "<%=oChartConfig.getNormalLow() %>"/>
									 <input type="hidden" name="normal_high_<%=nLoopCount1 %>" id="normal_high_<%=nLoopCount1 %>" id ="normal_high_<%=nLoopCount1 %>" value= "<%=oChartConfig.getNormalHigh() %>"/>
									 <input type="hidden" name="critical_low_<%=nLoopCount1 %>" id="critical_low_<%=nLoopCount1 %>" id ="critical_low_<%=nLoopCount1 %>" value= "<%=oChartConfig.getCriticalLow() %>"/>
									 <input type="hidden" name="critical_high_<%=nLoopCount1 %>" id="critical_high_<%=nLoopCount1 %>" id ="critical_high_<%=nLoopCount1 %>" value= "<%=oChartConfig.getCriticalHigh()%>"/>
									 <input type="hidden" name="associate_score_yn<%=nLoopCount1 %>" id="associate_score_yn<%=nLoopCount1 %>" id ="associate_score_yn<%=nLoopCount1 %>" value= "<%=oChartConfig.getAssociateScoreYN() %>" />
									 <input type="hidden" name="normal_abnormal_ind_<%=nLoopCount1 %>" id="normal_abnormal_ind_<%=nLoopCount1 %>" id ="normal_abnormal_ind_<%=nLoopCount1 %>" value= "<%= normalInd %>" />
									 <input type="hidden" name="listItemValue<%=nLoopCount1 %>" id="listItemValue<%=nLoopCount1 %>" id ="listItemValue<%=nLoopCount1 %>" value = "<%=defaultText%>"/>
									 <input type="hidden" name="uom_<%=nLoopCount1 %>" id="uom_<%=nLoopCount1 %>" value="<%= oChartConfig.getUnits()%>">
									 <input type="hidden" name="hdnSF<%=nLoopCount1 %>" id="hdnSF<%=nLoopCount1 %>" id ="hdnSF<%=nLoopCount1 %>" value = "<%=oChartConfig.getSummationFormula()%>"/>
									 
									<% 
								
									strSectionId = oChartConfig.getSectionId();
								}//chartconfig
								 if(nCssCount==1)
								  {
									   nCssCount = nCssCount +1;
								  }
								  else
								  {
									  nCssCount = nCssCount -1;
								  }	  
							}//for
						}
					
					}
					catch ( Exception e ){
						out.println("Exception " + e);
						//out.println(sqlStr.toString());
						e.printStackTrace();
					}
			}
           %>
	     
	      
	    
	   </div>
	
    </div>
       <div class = "dvRecordControls">
	      <table class = "tbRecordControls" cellspacing = "0" cellpadding = "0" border = "0">
	        <tr class = "trRecordControls">
	          <td style = "width:55%"></td>
	          <td style ="width:15%" valign = "center" align = "right">
	            <!--  <input type ="button" name='btnVwHist' id='btnVwHist' value='View History' class="btnType1"  data-role = "none"/> -->
	          </td>
	           <td style ="width:15%" valign = "center" align = "center">
	              <input type ="button" name='btnRecord' id='btnRecord' value='Record' class="btnType1"  data-role = "none" onclick = "recordCharts(this)"/>
	           </td>
	            <td style ="width:15%" valign = "center" align = "left">
	              <input type ="button" name='btnCancel' id='btnCancel' value='Cancel' class="btnType1"  data-role = "none" onclick = "cancelRecord(this)"/>
	            </td>
	        </tr>
	      </table>
       </div>
    <input type = "hidden" name = "hdnPostBack" id = "hdnPostBack" value = "false" />
    <input type = "hidden" name = "hdnChartTypeCombo" id = "hdnChartTypeCombo" value = "<%=strChartType %>"/>
    <input type = "hidden" name = "hdnCurrentDate" id = "hdnCurrentDate" value = "<%=strCurrentDate %>"/>
    <input type = "hidden" name = "hdnCurrentDateTime" id = "hdnCurrentDateTime" value = "<%=strCurrentDatetime %>"/>
     <input type = "hidden" name = "count" id = "count" value = '<%=nListSize1 %>'/>
     <input type = "hidden" name = "hdnRecord" id = "hdnRecord" value = "<%=strRecord %>"/>
    <input type = "hidden" name = "hdnPatientId" id = "hdnPatientId" value = "<%=oPatientContext.sPatientId %>" /> 
    <input type = "hidden" name = "hdnTranState" id = "hdnTranState" value = "<%=recInsert %>" />
    <input type = "hidden" name = "hdnPatientClass" id = "hdnPatientClass" value = "<%=strPatientClass%>" />
    
     
    
 </form>
</section>
</body>
</html>

