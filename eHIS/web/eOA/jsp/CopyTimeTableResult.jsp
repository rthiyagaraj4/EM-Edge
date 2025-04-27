<!DOCTYPE html>
 
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*" %>
<%%>

<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<script src='../../eOA/js/CopyTimeTable.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function checkAll(){
var len=document.PractTimeTableCopy.nochkbox.value;
	 if(document.PractTimeTableCopy.selected_chk.checked){	 	
	 for(var k=0; k<len; k++){  
	 eval('document.PractTimeTableCopy.selected_'+k).checked=true;	
	 eval('document.PractTimeTableCopy.selected_'+k).value="Y";	 
	}
 }else{  
	for(var k=0; k<len; k++){ 
	  eval('document.PractTimeTableCopy.selected_'+k).checked=false;
      eval('document.PractTimeTableCopy.selected_'+k).value="N";         
	} 
  }
  document.PractTimeTableCopy.nochkbox.value=len;
}

function checkSinglechk(){
 var singchklen=document.PractTimeTableCopy.selected_chk.value;
for(var m=0; m<singchklen; m++){
	if(eval('document.PractTimeTableCopy.selected_'+m).checked){ 
       eval('document.PractTimeTableCopy.selected_'+m).checked=true;	
	   eval('document.PractTimeTableCopy.selected_'+m).value="Y";
    }else{ 
	   eval('document.PractTimeTableCopy.selected_'+m).checked=false;
       eval('document.PractTimeTableCopy.selected_'+m).value="N";
	   if(document.PractTimeTableCopy.selected_chk.checked){	  
	   document.PractTimeTableCopy.selected_chk.checked=false;
	   }	   
    }	 
  }	
}

</script>
<%
request.setCharacterEncoding("UTF-8");	
Connection con = ConnectionManager.getConnection(request);
String resource_class = checkForNull(request.getParameter("resource_class"));
String facilityId = (String) session.getValue( "facility_id" ) ;
String locale=(String)session.getAttribute("LOCALE");
String cliniccode = checkForNull(request.getParameter("clinic_code"));
String day_no = checkForNull(request.getParameter("day_no"));
String start_time = checkForNull(request.getParameter("start_time"));
String end_time = checkForNull(request.getParameter("end_time"));
String res_class = "";
if(resource_class.equals("P")){
	res_class="Practitioner";
}else if(resource_class.equals("R")){
	res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
}else if(resource_class.equals("E")){
	res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
}else if(resource_class.equals("O")){
	res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
}


%>
</head>

<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<form name='PractTimeTableCopy' id='PractTimeTableCopy' action="../../servlet/eOA.TimeTableServlet"  method='post' target='messageFrame'>
	 
	<table border='0' cellpadding='0' cellspacing='0' align='center' width='58%'>
	<tr><th colspan='4' class='COLUMNHEADER' ><fmt:message key="eOA.ResourceDetail.label" bundle="${oa_labels}"/></th></tr>
		<tr>
		<td  width='10%' class='CAGROUPHEADING' ><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
		<td  width='11%' class='CAGROUPHEADING' ><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>	
		<td  width='13%' class='CAGROUPHEADING' ><fmt:message key="Common.resourcename.label" bundle="${common_labels}"/></td>	
		<td width='8%' align='center' class='CAGROUPHEADING'> <fmt:message key="Common.selectall.label" bundle="${common_labels}"/>		
		<input type='checkbox' name='selected_chk' id='selected_chk'  onclick ='checkAll()' value='Y' checked >
		</td>
		</tr>	
	</table>
		
	  <div  style="position:relative;height:290px;vertical-align:top;overflow:auto">  
	<table border='0' cellpadding='0' cellspacing='0' align='center' width='55%'>
	
	<%
	try{			
			String practListSql =  "{call GET_RESOURCE_LIST(?,?,?,?,?,?,?,?)}"; 				
			CallableStatement practListCall = con.prepareCall(practListSql);
            practListCall.setString(1, facilityId);
            practListCall.setString(2, cliniccode);
            practListCall.setString(3, day_no);
            practListCall.setString(4, resource_class);
            practListCall.setString(5, start_time);
            practListCall.setString(6, end_time);
            practListCall.setString(7, locale);
			practListCall.registerOutParameter(8,java.sql.Types.CLOB);
			String practList = "";
			String pre_pract = "";
			String pre_practName = "";
			String practVal = "";
			
            try{
				Clob clob_partList = null;
				int s = 0;
				java.io.Reader reader = null;
				java.io.BufferedReader buffer_reader = null;
				practListCall.execute();		
				clob_partList = (java.sql.Clob) practListCall.getClob(8);	
				if(clob_partList!=null && !clob_partList.equals("")){
						reader = clob_partList.getCharacterStream();
						buffer_reader = new java.io.BufferedReader(reader);
						char[] arr_clob_partList = new char[(int) clob_partList.length()];
						buffer_reader.read(arr_clob_partList, 0,(int) clob_partList.length());
						practList = new String(arr_clob_partList);		
						
						if(practList==null) practList="N";		
		
						StringTokenizer practid 	= new StringTokenizer(practList,"|");		
			
						while(practid.hasMoreTokens()){		
							practVal=practid.nextToken();							
							StringTokenizer practName 	= new StringTokenizer(practVal,"$");	
							while(practName.hasMoreTokens()){		
								pre_pract = practName.nextToken();	
								//pre_practName= practName.nextToken();	
								if (practName.hasMoreTokens()) {
						                pre_practName = practName.nextToken();  // Get the second token (pre_practName)
						            }else{
						            	pre_practName="";
						            }
								%>						
									<tr>
									<td  width='10%' class='labelleft' nowrap ><%=res_class%></td>
									<td width='12%' class='labelleft' nowrap ><%=pre_pract%></td>
									<input type='hidden' name='practitioner_id_<%=s%>' id='practitioner_id_<%=s%>' value='<%=pre_pract%>'></td>					
									<td width='12%' class='labelleft' nowrap ><%=pre_practName%></td>			
									<td width='8%' align='center'>						
									<input type='checkbox' name='selected_<%=s%>' id='selected_<%=s%>'  value='Y' onclick="checkSinglechk()" checked> 
									<%s++;%>
									</td>
									</tr>
								<%					
						   }
						}
						%>
							<input type='hidden' name='nochkbox' id='nochkbox' value='<%=s%>' >
							 </div>
							<%
				}else{%>
					<script>
							alert(getMessage('TIME_TABLE_CREATED','OA'));
							parent.frames[0].document.forms[0].Time_Table_Details.value="";
							parent.frames[1].document.location.href='../../eCommon/html/blank.html'	
							parent.frames[2].document.location.href='../../eCommon/html/blank.html'	
					</script><%
			    }
 			}catch(Exception e1) {			
				e1.printStackTrace();
  		   }
            finally{
					practListCall.close();
 				}
	}catch(Exception e) {
		//out.println(e.toString()); 
		e.printStackTrace();	
	}finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
</table>
</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

