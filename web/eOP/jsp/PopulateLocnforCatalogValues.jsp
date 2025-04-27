<!DOCTYPE html>

<%@ page import ="webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey();'><form name='testform' id='testform'>");
	
	String	facilityId  = (String) session.getValue( "facility_id" ) ;
	String selclaim	= 	"";
	selclaim = request.getParameter("selclaim");

	if(selclaim ==  null) selclaim="";

	Connection con 		= null;
	Statement st = null;
	ResultSet rs1			= null; 
	String sql1 ="";
	String ID4				= "";
	String dat4				= "";
	
	try{

	con = ConnectionManager.getConnection(request);	
	if (!selclaim.equals(""))
	{%>
	 <script>
		var n = parent.frames[1].frames[0].document.forms[0].stat_group.options.length;
		for(var i=0;i<n;i++)
		parent.frames[1].frames[0].document.statgrpdtlquery.stat_group.remove("short_desc");	
		var temp = "";
		var temp1="--------"+getLabel('Common.defaultSelect.label','Common')+"--------";
		var opt=parent.frames[1].frames[0].document.createElement('OPTION');
		opt.text=temp1;
		opt.value=temp;
		parent.frames[1].frames[0].document.statgrpdtlquery.stat_group.add(opt);	
		parent.frames[1].frames[0].document.statgrpdtlquery.stat_group.options[0].selected = true;
	 </script>
	 <%

	st=con.createStatement();
	sql1 = "Select clinic_code, long_desc from op_clinic where Facility_ID = '"+facilityId+"' and CARE_LOCN_TYPE_IND='"+selclaim+"' and eff_status='E' order by 2";
	
	rs1=st.executeQuery(sql1);

		if(rs1!=null)
		{
			while(rs1.next())
			{
				dat4 = rs1.getString("long_desc");
				ID4 = rs1.getString("clinic_code");	 
			%>
			<script>
					var element = parent.frames[1].frames[0].document.createElement('OPTION');
					element.text = "<%=dat4%>";
					element.value= "<%=ID4%>";
					element.selected=false;
					parent.frames[1].frames[0].document.statgrpdtlquery.stat_group.add(element);
			</script> 
		<%
			}
		}	

		if(rs1 != null) rs1.close();
		if(st != null) st.close();
	}
	}catch(Exception e)
	{
		out.println(e);
	}
	finally{

		try{
		if(rs1!= null)	rs1.close();
		if(st != null)	st.close();
		}catch(Exception e){}
		
		if( con != null) ConnectionManager.returnConnection(con,request);
	}
%>
</form>
</body>
</html>

