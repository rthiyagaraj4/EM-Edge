<!DOCTYPE html>
<%--

  *	Author				:	Prashant Bhalsingh
  * Created on			:	23 July 2002
  *	Modified on			:	22 Feb 2005
  *	Purpose				:	Populates values dynamically for View Free Doc
  *
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../js/DiscreteMeasurePanel.js"></script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

	<script language='javascript'>
  	function resetSelectItem ( select_item_name, default_required ){
			var optlength = eval("f_query_add_mod.document.DiscreteMeasurePanel_form."+select_item_name).options.length;
			for (var i=0; i<optlength; i++)	{
				eval("f_query_add_mod.document.DiscreteMeasurePanel_form."+select_item_name).options.remove(select_item_name);
			}

			if(default_required)	{
//				var opt		=	parent.f_query_add_mod.document.createElement('OPTION'); 
				var opt		=	f_query_add_mod.document.createElement('OPTION'); 
				opt.text	=	"    ----- "+getLabel("Common.facility.label",'Common')+" -----    ";
				opt.value	=	'';
				eval("f_query_add_mod.document.DiscreteMeasurePanel_form."+select_item_name).add(opt);
			}
		}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
request.setCharacterEncoding("UTF-8");
	Connection			conlCon		=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rslRst		=	null;
	String  short_desc				=	"" ;
	String	discr_msr_id			=	"";
	String	service_code			=	(request.getParameter("service_code")==null)?"":request.getParameter("service_code");
	String	result_type			=	(request.getParameter("result_type")==null)?"":request.getParameter("result_type");
 
	String sql	= " select discr_msr_id, short_desc, service_code from am_discr_msr	Where eff_status = 'E' and result_type not in ('V','Z') And service_code ='" + service_code  + "' Order by short_desc";
	if(result_type.equals("V"))
		sql = " select discr_msr_id, short_desc, service_code from am_discr_msr	Where eff_status = 'E' and result_type not in ('V','Z','F') And service_code ='" + service_code  + "' Order by short_desc";

//	String frame_name		=	"parent.f_query_add_mod";
	String frame_name		=	"f_query_add_mod";


	try	
	{
		conlCon				=	(Connection)	ConnectionManager.getConnection(request);
		pstmt = conlCon.prepareStatement(sql);
		rslRst = pstmt.executeQuery();%>
		<script>
		resetSelectItem ("discr_msr_id",true);

		</script>
		<%
			while(rslRst.next()) {
			
				discr_msr_id	=(rslRst.getString("discr_msr_id")==null)?"":rslRst.getString("discr_msr_id");
				short_desc =(rslRst.getString("short_desc")==null)?"":rslRst.getString("short_desc");
		%>
			<script>
				var opt		=	<%=frame_name%>.document.createElement('OPTION'); 
				opt.text	=	"<%=short_desc%>";
				opt.value	=	"<%=discr_msr_id%>";
				<%=frame_name%>.document.forms[0].discr_msr_id.add(opt); 
			</script>
			<%
			} // end of while
     if(rslRst!=null) rslRst.close();
	 if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception@1: "+e);
	}
	finally
	{
		try
		{
		if(pstmt!=null) pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		if(conlCon!=null) ConnectionManager.returnConnection(conlCon,request);
	}

%>
	</script>
</head>
<body class='MESSAGE' onKeyDown = 'lockKey()'></body>
</html>

