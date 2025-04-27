<!DOCTYPE html>
<%@ page import  ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<HTML><head><%
         request.setCharacterEncoding("UTF-8");
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	</head><BODY onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()'   class='CONTENT'>
<%

Connection conn=null;

//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
boolean isSSOIntegrationAppl = false;
String active_dir_id = "";

try{

	conn = ConnectionManager.getConnection(request);

	//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
	isSSOIntegrationAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "SM", "SSO_INTEGRATION");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer();
	sql.append(" where b.facility_id (+) = a.rep_facility_id  " );
	String from = request.getParameter( "from" );
	String to = request.getParameter( "to" );
	if ( (whereClause == null || whereClause.equals("")) )
	{
		String cd = request.getParameter("appl_user_id");
		String ccd=request.getParameter("appl_user_name");
		String funcroletype=request.getParameter("func_role_type");
		String practtype=request.getParameter("pract_type");
		String other_staff_type=request.getParameter("other_staff_type");
		String practname=request.getParameter("pract_name");
		String enabled = request.getParameter("eff_status");
		String pract_id = request.getParameter("pract_id");
		String employeeNo=request.getParameter("emp_no");
		
		//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
		if(isSSOIntegrationAppl){
			active_dir_id = request.getParameter("active_dir_id");

			if ( !(active_dir_id == null || active_dir_id.equals("")) ){
				sql.append(" and upper(a.active_dir_id) like upper('"+active_dir_id+"%')");
			}
		}

		if ( !(cd == null || cd.equals("")) ){
			sql.append(" and upper(a.appl_user_id) like upper('"+cd+"%')");
		}

		if ( !(employeeNo == null || employeeNo.equals("")) ){
			sql.append(" and upper(a.employee_no) like upper('"+employeeNo+"%')");
		}

		if ( !(pract_id == null || pract_id.equals("")) ){
			sql.append(" and upper(a.FUNC_ROLE_ID) like upper('"+pract_id+"%')");
		}

		if ( !(ccd == null || ccd.equals("")) )	{
			sql.append(" and upper(a.appl_user_name)  like  upper('"+ccd+"%')");
		}

		if ( funcroletype.equals("P")){
			sql.append(" and a.FUNC_ROLE  =  '"+funcroletype+"' ");
		}
		else if( funcroletype.equals("O"))
		{
			sql.append(" and a.FUNC_ROLE  =  '"+funcroletype+"' ");
		}
		
		if ( !(practtype == null || practtype.equals("")) )
		{
			sql.append(" and upper(a.pract_type)  like  upper('"+practtype+"%') ");
		}
        
		if ( !(other_staff_type == null || other_staff_type.equals("")) )
		{
			sql.append(" and upper(a.pract_type)  like  upper('"+other_staff_type+"%') ");
		}

		if ( !(practname == null || practname.equals("")) )
		{
			sql.append(" and upper(a.practitioner_name)  like  upper('"+practname+"%') ");
		}

		if ( !(enabled == null || enabled.equals("")) )
			{
			     if( enabled.equals("E") )
			     {
				   sql.append(" and a.eff_status='E'");
			     }
			     if ( enabled.equals("D") ) {
     	           sql.append(" and a.eff_status='D'");
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
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;


	java.sql.Statement stmt=null;
	ResultSet rs=null;
	int cnt = 0;
	String endOfRes="1";

	stmt = conn.createStatement();
String sql2="select a.appl_user_id,a.appl_user_name,b.facility_id,b.facility_name,a.employee_no,a.eff_date_from,a.eff_date_to,a.eff_status, a.FUNC_ROLE FUNC_ROLE , a.PRACTITIONER_NAME PRACTITIONER_NAME,a.DESC_SYSDEF DESC_SYSDEF,a.FUNC_ROLE_ID, a.active_dir_id from sm_appl_user_vw a,sm_facility_param b "+sql.toString();
rs = stmt.executeQuery(sql2);
 	if ( start != 1 )
 	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	  String classValue = "" ;
	  
	  while ( i<=end  && rs.next()){
		  if(cnt==0){
%>
<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	{%>
	<A HREF='../jsp/queryUser.jsp?from=<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
<%}
if ( endOfRes.equals("1"))
	{%>

	<A id='nextval' HREF='../jsp/queryUser.jsp?from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>

<%}%>
</td>
</tr>
</table>
<br><br>
</p>


<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.userid.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.username.label" bundle="${common_labels}"/></th>
<th><fmt:message key="eSM.FunctionalRoleType.label" bundle="${sm_labels}"/></th>
<th><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.EmployeeNo.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></th>

<!--Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2-->
<%if(isSSOIntegrationAppl){%>
	<th><fmt:message key="eSM.ActiveDirectoryID.label" bundle="${sm_labels}"/></th>
<%}%>

<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%}


java.sql.Date date=null;
java.util.Date date1=null;
SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;
		  %>

	<tr><td class='<%=classValue%>'>
	<%
	String code = rs.getString(1);
	String practName= rs.getString("PRACTITIONER_NAME");
	if(practName == null) practName="&nbsp;";
	
	String practID= rs.getString("FUNC_ROLE_ID");
	if(practID == null || practID.equals("null")) practID="&nbsp;";
	%>
	<a href='../jsp/User_Form.jsp?appl_user_id=<%=java.net.URLEncoder.encode(code)%>&practName=<%=java.net.URLEncoder.encode(practName)%>' target='f_query_add_mod' >
	<%=code%></a></td><td class='<%=classValue%>'>
	<%=rs.getString(2)%>
	</td><td class='<%=classValue%>'>
	<%

	if(rs.getString("FUNC_ROLE") != null)
		{
		   
           if(rs.getString("FUNC_ROLE").equals("P"))
	        out.println("Practitioner");
		   else
			   out.println("Other Staff");

		}
	else
	{%>
		&nbsp;
	<%}%>

	</td> <td class='<%=classValue%>'>
	<%
	if(rs.getString("DESC_SYSDEF") != null)
		out.println(rs.getString("DESC_SYSDEF"));
	else
		{%>
		&nbsp;
	<%}%>
	</td> <td class='<%=classValue%>'>
	<%=practID%>
	</td> <td class='<%=classValue%>'>
	<%
	if(rs.getString("PRACTITIONER_NAME") != null)
			out.println(rs.getString("PRACTITIONER_NAME"));
			else
			{%>
			&nbsp;
			<%}%>
	</td> <td class='<%=classValue%>'>

	<%
	String employee_no=rs.getString("EMPLOYEE_NO");
	if(employee_no==null)
		employee_no="&nbsp;";
	%>
	<%=employee_no%></td> <td class='<%=classValue%>'>
	<%
		if ( rs.getDate("eff_date_from") != null )
		{
		  date = rs.getDate("eff_date_from");
		
		 String dateString = formatter.format(date);
		 if( dateString==null) dateString="";
		else dateString = DateUtils.convertDate(dateString,"DMY","en",localeName);
		 out.println(dateString);
		 dateString = null;
		 //formatter = null;
		}
		else
		{%>
			&nbsp;
		<%}%>
		</td><td class='<%=classValue%>'>
		<%
		if ( rs.getDate("eff_date_to") != null )
		{
		  date1 = rs.getDate("eff_date_to");
		// SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
		 String dateString = formatter.format(date1);
		 if( dateString==null) dateString="";
		else dateString = DateUtils.convertDate(dateString,"DMY","en",localeName);
		 out.println(dateString);
		}
		else
		{%>
			&nbsp;
		<%}%>

		</td>
		
		<!--Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2--> 
		<%if(isSSOIntegrationAppl){%>
			<td class='<%=classValue%>'>
			<%
				String act_dir_id = rs.getString("active_dir_id");
				if(act_dir_id==null)
				act_dir_id="&nbsp;";
			%>
			<%=act_dir_id%></td>
		<%}%>
		
		
		<td align='center' class='<%=classValue%>'>
		<%
		if ( rs.getString("eff_status").equals("E") )
		{%>
			<img src='../../eCommon/images/enabled.gif'></img>
		<%}else{%>
			<img src='../../eCommon/images/disabled.gif'></img>
		<%}
		i++;
		cnt++;
	} 
	if( cnt == 0 )
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
	if(!rs.next()&&cnt!=0){
		endOfRes="0";
		%>
		<script>
			document.getElementById("nextval").innerHTML=" ";
		</script>
	<%}
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}
catch(Exception e){
out.println(e);}
finally
{
	if(conn!=null)
	ConnectionManager.returnConnection(conn,request);
}%>

</td></tr>
</table>
<br><center>
</center>
</BODY>
</HTML>

