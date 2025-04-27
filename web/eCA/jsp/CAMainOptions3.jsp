<!DOCTYPE html>
<%@ page import="java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>	
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

 <%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	webbeans.eCA.CAOptions CaOptions = (webbeans.eCA.CAOptions)getObjectFromBean("CaOptions","webbeans.eCA.CAOptions",session);
%>
<html>
    <head>
        <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	    <script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


        <STYLE TYPE="text/css">
        A:link {
            COLOR: white;
        }

        A:visited {
            COLOR:white ;
        }
        A:active {
            COLOR: white;
        }
        </STYLE>

        <%
            String queryString = request.getQueryString()== null?"":request.getQueryString() ;
            String patient_id = request.getParameter("patient_id");
            String episode_id = request.getParameter("episode_id");
			//String episode_type= request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
			String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
			String child_window = request.getParameter("child_window") ;
            boolean pat_sel = false ;

            if( patient_id!=null || episode_id != null )
                pat_sel = true;

            String menu_pos = request.getParameter("menu_pos")==null?"V":request.getParameter("menu_pos");
        %>

        <script>
			var currClass = '';

            function display(from)
            {
                cellref = document.getElementById("tab").rows(0).cells
                 if("<%=menu_pos%>" == "V")
                    cellref = document.getElementById("tab").rows[0]

                for(i=0; i<cellref.length; i++)
                {
                    if("<%=menu_pos%>" == "H")
                       cellref[i].className = 'CASECONDSELECTHORZ'
                     else
                      cellref[i].cells[0].className = 'CASECONDSELECTVERT'
                }
                if("<%=menu_pos%>" == "H")
				{
                    from.className = "CATHIRDSELECTHORZ"
					currClass ="CATHIRDSELECTHORZ";
				}
                else
				{
                    from.className = "CATHIRDSELECTVERT"
					currClass ="CATHIRDSELECTVERT";
				}
            }

			function callOnMouseOver(obj)
            {
				currClass = obj.className ;
				 if("<%=menu_pos%>" == "H")
					obj.className = 'CATHIRDSELECTHORZ';
				 else
					obj.className = 'CATHIRDSELECTVERT';
            }

            function callOnMouseOut(obj)
            {
				obj.className = currClass;
            }

            function callNextLevel(option_type,executable_name, option_id,option_desc,menu_position)
            {
               if(top.content !=null)
                    top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
                else
                    top.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
				top.frames[1].frames[0].displayFunctionName(option_desc);//commontoolbar
                var params = "&<%=queryString%>"
                var oper = "&"
               if(executable_name.indexOf("?") == -1)
                    oper = "?"
                parent.Detail.location.href = executable_name+oper+"cname=CATHIRDWORKAREA&option_id="//+option_id+"&"+params
            }
        </script>
    </head>

    <body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
        <table id='tab' cellspacing=0 cellpadding='3' border='0'>
        <%
            String parent_option_id = request.getParameter("option_id");
            ArrayList thirdlevellist = CaOptions.getHeaders("3",parent_option_id) ;
            boolean bool  =false;
			boolean display = false;
			boolean first = true;
			String className = "";
			HashMap onthirdload = null;

            String cname = "CASECONDSELECTVERT";

            if(menu_pos.equals("H"))
            {
                out.println("<tr>");
                cname = "CASECONDSELECTHORZ";
             }

            for (int i=0; i<thirdlevellist.size(); i++)
            {
                if(menu_pos.equals("V"))
                    out.println("<tr>");
                HashMap thirdhash = ( HashMap ) thirdlevellist.get( i );
                String applicable_on_pat_yn = (String) thirdhash.get("APPLICABLE_ON_PAT_YN");
                String applicable_on_enc_yn = (String) thirdhash.get("APPLICABLE_ON_ENC_YN");
				//String applicable_category = (String) thirdhash.get("APPLICABLE_CATEGORY");
				display = false;

				if( (episode_id != null)&& (applicable_on_pat_yn.equals("Y") || applicable_on_enc_yn.equals("Y")) )
					bool = true;
				else
					if( (patient_id != null)&& applicable_on_pat_yn.equals("Y") )
						bool = true ;

				if(first)
				{
					if(menu_pos.equals("H"))
						className = "CATHIRDSELECTHORZ";
					else
						className = "CATHIRDSELECTVERT";
				}
				else
					className = cname;

				if(bool)
				{
					if(child_window.equals("N"))
						display = true;
					else
					{
						if(mode.equals("R"))
						{
							if(applicable_on_enc_yn.equals("Y"))
								display = true;
						}
						else
						{
							if(applicable_on_enc_yn.equals("N") && applicable_on_pat_yn.equals("Y"))
								display = true;
						}
					}
					if(display)
					{
						out.println("<td class='"+className+"' onMouseOver='callOnMouseOver(this);' onMouseOut='callOnMouseOut(this);' onclick='display(this)'><a href=\"javascript:callNextLevel('"+(String) thirdhash.get("OPTION_TYPE")+"','"+(String) thirdhash.get("EXECUTABLE_NAME")+"','"+(String) thirdhash.get("CA_OPTION_ID")+"','"+(String)thirdhash.get("FUNCTION_NAME")+"','"+(String)thirdhash.get("MENU_POSITION")+"')\">");
						out.println(thirdhash.get("OPTION_DESC"));
						out.println("</a></td>");
					}
				}
				else
				{
					if( applicable_on_pat_yn.equals("N") && applicable_on_enc_yn.equals("N") && !pat_sel)
					{
						out.println("<td class='"+className+"' onMouseOver='callOnMouseOver(this);' onMouseOut='callOnMouseOut(this);' onclick='display(this)' nowrap><a href=\"javascript:callNextLevel('"+(String) thirdhash.get("OPTION_TYPE")+"','"+(String) thirdhash.get("EXECUTABLE_NAME")+"','"+(String) thirdhash.get("CA_OPTION_ID")+"','"+(String)thirdhash.get("FUNCTION_NAME")+"','"+(String)thirdhash.get("MENU_POSITION")+"')\">");
						out.println(thirdhash.get("OPTION_DESC"));
						out.println("</a></td>");
					}
				}
				if(menu_pos.equals("V"))
					out.println("</tr>");

				first = false;
            }
            if(menu_pos.equals("H"))
                out.println("</tr>");

			 onthirdload = ( HashMap ) thirdlevellist.get( 0 );
			out.println("<script>callNextLevel('"+(String) onthirdload.get("OPTION_TYPE")+"','"+(String) onthirdload.get("EXECUTABLE_NAME")+"','"+(String) onthirdload.get("CA_OPTION_ID")+"','"+(String)onthirdload.get("FUNCTION_NAME")+"','"+(String)onthirdload.get("MENU_POSITION")+"')</script>");
        %>
        </table>
    </body>
</html>

