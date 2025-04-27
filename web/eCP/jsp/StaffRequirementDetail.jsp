<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sreelatha
*	Created On		:	10 Jan 2005

--%>
<html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=ISO-8859-1"%>
<jsp:useBean id="StaffRequirement" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="StaffRequirementwday" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="StaffRequirementnwday" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="StaffRequirementhday" class="webbeans.eCommon.RecordSet" scope="session"/> 


<head>
<%
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link><script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/messages.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language="JavaScript" src="../../eCP/js/StaffRequirement.js"></script>
<script language="javascript" src="../js/CpMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
<script>
       
	function submitPrevNext(from, to){
	    document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
	    document.forms[0].submit();
	}

function selectAll(Obj,start,end)
{

	if(Obj.checked)
	{
	for(var i=start;i<=end;i++)
		{
		if(eval("document.forms[0].chk"+i))
		eval("document.forms[0].chk"+i).checked=true;
		}
	var workplace_code = document.forms[0].workplace_code.value;
	var facility_id=document.forms[0].facility_id.value;
	var shift_code=document.forms[0].shift_code.value;
	var dependency_code=document.forms[0].dependency_code.value;
	var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='StaffRequirementDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='workplace_code' id='workplace_code' value='"+workplace_code+"'><input type='hidden' name='facility_id' id='facility_id' value='"+facility_id+"'><input type='hidden' name='shift_code' id='shift_code' value='"+shift_code+"'><input type='hidden' name='dependency_code' id='dependency_code' value='"+dependency_code+"'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();
	}
	else
	{
		for(var i=start;i<=end;i++)
			{
			if(eval("document.forms[0].chk"+i))
			eval("document.forms[0].chk"+i).checked=false;
			}
	
	var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='StaffRequirementDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();
	}
}

function chkForSelectAll(start,end)
{
	if(parent.frames[2].document.forms[0].E.value == 'selectAll')
	{
	document.forms[0].chkAll.checked=true;
	selectAll(document.forms[0].chkAll,start,end)
	}

}
</script>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String spcode="";
	//String spname="";
	
	String  req_start   =   "", req_end     =   "";
	
        String  checkedOnes         =   "",checkedWday="",checkedNWday="",checkedHday="";
        String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;
        int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
       
       req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
       req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

	String effStatus="";
	Statement stmt3 = null;
	ResultSet rstlRs3 = null;
	PreparedStatement pstmt = null;//common-icn-0180

	effStatus=request.getParameter("effStatus");
	if(effStatus == null) effStatus="";
		Statement stmt=null;
		ResultSet rs=null ;

	Connection con = null;
	try{
			
	con = ConnectionManager.getConnection(request);

	
	//String dat="";
	//String facility="";
	//String pract="";
	//String en="";
	//String fnval="insert";
	//String id="";
	//String fname="";
	//String prname="";
	//String ps="";

	String facility_id=request.getParameter("facility_id");
	String workplace_code = request.getParameter("workplace_code");
	String shift_code = request.getParameter("shift_code");
	String dependency_code = request.getParameter("dependency_code");

	String flagSelect = request.getParameter("fromSearch");
	String wday_hours="" ;
	String nwday_hours="";
	String hday_hours="";


	        	if(flagSelect !=null)
	        	{
	        		StaffRequirement.clearAll();
					StaffRequirementwday.clearAll();
					StaffRequirementnwday.clearAll();
					StaffRequirementhday.clearAll();

	        		 //String sqlinsVals= "select position_code,wday_hours,nwday_hours,hday_hours from cp_staff_requirement where facility_id='"+facility_id+"' and workplace_code='"+workplace_code+"' and shift_code='"+shift_code+"'and dependency_code='"+dependency_code+"'";//common-icn-0180
	        		 String sqlinsVals= "select position_code,wday_hours,nwday_hours,hday_hours from cp_staff_requirement where facility_id= ? and workplace_code= ? and shift_code= ? and dependency_code= ?";//common-icn-0180
	 				
	        		//common-icn-0180 starts
				 //stmt3=con.createStatement();//common-icn-0180
				 pstmt=con.prepareStatement(sqlinsVals);
				 pstmt.setString(1, facility_id);
				 pstmt.setString(2, workplace_code);
				 pstmt.setString(3, shift_code);
				 pstmt.setString(4, dependency_code);
				 //rstlRs3 = stmt3.executeQuery(sqlinsVals);//common-icn-0180
				 rstlRs3 = pstmt.executeQuery();
				//common-icn-0180 ends
				if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {
						StaffRequirement.putObject(rstlRs3.getString(1));
						 wday_hours = rstlRs3.getString("wday_hours");
						 nwday_hours=rstlRs3.getString("nwday_hours");
						 hday_hours=rstlRs3.getString("hday_hours");
						if(wday_hours == null) wday_hours="";
				    	StaffRequirementwday.putObject(wday_hours);
						if(nwday_hours == null) nwday_hours="";
				    	StaffRequirementnwday.putObject(nwday_hours);
						if(hday_hours == null) hday_hours="";
				    	StaffRequirementhday.putObject(hday_hours);
						
					 }
				}
	
	        	}

             if(from != null && to != null)
             {
                     int j=0;
                     for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
                     {
                         if(request.getParameter("chk"+(i)) != null || request.getParameter("wday_hours"+(i)) != null || request.getParameter("nwday_hours"+(i)) != null|| request.getParameter("hday_hours"+(i)) != null)
                         {
                             checkedOnes = request.getParameter("chk"+(i));
							 checkedWday=request.getParameter("wday_hours"+(i));
							 if(checkedWday == null) checkedWday="";
							 checkedNWday=request.getParameter("nwday_hours"+(i));
							if(checkedNWday == null) checkedNWday="";
							checkedHday=request.getParameter("hday_hours"+(i));
							if(checkedHday == null) checkedHday="";
                       
                             if(!(StaffRequirement.containsObject(checkedOnes) &&!StaffRequirementwday.containsObject(checkedWday)&&!StaffRequirementnwday.containsObject(checkedNWday)&&!StaffRequirementhday.containsObject(checkedHday) )) { 
								 
                                 StaffRequirement.putObject(checkedOnes);
								 StaffRequirementwday.putObject(checkedWday);
								StaffRequirementnwday.putObject(checkedNWday);
								   StaffRequirementhday.putObject(checkedHday);
							 }

                             j++;
                         }
                         
                     }
     
            
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
        i = 1 ;
     
			String classValue="";
			String chkAttribute="";
			//String eff_status="",selectyn="";
			

	

	//String sql=" select  position_code,position_desc,to_number(null) wday_hours,to_number(null) nwday_hours,to_number(null) hday_hours,'l' db_action from am_position where position_code not in(select position_code from cp_staff_requirement where facility_id='"+facility_id+"' and workplace_code= '"+workplace_code+"' and shift_code= '"+shift_code+"' and dependency_code='"+dependency_code+"')and role_type='P' and eff_status='E' and position_code in(select position_code from rs_shift_for_position where shift_code= '"+shift_code+"') union all select a.position_code,b.position_desc,wday_hours,nwday_hours,hday_hours,'U' db_action from cp_staff_requirement a,am_position b where a.facility_id= '"+facility_id+"' and a.workplace_code= '"+workplace_code+"' and a.shift_code= '"+shift_code+"'  and a.dependency_code='"+dependency_code+"' and b.position_code=a.position_code and b.role_type='P' order by 2 ";//common-icn-0180
	String sql=" select  position_code,position_desc,to_number(null) wday_hours,to_number(null) nwday_hours,to_number(null) hday_hours,'l' db_action from am_position where position_code not in(select position_code from cp_staff_requirement where facility_id=? and workplace_code= ? and shift_code= ? and dependency_code=?)and role_type='P' and eff_status='E' and position_code in(select position_code from rs_shift_for_position where shift_code= ?) union all select a.position_code,b.position_desc,wday_hours,nwday_hours,hday_hours,'U' db_action from cp_staff_requirement a,am_position b where a.facility_id= ? and a.workplace_code= ? and a.shift_code= ?  and a.dependency_code=? and b.position_code=a.position_code and b.role_type='P' order by 2 ";//common-icn-0180
	
				
		
try{
	//common-icn-0180 starts
	//stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//common-icn-0180
	 pstmt=con.prepareStatement(sql);
	 pstmt.setString(1, facility_id);
	 pstmt.setString(2, workplace_code);
	 pstmt.setString(3, shift_code);
	 pstmt.setString(4, dependency_code);
	 pstmt.setString(5, shift_code);
	 pstmt.setString(6, facility_id);
	 pstmt.setString(7, workplace_code);
	 pstmt.setString(8, shift_code);
	 pstmt.setString(9, dependency_code);
	//rs=stmt.executeQuery(sql);//common-icn-0180
	rs=pstmt.executeQuery();
	//common-icn-0180 ends
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();
	  }catch(Exception e){
		 // out.println(e);//COMMON-ICN-0181
             e.printStackTrace();//COMMON-ICN-0181
		  }

%>
<body  OnMouseDown="CodeArrest();" onLoad='chkForSelectAll(<%=start%>,<%=end%>)' class='CONTENT' >
<form name='facility_form_result' id='facility_form_result' action='../../eCP/jsp/StaffRequirementDetail.jsp' method='post' >

<table  width='98%' border=0 align='center'>
<tr>
<td align='right' class='NONURGENT'>
<input type=hidden name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type=hidden name='workplace_code' id='workplace_code' value='<%=workplace_code%>'>
	<input type=hidden name='shift_code' id='shift_code' value='<%=shift_code%>'>
	<input type=hidden name='dependency_code' id='dependency_code' value='<%=dependency_code%>'>
	<input type=hidden name='maxRecord' id='maxRecord' value='<%=maxRecord%>'>
<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>

<input type=hidden name='from' id='from' value='<%=start%>'>
<input type=hidden name='to' id='to' value='<%=end%>'>
<input type=hidden name='start' id='start' value='<%=start%>'>
<input type=hidden name='end' id='end' value='<%=end%>'>
<input type='hidden' name='function_name' id='function_name' value='insert'>
<input type='hidden' name='allValues' id='allValues' value=''>


<%
    if ( !(start <= 1)) {
%>
    <a href='javascript:submitPrevNext(<%=(start-12)%>,<%=(end-12)%>)' text-decoration='none'>Previous</a>
    <input type=hidden name='whichPage' id='whichPage' value='prev'>

<%
    }
    if ( !((start+12) >= maxRecord )){
%>
    <a href='javascript:submitPrevNext(<%=(start+12)%>,<%=(end+12)%>)' text-decoration='none'>Next</a>
    <input type=hidden name='whichPage' id='whichPage' value='next'>
<%
    }
%>
</td>
</tr>
</table>
		<table border='1' cellpadding='0' cellspacing='0' width='98%' align='center'>
	<tr>
			<th rowspan='2'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></th>
			<th colspan='3'>Working Hours</th>
			<th  rowspan='2' width='5%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='chkAll' id='chkAll' onClick='selectAll(this,<%=start%>,<%=end%>)'></th>
				</tr>
				<tr>
				<th>WDay&nbsp;<img  src='../../eCommon/images/mandatory.gif'align='center'></img></th> 
			<th >NWDay&nbsp;<img  src='../../eCommon/images/mandatory.gif'align='center'></img></th> 
			<th >HDay&nbsp;<img  src='../../eCommon/images/mandatory.gif'align='center'></img></th> 
				</tr>

		<%	 
		if (start != 0){
				    for(int j=1; j<=start; i++,j++){
					rs.next() ;
				     }
				    }
			while(rs.next() && i<=end){ 
			String position_code=rs.getString("position_code");
						
			String position_desc=rs.getString("position_desc");
			

			if(StaffRequirement.containsObject(position_code)) 
				{
				chkAttribute = "CHECKED";
			
				}
			else
				{
			chkAttribute="";
		
				}

			int recordIndex = StaffRequirement.indexOfObject(position_code);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED"))    
				{
				StaffRequirement.removeObject(recordIndex);
				wday_hours=(String)StaffRequirementwday.getObject(recordIndex);
				System.err.println("wday_hours"+wday_hours);
				StaffRequirementwday.removeObject(recordIndex);
				nwday_hours=(String)StaffRequirementnwday.getObject(recordIndex);
				System.err.println("nwday_hours"+nwday_hours);

				StaffRequirementnwday.removeObject(recordIndex);

				hday_hours=(String)StaffRequirementhday.getObject(recordIndex);
				System.err.println("hday_hours"+hday_hours);

				
				StaffRequirementhday.removeObject(recordIndex);

				}
				else
				{
					wday_hours="";
					nwday_hours="";
					hday_hours="";
				}
	
	
				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
				%>
			<tr>
				<td class='<%=classValue%>'><%=position_desc%></td>
					<td class='<%=classValue%>' align='center'><input type='text' name='wday_hours<%=i%>' id='wday_hours<%=i%>' size='3' maxlength='3' onblur='CheckMin(this);check24(this);' onkeypress="return allowPositiveNumber()"  value=<%=wday_hours%>></td>
				<td class='<%=classValue%>' align='center'><input type='text' name='nwday_hours<%=i%>' id='nwday_hours<%=i%>' size='3' maxlength='3' onblur='CheckMin(this);check24(this);' onkeypress="return allowPositiveNumber()"  value=<%=nwday_hours%>></td>
					<td class='<%=classValue%>' align='center'><input type='text' name='hday_hours<%=i%>' id='hday_hours<%=i%>' size='3' maxlength='3' onblur='CheckMin(this);check24(this);' onkeypress="return allowPositiveNumber();"  value=<%=hday_hours%>></td>
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>'  value='<%=position_code%>'> </td>
			</tr>
			<%
			i++;
				
				wday_hours="";
					nwday_hours="";
					hday_hours="";
				
			}		
			
			
			 }
			  catch(Exception e){out.print(e);}
			  finally
			  {
				  
							 if(rs != null){ rs.close(); }
							  if(rstlRs3 != null){ rstlRs3.close(); }
				            if(stmt != null){ stmt.close(); }
				            if(pstmt != null){ pstmt.close(); }//common-icn-0180
				   		    if(stmt3 != null){ stmt3.close(); }
					    

				ConnectionManager.returnConnection(con,request);
				session.setAttribute("StaffRequirement", StaffRequirement);
				session.setAttribute("StaffRequirementwday", StaffRequirementwday);
				session.setAttribute("StaffRequirementnwday", StaffRequirementnwday);
				session.setAttribute("StaffRequirementhday", StaffRequirementhday);

			  }%>

</table>

</form>
</body>
</html>






