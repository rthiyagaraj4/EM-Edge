<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8"%>
<html>
<%	request.setCharacterEncoding("UTF-8");	%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<head>



<Title> Transfusion Dialog</title>
 

<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script src="../../eBT/js/BTTransaction.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eBT/js/BTMaster.js"></Script>
<Script Language="JavaScript" src="../../eBT/js/BTTransaction.js"></Script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<Script Language="JavaScript" src="../../eBT/js/BTMessage.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<!-- Modified by DhanasekarV against SRR20056-5795  on date 22/10/2010-->
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>

  <script language='javascript'>

   function closeWindow()
        {
		   parent.window.close();
		}

       function checkVolume()
		{
		var obj=document.forms[0];
		// added by Sanjay on 17-Jan-14 against SRR20056-SCF-11264 STARTS
		var CURRENT_VOLUME = parseInt(obj.CURRENT_VOLUME.value);
		var PR_CURRENT_VOLUME = parseInt(obj.PR_CURRENT_VOLUME.value);
		// added by Sanjay on 17-Jan-14 against SRR20056-SCF-11264 ENDS
		

		// 47715 Sandeep K Gujje 19-MAR-2014

		if (BTCheckPositiveNumber(obj.CURRENT_VOLUME))
	{
		if(obj.PR_CURRENT_VOLUME.value=='0')
		{
		//alert(getBTMessage("VOLUME_NULL"));
		//BT0136,VOLUME_NULL
		alert(getBTMessage("BT0136",'BT'));
		return;
		}

		//BT0165,VOLUME_LT        

		if(obj.CURRENT_VOLUME==null||obj.CURRENT_VOLUME.value=='0'||obj.CURRENT_VOLUME.value=='')
		{
		//BT0136,VOLUME_NULL

		alert(getBTMessage("BT0136","BT"));
		return false;
		}
		
		// below line modified by Sanjay on 17-Jan-14 against SRR20056-SCF-11264
		//if (parseInt(CURRENT_VOLUME) < parseInt(PR_CURRENT_VOLUME))		
		if (parseInt(CURRENT_VOLUME) > parseInt(PR_CURRENT_VOLUME))		
		//if( obj.CURRENT_VOLUME.value > obj.PR_CURRENT_VOLUME.value)
		{			
		 //Modified by DhanasekarV against % message issue  on 14/06/2011
		var cur_vol = getLabel("eBT.CurrentVolume.label","BT");
		var pre_vol = getLabel("eBT.PreviousVolume.label","BT");
		//var msg1 = getBTMessage("BT0165",'BT');
		var msg1 = getBTMessage("BT0164",'BT');
	    msg1= msg1.replace('%1',cur_vol);
		msg1=msg1.replace('%2',pre_vol);
		alert(msg1);

		// 47715 Sandeep K Gujje 19-MAR-2014
		obj.CURRENT_VOLUME.value = '';
//		obj.CURRENT_VOLUME.focus();

		return false;
		}
	}
		}

function checkSTDate(objSt,objIS,objRE,objSYS,objEn,objEX)
	{
		
	var locale		= document.forms[0].locale.value;
		if(objSt==null||objSt.value=='') 
		{			
			return;
		}
  var obj1=changeDate1(objSt.value);
  var obj2=changeDate1(objIS.value);
  var obj3=changeDate1(objRE.value);
  var obj4=changeDate1(objSYS.value);
  var obj6=changeDate1(objEX.value);	



  if(objEn != null||objEn.value !='')
		{
		  var obj5=changeDate1(objEn.value);
		   if(obj1 > obj5)
					{
				alert(getBTMessage("BT0527","BT"));
				objSt.value='';
				 return;
				   }
		}


if(!(isBeforeNow(objSt.value,"DMYHM",locale) ))
	{
		alert(getBTMessage("BT0414","BT"));
		objSt.value='';
		return;
	}

/*  if(obj1 > obj4 ) {	    
		alert(getBTMessage("BT0414","BT"));
		objSt.value='';
		return;
		}*/

  if(obj1 < obj2 )
	  { 	
//BT0114,DATE_ST_GT_ISSUE

  alert(getBTMessage("BT0114","BT"));
  objSt.value='';
  return;}
//BT0115,DATE_ST_LT_RESER
//alert(obj1+"and"+obj3);
  if(obj1 > obj3)       { alert(getBTMessage("BT0115","BT"));
    objSt.value='';
  return;}
	
if(obj1 > obj6)       { alert(getBTMessage("BT0551","BT"));
    objSt.value='';
  return;}

	
	}


function checkEnDate(objEt,objTR,objRE,objSYS,objEX)
	{
		

var locale		= document.forms[0].locale.value;

  if(objEt==null||objEt.value=='')
		{	  
		return ;
		}

  var obj1=changeDate1(objEt.value);
  var obj2=changeDate1(objTR.value);
  var obj3=changeDate1(objRE.value);
  var obj4=changeDate1(objSYS.value);
  var obj5=changeDate1(objEX.value);

//BT0117,DATE_EN_LT_SYS

if(!(isBeforeNow(objEt.value,"DMYHM",locale) ))
	{
		alert(getBTMessage("BT0117","BT"));
		objEt.value='';
		return;
	}

/*  if(obj1 > obj4 ) {	    
		alert(getBTMessage("BT0117","BT"));
		objEt.value='';
		return;}*/
//BT0118,DATE_EN_GT_TRANS

  if(obj1 < obj2)    { alert(getBTMessage("BT0118","BT"));
  objEt.value='';
  return;}
//BT0119,DATE_EN_LT_RESER
//alert("obj1==="+obj1+"obj3=="+obj3)
  if(obj1 > obj3)     {  alert(getBTMessage("BT0119","LT"));
  objEt.value='';
  return;}	
if(obj1 > obj5)       { alert(getBTMessage("BT0550","BT"));
    objEt.value='';
  return;}


	}


function changeDate1(objEt)
{
	var objStr=new Array();
	objStr=objEt.split("/");
	var datVal='';
	//alert("date"+objStr);
	if(objStr != null && objStr.length>0)
	{
	 datVal+=objStr[1]+"/";
	 datVal+=objStr[0]+"/";
	 datVal+=objStr[2];
	}
	else	 datVal=objEt;

	var dat=new Date(datVal);
	 return dat;
 }

// 47715 Sandeep K Gujje 19-MAR-2014
function BTCheckNumber(obj) {
   var sequence = "0123456789";
   var obj_value = obj.value;
   var obj_length = obj_value.length;

   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			//alert("ONLY_POSITIVE_NUM");
			alert(getBTMessage('BT0314','BT'));
			obj.value = '';
			//obj.focus();
			return false;
		}
   }

   return true ;
}

// 47715 Sandeep K Gujje 19-MAR-2014
function BTCheckPositiveNumber(obj) {
   var sequence = "123456789";
   var obj_value = obj.value;
   var obj_length = obj_value.length;


	if(obj.value == ""){
		return true;
	}

	if(obj != null)
	{
		if(!BTCheckNumber(obj))
			return false;

		if(parseInt(obj.value) <= 0){
			alert(getBTMessage('BT0136','BT')); 
			obj.value = '';
			//obj.focus();
			return false;
		}

		return true;
	
	}
}


function validateNull()
{
var obj=document.forms[0];


var strUser=obj.LOGIN_USER.value;
obj.LOGIN_USER.value=strUser.toUpperCase();

/* Commented by Sanjay against SRR20056-SCF-12161 on 03-Jan-14
strUser=obj.TRANSFUSE_PRACT_ID.value;
obj.Practioner_Name1.value=strUser.toUpperCase();

strUser=obj.TRANSFUSE_PRACT_ID_2.value;
obj.Practioner_Name2.value=strUser.toUpperCase();
*/

//alert(obj.LOGIN_USER.value+"name1"+obj.Practioner_Name1.value+"name2"+obj.Practioner_Name2.value);

if(obj.CHECK_PRACT_ID.value==null||obj.CHECK_PRACT_ID.value=='')
	{
	//Dhana BT0267 TXT_PRACT_NULL
	alert(getBTMessage("BT0438","BT"));
	return false;
	}
if(obj.TRANSFUSE_PRACT_ID.value==null||obj.TRANSFUSE_PRACT_ID.value=='')
	{
	//Dhana BT0267 TXT_PRACT_NULL
	alert(getBTMessage("BT0267","BT"));
	return false;
	}

 if(obj.TRANSFUSE_PRACT_ID.value != obj.LOGIN_USER.value) 

    if (obj.TRANSFUSE_PRACT_ID_2.value != null)
	{
     if(obj.TRANSFUSE_PRACT_ID_2.value != obj.LOGIN_USER.value)
	{
		 //BT0266, PARCT_ID_CURRENT_USER		 
	alert(getBTMessage("BT0266","BT"));
	return false;
	}
	
	}
	else
	{		
		// BT0266 ,PARCT_ID_CURRENT_USER
	alert(getBTMessage("BT0266","BT"));
	return false;
	}	

	// 47715 Sandeep K Gujje 19-MAR-2014
	// Changed if condition to validate volume field properly
	// if(obj.CURRENT_VOLUME=='0'||obj.CURRENT_VOLUME==null)
	// alert("47715 - "+obj.CURRENT_VOLUME+", "+obj.CURRENT_VOLUME.value+", "+obj.CURRENT_VOLUME.value.length); 
	if(obj.CURRENT_VOLUME==null||obj.CURRENT_VOLUME.value=='0'||obj.CURRENT_VOLUME.value=='')
	{
	//BT0136,VOLUME_NULL

	alert(getBTMessage("BT0136","BT"));
	return false;
	}

if(obj.REACTION_CODE.value==null||obj.REACTION_CODE.value=='')
	{
	//BT0131,REACTION_CODE_NULL
	alert(getBTMessage("BT0131","BT"));
	return false;
	}

if(obj.TRANSFUSE_ST_DATE_TIME.value==null||obj.TRANSFUSE_ST_DATE_TIME.value=='')
	{
	//BT0113,DATE_ST_NULL

	alert(getBTMessage("BT0113","BT"));
	return false;
	}
	if(obj.TRANSFUSE_EN_DATE_TIME.value==null||obj.TRANSFUSE_EN_DATE_TIME.value=='')
	{
		//BT0116,DATE_EN_NULL
	alert(getBTMessage("BT0116","BT"));
	return false;
	}

     if(obj.DISC_CHECK.value == 'Y' && (obj.TRANS_CODE.value==null||obj.TRANS_CODE.value==''))
	{
		 //BT0167,PARTIAL_TRANS_CODE
		 //Modified by DhanasekarV against % message issue on 14/06/2011
		 var  trn_code = getLabel("eBT.PartialTransfusionReason.label","BT");
		 var msg2 = getBTMessage("BT0167","BT");
		  msg2=msg2.replace('%1',trn_code);
		alert(msg2);
		return false;
	}

	/* added by Sanjay against SRR20056-SCF-12161 on 03-Jan-14 STARTS here */
	strUser=obj.TRANSFUSE_PRACT_ID.value;
	obj.Practioner_Name1.value=strUser.toUpperCase();
	strUser=obj.TRANSFUSE_PRACT_ID_2.value;
	obj.Practioner_Name2.value=strUser.toUpperCase();
	/* added by Sanjay against SRR20056-SCF-12161 on 03-Jan-14 ENDS here */



<% String locale = (String)session.getAttribute("LOCALE"); %>

/*else if(obj.Practioner_Name2.value!=null)
	{
if(obj.Practioner_Name1.value!=obj.LOGIN_USER.value && 		obj.Practioner_Name2.value!=obj.LOGIN_USER.value )
		{
			alert(getBTMessage("PARCT_ID_CURRENT_USER"));
			return false;
		}
	}
else 
	if(obj.Practioner_Name1.value!=obj.LOGIN_USER.value)
		{
		 alert(getBTMessage("PARCT_ID_CURRENT_USER"));
		 return false;
		}
*/

	return true;
}


function transfusionDlgSubmit()
	{
try
		{
	if(validateNull()==false) return;
	var objFrm=document.forms[0];
	//alert("1"+objFrm);//Sanjay
	var data = funBTXMLFormApply(objFrm);
	//alert(data);//Sanjay

  var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();

    xmlDoc.loadXML(data);
	
	xmlHttp.open("POST", "../../servlet/eBT.BTTransfuseServlet", false);
    xmlHttp.send(xmlDoc);

	var resTxt=xmlHttp.responseText;
	
	parent.window.returnValue=resTxt;
		
	parent.window.close();
		}
		catch(e)
		{
			alert('exception'+e);
		}
		
		}

function funCheck(objChe)
{
objFrm=document.forms[0];
if(objChe.checked == true)
	{	
objFrm.TRANS_BS.disabled=false;
objFrm.DISC_CHECK.value='Y';
	}
else
	{
	objFrm.TRANS_BS.disabled=true;
	objFrm.DISC_CHECK.value='N';
	objFrm.TRANS_CODE.value='';
	objFrm.TRANS_DESC.value='';
	}

}

	   </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	    



    </head>


 <body onLoad="callStorageLocation()">
    <form name='BT_UNIT_REQUEST_DTL' id='BT_UNIT_REQUEST_DTL' method='post'   action='' target='messageFrame'> 

   	 <%



		String login_user;
		String strFid="";
		Properties p=null;
		HttpSession httpSession = request.getSession(false);
		p = (Properties)httpSession.getValue("jdbc"); 
		strFid=""+httpSession.getAttribute("facility_id");

		login_user =  p.getProperty("login_user");



		   String strUnitNo;
		   String strSpecimenNo;
		   String strProductCode;
		   String strFacilityId;
		   String strPatientId;
		   String strTransfusedVol;
		   String strTransfusedUnits;
		   String strRowId;
		   String strIssuedDate;
		   String strReservedDate;
		   String strSysDate;


		   String strRhesusCode;
		   String strBloodGroup;

		   String strSourceType="";
		   String strSourceCode="";
		   String strExpiryDate="";
		   String bar_code_scan_site_yn ="";//Added for MMS-DM-CRF-0157
		   String entry_type ="";//Added for MMS-DM-CRF-0157
		   String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="",patient_class="",encounter_id="";//Added for MMS-DM-CRF-0170.2





locale = (locale == null || locale.equals(""))?"en":locale;

java.util.Locale loc = new java.util.Locale(locale);
java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
//System.err.println("params@@@@===="+ request.getQueryString());

			strUnitNo=request.getParameter("UNIT_NO");
			strSpecimenNo=request.getParameter("SPECIMEN_NO");
		    strProductCode=request.getParameter("PRODUCT_CODE");
		    strFacilityId=request.getParameter("OPERATING_FACILITY_ID");
		    strPatientId=request.getParameter("PATIENT_ID");
			strTransfusedVol=request.getParameter("CURRENT_VOLUME");
			strRowId=request.getParameter("ROW_ID");
			strTransfusedUnits=request.getParameter("VOLUME_UNITS");

			//strIssuedDate=request.getParameter("ISSUED_DATE");
			//strReservedDate=request.getParameter("RESERVED_DATE");
			
			strIssuedDate=com.ehis.util.DateUtils.convertDate(request.getParameter("ISSUED_DATE"),"DMYHM","en",locale);
			strReservedDate=com.ehis.util.DateUtils.convertDate(request.getParameter("RESERVED_DATE"),"DMYHM","en",locale);

			strExpiryDate= com.ehis.util.DateUtils.convertDate(request.getParameter("EXPIRY_DATE"),"DMYHM","en",locale);
		//strSysDate=request.getParameter("SYDATE");
			strSysDate		= com.ehis.util.DateUtils.getCurrentDate("DMYHMS",locale);	
		//strSysDate=com.ehis.util.DateUtils.convertDate(request.getParameter("SYDATE"),"DMYHMS","en",locale);
		//strSysDate=com.ehis.util.DateUtils.convertDate("03/01/2007 8:16","DMY","en",locale);
		//strSysDate=com.ehis.util.DateUtils.convertDate("03/01/2007 08:13","DMYHM","en",locale);
		//strSysDate=request.getParameter("SYDATE");


			strRhesusCode=request.getParameter("RHESUS_CODE");
			strBloodGroup=request.getParameter("BLOOD_GROUP");
			bar_code_scan_site_yn=request.getParameter("BAR_CODE_SCAN_SITE_YN");//Added for MMS-DM-CRF-0157
			patient_class=request.getParameter("PATIENT_CLASS");//Added for MMS-DM-CRF-0170.2
			encounter_id=request.getParameter("ENCOUNTER_ID");//Added for MMS-DM-CRF-0170.2
			scan_count_required_yn=request.getParameter("SCAN_COUNT_REQUIRED_YN");//Added for MMS-DM-CRF-0170.2
			alert_required_yn=request.getParameter("ALERT_REQUIRED_YN");//Added for MMS-DM-CRF-0170.2
			remarks_required_yn=request.getParameter("REMARKS_REQUIRED_YN");//Added for MMS-DM-CRF-0170.2		
			entry_type=request.getParameter("ENTRY_TYPE");//Added for MMS-DM-CRF-0157
			System.err.println("bar_code_scan_site_yn11111@@@===="+bar_code_scan_site_yn+"entry_type==="+entry_type+"scan_count_required_yn==="+scan_count_required_yn+"alert_required_yn=="+alert_required_yn+"encounter_id===="+encounter_id+"patient_class==="+patient_class);


		//eBT.LogFile.log("QADebugger","Rhesus"+strRhesusCode,this);
		//eBT.LogFile.log("QADebugger","strBloodGroup"+strBloodGroup,this);

		Connection conn=null;


		PreparedStatement pstmt1=null;
		ResultSet rs1=null;
		String sql=" SELECT NVL(SHORT_DESC,'')  from BT_UOM_MAST_LANG_VW where  language_id = ? and  UOM_CODE =  ?";
		
		try
		{
			conn = ConnectionManager.getConnection(request);
			pstmt1 = conn.prepareStatement(sql);
			pstmt1.setString(1,locale);
			pstmt1.setString(2,strTransfusedUnits);
			rs1 = pstmt1.executeQuery();
			if(rs1.next())
			{
			strTransfusedUnits=rs1.getString(1);
			}

		}catch(Exception ee){}
		finally
		{
		rs1.close();
		pstmt1.close();		
		}


		PreparedStatement pstmt=null;
		ResultSet rs=null;
		sql="select SOURCE_TYPE,SOURCE_CODE from BT_UNIT_REQUEST_HDR where SPECIMEN_NO=? and operating_facility_id=?";
		
		try
		{

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,strSpecimenNo);
			pstmt.setString(2,strFacilityId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
			strSourceType=rs.getString(1);
			strSourceCode=rs.getString(2);
			}

		}catch(Exception ee){}
		finally
		{
		rs.close();
		pstmt.close();
		ConnectionManager.returnConnection(conn,request);
		}
		ConnectionManager.returnConnection(conn,request);

%>
		


	
<table width='100%'  cellpadding='0' cellspacing='0' border='0'>

<!--<tr>
<td class='label' align='left'>&nbsp;</td>
<td class='label' align='left'><fmt:message key="eBT.UnitNo.label" bundle="${bt_labels}"/></td>
<td class='label' align='left'>&nbsp;</td>
</tr> -->

<tr>
<td class='label' align='left'>&nbsp;</td>
<td class='label' align='left'><fmt:message key="eBT.UnitNo.label" bundle="${bt_labels}"/>&nbsp&nbsp
<input type='text' name='UNIT_NO' id='UNIT_NO' maxlength='20' size='20' value= "<%=strUnitNo%>"  RECORD_TYPE='S' disabled> </td>
<td class='label' align='left'>&nbsp;</td>
</tr>

<tr>
<td colspan='3' class='label'>&nbsp;</td>
</tr>


<tr>
<td class='label' align='left'><fmt:message key="eBT.CheckedPractioner.label" bundle="${bt_labels}"/></td>
<td class='label' align='left'><fmt:message key="eBT.TransfuseByPractitioner.label" bundle="${bt_labels}"/></td>
<td class='label' align='left'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
</tr>


<tr>
<td class='label' align='left'>
<input type='text' name='Checked_Practioner' id='Checked_Practioner' maxlength='30' size='30' value= "" disabled>
<input type='button' class='Button' value='?' onClick="funBTCheckDetail1('3')"  name='bs' id='bs'>
<img src='..\..\eCommon/images/mandatory.gif'></img>
</td>
<td class='label' align='left'>
<input type='text' name='Practioner_Name1' id='Practioner_Name1' maxlength='30' size='25' value= "" disabled>
<input type='button' class='Button' value='?' onClick="funBTCheckDetail1('1')"  name='bs' id='bs'>
<img src='..\..\eCommon/images/mandatory.gif'></img>
</td>

<td class='label' align='left'>
<input type='text' name='Practioner_Name2' id='Practioner_Name2' maxlength='30' size='25' value= "" disabled>
<input type='button' class='Button' value='?' onClick="funBTCheckDetail1('2')"  name='bs' id='bs'>
</td>
</tr>
<tr>
<td colspan='3' class='label'>&nbsp;</td>
</tr>


<tr>
<td class='label' align='left'><fmt:message key="eBT.startdatetime.label" bundle="${bt_labels}"/></td>
<td class='label' align='left'><fmt:message key="Common.EndDateTime.label" bundle="${common_labels}"/></td>
<td class='label' align='left'>&nbsp;</td>
</tr>


<tr>
<td class='label' align='left'>
<input type='text' name='TRANSFUSE_ST_DATE_TIME' id='TRANSFUSE_ST_DATE_TIME' maxlength='19' size='19' value= "" RECORD_TYPE='S' Onblur='checkSTDate(this,document.forms[0].ISSUED_DATE,document.forms[0].RESERVED_DATE,document.forms[0].SYDATE,document.forms[0].TRANSFUSE_EN_DATE_TIME,document.forms[0].EXPIRY_DATE);' >      
<input type='image' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('TRANSFUSE_ST_DATE_TIME','dd/mm/y','hh:mm:ss');"
>&nbsp;
<img src='..\..\eCommon/images/mandatory.gif'></img>
</td>

<td class='label' align='left'>
<input type='text' name='TRANSFUSE_EN_DATE_TIME' id='TRANSFUSE_EN_DATE_TIME' maxlength='19' size='19' value= "" RECORD_TYPE='S' Onblur='checkEnDate(this,document.forms[0].TRANSFUSE_ST_DATE_TIME,document.forms[0].RESERVED_DATE,document.forms[0].SYDATE,document.forms[0].EXPIRY_DATE);' >      

<input type='image' src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('TRANSFUSE_EN_DATE_TIME','dd/mm/y','hh:mm:ss');">
<img src='..\..\eCommon/images/mandatory.gif'></img>
</td>
<td class='label' align='left'>&nbsp;</td>
</tr>

<tr>
<td colspan='3' class='label'>&nbsp;</td>
</tr>



<tr>
<td class='label' align='left' ><fmt:message key="Common.volume.label" bundle="${common_labels}"/></td>
<td class='label' align='left' colspan='2'><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StorageLocation.label","common_labels")%></td>
</tr>


<tr>
<td class ='label' align='left'>
<input type='text' name='CURRENT_VOLUME' id='CURRENT_VOLUME' maxlength='5' size='5' value= "<%=strTransfusedVol%>" RECORD_TYPE='S' Onblur='checkVolume()'>&nbsp;&nbsp;
<input type='text' name='xx1' id='xx1' maxlength='25' size='15' value= "<%=strTransfusedUnits%>" disabled>      
&nbsp;&nbsp;&nbsp;
</td>
<td class='label' align='left'>
<input type='text' name='LOCATION_CODE' id='LOCATION_CODE' maxlength='4' size='4' value= "" RECORD_TYPE='S' Onblur='validateStorage();'>      
<input type='button' class='button' value='?'   name='bs' id='bs'
onClick="funBTStorageLocation()">
&nbsp;</td>

<td  class='label'>&nbsp;</td> 
</tr>


<tr>
<td colspan='3' class='label'>&nbsp;</td>
</tr>

<tr>
<td class='label' align='left'><fmt:message key="Common.ReactionCode.label" bundle="${common_labels}"/></td>
<td class='label' align='left'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<td class='label' align='left'><fmt:message key="Common.AdverseReaction.label" bundle="${common_labels}"/></td>
</tr>

<tr>
<td class ='label' align='left'  >
<input type='text' name='REACTION_CODE' id='REACTION_CODE' maxlength='4' size='4' value= "" RECORD_TYPE='S' disabled>&nbsp;
</td>
<td class ='label' align='left'  >
<input type='text' name='REACTION_DESC' id='REACTION_DESC' maxlength='40' size='30' value= "" disabled>   
<input type='button' class='button' value='?'   name='bs' id='bs'
onClick="funBTReactionDetail()"
><img src='..\..\eCommon/images/mandatory.gif'></img></td>
<td class='label' align='left'><input type='checkbox' name='adverse' id='adverse' disabled></td>
</tr>

<tr>
<td colspan='3' class='label'>&nbsp;</td>
</tr>

<tr>
<td colspan='3' class='label'><fmt:message key="eBT.TransfusionRemarks.label" bundle="${bt_labels}"/></td>
</tr>

<tr>
<td class='label' colspan='3' align='left'>
 <TEXTAREA NAME="TRANSFUSION_REMARKS" ROWS="2" COLS="40" RECORD_TYPE='S'></TEXTAREA>
</td>
</tr>


<tr>
<td class='label' align='left'> <fmt:message key="Common.Discontinue.label" bundle="${common_labels}"/>?</td>
<td class='label' align='left' colspan='2'><fmt:message key="eBT.PartialTransfusionDesc.label"  bundle="${bt_labels}"/></td>
<td class='label' align='left'></td>
</tr>


<tr>
<td class ='label' align='left' >
<input type='checkbox' name='DISCONTINUE' id='DISCONTINUE'  align='center' onClick="funCheck(this)"  >&nbsp;&nbsp;  
</td>

<td class ='label' align='left' colspan='2'>
<input type='text' name='TRANS_CODE' id='TRANS_CODE' maxlength='5' size='5' RECORD_TYPE='S' readonly>     
&nbsp;&nbsp;
<input type='text' name='TRANS_DESC' id='TRANS_DESC' maxlength='30' size='30' value= "" Onblur='' readonly>
<input type='button' class='button' value='?'   name='TRANS_BS' id='TRANS_BS' onClick="funBTReasonDetail()" disabled>
</td>
</tr>


<tr>
<td class ='label' ></td>
<td class ='label' ></td>
<td class ='label'  align='right' >

<!--<input type='Button' class='button'  name="save" id="save" value= '<fmt:message key="Common.apply.label" bundle="${common_labels}"/>'OnClick='transfusionDlgSubmit()'> 
<input type='button' value='<%=common_labels.getString("Common.apply.label")%>' name='save' class='BUTTON' OnClick='transfusionDlgSubmit()>
&nbsp;&nbsp;<input type='Button' class='button'  name="cancel1" id="cancel1" value= '<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='javascript:closeWindow()'>  -->
<input type='Button' class='button'  name="save" id="save" value= '<%=common_labels.getString("Common.apply.label")%>'
OnClick='transfusionDlgSubmit()'> 
&nbsp;&nbsp;<input type='Button' class='button'  name="cancel" id="cancel" value= '<%=common_labels.getString("Common.cancel.label")%>' onClick='javascript:closeWindow()'>
</td>
</tr>
</table>
</table>  
<input type='hidden' name='SYDATE' id='SYDATE' value='<%=strSysDate%>'>
<input type='hidden' name='ISSUED_DATE' id='ISSUED_DATE' value='<%=strIssuedDate%>'>
<input type='hidden' name='RESERVED_DATE' id='RESERVED_DATE' value='<%=strReservedDate%>'>
<input type='hidden' name='EXPIRY_DATE' id='EXPIRY_DATE' value='<%=strExpiryDate%>'>
<input type='hidden' name='LOGIN_USER' id='LOGIN_USER' value='<%=login_user%>'>

<input type='hidden' name='PR_CURRENT_VOLUME' id='PR_CURRENT_VOLUME' value='<%=strTransfusedVol%>'>


<input type='hidden' name='PATIENT_ID' id='PATIENT_ID' value='<%=strPatientId%>' RECORD_TYPE='S'>

<input type='hidden' name='SPECIMEN_NO' id='SPECIMEN_NO' value='<%=strSpecimenNo%>' RECORD_TYPE='S'>

<input type='hidden' name='PRODUCT_CODE' id='PRODUCT_CODE' value='<%=strProductCode%>' RECORD_TYPE='S'>


<input type='hidden' name='PRACTIONER_CODE' id='PRACTIONER_CODE' value='<%=strProductCode%>' RECORD_TYPE='S'>

<input type='hidden' name='RHESUS_CODE' id='RHESUS_CODE' value="<%=strRhesusCode%>" >

<input type='hidden' name='BLOOD_GROUP' id='BLOOD_GROUP' value="<%=strBloodGroup%>" >

<input type='hidden' name='locale' id='locale' value="<%=locale%>">

<input type='hidden' name='FACILITY_ID' id='FACILITY_ID' value='<%=strFacilityId%>' RECORD_TYPE='S'>

<input type='hidden' name='FID' id='FID' value='<%=strFid%>' >

<input type='hidden' name='TRANSFUSE_PRACT_ID' id='TRANSFUSE_PRACT_ID' value='' RECORD_TYPE='S'> 
<input type='hidden' name='TRANSFUSE_PRACT_ID_2' id='TRANSFUSE_PRACT_ID_2' value='' RECORD_TYPE='S'> 
<input type='hidden' name='CHECK_PRACT_ID' id='CHECK_PRACT_ID' value='' RECORD_TYPE='S'> 

<input type='hidden' name='ROW_ID' id='ROW_ID' value='<%=strRowId%>' RECORD_TYPE='S'> 

<input type='hidden' name='DISC_CHECK' id='DISC_CHECK' value='N'  RECORD_TYPE='S'>
<input type='hidden' name='SOURCE_TYPE' id='SOURCE_TYPE' value='<%=strSourceType%>'> 
<input type='hidden' name='SOURCE_CODE' id='SOURCE_CODE' value='<%=strSourceCode%>'> 
<input type='hidden' name='BAR_CODE_SCAN_SITE_YN' id='BAR_CODE_SCAN_SITE_YN' value='<%=bar_code_scan_site_yn%>' RECORD_TYPE='S'> <!-- Added for MMS-DM-CRF-0157 -->
<input type='hidden' name='ENTRY_TYPE' id='ENTRY_TYPE' value='<%=entry_type%>' RECORD_TYPE='S'> <!-- Added for MMS-DM-CRF-0157 -->
<input type='hidden' name='REASON_CODE' id='REASON_CODE' value='' RECORD_TYPE='S'> <!-- Added for MMS-DM-CRF-0157 -->
<input type='hidden' name='REASON_DESC' id='REASON_DESC' value='' RECORD_TYPE='S'> <!-- Added for MMS-DM-CRF-0157 -->
<input type='hidden' name='MODULE_ID' id='MODULE_ID' value='BT' RECORD_TYPE='S'> <!-- Added for MMS-DM-CRF-0157 -->
<input type='hidden' name='MENU_ID' id='MENU_ID' value='BLOOD_CONSUMPTION' RECORD_TYPE='S'> <!-- Added for MMS-DM-CRF-0157 -->
<input type='hidden' name='BARCODE_SCAN_COUNT_YN' id='BARCODE_SCAN_COUNT_YN' value='<%=bar_code_scan_site_yn%>' RECORD_TYPE='S'> <!-- Added for MMS-DM-CRF-0157 -->
<input type='hidden' name='PATIENT_CLASS' id='PATIENT_CLASS' value='<%=patient_class%>' RECORD_TYPE='S'> <!-- Added for MMS-DM-CRF-0170.2 -->
<input type='hidden' name='ENCOUNTER_ID' id='ENCOUNTER_ID' value='<%=encounter_id%>' RECORD_TYPE='S'> <!-- Added for MMS-DM-CRF-0170.2 -->
<input type='hidden' name='SCAN_COUNT_REQUIRED_YN' id='SCAN_COUNT_REQUIRED_YN' value='<%=scan_count_required_yn%>' RECORD_TYPE='S'> <!-- Added for MMS-DM-CRF-0170.2 -->
<input type='hidden' name='ALERT_REQUIRED_YN' id='ALERT_REQUIRED_YN' value='<%=alert_required_yn%>' RECORD_TYPE='S'> <!-- Added for MMS-DM-CRF-0170.2 -->
<input type='hidden' name='REMARKS_REQUIRED_YN' id='REMARKS_REQUIRED_YN' value='<%=remarks_required_yn%>' RECORD_TYPE='S'> <!-- Added for MMS-DM-CRF-0170.2 -->

</form>
</body>
</html>

