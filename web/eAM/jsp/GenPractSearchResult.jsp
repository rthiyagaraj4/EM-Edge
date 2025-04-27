<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey()'>

<%
		request.setCharacterEncoding("UTF-8");
        String code="";
    
		String desc="";
 
		String user_sql="";

		String whereClause="";

		java.util.HashMap htjbtitle=new java.util.HashMap();
		String pract_type					=request.getParameter("pract_type");            
		if(pract_type==null) pract_type="";

		String fromLink					=request.getParameter("fromLink");            
		if(fromLink==null) fromLink="";

		String primary_specialty		=request.getParameter("primary_specialty");
		if(primary_specialty==null) primary_specialty="";

		String pract_id						=request.getParameter("pract_id");                
		if(pract_id==null) pract_id="";
		pract_id=pract_id.trim();
		//out.println("<script> alert(\" in search queryString:---"+pract_id+"\"); </script>");
		String pract_name				=request.getParameter("pract_name");         
		if(pract_name==null) pract_name="";
		pract_name=pract_name.trim();

		String start_ends_contains=request.getParameter("start_ends_contains");         
		if(start_ends_contains==null) start_ends_contains="";

		String job_title						=request.getParameter("job_title");         
		if(job_title==null) job_title="";

		String gender						=request.getParameter("gender");         
		if(gender==null) gender="";


		String bool_user_sql			=request.getParameter("bool_user_sql");         
		if(bool_user_sql==null) bool_user_sql="";

		String radiovalue			=request.getParameter("radiovalue");         
		if(radiovalue==null) radiovalue="";


		if(fromLink.equals("")){
		//session.putValue("sqlResultPage","");
		}

        //whereClause  = (String) session.getValue("sqlResultPage");
		 out.println("<script> alert(\" in search queryString:---"+whereClause+"\"); </script>");
         if(whereClause==null) whereClause="";

         user_sql=(String) session.getValue("sqlResultPage");
         if(user_sql==null) user_sql="";
         user_sql=java.net.URLDecoder.decode(user_sql);

         if(bool_user_sql.equals(""))
         {
             if(user_sql.equals("") ) 
	         bool_user_sql="0";
              else
	         bool_user_sql="1";
          }

%>
<script>



	function closew(Dcode,Name)
	  {
		

		//this loop is to remove the %20 addition in description feilds
		while(Name.indexOf("+")!=-1)
		  {
			Name=Name.replace('+'," ");
	 	  }
		 
	
	window.parent.parent.returnValue=Dcode+"~"+Name;
		window.parent.parent.close();
	  }
/******function to show practitioner details*********************/
 function showPractWindow(practID)
	{
	    var url     = "ViewPractitionerDtls.jsp?practitioner_id="+practID+"&fcall=call";
	    //var dialogHeight    = "30" ;
	    //var dialogWidth = "40" ;
		var dialogHeight    = "400px" ;
	    var dialogWidth = "700px" ;
	    var dialogLeft="";
	    var arguments   = "" ;
	    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;dialogLeft:"+dialogLeft+";";
	    var reportURL   =  window.showModalDialog( url, arguments, features ) ;
	}

 </script>


<%
Connection conn=null;
PreparedStatement stmt=null;
ResultSet rs=null;
ResultSet rs1=null;

ResultSet rs_practDetail=null;
PreparedStatement pstmt_practDetail=null;

//String searchtext="";
int i=1;
String dispDescFirst =request.getParameter("dispDescFirst");
if(dispDescFirst == null) dispDescFirst="";

try{
	conn=ConnectionManager.getConnection(request);

    String sql = (String) session.getValue("sqlResultPage");
    
	String from = request.getParameter( "from" ) ;
  
    String to = request.getParameter( "to" ) ;
 
  //  searchtext = request.getParameter("searchtext");
    //if(searchtext == null) searchtext="";


	int start = 0 ;
	int end = 0 ;
	int k=0;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;
	

int sqlind=sql.indexOf("order by");
if(sqlind == -1)
{
	sqlind=sql.indexOf("ORDER BY");
}

if(sqlind != -1)
{
	sql = sql.substring(0,sqlind-1);
}

try{

if(radiovalue.equals("C")){
sql=sql+" order by practitioner_id";
}
else{
sql=sql+" order by practitioner_name";
}


stmt = conn.prepareStatement(sql);


int index2=sql.indexOf("upper(nvl(?,b.practitioner_id)) or");
String strpart1="";
String strpart2="";
if(!pract_id.equals("")  )
{
if(index2>0)
{
strpart1=sql.substring(0,index2);
String temp="upper(nvl(?,b.practitioner_id)) and";
int len=temp.length();
strpart1=strpart1+"upper(nvl(?,b.practitioner_id))  and  "; 
strpart2=sql.substring(index2+len);
strpart2=strpart1+strpart2;
 //out.println("<script> alert(\" in search queryString:---"+strpart2+"\"); </script>");
sql=strpart2;
}
}

if(!pract_id.equals("")  )
{
if(start_ends_contains.equals("S"))
					{
						pract_id=pract_id+"%";
			          //   pract_name=pract_id+"%";   		
					}
				else if(start_ends_contains.equals("E"))
				{
						pract_id="%"+pract_id;
				       //pract_name="%"+pract_id;
				}
				else if(start_ends_contains.equals("C"))
				{
						pract_id="%"+pract_id+"%";
			           //pract_id="%"+pract_id+"%";	
				}
}else
	{

	
	if(start_ends_contains.equals("S"))
	{
  	if(!(pract_name.equals("")||pract_name.equals("")))
	{
		pract_name=pract_name+"%";
	//	pract_id=pract_name+"%";
		}
	}
	else if(start_ends_contains.equals("E"))
	{
			if(!(pract_name.equals("")||pract_name.equals("")))
		{
			pract_name="%"+pract_name;
		//	pract_id="%"+pract_name;
     	}
	}
	else if(start_ends_contains.equals("C"))
	{
			if(!(pract_name.equals("")||pract_name.equals("")))
		{
			pract_name="%"+pract_name+"%";
			//pract_id="%"+pract_name+"%";
		}
	}

	}
	if(pract_type.equals("")){
		stmt.setString(1,"%");
	}else{
	
		//out.println("<script> alert(\" in search queryString:---"+pract_id+"\"); </script>");
		stmt.setString(1,pract_type);
	}



	if(primary_specialty.equals("")){
		stmt.setString(2,"%");
	}else{
		stmt.setString(2,primary_specialty);
	}


//out.println("<script> alert(\" in search queryString:---"+pract_id.equals("")+"\"); </script>");
	if(pract_id.equals("")){
		//out.println("<script> alert(\" in search queryString:---"+pract_id+"\"); </script>");
		stmt.setString(3,"%");
	}else{
		//out.println("<script> alert(\" in search queryString:pract_id---"+pract_id+"\"); </script>");
		stmt.setString(3,pract_id);
	}

	if(pract_name.equals("")){
		stmt.setString(4,"%");
	}else{
		stmt.setString(4,pract_name);
	}

	if(gender.equals("")){
		stmt.setString(5,"%");
	}else{
		stmt.setString(5,gender);
	}


	if(job_title.equals("")){
		stmt.setString(6,"%");
	}else{
		stmt.setString(6,job_title);
	}



    




rs1=stmt.executeQuery();

while(rs1.next())
{
	k++;

}




if(k == 0)
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));  if(parent.frames[0].document.getElementById('radiovalue').value == 'D'){  if(parent.frames[0].document.getElementById('pract_name'))                   parent.frames[0].document.getElementById('pract_name').readOnly=false; }else if (parent.frames[0].document.getElementById('radiovalue').value == 'C'){if(parent.frames[0].document.getElementById('pract_id'))                   parent.frames[0].document.getElementById('pract_id').readOnly=false; }else {if(parent.frames[0].document.getElementById('pract_name'))                   parent.frames[0].document.getElementById('pract_name').readOnly=false;}  if(parent.frames[0].document.getElementById('Search'))                                       parent.frames[0].document.getElementById('Search').disabled=false;  if(parent.frames[0].document.getElementById('clear'))                                                 parent.frames[0].document.getElementById('clear').disabled=false;	document.location.href='../../eCommon/html/blank.html'</script>");

rs = stmt.executeQuery();
%>

<table align='right'>
<tr>
<td>
<%


if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/GeneralPractitionerSearchResult.jsp?dispDescFirst="+dispDescFirst+"&bool_user_sql="+URLEncoder.encode(bool_user_sql)+"&from="+(start-14)+"&to="+(end-14)+"&fromLink="+URLEncoder.encode("Yes")+"&pract_type="+URLEncoder.encode(pract_type)+"&primary_specialty="+URLEncoder.encode(primary_specialty)+"&pract_id="+URLEncoder.encode(pract_id)+"&gender="+URLEncoder.encode(gender)+"&job_title="+URLEncoder.encode(job_title)+"&start_ends_contains="+URLEncoder.encode(start_ends_contains)+"&pract_name="+URLEncoder.encode(pract_name)+"&radiovalue="+radiovalue+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > k ) )
	out.println("<A HREF='../../eAM/jsp/GeneralPractitionerSearchResult.jsp?dispDescFirst="+dispDescFirst+"&bool_user_sql="+URLEncoder.encode(bool_user_sql)+"&from="+(start+14)+"&to="+(end+14)+"&fromLink="+URLEncoder.encode("Yes")+"&pract_id="+URLEncoder.encode(pract_id)+"&pract_type="+URLEncoder.encode(pract_type)+"&primary_specialty="+URLEncoder.encode(primary_specialty)+"&gender="+URLEncoder.encode(gender)+"&job_title="+URLEncoder.encode(job_title)+"&start_ends_contains="+URLEncoder.encode(start_ends_contains)+"&pract_name="+URLEncoder.encode(pract_name)+"&radiovalue="+radiovalue+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");


%>
</td>
</tr>
</table>
<BR><BR>
</P>



	<table border="1" width="100%" cellspacing='0' cellpadding='0' id='tb1'>
	<%if(dispDescFirst.equals("dispDescFirst")) {%>
	<th width='60%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	<th width='40%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<%} else {%>
	<th >+</th>
	<th ><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="Common.Position.label" bundle="${common_labels}"/></th>
	
	<%} %>

	<%
if(rs != null)
{
	if ( start != 1 )
	for( int j=1; j<start; i++,j++ )
	rs.next() ;

	while(rs.next() && i<=end)
	{
%>
<%
	String rowclass = "" ;


	if ( i % 2 == 0 )
	rowclass = "QRYEVEN" ;
	else
	rowclass = "QRYODD" ;
	code							=	rs.getString("practitioner_type");
	desc							=	rs.getString("primary_specialty");
	String pract_id1		=	rs.getString("practitioner_id");
	String pract_name1	=	rs.getString("practitioner_name");
	String gender1			=	rs.getString("gender");
    String job_title1       = rs.getString("position_code");

	  		
	
		out.println("<tr><td><a href=\"javascript:showPractWindow('"+pract_id1+"')\">+</a></td>");
		%>
		<td class=<%=rowclass%>><a href=javascript:closew("<%=pract_id1%>","<%=java.net.URLEncoder.encode(pract_name1)%>")><%=pract_id1%></a></td>
		<%
		out.println( "<td class='"+rowclass+"'>");
		%>
		<a href=javascript:closew("<%=pract_id1%>","<%=java.net.URLEncoder.encode(pract_name1)%>")>
		<%
		out.println( pract_name1	+"</a></td>" );
		out.println("<td class='"+rowclass+"'>");
		out.println(code+"</a></td><td  class='"+rowclass+"'>");
		out.println( desc+"</td>" );
		out.println( "<td class='"+rowclass+"'>"+ gender1			+"</td>" );

		job_title1=(String) htjbtitle.get(pract_id1);
		if(job_title1==null || job_title1.equals("null"))
		job_title1="&nbsp;";

		out.println( "<td class='"+rowclass+"'>"+ job_title1+"</td></tr>" );
		
		i++;	  
	 }htjbtitle.clear();
	 
  %>
<script>

if(parent.frames[0].document.getElementById('pract_id'))
parent.frames[0].document.getElementById('pract_id').readOnly=false;                     

if(parent.frames[0].document.getElementById('pract_name'))
parent.frames[0].document.getElementById('pract_name').readOnly=false;               


if(parent.frames[0].document.getElementById('Search'))
parent.frames[0].document.getElementById('Search').disabled=false;

if(parent.frames[0].document.getElementById('clear'))
parent.frames[0].document.getElementById('clear').disabled=false;

</script>
	  <%
   
  } 
}catch(Exception e) { out.println(e.toString());
}
	finally
	{
	
		if (rs != null) rs.close();
		if (rs1 != null) rs1.close();
		if (pstmt_practDetail != null) pstmt_practDetail.close();
		if (rs_practDetail != null) rs_practDetail.close();
		if (stmt != null) stmt.close();
	
	
	
	}

//session.putValue("sqlResultPage",sql);
%>
</table>
<!-- <input type='hidden' name='searchtext' id='searchtext' value="" >  -->
</BODY>
</html>
<%
}catch(Exception e) { out.println(e.toString());
}
	finally
	{
		if (conn != null) 
			ConnectionManager.returnConnection(conn,request);
	}	

%>

