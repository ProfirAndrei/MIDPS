#! /bin/bash

cd ./clone/HelloWorldPrograms

echo "<-----C program...----->"
gcc -o ./c/hello.exe ./c/hello.c
./c/hello.exe

echo "<-----Cpp program...----->"
g++ -o ./cpp/hello.exe ./cpp/hello.cpp
./cpp/hello.exe

echo "<-----Java program...----->"
javac ./java/hello.java
java -cp ./java HelloWorld

echo "<-----Python program...----->"
python ./python/hello.py

echo "<-----Ruby program...----->"
ruby ./ruby/hello.rb
