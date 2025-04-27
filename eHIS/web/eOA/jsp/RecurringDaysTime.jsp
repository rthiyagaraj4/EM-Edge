<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<Script src="../../eOA/js/SecondaryResource.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>

<% 
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			Connection con = null; 
			CallableStatement statement=null;
			ResultSet rs = null;
			Statement stmtsd=null;
			PreparedStatement stmtps=null;
			ResultSet rsps=null;
			CallableStatement cstmt = null;

			String blkStatus="";
			String blkRemark="";
			String clinic_date="";
			String nowarp1 ="";
			//jit
			String holdArr[]=new String[5];
			ArrayList arrLst=new ArrayList();
			String tmp_Hld_var="";
	
			//Below variable declare for this  [Bru-HIMS-CRF-177]	
	String colour_indicator="",  vist_code=""; 

	//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
	String schedule_extend_yn="N";

	//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
	 Boolean isSlotStartMidEndAppl = false;
	 String p_o_ext_slot_status = "";
	 String p_o_reserved_slot_dtls = "";
	 String p_o_appt_slot_dtls = "";
	 String p_o_block_slot_dtls = "";
	 String p_o_break_slot_dtls = "";

try
{

			con=ConnectionManager.getConnection(request);

			isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1

			String date=(String)request.getParameter("Date");
			String clinic_code=(String)request.getParameter("clinic_code");
			String pat_id1=request.getParameter("patient_id");
			String locale = (String)session.getAttribute("LOCALE");
			String care_locn_ind=request.getParameter("care_locn_ind");
			String res_class=request.getParameter("res_class");
			
			

			String care_locn_ind_desc="";
			if(care_locn_ind.equals("C")){
				care_locn_ind_desc="Clinic";
			}else if(care_locn_ind.equals("E")){
				care_locn_ind_desc="Procedure Unit";
			}else if(care_locn_ind.equals("D")){
				care_locn_ind_desc="Day Care Unit";
			}

			String res_class_desc="";
			if(res_class.equals("P")){
				res_class_desc="Practitioner";
			}else if(res_class.equals("E")){
				res_class_desc="Equipment";
			}else if(res_class.equals("R")){
				res_class_desc="Room";
			}else if(res_class.equals("O")){
				res_class_desc="Others";
			}else if(res_class.equals("B")){
				res_class_desc="Bed";
			}


			String practitioner_id=(String)request.getParameter("practitioner_id");
				if( practitioner_id == null|| practitioner_id.equals("null")) practitioner_id="";
			String facilityid=(String)session.getValue("facility_id");

			String P_O_CLINIC             ="";
			String P_O_PRACTITIONER       ="";
			String P_O_MAX_PAT            ="";
			String P_O_MAX_OVER_BOOK      ="";
			String P_O_BOOKED             ="";
			String P_O_OVER_BOOKED        ="";
			String P_O_OVER_BOOKING       ="";
			String P_O_TIME_TAB_TYPE     ="";
			String P_O_STATUS             ="";
			String P_O_FROM_TIME          ="";
			String P_O_TO_TIME            ="";
			String P_O_APPT_REF_NO        ="";
			String P_O_PATIENT_NAME       ="";
			String P_O_PATIENT_ID       ="";
			String P_O_END_TIME= "";
			String P_O_VISIT_TYPE_IND     ="";
			String P_O_NO_OF_SLOTS= "";
			String P_O_Max_Forced= "";
			String P_O_Total_Forced= "";
			String P_O_Max_Global= "";
			String P_O_Total_Global= "";
			String P_APPT_OTH_DTL="";
			
			String P_O_VISIT_TYPE_CODE="";  //Added Bru-HIMS- CRF-177

			String u="";
			String u1="";
	
				PreparedStatement pstmtststus=null;
				ResultSet rsststus=null;
				//String sqlStat="SELECT NVL(Schedule_status,'A') Schedulestatus,Remarks, schedule_extend_yn FROM OA_CLINIC_SCHEDULE WHERE care_locn_type_ind='"+care_locn_ind+"' and resource_class='"+res_class+"' and Facility_id=? AND clinic_date=TO_DATE(?,'dd/mm/yyyy') AND clinic_code=? AND nvl(practitioner_id,'x')=nvl(?,'x')";
				String sqlStat="SELECT NVL(Schedule_status,'A') Schedulestatus,Remarks, schedule_extend_yn FROM OA_CLINIC_SCHEDULE WHERE care_locn_type_ind=? and resource_class=? and Facility_id=? AND clinic_date=TO_DATE(?,'dd/mm/yyyy') AND clinic_code=? AND nvl(practitioner_id,'x')=nvl(?,'x')";

				pstmtststus=con.prepareStatement(sqlStat);
				pstmtststus.setString( 1, care_locn_ind);
				pstmtststus.setString( 2, res_class);
				pstmtststus.setString( 3, facilityid);
				pstmtststus.setString( 4, date);
				pstmtststus.setString( 5, clinic_code);
				pstmtststus.setString( 6, practitioner_id);

				rsststus = pstmtststus.executeQuery();
				if(rsststus !=null)
				{
					rsststus.next();
					blkStatus= rsststus.getString("Schedulestatus");
					blkRemark=rsststus.getString("Remarks");
					schedule_extend_yn=rsststus.getString("schedule_extend_yn");
					if(schedule_extend_yn==null) schedule_extend_yn="N";
				} 

				if(pstmtststus!=null) pstmtststus.close();
				if(rsststus!=null) rsststus.close();

				/* Added for ML-BRU-CRF-0628.1 */
				if(isSlotStartMidEndAppl){
					cstmt = con.prepareCall("{call oa_external_slots_BRU(?,?,?,?,?,?,?,?,?)}");
					cstmt.setString( 1, facilityid );
					cstmt.setString( 2, clinic_code );
					cstmt.setString( 3, practitioner_id );
					cstmt.setString( 4, date );
					cstmt.registerOutParameter( 5, Types.VARCHAR );
					cstmt.registerOutParameter( 6, Types.VARCHAR );
					cstmt.registerOutParameter( 7, Types.VARCHAR );
					cstmt.registerOutParameter( 8, Types.VARCHAR );
					cstmt.registerOutParameter( 9, Types.VARCHAR );

					cstmt.execute() ;

					p_o_ext_slot_status = cstmt.getString( 5 ); 
					if(p_o_ext_slot_status == null) p_o_ext_slot_status = "";
					
					p_o_reserved_slot_dtls = cstmt.getString( 6 );
					if(p_o_reserved_slot_dtls == null) p_o_reserved_slot_dtls = "";

					p_o_appt_slot_dtls = cstmt.getString( 7 );
					if(p_o_appt_slot_dtls == null) p_o_appt_slot_dtls = "";

					p_o_block_slot_dtls = cstmt.getString( 8 );
					if(p_o_block_slot_dtls == null) p_o_block_slot_dtls = "";

					p_o_break_slot_dtls = cstmt.getString( 9 );
					if(p_o_break_slot_dtls == null) p_o_break_slot_dtls = "";
				}
				/* End ML-BRU-CRF-0628.1 */


				statement=con.prepareCall("{call oa_schedules.get_day_status( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

				statement.setString( 1, facilityid);
				statement.setString( 2, date);
				statement.setString( 3, clinic_code);
				statement.setString( 4, practitioner_id);
				statement.setString( 5, care_locn_ind);
				statement.setString( 6, res_class);

				
				statement.registerOutParameter(7, Types.VARCHAR );
				statement.registerOutParameter(8, Types.VARCHAR );
				
				/*
				statement.registerOutParameter(7, Types.CLOB );
				statement.registerOutParameter(8, Types.CLOB );
				*/

				statement.registerOutParameter(9, Types.INTEGER);
				statement.registerOutParameter(10, Types.INTEGER);
				statement.registerOutParameter(11, Types.INTEGER);
				statement.registerOutParameter(12, Types.INTEGER);

				statement.registerOutParameter(13, Types.VARCHAR );
				statement.registerOutParameter(14, Types.VARCHAR );
				statement.registerOutParameter(15, Types.VARCHAR );
				statement.registerOutParameter(16, Types.VARCHAR );
				statement.registerOutParameter(17, Types.VARCHAR );
				statement.registerOutParameter(18, Types.VARCHAR );
				statement.registerOutParameter(19, Types.VARCHAR );
				statement.registerOutParameter(20, Types.VARCHAR );
				statement.registerOutParameter(21, Types.VARCHAR );
				statement.registerOutParameter(22, Types.VARCHAR );
				statement.registerOutParameter(23, Types.VARCHAR );
				statement.registerOutParameter(24 ,Types.VARCHAR );
				statement.registerOutParameter(25 ,Types.VARCHAR );
				statement.registerOutParameter(26 ,Types.VARCHAR );
				statement.registerOutParameter(27 ,Types.VARCHAR );
				statement.registerOutParameter(28 ,Types.VARCHAR );
				statement.registerOutParameter(29 ,Types.VARCHAR );
				statement.registerOutParameter(30 ,Types.VARCHAR );
				statement.registerOutParameter(31 ,Types.VARCHAR );
				statement.registerOutParameter(32 ,Types.VARCHAR );
				statement.registerOutParameter(33 ,Types.VARCHAR );
				
				/*
				statement.registerOutParameter(13, Types.CLOB );
				statement.registerOutParameter(14, Types.CLOB );
				statement.registerOutParameter(15, Types.CLOB );
				statement.registerOutParameter(16, Types.CLOB );
				statement.registerOutParameter(17, Types.CLOB );
				statement.registerOutParameter(18, Types.CLOB );
				statement.registerOutParameter(19, Types.CLOB );
				statement.registerOutParameter(20, Types.CLOB );
				statement.registerOutParameter(21, Types.CLOB );
				statement.registerOutParameter(22, Types.CLOB );
				statement.registerOutParameter(23, Types.CLOB );
				statement.registerOutParameter(24 ,Types.CLOB );
				statement.registerOutParameter(25 ,Types.CLOB );
				statement.registerOutParameter(26 ,Types.CLOB );
				statement.registerOutParameter(27 ,Types.CLOB );
				statement.registerOutParameter(28 ,Types.INTEGER );
				statement.registerOutParameter(29 ,Types.INTEGER);
				statement.registerOutParameter(30 ,Types.INTEGER );
				statement.registerOutParameter(31 ,Types.INTEGER );
				statement.registerOutParameter(32 ,Types.CLOB );
				statement.registerOutParameter(33 ,Types.CLOB );
				*/
				statement.setString( 34, locale);
				
				statement.registerOutParameter(35 ,Types.VARCHAR );
				statement.registerOutParameter(36 ,Types.VARCHAR );
				statement.registerOutParameter(37 ,Types.VARCHAR );
				statement.registerOutParameter(38 ,Types.VARCHAR );
				statement.registerOutParameter(39 ,Types.VARCHAR );
				statement.registerOutParameter(40 ,Types.VARCHAR );
				statement.registerOutParameter(41 ,Types.VARCHAR );
				
				/*
				statement.registerOutParameter(35 ,Types.CLOB );
				statement.registerOutParameter(36 ,Types.CLOB );
				statement.registerOutParameter(37 ,Types.CLOB );
				statement.registerOutParameter(38 ,Types.CLOB );
				statement.registerOutParameter(39 ,Types.CLOB );
				statement.registerOutParameter(40 ,Types.CLOB );
				*/

				statement.execute() ;


				P_O_CLINIC=statement.getString( 7 ); if(P_O_CLINIC == null) P_O_CLINIC="";
				P_O_PRACTITIONER=statement.getString( 8 ); if(P_O_PRACTITIONER == null) P_O_PRACTITIONER="";
				P_O_MAX_PAT=statement.getString( 9 ); if(P_O_MAX_PAT == null) P_O_MAX_PAT="";
				P_O_MAX_OVER_BOOK     =statement.getString( 10 );        if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";
				P_O_BOOKED                 =statement.getString(11 );   if( P_O_BOOKED ==null) P_O_BOOKED="";
				P_O_OVER_BOOKED        =statement.getString( 12 );    if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";
				P_O_OVER_BOOKING         =statement.getString( 13 );     if(P_O_OVER_BOOKING == null) 
				P_O_OVER_BOOKING="";
				P_O_TIME_TAB_TYPE          =statement.getString( 14 );if(P_O_TIME_TAB_TYPE == null) P_O_TIME_TAB_TYPE="";
				P_O_STATUS                    =statement.getString(15);if(P_O_STATUS == null) P_O_STATUS="";
				P_O_FROM_TIME            =statement.getString( 16 );     if(P_O_FROM_TIME == null) P_O_FROM_TIME="";

				P_O_TO_TIME                   =statement.getString( 17 );
				if(P_O_TO_TIME == null) P_O_TO_TIME="";


				P_O_APPT_REF_NO         =statement.getString(18 );      
				if(P_O_APPT_REF_NO ==null) P_O_APPT_REF_NO="";
				P_O_PATIENT_NAME        =statement.getString( 19 );      if(P_O_PATIENT_NAME ==null) P_O_PATIENT_NAME="";

				tmp_Hld_var                       =statement.getString( 20 );		if(tmp_Hld_var ==null) tmp_Hld_var="";
				holdArr[0]=tmp_Hld_var;

				tmp_Hld_var                    =statement.getString( 21 );	if(tmp_Hld_var ==null) tmp_Hld_var="";
				holdArr[1]=tmp_Hld_var;

				tmp_Hld_var    =statement.getString( 22 );        if(tmp_Hld_var ==null) tmp_Hld_var="";
				holdArr[2]=tmp_Hld_var;

				tmp_Hld_var                =statement.getString( 23 );		if(tmp_Hld_var ==null) tmp_Hld_var="";
				holdArr[3]=tmp_Hld_var;

				tmp_Hld_var       =statement.getString( 24 );		if(tmp_Hld_var == null) tmp_Hld_var="";
				holdArr[4]=tmp_Hld_var;
				P_O_END_TIME = statement.getString(25); if( P_O_END_TIME == null) P_O_END_TIME="";
				P_O_VISIT_TYPE_IND = statement.getString(26); if( P_O_VISIT_TYPE_IND == null) P_O_VISIT_TYPE_IND="";
				P_O_NO_OF_SLOTS = statement.getString(27); if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";

				P_O_Max_Forced=statement.getString(28); if( P_O_Max_Forced == null) P_O_Max_Forced="";
				P_O_Total_Forced=statement.getString(29); if( P_O_Total_Forced == null) P_O_Total_Forced="";

				P_O_Max_Global=statement.getString(30); if( P_O_Max_Global == null) P_O_Max_Global="";
				P_O_Total_Global=statement.getString(31); if( P_O_Total_Global == null) P_O_Total_Global="";

				P_O_PATIENT_ID=statement.getString(32); if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";
				
					/*Below Line Added for this CRF [Bru-HIMS-CRF-177]*/
	P_O_VISIT_TYPE_CODE = statement.getString(35);
	if( P_O_VISIT_TYPE_CODE == null) P_O_VISIT_TYPE_CODE="";	
	//End[Bru-HIMS-CRF-177]
				
				
				
				P_APPT_OTH_DTL= statement.getString(40); if( P_APPT_OTH_DTL == null) P_APPT_OTH_DTL="";




			StringTokenizer token = new StringTokenizer(P_O_FROM_TIME, "|");
			int counter=token.countTokens();

			String from_time[]=new String[counter];
			int track=0;
			while (token.hasMoreTokens())
				{
				from_time[track]=token.nextToken();
				track++;
				}
			
			token=null;
			track=0;
			token = new StringTokenizer(P_O_TO_TIME, "|");

			String to_time[]=new String[counter];
			String end_time ="";
			int tot_token= token.countTokens();

			while (token.hasMoreTokens())
			{
				end_time=token.nextToken();

				if(schedule_extend_yn.equals("Y") && P_O_TIME_TAB_TYPE.equals("1")) { // to handle last slot for extended

					if (tot_token-track == 1) {					
						end_time="00:00";
					}
				}
				
				to_time[track]=end_time;

				track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_PATIENT_NAME, "|");
			String patient_name[]=new String[counter];
			while (token.hasMoreTokens())
				{
				patient_name[track]=token.nextToken();
				track++;
				}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_PATIENT_ID, "|");
			String patient_id[]=new String[counter];
			while (token.hasMoreTokens())
				{
				patient_id[track]=token.nextToken();
				track++;
				}


			

			// code opt by Jith

			for(int ij=0;ij<holdArr.length;ij++){
				token=null;
				track=0;
				String popArr[]=new String[counter];
				token = new StringTokenizer(holdArr[ij], "|");

				while (token.hasMoreTokens()){
					popArr[track]=token.nextToken();
					track++;
				}
				 arrLst.add(popArr);				 
			}

			// end jith

			token=null;
			track=0;
			token = new StringTokenizer(P_O_APPT_REF_NO, "|");
			String o_appt_ref_no[]=new String[counter];
			while (token.hasMoreTokens())
			{
			o_appt_ref_no[track]=token.nextToken();
			track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_STATUS, "|");
			String status[]=new String[counter];
			String status1[]=new String[counter];
			while (token.hasMoreTokens())
			{
			status[track]=token.nextToken();
			status1[track]=status[track];
			track++;
			}
			

			token=null;
			track=0;
			token = new StringTokenizer(P_O_VISIT_TYPE_IND, "|");
			String visit_type_ind[]=new String[counter];
			while (token.hasMoreTokens())
			{
			visit_type_ind[track]=token.nextToken();
			track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_NO_OF_SLOTS, "|");
			String no_of_slots[]=new String[counter];
			while (token.hasMoreTokens())
			{
			no_of_slots[track]=token.nextToken();
			track++;
			}
			
			
			/*Below Line Added for this CRF [Bru-HIMS-CRF-177]*/
			token=null;
			track=0;
			token = new StringTokenizer(P_O_VISIT_TYPE_CODE, "|");
			String visit_type_code[]=new String[counter];
			while (token.hasMoreTokens())
			{   
				visit_type_code[track]=token.nextToken();
				track++;
				
			}
		//End [Bru-HIMS-CRF-177]	
%>

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	 -->	
	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name='displayresults' id='displayresults'>
		
<table  border='0' width='100%' cellspacing='0' cellpadding='2' valign='top'>
	<%
	String date_val_display =DateUtils.convertDate(date,"DMY","en",locale);
	%>
		
	<tr>
			<td  class='label'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>	
			<td class='fields'><b><%=date_val_display%></b></td>
			<td class='label' colspan='2'></td>
	</tr>
	<tr>
			<td  class='label'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td  class='fields'><b><%=care_locn_ind_desc%></b></td>
			<td  class='label'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td  class='fields'><b><%=P_O_CLINIC %></b></td>
	</tr>
	<tr>
			<td  class='label'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
			<td  class='fields'><b><%=res_class_desc%></b></td>
			<td  class='label'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
			<td  class='fields'><b><%=P_O_PRACTITIONER %> </b></td> 
	</tr>
		
	
		
</table>
<%

	/*Below Code Added for this CRF [Bru-HIMS-CRF-177] */   
        java.util.HashMap hm=eMP.ChangePatientDetails.getColorCode(con,facilityid);			
       // End [Bru-HIMS-CRF-177] 	
		
int maxval=0; String appt_ref_assign_value="";
for (int maxchk = 0; maxchk < o_appt_ref_no.length; maxchk++) 
{
   appt_ref_assign_value=o_appt_ref_no[maxchk];   
   if(!appt_ref_assign_value.equals("~")){
       while(Integer.parseInt(appt_ref_assign_value)>maxval)
       { 
          maxval=Integer.parseInt(appt_ref_assign_value);
       }
   } 
}
// End [Bru-HIMS-CRF-177] 




String classValue="";
int slots = 0;
String same_appt = "N";
String pat_name = "";
for(int init=0;init<counter;init++)
{

same_appt = "N";

if( !(no_of_slots[init].equals("~")) && (Integer.parseInt(no_of_slots[init]) > 1) ) 
{
	slots = Integer.parseInt(no_of_slots[init]);
	pat_name = patient_name[init];
}

if ( init % 2 == 0 )
		classValue = "OAQRYEVEN" ;
			else
		classValue = "OAQRYODD" ;
if(init==0){
	%>
<table border="1" width="100%" cellspacing='0' cellpadding='0' id='results'>
	
	<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.totime.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='23%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='2%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='30%'><fmt:message key="Common.ReasonForContact.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='11%' nowrap><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='23%'><fmt:message key="Common.contact.label" bundle="${common_labels}"/></td>
	
	<%}%>
		


<tr>
<%
u=from_time[init];
u1=to_time[init];

//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
if(u1.equals("00:00")){
	u1 = "23:59";
}

String z=status[init];
String z1=status1[init];
String reason ="";
String reason1=z.substring(0,2);
if( z.length() > 2)
	reason=z.substring(2,z.length());
else
	reason="";
z=reason1;


String chk_blank_row_patient=patient_name[init];


if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")){
				if(chk_blank_row_patient.equals("~"))
					{ 
					if(slots > 0)
					 {%>	
						<td width=5% <%=nowarp1%> class="<%=classValue%>" onClick='col(this)'><a  href= javascript:moveNext()><%= u%> <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
						<%slots--;
						same_appt = "Y";
							}
							else
							{
								if(blkStatus.equals("B")){%>
									
									<td width=5% <%=nowarp1%> class="OARED" onClick='col(this)' title="<%=blkRemark%>"><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
								<%}else{%>
										<td width=5% <%=nowarp1%> class="<%=classValue%>" onclick = "col()"><a href= "javascript:cols('<%=u%>','<%=u1%>','<%=date%>')"><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
								<%}
							}
					}
			else
					{

					{%>
					<%if(z1.equals("OL*F")){
						if(blkStatus.equals("B")){%>
												
						<td width=5% <%=nowarp1%> class="OARED" onClick='col(this)'><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>

						<%}else{%>
													
						<td width=5% <%=nowarp1%> class="OAFORCED" ><a href= javascript:col()><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>

						<%}%>

					<%}else{
							if(blkStatus.equals("B")){%>
								
								<td width=5% <%=nowarp1%> class="OARED" onClick='col(this)' title="<%=blkRemark%>"><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
							<%}else{%>
								<td width=5% <%=nowarp1%> class="<%=classValue%>" onClick='col(this)'><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
							<%}%>
					<%}%>
					<%pat_name = patient_name[init];
						slots--;
					}
					
					}


		}
	else if (z.equals("RN")){%>
	
		<td width=5% <%=nowarp1%> class='oablock'><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
	<%}else
			if (z.equals("VT")){%>
			
		<td width=5% <%=nowarp1%> class="<%=classValue%>"><%=u%> <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
	<%} else { %>
		<td width=5% <%=nowarp1%> class='oared'><%=u%> <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
			<% }

if( ! u1 .equals("~"))

{
	if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT"))
	{
		if(blkStatus.equals("B")){%>
			<td width=5% <%=nowarp1%> class="OARED" title="<%=blkRemark%>"><%=u1%></td>
		<%}else{%>
			<%if(z1.equals("OL*F")){%>
				<td width=5% <%=nowarp1%> class="OAFORCED" Title="Forced Appointment"><%=u1%></td>
			<%}else{%>
				<td width=5% <%=nowarp1%> class="<%=classValue%>"><%=u1%></td>
			<%}%>

		<%}%>
	<%}
	else
	if(z.equals("RN"))
	{%>
		<td width=5% <%=nowarp1%> class='oablock'><%=u1%></td>
	<%}
	else
	if(z.equals("BN"))
	{%>
		<td width=5% <%=nowarp1%> class='OARED'  title ="<%=reason%>"><%=u1%></td>
	<%}
}
else{%>
	<td width=5% <%=nowarp1%> class="<%=classValue%>">&nbsp;</td>
<%}


String u2=patient_name[init];//patient name

String pat_id=patient_id[init];
if(pat_id.equals("~"))
	pat_id="";
else
	pat_id=pat_id+" , ";

	if( ! u2 .equals("~")){
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT")){%>
			<td width=23% <%=nowarp1%> class="<%=classValue%>"><%=pat_id%>&nbsp;<%=u2%></td>
		<%}else	{
			if(same_appt.equals("Y")){%>
				<td width=23% <%=nowarp1%> class="<%=classValue%>"></td>
			<%}else{%>
				<td width=23% <%=nowarp1%> class='OARED'>&nbsp;</td>
			<%}
		}
	} else {
		if(same_appt.equals("Y")){%>
			<td width=23% <%=nowarp1%> class="<%=classValue%>"><%=pat_name%></td>
		<%}	else{
			if(z.equals("BN")){%>
				<td width=23% class="<%=classValue%>">Block Reason:&nbsp;<b><%=reason%></b></td>
			<%}else{%>				 
				<td width=23% class="<%=classValue%>">&nbsp;</td>
			<%}
			
		}
	}



for(int kkk=0;kkk<arrLst.size();kkk++){
	String dispArr[]=(String []) arrLst.get(kkk);

	String u3=dispArr[init];
	if( ! u3 .equals("~"))
		{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){
		if(kkk==3){
		 vist_code=checkForNull(visit_type_code[init]);       //this line Added for this CRF [Bru-HIMS-CRF-177]        
		   colour_indicator =checkForNull((String)hm.get(vist_code)); 			
			
			 //if(colour_indicator.equals("") && o_appt_ref_no[init].equals(Integer.toString(maxval))){
			   //  colour_indicator="ORANGE";
			 //  }
			 %>
			  
			   <td width=5% <%=nowarp1%> nowrap style="background-color:<%=colour_indicator%>;FONT-SIZE:8pt;"><%= u3%></td>
			   <%
		      }else{%>
		      <td width=5% class="<%=classValue%>">&nbsp;<%= u3%></td>
		 
		<% }		
		}
		else{%>
			<td width=5% class='OARED'>&nbsp;</td>
		<%}
		}
		else{%>
			<td width=5% class="<%=classValue%>">&nbsp;</td>
		<%}
}

%>

<%}%>
	</TR>
</table>
	<table>
<tr>
<td>
	

	
</td>
</tr>
</table>

			<input type='hidden' name='clinic_code' id='clinic_code' value='<%= clinic_code %>' >
			<input type='hidden' name='clinic_name' id='clinic_name' value='<%=P_O_CLINIC %>' >
			<input type='hidden' name='pract_id' id='pract_id' value='<%=practitioner_id %>' >
			<input type='hidden' name='pract_name' id='pract_name' value='<%=P_O_PRACTITIONER %>' >
			<input type='hidden' name='from_time' id='from_time' value='<%=u%>' >
			<input type='hidden' name='to_time' id='to_time' value='<%=u1%>'>
			<input type='hidden' name='clinic_date' id='clinic_date' value='<%=clinic_date%>'>
			<input type='hidden' name='patient_id' id='patient_id' value='<%=pat_id1%>'>
			<input type="hidden" name ="care_locn_ind" value="<%=care_locn_ind%>">
			<input type="hidden" name ="res_class" value="<%=res_class%>">

			<!-- Added for ML-BRU-CRF-0628.1 -->
			<input type="hidden" name="p_o_ext_slot_status" id="p_o_ext_slot_status" value="<%=p_o_ext_slot_status%>">
			<input type="hidden" name="p_o_reserved_slot_dtls" id="p_o_reserved_slot_dtls" value="<%=p_o_reserved_slot_dtls%>">
			<input type="hidden" name="p_o_appt_slot_dtls" id="p_o_appt_slot_dtls" value="<%=p_o_appt_slot_dtls%>">
			<input type="hidden" name="p_o_block_slot_dtls" id="p_o_block_slot_dtls" value="<%=p_o_block_slot_dtls%>">
			<input type="hidden" name="p_o_break_slot_dtls" id="p_o_break_slot_dtls" value="<%=p_o_break_slot_dtls%>">
			<input type="hidden" name="isSlotStartMidEndAppl" id="isSlotStartMidEndAppl" value="<%=isSlotStartMidEndAppl%>">
			<!-- End ML-BRU-CRF-0628.1 -->

</form>

<script>
	
	/* Added for ML-BRU-CRF-0628.1 */
	if (document.forms[0].isSlotStartMidEndAppl.value=='true'){
	
		var ext_slt=document.forms[0].p_o_ext_slot_status.value;
		var res_slt=document.forms[0].p_o_reserved_slot_dtls.value;
		var appt_slt=document.forms[0].p_o_appt_slot_dtls.value;
		var blk_slt=document.forms[0].p_o_block_slot_dtls.value;
		var brk_slt=document.forms[0].p_o_break_slot_dtls.value;


		var ext_slot_arr=ext_slt.split("|");
		var res_slot_arr=res_slt.split("|");
		var appt_slot_arr=appt_slt.split("|");
		var blk_slot_arr=blk_slt.split("|");
		var brk_slot_arr=brk_slt.split("|");


		for(var i=0;i<=ext_slot_arr.length;i++){
			
			if(ext_slot_arr[i]=='Y') {

				if(blk_slot_arr[i]=='N' && brk_slot_arr[i]=='N') {
					if(res_slot_arr[i] !='N'){
					
						document.getElementById("results").rows(i+1).cells(0).style.backgroundColor = "Bisque";
						document.getElementById("results").rows(i+1).cells(1).style.backgroundColor = "Bisque";
						document.getElementById("results").rows(i+1).cells(0).style.Color = "Black";
						document.getElementById("results").rows(i+1).cells(1).style.Color = "Black";
						document.getElementById("results").rows(i+1).cells(2).style.backgroundColor = "Bisque";
						document.getElementById("results").rows(i+1).cells(2).innerText = "BRU Health Reservation : "+res_slot_arr[i];

					}else {
						document.getElementById("results").rows(i+1).cells(0).style.backgroundColor = "Bisque";
						document.getElementById("results").rows(i+1).cells(1).style.backgroundColor = "Bisque";
					}
				}

				
			}
				
		}
	}
	/* End ML-BRU-CRF-0628.1 */
	</script>
<%
	if (rs != null) rs.close();
	if (rsps != null) rsps.close();
	if (stmtsd != null) stmtsd.close();
	if (stmtps != null) stmtps.close();
	if (statement != null) statement.close();
	if (cstmt != null) cstmt.close();
	arrLst.clear();
}catch(Exception e) {
	///out.println(e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	ConnectionManager.returnConnection(con,request);
} 
%>
   

<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}


%>


