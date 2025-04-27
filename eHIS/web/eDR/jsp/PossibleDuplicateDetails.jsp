<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*" %>
<html>
<head>
   <!--   <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
   <%
    request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
     <script language='javascript' src='../../eDR/js/PossibleDuplicates.js'></script>
     <Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
     <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown='lockKey();'>
<%
	String locale=(String)session.getAttribute("LOCALE");

	Connection con              = null;
	java.sql.Statement	stmt    = null;
	ResultSet	rs			    = null;

	String str				    = "";
	String p_patient_id		    = "";
	String p_dup_group_id	    = "";
	String p_valid_duplicate    = "";
	String p_valid_check        = "";
	String p_dup_check          = "";
	String p_not_check          = "";
	String p_patient_line       = "";
	String p_dup_count		    = "";
	String p_order_by		    = "";
	String group_status		    = "";

	int i				        = 0;

	p_dup_count				    = request.getParameter("p_pat_count");
	p_patient_id                = request.getParameter("patient_id");

    try
	   {
		 con=ConnectionManager.getConnection(request);
		 stmt			    =con.createStatement();
		 if(p_patient_id==null)
		 {
		   p_patient_id ="";
		 }
		 if(p_dup_count==null)
		 {
		   p_dup_count  ="";
		 }

		 //str  =  "select dup_group_id,pat_count from dr_dup_group_vw2 where  system_gen_yn='Y' and marked_for_merge_yn='N' and patient_id = nvl(('"+p_patient_id+"'),patient_id) ";

		 str  =  " SELECT b.dup_group_id, pat_count FROM DR_DUP_GROUP_HDR A,DR_DUP_GROUP_DTLS B WHERE   A.DUP_GROUP_ID = B.DUP_GROUP_ID AND system_gen_yn='Y' AND marked_for_merge_yn='N'  and group_status = 'U' AND patient_id = NVL(('"+p_patient_id+"'),patient_id) ";

		 rs	  =  stmt.executeQuery(str);

		  if (rs != null)
			{
			  if (rs.next())
			   {
				 p_dup_group_id = rs.getString("dup_group_id");
				 p_dup_count    = rs.getString("pat_count") ;
%>
				   <script>
						parent.frames[1].document.getElementById("p_patcount").value = <%=p_dup_count%> ; 
						parent.frames[4].document.getElementById("duplicatesdetails").disabled = false;
				   </script>

<%			
			   }
			  else
			  {
%> 
				  <script>
						   var ErrorText = getMessage('NO_RECORD','DR');
						   parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
						   parent.frames[4].document.getElementById("duplicatesdetails").disabled = true;
				  </script>

<%			  }
		  }
	if (rs != null) rs.close();
	str  = "select decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle from dr_process_ctl " ;
	rs	 = stmt.executeQuery(str);
	if(rs!=null)
	{
		 if (rs.next())
		  {
			p_order_by = rs.getString("order_by_for_process_cycle");
		  }
	}
	if (rs != null) rs.close();

	//str   = "select group_status,dup_group_id,patient_id,mp_patient_added_date,	dup_indicator  valid_duplicate,patient_line from dr_dup_group_vw2 where dup_group_id='"+p_dup_group_id+"' " + " order by "+p_order_by+" ";

	str   = "SELECT group_status, a.dup_group_id, patient_id, mp_patient_added_date, dup_indicator valid_duplicate, SUBSTR(get_patient_line(patient_id,'"+locale+"'),1,LENGTH(get_patient_line(patient_id,'"+locale+"'))-6) patient_line FROM  DR_DUP_GROUP_HDR A,DR_DUP_GROUP_DTLS B WHERE A.DUP_GROUP_ID = B.DUP_GROUP_ID AND     a.dup_group_id='"+p_dup_group_id+"' ORDER BY "+p_order_by+"";
	
	rs	  = stmt.executeQuery(str);
%>
    <form name='group_details_form' id='group_details_form'>
	<table border=0 width=100% cellspacing=0 cellpadding=0 >
<%
	if (rs != null)
	  {
		while (rs.next())
		 {
				i++;
				p_patient_id		= rs.getString("patient_id") ;
				p_valid_duplicate	= rs.getString("valid_duplicate");
				p_patient_line		= rs.getString("patient_line") ;
				group_status		= rs.getString("group_status") ;
			    if(p_valid_duplicate.equals("V"))
					{
						p_valid_check = "checked";
						p_dup_check   = "unchecked";
						p_not_check   = "unchecked";
					}
					else if(p_valid_duplicate.equals("D"))
					{
						p_valid_check = "unchecked";
						p_not_check   = "unchecked";
						p_dup_check   = "checked";
					}
					else if(p_valid_duplicate.equals("X"))
					{
						p_valid_check = "unchecked";
						p_dup_check   = "unchecked";
						p_not_check   = "checked";
					}
%>
	  <tr>
				<td width=8% class='fields'>
					<input type=checkbox name='selectpatient<%=i%>' id='selectpatient<%=i%>' onClick='javascript:checkDuplicatesDetails("<%=p_patient_id%>","<%=i%>")' ></td>
				<td width=3% class='label'><a href='javascript:viewPatientDetails("<%=p_patient_id%>")'>+</a></td>
				<td width=48% class='label' colspan='1' ><font size=1><%=p_patient_id%></font></td>
				<td width=10% class=label>
				   <input type='hidden' name='selectpatientid<%=i%>' id='selectpatientid<%=i%>' value='<%=p_patient_id%>'>
<%              
				if (group_status.equals("I")){
				if (p_valid_check.equals("checked"))
				{
%>
					<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG></td>
<%
				}
				}
%>
				
				<td width=10% class=label align='center' >
<%              if (group_status.equals("I")){
				if (p_dup_check.equals("checked"))
				{

%>
					<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG></td>
<%
				}
				}
%>
				<td width=20%class=label align='center' >
<%               if (group_status.equals("I")){ 
				if (p_not_check.equals("checked"))
				{

%>
					<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG></td>
<%
				}
              }
%>
				</tr>
					<tr>
						<td>&nbsp;</td>
						<td class='label' colspan='5'><font size=1><%=p_patient_line%> </font></td>
					</tr>

<%
				}
			}if (rs != null) rs.close();
%>

 	</table>
		<input type=hidden name=patcount id=patcount value=0>
		<input type=hidden name=patient_id1 id=patient_id1 value=''>
		<input type=hidden name=patient_id2 id=patient_id2 value=''>
		<input type=hidden name=p_dup_group_id id=p_dup_group_id value=<%=p_dup_group_id%>>
		<input type=hidden name=p_dup_count id=p_dup_count value=<%=p_dup_count%>>
 </form>
<%  if (rs != null) rs.close();
	if (stmt != null) stmt.close();
	}
	catch(Exception e)
	{
	   out.println("Error From File PossibleDuplicateDetails"+ e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

