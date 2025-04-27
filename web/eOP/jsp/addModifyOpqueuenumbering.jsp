<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
request.setCharacterEncoding("UTF-8");

request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<!-- <script src='../../eCommon/js/GenderGroup.js'  language='javascript'></script>-->
<script src='../../eOP/js/Opqueuenumbering.js'  language='javascript'></script>
<script src='../../eOP/js/OPPractitionerComponent.js'  language='javascript'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
    String loctype="";
    String loccode="";
    String pracid="";
	String roomid="";
	/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	String room_desc="";
	/*CRF end SS-CRF-0010 [IN034516]*/
    String sourceid="";
    String loginfacilityid="";
    String fnval = "modify";
    String allow_appt_yn="";                                     
	String allow_walk_in_yn="";
	String allow_referral_yn="";
	StringBuffer sql1=new StringBuffer();


    Connection conn = null;
    try{
        conn=ConnectionManager.getConnection(request);

		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = "";

    Statement stmt1 = null;
    Statement stmt2 = null;
    loginfacilityid  =  (String) session.getValue( "facility_id" ) ;

    ResultSet rset1=null;
    ResultSet rset2=null;

    loctype=request.getParameter("locn_type");
    loccode=request.getParameter("locn_code");
    pracid=request.getParameter("practitioner_id");
    roomid=request.getParameter("room_num");
    sourceid = request.getParameter("source");
			
	/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
      room_desc=request.getParameter("room_desc");
	  if(room_desc==null) room_desc ="";
	/*CRF end SS-CRF-0010 [IN034516]*/
	if(roomid==null) roomid = "";
              
%>
</head>

	
 <%try
	 {
		 sql = "select ALLOW_APPT_YN,ALLOW_WALK_IN_YN, ALLOW_REFERRAL_YN from op_clinic where facility_id=? and clinic_code=?";
		 pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1,loginfacilityid);
		 pstmt.setString(2,loccode);
         rset1 = pstmt.executeQuery();

         if( rset1 != null )
          {
         while( rset1.next() )
		  {allow_appt_yn=rset1.getString("ALLOW_APPT_YN")==null?"N":rset1.getString("ALLOW_APPT_YN");
		   if(!allow_appt_yn.equals("Y"))allow_appt_yn="disabled";	
		   allow_walk_in_yn=rset1.getString("ALLOW_WALK_IN_YN")==null?"N":rset1.getString("ALLOW_WALK_IN_YN");
		    if(!allow_walk_in_yn.equals("Y"))allow_walk_in_yn="disabled";	   allow_referral_yn=rset1.getString("ALLOW_REFERRAL_YN")==null?"N":rset1.getString("ALLOW_REFERRAL_YN");
	        if(!allow_referral_yn.equals("Y"))allow_referral_yn="disabled";							 
			}
		    
			}
		}catch(Exception e) { out.println(e.toString());}
		finally
		{
		         if (pstmt != null) pstmt.close();
		        if (rset1 != null) rset1.close();
			}

if(sourceid.equals("Insert"))
  {%>
			
	<!-- opqueuenumbering_form is being called when new queue numbering control has to be created --- Srijagadeesh. -->	

	<body OnMouseDown='CodeArrest()' onLoad="Focusing('locn_type')" onKeyDown = 'lockKey();' >
        <form name='opqueuenumbering_form' id='opqueuenumbering_form' action='../../servlet/eOP.OPQueuenumberingServlet' method='post' target='messageFrame'>
        <tr>
<%
		fnval = "insert";
		    %><BR><BR><BR>
             <div align='center'>
                <table border='0' cellpadding='6' cellspacing='0' width='65%'>
                <tr>
                  <td width="35%" class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
                  <td width="65%" class='fields' colspan="3"><select name="locn_type" id="locn_type" onChange="disablePract()">
                  <OPTION VALUE=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
				bundle="${common_labels}"/> --------&nbsp;</OPTION>
<%				    
					try
					{stmt1 = conn.createStatement();
            			rset1 = stmt1.executeQuery( "Select short_desc,locn_type from am_care_locn_type where care_locn_type_ind in ('C','E') and locn_type in('C','E') and SYS_USER_DEF_IND='S' order by short_desc");

		                if( rset1 != null )
				        {
							 while( rset1.next() )
							 {
			                     String loctype1 = rset1.getString( "locn_type" ) ;
						         String locdesc1 = rset1.getString( "short_desc" ) ;

			                     if ( loctype1.equals( loctype ) )
								     out.println( "<option value='" + loctype1 + "' SELECTED > "+ locdesc1 +"</option>");
								else
			                         out.println( "<option value='" + loctype1 + "' >" + locdesc1 +"</option>") ;
						     }
						 }
					}catch(Exception e) { out.println(e.toString());}
					finally
					{
		                if (stmt1 != null) stmt1.close();
				        if (rset1 != null) rset1.close();
					}

%>
                </select><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
			</tr>
        	<tr>
                  <td width="35%" class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
                  <td width="65%" class='fields' colspan="3">
				  <INPUT TYPE="text" name="locn_code1" id="locn_code1"  onBlur="onBlurgetLoc('<%=loginfacilityid%>',document.forms[0].locn_type.value,document.forms[0].locn_code1);PopulatePractitioner()"><input type="button" name="qloc_butt" id="qloc_butt" value="?" class="button" onClick="getLocn('<%=loginfacilityid%>',document.forms[0].locn_type.value,document.forms[0].locn_code1);PopulatePractitioner()" ><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
				  <input type="hidden" name="locn_code" id="locn_code">
				  

				  <!-- 
				  <select name="locn_code" id="locn_code" onChange="PopulatePractitioner()">
                  <OPTION VALUE='*ALL'>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
					bundle="${common_labels}"/> --------&nbsp;</OPTION>
                  </select>
				  -->
				  
	        </tr>
            <tr>
                  <td width="35%" class="label"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
                  <td width="65%" class='fields' colspan="3"><input type="text" name="practitioner_name" id="practitioner_name" value="" size="30" maxlength="30" onBlur="onBlurCallPractitionerSearch(document.forms[0].pname,practitioner_name);" readOnly ><input type="button" disabled name="pname" id="pname" value="?" class="button" onClick="callPractSearch(this,practitioner_name);" readOnly ><img align='center' src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id='practitionerMandatoryGIF' ></img>
				  <input type="hidden" name="practitioner_id" id="practitioner_id" value=""></td>
            </tr>
		    <tr> <!--  Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516]  -->
                  <td width="35%" class="label"><fmt:message key="Common.room.label" bundle="${common_labels}"/></td>
				  <!-- CRF end SS-CRF-0010 [IN034516] -->
                  <td width="65%" class='fields' colspan="3"><select name="room_no1" id="room_no1" >
                  <OPTION VALUE='*ALL'>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
					  bundle="${common_labels}"/> --------&nbsp;
				   </select><img align='center' src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id='roomGIF' ></img>
				  <input type="hidden" name="room_id" id="room_id" value=""></td>
            </tr>
            <tr>
              <td width="35%" class="label"><fmt:message key="eOP.OtherResource.label" bundle="${op_labels}"/></td>
               <!-- <input type='hidden' name='locn_code' id='locn_code' value='<%=loccode%>'> -->
               <td width='65%' class='fields' colspan='3'><select name="other_resource" id="other_resource" onChange="selectResource(this)" disabled>
               <OPTION VALUE='*'>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
				   bundle="${common_labels}"/> --------&nbsp;
               <OPTION VALUE='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
                <OPTION VALUE='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/>
                 </select>&nbsp;/&nbsp;<select name="room_no" id="room_no" disabled>
                  <OPTION VALUE='*ALL'>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
				   bundle="${common_labels}"/> --------&nbsp;
                                  
                  </select><img align='center' src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id='otherresourceGIF' ></img></td></tr>
				</table>
                <table border='0' cellpadding='0' cellspacing='0' width='65%'>
					  <th class='columnheader' colspan='4' align="left" ><fmt:message key="eOP.AssignedQueues.label" bundle="${op_labels}"/></th>
				  <tr>
				</table>
				<table border='0' cellpadding='6' cellspacing='0' width='65%'>
				<tr>	
				  <td width="35%" class="label"><fmt:message key="eOP.Walkins.label" bundle="${op_labels}"/></td>
				  <td width='65%' class='fields' colspan='3' ><select name="walk_in" id="walk_in" <%=allow_walk_in_yn%> onChange="" >
				  <OPTION VALUE=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
					  bundle="${common_labels}"/> --------&nbsp;</OPTION>
				  <%                                  
                  try
                   {
                                        
                        stmt2 = conn.createStatement();
                        rset2 = stmt2.executeQuery("Select QUEUE_ID, QUEUE_DESCRIPTION from OP_QUEUE_SERIES where WALK_IN_APPL_YN='Y' and eff_status='E'");
                        if( rset2 != null )
                        {
                          while( rset2.next() )
                         {
                            String queue_id = rset2.getString( "QUEUE_ID" ) ;
                            String queue_desc = rset2.getString( "QUEUE_DESCRIPTION" ) ;
                            out.println( "<option value='"+queue_id+ "' > "+ queue_desc +"</option>");
                          }
                        }
                       }catch(Exception e) { out.println(e.toString());}
                        finally
                        {
                             if (stmt2 != null) stmt2.close();
                             if (rset2 != null) rset2.close();
                        }

            %>
                  </select>
                  
            </tr>	

         <tr>
        <td width="35%" class="label"><fmt:message key="Common.referral.label" bundle="${common_labels}"/></td>
        <td width='65%' class='fields' colspan='3' ><select name="referral" id="referral" <%=allow_referral_yn%> onChange="" >
        <OPTION VALUE=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
			 bundle="${common_labels}"/> --------&nbsp;</OPTION>
           <%       

                           
                  try
                   {
                                        
                        stmt2 = conn.createStatement();
                        rset2 = stmt2.executeQuery("Select QUEUE_ID, QUEUE_DESCRIPTION from OP_QUEUE_SERIES where  REFERRAL_APPL_YN='Y'  and eff_status='E'");
                        if( rset2 != null )
                        {
                          while( rset2.next() )
                         {
                            String queue_id = rset2.getString( "QUEUE_ID" ) ;
                            String queue_desc = rset2.getString( "QUEUE_DESCRIPTION" ) ;
                            out.println( "<option value='"+queue_id+ "' > "+ queue_desc +"</option>");
                          }
                        }
                       }catch(Exception e) { out.println(e.toString());}
                        finally
                        {
                             if (stmt2 != null) stmt2.close();
                             if (rset2 != null) rset2.close();
                        }

            %>
                  </select>
                  
            </tr>
			<tr>
        <td width="35%" class="label"><fmt:message key="Common.Appointment.label" bundle="${common_labels}"/></td>
        <td width='65%' class='fields' colspan='3'><select name="appointment" id="appointment" onChange=""  <%=allow_appt_yn%>>
        <OPTION VALUE=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
				bundle="${common_labels}"/> --------&nbsp;</OPTION>
           <%  
                                
                  try
                   {
                                        
                        stmt2 = conn.createStatement();
                        rset2 = stmt2.executeQuery("Select QUEUE_ID, QUEUE_DESCRIPTION from OP_QUEUE_SERIES where  APPT_APPL_YN='Y' and eff_status='E'");
                        if( rset2 != null )
                        {
                          while( rset2.next() )
                         {
                            String queue_id = rset2.getString( "QUEUE_ID" ) ;
                            String queue_desc = rset2.getString( "QUEUE_DESCRIPTION" ) ;
                            out.println( "<option value='"+queue_id+ "' > "+ queue_desc +"</option>");
                          }
                        }
                       }catch(Exception e) { out.println(e.toString());}
                        finally
                        {
                             if (stmt2 != null) stmt2.close();
                             if (rset2 != null) rset2.close();
                        }

            %>
                  </select>
                  
            </tr>
				
		  <%
  }
  else
  {
 %>

	<!-- query_form is being called when existing Queue Numbering control has to be altered --- Srijagadeesh. -->

 <body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement();ClearMsg()' onKeyDown = 'lockKey();'> 
	<form name='query_form' id='query_form' action='../../servlet/eOP.OPQueuenumberingServlet' method='post' target='messageFrame'>
		<BR><BR><BR>
        <div align='center'>
	   		<table border='0' cellpadding='6' cellspacing='0' width='65%'>
				<tr>
                <td width="35%" class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
<%          try
			{String walkin_q_id=request.getParameter("WALK_IN_QUEUE_ID")==null?"":request.getParameter("WALK_IN_QUEUE_ID");
					String ref_q_id=request.getParameter("REFERRAL_QUEUE_ID")==null?"":request.getParameter("REFERRAL_QUEUE_ID");
					String appt_q_id=request.getParameter("APPT_QUEUE_ID")==null?"":request.getParameter("APPT_QUEUE_ID");
					String other_resource=request.getParameter("OTHER_RES_CLASS")==null?"":request.getParameter("OTHER_RES_CLASS");
					
					String other_resource_desc=request.getParameter("OTHER_RESOURCE_DESC")==null?"":request.getParameter("OTHER_RESOURCE_DESC");
									
				sql1.append("Select locn_type_short_desc,OTHER_RESOURCE_ID ,OTHER_RESOURCE_DESC,locn_long_desc, practitioner_name,room_num,REFERRAL_QUEUE_ID,WALK_IN_QUEUE_ID,APPT_QUEUE_ID from op_queue_num_for_locn_vw where facility_id = ? and locn_type = ? and locn_code = ? and practitioner_id = ? and room_num ");
				
				if(roomid.equals(""))
					sql1.append(" is NULL ");
				else
					sql1.append(" = ? ");
				
				pstmt2 = conn.prepareStatement(sql1.toString());
				pstmt2.setString(1,loginfacilityid);
				pstmt2.setString(2,loctype);
				pstmt2.setString(3,loccode);
				pstmt2.setString(4,pracid);
				if(!roomid.equals(""))
				pstmt2.setString(5,roomid);
				rset2 = pstmt2.executeQuery();
					
				if(rset2.next())
                {
					ref_q_id=rset2.getString("REFERRAL_QUEUE_ID");
					if(ref_q_id == null) ref_q_id="";
					appt_q_id=rset2.getString("APPT_QUEUE_ID");
					if(appt_q_id == null) appt_q_id="";
					walkin_q_id=rset2.getString("WALK_IN_QUEUE_ID");
					if(walkin_q_id == null) walkin_q_id="";
%>
			<input type='hidden' name='locn_type' id='locn_type' value='<%=loctype%>'>
		    <td width='65%' class='fields' colspan='3'><input type='text' name='locn_type_short_desc' id='locn_type_short_desc' value='<%=rset2.getString("locn_type_short_desc")%>' size='15'maxlength='15' readonly><img align='center' src='../../eCommon/images/mandatory.gif'></img></td></tr>
			<tr>
                <td width="35%" class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<input type='hidden' name='locn_code' id='locn_code' value='<%=loccode%>'>
				<td width='65%' class='fields' colspan='3'><input type='text' name='locn_short_desc' id='locn_short_desc' value='<%=rset2.getString("locn_long_desc")%>' size='30' maxlength='30' readonly><img align='center' src='../../eCommon/images/mandatory.gif'></img></td></tr>

            <tr>
                <td width="35%" class="label"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<%
	            String  pr_name = rset2.getString("practitioner_name");
                if (pr_name == null) pr_name = "*"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
		%>
				<input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=pracid%>">
				<td width='65%' class='fields' colspan='3'><input type='text' name='practitioner_name' id='practitioner_name' value="<%=pr_name%>" size='30'maxlength='30' readonly></td></tr>


            <tr> <!--  Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516]  -->
                <td width="35%" class="label"><fmt:message key="Common.room.label" bundle="${common_labels}"/></td> <!-- CRF end SS-CRF-0010 [IN034516] -->
		<% 
	            String room_no = rset2.getString("room_num");
				if(room_no==null) room_no="";
				/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
				room_no=room_no+" "+room_desc;
				/*CRF end SS-CRF-0010 [IN034516]*/
		%>

				<input type='hidden' name='room_no1' id='room_no1' value='<%=roomid%>'>
				<td width='65%' class='fields' colspan='3'><input type='text' name='room_num' id='room_num' value='<%=room_no%>' size='30'maxlength='30' readonly></td> </tr>

            <tr>
	<td width="35%" class="label"><fmt:message key="eOP.OtherResource.label" bundle="${op_labels}"/></td>
	<td width='65%' class='fields' colspan='3' >
	<input type='text' name='other_resource_desc' id='other_resource_desc' value='<%=other_resource_desc%>' size='15'maxlength='15' readonly>&nbsp;&nbsp;&nbsp;/ 
	<input type=hidden name='other_resource' id='other_resource' value='<%=other_resource%>'>

	<%
	String other_resource_id = rset2.getString("OTHER_RESOURCE_ID");
	if(other_resource_id==null) other_resource_id="";
	 other_resource_desc = rset2.getString("OTHER_RESOURCE_DESC");
	if(other_resource_desc==null) other_resource_desc="";

		
	%>

	<input type='hidden' name='room_no' id='room_no' value='<%=other_resource_id%>' >
        <input type='text' name='room_no' id='room_no' value='<%=other_resource_desc%>' size='30'maxlength='30' readonly></td></tr>
	</table>
     <table border='0' cellpadding='0' cellspacing='0' width='65%'>
					  <th class='columnheader' colspan='4' align="left"><fmt:message key="eOP.AssignedQueues.label" bundle="${op_labels}"/></th>
	 </table>
	 <table border='0' cellpadding='6' cellspacing='0' width='65%'>
	 <td width="35%" class="label"><fmt:message key="eOP.Walkins.label" bundle="${op_labels}"/></td>
        <td width='65%' class='fields' colspan='3' ><select name="walk_in" id="walk_in" <%=allow_walk_in_yn%> onChange="" >
        <OPTION VALUE=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
		bundle="${common_labels}"/> --------&nbsp;</OPTION>
           <%                                  
                  try
                   {
                                        
                        stmt2 = conn.createStatement();
                        rset2 = stmt2.executeQuery("Select QUEUE_ID, QUEUE_DESCRIPTION from OP_QUEUE_SERIES where WALK_IN_APPL_YN='Y' and eff_status='E'");
                        if( rset2 != null )
                        {
                          while( rset2.next() )
                         {
                            String queue_id = rset2.getString( "QUEUE_ID" ) ;
                            String queue_desc = rset2.getString( "QUEUE_DESCRIPTION" ) ;
                             if(queue_id.equals(walkin_q_id))
							out.println( "<option value='"+queue_id+"' selected > "+ queue_desc +"</option>");else
                            out.println( "<option value='"+queue_id+ "' > "+ queue_desc +"</option>");
                          }
                        }
                       }catch(Exception e) { out.println(e.toString());}
                        finally
                        {
                             if (stmt2 != null) stmt2.close();
                             if (rset2 != null) rset2.close();
                        }

            %>
                  </select>
                  
            </tr>        
            <tr>
        <td width="35%" class="label"><fmt:message key="Common.referral.label" bundle="${common_labels}"/></td>
        <td width='65%' class='fields' colspan='3' ><select name="referral" id="referral" <%=allow_referral_yn%> onChange="" >
        <OPTION VALUE=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
				bundle="${common_labels}"/> --------&nbsp;</OPTION>
           <%       
                      
                  try
                   {
                                        
                        stmt2 = conn.createStatement();
                        rset2 = stmt2.executeQuery("Select QUEUE_ID, QUEUE_DESCRIPTION from OP_QUEUE_SERIES where  REFERRAL_APPL_YN='Y'  and eff_status='E'");
                        if( rset2 != null )
                        {
                          while( rset2.next() )
                         {
                            String queue_id = rset2.getString( "QUEUE_ID" ) ;
                            String queue_desc = rset2.getString( "QUEUE_DESCRIPTION" ) ;
                            if(queue_id.equals(ref_q_id))
							out.println( "<option value='"+queue_id+"' selected > "+ queue_desc +"</option>");else
                            out.println( "<option value='"+queue_id+ "' > "+ queue_desc +"</option>");
                          }
                        }
                       }catch(Exception e) { out.println(e.toString());}
                        finally
                        {
                             if (stmt2 != null) stmt2.close();
                             if (rset2 != null) rset2.close();
                        }

            %>
                  </select>
                  
            </tr>
			<tr>
        <td width="35%" class="label"><fmt:message key="Common.Appointment.label" bundle="${common_labels}"/></td>
        <td width='65%' class='fields' colspan='3' ><select name="appointment" id="appointment" onChange=""  <%=allow_appt_yn%>>
        <OPTION VALUE=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
				bundle="${common_labels}"/> --------&nbsp;</OPTION>
           <%  
                                
                  try
                   {
                                        
                        stmt2 = conn.createStatement();
                        rset2 = stmt2.executeQuery("Select QUEUE_ID, QUEUE_DESCRIPTION from OP_QUEUE_SERIES where  APPT_APPL_YN='Y' and eff_status='E'");
                        if( rset2 != null )
                        {
                          while( rset2.next() )
                         {
                            String queue_id = rset2.getString( "QUEUE_ID" ) ;
                            String queue_desc = rset2.getString( "QUEUE_DESCRIPTION" ) ;
                            if(queue_id.equals(appt_q_id))
							out.println( "<option value='"+queue_id+"' selected > "+ queue_desc +"</option>");else
                            out.println( "<option value='"+queue_id+ "' > "+ queue_desc +"</option>");
                          }
                        }
                       }catch(Exception e) { out.println(e.toString());}
                        finally
                        {
                             if (stmt2 != null) stmt2.close();
                             if (rset2 != null) rset2.close();
                        }

            %>
                  </select>
                  
            </tr>
			
		<%
            }
		
		sql1.setLength(0);

		   }catch(Exception e) { out.println(e.toString());}
		    finally
			{
		        if (stmt2 != null) stmt2.close();
		        if (pstmt2 != null) pstmt2.close();
				if (rset2 != null) rset2.close();
			}
  }
            
%>
		   </table>
        </div>

        <input type='hidden' name='function' id='function' value='<%=fnval%>'>
        <input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
        <input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value=''>
		<input type='hidden' name='res_class' id='res_class' value=''>
		 <input type='hidden' name='identifyPractitionerAtCheckIn' id='identifyPractitionerAtCheckIn' value='N'> 
		<input type='hidden' name='loginfacilityid' id='loginfacilityid' value='<%=loginfacilityid%>'>
<%
    }catch(Exception e){}
	finally
	{
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
%>
</form>
</body>
</html>

