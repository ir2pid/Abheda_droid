@ECHO OFF
SET /P device=enter your device ip:

adb -s %device%:5555

adb kill-server
adb start-server
adb devices