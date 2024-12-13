
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
    private Triangle[] lights;
    
    
    public Picture()
    {
        // Get a reference to the canvas for this drawing and set its title.
        pic = Canvas.getCanvas();
        pic.setTitle("Shed in Blizzard");
        pic.setBackgroundColor("#D9DDDC");
        
        // Turn off automatic redrawing
        pic.pause(true);

        Rect shed= new Rect(0, 450, 200, 150,"#C23B22", true);
        Rect roof= new Rect(0, 450, 200, 30, "#c4a484", true);
        Triangle tree= new Triangle(400,150, 300, 450, "#acd8a7",true);
       
        storm= new Circle [400];
       for(int i=0; i<storm.length; i++)
       {

             //int y=0;
             int randomX= (int)(Math.random()*800)+0;
             
             int randomY= (int)(Math.random()*600)+0;
        
            storm[i]= new Circle(randomX, randomY, 10, "#FAF9F6",true);
        

           
       }

         lights= new Triangle [50];
       for(int i=0; i<lights.length; i++)
       {

             //int y=0;
             int randomX= (int)(Math.random()*260)+260;
             
             int randomY= (int)(Math.random()*400)+200;
        
            lights [i]= new Triangle (randomX, randomY, 10, 20, "#87CEEB",true);
        

            
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
            int xS= storm[i].getX();
            int yS= storm[i].getY();

            int numx= (int)(Math.random()*800)+0;

           

            if(xS>=800 || yS>=600)
            {
                storm[i].setX(numx);
                storm[i].setY(0);
            }
            
        }
        
        for(int i=0; i<lights.length; i++)
        {
            String color= "#ADD8E6"
            lights[i].changeColor("#ADD8E6");
            lights[i].sleep(1000);
            lights[i].changeColor("#87CEEB");
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