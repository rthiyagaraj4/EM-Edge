<!DOCTYPE html>
<%@ page import="java.sql.*,  java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eCA.TriageDetail.label" bundle="${ca_labels}"/></title>
  <%
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
  <script language='javascript' src='../../eCommon/js/dchk.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
  <!--<script language='javascript' src='../../eAE/js/AESecondaryTriage.js'></script>-->
  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  <script>	
	// To Make RTA Enabled or Disabled
	function doDate1(obj) 
	{
		var fromdate;
		var todate;
		todate  = document.forms[0].sysdate.value;
		fromdate = obj.value;
	
	  if(fromdate!=null &&todate!=null)
		{
		 if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt)) {
			alert(getMessage("LMP_DATE_GRT_SYSDATE",'CA'));
		//	document.forms[0].lmp_date.value="";
            document.forms[0].lmp_date.focus();
		    document.getElementById("nmdesig").innerHTML=""
		    document.getElementById("nmdesig1").innerHTML="";		
			return false;
			}
		 }
		}
	}
	function checktrauma()
	{
       if(document.forms[0].CaseofTrauma.checked==true)
		{
		   document.forms[0].CaseofTrauma_val.value='Y';
	    }
		else
		{
		  document.forms[0].CaseofTrauma_val.value='N';
		}
	}

	function BroughtDead(obj)
	{
		if(obj.value=="Y")
		{
			document.forms[0].ambulatory_status.value='';
				document.forms[0].patient_type.value='';
			document.forms[0].ambulatory_status.disabled = true;
			document.forms[0].responsiveness_val.disabled = true;
			document.forms[0].symptom_val.disabled = true;
			document.forms[0].patient_type.disabled = true;
		}
		else
		{
			document.forms[0].ambulatory_status.disabled = false;
			document.forms[0].responsiveness_val.disabled = false;
			document.forms[0].symptom_val.disabled = false;
			document.forms[0].patient_type.disabled = false;
		}
	}
/* code for menstral history validation  in pediatric details table menstral check box is checked  then pregnent at present checkbox will be enabled if it is checked then lmp date will becomes mandatory */
	function checkmenstrual(obj)
	{//alert(document.forms[0].menarche.checked);
		if((document.forms[0].pregnant_at_present_yn_val!=null) && (document.forms[0].lmp_date!=null))
		{
		if(obj.name=="menarche"){
			if(!(document.getElementById("menarche").value=null))
			   if(document.forms[0].menarche.checked==true)
				{
   				  document.forms[0].pregnant_at_present_yn_val.disabled=false;
			   }
			  else
			  { 
				  document.forms[0].pregnant_at_present_yn_val.checked=false;
				  document.forms[0].pregnant_at_present_yn_val.disabled=true;
				  document.forms[0].lmp_date.value="";
  				  document.forms[0].lmp_date.disabled=true;
				  document.getElementById("lmp_calendar").disabled=true;
				  document.forms[0].mand2.style.visibility='hidden';
				  parent.frames[2].document.getElementById("nmdesig").innerHTML="";
				  parent.frames[2].document.getElementById("nmdesig1").innerHTML="";
		  }
		}else{
				if(!(document.getElementById("pregnant_at_present_yn_val").value=null))
				   if(document.forms[0].pregnant_at_present_yn_val.checked==true)
					{
						document.forms[0].lmp_date.disabled=false;
						document.getElementById("lmp_calendar").disabled=false;
						document.forms[0].mand2.style.visibility='visible';

					}else
					{
						document.forms[0].lmp_date.value="";
						document.forms[0].lmp_date.disabled=true;
						document.getElementById("lmp_calendar").disabled=true;
						document.forms[0].mand2.style.visibility='hidden';
						parent.frames[2].document.getElementById("nmdesig").innerHTML="";
				        parent.frames[2].document.getElementById("nmdesig1").innerHTML="";

					}
		}
		}
	}
   	
	/* code for displaying area codes in  area text box*/
	function searchDisasterArea(obj,target)
     {
                var retVal =    new String();
                var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var tit="";				
					if(target.name == 'disaster_area1'){
					tit="Disaster Area";
                   
				   sql="select res_town_code code,short_desc description from mp_res_town where upper(res_town_code)like upper(?) and upper(short_desc) like upper(?) and eff_status = 'E' order by 2";
					}
							
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				retVal = await CommonLookup( tit, argumentArray );
				if(retVal != null && retVal != "" )
                 {
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					
					target.value=arr[1];
					if(target.name == 'disaster_area1')
					{
						document.forms[0].disaster_area.value= arr[0];
						document.forms[0].disaster_area1.value= arr[1];	
						document.forms[0].disaster_area1.disabled=false;
						
					}
			    }
			   else
		       {
				 target.value="";
				 return;
			   }
	}

	function calculateNoOfDays()
	{
		//alert("calculate no ");
		if(document.getElementById("lmp_date")) {
		if(document.getElementById("lmp_date").value == null || document.getElementById("lmp_date").value == "" || document.getElementById("lmp_date").value == null || document.getElementById("lmp_date").value == "")
			return;

		var from = document.getElementById("lmp_date").value;
		var to   = document.getElementById("visit_date_time").value;		
		
		
		var a=  from.split(" ")
		splitdate=a[0];
        var splitdate1 =splitdate.split("/")
		
		var dateFrom  =new Date(splitdate1[2],splitdate1[1]-1,splitdate1[0])
    
		a=  to.split(" ")
		splitdate=a[0];
		splitdate1 =splitdate.split("/")
		var dateTo  =new Date(splitdate1[2],splitdate1[1]-1,splitdate1[0])
		
		var toMilliSeconds=dateTo.getTime();
		
      
		var fromMilliSeconds=dateFrom.getTime();
		
		var week =(Math.floor(((toMilliSeconds-fromMilliSeconds)/DAY))/7);
		var weeks =Math.floor(week);
		var days =  (Math.round(((toMilliSeconds-fromMilliSeconds)/DAY))%7);
		if(weeks<0 ||days<0)
		{
			return false;
		}
		document.getElementById("nmdesig").innerHTML=weeks;
		document.getElementById("nmdesig1").innerHTML=days;
		//document.getElementById("poa").value =Math.round(weeks);
		//document.getElementById("poa_days").value =days;
		return;
		}
  	}


 function chkhwc(obj)
 {
 if(document.forms[0].growth_age!=null)
	 {
	 if(document.forms[0].growth_age.checked==true)
	 {
       document.forms[0].height.disabled=false;
	   document.forms[0].weight.disabled=false;
	   document.forms[0].circumference.disabled=false;
	 }
	 else
	 {
		 document.forms[0].height.disabled=true;
		 document.forms[0].weight.disabled=true;
		 document.forms[0].circumference.disabled=true;
		 document.forms[0].height.value="";
		  document.forms[0].weight.value="";
		   document.forms[0].circumference.value="";
	 }
	 }
 }
function enablePriorityZone()
{ 
	if(document.forms[0].bed_no.value)
	{
      document.forms[0].priorityR.disabled=true;
	  document.forms[0].priorityG.disabled=true;
	  document.forms[0].priorityY.disabled=true;
	}
}
 </script>
 </head>
<%
Connection con				      = null;
/*
below line commented as per dinesh advice
con = ConnectionManager.getConnection(request);
*/
PreparedStatement pstmt		      = null;
PreparedStatement pstmt2		      = null;
ResultSet rs2				      = null ;
ResultSet rs				      = null ;
ResultSet rset				      = null;
PreparedStatement pstmt1	      = null;
ResultSet rset1				      = null;
PreparedStatement pstmt_date	  = null;
ResultSet rs_date			      = null;
PreparedStatement pstmt_priority  = null; 
ResultSet rs_priority			  = null;
String bed_no = "";

/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	  String sql              ="";
	  String color            ="";
	  String green            ="";
	  String red              ="";
      String yellow           ="";
      String unassigned       ="";
 	/* CRF  SKR-CRF-0021 [IN028173] end  */

String facilityId			= (String)session.getValue("facility_id");
String patient_id			= request.getParameter("patient_id");
// for Frame reference changes
String called_from_ca = request.getParameter("called_from_ca");
if((called_from_ca==null) || (called_from_ca.equals("null")) || (called_from_ca=="") || (called_from_ca.equals("")))
	called_from_ca= "N";
String clinic_code			= request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");

String priority			= (request.getParameter("priority_zone")==null)?"":request.getParameter("priority_zone");
if(priority.equals(""))
    priority="G";

String brought_dead			= request.getParameter("brought_dead")==null?"":request.getParameter("brought_dead");

 
String encounter_id			= request.getParameter("encounter_id");

     if(called_from_ca .equals("Y"))
		{
            String qryPatTriageDetails = "SELECT  a.bed_no FROM ae_patient_queue_vw a,op_clinic b WHERE a.facility_id=b.facility_id  AND a.locn_code=b.clinic_code AND a.facility_id = ? AND  encounter_id=? ";

            pstmt2		=	con.prepareStatement(qryPatTriageDetails);

            pstmt2.setString	(	1,	facilityId		);
			pstmt2.setString	(	2,	encounter_id	);
			rs2			=	pstmt2.executeQuery();
			while(rs2.next())
				{
				bed_no 		=	(rs2.getString("bed_no")==null)		?	""	: rs2.getString("bed_no");
				}

				if(rs2 != null)rs2.close();
				if(pstmt2 != null)pstmt2.close();
	    } 
	 else
		{
		    bed_no               = request.getParameter("bed_no")==null?"":request.getParameter("bed_no");
        }

String heightDesc				= "";
String weightDesc				= "";
String circumDesc				= "";
String sex						= "";
String date_of_birth			= "";
String menstrual_status			= "false";
String pediatric_status			= "false";
String disabled					="disabled";
String visit_date				= "";
String priorityStatus1			= "";
String priorityStatus2			= "";
String priorityStatus3			= "";
String  a_status				="";
String  p_type                  ="";
String complaint_code           ="";
String emergency_yn             ="";
String disaster_yn				="";
String mech_injr_code			="";
String mech_injr_subcat_code	="";
String checked					="";
String checked1					="";
String checked2					="";
String checked3					="";
String checked4					="";
String checked5					="";
String checked6					="";
String checked7					="";
String checked8					="";
String checked9					="";
String optSelected				="";
String vehicle_invlovedcode		="";
String vehicle_invlovedcode1	="";
String protective_device_code	="";
String pat_position_code		="";
String oscc_yn					="";
String mlc_yn					="";
String treat_code				="";
String police_rep_no			="";
String police_station_dtls		="";
String  immunization_status		="";
String selected					="";
String selected1				="";
String selected2				="";
String att_given				="";
String dev_mile_stone			="";
String imm_date					="";
String circumference			="";
String height					="";
String weight					="";
String  menarche_yn				="";
String disaster_town_code		="";
String lmp_date					="";
String disPriority				="";
String disTreatArea				="";

String pregnant_yn				="";
String disabled11				="disabled";
String mech_injury_subcatg_code	="";
String  disable2				="";
String  disable3				="";
String disabled111				="";
String disabled12				="";
String disabled13				="";
String sqlDate					="";
String disabled99="";
String disabled991="";
String disabledPre="";
String disMenarche="";
String pat_priority             =""; 
String trauma_yn                =""; 
String dis_area                 ="";
String dis1						="";
String dis2						="";
String dis3					    ="";
String dis4					    ="";
String dis5					    ="";
String dis6					    ="";
String dis7					    ="";
String dis8					    ="";
String dis9					    ="";
String dis10					="";
String dis11				    ="";
String dis12				    ="";
String dis13				    ="";
String dis14				    ="";
String dis15				    ="";
String disHeight				="";
String disWeight				="";
String disCir				    ="";
String disImm					="";
int  patient_age				= 0;
int min_age_pregnancy			= 0;
int nb_mother_min_age           =0;
int min_age_pregnancy1			= 0;
int max_age_paediatric			= 0;
try
     {
        pstmt  = con.prepareStatement("select to_char(trunc(sysdate),'dd/mm/yyyy') from dual");
		pstmt_date = con.prepareStatement("select to_char(trunc(visit_adm_date_time),'dd/mm/yyyy') from PR_ENCOUNTER where patient_id = ? ");

		pstmt_date.setString(1,patient_id);

        rs = pstmt.executeQuery();
		rs_date = pstmt_date.executeQuery();

       
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();
		if (rs_date!=null)
		{
			while(rs_date.next())
			{
				visit_date = rs_date.getString(1);			
			}
		}
		if (rs_date != null)   rs_date.close();
		if (pstmt_date != null) pstmt_date.close();
     }
     catch(Exception e) { 
		 //out.println("Exception in AESecondaryTriageDetail.jsp"+e.toString());//COMMON-ICN-0181
		 e.printStackTrace();//COMMON-ICN-0181
	}

%>
<%

  /* code added by naveen for defaulting values*/
  try{
        ResultSet rsetsys=null ;
		PreparedStatement stmtsys=null;
        String sysdtsql="select to_char(sysdate,'dd/mm/yyyy') from dual ";
		
	   con = ConnectionManager.getConnection(request);
       
		stmtsys=con.prepareStatement(sysdtsql);
		rsetsys=stmtsys.executeQuery();
		rsetsys.next();
		sqlDate=rsetsys.getString(1);

		if(rsetsys!=null) rsetsys.close();
        if(stmtsys!=null) stmtsys.close();
       
        String sqlquery1=" select AMBULATORY_STATUS,PATIENT_TYPE from PR_ENCOUNTER where   ENCOUNTER_ID= ?";

		String emerdetails ="select emergency_yn,COMPLAINT_CODE,DISASTER_YN,MECH_INJURY_CATG_CODE,MECH_INJURY_SUBCATG_CODE,VEHICLE_INVOLVED1_CODE,VEHICLE_INVOLVED2_CODE,PROTECTIVE_DEVICE_CODE,PAT_POSITION_CODE,OSCC_YN,MLC_CASE_YN,POLICE_REPORT_NO,POLICE_STATION_DTLS,IMMUNIZATION_STATUS,ATT_GIVEN_YN,DEVP_MILESTONE_AGE_YN,IM_UPTO_DATE_YN,MENARCHE_YN,HEIGHT,WEIGHT,CIRCUMFERENCE,DISASTER_TOWN_CODE, to_char(LMP_DATE,'dd/mm/yyyy'),PREGNANT_YN,MECH_INJURY_SUBCATG_CODE,PAT_PRIORITY,TRAUMA_YN from AE_PAT_EMERGENCY_DETAIL where ENCOUNTER_ID= ? AND FACILITY_ID= ? " ; 

		
		String sqltreatment1="select TREATMENT_AREA_CODE ,PRIORITY_ZONE from OP_PATIENT_QUEUE where ENCOUNTER_ID = ?";

         String sqlaeage="  select MIN_AGE_FOR_PREG_DTL, MAX_AGE_FOR_PAED_DTL from ae_param where OPERATING_FACILITY_ID= ?";
		String sqlUnit	    = " select UNIT_OF_LENGTH_NB,UNIT_OF_WT_NB,UNIT_OF_CIRCUM_NB,NB_MOTHER_CUTOFF_AGE from MP_PARAM ";

		String sqlAge	 = " select Calculate_Age(TO_CHAR(date_of_birth,'dd/mm/yyyy'),1), sex from mp_patient where patient_id = ? ";
 
		String sqlAmbulatory = " select AMBULATORY_STATUS,SHORT_DESC from AM_AMBULATORY_STATUS "+
							   " where EFF_STATUS='E' and nvl(eff_date_from,sysdate) >= sysdate "+
						       " and nvl(eff_date_to,sysdate) <= sysdate order by SHORT_DESC ";	   

	    String sqlComplaint	 = " select COMPLAINT_CODE,COMPLAINT_DESC from AM_COMPLAINT "+
						       " where EFF_STATUS='E' order by COMPLAINT_DESC ";

		String sqlPatType	 = " select PATIENT_TYPE,SHORT_DESC from AM_PATIENT_TYPE "+
							   " where EFF_STATUS='E' and nvl(eff_date_from,sysdate) >= sysdate "+
							   " and nvl(eff_date_to,sysdate) <= sysdate order by SHORT_DESC ";
	
		String sqlPosition	= " select PAT_POSITION_CODE,SHORT_DESC from AE_PAT_POSITION "+
							  " where EFF_STATUS='E' order by SHORT_DESC ";
		
		if (priority.equals("R")) priorityStatus1="checked";
		else if (priority.equals("Y")) priorityStatus2="checked";
		else if (priority.equals("G")) priorityStatus3="checked";

                       pstmt = con.prepareStatement(sqlUnit);
				       rset = pstmt.executeQuery();
					   while(rset!=null && rset.next())
					   {
                             heightDesc = rset.getString(1);
							 weightDesc = rset.getString(2);
							 circumDesc = rset.getString(3);
							 nb_mother_min_age = rset.getInt(4);

							
					   } 
   					   if(rset!=null) rset.close();
					   if(pstmt!=null) pstmt.close();

					   if(heightDesc!=null && heightDesc.equalsIgnoreCase("C"))
							heightDesc = "CM";
					   else if(heightDesc!=null && heightDesc.equalsIgnoreCase("I"))
							heightDesc = "Inch";
					   if(weightDesc!=null && weightDesc.equalsIgnoreCase("K"))
							weightDesc = "KG";
					   else if(weightDesc!=null && weightDesc.equalsIgnoreCase("L"))
							weightDesc = "LB";
					   if(circumDesc!=null && circumDesc.equalsIgnoreCase("C"))
							circumDesc = "CM";
					   else if(circumDesc!=null && circumDesc.equalsIgnoreCase("I"))
							circumDesc = "Inch";	
						
                       pstmt = con.prepareStatement(sqlaeage);
						pstmt.setString(1,facilityId);
				       rset = pstmt.executeQuery();
					   while(rset!=null && rset.next())
					   {
                             min_age_pregnancy1 = rset.getInt(1);
							 max_age_paediatric = rset.getInt(2);
							 					   } 
                        if(nb_mother_min_age>0) 
							 min_age_pregnancy=nb_mother_min_age;
                              
						else
                             min_age_pregnancy=min_age_pregnancy1;
						                          
                      pstmt1 = con.prepareStatement(sqlquery1);
					  pstmt1.setString(1,encounter_id);
                      rset1 = pstmt1.executeQuery();
					   while(rset1!=null && rset1.next())
					   {                            
						 a_status	=  rset1.getString(1)==null?"":rset1.getString(1);
						  p_type  	=  rset1.getString(2)==null?"":rset1.getString(2);
					   } 
					   if(!a_status.equals("")) dis1 = disabled;
					    if(!p_type.equals("")) dis4 = disabled;
					  if(rset1!=null) rset1.close(); 
					  if(pstmt1!=null) pstmt1.close();
					  pstmt1 = con.prepareStatement(emerdetails);
					  pstmt1.setString(1,encounter_id);
					  pstmt1.setString(2,facilityId);
					  rset1 = pstmt1.executeQuery();
					   while(rset1!=null && rset1.next())
					    {
                         emergency_yn = rset1.getString(1)==null?"":rset1.getString(1); 
						 complaint_code=rset1.getString(2)==null?"":rset1.getString(2);
						 disaster_yn=rset1.getString(3)==null?"":rset1.getString(3);
						 mech_injr_code=rset1.getString(4)==null?"":rset1.getString(4);
						 mech_injr_subcat_code=rset1.getString(5)==null?"":rset1.getString(5);
						 vehicle_invlovedcode=rset1.getString(6)==null?"":rset1.getString(6);
						 vehicle_invlovedcode1=rset1.getString(7)==null?"":rset1.getString(7);
						 protective_device_code=rset1.getString(8)==null?"":rset1.getString(8);
						 pat_position_code=rset1.getString(9)==null?"":rset1.getString(9);
						 oscc_yn=rset1.getString(10)==null?"":rset1.getString(10);
						 mlc_yn=rset1.getString(11)==null?"":rset1.getString(11);
						 police_rep_no=rset1.getString(12)==null?"":rset1.getString(12);
						 police_station_dtls=rset1.getString(13)==null?"":rset1.getString(13);
                         immunization_status=rset1.getString(14)==null?"":rset1.getString(14);
						 att_given=rset1.getString(15)==null?"":rset1.getString(15);
						 dev_mile_stone=rset1.getString(16)==null?"":rset1.getString(16);
						 imm_date=rset1.getString(17)==null?"":rset1.getString(17);
						 menarche_yn=rset1.getString(18)==null?"":rset1.getString(18);
						 height=rset1.getString(19)==null?"":rset1.getString(19);
						 weight=rset1.getString(20)==null?"":rset1.getString(20);
						 circumference=rset1.getString(21)==null?"":rset1.getString(21);
						 disaster_town_code=rset1.getString(22)==null?"":rset1.getString(22);
        				 lmp_date=rset1.getString(23)==null?"":rset1.getString(23);
						 pregnant_yn=rset1.getString(24)==null?"":rset1.getString(24);
		    			 mech_injury_subcatg_code=rset1.getString(25)==null?"":rset1.getString(25);
			             pat_priority=rset1.getString(26)==null?"":rset1.getString(26);
						 trauma_yn=rset1.getString(27)==null?"":rset1.getString(27);
						 
					 }
					 if(rset1!=null) rset1.close();
		             if(pstmt1!=null) pstmt1.close();
		 
				 if(emergency_yn.equals("Y")){
				
		                  checked="checked";
						  dis2 = disabled;
				 }
			     else
				
                          checked="";
						   
 	             if(!complaint_code.equals("")) dis3 = disabled;
				 if(!mech_injr_code.equals("")) dis6 = disabled;
                 if(!mech_injury_subcatg_code.equals("")) dis7 = disabled;
				 if(!vehicle_invlovedcode.equals("")) dis8 = disabled;
				 if(!vehicle_invlovedcode1.equals("")) dis9 = disabled;
	             if(!protective_device_code.equals("")) dis10 = disabled;
				 if(!pat_position_code.equals("")) dis11 = disabled;
				 if(!police_rep_no.equals("")) dis12 = disabled;
				 if(!police_station_dtls.equals("")) dis13 = disabled;
				 if(!height.equals("")) disHeight = disabled;
                 if(!weight.equals("")) disWeight = disabled;
                 if(!circumference.equals("")) disCir = disabled;


				 

				 if(disaster_yn.equals("Y"))

				   {
		                  checked1="checked";
						  disabled11="";
				    }
                 else
				   {
                          checked1="";
						  disabled11="disabled";
                   }
				 if(oscc_yn.equals("Y"))
	  {        
				 checked2="checked";
	          
	  			  disable3="disabled";
	  }                       
			     else
		
	  {checked2="";
	    
	  }        
                if(mlc_yn.equals("Y"))
				  {		
		                 checked3="checked";
						 disable2="disabled";
                  }
				else
				  {
                          checked3="";
						  disable2="";
                  }

                if(immunization_status.equals("F"))
	             {
				          selected="selected" ;
						  dis14 = disabled;
	             }
                else if(immunization_status.equals("P"))
	            {
                          selected1="selected" ;
						  dis14 = disabled;
                }
                else if(immunization_status.equals("U"))
	            {
                         selected2="selected" ;
						 dis14 = disabled;
                } 

                if(att_given.equals("Y"))
	            {
				         checked4="checked" ;
						 dis15 = disabled;
                }
			    else
	            { 
					      dis15 = "";
                         checked4="" ;
                }
				if(dev_mile_stone.equals("Y"))
	             {
				          checked5="checked" ;
						  disabled99="disabled";
						  disabled991="disabled";

                 }
				else
	            {
                          checked5="" ;	
						  disabled99="";
						  disabled991="";
                }
				if(imm_date.equals("Y")){
				          checked6="checked" ;
						  disImm = disabled;
				}

				else{
                          checked6="" ;	
						  disImm = "";
				}
				if(menarche_yn.equals("Y"))
				{	
				          checked7="checked" ;
						  checked8="checked";
						  disMenarche=disabled;
		        }
						  
			    else
				{
                          checked7="" ;	
						  checked8="" ;
						  disMenarche="";
						 
				}

			    if(pregnant_yn.equals("Y"))
	             {
				
				          checked8="checked" ;
						   disabledPre=disabled;
				
                 }
				  
			    else
	             {
				         
                          checked8="" ;
						  disabledPre="";
						   
                 }
              if(trauma_yn.equals("Y")){
				
				
				          checked9="checked" ;
						  dis5 = disabled;
			  }
			    else
	           {
                          checked9="" ;
						   dis5 = "";
               } 
			
            pstmt1 = con.prepareStatement(sqltreatment1);
			pstmt1.setString(1,encounter_id);
			rset1 = pstmt1.executeQuery();
					     while(rset1!=null && rset1.next())
					     {
                          
						 treat_code = rset1.getString(1)==null?"":rset1.getString(1); 
						 priority=rset1.getString(2)==null?"":rset1.getString(2); 
						
						 }
                          priorityStatus1="";
                          priorityStatus2="";
						  priorityStatus3="";
                          if (priority.equals("R"))
						  {   priorityStatus1="checked";
						      disabled12="disabled";
						      disabled13="disabled";
							  disPriority ="disabled";
								   
						  }
		                  else if (priority.equals("Y"))
						  {
							  priorityStatus2="checked";
						      disabled111="disabled";
						      disabled13="disabled";
							  disPriority ="disabled";
						   
						  }
		                  else if (priority.equals("G"))
						  {
							  priorityStatus3="checked";
						      disabled111="disabled";
						      disabled12="disabled";
							  disPriority ="";
                          
						  }
						  if(!bed_no.equals("")){
								  disTreatArea= "disabled";
						  }

      String sqlarea="select short_desc from mp_res_town where res_town_code='"+disaster_town_code+"'";
					   pstmt1 = con.prepareStatement(sqlarea);
					   rset1 = pstmt1.executeQuery();
					     while(rset1!=null && rset1.next())
					     {
                          
						 dis_area = rset1.getString(1);
	
						 }
						 if(rset1!=null) rset1.close();
						 if(pstmt1!=null) pstmt1.close();
					 



%>
<%
					   pstmt1 = con.prepareStatement(sqlAge);
					   pstmt1.setString(1,patient_id);
					   rset1 = pstmt1.executeQuery();
					   while(rset1!=null && rset1.next())
					   {
                             patient_age = rset1.getInt(1);
							 sex	=  rset1.getString(2)==null?"":rset1.getString(2);

					   } 
					    if(rset1!=null) rset1.close();
					    if(pstmt1!=null) pstmt1.close();
						
						
				/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	 
	           
	           sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E'";
				
			     pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,localeName) ;
			    rs2    = pstmt.executeQuery();
				while(rs2!=null && rs2.next())
				{
				  color      =rs2.getString("PRIORITY_ZONE");
				 if (color.equals("G")) {green=rs2.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("R")) {red=rs2.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("Y")) {yellow=rs2.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("U")) {unassigned=rs2.getString("PRIORITY_ZONE_DESC");}
				}
		    
	
			
			if(rs2!=null) rs2.close();
		    if(pstmt!=null) pstmt.close();
	
	/* CRF  SKR-CRF-0021 [IN028173] end  */
					  
%>

 <body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad='calculateNoOfDays();doDate1(this);enablePriorityZone();'>
<form name='AESecondaryTriage_form' id='AESecondaryTriage_form' action='../../servlet/eAE.AESecondaryTriageServlet' method='post' target='messageFrame' >
<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>

      <input type='hidden' name='sysdate' id='sysdate' value='<%=sqlDate%>'>
<tr>
		 <th align='left' colspan='6'><fmt:message key="Common.PatientCondition.label" bundle="${common_labels}"/></th>
     </tr>
		  <tr><td colspan=8 class=label height=5></td></tr>
      <tr><input type="hidden" name='hddpriority' id='hddpriority'value=<%=priority%>>
		      <td class='LABEL' width='5%'>&nbsp;</td>
              <td class='label' width='20%' align='right' nowrap><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/>&nbsp;
            <!--below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173]  -->			 
			 </td><td class='label' align=left width="15%" nowrap>&nbsp; <%=red%>
					<input type="checkbox" name='priorityR' id='priorityR'   value='R' onClick='setPriority(this);setTreatment(this);' <%=priorityStatus1%><%=disabled111%>><%=yellow%>
			 		<input type="checkbox" name='priorityY' id='priorityY'    onClick='setPriority(this);setTreatment(this);'<%=priorityStatus2%><%=disabled12%>><%=green%>
			 		<input type="checkbox" name='priorityG' id='priorityG' <%=priorityStatus3%> onClick='setPriority(this);setTreatment(this);'<%=disabled13%>>&nbsp;
					
              </td>
			  <!--CRF  SKR-CRF-0021 [IN028173] end-->
			  <td class='label' width='20%' align='right' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/> &nbsp;
			  </td>
             <td class='label' align='left' width='15%'>&nbsp;
				 <select name='priority11' id='priority11' tabindex='65' <%=disPriority%>>
					<option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

					</select>
			 <td class='LABEL' align='right' nowrap>&nbsp;
		     </td>
			</tr>
		<tr> 
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
			  <td class='LABEL' align='right' width='20%' nowrap><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
			  <td class='label' align='left' width='15%'>&nbsp;
				 <select name='treat_area' id='treat_area' tabindex='' <%=disTreatArea%>>
					<option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  </select>
              </td>

			   <td class='LABEL' align='right' width='5%' nowrap><fmt:message key="Common.Disaster.label" bundle="${common_labels}"/></td>
			 <td class='label'align='left' width='15%'>&nbsp;<input type="checkbox" name='Disaster_YN' id='Disaster_YN'  onClick='setDisaster(this)'<%=checked1%>>&nbsp;Area&nbsp;<input type='text'  name="disaster_area1" id="disaster_area1" value="<%=dis_area%>" maxLength='10' onblur='if(this.value !="")searchDisasterArea(this,disaster_area1);' tabindex='' <%=disabled11%>><input type='button' name='disaster' id='disaster' value='?' class='button' onclick='searchDisasterArea(this,disaster_area1);' <%=disabled11%> nowrap>
             </td>
               <td class='LABEL' align='right' width='5%' nowrap>&nbsp; 
			 <td ></td> 

		  </tr>
	 <tr>
		      <td class='label' width='5%'>&nbsp;</td> 
		      <td class='LABEL' align='right' width='20%' nowrap><fmt:message key="Common.ambulatorystatus.label" bundle="${common_labels}"/></td>
  		      <td class='LABEL' align='left' width='15%'>&nbsp;
				 <select name='ambulatory_status' id='ambulatory_status' tabindex='63' <%=dis1%>>
				  <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   <%
						   pstmt = con.prepareStatement(sqlAmbulatory);
					       rset = pstmt.executeQuery();
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(a_status))
							   {
                                    optSelected="selected";
									
									
									
							   }
							   else
							   {
								   optSelected="";
							      
							   }
							  
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
					   %>
                 </select>
              </td>
			
			 <td class='LABEL' align='right' width='5%'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></td>
			
			 <td class='label'align='left' width='25%'>&nbsp;<input type="checkbox" name='emergency' id='emergency'  onClick='setEmergency(this)'<%=checked%> <%=dis2%> >
			
             </td>
				 <td class='LABEL' align='left' width='25%'>
          </tr>
	      <tr> 
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
			  <td class='LABEL' align='right' width='20%' nowrap><fmt:message key="Common.Complaint.label" bundle="${common_labels}"/></td>
  		      <td class='LABEL' align='left' width='15%'>&nbsp;
				 <select name='symptom_val' id='symptom_val' tabindex='65' <%=dis3%>>
					<option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   <%
						   pstmt = con.prepareStatement(sqlComplaint);
					       rset = pstmt.executeQuery();
                             optSelected="";
						   while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(complaint_code))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
                           
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
					   %>
                 </select>
              </td>
              <td class='LABEL' align='right' width='5%'><fmt:message key="Common.patienttype.label" bundle="${common_labels}"/></td>
              <td class='LABEL' align='left' width='15%'>&nbsp;
			  <select name='patient_type' id='patient_type' tabindex='66' <%=dis4%>>
					<option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   <%
						   pstmt = con.prepareStatement(sqlPatType);
					       rset = pstmt.executeQuery();
						    optSelected="";
						   while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(p_type))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
					   %>
                 </select>
              </td>
			<td class='LABEL' align='left' width='25%'>&nbsp;  
		  </tr> 
		  
	<input type='hidden' name='injury_3' id='injury_3' value=''>
	<tr>
	   	  <th align='left' colspan='6'><fmt:message key="eCA.TraumaCaseDetail.label" bundle="${ca_labels}"/></th>
     </tr>
			  <tr>   <td class='label' width='5%'>&nbsp;</td>
			        <td class='label' align ='right'width='20%'><fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/></td>
			        <td class='LABEL' align='left'width='25%'>&nbsp;<input type='checkbox'  name="CaseofTrauma" id="CaseofTrauma"  onClick='checktrauma(this)' <%=checked9%> <%=dis5%>></td>
				<td></td><td></td><td></td>
			  </tr>
	 <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'nowrap><fmt:message key="Common.MechanismofInjury.label" bundle="${common_labels}"/></td>
  		       <td class='LABEL' align='left' width='15%'>&nbsp;
				 <select name='mechan_injury' id='mechan_injury' onChange='setInjury(this)' <%=dis6%>> 
				  <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   <%
						 String sqlMechaInjury = "SELECT INJ_CATEGORY_CODE,SHORT_DESC FROM                         "+"AE_INJURY_CATEGORY WHERE EFF_STATUS='E'                          ORDER BY 2";  
						 pstmt = con.prepareStatement(sqlMechaInjury);
					     rset = pstmt.executeQuery();
						 	 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(mech_injr_code))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
					   %>
                 </select>
              </td>
  		      <input type='hidden' name='mech_sub_code' id='mech_sub_code' value=<%=mech_injury_subcatg_code%> >
			  <td class='LABEL' align='left' width='25%'>&nbsp;
				<select name='injury' id='injury' tabindex='68' <%=dis7%>>
				  <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

				</select>
				<input type='hidden' name='patient_id' id='patient_id' value=<%=patient_id%>>
				<input type='hidden' name='called_from_ca' id='called_from_ca' value=<%=called_from_ca%>>
			
              </td>
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
			   <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td> 
	  </tr>
	  <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%' nowrap><fmt:message key="Common.VehiclesInvolved.label" bundle="${common_labels}"/></td>
  		      <td class='LABEL' align='left' width='15%'>&nbsp;
				 <select name='vehicle_invol' id='vehicle_invol' <%=dis8%>>
				  <option value='' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   <%
						 String sqlVehicleInv = "select ARRIVAL_CODE, ARRIVAL_LONG_DESC, ARRIVAL_SHORT_DESC from am_arrival_vw order by 2";  
						 pstmt = con.prepareStatement(sqlVehicleInv);
					     rset = pstmt.executeQuery();
						 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(vehicle_invlovedcode))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(3)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
					   %>
                 </select>
              </td>
  		      
			   <td class='LABEL' align='left' width='25%'>&nbsp;
				<select name='vehicle_invol1' id='vehicle_invol1' tabindex='68' <%=dis9%>>
				  <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<%
						 pstmt = con.prepareStatement(sqlVehicleInv);
					     rset = pstmt.executeQuery();
						 optSelected="";
						 while(rset!=null && rset.next())
						   {
							   if(rset.getString(1).equals(vehicle_invlovedcode1))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(3)+" ");
						   }
						 if(pstmt!=null) pstmt.close();
						 if(rset!=null) rset.close();
					   %>
				</select>
              </td> 			   
               <td class='label' width='5%'>&nbsp;</td>
			   <td class='label' width='5%'>&nbsp;</td>
	   </tr>
	   <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%' nowrap><fmt:message key="Common.ProtectiveDeviceUsed.label" bundle="${common_labels}"/></td>
  		      <td class='LABEL' align='left' width='15%'>&nbsp;
				 <select name='protective_device' id='protective_device' <%=dis10%>>
				   <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   <%
						   String sqlProtect = "SELECT PROTECTIVE_DEVICE_CODE, SHORT_DESC FROM "+				            "AE_PROTECTIVE_DEVICE WHERE EFF_STATUS ='E' ORDER BY 2";
						   pstmt = con.prepareStatement(sqlProtect);
					       rset = pstmt.executeQuery();
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							    if(rset.getString(1).equals(protective_device_code))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";

							   
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
					   %>
                 </select>
              </td>
  		      <td class='LABEL' align='right' width='5%'><fmt:message key="Common.PositionDuringIncident.label" bundle="${common_labels}"/></td>
			  <td class='LABEL' align='left' width='25%'>&nbsp;
				<select name='affected_site' id='affected_site' tabindex='' <%=dis11%>>
				  <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   <%
						   pstmt = con.prepareStatement(sqlPosition);
					       rset = pstmt.executeQuery();
						   optSelected="";
						   while(rset!=null && rset.next())
						   {
							  if(rset.getString(1).equals(pat_position_code))
							   {
                                    optSelected="selected";
															
							   }
							   else
								   optSelected="";
                              out.println("<option value='"+rset.getString(1)+"'"+optSelected+">"+rset.getString(2)+" ");
						   }
						   if(pstmt!=null) pstmt.close();
						   if(rset!=null) rset.close();
					   %>
                 </select>
              </td>
			  <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
	  <tr>
		 <th align='left' colspan='6'><fmt:message key="eCA.OSCCMLCCase.label" bundle="${ca_labels}"/></th>
      </tr>
	  <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%' nowrap><fmt:message key="Common.oscc.label" bundle="${common_labels}"/></td>
			  <td class='LABEL' align='LEFT' width='15%'>&nbsp; <input type='checkbox'  name="oscc_yn" id="oscc_yn"   value='' onClick='chkOsccValue(this);' tabindex=''<%=checked2%> <%=disable3%>>
              </td>
		     <td class='LABEL' align='right' width='5%'><fmt:message key="Common.PoliceReportNo.label" bundle="${common_labels}"/></td>
  		      <td class='LABEL' align='left' width='10%' size='20'>&nbsp;
				   <input type='text'  name='police_rep_no1' id='police_rep_no1'   maxLength='20' size='20' tabindex=''value="<%=police_rep_no%>" <%=disable2%> <%=dis12%>>
		      </td>
			
              <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
      <tr>	
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%' nowrap><fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td>
			  <td class='LABEL' align='LEFT' width='15%'>&nbsp;
			    
			  <input type='checkbox'  name="mlc_case_yn" id="mlc_case_yn" <%=disable2%> onclick='chkMlcValue(this)'  tabindex=' ' <%=checked3%> >
              </td>
		     <td class='LABEL' align='right' width='5%'><fmt:message key="Common.PoliceStationDetails.label" bundle="${common_labels}"/></td>
  		      <td class='LABEL' align='left' width='10%' size='20'>&nbsp;
				   <input type='text'  name="police_stat_detail" id="police_stat_detail"  maxLength='30' size='30' tabindex='' value='<%=police_station_dtls%>' <%=disable2%> <%=dis13%>>
		      </td>
			
              <td class='LABEL' align='RIGHT' width='5%'>&nbsp;</td>
	  </tr>
	  
	 <table table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
	 <tr> 
		 <th align='left' colspan='7'><fmt:message key="Common.ATTImmunization Details.label" bundle="${common_labels}"/></th>
     </tr>
	 <tr>				 
		    <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='17%' nowrap><fmt:message key="Common.ImmunizationStatus.label" bundle="${common_labels}"/></td>
  		       <td class='LABEL' align='left' width='15%'>&nbsp;
				 <select name='immunization_stat' id='immunization_stat' onChange='' <%=dis14%>>
					       <Option value=''>&nbsp;------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;</Option>
                           <Option value='F'<%=selected%> ><fmt:message key="Common.FullyImmunized.label" bundle="${common_labels}"/></option>
                           <Option value='P'<%=selected1%>  ><fmt:message key="Common.PartiallyImmunized.label" bundle="${common_labels}"/></option>
                           <Option value='U'<%=selected2%>  ><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
				 </select>
              </td>
  		     <td class='LABEL' align='right' width='28%'><fmt:message key="Common.ATTGiven.label" bundle="${common_labels}"/>&nbsp;</td>
			  	 <td class='LABEL' align='LEFT' width='28%'colspan='2'><input type='checkbox'  name="att_given" id="att_given"   value=''  tabindex=''<%=checked4%> <%=dis15%>>
				 </td>
				 <td class='LABEL' align='RIGHT' width='25%'>&nbsp;</td>
	 </tr>
	 </table>
	<% if (patient_age <= max_age_paediatric){
	   pediatric_status = "true";	   
	%>
	 <tr width="90%">
      <table  border="0" cellpadding="0" cellspacing="0" align='center' colspan=12 width="100%">
       <tr> 
		 <th align='left' colspan='8'><fmt:message key="Common.PediatricDetail.label" bundle="${common_labels}"/></th>
       </tr>
	   <tr width="90%">	
         <td class='LABEL' align='RIGHT' width="20%" nowrap><fmt:message key="Common.Growth/DevelMilestoneAge.label" bundle="${common_labels}"/></td>
  		 <td class='LABEL' align='left' width="5%">&nbsp;<input type='checkbox'  name="growth_age" id="growth_age"  <%=checked5%> onclick='chkhwc(event);' <%=disabled991%> <%=disabled99%>></td>
		 <td class='LABEL' align='RIGHT' width="25%"><fmt:message key="Common.Immunizationuptodate.label" bundle="${common_labels}"/></td>
		 <td width="15%">&nbsp;
		 <input type='checkbox' align='left' name="immun_date" id="immun_date"    <%=checked6%> <%=disImm%> >
         </td>
 		 <td class='LABEL' align='RIGHT' width="15%"><fmt:message key="Common.Menarche.label" bundle="${common_labels}"/></td>
		 <td width="15%" >&nbsp;<input type='checkbox'  name="menarche" id="menarche"    onclick='checkmenstrual(this);' <%=checked7%> <%=disMenarche%>></td>
		 <td class='LABEL' align='left' ></td>
		 <td class='LABEL' align='left' ></td>
         
	   </tr>
        <tr colspan=8 width="90%">	
         <td class='LABEL' align='right' ><fmt:message key="Common.height.label" bundle="${common_labels}"/></td>
  		 <td class='LABEL' align='left' >&nbsp;&nbsp;<input type='text'  name="height" id="height"<%=disHeight%> id='height'size="5" maxlength='6' value="<%=height%>"onKeyPress='return( allowValidNumber(this,event,3,2)); return(ChkNumberInput(this,event,0)); '
		 onBlur='SPCheckPositiveNumber(this);'>Cm</td>
		 <td class='LABEL' align='right' ><fmt:message key="Common.weight.label" bundle="${common_labels}"/></td>
  		 <td class='LABEL' align='left'>&nbsp;&nbsp;&nbsp;<input type='text'  name="weight" id="weight" size="5" maxlength='7' value="<%=weight%>" onKeyPress='return( allowValidNumber(this,event,2,3));return(ChkNumberInput(this,event,0))'
		 onBlur='SPCheckPositiveNumber(this);'<%=disWeight%>>Kg</td>
 		 <td class='LABEL' align='right' ><fmt:message key="Common.Circumference.label" bundle="${common_labels}"/></td>
  		 <td class='LABEL' align='left' >&nbsp;&nbsp;<input type='text'  name="circumference" id="circumference" size="5" maxlength='6'value="<%=circumference%>"onKeyPress='return( allowValidNumber(this,event,3,2));return(ChkNumberInput(this,event,0))'onBlur='SPCheckPositiveNumber(this);'<%=disCir%>>Cm</td>
 		 <td class='LABEL' align='right' ></td>
  		 <td class='LABEL' align='left' ></td>
	  </tr>      
   </tr>
 </table>
    <% } else{
			
			  disabled="";
		}%>
 

<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
	 <% if (sex.equalsIgnoreCase("F") && (patient_age >= min_age_pregnancy)) {
	 // && (patient_age<12)) { 
		 menstrual_status = "true";
	  %>
     <tr> 
		 <th align='left' colspan='6'><fmt:message key="Common.MenstrualHistory.label" bundle="${common_labels}"/></th>
     </tr>
		 
     <tr>				 
		    <td class='LABEL' align='RIGHT' width='21%' colspan='1'><fmt:message key="Common.PregnantatPresent.label" bundle="${common_labels}"/>&nbsp;</td>

            <td class='LABEL' align='left'width='3%'>
	         <input type='checkbox'  name="pregnant_at_present_yn_val" id="pregnant_at_present_yn_val" <%=checked8%> onClick='checkmenstrual(this); checkPregnant(this);' <%=disabledPre%>></td>
			<td class='LABEL' ></td>
				
			<td class='LABEL' align='right' width='42%' size='20'nowrap>&nbsp;LMP Date&nbsp;&nbsp;<input type="text" name="lmp_date" id="lmp_date" disabled id="lmpdate" maxlength="10" size="8"  onblur='makeValidString(this);doDate1(this); checkPregnantDate(this);calculateNoOfDays();' value = "<%=lmp_date%>" ><input type='image' src='../../eCommon/images/CommonCalendar.gif' name="lmp_calendar" id="lmp_calendar" onClick="document.forms[0].lmp_date.focus();return showCalendar('lmpdate');" disabled >&nbsp;</td>
			<td class='LABEL' ><img src='../../eCommon/images/mandatory.gif' id='mand2' style="visibility:hidden" align='center'></img></td> 
				  
          	<td class='LABEL' align='left' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.POA.label" bundle="${common_labels}"/>
   		       &nbsp;
		       <b><font name="weekVal" id='nmdesig' class='label'><b></font>&nbsp;Weeks&nbsp;
		       <font id='nmdesig1' class='label'><b></font>&nbsp;Days
		    </td>	
	</tr> 

		 </table>
       <% } %> 

</table>
<table border="0" cellpadding="0" cellspacing="0" align='center' colspan=3 width="100%">
<tr><td colspan=3 class = 'BODYCOLORFILLED'align=right>&nbsp;</td>
</tr>
<tr>
<td colspan='3' class='BODYCOLORFILLED' align="right">
<input type=button name='Close' id='Close' value=" Close "  onClick='close_func()'  class='Button' >

</td>
</tr>
</table>
		
<input type='hidden' name=hdddob value=<%=date_of_birth%>>
<input type='hidden' name='bed_no' id='bed_no' value='<%=bed_no%>'>
<input type='hidden' name=encounter_id value=<%=encounter_id%>>

<input type='hidden' name='treat_code' id='treat_code' value='<%=treat_code%>'>

<input type='hidden' name=menstrual_status value=<%=menstrual_status%>>
<input type='hidden' name=pediatric_status value=<%=pediatric_status%>>
<input type='hidden' name="mech_injr_subcat_code" id="mech_injr_subcat_code" value="<%=mech_injr_subcat_code%>">
<input type='hidden'  id='regndatetime' name="visit_date_time" id="visit_date_time"  value='<%=visit_date%>'>
<input type='hidden' name=facility_id value=<%=facilityId%>>
<input type='hidden' name=clinic_code value=<%=clinic_code%>>
<input type='hidden' name=priority_zone value=<%=priority%>>
<input type='hidden' name=brought_dead value=<%=brought_dead%>>
<input type='hidden' name=pat_priority value=<%=pat_priority%>>
<input type='hidden' name='CaseofTrauma_val' id='CaseofTrauma_val' value=''>
<input type='hidden' name='disaster_area' id='disaster_area' value='<%=disaster_town_code%>'>
	
	<input type='hidden' name='gender' id='gender' value='<%=sex%>'>


</form>
<% }catch(Exception e){ 
			//out.println("Exception in AESecondaryTriageDetail.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	finally {
			 try{
			       if(rs!=null) { rs.close(); rs = null; } 
				   if(rset!=null) { rset.close(); rset = null; } 
				   if(rset1!=null) { rset1.close(); rset1 = null; } 
				   if(rs_date!=null) { rs_date.close(); rs_date = null; } 
				   if(rs_priority!=null) { rs_priority.close(); rs_priority = null; } 

				   
 				   if(pstmt!=null) { pstmt.close(); pstmt = null;}
				   if(pstmt1!=null) { pstmt1.close(); pstmt1 = null;}
				   if(pstmt_date!=null) { pstmt_date.close(); pstmt_date = null;}
                   if(pstmt_priority!=null) { pstmt_priority.close(); pstmt_priority = null;}
		           if(con!=null) ConnectionManager.returnConnection(con,request);  
			     }
		         catch(Exception e){ 
					 //out.println("Exception in AESecondaryTriageDetail.jsp"+e.toString()); //COMMON-ICN-0181
					 e.printStackTrace();//COMMON-ICN-0181
				} 
		    }
	%>
<script>
/* code for populating values onload in treatmentarea and mechanical injury sub category list boxes*/
setInjury(document.forms[0].mechan_injury);
window.setTimeout('setTreatment(document.forms[0].priority_zone)',200);


</script>
</body>
</html>

