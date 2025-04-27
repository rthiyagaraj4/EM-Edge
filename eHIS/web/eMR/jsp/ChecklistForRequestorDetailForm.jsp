<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%

	String redOnly = "";
	String diffinDate = "0";
	String disableFld = "";
	String upd_ind1 = "";
	 int cnt=0;
	Connection con=null;
	Statement stmt3=null;
	Statement stmt=null;
	ResultSet rset=null;
	ResultSet rset1=null;

	String classValue="";
	try{
		 request.setCharacterEncoding("UTF-8");
		con = ConnectionManager.getConnection(request);
		String userID="";
		
		String searchchklist="";
		String searchcriteria="";
		String whereclause="";
	
		
		String count=request.getParameter("count");
		if(count==null) count="2";
		
		int chk_count = 0;
		String from = request.getParameter("from") ;
		String to = request.getParameter("to") ;
		userID=request.getParameter("userID"); 
		
		String tableheader = "";
		searchchklist=request.getParameter("searchchklist")==null?"":request.getParameter("searchchklist");
		String scode = searchchklist.toUpperCase();
		
			searchcriteria=request.getParameter("searchcriteria");
			
			if(searchcriteria.equals("S"))
			whereclause = "upper(LONG_DESC) like upper('"+scode+"%') ";
			if(searchcriteria.equals("E"))
			whereclause = "upper(LONG_DESC) like upper('%"+scode+"') ";
			if(searchcriteria.equals("C"))
			whereclause = "upper(LONG_DESC) like upper('%"+scode+"%') ";
			tableheader = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CheckListName.label","mr_labels");
		
		int chk_list_count=0,chk_list_count_dum=0;
		 chk_list_count =  eMR.MRCommonBean.getChecklistCount(con,userID);	
		 chk_list_count_dum = chk_list_count;
		
		String chk_list_count11=request.getParameter("chk_list_count")==null?"0":request.getParameter("chk_list_count");
		int chk_list_count12 = Integer.parseInt(chk_list_count11);
		
		if (chk_list_count12 != 0) chk_list_count = chk_list_count12;
			
		
		
	
		int start = 0 ;
		int end = 0 ;
		int i=1;
			if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
			if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }
			String chkAttribute="";
			
			SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
			
	
		   %>
			<%
			i = 1 ;
		stmt=con.createStatement();
		if(rset1!=null) rset1.close();
		if(stmt!=null) stmt.close();
	%>
	<head>
	<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<Script src="../../eMR/js/ChecklistForRequestor.js" language="JavaScript"></Script>
    <script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
	
	<script>


		

	function submitPrevNext(from, to)
	{
			
			effected_records1(from,to);
			
	}
	var flag=1;	
		
	
	


	
	</script>
	</head>
	<body  onKeyDown = 'lockKey();'  OnMouseDown="CodeArrest()">
	<form name='checklist_requestor_form' id='checklist_requestor_form' action='../../eMR/jsp/ChecklistForRequestorDetailForm.jsp' method='post' >
		<p>	
		<center><table  align='center' id='titletb' width="70%" >
		
		<tr align ='right' >
		<%
			if ( !(start <= 1)) {
		%>
			<td  id='prev' width="67%" align ='right' ><a  href='javascript:submitPrevNext(<%=(start-10)%>,<%=(end-10)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
		
		<%
			}
	//		if ( !((start+10) > maxRecord )){
		%>
			<td  id='next' style='visibility:hidden' width="3%" align ='right'  ><a  href='javascript:submitPrevNext(<%=(start+10)%>,<%=(end+10)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>

		<%
		//	}
		%>
		
		</tr>
		</table></center>
		<br>
		<br>

	<center><table border='1' cellpadding='0' cellspacing='0' id='titletb1' width="70%">
	<th width='55%'  ><%=tableheader%> </th>

	<th width='5%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
	<%
		String resp_id="";
		
		 
		
		
		String sqlUser ="select * from ((select A.CHK_LIST_CODE code,a.LONG_DESC description,'Y' check_indicator from chk_list_medical_report a, mr_chklist_for_requestor b where B.CHK_LIST_CODE = A.chk_list_code and b.REQUESTOR_ID ='"+userID+"' and "+whereclause+"  ) UNION (select A.CHK_LIST_CODE code,a.LONG_DESC description,'N' check_indicator from chk_list_medical_report a where a.CHK_LIST_CODE not in (select A.CHK_LIST_CODE from chk_list_medical_report a, mr_chklist_for_requestor b where B.CHK_LIST_CODE = A.chk_list_code and b.REQUESTOR_ID = '"+userID+"'  ) and "+whereclause+" )) order by 1 ";
		
		
		stmt = con.createStatement();
		rset=stmt.executeQuery(sqlUser);
		if(rset!=null)
		{
			if ( start != 0 )
			{
			 for( int j=1; j<start; i++,j++ ){
			  rset.next() ;
			  }
			}

			
			 while(i<=end && rset.next())
			 {
				resp_id = rset.getString("code");
				
			


			String upd_ind = rset.getString("check_indicator");
			if(upd_ind.equals("Y"))
			 {
				chkAttribute = "CHECKED";
				upd_ind1="true";
				
			 }
			 else
			 {
				chkAttribute = "";
				upd_ind1="false";
			 }
			
					
				if((i%2) == 1)
					classValue = "QRYODD";
				else
					classValue ="QRYEVEN";
				%>
				
				<tr>

					<td class='<%=classValue%>' ><%=rset.getString("description")%></td>
					
					
				
					<td align='center' class='<%=classValue%>' ><input type='checkbox' <%=chkAttribute%> id='respID<%=i%>' name='respID<%=i%>'  value='<%=resp_id%>' onClick='change_count(this)' ><input type='hidden'  name='db_respID<%=i%>' id='db_respID<%=i%>'  value='<%=upd_ind1%>' ></td>
				</tr>
						<%
				i++;
				cnt++;
			}
			
%>
</table></center>
<%	
			if (cnt==0)
			{
				out.println("<script>document.getElementById(\"titletb\").style.visibility='hidden';document.getElementById(\"titletb1\").style.visibility='hidden';alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				
			}
			boolean flag = false;
			if ( cnt < 10 || (!rset.next()) ) {
			%>
				<script >
				if (document.getElementById("next"))
					document.getElementById("next").style.visibility='hidden';
				</script>
			<% flag = true;
					} else {%>
				<script >
				if (document.getElementById("next"))
					document.getElementById("next").style.visibility='visible';
				</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



			<%}
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
		}
	 

			 
			
%>

		
			<input type='hidden' name='from' id='from' value='<%=start%>'>
			<input type='hidden' name='to' id='to' value='<%=end%>'>
			<input type='hidden' name='start' id='start' value='<%=start%>'>
			<input type='hidden' name='end' id='end' value='<%=end%>'>
			<input type='hidden' name='userID' id='userID' value="<%=userID%>" >
			<input type='hidden' name='count' id='count' value="<%=count%>" >
			<input type='hidden' name='searchchklist' id='searchchklist' value="<%=searchchklist%>" >
			<input type='hidden' name='scode' id='scode' value="<%=scode%>" >
			<input type='hidden' name='searchcriteria' id='searchcriteria' value="<%=searchcriteria%>" >
			<input type='hidden' name='function_name' id='function_name' value=''>
			<input type='hidden' name='insert_vals' id='insert_vals' value="" >
			<input type='hidden' name='delete_vals' id='delete_vals' value="" >
			<input type='hidden' name='chk_list_count' id='chk_list_count' value="<%=chk_list_count%>"  > 
			<input type='hidden' name='chk_list_count_dummy' id='chk_list_count_dummy' value="<%=chk_list_count_dum%>"  >
			
	<%	}catch(Exception e){
			// System.out.println(e);
			e.printStackTrace();
		}
		finally {
			if(stmt!=null) stmt.close();
			if(stmt3!=null) stmt3.close();
			ConnectionManager.returnConnection(con,request);
		}	
	%>
	</form>
	</body>
</html>

