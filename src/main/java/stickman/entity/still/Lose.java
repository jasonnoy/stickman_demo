package stickman.entity.still;

import stickman.entity.Entity;
import stickman.entity.GameObject;

/**
 * The win message displayed after collecting the flag.
 */
public class Lose extends GameObject {

    /**
     * Constructs a new win object.
     * @param x The x-coordinate
     * @param y The y-coordinate
     */
    public Lose(double x, double y) {
        super("youlose.png", x, y, 400, 400, Layer.EFFECT);
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public Lose clone() {
        return null;
    }
}