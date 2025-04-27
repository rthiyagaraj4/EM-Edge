<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <%
 request.setCharacterEncoding("UTF-8");
//String locale = (String)session.getAttribute("LOCALE");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
 
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eAE/js/AccsRightsforQMgmt.js'></script>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>


 
</head>   
  <%	
     Connection con 					= null;
	 java.sql.Statement stmt			= null; 
	 ResultSet reslt			        = null;  
	 ResultSet reslt1			        = null;  
	 ResultSet reslt2			        = null;  
	 PreparedStatement pstmt			= null;
	 String mode						= "";
	 String	facilityId 					= (String) session.getValue( "facility_id" ) ;



try
  {
     con	= ConnectionManager.getConnection(request);
  
	 String enable_rights = "";
	 int noOfRecords = 0;
	 int counter= 0;
	 String classValue= "";
	 String insert_disable   = "";
	 String cons_yn_check     = "";
	 String sec_triag_yn_check   = "";
	 String sec_triag_yn   = "";
	 
	 //<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
	 boolean isPendingForAdmissionAppl=false;
	 isPendingForAdmissionAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB");
			 
	 String Modify_referral_yn="";
	 String cancel_for_admission_yn="";
	 String for_admission_yn="";
	 
	 String Modify_referral_yn_chk="";
	 String cancel_for_admission_yn_chk="";
	 String for_admission_yn_chk="";
	 //<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Ends-->
	 
	 String cons_yn   = "";
	 String desc_sysdef ="";
	 String pract_type ="";
	 String update_disable ="";
	 /*Added by Dharma on July 25th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
	 String reg_new_born_yn_chk   = "";
	 String reg_new_born_yn		 = "";
	 String inv_reg_new_born_yn		 = "N";
	/*Added by Dharma on July 25th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/
try
	  {
	      String AcessSql   = "SELECT ENABLE_ACCS_RIGHTS_IN_QUEUE,INV_REG_NEW_BORN_YN FROM AE_PARAM WHERE MODIFIED_FACILITY_ID=? ";
		  pstmt=con.prepareStatement(AcessSql);
		  pstmt.setString(1,facilityId);
		  reslt=pstmt.executeQuery();
		
    if(reslt != null && reslt.next()) 
	{
	  enable_rights	 = (reslt.getString("ENABLE_ACCS_RIGHTS_IN_QUEUE"));
	  inv_reg_new_born_yn	 = (reslt.getString("INV_REG_NEW_BORN_YN"));
	}
		if (enable_rights.equals("N")|| enable_rights.equals("") || enable_rights.equals(null) )
		  {%>
		  <SCRIPT LANGUAGE="JavaScript">
			var error=getMessage("NO_AE_USER_RIGHTS","AE");			
		    alert(error);
						
		 </SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 <%}

		else 
		 {
		String AccessSql0="SELECT COUNT(*) count FROM AE_ACCS_RIGHTS_BY_PRAC_TYPE";
		pstmt = null;
		pstmt=con.prepareStatement(AccessSql0);
		reslt1 =null;
        reslt1=pstmt.executeQuery();
		 reslt1.next();
		if( ((String)reslt1.getString("COUNT")).equals("0"))
		{
   		 String AccessSql1="SELECT PRACT_TYPE, DESC_SYSDEF FROM AM_PRACT_TYPE WHERE EFF_STATUS = 'E' ORDER BY DESC_SYSDEF ";
		 stmt= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 reslt2 = stmt.executeQuery(AccessSql1) ;
    	 mode="INSERT";
	 	}
		
		else 
	    {
		  //REG_NEW_BORN_YN Added by Dharma on July 25th 2017 against ML-MMOH-CRF-0631 [IN:062148]
		  String AccessSql2="SELECT B.PRACT_TYPE PRACT_TYPE, A.DESC_SYSDEF DESC_SYSDEF,B.SEC_TRIAG_YN SEC_TRIAG_YN ,B.CONS_YN CONS_YN,B.REG_NEW_BORN_YN REG_NEW_BORN_YN,B.FOR_ADMISSION_YN FOR_ADMISSION_YN,B.CANCEL_FOR_ADMISSION_YN CANCEL_FOR_ADMISSION_YN,B.MODIFY_REFERRAL_YN MODIFY_REFERRAL_YN FROM AM_PRACT_TYPE A,AE_ACCS_RIGHTS_BY_PRAC_TYPE B WHERE  B.PRACT_TYPE=A.PRACT_TYPE  ORDER BY DESC_SYSDEF";
		  stmt= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		  reslt2 = stmt.executeQuery(AccessSql2) ;
		  mode= "UPDATE"; 
					
        }

		  while(reslt2.next())
		  noOfRecords = noOfRecords + 1;
          reslt2.beforeFirst();
           %>
			<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	        <form name="AddModifyAccsRightsforQMgmt" id="AddModifyAccsRightsforQMgmt" action="../../servlet/eAE.AccsRightsforMgmtservlet" method="post" target="messageFrame">
             <table border="1" width="60%" cellspacing='0' cellpadding='3' align='center'>                  
				   <td class= 'COLUMNHEADER' > <fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/> </td>
				   <td class= 'COLUMNHEADER' ><fmt:message key="eAE.SecondaryTriage.label" bundle="${ae_labels}"/> </td> 
				   <td class= 'COLUMNHEADER' ><fmt:message key="eAE.Consultation.label" bundle="${ae_labels}"/></td> 
				 <%if("Y".equals(inv_reg_new_born_yn)) {%> <td class= 'COLUMNHEADER' ><fmt:message key="eAE.RegisterNewBornForAE.label" bundle="${ae_labels}"/></td> <%}%>
<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
				 <%if(isPendingForAdmissionAppl){ %>
				  <td class= 'COLUMNHEADER' ><fmt:message key="eAE.ForAdmission.label" bundle="${ae_labels}"/></td>
				  <td class= 'COLUMNHEADER' ><fmt:message key="Common.CancelForAdmission.label" bundle="${common_labels}"/></td>
				  <td class= 'COLUMNHEADER' ><fmt:message key="eAE.ModifyReferral.label" bundle="${ae_labels}"/></td>
				  <%}%>
				   <!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Ends-->
    <%
		int i = 1;
		while(reslt2.next()) 
		{
		counter++ ;
		if ( counter % 2 == 0 )
		  	classValue = "QRYODD" ;
		else
		  	classValue = "QRYEVEN" ;
		if(mode.equals("INSERT"))
		{
            pract_type=reslt2.getString("PRACT_TYPE");
		    desc_sysdef=reslt2.getString("DESC_SYSDEF");
			insert_disable="disabled";
		}
		
		else if(mode.equals("UPDATE"))
		{  
			sec_triag_yn=reslt2.getString("SEC_TRIAG_YN");
			cons_yn=reslt2.getString("CONS_YN");
			reg_new_born_yn=reslt2.getString("REG_NEW_BORN_YN");
            pract_type=reslt2.getString("PRACT_TYPE");
            desc_sysdef=reslt2.getString("DESC_SYSDEF");
            
          // <!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
	          for_admission_yn=reslt2.getString("FOR_ADMISSION_YN");
	          cancel_for_admission_yn=reslt2.getString("CANCEL_FOR_ADMISSION_YN");
	          Modify_referral_yn=reslt2.getString("MODIFY_REFERRAL_YN");
	         if(for_admission_yn.equals("Y")){for_admission_yn_chk="checked";}
	         else{for_admission_yn_chk="";}
	         
	         if(cancel_for_admission_yn.equals("Y")){ cancel_for_admission_yn_chk="checked";}
	         else{ cancel_for_admission_yn_chk="";}
	         
	         if(Modify_referral_yn.equals("Y")) { Modify_referral_yn_chk="checked"; }
	         else{ Modify_referral_yn_chk="";}
	        // <!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Ends-->
	         

			if(sec_triag_yn.equals("Y")) {
				 sec_triag_yn_check="checked"; 
				 update_disable="";
			} else { 
				update_disable="disabled";
				sec_triag_yn_check="";
			}

			if(cons_yn.equals("Y")) {
				 cons_yn_check="checked"; 
			}else {
				cons_yn_check="";
				
			}

			/*Added by Dharma on July 25th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
			reg_new_born_yn_chk	 = "";
			if("Y".equals(reg_new_born_yn)){
				reg_new_born_yn_chk = "checked";
			}
			/*Added by Dharma on July 25th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/


	
		}
 
		
    %>
 
			<tr>
            <input type='hidden' class='fields'  name='practitioner_code<%=counter%>' id='practitioner_code<%=counter%>' value='<%=pract_type%>'>
			<td width='15%' class=<%=classValue%>><%=desc_sysdef%></td>
			<td  width='15%' class=<%=classValue%> ><input type='checkbox' class='fields'  name='second_triage_yn<%=counter%>' id='second_triage_yn<%=counter%>' onclick='Enable_counsl(this,<%=counter%>);' value='<%=sec_triag_yn%>' <%=sec_triag_yn_check%>></td>
			<td width='15%' class=<%=classValue%>><input type='checkbox' class='fields'  name='counsulation_yn<%=counter%>' id='counsulation_yn<%=counter%>' onclick='CounslationCheck(this);' value='<%=cons_yn%>' <%=cons_yn_check%> <%=insert_disable%> <%=update_disable%> ></td>
			 <%if("Y".equals(inv_reg_new_born_yn)) {%>
			 <td width='15%' class=<%=classValue%>><input type='checkbox' class='fields'  name='reg_new_born_yn<%=counter%>' id='reg_new_born_yn<%=counter%>' value='<%=reg_new_born_yn%>' <%=reg_new_born_yn_chk%> ></td> 
			<%}%>
			
			 <!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
			 <%if(isPendingForAdmissionAppl){%>
			 <td  width='10%' class=<%=classValue%> ><input type='checkbox' class='fields'  name='for_admission<%=counter%>' id='for_admission<%=counter%>'        id='for_admission<%=counter%>'          onclick='Checkboxcheck("for_admission",<%=counter%>);'         value='<%=for_admission_yn%>' <%=for_admission_yn_chk%>></td>
			 <td  width='15%' class=<%=classValue%> ><input type='checkbox' class='fields'  name='cancel_for_admission<%=counter%>' id='cancel_for_admission<%=counter%>' id='cancel_for_admission<%=counter%>'   onclick='Checkboxcheck("cancel_for_admission",<%=counter%>);'  value='<%=cancel_for_admission_yn%>' <%=cancel_for_admission_yn_chk%>></td>
			 <td  width='15%' class=<%=classValue%> ><input type='checkbox' class='fields'  name='Modify_referral<%=counter%>' id='Modify_referral<%=counter%>'       id='Modify_referral<%=counter%>'         onclick='Checkboxcheck("Modify_referral",<%=counter%>);'        value='<%=Modify_referral_yn%>' <%=Modify_referral_yn_chk%>></td>
			 <%}%>
			 <!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Ends-->
			</tr>
			
	<%
				i++ ;
	   
				

	   }
			 
	}
					if(pstmt != null) pstmt.close();
					if(reslt != null) reslt.close();
					if(reslt1 != null) reslt1 .close();
					if(reslt2 != null) reslt2 .close();
}
	  
		catch(Exception e) 
			{
					e.printStackTrace();

			}
	  
	   
%>
<input type='hidden' name='noOfRecords' id='noOfRecords' value='<%=noOfRecords%>'>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
	</table> 
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
    	if(con!=null)
	    ConnectionManager.returnConnection(con,request);
    }
	%>
	</html>


