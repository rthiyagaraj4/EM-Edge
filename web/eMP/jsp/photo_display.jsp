<!DOCTYPE html>
<%@ page session="true" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
    request.setCharacterEncoding("UTF-8");
%>

<script language="JavaScript">
    function showBlankImage() {
        document.patient_photo.src = "../../pat_photo/blank.gif"
    }
</script>
<%
    String patient_id = (String) session.getValue( "patient_id" ) ;
    if ( patient_id == null ) patient_id = " " ;

    String image = "../../pat_photo/" + patient_id ;

    out.println( "<img name='patient_photo' src='" + image + ".jpg' onError=\"showBlankImage();\">" ) ;
%>

