<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
    request.setCharacterEncoding("UTF-8");
	Connection con=null;
	Statement stmt3=null;
	Statement stmt=null;

	String classValue="";
	try{
	con = ConnectionManager.getConnection(request);
	

	String respID="";
    String respons="";
	String param="";
	String param1="";
	String order="";
	String faci="";
	respID=request.getParameter("respID");

	order=request.getParameter("order");
	faci=request.getParameter("faci");
	

	if(order == null || order.equals("null")) 
	order="";
	param=request.getParameter("param");
    if(param == null || param.equals("null")) 
	param="";
param1 = param;
 if(order.equals(""))
		{
		param=param+"%";
		}
		else if(order.equals("S"))
		{
		param=param+"%";
		}
		else if(order.equals("E"))
		{
		param="%"+param;
		}
		else if(order.equals("C"))
		{
		param="%"+param+'%';
		}
	
	
	String from = request.getParameter("from") ;
	String to = request.getParameter("to") ;
	int start = 0 ;
	int end = 0 ;
	int i=1;
        if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 11 ; }   else {  end = Integer.parseInt( to ) ; }
        
        String chkAttribute="";

			%>
       

       <%// }
    i = 1 ;
    ResultSet rset=null ;
	ResultSet rset1=null ;	
	stmt=con.createStatement();

%>

<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src='../../eCommon/js/showModalDialog.js' language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eSM/js/FacilityforResponsibility.js' language='javascript'></SCRIPT>
	<script>
	function submitPrevNext(from,to,param,order){
	    /*document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
		document.forms[0].param.value =param; 
		document.forms[0].order.value =order; */
		//var respID = document.forms[0].respID.value;
		//var faci = document.forms[0].faci.value;
		//var param1 = document.forms[0].param1.value;
		effected_records1(from,to);
		//alert("effected_records1(from,to)"+effected_records1(from,to));
	}
	
	async function getComments(Obj,comments)
	{
		var url		= "../../eSM/jsp/GetComments.jsp";
		var dialogTop	= "270";
		var dialogHeight= "9" ; 
		var dialogWidth	= "24" ;	
		var dialogLeft	= "300" ;
		var arguments	= eval("document.forms[0]."+comments).value ;
		if(arguments == null) arguments="";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no; dialogLeft: "+dialogLeft ;
		var returnval = await window.showModalDialog( url, arguments, features ) ;	
		if(returnval == null) returnval="";
		eval("document.forms[0]."+comments).value = returnval;
	}
	
</script>
</head>
<body  onLoad="FocusFirstElement()"; OnMouseDown="CodeArrest()"; onKeyDown = 'lockKey()';>
<form name='responsibility_form' id='responsibility_form' action='../../eSM/jsp/FacilityforResponsibilityDetail.jsp' method='post' >
<%	
	String commentVal="";
	if(!(faci.equals("fac")))
			
	//rset=stmt.executeQuery("select facility_name,facility_id from sm_facility_param  where upper(facility_name) like upper('"+param+"') order by facility_name");
	rset=stmt.executeQuery("Select FACILITY_NAME,FACILITY_ID,  REMARKS, upd_ind from ( Select FACILITY_ID, FACILITY_NAME, REMARKS, 'Y' upd_ind from  SM_FACILITY_FOR_RESP_VW where RESP_ID = '"+respID+"'  UNION  Select FACILITY_ID, FACILITY_NAME, '' REMARAKS, 'N' upd_ind from  sm_facility_param WHERE STATUS='E' and FACILITY_ID not in (Select FACILITY_ID FROM SM_FACILITY_FOR_RESP WHERE RESP_ID = '"+respID+"') ) where upper(FACILITY_NAME) like upper('"+param+"') order by  upper (FACILITY_NAME)");
	else
		{
		if(rset!=null) rset.close();
		//rset=stmt.executeQuery("Select resp_name,resp_id from sm_resp where  eff_status='E' and ( (trunc(eff_date_from) <= trunc(sysdate) and trunc(eff_date_to) >=  trunc(sysdate) )  or (trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and  eff_date_from is null)  or (eff_date_from is null and eff_date_to is null))and upper(resp_name) like upper('"+param+"') order by upper(resp_name)");
		rset=stmt.executeQuery("Select RESP_NAME,RESP_ID,  REMARKS, upd_ind from ( Select RESP_ID, RESP_NAME, REMARKS, 'Y' upd_ind from SM_FACILITY_FOR_RESP_VW where FACILITY_ID = '"+respID+"'  UNION  Select RESP_ID, RESP_NAME, '' REMARAKS, 'N' upd_ind from  SM_RESP WHERE EFF_STATUS='E' AND NVL(EFF_DATE_TO, SYSDATE) >= SYSDATE and RESP_ID not in (Select RESP_ID FROM SM_FACILITY_FOR_RESP WHERE FACILITY_ID = '"+respID+"') )  where upper(RESP_NAME) like upper('"+param+"')  order by  upper (RESP_NAME)");
		}


	if(rset!=null)
	{
		if ( start != 0 )
		{
		 for( int k=1; k<start; i++,k++ ){
		  rset.next() ;
		  }
		}

		 String facility_id="";
		 String upd_ind="";
		 String upd_ind1="";
		 int cnt=0;
		 while(rset.next() && i<=end )
		 {
			 if(cnt==0)
			 {%>
				 <p>	
				<table align='right'>
				
				<tr>
				
			<%
				if ( !(start <= 1)) {
			%>
				<td align ='right' id='prev' name='prev'><a href='javascript:submitPrevNext(<%=(start-11)%>,<%=(end-11)%>,"<%=param%>","<%=order%>")' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
				
			
			<%
				}
			%>
				<td align ='right' id='next' name='next' style='visibility:hidden'><a href='javascript:submitPrevNext(<%=(start+11)%>,<%=(end+11)%>,"<%=param%>","<%=order%>")' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
		
			
			</tr>
			</table>
				<br><br>

		<table border='1' cellpadding='0' cellspacing='0'  width='100%'>
			
		<%if(!(faci.equals("fac"))){%>
		<th width='80%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></th>
		<th width='15%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
		<th width='5%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
		<%}else{%>
		<th width='80%'><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></th>
		<th width='15%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
		<th width='5%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>

		<%}
			 }
			
			facility_id = rset.getString(2);
			upd_ind= rset.getString("upd_ind");
			commentVal= rset.getString("remarks");

			if(commentVal == null)
				commentVal = "";

			if(upd_ind.equals("Y"))
			 {
				chkAttribute="checked";
				upd_ind1="true";
			 }
			 else
			 {
				 chkAttribute= "";
				 upd_ind1="false";
			 }

			if((i%2) == 1)
				classValue = "QRYODD";
			else
				classValue ="QRYEVEN";
			%>
			    <tr>       
				<td class='<%=classValue%>' ><%=rset.getString(1)%></td>
				<td class='<%=classValue%>' ><input type='hidden' name='comments<%=i%>' id='comments<%=i%>' value='<%=commentVal%>'><input type='hidden' name='db_comments<%=i%>' id='db_comments<%=i%>' value='<%=commentVal%>'><a href=javaScript:getComments(this,'comments<%=i%>')><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>
				<td align='center' class='<%=classValue%>' ><input type='checkbox' <%=chkAttribute%> name='facilityID<%=i%>' id='facilityID<%=i%>'  value='<%=facility_id%>' ><input type='hidden' name='db_val<%=i%>' id='db_val<%=i%>' value='<%=upd_ind1%>'></td>
			</tr>

			<%
			i++;
			cnt++;
		}

		if (cnt==0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
		boolean flag = false;
		if ( cnt < 10 || (!rset.next()) ) {
		%>
			<script >
			if (document.getElementById('next'))
				document.getElementById('next').style.visibility='hidden';
			</script>
		<% flag = true;
				} else {%>
			<script >
			if (document.getElementById('next'))
				document.getElementById('next').style.visibility='visible';
			</script>





		<%}
	}
	if(rset!=null)rset.close();
	
	//}
	%>	
	</table>
		<input type='hidden' name='from' id='from' value='<%=start%>'>
	    <input type='hidden' name='order' id='order' value='<%=order%>'>
		<input type='hidden' name='to' id='to' value='<%=end%>'>
	    <input type='hidden' name='param' id='param' value='<%=param%>'>
	    <input type='hidden' name='param1' id='param1' value='<%=param1%>'>
		<input type='hidden' name='start' id='start' value='<%=start%>'>
		<input type='hidden' name='end' id='end' value='<%=end%>'>
		<input type='hidden' name='respID' id='respID' value="<%=respID%>" >
		<input type='hidden' name='responce' id='responce' value="<%=respons%>" >	
		<input type='hidden' name='faci' id='faci' value="<%=faci%>" >
		<input type='hidden' name='insert_vals' id='insert_vals' value="" >
		<input type='hidden' name='update_vals' id='update_vals' value="" >
		<input type='hidden' name='delete_vals' id='delete_vals' value="" >
	</form>
	</body>
</html>
<%	
	if(rset1!=null) rset1.close();
	if(stmt!=null) stmt.close();
	if(stmt3!=null) stmt3.close();
	
	}catch(Exception e)
		{
		out.println(e);
		e.printStackTrace();
		}
	finally 
		{					
		ConnectionManager.returnConnection(con,request);
	
		}	
	%>

