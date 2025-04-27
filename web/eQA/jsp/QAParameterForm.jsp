<!DOCTYPE html>
<!--
               Developed By :-  Rajesh Kanna.S
			                        1/2/2005 

-->
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<html>
<head>
  <%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script src='../../eCommon/js/MstCodeCommon.js' language='javascript'></script>
  <script language='javascript' src='../../eQA/js/QAParameter.js'></script>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/messages.js'></script>
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eQA/js/QAMessages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%	
	Connection con 					= null;
	ResultSet rset					= null;
	PreparedStatement pstmt			= null;
	String mode						= "";
	//String	facilityId 				= (String) session.getValue( "facility_id" ) ;
	String	analyzeenc				= "";	
	String	encounterstatus			= "";	
	String  encounteripTo			= "";
	String  encounteripFrom			= "";
	String  encounteropTo			= "";
	String  encounteropFrom			= "";
	String  encounterdcTo			= "";
	String  encounterdcFrom			= "";
	String  encounteremTo			= "";
	String  encounteremFrom			= "";
	String  encounterxtTo			= "";
	String  encounterxtFrom			= "";
	String  encollecipTo			= "";
	String  encollecipFrom			= "";
	String  encollecopTo			= "";
	String  encollecopFrom			= "";
	String  encollecdcTo			= "";
	String  encollecdcFrom			= "";
	String  encollecemTo			= "";
	String  encollecemFrom			= "";
	String  encollecxtTo			= "";
	String  encollecxtFrom			= "";
	String  checkBoxAttribute		= "";
	mode="INSERT";
	try
    {
     con	 = ConnectionManager.getConnection(request);
	 pstmt	 = con.prepareStatement("Select * from  qa_qind_param");
	 rset	 = pstmt.executeQuery();
	 if(rset!=null && rset.next())
	  {    
		analyzeenc		= rset.getString("DIR_REC_INCL_ANALYZED_YN");
		if(analyzeenc!=null &&analyzeenc.equalsIgnoreCase("Y"))
			checkBoxAttribute = "checked";
        encounterstatus		= rset.getString("DIR_REC_ENC_STATUS");    
		encounterstatus		= (encounterstatus == null)?"A":encounterstatus.trim();	 
		encounteripTo		= rset.getString("DIR_REC_PRD_TO_DAYS_BACK_IP");    
		encounteripTo		= (encounteripTo == null)?"7":encounteripTo;	 
		encounteripFrom		= rset.getString("DIR_REC_PRD_FR_DAYS_BACK_IP");    
		encounteripFrom		= (encounteripFrom == null)?"14":encounteripFrom;	 
       	encounteropTo		= rset.getString("DIR_REC_PRD_TO_DAYS_BACK_OP");    
		encounteropTo		= (encounteropTo == null)?"7":encounteropTo;	 
      	encounteropFrom		= rset.getString("DIR_REC_PRD_FR_DAYS_BACK_OP");    
		encounteropFrom		= (encounteropFrom == null)?"14":encounteropFrom;	 
       	encounterdcTo		= rset.getString("DIR_REC_PRD_TO_DAYS_BACK_DC");    
		encounterdcTo		= (encounterdcTo == null)?"7":encounterdcTo;	 
 	    encounterdcFrom		= rset.getString("DIR_REC_PRD_FR_DAYS_BACK_DC");    
		encounterdcFrom		= (encounterdcFrom == null)?"14":encounterdcFrom;	 
		encounteremTo		= rset.getString("DIR_REC_PRD_TO_DAYS_BACK_EM");    
		encounteremTo		= (encounteremTo == null)?"7":encounteremTo;	 
      	encounteremFrom		= rset.getString("DIR_REC_PRD_FR_DAYS_BACK_EM");    
		encounteremFrom		= (encounteremFrom == null)?"14":encounteremFrom;	 
      	encounterxtTo		= rset.getString("DIR_REC_PRD_TO_DAYS_BACK_XT");    
		encounterxtTo		= (encounterxtTo == null)?"7":encounterxtTo;	 
       	encounterxtFrom		= rset.getString("DIR_REC_PRD_FR_DAYS_BACK_XT");    
		encounterxtFrom		= (encounterxtFrom == null)?"14":encounterxtFrom;	 
        encollecipTo		= rset.getString("SYS_REC_PROC_UPTO_DATE_IP");    
 	    encollecipTo		= (encollecipTo == null)?"7":encollecipTo;	 
		encollecipFrom		= rset.getString("SYS_REC_DAYS_AFT_CLOSE_IP");    
		encollecipFrom		= (encollecipFrom == null)?"7":encollecipFrom;	 
       	encollecopTo		= rset.getString("SYS_REC_PROC_UPTO_DATE_OP");    
		encollecopTo		= (encollecopTo == null)?"7":encollecopTo;	 
      	encollecopFrom		= rset.getString("SYS_REC_DAYS_AFT_CLOSE_OP");    
		encollecopFrom		= (encollecopFrom == null)?"7":encollecopFrom;	 
		encollecdcTo		= rset.getString("SYS_REC_PROC_UPTO_DATE_DC");    
		encollecdcTo		= (encollecdcTo == null)?"7":encollecdcTo;	 
		encollecdcFrom		= rset.getString("SYS_REC_DAYS_AFT_CLOSE_DC");    
		encollecdcFrom		= (encollecdcFrom == null)?"7":encollecdcFrom;	 
		encollecemTo		= rset.getString("SYS_REC_PROC_UPTO_DATE_EM");    
		encollecemTo		= (encollecemTo == null)?"7":encollecemTo;	 
		encollecemFrom		= rset.getString("SYS_REC_DAYS_AFT_CLOSE_EM");    
		encollecemFrom		= (encollecemFrom == null)?"7":encollecemFrom;	 
		encollecxtTo		= rset.getString("SYS_REC_PROC_UPTO_DATE_XT");    
		encollecxtTo		= (encollecxtTo == null)?"7":encollecxtTo;	 
		encollecxtFrom		= rset.getString("SYS_REC_DAYS_AFT_CLOSE_XT");    
		encollecxtFrom		= (encollecxtFrom == null)?"7":encollecxtFrom;	 
	    mode				= "MODIFY";
    }
    else
    {
		encounteripTo		="7";
		encounteripFrom		="14";
		encounteropTo		="7";
		encounteropFrom		="14";
		encounterdcTo		="7";
		encounterdcFrom		="14";
		encounteremTo		="7";
		encounteremFrom		="14";
		encounterxtTo		="7";
		encounterxtFrom		="14";
		encollecipFrom		="7";
		encollecopFrom		="7";
		encollecdcFrom		="7";
		encollecemFrom		="7";
		encollecxtFrom		="7";
	}
 %>
 <body OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
 <form name="qaparameter_form" id="qaparameter_form" action="../../servlet/eQA.QAParameterServlet" method="post" target="messageFrame">
 <table border="0" cellpadding="0" cellspacing="0" align='center' width='90%'>
 <br><br>
 <tr><th align=left colspan=3> Direct Recording: Encounter Selection Defaults </th></tr> 
 <tr><td align=left colspan=3> &nbsp;</td></tr>       
 <tr><td class=label>&nbsp;</td> <td class=label  >Period To &nbsp; </td><td class=label  align=left>Period  From&nbsp;</td></tr>
 <tr><td class=label align=right width=40%><B>Days to backdate</B> For IP &nbsp; </td ><td width=15%><input type='text' name='encounteripTo' id='encounteripTo'  value='<%=encounteripTo%>' maxLength='4' size='4'  onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='checkSequence(this)'>  </td> <td><input type='text' name='encounteripFrom' id='encounteripFrom'  value='<%=encounteripFrom%>' maxLength='4' size='4'   onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='checkSequence(this)'></td></tr>
 <tr><td class=label align=right>&nbsp;For DC   &nbsp; </td> <td><input type='text' name='encounterdcTo' id='encounterdcTo'  value='<%=encounterdcTo%>'maxLength='4' size='4' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='checkSequence(this)'>  </td> <td><input type='text' name='encounterdcFrom' id='encounterdcFrom'   value='<%=encounterdcFrom%>'maxLength='4' size='4' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='checkSequence(this)'></td></tr>
 <tr><td class=label align=right>&nbsp;For OP  &nbsp; </td> <td><input type='text' name='encounteropTo' id='encounteropTo'   value='<%=encounteropTo%>'maxLength='4' size='4' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='checkSequence(this)'>  </td> <td><input type='text' name='encounteropFrom' id='encounteropFrom'  value='<%=encounteropFrom%>' maxLength='4' size='4'  onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='checkSequence(this)'></td></tr>
 <tr><td class=label align=right>&nbsp; For EM  &nbsp; </td> <td><input type='text' name='encounteremTo' id='encounteremTo'   value='<%=encounteremTo%>'maxLength='4' size='4' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='checkSequence(this)'>  </td> <td><input type='text' name='encounteremFrom' id='encounteremFrom'   value='<%=encounteremFrom%>'maxLength='4' size='4' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='checkSequence(this)'></td></tr>
 <tr><td class=label align=right>&nbsp;For XT   &nbsp; </td> <td><input type='text' name='encounterxtTo' id='encounterxtTo'  value='<%=encounterxtTo%>'maxLength='4' size='4' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='checkSequence(this)'>  </td> <td><input type='text' name='encounterxtFrom' id='encounterxtFrom'  value='<%=encounterxtFrom%>' maxLength='4' size='4'  onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='checkSequence(this)'></td></tr>
 <tr><td align=left colspan=3> &nbsp;</td></tr> 
 <tr><td class=label align=right>Encounter Status &nbsp; </td> <td>
 <SELECT name="encounterstatus" id="encounterstatus">
 <% if(encounterstatus.equals("A")){	%>
		 <option value='A'>All</option>
		 <%}else{%>
		<option value='A'>All</option>
		<%}%>

		<% if(encounterstatus.equals("O")){	%>
		 <option value='O' selected>Open</option>
		 <%}else{%>
		  <option value='O' >Open</option>
		<%}%>
		<% if(encounterstatus.equals("C"))	%>
		 <option  value='C' selected>Closed</option>
		 <%else{%>
		  <option value='C'>Closed</option>
		 <%}%>
			  </SELECT></td><td>&nbsp;</td></tr>
<tr><td class=label align=right>Include Analyzed Encounters  &nbsp; </td> <td>
<INPUT TYPE="checkbox" name="analyzeenc" id="analyzeenc"  value='<%=analyzeenc%>'	 onclick='chkValue(this);' <%=checkBoxAttribute%>></td><td>&nbsp;</td></tr>
<tr><td align=left colspan=3> &nbsp;</td></tr>
<tr><th align=left colspan=3> Automated Data Collection: Encounter Selection Controls </th></tr> 
<tr><td align=left colspan=3> &nbsp;</td></tr>       
<tr><td class=label align=right><B>Min Days After Discharge/Check-out</B> For IP &nbsp; </td> <td><input type='text' name='encollecipTo' id='encollecipTo'  value='<%=encollecipFrom%>'maxLength='4' size='4'  onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='checkSequence(this)'>  </td> <td>&nbsp;</td></tr>
<tr><td class=label align=right>&nbsp;For DC   &nbsp; </td> <td><input type='text' name='encollecdcTo' id='encollecdcTo'   value='<%=encollecdcFrom%>'maxLength='4' size='4' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='checkSequence(this)'>  </td> <td>&nbsp;</td></tr>
<tr><td class=label align=right>&nbsp;For OP  &nbsp; </td> <td><input type='text' name='encollecopTo' id='encollecopTo'   value='<%=encollecopFrom%>'maxLength='4' size='4' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='checkSequence(this)'> </td><td> &nbsp;</td></tr>
<tr><td class=label align=right>&nbsp; For EM  &nbsp; </td> <td><input type='text' name='encollecemTo' id='encollecemTo'   value='<%=encollecemFrom%>'maxLength='4' size='4' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='checkSequence(this)'>  </td> <td>&nbsp;</td></tr>
<tr><td class=label align=right>&nbsp;For XT   &nbsp; </td> <td><input type='text' name='encollecxtTo' id='encollecxtTo'  value='<%=encollecxtFrom%>'maxLength='4' size='4' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='checkSequence(this)'>  </td> <td>&nbsp;</td></tr>
<tr><td align=left colspan=3> &nbsp;</td></tr>
<input type="hidden"  name=mode id=mode  value='<%=mode%>'>
</table>
</form>
<%
	if(rset!=null) rset.close();
	if(pstmt!=null) pstmt.close();
  }
  catch(Exception e)
  {
  out.println("Main "+e);
  }
finally
{
   ConnectionManager.returnConnection(con,request);
}
%>
</html>

