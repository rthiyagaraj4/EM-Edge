<!DOCTYPE html>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);//MMS-ME-SCF-0038
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
webbeans.eCommon.RecordSet NoteTypeServiz = (webbeans.eCommon.RecordSet)getObjectFromBean("NoteTypeServiz","webbeans.eCommon.RecordSet",session);
%>


<html>
<head>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!-- <modifeid by Arvind @06-12-2008> -->

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js'></script>
	  <Script language='javascript' src='../js/NoteTypeByService.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
    
</head>
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form name='NoteTypeByServiceSecond_form' id='NoteTypeByServiceSecond_form' action="AddModifyNoteTypeByServiceDetail.jsp"  method='post' target='messageFrame'>
<%
	Connection con  = null;
	

	String classValue	= "";
	String from			= request.getParameter("from") ;
	String to			= request.getParameter("to") ;
	String checkedOnes	= "";
	String  req_start   =   "", req_end     =   "";

	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=1;
	
	if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 14 ; }   else {  end = Integer.parseInt( to ) ; }


	req_start       =   (request.getParameter("start")==null)   ?   "0" : request.getParameter("start");
	req_end         =   (request.getParameter("end")==null)     ?   "0" : request.getParameter("end");

	String facility_id = (String)session.getValue("facility_id");
	String service_code = request.getParameter("service_code");
		if(service_code == null) service_code = ""; 

	String dept_id = request.getParameter("dept_id");
		if(dept_id == null) dept_id = "";

	String note_type = request.getParameter("note_type");
		if(note_type == null) note_type = "";

	String occurance = request.getParameter("occurance");

	if(occurance == null) {
			occurance = "";
			NoteTypeServiz.clearAll();
		}

	String checkVal = request.getParameter("checkVal");
		if(checkVal == null) checkVal = "";

	if(from != null && to != null) {
			int j=0;
			for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++){
				if(request.getParameter("chk"+(i-1)) != null) {
					checkedOnes = request.getParameter("chk"+(i-1));
					if(!(NoteTypeServiz.containsObject(checkedOnes))){
						NoteTypeServiz.putObject(checkedOnes);
					}

					j++;
				}
				
			}

   
		out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	}

	 putObjectInBean("NoteTypeServiz", NoteTypeServiz,session);

	i = 1	 ;
	String whereString="";
	if(dept_id.equals("") || dept_id == null || dept_id.equals("null"))
	{
		whereString="";
	}
	else
	{
		whereString=" and dept_code ='"+dept_id+"' ";
	}

	StringBuffer sql1 = new StringBuffer();

	sql1.append("Select distinct SERVICE_SHORT_DESC SERVICE_DESC,SERVICE_CODE , (select 'Y' from CA_NOTE_TYPE_BY_SERV_VW where facility_id =a.OPERATING_FACILITY_ID and note_type= ? and service_code=a.service_code) checked from AM_FACILITY_SERVICE_vw a where OPERATING_FACILITY_ID=? ");
	sql1.append(whereString);
	sql1.append("and EFF_STATUS='E' ORDER BY 1");

		
	try{		
		PreparedStatement stmt  = null;
		ResultSet rs = null;	
		con = ConnectionManager.getConnection(request);
		stmt = con.prepareStatement(sql1.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
		stmt.setString(1,note_type);
		stmt.setString(2,facility_id);
	
		rs = stmt.executeQuery();	
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();
		
%>	
	<input type=hidden name='pages' id='pages' value='single'>
	<input type=hidden name='totChecked' id='totChecked' value='0'>
	
	<table cellpadding='3' cellspacing='0' border='0' width='90%' align="center" >
	<tr>
	<td class='white' width='65%'></td> 
	<td  align='right' width='15%'>
	<%
		if ( !(start <= 1)) {
	%>
		<a class='gridLink'  href='javascript:submitPrevNext(<%=(start-14)%>,<%=(end-14)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
		<input type=hidden name='whichPage' id='whichPage' value='prev'>
	<%
		}
		if ( !((start+14) > maxRecord )){
	%>
		<a class='gridLink' href='javascript:submitPrevNext(<%=(start+14)%>,<%=(end+14)%>)' text-decoration='none'>&nbsp;<fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
		<input type=hidden name='whichPage' id='whichPage' value='next'>
	<%
		}
	%>
	
	</td>
	</tr>
	</table>
		  
	  
	  <table align="CENTER" style="border: 1px solid black;" border='1' cellpadding='3' cellspacing='0' width='90%'  id=tableId>
		<td class='COLUMNHEADERCENTER' ><fmt:message key="eCA.Services.label" bundle="${ca_labels}"/></td><td class='COLUMNHEADERCENTER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><input type='checkbox' name=selectAll  onclick='selectAllServices(this);'></td>
<%			 
		 String service_cod = "";
		 String service_desc = "";
		 String checkStatus  = "";	
		 String checkProp = "";
		 String flag	  = "N";
		 int ilCkeckedYN = 0;
		 int recordCount = 0;

		if (start != 0){
            for(int j=1; j<start; i++,j++){
                rs.next() ;
             }
             ilCkeckedYN+=start;
             --ilCkeckedYN ;
//			 start++;
			 
        }

		
		recordCount			=	NoteTypeServiz.getSize();
		

		 if(rs!= null) {
			while(rs.next()&& i<=end) {
			 // ilRow = ilRow + 1;

			  service_cod = rs.getString("SERVICE_CODE");
			  service_desc = rs.getString("SERVICE_DESC");
			  checkStatus =  rs.getString("checked")==null?"":rs.getString("checked");
			  if(checkStatus.trim().equals("Y"))
				{
					flag	  = "Y";
				}
				else
				{
					flag	  = "N";
				}
            try {
                if(NoteTypeServiz.containsObject(service_cod))  checkStatus = "Y";
                //else if(!checkStatus.equals("Y"))  checkStatus = "N";
				
                int recordIndex = NoteTypeServiz.indexOfObject(service_cod);
                if(recordIndex!=-1){
					if(checkStatus.equals("Y")){
						NoteTypeServiz.removeObject(recordIndex);
					}
				}
            } catch(Exception e) {
                //out.println("Exception@containsObject in AddModifyNoteTypeByServiceDeatil.jsp: "+e.toString());//common-icn-0181
               e.printStackTrace();//COMMON-ICN-0181
	    }
		
				if(checkStatus.trim().equals("Y")) {
					checkProp = " CHECKED "; 
					
				} else {
					checkProp = "";
					
				}


				if ( i % 2 == 0 ) 
					classValue = "QRYEVEN" ;
				else 
					classValue = "QRYODD" ;
%>
				
				<tr><td  class='gridData'   ><%=service_desc%></td>
					<td  class='gridData'   width='25%' >
	
					<input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value='<%=service_cod%>' <%=checkProp%> ><input type=hidden name="flag<%=ilCkeckedYN%>" id="flag<%=ilCkeckedYN%>" value='<%=flag%>'>
					
				</td>	
				</tr>
<%
				ilCkeckedYN = ilCkeckedYN + 1;
				i = i+1;
				//out.println(i);
			}
			out.println("<input type=hidden name='count' id='count' value="+(ilCkeckedYN-1)+">");
			out.println("<input type='hidden' name='note_type' id='note_type' value='"+ note_type +"'>");
 			out.println("<input type='hidden' name='recordCount' id='recordCount' value='"+ recordCount +"'>");
			out.println("<input type=hidden name=occurance value='next'>");
			
		 }	
	
	
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
             
			}catch(Exception e){
		//out.println("Exception in AddModifyNoteTypeByServiceDetail.jsp"+e.toString());//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
	}finally{
            if(con != null)ConnectionManager.returnConnection(con,request);
           // session.setAttribute("NoteTypeServize", NoteTypeServiz);
		  
    }
		

%>
	<input type=hidden name=from value='<%=start%>'>
	<input type=hidden name=to value='<%=end%>'>
	<input type=hidden name='start' id='start' value='<%=start%>'>
	<input type=hidden name='end' id='end' value='<%=end%>'>
	<input type=hidden name='dept_id' id='dept_id' value='<%=dept_id%>'>

</table>	
</form>
</body>
<script>
	var start=eval(document.forms[0].from.value)-1;
	var end=eval(document.forms[0].end.value)-1;
	var flag=true;
	for(i=start;i<=end;i++)
	{
		if(eval("document.forms[0].chk"+i)!=null)
		{
			var obj=eval("document.forms[0].chk"+i);
			if(!obj.checked)
			{
				flag=false;
			}
		}
	}
	if(flag)
		document.forms[0].selectAll.checked=true;
</script>
</html>

