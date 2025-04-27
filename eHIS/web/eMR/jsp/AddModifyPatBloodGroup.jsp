<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8" import="java.sql.Connection,java.sql.Statement,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<%
	Connection con=null;
    PreparedStatement pstmt=null;  
	//Statement stmt=null;
	PreparedStatement stmt=null;
    ResultSet rset=null;
    ResultSet rs=null;
 %>   
    
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  <script>
 /* function checkN()
  {
    if(document.PatBloodGroup_form.siccn.checked)
   {
     document.PatBloodGroup_form.siccp.checked=false;
     document.PatBloodGroup_form.radioval.value='N';
   }
 }  
 
 function checkP()
  {
   if(document.PatBloodGroup_form.siccp.checked)
   {
     document.PatBloodGroup_form.siccn.checked=false;
     document.PatBloodGroup_form.radioval.value='P';
  }
 } */

 function clearresultPage(){
	 parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";

 }

  </script>
 </head>

<%
	
  String PatientId = request.getParameter("P_Patient_Id");
  String locale    = (String)session.getAttribute("LOCALE"); 
 // String G6pdCol[] = {"--Select--","No Activity","Normal Activity","Partial Activity"};
 // String G6pdVal[] = {"","X","N","P"};
  String funcval="insert";
  String selectAttribute="";
  String selectAttribute1="";
//  String selectAttribute2="";
  String checkboxAttribute2="";
  String patbloodgrp="";
  String RHfactor="";
  String G6PDmarker="";
  String SICCmarker="";
  String sele="";

 
  
//  String sql1="select count(blood_grp) as total from mp_pat_oth_dtls where patient_id='"+PatientId+"'";
	String sql="select blood_grp, rh_factor, g6pd_marker, sicc_marker FROM MP_PAT_OTH_DTLS where patient_id=?";
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	

	try
	{	
		con=ConnectionManager.getConnection(request);
		//stmt=con.createStatement(); 
		stmt = con.prepareStatement(sql);
		stmt.setString(1,PatientId);
		rs=stmt.executeQuery();

		if (rs.next())
		{
			funcval="modify";
			patbloodgrp=rs.getString(1);
			if(patbloodgrp==null) patbloodgrp="";
				RHfactor=rs.getString(2);
			if(RHfactor==null) RHfactor="";
				G6PDmarker=rs.getString(3);
			if(G6PDmarker==null) G6PDmarker="";
				SICCmarker=rs.getString(4);
			if(SICCmarker==null) SICCmarker="";
			//if(SICCmarker.equals("N"))  checkboxAttribute1="checked";
			//if(SICCmarker.equals("P"))  checkboxAttribute2="checked";
		}
		else {
			    checkboxAttribute2="checked";     
	    	 } 
		
		int count = 0;
		String dis_blood_grp = "";
		String sql2="select count(1) from bt_patient_blgrp_rh_ant where patient_id =? ";			
		stmt = con.prepareStatement(sql2);
		stmt.setString(1,PatientId);
		rs=stmt.executeQuery();
		if (rs != null) {
			while(rs.next() ) {
				count = rs.getInt(1);
			}
		} 
		rs.close();								
		if(count > 0)
		dis_blood_grp = "disabled";								
%>

<body onload='FocusFirstElement();'  OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()'>
<form name='PatBloodGroup_form' id='PatBloodGroup_form' method='POST' action='../../servlet/eMR.PatBloodGroupServlet' target='messageFrame'>
         <BR><BR><BR><BR><BR><BR><BR><table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'>
            <tr>
			<td colspan='2' class='label'>&nbsp;</td></tr>
			<tr>
		  	<td class="label" width='50%' ><fmt:message key="Common.bloodgroup.label" bundle="${common_labels}"/></td>
		   	<td class='fields' width='50%'>
		  		<select name='blood_group' id='blood_group' <%=dis_blood_grp%> ><option value='' >------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
				    <%
				     try {
						/*
							Added on 6/14/2010 For PE.
							The execution of the below query was changed to PreparedStatement from Statement. 
						*/
						String BLD_GRP_SQL="SELECT  BLOOD_GRP , SHORT_DESC  FROM MR_BLOOD_GRP_LANG_VW  WHERE EFF_STATUS=? AND LANGUAGE_ID=?" ;
						pstmt = con.prepareStatement(BLD_GRP_SQL);
						pstmt.setString(1,"E");
						pstmt.setString(2,locale);
						//rs = pstmt.executeQuery("select blood_grp,short_desc from mr_blood_grp where eff_status='E'");
						rs = pstmt.executeQuery();
						if (rs != null) {
							while(rs.next() ) {
								String BloodGroup = rs.getString("BLOOD_GRP");
								String ShortDesc = rs.getString("SHORT_DESC");
							if(funcval.equals("modify")){
								if(BloodGroup.equals(patbloodgrp)){
									selectAttribute="selected";
								}else{ 
									selectAttribute="";	
								}
							} 
								out.println("<option value ='"+BloodGroup+"' "+selectAttribute+">"+ShortDesc);
							}
						}
			           	   if(rs != null) rs.close();
   			           	   if(pstmt != null) pstmt.close();
				       }catch(Exception e) {
				              e.printStackTrace();
				       }
				       finally {
						   try{
				                if (rs != null) rs.close();
				                if (pstmt != null) pstmt.close();
						   }catch(Exception e) {}
				       }
				     %>	
		  		</select><img src='../../eCommon/images/mandatory.gif'></img>
		  	</td>
		  </tr>
		    <tr>
		      <td class='label' ><fmt:message key="eMR.RHDFactor.label" bundle="${mr_labels}"/></td>
		      <td class='fields'>
		        <select name='rf_code' id='rf_code' <%=dis_blood_grp%> ><option value='' >------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		          <%
		            try{
						String RHD_SQL="SELECT RHESUS_FACTOR_CODE, SHORT_DESC FROM MR_RHESUS_FACTOR_LANG_VW  WHERE EFF_STATUS=? AND LANGUAGE_ID=?"; 
						pstmt = con.prepareStatement(RHD_SQL);
						pstmt.setString(1,"E");
						pstmt.setString(2,locale);
						rs = pstmt.executeQuery();
						if(rs!= null) {
							while(rs.next()) {
								if(funcval.equals("modify")){
									if(rs.getString("RHESUS_FACTOR_CODE").equals(RHfactor)){
										selectAttribute1="selected";
									}else{ 
										selectAttribute1="";	 
									}
								} 
								out.println("<option value='" + rs.getString("RHESUS_FACTOR_CODE") + "' "+selectAttribute1+">"+ rs.getString("SHORT_DESC"));
							}
						}
		            }catch(Exception e) {
		                   e.printStackTrace();
		            }
		            finally {
						try{
		                     if (rs!= null) rs.close();
		                     if (pstmt != null) pstmt.close();
						}catch(Exception e) {}
		            }
		          %>
		        </select><img src='../../eCommon/images/mandatory.gif'></img>
		      </td> 
		   </tr>
          <tr ><td class="COLUMNHEADER" colspan='2'><b><fmt:message key="eMR.GeneticMarkers.label" bundle="${mr_labels}"/></b></td></tr>
          <tr>  
               <td class="label" ><fmt:message key="Common.g6pd.label" bundle="${common_labels}"/></td>
	 	   
		  	<td class='fields'>
		  		<select name='g6pd_marker' id='g6pd_marker'>
					<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
				    <%
  			           	   if(rs != null) rs.close();
   			           	   if(pstmt != null) pstmt.close();
						   String G6PD_SQL="SELECT DISCR_MSR_ID, A.REF_RNG_DESC FROM AM_DISCR_MSR_RF_RNG_LS_LANG_VW A, MR_PARAMETER B WHERE A.DISCR_MSR_ID=B.G6PD_DISCR_MSR_ID AND A.LANGUAGE_ID =? ORDER BY A.SORT_ORDER";
						   pstmt =con.prepareStatement(G6PD_SQL);
						   pstmt.setString(1,locale);
							rs = pstmt.executeQuery();
						  // rs = pstmt.executeQuery("select discr_msr_id, a.ref_rng_desc from am_discr_msr_ref_rng_list a,mr_parameter b where a.discr_msr_id=b.g6pd_discr_msr_id and rownum< 2 order by a.sort_order ");
   				           //rs = pstmt.executeQuery("select ref_rng_desc from am_discr_msr_ref_rng_list a,mr_parameter b where a.discr_msr_id=b.sicc_discr_msr_id order by a.sort_order  ");

						  // rs = pstmt.executeQuery("select discr_msr_id, a.ref_rng_desc from AM_DISCR_MSR_RF_RNG_LS_LANG_VW a, MR_PARAMETER b where a.discr_msr_id=b.g6pd_discr_msr_id and a.language_id = '"+locale+"' and rownum< 2 order by a.sort_order");

						  //modified on 10-06-08 for SPR 3994
//						  rs = pstmt.executeQuery("select discr_msr_id, a.ref_rng_desc from AM_DISCR_MSR_RF_RNG_LS_LANG_VW a, MR_PARAMETER b where a.discr_msr_id=b.g6pd_discr_msr_id and a.language_id = '"+locale+"' order by a.sort_order"); 
								if (rs != null){
									while(rs.next() ){
										sele="";
										String ssp=rs.getString("ref_rng_desc");if(ssp==null)ssp="";
										String g6pd_val=rs.getString("discr_msr_id");if(g6pd_val==null)g6pd_val="";
										/*if(G6PDmarker.equals(g6pd_val))sele="selected";
										out.println("<option "+sele+" value='"+g6pd_val+"'>"+ssp+"</option>");*/
										////modified for SCR #5301  on 9-9-8
										if(funcval.equals("modify")){
											//if(G6PDmarker.equals(g6pd_val))
											if(G6PDmarker.equals(ssp)){
												sele="selected";
											}else{
												sele="";
											}
										}
										out.println("<option "+sele+" value='"+ssp+"'>"+ssp+"</option>");
									}
								}
  			           	   if(rs != null) rs.close();
   			           	   if(pstmt != null) pstmt.close();

				     %>	
		  		</select>
		  	</td>
		  </tr>
		  <tr>
		      <td class='label' ><fmt:message key="Common.sicc.label" bundle="${common_labels}"/></td>
		      <td  class='fields'>
		 		<select name='sicc_marker' id='sicc_marker'>
				<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
 				<% 	
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					String SICC_SQL="SELECT DISCR_MSR_ID, A.REF_RNG_DESC FROM AM_DISCR_MSR_RF_RNG_LS_LANG_VW A,MR_PARAMETER B WHERE A.DISCR_MSR_ID = B.SICC_DISCR_MSR_ID AND A.LANGUAGE_ID =? ORDER BY A.SORT_ORDER";
					pstmt = con.prepareStatement(SICC_SQL);
					pstmt.setString(1,locale);
					rs = pstmt.executeQuery();
					//rs = pstmt.executeQuery("select discr_msr_id, a.ref_rng_desc from am_discr_msr_ref_rng_list a,mr_parameter b where a.discr_msr_id=b.sicc_discr_msr_id and rownum < 2 order by a.sort_order  ");
					//rs = pstmt.executeQuery(" select discr_msr_id, a.ref_rng_desc from AM_DISCR_MSR_RF_RNG_LS_LANG_VW a,MR_PARAMETER b where a.discr_msr_id = b.sicc_discr_msr_id and a.language_id = '"+locale+"' and rownum < 2 order by a.sort_order");
					//modified on 10-06-08 for SPR 3994
//					rs = pstmt.executeQuery(" select discr_msr_id, a.ref_rng_desc from AM_DISCR_MSR_RF_RNG_LS_LANG_VW a,MR_PARAMETER b where a.discr_msr_id = b.sicc_discr_msr_id and a.language_id = '"+locale+"' order by a.sort_order");
						if (rs != null) {
							while(rs.next()){
							sele="";
							String ssp=rs.getString("ref_rng_desc");if(ssp==null)ssp="";
							String sicc_val=rs.getString("discr_msr_id");if(sicc_val==null)sicc_val="";
							/*if(SICCmarker.equals(sicc_val))sele="selected";
							out.println("<option "+sele+" value='"+sicc_val+"'>"+ssp+"</option>");*/
							//modified for SCR #5301  on 9-9-8
							if(funcval.equals("modify")){
								if(SICCmarker.equals(ssp)){
								sele="selected";
								}else{
									sele="";
								}
							}
							out.println("<option "+sele+" value='"+ssp+"'>"+ssp+"</option>");
							}
						}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					%>
					</select>
					</td> 
		   </tr>
            <tr>
			<td class='label'>&nbsp;</td>
			<td  class='button'><input type='button' align='right' name='record' id='record' onclick="parent.apply()" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" class='button'><input type='button' align='right' name='clear' id='clear' onclick="parent.clearform()" class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'class='button'><input type='button' align='right' name='cancel' id='cancel' onclick="parent.blank()" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class='button'></td>
		</tr>
		<tr>
			<td colspan='2' class='label'>&nbsp;</td>
		</tr>
	
	</table>
	
      <input type='hidden' name='function' id='function' value='<%=funcval%>'>
      <input type='hidden' name='function_name' id='function_name' value='<%=funcval%>'>
      <input type='hidden' name='patientid' id='patientid' value=" <%= PatientId %> "> 
      <input type='hidden' name='radioval' id='radioval' value='P'>
  </form>
  <script>
		  clearresultPage();
		  </script>
</body>
</html>
<%
}
   catch(Exception e){/* out.println(e.toString()+" P_Patient_Id "+PatientId); */e.printStackTrace();}
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
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

