<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
  
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!--head-->
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,oracle.sql.ARRAY,eXH.XHIdentify" %>
<%/*
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
*/
%>
<%
Connection connection = null;
CallableStatement ostmt = null;

String msgId="";

String ProfileID="";
String res_txt="";
String ReqText="";

String Req_syntax="";
String REs_Syn="";

String Standard_type="";
String Standard_symbols="";

String ReqText1="",Req_syntax1="",res_txt1="",REs_Syn1="";
ProfileID=request.getParameter("Profile_id");
Statement s=null;
  ResultSet r = null;
msgId=(String)session.getAttribute("Msg_Id");
//System.out.println("'Msg_Id38"+msgId+"ProfileID"+ProfileID);
try
	{
	if(connection==null) connection = ConnectionManager.getConnection();
      
      }
      catch(Exception exp)
      {
		 System.out.println("Error in calling getconnection method of ViewSegmentJSP :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }
try
{
	s= connection.createStatement();
//System.out.println("select REQUEST_TEXT, REQUEST_SYNTAX, RESPONSE_TEXT, REPONSE_SYNTAX from XH_INTERACTIVE_INTEGRATION where MESSAGE_ID='"+msgId+"'");

 r = s.executeQuery("select REQUEST_TEXT, REQUEST_SYNTAX, RESPONSE_TEXT, REPONSE_SYNTAX from XH_INTERACTIVE_INTEGRATION where MESSAGE_ID='"+msgId+"'");
 while(r.next())
	{


ReqText=java.net.URLEncoder.encode(XHIdentify.returnvalue(r.getClob(1)));

ReqText1=ReqText;

Req_syntax=java.net.URLEncoder.encode(XHIdentify.returnvalue(r.getClob(2)));
Req_syntax1=Req_syntax;
res_txt=java.net.URLEncoder.encode(XHIdentify.returnvalue(r.getClob(3)));
res_txt1=res_txt;
REs_Syn=java.net.URLEncoder.encode(XHIdentify.returnvalue(r.getClob(4)));
REs_Syn1=REs_Syn;
	}   
//System.out.println("ReqText70"+ReqText1+"Req_syntax70"+Req_syntax1+"res_txt"+res_txt1+"REs_Syn"+REs_Syn1);
r.close() ;
 s.close();


ostmt = connection.prepareCall("{ call XHSTANDARD.Fetch_standard_Control_Char(?,?,?) }" ); 
ostmt.setString(1,ProfileID);
ostmt.registerOutParameter(2,java.sql.Types.VARCHAR);
ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
ostmt.execute();
Standard_type=ostmt.getString(2);
Standard_symbols=ostmt.getString(3);


//System.out.println("Standard_symbols70"+Standard_symbols);

if(ostmt!=null) 
ostmt.close();




	
		}
catch(Exception exp)
    {
       
	   exp.printStackTrace(System.err);
    }
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of ViewSegments :"+ex.toString());
		   ex.printStackTrace(System.err); }
	    
%>
<head>
	<link rel="StyleSheet" href="../../eCommon/html/dtree.css" type="text/css" />
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel="StyleSheet" href="../../eCommon/html/lris_style.css" type="text/css" />
	<script type="text/javascript" src="../../eCommon/js/dtree1.js"></script>
	<script language="javascript" src="../../eXH/js/Viewtreeimage2.js" ></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<script>
	
	</script>
</head>
<BODY   >
<form name="view_segment_form" id="view_segment_form">
<input type=hidden name='Req_symbols' id='Req_symbols' value='<%=Standard_symbols%>' >
<input type=hidden name='Req_type' id='Req_type' value='<%=Standard_type%>' >
<input type=hidden name='Req_txt' id='Req_txt' value='<%=ReqText%>' >
<input type=hidden name='ReQ_Syn' id='ReQ_Syn' value='<%=Req_syntax%>' >
<input type=hidden name='Res_txt' id='Res_txt' value='<%=res_txt%>' >
<input type=hidden name='Res_syn' id='Res_syn' value='<%=REs_Syn%>' >


<script>  




	submitForm();

	
</script>
</form>

</BODY>
</html>






