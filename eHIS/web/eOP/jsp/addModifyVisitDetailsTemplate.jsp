<!DOCTYPE html>
<html> 
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
Connection con = null;
%>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
 <script  src='../../eOP/js/VisitDetailsTemplate.js'   language='javascript' ></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script  src='../../eOP/js/OPPractitionerComponent.js'   language='javascript' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  <%
       try{
		   
	 
    
         con=ConnectionManager.getConnection(request);
         Statement stmt=null;
         ResultSet rs=null ;
         PreparedStatement pstmt=null;
	    ResultSet rs1=null ;
	   String locale ="";
         //String clinicdesc="";
	   String servicedesc="";
	   //String noof_visits="";
	   //String  dura_for_follow="";
	   //String cliniccode="";
	   String sql="";
       String servicecode="";
	    //String flag=""; 
	  String fnval="";
	 String temp_code="";
	String desc="";
	String locn_code="";
	String room_num="";
	String service_code="";
    String subservice_code="";
    String visit_type_code="";
	String practitioner_id="";
	String other_res_class="";
	String other_resource_id="";
	String order_catlog_code="";
	String contact_reason_code="";
	 String roomdesc=""; 
     String roomcode=""; 
	 /* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
     String room_short_desc="";
	 /*CRF end SS-CRF-0010 [IN034516]*/
	 String sel="";
	 String subservicecode="";
	 String  subservicedesc=""; 
	  String visittypecode="";
	 String visittypedesc="";
	 String locn_desc=""; 
	 String  other_resource_code="";
	  String order_catlog_desc="";
	 String contact_reason_desc="";
	 String practitioner_code=""; 
	 String locn_type="";
	 String open_to_all_pract_yn="";
	 String facilityid  = (String) session.getValue("facility_id");	 
	 locale = (String)session.getValue("LOCALE");
    fnval=request.getParameter("finval")==null ? "" : request.getParameter("finval").trim();  
	temp_code=request.getParameter("temp_code")==null ? "" : request.getParameter("temp_code");
	if(fnval.equals(""))
	fnval="insert";
     if(temp_code!=null )
         {
		 try{
		 	 
		 
		 stmt=con.createStatement();
			/* This query selects all the records from the table op_param_for_facy_service_vw for the corresponding operating facility and service. --- Srijagadeesh */
         //sql="select * from OP_TEMPLATE_FOR_VIS_REGN where template_code='"+ temp_code+"' " ;AM_SERVICE

      

	sql="SELECT template_code, description, locn_code, b.clinic_type locn_type, op_get_desc.op_clinic ('"+facilityid+"', locn_code, '"+locale+"', 1) locn_desc, room_num, a.service_code, subservice_code, visit_type_code, practitioner_id, am_get_desc.AM_PRACTITIONER (practitioner_id,'"+locale+"', 1) pract_name,other_res_class, other_resource_id,am_get_desc.AM_RESOURCE ('"+facilityid+"',other_resource_id,'"+locale+"',2) resource_desc,order_catalog_code,or_get_desc.or_order_catalog(order_catalog_code,'"+locale+"',2) order_cat_desc,contact_reason_code,am_get_desc.AM_CONTACT_REASON (contact_reason_code,'"+locale+"',1) reason_desc, b.open_to_all_pract_yn FROM op_template_for_vis_regn a,  op_clinic b WHERE a.FACILITY_ID ='"+facilityid+"' AND a.FACILITY_ID = b.FACILITY_ID  AND a.LOCN_CODE = b.CLINIC_CODE AND a.template_code = '"+temp_code+"'" ;
			
		rs=stmt.executeQuery(sql);
		if(rs.next())
			{
				    temp_code = rs.getString("TEMPLATE_CODE")==null ? "" : rs.getString("TEMPLATE_CODE"); 
				
				    desc=rs.getString("DESCRIPTION")==null ? "" : rs.getString("DESCRIPTION"); 
				    locn_code=rs.getString("LOCN_CODE")==null ?"" : rs.getString("LOCN_CODE"); 	
					locn_desc=rs.getString("locn_desc")==null ?"" : rs.getString("locn_desc"); 				
					room_num=rs.getString("room_num")==null ?"" : rs.getString("room_num"); 
					service_code=rs.getString("service_code")==null ? "" : rs.getString("service_code"); 
					 subservice_code=rs.getString("subservice_code")==null ? "" : rs.getString("subservice_code"); 
					 visit_type_code=rs.getString("visit_type_code")==null ? "" : rs.getString("visit_type_code"); 
					 practitioner_id=rs.getString("pract_name")==null ? "" : 
					 rs.getString("pract_name"); 
					 practitioner_code=rs.getString("practitioner_id")==null ? "" : 
					 rs.getString("practitioner_id"); 
					 other_res_class=rs.getString("OTHER_RES_CLASS")==null ? "" : rs.getString("OTHER_RES_CLASS"); 
					 other_resource_id=rs.getString("resource_desc")==null ? "" : rs.getString("resource_desc"); 
					 other_resource_code=rs.getString("OTHER_RESOURCE_ID")==null ? "" : rs.getString("OTHER_RESOURCE_ID");
					 order_catlog_desc=rs.getString("order_cat_desc")==null ? "" : rs.getString("order_cat_desc"); 
				      order_catlog_code=rs.getString("ORDER_CATALOG_CODE")==null ? "" : rs.getString("ORDER_CATALOG_CODE"); 
					   
					   contact_reason_desc=rs.getString("reason_desc")==null ? "" :rs.getString("reason_desc");
	                    contact_reason_code=rs.getString("contact_reason_code")==null ? "" :rs.getString("contact_reason_code");
					locn_type=rs.getString("locn_type")==null ? "" :rs.getString("locn_type");
					open_to_all_pract_yn = rs.getString("open_to_all_pract_yn")==null ? "" :rs.getString("open_to_all_pract_yn");
			
			}
	        
		}catch(Exception e) { 
			out.println(e.toString());
			e.printStackTrace();
			}
		finally
		{
			if (stmt != null) stmt.close();
	        if (rs != null) rs.close();
		}
        }else 
	    {
       
	    }
	  
       %>


    </head>
   <body  onLoad="FocusFirstElement()" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();' >
	  <form name='Visit_Details_Template' id='Visit_Details_Template' action='../../servlet/eOP.VisitDetailsTemplateServlet' method='post' target='messageFrame'>
     <BR><BR><BR><BR><BR>
	      <div align='center'>
	 <table border='0' cellpadding='3' cellspacing='0' width='90%' colspan='4'>
	 <tr>
	 <td width='15%' class='label'>
			 <fmt:message  key="Common.code.label" bundle="${common_labels}"/></td>
			 
	 <td width='40%' class='fields' cellpadding='4' >
	 <%  if(fnval.equals("modify"))
                        {%>
			 		
			 <INPUT TYPE="text" name="code" id="code" size='4'  value="<%=temp_code%>"  disabled onKeyPress="return CheckForSpecChars(event)">
			 <img align='center'  src='../../eCommon/images/mandatory.gif'></img></td>
		   	  <input type="hidden"  name="code1" id="code1" value="">	
			  </td>	
					
			  <% }
			 else
			 { %>
						
			 <INPUT TYPE="text"   name="code" id="code" maxlength='4'  size='4'   value=""  onKeyPress="return CheckForSpecChars(event)">
			 <img align='center'  src='../../eCommon/images/mandatory.gif'></img>
			 	</td>			
			  <%  } %>			
			 
			<td class='label' width='15%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>				
					 
			<td width='30%' class='fields' cellpadding='4' >
			 <INPUT TYPE="text" name="code_desc" id="code_desc" maxlength='40'  value="<%=desc%>"> <img align='center'  src='../../eCommon/images/mandatory.gif'></img></td>
              <input type="hidden" name="service_code" id="service_code" value="">					
			  </tr>                 
			</table>
		<table border='4' cellpadding='5' cellspacing='0' width='90%'>
			 <th class='columnheader' align="left"><fmt:message key="Common.Default.label" bundle="${common_labels}"/> <fmt:message key="Common.Values.label" bundle="${common_labels}"/></th>
			</table>
             <table border='0' cellpadding='3' cellspacing='0' width='90%'>
			 			 
			 <tr>
               <td width='15%' class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></b></td>
				
			 <td width='40%' class='fields' cellpadding='4' >
			 <select name="locn_type_desc" id="locn_type_desc" onchange='getValue(document.forms[0].locn_type_desc);' >
			 <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label"  bundle="${common_labels}"/> --------&nbsp;</option>
             <%if(locn_type.equals("C")){%>
			 <option value='C' selected ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
            <option value='E'><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
			 <%} else if(locn_type.equals("E")){%>
			  <option value='C' selected ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
            <option value='E' selected><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option> bundle="${common_labels}"/></option>
			<%}else{ %>
			<option value='C'  ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
            <option value='E'><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
			 <%}%>
			 </select>	 
			 
			 <INPUT TYPE="text" name="location_desc" id="location_desc" value="<%=locn_desc%>" onBlur="onBlurgetCli('<%=facilityid %>',document.Visit_Details_Template.location_desc);" ><input type="button" name="location_btn" id="location_btn" value="?" class="button"  onClick="getClinic('<%=facilityid %>',document.Visit_Details_Template.location_desc)"><img align='center'  src='../../eCommon/images/mandatory.gif'></img>
		   		 </td>	
				 <!--venkat-->
              <td width='15%' class='label'><fmt:message key="Common.room.label" bundle="${common_labels}"/></td>
			
			 <td width='30%' class='fields' cellpadding='4'>
			  <%if(fnval.equals("insert")){%>
			 <select name="room_desc" id="room_desc">
			 <option value=''>&nbsp------------------ <fmt:message key="Common.defaultSelect.label"     bundle="${common_labels}"/> ------------------&nbsp;</option>
             </select>
             <%} else {%>
			 	 <select name="room_desc" id="room_desc">
			 <option value=''>&nbsp;------------------ <fmt:message key="Common.defaultSelect.label"  bundle="${common_labels}"/> ------------------&nbsp;</option>
             <%
			try
			 {
			// query tuning.. modified by venkat S
			/* Below line query modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
              pstmt=con.prepareStatement("SELECT a.practitioner_id ROOM_NO, b.room_type room_type,am_get_desc.am_facility_room (a.facility_id,a.practitioner_id,'"+locale+"', 2) room_desc FROM op_pract_for_clinic a,  am_facility_room b WHERE a.facility_id='"+facilityid+"' AND a.clinic_code='"+locn_code+"' AND  a.eff_status='E' AND  a.resource_class='R' AND  a.practitioner_id=b.room_num  AND a.facility_id=b.OPERATING_FACILITY_ID");
			 /*CRF end SS-CRF-0010 [IN034516]*/
			 /* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
            
			rs1=pstmt.executeQuery();
			 while(rs1.next())
			{		 
				 roomcode=rs1.getString("ROOM_NO");
				 /* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
				room_short_desc=rs1.getString("room_desc");
				/*CRF end SS-CRF-0010 [IN034516]*/
			    roomdesc=rs1.getString("room_type");
			if(room_num.equals(roomdesc))
								sel="selected";
						%>	
			<!--  Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516]  -->			
			<option value='<%=roomcode%>'<%=sel%>> <%=roomcode%> <%=room_short_desc%></option>;		
<!-- CRF end SS-CRF-0010 [IN034516] -->			
						<% sel="";
			}
			if(pstmt != null) pstmt.close();
			if(rs1 != null) rs1.close();
				 }
		catch(Exception e) {
			e.printStackTrace();
			} 
			
			 }
			 %>
			 </select>
			 </td>
             <input type="hidden" name="room_code" id="room_code" value="">					
			  <input type="hidden" name="location_code" id="location_code" value="">
			 <input type="hidden" name="locn_type_code" id="locn_type_code" value="">	 
			 </tr>
			<tr>
          	   <td width='15%' class='label'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			 <td width='40%' class='fields' cellpadding='4'>
			 <%if(fnval.equals("insert")){%>
			 <select name="service_desc" id="service_desc" onChange="popSubservice(document.forms[0].service_desc);" >
			 <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label"  bundle="${common_labels}"/> --------&nbsp;</option>
            </select>
           <%} else {%>
		   <select name="service_desc" id="service_desc" onChange="popSubservice(this);" >
			 <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label"  bundle="${common_labels}"/> --------&nbsp;</option>
		   <%  try
				 {
			 pstmt=con.prepareStatement("SELECT   service_code,  short_desc FROM   am_service_lang_vw WHERE  language_id='"+locale+"' and eff_status = 'E' AND service_code in (SELECT service_code FROM op_clinic WHERE clinic_code ='"+locn_code+"' AND   facility_id='"+facilityid+"' UNION SELECT b.service_code FROM OP_CLINIC_FOR_SERVICE b WHERE b.clinic_code ='"+locn_code+"' AND b.facility_id='"+facilityid+"' and b.care_locn_type_ind = 'C') order by 2");
			 rs1=pstmt.executeQuery();
			 while(rs1.next())
			{		 
			servicecode=rs1.getString("service_code");
			servicedesc=rs1.getString("short_desc");
			if(room_num.equals(roomdesc))
			sel="selected";
						%>			
			<option value='<%=servicecode%>'<%=sel%>><%=servicedesc%></option>;				
						<% sel="";
			}
			if(pstmt != null) pstmt.close();
			if(rs1 != null) rs1.close();
				 }
		catch(Exception e) {
			e.printStackTrace();
			} 
			}		
			 %>
			 </select>
			  </td>            
			 
			 <td width='15%' class='label'><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
					
			 <td width='30%' class='fields' cellpadding='4'  >
			 <%if(fnval.equals("insert")){%>
			 <select name="sub_service_desc" id="sub_service_desc" >
			 <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label"  bundle="${common_labels}"/> --------&nbsp;</option>
         			 
			 </select>
           <%} else {%>
			<select name="sub_service_desc" id="sub_service_desc" >
			 <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label"  bundle="${common_labels}"/> --------&nbsp;</option> 
			 <%  try
				 {
			 pstmt=con.prepareStatement("SELECT  SUBSERVICE_CODE subservice_code, AM_GET_DESC.AM_SUBSERVICE(SERVICE_CODE,SUBSERVICE_CODE,'"+locale+"','2') short_desc FROM AM_FACILITY_SUBSRVC WHERE  OPERATING_FACILITY_ID='"+facilityid+"' AND  SERVICE_CODE='"+service_code+"' ORDER BY 2");
			rs1=pstmt.executeQuery();
			 while(rs1.next())
			{		 
				subservicecode=rs1.getString("subservice_code");
			    subservicedesc=rs1.getString("short_desc");
			if(room_num.equals(roomdesc))
								sel="selected";
						%>			
			<option value='<%=subservicecode%>'<%=sel%>><%=subservicedesc%></option>;				
						<% sel="";
			}
			if(pstmt != null) pstmt.close();
			if(rs1 != null) rs1.close();
				 }
		catch(Exception e) {
			e.printStackTrace();
			} 
			}
		
			 %>
			 </select>
              </td>
             <input type="hidden" name="sub_service_code" id="sub_service_code"      value="">					
			 <input type="hidden" name="service_code" id="service_code" value="">		
			 </tr>	 
			 
			<tr>
               <td width='15%' class='label'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
					
			 <td width='40%' class='fields' cellpadding='4'   >
			 <%if(fnval.equals("insert")){%>
			 <select name="visit_type_desc" id="visit_type_desc">
			 <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label"  bundle="${common_labels}"/> --------&nbsp;</option>
             </select>
              <%} else {%>
			 <select name="visit_type_desc" id="visit_type_desc">
			 <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label"  bundle="${common_labels}"/> --------&nbsp;</option>
					  
			  <%  try
				 {
			 pstmt=con.prepareStatement("select visit_type_code, OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, VISIT_TYPE_CODE,'"+locale+"','2') short_desc from op_visit_type_for_clinic where facility_id = '"+facilityid+"' and clinic_code ='"+locn_code+"' and eff_status='E' order by 2");
		  	
			rs1=pstmt.executeQuery();
			 while(rs1.next())
			{		 
				visittypecode=rs1.getString("visit_type_code");
			   visittypedesc=rs1.getString("short_desc");
			if(room_num.equals(roomdesc))
				sel="selected";
						%>			
			<option value='<%=visittypecode%>'<%=sel%>><%=visittypedesc%></option>;				
						<% sel="";
			}
			if(pstmt != null) pstmt.close();
			if(rs1 != null) rs1.close();
				 }
		catch(Exception e) {
			e.printStackTrace();
			} 
			}
				 %>
			 </select>
			  </td>
             
				 
				 
			<td width='15%' class='label'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></b></td>
			
			 <td width='30%' class='fields' colspan='3' cellpadding='4'   >
			 <INPUT TYPE="text" name="practitioner_desc" id="practitioner_desc"  maxlength="30" size="30" value="<%=practitioner_id%>"  onBlur="onBlurcallPractSearchQuery(this,'<%=facilityid %>' ,document.Visit_Details_Template.practitioner_desc)"><input type="button" name="practitioner_btn" id="practitioner_btn" value="?" class="button"  onClick="callPractSearchQuery(this,'<%=facilityid %>',document.Visit_Details_Template.practitioner_desc)"  >
		   	 </td>	
             <input type="hidden" name="practitioner_code" id="practitioner_code" value="">
			 <input type="hidden" name="visit_type_code" id="visit_type_code" value="">
			 </tr>
		
			 <tr>
              <td width='15%' class='label'><fmt:message key="eOP.OtherResource.label" bundle="${op_labels}"/></td>
				
			 <td width='40%' class='fields' cellpadding='4'  >
			 <select name="other_res_type_desc" id="other_res_type_desc" onChange='clearOthResource(this);'>
			 <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label"  bundle="${common_labels}"/> --------&nbsp;</option>
             <%if(other_res_class.equals("E")){%>
			 <option value='E' selected ><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
            <option value='O'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
			 <%} else if(other_res_class.equals("O")){%>
			  <option value='E'  ><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
            
			 <option value='O' selected ><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
			<%}else{ %>
			 <option value='E'  ><fmt:message key='Common.equipment.label' bundle='${common_labels}'/></option>
            <option value='O' ><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
			
			 <%}%>
			 </select> <INPUT TYPE="text" name="other_res_desc" id="other_res_desc" value="<%=other_resource_id%>" onBlur="onBlurotherResourceLookUp('<%=facilityid %>',document.Visit_Details_Template.other_res_desc)"><input type="button" name="other_res_btn" id="other_res_btn" value="?" class="button"  onClick="otherResourceLookUp('<%=facilityid %>',document.Visit_Details_Template.other_res_desc)">
		   	 </td>	
             <td width='15%' class='label'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
				 
			 <td width='30%' class='fields' cellpadding='4'  >
			 <INPUT TYPE="text" name="order_cat_desc" id="order_cat_desc" value="<%=order_catlog_desc%>" onBlur="onBlurCallCatalogSearch('<%=facilityid %>',document.Visit_Details_Template.order_cat_desc)"><input type="button" name="order_cat_btn" id="order_cat_btn" value="?" class="button"  onClick="CallCatalogSearch('<%=facilityid %>',document.Visit_Details_Template.order_cat_desc)">
		   		</td>               	
			   <input type="hidden" name="other_res_code" id="other_res_code" value="">
			   <input type="hidden" name="order_cat_code" id="order_cat_code" value="">
			 </tr>
			 </table>
			<table border='0' cellpadding='3' cellspacing='0' width='90%'>
           <tr>
			 <td width='15%' class='label'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
			  
			 <td class='fields' colspan='3' cellpadding='4' ><INPUT TYPE="text" name="reason_desc" id="reason_desc" size='55'  value="<%=contact_reason_desc%>" onBlur="onBlurCallContactReasonSearch('<%=facilityid %>',document.Visit_Details_Template.reason_desc)"><input type="button" name="reason_btn" id="reason_btn" value="?" class="button"  onClick="CallContactReasonSearch('<%=facilityid %>',document.Visit_Details_Template.reason_desc)">
		   		<input type="hidden" name="reason_code" id="reason_code" value="">
			  </td>	
              <% if(fnval.equals("modify")){ %>
			 <script>
			 var room_num="<%=room_num%>";
			 var service_code="<%=service_code%>";
			 var subservice_code="<%=subservice_code%>";
			 var  visit_type_code="<%=visit_type_code%>";
			 var contact_reason_code="<%=contact_reason_code%>";
			 var order_catlog_code="<%=order_catlog_code%>";
			 var practitioner_code="<%=practitioner_code%>";
			 var	other_resource_code="<%=other_resource_code%>";	
			 var locn_code="<%=locn_code%>";	
			 document.forms[0].room_desc.value=room_num;
			 document.forms[0].service_desc.value=service_code;
			 document.forms[0].sub_service_desc.value=subservice_code;
			 document.forms[0].visit_type_desc.value=visit_type_code;
			// document.forms[0].other_res_type_desc.value=other_resource_id;
			 document.forms[0].location_code.value=locn_code;
		     document.forms[0].practitioner_code.value=practitioner_code;
			 document.forms[0].other_res_code.value=other_resource_code;
			 document.forms[0].order_cat_code.value=order_catlog_code;
			 document.forms[0].reason_code.value=contact_reason_code;
			
			 
			 </script>
			 <%}%>
			 <input type="hidden" name="locale" id="locale" value="<%=locale%>">
			 <!-- <input type="hidden" name="function" id="function" value="<%=fnval%>"> -->
			 <input type="hidden" name="function_name" id="function_name" value="<%=fnval%>">
			 <input type="hidden" name="open_pract_yn" id="open_pract_yn" value="<%=open_to_all_pract_yn%>">
			 </tr>
						 
	        </table>
            </div>
            
			
			
			</form>
          
			<%  }catch(Exception e) { 
				out.println(e.toString());
				e.printStackTrace();
				}
         finally
		  {
				ConnectionManager.returnConnection(con,request);	
	     	}
			%>
			</body>
           </html>

