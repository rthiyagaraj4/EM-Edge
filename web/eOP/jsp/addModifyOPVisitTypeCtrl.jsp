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
<script  src='../../eOP/js/VisitTypeControl.js'   language='javascript' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>


  <%
       try{	
		   
         con=ConnectionManager.getConnection(request);
         Statement stmt=null;
         ResultSet rset=null ;
       
	   String locale ="";
       String fnval="modify";
	   String clinicdesc="";
	   String servicedesc="";
	   String noof_visits="";
	   String  dura_for_follow="";
	   String cliniccode="";
	   String sql="";
        String servicecode="";
	     //String flag=""; 
	  
	  String facilityid  = (String) session.getValue("facility_id");	 
	   locale = (String)session.getValue("LOCALE");
        cliniccode=request.getParameter("clinic_code");
	   servicecode=request.getParameter("service_code");
	 
	 
	  if(cliniccode!=null )
       {
		 try{
		 	 
		 fnval="modify";
		 stmt=con.createStatement();
			/* This query selects all the records from the table op_param_for_facy_service_vw for the corresponding operating facility and service. --- Srijagadeesh */

			sql="select CLINIC_CODE, op_get_desc.op_clinic(FACILITY_ID, CLINIC_CODE, '"+locale+"','1') clinic_desc, SERVICE_CODE, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"',2) service_desc, NO_OF_FOLLOW_UP_VISITS_ALLOWED, DUR_FOR_FOLLOW_UP_VSTS_IN_DAYS from op_visit_type_control where FACILITY_ID = '"+facilityid+"' and CLINIC_CODE ='"+cliniccode+"' and SERVICE_CODE ='"+ servicecode+"' " ;
	       	rset=stmt.executeQuery(sql);

			if(rset.next())
			{
				clinicdesc=rset.getString("clinic_desc");
												
				if(clinicdesc==null) clinicdesc="";
				
				servicedesc=rset.getString("service_desc");
	           	
				if(servicedesc==null)servicedesc="";
				
	      noof_visits=rset.getString("NO_OF_FOLLOW_UP_VISITS_ALLOWED")==null?"":rset  .getString("NO_OF_FOLLOW_UP_VISITS_ALLOWED");
          dura_for_follow=rset.getString("DUR_FOR_FOLLOW_UP_VSTS_IN_DAYS")==null?"":rset.getString("DUR_FOR_FOLLOW_UP_VSTS_IN_DAYS");
	
			}
	        //else
				//out.println("no resultset");
		}catch(Exception e) { out.println(e.toString());}
		finally
		{
			if (stmt != null) stmt.close();
	        if (rset != null) rset.close();
		}
        }else 
	    {
        fnval="insert";
	    }
	  
       %>
       
       
        

    </head>
   <body  onLoad="FocusFirstElement()" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();' >
	 <form name='Add_Visit_Contl' id='Add_Visit_Contl' action='../../servlet/eOP.OPVisitTypeControlServlet' method='post' target='messageFrame'>
     <BR><BR><BR><BR><BR><BR><BR><BR>
	      <div align='center'>
	
	 <table border='0' cellpadding='3' cellspacing='0' width='60%'>
	 <tr>
		<td class='label'>&nbsp;</td>
		<td class='label'>&nbsp;</td>
	 </tr>
	 <tr>
	 <td width='30%' class='label'>
			 <fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>
			 <%  if(fnval.equals("modify"))
                        {%>
			  <td width='40%' class='fields' colspan='3'>			
			 <INPUT TYPE="text" name="clinic_desc" id="clinic_desc" value="<%=clinicdesc%>"  disabled onBlur="onBlurgetCli('<%=facilityid%>',document.Add_Visit_Contl.clinic_desc)"> 
		      <img align='center' src='../../eCommon/images/mandatory.gif'  id='otherresourceGIF'></img>
		   	  <input type="hidden"  name="clinic_code1" id="clinic_code1" value="<%=cliniccode%>">	
			  </td>	
					
			  <% }
			 else
			 { %>
			 
			 <td width='50%' class='fields' colspan='3'>
			
			 <INPUT TYPE="text" name="clinic_desc" id="clinic_desc" value="<%=clinicdesc%>"  onBlur="onBlurgetCli('<%=facilityid %>',document.Add_Visit_Contl.clinic_desc)">
			 <input type="button" name="clinic_btn" id="clinic_btn" value="?" class="button"  onClick="getClinic('<%=facilityid %>',document.Add_Visit_Contl.clinic_desc)"><img align='center' src='../../eCommon/images/mandatory.gif'  id='otherresourceGIF' ></img>
		   		<input type="hidden" name="clinic_code" id="clinic_code" value="<%=cliniccode%>">
			  </td>	
						
			  <%  } %></tr>
			<tr>
			<td class='label' width='40%'    ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			
			<%  if(fnval.equals("modify"))
                        {%>
                     <td width='40%' class='fields' colspan='3'>
					 
					 <input type='text' name="service" id="service"  size=20 maxlength=30 value="<%=servicedesc%>"   disabled ><img align='center'  src='../../eCommon/images/mandatory.gif'></img>
                     
				<input type='hidden' name="service_desc" id="service_desc"  value="<%=servicecode%>">                      
                  				 
					 </td>
										 				 
					 <%}
			              else
			           { %>
			 
			 <td width='50%' class='fields' colspan='3'>
			 <select name="service" id="service">
			 <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label"  bundle="${common_labels}"/> --------&nbsp;</option>
             </select><img align='center'
               src='../../eCommon/images/mandatory.gif'></img>
                </td>
                    <input type="hidden" name="service_code" id="service_code" value="">					
					<% } %>  
			   
			   </tr>                 
			  
				 <tr>
                 <td width='30%' class='label'><fmt:message key="eOP.NoofFollowUpVisitAllowed.label" bundle="${op_labels}"/></b></td>
			 <td width='40%' class='fields' colspan='3'>
			 <input type="text" name="no_ofvisit_allow" id="no_ofvisit_allow" value="<%=noof_visits%>" maxlength=6      onKeyPress='return(ChkNumberInput(this,event,0))'
		      onBlur="CheckNum(this)"  ><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
            </tr>
            <tr>
               <td width='40%' class='label'><fmt:message key="eOP.FollowUpVisitDuratin.label" bundle="${op_labels}"/></td>
			<td width='40%' class='fields' colspan='3'>
		 <input type="text" name="foll_visit_dura" id="foll_visit_dura" value="<%=dura_for_follow%>"  maxlength=6  onKeyPress='return(ChkNumberInput(this,event,0))'  onBlur="CheckNum(this)"><img align='center' src='../../eCommon/images/mandatory.gif'></img>
			 <input type='hidden' name='locale' id='locale' value='<%=locale%>'>
			 <input type='hidden' name='function' id='function' value='<%=fnval%>'>
			 </td>
         </tr>
			
			
			 <tr>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
			</tr>
	        </table>
            </div>
            </form>
          
<%  
	} catch(Exception e) { 
		out.println(e.toString());
	} finally {
		ConnectionManager.returnConnection(con,request);
	}
	%>
</body>
</html>

