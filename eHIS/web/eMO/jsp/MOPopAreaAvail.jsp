<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<HTML>
<HEAD>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eMO/js/MOAreaAvailabilityQueryCriteria.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
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
	String areaval	= 	"";
	String dat4	    = 	"";
	String ID4	    = 	"";
	String selopt	= 	"";
	String status	= 	"";
	String framsel="";
	areaval         = request.getParameter("areaval");
	status          = request.getParameter("status");
	framsel          = request.getParameter("framsel");
	String mode     = request.getParameter("mode");
	String	 facilityId 			= (String) session.getValue( "facility_id" ) ;
    if(mode ==  null) mode="";
	if(framsel ==  null) framsel="";

		
	if(framsel.equals("fram1"))
	{
	framsel="parent.frames[0]";
	
	}else
	{
    framsel="parent.frames[1]";
	}
	
	if(areaval ==  null) areaval="";
	if(status ==  null)  status="";

	Connection con 	= null;
	Statement st    = null;
	ResultSet rs    = null; 
	try
	{
    con = ConnectionManager.getConnection(request);
	%>
			
		  <script>

   		  var n = <%=framsel%>.document.forms[0].area_code.length;
			 for(var i=0;i<n;i++)
			 {
			 <%=framsel%>.document.forms[0].area_code.remove("short_desc");	
			 }
			 var temp = "";
			 var temp1="--------"+getLabel('Common.defaultSelect.label','MP')+"--------";
			 var opt=<%=framsel%>.document.createElement('OPTION');
			 opt.text=temp1;
			 opt.value=temp;
			 <%=framsel%>.document.forms[0].area_code.add(opt);	
			 <%=framsel%>.document.forms[0].area_code.options[0].selected = true;
		  </script>

   <% 
	st=con.createStatement();
    if(areaval.equals(""))
	{
	
	
	
	if(status.equals("R"))
	{if(mode.equals("callfrommoreg")||mode.equals("")||mode.equals("callfrombdyprt"))
	{
	// selopt="select area_code,short_desc from mo_area union select '*' area_code,'Unassigned' short_desc from dual order by 2";
	 selopt 	 ="select area_code,short_desc from mo_area_lang_vw where facility_id = '"+facilityId+"' AND language_id='"+localeName+"'  union select '*' area_code,'"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels")+"' short_desc from dual order by 2  ";
	
	}else{
	// selopt="select area_code,short_desc from mo_area union select '*' area_code,'Unassigned' short_desc from dual union select '$' area_code,'Unregistered' short_desc from dual order by short_desc";
	 selopt ="select area_code,short_desc from mo_area_lang_vw where facility_id = '"+facilityId+"' AND language_id='"+localeName+"' union select '*' area_code,'"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels")+"' short_desc from dual union select '$' area_code,'"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.Unregistered.label","mo_labels")+"' short_desc from dual order by short_desc";

	
	}
	}
	else
	{
	// selopt ="select area_code,short_desc from mo_area order by short_desc"	;
	 selopt ="select area_code,short_desc from mo_area_lang_vw where facility_id = '"+facilityId+"' AND language_id='"+localeName+"' order by short_desc"	;
	}
	}
	else
	{
	 //selopt ="select area_code,short_desc from mo_area where area_type='"+areaval+"'order by short_desc"	;	
	 selopt ="select area_code,short_desc from mo_area_lang_vw where area_type='"+areaval+"' and facility_id = '"+facilityId+"' AND language_id='"+localeName+"' order by short_desc"	;	
	}

	rs=st.executeQuery(selopt);

	if(rs!=null)
	{
			while(rs.next())
			{
			
				dat4 = rs.getString("short_desc");
				ID4 = rs.getString("area_code");
    %>
		  <script>
			 var element = <%=framsel%>.document.createElement('OPTION');
			 element.text = "<%=dat4%>";
			 element.value= "<%=ID4%>";
			 element.selected=false;
             <%=framsel%>.document.forms[0].area_code.add(element);
				
		  </script>
<%			
		    }
	}	
	if(st != null)	st.close();
	if(rs!= null)	rs.close();
	}
	catch(Exception e)
	{
	out.print(e);
	e.printStackTrace();
	}
	finally
	{
	ConnectionManager.returnConnection(con,request);
	}
%>
</form>
</body>
</html>

