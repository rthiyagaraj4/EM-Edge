<!DOCTYPE html>
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.sql.*,webbeans.eCommon.*,eFM.*,eCommon.Common.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

	     

<html>
<head>
	<%
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../js/DayoftheWeek.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function getValue(day_no,num){
	eval("document.forms[0].day_nof"+num).value=day_no;	
	week_appl1=eval("document.forms[0].week_appl1"+num).value
	if(week_appl1=="A")
	{
		
		
	if(eval("document.forms[0].deflt1"+num).value=='Working Day')
	{
	eval("document.forms[0].default11"+num).options[0].selected=true
	}
    
	eval("document.forms[0].week21"+num).disabled=false
	eval("document.forms[0].week31"+num).disabled=false
	eval("document.forms[0].week41"+num).disabled=false
	eval("document.forms[0].week51"+num).disabled=false
	if(eval("document.forms[0].deflt1"+num).value=='Working Day')
	{
	eval("document.forms[0].default11"+num).options[0].selected=true
	}
	if(eval("document.forms[0].week111"+num).value=='Working Day')
	{
	eval("document.forms[0].week11"+num).options[0].selected=true
	}
	if(eval("document.forms[0].week211"+num).value=='Working Day')
	{
	eval("document.forms[0].week21"+num).options[0].selected=true
	}
	if(eval("document.forms[0].week311"+num).value=='Working Day')
	{
	eval("document.forms[0].week31"+num).options[0].selected=true
	}
	if(eval("document.forms[0].week411"+num).value=='Working Day')
	{
	eval("document.forms[0].week41"+num).options[0].selected=true
	}
	if(eval("document.forms[0].week511"+num).value=='Working Day')
	{
	eval("document.forms[0].week51"+num).options[0].selected=true
	}
	
	
	eval("document.forms[0].default11"+num).disabled=true
	eval("document.forms[0].week11"+num).disabled=true
	eval("document.forms[0].week21"+num).disabled=true
	eval("document.forms[0].week31"+num).disabled=true
	eval("document.forms[0].week41"+num).disabled=true
	eval("document.forms[0].week51"+num).disabled=true
	}else
	{
    
	eval("document.forms[0].default11"+num).disabled=false
	eval("document.forms[0].week11"+num).disabled=false
	eval("document.forms[0].week21"+num).disabled=false
	eval("document.forms[0].week31"+num).disabled=false
	eval("document.forms[0].week41"+num).disabled=false
	eval("document.forms[0].week51"+num).disabled=false
	}
}
function changeOther(obj,dayno,num1){
	var j=num1;
	var dayno=dayno;
	var default2=obj.value;
	
		eval("document.forms[0].week11"+j).value=default2;
		eval("document.forms[0].week21"+j).value=default2;
		eval("document.forms[0].week31"+j).value=default2;
		eval("document.forms[0].week41"+j).value=default2;
		eval("document.forms[0].week51"+j).value=default2;


}
</script>
</head>


<body  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>


<form name='dayoftheweek' id='dayoftheweek' target='messageFrame'>

<br><br><br><br><br>
<table border='0' width='97%' cellpadding='0' cellspacing='0' align='center' >
<tr><td width='6%'>&nbsp;&nbsp;</td>
<td width='17%'>&nbsp;&nbsp;</td>
<td width='15%'>&nbsp;&nbsp;</td>
<td width='' ><b><fmt:message key="eSM.HolidayorWorkingday.label" bundle="${sm_labels}"/>?&nbsp;&nbsp;&nbsp;&nbsp;</b>
</td></tr>
<tr>
<table border='0' width='97%' cellpadding='0' cellspacing='0' align='center'>
	
    <th width='6%' align='center' wrap><b><fmt:message key="eSM.DayNo.label" bundle="${sm_labels}"/></b></th> 
	<th width='10%' align='center' wrap><b><fmt:message key="Common.dayofweek.label" bundle="${common_labels}"/></b></th>
	<th width='8%' align='center'><b><fmt:message key="eSM.WeekAppl.label" bundle="${sm_labels}"/></b></th>
	<th width='5%' align='center'><b><fmt:message key="Common.Default.label" bundle="${common_labels}"/></b></th> 
	<th width='5%' align='center'><b><fmt:message key="Common.Week.label" bundle="${common_labels}"/> 1</b></th>
	<th width='5%' align='center'><b><fmt:message key="Common.Week.label" bundle="${common_labels}"/>  2</b></th>
	<th width='5%' align='center'><b><fmt:message key="Common.Week.label" bundle="${common_labels}"/>  3</b></th> 
	<th width='5%' align='center'><b><fmt:message key="Common.Week.label" bundle="${common_labels}"/>  4</b></th>
	<th width='5%' align='center'><b><fmt:message key="Common.Week.label" bundle="${common_labels}"/>  5</b></th>
	<% 
	 request.setCharacterEncoding("UTF-8");
	Connection con = ConnectionManager.getConnection(request);
	
	boolean isSitespecificparam=false;//Added for this CRF HSA-CRF-0306.1
	
	try{
	
	isSitespecificparam = CommonBean.isSiteSpecific(con,"FM","CURRENT_FS_LOCATION");//Added for this CRF HSA-CRF-0306.1
		
	Statement stmt = null;
	ResultSet rs=null;
	String day_no="" ;
	String disabled="";
	String day_of_week="";
	String week_appl="";
	String default1="";
	String week1="";
	String week2="";
	String week3="";
	String week4="";
	String week5="";
	String ws="";
	String hs="";
	String ws1="";
	String hs1="";
	String ws2="";
	String hs2="";
	String ws3="";
	String hs3="";
	String ws4="";
	String hs4="";
	String ws5="";
	String hs5="";
	String ws6="";
	String hs6="";
		
	
	String sql="Select DAY_NO,DAY_OF_WEEK,Decode(WEEK_APPLICABILITY, 'A','For All Weeks of the Month', 'W','By Specific Week of the Month')Week_Appl, Decode(DAY_TYPE, 'W', 'Working Day', 'H', 'Holiday') Default1, Decode(DAY_TYPE_WEEK_1, 'W', 'Working Day', 'H', 'Holiday', Null) DAY_TYPE_WEEK_1,Decode(DAY_TYPE_WEEK_2, 'W', 'Working Day', 'H', 'Holiday', Null) DAY_TYPE_WEEK_2, Decode(DAY_TYPE_WEEK_3, 'W', 'Working Day', 'H', 'Holiday', Null) DAY_TYPE_WEEK_3, Decode(DAY_TYPE_WEEK_4, 'W', 'Working Day', 'H', 'Holiday', Null) DAY_TYPE_WEEK_4, Decode(DAY_TYPE_WEEK_5, 'W', 'Working Day', 'H', 'Holiday', Null) DAY_TYPE_WEEK_5 From SM_DAY_OF_WEEK Order by DAY_NO";

		stmt = con.createStatement() ;
		rs = stmt.executeQuery(sql) ;
		int i=0;
		while(rs.next())
		{
			day_no=rs.getString(1);
			day_of_week=rs.getString(2);
			week_appl=rs.getString(3);
			if(week_appl == null) week_appl="";
			default1=rs.getString(4);
			week1=rs.getString(5);
			week2=rs.getString(6);
			week3=rs.getString(7);
			week4=rs.getString(8);
			week5=rs.getString(9);
		
%>

	<tr>
	<td class='label' name='day_no1<%=i%>' width='6%' align='center' wrap >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=day_no%>&nbsp;&nbsp<input type=hidden name='day_nof<%=i%>' id='day_nof<%=i%>' ></td>
		
	<td  width='10%' align='center' wrap class='label' name='day_of_week1<%=i%>' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=day_of_week%>&nbsp;&nbsp
	
	<td class="fields">
	<%
			ws="";
		hs=""; 
		
	if(week_appl.equals("For All Weeks of the Month")){ 
		disabled="disabled";
		 ws="Selected";
	}else {
		 disabled="";
		 hs="Selected";
	}%>
		<select name='week_appl1<%=i%>' id='week_appl1<%=i%>' width='8%' align='center' onChange='getValue(<%=day_no%>,<%=i%>);' >
		<option value='A' <%=ws%>>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.all.label" bundle="${common_labels}"/>&nbsp;&nbsp;</option>
		 <option value='W' <%=hs%>> &nbsp;&nbsp;<fmt:message key="Common.specific.label" bundle="${common_labels}"/>&nbsp;&nbsp;</option>
		</select></td>
					
 <td class="fields">
 <% 
	 	ws1="";
		hs1="";
			 
		 if(default1.equals("Working Day")){ 
		 ws1="Selected";
	}else {
		 hs1="Selected";
	}%>
        <select width='5%' align='center' <%=disabled%> name='default11<%=i%>' onChange='changeOther(this,<%=day_no%>,<%=i%>);getValue(<%=day_no%>,<%=i%>);'>
		<option value='W' <%=ws1%>>&nbsp;&nbsp;W&nbsp;&nbsp;</option>
		<option value='H' <%=hs1%>>&nbsp;&nbsp;H&nbsp;&nbsp;</option>
		</select></td>
 <td class="fields">
	<%
		ws2="";
		hs2="";
	if(week1.equals("Working Day")){ 
		ws2="Selected";
	}else {
		 hs2="Selected";
	} %>
        <select width='5%' align='center' name='week11<%=i%>' id='week11<%=i%>' <%=disabled%> onChange='getValue(<%=day_no%>,<%=i%>);'>
		<option value='W' <%=ws2%>>&nbsp;&nbsp;W&nbsp;&nbsp;</option>
		<option value='H' <%=hs2%>>&nbsp;&nbsp;H&nbsp;&nbsp;</option>
		</select></td>
											
 <td class="fields">
	<% 
		ws3="";
		hs3="";	 
	 if(week2.equals("Working Day")){ 
		 ws3="Selected";
	}else {
		 hs3="Selected";
	} %>
    <select name='week21<%=i%>' id='week21<%=i%>' <%=disabled%> width='5%' align='center' onChange='getValue(<%=day_no%>,<%=i%>);'>
	<option value='W' <%=ws3%>>&nbsp;&nbsp;W&nbsp;&nbsp;</option>						
	<option value='H' <%=hs3%>>&nbsp;&nbsp;H&nbsp;&nbsp;</option>
	</select></td>
    <input type ='hidden' name='deflt1<%=i%>' id='deflt1<%=i%>' value='<%=default1%>' >
	<input type =hidden name='week111<%=i%>' id='week111<%=i%>' value='<%=week1%>' >
	<input type =hidden name='week211<%=i%>' id='week211<%=i%>' value='<%=week2%>' >
	<input type =hidden name='week311<%=i%>' id='week311<%=i%>' value='<%=week3%>' >
	<input type =hidden name='week411<%=i%>' id='week411<%=i%>' value='<%=week4%>' >
	<input type =hidden name='week511<%=i%>' id='week511<%=i%>' value='<%=week5%>' >
    
<td class="fields">
	<% 
		ws4="";
		hs4="";	 
	 if(week3.equals("Working Day")){ 
		 ws4="Selected";
	}else {
		 hs4="Selected";
	} %>
    <select name='week31<%=i%>' id='week31<%=i%>'  <%=disabled%> width='5%' align='center' onChange='getValue(<%=day_no%>,<%=i%>);'>
	<option value='W' <%=ws4%>>&nbsp;&nbsp;W&nbsp;&nbsp;</option>
	<option value='H' <%=hs4%>>&nbsp;&nbsp;H&nbsp;&nbsp;</option></select></td>      		    
 <td class="fields">
	<% 
		ws5="";
		hs5="";	 
	if(week4.equals("Working Day")){ 
		 ws5="Selected";
	}else {
		hs5="Selected";
	} %>
    <select name='week41<%=i%>' id='week41<%=i%>' <%=disabled%> width='5%' align='center' onChange='getValue(<%=day_no%>,<%=i%>);'>
	<option value='W' <%=ws5%>>&nbsp;&nbsp;W&nbsp;&nbsp;</option>
	<option value='H' <%=hs5%>>&nbsp;&nbsp;H&nbsp;&nbsp;</option>
	</select></td>
<td class="fields">
	<% 
		ws6="";
		hs6="";	 
 if(week5.equals("Working Day")){ 
		 ws6="Selected";
	}else {
		 hs6="Selected";
	} %>
	<select name='week51<%=i%>' id='week51<%=i%>' <%=disabled%> width='5%' align='center' onChange='getValue(<%=day_no%>,<%=i%>);'>
	<option value='W' <%=ws6%>>&nbsp;&nbsp;W&nbsp;&nbsp;</option>			
	<option value='H' <%=hs6%>>&nbsp;&nbsp;H&nbsp;&nbsp;</option>
	 </select></td>
	
	

	</tr>
			
		
		
	<% 
	i++;

	}
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	%>
		
</table>
</tr>
</table>

   <input type=hidden name='i' id='i' value='<%=i%>'>
   <!--Added for this CRF HSA-CRF-0306.1 -->   
   <input type=hidden name="isSitespecificparam" id="isSitespecificparam" value="<%=isSitespecificparam%>"> 
		</form>
      	</body>
      	</html>
		<%
		}catch(Exception e){out.println(e);}
		finally { 
			ConnectionManager.returnConnection(con,request);
}			
		%>




