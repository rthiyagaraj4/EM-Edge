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

<jsp:useBean id="keyGen" scope="page" class="eCA._ca_license_rights" />
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
            String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
            String episode_id = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
           // String episode_type= request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
            String menu_pos = request.getParameter("menu_pos")==null?"V":request.getParameter("menu_pos");
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
                 if("<%=menu_pos%>" == "V")
                    cellref = document.getElementById("tab").rows

                for(i=0; i<cellref .length; i++)
                {
                    if("<%=menu_pos%>" == "H")
                        cellref[i].className = 'CAFIRSTSELECTHORZ'
                     else
                      cellref[i].cells[0].className = 'CAFIRSTSELECTVERT'
                 }
                  if("<%=menu_pos%>" == "H")
                 {
                    from.className = "CASECONDSELECTHORZ"
                    currClass ="CASECONDSELECTHORZ";
                  }
                  else
                 {
                    from.className = "CASECONDSELECTVERT";
                    currClass ="CASECONDSELECTVERT";
                 }
            }

            function callOnMouseOver(obj)
            {
                currClass = obj.className ;
                 if("<%=menu_pos%>" == "H")
                    obj.className = 'CASECONDSELECTHORZ';
                 else
                    obj.className = 'CASECONDSELECTVERT';
            }

            function callOnMouseOut(obj)
            {
                obj.className = currClass;
            }

            function callNextLevel(option_type,executable_name, option_id,option_desc,menu_position)
            {
                //var params = "&patient_id=TN06500992&episode_id=50103511&visit_id=1&episode_type=O&location_code=CARD&location_type=C";
                //top.messageframe.location.href = '../../eCommon/jsp/error.jsp';

                if(top.content !=null)
                    top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
                else
                    top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
                var params = "&<%=queryString%>"
                if(option_type == 'M')
                {
                    //top.frames[1].displayFunctionName("")
                    if(top.content !=null)
	                    setTimeout("return top.content.CommonToolbar.displayFunctionName(\""+option_desc+"\");",750);
                     else
	                    setTimeout("return top.CommonToolbar.displayFunctionName(\""+option_desc+"\");",750);

                    //parent.thirdframe.location.href='CAThirdFrame.jsp?fname=CAOptions3.jsp&option_id=' +option_id+'&menu_pos='+menu_position+params+'&CA=Y'

					parent.Options3.location.href='../../eCA/jsp/CAMainOptions3.jsp?option_id=' +option_id+'&menu_pos='+menu_position+params+'&CA=Y';
                }
                else
                {
                    if(top.content !=null)
	                    setTimeout("return top.content.CommonToolbar.displayFunctionName(\""+option_desc+"\");",750);
                     else
	                    setTimeout("return top.CommonToolbar.displayFunctionName(\""+option_desc+"\");",750);

                    var oper = "&"
                    if(executable_name.indexOf("?") == -1)
                        oper = "?"
                   
					changeFramesOptions2();	parent.workAreaFrame.location.href=executable_name+oper+'cname=CASECONDWORKAREA&option_id='+option_id+params+'&CA=Y';
					//parent.thirdframe.location.href=executable_name+oper+'cname=CASECONDWORKAREA&option_id='+option_id+params+'&CA=Y'
                }
            }
        </script>
    </head>

    <body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
        <table id='tab' cellspacing=0 cellpadding='3' border='0'>
        <%
			//out.println("CaOptions==========="+CaOptions);
            String parent_option_id = request.getParameter("option_id");
            ArrayList secondlevellist = CaOptions.getSubHeaders("2",parent_option_id,patient_id,episode_id) ;
			//out.println(secondlevellist);
			//out.println(parent_option_id);
            String cname = "CAFIRSTSELECTVERT";

            if(menu_pos.equals("H"))
            {
                out.println("<tr>");
                cname = "CAFIRSTSELECTHORZ";
             }
            boolean bool  =false;
            boolean display = false;
            boolean first = true;
            String className = "";
            HashMap onsecondload = null;

            for (int i=0; i<secondlevellist.size(); i++)
            {
               if(menu_pos.equals("V"))
                    out.println("<tr>");
                HashMap secondhash = ( HashMap ) secondlevellist.get( i );
                String applicable_on_pat_yn = (String) secondhash.get("APPLICABLE_ON_PAT_YN");
                String applicable_on_enc_yn = (String) secondhash.get("APPLICABLE_ON_ENC_YN");
                //String applicable_category = (String) secondhash.get("APPLICABLE_CATEGORY");
                display = false;

                if( (!episode_id.equals(""))&& (applicable_on_pat_yn.equals("Y") || applicable_on_enc_yn.equals("Y")) )
                    bool = true;
                else
                    if( (!patient_id.equals(""))&& applicable_on_pat_yn.equals("Y") )
                        bool = true ;

                if(first)
                {
                    onsecondload = (HashMap) secondlevellist.get( 0 );
                    if(menu_pos.equals("H"))
                        className = "CASECONDSELECTHORZ";
                    else
                        className = "CASECONDSELECTVERT";
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
						 	out.println("<td nowrap class='"+className+"' onMouseOver='callOnMouseOver(this);' onMouseOut='callOnMouseOut(this);' onclick='display(this)'><a href=\"javascript:callNextLevel('"+(String) secondhash.get("OPTION_TYPE")+"','"+(String) secondhash.get("EXECUTABLE_NAME")+"','"+(String) secondhash.get("CA_OPTION_ID")+"','"+(String)secondhash.get("FUNCTION_NAME")+"','"+(String)secondhash.get("MENU_POSITION")+"')\">");
                        	out.println(secondhash.get("OPTION_DESC"));
                        	out.println("</a></td>");
				    }
                }
                else
                {
	                if( applicable_on_pat_yn.equals("N") && applicable_on_enc_yn.equals("N") && !pat_sel )
                    {
						if(child_window.equals("N")  && ((eCA._ca_license_rights.getKey()).equals("CACLDC")  || (eCA._ca_license_rights.getKey()).equals("CABASIC")))  // CA Clinical Documentation
							display = true;
						else if ((eCA._ca_license_rights.getKey()).equals("CAMINI") )  // CA Consultation
							display = true;
						if(display)
						{
                        	out.println("<td nowrap class='"+className+"' onMouseOver='callOnMouseOver(this);' onMouseOut='callOnMouseOut(this);' onclick='display(this)' nowrap><a href=\"javascript:callNextLevel('"+(String) secondhash.get("OPTION_TYPE")+"','"+(String) secondhash.get("EXECUTABLE_NAME")+"','"+(String) secondhash.get("CA_OPTION_ID")+"','"+(String)secondhash.get("FUNCTION_NAME")+"','"+(String)secondhash.get("MENU_POSITION")+"')\">");
                        	out.println(secondhash.get("OPTION_DESC"));
                        	out.println("</a></td>");
						}
                    }
                }

               if(menu_pos.equals("V"))
                    out.println("</tr>");

               first = false;
            }
             if(menu_pos.equals("H"))
                out.println("</tr>");

            // Enhancements
           	/*if (child_window.equals("N") && (eCA._ca_license_rights.getKey()).equals("CAMINI") )  // CA Consultation
			{
				out.println("<tr><td width='100%' class='DATA' COLSPAN='"+secondlevellist.size()+"')\">");
			   	out.println("Patient List ");
               	out.println("</td></tr>");
			}*/
			if(onsecondload!=null)
            out.println("<script>callNextLevel('"+(String) onsecondload.get("OPTION_TYPE")+"','"+(String) onsecondload.get("EXECUTABLE_NAME")+"','"+(String) onsecondload.get("CA_OPTION_ID")+"','"+(String)onsecondload.get("FUNCTION_NAME")+"','"+(String)onsecondload.get("MENU_POSITION")+"')</script>");
        %>
        </table>
    </body>
</html>

