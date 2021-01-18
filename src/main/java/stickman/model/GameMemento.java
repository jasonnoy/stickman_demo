package stickman.model;

import stickman.level.Level;

import java.util.List;

public class GameMemento {
    private int currentLevelIndex;
    private Level level;
    private List<String> levelFileNames;

    public GameMemento(int levelIndex,Level level,List<String> levelFileNames){
        this.currentLevelIndex=levelIndex;
        this.level=level;
        this.levelFileNames=levelFileNames;
    }

    public int getCurrentLevelIndex(){
        return currentLevelIndex;
    }

    public Level getLevel() {
        return level;
    }

    public List<String> getLevelFileNames() {
        return levelFileNames;
    }
}
