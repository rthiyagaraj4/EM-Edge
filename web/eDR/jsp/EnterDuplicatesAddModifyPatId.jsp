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
 	<script language='javascript' src='../../eCommon/js/common.js'></script> 
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title></title>
</head>
<body class='CONTENT' onKeyDown="lockKey()">
<%
	Connection con				= null;
	java.sql.Statement	stmt	= null;
	java.sql.Statement	stmt1	= null;
	ResultSet	rs				= null;
	ResultSet	rs1			= null;
	int		i			  = 0  ;
try
{
	con = ConnectionManager.getConnection(request);
	
	stmt					=con.createStatement();
	stmt1					=con.createStatement();
	String str				="";
	String  p_string_val  = "" ;
	String  p_patient_id  = "" ;
	String  p_dup_ind	  = "" ;
	String  p_remarks	  = "" ;
	//String  p_flag_value	  = "" ;
	String  p_valid_check = "" ;
	String  p_dup_check   = "" ;
	String  p_not_check   = "" ; 
	String p_mode		  = "" ;
	String p_before_dup	  = "" ;
	String p_dup_group_id = "";
	String p_dupgroupid	  = "";
	String pat_series="";
	String locale=(String)session.getAttribute("LOCALE"); 
	String check1="";
	String p_function_name = request.getParameter("function_name");
	//String p_order_by	= "";

	p_string_val	= request.getParameter("p_string_val");
	
	p_mode				= request.getParameter("p_mode");
		
	p_before_dup		= request.getParameter("p_before_dup");
	p_dup_group_id		= request.getParameter("p_dup_group_id");

	
	if(p_dup_group_id==null) p_dup_group_id="";
	p_dupgroupid		= request.getParameter("p_dupgroupid");
	 check1		= request.getParameter("check");
	demography d=new demography();
	String p_patient_line = "";
  
	if (p_string_val==null) p_string_val="";
	if (p_mode==null) p_mode="";
	if (p_dup_group_id==null) p_dup_group_id="";
	if (p_dupgroupid==null) p_dupgroupid="";
	if (p_function_name==null) p_function_name="";
	if (check1==null) check1="";
%>
<form name='search_form' id='search_form'>
	<table border=0 width='100%' cellspacing=1 cellpadding=1 align='center'  >
		<th class='columnheader' colspan=6  width='100%'><fmt:message key="Common.GroupDetails.label" bundle="${common_labels}"/></th>
		<tr>
		<%
			if (!p_function_name.equals("insert"))
			{
		%>
				
		<td width='11%'  class='data'><b><fmt:message key="Common.patient.label" bundle="${common_labels}"/> <fmt:message key="Common.Series.label" bundle="${common_labels}"/><b></td>
	
		<td width='5%'  class='data'><b><fmt:message key="Common.delete.label" bundle="${common_labels}"/> <b></td>
				<td width='25%' class='data'>&nbsp;&nbsp; <b><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></b></td>
				<td width='5%'  class='data'><b><fmt:message key="Common.main.label" bundle="${common_labels}"/></b></td>
				<td width='5%'  class='data'><b><fmt:message key="eDR.Duplicate.label" bundle="${dr_labels}"/></b></td>

		<%
			}
		else
			{
		%>
			<td width='20%' class='data'><b><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></b></td>
			<td width='5%'  class='data'><b><fmt:message key="Common.main.label" bundle="${common_labels}"/></b></td>
			<td width='5%'  class='data'><b><fmt:message key="eDR.Duplicate.label" bundle="${dr_labels}"/></b></td>
		</tr>
</table>
		<%
			}
		%>

<table border=0 width='100%' cellspacing=0 cellpadding=0 align='center'  >
<%

if (p_dup_group_id != "")
{

	str = "select dup_group_id,patient_id,dup_indicator,nvl(remarks,' ') remarks from dr_dup_group_dtls where dup_group_id='"+p_dup_group_id+"' ";
	
		rs = stmt.executeQuery(str) ;

	while (rs.next())
	{
		p_patient_id = rs.getString("patient_id");
		p_dup_ind    = rs.getString("dup_indicator");
		p_remarks    = rs.getString("remarks");
			
	p_string_val = p_string_val + p_patient_id +"`"+ p_dup_ind +"`"+ p_remarks +"~" ;

	}

}

%>
<input type='hidden' name='p_string_val' id='p_string_val' value="<%=p_string_val%>">

<%
if (p_dup_group_id=="")
	{
		p_dup_group_id = p_dupgroupid;
	}
	else if (p_dupgroupid=="")
	{
		p_dupgroupid = p_dup_group_id;
	}
	if (!p_string_val.equals(""))
		{
		
			StringTokenizer splitedtoken = null;
			String tokenvalue = "";

			tokenvalue="";
			i = 0;
		StringTokenizer token1=new StringTokenizer(p_string_val,"~");

			while(token1.hasMoreTokens())
			{
					i++ ;
					tokenvalue      = token1.nextToken();
					
					splitedtoken=new StringTokenizer(tokenvalue,"`");

				while (splitedtoken.hasMoreTokens())
				{	
					p_patient_id		=	splitedtoken.nextToken();
					p_dup_ind			=	splitedtoken.nextToken();
					p_remarks			=	splitedtoken.nextToken();
					p_patient_line		=	d.name_age_sex(session ,p_patient_id,con,locale);
						
			
			if (p_dup_ind.equals("V"))
				{
					p_valid_check = "checked";
					p_dup_check = "unchecked";
					p_not_check = "unchecked";
				}
				if (p_dup_ind.equals("D"))
				{
					p_valid_check = "unchecked";
					p_dup_check = "checked";
					p_not_check = "unchecked";
				}

				if (p_dup_ind.equals("X"))
				{
					p_valid_check = "unchecked";
					p_dup_check = "unchecked";
					p_not_check = "checked";
				}					
                  String str1="SELECT PAT_SER_GRP_CODE FROM mp_patient WHERE patient_id='"+p_patient_id+"'";
					rs1 = stmt1.executeQuery(str1);
					while(rs1.next())
					{	
		          pat_series=rs1.getString("PAT_SER_GRP_CODE")==null?"":rs1.getString("PAT_SER_GRP_CODE");
					}
                 if(rs1!=null) rs1.close();
%>
		<tr>		

		<%
			if (!p_function_name.equals("insert"))
			{			
				if(p_dup_ind.equals("V")){
		%>			
		<td width='11%' class='data'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=pat_series%></td>
		<td width='5%'  class='label' >&nbsp;&nbsp;&nbsp;<input type=checkbox disabled name='deletePatient<%=i%>' id='deletePatient<%=i%>' value=''></td>
		<%}else
				{%>
				<td width='11%' class='data'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=pat_series%></td>
				<td width='5%'  class='label' >&nbsp;&nbsp;&nbsp;<input type=checkbox  name='deletePatient<%=i%>' id='deletePatient<%=i%>' value=''></td>

				<%}%>
		
		<td width='25%' >&nbsp;&nbsp;<a href='javascript:viewPatientDetails("<%=p_patient_id%>")'>+</a><a href='javascript:callHeaderScreen("<%=p_patient_id%>","<%=p_dup_ind%>","<%=i%>",
	"<%=p_function_name%>","<%=p_dup_group_id%>")'><font size=1>  <%=p_patient_id%>	</font></a>
			</td>
		
		<%
			}else {
		%>
			<td width='21%' ><a href='javascript:viewPatientDetails("<%=p_patient_id%>")'>+</a><a href='javascript:callHeaderScreen("<%=p_patient_id%>","<%=p_dup_ind%>","<%=i%>","<%=p_function_name%>","<%=p_dup_group_id%>")'><font size=1>  <%=p_patient_id%>	</font></a>
			</td>
			<%}%>
			
			<td width='5%' class='fields' align='center' id='yyy'>
						<input type=hidden name='patient_id<%=i%>' id='patient_id<%=i%>' value='<%=p_patient_id%>'>	
						<input type=hidden name='dup_indicator<%=i%>' id='dup_indicator<%=i%>' value='<%=p_dup_ind%>'>	
						<input type=hidden name='remarks<%=i%>' id='remarks<%=i%>' value="<%=p_remarks%>">	
                       
				<%
					if (p_valid_check.equals("checked"))
					{
					 if (!p_function_name.equals("insert"))
						{
					 %>
					
					&nbsp;&nbsp<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG></td>
						<%
						}else
						{%>
						<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td>
					   <%}
					    }
			            %>
			             
				 <td width='5%' class='fields' align='center' id='xxx'>
		<%
			if (p_dup_check.equals("checked"))
			{
				
		%>
			&nbsp;&nbsp;	<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG></td>
		<%
			}
		%>
				
			</td>

			</tr>
			<tr>
			<%
			if (!p_function_name.equals("insert"))
			{					
		%>
			<td width='6%' ></td>
			<td colspan='4' class=othlanglabel><font size="1"> <%=p_patient_line%></font>
          <%} else{%>
			<td colspan='4' class=othlanglabel><font size="1"> <%=p_patient_line%></font>
			<%}%>
		</td>
			</tr>

            <%			
			}
			
			}

			
     %>	     
		<input type="hidden" name='no_of_records' id='no_of_records' value='<%=i%>'>	

		<input type='hidden' name='p_string_old_val_new' id='p_string_old_val_new' value="<%=p_string_val%>">
		<input type='hidden' name='end' id='end' value=''>
		<input type='hidden' name='max_record' id='max_record' value=''> 
		<input type="hidden" name='dupgroupid' id='dupgroupid' value='<%=p_dupgroupid%>'>	
        <input type=hidden name='count' id='count' value="">	
<%
			
		if (p_mode.equals("add"))
		{
			
%>
		<script>
			var function_name = 
  
          parent.parent.frames[1].frames[0].document.forms[0].function_name.value;
		 // alert(parent.parent.frames[1].frames[0].document.forms[0].p_flag_value.value)
		
			var p_flag_value=parent.parent.frames[1].frames[0].document.forms[0].p_flag_value.value
		if (parent.parent.frames[1].frames[0].document.forms[0])
			{
				parent.parent.frames[1].frames[0].document.forms[0].p_string_value.value = "<%=p_string_val%>";		
				var p_string_val = parent.parent.frames[1].frames[0].document.forms[0].p_string_value.value;
				
			 parent.parent.frames[1].frames[0].location.href="../../eDR/jsp/EnterDuplicatesAddPatId.jsp?p_flag_value="+p_flag_value+"&p_string_val="+encodeURIComponent(p_string_val)+"&function_name="+function_name;
			}
		</script>

<%
		}
		else
			{
		
%>
		<script>
		
			parent.parent.frames[1].frames[1].document.forms[0].for_mod_val.value = "<%=p_string_val%>";
		</script>
<%			}
		}
	if(rs!=null)	rs.close();
	if(rs1!=null)   rs1.close();
	if(stmt!=null) stmt.close();
     if(stmt1!=null) stmt1.close();
}
catch(Exception e)
{
	out.println(e);
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>

</table>
<input type="hidden" name="chkcancel" id="chkcancel" value='<%=i%>'>
</form>
</body>
</html>

