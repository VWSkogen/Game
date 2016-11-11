/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;


/**
 *
 * @author Vegar
 */
public class Labyrint
{
    static AreaMap test = new AreaMap(35,35);
    static JFrame gui = new JFrame("Labyrinth");
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        

        
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int startpos=0;
        for (int n=0; n<test.map.length; n++)
        {
            for (int i=0; i<test.map[0].length; i++)
            {
                test.map[n][i].setBounds(15*n, 15*i, 15, 15);
                gui.add(test.map[n][i]);
            }
        }
        
        
        
        
        gui.setBackground(Color.white);
        //gui.setUndecorated(true);
        gui.setSize(new Dimension((test.map[0].length*15)+15, (test.map.length*15)+40));
        gui.setVisible(true);
        final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
        JComponent component = new JComponent() {};
        component.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), "move down");
        component.getInputMap(IFW).put(KeyStroke.getKeyStroke("A"), "move left");
        component.getInputMap(IFW).put(KeyStroke.getKeyStroke("D"), "move right");
        component.getInputMap(IFW).put(KeyStroke.getKeyStroke("W"), "move up");
        
        component.getActionMap().put("move down",new MoveAction('d') );
        component.getActionMap().put("move left",new MoveAction('l') );
        component.getActionMap().put("move right",new MoveAction('r') );
        component.getActionMap().put("move up",new MoveAction('u') );
        gui.add(component);
        
    }
    private static class MoveAction extends AbstractAction
    {
        char dir;
        
        MoveAction(char dir)
        {
            this.dir=dir;
        }
        @Override
        public void actionPerformed (ActionEvent e)
        {
            int oldX = test.Playerpos[0];
            int oldY = test.Playerpos[1];
            gui.repaint();
            switch (this.dir)
            {
                case 'u':
                    // up -> y--
                    
                    System.out.println("Moved up");
                    
                    
                    // if position on Y is 0, don't do anything
                    if (oldY >0 )
                    {
                        // if the new position is black, don't do anything
                        if (test.map[oldX][oldY-1].getBackground() != Color.black)
                        {
                            int newX = oldX;
                            int newY = oldY-1;
                            test.map[oldX][oldY].setBackground(Color.white);
                            test.map[newX][newY].setBackground(Color.red);
                            test.Playerpos[0]=newX;
                            test.Playerpos[1]=newY;
                            
                            
                            System.out.println(newX +","+newY);
                        }
                    }
                    else
                        System.out.println("You are at the border!");
                    
                    
                    break;
                    
                case 'l':
                    System.out.println("moved left");
                    // left -> x--
                    // Check if attempted move is valid
                    if (oldX > 0)
                    {
                        if (test.map[oldX-1][oldY].getBackground() != Color.black)
                        {
                            int newX = oldX-1;
                            int newY = oldY;
                            
                            test.map[oldX][oldY].setBackground(Color.white);
                            test.map[newX][newY].setBackground(Color.red);
                            test.Playerpos[0]=newX;
                            test.Playerpos[1]=newY;
                            
                            System.out.println(newX +","+newY);
                        }
                    }
                    else 
                        System.out.println("You are at the border");
                    
                    break;
                case 'd':
                    System.out.println("moved down");
                    // down -> y++
                    
                    if (oldY < test.map[oldX].length-1)
                    {
                        if (test.map[oldX][oldY+1].getBackground() != Color.black)
                        {
                            int newX=oldX, newY=oldY+1;
                            test.map[oldX][oldY].setBackground(Color.white);
                            test.map[newX][newY].setBackground(Color.red);
                            test.Playerpos[0]=newX;
                            test.Playerpos[1]=newY;
                            
                            System.out.println(newX +","+newY);
                        }
                        else
                            System.out.println("Something went wrong");
                    }
                    else
                        System.out.println("You are at the border");
                    
                    
                    break;
                case 'r':
                    System.out.println("moved right");
                    // right -> x++
                    if (oldX < test.map.length-1)
                    {
                        if (test.map[oldX+1][oldY].getBackground() != Color.black)
                        {
                            int newX = oldX+1, newY = oldY;
                            test.map[oldX][oldY].setBackground(Color.white);
                            test.map[newX][newY].setBackground(Color.red);
                            test.Playerpos[0]=newX;
                            test.Playerpos[1]=newY;
                            
                            System.out.println(newX +","+newY);
                        }
                    }
                    break;
                    
                default:
                    System.out.println("Not recognized");
            }
        }
    }

    
}
