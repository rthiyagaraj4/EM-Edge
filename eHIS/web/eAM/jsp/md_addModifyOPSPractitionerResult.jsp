<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*,eCommon.XSSRequestWrapper"%>
<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>


<script>
	
	async function showPractWindow(practID)
	{
	    var url     = "../../eAM/jsp/ViewPractitionerDtls.jsp?practitioner_id="+practID+"&fcall=call";
	    var dialogHeight    = "80vh" ;
		/* below lines moidified by Venkatesh.S agasint 57984 on 07-01-2015 */
	    var dialogWidth = "80vw" ;  
		/*End 57984 */
	    var dialogLeft="";
	    var arguments   = "" ;
	    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;dialogLeft:"+dialogLeft+";";
	    var reportURL   = await top.window.showModalDialog( url, arguments, features ) ;
	}
	
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
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	String finalPractList= request.getParameter("finalPractList");
	String search_by=request.getParameter("search_by");
	String search_txt=request.getParameter("search_txt");
	if(finalPractList == null) finalPractList="";
	if(search_by == null) search_by="";
	if(search_txt == null) search_txt="";
	search_txt = search_txt.replaceAll("\'","\'\'"); //Added for ML-MMOH-SCF-2337 by Ajay Hatwate

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
	
	String facility_id=request.getParameter("facility_id") ;
	if(facility_id == null) facility_id="";
	

	String alphabet=request.getParameter("alphabet");
	if( alphabet == null) alphabet="";
	String splty_code=request.getParameter("splty_code");
	if( splty_code == null) splty_code="";
	String req_end= request.getParameter("totCount");
	if(req_end == null) req_end="0";
	if(search_by.equals("01"))
	   search_by="PRACTITIONER_ID";
    else if(search_by.equals("02"))
	   search_by="PRACTITIONER_NAME";
	
	try
	{
		con = ConnectionManager.getConnection(request);
	
		String practSql=" Select A.Practitioner_ID, B.Practitioner_Name, 'Y', 'Y',upper(Practitioner_Name) from AM_PRACT_SPECIALITIES a, AM_PRACTITIONER B where   A.Practitioner_Id = B. Practitioner_Id and A.Facility_Id = '"+facility_id+"'and a.Speciality_Code = '"+splty_code+"'   ";
		if(!search_by.equals("") && !search_txt.equals(""))
          practSql=practSql+"and upper(B."+search_by+")  like upper('"+search_txt+"%')"; 
		
			practSql=practSql+" Union Select A.Practitioner_Id, B.Practitioner_Name, 'N', 'N',upper(Practitioner_Name) from AM_Pract_For_Facility A, AM_Practitioner B where   A.eff_status = 'E' and A.Practitioner_Id = B.Practitioner_Id and A.Facility_Id = '"+facility_id+"'   AND B.PRIMARY_SPECIALITY_CODE <> '"+splty_code+"'";
            if(!search_by.equals("") && !search_txt.equals(""))
				 practSql=practSql+"and upper(B."+search_by+")  like upper('"+search_txt+"%')"; 
			 practSql=practSql+" and A.Practitioner_Id not in (Select Practitioner_Id from  Am_Pract_Specialities where Speciality_Code = '"+splty_code+"'  and Facility_id = '"+facility_id+"'";
                if(!search_by.equals("") && !search_txt.equals(""))
          practSql=practSql+"and upper("+search_by+")  like upper('"+search_txt+"%')"; 
			practSql=practSql+")   order by 5";
	try
	{

	stmt = con.createStatement();
	rs=stmt.executeQuery(practSql);
	
	
	}
	catch(Exception e)
	{} 
	
	String sqlap="select count(1) total  from oa_appt a , op_clinic b where a.clinic_code = b.clinic_code and a.facility_id = b.facility_id and a.facility_id = ?  and a.practitioner_id =?  and b.speciality_code = ?  AND trunc(a.Appt_date)>=trunc(sysdate) AND A.APPT_STATUS != 'A' ";
	stmtap=con.prepareStatement(sqlap);
%>
	</head>

	<body  OnMouseDown="CodeArrest();"  class='CONTENT' onKeyDown = 'lockKey()'>
		<form name='facility_form_result' id='facility_form_result' action='../../eAM/jsp/md_addModifyOPSPractitionerResult.jsp' method='post' >
	<table border='0' cellpadding='0' cellspacing='0' width='85%' align='center'>
	<tr>
		<td class="white">			
		<table  align='right'>
		<tr>
		<td>
		<input type=hidden name=from id=from value='<%=start%>'>
		<input type=hidden name=to id=to value='<%=end%>'>
		<input type=hidden name='start' id='start' value='<%=start%>'>
		<input type=hidden name='end' id='end' value='<%=end%>'>
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
					<td class='columnheader' width='1%' >&nbsp;</td>
					<td class='columnheader' width='79%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
					<td class='columnheader' width='20%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
				</tr>
				<%  }
				int totApptCount=0;
				String classValue="",str3=""/*,str4=""*/;
				String chkAttribute="";String practID="";
			
				
				practID=rs.getString("Practitioner_ID");
				
				if(rs.getString(4).substring(0,1).equals("Y"))
				chkAttribute="CHECKED";
				else
				chkAttribute="";
				stmtap.setString(1,facility_id );
				stmtap.setString(2,practID );
				stmtap.setString(3,splty_code );
				rsap=stmtap.executeQuery();
				if(rsap!=null)
				rsap.next();
				totApptCount = rsap.getInt("total");

				if(rsap!=null)    rsap.close();

				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
				str3 = rs.getString(3).substring(0,1);
				
				
				%>
				<tr>
					<td width='1%' class='<%=classValue%>'><a href=javaScript:showPractWindow('<%=practID%>')>+</a></td>
					<td class='<%=classValue%>'><%=rs.getString(2)%></td>
					<td align='center' class='<%=classValue%>'><input type='hidden' name='enable<%=i%>' id='enable<%=i%>' value='<%=practID%>$<%=rs.getString(3).substring(0,1)%>$<%=rs.getString(4).substring(0,1)%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>'  id='chk<%=i%>' onClick='parent.frames[0].changeEnable(this,enable<%=i%>,<%=totApptCount%>,"<%=str3%>")'  value='<%=rs.getString("Practitioner_ID")%>' > </td>
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
					if (document.getElementById('next'))
						document.getElementById('next').style.visibility='hidden';
					</script>
				<%
						} else {%>
					<script >
					if (document.getElementById('next'))
						document.getElementById('next').style.visibility='visible';
					</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

				<%}

				session.setAttribute("AXSRightRecSet", accessRightRecSet);
				%>  			
			</table>		
		</td>
		</tr>
		</table>
		<input type='hidden' name='splty_code' id='splty_code' value='<%=splty_code%>'>
		<input type='hidden' name='function_name' id='function_name' value='insert'>
		<input type='hidden' name='finalPractList' id='finalPractList' value='<%=finalPractList%>'>
		<input type='hidden' name='totCount' id='totCount' value='<%=i%>'>
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='search_by' id='search_by' value='<%=search_by%>'>
		<input type='hidden' name='search_txt' id='search_txt' value='<%=search_txt%>'>
		
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
			  catch(Exception e){
				  //out.print(e);
				  e.printStackTrace();
			  }
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

