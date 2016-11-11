/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrint;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Vegar
 */
public class Map
{
    public char[][] map;

    public Map(int x, int y)
    {
        map=new char[x][y];
        
        // Start with fully empty map
        for (int n=0; n<x-1; n++)
        {
            for (int i=0; i<y-1; i++)
            {
                map[n][i]='e';
            }
        }
        
        generate (x,y);
    }
    
    
    public void generate(int x, int y)
    {
        
        divide(0,0,x-1,y-1);
        
    }
    public void divide(int minX, int minY, int maxX, int maxY)
    {
        
        // Division
        
        int xdiv=ThreadLocalRandom.current().
                nextInt(minX,((maxX+1)-1)/2)*2+1;
        if (xdiv%2==0 && maxX-xdiv>0)
            xdiv++;
        else if (xdiv%2==0 && xdiv-minX>0)
            xdiv--;
        
       /*int xdiv=ThreadLocalRandom.current().
                nextInt(minX,(maxX+1));
        if (xdiv%2==0 && maxX-xdiv>0)
            xdiv++;
        else if (xdiv%2==0 && xdiv-maxX>0)
            xdiv--;*/
        
        
        

        
        
        int ydiv=ThreadLocalRandom.current().
                nextInt(minY,((maxY+1)));
        if (ydiv%2==0 && maxY-ydiv>0)
            ydiv++;
        else if (ydiv%2==0 && ydiv-minY>0)
            ydiv--;
        
        System.out.println("xdiv:"+xdiv+"\tydiv:"+ydiv);
        
        
        
        System.out.println(xdiv+"\t"+ydiv);
        for (int n = minY; n <=maxY; n++)
        {
            map[xdiv][n]='w';
        }
        for (int n = minX; n <= maxX; n++)
        {
            map[n][ydiv]='w';
        }
        
        for (int n = 0; n<maxX; n++)
        {
            for (int i = 0 ; i<maxY; i++)
            {
                System.out.print(map[i][n]);
            }
            System.out.println("");
        }
        // Decide which wall not to open
        int exception = ThreadLocalRandom.current().
                nextInt(0,3+1);
        
        for (int n= 0; n<4; n++)
                if (n!=exception)
                {
                    
                }
        
        
        // Opening
        int _open = ThreadLocalRandom.current().nextInt(0, 3+1);
        for (int n=0; n<4; n++)
        {
            if (n!=_open)
            {
                switch (n)
                {
                    case 0:
                        // north
                        // (open)random num between minY and ydiv-1
                        open(xdiv, ThreadLocalRandom.current().nextInt(minY, ydiv) );
                        break;
                    case 1:
                        // east
                        // (open) random num between xdiv+1 and maxX
                        if (maxX-xdiv>0)
                        open (ThreadLocalRandom.current().nextInt(xdiv+1, maxX+1), ydiv);
                        break;
                    case 2:
                        // south
                        // (open) random num between ydiv+1 and maxY
                        if (maxY-ydiv>1)
                            open (xdiv, ThreadLocalRandom.current().nextInt(ydiv+1, maxY));
                        break;
                    case 3:
                        // west
                        // (open) random num between minX and xdiv-1
                        open (ThreadLocalRandom.current().nextInt(minX, xdiv) ,ydiv);
                        break;
                    
                }
                
                
               

            }
        }
        
        
         // West
                if (xdiv-1-minX > 2)
                {
                    // North
                    if (ydiv-1-minY >=2 && ydiv -minY > 1)
                    {
                        divide (minX, minY, xdiv-1, ydiv-1);
                    }
                    if (maxY-ydiv+1 > 2 && maxY-ydiv+1>1)
                    {
                        divide (minX, ydiv+1, xdiv-1, maxY);
                    }
                }
                // East
                if (maxX-xdiv+1 > 2)
                {
                    if (ydiv-1-minY >2)
                    {
                        //divide (xdiv+1, minY, maxX, ydiv-1);
                    }
                    if (maxY-ydiv+1 > 2)
                    {
                        //divide (xdiv+1, ydiv+1, maxX, maxY);
                    }
                }
        
        
        
        
    }
    
    public void open (int x, int y)
    {
        map[x][y]='e';
    }
    
}
