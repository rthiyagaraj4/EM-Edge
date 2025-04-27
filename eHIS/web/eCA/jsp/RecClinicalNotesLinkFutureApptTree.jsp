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
	String 	appt_date_str="";	
	String 	appt_time_str="";	
	String 	appt_ref_no="";	

    String practionerid="";  
	StringBuffer sql=new StringBuffer();
	
	Connection con		=null;
	ResultSet rs		=null;
	PreparedStatement stmt		=null;
	
 	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	
	
%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<!-- added by Kishore Kumar N on 10/12/2008  -->

<!-- end here -->
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src='../../eCA/js/RecClinicalNotesLinkFutureEvent.js'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
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
	end_date=request.getParameter("to_date")==null? "" :request.getParameter("to_date");
	patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	order	=request.getParameter("order")==null?"":request.getParameter("order");
   
	from_date		=	com.ehis.util.DateUtils.convertDate(from_date,"DMY",locale,"en");
	end_date		=	com.ehis.util.DateUtils.convertDate(end_date,"DMY",locale,"en");
	facility_id 				=	(String) session.getValue("facility_id");
	
	sql.append(" select   to_char(APPT_DATE,'dd/mm/yyyy') appt_date_str , to_char(APPT_SLAB_FROM_TIME,'hh24:mi') appt_time_str,APPT_REF_NO from oa_appt where FACILITY_ID=? AND patient_id=? ");
	
	//if( (!(from_date.equals(""))) && (!(end_date.equals(""))))
		{
				 sql.append(" and APPT_DATE between nvl(to_date(?,'dd/mm/yyyy'),trunc(SYSDATE)) and  NVL(to_date(?,'dd/mm/yyyy'),SYSDATE+365) ");
		}
		if((nature.equals("S")))
		{
        sql.append(" and PRACTITIONER_ID = ?");
		}

		if(order.equals("D"))
		sql.append(" order by appt_date desc, appt_time desc ");
		else
        sql.append(" order by appt_date,appt_time "); 
			

	    /*	
		if(!(med_anc_id.equals(""))){
		sql.append("and a.service_code=? ");
		}
		*/
		//out.println(sql.toString()+"from_date"+from_date+"end_date"+end_date);
//out.println("nature"+nature);
	   
		stmt=con.prepareStatement(sql.toString());
		int count1 = 0;
		
        stmt.setString(++count1,facility_id);
		stmt.setString(++count1,patient_id);
		
		//if( (!(from_date.equals(""))) && (!(end_date.equals(""))) )
		{
				 stmt.setString(++count1,from_date);
				 stmt.setString(++count1,end_date);
				 }
		

		if((nature.equals("S"))){
     
			stmt.setString(++count1,practionerid);
		 
		} 

		
        
		rs=stmt.executeQuery();

		%>


<table width="100%" class='grid'>
<TR>
<td class='columnheader' width='100%' ><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>

<%
int i = 0,k=0;

 if (rs !=null)
 {
	 classValue = "gridData";
  	while(rs.next())
	{
     	if ( k%2 == 0 )
		/*classValue = "QRYEVEN" ;
		else
		classValue = "QRYODD" ;*/
	
		
		appt_date_str=rs.getString("appt_date_str")==null?"":rs.getString("appt_date_str");
		appt_time_str=rs.getString("appt_time_str")==null?"":rs.getString("appt_time_str");
		appt_ref_no=rs.getString("APPT_REF_NO")==null?"":rs.getString("APPT_REF_NO");

		appt_date_str		=	com.ehis.util.DateUtils.convertDate(appt_date_str,"DMY","en",locale);
	
	    if(!appt_date_str.equals(prevdate))
	    {
	     out.println("<tr><td  colspan=2 class='CAHIGHERLEVELCOLOR'  style='color:white' onClick=javascript:call_result('"+appt_date_str+"','Dat')><font size=2>"+appt_date_str+"</font></td></tr>");
	    }

	
        out.println("<tr><td  class='"+classValue+"'  colspan='2'><a href=javascript:call_result('"+appt_ref_no+"','Refno')>&nbsp;&nbsp;-"+appt_time_str+"</a></td>");
	
	
        prevdate = appt_date_str;
	
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
		//out.print("ERROR"+e);//COMMON-ICN-0181
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

