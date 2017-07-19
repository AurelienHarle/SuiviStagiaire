@echo off
setlocal enableDelayedExpansion 
REM @Author Aurélien Harlé
REM @Version 1
REM @Since 06-06-2017
REM @Description Programme qui sauvegarde le projet en cour tout les jours a XX heure.

REM Couleur officiel des batch d'Aurélien Harlé
color 02

REM Sauvegarde du projet

REM Creation d'une copie pour sauvegarde
robocopy "D:\Projet\Suivi Stagiaire" "E:\Save\Projet\%date:~0,2%-%date:~3,2%-%date:~6,4%" /E 

REM récuperation de l'heure et des minutes
set /a heure = %time:~0,2%
set /a minute = %time:~3,2%

REM Compression en zip de 25 mo
REM 7z u -tzip -v25m "E:\Save\Projet\%date:~0,2%-%date:~3,2%-%date:~6,4%\save\%heure%-%minute%\%date:~0,2%-%date:~3,2%-%date:~6,4%.zip" "E:\Save\Projet\%date:~0,2%-%date:~3,2%-%date:~6,4%"

REM Compression en fichier zip
7z a -tzip "E:\Save\Projet\%date:~0,2%-%date:~3,2%-%date:~6,4%\%date:~0,2%-%date:~3,2%-%date:~6,4%.zip" "E:\Save\Projet\%date:~0,2%-%date:~3,2%-%date:~6,4%"

REM Supprime les fichier vieux de plus d'une semaine (5 jour ouvrés)
REM forfiles /p "E:\Save\Projet\" /S /D -5

REM rmdir /s /q "D:\Projet\Suivi stagiaire\Git\SuiviStagiaire\save\"
REM copy  /Y "E:\Save\Projet\%date:~0,2%-%date:~3,2%-%date:~6,4%\save\%heure%-%minute%\%date:~0,2%-%date:~3,2%-%date:~6,4%.zip.*" "D:\Projet\Suivi stagiaire\Git\SuiviStagiaire\save\"
REM git commit git push



pause