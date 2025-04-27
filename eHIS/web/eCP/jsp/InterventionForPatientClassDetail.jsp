<!DOCTYPE html>
<html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="InterventionPatient" class="webbeans.eCommon.RecordSet" scope="session"/> 
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function submitPrevNext(from, to)
{
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
	var patient_class = document.forms[0].patient_class.value;
	var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='InterventionForPatientClassDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='patient_intervention_class' id='patient_intervention_class' value='"+patient_class+"'></form></BODY></HTML>";
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
	
	var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='InterventionForPatientClassDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";
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
function unCheckSelectAll(obj)
{
	if(!obj.checked) 
	{
		document.forms[0].chkAll.checked=false;			
		var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='InterventionForPatientClassDynamicValues.jsp'><input type='hidden' name='clearOne' id='clearOne' value='"+obj.value+"'></form></BODY></HTML>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.form1.submit();
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
	PreparedStatement stmt3 = null;
	ResultSet rstlRs3 = null;

	effStatus=request.getParameter("effStatus");
	if(effStatus == null) effStatus="";

	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null ;

	try
	{
	con = ConnectionManager.getConnection(request);

	
	String patient_class = request.getParameter("patient_class");
	String flagSelect = request.getParameter("fromSearch");


	        	if(flagSelect !=null)
	        	{
	        		InterventionPatient.clearAll();
	        		 String sqlinsVals= "select intervention_code from ca_pat_class_intervention where patient_class=?";
				
				 stmt3=con.prepareStatement(sqlinsVals);
				 stmt3.setString(1,patient_class);
				 rstlRs3 = stmt3.executeQuery();
				if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {
						InterventionPatient.putObject(rstlRs3.getString(1));

					 }
				}
	         	}

             if(from != null && to != null)
             {
                int j=0;
                for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
                {
                         if(request.getParameter("chk"+(i)) != null)
                         {
                             checkedOnes = request.getParameter("chk"+(i));
                             if(!(InterventionPatient.containsObject(checkedOnes)))
                                 InterventionPatient.putObject(checkedOnes);
                             j++;
                         }
				}
                
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
        i = 1 ;
     
			String classValue="";
			String chkAttribute="";
			
//String   sql="select ?,intervention_code,short_desc intervention_desc,'I' db_action from ca_intervention where intervention_code not in ( select intervention_code  from ca_pat_class_intervention where patient_class = ?) and eff_status = 'E' union all select ?,a.intervention_code intervention_code, b.short_desc intervention_desc, 'U' db_action from ca_pat_class_intervention a, ca_intervention b where a.patient_class = ? and b.intervention_code  = a.intervention_code order by 3";
String   sql="SELECT ?,intervention_code,short_desc intervention_desc,'I' db_action FROM ca_intervention_lang_vw WHERE intervention_code NOT IN ( SELECT intervention_code  FROM ca_pat_class_intervention WHERE patient_class = ?) AND eff_status = 'E' and language_id = ? UNION ALL SELECT ?,a.intervention_code intervention_code, b.short_desc intervention_desc, 'U' db_action FROM ca_pat_class_intervention a, ca_intervention_lang_vw b WHERE a.patient_class = ? AND b.intervention_code  = a.intervention_code and b.language_id = ? ORDER BY 3";
					
	try
	{
    stmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	stmt.setString(1,patient_class);
	stmt.setString(2,patient_class);
	stmt.setString(3,locale);
	stmt.setString(4,patient_class);
	stmt.setString(5,patient_class);
	stmt.setString(6,locale);
	rs=stmt.executeQuery();
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();
	  }catch(Exception e){
		  //out.println(e);//COMMON-ICN-0181
		  e.printStackTrace();//COMMON-ICN-0181
		  }

%>
<body  OnMouseDown="CodeArrest();" onLoad='chkForSelectAll(<%=start%>,<%=end%>)' onKeyDown="lockKey()" class='CONTENT' >
<form name='facility_form_result' id='facility_form_result' action='../../eCP/jsp/InterventionForPatientClassDetail.jsp' method='post' >
<table width='90%' border=0 align='center'>
<tr>
<td align='right' class='NONURGENT'>
<input type=hidden name='patient_class' id='patient_class' value='<%=patient_class%>'>
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
    <a href='javascript:submitPrevNext(<%=(start-12)%>,<%=(end-12)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
    <input type=hidden name='whichPage' id='whichPage' value='prev'>

<%
    }
    if ( !((start+12) >= maxRecord )){
%>
    <a href='javascript:submitPrevNext(<%=(start+12)%>,<%=(end+12)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
    <input type=hidden name='whichPage' id='whichPage' value='next'>
<%
    }
%>
</td>
</tr>
</table>
<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
<th width='60%'><fmt:message key="eCP.Interventions.label" bundle="${cp_labels}"/></th>
<th width='20%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='chkAll' id='chkAll' onClick='selectAll(this,<%=start%>,<%=end%>)'></th>
<%	 	
		if (start != 0)
	    {
				    for(int j=1; j<=start; i++,j++){
					rs.next() ;
		}
		}
			while(rs.next() && i<=end){ 
			String intervention_code=rs.getString("intervention_code");
			
			String short_desc=rs.getString("intervention_desc");
			
			if(InterventionPatient.containsObject(intervention_code))  chkAttribute = "CHECKED";
			else
			chkAttribute="";

			int recordIndex = InterventionPatient.indexOfObject(intervention_code);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED"))    InterventionPatient.removeObject(recordIndex);
	
	
				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
				%>
			<tr>
				<td class='<%=classValue%>'><%=short_desc%></td>
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>'  value='<%=intervention_code%>'onClick='unCheckSelectAll(this)'> </td>
			</tr>
			<%
			i++;
			}		
		 }
			  catch(Exception e){
				//  out.print(e);//COMMON-ICN-0181
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

				session.setAttribute("InterventionPatient",InterventionPatient);
              }
%>
</table>
</form>
</body>
</html>






