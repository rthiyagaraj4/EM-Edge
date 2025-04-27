<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eAE/js/GCSScore.js'></script>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
  <%	
     Connection con 					= null;
	 PreparedStatement pstmt			= null;
	 ResultSet rset					    = null;
	 PreparedStatement pstmt1			= null;
	 ResultSet rset1				    = null;
	 String mode						= "";
	 int i								= 0;
	 int j								= 0;
	 int k								= 0;
	 String classValue					= "";

  try
  {
	 request.setCharacterEncoding("UTF-8");
     con								= ConnectionManager.getConnection(request);
	 String er_gcs_code1_score			= "";
	 String	er_gcs_code2_score			= "";
	 String er_gcs_code3_score			= "";
	 String er_gcs_code4_score			= "";
	 String vr_gcs_code1_score			= "";
	 String vr_gcs_code2_score			= "";
	 String vr_gcs_code3_score			= "";
	 String vr_gcs_code4_score			= ""; 
	 String vr_gcs_code5_score			= "";
	 String mr_gcs_code1_score			= "";
	 String mr_gcs_code2_score			= "";
	 String mr_gcs_code3_score			= ""; 
	 String mr_gcs_code4_score			= ""; 
	 String mr_gcs_code5_score			= "";  
	 String mr_gcs_code6_score			= "";  
		mode							= "INSERT";
   
    StringBuffer sql = new StringBuffer();
	sql.append(" Select GCS_RESPONSE_CODE_ER, ER_GCS_CODE1, ER_GCS_CODE1_SCORE, ");
	sql.append(" ER_GCS_CODE2, ER_GCS_CODE2_SCORE, ER_GCS_CODE3, ER_GCS_CODE3_SCORE, ");
    sql.append(" ER_GCS_CODE4, ER_GCS_CODE4_SCORE, GCS_RESPONSE_CODE_VR, VR_GCS_CODE1, ");
    sql.append(" VR_GCS_CODE1_SCORE, VR_GCS_CODE2, VR_GCS_CODE2_SCORE, VR_GCS_CODE3, ");          
	sql.append(" VR_GCS_CODE3_SCORE, VR_GCS_CODE4, VR_GCS_CODE4_SCORE, VR_GCS_CODE5, ");
	sql.append(" VR_GCS_CODE5_SCORE, GCS_RESPONSE_CODE_MR, MR_GCS_CODE1, MR_GCS_CODE1_SCORE, ");     
	sql.append(" MR_GCS_CODE2, MR_GCS_CODE2_SCORE, MR_GCS_CODE3, MR_GCS_CODE3_SCORE, ");
	sql.append(" MR_GCS_CODE4, MR_GCS_CODE4_SCORE, MR_GCS_CODE5, MR_GCS_CODE5_SCORE, ");
	sql.append(" MR_GCS_CODE6, MR_GCS_CODE6_SCORE from AE_GCS_SCORE where MODULE_ID='AE'");	    
	//where module_id='AE'";
	pstmt   = con.prepareStatement(sql.toString());
	rset = pstmt.executeQuery();
	 while(rset!=null && rset.next())
	  {
	 		er_gcs_code1_score					= rset.getString("ER_GCS_CODE1_SCORE");    
			er_gcs_code1_score 					= (er_gcs_code1_score == null)?"":er_gcs_code1_score;
	 		er_gcs_code2_score					= rset.getString("ER_GCS_CODE2_SCORE");    
			er_gcs_code2_score 					= (er_gcs_code2_score == null)?"":er_gcs_code2_score;
	 		er_gcs_code3_score					= rset.getString("ER_GCS_CODE3_SCORE");    
			er_gcs_code3_score 					= (er_gcs_code3_score == null)?"":er_gcs_code3_score;
	 		er_gcs_code4_score					= rset.getString("ER_GCS_CODE4_SCORE");    
			er_gcs_code4_score 					= (er_gcs_code4_score == null)?"":er_gcs_code4_score;

			vr_gcs_code1_score					= rset.getString("VR_GCS_CODE1_SCORE");    
			vr_gcs_code1_score 					= (vr_gcs_code1_score == null)?"":vr_gcs_code1_score;
	 		vr_gcs_code2_score					= rset.getString("VR_GCS_CODE2_SCORE");    
			vr_gcs_code2_score 					= (vr_gcs_code2_score == null)?"":vr_gcs_code2_score;
	 		vr_gcs_code3_score					= rset.getString("VR_GCS_CODE3_SCORE");    
			vr_gcs_code3_score 					= (vr_gcs_code3_score == null)?"":vr_gcs_code3_score;
	 		vr_gcs_code4_score					= rset.getString("VR_GCS_CODE4_SCORE");    
			vr_gcs_code4_score 					= (vr_gcs_code4_score == null)?"":vr_gcs_code4_score;
			vr_gcs_code5_score					= rset.getString("VR_GCS_CODE5_SCORE");    
			vr_gcs_code5_score 					= (vr_gcs_code5_score == null)?"":vr_gcs_code5_score;

			mr_gcs_code1_score					= rset.getString("MR_GCS_CODE1_SCORE");    
			mr_gcs_code1_score 					= (mr_gcs_code1_score == null)?"":mr_gcs_code1_score;
	 		mr_gcs_code2_score					= rset.getString("MR_GCS_CODE2_SCORE");    
			mr_gcs_code2_score 					= (mr_gcs_code2_score == null)?"":mr_gcs_code2_score;
	 		mr_gcs_code3_score					= rset.getString("MR_GCS_CODE3_SCORE");    
			mr_gcs_code3_score 					= (mr_gcs_code3_score == null)?"":mr_gcs_code3_score;
	 		mr_gcs_code4_score					= rset.getString("MR_GCS_CODE4_SCORE");    
			mr_gcs_code4_score 					= (mr_gcs_code4_score == null)?"":mr_gcs_code4_score;
			mr_gcs_code5_score					= rset.getString("MR_GCS_CODE5_SCORE");    
			mr_gcs_code5_score 					= (mr_gcs_code5_score == null)?"":mr_gcs_code5_score;
			mr_gcs_code6_score					= rset.getString("MR_GCS_CODE6_SCORE");    
			mr_gcs_code6_score 					= (mr_gcs_code6_score == null)?"":mr_gcs_code6_score;


			mode								= "MODIFY";
	  }
	  if(rset!=null)  rset.close();
	  if(pstmt!=null)  pstmt.close();
	  pstmt1 = con.prepareStatement("select GCS_CODE,GCS_DESC,APPL_GCS_RESPONSE_CODE from AE_GCS_FOR_RESPONSE where APPL_GCS_RESPONSE_CODE = ? ");
   %>

	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="gcs_for_response_form" id="gcs_for_response_form" action="../../servlet/eAE.GCSScoreServlet" method="post" target="messageFrame">
		 <!--<br>-->
		 <table border="1" cellpadding="0" cellspacing="0" align='center' width='100%'>
		<%	pstmt   = con.prepareStatement("select GCS_RESPONSE_DESC from AE_GCS_RESPONSE where GCS_RESPONSE_CODE = ?");
			pstmt.setString(1,"ER");
			rset = pstmt.executeQuery();
			while(rset!=null && rset.next())
			{
		%>	
			<th align='left'>
		<%    out.println(rset.getString(1));  %>
			 <input type='hidden' name='er_error_desc' id='er_error_desc' value='<%=rset.getString(1)%>'>
			</th>
			<th align='center'><fmt:message key="Common.Score.label" bundle="${common_labels}"/></th>
		<%  }
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
		 %>

	<%
			pstmt1.setString(1,"ER");
			rset1 = pstmt1.executeQuery();
			while(rset1!=null && rset1.next())
		   {
				if ( i % 2 == 0 )
			  		classValue = "QRYEVEN" ;
				else
		  			classValue = "QRYODD" ;
 	%>
	    <tr>
		      <td class='<%=classValue%>' align='LEFT' width='85%'><%=rset1.getString(2)%>
		      <input type='hidden' name='er_code<%=i%>' id='er_code<%=i%>' value='<%=rset1.getString(1)%>'>
		      </td>
		      <td class='<%=classValue%>' align='center' width='15%'>&nbsp;
			  <select name='er_gcs_code1_weight<%=i%>' id='er_gcs_code1_weight<%=i%>'>
				   <option value='1'>1
		 		   <option value='2'>2
			       <option value='3'>3
		 		   <option value='4'>4
		      </select>
   		  	  </td> 	
	    </tr>	
    <%
        i++;
	   }  // End of while rset1
        if(rset1!=null) rset1.close();
	    //if(pstmt1!=null) pstmt1.close();
    %>
     <%		pstmt   = con.prepareStatement("select GCS_RESPONSE_DESC from AE_GCS_RESPONSE where 	GCS_RESPONSE_CODE = ?");
	    pstmt.setString(1,"VR");
			rset = pstmt.executeQuery();
			while(rset!=null && rset.next())
			{
	%>	
        <th align='left' >
        <%    out.println(rset.getString(1));%>
			 <input type='hidden' name='vr_error_desc' id='vr_error_desc' value='<%=rset.getString(1)%>'>
		</th>
		<th align='center'>&nbsp;&nbsp;<fmt:message key="Common.Score.label" bundle="${common_labels}"/></th>
	<%  }	
			if(pstmt!=null) pstmt.close();
			if(rset!=null) rset.close();

			pstmt1.setString(1,"VR");
			rset1 = pstmt1.executeQuery();
			while(rset1!=null && rset1.next())
		{
				if ( j % 2 == 0 )
			  		classValue = "QRYEVEN" ;
				else
		  			classValue = "QRYODD" ;
 	%>
    <tr>
		      <td class='<%=classValue%>' align='left' width='85%'><%=rset1.getString(2)%>
		      <input type='hidden' name='vr_code<%=j%>' id='vr_code<%=j%>' value='<%=rset1.getString(1)%>'>
		      </td>
		      <td class='<%=classValue%>' align='center' width='15%'>&nbsp;
			  <select name='vr_gcs_code1_weight<%=j%>' id='vr_gcs_code1_weight<%=j%>'>
		      	   <option value='1'>1
		 		   <option value='2'>2
			       <option value='3'>3
		 		   <option value='4'>4
				   <option value='5'>5
		      </select>
   		  	  </td> 	
	    </tr>	
    <%
        j++;
	   }  // End of while rset1
        if(rset1!=null) rset1.close();
	   // if(pstmt1!=null) pstmt1.close();
    %>
	 <%	pstmt   = con.prepareStatement("select GCS_RESPONSE_DESC from AE_GCS_RESPONSE where GCS_RESPONSE_CODE = ?");
	    pstmt.setString(1,"MR");
		rset = pstmt.executeQuery();
		while(rset!=null && rset.next())
		{
	%>	
		
        <th align='left' >
        <%    out.println(rset.getString(1));  %>
		 <input type='hidden' name='mr_error_desc' id='mr_error_desc' value='<%=rset.getString(1)%>'>
		</th>
		<th align='center'>&nbsp;&nbsp;<fmt:message key="Common.Score.label" bundle="${common_labels}"/></th>
    <%  }	
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
    %>
	<%
			pstmt1.setString(1,"MR");
			rset1 = pstmt1.executeQuery();
			while(rset1!=null && rset1.next())
		   {
				if ( k % 2 == 0 )
			  		classValue = "QRYEVEN" ;
				else
		  			classValue = "QRYODD" ;
 	%>
<tr>
		      <td class='<%=classValue%>' align='left' width='85%'><%=rset1.getString(2)%>
		      <input type='hidden' name='mr_code<%=k%>' id='mr_code<%=k%>' value='<%=rset1.getString(1)%>'>
		      </td>
		      <td class='<%=classValue%>' align='center' width='15%'>&nbsp;
			  <select name='mr_gcs_code1_weight<%=k%>' id='mr_gcs_code1_weight<%=k%>'>
		      
				   <option value='1'>1
		 		   <option value='2'>2
			       <option value='3'>3
		 		   <option value='4'>4
   			       <option value='5'>5
				   <option value='6'>6
		      </select>
   		  	  </td> 	
	    </tr>	
    <%
        k++;
	   }  // End of while rset1
        if(rset1!=null) rset1.close();
	    if(pstmt1!=null) pstmt1.close();
    %>
	 </table> 
		     <input type='hidden' name='mode' id='mode' value='<%=mode%>' >	
		     <input type='hidden' name='total_vr' id='total_vr' value='<%=j%>'>
		     <input type='hidden' name='total_mr' id='total_mr' value='<%=k%>'>
	  	     <input type='hidden' name='total_er' id='total_er' value='<%=i%>'>

			 <input type=hidden name='er_gcs_code1_score' id='er_gcs_code1_score' value='<%=er_gcs_code1_score%>'>
			 <input type=hidden name='er_gcs_code2_score' id='er_gcs_code2_score' value='<%=er_gcs_code2_score%>'>
			 <input type=hidden name='er_gcs_code3_score' id='er_gcs_code3_score' value='<%=er_gcs_code3_score%>'>
			 <input type=hidden name='er_gcs_code4_score' id='er_gcs_code4_score' value='<%=er_gcs_code4_score%>'>

			 <input type=hidden name='vr_gcs_code1_score' id='vr_gcs_code1_score' value='<%=vr_gcs_code1_score%>'>
			 <input type=hidden name='vr_gcs_code2_score' id='vr_gcs_code2_score' value='<%=vr_gcs_code2_score%>'>
			 <input type=hidden name='vr_gcs_code3_score' id='vr_gcs_code3_score' value='<%=vr_gcs_code3_score%>'>
			 <input type=hidden name='vr_gcs_code4_score' id='vr_gcs_code4_score' value='<%=vr_gcs_code4_score%>'>
			 <input type=hidden name='vr_gcs_code5_score' id='vr_gcs_code5_score' value='<%=vr_gcs_code5_score%>'>

			 <input type=hidden name='mr_gcs_code1_score' id='mr_gcs_code1_score' value='<%=mr_gcs_code1_score%>'>
			 <input type=hidden name='mr_gcs_code2_score' id='mr_gcs_code2_score' value='<%=mr_gcs_code2_score%>'>
			 <input type=hidden name='mr_gcs_code3_score' id='mr_gcs_code3_score' value='<%=mr_gcs_code3_score%>'>
			 <input type=hidden name='mr_gcs_code4_score' id='mr_gcs_code4_score' value='<%=mr_gcs_code4_score%>'>
			 <input type=hidden name='mr_gcs_code5_score' id='mr_gcs_code5_score' value='<%=mr_gcs_code5_score%>'>
			 <input type=hidden name='mr_gcs_code6_score' id='mr_gcs_code6_score' value='<%=mr_gcs_code6_score%>'>

	 </form>
		  <%
                if(!mode.equals("INSERT"))
				{	
          %>
					<script>
						document.forms[0].er_gcs_code1_weight0.value='<%=er_gcs_code1_score%>';
				  	    document.forms[0].er_gcs_code1_weight1.value='<%=er_gcs_code2_score%>';
				  	    document.forms[0].er_gcs_code1_weight2.value='<%=er_gcs_code3_score%>';
				  	    document.forms[0].er_gcs_code1_weight3.value='<%=er_gcs_code4_score%>';

						document.forms[0].vr_gcs_code1_weight0.value='<%=vr_gcs_code1_score%>';
				  	    document.forms[0].vr_gcs_code1_weight1.value='<%=vr_gcs_code2_score%>';
				  	    document.forms[0].vr_gcs_code1_weight2.value='<%=vr_gcs_code3_score%>';
				  	    document.forms[0].vr_gcs_code1_weight3.value='<%=vr_gcs_code4_score%>';
						document.forms[0].vr_gcs_code1_weight4.value='<%=vr_gcs_code5_score%>';

						document.forms[0].mr_gcs_code1_weight0.value='<%=mr_gcs_code1_score%>';
				  	    document.forms[0].mr_gcs_code1_weight1.value='<%=mr_gcs_code2_score%>';
				  	    document.forms[0].mr_gcs_code1_weight2.value='<%=mr_gcs_code3_score%>';
				  	    document.forms[0].mr_gcs_code1_weight3.value='<%=mr_gcs_code4_score%>';
						document.forms[0].mr_gcs_code1_weight4.value='<%=mr_gcs_code5_score%>';
						document.forms[0].mr_gcs_code1_weight5.value='<%=mr_gcs_code6_score%>';
					</script>
		   <%	} else {  %>
							<script>
						document.forms[0].er_gcs_code1_weight0.value='1';
				  	    document.forms[0].er_gcs_code1_weight1.value='2';
				  	    document.forms[0].er_gcs_code1_weight2.value='3';
				  	    document.forms[0].er_gcs_code1_weight3.value='4';

						document.forms[0].vr_gcs_code1_weight0.value='1';
				  	    document.forms[0].vr_gcs_code1_weight1.value='2';
				  	    document.forms[0].vr_gcs_code1_weight2.value='3';
				  	    document.forms[0].vr_gcs_code1_weight3.value='4';
						document.forms[0].vr_gcs_code1_weight4.value='5';

						document.forms[0].mr_gcs_code1_weight0.value='1';
				  	    document.forms[0].mr_gcs_code1_weight1.value='2';
				  	    document.forms[0].mr_gcs_code1_weight2.value='3';
				  	    document.forms[0].mr_gcs_code1_weight3.value='4';
						document.forms[0].mr_gcs_code1_weight4.value='5';
						document.forms[0].mr_gcs_code1_weight5.value='6';
					</script>
			<%		}	 %>
    </body>

<% 
sql.setLength(0);

} catch(Exception e){e.printStackTrace();}
   finally
    {
    	if(con != null)		
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

