<!DOCTYPE html>
<%@ page import ="java.util.HashMap,java.util.ArrayList,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,java.util.regex.Pattern,java.lang.*"%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>

<HTML>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle="IeStyle.css";
String filter_group = request.getParameter("Filter_group_code");
//System.out.println("filter_group35"+filter_group);
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="JavaScript" src='../../eCommon/js/common.js'> </Script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript" src='../../eXH/js/Validate.js'> </script>
<script src='../../eXH/js/FilterLayerReference.js' language='javascript'></script>
<script src='../../eXH/js/FilterLayerReferenceApplication.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script Language="JavaScript" >
function hide()
{
	parent.frames[3].location.href='../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?Filter_group_code='+document.forms[0].Filter_group_desc_id.value;
}


</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


  
</HEAD>
<BODY  leftmargin=0 topmargin=0  onMouseDown="CodeArrest()"  onKeyDown ='lockKey()' onload='hide()'>
<form name="FilterSearchForm" id="FilterSearchForm" target='messageFrame' >
<%
int levelcount=0;
ResultSet resultset = null;
PreparedStatement pstmt = null ;
Statement stment=null;
Connection conn = null;
ResultSet rset = null;
int j=1;
String replacestr=" ";
String reSecond = new String("'"+replacestr+"'");
int ach;
int ch;
try
{
if(conn==null) conn = ConnectionManager.getConnection();
}
 catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of FilterLayerqueryNull.jsp :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }
try
 {
 stment= conn.createStatement();
 resultset = stment.executeQuery("select count(*) AS rowcount from XH_FILTER_LEVEL_CONFIG where filter_group_code='"+filter_group+"'");
 resultset.next();
 levelcount = resultset.getInt("rowcount") ;

 j=1 ;
int typeflag=0;
int subtypeflag=0;
resultset.close() ;
stment.close();
 String sql="select B.LEVEL_NUMBER,B.TYPE_QUERY,B.SUBTYPE_QUERY,B.LOOKUP_QUERY,B.FILTER_ELEMENT_TYPE_DESC,B.FILTER_SUBTYPE_DESC,B.ELEMENT_CODE_NAME,A.FACILITY_ID  from XH_FILTER_GROUP A,XH_FILTER_LEVEL_CONFIG B where B.FILTER_GROUP_CODE=A.FILTER_GROUP_CODE and B.FILTER_GROUP_CODE='"+filter_group+"' ORDER BY B.LEVEL_NUMBER";

 pstmt = conn.prepareStatement(sql);
 rset = pstmt.executeQuery();
 while(rset.next())
 {
int level_number=Integer.parseInt(rset.getString(1).toString().trim());

String sql1=rset.getString(2);	
PreparedStatement pstmt1 = null ;
ResultSet resultset1 = null;
try{

String facility1= new String("'"+rset.getString(8).toString().trim()+"'");
sql1=rset.getString(3).toString().trim();
if(sql1.indexOf(":FACILITY")!=-1)
	{

        sql1=sql1.replaceAll(":FACILITY",facility1);
	}
	else
	{
        sql1=sql1;
	}

for(ch=1;ch<=(level_number*2);ch++)
{
	String str=":"+ch;
   sql1=sql1.replaceAll(str,reSecond);
}

//System.out.println("1st Column combo :"+sql1);

pstmt1 = conn.prepareStatement(sql1);
 resultset1 = pstmt1.executeQuery();
 while(resultset1.next())
	 {

	 }
if(pstmt1!=null )
 pstmt1.close() ;
 resultset1.close() ;
}
catch(Exception e)
	 {
	typeflag=1;
	 }
 %>

<%
	try{

	
String sql2="";
PreparedStatement pstmt2 = null ;
ResultSet resultset2 = null;
//Regex = Pattern.compile("\\|",Pattern.MULTILINE);

String facility= new String("'"+rset.getString(8).toString().trim()+"'");

//System.out.println("reSecond :"+reSecond);
sql2=rset.getString(3).toString().trim();
/*if(rset.getString(3).indexOf(":1")!=-1)
	{ 
	
sql2=rset.getString(3).replaceAll(":1",reSecond);

//replacestr
//rset.getString(3);
	} 
	else
	{
		sql2=rset.getString(3);
	}*/
	for (ach=1;ach<=(level_number*2);ach++)
{
	String str=":"+ach;
sql2=sql2.replaceAll(str,reSecond);
}

if(rset.getString(3).indexOf(":FACILITY")!=-1)
	{

        sql2=sql2.replaceAll(":FACILITY",facility);
	}
	else
	{
        sql2=sql2;
	}
//System.out.println("2st Column combo :"+sql2);
pstmt2 = conn.prepareStatement(sql2);
 resultset2 = pstmt2.executeQuery();
 while(resultset2.next())
	 {
 

}
if(pstmt2!=null )
 pstmt2.close() ;
 resultset2.close() ;
%>

<%
/*String sql3="";
PreparedStatement pstmt3= null ;
ResultSet resultset3 = null;
sql3=rset.getString(4);	

System.out.println("sql3"+sql3);
pstmt3 = conn.prepareStatement(sql3);
 resultset3 = pstmt3.executeQuery();
 while(resultset3.next())
	 {
 

}
if(pstmt3!=null )
 pstmt3.close() ;
 resultset3.close() ;*/
 //out.println("<script>parent.frames[3].location.href='../../eXH/jsp/FilteringandschedulingApplicationLevel.jsp?Filter_group_code="+filter_group+"';</script>");
//out.println("<script>parent.frames[4].location.href='../../eXH/jsp/FilteringandschedulingApplicationSearch1.jsp?Filter_group_code="+filter_group+"';</script>");
out.println("<script>parent.frames[4].location.href='../../eXH/jsp/FilteringAndSchedulingApplicationSearchAdd.jsp?Filter_group_code="+filter_group+"';</script>");


}catch(Exception exp)
      {
      subtypeflag=1;
//out.println("<script>parent.frames[3].location.href='../../eXH/jsp/FilteringandschedulingApplicationLevel.jsp?Filter_group_code="+filter_group+"';</script>");
out.println("<script>parent.frames[4].location.href='../../eCommon/html/blank.html'</script>");
		// exp.printStackTrace(System.err);
		
      }
finally
	 {


 }

	 
	 }


if(pstmt!=null)
pstmt.close();
if(rset!=null)
rset.close() ;

  if(subtypeflag==1 || typeflag==1)
		 {

out.println("<script>alert('Query must be properly set it ...');</script>");
		 }

	}
catch(Exception exp)
      {
		
//out.println("<script>alert(getMessage('XH1046','XH'));</script>");
		 System.out.println("Error in calling getconnection method of FilterLayerqueryNull.jsp  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }

finally
	{


		ConnectionManager.returnConnection(conn);
	}
	%>

<input type=hidden name=count_fields id=count_fields value='<%=j%>'>
<input type=hidden name=actualmode id=actualmode value='I'>
<input type=hidden name=Filter_group_desc_id id=Filter_group_desc_id value='<%=filter_group%>'>
<input type=hidden name=element_field id=element_field value=''>

</form>	
</BODY>
</HTML>

