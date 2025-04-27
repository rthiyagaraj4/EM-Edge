<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<%@ page contentType="text/html;charset=UTF-8" import="eDR.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script language='javascript' src='../../eDR/js/EnterDuplicatesPatientID.js'></script>
<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
<!-- <script language="javascript" src="../../eDR/js/DRrowcolor.js" ></script> -->
<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	Connection con = null;
	java.sql.Statement	stmt		=null;
	ResultSet	rs			=null;
	StringBuffer str1 = null;
try
{
	str1=new StringBuffer();
	con = ConnectionManager.getConnection(request);
	stmt					=con.createStatement();
	//String str				="";
	String p_patient_id		="";
	int p_pat_count			= 0;
	String p_patient_line	="";
	int p_dup_group_id	    = 0; 
	//int p_pat_rec_cnt		= 0;
	int p_no_of_groups		= 0;
	//int p_no_of_records		= 0;
	 String locale=(String)session.getAttribute("LOCALE");  
	String valid			="";
	demography d=new demography();

	///String sql	= "";
	String sql1 = "";
	//String strsql1	= "";
	//String p_order_by = "";
	
	String p_function_name = request.getParameter("function_name");
	String patient_id		=request.getParameter("patient_id");
	patient_id=patient_id.toUpperCase();
	if(patient_id==null) patient_id="";
	if(patient_id.equals("")) patient_id="";
	int x					= 0;
	int time_count			= 0;
	
	int i=1;


%>

<form name='add_form' id='add_form'  action='../../servlet/eDR.EnterDuplicatesServlet' method='post' target='messageFrame'>
	<%
	//str  = "select decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle from dr_process_ctl " ;
    /* str  = "select order_by_for_process_cycle from dr_process_ctl " ;

	rs	 = stmt.executeQuery(str);

	if (rs.next())
		{
			p_order_by = rs.getString("order_by_for_process_cycle");
		}*/
	
	sql1 = "select count(1) total_groups from dr_dup_group_vw2 where dup_indicator='V' and system_gen_yn='N' AND group_status = 'I' and patient_id not in (select patient_id from DR_MERGED_PATIENT_DTLS where dup_indicator != 'V')";
	if(!patient_id.equals(""))
		{		
			sql1=sql1+"and UPPER(patient_id)='"+patient_id+"'";
		}
	
	rs = stmt.executeQuery(sql1);

	while (rs.next())
	{
		p_no_of_groups = rs.getInt("total_groups");
		
	}if(rs!=null) rs.close();

if (p_no_of_groups==0){ 
	 %>
		 <script>
			 alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>
  <script>
parent.location.href='../../eCommon/html/blank.html'
</script>
<% 
	}
else{
%>
		<table border=0 width='100%' cellspacing=0  id='tb1'>
		<tr>
			<td class=label width='80%'></td>
			<td class=label width='20%'></td>
		</tr>
		<tr>
			<td class='columnheader'><fmt:message key="eDR.MainPatientID.label" bundle="${dr_labels}"/></td>
			<td class='columnheader'> <fmt:message key="Common.count.label" bundle="${common_labels}"/></td>
		</tr>


 </table>
	<table border=0 width='100%' cellspacing=0  id='tb2' >
	
		<tr>
			<td class=label width='100%' colspan=3><b><fmt:message key="eMP.NoofGroups.label" bundle="${mp_labels}"/> = <%=p_no_of_groups%></td>
		</tr>
		</table>

	<table border=0 width='100%' cellspacing=0  id='tb1' >
		<tr>
			<td class=label width='5%'></td>
			<td class=label width='75%' ></td>
			<td class=label width='20%'></td>
		</tr>

<%
	/*str1.append("select dup_group_id,patient_id,pat_count,mp_patient_added_date ");
	str1.append("from dr_dup_group_vw2 where dup_indicator='V' and system_gen_yn='N'and patient_id not in (select patient_id from DR_MERGED_PATIENT_DTLS)"); 
	if(!patient_id.equals("") )
		{
		
	str1.append("and UPPER(patient_id)='"+patient_id+"'");
	}*/
	
	//str1.append("SELECT  b.dup_group_id, patient_id,  pat_count,  mp_patient_added_date FROM  DR_DUP_GROUP_HDR A, DR_DUP_GROUP_DTLS B WHERE  A.DUP_GROUP_ID = B.DUP_GROUP_ID AND dup_indicator='V' AND system_gen_yn='N' AND  patient_id NOT IN (SELECT patient_id FROM DR_MERGED_PATIENT_DTLS where dup_indicator != 'V')");

// Commented the above code and added the below code for SRR20056-SCF-5281 [IN:023889] by Suresh M on 21.09.2010
	str1.append("SELECT  b.dup_group_id, patient_id,  pat_count,  mp_patient_added_date FROM  DR_DUP_GROUP_HDR A, DR_DUP_GROUP_DTLS B WHERE  A.DUP_GROUP_ID = B.DUP_GROUP_ID AND dup_indicator='V' AND system_gen_yn='N' AND a.group_status = 'I' AND  patient_id NOT IN (SELECT patient_id FROM DR_MERGED_PATIENT_DTLS where dup_indicator != 'V')");


	
	if(!patient_id.equals("") )
		{
			str1.append("AND UPPER(patient_id)='"+patient_id+"'");
		}


	rs  =stmt.executeQuery(str1.toString());

	if (rs != null)
	{
						while ( rs.next())
						{
							x= x + 1;
							time_count++;
							p_patient_id	= rs.getString("patient_id");
							p_pat_count		= rs.getInt("pat_count");
							p_dup_group_id  = rs.getInt("dup_group_id");
							p_patient_line		=	d.name_age_sex(session ,p_patient_id,con,locale);

							//java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:MM:SS");

						%>
							<tr id='_<%=p_patient_id%>'>
								<td class='label' valign=top>
							<a href='javascript:viewPatientDetails("<%=p_patient_id%>")'>+</a></td>
								<td colspan='2' class='othlanglabel' >
							<a name='<%=x%>' href='javascript:callGroupDetails("<%=p_patient_id%>","<%=p_dup_group_id%>","<%=p_pat_count%>","<%=p_function_name%>")' id='_a<%=p_patient_id%>'>
									<%=p_patient_id%> 
									</a><br>
									<font size=2><%=p_patient_line%> </font><input type=hidden name=record id=record value=<%=valid%>>
								</td>
								<td class='label' valign=top class='label'>
									<%=p_pat_count%> 
								</td>
							</tr>
						<input type=hidden name=count id=count value=''>
						
							<%
						i++;
					}
				}
			}
			for(int j=1;j<=p_pat_count ;j++){
					%>
		<input type=hidden name=patient_id<%=j% id=patient_id<%=j%> value=''>
			<%}%>		
					</table>
		
		
		<input type=hidden name=p_patcount id=p_patcount value=''>
		<input type=hidden name=p_pat_count id=p_pat_count value=''>
		<input type=hidden name=delete_string id=delete_string value=''>
	    <input type=hidden name=p_string_value id=p_string_value value=''>
		<input type=hidden name=function_name id=function_name value='<%=p_function_name%>'>
		<input type=hidden name=mode id=mode value='insert'>
		<input type=hidden name=dupgroupid id=dupgroupid value=''>
	    		
			
			</form>
<%
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

