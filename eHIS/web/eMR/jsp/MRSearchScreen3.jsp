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


		<%@ page import="java.sql.*, java.text.*, webbeans.eCommon.*" %>

		<%
			Connection con=null; 
			PreparedStatement stmt=null;
			ResultSet rs		 	= null;
			//String fac_id    	= (String) session.getValue( "facility_id" ) ;
			String from_diag=request.getParameter("From_Diag");
			String to_diag=request.getParameter("To_Diag");
			String auth=request.getParameter("p_auth_yn");			
			String p_code_indicator =(request.getParameter("p_code_indicator")==null)?"":request.getParameter("p_code_indicator");
			String sql="";

			String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
			String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
			String step =(request.getParameter("step")==null)?"":request.getParameter("step");
			String defn_levels =(request.getParameter("defn_levels")==null)?"":request.getParameter("defn_levels");	
			String term_set_id =(request.getParameter("term_set_id")==null)?"":request.getParameter("term_set_id");	
			String term_code =(request.getParameter("term_code")==null)?"":request.getParameter("term_code");			
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
			//function loadOtherFrames(scheme,code,desc)
			function loadOtherFrames(code,term_set_id,defn_levels,step,desc,select_yn,oldstep)
			{
				
				var scheme = "";
				if(term_set_id=="ICD10")
					scheme = "1";

				//parent.parent.frames[1].document.forms[0].elements(1).disabled=true
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
				parent.parent.frames[1].document.f.diag_scheme.value=scheme;
				parent.parent.frames[1].document.forms[0].term_set_id.value=term_set_id;

			//parent.frames[3].location.href='MRSearchScreen4.jsp?p_auth_yn=<%=auth%>&Scheme='+scheme+'&Search_Code='+code + '&Sex=<%=sex%>&Dob=<%=dob%>&p_code_indicator=<%=p_code_indicator%>';
			
				if(defn_levels==oldstep)
				{
				}
				else
				{
					parent.frames[3].location.href='MRSearchScreen4.jsp?term_set_id='+term_set_id+'&defn_levels='+defn_levels+'&term_code='+code+'&step='+step+'&p_auth_yn=<%=auth%>&Sex=<%=sex%>&Dob=<%=dob%>&p_code_indicator=<%=p_code_indicator%>';
				}
					
				if(select_yn=='Y')
					parent.parent.frames[1].document.forms[0].elements[1].disabled=false;
				else
					parent.parent.frames[1].document.forms[0].elements[1].disabled=true;
			}

			function loadOtherFramesICD10(scheme,code,desc,term_set_id)
			{
				//parent.parent.frames[1].document.forms[0].elements(1).disabled=true
				parent.parent.frames[1].document.forms[0].elements[1].disabled=false;
				while(desc.indexOf(";")!=-1)
					desc=desc.replace(";" ,' ');
				parent.parent.frames[1].document.forms[0].elements[0].value=desc+", "+code;
				parent.parent.frames[1].document.forms[0].elements[2].value=code;
				parent.parent.frames[1].document.f.diag_scheme.value=scheme;
				parent.parent.frames[1].document.forms[0].term_set_id.value=term_set_id;
				parent.frames[3].location.href='MRSearchScreen4.jsp?term_set_id=<%=term_set_id%>&p_auth_yn=<%=auth%>&Scheme='+scheme+'&Search_Code='+code + '&Sex=<%=sex%>&Dob=<%=dob%>&p_code_indicator=<%=p_code_indicator%>';
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
				sql="select diag_code,long_desc,short_desc, diag_code||'-'||short_desc diag_desc,diag_code_scheme from mr_icd_code where length(diag_code)=3 and diag_code between '"+from_diag+"' and '"+to_diag+"' and nvl(sensitive_yn,'N')=decode('"+auth+"' ,'N' ,'N',nvl(sensitive_yn,'N'))order by diag_code";
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);


*/

				/*if(term_set_id.equals("ICD10"))
				{
					sql="select diag_code,long_desc,short_desc, diag_code||'-'||short_desc diag_desc,diag_code_scheme from mr_icd_code where length(diag_code)=3 and diag_code between ? and ? ";
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
				/*if(term_set_id.equals("ICD10"))
				{
					stmt.setString(1,from_diag);
					stmt.setString(2,to_diag);
				}*/

				rs=stmt.executeQuery();
					
				if(rs!=null)
				{
					String s="";
					while(rs.next())
					{	
						s=rs.getString("long_desc");
						if(s!=null)
							s=s.replace(' ', ';');
							s=s.replaceAll("'", "|");
							s=s.replace('"', '$');

						%>
					<tr  onclick='change_row_color(this)'>
					<td>
						
					
						<a href='javascript:loadOtherFrames("<%=rs.getString("term_code")%>","<%=term_set_id%>","<%=defn_levels%>","<%=Integer.parseInt(step)+1%>","<%=s%>","<%=rs.getString("select_yn")%>","<%=Integer.parseInt(step)%>")'><font size=1><%=rs.getString("long_desc")%><a><br>
						
					</td>
					</tr>
			<%	}
				if (s.equals(""))
					{
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'))</script>");					
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

