<!DOCTYPE html>
<%--
	FileName	: SpecialtyForExternalReferralSourceDeatail.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page language="java" contentType="text/html;charset=UTF-8" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>


<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script>
	
function submitPrevNext(from, to){
	document.forms[0].from.value = from;  
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}
</script>
<%
request.setCharacterEncoding("UTF-8");	
	String  req_start   =   "", req_end     =   "";
    String  checkedOnes         =   "";
    String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
    //int maxRecord = 0;
    int start = 0 ;
    int end = 0 ;
	int i=1;		
    if(from == null){ 
		start = 0;
	}else{
		start = Integer.parseInt( from ) ; 
	}
    if(to == null){
		end = 10 ;
	}else{
		end = Integer.parseInt( to ) ;
	}       
    req_start = (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
    req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
	String search_by=request.getParameter("search_by");
	String search_txt=request.getParameter("search_txt");
	if(search_by == null) search_by="";
	if(search_txt == null) search_txt="";
	String search_by1="";
	if(search_by.equals("01")){
	   search_by1="SPECIALITY_CODE";
	}else if(search_by.equals("02")){
		search_by1="SHORT_DESC";
	}
	Statement stmt3 = null;
	ResultSet rstlRs3 = null;
	Statement stmt=null;
	ResultSet rs=null ;
	Connection con = null;
	
	try{
		con = ConnectionManager.getConnection(request);
		String facility_id=(String)session.getValue("facility_id");
		String facility	= request.getParameter("facility");
		String flagSelect = request.getParameter("fromSelect");
		if(facility == null || facility.equals("null")) facility = "";

		if(flagSelect !=null){
			accessRightRecSet.clearAll();
	    	String sqlinsVals= "select specialty_code from AM_REFERRAL_FOR_SPECIALTY where referral_code='"+facility+"'";
			stmt3=con.createStatement();
			rstlRs3 = stmt3.executeQuery(sqlinsVals);
			if(rstlRs3 !=null){
				while(rstlRs3.next()){
					accessRightRecSet.putObject(rstlRs3.getString(1));
				}
			}
		}
        
		int recordCount	=	0;
        if(from != null && to != null){
			int j=0;
			for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++){
				if(request.getParameter("chk"+(i)) != null){
					checkedOnes = request.getParameter("chk"+(i));
					if(!(accessRightRecSet.containsObject(checkedOnes)))
						accessRightRecSet.putObject(checkedOnes);
                        j++;
                 }
            }
%>
	<input type=hidden name='pages' id='pages' value='multiple'>
	<input type=hidden name='totChecked' id='totChecked' value='<%=j%>'>
<%
}
	i = 1 ;
	String classValue="QRYODD";
	String chkAttribute="";
	//	StringBuffer sql=new StringBuffer().append("SELECT  a.specialty_code, b.short_desc FROM am_referral_for_specialty a, am_speciality b WHERE a.specialty_code = b.speciality_code AND a.referral_code = '"+facility+"' UNION SELECT a.speciality_code, a.short_desc FROM  am_speciality a WHERE eff_status = 'E' ORDER BY 2");
	StringBuffer sql=new StringBuffer();
	sql.setLength(0);
	sql.append("SELECT  a.specialty_code, b.short_desc FROM am_referral_for_specialty a, am_speciality b WHERE a.specialty_code = b.speciality_code AND a.referral_code = '"+facility+"'");
	if(!search_by.equals("") && !search_txt.equals(""))
		sql.append(" and upper(b."+search_by1+")  like upper('"+search_txt+"%')"); 
 	sql.append(" UNION SELECT a.speciality_code, a.short_desc FROM  am_speciality a WHERE eff_status = 'E'");
	if(!search_by.equals("") && !search_txt.equals(""))
		sql.append(" and upper(a."+search_by1+")  like upper('"+search_txt+"%')");
 	 sql.append(" ORDER BY 2");
	 if(rstlRs3!=null)rstlRs3.close();
	 if(stmt!=null)stmt.close();
	 try{
		 stmt = con.createStatement();
		 rs=stmt.executeQuery(sql.toString());	
  }catch(Exception e){
	  out.println(e);
	  e.printStackTrace();
	  }
  
  if(start != 0)
		{
			for(int j=1; j<=start; i++,j++)
			{
				rs.next() ;
			}
		}
%>
<body  onKeyDown = 'lockKey()' OnMouseDown="CodeArrest();"  class='CONTENT' >
<form name='facility_form_result' id='facility_form_result' action='../../eAM/jsp/SpecialtyForExternalReferralSourceDetail.jsp' method='post'>

<table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>
<tr>
<td class="white">
<table border='0' align='right'>
<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>
<input type=hidden name='from' id='from' value='<%=start%>'>
<input type=hidden name='to' id='to' value='<%=end%>'>
<input type=hidden name='start' id='start' value='<%=start%>'>
<input type=hidden name='end' id='end' value='<%=end%>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >
<input type='hidden' name='function_name' id='function_name' value='insert'>
<input type='hidden' name='search_by' id='search_by' value='<%=search_by%>'>
<input type='hidden' name='search_txt' id='search_txt' value='<%=search_txt%>'>
<%
    if(!(start <= 1)) 
	{
%>		<tr>
		<td align='right'  id='prev'><a href='javascript:submitPrevNext(<%=(start-10)%>,<%=(end-10)%>)'  text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
		<input type=hidden name='whichPage' id='whichPage' value='prev'></td>
<%
    }

 //   if (!((start+10) >= maxRecord))
	{
%>  
		
		<td align='right' id='next'><a href='javascript:submitPrevNext(<%=(start+10)%>,<%=(end+10)%>)'  text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
		<input type=hidden name='whichPage' id='whichPage' value='next'></td>
		</tr>
<%		
    }
%>
<!-- </td> -->

<!-- </tr> -->
</table>	
	</td>
	</tr>
<%	 
		recordCount = accessRightRecSet.getSize();
	
		int sCnt=0;
		
		while( i<=end && rs.next() )
		{ 
			++sCnt;

			if(sCnt==1)
			{%>
			<tr>
			<td>
				<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
				<td class='columnheader' width='50%' align='center'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td class='columnheader' width='20%' align='center'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<%}
			String speciality_num=rs.getString("specialty_code");
			String short_desc=rs.getString("short_desc");
		
			
			int recordIndex = accessRightRecSet.indexOfObject(speciality_num);	
			
				if(accessRightRecSet.containsObject(speciality_num))
					chkAttribute = "CHECKED";
				else
					chkAttribute="";

				if(recordIndex!=-1)
				{
					if(chkAttribute.equals("CHECKED"))    
						accessRightRecSet.removeObject(recordIndex);       
				}
				if( classValue.equals("QRYODD"))  classValue="QRYEVEN";
				else	classValue="QRYODD";
				%>
			<tr>
				<td class='<%=classValue%>'><%=short_desc%></td>
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%>  name='chk<%=i%>'  value='<%=speciality_num%>'></td>
			</tr>
					<input type='hidden' name='recordCount' id='recordCount' value='<%=recordCount%>'>
					<input type='hidden' name='facility' id='facility' value='<%=facility%>'>
			<%			
				i++;
			}//end of while		
			if(sCnt>0)
			{%>
			</table>
			</td>
			</tr>
		</table>
			<%}
			else
			{%>	
				<script>
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
				</script>
			<%}

if ( sCnt < 10 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}
				if(rs != null){ rs.close();}
			 if(stmt != null){ stmt.close(); }
			if(rstlRs3 != null){ rstlRs3.close(); }
		     if(stmt3 != null){ stmt3 .close();}
			 
		
		}
		catch(Exception e){out.print(e);}
		finally
		{
			 ConnectionManager.returnConnection(con,request);
			 session.setAttribute("ReferralSpeciality", accessRightRecSet);
		}
		%>

</form>
</body>
</html>

