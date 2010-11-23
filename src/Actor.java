import java.util.ArrayList;
import java.util.Random;

abstract class Actor {
	/**
	 * Common random number generator object
	 */
	static protected Random gen = new Random();

	/**
	 *  All the actors currently in play
	 */
	static public ArrayList<Actor> actors = new ArrayList<Actor>();

	
	// These fields are protected so that our descendants can modify them
	protected Vector position;
	protected Vector velocity;
	protected float theta; // Angular position
	protected float omega; // Angular velocity
	protected Sprite sprite; // This is the texture of this object
	protected float size; // the radius of the object

	/**
	 * Call back before render loop for update to update it's position and do any housekeeping
	 */
	 public void update() {
		 theta += omega;
		 position.incrementBy(velocity);
	 }
	 
	 /**
	  * CL - We need to synchronize removing actors so we don't have threads
	  *      stepping on eachother's toes.
	  *      
	  *      NOTE: thread concurrency is an advanced topic. This is a base
	  *      implementation to handle the problem.
	  */
	 protected void delete(){
		 synchronized (Actor.actors){
			 // FIXME causes an IndexOutOfBoundsException because this call
			 // is asynchronous and changes the array under other people's noses.
			 Actor.actors.remove(this);
		 }
	 }

	/**
	 * Call back upon collision detection for object to handle collision
	 * It could...
	 *   Bounce off
	 *   Explode into many smaller objects
	 *   Just explode
	 * @param other the object this actor collided with
	 */
	abstract public void handleCollision(Actor other);
	
	/**
	 * 
	 * @return the actors current position
	 */
	public Vector getPosition() {
		return position;
	}
	
	/**
	 * 
	 * @return the actors current velocity
	 */
	public Vector getVelocity(){
		return velocity;
	}
	
	/**
	 * 
	 * @return the actors current rotational position
	 */
	public float getTheta(){
		return theta;
	}
	
	/**
	 * 
	 * @return the actors current angular velocity
	 */
	public float getOmega() {
		return omega;
	}
	
	/**
	 * 
	 * @return the actors Sprite/Texture
	 */
	public Sprite getSprite(){
		return sprite;
	}
	
	/**
	 * 
	 * @return the actors size (for texture scaling and collision detection)
	 */
	public float getSize(){
		return size;
	}
}