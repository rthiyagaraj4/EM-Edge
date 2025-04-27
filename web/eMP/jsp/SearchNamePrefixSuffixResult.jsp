<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,java.io.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
request.setCharacterEncoding("UTF-8");
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script Language="JavaScript" src="../js/NamePrefix.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY  class='CONTENT' onLoad='' onKeyDown = 'lockKey()'>
<%
    StringBuffer strsql2=new StringBuffer();
	StringBuffer sbQuery = new StringBuffer();
//	String sql ="";									// will be deleted once code walkthrough is done
    StringBuffer strsql1=new StringBuffer();

    String whereClause = request.getParameter("whereclause");
    String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	String opt = request.getParameter("opt");
    int andCheck=0;
    
    if ( whereClause == null || whereClause.equals("")) 
    {
//        sql="";
        
        String name_prefix_suffix= request.getParameter("name_prefix_suffix");
        String name_prefix_suffix_loc_lang  = request.getParameter("name_prefix_suffix_loc_lang");
        String criteria = request.getParameter("criteria");

        if (!(name_prefix_suffix==null || name_prefix_suffix.equals("")) )
        {
            name_prefix_suffix=name_prefix_suffix.toUpperCase();

			if(opt.equals("Prefix"))
			{
				if (criteria.equals("N")) {
					sbQuery.append(" where upper(NAME_PREFIX)= upper('");
					sbQuery.append(name_prefix_suffix);
					sbQuery.append("')");
//					sql = " where upper(NAME_PREFIX)= upper('"+name_prefix_suffix+"')";
					andCheck = 1;
				} else if(criteria.equals("C")) {
					sbQuery.setLength(0);
					sbQuery.append(" where upper(NAME_PREFIX) like upper('%");
					sbQuery.append(name_prefix_suffix);
					sbQuery.append("%')");
//					sql = " where upper(NAME_PREFIX) like upper('%"+name_prefix_suffix+"%')";
					andCheck = 1;
				} else if(criteria.equals("S")){
					sbQuery.setLength(0);
					sbQuery.append(" where upper(NAME_PREFIX) like upper('");
					sbQuery.append(name_prefix_suffix);
					sbQuery.append("%')");
//					sql = " where upper(NAME_PREFIX) like upper('"+name_prefix_suffix+"%')";
					andCheck = 1;
				} else if(criteria.equals("E")){
					sbQuery.setLength(0);
					sbQuery.append(" where upper(NAME_PREFIX) like upper('%");
					sbQuery.append(name_prefix_suffix);
					sbQuery.append("')");
//					sql = " where upper(NAME_PREFIX) like upper('%"+name_prefix_suffix+"')";
					andCheck = 1;
				}
			}
			else if(opt.equals("Suffix"))
			{
				if (criteria.equals("N")) {
					sbQuery.setLength(0);
					sbQuery.append(" where upper(NAME_SUFFIX)= upper('");
					sbQuery.append(name_prefix_suffix);
					sbQuery.append("')");
//					sql = " where upper(NAME_SUFFIX)= upper('"+name_prefix_suffix+"')";
					andCheck = 1;
				} else if(criteria.equals("C")) {
					sbQuery.setLength(0);
					sbQuery.append(" where upper(NAME_SUFFIX) like upper('%");
					sbQuery.append(name_prefix_suffix);
					sbQuery.append("%')");
//					sql = " where upper(NAME_SUFFIX) like upper('%"+name_prefix_suffix+"%')";
					andCheck = 1;
				} else if(criteria.equals("S")){
					sbQuery.setLength(0);
					sbQuery.append(" where upper(NAME_SUFFIX) like upper('");
					sbQuery.append(name_prefix_suffix);
					sbQuery.append("%')");
//					sql = " where upper(NAME_SUFFIX) like upper('"+name_prefix_suffix+"%')";
					andCheck = 1;
				} else if(criteria.equals("E")){
					sbQuery.setLength(0);
					sbQuery.append(" where upper(NAME_SUFFIX) like upper('%");
					sbQuery.append(name_prefix_suffix);
					sbQuery.append("')");
//					sql = " where upper(NAME_SUFFIX) like upper('%"+name_prefix_suffix+"')";
					andCheck = 1;
				}
			}
        }
        
        if (!(name_prefix_suffix_loc_lang==null || name_prefix_suffix_loc_lang.equals("")) )
        {
            if (sbQuery.toString().equals(" "))
            {
				sbQuery.setLength(0);
				sbQuery.append(" where ");
//                sql = " where ";
            }
            else
            {
				sbQuery.append(" and ");
//                sql += " and ";
            }

            InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( name_prefix_suffix_loc_lang.getBytes()), "UTF-8" ) ;
            name_prefix_suffix_loc_lang = (new BufferedReader(reader)).readLine() ;

			if(opt.equals("Prefix"))
			{
				if (criteria.equals("N"))
				{
					sbQuery.append(" NAME_PREFIX_LOC_LANG='");
					sbQuery.append(name_prefix_suffix_loc_lang);
					sbQuery.append("'");
//					sql = sql + " NAME_PREFIX_LOC_LANG='"+name_prefix_suffix_loc_lang+"'";
					andCheck = 1;
				}
				else if(criteria.equals("C")) {
					sbQuery.append(" NAME_PREFIX_LOC_LANG like '%");
					sbQuery.append(name_prefix_suffix_loc_lang);
					sbQuery.append("%'");
//					sql = sql + " NAME_PREFIX_LOC_LANG like '%"+name_prefix_suffix_loc_lang+"%'";
					andCheck = 1;
				}
				else if(criteria.equals("S")){
					sbQuery.append(" NAME_PREFIX_LOC_LANG like '");
					sbQuery.append(name_prefix_suffix_loc_lang);
					sbQuery.append("%'");
//					sql = sql + " NAME_PREFIX_LOC_LANG like '"+name_prefix_suffix_loc_lang+"%'";
					andCheck = 1;
				}
				else if(criteria.equals("E")){
					sbQuery.append(" NAME_PREFIX_LOC_LANG like '%");
					sbQuery.append(name_prefix_suffix_loc_lang);
					sbQuery.append("'");
//					sql = sql + " NAME_PREFIX_LOC_LANG like '%"+name_prefix_suffix_loc_lang+"'";
					andCheck = 1;
				}
			}
			else if(opt.equals("Suffix"))
			{
				if (criteria.equals("N"))
				{
					sbQuery.append(" NAME_SUFFIX_LOC_LANG='");
					sbQuery.append(name_prefix_suffix_loc_lang);
					sbQuery.append("'");
//					sql = sql + " NAME_SUFFIX_LOC_LANG='"+name_prefix_suffix_loc_lang+"'";
					andCheck = 1;
				}
				else if(criteria.equals("C")) {
					sbQuery.append(" NAME_SUFFIX_LOC_LANG like '%");
					sbQuery.append(name_prefix_suffix_loc_lang);
					sbQuery.append("%'");
//					sql = sql + " NAME_SUFFIX_LOC_LANG like '%"+name_prefix_suffix_loc_lang+"%'";
					andCheck = 1;
				}
				else if(criteria.equals("S")){
					sbQuery.append(" NAME_SUFFIX_LOC_LANG like '");
					sbQuery.append(name_prefix_suffix_loc_lang);
					sbQuery.append("%'");
//					sql = sql + " NAME_SUFFIX_LOC_LANG like '"+name_prefix_suffix_loc_lang+"%'";
					andCheck = 1;
				}
				else if(criteria.equals("E")){
					sbQuery.append(" NAME_SUFFIX_LOC_LANG like '%");
					sbQuery.append(name_prefix_suffix_loc_lang);
					sbQuery.append("'");
//					sql = sql + " NAME_SUFFIX_LOC_LANG like '%"+name_prefix_suffix_loc_lang+"'";
					andCheck = 1;
				}
			}
		}
    }
    else
    {
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
//        sql = whereClause;
        InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( sbQuery.toString().getBytes()), "UTF-8" ) ;
		sbQuery.setLength(0);
		sbQuery.append((new BufferedReader(reader)).readLine());
//        sql = (new BufferedReader(reader)).readLine() ;     
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

	String prompt		= "";
	String prompt_local	= "";	
	
	Connection conn = null; 
    Statement stmt=null;
    ResultSet rs=null;
    int maxRecord = 0;
    
    try
    {
		if(opt.equals("Prefix"))
		{	
			prompt		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NamePrefix.label","common_labels");
			prompt_local = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NamePrefixinOtherLanguage.label","mp_labels");		

			strsql1.append("select count(*) as total from mp_name_prefix ");
			strsql1.append(sbQuery.toString());
			strsql2.append("select NAME_PREFIX,NAME_PREFIX_LOC_LANG from mp_name_prefix ");
			strsql2.append(sbQuery.toString());
			strsql2.append( " order by NAME_PREFIX");
		}
		else if(opt.equals("Suffix"))
		{
			prompt		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NameSuffix.label","common_labels");
			prompt_local = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NameSuffixinOtherLanguage.label","mp_labels");		
		
			strsql1.append("select count(*) as total from mp_name_suffix ");
			strsql1.append(sbQuery.toString());
			strsql2.append("select NAME_SUFFIX,NAME_SUFFIX_LOC_LANG from mp_name_suffix ");
			strsql2.append(sbQuery.toString());
			strsql2.append(" order by NAME_SUFFIX");
		}
			conn = ConnectionManager.getConnection(request);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(strsql1.toString());
			rs.next();
			maxRecord = rs.getInt("total");
			rs = stmt.executeQuery(strsql2.toString()); 
		%>

        <p>
        <table align='right' >
        <tr>
            <td>
                <%
                        if ( !(start <= 1) )
                        {
                            out.println("<A HREF='javascript:nextSet("+(start-14)+","+(end-14)+")' text-decoration='none'>Previous</A>");
                        }

                        if ( !( (start+14) > maxRecord ) )
                        {
                            out.println("<A HREF='javascript:nextSet("+(start+14)+","+(end+14)+")' text-decoration='none'>Next</A>");
                        }
                %>
            </td>
        </tr>
        </table>
        <BR>
        </p>

        <table align='center' border="1" width="100%"cellspacing='0' cellpadding='0'>
        <th width='50%'><%=prompt%></th>
        <th width='50%'><%=prompt_local%></th>
        <%
            if ( start != 1 )
                for( int j=1; j<start; i++,j++ ) {
                    rs.next() ;
                }

            String classValue = "" ;

            while ( rs.next() && i<=end )
            {
                if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
                    classValue = "QRYODD" ;

                out.println("<tr><td   class='" + classValue + "' align='left'>");
        
                String name_prefix_suffix    = rs.getString(1);
                String name_prefix_suffix_loc_lang   = rs.getString(2);
                String name1		  = name_prefix_suffix;
                String name_loc_lang1 = name_prefix_suffix_loc_lang;
                
                if(name_prefix_suffix==null || name_prefix_suffix.equals("null"))
                {
                    name_prefix_suffix="&nbsp;";
                    name1="";
                }
                if(name_prefix_suffix_loc_lang==null || name_prefix_suffix_loc_lang.equals("null"))
                {
                    name_prefix_suffix_loc_lang="&nbsp;";
                    name_loc_lang1="";
                }
    
                out.println("<a id='np"+i+"' href=\"javascript:closeWin('np"+i+"')\">");
                out.println(name_prefix_suffix+"</a></td>");
                
                if(classValue.equals("QRYEVEN"))    classValue = "QRYEVENOTHLANG";
                else if(classValue.equals("QRYODD"))    classValue = "QRYODDOTHLANG";
                
                out.println("<td  class='" + classValue + "' >");
                out.println("<a id='nplc"+i+"' href=\"javascript:closeWin('nplc"+i+"')\">");
                out.println(name_prefix_suffix_loc_lang+"</a></td></tr>");
                i++;

                if(classValue.equals("QRYEVENOTHLANG"))    classValue = "QRYEVEN";
                else if(classValue.equals("QRYODDOTHLANG"))    classValue = "QRYODD";
            }//endwhile

        if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
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
    <form name='dummyform' id='dummyform' action='SearchNamePrefixSuffixResult.jsp' method='post'>
        <input type='hidden' name='from' id='from' >
        <input type='hidden' name='to' id='to' >
        <input type='hidden' name='whereclause' id='whereclause' value="<%=sbQuery.toString()%>">
		<input type='hidden' name='opt' id='opt' value="<%=opt%>">
</form>
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

