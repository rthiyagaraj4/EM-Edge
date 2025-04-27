<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
21/11/2012		IN035950		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible.   								 
-------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date	Rev.Name	Description
-------------------------------------------------------------------------------------------------
28/06/2018	IN065341	Prakash C	29/06/2018	Ramesh G	MMS-DM-CRF-0115
03/04/2019	IN069978        Prakash C	03/04/2019	Ramesh G	MMS-ICN-00116
--------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.net.*,java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
//String content_ID = request.getParameter("content_ID");checkstyle
String title = request.getParameter("title");
//String sStyle = "";
if(!"".equals(prefStyleSheet)){
 sStyle=prefStyleSheet;
}
/*else{
	sStyle=prefStyleSheet;
}*/
//[IN035950] Ends
%>

<title><%=title %></title><!--IN035950-->
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<table  width="100%" class='grid' id='tb1' align='center'>
 <%
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	
	Connection con=null;
    PreparedStatement stmt=null;
    ResultSet rs=null;
try
{	String Patient_Id        = request.getParameter("patient_id");
//IN065341 starts
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String operating_facility_id="";
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String encounter_id=request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");//IN069978
	if(called_from.equals("CDR")){
		operating_facility_id = request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
	}else{//IN065341 ends
	    operating_facility_id=(String) session.getValue("facility_id");
	}//IN065341
    String procedure="";
    String date="";
    String practitioner="";
    String classValue="";
   // String error_yn = "";
    int k=1;
   
        con=ConnectionManager.getConnection(request);
       
	try
    {


       // String sql="Select a.proc_narration,to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date,b.practitioner_name practitioner_name,proc_date dummydate, a.srl_no srl_no, a.ERROR_YN error_yn from pr_encounter_procedure a, am_practitioner b where a.facility_id = ? and a.PATIENT_ID = ? and b.practitioner_id=a.practitioner_id  and nvl(error_yn,'N')!='Y' order by dummydate desc "; 
		
		 //String sql="Select a.proc_narration,to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date,AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'1') practitioner_name,proc_date dummydate, a.srl_no srl_no, a.ERROR_YN error_yn from pr_encounter_procedure a where a.facility_id = ? and a.PATIENT_ID = ? and nvl(error_yn,'N')!='Y' order by dummydate desc ";  
	//IN069978 starts
		// String sql="Select a.proc_narration,to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date,AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.practitioner_id,?,'1') practitioner_name,proc_date dummydate, a.srl_no srl_no, a.ERROR_YN error_yn from pr_encounter_procedure ##REPDB## a where a.facility_id = ? and a.PATIENT_ID = ? and nvl(error_yn,'N')!='Y' order by dummydate desc ";  
		 StringBuffer sql = new StringBuffer();
		 sql.append("Select a.proc_narration,to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date,AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.practitioner_id,?,'1') practitioner_name,proc_date dummydate, a.srl_no srl_no, a.ERROR_YN error_yn from pr_encounter_procedure ##REPDB## a where a.facility_id = ? and a.PATIENT_ID = ? and nvl(error_yn,'N')!='Y' "); //IN065341
		if(called_from.equals("CDR")){
			sql.append(" and a.encounter_id = ?");
		}
		sql.append(" order by dummydate desc");
		
		String result=sql.toString();
		result=result.replaceAll("##REPDB##", RepDb);//IN065341

		stmt = con.prepareStatement(result);
		stmt.setString(1, locale);
		stmt.setString(2, operating_facility_id);
		stmt.setString(3, Patient_Id);
		if(called_from.equals("CDR")){
		  stmt.setString(4, encounter_id);
		}
       //IN069978 ends	
        rs = stmt.executeQuery();
		
		//out.println(rs.next());
		/*if(rs.next())
		{
			 error_yn = rs.getString("error_yn") == null ? "N" : rs.getString("error_yn");
		}*/
		
		//if (rs == null)
		 while (rs.next())
        { 
		
                    if ( k%2 == 0 )
                            classValue = "QRYEVEN" ;
                    else
                            classValue = "QRYODD" ;
                    procedure       =(rs.getString(1)==null)?"&nbsp;":rs.getString(1);
                    date            =(rs.getString(2)==null)?"&nbsp;":rs.getString(2);
                    practitioner    =(rs.getString(3)==null)?"&nbsp;":rs.getString(3);

					if(!date.equals("&nbsp;"))
						date = com.ehis.util.DateUtils.convertDate(date,"DMYHM","en",locale);

                    out.println("<tr><td  class='gridData'> "+procedure+","+date+","+practitioner+"</td></tr>");
                    k++;
              
				
        }
			if(rs!=null)    rs.close();
            if(stmt!=null)  stmt.close();
    }
	catch(Exception e)
	{
		out.print("ERROR"+e);
	}
   
%>
</table>
</body>
</html>
<%
}
catch(Exception e)
{
	out.println(e);
}
finally
{
 if(con!=null)ConnectionManager.returnConnection(con,request);

}
%>

