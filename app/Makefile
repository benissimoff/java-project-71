run-dist:
	./build/install/app/bin/app ./input/file1.json ./input/file2.json
test-json:
	./build/install/app/bin/app ./src/test/resources/file1.json ./src/test/resources/file2.json

test-yaml:
	./build/install/app/bin/app ./src/test/resources/file1.yaml ./src/test/resources/file2.yaml

build:
	./gradlew installDist --warning-mode all

check-style:
	./gradlew checkstyleMain

full-run: build run-dist

.PHONY: run-dist	build	full-run check-style	test-app