<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
String url ="";
String url2 ="";
String applicationid=request.getParameter("application_id");
String Facility_id=request.getParameter("Facility_id");
String eventype=request.getParameter("eventype");
String protocollinkid=request.getParameter("protocollinkid");

//System.out.println("applicationid :"+applicationid+"Facility_id :"+Facility_id+"eventype :"+eventype+"protocollinkid 17 :"+protocollinkid);
/*String	appli=(String)session.getAttribute("applicationName");
String	facility_name=(String)session.getAttribute("facilityname");
String Query_Option=(String)session.getAttribute("Query_Option");
String Query_Status=(String)session.getAttribute("Query_Status");
String	msgid=(String)session.getAttribute("msgId");*/
String	appli=request.getParameter("applicationName");
String	facility_name=request.getParameter("facilityname");
String  Query_Option=request.getParameter("Query_Option");
String  Query_Status=request.getParameter("Query_Status");
String	msgid=request.getParameter("msgId");
//System.out.println("appli :"+appli+" facility_name :"+facility_name+"msgId :"+msgid);
String	mode=request.getParameter("mode");
if(mode!=null){ 
	if(appli!=null)
	{
		//session.setAttribute("applicationName",appli);
	}
	else
	{ 
		appli="All";
		//session.setAttribute("applicationName","All");
	}

if(facility_name!=null){
		//session.setAttribute("facilityName",facility_name);
		}

else
	{
	facility_name="All";
	//session.setAttribute("facilityName","All");
	}

//session.setAttribute("Query_Option",Query_Option);
//session.setAttribute("msgId",msgid);
session.setAttribute("mode",mode); 
//session.setAttribute("Query_Status",Query_Status);
}
 url = "../../eXH/jsp/ViewQueryMessageMenuTreeText.jsp?application_id="+applicationid+"&msgId="+msgid+"&Facility_id="+Facility_id+"&eventype="+eventype+"&protocollinkid="+protocollinkid+"&facilityname="+facility_name+"&applicationName="+appli+"&Query_Option="+Query_Option+"&Query_Status="+Query_Status;

//System.out.println("URL2 :"+url);

url2="../../eXH/jsp/ViewQueryMessageMenuTree.jsp?application_id="+applicationid+"&msgId="+msgid+"&Facility_id="+Facility_id+"&eventype="+eventype+"&protocollinkid="+protocollinkid+"&facilityname="+facility_name+"&applicationName="+appli+"&Query_Option="+Query_Option+"&Query_Status="+Query_Status;
//System.out.println("URL2 :"+url2);
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<title>View Message</title> 
<iframe src=<%=url2%>  name="master_menu" noresize scrolling='auto' style='height:100vh;width:38.5vw></iframe>
<iframe src=<%=url%> name="master_pages"  marginwidth="0" marginheight="0" scrolling='no' noresize style='height:100vh;width:61.5vw></iframe>

</html> 

