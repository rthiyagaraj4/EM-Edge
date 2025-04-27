<!DOCTYPE html>
<%@ page import="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<HTML>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eSM/js/Report.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function CheckFacilityBased(obj,val)
{
	if(obj.checked)
	{
		eval("document.forms[0].Report_Group"+val).options[0].selected=true;

		eval("document.forms[0].Report_Group"+val).disabled = true;
		obj.value='Y';
		eval("document.forms[0].facBased"+val).value='Y';
		eval("document.forms[0].repGrp"+val).value=eval("document.forms[0].Report_Group"+val).value;
	}
	else 
	{
		eval("document.forms[0].Report_Group"+val).options[0].selected=true;
		eval("document.forms[0].Report_Group"+val).disabled = false;
		obj.value="";
		eval("document.forms[0].facBased"+val).value='N';
		eval("document.forms[0].repGrp"+val).value=eval("document.forms[0].Report_Group"+val).value;
	}	
}	

function finalSelect(obj,val)	
{
	if(obj.checked)
	{
		eval("document.forms[0].Select_Yn"+val).value="Y";
	}
	else
	{
		eval("document.forms[0].Select_Yn"+val).value="N"; 
	}
}
			 
function chkgroup(obj,val)
{
  eval("document.forms[0].repGrp"+val).value=obj.value;
}

</script>
</head>

<BODY class='CONTENT' onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()' >
<form name="query_report_table" id="query_report_table" action="../../servlet/eSM.ReportServlet" method="post" target="messageFrame">
<%					 
Connection conn = null;
try{
	     request.setCharacterEncoding("UTF-8");
	conn = ConnectionManager.getConnection(request);
	java.sql.Statement stmt=conn.createStatement();
	java.sql.Statement stmt1=conn.createStatement();
	java.sql.Statement stmt2=conn.createStatement();
	java.sql.Statement stmt3=conn.createStatement();

	ResultSet rs1=null;
	ResultSet rs3=null;

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer() ;
	String from = request.getParameter( "from" ) ;
	String Report_Group_Id="";
	String sel="";
	String modulename = request.getParameter("module_name");
	String name=request.getParameter("name");

	if ((whereClause == null || whereClause.equals("")) ) 
	{
		if(sql.length() > 0) sql.delete(0,sql.length());
				
		String Report_Id = request.getParameter("Report_Id");
		String Report_Desc = request.getParameter("Report_Desc");	 
		String Report_Class = request.getParameter("Report_Class");
		String Transaction_Based_Yn = request.getParameter("Transaction_Based_Yn");
		String Internal_Request_Yn = request.getParameter("Internal_Request_Yn");
		
		Report_Group_Id = request.getParameter("Report_Group_Id")==null ? "" : request.getParameter("Report_Group_Id");
		
		int andCheck = 0;

		if ( !(modulename == null || modulename.equals("")) ) 
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("where ACCEPT_ADHOC_EMAILID_YN='N' and module_id like '"+modulename+"%'");
			andCheck = 1;
		}

		if ( !(Report_Id == null || Report_Id.equals("")) ) 
		{
			if ( andCheck == 1 )
			{	
				sql.append(" and ");
				sql.append("upper(Report_Id) like  upper('"+Report_Id+"%')");
		    }
			else 
			{	
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where ACCEPT_ADHOC_EMAILID_YN='N' and  upper(Report_Id) like upper('"+Report_Id+"%')");
				andCheck = 1;
		    }
	    }

		if ( !(Report_Desc == null || Report_Desc.equals("")) ) 
		{
			if ( andCheck == 1 )
			{	
				sql.append(" and ");
				sql.append(" upper(Report_Desc) like  upper('"+Report_Desc+"%') ");
			}
			else 
			{	
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where ACCEPT_ADHOC_EMAILID_YN='N' and  upper(Report_Desc)  like upper('"+Report_Desc+"%') ");
				andCheck = 1;
			}
		}

		if ( !(Report_Class == null || Report_Class.equals("")) )
		{
			if ( andCheck == 1 ) 
			{	
				sql.append(" and ");
				sql.append("upper(Report_Class) =upper('"+Report_Class+"')");
			}
			else 
			{	
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where ACCEPT_ADHOC_EMAILID_YN='N' and  upper(Report_Class) =upper('"+Report_Class+"')");
				andCheck = 1;
			}
		}

		if ( !(Transaction_Based_Yn == null ||Transaction_Based_Yn.equals("")) ) 
		{
			if ( andCheck == 1 ) 
			{	
				sql.append(" and ");
				sql.append("upper(Transaction_Based_Yn) =upper('"+Transaction_Based_Yn+"')");
			}
			else
			{	
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where ACCEPT_ADHOC_EMAILID_YN='N' and  upper(Transaction_Based_Yn) =upper('"+Transaction_Based_Yn+"')");
				andCheck = 1;
			}
		}

		if ( !(Internal_Request_Yn == null || Internal_Request_Yn.equals("")))
		{
			if ( andCheck == 1 )
			{	
				sql.append( " and ");
				sql.append("upper(Internal_Request_Yn) =upper('"+Internal_Request_Yn+"')");
			}
			else
			{	
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where ACCEPT_ADHOC_EMAILID_YN='N' and  upper(Internal_Request_Yn) =upper('"+Internal_Request_Yn+"')");
				andCheck = 1;
			}
		}

		if ( !(Report_Group_Id == null || Report_Group_Id.equals("")) ) 
		{
			if ( andCheck == 1 ) 
			{	
				sql.append(" and ");
				sql.append("upper(Report_Group_Id) like upper( '"+Report_Group_Id+"%')");
			}
			else
			{	
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where ACCEPT_ADHOC_EMAILID_YN='N' and  upper(Report_Group_Id) like upper('"+Report_Group_Id+"%')");
				andCheck = 1;
			}
		}

		String ord[] = request.getParameterValues("orderbycolumns");
         
		if ( !(ord == null || ord .equals("")) )
		{	
			sql.append(" order by ");
			for ( int i=0;i < ord.length;i++ )
			{	
			if ( i == ord.length - 1 )
				sql.append(ord[i]);
			else 
				sql.append(ord[i]+",");
			}			
		}
	} 
	else 
	{
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append(whereClause);
	}
	
	int start = 0 ;       
	int i=1;
		
	if ( from == null )
	{
		start = 1 ;
	}
	else
	{
		start = Integer.parseInt( from ) ; 
	}
	
	ResultSet rs=null;
	int cnt=0;
			
	rs = stmt.executeQuery("select * from Sm_Report_vw "+sql.toString()); 

		if ( start != 1 )   
		for( int j=1; j<start; i++,j++ ) 
			rs.next() ;
String Report_Group_Id1="";
			 
		while ( rs.next()) 
		{ 
	if(cnt==0){
	

	%>

	<table border="2" width="100%" cellspacing='0' cellpadding='0'>
	<tr>
	<th><fmt:message key="Common.Module.label" bundle="${common_labels}"/></th>
	<th align=left><%=name%></th></tr>

	<th><fmt:message key="Common.ReportID.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.ReportDesc.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="eSM.TransBased.label" bundle="${sm_labels}"/></th>
	<th><fmt:message key="eSM.InternalRequest.label" bundle="${sm_labels}"/></th>
	<th><fmt:message key="Common.FacilityBased.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="eSM.ReportGroup.label" bundle="${sm_labels}"/>&nbsp;<!-- <img src='../../eCommon/images/mandatory.gif'></img> --></th>
	<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th> 
	
	<% }
 	

			String classValue = "" ;	
			String Rep_Group_Id = "";			 

			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
		%>
		
		<%
		//String modname = rs.getString("module_name"); 
		String M_ID = rs.getString("module_id"); 
		String R_ID = rs.getString("Report_Id");        
        String short_desc="";		
		String Transaction_Based_Yn =rs.getString("Transaction_Based_Yn"); 		
		String Internal_Request_Yn =rs.getString("Internal_Request_Yn");		
		String Facility_Based_Yn =rs.getString("Facility_Based_Yn");
		Rep_Group_Id =rs.getString("report_group_id");
		if(Rep_Group_Id==null) Rep_Group_Id="";
		%>
		<tr>
			<td align='left' class='<%=classValue%>'>
			<a  href='javascript:showWindow("<%=M_ID%>","<%=R_ID%>");'><%=R_ID%></a></td>

			<td align='left' class='<%=classValue%>'>		
			<%=rs.getString("Report_Desc")%></td>
				   
				<td align='center' class='<%=classValue%>'>
					  <%if(Transaction_Based_Yn.equals("Y")){%>
				  <img src='../../eCommon/images/enabled.gif'></img>
				<%}else{%> 
				  
				 <img src='../../eCommon/images/disabled.gif'></img>
				<%}%>  </td>
				
				<td align='center' class='<%=classValue%>'>
					<%if(Internal_Request_Yn.equals("Y")){%>
				  <img src='../../eCommon/images/enabled.gif'></img>
				<%}else{%> 
				  
				 <img src='../../eCommon/images/disabled.gif'></img>
				<%}%>  </td>

		<%String  var = "";
		if(Internal_Request_Yn.equals("N")&& Transaction_Based_Yn.equals("N"))
		{
			var = "";			
			if(Facility_Based_Yn.equals("Y"))
			{
				%>	
				<td class='<%=classValue%>'>&nbsp;&nbsp;&nbsp;
				<input type='checkbox' name='Facility_Based_Yn<%=i%>' id='Facility_Based_Yn<%=i%>' value= "" checked onClick="CheckFacilityBased(this,'<%=i%>');" <%=var%> >
				<input type='hidden' name='facBased<%=i%>' id='facBased<%=i%>' value='Y'></td> 
				<td class='<%=classValue%>'>  								
				<select name='Report_Group<%=i%>' id='Report_Group<%=i%>'onchange="chkgroup(this,'<%=i%>');" disabled nowrap ><option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<%
			}
			else
			{
				%>
				<td class='<%=classValue%>'>&nbsp;&nbsp;&nbsp;
				<input type='checkbox' name='Facility_Based_Yn<%=i%>' id='Facility_Based_Yn<%=i%>' value= ""  onClick="CheckFacilityBased(this,'<%=i%>')" <%=var%> >
				<input type='hidden' name='facBased<%=i%>' id='facBased<%=i%>' value='N'></td> 
				<td class='<%=classValue%>'>  								
				<select name='Report_Group<%=i%>' id='Report_Group<%=i%>'onchange="chkgroup(this,'<%=i%>');" nowrap ><option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
			   <%
			}
			%>	
			<%
		}
		else if(Internal_Request_Yn.equals("Y")&& Transaction_Based_Yn.equals("Y"))
		{%>
			<td class='<%=classValue%>'>&nbsp;&nbsp;&nbsp;
			<input type='checkbox' name='Facility_Based_Yn<%=i%>' id='Facility_Based_Yn<%=i%>' value= "Y"  checked disabled onClick="CheckFacilityBased(this,'<%=i%>');"></td>          
			<td class='<%=classValue%>'>  								
			<select name='Report_Group<%=i%>' id='Report_Group<%=i%>'disabled nowrap ><option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
		<%}
		else 
		{
			if(Facility_Based_Yn.equals("Y")){
			%>
				<td class='<%=classValue%>'>&nbsp;&nbsp;&nbsp;
				<input type='checkbox' name='Facility_Based_Yn<%=i%>' id='Facility_Based_Yn<%=i%>' value= "" checked onClick="CheckFacilityBased(this,'<%=i%>');" >
				<input type='hidden' name='facBased<%=i%>' id='facBased<%=i%>' value='Y'></td>
				<td class='<%=classValue%>'>  								
				<select name='Report_Group<%=i%>' id='Report_Group<%=i%>' onchange="chkgroup(this,'<%=i%>');" disabled nowrap><option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
			<%}
			else
			{%>
				<td class='<%=classValue%>'>&nbsp;&nbsp;&nbsp;
				<input type='checkbox' name='Facility_Based_Yn<%=i%>' id='Facility_Based_Yn<%=i%>' value= ""  onClick="CheckFacilityBased(this,'<%=i%>');" <%=var%> >
				<input type='hidden' name='facBased<%=i%>' id='facBased<%=i%>' value='N'></td>
				<td class='<%=classValue%>'>  								
				<select name='Report_Group<%=i%>' id='Report_Group<%=i%>' onchange="chkgroup(this,'<%=i%>');" nowrap><option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<%
			}%>          
			<%
		}
			
		rs1 = stmt1.executeQuery("Select Report_Group_Id,Short_Desc from Sm_Report_Group where eff_status='E'  order by Short_Desc"); 
		if(rs1!=null)	
		{
			while(rs1.next())
			{ 
				Report_Group_Id1=rs1.getString("Report_Group_Id")==null ? "" : rs1.getString("Report_Group_Id");
				short_desc=rs1.getString("Short_Desc");
				sel="";
				if(Rep_Group_Id.equals(Report_Group_Id1))
					sel="selected";
				
				%> 
				<option value='<%=Report_Group_Id1%>'<%=sel%>><%=short_desc%></option>
				<%
			} 
		}if(rs1 !=null) rs1.close();
		%> </select>          
			</td> 
			<input type='hidden' name='repGrp<%=i%>' id='repGrp<%=i%>' value='<%=Rep_Group_Id%>'>
			<td class='<%=classValue%>'>
			&nbsp;&nbsp;&nbsp;<input type = checkbox name ='Select_Yn<%=i%>' onClick="finalSelect(this,'<%=i%>');" value = "" ></td>
			<input type='hidden' name='reportId<%=i%>' id='reportId<%=i%>' value='<%=R_ID%>'>
			<input type='hidden'name='reportGroup<%=i%>'value='<%=Report_Group_Id%>'>
		<% 
		i++;
		cnt++;
		}
		if( cnt == 0 )
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
		if(rs !=null) rs.close();
		
		if(rs3 !=null) rs3.close();
		if(stmt != null) stmt.close();
		if(stmt1 != null) stmt1.close();
		if(stmt2 != null) stmt2.close();
		if(stmt3 != null) stmt3.close();
		sql.setLength(0);     
		%>
        
        <input type='hidden'name='maxrecord'value='<%=i%>'>			
</tr>
</table>
<br><center>
</center>
</form>
</BODY>
</HTML>
<%
   }catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(conn,request);
}	
%>

