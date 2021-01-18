package stickman.entity.moving.other;

import stickman.entity.Entity;
import stickman.entity.moving.MovingEntity;
import stickman.entity.moving.MovingObject;
import stickman.entity.moving.player.Controllable;

import java.util.List;

/**
 * Bullet object that the player can shoot to kill slimes.
 */
public class Bullet extends MovingObject implements Projectile {

    /**
     * The x-velocity of all bullets.
     */
    public static final double BULLET_SPEED = 2;

    /**
     * The width of all bullets. (Static to help testing)
     */
    public static final double BULLET_WIDTH = 10;

    /**
     * The height of all bullets. (Static to help testing)
     */
    public static final double BULLET_HEIGHT = 10;

    /**
     * Constructs a bullet object.
     *
     * @param x The x-coordinate
     * @param y The y-coordinate
     * @param left Whether the bullet is moving left or right
     */
    private Controllable hero;

    private boolean left;

    public Bullet(double x, double y, boolean left, Controllable hero) {
        super("bullet.png", x, y, BULLET_HEIGHT, BULLET_WIDTH, Layer.FOREGROUND);
        this.hero = hero;
        this.xVelocity = left ? -BULLET_SPEED : BULLET_SPEED;
        this.yVelocity = 0;
        this.left=left;
    }

    @Override
    public void movingCollision(List<MovingEntity> movingEntities) {
        for (MovingEntity movingEntity : movingEntities) {
            if (movingEntity != this) {
                if (this.checkCollide(movingEntity) && movingEntity.isActive()) {
                    movingEntity.die();
                    hero.addScore(100);
                    this.stop();
                    return;
                }
            }
        }
    }

    @Override
    public void tick(List<Entity> entities, double heroX, double floorHeight) {
        this.xPos += this.xVelocity;
        this.yPos += this.yVelocity;
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public Bullet clone() {
        return new Bullet(this.xPos,this.yPos,this.left,this.hero);
    }

    @Override
    public void stop() {
        this.active = false;
    }
}
