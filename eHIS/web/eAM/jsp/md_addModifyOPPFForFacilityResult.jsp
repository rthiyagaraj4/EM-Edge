<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <script src='../../eAM/js/OPPForFacility.js' language='javascript'></script>
 <script>

	function changeEnable(Obj,Obj1)
	{
		var arr = new Array();
		arr = Obj1.value.split("$");
		if(Obj.checked)
		{
			arr[1]="Y";
		}
		else
			arr[1]="N";
			Obj1.value=arr[0]+"$"+arr[1]+"$"+arr[2];
	}
	
	async function showPractWindow(practID)
	{
	    var url     = "../../eAM/jsp/ViewPractitionerDtls.jsp?practitioner_id="+practID+"&fcall=call";
	    var dialogHeight    = "70vh" ;
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
		document.forms[0].totAssignreassign.value=parent.frames[0].assignReassign;
		document.forms[0].effStatus.value=parent.frames[0].effStatus;
		document.forms[0].totselected.value=parent.frames[0].selected;
		document.forms[0].finalSelect.value=parent.frames[0].temp;
	    document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
		var search_txt = document.forms[0].search_txt.value;
		var search_by = document.forms[0].search_by.value;
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
	String totAssignreasign="",effStatus="",totselected="",finalSelect="";
	String search_by=request.getParameter("search_by");
	String search_txt=request.getParameter("search_txt");
	totAssignreasign=request.getParameter("totAssignreassign");
	if(totAssignreasign == null) totAssignreasign="";
	if(search_by == null) search_by="";
	if(search_txt == null) search_txt="";
	search_txt = search_txt.replaceAll("\'","\'\'"); //Added for ML-MMOH-SCF-2337 by Ajay H.
	totselected=request.getParameter("totselected");
	if(totselected == null) totselected="";

	finalSelect=request.getParameter("finalSelect");
	if(finalSelect == null) finalSelect="";

	if(search_by.equals("01"))
	   search_by="PRACTITIONER_ID";
    else if(search_by.equals("02"))
	   search_by="PRACTITIONER_NAME";
	
	String space="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	
	effStatus=request.getParameter("effStatus");
	if(effStatus == null) effStatus="";
	
	Connection con = null;
	PreparedStatement pstmt=null;
	PreparedStatement stmtap=null;
	Statement stmt=null;
	ResultSet rs=null ;
	
	String facility_id=request.getParameter("facility_id") ;
	if(facility_id == null) facility_id="";
	String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=0;
        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 14 ; }   else {  end = Integer.parseInt( to ) ; }
	
	
	String primary_specialty=request.getParameter("primary_specialty");
	if( primary_specialty == null) primary_specialty="";
try{
		
		con = ConnectionManager.getConnection(request);
		
		String practSql=" select  practitioner_id, practitioner_name, allow_unassign_in_practq_yn,  eff_status,'N',upper(practitioner_name) from  am_pract_for_facility_vw where  operating_facility_id= '"+facility_id+"' and primary_speciality_code = '"+primary_specialty+"' ";
		
		if(!search_by.equals("") && !search_txt.equals(""))
          practSql=practSql+"and upper("+search_by+")  like upper('"+search_txt+"%')"; 

		practSql=practSql+" union select practitioner_id, practitioner_name, 'Y',eff_status,'N',upper(practitioner_name) from am_practitioner where eff_status='E' and primary_speciality_code = '"+primary_specialty+"'";

		if(!search_by.equals("") && !search_txt.equals(""))
          practSql=practSql+"and upper("+search_by+")  like upper('"+search_txt+"%')"; 

		practSql=practSql+" and practitioner_id   not in ( select practitioner_id from am_pract_for_facility_vw where operating_facility_id ='"+facility_id+"'  and primary_speciality_code ='"+primary_specialty+"'  ";

		if(!search_by.equals("") && !search_txt.equals(""))
          practSql=practSql+"and upper("+search_by+")  like upper('"+search_txt+"%')"; 

		practSql=practSql+" ) order by 1";

		
try{


	stmt=con.createStatement();
	rs=stmt.executeQuery(practSql);
	  }catch(Exception e){
		  //out.println(e);
		  e.printStackTrace();
	  }

	  %>
<body  OnMouseDown="CodeArrest();"  class='CONTENT' onKeyDown = 'lockKey()'>
<form name='facility_form_result' id='facility_form_result' action='../../eAM/jsp/md_addModifyOPPFForFacilityResult.jsp' method='post' >
<table border='0' cellpadding='0' cellspacing='0' width='80%' align='center'>
	<tr>
		<td class="white">
			<table border='0' align='right'>
			<tr>
				<td align='right' class='NONURGENT' nowrap><%=space%>
				<input type=hidden name='totAssignreassign' id='totAssignreassign' value='<%=totAssignreasign%>'>
				<input type=hidden name='effStatus' id='effStatus' value='<%=effStatus%>'>
				<input type=hidden name='totselected' id='totselected' value='<%=totselected%>'>
				<input type='hidden' name='finalSelect' id='finalSelect' value='<%=finalSelect%>'>

				<input type=hidden name=from value='<%=start%>'>
				<input type=hidden name=to value='<%=end%>'>
				<input type=hidden name='start' id='start' value='<%=start%>'>
				<input type=hidden name='end' id='end' value='<%=end%>'>
				<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >
				<input type='hidden' name='primary_specialty' id='primary_specialty' value='<%=primary_specialty%>' >
				<input type='hidden' name='function_name' id='function_name' value='insert'>
				<input type='hidden' name='pract_id_exists' id='pract_id_exists' value='N'>
				<input type='hidden' name='search_by' id='search_by' value='<%=search_by%>'>
				<input type='hidden' name='search_txt' id='search_txt' value='<%=search_txt%>'>

				<%
					if (start != 0){
					    for(int j=1; j<=start; i++,j++){
						rs.next() ;
					     }
				    }

					while(i<end && rs.next()){ 
						if(maxRecord==0)
						{

				    if ( !(start <= 1)) {
				%>
				     <a href='javascript:submitPrevNext(<%=(start-14)%>,<%=(end-14)%>)' id='prev' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
				     <input type=hidden name='whichPage' id='whichPage' value='prev'>
 
				<%
				}
			  //   if ( !((start+14) >= maxRecord )){
				%>
			    <a href='javascript:submitPrevNext(<%=(start+14)%>,<%=(end+14)%>)' id='next' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
			     <input type=hidden name='whichPage' id='whichPage' value='next'>
				<%
			//	}
				%>	
				</td>
			</tr>
		  </table>
        </td>
	</tr>	
		<tr>
			<td>	
				<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
					<th width='1%' >&nbsp;</th>
					<th width='64%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
					<th width='5%' nowrap><fmt:message key="eAM.AssignUnassigned.label" bundle="${am_labels}"/> <br><fmt:message key="Common.patient.label" bundle="${common_labels}"/></th>
					<th width='5%' nowrap><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
					<th width='5%' nowrap><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
					<% }
					String classValue="",temp2="";
					String chkAttribute="",chkAttribute1="",chkAttribute2="";
					String practitioner_id="",practitioner_name="",allow_unassign_in_practq_yn="",eff_status="",selectyn="",dummyPractId="";
					
					temp2=rs.getString("practitioner_id");				

					practitioner_id="ID"+rs.getString("practitioner_id");
					dummyPractId=practitioner_id+"dummypractid";
					practitioner_name=rs.getString("practitioner_name");
					allow_unassign_in_practq_yn=rs.getString("allow_unassign_in_practq_yn");
					eff_status=rs.getString("eff_status");
					selectyn=rs.getString(5);
					selectyn=selectyn.substring(0,1);
			
					if( i%2 == 0)  classValue="QRYEVEN";
					else
						classValue="QRYODD";
					if(rs.getString("eff_status").equals("E"))
						chkAttribute="CHECKED";
					else
						chkAttribute="";
					if(rs.getString(3).equals("Y"))
						chkAttribute1="CHECKED";
					else
						chkAttribute1="";
					%>
			<tr>
				<td width='1%' class='<%=classValue%>'><a href=javaScript:showPractWindow('<%=temp2%>')>+</a></td>
				<td class='<%=classValue%>'><%=practitioner_name%></td>
				<!-- Modified By Dharma on Feb 26th 2015 against ML-BRU-SCF-1541 [IN:053351] Start -->
				<!--
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute1%> name='<%=practitioner_id%>'  onClick='parent.frames[0].chkassignReAssign(this,select<%=i%>)'  value='<%=practitioner_id%>$<%=allow_unassign_in_practq_yn%>$<%=selectyn%>' > </td>
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='<%=dummyPractId%>' onClick='parent.frames[0].chkEnable(this,select<%=i%>);'  value='<%=dummyPractId%>$<%=eff_status%>$<%=selectyn%>'> </td>
				-->
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute1%> name='<%=practitioner_id%>'  onClick='parent.frames[0].chkassignReAssign(this,select<%=i%>);parent.frames[0].finalSelect(select<%=i%>,<%=practitioner_id%>,<%=dummyPractId%>)'  value='<%=practitioner_id%>$<%=allow_unassign_in_practq_yn%>$<%=selectyn%>' > </td>
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='<%=dummyPractId%>' onClick='parent.frames[0].chkEnable(this,select<%=i%>);parent.frames[0].finalSelect(select<%=i%>,<%=practitioner_id%>,<%=dummyPractId%>)'  value='<%=dummyPractId%>$<%=eff_status%>$<%=selectyn%>'> </td>
				<!-- Modified By Dharma on Feb 26th 2015 against ML-BRU-SCF-1541 [IN:053351] End -->
				<td align='center' class='<%=classValue%>'><input type='checkbox'  name= 'select<%=i%>' <%=chkAttribute2%> onClick="parent.frames[0].finalSelect(this,<%=practitioner_id%>,<%=dummyPractId%>)"  value='<%=practitioner_id%>$<%=eff_status%>$<%=selectyn%>$<%=i%>'> </td>
			</tr>
			<%
					
			i++;
			maxRecord++;
			}//end of while		

			if(maxRecord == 0)
			{%>
				<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>
			<%}

			if ( maxRecord < 14 || (!rs.next()) ) {
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
			
			StringTokenizer st=new StringTokenizer(totAssignreasign,"~");
			int temp=st.countTokens();
			for(int u2=0;u2<temp;u2++)
			{
			String st2=st.nextToken();
			StringTokenizer st1=new StringTokenizer(st2,"$");
			String practId=st1.nextToken();
			String asisignYN=st1.nextToken();
				if(asisignYN.equals("Y"))
					out.println("<script>if(document.forms[0]."+practId+") document.forms[0]."+practId+".checked=true;</script>");
				else
					out.println("<script>if(document.forms[0]."+practId+") document.forms[0]."+practId+".checked=false;</script>");
					
			}
			
			
			StringTokenizer steff=new StringTokenizer(effStatus,"~");
			int temp1=steff.countTokens();
			for(int u3=0;u3<temp1;u3++)
			{
			String st4=steff.nextToken();
			StringTokenizer st5=new StringTokenizer(st4,"$");
			String practname=st5.nextToken(); 
			String status=st5.nextToken(); 
			if(status.equals("E"))
			out.println("<script>if(document.forms[0]."+practname+") document.forms[0]."+practname+".checked=true;</script>");
			else
			out.println("<script>if(document.forms[0]."+practname+") document.forms[0]."+practname+".checked=false;</script>");

			}

			//out.println("totselected :"+totselected);
			StringTokenizer sel=new StringTokenizer(totselected,"~");
			int temp3=sel.countTokens();
			for(int u4=0;u4<temp3;u4++)
			{
			String st6=sel.nextToken();
			StringTokenizer st7=new StringTokenizer(st6,"$");
			st7.nextToken(); 
			String sel1=st7.nextToken();
			st7.nextToken(); 
			String s=st7.nextToken();
			//out.println("s :"+s);
			//out.println("<script>alert('into');</script>"); 
			if(sel1.equals("Y"))
			out.println("<script> if(document.forms[0].select"+s+") document.forms[0].select"+s+".checked=true;</script>");
			else
			out.println("<script>if(document.forms[0].select"+s+") document.forms[0].select"+s+".checked=false;</script>");
			}

			%>
				
		<%	 }
			  catch(Exception e){
				  //out.print(e);
				  e.printStackTrace();
				  }
			  finally
			  {
			  if(rs!=null)		rs.close();
			  			  
			  if(stmt!=null)	stmt.close();
			  if(pstmt!=null)	pstmt.close();
			  if(stmtap!=null)  stmtap.close();
			  ConnectionManager.returnConnection(con,request);
			  }%>
			</table>
		</td>
	</tr>
  </table>
</form>
</body>
</html>

