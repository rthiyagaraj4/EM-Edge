<!DOCTYPE html>
<!-- Last Modified Date Time : 9/23/2005 11:32 AM -->

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,java.io.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML><head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../js/StdFamilyName.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head><BODY  class='CONTENT' onLoad='' onKeyDown = 'lockKey()'>
<% 
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
    String strsql2="";
    String sql=" ";
    //String strsql1=" ";

    String whereClause = request.getParameter("whereclause");
    String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;

    int andCheck=0;
    
    if ( whereClause == null || whereClause.equals("")) 
    {
        sql=" ";
        String last_name= request.getParameter("last_name");
        String last_name_loc_lang  = request.getParameter("last_name_loc_lang");
        String criteria=request.getParameter("criteria");
       
        if (!(last_name==null || last_name.equals("")) )
        {
            last_name=last_name.toUpperCase();
            
            if (criteria.equals("N")) {
                sql = " where upper(last_name)= upper('"+last_name+"')";
                andCheck = 1;
            } else if(criteria.equals("C")) {
                sql = " where upper(last_name) like upper('%"+last_name+"%')";
                andCheck = 1;
            } else if(criteria.equals("S")){
                sql = " where upper(last_name) like upper('"+last_name+"%')";
                andCheck = 1;
            } else if(criteria.equals("E")){
                sql = " where upper(last_name) like upper('%"+last_name+"')";
                andCheck = 1;
            }
        }
        
        if (!(last_name_loc_lang==null || last_name_loc_lang.equals("")) )
        {
            if (sql.equals(" "))
            {
                sql = " where ";
            }
            else
            {
                sql = sql + " and ";
            }

			 /* below two line was commented by venkatesh s on 03-Aug-2013 against MMS-SCF-0086 [IN:042990]*/
            //InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( last_name_loc_lang.getBytes()), "UTF-8" ) ;
            //last_name_loc_lang = (new BufferedReader(reader)).readLine() ;

            if (criteria.equals("N"))
            {
                sql = sql + " upper(last_name_loc_lang)=upper('"+last_name_loc_lang+"')";
                andCheck = 1;
            }
            else if(criteria.equals("C")) {
                sql = sql + " upper(last_name_loc_lang) like upper('%"+last_name_loc_lang+"%')";
                andCheck = 1;
            }
			else if(criteria.equals("S")){
				sql = sql + "upper(last_name_loc_lang) like upper('"+last_name_loc_lang+"%')";
                andCheck = 1;
			}
			else if(criteria.equals("E")){
				sql = sql + " upper(last_name_loc_lang) like upper('%"+last_name_loc_lang+"')";
                andCheck = 1;
			}
        }
    }
    else
    {
        sql = whereClause;
        InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( sql.getBytes()), "UTF-8" ) ;
        sql = (new BufferedReader(reader)).readLine() ;     
        reader.close();
    }
     
	
    int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14;
    else
        end = Integer.parseInt( to ) ;

    Connection conn = null; 
    java.sql.Statement stmt=null;
    ResultSet rs=null;
    //int maxRecord = 0;
    
    try
    {
		conn = ConnectionManager.getConnection(request);
        stmt = conn.createStatement();

		/*
        strsql1="select count(*) as total from mp_std_family_name "+sql;
        rs = stmt.executeQuery(strsql1);
        rs.next();
        maxRecord = rs.getInt("total");
		*/
        
        strsql2  ="select last_name,last_name_loc_lang from mp_std_family_name "+sql + " order by last_name";
        rs = stmt.executeQuery(strsql2); 
                 
        if ( start != 1 )
                for( int j=1; j<start; i++,j++ ) {
                    rs.next() ;
                }
			int cnt = 0;
            while (i<=end && rs.next())
            {
				if(cnt == 0)
				{
					%>
					<p>
				<table align='right'>
				<tr>
					<td>
                <%                   
                        if ( !(start <= 1) )
                        {
                            out.println("<A HREF='javascript:nextSet("+(start-14)+","+(end-14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
                        }

                       out.println("<A id='nextval' HREF='javascript:nextSet("+(start+14)+","+(end+14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
                        
                %>
							</td>
						</tr>
						</table>
						<BR><BR>
						</p>

						<table align='center' border="1" width="98%"cellspacing='0' cellpadding='0' id='ResultTab'>
						<th class='columnheader'  width='50%'><fmt:message key="Common.FamilyName.label" bundle="${common_labels}"/></th>
						<th class='columnheader' width='50%'><fmt:message key="eMP.FamilyNameinOtherLanguage.label" bundle="${mp_labels}"/></th>

					<%
				}

				String classValue = "" ;
                if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
                    classValue = "QRYODD" ;
                
        
                String last_name    = rs.getString("last_name");
                String last_name_loc_lang   = rs.getString("last_name_loc_lang");
                String last_name1   = last_name;
                String last_name_loc_lang1  = last_name_loc_lang;
                
                if(last_name==null || last_name.equals("null"))
                {
                    last_name="&nbsp;";
                    last_name1="";
                }
                if(last_name_loc_lang==null || last_name_loc_lang.equals("null"))
                {
                    last_name_loc_lang="&nbsp;";
                    last_name_loc_lang1="";
                }

				out.println("<tr><td   class='" + classValue + "' align='left' onclick=\"closeWin('"+last_name1+"','"+last_name_loc_lang1+"')\">");
    
                out.println("<a href=\"\">");
                out.println(last_name+"</td>");
                
                if(classValue.equals("QRYEVEN"))    classValue = "QRYEVENOTHLANG";
                else if(classValue.equals("QRYODD"))    classValue = "QRYODDOTHLANG";
                
                out.println("<td  class='" + classValue + "' onclick=\"closeWin('"+last_name1+"','"+last_name_loc_lang1+"')\">");
                out.println("<a href=\"\">");
                out.println(last_name_loc_lang+"</td></tr>");   
                i++;
				cnt++;

                if(classValue.equals("QRYEVENOTHLANG"))    classValue = "QRYEVEN";
                else if(classValue.equals("QRYODDOTHLANG"))    classValue = "QRYODD";
            }//endwhile

			if(cnt==0)				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");

			if(i == 2)
			{
				%>
					<script>				
						document.getElementById("ResultTab").rows[1].cells[0].click() ;
					</script>
				<%
			}

			if (!rs.next() && cnt!=0 )
			{
			%>
			<script>
				document.getElementById("nextval").innerHTML=" ";	
			</script>

			<% } 

    }
    catch(Exception e)
    {
        //out.println(e.toString());
		e.printStackTrace();
    }
    finally
    {
        if(stmt!=null)
            stmt.close();
        if(rs!=null)
            rs.close();
        if(conn!=null) ConnectionManager.returnConnection(conn,request);
    }
        %>

    </td></tr>
    </table>
    <form name='dummyform' id='dummyform' action='SearchStdFamilyNameResult.jsp' method='post'>
        <input type='hidden' name='from' id='from' >
        <input type='hidden' name='to' id='to' >
        <input type='hidden' name='whereclause' id='whereclause' value="<%=sql%>">
</form>

<script>
		if( parent.SearchCriteria.document.Search_STD_Family_Name_form.search != null )
			if( parent.SearchCriteria.document.Search_STD_Family_Name_form.search.disabled )
				parent.SearchCriteria.document.Search_STD_Family_Name_form.search.disabled = false;
</script>

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

