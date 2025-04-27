<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<html>
<head>
  <%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eQA/js/QAIndicatorsForDiscipline.js'></script>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/messages.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script> 
  <!-- <script language='javascript' src='../../eCommon/js/MstCodeCommon.js' ></script> -->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  
</head>
  <%	
     session.removeAttribute("hashIndicator");
	 session.removeAttribute("arrayKeys");
	 Connection con 					= null;
	 PreparedStatement pstmt			= null;
	 ResultSet rset					    = null;
	 
	 String disip			= request.getParameter("disipid");
	 disip			= (disip == null)?"":disip;

	  String  disipline= "select qind_discipline_id,qind_discipline_desc from qa_qind_discipline  where eff_status='E' order by 2";
  
	%>
 	 
	 <body OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
	 <form name="IndicatorFacilityform" id="IndicatorFacilityform" action="../../servlet/eQA.QAIndicatorForDisciplineServlet" method="post" target="messageFrame">

	 <table border="0" cellpadding="0" cellspacing="0" align='center' width='90%'>
	    <tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
	    <tr>
		      <td align='left' width='12%'>&nbsp;</td> 	
		      <td class='label' align='right' width='25%'>Discipline</td>
		      <td class='label' align='left' width='40%'>&nbsp;<select name='disipid' id='disipid'  >
		      <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----Select----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		      <%
				 try
				 {
                    con	    = ConnectionManager.getConnection(request);
				    pstmt   = con.prepareStatement(disipline);
				    rset    = pstmt.executeQuery();
			
				 while(rset!=null && rset.next())
				 {
					
                        out.println("<option value='"+rset.getString(1)+"'>");	     
					    out.println(rset.getString(2));
					    out.println("</option>"); 
				 }

				 if(pstmt!=null) pstmt.close();
				 if(rset!=null) rset.close();
              %>
		      </select>
   		      <img src='../../eCommon/images/mandatory.gif' align='center'></img>
			  </td> 	
		      <td align='left' width='13%'>&nbsp;</td>
	    </tr>	
		<tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
		
          <tr>
		      <td align='left' width='12%'>&nbsp;</td> 	
		      <td class='label' align='right' width='25%'>Indicator ID</td>
		      <td class='label' align='left' width='40%'>&nbsp;
			  <Input Type=text name=indi id=indi onKeyPress='return CheckForSpecChars(event)' size='4' maxlength='4'>
				</td>
				  <td align='left' width='12%'>&nbsp;</td> 
		</tr>

<tr>				 <!--  ---------------- -->
	<td align='right' class='label' colspan=2></td>
	<td class='label' align=right>
	<input type='button' name='search' id='search' value='Search' class='button' onclick='submitPage()'></td>
	<td class='label' align=center>
	<input type='button' name='clear' id='clear' value='Clear' class='button' onclick='clearAll();'></td>	
	</tr>
</table>
	 </form>
		
    </body>

<%      if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
	  } 
	
	   catch(Exception e)
		   {
		   out.println("Exception in File QAIndicatorsForDiscipline1"+e.toString());}
   finally
    {
    	
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

