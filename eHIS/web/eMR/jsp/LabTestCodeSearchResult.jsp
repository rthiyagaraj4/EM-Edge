<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="LabTestforNotifyDise" class="webbeans.eCommon.RecordSet" scope="session"/>  
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'> </script>
	<script language="javascript" src="../../eMR/js/LabTestCodesForNotifDis.js"></script>
</head>
<script>
function submitPrevNext(from, to){

	    document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
		
	    document.forms[0].submit();
		
	}
 function RemSelectAll(obj, i)
{
	

	if(obj.checked == false)
		eval("document.forms[0].removeCode"+i).value = "Y";
	else
		eval("document.forms[0].removeCode"+i).value = "N";
}



function chkForSelectAll(start,end)
{
	if(parent.frames[2].document.forms[0].E.value == 'selectAll')
	{
	document.forms[0].chkAll.checked=true;
	
	
	}

}

</script>
<%
request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String from               = request.getParameter("from") ;
String to                 = request.getParameter("to");
//import
    String selectchkALLChk="";
	String selectchkALL = checkForNull(request.getParameter("selectchkALL") );
	if(selectchkALL.equals("Y"))
	selectchkALLChk="checked";
	else
	selectchkALLChk=" ";
	
	
//import
	String  req_start   =   "", req_end     =   "";
	   String  checkedOnes         =   "";
	   String removeCode = "";


String term_set_id        =request.getParameter("term_set_id");
String flagSelect         = request.getParameter("fromSearch");
String serachCriteriaValue=request.getParameter("serachCriteriaValue");
String searchCriteria     =request.getParameter("search_criteria");
String notifyDisCode      =request.getParameter("notifyDisCode");
String dftchkAttribute="";
String selectCHkChecked   ="";
String selectCHk          =checkForNull(request.getParameter("selectCHk"));
if(selectCHk.equals("Y"))
selectCHkChecked          ="checked";
else
selectCHkChecked          =" ";
int maxRecord             = 0;
int start                 = 0 ;
int end                   = 0 ;
int i                     =1;



if (from == null){start = 0 ;}
else {start = Integer.parseInt(from); }
if (to == null){  end = 12 ; }else{end = Integer.parseInt( to ) ;  }
     
	 req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
       req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");


	    
		String effStatus="";
		//Statement stmt3 = null;
		PreparedStatement stmt3=null;
		ResultSet rstlRs3 = null;
	 
	 effStatus=request.getParameter("effStatus") ;
		if(effStatus == null) effStatus="";
			Statement stmt=null;
			ResultSet rs=null ;

		Connection con = null;
	  
	  
	  try{ 

con = ConnectionManager.getConnection(request);		



		if(flagSelect !=null){  
	        LabTestforNotifyDise.clearAll() ;
	        String sqlinsVals="SELECT TEST_CODE FROM  MR_LABTEST_FOR_NOTIFY_DIS WHERE NOTIFY_DISEASE_CODE=?";
			//stmt3=con.createStatement();
			stmt3 = con.prepareStatement(sqlinsVals);
			stmt3.setString(1,notifyDisCode);
			rstlRs3 = stmt3.executeQuery();
			if(rstlRs3 !=null){
			  while(rstlRs3.next()){ 
			
				LabTestforNotifyDise.putObject(rstlRs3.getString(1));
			   }
			}
	   	}

		if(from != null && to != null){
            int j=0;
            for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++){
                if(request.getParameter("chk"+(i)) != null){  
                    checkedOnes = request.getParameter("chk"+(i));
                    if(!(LabTestforNotifyDise.containsObject(checkedOnes)))
                      LabTestforNotifyDise.putObject(checkedOnes);
                    j++;
                  }else{
                   }
			    removeCode = checkForNull(request.getParameter("removeCode"+(i)));
				if(removeCode.equals("Y"))	{
					String spclt_Code = request.getParameter("Code"+(i));
					if((LabTestforNotifyDise.containsObject(spclt_Code)))	{
						int removeCodeIndex = LabTestforNotifyDise.indexOfObject(spclt_Code) ;
						LabTestforNotifyDise.removeObject(removeCodeIndex);
				   	}
				}				 
            }						
            out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
            out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
          }
		i = 1 ;
		String classValue="";
		String chkAttribute=""; 
		StringBuffer sql = new StringBuffer() ;  
		sql.append("SELECT '"+notifyDisCode+"' , TEST_CODE  TEST_CODE, long_desc test_cod_desc, 'I' db_action from rl_test_code WHERE (status is null or status = 'A')  and test_code NOT IN ( select test_code FROM MR_LABTEST_FOR_NOTIFY_DIS WHERE NOTIFY_DISEASE_CODE='"+notifyDisCode+"') ");
		

		if(serachCriteriaValue!=null && !serachCriteriaValue.equals("") && searchCriteria!=null && searchCriteria.equals("test_code"))
			sql.append(" and Upper(TEST_CODE) LIKE Upper('"+serachCriteriaValue+"%')");
		else if(serachCriteriaValue!=null && !serachCriteriaValue.equals("") && searchCriteria!=null && searchCriteria.equals("test_desc"))
			sql.append(" and Upper(long_desc) LIKE Upper('"+serachCriteriaValue+"%')");
		
	 	 
	 	 sql.append("UNION ALL SELECT   '"+notifyDisCode+"', a.test_code test_code, b.long_desc test_code, 'U' db_action FROM MR_LABTEST_FOR_NOTIFY_DIS a, RL_TEST_CODE b WHERE a.notify_disease_code = '"+notifyDisCode+"' AND b.test_code = a.test_code ");

		if(serachCriteriaValue!=null && !serachCriteriaValue.equals("") && searchCriteria!=null && searchCriteria.equals("test_code"))
			sql.append(" and Upper(b.TEST_CODE) LIKE Upper('"+serachCriteriaValue+"%')");
		else if(serachCriteriaValue!=null && !serachCriteriaValue.equals("") && searchCriteria!=null && searchCriteria.equals("test_desc"))
			sql.append(" and Upper(b.long_desc) LIKE Upper('"+serachCriteriaValue+"%')");
		
		sql.append("  order by 3");	
	
	

	
	try{  
	 stmt=con.createStatement();

	 rs=stmt.executeQuery(sql.toString());
	}catch (Exception e){
		e.printStackTrace();
		//out.println(e); 		 
	}
 
	if (start != 0){
		for(int j=1; j<=start; i++,j++){
			rs.next() ;
		}
	}
	 
	while(i<=end && rs.next() ) { 	 
	  if(maxRecord == 0){ 
 %>
		 <body  OnMouseDown="CodeArrest();" onKeyDown='lockKey()'  onLoad='chkForSelectAll(<%=start%>,<%=end%>)'  class='CONTENT'>
		<form name='facility_form_result' id='facility_form_result' action='../../eMR/jsp/LabTestCodeSearchResult.jsp' method='post' > 
		<table  width='90%' border='0' align='center'>
		<tr>
				<input type=hidden name='from' id='from' value='<%=start%>'>
				<input type=hidden name='to' id='to' value='<%=end%>'>
				<input type=hidden name='start' id='start' value='<%=start%>'>
				<input type=hidden name='end' id='end' value='<%=end%>'>
				 <input type='hidden' name='selectCHk' id='selectCHk' value='<%=selectCHk%>'>
				<input type=hidden name='notifyDisCode' id='notifyDisCode' value='<%=notifyDisCode%>'>
				<input type=hidden name='term_set_id' id='term_set_id' value='<%=notifyDisCode%>'>
				<input type=hidden name='searchCriteria' id='searchCriteria' value='<%=searchCriteria%>'>
				<input type='hidden' name='selectchkALL' id='selectchkALL' value='<%=selectchkALL%>'>
				
			<table  align='right'>
			<tr>
			<%
			if ( !(start <= 1)) {
				out.println("<td align ='right' id='prev' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start-12)+","+(end-12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
		    %>
				<input type=hidden name='whichPage' id='whichPage' value='prev'>
		    <%
			}
			out.println("<td align ='right' id='next' style='visibility:hidden' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start+12)+","+(end+12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
			%> 
				<input type=hidden name='whichPage' id='whichPage' value='next'>
				</tr>
				</table>
				<br>
				<br>
				</tr>
				</table>
				<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
			
			<!-- <fmt:message key="eMR.NotifyDiseases.label" bundle="${mr_labels}"/> -->
			 <tr><td width='20%' height='30' align='center' class="COLUMNHEADER"><fmt:message key="eMR.TEST_CODE.label" bundle="${mr_labels}"/></td>
				<td width='60%' height='30' align='center'  class='COLUMNHEADERCENTER' ><fmt:message key="eMR.TEST_DES.label" bundle="${mr_labels}"/></td> <td width='20%' height='30' align='center' class='COLUMNHEADERCENTER'><fmt:message key="eMR.Select.label" bundle="${mr_labels}"/>
				</td>
				</tr>
			
			<%}
/*
			
	for(int j=1; j<=start; i++,j++){
		rs.next() ;
	}
*/	
	    String test_code=rs.getString("test_code");
	     String test_cod_desc=rs.getString("test_cod_desc");
		 
		 if(LabTestforNotifyDise.containsObject(test_code)) {
			chkAttribute = "CHECKED";
		  }else{
			chkAttribute="";
		}
		int recordIndex = LabTestforNotifyDise.indexOfObject(test_code);
		if(recordIndex!=-1)
		 if(chkAttribute.equals("CHECKED"))   
			LabTestforNotifyDise.removeObject(recordIndex); 
				
	
	    if(i%2 == 0)
			classValue="QRYEVEN";  
		else
		   classValue="QRYODD"; 
	%>
	
	<tr>
		 <td class='<%=classValue%>'><%=test_code%></td>
		<td class='<%=classValue%>'><%=test_cod_desc%></td>
		<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>'  value='<%=test_code%>' onclick="RemSelectAll(this, <%=i%>);"><input type='hidden' name='removeCode<%=i%>' id='removeCode<%=i%>' value=""><input type='hidden' name='Code<%=i%>' id='Code<%=i%>' value="<%=test_code%>"></td>
</tr>	

	 <% i++;
		maxRecord++;
		
		if ( maxRecord < 12 || (!rs.next()) )
				{ 
					%>
					<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='hidden';
					</script>
					<% 
				}
				else
				{  %>
					<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='visible';
					</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



				<%
				}
				  
	if(maxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.frames[1].location.href='../../eCommon/html/blank.html';</script>");
				}
	
	}
	
	if(maxRecord == 0)
				{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.frames[1].location.href='../../eCommon/html/blank.html';</script>");
				}
	
	} catch(Exception e){/* out.print(e); */e.printStackTrace();}
	 finally
	 {
	  if(rs != null){ rs.close(); }
							  if(rstlRs3 != null){ rstlRs3.close(); }
				            if(stmt != null){ stmt.close(); }
				   		    if(stmt3 != null){ stmt3.close(); }
							ConnectionManager.returnConnection(con,request);
				session.setAttribute("LabTestforNotifyDise", LabTestforNotifyDise);
	 
	 
	 }
	%>
	
</table>
</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

