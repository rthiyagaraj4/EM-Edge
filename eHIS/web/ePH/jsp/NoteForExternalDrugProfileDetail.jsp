<!DOCTYPE html>

<html>
	<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>

     <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
	<head>
<% 
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
	   ("PREFERRED_STYLE"):"IeStyle.css";

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="JavaScript" src="../js/NoteForExternalDrugProfile.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	</head>
<%
try{
		String note_group_code	=	request.getParameter("note_group_code")==null?"":request.getParameter("note_group_code");
	    String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	    String selValue="", classValue="";
		boolean selectall=true;
		String bean_id="@NoteForExternalDrugProfileBean";
		String bean_name="ePH.NoteForExternalDrugProfileBean";
		String selected="";
		String note_type_code="";
		ArrayList noteTypeDetails = null;
		
		NoteForExternalDrugProfileBean bean			= (NoteForExternalDrugProfileBean)getBeanObject( bean_id, bean_name, request);
		bean.setLanguageId(locale);
		bean.clear();
		noteTypeDetails = (ArrayList)bean.getNoteTypeForGroup(note_group_code);
		
		int maxRecord = 0;
		if(noteTypeDetails.size()>0)
			maxRecord=noteTypeDetails.size()/5;
		int index=0;
		int count=0;
	    String event_class_desc="";
	    String conf_yn = "";
	    String eff_status="";
	    int count_class = 0;
  	%>
		<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
			<form name='noteTypedetailforGroupform' id='noteTypedetailforGroupform'>
			   <input type='hidden' name='maxRecord' id='maxRecord' value='<%=maxRecord%>'>
	<%
	    if(maxRecord<1) {
  	%>
		<script language="javascript">
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  	<%
			return ;
		}
  	%>

			 <div id="HTab" style="width:100%; overflow:hidden" align='left'>
				<table border="1" align="left" width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<th width='15%'><fmt:message key="ePH.NoteType.label" bundle="${ph_labels}"/></th>
						<th width='20%'><fmt:message key="ePH.NoteDescription.label" bundle="${ph_labels}"/></th>
						<th width='15%'><fmt:message key="Common.Class.label" bundle="${common_labels}"/></th>
						<th width='15%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
						<th width='15%'><fmt:message key="Common.Confidential.label" bundle="${common_labels}"/></th>
						<th width='20%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><input type='checkbox' name='selectall' id='selectall' value="" onclick='selectAll(this, "<%=maxRecord%>");' ></th>
					</tr>
				</table>
			</div>
			<div id="DataTab" style="height:9vh0px; width:100%; overflow-y:auto;" >
				<table border="1" align="left" width='100%' cellpadding="0" cellspacing="0">
	<%           
	                while(count <= maxRecord-1){
						note_type_code = (String)noteTypeDetails.get(index);
						if( (count+1)%2 == 0)  
							classValue="QRYODD";
						else
							classValue="QRYEVEN";
	%>
						<tr>
							<input type='hidden' name='note_type_code<%=count%>' id='note_type_code<%=count%>' value='<%=note_type_code%>'>
							<td class='<%=classValue%>' width='15%'>&nbsp;<%=noteTypeDetails.get(index++)%></td>
							<td class='<%=classValue%>' width='20%'>&nbsp;<%=noteTypeDetails.get(index++)%></td>
	<%                     count_class =index++;
	                        if(noteTypeDetails.get(count_class).equals("PHY$")) 
	                        	event_class_desc="Physician";
							else if(noteTypeDetails.get(count_class).equals("NUR$")) 
								event_class_desc="Nursing";
							else if(noteTypeDetails.get(count_class).equals("CLI$")) 
								event_class_desc="Clinician";
							else if(noteTypeDetails.get(count_class).equals("REF$")) 
								event_class_desc="Referral Letter";
							else if(noteTypeDetails.get(count_class).equals("NTF$")) 
								event_class_desc="Notification Form";
							else if(noteTypeDetails.get(count_class).equals("MDR$")) 
								event_class_desc="Medical Record";
							else if(noteTypeDetails.get(count_class).equals("MDB$")) 
								event_class_desc="Medical Board";
	 							
	%>                    
	     <td class='<%=classValue%>' width='15%'>&nbsp;<%=event_class_desc%></td>
	     <td class='<%=classValue%>' width='15%'>
	<%   
	     eff_status = (String)noteTypeDetails.get(index++);
	     if ( eff_status.equalsIgnoreCase("E") ){
	%>
	        <img src="../../eCommon/images/enabled.gif" align="center">
	             
	<%
	    }
	     else{
	%> 
	    	<img src="../../eCommon/images/disabled.gif" align="center">
	<%
	     } 
	%>
	 	</td>
	 	<td class='<%=classValue%>' width='15%'>
	<% 
	    conf_yn=(String)noteTypeDetails.get(index++);
	     if ( conf_yn.equalsIgnoreCase("Y") ){
	%>
	    	 <img src="../../eCommon/images/enabled.gif" align="center">
	<%
	     }
	     else{
	%>
	         <img src="../../eCommon/images/disabled.gif" align="center">
	<% 
	     } 
	 	 if(bean.getNoteExistsAndEnabled(note_type_code, note_group_code)){
					selected="checked";
					selValue = "Y";
	 	 }
		 else{
					selected="";
					selValue = "N";
					selectall = false;
		}
	%>
	 	</td>
	<% 
	     if ( !eff_status.equalsIgnoreCase("E")){
	%> 
	 	 <td class='<%=classValue%>' width='20%'><input type='checkbox' name='check<%=count%>' id='check<%=count%>'  value='<%=selValue%>' <%=selected%> disabled readonly></td>
	<%
		 }
	     else{ 
	%>
	     <td class='<%=classValue%>' width='20%'><input type='checkbox' name='check<%=count%>' id='check<%=count%>'  value='<%=selValue%>' onclick="dispTypeCheck(this, '<%=note_type_code%>');" <%=selected%>></td>
	<%
	     } 
	%>   
		</tr>
	<%              
					  count++;
		}
						
	%>
		 </table>
	</div>
				<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
				<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
				<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>'>
				<input type='hidden' name='note_group_code' id='note_group_code' value='<%=note_group_code%>'>
				</form>
		</body>
		<script>
	<%
			if(selectall){
	%>
				document.noteTypedetailforGroupform.selectall.checked=true;
				document.noteTypedetailforGroupform.selectall.value="Y";
	<%
			}else{
	%>
				document.noteTypedetailforGroupform.selectall.checked=false;
				document.noteTypedetailforGroupform.selectall.value="N";
	<%
			}
	%>
		</script>
	<% 
	   putObjectInBean(bean_id,bean,request);
}
catch(Exception e){
	e.printStackTrace();
}
%>
</html>

