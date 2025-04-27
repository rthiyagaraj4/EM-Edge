<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script src="../../eCommon/js/common.js" language="javascript"></script>
 <script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<%
	request.setCharacterEncoding("UTF-8");

	
	%>
	
<%
	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	PreparedStatement pstmt1=null;
	ResultSet rs1 = null;
	String acc_yr="";
	String acc_dt="";
	String acc_dt1="";
	String count="";
	String date="";
	String month="";
	String year="";
	String acc_mon1="";
	String acc_yr1="";

		acc_yr = request.getParameter("acc_per_year1");
		if(acc_yr==null) acc_yr="";

		acc_dt = request.getParameter("acc_per_start_dt");
		if(acc_dt==null) acc_dt="";
		count=request.getParameter("count");
		if(count==null) count="";


		acc_yr=acc_yr.trim();
		acc_dt=acc_dt.trim();


		acc_yr1=DateUtils.convertDate(acc_yr,"YY",localeName,"en");
		acc_dt1=DateUtils.convertDate(acc_dt,"DMY","en",localeName);

		StringTokenizer str=new StringTokenizer(acc_dt1,"/");
		   if (str.hasMoreTokens()) {
			date=str.nextToken();

			month=str.nextToken();
			month = DateUtils.convertDate(month,"MM",localeName,"en");
			
			year=str.nextToken();
			year = DateUtils.convertDate(year,"YY",localeName,"en");
			acc_mon1=date+'/'+month+'/'+year;
			}

	try
	{
	con = ConnectionManager.getConnection(request);

	try
		{

		if(count.equals("year"))
		{
			
			String st ="select * from sy_acc_period_defn where acc_per_year='"+acc_yr1+"'";	
			pstmt = con.prepareStatement(st);

			rs=pstmt.executeQuery();					
			if(!rs.next())
			{	
		%>
		<script>
	//	parent.document.frames[1].document.forms[0].acc_per_year1.value='<%=acc_yr.trim()%>'
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';

		</script>
		<%
		}
		else
		{
	  %>
		<script Language='Javascript'>
		parent.document.f_query_add_mod.document.forms[0].acc_per_year1.value='';
		parent.document.f_query_add_mod.document.forms[0].acc_per_year1.focus();
	   	alert(getMessage("ACC_PER_YEAR_ALREADY_EXISTS",'SM'));
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
		</script>

	<%
	}
	}
	
	//out.println("count"+count);
	if(count.equals("date"))
	{
		String st1 ="select * from sy_acc_period_defn where trunc(acc_per_start_date) = trunc(to_date('"+acc_dt+"','dd/mm/yyyy'))";	
			
			pstmt1 = con.prepareStatement(st1);
			rs1 = pstmt1.executeQuery();
			if(!rs1.next())
			{
		%>
		<script>
		 var year_scc='<%=year%>';
		
		 var acc_year='<%=acc_yr%>';
		
		 var year_scc1=eval(year_scc)-1;
		
    	 var year_scc2=eval(year_scc)+1;
		 var acc_start_date= parent.document.frames[1].document.forms[0].acc_per_start_date.value;
	//	 alert("acc_start_date in populate"+acc_year in populate)

		/*if(acc_year==year_scc || acc_year==year_scc1 ||  acc_year==year_scc2 )
		{
		
			parent.document.frames[1].document.forms[0].acc_per_start_date.value='<%=acc_mon1.trim()%>'
		}
		else
		{
			
		alert(getMessage("ACC_PER_START_DATE_VAL",'SM'));
		parent.document.frames[1].document.forms[0].acc_per_start_date.value="";
	   }*/
	   parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';

		</script>

		<%
			}
		else
			{
	%>
		<script>
		
		parent.document.frames[1].document.forms[0].acc_per_start_date.value="";
		parent.document.frames[1].document.forms[0].acc_per_start_date.focus();
		alert(getMessage("ACC_PER_DATE_ALREADY_EXISTS",'SM'));
		 parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';

		
		</script>

	<%
			}

	}
}
		catch (Exception e)
		{
		}
		finally{
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
		}

	}catch(Exception e){out.println(e);}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>


<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

