<!DOCTYPE html>
<HTML>
<HEAD>
<TITLE>Disp Queue Medication Frameset</TITLE>
</HEAD>

<!-- <FRAMESET cols="20%,*" name="DispMedicationDetailFrameSet"id="DispMedicationDetailFrameSet" frameborder="0">
	<FRAMESET COLS="100%,0%" name="DispMedicationDetailSubFrameSet_1" id="DispMedicationDetailSubFrameSet_1" frameborder="0">
	<FRAME SRC="../../eCommon/html/blank.html" name="DispMedicationPatFrame" id="DispMedicationPatFrame"></FRAME>	 
	<FRAME SRC="../../eCommon/html/blank.html"  name="DispMedicationPatDetFrame_1"id="DispMedicationPatDetFrame_1"></FRAME>
	</FRAMESET>
	<FRAMESET rows="20%,80%" name="DispMedicationDetailSubFrameSet_2"id="DispMedicationDetailSubFrameSet_2" frameborder="0">
	<FRAME SRC="../../eCommon/html/blank.html" name="DispMedicationPatDetFrame_2" id="DispMedicationPatDetFrame_2"></FRAME>	
	<FRAME SRC="../../eCommon/html/blank.html"  name="DispMedicationPatDetFrame_3"id="DispMedicationPatDetFrame_3"></FRAME>
	</FRAMESET>
</FRAMESET> -->
<body style="margin:2px;">
<div  name="DispMedicationDetailFrameSet"id="DispMedicationDetailFrameSet" style="display:flex; flex-direction: column" > 
    <div name="DispMedicationDetailSubFrameSet_1" id="DispMedicationDetailSubFrameSet_1" style="display:flex; flex-direction: column; height:30vh;">
    	<iframe SRC="../../eCommon/html/blank.html" name="DispMedicationPatFrame" id="DispMedicationPatFrame" style="height: 37vh; width: 99vw;"></iframe> 
		<iframe SRC="../../eCommon/html/blank.html"  name="DispMedicationPatDetFrame_1"id="DispMedicationPatDetFrame_1" style="height: 37vh; width: 64vw; display:none"></iframe>
    </div>
    <div name="DispMedicationDetailSubFrameSet_2"id="DispMedicationDetailSubFrameSet_2" style="display:none; flex-direction: row; height:65vh;">
    	<iframe SRC="../../eCommon/html/blank.html" name="DispMedicationPatDetFrame_2" id="DispMedicationPatDetFrame_2" style="height: 90vh; width: 20vw;"></iframe>
		<iframe SRC="../../eCommon/html/blank.html"  name="DispMedicationPatDetFrame_3"id="DispMedicationPatDetFrame_3"style="height: 90vh; width: 70vw;"></iframe>
    </div>
</div>
</body>



</HTML>
