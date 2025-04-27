<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*" %>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eMR/js/HolidayForMedicalRecord.js"></script>
<HTML>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>

<BODY  class='CONTENT' onLoad='ClearMsg()' onKeyDown = 'lockKey()'>
<%	
    String operation="",from="",to="",orderCols="",holiday_date="",fromPage1="",selCheckBoxes="",selHolidays="",link="",locale="";
    int currPage=0;
	int fromPage=0;
	int temp=0;
	
    request.setCharacterEncoding("UTF-8");  
	StringBuffer strsql2=new StringBuffer();
	StringBuffer sql=new StringBuffer();
	StringBuffer where1=new StringBuffer();
		
	String checked[] = new String[15];
    ArrayList al= new ArrayList(25);
    al.add(0,"000000000000000");
    ArrayList al1= new ArrayList(25);
    al1.add(0,"");
	
	try{

	operation=request.getParameter("operation")==null?"":request.getParameter("operation") ;
	from = request.getParameter("from") ;
	to = request.getParameter("to") ;   
	fromPage1=request.getParameter("fromPage")==null?"0":request.getParameter("fromPage");
	selCheckBoxes=request.getParameter("selCheckBoxes")==null?"":request.getParameter("selCheckBoxes");
	selHolidays=request.getParameter("selHolidays")==null?"":request.getParameter("selHolidays");
	link =request.getParameter("link")==null?"":request.getParameter("link");
	locale=(String)session.getAttribute("LOCALE");
	fromPage=Integer.parseInt(fromPage1);

	String currSelVals="";

	ArrayList selVals= (ArrayList)session.getAttribute("selVals");
	ArrayList selVals1= (ArrayList)session.getAttribute("selVals1");

	if (selCheckBoxes.equals("") && selVals!=null) {
		session.removeAttribute("selVals");
		selCheckBoxes="000000000000000";
		selVals=null;
		session.removeAttribute("selVals1");
		selHolidays="";
		selVals1=null;
	}

	if (selVals==null){
		session.setAttribute("selVals",al);
	}else{
		if (selVals.size() > fromPage){
		selVals.set(fromPage,selCheckBoxes);
		}else{
		selVals.add(selCheckBoxes);
		}
		session.setAttribute("selVals",selVals);
	}

	if (selVals1==null){
		session.setAttribute("selVals1",al1);
	}else{
		if (selVals1.size() > fromPage){
		selVals1.set(fromPage,selHolidays);
		}else{
		selVals1.add(selHolidays);
		}
		session.setAttribute("selVals1",selVals1);
	}


	if (link.equals("prev")){
		currPage=fromPage-1;
	}else if(link.equals("next")){
		currPage=fromPage+1;
	}

	for ( int i=0;i<15;i++) checked[i]="";

	if (selVals !=null){
	if (selVals.size() > currPage){
		currSelVals=(String)selVals.get(currPage);
		for(int i=0;i<currSelVals.length();i++){
			if (currSelVals.charAt(i)=='1'){
				checked[i]="CHECKED";
			}else{
				checked[i]="";
			}
		}
	}
	}

	if (selVals!=null){
	   selVals.clear();
	}

	if (selVals1!=null){
		selVals1.clear();
	}
	}catch(Exception e){
		e.printStackTrace();
	}
    
	holiday_date = request.getParameter("holiday_date") == null ? "" : request.getParameter("holiday_date");	
	 	 	 
	if(!holiday_date.equals(""))holiday_date=DateUtils.convertDate(holiday_date,"DMY",locale,"en");	
	
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null ){
		start = 1 ;
	}else{
		start = Integer.parseInt( from ) ;
	}

	if ( to == null ){
	  	end = 14 ;
	}else{
		end = Integer.parseInt( to ) ;
	}
	
	Connection conn = ConnectionManager.getConnection(request);

	Statement stmt=null;
	Statement stmt1=null;
	ResultSet rset1=null;
	ResultSet rs=null;
	int maxRecord = 0;
%>
<script>

function nextRecs(start,end,whereclause,fromPag){ 
	var flag=false;
	var len=document.getElementById('checkBox').length;
	var currentPage=document.forms[0].currentPage.value;
	var operation =document.forms[0].operation.value;
	var holiday_date=document.forms[0].holiday_date.value;
	var obj=parent.frames[1].document.HolidayForMedicalRecordQueryResult.checkBox;
	var Obj=parent.frames[1].document.HolidayForMedicalRecordQueryResult;
	if (len!=null && len!=''){
		for(i=0;i<len;i++){
			if(document.getElementById('checkBox')[i]){
				if(document.getElementById('checkBox')[i].checked==true){
					flag=true;
				}
			}
		}
	}else if(len==null){
		if(obj.checked){
		  flag=true;
		}
	}
	
	if(flag==false){
		var url="../../eMR/jsp/HolidayForMedicalRecordQueryResult.jsp?operation="+operation+"&from="+(start)+"&to="+(end)+"&holiday_date="+holiday_date+"&fromPage="+currentPage+"&link=next&selCheckBoxes=";	 	
		parent.f_query_add_mod.location.href=url;
	}else{
		var conf = confirm(getMessage("DELETE_CANCEL_HOLIDAY_NEXT","FM"));
		if(conf){
			var selValues="";
			var selValues1="";
			
			if (Obj.selectall.checked){
				var str="111111111111111";
			}else{
				var str="000000000000000";
			}
			if (len!=null && len!=''){
				for (i=0;i<len;i++){
					if (obj[i].checked){ 
						str=parent.frames[1].replace(str,i+1,'1') ;
						selValues1=Obj.holidayDate[i].value+'|';
						selValues+=selValues1;
					 }
				}
			}else if(len==null){
			   if(obj.checked){
				var str="10000000000000";
				selValues=Obj.holidayDate.value+'|';
			    }
			}
						
			
			parent.frames[1].document.HolidayForMedicalRecordQueryResult.selectedValues.value=selValues;
			parent.frames[1].document.HolidayForMedicalRecordQueryResult.selCheckBoxes.value=str;
			parent.frames[1].document.HolidayForMedicalRecordQueryResult.prevnextsubm.value="Y";
			var fromPage=parent.frames[1].document.HolidayForMedicalRecordQueryResult.currentPage.value;	
			parent.frames[1].document.HolidayForMedicalRecordQueryResult.submit();					
		
			
		}else{
			ClearAll();
			var url="../../eMR/jsp/HolidayForMedicalRecordQueryResult.jsp?operation="+operation+"&from="+start+"&to="+end+"&holiday_date="+holiday_date+"&fromPage="+currentPage+"&link=next&selCheckBoxes=";
			parent.f_query_add_mod.location.href=url;
			
		}
	}
}

function ClearAll(){
	var len=document.getElementById('checkBox').length
	for(i=0;i<len;i++){
		if(document.getElementById('checkBox')[i]){
			if(document.getElementById('checkBox')[i].checked==true){
				document.getElementById('checkBox')[i].checked=false;
			}
		}
	}
	if(document.forms[0].selectall.checked==true){
		document.forms[0].selectall.checked=false;
	}
}

function  prevRecs(start,end,whereclause,fromPag){ 
	var flag=false;
	var len=document.getElementById('checkBox').length;
	var operation="<%=operation%>";
	var currentPage="<%=currPage%>";
	
	var holiday_date=document.forms[0].holiday_date.value;	
		
	var obj=parent.frames[1].document.HolidayForMedicalRecordQueryResult.checkBox;
	var Obj=parent.frames[1].document.HolidayForMedicalRecordQueryResult;
	
	if (len!=null && len!=''){
		for(i=0;i<len;i++){
			if(document.getElementById('checkBox')[i]){
				if(document.getElementById('checkBox')[i].checked==true){
					flag=true;
				}
		}
	 }
	}else if(len==null){
		if(obj.checked){
			flag=true;
	    }
	}
	
	if(flag==false){
		var url="../../eMR/jsp/HolidayForMedicalRecordQueryResult.jsp?operation="+operation+"&from="+(start)+"&to="+(end)+"&holiday_date="+holiday_date+"&fromPage="+currentPage+"&link=prev&selCheckBoxes=";
		parent.f_query_add_mod.location.href=url;
	}else{
		var conf = confirm(getMessage("DELETE_CANCEL_HOLIDAY_NEXT","FM"));
		if(conf){
			var selValues="";
			var selValues1="";
			
			if (Obj.selectall.checked){
				var str="111111111111111";
			}else{
				var str="000000000000000";
			}
			if (len!=null && len!=''){
				for (i=0;i<len;i++){
					if (obj[i].checked){ 
						str=parent.frames[1].replace(str,i+1,'1') ;
						selValues1=Obj.holidayDate[i].value+'|';
						selValues+=selValues1;
					}
				}
			}else if(len==null){
			   if(obj.checked){
				var str="10000000000000";
				selValues=Obj.holidayDate.value+'|';
				}
			}
			
			parent.frames[1].document.HolidayForMedicalRecordQueryResult.selectedValues.value=selValues;
			parent.frames[1].document.HolidayForMedicalRecordQueryResult.selCheckBoxes.value=str;
			var fromPage=parent.frames[1].document.HolidayForMedicalRecordQueryResult.currentPage.value;
			parent.frames[1].document.HolidayForMedicalRecordQueryResult.prevnextsubm.value="Y";
			parent.frames[1].document.HolidayForMedicalRecordQueryResult.submit();
		}else{
			ClearAll();
			var url="../../eMR/jsp/HolidayForMedicalRecordQueryResult.jsp?operation="+operation+"&holiday_date="+holiday_date+"&fromPage="+currentPage+"&link=prev&selCheckBoxes=";
			parent.f_query_add_mod.location.href=url;
		}
	}
}
</script>
<%

try
{	
	String facilityId = (String) session.getValue( "facility_id" ) ;

	stmt = conn.createStatement();
	strsql2.append("SELECT TO_CHAR (holiday_date, 'dd/mm/yyyy') holiday_val_date, holiday_date,reason_for_holiday, facility_id facilityid,TO_CHAR (holiday_date, 'Day') d  FROM mr_medical_record_holiday  WHERE TRUNC (holiday_date) >= TRUNC (SYSDATE)   AND facility_id = '"+facilityId+"' ");
	
	rs = stmt.executeQuery(strsql2.toString());
	
	strsql2.setLength(0);

	if ( start != 1 )
	for( int j=1; j<start; i++,j++ ){
		rs.next() ;
	}

	int k=1;
	while ( i<=end && rs.next()  )
	{
	
	if(maxRecord==0)
	{
	%>			
	<P>

	<table  align='right'>
	<tr>

	<%if ( !(start <= 1) ){%>
	<td align ='right' id='prev'><A HREF='javascript:prevRecs("<%=(start-14)%>","<%=(end-14)%>","<%=URLEncoder.encode(sql.toString())%>","<%=currPage%>")' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A></td>	
		<%
	}%>
		<td align ='right' id='next' style='visibility:hidden'><A HREF='javascript:nextRecs("<%=(start+14)%>","<%=(end+14)%>","<%=URLEncoder.encode(sql.toString())%>","<%=currPage%>")' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
	<%

	sql.setLength(0);
	  
	%>
	</td>
	</tr>
	</table>
	<br><br>
	</P>	

	<form name='HolidayForMedicalRecordQueryResult' id='HolidayForMedicalRecordQueryResult' method='post' action='../../servlet/eMR.HolidayForMedicalRecordServlet' target='messageFrame'>
	
	<table id='QRTable' border="1" width="100%" cellspacing='0' cellpadding='0'>
	<tr>	
		<td class='columnheader' ><fmt:message key="Common.HolidayDate.label" bundle="${common_labels}"/></td>
		<td class='columnheader' ><fmt:message key="eOA.HolidayDay.label" bundle="${oa_labels}"/></td>
		<td class='columnheader' ><fmt:message key="Common.ReasonForHoliday.label" bundle="${common_labels}"/></td>
		<td class='columnheader' ><fmt:message key="Common.selectall.label" bundle="${common_labels}"/><input type='checkbox' name='selectall' id='selectall' onClick='selectAll_S(this);' <%=checked[0]%>></td>	
	</tr>
	<% }

		String classValue = "" ;
	
		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;
		
		String holiday_date_disp="";
		String fs_locn_holiday_date="";
		String reason="";
		String holiday="";
		String clti="";
		facilityId="";

		facilityId	= rs.getString("facilityId")==null?"":rs.getString("facilityId");

		fs_locn_holiday_date=rs.getString("holiday_val_date")==null?"":rs.getString("holiday_val_date");

		holiday_date_disp=DateUtils.convertDate(fs_locn_holiday_date,"DMY","en",locale);

		reason=rs.getString("REASON_FOR_HOLIDAY")==null?"":rs.getString("REASON_FOR_HOLIDAY");
		holiday=rs.getString("D")==null?"":rs.getString("D");

		holiday=holiday.trim();

		if(holiday.equalsIgnoreCase("Monday"))
		{
			holiday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
		}else if(holiday.equalsIgnoreCase("Tuesday"))
		{
			holiday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
		}else if(holiday.equalsIgnoreCase("Wednesday"))
		{
			holiday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
		}else if(holiday.equalsIgnoreCase("Thursday"))
		{
			holiday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
		}else if(holiday.equalsIgnoreCase("Friday"))
		{
			holiday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
		}else if(holiday.equalsIgnoreCase("Saturday"))
		{
			holiday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
		}else  if(holiday.equalsIgnoreCase("Sunday"))
		{
			holiday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
		}

		%>
		<tr>
			<td class='<%=classValue%>' >
			<a href='javascript:modifyHolidayForMedicalRecord("<%=fs_locn_holiday_date%>","<%=java.net.URLEncoder.encode(reason)%>","<%=holiday%>","<%=facilityId%>")'><%=holiday_date_disp%></a><input type=hidden name='holidayDate' id='holidayDate' value='<%=fs_locn_holiday_date%>'></td>
			<td class='<%=classValue%>'>
			<a href='javascript:modifyHolidayForMedicalRecord("<%=fs_locn_holiday_date%>","<%=java.net.URLEncoder.encode(reason)%>","<%=holiday%>","<%=facilityId%>")'> 
			<%=holiday%>&nbsp;</a></td>
			<td class='<%=classValue%>'>
			<a href='javascript:modifyHolidayForMedicalRecord("<%=fs_locn_holiday_date%>","<%=java.net.URLEncoder.encode(reason)%>","<%=holiday%>","<%=facilityId%>")'> 
			<%=reason%></a></td>
			<td class='<%=classValue%>' align='center'><input type='checkbox' id='check_Box<%=k%>' name='checkBox' onClick='javascript:checkBoxOnClick(this,<%=k%>);'  ></td>
		</tr>

		<%
		k=k+1;
		i++;
		maxRecord++;
	}

	if(maxRecord == 0)
	{		
    %>
		<script>if('<%=temp%>'==0){alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));}</script>
	<% 
		temp++;
	}
	
	if ( maxRecord < 14 || (!rs.next()) ) {
	%>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='hidden';
		</script>
	<% 	} else {%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='visible';
		</script>
	<%}

	if(stmt!=null)	stmt.close();
	if(rs!=null)	rs.close();
	
}catch(Exception e){
	out.println(e.toString());
	e.printStackTrace();
}
finally{
	ConnectionManager.returnConnection(conn,request);
}
%>

</td></tr>
</table>

<input type='HIDDEN' name='selCheckBoxes' id='selCheckBoxes' value='00000000000000'>
<input type='HIDDEN' name='selectedValues' id='selectedValues' value=''>
<input type='HIDDEN' name='function_name' id='function_name' value='delete'>
<input type='hidden' name='fromWhere' id='fromWhere' value='multipleDelete'>
<input type='hidden' name='currentPage' id='currentPage' value='<%=currPage%>'>
<input type='hidden' name='prevnextsubm' id='prevnextsubm' value=''>
<input type='hidden' name='holiday_date' id='holiday_date' value='<%=holiday_date%>'>
<input type='hidden' name='operation' id='operation' value='<%=operation%>'>
<input type='hidden' name='orderCols' id='orderCols' value='<%=orderCols%>'>
<input type='hidden' name='maxRecordCount' id='maxRecordCount' value='<%=maxRecord%>'> 

</form>

<br><center>
</center>
</BODY>
</HTML>

