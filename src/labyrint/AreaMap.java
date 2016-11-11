/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrint;

import java.awt.Color;
import javax.swing.JTextArea;

/**
 *
 * @author Vegar
 */
public class AreaMap
{
    JTextArea[][] map;
    Map charmap;
    public int[] Playerpos = new int[2];
    public int[] Goalpos = new int [2];
    
    // Custom map
    public AreaMap(int x, int y)
    {
        
        charmap = new Map(x,y);
        
        map= new JTextArea[x][y];
        setup(new char[2][2]);
        
        
    }
    
    private void setup(char[][] nil)
    {
        for (int n = 0; n<charmap.map.length; n++)
        {
            for (int i = 0; i<charmap.map[n].length; i++)
            {
                map[i][n]=new JTextArea();
                map[i][n].setEditable(false);
                if (charmap.map[i][n] == 'e')
                    map[i][n].setBackground(Color.white);
                else if (charmap.map[i][n] == 'w')
                    map[i][n].setBackground(Color.black);
            }
        }
        
        map[0][0].setBackground(Color.red);
            this.Playerpos[0]=0;
            this.Playerpos[1]=0;
            
            
            map[9][8].setBackground(Color.blue);
            this.Goalpos[0]=9;
            this.Goalpos[1]=8;
            
            
    }
    
    
    
    // Default map for pure testing
    public AreaMap()
    {
        map = new JTextArea[10][10];
        
        for (JTextArea[] map1 : map)
        {
            for (int i = 0; i<map[0].length; i++)
            {
                map1[i] = new JTextArea();
                map1[i].setBackground(Color.black);
                map1[i].setEditable(false);
                map1[i].setText("");
            }
        }
        setup();
        
        
    }
    
    
        // Takes default char-map and turns it into graphical map
        private void setup()
        {
            
            char[][] examplemap = {
                { 'e','w','e','e','e','e','e','e','e','e' },
                { 'e','w','e','w','w','w','w','e','w','w' },
                { 'e','w','e','w','e','w','w','e','w','e' },
                { 'e','e','e','w','e','w','e','e','w','e' },
                { 'e','w','e','e','e','w','e','e','w','e' },
                { 'e','w','w','w','e','w','e','w','w','e' },
                { 'e','e','e','e','e','e','e','w','e','e' },
                { 'e','w','w','e','w','e','w','w','w','e' },
                { 'e','e','w','e','e','w','w','e','e','e' },
                { 'e','e','w','e','e','e','e','e','e','w' }};
            for (int i=0; i<map.length; i++)
            {
                for (int n=0; n<map[i].length; n++)
                {
                    if (examplemap[n][i] == 'e')
                        map[i][n].setBackground(Color.white);
                    else
                        map[i][n].setBackground(Color.black);
                }
            }
            
            map[0][0].setBackground(Color.red);
            this.Playerpos[0]=0;
            this.Playerpos[1]=0;
            
            
            map[9][8].setBackground(Color.blue);
            this.Goalpos[0]=9;
            this.Goalpos[1]=8;
            
            
            
            
        }
}
