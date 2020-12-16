
/**
 * Write a description of class DinoDriver1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver1
{
    public static void main(String[] args)
    {
        Dinosaur d1 = new Dinosaur();
        Dinosaur d2 = new Dinosaur("TRex");
        //System.out.println(d2.toString());
        
        Dinosaur [] pop = new Dinosaur[10];
        for(int i = 0; i < pop.length; i++)//loop
        {
            pop[i] =  new Dinosaur("TRex");
            int rand = (int)(Math.random()*35);
             for( int j =0; j < rand; j++)
            {
                pop[i].ageUp();
            }
        }
        

        //Age up all dinosaurs to a random age between 0 and 35 
        
        for(int i = 0; i < pop.length; i++)
        System.out.println(pop[i]);
       
        //Dinosaur d2 = d2; are alliases
        //System.out.println(d1.equals(d2));
        //equals in object shows if they are in the same memory location 
  }
}
