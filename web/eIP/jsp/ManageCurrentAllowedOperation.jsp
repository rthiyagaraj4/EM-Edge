<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.*, java.util.*,java.net.*, java.text.*,javax.servlet.jsp.JspWriter,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<html>
    <head>
	 	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
       <script language='javascript' src='../../eCommon/js/common.js'></script>
       <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
   		<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
       <script language='javascript' src='../../eIP/js/IPManageCurrent.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


  
    <%  
		request.setCharacterEncoding("UTF-8");
        Connection con=null;
        try{       
		con=ConnectionManager.getConnection(request);
         String P_USER_ID           = (String) session.getValue("login_user");
         String  P_FACILITY_ID=(String)session.getValue("facility_id");
        String P_ENCOUNTER_ID =request.getParameter("encounter_id");
		String P_PATIENT_ID=request.getParameter("patient_id");
	    String P_NURSING_UNIT  =request.getParameter("nursing_unit_code");
		if(P_NURSING_UNIT==null) P_NURSING_UNIT="";
		String P_BED_NO  =request.getParameter("bed_no");
		if(P_BED_NO==null) P_BED_NO="";
		String P_OPER_STN_ID  =request.getParameter("oper_stn_id");
		//String locale = (String) session.getValue("LOCALE");
		String res_function_name = "";
		StringBuffer tablevalues=new StringBuffer("<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>");
		StringBuffer columnvalues=new StringBuffer();
		StringBuffer columnvalues1=new StringBuffer();
    %>

</head>
<body onKeyDown='lockKey()'>
<%
            try
            {
                PreparedStatement pstmt=null;
				ResultSet rs=null;


			String sql_new="SELECT IP_GET_BED_OPERN('"+P_FACILITY_ID+"','"+P_ENCOUNTER_ID+"','"+P_PATIENT_ID+"','"+P_OPER_STN_ID+"','"+P_USER_ID+"','"+P_NURSING_UNIT+"','"+P_BED_NO+"')  res_function_name FROM DUAL";

		
			
               pstmt=con.prepareStatement(sql_new);
               rs=pstmt.executeQuery();
               
	           
			  if (rs!=null)
				{
					 while (rs.next())
					{
					  res_function_name=rs.getString("res_function_name")==null?"":rs.getString("res_function_name");
					}
					
				}
			if (pstmt != null) pstmt.close();
			if(rs != null) rs.close();


String function_name="";
String Function_st="";

if(!res_function_name.equals(""))
	{
		  StringTokenizer strToken_fnID = new StringTokenizer(res_function_name,"||");

		   while(strToken_fnID.hasMoreTokens())
	 {

           Function_st		= strToken_fnID.nextToken(); 
		   								


    if(!Function_st.equals("*"))
	 {		
          //String sql2="SELECT FUNCTION_NAME FROM SM_FUNCTION_LANG WHERE FUNCTION_ID = '"+Function_st+"' AND MODULE_ID = 'IP' AND LANGUAGE_ID = '"+locale+"'";

          String sql2="select sm_get_desc.sm_function('IP','"+Function_st+"','en',1) from dual";
			

			pstmt = con.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			
          

			  if (rs!=null)
		      {
					  while (rs.next())
					  {
						  function_name = rs.getString(1);
					  }
				}
	
	
			if (pstmt != null) pstmt.close();
			if(rs != null) rs.close();

//	 columnvalues.append("<tr><td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);' ><a>"+function_name+"</a></td></tr>");

			 columnvalues.append("<tr><td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);' ><a href=javascript:CallFunction('"+P_FACILITY_ID+"','"+P_ENCOUNTER_ID+"','"+P_PATIENT_ID+"','"+P_OPER_STN_ID+"','"+P_USER_ID+"','"+P_NURSING_UNIT+"','"+P_BED_NO+"','"+Function_st+"');>"+function_name+"</a></td></tr>") ; 

		  %>

       <% 
		   }     
	   columnvalues1.append("<input type='hidden' name='Function_st' id='Function_st' value='"+Function_st+"'>");
	  
		   }
		  
//strToken_fnID=null;
//Function_st="";
//res_function_name="";
//function_name="";
//P_USER_ID="";
//P_FACILITY_ID="";
//P_ENCOUNTER_ID="";
//P_PATIENT_ID="";
//P_OPER_STN_ID="";
//P_NURSING_UNIT="";
//P_BED_NO="";

%>
	<script>

	  var tab_dat ="<%=tablevalues%>";
      tab_dat +="<%=columnvalues%>";
      tab_dat +="<%=columnvalues1%>";
      tab_dat +="</table>";
     parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
     parent.frames[2].ManageCurrentInPatientsQueryResultForm.document.getElementById("t").innerHTML= tab_dat;
	
	  </script>
<%

	         }
	         }
            catch(Exception e){
				e.printStackTrace();
			}
       }catch(Exception e) {}
finally{	
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>

