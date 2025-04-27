
<%@ page import ="java.sql.*, java.util.*, java.net.*, java.text.*,webbeans.eCommon.*,webbeans.*,eDR.*,java.io.*,eCommon.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:useBean id="obj" scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
    webbeans.op.PatientData patdata = new webbeans.op.PatientData();
   	Hashtable hash	= (Hashtable) obj.parseXMLString(request);
 	hash			= (Hashtable) hash.get("SEARCH");
    	 
	String patient_id	= (String) hash.get("Patient_ID");
	String patient_id9	= (String) hash.get("Patient_ID9");
	String patient_id1	= (String) hash.get("Patient_ID1");
	String patient_id2	= (String) hash.get("Patient_ID2");
	String function_id	= (String) hash.get("function_id");	
	String step			= (String)hash.get("step");
    String locale=(String)session.getAttribute("LOCALE");	
	String facility_id			 = (String)session.getValue("facility_id");
	if (patient_id == null || patient_id == "undefined") patient_id = "";
	if (step == null || step == "undefined") step = "";
	if (patient_id9 == null || patient_id9 == "undefined") patient_id9 = "";
	if (patient_id1 == null || patient_id1 == "undefined") patient_id1 = "";
	if (patient_id2 == null || patient_id2 == "undefined") patient_id2 = "";
 	Connection con			= null;
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;

	int cntPat = 0;

	String p_patient_line = "";
	String pat_id = "";

	//Added by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815
	Boolean isMergeDeceasedPatIdAppl = false; 
		
	try
	{
		con		= ConnectionManager.getConnection(request);

		isMergeDeceasedPatIdAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"DR","MERGE_DECEASED_PATIENTID");//Added by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815
		
		pstmt	= con.prepareStatement("select count(1) from mp_patient where patient_id = ?");

		if(function_id.equals("ENTER_DUPLICATES1"))
		{
			pstmt.setString(1, patient_id9);
		}

		if(function_id.equals("ENTER_DUPLICATES") || function_id.equals("EXCLUDE_DUPLICATES1"))
		{
			pstmt.setString(1, patient_id);
		}
		else
		{
			if(!patient_id1.equals("")) 
			{
				pstmt.setString(1, patient_id1);
			}
			else if(!patient_id2.equals("")) 
			{
				pstmt.setString(1, patient_id2);
			}
		}

		rs = pstmt.executeQuery();
		if(rs != null) 
		{
			if(rs.next()) 
			{
				cntPat = rs.getInt(1);
			}
		} 
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(cntPat > 0)
		{
			if(!patient_id9.equals(""))
			{
				demography d	= new demography();
				p_patient_line	= d.name_age_sex(session ,patient_id9,con,locale);
			}
			if(!patient_id.equals(""))
			{
				demography d	= new demography();
				p_patient_line	= d.name_age_sex(session ,patient_id,con,locale);
			}
			else if(!patient_id1.equals(""))
			{
				demography d	= new demography();
				p_patient_line	= d.name_age_sex(session ,patient_id1,con,locale);
			}
			else if(!patient_id2.equals(""))
			{
				demography d	= new demography();
				p_patient_line	= d.name_age_sex(session ,patient_id2,con,locale);
			}
			if(function_id.equals("ENTER_DUPLICATES1") && step.equals("1"))
			{
				%>
				document.forms[0].search.disabled = false;
				parent.frames[1].location.href='../../eCommon/html/blank.html';
				parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num= ';
				<%
			}
			else
			{

			if (function_id.equals("ENTER_DUPLICATES"))
			{
				int not_dup_cnt = 0;
				String sql = " select count(*) cnt from dr_not_dup_patients where patient_id1 = ? or patient_id2 = ? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, patient_id);
				pstmt.setString(2, patient_id);

				rs = pstmt.executeQuery();
				if(rs != null && rs.next()) 
				{			
					not_dup_cnt = rs.getInt("cnt");					
				} 
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();

				if(not_dup_cnt>0)
				{
					%>
						document.forms[0].patient_id.select();
						document.forms[0].patient_id.focus();
						document.getElementById('pat_name').innerHTML=''; 
						var ErrorText = getMessage('EXCLUDE_DUPLICATE_RECORD','DR');						
						parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;	
					<%

				} else {
				
				Boolean isConOGGApplicable	= CommonBean.isSiteSpecific(con, "SM","GGS_OWNER_BKG_JOB");
				String chkst=patdata.CheckStatus(con,patient_id);
				String patstatus = "";
				if(isConOGGApplicable){

						String sqlFn = " select ip_open_check(?) from dual";
						String result = "";
						pstmt = con.prepareStatement(sqlFn);
						pstmt.setString(1, patient_id);

						rs = pstmt.executeQuery();
						if(rs != null && rs.next()){			
							result = rs.getString(1);				
						} 
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();
						if(result.equals("Y")){
							patstatus = "CURRENTLY_IN_PATIENT";
						}
						
				}else{
					patstatus=patdata.CheckInPatient(con,patient_id,facility_id);
				}
				
				
				if(patstatus.equals("CURRENTLY_IN_PATIENT")) 
					{					
					%>					 
					 if(document.forms[0].p_flag_value.value=="N")
							 {			
									
									document.forms[0].patient_id.select();
									document.forms[0].patient_id.focus();
									document.getElementById('pat_name').innerHTML=''; 
									var ErrorText = getMessage('ONLY_ONE_INPATIENT','DR');						
									parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;					 
							 }
						else{
									document.getElementById('p_patient_line').value = "<%=p_patient_line%>"
									document.forms[0].p_flag_value.value="N";	
									document.getElementById('pat_name').innerHTML = "<%=p_patient_line%>"
									parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=';
									document.forms[0].dup_ind.focus();
									
							  }					
						
					<%}

				//Modified by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815
				else if(chkst.equals("DECEASED") && !isMergeDeceasedPatIdAppl) 
			    {%>
                document.forms[0].patient_id.select();
				document.forms[0].patient_id.focus();
				document.getElementById('pat_name').innerHTML=''; 
				var error= getMessage('PAT_DECEASED_NOT_ALLOWED','MP');
				parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+error;

				<%}else if(chkst.equals("SUSPENDED")){%>

                 document.forms[0].patient_id.select();
				 document.forms[0].patient_id.focus();
				 document.getElementById('pat_name').innerHTML=''; 
				 var error= getMessage('PAT_SUSPENDED_NOT_ALLOWED','MP');
				 parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+error;

				 <%}else if(chkst.equals("INACTIVE")){%>

                 document.forms[0].patient_id.select();
				 document.forms[0].patient_id.focus();
				 document.getElementById('pat_name').innerHTML=''; 
				 var error= getMessage('PAT_INACTIVE_NOT_ALLOWED','MP'); parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+error;
				<%}else {%>
			    document.getElementById('pat_name').innerHTML = "<%=p_patient_line%>"
				parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=';
				document.forms[0].dup_ind.focus();
				<%}
				}
			} else if(function_id.equals("EXCLUDE_DUPLICATES1"))
			{ 
				%>
				if('<%=patient_id%>' != '') 
					document.getElementById('pat_name1').innerHTML="<%=p_patient_line%>"						
			<%
			}
			else
			{ 
				%>
				if('<%=patient_id1%>' != '') 
					document.getElementById('pat_name1').innerHTML="<%=p_patient_line%>"
				else if('<%=patient_id2%>' != '') 
					document.getElementById('pat_name2').innerHTML="<%=p_patient_line%>"

			//	parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=';
			<%
			}
		}
	}
	else
	{
								
		     if(!patient_id.equals(""))
				pat_id = patient_id;
			 else if(!patient_id1.equals(""))
				pat_id = patient_id1;
			 else if(!patient_id2.equals(""))
				pat_id = patient_id2;
			 else if(!patient_id9.equals(""))
				pat_id = patient_id9; 
			 
				
		     String patientIdStatus = patdata.CheckStatus(con,pat_id);
				
			  if (patientIdStatus.indexOf("PATIENT_MERGED_VALID")>=0 )
			  {
				StringTokenizer token=new StringTokenizer(patientIdStatus,"$");
				String valid_patient_id = token.nextToken();
				valid_patient_id = token.nextToken();
				   %>
			   var error= getMessage( "PATIENT_MERGED_VALID","MP");
			   error = error.replace("#","<%=valid_patient_id%>");	
			    if('<%=patient_id%>' != '')
				{
					document.forms[0].patient_id.value="<%=valid_patient_id%>";		
					document.forms[0].patient_id.focus();
				} else if('<%=patient_id1%>' != '')	{  
					document.forms[0].patient_id1.value="<%=valid_patient_id%>";		
					document.forms[0].patient_id1.focus();
				} else 	if('<%=patient_id2%>' != '') {  
					document.forms[0].patient_id2.value="<%=valid_patient_id%>";		
					document.forms[0].patient_id2.focus();
				} 
				if('<%=function_id%>'=='ENTER_DUPLICATES1') 
				{ 				
					document.forms[0].patient_id1.value="<%=valid_patient_id%>";
					document.forms[0].patient_id1.focus();			
				}
				alert(error);
				<%
					} else { 
				%>

				if('<%=patient_id%>' != '')
				{
					document.forms[0].patient_id.select();	
					document.forms[0].patient_id.focus();
					if('<%=function_id%>'=='EXCLUDE_DUPLICATES1') 
					{ 	
						document.getElementById('pat_name1').innerHTML='';
					} else {
						document.getElementById('pat_name').innerHTML='';	
					}
					var errText = getMessage('INVALID_PAT','DR');					
					parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+errText;
				} else 	if('<%=patient_id1%>' != '') { 					
					document.forms[0].patient_id1.select();
					document.forms[0].patient_id1.focus();
					document.getElementById('pat_name1').innerHTML='';
					var errText = getMessage('INVALID_PAT','DR');					
					parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+errText;
				} else 	if('<%=patient_id2%>' != '') { 					
					document.forms[0].patient_id2.select();
					document.forms[0].patient_id2.focus();
					document.getElementById('pat_name2').innerHTML='';
					var errText = getMessage('INVALID_PAT','DR');					
					parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+errText;
				} 	
				
				if('<%=function_id%>'=='ENTER_DUPLICATES1') 
				{
				
					document.forms[0].patient_id1.select();
					document.forms[0].patient_id1.focus();
					document.forms[0].search.disabled=true;
					var errText = getMessage('INVALID_PAT','DR');
					parent.frames[1].location.href='../../eCommon/html/blank.html';
					parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+errText;
				
				} 
			<%
				}
		//}
	}
	
}
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception e :"+e.toString());
}
finally
{	
	ConnectionManager.returnConnection(con,request);
}
%>
	
