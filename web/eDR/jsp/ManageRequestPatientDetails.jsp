<!DOCTYPE html>
<%
/**
*	MODULE		: Duplicate Registration Check ...[DR]
*	Developer	: SRIDHAR R 
*	Created On	: 05 AUG 2005
*	Funtion		: To View the details of Patient...
**/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<html>
<head>
<title><fmt:message key="eDR.ViewRecordDetails.label" bundle="${dr_labels}"/></title>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
   String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/MergedPatientIds.js'></script>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
	<script>
		async function showPatientDtls(p_patient_id, valid_duplicate)
		{
			var title = getLabel("eDR.ViewRecordDetails.label","DR");
			//var dialogHeight= "41" ;
			//var dialogWidth	= "70" ;
			var dialogHeight= "90vh" ;
			var dialogWidth	= "90vw" ;
			var dialogTop="";
			var dialogLeft="1";			
			var prev="prev";
			var display="display";
			var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
			
			if(valid_duplicate == 'D')
			{
				//window.showModalDialog('../../eDR/jsp/ViewDupPatDetailsMain.jsp?disp_dup_pat_dtls=Duplicate&Patient_ID='+p_patient_id,arguments,features);
				await  top.window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?disp_dup_pat_dtls=Duplicate&Patient_ID='+p_patient_id,arguments,features);
			}
			else 
			{
				await top.window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID='+p_patient_id,arguments,features);
			}
		}
	</script>
	<body onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
	<table border=1 width='100%' cellspacing=0 cellpadding=0 >
		<td class='columnheader'>+</td>
		<td class='columnheader'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='columnheader'><fmt:message key="Common.main.label" bundle="${common_labels}"/></td>
		<td class='columnheader'><fmt:message key="eDR.Duplicate.label" bundle="${dr_labels}"/></td>
		<td class='columnheader'><fmt:message key="eDR.MergedBy.label" bundle="${dr_labels}"/></td>
		<td class='columnheader'><fmt:message key="eDR.MergedDate.label" bundle="${dr_labels}"/></td>
	<%
		Connection con		= null;
		Statement stmt		= null;
		Statement stmt1		= null;
		ResultSet rs		= null;
		ResultSet FinalRS	= null;
	
		String job_ctrl_no	= checkForNull(request.getParameter("job_ctrl_no"));
		String status		= checkForNull(request.getParameter("status"));
		String dup_group_id	= "";
		String merge_trn_id	= "";
		String str			= "";
		String classValue	= "";
		String patient_id	= "";
		String dup_indicator= "";
		String added_by_id	= "";
		String added_date	= "";
		String valid_check	= "";
		String dup_check	= "";
		String FinalStr		= "";		
		try
		{
			con		= ConnectionManager.getConnection(request);
			stmt	= con.createStatement();
			stmt1	= con.createStatement();			
			if(status.equals("C"))
			{
				// patient NOT duplicated	, chaking of merged
				
				str  = " select merge_trn_id from DR_MERGED_PATIENT_HDR where job_ctrl_no = '"+job_ctrl_no+"' ";
				
				
				rs	= stmt.executeQuery(str);
				while(rs != null && rs.next())
				{
					merge_trn_id = checkForNull(rs.getString("merge_trn_id"));
					if(!merge_trn_id.equals(""))
				    {
	    				 FinalStr = " SELECT dup_indicator, patient_id, added_by_id, to_char(added_date,'dd/mm/yyyy hh24:mi') added_date FROM DR_MERGED_PATIENT_VW11 WHERE merge_trn_id = '"+merge_trn_id+"' ";
						
						 FinalRS	= stmt1.executeQuery(FinalStr);
						 int i=0;
						 while(FinalRS.next())
						 {
							 
								if (i % 2 == 0)
								classValue = "QRYEVEN" ;
								else
								classValue = "QRYODD" ;
								
								patient_id		= 	checkForNull(FinalRS.getString("patient_id"),"&nbsp;");
								dup_indicator	= checkForNull(FinalRS.getString("dup_indicator"),"&nbsp;");
								added_by_id		= checkForNull(FinalRS.getString("added_by_id"),"&nbsp;");
								added_date		= checkForNull(FinalRS.getString("added_date"),"&nbsp;");
								added_date = DateUtils.convertDate(added_date,"DMYHM","en",localeName);  

								if(dup_indicator.equals("V"))
								{
									valid_check = "checked";
									dup_check   = "unchecked";
								}
								else if (dup_indicator.equals("D"))
								{
									valid_check = "unchecked";
									dup_check   = "checked";
								}
								%>
									<tr>
										<td class='<%=classValue%>' align="center" style='cursor:pointer;color:blue' onclick = 'javascript:showPatientDtls("<%=patient_id%>","<%=dup_indicator%>");' >+</td>
										<td class='<%=classValue%>' ><%=patient_id%></td>
										<td class='<%=classValue%>' align='center'>
								<%	if(valid_check.equals("checked"))
											out.println("<IMG SRC='../../eCommon/images/enabled.gif' BORDER='0'></IMG>");
										else
											out.println("&nbsp;");	%>
										</td>
										<td width='10%' class='<%=classValue%>' align='center' >
								<%	if(dup_check.equals("checked"))
											out.println("<IMG SRC='../../eCommon/images/enabled.gif' BORDER='0'></IMG>");
									else
											out.println("&nbsp;");
%>
										</td>
										<td class='<%=classValue%>' align="center" ><%=added_by_id%></td>
										<td class='<%=classValue%>' align="center" ><%=added_date%></td>
									</tr>
						   <%		i++; 
							}
				    }
			}
			}
			else
			{
				//stmt	= con.createStatement();
				
			try
			 {
				str  = " select dup_group_id from DR_DUP_GROUP_HDR where JOB_CTRL_NO = '"+job_ctrl_no+"' ";
				
				rs	= stmt.executeQuery(str);
				while(rs.next())
				{
					
					dup_group_id = checkForNull(rs.getString("dup_group_id"));
				    
				    if(!dup_group_id.equals("")) // patient duplicated
					{
						
						FinalStr  = " select dup_indicator, patient_id, null added_by_id, null added_date from DR_DUP_GROUP_DTLS where dup_group_id ='"+dup_group_id+"' AND dup_indicator IN('V','D')";
						
						FinalRS	= stmt1.executeQuery(FinalStr);
					    int i=0;
				  		//FinalRS	= stmt.executeQuery(FinalStr);
  						while(FinalRS.next())
					   	 { 
								if (i % 2 == 0)
								classValue = "QRYEVEN" ;
								else
								classValue = "QRYODD" ;
								
								patient_id		= 	checkForNull(FinalRS.getString("patient_id"),"&nbsp;");
								dup_indicator	= checkForNull(FinalRS.getString("dup_indicator"),"&nbsp;");
								added_by_id		= checkForNull(FinalRS.getString("added_by_id"),"&nbsp;");
								added_date		= checkForNull(FinalRS.getString("added_date"),"&nbsp;");
								added_date = DateUtils.convertDate(added_date,"DMYHM","en",localeName);  
								if(dup_indicator.equals("V"))
								{
									valid_check = "checked";
									dup_check   = "unchecked";
								}
								else if (dup_indicator.equals("D"))
								{
									valid_check = "unchecked";
									dup_check   = "checked";
								}
								%>
									<tr>
									<% 
									if(dup_indicator.equals("D"))
									{ 
									%>
										<td class='<%=classValue%>'></td>
									<% }
									else { %>
										<td class='<%=classValue%>' align="center" style='cursor:pointer;color:blue' onclick = 'javascript:showPatientDtls("<%=patient_id%>","<%=dup_indicator%>");' >+</td> 
									<% } %>										
										<td class='<%=classValue%>' ><%=patient_id%></td>
										<td class='<%=classValue%>' align='center'> 
								<%	if(valid_check.equals("checked"))
											out.println("<IMG SRC='../../eCommon/images/enabled.gif' BORDER='0'></IMG>");
										else
											out.println("&nbsp;");	%>
										</td>
										<td width='10%' class='<%=classValue%>' align='center' >
								<%	if(dup_check.equals("checked"))
											out.println("<IMG SRC='../../eCommon/images/enabled.gif' BORDER='0'></IMG>");
									else
											out.println("&nbsp;");
%>
										</td>
										<td class='<%=classValue%>' align="center" ><%=added_by_id%></td>
										<td class='<%=classValue%>' align="center" ><%=added_date%></td>
									</tr>
						   <%		i++; 
								}if(FinalRS!=null) FinalRS.close();
						}
		     }if(rs!=null) rs.close();
		  }
		        catch(Exception e)
				{
					e.printStackTrace();
				}
	  }
	
			
			if(FinalRS != null) FinalRS.close();
			if(stmt != null) stmt.close();
		}catch(Exception e)
		{
			out.println("Exception in ManageRequestPatientDetails.jsp : "+e.toString());
		}
		finally
		{
			if(rs   != null) rs.close();
			if(stmt != null) stmt.close();
			if(stmt1 != null) stmt.close();
		    ConnectionManager.returnConnection(con,request);
		}
		%>
	</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
%>

