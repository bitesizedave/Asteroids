/**
 * Author: Chris Lundquist
 * Description: Lets the player shoot 3 (smaller) bullets at once more slowly
 */
public class TripleShotWeapon extends Weapon{
	private static final float TRIPLE_BULLET_SIZE = 0.03f;
	private static final int SHOOT_DELAY = 30; // 30 frame delay between shots
	private static final float TRIPLE_SHOT_SPREAD = 0.5f;
	
	TripleShotWeapon(Actor owner) {
		super(owner);
	}

	@Override
	void shoot() {
		if (shootDelay > 0)
			return;
		
		/* Loop from -1 to 1 so we can shoot at angles to both sides of forward */
		for(int i = -1; i < 2; i++)
			Actor.actors.add(new Bullet(owner, i * TRIPLE_SHOT_SPREAD).setSize(TRIPLE_BULLET_SIZE));

		/* Expanded form of the Loop above
		Bullet bullet1 = new Bullet(owner, -1.0f);
		bullet1.size = TRIPLE_BULLET_SIZE;
		Bullet bullet2 = new Bullet(owner);
		bullet2.size = TRIPLE_BULLET_SIZE;
		Bullet bullet3 = new Bullet(owner, 1.0f);
		bullet3.size = TRIPLE_BULLET_SIZE;
		
		Actor.actors.add(bullet1);
		Actor.actors.add(bullet2);
		Actor.actors.add(bullet3);
		 */

		// Play our awesome explosion if sound is enabled
		if(SoundEffect.isEnabled())
			SoundEffect.forBulletShot().play();



		/* reset our shoot delay */
		shootDelay = SHOOT_DELAY;
	}
}
