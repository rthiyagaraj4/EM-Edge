<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<% 
	request.setCharacterEncoding("UTF-8");
    Connection con				= null;
	Statement	stmt	        = null;
	ResultSet	rs				= null;
	String str					= "";
	String group_desc			= "";
	String group_code			= "";
	String main_group			= "";
	String report_gr_id			= "";
	String sStyle				= "IeStyle.css";
	String calledFromFinction			= "";
 try
  {
	con	= ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	
	///// if called from PD/PL Report Group function. 
	///// populate_main_group.js function of addModifyReportGroupSetup.jsp
	sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	calledFromFinction = request.getParameter("calledFromFinction");
	if(calledFromFinction == null || calledFromFinction.equals("null")) calledFromFinction = "";
	///// end /////
	if(calledFromFinction.equals("PDPLReportGroup"))
	{
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");
		String group_id="";
		String grpDesc ="";
		String ReportID ="";
		String MainGroup ="";
		
		ReportID = request.getParameter("ReportID");
		if(ReportID == null || ReportID.equals("null"))
			ReportID = "";
		MainGroup = request.getParameter("MainGroup");
		if(MainGroup == null || MainGroup.equals("null"))
			MainGroup = "";



		String sql ="select GROUP_CODE, GROUP_DESC from MR_REPORT_GROUPING where REPORT_ID = '"+ReportID+"' and GROUP_CATEGORY = 'M' order by GROUP_DESC ";

        rs = stmt.executeQuery(sql);
		if(rs!=null)
		{  
			while(rs.next())
			{  
				grpDesc = rs.getString("GROUP_DESC")==null?"":rs.getString("GROUP_DESC");
				group_id = rs.getString("GROUP_CODE")==null?"":rs.getString("GROUP_CODE");
				if(group_id.equals(MainGroup))
				{
					%>
					<script>
					   var opt = parent.frames[1].document.createElement("OPTION");
					   opt.text="<%=grpDesc%>";
					   opt.value="<%=group_id%>";
					   parent.frames[1].document.getElementById("Main_Group").add(opt);
					   opt.selected = true;
					</script>
					<%
				}
				else
				{
					%>
					<script>
					   var opt = parent.frames[1].document.createElement("OPTION");
					   opt.text="<%=grpDesc%>";
					   opt.value="<%=group_id%>";
					   parent.frames[1].document.getElementById("Main_Group").add(opt);
					</script>
					<%
				}
			}
		}
		if(rs!=null) rs.close();
	}
	///////////////////////////Added for Level3//////////////////////////
	else if(calledFromFinction.equals("PDPLReportGroup_level3"))
	{

		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");
		String group_id="";
		String grpDesc ="";
		String ReportID ="";
		String MainGroup ="";
		String sub_group_code_l2 ="";
		
		ReportID = request.getParameter("ReportID");
		if(ReportID == null || ReportID.equals("null"))
			ReportID = "";
		MainGroup = request.getParameter("MainGroup");
		if(MainGroup == null || MainGroup.equals("null"))
			MainGroup = "";
		sub_group_code_l2 = request.getParameter("sub_group_code_l2");
		if(sub_group_code_l2 == null || sub_group_code_l2.equals("null"))
			sub_group_code_l2 = "";
		



		String sql ="select GROUP_CODE, GROUP_DESC from MR_REPORT_GROUPING where REPORT_ID = '"+ReportID+"' and GROUP_CATEGORY = 'S' and SUBGROUP_CODE='"+sub_group_code_l2+"'order by GROUP_DESC ";

        rs = stmt.executeQuery(sql);
		if(rs!=null)
		{  
			while(rs.next())
			{  
				grpDesc = rs.getString("GROUP_DESC")==null?"":rs.getString("GROUP_DESC");
				group_id = rs.getString("GROUP_CODE")==null?"":rs.getString("GROUP_CODE");
				if(group_id.equals(MainGroup))
				{
					%>
					<script>
					   var opt = parent.frames[1].document.createElement("OPTION");
					   opt.text="<%=grpDesc%>";
					   opt.value="<%=group_id%>";
					   parent.frames[1].document.getElementById("LEVEL3_CODE").add(opt);
					   opt.selected = true;
					</script>
					<%
				}
				else
				{
					%>
					<script>
					   var opt = parent.frames[1].document.createElement("OPTION");
					   opt.text="<%=grpDesc%>";
					   opt.value="<%=group_id%>";
					   parent.frames[1].document.getElementById("LEVEL3_CODE").add(opt);
					</script>
					<%
				}
			}
		}
		if(rs!=null) rs.close();
	}
	//////////////////////////////////////////////////////////////////
	else
	  {
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");
    main_group					= request.getParameter("main_group");
    report_gr_id				= request.getParameter("report_gr_id");
	
	if(main_group==null || main_group.equals("null") || main_group.equals(""))
	{
	
       str="select group_code, group_desc from mr_report_grouping where report_id ='"+report_gr_id+"' and group_category = 'M' order by group_desc ";
	   rs	= stmt.executeQuery(str);
	  
	  while(rs.next())
	  {
		  group_code	= rs.getString("group_code");
		  group_desc	= rs.getString("group_desc");
		  if(group_code==null || group_code.equals("null"))
		  group_code="";
		  if(group_desc==null || group_desc.equals("null"))
		  group_desc="";
          group_code=group_code.trim();
   %>
  <script>
	   var f=parent.frames[1].frames[0];         
	   opt=f.document.createElement("OPTION");
	   opt.text='<%=group_desc%>';
	   opt.value='<%=group_code%>';
	   f.document.getElementById("Main_group").add(opt);
 </script>
	<%  }
     if(rs!=null) rs.close();
	}

  else{
	    str	="select group_code, group_desc from mr_report_grouping where report_id ='"+report_gr_id+"' and subgroup_code = '"+main_group+"'and group_category = 'S' order by group_desc " ;
        rs	= stmt.executeQuery(str);
		
		   while(rs.next())
		   {
				group_code	= rs.getString("group_code");
				group_desc	= rs.getString("group_desc");
				if(group_code==null || group_code.equals("null"))
				  group_code="";
				if(group_desc==null || group_desc.equals("null"))
				  group_desc="";

				group_code=group_code.trim();

%>       
  <script>
	   var f=parent.frames[1].frames[0];         
	   opt=f.document.createElement("OPTION");
	   opt.text='<%=group_desc%>';
	   opt.value='<%=group_code%>';
	   f.document.getElementById("sub_group").add(opt);
			  
 </script>
<%
   }
    if(rs!=null) rs.close();//end of while
  }//end of else.
  }//end of first else
%>
 </form>
<%
   if(stmt!=null) stmt.close();
   if(rs!=null) rs.close();
   }
   catch(Exception e)
   {
	   //out.println("Exception in File SSPopulateValues"+e.toString());
	   e.printStackTrace();
   }
   finally
 {
    ConnectionManager.returnConnection(con,request);
 }
%>
</body>
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

