
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
var roleValue = new Array();
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

	function submitPrevNext(from, to){
		var count=0;
		var arr = new Array();
		for(var u=0;u<document.forms[0].maxRecord.value;u++)
		{
			if(eval("document.forms[0].role"+u))
			{	
				//Added on 3/15/2005
				document.forms[0].roleValue.value += eval("document.forms[0].role"+u).value + "#";
				//End
				if(eval("document.forms[0].role"+u).value == 'C')
				{
				arr[count]=eval("document.forms[0].role"+u).value;				
				count++;
				}
			}
		}
	
        if(parent.frames[0].flag==true){
		if( arr.length ==  1) parent.frames[0].flag=false;
		else
		parent.frames[0].flag=true;
        }

		document.forms[0].totRoleId.value=parent.frames[0].rowId;
		document.forms[0].start.value = from;
		document.forms[0].to.value = to;	   
		document.forms[0].action = '../../eAM/jsp/md_addModifyPractForTeamResult.jsp';
		document.forms[0].target = "_self";
		var search_txt = document.forms[0].search_txt.value;
		var search_by = document.forms[0].search_by.value;

		var facility_id = document.forms[0].facilityID.value;
		var from = from;
		var to = to;
		var speciality_code=document.forms[0].speciality_code.value;
		var team_id = document.forms[0].team_id.value;

	/*	if(confirm('Do you want to submit the current page'))
			{
			 
			parent.frames[0].apply('Y');
			alert("yes");
			document.location.href="../../eAM/jsp/md_addModifyPractForTeamResult.jsp?facilityID="+facility_id+"&start="+from+"&to="+to+"&speciality_code="+speciality_code+"&team_id="+team_id+"&search_txt="+search_txt+"&search_by="+search_by;
		
			}
			else
			{
			document.location.href="../../eAM/jsp/md_addModifyPractForTeamResult.jsp?facilityID="+facility_id+"&start="+from+"&to="+to+"&speciality_code="+speciality_code+"&team_id="+team_id+"&search_txt="+search_txt+"&search_by="+search_by;
			
			} */
	   document.forms[0].submit();
		parent.parent.window.frames[2].location.href="../../eCommon/jsp/error.jsp";
	    document.forms[0].finalSelect.value=parent.frames[0].temp;
		//alert(document.forms[0].finalSelect.value);
	}
</script>

<%
request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	String finalSelect=request.getParameter("finalSelect");
	if(finalSelect == null) finalSelect="";
	
	String strRoleValue = (request.getParameter("roleValue")==null)?"":request.getParameter("roleValue");

	String strPageAction = (request.getParameter("pageAction")==null)?"":request.getParameter("pageAction");
	String from = request.getParameter("start") ;
    String to = request.getParameter("to") ;
	String totRoleId = request.getParameter("totRoleId");
	if(totRoleId == null) totRoleId="";
	String search_by=request.getParameter("search_by");
	String search_txt=request.getParameter("search_txt");
	if(search_by == null) search_by="";
	if(search_txt == null) search_txt="";

	if(search_by.equals("01"))
	   search_by="PRACTITIONER_ID";
    else if(search_by.equals("02"))
	   search_by="PRACTITIONER_NAME";


	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=0;
        //int i3=1;

          if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }

	//Added on 3/15/2005

	String strClearSession = (String)request.getParameter("clsSessRoleValue");
	if(strClearSession != null && strClearSession.equals("Y"))		
		session.removeValue("roleValue");

	HashMap hmRole=null;
	if(session.getValue("roleValue") == null){
		hmRole = new HashMap();			
	}else{
		hmRole = (HashMap)session.getValue("roleValue");		
	}
	if(strPageAction.equals("N")){
		hmRole.put((start-14)+"_"+(end-14),strRoleValue);
	}else if(strPageAction.equals("P")){
		hmRole.put((start+14)+"_"+(end+14),strRoleValue);
	}
	session.putValue("roleValue",hmRole);

String facility_id = request.getParameter("facilityID");
	if(facility_id == null) facility_id="";

String team_id= request.getParameter("team_id");
if(team_id == null) team_id="";
String speciality_code= request.getParameter("speciality_code");
if(speciality_code == null) speciality_code="";

String sql=" Select practitioner_id, practitioner_name, Practitioner_Role, upper(practitioner_name) from am_pract_for_team_vw where Facility_Id = '"+facility_id+"' and team_id ='"+team_id+"' ";
if(!search_by.equals("") && !search_txt.equals(""))
          sql=sql+"and upper("+search_by+")  like upper('"+search_txt+"%')"; 

sql=sql+" Union  Select Practitioner_Id, Practitioner_Name, 'S', upper(practitioner_name) from am_pract_for_speciality_vw where facility_id ='"+facility_id+"' and speciality_code = '"+speciality_code+"'   ";

if(!search_by.equals("") && !search_txt.equals(""))
          sql=sql+" and upper("+search_by+")  like upper('"+search_txt+"%')"; 

sql=sql+"and  Practitioner_ID not in (Select Practitioner_Id from am_pract_for_team_vw Where Facility_ID ='"+facility_id+"' and team_id ='"+team_id+"') ";

if(!search_by.equals("") && !search_txt.equals(""))
          sql=sql+" and upper("+search_by+")  like upper('"+search_txt+"%')"; 

sql=sql+" Union Select Practitioner_Id, Practitioner_Name Practitioner_Short_Name, 'S' , upper(practitioner_name)from  am_pract_for_facility_vw where operating_facility_id = '"+facility_id+"'  AND Primary_Speciality_code ='"+speciality_code+"'";

if(!search_by.equals("") && !search_txt.equals(""))
          sql=sql+" and upper("+search_by+")  like upper('"+search_txt+"%')"; 

sql=sql+" and Practitioner_ID not in (Select Practitioner_Id from am_pract_for_team_vw  Where 	facility_id ='"+facility_id+"' and Team_ID ='"+team_id+"' ";

if(!search_by.equals("") && !search_txt.equals(""))
          sql=sql+" and upper("+search_by+")  like upper('"+search_txt+"%')"; 

sql=sql+" ) order by 4";

//out.println("sql :"+sql);
		
	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null ;

	try
	{
		con = ConnectionManager.getConnection(request);
		try
		{

		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		
	
		rs.beforeFirst();

		while(rs.next()){
     		String avlChief = rs.getString("PRACTITIONER_ROLE");
			if(avlChief.equals("CHIEF")){
				out.println("<script>parent.frames[0].flag=false;</script>");
	   		}
		}
		rs.beforeFirst();
		}catch(Exception e){}
%>
</head>

<body  OnMouseDown="CodeArrest();"  class='CONTENT' onKeyDown = 'lockKey()'>
<form name='pract_for_team_result' id='pract_for_team_result' action='../../eAM/jsp/md_addModifyPractForTeamResult.jsp' method='post' >
<input type="hidden" name="roleValue" id="roleValue" value=''>
<input type="hidden" name="pageAction" id="pageAction" value="">
	<table border='0' cellpadding='0' cellspacing='0' width='80%' align='center'>
	<tr>
		<td class="white">
			<table border='0' align='right'>
			<tr>
				
					<input type='hidden' name='totRoleId' id='totRoleId' value='<%=totRoleId%>' >
					<input type='hidden' name='finalSelect' id='finalSelect' value='<%=finalSelect%>'>
					<input type='hidden' name='maxRecord' id='maxRecord' value='<%=maxRecord%>'>

					<input type='hidden' name='function_name' id='function_name' value='insert'>

					<input type=hidden name='from' id='from' value='<%=start%>'>
					<input type=hidden name='to' id='to' value='<%=end%>'>
					<input type=hidden name='start' id='start' value='<%=start%>'>
					<input type=hidden name='end' id='end' value='<%=end%>'>
					<input type='hidden' name='team_id' id='team_id' value='<%=team_id%>'>
					<input type='hidden' name='speciality_code' id='speciality_code' value='<%=speciality_code%>'>
					<input type='hidden' name='facilityID' id='facilityID' value="<%=facility_id%>" >
					<input type='hidden' name='search_by' id='search_by' value='<%=search_by%>'>
					<input type='hidden' name='search_txt' id='search_txt' value='<%=search_txt%>'>
					


		<% 
			if (start != 0){
			for(int j=1; j<=start-1; i++,j++){
			rs.next() ;
			}
			}

			int iStartIndex = i;
		
			int iEnd = end;
			if(end == 12)
			iEnd++;
			
			while(rs.next() && i<iEnd){
				if(maxRecord==0)
				{

            if ( !(start <= 1)) {
		%>
				    <td align ='right' id='prev'><a href='javascript:document.forms[0].pageAction.value="P";javascript:submitPrevNext(<%=(start-14)%>,<%=(end-14)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
				    <input type=hidden name='whichPage' id='whichPage' value='prev'>

		<%
		    }
		//    if ( !((start+14) > maxRecord )){
		%>
				    <td align ='right' id='next' style='visibility:hidden'><a href='javascript:document.forms[0].pageAction.value="N";javascript:submitPrevNext(<%=(start+14)%>,<%=(end+14)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
				    <input type=hidden name='whichPage' id='whichPage' value='next'>
		<%
		//    }
		%>
			</tr>
			</table>
		</td>
	</tr>

	<tr>
		<td>
			<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
			<tr>
				<td class='columnheader' width='1%' >&nbsp;</td>
				<td class='columnheader' width='79%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
				<td class='columnheader' width='10%'><fmt:message key="Common.Role.label" bundle="${common_labels}"/></td>
				<td class='columnheader' width='10%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
			</tr>

		<% }
		
		String classValue="";//String chkAttribute="";
		
			if( i%2 == 0)  classValue="QRYEVEN";
			else
			classValue="QRYODD";

		%>
			<tr>
				<td width='1%' class='<%=classValue%>'><a href=javaScript:showPractWindow('<%=rs.getString("Practitioner_ID")%>')>+</a></td>
				
				<td class='<%=classValue%>'><%=rs.getString(2)%></td>
				
				<td  class='<%=classValue%>' align='center'><select name='role<%=i%>' id='role<%=i%>' onChange="parent.frames[0].populateRole(this,chk<%=i%>,'<%=rs.getString("Practitioner_ID")%>')"><option value='S'>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------<option value='C'><fmt:message key="Common.Chief.label" bundle="${common_labels}"/><option value='M'><fmt:message key="Common.Member.label" bundle="${common_labels}"/></select></td>
				<td class='<%=classValue%>' align='center'><input type='checkbox' name='chk<%=i%>' id='chk<%=i%>' onClick="parent.frames[0].finalSelect(this,role<%=i%>,'<%=rs.getString("Practitioner_ID")%>');"></td>
			</tr>
		<%
			out.println("<script>document.forms[0].role"+i+".value='"+rs.getString("Practitioner_Role").substring(0,1)+"'</script>");			
				%>

		<%

		if(rs.getString("Practitioner_Role").substring(0,1).equals("M") || rs.getString("Practitioner_Role").substring(0,1).equals("C"))
			out.println("<script>document.forms[0].chk"+i+".checked=true;</script>");
		i++;
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
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<%}

		if(strPageAction.equals("P") || strPageAction.equals("N")){
			hmRole = (HashMap)session.getValue("roleValue");
			String strParse = (String)hmRole.get(start+"_"+end);
			if(strParse != null){
				StringTokenizer stRoleTokenizer = new StringTokenizer(strParse,"#");		
				String strValue="";
				while(stRoleTokenizer.hasMoreElements()){
					strValue = stRoleTokenizer.nextToken();
					out.println("<script>document.forms[0].role"+ iStartIndex +".value='"+ strValue +"'</script>");
					if(strValue.equals("M") || strValue.equals("C"))
						out.println("<script>document.forms[0].chk"+iStartIndex+".checked=true;</script>");
					iStartIndex++;
				}
			}
		}
        hmRole.clear();

		StringTokenizer stmain=new StringTokenizer(totRoleId,"~");
		int mainTkn=stmain.countTokens();
		for(int k=0;k<mainTkn;k++)
		{
		String st=stmain.nextToken();
		StringTokenizer subTkn=new StringTokenizer(st,"$");
		String role_name=subTkn.nextToken();
		String role_value=subTkn.nextToken();
		out.println("<script>if(document.forms[0]."+role_name+") { document.forms[0]."+role_name+".value='"+role_value+"' }</script>");

		}

			StringTokenizer stmain1=new StringTokenizer(finalSelect,"~");
			int mainTkn1=stmain1.countTokens();
			for(int k1=0;k1<mainTkn1;k1++)
			{
			String st1=stmain1.nextToken();
			StringTokenizer subTkn1=new StringTokenizer(st1,"$");
			subTkn1.nextToken();
			String role_value1=subTkn1.nextToken();
			subTkn1.nextToken();
			String role_name1=subTkn1.nextToken();
			String objname =subTkn1.nextToken();

			//out.println("<script>alert("+role_value1+"); alert("+role_name1+"); alert("+objname+");	</script>");
	
			out.println("<script>if(document.forms[0]."+role_name1+") {document.forms[0]."+role_name1+".value='"+role_value1+"' }</script>");
			out.println("<script>if(document.forms[0]."+objname+"){if(document.forms[0]."+role_name1+".value !='S') document.forms[0]."+objname+".checked=true;else document.forms[0]."+objname+".checked=false; } </script>");

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
	  if(rs!=null)		rs.close();
	  if(stmt!=null)	stmt.close();
	  if(pstmt!=null)	pstmt.close();
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }

		ConnectionManager.returnConnection(con,request);

	  }%>
			</table>
		</td>
	</tr>
	</table>
</form>
</body>
</html>

