<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% 
	String sStyle				= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	String queryString			= request.getQueryString() ;
	String locale				= (String)session.getAttribute("LOCALE");
	String facility_id			= (String)session.getValue("facility_id");
	String specilaty_code		= checkForNull(request.getParameter("specilaty_code"));
	String nursing_unit_code	= checkForNull(request.getParameter("nursing_unit_code"));
	String nursing_unit_desc	= checkForNull(request.getParameter("nursing_unit_desc"));
	String start_ends_contains	= checkForNull(request.getParameter("start_ends_contains"));
	String applicable_to		= checkForNull(request.getParameter("applicable_to"));
	String statics_yn			= checkForNull(request.getParameter("statics_yn"));
	String bkg_type				= checkForNull(request.getParameter("bkg_type"));
	String call_function		= checkForNull(request.getParameter("call_function"));
	String open_location_yn		= checkForNull(request.getParameter("open_location_yn"));
	String room_no				= checkForNull(request.getParameter("room_no"));
	String med_serv_grp_code	= checkForNull(request.getParameter("med_ser_grp"));
	String practitioner_id		= checkForNull(request.getParameter("pract_id"));
	
	
	if( call_function.equals("IPList") || call_function.equals("PatMovList") || call_function.equals("AdminHist") || call_function.equals("QueryDischarge")||call_function.equals("ChangedAdmDtls") )
		open_location_yn		= "Y";

	String clinic_code			= checkForNull(request.getParameter("clinic_code"));

	if(start_ends_contains.equals(""))
		start_ends_contains = "S";
	String whereClause			= checkForNull(request.getParameter("whereclause"));
	String user_sql				= checkForNull(request.getParameter("sql"));
	String radioval				= checkForNull(request.getParameter("radioval"));
	if(radioval.equals("code"))
		radioval = "1";
	else
		radioval = "2";

	String code					= "";
	String desc					= "";
	String pat_class			= "";
	String pat_class_desc		= "";
	String login_user			= checkForNull(request.getParameter("login_user"));
	String oper_stn_id			= checkForNull(request.getParameter("oper_id"));
	String patient_class		= checkForNull(request.getParameter("patientclass"));
	String linkColor			= "";
	if(patient_class.equals("")) 
		patient_class			=	applicable_to;
	if(bkg_type.equals("D"))
		patient_class			= "DC";
	else if(bkg_type.equals("I"))
		patient_class			= "IP";


	Connection conn				= null;
	PreparedStatement pstmt		= null;
	PreparedStatement pstmt_block		= null;	
	ResultSet rs				= null;
	ResultSet rs1				= null;
	String searchtext			= "";
	String dispDescFirst		= checkForNull(request.getParameter("dispDescFirst"));
	int i						= 1;
	
	//Added by Kamatchi S for MOHE-SCF-0134
	if(user_sql.equals("SQL_GENNUR"))
	{
			user_sql = (String)session.getAttribute("SQL_GENNUR");
	}
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function hideToolTip(){
	document.getElementById("tooltiplayer").style.visibility='hidden';
}


function close_window(Dcode,position,patient_class,desccc){

	//var Name = eval("document.forms[0].desc"+position).value;
/*
	//this loop is to remove the %20 addition in description fields
	while(Name.indexOf("+")!=-1)
	{
		Name=Name.replace('+'," ");
	}
*/
	//window.parent.parent.returnValue=Dcode+"~"+Name+"~"+patient_class;
	returnValue=Dcode+"~"+desccc+"~"+patient_class;
	//window.parent.parent.returnValue="Test";
	//close();
let dialogBody = parent.parent.document.getElementById('dialog-body');

    dialogBody.contentWindow.returnValue = returnValue;

    const dialogTag = parent.parent.document.getElementById("dialog_tag");    

    dialogTag.close();   
}

function openToolTip(nursingUnitCode)
{

	var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='bed_class_form' id='bed_class_form' method='post' action='../../eIP/jsp/PopulateNursingUnitBedDetails.jsp'><input type='hidden' name='nursingunit' id='nursingunit' value='"+nursingUnitCode+"'><input type='hidden' name='x_coordinate' id='x_coordinate' value='"+event.clientX+"'><input type='hidden' name='y_coordinate' id='y_coordinate' value='"+event.clientY+"'></form></body></html>";
	parent.frames[2].document.write(HTMLVal);
	parent.frames[2].document.bed_class_form.submit();
/*


	var retVal = 	new String();
	var dialogHeight= "41";
	var dialogWidth = "65";
	var dialogTop	= "72";

	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = window.showModalDialog("../../eIP/jsp/PopulateNursingUnitBedDetails.jsp?nursingunit="+escape(nursingUnitCode),arguments,features);
*/

}

function closeesc(Dcode,Name,patient_class)
{
	window.parent.parent.returnValue=Dcode+"~"+Name+"~"+patient_class;
	window.parent.parent.close();
}
/*Friday, June 04, 2010 , function added for SRR20056-SCF-4564-IN021691*/
function submitPrevNext(from,to)
{
	
	document.location.href="../../eIP/jsp/GeneralNursingUnitSearchResult.jsp?from="+from+"&to="+to+"&queryString="+'<%=queryString%>';
}

</script>
</head>

<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name='NUform' id='NUform'>
<%
	try
	{
		conn				= ConnectionManager.getConnection(request);
		StringBuffer sql	= new StringBuffer();
		String from			= checkForNull(request.getParameter( "from" ));
		String to			= checkForNull(request.getParameter( "to" ));
		searchtext			= checkForNull(request.getParameter("searchtext"));
		
		if(user_sql.equals(""))
		{
			if(open_location_yn.equals("Y"))
			{
			
				sql.append("SELECT  COUNT(*) OVER () rowCount, a.nursing_unit_code, a.short_desc, a.patient_class APPL_PATIENT_CLASS,");
				sql.append(" patient_class, (SELECT COUNT (*) FROM ip_nursing_unit_bed ");
				sql.append("WHERE nursing_unit_code = a.nursing_unit_code AND facility_id = "); 
				sql.append("a.facility_id AND eff_status = 'E' AND pseudo_bed_yn = 'N') total_beds,");
				sql.append("(SELECT COUNT (*) FROM ip_nursing_unit_bed WHERE nursing_unit_code = "); 
				sql.append("a.nursing_unit_code AND facility_id = a.facility_id AND eff_status = 'E' ");
				sql.append("AND pseudo_bed_yn = 'N' AND current_status = 'A') available,(SELECT "); 
				sql.append("COUNT(*) FROM ip_nursing_unit_bed WHERE nursing_unit_code = "); 
				sql.append("a.nursing_unit_code AND facility_id = a.facility_id AND eff_status = 'E' ");
				sql.append("AND pseudo_bed_yn = 'N' AND current_status = 'O') occupied ");
				/*Monday, April 19, 2010 , added for Nurisng Unit Lookup fine tuning....*/
				sql.append(",nvl((SELECT SUM(CASE WHEN BOOKING_TYPE IN('B','N','L','T','D') THEN 1 ELSE 0 END) Blocked FROM IP_BED_BOOKING WHERE facility_id = a.facility_id AND req_nursing_unit_code = a.nursing_unit_code AND booking_status IN('0','1') AND ( SYSDATE BETWEEN blocked_from_date_time AND blocked_until_date_time OR blocked_until_date_time IS NULL )),0) blocked ");
				/**/
				sql.append("FROM IP_NURSING_UNIT_LANG_VW a WHERE language_id = '"+locale+"' and a.facility_id = '"+facility_id+"' AND  ");
				sql.append("a.eff_status = 'E' ");
			}
			else
			{
			
				
				sql.append( "select  COUNT(*) OVER () rowCount,a.nursing_unit_code,a.short_desc,a.patient_class appl_patient_class, patient_class,(select count(*) from ip_nursing_unit_bed where  nursing_unit_code = a.nursing_unit_code ");
				sql.append(" and facility_id = a.facility_id and eff_status = 'E' and pseudo_bed_yn = 'N' ) total_beds,(select count(*) from ip_nursing_unit_bed where nursing_unit_code = a.nursing_unit_code and facility_id = a.facility_id and eff_status = 'E' and pseudo_bed_yn = 'N' and current_status = 'A')available, ");
				sql.append(" (select count(*) from ip_nursing_unit_bed where nursing_unit_code = a.nursing_unit_code and facility_id = a.facility_id and eff_status = 'E' and pseudo_bed_yn = 'N'   and current_status = 'O' )occupied ");
				/*Monday, April 19, 2010 , added for Nurisng Unit Lookup fine tuning....*/
				sql.append(",nvl((SELECT SUM(CASE WHEN BOOKING_TYPE IN('B','N','L','T','D') THEN 1 ELSE 0 END) Blocked FROM IP_BED_BOOKING WHERE facility_id = a.facility_id AND req_nursing_unit_code = a.nursing_unit_code AND booking_status IN('0','1') AND (SYSDATE BETWEEN blocked_from_date_time AND blocked_until_date_time OR blocked_until_date_time IS NULL )),0)blocked ");
				/**/
				sql.append(" from IP_NURSING_UNIT_LANG_VW a,AM_OS_USER_LOCN_ACCESS_VW c ");

				if(call_function.equals("Admit_patient") || (call_function.equals("MODIFY_SERVICE_FOR_INPATIENT")&&!specilaty_code.equals("")) )
					sql.append(",IP_NURS_UNIT_FOR_SPECIALTY e");

				if(call_function.equals("IP_Booking") || call_function.equals("CA_Task_IP_Booking") || call_function.equals("Revise_Booking") || call_function.equals("IP_ConfirmBooking") || call_function.equals("OT"))/*Tuesday, January 05, 2010 call_function.equals("OT") added for IN017821 */
					sql.append(",IP_MED_SER_GRP_NURS_UT_TYPE e,IP_NURS_UNIT_FOR_SPECIALTY f ");

				if((call_function.equals("IP_Booking")  || call_function.equals("CA_Task_IP_Booking") || call_function.equals("Revise_Booking") || call_function.equals("IP_ConfirmBooking") || call_function.equals("OT"))&& !practitioner_id.equals(""))
					/*Tuesday, January 05, 2010 call_function.equals("OT") added for IN017821 */
					sql.append(" ,IP_NURSING_UNIT_FOR_PRACT g ");
			
				if(bkg_type.equals("D") && !room_no.equals(""))
					sql.append(",IP_NURSING_UNIT_ROOM d ");
				
				sql.append(" where c.locn_type = 'N' and c.locn_code = a.nursing_unit_code and language_id = '"+locale+"' and a.facility_id ='"+facility_id+"' and a.eff_status = 'E' and ");

				if(bkg_type.equals("D") && !room_no.equals(""))
				{
					sql.append(" a.facility_id = d.facility_id and d.room_no = '"+room_no+"' and a.nursing_unit_code = d.nursing_unit_code and ");
				}
		
				//added by kishore on 8/13/2004
				//	if(bkg_type.equals("D"))
				/*Modified by Dharma on July 25 2014*/
				if(bkg_type.equals("D") && !clinic_code.equals(""))
				{
					sql.append(" a.nursing_unit_code in ( select a.nursing_unit_code code from ip_dc_unit_for_nurs_unit_vw a, am_os_user_locn_access_vw b where a.facility_id = '"+facility_id+"' and a.facility_id = b.facility_id and a.nursing_unit_code = b.locn_code and b.locn_type = 'N' and b.oper_stn_id = '"+oper_stn_id+"' and b.appl_user_id ='"+login_user+"' and a.clinic_code ='"+clinic_code+"') and ");
				}
				
				//sql.append(" c.facility_id  = a.facility_id  and c.locn_type = 'N' and c.locn_code  = a.nursing_unit_code and  c.appl_user_id = '"+login_user+"' ");
				sql.append("  c.facility_id  = a.facility_id   and  c.appl_user_id = '"+login_user+"' ");
				sql.append(" and c.oper_stn_id = '"+oper_stn_id+"'");

				//Condition for Admit Patient
				if(call_function.equals("Admit"))
				{
					sql.append(" and (c.ADMIT_PAT_YN = 'Y' or c.ADMIT_PATIENT_WITH_BED_YN = 'Y') ");
				}

				if(call_function.equals("Admit_patient"))
				{
					sql.append(" and e.SPECIALTY_CODE = '"+specilaty_code+"' AND e.NURSING_UNIT_CODE = a.NURSING_UNIT_CODE AND e.facility_id = a.facility_id ");
				}
			
			//Condition Added  For Change Patient Details  @ 3/16/2009
				if(call_function.equals("MODIFY_SERVICE_FOR_INPATIENT")&&!specilaty_code.equals("")){
					sql.append(" and e.SPECIALTY_CODE = '"+specilaty_code+"' AND e.NURSING_UNIT_CODE = a.NURSING_UNIT_CODE AND e.facility_id = a.facility_id ");
				}
				if(call_function.equals("IP_Booking") || call_function.equals("CA_Task_IP_Booking") || call_function.equals("Revise_Booking") || call_function.equals("IP_ConfirmBooking") || call_function.equals("OT"))
					/*Tuesday, January 05, 2010 call_function.equals("OT") added for IN017821 */
				{
					sql.append(" and e.FACILITY_ID = a.FACILITY_ID and e.MED_SER_GRP_CODE ='"+med_serv_grp_code+"' and e.NURSING_UNIT_TYPE_CODE = a.NURSING_UNIT_TYPE_CODE and f.FACILITY_ID = a.FACILITY_ID AND f.NURSING_UNIT_CODE = a.NURSING_UNIT_CODE AND f.SPECIALTY_CODE = '"+specilaty_code+"' ");
				}
				if((call_function.equals("IP_Booking")|| call_function.equals("CA_Task_IP_Booking")  || call_function.equals("Revise_Booking") || call_function.equals("IP_ConfirmBooking") || call_function.equals("OT"))&& !practitioner_id.equals("") )
				/*Tuesday, January 05, 2010 call_function.equals("OT") added for IN017821 */
				{
					sql.append(" and g.FACILITY_ID = a.FACILITY_ID AND g.NURSING_UNIT_CODE = a.NURSING_UNIT_CODE AND g.PRACTITIONER_ID = '"+practitioner_id+"'  ");
				}

				if(call_function.equals("IP_ConfirmBooking"))
					sql.append(" and (c.CONFIRM_BOOKING_YN = 'Y' OR c.CREATE_BOOKING_WITH_CONF_YN = 'Y') ");

				if(call_function.equals("Revise_Booking") || call_function.equals("IP_Booking") || call_function.equals("CA_Task_IP_Booking") || call_function.equals("OT"))
					sql.append(" and (c.CREATE_BOOKING_YN = 'Y' OR c.CREATE_BOOKING_WITH_CONF_YN = 'Y') ");
				/*Tuesday, January 05, 2010 call_function.equals("OT") added for IN017821 */	

				//Condition for Transfer BLOCK BED
				if(call_function.equals("BLOCK_BED"))
					 sql.append(" and (c.BLOCK_BED_YN = 'Y') ");
				//Condition for Transfer BLOCK BED
				if(call_function.equals("RELEASE_BED"))
					 sql.append(" and (c.RELEASE_BED_YN = 'Y') ");
				//Condition for Cancel Admission
				if(call_function.equals("CancelAdmission"))
					sql.append(" and (c.CANC_ADMISSION_YN = 'Y') ");
				//Condition for Assign Bed
				if(call_function.equals("assign_bed"))
					sql.append(" and (c.ASSIGN_BED_YN = 'Y' ) ");
				//Condition for AssignTreatingPract
				if(call_function.equals("AssignTreatingPract"))
					 sql.append(" and (c.ASSIGN_TREAT_PRACT_YN = 'Y') ");
				//Condition for ExpectedDischarge
				if(call_function.equals("ExpectedDischarge"))
					sql.append(" and (c.ADMIT_PAT_YN = 'Y') ");
				//Condition for Transfer Patient 
				if(call_function.equals("TransferPatient"))
					 sql.append(" and (c.EMERGENCY_TFR_YN = 'Y') ");
				//Condition for SWAP PATIENT BED 
				if(call_function.equals("SWAP_PAT_BED"))
					sql.append(" and (c.SWAP_BED_YN = 'Y') ");
				//Condition for TransferPractitioner 
				if(call_function.equals("TransferPractitioner"))
					sql.append(" and (c.PRACT_TRANSFER_YN = 'Y') ");
				//Condition for TransferPractitioner 
				if(call_function.equals("RequestforTransfer"))
					sql.append(" and (c.ROUTINE_TFR_YN = 'Y') ");
				//Condition for Transfer Patient OUT Criteria
				if(call_function.equals("TransferPatientOut"))
					sql.append(" and (c.TRANSFER_OUT_PATIENT_YN = 'Y') ");
				//Condition for Transfer Patient In Criteria
				if(call_function.equals("TransferPatientIn"))
					sql.append(" and (c.TRANSFER_IN_PATIENT_YN = 'Y') ");
				//Condition for Cancle Transfer Patient Out Criteria
				if(call_function.equals("CancelTransferPatientOut"))
					sql.append(" and (c.CANCEL_TRANSFER_OUT_YN = 'Y') ");
				//Condition for Confirm Request Transfer Criteria
				if(call_function.equals("CONFIRM_TRANS_BOOKING"))
					sql.append(" and (c.CONFIRM_REQUEST_YN = 'Y') ");
				//Condition for Cancle Request Transfer Criteria
				if(call_function.equals("CANCEL_TRANS_BOOKING"))
					sql.append(" and (c.CANCEL_REQUEST_YN = 'Y') ");
				//Condition for Confirm Bed Class Criteria
				if(call_function.equals("ConfirmBedClass"))
					sql.append(" and (c.BED_CLASS_CHANGE_YN = 'Y') ");
				//Condition for Prepare Discharge Advice Criteria
				if(call_function.equals("PrepareDischargeAdvice"))
					 sql.append(" and (c.DISCHARGE_ADVICE_YN = 'Y') ");
				//Condition for Discharge Patient Criteria
				if(call_function.equals("DischargePatient"))
					sql.append(" and (c.DISCHARGE_PAT_YN = 'Y') ");
				//Condition for Checkin Accompaning Person Criteria
				if(call_function.equals("CHECK_IN_ACCMP_PERSON"))
					sql.append(" and (c.CHECK_LODGER_YN = 'Y') ");
				//Condition for Record Inpatient Leave / Amend Inpatient Leave Criteria
				if(call_function.equals("RecordInpatienLeave")||call_function.equals("AMEND_LEAVE"))
				  sql.append(" and (c.REVISE_LEAVE_YN = 'Y') ");
				//Condition for Transfer Patient In
				if(call_function.equals("Transfer_In"))
					sql.append(" and (c.TRANSFER_IN_PATIENT_YN = 'Y') ");
				//Condition for New Born Reg
				if(call_function.equals("NEWBORN_REG") || call_function.equals("BabyLinktoMother"))
					sql.append(" and (a.ALLOW_NEW_BORN_REGN_YN ='Y') ");

				//Condition for AssignBed after Admit patient
				/*Wednesday, March 03, 2010 ,IN019731 , to filter nursing unit if change nursing unit in assign bed is unchecked in AM->operator station restriction function , c.chg_nurs_unit_in_assign_bed_yn = 'Y' added */
				if(call_function.equals("ASSIGN_BED"))
					sql.append(" and (c.assign_bed_yn = 'Y' and c.chg_nurs_unit_in_assign_bed_yn = 'Y') and  a.locn_type=c.locn_type ");

				//Condition for RENEW_GATE_PASS
				if(call_function.equals("RENEW_GATE_PASS") || call_function.equals("CHECK_OUT_ACCMP_PERSON") || call_function.equals("CHECK_OUT_LODGER") )
					sql.append(" and (c.CHECK_LODGER_YN = 'Y') ");

				//Condition for Emergency Transfer Patient 
				if(call_function.equals("EMERGENCY_TRANSFER"))
					 sql.append(" and (c.EMERGENCY_TRANSFER_YN = 'Y') ");
				//Condition Added For Change Patient Details  @ 3/16/2009
				if(call_function.equals("MODIFY_SERVICE_FOR_INPATIENT"))
					sql.append(" and (c.revise_admission_yn='Y') ");
			

		

			}
			/*//Condition Added For Change Patient Details  @ 3/16/2009
			if(call_function.equals("MODIFY_SERVICE_FOR_INPATIENT")){
				sql.append(" and (c.revise_admission_yn='Y') ");
			}*/

			// This is for where criteria for the query
			if(!patient_class.equals("")) 
				sql.append(" and a.PATIENT_CLASS='"+patient_class+"' ");
			
			if(!nursing_unit_desc.equals(""))
			{
				whereClause = " and upper(a.SHORT_DESC) like ";
				if(start_ends_contains.equals("S"))
				{
					nursing_unit_desc=nursing_unit_desc+"%";
					whereClause=whereClause+"upper(?)";
				}
				else if(start_ends_contains.equals("E"))
				{
					nursing_unit_desc="%"+nursing_unit_desc;
					whereClause=whereClause+"upper(?)";
				}
				else if(start_ends_contains.equals("C"))
				{
					nursing_unit_desc="%"+nursing_unit_desc+"%";
					whereClause=whereClause+"upper(?)";
				}
			}
			else  if(!nursing_unit_code.equals(""))
			{
				whereClause = " and upper(A.Nursing_unit_code) like ";
				if(start_ends_contains.equals("S"))
				{
					nursing_unit_code=nursing_unit_code+"%";
					whereClause=whereClause+"upper(?)";
				}
				else if(start_ends_contains.equals("E"))
				{
					nursing_unit_code="%"+nursing_unit_code;
					whereClause=whereClause+"upper(?)";
				}
				else if(start_ends_contains.equals("C"))
				{
					nursing_unit_code="%"+nursing_unit_code+"%";
					whereClause=whereClause+"upper(?)";
				}
			}
			
			sql.append(whereClause);
			sql.append(" ORDER BY "+radioval);	
		}	
		else
		{
			sql.append(user_sql);
		}


		int start			= 0 ;
		int end				= 0 ;
		int k				= 0;
		int nRowCount =0; // this line and added  for ICN-64475
		if (( from == null ) ||(from == ""))
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;
		if (( to == null ) ||(to == ""))
			end = 14 ;
		else
			end = Integer.parseInt(to);
		try
		{
		
			pstmt = conn.prepareStatement(sql.toString());

			if(!nursing_unit_desc.equals(""))
			{
				pstmt.setString(1, nursing_unit_desc);
			}
			else if(!nursing_unit_code.equals(""))
			{
				pstmt.setString(1, nursing_unit_code);
			}
			/*Monday, April 19, 2010 , commented for Nurisng Unit Lookup fine tuning.... & added in main query */
			/*
			rs1	= pstmt.executeQuery();
			while(rs1.next())
			{
				//k++;
			}
		
			if(rs1!=null) rs1.close();
			rs1	= pstmt.executeQuery();
			Hashtable block_bed = new Hashtable();
			Vector block = new Vector();
			while(rs1.next())
			{
				k++;
				block.add(rs1.getString("nursing_unit_code"));
			}

			if(rs1!=null) rs1.close();
				
			String sbTmp = new String();			

			sbTmp = "Select sum(case when BOOKING_TYPE IN('B','N','L','T','D') then 1 else 0 end) Blocked from IP_BED_BOOKING where facility_id = '"+facility_id+"' and req_nursing_unit_code = ? and booking_status in('0','1') and ( sysdate between blocked_from_date_time and blocked_until_date_time OR blocked_until_date_time IS NULL )";			
			pstmt_block = conn.prepareStatement(sbTmp);


			// This code is used for finding any blocked beds are there for the nursing units.

			for(int b=0;b<block.size();b++)
			{				
				pstmt_block.setString(1, block.elementAt(b).toString());

				rs1 = pstmt_block.executeQuery();
				
				while(rs1.next())
				{
					String temp = rs1.getString("blocked");
					if(temp == null)
						temp = "0";
					block_bed.put(block.elementAt(b),temp);
				}
			}
			
			if(rs1!=null) rs1.close();
			if(pstmt_block!=null) pstmt_block.close();
			
			
			// If there are no records then message will be fired...
			if(k == 0)
			{
				<!--<script>
					alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));                      
					if(parent.frames[0].document.getElementById('nursing_unit_desc'))                   		
						parent.frames[0].document.getElementById('nursing_unit_desc').readOnly=false;      
					if(parent.frames[0].document.getElementById('Search'))                                     
						parent.frames[0].document.getElementById('Search').disabled=false;                 
					if(parent.frames[0].document.getElementById('clear'))
						parent.frames[0].document.getElementById('clear').disabled=false;	
					document.location.href='../../eCommon/html/blank.html'
				</script>-->
		//	}/*Monday, April 19, 2010 , commented for Nurisng Unit Lookup fine tuning.... & added in main query */
			rs = pstmt.executeQuery();
			session.removeAttribute("SQL_GENNUR");//Added by Kamatchi S for MOHE-SCF-0134
			if(rs != null)
			{
				if ( start != 1 )
				for( int j=1; j<start; i++,j++ ){
					
					rs.next() ;
				}
				
				
				
//			while((i<=(end+1))&&(rs.next()))
				while((rs.next()))
				{
				nRowCount = Integer.parseInt(rs.getString("rowCount"));	 // added  for ICN-64475
					
                  if(i<=(end)){
					if(k == 0)
					{
		%>
			<table align='right'>
				<tr>
					<td>
						<% 

						session.setAttribute("SQL_GENNUR",sql.toString());//Added by Kamatchi S for MOHE-SCF-0134
						// This code is used for next previous navigation 
						if ( !(start <= 1) )
						{
							/*Friday, June 04, 2010 , condition added for SRR20056-SCF-4564-IN021691*/
							if(call_function.equals("IP_Booking") || call_function.equals("CA_Task_IP_Booking") || call_function.equals("Revise_Booking") || call_function.equals("IP_ConfirmBooking") || call_function.equals("OT"))
							{
								out.println("<td align ='right' id='prev'><A HREF='javascript:submitPrevNext("+(start-14)+","+(end-14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
							}else
							{
								//Commented by Kamatchi S for MOHE-SCF-0134
								/*out.println("<td align ='right' id='prev'><A HREF='../../eIP/jsp/GeneralNursingUnitSearchResult.jsp?dispDescFirst="+dispDescFirst+"&sql="+URLEncoder.encode(sql.toString())+"&from="+(start-14)+"&to="+(end-14)+"&facility_id ="+facility_id+"&statics_yn="+statics_yn+"&nursing_unit_code="+URLEncoder.encode(nursing_unit_code,"UTF-8")+"&nursing_unit_desc="+URLEncoder.encode(nursing_unit_desc,"UTF-8")+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");*/
								out.println("<td align ='right' id='prev'><A HREF='../../eIP/jsp/GeneralNursingUnitSearchResult.jsp?dispDescFirst="+dispDescFirst+"&sql=SQL_GENNUR&from="+(start-14)+"&to="+(end-14)+"&facility_id ="+facility_id+"&statics_yn="+statics_yn+"&nursing_unit_code="+URLEncoder.encode(nursing_unit_code,"UTF-8")+"&nursing_unit_desc="+URLEncoder.encode(nursing_unit_desc,"UTF-8")+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
							}
							
						}
						//if ( !( (start+14) > k ) )
							/*Friday, June 04, 2010 , condition added for SRR20056-SCF-4564-IN021691*/
							if(call_function.equals("IP_Booking") || call_function.equals("CA_Task_IP_Booking") || call_function.equals("Revise_Booking") || call_function.equals("IP_ConfirmBooking") || call_function.equals("OT"))
							{
								out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='javascript:submitPrevNext("+(start+14)+","+(end+14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
							}
							else
							{
								//Commented by Kamatchi S for MOHE-SCF-0134
								/*out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eIP/jsp/GeneralNursingUnitSearchResult.jsp?dispDescFirst="+dispDescFirst+"&sql="+URLEncoder.encode(sql.toString())+"&from="+(start+14)+"&to="+(end+14)+"&facility_id ="+facility_id+"&statics_yn="+statics_yn+"&nursing_unit_code="+URLEncoder.encode(nursing_unit_code,"UTF-8")+"&nursing_unit_desc="+URLEncoder.encode(nursing_unit_desc,"UTF-8")+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");*/
								out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eIP/jsp/GeneralNursingUnitSearchResult.jsp?dispDescFirst="+dispDescFirst+"&sql=SQL_GENNUR&from="+(start+14)+"&to="+(end+14)+"&facility_id ="+facility_id+"&statics_yn="+statics_yn+"&nursing_unit_code="+URLEncoder.encode(nursing_unit_code,"UTF-8")+"&nursing_unit_desc="+URLEncoder.encode(nursing_unit_desc,"UTF-8")+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
							}
							
							
					%>
					
					</td>
				</tr>
			</table>
			<BR>
			</P>
			<table border="1" width="100%" cellspacing='0' cellpadding='0' id='tb1'>
			<%if(dispDescFirst.equals("dispDescFirst")||statics_yn.equals("")||statics_yn.equals("N")) 
			{%>
				<th width='50%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th width='20%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th width='30%'><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></th>
			<%} 
			else if(statics_yn.equals("Y"))
			{%>
				<th ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th ><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th ><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></th>
				<th ><fmt:message key="Common.noofbeds.label" bundle="${common_labels}"/></th>
				<th ><fmt:message key="eIP.BedsOccupied.label" bundle="${ip_labels}"/></th>
				<th ><fmt:message key="eIP.BedsBlocked.label" bundle="${ip_labels}"/></th>
				<th ><fmt:message key="eIP.BedsVacant.label" bundle="${ip_labels}"/></th>

			<%} %>
			<%
				}
				
					%>
					<%
					String rowclass		= "" ;

					if ( i % 2 == 0 )
						rowclass = "QRYEVEN" ;
					else
						rowclass = "QRYODD" ;
					code				= rs.getString("nursing_unit_code");
					desc				= specialCharacter(rs.getString("short_desc"));
					pat_class			= rs.getString("APPL_PATIENT_CLASS");
					pat_class_desc		= rs.getString("patient_class");
					if(pat_class_desc.equals("IP"))
						pat_class_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
					else 
						pat_class_desc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

					String total_beds	= "";
					String occupied_beds= "";
					String blocked_beds	= "";
					String vacant_beds	= "";
					if(statics_yn.equals("Y"))
					{
						total_beds		=	rs.getString("total_beds");
						occupied_beds	=	rs.getString("Occupied");
						//blocked_beds	=   (String)block_bed.get(code);
						blocked_beds	=   rs.getString("blocked");
						if(blocked_beds == null) blocked_beds = "0";
						vacant_beds		= Integer.parseInt(total_beds) - Integer.parseInt(occupied_beds) - Integer.parseInt(blocked_beds) + "";
						/*4/1/2009 IN009426 */
						vacant_beds		= Integer.parseInt(vacant_beds) < 0 ? "0" : vacant_beds +"";
						/**/
						linkColor		= Integer.parseInt(total_beds) == 0 ? "" : "COLOR:BLUE;cursor:pointer;";
					}
					%>
					<tr style='background-color:;'  ><td class='<%=rowclass%>'>
					<input type='hidden' name="desc<%=i%>" value="<%=desc%>" >	
					<%		//this case is redundant as of now....
					if(dispDescFirst.equals("dispDescFirst")||statics_yn.equals("")||statics_yn.equals("N")) 
					{
						if(!locale.equals("en"))
						{	%>
							<a href='javascript:close_window("<%=code%>","<%=i%>","<%=pat_class%>","<%=desc%>")'>
					<%	}
						else	
						{	%>
							<a href='javascript:close_window("<%=code%>","<%=i%>","<%=pat_class%>","<%=desc%>")'>
					<%	}	%>

						<%=desc%></a></td><td width='2%' class='<%=rowclass%>'>
						<%=code%></td><td width='2%' class='<%=rowclass%>'>
						<%=pat_class_desc%></td></tr>
					<%
					}
					else if(statics_yn.equals("Y"))
					{
						if(!locale.equals("en"))
						{ 
							out.print("<a href=\"javascript:close_window('"+code+"','"+i+"','"+pat_class+"','"+desc+"')\">"+code+"</a></td>");
						} 
						else
						{
						%>
							<a href=# onclick='close_window("<%=code%>","<%=i%>","<%=pat_class%>","<%=desc%>")'><%=code%></a></td>
							
					<%	}	%>
						<td class='<%=rowclass%>'
						<a href='javascript:close_window("<%=code%>","<%=i%>","<%=pat_class%>","<%=desc%>")'>
						<%=desc%></a></td><td class='<%=rowclass%>' align='right'>
						<%=pat_class_desc%></td>
						<td class='<%=rowclass%>' style='<%=linkColor%>' align='right' onMouseOut='hideToolTip()' onclick='openToolTip("<%=code%>");' ><%=total_beds%>
						</td><td class='<%=rowclass%>' style='<%=linkColor%>' align='right' onMouseOut='hideToolTip()' onclick='openToolTip("<%=code%>");'><%=occupied_beds%></td>
						<td class='<%=rowclass%>' style='<%=linkColor%>' align='right' onMouseOut='hideToolTip()' onclick='openToolTip("<%=code%>");'><%=blocked_beds%></td>
						<td class='<%=rowclass%>' style='<%=linkColor%>' align='right' onMouseOut='hideToolTip()' onclick='openToolTip("<%=code%>");'><%=vacant_beds%></td></tr>
						<%
					}
				}
					i++;
					k++;
				}
				if(i == 2) 
				{
					%>
					<script>closeesc('<%=code%>',"<%=desc%>",'<%=pat_class%>');</script>
					<%
				}
				if(k == 0)
				{%>
				<script>
					alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));                      
					if(parent.frames[0].document.getElementById('nursing_unit_desc'))                   		
						parent.frames[0].document.getElementById('nursing_unit_desc').readOnly=false;      
					if(parent.frames[0].document.getElementById('Search'))                                     
						parent.frames[0].document.getElementById('Search').disabled=false;                 
					if(parent.frames[0].document.getElementById('clear'))
						parent.frames[0].document.getElementById('clear').disabled=false;	
					document.location.href='../../eCommon/html/blank.html'
				</script>
				<%	}
				%>
				<script>
					if(parent.frames[0].document.getElementById('nursing_unit_code'))
						parent.frames[0].document.getElementById('nursing_unit_code').readOnly=false;                     
					if(parent.frames[0].document.getElementById('nursing_unit_desc'))
						parent.frames[0].document.getElementById('nursing_unit_desc').readOnly=false;               
					if(parent.frames[0].document.getElementById('Search'))
						parent.frames[0].document.getElementById('Search').disabled=false;
					if(parent.frames[0].document.getElementById('clear'))
						parent.frames[0].document.getElementById('clear').disabled=false;
				</script>
				<%
			} 
				
				

				//if ( (k < 14) && (!rs.next()) ) // commented this line and added new line for ICN-64475
				if ( k<14 || (end >= nRowCount) ) 
				{
				%>
				<script >
					if (document.getElementById('next'))
						document.getElementById('next').style.visibility='hidden';
				</script>
				<% 
				}
				else
				{%>
				<script >
					
					if (document.getElementById('next'))
						document.getElementById('next').style.visibility='visible';
				</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

				<%
				}
		}
		catch(Exception e) { out.println(e.toString()); e.printStackTrace();}
		
		%>
		</table>
		<input type='hidden' name='searchtext' id='searchtext' value="<%=searchtext%>" > 
		<input type=hidden name='from' id='from' value="<%=start%>">
		<input type=hidden name='to' id='to' value="<%=end%>">
		<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:5%; visibility:visible;' bgcolor='blue'>
			<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
				<tr>
					<td width='100%' id='t'></td>
				</tr>
			</table>
		</div>
		</form>
		</BODY>
		</html>
		<%!  
	public String specialCharacter(String single)
	{
		if(single == null) single = "";
		return single.replaceAll("'","");
	}	
%>
			
			
			<%
	}
	catch(Exception e) {
		
		e.printStackTrace();
		
		}
	finally
	{
		if(pstmt!=null) pstmt.close();
		if(pstmt_block!=null) pstmt_block.close();
		if (rs != null) rs.close();
		if (rs1 != null) rs1.close();
		if (conn != null)
		ConnectionManager.returnConnection(conn,request);

		}
%>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

