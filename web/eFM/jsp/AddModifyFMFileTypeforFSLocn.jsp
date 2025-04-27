<!DOCTYPE html>
<html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eOP/js/dchk.js'></script>
	<SCRIPT language='javascript' src='../js/FMFileTypeforFSLocn.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
    String req_start	= "", req_end = "";
    String checkedOnes	= "";	
	String file_type	= ""; 
	String chkyn		= "";
	String chkallyn   ="Y";
	String unchkcond    = "";
	String  enable_dis="";
	String from		= request.getParameter("from");
	String to		= request.getParameter("to");
	chkyn			= request.getParameter("chkunchk");
	unchkcond		= request.getParameter("unchkcond");
	String default_yn="N";
	String file_type_code="";
	String dflt_file_type="";
	String dfltchkattr="";
	if(chkyn == null) chkyn	= "";
	if(unchkcond == null) unchkcond	= "";
    int maxRecord	= 0;
    int start		= 0;
    int end			= 0;
    int i			= 1;    
    int recstart	= 0;

    if(from == null){ start = 0; } else { start = Integer.parseInt(from); }
    if(to == null){ end = 10; } else { end = Integer.parseInt(to); }

    req_start  = (request.getParameter("start")==null) ? "0" : request.getParameter("start");
    req_end    = (request.getParameter("end")==null)   ? "0" : request.getParameter("end");
    
   String effStatus = "";    
  
   effStatus		= request.getParameter("effStatus");
   if(effStatus == null) effStatus = "";

	Connection con			= null;
   java.sql.Statement stmt	= null;    
   PreparedStatement pstmt1 = null;
   ResultSet rs				= null;
   ResultSet rs1			= null;
  
   try
   {           
        con					= ConnectionManager.getConnection(request);       

        String facility_id	= (String)session.getValue("facility_id");
       	String fs_locn_code	= request.getParameter("fs_locn_code");
		String flagSelect	= request.getParameter("fromSelect");
		        
        if(flagSelect != null)
        {
            accessRightRecSet.clearAll();
          	StringBuffer sqlinsVals = new StringBuffer();
       
			//sqlinsVals.append("SELECT file_type_code,default_yn FROM fm_file_type_for_fsl WHERE facility_id = ? AND fs_locn_code = ? AND eff_status = 'E' ");        commented by S.Sathish for 21130 on Wednesday, May 12, 2010
			
			//Added by S.Sathish for 21130 on Wednesday, May 12, 2010 starts here
			sqlinsVals.append("SELECT file_type_code, default_yn, eff_status FROM fm_file_type_for_fsl WHERE facility_id = ? AND fs_locn_code = ? AND eff_status = 'E' AND EXISTS (SELECT (1) FROM mr_file_type WHERE facility_id = ? AND eff_status = 'E' AND file_type_code = fm_file_type_for_fsl.file_type_code)");
			//Ends here
			
	 	       pstmt1=con.prepareStatement(sqlinsVals.toString());
	        pstmt1.setString(1,facility_id);
	        pstmt1.setString(2,fs_locn_code); 
	        pstmt1.setString(3,facility_id); 

			rs1 = pstmt1.executeQuery();           
            if(rs1 !=null)
            {
                 while(rs1.next())
                 {
                    
					file_type_code=rs1.getString(1);
					accessRightRecSet.putObject(file_type_code);
                    default_yn=rs1.getString(2);
				 if(default_yn==null || default_yn.equals("null")) default_yn="N";
				if(default_yn.equals("Y"))
					 {
                      dflt_file_type=file_type_code;
					 }
				 }
            }
         }
		 
		 if(from != null && to != null)
         {
			 int j=0;
		   for(i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
           // for(i=0; i<=(Integer.parseInt(req_end)); i++)
			 {
				 if(request.getParameter("chk"+(i)) != null)
                 {
					 checkedOnes = request.getParameter("chk"+(i));
                     				 
					 if(!(accessRightRecSet.containsObject(checkedOnes)))
                          accessRightRecSet.putObject(checkedOnes);
                    
					 
					 j++;
                   }
				}
			    out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
			}
					
			String classValue	= "";
		    String chkAttribute	= "";			

			i = 1;
            
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

            StringBuffer sql = new StringBuffer();

      		sql.append("select A.file_type_code, A.short_desc, A.eff_status");
			sql.append(" from mr_file_type A, FM_FILE_TYPE_FOR_FSL B where B.facility_id='"+facility_id+"' and B.FS_LOCN_CODE='"+fs_locn_code+"' ");
			sql.append("and B.facility_id=A.facility_id and B.file_type_code = A.file_type_code and A.eff_status='E' union ");
			sql.append("select file_type_code,short_desc,eff_status");
			sql.append(" from mr_file_type where facility_id='"+facility_id+"' and eff_status='E' ");
			sql.append("and file_type_code not in(select file_type_code from FM_FILE_TYPE_FOR_FSL where facility_id ='"+facility_id+"' and  FS_LOCN_CODE ='"+fs_locn_code+"') order by file_type_code");

			try
			{				
				rs = stmt.executeQuery(sql.toString());
				rs.last();
				maxRecord = rs.getRow();
				rs.beforeFirst();
	        }catch(Exception e){out.println("resultset"+e);}
%>
<body OnMouseDown="CodeArrest();" class='CONTENT' onLoad='dochk()' onKeyDown = 'lockKey();'>
	<form name='facility_form_result' id='facility_form_result' action='../../eFM/jsp/AddModifyFMFileTypeforFSLocn.jsp' method='post'>
		<table  width='90%' border=0 align='center' >
			<tr>
				    <td width='63%' class='NONURGENT'>
					<input type='hidden' name='fs_locn_code' id='fs_locn_code' value='<%=fs_locn_code%>'>
					<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>
					<input type='hidden' name='max_record' id='max_record' value='maxRecord'>
					<input type='hidden' name='reccount' id='reccount' value='<%=maxRecord%>'>
					<input type='hidden' name='recstart' id='recstart' value='<%=recstart%>'>
					<input type='hidden' name='from' id='from' value='<%=start%>'>
					<input type='hidden' name='to' id='to' value='<%=end%>'>
					<input type='hidden' name='start' id='start' value='<%=start%>'>
					<input type='hidden' name='end' id='end' value='<%=end%>'>
					<input type='hidden' name='chkunchk' id='chkunchk' value='<%=chkyn%>'>
					<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >
					<input type='hidden' name='function_name' id='function_name' value='insert'>
				</td>
				<!--<td class='columnheader' nowrap><fmt:message key="Common.page.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.selectall.label" bundle="${common_labels}"/>>
				<input type='checkbox' name='pagechkAll' id='pagechkAll' align='left' onClick='selectAll(this,<%=start%>,<%=end%>)'></td>--> 
			<!-- <td class='columnheader' width='15%'  nowrap><fmt:message key="Common.selectall.label" bundle="${common_labels}"/><input type='checkbox'   name='chkAll' id='chkAll'   onClick='selectAll3("1")'></td>
			 <td width='25%'> </td> --> 
			</tr>
		</table>
		<input type=hidden name='whichPage' id='whichPage' value='prev'>
		<input type=hidden name='whichPage' id='whichPage' value='next'>
		<%
	    //This record count was taken from bean
	    //recordCount =   accessRightRecSet.getSize();
      //  if(start != 0)
       //  {
       //     for(int j=1; j<=start; i++,j++)
        //    {
         //       rs.next();
          //  }
     //   }

       int sCnt = 0;
		
       while(rs.next())
        {
		  ++sCnt;

           if(sCnt == 1)
           {
				%>
	            <table border='1' cellpadding='0' cellspacing='0' width='90%' align='center' >
		            <td width='10%' class='COLUMNHEADER' nowrap><fmt:message key="Common.filetype.label" bundle="${common_labels}"/></td>
			        <td width='40%' class='COLUMNHEADER' ><fmt:message key="Common.FileTypeDescription.label" bundle="${common_labels}"/></td>
                    <td width='20%' class='COLUMNHEADER'  ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>					
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox'   name='chkAll' id='chkAll'   onClick='selectAll3("1")'>   <fmt:message key="Common.selectall.label" bundle="${common_labels}"/></td>
				   <td width='20%' class='COLUMNHEADER'><fmt:message key="Common.Default.label" bundle="${common_labels}"/> </td>
						<%
			}

           
			
			file_type			= rs.getString("file_type_code"); 
            String short_desc	= rs.getString("short_desc");            
           			 
			 if(file_type.equals(dflt_file_type))
			{
              	   dfltchkattr="CHECKED";
			}else{
            dfltchkattr="";
			}
				 
				 int recordIndex		= accessRightRecSet.indexOfObject(file_type);    

			if(accessRightRecSet.containsObject(file_type)) 
			{
			chkAttribute = "CHECKED";	
					 
			}
			else{
				chkAttribute = ""; 
			     }
           if(chkAttribute.equals(""))
			{
              chkallyn="N";
			}
			if(recordIndex != -1)
            {
				if(chkAttribute.equals("CHECKED"))    
            		accessRightRecSet.removeObject(recordIndex);       
                   		
			}
			if(chkAttribute.equals("CHECKED"))    
    		{
             enable_dis="";
			}else{
              enable_dis="disabled";
			}
			if(i%2 == 0)  classValue = "QRYEVEN";
            else classValue = "QRYODD";
			%>
            <tr>
                <td width='1%' class='<%=classValue%>'><%=file_type%></td>
                <td class='<%=classValue%>'><%=short_desc%></td>
			    <td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>'  value='<%=file_type%>' onclick='chkunchkftypes(this,"<%=i%>");'> </td>
              <td align='center' class='<%=classValue%>'><input type='checkbox'   <%=enable_dis%> <%=dfltchkattr%>  name='chk_deflt<%=i%>'  value='<%=file_type%>'  onclick='chkdeflttype(this,"<%=i%>");'> </td> 
				</tr>
			<%
	        i++;
		}       

		if(sCnt>0) 
		{
			%> 
				</table>
					<%
		}
	    else
		{
			%> 
			<script>
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
                parent.frames[0].document.forms[0].submit();
            </script>
			<%
		}
		if(pstmt1 != null) pstmt1.close(); 
		if(rs != null) rs.close();             
		if(rs1 != null) rs1.close();   
		if(stmt != null) stmt.close();
	}
    catch(Exception e)
    {
		out.print(e.toString());
    }
    finally
    {		
        ConnectionManager.returnConnection(con,request);
        session.setAttribute("FMFileTypeforFSLocn", accessRightRecSet);
     }
%>
	<input type='hidden' name='remftypes' id='remftypes' value='R'>
	<input type='hidden' name='unchkcond' id='unchkcond' value='<%=unchkcond%>'>
      <input type='hidden' name='count' id='count' value='<%=i%>'>
 <input type='hidden' name='dflt_index' id='dflt_index' value=''>
<input type='hidden' name='status' id='status' value=''>
<script>	
			var chkallyn ="<%=chkallyn%>";
			if(chkallyn=="Y")
			{
			document.forms[0].chkAll.checked=true;
					
			}else{
       	document.forms[0].chkAll.checked=false;
			}
			</script>

</form>
</body>
</html>

