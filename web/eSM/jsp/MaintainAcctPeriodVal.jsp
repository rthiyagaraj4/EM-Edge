<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script src="../../eCommon/js/common.js" language="javascript"></script>
 <script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	%>

<%
	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String acc_dt="";
	String date="";
	String month="";
	String year="";
	String acc_yr="";
    String acc_mon="";
    String acc_mon1="";
    String acc_dt1="";
    String acc_yr1="";
    String acc_mon2="";
	int n=0;	

	 acc_yr = request.getParameter("acc_per_year");
	 if(acc_yr==null) acc_yr="";
	 acc_yr=acc_yr.trim();

	 acc_dt = request.getParameter("acc_per_start_date");
	 if(acc_dt==null) acc_dt="";
	 acc_dt=acc_dt.trim();
	  acc_yr1 = DateUtils.convertDate(acc_yr,"YY",localeName,"en");
	  acc_dt1 = DateUtils.convertDate(acc_dt,"DMY","en",localeName);
	
	StringTokenizer str=new StringTokenizer(acc_dt1,"/");
   if (str.hasMoreTokens()) {
	date=str.nextToken();

	month=str.nextToken();
	month = DateUtils.convertDate(month,"MM",localeName,"en");
	
	year=str.nextToken();
	year = DateUtils.convertDate(year,"YY",localeName,"en");
    acc_mon1=date+'/'+month+'/'+year;
  }

	String count=request.getParameter("count");
	 acc_mon = request.getParameter("acc_per_mon");
	  if(acc_mon==null) acc_mon="";
	  acc_mon=acc_mon.trim();

	 acc_mon2 = DateUtils.convertDate(acc_mon,"MM",localeName,"en");


	
try
	{
	con = ConnectionManager.getConnection(request);


		if(count.equals("year"))
		{
			
			String st ="select count(*) from sy_acc_period_defn where acc_per_year='"+acc_yr1+"' and acc_per_month='"+acc_mon+"'";
			
		
			pstmt = con.prepareStatement(st);
			
			rs=pstmt.executeQuery();
		
			if(rs.next())
			{
				
			n=rs.getInt(1);
			}
			if(n==0){
			
	%>
		<script>
		
		//parent.document.frames[1].document.forms[0].acc_per_year.value='<%=acc_yr.trim()%>'
	
		//parent.document.frames[1].document.forms[0].acc_per_mon.value='<%=acc_mon%>'
			
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
		</script>

		<%
		}
		else
			{
			%>
	   <script Language='Javascript'>
	   parent.f_query_add_mod.document.forms[0].acc_per_year.value="";
	    parent.f_query_add_mod.document.forms[0].acc_per_mon.value="";
		 parent.f_query_add_mod.document.forms[0].acc_per_start_date.value="";
		 parent.f_query_add_mod.document.forms[0].acc_per_end_date.value="";
		 parent.f_query_add_mod.document.forms[0].acc_per_desc.value="";
		 parent.f_query_add_mod.document.forms[0].acc_cal_year.value="";
		 parent.f_query_add_mod.document.forms[0].acc_cal_month.value="";

		parent.f_query_add_mods.document.forms[0].acc_per_year.focus();
	alert("acc1");
	   alert(getMessage("ACC_PER_YEAR_ALREADY_EXISTS",'SM'));
	   
	   parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
		</script>
<%
			}
		}
		

else if(count.equals("date"))
	{
	boolean submit_check=true;
//String st ="select * from sy_acc_period_defn where trunc(acc_per_start_date) = trunc(to_date('"+acc_dt+"','dd/mm/yyyy'))";
//String st ="select * from sy_acc_period_defn where ACC_PER_MONTH='"+month+"' and ACC_PER_YEAR='"+year+"'";
//String st ="select count(*) from SY_ACC_PERIOD_DEFN where ACC_PER_START_DATE=TO_DATE('"+acc_mon1+"','DD/MM/YYYY');";
String st="select * from sy_acc_period_defn where  TO_CHAR(ACC_PER_START_DATE,'MM') ='"+month+"' AND TO_CHAR(ACC_PER_START_DATE,'YYYY') ='"+year+"'";
pstmt = con.prepareStatement(st);
			rs=pstmt.executeQuery();					
			if(!rs.next())
			{
			
			
	%>
		<script>
		 var year_scc='<%=year%>';
		 var acc_year='<%=acc_yr%>';
		 var year_scc1=eval(year_scc)-1;
    	 var year_scc2=eval(year_scc)+1;
		 var acc_start_date= parent.document.f_query_add_mod.document.forms[0].acc_per_start_date.value;

		if(acc_year==year_scc || acc_year==year_scc1 ||  acc_year==year_scc2 )
		{
			alert("acc2");
		parent.document.f_query_add_mod.document.forms[0].acc_per_start_date.value='<%=acc_dt%>'
		}
		else
		{
			alert("acc3");
		   submit_check=false;
		   parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		   alert(getMessage("ACC_PER_START_DATE_VAL",'SM'));
		   parent.document.f_query_add_mod.document.getElementById('acc_per_start_date').value="";
		   parent.document.f_query_add_mod.document.getElementById('acc_per_end_date').value="";
		   parent.document.f_query_add_mod.document.getElementById('acc_per_desc').value="";
		   parent.document.f_query_add_mod.document.getElementById('acc_cal_year').value="";
		   parent.document.f_query_add_mod.document.getElementById('acc_cal_month').value="";
	   }
		</script>

<%
		}
		else
			{
             submit_check=false;
		
				
			%>
	   <script Language='Javascript'>
    	
	   parent.document.f_query_add_mod.document.forms[0].acc_per_start_date.value="";
	   parent.document.f_query_add_mod.document.forms[0].acc_per_end_date.value="";
	   parent.document.f_query_add_mod.document.forms[0].acc_per_desc.value="";
	   parent.document.f_query_add_mod.document.forms[0].acc_cal_year.value="";
	   parent.document.f_query_add_mod.document.forms[0].acc_cal_month.value="";
       parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
alert("acc4");
	   alert(getMessage("ACC_PER_DATE_ALREADY_EXISTS",'SM'));
				
		</script>
<%
			}
			
		if(submit_check)
		{
			%>
			<script Language='Javascript'>
				parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
				alert("acc5");
				parent.document.f_query_add_mod.document.forms[0].submit();
		    </script>
		<%}

		}
	
}
catch (Exception e)
		{
			e.printStackTrace();
		}
		finally{
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con,request);
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

