<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>

<html>
<head>

<%request.setCharacterEncoding("UTF-8");	%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = ((String)session.getAttribute("LOCALE"));%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
<Script Language="JavaScript" src="../../eBT/js/BTTransaction.js"></Script>
<Script Language="JavaScript" src="../../eBT/js/BTMessage.js"></Script>
<Script Language="JavaScript" src="../../eBT/js/BTMaster.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>


<script Language="JavaScript">


 
function verifyUnitCheck(obj)
{

 var strValue="PATIENT_ID=\""+obj.PATIENT_ID+"\" ";
 strValue+="OPERATING_FACILITY_ID=\""+obj.OPERATING_FACILITY_ID+"\" ";
 strValue+="SPECIMEN_NO=\""+obj.SPECIMEN_NO+"\" ";
 strValue+="PRODUCT_CODE=\""+obj.PRODUCT_CODE+"\" ";
 strValue+="UNIT_NO=\""+obj.UNIT_NO+"\" ";
 strValue+="EXTERNAL_TRANSFER=\""+obj.EXTERNAL_TRANSFER+"\"";//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589

 var xmlForm="<root> <dummyXml ";
 xmlForm+=strValue;
 xmlForm+="/></root>";

	var isUnitNoProdCodeScanAppl = document.forms[0].isUnitNoProdCodeScanAppl.value;//Added on 19th Mar 2018 against MMS-DM-CRF-0137
	//alert(xmlForm);

    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();

    xmlDoc.loadXML(xmlForm);	

	xmlHttp.open("POST", "../../servlet/eBT.BTUnitCheckServlet", false);

    xmlHttp.send(xmlDoc);

	var resTxt=xmlHttp.responseText;

//	alert("Response Text"+resTxt);




if(resTxt==null||resTxt.charAt(0)=='Y'|| resTxt.charAt(0)=='y'||resTxt.charAt(0)=='0' )	
	{
	if(resTxt!=null)
		{
	var err=new Array();err=resTxt.split("||");
	
	alert(getBTMessage(err[1],'BT'));

	/*Added on 19th Mar 2018 against MMS-DM-CRF-0137 Start*/
	if(isUnitNoProdCodeScanAppl == "true"){
		document.forms[0].ProductCode.value = "";
		document.forms[0].ProductCode.disabled = true;
		document.forms[0].ProductImg.style.visibility = 'hidden';
		document.forms[0].UnitNo.value = "";
		document.forms[0].UnitNo.focus();
	}
	/*End*/

		}
	return false;
	}
	else	
		if(resTxt.charAt(0)=='X'||resTxt.charAt(0)=='x')
	{
	var err=new Array();err=resTxt.split("||");
	

	var dt=window.confirm(getBTMessage(err[1],'BT'));

	return dt;		
	}
	else
	return true;
}


function fun(obj)
 {
//verify procedure calling IF state == 'E' show error text else show WindowDialog

	/*var dialogHeight 		= "20" ;
	var dialogWidth  		= "42" ;
	var dialogTop   		= "200";
	var dialogLeft   		= "50";
	*/

	var isUnitNoProdCodeScanAppl = document.forms[0].isUnitNoProdCodeScanAppl.value;//Added on 19th Mar 2018 against MMS-DM-CRF-0137
	var bar_code_scan_site_YN    = document.forms[0].bar_code_scan_site_YN.value;
	var entry_type               =document.forms[0].entry_type.value;
	var encounter_id             =document.forms[0].encounter_id.value;// Added for MMS-DM-CRF-0170.2
	var patient_class            =document.forms[0].patient_class.value;// Added for MMS-DM-CRF-0170.2
	var scan_count_required_yn   = document.forms[0].scan_count_required_yn.value;// Added for MMS-DM-CRF-0170.2
    var alert_required_yn        =document.forms[0].alert_required_yn.value;// Added for MMS-DM-CRF-0170.2
    var remarks_required_yn      =document.forms[0].remarks_required_yn.value;// Added for MMS-DM-CRF-0170.2

	
	var dialogHeight 		= "23" ;
	var dialogWidth  		= "50" ;
	var dialogTop   		= "280";
	var dialogLeft   		= "150";

/*	var dialogHeight 		= "22" ;
	var dialogWidth  		= "42" ;
	var dialogTop   		= "320";
	var dialogLeft   		= "150";*/
	
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;

	var arguments			= "" ;

	//alert("here only");

	if(verifyUnitCheck(obj)==false) 
	 {
		obj.checked=false;

		/*Added on 19th Mar 2018 against MMS-DM-CRF-0137 Start*/
		if(isUnitNoProdCodeScanAppl == "true"){
			document.forms[0].ProductCode.value = "";
			document.forms[0].ProductCode.disabled = true;
			document.forms[0].ProductImg.style.visibility = 'hidden';
			document.forms[0].UnitNo.value = "";
			document.forms[0].UnitNo.focus();
		}
		/*End*/

		return false;	 
	 }
	
	var strValue="PATIENT_ID="+obj.PATIENT_ID+"&";
	 strValue+="OPERATING_FACILITY_ID="+obj.OPERATING_FACILITY_ID+"&";
	 strValue+="SPECIMEN_NO="+obj.SPECIMEN_NO+"&";
 	 strValue+="PRODUCT_CODE="+obj.PRODUCT_CODE+"&";
  	 strValue+="ROW_ID="+obj.ROW_ID+"&";
  	 strValue+="CURRENT_VOLUME="+obj.CURRENT_VOLUME+"&";
	 strValue+="VOLUME_UNITS="+obj.VOLUME_UNITS+"&";
	 strValue+="ISSUED_DATE="+obj.ISSUED_DATE+"&";
	 strValue+="RESERVED_DATE="+obj.RESERVED_DATE+"&";
	 strValue+="SYDATE="+obj.SYDATE+"&";	
	 strValue+="UNIT_NO="+obj.UNIT_NO+"&";
	strValue+="RHESUS_CODE="+obj.RHESUS_CODE+"&";
	strValue+="BLOOD_GROUP="+obj.BLOOD_GROUP+"&";
	strValue+="BAR_CODE_SCAN_SITE_YN="+bar_code_scan_site_YN+"&";// Added for MMS-DM-CRF-0157
	strValue+="ENTRY_TYPE="+entry_type+"&";//Added for MMS-DM-CRF-0157
	strValue+="ENCOUNTER_ID="+encounter_id+"&";// Added for MMS-DM-CRF-0170.2
	strValue+="PATIENT_CLASS="+patient_class+"&";// Added for MMS-DM-CRF-0170.2
	strValue+="SCAN_COUNT_REQUIRED_YN="+scan_count_required_yn+"&";// Added for MMS-DM-CRF-0170.2
	strValue+="ALERT_REQUIRED_YN="+alert_required_yn+"&";// Added for MMS-DM-CRF-0170.2
	strValue+="REMARKS_REQUIRED_YN="+remarks_required_yn;// Added for MMS-DM-CRF-0170.2
//alert("strValue=="+strValue);


         
	
	retVal=window.showModalDialog("../../eBT/jsp/BTTransfusionDlg.jsp?"+strValue,arguments,features);

	//	parent.frames[3].location.href ="../../eBT/jsp/BTTransfusionDlg.jsp?"+strValue;


	//alert("Successfully Completed"+retVal);


	if(retVal!=null && retVal.charAt(0)=='1')	
	 {
		obj.disabled=true;		    
		var objSel="document.forms[0]."+obj.ROW_ID;
		//alert(objSel);		
		var objSell=eval(objSel);
		//alert(objSell.name);
		objSell.value='UT';

		/*Added on 19th Mar 2018 against MMS-DM-CRF-0137 Start*/
		if(isUnitNoProdCodeScanAppl == "true"){
			document.forms[0].ProductCode.value = "";
			document.forms[0].ProductCode.disabled = true;
			document.forms[0].ProductImg.style.visibility = 'hidden';
			document.forms[0].UnitNo.value = "";
			document.forms[0].UnitNo.focus();
		}
		/*End*/
		
		/*Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589*/
		alert(getMessage("UNIT_TRANSFUSED",'BT'));
		funBTTransfusionHistory(parent.frames[1].document.forms[0]);
		/*End ML-MMOH-CRF-0589*/
	 }
	 else 
	 {   
		  obj.checked= false;

		/*Added on 19th Mar 2018 against MMS-DM-CRF-0137 Start*/
		if(isUnitNoProdCodeScanAppl == "true"){
			document.forms[0].ProductCode.value = "";
			document.forms[0].ProductCode.disabled = true;
			document.forms[0].ProductImg.style.visibility = 'hidden';
			document.forms[0].UnitNo.value = "";
			document.forms[0].UnitNo.focus();
		}
		/*End*/
  		 
		  if(retVal!=null)
		 {
		 alert(getBTMessage(retVal,'BT'));
		
		 funBTTransfusionHistory(parent.frames[1].document.forms[0]);
		 }
	 }

 }

function submitFormN()
	{
		var from = new Number(document.forms[0].from.value );
		var to = new Number(document.forms[0].to.value );
		var maxval = new Number(document.forms[0].max_records.value );
		document.forms[0].from.value = from + maxval;
		document.forms[0].to.value = to + maxval;
		document.forms[0].submit();
	}
function submitFormP()
{
		var from = new Number(document.forms[0].from.value );
		var to = new Number(document.forms[0].to.value );
		var maxval = new Number(document.forms[0].max_records.value );
		document.forms[0].from.value = from - maxval;
		document.forms[0].to.value = to - maxval;
		document.forms[0].submit();
}



 </script>


<style>

<%		Connection conn=null;
		PreparedStatement pstmt=null;
		CallableStatement cstmt=null;
		ResultSet rs=null;
		PreparedStatement pstmt1=null;//Added for MMS-DM-CRF-0170.2
		ResultSet rsSet=null;//ADded for MMS-DM-CRF-170.2
	    String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="",encounter_id="",patient_class="";//ADded for MMS-DM-CRF-170.2
		


		String strColorInd="";
		String strStageCode="";
		String strResultString="";
		
		//Added by Ashwini on 15-Mar-2018 for MMS-DM-CRF-0137
		String UnitNoFld = "";
		String ProductCodeFld = "";

		String strSpecimenNo="";

		String strColumnDelimiter = ",";
		String desc_data="";
		int max_records = 10;		
		
		StringTokenizer strToken=null;
		StringTokenizer strSubToken=null;

		int i = 0;

		ArrayList vectorColumnSizes = new ArrayList();
		ArrayList vectorColumnDescriptions = new ArrayList();
		ArrayList vectorHtmlData = new ArrayList();
		int start = 0,end = 0;
		int intFetchedRecords = 0;
		try
		{
		
			conn = ConnectionManager.getConnection(request);
		
			cstmt=conn.prepareCall("{ call BT_CONSUMBTION_COLOR(?,?,?,?,?,?,?,?)}");

			cstmt.setString(1,"0");
			cstmt.setString(2,"0");
			cstmt.setString(3,"0");
			cstmt.setString(4,"0");
			cstmt.setString(5,"2");
			cstmt.setString(6,"0");
			cstmt.registerOutParameter(7,Types.VARCHAR);
			cstmt.registerOutParameter(8,Types.VARCHAR);		

			cstmt.execute();

			strResultString = cstmt.getString(7);
		

		
		strToken=new StringTokenizer(strResultString,"#");

		while(strToken.hasMoreElements())
			{			
			strSubToken=new StringTokenizer(strToken.nextToken(),"@");
			while(strSubToken.hasMoreElements())
			{		
			strColorInd=strSubToken.nextToken();
			strStageCode=strSubToken.nextToken();
			}		
			
		%>
		TD.<%=strStageCode%>{
		BACKGROUND-COLOR:<%=strColorInd%>;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
<%	}%>
</style>
</head>
<!--Added by Ashwini on 15-Mar-2018 for MMS-DM-CRF-0137-->
<%
	Boolean isUnitNoProdCodeScanAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "BT","UNIT_NO_PRODUCT_CODE");
	//Adding start for MMS-DM-CRF-157
		Boolean bar_code_scan_site = eCommon.Common.CommonBean.isSiteSpecific(conn,"AM", "BARCODE_SCANNING_APPLICABLE");
		String bar_code_scan_site_YN = "";
		 encounter_id = request.getParameter("encounter_id");
		 patient_class = request.getParameter("patient_class");
				
				if(bar_code_scan_site)
				{
					bar_code_scan_site_YN = "Y";
				}
				else
				{
					bar_code_scan_site_YN = "N";
				}
        //Ading end for MMS-DM-CRF-157
		//Adding start for MMS-DM-CRF-0170.2
		try {
			if(bar_code_scan_site_YN.equals("Y")){
		
		ArrayList scanCountSetup    = new ArrayList();
		pstmt1 =conn.prepareStatement("SELECT SCAN_REQUIRED_YN,ALERT_REQUIRED_YN,REMARKS_REQUIRED_YN FROM PR_BARCODE_SCAN_SETUP WHERE FUNCTION_ID = ? AND PATIENT_CLASS =?");

		    pstmt1.setString(1, "BLOOD_CONSUMPTION");
			pstmt1.setString(2, patient_class.trim());
			rsSet = pstmt1.executeQuery() ;

			if(rsSet.next())
			{ 
				scan_count_required_yn= rsSet.getString("SCAN_REQUIRED_YN")==null?"N":rsSet.getString("SCAN_REQUIRED_YN");
				alert_required_yn =rsSet.getString("ALERT_REQUIRED_YN")==null?"N":rsSet.getString("ALERT_REQUIRED_YN");
				remarks_required_yn = rsSet.getString("REMARKS_REQUIRED_YN")==null?"N":rsSet.getString("REMARKS_REQUIRED_YN");
			 }
		}
		  }catch(Exception expSQL)
			{
					//eBT.LogFile.log("QADebugger","Exception "+expSQL,this);
                	expSQL.printStackTrace();			
			}
			finally
			{
				try
				{
					rsSet.close();
					pstmt1.close();
				}
				catch(Exception ee)
				{
					ee.printStackTrace();
				}
			}

//Addign end for MMS-DM-CRF-0170.2

%>
<!--Onload Added on 19th Mar 2018 against MMS-DM-CRF-0137-->
<body onload="<%if(isUnitNoProdCodeScanAppl){%>document.forms[0].UnitNo.focus();<%}%>">
<form name='form_query' id='form_query' RECORD_ID_NAME='ROWID' DETAIL_BLOCK_NAME='BTTable' method='post' action='BTTransfusionDetail.jsp'>

<!--Added by Ashwini on 15-Mar-2018 for MMS-DM-CRF-0137-->
<%if(isUnitNoProdCodeScanAppl){%>
<table border='0' width='40%' cellspacing='0' cellpadding='0'>
	<tr>
		<td class='label'><fmt:message key="eBT.UnitNo.label" bundle="${bt_labels}"/></td>
		<td class='fields'><input type='text' name='UnitNo' id='UnitNo' value='' onChange="compareUnitNo(this.value);" onKeydown="unitNoBarCodeChk(event, this.value); return CheckForSpecCharsInUnitProdCode(event);" onblur="unitNoBarCodeChk(event, this.value);disableProductCode();" maxlength="20" size="25"/></td><!-- unitNoBarCodeChk changed from onkeypres to onkeydown for mms-kh-crf-0091-->

		<td class='label'><fmt:message key="eBT.Product.label" bundle="${bt_labels}"/> <fmt:message key="eBT.Code.label" bundle="${bt_labels}"/></td>
		<td class='fields'><input type='text' name='ProductCode' id='ProductCode' value='' onChange="compareProductCode(this.value);" onKeyPress="prodCodeBarCodeChk(event, this.value); return CheckForSpecCharsInUnitProdCode(event);" maxlength="10" size="20" disabled/><img name="ProductImg" style="visibility:hidden" src='../../eCommon/images/mandatory.gif'align='center'></img></td>
	</tr>
</table>
<%}%>
<!--End MMS-DM-CRF-0137-->

	<%
			max_records = (request.getParameter("max_records")== null) ? 10:Integer.parseInt(request.getParameter("max_records"));
		

		   String strPatient_Id = request.getParameter("patient_id");

			strPatient_Id = (strPatient_Id == null) ? "":strPatient_Id;

			String strOrderFacilityId = request.getParameter("order_facility_id");

			strOrderFacilityId = (strOrderFacilityId == null) ? "":strOrderFacilityId;

			String sql = " SELECT 'DAT'||ROWNUM ROW_ID1,A.patient_id PATIENT_ID1, A.specimen_no SPECIMEN_NO1,F.short_Desc PRODUCT_DESC1,NVL(B.CURRENT_VOLUME,0) CURRENT_VOLUME1,NVL(B.VOLUME_UNITS,'') VOLUME_UNITS1,A.OPERATING_FACILITY_ID OPERATING_FACILITY_ID1, to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') SYDATE1,to_char(A.reserved_date,'dd/mm/yyyy hh24:mi') RESERVED_DATE1,to_char(A.issued_date,'dd/mm/yyyy hh24:mi') ISSUED_DATE1,A.unit_no UNIT_NO1, A.product_code PRODUCT_CODE1,NVL(TO_CHAR(E.TRANSFUSE_EXPECT_DATE_TIME,'dd/mm/yyyy hh24:mi:ss'),'') TRANS_EXP_DATE, B.blood_group BLOOD_GROUP1, B.rhesus_code RHESUS_CODE1,A.UNIT_STATUS UNIT_STATUS1, A.request_for_issue_by REQUEST_FOR_ISSUE_BY1,NVL(TO_CHAR(B.EXPIRY_DATE,'dd/mm/yyyy hh24:mi'),'') EXPIRYDATE, A.STORAGE_LOC_CODE FROM BT_UNIT_REQUEST_DTL A, BT_BLOOD_UNITS_MAST B, BT_OUTSTAND_SPECIMENS_VW C,BT_UOM_MAST_LANG_VW D,BT_UNIT_REQUEST_CATEGORY E,BT_PRODUCT_MAST_LANG_VW F WHERE  A.PATIENT_ID='"+strPatient_Id+"' and D.LANGUAGE_ID='"+locale+"' and C.ORDERED_FACILITY_ID='"+strOrderFacilityId+"' AND A.unit_no = B.unit_no and E.specimen_no= A.specimen_no and e.specimen_no = a.specimen_no and e.product_code =a.product_code and e.patient_id = a.patient_id and E.operating_Facility_id = C.operating_facility_id and A.product_code = B.product_code AND F.product_code = A.product_code and F.language_id =d.language_id and NVL(A.unit_status, 'UO') IN ('UI') AND A.operating_facility_id = C.operating_facility_id AND C.specimen_no = A.specimen_no AND B.operating_facility_id = C.operating_facility_id AND C.patient_id = A.patient_id AND NVL(B.VOLUME_UNITS,'X')= D.UOM_CODE(+) ORDER BY A.issued_date";

			//Above query modified by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589

//			String sql= request.getParameter("sql");
//			sql = (sql == null) ? "":sql;

			String from = request.getParameter( "from" ) ;

			String to = request.getParameter( "to" ) ;
	

			from = (from == null) ? "0":from;

			to = (to == null) ? max_records+"":to;

			String column_descriptions = request.getParameter("column_descriptions");

			column_descriptions = (column_descriptions == null) ? "":column_descriptions;

			//eBT.LogFile.log("QADebugger","Column Desc"+column_descriptions,this);

			String column_sizes = request.getParameter("column_sizes");
			column_sizes = (column_sizes == null) ? "":column_sizes;

			//eBT.LogFile.log("QADebugger","ColumnSize "+column_sizes,this);


			StringTokenizer strTokenizer = null;
			strTokenizer = new StringTokenizer(column_sizes,strColumnDelimiter);

			i = 0;

			while(strTokenizer.hasMoreTokens())
			{
				vectorColumnSizes.add(i, strTokenizer.nextToken());
				++i;
			}
			

			strTokenizer = null;
			strTokenizer = new StringTokenizer(column_descriptions,strColumnDelimiter);

			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
				vectorColumnDescriptions.add( i,strTokenizer.nextToken());
				++i;
			}



			start = Integer.parseInt(from) ;
			end  = Integer.parseInt(to);
			if (start<=0) from = "0";




			try
			{

				String strPatientId = "";
				String strFacilityId ="";
				strSpecimenNo="";
				String strUnitNo="";
				String strProductDesc="";
				String strProductCode= "";
				String strBloodGroup="";
				String  strRhesusCode="";
				String strChk="";

				String tagHtml="";
				String rec_id;
				String strUnitStatus="";
				String strTransfusedVol="";
				String strTransfusedUnit="";
				String strRowId="";
				String strIssuedDate="";
				String strReservedDate="";	
				String strSysDate="";
				String strDonateType="";
				String strTransExpectDate="";
				String strEmergency=""; 
				
				//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
				String transOutClick = " onClick='transToExternal(this)';";
				String strLocationCode = "";

				String row = "<tr style='background-color:;'>";
				String evn = "<td class='QRYEVEN'";
				String odd = "<td class='QRYODD'";
				String strHtmlData = "";


			

			//Dhana


				String strClickEvent = " onClick='fun(this)';";


				int intTempStart = start;

				

				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				//eBT.LogFile.log("QADebugger","sqlValue"+sql,this);			
			
			vectorHtmlData.add("<table border='1' width='100%' cellspacing='0' cellpadding='0' id='tb1'>");

			//eBT.LogFile.log("QADebugger","Finish 2",this);

			for(i=0;i<vectorColumnSizes.size();i++)
				{
				try
					{
				desc_data=""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,""+vectorColumnDescriptions.get(i),"bt_labels");
					}catch(Exception e1) 
						{
						desc_data ="";		
					  }
				vectorHtmlData.add("<td class='columnheader' width='"+vectorColumnSizes.get(i)+"%'>"+desc_data+"</td>");
				}

			
				
				while(rs.next())
				{
	

					if (!(intTempStart<=0))
					{
						--intTempStart;
						continue;
					}
					++intFetchedRecords;

					vectorHtmlData.add(row);					


				 strPatientId = rs.getString("PATIENT_ID1");
				 strPatientId =strPatientId==null?"":strPatientId;

				 strFacilityId=rs.getString("OPERATING_FACILITY_ID1");
				strFacilityId=strFacilityId==null?"":strFacilityId;

				 strSpecimenNo=rs.getString("SPECIMEN_NO1"); 		
				 strSpecimenNo=strSpecimenNo==null?"":strSpecimenNo;


				strUnitNo = rs.getString("UNIT_NO1");
				strUnitNo =strUnitNo ==null?"":strUnitNo ;

				strProductCode =rs.getString("PRODUCT_CODE1");
				strProductCode =strProductCode ==null?"":strProductCode;	


				strProductDesc =rs.getString("PRODUCT_DESC1");
				strProductDesc =strProductDesc ==null?"":strProductDesc;	

				strBloodGroup=rs.getString("BLOOD_GROUP1");
				strBloodGroup=strBloodGroup==null?"":strBloodGroup;

				strRhesusCode=rs.getString("RHESUS_CODE1");      		
				strRhesusCode=strRhesusCode==null?"":strRhesusCode;

				strUnitStatus=rs.getString("UNIT_STATUS1");
				strUnitStatus=strUnitStatus==null?"":strUnitStatus;

			strTransfusedVol=rs.getString("CURRENT_VOLUME1");
			strTransfusedVol=strTransfusedVol==null?"":strTransfusedVol;

			strRowId=rs.getString("ROW_ID1");
			strRowId=strRowId==null?"":strRowId;
			
			strIssuedDate=rs.getString("ISSUED_DATE1");
			strIssuedDate=strIssuedDate==null?"":strIssuedDate;

			strTransfusedUnit=rs.getString("VOLUME_UNITS1");
			strTransfusedUnit=strTransfusedUnit==null?"":strTransfusedUnit;
			//System.out.println("EBT  value "+strTransfusedUnit);

		   // strTransExpectDate=rs.getString("TRANS_EXP_DATE");
		  //  strTransExpectDate=strTransExpectDate==null?"":strTransExpectDate;

			strTransExpectDate=com.ehis.util.DateUtils.convertDate(rs.getString("TRANS_EXP_DATE"),"DMYHMS","en",locale);


			strReservedDate=rs.getString("RESERVED_DATE1");
			strReservedDate=strReservedDate==null?"":strReservedDate;

			strSysDate=rs.getString("SYDATE1");
			strSysDate=strSysDate==null?"":strSysDate;

			//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
			strLocationCode = rs.getString("STORAGE_LOC_CODE");
			strLocationCode = strLocationCode==null?"":strLocationCode;

			strIssuedDate=strIssuedDate==null?"":strIssuedDate;
	
			strReservedDate=strReservedDate==null?"":strReservedDate;

			rec_id="1";
			strChk="";
			cstmt.setString(1,strUnitNo);
			cstmt.setString(2,strSpecimenNo);
			cstmt.setString(3,strProductCode);
			cstmt.setString(4,strUnitStatus);
			cstmt.setString(5,"0");
			cstmt.setString(6,strFacilityId);
			cstmt.registerOutParameter(7,Types.VARCHAR);
			cstmt.registerOutParameter(8,Types.VARCHAR);

			/*System.out.println("EBT Unit No="+strUnitNo+" specimen No ="+strSpecimenNo+" product Code ="+strProductCode+" UnitStatus ="+strUnitStatus);
			*/
			cstmt.execute();
			strDonateType = cstmt.getString(7);
			strEmergency  = cstmt.getString(8);

		 // System.out.println("EBT === Donate Type "+strDonateType);

 		//  System.out.println("EBT === Emergency "+strEmergency);
	

				if (intFetchedRecords%2 == 0)
					{
						strHtmlData =  evn;
					}
					else
					{
						strHtmlData = odd;
					}

						tagHtml=strHtmlData+" align='left' >";


				  if(strDonateType.equals("0")==true)
					{
					tagHtml=tagHtml+"<b class='label'>&nbsp;"+strSpecimenNo+"</b></td>";							
					}
					else
					{
					tagHtml="<td class="+strDonateType+"><b class='WHITE'>"+strSpecimenNo+"&nbsp;</b></td>";	
					}


				  if(strEmergency.equals("N")==true)
					{
					tagHtml=tagHtml+strHtmlData+" align='left' ><b class='label'>"+strUnitNo+"&nbsp;</b><input type='hidden'name='UNIT_NO' value="+strUnitNo+"></td>";
					}
					else
					{
					tagHtml=tagHtml+"<td class="+strEmergency+" align='left' ><b class='label'>"+strUnitNo+"&nbsp;</b><input type='hidden'name='UNIT_NO' value="+strUnitNo+"></td>";
					}
						
						/*Added by Ashwini on 15-Mar-2018 for MMS-DM-CRF-0137*/
						if(isUnitNoProdCodeScanAppl){
							tagHtml=tagHtml+strHtmlData+" align='left' ><b class='label'>"+strProductCode+"/"+strProductDesc+"&nbsp;</b><input type='hidden'name='PRODUCT_CODE' value="+strProductCode+"></td>";
						}else
						{
							tagHtml=tagHtml+strHtmlData+" align='left' ><b class='label'>"+strProductDesc+"&nbsp;</b><input type='hidden'name='PRODUCT_CODE' value="+strProductCode+"></td>";
						}

						tagHtml=tagHtml+strHtmlData+" align='center' ><b class='label'>"+strBloodGroup+"&nbsp;</b></td>";
						tagHtml=tagHtml+strHtmlData+" align='center' ><b class='label'>"+strRhesusCode+"&nbsp;</b></td>";
						tagHtml=tagHtml+strHtmlData+"><select name='"+strRowId+"' id='"+strRowId+"' value='"+strUnitStatus+"' disabled> <option value='UI'>Issued  <option value='UT'>Transfused <option value='TF'>Transferred </select></td>";

						tagHtml=tagHtml+strHtmlData+" align='center' ><b class='label'>"+strTransExpectDate+"&nbsp;</b></td>";
					

						tagHtml=tagHtml+strHtmlData+"align='center'><input type='checkbox' name='"+strRowId+rec_id+"' id='"+strRowId+rec_id+"' PATIENT_ID='"+strPatientId+"'  OPERATING_FACILITY_ID='"+strFacilityId+"' SPECIMEN_NO='"+strSpecimenNo+"'				PRODUCT_CODE ='"+strProductCode+"' UNIT_NO='"+strUnitNo+"'	ROW_ID='"+strRowId+"'	VOLUME_UNITS='"+strTransfusedUnit+"' 		RHESUS_CODE='"+strRhesusCode+"' 	BLOOD_GROUP='"+strBloodGroup+"' 			ISSUED_DATE='"+strIssuedDate+"'				SYDATE='"+strSysDate+"'						RESERVED_DATE='"+strReservedDate+"'		CURRENT_VOLUME='"+strTransfusedVol+"' EXTERNAL_TRANSFER='' align='center' "+strClickEvent+"  "+strChk+" ></td>"; //Modified by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589

						/*Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589*/
						tagHtml=tagHtml+strHtmlData+"align='center'>&nbsp;<input type='image' src='../../eCommon/images/Transfer.PNG' style='width:21px;height:13px;' name='"+strRowId+rec_id+"' id='"+strRowId+rec_id+"' PATIENT_ID='"+strPatientId+"'  OPERATING_FACILITY_ID='"+strFacilityId+"' SPECIMEN_NO='"+strSpecimenNo+"' PRODUCT_CODE ='"+strProductCode+"' UNIT_NO='"+strUnitNo+"'	ROW_ID='"+strRowId+"' VOLUME_UNITS='"+strTransfusedUnit+"' ISSUED_DATE='"+strIssuedDate+"' SYDATE='"+strSysDate+"' RESERVED_DATE='"+strReservedDate+"' CURRENT_VOLUME='"+strTransfusedVol+"' STORAGE_LOC_CODE='"+strLocationCode+"' EXTERNAL_TRANSFER='ExternalTransfer' align='center' "+transOutClick+"></td>";
						/*End ML-MMOH-CRF-0589*/

					vectorHtmlData.add(tagHtml);
					vectorHtmlData.add("</tr>");

					/*Added by Ashwini on 15-Mar-2018 for MMS-DM-CRF-0137*/
					UnitNoFld = UnitNoFld+","+strUnitNo+"^"+strRowId+rec_id; 
					ProductCodeFld = ProductCodeFld+","+strProductCode+"^"+strRowId+rec_id+"^"+strUnitNo;
					/*End MMS-DM-CRF-0137*/

					if (intFetchedRecords >= max_records)
					{
						break;
					}
					
				}
				vectorHtmlData.add("</table>");
				//ConnectionManager.returnConnection(conn, request);
	
			}
			catch(Exception expSQL)
			{
					//eBT.LogFile.log("QADebugger","Exception "+expSQL,this);
					System.out.println("EBT exception 1"+expSQL);
				
			}
			finally
			{
				try
				{
					rs.close();
					pstmt.close();
					cstmt.close();
					ConnectionManager.returnConnection(conn, request);
				}
				catch(Exception ee)
				{
					System.out.println("EBT exception2 "+ee);
				}
			}


			//eBT.LogFile.log("QADebugger","size"+vectorHtmlData.size(),this);			

			//debug("Final sql  = "+sql);
		%>


		<table align='center' width='100%'>
		<tr>
		<td align='right' colspan='5'>
		<%
		if ((start>1))
		{
			out.println("<A href=\"javascript:submitFormP()\" text-decoration='none'> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}

		//debug("intFetchedRecords="+intFetchedRecords);
		//debug("max_records="+max_records);

		if (intFetchedRecords>=max_records)
		{
			out.println("<A href=\"javascript:submitFormN()\" text-decoration='none'> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+" </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}


			//debug("vectorHtmlData.size()="+vectorHtmlData.size() );
			
		%>


		</td>
		</tr>
		</table>
		<%

			for (int l=0;l<vectorHtmlData.size();++l)
			{		
				out.println((String)vectorHtmlData.get(l));
			}

			if(vectorHtmlData.size()==10)
			{
			out.println("<script language='javascript'>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
			}

		%>	
		

		<input type='hidden' name='from' id='from' value="<%=start%>">
		<input type='hidden' name='to' id='to' value="<%=end%>">
		<input type='hidden' name='column_sizes' id='column_sizes' value="<%=column_sizes%>">
		<input type='hidden' name='column_descriptions' id='column_descriptions' value="<%=column_descriptions%>">
		<input type='hidden' name='sql' id='sql' value="<%=sql%>">
		<input type='hidden' name='max_records' id='max_records' value="<%=max_records%>">
		<input type='hidden' name='specimen_no' id='specimen_no' value="<%=strSpecimenNo%>">
		<input type='hidden' name='locale' id='locale' value="<%=locale%>">	    
		<input type='hidden' name='patient_id' id='patient_id' value="<%=strPatient_Id%>">	    
		<input type='hidden' name='order_facility_id' id='order_facility_id' value="<%=strOrderFacilityId%>">	 
		<!--Added by Ashwini on 15-Mar-2018 for MMS-DM-CRF-0137-->
		<input type='hidden' name='UnitNoFld' id='UnitNoFld' value="<%=UnitNoFld%>">
		<input type='hidden' name='ProductCodeFld' id='ProductCodeFld' value="<%=ProductCodeFld%>">
		<input type='hidden' name='isUnitNoProdCodeScanAppl' id='isUnitNoProdCodeScanAppl' value="<%=isUnitNoProdCodeScanAppl%>">
		<!--End MMS-DM-CRF-0137-->
		<input type='hidden' name='entry_type' id='entry_type' value=""><!-- Added for MMS-DM-CRF-0157 -->
		<input type='hidden' name='bar_code_scan_site_YN' id='bar_code_scan_site_YN' value="<%=bar_code_scan_site_YN%>"><!-- Added for MMS-DM-CRF-0157 -->
		<input type='hidden' name='scan_count_required_yn' id='scan_count_required_yn' value="<%=scan_count_required_yn%>"><!-- Added for MMS-DM-CRF-0170.2 -->
		<input type='hidden' name='alert_required_yn' id='alert_required_yn' value="<%=alert_required_yn%>"><!-- Added for MMS-DM-CRF-0170.2 -->
		<input type='hidden' name='remarks_required_yn' id='remarks_required_yn' value="<%=remarks_required_yn%>"><!-- Added for MMS-DM-CRF-0170.2 -->
		<input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>"><!-- Added for MMS-DM-CRF-0170.2 -->

		<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>"><!-- Added for MMS-DM-CRF-0170.2 -->

	

		<%
		}
		catch(Exception exp)
		{
			//System.out.println("EBT exception 3"+exp);
		}%>

</form>

</body>
</html>

