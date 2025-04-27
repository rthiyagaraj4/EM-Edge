<!DOCTYPE html>
<%--
	FileName	: StatGrpNationDetailresult.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*,java.text.*,webbeans.eCommon.*" %>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
</head>
<script Language="JavaScript">
function callMember(alpha)
{
	if(document.statgrpdtlquery.stat_grp_id.value.length !=0)
	{
		document.statgrpdtlquery.alphabet.value=alpha;
		document.statgrpdtlquery.dtl_flag.value='insert';
		document.statgrpdtlquery.submit();
	
	}
	else
	{
		parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=APP-000001 Statistics Group cannot be blank...'
	}
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<% 
String sql="";
String country_name="";
//int maxrec=0;
Hashtable statNationalRecSet= null;
Connection con=null;
try {
 con = ConnectionManager.getConnection(request);
statNationalRecSet=(Hashtable)session.getValue("StatNationalId");
if(statNationalRecSet==null)
{
	statNationalRecSet=new Hashtable();
}

	ResultSet rset=null ;
	Statement stmt=null;
	Statement stmt1=null;
	ResultSet rset1=null ;

	PreparedStatement pstmt1=null;


try{
	
	request.setCharacterEncoding("UTF-8");	
	String param=request.getParameter("param");
	if( param == null) param="";
	int maxrecord=0;
    int totprvrec=0;
	String classValue="";
	String totprvrec1=request.getParameter("totprvrec");
    if(totprvrec1 == null)	totprvrec=0;
	else totprvrec = Integer.parseInt(totprvrec1) ;
	
	String stat_grp_id=request.getParameter("stat_grp_id");
	if( stat_grp_id == null) stat_grp_id="";

	String category=request.getParameter("category");
	if(category == null) category="";

	
	if(!param.equals(""))
	{
		
		if( param.equals("Others"))
		{
			 if(category.equals("S"))
			{
				
				sql="SELECT   b.SERVICE_CODE country_code, NVL (a.member_id, '!'),     b.short_desc long_name, 'Y' cnt  FROM am_stat_grp_detail a, am_service b  WHERE b.SERVICE_CODE = a.member_id  AND a.stat_grp_id = '"+stat_grp_id+"' AND UPPER (substr(b.short_desc,1,1)) not between 'A' and 'Z'	UNION SELECT  SERVICE_CODE country_code, NULL member_id, short_desc long_name,'N' cnt FROM am_service WHERE eff_status = 'E' AND SERVICE_CODE NOT IN (SELECT member_id  FROM am_stat_grp_detail WHERE stat_grp_id = '"+stat_grp_id+"') AND UPPER (short_desc) like '"+param+"%' ORDER BY long_name";
			
			 
			}
			else if(category.equals("N"))
			{
				//Commented on 12/16/2008 by viswanath.b

				//sql="SELECT   b.country_code country_code, NVL (a.member_id, '!'),     b.long_desc long_name, 'Y' cnt  FROM am_stat_grp_detail a, mp_country b  WHERE b.country_code = a.member_id  AND a.stat_grp_id = '"+stat_grp_id+"' AND UPPER (substr(b.long_desc,1,1)) not between 'A' and 'Z' UNION SELECT  country_code country_code, NULL member_id, long_desc long_name,'N' cnt FROM mp_country WHERE eff_status = 'E' AND country_code NOT IN (SELECT member_id  FROM am_stat_grp_detail WHERE stat_grp_id = '"+stat_grp_id+"') AND UPPER (long_desc) like '"+param+"%' ORDER BY long_name";

				sql ="SELECT   b.country_code, NVL (a.member_id, '!'), b.long_name long_name, DECODE(NVL (a.member_id, '!'),'!','N','Y') cnt  FROM am_stat_grp_detail a, mp_country b WHERE b.country_code = a.member_id(+) AND b.eff_status = 'E' AND a.stat_grp_id(+) = '"+stat_grp_id+"' AND UPPER (SUBSTR (b.long_name, 1, 1)) NOT BETWEEN 'A' AND 'Z'   AND b.country_code NOT IN (SELECT member_id FROM am_stat_grp_detail  WHERE stat_grp_id <>'"+stat_grp_id+"')  ORDER BY b.long_name";

				
			
			}
			else if(category.equals("P"))
			{
				
                sql="SELECT   b.SPECIALITY_CODE country_code, NVL (a.member_id, '!'),     b.short_desc long_name, 'Y' cnt  FROM am_stat_grp_detail a, am_speciality b  WHERE b.SPECIALITY_CODE = a.member_id  AND a.stat_grp_id = '"+stat_grp_id+"' AND UPPER (substr(b.short_desc,1,1)) not between 'A' and 'Z'  UNION SELECT   speciality_code country_code, NULL member_id, short_desc long_name,'N' cnt FROM am_speciality WHERE eff_status = 'E' AND speciality_code NOT IN (SELECT member_id  FROM am_stat_grp_detail WHERE stat_grp_id = '"+stat_grp_id+"') AND UPPER (short_desc) like '"+param+"%' ORDER BY long_name";
				
			}

		}
		else
		{
			 if(category.equals("S"))
			{
		
				sql="SELECT   b.SERVICE_CODE country_code, NVL (a.member_id, '!'),     b.short_desc long_name, 'Y' cnt  FROM am_stat_grp_detail a, am_service b  WHERE b.SERVICE_CODE = a.member_id  AND a.stat_grp_id = '"+stat_grp_id+"' AND UPPER (b.short_desc) like '"+param+"%'			UNION SELECT  SERVICE_CODE country_code, NULL member_id, short_desc long_name,'N' cnt FROM am_service WHERE eff_status = 'E' AND SERVICE_CODE NOT IN (SELECT member_id  FROM am_stat_grp_detail WHERE stat_grp_id = '"+stat_grp_id+"') AND UPPER (short_desc) like '"+param+"%' ORDER BY long_name";
				
			}
			else  if(category.equals("N"))
			{
			//Commented on 12/16/2008 by viswanath.b
		
			//sql="SELECT   b.country_code country_code, NVL (a.member_id, '!'),     b.long_desc long_name, 'Y' cnt  FROM am_stat_grp_detail a, mp_country b  WHERE b.country_code = a.member_id  AND a.stat_grp_id = '"+stat_grp_id+"' AND UPPER (b.long_desc) like '"+param+"%' UNION SELECT   country_code country_code, NULL member_id, long_desc long_name,'N' cnt FROM mp_country WHERE eff_status = 'E' AND country_code NOT IN (SELECT member_id  FROM am_stat_grp_detail WHERE stat_grp_id = '"+stat_grp_id+"') AND UPPER (long_desc) like '"+param+"%' ORDER BY long_name";

			sql = "SELECT   b.country_code, NVL (a.member_id, '!'), b.long_name long_name,DECODE(NVL (a.member_id, '!'),'!','N','Y' )cnt FROM am_stat_grp_detail a, mp_country b WHERE b.country_code = a.member_id(+) AND b.eff_status = 'E' AND a.stat_grp_id(+) = '"+stat_grp_id+"' AND UPPER (b.long_name) LIKE'"+param+"%'  AND b.country_code NOT IN (SELECT member_id FROM am_stat_grp_detail WHERE stat_grp_id <> '"+stat_grp_id+"') ORDER BY b.long_name";
					
			
			}
			else  if(category.equals("P"))
			{
				
			
					sql="SELECT   b.SPECIALITY_CODE country_code, NVL (a.member_id, '!'),     b.short_desc long_name, 'Y' cnt  FROM am_stat_grp_detail a, am_speciality b  WHERE b.SPECIALITY_CODE = a.member_id  AND a.stat_grp_id = '"+stat_grp_id+"' AND UPPER (b.short_desc) like '"+param+"%' UNION SELECT   speciality_code country_code, NULL member_id, short_desc long_name,'N' cnt FROM am_speciality WHERE eff_status = 'E' AND speciality_code NOT IN (SELECT member_id  FROM am_stat_grp_detail WHERE stat_grp_id = '"+stat_grp_id+"') AND UPPER (short_desc) like '"+param+"%' ORDER BY long_name";
				
			  
		  }
	  }
	}
	
	stmt			            = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rset=stmt.executeQuery(sql);
	rset.last();
	maxrecord = rset.getRow();
	rset.beforeFirst();
	int i=0;
	if(maxrecord!=0){
    
%>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
	<form name='stat_grp_nation_detail_result_form' id='stat_grp_nation_detail_result_form'>
		<input type ='hidden' name ='stat_grp_id' id ='stat_grp_id' value ='<%=stat_grp_id%>'>
	    <input type ='hidden' name ='alphabet' id ='alphabet' value =' '>
	    <input type ='hidden' name ='dtl_flag' id ='dtl_flag' value =' '>
	    <input type ='hidden' name ='totprvrec' id ='totprvrec' value ='<%=maxrecord%>'>
	    <table cellspacing=0 cellpadding=0 width='100%' border=1>
			<tr>
				<th align='left' width='70%'><fmt:message key="Common.Member.label" bundle="${common_labels}"/></th>
				<th align='center' width='30%'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></th>
			</tr>
<% 
				String chkAttribute="";
                 String cnt="";
			
			    if(rset!=null)
				{
					while(rset.next())
					{
						country_name=rset.getString("LONG_NAME");
						cnt=rset.getString("cnt");
						if(cnt.equals("Y"))
							chkAttribute = "CHECKED";						
						else
								chkAttribute="";
						if ( (i+1) % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
						%>                          
						<tr>
							<td class='<%=classValue%>'><input type='hidden' name=code<%=i%> id=code<%=i%> value='<%=rset.getString(1)%>' ><%=rset.getString("long_name")%> </td>
							<td class='<%=classValue%>' align='center'><input type='checkbox' <%=chkAttribute%> name='inc<%=i%>'  id='inc<%=i%>'value='<%=country_name%>'></td>
							
						</tr>
						<input type="hidden" name="prev_select<%=i%>" id="prev_select<%=i%>" value="<%=chkAttribute%>">
<%	
					i++;
				}
			}
	}
			if(maxrecord==0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				}%>
        
		</table>
		</form>
		<form name='stat_grp_nation_detail_result_form1' id='stat_grp_nation_detail_result_form1'  method='post' target='parent.parent.messageFrame'>
		<input type='hidden' name='maxrecord' id='maxrecord' value=<%=maxrecord%> >
		<input type='hidden' name='insert_to_db' id='insert_to_db' value='' >
		<input type='hidden' name='function_name' id='function_name' value='insert' >
		</form>
	</body>
</html>
<%



} catch(Exception e){out.println("here: ");out.println(e); } 
finally
{
	try{
	if (rset != null)   rset.close();
	if (rset1 != null)  rset1.close();
	if (stmt != null)   stmt.close();
	if (stmt1 != null)  stmt1.close();
    if(pstmt1!=null)  pstmt1.close(); 
	}
	catch(Exception e)
	{}
	
	
}

}
catch(Exception e) { out.println(e);}
	finally{
		try{
	
		}
		catch(Exception e)
		{}
	ConnectionManager.returnConnection(con,request);
	}

%>

