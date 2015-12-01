package com.grizzlypenguins.dungeondart;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.io.Serializable;

/**
 * Created by Darko on 17.11.2015.
 */
public class Tile implements Serializable {

    // table fields
    public int _id;
    public int define;  //defines the tile with : 0 wall,1 movable,2 start,3 finish
    public int x,y;

    private int powerUp = 0; // powerUp = 0 , no powerup on that tile
    private int trap = 0;   // trap = 0, no traps on that Tile trap<0 used trap
    public boolean shadow = false;

    /*
        added getters and setters
     */

    public int getId() {
        return _id;
    }

    public void setId(int id){
        _id = id;
    }

    public int getDefine() {
        return define;
    }

    public void setDefine(int def) {
        define = def;
    }

    public int getX() {
        return x;
    }

    public void setX(int X) {
        x = X;
    }

    public int getY() {
        return y;
    }

    public void setY(int Y) {
        y = Y;
    }

    /*
        end of added getters and setters
     */


    /*
        added default constructor
     */

    public Tile() {

    }

    /*
        end of default constructor
     */

    public Tile(int move, int pu, int t)
    {
        powerUp = pu;
        trap = t;
        define = move;
    }

    public int getPowerUp()
    {
        return  powerUp;

    }

    public int use_powerUp()
    {
        int temp = powerUp;
        powerUp = 0;
        return temp;
    }

    public int get_trap()
    {
        return trap;
    }
    public int use_trap()
    {
        if(trap == 0)
            return 0;
        if(trap>0) {
            int temp = trap;
            trap *= -1;
            return temp;
        }
        else
        {
            return trap;
        }

    }

    public void render(Canvas c,float x, float y)
    {
        if(shadow)
        {
            /*
            Paint mpaint = myFactory.getInstance().paint;
            mpaint.setColor(Color.BLACK);
            c.drawRect(x, y, myFactory.TILESIZE, myFactory.TILESIZE, mpaint);
            */
        }
        else
            switch (define)
        {
            case 0:{
                c.drawBitmap(myFactory.getInstance().TileNotMovable,x,y,myFactory.getInstance().paint);
                break;
            }
            case 1:{
                c.drawBitmap(myFactory.getInstance().TileMovable,x,y,myFactory.getInstance().paint);
                break;
            }
            case 2:{
                c.drawBitmap(myFactory.getInstance().TileMovable,x,y,myFactory.getInstance().paint);
                break;
            }
            case 3:{
                c.drawBitmap(myFactory.getInstance().TileMovable,x,y,myFactory.getInstance().paint);
                break;
            }
            default:{
                c.drawBitmap(myFactory.getInstance().TileMovable,x,y,myFactory.getInstance().paint);
                break;
            }
        }
    }


}
