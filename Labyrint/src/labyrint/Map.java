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
        int xdiv=ThreadLocalRandom.current().
                nextInt(minX,((maxX+1)-1)/2)*2+1;
        if (xdiv%2==0 && maxX-xdiv>0)
            xdiv++;
        else if (xdiv%2==0 && xdiv-maxX>0)
            xdiv--;
        
        int ydiv=ThreadLocalRandom.current().
                nextInt(minY,((maxY+1)-1)/2)*1+1;
        
        System.out.println(xdiv+"\t"+ydiv);
        for (int n = minX; n <=maxX; n++)
        {
            map[xdiv][n]='w';
        }
        for (int n = minY; n <= maxY; n++)
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
        
        
        
    }
    
    public void open (int x, int y)
    {
        map[x][y]='e';
    }
    
}
