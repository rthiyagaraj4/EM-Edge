<!DOCTYPE html>
<%--
	FileName	: PractForExternalReferralResult.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>



<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eAM/js/PractForExternalReferral.js' language='javascript'></script> 
<script>
	function submitPrevNext(from, to){
	    //document.forms[0].totAssignreassign.value=parent.frames[0].assignReassign; //Commented by suji keerthi for BSP-SCF-0088
	   document.forms[0].effStatus.value=parent.frames[0].effStatus;
	    document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
	    document.forms[0].submit();
	}
</script>
<%
request.setCharacterEncoding("UTF-8");	

	String totAssignreasign="",effStatus="";
	totAssignreasign=request.getParameter("totAssignreassign");
	if(totAssignreasign == null) totAssignreasign="";
	
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
	ResultSet rsap=null;

	String referral_code=request.getParameter("referral_code") ;
	if(referral_code == null) referral_code="";

	String speciality_code =request.getParameter("splty_code") ;
	if(speciality_code == null) speciality_code="";

	String facility_id =request.getParameter("facility_id") ;
	if(facility_id == null) facility_id="";
	
	String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=0;
	int ctr = 0;
        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 13 ; }   else {  end = Integer.parseInt( to ) ; }
	

	String search_by=request.getParameter("search_by");
	String search_txt=request.getParameter("search_txt");
	if(search_by == null) search_by="";
	if(search_txt == null) search_txt="";

	String search_by1="";

	if(search_by.equals("01"))
	   search_by1="PRACTITIONER_ID";
    else if(search_by.equals("02"))
	   search_by1="PRACTITIONER_NAME";

	   
	String primary_specialty = speciality_code;
	if( primary_specialty == null) primary_specialty="";
try{
		
		con = ConnectionManager.getConnection(request);

	//   String practSql=" SELECT practitioner_name, practitioner_id,eff_status FROM am_ext_practitioner WHERE primary_speciality_code =  '"+speciality_code+"' AND eff_status = 'E'  and practitioner_id not in (SELECT a.practitioner_id FROM am_ext_pract_for_referral a, am_ext_practitioner b  WHERE  a.practitioner_id = b.practitioner_id  and a.referral_code = '"+referral_code+"'  AND b.primary_speciality_code =  '"+speciality_code+"') union  SELECT b.practitioner_name, a.practitioner_id, a.eff_status  FROM am_ext_pract_for_referral a, am_ext_practitioner b  WHERE  a.practitioner_id = b.practitioner_id  and a.referral_code = '"+referral_code+"' AND b.primary_speciality_code =  '"+speciality_code+"' order by 2 ";

	  StringBuffer practSql =new StringBuffer();
	  practSql.setLength(0);
	 
	  practSql.append(" SELECT practitioner_name, practitioner_id,eff_status FROM am_ext_practitioner WHERE primary_speciality_code =  '"+speciality_code+"' AND eff_status = 'E'");
  
	  if(!search_by.equals("") && !search_txt.equals(""))
			  practSql.append(" and upper("+search_by1+")  like upper('"+search_txt+"%')"); 
	  
	  practSql.append(" and practitioner_id not in (SELECT a.practitioner_id FROM am_ext_pract_for_referral a, am_ext_practitioner b  WHERE  a.practitioner_id = b.practitioner_id  and a.referral_code = '"+referral_code+"'  AND b.primary_speciality_code =  '"+speciality_code+"'");

	  if(!search_by.equals("") && !search_txt.equals(""))
			  practSql.append(" and upper(b."+search_by1+")  like upper('"+search_txt+"%')"); 
	  
	  practSql.append(" ) union  SELECT b.practitioner_name, a.practitioner_id, a.eff_status  FROM am_ext_pract_for_referral a, am_ext_practitioner b  WHERE  a.practitioner_id = b.practitioner_id  and a.referral_code = '"+referral_code+"' AND b.primary_speciality_code =  '"+speciality_code+"'");
	  
	  if(!search_by.equals("") && !search_txt.equals(""))
			  practSql.append(" and upper(b."+search_by1+")  like upper('"+search_txt+"%')"); 
	  
	  practSql.append(" order by 2 ");

try{
	stmt = con.createStatement();
	rs=stmt.executeQuery(practSql.toString());

	  }catch(Exception e){out.println(e);}
%>

<body  OnMouseDown="CodeArrest();"  class='CONTENT' onKeyDown = 'lockKey()'>
<form name='facility_form_result' id='facility_form_result' action='../../eAM/jsp/PractForExternalReferralResult.jsp' method='post' >
<table border='0' cellpadding='0' cellspacing='0' width='80%' align='center'>
	<tr>
		<td class="white">
			<table border='0' align='right'>
			<tr>
				<td align='right' class='NONURGENT' nowrap><%=space%>
				<input type=hidden name='totAssignreassign' id='totAssignreassign' value='<%=totAssignreasign%>'>
				<input type=hidden name='effStatus' id='effStatus' value='<%=effStatus%>'>
				<input type='hidden' name='finalSelect' id='finalSelect' value=''>
				<input type='hidden' name='finalString' id='finalString' value=''>
				<input type=hidden name=from value='<%=start%>'>
				<input type=hidden name=to value='<%=end%>'>
				<input type=hidden name='start' id='start' value='<%=start%>'>
				<input type=hidden name='end' id='end' value='<%=end%>'>
				<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >
				<input type='hidden' name='primary_specialty' id='primary_specialty' value='<%=primary_specialty%>' >
				<input type='hidden' name='function_name' id='function_name' value='insert'>
				<input type='hidden' name='referral_code' id='referral_code' value='<%=referral_code%>'>
				<input type='hidden' name='pract_id_exists' id='pract_id_exists' value='N'>
				<input type='hidden' name='search_by' id='search_by' value='<%=search_by%>'>
				<input type='hidden' name='search_txt' id='search_txt' value='<%=search_txt%>'>
				<!-- Below added by suji keerthi for BSP-SCF-0088 -->
				<input type='hidden' name='splty_code' id='splty_code' value='<%=speciality_code%>'>
				
                 
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
			 //    if ( !((start+14) >= maxRecord )){
				%>
			    <a href='javascript:submitPrevNext(<%=(start+13)%>,<%=(end+13)%>)' id='next' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
			     <input type=hidden name='whichPage' id='whichPage' value='next'>
				<%
				//}
				%>	
				</td>
			</tr>
		  </table>
        </td>
	</tr>	
					<%
					%>
		<tr>
			<td>	
				<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
					<th class='columnheader' width='60%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
					<th class='columnheader' width='20%' nowrap><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
					<th class='columnheader' width='20%' nowrap><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
					<% }

					String classValue="",practitioner_id2="";
					
					String chkAttribute="",chkAttribute2="";
					String practitioner_id="",practitioner_name="",selectyn="",dummyPractId="";
					
				/*int totApptCount=0;
					String sqlap="select count(1) total from oa_appt  where facility_id = ?  and practitioner_id = ? AND trunc(Appt_date)>=trunc(sysdate) AND APPT_STATUS != 'A' ";
			
					stmtap=con.prepareStatement(sqlap);

					
					temp2=rs.getString("practitioner_id");
			
					stmtap.setString(1,facility_id );
					stmtap.setString(2,temp2 );
					rsap=stmtap.executeQuery();
					if(rsap!=null)
					rsap.next();
					totApptCount = rsap.getInt("total");
					 if(rsap!=null)    rsap.close();
					  if(stmtap!=null)  stmtap.close();*/

					practitioner_id2=rs.getString("practitioner_id");
					dummyPractId=practitioner_id+"1";
					practitioner_name=rs.getString("practitioner_name");
					selectyn = "Y";
			
					if( i%2 == 0)  classValue="QRYEVEN";
					else
						classValue="QRYODD";

					if(rs.getString("eff_status").equals("E"))
						chkAttribute="CHECKED";
					else
						chkAttribute="";

					%>
			<tr>
				<td class='<%=classValue%>'><%=practitioner_name%></td>
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='Enablechk<%=i%>' value='<%=practitioner_id2%>' onClick=''> </td>
				<td align='center' class='<%=classValue%>'><input type='checkbox'  name= 'select<%=i%>' <%=chkAttribute2%> onClick=''> </td>
			</tr>
			<%
			i++;
			ctr++;
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
				
			out.println("<input type=hidden name='count_chk' id='count_chk' value='"+i+"'>"); //Modified by suji keerthi for BSP-SCF-0088
			
           
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
//	}else	{%>
		<!-- <script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common'))</script> -->
			
	<%//}
        	  if(rs!=null)		rs.close();
			  if(rsap!=null)    rsap.close();			  
			  if(stmt!=null)	stmt.close();
			  if(pstmt!=null)	pstmt.close();
			  if(stmtap!=null)  stmtap.close();
		}
		catch(Exception e){out.print(e);}
		finally
			  {
			  ConnectionManager.returnConnection(con,request);
			  }%>
			</table>
		</td>
	</tr>
  </table>
</form>
</body>
</html>

