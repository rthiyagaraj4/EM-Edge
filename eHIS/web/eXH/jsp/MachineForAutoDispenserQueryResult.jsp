<!DOCTYPE html>
<HTML>  
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page import = "java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = ((String)session.getAttribute("LOCALE")); 
 %>
<HEAD>  
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>					  
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>

<Script Language="JavaScript" src="../../eXH/js/MachineForAutoDispenser.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<Script>
function funModify(machineCode, longDesc, shortDesc,  effStatus, rowCount)
{
	//alert("rowCount..."+rowCount);
	var mode = "U";
	
	parent.f_query_add_mod.location.href = "../../eXH/jsp/MachineForAutoDispenserMaster.jsp?mode=" + mode+"&machineCode="+machineCode+"&longDesc="+longDesc+"&shortDesc="+shortDesc+"&effStatus="+effStatus;
	
}
</Script>
<BODY  leftmargin=0 topmargin=0  bgcolor='#F0F0F2' onMouseDown="CodeArrest()" onKeyDown ='lockKey()' >
<%
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
int rowCount = 0;

String   classValue="";
String MachineCode = "";
String PatientClass = "";
String LongDesc = "";
String ShortDesc = "";
String EFFStatus = "";


String mode=request.getParameter("mode");
String user_id=XHDBAdapter.checkNull(request.getParameter("user_id"));

String machine_code =  XHDBAdapter.checkNull(request.getParameter("machine_code"));	
String long_desc = XHDBAdapter.checkNull(request.getParameter("long_desc"));	

%>
<form name="MachineForAutoDispenser_Result" id="MachineForAutoDispenser_Result" target='' method='post' action=''>
<input type="hidden" name="mode" id="mode" value=''/>
<input type="hidden" name="Machine_code" id="Machine_code" />
<input type="hidden" name="Patient_class" id="Patient_class" />
<input type="hidden" name="Long_desc" id="Long_desc" />
<input type="hidden" name="Short_desc" id="Short_desc" />
<input type="hidden" name="eff_status" id="eff_status" />
 <br>
<%

try{
		con=ConnectionManager.getConnection();
		StringBuffer whereClause = new StringBuffer();
		StringBuffer whereCond = new StringBuffer();
		String sql = "";
		
		sql = "SELECT MACHINE_CODE,  LONG_DESC, SHORT_DESC, EFF_STATUS from XH_DISP_MACHINE_CODES ";
		
		if(machine_code.length() != 0 || long_desc.length() != 0 ){
			whereClause.append(" where ");
			if(machine_code.length() != 0){
				//whereClause.append(" where ");
				whereCond.append("UPPER(MACHINE_CODE) = UPPER('"+machine_code+"')");				
			}else if(long_desc.length() != 0){
				whereCond.append("UPPER(LONG_DESC) = UPPER('"+long_desc+"')");
			}else {
				whereCond.append("UPPER(MACHINE_CODE) = UPPER('"+machine_code+"') AND UPPER(LONG_DESC) = UPPER('"+long_desc+"')");
			}

			whereClause.append(whereCond);

			String ord[] = request.getParameterValues("orderbycolumns");

			if ( !(ord == null || ord .equals("")) )
			{
				whereClause.append(" order by ");

				for ( int i=0;i < ord.length;i++ )
				{
				if ( i == ord.length - 1 )
					whereClause.append(ord[i]);
				else
					whereClause.append(ord[i]+",");
				}
			}
				
			sql = sql + whereClause.toString();	
		}else{

			String ord[] = request.getParameterValues("orderbycolumns");

			if ( !(ord == null || ord .equals("")) )
			{
				//whereClause.append(" order by ");
				sql = sql + " order by ";

				for ( int i=0;i < ord.length;i++ )
				{
				if ( i == ord.length - 1 )
					//whereClause.append(ord[i]);
					sql = sql + ord[i];
				else
					//whereClause.append(ord[i]+",");
					sql = sql + ord[i]+",";
				}
			}


			sql = sql.toString();
		}



		System.out.println("MachineForAutoDispenserQueryResult..."+sql);
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
		rs=stmt.executeQuery(sql);
		rs.last(); 
		if(rs.getRow()==0)
	    { %>
		<script>
		this.document.forms[0].mode.value='E';
		alert(getMessage("XH1021","XH"));history.go(-1);
		</script>
		<%}
		else{
		
		rs.beforeFirst();
	   %>
		<table border=1 cellspacing=0 cellpadding=0 width='850px' align=center id="machineForAutoDispenserMasterTable">

<th width="150px"><fmt:message key="eXH.MachineCode.label" bundle="${xh_labels}"/></th>
<th width="300px"><fmt:message key="eXH.LongDesc.label" bundle="${xh_labels}"/></th>
<th width="300px"><fmt:message key="eXH.ShortDesc.label" bundle="${xh_labels}"/></th>
<th width="100px" colspan="2"><fmt:message key="eXH.EFFStatus.label" bundle="${xh_labels}"/></th>


   	 <%
  
		while(rs.next()) 
		{
			if ( rowCount % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
			
			MachineCode = rs.getString(1);
			LongDesc = rs.getString(2);
			ShortDesc = rs.getString(3);
			EFFStatus = rs.getString(4);

			out.println("<tr>");
			out.println("<td id='"+"MachineCode"+rowCount+"' class='"+classValue+"' style=\"text-align: center;\" size='15'>"+"<a href=\"javascript:funModify('"+MachineCode+"','"+LongDesc+"','"+ShortDesc+"','"+EFFStatus+"','"+rowCount+"');\">"+MachineCode+"</a></td><input type='hidden' name='"+"hid_MachineCode"+rowCount+"' id='"+"hid_MachineCode"+rowCount+"' value='"+MachineCode+"'/>");

			out.println("<td wrap id='"+"LongDesc"+rowCount+"' class='"+classValue+"' style=\"word-wrap: break-word\" size='50' >"+LongDesc+"</td><input type='hidden' name='"+"hid_LongDesc"+rowCount+"' id='"+"hid_LongDesc"+rowCount+"' value='"+LongDesc+"'/>");

			out.println("<td wrap id='"+"ShortDesc"+rowCount+"' class='"+classValue+"' style=\"word-wrap: break-word\"  size='50'>"+ShortDesc+"</td><input type='hidden' name='"+"hid_ShortDesc"+rowCount+"' id='"+"hid_ShortDesc"+rowCount+"' value='"+ShortDesc+"'/>");

			out.println("<td id='"+"EFFStatus"+rowCount+"' class='"+classValue+"' colspan=\"2\" style=\"text-align: center;\" >"+EFFStatus+"</td><input type='hidden' name='"+"hid_EFFStatus"+rowCount+"' id='"+"hid_EFFStatus"+rowCount+"' value='"+EFFStatus+"'/>");


			out.println("</tr>");
			%>
			<%
				rowCount++;

		}
		}
}catch(Exception e1)
{
		System.out.println("(MachineForAutoDispenseQueryResult.jsp:Error) :  "+e1.toString());
}
finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				System.out.println("(MachineForAutoDispenserQueryResult.jsp:Error) : "+e);
				}
			}
		
%>
</table>
</form>
</body>
</html>

