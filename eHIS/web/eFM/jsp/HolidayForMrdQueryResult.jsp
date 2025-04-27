<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*" %>


<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eFM/js/HolidayForMrd.js"></script>
<HTML><head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>




<BODY  class='CONTENT' onLoad='ClearMsg()' onKeyDown = 'lockKey()'>
<%	
    String operation="",from="",to="",orderCols="",holiday_date="",fromPage1="",selCheckBoxes="",selHolidays="",link="",locale="",
	fs_locn_code="",long_desc="";
    int currPage=0;
	int fromPage=0;
	
    request.setCharacterEncoding("UTF-8");  
	StringBuffer strsql2=new StringBuffer();
	StringBuffer sql=new StringBuffer();
	StringBuffer where1=new StringBuffer();
	String whereClause = request.getParameter("whereclause");	
	where1=where1.append(whereClause);	
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
  
	//MAINTAING SESSION FOR CHECK BOXES
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

	//MAINTAING SESSION FOR SELECTED LOCATION CODE-CLINI-HOLIDAY DATE

	

		
		
	

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
   }//if
   if (selVals!=null){
	   selVals.clear();
   }
	if (selVals1!=null){
		selVals1.clear();
	}
}catch(Exception e){
	e.printStackTrace();
}
    
	fs_locn_code = request.getParameter("fs_locn_code") == null ? "" : request.getParameter("fs_locn_code") ;
	long_desc = request.getParameter("long_desc") == null ? "" : request.getParameter("long_desc") ;
	if(long_desc!=null && long_desc.equals("")){
		long_desc=java.net.URLDecoder.decode(long_desc);
	}
	
	 holiday_date = request.getParameter("holiday_date") == null ? "" : request.getParameter("holiday_date");	
	 	 	 
	if(!holiday_date.equals(""))holiday_date=DateUtils.convertDate(holiday_date,"DMY",locale,"en");	
	if(!(fs_locn_code == null || fs_locn_code.equals(""))){
		fs_locn_code=fs_locn_code.toUpperCase();
		sql =sql.append(" and upper(a.fs_locn_code) like upper('"+fs_locn_code+"%')");
	}
	if(!(long_desc == null || long_desc.equals(""))){
			sql =sql.append( " and upper(long_desc) like  upper('"+long_desc+"%') ");

	}	
	if(!(holiday_date == null || holiday_date.equals(""))){
			sql=sql.append( " and holiday_date =to_date( '"+holiday_date+"' ,'dd/mm/yyyy') ");
	}
	if((whereClause == null || whereClause.equals(""))){		
		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");
		if (!(ord == null || ord .equals("")) ){
			sql=sql.append(" order by ");
			orderCols=" order by ";
			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					sql=sql.append(ord[i]);
					orderCols=orderCols+ord[i];
				}else{
					sql=sql.append(ord[i]);
					sql=sql.append(" ,");
					orderCols=orderCols+ord[i]+", ";
				}
			}			
		}else{
		  orderCols=" "+request.getParameter("orderCols") == null ? "" : request.getParameter("orderCols");
		  sql =sql.append(orderCols);		
		}
	}else {
		//sql = where1;
		orderCols=" "+request.getParameter("orderCols") == null ? "" : request.getParameter("orderCols");
		sql =sql.append(orderCols);	
        	
	}


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
	var len=document.getElementById("checkBox").length;
	var currentPage=document.forms[0].currentPage.value;
	var operation =document.forms[0].operation.value;
	var fs_locn_code=document.forms[0].fs_locn_code.value;
	var long_desc=document.forms[0].long_desc.value;
	var holiday_date=document.forms[0].holiday_date.value;
	var orderCols=document.forms[0].orderCols.value;
	
	var obj=parent.frames[1].document.FMHolidayQueryResult.checkBox;
	var Obj=parent.frames[1].document.FMHolidayQueryResult;
	if (len!=null && len!=''){
		for(i=0;i<len;i++){
			if(document.getElementById("checkBox")[i]){
				if(document.getElementById("checkBox")[i].checked==true){
					flag=true;
				}
			}
		}
	}else if(len==null){
		if(obj.checked){
		  flag=true;
		}
	}
	//alert("len==>"+len);
	
	if(flag==false){
		var url="../../eFM/jsp/HolidayForMrdQueryResult.jsp?operation="+operation+"&from="+(start)+"&to="+(end)+"&whereclause=Y"+"&fs_locn_code="+encodeURIComponent(fs_locn_code)+"&long_desc="+encodeURIComponent(long_desc)+"&holiday_date="+holiday_date+"&orderCols="+orderCols+"&fromPage="+currentPage+"&link=next&selCheckBoxes=";		
		parent.f_query_add_mod.location.href=url;
	}else{
		var conf = confirm(getMessage("DELETE_CANCEL_HOLIDAY_NEXT","FM"));
		if(conf){
			var selValues="";
			var selValues1="";
			/*len=parent.frames[1].document.FMHolidayQueryResult.checkBox.length;
			obj=parent.frames[1].document.FMHolidayQueryResult.checkBox;
			Obj=parent.frames[1].document.FMHolidayQueryResult;*/
			if (Obj.selectall.checked){
				var str="111111111111111";
			}else{
				var str="000000000000000";
			}
			if (len!=null && len!=''){
				for (i=0;i<len;i++){
					if (obj[i].checked){ 
						str=parent.frames[1].replace(str,i+1,'1') ;
						selValues1=Obj.holiday_fs_locn_code[i].value+'$'+Obj.holidayDate[i].value+'|';
						selValues+=selValues1;
					 }
				}
			}else if(len==null){
			   if(obj.checked){
				var str="10000000000000";
				selValues=Obj.holiday_fs_locn_code.value+'$'+Obj.holidayDate.value+'|';
			    }
			}
						
			
			parent.frames[1].document.FMHolidayQueryResult.selectedValues.value=selValues;
			parent.frames[1].document.FMHolidayQueryResult.selCheckBoxes.value=str;
			parent.frames[1].document.FMHolidayQueryResult.prevnextsubm.value="Y";
			var fromPage=parent.frames[1].document.FMHolidayQueryResult.currentPage.value;
			parent.frames[1].document.FMHolidayQueryResult.submit();
		
			//parent.parent.frames[2].document.getElementById("holiday").rows="8%,28%,*,8%";
		}else{
			ClearAll();
			var url="../../eFM/jsp/HolidayForMrdQueryResult.jsp?operation="+operation+"&from="+start+"&to="+end+"&whereclause=Y"+"&fs_locn_code="+encodeURIComponent(fs_locn_code)+"&long_desc="+encodeURIComponent(long_desc)+"&holiday_date="+holiday_date+"&orderCols="+orderCols+"&fromPage="+currentPage+"&link=next&selCheckBoxes=";
			parent.f_query_add_mod.location.href=url;
			//var url="../../eOA/jsp/HolidayQueryResult.jsp";
		}
	}
}
function ClearAll(){
	var len=document.getElementById("checkBox").length
	for(i=0;i<len;i++){
		if(document.getElementById("checkBox")[i]){
			if(document.getElementById("checkBox")[i].checked==true){
				document.getElementById("checkBox")[i].checked=false;
			}
		}
	}
	if(document.forms[0].selectall.checked==true){
		document.forms[0].selectall.checked=false;
	}
}
function  prevRecs(start,end,whereclause,fromPag){
	var flag=false;
	var len=document.getElementById("checkBox").length;
	var operation="<%=operation%>";
	var currentPage="<%=currPage%>";
	var fs_locn_code=document.forms[0].fs_locn_code.value;
	var long_desc=document.forms[0].long_desc.value;
	var holiday_date=document.forms[0].holiday_date.value;	
	var orderCols=document.forms[0].orderCols.value;	
	var obj=parent.frames[1].document.FMHolidayQueryResult.checkBox;
	var Obj=parent.frames[1].document.FMHolidayQueryResult;
	
	if (len!=null && len!=''){
		for(i=0;i<len;i++){
			if(document.getElementById("checkBox")[i]){
				if(document.getElementById("checkBox")[i].checked==true){
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
		
		var url="../../eFM/jsp/HolidayForMrdQueryResult.jsp?operation="+operation+"&from="+(start)+"&to="+(end)+"&whereclause=Y"+"&fs_locn_code="+encodeURIComponent(fs_locn_code)+"&long_desc="+encodeURIComponent(long_desc)+"&holiday_date="+holiday_date+"&orderCols="+orderCols+"&fromPage="+currentPage+"&link=prev&selCheckBoxes=";
		parent.f_query_add_mod.location.href=url;
	}else{
		var conf = confirm(getMessage("DELETE_CANCEL_HOLIDAY_NEXT","FM"));
		if(conf){
			var selValues="";
			var selValues1="";
			/*len=parent.frames[1].document.FMHolidayQueryResult.checkBox.length;
			obj=parent.frames[1].document.FMHolidayQueryResult.checkBox;
			Obj=parent.frames[1].document.FMHolidayQueryResult;*/
			if (Obj.selectall.checked){
				var str="111111111111111";
			}else{
				var str="000000000000000";
			}
			if (len!=null && len!=''){
				for (i=0;i<len;i++){
					if (obj[i].checked){ 
						str=parent.frames[1].replace(str,i+1,'1') ;
						selValues1=Obj.holiday_fs_locn_code[i].value+'$'+Obj.holidayDate[i].value+'|';
						selValues+=selValues1;
					}
				}
			}else if(len==null){
			   if(obj.checked){
				var str="10000000000000";
				selValues=Obj.holiday_fs_locn_code.value+'$'+Obj.holidayDate.value+'|';
				}
			}
			parent.frames[1].document.FMHolidayQueryResult.selectedValues.value=selValues;
			parent.frames[1].document.FMHolidayQueryResult.selCheckBoxes.value=str;
			var fromPage=parent.frames[1].document.FMHolidayQueryResult.currentPage.value;
			parent.frames[1].document.FMHolidayQueryResult.prevnextsubm.value="Y";
			parent.frames[1].document.FMHolidayQueryResult.submit();
			//parent.parent.frames[2].document.getElementById("holiday").rows="8%,28%,*,8%";
		}else{
			ClearAll();
			
			var url="../../eFM/jsp/HolidayForMrdQueryResult.jsp?operation="+operation+"&whereclause=Y"+"&fs_locn_code="+encodeURIComponent(fs_locn_code)+"&long_desc="+encodeURIComponent(long_desc)+"&holiday_date="+holiday_date+"&orderCols="+orderCols+"&fromPage="+currentPage+"&link=prev&selCheckBoxes=";
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
	strsql2.append(" select a.fs_locn_code fs_locn_code,to_char(holiday_date, 'dd/mm/yyyy') holiday_val_date,a.holiday_date,long_desc,REASON_FOR_HOLIDAY, a.facility_id facilityId, to_char(holiday_date,'Day') D   from fm_holiday a,fm_storage_locn b where trunc(holiday_date) >= trunc(sysdate) and a.facility_id ='"+facilityId+"'  and a.facility_id=b.facility_id and a.fs_locn_code=b.fs_locn_code  ");

	strsql2.append(sql);
	
    System.err.println("strsql2.toString()==>"+strsql2.toString());

	rs = stmt.executeQuery(strsql2.toString());
	
	strsql2.setLength(0);

		

	    if ( start != 1 )
		 for( int j=1; j<start; i++,j++ ){
		  rs.next() ;
			}
//out.println("i==>"+i+"==end=>"+end);
			int k=1;
		while ( i<=end && rs.next()  )
		{
		  	if(maxRecord==0)
			{

	%> 
				
<P>

<table  align='right'>
<tr>
<!-- <td  id='display_prev_next' value='as'>
 --><%if ( !(start <= 1) ){%>
<td align ='right' id='prev'><A HREF='javascript:prevRecs("<%=(start-14)%>","<%=(end-14)%>","<%=URLEncoder.encode(sql.toString())%>","<%=currPage%>")' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A></td>	
	<%
}
//if ( !( (start+14) > maxRecord ) )
	{%>
	<td align ='right' id='next' style='visibility:hidden'><A HREF='javascript:nextRecs("<%=(start+14)%>","<%=(end+14)%>","<%=URLEncoder.encode(sql.toString())%>","<%=currPage%>")' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
<%}
sql.setLength(0);
  
%>
</td>
</tr>
</table>
<br><br>
</P>	


<form name='FMHolidayQueryResult' id='FMHolidayQueryResult' method='post' action='../../servlet/eFM.FMHolidayServlet' target='messageFrame'>
	<table id='QRTable' border="1" width="100%" cellspacing='0' cellpadding='0'>
	<tr>	
	<th class='columnheader' align="left"><fmt:message key="eFM.MrdCode.label" bundle="${fm_labels}"/></th>
	<th class='columnheader' align="left"><fmt:message key="eFM.MrdDescription.label" bundle="${fm_labels}"/></th>
	<th class='columnheader' align="left"><fmt:message key="Common.HolidayDate.label" bundle="${common_labels}"/></th>
	<th class='columnheader' align="left"><fmt:message key="eOA.HolidayDay.label" bundle="${oa_labels}"/></th>
	<th class='columnheader' align="left"><fmt:message key="Common.ReasonForHoliday.label" bundle="${common_labels}"/></th>
	<th class='columnheader' align="left"><fmt:message key="Common.selectall.label" bundle="${common_labels}"/><input type='checkbox' name='selectall' id='selectall' onClick='selectAll_S(this);' <%=checked[0]%>></td>	
	</tr>
	<% }
	

		
		String classValue = "" ;
	
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
			String locn_type="";
			String care_locn_desc="";
			String fs_locn_desc="";
			String holiday_date_disp="";
			
			
			String holiday_fs_locn_code 	= "";
			
			 String fs_locn_holiday_date="";
			String reason="";
			String holiday="";
			String clti="";
			 facilityId="";
			 facilityId	=rs.getString("facilityId")==null?"":rs.getString("facilityId");		
			 
			
				
			 fs_locn_desc=rs.getString("long_desc");
			 if(fs_locn_desc == null) fs_locn_desc="";
			   
			   if(!fs_locn_desc.equals("")){			
			       fs_locn_desc = fs_locn_desc.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
                   fs_locn_desc = fs_locn_desc.replaceAll("\\+", "%2B");
				   fs_locn_desc = fs_locn_desc.replaceAll("/[+]/g"," ");
				}		   
			
			 holiday_fs_locn_code 	= rs.getString("fs_locn_code");
			if(holiday_fs_locn_code == null) holiday_fs_locn_code="";
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
			<a href='javascript:modifyFMHoliday("<%=holiday_fs_locn_code%>","<%=fs_locn_holiday_date%>","<%=java.net.URLEncoder.encode(reason)%>","<%=holiday%>","<%=java.net.URLEncoder.encode(fs_locn_desc)%>","<%=facilityId%>")'>
			<%=holiday_fs_locn_code%></a><input type=hidden name='holiday_fs_locn_code' id='holiday_fs_locn_code' value='<%=holiday_fs_locn_code%>'>
			
			<input type=hidden name='chk' id='chk' value='<%=k%>'>
			</td>	
			
			<td class='<%=classValue%>'>

			<a href='javascript:modifyFMHoliday("<%=holiday_fs_locn_code%>","<%=fs_locn_holiday_date%>","<%=java.net.URLEncoder.encode(reason)%>","<%=holiday%>","<%=java.net.URLEncoder.encode(fs_locn_desc)%>","<%=facilityId%>")'>
			<%=fs_locn_desc%></a>
			</td><td class='<%=classValue%>' >
			<a href='javascript:modifyFMHoliday("<%=holiday_fs_locn_code%>","<%=fs_locn_holiday_date%>","<%=java.net.URLEncoder.encode(reason)%>","<%=holiday%>","<%=java.net.URLEncoder.encode(fs_locn_desc)%>","<%=facilityId%>")'><%=holiday_date_disp%></a><input type=hidden name='holidayDate' id='holidayDate' value='<%=fs_locn_holiday_date%>'></td>
			<td class='<%=classValue%>'>
			<a href='javascript:modifyFMHoliday("<%=holiday_fs_locn_code%>","<%=fs_locn_holiday_date%>","<%=java.net.URLEncoder.encode(reason)%>","<%=holiday%>","<%=java.net.URLEncoder.encode(fs_locn_desc)%>","<%=facilityId%>")'> 
			<%=holiday%>&nbsp;</a></td>
			<td class='<%=classValue%>'>
			<a href='javascript:modifyFMHoliday("<%=holiday_fs_locn_code%>","<%=fs_locn_holiday_date%>","<%=java.net.URLEncoder.encode(reason)%>","<%=holiday%>","<%=java.net.URLEncoder.encode(fs_locn_desc)%>","<%=facilityId%>")'> 
			<%=reason%></a></td>
			<td class='<%=classValue%>' align='center'><input type='checkbox' id='check_Box<%=k%>' name='checkBox' onClick='javascript:checkBoxOnClick(this,<%=k%>);'  ></td>	</tr>
			<%
			k=k+1;
			i++;
			maxRecord++;
		}//endwhile
	//}

	if(maxRecord == 0)
	{%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
	<%}
	
	if ( maxRecord < 14 || (!rs.next()) ) {
	%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='hidden';
		</script>
	<% 	} else {%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='visible';
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	<%}

	if(stmt!=null)	stmt.close();
	if(rs!=null)	rs.close();
	


}catch(Exception e){
		out.println(e.toString());
		e.printStackTrace();
}
finally {
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
<input type='hidden' name='fs_locn_code' id='fs_locn_code' value='<%=fs_locn_code%>'>
<input type='hidden' name='long_desc' id='long_desc' value='<%=long_desc%>'>
<input type='hidden' name='holiday_date' id='holiday_date' value='<%=holiday_date%>'>
<input type='hidden' name='operation' id='operation' value='<%=operation%>'>
<input type='hidden' name='orderCols' id='orderCols' value='<%=orderCols%>'>
<input type='hidden' name='maxRecordCount' id='maxRecordCount' value='<%=maxRecord%>'> 
</form>
<br><center>
</center>
</BODY>
</HTML>

