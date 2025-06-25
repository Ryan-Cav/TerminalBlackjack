#!/bin/bash


if javac -d target src/main/java/*.java; then
	java -cp target GameStart
fi
