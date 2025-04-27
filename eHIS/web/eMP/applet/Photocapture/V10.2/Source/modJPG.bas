Attribute VB_Name = "modJPG"
' Module1 (Module1.bas)
Option Explicit

Public Const WS_CHILD = &H40000000
Public Const WS_VISIBLE = &H10000000
Public Const SWP_NOMOVE = &H2
Public Const SWP_NOZORDER = &H4
Public Const HWND_BOTTOM = 1

Private Type BITMAPINFOHEADER
    biSize As Long
    biWidth As Long
    biHeight As Long
    biPlanes As Integer
    biBitCount As Integer
    biCompression As Long
    biSizeImage As Long
    biXPelsPerMeter As Long
    biYPelsPerMeter As Long
    biClrUsed As Long
    biClrImportant As Long
End Type
Declare Sub RtlMoveMemory Lib "kernel32" (ByVal hpvDest As Long, ByVal hpvSource As Long, ByVal cbCopy As Long)
Private Declare Function CreateCompatibleDC Lib "gdi32" (ByVal hdc As Long) As Long
Private Declare Function CreateDIBSection Lib "gdi32" (ByVal hdc As Long, pBitmapInfo As BITMAPINFOHEADER, ByVal un As Long, lplpVoid As Long, ByVal Handle As Long, ByVal dw As Long) As Long
Public Declare Function SelectObject Lib "gdi32" (ByVal hdc As Long, ByVal hObject As Long) As Long
Public Declare Function DeleteObject Lib "gdi32" (ByVal hObject As Long) As Long
Public Declare Function DeleteDC Lib "gdi32" (ByVal hdc As Long) As Long
Public Declare Sub CopyMemory Lib "kernel32" Alias "RtlMoveMemory" (lpvDest As Any, lpvSource As Any, ByVal cbCopy As Long)
Public Declare Function BitBlt Lib "gdi32" (ByVal hDestDC As Long, ByVal x As Long, ByVal y As Long, ByVal nWidth As Long, ByVal nHeight As Long, ByVal hSrcDC As Long, ByVal xSrc As Long, ByVal ySrc As Long, ByVal dwRop As Long) As Long
Public PadBytes As Long
Public BytesPerScanLine As Long
Public m_hDIb As Long, m_hBmpOld As Long
Public m_hDC As Long, DIBPtr As Long
Public picWidth As Long, picHeight As Long
Private Const BLOCK_SIZE = 10000


Global ConnectingString As String
Global photo_table As String
Global photo_table_pk As String
Global patient_table As String
Global photo_column As String
Global LocalPath As String
Global Patient_ID_Len As String
Global DebugFlag As Boolean
Global storeDBFlag As Boolean
Global patFolder As String

Global bStopped As Boolean

Public Sub SETBMI()
On Error GoTo exception_blk
Dim SBI As BITMAPINFOHEADER
   With SBI
      .biSize = 40
      .biWidth = picWidth
      .biHeight = picHeight
      .biPlanes = 1
      .biBitCount = 32 '24
      .biCompression = 0
      BytesPerScanLine = (((.biWidth * .biBitCount) + 31) \ 32) * 4
      PadBytes = BytesPerScanLine - (((.biWidth * .biBitCount) + 7) \ 8)
      .biSizeImage = BytesPerScanLine * Abs(.biHeight)
      .biXPelsPerMeter = 0
      .biYPelsPerMeter = 0
      .biClrUsed = 0
      .biClrImportant = 0
   End With
   m_hDC = CreateCompatibleDC(0)
   m_hDIb = CreateDIBSection(m_hDC, SBI, 0, DIBPtr, 0, 0)
   m_hBmpOld = SelectObject(m_hDC, m_hDIb)

resume_blk:
     Exit Sub

exception_blk:
    Writelog ("SETBMI:  " & err.Description)
    MsgBox "SETBMI: " & err.Description
    Resume resume_blk
End Sub
Public Sub SAVEJPEG(FSpec As String, ByVal TheQuality As Long, APIC As PictureBox)
On Error GoTo exception_blk
   ' Create DIB, get pointer & publics:-
    DoEvents
    APIC.Visible = False
    APIC.AutoRedraw = True
    APIC.AutoSize = True
    APIC.ScaleMode = vbPixels
    APIC.BorderStyle = 0 ' None
    picWidth = APIC.Width
    picHeight = APIC.Height
    'picWidth = 320
    'picHeight = 240
    DoEvents
   ' DIBPtr, m_hDC, m_hDIb, m_hBmpOld
   SETBMI
   ' Blit picture to DIB
   
   BitBlt m_hDC, 0, 0, picWidth, picHeight, APIC.hdc, 0, 0, vbSrcCopy
   DoEvents
   Dim pvGDI As GDIPlusJPGConvertor
   
   Set pvGDI = New GDIPlusJPGConvertor
   
   pvGDI.SaveDIB picWidth, picHeight, DIBPtr, FSpec$, TheQuality
 
   Set pvGDI = Nothing
   SelectObject m_hDC, m_hBmpOld
   DeleteObject m_hDIb
   DeleteDC m_hDC
   DoEvents
   'APIC.Visible = True

resume_blk:
     Exit Sub

exception_blk:
    Writelog ("SAVEJPEG:  " & err.Description)
    MsgBox "SAVEJPEG: " & err.Description
    Resume resume_blk
End Sub
Public Sub SaveToDB(FSpec As String, patID As String, Picture1 As PictureBox, Image1 As Image)
DebugLog ("Inside the Saving to Database SubRoutine.....")
On Error GoTo exception_blk
Dim conn As ADODB.Connection
Dim rs As ADODB.Recordset
Dim SQL1 As String, SQL2 As String, SQL3 As String, SQL4 As String
Dim file_num As String
Dim file_length As String
Dim bytes() As Byte
Dim num_blocks As Long
Dim left_over As Long
Dim block_num As Long
Dim count As String
DebugLog ("SaveToDB:1")
'SQL2 = "SELECT " & photo_column & "," & photo_table_pk & " FROM " & photo_table & " WHERE " & photo_table_pk & " ='" & patID & "'"
SQL2 = "SELECT patient_id, pat_photo_blob FROM mp_patient_photo WHERE patient_id = '" & patID & "'"
SQL3 = "select count(*) count from " & photo_table & " where " & photo_table_pk & " = '" & patID & "'"

Set conn = New ADODB.Connection
Set rs = New ADODB.Recordset
conn.Open ConnectingString
rs.Open SQL3, conn
count = rs!count

If (rs.State = 1) Then
    rs.Close
End If
DebugLog ("SaveToDB:2")
' STORING THE PHOTO TO THE LOCAL FILE SYSTEM
If (storeDBFlag = False) Then
DebugLog ("SaveToDB:2.1")
      Dim localfilepath As String
      Dim fs, obj
      Dim flag As Boolean
      Set fs = CreateObject("Scripting.FileSystemObject")
      flag = fs.FileExists(patFolder & "\" & patID & ".jpg")
      Picture1.Picture = Image1.Picture
      localfilepath = patFolder & "\" & patID & ".jpg"
      
      If (flag = True) Then
            Kill localfilepath
      End If
     
     SAVEJPEG localfilepath, 100, Picture1
      
     Exit Sub
End If

DebugLog ("SaveToDB:3:" & FSpec)
file_num = FreeFile
DebugLog ("SaveToDB:3.1:" & file_num)
Open FSpec For Binary Access Read As #file_num
DebugLog ("SaveToDB:3.2:" & SQL2)
file_length = LOF(file_num)
If file_length > 0 Then
    num_blocks = file_length / BLOCK_SIZE
    left_over = file_length Mod BLOCK_SIZE
    rs.CursorType = adOpenKeyset
    rs.LockType = adLockOptimistic
    rs.Open SQL2, conn
    If count = 0 Then
        rs.AddNew
    End If
 
 DebugLog ("SaveToDB:4:" & patID)
    rs!Patient_ID = patID
    ReDim bytes(BLOCK_SIZE)
    For block_num = 1 To num_blocks
        Get #file_num, , bytes()
        rs!pat_photo_blob.AppendChunk bytes()
    Next block_num
DebugLog ("SaveToDB:5")
    If left_over > 0 Then
        ReDim bytes(left_over)
        Get #file_num, , bytes()
        rs!pat_photo_blob.AppendChunk bytes()
    End If
DebugLog ("SaveToDB:6")
    rs.Update
    Close #file_num
End If
DebugLog ("SaveToDB:7")
resume_blk:
    Set rs = Nothing
    Set conn = Nothing
DebugLog ("SaveToDB:8")
    Exit Sub

exception_blk:
    Writelog ("SaveToDB:" & err.Description)
    MsgBox "SaveToDB:" & err.Description
    GoTo resume_blk
End Sub

Public Sub LoadFromDB(SeqNo As String, picPerson As Image, noImageLabel As Label)
On Error GoTo exception_blk

Dim conn As ADODB.Connection
Dim rs As ADODB.Recordset
Dim rsPatChk As ADODB.Recordset
Dim patChk As String
Dim bytes() As Byte
Dim file_name As String
Dim file_num As Integer
Dim file_length As Long
Dim num_blocks As Long
Dim left_over As Long
Dim block_num As Long
Dim hgt As Single
Dim fs, obj
Dim flag As Boolean
Set fs = CreateObject("Scripting.FileSystemObject")
Dim SQLCount As String

'LOADING THE PHOTO FROM THE LOCAL FILE SYSYTEM
If (storeDBFlag = False) Then
     flag = fs.FileExists(patFolder & "\" & SeqNo & ".jpg")
      If (flag = True) Then
                picPerson.Picture = LoadPicture(patFolder & "\" & SeqNo & ".jpg")
                noImageLabel.Visible = False
            Else
                noImageLabel.Visible = True
      End If
      Exit Sub
End If
    
picPerson.Visible = False
'Screen.MousePointer = vbHourglass
DoEvents
' Get the record.
 
Set conn = New ADODB.Connection

Call LoadConfiguration
          
    conn.Open ConnectingString
    
    SQLCount = "select count(*) count from " & photo_table & " WHERE " & photo_table_pk & "='" & SeqNo & "'"
    Set rsPatChk = conn.Execute(SQLCount)
    
    patChk = rsPatChk!count
      
    
    If (patChk = 0) Then
        DebugLog ("Record not existing in the photo table")
        noImageLabel.Visible = True
        'frmCapture.Image3.Picture = LoadPicture(LocalPath + "\PhotoNA.jpg")
        'frmCapture.Image3.Refresh
        'frmCapture.noImageLabel.Caption = "No image available"
      
        'frmCapture.patSeqNo.SetFocus
        Exit Sub
    Else
       noImageLabel.Visible = False
        'frmCapture.patSeqNo.Enabled = True
      
    
        Set rs = conn.Execute("SELECT * FROM " & photo_table & "  WHERE " & photo_table_pk & " = '" & SeqNo & "'")
             
        If rs.EOF Then Exit Sub
        ' Get a temporary file name.
        file_name = LocalPath & "\temp.jpg"
        ' Open the file.
        file_num = FreeFile
        Open file_name For Binary As #file_num

        ' Copy the data into the file.
        file_length = rs!pat_photo_blob.ActualSize
        num_blocks = file_length / BLOCK_SIZE
        left_over = file_length Mod BLOCK_SIZE
   
        '  bytes() = rs!pat_photo_blob.GetChunk(1024000)
        '  Put #file_num, , bytes()

        For block_num = 1 To num_blocks
            bytes() = rs!pat_photo_blob.GetChunk(BLOCK_SIZE)
            Put #file_num, , bytes()
        Next block_num
        
        If left_over > 0 Then
           On Error Resume Next
           
            bytes() = rs!pat_photo_blob.GetChunk(left_over)
             
            
            Put #file_num, , bytes()
            On Error Resume Next
           
        End If
    
        Close #file_num
        ' Display the picture file.
        ' MsgBox picPerson.Picture
        picPerson.Picture = LoadPicture(file_name)
        picPerson.Visible = True
       
        'Width = picPerson.Left + picPerson.Width + Width - ScaleWidth
        'hgt = picPerson.Top + picPerson.Height + Height - ScaleHeight
        'If hgt < 1440 Then hgt = 1440
        'Height = hgt
        DebugLog ("Loaded the image from the database")
        DebugLog ("Deleting the image from the local drive 'temp.jpg'")
        Kill file_name
        Screen.MousePointer = vbDefault
         
End If
resume_blk:
    Set rs = Nothing
    Set rsPatChk = Nothing
    Set conn = Nothing
    
    Exit Sub

exception_blk:
    MsgBox "LoadFromDB  :" & err.Description
    Writelog ("LoadFromDB:  " & err.Description)
    Resume resume_blk
End Sub
Public Function LoadConfiguration() As Boolean
    On Error GoTo exception_blk
    LoadConfiguration = True
    
    Dim flag As String
    Dim fs, obj
    Dim folderExists As Boolean
    Set fs = CreateObject("Scripting.FileSystemObject")
  
    DebugLog ("Loading the parameters from the .ini file")
    
    ConnectingString = GetSysIni("Settings", "ConnectString")
    photo_table = GetSysIni("Settings", "photo_table")
    patient_table = GetSysIni("Settings", "patient_table")
    photo_table_pk = GetSysIni("Settings", "photo_table_pk")
    photo_column = GetSysIni("Settings", "photo_column")
    LocalPath = GetSysIni("Settings", "LocalPath")
    Patient_ID_Len = GetSysIni("Settings", "Patient_ID_Len")
   
    flag = GetSysIni("Settings", "Debug")
     
    If (flag <> "true" And flag <> "false" And flag <> "True" And flag <> "False") Then
        MsgBox "Improper settings in configuration file.  Cannot proceed further.", vbOKOnly + vbCritical, "Photo Capture"
        LoadConfiguration = False
         Exit Function
         'End
    End If
    
    DebugFlag = GetSysIni("Settings", "Debug")
    flag = GetSysIni("Settings", "storetoDB")
    
    If (flag <> "true" And flag <> "false" And flag <> "True" And flag <> "False") Then
       MsgBox "Improper ini setting", vbOKOnly + vbCritical, "Photo Capture"
        'End
        LoadConfiguration = False
        Exit Function
       
    End If
    
    storeDBFlag = GetSysIni("Settings", "storetoDB")
    patFolder = GetSysIni("Settings", "patFolder")

    
    If (Patient_ID_Len = "unknown") Or (patFolder = "unknown") Or (LocalPath = "unknown") Then
           MsgBox "Improper ini setting", vbOKOnly + vbCritical, "Photo Capture"
            LoadConfiguration = False
            'End
            Exit Function
    End If

    folderExists = fs.folderExists(patFolder)

    If (folderExists = "False") Then
        MsgBox "Improper ini setting", vbOKOnly + vbCritical, "Photo Capture"
        LoadConfiguration = False
         
         Exit Function
        'End
    End If
    folderExists = fs.folderExists(LocalPath)

    If (folderExists = "False") Then
        MsgBox "Improper ini setting", vbOKOnly + vbCritical, "Photo Capture"
        'End
        LoadConfiguration = False
         Exit Function
    End If
    
  If (LoadConfiguration = False) Then
        MsgBox "Improper ini setting", vbOKOnly + vbCritical, "Photo Capture"
     End If
      
resume_blk:
    Exit Function
    
exception_blk:
    Writelog ("While Lodaing the Configuration file:  " & err.Description)
    MsgBox "While Lodaing the Configuration file: " & err.Description
    Resume resume_blk
    
End Function




'// Memory manipulation
'Declare Function lStrCpy Lib "kernel32" Alias "lstrcpyA" (ByVal lpString1 As Long, ByVal lpString2 As Long) As Long
'Declare Function lStrCpyn Lib "kernel32" Alias "lstrcpynA" (ByVal lpString1 As Any, ByVal lpString2 As Long, ByVal iMaxLength As Long) As Long
'Declare Sub hmemcpy Lib "kernel32" (hpvDest As Any, hpvSource As Any, ByVal cbCopy As Long)
    
'// Window manipulation
'Declare Function SetWindowPos Lib "user32" (ByVal hwnd As Long, ByVal hWndInsertAfter As Long, ByVal x As Long, ByVal y As Long, ByVal cx As Long, ByVal cy As Long, ByVal wFlags As Long) As Long
'Declare Function DestroyWindow Lib "user32" (ByVal hndw As Long) As Boolean

Function MyFrameCallback(ByVal lwnd As Long, ByVal lpVHdr As Long) As Long

    Debug.Print "FrameCallBack"
    
    Dim VideoHeader As VIDEOHDR
    Dim VideoData() As Byte
    
    '//Fill VideoHeader with data at lpVHdr
    RtlMoveMemory VarPtr(VideoHeader), lpVHdr, Len(VideoHeader)
    
    '// Make room for data
    ReDim VideoData(VideoHeader.dwBytesUsed)
    
    '//Copy data into the array
    RtlMoveMemory VarPtr(VideoData(0)), VideoHeader.lpData, VideoHeader.dwBytesUsed

    Debug.Print VideoHeader.dwBytesUsed
    
    
    Debug.Print VideoData
    
End Function

Function MyYieldCallback(lwnd As Long) As Long

    Debug.Print "Yield"

End Function


Function MyVideoStreamCallback(lwnd As Long, lpVHdr As Long) As Long

    Beep  '// Replace this with your code!
  
End Function







