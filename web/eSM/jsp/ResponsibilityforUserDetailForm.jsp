<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String old_eff_date_from="";
   	String old_eff_date_to="";
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
		String objname="";
		String searchresp="";
		String searchcriteria="";
		String whereclause="";
		String imagesrc="";
		String sorting=request.getParameter("sorting");
		if(sorting==null) sorting="";
		String count=request.getParameter("count");
		if(count==null) count="2";
		if(count.equals("2"))
			imagesrc = "../../eSM/images/Ascending.gif";
		else
			imagesrc = "../../eSM/images/Descending.gif";
		String from = request.getParameter("from") ;
		String to = request.getParameter("to") ;
		userID=request.getParameter("userID"); 
		objname=request.getParameter("objname");
		String tableheader = "";
		searchresp=request.getParameter("searchresp")==null?"":request.getParameter("searchresp");
		String scode = searchresp.toUpperCase();
		if(objname.equals("User"))
		{
			searchcriteria=request.getParameter("searchcriteria");
			
			if(searchcriteria.equals("S"))
			whereclause = "upper(resp_name) like upper('"+scode+"%') ";
			if(searchcriteria.equals("E"))
			whereclause = "upper(resp_name) like upper('%"+scode+"') ";
			if(searchcriteria.equals("C"))
			whereclause = "upper(resp_name) like upper('%"+scode+"%') ";
			tableheader = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityName.label","common_labels");
		}
		else if(objname.equals("Resp"))
		{
			searchcriteria=request.getParameter("searchcriteria");
			//out.println(scode);
			if(searchcriteria.equals("S"))
			whereclause = "upper(appl_user_name) like upper('"+scode+"%') ";
			if(searchcriteria.equals("E"))
			whereclause = "upper(appl_user_name) like upper('%"+scode+"') ";
			if(searchcriteria.equals("C"))
			whereclause = "upper(appl_user_name) like upper('%"+scode+"%') ";
			tableheader = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels");
		}
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
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<Script src="../../eSM/js/ResponsibilityforUser.js" language="JavaScript"></Script>
    <script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
    
	
	<script>


		function validate_date(to_date,from_date)
        {
			if(from_date.value&&to_date.value){
			
 			if(!(isBefore(from_date.value,to_date.value,"DMY",localeName)))
			{
				alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'));
				to_date.select();
			}
		}
         }


		 function validate_date1(from_date,to_date)
			{
			
				if(to_date.value != '' && from_date.value!='')
				{
				if(!(isBefore(from_date.value,to_date.value,"DMY",localeName)))
				{
					alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'));
					to_date.select();
				}
				}
			}

	function submitPrevNext(from, to)
	{
			/*document.forms[0].from.value = from;
			document.forms[0].to.value = to; 
			document.forms[0].submit();*/
			effected_records1(from,to);
	}
	var flag=1;	
		function DateValidation(obj,oldFromDt,index)
		{
				if(validDateObj(obj,"DMY",localeName))
				{
				Obj2=eval("document.forms[0]."+oldFromDt)
				// Added on 3/23/2005 to avoid the "Date Cannot be blank" alert when the user tries to delete the From Date field when the select box is unchecked for the existing records.
				var selectCB = eval("document.forms[0].respID" + index);					
				if(selectCB.checked && Obj2.value.length>0 && obj.value.length == 0)
					{
				
					flag=0;
					}
				else{
				curdate = document.forms[0].cur_date;
				var msg = getMessage("FROM_DATE_LESS_SYSDATE",'SM');
				if(!(isAfterNow(obj.value,"DMY",localeName)))
				{
					obj.focus();
					obj.select();
					alert(msg);
					obj.value='';
					obj.focus();
					obj.focus();
					obj.select();
					
					flag=0;
				}
				else flag=1;
			}
		}
	}

	function toFromValidate(Obj,Obj2)
	{
		if(validDateObj(Obj,"DMY",localeName))
		{
		


		
			curdate = document.forms[0].cur_date;
			var msg = getMessage("TO_DATE_LESS_SYSDATE",'SM');
				if(!(isAfterNow(Obj.value,"DMY",localeName)))
				{
					Obj.focus();
					Obj.select();
					alert(msg);
					Obj.value='';
					Obj.focus();
					Obj.select();
					flag=0;
					chk=0;
				}
				else{
					flag=1;
					chk=1;
				}
				if(chk){
			
		var msg = getMessage("TO_DT_GR_EQ_FM_DT",'SM');		
					if(Obj2.value!=''){

			if(!(isBefore(Obj2.value,Obj.value,"DMY",localeName))) 
			{
				
				Obj.focus();
				Obj.select();
				alert(msg);
				Obj.value='';
				Obj.focus();
				Obj.select();
					
				flag =0;
			}
			else	flag =1;
				}
				}
		
		
		}
	}
	function sorts()
	{
		var count =  '<%=count%>';
		if(count=="2")
		{
			document.forms[0].sorting.value='desc';
			document.forms[0].count.value='1';
		}
		else
		{
			document.forms[0].sorting.value='';
			document.forms[0].count.value = '2';
		}
		document.forms[0].submit();
	}

	
	</script>
	</head>
	<body  onKeyDown = 'lockKey();'  OnMouseDown="CodeArrest()">
	<form name='responsibility_form' id='responsibility_form' action='../../eSM/jsp/ResponsibilityforUserDetailForm.jsp' method='post' >
		<p>	
		<table align='right' id='titletb'>
		
		<tr>
		<%
			if ( !(start <= 1)) {
		%>
			<td align ='right' id='prev'><a  href='javascript:submitPrevNext(<%=(start-10)%>,<%=(end-10)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
		
		<%
			}
	//		if ( !((start+10) > maxRecord )){
		%>
			<td align ='right' id='next' style='visibility:hidden'><a  href='javascript:submitPrevNext(<%=(start+10)%>,<%=(end+10)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>

		<%
		//	}
		%>
		
		</tr>
		</table>
		<br>
		<br>

	<table border='1' cellpadding='0' cellspacing='0' id='titletb1'>
	<th width='55%' style='cursor:pointer' onclick='sorts();'><%=tableheader%> </th>
	<th width='15%' nowrap><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></th>
	<th width='10%'><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></th>
	<th width='5%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
	<%
		String resp_id="";String fromDatVal="",toDatVal="";
		if(objname.equals("User"))
		{
		//String sqlUser="Select resp_id,resp_name from sm_resp where "+whereclause+"  eff_status='E'  and ( (trunc(eff_date_from) <= trunc(sysdate) and trunc(eff_date_to) >=  trunc(sysdate) )  or (trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and  eff_date_from is null)  or (eff_date_from is null and eff_date_to is null)) order by upper(resp_name)"+sorting;
		String sqlUser="Select RESP_ID, RESP_NAME, To_Char(EFF_DATE_FROM,'dd/mm/yyyy') EFF_DATE_FROM, To_Char(EFF_DATE_TO,'dd/mm/yyyy') EFF_DATE_TO, upd_ind, trunc(sysdate)-trunc(eff_date_from) diffdate  from ( Select RESP_ID, RESP_NAME, EFF_DATE_FROM,EFF_DATE_TO, 'Y' upd_ind from SM_RESP_FOR_USER_VW where APPL_USER_ID = '"+userID+"'  UNION  Select  RESP_ID, RESP_NAME, NULL EFF_DATE_FROM, NULL EFF_DATE_TO, 'N' upd_ind from  sm_resp WHERE EFF_STATUS='E' AND  ( (trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from) and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null)) and RESP_ID not in (Select RESP_ID FROM SM_RESP_FOR_USER_VW WHERE APPL_USER_ID = '"+userID+"') ) where "+whereclause+" order by  upper (RESP_NAME) "+sorting;
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
				resp_id = rset.getString("resp_id");
				fromDatVal = rset.getString("eff_date_from");
				toDatVal = rset.getString("eff_date_to");
			
			if(fromDatVal == null)
				fromDatVal="";

			if(toDatVal == null)
				toDatVal="";

			String upd_ind = rset.getString("upd_ind");
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
			 diffinDate = rset.getString("diffdate");
			if (diffinDate==null || diffinDate.equals("") || Integer.parseInt(diffinDate) < 0) diffinDate = "0"; 
					
				if((i%2) == 1)
					classValue = "QRYODD";
				else
					classValue ="QRYEVEN";
				%>
				
				<tr>

					<td class='<%=classValue%>' ><%=rset.getString("resp_name")%></td>
					<%if (Integer.parseInt(diffinDate) >0)
					{
					redOnly = "readonly";
					disableFld = "disabled";
					}
				else
					{
					redOnly = "";
					disableFld = "";
					}%>
					<td>
						<input type='hidden' name='old_eff_from<%=i%>' id='old_eff_from<%=i%>'  value='<%=fromDatVal%>' >
						<input type='hidden' name='diffinDate<%=i%>' id='diffinDate<%=i%>'  value='<%=diffinDate%>' >
						<input type='text' id='eff_date_from<%=i%>' name='eff_date_from<%=i%>' <%=redOnly%> size='10' onBlur="if (!this.readOnly) {DateValidation(this,'old_eff_from<%=i%>','<%=i%>')};validate_date1(this,eff_date_to<%=i%>);"  value='<%=DateUtils.convertDate(fromDatVal,"DMY","en",localeName)%>'  maxlength='10'>
						<input type='image' src='../../eCommon/images/CommonCalendar.gif' <%=disableFld%> onClick="document.getElementById('eff_date_from<%=i%>').focus();return showCalendar('eff_date_from<%=i%>');">
					</td>

					<td>
						<input type='text' id='eff_date_to<%=i%>' name='eff_date_to<%=i%>' size='10' 
			       onBlur='toFromValidate(this,eff_date_from<%=i%>);validate_date(this,eff_date_from<%=i%>);'  value='<%=DateUtils.convertDate(toDatVal,"DMY","en",localeName)%>' maxlength='10'>
			       		<input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick="document.getElementById('eff_date_to<%=i%>').focus();return  showCalendar('eff_date_to<%=i%>');">
			       		<input type='hidden' name='db_eff_date_to<%=i%>' id='db_eff_date_to<%=i%>' value='<%=toDatVal%>' maxlength='10'>
			       	</td>
				
					<td align='center' class='<%=classValue%>' ><input type='checkbox' <%=chkAttribute%> name='respID<%=i%>'  id='respID<%=i%>' value='<%=resp_id%>' ><input type='hidden'  name='db_respID<%=i%>' id='db_respID<%=i%>'  value='<%=upd_ind1%>' ></td>
				</tr>
						<%
				i++;
				cnt++;
			}
%>
</table>
<%	
			if (cnt==0)
			{
				out.println("<script>document.getElementById(\"titletb\").style.visibility='hidden';document.getElementById(\"titletb1\").style.visibility='hidden';alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				
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
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
		}
	 }
	 else if(objname.equals("Resp"))
	{
		//String sqlUser="select appl_user_name, appl_user_id from sm_appl_user  where  "+whereclause+" eff_status='E'and ( (trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from)  and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null))order by upper(appl_user_name)"+sorting;

		String sqlUser="Select APPL_USER_ID, APPL_USER_NAME, To_Char(EFF_DATE_FROM,'dd/mm/yyyy') EFF_DATE_FROM, To_Char(EFF_DATE_TO,'dd/mm/yyyy') EFF_DATE_TO, upd_ind , trunc(sysdate)-trunc(eff_date_from) diffdate  from ( Select APPL_USER_ID, APPL_USER_NAME, EFF_DATE_FROM,EFF_DATE_TO, 'Y' upd_ind from SM_RESP_FOR_USER_VW where RESP_ID = '"+userID+"' UNION   Select  APPL_USER_ID, APPL_USER_NAME, NULL EFF_DATE_FROM, NULL EFF_DATE_TO, 'N' upd_ind from  sm_appl_user WHERE EFF_STATUS='E' AND  ( (trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from) and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null)) and APPL_USER_ID not in (Select APPL_USER_ID FROM SM_RESP_FOR_USER_VW WHERE RESP_ID = '"+userID+"') ) where "+whereclause+" order by  upper (APPL_USER_NAME)"+sorting;
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
			cnt=0;
			 
			 while( i<=end && rset.next())
			 {
				resp_id = rset.getString("APPL_USER_ID");
				fromDatVal = rset.getString("eff_date_from");
				toDatVal = rset.getString("eff_date_to");
				if(fromDatVal == null)
					fromDatVal = "";
				if(toDatVal == null)
					toDatVal = "";

				String upd_ind = rset.getString("upd_ind");
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
				 diffinDate = rset.getString("diffdate");
				 if (diffinDate==null || diffinDate.equals("") || Integer.parseInt(diffinDate) < 0) diffinDate = "0"; 
			
				if((i%2) == 1)
					classValue = "QRYODD";
				else
					classValue ="QRYEVEN";
				%>
				
				<tr>

					<td class='<%=classValue%>' ><%=rset.getString("appl_user_name")%></td>
					<%
					if (Integer.parseInt(diffinDate) >0)
					{
					redOnly = "readonly";
					disableFld = "disabled";
					}
				else
					{
					redOnly = "";
					disableFld = "";
					}%>
					<td>
					<input type='hidden' name='old_eff_from<%=i%>' id='old_eff_from<%=i%>'  value='<%=fromDatVal%>' >
					<input type='hidden' name='diffinDate<%=i%>' id='diffinDate<%=i%>'  value='<%=diffinDate%>'>
					<input type='text' id='eff_date_from<%=i%>' name='eff_date_from<%=i%>' <%=redOnly%> size='10' onBlur="if (!this.readOnly) {DateValidation(this,'old_eff_from<%=i%>','<%=i%>')};validate_date1(this,eff_date_to<%=i%>);"  value='<%=DateUtils.convertDate(fromDatVal,"DMY","en",localeName)%>'  maxlength='10'>
					<input type='image' src='../../eCommon/images/CommonCalendar.gif' <%=disableFld%> onClick="document.getElementById('eff_date_from<%=i%>').focus();return showCalendar('eff_date_from<%=i%>');">
					</td>

					<td>
					<input type='text' id='eff_date_to<%=i%>' name='eff_date_to<%=i%>' size='10'  onBlur='toFromValidate(this,eff_date_from<%=i%>);validate_date(this,eff_date_from<%=i%>);'  value='<%=DateUtils.convertDate(toDatVal,"DMY","en",localeName)%>'  maxlength='10'>
					<input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="document.getElementById('eff_date_to<%=i%>').focus();return showCalendar('eff_date_to<%=i%>');">
					<input type='hidden' name='db_eff_date_to<%=i%>' id='db_eff_date_to<%=i%>' value='<%=toDatVal%>'>
					</td>

					<td align='center' class='<%=classValue%>' ><input type='checkbox' <%=chkAttribute%> name='respID<%=i%>' id='respID<%=i%>' value='<%=resp_id%>' ><input type='hidden'  name='db_respID<%=i%>' id='db_respID<%=i%>'  value='<%=upd_ind1%>' ></td>
				</tr>
				<%
				i++;
				cnt++;
			}
%>
</table>
<%			if (cnt==0)
			{
				out.println("<script>document.getElementById(\"titletb\").style.visibility='hidden';document.getElementById(\"titletb1\").style.visibility='hidden';alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
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

		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
		}
	 }
	//}
	%>	
		
			<input type=hidden name=from id='from' value='<%=start%>'>
			<input type=hidden name=to id='to' value='<%=end%>'>
			<input type=hidden name='start' id='start' value='<%=start%>'>
			<input type=hidden name='end' id='end' value='<%=end%>'>
			<input type='hidden' name='userID' id='userID' value="<%=userID%>" >
			<input type='hidden' name='sorting' id='sorting' value="<%=sorting%>" >
			<input type='hidden' name='count' id='count' value="<%=count%>" >
			<input type='hidden' name='objname' id='objname' value="<%=objname%>" >
			<input type='hidden' name='searchresp' id='searchresp' value="<%=searchresp%>" >
			<input type='hidden' name='scode' id='scode' value="<%=scode%>" >
			<input type='hidden' name='searchcriteria' id='searchcriteria' value="<%=searchcriteria%>" >
			<input type='hidden' name='function_name' id='function_name' value=''>
			<input type='hidden' name='cur_date' id='cur_date' value='<%=dateFormat.format( new java.util.Date() ) %>' >
			<input type='hidden' name='old_eff_date_from' id='old_eff_date_from' value='<%=old_eff_date_from%>'>
			<input type='hidden' name='old_eff_date_to' id='old_eff_date_to' value='<%=old_eff_date_to%>'>
			<input type='hidden' name='insert_vals' id='insert_vals' value="" >
			<input type='hidden' name='update_vals' id='update_vals' value="" >
			<input type='hidden' name='delete_vals' id='delete_vals' value="" >
	<%	}catch(Exception e){
				out.println(e);
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

