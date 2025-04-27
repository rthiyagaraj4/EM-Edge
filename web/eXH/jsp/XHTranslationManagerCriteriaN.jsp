<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eXH.*;" %> 
<%	
	 request.setCharacterEncoding("UTF-8"); 
     Connection conn = null;
	 PreparedStatement pstmt=null;
	 ResultSet rset=null;				  
	 int countRec =0;
	 String fun_id=XHDBAdapter.checkNull(request.getParameter("fun_id")); 
	 String application_id=XHDBAdapter.checkNull(request.getParameter("application_id")); 
	 String master_table_id=XHDBAdapter.checkNull(request.getParameter("master_table_id")); 
	 String module_id=XHDBAdapter.checkNull(request.getParameter("module_id"));   
	 //System.out.println("module_id 15 :"+module_id);								  
	 try																			    
	 {
		StringBuffer sql=new  StringBuffer();					  
		conn = ConnectionManager.getConnection(request); 		
	    String extStyle = "display:none";
		Statement stmt=null;
		Statement stmt1=null;
		ResultSet rs1=null; 

		String sql1 = "select 1 from SM_MENU_DTL where submenu_id='XH_JG_DEVELOPMENT_CONFIG' ";	
		String sql2 = "SELECT 1 FROM SM_MENU_RSTRN_RESP WHERE submenu_id='XH_JG_DEVELOPMENT_CONFIG' ";

		try{
			stmt = conn.createStatement();		
			rset  = stmt.executeQuery(sql1);
			if(rset.next()) {
	//					System.out.println("rs.next 1: ");
				stmt1 = conn.createStatement();		
				rs1  = stmt.executeQuery(sql2);
				if(rs1.next()) {
//				  System.out.println("rs.next :2 ");
						}
						else{
							  extStyle = "display:block";
			//				  System.out.println("extStyle : "+extStyle);
						}
					}
				}
				catch(Exception e){
					e.printStackTrace(System.err);
				}
				finally{		
					if(rset != null) rset.close();
					if(stmt != null) stmt.close();
					if(rs1 != null) rs1.close();
					if(stmt1 != null) stmt1.close();
//					if(conn != null) conn.close();
				}
		%>																	   		     				 
	<html>																			     
	<head>													   							    
	<%														    
													 
    String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>			    
	<script language='javascript' src='../js/XHTranslationManagerN.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		<script>	   
		function doUpload()
		{																	  
			var filePath = document.getElementById("upload_text").value;
			
			if(filePath != '')
			{												 
				var fileExtn = filePath.substring(filePath.length-4, filePath.length);
				if(fileExtn == '.xls')
				{	
						  document.forms[0].method='Get';
					  //   document.forms[0].method='Get';
						 document.forms[0].target='messageFrame';
						 document.forms[0].action= '../../servlet/eXH.XHTranslationSettingExcelUploadServlet';
						 document.forms[0].submit();																	  


				}
			}
		}																		   
		 function showUploadExcelSheet()
		 {

			document.forms[0].enctype="multipart/form-data";
		   document.getElementById("upload_id").style.display="block";
		   
																  
		 }
		function showExportExcelSheet()
		 {
			  document.forms[0].method='Post';
			document.forms[0].target='';
		  document.forms[0].action='../../servlet/eXH.XHTranslationSettingServlet';
			 document.forms[0].submit();

																 
		 }																				  
		</script>
	</head>																				 

	 <body onLoad='getMaster1(document.forms[0].application);' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'  >
	 <form name="TranslationCriteria" id="TranslationCriteria"  method='Post'  >														 
		<input type=hidden name="master_table_id" id="master_table_id" id="master_table_id" value="<%=master_table_id%>" >
		<input type=hidden name="module" id="module" id="module" value="<%=module_id%>" >       
		<input type=hidden name="fun_id" id="fun_id" id="fun_id" value="<%=fun_id%>">   							   

	<table cellspacing=0 cellpadding=2  width="100%" border="0">	
  
<!--	<tr id='External' style= "display:none">  -->
	<tr id='External' style= <%=extStyle%>> 	 
		<td class=label width='25%'><fmt:message key="Common.external.label" bundle="${common_labels}"/>
		</td>
		<td class="fields" width='25%'>
		<input type=checkbox name=external_yn  onClick='validatecheckbox(this);' >
		</td>
	</tr> 

	<tr>
	  <td class=label width='25%'><fmt:message key="Common.Application.label" bundle="${common_labels}"/>&nbsp;</td>
	  <td class="fields" width='25%'>
		<select name=application onChange='getMaster1(this);' style="width: 200px">
		  <option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
		  <%
		  sql.setLength(0);														 
		  sql.append("  SELECT APPLICATION_ID,APPLICATION_NAME FROM XH_APPLICATION where IN_USE_YN='Y' ORDER BY APPLICATION_ID");
		  pstmt = conn.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		  rset = pstmt.executeQuery();
		  if(rset != null)
		   {
			  rset.last();										     		    
			  countRec = rset.getRow();
			  rset.beforeFirst();
		   }											 
		   if (countRec == 1)						     
			  {
				while(rset!=null && rset.next())
				  {%>
					<option value='<%=rset.getString("APPLICATION_ID")%>' selected><%=rset.getString("APPLICATION_NAME")%> </option>
				  <%}
			  }
		   else if (countRec >= 1)
		   {																		  
			  while(rset!=null && rset.next())
			  {																			 
				  
					  if(application_id.equals(rset.getString("APPLICATION_ID")))
					 {
				  %>
					<option value='<%=rset.getString("APPLICATION_ID")%>'  selected><%=rset.getString("APPLICATION_NAME")%> </option>
					<%}
				  else
				  {%>
				  <option value='<%=rset.getString("APPLICATION_ID")%>' ><%=rset.getString("APPLICATION_NAME")%></option>
			  <%
				  }
				 }										 
			  }%>
		  </select>&nbsp;<img name='mandatory1' src='../../eCommon/images/mandatory.gif'>
	  </td>
	  <td class=label  width='25%'><fmt:message key="Common.display.label" bundle="${common_labels}"/>&nbsp;</td>
	   <td class="fields" width='25%'>
		   <select name='display' id='display' style="width: 200px" >  
				<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value='T'><fmt:message key="eSM.Translated.label" bundle="${sm_labels}"/></option>
				<option value='N'><fmt:message key="eSM.NonTranslated.label" bundle="${sm_labels}"/></option>
		  </select>&nbsp;<img name='mandatory1' src='../../eCommon/images/mandatory.gif'>
	  </td>
	  </tr>		 													    
	  <tr>
	  <td class='label' width='25%'><fmt:message key="Common.Module.label" bundle="${common_labels}"/>&nbsp;</td>
	  <td class="fields" width='25%'>
		<select name=module_id  onChange='getMaster(this);'  style="width: 200px">	    
			<option value=''>----------<fmt:message key="Common.defaultSelect.label"		        bundle="${common_labels}"/>---------</option>
		</select>&nbsp;<img name='mandatory1' src='../../eCommon/images/mandatory.gif'>
	  </td>
	  <td class='label' width='25%'><fmt:message key="eSM.MasterName.label" bundle="${sm_labels}"/>&nbsp;</td>
	  <td class="fields" width='25%'>
		<select name='master_name' id='master_name' onChange='changeObj(this,module_id)' style="width:200">    
			<option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>  
		</select>&nbsp;<img name='mandatory1' src='../../eCommon/images/mandatory.gif'>
	  </td>
	  </tr>										 	    					    
												   
	  <tr>
	  <td class=label width='25%'><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/>&nbsp;</td>
	  <td class="fields"  id='obj1' nowrap>
		 <select name="start_ends_contains" id="start_ends_contains"  style="width: 200px">
				<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
				<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
				<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
			</select>&nbsp;
	   <INPUT TYPE="text" name="searchtext" id="searchtext" size=10></td>
	   <td class='label' width='25%'><fmt:message key="eXH.CommunicationMode.Label" bundle="${xh_labels}"/></td>
	  <td class="fields"  id='obj2' width='25%'>
		<select name='outbound_yn1' id='outbound_yn1'  style="width:200" disabled>
		  <option value='X'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		  <option value='Y'><fmt:message key="eXH.Outbound.Label" bundle="${xh_labels}"/></option>
		  <option value='N'><fmt:message key="eXH.Inbound.Label" bundle="${xh_labels}"/></option>  
		</select>
		<INPUT TYPE="hidden" name='outbound_yn' id='outbound_yn' value='X'>
	  </td> 
	  </tr>
	  <tr> 																			 
		  <td class=label width='25%' id='obj3'></td>
		  <td class="fields"   width='25%' id='obj4'></td>   
		  <td align='right' colspan=2><INPUT TYPE="button" name="exportdata" id="exportdata" value='<fmt:message key="eXH.exportdata.Label" bundle="${xh_labels}"/>'  class=button onClick='showExportExcelSheet()' disabled ><INPUT TYPE="button" name="uploaddata" id="uploaddata" value='<fmt:message key="Common.UploadFile.label" bundle="${common_labels}"/>'  class=button onClick='showUploadExcelSheet()' disabled ><INPUT TYPE="button" name="synchronize" id="synchronize" value='<fmt:message key="eXH.Synchronize.Label" bundle="${xh_labels}"/>'  class=button onClick='showExportData()' ><INPUT TYPE="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  class=button onClick='showResultPage()'>&nbsp;<INPUT TYPE="button"  class=button name="clear" id="clear" value='Clear' onClick='clearData()' ></td>			   
	  </tr>
	   <input type='hidden' name='language_direction' id='language_direction' value="">	 	 			 	  		 	  
																			  	 
	<tr><td colspan=4 ></td></tr>						   
	 <%
		}catch(Exception e) { System.out.println("XHTranslationManagerCriteriaN.jsp Error1 : "+e.toString());}
		finally
		{											 
			try{
			if (rset != null) rset.close();															  
			if (pstmt != null) pstmt.close();
			}catch(Exception e) {
				System.out.println("XHTranslationManagerCriteriaN.jsp Error-2"+e.toString());
			 }
			if(conn != null) ConnectionManager.returnConnection(conn,request); 
		}
	%>		
	<select name="hidden_trans_table_id" id="hidden_trans_table_id" style='display:none'> 									   
	</select>
	<table id='upload_id' style="display:none;">
	<td class=label><fmt:message key="eXH.ChooseXLSFile.Label" bundle="${xh_labels}"/></td>
  <td class="fields">
  <INPUT TYPE="file" name="upload_text" id="upload_text" id="upload_text" >&nbsp;&nbsp;<input type='button' id='btnUpload' value='  Go  ' onclick='doUpload();'></td>
  </td>
	 </table>
   <input type ="hidden" name='sqlQuery' id='sqlQuery' >	
 </form>
 </body>
 </html>
											 		    

