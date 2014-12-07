@ECHO OFF
SET /P device=enter your device ip:
@ECHO ON
adb tcpip 5555
adb connect %device%:5555
pause