<!DOCTYPE html>

<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="EventBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<%EventBean.clearAll();%>
<html>
<head>
<%

	String patient_id	="";
	String from_date	="";
	String end_date		="";
	String classValue	="";
	String encounter_id	="";
	String order = "";
    String facility_id      ="";
    String prevdate=""; 
    String result_category="";
    String nature="";
	String 	ref_date_str="";	
	String 	ref_time_str="";	
	String 	ref_id="";	
	
	 String  practionerid="";  

      
	StringBuffer sql=new StringBuffer();
	
	Connection con		=null;
	ResultSet rs		=null;
	PreparedStatement stmt		=null;
	
	
	
%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src='../../eCA/js/RecClinicalNotesLinkFutureEvent.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<form name='RecClinicalNotesLinkFutureEventTreeForm' id='RecClinicalNotesLinkFutureEventTreeForm'>

 <%

	try
	{
	con				=ConnectionManager.getConnection(request);
  
	practionerid   = (String) session.getValue("ca_practitioner_id"); 
	result_category=request.getParameter("result_cat")==null?"":request.getParameter("result_cat");
	nature=request.getParameter("nature")==null?"":request.getParameter("nature"); 
	from_date=request.getParameter("from_date")==null?"":request.getParameter("from_date");
	end_date=request.getParameter("to_date")==null?"":request.getParameter("to_date");
	patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	order	=request.getParameter("order")==null?"":request.getParameter("order");
   
	facility_id 				=	(String) session.getValue("facility_id");
	
	sql.append(" select to_char(nvl(PREFERRED_TREATMENT_DATE,REFERRAL_DATE),'dd/mm/yyyy') date_str , to_char(nvl(PREFERRED_TREATMENT_DATE,REFERRAL_DATE),'hh24:mi')date_time_str , REFERRAL_ID from pr_referral_register where patient_id=? and trunc(nvl(PREFERRED_TREATMENT_DATE,REFERRAL_DATE)) > =  trunc(sysdate)");
	
	sql.append(" and nvl(PREFERRED_TREATMENT_DATE,REFERRAL_DATE) between nvl(to_date(?,'dd/mm/yyyy'),trunc(SYSDATE)) and  NVL(to_date(?,'dd/mm/yyyy'),SYSDATE+365) ");
	 
	   if((nature.equals("S")))
		{
        sql.append(" and FROM_PRACT_ID = ?");
		} 
	  
		if(order.equals("D"))
		sql.append(" order by nvl(PREFERRED_TREATMENT_DATE,REFERRAL_DATE) desc ");
		else
        sql.append(" order by nvl(PREFERRED_TREATMENT_DATE,REFERRAL_DATE) "); 
		stmt=con.prepareStatement(sql.toString());
		int count1 = 0;
		
//        stmt.setString(++count1,facility_id);
		stmt.setString(++count1,patient_id);
		
		
		stmt.setString(++count1,from_date);
		stmt.setString(++count1,end_date);
			 
         if((nature.equals("S"))){
     
			stmt.setString(++count1,practionerid);
		 
		} 
		
		        
		rs=stmt.executeQuery();

		%>


<table border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<TR>
<td class='columnheader' width='100%' ><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>

<%
int i = 0,k=0;

 if (rs !=null)
 {
  	while(rs.next())
	{
     	if ( k%2 == 0 )
		classValue = "QRYEVEN" ;
		else
		classValue = "QRYODD" ;
	
		
		ref_date_str=rs.getString("date_str")==null?"":rs.getString("date_str");
		ref_time_str=rs.getString("date_time_str")==null?"":rs.getString("date_time_str");
		ref_id=rs.getString("REFERRAL_ID")==null?"":rs.getString("REFERRAL_ID");
		
	
	    if(!ref_date_str.equals(prevdate))
	    {
	     out.println("<tr><td colspan=2 class='CAHIGHERLEVELCOLOR'  style='color:white' onClick=javascript:call_resultref('"+ref_date_str+"','Dat')><font size=2>"+ref_date_str+"</font></td></tr>");
	    }

		
        out.println("<tr><td  class='"+classValue+"' colspan='2'><a href=javascript:call_resultref('"+ref_id+"','Refid')>&nbsp;&nbsp;-"+ref_time_str+"</a></td>");
	
	
        prevdate = ref_date_str;
	
		i++;
		k++;
	    }
    }
		
	 if(k==0){
	 %>
	 <Script language=javascript>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common'));
	 </script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	 <%}
			
	if(rs!=null)	rs.close();
	if(stmt!=null) 	stmt.close();
	}
	catch(Exception e){
		//out.print("ERROR"+e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{	
		
		if(con!=null)ConnectionManager.returnConnection(con,request);

	}


%>
</table>
<input type="hidden" name="nature" id="nature" value="<%=nature%>">
<input type="hidden" name="order" id="order" value="<%=order%>">
</form>
</body>
</html>

