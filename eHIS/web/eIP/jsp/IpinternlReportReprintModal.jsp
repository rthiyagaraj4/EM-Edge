<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%   request.setCharacterEncoding("UTF-8"); %>
<html>
    <head>
        <script>
            async function showSearchVisit()
            {
                var dialogHeight= "35" ;
                var dialogWidth = "50" ;
                var dialogTop = "100";
                var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
                var arguments   = "" ;
                var encounterid = await window.showModalDialog("../../eIP/jsp/InpatientLookupCriteria.jsp",arguments,features);
                
                if(encounterid!=null)
                {
                    var encounterids= encounterid.split("|")
                    encounterid=encounterids[0]             
                
                    var dialogHeight= "25" ;
                    var dialogWidth = "45" ;
                    var dialogTop = "58";
                    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
                    var arguments   = "" ;
                    var val = await window.showModalDialog("../../eIP/jsp/IpinternlReportReprintFrame.jsp?encounterid="+encounterid+"&file_created_at_regn_yn=N",arguments,features);
                    if(val=="agn")
                        showSearchVisit()
                }
            }
            showSearchVisit()
        </script>
    </head>
    
    <body onLoad='' onKeyDown='lockKey()'>        
    </body>
<html>
