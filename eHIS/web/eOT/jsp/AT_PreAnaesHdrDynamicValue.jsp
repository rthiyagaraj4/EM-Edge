<!DOCTYPE html>
<%@page   import="eCommon.Common.*,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.sql.Statement,webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<html>
<head>

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	double weight		= Double.parseDouble(request.getParameter("weight"));
	double height		= Double.parseDouble(request.getParameter("height"));
//	double  bsa=Math.sqrt((height*weight)/3600);	0.20247* height(m) 0.725 * wt(kg) 0.425
	double  bsa= 0.20247*Math.pow((height/100),0.725) *Math.pow(weight,0.425);
//	System.err.println(" bsa in line 21 : "+bsa);
	double ix = (bsa * 100.0);
	ix = Math.round(ix);
	bsa = ix/100.0;
	//bsa=Math.round(bsa);
	double bmi=Math.round((weight/(Math.pow((height/100),2.0))));
	//System.err.println(" bsa in line 21 : "+bsa);
	String status_desc="";
	Connection connection   = null ;
	Statement stmt = null ;
	ResultSet resultSet     = null ;
	String sql_status="SELECT STATUS_DESC FROM   AT_BMI_ANALYSIS WHERE  to_number('"+bmi+"') BETWEEN MIN_VALUE AND MAX_VALUE ";

	try{
			connection			= ConnectionManager.getConnection(request);
			stmt				= connection.createStatement() ;
			resultSet			= stmt.executeQuery(sql_status);
			while(resultSet!=null && resultSet.next())
				{
					status_desc = resultSet.getString("STATUS_DESC");
				}
		}catch (Exception e) {
				e.printStackTrace() ;
		}finally {
            try{
					if(resultSet!=null) resultSet.close();
					if(stmt!=null) stmt.close();
					if(connection!=null) ConnectionManager.returnConnection(connection,request);
				}catch(Exception es){es.printStackTrace();}
        }
	%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="frm_temp" id="frm_temp" >
<script>
var status_desc='<%=status_desc%>';
	if(status_desc=="" || status_desc=="null" || status_desc=="null" || status_desc=="null"){
		//parent.frames[2].document.forms[0].bsaDisp.value="";
		parent.frames[2].document.forms[0].bsaDisp.value="";
		parent.frames[2].document.forms[0].bmi.value="";	
		parent.frames[2].document.forms[0].status_desc.value="";
	}else{
		//parent.frames[2].document.forms[0].bsaDisp.value='<%=bsa%>';
		parent.frames[2].document.forms[0].bsaDisp.value='<%=bsa%>';
		parent.frames[2].document.forms[0].bmi.value='<%=bmi%>';	
		parent.frames[2].document.forms[0].status_desc.value='<%=status_desc%>';
	}
</script>
</form>
</body>
</html>

