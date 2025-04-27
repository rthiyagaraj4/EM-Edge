<!DOCTYPE html>


<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html; charset=UTF-8" %>

<html>
<head>
  <!--   <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
  <%
  request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<%
    String url1 = "../../eOP/jsp/QPVepisodelist.jsp?" ;
    String url2 = "../../eCommon/html/blank.html" ;
    String blnk = request.getParameter("blnk") ;
   
    String patid=request.getParameter("patid");
    String mrnno=request.getParameter("mrnno");
    String enctid=request.getParameter("enctid");
    String dtfrm=request.getParameter("dtfrm");
    String dtto=request.getParameter("dtto");
    String serv=request.getParameter("serv");
    String loc=request.getParameter("loc");
    String pract=request.getParameter("pract");
	String episode_no=request.getParameter("episode_id");
	if(episode_no == null) episode_no="";
	//out.println("episode_no "+episode_no);
    

    String openEpisode = request.getParameter("openEpisode");
    if(openEpisode == null) openEpisode="";
    
    String params1="blnk="+blnk+"&patid="+patid+"&mrnno="+mrnno+"&enctid="+enctid+"&dtfrm="+dtfrm+"&dtto="+dtto+"&serv="+serv+"&loc="+loc+"&pract="+pract+"&openEpisode="+openEpisode+"&episode_id="+episode_no;
    String source1 = url1 + params1;
   
    String source2 = url2;   
%>

<iframe name='episode_list_frame' id='episode_list_frame' src=<%=source1%> frameborder=0 noresize style='height:55vh;width:100vw'></iframe>
    <iframe name='episode_notes_frame' id='episode_notes_frame' src=<%=source2%> frameborder=0 scrolling='no' noresize style='height:35vh;width:100vw'></iframe>


</html>


