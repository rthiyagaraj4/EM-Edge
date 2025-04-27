<!DOCTYPE html>
<!-- PositionForMDCPDetail.jsp -->
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Suchilagna panigrahi
*	Created On		:	30 Dec 2004

--%>
<%-- JSP Page specific attributes start --%>
<html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=ISO-8859-1"%>
<jsp:useBean id="PositionForMDCP" class="webbeans.eCommon.RecordSet" scope="session"/> 

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
<script src="../js/CpMessages.js" language="javascript"></script>  
<script src="../../eCP/js/PositionForMDCP.js" language="JavaScript"></script>
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
		var facility_id1 = document.forms[0].facility_id1.value;
		var pract_type = document.forms[0].pract_type.value;
		var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='PositionForMDCPDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='facility_id' id='facility_id' value='"+facility_id1+"'><input type='hidden' name='pract_type' id='pract_type' value='"+pract_type+"'></form></BODY></HTML>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.form1.submit();
	}
	else	{
		for(var i=start;i<=end;i++){
			if(eval("document.forms[0].chk"+i))
			eval("document.forms[0].chk"+i).checked=false;
		}
	
		var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='PositionForMDCPDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";
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
		String  req_start = "", req_end = "";
	    String  checkedOnes = "";
        String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;
		String facility_id1="";
		String pract_type="";
		String flagSelect="";
		String sqlinsVals="";
		String classValue="";
		String chkAttribute="";
		String   sql  ="";
		String position_code="";
		String position_desc="";

        int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }
       
       req_start = (request.getParameter("start")==null)   ?   "0" : request.getParameter("start");
       req_end =  (request.getParameter("end")==null)   ?   "0" : request.getParameter("end");

			Statement stmt3 = null;
			ResultSet rstlRs3 = null;
			Statement stmt=null;
			PreparedStatement pstmt = null;//common-icn-0180
			PreparedStatement pstmt1 = null;//common-icn-0180
			ResultSet rs=null ;

	Connection con = null;

	try{
			
	con = ConnectionManager.getConnection(request);

	facility_id1=request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
	pract_type=request.getParameter("pract_type")==null?"":request.getParameter("pract_type");
	flagSelect = request.getParameter("fromSearch");

       	if(flagSelect !=null)
	        	{
	        		PositionForMDCP.clearAll();
	        		//sqlinsVals= "  select position_code from cp_position_for_mdcp where facility_id='"+facility_id1+"'";//common-icn-0180
	        		sqlinsVals= "  select position_code from cp_position_for_mdcp where facility_id= ?";//common-icn-0180
						//stmt3=con.createStatement();//common-icn-0180
						pstmt=con.prepareStatement(sqlinsVals);//common-icn-0180
						pstmt.setString(1, facility_id1);//common-icn-0180
						rstlRs3 = pstmt.executeQuery();//common-icn-0180
						//rstlRs3 = stmt3.executeQuery(sqlinsVals);//common-icn-0180
				if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {
						PositionForMDCP.putObject(rstlRs3.getString(1));

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
                             if(!(PositionForMDCP.containsObject(checkedOnes)))
                                 PositionForMDCP.putObject(checkedOnes);
                             j++;
                         }
                         
                     }
     
            
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
        i = 1 ;
			
		 //sql  =" SELECT  position_code, position_desc, 'N' db_action FROM am_position WHERE position_code NOT IN(SELECT position_code FROM cp_position_for_mdcp WHERE facility_id = '"+facility_id1+"') AND role_type = 'P' AND ('"+pract_type+"'IS NULL OR staff_type = '"+pract_type+"') AND eff_status = 'E' UNION ALL SELECT  a.position_code,b.position_desc, 'Y' db_action FROM cp_position_for_mdcp a, am_position b WHERE a.facility_id = '"+facility_id1+"' AND b.position_code = a.position_code AND b.role_type = 'P' AND ('"+pract_type+"'IS NULL OR staff_type = '"+pract_type+"') ORDER BY 2";//common-icn-0180
         
		 sql  =" SELECT  position_code, position_desc, 'N' db_action FROM am_position WHERE position_code NOT IN(SELECT position_code FROM cp_position_for_mdcp WHERE facility_id = ?) AND role_type = 'P' AND (? IS NULL OR staff_type = ?) AND eff_status = 'E' UNION ALL SELECT  a.position_code,b.position_desc, 'Y' db_action FROM cp_position_for_mdcp a, am_position b WHERE a.facility_id = ? AND b.position_code = a.position_code AND b.role_type = 'P' AND (? IS NULL OR staff_type = ?) ORDER BY 2";//common-icn-0180

try{
	//stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
	//common-icn-0180 starts
	pstmt1=con.prepareStatement(sql);
	pstmt1.setString(1, facility_id1);
	pstmt1.setString(2, pract_type);
	pstmt1.setString(3, pract_type);
	pstmt1.setString(4, facility_id1);
	pstmt1.setString(5, pract_type);
	pstmt1.setString(6, pract_type);
	//common-icn-0180 starts
	rs=pstmt1.executeQuery();
	//rs=stmt.executeQuery(sql);//common-icn-0180
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();

	  }catch(Exception e){
		//  out.println(e);//COMMON-ICN-0181
           e.printStackTrace();//COMMON-ICN-0181
		  }


%>
<body  OnMouseDown="CodeArrest();" onLoad='chkForSelectAll(<%=start%>,<%=end%>)' class='CONTENT' >
<form name='form_positionformdcpdetail' id='form_positionformdcpdetail' action='../../eCP/jsp/PositionForMDCPDetail.jsp' method='post' >

<table  width='90%' border=0 align='center'>
<tr>
<td align='right' class='NONURGENT'>
<input type=hidden name='facility_id1' id='facility_id1' value='<%=facility_id1%>'>
<input type=hidden name='pract_type' id='pract_type' value='<%=pract_type%>'>

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
    <a href='javascript:submitPrevNext(<%=(start-10)%>,<%=(end-10)%>)' text-decoration='none'>Previous</a>
    <input type=hidden name='whichPage' id='whichPage' value='prev'>
<%
    }
    if ( !((start+10) >= maxRecord )){
%>
    <a href='javascript:submitPrevNext(<%=(start+10)%>,<%=(end+10)%>)'text-decoration='none'>Next</a>
    <input type=hidden name='whichPage' id='whichPage' value='next'>
<%
    }
if(maxRecord == 0)
		
		{
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));history.go(-1);</script>");
	}else{
%>
</td>
</tr>
</table>
		<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
			<th width='60%'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></th>
			<th width='20%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='chkAll' id='chkAll' onClick='selectAll(this,<%=start%>,<%=end%>)'></th>
		<%	 
		if (start != 0){
			for(int j=1; j<=start; i++,j++){
				rs.next() ;
			}
		}
			while(rs.next() && i<=end){ 
			position_code=rs.getString("position_code");
			position_desc=rs.getString("position_desc");

			if(PositionForMDCP.containsObject(position_code))  
				chkAttribute = "CHECKED";
			else
				chkAttribute="";

			int recordIndex = PositionForMDCP.indexOfObject(position_code);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED"))    PositionForMDCP.removeObject(recordIndex);
	
	
				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
				%>
			<tr>
				<td class='<%=classValue%>'><%=position_desc%></td>
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>'  value='<%=position_code%>'> </td>
			</tr>
			<%
			i++;
			}		
	}
			
			 }
			  catch(Exception e){out.print(e);}
			  finally
			  {
				 if(rs != null){ rs.close(); }
				 if(rstlRs3 != null){ rstlRs3.close(); }
				 if(stmt != null){ stmt.close(); }
				 if(stmt3 != null){ stmt3.close(); }
				 if(pstmt != null){ pstmt.close(); }//common-icn-0180
				 if(pstmt1 != null){ pstmt1.close(); }//common-icn-0180
					    
				if(con != null)
					ConnectionManager.returnConnection(con,request);

				session.setAttribute("PositionForMDCP", PositionForMDCP);
			  }
			  %>

</table>
</form>
</body>
</html>

