<!DOCTYPE html>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<body class='message' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %> 
<%
request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
java.sql.Date current_date = null ;
String  alt_id_exp_date = request.getParameter("expiry_date") ;

String alt_id_exp_warn_yn = "" ;
String alt_id_adv_alert_reqd_yn = "";
int alt_id_adv_alert_days = 0 ;
int  alt_id_exp_grace_days = 0 ;
java.util.Date p_alt_id_total_exp_date = null ;
int  IdNo  = Integer.parseInt(request.getParameter("expdateno")) ;
	
int p_alt_id_diff_days = 0;
java.sql.Date p_alt_id_exp_date1 = null;
String flag = "true";

Connection con = null;
Statement stmt = null;
ResultSet rset = null ;

StringBuffer expsql = new StringBuffer();
expsql.append("Select alt_id1_exp_warn_yn,alt_id1_exp_grace_days, alt_id1_adv_alert_reqd_yn, nvl(alt_id1_adv_alert_days,0) alt_id_adv_alert_days,to_date('"+alt_id_exp_date+"','dd/mm/rrrr')-trunc(sysdate) p_alt_id_exp_date ,");

try{
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement() ;

    if(IdNo == 2)
	{
		if(expsql.length() > 0) expsql.delete(0,expsql.length());
        expsql.append("Select alt_id2_exp_warn_yn,alt_id2_exp_grace_days, alt_id2_adv_alert_reqd_yn, nvl(alt_id2_adv_alert_days,0) alt_id_adv_alert_days,to_date('"+alt_id_exp_date+"','dd/mm/rrrr')-trunc(sysdate) p_alt_id_exp_date ," ) ;
	}
    if(IdNo == 3)
	{
		if(expsql.length() > 0) expsql.delete(0,expsql.length());
        expsql.append("Select alt_id3_exp_warn_yn,alt_id3_exp_grace_days, alt_id3_adv_alert_reqd_yn, nvl(alt_id3_adv_alert_days,0) alt_id_adv_alert_days,to_date('"+alt_id_exp_date+"','dd/mm/rrrr')-trunc(sysdate) p_alt_id_exp_date ," );
	}
    if(IdNo == 4 )
    { 
		if(expsql.length() > 0) expsql.delete(0,expsql.length());
		expsql.append("Select alt_id4_exp_warn_yn,alt_id4_exp_grace_days, alt_id4_adv_alert_reqd_yn, nvl(alt_id4_adv_alert_days,0) alt_id_adv_alert_days,to_date('"+alt_id_exp_date+"','dd/mm/rrrr')-trunc(sysdate) p_alt_id_exp_date ," );
	}

   expsql.append(" trunc(sysdate),to_date( '"+alt_id_exp_date+"','dd/mm/rrrr') from mp_param");
    
    rset = stmt.executeQuery( expsql.toString() );
    if (rset.next()){
    alt_id_exp_warn_yn=rset.getString(1);if(alt_id_exp_warn_yn==null)alt_id_exp_warn_yn="";
    alt_id_exp_grace_days=rset.getInt(2);
    alt_id_adv_alert_reqd_yn = rset.getString(3);if(alt_id_adv_alert_reqd_yn==null) alt_id_adv_alert_reqd_yn="";
    alt_id_adv_alert_days = rset.getInt(4);
    p_alt_id_diff_days = rset.getInt(5);
   
    current_date=rset.getDate(6);
     p_alt_id_exp_date1 = rset.getDate(7);
    }
 
 if(alt_id_exp_warn_yn.equals("Y"))
 {
    
   p_alt_id_total_exp_date=new java.util.Date(p_alt_id_exp_date1.getTime());
   p_alt_id_total_exp_date.setDate(p_alt_id_exp_date1.getDate()+alt_id_exp_grace_days);   
   
   if((p_alt_id_exp_date1.compareTo(current_date))< 0)
   {
    if((p_alt_id_total_exp_date.compareTo(current_date))< 0)
   {
          flag="false";
   }
   else{
   %>
      <script>
        msg = parent.f_query_add_mod.getMessage("ALT_ID_EXP_WITH_GRACE","MP")
        if('<%=IdNo%>'== 1)
        {
            msg = msg.replace('$',parent.f_query_add_mod.document.getElementById("alternate_id").value)
        }
        else if('<%=IdNo%>'== 2)
        {
            msg = msg.replace('$',parent.f_query_add_mod.document.getElementById("alt_id2_type").value)
        }
        else if('<%=IdNo%>'== 3)
        {
            msg = msg.replace('$',parent.f_query_add_mod.document.getElementById("alt_id3_type").value)
        }
        else if('<%=IdNo%>'== 4)
        {
            msg = msg.replace('$',parent.f_query_add_mod.document.getElementById("alt_id4_type").value)
        }
        alert(msg);
      </script>
 <%}
 }
 }
 
 if(alt_id_adv_alert_reqd_yn.equals("Y"))
 {
    if((p_alt_id_exp_date1.compareTo(current_date))> 0)
    {
        if (p_alt_id_diff_days > 0) 
        {
            if ( p_alt_id_diff_days <= alt_id_adv_alert_days)
            {
                %>
                <script>var alt_days = '<%=alt_id_adv_alert_days%>';
                    msg = parent.f_query_add_mod.getMessage("ALT_ID_EXP_WITHIN","MP")
                    if('<%=IdNo%>'== 1)
                    {
                        msg = msg.replace('$',parent.f_query_add_mod.document.getElementById("alternate_id").value)
                    }
                    else if('<%=IdNo%>'== 2)
                    {
                        msg = msg.replace('$',parent.f_query_add_mod.document.getElementById("alt_id2_type").value)
                    }
                    else if('<%=IdNo%>'== 3)
                    {
                        msg = msg.replace('$',parent.f_query_add_mod.document.getElementById("alt_id3_type").value)
                    }
                    else if('<%=IdNo%>'== 4)
                    {
                        msg = msg.replace('$',parent.f_query_add_mod.document.getElementById("alt_id4_type").value)
                    }
                    alert( (msg +" "+alt_days+' '+getLabel("Common.days.label","Common")) );
                    location.href = '../../eCommon/jsp/error.jsp'

                </script>
                <%
            }
        }
    }
 }

if(flag.equals("false"))
{
%>
    <script>
        msg = parent.f_query_add_mod.getMessage('ALT_ID_EXPIRED','MP')
        
        
        if('<%=IdNo%>'== 1)
        {
            parent.f_query_add_mod.document.getElementById("altid1expdate").focus();
            parent.f_query_add_mod.document.getElementById("altid1expdate").select();
            msg = msg.replace('$',parent.f_query_add_mod.document.getElementById("alternate_id").value)
        }
        else if('<%=IdNo%>'== 2)
        {
            parent.f_query_add_mod.document.getElementById("alt_id2_exp_date").focus();
            parent.f_query_add_mod.document.getElementById("alt_id2_exp_date").select();
            msg = msg.replace('$',parent.f_query_add_mod.document.getElementById("alt_id2_type").value)
        }
        else if('<%=IdNo%>'== 3)
        {
            parent.f_query_add_mod.document.getElementById("alt_id3_exp_date").focus();
            parent.f_query_add_mod.document.getElementById("alt_id3_exp_date").select();
            msg = msg.replace('$',parent.f_query_add_mod.document.getElementById("alt_id3_type").value)
        }
        else if('<%=IdNo%>'== 4)
        {
            parent.f_query_add_mod.document.getElementById("alt_id4_exp_date").focus();
            parent.f_query_add_mod.document.getElementById("alt_id4_exp_date").select();
            msg = msg.replace('$',parent.f_query_add_mod.document.getElementById("alt_id4_type").value)
        }
        alert(msg);
    </script>
 <%

}
}catch(Exception e) { 
//out.println(e.toString());
e.printStackTrace();
}
finally
{
    if (stmt != null) stmt.close();
    if (rset != null) rset.close();
    ConnectionManager.returnConnection(con,request);
}
%>
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

