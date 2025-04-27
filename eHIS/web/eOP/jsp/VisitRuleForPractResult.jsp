<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*"%>
<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>


<script>	 
	
	function submitPrevNext(from, to)
	{
	      document.forms[0].finalPractList.value=parent.frames[0].practList;

		  document.forms[0].from.value = from;
	      document.forms[0].to.value = to; 
	      document.forms[0].submit();
	}
</script>
<%
request.setCharacterEncoding("UTF-8");
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	String finalPractList= request.getParameter("finalPractList");
	String search_by=request.getParameter("search_by");
	String search_txt=request.getParameter("search_txt");
	if(finalPractList == null) finalPractList="";
	if(search_by == null) search_by="";
	if(search_txt == null) search_txt="";

	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=0;
         
        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 13; }   else {  end = Integer.parseInt( to ) ; }
        
	
	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	PreparedStatement stmtap=null;
	ResultSet rs=null ;
	ResultSet rsap=null;
	
	String RuleID=request.getParameter("RuleID") ;
	if(RuleID == null) RuleID="";
	String facility_id=(String) session.getValue( "facility_id" ) ;	

	String alphabet=request.getParameter("alphabet");
	if( alphabet == null) alphabet="";
	String primary_specialty=request.getParameter("primary_specialty");
	if( primary_specialty == null) primary_specialty="";
	String req_end= request.getParameter("totCount");
	if(req_end == null) req_end="0";
	if(search_by.equals("01"))
	   search_by="PRACTITIONER_ID";
    else if(search_by.equals("02"))
	   search_by="PRACTITIONER_NAME";
	
	try
	{
		con = ConnectionManager.getConnection(request);
	 

		String practSql=" Select A.Practitioner_ID, B.Practitioner_Name, 'Y', 'Y',upper(b.Practitioner_Name) from op_visit_rule_for_pract a, AM_PRACTITIONER B where   A.Practitioner_Id = B. Practitioner_Id and A.rule_id = '"+RuleID+"' ";
		if(!primary_specialty.equals(""))
			practSql=practSql+"AND B.PRIMARY_SPECIALITY_CODE = '"+primary_specialty+"' ";

		if(!search_by.equals("") && !search_txt.equals(""))
          practSql=practSql+"and upper(B."+search_by+")  like upper('"+search_txt+"%')"; 
		
			practSql=practSql+" Union Select A.Practitioner_Id, B.Practitioner_Name, 'N', 'N',upper(Practitioner_Name) from AM_Pract_For_Facility A, AM_Practitioner B where   A.eff_status = 'E' and A.Practitioner_Id = B.Practitioner_Id and A.Facility_Id = '"+facility_id+"' ";
			if(!primary_specialty.equals(""))
			practSql=practSql+"AND B.PRIMARY_SPECIALITY_CODE = '"+primary_specialty+"' ";
            if(!search_by.equals("") && !search_txt.equals(""))
				 practSql=practSql+"and upper(B."+search_by+")  like upper('"+search_txt+"%')"; 
			 practSql=practSql+" and A.Practitioner_Id not in (Select Practitioner_Id from  op_visit_rule_for_pract where rule_id = '"+RuleID+"')";          
			practSql=practSql+"  order by 5";
			try	{ 
			stmt = con.createStatement();
			rs=stmt.executeQuery(practSql);	
			}
			catch(Exception e)
			{e.printStackTrace();} 	
	
%>
	</head>

	<body  OnMouseDown="CodeArrest();"  class='CONTENT' onKeyDown = 'lockKey()'>
		<form name='facility_form_result' id='facility_form_result' action='../../eOP/jsp/VisitRuleForPractResult.jsp' method='post' >
	<table border='0' cellpadding='0' cellspacing='0' width='85%' align='center'>
	<tr>
		<td class="white">			
		<table  align='right'>
		<tr>
		<td>
		<input  type=hidden  name=from id=from value='<%=start%>'>
		<input  type=hidden  name=to id=to value='<%=end%>'>
		<input  type=hidden  name='start' id='start' value='<%=start%>'>
		<input  type=hidden  name='end' id='end' value='<%=end%>'>
		<%

					if (start != 0){
				            for(int j=1; j<=start; i++,j++){
				                rs.next() ;
            					 }
            					 }
				while( i<end && rs.next() ){ 
					if(maxRecord==0)
					{

    if ( !(start <= 1)) {
        %>
     <a href='javascript:submitPrevNext(<%=(start-13)%>,<%=(end-13)%>)' id='prev' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
     <input type=hidden name='whichPage' id='whichPage' value='prev'>
 
<%
    }
   //  if ( !((start+14) >= maxRecord )){
%>
    <a href='javascript:submitPrevNext(<%=(start+13)%>,<%=(end+13)%>)' id='next' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
     <input type=hidden name='whichPage' id='whichPage' value='next'>
<%
  //  }
%>
		</td>
		</tr>
		</table>
		<tr>
		<td>
			<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
				<tr>					 
					<th class='columnheader' width='40%'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></th>
					<th class='columnheader' width='40%'><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>
					<th class='columnheader' width='20%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
				</tr>
				<%  }
//				int totApptCount=0;
				String classValue="",str3="";
				String chkAttribute="";String practID="";
			
				
				practID=rs.getString("Practitioner_ID");
			 
				if(rs.getString(4).substring(0,1).equals("Y"))
				chkAttribute="CHECKED";
				else
				chkAttribute="";
			
				if(rsap!=null)    rsap.close();

				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
				str3 = rs.getString(3).substring(0,1);
				
				
				%>
				<tr>					
					<td class='<%=classValue%>'><%=rs.getString(1)%></td>
					<td class='<%=classValue%>'><%=rs.getString(2)%></td>
					<td align='center' class='<%=classValue%>'><input type='hidden' name='enable<%=i%>' id='enable<%=i%>' value='<%=practID%>$<%=rs.getString(3).substring(0,1)%>$<%=rs.getString(4).substring(0,1)%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>' id='chk<%=i%>' onClick='parent.frames[0].changeEnable(this,enable<%=i%>,"<%=str3%>")'  value='<%=rs.getString("Practitioner_ID")%>' > </td>
					 
				</tr>
				<% i++;  
				maxRecord++;
					}//end of while  

				if(maxRecord == 0)
				{%>
					<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>
				<%}

			
				if ( maxRecord < 13 || (!rs.next()) ) {
				%>
					<script >
					if (document.getElementById("next"))
						document.getElementById("next").style.visibility='hidden';
					</script>
				<%
						} else {%>
					<script >
					if (document.getElementById("next"))
						document.getElementById("next").style.visibility='visible';
					</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

				<%}

				session.setAttribute("AXSRightRecSet", accessRightRecSet);
				%>  			
			</table>		
		</td>
		</tr>
		</table>
		<input type='hidden' name='primary_specialty' id='primary_specialty' value='<%=primary_specialty%>'>
		<input type='hidden' name='function_name' id='function_name' value='insert'>
		<input type='hidden' name='finalPractList' id='finalPractList' value='<%=finalPractList%>'>
		<input type='hidden' name='totCount' id='totCount' value='<%=i%>'>
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='search_by' id='search_by' value='<%=search_by%>'>
		<input type='hidden' name='search_txt' id='search_txt' value='<%=search_txt%>'>
		<input type = 'hidden' name = 'RuleID' value = <%=RuleID%>>
		
	</form>
</body>
</html>
		<%	 
		
			StringTokenizer steff=new StringTokenizer(finalPractList,"~");
			int cnt=steff.countTokens();
			for(int u3=0;u3<cnt;u3++)
			{
			String st4=steff.nextToken();
			StringTokenizer st5=new StringTokenizer(st4,"$");
			st5.nextToken();
			String status=st5.nextToken(); 
			st5.nextToken();
			String name=st5.nextToken(); 
			if(status.equals("Y"))
			out.println("<script>if(document.forms[0]."+name+") document.forms[0]."+name+".checked=true;</script>");
			else
			out.println("<script>if(document.forms[0]."+name+") document.forms[0]."+name+".checked=false;</script>");
			}
		}
			  catch(Exception e){out.print(e);}
			  finally
			  {
				try
				{
			  if(rs!=null)	rs.close();
			  
			  if(stmt!=null)	stmt.close();
			  if(pstmt!=null)	pstmt.close();
			  if(stmtap!=null)  stmtap.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}

			  ConnectionManager.returnConnection(con,request);

			  }%>

