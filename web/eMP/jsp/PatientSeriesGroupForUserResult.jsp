<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8" import ="java.sql.Connection,java.sql.Statement,java.sql.*,webbeans.eCommon.*,java.util.HashMap,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script language='javascript' src='../../eMP/js/PatientSeriesGroupForUser.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%
	Connection con=null;
	Statement stmt=null;
	PreparedStatement pstmt = null;
	ResultSet rSet=null;
	String patcode="";
	String shortdesc="";
	String userID="";
	String userName="";
	String patSerGrpCode=request.getParameter("patSerGrpCode")==null?"":request.getParameter("patSerGrpCode");
	String searchuser=request.getParameter("searchuser")==null?"":request.getParameter("searchuser");
	String search_criteria=request.getParameter("search_criteria")==null?"":request.getParameter("search_criteria");
	String linked_yn="";
	int recCount=0;
	int recStart=Integer.parseInt(request.getParameter("recStart")==null?"0":request.getParameter("recStart"));
	int recEnd=Integer.parseInt(request.getParameter("recEnd")==null?"0":request.getParameter("recEnd"));
	recEnd=recEnd+14;
	String classValue		= "";
	HashMap psthashmap		=	new HashMap() ;
	//StringBuffer sqlQuery=new StringBuffer("SELECT a.pat_ser_grp_code, b.appl_user_id,sm_get_desc.sm_appl_user (b.appl_user_id, '"+localeName+"', 1) appl_user_name  FROM mp_pat_ser_grp_for_user a ,sm_appl_user b where a.appl_user_id(+) = b.appl_user_id and a.pat_ser_grp_code(+)='"+patSerGrpCode+"'");
	//StringBuffer sqlQuery=new StringBuffer("SELECT appl_user_id,sm_get_desc.sm_appl_user (appl_user_id, '"+localeName+"', 1)appl_user_name,NVL ((SELECT 'Y' FROM mp_pat_ser_grp_for_user b WHERE b.pat_ser_grp_code = '"+patSerGrpCode+"' AND b.appl_user_id = a.appl_user_id),'N') linked_yn FROM sm_appl_user a");
	StringBuffer sqlQuery=new StringBuffer("SELECT appl_user_id,sm_get_desc.sm_appl_user (appl_user_id, ?, 1)appl_user_name,decode((select count(*) from mp_pat_ser_grp_for_user b WHERE b.pat_ser_grp_code =? AND b.appl_user_id = a.appl_user_id),0,'N','Y')linked_yn FROM sm_appl_user a where EFF_STATUS='E' ");
	if(!searchuser.equals("")){
		if(search_criteria.equals("S")){
			sqlQuery.append(" and (upper(sm_get_desc.sm_appl_user (a.appl_user_id,?, 1)) like upper(?) or appl_user_id like upper(?))");
			psthashmap.put(1,searchuser+"%");
		}else if(search_criteria.equals("C")){
			sqlQuery.append(" and  (upper(sm_get_desc.sm_appl_user (a.appl_user_id, ?, 1)) like upper(?) or appl_user_id like upper(?))");
			psthashmap.put(1,"%"+searchuser+"%");
		}else if(search_criteria.equals("E")){
		        
			/* below lines modified by venkatesh.s against  MO-CRF-20074 [IN:043899] on 06-Aug-2014 */
		     
			sqlQuery.append(" and (upper(sm_get_desc.sm_appl_user (a.appl_user_id, ?, 1)) like upper(?) or appl_user_id like upper(?))");
			psthashmap.put(1,"%"+searchuser);
			  /* end  MO-CRF-20074 [IN:043899] */
			
			/* below line Commented by venkatesh */
			
			//sqlQuery.append(" and upper(sm_get_desc.sm_appl_user (a.appl_user_id, '"+localeName+"', 1)) like upper('%"+searchuser+"') or appl_user_id like upper('%"+searchuser+"')");
		}		
	}	
	sqlQuery.append(" order by appl_user_name");
	try{
		request.setCharacterEncoding("UTF-8");
	    request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
		con = ConnectionManager.getConnection(request);
		//stmt=con.createStatement();
		pstmt = con.prepareStatement(sqlQuery.toString());
		pstmt.setString(1,localeName);
		pstmt.setString(2,patSerGrpCode);
		pstmt.setString(3,localeName);
		if(!searchuser.equals("")){
		pstmt.setString(4,(String) psthashmap.get(1));
		pstmt.setString(5,(String) psthashmap.get(1));
		psthashmap.clear();
		}
		rSet=pstmt.executeQuery();		
%>
<body onLoad="FocusFirstElement()" onKeyDown = 'lockKey()' OnMouseDown="CodeArrest()">
<form name='MPPatSerGrpUserResult' id='MPPatSerGrpUserResult' action="../../eMP/jsp/PatientSeriesGroupForUserResult.jsp" target="messageFrame" method="post">
<%
	if( rSet != null){
		System.out.println("SQL String:"+sqlQuery.toString());
		while(recCount<recEnd && rSet.next()){
			linked_yn="";
			if((recStart<=recCount && recCount<recEnd)){
				if ( recCount % 2 == 0 )
					classValue = "QRYODD";
				else
					classValue = "QRYEVEN";
				userID="";
				linked_yn="";
				userID = rSet.getString("appl_user_id");				
				userName = rSet.getString("appl_user_name");				
				linked_yn = rSet.getString("linked_yn");
				if(recCount==recStart){%>
					<table border="0" width="99%" cellspacing='0' cellpadding='0'>
						<tr>
							<td  id='prev' style='display:none !important' width="100%"><A HREF="#" onClick='submitPrev();' text-decoration='none' style="float:right;"><fmt:message key="Common.previous.label"  bundle="${common_labels}"/></A></td><td>&nbsp;</td>
							<td id='next' style='display:none !important' width="100%"><A HREF="#" onClick='submitNext();' text-decoration='none' style="float:right;"><fmt:message key="Common.next.label"  bundle="${common_labels}"/></A></td>
						</tr>
					</table>
					<table border="1" width="99%" cellspacing='0' cellpadding='0'>
						<th width='35%'><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
						<th width='55%'><fmt:message key="Common.username.label" bundle="${common_labels}"/></td>
						<th width='20%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>	
				<%
				}
				%>
				<tr>
					<td class='<%=classValue%>'><%=userID%></td>
					<td class='<%=classValue%>'><%=userName%></td>
					<%
					if(linked_yn.equals("N")){%>
						<td class='<%=classValue%>' align=center><input type='checkbox' name='user_pat_link<%=recCount%>' id='user_pat_link<%=recCount%>'   onclick='AddRemUsers(this)'/><input type='hidden' name='linkedYN<%=recCount%>' id='linkedYN<%=recCount%>' value='N' ><input type='hidden' name='User<%=recCount%>' id='User<%=recCount%>' value='<%=userID%>' ></td>
					<%}else{%>
						<td class='<%=classValue%>' align=center><input type='checkbox' name='user_pat_link<%=recCount%>' id='user_pat_link<%=recCount%>'   checked  onclick='AddRemUsers(this)'/><input type='hidden' name='linkedYN<%=recCount%>' id='linkedYN<%=recCount%>' value='Y' ><input type='hidden' name='User<%=recCount%>' id='User<%=recCount%>' value='<%=userID%>' ></td>
					<%}%>				
				</tr>
			<%}
			recCount++;
		}
	}
	if(rSet.next()){
		%>
		<script>
			document.getElementById("next").style.display= '';
		</script>
	<%}
	if(recCount >14){%>
		<script>
			document.getElementById("prev").style.display= '';
		</script>
	<%}
	if(recCount ==0){%>
		<script>
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));
			document.location.href="../../eCommon/html/blank.html";
		</script>
	<%}
%>
</table>
	<input type='hidden' name='recStart' id='recStart' value='<%=recStart%>' >
	<input type='hidden' name='recEnd' id='recEnd' value='<%=recEnd%>' >
	<input type='hidden' name='recCount' id='recCount' value='<%=recCount%>' >
	<input type='hidden' name='patSerGrpCode' id='patSerGrpCode' value='<%=patSerGrpCode%>' >
	<input type='hidden' name='searchuser' id='searchuser' value='<%=searchuser%>' >
	<input type='hidden' name='search_criteria' id='search_criteria' value='<%=search_criteria%>' >
	<input type='hidden' name='associateUsers' id='associateUsers' value='' >
	<input type='hidden' name='deAssociateUsers' id='deAssociateUsers' value='' >
	<input type='hidden' name='prevnext' id='prevnext' value='' >
</form>
</body>
<%
	}catch(Exception e){
		//out.println(e);
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174234312 on 31-08-2023
	}finally { 
		ConnectionManager.returnConnection(con,request);
	}
%>
	
</html>

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

