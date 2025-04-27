<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*" %>

<head>
<%
          request.setCharacterEncoding("UTF-8");
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/rowcolor.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function callframe4(obj)
{

parent.document.frames[3].document.location.href='../../eSM/jsp/RecordTransEntry.jsp?tableid='+parent.document.frames[0].document.forms[0].tableid.value+"&code="+obj+"&module_id="+parent.document.frames[0].document.forms[0].module_id.value;
}
function getComments(obj)
	{
		
		var code_name = document.forms[0].code_name.value;
		
		var code1 = obj;
		document.forms[0].code.value = code1;
		var url		= '../../eSM/jsp/RecordTransEntry.jsp?tableid='+parent.document.frames[0].document.forms[0].tableid.value+"&code="+code1+"&module_id="+parent.document.frames[0].document.forms[0].module_id.value+"&code_name="+code_name;
		var dialogTop	= "165";
		var dialogHeight= "24" ; 
		var dialogWidth	= "40" ;	
		var dialogLeft	= "80" ;
		
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status=no;valign=center; dialogLeft: "+dialogLeft ;
		var returnval = window.showModalDialog( url, 'Trans Entry', features ) ;	
		if(returnval == null) returnval="";
		
		
	}
</script>
<%
	Connection con = null;
	java.sql.Statement stmt=null;
	ResultSet rs=null ;
	ResultSet rs4=null ;
	ResultSet rs1=null ;
	try{
	con = ConnectionManager.getConnection(request);
	ArrayList pklist = new ArrayList();
    String tableid = request.getParameter("tableid");
    String criteria_String = request.getParameter("criteria_String");
	if (criteria_String==null) criteria_String ="";
	String classValue="";
	//String othclassValue="";
	String all_column_id = "";
	String oth_all_column_id = "";
	String table_where_cond = "";
	String table_where_cond1 = "";
	String pk_key = "";
	String order_by = "";
	String module_id = request.getParameter("module_id");
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
	int total_column=0;
	String column_value="";
	String cri_where="";
	int maxRecord=0;
	int k = 0;
	int cw = 0;
	int row_name = 1;
	String sql="";
    int start = 0 ;
    int end = 0 ;
    int l=1;
	if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 15 ;
    else
        end = Integer.parseInt( to ) ;
	stmt=con.createStatement();
		%>
 	<body  onLoad="FocusFirstElement();"  onKeyDown = 'lockKey()'; OnMouseDown="CodeArrest()";> 
		<form name='RecordTransForm2' id='RecordTransForm2'>
<table align = 'center'  width='80%'>
<tr>
<td class = 'white' >
<%
        String where1="";
		String sqlstr1 = "select table_where_cond from sm_record_trans_hdr where table_id= '"+tableid+"'";
			rs4 = stmt.executeQuery(sqlstr1);
            while (rs4!=null&&rs4.next())
			{	
            where1 = rs4.getString(1);
			if(where1==null) where1="1=1";
			}
			sqlstr1 = "select COLUMN_ID from sm_record_trans_dtl where table_id= '"+tableid+"' and  COLUMN_SRL_NO = 2";
			if(rs4!=null)rs4.close();
			rs4 = stmt.executeQuery(sqlstr1);
            while (rs4!=null&&rs4.next())
			{	
			   cri_where = " and upper(" +rs4.getString("column_id")+ " ) like upper('" + criteria_String +"%')";
			}
			String strsql="select count(1) total from  "+tableid +" where " +where1 +cri_where;
		
			 rs1 = stmt.executeQuery(strsql);
			rs1.next();
			maxRecord = rs1.getInt("total");
		if(maxRecord == 0)		out.println("<script>parent.document.frames[1].document.location.href='../../eCommon/html/blank.html';parent.document.frames[2].document.location.href='../../eCommon/html/blank.html';alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");

		if ( !(start <= 1) )
    out.println("<A HREF='../../eSM/jsp/RecordTransResult.jsp?tableid="+tableid+"&module_id="+module_id+"&from="+(start-15)+"&to="+(end-15)+"&criteria_String="+criteria_String+"&whereclause="+sql+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+15) > maxRecord ) )
    out.println("<A HREF='../../eSM/jsp/RecordTransResult.jsp?tableid="+tableid+"&module_id="+module_id+"&from="+(start+15)+"&to="+(end+15)+"&criteria_String="+criteria_String+"&whereclause="+sql+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
    %>
</td>
</tr>
</table>
	<table align = 'center' width='80%' cellspacing=0 cellpadding=0 border="1" id='tb1'>
	<tr>
	<%
		    
		try{
								try{
				     	sql="select count(1) count from sm_record_trans_dtl where table_id= '"+tableid+"'";
						rs=stmt.executeQuery(sql) ;
				        if(rs!=null)
					    {
					      while(rs.next())
					  	   {
							 total_column = rs.getInt("count");
 
						   }
    				     }
    				   }
    				    	catch(Exception e){out.println(e.toString());}

						sql="select a.table_where_cond,b.column_id,b.column_display,b.column_pk_yn,a.table_order_by from sm_record_trans_hdr a , sm_record_trans_dtl b  where a.table_id = b.table_id and  a.module_id = b.module_id and b.table_id= '"+tableid+"' order by b.column_srl_no";

						String colid = "";
						if(rs!=null)rs.close();
						rs=stmt.executeQuery(sql) ;
				        if(rs!=null)
					    {
					      while(rs.next())
					  	   {
							  colid = rs.getString("column_id");
							 all_column_id      = all_column_id +","+colid;
							 oth_all_column_id  = oth_all_column_id +","+rs.getString("column_id");
							 table_where_cond = rs.getString("table_where_cond");
							 table_where_cond1 = rs.getString("table_where_cond");
							   if ( table_where_cond == null ) table_where_cond ="where 1=1";
                               else
								  table_where_cond = " Where "+ table_where_cond;

							   if ( table_where_cond1 == null ) table_where_cond1 ="1=1";

							   if (rs.getString("column_display").equals("N"))
							   {
							   all_column_id = all_column_id +","+"null  "+rs.getString("column_id")+"_oth_lang";
							   oth_all_column_id = oth_all_column_id +", "+rs.getString("column_id")+"_oth_lang";
							   total_column++;
							   }
							 order_by       = rs.getString("table_order_by");
							 
							 if (rs.getString("column_pk_yn").equalsIgnoreCase("Y"))
							   {
								pklist.add(colid);
							    pk_key = rs.getString("column_id");
							   }

						   }
    				     }
						
    				   }
    				    	catch(Exception e){out.println(e.toString());}
//shifted here from top 

 try{
					
						cw = (int)(100/total_column);
				     	sql="select column_display,column_width,column_prompt from sm_record_trans_dtl where table_id= '"+tableid+"'";
				      if(rs!=null)rs.close();
						rs=stmt.executeQuery(sql) ;
				        if(rs!=null)
					    {
					      while(rs.next())
					  	   {

							 out.println("<td width='"+cw+"%' class='CAHIGHERLEVELCOLOR' >");
							 out.println(rs.getString("column_prompt"));
							 if (rs.getString("column_display").equals("N"))
							   {	
							      out.println("</td> <td width='"+cw+"%' align = 'right' class='CAHIGHERLEVELCOLOR' > "+rs.getString("column_prompt")+" Loc Lang");   
							   }
							 out.println("</td>");
						   }
    				     }
    				   }
    				    	catch(Exception e){out.println(e.toString());}
				







				     try{
				     	
						sql = "select "+oth_all_column_id.substring(1)+" from "+tableid+"_oth_lang_vw " + table_where_cond+cri_where;

						sql= sql+" union select "+all_column_id.substring(1)+" from "+tableid	+" where "+table_where_cond1+cri_where+"and "+ pk_key + " not in ( select "+ pk_key +" from "+ tableid+"_oth_lang_vw "+table_where_cond+cri_where	+ ") order by " + order_by;
                       if(rs!=null)rs.close();
						rs=stmt.executeQuery(sql) ;
						ResultSetMetaData rsmd = rs.getMetaData();
						if(rs!=null)
					    {
							if ( start != 1 )
						     for( int j=1; j<start; l++,j++ )
						      rs.next() ;
							  while ( rs.next() && l<=end  )    
					  			{
									out.println("</tr><tr style='backgroundColor:'>");
	                           if(k % 2 == 0)
									{	
							         classValue 		  = "QRYODD" ;
									}

		                       else
									{	
  							        classValue 		  = "QRYEVEN" ;
									}
									
								String col_value = "";
								String code = "";
							for (int i=1;i<=total_column;i++)
							 {
							
							  column_value = rs.getString(rsmd.getColumnName(i));
								
							for(int j=0;j<pklist.size();j++)
									 {
										
										if(rsmd.getColumnName(i).equalsIgnoreCase(pklist.get(j).toString()))
										col_value = col_value + column_value;
										
									 }
							 }
							
							 for (int i=1;i<=total_column;i++)
							 {
                                column_value = rs.getString(i);
								
							
								
								if (column_value==null) column_value ="&nbsp;";
								if (i==1) 
								 {
									
									code = column_value;
									out.println("<td width='"+cw+"%' class='"+classValue+"'><a name="+row_name+" onClick='changeRowColor(this,"+total_column+");' href=\"javascript:getComments('"+col_value+"') \">");			out.println(column_value +"</a></td>");
								 }
								else
								 {
                                 String direction ="";
									
								 if (rsmd.getColumnName(i).indexOf("OTH_LANG") >0)
									 {
									
									 direction  ="right";
			                           if(k % 2 == 0)
								         classValue 		  = "QRYODDOTHLANG" ;
				                       else
  									        classValue 		  = "QRYEVENOTHLANG" ;
									}
								 else
									 { 
										
									 direction="left";
										
									 }
									
								 out.println("<td width='"+cw+"%' class='"+classValue+"' align = '"+direction+"'>"+column_value+"</td>");
								 }
							   }
							out.println("</tr>");
							k++;
							row_name++;
							l++;
						   }
    				     }
    				   }
    				    	catch(Exception e){out.println(e.toString());}
						%>                      

						</table>
<%
sql ="SELECT COLUMN_ID FROM SM_RECORD_TRANS_DTL WHERE TABLE_ID = '"+tableid+"' and column_pk_yn = 'Y'" ;
String code_name = "";
if(rs!=null)rs.close();
rs=stmt.executeQuery(sql) ;
while(rs.next())
		{
				code_name = code_name+rs.getString(1)+"||";
		}
		
		if(code_name.substring(code_name.length()-2,code_name.length()) .equals("||"))
			code_name = code_name.substring(0,code_name.length()-2);
		
		out.println("<input id=code_name  type='hidden' name= code_name value = '"+code_name+"'>"); 
%>
<input type='hidden' name='module_id' id='module_id' value='<%=module_id%>'>
<input type='hidden' name='tableid' id='tableid' value='<%=tableid%>'>
<input type='hidden' name='criteria_String' id='criteria_String' value='<%=criteria_String%>'>
<input type = 'hidden' name = 'code' value = 'X'>


						</form>
</body>

</html>
 <%pklist.clear();
	}catch(Exception e){out.println(e);}
finally{
	
if(rs!=null) rs.close();
if(rs1!=null) rs1.close();
if(rs4!=null) rs4.close();
if(stmt!=null) stmt.close();
if(con!=null) ConnectionManager.returnConnection(con,request);

}
%>

