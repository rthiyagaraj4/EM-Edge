<!DOCTYPE html>
<html>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*, eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String label1="";
	String old_eff_date_from="";
   	String old_eff_date_to="";
//	String diffdate = "";
	String redOnly = "";
	String diffinDate = "0";
	String disableFld = "";
	String upd_ind1 = "";
	String operation=request.getParameter("operation")==null ? "" :request.getParameter("operation");
	String searchText =request.getParameter("searchText")==null ? "" :request.getParameter("searchText");
	String filterCondition =request.getParameter("filter")==null ? "" :request.getParameter("filter");
	String searchText1=searchText;
    
   if(operation.equals("")){
	if(!searchText.equals(""))
	{
		//searchText = searchText + "%";
		if(filterCondition.equals("S"))
		{
			searchText = searchText + "%";
		}
		else if(filterCondition.equals("C"))
		{
			searchText ="%" + searchText + "%";
		}
		else if(filterCondition.equals("E"))
		{
			searchText ="%" + searchText;
		}
	}
	else
	{
		searchText = "%";
	}
 }

	Connection con=null;
//	Statement stmt3=null;

	Statement stmt=null;
	int cnt=0;

	String classValue="";
	try{
    con = ConnectionManager.getConnection(request);
	
//	ResultSet rset3=null ;
	
	
	String userID="";
	userID=request.getParameter("userID")==null ? "" : request.getParameter("userID");
	String from = request.getParameter("from") ;
	String to = request.getParameter("to") ;
	String label = request.getParameter("label") == null ? "" :request.getParameter("label");
	
	

//	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=1;
        if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 11 ; }   else {  end = Integer.parseInt( to ) ; }
        
        String chkAttribute="";
        
//        String  req_start   =   "", req_end     =   "";
//        String  checkedOnes         =   "",checkedRemarks="",checkedFrDate="",checkedToDate="";
        SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
        

	
				%>

       <%// }
        i = 1 ;
        
	ResultSet rset=null ;
	ResultSet rset1=null ;
	
	
	

   
		if(rset1!=null)rset1.close();
		if(stmt!=null)stmt.close();
	  

	
	//}


          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script language='javascript' src='../../eSM/js/FacilitiesForUser.js'> </script>
<script>
	function submitPrevNext(from, to,searchText,label){
	  /*  document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
		document.responsibility_form.label.value = label; 
		document.responsibility_form.searchText.value = searchText; 

	    document.forms[0].submit();*/
		
		effected_records1(from,to);
	}
	
	async function getComments(Obj,comments)
	{
		var url		= "../../eSM/jsp/GetComments.jsp";
		var dialogTop	= "270";
		var dialogHeight= "150px" ; 
		var dialogWidth	= "380px" ;	
		var dialogLeft	= "300" ;
		var arguments	= eval("document.forms[0]."+comments).value;
		if(arguments == null) arguments="";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no; dialogLeft: "+dialogLeft ;
		var returnval = await window.showModalDialog( url, arguments, features ) ;	
		
		if(returnval == null) returnval="";
		eval("document.forms[0]."+comments).value = returnval;
	}

var flag=1;	
function DateValidation(obj,oldFromDt)
	{
		if(obj.value!='')
		{
			if(validDateObj(obj,"DMY",localeName))
			{
			    Obj2=eval("document.forms[0]."+oldFromDt)
				if(Obj2.value.length>0 && obj.value.length == 0)
				{
				alert(getMessage("FROM_DATE_CANNOT_BE_BLANK","SM"));
				obj.value='';
				obj.focus();
				obj.select();
				flag=0;
			}
			else{
			var msg = getMessage("FROM_DATE_LESS_SYSDATE","SM");
			if (obj.value != oldFromDt)
			{
				if(!(isAfterNow(obj.value,"DMY",localeName)))
	            {
					obj.focus(); 
					obj.select();
					obj.value='';
					alert(msg);
	            }
				else flag=1;
			}
		}
	 }
	}
}
function toFromValidate(Obj,Obj2)
{

	if(validDateObj(Obj2,"DMY",localeName))
{
	var msg = getMessage("TO_DATE_LESS_SYSDATE","SM");
	if(Obj2.value!=''){
		if(!(isAfterNow(Obj2.value,"DMY",localeName)))
		{
			Obj2.focus();
			Obj2.select();
			alert(msg);
			Obj2.value='';
			return;
		}
		else flag=1;
	}
	if(validDateObj(Obj,"DMY",localeName))
	{
	     var msg = getMessage("TO_DT_GR_EQ_FM_DT","SM");

							if(Obj.value!="" && Obj2.value!="")
					{
							 if(!(isBefore(Obj.value,Obj2.value,"DMY",localeName)))
								{
									    alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
									    Obj2.value='';
										Obj2.select();
										Obj2.focus();						
								}	
						}
					}
		

	}
}

</script>
</head>
<body   onKeyDown = 'lockKey()';  OnMouseDown="CodeArrest()">
<form name='responsibility_form' id='responsibility_form' action='../../eSM/jsp/FacilityforUserDetailForm.jsp' method='post' >
	<p>
	<table align='right'>
	<tr>
	<%
	    if ( !(start <= 1)) {
	%>
	    <td align ='right' id='prev'><a href='javascript:submitPrevNext(<%=(start-11)%>,<%=(end-11)%>,"<%=java.net.URLEncoder.encode(searchText)%>","<%=label%>")' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
	
	<%
	    }
	//    if ( !((start+11) > maxRecord )){
	%>
	   <td align ='right' id='next' style='visibility:hidden'> <a href='javascript:submitPrevNext(<%=(start+11)%>,<%=(end+11)%>,"<%=java.net.URLEncoder.encode(searchText)%>","<%=label%>")' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
	<%
	//    }
	%>
		
		</tr>
		</table>
		<br>
		<br>

	
<table border='1' cellpadding='0' cellspacing='0'>
<th width='55%'><%if(label.equals(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.user.label","common_labels"))){
	out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels"));
    label1="User";
}
else
{
	out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.user.label","common_labels"));
  label1="Facility";
}%></th>
<th width='15%' nowrap><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></th>
<th width='10%'><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></th>
<th width='15%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
<th width='5%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
<%
	String facility_id="";String commentVal="",fromDatVal="",toDatVal="";
	String sqlUser="";
	

	if(!label.equals(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.user.label","common_labels"))){
	//sqlUser="SELECT    appl_user_id,appl_user_name     FROM sm_appl_user WHERE eff_status = 'E' and upper(appl_user_name) like upper('"+searchText+"')  AND  ((eff_date_from <= TRUNC (SYSDATE)  AND eff_date_to >= TRUNC (SYSDATE)  )  OR (eff_date_to >= TRUNC (SYSDATE) AND eff_date_from IS NULL)  OR (eff_date_from IS NULL or eff_date_to IS NULL)) ORDER BY appl_user_name  ";
	sqlUser="SELECT APPL_USER_ID , APPL_USER_NAME ,TO_CHAR(EFF_DATE_FROM,'dd/mm/yyyy') EFF_DATE_FROM , TO_CHAR(EFF_DATE_TO,'dd/mm/yyyy') EFF_DATE_TO , remarks , upd_ind FROM ( SELECT APPL_USER_ID , APPL_USER_NAME ,ACCESS_EFF_DATE_FROM EFF_DATE_FROM ,ACCESS_EFF_DATE_TO EFF_DATE_TO ,REMARKS, 'Y' upd_ind  FROM SM_FACILITY_FOR_USER_VW WHERE FACILITY_ID = '"+userID+"' UNION SELECT APPL_USER_ID , APPL_USER_NAME , NULL EFF_DATE_FROM , NULL EFF_DATE_TO , NULL remarks , 'N' upd_ind FROM sm_appl_user WHERE EFF_STATUS='E' AND APPL_USER_ID not IN ( SELECT APPL_USER_ID FROM SM_FACILITY_FOR_USER_VW WHERE FACILITY_ID = '"+userID+"' ) ) where upper(APPL_USER_NAME) like upper('"+searchText+"') ORDER BY  upper(APPL_USER_NAME)";
     
	}
else
	{
	//sqlUser=" select facility_id,facility_name from sm_facility_param where upper(facility_name) like upper('"+searchText+"') order by facility_name ";

	sqlUser="SELECT FACILITY_ID , FACILITY_NAME,TO_CHAR(EFF_DATE_FROM,'dd/mm/yyyy') EFF_DATE_FROM , TO_CHAR(EFF_DATE_TO,'dd/mm/yyyy') EFF_DATE_TO , upd_ind,remarks FROM ( SELECT FACILITY_ID , FACILITY_NAME ,ACCESS_EFF_DATE_FROM EFF_DATE_FROM ,ACCESS_EFF_DATE_TO EFF_DATE_TO , 'Y' upd_ind, remarks FROM SM_FACILITY_FOR_USER_VW WHERE APPL_USER_ID = '"+userID+"' UNION SELECT FACILITY_ID , FACILITY_NAME , NULL EFF_DATE_FROM , NULL EFF_DATE_TO , 'N' upd_ind, null remarks FROM sm_facility_param WHERE STATUS='E' AND FACILITY_ID not IN ( SELECT FACILITY_ID FROM SM_FACILITY_FOR_USER_VW WHERE APPL_USER_ID = '"+userID+"' ) ) where upper(FACILITY_NAME) like upper('"+searchText+"') ORDER BY upper (FACILITY_NAME)   ";
	}

     	stmt=con.createStatement();	
	rset=stmt.executeQuery(sqlUser);
	
	if(rset!=null)
	{
		if ( start != 0 )
		{
		 for( int j=1; j<start; i++,j++ ){
		  rset.next() ;
		  }
		}
		
		 while(rset.next() && i<=end )
		 {
			
			facility_id = rset.getString(1);
			fromDatVal = rset.getString("eff_date_from");
			toDatVal = rset.getString("eff_date_to");
			commentVal = rset.getString("remarks");

			if(commentVal == null)
				commentVal= "";

			if(fromDatVal == null)
				fromDatVal= "";

			if(toDatVal == null)
				toDatVal= "";

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
		/*	if(facForUser.containsObject(facility_id)) {
				chkAttribute = "CHECKED";
			}
			else
			chkAttribute="";
			
			int recordIndex = facForUser.indexOfObject(facility_id);
			if(recordIndex!=-1)
			{
			if(chkAttribute.equals("CHECKED")) 
				{ 
				facForUser.removeObject(recordIndex);
				commentVal = (String)facForUserRemarks.getObject(recordIndex);
				facForUserRemarks.removeObject(recordIndex);
				fromDatVal=(String)facForUserFromDate.getObject(recordIndex);
				facForUserFromDate.removeObject(recordIndex);
				toDatVal=(String)facForUserToDate.getObject(recordIndex);
				facForUserToDate.removeObject(recordIndex);
                diffinDate = (String) diffBean.getObject(recordIndex);
				if (diffinDate==null || diffinDate.equals("") || Integer.parseInt(diffinDate) < 0) diffinDate = "0";
				diffBean.removeObject(recordIndex);	
				}
			}
			else
			{
				commentVal="";
				fromDatVal="";
				toDatVal="";
			}*/
	
			if((i%2) == 1)
				classValue = "QRYODD";
			else
				classValue ="QRYEVEN";
			%>
			<tr>
			<td class='<%=classValue%>' ><%=rset.getString(2)%></td>
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
			 }
			%>
				<td><input type='hidden' name='old_eff_from<%=i%>' id='old_eff_from<%=i%>' value='<%=fromDatVal%>' ><input type='hidden' name='diffinDate<%=i%>' id='diffinDate<%=i%>' value='<%=diffinDate%>' ><input type='text' id='eff_date_from<%=i%>'  name='eff_date_from<%=i%>' size='10' <%=redOnly%> onBlur="if (!this.readOnly) { DateValidation(this,'old_eff_from<%=i%>');toFromValidate(this,eff_date_to<%=i%>)}" value='<%=DateUtils.convertDate(fromDatVal,"DMY","en",localeName)%>'  maxlength='10'><input type='image' src='../../eCommon/images/CommonCalendar.gif' <%=disableFld%> onClick="document.getElementById('eff_date_from<%=i%>').focus();return showCalendar('eff_date_from<%=i%>');"></td>
			
				<td><input type='text' id='eff_date_to<%=i%>' name='eff_date_to<%=i%>' size='10'  onBlur="toFromValidate(eff_date_from<%=i%>,this)"   value='<%=DateUtils.convertDate(toDatVal,"DMY","en",localeName)%>'  maxlength='10'><input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="document.getElementById('eff_date_to<%=i%>').focus();return showCalendar('eff_date_to<%=i%>');"><input type='hidden'  name='db_eff_date_to<%=i%>' id='db_eff_date_to<%=i%>'   value='<%=toDatVal%>'></td>
		
				<td class='<%=classValue%>' ><input type='hidden' name='comments<%=i%>' id='comments<%=i%>' value='<%=commentVal%>'><input type='hidden' name='db_comments<%=i%>' id='db_comments<%=i%>' value='<%=commentVal%>'>
					<a href=javaScript:getComments(this,'comments<%=i%>')><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>
					
				<td align='center' class='<%=classValue%>' ><input type='checkbox' <%=chkAttribute%> name='facilityID<%=i%>'  id='facilityID<%=i%>' value='<%=facility_id%>' ><input type='hidden' name='db_facilityID<%=i%>' id='db_facilityID<%=i%>'  value='<%=upd_ind1%>' ></td>
				</tr>
				<%
			i++;
			cnt++;
		}

	}
	if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.frames[2].document.location.href='../../eCommon/html/blank.html'</script>");
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
	if(rset!=null)rset.close();
	if(stmt!=null)stmt.close();
%>	
	</table>
		<input type=hidden name=from id='from' value='<%=start%>'>
		<input type=hidden name=to id='to' value='<%=end%>'>
		<input type=hidden name='start' id='start' value='<%=start%>'>
		<input type=hidden name='end' id='end' value='<%=end%>'>
		<input type='hidden' name='userID' id='userID' value="<%=userID%>" >
		<input type='hidden' name='function_name' id='function_name' value=''>
		<input type='hidden' name='label' id='label' value='<%=label%>'>
	    <input type='hidden' name='label1' id='label1' value='<%=label1%>'>
		<!--<input type='hidden' name='searchText' id='searchText' value=''>-->
		<input type='hidden' name='searchText' id='searchText' value='<%=searchText1%>'>
		<input type='hidden' name='operation' id='operation' value='split'>
		<input type='hidden' name='cur_date' id='cur_date' value='<%=dateFormat.format( new java.util.Date() ) %>' >
		<input type='hidden' name='old_eff_date_from' id='old_eff_date_from' value='<%=old_eff_date_from%>'>
		<input type='hidden' name='old_eff_date_to' id='old_eff_date_to' value='<%=old_eff_date_to%>'>
		<input type='hidden' name='filter' id='filter' value='<%=filterCondition%>'>
		<input type='hidden' name='insert_vals' id='insert_vals' value="" >
		<input type='hidden' name='update_vals' id='update_vals' value="" >
		<input type='hidden' name='delete_vals' id='delete_vals' value="" >
		<%			if(stmt!=null) stmt.close();
					
	  }catch(Exception e){out.println(e);
	  e.printStackTrace();}

	finally {
					
		ConnectionManager.returnConnection(con,request);
	/*	session.setAttribute("facForUser", facForUser);
		session.setAttribute("facForUserRemarks", facForUserRemarks);
		session.setAttribute("facForUserFromDate", facForUserFromDate);
		session.setAttribute("facForUserToDate", facForUserToDate);
		session.setAttribute("diffBean", diffBean);*/
	}	
	%>
	</form>
	</body>
</html>

