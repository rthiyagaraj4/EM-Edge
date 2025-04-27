<!DOCTYPE html>
<!-- Last Modified Date Time : 9/26/2005 1:33 PM -->

<%@ page contentType="text/html;charset=UTF-8" import="java.io.*, java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.* ,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	
	<Script Language="JavaScript" src="../js/StdFamilyName.js"></Script>
<%	
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

    String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;

	String language_direction="";
	int count=0;

    if ( !(whereClause == null || whereClause.equals("")) )
    {
		sbQuery.append(whereClause);
        
		/*InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( sbQuery.toString().getBytes()), "UTF-8" ) ;
		sbQuery.setLength(0);
		sbQuery.append((new BufferedReader(reader)).readLine() );
        reader.close();*/

    } //end of where clause IF
    else
    {
        String lastname = request.getParameter("last_name");
        String lastnameloclang = request.getParameter("last_name_loc_lang");
        if (lastnameloclang==null) lastnameloclang = "";
        String enabled = request.getParameter("eff_status");
        
        InputStreamReader reader;

        reader = new InputStreamReader( new ByteArrayInputStream( lastnameloclang.getBytes()), "UTF-8" ) ;
        lastnameloclang = (new BufferedReader(reader)).readLine() ;     


        int andCheck = 0;
        if(lastname != null)
        lastname=lastname.toUpperCase();
        
            if ( !(lastname == null || lastname.equals("")) )
            {
				sbQuery.setLength(0);
				sbQuery.append("where upper(last_name) like '");
				sbQuery.append(lastname);
				sbQuery.append("%'");
                andCheck = 1;
            }
        
            if ( !(lastnameloclang == null || lastnameloclang.equals("")) )
            {
                if ( andCheck == 1 )
                {   
					sbQuery.append(" and ");
					sbQuery.append("last_name_loc_lang like  '");
					sbQuery.append(lastnameloclang);
					sbQuery.append("%'" );
             }
                else
                {
					sbQuery.setLength(0);
					sbQuery.append("where last_name_loc_lang like '");
					sbQuery.append(lastnameloclang);
					sbQuery.append("%'" );

                    andCheck = 1;
                }
            }
        
        
            if ( !(enabled == null || enabled.equals("")) )
            {
             
			String strEffStatus="";
			if(enabled.equals("E"))
				strEffStatus="E";
			else if(enabled.equals("D"))
				strEffStatus="D";
			
			if(andCheck == 0 ){
				sbQuery.setLength(0);
				sbQuery.append("where eff_status='"+strEffStatus+"'");
			}else if(!enabled.equals("B")){
				sbQuery.append(" and eff_status='"+strEffStatus+"'");
			}
			
			 if ( enabled.equals("B") ){
				//Added on 2/18/2005
				if(andCheck == 0){
					sbQuery.setLength(0);
					sbQuery.append(" where (eff_status='E' or eff_status='D') ");
				}else
					sbQuery.append(" and (eff_status='E' or eff_status='D') ");
				
			}
       }
    }

    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord.equals("")) ){
		sbQuery.append(" order by ");

		for ( int i=0;i < ord.length;i++ ){
			if ( i == ord.length - 1 ){
				sbQuery.append(ord[i]);

			}else{
				sbQuery.append(ord[i]);
				sbQuery.append(",");
			}
		}
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

Connection conn = null;
PreparedStatement pstmt=null;
PreparedStatement pstmt1=null;
ResultSet rs=null;
ResultSet rs1=null;
ResultSet rs2=null;
//int maxRecord = 0;
try{
    conn = ConnectionManager.getConnection(request);
/*pstmt = conn.prepareStatement("select count(*) as total from mp_std_family_name "+ sbQuery.toString());

rs = pstmt.executeQuery();
rs.next();
maxRecord = rs.getInt("total");

if(rs!=null)    {rs.close();rs=null;} ;

if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/

			if(pstmt1 != null) pstmt1.close();
			if(rs2 != null) rs2.close();
			
			pstmt1 = conn.prepareStatement("select count(*) as total from sm_language where language_direction='R' and eff_status='E'" );
			
			rs2 = pstmt1.executeQuery() ;
				 
			 if ( rs2 != null && rs2.next() ) 
			 {
			 count = rs2.getInt("total");
			 }

			if ( count==1 ) 
			{
				 language_direction = "R" ;
			}else
			{
				 language_direction = "L" ;
			}



pstmt = conn.prepareStatement("select * from mp_std_family_name "+sbQuery.toString());
rs = pstmt.executeQuery();
boolean oth_lang = false ;

pstmt1 = conn.prepareStatement( " select 'x' from mp_param where names_in_oth_lang_yn='Y' and module_id = 'MP' " );
rs1 = pstmt1.executeQuery () ;
if( rs1. next())
    oth_lang = true ;
if( rs1 != null ) rs1.close() ;
if( pstmt1!= null ) pstmt1.close() ;
%>



<%
    if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rs.next() ;

      String classValue = "" ;
	  int cnt=0;


while( i<=end && rs.next())
{
	if(cnt==0)
	{%>
		<P>
		<table align='right'>
		<tr >

		<%

		if ( !(start <= 1) )
			{
				out.println("<td align ='right' id='prev'><A HREF='javascript:nextSet("+(start-14)+","+(end-14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
			}
		%>
			<td align ='right' id='next' style='visibility:hidden'>
		<%
		//if ( !( (start+14) > maxRecord ) )
		   // {
				
				out.println("<A HREF='javascript:nextSet("+(start+14)+","+(end+14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

		  //  }
		%>
		</td>
		</tr>
		</table><BR><BR>
		</P>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th><fmt:message key="Common.FamilyName.label" bundle="${common_labels}"/></th>
		<%
			if( oth_lang )
				out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FamilyNameinOtherLanguage.label","mp_labels")+"</th>") ; 
		%>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%	}
    if ( i % 2 == 0 )
            classValue = "QRYEVEN" ;
        else
            classValue = "QRYODD" ;

    out.println("<tr><td class='" + classValue + "'>");
    String val = rs.getString("last_name");
    if (val==null) val="";
        
    out.println("<a href='../../eMP/jsp/AddModifyStdFamilyName.jsp?last_name="+java.net.URLEncoder.encode(val)+"&language_direction="+language_direction+"' target='f_query_add_mod' >");
    out.println(val+"</a></td>");
    if(oth_lang )
    {
    
        if(classValue .equals("QRYEVEN"))
            classValue =  "QRYEVENOTHLANG";
        else
        classValue = "QRYODDOTHLANG"; 
                        
        String val1=rs.getString("last_name_loc_lang");
        if(val1==null)val1="";
        out.println( "<td class='" + classValue + "'");
		if(language_direction.equals("R"))
						{
						out.println("dir='RTL'" ) ;
						}
		out.println( ">"+val1);
        out.println("</td>");
        
        if(classValue.equals("QRYEVENOTHLANG") )
            classValue= "QRYEVEN" ;
        else if(classValue.equals("QRYODDOTHLANG"))
        classValue="QRYODD";
    }

    out.println( "<td class='" + classValue +
		"' align='center'>" ) ;

    if ( rs.getString("eff_status").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

    i++;
	cnt++;

}

	if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	boolean flag = false;
	if ( cnt < 14 || (!rs.next()) ) {
	%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='hidden';
		</script>
	<% flag = true;
			} else {%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='visible';
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%}
%>

</td></tr>
</table>
<br><center>

<%
}catch ( Exception e ){ 
	//out.println(e.toString());
e.printStackTrace();
}
finally{
	if ( rs!= null ) rs.close() ;
    if ( pstmt != null ) pstmt.close() ;    
    if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>

<form name='dummyform' id='dummyform' action='StdFamilyNameQueryResult.jsp' method='post'>
    <input type='hidden' name='from' id='from' >
    <input type='hidden' name='to' id='to' >
    <input type='hidden' name='whereclause' id='whereclause' value="<%=sbQuery.toString()%>">
</form>
</center>
</BODY>
</HTML>

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

