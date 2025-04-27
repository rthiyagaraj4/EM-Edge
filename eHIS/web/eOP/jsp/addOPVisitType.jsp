<!DOCTYPE html>
				
	<!-- Overview: This program called for two operations.One is Insert Mode
	     and  other is Modify mode.These mode values are stored one variable
		 -- fnvalue.Take one boolean variable newvisittype,If fnvalue is Insert
		 then boolean variable is true otherwise false.Based on Operation the
		 corresponding details are passed to VisitTypeServlet -->	
		
		
<html>
	<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*,eAE.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
		
<head>

<%
request.setCharacterEncoding("UTF-8");

request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eOP/js/Visittype.js'></script>
		<script language='javascript' src='../../eCommon/js/Colourpalette.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>


<%

   String facilityid = (String) session.getValue( "facility_id" ) ;	
   String visit_type_code=""; // Used to Store Visit Type Code
   String longdesc="";
   String shortdesc="";
   String visit_type_ind="";	// Used to Store visit type indicator value
   String max_appt_duration=""; // Used to store maximum appointment duration for patient - not to                                  exceed 1440 minutes
   String max_appt_slots="";  // Used to store maximum appointment slots
  
   String vtype="";
   String vtype1="";
   String effstatus=""; // Used to Store Effective Status either 'E' or 'D'
   
   String checkBoxAttribute_VC=""; //added by Himanshu Saxena for ML-MMOH-CRF-1930(U2)
   String effstatus_VC="D"; //added by Himanshu Saxena for ML-MMOH-CRF-1930(U2)
		   
   String codeTextAttribute=""; // used for visit type code
   String otherTextAttribute=""; // Used for  effective status whether it is (enabled/disabled)  
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   String rd_appl_yn="";
 
   String radApplYnChk = "";
   String radApplYnDis = "";
   String ris_oa_integrate = "N";
   String disCheckBoxAttribute=""; // added by mujafar for KDAH-CRF-0526
  
   //String sel="";
  
  String color_indicator=""; // color indicator used to store visit type colour code value. BRU-HIMS-CRF-177
  
   Connection conn =null;
   String service_criteria="";
   StringBuffer service_criteria_sel=new StringBuffer();

  try
  {
	conn=ConnectionManager.getConnection(request);
	Boolean isAERegisterTypeAutoUpdateAppl =	CommonBean.isSiteSpecific(conn, "AE", "AE_REG_TYPE_AUTO_UPDATE"); // added by mujafar for KDAH-CRF-0526
	Boolean isVIRTUAL_CONSULTATION  = eCommon.Common.CommonBean.isSiteSpecific(conn,"OP","VIRTUAL_CONSULTATION");//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 on 17-04-2023 -->

	Statement st=null;
	ResultSet rset=null;
	st=conn.createStatement();
	String sql3="";
	String installed_yn="N";
  	sql3="select install_yn, (select 'Y' from sm_function_control where functionality_id = 'RD_OA_INTEGRATE') ris_oa_integrate from sm_module where module_id='OR'";
	
	rset=st.executeQuery(sql3);
	if(rset != null && rset.next())
	  {
	   installed_yn=rset.getString(1);
	   ris_oa_integrate=rset.getString("ris_oa_integrate")==null?"N":rset.getString("ris_oa_integrate"); //Added this line for incident [36918]
	  }
	if(rset != null) rset.close();
	
	boolean newVisitType=false; // Used whether the visit type is create mode or modify mode
                                
/* if visit type is create mode 
    then set the variable newvisittype is true and continue the process. 
	otherwise take the data from the database based on visit type code
	and set the newvisittype is false
*/

%>
<%

	visit_type_code=request.getParameter("visit_type_code");
	               
	if(visit_type_code==null){
		visit_type_code="";
		longdesc="";
		shortdesc="";

		
	
		if(isAERegisterTypeAutoUpdateAppl) // added by mujafar for KDAH-CRF-0526
		{
			visit_type_ind="<select name='visit_type_ind' id='visit_type_ind' onChange='populateCriteria(this,this.form)'><option value=''>&nbsp;-------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --------&nbsp;</option><option value='F' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels")+"&nbsp;<option value='L'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels")+"&nbsp;<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels")+"&nbsp;<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels")+"&nbsp;<option value='W'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels")+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels")+"&nbsp;<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels")+"&nbsp;<option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels")+"&nbsp;</select>";

		}

		else
		{

		visit_type_ind="<select name='visit_type_ind' id='visit_type_ind' onChange='populateCriteria(this,this.form)'><option value=''>&nbsp;-------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --------&nbsp;</option><option value='F' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels")+"&nbsp;<option value='L'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels")+"&nbsp;<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels")+"&nbsp;<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels")+"&nbsp;<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels")+"&nbsp;<option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels")+"&nbsp;</select>";
		}
		max_appt_duration="";
		max_appt_slots="";
		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED"; //Used for checkbox is checked or not
		newVisitType=true;
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'"; //whatever case you enter either                                                        Lower OR Upper it will convert Uppercase 
		/* Resource Scheduling */

		if(!installed_yn.equals("Y"))
		{
			service_criteria_sel.append("<select name='scriteria' id='scriteria'><option value=''>&nbsp;-------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --------&nbsp;</option> </select>");
		}
		else
		{
			service_criteria_sel.append( "<select name='scriteria' id='scriteria'><option value=' '>&nbsp;-------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --------&nbsp;</option> </select>&nbsp;<img id='criteriaImg' align='center' src='../../eCommon/images/mandatory.gif'>");
		}
		
		/* Resource Scheduling */

	}else
		{
    	 
		try{
		
        /* The sql query is used to retrieve the values from
		the table op_visit_type based on the visittype code and facility_id 
		for modifying the data
		*/
                
        
		String sql = "select visit_type_code,long_desc,short_desc,visit_type_ind,eff_status,virtual_consultation,max_appt_duration,max_appt_slots,ORDER_CATALOG_CRITERIA,rd_appl_yn,color_indicator from op_visit_type where visit_type_code='"+visit_type_code+"' and facility_id ='"+facilityid+"'";
	    	
		rset = st.executeQuery(sql);
		rset.next();
		 
		visit_type_code=rset.getString("visit_type_code");
		longdesc=rset.getString("long_desc");
		shortdesc=rset.getString("short_desc");
		vtype =rset.getString("visit_type_ind");
		max_appt_duration = rset.getString("max_appt_duration");
		max_appt_slots= rset.getString("max_appt_slots");
		if(max_appt_duration == null) max_appt_duration = "";
		if(max_appt_slots== null) max_appt_slots = "";
		effstatus=rset.getString("eff_status");
		if(effstatus.equals("D")){
			otherTextAttribute="READONLY";
			checkBoxAttribute="";
		}else{
       		otherTextAttribute="";
			checkBoxAttribute="CHECKED";
		}
		
		//added by Himanshu Saxena for ML-MMOH-CRF-1930(U2) Started //
		effstatus_VC=rset.getString("virtual_consultation");
		if(effstatus_VC.equals("D")){
			checkBoxAttribute_VC="";
		}else{
			checkBoxAttribute_VC="CHECKED";
		}//added by Himanshu Saxena for ML-MMOH-CRF-1930(U2) Started //
		

		if(isAERegisterTypeAutoUpdateAppl) // added by mujafar for KDAH-CRF-0526
			{
				int loc_cnt = eAE.AECommonBean.getEffectiveStatus(conn,visit_type_code,facilityid);	
			

				if(loc_cnt>0 && effstatus.equals("E"))
				{disCheckBoxAttribute="disabled";
					checkBoxAttribute="CHECKED";}
			}


		
        service_criteria = (rset.getString("ORDER_CATALOG_CRITERIA")== null)?"":rset.getString("ORDER_CATALOG_CRITERIA");
        rd_appl_yn = (rset.getString("rd_appl_yn")== null)?"N":rset.getString("rd_appl_yn");
		
		color_indicator=rset.getString("color_indicator")==null?"":rset.getString("color_indicator"); //Added  [Bru-HIMS-CRF-177]
		
		if(rd_appl_yn.equals("Y")){
			radApplYnChk = "checked";
			radApplYnDis = "disabled";
		}else{
			radApplYnChk = "";
			radApplYnDis = "";
		}

        String service_criteria_value =""; 	
		
		if(service_criteria!=null) {
			
			if(service_criteria.equals("R"))
				service_criteria_value=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.required.label","common_labels");
			else if(service_criteria.equals("N"))
				service_criteria_value=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notrequired.label","common_labels");
			else if(service_criteria.equals(""))				service_criteria_value=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
		}
		
		if(effstatus.equals("E"))
			{
					if(!installed_yn.equals("Y"))
				 {
						service_criteria_sel.append( "<input type='text' name='scriteriaDisplay' id='scriteriaDisplay' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels")+"' size='15' maxlength='15' readonly> <input type=hidden name='scriteria' id='scriteria' value=''>");
				 }
				else
				 {
				service_criteria_sel.append("<select name='scriteria' id='scriteria'><option value=' ' >&nbsp;--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------&nbsp;</option><option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.required.label","common_labels")+"</option><option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notrequired.label","common_labels")+" </option></select>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>");	
				 }
			}
			else
			{
				service_criteria_sel.append("<input type='text' name='scriteriaDisplay' id='scriteriaDisplay' value='"+service_criteria_value+"' size='15' maxlength='15' readonly> <input type=hidden name='scriteria' id='scriteria' value='"+service_criteria+"'>");

				if(installed_yn.equals("Y"))
				{
					service_criteria_sel.append("&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
				}
			}
	
		if (vtype.equals("F")) {
			
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels");
		visit_type_ind= "<input type='text' name='visit_type_ind' id='visit_type_ind' value='"+vtype1+"' size='15' maxlength='15' readonly>";
			}
		else if(vtype.equals("L")) {
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels");
		visit_type_ind= "<input type='text' name='visit_type_ind' id='visit_type_ind' value='"+vtype1+"' size='15' maxlength='15' readonly>";
			}
		else if(vtype.equals("R")) {
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		visit_type_ind= "<input type='text' name='visit_type_ind' id='visit_type_ind' value='"+vtype1+"' size='15' maxlength='15' readonly>";
			}
		else if(vtype.equals("E")) {
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
		visit_type_ind= "<input type='text' name='visit_type_ind' id='visit_type_ind' value='"+vtype1+"' size='15' maxlength='15' readonly>";
			}


	


	else if(vtype.equals("W") && isAERegisterTypeAutoUpdateAppl) { // added by mujafar for KDAH-CRF-0526
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels")+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels");
		visit_type_ind= "<input type='text' name='visit_type_ind' id='visit_type_ind' value='"+vtype1+"' size='15' maxlength='15' readonly>";
			}





		else if(vtype.equals("S")) {
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels");
		visit_type_ind= "<input type='text' name='visit_type_ind' id='visit_type_ind' value='"+vtype1+"' size='15' maxlength='15' readonly>";
			}
		else {
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels");
		visit_type_ind= "<input type='text' name='visit_type_ind' id='visit_type_ind' value='"+vtype1+"' size='20' maxlength='20' readonly>";
	      }

     }catch(Exception e){
		e.printStackTrace();
		 }
     finally 
		{        
		     try{
				if (rset!= null) rset.close();
	           	if (st != null) st.close();
			 }catch(Exception e){}
		}
		codeTextAttribute="READONLY";
		newVisitType=false;
		eventFunctionForCase="";
	}
%>
     <body OnMouseDown='CodeArrest()' onload='FocusFirstElement();' onKeyDown = 'lockKey();' >
      	<form name='visittype_form' id='visittype_form' action='../../servlet/eOP.VisitTypeServlet' method='post' target='messageFrame'>
		 <%/*Below Div Added for this CRF [Bru-HIMS-CRF-177]*/	%>
	<div id='colorpicker201' class='colorpicker201' style="LEFT: 670px; DISPLAY: block; TOP: 330px;"></div>
      	<BR><BR><BR><BR><BR>
			<div align='left' >
			 <input type='hidden' name='install' id='install' value='<%=installed_yn%>'>
      	<table width='60%' border=0 align='center'>
      	<tr><td  valign='center' width='60%'>
      	<center>
      	<table border='0' cellpadding='2' cellspacing='0' >
      		<tr>
      		    <td width='40%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td width='60%' class='fields' colspan='2'><input type='text' name='visit_type_code' id='visit_type_code' value="<%=visit_type_code%>" size='2' maxlength='2' onKeyPress="return CheckForSpecChars(event)" <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>

     		<tr>
      		    <td  width='30%' class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      		    <td width='70%'  class='fields' colspan='2'><input type='text' name='long_desc' id='long_desc' size='32' onBlur = 'makeValidString(this)' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%> >
      		    <img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>

     		<tr>
      		    <td  width='30%' class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		    <td width='70%'  class='fields' colspan='2'>
		    <input type='text' name='short_desc' id='short_desc' size='20'  onBlur = 'makeValidString(this)' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%> >
		    <img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>

     		<tr>
      			<td width='30%' class='label'><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
      			<td width='70%' class='fields' colspan='2'><%=visit_type_ind%>
		   		<img align='center' src='../../eCommon/images/mandatory.gif'></img>
		   		</td>
   		</tr>

		<tr>
			<td width='30%' class='label'><fmt:message key="eOP.MaxApptDuration.label" bundle="${op_labels}"/></td>
			<td width='10%' class='fields'><input type='text' name='max_appt_duration' id='max_appt_duration' size='4' maxlength='4' value="<%=max_appt_duration%>" <%=otherTextAttribute%> onKeyPress='return allowValidNumber(this,event,4,0)' ></td>
			<td width='60%' class='querydata'><fmt:message key="Common.MIN.label" bundle="${common_labels}"/></td>
		</tr>
			<tr>
			<td width='30%' class='label'><fmt:message key="eOP.MaxApptSlots.label" bundle="${op_labels}"/></td>
			<td width='10%' class='fields'>
			<input type='text' name='max_appt_slots' id='max_appt_slots' onKeyPress='return allowValidNumber(this,event,3,0)' size='3' maxlength='3' value="<%=max_appt_slots%>" <%=otherTextAttribute%> ></td>
			<td class='label'>&nbsp;</td>
		</tr>
     		<tr>
      			<td width='30%' class='label'><fmt:message key="eOP.OrderableCriteria.label" bundle="${op_labels}"/></td>
      			<td width='70%' class='fields' colspan='2'><%out.println(service_criteria_sel.toString().trim());%>	</td>
   		</tr>
		<%if(ris_oa_integrate.equals("Y")){%>
		<tr>
      		     <td width='30%' class='label'><fmt:message key="Common.ApplicableToRadiology.label" bundle="${common_labels}"/></td>
      		     <td width='70%' colspan='2'  class='fields'>
      		     <input type='checkbox' name='rd_appl_yn' id='rd_appl_yn' value="<%=rd_appl_yn%>" <%=radApplYnChk%> <%=radApplYnDis%> onClick="assignValue()"></td>
			</tr>
			<%}%>
			<tr>
      		     <td width='30%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td width='70%' colspan='2'  class='fields'> 
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=disCheckBoxAttribute%>  <%=checkBoxAttribute%>  onClick="change()"></td></tr> <!--  added by mujafar for KDAH-CRF-0526 -->
				 
				 	 <%/*Below Line Added for this CRF [Bru-HIMS-CRF-177]*/%>
		<tr>
      			<td width='30%' class='label'><fmt:message key="Common.Color.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
      			<td width='70%' class='fields' colspan='2'>
             &nbsp;<input type="text" size="12" name="colour_code_disply"  id="colour_code_disply" style="background-color:<%=color_indicator%>" readonly ><input type="button" value='?' onclick="showColorGrid2('colour_code_id','colour_code_disply');">&nbsp;<input type="hidden" name="colour_code_id" id="colour_code_id"value="<%=color_indicator%>">	</td>
   		</tr>
   		
   		
   		<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U2) on 18-04-2023 Started -->
   		
<%if(isVIRTUAL_CONSULTATION){ %>
	<tr>
      		     <td width='30%' class='label'><fmt:message key="Common.virtualConsultation.label" bundle="${common_labels}"/></td>
      		     <td width='70%' colspan='2'  class='fields'> 
      		     <input type='checkbox' name='virtual_consultation' id='virtual_consultation' id='virtual_consultation' value="<%=effstatus_VC%>"  <%=checkBoxAttribute_VC%>  onClick="changeVCvalue()"></td>
      		     </tr>
<%
}else
{
	%>
	<input type='hidden' name='virtual_consultation' id='virtual_consultation' id='virtual_consultation' value="D">	
	<%
}
%><!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U2) on 18-04-2023 End -->
   		
   		
		<%//End [Bru-HIMS-CRF-177]%>
      	</table>
      	</td>
      	</table>
      	</div>
    <%  if(newVisitType){%>

      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>
   
			 <input type='hidden' name='hiddenscriteria' id='hiddenscriteria' value='<%=service_criteria%>'>

      	</form>
      	</body>
<script>
		if(document.forms[0].function_name.value=="modify")
				selectOrderableCriteria();
</script>
</html>

<%
  }catch(Exception e) {e.printStackTrace();}
finally{
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
		}
%>

