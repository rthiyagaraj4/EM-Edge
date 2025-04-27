<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale = checkForNull((String)session.getAttribute("LOCALE")); 

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%@ page import="java.sql.*,java.text.*, webbeans.eCommon.*" %>

		<%

			Connection con=null;
			PreparedStatement stmt=null;
			ResultSet rs	= null;
			//String fac_id   = (String) session.getValue( "facility_id" ) ;
			String scheme=request.getParameter("Scheme")==null?"":request.getParameter("Scheme");
			String code=request.getParameter("Search_Code")==null?"":request.getParameter("Search_Code");
			String p_code_indicator =(request.getParameter("p_code_indicator")==null)?"":request.getParameter("p_code_indicator");
			String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
			String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
			String auth=request.getParameter("p_auth_yn");			
			String step =(request.getParameter("step")==null)?"":request.getParameter("step");
			String defn_levels =(request.getParameter("defn_levels")==null)?"":request.getParameter("defn_levels");	
			String term_set_id =(request.getParameter("term_set_id")==null)?"":request.getParameter("term_set_id");	
			String term_code =(request.getParameter("term_code")==null)?"":request.getParameter("term_code");	

		//String auth=request.getParameter("p_auth_yn")==null?"":request.getParameter("p_auth_yn");			
			//String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");			

			//out.println(" called_from"+called_from);
			String sql="";
			//String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
			//String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
		%>
		
		<script>
			var prev=0
			function  change_row_color(obj)
			{
					document.getElementById("t").rows[prev].cells[0].style.backgroundColor=obj.bgColor
					//obj.cells(0).style.backgroundColor="#B2B6D7"
					obj.cells[0].style.backgroundColor="#d3d3d3"
					prev	=obj.rowIndex
			}
			//function closewin(code,desc)
			function closewin(code,term_set_id,defn_levels,step,desc,old_term_code,select_yn)
			{
				//parent.parent.frames[1].document.forms[0].elements(1).disabled=false;
				while(desc.indexOf(";")!=-1){
					desc=desc.replace(";" ,' ');
				}
				while(desc.indexOf("|")!=-1){
					desc=desc.replace("|" ,"'");
				}
				while(desc.indexOf("$")!=-1){
					desc=desc.replace('$' ,'"');
				}
				parent.parent.frames[1].document.forms[0].elements[0].value=desc+", "+code;
				parent.parent.frames[1].document.forms[0].elements[2].value=code;	
				parent.parent.frames[1].document.forms[0].term_set_id.value=term_set_id;

				if(select_yn=='Y')
					parent.parent.frames[1].document.forms[0].elements[1].disabled=false;
				else
					parent.parent.frames[1].document.forms[0].elements[1].disabled=true;
				
				if(parseInt(defn_levels)>parseInt(step))
				{
					
					parent.frames[0].location.href='MRSearchScreen1.jsp?term_set_id='+term_set_id+'&defn_levels='+defn_levels+'&term_code='+old_term_code+'&step='+step+'&p_auth_yn=<%=auth%>&Sex=<%=sex%>&Dob=<%=dob%>&p_code_indicator=<%=p_code_indicator%>';

					var step_int_val = parseInt(step);
					step_int_val = step_int_val + 1;
					parent.frames[1].location.href='MRSearchScreen2.jsp?term_set_id='+term_set_id+'&defn_levels='+defn_levels+'&term_code='+code+'&step='+step_int_val+'&p_auth_yn=<%=auth%>&Search_Code='+code+'&Sex=<%=sex%>&Dob=<%=dob%>&p_code_indicator=<%=p_code_indicator%>';

					parent.frames[2].location.href="../../eCommon/html/blank.html";

					parent.frames[3].location.href="../../eCommon/html/blank.html";					
				}
			}

			function closewinICD10(code,desc,term_set_id)
			{
				parent.parent.frames[1].document.forms[0].elements[1].disabled=false;
				while(desc.indexOf(";")!=-1)
					desc=desc.replace(";" ,' ');
				parent.parent.frames[1].document.forms[0].elements[0].value=desc+", "+code;
				parent.parent.frames[1].document.forms[0].elements[2].value=code;
				parent.parent.frames[1].document.forms[0].term_set_id.value=term_set_id;

				
			
			}
		</script>
	</head>
	
	<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<table cellspacing=1 cellpadding=2 width='100%' id='t'  border=0 name='t' id='t'>
		<%
			try
			{
				con = ConnectionManager.getConnection(request);
/*
				sql="select diag_code,diag_code||'-'||short_desc d , long_desc from mr_icd_code where length(diag_code)>=4 and diag_code like  '" +code+"%' and diag_code_scheme = '"+scheme+"' and nvl(sensitive_yn,'N') =decode('"+auth+"','N','N',nvl(sensitive_yn,'N'))  order by diag_code ";
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
*/				

				/*if(term_set_id.equals("ICD10"))
				{
					sql="select diag_code,diag_code||'-'||short_desc d , long_desc from mr_icd_code where length(diag_code)>=4 and diag_code like  ? and diag_code_scheme = ?  ";
					if(p_code_indicator.equals(""))
						sql=sql+" and ( code_indicator in ('C','D') OR code_indicator IS NULL ) ";
					else
						sql=sql+" and code_indicator = '"+p_code_indicator+"'"; 

					sql=sql+" order by diag_code ";
				}
				else
				{*/
					//sql="select  term_code,long_desc , select_yn from mr_term_code where term_set_id = '"+term_set_id+"' and code_level='"+step+"' and term_code like '"+term_code+"%'  order by long_desc";
						/*
							The following query was modified for IN023648.
							Modified On:10/5/2010
						*/
//					sql="select  term_code,long_desc , select_yn from mr_term_code where term_set_id = '"+term_set_id+"' and code_level='"+step+"' and part_term_code = '"+term_code+"' and diagnosis_yn = 'Y'  order by long_desc";
					sql="select  term_code,long_desc , select_yn from mr_d_"+term_set_id+"_lang_vw where term_set_id = '"+term_set_id+"' and code_level='"+step+"' and part_term_code = '"+term_code+"' and diagnosis_yn = 'Y' and language_id='"+locale+"'  order by long_desc";
				//}
				stmt=con.prepareStatement(sql);
				//out.println("<script>alert(\""+sql+"\");</script>");

				/*if(term_set_id.equals("ICD10"))
				{
					stmt.setString(1,code+"%");
					stmt.setString(2,scheme);
				}*/
				
				rs=stmt.executeQuery();
				String s="";
				if(rs!=null){
					while(rs.next()){
						s=rs.getString("long_desc");
						if(s!=null){
							s=s.replace(' ', ';');
							s=s.replaceAll("'", "|");
							s=s.replace('"', '$');
						}
					%>
					<tr  onclick='change_row_color(this)'>
						<td>
							<a href='javascript:closewin("<%=rs.getString("term_code")%>","<%=term_set_id%>","<%=defn_levels%>","<%=Integer.parseInt(step)%>","<%=s%>","<%=term_code%>","<%=rs.getString("select_yn")%>","<%=Integer.parseInt(step)%>")' ><font size=1><%=rs.getString("long_desc")%><a><br>
						</td>
					</tr>						
			<%	}

					if (s.equals(""))
					{
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'))</script>");
					//out.println("<script>parent.parent.frames[1].document.forms[0].elements(1).disabled=false;</script>");
				    }
				}
			
				if(rs!=null)	rs.close();
				if(stmt!=null)	stmt.close();
			}
			catch(Exception e){e.printStackTrace();}
			finally
			{
				
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}
		%>
		</table>
	</body>
</html>
<%!
public static String checkForNull(String inputString){
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue){
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

