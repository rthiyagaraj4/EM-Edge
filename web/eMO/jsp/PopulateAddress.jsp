<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<HTML>
<HEAD>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eMO/js/MOAreaAvailabilityQueryCriteria.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</HEAD>
<BODY CLASS='MESSAGE' onKeyDown="lockKey()">
  <form name='testform' id='testform'>
   <%
	String areaCode	    = 	"";
	String townCode	    = 	"";
    String area_code    ="";
	String selopt="";
	String res_area_desc="";
    String region_code="";
    String region_desc="";
	String framsel="";
	areaCode             =request.getParameter("areaCode")==null?"":request.getParameter("areaCode");
	townCode            = request.getParameter("townCode")==null?"":request.getParameter("townCode");
	
	framsel                = request.getParameter("framsel")==null?"":request.getParameter("framsel");
	
	
	if(framsel.equals("fram1"))
	{
	framsel="parent.frames[0]";
	
	}else
	{
    framsel="parent.frames[3]";
	}
	
	
	Connection con 	= null;
	Statement st    = null;
	ResultSet rs    = null; 
	try
	{
    con = ConnectionManager.getConnection(request);
	%>
			
		  

   <% 
	
    if(!townCode.equals(""))
	{
	//selopt="select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from mp_res_area a, mp_region b where res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+townCode+"') and a.region_code = b.region_code";

	selopt="select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from MP_RES_AREA_LANG_VW a, MP_REGION_LANG_VW b where a.LANGUAGE_ID='"+localeName+"' and b.LANGUAGE_ID='"+localeName+"' and res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+townCode+"') and a.region_code = b.region_code";

	st=con.createStatement();
	rs=st.executeQuery(selopt);
	while(rs.next())
	{
	area_code=rs.getString("res_area_code");
	res_area_desc=rs.getString("res_area_desc");
	region_code=rs.getString("region_code");
	region_desc=rs.getString("region_desc");
	%>
	
	<script>
	if(<%=framsel%>.document.forms[0].area!=null)
	<%=framsel%>.document.forms[0].area.value="<%=res_area_desc%>";
	if(<%=framsel%>.document.forms[0].area1!=null)
	<%=framsel%>.document.forms[0].area1.value="<%=area_code%>";
	if(<%=framsel%>.document.forms[0].region!=null)
	<%=framsel%>.document.forms[0].region.value="<%=region_desc%>"
		if(<%=framsel%>.document.forms[0].region1!=null)
	<%=framsel%>.document.forms[0].region1.value="<%=region_code%>";
	
	</script>
	 
	<%}
	}
	else
	{
	 //selopt="select region_code,long_desc from mp_region where  region_code = (select region_code from mp_res_area  where res_area_code = '"+areaCode +"')";
	 selopt="select region_code,long_desc from MP_REGION_LANG_VW where  LANGUAGE_ID='"+localeName+"' and region_code = (select region_code from mp_res_area  where res_area_code = '"+areaCode +"')";
	 st=con.createStatement();
	rs=st.executeQuery(selopt);
	while(rs.next())
	{
	region_code=rs.getString("region_code");
	region_desc=rs.getString("long_desc");
	%>
	<script>
	if(<%=framsel%>.document.forms[0].region!=null)
	<%=framsel%>.document.forms[0].region.value="<%=region_desc%>"
	
		if(<%=framsel%>.document.forms[0].region1!=null)
	<%=framsel%>.document.forms[0].region1.value="<%=region_code%>";
	
	</script>
	
	<%}
	}%>
		  
<%	if(st != null)	st.close();
	if(rs!= null)	rs.close();
	}
	catch(Exception e)
	{
	out.print(e);
	}
	finally
	{
	ConnectionManager.returnConnection(con,request);
	}
%>
</form>
</body>
</html>

