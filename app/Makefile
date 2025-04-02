run-dist:
	./build/install/app/bin/app ./input/file1.json ./input/file2.json

build:
	./gradlew installDist

check-style:
	./gradlew checkstyleMain

full-run: build run-dist

.PHONY: run-dist	build	full-run check-style