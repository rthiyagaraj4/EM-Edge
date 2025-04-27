<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Sreelatha
*	Created On		:	10 Jan 2005

--%>

<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");


String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eRS.* " contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="LocationWorkplace" class="webbeans.eCommon.RecordSet" scope="session"/> 

<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<!-- <script src='../../eCommon/js/messages.js' language='javascript'></script> -->
<script src='../../eCommon/js/MstCodeCommon.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<!-- <script src="../js/RSMessages.js" language="JavaScript" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
<script>
       
	function submitPrevNext(from, to){
	    document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
	    document.forms[0].submit();
	}

	function selectAll(Obj,start,end){
		
		if(Obj.checked){
			for(var i=start;i<=end;i++){
				if(eval("document.forms[0].chk"+i))
				eval("document.forms[0].chk"+i).checked=true;
			}
			/*var facility_id = document.forms[0].facility_id.value;
			var workplace_code = document.forms[0].workplace_code.value;
			var location_type= document.forms[0].locn_code.value;

			var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='LocnForWorkplaceDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='facility_id' id='facility_id' value='"+facility_id+"'><input type='hidden' name='workplace_code' id='workplace_code' value='"+workplace_code+"'><input type='hidden' name='location_type' id='location_type' value='"+location_type+"'> </form></BODY></HTML>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.form1.submit();  */
		}
		else{
			
			for(var i=start;i<=end;i++){
				if(eval("document.forms[0].chk"+i))
				eval("document.forms[0].chk"+i).checked=false;
			}
			/*var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='LocnForWorkplaceDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";
			parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[2].document.form1.submit();	 */
		}
	}

	function chkForSelectAll(start,end){
			if(parent.frames[2].document.forms[0].E.value == 'selectAll'){
			document.forms[0].chkAll.checked=true;
			selectAll(document.forms[0].chkAll,start,end)
		}
	}
</script>
<%
		String  req_start   =   "", req_end     =   "";
	
        String  checkedOnes         =   "";
        String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;

        int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

        if(from == null)
			start = 0 ;
		else 
			start = Integer.parseInt( from );

        if(to == null)
			end = 12;
		else
			end = Integer.parseInt( to );
       
		req_start = (request.getParameter("start")==null)?"0": request.getParameter("start");
		req_end =(request.getParameter("end")==null)?"0":request.getParameter("end");

		PreparedStatement pstmt3 = null;
		ResultSet rstlRs3 = null;

		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null ;
		boolean chkAll=true;
		try
		{
			con = ConnectionManager.getConnection(request);
			String workplace_code=request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
			String facility_id=request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
			String location_type=request.getParameter("locn_code")==null?"":request.getParameter("locn_code");
			String flagSelect = request.getParameter("fromSearch")==null?"":request.getParameter("fromSearch");

	        if(!flagSelect.equals("") ){
				LocationWorkplace.clearAll();
				 String sqlinsVals= "select locn_code from rs_locn_for_workplace where workplace_code=? and facility_id=? and locn_type=?";
				 pstmt3=con.prepareStatement(sqlinsVals);
				 pstmt3.setString(1,workplace_code);
				 pstmt3.setString(2,facility_id);
				 pstmt3.setString(3,location_type);
				 rstlRs3 = pstmt3.executeQuery();
				// out.println("workplace_code------|" +workplace_code+ "|--------location_type--------|" +location_type);
				if(rstlRs3 !=null){
					
					while(rstlRs3.next()){
						
						LocationWorkplace.putObject(rstlRs3.getString(1));
					 }
				}
	        }

             if(from != null && to != null){
				 int j=0;
				 for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++){
					 if(request.getParameter("chk"+(i)) != null){
						 checkedOnes = request.getParameter("chk"+(i));
						 if(!(LocationWorkplace.containsObject(checkedOnes)))
							 LocationWorkplace.putObject(checkedOnes);
						 j++;
					 }
				}
                out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
            }
			i = 1 ;
     
			String classValue="";
			String chkAttribute="";
			
			//String sql="select locn_code,locn_desc, 'I' db_action  from rs_locn_vw  where facility_id = ? and locn_type =? and (facility_id,locn_code,locn_type) not in(select facility_id,locn_code,locn_type from rs_locn_for_workplace where facility_id =? and workplace_code = ? ) union all select a.locn_code, b.locn_desc, 'U' db_action   from rs_locn_for_workplace a, rs_locn_vw b  where a.facility_id = ?  and a.workplace_code = ?  and a.locn_type = ?   and b.facility_id = a.facility_id   and b.locn_type = a.locn_type  and b.locn_code = a.locn_code  order by 2";
			String sql="SELECT locn_code,locn_desc, 'I' db_action  FROM rs_locn_vw  WHERE facility_id = ? AND locn_type =? AND (facility_id,locn_code,locn_type) NOT IN(SELECT facility_id,locn_code,locn_type FROM rs_locn_for_workplace WHERE facility_id =? AND workplace_code = ? ) AND LANGUAGE_ID = ? UNION ALL SELECT a.locn_code, b.locn_desc, 'U' db_action   FROM rs_locn_for_workplace a, rs_locn_vw b  WHERE a.facility_id = ?  AND a.workplace_code = ?  AND a.locn_type = ?   AND b.facility_id = a.facility_id   AND b.locn_type = a.locn_type  AND b.locn_code = a.locn_code AND B.LANGUAGE_ID = ? ORDER BY 2";
			
			try{
				pstmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,location_type);
				pstmt.setString(3,facility_id);
				pstmt.setString(4,workplace_code);
				pstmt.setString(5,locale);
				pstmt.setString(6,facility_id);
				pstmt.setString(7,workplace_code);
				pstmt.setString(8,location_type);
				
				pstmt.setString(9,locale);

				rs=pstmt.executeQuery();
				//out.println("workplace_code------|" +workplace_code+ "|--------location_type--------|" +location_type);
				//out.println("workplace_code------|" +workplace_code+ "|--------location_type--------|" +location_type);
				
				rs.last();
				maxRecord = rs.getRow();
				rs.beforeFirst();
				//out.println("maxRecord---->" +maxRecord);
				if(maxRecord == 0)                   //modified for getting no records msg dt:8/7/08 
		{
			%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);
	</script>
	<%
		}


				
				
			}
			catch(Exception e){
				e.printStackTrace() ;
				throw e ;
			}
%>
			<body  OnMouseDown="CodeArrest();" onLoad='chkForSelectAll(<%=start%>,<%=end%>)' class='CONTENT' >
			<form name='facility_form_result' id='facility_form_result' action='../../eRS/jsp/LocnForWorkplaceNoteDetail.jsp' method='post' >

			<table  width='90%' border=0 align='center'>
			<tr>
			<td align='right' class='NONURGENT'>
			<input type=hidden name='workplace_code' id='workplace_code' value='<%=workplace_code%>'>
			<input type=hidden name='locn_code' id='locn_code' value='<%=location_type%>'>
			<input type=hidden name='facility_id' id='facility_id' value='<%=facility_id%>'>
			<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>

			<input type=hidden name='from' id='from' value='<%=start%>'>
			<input type=hidden name='to' id='to' value='<%=end%>'>
			<input type=hidden name='start' id='start' value='<%=start%>'>
			<input type=hidden name='end' id='end' value='<%=end%>'>
			<input type='hidden' name='function_name' id='function_name' value='insert'>
			<input type='hidden' name='allValues' id='allValues' value=''>
<%
			if ( !(start<=1)) {
%>
				

				<a href='javascript:submitPrevNext(<%=(start-12)%>,<%=(end-12)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
				<input type=hidden name='whichPage' id='whichPage' value='prev'>
<%
			}
			if ( !((start+12) >= maxRecord )){
%>
				<a href='javascript:submitPrevNext(<%=(start+12)%>,<%=(end+12)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
				<input type=hidden name='whichPage' id='whichPage' value='next'>
<%
			}
%>
			</td>
			</tr>
		</table>
		<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
			<th width='60%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
			<th width='20%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/><br><input type='checkbox' name='chkAll' id='chkAll' onClick='selectAll(this,<%=start%>,<%=end%>)'></th>
<%	 
		if (start != 0){
			for(int j=1; j<=start; i++,j++){
				rs.next() ;
			}
		}
		while(rs.next() && i<=end){ 
			String locn_code=rs.getString("locn_code");
						
			String locn_desc=rs.getString("locn_desc");
			//out.println("locn_code-----235|" +locn_code+ "|------------locn_desc------236|" +locn_desc);
			if(LocationWorkplace.containsObject(locn_code)){
				chkAttribute = "CHECKED";
			}
			else{
				chkAttribute="";
				chkAll=false;
			}
			int recordIndex = LocationWorkplace.indexOfObject(locn_code);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED"))    
				LocationWorkplace.removeObject(recordIndex);

			if( i%2 == 0)  
				classValue="QRYEVEN";
			else
				classValue="QRYODD";
%>
			<tr>
				<td class='<%=classValue%>'><%=locn_desc%></td>
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>'  value='<%=locn_code%>'> </td>
			</tr>
<%
			i++;
		}		
	 }
	 catch(Exception e){
		e.printStackTrace() ;
		throw e ;
	}
	finally{
		if(rs != null)
			rs.close();
		if(rstlRs3 != null)
			rstlRs3.close();
		if(pstmt != null)
			pstmt.close();
		if(pstmt3 != null)
			pstmt3.close();
		ConnectionManager.returnConnection(con,request);
		session.setAttribute("LocationWorkplace", LocationWorkplace);
	}
%>
</table>
</form>
</body>
<script>
<%
		if(chkAll){
%>
			document.facility_form_result.chkAll.checked=true;
			document.facility_form_result.chkAll.value="Y";
<%
		}else{
%>
			document.facility_form_result.chkAll.checked=false;
			document.facility_form_result.chkAll.value="N";
<%
		}
%>
	</script>
</html>

