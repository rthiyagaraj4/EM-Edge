<!DOCTYPE html>
<!-- Last Modified Date Time :9/23/2005 11:32 AM -->

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*,java.net.*, java.text.*, java.io.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script>
    function closeWin(other_name,other_name_local_lang)
    {		
		parent.window.returnValue= other_name +"`"+other_name_local_lang
        parent.window.close();
    }
	function nextSet(start,end)
    {
         document.dummyform.from.value = start
         document.dummyform.to.value = end
         document.dummyform.submit();
    }	
</script>
<%
    out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY  class='CONTENT' onLoad='' onKeyDown = 'lockKey()'>");

    String strsql2="";
    String sql=" ";
    //String strsql1=" ";

    String whereClause = request.getParameter("whereclause");
    String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;

    int andCheck=0;
    
    if ( (whereClause == null || whereClause.equals("")) )
    {
        sql=" ";
        String other_name= request.getParameter("other_name");
        String other_name_loc_lang  = request.getParameter("other_name_loc_lang");
        String criteria=request.getParameter("criteria");
       
        if (!(other_name==null || other_name.equals("")) )
        {
            other_name=other_name.toUpperCase();
            if (criteria.equals("N")) {
                sql = " where upper(other_name)=upper('"+other_name+"')";
                andCheck = 1;
            } else if(criteria.equals("C")){
                sql = " where upper(other_name) like upper('%"+other_name+"%')";
                andCheck = 1;
            } else if(criteria.equals("S")){
                sql = " where upper(other_name) like upper('"+other_name+"%')";
                andCheck = 1;
            } else if(criteria.equals("E")){
                sql = " where upper(other_name) like upper('%"+other_name+"')";
                andCheck = 1;
            }
        }
        
        if (!(other_name_loc_lang==null || other_name_loc_lang.equals("")) )
        {
            if (sql.equals(" "))
            {
                sql = " where ";
            }
            else
            {
                sql = sql +" and ";
            }
            
			 /* below two line was commented by venkatesh s on 03-Aug-2013 against MMS-SCF-0086 [IN:042990]*/
           //InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( other_name_loc_lang.getBytes()), "UTF-8" ) ;
            //other_name_loc_lang = (new BufferedReader(reader)).readLine() ;
                        
            if (criteria.equals("N"))
            {
                sql = sql + " upper (other_name_loc_lang)=upper('"+other_name_loc_lang+"')";
                andCheck = 1;
            }
            else if(criteria.equals("C")){
                sql = sql + "upper(other_name_loc_lang) like upper('%"+other_name_loc_lang+"%')";
                andCheck = 1;
            }
			else if(criteria.equals("S")){
				sql = sql + " upper(other_name_loc_lang) like upper('"+other_name_loc_lang+"%')";
                andCheck = 1;
            }
			else if(criteria.equals("E")){
				sql = sql + " upper(other_name_loc_lang) like upper('%"+other_name_loc_lang+"')";
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
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;


    Connection conn = null;
    java.sql.Statement stmt=null;
    ResultSet rs=null;
    //int maxRecord = 0;
    try{
        conn = ConnectionManager.getConnection(request);
    try
    {
		/*
        stmt = conn.createStatement();
        strsql1="select count(*) as total from mp_std_other_name "+sql;
        rs = stmt.executeQuery(strsql1);
        rs.next();
        maxRecord = rs.getInt("total");
		*/

        stmt = conn.createStatement();
        strsql2  ="select other_name,other_name_loc_lang from mp_std_other_name "+sql + " order by other_name";
        rs = stmt.executeQuery(strsql2);
            
            
        if ( start != 1 )
         for( int j=1; j<start; i++,j++ )
         {
             rs.next() ;
         }

            int cnt = 0;

            while (i<=end  && rs.next())
            {				
				if(cnt == 0)
				{
					%>					
					<P>
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
					</P>

					<table align='center' border="1" width="98%" cellspacing='0' cellpadding='0' id='ResultTab'>
					<tr>
					<th class='columnheader' width='50%'><fmt:message key="eMP.OtherName.label" bundle="${mp_labels}"/></th>
					<th class='columnheader' width='50%'><fmt:message key="eMP.OtherNamOtherLang.label" bundle="${mp_labels}"/></th>
					</tr>

					<%
				}

				String classValue = "" ;

                if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
                    classValue = "QRYODD" ;

                String other_name   = rs.getString("other_name");
                String other_name_loc_lang  = rs.getString("other_name_loc_lang");
                String other_name1  = other_name;
                String other_name_loc_lang1 = other_name_loc_lang;			
                
                if(other_name==null || other_name.equals("null"))
                {
                    other_name="&nbsp;";
                    other_name1="";
                }
                if(other_name_loc_lang==null || other_name_loc_lang.equals("null"))
                {
                    other_name_loc_lang="&nbsp;";
                    other_name_loc_lang1="";
                }
				out.println("<tr><td   class='" + classValue + "' align='left'>"); 
                out.println("<a href=\"javascript:closeWin('"+convJS(other_name1)+"','"+convJS(other_name_loc_lang1)+"')\">");          
                out.println(other_name+"</a></td>");
                if(classValue.equals("QRYEVEN"))    classValue = "QRYEVENOTHLANG";
                else if(classValue.equals("QRYODD"))    classValue = "QRYODDOTHLANG";
                out.println("<td  class='" + classValue + "' >");
                out.println("<a href=\"javascript:closeWin('"+convJS(other_name1)+"','"+convJS(other_name_loc_lang1)+"')\">");				
                out.println(other_name_loc_lang+"</a></td></tr>");  
                i++;
				cnt++;
                
                if(classValue.equals("QRYEVEN"))    classValue = "QRYEVEN";
                else if(classValue.equals("QRYODD"))    classValue = "QRYODD";


            }//endwhile

	if(cnt==0)				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");

	if(i == 2)
	{
		%>
			<script>				
				document.getElementById('ResultTab').rows[1].cells(0).click() ;
			</script>
		<%
	}

	if (!rs.next() && cnt!=0 )
    {
	%>
	<script>
		document.getElementById('nextval').innerHTML=" ";	
	</script>

	<% 
	} 

    }
    catch(Exception e)
    {
        out.println(e.toString());
    }
    finally
    {
        if(stmt!=null)
            stmt.close();
        if(rs!=null)
            rs.close();
    }
    }
    catch(Exception e)
    {
        out.println(e.toString());
    }
    finally
    {
        if(conn!=null) ConnectionManager.returnConnection(conn,request);
    }
   %>

    </td></tr>
    </table>

<form name='dummyform' id='dummyform' action='SearchStdOtherNameResult.jsp' method='post'>
    <input type='hidden' name='from' id='from' >
    <input type='hidden' name='to' id='to' >
    <input type='hidden' name='whereclause' id='whereclause' value="<%=sql%>">
</form>
<script>
		if( parent.SearchCriteria.document.Search_STD_Other_Name_form.search != null )
			if( parent.SearchCriteria.document.Search_STD_Other_Name_form.search.disabled )
				parent.SearchCriteria.document.Search_STD_Other_Name_form.search.disabled = false;
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

//The following methods are added by suresh M on 11.04.2011 to replace the special chars
	public String convJS(Object str) {
		// Convert problem characters to JavaScript Escaped values
		if (str == null) {
			return "";
		}  
	  String escStr = (String)str;
	  escStr = replace(escStr,"\\","\\\\"); // replace backslash with \\
	  escStr = replace(escStr,"'","\\\'");  // replace an single quote with \'
	  escStr = replace(escStr,"\"","\\\""); // replace a double quote with \"
	  escStr = replace(escStr,"\r","\\r"); // replace CR with \r;
	  escStr = replace(escStr,"\n","\\n"); // replace LF with \n;  
	  return escStr;
} 

String replace(String s, String one, String another) {
// In a string replace one substring with another
  if (s.equals("")) return "";
  String res = "";
  int i = s.indexOf(one,0);
  int lastpos = 0;
  while (i != -1) {
    res += s.substring(lastpos,i) + another;
    lastpos = i + one.length();
    i = s.indexOf(one,lastpos);
  }
  res += s.substring(lastpos);  // the rest
  return res;  
}
%>

