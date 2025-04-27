<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.lang.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eXH/js/FilterLayerReference.js' language='javascript'></script>
<script Language="JavaScript" >
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body BGCOLOR="#B2B6D7" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' CLASS="MESSAGE" >
<form > 
<%  
	Connection con = null; 
	 
	CallableStatement ostmtleval = null;  
	Statement segstmt=null;
	String status="0";
	ResultSet levelset=null;

	MessageManager mm=new MessageManager();
	Properties p;
	p = (Properties) session.getValue("jdbc");	
		String locale  = p.getProperty("LOCALE");
    request.setCharacterEncoding("UTF-8");
   	response.setContentType("text/html;charset=UTF-8"); 
   
    try
    {
       if(con==null) con = ConnectionManager.getConnection(request);
      		
	}catch(Exception exp){
         System.out.println("Error in calling getconnection method of SegmentTypeUpdate.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
    }    	
   
	try
    {

		String stnd_code=request.getParameter("stnd_code");
        request.setAttribute("standard_code",stnd_code); 

        XHSegForApplicationElementsBean xhBean=XHSegForApplicationElementsBean.getBean(XHSegForApplicationElementsBean.strBeanName,request,session);
        xhBean.action(request,con);
		String strData[][]= xhBean.getDatabaseData();
		ArrayList arrAudit = ArrayAuditInfo.getArrayAuditInfo(session);
		xhBean.action(request,con);
	    ostmtleval =con.prepareCall("{ call xhmast.segment(?,?,?,?,?,?,?,?) }" ); 
		for(int i=0;i<strData.length;i++) 
		{
     		String  usr_added_by_id=(String)arrAudit.get(0);
			String  usr_added_at_ws_no=(String)arrAudit.get(1);
			/* if(strData[i][5].equals("Y"))
			{ */
				ostmtleval.setString(1,strData[i][3]); 
				ostmtleval.setString(2,strData[i][4]);
				ostmtleval.setString(3,strData[i][1]);
				ostmtleval.setString(4,usr_added_by_id);
				ostmtleval.setString(5,usr_added_at_ws_no);
				ostmtleval.setString(6,strData[i][5]);
				ostmtleval.registerOutParameter(7,java.sql.Types.VARCHAR);
				ostmtleval.registerOutParameter(8,java.sql.Types.VARCHAR);
				ostmtleval.execute();
				status = ostmtleval.getString(7);
				if("0".equals(status))
				{
					con.commit();
					final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
					status = ((String) mesg.get("message"));
				}
				else
				{
					con.rollback();
					final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ; 
					status = ((String) mesg.get("message"));
				}
			 
			/* }
			else
			{
			} */			  
		}
		if(ostmtleval!=null)ostmtleval.close();
        out.println("");
        out.println(status);
        out.println("");
        out.println("</body>");  
		
	}
	catch(Exception exception)
	{
		System.out.println("Error in calling db realted statements in dopost method of SegmentTypeUpdate.jsp :"+exception.toString());
		exception.printStackTrace(System.err); 		
	}finally{
		try
		{
		 if(ostmtleval!=null)ostmtleval.close();
		   ConnectionManager.returnConnection(con);
		}catch(Exception ex){
		   System.out.println("Eroor in closing dbconnection dopost method of SegmentTypeUpdate.jsp :"+ex.toString());
		  ex.printStackTrace(System.err); 
		}
			//if(con!=null)

	}
    try
	{
		if(ostmtleval!=null)ostmtleval.close();
		if(levelset!=null)levelset.close();
		if(segstmt!=null)segstmt.close();
		ConnectionManager.returnConnection(con);
	}
	catch(Exception exp){
         System.out.println("Error in calling getconnection  method of SegmentTypeUpdate.jsp:"+exp.toString());
	     exp.printStackTrace(System.err);
     }    
%>

</form>
</body>
</html>