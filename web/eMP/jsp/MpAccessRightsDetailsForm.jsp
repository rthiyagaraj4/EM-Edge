<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8" import ="java.sql.Connection,java.sql.*,webbeans.eCommon.*,java.util.HashMap"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="accessRightfinaRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script language='javascript' src='../js/MpAccessRights.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<title>
</title>
</head>
<%
	
	StringBuffer sblQry = new StringBuffer();
	Connection con=null;	
	Statement stmt=null;
	ResultSet rset=null;
	PreparedStatement pstmt = null;
	

	String classValue="";
	try{
		con = ConnectionManager.getConnection(request);
		String searchresp        = "";
		String searchcriteria    = "";
		String whereclause       = "";	
		String RespId            = "";
		String RespName          = "";
		String ViewPatPhotoYN    = "";
		String ViewPatFinDtlsYN  = "";
		String ViewPatPhotoYNChk  = "";
		String ViewPatFinDtlsYNChk  = "";
		/*Added by lakshmanan for security issue ID 174122693 on 31-08-2023 start */
		java.util.HashMap psthashmap		=	new java.util.HashMap() ;
		int psthmcount=0;
		/*Added by lakshmanan for security issue ID 174122693 on 31-08-2023 end */
		int maxRecord = 0;
		int counter= 0;

		searchresp=request.getParameter("searchresp")==null?"":request.getParameter("searchresp");
		String scode = searchresp.toUpperCase();
		searchcriteria=request.getParameter("searchcriteria");
		if(searchcriteria.equals("S"))
			psthashmap.put(++psthmcount,scode+"%");
			//whereclause = "('"+scode+"%')";
		if(searchcriteria.equals("E"))
			psthashmap.put(++psthmcount,"%"+scode);
			//whereclause = "('%"+scode+"')" ;
		if(searchcriteria.equals("C"))
			psthashmap.put(++psthmcount,"%"+scode+"%");
			//whereclause = "('%"+scode+"%')" ;
		try{

            sblQry.append("SELECT a.resp_id resp_id, b.resp_name resp_name, a.view_pat_photo_yn view_pat_photo_yn, a.view_pat_fin_dtls_yn view_pat_fin_dtls_yn ");
            sblQry.append("FROM MP_ACCESS_RIGHTS a, SM_RESP b ");
            sblQry.append("WHERE a.resp_id = b.resp_id and upper(b.resp_name) like upper(?)  ");
            sblQry.append("UNION " );
            sblQry.append("SELECT resp_id, resp_name, 'N' view_pat_photo_yn, 'N' view_pat_fin_dtls_yn FROM sm_resp ");
            sblQry.append("WHERE resp_id NOT IN(SELECT resp_id FROM mp_access_rights) and upper(resp_name) like upper(?) ");
            sblQry.append("ORDER BY resp_name");
            //stmt = con.createStatement();
            pstmt = con.prepareStatement(sblQry.toString());
            pstmt.setString(1,(String) psthashmap.get(1));
            pstmt.setString(2,(String) psthashmap.get(1));
            rset = pstmt.executeQuery();
            psthashmap.clear();
            maxRecord = rset.getRow();
   
          }
		catch(Exception e){
            //out.println("Error in select Query "+e);
			e.printStackTrace();
        }
		%>
				
<body onKeyDown='lockKey()'>
<form name="MpAccessRightsDetailsForm" id="MpAccessRightsDetailsForm" action="../../eMP/jsp/MpAccessRightsDetailsForm.jsp" target="messageFrame" method="post">
<table cellpadding=0 cellspacing=0 border=1 width=100%>
<tr>
<td class='columnheader'><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></td>
<!--Below Modified for Regression-PAS-OP Transaction- Register Visit-->
<td class='columnheader'><fmt:message key="eMP.ViewPatientPhoto.label" bundle="${mp_labels}"/></td>
<td class='columnheader'><fmt:message key="eMP.ViewPatFinlDtls.label" bundle="${mp_labels}"/></td>
</tr>

   		  <% 
	  int i = 1;
	  while(rset.next() )
		{
		  counter++;
            maxRecord = maxRecord + 1;
            RespId = rset.getString("resp_id");
            RespName = rset.getString("resp_name");
            ViewPatPhotoYN = rset.getString("view_pat_photo_yn");
            ViewPatFinDtlsYN = rset.getString("view_pat_fin_dtls_yn");

            if(RespId == null){ RespId = ""; }
            if(RespName == null){ RespName = ""; }
            if(ViewPatPhotoYN == null){ ViewPatPhotoYN = ""; }
            if(ViewPatFinDtlsYN == null){ ViewPatFinDtlsYN = ""; }
            if(counter%2==0)
			{
             classValue="QRYEVEN";
            }
			else
			{
		      classValue = "QRYODD";
            }
             if (ViewPatPhotoYN.equals("Y"))
			  {
                 ViewPatPhotoYNChk = "checked";
				
			  }
			  else
			  {
                 ViewPatPhotoYNChk = "";
			  }

			  if (ViewPatFinDtlsYN.equals("Y"))
			  {
                 ViewPatFinDtlsYNChk = "checked";
				
			  }
			  else
			  {
                ViewPatFinDtlsYNChk = "";
			  }
	%>
          
            <tr>
			    <input type= 'hidden' name='RespId<%=counter%>' id='RespId<%=counter%>' value='<%=RespId%>'>
                <td class = '<%= classValue %>'><%=RespName%></td>
                <td class = '<%= classValue %>' align=center>
                <input type='checkbox' name='viewpatphotoyn<%=counter%>' id='viewpatphotoyn<%=counter%>' onclick='chkValue(this);' value='<%=ViewPatPhotoYN %>' <%=ViewPatPhotoYNChk%>  > 
                </td>
                <td class = '<%= classValue %>' align=center>            
				<input type='checkbox' name='viewpatfindtlsyn<%=counter%>' id='viewpatfindtlsyn<%=counter%>' onclick='chkValue(this);' value='<%=ViewPatFinDtlsYN %>'  <%=ViewPatFinDtlsYNChk%>  > 
				</td>

            </tr>
			<%
				i++;
			}
			if(rset!=null) rset.close();
		   if(stmt!=null) stmt.close();
		
		if(maxRecord==0) 
		 {
		%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));
		document.location.href="../../eCommon/html/blank.html";
		</script>


		<%}
	%>		
<input type='hidden' name='maxRecords' id='maxRecords' value='<%=maxRecord%>'>

</table>
</form>
</body>

    

		<%
   	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	} finally {
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>

</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

