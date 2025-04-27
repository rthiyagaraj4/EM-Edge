<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 <script src='../../eCommon/js/common.js' language='javascript'></script>


 <%
		Connection con						 =  null;
		ResultSet rs 						 =	null;
		PreparedStatement pstmt				 =	null; 

		request.setCharacterEncoding("UTF-8");
	    String locale						=	(String)session.getAttribute("LOCALE");
		String attend_physician_id			=	checkForNull(request.getParameter("attend_physician_id"));
		String pract_flag					=	checkForNull(request.getParameter("pract_flag"));
		String dateformate_flag				=	checkForNull(request.getParameter("dateformate_flag"));
		String stillBirthDates				=	checkForNull(request.getParameter("stillBirthDates"));
		String RecordedDates				=	checkForNull(request.getParameter("RecordedDates"));
		String age							=	"";
		String apc_no						=	"";
		String age_val1                     =   "";
		String year1						=	"";
		String month1						=	"";
		String day1							=	"";
		String hour1						=	"";
		String dateFormat1					=	"";
		StringBuffer sqlPract				=	null;
		StringBuffer sqlDate				=	null;

	%>
	<html>
	<head>
	<%
	String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eMP/js/MPStillBirthDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<BODY class='message' onKeyDown = 'lockKey()'>
	<form>
	<%
try
	{
	   con					      = ConnectionManager.getConnection(request);

	if(pract_flag!=null)
		{
		    if(pract_flag.equals("Y"))
			{
			   if(attend_physician_id!=null)
				{
					if(!attend_physician_id.equals(""))
					{
					  sqlPract = new StringBuffer();
					  sqlPract.append("select  get_age(date_of_birth) age,apc_no from am_practitioner_lang_vw where practitioner_id = ? and language_id = '"+locale+"' ");
					  pstmt   = con.prepareStatement(sqlPract.toString());
					  pstmt.setString(1, attend_physician_id);

					  rs		 = pstmt.executeQuery();
					  if(rs!=null && rs.next())
					  {		
						age						= checkForNull(rs.getString("age"));
						apc_no                  = checkForNull(rs.getString("apc_no")); 
					  }//End of if
					if(!age.equals("")) 
					{
						int age_val = age.indexOf("Y");
						age_val1 = age.substring(0,age_val);
				   }
				  %>
					<script>
						parent.frames[0].document.forms[0].age.value ="<%=age_val1%>";
						parent.frames[0].document.forms[0].licenseNo.value ="<%=apc_no%>";
					</script>	
				  <%
					  if(pstmt!=null) pstmt.close();
					  if(rs!=null) rs.close(); 
					  if((sqlPract != null) && (sqlPract.length() > 0))
					  {
						sqlPract.delete(0,sqlPract.length());
					  } 
				  }
				} 
	}
  }
  if(dateformate_flag!=null)
	{
		if(dateformate_flag.equals("Y"))
		{
			sqlDate = new StringBuffer();

			StringTokenizer date1 = new StringTokenizer(stillBirthDates,"#");
			StringTokenizer date2_ref = new StringTokenizer(RecordedDates,"#");

			int i = 0;
			sqlDate.append("select CALCULATE_DATE_OF_BIRTH_YMDH (?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi')) from dual"); // to be changed

			pstmt   = con.prepareStatement(sqlDate.toString());


			while(date1.hasMoreTokens()){
				i++;
				String dd = date1.nextToken();
				String dd_ref = date2_ref.nextToken();  // to be passed to procedure

				StringTokenizer date2 = new StringTokenizer(dd,"^");
					
					while(date2.hasMoreTokens()){
						year1  =date2.nextToken();
						month1 =date2.nextToken();
						day1   =date2.nextToken();
						hour1  =date2.nextToken();
						
						pstmt.setString(1, year1);
						pstmt.setString(2, month1);
						pstmt.setString(3, day1);
						pstmt.setString(4, hour1);
						pstmt.setString(5, dd_ref);							

						boolean entered=true;

						if(year1.equals("0") && month1.equals("0") && day1.equals("0")){
							if( i<=4){
								if(hour1.equals("0")){
									entered=false;
								}
							}else{
								entered=false;
							}

						}
						
							
						if(entered){

								rs = pstmt.executeQuery();

								if (rs != null){
									rs.next();
									dateFormat1 = rs.getString(1);
								}

								
								%>
								<script>
									eval("parent.frames[0].document.forms[0].stillBirthDate"+<%=i%>).value ="<%=dateFormat1%>";
								</script>	
					  <%
						}else{
							%>
								<script>
									eval("parent.frames[0].document.forms[0].stillBirthDate"+<%=i%>).value ="";
								</script>	
					  <%
						}


				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			%>
			<script>
				parent.frames[0].document.forms[0].val_done.value ="Y";
			</script>	
		  <%
		}
	}
}
catch(Exception e){ e.toString(); }
	finally {
		           ConnectionManager.returnConnection(con,request);  
		    }
	%>
	</form>
		<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
%>

	</body>
	</html>	 

