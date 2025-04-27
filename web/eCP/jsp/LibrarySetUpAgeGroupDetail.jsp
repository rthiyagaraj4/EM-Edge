<!DOCTYPE html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="LibrarySetupAgeGroup" class="webbeans.eCommon.RecordSet" scope="session"/> 
<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<SCRIPT language="JavaScript" src="../../eCP/js/LibrarySetUp.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
       
	function submitPrevNext(from, to,flag){
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
		if(eval("document.forms[0].AgeGrpChk"+i))
		eval("document.forms[0].AgeGrpChk"+i).checked=true;
		}
		var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='LibrarySetUpAgeGroupDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'></form></BODY></HTML>";
		parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[3].document.form1.submit();
	}
	else
	{
		for(var i=start;i<=end;i++)
			{
			if(eval("document.forms[0].AgeGrpChk"+i))
			eval("document.forms[0].AgeGrpChk"+i).checked=false;
			}
	
	var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='LibrarySetUpAgeGroupDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";

	parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[3].document.form1.submit();
	}
}

function chkForSelectAll(start,end)
{
	//alert("called="+start+":"+end);
	if(parent.frames[3].document.forms[0].E.value == 'selectAll')
	{
		//alert("evalue:=selectall");
	document.forms[0].chkAll.checked=true;
	selectAll(document.forms[0].chkAll,start,end)
	}

}
</script>
<%
		String mode=request.getParameter("mode");
		String  req_start   =   "";
		String  req_end     =   "";

		//String checkAll=request.getParameter("chkValues");	
        String  checkedOnes         =   "";
		String flagSelect = "";
		String classValue="";
		String chkAttribute="";
		String sql="";
		String ageGrpCode="";
		

        String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;
        int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 7 ; }   else {  end = Integer.parseInt( to ) ; }
       
       req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
       req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

		Statement stmt=null;
		ResultSet rs=null ;
    	Connection con = null;

	
	try{
			
		con = ConnectionManager.getConnection(request);
		flagSelect = request.getParameter("fromSearch");
	  	if(flagSelect !=null)
	      	{
	       		LibrarySetupAgeGroup.clearAll();
	      	}
	        
//	        int recordCount			=	0;

             if(from != null && to != null)
             {
                     int j=0;
                     for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
                     {
                         if(request.getParameter("AgeGrpChk"+(i)) != null)
                         {
                             checkedOnes = request.getParameter("AgeGrpChk"+(i));
                             if(!(LibrarySetupAgeGroup.containsObject(checkedOnes)))
                                 LibrarySetupAgeGroup.putObject(checkedOnes);
                             j++;
                         }
                     }
     
            
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
        i = 1 ;
     
						
			 //sql="SELECT AGE_GROUP_CODE, SHORT_DESC,DECODE(GENDER,'M','Male','F','Female','All')Sex_specific,MIN_AGE ||' '|| DECODE(AGE_UNIT,'D','Days','M','Months','Y','Years')AGE_MIN_UNIT,MAX_AGE||' '||DECODE(NVL(AGE_UNIT_MAX,AGE_UNIT),'D','Days','M','Months','Y','Years')AGE_MAX_UNIT,GENDER FROM AM_AGE_GROUP WHERE EFF_STATUS='E' ORDER BY 2";
			  sql="SELECT AGE_GROUP_CODE, SHORT_DESC,DECODE(GENDER,'M','Male','F','Female','All')Sex_specific,MIN_AGE ||' '|| DECODE(AGE_UNIT,'D','Days','M','Months','Y','Years')AGE_MIN_UNIT,MAX_AGE||' '||DECODE(NVL(AGE_UNIT_MAX,AGE_UNIT),'D','Days','M','Months','Y','Years')AGE_MAX_UNIT,GENDER FROM AM_AGE_GROUP_lang_vw WHERE EFF_STATUS='E' and language_id='en' ORDER BY 2";
			
try{
	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs=stmt.executeQuery(sql);
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();
	  }catch(Exception e){
		  //out.println(e);//common-icn-0181
		  e.printStackTrace();//COMMON-ICN-0181
		  }

%>
<body  OnMouseDown="CodeArrest();" onLoad='chkForSelectAll(<%=start%>,<%=end%>)' class='CONTENT' >
<form name='LibraryAgeGroupForm' id='LibraryAgeGroupForm'  action='../../eCP/jsp/LibrarySetUpAgeGroupDetail.jsp?mode=<%=mode%>' method='post' >

<table  width='90%' border=0 align='center'>
<tr>
<td align='right' class='NONURGENT'>
<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>

<input type='hidden' name='from' id='from' value='<%=start%>'>
<input type='hidden' name='to' id='to' value='<%=end%>'>
<input type='hidden' name='start' id='start' value='<%=start%>'>
<input type='hidden' name='end' id='end' value='<%=end%>'>
<input type='hidden' name='function_name' id='function_name' value='insert'>
<input type='hidden' name='maxRecords' id='maxRecords' value='<%=maxRecord%>'>
<input type='hidden' name='chkValues' id='chkValues' value=''">


<%
    if ( !(start <= 1)) {
%>
    <a href='javascript:submitPrevNext(<%=(start-7)%>,<%=(end-7)%>,"1")' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
    <input type=hidden name='whichPage' id='whichPage' value='prev'>

<%
    }
    if ( !((start+7) >= maxRecord )){
%>
    <a href='javascript:submitPrevNext(<%=(start+7)%>,<%=(end+7)%>,"0")' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
    <input type=hidden name='whichPage' id='whichPage' value='next'>
<%
    }
%>
</td>
</tr>
</table>
		<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
			<th ><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></th>
			<th ><fmt:message key="eCP.SexSpecific.label" bundle="${cp_labels}"/></th>
			<th ><fmt:message key="Common.MinAge.label" bundle="${common_labels}"/></th>
			<th ><fmt:message key="Common.MaxAge.label" bundle="${common_labels}"/></th>
			<th ><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/><br><input type='checkbox' name='chkAll' id='chkAll' value="Y" onClick='selectAll(this,<%=start%>,<%=end%>); updateObj(this);setAll()'></th>
		<%	 
//		System.err.println("LibrarySetupAgeGroup=="+LibrarySetupAgeGroup.getRecordSetHandle());

//		recordCount =LibrarySetupAgeGroup.getSize();
	//	System.err.println(LibrarySetupAgeGroup.getSize());
		if (start != 0){
				    for(int j=1; j<=start; i++,j++){
					rs.next() ;
				     }
				    }
			while(rs.next() && i<=end){ 
			 ageGrpCode=rs.getString("AGE_GROUP_CODE");
			//System.err.println("ageGrpCode from db==>"+ageGrpCode+" :"+LibrarySetupAgeGroup.containsObject(ageGrpCode));
				if(LibrarySetupAgeGroup.containsObject(ageGrpCode))  chkAttribute = "CHECKED";
			else
			chkAttribute="";
		//	System.err.println("chkAttribute===>" +chkAttribute);
			int recordIndex = LibrarySetupAgeGroup.indexOfObject(ageGrpCode);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED"))    LibrarySetupAgeGroup.removeObject(recordIndex);
				
					
				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
				%>
			<tr>
				<td class='<%=classValue%>'><%=rs.getString(2)%></td>
				<TD class="<%=classValue%>"><%=rs.getString(3)%></TD>
				<TD class="<%=classValue%>"><%=rs.getString(4)%></TD>
				<TD class="<%=classValue%>"><%=rs.getString(5)%></TD>
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='AgeGrpChk<%=i%>'  value='<%=ageGrpCode%>' onclick="updateObj(this);setchkAll(this)"> </td>
			</tr>
			<%
			i++;
			}		
			
			
			 }
			  catch(Exception e){
				  //out.print(e);//COMMON-ICN-0181
                                   e.printStackTrace();//COMMON-ICN-0181
				  }
			  finally
			  {
				 			 if(rs != null){ rs.close(); }
						    if(stmt != null){ stmt.close(); }	
							if(con != null)
								ConnectionManager.returnConnection(con,request);
				session.setAttribute("LibrarySetupAgeGroup", LibrarySetupAgeGroup);

			  }%>

</table>
</form>
<Script>
				defaultValues('LibraryAgeGroupForm');
</Script>
</body>
</html>

