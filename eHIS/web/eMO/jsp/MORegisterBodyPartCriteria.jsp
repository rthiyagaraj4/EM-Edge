<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
	 request.setCharacterEncoding("UTF-8");
     String facilityId=(String)session.getValue("facility_id");
	 String patient_id_length="";
     Connection con							= null;	 
	 PreparedStatement pstmt2=null;
	 ResultSet vrs=null;
	 String body_part_obtained_from="";
     String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	 String registration_no=request.getParameter("registration_no")==null?"":request.getParameter("registration_no");
	 String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	 String disabled="";
	 Boolean isBodyPartRegnAppl	= false;//Added by Thamizh selvi on 27th July 2017 for ML-MMOH-CRF-0689
	 String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

     <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language='javascript' src='../../eMO/js/MORegisterBodyPart.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
	<%try
	{
	con = ConnectionManager.getConnection(request);
	isBodyPartRegnAppl    = eCommon.Common.CommonBean.isSiteSpecific(con,"MO","MO_EXT_BODY_PART_REGN");//Added by Thamizh selvi on 27th July 2017 for ML-MMOH-CRF-0689
    String patLength = "select PATIENT_ID_LENGTH, to_char(sysdate,'dd/mm/yyyy') from MP_PARAM";
	pstmt2   = con.prepareStatement(patLength);
	vrs = pstmt2.executeQuery();
	while(vrs!=null && vrs.next())
	  	{   
	patient_id_length = vrs.getString(1)==null?"":vrs.getString(1);
	   } 
	 
	if(vrs!=null) vrs.close();
	if(pstmt2!=null) pstmt2.close();

   if(mode.equals("modify")||mode.equals("viewdata"))
		{
		pstmt2  = con.prepareStatement("select BODY_PART_OBTAINED_FROM from mo_mortuary_regn_vw where registration_no = ? and facility_id='"+facilityId+"'");
		pstmt2.setString(1,registration_no);
	    vrs = pstmt2.executeQuery();
	  
	while(vrs!=null && vrs.next())
	   	{   
body_part_obtained_from=vrs.getString("body_part_obtained_from")==null?"":vrs.getString("body_part_obtained_from");
		  }
	 
	 
	if(vrs!=null) vrs.close();
	if(pstmt2!=null) pstmt2.close();		
		
	disabled="disabled";
	}        

	}catch(Exception e)
	{
       out.println(e);   
	}finally{
 	ConnectionManager.returnConnection(con,request);
 }%>
 <body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey();' onLoad="selectbodypartobtain('<%=body_part_obtained_from%>');"  >	 
 <form name="MO_regn_form" id="MO_regn_form"   method="post" target="messageFrame" >
	<table border="0" cellpadding="2" cellspacing="0" align='center' width='95%'>
	 <tr>
	   <td class='label' width='25%'><fmt:message key="eMO.BodyPartType.label" bundle="${mo_labels}"/></td>
	   <td class='field' width='25%'><select name='obt_from' id='obt_from' <%=disabled%> onChange='changeLegent(this)'><option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
	   <option value='A'><fmt:message key="eMO.AmputatedBodyPart.label" bundle="${mo_labels}"/></option>
	   <option value='D'><fmt:message key="eMO.DeadFetus.label" bundle="${mo_labels}"/></option>
	   <option value='U'><fmt:message key="eMO.UnidentifiedBodyPart.label" bundle="${mo_labels}"/></option>
	   </select><img src='../../eCommon/images/mandatory.gif' ></img></td>
	   <td class='label' width='25%'><label id=lab1></label></td>
	   <td class='field' width='25%'><input type='text'  <%=disabled%> name='patientid' id='patientid' disabled onKeyPress="return CheckForSpecChars(event);"onBlur='validatePatient(this);' value='<%=patient_id%>' size='20' maxlength='<%=patient_id_length%>'><input type='button'  disabled name=' patientid'  id='patbtn'  class='button' value='?' onClick="callpatientsearch(this,'<%=facilityId%>',patientid)"><img src='../../eCommon/images/mandatory.gif' style="visibility:hidden"  id='patman'></img></td>
	 </tr>
	</table>
  <input type='hidden' name='mode' id='mode' value='<%=mode%>'>
  <input type='hidden' name='registration_no' id='registration_no' value='<%=registration_no%>'>
  <input type='hidden' name='patient_id'  id='patient_id' value='<%=patient_id%>'>
  <input type="hidden" name="isBodyPartRegnAppl" id="isBodyPartRegnAppl" value='<%=isBodyPartRegnAppl%>'><!--Added by Thamizh selvi on 27th July 2017 for ML-MMOH-CRF-0689-->
  </table>
  </form>
  </body>
  </html>
     
     

