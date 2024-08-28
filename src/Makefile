OS := $(shell uname -s 2>/dev/null || echo Windows)

# Variables
SRC = dungeonfighter/DungeonFighter.java
BIN_DIR = bin
ASSETS_SRC = dungeonfighter/assets
ASSETS_DST = assets

# Commands
JAVAC = javac
JAVA = java

# Windows specific commands
ifeq ($(OS), Windows)
    COPY_CMD = xcopy /E /I /Y $(ASSETS_SRC) $(ASSETS_DST)
    RM = rmdir /S /Q $(BIN_DIR) $(ASSETS_DST)
    MKDIR = if not exist $(BIN_DIR) mkdir $(BIN_DIR)
else
    COPY_CMD = cp -r $(ASSETS_SRC) .
    RM = rm -rf $(BIN_DIR) $(ASSETS_DST)
    MKDIR = mkdir -p $(BIN_DIR)
endif

all: $(BIN_DIR)
	$(JAVAC) $(SRC) -d $(BIN_DIR)
	$(COPY_CMD)
	$(JAVA) -cp $(BIN_DIR) dungeonfighter.DungeonFighter

run:
	$(JAVA) -cp $(BIN_DIR) dungeonfighter.DungeonFighter

$(BIN_DIR):
	$(MKDIR)

clean:
	$(RM)
