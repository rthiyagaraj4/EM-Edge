<!DOCTYPE html>
<html> 
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eXH/js/InterfaceStandards.js" ></script> 
<script language="JavaScript" src="../../eXH/js/checkfield.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
String params = request.getQueryString() ;
	String source = url + params ;
	session.setAttribute("params",params);
//System.out.println("params1"+params);
String application_id=""; 
String facility_id=""; 
String mesg_type_id=""; 
String event_type_id=""; 
String segment_type_id="";
String protocol_link_id=""; 

String standard_code="";
String standard_desc="";
String standard_type="";
String msg_start="";
String msg_end="";
String seg_start="";
String seg_end="";
String fld_separator="";
String elmnt_separator="";

String application_name=""; 
String facility_name=""; 
String mesg_type=""; 
String event_type=""; 
String segment_type="";
String protocol_linkName="";



try
{
String mode			=	request.getParameter("mode");

if(mode.equals("U"))
{
	standard_desc=request.getParameter("standard_desc");
	standard_type=request.getParameter("standard_type");
	msg_start=request.getParameter("msg_start");
	msg_end=request.getParameter("msg_end");
	seg_start=request.getParameter("seg_start");
	seg_end=request.getParameter("seg_end");
	fld_separator=request.getParameter("fld_separator");
	elmnt_separator=request.getParameter("elmnt_separator");

	session.setAttribute("standard_desc",standard_desc);
session.setAttribute("standard_type",standard_type);
session.setAttribute("msg_start",msg_start);
session.setAttribute("msg_end",msg_end);
session.setAttribute("seg_start",seg_start);
session.setAttribute("seg_end",seg_end);
session.setAttribute("fld_separator",fld_separator);
session.setAttribute("elmnt_separator",elmnt_separator);
session.setAttribute("standard_code",standard_code);
session.setAttribute("application_id",application_id);
session.setAttribute("facility_id",facility_id);
session.setAttribute("mesg_type_id",mesg_type_id);
session.setAttribute("event_type_id",event_type_id);
session.setAttribute("segment_type_id",segment_type_id);
session.setAttribute("protocol_link_id",protocol_link_id);
application_name=request.getParameter("application_name");
	facility_name=request.getParameter("facility_name");
	mesg_type=request.getParameter("mesg_type");
	event_type=request.getParameter("event_type");
	segment_type=request.getParameter("segment_type");
	protocol_linkName=request.getParameter("protocol_linkName");
	}

else
{
}

application_id		=	request.getParameter("application_id");
facility_id			=	request.getParameter("facility_id");
mesg_type_id		=	request.getParameter("mesg_type_id");
event_type_id		=	request.getParameter("event_type_id");
segment_type_id		=	request.getParameter("segment_type_id");
protocol_link_id	=	request.getParameter("protocol_link_id");

}
catch(Exception exp)
    {
       
	   exp.printStackTrace(System.err);
    }

%>



<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod'  src='../../eXH/jsp/InterfaceStandardsSelectMaster.jsp?rule=NR&mode=I' frameborder=0  scrolling='auto' style='height:50vh;width:100vw'></iframe>
<iframe name='f_query_add_mod_detail' id='f_query_add_mod_detail'  src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:30vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0  scrolling='auto' style='height:12vh;width:100vw'></iframe>

</html>





