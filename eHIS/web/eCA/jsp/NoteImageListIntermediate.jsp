<!DOCTYPE html>

<%@ page import ="java.sql.*,webbeans.eCommon.*,java.io.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../js/NoteImageList.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

	String imageurl_sql = "";
	String note_image_rep_folder = "";
	String image_name = "";

	//File filecreate;
	
	boolean flag			= true;
	//boolean fileexists		= true;
	//boolean filecreateRes	= false;
	
	image_name = request.getParameter("image_name")==null?"":request.getParameter("image_name");

	try
	{
			con = ConnectionManager.getConnection();
			note_image_rep_folder = "";

			imageurl_sql = " select NOTE_IMAGE_REP_FOLDER from ca_note_param";
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(imageurl_sql);

			if(rs.next())
				note_image_rep_folder = rs.getString("note_image_rep_folder");

			if(stmt!=null)
				stmt.close();
			if(rs!=null)
				rs.close();
			

			//String filename = note_image_rep_folder+"/"+image_name;

//			filecreate     = new File(filename);

//			if(filecreate.exists())
//			{
				%>
					<script>
//						var result = confirm(getMessage('IMAGE_ALRDY_EXISTS','CA'));

//						if(result==true) -->
						{
//							parent.f_query_add_mod.document.ImageListForm.flag.value=true;
//							parent.f_query_add_mod.document.ImageListForm.record.value='Y';
//							parent.f_query_add_mod.document.ImageListForm.submit();
						}
//						else
//							alert(getMessage('FAILED_TRANSACTION','CA'));
					</script>
				<%
//			}
////			else
	///			flag = filecreate.createNewFile();

			
			
			if(flag)
			{
				%>
				<script>
							parent.f_query_add_mod.document.forms[0].flag.value=false;
							parent.f_query_add_mod.document.forms[0].record.value='Y'
							parent.f_query_add_mod.document.forms[0].submit();
				</script>
				<%
			}

%>
	<script>
			parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
	</script>

	</html>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception @ NoteImageListIntermediate.jsp "+e.toString());//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>

