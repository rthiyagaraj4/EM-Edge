<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<html> 
<title><fmt:message key="Common.cancelledby.label" bundle="${common_labels}"/></title>
<head>
	
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function send_back_result(appl_id,appl_name)
	{
		if(appl_id!=null)
		{
		var result=appl_id+'|'+appl_name;
		parent.window.returnValue=result;
		parent.window.close();
		}
	}
	</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
request.setCharacterEncoding("UTF-8"); 
ResultSet rs=null;
Statement stmt=null;
ResultSet rs_count=null;
Statement stmt_count=null;
Connection con = null;
String appl_userid="";
String appl_username="";
String classValue="";
int records_to_show=16;
int total_count =0;
int i=0;
int start=1;
int end=0;
String from = request.getParameter("from");
String to = request.getParameter("to");

try{
			con = ConnectionManager.getConnection(request);
			String sql =" SELECT Appl_user_id, Appl_user_name FROM SM_APPL_USER WHERE eff_status = 'E' order by 2";

			String sql_count="Select count(*) FROM SM_APPL_USER WHERE eff_status = 'E' ";

			stmt_count	=	con.createStatement();
			rs_count	=	stmt_count.executeQuery(sql_count);
			
			
        if(rs_count!=null)
        {
            while(rs_count.next())
            {
                total_count=rs_count.getInt(1);
            }
        }

		if ( from == null )
         {
              start = 1 ;
         }
         else
             start = Integer.parseInt( from ) ;
                
		if ( to == null )
			end = records_to_show ;
		else
			end = Integer.parseInt( to ) ;

// Prev/Next    From Here       

                out.println("<p><table align='right'><tr><td>");
                if ( !(start <= 0) )
                {
                    out.println("<A HREF='../jsp/CancelledbySearch.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
                }
                if (!((start+records_to_show) >= total_count ) )
                    {
                        out.println("<A HREF='../jsp/CancelledbySearch.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");   
                    }
                        out.println("</td></tr></table></p>");
                    out.println("<br><br><table border='1' cellpadding='0' cellspacing='0' width='100%' align='center' valign='top' >");
					out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.appluserid.label","common_labels")+"</th><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.applusername.label","common_labels")+"</th>");
    
					stmt = con.createStatement();
					rs=stmt.executeQuery(sql);

								if ( start != 1 )
								for( int j=1; j<start; i++,j++ )
								rs.next() ;
                                while(rs.next() && i < end)
                                {
                                  
									if ( i % 2 == 0 )
		  							classValue = "QRYEVEN" ;
									else
								  	classValue = "QRYODD" ;
									appl_username=rs.getString("Appl_user_name");
									appl_userid = rs.getString("Appl_user_id");
									
									
									out.println("<tr><td class='"+classValue+"'>");		
									out.println("<a href=\"javascript:send_back_result('"+appl_userid+"','"+appl_username+"');\"> ");
									out.println(appl_userid+"</a></td><td class='" + classValue + "'>");
																		
									out.println(appl_username+"</td></tr>");
									
									i++;
																		
									
                                }
                            }catch(Exception e){
                                out.println(e.toString());
                            }
                            finally
                            {
                                if(stmt!=null) stmt.close();
                                if(rs!=null) rs.close();
								if(stmt_count!=null) stmt_count.close();
								if(rs_count!=null) rs_count.close();
                                ConnectionManager.returnConnection(con,request);
                            }
%>
   
</table>	
</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

