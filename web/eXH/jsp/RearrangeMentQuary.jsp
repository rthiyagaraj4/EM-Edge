<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<html>
<head>
<title><fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/></title>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="JavaScript">

function Message()
{
}


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
 <table border='1' cellpadding='0' cellspacing='0' wrap width='102%' align='center' >
<%   
Connection connection	= null;
CallableStatement callableStatement=null;		
		//Statement statement		= null;
		//ResultSet resultSet		= null;
		int errFlag				= 0;
		//String sdt="";
		String exceptions		= "";
		String SysDefStructure1  = "";
		//String UserDefStructure1 = "";
String SysDefStructure  = request.getParameter("SystemDef_id");
 String  useDefStructure  = request.getParameter("event_type_id");
 String InpuType=request.getParameter("input");
 //System.out.println("SysDefStrvaluebfvjdj : "+useDefStructure+"SysDefStructure"+SysDefStructure+"Input"+InpuType);

  try{
			if(connection==null) connection = ConnectionManager.getConnection();      
		}
		catch(Exception exp){
			System.out.println("Error in calling getconnection method of ElementSegmentValidateQry  :"+exp.toString());
			exp.printStackTrace(System.err);
		//	exceptions=exceptions+"1"+"*"+exp.toString();        
		}
		try{		
              		
              callableStatement=connection.prepareCall("{ call xh_get_sysdef_structure(?,?,?,?)}");
              callableStatement.setString(1,SysDefStructure);
              callableStatement.setString(2,useDefStructure);
            //  callableStatement.registerOutParameter(3,Types.CLOB);
              //callableStatement.registerOutParameter(4,Types.CLOB);				
              callableStatement.execute();
			 
            if(InpuType.equals("System Defined Structure"))
			{
	 SysDefStructure1	=	callableStatement.getString(3);



			}
			else if(InpuType.equals("User Defined Structure"))
			{
				 SysDefStructure1	=	callableStatement.getString(4);
			}
            
       
				 
		}
	
		catch(Exception exp){
			errFlag = 1;
			System.out.println("Error in executing QueryResult of ElementSegmentValidateQry  :"+exp.toString());
			exp.printStackTrace(System.err);
			exceptions=exp.toString();        
		}
		finally{
				//System.out.println(" RearrangementLayerQryStructures errFlag : "+errFlag);

if(connection!=null)
	connection.close();
if(callableStatement!=null)
			{
	callableStatement.close();
			}
			// sdt = java.net.URLEncoder.encode(SysDefStructure1);
			//	String udt = java.net.URLEncoder.encode(UserDefStructure1);
              
		}
		
            
%>
 <tr>
			 <td  class='PATIENTLINECOLOROTHLANG'  nowrap width='30%' align='left' colspan='2'><font size='-1'><b><%=InpuType%></b></font></td></tr>
<tr>
<td  wrap width='30%' align='left' ><textarea rows="100" cols="100"><%=SysDefStructure1%></textarea></td>
</tr>
</table>
</body>
</html> 

