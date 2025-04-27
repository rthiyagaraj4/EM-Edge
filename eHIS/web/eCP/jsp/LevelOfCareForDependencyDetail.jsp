<!DOCTYPE html>


<html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=ISO-8859-1"%>
<jsp:useBean id="LevelOfCareForDependency" class="webbeans.eCommon.RecordSet" scope="session"/> 

<head>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link><script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/messages.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
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
	var level_of_care_code = document.forms[0].level_of_care_code.value;
	var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='LevelOfCareForDependencyDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='level_of_care_code' id='level_of_care_code' value='"+level_of_care_code+"'></form></BODY></HTML>";
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
	
	var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='LevelOfCareForDependencyDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";
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
	String  req_start   =   "", req_end     =   "";
	
        String  checkedOnes         =   "";
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

	effStatus=request.getParameter("effStatus");
	if(effStatus == null) effStatus="";
		Statement stmt=null;
		ResultSet rs=null ;

	Connection con = null;
	try{
			
	con = ConnectionManager.getConnection(request);
	String level_of_care_code=request.getParameter("level_of_care_code");
	String flagSelect = request.getParameter("fromSearch");


	        	if(flagSelect !=null)
	        	{
	        		 LevelOfCareForDependency.clearAll();
	        		 String sqlinsVals= " select dependency_code from cp_loc_for_dependency where level_of_care_code='"+level_of_care_code+"'";
					 stmt3=con.createStatement();
				     rstlRs3 = stmt3.executeQuery(sqlinsVals);
				if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {
						LevelOfCareForDependency.putObject(rstlRs3.getString(1));

					 }
				}
	
	        	}
	        
//	        int recordCount			=	0;

             if(from != null && to != null)
             {
                     int j=0;
                     for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
                     {
                         if(request.getParameter("chk"+(i)) != null)
                         {
                             checkedOnes = request.getParameter("chk"+(i));
                             if(!(LevelOfCareForDependency.containsObject(checkedOnes)))
                                 LevelOfCareForDependency.putObject(checkedOnes);
                             j++;
                         }
                     }
     
            
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
        i = 1 ;
     
			String classValue="";
			String chkAttribute="";
					
String   sql  =" select '"+level_of_care_code+"', dependency_code,long_desc dependency_desc, 'I' db_action from cp_dependency where dependency_code not in(select dependency_code from cp_loc_for_dependency where level_of_care_code = '"+level_of_care_code+"') and eff_status = 'E' union all select '"+level_of_care_code+"', a.dependency_code, b.long_desc dependency_desc, 'U' db_action from cp_loc_for_dependency a, cp_dependency b where level_of_care_code = '"+level_of_care_code+"' and b.dependency_code = a.dependency_code order by 3";
							
				
try{
	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs=stmt.executeQuery(sql);
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();
	  }catch(Exception e){out.println(e);}

%>
<body  OnMouseDown="CodeArrest();" onLoad='chkForSelectAll(<%=start%>,<%=end%>)' class='CONTENT' >
<form name='facility_form_result' id='facility_form_result' action='../../eCP/jsp/LevelOfCareForDependencyDetail.jsp' method='post' >

<table  width=90%' border=0 align='center'>
<tr>
<td align='right' class='NONURGENT'>
<input type=hidden name='level_of_care_code' id='level_of_care_code' value='<%=level_of_care_code%>'>
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
		<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
			<th width='60%'><fmt:message key="Common.Dependency.label" bundle="${common_labels}"/></th>
			<th width='20%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='chkAll' id='chkAll' onClick='selectAll(this,<%=start%>,<%=end%>)'></th>
		<%	 
//		recordCount =	LevelOfCareForDependency.getSize();
		if (start != 0){
				    for(int j=1; j<=start; i++,j++){
					rs.next() ;
				     }
				    }
			while(rs.next() && i<=end){ 
			String dependency_code=rs.getString("dependency_code");
			
			String dependency_desc=rs.getString("dependency_desc");

			if(LevelOfCareForDependency.containsObject(dependency_code))  chkAttribute = "CHECKED";
			else
			chkAttribute="";

			int recordIndex = LevelOfCareForDependency.indexOfObject(dependency_code);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED"))    LevelOfCareForDependency.removeObject(recordIndex);
	
	
				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
				%>
			<tr>
				<td class='<%=classValue%>'><%=dependency_desc%></td>
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>'  value='<%=dependency_code%>'> </td>
			</tr>
			<%
			i++;
			}		
			
			
			 }
			  catch(Exception e){
				  //out.print(e);//common-icn-0181
				  e.printStackTrace();//COMMON-ICN-0181
				  }
			  finally
			  {
				  
							 if(rs != null){ rs.close(); }
							  if(rstlRs3 != null){ rstlRs3.close(); }
				            if(stmt != null){ stmt.close(); }
				   		    if(stmt3 != null){ stmt3.close(); }
					    
				if(con != null)
					ConnectionManager.returnConnection(con,request);

				session.setAttribute("LevelOfCareForDependency", LevelOfCareForDependency);

			  }%>

</table>
</form>
</body>
</html>






