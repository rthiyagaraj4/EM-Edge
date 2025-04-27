<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<Script language='javascript' src='../../eMP/js/PatientSearch.js'></Script>
<%
request.setCharacterEncoding("UTF-8");
String First_Name=request.getParameter("First_Name");if(First_Name==null)First_Name="";
String Second_Name=request.getParameter("Second_Name");if(Second_Name==null)Second_Name="";
String Third_Name=request.getParameter("Third_Name");if(Third_Name==null)Third_Name="";
String Family_Name=request.getParameter("Family_Name");if(Family_Name==null)Family_Name="";
String Alt_Id_No=request.getParameter("Alt_Id_No");if(Alt_Id_No==null)Alt_Id_No="";
String Alt_Id2_No=request.getParameter("Alt_Id2_No");if(Alt_Id2_No==null)Alt_Id2_No="";
String Alt_Id3_No=request.getParameter("Alt_Id3_No");if(Alt_Id3_No==null)Alt_Id3_No="";
String Alt_Id4_No=request.getParameter("Alt_Id4_No");if(Alt_Id4_No==null)Alt_Id4_No="";
String National_Id_No=request.getParameter("National_Id_No");if(National_Id_No==null)National_Id_No="";
String MRN=request.getParameter("MRN");if(MRN==null)MRN="";
String Dob=request.getParameter("Dob");if(Dob==null)Dob="";
String Sex=request.getParameter("Sex");if(Sex==null)Sex="";
String Area=request.getParameter("Area");if(Area==null)Area="";
String Family_No=request.getParameter("Family_No");if(Family_No==null)Family_No="";
String OldFileNo=request.getParameter("OldFileNo");if(OldFileNo==null)OldFileNo="";
String apply_oth_name=request.getParameter("apply_oth_name");if(apply_oth_name==null)apply_oth_name="";
String first_name_loc_lang=request.getParameter("first_name_loc_lang");if(first_name_loc_lang==null)first_name_loc_lang="";
String second_name_loc_lang=request.getParameter("second_name_loc_lang");if(second_name_loc_lang==null)second_name_loc_lang="";
String third_name_loc_lang=request.getParameter("third_name_loc_lang");if(third_name_loc_lang==null)third_name_loc_lang="";
String family_name_loc_lang=request.getParameter("family_name_loc_lang");if(family_name_loc_lang==null)family_name_loc_lang="";
String dflt_pat_ser_grp_type = "" ;
String alt_id1_type = "" ;
String nat_id_prompt = "" ;
String countSeries = "" ;
String countPatSeries = "" ;
int cntSeries = 0, cntPatSeries = 0;
dflt_pat_ser_grp_type = request.getParameter("dflt_pat_ser_grp_type");
alt_id1_type = request.getParameter("alt_id1_type");
nat_id_prompt = request.getParameter("nat_id_prompt");
countSeries = request.getParameter("cntSeries");
countPatSeries= request.getParameter("cntPatSeries");
try
{		
	cntSeries = Integer.parseInt(countSeries);
	cntPatSeries = Integer.parseInt(countPatSeries);
	   if (cntSeries > 0)
		{			
			if (cntPatSeries > 0)
			{
				if  (dflt_pat_ser_grp_type.equals("G") ) 
				{
				
			%>  
				<html>
					<head>
					</head>
					<body onKeyDown='lockKey();'>
					<form name ="RapidPass" id ="RapidPass">
					<input type = "hidden" id = "Second_Name" name = "Second_Name" value = "<%=Second_Name%>">					
					<input type = "hidden" id = "First_Name" name = "First_Name" value = "<%=First_Name%>">
					<input type = "hidden" id = "Third_Name" name = "Third_Name" value = "<%=Third_Name%>">
					<input type = "hidden" id = "Family_Name" name = "Family_Name" value = "<%=Family_Name%>">
					<input type = "hidden" id = "first_name_loc_lang" name = "first_name_loc_lang" value ="<%=first_name_loc_lang%>">
					<input type = "hidden" id = "second_name_loc_lang" name = "second_name_loc_lang" value ="<%=second_name_loc_lang%>">
					<input type = "hidden" id = "third_name_loc_lang" name = "third_name_loc_lang" value ="<%=third_name_loc_lang%>">
					<input type = "hidden" id = "family_name_loc_lang" name = "family_name_loc_lang" value ="<%=family_name_loc_lang%>">
					
						<script language='javascript'>
							parent.frames[0].location = "InsertRapidRegnHead.jsp?<%=request.getQueryString()%>";
							document.location="../../eMP/jsp/InsertRapidRegn.jsp?group=G&First_Name="+encodeURIComponent(document.RapidPass.First_Name.value)+"&Second_Name="+encodeURIComponent(document.RapidPass.Second_Name.value)+"&Third_Name="+encodeURIComponent(document.RapidPass.Third_Name.value)+"&Family_Name="+encodeURIComponent(document.RapidPass.Family_Name.value)+"&Alt_Id_No=<%=Alt_Id_No%>&Alt_Id2_No=<%=Alt_Id2_No%>&Alt_Id3_No=<%=Alt_Id3_No%>&Alt_Id4_No=<%=Alt_Id4_No%>&National_Id_No=<%=National_Id_No%>&MRN=<%=MRN%>&Dob=<%=Dob%>&Sex=<%=Sex%>&Area=<%=Area%>&Family_No=<%=Family_No%>&OldFileNo=<%=OldFileNo%>&apply_oth_name=<%=apply_oth_name%>&first_name_loc_lang="+encodeURIComponent(document.RapidPass.first_name_loc_lang.value)+"&second_name_loc_lang="+encodeURIComponent(document.RapidPass.second_name_loc_lang.value)+"&third_name_loc_lang="+encodeURIComponent(document.RapidPass.third_name_loc_lang.value)+"&family_name_loc_lang="+encodeURIComponent(document.RapidPass.family_name_loc_lang.value)+"&<%=request.getQueryString()%>"
							
						</script>


						</form>
					</body>
				</html>
			<%
				}
				else 
				{
					String prompts=alt_id1_type+"~"+nat_id_prompt ;					
					%>
					<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
					<html>
					<head>
					<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
					<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
					<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
					<script language='javascript'>
						async function showModal()    {  
						var retVal =    new String();
						//var dialogHeight    = "11" ;
						//var dialogWidth = "20" ;
						/* var dialogHeight= "200px" ;
						var dialogTop = "10px" ;
						var dialogWidth	= "350px" ; */
						
						var dialogHeight= "30vh" ;
						var dialogTop = "0vh" ;
						var dialogWidth	= "25vw" ;
						  
						var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no ;";
						var arguments   = "" ;
						retVal = await window.showModalDialog("../../eMP/jsp/loadModal.jsp?series=<%=dflt_pat_ser_grp_type%>&alt_id=<%=request.getParameter("Alt_Id_No")%>&National_Id_No=<%=request.getParameter("National_Id_No")%>&prompt=<%=prompts%>",arguments,features);
						
						var pat_grp ="G"						
						if(retVal != null)
						pat_grp= retVal.charAt(0);
						var loc = "" ;
						parent.frames[0].location = "InsertRapidRegnHead.jsp?<%=request.getQueryString()%>";
						if ( pat_grp == 'N' )
						{
							var pat_id = escape(retVal.substr(1));
							loc="../../eMP/jsp/InsertRapidRegn.jsp?group="+pat_grp+"&nat_id="+pat_id ; 
						}
						else if ( pat_grp == 'A' )
						{
							var alt_id = escape(retVal.substr(1));
							loc="../../eMP/jsp/InsertRapidRegn.jsp?group="+pat_grp+"&alt_id="+alt_id ;
						}
						else if ( pat_grp == 'G' )
						{
							loc="../../eMP/jsp/InsertRapidRegn.jsp?from_modal=Y&group=G"; 
						}
						
						window.location = loc+ "&First_Name="+encodeURIComponent(document.RapidPass.First_Name.value)+"&Second_Name="+encodeURIComponent(document.RapidPass.Second_Name.value)+"&Third_Name="+encodeURIComponent(document.RapidPass.Third_Name.value)+"&Family_Name="+encodeURIComponent(document.RapidPass.Family_Name.value)+"&Alt_Id_No=<%=Alt_Id_No%>&Alt_Id2_No=<%=Alt_Id2_No%>&Alt_Id3_No=<%=Alt_Id3_No%>&Alt_Id4_No=<%=Alt_Id4_No%>&National_Id_No=<%=National_Id_No%>&MRN=<%=MRN%>&Dob=<%=Dob%>&Sex=<%=Sex%>&Area=<%=Area%>&Family_No=<%=Family_No%>&OldFileNo=<%=OldFileNo%>&apply_oth_name=<%=apply_oth_name%>&first_name_loc_lang="+encodeURIComponent(document.RapidPass.first_name_loc_lang.value)+"&second_name_loc_lang="+encodeURIComponent(document.RapidPass.second_name_loc_lang.value)+"&third_name_loc_lang="+encodeURIComponent(document.RapidPass.third_name_loc_lang.value)+"&family_name_loc_lang="+encodeURIComponent(document.RapidPass.family_name_loc_lang.value)+"&<%=request.getQueryString()%>"						
					}
					
					</script>
					</head>
					<body onKeyDown='lockKey();'>
					<form name ="RapidPass">
					<input type = "hidden" id = "Second_Name" name = "Second_Name" value = "<%=Second_Name%>">					
					<input type = "hidden" id = "First_Name" name = "First_Name" value = "<%=First_Name%>">
					<input type = "hidden" id = "Third_Name" name = "Third_Name" value = "<%=Third_Name%>">
					<input type = "hidden" id = "Family_Name" name = "Family_Name" value = "<%=Family_Name%>">
					<input type = "hidden" id = "first_name_loc_lang" name = "first_name_loc_lang" value ="<%=first_name_loc_lang%>">
					<input type = "hidden" id = "second_name_loc_lang" name = "second_name_loc_lang" value ="<%=second_name_loc_lang%>">
					<input type = "hidden" id = "third_name_loc_lang" name = "third_name_loc_lang" value ="<%=third_name_loc_lang%>">
					<input type = "hidden" id = "family_name_loc_lang" name = "family_name_loc_lang" value ="<%=family_name_loc_lang%>">			
					<script language='javascript'>

					setTimeout("showModal()",500);

			</script>

					<form>
					</body>
					</html>
					<% 
				} 
			}
			else
				out.println("<script>alert(getMessage('PAT_NUM_NOT_CREATED','MP'));</script>") ;
		}
		else
			out.println("<script>alert(getMessage('PAT_SER_NOT_CREATED','MP'));</script>") ;
}
catch(Exception e)
{
    out.println("Exception in main try"+e.getMessage());
	e.printStackTrace();
}
finally
{
//	if(conn!=null) ConnectionManager.returnConnection(conn,request);    
}
%>

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

