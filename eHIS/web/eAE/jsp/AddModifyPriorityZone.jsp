<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8" >
  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale			= (String)session.getAttribute("LOCALE");
String loginUser		= (String)session.getValue("login_user");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		<script type="text/javascript" src="../../eIP/html/JQuery/ColorCoding/farbtastic.js"></script>
		<link rel="stylesheet" href="../../eIP/html/JQuery/ColorCoding/farbtastic.css" type="text/css" />
		 <script language='javascript' src='../../eAE/js/PriorityZone.js'></script>
	  <script language='javascript' src='../../eCommon/js/common.js'></script>
	  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
  <%	
	 request.setCharacterEncoding("UTF-8");
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
	 
     Connection con 					= null;
	 PreparedStatement pstmt			= null;
	 ResultSet rset					    = null;
	 String mode						= ""; 

     String priority_zone_result		= request.getParameter("priority_zone");
	 priority_zone_result  = (priority_zone_result == null)?"":priority_zone_result;
  try
  {
     con								= ConnectionManager.getConnection(request);
	 /*Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on Apr 9th 2018 Start*/
	 Boolean waitingTimeIndYN			=	CommonBean.isSiteSpecific(con, "AE", "WAITING_TIME_INDICATOR");
	 String waiting_time				= "";
	 String waiting_time_color			= "";
	 /*Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on Apr 9th 2018 End*/
	

	 String priority_zone				= "";
	 String priority_zone_desc			= "";
	 String priority_zone_tab_desc		= "";
	 String eff_status					= "";

	 String checkBoxAttribute			= "";
 	 String readOnlyAttribute			= "";
	 String readOnlyAttribute1			= "";
	 /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
	 String priority_zone_color			= "";
	 String five_level_triage_appl_yn	= (request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
	 String facility_id					=	(String) session.getValue("facility_id");
	 /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End*/
	//Added By Shanmukh for MMS-DM-CRF-0147  start
	Boolean isPriorityZoneAppl			=	CommonBean.isSiteSpecific(con, "AE", "PRIORITY_ZONE");
    	String oper_stn_id="";
	String patient_count="";
	String sql1="";
	String sql2="";
	//End
		mode							= "INSERT";
   
	StringBuffer sql = new StringBuffer("select * from AE_PRIORITY_ZONE where PRIORITY_ZONE=?");
 if(!(priority_zone_result.equals("")))
  {
	pstmt   = con.prepareStatement(sql.toString());
	pstmt.setString(1,priority_zone_result) ;
 	rset = pstmt.executeQuery();
	
	 while(rset!=null && rset.next())
	  {
	 		priority_zone		= rset.getString("PRIORITY_ZONE");    
			priority_zone		= (priority_zone== null)?"":priority_zone;
			priority_zone_desc				= rset.getString("PRIORITY_ZONE_DESC");
			priority_zone_desc				= ( priority_zone_desc== null)?"": priority_zone_desc;
			priority_zone_tab_desc				= rset.getString("PRIORITY_ZONE_TAB_DESC");
			priority_zone_tab_desc				= (priority_zone_tab_desc== null)?"": priority_zone_tab_desc;
			/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
			priority_zone_color			= (rset.getString("PRIORITY_ZONE_COLOR")==null || rset.getString("PRIORITY_ZONE_COLOR")=="")?"":rset.getString("PRIORITY_ZONE_COLOR");
			/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End*/
			
			eff_status					= rset.getString("EFF_STATUS");
			/*Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on Apr 9th 2018 Start*/
			waiting_time			= (rset.getString("WAITING_TIME")==null || rset.getString("WAITING_TIME")=="")?"":rset.getString("WAITING_TIME");
			waiting_time_color			= (rset.getString("WAITING_TIME_COLOR")==null || rset.getString("WAITING_TIME_COLOR")=="")?"#FFFFFF":rset.getString("WAITING_TIME_COLOR");
			/*Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on Apr 9th 2018 End*/
			
			if(eff_status!=null && eff_status.equalsIgnoreCase("E"))
			{
					checkBoxAttribute   = "CHECKED";
			}
			else
		    {
					readOnlyAttribute	 = "READONLY";
	   	    }
			mode						 = "MODIFY";
			readOnlyAttribute1			 = "READONLY";
	  }
	  

	  if(rset!=null)  rset.close();
	  if(pstmt!=null)  pstmt.close();
	  
	  
  } // end of if rta_code_result	  
	  if(mode.equalsIgnoreCase("INSERT"))
		  checkBoxAttribute = "CHECKED";
	 //Added By Shanmukh for MMS-DM-CRF-0147
	sql2="select oper_stn_id from am_user_for_oper_stn where appl_user_id= '"+loginUser+"' and facility_id='"+facility_id+"'";
    pstmt   = con.prepareStatement(sql2);
    rset = pstmt.executeQuery();
	 while(rset!=null && rset.next()){
		 oper_stn_id=rset.getString("oper_stn_id");
	 }
   
	  /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
  
	  if(five_level_triage_appl_yn.equals("Y")){
   %>
   
  <script>
	  $(document).ready(function () {
		$('#colorpicker').farbtastic('#priority_zone_color');
		$("#colorPickId").click(function (event){
			$("#selectedElem").css('background-color', $("#priority_zone_color").val());
		});
	  });
  
  </script>


  <%}
	  /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End*/  
  if(waitingTimeIndYN){%>
  <script>
	  $(document).ready(function () {
		$('#colorpicker').farbtastic('#waiting_time_color');
		$("#colorPickId").click(function (event){
			$("#selectedElem").css('background-color', $("#waiting_time_color").val());
		});
	  });
  
  </script>


  <%}%>
   
   

	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="priority_zone_form" id="priority_zone_form" action="../../servlet/eAE.AEPriorityZoneServlet" method="post" target="messageFrame">
	 <table border="0" cellpadding="3" cellspacing="0" align='center' width='75%'>
		 <br><br><br>
	    <tr></tr>
		<tr></tr>
		<tr>
		   <td colspan='2' height='5'></td>
		</tr>
	    <tr>
		      <td class='label'  width='50%'><fmt:message key="eAE.PriorityZoneCode.label" bundle="${ae_labels}"/></td>
		      <td class='field'  width='50%'><input type='text' name='priority_zone' id='priority_zone' value='<%=priority_zone%>' maxLength='1' size='1' <%=readOnlyAttribute1%> onBlur='changeCase(this);' onKeyPress="return CheckForSpecChars(event)">
   		      <img src='../../eCommon/images/mandatory.gif' ></img>
			  </td> 	
		</tr>	
		<tr>
		   <td colspan='2'></td>
		</tr>
		
		<tr>
		      <td class='label'  width='50%'><fmt:message key="eAE.PriorityZoneColorDesc.label" bundle="${ae_labels}"/></td>
		      <td class='field' width='50%'><input type='text' name='priority_zone_desc' id='priority_zone_desc' value="<%=priority_zone_desc%>" maxLength='20' size='20' onBlur="makeValidString(this)">
			  <img src='../../eCommon/images/mandatory.gif' ></img>
              </td>
        </tr>
		<tr>
		   <td colspan='2'></td>
		</tr>
		<tr>
		      <td class='label'  width='50%'><fmt:message key="eAE.PriorityZoneTabDesc.label" bundle="${ae_labels}"/></td>
		      <td class='field'  width='50%'><input type='text' name='priority_zone_tab_desc' id='priority_zone_tab_desc' value="<%=priority_zone_tab_desc%>" maxLength='20' size='20' onBlur="makeValidString(this)">
 		      <img src='../../eCommon/images/mandatory.gif' ></img>
              </td>
        </tr>
		<tr>
		   <td colspan='2'></td>
		</tr>
		 <!-- Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start -->
		<%if(five_level_triage_appl_yn.equals("Y")){%>
		<tr>
		 <td class='label'  width='50%'><fmt:message key="eAE.ColorIndicator.label" bundle="${ae_labels}"/></td>
		      <td class='field' width='50%'>
		      <input type='text' name='selectedElem' id='selectedElem' id='selectedElem'  maxLength='20' size='20' readonly <%if(!priority_zone_color.equals("")){ %>style="background-color:<%=priority_zone_color%>" <%} %>><!-- Its Used for Display -->
		      <input type='hidden' name='priority_zone_color' id='priority_zone_color' id='priority_zone_color' value="<%=priority_zone_color%>" maxLength='20' size='20' readonly><!-- Its Used for Save -->
	  
              </td>
		     
        </tr>
        <%}else{ %>
       		 <input type='hidden' name='priority_zone_color' id='priority_zone_color' id='priority_zone_color' value="#ffffff" >
        <%} %>
         <!-- Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End -->


		 <!-- Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on Apr 9th 2018 Start -->
		<%if(waitingTimeIndYN){%>
		<tr>
		      <td class='label'  width='50%'><fmt:message key="eAE.WaitingTimeExceeds.label" bundle="${ae_labels}"/></td>
		      <td class='field'  width='50%'><input type='text' name='waiting_time' id='waiting_time' value="<%=waiting_time%>" maxLength='3' size='3' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='SPCheckPositiveNumber(this);' /> &nbsp;<fmt:message key="eOP.Mins.label" bundle="${op_labels}"/>
 		    
              </td>
        </tr>
		<tr>
		   <td colspan='2'></td>
		</tr>
		<tr>
		 <td class='label'  width='50%'><fmt:message key="eAE.WaitingTimeColorIndicator.label" bundle="${ae_labels}"/></td>
		      <td class='field' width='50%'>
		     
			 <div id="selectedElem" name="selectedElem" class='colorcode' style="background-color:<%=waiting_time_color%>; height:30px;width:30px;border: 1px solid;cursor:pointer;"></div>

		      <input type='hidden' name='waiting_time_color' id='waiting_time_color' id='waiting_time_color' value="<%=waiting_time_color%>"  />
	  
              </td>
		     
        </tr>
        <%}else{ %>
       		 <input type='hidden' name='waiting_time_color' id='waiting_time_color' id='waiting_time_color' value="#ffffff" >
       		 <input type='hidden' name='waiting_time' id='waiting_time' id='waiting_time' value="" >
        <%} %>
         <!-- Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on Apr 9th 2018 End -->



		<tr>
		   <td colspan='2'></td>
		</tr>
		<!-- Added by Shanmukh on 10th-SEPT-2018 for MMS-DM-CRF-0147-->
		<%if(isPriorityZoneAppl){%>
		<tr>
		      <td class='label'  width='50%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><input type='checkbox' name='eff_stat' id='eff_stat' value='<%=eff_status%>' <%=checkBoxAttribute%>  onClick='chkEffStatus(this);chkPatCount(this);'>
              </td>
			  <input type="hidden" name='eff_status' id='eff_status' value='<%=eff_status%>'>
			 <% try{
				 sql1="select count(*) patient_count from ae_current_patient a, mp_patient b, op_clinic_lang_vw c where a.facility_id = ? and a.facility_id = c.facility_id and a.patient_id = b.patient_id and c.language_id = ? and a.facility_id=c.facility_id and a.locn_code = c.clinic_code and a.queue_status < '07' and a.priority_zone = ? AND SYSDATE BETWEEN a.check_in_date_time AND (((select reg_attendace_within_hour from ae_param where operating_facility_id =?)/24)+(a.check_in_date_time)) and (a.locn_type, a.locn_code) in (select locn_type, locn_code from am_os_user_locn_access_vw where facility_id =? and Oper_stn_id =? and appl_user_id =? and manage_queue_yn = 'Y' )"; 
			 pstmt   = con.prepareStatement(sql1);
			 pstmt.setString(1,facility_id);
			 pstmt.setString(2,locale);
			 pstmt.setString(3,priority_zone_result);
			 pstmt.setString(4,facility_id);
			 pstmt.setString(5,facility_id);
			 pstmt.setString(6,oper_stn_id);
			 pstmt.setString(7,loginUser);
			 rset = pstmt.executeQuery();
			 while(rset!=null && rset.next()){
				 patient_count=rset.getString("patient_count");
			 }
			}catch(Exception e){e.printStackTrace();}
			 %> 
			  
			  <input type="hidden" name="patient_count" id="patient_count" value='<%=patient_count%>'>
        </tr>
		
		<tr>
		   <td colspan='2' height='5'></td>
		</tr>
		<%}%>
	    
	 </table> 
	 <!-- Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start -->
	 <%if(five_level_triage_appl_yn.equals("Y") || waitingTimeIndYN){%>
		
		  <div class="ui-layout-center" style="float:right;margin-top:-150px;margin-right:100px;" id='colorpickcontainer'> 
			<div id='colorPickId' class='colorPickId'>
				<div id="colorpicker"></div>
			</div>
		  </div>
	<%} 
	%>
	<input type='hidden' name='five_level_triage_appl_yn' id='five_level_triage_appl_yn' value='<%=five_level_triage_appl_yn%>'>
	 <!-- Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End -->
		
	<input type='hidden' name='isPriorityZoneAppl' id='isPriorityZoneAppl' value='<%=isPriorityZoneAppl%>'>	<!--Added By Shanmukh for MMS-DM-CRF-0147-->	 		 
		     <input type='hidden' name='mode' id='mode' value='<%=mode%>' >	
	 </form>
		  <%
                if(mode.equals("INSERT"))
					out.println("<script>document.forms[0].eff_status.value='E';document.forms[0].priority_zone.focus();</script>");
				 else
					out.println("<script>document.forms[0].priority_zone_desc.focus();</script>");
		 %>
    </body>

<% } catch(Exception e){e.printStackTrace();}
   finally
    {
    	
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

