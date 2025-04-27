<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
	</head>
	<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name='query_form' id='query_form'>
<%
    String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;

	String language_direction="";
	int count=0;

    if ( (whereClause == null || whereClause.equals("")) )
    {
//        sql = "";
        String name_suffix = request.getParameter("name_suffix");
		if(name_suffix != null)
		name_suffix=name_suffix.toUpperCase();
        String name_suffix_loc_lang = request.getParameter("name_suffix_loc_lang");
		if(name_suffix_loc_lang != null)
		name_suffix_loc_lang=name_suffix_loc_lang.toUpperCase();
        String enabled = request.getParameter("enabled");
        String baby_sex = request.getParameter("baby_sex");
        String baby_suffix_yn = request.getParameter("baby_suffix_yn");

        int andCheck = 0;

    if ( !(name_suffix == null || name_suffix.equals("")) )
        {
		sbQuery.append("where upper(name_suffix) like '");
		sbQuery.append(name_suffix);
		sbQuery.append("%'");
//        sql = "where mar_status_code like '"+cd+"%'";
        andCheck = 1;
        }
    if ( !(name_suffix_loc_lang == null || name_suffix_loc_lang.equals("")) )
    {
        if ( andCheck == 1 )
        {  
			sbQuery.append(" and ");
			sbQuery.append("upper(name_suffix_loc_lang) like  '");
			sbQuery.append(name_suffix_loc_lang);
			sbQuery.append("%'");
//			sql = sql + " and ";
//          sql = sql + "long_desc like  '"+longdesc+"%'" ;
        }
        else
        {
            sbQuery.setLength(0);
			sbQuery.append("where upper(name_suffix_loc_lang) like '");
			sbQuery.append(name_suffix_loc_lang);
			sbQuery.append("%'");
//			sql = "where long_desc like '"+longdesc+"%'" ;
            andCheck = 1;
        }
    }
	if ( !(baby_sex == null || baby_sex.equals("") || baby_sex.equals("A")) )
    {
        if ( andCheck == 1 )
        {  
			sbQuery.append(" and ");
			sbQuery.append("baby_sex like  '");
			sbQuery.append(baby_sex);
			sbQuery.append("%'");
//			sql = sql + " and ";
//          sql = sql + "long_desc like  '"+longdesc+"%'" ;
        } else{
			sbQuery.setLength(0);
			sbQuery.append("where baby_sex like '");
			sbQuery.append(baby_sex);
			sbQuery.append("%'");
//            sql = "where long_desc like '"+longdesc+"%'" ;
            andCheck = 1;
        }
    }
	
	if ( !(baby_suffix_yn == null || baby_suffix_yn.equals("") || baby_suffix_yn.equals("B")) )
    {
		String baby_suffix_yn1="";
		if(baby_suffix_yn.equals("Y"))
			baby_suffix_yn1="Y";
		else if(baby_suffix_yn.equals("N"))
			baby_suffix_yn1="N";
		
		if(andCheck == 0 ){
			sbQuery.setLength(0);
			sbQuery.append("where baby_suffix_yn='"+baby_suffix_yn1+"'");
		}else{
			sbQuery.append(" and baby_suffix_yn='"+baby_suffix_yn1+"'");
		}
    }
	

    if ( !(enabled == null || enabled.equals("") || enabled.equals("B")) )
    {
/*       if ( enabled.equals("E") )
            {
        if ( andCheck == 0 )
            sql = "where eff_status='E'";
        else
            sql = sql + " and eff_status='E'";
        }
       if ( enabled.equals("D") )
        {
        if ( andCheck == 0 )
            sql = " where  eff_status='D'";
        else
            sql = sql + " and eff_status='D'";
        }
		if ( enabled.equals("B") )
        {
        //out.println(sql );

        // sql = sql; nothing is added to get both E and D
        }
*/
		//Added by Sabarinathan S on 2/21/2005
		String strEffStatus="";
		if(enabled.equals("E"))
			strEffStatus="E";
		else if(enabled.equals("D"))
			strEffStatus="D";
		
		if(andCheck == 0 ){
			sbQuery.setLength(0);
			sbQuery.append("where eff_status='"+strEffStatus+"'");
		}else{
			sbQuery.append(" and eff_status='"+strEffStatus+"'");
		}
    }

    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
			sbQuery.append(" order by ");
//			sql=sql+" order by ";
			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					sbQuery.append(ord[i]);
//					sql=sql+ord[i];
				}else{
					sbQuery.append(ord[i]);
					sbQuery.append(",");
//					sql=sql+ord[i]+",";
				}
			}    
	}else{
		sbQuery.append(" order by name_suffix");
//        sql=sql+" order by name_suffix";
	}
    } //end of where clause IF
    else{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
//		sql = whereClause;
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

//Connection conn = (Connection) session.getValue( "connection" ) ;
Connection conn = null;
PreparedStatement pstmt=null;
PreparedStatement pstmt1=null;
ResultSet rs=null;
ResultSet rs1 =null;
ResultSet rs2 =null;
   // int maxRecord = 0;
try{
    conn = ConnectionManager.getConnection(request);

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

  /*  pstmt = conn.prepareStatement("select count(*) as total from mp_name_suffix "+sbQuery.toString());

    rs = pstmt.executeQuery();
    rs.next();
    maxRecord = rs.getInt("total");
	if (rs != null) rs.close();
    if (pstmt != null) pstmt.close();  

	if (maxRecord==0) 					
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/
	//out.println("sbQuery----->"+sbQuery);
    pstmt = conn.prepareStatement("select * from mp_name_suffix "+sbQuery.toString());
    rs = pstmt.executeQuery();

	boolean oth_lang = false ;
    pstmt1 = conn.prepareStatement(" select 'x' from mp_param where names_in_oth_lang_yn='Y' and module_id = 'MP' " );
    rs1 = pstmt1.executeQuery () ;
    if( rs1. next())
		oth_lang = true ;
	if (rs1 != null) rs1.close();
	if (pstmt1 != null) pstmt1.close();
%>



<%
    if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rs.next() ;
        String classValue = "" ;
		int cnt=0;
while ( i<=end && rs.next())
{
	if(cnt==0)
	{%>
		<P>
		<table align='right'>
		<tr>

		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/queryNameSuffix.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		%>
			<td align ='right' id='next' style='visibility:hidden'>
		<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eMP/jsp/queryNameSuffix.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
		</tr>
		</table>
			<BR><BR>
		</P>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th><fmt:message key="Common.NameSuffix.label" bundle="${common_labels}"/></th>
		<%
			if( oth_lang )
				out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NameSuffixinOtherLanguage.label","mp_labels")+"</th>") ; 
		%>

		<th><fmt:message key="eMP.BabySuffix.label" bundle="${mp_labels}"/></th>
		<th><fmt:message key="eMP.BabySex.label" bundle="${mp_labels}"/></th>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%	}
    if ( i % 2 == 0 )
                classValue = "QRYEVEN" ;
            else
            classValue = "QRYODD" ;

    String code = rs.getString("name_suffix");
	//out.println("code---->"+code);
    out.println("<tr>");
    out.println("   <td class='" + classValue + "'>");
    out.println("       <a href='../../eMP/jsp/NameSuffixModify.jsp?name_suffix="+java.net.URLEncoder.encode(code)+ "&language_direction="+language_direction+"' target='f_query_add_mod' >");
    out.println(code+"</a>");
    out.println("</td>");

    if(oth_lang )
    {
		/*
        if(classValue .equals("QRYEVEN"))
			classValue =  "QRYEVENOTHLANG";           
		else
		    classValue = "QRYODDOTHLANG"; 
		*/
       
        out.println("<td  class='" + classValue + "'");
		if(language_direction.equals("R"))
				{
				out.println("dir='RTL'");
				}
		out.println(">") ;
        out.println(        (rs.getString("name_suffix_loc_lang") == null? "&nbsp;":rs.getString("name_suffix_loc_lang") ) );
        out.println("</td>" );

		/*        
        if(classValue.equals("QRYEVENOTHLANG") )
            classValue= "QRYEVEN" ;
        else if(classValue.equals("QRYODDOTHLANG"))
			classValue="QRYODD";
		*/
    }

    out.println("<td align='center' class='" + classValue + "'>") ;
    if( rs.getString("baby_suffix_yn").equals("Y") )
            out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
            out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
            
    out.println("</td>");
    out.println("<td align='left' class='" + classValue + "'>") ;
    if(rs.getString("baby_sex").equals("M"))
            out.println("Male");
    else if(rs.getString("baby_sex").equals("F"))
            out.println("Female");
    else if(rs.getString("baby_sex").equals("U"))
            out.println("Both");
    else if(rs.getString("baby_sex").equals("B"))
            out.println("Both");
    out.println("</td>");
    
out.println("<td align='center' class='" + classValue + "'>") ;
    if ( rs.getString("eff_status").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
       out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
    i++;
	cnt++;
    out.println("</td></tr>");
}   
	if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	boolean flag = false;
	if ( cnt < 14 || (!rs.next()) ) {
	%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='hidden';
		</script>
	<% flag = true;
			} else {%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}%>

</table>
<br><center>
<%
        
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();      
}catch(Exception e) { 
	out.println(e.toString());
	e.printStackTrace();
}finally{
    if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>

</center>
<input type="hidden" name="language_direction" id="language_direction" value="<%=language_direction%>">
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

