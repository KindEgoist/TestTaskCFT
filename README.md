## Утилита фильтрации содержимого файлов.

### Ключи задаются при запуске программы в командной строке командной строки:
1. по __*default*__ результат сохраняются в той же папке где были исходники. С ключом `-o` задается путь к результатам;
2. имена файлов по __*default:*__ `integers.txt`, `floats.txt`, `strings.txt`. Ключ `-p` задает префикс к именам 
выходных файлов;
3. по __*default*__ файлы результатов перезаписываются. Ключ `-a` задает режим добавления в существующие файлы;
4. ключи `-s`(__*default*__) и `-f`. Выводят статистику по результату(краткая и полная).

#### Правила запуска программы:
1. путь должен быть нижнего регистра. Пример: __\path\result__ ;
2. на ввод должен подаваться хоть один файл;
3. входные файлы принимаются только с расширением __\*.txt__ ;
4. передаваемые параметры в командной строке должно быть как минимум __два__ ;

Примеры запуска из командной строки для Windows(через IntelliJ IDEA):
* `-s in1.txt` (краткая статистика и один входной файл)
* `-s -p result_ in1.txt in1.txt` (краткая статистика, добавлен прификс и два раза один и тот же файл на входе)
* `-a -f -p result_ in2.txt` (полная статистика, файлы с результатом не перезаписываются(данные дополняются к 
существующем если файлы уже были созданные), присутствует префикс и один входной файл)
* `-o \final\result\files -f in2.txt in1.txt in3.txt` (полная статистика, три входных файла, результат сохраняется
изначальный путь файлов + указанный (\final\result\files))

#### В проекте использовалось:
* стандартная система сборки проекта Maven
* Версия Java 22.0.1# 
