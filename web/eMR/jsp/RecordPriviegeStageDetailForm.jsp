<!DOCTYPE html>
<!--
Createted by:Anjaneya Reddy M
Date        :12/19/2008
Module      :eMR
Function    :Record PrivlegeStage Datils Form
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<HTML>
<HEAD>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eMR/js/RecodePrivilegeSetup.js'></script>
	<%
			
			
			String p_string_val	= checkForNull(request.getParameter("p_string_val"));
			String p_string_newval	= checkForNull(request.getParameter("p_string_newval"));
			String update_column	= checkForNull(request.getParameter("remove_column"));
			//String authorise	= checkForNull(request.getParameter("authorise"));

			//Thursday, March 26, 2009 Logic for the uncheck the authorise ,all users should uncheck
			String unChkAllAuth	= checkForNull(request.getParameter("unChkAllAuth"));
			String unChk_String_Val="";

			String update_string_val="";


			if(update_column.equals("remove_column")){
				
				       String user_id="";
				       String user_name="";
				       String auth_user="";
						StringTokenizer splitedtoken = null;
						String tokenvalue = "";
						tokenvalue="";
						int j = 0;
					   StringTokenizer token1=new StringTokenizer(p_string_val,"~");
					   update_string_val=update_string_val;
						while(token1.hasMoreTokens()){
								j++ ;
								tokenvalue      = token1.nextToken();
								splitedtoken=new StringTokenizer(tokenvalue,"`");
							while (splitedtoken.hasMoreTokens()){
								user_id		=	splitedtoken.nextToken();
								user_name			=	splitedtoken.nextToken();
								auth_user			=	splitedtoken.nextToken();
								if(!p_string_newval.equals(user_id))
                                  update_string_val=update_string_val+user_id+"`"+user_name+"`"+auth_user+"~";
							}
						}
			}
			
	%>
	

	

</HEAD>
	
<BODY onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()'>	
<FORM name="RecordPriviegeStageDetailForm" id="RecordPriviegeStageDetailForm" >

<TABLE BORDER=0 WIDTH='100%' CELLSPACING=1 CELLPADDING=1 ALIGN='CENTER'  >
<TR>
	<TH WIDTH='5%' CLASS='DATA'>&nbsp;&nbsp; <b><fmt:message key="Common.userid.label" bundle="${common_labels}"/></B></TH>
	<TH WIDTH='5%'  CLASS='DATA'><B><fmt:message key="Common.username.label" bundle="${common_labels}"/></B></TH>
	<TH WIDTH='5%'  CLASS='DATA'><B><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></B></TH>
</TR>
<%
 String      user_id		=	"";
String		user_name			=	"";
String		auth_user		=	"";
int i=0;
String auth_chk="";
/*
 number of user ids coming frommthe db
*/
String _update_mode_yn	= checkForNull(request.getParameter("_update_mode_yn"));
String _spec_user_id	= checkForNull(request.getParameter("all_user"));
if(_update_mode_yn.equals("update_db"))
p_string_val=_spec_user_id;

if(update_column.equals("remove_column"))
p_string_val=update_string_val;



		if(unChkAllAuth.equals("unChk")){
		StringTokenizer splitedtoken = null;
			String tokenvalue = "";
			tokenvalue="";
			i = 0;
		   StringTokenizer token1=new StringTokenizer(p_string_val,"~");
			while(token1.hasMoreTokens()){
					i++ ;
					tokenvalue      = token1.nextToken();
					splitedtoken=new StringTokenizer(tokenvalue,"`");
				while (splitedtoken.hasMoreTokens()){
					user_id		=	splitedtoken.nextToken();
					user_name			=	splitedtoken.nextToken();
					auth_user			=	splitedtoken.nextToken();

					//Thursday, March 26, 2009 Logic for the uncheck the authorise ,all users should uncheck
							if(unChkAllAuth.equals("unChk")){
								auth_chk="";
								auth_user="N";
								unChk_String_Val +=user_id+"`"+user_name+"`"+auth_user+"~";
								
								
							}
							else{
								//Thursday, March 26, 2009 this common before code for unchk
										if(auth_user.equals("Y")){
										auth_chk="checked";
									}
									else
										auth_chk="";
							}
					
					}
			}
			p_string_val=unChk_String_Val;

}




	if (!p_string_val.equals("")){
		   StringTokenizer splitedtoken = null;
			String tokenvalue = "";
			tokenvalue="";
			i = 0;
		   StringTokenizer token1=new StringTokenizer(p_string_val,"~");
			while(token1.hasMoreTokens()){
					i++ ;
					tokenvalue      = token1.nextToken();
					splitedtoken=new StringTokenizer(tokenvalue,"`");
				while (splitedtoken.hasMoreTokens()){
					user_id		=	splitedtoken.nextToken();
					user_name			=	splitedtoken.nextToken();
					user_name = user_name.replaceAll("%27", "\'");
					auth_user			=	splitedtoken.nextToken();

					//Thursday, March 26, 2009 Logic for the uncheck the authorise ,all users should uncheck
					if(unChkAllAuth.equals("unChk")){
						auth_chk="";
						auth_user="N";
						unChk_String_Val +=user_id+"`"+user_name+"`"+auth_user+"~";
						
						
					}
					else{
						//Thursday, March 26, 2009 this common before code for unchk
						if(auth_user.equals("Y")){
						auth_chk="checked";
					}
					else
						auth_chk="";
					}
					
				
%>
	<TR>
		<TD WIDTH='5%' CLASS='DATA'><A><a href='javascript:viewUserDetails(encodeURIComponent("<%=user_id%>"),encodeURIComponent("<%=user_name.replaceAll("\'", "%27")%>"),encodeURIComponent("<%=auth_user%>"),encodeURIComponent("<%=p_string_val.replaceAll("\'", "%27")%>"))'><FONT SIZE=1>  <%=user_id%></FONT></A></A></TD>
		<TD WIDTH='5%' CLASS='DATA'><%=user_name%></TD>
		<TD WIDTH='5%'  CLASS='DATA' >&nbsp;&nbsp;<input type=checkbox name='deleteUser<%=i%>' id='deleteUser<%=i%>' disabled <%=auth_chk%> value=''></TD>
				
    </TR>
<% 
				}
			}
		}
	%>
</TABLE>

<INPUT TYPE='hidden' name='locale' id='locale' VALUE="<%=locale%>">
<INPUT TYPE='hidden' name='p_string_val' id='p_string_val' VALUE="<%=p_string_val%>">
<INPUT TYPE='hidden' name='unChkAllAuth' id='unChkAllAuth' VALUE="<%=unChkAllAuth%>">
<INPUT TYPE='hidden' name='unChk_String_Val' id='unChk_String_Val' VALUE="<%=unChk_String_Val%>">
<INPUT TYPE='hidden' name='update_string_val' id='update_string_val' VALUE="<%=update_string_val%>">
<INPUT TYPE='hidden' name='_spec_user_id' id='_spec_user_id' VALUE="<%=_spec_user_id%>">


</FORM>
</BODY>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

