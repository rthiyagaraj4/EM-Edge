<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<HTML><head><%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

</head><BODY  class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()';>
<%
	String operating_facility_id="";
	request.setCharacterEncoding("UTF-8");
    //operating_facility_id =(String) session.getValue("facility_id");
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer();
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;
	Connection con=null;

	String facility_name="";          
	String proc_id="";                 
  
	String proc_srt_cmd="";           
	String failed_proc_id="";         
	String msg_num="";                
	String app_msg="";                
	String err_msg="";                
	String msg_date_time="";          
	String app_key="";

	

	String date_from="";
	String date_to="";

	try{
	con = ConnectionManager.getConnection(request);

	Statement stmt=null;
	ResultSet rs=null;
	stmt = con.createStatement();
if ( (whereClause == null || whereClause.equals("")) )
	{

	 operating_facility_id = request.getParameter("facility_id");
	 facility_name=request.getParameter("facility_name");
	 proc_id= request.getParameter("proc_id");

	 date_from= request.getParameter("date_from");	 
	date_from=DateUtils.convertDate(date_from,"DMY",localeName,"en");	
	 date_to= request.getParameter("date_to");	 
	date_to= DateUtils.convertDate(date_to,"DMY",localeName,"en");
	
	int andCheck = 0;

	if ( !(date_from == null || date_from.equals("")) )
	{
%>
	<script>
		if(!checkDt("<%=date_from%>"))
		{
			alert(getMessage("INVALID_DATE_FMT",'SM'));
			history.go(-1);
		}
	</script>
<%
	}


	if ( !(date_to == null || date_to.equals("")) )
	{
%>
	<script>
		if(!checkDt("<%=date_to%>"))
		{
			alert(getMessage("INVALID_DATE_FMT",'SM'));
			history.go(-1);
		}
	</script>
<%
	}


	if ( !(operating_facility_id == null || operating_facility_id.equals("")) )
		{
		sql.append("where  upper(operating_facility_id) like upper('"+operating_facility_id+"%') ");
		andCheck = 1;
		}
	if ( !(facility_name == null || facility_name.equals("")) )
		{
			if(andCheck==1)		sql.append(" and upper(facility_name)  like upper('"+facility_name+"%')  ");
			else 
			{
				sql.append(" where upper(facility_name)  like upper('"+facility_name+"%') ");
				andCheck = 1;
			}
		}
	//sql.append(" where operating_facility_id='"+operating_facility_id+"' ");
	//andCheck = 1;

	if ( !(proc_id == null || proc_id.equals("")) )
	{
		if(andCheck==1) 		sql.append(" and upper(proc_id) like  upper('"+proc_id+"%') ");
		else
		{
			sql.append(" where upper(proc_id) like  upper('"+proc_id+"%') ");
			andCheck = 1;
		}
	}
	if ( !(date_from == null || date_from.equals("")) )
	{
		if(andCheck==1) 		sql.append(" and msg_date_time >= to_date('"+date_from+"','dd/mm/yyyy')  ");
		else
		{
			sql.append(" where msg_date_time>= to_date('"+date_from+"','dd/mm/yyyy')  ");
			andCheck = 1;
		}
	}
	
		if ( !(date_to == null || date_to.equals("")) )
	{
			if(andCheck==1) 		sql.append(" and msg_date_time < to_date('"+date_to+"','dd/mm/yyyy') + 1 ");
			else					 		
			{
				sql.append(" where msg_date_time <  to_date('"+date_to+"','dd/mm/yyyy') +1  ");
				andCheck = 1;
			}
	}
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");
		if ( !(ord == null || ord .equals("")) )
		{
			sql.append(" order by ");

			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				{
				if(ord[i].equals("msg_date_time") )
					{
						sql.append(ord[i]+ " desc");
					}
				else
					{
						sql.append(ord[i]);
					}

				}
			else
				{
					if(ord[i].equals("msg_date_time") )
					{
						sql.append(ord[i]+" desc ,");
					}
					else
					{
						sql.append(ord[i]+" ,");
					}
				}
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
	  	end = 4 ;
	else
		end = Integer.parseInt( to ) ;


try
	{
		int cnt = 0;
		String endOfRes="1";

		String strsql2="select operating_facility_id, facility_name, proc_id, proc_name, proc_srt_cmd, failed_proc_id, msg_num, app_msg, err_msg, to_char(msg_date_time,'dd/mm/yyyy hh24:mi:ss') msg_date_time1 , app_key  from sm_proc_msg_vw  "+sql.toString();
		
		
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql2);
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
	<A HREF='../../eSM/jsp/ProcQueryResult.jsp?from=<%=(start-4)%>&to=<%=(end-4)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
	<%}
if (endOfRes.equals("1"))
		{%>
	<A id='nextval' HREF='../../eSM/jsp/ProcQueryResult.jsp?from=<%=(start+4)%>&to=<%=(end+4)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>

<%}%>
</td>
</tr>
</table>
<br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<tr>
	<th align=left><fmt:message key="Common.MessageDate/Time.label" bundle="${common_labels}"/></th>
	<th align=left><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
</tr>
<tr>
	<th align=left><fmt:message key="Common.ProcessID.label" bundle="${common_labels}"/></th>
	<th align=left><fmt:message key="eSM.FailedProcessID.label" bundle="${sm_labels}"/></th>
</tr>
<tr>
	<th colspan=4 align=left><fmt:message key="Common.ErrorMessage.label" bundle="${common_labels}"/></th>
</tr>


<%}

						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
							       
						operating_facility_id=rs.getString("operating_facility_id");
						if( operating_facility_id==null) operating_facility_id="";

						facility_name=rs.getString("facility_name");
						if (facility_name.length()<35)
						{
								int x=35-facility_name.length();
								for(int a=0; a<=x; a++)
								{
									facility_name=facility_name+"&nbsp;";
								}
						}


						proc_id	=rs.getString("proc_id");
						if( proc_id==null) proc_id="";
						if (proc_id.length()<30)
						{
								int x=30-proc_id.length();
								for(int a=0; a<=x; a++)
								{
									proc_id=proc_id+"&nbsp;";
								}
						}

						proc_srt_cmd=rs.getString("proc_srt_cmd");
						if( proc_srt_cmd==null) proc_srt_cmd="";

						failed_proc_id=rs.getString("failed_proc_id");
						if( failed_proc_id==null) failed_proc_id="";
						if (failed_proc_id.length()<30)
						{
								int x=30-failed_proc_id.length();
								for(int a=0; a<=x; a++)
								{
									failed_proc_id=failed_proc_id+"&nbsp;";
								}
						}

						msg_num=rs.getString("msg_num");
						if( msg_num==null) msg_num="";

						app_msg=rs.getString("app_msg");
						if( app_msg==null) app_msg="";

						err_msg=rs.getString("err_msg");
						if( err_msg==null) err_msg="";

						msg_date_time=rs.getString("msg_date_time1");
						if( msg_date_time==null) msg_date_time="";
						else msg_date_time = DateUtils.convertDate(msg_date_time,"DMYHMS","en",localeName);
						app_key=rs.getString("app_key");
						if( app_key==null) app_key="";
						%>
						<tr>
						<td  nowrap align=left class='<%=classValue%>'>
						<%=msg_date_time%></td>
					
						<td  nowrap align=left class='<%=classValue%>'>
						<%=facility_name%></td></tr>
						<tr><td nowrap align=left class='<%=classValue%>'>
						<%=proc_id%></td>
						<td nowrap align=left class='<%=classValue%>'>
						<%=failed_proc_id%></td></tr>
						<tr><td  colspan=2 class='<%=classValue%>'>
						<%=app_key%><br><%=app_msg%><br><%=err_msg%><br><br></td></tr>
						<%
						i++;
						cnt++;
	}  
	if( cnt == 0 )
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
	if(!rs.next()&&cnt!=0){
		endOfRes="0";
		%>
		<script>
			document.getElementById('nextval').innerHTML=" ";
		</script>
	<%}
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
		
					%>
		</table>
<%
								
}
			catch(Exception e)
			{
				out.print("here3"+e.toString());
				e.printStackTrace();
			}
						if(rs!=null) 	rs.close();
						if(stmt!=null) 	stmt.close();					
			
	}catch(Exception e){
		out.println(e);
		e.printStackTrace();
		}
	finally { 
	ConnectionManager.returnConnection(con,request);
}	

%>
</center>
</BODY>
</HTML>

