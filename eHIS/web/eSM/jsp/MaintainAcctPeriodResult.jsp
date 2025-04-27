<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
       <script language='javascript' src='../../eSM/js/MaintainAccountingPeriod.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
<form name="maitain_acc_per" id="maitain_acc_per"  method="post" target="messageFrame">
<%
    request.setCharacterEncoding("UTF-8");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer();

	String acc_per_year="";
    String acc_per_month="";
	String acc_per_start_date="";
	String acc_per_end_date="";
	String cal_per_year="";
	String cal_per_month="";
    String acc_per_desc="";
	String classValue = "";
	String year="";
	String month="";
	String year1="";
	String desc="";
    String acc_per_year1="";
   // String acc_per_year2="";
	String acc_per_month1="";
	String acc_per_start_date1="";
    String acc_per_end_date1="";
	String acc_cal_year1="";
	//String acc_cal_year2="";
	String acc_cal_month1="";
     
     Connection con = ConnectionManager.getConnection(request);
	 PreparedStatement pstmt = null;
	 ResultSet rs = null;
	
     String from = request.getParameter( "from" ) ;
	 String to = request.getParameter( "to" ) ;


	 try{

         if ( (whereClause == null || whereClause.equals("")) )
	    {
          acc_per_year1 = request.getParameter("acc_per_year");
		  acc_per_year1 = DateUtils.convertDate(acc_per_year1,"YY",localeName,"en");
		 
          acc_per_month1 = request.getParameter("acc_per_month");
		  //acc_per_month1 = DateUtils.convertDate(acc_per_month1,"MM",localeName,"en");

          acc_per_start_date1 = request.getParameter("acc_per_start_date");
          acc_per_start_date1 = DateUtils.convertDate(acc_per_start_date1,"DMY",localeName,"en");

          acc_per_end_date1 = request.getParameter("acc_per_end_date");
		  acc_per_end_date1 = DateUtils.convertDate(acc_per_end_date1,"DMY",localeName,"en");

		  acc_cal_year1 = request.getParameter("acc_cal_year");
		  acc_cal_year1 = DateUtils.convertDate(acc_cal_year1,"YY",localeName,"en");

		  acc_cal_month1 = request.getParameter("acc_cal_month");
		  //acc_cal_month1 = DateUtils.convertDate(acc_cal_month1,"MM",localeName,"en");
          

		  int andCheck= 0;

   if ( !(acc_per_year1 == null || acc_per_year1.equals("")) )
		{
			sql.append("where upper(ACC_PER_YEAR) like upper('"+acc_per_year1+"%' )");
			andCheck = 1;
		}

   if ( !(acc_per_month1 == null || acc_per_month1.equals("")) )
		{
			if(andCheck == 1){
				sql.append(" and ");
				sql.append(" upper(ACC_PER_MONTH) like upper('"+acc_per_month1+"%' )");
			}
			else{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(ACC_PER_MONTH) like upper('"+acc_per_month1+"%' )");
				andCheck = 1;
			}
		}
  

  if ( !(acc_cal_year1 == null || acc_cal_year1.equals("")) )
		{
			if(andCheck == 1){
				sql.append(" and ");
				sql.append(" upper(CAL_PER_YEAR) like upper('"+acc_cal_year1+"%' )");
			}
			else{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(CAL_PER_YEAR) like upper('"+acc_cal_year1+"%' )");
				andCheck = 1;
			}
		}
  
  if ( !(acc_cal_month1 == null || acc_cal_month1.equals("")) )
		{
			if(andCheck == 1){
				sql.append(" and ");
				sql.append(" upper(CAL_PER_MONTH) like upper('"+acc_cal_month1+"%' )");
			}
			else{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(CAL_PER_MONTH) like upper('"+acc_cal_month1+"%' )");
				andCheck = 1;
			}
		}
  
   

if ( !(acc_per_start_date1 == null || acc_per_start_date1.equals("")) )
		{
	   if(andCheck == 1)
			{
		   
		sql.append("and ACC_PER_START_DATE=to_date('"+acc_per_start_date1+"','dd/mm/yyyy')");
		}
else{
	if(sql.length() > 0) sql.delete(0,sql.length());
   sql.append(" where ACC_PER_START_DATE = to_date('"+acc_per_start_date1+"','dd/mm/yyyy')");
   andCheck = 1;
    }
  }

  if ( !(acc_per_end_date1 == null || acc_per_end_date1.equals("")) )
		{
	   if(andCheck == 1){
		   
		sql.append(" and ACC_PER_END_DATE=to_date('"+acc_per_end_date1+"','dd/mm/yyyy')");
		}
		else{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("where ACC_PER_END_DATE = to_date('"+acc_per_end_date1+"','dd/mm/yyyy')");
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
			sql.append(ord[i]);
		else
			sql.append(ord[i]+",");
		}
	}


	} //end of where clause IF
	else
	{
	sql.setLength(0);
	sql.append(whereClause);

	}   
       
}
	 catch(Exception e){
		 out.println("valu "+ e);
		 e.printStackTrace();
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
		try
		{
			System.out.println("sql"+sql.toString());
			pstmt = con.prepareStatement("SELECT ACC_PER_YEAR, ACC_PER_MONTH, to_char(ACC_PER_START_DATE,'dd/mm/yyyy') ACC_PER_START_DATE1, to_char(ACC_PER_END_DATE,'dd/mm/yyyy') ACC_PER_END_DATE1, CAL_PER_YEAR, CAL_PER_MONTH, ACC_PER_DESC, ACC_PER_CLOSED_YN FROM SY_ACC_PERIOD_DEFN "+sql.toString());

			rs = pstmt.executeQuery();
			int cnt=0;
	  String endOfRes="1";
	  	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  {
	    rs.next() ;
	  }
  
 while (i<=end && rs.next()){
	if(cnt==0){

%>
<P>
<table align='right'>
<tr >
<td>
<%
if ( !(start <= 1) )
		{
	%>
	<A HREF='../../eSM/jsp/MaintainAcctPeriodResult.jsp?from=<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>

	<%
		}

if (endOfRes.equals("1"))
		{
	%>
		<A id='nextvalue' HREF='../../eSM/jsp/MaintainAcctPeriodResult.jsp?from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>

<%
		}
%>
</td>
</tr>
</table>
	<br><br>
</P>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<tr>
		
		    <th><fmt:message key="eSM.AccountPeriodYear.label" bundle="${sm_labels}"/></th>
			<th><fmt:message key="eSM.AccountPeriodMonth.label" bundle="${sm_labels}"/></th>
			<th><fmt:message key="eSM.AccountPeriodSdate.label" bundle="${sm_labels}"/></th>
			<th><fmt:message key="eSM.AccountPeriodEdate.label" bundle="${sm_labels}"/></th>
			<th><fmt:message key="eSM.AccountPeriodDesc.label" bundle="${sm_labels}"/></th>
            <th><fmt:message key="eSM.CalenderYear.label" bundle="${sm_labels}"/></th>
			<th><fmt:message key="eSM.CalenderMonth.label" bundle="${sm_labels}"/></th>
			</tr>

<%}		
cnt++;

if (i % 2 == 0 )
  	classValue = "QRYEVEN" ;
 else
  	classValue = "QRYODD" ;
 
  acc_per_year	= (rs.getString("ACC_PER_YEAR")==null?"&nbsp;":rs.getString("ACC_PER_YEAR"));
  acc_per_year = DateUtils.convertDate(acc_per_year,"YY","en",localeName);
  acc_per_month	= (rs.getString("ACC_PER_MONTH")==null?"&nbsp;":rs.getString("ACC_PER_MONTH"));
 // out.println(acc_per_month);
  acc_per_start_date	= (rs.getString("ACC_PER_START_DATE1")==null?"&nbsp;":rs.getString("ACC_PER_START_DATE1"));
  acc_per_start_date = DateUtils.convertDate(acc_per_start_date,"DMY","en",localeName);
  acc_per_end_date	= (rs.getString("ACC_PER_END_DATE1")==null?"&nbsp;":rs.getString("ACC_PER_END_DATE1"));
  acc_per_end_date = DateUtils.convertDate(acc_per_end_date,"DMY","en",localeName);
  acc_per_desc	= (rs.getString("ACC_PER_DESC")==null?"&nbsp;":rs.getString("ACC_PER_DESC"));
StringTokenizer str=new StringTokenizer(acc_per_desc);
while (str.hasMoreTokens()) {
	month=str.nextToken();
	year=str.nextToken();
year1= cal_per_year = DateUtils.convertDate(year,"YY","en",localeName);
desc=month+" "+year1;
}

  cal_per_year	= (rs.getString("CAL_PER_YEAR")==null?"&nbsp;":rs.getString("CAL_PER_YEAR"));
  cal_per_year = DateUtils.convertDate(cal_per_year,"YY","en",localeName);
  cal_per_month	= (rs.getString("CAL_PER_MONTH")==null?"&nbsp;":rs.getString("CAL_PER_MONTH"));
   out.println("<tr>");
   out.println("<td class='" + classValue + "'>"+acc_per_year +"</td>");
   out.println("<td class='" + classValue + "'>"+acc_per_month +"</td>");
   out.println("<td class='" + classValue + "'>"+acc_per_start_date +"</td>");
   out.println("<td class='" + classValue + "'>"+acc_per_end_date +"</td>");
   out.println("<td class='" + classValue + "'>"+desc +"</td>");
   out.println("<td class='" + classValue + "'>"+cal_per_year +"</td>");
    out.println("<td class='" + classValue + "'>"+cal_per_month +"</td>");
   out.println("</tr>");

				 i++;

	
			}

			if( cnt == 0 )						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");

		if(!rs.next()&&cnt!=0){
	endOfRes="0";
	%>
	<script>
		document.getElementById('nextvalue').innerHTML=" ";
	</script>
	<%}
	
 %>

 <%
			if(rs!=null)rs.close();
			pstmt.close();
		}catch(Exception e)
		{ //out.println(e);
		e.printStackTrace();
		}
		finally{
		 	 if(rs!=null) rs.close();
			 if(pstmt!=null) pstmt.close();
		     if(con!=null)
		 ConnectionManager.returnConnection(con,request);
	}

		
%>
</table>
</form>
</body>
</html>

