<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
  <script src='../../eCommon/js/common.js' language='javascript'></script>

 <%
		Connection con		      =  null;
		ResultSet rs 		      = null;
		ResultSet rs1 		      = null;
		PreparedStatement pstmt   = null; 
		PreparedStatement pstmt1   = null;
		ResultSet rset				= null; 
	    java.sql.Statement stmt		= null; 

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
	    String locale			= (String)session.getAttribute("LOCALE");

		/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		String RepDb		= checkForNull(request.getParameter("repDb"));
		String facilityId	= checkForNull(request.getParameter("facility_id"));
		String sqlFinal		= "";
		/*End*/

		int chkflag = 0;  
        if(facilityId.equals(""))//Added by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			facilityId 	     = checkForNull((String) session.getValue( "facility_id" )) ;
		String clinic_code	     = checkForNull(request.getParameter("clinic_code"));
		String service_code      = checkForNull(request.getParameter("service_code"));
		String transport_mode    = checkForNull(request.getParameter("transport_mode"));
		String serviceflag       = checkForNull(request.getParameter("serviceflag"));
		String visitflag         = checkForNull(request.getParameter("visitflag"));
		String subserviceflag    = checkForNull(request.getParameter("subserviceflag"));
		String transportflag     = checkForNull(request.getParameter("transportflag"));
		String treatmentflag     = checkForNull(request.getParameter("treatmentflag"));
		String gender			 = checkForNull(request.getParameter("gender"));	
        String treatmentflag1    = checkForNull(request.getParameter("treatmentflag1"));
		String patient_id        = checkForNull(request.getParameter("patient_id"));
		String preVisitFlag      = checkForNull(request.getParameter("preVisitFlag"));
		String priority          = checkForNull(request.getParameter("priority"));
		String occ_classFlag     = checkForNull(request.getParameter("occ_classFlag"));
		String occ_class         = checkForNull(request.getParameter("occ_class"));
		String mechaInjflag      = checkForNull(request.getParameter("mechaInjflag"));
		String mech_injr_subcat_code      = checkForNull(request.getParameter("mech_injr_subcat_code"));
        String category          = checkForNull(request.getParameter("category"));
		String mechaInjflagNew   =checkForNull(request.getParameter("mechaInjflagNew"));
		
		String called_function   =checkForNull(request.getParameter("called_function"));	/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
		
		String oscc_yn			 =checkForNull(request.getParameter("oscc_yn"));
		String treat_code        = checkForNull(request.getParameter("treat_code"));
		String pat_priority      = checkForNull(request.getParameter("pat_priority"));
		String patValidflag      = checkForNull(request.getParameter("patValidflag"));
        String from_rev          = checkForNull(request.getParameter("from_rev"));
		String func_source       = checkForNull(request.getParameter("func_source"));
		String to_service_code       = checkForNull(request.getParameter("referal_service"));
		session.putValue("queryString",func_source);
		String serviceflag1      = checkForNull(request.getParameter("serviceflag1"));
		String priorityzone = checkForNull(request.getParameter("priorityzone"));
		
		String NatIdFlag                 = checkForNull(request.getParameter("NatIdFlag"));
		String Nat_Id                    = checkForNull(request.getParameter("Nat_Id"));
		String nat_id_check_digit_id     = checkForNull(request.getParameter("nat_id_check_digit_id"));
		String nat_id_prompt             = checkForNull(request.getParameter("nat_id_prompt"));
		String Nat_IdName                = checkForNull(request.getParameter("Nat_IdName"));
		String CalledFrom                = checkForNull(request.getParameter("CalledFrom"));
		/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 3rd 2014 Start*/
		String five_level_triage_appl_yn = checkForNull(request.getParameter("five_level_triage_appl_yn"),"N");
		String p_zone_order_no_new		 = checkForNull(request.getParameter("p_zone_order_no_new"),"1");
		/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 3rd 2014 End*/
		
		//Below line added for this CRF ML-MMOH-CRF-0654
		String mode_of_arrival = checkForNull(request.getParameter("mode_of_arrival"));
		String modify_flag     = checkForNull(request.getParameter("modify_flag"),"N");
		String transportmodeflag  = checkForNull(request.getParameter("transportmodeflag")); //Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17

		/*Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
		String frameRef				= checkForNull(request.getParameter("frameRef"),"top.content");
		String invoke_from			= checkForNull(request.getParameter("invoke_from"));
		/*Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/

		//End this CRF ML-MMOH-CRF-0654	
		
		String isAERegisterTypeAutoUpdateAppl = checkForNull(request.getParameter("isAERegisterTypeAutoUpdateAppl")); // added by mujafar for KDAH-CRF-0526
		String dflt_emer_follow_type_code = checkForNull(request.getParameter("dflt_emer_follow_type_code"));
		String dflt_time_reg_auto_update = checkForNull(request.getParameter("dflt_time_reg_auto_update"));
	
		double prev_visit_hrs =0d;
		String shortDesc		 = "";
	    String arrival_code      = "",			priority_no		 = "";
		String area_code         = "",			code 		     = "";
		String inj_sub			 = "";	
		String secondaryTriFlag  = checkForNull(request.getParameter("secondaryTriFlag"));
		String referral_id       = checkForNull(request.getParameter("referral_id"));		
		int    count			 = 0;	
		int countRec1			 = 0,			countRecTreat    = 0;
        int countRef = 0;
		StringBuffer sqlVisit         = null;
		StringBuffer sqlVisit1        = null;
		StringBuffer sqlService       = null;
		StringBuffer sqlSubServ       = null;
		StringBuffer sqlTreat		  = null;
		StringBuffer sqlTrans		  = null;
		StringBuffer sqlTreatF1       = null;
		StringBuffer sqlTreatF2       = null;
		StringBuffer sqlOcc           = null;
		StringBuffer sqlMechInj       = null;
		StringBuffer sqlMechInj1      = null;
		StringBuffer sqlPatValid      = null;
		StringBuffer sqlService1      = null;
		StringBuffer sqlServiceP      = null;
		String visit_status			   ="";
if(CalledFrom.equals("register_atten"))
{
	visit_status                 = checkForNull(request.getParameter("visit_status"));
	String prev_visit_hr                = checkForNull(request.getParameter("prev_visit_hrs"),"0.0");
	//String prev_visit_hr                = checkForNull(request.getParameter("prev_visit_hrs"));
	prev_visit_hrs = Double.parseDouble(prev_visit_hr);
}



	%>
	
	<html>
	<head>
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<!--Added by Dharma on Aug 22nd 2017 against ML-MMOH-CRF-0631 [IN:062148] Start-->
	<script  language='javascript'>
		var frameRef	= eval("<%=frameRef%>");
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<!--Added by Dharma on Aug 22nd 2017 against ML-MMOH-CRF-0631 [IN:062148] End-->
	</head>
	<BODY class='message' onKeyDown = 'lockKey()'>
	<form>
	<%
	try
	{
	   con					      = ConnectionManager.getConnection(request);
	


	   if(serviceflag1!=null)
		{		  
		    if(serviceflag1.equals("Y"))
			{
			  String func ="&../../eCommon/jsp/commonToolbar.jsp?menu_id=AE&module_id=AE&function_id=AE_QRY_PAT_HISTORY&function_name=Patient AE History&function_type=F&access=NNNNN";
			  session.putValue("queryString",func);
			  sqlService1 = new StringBuffer();
              sqlService1.append("SELECT B.SERVICE_CODE, AM_GET_DESC.AM_SERVICE ##REPDB##(A.SERVICE_CODE,'"+locale+"','2') SHORT_DESC FROM   AM_FACILITY_SERVICE ##REPDB## A,   OP_CLINIC_FOR_SERVICE ##REPDB## B WHERE   B.FACILITY_ID= ?  AND B.CLINIC_CODE =  ?   AND A.OPERATING_FACILITY_ID = B.FACILITY_ID   AND A.SERVICE_CODE = B.SERVICE_CODE UNION   SELECT SERVICE_CODE, AM_GET_DESC.AM_SERVICE ##REPDB##(SERVICE_CODE,'"+locale+"','2') SHORT_DESC FROM OP_CLINIC ##REPDB## WHERE FACILITY_ID= ? AND CLINIC_CODE= ? ORDER BY 2  ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

			  /*Added by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1 Start*/
		      sqlFinal = sqlService1.toString();
			  sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			  /*End*/
			  pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			  pstmt.setString(1, facilityId);
			  pstmt.setString(2, clinic_code);
			  pstmt.setString(3, facilityId);
			  pstmt.setString(4, clinic_code);

		      rs		 = pstmt.executeQuery();
	 	      while(rs!=null && rs.next())
			  {		
				code			= rs.getString(1);
				shortDesc		= rs.getString(2);
			  %>
		        <script>

				   //	var opt1	= top.content.frames[1].document.createElement("OPTION");
				   	var opt1	= frameRef.frames[1].document.createElement("OPTION");//Modified by Dharma on Aug 14th 2017 against ML-MMOH-CRF-0631 [IN:062148] 
					opt1.text	= "<%=shortDesc%>";
			     	opt1.value	= "<%=code%>";
					//top.content.frames[1].document.forms[0].ae_pat_history_service.add(opt1);
					frameRef.frames[1].document.forms[0].ae_pat_history_service.add(opt1);//Modified by Dharma on Aug 14th 2017 against ML-MMOH-CRF-0631 [IN:062148] 
	  	        </script>	
	<%	      }//End of while	
              if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlService1 != null) && (sqlService1.length() > 0))
			  {
				sqlService1.delete(0,sqlService1.length());
			  } 
		  }
		} 

       if(visitflag!=null)
		{		   
		  if(visitflag.equals("Y"))
			{	
			 try{
				    sqlVisit = new StringBuffer();
                    sqlVisit.append("SELECT COUNT(*) FROM OP_VISIT_TYPE_FOR_CLINIC ##REPDB## ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
					sqlVisit.append("WHERE  FACILITY_ID = ?  AND CLINIC_CODE= ? ");
					/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				    sqlFinal = sqlVisit.toString();
				    sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				    /*End*/
					pstmt1   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
                    pstmt1.setString(1, facilityId);
					pstmt1.setString(2, clinic_code);
					rs1		 = pstmt1.executeQuery(); 
					if(rs1!=null)
					{
						while(rs1.next())
							{
								count=rs1.getInt(1);
							}
					}
					if(pstmt1!=null) pstmt1.close();
		            if(rs1!=null) rs1.close(); 
					if((sqlVisit != null) && (sqlVisit.length() > 0))
					  {
						sqlVisit.delete(0,sqlVisit.length());
					  } 
                 if (count >= 1)
                 {
					String temp_val1="";
					sqlVisit1 = new StringBuffer();
                    sqlVisit1.append("select a.VISIT_TYPE_CODE, OP_GET_DESC.OP_VISIT_TYPE ##REPDB##(a.FACILITY_ID,a.VISIT_TYPE_CODE,'"+locale+"','2') VISIT_TYPE_SHORT_DESC  from     OP_VISIT_TYPE_FOR_CLINIC ##REPDB## A, OP_VISIT_TYPE ##REPDB## B where A.FACILITY_ID=B.FACILITY_ID AND A.VISIT_TYPE_CODE=B.VISIT_TYPE_CODE AND B.visit_type_ind=?  and A.eff_status='E' and a.clinic_code= ?  AND A.facility_id=? ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
					
					/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				    sqlFinal = sqlVisit1.toString();
				    sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				    /*End*/
					pstmt=con.prepareStatement(sqlFinal,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
					
					
					
					if(isAERegisterTypeAutoUpdateAppl.equals("true") && !dflt_time_reg_auto_update.equals("0") && !dflt_emer_follow_type_code.equals(""))
					{ //added by mujafar for KDAH-CRF-0526
						String temp_val = eAE.AECommonBean.getAEfollowupType(con,facilityId,patient_id,dflt_time_reg_auto_update,clinic_code);
						temp_val1 = temp_val;
						if(temp_val.equals("W")){
						pstmt.setString(1, "W");
						}
						else
						{
						pstmt.setString(1, "E");
						}
					}
					else
					{ 
					pstmt.setString(1, "E");
					}
					
				
				    pstmt.setString(2, clinic_code);
				    pstmt.setString(3, facilityId);
					rs		 = pstmt.executeQuery(); 
					
                    if(rs != null)
				           {
				              rs.last();
			                  countRec1 = rs.getRow();
                              rs.beforeFirst();
					       }
				   while(rs!=null && rs.next())
			           {
				          code			= rs.getString(1);
				          shortDesc		= rs.getString(2);
				 %>
		          <script>
		          	var opt		= parent.frames[1].frames[2].document.createElement("OPTION");
			     	opt.text	= "<%=shortDesc%>";
				   	opt.value	= "<%=code%>";
					if("<%=countRec1%>"==1)
                      opt.selected = true;
				  <%if(countRec1 == 1 )
				  {
					if(isAERegisterTypeAutoUpdateAppl.equals("true"))
					{
						
						if(!temp_val1.equals("W"))
						{%>
							opt.selected = true;
						<%}
						
					}
					else
					{%>
						opt.selected = true;
						
					<%}

						
				  }
				  %>
				  
				  
				 <% if(code.equals(dflt_emer_follow_type_code)&& isAERegisterTypeAutoUpdateAppl.equals("true")){ //added by mujafar for KDAH-CRF-0526
					 %>
					  opt.selected = true;
				 <%}%>
					
					parent.frames[1].frames[2].document.forms[0].visit_type.add(opt);
				
	              </script>	
	<%	        } //End of while	    
			 }
           if(pstmt!=null) pstmt.close();
	       if(rs!=null) rs.close(); 
		   if((sqlVisit1 != null) && (sqlVisit1.length() > 0))
			  {
				sqlVisit1.delete(0,sqlVisit1.length());
			  } 
		 }catch(Exception e){e.printStackTrace();}
	  }
	}
	if(serviceflag!=null)
		{
		  if(serviceflag.equals("Y"))
			{	
			  sqlService = new StringBuffer();
			  

              sqlService.append("SELECT B.SERVICE_CODE, AM_GET_DESC.AM_SERVICE ##REPDB##(A.SERVICE_CODE,'"+locale+"','2') SHORT_DESC FROM   AM_FACILITY_SERVICE ##REPDB## A,   OP_CLINIC_FOR_SERVICE ##REPDB## B WHERE   B.FACILITY_ID= ?  AND B.CLINIC_CODE =  ?   AND A.OPERATING_FACILITY_ID = B.FACILITY_ID   AND A.SERVICE_CODE = B.SERVICE_CODE UNION   SELECT SERVICE_CODE, AM_GET_DESC.AM_SERVICE ##REPDB##(SERVICE_CODE,'"+locale+"','2') SHORT_DESC FROM OP_CLINIC ##REPDB## WHERE FACILITY_ID= ? AND CLINIC_CODE= ? ORDER BY 2 ");

			  /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
			  sqlFinal = sqlService.toString();
		      sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			  /*End*/

			  
			  pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			  pstmt.setString(1, facilityId);
			  pstmt.setString(2, clinic_code);
			  pstmt.setString(3, facilityId);
			  pstmt.setString(4, clinic_code);

		      rs		 = pstmt.executeQuery();
			  int countSub = 1;
	 	      while(rs!=null && rs.next())
			  {		
				if (countSub==1)
                  service_code = rs.getString(1);

				code			= rs.getString(1);
				shortDesc		= rs.getString(2);
				countSub++ ;
		       %>
		        <script>				  
				   	//var opt1	= top.content.frames[1].frames[2].document.createElement("OPTION");
				   	var opt1	= frameRef.frames[1].frames[2].document.createElement("OPTION");//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] 
			     	opt1.text	= "<%=shortDesc%>";
			     	opt1.value	= "<%=code%>";
					<%if(!to_service_code.equals("")){if(to_service_code.equals(code)){%>
					opt1.selected=true;
					//top.content.frames[1].frames[2].document.forms[0].service.add(opt1);
					frameRef.frames[1].frames[2].document.forms[0].service.add(opt1);//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] 
					<%}else{%>
					//top.content.frames[1].frames[2].document.forms[0].service.add(opt1);
					frameRef.frames[1].frames[2].document.forms[0].service.add(opt1);//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] 
					<%}
					}else{%>
					//top.content.frames[1].frames[2].document.forms[0].service.add(opt1);
					frameRef.frames[1].frames[2].document.forms[0].service.add(opt1);//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] 
					<%}%>
					
	  	        </script>	
	<%	      }//End of while	
              subserviceflag = "Y"; 
              if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlService != null) && (sqlService.length() > 0))
			  {
				sqlService.delete(0,sqlService.length());
			  } 
		  }
			
		} 
				//Priority populate start
	   if(priorityzone != null)
		{
		  	  sqlServiceP = new StringBuffer();
			 
              sqlServiceP.append( "select PRIORITY_CODE,SHORT_DESC  from ae_pat_priority_lang_vw ##REPDB## where language_id='"+locale+"' and PRIORITY_ZONE=? and EFF_STATUS='E'"); //Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			   
			  /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
			  sqlFinal = sqlServiceP.toString();
			  sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			  /*End*/
			  
			  pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			  pstmt.setString(1, priorityzone);
		      rs		 = pstmt.executeQuery();
	 	      while(rs!=null && rs.next())
			  {		
				code			= rs.getString(1);
				shortDesc		= rs.getString(2);
			    %>
				   <script>
				   /*Below Condition Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014*/
				  // if(top.content.frames[1].frames[2].document.forms[0].priority11!=null){//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] 
				   if(frameRef.frames[1].frames[2].document.forms[0].priority11!=null){//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] 
					   //	var optp	= top.content.frames[1].frames[2].document.createElement("OPTION");
					   	var optp	= frameRef.frames[1].frames[2].document.createElement("OPTION");//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] 
				     	optp.text	= "<%=shortDesc%>";
				     	optp.value	= "<%=code%>";
						//top.content.frames[1].frames[2].document.forms[0].priority11.add(optp);
						 frameRef.frames[1].frames[2].document.forms[0].priority11.add(optp);//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] 
				   }
	  	        </script>	
   	   			
			<%	 }//End of while	
              if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlServiceP != null) && (sqlServiceP.length() > 0))
			  {
				sqlServiceP.delete(0,sqlServiceP.length());
			  } 
		  } 
		//Priority populate start
		if(subserviceflag!=null)
		{
		  if(subserviceflag.equals("Y"))
			{
              sqlSubServ    = new StringBuffer ();
			  
			  sqlSubServ.append("SELECT AM_GET_DESC.AM_SUBSERVICE ##REPDB##(service_code,subservice_code,'"+locale+"','2') short_desc, SUBSERVICE_CODE FROM  am_facility_subsrvc ##REPDB##  WHERE  operating_facility_id = ? AND service_code = ? ORDER BY 1 ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

			  /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
			  sqlFinal = sqlSubServ.toString();
			  sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			  /*End*/
			  pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			  pstmt.setString(1, facilityId);
			  pstmt.setString(2, service_code);

			  rs	  = pstmt.executeQuery(); 
              
		      while(rs!=null && rs.next())
			  {	
				code			= rs.getString(2);
				shortDesc		= rs.getString(1);
	          %>
		       <script>
		          //  var opt2 = top.content.frames[1].frames[2].document.createElement("OPTION");
		            var opt2 =  frameRef.frames[1].frames[2].document.createElement("OPTION");//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] 
			     	opt2.text	= "<%=shortDesc%>";
			     	opt2.value	= "<%=code%>";
					//top.content.frames[1].frames[2].document.forms[0].sub_service.add(opt2);
					 frameRef.frames[1].frames[2].document.forms[0].sub_service.add(opt2);//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] 
	    	   </script>	
	       <% } 
			  if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlSubServ != null) && (sqlSubServ.length() > 0))
			  {
				sqlSubServ.delete(0,sqlSubServ.length());
			  } 
		  }
		}
		if(transportflag!=null)
		{
		 if(transportflag.equals("Y"))
			{
			  sqlTrans    = new StringBuffer();
			  
              sqlTrans.append("SELECT ARRIVAL_CODE,SHORT_DESC FROM  AM_ARRIVAL_LANG_VW ##REPDB## WHERE language_id='"+locale+"' and EFF_STATUS='E'  AND FACILITY_ID= ?  AND TRANSPORT_MODE = ? ORDER BY 2  ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

			  /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
			  sqlFinal = sqlTrans.toString();
			  sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			  /*End*/
			  pstmt  = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			  pstmt.setString(1, facilityId);
			  pstmt.setString(2, transport_mode);

			  rs	 = pstmt.executeQuery(); 
		      while(rs!=null && rs.next())
		      {	
			    arrival_code    = rs.getString(1);
				shortDesc		= rs.getString(2);
			   %>
	    	   <script>
		           // var opt3 = top.content.frames[1].frames[2].document.createElement("OPTION");
		            var opt3 = frameRef.frames[1].frames[2].document.createElement("OPTION");//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] 
			     	opt3.text	= "<%=shortDesc%>";
			     	opt3.value	= "<%=arrival_code%>";
					//top.content.frames[1].frames[2].document.forms[0].mode_of_arrival.add(opt3);
					frameRef.frames[1].frames[2].document.forms[0].mode_of_arrival.add(opt3);//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] 
	  	       </script>	
	     <%	  } 
			  if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlTrans != null) && (sqlTrans.length() > 0))
			  {
				sqlTrans.delete(0,sqlTrans.length());
			  } 
		   }
		}
	if(treatmentflag!=null)
		{
		 if(treatmentflag.equals("Y"))
			{
			 sqlTreat   = new StringBuffer();
			 
             sqlTreat.append("select treatment_area_code, short_desc treatment_area_desc from ae_tmt_area_for_clinic_lang_vw ##REPDB## where language_id='"+locale+"' and facility_id = ?  and CLINIC_CODE = ? AND PRIORITY_ZONE=  ? and (gender = ?  OR gender IS NULL)   and eff_status = 'E'  order by 2 ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

			 /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		     sqlFinal = sqlTreat.toString();
			 sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			 /*End*/
			 
			 pstmt      = con.prepareStatement(sqlFinal,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
             pstmt.setString(1, facilityId);
			 pstmt.setString(2, clinic_code);
             pstmt.setString(3, priority);
			 pstmt.setString(4, gender);

			 rs		 = pstmt.executeQuery();
			    if(rs != null)
				  {
				              rs.last();
			                  countRecTreat = rs.getRow();
                              rs.beforeFirst();
				  }

		      while(rs!=null && rs.next())
			  {	
					area_code        = rs.getString(1); 
				    shortDesc		 = rs.getString(2);
                    %>
		            <script>
		            /*Below Condition Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014*/
		            //if(top.content.frames[1].frames[2].document.forms[0].treat_area!=null){
		            if(frameRef.frames[1].frames[2].document.forms[0].treat_area!=null){//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148]
			             // var opt4 = top.content.frames[1].frames[2].document.createElement("OPTION");
			              var opt4 = frameRef.frames[1].frames[2].document.createElement("OPTION");//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148]
				     	      opt4.text	    = "<%=shortDesc%>";
				     	      opt4.value	= "<%=area_code%>";
						  if("<%=countRecTreat%>"==1)
					      {
	                        opt4.selected = true;
							/*top.content.frames[1].frames[2].document.forms[0].bed_bay_no.value = "";
				            top.content.frames[1].frames[2].document.forms[0].bed_bay_no.disabled = false;
				            top.content.frames[1].frames[2].document.forms[0].bed_button.disabled = false;*/
							frameRef.frames[1].frames[2].document.forms[0].bed_bay_no.value = "";
				            frameRef.frames[1].frames[2].document.forms[0].bed_bay_no.disabled = false;
				            frameRef.frames[1].frames[2].document.forms[0].bed_button.disabled = false;

							/*Added by Rameswar on 10-Feb-16 for GDOH-CRF-081*/
							//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] Start
							/*if(top.content.frames[1].frames[2].document.forms[0].isPracApplicable.value=="true"){
								top.content.frames[1].frames[2].document.forms[0].pract_button.disabled = false;
								top.content.frames[1].frames[2].document.forms[0].practitioner_desc.disabled = false;
								top.content.frames[1].frames[2].document.forms[0].pract_mand_img.style.visibility	=	'visible';
							}*/

							if(frameRef.frames[1].frames[2].document.forms[0].isPracApplicable.value=="true"){
								frameRef.frames[1].frames[2].document.forms[0].pract_button.disabled = false;
								frameRef.frames[1].frames[2].document.forms[0].practitioner_desc.disabled = false;
								frameRef.frames[1].frames[2].document.forms[0].pract_mand_img.style.visibility	=	'visible';
							}
							//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] End
							/*Added by Rameswar on 10-Feb-16 for GDOH-CRF-081*/
						  }
						  //top.content.frames[1].frames[2].document.forms[0].treat_area.add(opt4);
						  frameRef.frames[1].frames[2].document.forms[0].treat_area.add(opt4);//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148]
		            }
					  
	  	            </script>	
    <%        } 
			  if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlTreat != null) && (sqlTreat.length() > 0))
			  {
				sqlTreat.delete(0,sqlTreat.length());
			  } 
		  }
	 }

/** Code Added For Populating Values In TreatmentArea And Priority List Boxes Based On The PRIORITY-ZONE Value In Secondary Triage Function **/

if(treatmentflag1!=null)
		{
		
		 if(treatmentflag1.equals("Y"))
			{  
			 
			 /*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 3rd 2014 Start*/
			 if(!five_level_triage_appl_yn.equals("Y")){
			    if(priority.equals("R"))
				         priority_no="1";
			   if(priority.equals("Y"))
				         priority_no="3";
			    if(priority.equals("G"))
				         priority_no="2";
				if(priority.equals("U"))
				         priority_no="4";
			 }else{
				 priority_no	= p_zone_order_no_new;
			 }
				/*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 3rd 2014 End*/
				sqlTreatF1       = new StringBuffer();
				  
                  sqlTreatF1.append("select treatment_area_code, short_desc,OPEN_TO_ALL_PRAC_FOR_CLINIC_YN from ae_tmt_area_for_clinic_lang_vw ##REPDB## where language_id='"+locale+"' and facility_id = ?  and CLINIC_CODE = ? AND PRIORITY_ZONE=  ? and (gender = ?  OR gender IS NULL)   and eff_status = 'E' ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

				  /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				  sqlFinal = sqlTreatF1.toString();
				  sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				  /*End*/
			  pstmt      = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			  pstmt.setString(1, facilityId);
			  pstmt.setString(2, clinic_code);
              pstmt.setString(3, priority);
			  pstmt.setString(4, gender);

			  rs		 = pstmt.executeQuery();
			  while(rs!=null && rs.next())
			  {	
			        area_code        = rs.getString(1);
				    shortDesc		= rs.getString(2);
					//Senthil added AAKH-CRF-0010 [IN:038535]
					String open_allclinicyn=rs.getString(3);
					String tempcode="";
					tempcode=area_code+"$$"+open_allclinicyn;
                    %>
		            <script>
						
		              var opt9= parent.frames[2].document.createElement("OPTION");
			     	      opt9.text	= "<%=shortDesc%>";
			     	      opt9.value	= "<%=tempcode%>";
						  if("<%=treat_code%>"=="<%=area_code%>")

						   opt9.selected	=true;
						  parent.frames[2].document.forms[0].treat_area.add(opt9);
	  	            </script>	
    <%        } 
              if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlTreatF1 != null) && (sqlTreatF1.length() > 0))
			  {
				sqlTreatF1.delete(0,sqlTreatF1.length());
			  } 
            sqlTreatF2       = new   StringBuffer();
	 //Modified By Shanmukh for MMS-DM-CRF-0147		
            sqlTreatF2.append("select PRIORITY_CODE,SHORT_DESC  from ae_pat_priority_lang_vw ##REPDB## where language_id='"+locale+"' and PRIORITY_ZONE=? and EFF_STATUS='E' ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

			/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		    sqlFinal = sqlTreatF2.toString();
			sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			/*End*/
            pstmt      = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			pstmt.setString(1, priority);

            rs		 = pstmt.executeQuery();
			while(rs!=null && rs.next())
			  {	
			        area_code        = rs.getString(1);
				    shortDesc		= rs.getString(2);
				
                    %>
		            <script>
						
		              var opt99= parent.frames[2].document.createElement("OPTION");
			     	      opt99.text	= "<%=shortDesc%>";
			     	      opt99.value	= "<%=area_code%>";

						   if("<%=pat_priority%>"=="<%=area_code%>")
						   opt99.selected	=true;

						   parent.frames[2].document.forms[0].priority11.add(opt99);
	  	            </script>	
			  <%
              }
			  if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlTreatF2 != null) && (sqlTreatF2.length() > 0))
			  { 
				sqlTreatF2.delete(0,sqlTreatF2.length());
			  } 
		  }
	 }
/*END'S HERE*/
	if(preVisitFlag!=null)
		{
		 if(preVisitFlag.equals("Y"))
			{     
				// Start (venkat s) for PE_EXE ae regn attn function 
				   if( (prev_visit_hrs > 24) && (visit_status.equals("07") || visit_status.equals("09"))) {%>
				    <script>	
				      //top.content.frames[1].frames[2].document.forms[0].visit_within_24hrs.disabled = true;
				      frameRef.frames[1].frames[2].document.forms[0].visit_within_24hrs.disabled = true;
                    </script>
				   <%}else if(prev_visit_hrs > 0 && prev_visit_hrs <= 24 && (visit_status.equals("07") || visit_status.equals("09"))) {%>
				    <script>
                      //top.content.frames[1].frames[2].document.forms[0].visit_within_24hrs.disabled = false;
                      frameRef.frames[1].frames[2].document.forms[0].visit_within_24hrs.disabled = false;
               	    </script>
				   <%} 
			  } 
		}  
        if(NatIdFlag!=null)
		{
		 if(NatIdFlag.equals("Y"))
			{
			        stmt = con.createStatement();
			        String sql = "";
					String result ="";
			 		if(nat_id_check_digit_id != null)
					{
						sql = "SELECT program_name FROM mp_check_digit_scheme ##REPDB## WHERE scheme_id = '"+nat_id_check_digit_id+"' ";//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

					    sql = sql.replaceAll("##REPDB##",RepDb);//Added by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
				        rset = stmt.executeQuery(sql);
				        if( rset !=null && rset.next())
				        {
				            nat_id_check_digit_id = rset.getString("program_name");
				            if(rset != null)  rset.close();
							sql	= "select "+nat_id_check_digit_id+"('"+Nat_Id+"') ##REPDB## from dual";//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

							sql = sql.replaceAll("##REPDB##",RepDb);//Added by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
					        rset = stmt.executeQuery(sql);
				            if(rset.next())
								result = rset.getString(1);
				            if(rset != null)  rset.close();
						}
					}
				    if(rset != null)  rset.close();
                    if(stmt != null)  stmt.close();
					if (result.equals("N"))
					{
						%>
						<script>
						 var msg = getMessage("INVALID_NAT_ID","MP");
						 msg = msg.replace('#','<%=nat_id_prompt%>');
						alert(msg);
						</script>
						<%if(CalledFrom.equals("Reg")){%>
						<script>
						
					
						parent.frames[1].frames[2].document.forms[0].<%=Nat_IdName%>.focus();
						parent.frames[1].frames[2].document.forms[0].<%=Nat_IdName%>.value='';
						</script>
						<%}else{%>	
						<script>
							 parent.frames[3].document.forms[0].<%=Nat_IdName%>.focus();
							 parent.frames[3].document.forms[0].<%=Nat_IdName%>.value='';
						</script>
						<%}
					}  

			} 
	    }
	   if(occ_classFlag!=null)
		{
		 if(occ_classFlag.equals("Y"))
			{
       		sqlOcc             = new StringBuffer();
            sqlOcc.append("select ocpn_code,short_desc from  mp_occupation_lang_vw ##REPDB## where language_id='"+locale+"' and ocpn_class_code = ?  and eff_status='E' order by 2  ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

			/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		    sqlFinal = sqlOcc.toString();
			sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			/*End*/
			pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			pstmt.setString(1, occ_class);

			rs		 = pstmt.executeQuery();
		    
			while(rs!=null && rs.next())
			  {	
					   code				= rs.getString("ocpn_code");
				       shortDesc		= rs.getString("short_desc");
					   if(from_rev.equals(""))
				       {%>
		                 <script>
		                  //var opt6 = top.content.frames[1].frames[2].document.createElement("OPTION");
		                  var opt6 = frameRef.frames[1].frames[2].document.createElement("OPTION");
			     	      opt6.text 	= "<%=shortDesc%>";
			     	      opt6.value	= "<%=code%>";
					     // top.content.frames[1].frames[2].document.forms[0].occ_of_per.add(opt6);
					     frameRef.frames[1].frames[2].document.forms[0].occ_of_per.add(opt6);
	  	          </script>	
                 <%}
				  else
				  {%>
		          <script>
		             // var opt6 = top.content.frames[3].document.createElement("OPTION");
		              var opt6 = frameRef.frames[3].document.createElement("OPTION");
			     	      opt6.text 	= "<%=shortDesc%>";
			     	      opt6.value	= "<%=code%>";
					     // top.content.frames[3].document.forms[0].occ_of_per.add(opt6);
					      frameRef.frames[3].document.forms[0].occ_of_per.add(opt6);
	  	          </script>	
    <%        } 
				  }
			  if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close();
			  if((sqlOcc != null) && (sqlOcc.length() > 0))
			  {
				sqlOcc.delete(0,sqlOcc.length());
			  } 
			} 
	    }
		if(mechaInjflag!=null)
		{
		 if(mechaInjflag.equals("Y"))
			{ 
			    sqlMechInj      = new StringBuffer();
				
                sqlMechInj.append(" SELECT INJ_SUBCATEGORY_CODE,SHORT_DESC FROM AE_INJURY_SUBCATEGORY_LANG_VW ##REPDB##  WHERE language_id='"+locale+"' AND EFF_STATUS='E' AND INJ_CATEGORY_CODE = ? ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sqlMechInj.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/

				pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
				pstmt.setString(1, category);

				rs		 = pstmt.executeQuery();
		        while(rs!=null && rs.next())
			     {	
			        inj_sub         = rs.getString(1);
				    shortDesc		= rs.getString(2);
				    if(called_function.equals("REGISTER_ATTEN")){	/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
        %>
       			 <script> 
		            var opt5 = parent.frames[1].frames[2].document.createElement("OPTION");
			     	opt5.text	= "<%=shortDesc%>";
			     	opt5.value	= "<%=inj_sub%>";
					if("<%=mech_injr_subcat_code%>" == "<%=inj_sub%>" )
						opt5.selected = true;
					parent.frames[1].frames[2].document.forms[0].injury.add(opt5);
	  	         </script>
	        	

        	<%}else{%>
	        	  <script> 
		            var opt5 = parent.frames[2].document.createElement("OPTION");
			     	opt5.text	= "<%=shortDesc%>";
			     	opt5.value	= "<%=inj_sub%>";
					if("<%=mech_injr_subcat_code%>" == "<%=inj_sub%>" )
						opt5.selected = true;
					parent.frames[2].document.forms[0].injury.add(opt5);
	  	         </script>	
	    <%	} 

	       } 
				 if(rs!=null) { rs.close(); rs = null; }   
 				 if(pstmt!=null) { pstmt.close(); pstmt = null;}
				 if((sqlMechInj != null) && (sqlMechInj.length() > 0))
				  {
					sqlMechInj.delete(0,sqlMechInj.length());
				  } 
			}
		}
    

	if(mechaInjflagNew!=null)
		{
		 if(mechaInjflagNew.equals("Y"))
			{
			    sqlMechInj1    = new StringBuffer();
				sqlMechInj1.append("SELECT INJ_CATEGORY_CODE,SHORT_DESC FROM AE_INJURY_CATEGORY_LANG_VW ##REPDB## WHERE language_id='"+locale+"'  AND EFF_STATUS='E' and oscc_yn=  ?  ORDER BY 2  ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sqlMechInj1.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
				pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
				pstmt.setString(1, oscc_yn);

				rs		 = pstmt.executeQuery();
		        while(rs!=null && rs.next())
			     {	
			        inj_sub         = rs.getString(1);
				    shortDesc		= rs.getString(2);
				    if(called_function.equals("REGISTER_ATTEN")){ 	/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
        %>	
	        	  <script>
		            var opt5 = parent.frames[1].frames[2].document.createElement("OPTION");
			     	opt5.text	= "<%=shortDesc%>";
			     	opt5.value	= "<%=inj_sub%>";
					parent.frames[1].frames[2].document.forms[0].mechan_injury.add(opt5);
	  	         </script>	
	    <%}else{%>
	    		 <script>
		            var opt5 = parent.frames[2].document.createElement("OPTION");
			     	opt5.text	= "<%=shortDesc%>";
			     	opt5.value	= "<%=inj_sub%>";
					parent.frames[2].document.forms[0].mechan_injury.add(opt5);
	  	         </script>

	    <%}

	     } 
				 if(rs!=null) { rs.close(); rs = null; }   
 				 if(pstmt!=null) { pstmt.close(); pstmt = null;}
				 if((sqlMechInj1 != null) && (sqlMechInj1.length() > 0))
				  {
					sqlMechInj1.delete(0,sqlMechInj1.length());
				  } 
			}
		}



     if(patValidflag!=null)
		{
		 
		 if(patValidflag.equals("Y"))
			{
			    // Tuesday, April 20, 2010 for PE_EXC venkat s (changed pr_encounter into oae_current_patient table , condition remain same )
				sqlPatValid    = new StringBuffer();
                sqlPatValid.append("select patient_id from ae_current_patient ##REPDB## where "); //Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
				sqlPatValid.append(" patient_id= ? and QUEUE_STATUS < '07' "); 
				sqlPatValid.append(" and locn_code= ?  ");
				sqlPatValid.append(" and facility_id = ? ");

				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sqlPatValid.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
				pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
				pstmt.setString(1, patient_id);
				pstmt.setString(2, clinic_code);
				pstmt.setString(3, facilityId);

				rs		 = pstmt.executeQuery();
		       if (rs!=null && rs.next()) 
			     {	
                  chkflag=1; 
	             } 
				 
				 if(rs!=null) { rs.close(); rs = null; }   
 				 if(pstmt!=null) { pstmt.close(); pstmt = null;}
				 if((sqlPatValid != null) && (sqlPatValid.length() > 0))
				  {
					sqlPatValid.delete(0,sqlPatValid.length());
				  } 
			}
		} 
		if(chkflag==1)
					{				          

					      // out.println("<script>parent.frames[0].document.forms[0].apply.disabled=false;     parent.frames[1].frames[2].document.forms[0].location.disabled=false;alert(getMessage('OPEN_VST_STATUS_FOR_AE_CLINIC','AE'));top.content.frames[1].frames[2].document.forms[0].location.value=''; var loc = top.content.frames[1].frames[2].document.forms[0].location; if(top.content.frames[1].frames[2].document.forms[0].location.value==''){ 					 var opt1 = top.content.frames[1].frames[2].document.createElement('OPTION'); opt1.text	= '----' +getLabel('Common.defaultSelect.label','Common')+ '----';  opt1.value	= ''; top.content.frames[1].frames[2].document.forms[0].location.add(opt1,0)};</script>");
					       out.println("<script> parent.frames[0].document.forms[0].apply.disabled=false;     parent.frames[1].frames[2].document.forms[0].location.disabled=false;alert(getMessage('OPEN_VST_STATUS_FOR_AE_CLINIC','AE'));"+frameRef+".frames[1].frames[2].document.forms[0].location.value=''; var loc = "+frameRef+".frames[1].frames[2].document.forms[0].location; if("+frameRef+".frames[1].frames[2].document.forms[0].location.value==''){ 					 var opt1 = "+frameRef+".frames[1].frames[2].document.createElement('OPTION'); opt1.text	= '----' +getLabel('Common.defaultSelect.label','Common')+ '----';  opt1.value	= ''; "+frameRef+".frames[1].frames[2].document.forms[0].location.add(opt1,0)};</script>");
						%>
					<script>							
						/*var selLength = top.content.frames[1].frames[2].document.forms[0].location.options.length;
						var selObj = top.content.frames[1].frames[2].document.forms[0].location;*/
						
						var selLength = frameRef.frames[1].frames[2].document.forms[0].location.options.length;
						var selObj = frameRef.frames[1].frames[2].document.forms[0].location;
						selObj.remove(0);
						//var opt5 = top.content.frames[1].frames[2].document.createElement("OPTION");
						var opt5 = frameRef.frames[1].frames[2].document.createElement("OPTION");
						opt5.text	= '------------------' +getLabel("Common.defaultSelect.label","Common")+ '----------------';
						opt5.value	= '';

						var cnt = 0;
						for(var t=0;t<parseInt(selLength-1);t++)
						{
							if(selObj.options[t].value == '')
							{
								cnt++;
								break;
							}
						}
						if(cnt == 0)
						{
							//top.content.frames[1].frames[2].document.forms[0].location.add(opt5,0);
							frameRef.frames[1].frames[2].document.forms[0].location.add(opt5,0);
						}

                    	//var service	= top.content.frames[1].frames[2].document.forms[0].service;
                    	var service	= frameRef.frames[1].frames[2].document.forms[0].service;
						while(service.options.length >= 1)
						service.remove(0);

						//var opt = top.content.frames[1].frames[2].document.createElement("OPTION");
						var opt = frameRef.frames[1].frames[2].document.createElement("OPTION");
						opt.text	= '----' +getLabel("Common.defaultSelect.label","Common")+ '----';
						opt.value	= '';
						//top.content.frames[1].frames[2].document.forms[0].service.add(opt);
						frameRef.frames[1].frames[2].document.forms[0].service.add(opt);

                    	//var visit_type	= top.content.frames[1].frames[2].document.forms[0].visit_type;
                    	var visit_type	= frameRef.frames[1].frames[2].document.forms[0].visit_type;
						while(visit_type.options.length >= 1)
						visit_type.remove(0);

						//var opt1 = top.content.frames[1].frames[2].document.createElement("OPTION");
						var opt1 = frameRef.frames[1].frames[2].document.createElement("OPTION");
						opt1.text	= '----' +getLabel("Common.defaultSelect.label","Common")+ '----';
						opt1.value	= '';
						//top.content.frames[1].frames[2].document.forms[0].visit_type.add(opt1);        
						frameRef.frames[1].frames[2].document.forms[0].visit_type.add(opt1);        
					 </script>
						<%
						//out.println("<script>top.content.frames[1].frames[2].document.forms[0].location.value='';top.content.frames[1].frames[2].document.forms[0].location.text='';</script>");						
						out.println("<script>"+frameRef+".frames[1].frames[2].document.forms[0].location.value='';"+frameRef+".frames[1].frames[2].document.forms[0].location.text='';</script>");						
					}
	if(secondaryTriFlag!=null) 
			{
	  if(secondaryTriFlag.equals("Y"))
		{
		   StringBuffer PRRef = new StringBuffer();
		   PRRef.append("select count(*) count from PR_REFERRAL_REGISTER ##REPDB## where ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
		   PRRef.append(" REFERRAL_ID= ?  and PATIENT_ID= ? ");

		   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		   sqlFinal = PRRef.toString();
		   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
		   /*End*/
		   pstmt  = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
		   pstmt.setString(1, referral_id);
		   pstmt.setString(2, patient_id);
		   rs = pstmt.executeQuery();
		   if(rs != null && rs.next())
			 {
				countRef = rs.getInt("count");
			 }if(rs != null) rs.close();
			 if(countRef == 0)
			 {
			 out.println("<script>alert(getMessage('INV_REF_ID','IP'));</script>");
			  %>
			  <script>

			  parent.frames[2].document.getElementById('tab1').scrollIntoView();
			  parent.frames[2].document.forms[0].referral_id.select();
			  parent.frames[2].document.forms[0].referral_id.value="";
			  parent.frames[2].document.forms[0].referral_id.focus();

			  </script>
			 <%
			  }
			  if(pstmt!=null)pstmt.close();
			  if((PRRef != null) && (PRRef.length() > 0))
				{
					PRRef.delete(0,PRRef.length());
				}
		}
	}
	/*Below line added for this CRF ML-MMOH-CRF-0654*/
	if(transportmodeflag!=null)
		{

		 if(transportmodeflag.equals("ModeOfTransfer"))
			{
			  sqlTrans    = new StringBuffer();
			  
              sqlTrans.append("SELECT ARRIVAL_CODE,SHORT_DESC FROM  AM_ARRIVAL_LANG_VW ##REPDB## WHERE language_id='"+locale+"' and EFF_STATUS='E'  AND FACILITY_ID= ?  AND TRANSPORT_MODE = ? ORDER BY 2  ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

			  /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
			  sqlFinal = sqlTrans.toString();
			  sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			  /*End*/
			  			  			  			  
			  pstmt  = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			  pstmt.setString(1, facilityId);
			  pstmt.setString(2, transport_mode);

			  rs	 = pstmt.executeQuery(); 
		      while(rs!=null && rs.next())
		      {	
			    arrival_code    = rs.getString(1);
				shortDesc		= rs.getString(2);
			   %>
	    	   <script> 	   
		            var optsec= parent.frames[2].document.createElement("OPTION");					
			     	optsec.text	= "<%=shortDesc%>";					
			     	optsec.value	= "<%=arrival_code%>";					
					if("<%=mode_of_arrival%>" == "<%=arrival_code%>" ){

						optsec.selected = true; 
						
						//Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17
						if("<%=modify_flag%>" == "Y")
							parent.frames[2].document.forms[0].mode_of_arrival.disabled=true;
						else
							parent.frames[2].document.forms[0].mode_of_arrival.disabled=false;
                    }					
					   parent.frames[2].document.forms[0].mode_of_arrival.add(optsec);					
	  	       </script>	
	     <%	  } 
			  if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlTrans != null) && (sqlTrans.length() > 0))
			  {
				sqlTrans.delete(0,sqlTrans.length());
			  } 
		   }
		}
	//End this CRF ML-MMOH-CRF-0654	
	%>

	<%
	if(CalledFrom.equals("register_atten") ){
		out.println("<script> parent.frames[0].document.forms[0].apply.disabled=false;parent.frames[1].frames[2].document.forms[0].location.disabled=false;</script>");
		%>
	<script>
	parent.frames[0].document.forms[0].apply.disabled=false;
	parent.frames[1].frames[2].document.forms[0].location.disabled=false;
	</script>		
<%}
}
catch(Exception e){ e.toString(); e.printStackTrace();}
	finally {
		           ConnectionManager.returnConnection(con,request);  
		    }
	%>
	</form>
		<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
	public static String checkForNull(String inputString,String dftVlaue){
		return ( ((inputString == null) || (inputString.equals(""))) ? dftVlaue : inputString );
	}
%>

	</body>
	</html>	 

