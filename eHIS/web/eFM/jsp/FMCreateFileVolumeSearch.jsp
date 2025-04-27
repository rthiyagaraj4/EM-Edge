<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMCreateFileVolume.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad='FocusFirstElement()' onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'> 
<form name='FMCreateFileVolumeSearchForm' id='FMCreateFileVolumeSearchForm'>
<table cellpadding='2' cellspacing='0' border='0' width='80%' align='center'>
<tr><td colspan='6' class='label'>&nbsp;</td></tr>
	<tr><td colspan='6'>
				<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name="frame_name" value="parent.createvolume_header"/>
				<jsp:param name="form_name" value="FMCreateFileVolumeSearchForm"/>
				<jsp:param name="messageframe_name" value="parent.messageFrame"/>
				<jsp:param name="patientid_name" value="patient_id"/>
				<jsp:param name="fileno_name" value="file_no"/>
				<jsp:param name="filetype_name" value="file_type_code"/>
				<jsp:param name="table_width" value="100"/>
				<jsp:param name="tablealign" value="center"/>
				<jsp:param name="volume_no_appl_yn" value="N"/>
				<jsp:param name="locn_code" value="f_curr_fs_locn"/>
			</jsp:include>
		</td>
	</tr>
	<tr>
		<td colspan='6' class='button' align="right"><input type='button' class='button' name='search_dtl' id='search_dtl' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='return fetchResults();'><input type='button' class='button' name='reset1' id='reset1' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='ClearAll()'></td>
		<input type='hidden' name='f_curr_fs_locn' id='f_curr_fs_locn' value=''>
	</tr>
</table>
</form>
</body>
</html>

