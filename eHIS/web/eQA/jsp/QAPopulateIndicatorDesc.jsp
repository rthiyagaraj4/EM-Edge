<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script>






<%

	PreparedStatement pstmt = null;
	ResultSet         rs    = null;
    Connection        conn  = null; 
	conn  = ConnectionManager.getConnection(request);
try
{
	String repyn = request.getParameter("reportyn")==null?"":request.getParameter("reportyn");

	if(repyn.equals("Y"))
	{
	String dflt_rep_periodicity="";
	String	facilityId 					= (String) session.getValue( "facility_id" ) ;
	String indicator_id = request.getParameter("indicator_id")==null?"":request.getParameter("indicator_id");
	//conn  = ConnectionManager.getConnection(request);
	pstmt = conn.prepareStatement("select DFLT_REP_PERIODICITY FROM QA_QIND_FACILITY_CLIND WHERE OPERATING_FACILITY_ID =? and QIND_CLIND_ID =?");
	pstmt.setString(1,facilityId);
	pstmt.setString(2,indicator_id);
	rs = pstmt.executeQuery();
	
		
	if(rs!=null)
		{
			while(rs.next())
			{
				dflt_rep_periodicity = rs.getString(1);
			}
		}
		if(dflt_rep_periodicity.equals("M"))
		{
		out.println("<script>parent.f_query_add_mod.document.getElementById('P_PERIODICITY').options[1].selected=true</script>"); %>
		<script>
			var objFrom=parent.f_query_add_mod.document.forms[0].P_FROM;
			var objTo=parent.f_query_add_mod.document.forms[0].P_TO;
			var arr = new Array();
			parent.f_query_add_mod.document.forms[0].P_FROM.disabled=false
			parent.f_query_add_mod.document.forms[0].P_TO.disabled=false
			parent.f_query_add_mod.document.getElementById('hide').style.visibility='visible'	
			arr = new Array("1-JAN","2-FEB","3-MAR","4-APR","5-MAY","6-JUN","7-JUL", "8-AUG","9-SEP","10-OCT","11-NOV","12-DEC");
			parent.f_query_add_mod.removeAll(objFrom);
			parent.f_query_add_mod.removeAll(objTo);
			parent.f_query_add_mod.addAll(objFrom,arr);
			parent.f_query_add_mod.addAll(objTo,arr);
		</script>
	<%	}else if(dflt_rep_periodicity.equals("Q")){ 
		out.println("<script>parent.f_query_add_mod.document.getElementById('P_PERIODICITY').options[2].selected=true</script>"); %>
		<script>
			var objFrom=parent.f_query_add_mod.document.forms[0].P_FROM;
			var objTo=parent.f_query_add_mod.document.forms[0].P_TO;
			var arr = new Array();
			parent.f_query_add_mod.document.forms[0].P_FROM.disabled=false
			parent.f_query_add_mod.document.forms[0].P_TO.disabled=false
			
			arr = new Array("Q1-Quarter 1","Q2-Quarter 2","Q3-Quarter 3","Q4-Quarter 4");
			parent.f_query_add_mod.document.getElementById('hide').style.visibility='visible'	
			parent.f_query_add_mod.removeAll(objFrom);
			parent.f_query_add_mod.removeAll(objTo);
			parent.f_query_add_mod.addAll(objFrom,arr);
			parent.f_query_add_mod.addAll(objTo,arr);
		</script>


	<%	}else if(dflt_rep_periodicity.equals("B"))
		{
		out.println("<script>parent.f_query_add_mod.document.getElementById('P_PERIODICITY').options[3].selected=true</script>"); %>
			
		<script>
			var objFrom=parent.f_query_add_mod.document.forms[0].P_FROM;
			var objTo=parent.f_query_add_mod.document.forms[0].P_TO;
			var arr = new Array();
			arr = new Array("F-First Half","S-Second Half");
			parent.f_query_add_mod.document.forms[0].P_FROM.disabled=false
			parent.f_query_add_mod.document.forms[0].P_TO.disabled=false
			parent.f_query_add_mod.document.getElementById('hide').style.visibility='visible'	
			parent.f_query_add_mod.removeAll(objFrom);
			parent.f_query_add_mod.removeAll(objTo);
			parent.f_query_add_mod.addAll(objFrom,arr);
			parent.f_query_add_mod.addAll(objTo,arr);
		</script>

		<%}else if(dflt_rep_periodicity.equals("A"))
		{
		out.println("<script>parent.f_query_add_mod.document.getElementById('P_PERIODICITY').options[4].selected=true</script>"); %>
		<script>
			var objFrom=parent.f_query_add_mod.document.forms[0].P_FROM;
			var objTo=parent.f_query_add_mod.document.forms[0].P_TO;
			var arr = new Array();
			parent.f_query_add_mod.removeAll(objFrom);
			parent.f_query_add_mod.removeAll(objTo);
			parent.f_query_add_mod.document.getElementById('hide').style.visibility='hidden'
			parent.f_query_add_mod.document.forms[0].P_FROM.disabled=true
			parent.f_query_add_mod.document.forms[0].P_TO.disabled=true
		</script>
		<%}




		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	
	}else
	{
	String popclind = request.getParameter("popclind")==null?"":request.getParameter("popclind");
	String indicator_id = request.getParameter("indicator_id")==null?"":request.getParameter("indicator_id");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
    String indicator_desc = "";
    String indi_class = "";
	//conn  = ConnectionManager.getConnection(request);
	pstmt = conn.prepareStatement("select QIND_CLIND_DESC,CLIND_CLASS from qa_qind_clind where QIND_CLIND_ID = ?");
	pstmt.setString(1,indicator_id);
	rs = pstmt.executeQuery();
	if(rs!=null)
		{
			while(rs.next())
			{
				indicator_desc = rs.getString(1);
			    indi_class     = rs.getString(2);
			}
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if((indicator_desc==null) || (indicator_desc.equals("null")))
			indicator_desc="";

if(popclind.equals("popclind") &&(!mode.equals("U")))
{
		out.println("<script>var obj=parent.f_query_add_mod.document.getElementById('diag_proc_ind');</script>");
        out.println("<script> var length = obj.length;for(i=0;i<length;i++) obj.remove(1);</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('mandatorydiag').style.visibility='visible'</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('Schemetype').style.visibility ='visible'</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('CLIND_CLASS').value ='"+indi_class+"'</script>");

if(indi_class.equals("D"))
	{
		out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
        out.println("<script>opt.text='Diagnosis';</script>");
        out.println("<script>opt.value='D';</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('diag_proc_ind').add(opt)</script>");
	
	out.println("<script>parent.f_query_add_mod.document.getElementById('diag_proc_ind').options[1].selected=true</script>");
	}
	
	if(indi_class.equals("P"))
	{
		out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
        out.println("<script>opt.text='Procedure';</script>");
        out.println("<script>opt.value='P';</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('diag_proc_ind').add(opt)</script>");
	
	out.println("<script>parent.f_query_add_mod.document.getElementById('diag_proc_ind').options[1].selected=true</script>");
	}
	if(indi_class.equals("O"))
	{
		
		out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
        out.println("<script>opt.text='Orderable';</script>");
        out.println("<script>opt.value='O';</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('diag_proc_ind').add(opt)</script>");
	
	out.println("<script>parent.f_query_add_mod.document.getElementById('diag_proc_ind').options[1].selected=true</script>");
	}


if(indi_class.equals("Z"))
	{
		
		

		out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
        out.println("<script>opt.text='Diagnosis';</script>");
        out.println("<script>opt.value='D';</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('diag_proc_ind').add(opt)</script>");
		out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
        out.println("<script>opt.text='Procedure';</script>");
        out.println("<script>opt.value='P';</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('diag_proc_ind').add(opt)</script>");
	
	out.println("<script>parent.f_query_add_mod.document.getElementById('diag_proc_ind').options[1].selected=true</script>");
	}
}%>

<script>parent.f_query_add_mod.document.getElementById('indicator').innerHTML="<b><%=indicator_desc%></b>"
</script>

<%if(indi_class.equals("M"))
	{%>
<script>parent.f_query_add_mod.document.getElementById('diag').innerHTML="Code"
	parent.f_query_add_mod.document.getElementById('mandatorydiag').style.visibility='hidden'
	parent.f_query_add_mod.document.getElementById('Schemetype').style.visibility='hidden'
</script>
	<%}%>

	<%if(indi_class.equals("S") || indi_class.equals("A") || indi_class.equals("N"))
	{%>
<script>
	parent.f_query_add_mod.document.getElementById('mandatorydiag').style.visibility='hidden'
	parent.f_query_add_mod.document.getElementById('Schemetype').style.visibility='hidden'
	
</script>
	<%}%>

<%	}
}catch(Exception e)
{
	out.println("Exception in File QAPopulateIndicatorDesc"+e.toString());
}
finally
{
	ConnectionManager.returnConnection(conn,request);
}

%>

