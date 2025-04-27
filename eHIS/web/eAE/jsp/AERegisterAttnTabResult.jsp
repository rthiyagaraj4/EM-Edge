<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eAE/js/AERegisterAttn.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
        Connection con               = null;
    	PreparedStatement pstmt		 = null;
        ResultSet rset               = null ;

		String remarks				 = "";

		try{
			    request.setCharacterEncoding("UTF-8");
                con                  = ConnectionManager.getConnection(request);
%>
	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="ae_reg_attn_result_form" id="ae_reg_attn_result_form"  method="post" target="messageFrame">
	   <table border="0" cellpadding="0" cellspacing="0" align='center' width='90%'>
		  <a name="tab1" ></a>
		  <table width='100%' cellpadding='0' cellspacing='0' BORDER='0'><tr><td width='1%' class='BODYCOLORFILLED'>&nbsp;</td><td width='32%' class='BODYCOLORFILLED'>
            <a align='left' href="javascript:tab1.scrollIntoView();"><img  src="/../../eAE/images/arrival.gif" border=0></a><a align='left' href="javascript:tab2.scrollIntoView();"><img  src="../../eAE/images/Related Contacts_click.gif" border=0></a>
            </td><td width='56%' class='BODYCOLORFILLED'>&nbsp;</td></tr></table>	      
         </table>
	   <table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
	      <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="Common.ModeofArrival.label" bundle="${common_labels}"/></td>
  		      <td class='LABEL' align='left' width='30%'>&nbsp;
 				   <select name='location' id='location'>
					    <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                   </select>
				   <img src='../../eCommon/images/mandatory.gif' align='center'></img>
              </td>
			  <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="Common.broughtdead.label" bundle="${common_labels}"/></td>
  		      <td class='LABEL' align='left' width='15%'>&nbsp;
 			       <input type='checkbox'  name="brought_dead" id="brought_dead"  value='' >
              </td>
		  	  <td class='label' width='5%'>&nbsp;</td>
		  </tr> 
          <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.CaseofMLC.label" bundle="${ae_labels}"/></td>
			  <td class='LABEL' align='left' width='30%'>&nbsp;
 			       <input type='checkbox'  name="brought_dead" id="brought_dead"  value='' >
              </td>
			  <td class='LABEL' align='RIGHT' width='20%'><input type="button" name="mlc_details" id="mlc_details" class=BUTTON value="MLC Details" onClick="mlc_details()">
		      </td>
  		      <td class='LABEL' align='left' width='15%'>&nbsp;
			  <td class='label' width='5%'>&nbsp;</td>
		  </tr>
          <th align='left' colspan='6'><fmt:message key="eAE.Escort.label" bundle="${ae_labels}"/></th>
           <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><b><fmt:message key="eAE.Escort.label" bundle="${ae_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></b></td>
			  <td class='LABEL' align='left' width='30%'>&nbsp;
				   <input type='radio' name='escort_type' id='escort_type' value="N" ><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/>
              </td>
			  <td class='LABEL' align='left' width='20%'>
			       <input type='radio' name='escort_type' id='escort_type' value="P" ><fmt:message key="Common.police.label" bundle="${common_labels}"/>
              </td>
  			  <td class='LABEL' align='left' width='15%'>
				   <input type='radio' name='escort_type' id='escort_type' value="O" ><fmt:message key="Common.others.label" bundle="${common_labels}"/>
			  </td>
			  <td class='label' width='5%' >&nbsp;</td>
          </tr> 
		 <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.NameofEscortService.label" bundle="${ae_labels}"/></td>
  		      <td class='LABEL' align='left' width='30%'>&nbsp;
 				   <input type='text'  name="name_of_escort" id="name_of_escort"  value='' maxLength='16' size='16' >
		      </td>
			  <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.Relation.label" bundle="${ae_labels}"/></td>
  		      <td class='LABEL' align='left' width='15%'>&nbsp;
 			      <select name='visit_type' id='visit_type'>
				     <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  </select>
              </td>
		      <td class='label' width='5%'>&nbsp;</td>
	      </tr>	
		  <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.AddrofEscortAmbulanceService.label" bundle="${ae_labels}"/></td>
  		      <td class='LABEL' align='left' width='30%' colspan='3'>&nbsp;
 				   <input type='text'  name="address_of_escort" id="address_of_escort"  value='' maxLength='25' size='25' >
		      </td>
			  <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td>
	      </tr>	
		  <tr>
		      <td class='label' width='5%' colspan='2'>&nbsp;</td>
  		      <td class='LABEL' align='left' width='30%' colspan='3'>&nbsp;
 				   <input type='text'  name="address_of_escort1" id="address_of_escort1"  value='' maxLength='40' size='40' >
		      </td>
			  <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td>
	      </tr>	
		  <tr>
		      <td class='label' width='5%' colspan='2'>&nbsp;</td>
  		      <td class='LABEL' align='left' width='20%' colspan='3'>&nbsp;
 				   <input type='text'  name="address_of_escort2" id="address_of_escort2"  value='' maxLength='40' size='40' >
		      </td>
			  <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td>
	      </tr>	
		  <tr>
		      <td class='label' width='5%' colspan='2'>&nbsp;</td>
  		      <td class='LABEL' align='left' width='20%' colspan='3'>&nbsp;
 				   <input type='text'  name="address_of_escort3" id="address_of_escort3"  value='' maxLength='40' size='40' >
		      </td>
			  <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td>
	      </tr>	
		  <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.PostalCodeNo.label" bundle="${ae_labels}"/></td>
  		      <td class='LABEL' align='left' width='30%'>&nbsp;
 				   <input type='text'  name="postal_code_no" id="postal_code_no"  value='' maxLength='25' size='25' >
		      </td>
			  <td class='LABEL' align='RIGHT' width='10%' colspan='3'>&nbsp;</td>
	      </tr>	
		 <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.EscAmbulanceContNo.label" bundle="${ae_labels}"/></td>
  		      <td class='LABEL' align='left' width='30%'>&nbsp;
 				   <input type='text'  name="ambulance_contact_no" id="ambulance_contact_no"  value='' maxLength='25' size='25' >
		      </td>
			  <td class='LABEL' align='RIGHT' width='10%' colspan='3'>&nbsp;</td>
	      </tr>	
		  <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="eAE.VehicleRegNo.label" bundle="${ae_labels}"/></td>
  		      <td class='LABEL' align='left' width='30%'>&nbsp;
 				   <input type='text'  name="motor_vehicle_reg_no" id="motor_vehicle_reg_no"  value='' maxLength='25' size='25' >
		      </td>
			  <td class='LABEL' align='RIGHT' width='10%' colspan='3'>&nbsp;</td>
	      </tr>	
		  <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='20%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
  		      <td class='LABEL' align='left' width='30%' colspan='3'>&nbsp;
 				   <textarea name='remarks' cols='60' rows='3' align='left'  onKeyPress="checkMaxLimit(this,2000);" ><%=remarks%></textarea>
		      </td>
			  <td class='LABEL' align='RIGHT' width='10%' >&nbsp;</td>
	      </tr>	
       </table>

	    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
   
       <a name="tab2"></a> 
       <table width='100%' cellpadding='0' cellspacing='0' BORDER='0'><tr><td width='1%' class='BODYCOLORFILLED'>&nbsp;</td><td width='32%' class='BODYCOLORFILLED'>
      <a align ='left' href="javascript:tab1.scrollIntoView();" onFocus="javascript:tab2.scrollIntoView();"><img  src="../../eAE/images/arrival_click.gif" border=0></a><a align='left' href="javascript:tab1.scrollIntoView();"><img  src="../../eAE/images/Related Contacts.gif" border=0></a>
      </td><td width='56%' class='BODYCOLORFILLED'>&nbsp;</td></tr></table>
      <table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
      <tr>
		<th align='left' colspan='4'><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></th>
		<th align='left' colspan='2'><fmt:message key="Common.employer.label" bundle="${common_labels}"/></th>
        <th align='left' colspan='2'><fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></th>
      </tr>
	  <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='10%'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
  		      <td class='LABEL' align='left' width='20%'>&nbsp;
 				   <select name='relationship' id='relationship'>
					    <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                   </select>
              </td>
			  <td class='LABEL' align='RIGHT' width='10%' colspan='5'>&nbsp;</td>
       </tr>
	  <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='10%'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
  		      <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="name" id="name"  value='' maxLength='25' size='25' >
              </td>
  		      <td class='LABEL' align='left' width='20%'>&nbsp;</td>
			  <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="name1" id="name1"  value='' maxLength='25' size='25' >
              </td>
			  <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td>
		      <td class='LABEL' align='left' width='20%'>&nbsp;</td>
			  <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="name2" id="name2"  value='' maxLength='25' size='25' >
              </td>
			  <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td>
	  </tr>
	  <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='10%'><fmt:message key="Common.JobTitle.label" bundle="${common_labels}"/></td>
  		      <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="job_title" id="job_title"  value='' maxLength='25' size='25' >
              </td>
  		      <td class='LABEL' align='left' width='20%'>&nbsp;</td>
			  <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="job_title1" id="job_title1"  value='' maxLength='25' size='25' >
              </td>
			  <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td>
		      <td class='LABEL' align='left' width='20%'>&nbsp;</td>
			  <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="name2" id="name2"  value='' maxLength='25' size='25' >
              </td>
			  <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td>
	  </tr>
	 <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='10%'><fmt:message key="Common.Address.label" bundle="${common_labels}"/></td>
  		      <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="rel_address" id="rel_address"  value='' maxLength='25' size='25' >
              </td>
  		      <td class='LABEL' align='left' width='20%'>&nbsp;</td>
			  <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="rel_address1" id="rel_address1"  value='' maxLength='25' size='25' >
              </td>
			  <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td>
	  </tr>
	  <tr>
		      <td class='LABEL' align='RIGHT' width='10%' colspan='2'>&nbsp;</td>
  		      <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="rel_address2" id="rel_address2"  value='' maxLength='25' size='25' >
              </td>
  		      <td class='LABEL' align='left' width='20%'>&nbsp;</td>
			  <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="rel_address3" id="rel_address3"  value='' maxLength='25' size='25' >
              </td>
			  <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td>
	  </tr>
	 <tr>
		      <td class='LABEL' align='RIGHT' width='10%' colspan='2'>&nbsp;</td>
  		      <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="rel_address4" id="rel_address4"  value='' maxLength='25' size='25' >
              </td>
  		      <td class='LABEL' align='left' width='20%'>&nbsp;</td>
			  <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="rel_address5" id="rel_address5"  value='' maxLength='25' size='25' >
              </td>
			  <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td>
	  </tr>
	 <tr>
		      <td class='LABEL' align='RIGHT' width='10%' colspan='2'>&nbsp;</td>
  		      <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="rel_address5" id="rel_address5"  value='' maxLength='25' size='25' >
              </td>
  		      <td class='LABEL' align='left' width='20%'>&nbsp;</td>
			  <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="rel_address6" id="rel_address6"  value='' maxLength='25' size='25' >
              </td>
			  <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td>
	  </tr>
	  <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='10%'><fmt:message key="eMP.postalcode.label" bundle="${mp_labels}"/></td>
  		      <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="postal_code" id="postal_code"  value='' maxLength='25' size='25' >
              </td>
  		      <td class='LABEL' align='left' width='20%'>&nbsp;</td>
			  <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="postal_code1" id="postal_code1"  value='' maxLength='25' size='25' >
              </td>
			  <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td>
	  </tr>
	  <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='10%'><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
  		      <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="country" id="country"  value='' maxLength='25' size='25' >
              </td>
  		      <td class='LABEL' align='left' width='20%'>&nbsp;</td>
			  <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="country1" id="country1"  value='' maxLength='25' size='25' >
              </td>
			  <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td>
	  </tr>
	  <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='10%'><fmt:message key="Common.telephone.label" bundle="${common_labels}"/>(<fmt:message key="Common.residence.label" bundle="${common_labels}"/>)</td>
  		      <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="telephone" id="telephone"  value='' maxLength='25' size='25' >
              </td>
  		      <td class='LABEL' align='left' width='20%'><fmt:message key="Common.telephone.label" bundle="${common_labels}"/></td>
			  <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="telephone1" id="telephone1"  value='' maxLength='25' size='25' >
              </td>
			  <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td> 
	  </tr>
	  <tr>
		      <td class='label' width='5%'>&nbsp;</td>
		      <td class='LABEL' align='RIGHT' width='10%'>(<fmt:message key="Common.office.label" bundle="${common_labels}"/>)</td>
			  <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="telephone_office" id="telephone_office"  value='' maxLength='25' size='25' >
              </td>
  		      <td class='LABEL' align='right' width='20%'>fmt:message key="Common.telephone.label" bundle="${common_labels}"/></td>
			  <td class='LABEL' align='left' width='20%'>&nbsp;
					<input type='text'  name="telephone_office1" id="telephone_office1"  value='' maxLength='25' size='25' >
              </td>
			  <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td>
	  </tr> 
     <tr>
             <td class='label' width='5%'>&nbsp;</td>
             <td class='label' align='right' width='10%' colspan='2'>&nbsp;</td>
             <td class='label' align='right' width='20%'><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td>
             <td class='label' align='left' width='20%'>
 					<input type='text'  name="rel_occupation" id="rel_occupation"  value='' maxLength='25' size='25' >
             </td>
			 <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td>
	 </tr>  
	 <tr>
             <td class='label' width='5%'>&nbsp;</td>
             <td class='label' align='right' width='10%' colspan='2'>&nbsp;</td>
             <td class='label' align='right' width='20%'><fmt:message key="eAE.EID.label" bundle="${ae_labels}"/></td>
             <td class='label' align='left' width='20%'>
 					<input type='text'  name="rel_eid" id="rel_eid"  value='' maxLength='25' size='25' >
             </td>
			 <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td>
	 </tr>
	 <tr>
             <td class='label' width='5%'>&nbsp;</td>
             <td class='label' align='right' width='10%' colspan='2'>&nbsp;</td>
             <td class='label' align='right' width='20%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
             <td class='label' align='left' width='20%'>
 					<input type='text'  name="rel_status" id="rel_status"  value='' maxLength='25' size='25' >
             </td>
			 <td class='LABEL' align='RIGHT' width='10%'>&nbsp;</td>
	 </tr>
				
       </table>
	  <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>	  
	 </form>
	 </body>
<%
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
        if(pstmt!=null)  pstmt.close();
		if(rset!=null)  rset.close();
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>	



	

	   

