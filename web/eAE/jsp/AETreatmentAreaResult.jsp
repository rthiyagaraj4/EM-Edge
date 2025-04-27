<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<HTML>
<head>
	<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<title><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></title>
</head>
<BODY onload='callonload();' class='CONTENT' onKeyDown = 'lockKey()'>

<script>

function closewin(treatment_area_code,short_desc,clinic_code){
	var short_desc1=eval('short_desc')
	while(short_desc1.indexOf("+")!=-1){
		      short_desc1=short_desc1.replace('+'," ");
		  }
		  var sv=	unescape(short_desc1)

		window.returnValue = treatment_area_code+"^"+sv+"^"+clinic_code;
		window.close();	
   }



function callonload()
{
if(parent.frames[0].document.getElementById("Search"))
parent.frames[0].document.getElementById("Search").disabled=false;

if(parent.frames[0].document.getElementById("clear"))
parent.frames[0].document.getElementById("clear").disabled=false;
}
</script>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	//String locale					= (String)session.getAttribute("LOCALE");
	String facility_id 			= (String) session.getValue( "facility_id" );
// 26.02.09
	String treatment_code						=request.getParameter("treatment_code")==null?"":request.getParameter("treatment_code");              
	treatment_code=treatment_code.trim();
	String treatment_desc		=request.getParameter("treatment_desc")==null?"":request.getParameter("treatment_desc");
	treatment_desc=treatment_desc.trim();
	String treatment_cliniccode				=request.getParameter("treatment_cliniccode")==null?"":request.getParameter("treatment_cliniccode");         
	if(treatment_cliniccode==null) treatment_cliniccode="";
 	Connection con=null;
	String treatment_area_code="";                
	String long_desc="";             
	String short_desc="";             
	String clinic_code="";       
	 int maxDispRecords =14; 

 		int rowIndex					=	1;		
		int		maxRecord				=	0;
		int 	i						=	1;
		int		start					=	0;
		int 	end						=	0;
    
		String from							=	request.getParameter("from") ;
		String to								=	request.getParameter("to") ;
		if ( from == null ||from.equals("") )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null ||to.equals(""))
			end = maxDispRecords ;
		else
			end = Integer.parseInt( to ) ;  

	
	try{
	con = ConnectionManager.getConnection(request);
	Statement stmt=null;
	ResultSet rs=null;
	
  try
	 {
  //  String strsql2="select * from AE_TMT_AREA_FOR_CLINIC_LANG_VW where language_id='"+locale+"'  and FACILITY_ID = '"+facility_id+"'  and eff_status='E' and upper(short_desc)  like upper(nvl('"+treatment_desc+"%',short_desc)) and upper(treatment_area_code) like upper(nvl('"+treatment_code+"%',treatment_area_code)) and upper(clinic_code)  like upper(nvl('"+treatment_cliniccode+"%',clinic_code))  order by 2 ";

    String strsql2="select * from AE_TMT_AREA_FOR_CLINIC_VW where FACILITY_ID = '"+facility_id+"'  and eff_status='E' and upper(SHORT_DESC)  like upper(nvl('"+treatment_desc+"%',SHORT_DESC)) and upper(treatment_area_code) like upper(nvl('"+treatment_code+"%',treatment_area_code)) and upper(clinic_code)  like upper(nvl('"+treatment_cliniccode+"%',clinic_code))  order by 2 ";

	 stmt=con.createStatement();
	 rs = stmt.executeQuery(strsql2);
   while(rs!=null && rs.next())
			{
			  maxRecord++; 
			}
	    
		if(stmt!=null)	stmt.close();
		if(rs!=null)	rs.close();
		if	 (maxRecord==0)
		{
%>
		<script>
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		</script>
<%
}
else
{
	 stmt=con.createStatement();
	 rs = stmt.executeQuery(strsql2);
	%>
<table border='0' cellpadding='0' cellspacing='0' width='100%' id='TitleTab'>
<tr>
        <td  width='80%'>
            <table  align=right>
                <tr>
                    <td>
<%
if ( !(start <= 1) ){

	out.println("<label  onClick=\"self.location.href='../../eAE/jsp/AETreatmentAreaResult.jsp?from="+(start-maxDispRecords)+"&to="+(end-maxDispRecords)+"&treatment_desc="+treatment_desc+"&treatment_cliniccode="+treatment_cliniccode+ "&treatment_code="+treatment_code+ "';\"  style='cursor:pointer'><font color='BLUE'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font></label>");
	}

  if ( !( (start+maxDispRecords) > maxRecord ) ){

	  out.println("<A HREF='../../eAE/jsp/AETreatmentAreaResult.jsp?from="+(start+maxDispRecords)+"&to="+(end+maxDispRecords)+"&treatment_code="+treatment_code+ "&treatment_cliniccode="+treatment_cliniccode+ "&treatment_desc="+treatment_desc+"';\" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

	}
%>
</td>
                </tr>
            </table>
        </td>
    </tr>	
</table>

	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<tr>
		<th align=left><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th align=left><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th align=left><fmt:message key="Common.ClinicCode.label" bundle="${common_labels}"/></th>
	</tr>
	<%
	String classValue = "" ;
	i=1;
	if ( rs != null )
	{
	   if ( start != 1 )
		{
			 for( int k=1; k<start; i++,k++ )
			 {
			  rs.next() ;
			 }
		}
						while ( rs.next() && i<=end )
						{
							classValue				=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
							rowIndex++;
		   					treatment_area_code=rs.getString("treatment_area_code");
							if( treatment_area_code==null) treatment_area_code="";
							long_desc=rs.getString("long_desc");
							if( long_desc==null) long_desc="";
						   short_desc=rs.getString("short_desc");
							if( short_desc==null) short_desc="";
							clinic_code=rs.getString("clinic_code");
							if(clinic_code==null) clinic_code="";
					
						 out.println("<tr>");
						 out.println("<td  nowrap class='" + classValue + "' onclick=closewin('"+java.net.URLEncoder.encode(treatment_area_code)+"','"+java.net.URLEncoder.encode(short_desc,"UTF-8")+"','"+java.net.URLEncoder.encode(clinic_code)+"')><a  href=\"javascript:closewin('"+java.net.URLEncoder.encode(treatment_area_code)+"','"+java.net.URLEncoder.encode(short_desc)+"','"+java.net.URLEncoder.encode(clinic_code)+"') \" target='proc1' >");

							out.println(treatment_area_code+"</td>");
			                out.println("<td  nowrap class='" + classValue + "' onclick=closewin('"+java.net.URLEncoder.encode(treatment_area_code) +"','"+java.net.URLEncoder.encode(short_desc)+"','"+java.net.URLEncoder.encode(clinic_code)+"')><a  href=\"javascript:closewin('"+java.net.URLEncoder.encode(treatment_area_code)+"','"+java.net.URLEncoder.encode(short_desc)+"','"+java.net.URLEncoder.encode(clinic_code)+"') \" target='proc1' >");
							out.println(short_desc+"</td>");
							out.println("<td nowrap class='" + classValue + "'>");
							out.println(clinic_code+"</td></tr>");
							%> 
							<input type=hidden name=short_desc  value='<%=treatment_area_code+"/"+short_desc+"/"+clinic_code%>'>
							<%							
							i++;
						}
						if(rs!=null) rs.close();
						if(stmt!=null) stmt.close();
	}
						out.println("</table>");
		}	  
	 }
	  catch(Exception e)
	  {
				e.printStackTrace();
	  }
	  finally
			{
					if(stmt!=null) 	stmt.close();
					if(rs!=null) 	rs.close();
					
			}
	}catch(Exception e){e.printStackTrace();}
	finally { 
		ConnectionManager.returnConnection(con,request);
     }	
%>
</center>
</BODY>
</HTML>

