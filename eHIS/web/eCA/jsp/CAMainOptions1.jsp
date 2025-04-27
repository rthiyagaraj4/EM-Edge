<!DOCTYPE html>
<%@ page import=" java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0038
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


		try
		{

			String queryString = request.getQueryString()== null?"":request.getQueryString() ;
            String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
            String episode_id = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
            
            String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
            String child_window = request.getParameter("child_window") ;
            boolean pat_sel = false ;

			if( !patient_id.equals("") || !episode_id.equals("") )
                pat_sel = true;
        %>

         <script>
             var currClass = '';

            function display(from)
            {
                cellref = document.getElementById("tab").rows(0).cells
                for(i=0; i<cellref.length; i++)
                {
                    cellref[i].className = 'CAFIRSTNOSELECT'
                }
                from.className = "CAFIRSTSELECTHORZ"
                currClass ="CAFIRSTSELECTHORZ";
            }

            function callOnMouseOver(obj)
            {
                currClass = obj.className ;
                obj.className = 'CAFIRSTSELECTHORZ';
            }

            function callOnMouseOut(obj)
            {
                obj.className = currClass;
            }

            function callNextLevel(option_type,executable_name, option_id, option_desc,menu_position)
            {
                var params = "&<%=queryString%>";

                if(top.content !=null)
                    top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
                else
                    setTimeout("top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp';",750);
                if(option_type == 'M')
                {
                    if(top.content !=null)
	                    setTimeout("return top.content.CommonToolbar.displayFunctionName(\""+option_desc+"\");",750);
                     else
	                    setTimeout("return top.CommonToolbar.displayFunctionName(\""+option_desc+"\");",750);

				
					parent.Options2.location.href='../../eCA/jsp/CAMainOptions2.jsp?option_id='+option_id+'&menu_pos='+menu_position+params
                   
                }
                else
                {
                    setTimeout("return top.content.CommonToolbar.displayFunctionName(\""+option_desc+"\");",750);
                    var oper = "&"
                    if(executable_name.indexOf("?") == -1)
                        oper = "?"
                    var url = executable_name+oper+'cname=CAFIRSTWORKAREA&option_id='+option_id+params
					changeFramesOptions1();
                    setTimeout("return displayScreen(\""+url+"\");",750);
                    //parent.secondframe.className="CAFIRSTWORKAREA";
                }
            }

            function displayScreen(url)
            {
                //parent.secondframe.location.href    =   url;
				parent.workAreaFrame.location.href    =   url;
            }

        </script>
    </head>

    <body  class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
        <table id='tab' cellspacing=0 cellpadding='3' border='0'>

        <%
			ArrayList firstlevellist = CaOptions.getHeaders(patient_id,episode_id) ;
			
            boolean bool  =false;
            boolean display = false;
            boolean first = true;
            boolean first1 = true;
            String className = "";
            int level = 0;
            HashMap onfirstload = null;
            out.println("<tr>");



            for (int i=0; i<firstlevellist.size(); i++)
            {

                HashMap firsthash = ( HashMap ) firstlevellist.get( i );
				String applicable_on_pat_yn = (String) firsthash.get("APPLICABLE_ON_PAT_YN");
                String applicable_on_enc_yn = (String) firsthash.get("APPLICABLE_ON_ENC_YN");
                display = false;
            
                if( (!episode_id.equals(""))&& (applicable_on_pat_yn.equals("Y") || applicable_on_enc_yn.equals("Y")) )
                    bool = true;
                else
                    if( (!patient_id.equals(""))&& applicable_on_pat_yn.equals("Y") )
                        bool = true ;

                if(first)
                {
                    className = "CAFIRSTSELECTHORZ";
                    onfirstload = ( HashMap ) firstlevellist.get( level );
                }
                else
                    className = "CAFIRSTNOSELECT";
				 
                if(bool)
                {
                    if(first1)
                    {
                        level = i;
                        className = "CAFIRSTSELECTHORZ";
                        onfirstload = ( HashMap ) firstlevellist.get( level );
                    }

                    if(child_window.equals("N") )
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
						out.println("<td class='"+className+"' onMouseOver='callOnMouseOver(this);' onMouseOut='callOnMouseOut(this);' onclick='display(this)' nowrap><a href=\"javascript:callNextLevel('"+(String) firsthash.get("OPTION_TYPE")+"','"+(String) firsthash.get("EXECUTABLE_NAME")+"','"+(String) firsthash.get("CA_OPTION_ID")+"','"+(String)firsthash.get("FUNCTION_NAME")+"','"+(String)firsthash.get("MENU_POSITION")+"')\">");
                        out.println(firsthash.get("OPTION_DESC"));
                        out.println("</a></td>");
                        first1 = false;
                    }
                }
                else
                {
                    if( applicable_on_pat_yn.equals("N") && applicable_on_enc_yn.equals("N") && !pat_sel )
                    {
							out.println("<td class='"+className+"' onMouseOver='callOnMouseOver(this);' onMouseOut='callOnMouseOut(this);'  onclick='display(this)'  nowrap><a href=\"javascript:callNextLevel('"+(String) firsthash.get("OPTION_TYPE")+"','"+(String) firsthash.get("EXECUTABLE_NAME")+"','"+(String) firsthash.get("CA_OPTION_ID")+"','"+(String)firsthash.get("FUNCTION_NAME")+"','"+(String)firsthash.get("MENU_POSITION")+"')\">");
                        	out.println(firsthash.get("OPTION_DESC"));
                        	out.println("</a></td>");
					}
                }
                first = false;
            }

            out.println("</tr>");
			if(onfirstload != null){
				out.println("<script>callNextLevel('"+(String) onfirstload.get("OPTION_TYPE")+"','"+(String) onfirstload.get("EXECUTABLE_NAME")+"','"+(String) onfirstload.get("CA_OPTION_ID")+"','"+(String)onfirstload.get("FUNCTION_NAME")+"','"+(String)onfirstload.get("MENU_POSITION")+"')</script>");
			}
	} 
	catch (Exception e) {
		//out.println(e+" here");//COMMON-ICN-0181
		e.printStackTrace();
	}
        %>
        </table>
    </body>
</html>

