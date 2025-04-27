Attribute VB_Name = "modGeneral"
 'Public Declare Function SendMessage Lib "user32" Alias "SendMessageA" (ByVal hwnd As Long, ByVal wMsg As Long, ByVal wParam As Long, lParam As Any) As Long
 'Public Declare Function capCreateCaptureWindowA Lib "avicap32.dll" (ByVal lpszWindowName As String, ByVal dwStyle As Long, ByVal x As Long, ByVal y As Long, ByVal nWidth As Long, ByVal nHeight As Long, ByVal hWndParent As Long, ByVal nID As Long) As Long
     
    Public Const WM_USER As Long = 1024
    
    Public Const WM_CAP_CONNECT As Long = 1034
    Public Const WM_CAP_DISCONNECT As Long = 1035
    Public Const WM_CAP_GET_FRAME As Long = 1084
    Public Const WM_CAP_COPY As Long = 1054
    
    Public Const WM_CAP_START As Long = WM_USER
    
    Public Const WM_CAP_DLG_VIDEOFORMAT As Long = WM_CAP_START + 41
    Public Const WM_CAP_DLG_VIDEOSOURCE As Long = WM_CAP_START + 42
    Public Const WM_CAP_DLG_VIDEODISPLAY As Long = WM_CAP_START + 43
    Public Const WM_CAP_GET_VIDEOFORMAT As Long = WM_CAP_START + 44
    Public Const WM_CAP_SET_VIDEOFORMAT As Long = WM_CAP_START + 45
    Public Const WM_CAP_DLG_VIDEOCOMPRESSION As Long = WM_CAP_START + 46
    Public Const WM_CAP_SET_PREVIEW As Long = WM_CAP_START + 50
 
Declare Function GetPrivateProfileString Lib "kernel32" Alias "GetPrivateProfileStringA" (ByVal lpApplicationName As String, ByVal lpKeyName As Any, ByVal lpDefault As String, ByVal lpReturnedString As String, ByVal nSize As Long, ByVal lpFileName As String) As Long
Public Type NOTIFYICONDATA
       cbSize As Long
       hwnd As Long
       uId As Long
       uFlags As Long
       uCallBackMessage As Long
       hIcon As Long
       szTip As String * 64
End Type

'constants required by Shell_NotifyIcon API call:
Public Const NIM_ADD = &H0
Public Const NIM_MODIFY = &H1
Public Const NIM_DELETE = &H2
Public Const NIF_MESSAGE = &H1
Public Const NIF_ICON = &H2
Public Const NIF_TIP = &H4
Public Const WM_MOUSEMOVE = &H200
Public Const WM_LBUTTONDOWN = &H201     'Button down
Public Const WM_LBUTTONUP = &H202       'Button up
Public Const WM_LBUTTONDBLCLK = &H203   'Double-click
Public Const WM_RBUTTONDOWN = &H204     'Button down
Public Const WM_RBUTTONUP = &H205       'Button up
Public Const WM_RBUTTONDBLCLK = &H206   'Double-click

Public Declare Function SetForegroundWindow Lib "user32" _
      (ByVal hwnd As Long) As Long

Public Declare Function Shell_NotifyIcon Lib "shell32" _
      Alias "Shell_NotifyIconA" _
      (ByVal dwMessage As Long, pnid As NOTIFYICONDATA) As Boolean

Public nID As NOTIFYICONDATA

Function GetSysIni(section As String, key As String) As String
Dim retVal As String, AppName As String, worked As Integer
    retVal = String$(255, 0)
    worked = GetPrivateProfileString(section, key, "", retVal, Len(retVal), "IBAPhotoCap.ini")
    If worked = 0 Then
        GetSysIni = "unknown"
    Else
        GetSysIni = Left(retVal, worked)
    End If
End Function

Sub DebugLog(Msg As String)
If DebugFlag = True Then
    Writelog "DEBUG >  " & Msg
End If
End Sub

Sub ErrorLog(Msg As String)
    Writelog "ERROR > " & Msg
End Sub
Sub Writelog(err As String)
    Dim filenim
    filenum = FreeFile
    Open LocalPath & "\IBAPhotoCap.log" For Append As #filenum
    'MsgBox LocalPath & "\MedPhotoCap.log"
    Print #filenum, Format(Now, "dd-mmm-yyyy    hh:mm AM/PM  ") & " : " & err
    Close #filenum

End Sub
Public Sub StopWork()
DebugLog "Inside StopWork()"
    On Error Resume Next
    ' stop the timer
    bStopped = True
    DebugLog "bStopped=" & bStopped
    Timer1.Enabled = False
    ' disconnect from the video source
    DoEvents
    If mCapHwnd <> 0 Then Call SendMessage(mCapHwnd, WM_CAP_DISCONNECT, 0, 0)
    mCapHwnd = 0
    'MsgBox "Terminating Capture"
DebugLog "mCapHwnd=" & mCapHwnd
End Sub
