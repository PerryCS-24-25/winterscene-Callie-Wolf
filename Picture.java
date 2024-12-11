
import javax.swing.Timer;

/**
 * Draw a pretty picture composed of shape objects on a canvas
 * 
 * @author: (Callie Khor)
 * @version: (12/11/24)
 * 
 */
public class Picture
{
    // Private member (instance) variables
    private Canvas pic;
    //private Circle ball; // The sample ball to animate
    //private int dx = 5; // Speed in x direction for the sample ball
   // private int dy = -5; // Speed in y direction for the sample ball
    private Circle[] storm;
    
    
    public Picture()
    {
        // Get a reference to the canvas for this drawing and set its title.
        pic = Canvas.getCanvas();
        pic.setTitle("Shed in Blizzard");
        pic.setBackgroundColor("#D9DDDC");
        
        // Turn off automatic redrawing
        pic.pause(true);
        
       storm= new Circle [400];
       for(int i=0; i<storm.length; i++)
       {

             int y=0;
             int randomX= (int)(Math.random()*800)+0;
             
             int randomY= (int)(Math.random()*600)+0;
        
            storm[i]= new Circle(randomX, randomY, 10, "#FAF9F6",true);
        

            
       }



        
        // Show the initial picture
        pic.redraw();
    }
    
    /**
     * Update the screen to create a new frame for the animation
     */
    public void update() 
    {
       
        
        for(int i=0; i<storm.length; i++)
        {
            int stormer= (int)(Math.random()*50)+0;
            storm[i].setX(storm[i].getX() + stormer);
            storm[i].setY(storm[i].getY() + stormer);

            int valuex= storm[i].setX(storm[i].getX() + stormer);
            int value y=storm[i].setY(storm[i].getY() + stormer);

            if(storm[i]>800 || storm[i]>600)
            {

            }
            
        }
        
 
        
        // Update the screen
        pic.redraw();
    }
    
    /**
     * This main method prepares and regularly updates a picture.
     */
    public static void main(String[] args)
    {
        Picture pic = new Picture();
        
        // update the screen every 33ms (30 times / second)
        new Timer(33, e->pic.update()).start();        
    }
   
}