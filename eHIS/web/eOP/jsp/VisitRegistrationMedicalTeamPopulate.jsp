<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*, java.text.*,java.io.*, javax.servlet.jsp.JspWriter,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
    <head>
	   <%
	   request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
        <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
	</head>

    <body CLASS='MESSAGE' onKeyDown ='lockKey()'>
        <form name="DynamicFile" id="DynamicFile">
		<%
		  Connection con = null ;		  
		  PreparedStatement   pstmt = null;
		  PreparedStatement   pstmt01 = null;
		  ResultSet     rs	 = null;
		  ResultSet     rs01 = null;
		  String facility_id       = (String) session.getValue("facility_id");

		  String practitioner	= request.getParameter("attend_ptactitioner_id") ;
		  String locationcode	= request.getParameter("location_code") ;
		  String callFromMPQuery= request.getParameter("callFromMPQuery") ;
		  if(callFromMPQuery == null || callFromMPQuery.equals("null")) callFromMPQuery = "";		 
		  
     try
       {
	        con = ConnectionManager.getConnection(request);		
				
			pstmt01   = con.prepareStatement("Select Team_Id, Team_Short_Desc from Am_Pract_For_Team_Vw where Facility_Id = '"+facility_id+"' and Practitioner_Id = '"+practitioner+"' and Appl_for_op_yn = 'Y' and Speciality_Code = (Select SPECIALITY_CODE From OP_CLINIC Where FACILITY_ID = '"+facility_id+"' and CLINIC_CODE = '"+locationcode+"') ");
			rs01 = pstmt01.executeQuery();
%>
			<script>
	
			if ("<%=callFromMPQuery%>" == "Y")
			{
				parent.parent.parent.frames[0].document.getElementById("team_prompt").innerHTML="";
				parent.parent.parent.frames[0].document.getElementById("team_desc").innerHTML="";
				parent.parent.parent.frames[0].document.forms[0].team_code.value="";          
			}
			else
		    {
				parent.frames[1].frames[1].frames[0].document.getElementById("team_prompt").innerHTML="";
				parent.frames[1].frames[1].frames[0].document.getElementById("team_desc").innerHTML="";
				parent.frames[1].frames[1].frames[0].document.forms[0].team_code.value="";          
		    }
			</script>
<%
			String teamCode02 = "";
			String teamDesc02 = "";
			String str02 = "<option value=''>&nbsp;&nbsp;-------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --------&nbsp;&nbsp;</option>";
			
			int count02 = 0;

	      if( rs01 != null )
		  {
			while( rs01.next() )
			{
				teamCode02 = rs01.getString( "Team_Id" );
				teamDesc02 = rs01.getString( "Team_Short_Desc" );
				str02 = str02 + "<option value='"+teamCode02+"'>"+teamDesc02+"</option>";
				count02++;
	        }
			

		    if(count02 > 1)
			{	
			  String vals = "<select   name=team_id id=team_id onChange='assignTeamValue(this);'>"+str02+"</select>";
%>
			<script>
			if ("<%=callFromMPQuery%>" == "Y")
			{
			   parent.parent.parent.frames[0].document.getElementById('team_prompt').innerHTML=getLabel("Common.medicalteam.label","Common");
			   parent.parent.parent.frames[0].document.getElementById('team_desc').innerHTML="<%=vals%>";
			}
			else
			{
				parent.frames[1].frames[1].frames[0].document.getElementById("team_prompt").innerHTML=getLabel("Common.medicalteam.label","Common");
				parent.frames[1].frames[1].frames[0].document.getElementById("team_desc").innerHTML="<%=vals%>";
			}
			</script>
<%
			}
			else if(count02 == 1)
			{
%>
			<script>
			if ("<%=callFromMPQuery%>" == "Y")
			{
			  parent.parent.parent.frames[0].document.getElementById("team_prompt").innerHTML=getLabel("Common.medicalteam.label","Common");
			  parent.parent.parent.frames[0].document.getElementById("team_desc").innerHTML="<b>"+"<%=teamDesc02%>";
			  parent.parent.parent.frames[0].document.forms[0].team_code.value="<%=teamCode02%>";   
			}
			else
			{
			  parent.frames[1].frames[1].frames[0].document.getElementById("team_prompt").innerHTML=getLabel("Common.medicalteam.label","Common");
			  parent.frames[1].frames[1].frames[0].document.getElementById("team_desc").innerHTML="<b>"+"<%=teamDesc02%>";
			  parent.frames[1].frames[1].frames[0].document.forms[0].team_code.value="<%=teamCode02%>";   
			}
			</script>
<%
			}
		  } 
	   }
        catch(Exception e){out.println(e);}
        finally
        {
            if(rs != null)		rs.close() ;
            if(rs01 != null)    rs01.close() ;
            if(pstmt != null)   pstmt.close() ;
			if(pstmt01 != null) pstmt01.close() ;
            if(con!=null) ConnectionManager.returnConnection(con,request);
        }
		%>
		</form>
	</body>
</html>

