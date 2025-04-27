var CODE_LINK		= "1"   ; 
var DESC_LINK		= "2"   ;
var CODE_DESC_LINK  = "1,2" ;
var CODE_DESC       = "CODE_DESC" ;
var DESC_CODE       = "DESC_CODE" ;

function funBTTransactionSearch(obj)
{
	
	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";

	var title="Search";

	var column_sizes ;
	var column_descriptions ;
	var opt;
	//	var column_sizes = escape("10%,5%,10%,15%,10%,15%,*");
	//	var column_descriptions = escape("Common.status.label, ,eBT.UnitNo.label,eBT.Product.label,Common.bloodgroup.label,eBT.Rhesus.label,eBT.Sel.label");


	//	var column_sizes = escape("10%,5%,10%,15%,10%,10%,10%,*");
	//	var column_descriptions = escape("Common.status.label, ,eBT.UnitNo.label,eBT.Product.label,Common.bloodgroup.label,eBT.Rhesus.label,eBT.TransfuseExpectDate.label,eBT.Sel.label");
	try
	{
		//alert('here'+obj.RRSelection.value);

		
		
		
		

		/*	if (opt == 'RR')
	{
	column_sizes = escape("5%,5%,10%,10%,10%,10%,10%,10%,10%,10%,5%,5%");
	column_descriptions = escape("Common.status.label, ,eBT.UnitNo.label,eBT.SpecimenNo.label,eBT.ReservedDate.label,eBT.SpecregDate.label,eBT.Product.label,Common.bloodgroup.label,eBT.Rhesus.label,eBT.TransfuseExpectDate.label,eBT.RequestReprint.label,Common.Reprint.label");
	}
	else
	{
	column_sizes = escape("5%,5%,10%,10%,10%,10%,10%,10%,10%,10%,10%");
	column_descriptions = escape("Common.status.label, ,eBT.UnitNo.label,eBT.SpecimenNo.label,eBT.ReservedDate.label,eBT.SpecregDate.label,eBT.Product.label,Common.bloodgroup.label,eBT.Rhesus.label,eBT.TransfuseExpectDate.label,eBT.Sel.label");
	}
			*/
		//var column_descriptions = escape("Common.status.label, ,eBT.SpecimenNo.label,eBT.UnitNo.label,eBT.UnitNo.label,eBT.UnitNo.label,eBT.Product.label,Common.bloodgroup.label,eBT.Rhesus.label,eBT.TransfuseExpectDate.label,eBT.Sel.label");

		//var column_descriptions = escape("Common.status.label, ,eBT.UnitNo.label,eBT.Product.label,Common.bloodgroup.label,eBT.Rhesus.label,Common.bloodgroup.label,eBT.Sel.label");


		var sql="";
		var sql1="";
		var where ='';
		var where1 ='';
		var opt='';
		var desc='';
		

		opt=obj.RRSelection.value;
		if(opt==null||opt=='') return;
		
	}
	catch(e)
	{
		alert(e);
	}	
	if (opt == 'RR')
	{
		/* Below lines commented by Sanjay for ML-MMOH-CRF-0404 on 15-Oct-15 */
		//column_sizes = escape("5%,5%,10%,10%,10%,10%,10%,10%,10%,10%,5%,5%");
		//column_descriptions = escape("Common.status.label, ,eBT.UnitNo.label,eBT.SpecimenNo.label,eBT.ReservedDate.label,eBT.SpecregDate.label,eBT.Product.label,Common.bloodgroup.label,eBT.Rhesus.label,eBT.TransfuseExpectDate.label,eBT.RequestReprint.label,Common.Reprint.label");
				
		// Two lines added by Sanjay for ML-MMOH-CRF-0404 on 15-Oct-15
		column_sizes = escape("5%,5%,10%,10%,10%,10%,10%,10%,10%,5%,5%,5%,5%");
		column_descriptions = escape("Common.status.label, ,eBT.UnitNo.label,eBT.SpecimenNo.label,eBT.ReservedDate.label,eBT.SpecregDate.label,eBT.Product.label,Common.bloodgroup.label,eBT.XMatchStatus.label,eBT.Rhesus.label,eBT.TransfuseExpectDate.label,eBT.RequestReprint.label,Common.Reprint.label");
	}
	else
	{
		/* Below lines commented by Sanjay for ML-MMOH-CRF-0404 on 15-Oct-15 */
		//column_sizes = escape("5%,5%,10%,10%,10%,10%,10%,10%,10%,10%,10%");
		//column_descriptions = escape("Common.status.label, ,eBT.UnitNo.label,eBT.SpecimenNo.label,eBT.ReservedDate.label,eBT.SpecregDate.label,eBT.Product.label,Common.bloodgroup.label,eBT.Rhesus.label,eBT.TransfuseExpectDate.label,eBT.Sel.label");
		// Two lines added by Sanjay for ML-MMOH-CRF-0404 on 15-Oct-15
		column_sizes = escape("5%,5%,10%,10%,10%,10%,10%,5%,5%,5%,10%,10%");
		column_descriptions = escape("Common.status.label, ,eBT.UnitNo.label,eBT.SpecimenNo.label,eBT.ReservedDate.label,eBT.SpecregDate.label,eBT.Product.label,Common.bloodgroup.label,eBT.XMatchStatus.label,eBT.Rhesus.label,eBT.TransfuseExpectDate.label,eBT.Sel.label");
	}
	

	//parent.frames[3].location.href ='../../eBT/jsp/BTRRIndication.jsp';
	desc='../../eBT/jsp/BTRRIndFrame.jsp?pid='+obj.PATIENT_ID.value+'&fid='+obj.FACILITY_ID.value+'&opt='+opt;
	desc+='&column_descriptions='+column_descriptions;
	desc+='&column_sizes='+column_sizes;
	parent.frames[3].location.href =desc;


}


function funBTCheckDetail1(flag)
{
	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";




	var title;

	//Modified by Ravi Shankar, 23/10/2013, IN-44295
	//if(flag == 1)	title = "eBT.CheckedPractioner.label";
	//else    title = "Common.practitionerid.label";
	if(flag == 3)	title = "eBT.CheckedPractioner.label";
	else if(flag == 1)	title = "eBT.TransfuseByPractitioner.label";
	else if(flag == 4)	title = "eBT.TransferBy.label"; //Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
	else    title = "Common.practitionerid.label";


	var column_sizes = escape("30%,70%");               
	var column_descriptions = escape("eBT.Code.label,Common.description.label"); 
	var sql;
	var facility='';
	var obj=document.forms[0];

	// Modified by DhanasekarV on 10/8/2011 against issue  28274
	//facility=obj.FACILITY_ID.value;
	facility=obj.FID.value;


	// Modified for testing DhanasekarV IN024221 05/10/2010 -
	//sql=escape("select USER_ID USERID1,USERNAME USERNAME1 from SY_USER_LANG_VW where FACILITY_ID='"+facility+"' and language_id='"+obj.locale.value+"'");
	// Below Query modified by Sanjay on 29-Jan-14 for SCF-SS-SCF-0720
	sql=escape("select USER_ID USERID1,USERNAME USERNAME1 from SY_USER_LANG_VW where FACILITY_ID='"+facility+"' and language_id='"+obj.locale.value+"'"+" AND NVL(STATUS,'E') = 'E'");
	

	//	sql=escape("select USER_ID USERID1,USERNAME USERNAME1 from SY_USER_LANG_VW where FACILITY_ID='"+facility+"' and language_id='tt'");
	//end 

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=window.showModalDialog("../../eBT/jsp/EBTLookupMain.jsp?"+param,arguments,features);
	var arr=new Array();	
	if(retVal == null) retVal='';
	if (retVal != null || retVal!="")
	{
		var retVal=unescape(retVal);
		//alert('2 retVal' + retVal);
		if(retVal != null && retVal.length>0)
		{
			
			arr=retVal.split("::");
			//alert('flag:' + flag + ':arr[0]:' + arr[0] + ':arr[1]:' + arr[1]);
			//alert(retVal);
			if(flag=='3')
			{
				document.forms[0].Checked_Practioner.value = arr[1];
				document.forms[0].CHECK_PRACT_ID.value = arr[0];
				
			}
			else
			
			if(flag=='1')
			{
				//document.forms[0].Practioner_Name1.value = decodeURIComponent(arr[1],"UTF-8");
				//document.forms[0].TRANSFUSE_PRACT_ID.value = decodeURIComponent(arr[0],"UTF-8");
				//alert('BTTransaction.js Practioner_Name1:' + arr[1] + 'TRANSFUSE_PRACT_ID:' + arr[0]);
				document.forms[0].Practioner_Name1.value = arr[1];
				document.forms[0].TRANSFUSE_PRACT_ID.value = arr[0];

			}

			//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
			else if(flag=='4')
			{
				document.forms[0].transfer_by.value = arr[1];
				document.forms[0].transfer_by_id.value = arr[0];
			}

			else
			{
				document.forms[0].Practioner_Name2.value = arr[1];
				document.forms[0].TRANSFUSE_PRACT_ID_2.value = arr[0];
			}

		}
		else		
		{
			if(flag=='3')
			{
				document.forms[0].Checked_Practioner.value ='';
				document.forms[0].CHECK_PRACT_ID.value = '';
			}
			else

			if(flag=='1')
			{
				document.forms[0].Practioner_Name1.value = '';
				document.forms[0].TRANSFUSE_PRACT_ID.value = '';
			}

			//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
			else if(flag=='4')
			{
				document.forms[0].transfer_by.value = '';
				document.forms[0].transfer_by_id.value = '';
			}

			else
			{
				document.forms[0].Practioner_Name2.value = '';
				document.forms[0].TRANSFUSE_PRACT_ID_2.value = '';
			}
		}
	}
}


//Modified by DhanasekarV against SRR20056-5795  on date 22/10/2010

function funBTReasonDetail(){
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var flg="";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var obj=document.forms[0];
	//var frmObj=document.forms[0];
	//var sql="select short_desc DESCRIPTION,ANAESTHESIA_CODE CODE from AM_ANAESTHESIA where NVL(Eff_Status,'X')='E' AND upper(short_desc) like upper(?) AND upper(ANAESTHESIA_CODE) like upper(?) order by 2";
	//var sql="SELECT REASON_DESC DESCRIPTION, REASON_CODE CODE FROM OT_REASONS where NVL(STATUS,'E')='E' AND REASON_CODE IN (SELECT REASON_CODE REASON_CODE1 FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE IN ('TA')  AND 	NVL(ACTIVE_YN,'N') = 'Y') AND upper(REASON_DESC) like upper(?) AND upper(REASON_CODE) like upper(?) order by 2 " ;
	//var sql= "SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+obj.locale.value+"' AND PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE = 'OS') AND NVL(EFF_STATUS,'X') <> 'S' ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	var sql="SELECT DESCRIPTION, CODE FROM (SELECT SHORT_DESC DESCRIPTION,REASON_CODE  CODE FROM RL_REASON_CODE_LANG_VW WHERE REASON_TYPE='BT' AND NVL (STATUS,'X') <> 'S' AND LANGUAGE_ID='"+obj.locale.value+"') WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] ="";
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup(getLabel("Common.ReasonCode.label","common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		document.forms[0].TRANS_DESC.value = returnedValues[1];
		document.forms[0].TRANS_CODE.value = returnedValues[0];	
	}else{
		document.forms[0].TRANS_DESC.value = '';
		document.forms[0].TRANS_CODE.value = '';		}

}

/*function funBTReasonDetail()
{

	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;

	//var title="Complication Search";
	var title ="Common.search.label";

	var column_sizes = escape("30%,70%");               
	var column_descriptions = escape("Common.ReasonCode.label,Common.description.label"); 
	var sql ;	
	var obj=document.forms[0];
	
	sql=escape("SELECT REASON_CODE REASON_CODE1,SHORT_DESC SHORT_DESC1  FROM RL_REASON_CODE_LANG_VW WHERE REASON_TYPE='BT' AND NVL (STATUS,'X') <> 'S' AND LANGUAGE_ID='"+obj.locale.value+"'");



	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=window.showModalDialog("../../eBT/jsp/EBTLookupMain.jsp?"+param,arguments,features);
	var arr=new Array();

	if(retVal == null) retVal='';
	if (retVal != null || retVal!="")
	{
		var retVal=unescape(retVal);

		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("::");
			document.forms[0].TRANS_CODE.value = arr[0];
			document.forms[0].TRANS_DESC.value = arr[1];
		}
		else		
		{
			document.forms[0].TRANS_CODE.value = '';
			document.forms[0].TRANS_DESC.value = '';
			}
	}

	//Modified by DhanasekarV 

	alert(decodeURIComponent(document.forms[0].TRANS_DESC.value));

}
*/

function funBTReactionDetail()
{
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;

	//var title="Complication Search";
	var title="Common.search.label";

	var column_sizes = escape("20%,70%,10%");               
	var column_descriptions = escape("Common.ReactionCode.label,Common.description.label,Common.AdverseReaction.label"); 
	var sql ;
	var facility='';
	var obj=document.forms[0];
	facility=obj.FACILITY_ID.value;	

	//		sql=escape("select REACTION_CODE REACTION_CODE1,SHORT_DESC SHORT_DESC1 from BT_REACTION_CODE_MAST_LANG_VW where ADDED_FACILITY_ID='"+facility+"' and LANGUAGE_ID='"+obj.locale.value+"'");

	//	sql=escape("select REACTION_CODE REACTION_CODE1,SHORT_DESC SHORT_DESC1,NVL(ADVERSE_REACTION_YN,'N') ADVERSE_REACTION_YN1 from BT_REACTION_CODE_MAST_LANG_VW where ADDED_FACILITY_ID='"+facility+"' and LANGUAGE_ID='"+obj.locale.value+"'");

	sql=escape("select REACTION_CODE REACTION_CODE1,SHORT_DESC SHORT_DESC1,NVL(ADVERSE_REACTION_YN,'N') ADVERSE_REACTION_YN1 from BT_REACTION_CODE_MAST_LANG_VW where NVL(STATUS,'X')<> 'S' and LANGUAGE_ID='"+obj.locale.value+"'");

	//   alert(sql);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=window.showModalDialog("../../eBT/jsp/EBTLookupMain.jsp?"+param,arguments,features);
	var arr=new Array();

	if(retVal == null) retVal='';

	//alert(retVal);//Sanjay
	if (retVal != null || retVal!="")
	{
		var retVal=unescape(retVal);

		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("::");
			document.forms[0].REACTION_CODE.value = arr[0];
			document.forms[0].REACTION_DESC.value = arr[1];
			if(arr[2]=='N') 
			document.forms[0].adverse.checked=false;
			else
			{
				document.forms[0].adverse.checked=true;
				//BT0218,TRANS_INVESTIGATE
				alert(getBTMessage('BT0218','BT'));
				//alert("Please order transfusion reaction investigation");

			}

		}
		else		
		{
			document.forms[0].REACTION_CODE.value = '';
			document.forms[0].REACTION_DESC.value = '';
		}
	}


}


function funBTTransfusionHistory(obj)
{
	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";

	var title="Common.search.label";

	/*Added by Ashwini on 15-Mar-2018 for MMS-DM-CRF-0137*/
	var isUnitNoProdCodeScanAppl = document.forms[0].isUnitNoProdCodeScanAppl.value;

	if(isUnitNoProdCodeScanAppl == "true")
	{
		var prdctLabel = "eBT.ProdCodeDesc.label";
	}else
	{
		var prdctLabel = "eBT.Product.label";
	}
	/*End MMS-DM-CRF-0137*/

	//var column_sizes = escape("15%,10%,10%,10%,15%,10%,10%");               
	//var column_descriptions = escape("eBT.SpecimenNo.label,eBT.UnitNo.label,eBT.Product.label,Common.bloodgroup.label,eBT.Rhesus.label,Common.status.label,eBT.Sel.label"); 

	var column_sizes = escape("10%,10%,15%,10%,10%,10%,15%,10%,10%"); //Modified by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589           
	var column_descriptions = escape("eBT.SpecimenNo.label,eBT.UnitNo.label,"+prdctLabel+",Common.bloodgroup.label,eBT.Rhesus.label,Common.status.label,eBT.TransfuseExpectDate.label,eBT.Transfuse.label,eBT.ExternalTransfer.label"); //Modified by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589

	//var column_descriptions = escape("eBT.SpecimenNo.label,eBT.UnitNo.label,eBT.Product.label,Common.bloodgroup.label,eBT.Rhesus.label,Common.status.label,Common.bloodgroup.label,eBT.Sel.label"); 


	var sql='';
	var where ='';
	var opt='';
	var desc='';
	try
	{

		

		/*
sql="SELECT 'DAT'||ROWNUM ROW_ID1,A.patient_id PATIENT_ID1, A.specimen_no SPECIMEN_NO1,F.short_Desc PRODUCT_DESC1,NVL(B.CURRENT_VOLUME,0) CURRENT_VOLUME1,NVL(B.VOLUME_UNITS,'') VOLUME_UNITS1,A.OPERATING_FACILITY_ID OPERATING_FACILITY_ID1, to_char(";
sql+="SYSDATE";
sql+=",'dd/mm/yyyy hh24:mi:ss') SYDATE1,to_char(A.reserved_date,'dd/mm/yyyy hh24:mi') RESERVED_DATE1,to_char(A.issued_date,'dd/mm/yyyy hh24:mi') ISSUED_DATE1,A.unit_no UNIT_NO1, A.product_code PRODUCT_CODE1,NVL(TO_CHAR(E.TRANSFUSE_EXPECT_DATE_TIME,'dd/mm/yyyy hh24:mi:ss'),'') TRANS_EXP_DATE, B.blood_group BLOOD_GROUP1, B.rhesus_code RHESUS_CODE1,A.UNIT_STATUS UNIT_STATUS1, A.request_for_issue_by REQUEST_FOR_ISSUE_BY1,NVL(TO_CHAR(B.EXPIRY_DATE,'dd/mm/yyyy hh24:mi'),'') EXPIRYDATE FROM BT_UNIT_REQUEST_DTL A, BT_BLOOD_UNITS_MAST B, BT_OUTSTAND_SPECIMENS_VW C,BT_UOM_MAST_LANG_VW D,BT_UNIT_REQUEST_CATEGORY E,BT_PRODUCT_MAST_LANG_VW F WHERE";




	where +="  A.PATIENT_ID='";
	where +=obj.PATIENT_ID.value+"'";
	where +=" and D.LANGUAGE_ID='";
	where +=obj.locale.value+"'";
	where +=" and C.ORDERED_FACILITY_ID='";
	where +=obj.FACILITY_ID.value+"'";
	where+= "  AND A.unit_no = B.unit_no and E.specimen_no= A.specimen_no and e.specimen_no = a.specimen_no and e.product_code =a.product_code and e.patient_id = a.patient_id and E.operating_Facility_id = C.operating_facility_id and A.product_code = B.product_code AND F.product_code = A.product_code and F.language_id =d.language_id and NVL(A.unit_status, 'UO') IN ('UI') AND A.operating_facility_id = C.operating_facility_id AND C.specimen_no = A.specimen_no AND B.operating_facility_id = C.operating_facility_id AND C.patient_id = A.patient_id AND NVL(B.VOLUME_UNITS,'X')= D.UOM_CODE"
	where+="(%2B";
	where+=") ORDER BY A.issued_date";
		sql+=where; 	

*/

		sql = "patient_id="+obj.PATIENT_ID.value+"&order_facility_id="+obj.FACILITY_ID.value+"&encounter_id="+obj.encounter_id.value+"&patient_class="+obj.patient_class.value;

		
		

		
		//desc='../../eBT/jsp/BTTransfusionDetail.jsp?sql='+sql;
		desc='../../eBT/jsp/BTTransfusionDetail.jsp?'+sql;

		desc+='&column_descriptions='+column_descriptions;
		desc+='&column_sizes='+column_sizes;

		parent.frames[3].location.href =desc;
	}
	catch(e)
	{
		alert(e);
	}
}

function funBTXMLFormApply(frmObj) 
{	
	var formId = frmObj;
	var retVal ="";
	var idall = formId.all;
	var bar_code_scan_count_yn = formId.BAR_CODE_SCAN_SITE_YN.value;//Added for MMS-DM-CRF-0157
	var entry_type = formId.ENTRY_TYPE.value;//Added for MMS-DM-CRF-0157
	var scan_count_required_yn=formId.SCAN_COUNT_REQUIRED_YN.value;//Added for MMS-DM-CRF--0170.2
	var alert_required_yn=formId.ALERT_REQUIRED_YN.value;//Added for MMS-DM-CRF--0170.2
	var remarks_required_yn=formId.REMARKS_REQUIRED_YN.value;//Added for MMS-DM-CRF--0170.2
	var patient_class =formId.PATIENT_CLASS.value;//Added for MMS-DM-CRF--0170.2
    var encounter_id  =formId.ENCOUNTER_ID.value;//Added for MMS-DM-CRF--0170.2
    var patient_id =formId.PATIENT_ID.value;//Added for MMS-DM-CRF--0170.2

	if(scan_count_required_yn =="N"){//scan_count_required_yn added for MMS-DM-CRF-0170.2
		formId.REASON_CODE.value =".";
		formId.REASON_DESC.value =".";
		formId.ENTRY_TYPE.value =".";
	}

	if (bar_code_scan_count_yn =='Y' && scan_count_required_yn =='Y'){//scan_count_required_yn added foor MMS-DM-CRF-0170.2
             
	      if(entry_type=='M' && alert_required_yn =='Y'){
		     retVal =callManualScanRemarks(remarks_required_yn);//remarks_required_yn added for MMS-DM--CRF-0170.2
	      }
		  if(entry_type =='M' && alert_required_yn =='N'){//Added if condition for MMS-DM-CRF-0170.2
			  formId.REASON_CODE.value =".";
		      formId.REASON_DESC.value =".";

		  }
	}

	var xmlString = '';
	xmlString = '<root><' + formId.name;
	var endxmlString = '></'+formId.name+'>'; 
	var record_type = '';
	for (l=0;l<idall.length;l++)
	{
		record_type = checkAttributeNull(idall[l],'RECORD_TYPE');
		if (record_type == 'S')
		{

			xmlString = xmlString +' '+	addAttribute(idall[l])+' ';
		}
	}
	xmlString = xmlString+endxmlString+"</root>";

	//Adding start for MMS-DM-CRF-0157
	//Adding end  for MMS-DM-CRF-0157
 if(retVal != undefined)//Added for MMS-DM-CRF-0157
	return(xmlString);
}

//Code changes made for 73815 - Regression-BT-3T-Blood Unit Consumption-Transfer by Sethu on 31/08/2020
function funBTXMLFormApplyOut(frmObj) 
{	
	var formId = frmObj;
	var idall = formId.all;


	var xmlString = '';
	xmlString = '<root><' + formId.name;
	var endxmlString = '></'+formId.name+'>'; 
	var record_type = '';
	for (l=0;l<idall.length;l++)
	{
		record_type = checkAttributeNull(idall[l],'RECORD_TYPE');
		if (record_type == 'S')
		{

			xmlString = xmlString +' '+	addAttribute(idall[l])+' ';
		}
	}
	xmlString = xmlString+endxmlString+"</root>";
	return(xmlString);
}



function funBTStorageLocation()
{

	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";

	//var title="Complication Search";
	var title="Common.search.label";
	var column_sizes = escape("30%,70%");               
	var column_descriptions = escape("eBT.Code.label,Common.description.label"); 
	//	var column_descriptions = escape("Common.description.label,Common.description.label"); 
	var sql;

	var facility='';
	var product_code='';
	var blood_group='';
	var rhesus_code='';
	var source_type='';
	var source_code='';

	var obj=document.forms[0];

	facility=obj.FID.value;
	product_code=obj.PRODUCT_CODE.value;
	blood_group=obj.BLOOD_GROUP.value;
	rhesus_code=obj.RHESUS_CODE.value;
	source_type=obj.SOURCE_TYPE.value;
	source_code=obj.SOURCE_CODE.value;


	sql="Select A.Storage_Loc_Code,A.Short_Desc From BT_STORAGE_LOCATION_LANG_VW  A,Bt_Product_Location_Dtl B Where A.Storage_Loc_Code=B.storage_Loc_Code And B.Product_Code ='"+product_code+"' And B.Blood_Group='"+blood_group+"' And B.Rhesus_Code='"+rhesus_code+"' AND B.OPERATING_FACILITY_ID = '"+facility+"' AND B.SOURCE_TYPE='"+source_type+"' AND SOURCE_CODE='"+source_code+"' And B.Unit_Event_Type IN ('UT') and A.language_id='"+obj.locale.value+"' UNION  Select A.Storage_Loc_Code,A.Short_Desc From BT_STORAGE_LOCATION_LANG_VW  A,Bt_Product_Location_Dtl B Where A.Storage_Loc_Code=B.storage_Loc_Code And B.Product_Code = '"+product_code+"' And B.Blood_Group='*ALL' And B.Rhesus_Code='*ALL' AND B.OPERATING_FACILITY_ID = '"+facility+"' AND B.SOURCE_TYPE='"+source_type+"' AND SOURCE_CODE='"+source_code+"' And B.Unit_Event_Type IN ('UT') and A.language_id='"+obj.locale.value+"'";




	//sql =" Select A.Storage_Loc_Code,A.Short_Desc,B.source_type,source_code From BT_STORAGE_LOCATION_LANG_VW  A,Bt_Product_Location_Dtl B Where A.Storage_Loc_Code=B.storage_Loc_Code And B.Product_Code ='01' And B.Blood_Group='A' And B.Rhesus_Code='DPOS'AND B.OPERATING_FACILITY_ID = 'HS' AND B.SOURCE_TYPE='B' AND SOURCE_CODE='BTS' And B.Unit_Event_Type IN ('UO')" ;
	//alert (sql);
	sql=escape(sql);


	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	//alert(param);
	retVal=window.showModalDialog("../../eBT/jsp/EBTLookupMain.jsp?"+param,arguments,features);
	//    retVal =window.showModalDialog("../../eBT/jsp/CommonLookup.jsp?"+param,arguments,features);
	var arr=new Array();

	if(retVal == null) retVal='';
	if ( retVal!='')
	{
		var retVal=unescape(retVal);
		arr=retVal.split("::");
		obj.LOCATION_CODE.value=arr[0];
	}
	else
	obj.LOCATION_CODE.value='';

	validateStorage();

}


function callStorageLocation()
{

	var obj=document.forms[0];


	var strValue="LOCATION_CODE="+obj.LOCATION_CODE.value+"&";
	strValue+="SPECIMEN_NO="+obj.SPECIMEN_NO.value+"&";
	strValue+="PRODUCT_CODE="+obj.PRODUCT_CODE.value+"&";
	strValue+="RHESUS_CODE="+obj.RHESUS_CODE.value+"&";
	strValue+="BLOOD_GROUP="+obj.BLOOD_GROUP.value+"&";
	strValue+="SOURCE_TYPE="+obj.SOURCE_TYPE.value+"&";
	strValue+="SOURCE_CODE="+obj.SOURCE_CODE.value+"&";
	strValue+="FLAG=1";

	//alert(strValue);


	var xmlForm="<root></root>";
	
	//alert(xmlForm);

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlDoc.loadXML(xmlForm);	

	xmlHttp.open("POST", "../../servlet/eBT.BTStorageLocation?"+strValue,false);

	xmlHttp.send(xmlDoc);

	var resTxt=xmlHttp.responseText;
	if(resTxt=='null' || resTxt == '0') resTxt='';
	obj.LOCATION_CODE.value=resTxt;
	if(obj.LOCATION_CODE.value=='null')
	obj.LOCATION_CODE.value='';
}

function validateStorage()
{
	var obj=document.forms[0];
	var strValue="LOCATION_CODE="+obj.LOCATION_CODE.value+"&";
	strValue+="SPECIMEN_NO="+obj.SPECIMEN_NO.value+"&";
	strValue+="PRODUCT_CODE="+obj.PRODUCT_CODE.value+"&";
	strValue+="RHESUS_CODE="+obj.RHESUS_CODE.value+"&";
	strValue+="BLOOD_GROUP="+obj.BLOOD_GROUP.value+"&";
	strValue+="SOURCE_TYPE="+obj.SOURCE_TYPE.value+"&";
	strValue+="SOURCE_CODE="+obj.SOURCE_CODE.value+"&";
	strValue+="FLAG=0";

	//	alert(strValue);
	if(obj.LOCATION_CODE.value=='') return;
	var xmlForm="<root></root>";
	
	//alert(xmlForm);

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlDoc.loadXML(xmlForm);	

	xmlHttp.open("POST", "../../servlet/eBT.BTStorageLocation?"+strValue, false);

	xmlHttp.send(xmlDoc);

	var resTxt=xmlHttp.responseText;
	

	if(resTxt!=null)

	if(resTxt==null||resTxt.charAt(0)=='N'|| resTxt.charAt(0)=='n'||resTxt.charAt(0)=='0' )	
	{
		if(resTxt!=null)
		{
			var err=new Array();err=resTxt.split("||");
			alert(err[1]);
			obj.LOCATION_CODE.value='';
		}
	}
}


async function callAntiBody()
{

	var patient_id      = document.formTab.patient_id.value;
	var encounter_id	= document.formTab.encounter_id.value;
	var finalString		= "patient_id="+patient_id+"&encounter_id="+encounter_id
	var retVal 			= new String();
	var dialogHeight 	= "25" ;
	var dialogWidth  	= "40" ;
	var dialogTop    	= "170";
	var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal				= await window.showModalDialog("../../eBT/jsp/BTAntiBodyFrameSet.jsp?"+finalString,arguments,features);


	//  alert('here');
	//var finalString		= "patient_id="+patient_id+"&encounter_id="+encounter_id;
	/*
	var dialogHeight 		= "21" ;
	var dialogWidth  		= "50" ;
	var dialogTop   		= "300";
	var dialogLeft   		= "150";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	retVal	= window.showModalDialog("	../../eBT/jsp/BTTransfusionDlg.jsp",arguments,features);
*/

} 

async function callRequirments()
{
	
	var patient_id      = document.formTab.patient_id.value;
	var encounter_id	= document.formTab.encounter_id.value;
	var finalString		= "patient_id="+patient_id+"&encounter_id="+encounter_id
	var retVal 			= new String();
	var dialogHeight 	= "25" ;
	var dialogWidth  	= "40" ;
	var dialogTop    	= "170";
	var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal				= await window.showModalDialog("../../eBT/jsp/BTRequirementFrameSet.jsp?"+finalString,arguments,features);
} 

async function callDetails()
{
	
	var patient_id      = document.formTab.patient_id.value;
	var encounter_id	= document.formTab.encounter_id.value;
	var finalString		= "patient_id="+patient_id+"&encounter_id="+encounter_id
	var retVal 			= new String();
	var dialogHeight 	= "18" ;
	var dialogWidth  	= "60" ;
	var dialogTop    	= "170";
	var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	//alert("here");	alert(document.parent.frames[2].form_query.name);		alert(parent.frames[1].document.specimen_no);
	retVal				= await window.showModalDialog("../../eBT/jsp/BTPatientDtl.jsp?"+finalString,arguments,features);
} 

/*Added by Ashwini on 15-Mar-2018 for MMS-DM-CRF-0137*/
function unitNoBarCodeChk(evnt, obj){
	var entry_type ="";
	if(evnt.keyCode == 13 || evnt.keyCode == 17){

	 if(evnt.keyCode == 17)
		 document.forms[0].entry_type.value ="S";
	 else
		 document.forms[0].entry_type.value ="M";

		compareUnitNo(obj);
	}
	else
		return false;
}

function compareUnitNo(obj)
{
	var UnitNoFldValue = document.forms[0].UnitNoFld.value;
	var UnitNoInput	   = document.forms[0].UnitNo.value;
	var UnitValSep	   = UnitNoFldValue.split(',');
	var UnitValLength  = UnitValSep.length;
	var UnitValCount   = 0;
	var UnitName	   = "";
	var count		   = 0;

	document.forms[0].UnitNo.value = obj;

	if(!UnitNoInput == "")
	{
		for(var i=1;i<UnitValLength;i++)
		{
			var UnitValNameSep = UnitValSep[i].split('^');
			
			if (UnitNoInput == UnitValNameSep[0])
			{
				UnitValCount++;
				UnitName = UnitName+","+UnitValNameSep[1];
			}
		}
		var UnitNameArr	 = UnitName.split(',');
		
		if(parseInt(UnitValCount) == 0)
		{
			document.forms[0].ProductCode.disabled = true;
			document.forms[0].ProductImg.style.visibility = 'hidden';
			alert(getMessage("UNIT_NO_NOT_VALID",'BT'));
			document.forms[0].UnitNo.value = "";
			document.forms[0].UnitNo.focus();
		}
		else if(parseInt(UnitValCount) == 1)
		{
			if(eval("document.forms[0]."+UnitNameArr[1]+".disabled == false"))
			{
			document.forms[0].ProductCode.disabled = true;
			document.forms[0].ProductImg.style.visibility = 'hidden';
			eval("document.forms[0]."+UnitNameArr[1]+".checked = true; document.forms[0]."+UnitNameArr[1]+".onclick();");
			}
			else
			{
			document.forms[0].ProductCode.disabled = true;
			document.forms[0].ProductImg.style.visibility = 'hidden';
			alert(getMessage("BLOOD_UNIT_TRANSFUSED",'BT'));
			document.forms[0].UnitNo.value = "";
			document.forms[0].UnitNo.focus();
			}
		}
		else if(parseInt(UnitValCount) > 1)
		{
			for(var i=1;i<=UnitValCount;i++)
			{
				if(eval("document.forms[0]."+UnitNameArr[i]+".disabled == true"))
				{
					count++;
				}
			}
			if(count == UnitValCount)
			{
				document.forms[0].ProductCode.disabled = true;
				document.forms[0].ProductImg.style.visibility = 'hidden';
				alert(getMessage("BLOOD_UNIT_TRANSFUSED",'BT'));
				document.forms[0].UnitNo.value = "";
				document.forms[0].UnitNo.focus();
			}
			else
			{
				document.forms[0].ProductCode.disabled = false;
				document.forms[0].ProductCode.focus();
				document.forms[0].ProductImg.style.visibility = 'visible';
			}
		}
	}
	else
	{
		document.forms[0].ProductCode.disabled = true;
		document.forms[0].ProductCode.value = "";
		document.forms[0].ProductImg.style.visibility = 'hidden';
	}
}

function disableProductCode()
{
	if(document.forms[0].UnitNo.value == "")
	{
		document.forms[0].ProductCode.disabled = true;
		document.forms[0].ProductCode.value = "";
		document.forms[0].ProductImg.style.visibility = 'hidden';
	}
}

function prodCodeBarCodeChk(evnt, obj){
	if(evnt.keyCode == 13)
		compareProductCode(obj);
	else
		return false;
}

function compareProductCode(obj)
{
	var ProductCodeFldValue = document.forms[0].ProductCodeFld.value;
	var ProductCodeInput	= document.forms[0].ProductCode.value;
	var UnitNoInput			= document.forms[0].UnitNo.value;
	var ProductValSep		= ProductCodeFldValue.split(',');
	var ProductValLength	= ProductValSep.length;
	var ProductValCount		= 0;
	var ProductName			= "";
	
	document.forms[0].ProductCode.value = obj;

	if(!ProductCodeInput == "")
	{
		for(var i=1;i<ProductValLength;i++)
		{
			var ProductValNameSep = ProductValSep[i].split('^');

			if ((UnitNoInput == ProductValNameSep[2]) && (ProductCodeInput == ProductValNameSep[0]))
			{
				ProductValCount++;
				ProductName = ProductValNameSep[1];
			}
		}

		if(parseInt(ProductValCount) == 0)
		{
			alert(getMessage("PRODUCT_CODE_NOT_VALID",'BT'));
			document.forms[0].ProductCode.value = "";
			document.forms[0].ProductCode.focus();
		}
		else if(parseInt(ProductValCount) == 1)
		{
			if(eval("document.forms[0]."+ProductName+".disabled == false"))
			{
			eval("document.forms[0]."+ProductName+".checked = true; document.forms[0]."+ProductName+".onclick();");
			}
			else
			{
			alert(getMessage("BLOOD_UNIT_TRANSFUSED",'BT'));
			document.forms[0].ProductCode.value = "";
			document.forms[0].ProductCode.focus();
			}
		}
	}
}

function CheckForSpecCharsInUnitProdCode(event)
{ 
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ._-';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	//alert(whichCode+" : "+key+" : "+strCheck.indexOf(key));
	if (event.keyCode == 189) return true; // Code added by Sethu for MMS-DM-SCF-0747/MMS-RY-SCF-0106
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
/*End MMS-DM-CRF-0137*/

/*Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589*/
function transToExternal(obj)
{
	var dialogHeight 		= "20" ;
	var dialogWidth  		= "55" ;
	var dialogTop   		= "200";
	var dialogLeft   		= "150";
	var arguments			= "" ;
	
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;

	if(verifyUnitCheck(obj)==false) 
	 {
		return false;	 
	 }
	
	var strValue="PATIENT_ID="+obj.PATIENT_ID+"&";
	strValue+="OPERATING_FACILITY_ID="+obj.OPERATING_FACILITY_ID+"&";
	strValue+="SPECIMEN_NO="+obj.SPECIMEN_NO+"&";
 	strValue+="PRODUCT_CODE="+obj.PRODUCT_CODE+"&";
  	strValue+="ROW_ID="+obj.ROW_ID+"&";
	strValue+="CURRENT_VOLUME="+obj.CURRENT_VOLUME+"&";
	strValue+="STORAGE_LOC_CODE="+obj.STORAGE_LOC_CODE+"&";
	strValue+="VOLUME_UNITS="+obj.VOLUME_UNITS+"&";
	strValue+="ISSUED_DATE="+obj.ISSUED_DATE+"&";
	strValue+="RESERVED_DATE="+obj.RESERVED_DATE+"&";
	strValue+="SYDATE="+obj.SYDATE+"&";	
	strValue+="UNIT_NO="+obj.UNIT_NO+"&";
	
	retVal=window.showModalDialog("../../eBT/jsp/BTTransferOutDlg.jsp?"+strValue,arguments,features);

	if(retVal!=null && retVal.charAt(0)=='1')	
	 {	    
		var objtransToExt = "document.forms[0]."+obj.ROW_ID;
		var objtransToExtEval = eval(objtransToExt);
		objtransToExtEval.value = 'TF';
		alert(getMessage("UNIT_TRANSFERRED",'BT'));
		funBTTransfusionHistory(parent.frames[1].document.forms[0]);
	 }
	 else 
	 {
		if(retVal!=null)
		{
			alert(getBTMessage(retVal,'BT'));
			funBTTransfusionHistory(parent.frames[1].document.forms[0]);
		}
	 }
}

function validateNull()
{
	var obj=document.forms[0];

	if(obj.transfer_to.value==null||obj.transfer_to.value=='')
	{
		alert(getBTMessage("BT0602","BT"));
		return false;
	}

	if(obj.transfer_by_id.value==null||obj.transfer_by_id.value=='')
	{
		alert(getBTMessage("BT0597","BT"));
		return false;
	}

	if(obj.transfer_date_time.value==null||obj.transfer_date_time.value=='')
	{
		alert(getBTMessage("BT0593","BT"));
		return false;
	}

	if(obj.transfer_reason.value==null||obj.transfer_reason.value=='')
	{
		alert(getBTMessage("BT0598","BT"));
		return false;
	}

	var strUser = obj.transfer_by_id.value;
	obj.transfer_by.value = strUser.toUpperCase();

	var transferTo = obj.transfer_to.value;
	obj.transfer_to_code.value = transferTo.toUpperCase();

	var transferReason = obj.transfer_reason.value;
	obj.transfer_reason_code.value = transferReason.toUpperCase();

	return true;
}

function checkTransDateTime(objSt,objIS,objRE,objSYS,objEX)
{
	var locale = document.forms[0].locale.value;

	//alert("Transfer Date : "+objSt.value+" Issued Date : "+objIS.value+" Reserved Date : "+objRE.value+" Sysem Date : "+objSYS.value+" Expiry Date : "+objEX.value);

	if(objSt==null||objSt.value=='') 
	{			
		return;
	}

	var obj1 = changeTransDate(objSt.value);
	var obj2 = changeTransDate(objIS.value);
	var obj3 = changeTransDate(objRE.value);
	var obj4 = changeTransDate(objSYS.value);
	var obj6 = changeTransDate(objEX.value);

	if(obj1 < obj2 )
	{ 	
		alert(getBTMessage("BT0594","BT"));
		objSt.value = '';
		return;
	}

	if(obj1 > obj3)       
	{ 
		alert(getBTMessage("BT0595","BT"));
		objSt.value = '';
		return;
	}
	
	if(obj1 > obj6)       
	{ 
		alert(getBTMessage("BT0596","BT"));
		objSt.value = '';
		return;
	}
}

function changeTransDate(objTrsDt)
{
	var objStr = new Array();
	objStr = objTrsDt.split("/");
	var datVal = '';
	
	if(objStr != null && objStr.length>0)
	{
		datVal+=objStr[1]+"/";
		datVal+=objStr[0]+"/";
		datVal+=objStr[2];
	}
	else
	{
		datVal = objTrsDt;
	}

	var dat = new Date(datVal);
	
	return dat;
}

function imposeMaxLength(obj)
{
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	if (obj.getAttribute && obj.value.length>mlength)
	{
		var error = getMessage("REMARKS_CANNOT_EXCEED","common");
		var remarks = getLabel("Common.Transfer.label","common")+" "+getLabel("Common.remarks.label","common");
		error = error.replace("$",remarks);
		error = error.replace("#","2000")
		alert(error);
		obj.value=obj.value.substring(0,mlength);
	}
}
/*End ML-MMOH-CRF-0589*/
//Adding start for MMS-DM-CRF-01571.
function callManualScanRemarks(remarks_required_yn){//remarks_required_yn Added for MMS-DM--CRF-0170.2
	//alert("option_lisvar bean_id      =  formObj.bean_id.value;
	var module_id    = "BT";
	var retVal = new String();
	var dialogHeight= "17" ;                                                 
	
	var dialogWidth              = "40" ;

	var status = "no";                                         
	var features       = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=auto; status:" + status; 
	retVal =window.showModalDialog("../../eOR/jsp/BarCodeManualEntryReason.jsp?module_id="+module_id+"&remarks_mandetory_yn="+remarks_required_yn,arguments,features);
	if(retVal!=undefined){
			var  retValArr					= retVal.split("||");
			formId.REASON_CODE.value			    = retValArr[0];
			formId.REASON_DESC.value             = retValArr[1];
			return true;
	}else
			return retval;

}

//Adding end for MMS-DM-CRF-157.1
